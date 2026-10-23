#!/home/itsju/.venv/bin/python
"""debt_due_alert.py — daily payment-due nudge to Mike's Telegram DM.

Reads the single-source debt tracker ~/.lifeclaw/debts.json and DMs Mike a
short, ADHD-friendly reminder when any card is PAST DUE or its minimum is due
soon, so a late fee never sneaks up. Alert-only, additive, reversible — never
touches trading, never writes money values.

Sends via the LifeClaw bot token/chat (same secret files the /debts bot uses),
so it lands in the same DM as the rest of LifeClaw.

Flags:
  --dry-run   print the message, send nothing
  --force     send even if nothing is in the alert window (for testing)
  --window N  days-ahead threshold to alert on (default 5)

Cron-safe: exits 0 with a log line if debts.json or the bot creds are missing.
Recommended cron (ET):  0 9 * * *  (after the 08:00 plaid_sync balance refresh)
"""
import sys
import json
import calendar
from pathlib import Path
from datetime import date, datetime
from zoneinfo import ZoneInfo

import requests

ET = ZoneInfo("America/New_York")
DEBTS = Path.home() / ".lifeclaw/debts.json"
SECRETS = Path.home() / ".openclaw/secrets"
TOK_FILE = SECRETS / "lifeclaw_telegram_bot_token"
CHAT_FILE = SECRETS / "lifeclaw_telegram_chat_id"

DRY = "--dry-run" in sys.argv
FORCE = "--force" in sys.argv
WINDOW = 5
if "--window" in sys.argv:
    try:
        WINDOW = int(sys.argv[sys.argv.index("--window") + 1])
    except (ValueError, IndexError):
        pass


def _money(x):
    try:
        return f"${float(x):,.2f}"
    except (TypeError, ValueError):
        return "$?"


def next_due_date(due_day, today):
    """Soonest calendar date matching due_day, clamped to month length."""
    if not due_day:
        return None
    last = calendar.monthrange(today.year, today.month)[1]
    cand = date(today.year, today.month, min(int(due_day), last))
    if cand < today:
        y = today.year + (1 if today.month == 12 else 0)
        m = 1 if today.month == 12 else today.month + 1
        last2 = calendar.monthrange(y, m)[1]
        cand = date(y, m, min(int(due_day), last2))
    return cand


def main():
    now = datetime.now(ET)
    today = now.date()

    if not DEBTS.exists():
        print(f"[debt_due_alert] {now:%Y-%m-%d %H:%M} no debts.json — skipping")
        return 0

    data = json.loads(DEBTS.read_text() or "{}")
    debts = [d for d in data.get("debts", []) if (d.get("balance") or 0) > 0]
    if not debts:
        print(f"[debt_due_alert] {now:%Y-%m-%d %H:%M} no open debts — skipping")
        return 0

    past_due, soon = [], []
    for d in debts:
        note = (d.get("note") or "").upper()
        cred = d.get("creditor", d.get("id", "card"))
        minp = d.get("min_payment")
        if "PAST DUE" in note:
            past_due.append((cred, minp, d))
            continue
        nd = next_due_date(d.get("due_day"), today)
        if nd is None:
            continue
        days = (nd - today).days
        if days <= WINDOW:
            soon.append((days, cred, minp, nd, d))

    soon.sort(key=lambda t: t[0])

    if not past_due and not soon and not FORCE:
        print(f"[debt_due_alert] {now:%Y-%m-%d %H:%M} nothing due within {WINDOW}d — no alert")
        return 0

    lines = ["💳 *Card payment check* — " + now.strftime("%a %b %-d")]
    for cred, minp, _ in past_due:
        lines.append(f"🔴 *PAST DUE* — {cred}: pay {_money(minp)} NOW (late fee + APR hit risk)")
    for days, cred, minp, nd, _ in soon:
        when = "TODAY" if days == 0 else ("TOMORROW" if days == 1 else f"in {days}d ({nd:%b %-d})")
        icon = "🟠" if days <= 2 else "🟡"
        lines.append(f"{icon} {cred}: min {_money(minp)} due {when}")
    if not past_due and not soon:
        lines.append("✅ Nothing due in the next "+str(WINDOW)+" days. (forced check)")
    lines.append("\nSet autopay for minimums so this never bites. /debts for the full picture.")
    msg = "\n".join(lines)

    if DRY:
        print("--- DRY RUN (not sent) ---")
        print(msg)
        return 0

    if not (TOK_FILE.exists() and CHAT_FILE.exists()):
        print(f"[debt_due_alert] {now:%Y-%m-%d %H:%M} bot creds missing — skipping send")
        return 0

    chat = CHAT_FILE.read_text().strip()
    try:   # life_wellness lane (LifeClaw bot) through tg_fleet.call - no raw Bot API call (script-standard #6)
        sys.path.insert(0, str(Path.home() / "scripts"))
        import tg_fleet
        r = tg_fleet.call("life_wellness", "sendMessage", chat_id=chat, text=msg, parse_mode="Markdown")
        ok = r.get("ok")
        print(f"[debt_due_alert] {now:%Y-%m-%d %H:%M} sent ok={ok} "
              f"({len(past_due)} past-due, {len(soon)} due-soon)")
    except Exception as e:  # noqa: BLE001 — alert daemon must never crash the cron
        print(f"[debt_due_alert] {now:%Y-%m-%d %H:%M} send failed: {e}")
    return 0


if __name__ == "__main__":
    sys.exit(main())
