#!/usr/bin/env python3
"""positions_review.py — REAL-MONEY (Robinhood + Coinbase) holdings review → visual card.

READ-ONLY. Pulls the merged, priced crypto book (lib/portfolio.real_money_holdings),
ranks by value, flags concentration (>25% in one name) + dust (<$20), renders an
allocation card (chart_renderer.holdings_card) + a concise read, and posts to a channel
we own (#main-portfolios). Cost basis / P&L is N/A (the broker API exposes qty only).

  positions_review.py                 # post the review → #main-portfolios
  positions_review.py --print         # text only, no post
  positions_review.py --channel main-portfolios
Run with ~/.venv/bin/python (matplotlib).
"""
from __future__ import annotations

import argparse
import sys
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parent))
from lib.portfolio import real_money_holdings   # noqa: E402  (read-only RH+CB, priced)
from lib import chart_renderer as cr             # noqa: E402
from lib import ops_card as oc                   # noqa: E402
from skill_to_discord import GUILD               # noqa: E402

SYNTH = (Path.home() / ".openclaw" / "secrets" / "discord_synthcontrol_token").read_text().strip()
CONCENTRATION = 25.0   # % of book in one name = overweight
DUST = 20.0            # $ below this = dust


def review():
    h = real_money_holdings()
    if not h:
        return None
    total = sum(h.values()) or 1.0
    ranked = sorted(h.items(), key=lambda x: -x[1])
    holdings = [(s, v, v / total * 100) for s, v in ranked]
    flags = []
    top_s, top_v = ranked[0]
    if top_v / total * 100 >= CONCENTRATION:
        flags.append(f"{top_s} {top_v/total*100:.0f}% — overweight, consider trimming")
    dust = [s for s, v in ranked if v < DUST]
    if dust:
        flags.append(f"{len(dust)} dust <$20: {', '.join(dust[:6])}")
    if not flags:
        flags.append("balanced — no single name >25%")
    spec = {"title": "REAL-MONEY · RH + Coinbase", "total": total, "holdings": holdings, "flags": flags}
    return spec, holdings, total, flags


def text_read(holdings, total, flags) -> str:
    lines = [f"💰 **REAL-MONEY REVIEW — Robinhood + Coinbase** · ${total:,.0f}"]
    for s, v, p in holdings[:6]:
        lines.append(f"   {s} ${v:,.0f} ({p:.0f}%)")
    lines.append("")
    lines += ["• " + f for f in flags]
    lines.append("_Read-only · cost basis n/a from broker API · not financial advice._")
    return "\n".join(lines)


def main() -> None:
    ap = argparse.ArgumentParser()
    ap.add_argument("--channel", default="main-portfolios")
    ap.add_argument("--print", action="store_true", dest="print_only")
    a = ap.parse_args()
    r = review()
    if not r:
        print("[positions] no real-money holdings (ARIES unreachable?)", flush=True)
        return
    spec, holdings, total, flags = r
    if a.print_only:
        print(text_read(holdings, total, flags))
        return
    cid = oc.resolve_channel(GUILD, SYNTH, a.channel)
    if not cid:
        print(f"[positions] #{a.channel} not found", flush=True)
        return
    png = cr.holdings_card(spec)
    ok = png and oc.post_image_bot(cid, SYNTH, png, content=text_read(holdings, total, flags)[:1900])
    print(f"[positions] posted: {'ok' if ok else 'FAILED'} (img={bool(png)})", flush=True)


if __name__ == "__main__":
    main()
