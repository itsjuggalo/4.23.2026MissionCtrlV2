#!/usr/bin/env python3
"""Builds a live market context string for injection into bot system prompts.

Call get_live_context() in any Telegram bot's handle_message() to prepend
fresh flow + signal data to the system prompt. Fails silently if DBs are
unavailable (market closed, path differs, etc.).
"""
import json
import sqlite3
from datetime import datetime, timedelta, timezone
from pathlib import Path

FLOW_DB = Path.home() / "flow-data" / "flow.db"
SIGNALS_JSON = (Path.home() / "mission-control-restored"
                / "Option-Signals-Scraper" / "data" / "analyst_signals_merged.json")


def get_live_context(max_flow: int = 5, max_signals: int = 8) -> str:
    """Return a formatted live-data block, or empty string if nothing is available."""
    parts = []
    now_utc = datetime.now(timezone.utc)
    cutoff_ms = int((now_utc - timedelta(hours=4)).timestamp() * 1000)

    # ── Unusual options flow (FlowScraper → flow.db) ──────────────────────────
    try:
        con = sqlite3.connect(f"file:{FLOW_DB}?mode=ro", uri=True)
        con.row_factory = sqlite3.Row
        rows = con.execute(
            "SELECT symbol, option_type, strike, expiry, premium, block_type "
            "FROM flow_events WHERE event_time >= ? "
            "ORDER BY premium DESC LIMIT ?",
            (cutoff_ms, max_flow),
        ).fetchall()
        con.close()
        if rows:
            lines = [
                f"  • {r['symbol']} {r['option_type']} ${r['strike']} exp {r['expiry']} "
                f"| ${r['premium']:,.0f} premium | {r['block_type']}"
                for r in rows
            ]
            parts.append("UNUSUAL OPTIONS FLOW (last 4h, top by premium):\n" + "\n".join(lines))
    except Exception:
        pass

    # ── Firebase analyst trade signals (Name/Name2/Vivid2) ────────────────────
    try:
        data = json.loads(SIGNALS_JSON.read_text())
        open_sigs = data.get("open", [])
        total = len(open_sigs)
        showing = open_sigs[:max_signals]
        if showing:
            lines = []
            for s in showing:
                direction = "PUT" if s.get("isPut") else "CALL"
                exp = s.get("expiry")
                exp_str = (datetime.fromtimestamp(exp, tz=timezone.utc).strftime("%Y-%m-%d")
                           if exp else "?")
                lines.append(
                    f"  • {s.get('symbol')} {direction} ${s.get('strike')} exp {exp_str} "
                    f"| tgt ${s.get('sellTarget', '?')} stop ${s.get('stopLoss', '?')} "
                    f"[{s.get('category', '?')}] src:{s.get('source', '?')}"
                )
            parts.append(
                f"OPEN ANALYST SIGNALS ({total} total, showing {len(showing)}):\n"
                + "\n".join(lines)
            )
    except Exception:
        pass

    if not parts:
        return ""
    ts = now_utc.strftime("%Y-%m-%d %H:%M UTC")
    return (
        f"--- LIVE MISSION CONTROL DATA ({ts}) ---\n"
        + "\n\n".join(parts)
        + "\n---"
    )


if __name__ == "__main__":
    ctx = get_live_context()
    print(ctx if ctx else "(no live data available)")
