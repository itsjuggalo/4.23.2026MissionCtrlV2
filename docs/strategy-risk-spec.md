# Strategy Risk Spec — PullbackTrend (BTCUSD / XRPUSD, 1m/5m/1h)

**Author:** Risk Manager (Tier-2)
**Date:** 2026-05-22
**Target:** TradingView Pine alerts → Alpaca paper → conditional live promotion
**Baseline strategy:** `/home/itsju/LapClaw/freqtrade/user_data/strategies/PullbackTrend.py`

---

## 0. Preamble — Honest Assessment First (Dalio: radical truth)

The current backtest numbers are **not even close to live-trade qualifying**:

| Metric        | Train (12mo)   | OOS (~11mo) | Live-go threshold (see §9) | Pass? |
|---------------|----------------|-------------|----------------------------|-------|
| Return        | +0.14%         | +0.07%      | > +8% annualized           | NO    |
| Max DD        | 0.17%          | 0.10%       | < 15%                      | yes (but only because of zero activity) |
| Sharpe        | 0.61           | 0.46        | > 1.0                      | NO    |
| Trade count   | unknown        | unknown     | > 100 OOS                  | UNKNOWN |

**Verdict:** A +0.07% OOS return on a year is statistical noise — likely sub-10 winning trades net of fees. The edge is either non-existent or too small to overcome slippage and spread on alts. **DO NOT PUT REAL MONEY ON THIS STRATEGY IN ITS CURRENT FORM.** Paper-trade the Pine port to validate the alert→bracket plumbing, then go back and re-engineer the entry logic. Risk management cannot rescue a strategy with no edge — it can only stop it from killing you faster.

Also flagged: the strategy docstring claims a `1.5 * ATR` stop, but `stoploss = -0.03` (fixed 3%) is what actually runs. `custom_stoploss()` returns `None`. **The backtest you have is not the strategy the docstring describes.** Reconcile before any further tuning.

---

## 1. Per-Trade Risk

### Move to ATR-based stops. Yes, immediately.

Fixed 3% stops are wrong because:
- A 3% stop on BTC 1m (typical ATR ~0.08%) is ~35 ATRs — never hits, ROI ladder always exits.
- A 3% stop on XRP 5m in a volatile session (ATR ~0.6%) is only 5 ATRs — gets stopped on noise.
- Different timeframes need different stop distances. Same with different pairs.

### Formulas (program these into Pine)

```
stop_distance_$  = atr_mult * ATR(14)              // see §3 & §4 for mult
risk_per_trade_$ = account_equity * risk_pct       // risk_pct = 0.50% default
position_size    = risk_per_trade_$ / stop_distance_$
position_notional_cap = account_equity * max_pos_pct   // hard ceiling, see below
final_size       = min(position_size, position_notional_cap / entry_price)
```

### Numbers

- **`risk_pct` per trade = 0.50% of account equity** (live). Paper can run 1.0% for faster feedback loop.
- **`max_pos_pct` notional cap = 25% of equity per single position.** Even if the stop math says you can risk more, never let one position exceed 25% notional — that's the catastrophic-gap protection layer.
- **Hard min position = $10 notional** (don't waste fees on dust).

### Why 0.50%?

Kelly-style ruin math: with an honest 50% win rate and 1.5R average winner (optimistic for this strategy), full-Kelly = ~17% per trade. **Fractional Kelly (1/20th to 1/30th) = 0.5%-0.85%** is the standard pro survival band. At 0.5%, 20 consecutive full-stop losses = 10% drawdown — recoverable. At 2% per trade (a common amateur number), 20 losses in a row = 33% drawdown — psychologically and mathematically much harder to come back from.

---

## 2. Account-Level Limits

| Limit                                | Value           | Rationale |
|--------------------------------------|-----------------|-----------|
| Max concurrent open positions        | **3**           | Keep current. With correlation cap in §5, this is effectively ≤ 2 independent bets. |
| Max concurrent per-pair              | **1**           | One BTCUSD position at a time. No pyramiding in v1. |
| Daily loss limit (hard stop trading) | **-2.0% equity**| At 0.5% risk/trade, that's 4 full stops in a day. If you take 4 stops you are wrong about the regime — stop. |
| Weekly drawdown limit (pause 48h)    | **-5.0% equity**| 2.5x daily; covers a string of bad days without immediately killing the strategy. |
| Max consecutive losses (pause 24h)   | **5**           | At 50% win rate, 5 losses in a row = ~3% probability. If it happens, something is regime-broken or strategy-broken. |
| Max trades per day per pair          | **8** (5m), **20** (1m), **3** (1h) | Overtrading guard. |
| Monthly drawdown circuit breaker     | **-10.0%**      | Strategy goes offline pending full review. Do NOT auto-resume. |

All four pause triggers must be implementable as Pine alert suppression flags + an Alpaca account-level state variable. None of this needs anything beyond REST polling.

---

## 3. Per-Timeframe Adjustments

Faster timeframes generate more trades, which compounds variance. Smaller R per trade is required.

| Timeframe | `risk_pct` | `atr_mult` (stop) | Max trades/day | Notes |
|-----------|------------|-------------------|----------------|-------|
| 1m scalp  | **0.25%**  | 1.0 × ATR(14)     | 20             | Slippage eats this alive — see §7. Probably not worth running. |
| 5m intraday | **0.50%** | 1.5 × ATR(14)    | 8              | Baseline. Matches current strategy intent. |
| 1h swing  | **0.75%**  | 2.0 × ATR(14)    | 3              | Larger stop, slower drawdown compounding, can afford more R. |

Total daily risk if every timeframe takes max losses: 0.25×20 + 0.5×8 + 0.75×3 = 11.25%. The §2 daily -2% cap is the actual binding constraint.

---

## 4. Per-Pair ATR Multipliers

Historical ATR% (ATR / price) ranges I'd assume until you measure on your data:

| Pair    | Typical ATR(14) on 5m | Stop atr_mult | Effective stop % at entry |
|---------|----------------------|---------------|---------------------------|
| BTCUSD  | 0.10% – 0.20%        | **1.5**       | ~0.15% – 0.30%            |
| XRPUSD  | 0.30% – 0.80%        | **1.8**       | ~0.54% – 1.44%            |

XRP gets a slightly wider multiplier because alt ATR underestimates true tail volatility (XRP can do 5% candles on news). BTC is the cleaner instrument.

**Action item:** before going live, run a 90-day rolling ATR% on both pairs at each TF and confirm these multipliers produce stop distances in the 0.2% – 2% range. If you see <0.1% or >3% stops, the multiplier is wrong for that regime.

---

## 5. Correlation Risk — Crucial

BTC and XRP have rolling 30-day correlation typically **0.65 – 0.85**. They are not independent bets. Two simultaneous longs = roughly **1.4 effective bets**, not 2.

### Rule: Cap total *crypto* notional at 40% of account equity, regardless of how many signals fire.

```
sum(open_position_notional for p in crypto_pairs) <= 0.40 * equity
```

If BTC long is already open at 25% notional and XRP fires, the XRP entry is capped at 15% notional (which after the §4 sizing math may mean: don't take it).

### Rule: If BTC stops out, suppress XRP entries for the next 30 minutes.

The signal that broke BTC is probably about to break XRP too. This is "second-level thinking" — the BTC stop is information, not just an event.

---

## 6. Kill-Switch Triggers

All implementable as Pine alert-suppression flags + Alpaca state polling.

| Trigger                                          | Action                                                    |
|--------------------------------------------------|-----------------------------------------------------------|
| Daily loss ≤ -2.0%                               | Block new entries; let open positions run to stop/target. |
| Weekly loss ≤ -5.0%                              | Block new entries 48h; manual review required.            |
| Monthly loss ≤ -10.0%                            | Flatten all positions; strategy offline until human re-enables. |
| 5 consecutive losses                             | Block new entries 24h.                                    |
| Single-bar move > 5% on any traded pair (1m or 5m) | Cancel all unfilled pending entries; existing positions keep their stops. |
| Alpaca API error rate > 20% over 5min            | Block new entries until restored; alert via Discord webhook. |
| Account equity < 90% of starting equity          | Flatten all; offline.                                     |
| BTC and XRP both stop out within 15 min          | Suspend strategy 60 min (regime broken).                  |

**Alert channels:** all kill-switch events post to Discord (Risk channel) + SMS via existing MacroDroid bridge. Logged to SQLite for `@auditor` later.

---

## 7. Slippage + Fee Budget

Alpaca crypto: 0% commission but spread + slippage is real.

| Pair    | Typical bid/ask spread | Assumed slippage per side | Round-trip cost |
|---------|------------------------|---------------------------|-----------------|
| BTCUSD  | 1 – 3 bps              | 1 bp                      | **4 – 8 bps**   |
| XRPUSD  | 5 – 15 bps             | 3 bps                     | **16 – 36 bps** |

### Bake into expected value calc

```
EV_per_trade = (win_rate * avg_win_R) - ((1 - win_rate) * 1.0) - (round_trip_cost_R)
```

Where `round_trip_cost_R = round_trip_cost_% / stop_distance_%`. On XRP 1m with a 0.3% stop and 30bps round-trip = **1.0R of pure friction per trade**. That's an entire average loser's worth of cost. The 1m XRP variant is probably **negative EV by construction** — flag for removal unless backtest shows >2R average winners.

### Rule: Don't run a TF/pair combo where round_trip_cost_R > 0.25R.

---

## 8. Catastrophic-Event Handling

| Event                              | Detection                                         | Response                                    |
|------------------------------------|---------------------------------------------------|---------------------------------------------|
| Flash crash (>5% single-bar move)  | Pine condition: `abs(close - open) / open > 0.05` | Cancel all pending entries; existing positions hold their hard stops. |
| Alpaca API down                    | Heartbeat ping every 60s                          | Suspend new entries; alert. Existing stops on broker side (use bracket OCO so they live broker-side). |
| Exchange (Alpaca) halts pair       | Order rejection code                              | Mark pair "halted" for the session; flatten if position exists and price is recoverable. |
| Internet/laptop outage             | Oracle failover — laptop monitors heartbeat       | All stops MUST be broker-resident OCO orders. Pine alerts can fail; broker brackets cannot. |
| Stablecoin depeg / black-swan news | Manual; no auto-detection in v1                   | User pulls the master kill switch (one-click "flatten all" button on dashboard). |

**Non-negotiable:** every entry MUST be placed as a bracket OCO (entry + stop + take-profit) so that even if the laptop, the Pine alert, and Oracle all go down simultaneously, the stop sits on Alpaca's side and protects the account. No naked entries.

---

## 9. Live-Go Criteria

Before this (or any) strategy is allowed to touch a non-paper account, **all of the following must be true**:

| Criterion                             | Threshold       | Why |
|---------------------------------------|-----------------|-----|
| OOS Sharpe (12mo rolling)             | **≥ 1.0**       | Below 1, you're not being paid for the risk. |
| OOS profit factor                     | **≥ 1.4**       | Gross wins / gross losses. <1.4 is fragile. |
| OOS trade count                       | **≥ 200**       | Statistical significance. Current strategy probably has <30. |
| OOS max drawdown                      | **≤ 15%**       | If DD > 15% in backtest, expect 20%+ live (slippage tax). |
| OOS win rate                          | **≥ 40%**       | Combined with the avg R, this is the EV floor. |
| Paper-trade duration                  | **≥ 90 days**   | Must include at least one full regime shift (trend → chop or vice versa). |
| Paper-trade trade count               | **≥ 50**        | Plumbing actually working, not just sitting idle. |
| Paper Sharpe vs OOS backtest Sharpe   | **within 30%**  | If paper Sharpe is half the backtest Sharpe, the backtest lied. |
| Max single-day loss in paper          | **≤ 2.5%**      | Kill-switch is actually firing. |
| Pine ↔ Alpaca bracket reconciliation  | **100% match over 30 days** | Every Pine alert produced an Alpaca order at the right size and stop. Zero unexplained gaps. |
| Discord/SMS alerts firing             | **100% on every kill-switch test** | Don't go live with broken alerting. |

**Live promotion sizing:** even after passing all criteria, start live with **10% of intended capital** for 30 days. If that period passes within 30% of paper-equivalent results, scale to 50% for another 30 days, then full capital.

---

## 10. Hand-offs

- **Execution / Pine implementation:** `@executor` — translate §1 sizing formula + §6 kill-switch flags into Pine v5 with `strategy.order` bracket calls.
- **Backtest re-run with ATR stops:** `@executor` — fix the `custom_stoploss` bug, re-run train+OOS, return new metrics for §9 evaluation.
- **Performance audit cadence:** `@auditor` — weekly review of realized vs expected, attribution by pair/TF, slippage tracking.
- **Regime / macro context:** `@macro-strategist` — confirm crypto regime (trending vs chop) before each weekly session start; PullbackTrend is regime-dependent.

---

## 11. Single Most Important Reminder

> "The market can stay irrational longer than you can stay solvent." — Keynes
> "Survive first, win second." — Dalio
> "Risk control is the best route to investment success — not avoiding risk, but understanding it." — Marks

**Your current backtest does not show evidence of an edge. Risk management makes a good strategy survivable. It cannot make a non-edge profitable. Spend 80% of remaining time improving the signal, 20% wiring up this risk frame.**
