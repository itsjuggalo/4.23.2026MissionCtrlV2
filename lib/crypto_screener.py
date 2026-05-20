"""Crypto day-trading screener with DYNAMIC Alpaca tradeable mapping.
Pulls Alpaca's full crypto asset list at startup, maps CoinGecko symbols to it.
Picks pumpers (5-30% 24h with volume backing).
"""
import requests, json, os
from pathlib import Path
from datetime import datetime, timezone

SECRETS = Path("/home/ubuntu/.openclaw/secrets")
MIN_MCAP = 100_000_000
MIN_VOL_24H = 5_000_000
MIN_CHG_24H = 5.0
MAX_CHG_24H = 30.0
MIN_SCORE = 60

# Cache of Alpaca-tradeable crypto symbols (filled at startup)
_ALPACA_USD_SYMBOLS = None

def _alpaca_creds(account="boba"):
    key = (SECRETS / f"alpaca-{account}-key-id").read_text().strip()
    sec = (SECRETS / f"alpaca-{account}-secret").read_text().strip()
    return key, sec

def fetch_alpaca_crypto_symbols():
    """Returns set of plain symbols (no /USD), e.g. {'BTC','ETH','ONDO',...}"""
    global _ALPACA_USD_SYMBOLS
    if _ALPACA_USD_SYMBOLS is not None: return _ALPACA_USD_SYMBOLS
    try:
        key, sec = _alpaca_creds("boba")
        r = requests.get(
            "https://paper-api.alpaca.markets/v2/assets",
            params={"asset_class": "crypto", "status": "active", "tradable": "true"},
            headers={"APCA-API-KEY-ID": key, "APCA-API-SECRET-KEY": sec},
            timeout=15,
        )
        r.raise_for_status()
        symbols = set()
        for a in r.json():
            sym = a.get("symbol", "")
            if sym.endswith("/USD"):
                symbols.add(sym.split("/")[0])
        _ALPACA_USD_SYMBOLS = symbols
        return symbols
    except Exception as e:
        print(f"[crypto_screener] alpaca symbol fetch fail: {e}")
        _ALPACA_USD_SYMBOLS = set()
        return _ALPACA_USD_SYMBOLS

_markets_cache = None
_markets_ts = 0
_MARKETS_CACHE_TTL = 60

def fetch_markets():
    """Pull top 100 by 24h volume from CoinPaprika. CoinGecko-shaped output."""
    global _markets_cache, _markets_ts
    import time as _t
    if _markets_cache is not None and _t.time() - _markets_ts < _MARKETS_CACHE_TTL:
        return _markets_cache
    try:
        r = requests.get("https://api.coinpaprika.com/v1/tickers", timeout=15)
        r.raise_for_status()
        raw = r.json()
        out = []
        for t in raw:
            q = (t.get("quotes") or {}).get("USD") or {}
            out.append({
                "id": t.get("id", ""),
                "symbol": (t.get("symbol") or "").lower(),
                "name": t.get("name", ""),
                "current_price": q.get("price"),
                "market_cap": q.get("market_cap"),
                "total_volume": q.get("volume_24h"),
                "price_change_percentage_24h": q.get("percent_change_24h"),
                "price_change_percentage_1h_in_currency": q.get("percent_change_1h"),
                "price_change_percentage_7d_in_currency": q.get("percent_change_7d"),
            })
        out.sort(key=lambda x: -(x.get("total_volume") or 0))
        out = out[:100]
        _markets_cache = out
        _markets_ts = _t.time()
        return out
    except Exception as e:
        print(f"[crypto_screener] coinpaprika fail: {e} (cache age {int(_t.time()-_markets_ts)}s)", flush=True)
        return _markets_cache or []


SYMBOL_ALIASES = {
    "MATIC": "POL",   # Polygon rebranded
    "RNDR": "RENDER", # Render network
}

def alpaca_symbol_for(coingecko_sym, alpaca_set):
    """Returns 'X/USD' if tradeable, else None."""
    sym = coingecko_sym.upper()
    sym = SYMBOL_ALIASES.get(sym, sym)
    if sym in alpaca_set:
        return f"{sym}/USD"
    return None

def score(c, alpaca_set):
    chg_24h = c.get("price_change_percentage_24h") or 0
    chg_1h = c.get("price_change_percentage_1h_in_currency") or 0
    chg_7d = c.get("price_change_percentage_7d_in_currency") or 0
    mc = c.get("market_cap") or 0
    vol = c.get("total_volume") or 0
    if mc < MIN_MCAP or vol < MIN_VOL_24H: return 0, None
    if chg_24h < MIN_CHG_24H or chg_24h > MAX_CHG_24H: return 0, None
    alpaca_sym = alpaca_symbol_for(c.get("symbol", ""), alpaca_set)
    if not alpaca_sym: return 0, None
    momentum_24h = min(chg_24h / MAX_CHG_24H * 25, 25)
    momentum_1h = min(max(chg_1h, 0) / 5 * 20, 20)
    turnover = min(vol / mc * 100, 30)
    alignment = 15 if (chg_1h > 0 and chg_24h > 0 and chg_7d > -5) else 0
    not_blowoff = 10 if chg_24h < 25 else 5
    return min(int(momentum_24h + momentum_1h + turnover + alignment + not_blowoff), 100), alpaca_sym

def get_top_picks(n=2):
    alpaca_set = fetch_alpaca_crypto_symbols()
    if not alpaca_set:
        print("[crypto_screener] alpaca symbol set empty - bailing")
        return []
    try:
        coins = fetch_markets()
    except Exception as e:
        print(f"[crypto_screener] coingecko fail: {e}")
        return []
    scored = []
    for c in coins:
        s, alpaca_sym = score(c, alpaca_set)
        if s >= MIN_SCORE:
            scored.append({
                "symbol": alpaca_sym,
                "name": c["name"],
                "score": s,
                "price": c["current_price"],
                "chg_1h": c.get("price_change_percentage_1h_in_currency"),
                "chg_24h": c.get("price_change_percentage_24h"),
                "chg_7d": c.get("price_change_percentage_7d_in_currency"),
                "volume": c.get("total_volume"),
                "mcap": c.get("market_cap"),
            })
    scored.sort(key=lambda x: -x["score"])
    return scored[:n]

if __name__ == "__main__":
    picks = get_top_picks(5)
    print(f"alpaca-tradeable crypto: {len(fetch_alpaca_crypto_symbols())} symbols")
    print(json.dumps(picks, indent=2))
