#!/usr/bin/env python3
"""CouponClaw v2.1 Validator — Instant Shopify validation via AJAX cart API.
No Playwright needed for Shopify stores. Falls back to marking untested for others.

Shopify validation flow (2 seconds per code):
1. GET /products.json → find in-stock variant
2. POST /cart/clear.js → clean slate
3. POST /cart/add.js → add item to cart
4. GET /discount/CODE → apply discount cookie
5. GET /cart.json → check if applicable=True and total_discount>0
6. POST /cart/clear.js → clean up
"""

import asyncio
import re
import json
import os
import tempfile
import subprocess
import time
from datetime import datetime


def _shopify_validate_code(domain, code, variant_id):
    """Validate a single code on a Shopify store using curl + AJAX cart API."""
    result = {
        "code": code,
        "status": "failed",
        "discount": None,
        "targeted": False,
        "error": None,
        "tested_at": datetime.utcnow().isoformat(),
        "platform": "shopify",
    }

    cookie_file = tempfile.mktemp(suffix='.txt')

    try:
        # Step 1: Clear cart
        subprocess.run([
            'curl', '-s', '-c', cookie_file,
            '-X', 'POST', f'{domain}/cart/clear.js',
            '-H', 'Content-Type: application/json',
            '-o', '/dev/null'
        ], timeout=10, capture_output=True)

        # Step 2: Add in-stock item
        add_result = subprocess.run([
            'curl', '-s', '-b', cookie_file, '-c', cookie_file,
            '-X', 'POST', f'{domain}/cart/add.js',
            '-H', 'Content-Type: application/json',
            '-d', json.dumps({"items": [{"id": variant_id, "quantity": 1}]})
        ], timeout=10, capture_output=True, text=True)

        try:
            add_data = json.loads(add_result.stdout)
        except:
            result['error'] = 'Failed to add product'
            result['status'] = 'untested'
            return result

        if add_data.get('status') == 422:
            result['error'] = 'Product sold out'
            result['status'] = 'untested'
            return result

        # Step 3: Apply discount code
        subprocess.run([
            'curl', '-s', '-b', cookie_file, '-c', cookie_file,
            f'{domain}/discount/{code}',
            '-o', '/dev/null'
        ], timeout=10, capture_output=True)

        # Step 4: Check cart for discount
        cart_result = subprocess.run([
            'curl', '-s', '-b', cookie_file,
            f'{domain}/cart.json'
        ], timeout=10, capture_output=True, text=True)

        cart_data = json.loads(cart_result.stdout)

        discount_codes = cart_data.get('discount_codes', [])
        total_discount = cart_data.get('total_discount', 0)
        original = cart_data.get('original_total_price', 0)

        for dc in discount_codes:
            if dc.get('code', '').upper() == code.upper():
                if dc.get('applicable', False) and total_discount > 0:
                    result['status'] = 'success'
                    discount_pct = round((total_discount / original) * 100) if original > 0 else 0
                    discount_dollars = total_discount / 100
                    result['discount'] = f"${discount_dollars:.2f} ({discount_pct}% off)"
                else:
                    result['status'] = 'failed'
                    if not dc.get('applicable'):
                        result['error'] = 'Code not applicable'
                break

        # Step 5: Clean up
        subprocess.run([
            'curl', '-s', '-b', cookie_file, '-c', cookie_file,
            '-X', 'POST', f'{domain}/cart/clear.js',
            '-H', 'Content-Type: application/json',
            '-o', '/dev/null'
        ], timeout=10, capture_output=True)

    except json.JSONDecodeError as e:
        result['error'] = f'JSON parse error'
        result['status'] = 'untested'
    except subprocess.TimeoutExpired:
        result['error'] = 'Request timeout'
        result['status'] = 'untested'
    except Exception as e:
        result['error'] = str(e)[:100]
        result['status'] = 'untested'
    finally:
        try:
            os.unlink(cookie_file)
        except:
            pass

    return result


def _find_shopify_variant(domain):
    """Find an in-stock product variant ID from a Shopify store."""
    try:
        result = subprocess.run([
            'curl', '-s', f'{domain}/products.json?limit=25'
        ], timeout=15, capture_output=True, text=True)

        data = json.loads(result.stdout)
        for product in data.get('products', []):
            for variant in product.get('variants', []):
                if variant.get('available', False):
                    return variant['id']
    except Exception as e:
        print(f"  [validator] Error finding variant: {e}")
    return None


def _detect_platform_curl(domain):
    """Detect e-commerce platform using curl."""
    # Quick Shopify check: /products.json only exists on Shopify
    try:
        result = subprocess.run([
            'curl', '-s', '-o', '/dev/null', '-w', '%{http_code}',
            f'{domain}/products.json?limit=1'
        ], timeout=10, capture_output=True, text=True)
        if result.stdout.strip() == '200':
            return 'shopify'
    except:
        pass
    # Also check /cart.json — only Shopify stores have this
    try:
        result = subprocess.run([
            'curl', '-s', '-o', '/dev/null', '-w', '%{http_code}',
            f'{domain}/cart.json'
        ], timeout=10, capture_output=True, text=True)
        if result.stdout.strip() == '200':
            return 'shopify'
    except:
        pass
    # Fallback: check page source
    try:
        result = subprocess.run([
            'curl', '-s', '-L', domain,
            '-H', 'User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36'
        ], timeout=15, capture_output=True, text=True)
        body = result.stdout.lower()
        if 'shopify' in body or 'cdn.shopify.com' in body or 'myshopify.com' in body:
            return 'shopify'
        if 'woocommerce' in body or 'wp-content/plugins/woocommerce' in body:
            return 'woocommerce'
        if 'bigcommerce' in body:
            return 'bigcommerce'
        if 'magento' in body:
            return 'magento'
    except:
        pass
    return 'unknown'


async def test_codes(merchant, codes, product_url=None):
    """Test coupon codes. Auto-detects platform and uses best method."""
    results = []
    if not codes:
        return results

    domain = merchant.lower().strip()
    if not domain.startswith('http'):
        domain = f"https://{domain}" if '.' in domain else f"https://{domain}.com"

    platform = _detect_platform_curl(domain)
    print(f"  [validator] Platform: {platform}, testing {len(codes)} codes")

    if platform == 'shopify':
        variant_id = _find_shopify_variant(domain)
        if not variant_id:
            print(f"  [validator] No in-stock products found")
            return [{"code": c, "status": "untested", "discount": None,
                     "targeted": False, "error": "No in-stock products",
                     "platform": "shopify"} for c in codes]

        print(f"  [validator] Using variant {variant_id}")

        for code in codes:
            result = _shopify_validate_code(domain, code, variant_id)
            results.append(result)

            icon = "✅" if result['status'] == 'success' else "❌" if result['status'] == 'failed' else "❓"
            extra = f" ({result['discount']})" if result.get('discount') else ""
            err = f" — {result['error']}" if result.get('error') else ""
            print(f"  [validator] {icon} {code}: {result['status']}{extra}{err}")

            time.sleep(3)
    else:
        for code in codes:
            results.append({
                "code": code,
                "status": "untested",
                "discount": None,
                "targeted": False,
                "error": f"Non-Shopify ({platform}) — verify manually",
                "platform": platform,
                "tested_at": datetime.utcnow().isoformat(),
            })
            print(f"  [validator] ❓ {code}: untested ({platform})")

    return results
