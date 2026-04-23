#!/usr/bin/env python3
"""
Option Signals Firebase Scraper
================================
Pulls data from 20+ Firebase endpoints on tiered schedules.
Zero AI tokens — just HTTP requests.

Tier 1: Every 5 min  (live flow, alerts, active signals)
Tier 2: Every 30 min (long-term signals, full day flow)
Tier 3: Every 6 hrs  (closed/historical trades)
Tier 4: Once daily   (deep archive)

Deploy:
  mkdir -p /home/ubuntu/mission-control-restored/option-signals-scraper/data
  cp scraper.py /home/ubuntu/mission-control-restored/option-signals-scraper/
  pm2 start scraper.py --name "option-signals" --interpreter python3
  pm2 save
"""

import json
import time
import os
import logging
import requests
from datetime import datetime, timezone

# ─── CONFIG ────────────────────────────────────────────────────────────────────
BASE_DIR = os.path.dirname(os.path.abspath(__file__))
DATA_DIR = os.path.join(BASE_DIR, "data")
FIREBASE = "https://stock-signal-72772-default-rtdb.firebaseio.com"
TICK = 60  # main loop interval in seconds (1 min)
TIMEOUT = 20  # HTTP timeout per request

os.makedirs(DATA_DIR, exist_ok=True)

logging.basicConfig(
    filename=os.path.join(BASE_DIR, "scraper.log"),
    level=logging.INFO,
    format="%(asctime)s %(levelname)s %(message)s",
    datefmt="%Y-%m-%d %H:%M:%S"
)
# Also log to console
console = logging.StreamHandler()
console.setLevel(logging.INFO)
logging.getLogger().addHandler(console)

# ─── ENDPOINT DEFINITIONS ─────────────────────────────────────────────────────
# Format: (local_filename, firebase_path, interval_minutes)

TIER_1 = [  # Every 5 min — live trading data
    ("flow_live_last100",       "/FlowGreeks/LiveFlowLast100.json",         5),
    ("flow_alerts_today",       "/FlowGreeks/Alerts/today.json",            5),
    ("flow2_alerts_today",      "/FlowGreeks2/Alerts/today.json",           5),
    ("short_term_options",      "/Vivid2/ShortTermOptions.json",            5),
    ("short_term_stocks",       "/Vivid2/ShortTermStocks.json",             5),
    ("option_notifications",    "/Vivid2/OptionNotifications.json",         5),
    ("stock_notifications",     "/Vivid2/StockNotifications.json",          5),
]

TIER_2 = [  # Every 30 min — slower changing
    ("long_term_options",       "/Vivid2/LongTermOptions.json",            30),
    ("long_term_stocks",        "/Vivid2/LongTermStocks.json",             30),
    ("flow_liveflows_today",    "/FlowGreeks/LiveFlows/today.json",        30),
    ("flow_bullbears_today",    "/FlowGreeks/BullBears/today.json",        30),
    ("flow2_liveflows_today",   "/FlowGreeks2/LiveFlows/today.json",       30),
    ("flow2_bullbears",         "/FlowGreeks2/BullBears.json",             30),
]

TIER_3 = [  # Every 6 hours — historical
    ("closed_options",          "/Vivid2/ClosedOptions.json",             360),
    ("closed_stocks",           "/Vivid2/ClosedStocks.json",              360),
    ("closed_options_older",    "/Vivid2/ClosedOptionssOlder.json",       360),
    ("closed_stocks_older",     "/Vivid2/ClosedStocksOlder.json",         360),
    ("closed_options_2022",     "/Vivid2/ClosedOptions2022AndOld.json",   360),
]

TIER_4 = [  # Once daily — deep archive
    ("notif_options_older",     "/Vivid2/OptionNotificationsOlder.json",  1440),
    ("notif_stocks_older",      "/Vivid2/StockNotificationsOlder.json",   1440),
    ("notif_options_2022",      "/Vivid2/OptionNotifications2022AndOld.json", 1440),
    ("notif_stocks_2022",       "/Vivid2/StockNotifications2022AndOld.json",  1440),
    ("notif_stocks_2023",       "/Vivid2/StockNotifications2023.json",    1440),
]

ALL_ENDPOINTS = TIER_1 + TIER_2 + TIER_3 + TIER_4

# ─── STATE TRACKING ───────────────────────────────────────────────────────────
last_fetch = {}   # endpoint -> last successful fetch time
fetch_stats = {}  # endpoint -> {ok: int, fail: int, last_count: int}

def init_stats():
    for name, _, _ in ALL_ENDPOINTS:
        last_fetch[name] = 0
        fetch_stats[name] = {"ok": 0, "fail": 0, "last_count": 0, "last_status": "pending"}

# ─── FETCH LOGIC ──────────────────────────────────────────────────────────────
def fetch_endpoint(name, path):
    """Fetch a single Firebase endpoint and save to disk."""
    url = f"{FIREBASE}{path}"
    filepath = os.path.join(DATA_DIR, f"{name}.json")

    try:
        r = requests.get(url, timeout=TIMEOUT)

        if r.status_code == 200:
            data = r.json()

            # Count signals/entries
            if isinstance(data, dict):
                count = len(data)
            elif isinstance(data, list):
                count = len(data)
            else:
                count = 1 if data else 0

            # Save raw data
            with open(filepath, "w") as f:
                json.dump(data, f, indent=2)

            # Update per-alert price history for the two Alerts/today feeds
            if name == "flow_alerts_today":
                update_alert_history(data, "FlowGreeks")
            elif name == "flow2_alerts_today":
                update_alert_history(data, "FlowGreeks2")

            # Update stats
            fetch_stats[name]["ok"] += 1
            fetch_stats[name]["last_count"] = count
            fetch_stats[name]["last_status"] = "ok"

            logging.info(f"OK  {name}: {count} entries")
            return True

        elif r.status_code in (401, 403):
            logging.error(f"AUTH BLOCKED  {name}: HTTP {r.status_code} — Firebase may have locked down!")
            fetch_stats[name]["fail"] += 1
            fetch_stats[name]["last_status"] = f"blocked_{r.status_code}"
            return False

        else:
            logging.warning(f"ERR {name}: HTTP {r.status_code}")
            fetch_stats[name]["fail"] += 1
            fetch_stats[name]["last_status"] = f"http_{r.status_code}"
            return False

    except requests.exceptions.Timeout:
        logging.warning(f"TIMEOUT {name}: exceeded {TIMEOUT}s")
        fetch_stats[name]["fail"] += 1
        fetch_stats[name]["last_status"] = "timeout"
        return False

    except Exception as e:
        logging.error(f"EXCEPTION {name}: {e}")
        fetch_stats[name]["fail"] += 1
        fetch_stats[name]["last_status"] = f"error: {str(e)[:80]}"
        return False


# ─── ALERT HISTORY TRACKING ───────────────────────────────────────────────────
HISTORY_FILE = os.path.join(DATA_DIR, "flow_alerts_history.json")

def load_history():
    if not os.path.exists(HISTORY_FILE):
        return {}
    try:
        with open(HISTORY_FILE) as f:
            return json.load(f)
    except Exception as e:
        logging.warning(f"history load failed: {e}")
        return {}

def save_history(hist):
    try:
        with open(HISTORY_FILE, "w") as f:
            json.dump(hist, f, indent=2)
    except Exception as e:
        logging.warning(f"history save failed: {e}")

def update_alert_history(raw_data, source_root):
    """Walk Alerts/today, update running price stats per OptionSymbol."""
    if not isinstance(raw_data, dict):
        return
    hist = load_history()
    now_ms = int(datetime.now(timezone.utc).timestamp() * 1000)
    new_count = 0
    updated_count = 0
    for _, v in raw_data.items():
        if not isinstance(v, dict):
            continue
        a = v.get("alert", v)
        if not isinstance(a, dict):
            continue
        opt_sym = a.get("OptionSymbol")
        price = a.get("AlertPrice")
        if not opt_sym or price is None:
            continue
        try:
            price = float(price)
        except (TypeError, ValueError):
            continue
        if price <= 0:
            continue
        entry = hist.get(opt_sym)
        if entry is None:
            hist[opt_sym] = {
                "first_price": price,
                "last_price": price,
                "max_price": price,
                "min_price": price,
                "first_seen": now_ms,
                "last_seen": now_ms,
                "num_updates": 1,
                "source": source_root,
            }
            new_count += 1
        else:
            entry["last_price"] = price
            if price > entry.get("max_price", price):
                entry["max_price"] = price
            if price < entry.get("min_price", price):
                entry["min_price"] = price
            entry["last_seen"] = now_ms
            entry["num_updates"] = entry.get("num_updates", 0) + 1
            updated_count += 1
    cutoff = now_ms - (7 * 24 * 60 * 60 * 1000)
    before = len(hist)
    hist = {k: v for k, v in hist.items() if v.get("last_seen", 0) > cutoff}
    pruned = before - len(hist)
    save_history(hist)
    if new_count or updated_count or pruned:
        logging.info(f"  history[{source_root}]: +{new_count} new, ~{updated_count} updated, -{pruned} pruned, {len(hist)} total")

# ─── STATUS FILE ──────────────────────────────────────────────────────────────
def save_status():
    """Write scraper status for dashboard/monitoring."""
    now = datetime.now(timezone.utc).isoformat()
    status = {
        "scraper": "option-signals-firebase",
        "updated_at": now,
        "endpoints": {}
    }

    for name, path, interval in ALL_ENDPOINTS:
        tier = "tier1" if interval <= 5 else "tier2" if interval <= 30 else "tier3" if interval <= 360 else "tier4"
        last = last_fetch.get(name, 0)
        status["endpoints"][name] = {
            "tier": tier,
            "interval_min": interval,
            "last_fetch": datetime.fromtimestamp(last, tz=timezone.utc).isoformat() if last > 0 else "never",
            "firebase_path": path,
            **fetch_stats.get(name, {})
        }

    # Summary
    total_ok = sum(s["ok"] for s in fetch_stats.values())
    total_fail = sum(s["fail"] for s in fetch_stats.values())
    status["summary"] = {
        "total_fetches": total_ok + total_fail,
        "successful": total_ok,
        "failed": total_fail,
        "success_rate": f"{(total_ok/(total_ok+total_fail)*100):.1f}%" if (total_ok+total_fail) > 0 else "n/a"
    }

    with open(os.path.join(DATA_DIR, "_scraper_status.json"), "w") as f:
        json.dump(status, f, indent=2)

# ─── MAIN LOOP ────────────────────────────────────────────────────────────────
def run():
    init_stats()
    logging.info("=" * 60)
    logging.info("Option Signals Firebase Scraper starting")
    logging.info(f"Endpoints: {len(ALL_ENDPOINTS)}")
    logging.info(f"  Tier 1 (5 min):   {len(TIER_1)} endpoints")
    logging.info(f"  Tier 2 (30 min):  {len(TIER_2)} endpoints")
    logging.info(f"  Tier 3 (6 hrs):   {len(TIER_3)} endpoints")
    logging.info(f"  Tier 4 (daily):   {len(TIER_4)} endpoints")
    logging.info(f"Data dir: {DATA_DIR}")
    logging.info("=" * 60)

    cycle = 0
    while True:
        now = time.time()
        fetched_this_cycle = 0

        for name, path, interval_min in ALL_ENDPOINTS:
            elapsed = now - last_fetch.get(name, 0)
            interval_sec = interval_min * 60

            if elapsed >= interval_sec:
                if fetch_endpoint(name, path):
                    last_fetch[name] = now
                else:
                    # On failure, still update time to avoid hammering
                    # but use a shorter retry (2 min for tier1, 5 min for others)
                    retry_sec = 120 if interval_min <= 5 else 300
                    last_fetch[name] = now - interval_sec + retry_sec

                fetched_this_cycle += 1
                # Small delay between requests to be nice to Firebase
                time.sleep(0.5)

        # Save status file every cycle
        if fetched_this_cycle > 0:
            save_status()
            logging.info(f"Cycle {cycle}: fetched {fetched_this_cycle} endpoints")

        cycle += 1
        time.sleep(TICK)

if __name__ == "__main__":
    try:
        run()
    except KeyboardInterrupt:
        logging.info("Scraper stopped by user")
    except Exception as e:
        logging.critical(f"Scraper crashed: {e}", exc_info=True)
        raise
