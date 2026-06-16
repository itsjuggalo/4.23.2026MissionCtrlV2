#!/usr/bin/env python3
"""regime.py — lightweight market-regime read (VIX + SPY trend + BTC).

A cheap, honest heuristic the command-center embed and the bot's sidebar presence
both consume so they speak one language: RISK-ON / NEUTRAL / RISK-OFF. Not a
forecast — just "what kind of tape is this right now" so flow gets the right
benchmark. yfinance under the hood, 90s file cache so the 2-3 min loops don't
hammer it. Never raises; returns a NEUTRAL stub on any failure.

  regime() -> {state, emoji, label, vix, spy_chg, spy_slope, btc_chg, line}
"""
from __future__ import annotations

import json
import time
from pathlib import Path

CACHE = Path("/tmp/mc_regime_cache.json")
TTL = 90  # seconds


def _stub() -> dict:
    return {"state": "NEUTRAL", "emoji": "🟡", "label": "NEUTRAL",
            "vix": None, "spy_chg": None, "spy_slope": None, "btc_chg": None,
            "line": "Regime: NEUTRAL (no data)"}


def _compute() -> dict:
    import yfinance as yf

    def _chg(sym, period="2d", interval="1d"):
        h = yf.Ticker(sym).history(period=period, interval=interval)
        if len(h) < 2:
            return None, None
        prev = float(h["Close"].iloc[-2])
        last = float(h["Close"].iloc[-1])
        return last, ((last - prev) / prev * 100 if prev else 0.0)

    # SPY: intraday last for change, 10d daily for slope
    spy_last, spy_chg = _chg("SPY")
    try:
        i = yf.Ticker("SPY").history(period="1d", interval="5m")
        if len(i):
            spy_last = float(i["Close"].iloc[-1])
        d = yf.Ticker("SPY").history(period="10d", interval="1d")["Close"]
        spy_slope = (float(d.iloc[-1]) - float(d.iloc[0])) / float(d.iloc[0]) * 100 if len(d) >= 2 else 0.0
        if spy_chg is None and len(d) >= 2:
            spy_chg = (float(d.iloc[-1]) - float(d.iloc[-2])) / float(d.iloc[-2]) * 100
    except Exception:
        spy_slope = 0.0

    vix_last, _ = _chg("^VIX")
    _, btc_chg = _chg("BTC-USD")

    # ── classify ──
    vix = vix_last if vix_last is not None else 17.0
    sc = spy_chg if spy_chg is not None else 0.0
    sl = spy_slope if spy_slope is not None else 0.0

    score = 0
    score += 1 if vix < 16 else (-1 if vix > 22 else 0)
    score += 1 if sc > 0.2 else (-1 if sc < -0.8 else 0)
    score += 1 if sl > 0.5 else (-1 if sl < -1.5 else 0)

    if score >= 2:
        state, emoji, label = "RISK-ON", "🟢", "RISK-ON"
    elif score <= -2:
        state, emoji, label = "RISK-OFF", "🔴", "RISK-OFF"
    else:
        state, emoji, label = "NEUTRAL", "🟡", "NEUTRAL"

    bits = []
    if spy_last is not None:
        bits.append(f"SPY {spy_last:,.0f} ({sc:+.1f}%)")
    if vix_last is not None:
        bits.append(f"VIX {vix_last:.1f}")
    if btc_chg is not None:
        bits.append(f"BTC {btc_chg:+.1f}%")
    line = f"{label} · " + " · ".join(bits) if bits else f"{label}"

    return {"state": state, "emoji": emoji, "label": label,
            "vix": round(vix_last, 1) if vix_last is not None else None,
            "spy_chg": round(sc, 2), "spy_slope": round(sl, 2),
            "btc_chg": round(btc_chg, 2) if btc_chg is not None else None,
            "line": line}


def regime(force: bool = False) -> dict:
    if not force:
        try:
            c = json.loads(CACHE.read_text())
            if time.time() - c.get("_ts", 0) < TTL:
                return c["data"]
        except Exception:
            pass
    try:
        data = _compute()
    except Exception:
        data = _stub()
    try:
        CACHE.write_text(json.dumps({"_ts": time.time(), "data": data}))
    except Exception:
        pass
    return data


if __name__ == "__main__":
    print(json.dumps(regime(force=True), indent=2))
