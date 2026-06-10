#!/usr/bin/env python3
"""aime_client.py — shared BROWSERLESS AIME client (no browser, no windows).

One place for everything to call AInvest/AIME: the Telegram bot, the Discord bot,
the flow-digest enrichment, and the self-heal watchdog. Pure HTTP + the ainvest
session cookie — never launches a browser.

Public API:
    ask_aime(question, timeout=120) -> str            # full answer (logged-in cookie)
    is_healthy() -> (bool, str)                        # cheap liveness probe
    mint_visitor_token() -> str | None                 # anon fallback token
    ask_aime_visitor(question) -> str | None           # degraded anon "Fast Answer"

Cookie lives at ~/.openclaw/secrets/ainvest_cookie.txt. On expiry, AIME returns
"access/forbidden" — recapture per ~/04_RESEARCH/aime_research/HOW_TO_CAPTURE_COOKIE.md.
"""
from __future__ import annotations

import json
import os
import secrets as _secrets
import urllib.request
from pathlib import Path

SEC = Path.home() / ".openclaw" / "secrets"
COOKIE_FILE = SEC / "ainvest_cookie.txt"
AIME_URL = "https://tech.ainvest.com/gateway/aime/stream-query"
VISITOR_URL = "https://tech.ainvest.com/gateway/auth/visitor/login"
USER_ID = os.environ.get("AIME_USER_ID", "1844221468")
SOURCE = "ths_wencai_international_pc_robot"


def _cookie() -> str | None:
    try:
        return COOKIE_FILE.read_text(encoding="utf-8").strip()
    except FileNotFoundError:
        return None


def _payload(question: str) -> bytes:
    return json.dumps({
        "question": question, "input_type": "typewrite",
        "session_id": _secrets.token_hex(16), "user_id": USER_ID, "source": SOURCE,
        "events": [{"event_name": "auto_agent", "event_type": "user_input"}],
        "entity_info": {"comefrom": "WebaimeRobot", "device_type": "pc"},
        "add_info": {"async_generate_data": True, "urp": {"component_version": "1.1.3"}},
        "log_info": {}, "version": "3.4.1", "suggest_resultpage_only": True,
    }).encode()


def _parse_sse(resp) -> tuple[str, bool]:
    """Returns (answer, forbidden)."""
    ans, buf, forbidden = "", "", False
    for raw in resp:
        buf += raw.decode("utf-8", "replace")
        while "\n" in buf:
            line, buf = buf.split("\n", 1)
            if not line.startswith("data:"):
                continue
            try:
                ev = json.loads(line[5:])
                if ev.get("answer_path") == "access/forbidden":
                    return "", True
                sec = ev.get("section", {})
                if ev.get("answer_path") == "other/openAnswer" and sec.get("show_type") == "rich_text":
                    ans += sec.get("text_answer", "")
                    if sec.get("is_last"):
                        return ans.strip(), False
            except Exception:  # noqa: BLE001
                pass
    return ans.strip(), forbidden


def ask_aime(question: str, timeout: int = 120) -> str:
    cookie = _cookie()
    if not cookie:
        return "[AIME: no cookie configured]"
    req = urllib.request.Request(AIME_URL, data=_payload(question), headers={
        "content-type": "application/json", "accept": "text/event-stream",
        "x-source": SOURCE, "Cookie": cookie})
    try:
        with urllib.request.urlopen(req, timeout=timeout) as r:
            if r.status != 200:
                return f"[AIME HTTP {r.status}]"
            ans, forbidden = _parse_sse(r)
        if forbidden:
            return "[AIME: session expired — recapture cookie]"
        return ans or "[AIME: no answer]"
    except Exception as e:  # noqa: BLE001
        return f"[AIME error: {e}]"


def is_healthy() -> tuple[bool, str]:
    """Cheap liveness probe: trivial query. Returns (ok, detail)."""
    ans = ask_aime("hi", timeout=45)
    if ans.startswith("[AIME"):
        return False, ans
    return True, "ok"


def mint_visitor_token() -> str | None:
    """Anon visitor token (Fast Answer fallback when the logged-in cookie dies)."""
    body = json.dumps({"udid": _secrets.token_hex(16), "clientType": "pc"}).encode()
    req = urllib.request.Request(VISITOR_URL, data=body, headers={
        "content-type": "application/json", "x-source": SOURCE})
    try:
        with urllib.request.urlopen(req, timeout=20) as r:
            d = json.loads(r.read())
        return (d.get("data") or {}).get("token") or d.get("token")
    except Exception:  # noqa: BLE001
        return None


def ask_aime_visitor(question: str) -> str | None:
    """Degraded anonymous AIME via a fresh visitor token (no cookie needed)."""
    tok = mint_visitor_token()
    if not tok:
        return None
    req = urllib.request.Request(AIME_URL, data=_payload(question), headers={
        "content-type": "application/json", "accept": "text/event-stream",
        "x-source": SOURCE, "Authorization": f"Bearer {tok}"})
    try:
        with urllib.request.urlopen(req, timeout=90) as r:
            ans, forbidden = _parse_sse(r)
        return None if forbidden else (ans or None)
    except Exception:  # noqa: BLE001
        return None


if __name__ == "__main__":
    import sys
    q = " ".join(sys.argv[1:]) or "one line read on SPY"
    print(ask_aime(q))
