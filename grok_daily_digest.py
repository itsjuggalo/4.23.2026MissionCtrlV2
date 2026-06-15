#!/usr/bin/env python3
"""
grok_daily_digest.py — Daily X/social digest via Grok live search → Telegram

Queries:
  1. Claude Code / Anthropic AI dev updates from X
  2. Top stock & crypto market chatter from X

Sends a combined digest to Mike via JazzyHazzy bot.
Cron: 7:00 AM ET daily (Oracle cron or local systemd timer)
"""
import json
import sys
import urllib.parse
import urllib.request
from datetime import datetime, timezone, timedelta
from pathlib import Path

SEC = Path.home() / ".openclaw" / "secrets"

def read_secret(name: str) -> str:
    p = SEC / name
    return p.read_text().strip() if p.exists() else ""

XAI_KEY = read_secret("xai_api_key")
TG_TOKEN = read_secret("lifeclaw_telegram_bot_token")
TG_CHAT_ID = read_secret("lifeclaw_telegram_chat_id")


def xai_oauth_token() -> str:
    """Grok token on the SuperGrok/X-Premium+ OAuth SUBSCRIPTION (Hermes, auto-refreshed).
    Preferred over the pay-per-token API key (which is credit-dead)."""
    import os
    try:
        a = json.loads((Path(os.path.expanduser("~/.hermes/auth.json"))).read_text())
        for c in (a.get("credential_pool", {}) or {}).get("xai-oauth", []):
            if c.get("access_token"):
                return c["access_token"].strip()
    except Exception:
        pass
    return ""


XAI_TOKEN = xai_oauth_token() or XAI_KEY   # subscription first, API key fallback

def et_now() -> datetime:
    return datetime.now(timezone.utc).astimezone(timezone(timedelta(hours=-4)))

def grok_search(query: str, summary_prompt: str) -> str:
    """Call xAI Grok Responses API with the built-in x_search tool, return summary text."""
    instruction = (
        "You are a concise trading/tech news digest bot. "
        "Return a tight 5-8 bullet summary of the most important real posts you find. "
        "No filler, no meta-commentary. Just the news.\n\n"
    )
    payload = {
        "model": "grok-4-fast-non-reasoning",
        "input": instruction + summary_prompt,
        "tools": [{"type": "x_search"}],
    }
    data = json.dumps(payload).encode()
    req = urllib.request.Request(
        "https://api.x.ai/v1/responses",
        data=data,
        headers={
            "Authorization": f"Bearer {XAI_TOKEN}",
            "Content-Type": "application/json",
        },
    )
    try:
        with urllib.request.urlopen(req, timeout=120) as r:
            resp = json.loads(r.read())
        for block in resp.get("output", []):
            for c in (block.get("content") or []):
                if c.get("type") == "output_text":
                    return c.get("text", "").strip()
        return "[no posts found]"
    except Exception as e:
        return f"[fetch error: {e}]"

def send_telegram(text: str) -> bool:
    payload = json.dumps({"chat_id": TG_CHAT_ID, "text": text}).encode()
    req = urllib.request.Request(
        f"https://api.telegram.org/bot{TG_TOKEN}/sendMessage",
        data=payload,
        headers={"Content-Type": "application/json"},
    )
    try:
        with urllib.request.urlopen(req, timeout=15) as r:
            result = json.loads(r.read())
            return result.get("ok", False)
    except urllib.error.HTTPError as e:
        body = e.read().decode()
        print(f"Telegram HTTP {e.code}: {body}", file=sys.stderr)
        return False
    except Exception as e:
        print(f"Telegram send failed: {e}", file=sys.stderr)
        return False

def main():
    if not XAI_TOKEN:
        print("ERROR: no xai OAuth token or api key found", file=sys.stderr)
        sys.exit(1)
    if not TG_TOKEN or not TG_CHAT_ID:
        print("ERROR: Telegram credentials missing", file=sys.stderr)
        sys.exit(1)

    now = et_now()
    date_str = now.strftime("%a %b %d, %Y %I:%M %p ET")

    print(f"[{date_str}] Fetching Claude Code digest...")
    claude_section = grok_search(
        query="Claude Code Anthropic updates",
        summary_prompt=(
            "Search X for posts today about: Claude Code updates, Anthropic announcements, "
            "new Claude models, Claude API changes, Claude Code features or bugs. "
            "Summarize the top 5 most relevant posts in tight bullets."
        ),
    )

    print("Fetching stocks/crypto digest...")
    market_section = grok_search(
        query="stocks crypto trending market movers",
        summary_prompt=(
            "Search X for posts today about: trending stocks, hot crypto coins, "
            "unusual options flow mentions, breaking market news, notable analyst calls. "
            "Summarize the top 5 most relevant signals in tight bullets."
        ),
    )

    msg = (
        f"🤖 Daily X Digest — {date_str}\n\n"
        f"== Claude Code / AI Dev ==\n{claude_section}\n\n"
        f"== Stocks & Crypto ==\n{market_section}\n\n"
        f"via Grok live search"
    )

    # Telegram max message length is 4096; truncate if needed
    if len(msg) > 4000:
        msg = msg[:3990] + "\n…[truncated]"

    ok = send_telegram(msg)
    print(f"Telegram send: {'OK' if ok else 'FAILED'}")
    sys.exit(0 if ok else 1)

if __name__ == "__main__":
    main()
