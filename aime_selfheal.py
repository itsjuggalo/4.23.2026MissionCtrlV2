#!/usr/bin/env python3
"""aime_selfheal.py — AIME self-healing watchdog (browserless).

Runs on a schedule (cron, every ~10 min). Does three jobs:
  1. KEEP-WARM   — a trivial AIME query keeps the ainvest session active (extends
                   cookie life, the #1 cause of expiry is idle timeout).
  2. HEAL        — if the logged-in cookie is dead, fall back to an anonymous
                   visitor token so AIME keeps answering (degraded) until recapture.
  3. ALERT       — on real expiry, notify via Telegram + Discord (with cooldown) so
                   AIME never silently goes dark; transient network/DNS blips are
                   retried and do NOT trigger an alert.

Writes status to ~/.openclaw/state/aime_health.json. No browser, ever.
"""
from __future__ import annotations

import json
import os
import sys
import time
import urllib.request
from datetime import datetime, timezone
from pathlib import Path

sys.path.insert(0, str(Path.home() / "scripts"))
import aime_client as a  # noqa: E402

SEC = Path.home() / ".openclaw" / "secrets"
STATE_DIR = Path.home() / ".openclaw" / "state"
STATE = STATE_DIR / "aime_health.json"
ALERT_COOLDOWN = 3 * 3600  # 3h between expiry alerts

RECAPTURE = ("AIME cookie expired. Recapture: log into ainvest.com, DevTools -> Network -> "
             "copy the Cookie header -> overwrite ~/.openclaw/secrets/ainvest_cookie.txt "
             "(see ~/04_RESEARCH/aime_research/HOW_TO_CAPTURE_COOKIE.md). Running on visitor "
             "fallback until then.")


def _read(name):
    p = SEC / name
    return p.read_text(encoding="utf-8").strip() if p.exists() else None


def _load_state() -> dict:
    try:
        return json.loads(STATE.read_text(encoding="utf-8"))
    except Exception:  # noqa: BLE001
        return {}


def _save_state(d: dict):
    STATE_DIR.mkdir(parents=True, exist_ok=True)
    STATE.write_text(json.dumps(d, indent=2), encoding="utf-8")


def alert(msg: str):
    # Telegram → System Health bot (infra alerts belong OFF the Life & Wellness bot)
    try:
        sys.path.insert(0, "/home/itsju/scripts")
        from lib.notify import tg_push
        tg_push("⚠️ " + msg, "system_health", loud=False, html=False,
                fallback_token_file="telegram-ping-bot-token")
    except Exception as e:  # noqa: BLE001
        print(f"[selfheal] telegram alert failed: {e}", file=sys.stderr)
    # Discord webhook
    hook = _read("discord_new_stuff_webhook") or _read("discord_tv_signals_webhook")
    if hook:
        try:
            body = json.dumps({"content": "⚠️ " + msg}).encode()
            req = urllib.request.Request(hook, data=body,
                                         # Discord/Cloudflare 403s the default Python-urllib UA
                                         headers={"content-type": "application/json",
                                                  "User-Agent": "aime-selfheal/1.0"})
            urllib.request.urlopen(req, timeout=15)
        except Exception as e:  # noqa: BLE001
            print(f"[selfheal] discord alert failed: {e}", file=sys.stderr)


def main():
    now = time.time()
    st = _load_state()

    # Health probe with retry to absorb transient network/DNS blips.
    ok, detail, transient = False, "", False
    for attempt in range(3):
        ok, detail = a.is_healthy()
        if ok:
            break
        # network/DNS/timeout = transient → retry; "session expired"/"forbidden" = real
        if any(k in detail.lower() for k in ("name resolution", "timed out", "timeout",
                                             "connection", "temporarily", "reset")):
            transient = True
            time.sleep(5)
            continue
        transient = False
        break

    if ok:
        _save_state({"healthy": True, "mode": "cookie", "last_ok": now,
                     "checked_at": datetime.now(timezone.utc).isoformat()})
        print("[selfheal] healthy (cookie) — session kept warm")
        return 0

    if transient:
        # Don't alert on a network blip; record but keep prior good state.
        st.update({"healthy": False, "mode": "transient",
                   "checked_at": datetime.now(timezone.utc).isoformat(), "detail": detail})
        _save_state(st)
        print(f"[selfheal] transient failure (no alert): {detail}")
        return 0

    # Real expiry — try visitor fallback so AIME still answers.
    visitor_ok = a.ask_aime_visitor("hi") is not None
    mode = "visitor" if visitor_ok else "down"
    last_alert = st.get("last_alert", 0)
    if now - last_alert > ALERT_COOLDOWN:
        alert(RECAPTURE if visitor_ok else
              "AIME is DOWN — cookie expired and visitor fallback failed. " + RECAPTURE)
        st["last_alert"] = now
    st.update({"healthy": False, "mode": mode, "detail": detail,
               "checked_at": datetime.now(timezone.utc).isoformat()})
    _save_state(st)
    print(f"[selfheal] cookie expired — mode={mode}; {detail}")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
