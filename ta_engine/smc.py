"""Smart Money Concepts structure (pure numpy, hand-rolled).

Matches the `smc` doctrine skill's vocabulary: market structure (BOS / CHoCH),
fair value gaps (FVG), order blocks (OB). Built on swing pivots from indicators.
swing_length default 10 (n=5 each side). A pragmatic Layer-2 implementation —
tuned further in later layers.
"""
import numpy as np

from .indicators import swing_points


def _structure(swh, swl):
    """Prevailing trend from the last two swing highs + last two swing lows."""
    if len(swh) >= 2 and len(swl) >= 2:
        hh = swh[-1]["price"] > swh[-2]["price"]
        hl = swl[-1]["price"] > swl[-2]["price"]
        lh = swh[-1]["price"] < swh[-2]["price"]
        ll = swl[-1]["price"] < swl[-2]["price"]
        if hh and hl:
            return "bullish"
        if lh and ll:
            return "bearish"
    return "neutral"


def _fvgs(o, h, l, c, lookback=40):
    """3-candle imbalances in the recent window; mark filled if price later re-entered."""
    n = len(c)
    start = max(2, n - lookback)
    out = []
    for i in range(start, n):
        # bullish FVG: gap between candle i-2 high and candle i low
        if l[i] > h[i - 2]:
            top, bottom = float(l[i]), float(h[i - 2])
            filled = bool(np.any(l[i + 1 :] <= top)) if i + 1 < n else False
            out.append({"type": "bullish", "top": round(top, 2), "bottom": round(bottom, 2), "filled": filled, "i": i})
        # bearish FVG: gap between candle i low and candle i-2 ... (high[i] < low[i-2])
        elif h[i] < l[i - 2]:
            top, bottom = float(l[i - 2]), float(h[i])
            filled = bool(np.any(h[i + 1 :] >= bottom)) if i + 1 < n else False
            out.append({"type": "bearish", "top": round(top, 2), "bottom": round(bottom, 2), "filled": filled, "i": i})
    return out


def _order_block(o, h, l, c, kind, lookback=30):
    """Bullish OB = last down-candle before an up-move; bearish OB = last up-candle before a down-move."""
    n = len(c)
    for i in range(n - 2, max(n - lookback - 2, 0), -1):
        if kind == "bull" and c[i] < o[i] and h[i + 1 :].max() > h[i]:
            return {"type": "bullish", "top": round(float(max(o[i], c[i])), 2), "bottom": round(float(l[i]), 2)}
        if kind == "bear" and c[i] > o[i] and l[i + 1 :].min() < l[i]:
            return {"type": "bearish", "top": round(float(h[i]), 2), "bottom": round(float(min(o[i], c[i])), 2)}
    return None


def analyze_smc(opens, highs, lows, closes, n=5):
    o = np.asarray(opens, float)
    h = np.asarray(highs, float)
    l = np.asarray(lows, float)
    c = np.asarray(closes, float)
    if len(c) < 2 * n + 3:
        return {"structure": "neutral", "event": None, "last_swing_high": None, "last_swing_low": None, "fvg": [], "order_block": None}

    sw = swing_points(h, l, n=n)
    swh, swl = sw["swing_highs"], sw["swing_lows"]
    structure = _structure(swh, swl)
    last_sh = swh[-1]["price"] if swh else None
    last_sl = swl[-1]["price"] if swl else None

    close = float(c[-1])
    event = None
    if last_sh is not None and close > last_sh:
        event = "BOS_up" if structure == "bullish" else "CHoCH_up"
    elif last_sl is not None and close < last_sl:
        event = "BOS_down" if structure == "bearish" else "CHoCH_down"

    ob_kind = "bull" if (structure == "bullish" or (event and "up" in event)) else "bear" if (structure == "bearish" or (event and "down" in event)) else "bull"
    order_block = _order_block(o, h, l, c, ob_kind)

    fvgs = _fvgs(o, h, l, c)
    unfilled = [f for f in fvgs if not f["filled"]]
    recent = (unfilled or fvgs)[-3:]

    return {
        "structure": structure,
        "event": event,
        "last_swing_high": last_sh,
        "last_swing_low": last_sl,
        "fvg": recent,
        "order_block": order_block,
    }
