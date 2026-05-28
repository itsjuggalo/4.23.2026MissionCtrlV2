#!/home/itsju/.venv/bin/python3
"""Life Engine — standalone runner. Called by cron every 30 min."""
import json
import os
import re
import subprocess
import sys
import urllib.request
from datetime import datetime, timedelta, timezone

import pytz

# ── Config ──────────────────────────────────────────────────────────────────
ET = pytz.timezone('America/New_York')
SECRETS = os.path.expanduser('~/.openclaw/secrets')
STATE_FILE = os.path.expanduser('~/.life-engine-state.json')
CLAUDECLAW_DIR = '/home/itsju/claudeclaw-os'
PYTHON = '/home/itsju/.venv/bin/python3'
GMAIL = os.path.expanduser('~/.config/gmail/gmail.py')
GCAL  = os.path.expanduser('~/.config/calendar/gcal.py')

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
]

# ── Helpers ──────────────────────────────────────────────────────────────────
def secret(name):
    path = os.path.join(SECRETS, name)
    return open(path).read().strip() if os.path.exists(path) else None

def esc(text: str) -> str:
    """Escape text for Telegram HTML parse_mode."""
    return text.replace('&', '&amp;').replace('<', '&lt;').replace('>', '&gt;')

DISCORD_HOOKS = {
    'morning_brief':   'discord-webhook-morning-brief.txt',
    'midday_checkin':  'discord_midday_brief_webhook',
    'evening_summary': 'discord_eod_brief_webhook',
    'nightly_wrap':    'discord-webhook-nightly-brief.txt',
}

def send_telegram(message: str):
    token   = secret('lifeclaw_telegram_bot_token')
    chat_id = secret('lifeclaw_telegram_chat_id')
    if not token or not chat_id:
        print('Telegram: missing token/chat_id', file=sys.stderr)
        return False
    import urllib.parse
    encoded = urllib.parse.quote(message)
    url = f'https://api.telegram.org/bot{token}/sendMessage'
    data = f'chat_id={chat_id}&parse_mode=HTML&text={encoded}'.encode()
    try:
        resp = json.loads(urllib.request.urlopen(urllib.request.Request(url, data=data), timeout=10).read())
        return resp.get('ok', False)
    except Exception as e:
        print(f'Telegram error: {e}', file=sys.stderr)
        return False

def send_discord(brief_type: str, message: str):
    hook_file = DISCORD_HOOKS.get(brief_type)
    if not hook_file:
        return
    webhook_url = secret(hook_file)
    if not webhook_url:
        return
    webhook_url = webhook_url.replace('discordapp.com', 'discord.com')
    import re
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
    # Prune dated keys but always preserve non-date keys (tracked_bills, etc.)
    state = {k: v for k, v in state.items() if k >= cutoff or not k[:4].isdigit()}
    json.dump(state, open(STATE_FILE, 'w'), indent=2)

def already_sent(brief_type):
    today = datetime.now(ET).strftime('%Y-%m-%d')
    return load_state().get(today, {}).get(brief_type, False)

def mark_sent(brief_type):
    state = load_state()
    today = datetime.now(ET).strftime('%Y-%m-%d')
    state.setdefault(today, {})[brief_type] = True
    save_state(state)

def run(cmd, timeout=15):
    try:
        r = subprocess.run(cmd, shell=True, capture_output=True, text=True, timeout=timeout)
        return r.stdout.strip()
    except:
        return ''

# ── Email helpers ─────────────────────────────────────────────────────────────
_REAL_DEAL = re.compile(
    r'(\d+)\s*%\s*off|save\s+\$(\d+)|\$(\d+)\s+off|'
    r'code[:\s]+([A-Z0-9]{4,})|promo\s*code[:\s]+([A-Z0-9]{4,})',
    re.IGNORECASE
)
_AMOUNT_RE  = re.compile(r'\$\s*([\d,]+\.?\d*)')
_DUE_RE     = re.compile(
    r'due\s+(?:by\s+)?(?:on\s+)?'
    r'((?:jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec)\w*\.?\s+\d+|\d+/\d+)',
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

def _parse_bill(email):
    text = (email.get('subject', '') + ' ' + email.get('snippet', '')).lower()
    amount = due_date = None
    m = _AMOUNT_RE.search(text)
    if m:
        amount = f"${m.group(1)}"
    m = _DUE_RE.search(text)
    if m:
        due_date = m.group(1).strip()
    paid = any(k in text for k in _PAID_KW)
    return amount, due_date, paid

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

def track_bills(emails):
    """Upsert parsed bill info into state['tracked_bills']."""
    state = load_state()
    tracked = state.setdefault('tracked_bills', {})
    today = datetime.now(ET).strftime('%Y-%m-%d')
    for e in emails:
        name = _friendly_name(e)
        amount, due_date, paid = _parse_bill(e)
        existing = tracked.get(name, {})
        tracked[name] = {
            'amount':    amount    or existing.get('amount'),
            'due_date':  due_date  or existing.get('due_date'),
            'status':    'paid' if paid else existing.get('status', 'pending'),
            'added':     existing.get('added', today),
            'last_seen': today,
        }
    state['tracked_bills'] = tracked
    save_state(state)

def get_bill_reminders():
    """Bills from state due within 10 days or past due."""
    state   = load_state()
    tracked = state.get('tracked_bills', {})
    today   = datetime.now(ET).date()
    results = []
    for name, info in tracked.items():
        if info.get('status') == 'paid':
            continue
        due_str = info.get('due_date')
        if not due_str:
            continue
        for fmt in ('%b %d', '%b. %d', '%m/%d'):
            try:
                due = datetime.strptime(due_str.strip(), fmt).replace(year=today.year).date()
                if due < today:
                    due = due.replace(year=today.year + 1)
                days = (due - today).days
                if days <= 10:
                    results.append((name, info.get('amount'), due_str.strip(), days))
                break
            except ValueError:
                continue
    return sorted(results, key=lambda x: x[3])

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
        # For broad domains (robinhood, ebay), require a keyword hit too
        broad = any(s in frm for s in ('robinhood.com','ebay.com','amazon.com','walmart.com'))
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

# ── Brief composers ───────────────────────────────────────────────────────────
def morning_brief(now):
    date_str = now.strftime('%a %b %-d · %H:%M ET')

    # Calendar (both accounts, dedup)
    events = get_calendar('', 2) + get_calendar('personal', 2)
    seen, cal_events = set(), []
    for e in sorted(events, key=lambda x: x['start']):
        key = (e['summary'], e['start'][:16])
        if key not in seen:
            seen.add(key)
            cal_events.append(e)
    cal_lines = '\n'.join(fmt_event(e) for e in cal_events[:6]) or '  No events today'

    # Gmail (both accounts) — 3 buckets each
    i1, b1, c1 = get_gmail('',         hours=168)
    i2, b2, c2 = get_gmail('personal', hours=168)
    all_important = i1 + i2
    all_bills     = b1 + b2
    all_coupons   = c1 + c2

    # Track bills for reminder system
    track_bills(all_bills + all_important)

    # Bill reminders (upcoming / past due)
    reminders = get_bill_reminders()
    remind_lines = ''
    if reminders:
        parts = []
        for name, amount, due_str, days in reminders:
            amt = f" · {amount}" if amount else ''
            if days < 0:   flag = '🔴 PAST DUE'
            elif days == 0: flag = '🔴 DUE TODAY'
            elif days <= 3: flag = f'⚠️ due in {days}d'
            else:           flag = f'due {due_str}'
            parts.append(f"  └ {esc(name)}{esc(amt)} — {flag}")
        remind_lines = '\n'.join(parts)

    inbox_sections = ''
    if reminders:
        inbox_sections += f"  📋 <b>Bills Due Soon</b>:\n{remind_lines}\n"
    if all_important:
        alert_lines = '\n'.join(
            f"  └ {esc(_friendly_name(e))} — {esc(e.get('subject','')[:50])}"
            for e in all_important)
        inbox_sections += f"  🚨 <b>Alerts</b> ({len(all_important)}):\n{alert_lines}\n"
    if all_bills:
        bill_parts = []
        for b in all_bills:
            amount, due_date, paid = _parse_bill(b)
            name = _friendly_name(b)
            detail = ''
            if paid:          detail = ' — ✓ paid'
            elif due_date:    detail = f" — due {due_date}"
            if amount:        detail += f" · {amount}"
            bill_parts.append(f"  └ {esc(name)}{esc(detail)}")
        inbox_sections += f"  💸 <b>Bills</b>:\n" + '\n'.join(bill_parts) + '\n'
    if all_coupons:
        deal_parts = [f"  └ {esc(_deal_summary(c))}" for c in all_coupons]
        inbox_sections += f"  🎟 <b>Deals</b>:\n" + '\n'.join(deal_parts) + '\n'
    if not inbox_sections:
        inbox_sections = '  Inbox clear'

    # Trading
    boba  = get_alpaca('alpaca-boba-key-id',  'alpaca-boba-secret',  'Boba R2')
    jazzy = get_alpaca('alpaca-jazzy-key-id', 'alpaca-jazzy-secret', 'Jazzy')
    pm2   = esc(get_pm2())

    return f"""🌅 <b>LIFE ENGINE — Morning Brief</b> | {date_str}
━━━━━━━━━━━━━━━━━━━━━━━━━━━━

📅 <b>CALENDAR</b>
{cal_lines}

📧 <b>INBOX</b>
{inbox_sections.rstrip()}

📈 <b>TRADING</b> (paper)
  {boba}
  {jazzy}

🤖 Oracle PM2: {pm2}
━━━━━━━━━━━━━━━━━━━━━━━━━━━━"""

def midday_brief(now):
    time_str = now.strftime('%H:%M ET')
    boba  = get_alpaca('alpaca-boba-key-id',  'alpaca-boba-secret',  'Boba R2')
    jazzy = get_alpaca('alpaca-jazzy-key-id', 'alpaca-jazzy-secret', 'Jazzy')
    i1, _, _ = get_gmail('',         hours=6)
    i2, _, _ = get_gmail('personal', hours=6)
    alerts = i1 + i2
    inbox_line = f"  ⚡ {len(alerts)} alert{'s' if len(alerts)!=1 else ''} in inbox" if alerts else '  Inbox clear'
    events = get_calendar('', 1)
    next_evt = ''
    for e in events:
        try:
            evt_dt = datetime.fromisoformat(e['start']).astimezone(ET)
            if (evt_dt - now).total_seconds() < 7200:
                next_evt = f"\n  ⏰ Upcoming: {e['summary']} at {evt_dt.strftime('%H:%M')}"
                break
        except:
            pass
    return f"☀️ <b>MIDDAY</b> | {time_str}\n  {boba}\n  {jazzy}\n{inbox_line}{next_evt}"

def eod_brief(now):
    date_str = now.strftime('%a %b %-d')
    boba  = get_alpaca('alpaca-boba-key-id',  'alpaca-boba-secret',  'Boba R2')
    jazzy = get_alpaca('alpaca-jazzy-key-id', 'alpaca-jazzy-secret', 'Jazzy')
    pm2   = get_pm2()
    events = get_calendar('', 2) + get_calendar('personal', 2)
    seen, tomorrow = set(), []
    for e in sorted(events, key=lambda x: x['start']):
        key = (e['summary'], e['start'][:16])
        if key not in seen and e['start'][:10] > now.strftime('%Y-%m-%d'):
            seen.add(key)
            tomorrow.append(e)
    tmrw_lines = '\n'.join(fmt_event(e) for e in tomorrow[:3]) or '  Nothing scheduled'
    return f"""📊 <b>EOD WRAP</b> | {date_str}
  {boba}
  {jazzy}
  PM2: {pm2}

📅 <b>Tomorrow</b>
{tmrw_lines}"""

def nightly_brief(now):
    date_str = now.strftime('%a %b %-d')
    i1, b1, c1 = get_gmail('',         hours=168)
    i2, b2, c2 = get_gmail('personal', hours=168)
    all_important = i1 + i2
    all_bills     = b1 + b2
    all_coupons   = c1 + c2

    track_bills(all_bills + all_important)

    reminders = get_bill_reminders()
    remind_lines = ''
    if reminders:
        parts = []
        for name, amount, due_str, days in reminders:
            amt = f" · {amount}" if amount else ''
            if days < 0:    flag = '🔴 PAST DUE'
            elif days == 0: flag = '🔴 DUE TODAY'
            elif days <= 3: flag = f'⚠️ due in {days}d'
            else:           flag = f'due {due_str}'
            parts.append(f"  └ {esc(name)}{esc(amt)} — {flag}")
        remind_lines = '\n'.join(parts)

    inbox_sections = ''
    if reminders:
        inbox_sections += f"  📋 <b>Bills Due Soon</b>:\n{remind_lines}\n"
    if all_important:
        alert_lines = '\n'.join(
            f"  └ {esc(_friendly_name(e))} — {esc(e.get('subject','')[:50])}"
            for e in all_important)
        inbox_sections += f"  🚨 <b>Alerts</b> ({len(all_important)}):\n{alert_lines}\n"
    if all_bills:
        bill_parts = []
        for b in all_bills:
            amount, due_date, paid = _parse_bill(b)
            name = _friendly_name(b)
            detail = ''
            if paid:       detail = ' — ✓ paid'
            elif due_date: detail = f" — due {due_date}"
            if amount:     detail += f" · {amount}"
            bill_parts.append(f"  └ {esc(name)}{esc(detail)}")
        inbox_sections += f"  💸 <b>Bills</b>:\n" + '\n'.join(bill_parts) + '\n'
    if all_coupons:
        deal_parts = [f"  └ {esc(_deal_summary(c))}" for c in all_coupons]
        inbox_sections += f"  🎟 <b>Deals</b>:\n" + '\n'.join(deal_parts) + '\n'
    if not inbox_sections:
        inbox_sections = '  Inbox clear'

    events = get_calendar('', 2) + get_calendar('personal', 2)
    seen, tomorrow = set(), []
    for e in sorted(events, key=lambda x: x['start']):
        key = (e['summary'], e['start'][:16])
        if key not in seen and e['start'][:10] > now.strftime('%Y-%m-%d'):
            seen.add(key)
            tomorrow.append(e)
    tmrw_lines = '\n'.join(fmt_event(e) for e in tomorrow[:4]) or '  Nothing scheduled'
    return f"""🌙 <b>NIGHTLY</b> | {date_str}
📧 <b>INBOX</b>
{inbox_sections.rstrip()}

📅 <b>Tomorrow</b>
{tmrw_lines}"""

# ── Main ──────────────────────────────────────────────────────────────────────
def main():
    import argparse
    parser = argparse.ArgumentParser()
    parser.add_argument('--force', metavar='BRIEF_TYPE', default=None,
                        help='Force-send a specific brief, bypassing dedup check')
    args = parser.parse_args()

    now  = datetime.now(ET)
    hour = now.hour

    if args.force:
        brief_type = args.force
        print(f'[{now.strftime("%H:%M")}] --force {brief_type}: bypassing dedup')
    else:
        # Quiet hours: no scheduled briefs
        if hour < 6 or hour >= 23:
            print(f'[{now.strftime("%H:%M")}] Quiet hours — skipping')
            return

        # Determine which brief is due
        if 6 <= hour < 11:
            brief_type = 'morning_brief'
        elif 11 <= hour < 13:
            brief_type = 'midday_checkin'
        elif 15 <= hour < 18:
            brief_type = 'evening_summary'
        elif 20 <= hour < 23:
            brief_type = 'nightly_wrap'
        else:
            print(f'[{now.strftime("%H:%M")}] No brief scheduled for this window')
            return

        if already_sent(brief_type):
            print(f'[{now.strftime("%H:%M")}] {brief_type} already sent today — skipping')
            return

    print(f'[{now.strftime("%H:%M")}] Composing {brief_type}...')

    if brief_type == 'morning_brief':
        msg = morning_brief(now)
    elif brief_type == 'midday_checkin':
        msg = midday_brief(now)
    elif brief_type == 'evening_summary':
        msg = eod_brief(now)
    else:
        msg = nightly_brief(now)

    ok = send_telegram(msg)
    if ok:
        mark_sent(brief_type)
        print(f'[{now.strftime("%H:%M")}] {brief_type} sent via Telegram ✓')
        send_discord(brief_type, msg)
        print(f'[{now.strftime("%H:%M")}] {brief_type} mirrored to Discord ✓')
    else:
        print(f'[{now.strftime("%H:%M")}] Telegram send failed', file=sys.stderr)
        sys.exit(1)

if __name__ == '__main__':
    main()
