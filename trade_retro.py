#!/usr/bin/env python3
"""trade_retro.py — action-gating trade retro (EMIT-ONLY, safe).

Reads the last N closed trades from `decipher_exits` (desk_pipeline.sqlite) and runs the
"action-gating" retro prompt through the Claude CLI (subscription/OAuth — free): it FORCES the
model to name ONE concrete rule to change first (entry filter / size cap / exit tier / gate
threshold), the evidence from these trades, and the single 2-week metric that proves it helped —
or to say plainly "no change — keep the rule set." It rejects vague "be smarter / improve the
model" output.

EMIT-ONLY by design: it writes the recommendation to a SEPARATE retro log and (optionally) prints
it. It does NOT write to boba_lessons.md or any live decision input — so it has ZERO effect on what
or how the desk trades. Applying any rule it suggests stays a human decision.

  trade_retro.py                 # last 15 closed trades from the desk DB → retro_log.md + stdout
  trade_retro.py --n 25
  trade_retro.py --demo          # built-in sample trades (no DB) — still calls the LLM
  trade_retro.py --print-prompt  # assemble + print the prompt, NO LLM call (free dry-run)
  trade_retro.py --no-log        # print only, don't append to the retro log
"""
import argparse, json, os, sqlite3, subprocess, sys, datetime
from pathlib import Path

DB    = Path(os.path.expanduser("/AIWorkWSL/web/missionctrl/pipeline/desk_pipeline.sqlite"))
LOG   = Path(os.path.expanduser("~/.openclaw/workspace/memory/retro_log.md"))  # SEPARATE from boba_lessons.md
CLAUDE = "/home/itsju/.local/bin/claude"
OAUTH  = Path(os.path.expanduser("~/.openclaw/secrets/claude_oauth_token"))

RETRO_PROMPT = """You are running an action-gating retro on a trading desk's last closed trades.

HARD RULES for your answer:
- Do NOT say "be smarter", "improve the model", "trade better", or any vague self-improvement.
- Name exactly ONE concrete rule to change FIRST, and it must be one of: an entry filter, a
  size cap, an exit tier, or a gate threshold.
- Give the specific EVIDENCE from THESE trades that justifies that one change (cite tickers / the
  pattern in the numbers).
- Give the SINGLE metric that, in 2 weeks, will tell us whether the change helped (and the
  direction that means "it worked").
- If NO rule clears that bar, answer exactly: "no change — keep the rule set." and one line why.

Keep it under ~150 words. Output plainly (no preamble).

CLOSED TRADES:
"""

DEMO_TRADES = [
    {"ticker": "NVDA", "account": "Boba", "reason": "trail stop", "entry": 2.04, "exit_price": 2.44,
     "gain_pct": 19.6, "peak_gain_pct": 41.0, "realized": 40.0, "hold_min": 23},
    {"ticker": "TSLA", "account": "Jazzy", "reason": "stop loss", "entry": 3.10, "exit_price": 2.20,
     "gain_pct": -29.0, "peak_gain_pct": 8.0, "realized": -90.0, "hold_min": 47},
    {"ticker": "AAPL", "account": "Boba", "reason": "profit target", "entry": 1.50, "exit_price": 2.25,
     "gain_pct": 50.0, "peak_gain_pct": 73.0, "realized": 75.0, "hold_min": 110},
    {"ticker": "SPY", "account": "Boba", "reason": "stop loss", "entry": 4.00, "exit_price": 2.80,
     "gain_pct": -30.0, "peak_gain_pct": 5.0, "realized": -120.0, "hold_min": 18},
]


def read_trades(n):
    if not DB.exists():
        return []
    con = sqlite3.connect(f"file:{DB}?mode=ro", uri=True)
    con.row_factory = sqlite3.Row
    try:
        rows = con.execute(
            """SELECT ticker, account, reason, entry, exit_price, gain_pct, peak_gain_pct,
                      realized, hold_min, closed_at
               FROM decipher_exits ORDER BY closed_at DESC LIMIT ?""", (n,)).fetchall()
    except Exception:
        rows = []
    finally:
        con.close()
    return [dict(r) for r in rows]


def fmt_trades(rows):
    if not rows:
        return "(no closed trades found)"
    out = []
    for r in rows:
        g = r.get("gain_pct"); pk = r.get("peak_gain_pct"); rl = r.get("realized")
        out.append(
            f"- {r.get('ticker','?')} ({r.get('account','?')}) {r.get('reason','?')}: "
            f"entry {r.get('entry')} → exit {r.get('exit_price')}, "
            f"gain {g if g is not None else '?'}% (peak {pk if pk is not None else '?'}%), "
            f"realized ${rl if rl is not None else '?'}, held {r.get('hold_min','?')}min")
    return "\n".join(out)


def call_claude(prompt):
    env = {k: v for k, v in os.environ.items() if k != "ANTHROPIC_API_KEY"}
    if OAUTH.exists():
        env["CLAUDE_CODE_OAUTH_TOKEN"] = OAUTH.read_text().strip()
    try:
        r = subprocess.run([CLAUDE, "-p", "--model", "sonnet", "--output-format", "text",
                            "--no-session-persistence"], input=prompt, capture_output=True,
                           text=True, timeout=240, env=env)
        return r.stdout.strip() or None
    except Exception as e:
        print(f"claude call failed: {e}", file=sys.stderr)
        return None


def now_et():
    try:
        from zoneinfo import ZoneInfo
        return datetime.datetime.now(ZoneInfo("America/New_York")).strftime("%Y-%m-%d %H:%M ET")
    except Exception:
        return datetime.datetime.now().strftime("%Y-%m-%d %H:%M")


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("--n", type=int, default=15)
    ap.add_argument("--demo", action="store_true")
    ap.add_argument("--print-prompt", action="store_true")
    ap.add_argument("--no-log", action="store_true")
    a = ap.parse_args()

    rows = DEMO_TRADES if a.demo else read_trades(a.n)
    if not rows:
        print("No closed trades to retro (desk DB empty or missing). Use --demo to dry-run.", file=sys.stderr)
        return 1
    prompt = RETRO_PROMPT + fmt_trades(rows)

    if a.print_prompt:
        print(prompt)
        return 0

    out = call_claude(prompt)
    if not out:
        print("retro produced no output (LLM call failed).", file=sys.stderr)
        return 1

    stamp = now_et()
    block = f"\n## Retro {stamp} — {len(rows)} closed trade(s){' [DEMO]' if a.demo else ''}\n{out}\n"
    print(block)
    if not a.no_log and not a.demo:
        LOG.parent.mkdir(parents=True, exist_ok=True)
        with open(LOG, "a") as f:
            f.write(block)
        print(f"(appended to {LOG} — emit-only; not fed to any live decision cycle)")
    return 0


if __name__ == "__main__":
    sys.exit(main())
