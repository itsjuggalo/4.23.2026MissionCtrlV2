#!/usr/bin/env python3
"""
stock_auto_trader — follow-the-analyst auto-execution daemon.

Reads stock signals from the Option-Signals-Scraper output. For each NEW signal
in the active (ShortTerm/LongTerm) files, places a 1-share market BUY on BOTH
Boba (R2) and Jazzy paper accounts. When a signal appears in the closed-stocks
file, closes the position with a market SELL on both accounts.

Day-validity orders queue for the next market open when the daemon fires after
hours, so the chaotic "Monday morning floods" risk on first run is mitigated by
a SEED step that records every existing signal as already-handled before any
order is placed.

State: /home/ubuntu/mission-control-restored/data/options_flow.sqlite,
table auto_trader_orders, PRIMARY KEY (signal_id, account, action) — guarantees
each signal is BUY-able and SELL-able exactly once per account.

PM2 daemon (polls every 60s).
"""
import json
import logging
import sqlite3
import time
from pathlib import Path

import requests

SECRETS = Path("/home/ubuntu/.openclaw/secrets")
DB_PATH = Path("/home/ubuntu/mission-control-restored/data/options_flow.sqlite")
SCRAPER_DATA = Path("/home/ubuntu/mission-control-restored/Option-Signals-Scraper/data")
LOG_FILE = Path("/home/ubuntu/mission-control-restored/data/stock_auto_trader.log")

# (raw_filename, source_label, category) — ACTIVE positions
ACTIVE_FILES = [
    ("short_term_stocks.json",       "Vivid2", "ShortTermStocks"),
    ("ts_short_term_stocks.json",    "Name",   "ShortTermStocks"),
    ("ss_short_term_stocks.json",    "Name2",  "ShortTermStocks"),
    ("long_term_stocks.json",        "Vivid2", "LongTermStocks"),
    ("ts_long_term_stocks.json",     "Name",   "LongTermStocks"),
    ("ss_long_term_stocks.json",     "Name2",  "LongTermStocks"),
]
# (raw_filename, source_label, category) — CLOSED positions
CLOSED_FILES = [
    ("closed_stocks.json",           "Vivid2", "ClosedStocks"),
    ("ts_closed_stocks.json",        "Name",   "ClosedStocks"),
    ("ss_closed_stocks.json",        "Name2",  "ClosedStocks"),
]

# Account name → (key-id secret file, secret secret file)
ACCOUNTS = {
    "boba":  ("alpaca-key-id",        "alpaca-secret"),
    "jazzy": ("alpaca-jazzy-key-id",  "alpaca-jazzy-secret"),
}

ALPACA_BASE = "https://paper-api.alpaca.markets"
POLL_INTERVAL = 60

SCHEMA = """
CREATE TABLE IF NOT EXISTS auto_trader_orders (
    signal_id       TEXT NOT NULL,
    account         TEXT NOT NULL,
    ticker          TEXT NOT NULL,
    action          TEXT NOT NULL,
    qty             INTEGER NOT NULL,
    placed_at       TEXT NOT NULL,
    alpaca_order_id TEXT,
    status          TEXT,
    error           TEXT,
    PRIMARY KEY (signal_id, account, action)
);
CREATE INDEX IF NOT EXISTS idx_auto_placed ON auto_trader_orders(placed_at);
CREATE INDEX IF NOT EXISTS idx_auto_ticker ON auto_trader_orders(ticker);
"""

LOG_FILE.parent.mkdir(parents=True, exist_ok=True)
logging.basicConfig(
    filename=str(LOG_FILE),
    level=logging.INFO,
    format="%(asctime)s %(levelname)s %(message)s",
)
log = logging.getLogger()
log.addHandler(logging.StreamHandler())


def get_secret(name):
    p = SECRETS / name
    return p.read_text().strip() if p.exists() else None


def alpaca_headers(account):
    key_file, sec_file = ACCOUNTS[account]
    return {
        "APCA-API-KEY-ID": get_secret(key_file) or "",
        "APCA-API-SECRET-KEY": get_secret(sec_file) or "",
    }


def place_market_order(account, ticker, qty, side):
    """Returns (alpaca_order_id, error_msg). Day-TIF queues after hours."""
    headers = alpaca_headers(account)
    headers["Content-Type"] = "application/json"
    body = {
        "symbol": ticker,
        "qty": str(qty),
        "side": side,
        "type": "market",
        "time_in_force": "day",
    }
    try:
        r = requests.post(f"{ALPACA_BASE}/v2/orders",
                          json=body, headers=headers, timeout=15)
        if 200 <= r.status_code < 300:
            return r.json().get("id"), None
        return None, f"HTTP {r.status_code}: {r.text[:200]}"
    except Exception as e:
        return None, f"exception: {e}"


def get_open_position(account, ticker):
    """Returns integer qty held, or 0 if no position / error."""
    try:
        r = requests.get(f"{ALPACA_BASE}/v2/positions/{ticker}",
                         headers=alpaca_headers(account), timeout=10)
        if r.status_code == 200:
            return int(float(r.json().get("qty", 0)))
        return 0
    except Exception:
        return 0


def db_connect():
    conn = sqlite3.connect(str(DB_PATH), timeout=15)
    conn.executescript(SCHEMA)
    return conn


def already_handled(cur, signal_id, account, action):
    cur.execute("SELECT 1 FROM auto_trader_orders WHERE signal_id=? AND account=? AND action=?",
                (signal_id, account, action))
    return cur.fetchone() is not None


def build_rationale(action, source_label, category, raw, extra=""):
    """Compose a one-line mechanical rationale from the raw signal payload."""
    if not isinstance(raw, dict):
        raw = {}
    parts = [f"{source_label}/{category}", f"action={action}"]
    for k in ("buy_target", "sell_target", "stop_loss", "risk", "category", "captured_at"):
        v = raw.get(k)
        if v not in (None, "", 0):
            parts.append(f"{k}={v}")
    if raw.get("is_free"):
        parts.append("tier=free")
    if extra:
        parts.append(extra)
    return " | ".join(str(p) for p in parts)[:480]


def record(cur, signal_id, account, ticker, action, qty, order_id, status, error, rationale=""):
    cur.execute("""
        INSERT OR REPLACE INTO auto_trader_orders
        (signal_id, account, ticker, action, qty, placed_at, alpaca_order_id, status, error, rationale)
        VALUES (?,?,?,?,?,?,?,?,?,?)
    """, (signal_id, account, ticker, action, qty,
          time.strftime("%Y-%m-%dT%H:%M:%SZ", time.gmtime()),
          order_id, status, error, rationale))


def load_signals(filename, source_label, category):
    """Yields (signal_id, ticker, raw) for each entry in the raw Firebase-dict file."""
    p = SCRAPER_DATA / filename
    if not p.exists():
        return
    try:
        data = json.loads(p.read_text())
    except Exception as e:
        log.warning(f"unreadable {filename}: {e}")
        return
    if not isinstance(data, dict):
        return
    for key, raw in data.items():
        if not isinstance(raw, dict):
            continue
        ticker = raw.get("symbol")
        if not ticker:
            continue
        signal_id = f"{source_label}_{category}_{key}"
        yield signal_id, ticker, raw


def seed_if_first_run(conn):
    """On first run, mark all existing signal IDs as handled WITHOUT placing
    orders. This prevents the daemon from trying to BUY hundreds of historical
    signals all at once on initial deployment."""
    cur = conn.cursor()
    cur.execute("SELECT COUNT(*) FROM auto_trader_orders")
    if cur.fetchone()[0] > 0:
        return
    log.info("[stock_auto_trader] FIRST RUN — seeding existing signals as already handled")
    n_seeded = 0
    for filename, source, category in ACTIVE_FILES + CLOSED_FILES:
        for signal_id, ticker, raw in load_signals(filename, source_label, category):
            for account in ACCOUNTS:
                for action in ("BUY", "SELL"):
                    cur.execute("""
                        INSERT OR IGNORE INTO auto_trader_orders
                        (signal_id, account, ticker, action, qty, placed_at, status, error)
                        VALUES (?,?,?,?,?,?,?,?)
                    """, (signal_id, account, ticker, action, 0,
                          time.strftime("%Y-%m-%dT%H:%M:%SZ", time.gmtime()),
                          "seeded", "first_run_seed"))
                    n_seeded += 1
    conn.commit()
    log.info(f"[stock_auto_trader] seeded {n_seeded} (signal, account, action) rows — no orders placed")


def process_active(conn):
    """For each signal in active files: place BUY on both accounts if not yet placed.

    Refactored 2026-05-23: writes a 'pending' dedup row BEFORE place_market_order
    so any future exception in record()/rationale path cannot re-fire the order.
    """
    cur = conn.cursor()
    buys = 0
    for filename, source_label, category in ACTIVE_FILES:
        for signal_id, ticker, raw in load_signals(filename, source_label, category):
            for account in ACCOUNTS:
                if already_handled(cur, signal_id, account, "BUY"):
                    continue
                # 1. Write speculative 'pending' dedup row FIRST
                try:
                    record(cur, signal_id, account, ticker, "BUY", 1, None, "pending", None, "pre-order placeholder")
                    conn.commit()
                except Exception as pe:
                    log.warning(f"[{account}] BUY {ticker} pending-record failed ({signal_id}): {pe}")
                    continue  # If we can't even write pending, don't fire the order
                # 2. Fire the order
                order_id, err = place_market_order(account, ticker, 1, "buy")
                status = "submitted" if order_id else "failed"
                # 3. Update dedup row with final status. If THIS throws, pending row still blocks re-fire.
                try:
                    rationale = build_rationale("BUY", source_label, category, raw)
                except Exception as be:
                    rationale = f"rationale-build error: {be}"
                try:
                    record(cur, signal_id, account, ticker, "BUY", 1, order_id, status, err, rationale)
                    conn.commit()
                except Exception as ue:
                    log.warning(f"[{account}] BUY {ticker} status-update failed ({signal_id}): {ue} (pending row blocks re-fire)")
                if err:
                    log.warning(f"[{account}] BUY {ticker} 1sh FAILED ({signal_id}): {err}")
                else:
                    log.info(f"[{account}] BUY {ticker} 1sh order={order_id} (signal={signal_id})")
                    buys += 1
    return buys


def process_closed(conn):
    """For each signal in closed files: place SELL on both accounts if we hold a position.

    Refactored 2026-05-23: writes a 'pending' dedup row BEFORE place_market_order.
    """
    cur = conn.cursor()
    sells = 0
    for filename, source_label, category in CLOSED_FILES:
        for signal_id, ticker, raw in load_signals(filename, source_label, category):
            for account in ACCOUNTS:
                if already_handled(cur, signal_id, account, "SELL"):
                    continue
                # Only sell if we actually have an open position
                qty = get_open_position(account, ticker)
                if qty <= 0:
                    try:
                        record(cur, signal_id, account, ticker, "SELL", 0, None, "skipped", "no_position", "no open position to sell")
                        conn.commit()
                    except Exception as e:
                        log.warning(f"[{account}] SELL {ticker} skip-record failed ({signal_id}): {e}")
                    continue
                # 1. Write 'pending' first
                try:
                    record(cur, signal_id, account, ticker, "SELL", qty, None, "pending", None, "pre-order placeholder")
                    conn.commit()
                except Exception as pe:
                    log.warning(f"[{account}] SELL {ticker} pending-record failed ({signal_id}): {pe}")
                    continue
                # 2. Fire
                order_id, err = place_market_order(account, ticker, qty, "sell")
                status = "submitted" if order_id else "failed"
                # 3. Update with final status
                try:
                    rationale = build_rationale("SELL", source_label, category, raw)
                except Exception as be:
                    rationale = f"rationale-build error: {be}"
                try:
                    record(cur, signal_id, account, ticker, "SELL", qty, order_id, status, err, rationale)
                    conn.commit()
                except Exception as ue:
                    log.warning(f"[{account}] SELL {ticker} status-update failed ({signal_id}): {ue} (pending row blocks re-fire)")
                if err:
                    log.warning(f"[{account}] SELL {ticker} {qty}sh FAILED ({signal_id}): {err}")
                else:
                    log.info(f"[{account}] SELL {ticker} {qty}sh order={order_id} (signal={signal_id})")
                    sells += 1
    return sells


def main():
    log.info("[stock_auto_trader] starting daemon...")
    log.info(f"  accounts:  {list(ACCOUNTS.keys())}")
    log.info(f"  data dir:  {SCRAPER_DATA}")
    log.info(f"  db:        {DB_PATH}")
    log.info(f"  poll:      {POLL_INTERVAL}s")

    # Verify Alpaca creds resolve before we start trading
    for account in ACCOUNTS:
        kid = get_secret(ACCOUNTS[account][0]) or ""
        sec = get_secret(ACCOUNTS[account][1]) or ""
        log.info(f"  {account}: key_last4=...{kid[-4:] if kid else 'MISSING'} sec_last4=...{sec[-4:] if sec else 'MISSING'}")

    conn = db_connect()
    seed_if_first_run(conn)

    while True:
        try:
            n_buys = process_active(conn)
            n_sells = process_closed(conn)
            if n_buys or n_sells:
                log.info(f"[stock_auto_trader] cycle: buys={n_buys} sells={n_sells}")
        except Exception as e:
            log.exception(f"[stock_auto_trader] cycle error: {e}")
        time.sleep(POLL_INTERVAL)


if __name__ == "__main__":
    main()
