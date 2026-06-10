#!/usr/bin/env python3
"""
Erik Dalton transcription progress monitor.
Runs every 30 min via cron; pings Telegram with status, detects stalls, auto-syncs KB when done.
"""
import json, os, subprocess, time, urllib.request, urllib.parse
from pathlib import Path

HOME = Path.home()
BASE = HOME / "scrapes/erikdalton"
TX = BASE / "transcripts"
DONE_FILE = BASE / ".transcribe_done"
SECRETS = HOME / ".openclaw/secrets"
STATE_FILE = BASE / ".monitor_state.json"
WORKER_IDS = ["DVD", "MSG"]
DVD_TOTAL = 48
MSG_TOTAL = 354
TOTAL = DVD_TOTAL + MSG_TOTAL


def telegram(msg):
    try:
        tok = (SECRETS / "telegram_laptopclaude_bot_token").read_text().strip()
        cid = (SECRETS / "telegram-chat-id.txt").read_text().strip()
        data = urllib.parse.urlencode({"chat_id": cid, "text": msg}).encode()
        urllib.request.urlopen(
            f"https://api.telegram.org/bot{tok}/sendMessage", data=data, timeout=15
        )
    except Exception as e:
        print(f"telegram failed: {e}")


def load_state():
    try:
        return json.loads(STATE_FILE.read_text())
    except Exception:
        return {"last_count": 0, "last_change_ts": time.time(), "start_ts": time.time()}


def save_state(s):
    STATE_FILE.write_text(json.dumps(s))


def count_done():
    try:
        return len(list(TX.glob("*.txt")))
    except Exception:
        return 0


def worker_alive(wid):
    pid_file = BASE / f"transcribe_{wid}.pid"
    try:
        pid = int(pid_file.read_text().strip())
        os.kill(pid, 0)
        return True
    except Exception:
        return False


def remove_cron():
    try:
        result = subprocess.run(["crontab", "-l"], capture_output=True, text=True)
        lines = [l for l in result.stdout.splitlines() if "ed_transcribe_monitor" not in l]
        subprocess.run(["crontab", "-"], input="\n".join(lines) + "\n", text=True)
        print("cron removed")
    except Exception as e:
        print(f"cron removal failed: {e}")


def run_sync():
    try:
        result = subprocess.run(
            [str(HOME / "02_DATA/mc-kb/.venv/bin/python"),
             str(HOME / "erikdalton-kb/sync.py"), "--reindex"],
            capture_output=True, text=True, timeout=600
        )
        return result.returncode == 0
    except Exception:
        return False


def main():
    state = load_state()
    done = count_done()
    now_ts = time.time()

    if DONE_FILE.exists():
        # Auto-run sync if not yet done
        sync_status = HOME / "erikdalton-kb/sync_status.json"
        if not sync_status.exists():
            telegram(f"🔄 Erik Dalton: {done}/{TOTAL} done — running sync.py to build KB...")
            ok = run_sync()
            if ok:
                telegram(
                    f"✅ Erik Dalton COMPLETE + KB BUILT\n"
                    f"{done}/{TOTAL} items indexed\n"
                    f"Query: python ~/erikdalton-kb/query.py \"carpal tunnel from desk\""
                )
            else:
                telegram(
                    f"✅ Erik Dalton transcription done but sync.py failed — run manually:\n"
                    f"python ~/erikdalton-kb/sync.py --reindex"
                )
        else:
            telegram(
                f"✅ Erik Dalton COMPLETE\n"
                f"{done}/{TOTAL} items done — KB already synced"
            )
        remove_cron()
        return

    alive = [w for w in WORKER_IDS if worker_alive(w)]
    dead = [w for w in WORKER_IDS if not worker_alive(w)]
    pct = round(done / TOTAL * 100, 1)
    remaining = TOTAL - done

    # Update last-change tracking
    if done > state["last_count"]:
        state["last_count"] = done
        state["last_change_ts"] = now_ts
        save_state(state)
    else:
        stall_hours = (now_ts - state["last_change_ts"]) / 3600
        if stall_hours >= 1.0 and not alive:
            telegram(
                f"⚠️ Erik Dalton ALL workers DEAD — stalled!\n"
                f"Frozen at {done}/{TOTAL} ({pct}%)\n"
                f"Restart: cd ~/scripts && python erikdalton_transcribe.py --source dvd --worker-id DVD &"
            )
            return
        elif dead:
            telegram(
                f"⚠️ Erik Dalton worker(s) {', '.join(dead)} DEAD\n"
                f"Alive: {', '.join(alive) or 'none'}\n"
                f"Progress: {done}/{TOTAL} ({pct}%)"
            )

    elapsed = now_ts - state.get("start_ts", now_ts)
    if done > 0 and elapsed > 60:
        rate = done / (elapsed / 3600)
        eta_h = remaining / rate if rate > 0 else 0
        eta_str = f"~{eta_h:.1f}h remaining"
    else:
        eta_str = "calculating..."

    telegram(
        f"📊 Erik Dalton — {done}/{TOTAL} ({pct}%)\n"
        f"{remaining} items left | {eta_str}\n"
        f"Workers alive: {', '.join(alive) or 'none'} | Dead: {', '.join(dead) or 'none'}"
    )

    if "start_ts" not in state:
        state["start_ts"] = now_ts
        save_state(state)


if __name__ == "__main__":
    main()
