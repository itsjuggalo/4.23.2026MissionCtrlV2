#!/usr/bin/env python3
"""data_freshness_auditor.py — daily "is every page's data actually fresh?" audit.

Walks every desk_pipeline.sqlite table and every page-consumed JSON feed, computes a
weekend-aware age, and grades each source OK / STALE / ORPHANED / UNIMPLEMENTED / EMPTY / MISSING.
STALE (a live source with a live consumer that stopped updating) pings Telegram via
ping_mike.py. ORPHANED (no cron, no page consumer) is reported but never alerts —
a dead table isn't an incident. UNIMPLEMENTED (schema exists, no producer was ever built)
is likewise reported, never alerted.

Alert-only. Never writes to the pipeline DB, never touches trading behaviour.

Cron: 06:45 ET daily (before the 09:30 open, so weekend carryover is caught early).

Usage:
    data_freshness_auditor.py [--dry-run]   # audit + report.json write happen either
                                             # way; --dry-run only skips the Telegram
                                             # send + alert_gate mark_sent
"""
import argparse
import json
import sqlite3
import subprocess
import sys
from datetime import datetime, time as dtime, timedelta, timezone
from pathlib import Path
from zoneinfo import ZoneInfo

sys.path.insert(0, str(Path.home() / "05_AUTOMATION" / "scripts"))
from lib.alert_gate import should_send, mark_sent  # noqa: E402

ET = ZoneInfo("America/New_York")
DB = Path.home() / "LapClaw" / "pipeline" / "desk_pipeline.sqlite"
REPORT = Path.home() / ".openclaw" / "workspace" / "directives" / "freshness_audit_report.json"
PING_MIKE = Path.home() / "scripts" / "ping_mike.py"
ALERT_GATE_KEY = "data_freshness"
ALERT_REPEAT_AFTER = 24 * 3600   # 2026-09-15: same stale list no longer re-pings every run

MH = "market_hours"   # age discounts weekend hours (producer only runs Mon-Fri)
ALL = "calendar"      # producer runs every day; weekends count against it

# (table, ts_column, mode, max_age_h, note)
# max_age_h is derived from the producer's real cron interval (~2-3x it), see note.
TABLES = [
    ("agent_call_log",       "started_at",   MH,  26,  "desk-cycle */15 market hours"),
    ("agent_weights",        "last_adjusted", ALL, 192, "weight_learning.py weekly Sun 04:00"),
    ("cycle_metadata",       "started_at",   MH,  26,  "desk-cycle */15 market hours"),
    ("decipher_audit",       "computed_at",  MH,  26,  "run_decipher.sh :00/:30 market hours"),
    ("decipher_picks",       "created_at",   MH,  120, "run_decipher.sh; picks only when a candidate qualifies"),
    ("dossiers",             "ran_at",       MH,  26,  "desk-cycle floor 3/4"),
    ("insider_transactions", "fetched_at",   MH,  26,  "insiders_fetch.py 08/12/16 weekdays"),
    ("institutional_holdings", "fetched_at", MH,  30,  "institutions_fetch.py 06:30 weekdays (13F content is quarterly by law — fetch cadence is what's graded)"),
    ("lane_findings",        "ran_at",       MH,  26,  "desk-cycle floor 3 lanes"),
    ("macro_context",        "ran_at",       MH,  26,  "desk-cycle macro floor"),
    ("pipeline_metrics",     "collected_at", MH,  26,  "pipeline_metrics.py per desk cycle"),
    ("policy_events",        "fetched_at",   ALL, 26,  "policy_events_fetch.py 07:00/19:00 daily"),
    ("premium_shortlist",    "generated_at", MH,  26,  "desk-cycle promotion step"),
    ("raw_candidates",       "created_at",   MH,  26,  "desk-cycle floor 1 ingest"),
    ("rd_outputs",           "created_at",   MH,  168, "event-driven: autoresearch / R&D agents"),
    ("ticker_momentum",      "updated_at",   MH,  26,  "ticker_momentum.py per desk cycle"),
    ("unified_contracts",    "built_at",     MH,  26,  "run_desk_flow.sh every 5 min market hours"),
    ("vetoed_candidates",    "vetoed_at",    MH,  26,  "desk-cycle veto step"),
]

# Tables with no live cron producer AND no missionctrl page consumer (verified by grep).
# Reported for visibility, never alerted on.
ORPHANED = {
    "flow_candidates":                 "superseded by unified_contracts; no cron, no page reads it",
    "yfinance_closes":                 "superseded by the fmp/ainvest quote path; no cron, no page reads it",
    "miss_audit_t1_candidates":        "miss_audit.py exists but was never cronned; no page reads it",
    "miss_audit_missed_winner_report": "miss_audit.py exists but was never cronned; no page reads it",
    "position_state":                  "decipher position cache; empty, rebuilt on demand",
    "preseason_checklist":             "one-off manual checklist, not a feed",
    # 2026-09-27: three producers died for good — they were STALE in the 06:45 ping every day.
    "decipher_exits":                  "position-close rows from the Alpaca paper executor, retired 2026-08-11 (last row 08-07); advisory exits now live in decision/decipher_exits.json",
    "historical_outcomes":             "decipher REALIZED P&L mirror (outcome_attribution.py) — needs executed fills; Alpaca execution retired 2026-08-11 (last row 08-07)",
    "notification_log":                "floor5 top-3 push log — its notify_bus.py was pruned 2026-08-30 (last row 08-25); floor5 push retired 2026-09-27",
}

# Tables whose schema exists but whose producer was never implemented. Visible, never
# stale, never alerted — building a producer is a feature decision, not a health fix.
UNIMPLEMENTED = {
    "fintwit_calls": "UNIMPLEMENTED / NOT EXPECTED — table created by fintwit_scout.py:251, but no code inserts rows",
}

H = str(Path.home())
# 2026-09-27 limit fixes (longest normal cron gap + margin; the 06:45 audit was flagging these
# every day): volume_radar 10->13 (Sun 20:00->Mon 08:00=12h), decision_scorecard 2->15 (Sat 18:15->
# Sun 08:15=14h), mtf_ta 2->18 (weekday 16:40->09:40=17h), sector_rotation 6->22 MH (14:00->10:00=20h),
# decision_fundamentals 16->26 (weekend 05:30->05:30=24h), dph/psych_cards/replay_drills/markov_regime
# ALL->MH (weekday-only crons).
# (label, path, mode, max_age_h, note)
FILES = [
    ("unified_contracts_high_interest", f"{H}/.openclaw/workspace/directives/unified_contracts_high_interest.json", MH, 30, "high-interest contract feed -> /api/unified-contracts"),
    ("entry_radar",         f"{H}/.openclaw/workspace/directives/entry_radar.json",       ALL,  14, "entry radar feed — RTH premarket/hourly + after-hours/weekend refresh (2026-09-12)"),
    ("dashboard_data",      f"{H}/.openclaw/workspace/directives/dashboard_data.json",    MH,  26, "dashboard rollup"),
    ("market_regime_BTC",   f"{H}/.openclaw/workspace/directives/market_regime_BTC.json", ALL, 10, "regime_detector.py every 4h"),
    ("market_regime",       f"{H}/mission-control/signal-receiver/data/market_regime.json", ALL, 10, "regime_detector.py every 4h"),
    ("daily_report",        f"{H}/mission-control/signal-receiver/data/daily_report.json", ALL, 30, "daily_report.py 23:55 daily"),
    ("spy_scalp_signal",    f"{H}/mission-control/signal-receiver/data/spy_scalp_signal.json", ALL, 4, "spy scalp feed — RTH ORB/VWAP engine + after-hours/weekend --prep mode (2026-09-12)"),
    ("desk2_weekend",       f"{H}/.openclaw/workspace/directives/desk2_weekend.json",        ALL, 60, "desk2 weekend review, Sat 11:00 + Sun 19:00 ET (2026-09-12)"),
    ("desk2_nollm",         f"{H}/.openclaw/workspace/directives/desk2_nollm.json",          MH,  26, "desk2 NO-LLM shadow ranked table, every cycle 9:37-15:37 ET weekdays (2026-09-13)"),
    ("fmp_market",          "/AIWorkWSL/web/missionctrl/data/fmp_market.json",            ALL,  6, "FMP market snapshot, hourly"),
    ("markov_regime",       "/AIWorkWSL/web/missionctrl/data/markov_regime.json",         MH,  26, "markov regime snapshot — 09:00 ET M-F only (2026-09-27: was ALL/10h -> STALE every weekend)"),
    ("volume_radar",        "/AIWorkWSL/web/missionctrl/data/volume_radar.json",          ALL, 13, "volume radar snapshot — RTH pace scan + after-hours/weekend movers (2026-09-12)"),
    ("ainvest_themes",      "/AIWorkWSL/web/missionctrl/data/ainvest-themes.json",        MH,  26, "ainvest theme scrape"),
    ("watchlist_signals",   "/AIWorkWSL/web/missionctrl/data/watchlist-signals.json",     MH,  26, "watchlist signal scan"),
    ("strategy_compare",    "/AIWorkWSL/web/missionctrl/data/strategy_compare.json",      MH,  26, "strategy comparison rollup"),
    ("cc_verify",           f"{H}/.openclaw/data/cc-verify/latest.json",                  ALL,  14, "Command Center independent verifier (yfinance/signal8) — pre-open/post-open/post-close/weekend cron"),
    # [console-freshness 2026-09-14] CONSOLE pages: verifier + producers it repairs (pipeline/console/verify_console.py)
    ("console_verify",      f"{H}/.openclaw/data/ovtlyr-console/verify/latest.json",     ALL,  16, "console per-page verifier (yfinance/finviz/signal8) — 07:45 daily, 17:15 weekdays, 12:00 weekends"),
    ("console_meta",        f"{H}/.openclaw/data/ovtlyr-console/latest/meta.json",       ALL,  50, "console nightly refresh (bars+compute) 16:30 weekdays + Sun 07:30 --full; Sat gap ≈39h"),
    ("console_mentions",    f"{H}/.openclaw/data/ovtlyr-console/latest/mentions.json",   ALL,  30, "StockTwits+Reddit mentions 16:12 daily (weekend lines added 2026-09-14)"),
    # [decision-ta 2026-09-14] Decision Hub technical-analysis factor (pipeline/decision/factor_ta.py -> /api/decision/ta)
    ("decision_ta",         f"{H}/.openclaw/data/decision/factors/ta.json",             ALL,  54, "TA decision factor: full run 17:05 M-F + 08:00 Sat, market-block-only refresh 10:35 M-F (touches mtime); Sat->Mon gap ~50.5h, no Sunday run"),
    # [decision-fundamentals 2026-09-14] Decision Hub fundamental-analysis factor (pipeline/decision/factor_fundamentals.py -> /api/decision/fundamentals)
    ("decision_fundamentals", f"{H}/.openclaw/data/decision/factors/fundamentals.json", ALL,  26, "fundamentals decision factor: rolling 1/7-universe refresh 05:30 daily + 18:30 M-F"),
    ("console_finviz_news", f"{H}/.openclaw/data/ovtlyr-console/latest/supplement/finviz_news.json", ALL, 16, "finviz news wire supplement written by verify_console.py"),
    ("console_finviz_sectors", f"{H}/.openclaw/data/ovtlyr-console/latest/supplement/finviz_sectors.json", ALL, 16, "finviz sector/industry perf supplement written by verify_console.py"),
    ("oi_flow_latest",      f"{H}/.openclaw/data/oi-flow/latest.json",                   MH,  30, "OI Flow Yahoo lists 10:05/12:35/15:50 weekdays (console-options-flow)"),
    # [decision-factors 2026-09-14] pipeline/gex producers (CBOE delayed chains + yfinance vol family + calendar rules)
    ("decision_gex",        f"{H}/.openclaw/data/decision/factors/gex.json",              MH,  30, "GEX + vol structure 08:45/10:05/12:05/15:35/16:20 weekdays (pipeline/gex/gex-cron.sh gex)"),
    ("decision_events",     f"{H}/.openclaw/data/decision/factors/events.json",           ALL, 30, "event calendar (witching/OPEX/VIX exp/rebalances/FOMC) 06:00 daily (pipeline/gex/events.py)"),
    ("decision_factor_crypto", f"{H}/.openclaw/data/decision/factors/crypto.json",       ALL,  2, "crypto decision factor (F&G/dominance/stablecoin/funding+OI) — crypto_context.py every 30min, all days"),
    # [cvd 2026-09-14] cumulative volume delta (Mike: "add cumulative volume delta to the command
    # center") — pipeline/cvd/cvd.py, advisory display only. */5 04:00-20:00 ET weekdays
    # (equities+crypto) + */15 all other hours incl. weekends (crypto-only); 1h = 4x the sparsest
    # (15min) cadence.
    ("cvd_latest",           f"{H}/.openclaw/data/cvd/latest.json",                      ALL,  1, "cumulative volume delta — pipeline/cvd/cvd.py every 5min market hours / 15min weekends"),
    # [decision-hub 2026-09-14] combiner scorecard — every 30min 06:00-20:00 ET weekdays + 08:15/12:15/18:15 ET weekends
    ("decision_scorecard",  f"{H}/.openclaw/data/decision/scorecard.json",              ALL,  15, "Decision Hub combiner (pipeline/decision/decision_score.py) — blends factors/*.json -> /api/decision"),
    # [fed-watch 2026-09-14] macro_fed decision factor — 06:30 ET daily + 13:30/14:15 ET weekdays + every 30min on FOMC days
    ("macro_fed_factor",    f"{H}/.openclaw/data/decision/factors/macro_fed.json",      ALL,  20, "Fed/macro watcher (pipeline/fed/fed_watch.py) -> /api/decision/macro_fed, advisory only; longest normal gap is 14:15->06:30 next day (~16h)"),
    # [decision-news 2026-09-14] news/sentiment/catalyst decision factor — */30 06:00-20:00 ET weekdays, hourly 21:00-05:00 ET weekdays + all day weekends
    ("decision_news_factor", f"{H}/.openclaw/data/decision/factors/news.json",           ALL, 1.5, "News/sentiment/catalyst factor (pipeline/decision/factor_news.py) -> /api/decision/news, advisory only; worst normal gap is the 05:00->06:00 ET weekday hourly->30min handoff (~1h)"),
    # [decision-catalysts 2026-09-14] catalyst -> ticker -> industry/sector propagation factor (pipeline/decision/factor_catalysts.py -> /api/decision/catalysts) — ADVISORY, not in market blend until backtest fits it
    ("decision_catalysts",  f"{H}/.openclaw/data/decision/factors/catalysts.json",        ALL,  26, "catalyst propagation factor: :20/:50 06-19 ET weekdays + 22:20 weekdays + 08:05 Sat/Sun; longest normal gap Sat 08:05 -> Sun 08:05 = 24h"),
    # [market-hours 2026-09-14] weekend/pre-/after-hours session-price consistency (pipeline/market_hours/)
    ("session_prices",      f"{H}/.openclaw/data/market-hours/session_prices.json",     ALL,  10, "canonical KPI/marquee/console price+session producer — */5min PRE(4-9:30)/AFTER(16-20) weekdays, hourly weekends; longest normal gap is weekday CLOSED overnight ~8h"),
    ("session_consistency", f"{H}/.openclaw/data/market-hours/consistency.json",        ALL,  10, "session_prices.py vs /api/market, /api/crypto, mc-market-cache.json, console symbols.json — every 30min PRE/AFTER weekdays, hourly weekends"),
    # [autoheal 2026-09-14] data-health self-repair loop (pipeline/autoheal/autoheal.py -> /api/autoheal)
    ("autoheal_latest",     f"{H}/.openclaw/data/autoheal/latest.json",                 ALL,   1, "autoheal cron */15min — re-runs the producer for any stale/dead /api/data-health row it has a registry.py entry for"),
    # [darkpool 2026-09-14] free off-exchange/dark-pool layer (pipeline/darkpool/*.py) — FINRA Reg
    # SHO off-exchange share + SqueezeMetrics DIX 18:45/19:10 ET weekdays + 08:15 Sat catch-up,
    # FINRA ATS weekly venue share 07:30 ET Tue. Advisory display only. 64h = Sat 08:15 catch-up
    # -> Mon 18:45 gap (~58.5h) + margin.
    ("darkpool_latest",      f"{H}/.openclaw/data/darkpool/latest.json",                 ALL,  64, "dark pool layer (pipeline/darkpool/darkpool-cron.sh) -> /api/darkpool, advisory only"),
    ("dph_latest",           f"{H}/.openclaw/data/darkpool/dph/latest.json",             MH,   14, "darkpoolheatmap.com poll (pipeline/darkpool/dph_scrape.py) every 30min market hours, advisory only"),
    ("news_snr_latest", f"{H}/.openclaw/data/decision/news_snr.json", ALL, 2, "news signal-to-noise scorer (pipeline/decision/news_snr.py) hourly, advisory only"),
    ("mtf_ta_latest",        f"{H}/.openclaw/data/decision/mtf_ta.json",                 ALL,  18, "multi-timeframe TA for relay tickers (pipeline/decision/mtf_ta.py) hourly market hours, advisory only"),
    # [structure-first 2026-09-15] rebound detector hourly 09:43-16:43 + 16:48 ET weekdays -> Fri 16:48 -> Mon 09:43 gap (~65h) + margin
    ("rebound_setup_latest", f"{H}/.openclaw/data/decision/rebound_setup.json",          ALL,  68, "structure-first rebound detector (pipeline/decision/rebound_setup.py) hourly market hours, advisory only"),
    # macro reaction 07:00 + 09:05 + 16:40 ET weekdays -> Fri 16:40 -> Mon 07:00 gap (~62.5h) + margin
    ("macro_reaction_latest", f"{H}/.openclaw/data/decision/macro_reaction.json",        ALL,  66, "macro expectations-vs-reaction tracker (pipeline/decision/macro_reaction.py) 3x/day weekdays, advisory only"),
    # [decipher-repurpose 2026-09-15] ADVISORY layer that replaced the retired Alpaca paper executor (pipeline/decipher/)
    ("decipher_rank",        f"{H}/.openclaw/data/decision/decipher_rank.json",          ALL,  66, "decipher ranked list (decipher_publish.py, run_decipher.sh step 5) 30-min RTH weekdays -> /api/decipher-rank; 66h rides the weekend gap"),
    ("decipher_grades",      f"{H}/.openclaw/data/decision/decipher_grades.json",        ALL,  76, "decipher grader (decipher_grader.py) 16:40 ET weekdays -> decipher_outcomes + grades by composite decile; 76h rides the weekend gap"),
    ("decipher_exits",       f"{H}/.openclaw/data/decision/decipher_exits.json",         ALL,  66, "decipher exit advisor (decipher_exit_advisor.py) */10 RTH weekdays -> exit LEVELS for journal fills; never places orders"),
    ("decision_decipher",    f"{H}/.openclaw/data/decision/factors/decipher.json",       ALL,  66, "decision factor #9 decipher (pipeline/decision/factor_decipher.py) 30-min RTH weekdays -> /api/decision"),
    # [portfolio-retired 2026-09-12] producer retired (refresh-holdings.sh/wallets-refresh.sh cron) — file will never update again
    # ("unified_book",        f"{H}/portfolio/unified_book.json",                           ALL,  6, "REAL MONEY book (RH + Coinbase) -> portfolio/risk pages"),
    # ("robinhood_holdings",  f"{H}/portfolio/robinhood_holdings.json",                     MH,  26, "REAL MONEY RH equity/options positions"),
    # ("coinbase_holdings",   f"{H}/portfolio/coinbase_holdings.json",                      ALL,  6, "REAL MONEY Coinbase positions"),
    # [portfolio-retired 2026-09-12] producer (pre_breakout_scan.py) cron retired — file will never update again
    # ("pullback_watchlist",  f"{H}/portfolio/pullback_watchlist.json",                     MH,  26, "pullback watchlist feed"),
    # [gate-trend-psych-replay 2026-09-15] holdings-free rewrite — 4-page fix for
    # GatePage/TrendBoardPage/PsychCardsPage/ReplayPage (unified_book.json dead,
    # never re-read). psych_cards.json + replay_drills.json read ONLY mike.sqlite
    # fills/round_trips (closed trade history, not holdings) + yfinance.
    ("psych_cards",         f"{H}/portfolio/psych_cards.json",                            MH,   26, "psych_cards_refresh.py daily -> live_stats block; deck's cards are static canon (not tracked here)"),
    ("replay_drills",       f"{H}/portfolio/replay_drills.json",                          MH,   26, "replay_drills_refresh.py daily, drives real_coach/replay_drills.py"),
    # [sector-rotation 2026-09-15] SectorRotationPage/route had zero file/fetch backing on
    # record (B5/N5) — sector_rotation_detector.py now also writes this file (route's live
    # yfinance fetch kept as fallback). Cron 10:00/12:00/14:00 ET M-F only; longest normal
    # gap is Fri 14:00 -> Mon 10:00 (~68h).
    ("sector_rotation",     f"{H}/.openclaw/data/sector-rotation/latest.json",             MH,  22, "sector_rotation_detector.py 10:00/12:00/14:00 ET M-F -> /api/sector-rotation"),
]


def latest_trading_day_start():
    """Start-of-day (ET, naive) for today's market day, or Friday's on a weekend.
    Same weekday-only fallback firebase_signal_relay.py uses — no holiday calendar."""
    now_et = datetime.now(ET)
    day = now_et.date()
    if day.weekday() == 5:
        day -= timedelta(days=1)
    elif day.weekday() == 6:
        day -= timedelta(days=2)
    return datetime.combine(day, dtime.min)


def parse_ts(raw):
    """Tolerant parser for the ~6 timestamp shapes in this DB. Naive -> UTC."""
    if raw is None:
        return None
    s = str(raw).strip()
    if not s:
        return None
    for suffix in (" EDT", " EST", " UTC"):
        if s.endswith(suffix):
            s = s[: -len(suffix)].strip()
    s = s.replace("Z", "+00:00")
    # "+0000" / "-0400" -> "+00:00" / "-04:00"
    if len(s) > 5 and s[-5] in "+-" and s[-5:].lstrip("+-").isdigit():
        s = s[:-2] + ":" + s[-2:]
    try:
        dt = datetime.fromisoformat(s)
    except ValueError:
        return None
    return dt.replace(tzinfo=timezone.utc) if dt.tzinfo is None else dt


def weekend_hours_between(start, end):
    """Hours in [start, end] that fall on an ET Saturday or Sunday."""
    total = 0.0
    cur = start.astimezone(ET)
    stop = end.astimezone(ET)
    while cur < stop:
        nxt = min(datetime.combine(cur.date() + timedelta(days=1), dtime.min, ET), stop)
        if cur.weekday() >= 5:
            total += (nxt - cur).total_seconds() / 3600
        cur = nxt
    return total


def grade(ts, mode, max_age_h):
    now = datetime.now(timezone.utc)
    raw_h = (now - ts).total_seconds() / 3600
    eff_h = raw_h - weekend_hours_between(ts, now) if mode == MH else raw_h
    eff_h = max(eff_h, 0.0)
    return raw_h, eff_h, ("OK" if eff_h <= max_age_h else "STALE")


def audit_tables(conn):
    rows = []
    for name, col, mode, max_age_h, note in TABLES:
        rec = {"source": name, "kind": "sqlite", "column": col, "mode": mode,
               "max_age_hours": max_age_h, "note": note}
        try:
            latest, count = conn.execute(
                f"SELECT MAX({col}), COUNT(*) FROM {name}").fetchone()
        except sqlite3.Error as e:
            rows.append({**rec, "status": "ERROR", "detail": str(e)})
            continue
        rec["row_count"] = count
        ts = parse_ts(latest)
        if count == 0 or ts is None:
            rec.update(status="EMPTY", last_update=latest,
                       detail="no rows" if count == 0 else f"unparseable timestamp: {latest!r}")
        else:
            raw_h, eff_h, status = grade(ts, mode, max_age_h)
            rec.update(status=status, last_update=ts.astimezone(ET).isoformat(),
                       age_hours=round(raw_h, 1), effective_age_hours=round(eff_h, 1))
        rows.append(rec)

    for name, why in ORPHANED.items():
        rec = {"source": name, "kind": "sqlite", "status": "ORPHANED", "note": why}
        try:
            rec["row_count"] = conn.execute(f"SELECT COUNT(*) FROM {name}").fetchone()[0]
        except sqlite3.Error:
            rec["row_count"] = None
        rows.append(rec)

    for name, why in UNIMPLEMENTED.items():
        rec = {"source": name, "kind": "sqlite", "status": "UNIMPLEMENTED", "note": why}
        try:
            rec["row_count"] = conn.execute(f"SELECT COUNT(*) FROM {name}").fetchone()[0]
        except sqlite3.Error:
            rec["row_count"] = None
        rows.append(rec)
    return rows


def audit_files():
    rows = []
    for label, path, mode, max_age_h, note in FILES:
        p = Path(path)
        rec = {"source": label, "kind": "file", "path": path, "mode": mode,
               "max_age_hours": max_age_h, "note": note}
        if not p.exists():
            rows.append({**rec, "status": "MISSING"})
            continue
        ts = datetime.fromtimestamp(p.stat().st_mtime, timezone.utc)
        raw_h, eff_h, status = grade(ts, mode, max_age_h)
        rows.append({**rec, "status": status, "last_update": ts.astimezone(ET).isoformat(),
                     "age_hours": round(raw_h, 1), "effective_age_hours": round(eff_h, 1),
                     "size_bytes": p.stat().st_size})
    return rows


def alert(stale, today, dry_run=False):
    """Ping via the shared alert_gate: fingerprint = sorted stale/error/missing source
    ids, 24h cooldown — an UNCHANGED stale list reminds once per 24h instead of once
    every cron run (the old per-day-only dedup re-pinged the identical list every
    single day a multi-day outage ran). A CHANGED list (new source went stale, or one
    recovered) always sends immediately, same as alert_gate's normal 'changed' rule."""
    fp = "|".join(sorted(s["source"] for s in stale))
    ok, why = should_send(ALERT_GATE_KEY, fp, repeat_after=ALERT_REPEAT_AFTER)
    lines = [f"• {s['source']} — {s.get('effective_age_hours', '?')}h old "
             f"(limit {s['max_age_hours']}h)" for s in stale[:12]]
    more = f"\n…+{len(stale) - 12} more" if len(stale) > 12 else ""
    msg = ("⚠️ DATA FRESHNESS — %d stale source(s) on missionctrl:\n%s%s\n"
           "Full report: ~/.openclaw/workspace/directives/freshness_audit_report.json"
           % (len(stale), "\n".join(lines), more))
    if dry_run:
        print(f"[freshness] --dry-run: gate says {'SEND' if ok else 'SUPPRESS'} ({why})\n{msg}", flush=True)
        return False
    if not ok:
        return False
    try:
        sent = subprocess.run(["python3", str(PING_MIKE), msg], timeout=30).returncode == 0
    except Exception:
        sent = False
    if sent:
        mark_sent(ALERT_GATE_KEY, fp)
    return sent


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("--dry-run", action="store_true",
                     help="audit + write report.json as normal, but print (don't send) the alert")
    a = ap.parse_args()
    if not DB.exists():
        print(f"[freshness] DB missing: {DB}", file=sys.stderr)
        return 2
    conn = sqlite3.connect(f"file:{DB}?mode=ro&immutable=0", uri=True, timeout=60)
    try:
        rows = audit_tables(conn) + audit_files()
    finally:
        conn.close()

    order = {"STALE": 0, "ERROR": 1, "MISSING": 2, "EMPTY": 3, "ORPHANED": 4, "UNIMPLEMENTED": 5, "OK": 6}
    rows.sort(key=lambda r: (order.get(r["status"], 9), r["source"]))
    counts = {}
    for r in rows:
        counts[r["status"]] = counts.get(r["status"], 0) + 1

    now_et = datetime.now(ET)
    report = {
        "generated_at": now_et.isoformat(),
        "trading_day": latest_trading_day_start().date().isoformat(),
        "counts": counts,
        "sources": rows,
    }
    REPORT.parent.mkdir(parents=True, exist_ok=True)
    REPORT.write_text(json.dumps(report, indent=2))

    print(f"=== DATA FRESHNESS AUDIT — {now_et:%Y-%m-%d %H:%M %Z} "
          f"(trading day {report['trading_day']}) ===")
    print(f"{'STATUS':<9} {'SOURCE':<34} {'AGE(h)':>8} {'EFF(h)':>8} {'LIMIT':>6}  LAST UPDATE")
    for r in rows:
        age = r.get("age_hours")
        eff = r.get("effective_age_hours")
        detail = r.get("last_update") or r.get("detail") or r.get("note") or ""
        print(f"{r['status']:<9} {r['source']:<34} "
              f"{age if age is not None else '-':>8} {eff if eff is not None else '-':>8} "
              f"{r.get('max_age_hours', '-'):>6}  {str(detail)[:60]}")
    print("\n" + "  ".join(f"{k}={v}" for k, v in sorted(counts.items())))
    print(f"report -> {REPORT}")

    stale = [r for r in rows if r["status"] in ("STALE", "MISSING", "ERROR")]
    if stale:
        sent = alert(stale, now_et.date().isoformat(), dry_run=a.dry_run)
        print(f"alert: {'sent to Telegram' if sent else ('dry-run' if a.dry_run else 'not sent (gated/cooldown or ping failed)')}")
    return 0


if __name__ == "__main__":
    sys.exit(main())
