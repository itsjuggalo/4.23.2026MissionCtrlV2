#!/usr/bin/env python3
"""
TWEAK - Signal-Based Paper Trading Bot
Sources: AI Crypto, Firebase, Telegram Listener
Prices: Coinbase (crypto) + Finnhub (stocks)
"""

import json
import time
import requests
from datetime import datetime
from pathlib import Path
from typing import Dict, List, Optional

FINNHUB_API_KEY = 'd70ov6hr01ql6rg044qgd70ov6hr01ql6rg044r0'

SOURCE_TO_STRATEGY = {
    "ai_crypto": "ai_crypto",
    "firebase":  "firebase",
    "telegram":  "telegram",
    "grid":      "grid",
    "dca":       "dca",
}

# Known crypto base symbols — everything else goes to Finnhub
CRYPTO_SYMBOLS = {
    'BTC','ETH','SOL','BNB','XRP','ADA','DOGE','AVAX','DOT','MATIC',
    'LINK','UNI','LTC','ATOM','PEPE','WIF','BONK','SUI','APT','OP',
    'ARB','AXS','RENDER','SNX','FIL','INJ','SEI','TIA','BLUR','GMX',
    'DYDX','ENS','SAND','MANA','APE','CRV','LDO','RPL','SSV','ANKR',
    'FTM','ONE','NEAR','FLOW','HBAR','VET','XLM','EOS','TRX','XMR',
}

class TweakSignalTrader:
    def __init__(self):
        self.bot_dir = Path(__file__).parent
        self.config  = self.load_config()
        self.wallet  = self.load_wallet()

        if self.wallet['balance_usd'] == 100:
            self.wallet['balance_usd'] = 10000.0
            self.wallet['available']   = 10000.0
            self.save_wallet()

        self.positions     = self.load_positions()
        self.pnl_by_source = self.load_pnl_by_source()

        print("="*60)
        print("🤖 TWEAK - Signal-Based Paper Trading Bot")
        print(f"💰 Balance: ${self.wallet['balance_usd']:,.2f}")
        print("📊 Sources: AI Crypto, Firebase, Telegram")
        print("📈 Prices: Coinbase (crypto) + Finnhub (stocks)")
        print("="*60)

    # ── Config / persistence ──────────────────────────────────────────────────

    def load_config(self) -> Dict:
        p = self.bot_dir / "config_signals.json"
        if p.exists():
            with open(p) as f:
                return json.load(f)
        return {}

    def load_wallet(self) -> Dict:
        p = self.bot_dir / "wallet.json"
        if p.exists():
            with open(p) as f:
                return json.load(f)
        wallet = {"balance_usd": 10000.0, "reserved": 0.0, "available": 10000.0,
                  "transactions": [], "created_at": datetime.utcnow().isoformat()}
        self.save_wallet(wallet)
        return wallet

    def save_wallet(self, wallet=None):
        with open(self.bot_dir / "wallet.json", 'w') as f:
            json.dump(wallet or self.wallet, f, indent=2)

    def load_positions(self) -> List[Dict]:
        p = self.bot_dir / "positions.json"
        if p.exists():
            with open(p) as f:
                all_pos = json.load(f)
                return [x for x in all_pos if x.get('status') == 'open']
        return []

    def save_positions(self):
        with open(self.bot_dir / "positions.json", 'w') as f:
            json.dump(self.positions, f, indent=2)

    def load_pnl_by_source(self) -> Dict:
        p = self.bot_dir / "pnl_by_source.json"
        if p.exists():
            with open(p) as f:
                return json.load(f)
        data = {s: {"total_trades": 0, "winning_trades": 0, "losing_trades": 0,
                    "total_pnl": 0.0, "win_rate": 0.0}
                for s in ["ai_crypto", "firebase", "telegram"]}
        with open(p, 'w') as f:
            json.dump(data, f, indent=2)
        return data

    def save_pnl_by_source(self):
        with open(self.bot_dir / "pnl_by_source.json", 'w') as f:
            json.dump(self.pnl_by_source, f, indent=2)

    # ── Live prices ───────────────────────────────────────────────────────────

    def is_crypto(self, symbol: str) -> bool:
        base = symbol.split('/')[0].upper() if '/' in symbol else symbol.upper()
        return base in CRYPTO_SYMBOLS

    def get_coinbase_price(self, symbol: str) -> Optional[float]:
        try:
            base = symbol.split('/')[0].upper() if '/' in symbol else symbol.upper()
            r = requests.get(
                f"https://api.coinbase.com/v2/prices/{base}-USD/spot",
                timeout=5
            )
            if r.status_code == 200:
                price = r.json().get('data', {}).get('amount')
                if price:
                    return float(price)
        except Exception as e:
            print(f"❌ Coinbase error {symbol}: {e}")
        return None

    def get_finnhub_price(self, symbol: str) -> Optional[float]:
        try:
            r = requests.get(
                f"https://finnhub.io/api/v1/quote?symbol={symbol.upper()}&token={FINNHUB_API_KEY}",
                timeout=5
            )
            if r.status_code == 200:
                data  = r.json()
                price = data.get('c')   # current price
                if price and price > 0:
                    return float(price)
        except Exception as e:
            print(f"❌ Finnhub error {symbol}: {e}")
        return None

    def get_live_price(self, symbol: str) -> Optional[float]:
        """
        Route to Coinbase for crypto, Finnhub for stocks/options.
        Falls back to the other source if primary fails.
        """
        if self.is_crypto(symbol):
            price = self.get_coinbase_price(symbol)
            if price:
                return price
            # Crypto fallback — try Finnhub anyway
            return self.get_finnhub_price(symbol.split('/')[0])
        else:
            # Stock / option — use Finnhub
            price = self.get_finnhub_price(symbol)
            if price:
                return price
            # Stock fallback — try Coinbase in case it's a newer crypto
            return self.get_coinbase_price(symbol)

    # ── Signal readers ────────────────────────────────────────────────────────

    def read_simple_signals(self, source: str) -> List[Dict]:
        try:
            rel = self.config['signal_sources'][source]['signals_file'].lstrip('../')
            p   = self.bot_dir.parent / rel
            if not p.exists():
                return []
            with open(p) as f:
                signals = json.load(f)
            return [s for s in signals if not s.get('processed_by_tweak')]
        except Exception as e:
            print(f"❌ Error reading {source} signals: {e}")
            return []

    def read_telegram_signals(self) -> List[Dict]:
        try:
            cfg = self.config['signal_sources'].get('telegram', {})
            if not cfg.get('enabled', False):
                return []
            rel = cfg['signals_file'].lstrip('../')
            p   = self.bot_dir.parent / rel
            if not p.exists():
                return []
            with open(p) as f:
                signals = json.load(f)
            min_score        = cfg.get('min_score', 70)
            allowed_statuses = cfg.get('allowed_statuses', ['actionable'])
            return [
                s for s in signals
                if s.get('status') in allowed_statuses
                and (s.get('score') or 0) >= min_score
                and not s.get('processed_by_tweak')
                and s.get('direction') in ['BUY', 'CALL', 'PUT', 'LONG']
                and s.get('entry')
            ]
        except Exception as e:
            print(f"❌ Error reading telegram signals: {e}")
            return []

    def mark_signal_processed(self, signals_file_rel: str,
                               signal_id: str = None, match_fn=None):
        try:
            p = self.bot_dir.parent / signals_file_rel.lstrip('../')
            if not p.exists():
                return
            with open(p) as f:
                signals = json.load(f)
            for s in signals:
                if signal_id and s.get('id') == signal_id:
                    s['processed_by_tweak'] = True
                elif match_fn and match_fn(s):
                    s['processed_by_tweak'] = True
            with open(p, 'w') as f:
                json.dump(signals, f, indent=2)
        except Exception as e:
            print(f"❌ Error marking processed: {e}")

    # ── Execution ─────────────────────────────────────────────────────────────

    def execute_simple_signal(self, signal: Dict, source: str):
        symbol = signal.get('symbol') or signal.get('coin')
        action = signal.get('action', '').lower()
        if not symbol or action not in ['buy', 'sell']:
            return

        current_price = self.get_live_price(symbol)
        if not current_price:
            print(f"⚠️  No price for {symbol}, skipping")
            return

        size     = min(signal.get('amount_usd', 100),
                       self.config.get('max_position_size_usd', 500))
        strategy = SOURCE_TO_STRATEGY.get(source, source)

        if action == 'buy':
            if self.wallet['available'] < size:
                print(f"⚠️  Insufficient balance for {symbol}")
                return
            src_count     = len([p for p in self.positions if p.get('source') == source])
            max_per_source = self.config.get('max_positions_per_source', 25)
            if src_count >= max_per_source:
                print(f"⚠️  Max positions for {source}")
                return

            self.wallet['available'] -= size
            pos = {
                "id": f"TWEAK-{datetime.utcnow().strftime('%Y%m%d%H%M%S')}-{len(self.positions)}",
                "source": source, "strategy": strategy, "symbol": symbol,
                "side": "buy", "entry_price": current_price, "size_usd": size,
                "quantity": size / current_price,
                "opened_at": datetime.utcnow().isoformat(), "status": "open",
                "signal_data": signal,
                "target_price": signal.get('target'),
                "stop_loss": signal.get('stop_loss')
            }
            self.positions.append(pos)
            self.save_positions()
            self.log_trade({"source": source, "strategy": strategy, "action": "buy",
                            "symbol": symbol, "price": current_price, "size_usd": size,
                            "signal": signal.get('reason') or signal.get('analysis')})
            rel = self.config['signal_sources'][source]['signals_file']
            self.mark_signal_processed(rel, match_fn=lambda s: (
                (s.get('symbol') or s.get('coin')) == symbol and
                not s.get('processed_by_tweak')
            ))
            print(f"  💰 BUY {symbol} @ ${current_price:,.4f} | ${size} | {strategy}")

    def execute_telegram_signal(self, signal: Dict):
        symbol    = signal.get('symbol', '')
        direction = signal.get('direction', '').upper()
        entry     = signal.get('entry')
        size      = min(100, self.config.get('max_position_size_usd', 500))
        source    = 'telegram'
        strategy  = 'telegram'

        if not symbol or not entry:
            return
        if direction not in ['BUY', 'LONG', 'CALL']:
            return

        if self.wallet['available'] < size:
            print(f"⚠️  Insufficient balance")
            return

        max_total = self.config.get('risk_management', {}).get('max_total_positions', 100)
        if len(self.positions) >= max_total:
            print(f"⚠️  Max total positions reached")
            return

        src_count     = len([p for p in self.positions if p.get('source') == source])
        max_per_source = self.config.get('max_positions_per_source', 25)
        if src_count >= max_per_source:
            print(f"⚠️  Max telegram positions reached")
            return

        # Get live price — Coinbase for crypto, Finnhub for stocks
        current_price = self.get_live_price(symbol)
        if not current_price:
            print(f"⚠️  No price for {symbol}, using entry price {entry}")
            current_price = entry
        if not current_price or current_price <= 0:
            print(f"⚠️  Invalid price for {symbol}, skipping")
            return

        self.wallet['available'] -= size
        targets = signal.get('targets', [])
        pos = {
            "id": f"TWEAK-{datetime.utcnow().strftime('%Y%m%d%H%M%S')}-{len(self.positions)}",
            "source": source, "strategy": strategy, "symbol": symbol,
            "side": "buy", "entry_price": current_price, "size_usd": size,
            "quantity": size / current_price,
            "opened_at": datetime.utcnow().isoformat(), "status": "open",
            "signal_data": signal,
            "target_price": targets[0] if targets else None,
            "stop_loss": signal.get('stop_loss'),
            "score": signal.get('score'),
            "channel": signal.get('channel_name'),
        }
        self.positions.append(pos)
        self.save_positions()
        self.log_trade({"source": source, "strategy": strategy, "action": "buy",
                        "symbol": symbol, "price": current_price, "size_usd": size,
                        "signal": signal.get('raw_text', '')[:80]})

        rel = self.config['signal_sources']['telegram']['signals_file']
        self.mark_signal_processed(rel, signal_id=signal.get('id'))

        asset_type = "crypto" if self.is_crypto(symbol) else "stock"
        print(f"  📡 TELEGRAM BUY {symbol} ({asset_type}) @ ${current_price:,.4f} | "
              f"${size} | score={signal.get('score')}")

    # ── Trade log ─────────────────────────────────────────────────────────────

    def log_trade(self, trade: Dict):
        p = self.bot_dir / "trades.json"
        trades = json.load(open(p)) if p.exists() else []
        trade['timestamp'] = datetime.utcnow().isoformat()
        trade['bot'] = 'tweak'
        trades.append(trade)
        with open(p, 'w') as f:
            json.dump(trades, f, indent=2)

    # ── Status ────────────────────────────────────────────────────────────────

    def update_status(self):
        status = {
            "bot": "tweak", "status": "active", "mode": "paper_trading",
            "last_update": datetime.utcnow().isoformat(),
            "wallet_balance": self.wallet['balance_usd'],
            "available_balance": self.wallet['available'],
            "active_positions": len(self.positions),
            "pnl_by_source": self.pnl_by_source,
            "total_pnl": sum(self.pnl_by_source.get(s, {}).get('total_pnl', 0)
                             for s in self.pnl_by_source)
        }
        with open(self.bot_dir / "status.json", 'w') as f:
            json.dump(status, f, indent=2)

    # ── Main loop ─────────────────────────────────────────────────────────────

    def run(self):
        print(f"\n🚀 Tweak starting...")
        print(f"   Interval: {self.config.get('check_interval_seconds', 30)}s")
        print(f"   Max positions: {self.config.get('risk_management', {}).get('max_total_positions', 100)}")
        print()

        while True:
            try:
                print(f"\n⚙️  {datetime.utcnow().strftime('%H:%M:%S')} | "
                      f"Balance: ${self.wallet['available']:,.2f} | "
                      f"Positions: {len(self.positions)}")

                if self.config.get('signal_sources', {}).get('ai_crypto', {}).get('enabled'):
                    for sig in self.read_simple_signals('ai_crypto'):
                        self.execute_simple_signal(sig, 'ai_crypto')

                if self.config.get('signal_sources', {}).get('firebase', {}).get('enabled'):
                    for sig in self.read_simple_signals('firebase'):
                        self.execute_simple_signal(sig, 'firebase')

                telegram_signals = self.read_telegram_signals()
                if telegram_signals:
                    print(f"\n📡 Telegram: {len(telegram_signals)} actionable signals")
                    for sig in telegram_signals:
                        self.execute_telegram_signal(sig)

                # Update P&L on all open positions
                for pos in self.positions:
                    if pos['status'] != 'open':
                        continue
                    price = self.get_live_price(pos['symbol'])
                    if price and price > 0:
                        entry    = pos['entry_price']
                        qty      = pos['quantity']
                        size_usd = pos['size_usd']
                        pnl      = (price - entry) * qty
                        pos['current_price']      = price
                        pos['unrealized_pnl']     = pnl
                        pos['unrealized_pnl_pct'] = (pnl / size_usd * 100) if size_usd else 0

                self.save_positions()
                self.save_wallet()
                self.update_status()

                time.sleep(self.config.get('check_interval_seconds', 30))

            except KeyboardInterrupt:
                print("\n\n👋 Tweak shutting down...")
                self.update_status()
                break
            except Exception as e:
                print(f"\n❌ Error: {e}")
                time.sleep(self.config.get('check_interval_seconds', 30))


if __name__ == "__main__":
    bot = TweakSignalTrader()
    bot.run()
