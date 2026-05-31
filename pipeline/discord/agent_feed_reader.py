"""Read helper for boba_decision_cycle.py / jazzy_decision_cycle.py.

Usage in agent scripts:

    from pipeline.discord.agent_feed_reader import recent_outcomes

    outcomes = recent_outcomes(symbol="TSLA", limit=20, since_minutes=240)
    # -> list of dicts (newest last), suitable for inclusion in the agent prompt

Or for prompt summarization:

    from pipeline.discord.agent_feed_reader import summarize_for_prompt
    summary_str = summarize_for_prompt(symbol="TSLA", limit=15)
"""
from __future__ import annotations

import json
import os
from datetime import datetime, timedelta, timezone
from pathlib import Path


_DEFAULT_FEED = Path.home() / ".openclaw" / "workspace" / "directives" / "options_outcomes_feed.json"


def _resolve_path(feed_path: Path | str | None) -> Path:
    return Path(feed_path or os.environ.get("AGENT_FEED_PATH", _DEFAULT_FEED))


def recent_outcomes(
    feed_path: Path | str | None = None,
    symbol: str | None = None,
    limit: int = 50,
    since_minutes: int | None = None,
    type_filter: str | None = None,
) -> list[dict]:
    """Return the most recent matching outcomes from the feed.

    Args:
        feed_path: override the default feed location.
        symbol: if set, only entries matching this symbol (case-insensitive).
        limit: max entries to return.
        since_minutes: if set, only entries newer than now-N minutes.
        type_filter: "closure" or "peak_gain" to restrict.
    """
    path = _resolve_path(feed_path)
    if not path.exists():
        return []
    try:
        raw = json.loads(path.read_text())
    except (OSError, json.JSONDecodeError):
        return []
    if not isinstance(raw, list):
        return []

    cutoff = None
    if since_minutes is not None:
        cutoff = datetime.now(timezone.utc) - timedelta(minutes=since_minutes)

    out: list[dict] = []
    for entry in raw:
        if not isinstance(entry, dict):
            continue
        if symbol and str(entry.get("symbol", "")).upper() != symbol.upper():
            continue
        if type_filter and entry.get("type") != type_filter:
            continue
        if cutoff is not None:
            ts_raw = entry.get("captured_at")
            if not ts_raw:
                continue
            try:
                ts = datetime.fromisoformat(str(ts_raw).replace("Z", "+00:00"))
                if ts < cutoff:
                    continue
            except (ValueError, TypeError):
                continue
        out.append(entry)

    return out[-limit:]


def summarize_for_prompt(
    feed_path: Path | str | None = None,
    symbol: str | None = None,
    limit: int = 20,
    since_minutes: int | None = 1440,
) -> str:
    """Return a compact human-readable summary suitable for inclusion in an LLM prompt."""
    entries = recent_outcomes(
        feed_path=feed_path, symbol=symbol, limit=limit, since_minutes=since_minutes
    )
    if not entries:
        return f"(no recent outcomes{f' for {symbol}' if symbol else ''} in last {since_minutes}min)"
    lines = [
        f"Recent options outcomes{f' for {symbol}' if symbol else ''} "
        f"({len(entries)} of last {since_minutes}min):"
    ]
    for e in entries:
        sym = e.get("symbol", "?")
        strike = e.get("strike")
        opt = e.get("opt_type") or ""
        ident = f"{sym} {strike}{opt}" if strike else sym
        if e.get("type") == "closure":
            pct = e.get("outcome_pct")
            pct_str = f"{pct:+.0f}%" if pct is not None else "?"
            cat = e.get("category") or ""
            lines.append(f"  - CLOSED {ident} {pct_str}" + (f" [{cat}]" if cat else ""))
        elif e.get("type") == "peak_gain":
            thresh = e.get("threshold_pct")
            peak = e.get("actual_peak_pct")
            lines.append(f"  - PEAK {ident} crossed +{thresh}% (max {peak:.0f}%)")
    return "\n".join(lines)
