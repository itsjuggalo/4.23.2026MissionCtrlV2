#!/usr/bin/env python3
"""
best_options_poster — reads today's snapshot and posts top contracts to Discord.

Runs alongside the logger. Logger writes the JSON every 15 min during market hours,
poster reads it and posts a clean ranked list to #best-options-log so Mike sees
exactly what Boba and JazzyHazzy see.
"""
import json, sys, urllib.request
from datetime import datetime, timezone, timedelta
from pathlib import Path

WEBHOOK = (Path.home() / ".openclaw" / "secrets" / "discord_bobatrades_webhook").read_text().strip()
DATA_DIR = Path.home() / ".openclaw" / "data" / "best-options"
TOP_N = 10

def fmt_dollars(n):
    if n >= 1_000_000:
        return f"${n/1_000_000:.1f}M"
    if n >= 1_000:
        return f"${n/1_000:.0f}K"
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
        print(f"[poster] failed to parse snapshot: {e}")
        return
    contracts = snap.get("sorted_by_premium", []) or []
    if not contracts:
        print(f"[poster] empty contracts list, skipping")
        return
    tier_counts = snap.get("tier_counts", {})
    last_run = snap.get("last_run_human", "?")
    top = contracts[:TOP_N]
    # Build embed
    lines = []
    for i, c in enumerate(top, 1):
        bull = "🟢" if c.get("is_bullish") else "🔴"
        prem = fmt_dollars(c.get("premium", 0))
        ticker = c.get("ticker", "?")
        strike = c.get("strike", 0)
        opt_type = c.get("option_type", "?")
        expiry = c.get("expiry", "?")
        tier = c.get("tier", "?").replace("_", " ")
        sweeps = c.get("sweeps", 0)
        vol = c.get("volume", 0)
        oi = c.get("oi", 0)
        lines.append(
            f"`{i:>2}.` {bull} **{ticker}** ${strike:.0f}{opt_type[0]} {expiry} • "
            f"**{prem}** • V:{vol:,} OI:{oi:,} SW:{sweeps} • {tier}"
        )
    t1 = tier_counts.get("T1_HUGE", 0)
    t2 = tier_counts.get("T2_UNUSUAL_HUGE", 0)
    header = f"**🐋 Top {len(top)} by Premium** • {last_run}\nT1: {t1} • T2: {t2} • Total: {len(contracts)}"
    content = header + "\n\n" + "\n".join(lines)
    # Discord 2000 char limit
    if len(content) > 1900:
        content = content[:1897] + "..."
    body = json.dumps({"content": content}).encode()
    req = urllib.request.Request(WEBHOOK, data=body,
        headers={"Content-Type": "application/json"}, method="POST")
    try:
        resp = urllib.request.urlopen(req, timeout=10)
        print(f"[poster] posted top {len(top)}, status={resp.status}")
    except Exception as e:
        print(f"[poster] post FAIL: {e}")

if __name__ == "__main__":
    main()
