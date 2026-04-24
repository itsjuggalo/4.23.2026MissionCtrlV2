#!/usr/bin/env python3
"""
Technical Analysis Engine
Pulls OHLCV + calculates RSI, MACD, Bollinger Bands, EMA/SMA, support/resistance,
volume analysis, trend strength, and generates a structured TA summary for AI.
Usage: python3 ta_engine.py <TICKER>
"""
import sys, json, math, warnings
warnings.filterwarnings('ignore')
import numpy as np
import yfinance as yf
from datetime import datetime, timedelta

def safe(v, decimals=2):
    try:
        f = float(v)
        return round(f, decimals) if not (math.isnan(f) or math.isinf(f)) else None
    except:
        return None

def rsi(closes, period=14):
    if len(closes) < period + 1:
        return None
    deltas = np.diff(closes)
    gains = np.where(deltas > 0, deltas, 0)
    losses = np.where(deltas < 0, -deltas, 0)
    avg_gain = np.mean(gains[:period])
    avg_loss = np.mean(losses[:period])
    for i in range(period, len(gains)):
        avg_gain = (avg_gain * (period - 1) + gains[i]) / period
        avg_loss = (avg_loss * (period - 1) + losses[i]) / period
    if avg_loss == 0:
        return 100.0
    rs = avg_gain / avg_loss
    return round(100 - (100 / (1 + rs)), 2)

def ema(data, period):
    if len(data) < period:
        return None
    k = 2 / (period + 1)
    result = float(np.mean(data[:period]))
    for price in data[period:]:
        result = price * k + result * (1 - k)
    return round(result, 2)

def sma(data, period):
    if len(data) < period:
        return None
    return round(float(np.mean(data[-period:])), 2)

def macd(closes):
    if len(closes) < 26:
        return None, None, None
    ema12 = ema(closes, 12)
    ema26 = ema(closes, 26)
    if ema12 is None or ema26 is None:
        return None, None, None
    macd_line = round(ema12 - ema26, 4)
    # Signal: 9-period EMA of MACD values
    macd_series = []
    for i in range(26, len(closes) + 1):
        e12 = ema(closes[:i], 12)
        e26 = ema(closes[:i], 26)
        if e12 and e26:
            macd_series.append(e12 - e26)
    signal = ema(macd_series, 9)
    hist = round(macd_line - signal, 4) if signal else None
    return macd_line, signal, hist

def bollinger(closes, period=20, std_dev=2):
    if len(closes) < period:
        return None, None, None
    recent = closes[-period:]
    mid = float(np.mean(recent))
    std = float(np.std(recent))
    upper = round(mid + std_dev * std, 2)
    lower = round(mid - std_dev * std, 2)
    return round(mid, 2), upper, lower

def support_resistance(highs, lows, closes, lookback=20):
    """Find key S/R levels using recent pivots"""
    recent_high = float(np.max(highs[-lookback:]))
    recent_low = float(np.min(lows[-lookback:]))
    current = closes[-1]
    
    # Simple pivot points
    levels = sorted(set([
        round(recent_high, 2),
        round(recent_low, 2),
        round(float(np.mean(closes[-lookback:])), 2),
        round(float(np.percentile(closes[-lookback:], 75)), 2),
        round(float(np.percentile(closes[-lookback:], 25)), 2),
    ]))
    
    supports = [l for l in levels if l < current]
    resistances = [l for l in levels if l > current]
    
    return {
        'supports': supports[-3:] if supports else [],
        'resistances': resistances[:3] if resistances else [],
        '52wHigh': round(float(np.max(highs[-252:])) if len(highs) >= 252 else float(np.max(highs)), 2),
        '52wLow': round(float(np.min(lows[-252:])) if len(lows) >= 252 else float(np.min(lows)), 2),
    }

def trend_strength(closes, short=10, long=50):
    """ADX-lite: measure trend direction and strength"""
    if len(closes) < long:
        return None, None
    s = sma(list(closes), short)
    l = sma(list(closes), long)
    if not s or not l:
        return None, None
    direction = 'UPTREND' if s > l else 'DOWNTREND'
    pct_diff = abs((s - l) / l * 100)
    strength = 'STRONG' if pct_diff > 3 else 'MODERATE' if pct_diff > 1 else 'WEAK'
    return direction, strength

def volume_analysis(volumes, closes):
    """Analyze volume relative to average, detect climax/dry-up"""
    avg_vol = float(np.mean(volumes[-20:]))
    cur_vol = float(volumes[-1])
    vol_ratio = cur_vol / avg_vol if avg_vol > 0 else 1
    
    price_change = (closes[-1] - closes[-2]) / closes[-2] * 100 if len(closes) >= 2 else 0
    
    signal = 'NORMAL'
    if vol_ratio > 2 and price_change > 1:
        signal = 'BULLISH_SURGE'
    elif vol_ratio > 2 and price_change < -1:
        signal = 'BEARISH_SURGE'
    elif vol_ratio < 0.5:
        signal = 'LOW_VOLUME'
    
    return {
        'current': int(cur_vol),
        'avg20': int(avg_vol),
        'ratio': round(vol_ratio, 2),
        'signal': signal,
    }

def price_targets(current, sr_levels, indicators):
    """Generate price targets based on TA"""
    resistances = sr_levels.get('resistances', [])
    supports = sr_levels.get('supports', [])
    
    bull_targets = []
    bear_targets = []
    
    # Use resistance levels as bull targets
    for r in resistances[:3]:
        pct = round((r - current) / current * 100, 1)
        bull_targets.append({'price': r, 'pct': pct, 'basis': 'resistance'})
    
    # Use support levels as bear targets
    for s in reversed(supports[-3:]):
        pct = round((s - current) / current * 100, 1)
        bear_targets.append({'price': s, 'pct': pct, 'basis': 'support'})
    
    # Add MA-based targets
    for key, label in [('ema20', 'EMA20'), ('sma50', 'SMA50'), ('sma200', 'SMA200')]:
        v = indicators.get(key)
        if v and v != current:
            pct = round((v - current) / current * 100, 1)
            target = {'price': v, 'pct': pct, 'basis': label}
            if v > current:
                bull_targets.append(target)
            else:
                bear_targets.append(target)
    
    bull_targets.sort(key=lambda x: x['price'])
    bear_targets.sort(key=lambda x: x['price'], reverse=True)
    
    return bull_targets[:4], bear_targets[:4]

def get_news_headlines(ticker_sym):
    """Get recent news from yfinance"""
    try:
        t = yf.Ticker(ticker_sym)
        news = t.news or []
        headlines = []
        for item in news[:8]:
            content = item.get('content', {})
            title = content.get('title') or item.get('title', '')
            if title:
                ts = content.get('pubDate') or item.get('providerPublishTime', '')
                headlines.append({'title': title, 'published': str(ts)[:10]})
        return headlines
    except:
        return []

def main():
    if len(sys.argv) < 2:
        print(json.dumps({'error': 'Usage: ta_engine.py <TICKER>'}))
        sys.exit(1)
    
    sym = sys.argv[1].upper()
    
    try:
        ticker = yf.Ticker(sym)
        hist = ticker.history(period='1y')
        
        if hist.empty or len(hist) < 30:
            print(json.dumps({'error': f'Insufficient data for {sym}'}))
            sys.exit(1)
        
        closes = hist['Close'].values.astype(float)
        opens  = hist['Open'].values.astype(float)
        highs  = hist['High'].values.astype(float)
        lows   = hist['Low'].values.astype(float)
        vols   = hist['Volume'].values.astype(float)
        
        current = closes[-1]
        prev    = closes[-2]
        change  = round((current - prev) / prev * 100, 2)
        
        # Moving averages
        indicators = {
            'current': round(current, 2),
            'change1d': change,
            'ema9':   ema(list(closes), 9),
            'ema20':  ema(list(closes), 20),
            'ema50':  ema(list(closes), 50),
            'sma20':  sma(list(closes), 20),
            'sma50':  sma(list(closes), 50),
            'sma200': sma(list(closes), 200),
        }
        
        # Momentum
        rsi14   = rsi(closes, 14)
        rsi7    = rsi(closes, 7)
        macd_l, macd_s, macd_h = macd(list(closes))
        bb_mid, bb_upper, bb_lower = bollinger(list(closes))
        
        indicators.update({
            'rsi14': rsi14,
            'rsi7':  rsi7,
            'macd':  {'line': macd_l, 'signal': macd_s, 'histogram': macd_h} if macd_l else None,
            'bollinger': {'mid': bb_mid, 'upper': bb_upper, 'lower': bb_lower} if bb_mid else None,
        })
        
        # Price position relative to MAs
        above_ema20  = current > indicators['ema20'] if indicators['ema20'] else None
        above_sma50  = current > indicators['sma50'] if indicators['sma50'] else None
        above_sma200 = current > indicators['sma200'] if indicators['sma200'] else None
        
        # Trend
        direction, strength = trend_strength(closes)
        
        # S/R levels
        sr = support_resistance(highs, lows, closes)
        
        # Volume
        vol_data = volume_analysis(vols, closes)
        
        # Price targets
        bull_targets, bear_targets = price_targets(current, sr, indicators)
        
        # Momentum signals
        signals = []
        if rsi14:
            if rsi14 > 70:   signals.append('OVERBOUGHT (RSI>70)')
            elif rsi14 < 30: signals.append('OVERSOLD (RSI<30)')
            elif rsi14 > 60: signals.append('Bullish momentum (RSI 60-70)')
            elif rsi14 < 40: signals.append('Bearish momentum (RSI 30-40)')
        
        if macd_h:
            if macd_h > 0:  signals.append('MACD bullish (histogram positive)')
            else:           signals.append('MACD bearish (histogram negative)')
        
        if bb_upper and bb_lower:
            bb_pct = (current - bb_lower) / (bb_upper - bb_lower) * 100 if bb_upper != bb_lower else 50
            if bb_pct > 90:   signals.append('Near Bollinger upper band (overbought)')
            elif bb_pct < 10: signals.append('Near Bollinger lower band (oversold)')
            indicators['bb_position_pct'] = round(bb_pct, 1)
        
        if above_ema20 is not None:
            signals.append(f'{"Above" if above_ema20 else "Below"} EMA20')
        if above_sma50 is not None:
            signals.append(f'{"Above" if above_sma50 else "Below"} SMA50')
        if above_sma200 is not None:
            signals.append(f'{"Above" if above_sma200 else "Below"} SMA200 ({"bull" if above_sma200 else "bear"} market structure)')
        
        if direction:
            signals.append(f'{direction} — {strength}')
        
        # Recent performance
        perf = {}
        for label, days in [('1d', 1), ('5d', 5), ('1m', 21), ('3m', 63)]:
            if len(closes) > days:
                perf[label] = round((closes[-1] - closes[-1-days]) / closes[-1-days] * 100, 2)
        
        # News
        news = get_news_headlines(sym)
        
        # Company info
        info = {}
        try:
            raw = ticker.info
            info = {
                'name': raw.get('longName', sym),
                'sector': raw.get('sector', ''),
                'marketCap': raw.get('marketCap'),
                'pe': safe(raw.get('trailingPE')),
                'eps': safe(raw.get('trailingEps')),
                'beta': safe(raw.get('beta')),
                'earningsDate': str(raw.get('earningsTimestamp', '')),
                'analystTargetMean': safe(raw.get('targetMeanPrice')),
                'analystTargetHigh': safe(raw.get('targetHighPrice')),
                'analystTargetLow': safe(raw.get('targetLowPrice')),
                'recommendationMean': safe(raw.get('recommendationMean')),
            }
        except:
            pass
        
        result = {
            'ticker': sym,
            'indicators': indicators,
            'signals': signals,
            'trend': {'direction': direction, 'strength': strength},
            'supportResistance': sr,
            'volume': vol_data,
            'performance': perf,
            'priceTargets': {
                'bullish': bull_targets,
                'bearish': bear_targets,
            },
            'news': news,
            'companyInfo': info,
            'generatedAt': datetime.utcnow().isoformat(),
        }
        
        print(json.dumps(result))
        
    except Exception as e:
        print(json.dumps({'error': str(e)}))
        sys.exit(1)

if __name__ == '__main__':
    main()
