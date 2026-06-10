#!/usr/bin/env python3
"""
pw_scrape.py — reusable Playwright scraper base (stealth, WSL-safe)

Usage as a library:
    from pw_scrape import new_browser, new_page

Usage as CLI:
    python3 pw_scrape.py https://example.com
    python3 pw_scrape.py https://example.com --wait 2 --screenshot /tmp/shot.png
    python3 pw_scrape.py https://example.com --js "document.title"
"""

import argparse
import time
from contextlib import contextmanager

from playwright.sync_api import sync_playwright, Page, Browser
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
    "--disable-extensions",
]

DEFAULT_UA = (
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) "
    "AppleWebKit/537.36 (KHTML, like Gecko) "
    "Chrome/148.0.0.0 Safari/537.36"
)


@contextmanager
def new_browser(headless: bool = True, proxy: str | None = None):
    """Yields a stealth Playwright + Browser. Use as a context manager."""
    launch_opts = dict(executable_path=CHROME_BIN, args=CHROME_ARGS, headless=headless)
    if proxy:
        launch_opts["proxy"] = {"server": proxy}

    with Stealth().use_sync(sync_playwright()) as p:
        browser = p.chromium.launch(**launch_opts)
        try:
            yield p, browser
        finally:
            browser.close()


def new_page(
    browser: Browser,
    ua: str = DEFAULT_UA,
    cookies: list[dict] | None = None,
    storage_state: str | None = None,
    viewport: dict | None = None,
) -> Page:
    """Create a new stealth context + page."""
    ctx_opts = dict(user_agent=ua)
    if storage_state:
        ctx_opts["storage_state"] = storage_state
    if viewport:
        ctx_opts["viewport"] = viewport
    ctx = browser.new_context(**ctx_opts)
    if cookies:
        ctx.add_cookies(cookies)
    return ctx.new_page()


def save_auth(page: Page, path: str):
    """Save cookies/localStorage to a file for reuse."""
    page.context.storage_state(path=path)
    print(f"Auth saved → {path}")


def load_auth(path: str) -> str:
    """Return storage_state path (pass to new_page)."""
    return path


# ── CLI ──────────────────────────────────────────────────────────────────────

def main():
    ap = argparse.ArgumentParser(description="Playwright scraper (stealth)")
    ap.add_argument("url", help="URL to scrape")
    ap.add_argument("--wait", type=float, default=0, help="Extra sleep after load (seconds)")
    ap.add_argument("--screenshot", help="Save screenshot to this path")
    ap.add_argument("--js", help="Evaluate JS and print result")
    ap.add_argument("--text", action="store_true", help="Print full page text")
    ap.add_argument("--html", action="store_true", help="Print full page HTML")
    ap.add_argument("--auth", help="Path to saved auth state (storage_state JSON)")
    ap.add_argument("--save-auth", help="After load, save auth to this path")
    ap.add_argument("--headed", action="store_true", help="Run with visible browser")
    ap.add_argument("--proxy", help="Proxy server (e.g. http://user:pass@host:port)")
    ap.add_argument("--wait-for", help="CSS selector to wait for before extracting")
    args = ap.parse_args()

    with new_browser(headless=not args.headed, proxy=args.proxy) as (p, browser):
        page = new_page(browser, storage_state=args.auth)
        page.goto(args.url, wait_until="domcontentloaded", timeout=30000)

        if args.wait_for:
            page.wait_for_selector(args.wait_for, timeout=15000)

        if args.wait:
            time.sleep(args.wait)

        if args.save_auth:
            save_auth(page, args.save_auth)

        if args.screenshot:
            page.screenshot(path=args.screenshot, full_page=True)
            print(f"Screenshot → {args.screenshot}")

        if args.js:
            result = page.evaluate(args.js)
            print(result)
        elif args.html:
            print(page.content())
        elif args.text:
            print(page.inner_text("body"))
        else:
            print(f"Title: {page.title()}")
            print(f"URL:   {page.url}")


if __name__ == "__main__":
    main()
