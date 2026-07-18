#!/usr/bin/env python3
"""Lesson extractor — post-market analysis that turns today's wins/losses
into specific rules for tomorrow's cycles.

For each agent (Boba, Jazzy):
  1. Load today's decisions from boba/jazzy_decisions_validated.json
  2. Fetch the agent's current Alpaca positions + recent fills
  3. Ask Claude to identify 2-3 specific, actionable lessons
  4. Append them to ~/.openclaw/workspace/memory/{agent}_lessons.md
     in the format `_load_lessons()` expects (lines starting with `- [`)

Cron: 45 20 * * 1-5  (4:45 PM ET, after the daily grader at 4:30)

Idempotent: skips if today's lessons already extracted for the agent (checks
for a marker line with today's ISO date).
"""
from __future__ import annotations
import json
import os
import subprocess
import sys
import urllib.error
import urllib.request
from datetime import datetime, timezone
from pathlib import Path

SECRETS = Path("/home/ubuntu/.openclaw/secrets")
WORKSPACE_MEMORY = Path("/home/ubuntu/.openclaw/workspace/memory")
WORKSPACE_MEMORY.mkdir(parents=True, exist_ok=True)
CLAUDE_BIN = os.path.expanduser("~/.local/bin/claude")

DECISIONS_PATH = {
    "boba": Path("/home/ubuntu/.openclaw/workspace/skill_outputs/boba_decisions_validated.json"),
    "jazzy": Path("/home/ubuntu/.openclaw/workspace/skill_outputs/jazzy_decisions_validated.json"),
}
LESSONS_PATH = {
    "boba": WORKSPACE_MEMORY / "boba_lessons.md",
    "jazzy": WORKSPACE_MEMORY / "jazzy_lessons.md",
}

ALPACA_BASE = "https://paper-api.alpaca.markets/v2"


def read_secret(name: str) -> str:
    try: return (SECRETS / name).read_text().strip()
    except Exception: return ""


def alpaca_headers(agent: str) -> dict:
    if agent == "boba":
        key, sec = "alpaca-key-id", "alpaca-secret"
    else:
        key, sec = f"alpaca-{agent}-key-id", f"alpaca-{agent}-secret"
    return {
        "APCA-API-KEY-ID": read_secret(key),
        "APCA-API-SECRET-KEY": read_secret(sec),
    }


def http_get(url: str, headers: dict, timeout: float = 8) -> object:
    try:
        req = urllib.request.Request(url, headers=headers)
        with urllib.request.urlopen(req, timeout=timeout) as r:
            return json.loads(r.read().decode())
    except Exception:
        return None


def today_decisions(agent: str) -> list[dict]:
    """Return today's cycle decisions for the agent."""
    p = DECISIONS_PATH.get(agent)
    if not p or not p.exists():
        return []
    try:
        data = json.loads(p.read_text())
    except Exception:
        return []
    decisions = data if isinstance(data, list) else data.get("decisions", [])
    today = datetime.now(timezone.utc).date().isoformat()
    out = []
    for dec in decisions:
        ts = (dec.get("cycle_time") or dec.get("timestamp") or "")[:10]
        if ts == today:
            out.append(dec)
    return out


def already_extracted(agent: str) -> bool:
    """Skip if today's marker is already in the lessons file."""
    p = LESSONS_PATH[agent]
    if not p.exists():
        return False
    today = datetime.now(timezone.utc).date().isoformat()
    marker = f"<!-- extracted {today} -->"
    return marker in p.read_text()


def build_prompt(agent: str, decisions: list[dict], account: dict, positions: list, recent_orders: list) -> str:
    """Compress today's activity into a focused lesson-extraction prompt."""
    cycle_summaries = []
    for d in decisions:
        ts = (d.get("cycle_time") or d.get("timestamp") or "?")[:19]
        summary = (d.get("cycle_summary") or "")[:300]
        picks_exec = d.get("picks_executed") or []
        passed = d.get("passed_on") or []
        cycle_summaries.append({
            "time": ts,
            "summary": summary,
            "picks": [
                {
                    "ticker": p.get("ticker"),
                    "contract": (
                        f"${p.get('strike','?')}{(p.get('option_type','') or '?')[:1]} {p.get('expiry','?')} × {p.get('contracts','?')}"
                        if p.get("strike") else "stock"
                    ),
                    "reasoning": (p.get("reasoning") or "")[:300],
                    "institutional_thesis": (p.get("institutional_thesis") or "")[:200],
                } for p in picks_exec
            ],
            "passed_count": len(passed),
            "passed_first": (passed[0].get("ticker") + ": " + (passed[0].get("reason") or "")[:160]) if passed else None,
        })

    open_pos = []
    for p in positions:
        try: pl = float(p.get("unrealized_plpc", 0)) * 100
        except Exception: pl = 0.0
        open_pos.append({
            "symbol": p.get("symbol"),
            "qty": p.get("qty"),
            "pl_pct": round(pl, 1),
        })

    recent_fills = []
    for o in recent_orders:
        if o.get("status") != "filled":
            continue
        recent_fills.append({
            "time": (o.get("filled_at") or o.get("submitted_at", ""))[:19],
            "side": o.get("side"),
            "qty": o.get("qty"),
            "symbol": o.get("symbol"),
            "filled_avg_price": o.get("filled_avg_price"),
        })

    equity = account.get("equity") if account else "?"
    daytrade = account.get("daytrade_count") if account else "?"
    today = datetime.now(timezone.utc).date().isoformat()

    return f"""You are reviewing {agent.upper()}'s trading day. Your job: extract 2 to 4 SPECIFIC, ACTIONABLE lessons that should change tomorrow's decisions.

# Account state at EOD
- Equity: ${equity}
- Daytrade count: {daytrade}

# Open positions
{json.dumps(open_pos, indent=2)}

# Today's filled orders ({len(recent_fills)})
{json.dumps(recent_fills[:20], indent=2)}

# Today's decision cycles ({len(cycle_summaries)})
{json.dumps(cycle_summaries, indent=2)[:6000]}

# Lesson format — output a JSON array. Each lesson is a string. Examples:

[
  "Bear thesis on 0DTE puts in a mixed-bullish regime needs flow score ≥95 to override the regime bias",
  "Doubling down on a losing 0DTE position with the SAME signal is a forbidden move — adds only if NEW confluence appears (new flow, regime shift, news)",
  "When peer agent has already taken the contract, default is to skip — only converge if your independent analysis adds something materially different"
]

# Rules for good lessons
- Be SPECIFIC: mention tickers, thresholds, time-of-day, contract types
- Tie to OUTCOMES: "today's SPY 747P 0DTE lost $X because…"
- Be ACTIONABLE: phrase it as a rule the future agent can apply
- Avoid platitudes ("trade carefully") — only concrete, testable rules
- 2-4 lessons total; quality over quantity

Respond with ONLY the JSON array, no markdown fences, no preamble.
"""


def call_claude(prompt: str) -> list[str] | None:
    """Ask Claude Sonnet to extract lessons. Returns list of strings or None."""
    try:
        r = subprocess.run(
            [CLAUDE_BIN, "-p", "--model", "sonnet", "--effort", "high",
             "--output-format", "text", "--no-session-persistence", "--tools", ""],
            input=prompt,
            capture_output=True,
            text=True,
            timeout=180,
            env={k: v for k, v in os.environ.items() if k != "ANTHROPIC_API_KEY"},
        )
        if r.returncode != 0:
            print(f"[lesson-extractor] claude exit {r.returncode}: {r.stderr[:300]}", file=sys.stderr)
            return None
        text = r.stdout.strip()
        if text.startswith("```"):
            text = text.split("\n", 1)[1] if "\n" in text else text[3:]
            text = text.strip()
        # raw_decode to be tolerant of trailing fences
        try:
            lessons, _ = json.JSONDecoder().raw_decode(text)
            return [str(L) for L in lessons if isinstance(L, str) and L.strip()]
        except Exception as e:
            print(f"[lesson-extractor] parse fail: {e}; text[:300]={text[:300]!r}", file=sys.stderr)
            return None
    except subprocess.TimeoutExpired:
        print("[lesson-extractor] claude timeout 180s", file=sys.stderr)
        return None
    except Exception as e:
        print(f"[lesson-extractor] claude err: {e}", file=sys.stderr)
        return None


def append_lessons(agent: str, lessons: list[str]) -> None:
    p = LESSONS_PATH[agent]
    today = datetime.now(timezone.utc).date().isoformat()
    lines = [f"\n<!-- extracted {today} -->"]
    for L in lessons:
        lines.append(f"- [{today}] {L}")
    existing = p.read_text() if p.exists() else f"# {agent.title()} — Lessons Learned\n"
    p.write_text(existing + "\n".join(lines) + "\n")


def process_agent(agent: str) -> dict:
    if already_extracted(agent):
        return {"agent": agent, "skipped": "already extracted today"}

    decisions = today_decisions(agent)
    if not decisions:
        return {"agent": agent, "skipped": "no decisions today"}

    headers = alpaca_headers(agent)
    account = http_get(f"{ALPACA_BASE}/account", headers) or {}
    positions = http_get(f"{ALPACA_BASE}/positions", headers) or []
    today = datetime.now(timezone.utc).date().isoformat()
    orders = http_get(f"{ALPACA_BASE}/orders?status=all&after={today}T13:00:00Z&limit=50", headers) or []

    prompt = build_prompt(agent, decisions, account, positions, orders)
    lessons = call_claude(prompt)
    if not lessons:
        return {"agent": agent, "error": "no lessons extracted"}

    append_lessons(agent, lessons)
    return {"agent": agent, "lessons_added": len(lessons), "first": lessons[0][:120]}


def main() -> int:
    results = []
    for agent in ("boba", "jazzy"):
        results.append(process_agent(agent))
    print(json.dumps(results, indent=2))
    return 0


if __name__ == "__main__":
    sys.exit(main())
