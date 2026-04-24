#!/usr/bin/env python3
"""CouponClaw v2 Watchlist Scanner — Cron job to scan all watchlist merchants.
PM2: pm2 start cron_watchlist.py --name coupon-watchlist --interpreter python3 --cron "0 */6 * * *" --no-autorestart
"""

import asyncio
import json
import os
import requests
from datetime import datetime
from dotenv import load_dotenv

from discovery import find_candidate_codes
from validator import test_codes
from db import save_results, get_working_codes

load_dotenv()

WATCHLIST_FILE = os.path.join(os.path.dirname(__file__), "watchlist.json")
WEBHOOK_URL = os.getenv("DISCORD_WEBHOOK_URL", "")
LOGS_WEBHOOK = os.getenv("DISCORD_LOGS_WEBHOOK", "")


def load_watchlist():
    if os.path.exists(WATCHLIST_FILE):
        with open(WATCHLIST_FILE) as f:
            return json.load(f)
    return []


def send_webhook(url: str, content: str):
    if not url:
        return
    try:
        chunks = [content[i:i+1900] for i in range(0, len(content), 1900)]
        for chunk in chunks:
            requests.post(url, json={"content": chunk}, timeout=10)
    except Exception as e:
        print(f"[webhook] Error: {e}")


async def scan_merchant(merchant: str) -> dict:
    """Scan a single merchant: discover + validate."""
    print(f"[watchlist] Scanning: {merchant}")
    result = {"merchant": merchant, "codes_found": 0, "working": 0, "failed": 0, "untested": 0}

    try:
        codes = await find_candidate_codes(merchant)
        result["codes_found"] = len(codes)

        if not codes:
            return result

        # Validate top 10 codes
        test_results = await test_codes(merchant, codes[:10])
        save_results(merchant, test_results, source='watchlist-cron')

        for r in test_results:
            if r['status'] == 'success':
                result['working'] += 1
            elif r['status'] == 'failed':
                result['failed'] += 1
            else:
                result['untested'] += 1

    except Exception as e:
        print(f"[watchlist] Error scanning {merchant}: {e}")
        result['error'] = str(e)[:100]

    return result


async def main():
    watchlist = load_watchlist()
    if not watchlist:
        print("[watchlist] Empty watchlist, nothing to scan")
        return

    print(f"[watchlist] Starting scan of {len(watchlist)} merchants at {datetime.utcnow().isoformat()}")

    results = []
    new_working = []

    for merchant in watchlist:
        result = await scan_merchant(merchant)
        results.append(result)

        if result['working'] > 0:
            working_codes = get_working_codes(merchant)
            for wc in working_codes:
                new_working.append(f"✅ **{merchant.title()}**: `{wc['code']}` — {wc.get('discount_text') or 'working'}")

        # Rate limit between merchants
        await asyncio.sleep(10)

    # Summary
    total_found = sum(r['codes_found'] for r in results)
    total_working = sum(r['working'] for r in results)
    total_failed = sum(r['failed'] for r in results)

    summary = (
        f"📋 **CouponClaw Watchlist Scan Complete**\n"
        f"🕐 {datetime.utcnow().strftime('%Y-%m-%d %H:%M UTC')}\n"
        f"📊 {len(watchlist)} merchants · {total_found} codes found · {total_working} working · {total_failed} failed\n"
    )

    if new_working:
        summary += "\n🎉 **Working Codes:**\n" + "\n".join(new_working[:20])
    else:
        summary += "\n❌ No working codes found this scan"

    print(summary)

    # Send to Discord
    if WEBHOOK_URL:
        send_webhook(WEBHOOK_URL, summary)
    if LOGS_WEBHOOK:
        # Detailed log
        detail = "📋 **Scan Details:**\n"
        for r in results:
            icon = "✅" if r['working'] > 0 else "❌" if r['codes_found'] > 0 else "⬛"
            detail += f"{icon} **{r['merchant']}**: {r['codes_found']} found, {r['working']} working, {r['failed']} failed\n"
        send_webhook(LOGS_WEBHOOK, detail)


if __name__ == "__main__":
    asyncio.run(main())
