#!/usr/bin/env python3
"""Mission Control Brief Data Fetcher — Uses Alpaca, Kraken, CryptoCompare"""
import json, os, sys, time
from datetime import datetime, timezone, timedelta
try:
    import requests
except ImportError:
    import subprocess
    subprocess.check_call([sys.executable, '-m', 'pip', 'install', 'requests', '--break-system-packages', '-q'])
    import requests

sys.path.insert(0, os.path.expanduser('~/scripts'))
from lib.http_retry import requests_session
SESSION = requests_session()  # read-only fetcher: retries idempotent GETs (429/5xx/timeout)

SECRETS = '/home/ubuntu/.openclaw/secrets'
OUTPUT = '/home/ubuntu/.openclaw/workspace/directives/pre_brief_data.md'
OUTPUT_JSON = '/home/ubuntu/.openclaw/workspace/directives/pre_brief_data.json'

def read_secret(name):
    try: return open(f'{SECRETS}/{name}').read().strip()
    except: return ''

def get_edt_now():
    return datetime.now(timezone.utc) - timedelta(hours=4)

def get_market_sessions():
    now = get_edt_now()
    h = now.hour + now.minute / 60.0
    day = now.weekday()
    wd = day < 5
    s = {}
    if wd:
        s['NYSE'] = 'PREMARKET' if 4<=h<9.5 else 'OPEN' if 9.5<=h<16 else 'AFTER-HOURS' if 16<=h<20 else 'CLOSED'
    else:
        s['NYSE'] = 'WEEKEND'
    s['LONDON'] = 'OPEN' if wd and 3<=h<11.5 else ('WEEKEND' if not wd else 'CLOSED')
    tokyo_open = (h >= 20 or h < 2) and ((day < 4) or (day == 4 and h < 2) or (day == 6 and h >= 20))
    s['TOKYO'] = 'OPEN' if tokyo_open else 'CLOSED'
    hk_open = (h >= 21.5 or h < 4) and ((day < 4) or (day == 4 and h < 4) or (day == 6 and h >= 21.5))
    s['HONG_KONG'] = 'OPEN' if hk_open else 'CLOSED'
    s['MIDDLE_EAST'] = 'BUSINESS HOURS' if 0.5 <= h < 9.5 else 'OFF HOURS'
    s['CRYPTO'] = '24/7'
    return s

def fetch_alpaca():
    key, secret = read_secret('alpaca-key-id'), read_secret('alpaca-secret')
    if not key: return None
    try:
        hd = {'APCA-API-KEY-ID': key, 'APCA-API-SECRET-KEY': secret}
        acct = SESSION.get('https://paper-api.alpaca.markets/v2/account', headers=hd, timeout=10).json()
        pos = SESSION.get('https://paper-api.alpaca.markets/v2/positions', headers=hd, timeout=10).json()
        return {'account': acct, 'positions': pos if isinstance(pos, list) else []}
    except Exception as e:
        return {'error': str(e)}

def fetch_crypto():
    prices = {}
    for sym, pair in {'BTC':'XBTUSD','ETH':'ETHUSD','SOL':'SOLUSD'}.items():
        try:
            r = SESSION.get(f'https://api.kraken.com/0/public/Ticker?pair={pair}', timeout=8)
            d = r.json(); k = list(d.get('result',{}).keys())[0]
            if k:
                info = d['result'][k]
                last, opn = float(info['c'][0]), float(info['o'])
                prices[sym] = {'price':last, 'open':opn, 'high':float(info['h'][1]), 'low':float(info['l'][1]),
                    'volume':float(info['v'][1]), 'change_24h':round((last-opn)/opn*100,2) if opn else 0}
        except: pass
    return prices

def fetch_extras():
    ex = {}
    try:
        r = SESSION.get('https://api.alternative.me/fng/?limit=1', timeout=8).json()
        if r.get('data'): ex['fear_greed'] = {'value':int(r['data'][0]['value']), 'label':r['data'][0]['value_classification']}
    except: ex['fear_greed'] = {'value':0,'label':'Unknown'}
    try:
        r = SESSION.get('https://api.coingecko.com/api/v3/global', timeout=8).json()
        ex['btc_dominance'] = round(r.get('data',{}).get('market_cap_percentage',{}).get('btc',0),2)
    except: ex['btc_dominance'] = 0
    return ex

def fetch_stocks():
    key, secret = read_secret('alpaca-key-id'), read_secret('alpaca-secret')
    if not key: return {}
    try:
        hd = {'APCA-API-KEY-ID': key, 'APCA-API-SECRET-KEY': secret}
        r = SESSION.get('https://data.alpaca.markets/v2/stocks/snapshots?symbols=AAPL,NVDA,TSLA,MU,LLY,MSTR,SPY,QQQ', headers=hd, timeout=10)
        if not r.ok: return {}
        quotes = {}
        for sym, snap in r.json().items():
            latest = snap.get('latestTrade',{}).get('p',0)
            prev = snap.get('prevDailyBar',{}).get('c',latest)
            chg = latest - prev if prev else 0
            quotes[sym] = {'price':latest,'prev_close':prev,'change':round(chg,2),'change_pct':round(chg/prev*100,2) if prev else 0}
        return quotes
    except: return {}

def fetch_flows():
    try:
        r = SESSION.get('http://localhost:3000/api/options-flow', timeout=10).json()
        flows = r.get('flows',[])
        unusual = sorted([f for f in flows if f.get('Volume',0)>f.get('OI',0)], key=lambda x:x.get('Value',0), reverse=True)[:5]
        return [{'symbol':f.get('Symbol'),'type':f.get('OptionType'),'strike':f.get('Strike'),'value':f.get('Value'),
            'volume':f.get('Volume'),'oi':f.get('OI'),'side':f.get('BidAskType'),'flow_type':f.get('BlockType')} for f in unusual]
    except: return []

def build(brief_type):
    now = get_edt_now()
    sess = get_market_sessions()
    port = fetch_alpaca()
    crypto = fetch_crypto()
    extras = fetch_extras()
    stocks = fetch_stocks()
    flows = fetch_flows()

    equity = 0; daily_pct = 0; total_return = 0; pos_lines = []; buying_power = 0
    if port and 'account' in port:
        a = port['account']; equity = float(a.get('equity',0)); le = float(a.get('last_equity',0))
        daily_pct = ((equity-le)/le*100) if le else 0; total_return = (equity-100000)/1000
        buying_power = float(a.get('buying_power',0))
        for p in port.get('positions',[]):
            sym=p.get('symbol',''); qty=p.get('qty','0'); entry=float(p.get('avg_entry_price',0))
            cur=float(p.get('current_price',0)); pnl=float(p.get('unrealized_pl',0))
            pct=float(p.get('unrealized_plpc',0))*100; mv=float(p.get('market_value',0))
            pos_lines.append(f"  {sym}: {qty} @ ${entry:.2f} -> ${cur:.2f} | P/L: ${pnl:.2f} ({pct:+.1f}%) | Val: ${mv:.2f}")

    sl = '\n'.join([f"  {'G' if v in ['OPEN','PREMARKET','AFTER-HOURS','24/7','BUSINESS HOURS'] else 'X'} {k}: {v}" for k,v in sess.items()])

    md = f"""# BRIEF DATA -- {now.strftime('%A, %B %d, %Y')} -- {now.strftime('%I:%M %p')} EDT
## Brief Type: {brief_type.upper()}

## GLOBAL MARKET SESSIONS
{sl}

## PORTFOLIO
Equity: ${equity:,.2f} | Daily: {daily_pct:+.2f}% | Return: {total_return:+.1f}% from $100K | BP: ${buying_power:,.2f}
{chr(10).join(pos_lines) if pos_lines else '  No positions'}

## CRYPTO (Kraken)
"""
    for sym, d in crypto.items():
        md += f"  {sym}: ${d['price']:,.2f} ({d['change_24h']:+.2f}%) | H: ${d['high']:,.2f} L: ${d['low']:,.2f}\n"
    fg = extras.get('fear_greed',{})
    md += f"  Fear and Greed: {fg.get('value','?')} ({fg.get('label','?')}) | BTC Dom: {extras.get('btc_dominance','?')}%\n"

    md += "\n## WATCHLIST (Alpaca)\n"
    for sym, q in stocks.items():
        md += f"  {sym}: ${q['price']:.2f} ({q['change_pct']:+.2f}%)\n"

    if flows:
        md += "\n## TOP UNUSUAL FLOW\n"
        for f in flows:
            v = f['value']; vs = f"${v/1e6:.1f}M" if v>=1e6 else f"${v/1e3:.0f}K"
            md += f"  {f['symbol']} {f['strike']} {f['type']} -- {vs} | {f['flow_type']} | Vol:{f['volume']} OI:{f['oi']}\n"

    md += f"\n## TIMESTAMP\n  {now.strftime('%Y-%m-%d %I:%M %p')} EDT\n"

    os.makedirs(os.path.dirname(OUTPUT), exist_ok=True)
    open(OUTPUT,'w').write(md)
    json.dump({'generated':now.strftime('%Y-%m-%d %I:%M %p EDT'),'type':brief_type,'sessions':sess,'equity':equity,
        'crypto':crypto,'extras':extras,'stocks':stocks,'flows':flows}, open(OUTPUT_JSON,'w'), indent=2)
    print(f"[{now.strftime('%I:%M %p EDT')}] Brief data saved for {brief_type}")
    return md

if __name__ == '__main__':
    brief_type = sys.argv[1] if len(sys.argv) > 1 else 'general'
    print(build(brief_type))
