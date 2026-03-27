#!/usr/bin/env python3
"""
Tweak Discord Monitor - Watches trade files and posts updates to Discord.
Monitors positions.json, trades.json, and wallet.json for changes and posts to #tweak-trades.

Usage:
  python3 tweak_discord_monitor.py
  
This will:
- Monitor for new positions opened
- Monitor for positions closed with P&L
- Post daily summary at midnight UTC
"""

import json
import os
import time
import hashlib
import requests
from datetime import datetime, timedelta
from pathlib import Path
from typing import Dict, Any, Optional, List

class TweakDiscordMonitor:
    def __init__(self, config_path: str = "discord_config.json"):
        self.config_path = config_path
        self.config = self._load_config()
        self.webhook_url = self.config.get("webhook_url")
        
        # Track state to avoid duplicate posts
        self.last_positions_hash = None
        self.last_trades_hash = None
        self.tracked_positions = {}  # Track positions we've already posted about
        self.last_daily_summary = None
        
        print(f"[Tweak Discord Monitor] Initialized")
        print(f"[Tweak Discord Monitor] Webhook URL: {self.webhook_url[:50]}...")
        print(f"[Tweak Discord Monitor] Channel: #{self.config.get('channel_name')}")
    
    def _load_config(self) -> Dict[str, Any]:
        """Load Discord configuration."""
        try:
            with open(self.config_path, 'r') as f:
                return json.load(f)
        except Exception as e:
            print(f"[ERROR] Failed to load config: {e}")
            return {}
    
    def _read_json_file(self, path: str) -> Optional[Dict | List]:
        """Safely read JSON file."""
        try:
            if os.path.exists(path):
                with open(path, 'r') as f:
                    return json.load(f)
        except Exception as e:
            print(f"[WARN] Error reading {path}: {e}")
        return None
    
    def _file_hash(self, data: Any) -> str:
        """Get hash of data for change detection."""
        return hashlib.md5(json.dumps(data, sort_keys=True).encode()).hexdigest()
    
    def _send_webhook(self, content: str = "", embeds: List[Dict] = None) -> bool:
        """Send message to Discord webhook."""
        try:
            payload = {}
            if content:
                payload["content"] = content
            if embeds:
                payload["embeds"] = embeds
            
            response = requests.post(
                self.webhook_url,
                json=payload,
                headers={"Content-Type": "application/json"},
                timeout=10
            )
            
            if response.status_code in [200, 204]:
                return True
            else:
                print(f"[WARN] Discord POST failed: {response.status_code}")
                return False
        except Exception as e:
            print(f"[ERROR] Webhook error: {e}")
            return False
    
    def _format_position_open(self, position: Dict) -> str:
        """Format position open message."""
        symbol = position.get('symbol', 'UNKNOWN')
        entry = position.get('entry_price', 0)
        size_usd = position.get('size_usd', 0)
        source = position.get('source', 'Unknown')
        strategy = position.get('signal_data', {}).get('action', 'Buy').upper()
        
        return f"💰 BOUGHT {symbol} @ ${entry:,.2f} | Size: ${size_usd:,.2f} | Source: {source}"
    
    def _format_position_close(self, position: Dict) -> str:
        """Format position close message."""
        symbol = position.get('symbol', 'UNKNOWN')
        exit_price = position.get('current_price', 0)
        pnl = position.get('unrealized_pnl', 0)
        pnl_pct = position.get('unrealized_pnl_pct', 0)
        source = position.get('source', 'Unknown')
        
        emoji = "📈" if pnl >= 0 else "📉"
        return f"{emoji} SOLD {symbol} @ ${exit_price:,.2f} | P&L: ${pnl:,.2f} ({pnl_pct:+.2f}%) | Source: {source}"
    
    def post_position_open(self, position: Dict) -> bool:
        """Post position open to Discord."""
        symbol = position.get('symbol', 'UNKNOWN')
        entry = position.get('entry_price', 0)
        size_usd = position.get('size_usd', 0)
        source = position.get('source', 'Unknown')
        strategy = position.get('signal_data', {}).get('reason', 'Grid/DCA')
        target = position.get('target_price')
        stop_loss = position.get('stop_loss')
        
        embed = {
            "title": f"💰 Position Opened: {symbol}",
            "color": 3066993,  # Green
            "fields": [
                {"name": "Entry Price", "value": f"${entry:,.2f}", "inline": True},
                {"name": "Size", "value": f"${size_usd:,.2f}", "inline": True},
                {"name": "Source", "value": source, "inline": True},
            ],
            "description": strategy,
            "timestamp": datetime.utcnow().isoformat(),
            "footer": {"text": "Tweak Trading Bot"}
        }
        
        if target:
            embed["fields"].append({"name": "Target", "value": f"${target:,.2f}", "inline": True})
        if stop_loss:
            embed["fields"].append({"name": "Stop Loss", "value": f"${stop_loss:,.2f}", "inline": True})
        
        success = self._send_webhook(embeds=[embed])
        if success:
            print(f"[Discord] ✅ Posted position open: {symbol}")
        return success
    
    def post_position_close(self, position: Dict) -> bool:
        """Post position close to Discord."""
        symbol = position.get('symbol', 'UNKNOWN')
        entry = position.get('entry_price', 0)
        exit_price = position.get('current_price', 0)
        pnl = position.get('unrealized_pnl', 0)
        pnl_pct = position.get('unrealized_pnl_pct', 0)
        source = position.get('source', 'Unknown')
        
        color = 3066993 if pnl >= 0 else 15158332  # Green if profit, red if loss
        emoji = "✅" if pnl >= 0 else "❌"
        
        embed = {
            "title": f"{emoji} Position Closed: {symbol}",
            "color": color,
            "fields": [
                {"name": "Entry Price", "value": f"${entry:,.2f}", "inline": True},
                {"name": "Exit Price", "value": f"${exit_price:,.2f}", "inline": True},
                {"name": "P&L (USD)", "value": f"${pnl:,.2f}", "inline": True},
                {"name": "P&L (%)", "value": f"{pnl_pct:+.2f}%", "inline": True},
                {"name": "Source", "value": source, "inline": True},
            ],
            "timestamp": datetime.utcnow().isoformat(),
            "footer": {"text": "Tweak Trading Bot"}
        }
        
        success = self._send_webhook(embeds=[embed])
        if success:
            print(f"[Discord] ✅ Posted position close: {symbol}")
        return success
    
    def post_daily_summary(self, stats: Dict) -> bool:
        """Post daily summary to Discord."""
        embed = {
            "title": f"📊 Tweak Daily Summary - {datetime.now().strftime('%Y-%m-%d')}",
            "color": 3066993,
            "fields": [
                {"name": "Total P&L", "value": f"${stats.get('total_pnl', 0):,.2f}", "inline": True},
                {"name": "Active Positions", "value": str(stats.get('active_positions', 0)), "inline": True},
                {"name": "Wallet Balance", "value": f"${stats.get('wallet_balance', 0):,.2f}", "inline": True},
                {"name": "Total Trades", "value": str(stats.get('total_trades', 0)), "inline": True},
                {"name": "Win Rate", "value": f"{stats.get('win_rate', 0):.1f}%", "inline": True},
                {"name": "Grid Strategies", "value": str(stats.get('grid_strategies', 0)), "inline": True},
                {"name": "DCA Strategies", "value": str(stats.get('dca_strategies', 0)), "inline": True},
            ],
            "timestamp": datetime.utcnow().isoformat(),
            "footer": {"text": "Tweak Trading Bot - Daily Report"}
        }
        
        # Add P&L by source if available
        pnl_source = stats.get('pnl_by_source', {})
        if pnl_source:
            ai_crypto = pnl_source.get('ai_crypto', {})
            firebase = pnl_source.get('firebase', {})
            
            if ai_crypto:
                embed["fields"].append({
                    "name": "AI Crypto",
                    "value": f"P&L: ${ai_crypto.get('total_pnl', 0):,.2f} | Win Rate: {ai_crypto.get('win_rate', 0):.1f}% | Trades: {ai_crypto.get('total_trades', 0)}",
                    "inline": False
                })
            
            if firebase:
                embed["fields"].append({
                    "name": "Firebase",
                    "value": f"P&L: ${firebase.get('total_pnl', 0):,.2f} | Win Rate: {firebase.get('win_rate', 0):.1f}% | Trades: {firebase.get('total_trades', 0)}",
                    "inline": False
                })
        
        success = self._send_webhook(embeds=[embed])
        if success:
            print(f"[Discord] ✅ Posted daily summary")
        return success
    
    def check_positions(self) -> bool:
        """Check positions.json for new opens/closes."""
        positions_data = self._read_json_file('positions.json')
        if not positions_data:
            return False
        
        current_hash = self._file_hash(positions_data)
        if current_hash == self.last_positions_hash:
            return False
        
        self.last_positions_hash = current_hash
        
        # Initialize tracked positions on first run
        if not self.tracked_positions and isinstance(positions_data, list):
            for position in positions_data:
                pos_id = position.get('id')
                self.tracked_positions[pos_id] = {'status': position.get('status'), 'posted': True}
            return False  # Don't post initial positions, just track them
        
        # Check for new positions
        if isinstance(positions_data, list):
            for position in positions_data:
                pos_id = position.get('id')
                
                # New position opened (not previously tracked)
                if pos_id not in self.tracked_positions:
                    if position.get('status') == 'open':
                        self.post_position_open(position)
                        self.tracked_positions[pos_id] = {'status': 'open', 'posted': True}
                
                # Position closed
                elif self.tracked_positions.get(pos_id, {}).get('status') == 'open' and position.get('status') == 'closed':
                    self.post_position_close(position)
                    self.tracked_positions[pos_id]['status'] = 'closed'
        
        return True
    
    def check_daily_summary(self) -> bool:
        """Check if it's time for daily summary (midnight UTC)."""
        now = datetime.utcnow()
        summary_time = now.replace(hour=0, minute=0, second=0, microsecond=0)
        
        # Only post once per day
        if self.last_daily_summary:
            if self.last_daily_summary.date() == now.date():
                return False
        
        # Check if we're close to midnight (within 5 minutes)
        if abs((now - summary_time).total_seconds()) > 300:
            return False
        
        # Load stats from various files
        stats = {
            'total_pnl': 0,
            'active_positions': 0,
            'wallet_balance': 0,
            'total_trades': 0,
            'win_rate': 0,
            'grid_strategies': 0,
            'dca_strategies': 0,
            'pnl_by_source': {}
        }
        
        # Get wallet balance
        wallet = self._read_json_file('wallet.json')
        if wallet:
            stats['wallet_balance'] = wallet.get('balance_usd', 0)
        
        # Get position stats
        positions = self._read_json_file('positions.json')
        if positions and isinstance(positions, list):
            open_positions = [p for p in positions if p.get('status') == 'open']
            stats['active_positions'] = len(open_positions)
            
            grid_count = sum(1 for p in open_positions if p.get('strategy') == 'grid')
            dca_count = sum(1 for p in open_positions if p.get('strategy') == 'dca')
            stats['grid_strategies'] = grid_count
            stats['dca_strategies'] = dca_count
        
        # Get trades and P&L by source
        pnl_by_source = self._read_json_file('pnl_by_source.json')
        if pnl_by_source:
            stats['pnl_by_source'] = pnl_by_source
            total_pnl = 0
            for source, data in pnl_by_source.items():
                total_pnl += data.get('total_pnl', 0)
            stats['total_pnl'] = total_pnl
        
        # Get total trades
        trades = self._read_json_file('trades.json')
        if trades and isinstance(trades, list):
            stats['total_trades'] = len(trades)
        
        self.post_daily_summary(stats)
        self.last_daily_summary = now
        return True
    
    def run(self, interval: int = 5):
        """Run the monitor loop."""
        print(f"[Tweak Discord Monitor] Starting monitor (check every {interval}s)...")
        
        try:
            while True:
                # Check for position changes
                self.check_positions()
                
                # Check for daily summary (every 5s, posts only once per day)
                self.check_daily_summary()
                
                time.sleep(interval)
        except KeyboardInterrupt:
            print("[Tweak Discord Monitor] Stopped")
        except Exception as e:
            print(f"[ERROR] Monitor crashed: {e}")
            raise

if __name__ == "__main__":
    monitor = TweakDiscordMonitor()
    monitor.run(interval=5)  # Check every 5 seconds
