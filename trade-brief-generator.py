#!/usr/bin/env python3
"""
Trade Desk brief (every 15 min in RTH) -> ~/02_DATA/trade-brief-cache.json.

Token hotfix (2026-10-20): the brief is a python template over the pipeline facts, each line with its
source and ET as_of (STALE when older than 26 h). An LLM adds at most a 2-3 line read, at most once per
ET hour, through ~/bin/llm-route with no settings/MCP (prompt <= 6K chars); the read is reused within
the hour and dropped if it carries a trade verb. Was: a full `claude -p` (whole Claude Code harness)
every 15 minutes.
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
        SELECT p.rank, d.ticker, d.final_band, d.final_confidence, d.curator_thesis, d.asset_class, p.generated_at
        FROM premium_shortlist p
        JOIN dossiers d ON p.dossier_id = d.id
        WHERE p.cycle_id = (SELECT cycle_id FROM premium_shortlist ORDER BY generated_at DESC LIMIT 1)
        ORDER BY p.rank ASC LIMIT 5
    """)


def get_flow_winners(days=3) -> list[dict]:
    from datetime import timedelta
    since = (datetime.now(timezone.utc) - timedelta(days=days)).isoformat()
    return query_db(FLOW_DB, """
        SELECT symbol, option_type, strike, expiry, peak_pct, flow_value, flow_count, why_summary, detected_at
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


READ_MAX_CHARS = 6000
STALE_H = 26
LLM_ROUTE = HOME / "bin" / "llm-route"
_TRADE_VERB = __import__("re").compile(r"\b(BUY|SELL|HOLD|WAIT|TRIM|EXIT|AVOID)\b")


def _asof(ts) -> str:
    """'MM-DD HH:MM ET', plus ' STALE' when older than STALE_H hours; 'as_of unknown' if unparseable."""
    try:
        d = datetime.fromisoformat(str(ts).replace("Z", "+00:00"))
        d = d if d.tzinfo else d.replace(tzinfo=timezone.utc)
    except (TypeError, ValueError):
        return "as_of unknown"
    stale = (datetime.now(timezone.utc) - d).total_seconds() > STALE_H * 3600
    return d.astimezone(ET).strftime("%m-%d %H:%M ET") + (" STALE" if stale else "")


def template_brief(rank, winners, momentum, macro) -> list[str]:
    """Deterministic bullets from the pipeline facts — no LLM."""
    b = []
    if macro:
        pct = f" ({macro['vix_pct']}%ile)" if macro.get("vix_pct") is not None else ""
        b.append(f"Macro: {macro.get('regime','?')} regime, VIX {macro.get('vix') if macro.get('vix') is not None else 'UNAVAILABLE'}{pct}, "
                 f"Fed {macro.get('fed_posture','?')} — src macro_context, {_asof(macro.get('ran_at'))}.")
    else:
        b.append("Macro: UNAVAILABLE (no macro_context row).")
    if rank:
        picks = ", ".join(f"#{r.get('rank')} {r.get('ticker','?')} {r.get('final_band','?')}" for r in rank[:5])
        b.append(f"Shortlist: {picks} — src premium_shortlist, {_asof(rank[0].get('generated_at'))}.")
    else:
        b.append("Shortlist: UNAVAILABLE (no premium_shortlist cycle).")
    if winners:
        w = winners[0]
        b.append(f"Top flow winner (3d): {w.get('symbol','?')} {w.get('option_type','?')} ${w.get('strike','?')} {w.get('expiry','?')} "
                 f"hindsight peak +{float(w.get('peak_pct') or 0):.0f}% (first → highest print seen; winner-only list, "
                 f"not a return or hit rate) — src flow_winners, {_asof(w.get('detected_at'))}.")
    if momentum:
        up = [m["ticker"] for m in momentum if m.get("trend") == "UP" or (m.get("bull_streak") or 0) >= 3]
        down = [m["ticker"] for m in momentum if m.get("trend") == "DOWN" or (m.get("bear_streak") or 0) >= 3]
        if up or down:
            b.append(f"Momentum: bullish {', '.join(up[:4]) or 'none'}; bearish {', '.join(down[:4]) or 'none'} — src ticker_momentum.")
    return [f"{chr(8226)} {x}" for x in b]


def llm_read(bullets: list[str], prev: dict) -> tuple[list[str], str, str | None]:
    """(read lines, status, hour key). Reuses the previous read within the same ET hour."""
    hour = datetime.now(ET).strftime("%Y-%m-%dT%H")
    if prev.get("read_hour") == hour:
        return prev.get("read") or [], prev.get("read_status") or "reused", hour
    prompt = ("You read a trading desk's computed facts. Write 2-3 short lines (max 25 words each) on what "
              "matters most and what to watch. Use only these facts; keep any STALE label. Never write "
              "BUY/SELL/HOLD/WAIT/TRIM/EXIT/AVOID or a confidence %.\n\nFACTS:\n" + "\n".join(bullets))[:READ_MAX_CHARS]
    try:
        r = subprocess.run([str(LLM_ROUTE), "-p", prompt, "--model", "sonnet", "--strict-mcp-config",
                            "--setting-sources", ""], capture_output=True, text=True, timeout=90,
                           cwd=str(HOME), env={k: v for k, v in os.environ.items() if k != "ANTHROPIC_API_KEY"})
    except (subprocess.TimeoutExpired, OSError) as e:
        return [], f"unavailable ({type(e).__name__})", hour
    if r.returncode != 0:
        return [], "unavailable (" + ((r.stderr or r.stdout or "").strip().splitlines() or ["error"])[-1][:120] + ")", hour
    lines = [x.strip().lstrip("•-* ").strip() for x in r.stdout.splitlines() if x.strip()][:3]
    if any(_TRADE_VERB.search(x) for x in lines):
        return [], "dropped (trade verb in LLM read)", hour
    return [f"{chr(8226)} Read (LLM, interpretation only): {x}" for x in lines], "ok", hour


def main():
    if not is_market_hours():
        print("[skip] Outside market hours", file=sys.stderr)
        sys.exit(0)

    print("[trade-brief] Gathering pipeline data…", file=sys.stderr)
    rank    = get_flow_rank()
    winners = get_flow_winners(3)
    momentum = get_momentum()
    macro   = get_macro()

    bullets = template_brief(rank, winners, momentum, macro)
    try:
        prev = json.loads(BRIEF_CACHE.read_text())
    except (OSError, ValueError):
        prev = {}
    read, read_status, read_hour = llm_read(bullets, prev)
    print(f"[trade-brief] template {len(bullets)} lines; LLM read {read_status}", file=sys.stderr)
    brief_text = "\n".join(bullets + read)
    status, error = "ok", None

    output = {
        "brief": brief_text,
        "bullets": bullets + read,
        "engine": "python template + hourly LLM read",
        "read": read, "read_status": read_status, "read_hour": read_hour,
        "generated_at": datetime.now(timezone.utc).isoformat(),
        "status": status,
        "error": error,
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
