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

Cookie lives at ~/.openclaw/secrets/ainvest_cookie.txt. On expiry the API answers 401 — re-mint with
ainvest_login.js (run from ~/tools-node/ainvest-login, which holds its node_modules).
"""
from __future__ import annotations

import json
import os
import secrets as _secrets
import urllib.error
import urllib.request
import uuid
from pathlib import Path

SEC = Path.home() / ".openclaw" / "secrets"
COOKIE_FILE = SEC / "ainvest_cookie.txt"
# 2026-11-10: AInvest retired /gateway/aime/stream-query (the whole old gateway answers 404). AIME now runs on the
# "harness" API: POST chat (opens a thread) then POST runs (event stream, answer text in TEXT_MESSAGE_CONTENT deltas).
AIME_BASE = "https://tech.ainvest.com/gateway/harness/api/interaction/"
VISITOR_URL = "https://tech.ainvest.com/gateway/auth/visitor/login"
USER_ID = os.environ.get("AIME_USER_ID", "1844221468")
SOURCE = "ths_wencai_international_pc_robot"
COMEFROM = "WebAinvestNavirobot"
UA = ("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) "
      "Chrome/124.0 Safari/537.36")


def _cookie() -> str | None:
    try:
        return COOKIE_FILE.read_text(encoding="utf-8").strip()
    except FileNotFoundError:
        return None


def _headers(auth: dict) -> dict:
    return {"content-type": "application/json", "x-source": SOURCE, "x-comefrom": COMEFROM, "User-Agent": UA,
            "Origin": "https://tech.ainvest.com", "Referer": "https://tech.ainvest.com/webapp/", **auth}


def _parse_sse(resp) -> str:
    """Join the answer text from the run's event stream (reasoning and tool events are skipped)."""
    ans = ""
    for raw in resp:
        line = raw.decode("utf-8", "replace").strip()
        if not line.startswith("data:"):
            continue
        try:
            ev = json.loads(line[5:])
        except Exception:  # noqa: BLE001
            continue
        if ev.get("type") == "TEXT_MESSAGE_CONTENT":
            ans += ev.get("delta") or ""
        elif ev.get("type") == "RUN_ERROR":
            return ans.strip() or f"[AIME run error: {str(ev.get('message'))[:120]}]"
        elif ev.get("type") == "RUN_FINISHED":
            break
    return ans.replace("\u2060", "").strip()


def _run(question: str, auth: dict, timeout: int) -> str:
    """One question in a fresh thread. Raises on HTTP errors (401 = session expired)."""
    h = _headers(auth)
    req = urllib.request.Request(AIME_BASE + "chat", data=b"", headers=h, method="POST")
    with urllib.request.urlopen(req, timeout=30) as r:
        tid = json.loads(r.read())["response"]["chat"]["threadId"]
    body = json.dumps({
        "threadId": tid, "runId": str(uuid.uuid4()), "mode": "fast",
        "messages": [{"id": str(uuid.uuid4()), "role": "user", "content": question}],
        "entityInfo": {"deviceType": "web", "lang": "en", "stockCode": "", "stockName": "", "marketId": "",
                       "colorTheme": "light"},
        "forwardedProps": {"source": SOURCE, "comefrom": COMEFROM, "inputType": "typewrite"},
    }).encode()
    req = urllib.request.Request(AIME_BASE + "runs", data=body, headers={**h, "accept": "text/event-stream"})
    with urllib.request.urlopen(req, timeout=timeout) as r:
        return _parse_sse(r)


def ask_aime(question: str, timeout: int = 120) -> str:
    cookie = _cookie()
    if not cookie:
        return "[AIME: no cookie configured]"
    try:
        return _run(question, {"Cookie": cookie}, timeout) or "[AIME: no answer]"
    except urllib.error.HTTPError as e:
        if e.code in (401, 403):
            return "[AIME: session expired — recapture cookie]"
        return f"[AIME error: {e}]"
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
    try:
        ans = _run(question, {"Authorization": f"Bearer {tok}"}, 90)
        return None if ans.startswith("[AIME") else (ans or None)
    except Exception:  # noqa: BLE001
        return None


if __name__ == "__main__":
    import sys
    q = " ".join(sys.argv[1:]) or "one line read on SPY"
    print(ask_aime(q))
