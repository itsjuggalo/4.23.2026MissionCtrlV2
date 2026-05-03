"""
Shared core for boba_decision_cycle_py and jazzy_decision_cycle_py.
Same hard filters - different scoring/tiebreaker per agent.
"""
import json, time, requests
from datetime import datetime, timezone, timedelta
from pathlib import Path

SECRETS = Path('/home/ubuntu/.openclaw/secrets')
SCANNER_DATA = Path('/home/ubuntu/.openclaw/data/scanners')
FLOW_DATA = Path('/home/ubuntu/mission-control-restored/Option-Signals-Scraper/data')
SHARED_STATE = Path('/home/ubuntu/.openclaw/workspace/state/disciplined')
SHARED_STATE.mkdir(parents=True, exist_ok=True)
COORD_FILE = SHARED_STATE / 'agent_picks_today.json'

# Hard filters - identical for both agents
MIN_FLOW_T1 = 1_000_000
MIN_FLOW_T2 = 500_000
MIN_SCANNER_CONFLUENCE = 2
MIN_DTE = 1
MAX_BIDASK_SPREAD_PCT = 15.0
HARD_CAP_OPEN_POSITIONS = 1

# Sizing tiers - identical for both
SIZING_A_PLUS_PCT = 0.80
SIZING_A_PCT = 0.50
STOP_A_PLUS_PCT = -10.0
STOP_A_PCT = -20.0


def read_secret(name):
    p = SECRETS / name
    return p.read_text().strip() if p.exists() and p.stat().st_size > 0 else ''


def alpaca_call(endpoint, key, secret, method='GET', **kwargs):
    if not key or not secret:
        return None
    url = f'https://paper-api.alpaca.markets{endpoint}'
    headers = {'APCA-API-KEY-ID': key, 'APCA-API-SECRET-KEY': secret, 'Content-Type': 'application/json'}
    try:
        if method == 'GET':
            r = requests.get(url, headers=headers, timeout=15, **kwargs)
        elif method == 'POST':
            r = requests.post(url, headers=headers, timeout=15, **kwargs)
        elif method == 'DELETE':
            r = requests.delete(url, headers=headers, timeout=15, **kwargs)
        if r.status_code in (200, 201, 204, 207):
            return r.json() if r.text else {}
        return None
    except Exception:
        return None


def get_account_state(key, secret):
    return alpaca_call('/v2/account', key, secret)


def get_open_positions(key, secret):
    return alpaca_call('/v2/positions', key, secret) or []


def fetch_active_flow():
    """T1 huge or T2 unusual SWEEP + A/AA - last 24h."""
    cutoff = int(time.time()) - 24 * 3600
    candidates = {}
    for feed_name in ['flow_alerts_today', 'flow2_alerts_today']:
        p = FLOW_DATA / f'{feed_name}.json'
        if not p.exists():
            continue
        try:
            d = json.loads(p.read_text())
        except Exception:
            continue
        items = d.values() if isinstance(d, dict) else d
        for entry in items:
            if not isinstance(entry, dict):
                continue
            a = entry.get('alert', entry) if isinstance(entry.get('alert'), dict) else entry
            symbol = a.get('Symbol')
            t = a.get('Time')
            value = float(a.get('Value', 0) or 0)
            bidask = (a.get('BidAskType') or '').upper()
            block_type = (a.get('BlockType') or '').upper()
            volume = float(a.get('Volume', 0) or 0)
            oi = float(a.get('OpenInterest', 0) or 0)
            if not symbol or not t:
                continue
            try:
                ts = float(t)
                if ts > 1e12:
                    ts /= 1000.0
                if int(ts) < cutoff:
                    continue
            except Exception:
                continue
            is_t1 = (value >= MIN_FLOW_T1 and 'SWEEP' in block_type and bidask in ('A', 'AA'))
            is_t2 = (value >= MIN_FLOW_T2 and 'SWEEP' in block_type and bidask in ('A', 'AA') and volume > oi)
            if not (is_t1 or is_t2):
                continue
            try:
                strike = float(a.get('Strike'))
                expiry = a.get('Expiration') or a.get('ExpiryStr', '')
                is_put = a.get('IsPut', False)
                exp_dt = datetime.fromisoformat(expiry[:10])
                strike_int = int(round(strike * 1000))
                occ = f"{symbol}{exp_dt.strftime('%y%m%d')}{'P' if is_put else 'C'}{strike_int:08d}"
            except Exception:
                continue
            candidates[occ] = {
                'symbol': symbol, 'strike': strike, 'expiry': expiry, 'is_put': is_put,
                'value': value, 'bidask': bidask, 'block_type': block_type,
                'volume': volume, 'oi': oi, 'tier': 'T1' if is_t1 else 'T2',
                'alert_time': int(ts), 'occ': occ,
            }
    return candidates


def fetch_scanner_confluence(symbol):
    confluence = []
    for scanner_file in ['multi_feed_overlap.json', 'gamma_squeeze.json',
                         'congress_catalyst.json', 'pre_pop.json',
                         'earnings_catalyst.json']:
        p = SCANNER_DATA / scanner_file
        if not p.exists():
            continue
        try:
            d = json.loads(p.read_text())
        except Exception:
            continue
        scanner_name = scanner_file.replace('.json', '')
        candidates_field = None
        for key in ['top_15', 'top_10', 'overlap_symbols', 'candidates', 'top_candidates']:
            if key in d:
                candidates_field = d[key]
                break
        if candidates_field is None:
            continue
        if isinstance(candidates_field, list):
            for c in candidates_field:
                if isinstance(c, dict) and c.get('symbol') == symbol:
                    confluence.append(scanner_name)
                    break
                elif isinstance(c, str) and c == symbol:
                    confluence.append(scanner_name)
                    break
        elif isinstance(candidates_field, dict) and symbol in candidates_field:
            confluence.append(scanner_name)
    return confluence


def fetch_inline_ta(symbol, alpaca_key=None, alpaca_secret=None):
    bars = None
    if alpaca_key and alpaca_secret:
        try:
            url = f'https://data.alpaca.markets/v2/stocks/{symbol}/bars'
            params = {'timeframe': '5Min', 'limit': 50, 'feed': 'iex'}
            r = requests.get(url, headers={
                'APCA-API-KEY-ID': alpaca_key,
                'APCA-API-SECRET-KEY': alpaca_secret,
            }, params=params, timeout=10)
            if r.status_code == 200:
                bars = r.json().get('bars', [])
        except Exception:
            pass
    if not bars:
        try:
            import yfinance as yf
            tk = yf.Ticker(symbol)
            hist = tk.history(period='1d', interval='5m')
            if not hist.empty:
                bars = [{'h': float(row['High']), 'l': float(row['Low']),
                         'c': float(row['Close']), 'v': float(row['Volume']),
                         'o': float(row['Open'])} for _, row in hist.iterrows()]
        except Exception:
            pass
    if not bars or len(bars) < 14:
        return {'error': 'insufficient_bars'}

    closes = [b.get('c') for b in bars]
    highs = [b.get('h') for b in bars]
    lows = [b.get('l') for b in bars]
    volumes = [b.get('v', 0) for b in bars]

    deltas = [closes[i+1] - closes[i] for i in range(len(closes)-1)]
    gains = [d if d > 0 else 0 for d in deltas]
    losses = [-d if d < 0 else 0 for d in deltas]
    if len(gains) >= 14:
        avg_gain = sum(gains[-14:]) / 14
        avg_loss = sum(losses[-14:]) / 14
        rs = avg_gain / avg_loss if avg_loss > 0 else 100
        rsi = 100 - (100 / (1 + rs))
    else:
        rsi = 50.0

    def ema(values, period):
        if len(values) < period:
            return values[-1] if values else 0
        k = 2 / (period + 1)
        e = values[0]
        for v in values[1:]:
            e = v * k + e * (1 - k)
        return e

    ema9 = ema(closes, 9)
    ema21 = ema(closes, 21)
    if sum(volumes) > 0:
        vwap = sum((highs[i] + lows[i] + closes[i]) / 3 * volumes[i] for i in range(len(closes))) / sum(volumes)
    else:
        vwap = closes[-1]
    if len(closes) >= 20:
        recent = closes[-20:]
        mean = sum(recent) / 20
        std = (sum((c - mean) ** 2 for c in recent) / 20) ** 0.5
        bb_upper = mean + 2 * std
        bb_lower = mean - 2 * std
        bb_position = (closes[-1] - bb_lower) / (bb_upper - bb_lower) if bb_upper != bb_lower else 0.5
    else:
        bb_upper = bb_lower = closes[-1]
        bb_position = 0.5
    trs = []
    for i in range(1, len(closes)):
        tr = max(highs[i] - lows[i], abs(highs[i] - closes[i-1]), abs(lows[i] - closes[i-1]))
        trs.append(tr)
    atr = sum(trs[-14:]) / 14 if len(trs) >= 14 else 0
    return {
        'price': closes[-1], 'rsi': round(rsi, 1),
        'ema9': round(ema9, 2), 'ema21': round(ema21, 2),
        'vwap': round(vwap, 2),
        'bb_upper': round(bb_upper, 2), 'bb_lower': round(bb_lower, 2),
        'bb_position': round(bb_position, 2),
        'atr': round(atr, 2),
        'price_vs_ema9': round((closes[-1] / ema9 - 1) * 100, 1) if ema9 else 0,
        'price_vs_vwap': round((closes[-1] / vwap - 1) * 100, 1) if vwap else 0,
        'bars_used': len(bars),
    }


def fetch_tradier_quote(occ):
    tradier_key = read_secret('tradier-sandbox-key')
    if not tradier_key:
        return None
    try:
        url = 'https://sandbox.tradier.com/v1/markets/quotes'
        r = requests.get(url, headers={
            'Authorization': f'Bearer {tradier_key}',
            'Accept': 'application/json',
        }, params={'symbols': occ, 'greeks': 'true'}, timeout=10)
        if r.status_code != 200:
            return None
        d = r.json()
        q = d.get('quotes', {}).get('quote')
        if not q:
            return None
        if isinstance(q, list):
            q = q[0]
        bid = float(q.get('bid', 0) or 0)
        ask = float(q.get('ask', 0) or 0)
        spread_pct = ((ask - bid) / ((ask + bid) / 2) * 100) if (ask + bid) > 0 else 100
        return {
            'bid': bid, 'ask': ask, 'last': float(q.get('last', 0) or 0),
            'spread_pct': round(spread_pct, 1),
            'iv': float(q.get('greeks', {}).get('mid_iv', 0) or 0) if q.get('greeks') else 0,
            'delta': float(q.get('greeks', {}).get('delta', 0) or 0) if q.get('greeks') else 0,
            'volume': int(q.get('volume', 0) or 0),
            'open_interest': int(q.get('open_interest', 0) or 0),
        }
    except Exception:
        return None


def grade_setup(confluence_count, tier):
    if confluence_count >= 3 and tier == 'T1':
        return ('A+', SIZING_A_PLUS_PCT, STOP_A_PLUS_PCT)
    elif confluence_count >= 2:
        return ('A', SIZING_A_PCT, STOP_A_PCT)
    return (None, 0, 0)


def load_agent_picks_today():
    """Load OCC tickers other agents have already picked today - cross-coordination."""
    if not COORD_FILE.exists():
        return {}
    try:
        d = json.loads(COORD_FILE.read_text())
        today = datetime.now(timezone.utc).strftime('%Y-%m-%d')
        # Filter to today only - auto-prunes stale entries
        return {k: v for k, v in d.items() if v.get('date') == today}
    except Exception:
        return {}


def record_agent_pick(agent_name, occ):
    """Record that this agent picked this OCC today - other agents will skip it."""
    picks = load_agent_picks_today()
    today = datetime.now(timezone.utc).strftime('%Y-%m-%d')
    key = f'{agent_name}_{today}_{occ}'
    picks[key] = {
        'agent': agent_name, 'occ': occ, 'date': today,
        'picked_at': datetime.now(timezone.utc).isoformat(),
    }
    COORD_FILE.write_text(json.dumps(picks, indent=2))


def get_other_agents_occ_today(self_agent_name):
    """Return set of OCCs that OTHER agents (not self) picked today."""
    picks = load_agent_picks_today()
    others = set()
    for k, v in picks.items():
        if v.get('agent') != self_agent_name:
            others.add(v.get('occ'))
    return others


def filter_and_score_candidates(candidates, sort_strategy):
    """
    Apply hard filters then sort by agent-specific strategy.
    sort_strategy: 'boba' = (tier, -confluence, -value)
                   'jazzy' = (-confluence, tier, -alert_time)
    """
    scored = []
    for occ, c in candidates.items():
        confluence = fetch_scanner_confluence(c['symbol'])
        c['confluence'] = confluence
        c['confluence_count'] = len(confluence)
        if c['confluence_count'] >= MIN_SCANNER_CONFLUENCE:
            grade, sizing_pct, stop_pct = grade_setup(c['confluence_count'], c['tier'])
            if grade:
                c['grade'] = grade
                c['sizing_pct'] = sizing_pct
                c['stop_pct'] = stop_pct
                c['flow_value'] = c['value']
                scored.append(c)
    if sort_strategy == 'boba':
        scored.sort(key=lambda x: (x['tier'] != 'T1', -x['confluence_count'], -x['value']))
    elif sort_strategy == 'jazzy':
        scored.sort(key=lambda x: (-x['confluence_count'], x['tier'] != 'T1', -x['alert_time']))
    return scored
