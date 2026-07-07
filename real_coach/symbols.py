"""symbols.py — route a book position to a chartable data symbol (or honest triage).

Stocks pass through to yfinance as-is (XXRP/XRPT/BTC-the-ETF are real NYSE tickers).
Crypto tries yfinance "<SYM>-USD" (works for every major + most of Mike's alts);
anything without ≥60 daily bars degrades to TRIAGE mode — price/value only via
CoinGecko, never fake TA. CG id map lifted from labs/quantum cb_rh_crypto_watch.py
(only Mike's held coins; unmapped symbols are skipped, never guessed).
"""
from __future__ import annotations

import json
import urllib.parse
import urllib.request

# symbol -> CoinGecko id (triage pricing for alts with no yfinance history)
CG_ID = {
    "BTC": "bitcoin", "ETH": "ethereum", "DOGE": "dogecoin", "XRP": "ripple",
    "SOL": "solana", "AVAX": "avalanche-2", "ETC": "ethereum-classic", "LTC": "litecoin",
    "XLM": "stellar", "ALGO": "algorand", "HBAR": "hedera-hashgraph", "JASMY": "jasmycoin",
    "CRO": "crypto-com-chain", "SHIB": "shiba-inu", "GRT": "the-graph", "UNI": "uniswap",
    "RNDR": "render-token", "COTI": "coti", "LRC": "loopring", "AMP": "amp-token",
    "XCN": "onyxcoin", "AUCTION": "auction", "CLV": "clover-finance",
}

# yfinance alias fixes (renames/quirks)
YF_ALIAS = {"RNDR": "RENDER-USD"}

CG_URL = "https://api.coingecko.com/api/v3/simple/price"


def ta_symbol(symbol: str, asset_class: str) -> str:
    """Best-guess chartable symbol. Caller must still handle insufficient-data."""
    s = symbol.upper()
    if asset_class == "crypto":
        return YF_ALIAS.get(s, f"{s}-USD")
    return s  # stocks/ETFs as-is


def cg_prices(symbols: list[str]) -> dict[str, dict]:
    """{SYM: {usd, usd_24h_change}} for mapped coins via CoinGecko (free, no key)."""
    ids = {CG_ID[s]: s for s in symbols if s in CG_ID}
    if not ids:
        return {}
    q = urllib.parse.urlencode({"ids": ",".join(sorted(ids)), "vs_currencies": "usd",
                                "include_24hr_change": "true"})
    try:
        req = urllib.request.Request(f"{CG_URL}?{q}", headers={"User-Agent": "real-coach/1.0"})
        with urllib.request.urlopen(req, timeout=20) as r:
            raw = json.loads(r.read().decode())
        return {sym: raw[cid] for cid, sym in ids.items() if cid in raw}
    except Exception:
        return {}
