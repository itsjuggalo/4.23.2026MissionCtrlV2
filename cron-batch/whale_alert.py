#!/usr/bin/env python3
"""whale_alert.py v2 — large on-chain transfer detector (NO API KEY required).

Monitors:
  - Ethereum: native ETH transfers + USDT/USDC ERC-20 transfers (Etherscan API)
  - Solana:   native SOL transfers + USDC SPL transfers (Solscan public API)
  - Bitcoin:  large transfers (mempool.space)
  - USD valuation via CoinGecko free tier

Threshold: $10M USD
Cooldown:  60 min per tx hash (state file)
Output:    discord_whale_flow_webhook
"""
import json, os, sys, time, hashlib, logging
from pathlib import Path
from datetime import datetime, timezone, timedelta
import requests

SECRETS = Path.home() / ".openclaw" / "secrets"
WEBHOOK = (SECRETS / "discord_whale_flow_webhook").read_text().strip()

# Etherscan API key (free tier, 5 req/sec, 100k/day)
_etherscan_key_path = SECRETS / "etherscan_api_key"
ETHERSCAN_KEY = _etherscan_key_path.read_text().strip() if _etherscan_key_path.exists() else None

STATE_DIR = Path.home() / ".openclaw" / "workspace" / "state"
STATE_DIR.mkdir(parents=True, exist_ok=True)
STATE_FILE = STATE_DIR / "whale_alert_state.json"

LOG_DIR = Path.home() / ".openclaw" / "workspace" / "logs"
LOG_DIR.mkdir(parents=True, exist_ok=True)
logging.basicConfig(
    filename=LOG_DIR / "whale_alert.log",
    level=logging.INFO,
    format="%(asctime)s %(levelname)s %(message)s",
)

THRESHOLD_USD = 10_000_000  # $10M
COOLDOWN_MIN  = 60
ALERTS_PER_RUN_MAX = 5  # cap so a noisy run doesn't spam


def load_state():
    if not STATE_FILE.exists(): return {"seen": {}}
    try: return json.loads(STATE_FILE.read_text())
    except: return {"seen": {}}

def save_state(s):
    # purge stale seen entries
    now = time.time()
    s["seen"] = {k: v for k, v in s["seen"].items() if (now - v) < COOLDOWN_MIN * 60 * 4}
    STATE_FILE.write_text(json.dumps(s, indent=2))

def already_seen(state, tx_hash):
    now = time.time()
    last = state["seen"].get(tx_hash)
    if last and (now - last) < COOLDOWN_MIN * 60:
        return True
    state["seen"][tx_hash] = now
    return False


def get_prices():
    """CoinGecko: ETH, SOL, BTC USD prices. Falls back to last cached if rate-limited."""
    cache_file = STATE_DIR / "whale_prices_cache.json"
    try:
        r = requests.get(
            "https://api.coingecko.com/api/v3/simple/price",
            params={"ids": "ethereum,solana,bitcoin", "vs_currencies": "usd"},
            timeout=10,
        )
        if r.status_code == 200:
            d = r.json()
            prices = {
                "ETH": d.get("ethereum", {}).get("usd", 0),
                "SOL": d.get("solana", {}).get("usd", 0),
                "BTC": d.get("bitcoin", {}).get("usd", 0),
            }
            cache_file.write_text(json.dumps(prices))
            return prices
    except Exception as e:
        logging.warning(f"coingecko fail: {e}")
    # Fallback to cache
    try:
        return json.loads(cache_file.read_text())
    except:
        return {"ETH": 3500, "SOL": 200, "BTC": 95000}  # safety fallback


def short_addr(a):
    if not a or len(a) < 14: return a
    return a[:6] + "..." + a[-4:]


# ─── Ethereum (Etherscan free tier — no key needed for basic ─────
def fetch_eth_large_transfers(prices):
    """Etherscan's free tier: latest block tx list. Filter for value > threshold/ETH price."""
    eth_price = prices.get("ETH", 3500)
    if eth_price <= 0: return []
    threshold_eth = THRESHOLD_USD / eth_price

    alerts = []
    try:
        # Get latest block number
        r = requests.get(
            "https://api.etherscan.io/v2/api",
            params={"chainid": 1, "module": "proxy", "action": "eth_blockNumber", "apikey": ETHERSCAN_KEY or ""},
            timeout=10,
        )
        if r.status_code != 200: return []
        block_hex = r.json().get("result", "0x0")
        block_num = int(block_hex, 16)

        # Fetch the latest block with full tx info
        r2 = requests.get(
            "https://api.etherscan.io/v2/api",
            params={
                "chainid": 1,
                "module": "proxy",
                "action": "eth_getBlockByNumber",
                "tag": block_hex,
                "boolean": "true",
                "apikey": ETHERSCAN_KEY or "",
            },
            timeout=10,
        )
        if r2.status_code != 200: return []
        block_data = r2.json().get("result", {})
        if not block_data: return []
        txs = block_data.get("transactions", [])

        for tx in txs:
            value_wei = int(tx.get("value", "0x0"), 16)
            value_eth = value_wei / 1e18
            value_usd = value_eth * eth_price
            if value_usd >= THRESHOLD_USD:
                alerts.append({
                    "chain": "ETH",
                    "asset": "ETH",
                    "amount": value_eth,
                    "amount_usd": value_usd,
                    "from": tx.get("from", "?"),
                    "to": tx.get("to", "?"),
                    "tx_hash": tx.get("hash", "?"),
                    "block": block_num,
                })
    except Exception as e:
        logging.warning(f"etherscan eth fail: {e}")
    return alerts


# ─── Bitcoin (mempool.space — no key needed) ─────────────────────
def fetch_btc_large_transfers(prices):
    """Mempool.space recent confirmed block transactions."""
    btc_price = prices.get("BTC", 95000)
    if btc_price <= 0: return []

    alerts = []
    try:
        # Get the latest block hash
        r = requests.get("https://mempool.space/api/blocks/tip/hash", timeout=10)
        if r.status_code != 200: return []
        block_hash = r.text.strip()

        # Fetch transaction summaries from latest block
        r2 = requests.get(f"https://mempool.space/api/block/{block_hash}/txids", timeout=10)
        if r2.status_code != 200: return []
        tx_ids = r2.json()[:50]  # check first 50 txs (most are coinbase + small)

        for txid in tx_ids:
            try:
                r3 = requests.get(f"https://mempool.space/api/tx/{txid}", timeout=8)
                if r3.status_code != 200: continue
                tx = r3.json()
                # Sum vout values
                total_sats = sum(out.get("value", 0) for out in tx.get("vout", []))
                value_btc = total_sats / 1e8
                value_usd = value_btc * btc_price
                if value_usd >= THRESHOLD_USD:
                    inp_addr = "?"
                    out_addr = "?"
                    if tx.get("vin"):
                        inp_addr = tx["vin"][0].get("prevout", {}).get("scriptpubkey_address", "?")
                    if tx.get("vout"):
                        out_addr = tx["vout"][0].get("scriptpubkey_address", "?")
                    alerts.append({
                        "chain": "BTC",
                        "asset": "BTC",
                        "amount": value_btc,
                        "amount_usd": value_usd,
                        "from": inp_addr,
                        "to": out_addr,
                        "tx_hash": txid,
                        "block": tx.get("status", {}).get("block_height", 0),
                    })
                if len(alerts) >= 3: break  # cap per chain per run
            except:
                continue
    except Exception as e:
        logging.warning(f"mempool btc fail: {e}")
    return alerts


# ─── ERC-20 stablecoin transfers (USDT/USDC) ─────────────────────
def fetch_erc20_large_transfers():
    """Etherscan tokentx list for USDT + USDC contracts. No price needed (1:1 USD)."""
    USDT_CONTRACT = "0xdAC17F958D2ee523a2206206994597C13D831ec7"
    USDC_CONTRACT = "0xA0b86991c6218b36c1d19D4a2e9Eb0cE3606eB48"

    alerts = []
    for symbol, contract, decimals in [("USDT", USDT_CONTRACT, 6), ("USDC", USDC_CONTRACT, 6)]:
        try:
            # Etherscan public token tx list — recent transfers (latest 100)
            r = requests.get(
                "https://api.etherscan.io/v2/api",
                params={
                    "chainid": 1,
                    "module": "account",
                    "action": "tokentx",
                    "contractaddress": contract,
                    "page": 1,
                    "offset": 100,
                    "sort": "desc",
                    "apikey": ETHERSCAN_KEY or "",
                },
                timeout=10,
            )
            if r.status_code != 200: continue
            d = r.json()
            if d.get("status") != "1": continue
            for tx in d.get("result", []):
                amount = int(tx.get("value", "0")) / (10 ** decimals)
                if amount >= THRESHOLD_USD:
                    alerts.append({
                        "chain": "ETH",
                        "asset": symbol,
                        "amount": amount,
                        "amount_usd": amount,  # stablecoin
                        "from": tx.get("from", "?"),
                        "to": tx.get("to", "?"),
                        "tx_hash": tx.get("hash", "?"),
                        "block": int(tx.get("blockNumber", 0)),
                    })
                if len(alerts) >= 5: break
        except Exception as e:
            logging.warning(f"erc20 {symbol} fail: {e}")
            continue
    return alerts


# ─── Solana via Solscan public API ──────────────────────────────
def fetch_sol_large_transfers(prices):
    """SOL coverage disabled — Solscan public API deprecated DNS.
    TODO: swap to Helius/QuickNode free RPC for SOL whale tracking."""
    return []


def post_alert(alert):
    asset = alert["asset"]
    emoji = EMOJI.get(asset, "💰")
    amount_str = f"{alert['amount']:,.2f} {asset}"
    usd_str = f"${alert['amount_usd']:,.0f}"
    embed = {
        "title": f"{emoji} Whale Alert — {asset} ${alert['amount_usd']/1e6:.1f}M",
        "color": 0xFFD700,
        "fields": [
            {"name": "Amount", "value": f"**{amount_str}**\n({usd_str})", "inline": True},
            {"name": "Chain", "value": alert["chain"], "inline": True},
            {"name": "Block", "value": str(alert.get("block", "?")), "inline": True},
            {"name": "From", "value": f"`{short_addr(alert['from'])}`", "inline": True},
            {"name": "To", "value": f"`{short_addr(alert['to'])}`", "inline": True},
            {"name": "Tx", "value": f"`{short_addr(alert['tx_hash'])}`", "inline": True},
        ],
        "timestamp": datetime.now(timezone.utc).isoformat(),
        "footer": {"text": "Mission Control · Whale Watch"},
    }
    try:
        r = requests.post(WEBHOOK, json={"embeds": [embed]}, timeout=10)
        return r.status_code in (200, 204)
    except Exception as e:
        logging.error(f"webhook post fail: {e}")
        return False


# ─── Main ────────────────────────────────────────────────────────
def main():
    state = load_state()
    prices = get_prices()
    if not any(prices.values()):
        print("[whale] no prices, skipping")
        return

    all_alerts = []
    all_alerts.extend(fetch_eth_large_transfers(prices))
    all_alerts.extend(fetch_btc_large_transfers(prices))
    all_alerts.extend(fetch_erc20_large_transfers())
    all_alerts.extend(fetch_sol_large_transfers(prices))

    # Filter by cooldown
    new_alerts = [a for a in all_alerts if not already_seen(state, a["tx_hash"])]
    # Sort biggest first
    new_alerts.sort(key=lambda x: x["amount_usd"], reverse=True)
    # Cap per run
    new_alerts = new_alerts[:ALERTS_PER_RUN_MAX]

    posted = 0
    for alert in new_alerts:
        if post_alert(alert):
            posted += 1
            logging.info(f"posted {alert['asset']} ${alert['amount_usd']:,.0f} chain={alert['chain']}")
            time.sleep(0.6)
    save_state(state)

    print(f"[whale] checked {len(all_alerts)} transfers ({len(all_alerts) - len(new_alerts)} cooled), posted {posted}")


if __name__ == "__main__":
    main()
