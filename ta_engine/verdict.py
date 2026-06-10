"""Compose indicators + patterns + SMC into a single TA verdict.

The verdict's TOP-LEVEL fields are the signal_scorer / signal_gatekeeper contract
(Layer 3 drop-in): trend, rsi, signal_type, factors, confidence, risk_reward,
direction. Plus engine-native fields: bull_bear_lean, ta_read, and full
indicators/patterns/levels blocks.

confidence is a directional alignment score: each TA factor votes +/-/0 for the
signal's intended direction; confidence = 50 + 50*net/total (100=fully aligned,
0=fully opposed, 50=neutral). risk_reward is a structural TA estimate on the
UNDERLYING (target = structural swing level, risk = nearest support/resistance or
1.5*ATR). The signal's own option RR (from buy/sell/stop) is reported separately as
signal_risk_reward — Layer 3 decides which to gate on.
"""
import numpy as np

from . import data, indicators as ind, patterns as pat, smc as smc_mod


# (weight, factor_key) — each factor votes +w (aligned) / -w (opposed) / 0 (neutral)
_WEIGHTS = {"trend": 2.0, "ema": 1.5, "rsi": 1.0, "macd": 1.5, "smc_structure": 1.5, "smc_event": 1.0, "candle": 1.0, "volume": 1.0}


def _vote_to_conf(votes):
    total = sum(_WEIGHTS.values())
    net = sum(_WEIGHTS[k] * v for k, v in votes.items())
    return int(round(max(0.0, min(100.0, 50 + 50 * net / total))))


def analyze(ticker, side="long", asset_type="option", strike=None, buy=None, stop=None, sell=None, period="1y"):
    """Return the TA verdict dict for `ticker`. side ∈ {long, short}."""
    side = side.lower()
    bull = side == "long"
    b = data.fetch_ohlcv(ticker, period=period)
    o, h, l, c, v = b["open"], b["high"], b["low"], b["close"], b["volume"]
    if len(c) < 60:
        return {"ticker": ticker.upper(), "error": f"insufficient data ({len(c)} bars)"}
    current = round(float(c[-1]), 2)

    # ── indicators ──────────────────────────────────────────────────────────
    ema20 = ind.ema(c, 20); ema50 = ind.ema(c, 50); sma200 = ind.sma(c, 200)
    rsi14 = ind.rsi(c, 14)
    macd = ind.macd(c)
    bb = ind.bollinger(c)
    atr14 = ind.atr(h, l, c)
    sr = ind.support_resistance(h, l, c)
    vol = ind.volume_analysis(v, c)
    trend_dir, trend_str = ind.trend_strength(c)

    candles = pat.detect_candles(o, h, l, c)
    structure = smc_mod.analyze_smc(o, h, l, c)

    # ── directional votes ───────────────────────────────────────────────────
    votes = {k: 0 for k in _WEIGHTS}
    factors = []

    ema_bull = (ema20 and ema50 and ema20 > ema50 and current > ema20)
    ema_bear = (ema20 and ema50 and ema20 < ema50 and current < ema20)
    if ema_bull:
        votes["ema"] = 1 if bull else -1
    elif ema_bear:
        votes["ema"] = -1 if bull else 1
    trend_bull = ema_bull or structure["structure"] == "bullish"
    trend_bear = ema_bear or structure["structure"] == "bearish"
    trend_label = "bullish" if (trend_bull and not trend_bear) else "bearish" if (trend_bear and not trend_bull) else "neutral"
    if trend_label == "bullish":
        votes["trend"] = 1 if bull else -1
    elif trend_label == "bearish":
        votes["trend"] = -1 if bull else 1
    if (bull and trend_label == "bullish") or (not bull and trend_label == "bearish"):
        factors.append("trend")

    if rsi14 is not None:
        if bull:
            votes["rsi"] = 1 if 50 <= rsi14 <= 70 else (-1 if rsi14 > 75 or rsi14 < 40 else 0)
        else:
            votes["rsi"] = 1 if 30 <= rsi14 <= 50 else (-1 if rsi14 < 25 or rsi14 > 60 else 0)

    macd_hist = macd["histogram"] if macd else None
    if macd_hist is not None:
        macd_bull = macd_hist > 0
        votes["macd"] = (1 if macd_bull else -1) if bull else (-1 if macd_bull else 1)
        if (bull and macd_bull) or (not bull and not macd_bull):
            factors.append("momentum")
    if "momentum" not in factors and rsi14 is not None and votes["rsi"] > 0:
        factors.append("momentum")

    if structure["structure"] == "bullish":
        votes["smc_structure"] = 1 if bull else -1
    elif structure["structure"] == "bearish":
        votes["smc_structure"] = -1 if bull else 1
    ev = structure["event"]
    if ev:
        ev_bull = "up" in ev
        votes["smc_event"] = (1 if ev_bull else -1) if bull else (-1 if ev_bull else 1)
    if votes["smc_structure"] > 0 or votes["smc_event"] > 0:
        factors.append("structure")

    cdir = next((p["dir"] for p in candles if p["dir"] in ("bull", "bear")), None)
    if cdir:
        c_bull = cdir == "bull"
        votes["candle"] = (1 if c_bull else -1) if bull else (-1 if c_bull else 1)
        if (bull and c_bull) or (not bull and not c_bull):
            factors.append("pattern")

    if vol["signal"] in ("BULLISH_SURGE", "BEARISH_SURGE") or vol["ratio"] >= 1.5:
        surge_bull = vol["signal"] == "BULLISH_SURGE" or (vol["ratio"] >= 1.5 and vol["signal"] != "BEARISH_SURGE")
        votes["volume"] = (1 if surge_bull else -1) if bull else (-1 if surge_bull else 1)
        if votes["volume"] > 0:
            factors.append("volume")

    confidence = _vote_to_conf(votes)

    # ── signal_type ─────────────────────────────────────────────────────────
    nearest_res = sr["resistances"][0] if sr["resistances"] else None
    nearest_sup = sr["supports"][-1] if sr["supports"] else None
    aligned_break = ev in (("BOS_up", "CHoCH_up") if bull else ("BOS_down", "CHoCH_down"))
    if aligned_break:
        signal_type = "breakout"
    elif bull and ema20 and current < ema20 and trend_label == "bullish":
        signal_type = "pullback"
    elif not bull and ema20 and current > ema20 and trend_label == "bearish":
        signal_type = "pullback"
    else:
        signal_type = "continuation"

    # ── risk_reward (structural, on the underlying) ─────────────────────────
    risk_reward = None
    risk_floor = 0.5 * atr14 if atr14 else 0.0  # a stop tighter than half an ATR is noise
    sh, sl = structure["last_swing_high"], structure["last_swing_low"]
    if bull:
        target = sh if (sh and sh > current) else nearest_res
        stop_lvl = max([x for x in [nearest_sup, (current - 1.5 * atr14) if atr14 else None] if x is not None], default=None)
        if target and stop_lvl:
            risk = max(current - stop_lvl, risk_floor)
            if risk > 0:
                risk_reward = min(round((target - current) / risk, 2), 10.0)
    else:
        target = sl if (sl and sl < current) else nearest_sup
        stop_lvl = min([x for x in [nearest_res, (current + 1.5 * atr14) if atr14 else None] if x is not None], default=None)
        if target and stop_lvl:
            risk = max(stop_lvl - current, risk_floor)
            if risk > 0:
                risk_reward = min(round((current - target) / risk, 2), 10.0)

    signal_rr = None
    try:
        buy_f, sell_f, stop_f = float(buy), float(sell), float(stop)
        if buy_f > stop_f and sell_f > buy_f:
            signal_rr = round((sell_f - buy_f) / (buy_f - stop_f), 2)
    except (TypeError, ValueError):
        pass

    lean = "bullish" if confidence >= 60 else "bearish" if confidence <= 40 else "neutral"
    if not bull:  # confidence is direction-aligned; lean is absolute market view
        lean = "bearish" if confidence >= 60 else "bullish" if confidence <= 40 else "neutral"

    # ── plain-language read ─────────────────────────────────────────────────
    bits = [f"{trend_label} trend" + (f" ({trend_str})" if trend_label != "neutral" and trend_str else "")]
    if ema20:
        bits.append(f"price {'above' if current > ema20 else 'below'} EMA20")
    if rsi14 is not None:
        bits.append(f"RSI {rsi14}")
    if macd_hist is not None:
        bits.append(f"MACD {'+' if macd_hist > 0 else '-'}")
    if ev:
        bits.append(ev)
    elif structure["structure"] != "neutral":
        bits.append(f"{structure['structure']} structure")
    if candles:
        bits.append("/".join(p["pattern"] for p in candles))
    tgt = nearest_res if bull else nearest_sup
    if tgt:
        bits.append(f"nearest {'resistance' if bull else 'support'} {tgt} ({round((tgt-current)/current*100,1)}%)")
    if atr14:
        bits.append(f"ATR {atr14}")
    ta_read = "; ".join(bits) + "."

    return {
        "ticker": ticker.upper(),
        "direction": side,
        "type": asset_type,
        "current": current,
        # ── gatekeeper/scorer contract ──
        "trend": trend_label,
        "rsi": rsi14,
        "signal_type": signal_type,
        "factors": factors,
        "confidence": confidence,
        "risk_reward": risk_reward,
        # ── engine-native ──
        "bull_bear_lean": lean,
        "signal_risk_reward": signal_rr,
        "ta_read": ta_read,
        "indicators": {
            "current": current, "ema20": ema20, "ema50": ema50, "sma200": sma200,
            "rsi14": rsi14, "macd": macd, "bollinger": bb, "atr14": atr14,
            "trend": {"direction": trend_dir, "strength": trend_str}, "volume": vol,
        },
        "patterns": {"candles": candles, "smc": structure},
        "levels": {
            "supports": sr["supports"], "resistances": sr["resistances"],
            "swing_high": sh, "swing_low": sl, "52wHigh": sr["52wHigh"], "52wLow": sr["52wLow"],
        },
        "votes": votes,
    }
