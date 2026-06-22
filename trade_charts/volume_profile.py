#!/usr/bin/env python3
"""
volume_profile.py — Volume Profile (VPVR) cards for the top options-flow tickers.

Bins ~6 months of daily data by PRICE LEVEL (not time), sums traded volume into each
price bin, and draws a horizontal volume-by-price histogram alongside the price line.
Marks POC (point of control = highest-volume price level), the Value Area (70% of
volume), and high/low volume nodes. The trading read: a price moving through a
LOW-volume node runs fast (thin air, little resistance), while a HIGH-volume node
stalls/acts as support-resistance (lots of prior trade there).

Usage:
  python3 volume_profile.py --from-flow [--top 3]     # default: top 3 flow tickers
  python3 volume_profile.py SPY QQQ NVDA              # explicit tickers
  python3 volume_profile.py --from-flow --dry         # render only, no posting
  [--channel ta-charts]  [--bins 40]  [--period 6mo]
"""
from __future__ import annotations
import sys, json, argparse, time
from pathlib import Path
from collections import defaultdict

import numpy as np
import matplotlib; matplotlib.use("Agg")
import matplotlib.pyplot as plt

sys.path.insert(0, str(Path(__file__).resolve().parent.parent))  # 05_AUTOMATION/scripts
import chartlib                              # noqa: E402
import deliver                               # noqa: E402

FLOW = Path.home() / "trading/signals/option-scraper/data/flow_alerts_today.json"
BG = chartlib.BG if hasattr(chartlib, "BG") else "#0d1117"


def flow_names(top: int) -> list[str]:
    """Top stock tickers in today's flow, ranked by total premium (READ-ONLY)."""
    raw = json.loads(FLOW.read_text())
    items = raw.values() if isinstance(raw, dict) else raw
    prem: dict[str, float] = defaultdict(float)
    for it in items:
        a = it.get("alert", it) if isinstance(it, dict) else None
        if not a or a.get("UnderlyingType") != "stock" or not a.get("Symbol"):
            continue
        prem[a["Symbol"]] += (a.get("Volume", 0) or 0) * (a.get("AlertPrice", 0) or 0) * 100
    return [s for s, _ in sorted(prem.items(), key=lambda x: -x[1])[:top]]


def volume_profile(ticker: str, period="6mo", bins=40):
    """Build a price-binned volume profile from daily OHLCV.

    Each day's volume is distributed across the price bins its High-Low range touches
    (uniform split), which is closer to a true VPVR than dumping it all on the close.
    Returns dict with bin centers, per-bin volume, POC, value area, and node markers.
    """
    df = chartlib.fetch(ticker, period=period)
    lo = float(df["Low"].min())
    hi = float(df["High"].max())
    if hi <= lo:
        raise ValueError("flat price range")
    edges = np.linspace(lo, hi, bins + 1)
    centers = (edges[:-1] + edges[1:]) / 2
    vol = np.zeros(bins)

    bw = (hi - lo) / bins
    for _, row in df.iterrows():
        l, h, v = float(row["Low"]), float(row["High"]), float(row["Volume"])
        if v <= 0:
            continue
        lo_i = int(np.clip((l - lo) // bw, 0, bins - 1))
        hi_i = int(np.clip((h - lo) // bw, 0, bins - 1))
        span = hi_i - lo_i + 1
        vol[lo_i:hi_i + 1] += v / span  # spread day's volume over its range

    poc_i = int(np.argmax(vol))
    poc_price = float(centers[poc_i])

    # Value Area = the contiguous-ish set of bins (grown around POC) holding 70% of volume.
    total = vol.sum()
    target = total * 0.70
    inc = {poc_i}
    acc = vol[poc_i]
    lo_p, hi_p = poc_i - 1, poc_i + 1
    while acc < target and (lo_p >= 0 or hi_p < bins):
        below = vol[lo_p] if lo_p >= 0 else -1
        above = vol[hi_p] if hi_p < bins else -1
        if above >= below:
            if hi_p < bins: inc.add(hi_p); acc += vol[hi_p]; hi_p += 1
            elif lo_p >= 0: inc.add(lo_p); acc += vol[lo_p]; lo_p -= 1
        else:
            if lo_p >= 0: inc.add(lo_p); acc += vol[lo_p]; lo_p -= 1
            elif hi_p < bins: inc.add(hi_p); acc += vol[hi_p]; hi_p += 1
    va_lo = float(centers[min(inc)])
    va_hi = float(centers[max(inc)])

    nz = vol[vol > 0]
    mean_v = float(nz.mean()) if len(nz) else 0.0
    hvn = poc_price  # high-volume node = POC
    # low-volume node: the thinnest bin that still sits inside the traded range
    interior = [(vol[i], centers[i]) for i in range(bins) if vol[i] > 0]
    lvn = min(interior, key=lambda x: x[0])[1] if interior else poc_price

    return dict(ticker=ticker, df=df, centers=centers, vol=vol, bins=bins,
                poc=poc_price, va_lo=va_lo, va_hi=va_hi, hvn=hvn, lvn=lvn,
                mean_v=mean_v, spot=float(df["Close"].iloc[-1]),
                inc=inc, period=period)


def render(p) -> str:
    df = p["df"]; centers = p["centers"]; vol = p["vol"]
    spot = p["spot"]; poc = p["poc"]
    fig, (axp, axv) = plt.subplots(
        1, 2, figsize=(12, 7.5), facecolor=BG, sharey=True,
        gridspec_kw={"width_ratios": [3.2, 1.0], "wspace": 0.03})

    # ---- left: price line ----
    x = np.arange(len(df))
    axp.set_facecolor(BG)
    up = df["Close"].iloc[-1] >= df["Close"].iloc[0]
    axp.plot(x, df["Close"], color="#3fb950" if up else "#f85149", lw=1.4)
    axp.axhline(poc, color="#d29922", lw=1.4, ls="-")
    axp.axhspan(p["va_lo"], p["va_hi"], color="#58a6ff", alpha=0.08)
    axp.axhline(p["va_lo"], color="#58a6ff", lw=0.7, ls="--")
    axp.axhline(p["va_hi"], color="#58a6ff", lw=0.7, ls="--")
    axp.axhline(p["lvn"], color="#bc8cff", lw=0.9, ls=":")
    axp.axhline(spot, color="#8b949e", lw=0.6, ls="-")
    axp.text(0, poc, f" POC ${poc:,.2f}", color="#d29922", fontsize=9, va="bottom")
    axp.text(0, p["va_hi"], f" VA hi ${p['va_hi']:,.2f}", color="#58a6ff", fontsize=8, va="bottom")
    axp.text(0, p["va_lo"], f" VA lo ${p['va_lo']:,.2f}", color="#58a6ff", fontsize=8, va="top")
    axp.text(0, p["lvn"], f" LVN ${p['lvn']:,.2f} (runs fast)", color="#bc8cff", fontsize=8, va="center")
    axp.text(len(df) - 1, spot, f"${spot:,.2f} ", color="#c9d1d9", fontsize=9, va="center", ha="right")
    axp.tick_params(colors="#8b949e")
    [s.set_color("#30363d") for s in axp.spines.values()]
    axp.grid(color="#21262d", lw=0.5)
    axp.set_xlim(0, len(df) - 1)

    # ---- right: horizontal volume-by-price histogram ----
    axv.set_facecolor(BG)
    bw = centers[1] - centers[0] if len(centers) > 1 else 1.0
    cols = []
    for i, c in enumerate(centers):
        if i == int(np.argmax(vol)):
            cols.append("#d29922")                      # POC
        elif p["va_lo"] <= c <= p["va_hi"]:
            cols.append("#58a6ff")                      # value area
        elif vol[i] > 0 and vol[i] < p["mean_v"] * 0.4:
            cols.append("#bc8cff")                      # low-volume node
        else:
            cols.append("#39414d")                      # normal node
    axv.barh(centers, vol / 1e6, height=bw * 0.9, color=cols, align="center")
    axv.tick_params(colors="#8b949e")
    [s.set_color("#30363d") for s in axv.spines.values()]
    axv.grid(color="#21262d", lw=0.4, axis="x")
    axv.set_xlabel("vol (M)", color="#8b949e", fontsize=8)

    pos = "ABOVE POC (POC=support)" if spot >= poc else "BELOW POC (POC=resistance)"
    title = (f"{p['ticker']}   ${spot:,.2f}   Volume Profile ({p['period']}, {p['bins']} bins)\n"
             f"POC ${poc:,.2f}  ·  Value Area ${p['va_lo']:,.2f}-${p['va_hi']:,.2f}  ·  price {pos}")
    fig.suptitle(title, color="#e6edf3", fontsize=12, x=0.012, ha="left", y=0.98)

    path = str(chartlib.OUT / f"vprofile_{p['ticker']}.png")
    fig.savefig(path, dpi=120, bbox_inches="tight", facecolor=BG)
    plt.close(fig)
    return path


def caption(p) -> str:
    spot = p["spot"]; poc = p["poc"]
    side = "above" if spot >= poc else "below"
    role = "support below" if spot >= poc else "resistance above"
    return (f"📊 **{p['ticker']}** Volume Profile (VPVR) — "
            f"POC **${poc:,.2f}** (price {side} POC → POC is {role})\n"
            f"Value Area ${p['va_lo']:,.2f}-${p['va_hi']:,.2f} · LVN ${p['lvn']:,.2f}\n"
            f"_Flow at a low-volume node runs fast; at a high-volume node it stalls._")


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("tickers", nargs="*")
    ap.add_argument("--channel", default="ta-charts")
    ap.add_argument("--from-flow", action="store_true")
    ap.add_argument("--top", type=int, default=3)
    ap.add_argument("--bins", type=int, default=40)
    ap.add_argument("--period", default="6mo")
    ap.add_argument("--dry", action="store_true")
    a = ap.parse_args()

    tickers = a.tickers or (flow_names(a.top) if a.from_flow else flow_names(a.top))
    if not tickers:
        tickers = ["SPY"]
    print(f"[vprofile] tickers: {', '.join(tickers)}")
    n = 0
    for t in tickers:
        try:
            p = volume_profile(t, period=a.period, bins=a.bins)
            png = render(p)
        except Exception as e:
            print(f"  {t}: {e}"); continue
        cap = caption(p)
        dok, tok = deliver.post_chart(a.channel, png, cap, dry=a.dry)
        print(f"  {t}: discord={'✓' if dok else '✗'} tg={'✓' if tok else '✗'}")
        n += bool(dok or tok); time.sleep(0 if a.dry else 1)
    print(f"[vprofile] {n}/{len(tickers)} → #{a.channel}")


if __name__ == "__main__":
    main()
