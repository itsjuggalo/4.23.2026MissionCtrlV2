"""
Position Manager
Tracks open positions, grid levels, and P&L
"""

import json
from datetime import datetime
from pathlib import Path
from typing import Dict, List

class PositionManager:
    def __init__(self, bot_dir: Path):
        self.bot_dir = bot_dir
        self.positions_file = bot_dir / "positions.json"
        self.positions = self.load_positions()
    
    def load_positions(self) -> List[Dict]:
        """Load positions from file"""
        if self.positions_file.exists():
            with open(self.positions_file, 'r') as f:
                return json.load(f)
        return []
    
    def save_positions(self):
        """Save positions to file"""
        with open(self.positions_file, 'w') as f:
            json.dump(self.positions, f, indent=2)
    
    def add_position(self, position: Dict):
        """Add a new position"""
        position['id'] = self.generate_position_id()
        position['opened_at'] = datetime.utcnow().isoformat()
        position['status'] = 'open'
        
        self.positions.append(position)
        self.save_positions()
        
        return position['id']
    
    def close_position(self, position_id: str, exit_price: float):
        """Close a position"""
        for position in self.positions:
            if position.get('id') == position_id:
                position['status'] = 'closed'
                position['exit_price'] = exit_price
                position['closed_at'] = datetime.utcnow().isoformat()
                
                # Calculate P&L
                entry_price = position.get('entry_price', 0)
                size = position.get('size', 0)
                side = position.get('side', 'buy')
                
                if side == 'buy':
                    pnl = (exit_price - entry_price) * size
                else:  # sell/short
                    pnl = (entry_price - exit_price) * size
                
                position['pnl'] = pnl
                position['pnl_pct'] = (pnl / (entry_price * size)) * 100
                
                self.save_positions()
                return position
        
        return None
    
    def get_active_positions(self) -> List[Dict]:
        """Get all open positions"""
        return [p for p in self.positions if p.get('status') == 'open']
    
    def get_strategy_positions(self, strategy_name: str) -> List[Dict]:
        """Get positions for a specific strategy"""
        return [p for p in self.get_active_positions() 
                if p.get('strategy') == strategy_name]
    
    def update_positions(self):
        """Update all positions with current prices"""
        active_positions = self.get_active_positions()
        
        for position in active_positions:
            symbol = position.get('symbol')
            current_price = self.get_current_price(symbol)
            
            if current_price:
                entry_price = position.get('entry_price', 0)
                size = position.get('size', 0)
                side = position.get('side', 'buy')
                
                if side == 'buy':
                    unrealized_pnl = (current_price - entry_price) * size
                else:
                    unrealized_pnl = (entry_price - current_price) * size
                
                position['current_price'] = current_price
                position['unrealized_pnl'] = unrealized_pnl
                position['unrealized_pnl_pct'] = (unrealized_pnl / (entry_price * size)) * 100
        
        self.save_positions()
    
    def get_total_pnl(self) -> Dict:
        """Calculate total P&L across all positions"""
        realized_pnl = sum(p.get('pnl', 0) for p in self.positions if p.get('status') == 'closed')
        unrealized_pnl = sum(p.get('unrealized_pnl', 0) for p in self.get_active_positions())
        
        return {
            "realized": realized_pnl,
            "unrealized": unrealized_pnl,
            "total": realized_pnl + unrealized_pnl
        }
    
    def generate_position_id(self) -> str:
        """Generate unique position ID"""
        timestamp = datetime.utcnow().strftime('%Y%m%d%H%M%S')
        count = len(self.positions)
        return f"TWEAK-{timestamp}-{count}"
    
    def get_current_price(self, symbol: str) -> float:
        """Get current price (mock for now)"""
        mock_prices = {
            "BTC/USDT": 67000,
            "ETH/USDT": 3200,
            "SOL/USDT": 145,
            "ARB/USDT": 1.15,
            "AVAX/USDT": 38
        }
        
        return mock_prices.get(symbol, 0)
