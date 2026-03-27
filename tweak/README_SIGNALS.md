# 🤖 TWEAK - Signal-Based Paper Trading Bot

**Upgraded Version**: Reads AI Crypto & Firebase signals, trades with REAL LIVE PRICES

---

## Features

### 📊 **Signal Integration**
- Reads signals from AI Crypto (Telegram)
- Reads signals from Firebase (premium signals)
- Processes raw message data for accurate execution
- Separate P&L tracking per signal source

### 💰 **Paper Trading**
- **$10,000 starting balance**
- Uses REAL LIVE PRICES from CoinGecko API
- No actual money at risk
- Build track record before live trading

### 📈 **Performance Tracking**
- Win rate by signal source
- Total P&L by source (AI Crypto vs Firebase)
- Winning vs losing trades
- Unrealized P&L on open positions

---

## How It Works

### 1. **Signal Reading**
Tweak monitors two signal sources:
- `/aicrypto-signals/signals.json` - AI Crypto Telegram signals
- `/firebase-signals/signals.json` - Firebase premium signals

### 2. **Price Fetching**
Uses CoinGecko API for REAL LIVE prices:
- BTC, ETH, SOL, ARB, AVAX, MATIC, LINK, UNI, AAVE, DOT
- Updates every API call (no caching)
- Free API, no authentication needed

### 3. **Trade Execution**
- **BUY signals**: Opens position at current market price
- **SELL signals**: Closes position, calculates P&L
- Tracks which source the signal came from
- Enforces risk limits (max $500/position, 5 positions/source)

### 4. **P&L Tracking**
Separate tracking for each signal source:
```json
{
  "ai_crypto": {
    "total_trades": 10,
    "winning_trades": 7,
    "losing_trades": 3,
    "total_pnl": 234.56,
    "win_rate": 70.0
  },
  "firebase": {
    "total_trades": 5,
    "winning_trades": 4,
    "losing_trades": 1,
    "total_pnl": 123.45,
    "win_rate": 80.0
  }
}
```

---

## Installation

### 1. **Upload Files**
```bash
cd /home/ubuntu/mission-control/tweak
# Upload via WinSCP:
# - tweak_signals.py
# - config_signals.json
```

### 2. **Stop Old Tweak**
```bash
pm2 stop tweak
pm2 delete tweak
```

### 3. **Start Signal-Based Tweak**
```bash
pm2 start tweak_signals.py --name tweak --interpreter python3
pm2 save
```

### 4. **Monitor**
```bash
pm2 logs tweak
```

---

## Signal Format

### **AI Crypto Signals** (`aicrypto-signals/signals.json`):
```json
{
  "symbol": "BTC/USDT",
  "action": "buy",
  "amount_usd": 200,
  "reason": "Bullish breakout above resistance",
  "target": 70000,
  "stop_loss": 65000,
  "timestamp": "2026-03-25T20:00:00Z",
  "processed_by_tweak": false
}
```

### **Firebase Signals** (`firebase-signals/signals.json`):
```json
{
  "coin": "ETH",
  "action": "sell",
  "analysis": "Take profit at resistance level",
  "target": 3500,
  "timestamp": "2026-03-25T20:00:00Z",
  "processed_by_tweak": false
}
```

---

## Files Created

```
tweak/
├── tweak_signals.py       # Main signal-based bot
├── config_signals.json    # Configuration
├── wallet.json            # $10k paper wallet
├── positions.json         # Open positions
├── trades.json            # Trade history
├── pnl_by_source.json     # P&L tracking by source
├── status.json            # Bot status
└── README_SIGNALS.md      # This file
```

---

## Configuration

Edit `config_signals.json`:

```json
{
  "max_position_size_usd": 500,        // Max $ per trade
  "max_positions_per_source": 5,       // Max positions from each source
  "check_interval_seconds": 30,        // How often to check for signals
  
  "signal_sources": {
    "ai_crypto": {
      "enabled": true,
      "signals_file": "../aicrypto-signals/signals.json"
    },
    "firebase": {
      "enabled": true,
      "signals_file": "../firebase-signals/signals.json"
    }
  }
}
```

---

## Monitoring

### **Check Status:**
```bash
cat /home/ubuntu/mission-control/tweak/status.json
```

### **View Wallet:**
```bash
cat /home/ubuntu/mission-control/tweak/wallet.json
```

### **See P&L by Source:**
```bash
cat /home/ubuntu/mission-control/tweak/pnl_by_source.json
```

### **Live Logs:**
```bash
pm2 logs tweak --lines 50
```

---

## Example Output

```
🤖 TWEAK - Signal-Based Paper Trading Bot
💰 Starting Balance: $10,000.00
📊 Signal Sources: AI Crypto, Firebase
📈 Using REAL LIVE PRICES
============================================================

⚙️  Tweak check at 20:30:15
   Balance: $10,000.00 | Available: $9,500.00
   Positions: 2

📡 AI Crypto Signals: 1 new
  💰 BUY BTC/USDT @ $67,234.50 | Size: $200 | Source: ai_crypto

🔥 Firebase Signals: 1 new
  📈 SELL ETH/USDT @ $3,245.67 | P&L: $45.23 (+2.34%) | Source: firebase

📊 P&L by Source:
   AI_CRYPTO: $123.45 | Win Rate: 65.0% | Trades: 8
   FIREBASE: $234.56 | Win Rate: 75.0% | Trades: 4
```

---

## Next Steps

### **Phase 1: Paper Trading (Current)**
- Build 2-4 week track record
- Compare AI Crypto vs Firebase performance
- Tune risk parameters

### **Phase 2: Go Live**
- Connect to Hyperliquid API for real execution
- Start with small amounts ($100-500)
- Use best-performing signal source

### **Phase 3: Optimization**
- Filter low-quality signals
- Auto-adjust position sizing
- Add stop-loss automation

---

## Safety Features

- ✅ Paper trading only (no real money)
- ✅ Real live prices (accurate simulation)
- ✅ Position size limits ($500 max)
- ✅ Max positions per source (5 max)
- ✅ Separate P&L tracking
- ✅ Full trade history logging

---

**Version 2.0 - Signal-Based Paper Trading**  
**March 2026**
