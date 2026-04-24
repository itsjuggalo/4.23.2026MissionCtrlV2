#!/usr/bin/env python3
"""Robinhood crypto holdings fetcher with live prices via CoinGecko"""
import base64, time, os, sys, json, urllib.request, urllib.error

api_key = os.environ.get('ROBINHOOD_API_KEY', '')
priv_path = os.path.expanduser('~/.openclaw/secrets/robinhood-private.b64')

COINGECKO_IDS = {
    'BTC': 'bitcoin', 'ETH': 'ethereum', 'SOL': 'solana',
    'HYPE': 'hyperliquid', 'USDC': 'usd-coin', 'USDT': 'tether',
    'DOGE': 'dogecoin', 'XRP': 'ripple', 'ADA': 'cardano',
    'AVAX': 'avalanche-2', 'MATIC': 'matic-network', 'LINK': 'chainlink',
    'DOT': 'polkadot', 'LTC': 'litecoin', 'BCH': 'bitcoin-cash',
    'UNI': 'uniswap', 'AAVE': 'aave', 'SHIB': 'shiba-inu',
}

def get_prices(symbols):
    prices = {}
    ids_needed = {s: COINGECKO_IDS[s] for s in symbols if s in COINGECKO_IDS}
    if not ids_needed:
        return prices
    ids_str = ','.join(ids_needed.values())
    try:
        req = urllib.request.Request(
            f'https://api.coingecko.com/api/v3/simple/price?ids={ids_str}&vs_currencies=usd',
            headers={'User-Agent': 'Mozilla/5.0'}
        )
        with urllib.request.urlopen(req, timeout=8) as r:
            data = json.loads(r.read())
        for symbol, cg_id in ids_needed.items():
            if cg_id in data:
                prices[symbol] = data[cg_id]['usd']
    except:
        pass
    return prices

try:
    from cryptography.hazmat.primitives.asymmetric.ed25519 import Ed25519PrivateKey
    if not api_key:
        raise Exception('ROBINHOOD_API_KEY not set')

    priv_b64 = open(priv_path).read().strip()
    private_key = Ed25519PrivateKey.from_private_bytes(base64.b64decode(priv_b64))

    timestamp = str(int(time.time()))
    path = '/api/v1/crypto/trading/holdings/'
    method = 'GET'
    message = api_key + timestamp + path + method
    signature = private_key.sign(message.encode('utf-8'))
    sig_b64 = base64.b64encode(signature).decode('utf-8')

    req = urllib.request.Request(
        f'https://trading.robinhood.com{path}',
        headers={
            'x-api-key': api_key,
            'x-timestamp': timestamp,
            'x-signature': sig_b64,
            'Content-Type': 'application/json',
        }
    )
    with urllib.request.urlopen(req, timeout=10) as r:
        data = json.loads(r.read().decode())

    results = data.get('results', [])

    # Get all symbols with non-zero quantity
    symbols = [h['asset_code'] for h in results if float(h.get('total_quantity', 0)) > 0]
    prices = get_prices(symbols)

    total_usd = 0.0
    enriched = []
    for h in results:
        qty = float(h.get('total_quantity', 0))
        if qty <= 0:
            continue
        symbol = h['asset_code']
        price = prices.get(symbol, 0.0)
        value_usd = round(qty * price, 2)
        total_usd += value_usd
        enriched.append({
            **h,
            'price_usd': price,
            'value_usd': value_usd,
        })

    enriched.sort(key=lambda x: -x['value_usd'])
    print(json.dumps({'results': enriched, 'total_usd': round(total_usd, 2)}))

except urllib.error.HTTPError as e:
    print(json.dumps({'error': f'HTTP {e.code}: {e.read().decode()[:200]}'}))
except Exception as ex:
    print(json.dumps({'error': str(ex)}))
