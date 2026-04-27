#!/usr/bin/env python3
"""Signal tracker — log metadata about all signals processed.
Reads signals.json + closed trade files, writes metadata snapshot.
No Discord posts — just data logging for analytics.
"""
import json, time, os
from pathlib import Path
from datetime import datetime, timezone, timedelta
from collections import defaultdict, Counter

LISTENER_DIR = Path.home() / "mission-control" / "telegram-listener"
SIGNALS_FILE = LISTENER_DIR / "signals.json"
RELAY_DATA = Path.home() / "mission-control-restored" / "Option-Signals-Scraper" / "data"
TRACKER_FILE = Path.home() / ".openclaw" / "workspace" / "state" / "signal_tracker.json"
TRACKER_FILE.parent.mkdir(parents=True, exist_ok=True)

def main():
    out = {
        "updated_at": datetime.now(timezone.utc).isoformat(),
        "telegram_signals": {},
        "options_flow": {},
        "closed_trades": {},
    }

    # Telegram signals
    if SIGNALS_FILE.exists():
        signals = json.loads(SIGNALS_FILE.read_text())
        if isinstance(signals, list):
            now = datetime.now(timezone.utc)
            buckets = {"1h": 0, "6h": 0, "24h": 0, "7d": 0}
            symbols = Counter()
            channels = Counter()
            directions = Counter()
            for s in signals:
                ts = s.get("timestamp", "")
                try:
                    t = datetime.fromisoformat(ts.replace("Z", "+00:00"))
                except:
                    continue
                age = now - t
                if age < timedelta(hours=1): buckets["1h"] += 1
                if age < timedelta(hours=6): buckets["6h"] += 1
                if age < timedelta(hours=24): buckets["24h"] += 1
                if age < timedelta(days=7): buckets["7d"] += 1
                if s.get("symbol"): symbols[s["symbol"]] += 1
                if s.get("channel_name"): channels[s["channel_name"]] += 1
                if s.get("direction"): directions[s["direction"]] += 1

            out["telegram_signals"] = {
                "total": len(signals),
                "by_window": buckets,
                "top_symbols": symbols.most_common(20),
                "top_channels": channels.most_common(10),
                "directions": dict(directions),
            }

    # Options flow stats from today's file
    flow_file = RELAY_DATA / "flow_liveflows_today.json"
    if flow_file.exists():
        flow = json.loads(flow_file.read_text())
        if isinstance(flow, dict):
            symbols = Counter()
            sweeps = 0
            blocks = 0
            total_value = 0.0
            for entry in flow.values():
                if not isinstance(entry, dict): continue
                if entry.get("Symbol"): symbols[entry["Symbol"]] += 1
                if entry.get("BlockType") == "SWEEP": sweeps += 1
                elif entry.get("BlockType") == "BLOCK": blocks += 1
                try: total_value += float(entry.get("Value", 0) or 0)
                except: pass
            out["options_flow"] = {
                "total_today": len(flow),
                "sweeps": sweeps,
                "blocks": blocks,
                "total_value": total_value,
                "top_symbols": symbols.most_common(20),
            }

    # Closed trades
    closed_files = ["closed_options", "closed_stocks"]
    closed_summary = {}
    for fname in closed_files:
        p = RELAY_DATA / f"{fname}.json"
        if p.exists():
            try:
                d = json.loads(p.read_text())
                entries = list(d.values()) if isinstance(d, dict) else d
                wins = losses = 0
                for e in entries:
                    status = (e.get("status") or "").lower() if isinstance(e, dict) else ""
                    if any(k in status for k in ("profit", "locked", "booked")): wins += 1
                    elif any(k in status for k in ("stop", "loss")): losses += 1
                closed_summary[fname] = {"total": len(entries), "wins": wins, "losses": losses,
                                          "win_rate": wins/(wins+losses) if (wins+losses) else 0}
            except: pass
    out["closed_trades"] = closed_summary

    TRACKER_FILE.write_text(json.dumps(out, indent=2, default=str))
    print(f"[tracker] wrote {TRACKER_FILE}")
    print(f"  TG signals: {out['telegram_signals'].get('total', 0)} total, {out['telegram_signals'].get('by_window', {}).get('24h', 0)} in 24h")
    print(f"  Options flow today: {out['options_flow'].get('total_today', 0)} fills")
    print(f"  Closed trade files: {len(closed_summary)}")

if __name__ == "__main__":
    main()
