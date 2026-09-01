#!/usr/bin/env python3
"""
unified_contracts_high_interest_sync.py — a SECOND, richer source for missionctrl's
"high premium/high vol/high OI" surface, alongside firebase_signal_relay.py's
single external "Name" RTDB feed.

Mike (2026-09-01): "are there any other sources we can use that will add more of
that type of data to missionctrl?" — decipher's own options-flow pipeline already
writes real per-contract premium/volume/open-interest into desk_pipeline.sqlite's
unified_contracts table (3M+ rows, updated every 30min market hours via
run_decipher.sh --live). That's a free, already-live, already-richer source than
the single third-party RTDB feed — this script just surfaces its top hits the
same way firebase_signal_relay.py does, into a separate feed file so the two
sources stay distinguishable by `source`.

PM2/cron: run every 30min market hours, right after decipher's own cycle.
"""
import json, sqlite3
from pathlib import Path
from datetime import datetime, timedelta, time as dtime
from zoneinfo import ZoneInfo

DB = Path.home() / "LapClaw" / "pipeline" / "desk_pipeline.sqlite"
OUT = Path.home() / ".openclaw" / "workspace" / "directives" / "unified_contracts_high_interest.json"
OUT.parent.mkdir(parents=True, exist_ok=True)
OUT_MAX = 100

# Separate thresholds from firebase_signal_relay.py's per-contract ones —
# total_premium here is AGGREGATE dollar flow for the strike/expiry, not a
# single contract's price*100, so it runs orders of magnitude larger.
HIGH_TOTAL_PREMIUM = 100_000   # aggregate $ flow
HIGH_VOLUME = 1_000
HIGH_OPEN_INTEREST = 1_000


def latest_trading_day_start():
    now_et = datetime.now(ZoneInfo("America/New_York"))
    day = now_et.date()
    if day.weekday() == 5:
        day -= timedelta(days=1)
    elif day.weekday() == 6:
        day -= timedelta(days=2)
    return datetime.combine(day, dtime.min)


def latest_window_today(conn):
    """unified_contracts.window_id is 'YYYY-MM-DDTHH' (ET hour bucket). Pick the
    newest window that falls on the latest trading day; None if nothing today yet."""
    cutoff_date = latest_trading_day_start().date().isoformat()
    row = conn.execute(
        "SELECT window_id FROM unified_contracts WHERE window_id LIKE ? "
        "ORDER BY window_id DESC LIMIT 1",
        (f"{cutoff_date}%",),
    ).fetchone()
    return row[0] if row else None


def fetch_high_interest(conn, window_id):
    rows = conn.execute(
        """SELECT occ, ticker, expiry, strike, option_type, total_premium,
                  volume, open_interest, size_vs_oi, sweep_count, spot, built_at
           FROM unified_contracts
           WHERE window_id = ?
             AND (total_premium >= ? OR volume >= ? OR open_interest >= ?)
           ORDER BY total_premium DESC
           LIMIT 200""",
        (window_id, HIGH_TOTAL_PREMIUM, HIGH_VOLUME, HIGH_OPEN_INTEREST),
    ).fetchall()
    out = []
    for occ, ticker, expiry, strike, otype, prem, vol, oi, size_vs_oi, sweeps, spot, built_at in rows:
        flags = []
        if prem is not None and prem >= HIGH_TOTAL_PREMIUM:
            flags.append("HIGH_PREMIUM")
        if isinstance(vol, (int, float)) and vol >= HIGH_VOLUME:
            flags.append("HIGH_VOLUME")
        if isinstance(oi, (int, float)) and oi >= HIGH_OPEN_INTEREST:
            flags.append("HIGH_OI")
        if len(flags) < 2:
            continue
        out.append({
            "id": occ,
            "source": "unified_contracts",
            "ticker": ticker,
            "expiry": expiry,
            "strike": strike,
            "option_type": otype,
            "total_premium": prem,
            "volume": vol,
            "open_interest": oi,
            "size_vs_oi": size_vs_oi,
            "sweep_count": sweeps,
            "spot": spot,
            "high_interest_flags": flags,
            "is_high_interest": True,
            "captured_at": built_at,
        })
    return out


def main():
    conn = sqlite3.connect(str(DB))
    window_id = latest_window_today(conn)
    if not window_id:
        print("[uc-sync] no unified_contracts window for the latest trading day yet")
        OUT.write_text(json.dumps([], indent=2))
        return
    hits = fetch_high_interest(conn, window_id)[:OUT_MAX]
    OUT.write_text(json.dumps(hits, indent=2))
    print(f"[uc-sync] window={window_id} wrote {len(hits)} high-interest contracts to {OUT}")


if __name__ == "__main__":
    main()
