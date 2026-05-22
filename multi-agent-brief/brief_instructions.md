# Brief Generation Instructions (shared across all brief types)

## Data Sources
Run `bash /home/ubuntu/scripts/multi-agent-brief/gather_context.sh` to get:
- Grok sentiment (Discord last 4h)
- Orion technicals (market regime, optimal params, signal state)
- Live option flow (top watched, signals, picks executed/passed)
- Recent Boba journal entries (trade decisions + reasoning)
- Alpaca R1 (Boba) portfolio: equity, cash, positions, P&L
- Alpaca R2 (Jazzy) portfolio: equity, cash, positions, P&L
- Insider trading data (OpenInsider + SEC EDGAR Form 4)
- Market snapshot (crypto, sessions, Fear & Greed)

## Insider Trading Interpretation Rules
When analyzing the insider data section, apply these rules:
1. BUYS are signals; SELLS are mostly noise (insiders sell for taxes, houses, diversification)
2. CLUSTER BUYS (multiple insiders, same stock, 7 days) are the strongest signal
3. C-SUITE buys (CEO/CFO/COO) matter far more than director buys
4. Large purchases relative to existing holdings (high deltaOwn%) show real conviction
5. Ignore automatic/compensation trades - only flag open-market cash purchases
6. If notable insider activity exists, mention it. If not, skip it - don't force it.

## Portfolio Rules
Always include a PORTFOLIO section showing:
- R1 (Boba): equity, day P&L, open positions with unrealized P&L
- R2 (Jazzy): equity, day P&L, open positions with unrealized P&L

## Format Rules
- Lead with a 1-line take (bullish/bearish/chop/mixed)
- 3-5 labeled bullet sections with actual numbers
- Max 1800 chars total
- No fluff, no filler. Numbers over words.
- End with a specific actionable item per brief type

## Discord Posting
Write the brief to /tmp/brief_content.txt, then POST using python3:
```bash
TOKEN=$(cat /home/ubuntu/.openclaw/secrets/spacer_bot_token.txt)
TIMESTAMP=$(date "+%a %b %d, %I:%M %p ET")
python3 -c "
import json, requests
brief = open('/tmp/brief_content.txt').read()
embed = {'title': 'BRIEF_TITLE', 'description': brief[:4000], 'color': COLOR_INT,
         'footer': {'text': '$TIMESTAMP · ClaudeClaw multi-agent brief'}}
r = requests.post('https://discord.com/api/v10/channels/CHANNEL_ID/messages',
    headers={'Authorization': f'Bot $TOKEN', 'Content-Type': 'application/json'},
    json={'embeds': [embed]}, timeout=15)
print(f'Discord: {r.status_code}')
"
```
