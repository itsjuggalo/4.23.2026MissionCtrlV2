#!/usr/bin/env python3
"""Coinbase CDP holdings fetcher with real USD spot prices"""
import os, sys, json, time, base64, secrets, concurrent.futures
from cryptography.hazmat.primitives.asymmetric.ec import ECDSA
from cryptography.hazmat.primitives.hashes import SHA256
from cryptography.hazmat.primitives.serialization import load_pem_private_key
import urllib.request, urllib.error

api_key_name = os.environ.get('COINBASE_API_KEY', '')
if not api_key_name:
    try:
        api_key_name = open(os.path.expanduser('~/.openclaw/secrets/coinbase-api-key.txt')).read().strip()
    except: pass

pem_path = os.path.expanduser('~/.openclaw/secrets/coinbase-private.pem')

def make_jwt(api_key_name, private_key, method, path):
    host = 'api.coinbase.com'
    uri = f'{method} {host}{path}'
    now = int(time.time())
    nonce = secrets.token_hex(16)
    header = base64.urlsafe_b64encode(json.dumps({'alg':'ES256','kid':api_key_name,'nonce':nonce}).encode()).rstrip(b'=').decode()
    payload = base64.urlsafe_b64encode(json.dumps({'sub':api_key_name,'iss':'cdp','nbf':now,'exp':now+120,'uri':uri}).encode()).rstrip(b'=').decode()
    sig_input = f'{header}.{payload}'
    sig_der = private_key.sign(sig_input.encode(), ECDSA(SHA256()))
    idx = 3; r_len = sig_der[idx]; idx += 1
    r = sig_der[idx:idx+r_len]; idx += r_len + 1
    s_len = sig_der[idx]; idx += 1
    s = sig_der[idx:idx+s_len]
    def pad32(b): return (b'\x00'*(32-len(b)) + b)[-32:] if len(b) <= 32 else b[-32:]
    sig_b64 = base64.urlsafe_b64encode(pad32(r) + pad32(s)).rstrip(b'=').decode()
    return f'{sig_input}.{sig_b64}'

def get_spot_price(currency):
    """Fetch spot price using public Coinbase v2 API"""
    if currency in ('USD', 'USDC', 'USDT'):
        return 1.0
    try:
        req = urllib.request.Request(f'https://api.coinbase.com/v2/prices/{currency}-USD/spot')
        req.add_header('CB-VERSION', '2016-02-18')
        with urllib.request.urlopen(req, timeout=5) as r:
            return float(json.loads(r.read())['data']['amount'])
    except:
        return 0.0

try:
    if not api_key_name:
        raise Exception('COINBASE_API_KEY not set')

    pem = open(pem_path, 'rb').read()
    private_key = load_pem_private_key(pem, password=None)

    jwt = make_jwt(api_key_name, private_key, 'GET', '/api/v3/brokerage/accounts')
    req = urllib.request.Request(
        'https://api.coinbase.com/api/v3/brokerage/accounts',
        headers={'Authorization': f'Bearer {jwt}', 'Content-Type': 'application/json'}
    )
    with urllib.request.urlopen(req, timeout=10) as r:
        data = json.loads(r.read().decode())

    accounts = data.get('accounts', [])

    # Filter non-zero, skip dead/staked tokens
    nonzero = [(a['currency'], float(a['available_balance']['value']) + float(a['hold']['value']))
               for a in accounts
               if float(a['available_balance']['value']) + float(a['hold']['value']) > 0.000001
               and a.get('ready', True)
               and a['currency'] not in ('ETH2', 'BSV')]

    # Fetch all prices in parallel
    currencies = list(set(c for c, _ in nonzero))
    with concurrent.futures.ThreadPoolExecutor(max_workers=10) as ex:
        price_map = dict(zip(currencies, ex.map(get_spot_price, currencies)))

    result_accounts = []
    total_usd = 0.0

    for currency, amount in nonzero:
        price = price_map.get(currency, 0.0)
        value_usd = round(amount * price, 2)
        total_usd += value_usd
        result_accounts.append({
            'currency': currency,
            'available_balance': {'value': str(amount), 'currency': currency},
            'hold': {'value': '0', 'currency': currency},
            'value_usd': value_usd,
            'price_usd': price
        })

    result_accounts.sort(key=lambda x: -x['value_usd'])

    print(json.dumps({'accounts': result_accounts, 'total_usd': round(total_usd, 2)}))

except urllib.error.HTTPError as e:
    print(json.dumps({'error': f'HTTP {e.code}: {e.read().decode()[:300]}'}))
except Exception as ex:
    print(json.dumps({'error': str(ex)}))
