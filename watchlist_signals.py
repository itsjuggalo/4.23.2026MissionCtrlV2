#!/usr/bin/env python3
"""Watchlist Signals — capytrade-style systematic engine.

You bring the tickers (data/watchlist-tickers.json, editable from the page).
The engine scores each across 6 indicators (EMA20/50, RSI14, MACD, ATR14, ADX14)
into SWING signals (daily bars, ATR-based stop, R-target, ⭐ hi-conviction) and
DAY signals (1-min momentum, confidence + edge). Writes data/watchlist-signals.json
which the MissionCtrl "Watchlist Signals" page reads.

Read-only / recommendation surface. Auto-execution is a SEPARATE env-gated path
(watchlist_exec.py, OFF by default) — this engine never places orders.

Usage:  watchlist_signals.py [swing|day|all]   (default all)
"""
import json, sys, time
from pathlib import Path

REPO = Path("/AIWorkWSL/web/missionctrl")
WL_FILE = REPO / "data" / "watchlist-tickers.json"
OUT = REPO / "data" / "watchlist-signals.json"
DEFAULT_WL = ["SPY", "QQQ", "NVDA", "TSLA", "AAPL", "AMD", "PLTR", "COIN", "MSTR", "META", "MSFT", "AMZN"]

# capytrade spec
ATR_STOP_MULT = 0.25      # stop distance = 0.25 x ATR
R_STD, R_HICONV = 4.5, 5.5
HICONV_SCORE = 8.0        # >= this (of 10) flags ⭐ hi-conviction (their "score >= 60")
MAX_SWING = 25            # cap rows


def load_watchlist():
    for p in (WL_FILE, OUT):
        try:
            j = json.load(open(p))
            wl = j.get("tickers") or j.get("watchlist")
            if wl:
                return [t.upper() for t in wl]
        except Exception:
            pass
    return DEFAULT_WL


def _indicators(df):
    """Return latest EMA20/50, RSI14, MACD hist, ATR14, ADX14 from an OHLCV df."""
    import pandas as pd
    close, high, low = df["Close"].astype(float), df["High"].astype(float), df["Low"].astype(float)
    ema20 = close.ewm(span=20, adjust=False).mean().iloc[-1]
    ema50 = close.ewm(span=50, adjust=False).mean().iloc[-1]
    # RSI14 Wilder
    d = close.diff()
    gain = d.clip(lower=0).ewm(alpha=1/14, adjust=False).mean().iloc[-1]
    loss = (-d.clip(upper=0)).ewm(alpha=1/14, adjust=False).mean().iloc[-1]
    rsi = 100.0 if loss == 0 else 100 - 100 / (1 + gain / loss)
    # MACD 12/26/9 histogram
    macd = close.ewm(span=12, adjust=False).mean() - close.ewm(span=26, adjust=False).mean()
    hist = (macd - macd.ewm(span=9, adjust=False).mean()).iloc[-1]
    # ATR14 Wilder
    pc = close.shift(1)
    tr = pd.concat([(high - low), (high - pc).abs(), (low - pc).abs()], axis=1).max(axis=1)
    atr = tr.ewm(alpha=1/14, adjust=False).mean().iloc[-1]
    # ADX14
    up, dn = high.diff(), -low.diff()
    plus_dm = ((up > dn) & (up > 0)) * up
    minus_dm = ((dn > up) & (dn > 0)) * dn
    atr_s = tr.ewm(alpha=1/14, adjust=False).mean()
    plus_di = 100 * plus_dm.ewm(alpha=1/14, adjust=False).mean() / atr_s
    minus_di = 100 * minus_dm.ewm(alpha=1/14, adjust=False).mean() / atr_s
    dx = 100 * (plus_di - minus_di).abs() / (plus_di + minus_di).replace(0, 1e-9)
    adx = dx.ewm(alpha=1/14, adjust=False).mean().iloc[-1]
    return {"last": float(close.iloc[-1]), "ema20": float(ema20), "ema50": float(ema50),
            "rsi": float(rsi), "macd_hist": float(hist), "atr": float(atr), "adx": float(adx),
            "plus_di": float(plus_di.iloc[-1]), "minus_di": float(minus_di.iloc[-1])}


def score_swing(ind):
    """6-indicator confluence → (score 0-10, dir). Long/short by trend alignment."""
    last, e20, e50 = ind["last"], ind["ema20"], ind["ema50"]
    bull = e20 >= e50  # primary trend
    direction = "LONG" if bull else "SHORT"
    pts = 0.0
    # trend stack (EMA20 vs 50, price vs EMA20) — 3 pts
    if bull:
        pts += 1.5 if e20 > e50 else 0
        pts += 1.5 if last > e20 else 0
    else:
        pts += 1.5 if e20 < e50 else 0
        pts += 1.5 if last < e20 else 0
    # MACD histogram agrees — 2 pts
    if (ind["macd_hist"] > 0) == bull:
        pts += 2.0
    # RSI momentum in trend direction (not exhausted) — 2 pts
    rsi = ind["rsi"]
    if bull and 45 <= rsi <= 75: pts += 2.0
    elif (not bull) and 25 <= rsi <= 55: pts += 2.0
    elif (bull and rsi > 75) or ((not bull) and rsi < 25): pts += 0.5  # extended
    # ADX trend strength — 2 pts (DI must agree with direction)
    adx = ind["adx"]
    di_ok = (ind["plus_di"] > ind["minus_di"]) == bull
    if di_ok:
        pts += 2.0 if adx >= 30 else 1.2 if adx >= 20 else 0.4
    # ATR sanity (tradeable volatility) — 1 pt
    if ind["atr"] > 0 and last > 0 and (ind["atr"] / last) <= 0.12:
        pts += 1.0
    return round(min(10.0, pts), 1), direction


def swing_signals(tickers):
    import yfinance as yf
    out = []
    for t in tickers:
        try:
            df = yf.Ticker(t).history(period="120d", interval="1d").dropna()
            if len(df) < 50:
                continue
            ind = _indicators(df)
            score, direction = score_swing(ind)
            if score < 5.0:
                continue  # only fire qualifying setups (capytrade: "math checks out")
            hiconv = score >= HICONV_SCORE
            rtgt = R_HICONV if hiconv else R_STD
            stop_dist = ATR_STOP_MULT * ind["atr"]
            entry = round(ind["last"], 2)
            if direction == "LONG":
                stop = round(entry - stop_dist, 2); target = round(entry + rtgt * stop_dist, 2)
            else:
                stop = round(entry + stop_dist, 2); target = round(entry - rtgt * stop_dist, 2)
            out.append({"symbol": t, "dir": direction, "score": score, "entry": entry,
                        "stop": stop, "target": target, "rTarget": rtgt, "hiConv": hiconv})
        except Exception as e:
            print(f"  swing {t}: {e}", file=sys.stderr)
    out.sort(key=lambda r: r["score"], reverse=True)
    return out[:MAX_SWING]


def day_signals(tickers):
    """1-min momentum read → conf(0-100) + edge%. Status=WATCHING (no positions; auto-exec off)."""
    import yfinance as yf
    out = []
    for t in tickers:
        try:
            df = yf.Ticker(t).history(period="2d", interval="1m").dropna()
            if len(df) < 60:
                continue
            ind = _indicators(df)  # indicators on 1-min bars
            last, e20 = ind["last"], ind["ema20"]
            bull = ind["macd_hist"] > 0 and last >= e20
            direction = "LONG" if bull else "SHORT"
            # confidence: blend of trend + ADX + MACD strength → 0-100
            conf = 0
            conf += 30 if (last >= e20) == bull else 0
            conf += 25 if (ind["macd_hist"] > 0) == bull else 0
            conf += min(25, ind["adx"]) if ind["adx"] else 0
            rsi = ind["rsi"]
            conf += 20 if (bull and 45 <= rsi <= 80) or ((not bull) and 20 <= rsi <= 55) else 0
            conf = int(min(100, conf))
            if conf < 55:
                continue
            # edge%: recent 15-min momentum magnitude
            recent = df["Close"].astype(float)
            edge = abs(round((recent.iloc[-1] / recent.iloc[-15] - 1) * 100, 2)) if len(recent) >= 15 else 0.0
            stop_pct = 0.45 if t in ("SPY", "QQQ", "DIA", "IWM") else 0.70
            out.append({"symbol": t, "dir": direction, "conf": conf, "edge": edge,
                        "entry": round(last, 2), "stopPct": stop_pct, "status": "WATCHING"})
        except Exception as e:
            print(f"  day {t}: {e}", file=sys.stderr)
    out.sort(key=lambda r: r["conf"], reverse=True)
    return out


def main():
    mode = sys.argv[1] if len(sys.argv) > 1 else "all"
    wl = load_watchlist()
    prev = {}
    try: prev = json.load(open(OUT))
    except Exception: pass
    swing = swing_signals(wl) if mode in ("swing", "all") else prev.get("swing", [])
    day = day_signals(wl) if mode in ("day", "all") else prev.get("day", [])
    auto = (Path.home() / ".openclaw" / "workspace" / "state" / "watchlist_exec_ARMED").exists()
    OUT.write_text(json.dumps({
        "watchlist": wl, "swing": swing, "day": day,
        "execLog": prev.get("execLog", []),
        "mode": {"swingDrop": "3:10 PM ET", "dayFlat": "3:45 PM ET", "autoExec": auto},
    }))
    print(f"WROTE {OUT} — {len(swing)} swing, {len(day)} day signals (autoExec={auto})")


if __name__ == "__main__":
    main()
