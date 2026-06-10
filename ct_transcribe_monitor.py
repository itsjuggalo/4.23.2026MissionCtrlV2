#!/usr/bin/env python3
"""
ClayTrader transcription progress monitor.
Runs every 30 min via cron; pings Telegram with status, stall alerts, and done notice.
Deregisters itself from cron once the job is fully done.
"""
import json, os, subprocess, time, urllib.request, urllib.parse
from pathlib import Path

HOME = Path.home()
BASE = HOME / "scrapes/claytrader.com"
TX = BASE / "transcripts"
LOG = BASE / "transcribe_gpu_A.log"   # check worker A log for activity
WORKER_IDS = ["A", "B", "C"]
DONE_FILE = BASE / ".transcribe_done"
STATUS_FILE = BASE / "transcribe_status.json"
SECRETS = HOME / ".openclaw/secrets"
STATE_FILE = BASE / ".monitor_state.json"
TOTAL = 224


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
        return {"last_count": 0, "last_change_ts": time.time()}


def save_state(state):
    STATE_FILE.write_text(json.dumps(state))


def worker_status():
    alive = []
    dead = []
    for wid in WORKER_IDS:
        pid_file = BASE / f"transcribe_gpu_{wid}.pid"
        try:
            pid = int(pid_file.read_text().strip())
            os.kill(pid, 0)
            alive.append(wid)
        except Exception:
            dead.append(wid)
    return alive, dead


def count_done():
    return len(list(TX.glob("*.txt")))


def last_log_line():
    try:
        lines = LOG.read_text().strip().splitlines()
        # De-dup doubled lines (log fn writes to stdout + file)
        seen = set()
        unique = []
        for l in reversed(lines):
            if l not in seen:
                seen.add(l)
                unique.append(l)
        return unique[0] if unique else ""
    except Exception:
        return ""


def remove_cron():
    """Remove this monitor from crontab once job is done."""
    try:
        result = subprocess.run(["crontab", "-l"], capture_output=True, text=True)
        lines = [l for l in result.stdout.splitlines() if "ct_transcribe_monitor" not in l]
        subprocess.run(["crontab", "-"], input="\n".join(lines) + "\n", text=True)
        print("cron entry removed")
    except Exception as e:
        print(f"cron removal failed: {e}")


def main():
    state = load_state()
    done = count_done()
    alive, dead = worker_status()
    now_ts = time.time()

    # --- DONE ---
    if DONE_FILE.exists():
        msg = (
            f"✅ ClayTrader University transcription COMPLETE\n"
            f"{done}/{TOTAL} lessons done\n"
            f"Run: python ~/claytrader-kb/sync.py --reindex to build the KB"
        )
        telegram(msg)
        remove_cron()
        return

    pct = round(done / TOTAL * 100, 1)
    remaining = TOTAL - done

    # --- STALL DETECTION ---
    if done > state["last_count"]:
        state["last_count"] = done
        state["last_change_ts"] = now_ts
        save_state(state)
    else:
        stall_hours = (now_ts - state["last_change_ts"]) / 3600
        if stall_hours >= 1.0 and not alive:
            msg = (
                f"⚠️ ClayTrader ALL workers DEAD — transcription stalled!\n"
                f"Frozen at {done}/{TOTAL} ({pct}%)\n"
                f"Restart workers A/B/C manually"
            )
            telegram(msg)
            return
        elif dead:
            msg = (
                f"⚠️ ClayTrader worker(s) {', '.join(dead)} DEAD\n"
                f"Alive: {', '.join(alive) or 'none'}\n"
                f"Progress: {done}/{TOTAL} ({pct}%)"
            )
            telegram(msg)

    # --- NORMAL PROGRESS UPDATE ---
    elapsed = now_ts - state.get("start_ts", now_ts)
    if done > 0 and elapsed > 60:
        rate = done / (elapsed / 3600)
        eta_h = remaining / rate if rate > 0 else 0
        eta_str = f"~{eta_h:.1f}h remaining"
    else:
        eta_str = "calculating..."

    msg = (
        f"📊 ClayTrader transcription — {done}/{TOTAL} ({pct}%)\n"
        f"{remaining} lessons left | {eta_str}\n"
        f"Workers alive: {', '.join(alive) or 'none'} | Dead: {', '.join(dead) or 'none'}"
    )
    telegram(msg)

    if "start_ts" not in state:
        state["start_ts"] = now_ts
        save_state(state)


if __name__ == "__main__":
    main()
