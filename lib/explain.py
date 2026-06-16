#!/usr/bin/env python3
"""explain.py — turn a raw option-flow alert into novice-friendly language + a
chart_renderer.pick_card spec. Deterministic (no LLM): mirrors the BetaBot
"what this means / how to play it" content, generated from our own flow fields.

Public:
    tier(alert)            'T1'|'T2'|'T3'  (size/aggression)
    conviction(alert)      0-10 float
    what_this_means(alert) plain-English read
    how_to_play(alert)     sizing + exit doctrine ($800 / equity-fraction)
    contract_label(alert)  'NVDA $205C 8/21'
    card_spec(alert, iv)   dict ready for chart_renderer.pick_card
"""
from __future__ import annotations

import math
from datetime import datetime, timezone
from zoneinfo import ZoneInfo

ET = ZoneInfo("America/New_York")


def _f(a, *keys, default=0.0):
    for k in keys:
        v = a.get(k)
        if v not in (None, ""):
            try:
                return float(v)
            except (TypeError, ValueError):
                pass
    return default


def _is_call(a) -> bool:
    return str(a.get("OptionType", a.get("type", ""))).upper().startswith("C")


def _is_bullish(a) -> bool:
    if "isBullish" in a:
        return bool(a.get("isBullish"))
    return _is_call(a)


def voi(a) -> float:
    vol = _f(a, "Volume", "volume")
    oi = _f(a, "OI", "oi", default=1) or 1
    return vol / oi if oi else 0.0


def tier(a) -> str:
    fv = _f(a, "totalFlowValue", "flowValue", "Value")
    sw = _f(a, "SWEEPS", "sweeps")
    if fv >= 5_000_000 or (fv >= 2_000_000 and sw >= 10):
        return "T3"
    if fv >= 1_500_000:
        return "T2"
    return "T1"


def conviction(a) -> float:
    """0-10 risk-adjusted setup quality from flow size, freshness, aggression, DTE."""
    fv = _f(a, "totalFlowValue", "flowValue", "Value")
    sw = _f(a, "SWEEPS", "sweeps")
    bl = _f(a, "BLOCKS", "blocks")
    dte = _f(a, "DTE", "dte")
    v = voi(a)
    s = 0.0
    s += max(0.0, min(6.0, (math.log10(max(fv, 1)) - 4) * 2))   # $10k→0 … $10M→4 … $100M→6
    s += 1.5 if v >= 2 else (0.5 if v >= 1 else 0.0)             # fresh positioning
    s += min(1.5, (sw + bl) * 0.08)                              # aggression / repetition
    s += 1.0 if 7 <= dte <= 120 else (-1.0 if dte <= 1 else 0.0)  # swing window vs 0DTE lotto
    return round(max(0.0, min(10.0, s)), 1)


def contract_label(a) -> str:
    sym = str(a.get("Symbol", a.get("symbol", "?"))).upper()
    strike = _f(a, "Strike", "strike")
    cp = "C" if _is_call(a) else "P"
    try:
        exp = datetime.fromtimestamp(int(_f(a, "Expiry", "exp")), tz=timezone.utc).astimezone(ET).strftime("%-m/%-d")
    except Exception:
        exp = ""
    return f"{sym} ${strike:g}{cp} {exp}".strip()


def what_this_means(a) -> str:
    bull = _is_bullish(a)
    call = _is_call(a)
    v = voi(a)
    sw = int(_f(a, "SWEEPS", "sweeps"))
    bl = int(_f(a, "BLOCKS", "blocks"))
    dte = int(_f(a, "DTE", "dte"))
    fv = _f(a, "totalFlowValue", "flowValue", "Value")
    side = "bullish" if bull else "bearish"
    instrument = "calls" if call else "puts"
    fresh = ("new positioning (volume >> open interest)" if v >= 2
             else "adding to an existing position" if v < 1
             else "building a position")
    how = ("aggressive sweeps — buyers paying up across exchanges" if sw >= bl and sw
           else "negotiated blocks — larger, less urgent" if bl else "mixed order flow")
    urgency = ("0DTE — same-day, treat as a directional tell, not a swing" if dte <= 1
               else f"{dte}-day — a swing-able window" if dte <= 120
               else f"{dte}-day — long-dated / likely a hedge or LEAP")
    size = (f"${fv/1e6:.1f}M" if fv >= 1e6 else f"${fv/1e3:.0f}K")
    return (f"{size} of {side} {instrument} — {fresh}. {how.capitalize()}. {urgency}.")


def how_to_play(a, iv=None) -> str:
    bull = _is_bullish(a)
    dte = int(_f(a, "DTE", "dte"))
    bits = ["Size 1-2% of equity (max $800 risk)"]
    if dte <= 1:
        bits.append("0DTE = confirmation, not an entry")
    bits.append("exit 50-100% / cut at -50%")
    if iv is not None:
        try:
            if float(iv) >= 70:
                bits.append("IV is rich → prefer a spread over a naked long")
        except (TypeError, ValueError):
            pass
    if not bull:
        bits.append("bearish: respect it as a hedge signal on your longs")
    return " · ".join(bits)


def card_spec(a, iv=None) -> dict:
    """Build the dict chart_renderer.pick_card expects. `iv` = 0-100 IV rank (optional)."""
    return {
        "symbol": str(a.get("Symbol", a.get("symbol", "?"))).upper(),
        "contract": contract_label(a),
        "tier": tier(a),
        "is_bullish": _is_bullish(a),
        "premium": _f(a, "totalFlowValue", "flowValue", "Value"),
        "voi": round(voi(a), 1),
        "sweeps": int(_f(a, "SWEEPS", "sweeps")),
        "blocks": int(_f(a, "BLOCKS", "blocks")),
        "dte": int(_f(a, "DTE", "dte")),
        "spot": _f(a, "Spot", "spot") or None,
        "conviction": conviction(a),
        "iv": iv,
        "what": what_this_means(a),
        "play": how_to_play(a, iv),
        "days": 45,
    }


if __name__ == "__main__":
    import json
    sample = {"Symbol": "NVDA", "Strike": 205, "OptionType": "CALL", "Expiry": 1755748800,
              "DTE": 66, "totalFlowValue": 1_210_000, "Volume": 9715, "OI": 685,
              "SWEEPS": 8, "BLOCKS": 3, "isBullish": True}
    print(json.dumps(card_spec(sample, iv=58), indent=2))
