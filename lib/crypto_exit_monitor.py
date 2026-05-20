"""Check open crypto positions, close any that hit TP (+3%) or SL (-1.5%).
Called by boba/jazzy decision cycles BEFORE the buy logic each tick.
"""
import sys, json, requests
from pathlib import Path
SECRETS = Path("/home/ubuntu/.openclaw/secrets")
TP_PCT = 0.03   # +3%
SL_PCT = 0.015  # -1.5%

def _alpaca(account):
    key = (SECRETS / f"alpaca-{account}-key-id").read_text().strip()
    sec = (SECRETS / f"alpaca-{account}-secret").read_text().strip()
    return key, sec, "https://paper-api.alpaca.markets"

def run(account):
    key, sec, base = _alpaca(account)
    h = {"APCA-API-KEY-ID": key, "APCA-API-SECRET-KEY": sec}
    try:
        r = requests.get(f"{base}/v2/positions", headers=h, timeout=10)
        positions = r.json()
    except Exception as e:
        print(f"[crypto_exit/{account}] fetch fail: {e}")
        return
    for p in positions:
        sym = p.get("symbol", "")
        if "/" not in sym: continue  # skip non-crypto
        try:
            avg = float(p.get("avg_entry_price", 0))
            cur = float(p.get("current_price", 0))
            qty = p.get("qty", "0")
            if avg <= 0 or cur <= 0: continue
            pnl_pct = (cur - avg) / avg
            reason = None
            if pnl_pct >= TP_PCT: reason = f"TP +{pnl_pct*100:.2f}%"
            elif pnl_pct <= -SL_PCT: reason = f"SL {pnl_pct*100:.2f}%"
            if not reason: continue
            close = requests.delete(f"{base}/v2/positions/{sym.replace('/', '%2F')}",
                                     headers=h, timeout=15)
            ok = 200 <= close.status_code < 300
            print(f"[crypto_exit/{account}] {sym} {reason} → {'CLOSED' if ok else 'FAIL'} ({close.status_code})")
        except Exception as e:
            print(f"[crypto_exit/{account}] {sym} err: {e}")

if __name__ == "__main__":
    run(sys.argv[1] if len(sys.argv) > 1 else "boba")
