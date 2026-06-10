#!/usr/bin/env python3
"""
pw_login_save.py — headed login helper: open a site, wait for you to log in,
save the auth state (cookies + localStorage) for headless reuse.

Usage:
    python3 pw_login_save.py https://claytrader.com/login --auth /tmp/ct_auth.json
    python3 pw_login_save.py https://site.com/login --detect-url "/dashboard" --auth /tmp/auth.json
"""

import argparse
import sys
import time

from playwright.sync_api import sync_playwright
from playwright_stealth import Stealth

CHROME_BIN = "/usr/bin/google-chrome"
CHROME_ARGS = [
    "--no-sandbox",
    "--disable-setuid-sandbox",
    "--disable-dev-shm-usage",
    "--disable-blink-features=AutomationControlled",
    "--disable-infobars",
    "--disable-gpu",
    "--ignore-certificate-errors",
    "--start-maximized",
]

DEFAULT_UA = (
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) "
    "AppleWebKit/537.36 (KHTML, like Gecko) "
    "Chrome/148.0.0.0 Safari/537.36"
)

def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("url", help="Login page URL")
    ap.add_argument("--auth", default="/tmp/pw_auth.json", help="Where to save auth state")
    ap.add_argument("--detect-url", default=None, help="URL fragment that signals login success (e.g. /member/)")
    ap.add_argument("--timeout", type=int, default=120, help="Seconds to wait for login (default 120)")
    args = ap.parse_args()

    print(f"\n{'='*60}")
    print(f"  Opening: {args.url}")
    print(f"  Log in manually in the browser window.")
    print(f"  Auth will be saved to: {args.auth}")
    if args.detect_url:
        print(f"  Auto-save triggers when URL contains: {args.detect_url}")
    else:
        print(f"  Press Ctrl+C here when you're fully logged in.")
    print(f"{'='*60}\n")

    with Stealth().use_sync(sync_playwright()) as p:
        browser = p.chromium.launch(
            executable_path=CHROME_BIN,
            args=CHROME_ARGS,
            headless=False,
        )
        ctx = browser.new_context(
            user_agent=DEFAULT_UA,
            no_viewport=True,
        )
        page = ctx.new_page()
        page.goto(args.url, wait_until="domcontentloaded", timeout=30000)

        saved = False
        deadline = time.time() + args.timeout

        try:
            while time.time() < deadline:
                current = page.url
                if args.detect_url and args.detect_url in current:
                    print(f"\n✓ Detected success URL: {current}")
                    ctx.storage_state(path=args.auth)
                    print(f"✓ Auth saved → {args.auth}")
                    saved = True
                    break
                time.sleep(1)

            if not saved:
                if args.detect_url:
                    print("\n✗ Timed out waiting for success URL.")
                    sys.exit(1)
                else:
                    # Ctrl+C path — save whatever state we have
                    pass

        except KeyboardInterrupt:
            print("\nCtrl+C caught — saving current auth state...")

        if not saved:
            ctx.storage_state(path=args.auth)
            print(f"✓ Auth saved → {args.auth}")

        print("\nVerifying saved cookies...")
        import json
        with open(args.auth) as f:
            state = json.load(f)
        cookies = state.get("cookies", [])
        print(f"  {len(cookies)} cookies saved")
        ct_cookies = [c for c in cookies if "claytrader" in c.get("domain","")]
        print(f"  {len(ct_cookies)} claytrader.com cookies")
        for c in ct_cookies[:8]:
            print(f"    {c['name']} = {c['value'][:30]}...")

        browser.close()

if __name__ == "__main__":
    main()
