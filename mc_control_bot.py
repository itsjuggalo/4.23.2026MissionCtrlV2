#!/usr/bin/env python3
"""mc_control_bot.py — two-way Telegram control bot for Mission Control internals.

Long-polls the dedicated "Mike Ping" bot (same token/chat as ping_mike.py) and lets Mike
SEE + CHANGE internals from his phone. Escalations still go OUT via ping_mike.py; this daemon
is the listener that takes commands back IN.

  READ:    /status /queue /heal /pipeline /services /time /recall <q> /help
  CONTROL: /pause [reason] /resume /restart <unit> /merge <id> /reject <id> <reason> /drill <svc>
  SHELL:   /sh <cmd>   — or just type any non-slash message — runs an arbitrary shell command

SECURITY MODEL: the bot acts ONLY on messages from the saved chat_id (telegram-ping-chat-id);
every other sender is ignored + logged. It runs as Mike's user, so /sh has full laptop access —
the chat_id allowlist is the ONLY gate. Every received command is logged to control_bot.log.
Stdlib only (urllib); runs under /usr/bin/python3.
"""
import json
import shlex
import subprocess
import sys
import time
import urllib.parse
import urllib.request
from pathlib import Path

SEC = Path.home() / ".openclaw" / "secrets"
TOKEN = (SEC / "telegram-ping-bot-token").read_text().strip() if (SEC / "telegram-ping-bot-token").exists() else ""
CHAT = (SEC / "telegram-ping-chat-id").read_text().strip() if (SEC / "telegram-ping-chat-id").exists() else ""
NS = "/home/itsju/cron/nightshift"
PY = "/usr/bin/python3"
DESK_DB = "/home/itsju/LapClaw/pipeline/desk_pipeline.sqlite"
LOG = Path(NS) / "logs" / "control_bot.log"
SH_TIMEOUT = 120
TG_LIMIT = 3900


def log(msg: str) -> None:
    LOG.parent.mkdir(parents=True, exist_ok=True)
    LOG.open("a").write(f"[{time.strftime('%Y-%m-%dT%H:%M:%SZ', time.gmtime())}] {msg}\n")


def api(method: str, params: dict, timeout: int = 60) -> dict:
    url = f"https://api.telegram.org/bot{TOKEN}/{method}"
    data = urllib.parse.urlencode(params).encode()
    with urllib.request.urlopen(urllib.request.Request(url, data=data), timeout=timeout) as r:
        return json.loads(r.read())


def send(text: str) -> None:
    text = text or "(empty)"
    for i in range(0, len(text), TG_LIMIT):
        try:
            api("sendMessage", {"chat_id": CHAT, "text": text[i:i + TG_LIMIT],
                                "disable_web_page_preview": "true"}, timeout=20)
        except Exception as e:  # noqa: BLE001
            log(f"send failed: {e}")


def run(cmd: str, timeout: int = SH_TIMEOUT) -> str:
    try:
        r = subprocess.run(cmd, shell=True, capture_output=True, text=True, timeout=timeout)
        out = (r.stdout or "")
        if r.stderr and r.stderr.strip():
            out += "\n[stderr] " + r.stderr.strip()
        return out.strip() or f"(no output — exit {r.returncode})"
    except subprocess.TimeoutExpired:
        return f"(timed out after {timeout}s)"
    except Exception as e:  # noqa: BLE001
        return f"(error: {e})"


HELP = (
    "🛰️ MC control bot\n"
    "READ: /status /queue /heal /pipeline /services /time /recall <q>\n"
    "CONTROL: /pause [reason] /resume /restart <unit> /merge <id> /reject <id> <reason> /drill <svc>\n"
    "SHELL: /sh <cmd> — or just type any command (full shell)."
)


def handle(text: str) -> str:
    t = text.strip()
    low = t.lower()
    arg = t.split(None, 1)[1].strip() if len(t.split(None, 1)) > 1 else ""

    if low in ("/help", "help", "/start"):
        return HELP
    if low == "/status":
        return run(f"{PY} {NS}/loop_audit.py")
    if low == "/queue":
        return run(f"{PY} {NS}/ns_review.py list")
    if low == "/heal":
        return run(f"sqlite3 -header {NS}/nightshift.sqlite "
                   "\"SELECT ts,service,state FROM heal_events WHERE ts>datetime('now','-24 hours') "
                   "ORDER BY id DESC LIMIT 20\"")
    if low == "/pipeline":
        return run(f"sqlite3 -header {DESK_DB} "
                   "\"SELECT substr(cycle_id,1,19) cycle,asset_class,status,candidates_total ct,"
                   "candidates_promoted cp FROM cycle_metadata ORDER BY started_at DESC LIMIT 8\"")
    if low == "/services":
        # Oracle retired 2026-06-30 (laptop-only) — local PM2 + ports only
        return run("echo 'laptop ports:'; ss -ltn 2>/dev/null | grep -oE ':(3000|1337|3141|8080|3033)\\b' | sort -u; "
                   "echo '--- laptop pm2 online ---'; pm2 list 2>/dev/null | grep -cE online | sed 's/^/online: /'")
    if low == "/time":
        return run("TZ=America/New_York date '+%A %Y-%m-%d %I:%M %p %Z'")
    if low.startswith("/recall"):
        return run(f"~/mc-kb/.venv/bin/python ~/mc-kb/query.py {shlex.quote(arg)}", timeout=120) if arg else "usage: /recall <question>"
    if low.startswith("/pause"):
        return run(f"bash {NS}/pause.sh on {shlex.quote(arg or 'via telegram')}")
    if low == "/resume":
        return run(f"bash {NS}/pause.sh off")
    if low.startswith("/restart"):
        return run(f"systemctl --user restart {shlex.quote(arg)} && echo restarted {arg}") if arg else "usage: /restart <systemd-unit>"
    if low.startswith("/merge"):
        return run(f"{PY} {NS}/ns_review.py accept {shlex.quote(arg)}") if arg else "usage: /merge <id>"
    if low.startswith("/reject"):
        p = t.split(None, 2)
        return run(f"{PY} {NS}/ns_review.py reject {p[1]} {shlex.quote(p[2] if len(p) > 2 else 'via telegram')}") if len(p) > 1 else "usage: /reject <id> <reason>"
    if low.startswith("/drill"):
        if not arg:
            return "usage: /drill <aries|missioncontrol|claudeclaw-os|--deadman>"
        subprocess.Popen(f"bash {NS}/chaos_drill.sh {shlex.quote(arg)} >> {NS}/logs/control_drill.log 2>&1", shell=True)
        return f"drill started for {arg} — check /status or control_drill.log"
    if low.startswith("/sh"):
        return run(arg) if arg else "usage: /sh <command>"
    if t.startswith("/"):
        return f"unknown command.\n{HELP}"
    return run(t)  # bare text = full shell


def main() -> int:
    if not TOKEN or not CHAT:
        log("missing telegram-ping-bot-token or telegram-ping-chat-id — exiting")
        return 2
    log("control bot starting")
    send("🟢 MC control bot online — text /help for commands.")
    offset = None
    while True:
        try:
            params = {"timeout": 50}
            if offset is not None:
                params["offset"] = offset
            res = api("getUpdates", params, timeout=70)
            for u in res.get("result", []):
                offset = u["update_id"] + 1
                msg = u.get("message") or u.get("edited_message")
                if not msg:
                    continue
                cid = str(msg.get("chat", {}).get("id", ""))
                txt = msg.get("text", "")
                if cid != CHAT:                       # the ONLY security gate
                    log(f"IGNORED unauthorized chat {cid}: {txt[:80]!r}")
                    continue
                if not txt:
                    continue
                log(f"CMD from {cid}: {txt!r}")
                try:
                    reply = handle(txt)
                except Exception as e:  # noqa: BLE001
                    reply = f"(handler error: {e})"
                send(reply)
                log(f"replied ({len(reply)} chars)")
        except Exception as e:  # noqa: BLE001
            log(f"loop error: {e}")
            time.sleep(5)


if __name__ == "__main__":
    raise SystemExit(main())
