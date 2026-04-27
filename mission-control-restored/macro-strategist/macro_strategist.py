#!/usr/bin/env python3
"""
Macro Strategist — Soros-style macro vision.
Reads the full macro environment every 4 hours and sets the
team's overall stance: STRONG RISK-ON / RISK-ON / NEUTRAL /
RISK-OFF / CRISIS.

Outputs macro_state.json which the Risk Manager reads to
adjust position size modifiers.
"""
import asyncio
import json
import logging
import os
import sys
import time
from datetime import datetime, timezone

import aiohttp
import numpy as np
import pandas as pd
import requests
import yfinance as yf
import sys as _sys
_sys.path.insert(0, os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
from dotenv import load_dotenv
from shared.archiver import maybe_rotate

# ── Config ────────────────────────────────────────────────────────────────────

load_dotenv(os.path.join(os.path.dirname(os.path.abspath(__file__)), ".env"))

_DIR          = os.path.dirname(os.path.abspath(__file__))
BTC_BIAS_FILE = os.path.join(os.path.dirname(_DIR), "btc-bias", "btc-bias.json")
STATE_FILE    = os.path.join(_DIR, "macro_state.json")

OUTLOOK_URL   = os.getenv("DISCORD_MACRO_OUTLOOK_WEBHOOK", "")
ALERTS_URL    = os.getenv("DISCORD_MACRO_ALERTS_WEBHOOK",  "")
ARCHIVE_URL   = os.getenv("DISCORD_ARCHIVE_MACRO_WEBHOOK", "")

MAX_HISTORY   = 10
YF_DELAY      = 1.0  # seconds between Yahoo Finance calls

logging.basicConfig(
    level=logging.INFO,
    format="%(asctime)s [MACRO] %(message)s",
    datefmt="%Y-%m-%d %H:%M:%S",
    stream=sys.stdout,
)
log = logging.getLogger("macro")


# ── Helpers ───────────────────────────────────────────────────────────────────

def load_json(path: str, default):
    if os.path.exists(path):
        try:
            with open(path) as f:
                return json.load(f)
        except Exception as e:
            log.warning(f"Failed to load {path}: {e}")
    return default


def save_json(path: str, data) -> None:
    with open(path, "w") as f:
        json.dump(data, f, indent=2, default=str)


def fetch_yf(ticker: str, period: str = "60d", interval: str = "1d",
             retries: int = 2) -> pd.DataFrame | None:
    """Fetch Yahoo Finance data with retries. Returns None on failure."""
    for attempt in range(retries + 1):
        try:
            df = yf.Ticker(ticker).history(period=period, interval=interval)
            if not df.empty:
                df = df.rename(columns={"Open":"open","High":"high","Low":"low",
                                        "Close":"close","Volume":"vol"})
                return df[["open","high","low","close","vol"] if "vol" in df.columns
                          else ["open","high","low","close"]].dropna()
        except Exception as e:
            if attempt < retries:
                time.sleep(2)
            else:
                log.warning(f"yfinance {ticker} failed after {retries+1} attempts: {e}")
    return None


def ema(series: pd.Series, span: int) -> float | None:
    if len(series) < span:
        return None
    return float(series.ewm(span=span, adjust=False).mean().iloc[-1])


def sma(series: pd.Series, window: int) -> float | None:
    if len(series) < window:
        return None
    return float(series.rolling(window).mean().iloc[-1])


def pct_change_n(series: pd.Series, n: int = 5) -> float | None:
    if len(series) < n + 1:
        return None
    old = float(series.iloc[-(n+1)])
    new = float(series.iloc[-1])
    if old == 0:
        return None
    return round((new - old) / old * 100, 3)


# ── Indicator Fetchers ────────────────────────────────────────────────────────

def fetch_btc_bias() -> dict:
    """Read existing btc-bias-scorer output."""
    data = load_json(BTC_BIAS_FILE, None)
    if not data:
        log.warning("btc-bias.json not found — scoring 0")
        return {"score": 0, "bias": "UNKNOWN", "source": "btc-bias-scorer", "error": True}

    raw_score = int(data.get("score", 0))
    bias      = data.get("bias", "UNKNOWN")

    # The btc-bias scorer uses a ±13 scale. We normalise to ±4 for macro weighting.
    # ≥ +6 → +2, +3 to +5 → +1, -2 to +2 → 0, -5 to -3 → -1, ≤ -6 → -2
    if raw_score >= 6:
        macro_score = 2
    elif raw_score >= 3:
        macro_score = 1
    elif raw_score >= -2:
        macro_score = 0
    elif raw_score >= -5:
        macro_score = -1
    else:
        macro_score = -2

    return {
        "raw_score": raw_score,
        "bias":      bias,
        "score":     macro_score,
        "source":    "btc-bias-scorer",
        "timestamp": data.get("timestamp"),
    }


def fetch_dxy() -> dict:
    """DXY trend vs 20/50 SMA. Score: +2 to -2."""
    log.info("  Fetching DXY...")
    df = fetch_yf("DX-Y.NYB", period="60d")
    time.sleep(YF_DELAY)
    if df is None or len(df) < 20:
        return {"value": None, "trend": "unknown", "score": 0, "stale": True}

    price  = round(float(df["close"].iloc[-1]), 3)
    sma20  = sma(df["close"], 20)
    sma50  = sma(df["close"], 50)
    chg5   = pct_change_n(df["close"], 5)

    falling = chg5 is not None and chg5 < -0.1
    rising  = chg5 is not None and chg5 > 0.1

    below_both = (sma20 and price < sma20) and (sma50 and price < sma50)
    above_both = (sma20 and price > sma20) and (sma50 and price > sma50)

    if falling and below_both:
        score, trend = 2, "falling below both SMAs"
    elif falling:
        score, trend = 1, "falling"
    elif rising and above_both:
        score, trend = -2, "rising above both SMAs"
    elif rising:
        score, trend = -1, "rising"
    else:
        score, trend = 0, "flat"

    vs_sma20 = "below" if (sma20 and price < sma20) else "above"
    return {
        "value":   price,
        "trend":   trend,
        "sma20":   round(sma20, 3) if sma20 else None,
        "sma50":   round(sma50, 3) if sma50 else None,
        "vs_sma20": vs_sma20,
        "chg5d":   chg5,
        "score":   score,
    }


def fetch_vix() -> dict:
    """VIX level. Score: +2 to -2."""
    log.info("  Fetching VIX...")
    df = fetch_yf("^VIX", period="5d")
    time.sleep(YF_DELAY)
    if df is None or df.empty:
        return {"value": None, "level": "unknown", "score": 0, "stale": True}

    value = round(float(df["close"].iloc[-1]), 2)
    prev  = round(float(df["close"].iloc[-2]), 2) if len(df) >= 2 else value

    if value < 15:
        level, score = "low fear — risk-on", 2
    elif value < 20:
        level, score = "normal", 0
    elif value < 30:
        level, score = "elevated fear", -1
    else:
        level, score = "panic — risk-off", -2

    return {"value": value, "prev": prev, "level": level, "score": score}


def fetch_sp500() -> dict:
    """S&P 500 trend vs EMAs/SMA. Score: -2 to +2."""
    log.info("  Fetching S&P 500...")
    df = fetch_yf("^GSPC", period="300d")
    time.sleep(YF_DELAY)
    if df is None or len(df) < 20:
        return {"price": None, "trend": "unknown", "score": 0, "stale": True}

    price  = round(float(df["close"].iloc[-1]), 2)
    ema20  = ema(df["close"], 20)
    ema50  = ema(df["close"], 50)
    sma200 = sma(df["close"], 200)
    chg5   = pct_change_n(df["close"], 5)

    above_ema20  = ema20  and price > ema20
    above_ema50  = ema50  and price > ema50
    above_sma200 = sma200 and price > sma200
    above_count  = sum([bool(above_ema20), bool(above_ema50), bool(above_sma200)])

    if above_count == 3:
        score, trend = 2, "above all MAs — strong bull"
    elif above_sma200:
        score, trend = 1, "above 200 SMA — moderate bull"
    elif above_count == 0:
        score, trend = -2, "below all MAs — bear"
    else:
        score, trend = 0, "mixed — transitioning"

    return {
        "price":   price,
        "ema20":   round(ema20, 2)  if ema20  else None,
        "ema50":   round(ema50, 2)  if ema50  else None,
        "sma200":  round(sma200, 2) if sma200 else None,
        "trend":   trend,
        "chg5d":   chg5,
        "score":   score,
    }


def fetch_us10y() -> dict:
    """10-Year Treasury yield trend. Score: -1 to +1."""
    log.info("  Fetching US 10Y yield...")
    df = fetch_yf("^TNX", period="30d")
    time.sleep(YF_DELAY)
    if df is None or len(df) < 5:
        return {"value": None, "trend": "unknown", "score": 0, "stale": True}

    value  = round(float(df["close"].iloc[-1]), 3)
    chg10  = pct_change_n(df["close"], 10)

    if chg10 is not None and chg10 < -3.0:
        trend, score = "falling sharply — easing", 1
    elif chg10 is not None and chg10 < -0.5:
        trend, score = "falling", 1
    elif chg10 is not None and chg10 > 3.0:
        trend, score = "rising sharply — tightening", -1
    elif chg10 is not None and chg10 > 0.5:
        trend, score = "rising", -1
    else:
        trend, score = "stable", 0

    return {"value": value, "chg10d_pct": chg10, "trend": trend, "score": score}


def fetch_crypto_mcap(prev_mcap: float | None) -> dict:
    """CoinGecko total market cap trend. Score: -1 to +1."""
    log.info("  Fetching crypto market cap...")
    try:
        r = requests.get("https://api.coingecko.com/api/v3/global", timeout=12)
        r.raise_for_status()
        data = r.json()
        mcap = float(data["data"]["total_market_cap"]["usd"])
    except Exception as e:
        log.warning(f"CoinGecko global failed: {e}")
        return {"mcap": prev_mcap, "trend": "unknown", "score": 0, "stale": True}

    if prev_mcap is None:
        trend, score = "unknown (first run)", 0
    else:
        chg = (mcap - prev_mcap) / prev_mcap * 100
        if chg > 1.0:
            trend, score = f"rising ({chg:+.1f}%)", 1
        elif chg < -1.0:
            trend, score = f"falling ({chg:+.1f}%)", -1
        else:
            trend, score = f"flat ({chg:+.1f}%)", 0

    return {"mcap": round(mcap, 0), "prev_mcap": prev_mcap, "trend": trend, "score": score}


def fetch_fed_expectations() -> dict:
    """2-Year yield as Fed expectations proxy. Score: -1 to +1."""
    log.info("  Fetching 2Y yield (Fed proxy)...")
    # ^IRX is 13-week T-bill; use 2YY=F for actual 2Y futures
    df = fetch_yf("^IRX", period="30d")
    time.sleep(YF_DELAY)
    if df is None or len(df) < 5:
        # Fallback to 2Y note futures
        df = fetch_yf("2YY=F", period="30d")
        time.sleep(YF_DELAY)
    if df is None or len(df) < 5:
        return {"value": None, "two_year_trend": "unknown", "score": 0, "stale": True}

    value  = round(float(df["close"].iloc[-1]), 3)
    chg10  = pct_change_n(df["close"], 10)

    if chg10 is not None and chg10 < -1.0:
        trend, score = "falling — cuts priced in", 1
    elif chg10 is not None and chg10 > 1.0:
        trend, score = "rising — hikes priced in", -1
    else:
        trend, score = "stable", 0

    return {"value": value, "chg10d_pct": chg10, "two_year_trend": trend, "score": score}


def fetch_sector_rotation() -> dict:
    """
    Compare XLK (tech/growth) vs XLU+XLP (defensive) 5-day performance.
    Score: +1 risk-on, -1 risk-off, 0 mixed.
    """
    log.info("  Fetching sector rotation (ETFs)...")
    etfs   = {"XLK": None, "XLF": None, "XLE": None, "XLU": None, "XLP": None}
    perf   = {}

    for ticker in etfs:
        df = fetch_yf(ticker, period="10d")
        time.sleep(YF_DELAY)
        if df is not None and len(df) >= 5:
            chg = pct_change_n(df["close"], 5)
            perf[ticker] = round(chg, 3) if chg is not None else 0.0
        else:
            perf[ticker] = None

    # Require at least XLK and one defensive
    if perf.get("XLK") is None and perf.get("XLU") is None:
        return {"leader": "unknown", "type": "unknown", "perf": perf, "score": 0, "stale": True}

    growth_avg   = sum(v for k, v in perf.items()
                       if k in ("XLK","XLF") and v is not None) / \
                   max(1, sum(1 for k in ("XLK","XLF") if perf.get(k) is not None))
    defensive_avg = sum(v for k, v in perf.items()
                        if k in ("XLU","XLP") and v is not None) / \
                    max(1, sum(1 for k in ("XLU","XLP") if perf.get(k) is not None))

    valid = {k: v for k, v in perf.items() if v is not None}
    leader = max(valid, key=lambda k: valid[k]) if valid else "unknown"

    if growth_avg > defensive_avg + 0.3:
        rot_type, score = "risk-on", 1
    elif defensive_avg > growth_avg + 0.3:
        rot_type, score = "risk-off", -1
    else:
        rot_type, score = "neutral", 0

    return {
        "leader":         leader,
        "type":           rot_type,
        "growth_avg_5d":  round(growth_avg, 3),
        "defensive_avg_5d": round(defensive_avg, 3),
        "perf":           perf,
        "score":          score,
    }


# ── Regime Classification ─────────────────────────────────────────────────────

REGIME_MAP = [
    (7,   float("inf"), "STRONG RISK-ON", 1.25),
    (3,   6,            "RISK-ON",        1.0),
    (-2,  2,            "NEUTRAL",        0.75),
    (-6, -3,            "RISK-OFF",       0.5),
    (float("-inf"), -7, "CRISIS",         0.25),
]


def classify_regime(score: int) -> tuple[str, float]:
    for lo, hi, label, modifier in REGIME_MAP:
        if lo <= score <= hi:
            return label, modifier
    return "NEUTRAL", 0.75


def regime_emoji(regime: str) -> str:
    return {
        "STRONG RISK-ON": "🟢",
        "RISK-ON":        "🟡",
        "NEUTRAL":        "🟠",
        "RISK-OFF":       "🔴",
        "CRISIS":         "🚨",
    }.get(regime, "⚪")


# ── Alert Detection ───────────────────────────────────────────────────────────

def detect_alerts(current: dict, previous: dict | None) -> list[str]:
    alerts = []
    if not previous:
        return alerts

    # Regime change
    if previous.get("regime") and current["regime"] != previous["regime"]:
        alerts.append(f"Regime change: {previous['regime']} → {current['regime']}")

    # VIX spike above 25
    vix_now  = current["indicators"].get("vix", {}).get("value")
    vix_prev = previous.get("indicators", {}).get("vix", {}).get("value")
    if vix_now and vix_prev and vix_now > 25 and vix_prev <= 25:
        alerts.append(f"VIX spiked from {vix_prev} to {vix_now} — elevated fear")

    # DXY >1% move in a day
    dxy_chg = current["indicators"].get("dxy", {}).get("chg5d")
    dxy_prev_chg = previous.get("indicators", {}).get("dxy", {}).get("chg5d")
    if dxy_chg is not None and abs(dxy_chg) > 1.0:
        direction = "surging" if dxy_chg > 0 else "collapsing"
        alerts.append(f"DXY {direction} — 5d change {dxy_chg:+.2f}%")

    # Indicator direction flips
    for key in ("dxy", "us10y", "fed_expectations"):
        cur_trend  = current["indicators"].get(key, {}).get("trend", "")
        prev_trend = previous.get("indicators", {}).get(key, {}).get("trend", "")
        if cur_trend and prev_trend and cur_trend != prev_trend and \
                "unknown" not in (cur_trend, prev_trend) and "stale" not in (cur_trend, prev_trend):
            alerts.append(f"{key.upper()} direction change: '{prev_trend}' → '{cur_trend}'")

    return alerts


# ── Recommendation Text ───────────────────────────────────────────────────────

def build_recommendation(regime: str, indicators: dict, alerts: list) -> str:
    btc_bias = indicators.get("btc_bias", {}).get("bias", "?")
    dxy_trend = indicators.get("dxy", {}).get("trend", "")
    vix_val   = indicators.get("vix", {}).get("value", 0) or 0
    sp_trend  = indicators.get("sp500", {}).get("trend", "")

    base = {
        "STRONG RISK-ON": "Full position sizes. Favor high-conviction longs across crypto and tech. Macro tailwinds are strong.",
        "RISK-ON":        "Normal positioning. Favor long setups in crypto and growth sectors.",
        "NEUTRAL":        "Reduce position sizes by 25%. Be selective — only highest-conviction setups.",
        "RISK-OFF":       "Defensive stance. Half position sizes. Prefer shorts or cash over new longs.",
        "CRISIS":         "Minimal exposure. Quarter-size only. Preserve capital — no new longs.",
    }.get(regime, "Monitor closely.")

    extras = []
    if "falling" in dxy_trend:
        extras.append("DXY weakness supports risk assets.")
    elif "rising" in dxy_trend:
        extras.append("DXY strength is a headwind — watch for risk-off pressure.")
    if vix_val > 25:
        extras.append(f"VIX at {vix_val} — heightened volatility, size down.")
    if btc_bias in ("BEARISH", "STRONGLY BEARISH") and "RISK-ON" in regime:
        extras.append("BTC bias bearish — macro divergence, watch closely.")
    if btc_bias in ("BULLISH", "STRONGLY BULLISH") and "RISK-OFF" in regime:
        extras.append("BTC showing relative strength despite macro weakness — divergence signal.")

    return " ".join([base] + extras)


# ── Discord ───────────────────────────────────────────────────────────────────

def score_icon(score: int) -> str:
    if score > 0: return "✅"
    if score < 0: return "❌"
    return "➖"


async def post_discord(session: aiohttp.ClientSession, url: str, payload: dict) -> None:
    if not url:
        return
    try:
        async with session.post(url, json=payload,
                                timeout=aiohttp.ClientTimeout(total=10)) as resp:
            if resp.status not in (200, 204):
                body = await resp.text()
                log.warning(f"Discord {resp.status}: {body[:120]}")
    except Exception as e:
        log.warning(f"Discord post failed: {e}")


def build_outlook_embed(state: dict) -> dict:
    ind     = state["indicators"]
    regime  = state["regime"]
    score   = state["total_score"]
    emoji   = regime_emoji(regime)
    modifier = state["position_size_modifier"]

    btc     = ind.get("btc_bias", {})
    dxy     = ind.get("dxy", {})
    vix_d   = ind.get("vix", {})
    sp5     = ind.get("sp500", {})
    t10y    = ind.get("us10y", {})
    mcap    = ind.get("crypto_mcap", {})
    fed     = ind.get("fed_expectations", {})
    sec     = ind.get("sector_rotation", {})

    def _fmt_score(sc: int) -> str:
        return f"({sc:+d})" if sc != 0 else "(0)"

    lines = [
        f"**Regime: {emoji} {regime} ({score}/12)**",
        f"**Position Size Modifier: {modifier}x**",
        "",
        f"DXY: {dxy.get('value','N/A')} — {dxy.get('trend','?')} {score_icon(dxy.get('score',0))} {_fmt_score(dxy.get('score',0))}",
        f"VIX: {vix_d.get('value','N/A')} — {vix_d.get('level','?')} {score_icon(vix_d.get('score',0))} {_fmt_score(vix_d.get('score',0))}",
        f"S&P 500: {sp5.get('trend','?')} {score_icon(sp5.get('score',0))} {_fmt_score(sp5.get('score',0))}",
        f"US 10Y: {t10y.get('value','N/A')}% — {t10y.get('trend','?')} {score_icon(t10y.get('score',0))} {_fmt_score(t10y.get('score',0))}",
        f"Crypto MCap: {mcap.get('trend','?')} {score_icon(mcap.get('score',0))} {_fmt_score(mcap.get('score',0))}",
        f"Fed Expectations: {fed.get('two_year_trend','?')} {score_icon(fed.get('score',0))} {_fmt_score(fed.get('score',0))}",
        f"Sector Rotation: {sec.get('leader','?')} leading — {sec.get('type','?')} {score_icon(sec.get('score',0))} {_fmt_score(sec.get('score',0))}",
        f"BTC Bias (from scorer): {btc.get('raw_score',0):+d}/13 {btc.get('bias','?')} {score_icon(btc.get('score',0))} {_fmt_score(btc.get('score',0))}",
        "",
        f"**Recommendation:** {state['recommendation']}",
        "",
        "_Next update: 4 hours_",
    ]

    color = {
        "STRONG RISK-ON": 0x00d2a0,
        "RISK-ON":        0x6c5ce7,
        "NEUTRAL":        0xffa502,
        "RISK-OFF":       0xff7675,
        "CRISIS":         0xff4757,
    }.get(regime, 0x636e72)

    return {"embeds": [{
        "title":       "🌍 MACRO OUTLOOK UPDATE",
        "description": "\n".join(lines),
        "color":       color,
        "footer":      {"text": f"Macro Strategist • {state['timestamp'][:19].replace('T',' ')} UTC"},
    }]}


def build_alert_embed(alerts: list[str], prev_regime: str, cur_regime: str,
                      cur_score: int, recommendation: str) -> dict:
    changed  = prev_regime != cur_regime
    title    = f"🚨 MACRO ALERT — {'Regime Change' if changed else 'Macro Shift'}"
    body     = "\n".join(f"• {a}" for a in alerts)
    if changed:
        body = f"**{prev_regime} → {cur_regime}**\n\n" + body
    body += f"\n\n**Recommendation:** {recommendation}"
    return {"embeds": [{
        "title":       title,
        "description": body,
        "color":       0xff4757,
        "footer":      {"text": f"Macro Strategist • {datetime.now(timezone.utc).strftime('%Y-%m-%d %H:%M')} UTC"},
    }]}


# ── Main ──────────────────────────────────────────────────────────────────────

async def run():
    log.info("=== Macro Strategist starting ===")
    log.info(f"BTC Bias file : {BTC_BIAS_FILE}")
    log.info(f"State file    : {STATE_FILE}")
    log.info(f"Discord outlook : {'✅' if OUTLOOK_URL else '❌'}")
    log.info(f"Discord alerts  : {'✅' if ALERTS_URL else '❌'}")
    log.info("")

    prev_state = load_json(STATE_FILE, None)
    prev_mcap  = prev_state.get("indicators", {}).get("crypto_mcap", {}).get("mcap") \
                 if prev_state else None
    prev_regime = prev_state.get("regime") if prev_state else None

    now = datetime.now(timezone.utc)
    log.info(f"[{now.strftime('%Y-%m-%d %H:%M UTC')}] Running macro analysis...")
    log.info("")

    # ── Fetch all indicators ──────────────────────────────────────────────────
    log.info("Fetching indicators:")
    btc_bias = fetch_btc_bias()
    log.info(f"  BTC Bias  : {btc_bias.get('bias')} raw={btc_bias.get('raw_score')} → macro score {btc_bias.get('score'):+d}")

    dxy      = fetch_dxy()
    log.info(f"  DXY       : {dxy.get('value')} {dxy.get('trend')} → score {dxy.get('score'):+d}")

    vix_d    = fetch_vix()
    log.info(f"  VIX       : {vix_d.get('value')} {vix_d.get('level')} → score {vix_d.get('score'):+d}")

    sp500    = fetch_sp500()
    log.info(f"  S&P 500   : {sp500.get('price')} {sp500.get('trend')} → score {sp500.get('score'):+d}")

    us10y    = fetch_us10y()
    log.info(f"  US 10Y    : {us10y.get('value')}% {us10y.get('trend')} → score {us10y.get('score'):+d}")

    crypto_mc = fetch_crypto_mcap(prev_mcap)
    log.info(f"  Crypto MC : {crypto_mc.get('trend')} → score {crypto_mc.get('score'):+d}")

    fed_exp  = fetch_fed_expectations()
    log.info(f"  Fed Proxy : {fed_exp.get('value')} {fed_exp.get('two_year_trend')} → score {fed_exp.get('score'):+d}")

    sector   = fetch_sector_rotation()
    log.info(f"  Sectors   : {sector.get('leader')} leading ({sector.get('type')}) → score {sector.get('score'):+d}")

    # ── Total score & regime ──────────────────────────────────────────────────
    total  = (btc_bias["score"] + dxy["score"] + vix_d["score"] + sp500["score"] +
              us10y["score"] + crypto_mc["score"] + fed_exp["score"] + sector["score"])
    regime, modifier = classify_regime(total)
    recommendation   = build_recommendation(regime, {
        "btc_bias": btc_bias, "dxy": dxy, "vix": vix_d, "sp500": sp500,
        "us10y": us10y, "crypto_mcap": crypto_mc,
        "fed_expectations": fed_exp, "sector_rotation": sector,
    }, [])

    log.info("")
    log.info(f"  ══════════════════════════════════")
    log.info(f"  TOTAL SCORE : {total:+d} / 12")
    log.info(f"  REGIME      : {regime}")
    log.info(f"  MODIFIER    : {modifier}x")
    log.info(f"  ══════════════════════════════════")
    log.info("")

    # ── Build state ───────────────────────────────────────────────────────────
    indicators = {
        "btc_bias":         btc_bias,
        "dxy":              dxy,
        "vix":              vix_d,
        "sp500":            sp500,
        "us10y":            us10y,
        "crypto_mcap":      crypto_mc,
        "fed_expectations": fed_exp,
        "sector_rotation":  sector,
    }

    alerts = detect_alerts(
        {"regime": regime, "indicators": indicators},
        prev_state,
    )
    if alerts:
        log.info(f"Alerts detected: {len(alerts)}")
        for a in alerts:
            log.info(f"  ⚠️  {a}")

    # Rolling history
    history = (prev_state.get("history", []) if prev_state else [])
    if prev_state:
        history = [{
            "timestamp": prev_state.get("timestamp"),
            "regime":    prev_state.get("regime"),
            "score":     prev_state.get("total_score"),
        }] + history
    history = history[:MAX_HISTORY]
    # Archive history when it grows (async post via aiohttp inline)
    _macro_archive_url = ARCHIVE_URL

    state = {
        "timestamp":            now.isoformat(),
        "regime":               regime,
        "total_score":          total,
        "max_score":            12,
        "position_size_modifier": modifier,
        "recommendation":       recommendation,
        "indicators":           indicators,
        "alerts":               alerts,
        "history":              history,
    }
    save_json(STATE_FILE, state)
    log.info(f"State saved → {STATE_FILE}")

    # ── Discord ───────────────────────────────────────────────────────────────
    async with aiohttp.ClientSession() as session:
        outlook_payload = build_outlook_embed(state)
        await post_discord(session, OUTLOOK_URL, outlook_payload)
        log.info("Posted to #macro-outlook")

        if alerts:
            alert_payload = build_alert_embed(
                alerts, prev_regime or regime, regime, total, recommendation
            )
            await post_discord(session, ALERTS_URL, alert_payload)
            log.info(f"Posted {len(alerts)} alert(s) to #macro-alerts")

    log.info("=== Macro Strategist run complete ===")


if __name__ == "__main__":
    asyncio.run(run())
