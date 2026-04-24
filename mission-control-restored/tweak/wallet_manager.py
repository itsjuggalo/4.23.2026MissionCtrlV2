"""
Wallet Manager
Manages Tweak's dedicated trading wallet and balance
"""

import json
from datetime import datetime
from pathlib import Path
from typing import Dict, Optional

class WalletManager:
    def __init__(self, bot_dir: Path):
        self.bot_dir = bot_dir
        self.wallet_file = bot_dir / "wallet.json"
        self.wallet_data = self.load_wallet()
    
    def load_wallet(self) -> Dict:
        """Load wallet data"""
        if self.wallet_file.exists():
            with open(self.wallet_file, 'r') as f:
                return json.load(f)
        else:
            # Initialize wallet
            default_wallet = {
                "balance_usd": 100.0,  # Starting balance
                "reserved": 0.0,
                "available": 100.0,
                "transactions": [],
                "created_at": datetime.utcnow().isoformat()
            }
            self.save_wallet(default_wallet)
            return default_wallet
    
    def save_wallet(self, wallet_data: Optional[Dict] = None):
        """Save wallet data"""
        if wallet_data is None:
            wallet_data = self.wallet_data
        
        with open(self.wallet_file, 'w') as f:
            json.dump(wallet_data, f, indent=2)
    
    def get_balance(self) -> float:
        """Get available balance"""
        return self.wallet_data.get('available', 0.0)
    
    def get_total_balance(self) -> float:
        """Get total balance (available + reserved)"""
        return self.wallet_data.get('balance_usd', 0.0)
    
    def reserve_funds(self, amount: float, reason: str = "") -> bool:
        """Reserve funds for a trade"""
        if self.wallet_data.get('available', 0) >= amount:
            self.wallet_data['available'] -= amount
            self.wallet_data['reserved'] += amount
            
            # Log transaction
            self.add_transaction({
                "type": "reserve",
                "amount": amount,
                "reason": reason,
                "timestamp": datetime.utcnow().isoformat()
            })
            
            self.save_wallet()
            return True
        
        return False
    
    def release_funds(self, amount: float, reason: str = ""):
        """Release reserved funds"""
        release_amount = min(amount, self.wallet_data.get('reserved', 0))
        
        self.wallet_data['reserved'] -= release_amount
        self.wallet_data['available'] += release_amount
        
        # Log transaction
        self.add_transaction({
            "type": "release",
            "amount": release_amount,
            "reason": reason,
            "timestamp": datetime.utcnow().isoformat()
        })
        
        self.save_wallet()
    
    def add_funds(self, amount: float, reason: str = "deposit"):
        """Add funds to wallet"""
        self.wallet_data['balance_usd'] += amount
        self.wallet_data['available'] += amount
        
        # Log transaction
        self.add_transaction({
            "type": "deposit",
            "amount": amount,
            "reason": reason,
            "timestamp": datetime.utcnow().isoformat()
        })
        
        self.save_wallet()
    
    def remove_funds(self, amount: float, reason: str = "withdrawal"):
        """Remove funds from wallet"""
        if self.wallet_data.get('available', 0) >= amount:
            self.wallet_data['balance_usd'] -= amount
            self.wallet_data['available'] -= amount
            
            # Log transaction
            self.add_transaction({
                "type": "withdrawal",
                "amount": amount,
                "reason": reason,
                "timestamp": datetime.utcnow().isoformat()
            })
            
            self.save_wallet()
            return True
        
        return False
    
    def record_trade(self, trade_type: str, amount: float, pnl: float):
        """Record a completed trade"""
        if trade_type == "buy":
            # Deduct from available
            if self.wallet_data.get('available', 0) >= amount:
                self.wallet_data['available'] -= amount
                self.wallet_data['balance_usd'] -= amount
        
        elif trade_type == "sell":
            # Add proceeds + P&L
            proceeds = amount + pnl
            self.wallet_data['available'] += proceeds
            self.wallet_data['balance_usd'] += proceeds
        
        # Log transaction
        self.add_transaction({
            "type": "trade",
            "trade_type": trade_type,
            "amount": amount,
            "pnl": pnl,
            "timestamp": datetime.utcnow().isoformat()
        })
        
        self.save_wallet()
    
    def add_transaction(self, transaction: Dict):
        """Add transaction to history"""
        if 'transactions' not in self.wallet_data:
            self.wallet_data['transactions'] = []
        
        self.wallet_data['transactions'].append(transaction)
        
        # Keep only last 1000 transactions
        if len(self.wallet_data['transactions']) > 1000:
            self.wallet_data['transactions'] = self.wallet_data['transactions'][-1000:]
    
    def get_stats(self) -> Dict:
        """Get wallet statistics"""
        transactions = self.wallet_data.get('transactions', [])
        
        total_deposits = sum(t.get('amount', 0) for t in transactions if t.get('type') == 'deposit')
        total_withdrawals = sum(t.get('amount', 0) for t in transactions if t.get('type') == 'withdrawal')
        total_trades = len([t for t in transactions if t.get('type') == 'trade'])
        total_pnl = sum(t.get('pnl', 0) for t in transactions if t.get('type') == 'trade')
        
        return {
            "total_balance": self.wallet_data.get('balance_usd', 0),
            "available": self.wallet_data.get('available', 0),
            "reserved": self.wallet_data.get('reserved', 0),
            "total_deposits": total_deposits,
            "total_withdrawals": total_withdrawals,
            "total_trades": total_trades,
            "total_pnl": total_pnl,
            "roi": (total_pnl / total_deposits * 100) if total_deposits > 0 else 0
        }
