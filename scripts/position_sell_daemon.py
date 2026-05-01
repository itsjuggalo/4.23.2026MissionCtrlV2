#!/usr/bin/env python3
"""
Position Sell Daemon v2 — trailing stops + EOD protection + IV-aware sizing.

Runs every 15 min during market hours via cron. For each open Alpaca position:
  1. Fetch live bid/ask/IV from Tradier sandbox
  2. Determine trail phase based on highest-ever PnL% (sticky — won't loosen)
  3. Set stop-loss % per phase:
       Entry → +25% high    : SL = -30% (or -20% if IV>0.80 when Tradier responds)
       +25%  → +50% high    : SL = breakeven (0%)
       +50%  → +100% high   : SL = +25% locked
       +100% high+          : SL = +50% locked
  4. Check current PnL vs phase SL:
       - SELL_STOP   : PnL <= phase SL, close via limit at bid
       - SELL_PROFIT : PnL >= +50% take-profit, close via limit at bid
       - EOD_CLOSE   : after 3:45 PM ET if PnL <= -15% (prevent overnight gap)
       - WARN        : ±15% range  — notify only
       - HOLD        : otherwise — log only
  5. Execute closes via POST /v2/orders as sell LIMIT orders (not market).
     Limit is priced at the current bid (fills immediately if bid is real).
  6. Post to BobaTrades Discord webhook on every trail adjust / warn / fire.

State persisted at ~/.openclaw/workspace/state/position_daemon/trails.json
so phase tracking survives cron invocations.
"""
import argparse
import json
import os
import sys
import time
from datetime import datetime, timezone, timedelta
from pathlib import Path

sys.path.insert(0, "/home/ubuntu/scripts/lib")
sys.path.insert(0, "/home/ubuntu/mission-control/agent-team")

try:
    from tradier_client import fetch_option_quote
except Exception:
    fetch_option_quote = None

try:
    from post_helper import post_to_telegram
except Exception:
    def post_to_telegram(**kwargs):
        pass

try:
    from ops_log import log_to_ops
except Exception:
    def log_to_ops(*args, **kwargs):
        print(f"[log] {args} {kwargs}")

SECRETS = Path("/home/ubuntu/.openclaw/secrets")
STATE_DIR = Path("/home/ubuntu/.openclaw/workspace/state/position_daemon")
STATE_DIR.mkdir(parents=True, exist_ok=True)
TRAILS_FILE = STATE_DIR / "trails.json"
NOTIFIED_FILE = STATE_DIR / "notified.json"
LOG_FILE = STATE_DIR / "daemon.log"

ALPACA_BASE = "https://paper-api.alpaca.markets"

# === Tunables ===
PROFIT_TAKE_PCT = 50.0       # Hard take-profit at +50%
WARN_PROFIT_PCT = 25.0       # Notify at +25%
WARN_LOSS_PCT = -15.0        # Notify at -15%
EOD_CLOSE_THRESHOLD_PCT = -15.0  # EOD close trigger
EOD_HOUR_ET = 15             # 3 PM ET
EOD_MINUTE_ET = 45           # 3:45 PM ET
HIGH_IV_THRESHOLD = 0.80     # Above this, tighten stops
HIGH_IV_STOP_PCT = -20.0     # Tighter stop for high-IV contracts
NORMAL_STOP_PCT = -30.0      # Default stop


def read_secret(name: str) -> str:
    for fname in (name, name + ".txt"):
        p = SECRETS / fname
        if p.exists():
            return p.read_text().strip()
    return ""



def assert_correct_account():
    """Crash if this daemon is pointed at the wrong Alpaca account."""
    import requests
    try:
        r = requests.get(f"{ALPACA_BASE}/v2/account", headers=alpaca_headers(), timeout=10)
        if r.status_code != 200:
            print(f"[FATAL] Cannot reach Alpaca: HTTP {r.status_code}", flush=True)
            raise SystemExit(1)
        actual = r.json().get("account_number", "")
        if actual != EXPECTED_ACCOUNT:
            print(f"[FATAL] Account mismatch! Expected R1 ({EXPECTED_ACCOUNT}) but got {actual}.", flush=True)
            print(f"[FATAL] This daemon manages R1 only. Refusing to run on the wrong account.", flush=True)
            raise SystemExit(2)
        equity = float(r.json().get("equity", 0))
        print(f"[startup] ✓ Confirmed R1 account {actual} (equity ${equity:,.0f}) — managing R1 positions only", flush=True)
    except SystemExit: raise
    except Exception as e:
        print(f"[FATAL] Account check exception: {e}", flush=True)
        raise SystemExit(3)


# DAEMON ACCOUNT LOCK: this daemon is hardcoded to R1 (PA3Y7UTNIQFZ).
# Do not change to alpaca-key-id/alpaca-secret — those are R2 (Boba's account, managed by trail_daemon).
EXPECTED_ACCOUNT = "PA3Y7UTNIQFZ"  # R1

def alpaca_headers() -> dict:
    return {
        "APCA-API-KEY-ID": read_secret("alpaca-r1-key-id"),
        "APCA-API-SECRET-KEY": read_secret("alpaca-r1-secret"),
        "Content-Type": "application/json",
    }


def fetch_alpaca_positions() -> list:
    import requests
    try:
        r = requests.get(f"{ALPACA_BASE}/v2/positions", headers=alpaca_headers(), timeout=10)
        return r.json() if r.status_code == 200 else []
    except Exception as e:
        log_to_ops("position_daemon", "ERROR", f"Fetch positions failed: {e}")
        return []


def cancel_open_sells_for_symbol(symbol: str) -> int:
    """
    Cancel any open sell orders (OCO bracket legs, stop_limits, limits) for this symbol.
    Needed because Boba's Layer 2 arms OCO brackets that would reject our Layer 1 sell
    with "insufficient balance" since shares are reserved. Returns count cancelled.
    """
    import requests
    try:
        r = requests.get(f"{ALPACA_BASE}/v2/orders?status=open&limit=100",
                         headers=alpaca_headers(), timeout=10)
        if r.status_code != 200:
            return 0
        cancelled = 0
        for o in r.json():
            if o.get("symbol") == symbol and o.get("side") == "sell":
                del_r = requests.delete(f"{ALPACA_BASE}/v2/orders/{o.get('id')}",
                                        headers=alpaca_headers(), timeout=5)
                if del_r.status_code in (200, 204):
                    cancelled += 1
        # Alpaca needs ~1-2 sec to release reserved shares after cancel
        if cancelled > 0:
            import time as _t
            _t.sleep(2)
        return cancelled
    except Exception:
        return 0


def submit_sell_limit(symbol: str, qty: float, limit_price: float) -> dict:
    """Submit a sell LIMIT order. Returns {ok, order_id, error}.
    First cancels any open OCO/bracket legs for this symbol to release reserved shares."""
    cancelled = cancel_open_sells_for_symbol(symbol)
    if cancelled > 0:
        print(f"  [daemon] cancelled {cancelled} open sell order(s) on {symbol} before new sell")
    import requests
    body = {
        "symbol": symbol,
        "qty": str(int(qty)),
        "side": "sell",
        "type": "limit",
        "time_in_force": "day",
        "limit_price": f"{limit_price:.2f}",
    }
    try:
        r = requests.post(f"{ALPACA_BASE}/v2/orders", headers=alpaca_headers(),
                          json=body, timeout=10)
        if r.status_code in (200, 201):
            return {"ok": True, "order_id": r.json().get("id"), "response": r.json()}
        return {"ok": False, "error": f"HTTP {r.status_code}: {r.text[:200]}"}
    except Exception as e:
        return {"ok": False, "error": str(e)}


def post_bobatrades(content: str, embed: dict = None):
    """Post to BobaTrades Discord webhook."""
    import requests
    url = read_secret("discord_bobatrades_webhook")
    if not url:
        return False
    payload = {"content": content, "username": "Position Daemon"}
    if embed:
        payload["embeds"] = [embed]
    try:
        r = requests.post(url, json=payload, timeout=10)
        return r.status_code in (200, 204)
    except Exception:
        return False


def load_trails() -> dict:
    if TRAILS_FILE.exists():
        try:
            return json.loads(TRAILS_FILE.read_text())
        except Exception:
            return {}
    return {}


def save_trails(trails: dict):
    TRAILS_FILE.write_text(json.dumps(trails, indent=2))


def load_notified() -> dict:
    if NOTIFIED_FILE.exists():
        try:
            return json.loads(NOTIFIED_FILE.read_text())
        except Exception:
            return {}
    return {}


def save_notified(n: dict):
    NOTIFIED_FILE.write_text(json.dumps(n, indent=2))


def classify_phase(highest_pct: float) -> str:
    """Trailing phase based on highest-ever PnL%."""
    if highest_pct >= 100.0:
        return "RIDE"           # SL locked at +50%
    if highest_pct >= 50.0:
        return "LOCK_PROFIT"    # SL locked at +25%
    if highest_pct >= 25.0:
        return "PROTECT_ENTRY"  # SL at breakeven
    return "NORMAL"             # SL at default stop


def stop_pct_for_phase(phase: str, iv: float) -> float:
    """Return stop-loss % for the phase, tightened if IV>threshold."""
    if phase == "RIDE":
        return 50.0
    if phase == "LOCK_PROFIT":
        return 25.0
    if phase == "PROTECT_ENTRY":
        return 0.0
    # NORMAL phase — check IV
    if iv and iv >= HIGH_IV_THRESHOLD:
        return HIGH_IV_STOP_PCT
    return NORMAL_STOP_PCT


def is_past_eod() -> bool:
    """Returns True if current time is after 3:45 PM ET."""
    # UTC-4 during EDT (we're in April). TODO: DST-aware for Nov–Mar.
    et = datetime.now(timezone.utc) - timedelta(hours=4)
    if et.weekday() >= 5:  # Saturday/Sunday
        return False
    return (et.hour, et.minute) >= (EOD_HOUR_ET, EOD_MINUTE_ET)


def main():
    p = argparse.ArgumentParser()
    p.add_argument("--execute", action="store_true",
                   help="Actually submit close orders (default: dry-run)")
    p.add_argument("--quiet", action="store_true",
                   help="Suppress HOLD logs")
    p.add_argument("--test-symbol", default=None,
                   help="Only process this symbol (for testing)")
    args = p.parse_args()

    mode = "EXECUTE" if args.execute else "DRY-RUN"
    cycle_start = datetime.now(timezone.utc)
    log_to_ops("position_daemon", "INFO", f"Cycle start ({mode})")

    positions = fetch_alpaca_positions()
    if not positions:
        log_to_ops("position_daemon", "WARN", "No positions fetched")
        print(f"[{mode}] No positions")
        return 0

    if args.test_symbol:
        positions = [p for p in positions if p.get("symbol") == args.test_symbol]

    trails = load_trails()
    notified = load_notified()
    today_key = cycle_start.strftime("%Y-%m-%d")
    if notified.get("_date") != today_key:
        notified = {"_date": today_key}

    past_eod = is_past_eod()
    actions_taken = []

    for pos in positions:
        symbol = pos.get("symbol", "?")
        qty = float(pos.get("qty", 0))
        entry = float(pos.get("avg_entry_price", 0))
        current = float(pos.get("current_price", 0) or 0)
        pnl_pct = float(pos.get("unrealized_plpc", 0)) * 100
        pnl_usd = float(pos.get("unrealized_pl", 0))

        # Update sticky high watermark
        trail = trails.get(symbol, {"highest_pct": pnl_pct, "phase": "NORMAL"})
        if pnl_pct > trail.get("highest_pct", pnl_pct):
            trail["highest_pct"] = pnl_pct
        phase = classify_phase(trail["highest_pct"])
        trail["phase"] = phase

        # Fetch live IV from Tradier
        iv = None
        bid = current
        if fetch_option_quote:
            q = fetch_option_quote(symbol)
            if q:
                iv = q.get("iv")
                bid = q.get("bid") or current

        phase_stop_pct = stop_pct_for_phase(phase, iv or 0)
        trail["stop_pct"] = phase_stop_pct
        trail["iv"] = iv
        trail["last_checked"] = cycle_start.isoformat()
        trails[symbol] = trail

        # Decide action
        action = "HOLD"
        reason = ""

        if pnl_pct >= PROFIT_TAKE_PCT:
            action = "SELL_PROFIT"
            reason = f"Hit +{PROFIT_TAKE_PCT}% take-profit"
        elif pnl_pct <= phase_stop_pct:
            action = "SELL_STOP"
            reason = f"Hit phase SL ({phase}, {phase_stop_pct:+.0f}%)"
        elif past_eod and pnl_pct <= EOD_CLOSE_THRESHOLD_PCT:
            action = "EOD_CLOSE"
            reason = f"EOD rule: {pnl_pct:+.1f}% after 3:45 PM ET"
        elif pnl_pct >= WARN_PROFIT_PCT:
            action = "WARN_PROFIT"
        elif pnl_pct <= WARN_LOSS_PCT:
            action = "WARN_LOSS"

        # Log the scan line
        log_msg = (f"{symbol} qty={qty:.0f} entry={entry:.2f} now={current:.2f} "
                   f"pnl={pnl_pct:+.1f}% (${pnl_usd:+,.0f}) IV={iv or 'n/a'} "
                   f"phase={phase} SL={phase_stop_pct:+.0f}% → {action}")
        print(log_msg)
        if not args.quiet or action != "HOLD":
            log_to_ops("position_daemon", "DATA", log_msg,
                       metadata={"symbol": symbol, "pnl_pct": pnl_pct, "iv": iv,
                                 "phase": phase, "action": action})

        # Execute closes
        if action in ("SELL_STOP", "SELL_PROFIT", "EOD_CLOSE"):
            # Price limit at bid (or current if Tradier unavailable). Rounds to nearest cent.
            limit_price = max(round(bid, 2), 0.01)
            if args.execute:
                result = submit_sell_limit(symbol, qty, limit_price)
                status = f"✅ Order {result.get('order_id','?')[:8]}" if result.get("ok") \
                         else f"❌ {result.get('error','?')[:80]}"
            else:
                status = f"DRY-RUN (would sell {qty:.0f} @ limit {limit_price:.2f})"

            actions_taken.append((symbol, action, pnl_pct, pnl_usd))

            emoji = {"SELL_PROFIT": "💰", "SELL_STOP": "🛑", "EOD_CLOSE": "🌙"}[action]
            content = (f"{emoji} **{action}** on `{symbol}`\n"
                       f"{reason}\n"
                       f"Entry ${entry:.2f} → ${current:.2f} | PnL {pnl_pct:+.1f}% (${pnl_usd:+,.0f})\n"
                       f"IV={iv or 'n/a'} | Phase={phase} | Highest={trail['highest_pct']:+.1f}%\n"
                       f"Status: {status}")
            post_bobatrades(content)
            post_to_telegram(agent="orion", message_type=f"Position {action}",
                             body=content, bypass_cooldown=True)

        # Warn notifications (deduplicated per day per symbol+action)
        elif action in ("WARN_PROFIT", "WARN_LOSS"):
            notif_key = f"{symbol}:{action}"
            if notified.get(notif_key) != today_key:
                notified[notif_key] = today_key
                emoji = "⚠️" if action == "WARN_LOSS" else "📈"
                content = (f"{emoji} **{action}** on `{symbol}`\n"
                           f"Entry ${entry:.2f} → ${current:.2f} | PnL {pnl_pct:+.1f}% (${pnl_usd:+,.0f})\n"
                           f"IV={iv or 'n/a'} | Phase={phase} | SL at {phase_stop_pct:+.0f}%")
                post_bobatrades(content)
                post_to_telegram(agent="orion", message_type="Position Alert", body=content)

        # Trail-adjust notification — notify once when phase advances
        prev_phase = trails.get(symbol, {}).get("phase_announced")
        if phase != "NORMAL" and prev_phase != phase:
            trails[symbol]["phase_announced"] = phase
            content = (f"🎯 **Trail advanced** `{symbol}` → **{phase}**\n"
                       f"Highest PnL: {trail['highest_pct']:+.1f}% | New SL: {phase_stop_pct:+.0f}%\n"
                       f"Current: {pnl_pct:+.1f}% (${pnl_usd:+,.0f})")
            post_bobatrades(content)

    save_trails(trails)
    save_notified(notified)

    summary = f"[{mode}] Scanned {len(positions)} positions. Actions: {len(actions_taken)} | EOD={past_eod}"
    print(summary)
    log_to_ops("position_daemon", "INFO", summary)
    return 0


if __name__ == "__main__":
    assert_correct_account()
    sys.exit(main())
