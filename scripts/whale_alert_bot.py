#!/usr/bin/env python3
"""
whale_alert_bot — polls Firebase /FlowGreeks2/Alerts/today every 30s.
On NEW or GROWING contracts above $5M, $10M, $25M premium, posts to the
corresponding Discord channel and (for $10M+) triggers Boba decision cycle.

Daily reset at NY 4 AM ET via date-keyed state file.
"""
import json, time, requests, subprocess, sys
from datetime import datetime, timezone, timedelta
from pathlib import Path

FIREBASE_URL = "https://stock-signal-72772-default-rtdb.firebaseio.com/FlowGreeks2/Alerts/today.json"
SECRETS = Path.home() / ".openclaw" / "secrets"
STATE_DIR = Path.home() / ".openclaw" / "state"
STATE_DIR.mkdir(parents=True, exist_ok=True)
LOG_FILE = Path.home() / ".openclaw" / "workspace" / "memory" / "whale_alert_bot.jsonl"
LOG_FILE.parent.mkdir(parents=True, exist_ok=True)

THRESHOLD_5M = 5_000_000
THRESHOLD_10M = 10_000_000
THRESHOLD_25M = 25_000_000
GROWTH_REALERT_PCT = 25.0   # only re-alert same contract if premium grows by >=25%
POLL_INTERVAL = 30          # seconds
HEADERS = {"Content-Type": "application/json", "User-Agent": "MissionControl-WhaleAlertBot/1.0"}

W5 = (SECRETS / "discord_whale_5m_webhook").read_text().strip()
W10 = (SECRETS / "discord_whale_10m_webhook").read_text().strip()
W25 = (SECRETS / "discord_whale_25m_webhook").read_text().strip()

def et_now():
    return datetime.now(timezone.utc) + timedelta(hours=-4)

def state_path():
    return STATE_DIR / f"whale_alerts_seen_{et_now().strftime('%Y-%m-%d')}.json"

def load_state():
    p = state_path()
    if not p.exists(): return {}
    try: return json.loads(p.read_text())
    except: return {}

def save_state(s):
    state_path().write_text(json.dumps(s))

def log(action, detail):
    e = {"ts": datetime.now(timezone.utc).isoformat(), "action": action, "detail": detail}
    with LOG_FILE.open("a") as f: f.write(json.dumps(e) + "\n")
    print(f"[whale-bot] {action}: {str(detail)[:200]}", flush=True)

def fmt_dollars(n):
    if n >= 1_000_000: return f"${n/1_000_000:.2f}M"
    if n >= 1_000: return f"${n/1_000:.0f}K"
    return f"${n}"

def post(webhook, content, mention=False):
    body = {"content": ("@here " if mention else "") + content[:1900]}
    if mention:
        body["allowed_mentions"] = {"parse": ["everyone"]}
    try:
        r = requests.post(webhook, headers=HEADERS, json=body, timeout=10)
        return r.status_code in (200, 204)
    except Exception as e:
        log("post_fail", str(e)[:200])
        return False

def trigger_boba(reason):
    """Fire Boba decision cycle out-of-band on T0 MEGA flows."""
    try:
        log("trigger_boba", reason)
        subprocess.Popen(
            ["python3", "/home/ubuntu/scripts/boba_decision_cycle.py"],
            stdout=open("/tmp/boba_cycle.log", "a"),
            stderr=subprocess.STDOUT,
            start_new_session=True
        )
    except Exception as e:
        log("trigger_boba_fail", str(e)[:200])

def normalize(sym, wrapper):
    a = wrapper.get("alert", {}) if isinstance(wrapper, dict) else {}
    if not a: return None
    exp_s = a.get("Expiry", 0)
    try:
        exp_iso = datetime.fromtimestamp(exp_s, timezone.utc).strftime("%Y-%m-%d") if exp_s else "?"
    except:
        exp_iso = "?"
    return {
        "sym": sym, "ticker": a.get("Symbol","?"),
        "strike": a.get("Strike",0), "option_type": a.get("OptionType","?"),
        "expiry": exp_iso, "dte": a.get("DTE",0),
        "premium": int(a.get("totalFlowValue",0)),
        "volume": int(a.get("Volume",0)), "oi": int(a.get("OI",0)),
        "sweeps": int(a.get("SWEEPS",0)), "blocks": int(a.get("BLOCKS",0)),
        "is_bullish": bool(a.get("isBullish", False)),
        "alert_type": a.get("AlertType","?"),
        "alert_price": float(a.get("AlertPrice",0)),
    }

def format_alert_msg(c, tier_label):
    bull = "🟢 BULL" if c["is_bullish"] else "🔴 BEAR"
    side = "C" if c["option_type"].upper().startswith("C") else "P"
    repeat = " 🔁 REPEATER" if c["alert_type"] == "repeat_flow" else ""
    return (
        f"{tier_label} **{c['ticker']}** ${c['strike']:.0f}{side} {c['expiry']} ({c['dte']}d) {bull}{repeat}\n"
        f"💰 **{fmt_dollars(c['premium'])}** premium • V:{c['volume']:,} OI:{c['oi']:,} • SW:{c['sweeps']} BL:{c['blocks']}\n"
        f"Alert price: ${c['alert_price']:.2f}"
    )

def check_and_alert(c, seen):
    sym = c["sym"]; prem = c["premium"]
    prev = seen.get(sym, {}).get("max_premium", 0)
    # Decide if this is a new alert event
    is_new = sym not in seen
    grew = prem >= prev * (1 + GROWTH_REALERT_PCT/100) if prev > 0 else False
    if not is_new and not grew: return
    # Determine highest tier crossed
    crossed_25 = prem >= THRESHOLD_25M and seen.get(sym, {}).get("alerted_25", 0) < prem
    crossed_10 = prem >= THRESHOLD_10M and seen.get(sym, {}).get("alerted_10", 0) < prem
    crossed_5 = prem >= THRESHOLD_5M and seen.get(sym, {}).get("alerted_5", 0) < prem
    if not (crossed_5 or crossed_10 or crossed_25): return
    # Init state row
    seen.setdefault(sym, {"alerted_5": 0, "alerted_10": 0, "alerted_25": 0, "max_premium": 0})
    seen[sym]["max_premium"] = max(seen[sym]["max_premium"], prem)
    # Post to highest channel that fired (avoid spamming all 3)
    if crossed_25:
        if post(W25, "🚨🐋 **MEGA WHALE $25M+** 🐋🚨\n" + format_alert_msg(c, "💎 MEGA"), mention=True):
            log("alert_25m", f"{c['ticker']} {fmt_dollars(prem)}")
            seen[sym]["alerted_25"] = prem
            seen[sym]["alerted_10"] = prem
            seen[sym]["alerted_5"] = prem
            trigger_boba(f"$25M+ MEGA on {c['ticker']}")
    elif crossed_10:
        if post(W10, "🐋 **T0 MEGA FLOW $10M+**\n" + format_alert_msg(c, "🐳")):
            log("alert_10m", f"{c['ticker']} {fmt_dollars(prem)}")
            seen[sym]["alerted_10"] = prem
            seen[sym]["alerted_5"] = prem
            trigger_boba(f"$10M+ T0 on {c['ticker']}")
    elif crossed_5:
        if post(W5, "🐟 **WHALE $5M+**\n" + format_alert_msg(c, "🌊")):
            log("alert_5m", f"{c['ticker']} {fmt_dollars(prem)}")
            seen[sym]["alerted_5"] = prem

def cycle():
    try:
        r = requests.get(FIREBASE_URL, timeout=15)
        r.raise_for_status()
        raw = r.json() or {}
    except Exception as e:
        log("fetch_fail", str(e)[:200])
        return
    seen = load_state()
    n_alerts = 0
    n_5plus = 0
    for sym, w in raw.items():
        c = normalize(sym, w)
        if not c or c["premium"] < THRESHOLD_5M: continue
        n_5plus += 1
        before = (seen.get(sym, {}).get("alerted_5", 0),
                  seen.get(sym, {}).get("alerted_10", 0),
                  seen.get(sym, {}).get("alerted_25", 0))
        check_and_alert(c, seen)
        after = (seen.get(sym, {}).get("alerted_5", 0),
                 seen.get(sym, {}).get("alerted_10", 0),
                 seen.get(sym, {}).get("alerted_25", 0))
        if before != after: n_alerts += 1
    save_state(seen)
    if n_5plus > 0 or n_alerts > 0:
        log("cycle", f"{n_5plus} contracts >=$5M scanned, {n_alerts} new alerts fired")

def main():
    log("startup", f"whale-alert-bot online, polling every {POLL_INTERVAL}s")
    while True:
        try:
            cycle()
        except Exception as e:
            log("cycle_err", str(e)[:200])
        time.sleep(POLL_INTERVAL)

if __name__ == "__main__":
    main()
