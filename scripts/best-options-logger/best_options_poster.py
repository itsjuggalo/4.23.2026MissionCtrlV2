#!/usr/bin/env python3
"""best_options_poster — reads today's snapshot and posts top contracts to Discord."""
import json, sys, requests
from datetime import datetime, timezone, timedelta
from pathlib import Path

WEBHOOK = (Path.home() / ".openclaw" / "secrets" / "discord_bobatrades_webhook").read_text().strip()
DATA_DIR = Path.home() / ".openclaw" / "data" / "best-options"
TOP_N = 10
HEADERS = {"Content-Type": "application/json", "User-Agent": "MissionControl-BestOptionsPoster/1.0"}

def fmt_dollars(n):
    if n >= 1_000_000: return f"${n/1_000_000:.1f}M"
    if n >= 1_000: return f"${n/1_000:.0f}K"
    return f"${n}"

def main():
    et = datetime.now(timezone.utc) + timedelta(hours=-4)
    fp = DATA_DIR / f"{et.strftime('%Y-%m-%d')}.json"
    if not fp.exists():
        print(f"[poster] no snapshot for {et.strftime('%Y-%m-%d')}, skipping")
        return
    try:
        snap = json.loads(fp.read_text())
    except Exception as e:
        print(f"[poster] parse fail: {e}")
        return
    contracts = snap.get("sorted_by_premium", []) or []
    if not contracts:
        print(f"[poster] empty contracts, skipping")
        return
    tier_counts = snap.get("tier_counts", {})
    last_run = snap.get("last_run_human", "?")
    top = contracts[:TOP_N]
    lines = []
    for i, c in enumerate(top, 1):
        bull = "🟢" if c.get("is_bullish") else "🔴"
        prem = fmt_dollars(c.get("premium", 0))
        lines.append(
            f"`{i:>2}.` {bull} **{c.get('ticker','?')}** ${c.get('strike',0):.0f}{c.get('option_type','?')[0]} "
            f"{c.get('expiry','?')} • **{prem}** • V:{c.get('volume',0):,} OI:{c.get('oi',0):,} SW:{c.get('sweeps',0)} • "
            f"{c.get('tier','?').replace('_',' ')}"
        )
    t1 = tier_counts.get("T1_HUGE", 0)
    t2 = tier_counts.get("T2_UNUSUAL_HUGE", 0)
    header = f"**🐋 Top {len(top)} by Premium** • {last_run}\nT1: {t1} • T2: {t2} • Total: {len(contracts)}"
    content = (header + "\n\n" + "\n".join(lines))[:1900]
    try:
        r = requests.post(WEBHOOK, headers=HEADERS, json={"content": content}, timeout=10)
        print(f"[poster] posted top {len(top)}, status={r.status_code}")
    except Exception as e:
        print(f"[poster] FAIL: {e}")

if __name__ == "__main__":
    main()
