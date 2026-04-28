"""
Orion's morning flow brief — scheduled to run premarket 8:45 ET weekdays.

Reads flow data from mission-control/flow-monitor sources, runs score_reasoner
to annotate each event with component breakdown, selects top 5 by score,
formats for Telegram, posts via agent-team/post_helper.

Usage:
    python3 orion_morning_flow_brief.py              # live
    python3 orion_morning_flow_brief.py --dry-run    # see output, don't post
"""
import argparse
import json
import sys
from datetime import datetime, timedelta, timezone
from pathlib import Path
import sys as _sys_orion
_sys_orion.path.insert(0, "/home/ubuntu/scripts")
try:
    from lib.agent_debate import post_to_debate as _post_orion_debate
    _ORION_DEBATE_OK = True
except Exception:
    _ORION_DEBATE_OK = False

sys.path.insert(0, "/home/ubuntu/mission-control/agent-team")
sys.path.insert(0, "/home/ubuntu/mission-control/flow-monitor/reasoning")

from post_helper import post_to_telegram
from formatters import format_flow_scan
from score_reasoner import annotate_event

FLOW_SCORER_SIDECAR = Path("/home/ubuntu/mission-control/signal-receiver/data/scored_signals_recent.json")

FLOW_DATA_DIRS = [
    Path("/home/ubuntu/mission-control/signal-receiver/data"),
    Path("/home/ubuntu/mission-control/signal-receiver"),
    Path("/home/ubuntu/.openclaw/workspace/skill_outputs"),
    Path("/home/ubuntu/mission-control/flow-monitor/data"),
]
FLOW_FILE_PATTERNS = ["flow*.json", "options*.json", "signals*.json", "*scored*.json"]
LOOKBACK_HOURS = 18  # Covers overnight flow


def find_recent_flow_events(lookback_hours: int = LOOKBACK_HOURS) -> list:
    """Gather options flow events from all known sources within the lookback window."""
    events = []
    cutoff = datetime.now(timezone.utc) - timedelta(hours=lookback_hours)

    for d in FLOW_DATA_DIRS:
        if not d.exists():
            continue
        files = []
        try:
            for pat in FLOW_FILE_PATTERNS:
                files.extend(d.glob(pat))
        except Exception:
            files = list(d.glob("*.json"))
        for jsonf in sorted(set(files), key=lambda p: p.stat().st_mtime if p.exists() else 0, reverse=True)[:20]:
            try:
                data = json.loads(jsonf.read_text())
            except Exception:
                continue
            items = data if isinstance(data, list) else data.get("events") or data.get("flow") or data.get("signals") or []
            for e in items:
                if not isinstance(e, dict):
                    continue
                ts_str = e.get("timestamp") or e.get("time") or e.get("created_at") or ""
                if ts_str:
                    try:
                        ts = datetime.fromisoformat(ts_str.replace("Z", "+00:00"))
                        if ts < cutoff:
                            continue
                    except Exception:
                        pass
                events.append(e)
    return events


def top_n_scored(events: list, n: int = 5) -> list:
    """Annotate every event with reasoning, return top N by score."""
    annotated = [annotate_event(e) for e in events]
    annotated = [a for a in annotated if a["_reasoning"]["grade"] != "REJECT"]
    annotated.sort(key=lambda x: -x["_reasoning"]["total_score"])
    return annotated[:n]


def to_formatter_dict(annotated_event: dict) -> dict:
    """Flatten an annotated event into the shape format_flow_scan expects."""
    r = annotated_event.get("_reasoning", {})
    return {
        "ticker": annotated_event.get("ticker") or annotated_event.get("symbol") or "?",
        "strike": annotated_event.get("strike", "?"),
        "type": annotated_event.get("type") or annotated_event.get("right") or "",
        "expiry": annotated_event.get("expiry") or annotated_event.get("expiration") or "",
        "score": r.get("total_score", 0),
        "top_reason": r.get("top_reason", ""),
    }


def main():
    p = argparse.ArgumentParser()
    p.add_argument("--dry-run", action="store_true")
    p.add_argument("--lookback", type=int, default=LOOKBACK_HOURS)
    p.add_argument("--source", choices=["sidecar", "files", "both"], default="sidecar",
                   help="sidecar = use flow_scorer's scored_signals_recent.json (preferred)")
    args = p.parse_args()

    # PREFERRED: read from flow_scorer sidecar (has full reasoning)
    scored = []
    if args.source in ("sidecar", "both") and FLOW_SCORER_SIDECAR.exists():
        try:
            scored = json.loads(FLOW_SCORER_SIDECAR.read_text())
            print(f"Loaded {len(scored)} pre-scored signals from flow_scorer sidecar", file=sys.stderr)
        except Exception as e:
            print(f"Sidecar read failed: {e}", file=sys.stderr)

    # FALLBACK: raw event directory scan + annotate locally
    if not scored and args.source in ("files", "both"):
        events = find_recent_flow_events(args.lookback)
        print(f"Fallback: gathered {len(events)} raw flow events", file=sys.stderr)
        annotated = [annotate_event(e) for e in events]
        scored = [{
            "ticker": a.get("ticker") or a.get("symbol") or "?",
            "option_type": a.get("type") or a.get("right") or "",
            "strike": a.get("strike", "?"),
            "expiry": a.get("expiry") or a.get("expiration") or "",
            "score": a["_reasoning"]["total_score"],
            "grade": a["_reasoning"]["grade"],
            "reasons": [f"{lbl}: {note}" for lbl, pts, note in a["_reasoning"]["components"] if pts > 0],
        } for a in annotated if a["_reasoning"]["grade"] != "REJECT"]

    if not scored:
        body = (f"No scored flow signals available.\n"
                f"(flow-monitor may be quiet — it posts to Discord not disk. "
                f"Once flow_scorer processes a signal, the sidecar will populate.)")
    else:
        # Filter to high-quality, take top 5
        top = sorted(scored, key=lambda x: -x.get("score", 0))[:5]
        lines = [f"{len(scored)} whale-tier ($1M+) picks today, top {min(5, len(scored))}:"]
        for i, s in enumerate(top, 1):
            ticker = s.get("ticker", "?")
            ot = (s.get("option_type") or "")[:1]
            strike = s.get("strike", "?")
            exp = str(s.get("expiry", ""))[:10]
            score = s.get("score", "?")
            grade = s.get("grade", "")
            tier = s.get("tier", "")
            fv_raw = s.get("flow_value_raw", "")
            top_reason = ""
            reasons = s.get("reasons", [])
            if reasons:
                top_reason = f" — {reasons[0]}" if isinstance(reasons[0], str) else ""
            tier_prefix = f"{tier} " if tier else ""
            fv_suffix = f" ({fv_raw})" if fv_raw else ""
            lines.append(f"{i}. {tier_prefix}{ticker} {strike}{ot} {exp}{fv_suffix} — {score}/{grade}{top_reason}")
        body = "\n".join(lines)

    result = post_to_telegram(
        agent="orion",
        message_type="Morning Flow Scan",
        body=body,
        dry_run=args.dry_run,
    )
    print(json.dumps(result, indent=2, default=str))
    return 0 if result["ok"] else 1


if __name__ == "__main__":
    sys.exit(main())
    # Multi-agent: post Orion's brief summary to #agent-debate
    if _ORION_DEBATE_OK:
        try:
            _orion_summary = "**Orion Premarket Brief**\n\n"
            if 'top_events' in dir() and top_events:
                for e in top_events[:5]:
                    _orion_summary += f"• {e.get('symbol','?')} score {e.get('score','?')}: {e.get('reasoning','')[:100]}\n"
            else:
                _orion_summary += "No high-conviction events surfaced this morning."
            _post_orion_debate("orion", _orion_summary)
            print("[orion] posted brief to #agent-debate")
        except Exception as _e:
            print(f"[orion] debate post failed: {_e}")
