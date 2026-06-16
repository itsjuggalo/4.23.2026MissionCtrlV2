#!/usr/bin/env python3
"""chart_renderer.py — real charts + gauges + tiles → PNG, for Discord cards.

Pure matplotlib (Agg, no browser, no new pip deps). Dark "hybrid" palette: clean,
novice-readable charts on a subtle StarCraft-Terran tint. Every public fn returns a
PNG path or None (never raises) so a render hiccup can never drop a message.

Composers (one PNG = the whole message):
    pick_card(spec)       candle+EMA chart · conviction/V-OI gauges · facts · WHAT/PLAY
    market_card(spec)     SPY/QQQ/VIX/your-names tiles + regime dial
    scorecard_card(spec)  book P&L bar + best/worst mini-charts + grade rows
    selftest()            render one of each to /tmp (healthcheck)

Data: yfinance OHLC (cached per-process). Indicators via pandas ewm/rolling.
"""
from __future__ import annotations

import os
import time
import traceback

import matplotlib
matplotlib.use("Agg")
import matplotlib.pyplot as plt          # noqa: E402
import numpy as np                       # noqa: E402
from matplotlib.patches import Rectangle, Wedge, Circle, FancyBboxPatch  # noqa: E402

# ── hybrid palette (Terran Dominion, novice-readable) ─────────────────────────
PAL = {
    "bg":     "#0c1722",
    "bg2":    "#060c12",
    "panel":  "#11202e",
    "panel2": "#0c1925",
    "edge":   "#2f5f8a",
    "text":   "#dfeaf2",
    "muted":  "#7f9bb3",
    "accent": "#f0a500",   # amber — EMA20 / highlights
    "ema2":   "#4aa3ff",   # blue  — EMA50
    "up":     "#2ecc71",
    "down":   "#e74c3c",
    "neutral": "#f1c40f",
    "glow":   "#1f4d73",
}
plt.rcParams.update({
    "font.family": "DejaVu Sans",
    "font.size": 11,
    "axes.edgecolor": PAL["edge"],
    "text.color": PAL["text"],
    "axes.labelcolor": PAL["text"],
    "xtick.color": PAL["muted"],
    "ytick.color": PAL["muted"],
    "figure.facecolor": PAL["bg"],
    "savefig.facecolor": PAL["bg"],
})

_TMP = "/tmp"
_OHLC_CACHE: dict = {}


def _out(name: str) -> str:
    return os.path.join(_TMP, f"mc_card_{name}_{os.getpid()}_{int(time.time()*1000) % 100000}.png")


# ── data ──────────────────────────────────────────────────────────────────────
def ohlc(symbol: str, days: int = 45, interval: str = "1d"):
    """OHLCV DataFrame via yfinance (per-process cached). None on failure."""
    key = (symbol.upper(), days, interval)
    if key in _OHLC_CACHE:
        return _OHLC_CACHE[key]
    try:
        import yfinance as yf
        period = f"{max(days, 5)}d" if interval.endswith(("m", "h")) else f"{max(days, 5) + 10}d"
        df = yf.Ticker(symbol).history(period=period, interval=interval)
        if df is None or len(df) < 3:
            _OHLC_CACHE[key] = None
            return None
        df = df.dropna(subset=["Open", "High", "Low", "Close"])   # drop partial/empty trailing bar
        if len(df) < 3:
            _OHLC_CACHE[key] = None
            return None
        df = df.tail(days + 5)
        _OHLC_CACHE[key] = df
        return df
    except Exception:
        _OHLC_CACHE[key] = None
        return None


def last_price(symbol: str):
    df = ohlc(symbol, days=5, interval="5m")
    if df is None:
        df = ohlc(symbol, days=5, interval="1d")
    try:
        return float(df["Close"].iloc[-1]) if df is not None and len(df) else None
    except Exception:
        return None


# ── primitives ──────────────────────────────────────────────────────────────
def _style_ax(ax):
    ax.set_facecolor(PAL["panel2"])
    for s in ax.spines.values():
        s.set_color(PAL["edge"])
        s.set_linewidth(0.8)
    ax.grid(True, color=PAL["edge"], alpha=0.18, linewidth=0.6)
    ax.tick_params(length=0, labelsize=8)


def draw_candles(ax, df, emas=(20, 50), levels=None, marks=None):
    """Candlesticks + EMA lines + faint volume overlay (twin axis)."""
    _style_ax(ax)
    o = df["Open"].values; h = df["High"].values
    l = df["Low"].values;  c = df["Close"].values
    x = np.arange(len(df))
    up = c >= o
    rng = (np.nanmax(h) - np.nanmin(l)) or 1.0
    minw = rng * 0.0015
    # wicks
    for i in range(len(df)):
        col = PAL["up"] if up[i] else PAL["down"]
        ax.plot([x[i], x[i]], [l[i], h[i]], color=col, linewidth=0.8, alpha=0.9, zorder=2)
        bot = min(o[i], c[i]); ht = max(abs(c[i] - o[i]), minw)
        ax.add_patch(Rectangle((x[i] - 0.32, bot), 0.64, ht, facecolor=col,
                               edgecolor=col, linewidth=0.4, zorder=3))
    # EMAs
    close = df["Close"]
    for span, col in zip(emas, [PAL["accent"], PAL["ema2"]]):
        ema = close.ewm(span=span, adjust=False).mean().values
        ax.plot(x, ema, color=col, linewidth=1.4, alpha=0.95, zorder=4, label=f"EMA{span}")
    # support/resistance / entry-stop marks
    for lv in (levels or []):
        ax.axhline(lv, color=PAL["muted"], linestyle="--", linewidth=0.8, alpha=0.5, zorder=1)
    for m in (marks or []):
        ax.axhline(m["y"], color=m.get("color", PAL["accent"]), linestyle=":",
                   linewidth=1.1, alpha=0.8, zorder=5)
    # volume (faint, twin axis at bottom)
    try:
        vol = df["Volume"].values.astype(float)
        axv = ax.twinx()
        axv.bar(x, vol, width=0.64, color=[PAL["up"] if u else PAL["down"] for u in up],
                alpha=0.16, zorder=0)
        axv.set_ylim(0, (np.nanmax(vol) or 1) * 4)   # keep bars in lower quarter
        axv.axis("off")
    except Exception:
        pass
    # x ticks: a few dated labels
    n = len(df)
    idx = list(range(0, n, max(1, n // 5)))
    ax.set_xticks(idx)
    try:
        ax.set_xticklabels([df.index[i].strftime("%-m/%-d") for i in idx], fontsize=7.5)
    except Exception:
        ax.set_xticklabels([str(i) for i in idx], fontsize=7.5)
    ax.set_xlim(-1, n)
    ax.legend(loc="upper left", fontsize=7.5, framealpha=0.0, labelcolor=PAL["muted"])
    # last price tag
    ax.text(0.99, 0.97, f"${c[-1]:,.2f}", transform=ax.transAxes, ha="right", va="top",
            fontsize=11, fontweight="bold", color=PAL["text"],
            bbox=dict(boxstyle="round,pad=0.25", fc=PAL["panel"], ec=PAL["edge"], lw=0.6))


def draw_gauge(ax, value, vmax, label, color=None, fmt="{:.1f}"):
    """Half-circle dial 0(left)→vmax(right) with needle + center value."""
    ax.axis("off"); ax.set_aspect("equal")
    ax.set_xlim(-1.18, 1.18); ax.set_ylim(-0.32, 1.22)
    frac = 0.0 if not vmax else max(0.0, min(1.0, float(value) / float(vmax)))
    color = color or (PAL["up"] if frac >= 0.66 else PAL["neutral"] if frac >= 0.33 else PAL["down"])
    ax.add_patch(Wedge((0, 0), 1.0, 0, 180, width=0.30, facecolor=PAL["panel2"], edgecolor=PAL["edge"], lw=0.6))
    ax.add_patch(Wedge((0, 0), 1.0, 180 * (1 - frac), 180, width=0.30, facecolor=color, edgecolor="none"))
    th = np.radians(180 * (1 - frac))
    ax.plot([0, 0.82 * np.cos(th)], [0, 0.82 * np.sin(th)], color=PAL["text"], lw=2.2, zorder=5)
    ax.add_patch(Circle((0, 0), 0.07, facecolor=PAL["text"], zorder=6))
    ax.text(0, -0.20, fmt.format(value), ha="center", va="center", color=PAL["text"],
            fontsize=15, fontweight="bold")
    ax.text(0, 1.04, label, ha="center", va="center", color=PAL["muted"], fontsize=9.5)


def draw_sparkline(ax, series, color=None):
    _style_ax(ax); ax.grid(False)
    for s in ax.spines.values():
        s.set_visible(False)
    s = np.asarray(series, dtype=float)
    if len(s) < 2:
        ax.axis("off"); return
    color = color or (PAL["up"] if s[-1] >= s[0] else PAL["down"])
    x = np.arange(len(s))
    ax.plot(x, s, color=color, linewidth=1.6)
    ax.fill_between(x, s, s.min(), color=color, alpha=0.15)
    ax.set_xticks([]); ax.set_yticks([])


def draw_tile(ax, ticker, price, chg, series):
    ax.set_facecolor(PAL["panel"]); ax.set_xticks([]); ax.set_yticks([])
    for s in ax.spines.values():
        s.set_color(PAL["edge"]); s.set_linewidth(0.8)
    col = PAL["up"] if (chg or 0) >= 0 else PAL["down"]
    ax.text(0.06, 0.82, ticker, transform=ax.transAxes, fontsize=12, fontweight="bold", color=PAL["text"])
    ax.text(0.94, 0.82, f"{chg:+.1f}%", transform=ax.transAxes, ha="right", fontsize=11,
            fontweight="bold", color=col)
    ax.text(0.06, 0.60, f"{price:,.2f}" if price else "—", transform=ax.transAxes,
            fontsize=10.5, color=PAL["muted"])
    if series is not None and len(series) >= 2:
        sx = np.asarray(series, dtype=float)
        xs = np.linspace(0.06, 0.94, len(sx))
        ys = 0.12 + 0.38 * (sx - sx.min()) / ((sx.max() - sx.min()) or 1)
        ax.plot(xs, ys, transform=ax.transAxes, color=col, linewidth=1.4)


def _badge(ax, x, y, text, fg, transform):
    ax.text(x, y, text, transform=transform, ha="left", va="center", fontsize=10.5,
            fontweight="bold", color=fg,
            bbox=dict(boxstyle="round,pad=0.32", fc=PAL["panel"], ec=fg, lw=1.0))


def _save(fig, name):
    path = _out(name)
    fig.savefig(path, dpi=130, bbox_inches="tight", pad_inches=0.18, facecolor=PAL["bg"])
    plt.close(fig)
    return path


# ── composers ─────────────────────────────────────────────────────────────────
def pick_card(spec: dict):
    """spec: symbol, contract, tier('T1'..), is_bullish, premium($), voi, sweeps,
    blocks, dte, spot, conviction(0-10), iv(optional 0-100 ivrank), what, play, days."""
    try:
        sym = str(spec.get("symbol", "?")).upper()
        df = ohlc(sym, days=int(spec.get("days", 45)), interval="1d")
        bull = bool(spec.get("is_bullish", True))
        dir_col = PAL["up"] if bull else PAL["down"]
        fig = plt.figure(figsize=(11, 6.9))
        gs = fig.add_gridspec(3, 2, height_ratios=[0.55, 3.0, 1.25],
                              width_ratios=[2.15, 1.0], hspace=0.30, wspace=0.16)
        # title
        axt = fig.add_subplot(gs[0, :]); axt.axis("off")
        axt.text(0.0, 0.5, sym, transform=axt.transAxes, va="center",
                 fontsize=21, fontweight="bold", color=PAL["text"])
        axt.text(0.27, 0.5, f"{spec.get('contract','')}", transform=axt.transAxes, va="center",
                 fontsize=14, color=PAL["muted"])
        tier = str(spec.get("tier", "")).upper()
        if tier:
            _badge(axt, 0.80, 0.5, tier, PAL["accent"], axt.transAxes)
        _badge(axt, 0.90, 0.5, "BULLISH" if bull else "BEARISH", dir_col, axt.transAxes)
        # chart
        axc = fig.add_subplot(gs[1, 0])
        if df is not None:
            marks = []
            if spec.get("spot"):
                marks.append({"y": float(spec["spot"]), "color": PAL["accent"]})
            draw_candles(axc, df, emas=(20, 50), marks=marks)
            axc.set_title(f"{sym} · daily · EMA 20/50", fontsize=10, color=PAL["muted"], loc="left")
        else:
            axc.axis("off")
            axc.text(0.5, 0.5, f"{sym}: no chart data", ha="center", va="center", color=PAL["muted"])
        # right column: 2 gauges + facts
        gsr = gs[1, 1].subgridspec(2, 2, height_ratios=[1.0, 1.05], hspace=0.05, wspace=0.1)
        draw_gauge(fig.add_subplot(gsr[0, 0]), float(spec.get("conviction", 0)), 10, "Conviction")
        if spec.get("iv") is not None:
            draw_gauge(fig.add_subplot(gsr[0, 1]), float(spec["iv"]), 100, "IV rank", fmt="{:.0f}")
        else:
            draw_gauge(fig.add_subplot(gsr[0, 1]), min(float(spec.get("voi", 0)), 20), 20, "V/OI", fmt="{:.0f}")
        axf = fig.add_subplot(gsr[1, :]); axf.axis("off")
        prem = spec.get("premium", 0)
        facts = [
            ("Premium", f"${prem/1e6:.2f}M" if prem >= 1e6 else f"${prem/1e3:.0f}K"),
            ("V / OI", f"{spec.get('voi',0):.1f}×"),
            ("Sweeps / Blocks", f"{int(spec.get('sweeps',0))} / {int(spec.get('blocks',0))}"),
            ("DTE", f"{int(spec.get('dte',0))}d"),
        ]
        for i, (k, v) in enumerate(facts):
            yy = 0.92 - i * 0.25
            axf.text(0.02, yy, k, transform=axf.transAxes, fontsize=10, color=PAL["muted"])
            axf.text(0.98, yy, v, transform=axf.transAxes, fontsize=11.5, ha="right",
                     fontweight="bold", color=PAL["text"])
        # WHAT / PLAY
        axb = fig.add_subplot(gs[2, :]); axb.axis("off")
        axb.add_patch(FancyBboxPatch((0.0, 0.0), 1.0, 1.0, transform=axb.transAxes,
                      boxstyle="round,pad=0.01", fc=PAL["panel"], ec=PAL["edge"], lw=0.8, zorder=0))
        what = str(spec.get("what", "")).strip()
        play = str(spec.get("play", "")).strip()
        axb.text(0.02, 0.72, "WHAT THIS MEANS", transform=axb.transAxes, fontsize=8.5,
                 color=PAL["accent"], fontweight="bold")
        axb.text(0.02, 0.50, what, transform=axb.transAxes, fontsize=10.5, color=PAL["text"], wrap=True)
        axb.text(0.02, 0.26, "HOW TO PLAY IT", transform=axb.transAxes, fontsize=8.5,
                 color=PAL["accent"], fontweight="bold")
        axb.text(0.02, 0.05, play, transform=axb.transAxes, fontsize=10.5, color=PAL["text"], wrap=True)
        return _save(fig, f"pick_{sym}")
    except Exception:
        print("chart_renderer.pick_card error:\n" + traceback.format_exc())
        return None


def market_card(spec: dict):
    """spec: title, tiles=[{ticker,price,chg,series}], regime={label,score(0-10),color}."""
    try:
        tiles = spec.get("tiles", []) or []
        n = max(1, len(tiles))
        fig = plt.figure(figsize=(11, 4.4))
        gs = fig.add_gridspec(2, max(n, 4), height_ratios=[0.5, 3], hspace=0.35, wspace=0.18)
        axt = fig.add_subplot(gs[0, :]); axt.axis("off")
        axt.text(0.0, 0.5, spec.get("title", "MARKET DASHBOARD"), transform=axt.transAxes,
                 va="center", fontsize=18, fontweight="bold", color=PAL["text"])
        reg = spec.get("regime") or {}
        if reg:
            axt.text(1.0, 0.5, reg.get("label", ""), transform=axt.transAxes, va="center", ha="right",
                     fontsize=13, fontweight="bold", color=reg.get("color", PAL["neutral"]))
        for i, t in enumerate(tiles):
            ax = fig.add_subplot(gs[1, i])
            draw_tile(ax, t.get("ticker", "?"), t.get("price", 0), t.get("chg", 0), t.get("series"))
        # regime dial in the last slot if room
        if reg and len(tiles) < max(n, 4):
            axg = fig.add_subplot(gs[1, max(n, 4) - 1])
            draw_gauge(axg, float(reg.get("score", 5)), 10, reg.get("label", "REGIME"),
                       color=reg.get("color"))
        return _save(fig, "market")
    except Exception:
        print("chart_renderer.market_card error:\n" + traceback.format_exc())
        return None


def scorecard_card(spec: dict):
    """spec: book(val,day_pl), best={sym,move,series}, worst={...}, rows=[(label,move,ok)]."""
    try:
        fig = plt.figure(figsize=(11, 5.2))
        gs = fig.add_gridspec(2, 3, height_ratios=[1.0, 1.1], width_ratios=[1.2, 1, 1],
                              hspace=0.4, wspace=0.22)
        book = spec.get("book", {})
        axt = fig.add_subplot(gs[0, :]); axt.axis("off")
        pl = float(book.get("day_pl", 0)); col = PAL["up"] if pl >= 0 else PAL["down"]
        axt.text(0.0, 0.7, "EOD SCORECARD", transform=axt.transAxes, fontsize=18,
                 fontweight="bold", color=PAL["text"])
        axt.text(0.0, 0.25, f"Book ${book.get('val',0):,.0f}", transform=axt.transAxes,
                 fontsize=13, color=PAL["muted"])
        axt.text(0.30, 0.25, f"Day {pl:+,.0f}", transform=axt.transAxes, fontsize=14,
                 fontweight="bold", color=col)
        for slot, key, lbl in ((gs[1, 0], "best", "▲ BEST"), (gs[1, 1], "worst", "▼ WORST")):
            d = spec.get(key)
            ax = fig.add_subplot(slot)
            if d and d.get("series") is not None:
                draw_sparkline(ax, d["series"])
                ax.set_title(f"{lbl} · {d.get('sym','')} {d.get('move',0):+.1f}%", fontsize=10,
                             color=PAL["muted"], loc="left")
            else:
                ax.axis("off")
        axr = fig.add_subplot(gs[1, 2]); axr.axis("off")
        rows = spec.get("rows", []) or []
        axr.text(0.0, 1.0, "PICKS", transform=axr.transAxes, fontsize=9, color=PAL["accent"], fontweight="bold")
        for i, (label, move, ok) in enumerate(rows[:6]):
            yy = 0.85 - i * 0.16
            c = PAL["up"] if ok else PAL["down"]
            axr.text(0.0, yy, ("✓ " if ok else "✗ ") + label, transform=axr.transAxes,
                     fontsize=9.5, color=PAL["text"])
            axr.text(1.0, yy, f"{move:+.1f}%", transform=axr.transAxes, ha="right", fontsize=9.5, color=c)
        return _save(fig, "scorecard")
    except Exception:
        print("chart_renderer.scorecard_card error:\n" + traceback.format_exc())
        return None


def holdings_card(spec: dict):
    """Real-money allocation. spec: title, total, holdings=[(sym,value,pct)], flags=[str].
    Horizontal value bars (overweight names amber), total, concentration/dust flags."""
    try:
        H = (spec.get("holdings") or [])[:9]
        if not H:
            return None
        total = spec.get("total") or sum(v for _, v, _ in H) or 1
        fig = plt.figure(figsize=(11, 5.8))
        gs = fig.add_gridspec(2, 1, height_ratios=[0.5, 4.0], hspace=0.22)
        axt = fig.add_subplot(gs[0]); axt.axis("off")
        axt.text(0.0, 0.5, spec.get("title", "REAL-MONEY HOLDINGS"), transform=axt.transAxes,
                 va="center", fontsize=18, fontweight="bold", color=PAL["text"])
        axt.text(1.0, 0.5, f"${total:,.0f}", transform=axt.transAxes, va="center", ha="right",
                 fontsize=17, fontweight="bold", color=PAL["accent"])
        ax = fig.add_subplot(gs[1]); ax.set_facecolor(PAL["panel2"])
        for s in ax.spines.values():
            s.set_visible(False)
        labels = [h[0] for h in H][::-1]; vals = [h[1] for h in H][::-1]; pcts = [h[2] for h in H][::-1]
        y = np.arange(len(labels))
        cols = [PAL["accent"] if p >= 25 else PAL["ema2"] for p in pcts]
        ax.barh(y, vals, color=cols, height=0.62, zorder=2)
        ax.set_yticks(y); ax.set_yticklabels(labels, fontsize=11.5, color=PAL["text"])
        ax.set_xticks([]); ax.grid(False)
        ax.set_xlim(0, max(vals) * 1.28)
        for yi, v, p in zip(y, vals, pcts):
            ax.text(v, yi, f"  ${v:,.0f} · {p:.0f}%", va="center", fontsize=10.5, color=PAL["text"])
        flags = spec.get("flags") or []
        if flags:
            ax.set_title("   ".join("• " + f for f in flags), fontsize=9.5, color=PAL["muted"], loc="left")
        return _save(fig, "holdings")
    except Exception:
        print("chart_renderer.holdings_card error:\n" + traceback.format_exc())
        return None


def payoff_card(spec: dict):
    """Option payoff-at-expiry diagram. spec from lib/options.autofill: symbol, opt_type,
    strike, premium, spot, contracts, expiry, breakeven, iv, delta, theta. Profit zone
    shaded green / loss red; spot, strike, breakeven marked. Novice-readable."""
    try:
        sym = str(spec.get("symbol", "?")).upper()
        K = float(spec["strike"]); prem = float(spec["premium"])
        call = str(spec.get("opt_type", "call")) == "call"
        spot = float(spec.get("spot") or K); ctr = int(spec.get("contracts", 1) or 1)
        mult = 100 * ctr
        be = spec.get("breakeven") or (K + prem if call else K - prem)
        lo = max(0.01, min(spot, K, be) * 0.80); hi = max(spot, K, be) * 1.20
        xs = np.linspace(lo, hi, 240)
        pnl = ((np.maximum(xs - K, 0) if call else np.maximum(K - xs, 0)) - prem) * mult
        fig = plt.figure(figsize=(11, 6.3))
        gs = fig.add_gridspec(2, 1, height_ratios=[3.0, 1.05], hspace=0.32)
        ax = fig.add_subplot(gs[0]); _style_ax(ax)
        ax.axhline(0, color=PAL["muted"], lw=1.0, alpha=0.6)
        ax.fill_between(xs, pnl, 0, where=(pnl >= 0), color=PAL["up"], alpha=0.20, zorder=1)
        ax.fill_between(xs, pnl, 0, where=(pnl < 0), color=PAL["down"], alpha=0.20, zorder=1)
        ax.plot(xs, pnl, color=PAL["text"], lw=2.2, zorder=4)
        y0, y1 = ax.get_ylim()
        ax.axvline(spot, color=PAL["text"], ls="--", lw=1.3, alpha=0.85, zorder=3)
        ax.text(spot, y1, f" spot ${spot:,.2f}", color=PAL["text"], fontsize=8.5, va="top")
        ax.axvline(K, color=PAL["muted"], ls=":", lw=1.2, zorder=2)
        ax.text(K, y0, " strike", color=PAL["muted"], fontsize=8.5, va="bottom")
        ax.axvline(be, color=PAL["accent"], ls="-.", lw=1.3, zorder=3)
        ax.text(be, 0, f" B/E ${be:,.2f}", color=PAL["accent"], fontsize=8.5, va="bottom")
        cp = "C" if call else "P"
        ax.set_title(f"{sym} ${K:g}{cp} {spec.get('expiry','')} · payoff at expiry · {ctr} contract"
                     f"{'s' if ctr != 1 else ''}", fontsize=12.5, color=PAL["text"], loc="left")
        ax.set_ylabel("profit / loss ($)"); ax.set_xlabel("underlying price at expiry")
        # facts strip
        axf = fig.add_subplot(gs[1]); axf.axis("off")
        facts = [("Cost (premium)", f"${prem:.2f} × {ctr} = ${prem*mult:,.0f}"),
                 ("Breakeven", f"${be:,.2f}"),
                 ("Max loss", f"${-prem*mult:,.0f}"),
                 ("Delta", f"{spec.get('delta','—')}"),
                 ("Theta / day", f"{spec.get('theta','—')}"),
                 ("IV", f"{spec.get('iv','—')}%")]
        for i, (k, v) in enumerate(facts):
            x = 0.02 + (i % 3) * 0.34; y = 0.74 - (i // 3) * 0.46
            axf.text(x, y, k, transform=axf.transAxes, fontsize=9.5, color=PAL["muted"])
            axf.text(x, y - 0.20, v, transform=axf.transAxes, fontsize=12, fontweight="bold", color=PAL["text"])
        return _save(fig, f"payoff_{sym}")
    except Exception:
        print("chart_renderer.payoff_card error:\n" + traceback.format_exc())
        return None


def selftest() -> dict:
    """Render one of each card with live-ish data. Returns {name: path|None}."""
    out = {}
    out["pick"] = pick_card({
        "symbol": "NVDA", "contract": "$205C 8/21", "tier": "T3", "is_bullish": True,
        "premium": 1_210_000, "voi": 14.2, "sweeps": 8, "blocks": 3, "dte": 66,
        "conviction": 7.2, "iv": 58,
        "what": "Fresh bullish call sweeps — new positioning, not closing. Volume >> open interest.",
        "play": "1-2% of account · exit 50-100% / cut at -50% · 0DTE = confirmation, not entry.",
    })
    import numpy as _np
    out["market"] = market_card({
        "title": "MARKET DASHBOARD",
        "tiles": [{"ticker": t, "price": p, "chg": ch, "series": list(_np.cumsum(_np.random.randn(20)) + 100)}
                  for t, p, ch in (("SPY", 755, 0.4), ("QQQ", 744, 0.9), ("VIX", 16.2, -8.4))],
        "regime": {"label": "RISK-ON", "score": 7, "color": PAL["up"]},
    })
    out["scorecard"] = scorecard_card({
        "book": {"val": 7758, "day_pl": 75},
        "best": {"sym": "NVDA", "move": 3.2, "series": list(_np.cumsum(_np.random.randn(20)) + 100)},
        "worst": {"sym": "MU", "move": -2.1, "series": list(_np.cumsum(_np.random.randn(20)) + 100)},
        "rows": [("NVDA $205C", 3.2, True), ("AMD $170C", 1.1, True), ("MU $90P", -2.1, False)],
    })
    return out


if __name__ == "__main__":
    import json
    import sys as _sys
    r = selftest()
    print(json.dumps({k: (v or "FAILED") for k, v in r.items()}, indent=2))
    # non-zero exit if any card failed → lets the healthcheck cron alert
    _sys.exit(0 if all(r.values()) else 1)
