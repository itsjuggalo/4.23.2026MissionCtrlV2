#!/usr/bin/env python3
"""
chartlib.py — shared chart rendering for the Mission Control Discord trade-chart suite.

Pure rendering + data helpers (no Discord posting here — callers use lib.ops_card).
Dark theme to match Discord. yfinance for OHLCV. matplotlib/mplfinance for plots.
"""
from __future__ import annotations
import os, math, datetime as dt
from pathlib import Path
import numpy as np
import pandas as pd
import matplotlib
matplotlib.use("Agg")
import matplotlib.pyplot as plt
import mplfinance as mpf
import yfinance as yf

OUT = Path.home() / ".openclaw/workspace/charts"
OUT.mkdir(parents=True, exist_ok=True)

# dark theme matching Discord
_MC = mpf.make_marketcolors(up="#3fb950", down="#f85149", edge="inherit",
                            wick="inherit", volume={"up": "#1f6f33", "down": "#7d2620"})
STYLE = mpf.make_mpf_style(base_mpf_style="nightclouds", marketcolors=_MC,
                           facecolor="#0d1117", edgecolor="#30363d",
                           figcolor="#0d1117", gridcolor="#21262d",
                           rc={"axes.labelcolor": "#c9d1d9", "xtick.color": "#8b949e",
                               "ytick.color": "#8b949e", "text.color": "#c9d1d9",
                               "axes.titlecolor": "#e6edf3"})


def fetch(ticker: str, period="6mo", interval="1d") -> pd.DataFrame:
    df = yf.Ticker(ticker).history(period=period, interval=interval, auto_adjust=False)
    if df.empty:
        raise ValueError(f"no data for {ticker}")
    return df[["Open", "High", "Low", "Close", "Volume"]].dropna()


def _rsi(close: pd.Series, n=14) -> pd.Series:
    d = close.diff()
    up = d.clip(lower=0).ewm(alpha=1/n, adjust=False).mean()
    dn = (-d.clip(upper=0)).ewm(alpha=1/n, adjust=False).mean()
    rs = up / dn.replace(0, np.nan)
    return (100 - 100/(1+rs)).fillna(50)


def support_resistance(df: pd.DataFrame, lookback=60, k=3):
    """Crude S/R: cluster recent swing highs/lows."""
    recent = df.tail(lookback)
    levels = []
    hi, lo = recent["High"], recent["Low"]
    for i in range(2, len(recent)-2):
        if hi.iloc[i] == hi.iloc[i-2:i+3].max(): levels.append(hi.iloc[i])
        if lo.iloc[i] == lo.iloc[i-2:i+3].min(): levels.append(lo.iloc[i])
    if not levels:
        return []
    levels = sorted(levels)
    merged, span = [], (recent["High"].max() - recent["Low"].min()) * 0.02
    for lv in levels:
        if merged and abs(lv - merged[-1]) < span:
            merged[-1] = (merged[-1] + lv) / 2
        else:
            merged.append(lv)
    cur = df["Close"].iloc[-1]
    merged.sort(key=lambda x: abs(x - cur))
    return merged[:k]


def render_ta(ticker: str, flows: list[dict] | None = None, period="6mo") -> str:
    """Candlestick + EMA20/50 + volume + RSI panel + S/R + flow-strike annotations → PNG path."""
    df = fetch(ticker, period=period)
    ema20 = df["Close"].ewm(span=20, adjust=False).mean()
    ema50 = df["Close"].ewm(span=50, adjust=False).mean()
    rsi = _rsi(df["Close"])
    sr = support_resistance(df)
    cur = df["Close"].iloc[-1]
    prev = df["Close"].iloc[-2]
    chg = (cur/prev - 1) * 100

    aps = [
        mpf.make_addplot(ema20, color="#58a6ff", width=1.0),
        mpf.make_addplot(ema50, color="#d29922", width=1.0),
        mpf.make_addplot(rsi, panel=2, color="#bc8cff", width=1.0, ylabel="RSI"),
    ]
    hlines = dict(hlines=[round(x, 2) for x in sr], colors=["#6e7681"]*len(sr),
                  linestyle="--", linewidths=0.7) if sr else None
    # flow strikes as extra horizontal lines (call=green, put=red)
    if flows:
        fl = [f["Strike"] for f in flows if f.get("Strike")]
        if fl:
            cols = ["#3fb950" if f.get("OptionType") == "CALL" else "#f85149"
                    for f in flows if f.get("Strike")]
            if hlines:
                hlines["hlines"] += fl; hlines["colors"] += cols
                hlines["linestyle"] = "-"  # mplfinance single style; flows solid-ish
            else:
                hlines = dict(hlines=fl, colors=cols, linestyle="-", linewidths=1.1)

    title = f"\n{ticker}   ${cur:,.2f}  ({chg:+.2f}%)   RSI {rsi.iloc[-1]:.0f}"
    path = str(OUT / f"ta_{ticker}.png")
    kw = dict(type="candle", style=STYLE, addplot=aps, volume=True, panel_ratios=(6, 2, 2),
              figsize=(11, 8), title=title, savefig=dict(fname=path, dpi=120, bbox_inches="tight"),
              tight_layout=True, xrotation=0, datetime_format="%m/%d")
    if hlines: kw["hlines"] = hlines
    mpf.plot(df, **kw)
    plt.close("all")
    return path


if __name__ == "__main__":
    import sys
    t = sys.argv[1] if len(sys.argv) > 1 else "SPY"
    p = render_ta(t)
    print("rendered", p, os.path.getsize(p), "bytes")
