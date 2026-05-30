# Discord Flow Pipeline — Redesign Spec

Status: draft, on branch `claude/pipeline-discord-messages-C5Wvw`.
Replaces the current per-event firehose across 27 webhooks in `Option-Signals-Scraper/discord_relay.py`.

## Problem

The current relay treats every flow alert as equally interesting and posts a
~11-field embed for each one. Symptoms:

- Same contract gets re-posted on every poll cycle until its dedup key flips.
- "Repeater" / "Unusual" / "Huge" / "Weekly" routing is binary on `AlertType`,
  with no relative context (is `$52K premium` big *for this ticker*?).
- 27 webhooks fragment attention with no clear "look here first" channel.
- The tier-emoji celebration logic (`Lightning Strike`, `Weekly Magic`, etc.)
  only fires *after* a trade has paid off — too late to act on.

## Approach

Move the tier judgement to the **alert moment**, using a per-event score that
combines absolute size, ticker-relative size, contract structure (DTE,
moneyness, sweep), and repeat behaviour. Then route by score, not by AlertType.

Pipeline:

```
raw alert/live row
       │
       ▼
   normalize  ──► FlowEvent  (canonical schema, source-agnostic)
       │
       ▼
   coalescer  ──► (is_first, count, cumulative_premium)
       │
       ▼
   scoring    ──► Score(value, tier, components)
       │
       ▼
   router     ──► {instant | digest | drop}
       │
       ▼
  embed_builder ──► Discord embed (single or digest)
       │
       ▼
       webhook
```

Each stage is a pure function (except coalescer, which holds bounded state)
so it can be unit-tested and shadow-run alongside the existing senders.

## Modules (`pipeline/discord/`)

| File | Responsibility |
|---|---|
| `normalize.py` | Convert `flow_alerts_today` / `flow_live_last100` rows → `FlowEvent` dataclass. Source-of-truth for the canonical schema. |
| `baseline.py` | `BaselineProvider` interface + `OnlineEWMABaselineProvider` (per-ticker EWMA of log-premium → z-score → percentile) + `StaticBaselineProvider` fallback. Persists to JSON between runs. |
| `scoring.py` | `score(event, baseline, coalescer_state) -> Score`. Pure function. |
| `coalescer.py` | `Coalescer(window_seconds=600)` — observes events keyed by `(symbol, strike, opt_type, expiry)`. Returns hit count + cumulative premium within window. |
| `digest.py` | `DigestBuffer.add(event, score)` + `flush(top_k)` — emits the top-K events in a window, grouped by symbol. Used by the periodic digest poster. |
| `embed_builder.py` | `build_instant_embed(event, score)` and `build_digest_embed(buckets)` → Discord embed dicts. |
| `router.py` | `route(score) -> Route` — one of `INSTANT`, `DIGEST`, `DROP`. Replaces `get_flow_channel`. |
| `integration_example.py` | Shows how `discord_relay.py` on Oracle would wire these modules in, with shadow-mode posting. |

## Scoring formula (v1)

`Score.value ∈ [0, 100]`. Five components, additive, clipped:

| Component | Range | Logic |
|---|---|---|
| `premium_pct`  | 0–40 | `min(40, percentile_30d * 0.4)` — how big is this premium vs ticker's 30d distribution? |
| `unusualness`  | 0–20 | `min(20, vol_to_oi * 10)` where `vol_to_oi = Volume / max(OI, 1)`. >1 means today's vol already exceeded OI. |
| `aggressor`    | -5–15 | +15 if `BlockType == SWEEP` AND `BidAskType == A` for calls or `B` for puts (aligned aggression). +5 if bullish call-at-ask. -5 if direction conflicts (e.g. call-at-bid). |
| `dte_bucket`   | -5–15 | 0-7d → +15 (scalp), 8-30d → +10 (swing), 31-90d → +5, >90d → 0, expired → -5. |
| `repeater`     | 0–10  | `min(10, (hits_in_10min - 1) * 5)`. First hit = 0, second = +5, third = +10. |

### Tiers

| Score | Tier | Route | Channel |
|---|---|---|---|
| ≥85 | `SCALP` | INSTANT | `#flow-instant` (new, replaces firehose for high-conviction) |
| 65–84 | `SWING` | INSTANT (degraded) or DIGEST head | `#flow-swing` |
| 45–64 | `WATCH` | DIGEST tail | `#flow-digest` (top-K every 10min) |
| <45 | `SKIP` | DROP | — (still logged to SQLite via existing writers) |

### Tunable thresholds

All thresholds live in `pipeline/discord/config.py` (not yet committed — start
hard-coded in `scoring.py` and `router.py`, extract once shadow data validates
the formula).

## Embed schema

### Instant (one event)

```
{tier_emoji} {SYMBOL} {STRIKE}{C|P} {MM/DD}  +{score}
──
${premium} premium · {pct}th pct vs {SYM} 30d
Vol {V} / OI {OI} · {V/OI}x · {DTE}d · spot ${spot} ({moneyness:+.1%})
{aggressor_marker}  {repeater_marker}
──
footer: score breakdown · {component_scores}
```

- Color: tier-tinted (calls = green family, puts = red family; brightness from tier).
- No more 11-field grid. One title, one description, one footer.

### Digest (top-K)

```
📊 Flow Digest — last 10 min ({n} events scored, {k} surfaced)
──
🔥 TSLA 480C 0DTE — score 91 (×3 hits, $230K cum)
📈 NVDA 145P 5/30 — score 78
👀 AAPL 230C 6/13 — score 67
... up to K=10, grouped by symbol where multiple strikes hit
──
footer: next digest in 10:00 · drop threshold 45
```

## Webhook consolidation

| Today | After |
|---|---|
| `flow_alerts`, `flow_live`, `flow_huge`, `flow_unusual`, `flow_repeaters`, `flow_weekly`, `flow_etf` (7) | `flow_instant` (1) — score ≥85 |
| `scalp_signals`, `swing_signals` (from picks pipeline, unchanged) | unchanged |
| Various mirror channels (`flow_messages`, `flow_trade_results`) | unchanged for now |
| — | `flow_digest` (1, new) — top-K every 10min |
| — | `flow_v2_shadow` (1, new) — receives ALL routed events during shadow run, for comparison |

Net: 27 → 22 active. The retired 5 keep receiving the old firehose during the
shadow window so nothing is lost.

## Rollout

1. **Land modules + tests in this repo.** Done in this branch.
2. **Rsync `pipeline/discord/` to Oracle**: `~/mission-control-restored/Option-Signals-Scraper/pipeline/discord/`.
3. **Add shadow webhook** to `WEBHOOKS` dict in `discord_relay.py` (one line).
4. **Add shadow call** at the end of `relay_flow_alerts` / `relay_flow_live`:
   ```python
   from pipeline.discord import normalize, scoring, embed_builder, router
   evt = normalize.from_flow_alert(alert, quote)
   sc = scoring.score(evt, baseline, coalescer)
   r = router.route(sc)
   if r != router.Route.DROP:
       post_embed("flow_v2_shadow", embed_builder.build_instant_embed(evt, sc))
   ```
   No removal of existing code yet — purely additive.
5. **Run digest scheduler** as a new PM2 process (see `integration_example.py`).
6. **Compare for 24–48h.** Use the auditor to correlate `flow_v2_shadow` scores
   with subsequent peak gains (does score ≥85 actually correlate with the
   trade printing 25%+?).
7. **If calibration holds**, retire the 5 listed webhooks, point `flow_instant`
   at the same Discord channel that currently shows `flow_alerts`, and turn off
   the old `relay_flow_alerts` posts to those 5.

## Out of scope for v1

- ML-learned scoring weights (the auditor outputs are the training signal, but
  start with hand-tuned weights).
- Earnings/catalyst context line (needs Finnhub calendar plumbing — separate ticket).
- IV rank in the context line (need historical IV stream — separate ticket).
- Edit-in-place for repeaters (Discord webhooks can edit, but adds complexity;
  start with coalescer + digest grouping).

## Files in this PR

- `PIPELINE_DISCORD_REDESIGN.md` — this doc
- `pipeline/discord/normalize.py`
- `pipeline/discord/baseline.py`
- `pipeline/discord/scoring.py`
- `pipeline/discord/coalescer.py`
- `pipeline/discord/digest.py`
- `pipeline/discord/embed_builder.py`
- `pipeline/discord/router.py`
- `pipeline/discord/integration_example.py`
- `pipeline/discord/tests/test_normalize.py`
- `pipeline/discord/tests/test_scoring.py`
- `pipeline/discord/tests/test_coalescer.py`
- `pipeline/discord/tests/test_router.py`
