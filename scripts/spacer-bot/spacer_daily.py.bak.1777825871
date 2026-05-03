#!/usr/bin/env python3
"""
Spacer Daily — posts a date divider in configured channels at midnight ET.

- Cycles through 18 divider styles (deterministic by day-of-year)
- Adds market context emoji (📈 green / 📉 red / 🕔 weekend/holiday)
- Reads channel list from ~/.openclaw/secrets/spacer_daily_channels (one ID per line)
- State guard prevents duplicate posts on cron retries
- Cron entry: 0 0 * * * with TZ=America/New_York
"""
import json
import logging
import sys
import time
from datetime import datetime
from pathlib import Path
from zoneinfo import ZoneInfo

import requests

SECRETS = Path("/home/ubuntu/.openclaw/secrets")
STATE = Path("/home/ubuntu/.openclaw/workspace/state/spacer_daily_state.json")
LOG_DIR = Path("/home/ubuntu/.openclaw/workspace/logs")
LOG_DIR.mkdir(parents=True, exist_ok=True)
STATE.parent.mkdir(parents=True, exist_ok=True)

logging.basicConfig(
    level=logging.INFO,
    format="%(asctime)s %(levelname)s %(message)s",
    handlers=[logging.FileHandler(LOG_DIR / "spacer_daily.log"), logging.StreamHandler()],
)
log = logging.getLogger("spacer_daily")

TOKEN = (SECRETS / "spacer_bot_token.txt").read_text().strip()
CHANNEL_LIST_FILE = SECRETS / "spacer_daily_channels"

# 18 divider styles — each ~50 chars wide, themed differently
STYLES = [
    "═══════════════════════════════════════════════",
    "─────────────────────────────────────────────",
    "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━",
    "▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰",
    "★ ─────────────────────────────────────── ★",
    "✦ · · · · · · · · · · · · · · · · · · · · · ✦",
    "◆━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━◆",
    "～～～～～～～～～～～～～～～～～～～～～～～",
    "▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽",
    "❖─────────────────────────────────────────❖",
    "╔═══════════════════════════════════════════╗",
    "▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓",
    "♦ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ♦",
    "▶─────────────────────────────────────────◀",
    "❄ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ❄",
    "╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍╍",
    "▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼",
    "✧ ✦ ✧ ✦ ✧ ✦ ✧ ✦ ✧ ✦ ✧ ✦ ✧ ✦ ✧ ✦ ✧ ✦ ✧ ✦ ✧",
]


def get_market_emoji():
    """📈 if SPY closed green prev session, 📉 if red, 🕔 if weekend/holiday/error."""
    try:
        import yfinance as yf
        spy = yf.Ticker("SPY")
        hist = spy.history(period="2d")
        if len(hist) >= 2:
            prev_close = float(hist["Close"].iloc[-2])
            last_close = float(hist["Close"].iloc[-1])
            return "📈" if last_close >= prev_close else "📉"
        return "🕔"
    except Exception as e:
        log.warning(f"market emoji fetch fail (defaulting to 🕔): {e}")
        return "🕔"


def load_channels() -> list:
    """Load channel IDs from config file (one per line, # comments allowed)."""
    if not CHANNEL_LIST_FILE.exists():
        log.error(f"channel list not found: {CHANNEL_LIST_FILE}")
        return []
    chans = []
    for line in CHANNEL_LIST_FILE.read_text().splitlines():
        line = line.strip()
        if not line or line.startswith("#"):
            continue
        # Allow "ID  # name" comments after ID
        cid = line.split("#")[0].strip().split()[0]
        if cid.isdigit():
            chans.append(int(cid))
    return chans


def load_state() -> dict:
    if not STATE.exists():
        return {}
    try:
        return json.loads(STATE.read_text())
    except Exception:
        return {}


def save_state(state: dict):
    STATE.write_text(json.dumps(state, indent=2))


def post_divider(channel_id: int, message: str) -> bool:
    """POST message to channel via bot API. Returns True on success."""
    url = f"https://discord.com/api/v10/channels/{channel_id}/messages"
    headers = {"Authorization": f"Bot {TOKEN}", "Content-Type": "application/json"}
    try:
        r = requests.post(url, headers=headers, json={"content": message}, timeout=15)
        if r.status_code in (200, 201):
            return True
        log.error(f"channel {channel_id} post fail: {r.status_code} {r.text[:200]}")
        return False
    except Exception as e:
        log.error(f"channel {channel_id} exception: {e}")
        return False


def main():
    et_now = datetime.now(ZoneInfo("America/New_York"))
    today = et_now.strftime("%Y-%m-%d")
    weekday = et_now.strftime("%A %B %-d, %Y")  # "Monday April 27, 2026"
    doy = et_now.timetuple().tm_yday
    style = STYLES[doy % len(STYLES)]
    emoji = get_market_emoji()

    log.info(f"=== spacer_daily {today} (DOY {doy}, style #{doy % len(STYLES)}) ===")

    channels = load_channels()
    if not channels:
        log.error("no channels configured, exiting")
        return

    # Build the divider message — date + emoji centered between two style lines
    centered_line = f"{emoji}  **{weekday}**  {emoji}"
    message = f"{style}\n{centered_line}\n{style}"

    state = load_state()
    posted = 0
    skipped = 0
    failed = 0
    for cid in channels:
        last = state.get(str(cid))
        if last == today:
            skipped += 1
            log.info(f"  channel {cid}: already posted today, skip")
            continue
        ok = post_divider(cid, message)
        if ok:
            state[str(cid)] = today
            posted += 1
            log.info(f"  channel {cid}: ✓ posted")
            time.sleep(0.5)  # gentle on Discord rate limits
        else:
            failed += 1

    save_state(state)
    log.info(f"=== done: {posted} posted, {skipped} skipped, {failed} failed ===")


if __name__ == "__main__":
    main()
