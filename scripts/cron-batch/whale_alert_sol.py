#!/usr/bin/env python3
"""
Whale Alert — SOL coverage via Helius Enhanced Transactions API.

Polls a curated list of CEX hot wallets every 5 min. Filters native SOL transfers
≥ MIN_USD threshold (default $10M). Dedupes by tx signature. Posts embed to
existing #whale-alerts webhook.

Wallets: Binance, Coinbase, Kraken, OKX, Bybit, KuCoin hot wallets (publicly known).

Free tier: 100K req/mo. 6 wallets × 12 polls/hr × 24 = 1,728/day → ~52K/mo, well under cap.
"""
import json, time, sys, logging, requests
from pathlib import Path
from datetime import datetime, timezone

SECRETS = Path.home() / ".openclaw" / "secrets"
HELIUS_KEY = (SECRETS / "helius_api_key").read_text().strip()
WEBHOOK = (SECRETS / "discord_whale_flow_webhook").read_text().strip()

STATE_DIR = Path.home() / ".openclaw" / "workspace" / "state"
STATE_DIR.mkdir(parents=True, exist_ok=True)
STATE_FILE = STATE_DIR / "whale_alert_sol_state.json"
LOG_DIR = Path.home() / ".openclaw" / "workspace" / "logs"
LOG_DIR.mkdir(parents=True, exist_ok=True)

logging.basicConfig(
    level=logging.INFO,
    format="%(asctime)s %(levelname)s %(message)s",
    handlers=[logging.FileHandler(LOG_DIR / "whale_alert_sol.log"), logging.StreamHandler()],
)
log = logging.getLogger("whale_sol")

MIN_USD = 10_000_000          # $10M threshold
LAMPORTS_PER_SOL = 1_000_000_000
COOLDOWN_MIN = 60             # don't repost same signature within 1h
TX_FETCH_LIMIT = 25           # last 25 tx per wallet per poll

# Publicly known SOL CEX hot wallets (from on-chain analytics: Arkham, Solscan tags)
WALLETS = [
    ("Binance Hot 1",  "5tzFkiKscXHK5ZXCGbXZxdw7gTjjD1mBwuoFbhUvuAi9"),
    ("Binance Hot 2",  "9WzDXwBbmkg8ZTbNMqUxvQRAyrZzDsGYdLVL9zYtAWWM"),
    ("Coinbase Hot",   "H8sMJSCQxfKiFTCfDR3DUMLPwcRbM61LGFJ8N4dK3WjS"),
    ("Kraken Hot",     "FWznbcNXWQuHTawe9RxvQ2LdCENssh12dsznf4RiouN5"),
    ("OKX Hot",        "5VCwKtCXgCJ6kit5FybXjvriW3xELsFDhYrPSqtJNmcD"),
    ("Bybit Hot",      "AC5RDfQFmDS1deWZos921JfqscXdByf8BKHs5ACWjtW2"),
]

def load_state():
    if not STATE_FILE.exists(): return {"seen": {}}
    try: return json.loads(STATE_FILE.read_text())
    except: return {"seen": {}}

def save_state(s):
    now = time.time()
    # purge entries older than 4× cooldown
    s["seen"] = {k: v for k, v in s["seen"].items() if (now - v) < COOLDOWN_MIN * 60 * 4}
    STATE_FILE.write_text(json.dumps(s, indent=2))

def get_sol_price():
    try:
        r = requests.get("https://api.coinbase.com/v2/prices/SOL-USD/spot", timeout=8)
        return float(r.json()["data"]["amount"])
    except Exception as e:
        log.warning(f"price fetch failed: {e}, falling back to $200")
        return 200.0

def fetch_wallet_tx(addr):
    url = f"https://api.helius.xyz/v0/addresses/{addr}/transactions"
    params = {"api-key": HELIUS_KEY, "limit": TX_FETCH_LIMIT}
    try:
        r = requests.get(url, params=params, timeout=15)
        if r.status_code != 200:
            log.warning(f"  {addr[:8]}...: HTTP {r.status_code}")
            return []
        return r.json() or []
    except Exception as e:
        log.warning(f"  {addr[:8]}...: {e}")
        return []

def label_for(addr):
    for name, a in WALLETS:
        if a == addr: return name
    return f"{addr[:6]}…{addr[-4:]}"

def post_alert(label, addr, native, sol_price):
    """native = a single nativeTransfer dict from a Helius tx."""
    sig = native["_sig"]
    sol_amount = native["amount"] / LAMPORTS_PER_SOL
    usd_value = sol_amount * sol_price
    direction = "OUT" if native["fromUserAccount"] == addr else "IN"
    counter_addr = native["toUserAccount"] if direction == "OUT" else native["fromUserAccount"]
    counter_label = label_for(counter_addr) if counter_addr in [w[1] for w in WALLETS] else f"{counter_addr[:6]}…{counter_addr[-4:]}"

    color = 0xef5350 if direction == "OUT" else 0x66bb6a
    arrow = "→" if direction == "OUT" else "←"

    embed = {
        "title": f"🐋 SOL whale transfer — ${usd_value/1_000_000:.2f}M",
        "description": f"**{label}** {arrow} **{counter_label}**",
        "color": color,
        "fields": [
            {"name": "Amount", "value": f"{sol_amount:,.0f} SOL", "inline": True},
            {"name": "Value (USD)", "value": f"${usd_value:,.0f}", "inline": True},
            {"name": "Direction", "value": direction, "inline": True},
            {"name": "Tx", "value": f"[{sig[:12]}…](https://solscan.io/tx/{sig})", "inline": False},
        ],
        "footer": {"text": f"SOL ≈ ${sol_price:.2f} · Helius"},
        "timestamp": datetime.now(timezone.utc).isoformat(),
    }
    try:
        r = requests.post(WEBHOOK, json={"embeds": [embed]}, timeout=10)
        if r.status_code in (200, 204):
            log.info(f"  ✓ POSTED {label} {direction} ${usd_value/1_000_000:.2f}M ({sig[:10]})")
            return True
        log.warning(f"  webhook {r.status_code}: {r.text[:120]}")
    except Exception as e:
        log.warning(f"  post failed: {e}")
    return False

def main():
    log.info(f"=== whale-alert-sol cycle (min=${MIN_USD/1e6:.0f}M, {len(WALLETS)} wallets) ===")
    state = load_state()
    seen = state["seen"]
    sol_price = get_sol_price()
    min_lamports = (MIN_USD / sol_price) * LAMPORTS_PER_SOL

    posted = 0; scanned = 0; matched = 0
    for label, addr in WALLETS:
        log.info(f"poll {label} ({addr[:8]}…)")
        txs = fetch_wallet_tx(addr)
        scanned += len(txs)
        for tx in txs:
            sig = tx.get("signature", "")
            if not sig or sig in seen: continue
            for nt in tx.get("nativeTransfers", []) or []:
                if nt.get("amount", 0) >= min_lamports:
                    nt["_sig"] = sig
                    matched += 1
                    if post_alert(label, addr, nt, sol_price):
                        seen[sig] = time.time()
                        posted += 1
                    time.sleep(0.5)
                    break  # one alert per tx
        time.sleep(0.4)  # rate-limit pacing between wallets

    state["seen"] = seen
    save_state(state)
    log.info(f"=== done: scanned {scanned} tx, matched {matched}, posted {posted} ===")

if __name__ == "__main__":
    main()
