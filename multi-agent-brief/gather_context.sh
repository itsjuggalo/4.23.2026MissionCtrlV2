#!/usr/bin/env bash
# Gathers all brief context data and outputs as structured text.
# Used by ClaudeClaw scheduled tasks to feed into brief synthesis.
set -euo pipefail

SECRETS="/home/ubuntu/.openclaw/secrets"
DATA_DIR="/home/ubuntu/mission-control/signal-receiver/data"

echo "=== GROK SENTIMENT (last 4h Discord) ==="
TOKEN=$(cat "$SECRETS/spacer_bot_token.txt" 2>/dev/null || echo "")
if [ -n "$TOKEN" ]; then
  curl -sf -H "Authorization: Bot $TOKEN" \
    "https://discord.com/api/v10/channels/1497448514404356136/messages?limit=20" 2>/dev/null \
    | python3 -c "
import sys, json
from datetime import datetime, timezone, timedelta
msgs = json.load(sys.stdin)
cutoff = datetime.now(timezone.utc) - timedelta(hours=4)
for m in msgs:
    ts = datetime.fromisoformat(m['timestamp'].replace('Z','+00:00'))
    if ts > cutoff and m.get('content'):
        print(f'- {m[\"content\"][:300]}')
" 2>/dev/null || echo "No recent grok updates"
else
  echo "No bot token available"
fi

echo ""
echo "=== ORION TECHNICALS ==="
for f in market_regime.json optimal_params.json latest_state.json; do
  if [ -f "$DATA_DIR/$f" ]; then
    echo "--- ${f%.json} ---"
    python3 -c "import json; print(json.dumps(json.load(open('$DATA_DIR/$f')), indent=2)[:800])" 2>/dev/null || echo "parse error"
  fi
done

echo ""
echo "=== LIVE FLOW ==="
curl -sf "http://localhost:3000/api/live-signals" 2>/dev/null \
  | python3 -c "
import sys, json
d = json.load(sys.stdin)
tw = d.get('topWatched',[])[:5]
rs = d.get('recentSignals',[])[:10]
pe = d.get('picksExecuted',[])
pa = d.get('passedOn',[])
if tw: print('Top Watched:', json.dumps(tw, indent=2)[:600])
if rs: print('Recent Signals:', json.dumps(rs, indent=2)[:1200])
if pe: print('Picks Executed:', json.dumps(pe, indent=2)[:600])
if pa: print('Passed On:', json.dumps(pa, indent=2)[:400])
" 2>/dev/null || echo "Flow API unavailable"

echo ""
echo "=== RECENT JOURNAL ENTRIES ==="
curl -sf "http://localhost:3000/api/boba-journal" 2>/dev/null \
  | python3 -c "
import sys, json
entries = json.load(sys.stdin).get('entries',[])[:5]
for e in entries:
    print(f\"- {e.get('symbol','?')} | {e.get('side','?')} | exec={e.get('executed','?')} | {(e.get('reasoning') or '')[:200]}\")
" 2>/dev/null || echo "Journal API unavailable"

echo ""
echo "=== ALPACA R1 (BOBA) ==="
R1_KEY=$(cat "$SECRETS/alpaca-boba-key-id" 2>/dev/null || echo "")
R1_SEC=$(cat "$SECRETS/alpaca-boba-secret" 2>/dev/null || echo "")
if [ -n "$R1_KEY" ] && [ -n "$R1_SEC" ]; then
  # Account summary
  curl -sf -H "APCA-API-KEY-ID: $R1_KEY" -H "APCA-API-SECRET-KEY: $R1_SEC" \
    "https://paper-api.alpaca.markets/v2/account" 2>/dev/null \
    | python3 -c "
import sys, json
a = json.load(sys.stdin)
print(f'Portfolio: \${float(a.get(\"portfolio_value\",0)):,.2f}')
print(f'Cash: \${float(a.get(\"cash\",0)):,.2f}')
print(f'Buying Power: \${float(a.get(\"buying_power\",0)):,.2f}')
print(f'Day P&L: \${float(a.get(\"equity\",0)) - float(a.get(\"last_equity\",0)):+,.2f}')
" 2>/dev/null || echo "R1 account API error"
  # Positions
  echo "--- R1 Positions ---"
  curl -sf -H "APCA-API-KEY-ID: $R1_KEY" -H "APCA-API-SECRET-KEY: $R1_SEC" \
    "https://paper-api.alpaca.markets/v2/positions" 2>/dev/null \
    | python3 -c "
import sys, json
positions = json.load(sys.stdin)
if not positions: print('No open positions')
for p in positions[:15]:
    sym = p.get('symbol','?')
    qty = p.get('qty','0')
    side = p.get('side','long')
    pnl = float(p.get('unrealized_pl','0'))
    pnl_pct = float(p.get('unrealized_plpc','0'))*100
    cur = float(p.get('current_price','0'))
    avg = float(p.get('avg_entry_price','0'))
    print(f'  {sym}: {qty} {side} @ \${avg:.2f} → \${cur:.2f} | P&L: \${pnl:+,.2f} ({pnl_pct:+.1f}%)')
" 2>/dev/null || echo "R1 positions error"
else
  echo "No R1 keys found"
fi

echo ""
echo "=== ALPACA R2 (JAZZY) ==="
R2_KEY=$(cat "$SECRETS/alpaca-jazzy-key-id" 2>/dev/null || echo "")
R2_SEC=$(cat "$SECRETS/alpaca-jazzy-secret" 2>/dev/null || echo "")
if [ -n "$R2_KEY" ] && [ -n "$R2_SEC" ]; then
  # Account summary
  curl -sf -H "APCA-API-KEY-ID: $R2_KEY" -H "APCA-API-SECRET-KEY: $R2_SEC" \
    "https://paper-api.alpaca.markets/v2/account" 2>/dev/null \
    | python3 -c "
import sys, json
a = json.load(sys.stdin)
print(f'Portfolio: \${float(a.get(\"portfolio_value\",0)):,.2f}')
print(f'Cash: \${float(a.get(\"cash\",0)):,.2f}')
print(f'Buying Power: \${float(a.get(\"buying_power\",0)):,.2f}')
print(f'Day P&L: \${float(a.get(\"equity\",0)) - float(a.get(\"last_equity\",0)):+,.2f}')
" 2>/dev/null || echo "R2 account API error"
  # Positions
  echo "--- R2 Positions ---"
  curl -sf -H "APCA-API-KEY-ID: $R2_KEY" -H "APCA-API-SECRET-KEY: $R2_SEC" \
    "https://paper-api.alpaca.markets/v2/positions" 2>/dev/null \
    | python3 -c "
import sys, json
positions = json.load(sys.stdin)
if not positions: print('No open positions')
for p in positions[:15]:
    sym = p.get('symbol','?')
    qty = p.get('qty','0')
    side = p.get('side','long')
    pnl = float(p.get('unrealized_pl','0'))
    pnl_pct = float(p.get('unrealized_plpc','0'))*100
    cur = float(p.get('current_price','0'))
    avg = float(p.get('avg_entry_price','0'))
    print(f'  {sym}: {qty} {side} @ \${avg:.2f} → \${cur:.2f} | P&L: \${pnl:+,.2f} ({pnl_pct:+.1f}%)')
" 2>/dev/null || echo "R2 positions error"
else
  echo "No R2 keys found"
fi

echo ""
echo "=== INSIDER TRADING (OpenInsider + SEC EDGAR) ==="
python3 /home/ubuntu/scripts/multi-agent-brief/fetch_insider_trades.py 2>/dev/null || echo "Insider data unavailable"

echo ""
echo "=== MARKET SNAPSHOT ==="
# Quick SPY/BTC from pre_brief_data if available
PRE_BRIEF="/home/ubuntu/.openclaw/workspace/directives/pre_brief_data.md"
if [ -f "$PRE_BRIEF" ]; then
  head -60 "$PRE_BRIEF" 2>/dev/null || echo "No pre-brief data"
else
  echo "No pre-brief data file"
fi
