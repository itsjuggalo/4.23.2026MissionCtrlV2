#!/usr/bin/env python3
"""
Options Engine — yfinance + Black-Scholes + Greeks
Usage: python3 options_engine.py <TICKER> [expiry_index]
Returns JSON with full options chain, Greeks, IV smile data, payoff data
"""
import sys
import json
import math
import numpy as np
from scipy.stats import norm
from scipy.optimize import brentq
import yfinance as yf
from datetime import datetime, date

def black_scholes(S, K, T, r, sigma, option_type='call'):
    """Black-Scholes price"""
    if T <= 0 or sigma <= 0:
        intrinsic = max(0, S - K) if option_type == 'call' else max(0, K - S)
        return intrinsic
    d1 = (math.log(S / K) + (r + 0.5 * sigma**2) * T) / (sigma * math.sqrt(T))
    d2 = d1 - sigma * math.sqrt(T)
    if option_type == 'call':
        return S * norm.cdf(d1) - K * math.exp(-r * T) * norm.cdf(d2)
    else:
        return K * math.exp(-r * T) * norm.cdf(-d2) - S * norm.cdf(-d1)

def greeks(S, K, T, r, sigma, option_type='call'):
    """Calculate all Greeks"""
    if T <= 0 or sigma <= 0:
        return {'delta': 0, 'gamma': 0, 'theta': 0, 'vega': 0, 'rho': 0}
    d1 = (math.log(S / K) + (r + 0.5 * sigma**2) * T) / (sigma * math.sqrt(T))
    d2 = d1 - sigma * math.sqrt(T)
    nd1 = norm.pdf(d1)
    
    gamma = nd1 / (S * sigma * math.sqrt(T))
    vega = S * nd1 * math.sqrt(T) / 100  # per 1% vol change
    
    if option_type == 'call':
        delta = norm.cdf(d1)
        theta = (-(S * nd1 * sigma) / (2 * math.sqrt(T)) - r * K * math.exp(-r * T) * norm.cdf(d2)) / 365
        rho = K * T * math.exp(-r * T) * norm.cdf(d2) / 100
    else:
        delta = norm.cdf(d1) - 1
        theta = (-(S * nd1 * sigma) / (2 * math.sqrt(T)) + r * K * math.exp(-r * T) * norm.cdf(-d2)) / 365
        rho = -K * T * math.exp(-r * T) * norm.cdf(-d2) / 100

    return {
        'delta': round(delta, 4),
        'gamma': round(gamma, 4),
        'theta': round(theta, 4),
        'vega': round(vega, 4),
        'rho': round(rho, 4),
    }

def implied_vol(market_price, S, K, T, r, option_type='call'):
    """Calculate implied volatility via Brent's method"""
    if T <= 0 or market_price <= 0:
        return None
    intrinsic = max(0, S - K) if option_type == 'call' else max(0, K - S)
    if market_price <= intrinsic:
        return None
    try:
        iv = brentq(
            lambda sigma: black_scholes(S, K, T, r, sigma, option_type) - market_price,
            1e-6, 10.0, maxiter=100, xtol=1e-6
        )
        return round(iv, 4)
    except Exception:
        return None

def days_to_expiry(expiry_str):
    """Days from today to expiry"""
    exp = datetime.strptime(expiry_str, '%Y-%m-%d').date()
    delta = (exp - date.today()).days
    return max(delta, 0)

def process_chain(df, S, T, r, option_type):
    """Process an options chain dataframe"""
    rows = []
    for _, row in df.iterrows():
        K = float(row.get('strike', 0))
        if K <= 0:
            continue
        
        def safe_float(v, default=0.0):
            try:
                f = float(v)
                return default if math.isnan(f) or math.isinf(f) else f
            except (TypeError, ValueError):
                return default
        def safe_int(v, default=0):
            try:
                f = float(v)
                return default if math.isnan(f) else int(f)
            except (TypeError, ValueError):
                return default

        bid = safe_float(row.get('bid'))
        ask = safe_float(row.get('ask'))
        last = safe_float(row.get('lastPrice'))
        volume = safe_int(row.get('volume'))
        oi = safe_int(row.get('openInterest'))
        iv_raw = safe_float(row.get('impliedVolatility'))
        
        mid = (bid + ask) / 2 if bid > 0 and ask > 0 else last
        
        # Use yfinance IV or recalculate
        iv = iv_raw if iv_raw > 0 else (implied_vol(mid, S, K, T, r, option_type) or 0)
        
        # BS theoretical price
        bs_price = black_scholes(S, K, T, r, iv if iv > 0 else 0.3, option_type) if T > 0 else 0
        
        # Greeks
        g = greeks(S, K, T, r, iv if iv > 0 else 0.3, option_type)
        
        moneyness = 'ATM' if abs(K - S) / S < 0.01 else ('ITM' if (option_type == 'call' and K < S) or (option_type == 'put' and K > S) else 'OTM')
        
        rows.append({
            'strike': K,
            'bid': round(bid, 2),
            'ask': round(ask, 2),
            'last': round(last, 2),
            'mid': round(mid, 2),
            'iv': round(iv * 100, 2),  # as %
            'volume': volume,
            'openInterest': oi,
            'bsPrice': round(bs_price, 2),
            'moneyness': moneyness,
            **g,
        })
    return rows

def payoff_data(S, K, premium, option_type, strategy='long'):
    """Generate P&L payoff curve data"""
    prices = np.linspace(S * 0.5, S * 1.5, 100).tolist()
    payoffs = []
    for price in prices:
        if option_type == 'call':
            intrinsic = max(0, price - K)
        else:
            intrinsic = max(0, K - price)
        
        if strategy == 'long':
            pnl = intrinsic - premium
        else:  # short
            pnl = premium - intrinsic
        payoffs.append(round(pnl, 2))
    
    return {
        'prices': [round(p, 2) for p in prices],
        'payoffs': payoffs,
        'breakeven': round(K + premium if option_type == 'call' else K - premium, 2),
        'maxLoss': round(-premium, 2) if strategy == 'long' else None,
        'maxGain': round(premium, 2) if strategy == 'short' else None,
        'currentPrice': S,
        'strike': K,
    }

def main():
    if len(sys.argv) < 2:
        print(json.dumps({'error': 'Usage: options_engine.py <TICKER> [expiry_index]'}))
        sys.exit(1)
    
    ticker_sym = sys.argv[1].upper()
    expiry_idx = int(sys.argv[2]) if len(sys.argv) > 2 else 0
    
    r = 0.053  # risk-free rate (approx 5.3% fed funds)
    
    try:
        ticker = yf.Ticker(ticker_sym)
        info = ticker.info
        S = info.get('currentPrice') or info.get('regularMarketPrice') or info.get('ask', 0)
        
        if not S:
            hist = ticker.history(period='1d')
            S = float(hist['Close'].iloc[-1]) if not hist.empty else 0
        
        if not S:
            print(json.dumps({'error': f'Could not get price for {ticker_sym}'}))
            sys.exit(1)
        
        S = float(S)
        
        # Get expiry dates
        expirations = ticker.options
        if not expirations:
            print(json.dumps({'error': f'No options found for {ticker_sym}'}))
            sys.exit(1)
        
        expiry_idx = min(expiry_idx, len(expirations) - 1)
        expiry = expirations[expiry_idx]
        
        days = days_to_expiry(expiry)
        T = days / 365.0
        
        # Fetch chain
        chain = ticker.option_chain(expiry)
        
        calls = process_chain(chain.calls, S, T, r, 'call')
        puts = process_chain(chain.puts, S, T, r, 'put')
        
        # IV smile data — use strikes near ATM
        smile_calls = [{'strike': c['strike'], 'iv': c['iv'], 'type': 'call'} for c in calls if c['iv'] > 0]
        smile_puts = [{'strike': p['strike'], 'iv': p['iv'], 'type': 'put'} for p in puts if p['iv'] > 0]
        smile_data = sorted(smile_calls + smile_puts, key=lambda x: x['strike'])
        
        # ATM options for payoff demo
        atm_call = min(calls, key=lambda c: abs(c['strike'] - S)) if calls else None
        atm_put = min(puts, key=lambda p: abs(p['strike'] - S)) if puts else None
        
        payoff_call = payoff_data(S, atm_call['strike'], atm_call['mid'] or atm_call['last'], 'call') if atm_call else None
        payoff_put = payoff_data(S, atm_put['strike'], atm_put['mid'] or atm_put['last'], 'put') if atm_put else None
        
        result = {
            'ticker': ticker_sym,
            'price': round(S, 2),
            'expiry': expiry,
            'daysToExpiry': days,
            'expirations': list(expirations),
            'selectedExpiryIndex': expiry_idx,
            'calls': calls,
            'puts': puts,
            'smileData': smile_data,
            'payoff': {
                'call': payoff_call,
                'put': payoff_put,
            },
            'companyName': info.get('longName', ticker_sym),
            'sector': info.get('sector', ''),
        }
        
        print(json.dumps(result))
        
    except Exception as e:
        print(json.dumps({'error': str(e)}))
        sys.exit(1)

if __name__ == '__main__':
    main()
