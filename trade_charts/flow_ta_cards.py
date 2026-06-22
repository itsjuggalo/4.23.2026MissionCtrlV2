#!/usr/bin/env python3
"""
flow_ta_cards.py — daily TA chart cards for the tickers in today's options-flow signals.

Reads the live flow stream (READ-ONLY), ranks tickers by premium/aggression, renders a
TA card per top ticker with the flow strikes annotated, and posts to a Discord channel.

Usage: python3 flow_ta_cards.py [--channel ta-charts] [--top 6] [--dry]
"""
from __future__ import annotations
import sys, json, argparse, time, datetime as dt
from pathlib import Path
from collections import defaultdict

sys.path.insert(0, str(Path(__file__).resolve().parent.parent))  # 05_AUTOMATION/scripts
import chartlib                            # noqa: E402
import deliver                             # noqa: E402

SYNTH_TOKEN = (Path.home() / ".openclaw/secrets/discord_synthcontrol_token").read_text().strip()
FLOW = Path.home() / "trading/signals/option-scraper/data/flow_alerts_today.json"


def load_flows():
    raw = json.loads(FLOW.read_text())
    items = raw.values() if isinstance(raw, dict) else raw
    out = []
    for it in items:
        a = it.get("alert", it) if isinstance(it, dict) else None
        if not a or not a.get("Symbol") or a.get("UnderlyingType") != "stock":
            continue
        prem = (a.get("Volume", 0) or 0) * (a.get("AlertPrice", 0) or 0) * 100
        out.append({
            "Symbol": a["Symbol"], "Strike": a.get("Strike"), "OptionType": a.get("OptionType"),
            "Expiry": a.get("Expiry"), "DTE": a.get("DTE"), "SWEEPS": a.get("SWEEPS", 0),
            "BLOCKS": a.get("BLOCKS", 0), "isBullish": a.get("isBullish"), "prem": prem,
        })
    return out


def rank(flows, top):
    by = defaultdict(list)
    for f in flows:
        by[f["Symbol"]].append(f)
    scored = []
    for sym, fs in by.items():
        prem = sum(f["prem"] for f in fs)
        scored.append((prem, sym, fs))
    scored.sort(reverse=True)
    return scored[:top]


def caption(sym, fs):
    prem = sum(f["prem"] for f in fs)
    bull = sum(1 for f in fs if f.get("isBullish"))
    bear = len(fs) - bull
    big = max(fs, key=lambda f: f["prem"])
    exp = dt.datetime.fromtimestamp(big["Expiry"]).strftime("%-m/%-d") if big.get("Expiry") else "?"
    kind = "SWEEP" if big.get("SWEEPS") else ("BLOCK" if big.get("BLOCKS") else "flow")
    arrow = "🟢" if bull >= bear else "🔴"
    return (f"{arrow} **{sym}** — {len(fs)} flow hits (${prem/1e6:.1f}M), "
            f"{bull}🟢/{bear}🔴 · biggest: ${big['Strike']:g}{big['OptionType'][0]} {exp} ({kind})")


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("--channel", default="ta-charts")
    ap.add_argument("--top", type=int, default=6)
    ap.add_argument("--dry", action="store_true")
    args = ap.parse_args()

    flows = load_flows()
    top = rank(flows, args.top)
    print(f"[flow-ta] {len(flows)} stock flows → top {len(top)} tickers")
    posted = 0
    for prem, sym, fs in top:
        try:
            png = chartlib.render_ta(sym, flows=fs[:5])
        except Exception as e:
            print(f"  {sym}: render fail {e}"); continue
        cap = caption(sym, fs)
        dok, tok = deliver.post_chart(args.channel, png, cap, dry=args.dry)
        print(f"  {sym}: discord={'✓' if dok else '✗'} tg={'✓' if tok else '✗'}")
        posted += bool(dok or tok); time.sleep(0 if args.dry else 1)
    print(f"[flow-ta] {posted}/{len(top)} cards → #{args.channel}")


if __name__ == "__main__":
    main()
