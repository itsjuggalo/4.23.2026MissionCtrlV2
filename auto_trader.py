#!/usr/bin/env python3
"""
auto_trader.py — Autonomous Paper Trading Executor
Reads signals from signal-receiver and places trades on Alpaca paper account.
Sends confirmation to Telegram + Discord.

Run via cron every 5 minutes during market hours, or triggered by webhook.
"""

import json
import os
import sys
import requests
from datetime import datetime, timezone, timedelta

sys.path.insert(0, os.path.expanduser("~/scripts"))
from lib.http_retry import requests_session
# Retries idempotent GET/DELETE (429/5xx/timeout); POST excluded -> order submits never auto-retried.
SESSION = requests_session()
# R1 safety guard - skip if buying power below threshold (paper-margin artifact)
MIN_BUYING_POWER = 1000.0



# === SQLite Trade Logging ===
def log_trade_to_db(symbol, direction, price, qty, source="supertrend"):
    """Log trade to Mission Control SQLite database"""
    try:
        import urllib.request, json
        data = json.dumps({
            "symbol": symbol, "direction": direction,
            "entry_price": price, "quantity": qty, "source": source
        }).encode()
        req = urllib.request.Request(
            "http://localhost:3033/api/trade-log",
            data=data,
            headers={"Content-Type": "application/json"},
            method="POST"
        )
        urllib.request.urlopen(req, timeout=5)
        print(f"[db] Trade logged: {direction} {qty} {symbol} @ ${price}")
    except Exception as e:
        print(f"[db] Trade log error: {e}")


EST = timezone(timedelta(hours=-4))
NOW = datetime.now(EST)
SECRETS_DIR = "/home/ubuntu/.openclaw/secrets"

# === Firebase signal execution config ===
from pathlib import Path as _Path
FIREBASE_SIGNALS_FILE = _Path("/home/ubuntu/.openclaw/workspace/directives/firebase_trade_signals.json")
FIREBASE_SEEN_FILE = _Path("/home/ubuntu/.openclaw/workspace/state/auto_trader_firebase_seen.json")
FIREBASE_MAX_AGE_HOURS = 24
FIREBASE_STOCK_QTY = 2
FIREBASE_OPTION_CONTRACTS = 2
SIGNAL_DIR = "/home/ubuntu/mission-control/signal-receiver/data"
TRADE_LOG = "/home/ubuntu/.openclaw/workspace/memory/trade_log.jsonl"
STATE_FILE = "/home/ubuntu/scripts/auto_trader_state.json"

# === CONFIG ===
MAX_POSITION_PCT = 10       # Max 10% of portfolio per trade
MAX_POSITIONS = 5           # Max 5 open positions
STOP_LOSS_PCT = 3.0         # 3% stop loss
TAKE_PROFIT_PCT = 6.0       # 6% take profit (2:1 R/R)
MIN_ACCOUNT_EQUITY = 50000  # Don't trade if account drops below this


def load_secret(name):
    for fname in [name, name + ".txt"]:
        path = os.path.join(SECRETS_DIR, fname)
        if os.path.exists(path):
            with open(path) as f:
                return f.read().strip()
    return None


ALPACA_KEY = load_secret("alpaca-r1-key-id")
ALPACA_SECRET = load_secret("alpaca-r1-secret")
ALPACA_BASE = "https://paper-api.alpaca.markets"
TG_TOKEN = load_secret("telegram-bot-token")
TG_CHAT = load_secret("telegram-chat-id")
DISCORD_WH = load_secret("discord_autotrader_webhook")


def alpaca_headers():
    return {
        "APCA-API-KEY-ID": ALPACA_KEY,
        "APCA-API-SECRET-KEY": ALPACA_SECRET,
        "Content-Type": "application/json",
    }


def alpaca_get(path):
    try:
        r = SESSION.get(f"{ALPACA_BASE}{path}", headers=alpaca_headers(), timeout=10)
        return r.json() if r.status_code == 200 else {}
    except:
        return {}


def alpaca_post(path, body):
    try:
        r = requests.post(f"{ALPACA_BASE}{path}", headers=alpaca_headers(), json=body, timeout=10)
        return r.json(), r.status_code
    except Exception as e:
        return {"error": str(e)}, 500


def get_account():
    return alpaca_get("/v2/account")


def get_positions():
    result = alpaca_get("/v2/positions")
    return result if isinstance(result, list) else []


def load_state():
    if os.path.exists(STATE_FILE):
        with open(STATE_FILE) as f:
            return json.load(f)
    return {"last_signal_id": None, "trades_today": 0, "last_trade_date": ""}


def save_state(state):
    with open(STATE_FILE, "w") as f:
        json.dump(state, f, indent=2)


def log_trade(trade_data):
    os.makedirs(os.path.dirname(TRADE_LOG), exist_ok=True)
    with open(TRADE_LOG, "a") as f:
        f.write(json.dumps(trade_data, default=str) + "\n")


def send_telegram(msg):
    if TG_TOKEN and TG_CHAT:
        try:
            requests.post(f"https://api.telegram.org/bot{TG_TOKEN}/sendMessage",
                json={"chat_id": TG_CHAT, "text": msg}, timeout=10)
        except:
            pass


def send_discord(msg):
    if DISCORD_WH:
        try:
            requests.post(DISCORD_WH, json={"content": msg, "username": "Auto Trader"}, timeout=10)
        except:
            pass


def read_supertrend_signal():
    """Read the latest SuperTrend signal from signal-receiver."""
    try:
        with open(os.path.join(SIGNAL_DIR, "latest_state.json")) as f:
            data = json.load(f)
        btc = data.get("BTCUSD", {})
        return {
            "symbol": "BTCUSD",
            "direction": btc.get("direction", "UNKNOWN"),
            "entry_price": btc.get("entry_price", 0),
            "last_action": btc.get("last_action", "UNKNOWN"),
            "signal_time": btc.get("last_signal_time", ""),
        }
    except:
        return None


def read_market_regime():
    try:
        with open(os.path.join(SIGNAL_DIR, "market_regime.json")) as f:
            return json.load(f)
    except:
        return {}


def calculate_position_size(account, price):
    """Calculate position size based on account equity and max position %."""
    equity = float(account.get("equity", 0))
    max_dollars = equity * (MAX_POSITION_PCT / 100)
    if price <= 0:
        return 0
    # For BTC, calculate fractional qty
    qty = max_dollars / price
    return round(qty, 5)


def check_existing_btc_position(positions):
    """Check if we already have a BTC position."""
    for p in positions:
        sym = p.get("symbol", "")
        if "BTC" in sym.upper() and "USD" in sym.upper():
            return {
                "symbol": sym,
                "qty": float(p.get("qty", 0)),
                "side": p.get("side", ""),
                "entry": float(p.get("avg_entry_price", 0)),
                "current": float(p.get("current_price", 0)),
                "pnl_pct": float(p.get("unrealized_plpc", 0)) * 100,
            }
    return None


def place_market_order(symbol, qty, side):
    """Place a market order on Alpaca."""
    # Alpaca crypto symbol format
    # Alpaca crypto uses BTC/USD for orders
    if symbol == "BTCUSD":
        symbol = "BTC/USD"

    order = {
        "symbol": symbol,
        "qty": str(qty),
        "side": side,
        "type": "market",
        "time_in_force": "gtc",
    }

    result, status = alpaca_post("/v2/orders", order)
    return result, status


def place_stop_order(symbol, qty, stop_price):
    """Place a stop market order for stop loss."""
    # Alpaca crypto uses BTC/USD for orders
    if symbol == "BTCUSD":
        symbol = "BTC/USD"

    order = {
        "symbol": symbol,
        "qty": str(qty),
        "side": "sell",
        "type": "stop_limit",
        "time_in_force": "gtc",
        "stop_price": str(round(stop_price, 2)),
        "limit_price": str(round(stop_price * 0.995, 2)),
    }

    result, status = alpaca_post("/v2/orders", order)
    return result, status


def place_limit_order(symbol, qty, limit_price):
    """Place a limit order for take profit."""
    # Alpaca crypto uses BTC/USD for orders
    if symbol == "BTCUSD":
        symbol = "BTC/USD"

    order = {
        "symbol": symbol,
        "qty": str(qty),
        "side": "sell",
        "type": "limit",
        "time_in_force": "gtc",
        "limit_price": str(round(limit_price, 2)),
    }

    result, status = alpaca_post("/v2/orders", order)
    return result, status




# ============ FIREBASE SIGNAL EXECUTOR ============
def load_firebase_seen():
    """Load set of Firebase signal IDs we have already executed."""
    try:
        if FIREBASE_SEEN_FILE.exists():
            return set(json.loads(FIREBASE_SEEN_FILE.read_text()))
    except Exception:
        pass
    return set()


def save_firebase_seen(seen_set):
    """Persist seen signal IDs to disk."""
    try:
        FIREBASE_SEEN_FILE.parent.mkdir(parents=True, exist_ok=True)
        FIREBASE_SEEN_FILE.write_text(json.dumps(sorted(list(seen_set))))
    except Exception as e:
        print(f"[firebase] save_seen failed: {e}")


def build_alpaca_option_symbol(ticker, strike, is_put, expiry_ts):
    """Build OCC option symbol like AAPL260619P00200000 from Firebase fields."""
    try:
        exp_dt = datetime.fromtimestamp(int(expiry_ts), tz=timezone.utc)
        yymmdd = exp_dt.strftime("%y%m%d")
        cp = "P" if is_put else "C"
        strike_int = int(round(float(strike) * 1000))
        strike_str = f"{strike_int:08d}"
        return f"{ticker}{yymmdd}{cp}{strike_str}"
    except Exception as e:
        print(f"[firebase] symbol build failed for {ticker}: {e}")
        return None


def execute_firebase_stock(sig):
    """Place bracket order: limit entry, TP at sell_target, SL at stop_loss."""
    ticker = sig.get("ticker")
    try:
        buy = float(sig.get("buy_target"))
        sell = float(sig.get("sell_target"))
        sl = float(sig.get("stop_loss"))
    except Exception:
        return False, "missing or non-numeric targets"

    body = {
        "symbol": ticker,
        "qty": str(FIREBASE_STOCK_QTY),
        "side": "buy",
        "type": "limit",
        "limit_price": f"{buy:.2f}",
        "time_in_force": "day",
        "order_class": "bracket",
        "take_profit": {"limit_price": f"{sell:.2f}"},
        "stop_loss": {"stop_price": f"{sl:.2f}"},
    }
    result = alpaca_post("/v2/orders", body)
    if isinstance(result, tuple):
        result = result[0]
    ok = (isinstance(result, dict) and "id" in result)
    if ok:
        oid = result.get("id", "?")
        msg = (
            f"FIREBASE STOCK BUY {FIREBASE_STOCK_QTY}x {ticker} "
            f"@ limit ${buy:.2f} | TP ${sell:.2f} / SL ${sl:.2f}\n"
            f"Source: {sig.get('source','?')} | Order: {oid}"
        )
        send_telegram(msg)
        send_discord(msg)
        print(f"[firebase] {msg}")
        return True, oid
    else:
        err = result if isinstance(result, str) else json.dumps(result)[:200]
        print(f"[firebase] STOCK order failed for {ticker}: {err}")
        return False, err


def execute_firebase_option(sig):
    """Market buy 2 contracts + separate stop_limit SELL at stop_loss (R1 L2 — no OCO)."""
    ticker = sig.get("ticker")
    try:
        sl = float(sig.get("stop_loss"))
    except Exception:
        return False, "missing stop_loss"

    occ_symbol = build_alpaca_option_symbol(
        ticker, sig.get("strike"), sig.get("is_put"), sig.get("expiry_ts")
    )
    if not occ_symbol:
        return False, "symbol build failed"

    # Step 1: market buy
    buy_body = {
        "symbol": occ_symbol,
        "qty": str(FIREBASE_OPTION_CONTRACTS),
        "side": "buy",
        "type": "market",
        "time_in_force": "day",
    }
    buy_result = alpaca_post("/v2/orders", buy_body)
    if isinstance(buy_result, tuple):
        buy_result = buy_result[0]
    if not (isinstance(buy_result, dict) and "id" in buy_result):
        err = buy_result if isinstance(buy_result, str) else json.dumps(buy_result)[:200]
        print(f"[firebase] OPTION buy failed for {occ_symbol}: {err}")
        return False, err

    buy_oid = buy_result.get("id", "?")

    # Step 2: stop_limit sell at SL (R1 only allows stop_limit on options)
    sl_limit = round(sl * 0.95, 2)  # 5% slippage tolerance below stop trigger
    sell_body = {
        "symbol": occ_symbol,
        "qty": str(FIREBASE_OPTION_CONTRACTS),
        "side": "sell",
        "type": "stop_limit",
        "stop_price": f"{sl:.2f}",
        "limit_price": f"{sl_limit:.2f}",
        "time_in_force": "gtc",
    }
    sell_result = alpaca_post("/v2/orders", sell_body)
    if isinstance(sell_result, tuple):
        sell_result = sell_result[0]
    sl_ok = (isinstance(sell_result, dict) and "id" in sell_result)
    sl_oid = sell_result.get("id", "?") if sl_ok else "FAILED"

    msg = (
        f"FIREBASE OPTION BUY {FIREBASE_OPTION_CONTRACTS}x {occ_symbol} (market)\n"
        f"Stop_limit SELL @ ${sl:.2f} trigger / ${sl_limit:.2f} limit | {'placed' if sl_ok else 'SL FAILED'}\n"
        f"Source: {sig.get('source','?')} | Buy: {buy_oid} | SL: {sl_oid}\n"
        f"NO AUTO TP (R1 L2 stop_limit only) - manage TP manually"
    )
    send_telegram(msg)
    send_discord(msg)
    print(f"[firebase] {msg}")
    return True, buy_oid


def process_firebase_signals():
    """Pull fresh Firebase signals, dedupe, execute on R1."""
    if not FIREBASE_SIGNALS_FILE.exists():
        print("[firebase] no signals file")
        return

    try:
        sigs = json.loads(FIREBASE_SIGNALS_FILE.read_text())
    except Exception as e:
        print(f"[firebase] failed to load: {e}")
        return

    seen = load_firebase_seen()
    now_utc = datetime.now(timezone.utc)

    fresh_unseen = []
    for s in sigs:
        sig_id = s.get("id")
        if not sig_id or sig_id in seen:
            continue
        captured = s.get("captured_at", "")
        try:
            cap_dt = datetime.fromisoformat(captured.replace("Z","+00:00"))
            if cap_dt.tzinfo is None:
                cap_dt = cap_dt.replace(tzinfo=timezone.utc)
            age_hours = (now_utc - cap_dt).total_seconds() / 3600
        except Exception:
            continue
        if age_hours <= FIREBASE_MAX_AGE_HOURS:
            fresh_unseen.append(s)

    if not fresh_unseen:
        print(f"[firebase] no fresh unseen signals (total={len(sigs)}, seen={len(seen)})")
        return

    print(f"[firebase] {len(fresh_unseen)} fresh signal(s) to execute")
    for s in fresh_unseen:
        sig_id = s.get("id")
        ticker = s.get("ticker", "?")
        is_option = (s.get("strike") is not None) and (s.get("is_put") is not None)

        if is_option:
            ok, info = execute_firebase_option(s)
        else:
            ok, info = execute_firebase_stock(s)

        if ok:
            seen.add(sig_id)
        else:
            print(f"[firebase] skipping {ticker} ({sig_id}): {info}")

    save_firebase_seen(seen)


def main():
    if not ALPACA_KEY or not ALPACA_SECRET:
        print("No Alpaca keys found")
        return

    state = load_state()
    today = NOW.strftime("%Y-%m-%d")

    # Reset daily trade count
    if state.get("last_trade_date") != today:
        state["trades_today"] = 0
        state["last_trade_date"] = today

    # Get account info
    account = get_account()
    equity = float(account.get("equity", 0))

    if equity < MIN_ACCOUNT_EQUITY:
        print(f"Account equity ${equity:,.2f} below minimum ${MIN_ACCOUNT_EQUITY:,.2f}. Not trading.")
        return

    # Get current positions
    positions = get_positions()

    # Read SuperTrend signal
    signal = read_supertrend_signal()
    if not signal:
        print("No signal data available")
        return

    regime = read_market_regime()

    # Check if this is a new signal — use timestamp, not price
    # Old method used price which breaks when TradingView sends null price
    signal_time = signal.get("signal_time", "")
    signal_id = f"{signal['direction']}_{signal_time}"
    if signal_id == state.get("last_signal_id"):
        # No new signal
        return

    print(f"New signal detected: {signal['direction']} @ ${signal.get('entry_price') or 0:,.2f}")
    print(f"Market regime: {regime.get('overall_regime', '?')} | Bias: {regime.get('direction_bias', '?')}")

    # Check existing BTC position
    btc_pos = check_existing_btc_position(positions)

    # === TRADING LOGIC ===
    # Supports both LONG and SHORT positions

    def get_current_price():
        """Fetch BTC price when signal doesn't include one."""
        p = signal.get("entry_price") or 0
        if not p or p <= 0:
            try:
                r = SESSION.get("https://api.coingecko.com/api/v3/simple/price",
                    params={"ids": "bitcoin", "vs_currencies": "usd"}, timeout=10)
                p = r.json().get("bitcoin", {}).get("usd", 0)
                print(f"  Fetched current BTC price: ${p:,.2f}")
            except:
                p = 0
        return p

    def cancel_btc_orders():
        """Cancel all open stop/limit orders for BTC."""
        try:
            orders = alpaca_get("/v2/orders?status=open&symbols=BTC/USD")
            if isinstance(orders, list):
                for o in orders:
                    SESSION.delete(f"{ALPACA_BASE}/v2/orders/{o['id']}",
                        headers=alpaca_headers(), timeout=10)
                    print(f"  Cancelled order {o['id']}")
        except:
            pass

    def close_position(btc_pos, reason="SuperTrend flip"):
        """Close existing BTC position (long or short)."""
        qty = btc_pos["qty"]
        price = btc_pos["current"]
        pnl = btc_pos["pnl_pct"]
        side = btc_pos["side"]
        close_side = "sell" if side == "long" else "buy"

        print(f"CLOSING {side.upper()} — {close_side}ing {qty} BTC/USD @ ~${price:,.2f} (P/L: {pnl:+.2f}%)")
        result, status = place_market_order("BTCUSD", qty, close_side)

        if status in (200, 201):
            order_id = result.get("id", "?")
            emoji = "\U0001f7e2" if pnl >= 0 else "\U0001f534"
            msg = (
                f"{emoji} AUTO TRADE — CLOSE {side.upper()} BTC/USD ({reason})\n"
                f"Qty: {qty} | Exit: ~${price:,.2f}\n"
                f"Entry was: ${btc_pos['entry']:,.2f}\n"
                f"P/L: {pnl:+.2f}%\n"
                f"Order: {order_id}\n"
                f"— Auto Trader | {NOW.strftime('%I:%M %p EDT')}"
            )
            send_telegram(msg)
            send_discord(msg)
            print(f"  \u2705 Position closed: {order_id}")
            cancel_btc_orders()

            log_trade({
                "timestamp": NOW.isoformat(),
                "action": f"CLOSE_{side.upper()}",
                "symbol": "BTC/USD",
                "qty": qty,
                "price": price,
                "entry_was": btc_pos["entry"],
                "pnl_pct": pnl,
                "order_id": order_id,
                "signal": signal,
            })
            state["trades_today"] += 1
            return True
        else:
            print(f"  \u274c Close failed: {result}")
            return False

    def open_position(direction, price):
        """Open a new BTC position (long or short)."""
        side = "buy" if direction == "LONG" else "sell"
        qty = calculate_position_size(account, price)

        if qty <= 0:
            print("Position size too small")
            return

        # Stop loss and take profit (reversed for shorts)
        if direction == "LONG":
            stop_price = price * (1 - STOP_LOSS_PCT / 100)
            tp_price = price * (1 + TAKE_PROFIT_PCT / 100)
        else:
            stop_price = price * (1 + STOP_LOSS_PCT / 100)
            tp_price = price * (1 - TAKE_PROFIT_PCT / 100)

        print(f"{'BUYING' if direction == 'LONG' else 'SHORTING'} {qty} BTC/USD @ ~${price:,.2f}")
        result, status = place_market_order("BTCUSD", qty, side)

        if status in (200, 201):
            order_id = result.get("id", "?")
            emoji = "\U0001f7e2" if direction == "LONG" else "\U0001f534"
            msg = (
                f"{emoji} AUTO TRADE — {side.upper()} BTC/USD ({direction})\n"
                f"Qty: {qty} | Entry: ~${price:,.2f}\n"
                f"Stop Loss: ${stop_price:,.2f} ({'-' if direction == 'LONG' else '+'}{STOP_LOSS_PCT}%)\n"
                f"Take Profit: ${tp_price:,.2f} ({'+' if direction == 'LONG' else '-'}{TAKE_PROFIT_PCT}%)\n"
                f"R/R: {TAKE_PROFIT_PCT/STOP_LOSS_PCT:.1f}:1\n"
                f"Regime: {regime.get('overall_regime', '?')} | Bias: {regime.get('direction_bias', '?')}\n"
                f"Order: {order_id}\n"
                f"— Auto Trader | {NOW.strftime('%I:%M %p EDT')}"
            )
            send_telegram(msg)
            send_discord(msg)
            print(f"  \u2705 Order placed: {order_id}")

            # Wait for fill
            import time as _time
            _time.sleep(2)

            # Place bracket orders (stop + TP)
            actual_pos = check_existing_btc_position(get_positions())
            actual_qty = actual_pos["qty"] if actual_pos else qty

            if direction == "LONG":
                stop_result, stop_status = place_stop_order("BTCUSD", actual_qty, stop_price)
            else:
                # For short: stop loss is a BUY stop above entry
                stop_order = {
                    "symbol": "BTC/USD",
                    "qty": str(actual_qty),
                    "side": "buy",
                    "type": "stop_limit",
                    "time_in_force": "gtc",
                    "stop_price": str(round(stop_price, 2)),
                    "limit_price": str(round(stop_price * 1.005, 2)),
                }
                stop_result, stop_status = alpaca_post("/v2/orders", stop_order)

            if stop_status in (200, 201):
                print(f"  \u2705 Stop loss set @ ${stop_price:,.2f}")
            else:
                print(f"  \u26a0\ufe0f Stop loss failed: {stop_result}")

            if direction == "LONG":
                tp_result, tp_status = place_limit_order("BTCUSD", actual_qty, tp_price)
            else:
                # For short: take profit is a BUY limit below entry
                tp_order = {
                    "symbol": "BTC/USD",
                    "qty": str(actual_qty),
                    "side": "buy",
                    "type": "limit",
                    "time_in_force": "gtc",
                    "limit_price": str(round(tp_price, 2)),
                }
                tp_result, tp_status = alpaca_post("/v2/orders", tp_order)

            if tp_status in (200, 201):
                print(f"  \u2705 Take profit set @ ${tp_price:,.2f}")
            else:
                print(f"  \u26a0\ufe0f Take profit failed: {tp_result}")

            log_trade({
                "timestamp": NOW.isoformat(),
                "action": side.upper(),
                "direction": direction,
                "symbol": "BTC/USD",
                "qty": qty,
                "price": price,
                "stop": stop_price,
                "target": tp_price,
                "order_id": order_id,
                "regime": regime.get("overall_regime"),
                "signal": signal,
            })
            state["trades_today"] += 1
        else:
            print(f"  \u274c Order failed: {result}")
            send_telegram(f"\u274c AUTO TRADE FAILED — {side.upper()} BTC/USD\nError: {result.get('message', result)}")

    # === EXECUTE ===

    price = get_current_price()
    if price <= 0:
        print("  No price available, skipping")
        state["last_signal_id"] = signal_id
        save_state(state)
        return

    if signal["direction"] == "LONG":
        if btc_pos and btc_pos["side"] == "long":
            print(f"Already LONG BTC. Holding.")
        elif btc_pos and btc_pos["side"] == "short":
            # Flip: close short, open long
            print("Flipping SHORT → LONG")
            if close_position(btc_pos, "Flip to LONG"):
                import time as _time
                _time.sleep(1)
                open_position("LONG", price)
        else:
            # No position, open long
            open_position("LONG", price)

    elif signal["direction"] == "SHORT":
        if btc_pos and btc_pos["side"] == "short":
            print(f"Already SHORT BTC. Holding.")
        elif btc_pos and btc_pos["side"] == "long":
            # Flip: close long, open short
            print("Flipping LONG → SHORT")
            if close_position(btc_pos, "Flip to SHORT"):
                import time as _time
                _time.sleep(1)
                open_position("SHORT", price)
        else:
            # No position, open short
            open_position("SHORT", price)

    state["last_signal_id"] = signal_id
    save_state(state)


    # === Firebase signal execution (R1) ===
    try:
        process_firebase_signals()
    except Exception as e:
        print(f"[firebase] process error: {e}")


if __name__ == "__main__":
    main()
