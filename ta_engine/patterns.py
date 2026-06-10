"""Candlestick pattern detection (pure numpy, hand-rolled).

Detects the high-signal patterns the japanese-candlestick doctrine skill names:
doji, hammer, inverted-hammer, bullish/bearish engulfing, dark-cloud-cover, piercing.
Evaluates the most recent bar (+ the prior bar for 2-bar patterns) and returns a list
of {pattern, dir} where dir ∈ {bull, bear, neutral}.
"""
import numpy as np

DOJI_BODY_FRAC = 0.1   # body <= 10% of range
WICK_MULT = 2.0        # long wick >= 2x body


def _parts(o, h, l, c):
    body = abs(c - o)
    rng = h - l
    upper = h - max(o, c)
    lower = min(o, c) - l
    return body, rng, upper, lower


def detect_candles(opens, highs, lows, closes):
    o = np.asarray(opens, float)
    h = np.asarray(highs, float)
    l = np.asarray(lows, float)
    c = np.asarray(closes, float)
    if len(c) < 2:
        return []

    out = []
    # ── single-bar (latest) ────────────────────────────────────────────────
    o1, h1, l1, c1 = o[-1], h[-1], l[-1], c[-1]
    body, rng, upper, lower = _parts(o1, h1, l1, c1)
    if rng > 0:
        if body <= DOJI_BODY_FRAC * rng:
            out.append({"pattern": "doji", "dir": "neutral"})
        elif lower >= WICK_MULT * body and upper <= body:
            out.append({"pattern": "hammer", "dir": "bull"})
        elif upper >= WICK_MULT * body and lower <= body:
            out.append({"pattern": "inverted_hammer", "dir": "bull"})

    # ── two-bar (prev = -2, cur = -1) ───────────────────────────────────────
    o0, c0 = o[-2], c[-2]
    prev_bull = c0 > o0
    prev_bear = c0 < o0
    cur_bull = c1 > o1
    cur_bear = c1 < o1
    mid0 = (o0 + c0) / 2.0

    if prev_bear and cur_bull and o1 <= c0 and c1 >= o0:
        out.append({"pattern": "bullish_engulfing", "dir": "bull"})
    elif prev_bull and cur_bear and o1 >= c0 and c1 <= o0:
        out.append({"pattern": "bearish_engulfing", "dir": "bear"})

    # dark cloud cover (bear): prev strong bull, cur opens above prev close, closes into >50% of prev body
    if prev_bull and o1 > c0 and o0 < c1 < mid0:
        out.append({"pattern": "dark_cloud_cover", "dir": "bear"})
    # piercing line (bull): prev strong bear, cur opens below prev close, closes into >50% of prev body
    if prev_bear and o1 < c0 and mid0 < c1 < o0:
        out.append({"pattern": "piercing_line", "dir": "bull"})

    return out
