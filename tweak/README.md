# 🤖 TWEAK - Automated Grid/DCA Trading Bot

**Tier 3: Execution & Monitoring**  
**DNA**: Citadel + Jane Street (systematic grid strategies + high-frequency execution)

---

## Overview

Tweak is an automated trading bot specializing in:
- **Grid Bots**: Long/Short/Neutral grid strategies
- **DCA Bots**: Time-based, dip-buying, and smart DCA strategies
- **Self-managed wallet**: Separate from main portfolio
- **Small position sizing**: $5-$50 per trade for capital preservation

---

## Features

### Grid Strategies
1. **Long Grid** - Bullish bias, buy low sell high
2. **Short Grid** - Bearish bias, sell high buy low
3. **Neutral Grid** - Profit from volatility both ways

### DCA Strategies
1. **Time-based DCA** - Fixed amount at intervals
2. **Dip-buying DCA** - Increase size on larger dips
3. **Smart DCA** - Uses BTC bias and market conditions

### Integration
- Reads **BTC Bias Scorer** for market direction
- Reads **Macro Strategist** for regime detection
- Uses **Analyst signals** for smart DCA timing
- Reports to **Portfolio Monitor** and **Auditor**

---

## Files

```
tweak/
├── tweak.py              # Main bot
├── grid_strategy.py      # Grid trading logic
├── dca_strategy.py       # DCA logic
├── position_manager.py   # Position tracking
├── wallet_manager.py     # Wallet management
├── config.json           # Strategy configuration
├── wallet.json           # Wallet state (auto-created)
├── positions.json        # Open positions (auto-created)
├── trades.json           # Trade history (auto-created)
├── status.json           # Bot status (auto-created)
└── README.md             # This file
```

---

## Setup

### 1. Upload Files

Upload to `/home/ubuntu/mission-control/tweak/`:
- tweak.py
- grid_strategy.py
- dca_strategy.py
- position_manager.py
- wallet_manager.py
- config.json
- README.md

### 2. Configure Strategies

Edit `config.json` to customize:
- Grid ranges and spacing
- DCA amounts and intervals
- Risk limits
- Enable/disable specific strategies

### 3. Add to PM2

```bash
cd /home/ubuntu/mission-control/tweak
pm2 start tweak.py --name tweak --interpreter python3
pm2 save
```

### 4. Verify Running

```bash
pm2 status
pm2 logs tweak
```

---

## Configuration

### Example Grid Strategy

```json
{
  "name": "BTC Long Grid",
  "active": true,
  "type": "long_grid",
  "symbol": "BTC/USDT",
  "range": [60000, 75000],
  "grids": 15,
  "amount_per_grid": 10,
  "take_profit": 1.0,
  "stop_loss": 5.0
}
```

### Example DCA Strategy

```json
{
  "name": "ETH Dip Buyer",
  "active": true,
  "type": "dip_buying",
  "symbol": "ETH/USDT",
  "interval_hours": 12,
  "base_amount": 5,
  "dip_multiplier": 2.5,
  "max_position": 100
}
```

---

## Wallet Management

Tweak has its own **dedicated wallet** separate from main portfolio:

- **Starting balance**: $100 (configurable in wallet.json)
- **Auto-initialized**: Creates wallet.json on first run
- **Balance tracking**: Available vs Reserved funds
- **Transaction history**: All deposits, withdrawals, trades logged

### Adding Funds

Edit `wallet.json`:
```json
{
  "balance_usd": 500.0,
  "available": 500.0,
  "reserved": 0.0
}
```

Or use WalletManager programmatically:
```python
wallet_manager.add_funds(400.0, "initial deposit")
```

---

## Risk Management

- **Max position size**: $50 per trade (configurable)
- **Max concurrent positions**: 5
- **Stop loss**: 5% default
- **Max daily trades**: 20
- **Max daily loss**: $50
- **Min wallet balance**: $10 (stops trading below this)

---

## Monitoring

### Status File

`status.json` updates every cycle:
```json
{
  "bot": "tweak",
  "status": "active",
  "last_update": "2026-03-25T20:00:00",
  "wallet_balance": 100.0,
  "active_positions": 3,
  "grid_strategies": 2,
  "dca_strategies": 3,
  "total_trades_today": 5
}
```

### Logs

```bash
pm2 logs tweak --lines 50
```

### Performance

```bash
cat /home/ubuntu/mission-control/tweak/trades.json
cat /home/ubuntu/mission-control/tweak/positions.json
```

---

## Integration with Mission Control

**Inputs:**
- BTC Bias Scorer → Grid direction bias
- Macro Strategist → Market regime
- Analyst signals → Smart DCA timing

**Outputs:**
- trades.json → Auditor reviews
- positions.json → Portfolio Monitor tracks
- Updates Discord/Telegram → Broadcaster announces

---

## Strategy Examples

### Conservative Setup
- 2-3 neutral grids on major pairs
- Daily DCA small amounts ($5-10)
- Tight stop losses (3-5%)

### Aggressive Setup
- Long/short grids on volatile altcoins
- Dip-buying DCA with 3x multiplier
- Larger position sizes ($30-50)

### Balanced Setup (Default)
- Mix of neutral and long grids
- Time-based + smart DCA
- Moderate position sizes ($10-20)

---

## Troubleshooting

**Bot not trading?**
- Check `config.json` - strategies enabled?
- Check wallet balance > min threshold
- Check logs: `pm2 logs tweak`

**Positions stuck?**
- Review `positions.json`
- Check if take-profit levels are reasonable
- Manually close via position_manager if needed

**Wallet issues?**
- Verify `wallet.json` exists and has balance
- Check reserved vs available funds
- Review transaction history

---

## Future Enhancements

- [ ] Live exchange API integration (Hyperliquid, Coinbase)
- [ ] Dynamic grid adjustment based on volatility
- [ ] Trailing stop losses
- [ ] Profit auto-compound to wallet
- [ ] Multi-pair correlation analysis
- [ ] Advanced risk metrics (Sharpe, Sortino)
- [ ] Web UI for strategy management

---

## Safety Notes

⚠️ **Important**:
- Start with small amounts ($50-100)
- Test strategies in paper mode first
- Monitor daily for first week
- Don't over-leverage
- Keep stop losses enabled
- Review trades weekly with Auditor

---

## Support

For issues or questions:
1. Check logs: `pm2 logs tweak`
2. Review status: `cat status.json`
3. Check config: `cat config.json`
4. Restart if needed: `pm2 restart tweak`

---

**Built for Mission Control Trading Team**  
**Version 1.0 - March 2026**
