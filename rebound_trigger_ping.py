#!/usr/bin/env python3
"""
rebound_trigger_ping.py — intraday Telegram ping when a symbol reaches TRIGGERED in
pipeline/decision/rebound_setup.py's state machine (key level held + momentum turning,
into negative sentiment). Cron every 30 min 09:45-15:45 ET weekdays.

Deterministic, no LLM: reads ~/.openclaw/data/decision/rebound_setup.json, pings each
(symbol, triggeredAt) ONCE via lib.notify.tg_push (default lane trading_command), and
records it in a state file so re-runs stay silent. ADVISORY ONLY — Mike decides;
never a sizing/gate input. Never prints tokens or chat ids.

Usage:
    ~/.venv/bin/python rebound_trigger_ping.py [--dry-run] [--lane trading_command] [--max-age-h 2]
"""
from __future__ import annotations

import argparse
import json
import os
import sys
from datetime import datetime
from pathlib import Path
from zoneinfo import ZoneInfo

sys.path.insert(0, str(Path(__file__).resolve().parent))
from tg_format import hdr, esc, footer  # noqa: E402  (2026-09-15 format sweep)

ET = ZoneInfo("America/New_York")
REBOUND_JSON = Path(os.environ.get(
    "REBOUND_JSON", str(Path.home() / ".openclaw" / "data" / "decision" / "rebound_setup.json")))
STATE_FILE = Path(os.environ.get(
    "REBOUND_PING_STATE", str(Path.home() / ".openclaw" / "data" / "decision" / "rebound_ping_state.json")))
DEFAULT_LANE = "trading_command"
DEFAULT_MAX_AGE_H = 2.0          # hourly producer; older than 2h = stale, don't ping off it


def load_state() -> dict:
    try:
        return json.loads(STATE_FILE.read_text())
    except Exception:
        return {"pinged": {}}


def save_state(state: dict) -> None:
    STATE_FILE.parent.mkdir(parents=True, exist_ok=True)
    tmp = STATE_FILE.with_suffix(".tmp")
    tmp.write_text(json.dumps(state, indent=1))
    os.replace(tmp, STATE_FILE)


def load_rebound(max_age_h: float) -> dict | None:
    try:
        data = json.loads(REBOUND_JSON.read_text())
    except Exception:
        return None
    as_of = data.get("asOf")
    try:
        ts = float(as_of) / 1000.0 if isinstance(as_of, (int, float)) else datetime.fromisoformat(str(as_of)).timestamp()
    except Exception:
        return None
    if (datetime.now(ET).timestamp() - ts) / 3600.0 > max_age_h:
        return None
    return data


def new_triggers(data: dict, state: dict) -> list[dict]:
    """TRIGGERED rows whose (symbol, triggeredAt) has not been pinged yet. Pure — unit tested."""
    pinged = state.setdefault("pinged", {})
    out = []
    for sym, row in sorted((data.get("symbols") or {}).items()):
        if not isinstance(row, dict) or row.get("state") != "triggered":
            continue
        key = f"{sym}|{row.get('triggeredAt') or row.get('stateSince') or ''}"
        if key in pinged:
            continue
        out.append({"key": key, "symbol": sym, "row": row})
    return out


def format_message(rows: list[dict], ran_at: str | None) -> str:
    n = len(rows)
    lines = [hdr("🏗", "Structure Trigger",
                 sub=f"{n} name{'s' if n != 1 else ''} held a key level + momentum turned")]
    for r in rows:
        row = r["row"]
        lines.append(f"▸ {esc(row.get('read'))} · score {row.get('score')}/100")
        opt = row.get("option") or {}
        if opt.get("stopRule"):
            lines.append(f"  ↳ {esc(opt['stopRule'])}")
    lines.append(footer(f"Advisory only · flat $400 cap · as of {ran_at or 'n/a'} · /api/rebound-setup").lstrip("\n"))
    return "\n".join(lines)


def main() -> int:
    ap = argparse.ArgumentParser()
    ap.add_argument("--dry-run", action="store_true", help="print, don't send, don't record")
    ap.add_argument("--lane", default=DEFAULT_LANE)
    ap.add_argument("--max-age-h", type=float, default=DEFAULT_MAX_AGE_H)
    a = ap.parse_args()

    data = load_rebound(a.max_age_h)
    if data is None:
        print(f"[rebound-ping] no fresh rebound_setup.json (>{a.max_age_h}h or missing) — nothing sent", flush=True)
        return 0
    state = load_state()
    rows = new_triggers(data, state)
    if not rows:
        print(f"[rebound-ping] no new triggers ({(data.get('counts') or {}).get('triggered', 0)} triggered, all pinged)", flush=True)
        return 0
    msg = format_message(rows, data.get("ranAt"))
    if a.dry_run:
        print(msg)
        return 0
    from lib.notify import tg_push  # local import: keeps --dry-run network-free
    # html=True (2026-09-15 format sweep): format_message() now routes every dynamic
    # field through tg_format.esc(), so switching on bold headers/HTML is safe.
    used = tg_push(msg, a.lane, loud=True, html=True)
    if not used:
        print(f"[rebound-ping] send FAILED on lane {a.lane} — will retry next run", flush=True)
        return 1
    now = datetime.now(ET).isoformat()
    for r in rows:
        state["pinged"][r["key"]] = now
    # keep the state file small: drop entries older than 10 days
    cutoff = datetime.now(ET).timestamp() - 10 * 86400
    state["pinged"] = {k: v for k, v in state["pinged"].items()
                       if datetime.fromisoformat(v).timestamp() >= cutoff}
    save_state(state)
    print(f"[rebound-ping] sent {len(rows)} trigger(s) via {used}: {', '.join(r['symbol'] for r in rows)}", flush=True)
    return 0


if __name__ == "__main__":
    sys.exit(main())
