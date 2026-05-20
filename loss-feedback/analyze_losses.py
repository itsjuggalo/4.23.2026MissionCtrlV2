#!/usr/bin/env python3
"""Loss Feedback Loop — runs after market close.
For each pick that closed at >5% loss today on Boba/Jazzy:
  1. Pull the original pick reasoning from daily_picks state
  2. Pull the actual trade outcome from Alpaca
  3. Ask Claude Haiku what went wrong (cheap LLM call)
  4. Append a "lessons learned" line to ~/.openclaw/workspace/memory/<account>_lessons.md
The decision cycle prompt builders inject the latest lessons into the next cycle's prompt.
"""
import os, json, requests
from pathlib import Path
from datetime import datetime, timezone
from zoneinfo import ZoneInfo

SECRETS = Path("/home/ubuntu/.openclaw/secrets")
MEMORY = Path("/home/ubuntu/.openclaw/workspace/memory")
MEMORY.mkdir(parents=True, exist_ok=True)
WEBHOOK = (SECRETS / "discord_webhook_autofix").read_text().strip()
ANTHROPIC_KEY = (SECRETS / "anthropic_api_key").read_text().strip()
LOSS_THRESHOLD_PCT = 5.0
ET = ZoneInfo("America/New_York")

def alpaca_orders(account):
    k = (SECRETS / f"alpaca-{account}-key-id").read_text().strip()
    s = (SECRETS / f"alpaca-{account}-secret").read_text().strip()
    today = datetime.now(ET).strftime("%Y-%m-%dT00:00:00-05:00")
    r = requests.get(
        "https://paper-api.alpaca.markets/v2/orders",
        headers={"APCA-API-KEY-ID": k, "APCA-API-SECRET-KEY": s},
        params={"status": "filled", "after": today, "limit": 200, "direction": "desc"},
        timeout=15,
    )
    return r.json()

def fifo_match(orders):
    by_sym = {}
    for o in sorted(orders, key=lambda x: x.get("filled_at","")):
        s = o["symbol"]; by_sym.setdefault(s, {"buys": [], "sells": []})
        side = o["side"]; qty = float(o.get("filled_qty", 0)); px = float(o.get("filled_avg_price") or 0)
        if qty <= 0 or px <= 0: continue
        by_sym[s][f"{side}s"].append({"qty": qty, "px": px, "at": o.get("filled_at")})
    closes = []
    for sym, ob in by_sym.items():
        buys = [dict(b) for b in ob["buys"]]
        for sell in ob["sells"]:
            sell_qty = sell["qty"]
            while sell_qty > 0 and buys:
                b = buys[0]
                m = min(sell_qty, b["qty"])
                pnl_pct = (sell["px"] - b["px"]) / b["px"] * 100
                pnl_dollars = (sell["px"] - b["px"]) * m * (100 if "/" not in sym and len(sym) > 6 else 1)
                closes.append({"sym": sym, "buy": b["px"], "sell": sell["px"], "pnl_pct": pnl_pct, "pnl_dollars": pnl_dollars,
                               "buy_at": b["at"], "sell_at": sell["at"], "qty": m})
                b["qty"] -= m; sell_qty -= m
                if b["qty"] <= 0: buys.pop(0)
    return closes

def claude_analyze(account, loss):
    """Cheap Haiku call to summarize what went wrong in 1 sentence."""
    prompt = f"""You're reviewing a closed trade on {account}'s paper account. It lost money.

Symbol: {loss['sym']}
Buy price: ${loss['buy']:.4f}  ({loss['buy_at']})
Sell price: ${loss['sell']:.4f}  ({loss['sell_at']})
P/L: {loss['pnl_pct']:+.1f}% / ${loss['pnl_dollars']:+.2f}
Quantity: {loss['qty']}

Write ONE concise lesson-learned sentence (max 25 words) that {account} should remember on similar setups. Format: "AVOID:" or "PREFER:" then the rule. Example: "AVOID: 0DTE ATM calls on bull-flagged tickers without explicit catalyst within market hours — theta crushes faster than directional thesis pays off."

Just the one sentence. No preamble."""
    try:
        r = requests.post("https://api.anthropic.com/v1/messages",
            headers={"x-api-key": ANTHROPIC_KEY, "anthropic-version": "2023-06-01", "content-type": "application/json"},
            json={"model": "claude-haiku-4-5-20251001", "max_tokens": 100, "messages": [{"role": "user", "content": prompt}]},
            timeout=20)
        data = r.json()
        return data.get("content", [{}])[0].get("text", "").strip()
    except Exception as e:
        return f"(claude error: {e})"

def append_lesson(account, lesson, sym, pnl_pct):
    f = MEMORY / f"{account}_lessons.md"
    today = datetime.now(ET).strftime("%Y-%m-%d")
    line = f"- [{today}] {sym} ({pnl_pct:+.1f}%): {lesson}\n"
    if f.exists():
        existing = f.read_text()
        if line.strip() in existing: return False
        f.write_text(existing + line)
    else:
        f.write_text(f"# {account.title()} Lessons Learned\n\nAuto-appended after each losing trade by loss-feedback cron.\n\n" + line)
    return True

def post_discord(embed):
    requests.post(WEBHOOK, json={"username": "Loss Feedback", "embeds": [embed]}, timeout=10)

def main():
    et_time = datetime.now(ET).strftime("%a %b %-d, %-I:%M %p ET")
    summary_fields = []
    new_lessons = 0
    for account in ["boba", "jazzy"]:
        try:
            orders = alpaca_orders(account)
        except Exception as e:
            print(f"[{account}] order fetch fail: {e}"); continue
        closes = fifo_match(orders)
        losses = [c for c in closes if c["pnl_pct"] <= -LOSS_THRESHOLD_PCT]
        if not losses:
            summary_fields.append({"name": f"🦙 {account.title()}", "value": f"_no losses ≥ {LOSS_THRESHOLD_PCT}% today_", "inline": False})
            continue
        lines = []
        for L in losses:
            lesson = claude_analyze(account, L)
            if append_lesson(account, lesson, L["sym"], L["pnl_pct"]): new_lessons += 1
            lines.append(f"`{L['sym']:<22}` `{L['pnl_pct']:+.1f}%` ${L['pnl_dollars']:+.0f}\n→ {lesson[:200]}")
        summary_fields.append({"name": f"🦙 {account.title()} ({len(losses)} losses)", "value": "\n\n".join(lines)[:1024], "inline": False})
    color = 15548997 if new_lessons else 7506394
    post_discord({
        "author": {"name": f"Loss Feedback · {et_time}"},
        "title": f"📚 {new_lessons} lesson(s) added" if new_lessons else "📚 No new lessons today",
        "description": "Lessons saved to `~/.openclaw/workspace/memory/<account>_lessons.md` — injected into next cycle's prompt.",
        "color": color,
        "fields": summary_fields,
        "timestamp": datetime.now(timezone.utc).isoformat(),
    })
    print(f"new lessons: {new_lessons}")

if __name__ == "__main__":
    main()
