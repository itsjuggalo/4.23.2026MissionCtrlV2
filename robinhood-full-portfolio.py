#!/usr/bin/env python3
# /// script
# requires-python = ">=3.9"
# dependencies = ["yfinance"]
# ///
"""Robinhood wallet data sourced from ~/portfolio/robinhood_holdings.json.

Reads the parsed CSV holdings (positions of record), fetches current prices
via yfinance, and emits the JSON contract /api/wallets/route.ts expects:
  { stocks: [...], crypto: [...], stock_total, crypto_total, cash, as_of }

Read-only and offline-safe — no Robinhood API call, no auth required.
Replaces the previous live-API version after CSV ingest became the source.
"""
import json
import sys
import warnings
from pathlib import Path

warnings.filterwarnings("ignore")
import yfinance as yf

CRYPTO = {"BTC", "ETH", "SOL", "XRP", "DOGE", "ADA", "AVAX", "MATIC", "LINK",
          "DOT", "LTC", "BCH", "XLM", "ALGO", "ATOM", "UNI", "AAVE", "SHIB",
          "POL", "HYPE", "GRT", "SAND", "MANA", "FIL", "NEAR", "APE", "PEPE",
          "FET", "ICP", "RNDR", "OP", "ARB"}

HOLDINGS = Path.home() / "portfolio" / "robinhood_holdings.json"

if not HOLDINGS.exists():
    print(json.dumps({
        "error": "no ~/portfolio/robinhood_holdings.json — upload a Robinhood CSV first"
    }))
    sys.exit(0)

d = json.load(open(HOLDINGS))
raw = d.get("holdings", [])

# robinhood_holdings.json is the EQUITIES file (positions of record from the
# :3011 keeper). It can carry junk $0-basis crypto-symbol artifacts (e.g. a
# phantom "BTC 0.4") that, if priced at crypto spot, balloon the book. The
# authoritative RH crypto is the dedicated live snapshot below — so when that
# snapshot exists we IGNORE crypto-symbol rows here (no phantom, no double-count)
# and only mine equities. Fall back to CSV-derived crypto only if it's missing.
crypto_snap = Path.home() / "portfolio" / "robinhood_crypto_holdings.json"
have_live_crypto = crypto_snap.exists()

stock_in = [h for h in raw if h["symbol"] not in CRYPTO]
crypto_in = [] if have_live_crypto else [h for h in raw if h["symbol"] in CRYPTO]
all_yf = ([h["symbol"] for h in stock_in]
          + [h["symbol"] + "-USD" for h in crypto_in])

prices = {}
if all_yf:
    data = yf.download(all_yf, period="2d", progress=False,
                       auto_adjust=False, group_by="ticker")
    for s in all_yf:
        try:
            if len(set(all_yf)) == 1:
                px = float(data["Close"].iloc[-1])
            else:
                px = float(data[s]["Close"].iloc[-1])
            prices[s] = px if px == px else 0.0
        except Exception:
            prices[s] = 0.0

stocks = []
for h in stock_in:
    sym = h["symbol"]
    px = prices.get(sym, 0.0)
    qty = h["quantity"]
    avg = h.get("avg_cost", 0.0)
    eq = qty * px
    pct = ((px - avg) / avg * 100) if avg > 0 else 0.0
    stocks.append({
        "symbol": sym,
        "quantity": round(qty, 6),
        "avg_cost": round(avg, 4),
        "price": round(px, 4),
        "equity": round(eq, 2),
        "pct_change": round(pct, 2),
    })

crypto = []
for h in crypto_in:
    sym = h["symbol"]
    yfs = sym + "-USD"
    px = prices.get(yfs, 0.0)
    qty = h["quantity"]
    eq = qty * px
    crypto.append({
        "symbol": sym,
        "quantity": round(qty, 8),
        "price": round(px, 4),
        "equity": round(eq, 2),
    })

# Robinhood Crypto holdings come from the live Robinhood Crypto API, snapshot
# at ~/portfolio/robinhood_crypto_holdings.json (refreshed by robinhood-holdings.py).
# This is the authoritative crypto source (see have_live_crypto note above).
if crypto_snap.exists():
    try:
        cd = json.load(open(crypto_snap))
        for r in cd.get("results", []):
            qty = float(r.get("total_quantity") or 0)
            if qty <= 0:
                continue
            px = float(r.get("price_usd") or 0)
            crypto.append({
                "symbol": r.get("asset_code", "?"),
                "quantity": round(qty, 8),
                "price": round(px, 4),
                "equity": round(float(r.get("value_usd") or 0), 2),
            })
    except Exception:
        pass

stocks.sort(key=lambda x: -x["equity"])
crypto.sort(key=lambda x: -x["equity"])

print(json.dumps({
    "stocks": stocks,
    "crypto": crypto,
    "stock_total": round(sum(x["equity"] for x in stocks), 2),
    "crypto_total": round(sum(x["equity"] for x in crypto), 2),
    "cash": 0,
    "as_of": d.get("as_of"),
    "source": "csv",
}))
