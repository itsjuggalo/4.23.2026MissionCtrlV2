#!/usr/bin/env python3
"""
pulse_ingest.py — write a live_strategy_pulse bucket to LapClaw's dashboard_history.sqlite
Replacement for the mc-livestrategy-pulse.timer (which requires systemd user units unavailable in WSL2).
Run via cron every 5 minutes.
"""
import sqlite3
import time
import os

DASHBOARD_DB = '/home/itsju/LapClaw/data/dashboard_history.sqlite'
LIVE_TRADES_DB = '/home/itsju/LapClaw/data/live_trades.sqlite'

def get_signal_counts():
    if not os.path.exists(LIVE_TRADES_DB):
        return {}
    try:
        since = time.strftime('%Y-%m-%dT%H:%M:%S', time.gmtime(time.time() - 30 * 86400))
        conn = sqlite3.connect(LIVE_TRADES_DB, timeout=5)
        rows = conn.execute(
            "SELECT decision, COUNT(*) n FROM live_signals WHERE received_at >= ? GROUP BY decision",
            (since,)
        ).fetchall()
        conn.close()
        return {r[0]: r[1] for r in rows}
    except Exception:
        return {}

def compute_pulse():
    now_ms = int(time.time() * 1000)
    ts_bucket = (now_ms // 300_000) * 300_000

    counts = get_signal_counts()
    submitted = counts.get('submitted', 0)
    rejected = counts.get('rejected', 0)
    total = sum(counts.values())
    fill_rate = submitted / (submitted + rejected) if (submitted + rejected) > 0 else 1.0

    # baseline: 60 trades / 7.5 months → ~0.267/day; 30-day window
    trades_per_day = submitted / 30
    expected_per_day = (60 / 7.5) / 30
    freq_ratio = trades_per_day / expected_per_day if expected_per_day else 0

    drift_score = 0.0
    if fill_rate < 0.95:
        drift_score += 3
    if fill_rate < 0.85:
        drift_score += 2
    if freq_ratio < 0.3 or freq_ratio > 2.5:
        drift_score += 2

    return ts_bucket, fill_rate, drift_score, total

def main():
    ts_bucket, fill_rate, drift_score, signal_total = compute_pulse()
    conn = sqlite3.connect(DASHBOARD_DB, timeout=10)
    conn.execute(
        "INSERT OR REPLACE INTO live_strategy_pulse (ts, fill_rate, drift_score, signal_total) VALUES (?, ?, ?, ?)",
        (ts_bucket, fill_rate, drift_score, signal_total)
    )
    conn.commit()
    conn.close()
    print(f"[pulse] upserted ts={ts_bucket} fill_rate={fill_rate:.3f} drift={drift_score} signals={signal_total}")

if __name__ == '__main__':
    main()
