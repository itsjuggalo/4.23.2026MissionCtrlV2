#!/usr/bin/env python3
"""strategy_paper_summary.py — daily armed-strategy P&L summary → LifeClaw (non-trading TG bot).

Reads the live strategy-paper book via missionctrl /api/strategy-paper (per-strat dir/uPnL/
realized/equity + accounts), formats a compact summary, and posts it to Mike on the LifeClaw
bot (LIFE/ops lane, never a trading bot). Additive + read-only against trading state; delete
this script + its cron line to fully undo.

Part (b) of capsule terminal-pro-promote-enhancements. Part (a) (Hyperliquid testnet venue)
stays parked on Mike's testnet wallet/faucet.
"""
import json, os, sys, urllib.request, urllib.parse
from pathlib import Path

API = os.environ.get("STRAT_PAPER_API", "http://localhost:3000/api/strategy-paper")
SEC = Path.home() / ".openclaw" / "secrets"

def _secret(name):
    p = SEC / name
    return p.read_text().strip() if p.exists() else ""

def _fmt_usd(v):
    try: v = float(v)
    except (TypeError, ValueError): return "n/a"
    return f"{'+' if v >= 0 else '-'}${abs(v):,.2f}"

def build():
    try:
        with urllib.request.urlopen(API, timeout=15) as r:
            d = json.load(r)
    except Exception as e:
        return f"⚠️ Strategy P&L summary: /api/strategy-paper unreachable ({e})."
    positions = d.get("positions", []) or []
    accounts  = d.get("accounts", [])  or []
    if not positions and not accounts:
        return "📊 Armed Strategies — none armed to paper right now. (Promote a strategy in Terminal Pro to start tracking.)"
    lines = ["📊 *Armed Strategies — Daily P&L*"]
    if positions:
        lines.append("\n*Open positions*")
        for p in positions:
            strat = p.get("strat") or p.get("key") or "?"
            coin  = p.get("coin") or p.get("symbol") or ""
            dir_  = (p.get("dir") or "").upper()
            upnl  = p.get("unrealized", p.get("uPnL"))
            lines.append(f"• {strat} {coin} {dir_} — uPnL {_fmt_usd(upnl)}")
    tot_u = sum(float(p.get("unrealized", p.get("uPnL", 0)) or 0) for p in positions)
    tot_r = tot_e = 0.0
    if accounts:
        lines.append("\n*By strategy*")
        for a in accounts:
            strat = a.get("strat") or a.get("key") or "?"
            realized = a.get("realized", 0); equity = a.get("equity", 0)
            wr = a.get("win_pct", a.get("winPct"))
            wr_s = f" · WR {float(wr):.0f}%" if wr is not None else ""
            lines.append(f"• {strat}: realized {_fmt_usd(realized)} · equity {_fmt_usd(equity)}{wr_s}")
            tot_r += float(realized or 0); tot_e += float(equity or 0)
    lines.append(f"\n*TOTAL* — uPnL {_fmt_usd(tot_u)} · realized {_fmt_usd(tot_r)} · equity {_fmt_usd(tot_e)}")
    lines.append("_paper/research only_")
    return "\n".join(lines)

def send(text):
    token = _secret("lifeclaw_telegram_bot_token")
    chat  = _secret("lifeclaw_telegram_chat_id")
    if not token or not chat:
        print("ERROR: LifeClaw token/chat_id missing", file=sys.stderr); return 2
    data = urllib.parse.urlencode({"chat_id": chat, "text": text,
                                   "parse_mode": "Markdown", "disable_web_page_preview": "true"}).encode()
    try:
        with urllib.request.urlopen(f"https://api.telegram.org/bot{token}/sendMessage", data=data, timeout=15) as r:
            ok = json.load(r).get("ok")
            print("sent" if ok else "send-not-ok"); return 0 if ok else 1
    except Exception as e:
        print(f"ERROR sending: {e}", file=sys.stderr); return 1

if __name__ == "__main__":
    msg = build()
    if "--dry" in sys.argv:
        print(msg)
    else:
        sys.exit(send(msg))
