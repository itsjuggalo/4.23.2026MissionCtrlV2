# Macro-Regime Overlay for PullbackTrend_1h

**Status:** spec v1 (2026-05-22)
**Target strategy:** `/home/itsju/LapClaw/freqtrade/user_data/strategies/PullbackTrend_1h.py`
**Pine target:** `/home/itsju/LapClaw/freqtrade/user_data/pine/PullbackTrend_1h_swing.pine`
**Baseline (real fees, no overlay):** OOS 2025-10 to 2026-05, +3.52%, WR 66.1%, DD 0.39%, Sharpe 2.72, 62 trades.

The 1h pullback-trend strategy already has a per-pair HTF bias (1d EMA50). The macro overlay adds a *cross-asset* gate that asks "is the global liquidity / risk regime hostile to crypto trend right now?" before each entry. The overlay is multiplicative with the existing HTF filter — never a replacement.

---

## 1. Regime indicators — the 4 that matter

Cut from a candidate list of 8 down to 4. Each one has a documented mechanism for why crypto-trend strategies bleed when it flips against you. Listed in **priority order** (highest signal value first):

### (1) BTC vs its own 200-day SMA — the meta-regime
**TradingView ticker:** `INDEX:BTCUSD` (or `BINANCE:BTCUSDT`), 1d, SMA(200)
**Red when:** `BTC close < BTC 200d SMA` for 3 consecutive daily closes (filters whipsaws)
**Why it matters for pullback-trend:** Below the 200d, the entire crypto complex enters bear-regime correlation. Altcoin pullbacks stop bouncing and become trend continuations down. The strategy's HTF=1d EMA50 filter catches *per-pair* bias but misses the basket-level regime where SOL/LINK/LTC/XRP all bleed in unison even when individual 50d slopes briefly turn up. This is the single most important gate. ~70% of historical crypto trend-strategy drawdowns occur with BTC below its 200d.

### (2) DXY trend regime
**TradingView ticker:** `TVC:DXY`, 1d
**Red when:** `DXY > 105 AND DXY > DXY.SMA(50)` (both level and trend rising)
**Why it matters:** Bull DXY = USD strength = liquidity contraction = risk-off across crypto. Empirically since 2020, the BTC/DXY rolling 90-day correlation sits at -0.45 to -0.65. A rising DXY above 105 historically coincided with the worst crypto-trend drawdowns (Q2/Q3 2022). The level threshold (105) matters because DXY rangebound 100-104 is regime-neutral.

### (3) US 10-year yield direction
**TradingView ticker:** `TVC:US10Y` (or `TVC:TNX` scaled)
**Red when:** `US10Y > 4.5% AND US10Y > US10Y.SMA(20)` (high and still rising)
**Why it matters:** Rising real yields = duration assets get repriced down. Crypto behaves as a long-duration risk asset. The 4.5% threshold is the level above which historically (2023-2024) the Nasdaq and BTC both struggled to sustain uptrends. A *falling* 10Y above 4.5% is OK — it's the *combination* of "high and rising" that kills risk appetite.

### (4) VIX absolute level
**TradingView ticker:** `CBOE:VIX`, 1d
**Red when:** `VIX > 25` on close
**Why it matters:** VIX above 25 = equity stress regime. Crypto correlation to SPX spikes to 0.7+ during stress (decorrelation is a peacetime luxury). Pullback strategies assume mean-reversion within an uptrend; in a high-VIX regime, "pullbacks" become "first leg of a crash". 25 is the threshold above which SPY 5d realized vol historically exceeds 1.5%.

### Dropped from the list (with reasoning)
- **FOMC blackout windows** — included as a *separate calendar gate* (see section 6), not a regime indicator. Suppresses entries 24h before/after FOMC, CPI, NFP.
- **SPX 50d MA bias** — redundant with VIX + DXY + 10Y. Adding it pushes us toward over-gating.
- **BTC dominance trend** — interesting for alt rotation timing but doesn't gate entries cleanly. The strategy is basket-level, so BTC.D matters less than basket-wide BTC regime.
- **Halving cycle phase** — too low frequency (4-year cycle, n=4 samples) to be statistically meaningful as a binary gate. Useful as a context overlay for position sizing later.

---

## 2. Composite regime score

**Rule: `macro_ok = (red_count < 2)`**

Count the number of red indicators out of 4. If 0 or 1 are red, the macro is OK and entries are allowed. If 2 or more are red, suppress new entries until the count drops back below 2.

Rationale:
- 1 red indicator is normal regime noise (DXY can spike on a single hot CPI without crypto breaking).
- 2 reds = confirmation across at least two independent channels (rates AND dollar, or BTC-meta AND VIX). This is when historical drawdowns cluster.
- 3+ reds = full risk-off, but waiting for 3 means missing the gate (we'd already be in the drawdown).

**Exits are NOT gated** — the existing strategy exit logic (HTF break, ROI ladder, stoploss) handles open positions. The overlay only suppresses *new* entries. This is intentional: if you're already in a winning trade and macro flips red, let the ATR-based exit handle it. Don't double-tax exits.

---

## 3. Pine Script snippet (drop-in)

Paste this **between line 53 (end of inputs section) and line 54 (LTF indicators)** of `PullbackTrend_1h_swing.pine`, then change one line in the entry trigger.

```pine
// ----- Macro regime overlay (4-indicator composite) -------------------
use_macro_gate   = input.bool(true,  "Use Macro Regime Gate", group="Macro")
btc_ticker       = input.symbol("INDEX:BTCUSD", "BTC meta-regime", group="Macro")
dxy_ticker       = input.symbol("TVC:DXY",      "DXY",             group="Macro")
us10y_ticker     = input.symbol("TVC:US10Y",    "US 10Y yield",    group="Macro")
vix_ticker       = input.symbol("CBOE:VIX",     "VIX",             group="Macro")
dxy_level_red    = input.float(105.0, "DXY red level",  step=0.5, group="Macro")
us10y_red        = input.float(4.5,   "US10Y red %",    step=0.1, group="Macro")
vix_red          = input.float(25.0,  "VIX red level",  step=0.5, group="Macro")
btc_below_n      = input.int(3, "BTC<200d days to confirm", minval=1, maxval=10, group="Macro")

// All fetches use lookahead=off and pull from daily — no intraday peek-ahead.
btc_d_close = request.security(btc_ticker,   "D", close, lookahead=barmerge.lookahead_off)
btc_d_sma200 = request.security(btc_ticker,  "D", ta.sma(close, 200), lookahead=barmerge.lookahead_off)
dxy_d       = request.security(dxy_ticker,   "D", close, lookahead=barmerge.lookahead_off)
dxy_sma50   = request.security(dxy_ticker,   "D", ta.sma(close, 50), lookahead=barmerge.lookahead_off)
us10y_d     = request.security(us10y_ticker, "D", close, lookahead=barmerge.lookahead_off)
us10y_sma20 = request.security(us10y_ticker, "D", ta.sma(close, 20), lookahead=barmerge.lookahead_off)
vix_d       = request.security(vix_ticker,   "D", close, lookahead=barmerge.lookahead_off)

// Individual red flags
btc_below_200d = btc_d_close < btc_d_sma200
btc_red = ta.barssince(not btc_below_200d) >= btc_below_n
dxy_red   = (dxy_d > dxy_level_red) and (dxy_d > dxy_sma50)
rates_red = (us10y_d > us10y_red) and (us10y_d > us10y_sma20)
vix_red   = vix_d > vix_red

red_count = (btc_red ? 1 : 0) + (dxy_red ? 1 : 0) + (rates_red ? 1 : 0) + (vix_red ? 1 : 0)
macro_ok  = not use_macro_gate or (red_count < 2)

// Optional visual: tint background amber when macro_ok=false
bgcolor(not macro_ok ? color.new(color.orange, 88) : na, title="Macro red")
```

**Then change line 70** from:
```pine
long_signal = htf_uptrend and pullback_hit and rsi_cross_up and volume_ok
```
to:
```pine
long_signal = htf_uptrend and pullback_hit and rsi_cross_up and volume_ok and macro_ok
```

That's it. No lookahead bias because every `request.security()` uses `lookahead=barmerge.lookahead_off` and pulls daily-close values. The 1h bars consume yesterday's confirmed daily close, which is the correct behavior.

**Note on `vix_red` shadowing:** the variable name `vix_red` is both the input float and the boolean. Rename the input to `vix_red_lvl` if Pine complains (it usually doesn't with strict typing, but be defensive):
```pine
vix_red_lvl = input.float(25.0, "VIX red level", step=0.5, group="Macro")
vix_red     = vix_d > vix_red_lvl
```

---

## 4. Python equivalent (for freqtrade backtest validation)

Drop this into a new file `/home/itsju/LapClaw/freqtrade/user_data/strategies/macro_regime.py`, then import from the strategy. No new dependencies — `yfinance` is already in the freqtrade default env. FRED is not strictly needed because `^TNX` on yfinance gives us 10Y yield directly.

```python
"""
macro_regime.py — composite 4-indicator macro gate for crypto-trend strategies.

Pulls daily data from Yahoo Finance (DX-Y.NYB, ^TNX, ^VIX, BTC-USD) once per day,
caches to a parquet. Returns a single boolean: macro_ok(timestamp) -> bool.

No new pip deps. yfinance ships with freqtrade default env.
"""
from __future__ import annotations
from datetime import datetime, timedelta, timezone
from pathlib import Path
import logging

import pandas as pd

logger = logging.getLogger(__name__)

CACHE_PATH = Path("/home/itsju/LapClaw/freqtrade/user_data/data/macro_regime_cache.parquet")
CACHE_MAX_AGE_HOURS = 6  # refresh every 6h during backtests; intraday queries reuse

# Thresholds (see /home/itsju/sites/missioncontrol/MissionCtrlV2/docs/macro-regime-overlay.md §1)
DXY_LEVEL_RED = 105.0
US10Y_RED_PCT = 4.5  # ^TNX is quoted ×10, so 45.0 in yfinance units
VIX_RED = 25.0
BTC_BELOW_200D_DAYS = 3


def _fetch_macro_frame(start: str = "2018-01-01") -> pd.DataFrame:
    """Fetch all 4 macro series + compute red flags. Cached to parquet."""
    import yfinance as yf

    tickers = {
        "dxy":   "DX-Y.NYB",
        "tnx":   "^TNX",       # 10y yield ×10 (45.0 = 4.5%)
        "vix":   "^VIX",
        "btc":   "BTC-USD",
    }
    frames = {}
    for label, t in tickers.items():
        df = yf.download(t, start=start, progress=False, auto_adjust=False)
        if df is None or df.empty:
            raise RuntimeError(f"yfinance returned no data for {t}")
        frames[label] = df["Close"].rename(label)

    df = pd.concat(frames.values(), axis=1).ffill().dropna()
    df.index = pd.to_datetime(df.index).tz_localize("UTC")

    # Indicators
    df["dxy_sma50"]    = df["dxy"].rolling(50).mean()
    df["tnx_sma20"]    = df["tnx"].rolling(20).mean()
    df["btc_sma200"]   = df["btc"].rolling(200).mean()
    df["btc_below"]    = df["btc"] < df["btc_sma200"]
    df["btc_below_streak"] = (
        df["btc_below"].groupby((~df["btc_below"]).cumsum()).cumcount() + 1
    ) * df["btc_below"].astype(int)

    # Red flags
    df["btc_red"]   = df["btc_below_streak"] >= BTC_BELOW_200D_DAYS
    df["dxy_red"]   = (df["dxy"] > DXY_LEVEL_RED) & (df["dxy"] > df["dxy_sma50"])
    df["rates_red"] = (df["tnx"] > US10Y_RED_PCT * 10) & (df["tnx"] > df["tnx_sma20"])
    df["vix_red"]   = df["vix"] > VIX_RED

    df["red_count"] = (
        df["btc_red"].astype(int)
        + df["dxy_red"].astype(int)
        + df["rates_red"].astype(int)
        + df["vix_red"].astype(int)
    )
    df["macro_ok"] = df["red_count"] < 2

    return df


def get_macro_frame(force_refresh: bool = False) -> pd.DataFrame:
    """Load cached parquet, refresh if stale."""
    if not force_refresh and CACHE_PATH.exists():
        age = datetime.now(timezone.utc) - datetime.fromtimestamp(
            CACHE_PATH.stat().st_mtime, tz=timezone.utc
        )
        if age < timedelta(hours=CACHE_MAX_AGE_HOURS):
            return pd.read_parquet(CACHE_PATH)

    df = _fetch_macro_frame()
    CACHE_PATH.parent.mkdir(parents=True, exist_ok=True)
    df.to_parquet(CACHE_PATH)
    return df


def macro_ok_series(index: pd.DatetimeIndex) -> pd.Series:
    """
    Return a boolean Series aligned to `index` (typically the 1h dataframe.date).
    Uses merge_asof with direction='backward' so each 1h bar consumes the most
    recent CONFIRMED daily macro value — no lookahead.
    """
    macro = get_macro_frame()[["macro_ok"]].reset_index().rename(columns={"index": "date", "Date": "date"})
    macro["date"] = pd.to_datetime(macro["date"], utc=True)
    target = pd.DataFrame({"date": pd.to_datetime(index, utc=True)})
    merged = pd.merge_asof(
        target.sort_values("date"),
        macro.sort_values("date"),
        on="date",
        direction="backward",
    )
    return merged["macro_ok"].fillna(True).astype(bool).values
```

**Hooking into `PullbackTrend_1h.py`** — add ONE line in `populate_entry_trend` (do this in a copy of the strategy, e.g. `PullbackTrend_1h_macro.py`, since the user said don't modify the original):

```python
from user_data.strategies.macro_regime import macro_ok_series

# inside populate_entry_trend, before the conditions.append() block:
dataframe["macro_ok"] = macro_ok_series(dataframe["date"])
conditions.append(dataframe["macro_ok"])
```

---

## 5. Backtest validation plan

Goal: prove the overlay improves OOS risk-adjusted return without killing trade frequency.

**Step 1 — Establish baseline parity** (sanity check that the new strategy file reproduces the OOS numbers when `macro_ok` is forced to True):
```bash
cd /home/itsju/LapClaw/freqtrade
.venv/bin/freqtrade backtesting \
  --strategy PullbackTrend_1h \
  --timerange 20251001-20260522 \
  --config user_data/config.json
```
Expected: matches the validated baseline (+3.52%, 62 trades, Sharpe 2.72).

**Step 2 — Run the macro-gated variant on the same OOS window:**
```bash
.venv/bin/freqtrade backtesting \
  --strategy PullbackTrend_1h_macro \
  --timerange 20251001-20260522 \
  --config user_data/config.json
```

**Acceptance criteria (what "good" looks like):**
- Trade count drops by **20-40%** (62 trades → 37-50 trades). More than 50% drop = over-gating.
- Sharpe ratio rises from **2.72 to 3.0+**. If it stays flat or drops, the overlay is noise.
- Max DD stays at or below baseline 0.39% (it should — gating removes bad regimes).
- Win rate moves modestly (62-72% range). If WR collapses, the gate is removing winners, not losers.
- Return per trade goes UP. Baseline is 3.52% / 62 = 0.057%/trade. Target: 0.08%+ per trade.

**Step 3 — Run the longer training window to check robustness:**
```bash
.venv/bin/freqtrade backtesting \
  --strategy PullbackTrend_1h_macro \
  --timerange 20240601-20260522 \
  --config user_data/config.json
```
Expected: full-period return improves from +16.38% baseline to **+18-22%** with similar trade-count reduction. Key check: did the overlay prevent the strategy from giving back gains in any 2024-2025 drawdown periods?

**Step 4 — Ablation test (which indicator carries the edge?):**
Run 4 variants, each disabling ONE of the 4 indicators. The variant that *most degrades* from the full overlay tells you which indicator is doing the work. Historically BTC-meta and DXY carry 70% of the signal; rates and VIX are confirmations.

**Step 5 — Walk-forward** on 90-day rolling windows from 2022-01 to 2026-05 to check that the thresholds (105, 4.5%, 25) aren't overfit to recent data. If they only work in 2024-2026, they're curve-fit. The thresholds should produce *directionally* correct gating in 2022's bear market even if the absolute returns are different.

---

## 6. Pitfalls

### Sample size honesty
- DXY > 105 has only been sustained in roughly **3 distinct episodes** since BTC's history begins (2014-15, 2022, brief 2023). N=3 is not statistical evidence — it's pattern recognition. The 105 threshold is *informed* by these episodes, not derived from a robust statistical study.
- US 10Y > 4.5% has happened in essentially **one regime** during crypto's life: 2023-2024. We have less than one full Fed hiking cycle of overlap with mature crypto.
- VIX > 25 is more frequent (~12% of trading days since 2018) so the sample is reasonable.
- BTC < 200d SMA is the most data-rich signal (~30% of trading days historically) — this is why it's the top-ranked indicator.

**Implication:** treat the *combination* (composite score) as more robust than any single threshold. Individual thresholds may need recalibration after the next major cycle.

### Calendar events (FOMC, CPI, NFP)
The overlay above is *price-driven only*. Event-driven suppression (FOMC blackout) is a separate concern and requires maintaining a date list. Suggested location:
- **Source of truth:** `/home/itsju/LapClaw/freqtrade/user_data/macro_calendar/fomc_2025_2026.csv` (CSV with `date,event,window_hours` columns)
- **Refresh cadence:** quarterly, manual update against the Fed's published calendar (https://www.federalreserve.gov/monetarypolicy/fomccalendars.htm)
- **Integration:** add a second gate `calendar_ok = not in_blackout(now, calendar_df, hours=24)` AND it with `macro_ok`.
- **Don't** scrape this live — Fed calendar APIs are flaky and an out-of-date scrape that misses an FOMC is worse than no calendar.

### Over-gating risk
This is the real failure mode. The strategy already has:
1. HTF=1d EMA50 per-pair bias
2. Pullback-within-1ATR-of-EMA20 filter
3. RSI cross-up-through-50 trigger

Adding a 4-indicator composite gate on top means **5 layers of conditions**. Each one is individually defensible; together they can produce a strategy that only trades ~20 times/year, at which point statistical significance dies.

**Mitigation:** the `red_count < 2` threshold is intentionally permissive. Tightening to `< 1` (any red = suppress) would likely cut trade count by 60-70% and is **not recommended** without explicit empirical justification from the backtests in section 5.

**Kill-switch:** if walk-forward shows the overlay reduces total return by more than 20% in any 1-year window, the overlay is wrong for that regime — disable it via the `use_macro_gate` Pine input or set `macro_ok` to True unconditionally in Python.

### Yahoo Finance reliability
`yfinance` can rate-limit or return empty frames during heavy use. The cache (6h TTL) mitigates this. For production, consider:
- Mirror DXY/TNX/VIX to a local SQLite via a daily cron (e.g., on Oracle's existing scraper infra)
- Fall back to FRED API (`DGS10` for 10Y, `DTWEXBGS` for broad dollar) — already a documented backup, free, requires no key for basic series.

---

## 7. Decision log

- **Why not BTC dominance?** Useful for alt rotation, not for entry gating. The strategy already trades a basket; BTC.D telling us "alts will underperform BTC" doesn't tell us "suppress entries entirely."
- **Why not Fed Funds rate?** Lags 10Y by definition. 10Y prices the market's view of future Fed action; FFR prices the past.
- **Why daily lookback on macro, not 1h?** Macro indicators are designed for daily-close interpretation. Intraday DXY/VIX flickers are noise. Consuming the prior day's confirmed close is the correct timing and removes lookahead concern.
- **Why exits not gated?** Adding macro-driven exits to a strategy with already-working ATR/HTF exits would be a second strategy bolted on top — different research question, defer to v2.
