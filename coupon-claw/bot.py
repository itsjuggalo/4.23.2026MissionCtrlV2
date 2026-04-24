#!/usr/bin/env python3
"""CouponClaw v2 Discord Bot — find, validate, and track coupon codes."""

import discord
import asyncio
import json
import os
import sys
import requests
from datetime import datetime
from dotenv import load_dotenv

from discovery import find_candidate_codes
from validator import test_codes
from db import save_results, get_cached_results, get_stats, get_working_codes
from formatter import format_response, format_validation_results

load_dotenv()

intents = discord.Intents.default()
intents.message_content = True
client = discord.Client(intents=intents)

REQUEST_CHANNEL_ID   = int(os.getenv("REQUEST_CHANNEL_ID",  "1491237778791465092"))
LOGS_CHANNEL_ID      = int(os.getenv("LOGS_CHANNEL_ID",     "1491237848823631892"))
WATCHLIST_CHANNEL_ID = int(os.getenv("WATCHLIST_CHANNEL_ID", "1491237939483770920"))
WEBHOOK_URL          = os.getenv("DISCORD_WEBHOOK_URL", "")

WATCHLIST_FILE = os.path.join(os.path.dirname(__file__), "watchlist.json")


def _load_watchlist():
    if os.path.exists(WATCHLIST_FILE):
        with open(WATCHLIST_FILE) as f:
            return json.load(f)
    return []


def _save_watchlist(wl):
    with open(WATCHLIST_FILE, "w") as f:
        json.dump(wl, f, indent=2)


def send_webhook(content: str):
    """Send notification via Discord webhook."""
    if not WEBHOOK_URL:
        return
    try:
        # Discord webhook max is 2000 chars
        chunks = [content[i:i+1900] for i in range(0, len(content), 1900)]
        for chunk in chunks:
            requests.post(WEBHOOK_URL, json={"content": chunk}, timeout=10)
    except Exception as e:
        print(f"[webhook] Error: {e}")


@client.event
async def on_ready():
    print(f"CouponClaw v2 online as {client.user}")
    print(f"  Request channel: {REQUEST_CHANNEL_ID}")
    print(f"  Logs channel: {LOGS_CHANNEL_ID}")
    print(f"  Watchlist channel: {WATCHLIST_CHANNEL_ID}")


@client.event
async def on_message(message):
    if message.author.bot:
        return

    # ── #coupon-request ──────────────────────────────────────────────────
    if message.channel.id == REQUEST_CHANNEL_ID:
        text = message.content.strip().lower()

        # Help command
        if text in ('help', '!help', '/help'):
            await message.channel.send(
                "🎟️ **CouponClaw v2 Commands:**\n"
                "• `merchant name` — Search & validate codes for a merchant\n"
                "• `verify merchant` — Re-validate all cached codes\n"
                "• `working` — Show all working codes across merchants\n"
                "• `stats` — Show database statistics\n"
                "• `help` — This message"
            )
            return

        # Stats command
        if text == 'stats':
            stats = get_stats()
            await message.channel.send(
                f"📊 **CouponClaw Stats:**\n"
                f"Total codes: {stats['total_codes']}\n"
                f"Working codes: {stats['working_codes']}\n"
                f"Failed codes: {stats['failed_codes']}\n"
                f"Untested codes: {stats['untested_codes']}\n"
                f"Merchants tracked: {stats['merchants']}\n"
                f"Tests run: {stats['total_tests']}"
            )
            return

        # Working codes command
        if text == 'working':
            working = get_working_codes()
            if not working:
                await message.channel.send("❌ No working codes found yet.")
                return
            lines = []
            for r in working[:20]:
                lines.append(f"✅ **{r['merchant'].title()}**: `{r['code']}` — {r.get('discount_text') or 'discount unknown'}")
            await message.channel.send("🎟️ **Working Codes:**\n" + "\n".join(lines))
            return

        # Verify command
        if text.startswith('verify '):
            merchant = text[7:].strip()
            if not merchant:
                return
            cached = get_cached_results(merchant, max_age_hours=999999)
            if not cached:
                await message.channel.send(f"❌ No cached codes for **{merchant}**")
                return
            codes_to_test = [r['code'] for r in cached]
            working_msg = await message.channel.send(f"🔍 Re-validating {len(codes_to_test)} codes for **{merchant}**...")
            try:
                results = await test_codes(merchant, codes_to_test)
                save_results(merchant, results, source='re-verify')
                response = format_validation_results(merchant, results)
                await working_msg.edit(content=response)
                # Notify on working codes
                working = [r for r in results if r['status'] == 'success']
                if working:
                    notify = f"🎉 **WORKING CODES FOUND** for {merchant.title()}!\n"
                    for w in working:
                        notify += f"✅ `{w['code']}` — {w.get('discount') or 'discount applied'}\n"
                    send_webhook(notify)
            except Exception as e:
                await working_msg.edit(content=f"❌ Validation error: {str(e)[:200]}")
            return

        # Default: search for merchant
        merchant = text
        if not merchant or len(merchant) > 60:
            return

        # Check fresh cache first (< 2h)
        cached = get_cached_results(merchant, max_age_hours=2)
        if cached:
            working = [r for r in cached if r.get('last_status') == 'success']
            failed = [r for r in cached if r.get('last_status') == 'failed']
            untested = [r for r in cached if r.get('last_status') not in ('success', 'failed')]

            lines = []
            for r in working:
                lines.append(f"✅ `{r['code']}` — {r.get('discount_text') or 'working'}")
            for r in untested:
                lines.append(f"❓ `{r['code']}` — untested")
            for r in failed[:5]:
                lines.append(f"❌ `{r['code']}` — failed")

            await message.channel.send(
                f"🎟️ **{merchant.title()}** — {len(cached)} codes (cached)\n\n"
                + "\n".join(lines) +
                f"\n\n💡 Type `verify {merchant}` to re-test all codes"
            )
            return

        # Full discovery + validation pipeline
        working_msg = await message.channel.send(f"🔍 Searching codes for **{merchant}**...")

        try:
            # Step 1: Discover codes
            await working_msg.edit(content=f"🔍 **{merchant}** — Step 1/3: Discovering codes...")
            codes = await find_candidate_codes(merchant)

            if not codes:
                await working_msg.edit(content=f"❌ No coupon codes found for **{merchant}**")
                return

            await working_msg.edit(content=f"🔍 **{merchant}** — Found {len(codes)} codes. Step 2/3: Validating...")

            # Step 2: Validate codes
            results = await test_codes(merchant, codes[:15])  # Limit to 15 codes to avoid timeout

            # Step 3: Save and respond
            save_results(merchant, results, source='discovery')
            response = format_validation_results(merchant, results)
            await working_msg.edit(content=response)

            # Log to #coupon-logs
            logs_channel = client.get_channel(LOGS_CHANNEL_ID)
            if logs_channel:
                log_msg = f"📋 **{merchant}** — {datetime.utcnow().strftime('%Y-%m-%d %H:%M UTC')}\n"
                for r in results:
                    icon = "✅" if r['status'] == 'success' else "❌" if r['status'] == 'failed' else "❓"
                    log_msg += f"{icon} `{r['code']}` — {r['status']}"
                    if r.get('discount'):
                        log_msg += f" ({r['discount']})"
                    if r.get('error'):
                        log_msg += f" | {r['error'][:50]}"
                    log_msg += "\n"
                if len(log_msg) > 1900:
                    log_msg = log_msg[:1900] + "..."
                await logs_channel.send(log_msg)

            # Webhook notification for working codes
            working = [r for r in results if r['status'] == 'success']
            if working:
                notify = f"🎉 **WORKING CODES FOUND** for {merchant.title()}!\n"
                for w in working:
                    notify += f"✅ `{w['code']}` — {w.get('discount') or 'discount applied'}\n"
                send_webhook(notify)

        except Exception as e:
            await working_msg.edit(content=f"❌ Error: {str(e)[:200]}")

    # ── #coupon-watchlist ────────────────────────────────────────────────
    elif message.channel.id == WATCHLIST_CHANNEL_ID:
        text = message.content.strip().lower()

        if text.startswith("watch "):
            merchant = text[6:].strip()
            wl = _load_watchlist()
            if merchant not in wl:
                wl.append(merchant)
                _save_watchlist(wl)
                await message.channel.send(f"✅ **{merchant}** added to watchlist ({len(wl)} total)")
            else:
                await message.channel.send(f"ℹ️ **{merchant}** already on watchlist")

        elif text.startswith("unwatch "):
            merchant = text[8:].strip()
            wl = _load_watchlist()
            if merchant in wl:
                wl.remove(merchant)
                _save_watchlist(wl)
                await message.channel.send(f"✅ **{merchant}** removed from watchlist")
            else:
                await message.channel.send(f"ℹ️ **{merchant}** not on watchlist")

        elif text == "list":
            wl = _load_watchlist()
            if wl:
                await message.channel.send("📋 **Watchlist:**\n" + "\n".join(f"• {m}" for m in wl))
            else:
                await message.channel.send("📋 Watchlist empty. Type `watch <merchant>` to add.")

        elif text == "scan":
            wl = _load_watchlist()
            if not wl:
                await message.channel.send("📋 Watchlist empty — nothing to scan.")
                return
            await message.channel.send(f"🔍 Scanning {len(wl)} watchlist merchants...")
            for merchant in wl:
                try:
                    codes = await find_candidate_codes(merchant)
                    if codes:
                        results = await test_codes(merchant, codes[:10])
                        save_results(merchant, results, source='watchlist-scan')
                        working = [r for r in results if r['status'] == 'success']
                        if working:
                            notify = f"🎉 **{merchant.title()}**: {len(working)} working codes!\n"
                            for w in working:
                                notify += f"✅ `{w['code']}`\n"
                            await message.channel.send(notify)
                            send_webhook(notify)
                        else:
                            await message.channel.send(f"❌ **{merchant}**: {len(codes)} codes found, none working")
                    else:
                        await message.channel.send(f"❌ **{merchant}**: no codes found")
                except Exception as e:
                    await message.channel.send(f"⚠️ **{merchant}**: error — {str(e)[:100]}")
                await asyncio.sleep(5)  # Rate limit between merchants


# ── CLI MODE ────────────────────────────────────────────────────────────
if __name__ == "__main__":
    if len(sys.argv) > 1 and sys.argv[1] == '--cli':
        # CLI mode — no Discord, just test
        async def cli_main():
            if len(sys.argv) < 3:
                print("Usage: python bot.py --cli <merchant> [--verify]")
                return
            merchant = sys.argv[2]
            verify = '--verify' in sys.argv

            if verify:
                cached = get_cached_results(merchant, max_age_hours=999999)
                if not cached:
                    print(f"No cached codes for {merchant}")
                    return
                codes = [r['code'] for r in cached]
                print(f"Re-validating {len(codes)} codes for {merchant}...")
                results = await test_codes(merchant, codes)
            else:
                print(f"Discovering codes for {merchant}...")
                codes = await find_candidate_codes(merchant)
                if not codes:
                    print(f"No codes found for {merchant}")
                    return
                print(f"Found {len(codes)} codes. Validating...")
                results = await test_codes(merchant, codes[:15])

            save_results(merchant, results, source='cli')
            for r in results:
                icon = "✅" if r['status'] == 'success' else "❌" if r['status'] == 'failed' else "❓"
                line = f"{icon} {r['code']}: {r['status']}"
                if r.get('discount'):
                    line += f" ({r['discount']})"
                if r.get('error'):
                    line += f" — {r['error'][:60]}"
                print(line)

        asyncio.run(cli_main())
    else:
        client.run(os.getenv("DISCORD_BOT_TOKEN"))
