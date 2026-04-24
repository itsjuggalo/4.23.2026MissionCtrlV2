#!/usr/bin/env python3
"""CouponClaw v2 Database — SQLite storage for coupons and test results."""

import sqlite3
import os
from datetime import datetime, timedelta

DB_PATH = os.path.join(os.path.dirname(__file__), "coupons.db")


def _get_conn():
    conn = sqlite3.connect(DB_PATH)
    conn.row_factory = sqlite3.Row
    conn.execute("PRAGMA journal_mode=WAL")
    return conn


def init_db():
    conn = _get_conn()
    conn.executescript("""
        CREATE TABLE IF NOT EXISTS coupons (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            merchant TEXT NOT NULL,
            code TEXT NOT NULL,
            source TEXT,
            first_seen TEXT NOT NULL,
            last_tested TEXT,
            last_status TEXT DEFAULT 'untested',
            discount_text TEXT,
            is_targeted INTEGER DEFAULT 0,
            test_count INTEGER DEFAULT 0,
            success_count INTEGER DEFAULT 0,
            platform TEXT,
            UNIQUE(merchant, code)
        );
        CREATE TABLE IF NOT EXISTS test_log (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            coupon_id INTEGER,
            tested_at TEXT NOT NULL,
            status TEXT NOT NULL,
            discount TEXT,
            error TEXT,
            platform TEXT,
            FOREIGN KEY (coupon_id) REFERENCES coupons(id)
        );
        CREATE INDEX IF NOT EXISTS idx_coupons_merchant ON coupons(merchant);
        CREATE INDEX IF NOT EXISTS idx_coupons_status ON coupons(last_status);
        CREATE INDEX IF NOT EXISTS idx_test_log_coupon ON test_log(coupon_id);
    """)
    conn.close()


init_db()


def save_results(merchant: str, results: list, source: str = None):
    """Save discovery/validation results to the database."""
    conn = _get_conn()
    now = datetime.utcnow().isoformat()
    merchant = merchant.lower().strip()

    for r in results:
        code = r.get('code', '').strip().upper()
        if not code:
            continue

        status = r.get('status', 'untested')
        discount = r.get('discount')
        targeted = 1 if r.get('targeted') else 0
        error = r.get('error')
        platform = r.get('platform', '')

        # Upsert coupon
        existing = conn.execute(
            "SELECT id, test_count, success_count FROM coupons WHERE merchant=? AND code=?",
            (merchant, code)
        ).fetchone()

        if existing:
            coupon_id = existing['id']
            test_count = existing['test_count'] + (1 if status != 'untested' else 0)
            success_count = existing['success_count'] + (1 if status == 'success' else 0)
            conn.execute(
                "UPDATE coupons SET last_tested=?, last_status=?, discount_text=?, is_targeted=?, test_count=?, success_count=?, platform=?, source=COALESCE(source, ?) WHERE id=?",
                (now, status, discount, targeted, test_count, success_count, platform, source, coupon_id)
            )
        else:
            cursor = conn.execute(
                "INSERT INTO coupons (merchant, code, source, first_seen, last_tested, last_status, discount_text, is_targeted, test_count, success_count, platform) VALUES (?,?,?,?,?,?,?,?,?,?,?)",
                (merchant, code, source, now, now, status, discount, targeted,
                 1 if status != 'untested' else 0,
                 1 if status == 'success' else 0,
                 platform)
            )
            coupon_id = cursor.lastrowid

        # Log test
        if status != 'untested':
            conn.execute(
                "INSERT INTO test_log (coupon_id, tested_at, status, discount, error, platform) VALUES (?,?,?,?,?,?)",
                (coupon_id, now, status, discount, error, platform)
            )

    conn.commit()
    conn.close()


def get_cached_results(merchant: str, max_age_hours: int = 2) -> list:
    """Get cached coupon results for a merchant."""
    conn = _get_conn()
    merchant = merchant.lower().strip()
    cutoff = (datetime.utcnow() - timedelta(hours=max_age_hours)).isoformat()

    rows = conn.execute(
        "SELECT * FROM coupons WHERE merchant=? AND first_seen > ? ORDER BY last_status='success' DESC, last_tested DESC",
        (merchant, cutoff)
    ).fetchall()

    conn.close()
    return [dict(r) for r in rows]


def get_working_codes(merchant: str = None) -> list:
    """Get all working coupon codes, optionally filtered by merchant."""
    conn = _get_conn()
    if merchant:
        rows = conn.execute(
            "SELECT * FROM coupons WHERE merchant=? AND last_status='success' ORDER BY last_tested DESC",
            (merchant.lower().strip(),)
        ).fetchall()
    else:
        rows = conn.execute(
            "SELECT * FROM coupons WHERE last_status='success' ORDER BY last_tested DESC LIMIT 50"
        ).fetchall()
    conn.close()
    return [dict(r) for r in rows]


def get_stats() -> dict:
    """Get database statistics."""
    conn = _get_conn()
    total = conn.execute("SELECT COUNT(*) FROM coupons").fetchone()[0]
    working = conn.execute("SELECT COUNT(*) FROM coupons WHERE last_status='success'").fetchone()[0]
    failed = conn.execute("SELECT COUNT(*) FROM coupons WHERE last_status='failed'").fetchone()[0]
    untested = conn.execute("SELECT COUNT(*) FROM coupons WHERE last_status='untested'").fetchone()[0]
    merchants = conn.execute("SELECT COUNT(DISTINCT merchant) FROM coupons").fetchone()[0]
    tests = conn.execute("SELECT COUNT(*) FROM test_log").fetchone()[0]
    conn.close()
    return {
        'total_codes': total,
        'working_codes': working,
        'failed_codes': failed,
        'untested_codes': untested,
        'merchants': merchants,
        'total_tests': tests,
    }


def get_merchants() -> list:
    """Get all tracked merchants."""
    conn = _get_conn()
    rows = conn.execute(
        "SELECT merchant, COUNT(*) as code_count, SUM(CASE WHEN last_status='success' THEN 1 ELSE 0 END) as working FROM coupons GROUP BY merchant ORDER BY working DESC"
    ).fetchall()
    conn.close()
    return [dict(r) for r in rows]
