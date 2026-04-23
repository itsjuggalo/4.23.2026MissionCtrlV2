#!/usr/bin/env python3
"""
Analyst signals puller — reads Name/Name2/Vivid/Vivid2 signal data from Firebase
and writes merged output for the Options page Scalps/Swings/Leaps tabs.

Runs alongside existing flow/alerts scraper. Independent — does not touch flow_alerts_*.
"""
import json, os, time, requests
from datetime import datetime, timezone

DB = "https://stock-signal-72772-default-rtdb.firebaseio.com"
DATA_DIR = os.path.join(os.path.dirname(os.path.abspath(__file__)), "data")
os.makedirs(DATA_DIR, exist_ok=True)

# 4 sources, merged into 2 groups: 'name' (Name+Name2) and 'vivid' (Vivid+Vivid2)
SOURCES = [
    ("Name",  "name"),
    ("Name2", "name"),
    ("Vivid", "vivid"),
    ("Vivid2","vivid"),
]

# Firebase path segments under each source
CATEGORIES = ["ShortTermOptions", "LongTermOptions", "ClosedOptions"]


def fetch(path):
    url = f"{DB}/{path}.json"
    try:
        r = requests.get(url, timeout=15)
        if r.status_code == 200:
            return r.json() or {}
    except Exception as e:
        print(f"  [err] {path}: {e}", flush=True)
    return {}


def normalize_signal(raw_key, raw, source, source_group, category_node):
    """Turn a raw Firebase signal record into a normalized signal for the UI."""
    # Determine tab mapping
    cat_upper = (raw.get("category") or "").upper()
    if category_node == "LongTermOptions":
        tab = "leaps"
    elif cat_upper == "SCALP":
        tab = "scalps"
    elif cat_upper == "SWING":
        tab = "swings"
    else:
        tab = "scalps"  # default fallback for ShortTermOptions without category

    # Closed vs open
    exit_time = raw.get("exitTime")
    is_closed = bool(exit_time) or category_node == "ClosedOptions"

    # Expiry — Firebase stores as string unix epoch
    expiry_raw = raw.get("expiry")
    try:
        expiry_ts = int(expiry_raw) if expiry_raw else None
    except (ValueError, TypeError):
        expiry_ts = None

    # Numeric coercions (Firebase stores everything as strings)
    def num(x):
        if x is None or x == "":
            return None
        try:
            return float(x)
        except (ValueError, TypeError):
            return None

    return {
        "id": f"{source}_{category_node}_{raw_key}",
        "key": raw_key,
        "source": source,           # Name / Name2 / Vivid / Vivid2
        "sourceGroup": source_group, # 'name' | 'vivid'
        "categoryNode": category_node,  # ShortTermOptions | LongTermOptions | ClosedOptions
        "tab": tab,                  # scalps | swings | leaps
        "symbol": raw.get("symbol"),
        "shortName": raw.get("shortName", ""),
        "strike": raw.get("strike"),
        "expiry": expiry_ts,
        "isPut": bool(raw.get("isPut")),
        "isWeekly": bool(raw.get("isWeekly")),
        "isFree": bool(raw.get("free")),
        "risk": raw.get("risk", ""),
        "category": raw.get("category", ""),
        "buyTarget": num(raw.get("buyTarget")),
        "earlyTarget": num(raw.get("earlyTarget")),
        "stopLoss": num(raw.get("stopLoss")),
        "reduceLoss": num(raw.get("reduceLoss")),
        "sellTarget": num(raw.get("sellTarget")),
        "sellTarget2": num(raw.get("sellTarget2")),
        "sellTarget3": num(raw.get("sellTarget3")),
        "status": raw.get("status", ""),
        "exitTime": exit_time,
        "isClosed": is_closed,
        "discordMessageId": raw.get("discordMessageId"),
        "discordThreadId": raw.get("discordThreadId"),
        # Time for sorting — prefer key (usually unix epoch created)
        "ts": int(raw_key) if raw_key.isdigit() else int(time.time()),
    }


def pull_all():
    """Pull all sources × categories, write per-source files + merged file."""
    all_signals = []
    per_source_counts = {}

    for source, source_group in SOURCES:
        for cat in CATEGORIES:
            path = f"{source}/{cat}"
            data = fetch(path)
            if not isinstance(data, dict):
                continue

            signals_for_key = []
            for raw_key, raw in data.items():
                if not isinstance(raw, dict):
                    continue
                sig = normalize_signal(raw_key, raw, source, source_group, cat)
                if sig.get("symbol"):  # skip malformed
                    signals_for_key.append(sig)
                    all_signals.append(sig)

            per_source_counts[f"{source}/{cat}"] = len(signals_for_key)
            print(f"  [{source}/{cat}] {len(signals_for_key)} signals", flush=True)

            # Per-source per-category file
            out_path = os.path.join(DATA_DIR, f"analyst_{source.lower()}_{cat.lower()}.json")
            with open(out_path, "w") as f:
                json.dump(signals_for_key, f, indent=None)

    # Merged output (what the API reads)
    # Sort: open first (newest first), then closed (newest first)
    open_signals = [s for s in all_signals if not s["isClosed"]]
    closed_signals = [s for s in all_signals if s["isClosed"]]
    open_signals.sort(key=lambda s: s["ts"], reverse=True)
    closed_signals.sort(key=lambda s: s["ts"], reverse=True)

    merged = {
        "generated_at": datetime.now(timezone.utc).isoformat(),
        "counts": per_source_counts,
        "totals": {
            "open": len(open_signals),
            "closed": len(closed_signals),
            "scalps_open": len([s for s in open_signals if s["tab"] == "scalps"]),
            "swings_open": len([s for s in open_signals if s["tab"] == "swings"]),
            "leaps_open": len([s for s in open_signals if s["tab"] == "leaps"]),
        },
        "open": open_signals,
        "closed": closed_signals[:200],  # cap closed at most recent 200
    }

    merged_path = os.path.join(DATA_DIR, "analyst_signals_merged.json")
    with open(merged_path, "w") as f:
        json.dump(merged, f, indent=None)

    return merged


if __name__ == "__main__":
    start = time.time()
    print(f"[{datetime.now().isoformat()}] analyst_signals_pull starting...", flush=True)
    result = pull_all()
    elapsed = time.time() - start
    print(f"[{datetime.now().isoformat()}] done in {elapsed:.1f}s — "
          f"{result['totals']['open']} open, {result['totals']['closed']} closed "
          f"({result['totals']['scalps_open']}S / {result['totals']['swings_open']}Sw / {result['totals']['leaps_open']}L)", flush=True)
