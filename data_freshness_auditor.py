#!/usr/bin/env python3
"""data_freshness_auditor.py — daily "is every page's data actually fresh?" audit.

Walks every desk_pipeline.sqlite table and every page-consumed JSON feed, computes a
weekend-aware age, and grades each source OK / STALE / ORPHANED / EMPTY / MISSING.
STALE (a live source with a live consumer that stopped updating) pings Telegram via
ping_mike.py. ORPHANED (no cron, no page consumer) is reported but never alerts —
a dead table isn't an incident.

Alert-only. Never writes to the pipeline DB, never touches trading behaviour.

Cron: 06:45 ET daily (before the 09:30 open, so weekend carryover is caught early).
"""
import json
import sqlite3
import subprocess
import sys
from datetime import datetime, time as dtime, timedelta, timezone
from pathlib import Path
from zoneinfo import ZoneInfo

ET = ZoneInfo("America/New_York")
DB = Path.home() / "LapClaw" / "pipeline" / "desk_pipeline.sqlite"
REPORT = Path.home() / ".openclaw" / "workspace" / "directives" / "freshness_audit_report.json"
PING_MIKE = Path.home() / "scripts" / "ping_mike.py"
ALERT_STATE = Path.home() / ".openclaw" / "state" / "freshness_audit_alerted.json"

MH = "market_hours"   # age discounts weekend hours (producer only runs Mon-Fri)
ALL = "calendar"      # producer runs every day; weekends count against it

# (table, ts_column, mode, max_age_h, note)
# max_age_h is derived from the producer's real cron interval (~2-3x it), see note.
TABLES = [
    ("agent_call_log",       "started_at",   MH,  26,  "desk-cycle */15 market hours"),
    ("agent_weights",        "last_adjusted", ALL, 192, "weight_learning.py weekly Sun 04:00"),
    ("cycle_metadata",       "started_at",   MH,  26,  "desk-cycle */15 market hours"),
    ("decipher_audit",       "computed_at",  MH,  26,  "run_decipher.sh :00/:30 market hours"),
    ("decipher_exits",       "closed_at",    MH,  336, "event-driven: only writes on a position close"),
    ("decipher_picks",       "created_at",   MH,  120, "run_decipher.sh; picks only when a candidate qualifies"),
    ("dossiers",             "ran_at",       MH,  26,  "desk-cycle floor 3/4"),
    ("fintwit_calls",        "ts",           MH,  168, "fintwit-scout 08:30 weekdays"),
    ("historical_outcomes",  "captured_at",  MH,  120, "decipher outcome capture"),
    ("insider_transactions", "fetched_at",   MH,  26,  "insiders_fetch.py 08/12/16 weekdays"),
    ("institutional_holdings", "fetched_at", MH,  30,  "institutions_fetch.py 06:30 weekdays (13F content is quarterly by law — fetch cadence is what's graded)"),
    ("lane_findings",        "ran_at",       MH,  26,  "desk-cycle floor 3 lanes"),
    ("macro_context",        "ran_at",       MH,  26,  "desk-cycle macro floor"),
    ("notification_log",     "sent_at",      MH,  168, "event-driven: only writes when an alert fires"),
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
}

H = str(Path.home())
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
    ("fmp_market",          "/AIWorkWSL/web/missionctrl/data/fmp_market.json",            ALL,  6, "FMP market snapshot, hourly"),
    ("markov_regime",       "/AIWorkWSL/web/missionctrl/data/markov_regime.json",         ALL, 10, "markov regime snapshot"),
    ("volume_radar",        "/AIWorkWSL/web/missionctrl/data/volume_radar.json",          ALL, 10, "volume radar snapshot — RTH pace scan + after-hours/weekend movers (2026-09-12)"),
    ("ainvest_themes",      "/AIWorkWSL/web/missionctrl/data/ainvest-themes.json",        MH,  26, "ainvest theme scrape"),
    ("watchlist_signals",   "/AIWorkWSL/web/missionctrl/data/watchlist-signals.json",     MH,  26, "watchlist signal scan"),
    ("strategy_compare",    "/AIWorkWSL/web/missionctrl/data/strategy_compare.json",      MH,  26, "strategy comparison rollup"),
    # [portfolio-retired 2026-09-12] producer retired (refresh-holdings.sh/wallets-refresh.sh cron) — file will never update again
    # ("unified_book",        f"{H}/portfolio/unified_book.json",                           ALL,  6, "REAL MONEY book (RH + Coinbase) -> portfolio/risk pages"),
    # ("robinhood_holdings",  f"{H}/portfolio/robinhood_holdings.json",                     MH,  26, "REAL MONEY RH equity/options positions"),
    # ("coinbase_holdings",   f"{H}/portfolio/coinbase_holdings.json",                      ALL,  6, "REAL MONEY Coinbase positions"),
    # [portfolio-retired 2026-09-12] producer (pre_breakout_scan.py) cron retired — file will never update again
    # ("pullback_watchlist",  f"{H}/portfolio/pullback_watchlist.json",                     MH,  26, "pullback watchlist feed"),
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


def alert(stale, today):
    """Ping once per source per day so a multi-day outage doesn't spam."""
    try:
        seen = set(json.loads(ALERT_STATE.read_text()))
    except Exception:
        seen = set()
    new = [s for s in stale if f"{s['source']}@{today}" not in seen]
    if not new:
        return False
    lines = [f"• {s['source']} — {s.get('effective_age_hours', '?')}h old "
             f"(limit {s['max_age_hours']}h)" for s in new[:12]]
    more = f"\n…+{len(new) - 12} more" if len(new) > 12 else ""
    msg = ("⚠️ DATA FRESHNESS — %d stale source(s) on missionctrl:\n%s%s\n"
           "Full report: ~/.openclaw/workspace/directives/freshness_audit_report.json"
           % (len(new), "\n".join(lines), more))
    try:
        ok = subprocess.run(["python3", str(PING_MIKE), msg], timeout=30).returncode == 0
    except Exception:
        ok = False
    if ok:
        seen |= {f"{s['source']}@{today}" for s in new}
        ALERT_STATE.parent.mkdir(parents=True, exist_ok=True)
        ALERT_STATE.write_text(json.dumps(
            sorted(k for k in seen if k.endswith(today))))
    return ok


def main():
    if not DB.exists():
        print(f"[freshness] DB missing: {DB}", file=sys.stderr)
        return 2
    conn = sqlite3.connect(f"file:{DB}?mode=ro&immutable=0", uri=True, timeout=60)
    try:
        rows = audit_tables(conn) + audit_files()
    finally:
        conn.close()

    order = {"STALE": 0, "ERROR": 1, "MISSING": 2, "EMPTY": 3, "ORPHANED": 4, "OK": 5}
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
        sent = alert(stale, now_et.date().isoformat())
        print(f"alert: {'sent to Telegram' if sent else 'not sent (already pinged today or ping failed)'}")
    return 0


if __name__ == "__main__":
    sys.exit(main())
