#!/home/itsju/.venv/bin/python3
"""Life Engine — standalone runner. Called by cron every 30 min.

Fully-loaded build: deterministic template (always sends) + optional AI
focus line (augment-on-top, never blocks) + bills.json + weather + todos +
yesterday-memory + cross-day dedup + reliability/recovery + archive.
All trading/PM2 blocks are byte-identical to the original.
"""
import calendar as _calmod
import glob
import json
import os
import re
import subprocess
import sys
import time
import urllib.request
from datetime import date, datetime, timedelta, timezone

import pytz

# ── Config ──────────────────────────────────────────────────────────────────
ET = pytz.timezone('America/New_York')
SECRETS = os.path.expanduser('~/.openclaw/secrets')
STATE_FILE = os.path.expanduser('~/.life-engine-state.json')
CLAUDECLAW_DIR = '/home/itsju/claudeclaw-os'
PYTHON = '/home/itsju/.venv/bin/python3'
GMAIL = os.path.expanduser('~/.config/gmail/gmail.py')
GCAL  = os.path.expanduser('~/.config/calendar/gcal.py')

LIFECLAW_DIR = os.path.expanduser('~/.lifeclaw')
CONFIG_FILE  = os.path.join(LIFECLAW_DIR, 'config.json')
BILLS_FILE   = os.path.join(LIFECLAW_DIR, 'bills.json')
ARCHIVE_FILE = os.path.join(LIFECLAW_DIR, 'sent_briefs.jsonl')
CLAUDE_BIN   = os.path.expanduser('~/.local/bin/claude')

DEFAULT_CONFIG = {
    'location': {'lat': None, 'lon': None, 'label': ''},
    'llm_voice': True,
    'llm_timeout_s': 60,
    'llm_style': 'augment',
    'persona': "You are Mike's chief of staff. Warm, sharp, zero fluff. Eastern Time.",
    'todo_file': '~/claude-office/TODO.md',
    'episodic_dir': '~/second-brain/episodic',
    'todo_max': 5,
}

BILL_KW   = ['bill','invoice','payment due','statement','amount due','overdue','past due',
             'utility','electric','gas bill','water bill','rent','renewal',
             'autopay','balance due','minimum payment','final notice','past due']
COUPON_KW = ['coupon','promo code','discount','% off','save ','flash sale','code:','get $']

# Friendly display names for known senders
FRIENDLY_SENDERS = {
    'speedpay.com':             'Duke Energy',
    'duke-energy.com':          'Duke Energy',
    'e.chase.com':              'Chase',
    'mcmap.chase.com':          'Chase',
    'bankofamerica.com':        'Bank of America',
    'wellsfargo.com':           'Wells Fargo',
    'e.siriusxm.com':           'SiriusXM',
    'is.email.nextdoor.com':    'Nextdoor',
    'ss.email.nextdoor.com':    'Nextdoor Safety',
    'informeddelivery.usps.com':'USPS Mail',
    'mailer.alpaca.markets':    'Alpaca',
    'commerce.fl.gov':          'FL Reemployment',
    'floridajobs.org':          'FL Jobs',
    'robinhood.com':            'Robinhood',
    'e.godaddy.com':            'GoDaddy',
}

# Senders whose emails are always noise — filtered before any keyword check
SKIP_SENDERS = [
    'beehiiv.com','therumers.com','warriortrading.com','optionsautotrader.com',
    'whitebeardstrategies.com','stocktwits.com','temuemail.com',
    'underarmour.com','seaworldparks.com','poshmark.com','email.bestbuy.com',
    'fiscal.ai','mail.perplexity.ai','ancestry.com','dignitymemorial.com',
    'e-offers.dominos.com','dcsg.com','e.ncl.com','email.livenation.com',
    'stockx.com','e.harborfreight.com','e.lowes.com',
    'email-advanceautoparts.com','nedm.asus.com','news@sophos.com',
    'e.questdiagnostics.com','takeprofittrader.com','e.allegiant.com',
    'eg.expedia.com','synchronyfinancial.com','support@ninjatrader.com',
    'team.public.com','mtmarketing@continued.com',
    'updates@okx.com','em.linkedin.com','messages-noreply@linkedin.com',
    'e.godaddy.com','news.temuemail.com',
    'nextdoor.com','email.nextdoor.com','ss.email.nextdoor.com','is.email.nextdoor.com',
    'muvfl.com','eml.muvfl.com',
]

# Senders that are always important — surface regardless of keywords
IMPORTANT_SENDERS = [
    'commerce.fl.gov','floridajobs.org','speedpay.com',
    'informeddelivery.usps.com',
    'e.chase.com','mcmap.chase.com','mailer.alpaca.markets',
    'bankofamerica.com','wellsfargo.com',
    'trulieve.com','ups.com','fedex.com',
    'walmart.com','ebay.com','siriusxm.com',
    'robinhood.com','amazon.com',
]

# Keywords in subject/snippet that flag an email as important
IMPORTANT_KW = [
    'reemployment','unemployment','benefit','claim',
    'duke energy','payment confirmation','payment received',
    'eviction','court notice','legal notice','judgment',
    'irs','tax refund','final notice','collections',
    'premium due','coverage lapsed','policy cancelled',
    'service shut','account suspended','account closed',
    'informed delivery','beware','safety alert','urgent',
    'dmv','vehicle registration','car payment',
    'michael englund',
    'out for delivery','package delivered','order shipped',
    'order confirmed','your order','tracking number',
    'your withdrawal','trade confirmation',
    # eBay account activity only
    'you sold','item sold','bid won','purchase confirmed',
    'payment received','payment sent','your listing',
    'case opened','refund','feedback left',
    # Account security
    'sign-in attempt','new device','unusual activity',
    # Robinhood real events
    'completed','your transfer','your deposit',
]

# ── Helpers ──────────────────────────────────────────────────────────────────
def secret(name):
    path = os.path.join(SECRETS, name)
    return open(path).read().strip() if os.path.exists(path) else None

def esc(text: str) -> str:
    """Escape text for Telegram HTML parse_mode."""
    return text.replace('&', '&amp;').replace('<', '&lt;').replace('>', '&gt;')

def load_config():
    cfg = dict(DEFAULT_CONFIG)
    try:
        cfg.update(json.load(open(CONFIG_FILE)))
    except Exception:
        pass
    return cfg

DISCORD_HOOKS = {
    'morning_brief':   'discord-webhook-morning-brief.txt',
    'midday_checkin':  'discord_midday_brief_webhook',
    'evening_summary': 'discord_eod_brief_webhook',
    'nightly_wrap':    'discord-webhook-nightly-brief.txt',
}

def _telegram_post(message: str, parse_mode: bool) -> bool:
    token   = secret('lifeclaw_telegram_bot_token')
    chat_id = secret('lifeclaw_telegram_chat_id')
    if not token or not chat_id:
        print('Telegram: missing token/chat_id', file=sys.stderr)
        return False
    import urllib.parse
    payload = message if parse_mode else re.sub(r'<[^>]+>', '', message)
    encoded = urllib.parse.quote(payload)
    url = f'https://api.telegram.org/bot{token}/sendMessage'
    mode = '&parse_mode=HTML' if parse_mode else ''
    data = f'chat_id={chat_id}{mode}&text={encoded}'.encode()
    try:
        resp = json.loads(urllib.request.urlopen(urllib.request.Request(url, data=data), timeout=10).read())
        return resp.get('ok', False)
    except Exception as e:
        print(f'Telegram error: {e}', file=sys.stderr)
        return False

def send_telegram(message: str) -> bool:
    """3 attempts w/ backoff; final fallback strips HTML if parse_mode rejected."""
    for i, delay in enumerate((0, 5, 15)):
        if delay:
            time.sleep(delay)
        if _telegram_post(message, parse_mode=True):
            return True
    # Last resort: maybe HTML was rejected — send plain text once.
    return _telegram_post(message, parse_mode=False)

def send_discord(brief_type: str, message: str):
    hook_file = DISCORD_HOOKS.get(brief_type)
    if not hook_file:
        return
    webhook_url = secret(hook_file)
    if not webhook_url:
        return
    webhook_url = webhook_url.replace('discordapp.com', 'discord.com')
    plain = re.sub(r'<[^>]+>', '', message)
    payload = json.dumps({'content': plain})
    result = run(
        f"curl -s -o /dev/null -w '%{{http_code}}' -X POST {json.dumps(webhook_url)} "
        f"-H 'Content-Type: application/json' -d {json.dumps(payload)}",
        timeout=10)
    if result not in ('200', '204'):
        print(f'Discord mirror: HTTP {result}', file=sys.stderr)

def load_state():
    try:
        return json.load(open(STATE_FILE))
    except:
        return {}

def save_state(state):
    cutoff = (datetime.now(ET).date() - timedelta(days=7)).strftime('%Y-%m-%d')
    # Prune dated keys but always preserve non-date keys (seen, bills_paid, etc.)
    state = {k: v for k, v in state.items() if k >= cutoff or not k[:4].isdigit()}
    json.dump(state, open(STATE_FILE, 'w'), indent=2)

def already_sent(brief_type):
    today = datetime.now(ET).strftime('%Y-%m-%d')
    return bool(load_state().get(today, {}).get(brief_type, False))

def mark_sent(brief_type):
    state = load_state()
    today = datetime.now(ET).strftime('%Y-%m-%d')
    state.setdefault(today, {})[brief_type] = 'sent'
    save_state(state)

def run(cmd, timeout=15):
    try:
        r = subprocess.run(cmd, shell=True, capture_output=True, text=True, timeout=timeout)
        return r.stdout.strip()
    except:
        return ''

def _ordinal(n):
    if 10 <= n % 100 <= 20:
        suf = 'th'
    else:
        suf = {1: 'st', 2: 'nd', 3: 'rd'}.get(n % 10, 'th')
    return f"{n}{suf}"

# ── Email helpers ─────────────────────────────────────────────────────────────
_REAL_DEAL = re.compile(
    r'(\d+)\s*%\s*off|save\s+\$(\d+)|\$(\d+)\s+off|'
    r'code[:\s]+([A-Z0-9]{4,})|promo\s*code[:\s]+([A-Z0-9]{4,})',
    re.IGNORECASE
)
_PAID_KW    = ['payment confirmation','payment received','thank you for your payment',
               'payment processed','successfully paid','autopay processed']

def _friendly_name(email):
    frm = email.get('from', '').lower()
    for domain, name in FRIENDLY_SENDERS.items():
        if domain in frm:
            return name
    raw = email.get('from', '')
    if '<' in raw:
        return raw.split('<')[0].strip().strip('"\'')
    return raw.split('@')[0] if '@' in raw else raw[:30]

def _dedup_by_sender(emails):
    seen, out = set(), []
    for e in emails:
        name = _friendly_name(e)
        if name not in seen:
            seen.add(name)
            out.append(e)
    return out

def _is_real_deal(email):
    text = email.get('subject', '') + ' ' + email.get('snippet', '')
    return bool(_REAL_DEAL.search(text))

def _deal_summary(email):
    text = email.get('subject', '') + ' ' + email.get('snippet', '')
    name = _friendly_name(email)
    m = _REAL_DEAL.search(text)
    if not m:
        return f"{name} — deal"
    pct, save_d, off_d, code1, code2 = m.groups()
    if pct:   return f"{name} — {pct}% off"
    if save_d: return f"{name} — save ${save_d}"
    if off_d:  return f"{name} — ${off_d} off"
    code = code1 or code2
    return f"{name} — code {code}"

# ── Cross-day dedup (G) ───────────────────────────────────────────────────────
def _email_key(e):
    return f"{_friendly_name(e)}|{e.get('subject','')[:50].lower()}"

def filter_new(items, kind, now, persist, keyfn):
    """Return only items whose key hasn't been seen before. Prune seen >14d.
    When persist=False (preview), state is not mutated."""
    state  = load_state()
    seen   = state.get('seen', {})
    today  = now.strftime('%Y-%m-%d')
    cutoff = (now.date() - timedelta(days=14)).strftime('%Y-%m-%d')
    seen   = {k: v for k, v in seen.items() if v >= cutoff}
    fresh  = []
    for it in items:
        key = f"{kind}:{keyfn(it)}"
        if key not in seen:
            fresh.append(it)
            seen[key] = today
    if persist:
        state['seen'] = seen
        save_state(state)
    return fresh

# ── Bills from config (I) ─────────────────────────────────────────────────────
def load_bills():
    try:
        return json.load(open(BILLS_FILE))
    except Exception:
        return []

def get_bills(now, emails, persist):
    """Curated bills from bills.json. Email only flips paid-this-cycle status."""
    bills = load_bills()
    if not bills:
        return []
    today  = now.date()
    cycle  = now.strftime('%Y-%m')          # monthly cycle id
    state  = load_state()
    paid   = state.get('bills_paid', {})
    # Flip paid status when a payment-confirmation from the payee domain is seen.
    flipped = False
    for b in bills:
        dom = (b.get('payee_domain') or '').lower()
        if not dom:
            continue
        for e in emails:
            frm = e.get('from', '').lower()
            txt = (e.get('subject', '') + ' ' + e.get('snippet', '')).lower()
            if dom in frm and any(k in txt for k in _PAID_KW):
                if paid.get(b['name']) != cycle:
                    paid[b['name']] = cycle
                    flipped = True
                break
    if persist and flipped:
        state['bills_paid'] = paid
        save_state(state)
    last_dom = _calmod.monthrange(today.year, today.month)[1]
    out = []
    for b in bills:
        due_day = int(b.get('due_day', 1))
        dd      = min(due_day, last_dom)
        due     = date(today.year, today.month, dd)
        out.append({
            'name':    b.get('name', '?'),
            'amount':  float(b.get('amount') or 0),
            'autopay': bool(b.get('autopay')),
            'due_day': due_day,
            'days':    (due - today).days,
            'is_paid': paid.get(b.get('name')) == cycle,
        })
    return out

def _bill_line(b):
    amt = f" (${b['amount']:,.2f})" if b['amount'] else ''
    ordn = _ordinal(b['due_day'])
    if b['is_paid']:
        return f"{b['name']} — {'autopay' if b['autopay'] else 'due'} {ordn}{amt} ✓ paid"
    if b['days'] < 0:
        return f"🔴 {b['name']} — PAST DUE (was {ordn}){amt}"
    if b['autopay']:
        return f"{b['name']} — autopay {ordn}{amt}"
    flag = ' ⚠️' if b['days'] <= 3 else ''
    return f"{b['name']} — due {ordn}{amt} · NOT autopay{flag}"

# ── Life data sources ─────────────────────────────────────────────────────────
def get_weather(cfg):
    loc = cfg.get('location', {})
    lat, lon = loc.get('lat'), loc.get('lon')
    if lat is None or lon is None:
        return None
    key = secret('openweathermap_api_key')
    if not key:
        return None
    try:
        url = (f"https://api.openweathermap.org/data/2.5/weather?"
               f"lat={lat}&lon={lon}&units=imperial&appid={key}")
        d   = json.loads(urllib.request.urlopen(url, timeout=8).read())
        t     = round(d['main']['temp'])
        feels = round(d['main']['feels_like'])
        desc  = d['weather'][0]['description']
        lo    = round(d['main']['temp_min'])
        hi    = round(d['main']['temp_max'])
        label = loc.get('label', '')
        prefix = f"{label}: " if label else ''
        return f"{prefix}{t}°F {desc} (feels {feels}°, {lo}–{hi}°)"
    except Exception:
        return 'weather unavailable'

def get_todos(cfg):
    path = os.path.expanduser(cfg.get('todo_file', ''))
    try:
        lines = open(path).read().splitlines()
    except Exception:
        return []
    out = []
    for ln in lines:
        s = ln.strip()
        if s.startswith('- [ ]'):
            t = s[5:].strip()
            t = t.replace('**', '')
            t = re.sub(r'^\d+\.\s*', '', t)
            if t:
                out.append(t)
    return out[:int(cfg.get('todo_max', 5))]

_COMMIT_CUES = ('todo', 'follow up', 'follow-up', 'commit', 'tomorrow', 'next step', 'need to')

def get_yesterday(cfg, now):
    d = os.path.expanduser(cfg.get('episodic_dir', ''))
    today_s = now.strftime('%Y-%m-%d')
    yday_s  = (now.date() - timedelta(days=1)).strftime('%Y-%m-%d')
    files = []
    for dt in (yday_s, today_s):
        files += sorted(glob.glob(os.path.join(d, f'TLDR -- {dt} -- *.md')))
        files += sorted(glob.glob(os.path.join(d, f'TLDR--{dt}--*.md')))
    title, raw = None, ''
    if files:
        f = files[-1]
        base = os.path.basename(f)
        parts = re.split(r'\s*--\s*', base)
        title = (parts[-1] if len(parts) >= 3 else base).replace('.md', '').strip()
        try:
            raw = open(f).read()[:1500]
        except Exception:
            raw = ''
    commitments = []
    for f in files:
        try:
            txt = open(f).read()
        except Exception:
            continue
        for ln in txt.splitlines():
            low = ln.lower()
            if any(c in low for c in _COMMIT_CUES):
                cl = ln.strip(' -*#>').strip()
                if cl and 4 < len(cl) < 160:
                    commitments.append(cl)
    commitments = list(dict.fromkeys(commitments))[:3]
    return {'title': title, 'raw': raw}, commitments

# ── Data sources ─────────────────────────────────────────────────────────────
def _is_skip(email):
    frm = email.get('from', '').lower()
    return any(s in frm for s in SKIP_SENDERS)

def get_gmail(account='', hours=168):
    flag = f'--account {account}' if account else ''
    raw = run(f'CLAUDECLAW_DIR={CLAUDECLAW_DIR} {PYTHON} {GMAIL} {flag} list --hours {hours}', timeout=25)
    try:
        emails = json.loads(raw)
    except:
        return [], [], []
    important, bills, coupons = [], [], []
    for e in emails:
        if _is_skip(e):
            continue
        frm  = e.get('from', '').lower()
        subj = e.get('subject', '').lower()
        snip = e.get('snippet', '').lower()
        sender_match = any(s in frm for s in IMPORTANT_SENDERS)
        kw_match     = any(k in subj + ' ' + snip for k in IMPORTANT_KW)
        # For commercial/broad domains, require a keyword hit — blocks ads but passes account activity
        broad = any(s in frm for s in (
            'robinhood.com','ebay.com','amazon.com','walmart.com','trulieve.com'))
        if (sender_match and not broad) or (broad and kw_match) or (not broad and kw_match):
            important.append(e)
        elif any(k in subj + ' ' + frm for k in BILL_KW):
            bills.append(e)
        elif any(k in subj + ' ' + snip for k in COUPON_KW) and _is_real_deal(e):
            coupons.append(e)
    return _dedup_by_sender(important)[:8], _dedup_by_sender(bills)[:5], _dedup_by_sender(coupons)[:3]

def get_calendar(account='', days=2):
    flag = f'--account {account}' if account else ''
    raw = run(f'CLAUDECLAW_DIR={CLAUDECLAW_DIR} {PYTHON} {GCAL} {flag} list --days {days}', timeout=20)
    try:
        events = json.loads(raw)
        seen, unique = set(), []
        for e in sorted(events, key=lambda x: x['start']):
            key = (e['summary'], e['start'][:16])
            if key not in seen:
                seen.add(key)
                unique.append(e)
        return unique
    except:
        return []

def _calendar_merged(days=2):
    events = get_calendar('', days) + get_calendar('personal', days)
    seen, out = set(), []
    for e in sorted(events, key=lambda x: x['start']):
        key = (e['summary'], e['start'][:16])
        if key not in seen:
            seen.add(key)
            out.append(e)
    return out

def cal_smarts(events, now):
    parsed = []
    for e in events:
        try:
            st = datetime.fromisoformat(e['start']).astimezone(ET)
        except Exception:
            st = None
        en = None
        if e.get('end'):
            try:
                en = datetime.fromisoformat(e['end']).astimezone(ET)
            except Exception:
                en = None
        parsed.append((st, en, e))
    conflicts = set()
    for i in range(len(parsed)):
        st_i, en_i, e_i = parsed[i]
        if not st_i:
            continue
        end_i = en_i or st_i + timedelta(hours=1)
        for j in range(i + 1, len(parsed)):
            st_j, en_j, e_j = parsed[j]
            if not st_j:
                continue
            if st_j.date() == st_i.date() and st_j < end_i:
                conflicts.add(e_i['summary'])
                conflicts.add(e_j['summary'])
    upcoming = [(st, e) for st, en, e in parsed if st and 0 < (st - now).total_seconds() <= 7200]
    next_prep = None
    if upcoming:
        st, e = min(upcoming, key=lambda x: x[0])
        mins = int((st - now).total_seconds() // 60)
        when = f"{mins // 60}h{mins % 60:02d}m" if mins >= 60 else f"{mins}m"
        next_prep = f"{e['summary']} in {when}"
    return conflicts, next_prep

def get_alpaca(key_file, secret_file, name):
    try:
        key    = secret(key_file)
        sec    = secret(secret_file)
        req    = urllib.request.Request(
            'https://paper-api.alpaca.markets/v2/account',
            headers={'APCA-API-KEY-ID': key, 'APCA-API-SECRET-KEY': sec})
        d      = json.loads(urllib.request.urlopen(req, timeout=8).read())
        pv     = float(d['portfolio_value'])
        pnl    = float(d['equity']) - float(d['last_equity'])
        cash   = float(d['cash'])
        return f'{name}: PV ${pv:,.2f} | Cash ${cash:,.2f} | P&amp;L <b>{pnl:+,.2f}</b>'
    except Exception as e:
        return f'{name}: unavailable'

def get_pm2():
    out = run(
        "ssh -o ConnectTimeout=6 -o StrictHostKeyChecking=no openclaw "
        "'/home/ubuntu/.npm-global/lib/node_modules/pm2/bin/pm2 jlist 2>/dev/null | "
        "python3 -c \""
        "import sys,json; p=json.load(sys.stdin); "
        "on=[x[\\\"name\\\"] for x in p if x[\\\"pm2_env\\\"][\\\"status\\\"]==\\\"online\\\"]; "
        "dn=[x[\\\"name\\\"] for x in p if x[\\\"pm2_env\\\"][\\\"status\\\"]!=\\\"online\\\"]; "
        "print(str(len(on))+\\\" online\\\"+(\\\" | STOPPED: \\\"+str(dn) if dn else \\\" | all healthy\\\"))\"'",
        timeout=12)
    return out or 'Oracle: unreachable'

def fmt_event(e):
    start = e['start'][11:16] if 'T' in e['start'] else e['start']
    return f"  {start}  {esc(e['summary'])}"

# ── Context object (Step 2) ───────────────────────────────────────────────────
def gather_context(brief_type, now, persist):
    cfg = load_config()
    ctx = {
        'brief_type': brief_type, 'now': now, '_cfg': cfg,
        'calendar': [], 'cal_conflicts': set(), 'cal_prep': None,
        'alerts': [], 'deals': [], 'bills': [],
        'trading': {}, 'pm2': None, 'weather': None,
        'todos': [], 'yesterday': {'title': None, 'raw': ''}, 'commitments': [],
    }

    if brief_type == 'morning_brief':
        ctx['calendar'] = _calendar_merged(2)
        ctx['cal_conflicts'], ctx['cal_prep'] = cal_smarts(ctx['calendar'], now)
        i1, _, c1 = get_gmail('',         hours=168)
        i2, _, c2 = get_gmail('personal', hours=168)
        important = i1 + i2
        ctx['alerts'] = filter_new(important, 'email', now, persist, _email_key)
        ctx['deals']  = (c1 + c2)[:3]
        ctx['bills']  = get_bills(now, important, persist)
        ctx['weather'] = get_weather(cfg)
        ctx['todos']  = get_todos(cfg)
        ctx['yesterday'], ctx['commitments'] = get_yesterday(cfg, now)
        ctx['trading'] = {
            'boba':  get_alpaca('alpaca-boba-key-id',  'alpaca-boba-secret',  'Boba R2'),
            'jazzy': get_alpaca('alpaca-jazzy-key-id', 'alpaca-jazzy-secret', 'Jazzy'),
        }
        ctx['pm2'] = get_pm2()

    elif brief_type == 'midday_checkin':
        ctx['trading'] = {
            'boba':  get_alpaca('alpaca-boba-key-id',  'alpaca-boba-secret',  'Boba R2'),
            'jazzy': get_alpaca('alpaca-jazzy-key-id', 'alpaca-jazzy-secret', 'Jazzy'),
        }
        i1, _, _ = get_gmail('',         hours=6)
        i2, _, _ = get_gmail('personal', hours=6)
        ctx['alerts'] = filter_new(i1 + i2, 'email', now, persist, _email_key)
        ctx['calendar'] = get_calendar('', 1)
        ctx['cal_conflicts'], ctx['cal_prep'] = cal_smarts(ctx['calendar'], now)

    elif brief_type == 'evening_summary':
        ctx['trading'] = {
            'boba':  get_alpaca('alpaca-boba-key-id',  'alpaca-boba-secret',  'Boba R2'),
            'jazzy': get_alpaca('alpaca-jazzy-key-id', 'alpaca-jazzy-secret', 'Jazzy'),
        }
        ctx['pm2'] = get_pm2()
        ctx['calendar'] = _calendar_merged(2)

    else:  # nightly_wrap
        i1, _, c1 = get_gmail('',         hours=168)
        i2, _, c2 = get_gmail('personal', hours=168)
        important = i1 + i2
        ctx['alerts'] = filter_new(important, 'email', now, persist, _email_key)
        ctx['deals']  = (c1 + c2)[:3]
        ctx['bills']  = get_bills(now, important, persist)
        ctx['calendar'] = _calendar_merged(2)
        ctx['weather'] = get_weather(cfg)
        ctx['todos']  = get_todos(cfg)
        ctx['yesterday'], ctx['commitments'] = get_yesterday(cfg, now)

    return ctx

def _tomorrow_events(ctx, now, limit):
    seen, tomorrow = set(), []
    for e in sorted(ctx['calendar'], key=lambda x: x['start']):
        key = (e['summary'], e['start'][:16])
        if key not in seen and e['start'][:10] > now.strftime('%Y-%m-%d'):
            seen.add(key)
            tomorrow.append(e)
    return tomorrow[:limit]

# ── Template renderers (deterministic fallback — Step 2) ──────────────────────
def _render_inbox(ctx):
    sections = ''
    if ctx['bills']:
        bl = '\n'.join(f"  └ {esc(_bill_line(b))}" for b in ctx['bills'])
        sections += f"  💸 <b>Bills</b>:\n{bl}\n"
    if ctx['alerts']:
        al = '\n'.join(
            f"  └ {esc(_friendly_name(e))} — {esc(e.get('subject','')[:50])}"
            for e in ctx['alerts'])
        sections += f"  🚨 <b>Alerts</b> ({len(ctx['alerts'])}):\n{al}\n"
    if ctx['deals']:
        dl = '\n'.join(f"  └ {esc(_deal_summary(c))}" for c in ctx['deals'])
        sections += f"  🎟 <b>Deals</b>:\n{dl}\n"
    return sections.rstrip() or '  Inbox clear'

def _render_calendar(ctx, limit):
    conflicts = ctx['cal_conflicts']
    lines = []
    for e in ctx['calendar'][:limit]:
        ln = fmt_event(e)
        if e['summary'] in conflicts:
            ln += ' ⚠️ overlap'
        lines.append(ln)
    out = '\n'.join(lines) or '  No events today'
    if ctx['cal_prep']:
        out += f"\n  ⏰ Next: {esc(ctx['cal_prep'])}"
    return out

def _render_life(ctx):
    """Weather / todos / yesterday blocks shared by morning + nightly."""
    out = ''
    if ctx['todos']:
        tl = '\n'.join(f"  └ {esc(t)}" for t in ctx['todos'])
        out += f"\n✅ <b>TODOS</b>\n{tl}\n"
    if ctx['yesterday'].get('title') or ctx['commitments']:
        out += "\n🧠 <b>YESTERDAY</b>\n"
        if ctx['yesterday'].get('title'):
            out += f"  └ {esc(ctx['yesterday']['title'])}\n"
        for c in ctx['commitments']:
            out += f"  ↻ {esc(c)}\n"
    return out

def render_template(brief_type, ctx):
    now = ctx['now']
    if brief_type == 'morning_brief':
        date_str = now.strftime('%a %b %-d · %H:%M ET')
        wx = f"🌤 {esc(ctx['weather'])}\n" if ctx['weather'] else ''
        return f"""🌅 <b>LIFE ENGINE — Morning Brief</b> | {date_str}
━━━━━━━━━━━━━━━━━━━━━━━━━━━━
{wx}
📅 <b>CALENDAR</b>
{_render_calendar(ctx, 6)}

📧 <b>INBOX</b>
{_render_inbox(ctx)}
{_render_life(ctx)}
📈 <b>TRADING</b> (paper)
  {ctx['trading']['boba']}
  {ctx['trading']['jazzy']}

🤖 Oracle PM2: {esc(ctx['pm2'])}
━━━━━━━━━━━━━━━━━━━━━━━━━━━━"""

    if brief_type == 'midday_checkin':
        time_str = now.strftime('%H:%M ET')
        alerts = ctx['alerts']
        inbox_line = (f"  ⚡ {len(alerts)} new alert{'s' if len(alerts)!=1 else ''} in inbox"
                      if alerts else '  Inbox clear')
        next_evt = f"\n  ⏰ Upcoming: {esc(ctx['cal_prep'])}" if ctx['cal_prep'] else ''
        return (f"☀️ <b>MIDDAY</b> | {time_str}\n  {ctx['trading']['boba']}\n  "
                f"{ctx['trading']['jazzy']}\n{inbox_line}{next_evt}")

    if brief_type == 'evening_summary':
        date_str = now.strftime('%a %b %-d')
        tmrw = _tomorrow_events(ctx, now, 3)
        tmrw_lines = '\n'.join(fmt_event(e) for e in tmrw) or '  Nothing scheduled'
        return f"""📊 <b>EOD WRAP</b> | {date_str}
  {ctx['trading']['boba']}
  {ctx['trading']['jazzy']}
  PM2: {esc(ctx['pm2'])}

📅 <b>Tomorrow</b>
{tmrw_lines}"""

    # nightly_wrap
    date_str = now.strftime('%a %b %-d')
    wx = f"🌤 {esc(ctx['weather'])}\n" if ctx['weather'] else ''
    tmrw = _tomorrow_events(ctx, now, 4)
    tmrw_lines = '\n'.join(fmt_event(e) for e in tmrw) or '  Nothing scheduled'
    return f"""🌙 <b>NIGHTLY</b> | {date_str}
{wx}📧 <b>INBOX</b>
{_render_inbox(ctx)}
{_render_life(ctx)}
📅 <b>Tomorrow</b>
{tmrw_lines}"""

# ── LLM focus line (Step F — augment-on-top, never blocks) ────────────────────
def _ctx_for_llm(ctx):
    def strip(s):
        return re.sub(r'<[^>]+>', '', s or '')
    return {
        'now': ctx['now'].strftime('%a %b %-d %H:%M ET'),
        'calendar': [
            {'time': e['start'][11:16] if 'T' in e['start'] else e['start'],
             'event': e['summary'],
             'conflict': e['summary'] in ctx['cal_conflicts']}
            for e in ctx['calendar'][:8]
        ],
        'next_event_prep': ctx['cal_prep'],
        'alerts': [{'from': _friendly_name(e), 'subject': e.get('subject', '')[:80]}
                   for e in ctx['alerts'][:8]],
        'bills': [{'name': b['name'], 'due_day': b['due_day'], 'days_until': b['days'],
                   'autopay': b['autopay'], 'paid': b['is_paid']} for b in ctx['bills']],
        'deals': [_deal_summary(c) for c in ctx['deals']],
        'todos': ctx['todos'],
        'yesterday_title': ctx['yesterday'].get('title'),
        'commitments': ctx['commitments'],
        'trading': {k: strip(v) for k, v in ctx['trading'].items()},
        'oracle_pm2': strip(ctx['pm2']) if ctx['pm2'] else None,
        'weather': ctx['weather'],
    }

def render_focus_line(brief_type, ctx, cfg):
    """Return one plain-text focus line, or None on any failure/timeout."""
    persona = cfg.get('persona', DEFAULT_CONFIG['persona'])
    blob = json.dumps(_ctx_for_llm(ctx), ensure_ascii=False, default=str)
    prompt = (
        f"{persona}\n\n"
        f"This is the {brief_type.replace('_',' ')}. Everything you know right now (JSON):\n"
        f"{blob}\n\n"
        "Write ONE line (max 140 characters, plain text, no markdown, no emoji, no quotes) "
        "naming the single most important thing Mike should act on right now. "
        "Use ONLY facts in the JSON — never invent names, numbers, or events. "
        "If nothing is urgent, state the most noteworthy thing in one line."
    )
    try:
        r = subprocess.run(
            ['env', '-u', 'ANTHROPIC_API_KEY', CLAUDE_BIN, '-p', prompt],
            capture_output=True, text=True, timeout=int(cfg.get('llm_timeout_s', 60)))
    except Exception as e:
        print(f'LLM focus error: {e}', file=sys.stderr)
        return None
    if r.returncode != 0:
        print(f'LLM focus rc={r.returncode}: {r.stderr[:200]}', file=sys.stderr)
        return None
    text = (r.stdout or '').strip()
    if not text:
        return None
    line = next((l.strip() for l in text.splitlines() if l.strip()), '')
    line = re.sub(r'<[^>]+>', '', line).strip().strip('"').strip()
    return line[:200] or None

# ── Compose (template + optional focus line) ──────────────────────────────────
def compose(brief_type, now, preview):
    ctx = gather_context(brief_type, now, persist=not preview)
    cfg = ctx['_cfg']
    body = render_template(brief_type, ctx)
    focus = render_focus_line(brief_type, ctx, cfg) if cfg.get('llm_voice') else None
    if focus:
        msg = f"💡 <b>Focus:</b> {esc(focus)}\n\n{body}"
        source = 'focus+template'
    else:
        msg = body
        source = 'template'
    return msg, source

def archive(brief_type, source, text, now):
    try:
        os.makedirs(LIFECLAW_DIR, exist_ok=True)
        rec = {'ts': now.isoformat(), 'brief_type': brief_type, 'source': source, 'text': text}
        with open(ARCHIVE_FILE, 'a') as f:
            f.write(json.dumps(rec, ensure_ascii=False) + '\n')
    except Exception as e:
        print(f'Archive error: {e}', file=sys.stderr)

def deliver(brief_type, now):
    """Compose + send live. Returns True on Telegram success."""
    msg, source = compose(brief_type, now, preview=False)
    ok = send_telegram(msg)
    if ok:
        mark_sent(brief_type)
        archive(brief_type, source, msg, now)
        print(f'[{now.strftime("%H:%M")}] {brief_type} sent via Telegram ✓ ({source})')
        send_discord(brief_type, msg)
        print(f'[{now.strftime("%H:%M")}] {brief_type} mirrored to Discord ✓')
    else:
        print(f'[{now.strftime("%H:%M")}] {brief_type} Telegram send failed', file=sys.stderr)
    return ok

# ── Scheduling / recovery (Step D) ────────────────────────────────────────────
# (brief_type, window_start_hour, window_end_hour, grace_end_hour)
WINDOWS = [
    ('morning_brief',   6,  11, 13),
    ('midday_checkin',  11, 13, 15),
    ('evening_summary', 15, 18, 20),
    ('nightly_wrap',    20, 23, 23),
]

def window_brief(hour):
    for bt, start, end, _ in WINDOWS:
        if start <= hour < end:
            return bt
    return None

def recover_missed(now, current):
    """Send any earlier-today brief that never succeeded, if still within grace."""
    hour = now.hour
    for bt, start, end, grace_end in WINDOWS:
        if bt == current:
            continue
        if hour >= end and hour < grace_end and not already_sent(bt):
            print(f'[{now.strftime("%H:%M")}] recovering missed {bt} (delayed)')
            msg, source = compose(bt, now, preview=False)
            msg = msg.replace('</b>', '</b> (delayed)', 1) if '</b>' in msg else f'(delayed)\n{msg}'
            if send_telegram(msg):
                mark_sent(bt)
                archive(bt, source + '+delayed', msg, now)
                send_discord(bt, msg)
                print(f'[{now.strftime("%H:%M")}] {bt} recovered ✓')

# ── Main ──────────────────────────────────────────────────────────────────────
def main():
    import argparse
    parser = argparse.ArgumentParser()
    parser.add_argument('--force', metavar='BRIEF_TYPE', default=None,
                        help='Force-send a specific brief, bypassing dedup check')
    parser.add_argument('--preview', metavar='BRIEF_TYPE', nargs='?', const='__auto__',
                        default=None,
                        help='Compose + print a brief; NO send, no state change')
    args = parser.parse_args()

    now  = datetime.now(ET)
    hour = now.hour

    # ── Preview: full compose path, print only, never mutates state ──
    if args.preview is not None:
        bt = args.preview if args.preview != '__auto__' else (window_brief(hour) or 'morning_brief')
        msg, source = compose(bt, now, preview=True)
        print(msg)
        print(f'\n----- [preview {bt}] source={source} — NO SEND, NO STATE CHANGE -----',
              file=sys.stderr)
        return

    if args.force:
        brief_type = args.force
        print(f'[{now.strftime("%H:%M")}] --force {brief_type}: bypassing dedup')
        ok = deliver(brief_type, now)
        sys.exit(0 if ok else 1)

    # Quiet hours: no scheduled briefs
    if hour < 6 or hour >= 23:
        print(f'[{now.strftime("%H:%M")}] Quiet hours — skipping')
        return

    brief_type = window_brief(hour)
    if not brief_type:
        # Between windows — still try to recover any earlier missed brief.
        recover_missed(now, current=None)
        print(f'[{now.strftime("%H:%M")}] No brief scheduled for this window')
        return

    # Recover earlier missed briefs first, then handle the current window.
    recover_missed(now, current=brief_type)

    if already_sent(brief_type):
        print(f'[{now.strftime("%H:%M")}] {brief_type} already sent today — skipping')
        return

    print(f'[{now.strftime("%H:%M")}] Composing {brief_type}...')
    ok = deliver(brief_type, now)
    if not ok:
        sys.exit(1)

if __name__ == '__main__':
    main()
