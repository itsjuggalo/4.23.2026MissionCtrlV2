"""Crypto Profit-Lock Daemon — ratchets stops UP as positions run.
Mirrors options profit-lock pattern with crypto-appropriate milestones.

Tiers (peak/avg gain → trail giveback from peak):
  +5%   → 3% trail (lock floor at peak * 0.97)
  +10%  → 5% trail (peak * 0.95)
  +20%  → 8% trail (peak * 0.92)
  +40%  → 12% trail (peak * 0.88)

Peak price tracked persistently per (account, symbol) in state file.
Polls Alpaca every 60s. Closes position when current < active lock.
"""
import sys, json, time, requests
from pathlib import Path
from datetime import datetime, timezone

SECRETS = Path("/home/ubuntu/.openclaw/secrets")
STATE_DIR = Path("/home/ubuntu/.openclaw/workspace/state")
STATE_DIR.mkdir(parents=True, exist_ok=True)
POLL = 60  # seconds

# (gain_pct, trail_giveback_pct)
TIERS = [
    (0.05, 0.03),   # +5% → 3% trail
    (0.10, 0.05),   # +10% → 5% trail
    (0.20, 0.08),   # +20% → 8% trail
    (0.40, 0.12),   # +40% → 12% trail
]

ACCOUNT = sys.argv[1] if len(sys.argv) > 1 else "boba"
STATE_FILE = STATE_DIR / f"crypto_profit_lock_{ACCOUNT}.json"

def _alpaca():
    key = (SECRETS / f"alpaca-{ACCOUNT}-key-id").read_text().strip()
    sec = (SECRETS / f"alpaca-{ACCOUNT}-secret").read_text().strip()
    return key, sec, "https://paper-api.alpaca.markets"

def _hdr():
    k, s, _ = _alpaca()
    return {"APCA-API-KEY-ID": k, "APCA-API-SECRET-KEY": s}

def _load_state():
    if STATE_FILE.exists():
        try: return json.loads(STATE_FILE.read_text())
        except: return {}
    return {}

def _save_state(s):
    STATE_FILE.write_text(json.dumps(s, indent=2))

def compute_lock_price(avg, peak):
    """Walk tiers, return highest active lock floor."""
    if avg <= 0 or peak <= 0: return None
    gain = (peak - avg) / avg
    lock = None
    for tier_gain, trail_pct in TIERS:
        if gain >= tier_gain:
            lock = peak * (1 - trail_pct)
    return lock

def cycle():
    _, _, base = _alpaca()
    state = _load_state()
    try:
        r = requests.get(f"{base}/v2/positions", headers=_hdr(), timeout=10)
        positions = r.json()
    except Exception as e:
        print(f"[{ts()}] fetch fail: {e}", flush=True)
        return
    seen = set()
    for p in positions:
        sym = p.get("symbol", "")
        if "/" not in sym: continue  # crypto only
        try:
            avg = float(p.get("avg_entry_price", 0))
            cur = float(p.get("current_price", 0))
            if avg <= 0 or cur <= 0: continue
            seen.add(sym)
            ps = state.get(sym, {"peak": cur, "lock": None, "tier": 0})
            if cur > ps["peak"]:
                ps["peak"] = cur
            new_lock = compute_lock_price(avg, ps["peak"])
            if new_lock and (ps.get("lock") is None or new_lock > ps["lock"]):
                ps["lock"] = new_lock
                gain = (ps["peak"] - avg) / avg * 100
                print(f"[{ts()}] {sym} peak ${ps['peak']:.6f} (+{gain:.2f}%) → lock floor ${new_lock:.6f}", flush=True)
            state[sym] = ps
            # Trigger close?
            if ps["lock"] and cur < ps["lock"]:
                close = requests.delete(
                    f"{base}/v2/positions/{sym.replace('/', '%2F')}",
                    headers=_hdr(), timeout=15,
                )
                ok = 200 <= close.status_code < 300
                gain = (cur - avg) / avg * 100
                print(f"[{ts()}] {sym} HIT LOCK at ${cur:.6f} (was peak ${ps['peak']:.6f}, +{gain:+.2f}%) → {'CLOSED' if ok else 'FAIL'}", flush=True)
                state.pop(sym, None)
        except Exception as e:
            print(f"[{ts()}] {sym} err: {e}", flush=True)
    # Drop state for closed positions
    for k in list(state.keys()):
        if k not in seen: state.pop(k)
    _save_state(state)

def ts():
    return datetime.now(timezone.utc).astimezone().strftime("%Y-%m-%d %H:%M:%S")

def main():
    print(f"[{ts()}] crypto-profit-lock starting (account={ACCOUNT}, poll={POLL}s)", flush=True)
    while True:
        try: cycle()
        except Exception as e: print(f"[{ts()}] cycle err: {e}", flush=True)
        time.sleep(POLL)

if __name__ == "__main__":
    main()
