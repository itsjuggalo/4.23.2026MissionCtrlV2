#!/home/itsju/.venv/bin/python
"""Pre-market brief → LaptopClaude Telegram bot (8:55 ET weekdays).

ONE tight, portfolio-aware buzz before the open: tone + today's catalysts (incl.
politics/geopolitics) + any catalyst on holdings + a single PLAN line. LLM-composed
via the subscription `claude` CLI (news-search + web), API key stripped. Anti-bloat:
≤8 lines. Honors the shared killswitch. Cron: 55 8 * * 1-5.
Test: quantum_premarket.py --dry-run
"""
import json, os, subprocess, sys
from datetime import datetime
from zoneinfo import ZoneInfo

sys.path.insert(0, os.path.expanduser("~/scripts"))
import quantum_tg as Q

ET     = ZoneInfo("America/New_York")
HALT   = os.path.expanduser("~/.openclaw/quantum_HALT")
CLAUDE = os.path.expanduser("~/.local/bin/claude")
TG     = os.path.expanduser("~/bin/tg-send-msg")


def main():
    dry = "--dry-run" in sys.argv
    if os.path.exists(HALT) and not dry:
        return
    env = {k: v for k, v in os.environ.items() if k != "ANTHROPIC_API_KEY"}
    try:
        r = subprocess.run(
            [CLAUDE, "-p", Q.premarket_prompt(), "--model", "sonnet",
             "--output-format", "json",
             "--allowedTools", "Bash,Read,WebSearch,WebFetch,Skill"],
            capture_output=True, text=True, timeout=300, env=env,
            cwd=os.path.expanduser("~"))
        body = Q.tidy((json.loads(r.stdout).get("result") or "").strip(), max_lines=9)
    except Exception as e:
        body = f"(pre-market brief unavailable: {e})"
    if not body:
        return  # nothing useful → say nothing (anti-bloat)
    msg = f"🌅 *PRE-MARKET* · {datetime.now(ET).strftime('%a %-m/%-d')}\n{body}"
    if dry:
        print(msg)
        return
    try:
        subprocess.run([TG, msg], timeout=20)
    except Exception as e:
        print(f"[premarket] send failed: {e}", file=sys.stderr)


if __name__ == "__main__":
    main()
