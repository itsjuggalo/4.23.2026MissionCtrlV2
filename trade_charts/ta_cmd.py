#!/usr/bin/env python3
"""ta_cmd.py — on-demand technical analysis for the Discord /ta command (stocks, crypto, option contracts).

Deterministic: every number in the text is computed from the bars named on the source line. No LLM here
(the bot may add an optional AI read that is checked against `facts`). Advisory only; no size, no proven edge.

Price sources (market-data rule): stocks daily/weekly = Robinhood daily bars (Yahoo fallback, labelled);
stock intraday = Yahoo bars labelled "not Robinhood"; crypto = Coinbase Exchange candles (Kraken fallback);
option contract = the contract's own Robinhood bars. A missing input is reported UNAVAILABLE, never guessed.

CLI:  ~/.venv/bin/python ta_cmd.py NVDA [--tf 1d] [--strike 185 --expiry 2026-12-18 --cp call] [--no-chart]
"""
from __future__ import annotations

import warnings

warnings.filterwarnings("ignore")   # yfinance/pandas deprecation noise would flood the cron log

import argparse
import re
import subprocess
import sys
from datetime import datetime, timezone
from pathlib import Path
from zoneinfo import ZoneInfo

import numpy as np
import pandas as pd

HERE = Path(__file__).resolve().parent
sys.path.insert(0, str(HERE))
sys.path.insert(0, str(HERE.parent))
import lib  # noqa: E402,F401 — bind ~/scripts/lib now; MissionCtrl modules put pipeline/ (which has its own lib/) first on sys.path
MC = "/AIWorkWSL/web/missionctrl"
ET = ZoneInfo("America/New_York")
TFS = ("5m", "1h", "1d", "1w")
CRYPTO = {"BTC", "ETH", "SOL", "XRP", "DOGE", "ADA", "AVAX", "LINK", "LTC", "BCH", "DOT", "UNI", "AAVE", "XLM", "HBAR",
          "ALGO", "ATOM", "NEAR", "SUI", "APT", "ARB", "OP", "SHIB", "PEPE", "ZEC", "CRO", "ETC", "FIL", "ICP", "XTZ"}
UA = {"User-Agent": "mc-ta/1.0"}


class Unavailable(Exception):
    pass


def _et(ts) -> str:
    d = ts.to_pydatetime() if hasattr(ts, "to_pydatetime") else ts
    if d.tzinfo is None:
        d = d.replace(tzinfo=timezone.utc)
    return d.astimezone(ET).strftime("%m-%d %H:%M ET")


def _frame(rows: list[dict]) -> pd.DataFrame:
    df = pd.DataFrame(rows).set_index("t").sort_index()
    df.index = pd.DatetimeIndex(df.index)
    return df[["Open", "High", "Low", "Close", "Volume"]].astype(float)


# ── bars ──────────────────────────────────────────────────────────────────────
def crypto_bars(coin: str, tf: str) -> tuple[pd.DataFrame, str]:
    import requests
    gran = {"5m": 300, "1h": 3600, "1d": 86400, "1w": 86400}[tf]
    try:
        r = requests.get(f"https://api.exchange.coinbase.com/products/{coin}-USD/candles",
                         params={"granularity": gran}, headers=UA, timeout=15)
        rows = r.json() if r.status_code == 200 else []
        if isinstance(rows, list) and len(rows) >= 30:
            df = _frame([{"t": pd.Timestamp(x[0], unit="s", tz="UTC"), "Low": x[1], "High": x[2], "Open": x[3],
                          "Close": x[4], "Volume": x[5]} for x in rows])
            src = "Coinbase Exchange candles"
        else:
            raise ValueError(f"coinbase http {r.status_code}")
    except Exception as e:  # noqa: BLE001 — fall through to Kraken
        kr = {"5m": 5, "1h": 60, "1d": 1440, "1w": 1440}[tf]
        pair = ("XBT" if coin == "BTC" else coin) + "USD"
        try:
            j = requests.get("https://api.kraken.com/0/public/OHLC", params={"pair": pair, "interval": kr},
                             headers=UA, timeout=15).json()
            rows = next(v for k, v in (j.get("result") or {}).items() if k != "last")
            df = _frame([{"t": pd.Timestamp(int(x[0]), unit="s", tz="UTC"), "Open": x[1], "High": x[2], "Low": x[3],
                          "Close": x[4], "Volume": x[6]} for x in rows])
            src = "Kraken OHLC (Coinbase failed)"
        except Exception as e2:  # noqa: BLE001
            raise Unavailable(f"no crypto bars for {coin}-USD (Coinbase: {e}; Kraken: {type(e2).__name__})")
    if tf == "1w":
        df = df.resample("W-SUN").agg({"Open": "first", "High": "max", "Low": "min", "Close": "last",
                                       "Volume": "sum"}).dropna()
        src += ", daily bars grouped into weeks"
    return df, src


def last_session():
    """Most recent NYSE trading day whose regular close has passed (MissionCtrl market clock)."""
    from datetime import timedelta
    sys.path.append(f"{MC}/pipeline")
    from market_clock import clock
    now = datetime.now(timezone.utc)
    d = now.astimezone(ET).date()
    for _ in range(10):
        if clock.is_trading_day(d) and clock.session_close(d) <= now:
            return d
        d -= timedelta(days=1)
    return None


def stock_bars(sym: str, tf: str) -> tuple[pd.DataFrame, str]:
    if tf in ("1d", "1w"):
        df, src = None, ""
        try:
            sys.path.append(f"{MC}/pipeline/decision/lib")   # append: must not shadow ~/scripts/lib
            sys.path.append(f"{MC}/pipeline")
            import rh_bars
            r = rh_bars.daily(sym, ET)
            if r is not None and len(r[0]) >= 30:
                d = r[0]
                df = _frame([{"t": t, "Open": o, "High": h, "Low": lo, "Close": c, "Volume": v}
                             for t, o, h, lo, c, v in zip(d["t"], d["o"], d["h"], d["l"], d["c"], d["v"])])
                src = "Robinhood daily bars"
        except Exception:  # noqa: BLE001 — Yahoo fallback below
            df = None
        why = ""
        if df is not None:
            # Robinhood's daily series can sit a full session behind (seen 2026-11-10: SPY and the sector ETFs
            # ended 11-06 while NVDA had 11-09). A stale series is not used: fall back and say so.
            try:
                want = last_session()
                if want and df.index[-1].date() < want:
                    why = f"; Robinhood daily bars stopped at {df.index[-1]:%m-%d}, last session was {want:%m-%d}"
                    df = None
            except Exception as e:  # noqa: BLE001 — clock failed: keep the bars but say they were not checked
                src += f" (freshness not checked: {type(e).__name__})"
        if df is None:
            import chartlib
            try:
                df = chartlib.fetch(sym, period="2y", interval="1d")
            except Exception as e:  # noqa: BLE001
                raise Unavailable(f"no daily bars for {sym} (Robinhood and Yahoo both failed: {e})")
            src = f"Yahoo daily bars (not Robinhood{why})"
        if tf == "1w":
            df = df.resample("W-FRI").agg({"Open": "first", "High": "max", "Low": "min", "Close": "last",
                                           "Volume": "sum"}).dropna()
            src += ", grouped into weeks"
        return df, src
    import chartlib
    try:
        df = chartlib.fetch(sym, period="5d" if tf == "5m" else "60d", interval="5m" if tf == "5m" else "60m")
    except Exception as e:  # noqa: BLE001
        raise Unavailable(f"no {tf} bars for {sym} ({e})")
    return df, f"Yahoo {tf} bars (not Robinhood)"


def occ_symbol(root: str, expiry: str, cp: str, strike: float) -> str:
    d = datetime.strptime(expiry, "%Y-%m-%d")
    return f"{root.upper()}{d:%y%m%d}{'C' if cp.lower().startswith('c') else 'P'}{int(round(strike * 1000)):08d}"


def option_bars(occ: str, tf: str) -> tuple[pd.DataFrame, str]:
    from lib.rh_quote import rh_option_bars
    interval, span = ("5minute", "week") if tf in ("5m", "1h") else ("day", "year")
    r = rh_option_bars(occ, interval, span)
    if r.get("error") or len(r["bars"]) < 5:
        raise Unavailable(f"no traded bars for {occ} ({r.get('error') or 'fewer than 5 bars'})")
    df = _frame([{"t": pd.Timestamp(b["t"], unit="s", tz="UTC"), "Open": b["o"], "High": b["h"], "Low": b["l"],
                  "Close": b["c"], "Volume": 0.0} for b in r["bars"]])
    if tf == "1h":
        df = df.resample("60min").agg({"Open": "first", "High": "max", "Low": "min", "Close": "last",
                                       "Volume": "sum"}).dropna()
    elif tf == "1w":
        df = df.resample("W-FRI").agg({"Open": "first", "High": "max", "Low": "min", "Close": "last",
                                       "Volume": "sum"}).dropna()
    return df, f"{r['source']} ({interval} bars, as of {r['as_of_et']})"


# ── indicators ────────────────────────────────────────────────────────────────
def indicators(df: pd.DataFrame, intraday: bool) -> dict:
    import chartlib
    c = df["Close"]
    out = {"ema20": c.ewm(span=20, adjust=False).mean(), "ema50": c.ewm(span=50, adjust=False).mean(),
           "ema200": c.ewm(span=200, adjust=False).mean() if len(df) >= 200 else None,
           "rsi": chartlib._rsi(c)}
    macd = c.ewm(span=12, adjust=False).mean() - c.ewm(span=26, adjust=False).mean()
    out["macd"], out["signal"] = macd, macd.ewm(span=9, adjust=False).mean()
    out["hist"] = out["macd"] - out["signal"]
    pc = c.shift(1)
    tr = pd.concat([df["High"] - df["Low"], (df["High"] - pc).abs(), (df["Low"] - pc).abs()], axis=1).max(axis=1)
    out["atr"] = tr.ewm(alpha=1 / 14, adjust=False).mean()
    out["vwap"] = None
    if intraday and df["Volume"].sum() > 0:
        day = df.index.tz_convert(ET).date if df.index.tz is not None else df.index.date
        tp = (df["High"] + df["Low"] + df["Close"]) / 3
        out["vwap"] = (tp * df["Volume"]).groupby(day).cumsum() / df["Volume"].groupby(day).cumsum().replace(0, np.nan)
    return out


def _p(x: float) -> str:
    """Price text: 2 decimals above $1, more below (crypto pennies, cheap options)."""
    return f"{x:,.2f}" if abs(x) >= 1 else f"{x:.4f}"


def read_lines(df: pd.DataFrame, ind: dict) -> list[str]:
    import chartlib
    c = float(df["Close"].iloc[-1])
    e20, e50 = float(ind["ema20"].iloc[-1]), float(ind["ema50"].iloc[-1])
    trend = "UP (close > EMA20 > EMA50)" if c > e20 > e50 else "DOWN (close < EMA20 < EMA50)" if c < e20 < e50 \
        else "MIXED (close and EMAs not stacked)"
    emas = f"EMA20 {_p(e20)} · EMA50 {_p(e50)}"
    if ind["ema200"] is not None:
        e200 = float(ind["ema200"].iloc[-1])
        emas += f" · EMA200 {_p(e200)} (close is {'above' if c > e200 else 'below'})"
    else:
        emas += f" · EMA200 UNAVAILABLE (only {len(df)} bars, 200 needed)"
    rsi = float(ind["rsi"].iloc[-1])
    rs = "overbought (70+)" if rsi >= 70 else "oversold (30 or less)" if rsi <= 30 else "neutral"
    m, s, h = float(ind["macd"].iloc[-1]), float(ind["signal"].iloc[-1]), ind["hist"]
    hd = "rising" if float(h.iloc[-1]) > float(h.iloc[-2]) else "falling"
    atr = float(ind["atr"].iloc[-1])
    lines = [f"Trend: {trend}", emas,
             f"Momentum: RSI14 {rsi:.0f} ({rs}) · MACD {m:+.3f} vs signal {s:+.3f} "
             f"({'above' if m > s else 'below'} signal, histogram {hd})",
             f"Volatility: ATR14 {_p(atr)} ({atr / c * 100:.1f}% of price)"]
    if ind["vwap"] is not None and not np.isnan(ind["vwap"].iloc[-1]):
        v = float(ind["vwap"].iloc[-1])
        lines.append(f"VWAP (session) {_p(v)} · close is {'above' if c > v else 'below'}")
    vol = df["Volume"]
    if vol.sum() > 0 and len(vol) >= 21:
        avg = float(vol.iloc[-21:-1].mean())
        if avg > 0:
            lines.append(f"Volume: last bar {float(vol.iloc[-1]) / avg:.1f}× the 20-bar average")
    sr = chartlib.support_resistance(df, lookback=min(120, len(df)), k=6)
    sup, res = sorted((x for x in sr if x < c), reverse=True)[:2], sorted(x for x in sr if x > c)[:2]
    lines.append("Support: " + (" · ".join(_p(x) for x in sup) or "none found") + "  |  Resistance: "
                 + (" · ".join(_p(x) for x in res) or "none found") + " (swing-pivot clusters)")
    return lines


def render(df: pd.DataFrame, ind: dict, title: str, name: str, tf: str, max_bars: int = 140) -> str:
    import chartlib
    import matplotlib.pyplot as plt
    import mplfinance as mpf
    d = df.tail(max_bars)
    cut = lambda s: s.reindex(d.index)  # noqa: E731
    has_vol = bool(d["Volume"].sum() > 0)
    p_rsi, p_macd = (2, 3) if has_vol else (1, 2)
    aps = [mpf.make_addplot(cut(ind["ema20"]), color="#58a6ff", width=1.0),
           mpf.make_addplot(cut(ind["ema50"]), color="#d29922", width=1.0),
           mpf.make_addplot(cut(ind["rsi"]), panel=p_rsi, color="#bc8cff", width=1.0, ylabel="RSI"),
           mpf.make_addplot(cut(ind["macd"]), panel=p_macd, color="#58a6ff", width=0.9, ylabel="MACD"),
           mpf.make_addplot(cut(ind["signal"]), panel=p_macd, color="#d29922", width=0.9),
           mpf.make_addplot(cut(ind["hist"]), panel=p_macd, type="bar", color="#6e7681", alpha=0.6)]
    if ind["ema200"] is not None:
        aps.append(mpf.make_addplot(cut(ind["ema200"]), color="#f0883e", width=1.0))
    if ind["vwap"] is not None and cut(ind["vwap"]).notna().sum() > 2:
        aps.append(mpf.make_addplot(cut(ind["vwap"]), color="#e6edf3", width=0.8, linestyle="--"))
    sr = chartlib.support_resistance(df, lookback=min(120, len(df)), k=4)
    path = str(chartlib.OUT / f"tacmd_{re.sub(r'[^A-Za-z0-9]', '_', name)}_{tf}.png")
    kw = dict(type="candle", style=chartlib.STYLE, addplot=aps, volume=has_vol,
              panel_ratios=(6, 2, 2, 2) if has_vol else (6, 2, 2), figsize=(11, 9), title="\n" + title,
              savefig=dict(fname=path, dpi=120, bbox_inches="tight"), tight_layout=True, xrotation=0,
              datetime_format="%m/%d %H:%M" if tf in ("5m", "1h") else "%m/%d", show_nontrading=False)
    if sr:
        kw["hlines"] = dict(hlines=[float(x) for x in sr], colors=["#6e7681"] * len(sr), linestyle="--", linewidths=0.7)
    mpf.plot(d, **kw)
    plt.close("all")
    return path


# ── extra blocks ──────────────────────────────────────────────────────────────
def _intel(*args: str, timeout: int = 60) -> str:
    try:
        r = subprocess.run(["/home/itsju/.venv/bin/python", "-W", "ignore", "-m", "pipeline.intel.query", *args],
                           capture_output=True, text=True, timeout=timeout, cwd=MC)
        return (r.stdout or "").strip() if r.returncode == 0 else f"UNAVAILABLE (intel rc={r.returncode})"
    except Exception as e:  # noqa: BLE001
        return f"UNAVAILABLE ({type(e).__name__})"


def levels_block(sym: str) -> str:
    out = _intel("levels", sym)
    keep = [ln for ln in out.splitlines() if ln.startswith(("Entry:", sym + " ")) or "UNAVAILABLE" in ln][:3]
    return "Levels (levels.v1, computed, no size): " + (" | ".join(keep) if keep else "UNAVAILABLE")


def crypto_spot(coin: str) -> str:
    import requests
    try:
        j = requests.get(f"https://api.exchange.coinbase.com/products/{coin}-USD/ticker", headers=UA, timeout=10).json()
        t = datetime.fromisoformat(j["time"][:19] + "+00:00")
        return f"Spot {_p(float(j['price']))} (src Coinbase {_et(t)})"
    except Exception as e:  # noqa: BLE001
        return f"Spot UNAVAILABLE (Coinbase ticker: {type(e).__name__})"


def stock_spot(sym: str) -> str:
    try:
        from spotsrc import live_spot
        px, src = live_spot(sym)
        return f"Spot {_p(px)} ({src})" if px else src[0].upper() + src[1:]
    except Exception as e:  # noqa: BLE001
        return f"Spot UNAVAILABLE ({type(e).__name__})"


# ── entry point ───────────────────────────────────────────────────────────────
def analyze(symbol: str, tf: str = "1d", asset: str = "auto", strike: float | None = None,
            expiry: str | None = None, cp: str | None = None, chart: bool = True) -> dict:
    """→ {"ok", "text", "png" (or None), "facts"}. Never raises: a failure comes back as ok=False with the reason."""
    sym = re.sub(r"[^A-Z0-9.]", "", (symbol or "").upper().replace("-USD", "").replace("/USD", ""))
    if tf not in TFS:
        return {"ok": False, "text": f"Timeframe must be one of {', '.join(TFS)}.", "png": None, "facts": ""}
    if not sym:
        return {"ok": False, "text": "Give a ticker or coin.", "png": None, "facts": ""}
    contract = strike is not None and expiry and cp
    if asset == "auto":
        asset = "option" if (contract or strike or expiry) else "crypto" if sym in CRYPTO else "stock"
    extra: list[str] = []
    try:
        if asset == "crypto":
            df, src = crypto_bars(sym, tf)
            name, head, spot = f"{sym}-USD", f"{sym}-USD", crypto_spot(sym)
        elif asset == "option" and contract:
            try:
                occ = occ_symbol(sym, expiry, cp, float(strike))
            except ValueError:
                return {"ok": False, "text": "Expiry must look like 2026-12-18.", "png": None, "facts": ""}
            df, src = option_bars(occ, tf)
            name = occ
            head = f"{sym} {expiry} {strike:g}{'C' if cp.lower().startswith('c') else 'P'} premium"
            spot = "Underlying: " + stock_spot(sym)
            extra.append("This is the contract's own premium chart; indicators are on premium, not the stock. "
                         "Robinhood gives no volume for option bars.")
        else:
            df, src = stock_bars(sym, tf)
            name, head, spot = sym, sym, stock_spot(sym)
            if asset == "option":
                extra += ["No strike + expiry + call/put given, so this is the underlying with its options context:",
                          _intel("gex", sym), _intel("iv", sym)]
            if tf in ("1d", "1w"):
                extra.append(levels_block(sym))
    except Unavailable as e:
        return {"ok": False, "text": f"📈 **{sym}** {tf} — UNAVAILABLE: {e}", "png": None, "facts": ""}
    if len(df) < 30:
        return {"ok": False, "text": f"📈 **{name}** {tf} — UNAVAILABLE: only {len(df)} bars, 30 needed.",
                "png": None, "facts": ""}
    ind = indicators(df, intraday=tf in ("5m", "1h") and asset != "option")
    c, prev = float(df["Close"].iloc[-1]), float(df["Close"].iloc[-2])
    when = f"bar date {df.index[-1]:%m-%d}" if tf == "1d" else f"week ending {df.index[-1]:%m-%d}" if tf == "1w" else f"bar start {_et(df.index[-1])}"
    last = f"last bar close {_p(c)} ({(c / prev - 1) * 100:+.2f}% vs prior bar) · {when}"
    lines = [f"📈 **{head}** · {tf} · {last}", spot, *read_lines(df, ind), *[x for x in extra if x],
             f"_Source: {src} · {len(df)} bars · computed {datetime.now(ET):%m-%d %H:%M ET} · the newest bar may still be "
             "forming · no AI in these numbers. "
             "Advisory only, no proven edge, no size._"]
    text = "\n".join(lines)
    png = None
    if chart:
        try:
            png = render(df, ind, f"{head}  {tf}   {_p(c)}   RSI {float(ind['rsi'].iloc[-1]):.0f}", name, tf)
        except Exception as e:  # noqa: BLE001 — the text still stands without the picture
            text += f"\n_Chart render failed ({type(e).__name__}: {str(e)[:80]}); text above is complete._"
    return {"ok": True, "text": text, "png": png, "facts": text}


_NUM = re.compile(r"(?<![A-Za-z0-9.])\$?(\d[\d,]*\.\d+|\d{3,}[\d,]*)%?")


def unsupported_numbers(ai_text: str, facts: str) -> list[str]:
    """Numbers in an AI read that do not appear in the computed facts (decimals, or 3+ digit integers)."""
    have = {m.group(1).replace(",", "") for m in _NUM.finditer(facts)}
    seen, bad = set(), []
    for m in _NUM.finditer(ai_text):
        n = m.group(1).replace(",", "")
        if n not in have and n not in seen:
            seen.add(n)
            bad.append(m.group(1))
    return bad


if __name__ == "__main__":
    ap = argparse.ArgumentParser()
    ap.add_argument("symbol")
    ap.add_argument("--tf", default="1d", choices=TFS)
    ap.add_argument("--asset", default="auto", choices=("auto", "stock", "crypto", "option"))
    ap.add_argument("--strike", type=float)
    ap.add_argument("--expiry")
    ap.add_argument("--cp")
    ap.add_argument("--no-chart", action="store_true")
    a = ap.parse_args()
    r = analyze(a.symbol, a.tf, a.asset, a.strike, a.expiry, a.cp, chart=not a.no_chart)
    print(r["text"])
    print("png:", r["png"], "| chars:", len(r["text"]))
