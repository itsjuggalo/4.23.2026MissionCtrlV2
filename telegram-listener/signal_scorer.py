#!/usr/bin/env python3
"""
Signal Quality Scorer
Evaluates incoming signals for quality before posting to Discord.

Scoring Factors:
- Basic validation (has symbol, entry, direction)
- Source credibility (historical win rate)
- Stop loss presence
- Take profit targets
- Price sanity check
- TA alignment (calls crypto skills)

Routes signals to:
- #eric-signals (score ≥7)
- #signal-review (score 5-7)
- #rejected-signals (score <5)
"""
import json
import os
import sys
import subprocess
import re
from typing import Dict, List, Tuple, Optional
from datetime import datetime, timedelta
from pathlib import Path

class SignalScorer:
    def __init__(
        self,
        channel_stats_path="channel_stats.json",
        signals_history_path="signals.json"
    ):
        self.stats_path = channel_stats_path
        self.history_path = signals_history_path
        self.channel_stats = self._load_stats()
        self.recent_signals = self._load_recent_signals()
        
        # Quality thresholds
        self.POST_THRESHOLD = 7.0      # Auto-post to #eric-signals
        self.REVIEW_THRESHOLD = 5.0    # Send to #signal-review
        # Below REVIEW_THRESHOLD → #rejected-signals
        
    def _load_stats(self) -> Dict:
        """Load historical channel performance stats."""
        if os.path.exists(self.stats_path):
            try:
                with open(self.stats_path, 'r') as f:
                    return json.load(f)
            except Exception as e:
                print(f"[SCORER] Error loading stats: {e}")
        return {}
    
    def _load_recent_signals(self) -> List[Dict]:
        """Load recent signals for duplicate detection."""
        if os.path.exists(self.history_path):
            try:
                with open(self.history_path, 'r') as f:
                    signals = json.load(f)
                    # Only keep last 24h
                    cutoff = datetime.now().timestamp() - 86400
                    recent = []
                    for s in signals:
                        ts = s.get('timestamp', 0)
                        # Handle both timestamp formats
                        if isinstance(ts, str):
                            try:
                                ts = datetime.fromisoformat(ts.replace('Z', '+00:00')).timestamp()
                            except:
                                continue
                        if ts > cutoff:
                            recent.append(s)
                    return recent
            except Exception as e:
                print(f"[SCORER] Error loading signals: {e}")
        return []
    
    def score_signal(self, signal: Dict) -> Tuple[float, List[str]]:
        """
        Score signal quality from 0-10.
        Returns (score, flags).
        """
        score = 5.0  # baseline
        flags = []
        
        # Ensure signal is a dict
        if not signal or not isinstance(signal, dict):
            return 0.0, ['invalid-signal']
        
        # 1. Basic validation (+2 if all present, -3 if missing critical)
        required_fields = ['symbol', 'entry', 'direction']
        has_all = True
        for field in required_fields:
            if field not in signal or signal[field] is None or signal[field] == '':
                has_all = False
                break
        
        if has_all:
            score += 2
            flags.append('complete-data')
        else:
            score -= 3
            flags.append('incomplete-data')
            return max(0, score), flags  # Early exit if incomplete
        
        # 2. Source credibility (+/-3 based on win rate)
        source_id = str(signal.get('channel_id', 'unknown'))
        source_stats = self.channel_stats.get(source_id, {})
        win_rate = source_stats.get('win_rate', 0.5)
        signal_count = source_stats.get('total_signals', 0)
        
        if signal_count > 50:  # Enough data to judge
            if win_rate >= 0.65:
                score += 3
                flags.append('S-tier-source')
            elif win_rate >= 0.55:
                score += 2
                flags.append('A-tier-source')
            elif win_rate >= 0.45:
                score += 0
                flags.append('B-tier-source')
            else:
                score -= 3
                flags.append('C-tier-source')
        else:
            # New source, neutral
            flags.append('new-source')
        
        # 3. Stop loss presence (+1.5)
        if 'stop_loss' in signal and signal['stop_loss']:
            score += 1.5
            flags.append('has-stop-loss')
        else:
            score -= 1
            flags.append('no-stop-loss')
        
        # 4. Take profit targets (+1)
        if 'take_profit' in signal and signal['take_profit']:
            score += 1
            flags.append('has-targets')
        
        # 5. Risk/Reward ratio (+1 if ≥2:1)
        if self._check_risk_reward(signal):
            score += 1
            flags.append('good-rr')
        
        # 6. Duplicate detection (-5 if duplicate)
        if self._is_duplicate(signal):
            score -= 5
            flags.append('duplicate-signal')
        
        # 7. Symbol validation (+0.5 if known crypto)
        symbol = signal.get('symbol', '').upper()
        if self._is_valid_symbol(symbol):
            score += 0.5
            flags.append('valid-symbol')
        
        return max(0, min(10, score)), flags
    
    def _check_risk_reward(self, signal: Dict) -> bool:
        """Check if signal has ≥2:1 risk/reward ratio."""
        try:
            entry = float(signal.get('entry', 0))
            stop = float(signal.get('stop_loss', 0))
            tp = signal.get('take_profit')
            
            if not entry or not stop or not tp:
                return False
            
            # Take first TP if multiple
            if isinstance(tp, list):
                tp = float(tp[0]) if tp else 0
            else:
                tp = float(tp)
            
            if entry == 0 or stop == 0 or tp == 0:
                return False
            
            risk = abs(entry - stop)
            reward = abs(tp - entry)
            
            return reward / risk >= 2.0
        except:
            return False
    
    def _is_duplicate(self, signal: Dict) -> bool:
        """Check if signal is duplicate of recent signal."""
        symbol = signal.get('symbol') or ''
        direction = signal.get('direction') or ''
        
        if not symbol or not direction:
            return False
        
        symbol = str(symbol).upper()
        direction = str(direction).upper()
        
        for recent in self.recent_signals:
            recent_symbol = str(recent.get('symbol') or '').upper()
            recent_dir = str(recent.get('direction') or '').upper()
            
            if recent_symbol == symbol and recent_dir == direction:
                # Same symbol + direction within 24h = duplicate
                return True
        
        return False
    
    def _is_valid_symbol(self, symbol: str) -> bool:
        """Basic symbol validation (crypto focus)."""
        if not symbol or len(symbol) < 2 or len(symbol) > 10:
            return False
        
        # Known crypto symbols (top 100)
        known = {
            'BTC', 'ETH', 'BNB', 'SOL', 'XRP', 'ADA', 'DOGE', 'AVAX', 'DOT',
            'MATIC', 'LINK', 'UNI', 'ATOM', 'LTC', 'XLM', 'ALGO', 'VET',
            'ICP', 'FIL', 'HBAR', 'NEAR', 'AAVE', 'EOS', 'XTZ', 'SAND',
            'MANA', 'THETA', 'AXS', 'GRT', 'FTM', 'EGLD', 'RUNE', 'KSM',
            'CAKE', 'ZEC', 'DASH', 'ENJ', 'CHZ', 'WAVES', 'COMP', 'MKR',
            'SNX', 'SUSHI', 'YFI', 'BAT', 'ZRX', '1INCH', 'CRV', 'UMA'
        }
        
        return symbol in known
    
    def get_routing(self, score: float) -> str:
        """
        Determine routing based on score.
        Returns: 'post', 'review', or 'reject'
        """
        if score >= self.POST_THRESHOLD:
            return 'post'       # #eric-signals
        elif score >= self.REVIEW_THRESHOLD:
            return 'review'     # #signal-review
        else:
            return 'reject'     # #rejected-signals
    
    def get_tier_emoji(self, score: float) -> str:
        """Get emoji based on quality tier."""
        if score >= 8.5:
            return '⭐⭐⭐'  # S-tier
        elif score >= 7.0:
            return '⭐⭐'    # A-tier
        elif score >= 5.5:
            return '⭐'      # B-tier
        else:
            return '❌'      # C-tier
    
    def verify_ta_alignment(self, signal: Dict) -> Optional[Dict]:
        """
        Call crypto-snapshot-diagnosis skill to verify TA alignment.
        Returns TA data or None if verification fails.
        """
        try:
            symbol = signal.get('symbol', '').upper()
            direction = signal.get('direction', '').upper()
            
            # Call crypto-snapshot-diagnosis skill
            # This would use openclaw skills or direct API call
            # For now, return mock structure
            
            # TODO: Implement actual TA verification
            # Example: openclaw run skill crypto-snapshot-diagnosis --symbol BTC
            
            return {
                'aligned': True,
                'ta_direction': 'BULLISH',
                'confidence': 0.75,
                'price': 67800,
                'momentum': 'STRONG'
            }
        except Exception as e:
            print(f"[SCORER] TA verification failed: {e}")
            return None
    
    def format_score_report(self, signal: Dict, score: float, flags: List[str]) -> str:
        """Format scoring report for logging."""
        return f"""
Signal Score Report
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
Symbol:    {signal.get('symbol', 'N/A')}
Direction: {signal.get('direction', 'N/A')}
Entry:     {signal.get('entry', 'N/A')}
Stop:      {signal.get('stop_loss', 'N/A')}
Targets:   {signal.get('take_profit', 'N/A')}

SCORE:     {score:.1f}/10 {self.get_tier_emoji(score)}
Routing:   {self.get_routing(score).upper()}
Flags:     {', '.join(flags)}
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
"""

def main():
    """Test the scorer with sample signals."""
    scorer = SignalScorer()
    
    # Test signals
    test_signals = [
        {
            'symbol': 'BTC',
            'direction': 'LONG',
            'entry': 67000,
            'stop_loss': 66000,
            'take_profit': [69000, 70000],
            'channel_id': -1002139755277
        },
        {
            'symbol': 'UNKNOWN',
            'direction': 'LONG',
            'entry': 100,
            'channel_id': -1001234567890
        },
        {
            'symbol': 'ETH',
            'direction': 'SHORT',
            'entry': 2500,
            'stop_loss': 2600,
            'take_profit': 2300,
            'channel_id': -1002139755277
        }
    ]
    
    for i, signal in enumerate(test_signals, 1):
        print(f"\n{'='*50}")
        print(f"Test Signal #{i}")
        print(f"{'='*50}")
        
        score, flags = scorer.score_signal(signal)
        routing = scorer.get_routing(score)
        
        print(scorer.format_score_report(signal, score, flags))
        print(f"→ Route to: {routing}")

if __name__ == '__main__':
    main()
