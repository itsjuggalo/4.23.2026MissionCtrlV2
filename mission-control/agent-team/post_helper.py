"""
Telegram posting helper for Mission Control agent team.

Reads bot token + chat_id from ~/.openclaw/secrets/ with env fallbacks.
Respects cadence limits from identity_config.json.
Tracks last-post timestamps in ~/.openclaw/workspace/state/team_post_history.json.
"""
import json
import os
import sys
import time
from datetime import datetime, timezone
from pathlib import Path

try:
    import requests
except ImportError:
    print("!! requests module missing. Install with: pip install requests --break-system-packages")
    sys.exit(1)

SECRETS_DIR = Path.home() / ".openclaw" / "secrets"
STATE_FILE = Path.home() / ".openclaw" / "workspace" / "state" / "team_post_history.json"
CONFIG_FILE = Path(__file__).parent / "identity_config.json"

def _read_secret(name: str, env_var: str = None) -> str:
    """Try secrets file first, then env var, then empty string."""
    secret_path = SECRETS_DIR / name
    if secret_path.exists():
        return secret_path.read_text().strip()
    if env_var:
        return os.environ.get(env_var, "").strip()
    return ""

def get_bot_token(agent: str = "") -> str:
    """Try per-agent bot first (e.g. telegram_orion_bot_token), fall back to team-wide."""
    candidates = []
    if agent:
        candidates.append(f"telegram_{agent}_bot_token")
    candidates.extend(["telegram_team_bot_token", "telegram-bot-token.txt", "telegram_bot_token"])
    for candidate in candidates:
        token = _read_secret(candidate, candidate.upper().replace("-", "_").replace(".TXT", ""))
        if token:
            return token
    return ""

def get_chat_id() -> str:
    for candidate in ["telegram_team_chat_id", "telegram_ops_chat_id", "telegram_chat_id"]:
        cid = _read_secret(candidate, candidate.upper())
        if cid:
            return cid
    return ""

def load_config() -> dict:
    with open(CONFIG_FILE) as f:
        return json.load(f)

def load_post_history() -> dict:
    if STATE_FILE.exists():
        try:
            return json.loads(STATE_FILE.read_text())
        except Exception:
            return {}
    return {}

def save_post_history(h: dict) -> None:
    STATE_FILE.parent.mkdir(parents=True, exist_ok=True)
    STATE_FILE.write_text(json.dumps(h, indent=2))

def check_cooldown(agent: str, message_type: str, cooldown_sec: int) -> bool:
    """Return True if OK to post (no cooldown active)."""
    h = load_post_history()
    key = f"{agent}::{message_type}"
    last = h.get(key, 0)
    return (time.time() - last) > cooldown_sec

def mark_posted(agent: str, message_type: str) -> None:
    h = load_post_history()
    h[f"{agent}::{message_type}"] = time.time()
    save_post_history(h)

def post_to_telegram(
    agent: str,
    message_type: str,
    body: str,
    dry_run: bool = False,
    bypass_cooldown: bool = False,
) -> dict:
    """
    Post a message to the team Telegram on behalf of an agent.

    Returns dict with keys: ok, skipped_reason, response, message_sent.
    """
    config = load_config()
    agents = config.get("agents", {})

    if agent not in agents:
        return {"ok": False, "skipped_reason": f"unknown agent {agent}", "response": None}

    a = agents[agent]
    cooldown = config.get("cadence_limits", {}).get("same_agent_same_type_cooldown_sec", 900)

    if not bypass_cooldown and not check_cooldown(agent, message_type, cooldown):
        return {
            "ok": False,
            "skipped_reason": f"cooldown active for {agent}::{message_type} ({cooldown}s)",
            "response": None,
        }

    now_et = datetime.now(timezone.utc).strftime("%-I:%M %p UTC")
    message = f"{a['emoji']} {a['display_name']} — {message_type}\n{body}\n({now_et})"

    if dry_run:
        print("=" * 60)
        print("DRY RUN — would have posted:")
        print("=" * 60)
        print(message)
        print("=" * 60)
        return {"ok": True, "skipped_reason": "dry_run", "response": None, "message_sent": message}

    token = get_bot_token(agent)
    chat_id = get_chat_id()

    if not token or not chat_id:
        return {
            "ok": False,
            "skipped_reason": f"missing credentials (token={'set' if token else 'missing'}, chat_id={'set' if chat_id else 'missing'})",
            "response": None,
            "message_sent": message,
        }

    try:
        r = requests.post(
            f"https://api.telegram.org/bot{token}/sendMessage",
            json={"chat_id": chat_id, "text": message, "disable_web_page_preview": True},
            timeout=10,
        )
        if r.status_code == 200:
            mark_posted(agent, message_type)
            return {"ok": True, "skipped_reason": None, "response": r.json(), "message_sent": message}
        return {"ok": False, "skipped_reason": f"http {r.status_code}", "response": r.text, "message_sent": message}
    except Exception as e:
        return {"ok": False, "skipped_reason": f"exception: {e}", "response": None, "message_sent": message}


if __name__ == "__main__":
    import argparse
    p = argparse.ArgumentParser()
    p.add_argument("--agent", required=True)
    p.add_argument("--type", required=True, dest="message_type")
    p.add_argument("--body", required=True)
    p.add_argument("--dry-run", action="store_true")
    p.add_argument("--bypass-cooldown", action="store_true")
    args = p.parse_args()
    result = post_to_telegram(args.agent, args.message_type, args.body, dry_run=args.dry_run, bypass_cooldown=args.bypass_cooldown)
    print(json.dumps(result, indent=2, default=str))
    sys.exit(0 if result["ok"] else 1)
