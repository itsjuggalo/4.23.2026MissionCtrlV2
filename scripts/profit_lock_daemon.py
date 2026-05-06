#!/usr/bin/env python3
"""
profit_lock_daemon — ratchets stop_limit orders up as positions gain.

Runs every 60s via PM2. For each R2 options position with unrealized gain:
- Cross +20% gain  -> stop arms at break-even (entry price)
- Cross +50% gain  -> stop ratchets to entry +20% (locks 20% min)
- Cross +100% gain -> stop ratchets to entry +50% (locks 50% min)
- Cross +200% gain -> stop ratchets to entry +100% (locks 100% min)

Only RATCHETS UP. Never lowers existing stops.

Account lock: PA3QIBJEYMB3 (R2). Will refuse to run on any other account.
Skips: stocks, crypto, positions without unrealized gain.
"""
import json, sys, time
from datetime import datetime, timezone
from pathlib import Path
import requests

SECRETS = Path.home() / ".openclaw" / "secrets"
STATE_DIR = Path.home() / ".openclaw" / "workspace" / "state"
STATE_DIR.mkdir(parents=True, exist_ok=True)
LOCK_STATE = STATE_DIR / "profit_lock_state.json"
LOG_FILE = Path.home() / ".openclaw" / "workspace" / "memory" / "profit_lock_daemon.jsonl"
LOG_FILE.parent.mkdir(parents=True, exist_ok=True)

POLL_INTERVAL_SEC = 20
ALPACA_BASE = "https://paper-api.alpaca.markets/v2"
EXPECTED_ACCOUNT = "PA3QIBJEYMB3"

def _read(name):
    p = SECRETS / name
    return p.read_text().strip() if p.exists() else ""

KEY = _read("alpaca-key-id")
SEC = _read("alpaca-secret")
HEADERS = {"APCA-API-KEY-ID": KEY, "APCA-API-SECRET-KEY": SEC, "Content-Type": "application/json"}

def log(action, detail):
    entry = {"ts": datetime.now(timezone.utc).isoformat(), "action": action, "detail": detail}
    with LOG_FILE.open("a") as f:
        f.write(json.dumps(entry) + "\n")
    print(f"[profit-lock] {action}: {str(detail)[:300]}", flush=True)

def assert_account():
    r = requests.get(f"{ALPACA_BASE}/account", headers=HEADERS, timeout=10)
    if r.status_code != 200:
        log("fatal", f"Cannot reach Alpaca: HTTP {r.status_code}")
        raise SystemExit(1)
    actual = r.json().get("account_number", "")
    if actual != EXPECTED_ACCOUNT:
        log("fatal_account", f"Expected R2 ({EXPECTED_ACCOUNT}) but got {actual}. Refusing to run.")
        raise SystemExit(2)
    eq = float(r.json().get("equity", 0))
    log("startup", f"Confirmed R2 {actual} equity ${eq:,.0f}")

def get_positions():
    r = requests.get(f"{ALPACA_BASE}/positions", headers=HEADERS, timeout=15)
    return r.json() if r.status_code == 200 else []

def get_open_orders():
    r = requests.get(f"{ALPACA_BASE}/orders?status=open&limit=100", headers=HEADERS, timeout=15)
    return r.json() if r.status_code == 200 else []

def cancel_order(oid):
    r = requests.delete(f"{ALPACA_BASE}/orders/{oid}", headers=HEADERS, timeout=15)
    return r.status_code in (200, 204, 207)

def place_stop_limit(sym, qty, stop_price, limit_price, tif="gtc"):
    payload = {
        "symbol": sym, "qty": str(qty), "side": "sell",
        "type": "stop_limit",
        "stop_price": f"{stop_price:.2f}", "limit_price": f"{limit_price:.2f}",
        "time_in_force": tif, "position_intent": "sell_to_close"
    }
    r = requests.post(f"{ALPACA_BASE}/orders", headers=HEADERS, json=payload, timeout=15)
    if r.status_code in (200, 201):
        return r.json()
    log("stop_place_fail", f"{sym} HTTP {r.status_code}: {r.text[:200]}")
    return None

GIVEBACK_PCT = 7.0  # NEW: percentage of CURRENT PEAK PRICE (not entry-relative pp). Trail = peak * (1 - 7/100).
FREE_TRADE_PEAK_PCT = 10.0  # NEW: at peak >= +10%, lock stop at FREE_TRADE_LOCK_PCT
FREE_TRADE_LOCK_PCT = 2.0   # NEW: free-trade safety lock above entry
TRAIL_START_PEAK_PCT = 20.0 # NEW: at peak >= +20%, percentage-of-peak trail kicks in

def calc_tier_floor(gain_pct, last_locked_pct):
    """Return (new_floor_pct, tier_label) when gain crosses next tier; else (None, None).
    Floor = entry-relative locked-pct that ratchets up at +20/+50/+100/+200."""
    if gain_pct >= 200 and last_locked_pct < 100:
        return (100, "+200% tier (floor +100%)")
    if gain_pct >= 100 and last_locked_pct < 50:
        return (50, "+100% tier (floor +50%)")
    if gain_pct >= 50 and last_locked_pct < 20:
        return (20, "+50% tier (floor +20%)")
    if gain_pct >= 20 and last_locked_pct < 0:
        return (0, "+20% tier (floor break-even)")
    return (None, None)

def calc_target_stop(entry, current, last_locked_pct, peak_pct):
    """Return (new_stop_pct_from_entry, label) or (None, None) if no upgrade.
    Combines tier-floor (entry-relative ratchet) + peak-tracker (HWM minus giveback)."""
    gain_pct = ((current - entry) / entry) * 100
    tier_pct, tier_label = calc_tier_floor(gain_pct, last_locked_pct)
    # Peak-tracker target: peak minus giveback. Only valid once peak >= +20 (don't trail negatives).
    peak_target = None
    if peak_pct >= TRAIL_START_PEAK_PCT:
        # NEW: percentage-of-peak-PRICE trail. peak_price = entry*(1+peak_pct/100); stop = peak_price*(1-GIVEBACK/100)
        peak_target = ((1 + peak_pct / 100.0) * (1 - GIVEBACK_PCT / 100.0) - 1) * 100.0
    elif peak_pct >= FREE_TRADE_PEAK_PCT:
        peak_target = FREE_TRADE_LOCK_PCT
    # Final target = max of the three (existing locked, tier floor, peak target)
    candidates = [last_locked_pct]
    if tier_pct is not None: candidates.append(tier_pct)
    if peak_target is not None: candidates.append(peak_target)
    best = max(candidates)
    if best <= last_locked_pct:
        return (None, None)
    # Round to 1 decimal place to keep stops clean
    best = round(best, 1)
    if peak_target is not None and best == round(peak_target, 1) and (tier_pct is None or peak_target > tier_pct):
        label = f"peak-trail (peak {peak_pct:+.1f}% * (1-{GIVEBACK_PCT:.0f}%) = lock {best:+.1f}%)" if peak_pct >= TRAIL_START_PEAK_PCT else f"free-trade (peak {peak_pct:+.1f}% -> lock +{FREE_TRADE_LOCK_PCT:.0f}%)"
    elif tier_label:
        label = tier_label
    else:
        label = f"floor lock {best:+.1f}%"
    return (best, label)

def is_option_symbol(sym):
    """Detect OCC option symbol (e.g. NVDA260508P00202500)."""
    if not sym or len(sym) < 15: return False
    return any(c.isdigit() for c in sym[-15:]) and (sym[-9] in ("C","P"))

def cleanup_orphans(positions, orders):
    """Cancel sell orders whose qty exceeds current position qty (orphan legs from filled SL or TP).
    Returns count of orders cancelled."""
    pos_qty = {}
    for p in positions:
        sym = p.get("symbol", "")
        if not is_option_symbol(sym):
            continue
        try:
            pos_qty[sym] = int(float(p.get("qty", 0)))
        except: pass
    
    cancelled = 0
    by_sym = {}
    for o in orders:
        if o.get("side") != "sell": continue
        sym = o.get("symbol", "")
        if not is_option_symbol(sym): continue
        by_sym.setdefault(sym, []).append(o)
    
    for sym, sell_orders in by_sym.items():
        cur_qty = pos_qty.get(sym, 0)
        # If we hold 0 contracts but have open sell orders, all are orphans
        if cur_qty == 0:
            for o in sell_orders:
                try:
                    cancel_order(o.get("id"))
                    cancelled += 1
                    log("orphan_cancel", f"{sym} qty=0 cancelled stale {o.get('order_type')} order {o.get('id','')[:8]}")
                except: pass
            continue
        # If sum of sell-order qtys exceeds position qty, cancel oldest until sum <= position qty
        total_sell = 0
        try:
            total_sell = sum(int(float(o.get("qty", 0))) for o in sell_orders)
        except: pass
        if total_sell > cur_qty:
            # Sort by created_at ascending (oldest first)
            sorted_orders = sorted(sell_orders, key=lambda o: o.get("created_at",""))
            excess = total_sell - cur_qty
            for o in sorted_orders:
                if excess <= 0: break
                try:
                    oq = int(float(o.get("qty", 0)))
                    cancel_order(o.get("id"))
                    cancelled += 1
                    excess -= oq
                    log("orphan_cancel", f"{sym} cur_qty={cur_qty} total_sell={total_sell} cancelled {o.get('order_type')} qty={oq} {o.get('id','')[:8]}")
                except: pass
    return cancelled

def cycle(state):
    positions = get_positions()
    orders = get_open_orders()
    
    # Layer 1: orphan cleanup before peak-tracking work
    orphans = cleanup_orphans(positions, orders)
    if orphans > 0:
        # Re-fetch orders since we just cancelled some
        import time as _t
        _t.sleep(1)
        orders = get_open_orders()
    
    summary = {"checked": 0, "locks_added": 0, "locks_upgraded": 0, "skipped": 0}
    
    for p in positions:
        sym = p.get("symbol", "")
        if not is_option_symbol(sym):
            summary["skipped"] += 1
            continue
        
        qty = int(float(p.get("qty", 0)))
        if qty <= 0:
            summary["skipped"] += 1
            continue
        
        entry = float(p.get("avg_entry_price", 0))
        current = float(p.get("current_price", 0))
        if entry <= 0 or current <= 0:
            summary["skipped"] += 1
            continue
        
        gain_pct = ((current - entry) / entry) * 100
        summary["checked"] += 1
        
        rec = state.get(sym, {"locked_pct": -999, "peak_pct": gain_pct, "first_seen": datetime.now(timezone.utc).isoformat()})
        last_locked = rec.get("locked_pct", -999)
        peak_pct = max(rec.get("peak_pct", gain_pct), gain_pct)
        rec["peak_pct"] = peak_pct
        
        new_pct, tier = calc_target_stop(entry, current, last_locked, peak_pct)
        
        if new_pct is None:
            continue
        
        # Compute new stop price = entry * (1 + new_pct/100)
        new_stop = round(entry * (1 + new_pct / 100), 2)
        new_limit = round(new_stop - 0.10, 2)
        if new_limit < 0.05:
            new_limit = 0.05
        
        # Find existing protective stop_limit orders for this symbol
        existing_stops = [o for o in orders if o.get("symbol") == sym and o.get("order_type") == "stop_limit" and o.get("side") == "sell"]
        
        # Check if existing stop is already >= new_stop (don't downgrade)
        skip_replace = False
        for eo in existing_stops:
            try:
                existing_stop_price = float(eo.get("stop_price", 0))
                if existing_stop_price >= new_stop:
                    skip_replace = True
                    break
            except: pass
        
        if skip_replace:
            continue
        
        # Cancel existing protective stops for this sym
        for eo in existing_stops:
            cancel_order(eo.get("id"))
            time.sleep(0.3)
        
        # Place new stop
        result = place_stop_limit(sym, qty, new_stop, new_limit)
        if result:
            action = "lock_added" if last_locked == -999 else "lock_upgraded"
            summary[f"locks_{'added' if last_locked == -999 else 'upgraded'}"] += 1
            log(action, f"{sym} qty={qty} gain={gain_pct:+.1f}% peak={peak_pct:+.1f}% -> stop ${new_stop:.2f} (lock {new_pct:+.1f}% from entry) | {tier}")
            rec["locked_pct"] = new_pct
            rec["last_stop"] = new_stop
            rec["last_update"] = datetime.now(timezone.utc).isoformat()
            state[sym] = rec
    
    if summary["checked"] > 0 or summary["locks_added"] > 0:
        log("cycle", summary)
    return state

def load_state():
    if LOCK_STATE.exists():
        try: return json.loads(LOCK_STATE.read_text())
        except: pass
    return {}

def save_state(state):
    tmp = LOCK_STATE.with_suffix(".json.tmp")
    tmp.write_text(json.dumps(state, indent=2))
    tmp.replace(LOCK_STATE)

def main():
    assert_account()
    state = load_state()
    log("startup", f"profit_lock_daemon online, polling every {POLL_INTERVAL_SEC}s")
    while True:
        try:
            state = cycle(state)
            save_state(state)
        except Exception as e:
            log("cycle_error", str(e))
        time.sleep(POLL_INTERVAL_SEC)

if __name__ == "__main__":
    try:
        main()
    except KeyboardInterrupt:
        pass
