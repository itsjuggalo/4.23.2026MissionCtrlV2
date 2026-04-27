"""
Grid Trading Strategy
Executes grid-based trading strategies (long, short, neutral)
"""

import json
from datetime import datetime
from typing import Dict, Optional

class GridStrategy:
    def __init__(self, config: Dict):
        self.config = config
    
    def execute(self, strategy: Dict, market_conditions: Dict, wallet, positions) -> Dict:
        """
        Execute grid strategy
        
        Strategy types:
        - long_grid: Buy low, sell high (bullish bias)
        - short_grid: Sell high, buy low (bearish bias)
        - neutral_grid: Profit from volatility both ways
        """
        
        strategy_type = strategy.get('type', 'neutral_grid')
        symbol = strategy.get('symbol')
        
        # Get current price (would fetch from exchange API in production)
        current_price = self.get_current_price(symbol)
        
        if current_price is None:
            return {"action": "skip", "reason": "price_unavailable"}
        
        # Check if price is in grid range
        price_range = strategy.get('range', [])
        if len(price_range) != 2:
            return {"action": "skip", "reason": "invalid_range"}
        
        min_price, max_price = price_range
        
        if current_price < min_price or current_price > max_price:
            return {"action": "skip", "reason": "price_out_of_range"}
        
        # Calculate grid levels
        num_grids = strategy.get('grids', 10)
        grid_size = (max_price - min_price) / num_grids
        
        # Determine which grid level we're in
        grid_level = int((current_price - min_price) / grid_size)
        
        # Check existing positions for this strategy
        existing_positions = positions.get_strategy_positions(strategy.get('name'))
        
        # Execute based on strategy type
        if strategy_type == 'long_grid':
            return self.execute_long_grid(
                strategy, grid_level, num_grids, current_price,
                existing_positions, wallet
            )
        
        elif strategy_type == 'short_grid':
            return self.execute_short_grid(
                strategy, grid_level, num_grids, current_price,
                existing_positions, wallet
            )
        
        elif strategy_type == 'neutral_grid':
            return self.execute_neutral_grid(
                strategy, grid_level, num_grids, current_price,
                existing_positions, wallet, market_conditions
            )
        
        return {"action": "skip", "reason": "unknown_strategy_type"}
    
    def execute_long_grid(self, strategy: Dict, grid_level: int, num_grids: int,
                          current_price: float, existing_positions: list, wallet) -> Dict:
        """
        Long Grid: Buy at lower levels, sell at higher levels
        More aggressive buying at bottom, take profits at top
        """
        
        amount_per_grid = strategy.get('amount_per_grid', 10)
        take_profit_pct = strategy.get('take_profit', 0.5) / 100
        
        # Buy zone: bottom 60% of grid
        if grid_level < (num_grids * 0.6):
            # Check if we should buy more
            if wallet.get_balance() >= amount_per_grid:
                return {
                    "action": "trade",
                    "side": "buy",
                    "symbol": strategy.get('symbol'),
                    "size": amount_per_grid,
                    "price": current_price,
                    "strategy": strategy.get('name'),
                    "grid_level": grid_level
                }
        
        # Sell zone: top 40% of grid
        elif grid_level >= (num_grids * 0.6):
            # Check if we have positions to take profit on
            for position in existing_positions:
                entry_price = position.get('entry_price', 0)
                profit_pct = (current_price - entry_price) / entry_price
                
                if profit_pct >= take_profit_pct:
                    return {
                        "action": "trade",
                        "side": "sell",
                        "symbol": strategy.get('symbol'),
                        "size": position.get('size'),
                        "price": current_price,
                        "strategy": strategy.get('name'),
                        "grid_level": grid_level,
                        "profit_pct": profit_pct * 100
                    }
        
        return {"action": "hold"}
    
    def execute_short_grid(self, strategy: Dict, grid_level: int, num_grids: int,
                           current_price: float, existing_positions: list, wallet) -> Dict:
        """
        Short Grid: Sell at higher levels, buy back at lower levels
        For bearish market conditions
        """
        
        amount_per_grid = strategy.get('amount_per_grid', 10)
        take_profit_pct = strategy.get('take_profit', 0.5) / 100
        
        # Sell zone: top 60% of grid
        if grid_level >= (num_grids * 0.4):
            # Check if we can short (or sell spot holdings)
            if len(existing_positions) == 0 and wallet.get_balance() >= amount_per_grid:
                return {
                    "action": "trade",
                    "side": "sell",
                    "symbol": strategy.get('symbol'),
                    "size": amount_per_grid,
                    "price": current_price,
                    "strategy": strategy.get('name'),
                    "grid_level": grid_level
                }
        
        # Buy back zone: bottom 40% of grid
        elif grid_level < (num_grids * 0.4):
            # Check if we have short positions to cover
            for position in existing_positions:
                if position.get('side') == 'sell':
                    entry_price = position.get('entry_price', 0)
                    profit_pct = (entry_price - current_price) / entry_price
                    
                    if profit_pct >= take_profit_pct:
                        return {
                            "action": "trade",
                            "side": "buy",
                            "symbol": strategy.get('symbol'),
                            "size": position.get('size'),
                            "price": current_price,
                            "strategy": strategy.get('name'),
                            "grid_level": grid_level,
                            "profit_pct": profit_pct * 100
                        }
        
        return {"action": "hold"}
    
    def execute_neutral_grid(self, strategy: Dict, grid_level: int, num_grids: int,
                            current_price: float, existing_positions: list,
                            wallet, market_conditions: Dict) -> Dict:
        """
        Neutral Grid: Profit from volatility in both directions
        Buy low, sell high regardless of trend
        """
        
        amount_per_grid = strategy.get('amount_per_grid', 10)
        
        # Calculate distance from grid levels
        price_range = strategy.get('range', [])
        grid_size = (price_range[1] - price_range[0]) / num_grids
        
        lower_level = price_range[0] + (grid_level * grid_size)
        upper_level = lower_level + grid_size
        
        # Buy at lower end of current grid level
        price_in_grid = (current_price - lower_level) / grid_size
        
        if price_in_grid < 0.3:  # Bottom 30% of grid level
            if wallet.get_balance() >= amount_per_grid:
                return {
                    "action": "trade",
                    "side": "buy",
                    "symbol": strategy.get('symbol'),
                    "size": amount_per_grid,
                    "price": current_price,
                    "strategy": strategy.get('name'),
                    "grid_level": grid_level
                }
        
        # Sell at upper end of current grid level
        elif price_in_grid > 0.7:  # Top 30% of grid level
            # Find a buy position to sell
            for position in existing_positions:
                if position.get('side') == 'buy' and position.get('grid_level', -1) < grid_level:
                    return {
                        "action": "trade",
                        "side": "sell",
                        "symbol": strategy.get('symbol'),
                        "size": position.get('size'),
                        "price": current_price,
                        "strategy": strategy.get('name'),
                        "grid_level": grid_level
                    }
        
        return {"action": "hold"}
    
    def get_current_price(self, symbol: str) -> Optional[float]:
        """
        Get current price for symbol
        In production, this would call exchange API
        For now, returns mock price
        """
        
        # Mock prices - replace with actual API calls
        mock_prices = {
            "BTC/USDT": 67000,
            "ETH/USDT": 3200,
            "SOL/USDT": 145,
            "ARB/USDT": 1.15,
            "AVAX/USDT": 38
        }
        
        return mock_prices.get(symbol)
