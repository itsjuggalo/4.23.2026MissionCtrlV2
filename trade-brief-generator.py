#!/usr/bin/env python3
"""
Trade Desk — 5-minute AI brief generator (zero API token cost).
Gathers data from pipeline SQLite DBs, calls the claude CLI,
writes output to ~/02_DATA/trade-brief-cache.json.
Only runs during US market hours (9:25 AM – 4:05 PM ET, Mon–Fri).
"""

import json
import os
import subprocess
import sqlite3
import sys
from datetime import datetime, timezone
from pathlib import Path
from zoneinfo import ZoneInfo

HOME = Path.home()
ET = ZoneInfo("America/New_York")

FLOW_DB     = HOME / "02_DATA/flow-data/flow.db"
PIPELINE_DB = HOME / "LapClaw/pipeline/desk_pipeline.sqlite"
LEDGER_DB   = HOME / "LapClaw/pipeline/trade_ledger.sqlite"
BRIEF_CACHE = HOME / "02_DATA/trade-brief-cache.json"


def is_market_hours() -> bool:
    now = datetime.now(ET)
    if now.weekday() >= 5:  # Saturday/Sunday
        return False
    t = now.time()
    from datetime import time
    return time(9, 25) <= t <= time(16, 5)


def query_db(db_path: Path, sql: str, params=()) -> list[dict]:
    if not db_path.exists():
        return []
    try:
        con = sqlite3.connect(f"file:{db_path}?mode=ro", uri=True)
        con.row_factory = sqlite3.Row
        cur = con.execute(sql, params)
        rows = [dict(r) for r in cur.fetchall()]
        con.close()
        return rows
    except Exception as e:
        print(f"[warn] DB query failed {db_path}: {e}", file=sys.stderr)
        return []


def get_flow_rank() -> list[dict]:
    return query_db(PIPELINE_DB, """
        SELECT p.rank, d.ticker, d.final_band, d.final_confidence, d.curator_thesis, d.asset_class
        FROM premium_shortlist p
        JOIN dossiers d ON p.dossier_id = d.id
        WHERE p.cycle_id = (SELECT cycle_id FROM premium_shortlist ORDER BY generated_at DESC LIMIT 1)
        ORDER BY p.rank ASC LIMIT 5
    """)


def get_flow_winners(days=3) -> list[dict]:
    from datetime import timedelta
    since = (datetime.now(timezone.utc) - timedelta(days=days)).isoformat()
    return query_db(FLOW_DB, """
        SELECT symbol, option_type, strike, expiry, peak_pct, flow_value, flow_count, why_summary
        FROM flow_winners WHERE detected_at >= ? ORDER BY peak_pct DESC LIMIT 5
    """, (since,))


def get_momentum() -> list[dict]:
    return query_db(PIPELINE_DB, """
        SELECT ticker, streak, trend, bull_streak, bear_streak, avg_confidence_7d
        FROM ticker_momentum
        WHERE trend != 'STEADY' OR streak >= 3
        ORDER BY cycle_count_7d DESC LIMIT 10
    """)


def get_macro() -> dict | None:
    rows = query_db(PIPELINE_DB, "SELECT * FROM macro_context ORDER BY rowid DESC LIMIT 1")
    return rows[0] if rows else None


def get_recent_ledger() -> list[dict]:
    return query_db(LEDGER_DB, """
        SELECT account, ticker, option_type, strike, expiry, fill_price, confidence, exec_ok, cycle_time
        FROM executed_ledger ORDER BY cycle_time DESC LIMIT 5
    """)


def build_prompt(rank, winners, momentum, macro, ledger) -> str:
    lines = ["You are a focused options trading analyst. Given the live pipeline data below, write a concise 5-bullet trading brief for a swing/day trader.\n"]
    lines.append("Rules: each bullet starts with •, max 25 words per bullet, be specific (include tickers/numbers), no fluff.\n")

    if macro:
        lines.append(f"MACRO: Regime={macro.get('regime','?')} | VIX={macro.get('vix','?')} ({macro.get('vix_pct','?')}%ile) | Fed={macro.get('fed_posture','?')}")
        lines.append(f"Rates: {str(macro.get('rates_summary',''))[:120]}\n")

    if rank:
        lines.append("FLOW RANK TOP PICKS (current cycle):")
        for r in rank:
            thesis = str(r.get("curator_thesis") or "").replace("\n", " ")[:80]
            lines.append(f"  #{r['rank']} {r['ticker']} [{r['final_band']}] conf={r['final_confidence']}% | {thesis}")
        lines.append("")

    if winners:
        lines.append("RECENT FLOW WINNERS (≥200% peak returns, last 3 days):")
        for w in winners:
            lines.append(f"  {w['symbol']} {w['option_type']} ${w['strike']} {w['expiry']} → +{w['peak_pct']:.0f}% | ${w['flow_value']:,.0f} premium")
        lines.append("")

    if momentum:
        up = [m["ticker"] for m in momentum if m.get("trend") == "UP" or (m.get("bull_streak") or 0) >= 3]
        down = [m["ticker"] for m in momentum if m.get("trend") == "DOWN" or (m.get("bear_streak") or 0) >= 3]
        if up:   lines.append(f"BULLISH MOMENTUM: {', '.join(up)}")
        if down: lines.append(f"BEARISH MOMENTUM: {', '.join(down)}")
        lines.append("")

    if ledger:
        lines.append("RECENT EXECUTIONS (paper):")
        for t in ledger:
            ok = "✓" if str(t.get("exec_ok","")).lower() == "true" else "✗"
            lines.append(f"  {ok} [{t['account']}] {t['ticker']} {t['option_type']} ${t['strike']} @ ${t['fill_price']} conf={t['confidence']}")
        lines.append("")

    lines.append("\nWrite your 5-bullet brief now:")
    return "\n".join(lines)


def run_claude(prompt: str) -> str:
    # Use claude CLI (subscription — no API token cost).
    # Absolute path: cron's PATH lacks ~/bin, so a bare "claude" raised
    # FileNotFoundError every market-hours tick. "-p" is already non-interactive
    # (the old "--no-interactive" flag is invalid and errored out).
    claude_bin = os.path.expanduser("~/bin/claude")
    if not os.path.exists(claude_bin):
        claude_bin = "claude"  # fall back to PATH for interactive shells
    result = subprocess.run(
        [claude_bin, "-p", prompt],
        capture_output=True, text=True, timeout=60,
        cwd=os.path.expanduser("~"),  # headless claude expects to run from $HOME
        env={**os.environ, "TERM": "dumb"},
    )
    if result.returncode != 0:
        raise RuntimeError(f"claude exited {result.returncode}: {result.stderr[:200]}")
    return result.stdout.strip()


def main():
    if not is_market_hours():
        print("[skip] Outside market hours", file=sys.stderr)
        sys.exit(0)

    print("[trade-brief] Gathering pipeline data…", file=sys.stderr)
    rank    = get_flow_rank()
    winners = get_flow_winners(3)
    momentum = get_momentum()
    macro   = get_macro()
    ledger  = get_recent_ledger()

    prompt = build_prompt(rank, winners, momentum, macro, ledger)

    print("[trade-brief] Calling claude CLI…", file=sys.stderr)
    brief_text = run_claude(prompt)

    # Parse bullets
    bullets = [line.strip() for line in brief_text.split("\n") if line.strip().startswith("•")]

    output = {
        "brief": brief_text,
        "bullets": bullets,
        "generated_at": datetime.now(timezone.utc).isoformat(),
        "status": "ok",
        "inputs": {
            "rank_picks": len(rank),
            "winners": len(winners),
            "momentum_tickers": len(momentum),
            "macro_regime": macro.get("regime") if macro else None,
        },
    }

    BRIEF_CACHE.parent.mkdir(parents=True, exist_ok=True)
    BRIEF_CACHE.write_text(json.dumps(output, indent=2, default=str))
    print(f"[trade-brief] Written → {BRIEF_CACHE}", file=sys.stderr)


if __name__ == "__main__":
    main()
