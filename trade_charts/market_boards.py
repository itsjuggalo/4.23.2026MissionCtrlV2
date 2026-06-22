#!/usr/bin/env python3
"""
market_boards.py — daily market-regime boards for #market-regime.

1. Flow heatmap   — top flow tickers by premium, bull/bear colored (from live flow JSON).
2. VIX term structure — ^VIX9D/^VIX/^VIX3M/^VIX6M curve (contango=calm / inverted=fear).
3. IV-rank board  — IV percentile per tracked ticker (populates as straddle_cards logs IV daily).

Usage: python3 market_boards.py [--channel market-regime] [--dry]
"""
from __future__ import annotations
import sys, json, argparse, time
from pathlib import Path
from collections import defaultdict
import numpy as np
import matplotlib; matplotlib.use("Agg")
import matplotlib.pyplot as plt
import yfinance as yf

sys.path.insert(0, str(Path(__file__).resolve().parent.parent))
import chartlib
import deliver

SYNTH_TOKEN = (Path.home() / ".openclaw/secrets/discord_synthcontrol_token").read_text().strip()
FLOW = Path.home() / "trading/signals/option-scraper/data/flow_alerts_today.json"
IVHIST = Path.home() / ".openclaw/workspace/charts/iv_history.json"
OUT = chartlib.OUT
BG = "#0d1117"


def _fig(h=6):
    fig, ax = plt.subplots(figsize=(11, h), facecolor=BG); ax.set_facecolor(BG)
    ax.tick_params(colors="#8b949e"); [s.set_color("#30363d") for s in ax.spines.values()]
    ax.grid(color="#21262d", lw=0.5, axis="x")
    return fig, ax


def flow_heatmap(top=15) -> str:
    raw = json.loads(FLOW.read_text()); items = raw.values() if isinstance(raw, dict) else raw
    prem = defaultdict(float); bull = defaultdict(float)
    for it in items:
        a = it.get("alert", it)
        if a.get("UnderlyingType") != "stock" or not a.get("Symbol"):
            continue
        p = (a.get("Volume", 0) or 0) * (a.get("AlertPrice", 0) or 0) * 100
        prem[a["Symbol"]] += p
        if a.get("isBullish"): bull[a["Symbol"]] += p
    rows = sorted(prem.items(), key=lambda x: x[1])[-top:]
    syms = [s for s, _ in rows]; vals = [v/1e6 for _, v in rows]
    cols = ["#3fb950" if bull[s] >= prem[s]/2 else "#f85149" for s in syms]
    fig, ax = _fig(7)
    ax.barh(syms, vals, color=cols)
    for i, v in enumerate(vals):
        ax.text(v, i, f" ${v:.1f}M", va="center", color="#c9d1d9", fontsize=8)
    ax.set_title("Options-Flow Heatmap — premium by ticker (green=net-bull / red=net-bear)",
                 color="#e6edf3", loc="left", fontsize=12)
    p = str(OUT / "board_flow_heatmap.png"); fig.savefig(p, dpi=120, bbox_inches="tight", facecolor=BG); plt.close(fig)
    return p


def vix_term() -> str | None:
    tks = {"VIX9D": "^VIX9D", "VIX": "^VIX", "VIX3M": "^VIX3M", "VIX6M": "^VIX6M"}
    vals = {}
    for lbl, t in tks.items():
        try:
            h = yf.Ticker(t).history(period="5d")["Close"].dropna()
            if len(h): vals[lbl] = float(h.iloc[-1])
        except Exception: pass
    if len(vals) < 2: return None
    labels = [k for k in ["VIX9D", "VIX", "VIX3M", "VIX6M"] if k in vals]
    ys = [vals[k] for k in labels]
    inverted = ys[0] > ys[-1]
    fig, ax = _fig(5.5)
    ax.plot(labels, ys, "-o", color="#f85149" if inverted else "#3fb950", lw=2)
    for x, y in zip(labels, ys): ax.text(x, y, f"  {y:.1f}", color="#c9d1d9", fontsize=10, va="bottom")
    regime = "BACKWARDATION → fear elevated (mean-revert plays)" if inverted else "CONTANGO → calm (momentum/flow-chasing)"
    ax.set_title(f"VIX Term Structure — {regime}", color="#e6edf3", loc="left", fontsize=12)
    ax.grid(color="#21262d", lw=0.5)
    p = str(OUT / "board_vix_term.png"); fig.savefig(p, dpi=120, bbox_inches="tight", facecolor=BG); plt.close(fig)
    return p


def iv_board(top=18) -> str | None:
    if not IVHIST.exists(): return None
    hist = json.loads(IVHIST.read_text())
    rows = []
    for tk, arr in hist.items():
        vals = [x[1] for x in arr]
        if len(vals) < 5: continue
        cur = vals[-1]; rank = round(100*sum(v <= cur for v in vals)/len(vals))
        rows.append((rank, tk, cur))
    if not rows: return None
    rows.sort()
    rows = rows[:top//2] + rows[-top//2:]   # cheapest + richest
    syms = [f"{t}" for _, t, _ in rows]; ranks = [r for r, _, _ in rows]
    cols = ["#3fb950" if r <= 30 else "#f85149" if r >= 60 else "#d29922" for r in ranks]
    fig, ax = _fig(7)
    ax.barh(syms, ranks, color=cols)
    for i, (r, _, c) in enumerate(rows): ax.text(r, i, f" {r}% (IV {c*100:.0f})", va="center", color="#c9d1d9", fontsize=8)
    ax.axvline(30, color="#3fb950", ls="--", lw=0.6); ax.axvline(60, color="#f85149", ls="--", lw=0.6)
    ax.set_xlim(0, 105)
    ax.set_title("IV Rank — green <=30 cheap (buy vol) / red >=60 rich (sell premium)", color="#e6edf3", loc="left", fontsize=12)
    p = str(OUT / "board_iv_rank.png"); fig.savefig(p, dpi=120, bbox_inches="tight", facecolor=BG); plt.close(fig)
    return p


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("--channel", default="market-regime")
    ap.add_argument("--dry", action="store_true")
    a = ap.parse_args()
    boards = [("flow heatmap", flow_heatmap, "🔥 **Options-Flow Heatmap** — where the premium is today"),
              ("VIX term", vix_term, "📉 **VIX Term Structure** — market regime"),
              ("IV rank", iv_board, "📊 **IV Rank Board** — straddle/vol picker")]
    n = 0
    for name, fn, cap in boards:
        try:
            png = fn()
        except Exception as e:
            print(f"  {name}: {e}"); continue
        if not png: print(f"  {name}: skipped (insufficient data)"); continue
        dok, tok = deliver.post_chart(a.channel, png, cap, dry=a.dry)
        print(f"  {name}: discord={'✓' if dok else '✗'} tg={'✓' if tok else '✗'}"); n += bool(dok or tok); time.sleep(0 if a.dry else 1)
    print(f"[boards] {n} posted → #{a.channel}")


if __name__ == "__main__":
    main()
