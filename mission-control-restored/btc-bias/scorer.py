#!/usr/bin/env python3
"""
BTC Directional Bias Scorer
Fetches 7 free data sources and writes a scored JSON file every 4h.
Zero Anthropic API tokens used.

APIs used (all free, no key required):
  - Fear & Greed : alternative.me
  - Funding Rate : OKX (no geo-block)
  - MA / prices  : CoinGecko market_chart
  - 4H candles   : OKX
  - BTC Dominance: CoinGecko global
  - Volume flow  : CryptoCompare v2/histoday
  - DXY          : Yahoo Finance
"""
import json
import os
import sys
from datetime import datetime, timezone, timedelta

import requests
import numpy as np

OUTPUT_FILE = os.path.join(os.path.dirname(os.path.abspath(__file__)), "btc-bias.json")
TIMEOUT = 15


def safe_get(url: str, **kwargs) -> dict | list | None:
    try:
        r = requests.get(url, timeout=TIMEOUT, **kwargs)
        r.raise_for_status()
        return r.json()
    except Exception as e:
        print(f"  [WARN] GET {url[:80]} failed: {e}", file=sys.stderr)
        return None


def fmt(v) -> str:
    """Safe format for printing possibly-None values."""
    if v is None:
        return "N/A"
    if isinstance(v, float):
        return f"{v:,.2f}"
    return str(v)


# ─── Signal scorers ────────────────────────────────────────────────────────

def score_fear_greed() -> dict:
    """Extreme Fear=+2, Fear=+1, Neutral=0, Greed=-1, Extreme Greed=-2"""
    data = safe_get("https://api.alternative.me/fng/?limit=1")
    if not data:
        return {"value": "N/A", "index": None, "score": 0, "error": True}
    try:
        entry = data["data"][0]
        idx = int(entry["value"])
        label = entry["value_classification"]
        ll = label.lower()
        if "extreme fear" in ll:
            score = 2
        elif "fear" in ll:
            score = 1
        elif "extreme greed" in ll:
            score = -2
        elif "greed" in ll:
            score = -1
        else:
            score = 0
        return {"value": label, "index": idx, "score": score}
    except Exception as e:
        return {"value": "N/A", "index": None, "score": 0, "error": str(e)}


def score_funding_rate() -> dict:
    """
    OKX BTC-USDT-SWAP funding rate.
    < -0.01% = +2, -0.01–0% = +1, 0–0.01% = 0, 0.01–0.05% = -1, > 0.05% = -2
    """
    data = safe_get("https://www.okx.com/api/v5/public/funding-rate?instId=BTC-USDT-SWAP")
    if not data or not data.get("data"):
        return {"value": "N/A", "rate": None, "score": 0, "error": True}
    try:
        rate = float(data["data"][0]["fundingRate"])
        pct = rate * 100
        if pct < -0.01:
            score = 2
        elif pct < 0:
            score = 1
        elif pct < 0.01:
            score = 0
        elif pct < 0.05:
            score = -1
        else:
            score = -2
        return {"value": f"{pct:.4f}%", "rate": round(pct, 6), "score": score}
    except Exception as e:
        return {"value": "N/A", "rate": None, "score": 0, "error": str(e)}


def score_moving_averages() -> dict:
    """
    CoinGecko daily closes (200 days) → 20/50/200 SMA.
    Above all 3=+3, 2=+1, 1=-1, 0=-3
    """
    data = safe_get(
        "https://api.coingecko.com/api/v3/coins/bitcoin/market_chart",
        params={"vs_currency": "usd", "days": "200", "interval": "daily"}
    )
    if not data or "prices" not in data:
        return {"price": None, "sma20": None, "sma50": None, "sma200": None, "score": 0, "error": True}
    try:
        closes = np.array([p[1] for p in data["prices"]])
        if len(closes) < 50:
            return {"price": None, "sma20": None, "sma50": None, "sma200": None, "score": 0, "error": "not enough data"}
        price  = float(closes[-1])
        sma20  = float(np.mean(closes[-20:]))
        sma50  = float(np.mean(closes[-50:]))
        sma200 = float(np.mean(closes[-min(200, len(closes)):]))
        above = sum([price > sma20, price > sma50, price > sma200])
        score_map = {3: 3, 2: 1, 1: -1, 0: -3}
        return {
            "price":  round(price, 2),
            "sma20":  round(sma20, 2),
            "sma50":  round(sma50, 2),
            "sma200": round(sma200, 2),
            "above_count": above,
            "score": score_map[above],
        }
    except Exception as e:
        return {"price": None, "sma20": None, "sma50": None, "sma200": None, "score": 0, "error": str(e)}


def score_structure_4h() -> dict:
    """
    OKX 4H candles — last 3 highs and lows.
    HH+HL = +2, LH+LL = -2, mixed = 0
    OKX candle format: [ts, open, high, low, close, ...]
    """
    data = safe_get("https://www.okx.com/api/v5/market/candles?instId=BTC-USDT-SWAP&bar=4H&limit=20")
    if not data or not data.get("data") or len(data["data"]) < 6:
        return {"trend": "N/A", "score": 0, "error": True}
    try:
        candles = data["data"]  # newest first
        candles = list(reversed(candles))  # oldest first
        highs = [float(c[2]) for c in candles]
        lows  = [float(c[3]) for c in candles]

        h1, h2, h3 = highs[-3], highs[-2], highs[-1]
        l1, l2, l3 = lows[-3],  lows[-2],  lows[-1]

        hh = h3 > h2 > h1
        hl = l3 > l2 > l1
        lh = h3 < h2 < h1
        ll = l3 < l2 < l1

        if hh and hl:
            trend, score = "uptrend", 2
        elif lh and ll:
            trend, score = "downtrend", -2
        else:
            trend, score = "consolidation", 0

        return {
            "trend": trend,
            "highs": [round(h1, 2), round(h2, 2), round(h3, 2)],
            "lows":  [round(l1, 2), round(l2, 2), round(l3, 2)],
            "score": score,
        }
    except Exception as e:
        return {"trend": "N/A", "score": 0, "error": str(e)}


def score_btc_dominance() -> dict:
    """
    > 60% = -1 (risk off), 50-60% = 0, < 50% = +1 (risk on)
    """
    data = safe_get("https://api.coingecko.com/api/v3/global")
    if not data:
        return {"value": "N/A", "dominance": None, "score": 0, "error": True}
    try:
        dom = float(data["data"]["market_cap_percentage"]["btc"])
        if dom > 60:
            score = -1
        elif dom < 50:
            score = 1
        else:
            score = 0
        return {"value": f"{dom:.1f}%", "dominance": round(dom, 2), "score": score}
    except Exception as e:
        return {"value": "N/A", "dominance": None, "score": 0, "error": str(e)}


def score_volume_flow() -> dict:
    """
    CryptoCompare daily volume — today vs 30d avg.
    Above avg = +1, below = -1
    """
    data = safe_get(
        "https://min-api.cryptocompare.com/data/v2/histoday",
        params={"fsym": "BTC", "tsym": "USD", "limit": 30}
    )
    if not data or "Data" not in data:
        return {"vs_average": "N/A", "score": 0, "error": True}
    try:
        days = data["Data"]["Data"]
        volumes = [float(d["volumeto"]) for d in days if d.get("volumeto")]
        if len(volumes) < 5:
            return {"vs_average": "N/A", "score": 0, "error": "not enough data"}
        avg_30d   = float(np.mean(volumes[:-1]))
        today_vol = float(volumes[-1])
        pct_diff  = ((today_vol - avg_30d) / avg_30d) * 100
        score = 1 if today_vol > avg_30d else -1
        sign = "+" if pct_diff >= 0 else ""
        return {
            "vs_average": f"{sign}{pct_diff:.1f}%",
            "today":  round(today_vol, 0),
            "avg30d": round(avg_30d, 0),
            "score":  score,
        }
    except Exception as e:
        return {"vs_average": "N/A", "score": 0, "error": str(e)}


def score_dxy() -> dict:
    """
    Yahoo Finance DXY. Falling = +1 (bullish BTC), Rising = -1, Flat = 0
    """
    data = safe_get(
        "https://query1.finance.yahoo.com/v8/finance/chart/DX-Y.NYB",
        params={"interval": "1d", "range": "10d"},
        headers={"User-Agent": "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36"}
    )
    if not data:
        return {"value": None, "trend": "N/A", "score": 0, "error": True}
    try:
        closes_raw = data["chart"]["result"][0]["indicators"]["quote"][0]["close"]
        closes = [c for c in closes_raw if c is not None]
        if len(closes) < 5:
            return {"value": None, "trend": "N/A", "score": 0, "error": "insufficient data"}
        last_close  = closes[-1]
        avg5_prev   = float(np.mean(closes[-6:-1]))
        if last_close < avg5_prev * 0.9995:
            trend, score = "falling", 1
        elif last_close > avg5_prev * 1.0005:
            trend, score = "rising", -1
        else:
            trend, score = "flat", 0
        return {
            "value":  round(last_close, 3),
            "avg5d":  round(avg5_prev, 3),
            "trend":  trend,
            "score":  score,
        }
    except Exception as e:
        return {"value": None, "trend": "N/A", "score": 0, "error": str(e)}


# ─── Bias label ─────────────────────────────────────────────────────────────

def get_bias(score: int) -> str:
    if score >= 6:   return "STRONGLY BULLISH"
    if score >= 3:   return "BULLISH"
    if score >= 1:   return "SLIGHTLY BULLISH"
    if score >= -1:  return "NEUTRAL"
    if score >= -3:  return "SLIGHTLY BEARISH"
    if score >= -5:  return "BEARISH"
    return "STRONGLY BEARISH"


# ─── Main ───────────────────────────────────────────────────────────────────

def main():
    now = datetime.now(timezone.utc)
    next_update = now + timedelta(hours=4)

    print(f"[{now.strftime('%Y-%m-%d %H:%M UTC')}] BTC Bias Scorer starting...")
    print()

    print("  [1/7] Fetching Fear & Greed Index...")
    fg = score_fear_greed()
    print(f"        → {fg.get('value')} (index: {fg.get('index')}) | score: {fg['score']:+d}")

    print("  [2/7] Fetching Funding Rate (OKX)...")
    fr = score_funding_rate()
    print(f"        → {fr.get('value')} | score: {fr['score']:+d}")

    print("  [3/7] Fetching Moving Averages (CoinGecko 200d)...")
    ma = score_moving_averages()
    print(f"        → price ${fmt(ma.get('price'))} | SMA20 ${fmt(ma.get('sma20'))} | SMA50 ${fmt(ma.get('sma50'))} | SMA200 ${fmt(ma.get('sma200'))} | score: {ma['score']:+d}")

    print("  [4/7] Fetching 4H Structure (OKX)...")
    s4h = score_structure_4h()
    print(f"        → {s4h.get('trend')} | score: {s4h['score']:+d}")

    print("  [5/7] Fetching BTC Dominance (CoinGecko)...")
    dom = score_btc_dominance()
    print(f"        → {dom.get('value')} | score: {dom['score']:+d}")

    print("  [6/7] Fetching Volume Flow (CryptoCompare)...")
    vol = score_volume_flow()
    print(f"        → vs 30d avg: {vol.get('vs_average')} | score: {vol['score']:+d}")

    print("  [7/7] Fetching DXY (Yahoo Finance)...")
    dxy = score_dxy()
    print(f"        → DXY {fmt(dxy.get('value'))} trend={dxy.get('trend')} | score: {dxy['score']:+d}")

    total = sum([fg["score"], fr["score"], ma["score"], s4h["score"], dom["score"], vol["score"], dxy["score"]])
    bias  = get_bias(total)

    print()
    print("  ══════════════════════════════════")
    print(f"  TOTAL SCORE : {total:+d} / 13")
    print(f"  BIAS        : {bias}")
    print("  ══════════════════════════════════")
    print()

    result = {
        "timestamp":   now.isoformat(),
        "score":       total,
        "max_score":   13,
        "bias":        bias,
        "signals": {
            "fear_greed":      fg,
            "funding_rate":    fr,
            "moving_averages": ma,
            "structure_4h":    s4h,
            "btc_dominance":   dom,
            "volume_flow":     vol,
            "dxy":             dxy,
        },
        "next_update": next_update.isoformat(),
    }

    with open(OUTPUT_FILE, "w") as f:
        json.dump(result, f, indent=2, default=str)

    print(f"  ✅ Written to: {OUTPUT_FILE}")


if __name__ == "__main__":
    main()
