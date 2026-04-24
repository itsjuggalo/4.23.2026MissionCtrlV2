#!/usr/bin/env python3
"""CouponClaw v2 Site Monitor — Watch specific e-commerce sites for new coupons.
Runs as PM2 process, checks sites on configurable intervals.

PM2: pm2 start site_monitor.py --name coupon-monitor --interpreter python3
"""

import asyncio
import json
import os
import hashlib
import requests
from datetime import datetime
from dotenv import load_dotenv

from discovery import scrape_direct_site, _extract_codes_from_text, _valid_code
from validator import test_codes
from db import save_results, get_cached_results

load_dotenv()

SITES_FILE = os.path.join(os.path.dirname(__file__), "monitored_sites.json")
STATE_FILE = os.path.join(os.path.dirname(__file__), "monitor_state.json")
WEBHOOK_URL = os.getenv("DISCORD_WEBHOOK_URL", "")

# Default check interval: 4 hours
DEFAULT_INTERVAL = 4 * 60 * 60


def load_sites():
    """Load monitored sites config."""
    if os.path.exists(SITES_FILE):
        with open(SITES_FILE) as f:
            return json.load(f)
    # Default sites
    default = [
        {
            "name": "buy7tabz",
            "url": "https://buy7tabz.com",
            "coupon_pages": [
                "https://buy7tabz.com/discount",
                "https://buy7tabz.com/coupons",
                "https://buy7tabz.com/promo",
            ],
            "interval_hours": 4,
            "enabled": True,
        }
    ]
    with open(SITES_FILE, 'w') as f:
        json.dump(default, f, indent=2)
    return default


def load_state():
    try:
        with open(STATE_FILE) as f:
            return json.load(f)
    except:
        return {}


def save_state(state):
    with open(STATE_FILE, 'w') as f:
        json.dump(state, f, indent=2)


def send_webhook(content: str):
    if not WEBHOOK_URL:
        return
    try:
        chunks = [content[i:i+1900] for i in range(0, len(content), 1900)]
        for chunk in chunks:
            requests.post(WEBHOOK_URL, json={"content": chunk}, timeout=10)
    except Exception as e:
        print(f"[monitor] Webhook error: {e}")


async def check_site(site: dict, state: dict) -> dict:
    """Check a single site for new coupon codes."""
    name = site['name']
    url = site['url']
    site_state = state.get(name, {})
    known_codes = set(site_state.get('known_codes', []))

    print(f"[monitor] Checking {name} ({url})")

    # Scrape the site
    try:
        new_codes = await scrape_direct_site(name)
    except Exception as e:
        print(f"[monitor] Scrape error for {name}: {e}")
        return site_state

    # Also scrape specific coupon pages via requests
    for page_url in site.get('coupon_pages', []):
        try:
            headers = {
                'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36',
            }
            r = requests.get(page_url, headers=headers, timeout=10)
            if r.status_code == 200:
                page_codes = _extract_codes_from_text(r.text)
                new_codes.extend(page_codes)
        except:
            pass

    new_codes = list(set(c for c in new_codes if _valid_code(c)))

    if not new_codes:
        print(f"[monitor] {name}: no codes found")
        site_state['last_check'] = datetime.utcnow().isoformat()
        site_state['known_codes'] = list(known_codes)
        return site_state

    # Find truly new codes
    fresh = [c for c in new_codes if c not in known_codes]

    if fresh:
        print(f"[monitor] {name}: {len(fresh)} NEW codes found! Validating...")

        # Validate new codes
        try:
            results = await test_codes(name, fresh[:10])
            save_results(name, results, source='site-monitor')

            working = [r for r in results if r['status'] == 'success']
            failed = [r for r in results if r['status'] == 'failed']
            untested = [r for r in results if r['status'] not in ('success', 'failed')]

            # Discord notification
            notify = f"🔔 **CouponClaw Site Monitor — {name.title()}**\n"
            notify += f"🕐 {datetime.utcnow().strftime('%Y-%m-%d %H:%M UTC')}\n"
            notify += f"📊 {len(fresh)} new codes detected\n\n"

            if working:
                notify += "✅ **WORKING:**\n"
                for w in working:
                    notify += f"  `{w['code']}` — {w.get('discount') or 'discount applied'}\n"

            if untested:
                codes_str = ', '.join(f'`{c}`' for c in [u['code'] for u in untested[:5]])
            notify += f"\n❓ **Untested:** {codes_str}\n"

            if failed:
                notify += f"\n❌ **Failed:** {len(failed)} codes\n"

            send_webhook(notify)
            print(notify)

        except Exception as e:
            print(f"[monitor] Validation error for {name}: {e}")
            # Still save as untested
            save_results(name, [{"code": c, "status": "untested", "discount": None, "targeted": False} for c in fresh], source='site-monitor')
    else:
        print(f"[monitor] {name}: {len(new_codes)} codes, all already known")

    # Update state
    known_codes.update(new_codes)
    site_state['last_check'] = datetime.utcnow().isoformat()
    site_state['known_codes'] = list(known_codes)
    site_state['last_code_count'] = len(new_codes)
    site_state['last_new_count'] = len(fresh)

    return site_state


async def main():
    print(f"[monitor] CouponClaw Site Monitor starting at {datetime.utcnow().isoformat()}")

    while True:
        sites = load_sites()
        state = load_state()

        for site in sites:
            if not site.get('enabled', True):
                continue

            name = site['name']
            interval = site.get('interval_hours', 4) * 3600
            last_check = state.get(name, {}).get('last_check')

            # Check if it's time
            if last_check:
                elapsed = (datetime.utcnow() - datetime.fromisoformat(last_check)).total_seconds()
                if elapsed < interval:
                    remaining = int((interval - elapsed) / 60)
                    continue

            try:
                site_state = await check_site(site, state)
                state[name] = site_state
                save_state(state)
            except Exception as e:
                print(f"[monitor] Error checking {name}: {e}")

            # Rate limit between sites
            await asyncio.sleep(30)

        # Sleep 5 minutes between full cycles
        await asyncio.sleep(300)


if __name__ == "__main__":
    asyncio.run(main())
