#!/usr/bin/env python3
"""
TWEAK - Automated Grid/DCA Trading Bot
Citadel + Jane Street DNA: Systematic grid strategies + High-frequency execution

Tier 3: Execution & Monitoring
Reports to: Risk Manager (for strategy approval)
Feeds into: Portfolio Monitor, Auditor
Independence: Can execute micro-trades autonomously
"""

import json
import time
import os
from datetime import datetime
from pathlib import Path
from typing import Dict, List, Optional

# Import strategies
from grid_strategy import GridStrategy
from dca_strategy import DCAStrategy
from position_manager import PositionManager
from wallet_manager import WalletManager

class TweakBot:
    def __init__(self):
        self.bot_dir = Path(__file__).parent
        self.config = self.load_config()
        
        # Initialize managers
        self.position_manager = PositionManager(self.bot_dir)
        self.wallet_manager = WalletManager(self.bot_dir)
        
        # Initialize strategies
        self.grid_strategy = GridStrategy(self.config.get('grid', {}))
        self.dca_strategy = DCAStrategy(self.config.get('dca', {}))
        
        # State
        self.active = True
        self.last_update = None
        
        print("="*60)
        print("🤖 TWEAK - Automated Grid/DCA Trading Bot")
        print("Citadel + Jane Street DNA")
        print("="*60)
    
    def load_config(self) -> Dict:
        """Load configuration from config.json"""
        config_path = self.bot_dir / "config.json"
        
        if config_path.exists():
            with open(config_path, 'r') as f:
                return json.load(f)
        else:
            # Default config
            default_config = {
                "enabled": True,
                "check_interval_seconds": 60,
                "max_concurrent_positions": 5,
                "max_position_size_usd": 50,
                "auto_compound": True,
                "grid": {
                    "enabled": True,
                    "strategies": []
                },
                "dca": {
                    "enabled": True,
                    "strategies": []
                }
            }
            
            # Save default config
            with open(config_path, 'w') as f:
                json.dump(default_config, f, indent=2)
            
            print(f"📝 Created default config at {config_path}")
            return default_config
    
    def save_config(self):
        """Save current configuration"""
        config_path = self.bot_dir / "config.json"
        with open(config_path, 'w') as f:
            json.dump(self.config, f, indent=2)
    
    def check_market_conditions(self) -> Dict:
        """
        Get current market conditions from other agents
        - BTC Bias Scorer: Overall market direction
        - Analyst: Technical indicators
        - Macro Strategist: Macro environment
        """
        try:
            # Read BTC bias
            btc_bias_file = self.bot_dir.parent / "btc-bias" / "btc_bias.json"
            if btc_bias_file.exists():
                with open(btc_bias_file, 'r') as f:
                    btc_bias = json.load(f)
            else:
                btc_bias = {"bias": "neutral", "score": 0}
            
            # Read macro conditions
            macro_file = self.bot_dir.parent / "macro-strategist" / "macro_state.json"
            if macro_file.exists():
                with open(macro_file, 'r') as f:
                    macro = json.load(f)
            else:
                macro = {"regime": "neutral"}
            
            return {
                "btc_bias": btc_bias.get("bias", "neutral"),
                "btc_score": btc_bias.get("score", 0),
                "macro_regime": macro.get("regime", "neutral"),
                "timestamp": datetime.utcnow().isoformat()
            }
        
        except Exception as e:
            print(f"⚠️  Error reading market conditions: {e}")
            return {
                "btc_bias": "neutral",
                "btc_score": 0,
                "macro_regime": "neutral",
                "timestamp": datetime.utcnow().isoformat()
            }
    
    def execute_grid_strategies(self, market_conditions: Dict):
        """Execute active grid strategies"""
        if not self.config.get('grid', {}).get('enabled', True):
            return
        
        strategies = self.config.get('grid', {}).get('strategies', [])
        
        for strategy in strategies:
            if not strategy.get('active', True):
                continue
            
            try:
                # Check if we should execute this grid
                result = self.grid_strategy.execute(
                    strategy=strategy,
                    market_conditions=market_conditions,
                    wallet=self.wallet_manager,
                    positions=self.position_manager
                )
                
                if result.get('action') == 'trade':
                    self.log_trade(result)
                    print(f"  📊 Grid Trade: {result.get('symbol')} {result.get('side')} ${result.get('size')}")
            
            except Exception as e:
                print(f"❌ Grid strategy error ({strategy.get('name')}): {e}")
    
    def execute_dca_strategies(self, market_conditions: Dict):
        """Execute active DCA strategies"""
        if not self.config.get('dca', {}).get('enabled', True):
            return
        
        strategies = self.config.get('dca', {}).get('strategies', [])
        
        for strategy in strategies:
            if not strategy.get('active', True):
                continue
            
            try:
                # Check if we should execute DCA buy
                result = self.dca_strategy.execute(
                    strategy=strategy,
                    market_conditions=market_conditions,
                    wallet=self.wallet_manager,
                    positions=self.position_manager
                )
                
                if result.get('action') == 'buy':
                    self.log_trade(result)
                    print(f"  💰 DCA Buy: {result.get('symbol')} ${result.get('size')}")
            
            except Exception as e:
                print(f"❌ DCA strategy error ({strategy.get('name')}): {e}")
    
    def log_trade(self, trade: Dict):
        """Log trade to trades.json for Auditor review"""
        trades_file = self.bot_dir / "trades.json"
        
        # Load existing trades
        if trades_file.exists():
            with open(trades_file, 'r') as f:
                trades = json.load(f)
        else:
            trades = []
        
        # Add new trade
        trade['timestamp'] = datetime.utcnow().isoformat()
        trade['bot'] = 'tweak'
        trades.append(trade)
        
        # Save trades
        with open(trades_file, 'w') as f:
            json.dump(trades, f, indent=2)
    
    def update_status(self):
        """Update status.json for monitoring"""
        status = {
            "bot": "tweak",
            "status": "active" if self.active else "paused",
            "last_update": datetime.utcnow().isoformat(),
            "wallet_balance": self.wallet_manager.get_balance(),
            "active_positions": len(self.position_manager.get_active_positions()),
            "grid_strategies": len([s for s in self.config.get('grid', {}).get('strategies', []) if s.get('active')]),
            "dca_strategies": len([s for s in self.config.get('dca', {}).get('strategies', []) if s.get('active')]),
            "total_trades_today": self.get_trades_today_count()
        }
        
        status_file = self.bot_dir / "status.json"
        with open(status_file, 'w') as f:
            json.dump(status, f, indent=2)
    
    def get_trades_today_count(self) -> int:
        """Count trades executed today"""
        trades_file = self.bot_dir / "trades.json"
        
        if not trades_file.exists():
            return 0
        
        with open(trades_file, 'r') as f:
            trades = json.load(f)
        
        today = datetime.utcnow().date()
        return len([t for t in trades if datetime.fromisoformat(t['timestamp']).date() == today])
    
    def run(self):
        """Main execution loop"""
        print(f"\n🚀 Tweak bot starting...")
        print(f"   Check interval: {self.config.get('check_interval_seconds', 60)}s")
        print(f"   Grid strategies: {len(self.config.get('grid', {}).get('strategies', []))}")
        print(f"   DCA strategies: {len(self.config.get('dca', {}).get('strategies', []))}")
        print()
        
        while self.active:
            try:
                print(f"\n⚙️  Tweak check at {datetime.utcnow().strftime('%H:%M:%S')}")
                
                # Get market conditions
                market_conditions = self.check_market_conditions()
                print(f"   BTC Bias: {market_conditions['btc_bias']} ({market_conditions['btc_score']})")
                print(f"   Macro: {market_conditions['macro_regime']}")
                
                # Execute strategies
                self.execute_grid_strategies(market_conditions)
                self.execute_dca_strategies(market_conditions)
                
                # Update positions
                self.position_manager.update_positions()
                
                # Update status
                self.update_status()
                
                # Sleep
                time.sleep(self.config.get('check_interval_seconds', 60))
            
            except KeyboardInterrupt:
                print("\n\n👋 Tweak shutting down gracefully...")
                self.active = False
                break
            
            except Exception as e:
                print(f"\n❌ Error in main loop: {e}")
                time.sleep(self.config.get('check_interval_seconds', 60))


if __name__ == "__main__":
    bot = TweakBot()
    bot.run()
