#!/usr/bin/env python3
"""
LLM Portfolio Scraper - Pulls trades from all 6 AI models on AInvest.
Saves to ~/mission-control-restored/data/llm_portfolio.json
Cron: 0 */4 * * * python3 ~/mission-control-restored/bots/llm_portfolio_scraper.py
"""
import json, time, requests
from datetime import datetime
from pathlib import Path

DATA_DIR = Path.home() / "mission-control-restored" / "data"
DATA_DIR.mkdir(parents=True, exist_ok=True)
OUTPUT = DATA_DIR / "llm_portfolio.json"

BASE_URL = "https://tech.ainvest.com/gateway/iwc-web-business-center/shadow_account_open/v1/order/"

MODELS = {
    "AIME":     {"id": "1800473182_15", "model": "AIME", "color": "#4fc3f7"},
    "DEEPSEEK": {"id": "1800473182_16", "model": "DeepSeek Chat 3.1", "color": "#66bb6a"},
    "QWEN":     {"id": "1800473182_17", "model": "Qwen3 Max", "color": "#ff9800"},
    "CLAUDE":   {"id": "1800473182_18", "model": "Claude Sonnet 4.5", "color": "#ce93d8"},
    "GEMINI":   {"id": "1800473182_19", "model": "Gemini 2.5 Pro", "color": "#81d4fa"},
    "GPT":      {"id": "1800473182_20", "model": "GPT-5", "color": "#ef5350"},
}

def fetch_trades(model_key, model_info, days=365):
    try:
        r = requests.get(BASE_URL, params={
            "id": model_info["id"],
            "asset_type": "stock",
            "lang": "en",
            "day": str(days)
        }, timeout=20)
        if r.status_code == 200:
            data = r.json()
            if data.get("status_code") == 0:
                return data.get("result", {}).get("list", [])
    except Exception as e:
        print(f"  [llm] {model_key} error: {e}")
    return []

def process_trades(raw_trades):
    all_trades = []
    holdings = {}
    total_buy = 0
    total_sell = 0

    for day in raw_trades:
        date = day.get("date", "")
        for side_key in ["buy", "sell"]:
            side_data = day.get(side_key)
            if not side_data: continue
            for order in side_data.get("order", []):
                symbol = order.get("symbol", "")
                price = float(order.get("execute_price", 0))
                qty = float(order.get("execute_quantity", 0))
                balance = float(order.get("execute_balance", 0))

                trade = {
                    "date": f"{date[:4]}-{date[4:6]}-{date[6:8]}",
                    "side": order.get("side", ""),
                    "symbol": symbol,
                    "company": order.get("company_name", ""),
                    "price": round(price, 2),
                    "quantity": round(abs(qty), 2),
                    "value": round(abs(balance), 2),
                    "order_id": order.get("order_id", ""),
                }
                all_trades.append(trade)

                if trade["side"] == "buy":
                    total_buy += trade["value"]
                    holdings[symbol] = holdings.get(symbol, 0) + trade["quantity"]
                else:
                    total_sell += trade["value"]
                    holdings[symbol] = holdings.get(symbol, 0) - trade["quantity"]

    # Clean up holdings (remove sold positions)
    current_holdings = {k: round(v, 2) for k, v in holdings.items() if v > 0.01}

    return {
        "total_trades": len(all_trades),
        "total_buy_value": round(total_buy, 2),
        "total_sell_value": round(total_sell, 2),
        "current_holdings": current_holdings,
        "holdings_count": len(current_holdings),
        "recent_trades": all_trades[:30],
        "all_trades": all_trades,
    }

def main():
    print(f"[llm] Starting LLM Portfolio scrape — {datetime.now().isoformat()}")

    results = {}
    for key, info in MODELS.items():
        print(f"  [{key}] Fetching trades (id: {info['id']})...")
        raw = fetch_trades(key, info)
        processed = process_trades(raw)
        results[key] = {
            "name": key,
            "model": info["model"],
            "color": info["color"],
            "account_id": info["id"],
            **processed
        }
        print(f"    {processed['total_trades']} trades, {processed['holdings_count']} current holdings")
        time.sleep(1)

    # Build leaderboard (we can't get exact portfolio value from this API,
    # but we can rank by trade activity and holdings)
    leaderboard = []
    for key, data in results.items():
        leaderboard.append({
            "rank": 0,
            "name": key,
            "model": data["model"],
            "color": data["color"],
            "total_trades": data["total_trades"],
            "holdings_count": data["holdings_count"],
            "buy_volume": data["total_buy_value"],
            "sell_volume": data["total_sell_value"],
        })

    output = {
        "last_updated": datetime.now().isoformat(),
        "leaderboard": leaderboard,
        "models": results,
    }

    with open(OUTPUT, "w") as f:
        json.dump(output, f, indent=2)

    print(f"\n[llm] DONE — saved to {OUTPUT}")
    for key, data in results.items():
        print(f"  {key}: {data['total_trades']} trades, {data['holdings_count']} holdings")

if __name__ == "__main__":
    main()
