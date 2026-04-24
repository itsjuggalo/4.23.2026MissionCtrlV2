# Tweak Discord Integration

Discord integration is now **LIVE** and automatically monitoring Tweak's trading activity, posting updates to the **#tweak-trades** channel in real-time.

## ✅ Status
- **Discord Server**: 1486025777970548908
- **Channel**: #tweak-trades (ID: 1486530350107852952)
- **Monitor Service**: Running (PM2 ID 18, PID 126102)
- **Webhook**: Active and verified ✅

## Architecture

The system consists of:

1. **discord_config.json** - Configuration file with webhook and bot details
2. **discord_webhook.py** - Core webhook module with message formatting functions
3. **tweak_discord_monitor.py** - Automated monitor service (runs via PM2)
4. **post_trade_to_discord.py** - Manual CLI tool for posting trades

## Automated Monitoring (PM2 Service)

The `tweak-discord-monitor` service runs continuously and:
- ✅ Monitors `positions.json` every 5 seconds for new/closed positions
- ✅ Monitors `wallet.json` for balance updates
- ✅ Monitors `pnl_by_source.json` for performance metrics
- ✅ Posts position opens/closes in real-time
- ✅ Posts daily summary at midnight UTC (00:00:00)
- ✅ Prevents duplicate posts by tracking posted positions

### Status
```bash
pm2 list | grep tweak-discord
```

### Logs
```bash
pm2 logs tweak-discord-monitor          # Live logs
pm2 logs tweak-discord-monitor --lines 50  # Last 50 lines
```

### Control
```bash
pm2 stop tweak-discord-monitor          # Stop service
pm2 restart tweak-discord-monitor       # Restart service
pm2 delete tweak-discord-monitor        # Remove service
pm2 save                                 # Save to startup list
```

## Manual CLI Usage

### Position Open
```bash
cd /home/ubuntu/mission-control/tweak
python3 post_trade_to_discord.py open \
  --symbol BTC/USDT \
  --entry 67000 \
  --size 200 \
  --target 70000 \
  --stop 65000 \
  --strategy "BTC Long Grid" \
  --source "ai_crypto"
```

### Position Close
```bash
python3 post_trade_to_discord.py close \
  --symbol BTC/USDT \
  --entry 67000 \
  --exit 68000 \
  --qty 0.003 \
  --pnl 200 \
  --pnl-pct 5.5 \
  --strategy "BTC Long Grid" \
  --source "ai_crypto"
```

### Daily Summary
```bash
python3 post_trade_to_discord.py daily --stats positions.json
```

## Discord Messages Format

### Position Open
```
💰 Position Opened: BTC/USDT
Entry Price: $67,000.00
Size: $200.00
Source: ai_crypto
Target: $70,000.00
Stop Loss: $65,000.00
```

### Position Close
```
✅ Position Closed: BTC/USDT
Entry Price: $67,000.00
Exit Price: $68,000.00
P&L (USD): $200.00
P&L (%): +2.99%
Source: ai_crypto
```

### Daily Summary
```
📊 Tweak Daily Summary - 2026-03-26
Total P&L: $523.45
Active Positions: 10
Wallet Balance: $10,000.00
Total Trades: 945
Win Rate: 62.5%
Grid Strategies: 5
DCA Strategies: 5

AI Crypto: P&L: $300.50 | Win Rate: 65.2% | Trades: 520
Firebase: P&L: $222.95 | Win Rate: 59.8% | Trades: 425
```

## Configuration

Edit `discord_config.json` to update settings:

```json
{
  "bot_token": "YOUR_BOT_TOKEN",
  "server_id": "1486025777970548908",
  "channel_id": "1486530350107852952",
  "channel_name": "tweak-trades",
  "webhook_url": "https://discord.com/api/webhooks/...",
  "features": {
    "post_position_opens": true,
    "post_position_closes": true,
    "post_daily_summary": true,
    "daily_summary_time": "00:00:00"
  }
}
```

## Discord Setup Details

- **Server ID**: 1486025777970548908
- **Channel**: #tweak-trades
- **Channel ID**: 1486530350107852952
- **Channel Type**: Text
- **Channel Topic**: Tweak trading bot - position opens, closes, and daily summaries
- **Webhook ID**: 1486530519477780531
- **Webhook URL**: `https://discord.com/api/webhooks/1486530519477780531/OWTy_lLSGKpRUPnawA-Z0QzZGuxaDfbx_44klTrbWfDKUKq_7rXon1p50G4A7qafdTsn`
- **Created**: 2026-03-26 01:00:00 UTC
- **Status**: ✅ Active and verified

## Testing

Test the webhook directly:
```bash
cd /home/ubuntu/mission-control/tweak
python3 discord_webhook.py
```

Test the monitor:
```bash
python3 tweak_discord_monitor.py
```

## Files

### Core Files
- `discord_config.json` - Bot token, server/channel IDs, webhook URL
- `discord_webhook.py` - Core webhook functions (post_position_open, post_position_close, post_daily_summary)
- `tweak_discord_monitor.py` - Automated monitor (13KB, runs via PM2)
- `post_trade_to_discord.py` - CLI tool for manual posting

### Integration Points
- Monitor reads from: `positions.json`, `trades.json`, `wallet.json`, `pnl_by_source.json`
- Monitor posts to: Discord webhook every 5 seconds
- Daily summary: Posts at 00:00:00 UTC

## Troubleshooting

**Monitor not posting messages?**
```bash
pm2 logs tweak-discord-monitor  # Check for errors
pm2 status tweak-discord-monitor  # Check if running
```

**Webhook authentication failed?**
- Verify `webhook_url` in `discord_config.json`
- Test with: `python3 discord_webhook.py`

**Duplicate posts?**
- Monitor automatically deduplicates on first run
- If stale, restart: `pm2 restart tweak-discord-monitor`

**Daily summary not posting?**
- Check if current time is within 5 minutes of 00:00:00 UTC
- Manually trigger: `python3 post_trade_to_discord.py daily --stats positions.json`

## Next Steps

1. ✅ Discord channel created
2. ✅ Webhook configured
3. ✅ Monitor service running
4. ⏭️ Optional: Integrate direct calls in tweak.py for real-time updates
5. ⏭️ Optional: Add position close detection to auto-post closes
