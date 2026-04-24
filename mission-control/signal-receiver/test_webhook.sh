#!/bin/bash
# Quick test script — run AFTER the server is up
# Usage: ./test_webhook.sh

SECRET=$(cat ~/.openclaw/secrets/tradingview_webhook_secret)
SERVER="http://localhost:8420"

echo "=== Testing Signal Receiver ==="
echo "Secret: $SECRET"
echo ""

# Test 1: Health check
echo "--- Health Check ---"
curl -s "$SERVER/health" | python3 -m json.tool
echo ""

# Test 2: Buy signal (Pine Script JSON format)
echo "--- BUY Signal (JSON) ---"
curl -s -X POST "$SERVER/webhook/tradingview?token=$SECRET" \
  -H "Content-Type: application/json" \
  -d '{
    "ticker": "BTCUSD",
    "action": "buy",
    "price": 86450.00,
    "timeframe": "1H",
    "supertrend": 85200.00,
    "atr": 1250.00,
    "atr_period": 10,
    "multiplier": 3.0
  }' | python3 -m json.tool
echo ""

# Test 3: Sell signal
echo "--- SELL Signal ---"
curl -s -X POST "$SERVER/webhook/tradingview?token=$SECRET" \
  -H "Content-Type: application/json" \
  -d '{
    "ticker": "BTCUSD",
    "action": "sell",
    "price": 84000.00,
    "timeframe": "1H",
    "signal_type": "supertrend_flip",
    "supertrend": 84500.00,
    "atr": 1100.00
  }' | python3 -m json.tool
echo ""

# Test 4: Plain text alert
echo "--- Plain Text Alert ---"
curl -s -X POST "$SERVER/webhook/tradingview?token=$SECRET" \
  -H "Content-Type: text/plain" \
  -d "BTCUSD SuperTrend Flip Long at 87000" | python3 -m json.tool
echo ""

# Test 5: Check latest state
echo "--- Latest State ---"
curl -s "$SERVER/signals/latest" | python3 -m json.tool
echo ""

# Test 6: Check history
echo "--- Signal History ---"
curl -s "$SERVER/signals/history/BTCUSD?limit=10" | python3 -m json.tool

echo ""
echo "=== Done ==="
