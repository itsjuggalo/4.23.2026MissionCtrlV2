"""Returns which exchanges list a given crypto symbol.
Caches Coinbase + Hyperliquid lists for 1 hour.
Robinhood is hardcoded (no clean public API).
"""
import requests, time
from pathlib import Path

CACHE = Path("/tmp/exchange_lookup_cache.txt")
CACHE_TTL = 3600  # 1 hour

# Robinhood Crypto supported symbols (manual — they don't publish a clean API)
# Source: https://robinhood.com/us/en/support/articles/crypto-trading-on-robinhood/
ROBINHOOD_SYMBOLS = {
    "AAVE","ADA","ARB","ATOM","AVAX","BAT","BCH","BSV","BTC","COMP","DOGE",
    "DOT","ETC","ETH","LINK","LTC","MATIC","POL","SHIB","SOL","UNI","USDC",
    "XLM","XRP","XTZ",
}

_cb_cache = None
_cb_ts = 0
_hl_cache = None
_hl_ts = 0

# Hardcoded fallback if Coinbase API is flaky (top 80 most liquid USD-tradeable on Coinbase)
COINBASE_FALLBACK = {
    "BTC","ETH","SOL","XRP","ADA","DOGE","AVAX","DOT","LINK","MATIC","POL",
    "SHIB","UNI","AAVE","BCH","LTC","ATOM","FIL","ALGO","XLM","XTZ","NEAR",
    "ETC","HBAR","CRO","APT","ARB","OP","SUI","SEI","INJ","JTO","TIA","MKR",
    "GRT","CRV","SNX","COMP","YFI","BAL","REN","KNC","BAND","UMA","ZRX","BAT",
    "MANA","SAND","AXS","ENJ","CHZ","APE","BONK","WIF","PEPE","FLOKI","ONDO",
    "RENDER","RNDR","FET","AGIX","OCEAN","TAO","WLD","ARKM","JUP","PYTH",
    "STRK","ENA","ETHFI","W","ZEC","XMR","DASH","NMR","RAY","FXS","LDO",
    "PAXG","USDC","USDT","DAI","LUNC","TRX","BSV","XCN","MASK",
}

def fetch_coinbase_symbols():
    """Returns set of base symbols listed on Coinbase (USD pairs)."""
    global _cb_cache, _cb_ts
    if _cb_cache and time.time() - _cb_ts < CACHE_TTL:
        return _cb_cache
    # Try v2 currencies endpoint first (more stable than exchange API)
    for url in ["https://api.coinbase.com/v2/currencies/crypto",
                "https://api.exchange.coinbase.com/currencies"]:
        try:
            r = requests.get(url, timeout=10)
            r.raise_for_status()
            data = r.json()
            out = set()
            # Coinbase v2 returns {"data": [{"code": "BTC", ...}]}
            items = data.get("data") if isinstance(data, dict) else data
            for c in items:
                code = c.get("code") or c.get("id") or ""
                if code: out.add(code.upper())
            if out:
                _cb_cache = out
                _cb_ts = time.time()
                return out
        except Exception as e:
            print(f"[exchange_lookup] coinbase {url} fail: {e}")
    # Fallback to hardcoded if both APIs fail
    print(f"[exchange_lookup] using hardcoded coinbase fallback ({len(COINBASE_FALLBACK)} symbols)")
    return COINBASE_FALLBACK

def fetch_hyperliquid_symbols():
    """Returns set of symbols listed as perps on Hyperliquid."""
    global _hl_cache, _hl_ts
    if _hl_cache and time.time() - _hl_ts < CACHE_TTL:
        return _hl_cache
    try:
        r = requests.post("https://api.hyperliquid.xyz/info",
                          json={"type": "meta"}, timeout=10)
        r.raise_for_status()
        out = set()
        for u in r.json().get("universe", []):
            sym = u.get("name", "").upper()
            if sym: out.add(sym)
        _hl_cache = out
        _hl_ts = time.time()
        return out
    except Exception as e:
        print(f"[exchange_lookup] hyperliquid fail: {e}")
        return _hl_cache or set()

def availability(symbol_upper):
    """Returns dict {alpaca: bool?, coinbase: bool, robinhood: bool, hyperliquid: bool}.
    Caller checks alpaca separately (already done in screener)."""
    return {
        "coinbase":    symbol_upper in fetch_coinbase_symbols(),
        "robinhood":   symbol_upper in ROBINHOOD_SYMBOLS,
        "hyperliquid": symbol_upper in fetch_hyperliquid_symbols(),
    }

if __name__ == "__main__":
    cb = fetch_coinbase_symbols()
    hl = fetch_hyperliquid_symbols()
    print(f"coinbase: {len(cb)} symbols")
    print(f"hyperliquid: {len(hl)} symbols")
    print(f"robinhood: {len(ROBINHOOD_SYMBOLS)} symbols")
    for sym in ["BTC","ETH","ONDO","WLFI","ZEC","TRUMP","WIF"]:
        a = availability(sym)
        print(f"  {sym}: cb={a['coinbase']} rh={a['robinhood']} hl={a['hyperliquid']}")
