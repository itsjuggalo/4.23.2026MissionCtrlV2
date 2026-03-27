#!/usr/bin/env python3
"""
The Broadcaster — External-facing output of the Mission Control trading team.
READ-ONLY. Watches executions, macro state, and risk state for key events,
then sends clean professional messages to Telegram + mirrors to Discord.

Cycles:
  Every 30 s : check for new events
  00:00 UTC  : daily summary
  Max 1 Telegram message per minute (queue for bursts)
"""
import asyncio
import json
import logging
import os
import sys
import uuid
from datetime import datetime, timezone, timedelta

import aiohttp
import sys as _sys
_sys.path.insert(0, os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
from dotenv import load_dotenv
from shared.archiver import maybe_rotate

# ── Config ────────────────────────────────────────────────────────────────────

load_dotenv(os.path.join(os.path.dirname(os.path.abspath(__file__)), ".env"))

_DIR    = os.path.dirname(os.path.abspath(__file__))
_ROOT   = os.path.dirname(_DIR)

EXECUTIONS_FILE = os.path.join(_ROOT, "execution-specialist", "executions.json")
MACRO_FILE      = os.path.join(_ROOT, "macro-strategist",     "macro_state.json")
RISK_FILE       = os.path.join(_ROOT, "risk-manager",         "risk_state.json")
PORTFOLIO_FILE  = os.path.join(_ROOT, "portfolio-monitor",    "portfolio_state.json")
BROADCAST_LOG   = os.path.join(_DIR,  "broadcast_log.json")

TG_TOKEN   = os.getenv("TELEGRAM_BOT_TOKEN", "")
TG_CHAT_ID = os.getenv("TELEGRAM_CHAT_ID", "")
DISCORD_URL  = os.getenv("DISCORD_BROADCAST_LOG_WEBHOOK",      "")
ARCHIVE_URL  = os.getenv("DISCORD_ARCHIVE_BROADCASTER_WEBHOOK", "")
LOG_MAX      = 200

POLL_INTERVAL     = 30    # seconds
TG_RATE_LIMIT     = 60    # seconds between Telegram sends
MAX_LOG_ENTRIES   = 200

logging.basicConfig(
    level=logging.INFO,
    format="%(asctime)s [BROADCASTER] %(message)s",
    datefmt="%Y-%m-%d %H:%M:%S",
    stream=sys.stdout,
)
log = logging.getLogger("broadcaster")


# ── File I/O ──────────────────────────────────────────────────────────────────

def load_json(path: str, default):
    if os.path.exists(path):
        try:
            with open(path) as f:
                return json.load(f)
        except Exception as e:
            log.warning(f"Load {path}: {e}")
    return default


def save_json(path: str, data) -> None:
    with open(path, "w") as f:
        json.dump(data, f, indent=2, default=str)


# ── Broadcast log ─────────────────────────────────────────────────────────────

def load_log() -> list:
    return load_json(BROADCAST_LOG, [])


def save_log(log_entries: list) -> None:
    if len(log_entries) > MAX_LOG_ENTRIES:
        log_entries = log_entries[-MAX_LOG_ENTRIES:]
    save_json(BROADCAST_LOG, log_entries)


def already_broadcast(source_id: str, event_type: str, log_entries: list) -> bool:
    return any(
        e.get("source_id") == source_id and e.get("type") == event_type
        for e in log_entries
    )


def record_broadcast(source_id: str, event_type: str, preview: str,
                     tg_ok: bool, disc_ok: bool, log_entries: list) -> None:
    log_entries.append({
        "id":              str(uuid.uuid4()),
        "type":            event_type,
        "source_id":       source_id,
        "timestamp":       datetime.now(timezone.utc).isoformat(),
        "telegram_sent":   tg_ok,
        "discord_sent":    disc_ok,
        "message_preview": preview[:120],
    })
    save_log(log_entries)


# ── Telegram sender ───────────────────────────────────────────────────────────

async def send_telegram(session: aiohttp.ClientSession, text: str) -> bool:
    """Send a message via Telegram Bot API. Returns True on success."""
    if not TG_TOKEN or not TG_CHAT_ID:
        log.warning("Telegram not configured (missing token or chat_id)")
        return False
    url = f"https://api.telegram.org/bot{TG_TOKEN}/sendMessage"
    payload = {
        "chat_id":    TG_CHAT_ID,
        "text":       text,
        "parse_mode": "HTML",
        "disable_web_page_preview": True,
    }
    try:
        async with session.post(url, json=payload,
                                timeout=aiohttp.ClientTimeout(total=12)) as resp:
            body = await resp.json()
            if resp.status == 200 and body.get("ok"):
                return True
            log.warning(f"Telegram {resp.status}: {body.get('description','?')}")
            if resp.status == 401:
                log.warning("  → Token invalid. Update TELEGRAM_BOT_TOKEN in .env")
            return False
    except Exception as e:
        log.warning(f"Telegram send failed: {e}")
        return False


async def send_discord_mirror(session: aiohttp.ClientSession,
                              event_type: str, preview: str,
                              tg_ok: bool) -> bool:
    """Mirror broadcast to #broadcast-log Discord channel."""
    if not DISCORD_URL:
        return False
    tg_status = "✅ sent" if tg_ok else "⚠️ failed (check token)"
    now_str   = datetime.now(timezone.utc).strftime("%H:%M:%S UTC")
    desc = (
        f"**Type:** {event_type.replace('_',' ').title()}\n"
        f"**Preview:** {preview[:120]}\n"
        f"**Telegram:** {tg_status}\n"
        f"**Time:** {now_str}"
    )
    payload = {"embeds": [{
        "title":       "📢 Broadcast sent",
        "description": desc,
        "color":       0x6c5ce7 if tg_ok else 0xffa502,
    }]}
    try:
        async with session.post(DISCORD_URL, json=payload,
                                timeout=aiohttp.ClientTimeout(total=10)) as resp:
            return resp.status in (200, 204)
    except Exception as e:
        log.warning(f"Discord mirror failed: {e}")
        return False


# ── Message builders ──────────────────────────────────────────────────────────

def _fmt_price(v) -> str:
    if v is None: return "N/A"
    try:    return f"${float(v):,.2f}"
    except: return str(v)


def _fmt_pct(v) -> str:
    if v is None: return "N/A"
    try:
        f = float(v)
        sign = "+" if f >= 0 else ""
        return f"{sign}{f:.2f}%"
    except: return str(v)


def build_trade_opened_msg(execution: dict) -> str:
    sym  = execution.get("symbol", "?")
    dire = execution.get("direction", "?")
    entry = execution.get("entry_avg") or execution.get("entry")
    sl    = execution.get("stop_loss")
    tgts  = execution.get("targets") or []
    tgt_str = " / ".join(_fmt_price(t) for t in tgts[:3]) if tgts else "N/A"

    # Pull score/verdict from history or metadata
    score   = execution.get("signal_score", "?")
    verdict = execution.get("analyst_verdict", "?")
    rr      = execution.get("risk_reward")

    lines = [
        "📈 <b>TRADE OPENED</b>",
        "",
        f"Symbol: {sym}",
        f"Direction: {dire}",
        f"Entry: {_fmt_price(entry)}",
        f"Stop Loss: {_fmt_price(sl)}",
        f"Targets: {tgt_str}",
    ]
    if rr:
        lines.append(f"R:R: {rr}:1")
    lines += [
        "",
        f"Signal Score: {score}",
        f"Analyst: {verdict}",
        "Risk Manager: APPROVED",
    ]
    return "\n".join(lines)


def build_trade_closed_win_msg(execution: dict) -> str:
    sym     = execution.get("symbol", "?")
    dire    = execution.get("direction", "?")
    entry   = execution.get("entry_avg") or execution.get("entry")
    exit_p  = execution.get("exit_price")
    pnl_usd = execution.get("realized_pnl_usd")
    pnl_pct = execution.get("realized_pnl_pct")
    opened  = execution.get("opened_at")
    closed  = execution.get("closed_at")
    tps_hit = execution.get("tps_hit", 0)
    tps_tot = len(execution.get("execution_plan", {}).get("take_profits", [])) or 3

    duration = "?"
    if opened and closed:
        try:
            o = datetime.fromisoformat(opened)
            c = datetime.fromisoformat(closed)
            if o.tzinfo is None: o = o.replace(tzinfo=timezone.utc)
            if c.tzinfo is None: c = c.replace(tzinfo=timezone.utc)
            hrs = int((c - o).total_seconds() / 3600)
            duration = f"{hrs} hours" if hrs < 48 else f"{hrs//24} days"
        except Exception:
            pass

    pnl_sign = "+" if (pnl_usd or 0) >= 0 else ""
    return "\n".join([
        "✅ <b>TRADE CLOSED — WIN</b>",
        "",
        f"Symbol: {sym} {dire}",
        f"Entry: {_fmt_price(entry)} → Exit: {_fmt_price(exit_p)}",
        f"P&L: {pnl_sign}{_fmt_price(pnl_usd)} ({_fmt_pct(pnl_pct)})",
        f"Duration: {duration}",
        f"TPs Hit: {tps_hit}/{tps_tot}",
    ])


def build_trade_closed_loss_msg(execution: dict) -> str:
    sym     = execution.get("symbol", "?")
    dire    = execution.get("direction", "?")
    entry   = execution.get("entry_avg") or execution.get("entry")
    exit_p  = execution.get("exit_price")
    pnl_usd = execution.get("realized_pnl_usd")
    pnl_pct = execution.get("realized_pnl_pct")
    opened  = execution.get("opened_at")
    closed  = execution.get("closed_at")

    duration = "?"
    if opened and closed:
        try:
            o = datetime.fromisoformat(opened)
            c = datetime.fromisoformat(closed)
            if o.tzinfo is None: o = o.replace(tzinfo=timezone.utc)
            if c.tzinfo is None: c = c.replace(tzinfo=timezone.utc)
            hrs = int((c - o).total_seconds() / 3600)
            duration = f"{hrs} hours" if hrs < 48 else f"{hrs//24} days"
        except Exception:
            pass

    return "\n".join([
        "❌ <b>TRADE CLOSED — STOP HIT</b>",
        "",
        f"Symbol: {sym} {dire}",
        f"Entry: {_fmt_price(entry)} → Exit: {_fmt_price(exit_p)}",
        f"P&L: {_fmt_price(pnl_usd)} ({_fmt_pct(pnl_pct)})",
        f"Duration: {duration}",
        "",
        "Risk was managed: loss within portfolio risk limits",
    ])


def build_macro_regime_msg(macro: dict, prev_regime: str) -> str:
    regime  = macro.get("regime", "?")
    score   = macro.get("total_score", 0)
    max_sc  = macro.get("max_score", 12)
    mod     = macro.get("position_size_modifier", 1.0)
    ind     = macro.get("indicators", {})

    # Key factors (negative scores)
    factors = []
    for key, data in ind.items():
        sc = data.get("score", 0) if isinstance(data, dict) else 0
        if sc < 0:
            label = key.replace("_"," ").title()
            factors.append(label)
    factors_str = ", ".join(factors[:3]) if factors else "See full report"

    return "\n".join([
        "🌍 <b>MACRO UPDATE</b>",
        "",
        f"Regime changed: {prev_regime} → {regime}",
        f"Score: {score}/{max_sc}",
        f"Key factors: {factors_str}",
        f"Position sizing: {mod}x",
    ])


def build_macro_update_msg(macro: dict) -> str:
    """First-run or periodic macro update (no regime change)."""
    regime  = macro.get("regime", "?")
    score   = macro.get("total_score", 0)
    max_sc  = macro.get("max_score", 12)
    mod     = macro.get("position_size_modifier", 1.0)
    rec     = macro.get("recommendation", "")[:120]

    return "\n".join([
        "🌍 <b>MACRO UPDATE</b>",
        "",
        f"Regime: {regime}",
        f"Score: {score}/{max_sc}",
        f"Sizing modifier: {mod}x",
        "",
        rec,
    ])


def build_risk_alert_msg(state: dict, alert_type: str) -> str:
    daily  = state.get("daily_pnl", 0)
    weekly = state.get("weekly_pnl", 0)

    if alert_type == "circuit_breaker":
        return "\n".join([
            "🚨 <b>RISK ALERT</b>",
            "",
            f"Daily drawdown limit reached: {daily:.1f}%",
            "All new trades BLOCKED",
            "Existing positions maintained",
            "Commander decision required",
        ])
    return "\n".join([
        "⚠️ <b>RISK ALERT</b>",
        "",
        f"Daily P&L: {daily:.2f}% | Weekly: {weekly:.2f}%",
        "Monitor closely",
    ])


def build_daily_summary_msg(portfolio: dict, macro: dict,
                             executions: list, date_str: str) -> str:
    total   = portfolio.get("total_value_usd", 0)
    pnl_usd = portfolio.get("total_pnl_today_usd", 0)
    pnl_pct = portfolio.get("total_pnl_today_pct", 0)
    posns   = portfolio.get("positions", [])
    exp     = portfolio.get("deployed_pct", 0)
    cash    = portfolio.get("cash_available", 0)

    # Today's trades
    today_str = datetime.now(timezone.utc).strftime("%Y-%m-%d")
    opened_today = [e for e in executions
                    if (e.get("opened_at","") or "").startswith(today_str)]
    closed_today = [e for e in executions
                    if (e.get("closed_at","") or "").startswith(today_str)
                    and e.get("status") == "closed"]
    wins  = [e for e in closed_today if (e.get("realized_pnl_usd") or 0) >= 0]

    # Top performer
    top = max(posns, key=lambda p: p.get("unrealized_pnl_pct") or 0) if posns else None
    top_str = (f"{top['symbol']} {_fmt_pct(top.get('unrealized_pnl_pct'))}"
               if top else "—")

    regime = macro.get("regime","?")
    score  = macro.get("total_score", 0)
    max_sc = macro.get("max_score", 12)
    pnl_sign = "+" if pnl_usd >= 0 else ""

    return "\n".join([
        f"📊 <b>DAILY SUMMARY — {date_str}</b>",
        "",
        f"Portfolio: ${total:,.0f} ({pnl_sign}{_fmt_pct(pnl_pct)})",
        f"Trades: {len(opened_today)} opened, {len(closed_today)} closed"
        + (f" ({len(wins)} WIN)" if closed_today else ""),
        f"Day P&L: {pnl_sign}${pnl_usd:,.0f}",
        "",
        f"Macro: {regime} ({score}/{max_sc})",
        f"Active positions: {len(posns)}",
        f"Risk exposure: {exp:.1f}%",
        "",
        f"Top performer: {top_str}",
    ])


# ── Event Watchers ────────────────────────────────────────────────────────────

def check_executions(log_entries: list) -> list[dict]:
    """Return list of broadcast-ready events from executions.json."""
    executions = load_json(EXECUTIONS_FILE, [])
    events = []

    for exe in executions:
        exe_id = exe.get("id", "")
        status = exe.get("status", "")

        # Trade opened
        if status in ("approved", "filled", "open", "partial"):
            if not already_broadcast(exe_id, "trade_opened", log_entries):
                events.append({
                    "type":    "trade_opened",
                    "id":      exe_id,
                    "data":    exe,
                    "message": build_trade_opened_msg(exe),
                })

        # Trade closed — win or loss
        elif status == "closed":
            pnl = exe.get("realized_pnl_usd") or 0
            etype = "trade_closed_win" if pnl >= 0 else "trade_closed_loss"
            if not already_broadcast(exe_id, etype, log_entries):
                msg = (build_trade_closed_win_msg(exe)
                       if pnl >= 0 else build_trade_closed_loss_msg(exe))
                events.append({
                    "type":    etype,
                    "id":      exe_id,
                    "data":    exe,
                    "message": msg,
                })

    return events


def check_macro(log_entries: list) -> list[dict]:
    """Detect regime changes in macro_state.json."""
    macro = load_json(MACRO_FILE, None)
    if not macro:
        return []

    regime    = macro.get("regime", "")
    timestamp = macro.get("timestamp", "")
    source_id = f"macro_{timestamp}"

    # First broadcast or regime changed?
    prev_entries = [e for e in log_entries
                    if e.get("type") in ("macro_regime_change","macro_update")]
    if not prev_entries:
        # First run — send current state
        if not already_broadcast(source_id, "macro_update", log_entries):
            return [{
                "type":    "macro_update",
                "id":      source_id,
                "data":    macro,
                "message": build_macro_update_msg(macro),
            }]
    else:
        # Check if regime changed since last broadcast
        last_regime = None
        for entry in reversed(prev_entries):
            preview = entry.get("message_preview","")
            # Extract regime from preview or check source
            data = entry.get("data", {})
            if isinstance(data, dict) and data.get("regime"):
                last_regime = data.get("regime")
                break

        if regime and last_regime and regime != last_regime:
            if not already_broadcast(source_id, "macro_regime_change", log_entries):
                return [{
                    "type":    "macro_regime_change",
                    "id":      source_id,
                    "data":    macro,
                    "message": build_macro_regime_msg(macro, last_regime),
                }]

    return []


def check_risk_alerts(log_entries: list) -> list[dict]:
    """Check for circuit breaker conditions."""
    risk = load_json(RISK_FILE, {})
    daily = float(risk.get("daily_pnl", 0))
    weekly = float(risk.get("weekly_pnl", 0))

    events = []

    # Check if circuit breaker should be active (replicate risk manager logic)
    if daily <= -5.0 or weekly <= -10.0:
        source_id = f"cb_{datetime.now(timezone.utc).strftime('%Y-%m-%d')}"
        if not already_broadcast(source_id, "circuit_breaker", log_entries):
            events.append({
                "type":    "circuit_breaker",
                "id":      source_id,
                "data":    risk,
                "message": build_risk_alert_msg(risk, "circuit_breaker"),
            })

    return events


# ── Daily summary ─────────────────────────────────────────────────────────────

def should_send_daily_summary(log_entries: list) -> bool:
    """True if we haven't sent today's summary yet."""
    today = datetime.now(timezone.utc).strftime("%Y-%m-%d")
    return not any(
        e.get("type") == "daily_summary" and
        e.get("timestamp","").startswith(today)
        for e in log_entries
    )


def is_daily_summary_time() -> bool:
    """True within the first 30s after 00:00 UTC."""
    now = datetime.now(timezone.utc)
    return now.hour == 0 and now.minute == 0


# ── Main loop ─────────────────────────────────────────────────────────────────

async def run():
    log.info("=== Broadcaster starting ===")
    log.info(f"Telegram  : {'✅ configured' if TG_TOKEN and TG_CHAT_ID else '⚠️  not configured — update .env'}")
    log.info(f"Discord   : {'✅ configured' if DISCORD_URL else '❌ not configured'}")
    log.info(f"Poll: {POLL_INTERVAL}s | Rate limit: 1 msg/{TG_RATE_LIMIT}s\n")

    last_tg_send   = 0.0  # monotonic time of last Telegram send
    tg_queue: list[dict] = []  # queued events when rate limited

    # Store last-seen macro regime for change detection (in memory)
    # The log file handles persistence

    async with aiohttp.ClientSession() as session:
        while True:
            try:
                log_entries = load_log()
                events: list[dict] = []

                # ── Gather events ─────────────────────────────────────────────
                events += check_executions(log_entries)
                events += check_macro(log_entries)
                events += check_risk_alerts(log_entries)

                # ── Daily summary ─────────────────────────────────────────────
                if is_daily_summary_time() and should_send_daily_summary(log_entries):
                    portfolio  = load_json(PORTFOLIO_FILE, {})
                    macro      = load_json(MACRO_FILE, {})
                    executions = load_json(EXECUTIONS_FILE, [])
                    date_str   = datetime.now(timezone.utc).strftime("%B %-d, %Y")
                    daily_msg  = build_daily_summary_msg(portfolio, macro, executions, date_str)
                    events.insert(0, {
                        "type":    "daily_summary",
                        "id":      f"daily_{datetime.now(timezone.utc).strftime('%Y-%m-%d')}",
                        "data":    {},
                        "message": daily_msg,
                        "priority": True,  # send even if rate limited
                    })

                # ── Add new events to queue ───────────────────────────────────
                for ev in events:
                    # Avoid re-queuing already-queued events
                    if not any(q["id"] == ev["id"] and q["type"] == ev["type"]
                               for q in tg_queue):
                        tg_queue.append(ev)
                        if ev["type"] not in ("macro_update",):
                            log.info(f"Queued: {ev['type']} — {ev['id'][:8]}")

                # ── Process queue (rate limited) ──────────────────────────────
                import time as _time
                now_mono = _time.monotonic()
                can_send = (now_mono - last_tg_send) >= TG_RATE_LIMIT

                if tg_queue and can_send:
                    ev = tg_queue.pop(0)
                    msg     = ev["message"]
                    etype   = ev["type"]
                    src_id  = ev["id"]
                    preview = msg.split("\n")[0].replace("<b>","").replace("</b>","")

                    log.info(f"Sending [{etype}]: {preview}")

                    tg_ok   = await send_telegram(session, msg)
                    disc_ok = await send_discord_mirror(session, etype, preview, tg_ok)

                    record_broadcast(src_id, etype, preview, tg_ok, disc_ok, log_entries)

                    # Archive rotation
                    log_entries = await maybe_rotate(
                        session, "broadcast-log", log_entries, BROADCAST_LOG,
                        max_entries=LOG_MAX, webhook_url=ARCHIVE_URL
                    )

                    # Store macro data for regime-change tracking
                    if etype in ("macro_update","macro_regime_change"):
                        log_entries[-1]["data"] = ev.get("data", {})
                    save_log(log_entries)

                    last_tg_send = now_mono
                    log.info(f"  → Telegram: {'✅' if tg_ok else '❌'}  Discord: {'✅' if disc_ok else '❌'}")

                elif tg_queue:
                    import time as _time2
                    wait = int(TG_RATE_LIMIT - (_time2.monotonic() - last_tg_send))
                    log.debug(f"Rate limited — {len(tg_queue)} queued, next in ~{wait}s")

            except Exception as e:
                log.error(f"Cycle error: {e}", exc_info=True)

            await asyncio.sleep(POLL_INTERVAL)


if __name__ == "__main__":
    asyncio.run(run())
