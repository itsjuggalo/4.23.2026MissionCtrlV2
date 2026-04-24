"""
Cost Watchdog — hourly check of Anthropic burn rate.
If Boba burns more than $THRESHOLD_USD_PER_HOUR, pause his cron and alert.

Primary path: Anthropic Admin API cost_report endpoint.
Fallback: log-based heartbeat if admin key not configured (warns once).

Re-enable after pause:
    rm /home/ubuntu/.openclaw/workspace/state/boba_killswitch
    openclaw cron enable cfcf6645-d175-478c-bd9f-e97c00a1e690
"""
import json
import os
import subprocess
import sys
import urllib.request
from datetime import datetime, timedelta, timezone
from pathlib import Path

SECRETS_DIR = Path.home() / ".openclaw" / "secrets"
STATE_DIR = Path.home() / ".openclaw" / "workspace" / "state"
STATE_FILE = STATE_DIR / "cost_watchdog.json"
KILLSWITCH = STATE_DIR / "boba_killswitch"
WARNED_FLAG = STATE_DIR / "admin_key_missing_warned"

BOBA_CRON_ID = "cfcf6645-d175-478c-bd9f-e97c00a1e690"
THRESHOLD_USD_PER_HOUR = float(os.environ.get("COST_THRESHOLD_USD", "1.00"))
STATE_DIR.mkdir(parents=True, exist_ok=True)


def get_admin_key() -> str:
    for name in ["anthropic_admin_api_key", "anthropic_admin_key", "admin_api_key"]:
        p = SECRETS_DIR / name
        if p.exists():
            val = p.read_text().strip()
            if val:
                return val
    # Also try env var
    return os.environ.get("ANTHROPIC_ADMIN_API_KEY", "").strip()


def fetch_cost_last_hour(admin_key: str):
    """Return (cost_usd_float, success_bool, error_str)."""
    now = datetime.now(timezone.utc)
    # Grab last 2 hours of buckets, use the most recent COMPLETE hour
    start = (now - timedelta(hours=2)).replace(minute=0, second=0, microsecond=0)
    end = now.replace(minute=0, second=0, microsecond=0)
    if end <= start:
        end = start + timedelta(hours=1)

    qs = (
        f"starting_at={start.strftime('%Y-%m-%dT%H:%M:%SZ')}"
        f"&ending_at={end.strftime('%Y-%m-%dT%H:%M:%SZ')}"
        f"&bucket_width=1h"
    )
    url = f"https://api.anthropic.com/v1/organizations/cost_report?{qs}"

    try:
        req = urllib.request.Request(url, headers={
            "anthropic-version": "2023-06-01",
            "x-api-key": admin_key,
        })
        with urllib.request.urlopen(req, timeout=15) as resp:
            payload = json.loads(resp.read())
    except Exception as e:
        return 0.0, False, f"API call failed: {e}"

    # Parse the cost_report response. Field names vary; handle a few shapes defensively.
    total_cents = 0.0
    found_buckets = 0
    for bucket in payload.get("data", []):
        found_buckets += 1
        for item in bucket.get("results", []):
            for field in ("amount", "cost", "cost_amount"):
                v = item.get(field)
                if v is not None:
                    try:
                        total_cents += float(v)
                    except Exception:
                        pass
                    break

    # Docs say amounts are "decimal strings in lowest units (cents)"
    # So total_cents is already in cents, convert to USD
    total_usd = total_cents / 100.0

    # Take latest hour only if we have multiple buckets
    if found_buckets > 1 and payload.get("data"):
        last_bucket = payload["data"][-1]
        last_total = sum(float(it.get("amount", 0) or 0) for it in last_bucket.get("results", []))
        total_usd = last_total / 100.0

    return total_usd, True, None


def pause_boba() -> str:
    """Set killswitch file and try openclaw cron disable variants."""
    KILLSWITCH.write_text(json.dumps({
        "paused_at": datetime.now(timezone.utc).isoformat(),
        "reason": "cost_watchdog_triggered",
        "threshold_usd_per_hour": THRESHOLD_USD_PER_HOUR,
    }, indent=2))

    attempts = []
    for cmd in [
        ["openclaw", "cron", "disable", BOBA_CRON_ID],
        ["openclaw", "cron", "pause", BOBA_CRON_ID],
        ["openclaw", "cron", "remove", BOBA_CRON_ID],
    ]:
        try:
            r = subprocess.run(cmd, capture_output=True, timeout=10, text=True)
            attempts.append(f"{' '.join(cmd)} -> rc={r.returncode}")
            if r.returncode == 0:
                return f"OK via: {' '.join(cmd)}"
        except Exception as e:
            attempts.append(f"{' '.join(cmd)} -> EXC {e}")

    return "killswitch file set; openclaw disable attempts: " + " | ".join(attempts)


def alert_threshold_triggered(cost_1h: float, pause_result: str):
    try:
        sys.path.insert(0, "/home/ubuntu/mission-control/agent-team")
        from post_helper import post_to_telegram
        from ops_log import log_to_ops

        body = (
            f"⚠ COST WATCHDOG TRIPPED\n"
            f"Last hour burn: ${cost_1h:.2f} (threshold ${THRESHOLD_USD_PER_HOUR}/h)\n"
            f"Pause: {pause_result}\n"
            f"Resume: rm killswitch + openclaw cron enable {BOBA_CRON_ID}"
        )
        post_to_telegram(agent="orion", message_type="⚠ Cost Alarm", body=body, bypass_cooldown=True)
        log_to_ops(
            "cost_watchdog", "ERROR",
            f"Boba paused — burn ${cost_1h:.2f}/hr vs threshold ${THRESHOLD_USD_PER_HOUR}/hr",
            metadata={"cost_1h": cost_1h, "threshold": THRESHOLD_USD_PER_HOUR, "pause_result": pause_result},
        )
    except Exception as e:
        print(f"[watchdog] Alert send failed: {e}", file=sys.stderr)


def alert_no_admin_key_once():
    """Post a warning once per install that admin key is missing."""
    if WARNED_FLAG.exists():
        return
    try:
        sys.path.insert(0, "/home/ubuntu/mission-control/agent-team")
        from post_helper import post_to_telegram
        body = (
            f"⚠ Cost watchdog running in HEARTBEAT-ONLY mode.\n"
            f"Need Anthropic Admin API key to track real-time burn.\n"
            f"Create at: console.anthropic.com → API Keys → Admin Keys\n"
            f"Save to: ~/.openclaw/secrets/anthropic_admin_api_key"
        )
        post_to_telegram(agent="orion", message_type="Setup Needed", body=body, bypass_cooldown=True)
    except Exception:
        pass
    WARNED_FLAG.write_text(datetime.now(timezone.utc).isoformat())


def main():
    state = {"history": [], "last_check": None}
    if STATE_FILE.exists():
        try:
            state = json.loads(STATE_FILE.read_text())
        except Exception:
            pass

    admin_key = get_admin_key()
    ts_now = datetime.now(timezone.utc).isoformat()

    if not admin_key:
        alert_no_admin_key_once()
        entry = {"checked_at": ts_now, "source": "no_admin_key", "cost_last_hour_usd": None}
        state["history"].append(entry)
        state["history"] = state["history"][-48:]
        STATE_FILE.write_text(json.dumps(state, indent=2))
        print(f"[watchdog] {ts_now} — no admin key, skipping cost check")
        return 0

    cost_1h, ok, err = fetch_cost_last_hour(admin_key)

    entry = {
        "checked_at": ts_now,
        "source": "admin_api" if ok else "error",
        "cost_last_hour_usd": round(cost_1h, 4) if ok else None,
        "error": err,
    }
    state["history"].append(entry)
    state["history"] = state["history"][-48:]
    STATE_FILE.write_text(json.dumps(state, indent=2))

    if not ok:
        print(f"[watchdog] {ts_now} — admin API error: {err}")
        return 0

    print(f"[watchdog] {ts_now} — last-hour cost: ${cost_1h:.3f} (threshold ${THRESHOLD_USD_PER_HOUR}/h)")

    if cost_1h > THRESHOLD_USD_PER_HOUR:
        if KILLSWITCH.exists():
            print("[watchdog] Already killswitched; not re-triggering")
            return 1
        result = pause_boba()
        alert_threshold_triggered(cost_1h, result)
        print(f"[watchdog] TRIGGERED: paused Boba. Result: {result}")
        return 1

    return 0


if __name__ == "__main__":
    sys.exit(main())
