"""
DCA (Dollar Cost Averaging) Strategy
Executes periodic buying with dip-buying enhancements
"""

import json
from datetime import datetime, timedelta
from typing import Dict, Optional

class DCAStrategy:
    def __init__(self, config: Dict):
        self.config = config
    
    def execute(self, strategy: Dict, market_conditions: Dict, wallet, positions) -> Dict:
        """
        Execute DCA strategy
        
        Strategy types:
        - time_based: Buy fixed amount at intervals
        - dip_buying: Increase buy size on larger dips
        - smart_dca: Use Analyst signals to optimize entries
        """
        
        strategy_type = strategy.get('type', 'time_based')
        symbol = strategy.get('symbol')
        
        # Get current price
        current_price = self.get_current_price(symbol)
        
        if current_price is None:
            return {"action": "skip", "reason": "price_unavailable"}
        
        # Check if it's time to buy
        last_buy = strategy.get('last_buy_timestamp')
        interval_hours = strategy.get('interval_hours', 24)
        
        if last_buy:
            last_buy_time = datetime.fromisoformat(last_buy)
            time_since_last = datetime.utcnow() - last_buy_time
            
            if time_since_last.total_seconds() < (interval_hours * 3600):
                return {"action": "skip", "reason": "too_soon"}
        
        # Execute based on strategy type
        if strategy_type == 'time_based':
            return self.execute_time_based(strategy, current_price, wallet)
        
        elif strategy_type == 'dip_buying':
            return self.execute_dip_buying(strategy, current_price, wallet, positions)
        
        elif strategy_type == 'smart_dca':
            return self.execute_smart_dca(strategy, current_price, wallet, market_conditions)
        
        return {"action": "skip", "reason": "unknown_strategy_type"}
    
    def execute_time_based(self, strategy: Dict, current_price: float, wallet) -> Dict:
        """
        Time-based DCA: Buy fixed amount at regular intervals
        """
        
        base_amount = strategy.get('base_amount', 10)
        
        if wallet.get_balance() < base_amount:
            return {"action": "skip", "reason": "insufficient_balance"}
        
        # Check max position size
        max_position = strategy.get('max_position', 100)
        current_position = self.get_current_position_value(strategy.get('symbol'))
        
        if current_position + base_amount > max_position:
            return {"action": "skip", "reason": "max_position_reached"}
        
        return {
            "action": "buy",
            "symbol": strategy.get('symbol'),
            "size": base_amount,
            "price": current_price,
            "strategy": strategy.get('name'),
            "type": "time_based_dca"
        }
    
    def execute_dip_buying(self, strategy: Dict, current_price: float, wallet, positions) -> Dict:
        """
        Dip Buying DCA: Increase buy size when price drops more
        """
        
        base_amount = strategy.get('base_amount', 10)
        dip_multiplier = strategy.get('dip_multiplier', 2.0)
        
        # Get reference price (average of last N buys or MA)
        reference_price = self.get_reference_price(strategy, positions)
        
        if reference_price is None:
            # First buy, use base amount
            buy_amount = base_amount
        else:
            # Calculate dip percentage
            dip_pct = (reference_price - current_price) / reference_price
            
            if dip_pct > 0:  # Price is lower than reference
                # Scale up buy amount based on dip size
                # 5% dip = 1.5x, 10% dip = 2x, 15% dip = 2.5x
                multiplier = 1 + (dip_pct * dip_multiplier * 10)
                buy_amount = base_amount * min(multiplier, 3.0)  # Cap at 3x
            else:
                # Price is higher, use base amount
                buy_amount = base_amount
        
        if wallet.get_balance() < buy_amount:
            return {"action": "skip", "reason": "insufficient_balance"}
        
        # Check max position
        max_position = strategy.get('max_position', 100)
        current_position = self.get_current_position_value(strategy.get('symbol'))
        
        if current_position + buy_amount > max_position:
            return {"action": "skip", "reason": "max_position_reached"}
        
        return {
            "action": "buy",
            "symbol": strategy.get('symbol'),
            "size": round(buy_amount, 2),
            "price": current_price,
            "strategy": strategy.get('name'),
            "type": "dip_buying_dca",
            "dip_detected": reference_price is not None and current_price < reference_price
        }
    
    def execute_smart_dca(self, strategy: Dict, current_price: float,
                         wallet, market_conditions: Dict) -> Dict:
        """
        Smart DCA: Use market conditions and Analyst signals
        """
        
        base_amount = strategy.get('base_amount', 10)
        
        # Check BTC bias
        btc_bias = market_conditions.get('btc_bias', 'neutral')
        btc_score = market_conditions.get('btc_score', 0)
        
        # Adjust buy amount based on market conditions
        if btc_bias == 'bullish' and btc_score > 5:
            # Strong bullish signal, increase buy
            buy_amount = base_amount * 1.5
        elif btc_bias == 'bearish' and btc_score < -5:
            # Strong bearish signal, reduce buy
            buy_amount = base_amount * 0.5
        else:
            # Neutral, use base amount
            buy_amount = base_amount
        
        if wallet.get_balance() < buy_amount:
            return {"action": "skip", "reason": "insufficient_balance"}
        
        # Check max position
        max_position = strategy.get('max_position', 100)
        current_position = self.get_current_position_value(strategy.get('symbol'))
        
        if current_position + buy_amount > max_position:
            return {"action": "skip", "reason": "max_position_reached"}
        
        return {
            "action": "buy",
            "symbol": strategy.get('symbol'),
            "size": round(buy_amount, 2),
            "price": current_price,
            "strategy": strategy.get('name'),
            "type": "smart_dca",
            "btc_bias": btc_bias,
            "btc_score": btc_score
        }
    
    def get_reference_price(self, strategy: Dict, positions) -> Optional[float]:
        """Get reference price for dip detection"""
        
        # Get recent buys for this strategy
        strategy_positions = positions.get_strategy_positions(strategy.get('name'))
        
        if not strategy_positions:
            return None
        
        # Calculate average entry price
        total_value = 0
        total_size = 0
        
        for position in strategy_positions[-5:]:  # Last 5 buys
            if position.get('side') == 'buy':
                total_value += position.get('price', 0) * position.get('size', 0)
                total_size += position.get('size', 0)
        
        if total_size == 0:
            return None
        
        return total_value / total_size
    
    def get_current_position_value(self, symbol: str) -> float:
        """
        Get current total position value for symbol
        In production, fetch from wallet/exchange
        """
        # Mock - replace with actual position tracking
        return 0.0
    
    def get_current_price(self, symbol: str) -> Optional[float]:
        """Get current price (mock for now)"""
        
        mock_prices = {
            "BTC/USDT": 67000,
            "ETH/USDT": 3200,
            "SOL/USDT": 145,
            "ARB/USDT": 1.15,
            "AVAX/USDT": 38
        }
        
        return mock_prices.get(symbol)
