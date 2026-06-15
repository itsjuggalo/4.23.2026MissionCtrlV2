#!/usr/bin/env python3
"""crypto_eod_recap.py — end-of-day wrap of YOUR real-money crypto book to
#daily-crypto-pumps. Book value + 24h $ P&L + biggest movers. Read-only. Cron 4:05 ET.
"""
from __future__ import annotations

import json
import sys
import urllib.request
from datetime import datetime
from zoneinfo import ZoneInfo
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parent))
import skill_to_discord as sd  # noqa: E402
from lib.portfolio import real_money_holdings  # noqa: E402

ET = ZoneInfo("America/New_York")


def _chg(sym: str):
    try:
        r = urllib.request.Request(
            f"https://api.exchange.coinbase.com/products/{sym}-USD/stats",
            headers={"User-Agent": "mc/1.0"})
        d = json.loads(urllib.request.urlopen(r, timeout=10).read())
        o = float(d.get("open", 0) or 0)
        last = float(d.get("last", 0) or 0)
        return (last - o) / o * 100 if o else None
    except Exception:
        return None


def main():
    held = real_money_holdings()
    if not held:
        print("[crypto-eod] no holdings; skip", flush=True)
        return
    rows = []           # (sym, val, chg%, day_pl$)
    for sym, val in held.items():
        chg = _chg(sym)
        if chg is None:
            rows.append((sym, val, 0.0, 0.0))
            continue
        pl = val * (chg / (100 + chg)) if (100 + chg) else 0.0   # $ gained over the 24h
        rows.append((sym, val, chg, pl))
    total_val = sum(r[1] for r in rows)
    total_pl = sum(r[3] for r in rows)
    open_val = total_val - total_pl
    total_pct = (total_pl / open_val * 100) if open_val else 0.0
    arrow = "🟢" if total_pl >= 0 else "🔴"
    date = datetime.now(ET).strftime("%a %b %-d")

    winners = sorted([r for r in rows if r[2] > 0], key=lambda x: -x[2])[:3]
    losers = sorted([r for r in rows if r[2] < 0], key=lambda x: x[2])[:3]

    lines = [f"🌙 **CRYPTO EOD — {date}**",
             f"Book **${total_val:,.0f}**  ·  24h {arrow} **${total_pl:+,.0f}** ({total_pct:+.1f}%)"]
    if winners:
        lines.append("🚀 Top: " + " · ".join(f"**{s}** {c:+.1f}% (${pl:+,.0f})" for s, v, c, pl in winners))
    if losers:
        lines.append("🔻 Lagging: " + " · ".join(f"**{s}** {c:+.1f}% (${pl:+,.0f})" for s, v, c, pl in losers))
    # full book by size
    top = sorted(rows, key=lambda x: -x[1])[:8]
    lines.append("\n**Book by size:**")
    for s, v, c, pl in top:
        ic = "🟢" if c >= 0 else "🔴"
        lines.append(f"   {s:<6} ${v:,.0f}  {ic} {c:+.1f}%")
    lines.append("_Real-money RH + Coinbase. 24h = Coinbase rolling open→last._")
    sd.post(sd.resolve_channel("daily-crypto-pumps"), "\n".join(lines))
    print(f"[crypto-eod] posted; book ${total_val:,.0f} pl ${total_pl:+,.0f}", flush=True)


if __name__ == "__main__":
    main()
