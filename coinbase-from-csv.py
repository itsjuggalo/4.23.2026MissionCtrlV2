#!/usr/bin/env python3
# /// script
# requires-python = ">=3.9"
# dependencies = ["yfinance"]
# ///
"""Coinbase wallet data sourced from ~/portfolio/coinbase_holdings.json.

Reads the parsed CSV holdings, fetches current prices via yfinance, emits
JSON the wallets route shapes into a wallet block:
  { holdings: [{currency, balance, price_usd, value_usd}],
    total_usd, account_count, as_of }

Read-only and offline-safe — no Coinbase API call, no auth required.
Replaces the previous live-API (JWT) block after CSV ingest became the source.
"""
import json
import sys
import warnings
from pathlib import Path

warnings.filterwarnings("ignore")
import yfinance as yf

HOLDINGS = Path.home() / "portfolio" / "coinbase_holdings.json"
STABLES = {"USDC", "USDT", "DAI", "BUSD", "USD"}

if not HOLDINGS.exists():
    print(json.dumps({
        "error": "no ~/portfolio/coinbase_holdings.json — upload a Coinbase CSV first"
    }))
    sys.exit(0)

d = json.load(open(HOLDINGS))
raw = d.get("holdings", [])

yf_syms = [h["symbol"] + "-USD" for h in raw if h["symbol"] not in STABLES]

prices = {}
if yf_syms:
    data = yf.download(yf_syms, period="2d", progress=False,
                       auto_adjust=False, group_by="ticker")
    for y in yf_syms:
        try:
            if len(set(yf_syms)) == 1:
                px = float(data["Close"].iloc[-1])
            else:
                px = float(data[y]["Close"].iloc[-1])
            prices[y] = px if px == px else 0.0
        except Exception:
            prices[y] = 0.0

holdings = []
total = 0.0
for h in raw:
    sym = h["symbol"]
    if sym in STABLES:
        px = 1.0
    else:
        px = prices.get(sym + "-USD", 0.0)
    bal = h["quantity"]
    val = bal * px
    total += val
    holdings.append({
        "currency": sym,
        "balance": round(bal, 8),
        "price_usd": round(px, 4),
        "value_usd": round(val, 2),
    })

holdings.sort(key=lambda h: -h["value_usd"])

print(json.dumps({
    "holdings": holdings,
    "total_usd": round(total, 2),
    "account_count": len(holdings),
    "as_of": d.get("as_of"),
    "source": "csv",
}))
