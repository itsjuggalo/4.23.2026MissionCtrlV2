#!/usr/bin/env python3
"""realmoney_health.py — the drawdown + concentration guardrail the REAL-MONEY book
lacks (paper Boba/Jazzy have one; RH+CB did not). READ-ONLY, alert-only: never trades.

Reuses lib.portfolio.real_money_holdings() (live RH+CB crypto book via ARIES operator
mode) — the volatile ~56%-of-NAV sleeve. Tracks an intraday baseline (day-open + high-
water) in a small state file and alerts on drawdown or single-name concentration. Tax-
loss harvesting stays a manual review (broker APIs don't expose cost basis) — the
macro_calendar T-1 + a Friday nudge here remind you to run it.

  realmoney_health.py             # print (no send) — default
  realmoney_health.py --send      # push to trading_command Telegram (loud on breach)
Run with ~/.venv/bin/python (lib.* imports + ARIES).
"""
from __future__ import annotations

import argparse
import json
import sys
from datetime import datetime, timedelta, timezone
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parent))

ET = timezone(timedelta(hours=-4))
STATE = Path.home() / ".openclaw" / "state" / "realmoney_health.json"
DD_OPEN = -6.0     # % drop from day-open on the crypto book → alert
DD_HIGH = -8.0     # % drop from intraday high → alert (catches reversals)
CONC = 25.0        # single-name % of book → overweight flag


def now_et():
    return datetime.now(timezone.utc).astimezone(ET)


def baseline(total: float, today: str) -> tuple[float, float]:
    """Return (day_open, day_high), seeding/rolling the state file for today."""
    st = {}
    if STATE.exists():
        try:
            st = json.loads(STATE.read_text())
        except Exception:
            st = {}
    if st.get("date") != today:
        st = {"date": today, "open": total, "high": total}
    st["high"] = max(float(st.get("high", total)), total)
    STATE.parent.mkdir(parents=True, exist_ok=True)
    STATE.write_text(json.dumps(st))
    return float(st["open"]), float(st["high"])


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("--send", action="store_true")
    a = ap.parse_args()

    try:
        from lib.portfolio import real_money_holdings
    except Exception as e:
        print(f"[realmoney] import failed: {e}", flush=True)
        return
    h = real_money_holdings()
    if not h:
        print("[realmoney] no real-money holdings (ARIES unreachable) — skip", flush=True)
        return

    n = now_et()
    total = sum(h.values())
    ranked = sorted(h.items(), key=lambda x: -x[1])
    op, hi = baseline(total, n.strftime("%Y-%m-%d"))
    dd_open = (total / op - 1) * 100 if op else 0.0
    dd_high = (total / hi - 1) * 100 if hi else 0.0
    top_s, top_v = ranked[0]
    top_pct = top_v / total * 100 if total else 0.0

    breach = []
    if dd_open <= DD_OPEN:
        breach.append(f"book {dd_open:+.1f}% from day-open (cap {DD_OPEN:.0f}%)")
    if dd_high <= DD_HIGH:
        breach.append(f"book {dd_high:+.1f}% off intraday high (cap {DD_HIGH:.0f}%)")
    if top_pct >= CONC:
        breach.append(f"{top_s} {top_pct:.0f}% of book — overweight, trim")
    loud = bool(breach)

    head = "🛡️ <b>REAL-MONEY GUARD — RH+CB crypto</b>"
    L = [f"{head} · ${total:,.0f}",
         f"day-open {dd_open:+.1f}% · off-high {dd_high:+.1f}%"]
    L += [f"top: {top_s} ${top_v:,.0f} ({top_pct:.0f}%)"]
    if breach:
        L += ["", "🔴 <b>BREACH:</b>"] + [f"• {b}" for b in breach]
    else:
        L.append("✅ within drawdown + concentration limits")
    if n.weekday() == 4:  # Friday nudge
        L += ["", "🗓️ <i>Friday: run a tax-loss harvest review (basis is manual — see harvest sheet).</i>"]
    L += ["", "<i>Alert-only — real-money execution is yours. Not financial advice.</i>"]
    msg = "\n".join(L)

    if not a.send:
        print(msg.replace("<b>", "").replace("</b>", "").replace("<i>", "").replace("</i>", ""))
        print(f"\n[dry-run] would send={'LOUD' if loud else 'quiet'}", flush=True)
        return
    try:
        from lib.notify import tg_push
        fn = tg_push(msg, "trading_command", loud=loud,
                     fallback_token_file="telegram_laptopclaude_bot_token")
        print(f"[realmoney] sent via {fn} (loud={loud})", flush=True)
    except Exception as e:
        print(f"[realmoney] send FAILED: {e}", flush=True)


if __name__ == "__main__":
    main()
