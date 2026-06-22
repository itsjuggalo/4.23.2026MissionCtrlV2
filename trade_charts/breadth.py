#!/usr/bin/env python3
"""
breadth.py — MARKET BREADTH regime gauge for #market-regime.

Uses a hardcoded, sector-diversified basket of ~40 large caps as an S&P proxy and
computes two classic breadth reads:

  1. % above 200-day MA  — the headline breadth gauge. Zones:
        <30  OVERSOLD / fear  -> straddles cheap, vol mean-reverts up
        30-50 weak            -> trust bearish flow more than bullish
        50-80 healthy         -> normal flow trust
        >80  COMPLACENT       -> froth, fade chasing, premium rich

  2. Advance / Decline — names UP vs DOWN today (daily momentum confirm).

Renders a half-circle gauge (% above 200MA, colored by zone) plus an A/D bar, and
captions the reading + what it means for trusting today's options-flow signals.

Read-only on all data. yfinance for OHLCV (200d window). NO emojis in matplotlib
titles (font lacks them) — emojis only in the Discord/TG caption text.

Usage: python3 breadth.py [--channel market-regime] [--dry]
"""
from __future__ import annotations
import sys, argparse, datetime as dt
from pathlib import Path
import numpy as np
import matplotlib
matplotlib.use("Agg")
import matplotlib.pyplot as plt
from matplotlib.patches import Wedge, Circle
import yfinance as yf

sys.path.insert(0, str(Path(__file__).resolve().parent.parent))
import chartlib  # noqa: E402  (shared dark theme + OUT path)
import deliver   # noqa: E402  (dual Discord+Telegram post)

OUT = chartlib.OUT
BG = "#0d1117"
FG = "#c9d1d9"
HEAD = "#e6edf3"
GREEN = "#3fb950"
RED = "#f85149"
AMBER = "#d29922"
GRID = "#21262d"

# ~40 large caps spread across all 11 GICS sectors — an S&P-500 breadth proxy.
BASKET = [
    # Technology
    "AAPL", "MSFT", "NVDA", "AVGO", "ADBE", "CRM", "ORCL",
    # Communication Services
    "GOOGL", "META", "NFLX", "DIS", "T",
    # Consumer Discretionary
    "AMZN", "TSLA", "HD", "MCD", "NKE",
    # Consumer Staples
    "WMT", "PG", "KO", "COST",
    # Financials
    "JPM", "BAC", "V", "MA", "GS",
    # Health Care
    "UNH", "JNJ", "LLY", "PFE", "ABBV",
    # Industrials
    "CAT", "BA", "GE", "HON",
    # Energy
    "XOM", "CVX",
    # Utilities
    "NEE",
    # Materials
    "LIN",
    # Real Estate
    "AMT",
]


def _zone(pct: float) -> tuple[str, str, str]:
    """Return (color, label, flow-meaning) for a % above 200MA reading."""
    if pct < 30:
        return (GREEN, "OVERSOLD / FEAR",
                "Washed out -> straddles cheap, vol mean-reverts UP. "
                "Trust bullish reversal flow; fade panic.")
    if pct < 50:
        return (AMBER, "WEAK / RISK-OFF",
                "Soft tape -> trust BEARISH flow more than bullish; size down longs.")
    if pct < 80:
        return (GREEN, "HEALTHY",
                "Broad participation -> normal flow trust; momentum chases tend to work.")
    return (RED, "COMPLACENT / FROTHY",
            "Overbought breadth -> premium rich, fade the chase. "
            "Bullish flow least reliable here; favor put protection / spreads.")


def compute() -> dict:
    """Download 1y daily closes for the basket; compute %>200MA and advance/decline."""
    # batch download is fast + polite; auto_adjust for clean MA
    data = yf.download(BASKET, period="1y", interval="1d",
                       auto_adjust=True, progress=False, group_by="ticker", threads=True)
    above = 0
    counted = 0
    adv = 0
    dec = 0
    flat = 0
    missing = []
    for t in BASKET:
        close = None
        try:
            close = data[t]["Close"].dropna()
        except Exception:
            close = None
        if close is None or len(close) < 200:
            # fall back to a per-ticker fetch (batch row may be short/missing)
            try:
                close = chartlib.fetch(t, period="1y")["Close"].dropna()
            except Exception:
                missing.append(t)
                continue
        if len(close) < 200:
            missing.append(t)
            continue
        ma200 = close.rolling(200).mean().iloc[-1]
        last = float(close.iloc[-1])
        prev = float(close.iloc[-2])
        counted += 1
        if last > ma200:
            above += 1
        if last > prev:
            adv += 1
        elif last < prev:
            dec += 1
        else:
            flat += 1
    pct = round(100 * above / counted) if counted else 0
    return dict(pct=pct, above=above, counted=counted, adv=adv, dec=dec,
                flat=flat, missing=missing)


def _gauge(ax, pct: float, color: str):
    """Half-circle gauge 0..100 with a needle at pct, on the dark theme."""
    # zone arcs (background): green / amber / green / red split at 30/50/80
    arcs = [(0, 30, GREEN), (30, 50, AMBER), (50, 80, GREEN), (80, 100, RED)]
    for lo, hi, c in arcs:
        # map 0..100 -> 180..0 degrees (left=0, right=100)
        a0 = 180 - lo * 1.8
        a1 = 180 - hi * 1.8
        ax.add_patch(Wedge((0, 0), 1.0, a1, a0, width=0.30, facecolor=c, alpha=0.55, edgecolor=BG, lw=1))
    # zone boundary ticks + labels
    for v in (0, 30, 50, 80, 100):
        ang = np.radians(180 - v * 1.8)
        x0, y0 = 0.68 * np.cos(ang), 0.68 * np.sin(ang)
        x1, y1 = 1.02 * np.cos(ang), 1.02 * np.sin(ang)
        ax.plot([x0, x1], [y0, y1], color=FG, lw=1)
        ax.text(1.12 * np.cos(ang), 1.12 * np.sin(ang), str(v), color="#8b949e",
                ha="center", va="center", fontsize=9)
    # needle
    ang = np.radians(180 - pct * 1.8)
    ax.plot([0, 0.82 * np.cos(ang)], [0, 0.82 * np.sin(ang)], color=color, lw=4, solid_capstyle="round")
    ax.add_patch(Circle((0, 0), 0.05, facecolor=color, edgecolor=BG, lw=1, zorder=5))
    # center reading
    ax.text(0, -0.18, f"{pct:.0f}%", color=color, ha="center", va="center",
            fontsize=34, fontweight="bold")
    ax.text(0, -0.34, "above 200-day MA", color=FG, ha="center", va="center", fontsize=11)
    ax.set_xlim(-1.3, 1.3)
    ax.set_ylim(-0.45, 1.25)
    ax.set_aspect("equal")
    ax.axis("off")


def render(r: dict) -> str:
    pct = r["pct"]
    color, label, _ = _zone(pct)
    fig = plt.figure(figsize=(11, 7.2), facecolor=BG)
    gs = fig.add_gridspec(2, 1, height_ratios=(3.0, 1.0), hspace=0.30)

    # --- gauge ---
    axg = fig.add_subplot(gs[0]); axg.set_facecolor(BG)
    _gauge(axg, pct, color)
    axg.set_title(f"Market Breadth — % of {r['counted']} large caps above 200-day MA",
                  color=HEAD, fontsize=14, loc="center", pad=14)
    axg.text(0, 1.18, label, color=color, ha="center", va="center", fontsize=15, fontweight="bold")

    # --- advance/decline bar ---
    axa = fig.add_subplot(gs[1]); axa.set_facecolor(BG)
    adv, dec, flat = r["adv"], r["dec"], r["flat"]
    total = max(adv + dec + flat, 1)
    axa.barh(0, adv, color=GREEN, edgecolor=BG)
    axa.barh(0, dec, left=adv, color=RED, edgecolor=BG)
    if flat:
        axa.barh(0, flat, left=adv + dec, color="#6e7681", edgecolor=BG)
    axa.text(adv / 2, 0, f"{adv} UP", color="#06210e", ha="center", va="center",
             fontsize=11, fontweight="bold") if adv else None
    axa.text(adv + dec / 2, 0, f"{dec} DN", color="#2b0606", ha="center", va="center",
             fontsize=11, fontweight="bold") if dec else None
    axa.set_xlim(0, total); axa.set_ylim(-0.6, 0.6)
    ad_ratio = adv / dec if dec else float(adv)
    axa.set_title(f"Today's Advance / Decline   (A/D ratio {ad_ratio:.2f})",
                  color=HEAD, fontsize=12, loc="left", pad=8)
    axa.axis("off")

    stamp = dt.datetime.now().strftime("%Y-%m-%d %H:%M ET")
    fig.text(0.99, 0.01, stamp, color="#6e7681", ha="right", va="bottom", fontsize=8)

    path = str(OUT / "breadth_gauge.png")
    fig.savefig(path, dpi=120, bbox_inches="tight", facecolor=BG)
    plt.close(fig)
    return path


def caption(r: dict) -> str:
    pct = r["pct"]
    _, label, meaning = _zone(pct)
    adv, dec = r["adv"], r["dec"]
    ad = adv / dec if dec else float(adv)
    emoji = "🟢" if 30 <= pct < 80 else ("🔵" if pct < 30 else "🔴")
    arrow = "📈" if adv > dec else ("📉" if dec > adv else "➖")
    return (
        f"{emoji} **Market Breadth — {pct}% above 200MA** ({label})\n"
        f"{arrow} Advance/Decline today: **{adv} up / {dec} down** (A/D {ad:.2f}), "
        f"basket of {r['counted']} large caps.\n"
        f"**What it means for flow:** {meaning}"
    )


def main():
    ap = argparse.ArgumentParser(description="Market breadth regime gauge -> #market-regime")
    ap.add_argument("--channel", default="market-regime")
    ap.add_argument("--dry", action="store_true")
    a = ap.parse_args()

    r = compute()
    if not r["counted"]:
        print("[breadth] no data — aborting"); sys.exit(1)
    png = render(r)
    cap = caption(r)
    if r["missing"]:
        print(f"[breadth] {len(r['missing'])} missing/short: {', '.join(r['missing'])}")
    print(f"[breadth] {r['pct']}% >200MA | A/D {r['adv']}/{r['dec']} | png={png}")
    dok, tok = deliver.post_chart(a.channel, png, cap, dry=a.dry)
    print(f"[breadth] discord={'✓' if dok else '✗'} tg={'✓' if tok else '✗'} -> #{a.channel}")


if __name__ == "__main__":
    main()
