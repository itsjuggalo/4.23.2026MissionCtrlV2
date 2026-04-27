#!/usr/bin/env python3
"""Pattern recognition bot.
Runs every 15 min during market hours via cron. Detects 4 pattern types.
Posts alerts to #pattern-alerts. 60-min cooldown per (ticker, pattern) pair.
"""
import json, os, sys, time, logging
from datetime import datetime, timezone
from pathlib import Path
import requests
sys.path.insert(0, str(Path(__file__).parent))
from ohlc_provider import get_active_provider
from pattern_detector import detect_all, fmt_prem

SECRETS = Path.home() / ".openclaw" / "secrets"
WEBHOOK = (SECRETS / "discord_pattern_alerts_webhook").read_text().strip()
STATE_FILE = Path.home() / ".openclaw" / "workspace" / "pattern_bot_state.json"
COOLDOWN_SECS = 60 * 60  # 60 min per (ticker, pattern)

LOG_DIR = Path.home() / ".openclaw" / "workspace" / "logs"
LOG_DIR.mkdir(parents=True, exist_ok=True)
logging.basicConfig(
    filename=LOG_DIR / "pattern_bot.log",
    level=logging.INFO,
    format="%(asctime)s %(levelname)s %(message)s",
)


PATTERN_META = {
    "BREAKOUT":   {"emoji": "🔥", "color": 0x2ecc71},
    "GAP_AND_GO": {"emoji": "🚀", "color": 0x3498db},
    "FLAG":       {"emoji": "🚩", "color": 0xf1c40f},
    "REVERSAL":   {"emoji": "⚡", "color": 0xe67e22},
}


def load_state():
    if not STATE_FILE.exists():
        return {"fired": {}}
    try: return json.loads(STATE_FILE.read_text())
    except: return {"fired": {}}


def save_state(s):
    tmp = str(STATE_FILE) + ".tmp"
    with open(tmp, "w") as f: json.dump(s, f, indent=2)
    os.replace(tmp, STATE_FILE)


def can_fire(state, key):
    last = state["fired"].get(key, 0)
    return (time.time() - last) >= COOLDOWN_SECS


def mark_fired(state, key):
    state["fired"][key] = int(time.time())


def post_alert(alert):
    meta = PATTERN_META.get(alert["pattern"], {"emoji": "📊", "color": 0x95a5a6})
    embed = {
        "title": f"{meta['emoji']} {alert['pattern'].replace('_', '-')} — {alert['ticker']}",
        "description": alert["summary"],
        "color": meta["color"],
        "fields": [
            {"name": "Confidence", "value": alert["confidence"], "inline": True},
            {"name": "Pattern", "value": alert["pattern"], "inline": True},
        ],
        "footer": {"text": f"Pattern Bot • {datetime.now().strftime('%-I:%M %p ET')}"},
        "timestamp": datetime.now(timezone.utc).isoformat(),
    }
    try:
        r = requests.post(WEBHOOK, json={"embeds": [embed]}, timeout=15)
        if r.status_code in (200, 204):
            return True
        logging.error(f"webhook {r.status_code}: {r.text[:200]}")
        return False
    except Exception as e:
        logging.error(f"post failed: {e}")
        return False


def in_market_hours():
    """ET market hours 9:30-16:00. Server is UTC, EDT = UTC-4."""
    now = datetime.now()
    hour = now.hour  # UTC
    # Skip weekends
    if now.weekday() >= 5: return False
    # 9:30 ET = 13:30 UTC, 16:00 ET = 20:00 UTC (EDT)
    # Allow 13:00-21:00 UTC for some buffer
    return 13 <= hour < 21


def main():
    force = "--force" in sys.argv
    if not force and not in_market_hours():
        logging.info("outside market hours, skipping")
        print("outside market hours")
        return
    state = load_state()
    provider = get_active_provider()
    logging.info(f"running detection with provider={provider.name}")
    alerts = detect_all(provider)
    fired = 0
    skipped_cooldown = 0
    for a in alerts:
        key = f"{a['ticker']}_{a['pattern']}"
        if not can_fire(state, key):
            skipped_cooldown += 1
            continue
        if post_alert(a):
            mark_fired(state, key)
            fired += 1
            logging.info(f"FIRED {a['pattern']} {a['ticker']} {a['confidence']}")
    save_state(state)
    print(f"detected={len(alerts)} fired={fired} cooldown_skipped={skipped_cooldown}")
    logging.info(f"detected={len(alerts)} fired={fired} cooldown_skipped={skipped_cooldown}")


if __name__ == "__main__":
    main()
