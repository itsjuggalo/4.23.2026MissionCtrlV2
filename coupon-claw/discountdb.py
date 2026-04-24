#!/usr/bin/env python3
"""CouponClaw v2 — DiscountDB API client for supplementary code discovery."""

import os
import re
import requests
from dotenv import load_dotenv

load_dotenv()

API_URL = os.getenv("DISCOUNTDB_API_URL", "https://api.discountdb.org")


async def query_discountdb(merchant: str) -> list:
    """Query DiscountDB for coupon codes. Returns list of code strings."""
    try:
        slug = re.sub(r'\.(com|net|org|co|io)$', '', merchant.lower().strip())
        r = requests.get(f"{API_URL}/coupons/{slug}", timeout=10)
        if r.status_code == 200:
            data = r.json()
            codes = []
            for item in (data if isinstance(data, list) else data.get('coupons', [])):
                code = item.get('code', '').strip().upper()
                if code and len(code) >= 4:
                    codes.append(code)
            return codes
    except Exception as e:
        print(f"  [discountdb] Error: {e}")
    return []
