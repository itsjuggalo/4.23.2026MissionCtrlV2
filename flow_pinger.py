#!/usr/bin/env python3
"""flow-pinger: event-driven trigger on DIAMOND+ flow alerts. Pings Boba+Jazzy + posts to agent-debate."""
import json, sys, time, subprocess, glob, requests
from datetime import datetime, timezone, timedelta
from pathlib import Path

PREMIUM_THRESHOLD = 10_000_000   # DIAMOND+
ACCUM_PREMIUM_MIN = 5_000_000
ACCUM_FLOW_COUNT_MIN = 10
TICKER_HEAT_MIN_CONTRACTS = 5
TICKER_HEAT_MIN_PREMIUM = 20_000_000
TICKER_HEAT_DIR_PCT = 0.70
TICKER_HEAT_COOLDOWN_SEC = 7200  # 2 hours (cost-control)
COOLDOWN_SEC = 3600              # 60 min per OCC (cost-control)
POLL_INTERVAL_SEC = 30
WEBHOOK_FILE = Path("/home/ubuntu/.openclaw/secrets/discord-webhook-agent-debate")
SECRETS_DIR = Path("/home/ubuntu/.openclaw/secrets")
STATE_FILE = Path("/home/ubuntu/.openclaw/state/flow_pinger_state.json")
BEST_OPTIONS_DIR = Path("/home/ubuntu/.openclaw/data/best-options")
ALPACA_PAPER = "https://paper-api.alpaca.markets"

def log(action, msg):
    print(f"[flow-pinger] {action}: {msg}", flush=True)

def load_state():
    try: return json.loads(STATE_FILE.read_text())
    except Exception: return {"cooldowns": {}}

def save_state(state):
    STATE_FILE.parent.mkdir(parents=True, exist_ok=True)
    STATE_FILE.write_text(json.dumps(state, indent=2))

def in_cooldown(occ, state, trigger_type="T0+_PREMIUM"):
    cd = state.get("cooldowns", {})
    if trigger_type.startswith("TICKER_HEAT"):
        # Use ticker-level key
        ticker = occ[:5].rstrip("0123456789")  # strip date+strike, keep ticker
        key = f"TICKER:{ticker}"
        return key in cd and (time.time() - cd[key]) < TICKER_HEAT_COOLDOWN_SEC
    return occ in cd and (time.time() - cd[occ]) < COOLDOWN_SEC

def mark_cooldown(occ, state, trigger_type="T0+_PREMIUM"):
    if trigger_type.startswith("TICKER_HEAT"):
        ticker = occ[:5].rstrip("0123456789")
        state.setdefault("cooldowns", {})[f"TICKER:{ticker}"] = time.time()
    state.setdefault("cooldowns", {})[occ] = time.time()
    cutoff = time.time() - 7200
    state["cooldowns"] = {k: v for k, v in state["cooldowns"].items() if v > cutoff}


def agent_holds_occ(agent, occ):
    """Check if agent already has a position in this OCC. Returns True if held."""
    try:
        key = (SECRETS_DIR / f"alpaca-{agent}-key-id").read_text().strip()
        sec = (SECRETS_DIR / f"alpaca-{agent}-secret").read_text().strip()
        r = requests.get(f"{ALPACA_PAPER}/v2/positions/{occ}",
            headers={"APCA-API-KEY-ID": key, "APCA-API-SECRET-KEY": sec}, timeout=8)
        return r.status_code == 200
    except Exception:
        return False
def get_account_bp(agent):
    try:
        key = (SECRETS_DIR / f"alpaca-{agent}-key-id").read_text().strip()
        sec = (SECRETS_DIR / f"alpaca-{agent}-secret").read_text().strip()
        r = requests.get(f"{ALPACA_PAPER}/v2/account",
            headers={"APCA-API-KEY-ID": key, "APCA-API-SECRET-KEY": sec}, timeout=10)
        if r.ok: return float(r.json().get("buying_power", 0))
    except Exception as e:
        log("bp_check_fail", f"{agent}: {e}")
    return 0.0

def post_discord(webhook_url, c, agents_pinged, trigger_type="T0+_PREMIUM"):
    occ = c.get("option_symbol", "?")
    ticker = c.get("ticker", "?")
    strike = c.get("strike", 0)
    opt = c.get("option_type", "?")
    exp = c.get("expiry", "?")
    prem = float(c.get("premium", 0))
    sweeps = c.get("sweeps", 0)
    blocks = c.get("blocks", 0)
    ap = float(c.get("alert_price", 0))
    cost = ap * 100
    direction = "[CALL]" if "CALL" in str(opt).upper() else "[PUT]"
    if trigger_type.startswith("TICKER_HEAT"):
        cnt = c.get("_ticker_heat_count", "?")
        total = c.get("_ticker_heat_total_prem", 0)
        direction = c.get("_ticker_heat_direction", "?")
        tier_band = f"TICKER_HEAT_{direction} x{cnt} contracts ${total/1e6:.0f}M total"
        color = 0xE0AC0E
    elif trigger_type == "ACCUMULATION":
        tier_band = f"ACCUMULATION x{c.get('total_flow_count', '?')}"
        color = 0x1F8F3F
    else:
        tier_band = "PLATINUM" if prem >= 20e6 else ("DIAMOND" if prem >= 15e6 else "T0 MEGA")
        color = 0xA32D2D if prem >= 20e6 else (0x9B30FF if prem >= 15e6 else 0xC76A00)
    embed = {
        "title": f"FLOW PINGER {tier_band}: {ticker} ${strike}{opt[0]} {exp}",
        "description": f"**Premium**: ${prem/1e6:.2f}M | **AlertPrice**: ${ap:.2f} | **Cost/contract**: ${cost:.0f}",
        "color": color,
        "fields": [
            {"name": "Direction", "value": direction, "inline": True},
            {"name": "Sweeps/Blocks", "value": f"{sweeps}/{blocks}", "inline": True},
            {"name": "Sweep ratio", "value": (f"{sweeps/max(blocks,1):.1f}:1" if blocks else f"{sweeps}:0 pure sweep"), "inline": True},
            {"name": "OCC", "value": f"`{occ}`", "inline": False},
            {"name": "Agents pinged", "value": ", ".join(agents_pinged) if agents_pinged else "none (BP insufficient)", "inline": False},
        ],
        "timestamp": datetime.now(timezone.utc).isoformat(),
        "footer": {"text": f"flow-pinger | threshold ${PREMIUM_THRESHOLD/1e6:.0f}M+ | {COOLDOWN_SEC//60}min OCC cooldown"},
    }
    try:
        r = requests.post(webhook_url, json={"embeds": [embed]}, timeout=10)
        if not r.ok: log("discord_fail", f"HTTP {r.status_code}: {r.text[:200]}")
    except Exception as e:
        log("discord_fail", str(e))

def trigger_agent(agent, occ):
    """Spawn DETACHED subprocess so it survives pinger restarts (setsid + new session)."""
    import os
    script = f"/home/ubuntu/scripts/{agent}_decision_cycle.py"
    logf = open(f"/tmp/{agent}_singlepick.log", "ab")
    try:
        subprocess.Popen(["python3", script, f"--single-pick={occ}"],
            stdout=logf, stderr=subprocess.STDOUT, cwd="/home/ubuntu/scripts",
            start_new_session=True)  # NEW: detach from parent process group
        log("triggered", f"{agent} on {occ} (detached)")
    except Exception as e:
        log("trigger_fail", f"{agent} on {occ}: {e}")

def scan_best_options():
    """Returns list of (occ, contract, trigger_type) tuples for qualifying alerts."""
    try:
        files = sorted(glob.glob(str(BEST_OPTIONS_DIR / "*.json")), reverse=True)
        if not files: return []
        d = json.loads(Path(files[0]).read_text())
        contracts = d.get("contracts", {})
        out = []
        # Pass 1: per-OCC triggers
        for occ, c in contracts.items():
            prem = float(c.get("premium", 0))
            flow_count = int(c.get("total_flow_count", c.get("trade_count", 1)) or 1)
            sweeps = int(c.get("sweeps", 0) or 0)
            blocks = int(c.get("blocks", 0) or 0)
            if prem >= PREMIUM_THRESHOLD:
                out.append((occ, c, "T0+_PREMIUM"))
                continue
            if prem >= ACCUM_PREMIUM_MIN and flow_count >= ACCUM_FLOW_COUNT_MIN and (sweeps / max(blocks, 1)) > 5:
                out.append((occ, c, "ACCUMULATION"))
        # Pass 2: ticker-heat across ticker
        from collections import defaultdict
        ticker_groups = defaultdict(list)
        for occ, c in contracts.items():
            if float(c.get("premium", 0)) >= 1_000_000:
                ticker_groups[c.get("ticker")].append((occ, c))
        for ticker, items in ticker_groups.items():
            if len(items) < TICKER_HEAT_MIN_CONTRACTS: continue
            total_prem = sum(float(c.get("premium", 0)) for _, c in items)
            if total_prem < TICKER_HEAT_MIN_PREMIUM: continue
            calls = sum(1 for _, c in items if "CALL" in str(c.get("option_type","")).upper())
            puts = len(items) - calls
            direction = None
            if calls / len(items) >= TICKER_HEAT_DIR_PCT: direction = "CALLS"
            elif puts / len(items) >= TICKER_HEAT_DIR_PCT: direction = "PUTS"
            if not direction: continue
            wanted = [it for it in items if (direction == "CALLS" and "CALL" in str(it[1].get("option_type","")).upper()) or
                                              (direction == "PUTS"  and "PUT"  in str(it[1].get("option_type","")).upper())]
            if not wanted: continue
            cheapest_occ, cheapest_c = min(wanted, key=lambda it: float(it[1].get("alert_price", 9e9) or 9e9))
            cheapest_c = dict(cheapest_c)
            cheapest_c["_ticker_heat_total_prem"] = total_prem
            cheapest_c["_ticker_heat_count"] = len(items)
            cheapest_c["_ticker_heat_direction"] = direction
            out.append((cheapest_occ, cheapest_c, f"TICKER_HEAT_{direction}"))
        return out
    except Exception as e:
        log("scan_fail", str(e))
        return []


def main():
    log("startup", f"online | threshold ${PREMIUM_THRESHOLD/1e6:.0f}M+ | cooldown {COOLDOWN_SEC}s | poll {POLL_INTERVAL_SEC}s")
    if not WEBHOOK_FILE.exists():
        log("fatal", f"webhook not found at {WEBHOOK_FILE}")
        return 1
    webhook_url = WEBHOOK_FILE.read_text().strip()
    state = load_state()
    while True:
        try:
            alerts = scan_best_options()
            for occ, c, trigger_type in alerts:
                if in_cooldown(occ, state, trigger_type): continue
                ap = float(c.get("alert_price", 0))
                cost = ap * 100
                boba_bp = get_account_bp("boba")
                jazzy_bp = get_account_bp("jazzy")
                agents = []
                if boba_bp >= cost and not agent_holds_occ("boba", occ):
                    trigger_agent("boba", occ); agents.append("Boba")
                elif boba_bp >= cost:
                    log("skip_already_held", f"boba already holds {occ}")
                if jazzy_bp >= cost and not agent_holds_occ("jazzy", occ):
                    trigger_agent("jazzy", occ); agents.append("Jazzy")
                elif jazzy_bp >= cost:
                    log("skip_already_held", f"jazzy already holds {occ}")
                post_discord(webhook_url, c, agents, trigger_type)
                mark_cooldown(occ, state, trigger_type); save_state(state)
                log("alert", f"{occ} [{trigger_type}] prem ${float(c.get('premium',0))/1e6:.2f}M cost ${cost:.0f} pinged={agents}")
        except Exception as e:
            log("loop_error", str(e))
        time.sleep(POLL_INTERVAL_SEC)

if __name__ == "__main__":
    sys.exit(main() or 0)
