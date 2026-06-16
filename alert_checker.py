#!/usr/bin/env python3
"""alert_checker.py — fire the user-set price alerts created by the Discord
"🔔 Set Alert" button. Reads pending alerts (lib/alerts), pulls live prices, posts
the ones that crossed to #price-checker (+ Telegram), and marks them fired so each
fires once. Cron during market hours. Run with ~/.venv/bin/python (yfinance).

  alert_checker.py            # check + fire
  alert_checker.py --print    # show pending, fire nothing
"""
from __future__ import annotations

import sys
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parent))
from lib import alerts as price_alerts  # noqa: E402
from lib import ops_card as oc           # noqa: E402

GUILD = "1486025777970548908"
SYNTH_TOKEN = (Path.home() / ".openclaw" / "secrets" / "discord_synthcontrol_token").read_text().strip()
CHANNEL = "price-checker"


def _last(t: str):
    try:
        import yfinance as yf
        i = yf.Ticker(t).history(period="1d", interval="5m")
        if len(i):
            return float(i["Close"].iloc[-1])
        h = yf.Ticker(t).history(period="1d")
        return float(h["Close"].iloc[-1]) if len(h) else None
    except Exception:
        return None


def main() -> None:
    pend = price_alerts.pending()
    if "--print" in sys.argv:
        for a in pend:
            print(f"{a['ticker']} {a['direction']} ${a['price']}  ({a.get('note', '')})")
        print(f"[alert-checker] {len(pend)} pending")
        return
    if not pend:
        print("[alert-checker] none pending", flush=True)
        return
    prices: dict[str, float | None] = {}
    fired = []
    for a in pend:
        t = a["ticker"]
        if t not in prices:
            prices[t] = _last(t)
        p = prices[t]
        if p is not None and price_alerts.crossed(a, p):
            fired.append((a, p))
    if not fired:
        print(f"[alert-checker] {len(pend)} pending, none crossed", flush=True)
        return
    cid = oc.resolve_channel(GUILD, SYNTH_TOKEN, CHANNEL)
    for a, p in fired:
        arrow = "🔺" if a["direction"] == "above" else "🔻"
        note = f" — {a['note']}" if a.get("note") else ""
        msg = (f"🔔 **PRICE ALERT** {arrow} **{a['ticker']}** crossed "
               f"**${a['price']:,.2f}** (now ${p:,.2f}){note}")
        if cid:
            oc.post_message_bot(cid, SYNTH_TOKEN, content=msg)
        try:
            from lib.notify import tg_brief
            tg_brief(msg)
        except Exception:
            pass
        price_alerts.mark_fired(a["id"])
        print(f"[alert-checker] fired {a['ticker']} @ {p}", flush=True)


if __name__ == "__main__":
    main()
