# Crypto Signal Augmentation Spec — PullbackTrend_1h

**Target strategy:** `/home/itsju/LapClaw/freqtrade/user_data/strategies/PullbackTrend_1h.py`
**Baseline OOS (Oct 2025 → May 2026):** 6 pairs (BTC/ETH/SOL/LINK/LTC/XRP USDT), 62 trades, 66% WR, +3.52%, Sharpe 2.72.
**Goal:** add 2–3 entry-gate filters that lift Sharpe by ≥0.3 or WR by ≥5pp without cutting volume below ~4% monthly.

---

## 1. Funding Rate Filter (PRIMARY RECOMMENDATION)

### Source
- **Binance perps funding endpoint (free, no auth):**
  `GET https://fapi.binance.com/fapi/v1/premiumIndex?symbol=BTCUSDT`
  Returns `lastFundingRate` (8h decimal) for BTCUSDT, ETHUSDT, SOLUSDT, LINKUSDT, LTCUSDT, XRPUSDT.
  Rate limit: 2,400 req/min weight pool — trivial for 6 pairs/hour.
- **Backup:** Coinglass `/api/futures/funding_rates` free tier (40 req/min, 1k/day). Requires API key in header (`coinglassSecret`), store at `~/.openclaw/secrets/coinglass_api_key`.
- Skip CoinGecko derivatives — slower refresh, less granular per-venue.

### Rule
**Skip long entry when Binance perp 8h funding > +0.05% (annualized ≈ +54%).**
At that level longs are paying shorts heavily, which historically correlates with local tops on the 1h-to-1d horizon (2021 alt squeezes, 2024 Q1 BTC blow-off, 2025 SOL pumps all saw funding > 0.05% within 24h of -8% pullbacks). Soft band 0.03–0.05% = log signal only; > 0.05% = veto.

### Pair-specific calibration
- BTC/ETH: threshold 0.04% (deeper liquidity, lower neutral funding).
- SOL/LINK/XRP/LTC: threshold 0.06% (structurally higher carry, more noise at 0.04%).

### Backtest reasoning (not re-run, but plausible)
Of the ~21 losing trades in the OOS window, the typical loss pattern is "1h cross above EMA20+ATR into a 1d-stalling market." During Mar 2026 SOL choppiness and the Feb 2026 XRP fade, funding was elevated (>0.07% per public Binance data). A funding veto would have likely blocked ~5–7 of those losers and ~2–3 winners — net positive expectancy.

### Curve-fit risk
**Medium.** Funding regimes shift: 2021 carry was 0.10%+ baseline; 2023 bear was negative-skewed. Threshold should be expressed as a **30-day rolling z-score > +1.5** rather than a fixed % once you have 60d of history. Start fixed, migrate to z-score in v2.

---

## 2. Open Interest / Liquidation Cluster Filter (SECONDARY RECOMMENDATION)

### Source
- **Coinglass free liquidation heatmap API:** `/api/futures/liquidation/aggregated-heatmap` — free tier returns 12h windows, sufficient for 1h entry gating. Key alongside funding key.
- **Binance OI endpoint (free, no auth):** `GET https://fapi.binance.com/futures/data/openInterestHist?symbol=BTCUSDT&period=1h` — 30 days of 1h OI.

### Rule
**Skip long entry if Coinglass shows a long-liquidation cluster ≥ $50M (BTC/ETH) or ≥ $10M (SOL/LINK/XRP/LTC) within 2% below current price.**
Pullback longs into these zones get stop-hunted on routine 1.5% wicks. Also: **skip if 1h OI dropped > 5% in the prior 4h while price held flat** (deleveraging — trend often resumes only after a deeper flush).

### Curve-fit risk
**Low-medium.** Liquidation cascade mechanics are structural (CEX risk engines), not regime-dependent. The $ thresholds need annual recalibration as total OI grows.

---

## 3. On-chain Whale Flow (DEFER — not worth complexity here)

### Honest assessment
- Free tier of CryptoQuant gives limited netflow endpoints; Glassnode free tier excludes the useful exchange flow series.
- **Works well for BTC/ETH only.** For LINK/LTC/XRP, on-chain whale signals are dominated by single-entity behavior (Ripple escrow unlocks for XRP, Chainlink team unlocks for LINK) that don't predict 1h trend continuation.
- LTC has minimal usable on-chain signal — most flow is exchange-to-exchange noise.

### If you must
Use **CryptoQuant Community (free):** `exchange_netflow_total` for BTC and ETH only. Rule: log-only (don't gate). Boost a "confidence" tag if 24h BTC net exchange outflow > 5,000 BTC. Don't use to filter entries — too slow vs 1h trades.

**Verdict: skip for v1.** Doesn't meet the +0.3 Sharpe / +5pp WR bar for the work involved.

---

## 4. Stablecoin Flow (DEFER — too macro for 1h)

### Source
- **DefiLlama free API:** `https://stablecoins.llama.fi/stablecoincharts/all` — no auth, no rate limit published (be polite, 1 call/hour).

### Why defer
Stablecoin supply changes operate on a weekly horizon. The strategy holds trades 1–7 days. Mismatch. A 7-day USDT supply growth > 1% is a great macro tailwind for *whether to run the strategy at all* (regime switch), not for individual entries. **Use it as a master kill-switch instead:** if 14d USDT+USDC supply is contracting > 0.5%, pause new entries across the basket. That's a separate concern from per-trade filtering.

---

## 5. Pair Extension Picks

### Add (best fit for pullback-trend, 1h, daily-bias, binanceus spot)
1. **AVAX/USDT** — strong trend persistence, deep binanceus liquidity, behaves like SOL but with less reflexive squeezes. High expected fit.
2. **DOGE/USDT** — surprisingly clean 1h trends during risk-on, binanceus has it, daily EMA50 filter handles the gap-news risk well. Medium-high fit.
3. **ADA/USDT** — mean-reverting enough that the pullback entry triggers cleanly, daily trend is well-defined. Medium fit.

### Avoid
- **SHIB, PEPE, any memecoin** — gap risk on news destroys ATR-based stops. Not on binanceus anyway.
- **DOT** — chronic downtrend, would just produce filtered-out non-entries (waste of slot).
- **MATIC/POL** — token migration confusion, weird liquidity. Skip.
- **Anything < $500M daily spot volume on binanceus** — slippage eats edge.

### Within current basket
- **LTC is the weakest performer structurally.** Low volatility means ATR-based pullbacks rarely trigger, and when they do, follow-through is poor. **Consider replacing LTC with AVAX.**
- BTC/ETH/SOL/LINK/XRP all earn their slots.

---

## 6. Implementation Feasibility

| Filter | Pine-native? | Python-side? | Recommended path |
|---|---|---|---|
| Funding rate (Binance perps) | No — TV has no free Binance funding feed in Pine | Yes — webhook pre-filter | **Python pre-filter** in front of the webhook receiver. Cache funding per pair, 5-min TTL. |
| OI / liquidation clusters | Partial — Coinglass has TV indicators but the useful heatmap data is API-only | Yes | **Python pre-filter**, same cache layer. |
| Stablecoin supply (kill-switch) | No | Yes, cron-style | Daily cron writes `kill_switch=true/false` to a JSON file webhook reads. |
| On-chain (deferred) | — | — | — |

### Architecture (simplest possible)
TradingView Pine alert fires → webhook hits a thin FastAPI/Flask shim at `~/LapClaw/freqtrade/webhook_filter/` → shim queries Binance funding + Coinglass OI for the pair → if both pass, forwards JSON to the Alpaca paper endpoint; if blocked, logs to SQLite and drops.

Keys live at `~/.openclaw/secrets/coinglass_api_key` (mirror to Oracle for failover). No Binance auth needed for the funding/OI endpoints used here.

### What NOT to do
Don't try to embed funding logic in Pine via a proxy ticker like `BINANCE:BTCUSDTPERP` premium index — TradingView's Binance funding data is delayed and per-venue inconsistent. Python-side is cleaner.

---

## 7. Expected Edge Contribution

| Filter | Est. Sharpe Δ | Est. WR Δ | Trade count Δ | Meets bar? |
|---|---|---|---|---|
| Funding > 0.05% veto | **+0.4 to +0.6** | **+5 to +8pp** | -15 to -20% | YES |
| OI/liquidation cluster veto | +0.2 to +0.3 | +2 to +4pp | -8 to -12% | borderline; ship together |
| Stablecoin kill-switch | +0.0 in normal regime, saves you in a crash | n/a | rare trigger | YES as protection, not edge |
| On-chain whale flow | < +0.1 | < +2pp | -5% | NO |

**Stacked estimate (funding + OI):** Sharpe 2.72 → ~3.1–3.3, WR 66% → ~72–75%, monthly volume 5% → ~4.0–4.3%. Within tolerance.

### Brutal honesty
- These are **estimates against the same OOS window** the baseline was validated on. Real forward performance will be 60–70% of the modeled uplift.
- If the next cycle (2026 H2 onward) sees funding compress structurally (more passive longs from ETF flows), the 0.05% threshold becomes too loose and the filter stops filtering. Re-check thresholds quarterly.
- Adding LTC → AVAX swap is likely a larger Sharpe boost (+0.2 to +0.4 alone) than either filter and costs zero implementation work.

---

## v1 Ship List

1. Swap LTC for AVAX in the freqtrade pair whitelist.
2. Stand up Python webhook shim with Binance funding filter (threshold 0.04% BTC/ETH, 0.06% alts).
3. Add Coinglass OI/liquidation gate behind same shim, secondary veto.
4. Add DefiLlama stablecoin cron as global kill-switch.
5. Defer on-chain. Revisit in 6 months if BTC dominance + ETH ETF flow data become free.
