#!/home/itsju/.venv/bin/python3
"""google_token_keeper.py — keep Gmail/Calendar OAuth tokens alive + alert on death.

Two jobs (run daily via cron):
  1. KEEP WARM: for each token, force a refresh and re-save. A refresh token that
     is actually used stays valid longer; this also catches a near-expiry token
     before a brief needs it.
  2. WATCHDOG: if a token is dead (RefreshError = Google revoked it), fire a
     Telegram alert to Mike with the one command to fix it — so he's never
     silently disconnected.

NOTE: the real permanent fix is publishing the OAuth consent screen to
"Production" in Google Cloud Console (project gen-lang-client-0151102876).
In "Testing" status Google revokes refresh tokens 7 days after issuance no
matter what — no amount of refreshing beats that. This keeper is the safety
net + early warning, not a substitute for that one Console toggle.

Exit 0 always (cron-friendly); state is in the alerts it sends.
"""
from __future__ import annotations
import json, os, sys, urllib.parse, urllib.request
from pathlib import Path
from google.oauth2.credentials import Credentials
from google.auth.transport.requests import Request

SEC = Path.home() / ".openclaw" / "secrets"
GMAIL_SCOPES = [
    "https://www.googleapis.com/auth/gmail.readonly",
    "https://www.googleapis.com/auth/gmail.modify",
    "https://www.googleapis.com/auth/gmail.send",
]
CAL_SCOPES = ["https://www.googleapis.com/auth/calendar.readonly",
              "https://www.googleapis.com/auth/calendar.events"]
YT_SCOPES = ["https://www.googleapis.com/auth/youtube.readonly"]

TOKENS = [
    ("Gmail (default)",  Path.home()/".config/gmail/token.json",          GMAIL_SCOPES),
    ("Gmail (personal)", Path.home()/".config/gmail/token_personal.json", GMAIL_SCOPES),
    ("Calendar",         Path.home()/".config/calendar/token.json",       CAL_SCOPES),
    ("YouTube MikeE E",  Path.home()/".config/youtube/token.json",        YT_SCOPES),
    ("YouTube itsjuggalo2", Path.home()/".config/youtube/token_2.json",   YT_SCOPES),
]


def tg_alert(msg: str):
    """system_health lane (infra, not trading) through tg_fleet.call - no raw Bot API call (script-standard #6)."""
    try:
        sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
        import tg_fleet
        r = tg_fleet.call("system_health", "sendMessage", text=msg)
        if not r.get("ok"):
            print(f"[keeper] telegram alert failed: {r.get('description')}", file=sys.stderr)
    except Exception as e:
        print(f"[keeper] telegram alert failed: {e}", file=sys.stderr)


def main():
    dead, warmed = [], []
    for name, path, scopes in TOKENS:
        if not path.exists():
            dead.append(f"{name} (no token file)")
            continue
        try:
            # Use the token's OWN granted scopes (scopes arg omitted) — hardcoding a
            # broader list (e.g. gmail.readonly the token never got) makes refresh
            # return invalid_scope and falsely report a healthy token as dead.
            creds = Credentials.from_authorized_user_file(str(path))
            if creds.refresh_token:
                creds.refresh(Request())          # force a live refresh
                path.write_text(creds.to_json())   # persist the fresh access token
                warmed.append(name)
            else:
                dead.append(f"{name} (no refresh_token)")
        except Exception as e:
            msg = str(e)
            if "invalid_grant" in msg or "revoked" in msg or "expired" in msg:
                dead.append(name)
            else:
                dead.append(f"{name} ({msg[:40]})")

    if warmed:
        print(f"[keeper] refreshed OK: {', '.join(warmed)}")
    if dead:
        print(f"[keeper] DEAD: {', '.join(dead)}")
        tg_alert(
            "⚠️ Google disconnected: " + ", ".join(dead) +
            "\n\nFix (run in a Claude session with the ! prefix so the browser opens):\n"
            "! ~/bin/google-reauth\n\n"
            "Permanent fix so this stops happening: publish the OAuth consent screen "
            "to 'Production' in Google Cloud Console (project gen-lang-client-0151102876). "
            "In 'Testing' mode Google kills tokens every 7 days."
        )
    if not dead:
        print("[keeper] all Google tokens healthy")


if __name__ == "__main__":
    main()
