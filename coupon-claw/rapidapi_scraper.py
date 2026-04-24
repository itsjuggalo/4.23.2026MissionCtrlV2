#!/usr/bin/env python3
"""RapidAPI Promo Codes Scraper — Pull all stores + coupons into local DB.
Run once to build your permanent coupon database.
Usage: python3 rapidapi_scraper.py [--stores] [--coupons] [--all]
"""

import os
import sys
import json
import time
import sqlite3
import requests
from datetime import datetime
from dotenv import load_dotenv

load_dotenv()

API_KEY = os.getenv("RAPIDAPI_KEY", "")
BASE_URL = "https://get-promo-codes.p.rapidapi.com/data"
HEADERS = {
    "Content-Type": "application/json",
    "x-rapidapi-host": "get-promo-codes.p.rapidapi.com",
    "x-rapidapi-key": API_KEY,
}

DB_PATH = os.path.join(os.path.dirname(__file__), "coupons.db")


def init_tables():
    conn = sqlite3.connect(DB_PATH)
    conn.executescript("""
        CREATE TABLE IF NOT EXISTS stores (
            store_id INTEGER PRIMARY KEY,
            store_name TEXT NOT NULL,
            url TEXT,
            domain TEXT,
            logo TEXT,
            country TEXT,
            scraped_at TEXT
        );
        CREATE TABLE IF NOT EXISTS rapidapi_coupons (
            id INTEGER PRIMARY KEY,
            store_id INTEGER,
            title TEXT,
            description TEXT,
            terms TEXT,
            code TEXT,
            url TEXT,
            language TEXT,
            status TEXT,
            added_date TEXT,
            end_date TEXT,
            scraped_at TEXT,
            FOREIGN KEY (store_id) REFERENCES stores(store_id)
        );
        CREATE INDEX IF NOT EXISTS idx_stores_name ON stores(store_name);
        CREATE INDEX IF NOT EXISTS idx_stores_domain ON stores(domain);
        CREATE INDEX IF NOT EXISTS idx_rapidapi_code ON rapidapi_coupons(code);
        CREATE INDEX IF NOT EXISTS idx_rapidapi_store ON rapidapi_coupons(store_id);
    """)
    conn.close()


def scrape_all_stores():
    """Pull all stores from RapidAPI (18,665 stores across ~187 pages)."""
    init_tables()
    conn = sqlite3.connect(DB_PATH)
    now = datetime.utcnow().isoformat()
    total_stores = 0
    page = 1

    print(f"[scraper] Starting store scrape at {now}")

    while True:
        try:
            r = requests.get(f"{BASE_URL}/get-stores/?page={page}", headers=HEADERS, timeout=15)
            if r.status_code != 200:
                print(f"[scraper] Page {page} returned {r.status_code}, stopping")
                break

            data = r.json()
            stores = data.get("data", [])
            total = data.get("total", 0)

            if not stores:
                print(f"[scraper] No more stores at page {page}")
                break

            for s in stores:
                conn.execute("""
                    INSERT OR REPLACE INTO stores (store_id, store_name, url, domain, logo, country, scraped_at)
                    VALUES (?, ?, ?, ?, ?, ?, ?)
                """, (s.get("store_id"), s.get("store_name", "").lower(), s.get("url", ""),
                      s.get("domain", ""), s.get("logo", ""), s.get("country", ""), now))

            total_stores += len(stores)
            conn.commit()
            print(f"[scraper] Page {page}/{(total//100)+1}: {len(stores)} stores (total: {total_stores}/{total})")

            page += 1
            time.sleep(1)  # Rate limit

        except Exception as e:
            print(f"[scraper] Error on page {page}: {e}")
            time.sleep(5)
            continue

    conn.close()
    print(f"[scraper] Done. {total_stores} stores saved to DB")
    return total_stores


def find_store_id(merchant):
    """Look up a merchant's numeric store_id from local DB."""
    conn = sqlite3.connect(DB_PATH)
    conn.row_factory = sqlite3.Row
    merchant = merchant.lower().strip()

    # Try exact match on store_name
    row = conn.execute("SELECT store_id, store_name, domain FROM stores WHERE store_name = ?", (merchant,)).fetchone()
    if row:
        conn.close()
        return dict(row)

    # Try domain match
    domain = merchant.replace(" ", "")
    if "." not in domain:
        domain = domain + ".com"
    row = conn.execute("SELECT store_id, store_name, domain FROM stores WHERE domain = ?", (domain,)).fetchone()
    if row:
        conn.close()
        return dict(row)

    # Try partial match
    row = conn.execute("SELECT store_id, store_name, domain FROM stores WHERE store_name LIKE ? OR domain LIKE ?",
                       (f"%{merchant}%", f"%{merchant}%")).fetchone()
    if row:
        conn.close()
        return dict(row)

    conn.close()
    return None


def scrape_coupons_for_store(store_id, store_name=""):
    """Pull all coupons for a specific store by numeric store_id."""
    conn = sqlite3.connect(DB_PATH)
    now = datetime.utcnow().isoformat()

    try:
        r = requests.get(f"{BASE_URL}/get-coupons/?storeId={store_id}", headers=HEADERS, timeout=15)
        if r.status_code != 200:
            print(f"[scraper] Coupons for store {store_id} returned {r.status_code}")
            conn.close()
            return []

        data = r.json()
        coupons = data.get("data", [])
        saved = 0

        for c in coupons:
            code = (c.get("code") or "").strip().upper()
            if not code:
                continue  # Skip deals without actual codes

            conn.execute("""
                INSERT OR REPLACE INTO rapidapi_coupons
                (id, store_id, title, description, terms, code, url, language, status, added_date, end_date, scraped_at)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
            """, (c.get("id"), c.get("store_id", store_id),
                  c.get("title", ""), c.get("description", ""),
                  c.get("terms", ""), code, c.get("url", ""),
                  c.get("language", ""), c.get("status", ""),
                  c.get("added_date", ""), c.get("end_date", ""), now))
            saved += 1

        conn.commit()
        print(f"[scraper] {store_name or store_id}: {saved} codes saved (of {len(coupons)} total offers)")
        conn.close()
        return [c for c in coupons if (c.get("code") or "").strip()]

    except Exception as e:
        print(f"[scraper] Error fetching coupons for {store_id}: {e}")
        conn.close()
        return []


def scrape_watchlist_coupons():
    """Pull coupons for all merchants in watchlist.json."""
    watchlist_path = os.path.join(os.path.dirname(__file__), "watchlist.json")
    if not os.path.exists(watchlist_path):
        print("[scraper] No watchlist.json found")
        return

    with open(watchlist_path) as f:
        watchlist = json.load(f)

    print(f"[scraper] Scraping coupons for {len(watchlist)} watchlist merchants")

    for merchant in watchlist:
        store = find_store_id(merchant)
        if store:
            print(f"[scraper] Found {merchant} → store_id {store['store_id']} ({store['domain']})")
            scrape_coupons_for_store(store["store_id"], merchant)
        else:
            print(f"[scraper] {merchant}: not found in store database")
        time.sleep(1)


def scrape_all_coupons(max_stores=500):
    """Pull coupons for top stores. Use max_stores to limit API calls."""
    conn = sqlite3.connect(DB_PATH)
    stores = conn.execute("SELECT store_id, store_name FROM stores WHERE country='US' ORDER BY store_id DESC LIMIT ?",
                          (max_stores,)).fetchall()
    conn.close()

    print(f"[scraper] Pulling coupons for {len(stores)} US stores")

    for i, (store_id, store_name) in enumerate(stores):
        scrape_coupons_for_store(store_id, store_name)
        if (i + 1) % 50 == 0:
            print(f"[scraper] Progress: {i+1}/{len(stores)}")
        time.sleep(1)


def get_codes_from_db(merchant):
    """Get coupon codes for a merchant from the local DB."""
    store = find_store_id(merchant)
    if not store:
        return []

    conn = sqlite3.connect(DB_PATH)
    conn.row_factory = sqlite3.Row
    rows = conn.execute("""
        SELECT code, title, description, terms, status, end_date
        FROM rapidapi_coupons
        WHERE store_id = ? AND code != '' AND status = 'Active'
        ORDER BY added_date DESC
    """, (store["store_id"],)).fetchall()
    conn.close()

    return [dict(r) for r in rows]


def stats():
    """Show database statistics."""
    conn = sqlite3.connect(DB_PATH)
    try:
        stores = conn.execute("SELECT COUNT(*) FROM stores").fetchone()[0]
    except:
        stores = 0
    try:
        coupons = conn.execute("SELECT COUNT(*) FROM rapidapi_coupons").fetchone()[0]
    except:
        coupons = 0
    try:
        active = conn.execute("SELECT COUNT(*) FROM rapidapi_coupons WHERE status='Active'").fetchone()[0]
    except:
        active = 0
    try:
        with_code = conn.execute("SELECT COUNT(*) FROM rapidapi_coupons WHERE code != ''").fetchone()[0]
    except:
        with_code = 0
    conn.close()
    print(f"[db] Stores: {stores} | Total offers: {coupons} | Active: {active} | With codes: {with_code}")


if __name__ == "__main__":
    if not API_KEY:
        print("Error: RAPIDAPI_KEY not set in .env")
        sys.exit(1)

    args = sys.argv[1:]

    if "--stores" in args or "--all" in args:
        scrape_all_stores()

    if "--coupons" in args or "--all" in args:
        scrape_all_coupons(max_stores=500)

    if "--watchlist" in args:
        scrape_watchlist_coupons()

    if "--stats" in args:
        stats()

    if not args:
        print("Usage: python3 rapidapi_scraper.py [--stores] [--coupons] [--watchlist] [--all] [--stats]")
        print("  --stores     Scrape all 18,665 stores into local DB")
        print("  --coupons    Scrape coupons for top 500 US stores")
        print("  --watchlist  Scrape coupons for watchlist merchants only")
        print("  --all        Scrape everything (stores + coupons)")
        print("  --stats      Show database statistics")
