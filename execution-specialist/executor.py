#!/usr/bin/env python3
"""
Execution Specialist — Alpaca Paper Trading Executor
Citadel DNA: Watches Risk Manager approvals, executes via Alpaca, logs everything.

Pipeline:
  Risk Manager → risk_state.json (decisions with APPROVED status)
  → This executor picks up APPROVED decisions not yet executed
  → Places market order on Alpaca paper account
  → Logs to executions.json + pending_orders.json
  → Updates risk_state.json decision with alpaca_order_id
"""

import json
import os
import time
import uuid
import logging
from datetime import datetime, timezone
from pathlib import Path

import requests

logging.basicConfig(level=logging.INFO, format="%(asctime)s [EXECUTOR] %(message)s", datefmt="%Y-%m-%d %H:%M:%S")
log = logging.getLogger(__name__)

# ── Paths ────────────────────────────────────────────────────────────────────
_DIR               = Path(__file__).parent
RISK_STATE_FILE    = _DIR.parent / "risk-manager" / "risk_state.json"
PENDING_FILE       = _DIR / "pending_orders.json"
EXECUTIONS_FILE    = _DIR / "executions.json"

# ── Alpaca ────────────────────────────────────────────────────────────────────
_secrets = Path.home() / ".openclaw" / "secrets"
ALPACA_KEY    = (_secrets / "alpaca-key-id").read_text().strip()
ALPACA_SECRET = (_secrets / "alpaca-secret").read_text().strip()
ALPACA_BASE   = "https://paper-api.alpaca.markets/v2"
ALPACA_HDR    = {"APCA-API-KEY-ID": ALPACA_KEY, "APCA-API-SECRET-KEY": ALPACA_SECRET}

# ── Settings ──────────────────────────────────────────────────────────────────
POLL_INTERVAL = 30   # seconds between cycles
MAX_POSITION_USD = 1500  # max $ per trade (safety cap for paper trading)

# ── Helpers ───────────────────────────────────────────────────────────────────
def load_json(path, default=None):
    try:
        if Path(path).exists():
            return json.loads(Path(path).read_text())
    except Exception as e:
        log.warning(f"load_json {path}: {e}")
    return default if default is not None else {}

def save_json(path, data):
    try:
        Path(path).write_text(json.dumps(data, indent=2))
        return True
    except Exception as e:
        log.error(f"save_json {path}: {e}")
        return False

def alpaca_get(endpoint):
    try:
        r = requests.get(f"{ALPACA_BASE}{endpoint}", headers=ALPACA_HDR, timeout=10)
        r.raise_for_status()
        return r.json()
    except Exception as e:
        log.error(f"Alpaca GET {endpoint}: {e}")
        return None

def alpaca_post(endpoint, data):
    try:
        r = requests.post(f"{ALPACA_BASE}{endpoint}", headers=ALPACA_HDR, json=data, timeout=10)
        r.raise_for_status()
        return r.json()
    except Exception as e:
        log.error(f"Alpaca POST {endpoint}: {e}")
        return None

def is_market_open():
    clock = alpaca_get("/clock")
    return clock and clock.get("is_open", False)

def get_latest_price(symbol):
    """Get latest quote from Alpaca."""
    quote = alpaca_get(f"/stocks/{symbol}/quotes/latest")
    if quote and "quote" in quote:
        ask = float(quote["quote"].get("ap", 0))
        bid = float(quote["quote"].get("bp", 0))
        if ask > 0 and bid > 0:
            return (ask + bid) / 2
    # Fallback: last trade
    trade = alpaca_get(f"/stocks/{symbol}/trades/latest")
    if trade and "trade" in trade:
        return float(trade["trade"].get("p", 0))
    return 0

def calc_qty(symbol, entry_price, portfolio_value, risk_pct=1.5, stop_loss=None):
    """
    Calculate position size:
    - Risk 1.5% of portfolio per trade
    - Cap at MAX_POSITION_USD
    - If stop_loss given, size by dollar risk
    """
    if portfolio_value <= 0 or entry_price <= 0:
        return 0

    max_usd = min(portfolio_value * (risk_pct / 100), MAX_POSITION_USD)

    if stop_loss and stop_loss > 0 and entry_price > stop_loss:
        risk_per_share = entry_price - stop_loss
        dollar_risk = portfolio_value * (risk_pct / 100)
        qty = int(dollar_risk / risk_per_share)
    else:
        qty = int(max_usd / entry_price)

    return max(qty, 1)

def place_order(symbol, qty, side="buy", order_type="market",
                limit_price=None, stop_loss=None, take_profit=None):
    """
    Place order on Alpaca paper account.
    If stop_loss AND take_profit provided → uses OCO bracket for protection.
    If only stop_loss → uses bracket entry order.
    """
    # Try OCO bracket first (for existing positions needing protection)
    # For new entries with stops: use bracket order class
    if stop_loss and take_profit:
        # New entry with full bracket
        payload = {
            "symbol":        symbol,
            "qty":           str(qty),
            "side":          side,
            "type":          order_type,
            "time_in_force": "day",
            "order_class":   "bracket",
            "stop_loss": {
                "stop_price":  str(round(stop_loss, 2)),
                "limit_price": str(round(stop_loss * 0.999, 2)),  # 0.1% below stop
            },
            "take_profit": {
                "limit_price": str(round(take_profit, 2)),
            },
        }
        if order_type == "limit" and limit_price:
            payload["limit_price"] = str(round(limit_price, 2))

        log.info(f"Placing BRACKET {side.upper()} {qty}x {symbol} | stop=${stop_loss} | tp=${take_profit}")
        result = alpaca_post("/orders", payload)
        if result and "id" in result:
            legs = result.get("legs", [])
            log.info(f"✅ Bracket order: {result['id'][:8]} | {len(legs)} legs (stop + take-profit)")
            return result
        else:
            log.warning(f"Bracket order failed for {symbol}: {result} — falling back to market")

    # Fallback: simple market order
    payload = {
        "symbol":        symbol,
        "qty":           str(qty),
        "side":          side,
        "type":          order_type,
        "time_in_force": "day",
    }
    if order_type == "limit" and limit_price:
        payload["limit_price"] = str(round(limit_price, 2))

    log.info(f"Placing {side.upper()} {qty}x {symbol} (market, no bracket)")
    result = alpaca_post("/orders", payload)
    if result and "id" in result:
        log.info(f"✅ Market order: {result['id'][:8]} | {symbol} {side} {qty}")

        # If we have a stop, place a separate GTC stop order for protection
        if stop_loss:
            stop_payload = {
                "symbol":        symbol,
                "qty":           str(qty),
                "side":          "sell" if side == "buy" else "buy",
                "type":          "stop",
                "time_in_force": "gtc",
                "stop_price":    str(round(stop_loss, 2)),
            }
            sr = alpaca_post("/orders", stop_payload)
            if sr and "id" in sr:
                log.info(f"✅ Protective stop: {sr['id'][:8]} @ ${stop_loss}")
            else:
                log.warning(f"⚠️ Could not place protective stop for {symbol}")
        return result
    else:
        log.error(f"❌ Order failed for {symbol}: {result}")
        return None

def process_approved_decisions():
    """Main cycle: find APPROVED decisions not yet executed, execute them."""

    risk_state = load_json(RISK_STATE_FILE)
    decisions  = risk_state.get("decisions", [])
    portfolio_value = float(risk_state.get("portfolio_value", 100000))
    pending    = load_json(PENDING_FILE, [])
    executions = load_json(EXECUTIONS_FILE, [])

    executed_signal_ids = {e.get("signal_id") for e in executions}
    pending_signal_ids  = {p.get("signal_id") for p in pending}

    # Find APPROVED decisions not yet in pending or executions
    to_execute = [
        d for d in decisions
        if d.get("decision") == "APPROVED"
        and d.get("signal_id") not in executed_signal_ids
        and d.get("signal_id") not in pending_signal_ids
    ]

    if not to_execute:
        log.info("No new approved trades to execute.")
        return

    log.info(f"Found {len(to_execute)} approved trade(s) to execute")

    market_open = is_market_open()
    if not market_open:
        log.info("Market is CLOSED — queuing orders for next open")

    for decision in to_execute:
        symbol    = decision.get("symbol", "")
        direction = decision.get("direction", "BUY").upper()
        entry     = float(decision.get("entry") or 0)
        stop_loss = float(decision.get("stop_loss") or 0)
        targets   = decision.get("targets", [])
        rec_pos   = decision.get("recommended_position", {}) or {}

        if not symbol:
            log.warning("Skipping decision with no symbol")
            continue

        # Skip crypto (Alpaca crypto needs different endpoint, skip for now)
        if "/" in symbol or "USDT" in symbol or "BTC" in symbol:
            log.info(f"Skipping crypto {symbol} — use Tweak for crypto execution")
            continue

        # Get live price if no entry
        live_price = get_latest_price(symbol) if entry <= 0 else entry
        if live_price <= 0:
            log.warning(f"Could not get price for {symbol}, skipping")
            continue

        # Calculate qty
        qty = int(rec_pos.get("size", 0)) if rec_pos.get("size") else calc_qty(
            symbol, live_price, portfolio_value,
            risk_pct=1.5, stop_loss=stop_loss if stop_loss > 0 else None
        )

        if qty <= 0:
            log.warning(f"Calculated qty=0 for {symbol}, skipping")
            continue

        side = "buy" if direction in ("BUY", "LONG", "CALL") else "sell"

        # Get take-profit from first target
        take_profit = float(targets[0]) if targets else None

        # Place order with bracket (stop + take-profit) if we have the data
        order_result = place_order(
            symbol, qty, side=side, order_type="market",
            stop_loss=stop_loss if stop_loss > 0 else None,
            take_profit=take_profit,
        )

        order_record = {
            "id":            str(uuid.uuid4()),
            "signal_id":     decision.get("signal_id"),
            "decision_id":   decision.get("id"),
            "symbol":        symbol,
            "side":          side,
            "qty":           qty,
            "entry_price":   live_price,
            "stop_loss":     stop_loss,
            "targets":       targets,
            "status":        "filled" if order_result else "failed",
            "alpaca_order_id": order_result.get("id") if order_result else None,
            "alpaca_status": order_result.get("status") if order_result else "failed",
            "created_at":    datetime.now(timezone.utc).isoformat(),
            "market_was_open": market_open,
            "source":        "risk-manager-approval",
        }

        if order_result:
            executions.append(order_record)
            log.info(f"✅ Executed: {symbol} {side.upper()} {qty} shares | Alpaca ID: {order_result['id']}")
        else:
            pending.append({**order_record, "status": "pending", "retry_count": 0})
            log.warning(f"⚠️  Order failed for {symbol}, added to pending for retry")

    # Save updated files
    save_json(EXECUTIONS_FILE, executions)
    save_json(PENDING_FILE, pending)
    log.info(f"Cycle done. Executions: {len(executions)} | Pending: {len(pending)}")

def retry_pending_orders():
    """Retry any failed/queued pending orders."""
    pending = load_json(PENDING_FILE, [])
    if not pending:
        return

    still_pending = []
    executions = load_json(EXECUTIONS_FILE, [])

    for order in pending:
        retries = order.get("retry_count", 0)
        if retries >= 3:
            log.warning(f"Abandoning {order['symbol']} after 3 retries")
            order["status"] = "abandoned"
            executions.append(order)
            continue

        result = place_order(order["symbol"], order["qty"], side=order["side"])
        if result:
            order["status"] = "filled"
            order["alpaca_order_id"] = result["id"]
            order["alpaca_status"] = result["status"]
            executions.append(order)
            log.info(f"✅ Retry success: {order['symbol']}")
        else:
            order["retry_count"] = retries + 1
            still_pending.append(order)

    save_json(PENDING_FILE, still_pending)
    save_json(EXECUTIONS_FILE, executions)

def main():
    log.info("=== Execution Specialist starting ===")
    log.info(f"Alpaca: paper account | Max per trade: ${MAX_POSITION_USD}")
    log.info(f"Risk state: {RISK_STATE_FILE}")
    log.info(f"Poll: every {POLL_INTERVAL}s\n")

    # Ensure files exist
    if not EXECUTIONS_FILE.exists(): save_json(EXECUTIONS_FILE, [])
    if not PENDING_FILE.exists(): save_json(PENDING_FILE, [])

    while True:
        try:
            retry_pending_orders()
            process_approved_decisions()
        except KeyboardInterrupt:
            log.info("Shutting down.")
            break
        except Exception as e:
            log.error(f"Cycle error: {e}", exc_info=True)
        time.sleep(POLL_INTERVAL)

if __name__ == "__main__":
    main()
