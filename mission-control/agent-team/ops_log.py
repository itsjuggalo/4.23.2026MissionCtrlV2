"""
Discord ops-channel logger — companion to post_helper.py (Telegram team).

Use this for NOISY stuff that shouldn't hit the public Telegram:
    - Rejected candidates with full reasoning breakdown
    - Scorer error traces
    - Raw JSON snapshots
    - Inter-agent disagreements
    - Diagnostic heartbeats

Mike's existing `discord_flow_picks_webhook` secret is reused by default.
"""
import json
import os
import sys
from pathlib import Path
from datetime import datetime, timezone

try:
    import requests
except ImportError:
    print("!! requests module missing", file=sys.stderr)

SECRETS_DIR = Path.home() / ".openclaw" / "secrets"

def _read_webhook(name: str) -> str:
    p = SECRETS_DIR / name
    if p.exists():
        return p.read_text().strip()
    return os.environ.get(name.upper(), "").strip()

def get_ops_webhook() -> str:
    # Priority order — try most specific first
    for candidate in [
        "discord_ops_webhook",
        "discord_agent_ops_webhook",
        "discord_flow_picks_webhook",
        "discord-webhook-broadcast-log.txt",
    ]:
        wh = _read_webhook(candidate)
        if wh and wh.startswith("http"):
            return wh
    return ""

def log_to_ops(
    agent: str,
    level: str,  # INFO, WARN, ERROR, DEBUG, DATA
    message: str,
    metadata: dict = None,
) -> dict:
    webhook = get_ops_webhook()
    ts = datetime.now(timezone.utc).strftime("%Y-%m-%d %H:%M:%S UTC")

    content = f"**[{level}]** `{agent}` — {ts}\n{message}"
    if metadata:
        try:
            meta_str = json.dumps(metadata, indent=2, default=str)[:1500]
            content += f"\n```json\n{meta_str}\n```"
        except Exception:
            pass

    if not webhook:
        print(f"[ops_log NO-WEBHOOK] {content[:200]}", file=sys.stderr)
        return {"ok": False, "reason": "no webhook configured"}

    try:
        r = requests.post(webhook, json={"content": content[:1900]}, timeout=8)
        return {"ok": r.status_code in (200, 204), "status": r.status_code}
    except Exception as e:
        return {"ok": False, "reason": str(e)}


if __name__ == "__main__":
    import argparse
    p = argparse.ArgumentParser()
    p.add_argument("--agent", default="system")
    p.add_argument("--level", default="INFO", choices=["INFO", "WARN", "ERROR", "DEBUG", "DATA"])
    p.add_argument("--message", required=True)
    args = p.parse_args()
    result = log_to_ops(args.agent, args.level, args.message)
    print(json.dumps(result))
