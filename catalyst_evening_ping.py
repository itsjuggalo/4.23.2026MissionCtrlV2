#!/usr/bin/env python3
"""catalyst_evening_ping.py — optional 22:25 ET Telegram ping on days a Form 4 cluster buy
or CEO/CFO open-market buy filed. Form 4 deadline is 22:00 ET, so this catches same-day
filings the 08:15 ET morning brief (morning_command.py, cron 08:15) hasn't seen yet.

Reads today's event log written by the catalysts factor producer —
`~/.openclaw/data/decision/raw/catalysts/events/YYYY-MM-DD.jsonl` (ET calendar date), one
JSON object per line: {id, type, symbol, at, magnitude, conf, hl, class, value_usd, actor,
note, url}. Sends ONLY when >=1 F4_CLUSTER_BUY or F4_CEO_CFO_BUY event landed today AND
today hasn't already pinged (state file). Advisory only — never touches a live cycle,
sizing, or gate. Never raises past main(); never prints tokens/chat ids.

  catalyst_evening_ping.py             # send if qualifying and not already pinged today
  catalyst_evening_ping.py --dry-run   # print what would be sent (or why not), send nothing
"""
from __future__ import annotations

import argparse
import json
import os
import sys
import urllib.parse
import urllib.request
from datetime import datetime
from pathlib import Path
from zoneinfo import ZoneInfo

sys.path.insert(0, str(Path(__file__).resolve().parent))
from lib.notify import tg_push  # noqa: E402
from tg_format import hdr, row, esc, b, money, footer  # noqa: E402  (2026-09-15 format sweep)

ET = ZoneInfo("America/New_York")
NEWS_SNR_URL = "http://localhost:3000/api/news-snr"
EVENTS_DIR = Path(os.environ.get(
    "CATALYST_EVENTS_DIR",
    str(Path.home() / ".openclaw" / "data" / "decision" / "raw" / "catalysts" / "events")))
STATE_FILE = Path(os.environ.get(
    "CATALYST_PING_STATE",
    str(Path.home() / ".openclaw" / "data" / "decision" / "raw" / "catalysts" / "evening_ping_state.json")))
QUALIFYING = {"F4_CLUSTER_BUY", "F4_CEO_CFO_BUY"}


def _today_str() -> str:
    return datetime.now(ET).strftime("%Y-%m-%d")


def _today_events() -> list[dict]:
    path = EVENTS_DIR / f"{_today_str()}.jsonl"
    out: list[dict] = []
    try:
        for line in path.read_text().splitlines():
            line = line.strip()
            if not line:
                continue
            try:
                out.append(json.loads(line))
            except Exception:
                continue
    except Exception:
        pass
    return out


def _already_pinged_today() -> bool:
    try:
        state = json.loads(STATE_FILE.read_text())
    except Exception:
        return False
    return state.get("last_ping_date") == _today_str()


def _mark_pinged() -> None:
    STATE_FILE.parent.mkdir(parents=True, exist_ok=True)
    tmp = STATE_FILE.with_suffix(".tmp")
    tmp.write_text(json.dumps({"last_ping_date": _today_str(),
                                "at": datetime.now(ET).isoformat()}))
    os.replace(tmp, STATE_FILE)


def _fmt_event(e: dict) -> str:
    sym = str(e.get("symbol", "?")).upper()
    typ = str(e.get("type", "?"))
    val = e.get("value_usd")
    note = str(e.get("note") or "").strip()
    at = str(e.get("at") or "")
    try:
        t = datetime.fromisoformat(at.replace("Z", "+00:00")).astimezone(ET).strftime("%-I:%M %p ET")
    except Exception:
        t = ""
    val_s = money(val, 0) if isinstance(val, (int, float)) else ""
    return row(sym, typ, val_s, note, t)


def _snr_line(symbol: str) -> str:
    """One SNR corroboration line for `symbol` — top-scoring headline (score >=60)
    from /api/news-snr, or 'no corroborating headline'. Fails soft: any network/parse
    error reads the same as no corroboration, never raises past the caller."""
    try:
        url = f"{NEWS_SNR_URL}?{urllib.parse.urlencode({'symbol': symbol, 'min': 60})}"
        req = urllib.request.Request(url, headers={"User-Agent": "Mozilla/5.0"})
        with urllib.request.urlopen(req, timeout=6) as r:
            d = json.loads(r.read())
        arts = sorted(d.get("articles") or [], key=lambda a: -(a.get("snr") or 0))
        if not arts:
            return f"📰 {b(symbol)}: no corroborating headline (SNR&lt;60)"
        top = arts[0]
        title = str(top.get("title") or "")[:100]
        return f"📰 {b(symbol)}: SNR {top.get('snr')} ({esc(top.get('source', '?'))}) “{esc(title)}”"
    except Exception:
        return f"📰 {b(symbol)}: no corroborating headline (SNR check failed)"


def build(qualifying: list[dict]) -> str:
    lines = [hdr("🧭", "Catalyst Ping", sub="cluster/insider buy filed today (Form 4 deadline 22:00 ET)")]
    lines += [_fmt_event(e) for e in qualifying]
    # One SNR corroboration line per TICKER (not per event — a symbol with two
    # qualifying filings today still gets one line), in order of first appearance.
    seen: list[str] = []
    for e in qualifying:
        sym = str(e.get("symbol", "?")).upper()
        if sym not in seen:
            seen.append(sym)
    lines += [_snr_line(sym) for sym in seen]
    lines.append(footer("Full sector read-through in tomorrow's 08:15 ET brief.").lstrip("\n"))
    return "\n".join(lines)


def main() -> None:
    ap = argparse.ArgumentParser()
    ap.add_argument("--dry-run", action="store_true",
                     help="print what would be sent (or the skip reason), send nothing")
    a = ap.parse_args()

    events = _today_events()
    qualifying = [e for e in events if str(e.get("type")) in QUALIFYING]

    if not qualifying:
        print("[catalyst-ping] no F4_CLUSTER_BUY/F4_CEO_CFO_BUY today — no-op", flush=True)
        return

    if a.dry_run:
        print("=== DRY RUN (not sent) ===")
        print(build(qualifying))
        if _already_pinged_today():
            print("(note: already pinged today — a real run would no-op instead of sending)")
        return

    if _already_pinged_today():
        print("[catalyst-ping] already pinged today — no-op", flush=True)
        return

    text = build(qualifying)
    # html=True (2026-09-15 format sweep): every dynamic field (note, headline title,
    # source) now goes through tg_format.esc()/row(), so HTML send is safe.
    used = tg_push(text, "trading_command", loud=True, html=True)
    if used:
        _mark_pinged()
        print(f"[catalyst-ping] sent via {used} ({len(qualifying)} qualifying event(s))", flush=True)
    else:
        print("[catalyst-ping] send FAILED (no live bot) — not marking as pinged", flush=True)


if __name__ == "__main__":
    main()
