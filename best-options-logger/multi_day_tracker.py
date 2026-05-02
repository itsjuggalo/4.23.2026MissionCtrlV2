#!/usr/bin/env python3
"""
multi_day_tracker — runs nightly at 12:30 AM ET.

Reads last 5 days of best-options snapshots and identifies multi-day patterns:
  1. Tickers with T1+T2 flow on 3+ of last 5 days (institutional building over time)
  2. Strike clusters with repeated activity (e.g. NVDA $200C hit on 4 of 5 days)
  3. Direction consistency (NVDA calls outweighed puts every day = persistent BULL)

Output written to ~/.openclaw/data/multi-day-repeaters.json
Both Boba and JazzyHazzy read this file and inject summary into their prompts.
"""
import json
from datetime import datetime, timezone, timedelta
from pathlib import Path
from collections import defaultdict

DATA_DIR = Path.home() / ".openclaw" / "data" / "best-options"
OUT_FILE = Path.home() / ".openclaw" / "data" / "multi-day-repeaters.json"
LOG_DIR = Path.home() / ".openclaw" / "workspace" / "logs"
LOG_DIR.mkdir(parents=True, exist_ok=True)
LOG_FILE = LOG_DIR / "multi_day_tracker.log"

LOOKBACK_DAYS = 5
MIN_DAYS_PRESENT = 3   # ticker must appear in 3 of 5 days to qualify
MIN_DAILY_PREMIUM = 1_000_000  # T1+ floor per day

def log(msg):
    ts = datetime.now(timezone.utc).isoformat()
    with LOG_FILE.open("a") as f:
        f.write(f"{ts} {msg}\n")
    print(msg, flush=True)

def et_now():
    return datetime.now(timezone.utc) + timedelta(hours=-4)

def load_snapshots():
    """Load up to LOOKBACK_DAYS snapshots, ending with yesterday."""
    snapshots = []
    et = et_now()
    for delta in range(1, LOOKBACK_DAYS + 1):
        d = et - timedelta(days=delta)
        fp = DATA_DIR / f"{d.strftime('%Y-%m-%d')}.json"
        if fp.exists():
            try:
                snap = json.loads(fp.read_text())
                snapshots.append({"date": d.strftime('%Y-%m-%d'),
                                  "contracts": snap.get("sorted_by_premium", [])})
            except Exception as e:
                log(f"parse fail {fp.name}: {e}")
    return snapshots

def analyze(snapshots):
    """Build multi-day pattern report."""
    if len(snapshots) < MIN_DAYS_PRESENT:
        return {"available_days": len(snapshots), "tickers": [], "strikes": []}

    # Per-day stats per ticker
    ticker_days = defaultdict(lambda: {"days": set(), "total_premium": 0,
                                        "call_premium": 0, "put_premium": 0,
                                        "contracts_seen": 0, "biggest_day": ("", 0)})
    # Per-(ticker, strike, type) repeats
    strike_days = defaultdict(lambda: {"days": set(), "total_premium": 0,
                                        "biggest": 0})

    for snap in snapshots:
        date = snap["date"]
        for c in snap["contracts"]:
            if c.get("tier") not in ("T1_HUGE", "T2_UNUSUAL_HUGE"): continue
            prem = c.get("premium", 0)
            if prem < MIN_DAILY_PREMIUM: continue
            t = c.get("ticker", "?")
            opt = c.get("option_type", "?").upper()
            strike = c.get("strike", 0)
            ticker_days[t]["days"].add(date)
            ticker_days[t]["total_premium"] += prem
            ticker_days[t]["contracts_seen"] += 1
            if opt.startswith("C"):
                ticker_days[t]["call_premium"] += prem
            else:
                ticker_days[t]["put_premium"] += prem
            if prem > ticker_days[t]["biggest_day"][1]:
                ticker_days[t]["biggest_day"] = (date, prem)
            key = (t, strike, opt[0] if opt else "?")
            strike_days[key]["days"].add(date)
            strike_days[key]["total_premium"] += prem
            if prem > strike_days[key]["biggest"]:
                strike_days[key]["biggest"] = prem

    # Filter to tickers/strikes hit on >= MIN_DAYS_PRESENT days
    qualified_tickers = []
    for t, d in ticker_days.items():
        if len(d["days"]) >= MIN_DAYS_PRESENT:
            cp = d["call_premium"]; pp = d["put_premium"]; total = d["total_premium"]
            call_pct = int(cp / total * 100) if total else 0
            bias = "BULL" if call_pct >= 65 else ("BEAR" if call_pct <= 35 else "MIXED")
            qualified_tickers.append({
                "ticker": t,
                "days_present": len(d["days"]),
                "days_list": sorted(d["days"]),
                "total_premium_5d": total,
                "avg_daily_premium": int(total / len(d["days"])),
                "contracts_seen": d["contracts_seen"],
                "bias": bias,
                "call_pct": call_pct,
                "biggest_day": d["biggest_day"][0],
                "biggest_day_premium": d["biggest_day"][1],
            })
    qualified_tickers.sort(key=lambda x: -x["total_premium_5d"])

    qualified_strikes = []
    for (t, strike, opt), d in strike_days.items():
        if len(d["days"]) >= MIN_DAYS_PRESENT:
            qualified_strikes.append({
                "ticker": t, "strike": strike, "type": opt,
                "days_present": len(d["days"]),
                "total_premium_5d": d["total_premium"],
                "biggest_single": d["biggest"],
            })
    qualified_strikes.sort(key=lambda x: -x["total_premium_5d"])

    return {
        "available_days": len(snapshots),
        "lookback_dates": [s["date"] for s in snapshots],
        "tickers": qualified_tickers[:15],
        "strikes": qualified_strikes[:10],
    }

def main():
    log(f"=== multi_day_tracker run {et_now().strftime('%Y-%m-%d %H:%M ET')} ===")
    snapshots = load_snapshots()
    log(f"Loaded {len(snapshots)} snapshots")
    report = analyze(snapshots)
    report["generated_at"] = datetime.now(timezone.utc).isoformat()
    OUT_FILE.parent.mkdir(parents=True, exist_ok=True)
    OUT_FILE.write_text(json.dumps(report, indent=2))
    log(f"Wrote report: {len(report.get('tickers',[]))} tickers, {len(report.get('strikes',[]))} strike clusters")
    log(f"=== done ===")

if __name__ == "__main__":
    main()
