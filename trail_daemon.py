#!/usr/bin/env python3
"""
Layer 2.5 trail daemon — ratcheting stops for swing positions.

Runs every 5 min via PM2. For each Alpaca R2 option position:
1. Check if it's a swing position (journal has protocol="swing", or fallback: DTE>=45 at entry)
2. Fetch current mid price
3. Update high-water mark in state
4. If position is at +50%/+100%/+200% gain, ratchet stop to lock in % off high
5. Cancel old stop-limit, replace with new one (only if new stop > old stop — never lower)

Trail tiers:
  +50% to +100% gain  → trail at 20% off HWM
  +100% to +200% gain → trail at 25% off HWM
  +200%+ gain         → trail at 30% off HWM

Flow protocol positions: skipped (keep their original native OCO).
Crypto + stocks: skipped (options only).

State: ~/.openclaw/workspace/state/trail_daemon_hwm.json
Log:   ~/.openclaw/workspace/memory/trail_daemon.jsonl
"""
import json, os, sys, time, re
from datetime import datetime, timezone
from pathlib import Path
import requests

SECRETS = Path.home() / ".openclaw" / "secrets"
STATE_DIR = Path.home() / ".openclaw" / "workspace" / "state"
STATE_DIR.mkdir(parents=True, exist_ok=True)
HWM_STATE = STATE_DIR / "trail_daemon_hwm.json"
LOG_FILE = Path.home() / ".openclaw" / "workspace" / "memory" / "trail_daemon.jsonl"
LOG_FILE.parent.mkdir(parents=True, exist_ok=True)
JOURNAL = Path.home() / ".openclaw" / "workspace" / "skill_outputs" / "boba_decisions_validated.json"

POLL_INTERVAL_SEC = 300  # 5 minutes
ALPACA_BASE = "https://paper-api.alpaca.markets/v2"

def _read(name):
    p = SECRETS / name
    return p.read_text().strip() if p.exists() else ""

# DAEMON ACCOUNT LOCK: this daemon is hardcoded to R2 (PA3R6MOPBWF7, Boba's account).
# Do not change to alpaca-r1-* — those are R1 (managed by position_sell_daemon).
EXPECTED_ACCOUNT = "PA3R6MOPBWF7"  # R2

KEY = _read("alpaca-key-id") or _read("alpaca_key.txt")
SEC = _read("alpaca-secret") or _read("alpaca_secret.txt")
DISCORD_WH = _read("discord_bobatrades_webhook")


def assert_correct_account():
    """Crash if this daemon is pointed at the wrong Alpaca account."""
    try:
        r = requests.get(f"{ALPACA_BASE}/account", headers=HEADERS, timeout=10)
        if r.status_code != 200:
            log("fatal", f"Cannot reach Alpaca: HTTP {r.status_code}")
            raise SystemExit(1)
        actual = r.json().get("account_number", "")
        if actual != EXPECTED_ACCOUNT:
            log("fatal_account_mismatch", f"Expected R2 ({EXPECTED_ACCOUNT}) but got {actual}. Refusing to run on wrong account.")
            raise SystemExit(2)
        equity = float(r.json().get("equity", 0))
        log("startup_account_check", f"✓ Confirmed R2 account {actual} (equity ${equity:,.0f}) — managing R2 swing positions only")
    except SystemExit: raise
    except Exception as e:
        log("fatal_account_check", str(e))
        raise SystemExit(3)

HEADERS = {"APCA-API-KEY-ID": KEY, "APCA-API-SECRET-KEY": SEC, "Content-Type": "application/json"}

# ─── Logging ─────────────────────────────────────────────────────────────────

def log(action, detail):
    entry = {"ts": datetime.now(timezone.utc).isoformat(), "action": action, "detail": detail}
    with LOG_FILE.open("a") as f:
        f.write(json.dumps(entry) + "\n")
    print(f"[trail-daemon] {action}: {str(detail)[:300]}", flush=True)


def post_discord(msg):
    if not DISCORD_WH: return
    try:
        requests.post(DISCORD_WH, json={"content": msg[:1900]}, timeout=10)
    except Exception as e:
        log("discord_err", str(e))


# ─── State ───────────────────────────────────────────────────────────────────

def load_hwm():
    if HWM_STATE.exists():
        try: return json.loads(HWM_STATE.read_text())
        except: return {}
    return {}


def save_hwm(state):
    tmp = HWM_STATE.with_suffix(".json.tmp")
    tmp.write_text(json.dumps(state, indent=2))
    tmp.replace(HWM_STATE)


# ─── Alpaca interface ────────────────────────────────────────────────────────

def get_positions():
    r = requests.get(f"{ALPACA_BASE}/positions", headers=HEADERS, timeout=15)
    return r.json() if r.status_code == 200 else []


def get_open_orders():
    r = requests.get(f"{ALPACA_BASE}/orders?status=open&limit=100", headers=HEADERS, timeout=15)
    return r.json() if r.status_code == 200 else []


def cancel_order(order_id):
    r = requests.delete(f"{ALPACA_BASE}/orders/{order_id}", headers=HEADERS, timeout=15)
    return r.status_code in (200, 204, 207)


def submit_stop_limit(symbol, qty, stop_price, limit_price):
    payload = {
        "symbol": symbol,
        "qty": str(qty),
        "side": "sell",
        "type": "stop_limit",
        "time_in_force": "gtc",
        "stop_price": f"{stop_price:.2f}",
        "limit_price": f"{limit_price:.2f}",
    }
    r = requests.post(f"{ALPACA_BASE}/orders", headers=HEADERS, json=payload, timeout=15)
    return r.json() if r.status_code in (200, 201) else None


# ─── Journal lookup — find swing-tagged picks ────────────────────────────────

_journal_cache = {"data": None, "ts": 0}

def load_journal():
    """Returns dict mapping option_symbol → {protocol, entry_criteria, dte_at_entry}."""
    now = time.time()
    if _journal_cache["data"] and (now - _journal_cache["ts"]) < 600:
        return _journal_cache["data"]
    if not JOURNAL.exists():
        return {}
    cycles = json.loads(JOURNAL.read_text())
    out = {}
    for cycle in cycles:
        for pick in cycle.get("picks_executed", []):
            ex = pick.get("execution", {})
            sym = ex.get("symbol", "")
            if not sym: continue
            out[sym] = {
                "protocol": pick.get("protocol", "flow"),
                "entry_criteria": pick.get("entry_criteria", []),
                "ticker": pick.get("ticker"),
                "expiry": pick.get("expiry"),
                "strike": pick.get("strike"),
                "option_type": pick.get("option_type"),
            }
    _journal_cache["data"] = out
    _journal_cache["ts"] = now
    return out


def days_to_expiry_from_occ(occ_symbol):
    """Parse OCC: SYMBOL + YYMMDD + C/P + STRIKE × 1000 → DTE."""
    try:
        # Find the YYMMDD block: 6 digits followed by C or P
        m = re.search(r"(\d{6})([CP])(\d{8})", occ_symbol)
        if not m: return None
        yymmdd = m.group(1)
        exp_dt = datetime.strptime(yymmdd, "%y%m%d").replace(tzinfo=timezone.utc)
        delta = (exp_dt - datetime.now(timezone.utc)).days
        return delta
    except Exception:
        return None


def is_swing_position(symbol, journal):
    """Either explicitly tagged, or fallback heuristic: DTE was >=45 when opened."""
    rec = journal.get(symbol)
    if rec:
        return rec.get("protocol") == "swing"
    # Fallback: look at remaining DTE — if >30, treat as swing-eligible
    # (catches positions opened before Step 1 schema)
    dte = days_to_expiry_from_occ(symbol)
    return dte is not None and dte >= 30


# ─── Trail logic ─────────────────────────────────────────────────────────────

def determine_trail_pct(gain_pct):
    """Return (trail_pct, tier_label) or (None, None) if no trail yet."""
    if gain_pct >= 200: return (30, "+200% tier")
    if gain_pct >= 100: return (25, "+100% tier")
    if gain_pct >= 50:  return (20, "+50% tier")
    return (None, None)


def find_open_stop_for(symbol, open_orders):
    """Find existing sell stop-limit for this symbol."""
    for o in open_orders:
        if (o.get("symbol") == symbol
            and o.get("side") == "sell"
            and o.get("order_type") == "stop_limit"
            and float(o.get("qty", 0)) > 0):
            return o
    return None


def process_position(p, hwm_state, journal, open_orders):
    sym = p["symbol"]

    # Skip non-options (BTC, equities)
    if "/" in sym or len(sym) < 18:
        return

    if not is_swing_position(sym, journal):
        return  # Flow positions retain native OCO

    avg_entry = float(p["avg_entry_price"])
    current = float(p["current_price"])
    qty = int(float(p["qty"]))
    if qty <= 0:
        return

    # Update HWM
    rec = hwm_state.get(sym, {"hwm": current, "entry": avg_entry, "last_trail_pct": 0, "first_seen": datetime.now(timezone.utc).isoformat()})
    if current > rec["hwm"]:
        rec["hwm"] = current
    rec["entry"] = avg_entry  # refresh in case of partial fills
    rec["last_seen_price"] = current
    rec["last_seen"] = datetime.now(timezone.utc).isoformat()
    hwm_state[sym] = rec

    gain_from_entry = ((current - avg_entry) / avg_entry) * 100
    gain_from_hwm_basis = ((rec["hwm"] - avg_entry) / avg_entry) * 100

    trail_pct, tier_label = determine_trail_pct(gain_from_hwm_basis)
    if trail_pct is None:
        return  # Hasn't hit +50% yet, leave original SL alone

    # Compute new stop based on HWM
    new_stop_trigger = round(rec["hwm"] * (1 - trail_pct / 100), 2)
    new_stop_limit = round(new_stop_trigger * 0.92, 2)

    # Find existing stop order
    existing = find_open_stop_for(sym, open_orders)
    if not existing:
        log("no_stop_found", {"sym": sym, "would_set": new_stop_trigger})
        # Create one fresh
        new_order = submit_stop_limit(sym, qty, new_stop_trigger, new_stop_limit)
        if new_order:
            log("created_trail", {"sym": sym, "stop": new_stop_trigger, "limit": new_stop_limit, "tier": tier_label})
            post_discord(f"🪜 {sym} | new trail (no prior stop) | trigger ${new_stop_trigger:.2f} ({tier_label}, HWM ${rec['hwm']:.2f}, entry ${avg_entry:.2f})")
        return

    existing_stop = float(existing.get("stop_price", 0) or 0)

    # Only ratchet UP — never lower a stop
    if new_stop_trigger <= existing_stop:
        return

    # Cancel old, place new
    if cancel_order(existing["id"]):
        time.sleep(0.5)  # Alpaca needs a beat
        new_order = submit_stop_limit(sym, qty, new_stop_trigger, new_stop_limit)
        if new_order:
            old_pct = ((existing_stop - avg_entry) / avg_entry) * 100
            new_pct = ((new_stop_trigger - avg_entry) / avg_entry) * 100
            log("ratcheted", {
                "sym": sym, "old_stop": existing_stop, "new_stop": new_stop_trigger,
                "tier": tier_label, "hwm": rec["hwm"], "gain_pct": round(gain_from_entry, 1),
            })
            post_discord(
                f"🔼 **{sym}** trail ratcheted ({tier_label})\n"
                f"  Stop: ${existing_stop:.2f} → ${new_stop_trigger:.2f}  (lock-in {old_pct:+.0f}% → {new_pct:+.0f}%)\n"
                f"  HWM ${rec['hwm']:.2f} | now ${current:.2f} | entry ${avg_entry:.2f} | gain {gain_from_entry:+.1f}%"
            )
            rec["last_trail_pct"] = trail_pct
            rec["last_ratchet_at"] = datetime.now(timezone.utc).isoformat()
            rec["last_stop"] = new_stop_trigger
        else:
            log("ratchet_failed_resubmit", {"sym": sym})
            post_discord(f"⚠ {sym} stop CANCELED but failed to resubmit new stop — manual review needed")
    else:
        log("ratchet_failed_cancel", {"sym": sym})


def run_once():
    if not KEY or not SEC:
        log("fatal", "no Alpaca creds"); return

    hwm = load_hwm()
    journal = load_journal()
    positions = get_positions()
    open_orders = get_open_orders()

    swing_count = 0
    for p in positions:
        if "/" in p["symbol"]: continue
        if len(p["symbol"]) < 18: continue
        if is_swing_position(p["symbol"], journal):
            swing_count += 1
            try:
                process_position(p, hwm, journal, open_orders)
            except Exception as e:
                log("process_error", {"sym": p["symbol"], "err": str(e)})

    save_hwm(hwm)

    if swing_count == 0:
        log("idle", {"positions": len(positions), "swing": 0})


def main():
    assert_correct_account()
    log("startup", f"trail daemon online, polling every {POLL_INTERVAL_SEC}s")
    while True:
        try:
            run_once()
        except Exception as e:
            log("cycle_error", str(e))
        time.sleep(POLL_INTERVAL_SEC)


if __name__ == "__main__":
    if "--once" in sys.argv:
        run_once()
    else:
        main()
