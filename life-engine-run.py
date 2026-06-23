#!/home/itsju/.venv/bin/python3
"""Life Engine — standalone runner. Called by cron every 30 min.

LIFE-ONLY build (2026-06-13): deterministic template (always sends) + optional
AI focus line (augment-on-top, never blocks) + calendar + Gmail bills/coupons/
important + weather + todos + yesterday-memory + cross-day dedup + archive.
NO trading: P&L / Oracle-PM2 / flow-signal blocks were removed — Mike gets all
trading via the AInvest copilot + flow digests + breakout scanner on the
trading bots. LifeClaw stays the life lane, no overlap, no redundancy.
"""
import calendar as _calmod
import glob
import json
import os
import re
import shlex
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
WELLNESS_FILE = os.path.join(LIFECLAW_DIR, 'wellness.json')

# brief_type -> wellness slot + card glyph (sun for daytime, moon for night)
WELLNESS_SLOT = {'morning_brief': 'morning', 'midday_checkin': 'midday',
                 'evening_summary': 'evening', 'nightly_wrap': 'nightly'}
CARD_GLYPH = {'morning_brief': 'sun', 'midday_checkin': 'sun',
              'evening_summary': 'moon', 'nightly_wrap': 'moon'}

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
    # Trading lives on the pipeline/Boba/Jazzy bots — keep ALL of it off LifeClaw
    'mailer.alpaca.markets','alpaca.markets','robinhood.com','coinbase.com',
    'public.com','webull.com','tdameritrade.com','schwab.com',
    'nextdoor.com','email.nextdoor.com','ss.email.nextdoor.com','is.email.nextdoor.com',
    'muvfl.com','eml.muvfl.com',
]

# Senders that are always important — surface regardless of keywords
IMPORTANT_SENDERS = [
    'commerce.fl.gov','floridajobs.org','speedpay.com',
    'informeddelivery.usps.com',
    'e.chase.com','mcmap.chase.com',
    'bankofamerica.com','wellsfargo.com',
    'trulieve.com','ups.com','fedex.com',
    'walmart.com','ebay.com','siriusxm.com',
    'amazon.com',
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
    # eBay account activity only
    'you sold','item sold','bid won','purchase confirmed',
    'payment received','payment sent','your listing',
    'case opened','refund','feedback left',
    # Account security
    'sign-in attempt','new device','unusual activity',
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

def send_telegram_photo(path: str, caption: str = '') -> bool:
    """Send a photo to the LifeClaw bot. Plain-text caption. Best-effort."""
    token   = secret('lifeclaw_telegram_bot_token')
    chat_id = secret('lifeclaw_telegram_chat_id')
    if not token or not chat_id or not path or not os.path.exists(path):
        return False
    cap = re.sub(r'<[^>]+>', '', caption)[:1000]
    url = f'https://api.telegram.org/bot{token}/sendPhoto'
    cmd = ('curl -s '
           f'-F {shlex.quote("chat_id=" + str(chat_id))} '
           f'-F {shlex.quote("photo=@" + path)} '
           f'-F {shlex.quote("caption=" + cap)} '
           f'{shlex.quote(url)}')
    out = run(cmd, timeout=30)
    try:
        return json.loads(out).get('ok', False)
    except Exception:
        return False

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
               'payment processed','successfully paid','autopay processed',
               'you sent','receipt for your payment','sent a payment','payment to']
# Payment processors — a receipt from these naming the merchant counts as paid.
_PROCESSOR_DOMAINS = ['paypal.com', 'intuit.com', 'venmo.com',
                      'chase.com', 'bankofamerica.com', 'wellsfargo.com']

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
    # Flip paid status when a payment-confirmation is seen. Two ways:
    #   1. direct  — email FROM the payee domain with a paid keyword
    #   2. processor — email FROM a processor (PayPal/card) that NAMES the
    #      merchant (bill name or a paid_alias). PayPal receipts come from
    #      paypal.com, never the merchant's domain, so #1 alone never fired
    #      for PayPal-paid bills (e.g. Duke Energy). See bills.json notes.
    flipped = False
    for b in bills:
        dom = (b.get('payee_domain') or '').lower()
        names = [b['name'].lower()] + [a.lower() for a in (b.get('paid_aliases') or [])]
        for e in emails:
            frm = e.get('from', '').lower()
            txt = (e.get('subject', '') + ' ' + e.get('snippet', '')).lower()
            has_paid_kw = any(k in txt for k in _PAID_KW)
            direct = dom and dom in frm and has_paid_kw
            processor = (any(p in frm for p in _PROCESSOR_DOMAINS)
                         and any(n in txt for n in names))
            if direct or processor:
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
    if b['autopay']:
        # autopay is never "past due" — it charges itself on/after the due day
        if b['days'] < 0:
            return f"{b['name']} — autopay {ordn}{amt} ✓ auto-charged"
        return f"{b['name']} — autopay {ordn}{amt}"
    if b['days'] < 0:
        return f"🔴 {b['name']} — PAST DUE (was {ordn}){amt}"
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
            'ebay.com','amazon.com','walmart.com','trulieve.com'))
        if (sender_match and not broad) or (broad and kw_match) or (not broad and kw_match):
            important.append(e)
        elif any(k in subj + ' ' + frm for k in BILL_KW):
            bills.append(e)
        elif any(k in subj + ' ' + snip for k in COUPON_KW) and _is_real_deal(e):
            coupons.append(e)
    return _dedup_by_sender(important)[:8], _dedup_by_sender(bills)[:5], _dedup_by_sender(coupons)[:3]

def _gmail_accounts():
    """Account slots LifeClaw scans — from config 'gmail_accounts' (default: primary + personal).
    '' = primary (token.json), 'personal' = token_personal.json. Add a 3rd slot:
      1) gmail.py --account <name> auth   (interactive OAuth, mints token_<name>.json)
      2) add '<name>' to ~/.lifeclaw/config.json -> gmail_accounts
    No code edit needed — Gmail AND calendar then cover it everywhere."""
    try:
        accts = json.load(open(CONFIG_FILE)).get('gmail_accounts')
        if isinstance(accts, list) and accts:
            return accts
    except Exception:
        pass
    return ['', 'personal']

def get_gmail_all(hours):
    """Aggregate important / bills / coupons across every configured Gmail account."""
    imp, bills, coup = [], [], []
    for acct in _gmail_accounts():
        i, b, c = get_gmail(acct, hours=hours)
        imp += i; bills += b; coup += c
    return imp, bills, coup

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
    events = []
    for acct in _gmail_accounts():
        events += get_calendar(acct, days)
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

def fmt_event(e):
    start = e['start'][11:16] if 'T' in e['start'] else e['start']
    return f"  {start}  {esc(e['summary'])}"

# ── Wellness (ADD-friendly body/mind nudges — additive, never blocks) ─────────
# Hardcoded fallback so a missing/broken wellness.json never kills the brief.
_WELLNESS_FALLBACK = {
    'quotes': {'morning': ['Progress over perfection.'],
               'midday': ['Pause. Breathe. Reset. You’re doing fine.'],
               'evening': ['What got done today is enough.'],
               'nightly': ['Sleep is the best recovery there is.']},
    'hydration': ['Drink a full glass of water.'],
    'sun': ['Get a few minutes of sunlight on your face.'],
    'body': {'morning': ['Neck rolls + shoulder drops to wake up.'],
             'midday': ['Posture reset: shoulders down and back, chin level.'],
             'evening': ['Gentle stretch — let the shoulders come down.'],
             'nightly': ['Long slow exhales to downshift for sleep.']},
    'adhd': {'morning': ['Pick ONE anchor task for today. Just one.'],
             'midday': ['Name the ONE thing that matters most right now.'],
             'evening': ['Brain-dump tomorrow’s to-dos so they stop renting space.'],
             'nightly': ['Phone on the charger across the room.']},
}

def load_wellness():
    try:
        data = json.load(open(WELLNESS_FILE))
        return data if isinstance(data, dict) else _WELLNESS_FALLBACK
    except Exception:
        return _WELLNESS_FALLBACK

def _pick(lst, idx):
    return lst[idx % len(lst)] if lst else None

def _pick_slot(d, slot, idx):
    """d may be {slot: [...]} or a flat list."""
    lst = d.get(slot, []) if isinstance(d, dict) else d
    return _pick(lst, idx)

def select_wellness(brief_type, now):
    """Deterministic per-day pick (rotates by day-of-year, reproducible)."""
    w = load_wellness()
    slot = WELLNESS_SLOT.get(brief_type, 'morning')
    base = now.timetuple().tm_yday          # day of year → daily rotation
    quote = _pick_slot(w.get('quotes', {}), slot, base)
    body  = _pick_slot(w.get('body', {}),   slot, base + 1)
    adhd  = _pick_slot(w.get('adhd', {}),   slot, base + 2)
    hydration = _pick(w.get('hydration', []), base)
    sun       = _pick(w.get('sun', []),       base + 1)
    # George Carlin "comms intercept" — different line per slot, rotates daily.
    _slot_off = {'morning': 0, 'midday': 1, 'evening': 2, 'nightly': 3}.get(slot, 0)
    carlin = _pick(w.get('carlin', []), base + _slot_off)
    # Compose the nudge list by time of day.
    if slot == 'morning':
        nudges = [hydration, sun, body, adhd]
    elif slot == 'midday':
        nudges = [body, hydration, adhd]
    elif slot == 'evening':
        nudges = [body, adhd]
    else:  # nightly
        nudges = [body, adhd]
    return {
        'quote': quote,
        'carlin': carlin,
        'nudges': [n for n in nudges if n],
        'glyph': CARD_GLYPH.get(brief_type, 'leaf'),
        'slot': slot,
    }

# ── Context object (Step 2) ───────────────────────────────────────────────────
def gather_context(brief_type, now, persist):
    cfg = load_config()
    ctx = {
        'brief_type': brief_type, 'now': now, '_cfg': cfg,
        'calendar': [], 'cal_conflicts': set(), 'cal_prep': None,
        'alerts': [], 'deals': [], 'bills': [], 'weather': None,
        'todos': [], 'yesterday': {'title': None, 'raw': ''}, 'commitments': [],
    }

    # LIFE-ONLY (2026-06-13): trading P&L / Oracle PM2 / flow signals removed from
    # every brief — Mike gets all trading via the AInvest copilot + flow digests +
    # breakout scanner on the trading bots. LifeClaw = life lane only, no overlap.
    if brief_type == 'morning_brief':
        ctx['calendar'] = _calendar_merged(2)
        ctx['cal_conflicts'], ctx['cal_prep'] = cal_smarts(ctx['calendar'], now)
        important, _, coupons = get_gmail_all(168)
        ctx['alerts'] = filter_new(important, 'email', now, persist, _email_key)
        ctx['deals']  = coupons[:3]
        ctx['bills']  = get_bills(now, important, persist)
        ctx['weather'] = get_weather(cfg)
        ctx['todos']  = get_todos(cfg)
        ctx['yesterday'], ctx['commitments'] = get_yesterday(cfg, now)
        ctx['debt_report'] = get_debt_report()

    elif brief_type == 'midday_checkin':
        important, _, _ = get_gmail_all(6)
        ctx['alerts'] = filter_new(important, 'email', now, persist, _email_key)
        ctx['calendar'] = get_calendar('', 1)
        ctx['cal_conflicts'], ctx['cal_prep'] = cal_smarts(ctx['calendar'], now)

    elif brief_type == 'evening_summary':
        # forward-looking: tomorrow's plan + anything needing action tonight
        ctx['calendar'] = _calendar_merged(2)
        ctx['cal_conflicts'], ctx['cal_prep'] = cal_smarts(ctx['calendar'], now)
        important, _, _ = get_gmail_all(12)
        ctx['alerts'] = filter_new(important, 'email', now, persist, _email_key)
        ctx['bills']  = get_bills(now, important, persist)
        ctx['debt_report'] = get_debt_report()

    else:  # nightly_wrap
        important, _, coupons = get_gmail_all(168)
        ctx['alerts'] = filter_new(important, 'email', now, persist, _email_key)
        ctx['deals']  = coupons[:3]
        ctx['bills']  = get_bills(now, important, persist)
        ctx['calendar'] = _calendar_merged(2)
        ctx['weather'] = get_weather(cfg)
        ctx['todos']  = get_todos(cfg)
        ctx['yesterday'], ctx['commitments'] = get_yesterday(cfg, now)

    # Body & Mind nudges — runs for every brief type (additive, never blocks).
    ctx['wellness'] = select_wellness(brief_type, now)
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
def get_debt_report():
    """Load the debt-payoff plan (debt_planner.build). Fully guarded — any failure
    returns None so the brief never breaks. Off-switch: LIFE_DEBTS=0."""
    try:
        if os.environ.get('LIFE_DEBTS') == '0':
            return None
        import sys as _sys
        if '/home/itsju/05_AUTOMATION' not in _sys.path:
            _sys.path.insert(0, '/home/itsju/05_AUTOMATION')
        import debt_planner
        d = debt_planner.load()
        if not [x for x in d.get('debts', []) if (x.get('balance') or 0) > 0]:
            return None
        return debt_planner.build(d)
    except Exception:
        return None


def _render_debts(ctx):
    """💳 DEBT PAYOFF — additive, fully guarded (never breaks a brief). RH buying
    power shown as available CASH (life cash-flow), not a trading signal."""
    rep = ctx.get('debt_report')
    if not rep or not rep.get('debts'):
        return ''
    try:
        def m(v):
            return '—' if v in (None, '') else f"${v:,.0f}"
        L = []
        burn = f" · ~{m(rep['monthly_burn'])}/mo interest" if rep.get('monthly_burn') else ''
        names = ', '.join(x['creditor'] for x in rep['debts'])
        L.append(f"  └ Total: {m(rep['total_debt'])} ({esc(names)}){burn}")
        rh = rep.get('rh_buying_power') or {}
        if rh.get('needs_relogin'):
            L.append("  └ RH buying power: <i>relogin to refresh</i>")
        elif rh.get('value') is not None:
            tag = '' if rh.get('live') else f" (last {rh.get('as_of')})"
            cashtag = f" · cash {m(rh['cash'])}" if rh.get('cash') is not None else ''
            L.append(f"  └ RH buying power: {m(rh['value'])}{cashtag}{tag}")
        tr = rep.get('truist_checking') or {}
        if tr.get('value') is not None:
            L.append(f"  └ Truist checking: {m(tr['value'])}")
        p = (rep.get('scenarios') or {}).get('planned') or {}
        if p and not p.get('never') and p.get('months') is not None:
            mo = p['months']
            mos = f"{mo} mo" if mo < 24 else f"{mo // 12}y {mo % 12}m"
            L.append(f"  └ Plan ({rep['strategy']} +{m(rep['monthly_extra'])}/mo): "
                     f"debt-free ~{mos}, {m(p['total_interest'])} interest")
        nd = rep.get('next_due')
        if nd and nd.get('due_day'):
            L.append(f"  └ Next: {esc(nd['creditor'])} min {m(nd['min_payment'])} due the {nd['due_day']}th")
        return "\n💳 <b>DEBT PAYOFF</b>\n" + '\n'.join(L) + "\n"
    except Exception:
        return ''


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

def _render_body_mind(ctx):
    """Quote + body/mind nudges block (shared by all briefs)."""
    w = ctx.get('wellness') or {}
    out = ''
    if w.get('quote'):
        out += f"\n💬 <i>{esc(w['quote'])}</i>\n"
    if w.get('nudges'):
        nl = '\n'.join(f"  • {esc(n)}" for n in w['nudges'])
        out += f"\n🌿 <b>BODY &amp; MIND</b>\n{nl}\n"
    if w.get('carlin'):
        out += f"\n📡 <b>COMMS INTERCEPT // CARLIN</b>\n  <i>“{esc(w['carlin'])}”</i>\n"
    return out

def _render_web(ctx):
    """🌐 free web finds — live coupons for inbox brands + next calendar-event prep.
    Additive + fully guarded (never breaks a brief); capped searches. Off-switch: LIFE_WEB=0."""
    try:
        from lib.life_web import web_finds_block
        brands = [nm for c in (ctx.get('deals') or []) if (nm := _friendly_name(c))]
        events = [e.get('summary', '') for e in (ctx.get('calendar') or [])[:2] if e.get('summary')]
        cfg = ctx.get('_cfg') or {}
        wx = cfg.get('weather') if isinstance(cfg.get('weather'), dict) else {}
        city = (wx.get('location') or wx.get('city') or cfg.get('location') or '') if isinstance(wx, dict) else ''
        block = web_finds_block(brands=brands, events=events, city=city)
        if block:
            body = '\n'.join(f"  {esc(l)}" for l in block.split('\n'))
            return f"\n🌐 <b>WEB FINDS</b>\n{body}\n"
    except Exception:
        pass
    return ''

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
{_render_debts(ctx)}{_render_life(ctx)}{_render_web(ctx)}{_render_body_mind(ctx)}━━━━━━━━━━━━━━━━━━━━━━━━━━━━"""

    if brief_type == 'midday_checkin':
        time_str = now.strftime('%H:%M ET')
        alerts = ctx['alerts']
        inbox_line = (f"  ⚡ {len(alerts)} new alert{'s' if len(alerts)!=1 else ''} in inbox"
                      if alerts else '  Inbox clear')
        next_evt = f"\n  ⏰ Upcoming: {esc(ctx['cal_prep'])}" if ctx['cal_prep'] else ''
        return f"☀️ <b>MIDDAY</b> | {time_str}\n{inbox_line}{next_evt}\n{_render_body_mind(ctx)}"

    if brief_type == 'evening_summary':
        date_str = now.strftime('%a %b %-d')
        tmrw = _tomorrow_events(ctx, now, 3)
        tmrw_lines = '\n'.join(fmt_event(e) for e in tmrw) or '  Nothing scheduled'
        inbox = _render_inbox(ctx)
        inbox_block = f"\n📧 <b>NEEDS ACTION</b>\n{inbox}\n" if inbox != '  Inbox clear' else ''
        return f"""📊 <b>EVENING — plan tomorrow</b> | {date_str}
{inbox_block}{_render_debts(ctx)}
📅 <b>Tomorrow</b>
{tmrw_lines}
{_render_web(ctx)}{_render_body_mind(ctx)}"""

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
{tmrw_lines}
{_render_web(ctx)}{_render_body_mind(ctx)}"""

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
        'weather': ctx['weather'],
    }

def _clean_focus_line(text):
    """One plain-text line: first non-empty line, tags/quotes stripped, ≤200 chars."""
    line = next((l.strip() for l in (text or '').splitlines() if l.strip()), '')
    line = re.sub(r'<[^>]+>', '', line).strip().strip('"').strip()
    return line[:200] or None


def render_focus_line(brief_type, ctx, cfg):
    """Return one plain-text focus line, or None on any failure/timeout.

    Fast path (2026-06-15): the same subscription/OAuth chain the trading briefs use —
    lib.llm.call_llm(["claude_oauth","deepseek"]) talks DIRECTLY to api.anthropic.com
    (~2s) instead of cold-starting the Node `claude` CLI, which was timing out at the
    60s cron limit (see life-engine.log "LLM focus error … timed out after 60 seconds").
    Bills the claude.ai sub, not API credits. The CLI stays as a last-ditch fallback so an
    OAuth/network hiccup can't regress us below the previous behaviour. Never blocks the
    brief — any failure just drops the focus line (the deterministic template still sends)."""
    persona = cfg.get('persona', DEFAULT_CONFIG['persona'])
    blob = json.dumps(_ctx_for_llm(ctx), ensure_ascii=False, default=str)
    rules = (
        "Name the single most important thing Mike should act on right now in ONE line "
        "(max 140 characters, plain text, no markdown, no emoji, no quotes). "
        "Use ONLY facts in the JSON — never invent names, numbers, or events. "
        "This is a LIFE briefing: NEVER mention trading, stocks, options, P&L, portfolio, "
        "Boba, Jazzy, Alpaca, markets, or system/PM2 health — those live elsewhere. "
        "If nothing life-relevant is urgent, say so plainly (e.g. 'Nothing pressing — "
        "calendar clear, no unpaid bills due soon.')."
    )
    head = (f"{persona}\n\n"
            f"This is the {brief_type.replace('_',' ')}. Everything you know right now (JSON):\n"
            f"{blob}\n\n")

    # Fast subscription/OAuth path — ask for strict JSON so lib.llm can parse it.
    try:
        sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
        from lib.llm import call_llm
        jprompt = head + rules + '\n\nReturn STRICT JSON only: {"focus": "<the one line>"}'
        res = call_llm(jprompt, ['claude_oauth', 'claude_cli', 'grok_oauth'])
        if res.get('ok'):
            line = _clean_focus_line(str((res['response'] or {}).get('focus', '')))
            if line:
                return line
        else:
            print(f"LLM focus chain failed: {res.get('error','')[:160]}", file=sys.stderr)
    except Exception as e:  # noqa: BLE001
        print(f'LLM focus fast-path error: {e}', file=sys.stderr)

    # Last-ditch fallback: the original plain-text CLI call (slow, but never worse than before).
    prompt = head + rules
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
    return _clean_focus_line(r.stdout)

# ── Visual card (warm spa/wellness dark PNG — additive, never blocks) ─────────
_CARD_TITLES = {'morning_brief': 'Good Morning, Mike', 'midday_checkin': 'Midday Reset',
                'evening_summary': 'Wind Down', 'nightly_wrap': 'Good Night, Mike'}
_CARD_BODY_LABEL = {'morning': 'Body & Mind', 'midday': 'Body Reset',
                    'evening': 'Let The Body Settle', 'nightly': 'Before Sleep'}
_CARD_CTX_LABEL = {'morning_brief': 'Today', 'midday_checkin': 'Coming Up',
                   'evening_summary': 'Set Up Tomorrow', 'nightly_wrap': 'Tomorrow'}
_CARD_FOOTER = {'morning': 'LifeClaw · your daily corner', 'midday': 'LifeClaw · keep it smooth',
                'evening': 'LifeClaw · soft landing', 'nightly': 'LifeClaw · rest well'}

def _card_context_items(brief_type, ctx):
    """1–3 short plain-text life lines (events, bills) for the card."""
    items, now = [], ctx['now']
    cal = ctx.get('calendar') or []
    if brief_type in ('evening_summary', 'nightly_wrap'):
        for e in _tomorrow_events(ctx, now, 2):
            start = e['start'][11:16] if 'T' in e['start'] else 'all day'
            items.append(f"{start}  {e['summary']}")
    else:
        today = now.strftime('%Y-%m-%d')
        for e in sorted(cal, key=lambda x: x['start']):
            if e['start'][:10] == today and 'T' in e['start']:
                items.append(f"{e['start'][11:16]}  {e['summary']}")
            if len(items) >= 2:
                break
    for b in (ctx.get('bills') or []):
        if not b['is_paid'] and not b['autopay'] and 0 <= b['days'] <= 5:
            items.append(f"{b['name']} — due in {b['days']}d")
            break
    out = [re.sub(r'<[^>]+>', '', str(i)).strip() for i in items if i]
    return out[:3]

def _card_spec(brief_type, ctx):
    w = ctx.get('wellness') or {}
    slot = w.get('slot', 'morning')
    sections = []
    if w.get('nudges'):
        sections.append({'label': _CARD_BODY_LABEL.get(slot, 'Body & Mind'),
                         'items': w['nudges']})
    ctx_items = _card_context_items(brief_type, ctx)
    if ctx_items:
        sections.append({'label': _CARD_CTX_LABEL.get(brief_type, 'Today'),
                         'items': ctx_items})
    return {
        'glyph': w.get('glyph', 'leaf'),
        'title': _CARD_TITLES.get(brief_type, 'LifeClaw'),
        'date': ctx['now'].strftime('%A, %B %-d · %-I:%M %p ET'),
        'quote': w.get('quote'),
        'carlin': w.get('carlin'),
        'weather': ctx.get('weather'),
        'brief_type': brief_type,
        'slot': slot,
        'day_seed': ctx['now'].timetuple().tm_yday,   # (kept for rail/bracket variation)
        'theme': 'WARM SLATE',                        # PIN: daylight-readable, no dark-faction rotation
        # Solid warm-slate panels (procedural) read in any light; dark AI art backgrounds undercut
        # that, so L&W opts out of 'hybrid'. Flip to load_config card_style to bring the art back.
        'card_style': 'procedural',
        'sections': sections,
        'footer': _CARD_FOOTER.get(slot, 'LifeClaw · your daily corner'),
    }

def _avail_mb():
    try:
        for line in open('/proc/meminfo'):
            if line.startswith('MemAvailable:'):
                return int(line.split()[1]) // 1024
    except Exception:
        return None
    return None

def _maybe_bg(spec, style):
    """Optional AI (ComfyUI) StarCraft background; None → procedural fallback.
    Never raises, never blocks the brief. 'hybrid' only attempts when RAM is roomy."""
    try:
        avail = _avail_mb()
        if style == 'hybrid' and avail is not None and avail < 11000:
            return None  # too tight — fall back to procedural HUD
        if LIFECLAW_DIR not in sys.path:
            sys.path.insert(0, LIFECLAW_DIR)
        import gen_bg
        return gen_bg.generate(spec.get('day_seed', 0), spec.get('slot', 'morning'))
    except Exception as e:
        print(f'bg gen skipped: {e}', file=sys.stderr)
        return None

def make_card(brief_type, ctx, now):
    """Render the brief's PNG card. Returns path or None (never raises)."""
    try:
        if LIFECLAW_DIR not in sys.path:
            sys.path.insert(0, LIFECLAW_DIR)
        import render_card
        spec = _card_spec(brief_type, ctx)
        style = spec.get('card_style', 'procedural')
        if style in ('ai', 'hybrid'):
            bg = _maybe_bg(spec, style)
            if bg:
                spec['bg_image'] = bg
        out = os.path.join(LIFECLAW_DIR, 'cards',
                           f'{brief_type}-{now.strftime("%Y-%m-%d")}.png')
        return render_card.render_card(spec, out)
    except Exception as e:
        print(f'card build error: {e}', file=sys.stderr)
        return None

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
    return msg, source, ctx

def archive(brief_type, source, text, now):
    try:
        os.makedirs(LIFECLAW_DIR, exist_ok=True)
        rec = {'ts': now.isoformat(), 'brief_type': brief_type, 'source': source, 'text': text}
        with open(ARCHIVE_FILE, 'a') as f:
            f.write(json.dumps(rec, ensure_ascii=False) + '\n')
    except Exception as e:
        print(f'Archive error: {e}', file=sys.stderr)

# Per-slot quick-action buttons under each brief card. callback_data "lw:<action>" is
# acked + logged by lifeclaw_bot.py (the life_wellness poller) to wellness_interactions.jsonl.
LW_BRIEF_BUTTONS = {
    'morning_brief':   [[{"text": "✓ Done", "callback_data": "lw:done:morning"},
                         {"text": "💧 Hydrate", "callback_data": "lw:hydrate"}],
                        [{"text": "🌞 Step outside", "callback_data": "lw:outside"}]],
    'midday_checkin':  [[{"text": "✓ Check in", "callback_data": "lw:checkin"},
                         {"text": "💧 Hydrate", "callback_data": "lw:hydrate"}],
                        [{"text": "⏰ 20-min break", "callback_data": "lw:break"}]],
    'evening_summary': [[{"text": "✓ Plan tomorrow", "callback_data": "lw:plan"},
                         {"text": "📝 Log mood", "callback_data": "lw:mood"}],
                        [{"text": "🔔 Bedtime", "callback_data": "lw:bedtime"}]],
    'nightly_wrap':    [[{"text": "😴 Goodnight", "callback_data": "lw:goodnight"},
                         {"text": "🔔 Set alarm", "callback_data": "lw:alarm"}]],
}


def deliver(brief_type, now):
    """Compose + send live. Returns True on Telegram success.

    Visual card (if cards_enabled) leads the brief; it is best-effort and
    NEVER blocks the text — if the card fails the text brief still sends.
    """
    msg, source, ctx = compose(brief_type, now, preview=False)
    cfg = ctx['_cfg']
    if cfg.get('cards_enabled'):
        card = make_card(brief_type, ctx, now)
        sent_card = False
        if card:
            try:   # photo + tappable quick-action buttons (vault-backed life_wellness)
                sys.path.insert(0, '/home/itsju/05_AUTOMATION/scripts')
                from lib.tg_wellness_card import send_card_with_buttons
                sent_card = send_card_with_buttons(
                    card, _CARD_TITLES.get(brief_type, 'LifeClaw'),
                    LW_BRIEF_BUTTONS.get(brief_type))
            except Exception as e:
                print(f'card+buttons send error: {e}', file=sys.stderr)
            if not sent_card:   # fallback: plain photo, no buttons
                sent_card = send_telegram_photo(card, _CARD_TITLES.get(brief_type, 'LifeClaw'))
        if sent_card:
            print(f'[{now.strftime("%H:%M")}] {brief_type} card sent ✓')
            source += '+card'
        elif card:
            print(f'[{now.strftime("%H:%M")}] {brief_type} card render OK, send failed',
                  file=sys.stderr)
        else:
            print(f'[{now.strftime("%H:%M")}] {brief_type} card unavailable — text only',
                  file=sys.stderr)
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
            msg, source, _ = compose(bt, now, preview=False)
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
        msg, source, _ = compose(bt, now, preview=True)
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
