#!/usr/bin/env python3
"""skill_to_discord.py — run a Claude skill/prompt headless and post the result to
a Discord channel. Generic cron runner for scheduled trading commands.

Billed to the claude.ai SUBSCRIPTION (ANTHROPIC_API_KEY stripped, cwd=$HOME,
--allowedTools) — same proven bridge as the SynthControl slash-command bot. Posts
via the BobaUpgraded bot token directly to a channel (no webhook, no channel edits).

Usage:
  skill_to_discord.py --skill "/market-context" --channel macro-outlook --header "🌐 REGIME"
  skill_to_discord.py --skill "/signal-liveness" --channel system-logs
"""
from __future__ import annotations

import argparse
import json
import os
import subprocess
import sys
import time
import urllib.request
import urllib.error
from datetime import datetime
from zoneinfo import ZoneInfo
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parent))
from lib.portfolio import top_tickers_str  # noqa: E402

SEC = Path.home() / ".openclaw" / "secrets"
GUILD = "1486025777970548908"
ET = ZoneInfo("America/New_York")
CLAUDE_BIN = str(Path.home() / ".local/bin/claude")
CLAUDE_CWD = str(Path.home())
CLAUDE_TOOLS = "Bash,Read,Grep,Glob,WebFetch,WebSearch,Skill,Agent,TodoWrite"
BOT_TOKEN = (SEC / "discord_boba_token").read_text().strip()


def run_skill(prompt: str, model: str = "sonnet", timeout: int = 420) -> str:
    env = {k: v for k, v in os.environ.items() if k != "ANTHROPIC_API_KEY"}
    try:
        r = subprocess.run(
            [CLAUDE_BIN, "-p", prompt, "--model", model, "--output-format", "json",
             "--allowedTools", CLAUDE_TOOLS],
            capture_output=True, text=True, timeout=timeout, env=env, cwd=CLAUDE_CWD)
        if r.returncode != 0:
            return f"[skill error rc={r.returncode}] {r.stderr.strip()[:300]}"
        return (json.loads(r.stdout).get("result") or "").strip() or "[skill returned empty]"
    except subprocess.TimeoutExpired:
        return f"[skill timed out after {timeout}s]"
    except Exception as e:  # noqa: BLE001
        return f"[skill error] {e}"


def _api(path: str):
    req = urllib.request.Request("https://discord.com/api/v10" + path,
        headers={"Authorization": "Bot " + BOT_TOKEN, "User-Agent": "mc-skillcron/1.0"})
    with urllib.request.urlopen(req, timeout=20) as x:
        return json.loads(x.read())


def resolve_channel(ref: str) -> str:
    if ref.isdigit():
        return ref
    for c in _api(f"/guilds/{GUILD}/channels"):
        if c.get("name") == ref:
            return c["id"]
    raise SystemExit(f"channel '{ref}' not found")


def post(cid: str, content: str) -> None:
    for i in range(0, len(content), 1900):
        body = json.dumps({"content": content[i:i + 1900]}).encode()
        for attempt in range(3):
            req = urllib.request.Request(
                f"https://discord.com/api/v10/channels/{cid}/messages", data=body,
                method="POST", headers={"Authorization": "Bot " + BOT_TOKEN,
                "Content-Type": "application/json", "User-Agent": "mc-skillcron/1.0"})
            try:
                with urllib.request.urlopen(req, timeout=15):
                    break
            except urllib.error.HTTPError as e:
                if e.code == 429:
                    try:
                        ra = float(json.loads(e.read()).get("retry_after", 2))
                    except Exception:
                        ra = 2.0
                    time.sleep(ra + 0.3)
                    continue
                raise
        time.sleep(0.6)


def main() -> None:
    ap = argparse.ArgumentParser()
    ap.add_argument("--skill", required=True, help="the /skill or prompt to run")
    ap.add_argument("--channel", required=True, help="channel name or id")
    ap.add_argument("--header", default="", help="optional banner line")
    ap.add_argument("--model", default="sonnet")
    ap.add_argument("--timeout", type=int, default=420)
    ap.add_argument("--tickers", type=int, default=0,
                    help="substitute {TICKERS} in --skill with the top-N portfolio holdings")
    a = ap.parse_args()
    skill = a.skill
    if a.tickers and "{TICKERS}" in skill:
        skill = skill.replace("{TICKERS}", top_tickers_str(a.tickers))
    cid = resolve_channel(a.channel)
    out = run_skill(skill, a.model, a.timeout)
    stamp = datetime.now(ET).strftime("%a %b %-d %-I:%M %p ET")
    header = (a.header + f"  ·  {stamp}") if a.header else ""
    msg = (header + "\n" + out) if header else out
    post(cid, msg)
    print(f"[skillcron] {a.skill[:40]!r} -> #{a.channel} ({len(out)} chars)", flush=True)


if __name__ == "__main__":
    main()
