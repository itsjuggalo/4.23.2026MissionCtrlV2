#!/usr/bin/env python3
"""Robinhood full portfolio — stocks + crypto via robin_stocks"""
import json, sys, os

try:
    import robin_stocks.robinhood as rh

    email = open(os.path.expanduser("~/.openclaw/secrets/robinhood-email.txt")).read().strip()
    password = open(os.path.expanduser("~/.openclaw/secrets/robinhood-password.txt")).read().strip()

    import io
    old_stdout = sys.stdout
    sys.stdout = io.StringIO()
    login = rh.login(email, password, store_session=True)
    sys.stdout = old_stdout
    if not login:
        print(json.dumps({"error": "Login failed"}))
        sys.exit(1)

    # Stock holdings
    holdings = rh.build_holdings()
    stocks = []
    stock_total = 0
    for symbol, data in holdings.items():
        equity = float(data.get('equity', 0))
        stocks.append({
            "symbol": symbol,
            "quantity": float(data.get('quantity', 0)),
            "avg_cost": float(data.get('average_buy_price', 0)),
            "price": float(data.get('price', 0)),
            "equity": equity,
            "pct_change": float(data.get('percent_change', 0)),
            "type": "stock"
        })
        stock_total += equity

    stocks.sort(key=lambda x: -x['equity'])

    # Account profile
    profile = rh.build_user_profile()
    total_equity = float(profile.get('equity', 0))
    cash = float(profile.get('cash', 0))

    # Crypto (already have this from the other script, but let's get it here too)
    crypto_positions = []
    try:
        crypto = rh.get_crypto_positions()
        for c in crypto:
            qty = float(c.get('quantity_available', 0))
            if qty > 0:
                code = c.get('currency', {}).get('code', '?')
                try:
                    quote = rh.get_crypto_quote(code)
                    price = float(quote.get('mark_price', 0))
                except:
                    price = 0
                val = qty * price
                crypto_positions.append({
                    "symbol": code,
                    "quantity": qty,
                    "price": price,
                    "equity": val,
                    "type": "crypto"
                })
    except:
        pass

    crypto_total = sum(c['equity'] for c in crypto_positions)
    crypto_positions.sort(key=lambda x: -x['equity'])

    print(json.dumps({
        "stocks": stocks,
        "crypto": crypto_positions,
        "stock_total": round(stock_total, 2),
        "crypto_total": round(crypto_total, 2),
        "total_equity": round(total_equity, 2),
        "cash": round(cash, 2),
        "position_count": len(stocks) + len(crypto_positions),
    }))

except Exception as ex:
    print(json.dumps({"error": str(ex)}))
