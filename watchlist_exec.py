#!/usr/bin/env python3
"""Watchlist Signals — alert + INERT auto-exec layer (capytrade clone).

  watchlist_exec.py alert   # LIVE: post the swing signal-drop to Discord + Telegram
  watchlist_exec.py exec    # TRIPLE-GATED Alpaca PAPER bracket orders — INERT by default

Auto-exec acts ONLY when ALL true: env WATCHLIST_EXEC=1, arm-file present, and the
live Alpaca account == EXPECTED_ACCOUNT. Otherwise it logs "INERT" and places nothing.
Reuses verified rails: lib/discord_post.post_discord, tg_fleet.send, lib/circuit_breaker.
"""
import json, os, sys, requests
from datetime import datetime
from pathlib import Path
from zoneinfo import ZoneInfo
sys.path.insert(0, "/home/itsju/scripts")
sys.path.insert(0, "/home/itsju/scripts/lib")

SIGNALS = Path("/AIWorkWSL/web/missionctrl/data/watchlist-signals.json")
SECRETS = Path.home() / ".openclaw" / "secrets"
STATE = Path.home() / ".openclaw" / "workspace" / "state"
ARM_FILE = STATE / "watchlist_exec_ARMED"
EXPECTED_ACCOUNT = "PA3W2OF36UVX"      # verified live 2026-06-22 (Boba R2 paper)
PAPER = "https://paper-api.alpaca.markets"
RISK_PER_TRADE = 100.0                 # $ risked entry→stop per order (small, capytrade-style)
SIGNAL_MAX_AGE_MIN = int(os.getenv("WATCHLIST_SIGNAL_MAX_AGE_MIN", "90"))
ET = ZoneInfo("America/New_York")
NOW_ET = lambda: datetime.now(ET).strftime("%H:%M")


def load(): return json.load(open(SIGNALS))


def _signals_fresh():
    if not SIGNALS.exists():
        return False, f"signals file missing: {SIGNALS}"
    mtime = datetime.fromtimestamp(SIGNALS.stat().st_mtime, ET)
    now = datetime.now(ET)
    age_min = (now - mtime).total_seconds() / 60
    if mtime.date() != now.date():
        return False, f"signals stale: mtime {mtime:%Y-%m-%d %H:%M ET}"
    if age_min > SIGNAL_MAX_AGE_MIN:
        return False, f"signals stale: {age_min:.0f} min old (max {SIGNAL_MAX_AGE_MIN})"
    return True, f"signals fresh: {age_min:.0f} min old"


def _discord(msg):
    try:
        from discord_post import post_discord
        return bool(post_discord(msg))
    except Exception as e:
        print("discord err:", e); return False


def _tg(msg):
    try:
        from tg_fleet import send as tg_send
        tg_send("trading_command", msg); return True
    except Exception as e:
        print("tg err:", e); return False


def fmt_swing(s):
    star = "⭐ " if s.get("hiConv") else ""
    arrow = "⬆" if s["dir"] == "LONG" else "⬇"
    return (f"{star}{arrow} SWING {s['dir']} · {s['symbol']} (score {s['score']}/10)\n"
            f"   Entry {s['entry']} · Stop {s['stop']} · Target {s['target']} · {s['rTarget']}R")


def alert():
    d = load(); swing = d.get("swing", [])
    if not swing:
        print("no swing signals to alert"); return
    top = swing[:6]
    body = (f"📡 Watchlist Signals · swing drop {NOW_ET()} ET · {len(swing)} fired\n\n"
            + "\n\n".join(fmt_swing(s) for s in top)
            + "\n\nPaper only · recommendation surface · auto-exec "
            + ("ARMED" if d.get("mode", {}).get("autoExec") else "OFF"))
    ok1, ok2 = _discord(body), _tg(body)
    print(f"alert sent — discord={ok1} tg={ok2}")


def _keys():
    return (SECRETS / "alpaca-key-id").read_text().strip(), (SECRETS / "alpaca-secret").read_text().strip()


def _account_ok():
    try:
        k, s = _keys()
        r = requests.get(f"{PAPER}/v2/account", headers={"APCA-API-KEY-ID": k, "APCA-API-SECRET-KEY": s}, timeout=10)
        return r.status_code == 200 and r.json().get("account_number") == EXPECTED_ACCOUNT
    except Exception as e:
        print("account check err:", e); return False


def armed():
    return os.getenv("WATCHLIST_EXEC") == "1" and ARM_FILE.exists()


def _bracket(symbol, side, qty, stop, target):
    k, s = _keys()
    payload = {"symbol": symbol, "qty": str(qty), "side": side, "type": "market",
               "time_in_force": "day", "order_class": "bracket",
               "take_profit": {"limit_price": str(round(target, 2))},
               "stop_loss": {"stop_price": str(round(stop, 2))}}
    r = requests.post(f"{PAPER}/v2/orders",
                      headers={"APCA-API-KEY-ID": k, "APCA-API-SECRET-KEY": s, "Content-Type": "application/json"},
                      json=payload, timeout=15)
    return (r.status_code in (200, 201), r.json() if r.status_code in (200, 201) else {"error": f"HTTP {r.status_code}", "body": r.text[:300]})


def exec_mode():
    if not armed():
        print(f"INERT — auto-exec OFF (WATCHLIST_EXEC={os.getenv('WATCHLIST_EXEC')}, "
              f"arm-file {'present' if ARM_FILE.exists() else 'absent'}). No orders placed.")
        return
    ok, why = _signals_fresh()
    if not ok:
        print(f"ABORT - {why}. No orders.")
        return
    if not _account_ok():
        print(f"ABORT — Alpaca account mismatch/unreachable (expected {EXPECTED_ACCOUNT}). No orders.")
        return
    try:
        from circuit_breaker import CircuitBreaker
        cb = CircuitBreaker("watchlist_exec", max_usd=2000, max_turns=20, max_hours=8, enabled=True)
    except Exception:
        cb = None
    d = load(); placed = []
    for s in d.get("swing", []):
        if not s.get("hiConv"):
            continue  # auto-exec ONLY the ⭐ hi-conviction setups
        if cb:
            ok, why = cb.check(auto_turn=False)
            if not ok:
                print(f"breaker blocked {s['symbol']}: {why}"); continue
        risk = abs(s["entry"] - s["stop"]) or 0.01
        qty = max(1, int(RISK_PER_TRADE / risk))
        side = "buy" if s["dir"] == "LONG" else "sell"
        ok, resp = _bracket(s["symbol"], side, qty, s["stop"], s["target"])
        if ok and cb:
            cb.record_turn(1); cb.record_spend(qty * s["entry"])
        msg = (f"{'✅' if ok else '❌'} AUTO {s['dir']} {qty}× {s['symbol']} @~{s['entry']} "
               f"SL {s['stop']} TP {s['target']} — {'order '+str(resp.get('id'))[:8] if ok else resp.get('error')}")
        _discord(msg); _tg(msg)
        placed.append({"ts": NOW_ET(), "symbol": s["symbol"], "action": "ENTRY", "mode": "swing-auto",
                       "detail": f"{qty}× {side} bracket", "pnlPct": None, "ok": ok})
    # append to execLog (front)
    d["execLog"] = (placed + d.get("execLog", []))[:50]
    SIGNALS.write_text(json.dumps(d))
    print(f"exec done — {len(placed)} order attempts ({sum(1 for p in placed if p['ok'])} ok)")


if __name__ == "__main__":
    mode = sys.argv[1] if len(sys.argv) > 1 else "alert"
    {"alert": alert, "exec": exec_mode}.get(mode, alert)()
