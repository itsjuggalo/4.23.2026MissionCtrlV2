#!/usr/bin/env python3
"""CouponClaw v2 Discovery — Playwright stealth + platform detection + aggregator scraping."""

import os
import re
import asyncio
import json
import requests
from datetime import datetime
from bs4 import BeautifulSoup
from playwright.async_api import async_playwright
from dotenv import load_dotenv

load_dotenv()

HEADERS = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36',
    'Accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8',
    'Accept-Language': 'en-US,en;q=0.9',
}

# Regex to find coupon-like strings near coupon context words
COUPON_CONTEXT = re.compile(
    r'(?:code|coupon|promo|discount|offer|save|copy|apply|use code|enter code|checkout code).{0,80}?([A-Z0-9][A-Z0-9\-_]{3,25})'
    r'|([A-Z0-9][A-Z0-9\-_]{3,25}).{0,40}?(?:code|coupon|promo|off|discount|% off|\$ off)',
    re.IGNORECASE
)

# Words that look like codes but aren't
SKIP = {
    "FREE", "SALE", "DEAL", "SAVE", "CODE", "PROMO", "SHOP", "MORE", "CLICK",
    "COPY", "SHOW", "NONE", "TRUE", "FALSE", "NULL", "ONLINE", "STORE", "VIEW",
    "HTML", "HTTP", "HTTPS", "JSON", "LINK", "TEXT", "MENU", "OPEN", "NEXT",
    "BACK", "SKIP", "DONE", "HELP", "INFO", "HOME", "CART", "PAGE", "DATA",
    "FORM", "ITEM", "LIST", "GRID", "ICON", "LOGO", "SIGN", "JOIN", "POST",
    "EMAIL", "LOGIN", "CLOSE", "IMAGE", "SHARE", "TITLE", "PRICE", "TOTAL",
    "USER", "TYPE", "BODY", "HEAD", "FOOT", "MAIN", "SIDE", "WRAP",
    "TABS", "SITE", "BLOG", "NEWS", "GIFT", "CARD", "HERE", "UNLIKE",
    "LATEST", "UPDATES", "TELEGRAM", "DISCORD", "TWITTER", "YOUTUBE",
    "TIKTOK", "INSTAGRAM", "FACEBOOK", "ORDERS", "ORDER", "PRODUCTS",
    "PRODUCT", "CHECKOUT", "PAYMENT", "SEARCH", "FILTER", "SORT", "BRAND",
    "BRANDS", "ABOUT", "CONTACT", "POLICY", "TERMS", "PRIVACY", "RETURN",
    "RETURNS", "SHIPPING", "TRACK", "ACCOUNT", "WISHLIST", "COMPARE",
    "REVIEW", "REVIEWS", "RATING", "NEWSLETTER", "SUBSCRIBE", "SIGNUP",
    "REGISTER", "MEMBER", "PATENT", "TRADEMARK", "COPYRIGHT", "BETTER",
    "FIRST", "ENTER", "SUBMIT", "CONFIRM", "CONTINUE", "BASKET", "APPLY",
    "ARGUMENTS", "CHARCODE", "DROPEFFECT", "FUNCTION", "KEYCODE", "SCREENY",
    "SCREENX", "ALTKEY", "CTRLKEY", "SHIFTKEY", "METAKEY", "BUTTONS",
    "CLIENTX", "CLIENTY", "OFFSETX", "OFFSETY", "PAGEX", "PAGEY",
    "MOVEMENTX", "MOVEMENTY", "TABLETOP", "THURSDAY", "PROTOTYPE",
    "CONSTRUCTOR", "UNDEFINED", "TOSTRING", "VALUEOF", "ITERATOR",
    "DETAILS", "VERIFY", "EXPIRED", "INVALID", "UNAVAILABLE", "LOADING",
    "PLEASE", "THANK", "WELCOME", "HEADER", "FOOTER", "WIDGET", "MOBILE",
    "DESKTOP", "TABLET", "WINDOW", "BUTTON", "INPUT", "SELECT", "OPTION",
}


def _valid_code(text: str) -> bool:
    t = text.strip().upper()
    if not t or not (4 <= len(t) <= 25):
        return False
    if not re.match(r'^[A-Z0-9\-_]{4,25}$', t):
        return False
    if t.isdigit():
        return False
    if t in SKIP:
        return False
    if not re.search(r'[A-Z]', t):
        return False
    # Short all-alpha codes are usually nav words
    if re.match(r'^[A-Z]{4,6}$', t) and len(t) < 7:
        return False
    return True


def _extract_codes_from_text(text: str) -> list:
    """Extract potential coupon codes from text using context-aware regex."""
    codes = set()
    for match in COUPON_CONTEXT.finditer(text):
        for g in match.groups():
            if g and _valid_code(g):
                codes.add(g.strip().upper())
    return list(codes)


def _merchant_slug(merchant: str) -> str:
    slug = merchant.lower().strip()
    slug = re.sub(r'\.(com|net|org|co|io|us|shop|store)$', '', slug)
    slug = slug.replace(" ", "-").replace("'", "").replace("&", "and")
    return slug


def _merchant_domain(merchant: str) -> str:
    m = merchant.lower().strip()
    if re.match(r'^https?://', m):
        return m
    if '.' in m:
        return f"https://{m}"
    return f"https://{m}.com"


# =============================================================================
# PLATFORM DETECTION
# =============================================================================

async def detect_platform(page) -> str:
    """Detect e-commerce platform from page source."""
    try:
        content = await page.content()
        cl = content.lower()
        if 'shopify' in cl or 'cdn.shopify.com' in cl or 'myshopify.com' in cl:
            return 'shopify'
        if 'woocommerce' in cl or 'wc-' in cl or 'wp-content/plugins/woocommerce' in cl:
            return 'woocommerce'
        if 'bigcommerce' in cl:
            return 'bigcommerce'
        if 'magento' in cl or 'mage-' in cl:
            return 'magento'
        if 'squarespace' in cl:
            return 'squarespace'
    except:
        pass
    return 'unknown'


def get_coupon_page_urls(domain: str, platform: str) -> list:
    """Return likely coupon/discount page URLs based on platform."""
    base = domain.rstrip('/')
    urls = [
        f"{base}/discount",
        f"{base}/discount/",
        f"{base}/coupon",
        f"{base}/coupons",
        f"{base}/promo",
        f"{base}/deals",
        f"{base}/offers",
        f"{base}/sale",
    ]
    if platform == 'shopify':
        urls += [f"{base}/collections/sale", f"{base}/pages/coupons"]
    elif platform == 'woocommerce':
        urls += [f"{base}/shop/?on_sale=1", f"{base}/coupon-codes/"]
    return urls


# =============================================================================
# STEALTH BROWSER
# =============================================================================

async def get_stealth_browser():
    """Launch Playwright with stealth settings."""
    pw = await async_playwright().start()
    browser = await pw.chromium.launch(
        headless=True,
        args=[
            '--no-sandbox',
            '--disable-blink-features=AutomationControlled',
            '--disable-dev-shm-usage',
        ]
    )
    return pw, browser


async def get_stealth_context(browser):
    """Create a stealth browser context."""
    context = await browser.new_context(
        user_agent='Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36',
        viewport={'width': 1920, 'height': 1080},
        java_script_enabled=True,
        locale='en-US',
        timezone_id='America/New_York',
    )
    # Anti-detection scripts
    await context.add_init_script("""
        Object.defineProperty(navigator, 'webdriver', { get: () => false });
        Object.defineProperty(navigator, 'plugins', { get: () => [1, 2, 3, 4, 5] });
        Object.defineProperty(navigator, 'languages', { get: () => ['en-US', 'en'] });
        window.chrome = { runtime: {} };
        const originalQuery = window.navigator.permissions.query;
        window.navigator.permissions.query = (parameters) => (
            parameters.name === 'notifications' ?
            Promise.resolve({ state: Notification.permission }) :
            originalQuery(parameters)
        );
    """)
    return context


# =============================================================================
# AGGREGATOR SCRAPING (zero Playwright, just requests)
# =============================================================================

def scrape_retailmenot(merchant: str) -> list:
    slug = _merchant_slug(merchant)
    codes = []
    for url in [
        f"https://www.retailmenot.com/view/{slug}.com",
        f"https://www.retailmenot.com/view/{slug}",
    ]:
        try:
            r = requests.get(url, headers=HEADERS, timeout=10)
            if r.status_code == 200:
                codes.extend(_extract_codes_from_text(r.text))
        except:
            pass
    return codes


def scrape_couponscom(merchant: str) -> list:
    slug = _merchant_slug(merchant)
    codes = []
    try:
        url = f"https://www.coupons.com/coupon-codes/{slug}/"
        r = requests.get(url, headers=HEADERS, timeout=10)
        if r.status_code == 200:
            codes.extend(_extract_codes_from_text(r.text))
    except:
        pass
    return codes


def scrape_dealspotr(merchant: str) -> list:
    slug = _merchant_slug(merchant)
    codes = []
    try:
        url = f"https://dealspotr.com/{slug}-coupons"
        r = requests.get(url, headers=HEADERS, timeout=10)
        if r.status_code == 200:
            codes.extend(_extract_codes_from_text(r.text))
    except:
        pass
    return codes


def scrape_honey_style(merchant: str) -> list:
    """Scrape Google search results for coupon codes."""
    slug = _merchant_slug(merchant)
    codes = []
    try:
        query = f"{slug} coupon code {datetime.now().year}"
        url = f"https://www.google.com/search?q={query}&num=10"
        r = requests.get(url, headers=HEADERS, timeout=10)
        if r.status_code == 200:
            codes.extend(_extract_codes_from_text(r.text))
    except:
        pass
    return codes


# =============================================================================
# DIRECT SITE SCRAPING (Playwright stealth)
# =============================================================================

async def scrape_direct_site(merchant: str) -> list:
    """Scrape the merchant's own website for coupon codes using Playwright stealth."""
    domain = _merchant_domain(merchant)
    codes = []

    pw, browser = await get_stealth_browser()
    try:
        context = await get_stealth_context(browser)
        page = await context.new_page()

        # Visit homepage first
        try:
            await page.goto(domain, timeout=20000, wait_until='domcontentloaded')
            await page.wait_for_timeout(2000)

            # Detect platform
            platform = await detect_platform(page)
            print(f"  [discovery] Platform detected: {platform}")

            # Extract from homepage (banners, popups, headers)
            homepage_text = await page.text_content('body') or ''
            codes.extend(_extract_codes_from_text(homepage_text))

            # Check for popup/modal with coupon
            try:
                modals = await page.query_selector_all('[class*="popup"], [class*="modal"], [class*="overlay"], [id*="popup"], [id*="modal"]')
                for modal in modals[:3]:
                    modal_text = await modal.text_content() or ''
                    codes.extend(_extract_codes_from_text(modal_text))
            except:
                pass

            # Visit common coupon pages
            coupon_urls = get_coupon_page_urls(domain, platform)
            for curl in coupon_urls[:4]:  # limit to avoid rate limiting
                try:
                    resp = await page.goto(curl, timeout=10000, wait_until='domcontentloaded')
                    if resp and resp.status == 200:
                        await page.wait_for_timeout(1000)
                        text = await page.text_content('body') or ''
                        codes.extend(_extract_codes_from_text(text))
                except:
                    pass
                await page.wait_for_timeout(500)

        except Exception as e:
            print(f"  [discovery] Direct scrape error for {domain}: {e}")

        await context.close()
    finally:
        await browser.close()
        await pw.stop()

    return list(set(c for c in codes if _valid_code(c)))


# =============================================================================
# GEMINI GROUNDED SEARCH (existing feature, kept)
# =============================================================================

async def gemini_search(merchant: str) -> list:
    """Use Gemini to find coupon codes via grounded search."""
    api_key = os.getenv("GEMINI_API_KEY", "")
    if not api_key:
        return []

    try:
        url = f"https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent?key={api_key}"
        payload = {
            "contents": [{
                "parts": [{"text": f"Find all currently valid coupon codes and promo codes for {merchant}. Return ONLY the codes, one per line, nothing else. If none exist, say NONE."}]
            }],
            "generationConfig": {"temperature": 0.1, "maxOutputTokens": 500}
        }
        r = requests.post(url, json=payload, timeout=30)
        if r.status_code == 200:
            data = r.json()
            text = data.get("candidates", [{}])[0].get("content", {}).get("parts", [{}])[0].get("text", "")
            if "NONE" in text.upper():
                return []
            codes = []
            for line in text.strip().split('\n'):
                cleaned = re.sub(r'[^A-Z0-9\-_]', '', line.strip().upper())
                if cleaned and _valid_code(cleaned):
                    codes.append(cleaned)
            return codes
    except Exception as e:
        print(f"  [discovery] Gemini error: {e}")
    return []


# =============================================================================
# MAIN DISCOVERY FUNCTION
# =============================================================================

async def find_candidate_codes(merchant: str) -> list:
    """Find coupon codes from all sources. Returns deduplicated list."""
    print(f"[discovery] Searching codes for: {merchant}")
    all_codes = set()

    # 1. Aggregator scraping (fast, no Playwright)
    print(f"  [discovery] Scraping aggregators...")
    for scraper_name, scraper in [
        ("retailmenot", scrape_retailmenot),
        ("coupons.com", scrape_couponscom),
        ("dealspotr", scrape_dealspotr),
        ("google", scrape_honey_style),
    ]:
        try:
            codes = scraper(merchant)
            if codes:
                print(f"  [discovery] {scraper_name}: {len(codes)} codes")
                all_codes.update(codes)
        except Exception as e:
            print(f"  [discovery] {scraper_name} error: {e}")

    # 2. Direct site scraping (Playwright stealth)
    print(f"  [discovery] Scraping direct site...")
    try:
        direct_codes = await scrape_direct_site(merchant)
        if direct_codes:
            print(f"  [discovery] direct site: {len(direct_codes)} codes")
            all_codes.update(direct_codes)
    except Exception as e:
        print(f"  [discovery] direct site error: {e}")

    # 3. Gemini search (AI-powered)
    print(f"  [discovery] Gemini search...")
    try:
        gemini_codes = await gemini_search(merchant)
        if gemini_codes:
            print(f"  [discovery] gemini: {len(gemini_codes)} codes")
            all_codes.update(gemini_codes)
    except Exception as e:
        print(f"  [discovery] gemini error: {e}")

    result = sorted(list(all_codes))
    print(f"[discovery] Total unique codes for {merchant}: {len(result)}")
    return result
