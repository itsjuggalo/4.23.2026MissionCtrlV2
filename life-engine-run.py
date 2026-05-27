#!/home/itsju/.venv/bin/python3
"""Life Engine — standalone runner. Called by cron every 30 min."""
import json
import os
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
             'utility','electric','gas bill','water bill','rent','subscription','renewal',
             'your receipt','charge','autopay','balance due','minimum payment']
COUPON_KW = ['coupon','promo code','discount','% off','save ','deal','offer',
             'free shipping','exclusive','limited time','flash sale','code:','get $','off your']

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
    today = datetime.now(ET).strftime('%Y-%m-%d')
    cutoff = (datetime.now(ET).date() - timedelta(days=7)).strftime('%Y-%m-%d')
    state = {k: v for k, v in state.items() if k >= cutoff}
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

# ── Data sources ─────────────────────────────────────────────────────────────
def get_gmail(account='', hours=168):
    flag = f'--account {account}' if account else ''
    raw = run(f'CLAUDECLAW_DIR={CLAUDECLAW_DIR} {PYTHON} {GMAIL} {flag} list --hours {hours}', timeout=25)
    try:
        emails = json.loads(raw)
    except:
        return [], []
    bills   = [e for e in emails if any(k.lower() in (e.get('subject','') + e.get('from','')).lower()   for k in BILL_KW)]
    coupons = [e for e in emails if any(k.lower() in (e.get('subject','') + e.get('snippet','')).lower() for k in COUPON_KW)]
    return bills[:5], coupons[:5]

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

    # Gmail (both accounts)
    b1, c1 = get_gmail('',         hours=168)
    b2, c2 = get_gmail('personal', hours=168)
    all_bills   = b1 + b2
    all_coupons = c1 + c2
    bill_lines   = '\n'.join(f"  └ {esc(b['from'][:35])} · {esc(b['subject'][:45])}" for b in all_bills[:3])   or '  none'
    coupon_lines = '\n'.join(f"  └ {esc(c['from'][:35])} · {esc(c['subject'][:45])}" for c in all_coupons[:3]) or '  none'

    # Trading
    boba  = get_alpaca('alpaca-boba-key-id',  'alpaca-boba-secret',  'Boba R2')
    jazzy = get_alpaca('alpaca-jazzy-key-id', 'alpaca-jazzy-secret', 'Jazzy')
    pm2   = esc(get_pm2())

    return f"""🌅 <b>LIFE ENGINE — Morning Brief</b> | {date_str}
━━━━━━━━━━━━━━━━━━━━━━━━━━━━

📅 <b>CALENDAR</b>
{cal_lines}

📧 <b>INBOX</b> (both accounts, 7d)
  Bills ({len(all_bills)}):
{bill_lines}
  Coupons ({len(all_coupons)}):
{coupon_lines}

📈 <b>TRADING</b> (paper)
  {boba}
  {jazzy}

🤖 Oracle PM2: {pm2}
━━━━━━━━━━━━━━━━━━━━━━━━━━━━"""

def midday_brief(now):
    time_str = now.strftime('%H:%M ET')
    boba  = get_alpaca('alpaca-boba-key-id',  'alpaca-boba-secret',  'Boba R2')
    jazzy = get_alpaca('alpaca-jazzy-key-id', 'alpaca-jazzy-secret', 'Jazzy')
    b1, _ = get_gmail('',         hours=6)
    b2, _ = get_gmail('personal', hours=6)
    urgent = b1 + b2
    inbox_line = f"  {len(urgent)} new since morning" if urgent else '  Inbox clear'
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
    b1, c1 = get_gmail('',         hours=168)
    b2, c2 = get_gmail('personal', hours=168)
    all_bills   = b1 + b2
    all_coupons = c1 + c2
    bill_lines   = '\n'.join(f"  └ {b['subject'][:50]}" for b in all_bills[:4])   or '  none'
    coupon_lines = '\n'.join(f"  └ {c['subject'][:50]}" for c in all_coupons[:3]) or '  none'
    events = get_calendar('', 2) + get_calendar('personal', 2)
    seen, tomorrow = set(), []
    for e in sorted(events, key=lambda x: x['start']):
        key = (e['summary'], e['start'][:16])
        if key not in seen and e['start'][:10] > now.strftime('%Y-%m-%d'):
            seen.add(key)
            tomorrow.append(e)
    tmrw_lines = '\n'.join(fmt_event(e) for e in tomorrow[:4]) or '  Nothing scheduled'
    return f"""🌙 <b>NIGHTLY</b> | {date_str}
  Bills ({len(all_bills)}):
{bill_lines}
  Coupons ({len(all_coupons)}):
{coupon_lines}

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
