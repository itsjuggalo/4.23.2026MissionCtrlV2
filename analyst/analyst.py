#!/usr/bin/env python3
"""
The Analyst — Renaissance-style quantitative signal evaluator.
Reads actionable signals from Eric's listener, runs 6-indicator
technical analysis, posts results to Discord.

Runs continuously, polling every 60 seconds.
"""
import asyncio
import json
import logging
import os
import sys
import time
import uuid
from datetime import datetime, timezone

import aiohttp
import numpy as np
import pandas as pd
import requests
import sys as _sys
_sys.path.insert(0, os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
from dotenv import load_dotenv
from shared.archiver import maybe_rotate

# ── Config ───────────────────────────────────────────────────────────────────

load_dotenv(os.path.join(os.path.dirname(os.path.abspath(__file__)), ".env"))

_DIR          = os.path.dirname(os.path.abspath(__file__))
SIGNALS_FILE  = os.path.join(os.path.dirname(_DIR), "telegram-listener", "signals.json")
RESULTS_FILE       = os.path.join(_DIR, "analysis_results.json")
ARCHIVE_URL        = os.getenv("DISCORD_ARCHIVE_ANALYST_WEBHOOK", "")
RESULTS_MAX        = 200

SETUPS_URL    = os.getenv("DISCORD_ANALYST_SETUPS_WEBHOOK", "")
WATCHLIST_URL = os.getenv("DISCORD_ANALYST_WATCHLIST_WEBHOOK", "")

POLL_INTERVAL = 60   # seconds

KNOWN_CRYPTO = {
    "BTC","ETH","SOL","BNB","XRP","ADA","DOGE","AVAX","DOT","MATIC",
    "LINK","UNI","ATOM","LTC","BCH","NEAR","APT","ARB","OP","SUI",
    "INJ","SEI","TIA","PEPE","WIF","FLOKI","SHIB","SAND","MANA",
    "FTM","ALGO","VET","HBAR","FIL","AAVE","CRV","GMX","RUNE","TAO",
    "JTO","ZRO","PENDLE","RENDER","FET","ONDO","TRX","ZAMA","RDNT",
    "POLYX","JST","STG","DCR","BAT","ONT","ZEN","ICX","LRC",
}

logging.basicConfig(
    level=logging.INFO,
    format="%(asctime)s [ANALYST] %(message)s",
    datefmt="%Y-%m-%d %H:%M:%S",
    stream=sys.stdout,
)
log = logging.getLogger("analyst")


# ── Asset classification ──────────────────────────────────────────────────────

def is_crypto(symbol: str) -> bool:
    sym = symbol.upper().replace("/", "").replace("-", "")
    if sym.endswith("USDT") or sym.endswith("USD") or sym.endswith("BTC") or sym.endswith("ETH"):
        return True
    base = sym.replace("USDT","").replace("USD","")
    return base in KNOWN_CRYPTO


def normalize_crypto_symbol(symbol: str) -> str:
    """Return OKX instId format: BTC-USDT"""
    sym = symbol.upper().replace("/","").replace("-","").strip()
    if sym.endswith("USDT"):
        base = sym[:-4]
    elif sym.endswith("USD"):
        base = sym[:-3]
    elif sym.endswith("BTC") and len(sym) > 3:
        base = sym[:-3]
        return f"{base}-BTC"
    elif sym.endswith("ETH") and len(sym) > 3:
        base = sym[:-3]
        return f"{base}-ETH"
    elif sym in KNOWN_CRYPTO:
        base = sym  # bare known ticker → default to USDT pair
    else:
        base = sym
    return f"{base}-USDT"


# ── Price data fetchers ───────────────────────────────────────────────────────


# ── Agent Directives (Supertrend Optimizer) ───────────────────────────────────

DIRECTIVES_FILE = os.path.join(os.path.dirname(os.path.dirname(os.path.abspath(__file__))), "shared", "agent_directives.json")

def load_directives() -> dict:
    """Load optimized Supertrend params from supertrend_optimizer."""
    try:
        if os.path.exists(DIRECTIVES_FILE):
            with open(DIRECTIVES_FILE) as f:
                return json.load(f)
    except Exception:
        pass
    return {"symbols": {}}

def get_supertrend_directive(symbol: str) -> dict:
    """Get optimized Supertrend params for a symbol."""
    base = symbol.split("/")[0].upper()
    directives = load_directives()
    return directives.get("symbols", {}).get(base, {})

def calc_supertrend_signal(df: pd.DataFrame, atr_period: int, factor: float) -> tuple[int, str]:
    """
    Calculate Supertrend direction for the latest candle.
    Returns (score, signal_text)
    """
    if df is None or len(df) < atr_period + 10:
        return 0, "insufficient data"
    try:
        high, low, close = df["high"], df["low"], df["close"]
        tr = pd.concat([
            high - low,
            (high - close.shift(1)).abs(),
            (low  - close.shift(1)).abs(),
        ], axis=1).max(axis=1)
        atr = tr.ewm(span=atr_period, adjust=False).mean()
        hl2 = (high + low) / 2
        upper = hl2 + factor * atr
        lower = hl2 - factor * atr
        direction = 1
        for i in range(1, len(df)):
            prev_upper = upper.iloc[i-1]
            prev_lower = lower.iloc[i-1]
            lower.iloc[i] = lower.iloc[i] if lower.iloc[i] > prev_lower or close.iloc[i-1] < prev_lower else prev_lower
            upper.iloc[i] = upper.iloc[i] if upper.iloc[i] < prev_upper or close.iloc[i-1] > prev_upper else prev_upper
            if direction == 1:
                direction = -1 if close.iloc[i] > upper.iloc[i] else 1
            else:
                direction = 1 if close.iloc[i] < lower.iloc[i] else -1
        return direction, "bullish" if direction == -1 else "bearish"
    except Exception as e:
        return 0, f"error: {e}"

def fetch_okx_candles(inst_id: str, bar: str = "1H", limit: int = 100) -> pd.DataFrame | None:
    """OKX candles — works from this server. Returns OHLCV DataFrame."""
    url = f"https://www.okx.com/api/v5/market/candles"
    try:
        r = requests.get(url, params={"instId": inst_id, "bar": bar, "limit": limit}, timeout=12)
        r.raise_for_status()
        data = r.json()
        if not data.get("data"):
            return None
        # OKX: [ts, open, high, low, close, vol, volCcy, ...], newest first
        rows = data["data"]
        rows = list(reversed(rows))
        df = pd.DataFrame(rows, columns=["ts","open","high","low","close","vol","volCcy","volCcyQuote","confirm"])
        for col in ["open","high","low","close","vol"]:
            df[col] = pd.to_numeric(df[col], errors="coerce")
        df["ts"] = pd.to_datetime(pd.to_numeric(df["ts"]), unit="ms", utc=True)
        return df[["ts","open","high","low","close","vol"]].dropna()
    except Exception as e:
        log.warning(f"OKX fetch {inst_id} {bar} failed: {e}")
        return None


def fetch_yfinance_candles(ticker: str, period: str = "60d", interval: str = "1h") -> pd.DataFrame | None:
    """yfinance for stocks/forex."""
    try:
        import yfinance as yf
        t = yf.Ticker(ticker)
        df = t.history(period=period, interval=interval)
        if df.empty:
            return None
        df = df.rename(columns={"Open":"open","High":"high","Low":"low","Close":"close","Volume":"vol"})
        df = df[["open","high","low","close","vol"]].copy()
        df = df.dropna()
        return df.tail(100)
    except Exception as e:
        log.warning(f"yfinance fetch {ticker} {interval} failed: {e}")
        return None


def get_candles(symbol: str) -> tuple[pd.DataFrame | None, pd.DataFrame | None]:
    """Return (1H df, 4H df) for given symbol."""
    if is_crypto(symbol):
        inst = normalize_crypto_symbol(symbol)
        df1h = fetch_okx_candles(inst, "1H", 100)
        df4h = fetch_okx_candles(inst, "4H", 100)
        # Fallback: try SWAP if spot failed
        if df1h is None:
            inst_swap = inst.replace("-USDT", "-USDT-SWAP")
            df1h = fetch_okx_candles(inst_swap, "1H", 100)
        if df4h is None:
            inst_swap = inst.replace("-USDT", "-USDT-SWAP")
            df4h = fetch_okx_candles(inst_swap, "4H", 100)
        return df1h, df4h
    else:
        # Stocks: 1H and daily (yfinance 4H not always available)
        df1h = fetch_yfinance_candles(symbol, period="60d", interval="1h")
        df1d = fetch_yfinance_candles(symbol, period="200d", interval="1d")
        return df1h, df1d


# ── Indicator calculators ─────────────────────────────────────────────────────

def calc_rsi(closes: pd.Series, period: int = 14) -> float | None:
    if len(closes) < period + 1:
        return None
    delta = closes.diff()
    gain  = delta.clip(lower=0).rolling(period).mean()
    loss  = (-delta.clip(upper=0)).rolling(period).mean()
    rs    = gain / loss.replace(0, np.nan)
    rsi   = 100 - (100 / (1 + rs))
    val = rsi.iloc[-1]
    return round(float(val), 2) if not np.isnan(val) else None


def calc_macd(closes: pd.Series,
              fast: int = 12, slow: int = 26, signal: int = 9
              ) -> tuple[float, float, float] | None:
    if len(closes) < slow + signal:
        return None
    ema_fast   = closes.ewm(span=fast, adjust=False).mean()
    ema_slow   = closes.ewm(span=slow, adjust=False).mean()
    macd_line  = ema_fast - ema_slow
    signal_line = macd_line.ewm(span=signal, adjust=False).mean()
    histogram  = macd_line - signal_line
    return round(float(macd_line.iloc[-1]), 6), \
           round(float(signal_line.iloc[-1]), 6), \
           round(float(histogram.iloc[-1]), 6)


def calc_emas_sma(closes: pd.Series) -> dict | None:
    if len(closes) < 20:
        return None
    ema20  = float(closes.ewm(span=20, adjust=False).mean().iloc[-1])
    ema50  = float(closes.ewm(span=50, adjust=False).mean().iloc[-1]) if len(closes) >= 50 else None
    sma200 = float(closes.rolling(200).mean().iloc[-1]) if len(closes) >= 200 else None
    price  = float(closes.iloc[-1])
    return {"price": round(price,4), "ema20": round(ema20,4),
            "ema50": round(ema50,4) if ema50 else None,
            "sma200": round(sma200,4) if sma200 else None}


def find_support_resistance(df: pd.DataFrame, window: int = 50) -> list[float]:
    """Simple swing-high / swing-low detection over last `window` candles."""
    sub = df.tail(window)
    highs = sub["high"].values
    lows  = sub["low"].values
    levels = []
    for i in range(2, len(highs)-2):
        if highs[i] > highs[i-1] and highs[i] > highs[i-2] and \
           highs[i] > highs[i+1] and highs[i] > highs[i+2]:
            levels.append(round(float(highs[i]), 6))
        if lows[i] < lows[i-1] and lows[i] < lows[i-2] and \
           lows[i] < lows[i+1] and lows[i] < lows[i+2]:
            levels.append(round(float(lows[i]), 6))
    return levels


# ── Scoring engine ────────────────────────────────────────────────────────────

def score_rsi(rsi: float | None, direction: str) -> tuple[int, str]:
    if rsi is None:
        return 0, "unavailable"
    d = direction.upper()
    if rsi < 30:
        return (1 if d in ("LONG","BUY","CALL") else -1), f"oversold ({rsi})"
    if rsi > 70:
        return (1 if d in ("SHORT","SELL","PUT") else -1), f"overbought ({rsi})"
    return 0, f"neutral ({rsi})"


def score_macd(macd_res: tuple | None, direction: str) -> tuple[int, str]:
    if macd_res is None:
        return 0, "unavailable"
    _, _, hist = macd_res
    d = direction.upper()
    if hist > 0:
        sig = "bullish crossover"
        return (1 if d in ("LONG","BUY","CALL") else -1), sig
    if hist < 0:
        sig = "bearish crossover"
        return (1 if d in ("SHORT","SELL","PUT") else -1), sig
    return 0, "no clear signal"


def score_mas(ma_data: dict | None, direction: str) -> tuple[int, str, dict]:
    if ma_data is None:
        return 0, "unavailable", {}
    price  = ma_data["price"]
    ema20  = ma_data["ema20"]
    ema50  = ma_data.get("ema50")
    sma200 = ma_data.get("sma200")
    d = direction.upper()

    checks = [price > ema20]
    if ema50:  checks.append(price > ema50)
    if sma200: checks.append(price > sma200)
    above = sum(checks)
    total = len(checks)

    if above == total:
        structure = "bullish"
        sc = 1 if d in ("LONG","BUY","CALL") else -1
    elif above == 0:
        structure = "bearish"
        sc = 1 if d in ("SHORT","SELL","PUT") else -1
    else:
        structure = "mixed"
        sc = 0

    desc = f"Price {structure} — above {above}/{total} MAs"
    return sc, desc, ma_data


def score_volume(df: pd.DataFrame) -> tuple[int, str, dict]:
    if df is None or len(df) < 5:
        return 0, "unavailable", {}
    avg20 = float(df["vol"].tail(20).mean())
    cur   = float(df["vol"].iloc[-1])
    ratio = round(cur / avg20, 2) if avg20 > 0 else 1.0
    if ratio >= 1.5:
        return 1, f"{ratio}x average — strong conviction", {"current": cur, "average": avg20, "ratio": ratio}
    if ratio < 0.8:
        return -1, f"{ratio}x average — low volume", {"current": cur, "average": avg20, "ratio": ratio}
    return 0, f"{ratio}x average — normal", {"current": cur, "average": avg20, "ratio": ratio}


def score_sr(df: pd.DataFrame, entry: float | None, direction: str) -> tuple[int, str, float | None]:
    if df is None or entry is None:
        return 0, "unavailable", None
    levels = find_support_resistance(df)
    if not levels:
        return 0, "no key levels found", None
    nearest = min(levels, key=lambda l: abs(l - entry))
    dist_pct = abs(nearest - entry) / entry * 100
    d = direction.upper()
    if dist_pct <= 1.5:  # within 1.5% of a level
        level_type = "support" if nearest <= entry else "resistance"
        aligned = (level_type == "support" and d in ("LONG","BUY","CALL")) or \
                  (level_type == "resistance" and d in ("SHORT","SELL","PUT"))
        sc = 1 if aligned else 0
        return sc, f"Entry near {level_type} at {nearest:.4f} ({dist_pct:.1f}%)", nearest
    return 0, f"Not near key level (nearest: {nearest:.4f}, {dist_pct:.1f}% away)", nearest


def score_rr(entry: float | None, stop: float | None, targets: list) -> tuple[int, str, float | None]:
    if entry is None or stop is None or not targets:
        return 0, "unavailable", None
    risk   = abs(entry - stop)
    if risk == 0:
        return 0, "zero risk (entry == stop)", None
    reward = abs(targets[0] - entry)
    rr     = round(reward / risk, 2)
    if rr >= 2.0:
        return 1, f"{rr}:1 ✅", rr
    if rr >= 1.0:
        return 0, f"{rr}:1 ⚠️", rr
    return -1, f"{rr}:1 ❌ below 1:1", rr


# ── Verdict ───────────────────────────────────────────────────────────────────

def get_verdict(score: int) -> str:
    if score >= 4:  return "STRONG"
    if score >= 2:  return "MODERATE"
    if score >= 0:  return "WEAK"
    return "REJECT"


def build_summary(symbol: str, direction: str, verdict: str, total: int,
                  indicators: dict) -> str:
    rsi_txt  = indicators.get("rsi", {}).get("signal", "N/A")
    macd_txt = indicators.get("macd", {}).get("signal", "N/A")
    ma_txt   = indicators.get("moving_averages", {}).get("structure", "N/A")
    vol_txt  = indicators.get("volume", {}).get("signal", "N/A")
    sr_txt   = indicators.get("support_resistance", {}).get("signal", "N/A")
    rr_txt   = indicators.get("risk_reward", {}).get("signal", "N/A")

    if verdict == "STRONG":
        tone = "technically strong. Recommend to Risk Manager."
    elif verdict == "MODERATE":
        tone = "decent setup. Proceed with caution."
    elif verdict == "WEAK":
        tone = "technically weak. Technicals don't fully support this."
    else:
        tone = "technicals CONTRADICT the signal. Avoid."

    return (
        f"{symbol} {direction} setup is {tone} "
        f"RSI: {rsi_txt}. MACD: {macd_txt}. MAs: {ma_txt}. "
        f"Volume: {vol_txt}. S/R: {sr_txt}. R:R: {rr_txt}."
    )


# ── Main analysis pipeline ────────────────────────────────────────────────────

def analyze_signal(signal: dict) -> dict | None:
    symbol    = signal.get("symbol", "")
    direction = signal.get("direction", "")
    entry     = signal.get("entry")
    stop      = signal.get("stop_loss")
    targets   = signal.get("targets", [])

    if not symbol or not direction:
        log.warning(f"Skipping signal {signal.get('id','?')} — missing symbol or direction")
        return None

    log.info(f"Analyzing {symbol} {direction} (id: {signal.get('id','?')[:8]}...)")

    df1h, df4h = get_candles(symbol)

    # Use whichever timeframe has data; prefer 1H for RSI/MACD/volume, 4H for S/R
    df_primary = df1h if df1h is not None and len(df1h) >= 20 else df4h
    df_sr      = df4h if df4h is not None and len(df4h) >= 20 else df1h

    if df_primary is None:
        log.warning(f"No price data for {symbol} — skipping analysis")
        return None

    closes = df_primary["close"]

    # ── Indicators ────────────────────────────────────────────────────────────
    rsi_val  = calc_rsi(closes)
    rsi_sc, rsi_sig = score_rsi(rsi_val, direction)

    macd_res = calc_macd(closes)
    macd_sc, macd_sig = score_macd(macd_res, direction)

    ma_data = calc_emas_sma(closes)
    ma_sc, ma_sig, ma_out = score_mas(ma_data, direction)

    vol_sc, vol_sig, vol_out = score_volume(df_primary)

    sr_sc, sr_sig, sr_level = score_sr(df_sr, entry, direction)

    rr_sc, rr_sig, rr_val = score_rr(entry, stop, targets)

    # ── 7th indicator: ML Adaptive SuperTrend (from optimizer) ──────────────
    st_directive = get_supertrend_directive(symbol)
    st_atr    = st_directive.get("atr_period", 10)
    st_factor = st_directive.get("multiplier", 3.0)
    st_regime = st_directive.get("volatility_regime", "UNKNOWN")
    st_dir, st_sig = calc_supertrend_signal(df_primary, st_atr, st_factor)
    # Score: +1 if ST agrees with direction, -1 if contradicts
    dir_map = {"LONG": -1, "BUY": -1, "CALL": -1, "SHORT": 1, "SELL": 1, "PUT": 1}
    expected_st = dir_map.get(direction.upper(), 0)
    st_sc = 1 if st_dir == expected_st else (-1 if expected_st != 0 else 0)
    st_label = f"{'✅' if st_sc == 1 else '❌' if st_sc == -1 else '➖'} {st_sig} (ATR={st_atr}, factor={st_factor}, regime={st_regime})"

    total   = rsi_sc + macd_sc + ma_sc + vol_sc + sr_sc + rr_sc + st_sc
    verdict = get_verdict(total)

    indicators = {
        "supertrend": {
            "direction":   st_dir,
            "signal":      st_sig,
            "score":       st_sc,
            "label":       st_label,
            "atr_period":  st_atr,
            "factor":      st_factor,
            "regime":      st_regime,
        },
        "rsi": {
            "value":  rsi_val,
            "signal": rsi_sig,
            "score":  rsi_sc,
        },
        "macd": {
            "macd_line":  macd_res[0] if macd_res else None,
            "signal_line": macd_res[1] if macd_res else None,
            "histogram":  macd_res[2] if macd_res else None,
            "signal":     macd_sig,
            "score":      macd_sc,
        },
        "moving_averages": {
            **(ma_out or {}),
            "structure": ma_sig,   # human-readable description
            "score":     ma_sc,
        },
        "volume": {
            **vol_out,
            "signal": vol_sig,
            "score":  vol_sc,
        },
        "support_resistance": {
            "nearest_level": sr_level,
            "signal":        sr_sig,
            "score":         sr_sc,
        },
        "risk_reward": {
            "ratio":  rr_val,
            "signal": rr_sig,
            "score":  rr_sc,
        },
    }

    summary = build_summary(symbol, direction, verdict, total, indicators)

    result = {
        "id":         str(uuid.uuid4()),
        "signal_id":  signal.get("id"),
        "symbol":     symbol,
        "direction":  direction,
        "timestamp":  datetime.now(timezone.utc).isoformat(),
        "entry":      entry,
        "stop_loss":  stop,
        "targets":    targets,
        "source_score": signal.get("score"),
        "indicators": indicators,
        "total_score": total,  # out of 7 (includes SuperTrend)
        "verdict":    verdict,
        "summary":    summary,
    }

    log.info(f"  → {symbol} {direction} | score={total}/6 | verdict={verdict}")
    return result


# ── Storage ───────────────────────────────────────────────────────────────────

def load_results() -> list:
    if os.path.exists(RESULTS_FILE):
        try:
            with open(RESULTS_FILE, "r") as f:
                return json.load(f)
        except Exception:
            return []
    return []


def save_results(results: list) -> None:
    with open(RESULTS_FILE, "w") as f:
        json.dump(results, f, indent=2, default=str)


def load_signals() -> list:
    if not os.path.exists(SIGNALS_FILE):
        return []
    try:
        with open(SIGNALS_FILE, "r") as f:
            return json.load(f)
    except Exception:
        return []


# ── Discord poster ─────────────────────────────────────────────────────────────

def score_icon(sc: int) -> str:
    if sc > 0:  return "✅"
    if sc < 0:  return "❌"
    return "⚠️"


def verdict_emoji(v: str) -> str:
    return {"STRONG":"🟢","MODERATE":"🟡","WEAK":"🟠","REJECT":"🔴"}.get(v, "⚪")


def build_discord_payload(result: dict) -> dict:
    ind = result["indicators"]
    verdict  = result["verdict"]
    total    = result["total_score"]
    symbol   = result["symbol"]
    direction = result["direction"]
    v_emoji  = verdict_emoji(verdict)

    header = f"📊 {'TECHNICAL ANALYSIS' if verdict in ('STRONG','MODERATE') else 'WATCHLIST'} — {symbol} {direction}"

    st_ind    = ind.get("supertrend", {})
    st_line   = f"SuperTrend: {st_ind.get('label','N/A')} {score_icon(st_ind.get('score',0))}"
    rsi_line  = f"RSI (14): {ind['rsi'].get('value','N/A')} — {ind['rsi']['signal']} {score_icon(ind['rsi']['score'])}"
    macd_line = f"MACD: {ind['macd']['signal']} {score_icon(ind['macd']['score'])}"
    ma_line   = f"MAs: {ind['moving_averages'].get('structure','N/A')} {score_icon(ind['moving_averages']['score'])}"
    vol_line  = f"Volume: {ind['volume'].get('signal','N/A')} {score_icon(ind['volume']['score'])}"
    sr_line   = f"S/R: {ind['support_resistance'].get('signal','N/A')} {score_icon(ind['support_resistance']['score'])}"
    rr_line   = f"R:R: {ind['risk_reward'].get('signal','N/A')} {score_icon(ind['risk_reward']['score'])}"

    source_sc = result.get("source_score")
    source_note = f"Source signal score: {source_sc}/100 (from Eric)" if source_sc is not None else ""

    description = (
        f"**Verdict: {v_emoji} {verdict} ({total}/6)**\n\n"
        f"{st_line}\n"
        f"{rsi_line}\n"
        f"{macd_line}\n"
        f"{ma_line}\n"
        f"{vol_line}\n"
        f"{sr_line}\n"
        f"{rr_line}\n\n"
        f"**Summary:** {result['summary']}\n"
        f"{source_note}"
    )

    color = {"STRONG": 0x00d2a0, "MODERATE": 0xffa502,
             "WEAK": 0xff7675, "REJECT": 0xff4757}.get(verdict, 0x636e72)

    return {
        "embeds": [{
            "title":       header,
            "description": description,
            "color":       color,
            "footer":      {"text": f"The Analyst • {result['timestamp'][:19].replace('T',' ')} UTC"},
        }]
    }


async def post_discord(session: aiohttp.ClientSession, url: str, payload: dict) -> None:
    if not url:
        return
    try:
        async with session.post(url, json=payload, timeout=aiohttp.ClientTimeout(total=10)) as resp:
            if resp.status not in (200, 204):
                body = await resp.text()
                log.warning(f"Discord {resp.status}: {body[:120]}")
    except Exception as e:
        log.warning(f"Discord post failed: {e}")


# ── Main loop ─────────────────────────────────────────────────────────────────

async def run():
    log.info("=== The Analyst starting ===")
    log.info(f"Signals file : {SIGNALS_FILE}")
    log.info(f"Results file : {RESULTS_FILE}")
    log.info(f"Discord setups    : {'✅' if SETUPS_URL else '❌'}")
    log.info(f"Discord watchlist : {'✅' if WATCHLIST_URL else '❌'}")
    log.info(f"Polling every {POLL_INTERVAL}s\n")

    async with aiohttp.ClientSession() as session:
        while True:
            try:
                signals = load_signals()
                results = load_results()
                analyzed_ids = {r["signal_id"] for r in results}

                actionable = [
                    s for s in signals
                    if s.get("status") == "actionable"
                    and s.get("id") not in analyzed_ids
                ]

                if actionable:
                    log.info(f"Found {len(actionable)} new actionable signal(s) to analyze")

                for sig in actionable:
                    result = analyze_signal(sig)
                    if result is None:
                        continue

                    results.append(result)
                    results = await maybe_rotate(
                        session, "analyst", results, RESULTS_FILE,
                        max_entries=RESULTS_MAX, webhook_url=ARCHIVE_URL
                    )
                    save_results(results)

                    # Discord routing
                    payload = build_discord_payload(result)
                    if result["verdict"] in ("STRONG", "MODERATE"):
                        await post_discord(session, SETUPS_URL, payload)
                    else:
                        await post_discord(session, WATCHLIST_URL, payload)

                    # Respect rate limits between analyses
                    await asyncio.sleep(2)

            except Exception as e:
                log.error(f"Main loop error: {e}", exc_info=True)

            await asyncio.sleep(POLL_INTERVAL)


if __name__ == "__main__":
    asyncio.run(run())
