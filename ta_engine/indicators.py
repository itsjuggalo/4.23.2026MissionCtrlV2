"""Pure-numpy technical indicators.

Lifted/cleaned from the seed ~/scripts/ta_engine.py, plus ATR(14) and swing-pivot
detection (new — feed risk_reward and the SMC module). All functions take numpy
arrays (or lists) and return JSON-friendly scalars/dicts. No pandas, no TA-Lib —
runs identically on the laptop and Oracle.
"""
import numpy as np


def _arr(x):
    return np.asarray(x, dtype=float)


def ema_series(x, period):
    """Full EMA series (NaN-padded before the seed). Seed = SMA of first `period`."""
    x = _arr(x)
    out = np.full(len(x), np.nan)
    if len(x) < period:
        return out
    k = 2.0 / (period + 1)
    prev = float(x[:period].mean())
    out[period - 1] = prev
    for i in range(period, len(x)):
        prev = x[i] * k + prev * (1 - k)
        out[i] = prev
    return out


def ema(x, period):
    s = ema_series(x, period)
    v = s[-1]
    return None if np.isnan(v) else round(float(v), 4)


def sma(x, period):
    x = _arr(x)
    if len(x) < period:
        return None
    return round(float(x[-period:].mean()), 4)


def rsi(closes, period=14):
    """Wilder's RSI."""
    c = _arr(closes)
    if len(c) < period + 1:
        return None
    d = np.diff(c)
    gains = np.where(d > 0, d, 0.0)
    losses = np.where(d < 0, -d, 0.0)
    ag = gains[:period].mean()
    al = losses[:period].mean()
    for i in range(period, len(d)):
        ag = (ag * (period - 1) + gains[i]) / period
        al = (al * (period - 1) + losses[i]) / period
    if al == 0:
        return 100.0
    rs = ag / al
    return round(100 - 100 / (1 + rs), 2)


def macd(closes, fast=12, slow=26, signal=9):
    """MACD = EMA(fast) - EMA(slow); signal = EMA(signal) of the MACD line."""
    c = _arr(closes)
    ef = ema_series(c, fast)
    es = ema_series(c, slow)
    line = ef - es
    valid = line[~np.isnan(line)]
    if len(valid) < signal:
        return None
    sig_series = ema_series(valid, signal)
    sig = sig_series[-1]
    line_v = float(line[-1])
    if np.isnan(line_v):
        return None
    sig_v = None if np.isnan(sig) else float(sig)
    return {
        "line": round(line_v, 4),
        "signal": round(sig_v, 4) if sig_v is not None else None,
        "histogram": round(line_v - sig_v, 4) if sig_v is not None else None,
    }


def bollinger(closes, period=20, std_dev=2.0):
    c = _arr(closes)
    if len(c) < period:
        return None
    recent = c[-period:]
    mid = float(recent.mean())
    sd = float(recent.std())  # population std (ddof=0), matches TA-Lib BBANDS
    return {"mid": round(mid, 2), "upper": round(mid + std_dev * sd, 2), "lower": round(mid - std_dev * sd, 2)}


def atr(highs, lows, closes, period=14):
    """Wilder's ATR. Seed ATR = SMA of first `period` true ranges."""
    h, l, c = _arr(highs), _arr(lows), _arr(closes)
    if len(c) < period + 1:
        return None
    prev_close = c[:-1]
    tr = np.maximum(h[1:] - l[1:], np.maximum(np.abs(h[1:] - prev_close), np.abs(l[1:] - prev_close)))
    a = float(tr[:period].mean())
    for i in range(period, len(tr)):
        a = (a * (period - 1) + tr[i]) / period
    return round(a, 4)


def swing_points(highs, lows, n=5):
    """Fractal pivots: a swing high is the strict window-max over [i-n, i+n] (center bar);
    swing low symmetric. n=5 -> 11-bar window (~SMC swing_length 10). Returns indices+prices,
    oldest-first. Used for SMC structure and for risk_reward levels.
    """
    h, l = _arr(highs), _arr(lows)
    N = len(h)
    sh, sl = [], []
    for i in range(n, N - n):
        wh = h[i - n : i + n + 1]
        wl = l[i - n : i + n + 1]
        if wh.argmax() == n and (wh == wh.max()).sum() == 1:
            sh.append({"i": i, "price": round(float(h[i]), 2)})
        if wl.argmin() == n and (wl == wl.min()).sum() == 1:
            sl.append({"i": i, "price": round(float(l[i]), 2)})
    return {"swing_highs": sh, "swing_lows": sl}


def support_resistance(highs, lows, closes, lookback=20):
    """Pivot-based S/R relative to current price + 52w extremes (lifted from seed)."""
    h, l, c = _arr(highs), _arr(lows), _arr(closes)
    current = float(c[-1])
    levels = sorted(
        set(
            [
                round(float(np.max(h[-lookback:])), 2),
                round(float(np.min(l[-lookback:])), 2),
                round(float(np.mean(c[-lookback:])), 2),
                round(float(np.percentile(c[-lookback:], 75)), 2),
                round(float(np.percentile(c[-lookback:], 25)), 2),
            ]
        )
    )
    supports = [x for x in levels if x < current]
    resistances = [x for x in levels if x > current]
    return {
        "supports": supports[-3:],
        "resistances": resistances[:3],
        "52wHigh": round(float(np.max(h[-252:])) if len(h) >= 252 else float(np.max(h)), 2),
        "52wLow": round(float(np.min(l[-252:])) if len(l) >= 252 else float(np.min(l)), 2),
    }


def trend_strength(closes, short=10, long=50):
    """SMA-cross trend label + strength bucket (lifted from seed)."""
    c = _arr(closes)
    s = sma(c, short)
    l = sma(c, long)
    if s is None or l is None:
        return None, None
    direction = "UPTREND" if s > l else "DOWNTREND"
    pct = abs((s - l) / l * 100)
    strength = "STRONG" if pct > 3 else "MODERATE" if pct > 1 else "WEAK"
    return direction, strength


def volume_analysis(volumes, closes):
    v = _arr(volumes)
    c = _arr(closes)
    avg = float(v[-20:].mean()) if len(v) >= 20 else float(v.mean())
    cur = float(v[-1])
    ratio = cur / avg if avg > 0 else 1.0
    chg = (c[-1] - c[-2]) / c[-2] * 100 if len(c) >= 2 else 0.0
    sig = "NORMAL"
    if ratio > 2 and chg > 1:
        sig = "BULLISH_SURGE"
    elif ratio > 2 and chg < -1:
        sig = "BEARISH_SURGE"
    elif ratio < 0.5:
        sig = "LOW_VOLUME"
    return {"current": int(cur), "avg20": int(avg), "ratio": round(ratio, 2), "signal": sig}
