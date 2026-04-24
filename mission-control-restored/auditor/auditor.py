#!/usr/bin/env python3
"""
The Auditor — DE Shaw-style systematic performance review.
READ-ONLY. Audits every closed trade, maintains performance stats,
extracts data-driven lessons, posts reports to Discord.

Schedule:
  Every 5 min  : scan for new closed trades to audit
  Every 10 min : refresh performance stats
  23:55 UTC    : daily report
  Sunday 20:00 : weekly report
  Every 10 new closed trades : lessons extraction
"""
import asyncio
import json
import logging
import os
import sys
import uuid
from collections import defaultdict
from datetime import datetime, timezone, timedelta
from statistics import mean

import sys as _sys
_sys.path.insert(0, os.path.dirname(os.path.dirname(os.path.abspath(__file__))))

import aiohttp
from dotenv import load_dotenv
from shared.archiver import maybe_rotate

# ── Config ────────────────────────────────────────────────────────────────────

load_dotenv(os.path.join(os.path.dirname(os.path.abspath(__file__)), ".env"))

_DIR  = os.path.dirname(os.path.abspath(__file__))
_ROOT = os.path.dirname(_DIR)

SRCS = {
    "executions":    os.path.join(_ROOT, "execution-specialist", "executions.json"),
    "pending":       os.path.join(_ROOT, "execution-specialist", "pending_orders.json"),
    "analyst":       os.path.join(_ROOT, "analyst",              "analysis_results.json"),
    "risk_state":    os.path.join(_ROOT, "risk-manager",         "risk_state.json"),
    "signals":       os.path.join(_ROOT, "telegram-listener",    "signals.json"),
    "chan_stats":     os.path.join(_ROOT, "telegram-listener",    "channel_stats.json"),
}

JOURNAL_FILE = os.path.join(_DIR, "trade_journal.json")
STATS_FILE   = os.path.join(_DIR, "performance_stats.json")
LESSONS_FILE = os.path.join(_DIR, "lessons.json")

REVIEWS_URL  = os.getenv("DISCORD_TRADE_REVIEWS_WEBHOOK",      "")
DAILY_URL    = os.getenv("DISCORD_PERFORMANCE_DAILY_WEBHOOK",  "")
WEEKLY_URL   = os.getenv("DISCORD_PERFORMANCE_WEEKLY_WEBHOOK", "")
MONTHLY_URL  = os.getenv("DISCORD_PERFORMANCE_MONTHLY_WEBHOOK","")
LESSONS_URL  = os.getenv("DISCORD_LESSONS_WEBHOOK",            "")
ARCHIVE_URL  = os.getenv("DISCORD_ARCHIVE_AUDITOR_WEBHOOK",    "")
JOURNAL_MAX  = 500

POLL_INTERVAL    = 5 * 60   # 5 min
STATS_INTERVAL   = 10 * 60  # 10 min
LESSONS_EVERY_N  = 10       # extract lessons after every N new trades

logging.basicConfig(
    level=logging.INFO,
    format="%(asctime)s [AUDITOR] %(message)s",
    datefmt="%Y-%m-%d %H:%M:%S",
    stream=sys.stdout,
)
log = logging.getLogger("auditor")


# ── I/O ───────────────────────────────────────────────────────────────────────

def load(key: str, default=None):
    path = SRCS.get(key, key)
    if os.path.exists(path):
        try:
            with open(path) as f:
                return json.load(f)
        except Exception as e:
            log.warning(f"Load {key}: {e}")
    return default if default is not None else []


def load_file(path: str, default=None):
    if os.path.exists(path):
        try:
            with open(path) as f:
                return json.load(f)
        except Exception:
            pass
    return default if default is not None else []


def save_file(path: str, data) -> None:
    with open(path, "w") as f:
        json.dump(data, f, indent=2, default=str)


# ── Lookup helpers ────────────────────────────────────────────────────────────

def _find_analyst(signal_id: str, analyst_results: list) -> dict | None:
    return next((r for r in analyst_results if r.get("signal_id") == signal_id), None)


def _find_signal(signal_id: str, signals: list) -> dict | None:
    return next((s for s in signals if s.get("id") == signal_id), None)


def _find_risk_decision(signal_id: str, risk_state: dict) -> dict | None:
    for d in (risk_state.get("decisions") or []):
        if d.get("signal_id") == signal_id:
            return d
    return None


def _hours_between(iso_a: str, iso_b: str) -> float:
    """Return hours between two ISO timestamps."""
    try:
        a = datetime.fromisoformat(iso_a.replace("Z", "+00:00"))
        b = datetime.fromisoformat(iso_b.replace("Z", "+00:00"))
        if a.tzinfo is None: a = a.replace(tzinfo=timezone.utc)
        if b.tzinfo is None: b = b.replace(tzinfo=timezone.utc)
        return round(abs((b - a).total_seconds() / 3600), 2)
    except Exception:
        return 0.0


def _classify_outcome(exe: dict) -> str:
    pnl    = float(exe.get("realized_pnl_usd") or exe.get("unrealized_pnl") or 0)
    pnl_pct= float(exe.get("realized_pnl_pct") or exe.get("unrealized_pnl_pct") or 0)
    tps    = exe.get("tps_hit", 0)
    sl     = exe.get("stop_hit", False)

    if sl:
        return "LOSS"
    if abs(pnl_pct) < 0.5:
        return "BREAK_EVEN"
    if pnl >= 0 and tps and tps > 0:
        tps_total = len((exe.get("execution_plan") or {}).get("take_profits", [])) or 3
        return "PARTIAL_WIN" if tps < tps_total else "WIN"
    if pnl >= 0:
        return "WIN"
    return "LOSS"


def _classify_asset(symbol: str) -> str:
    sym = symbol.upper().replace("/","").replace("-","")
    crypto_tails = ("USDT","USD","BTC","ETH","SOL","BNB")
    if any(sym.endswith(t) for t in crypto_tails):
        return "crypto"
    known = {"BTC","ETH","SOL","BNB","XRP","ADA","DOGE","AVAX","DOT","LINK",
             "UNI","LTC","BCH","TAO","FIL","AAVE","CRV","PEPE","WIF"}
    if sym in known:
        return "crypto"
    return "stocks"


# ── Trade audit ───────────────────────────────────────────────────────────────

def audit_trade(exe: dict, analyst_results: list,
                signals: list, risk_state: dict) -> dict:
    """Build a complete trade journal entry from an execution record."""
    sig_id  = exe.get("signal_id","")
    symbol  = exe.get("symbol","?")
    dire    = exe.get("direction","?")

    analyst = _find_analyst(sig_id, analyst_results)
    signal  = _find_signal(sig_id, signals)
    risk_d  = _find_risk_decision(sig_id, risk_state)

    # Core metrics
    entry     = float(exe.get("entry_avg") or exe.get("entry") or 0)
    exit_p    = float(exe.get("exit_price") or
                      (exe.get("price_history") or [{}])[-1].get("price") or 0)
    pnl_usd   = float(exe.get("realized_pnl_usd") or exe.get("unrealized_pnl") or 0)
    pnl_pct   = float(exe.get("realized_pnl_pct") or exe.get("unrealized_pnl_pct") or 0)
    fees      = float(exe.get("fees_paid") or exe.get("estimated_fees") or 0)

    opened    = exe.get("opened_at") or exe.get("timestamp","")
    closed    = exe.get("closed_at","")
    dur_h     = _hours_between(opened, closed) if closed else 0.0
    outcome   = _classify_outcome(exe)

    # Max drawdown / profit during trade (from price_history)
    hist      = exe.get("price_history") or []
    max_dd    = 0.0
    max_prof  = 0.0
    if hist and entry:
        prices = [float(h.get("price") or entry) for h in hist]
        peak   = max(prices)
        trough = min(prices)
        max_prof = round((peak  - entry) / entry * 100, 2)
        max_dd   = round((trough - entry) / entry * 100, 2)

    # Signal context
    sig_score   = signal.get("score")    if signal else None
    sig_channel = signal.get("channel_name","?") if signal else "?"

    # Analyst context
    a_verdict   = (analyst or {}).get("verdict","?")
    a_score     = (analyst or {}).get("total_score", None)

    # Risk context
    rm_pos   = (risk_d or {}).get("recommended_position") or {}
    rr_plan  = (analyst or {}).get("indicators",{}).get("risk_reward",{}).get("ratio")
    rr_act   = (round(abs(pnl_pct / (entry - float(exe.get("stop_loss") or entry or 1))
                          * entry), 2)
                if exe.get("stop_loss") and entry else None)

    # Indicator accuracy
    ind_accuracy = {}
    if analyst and signal:
        win = outcome in ("WIN","PARTIAL_WIN")
        ind = (analyst.get("indicators") or {})
        for name, data in ind.items():
            sc = (data or {}).get("score", 0)
            if sc == 0: continue
            bullish_signal = sc > 0
            bullish_dir    = dire.upper() in ("LONG","BUY","CALL")
            ind_accuracy[name] = "correct" if bullish_signal == bullish_dir == win else "incorrect"

    # Audit notes (generated)
    notes_parts = []
    if sig_score and sig_score >= 70:
        notes_parts.append(f"Signal quality was {'high' if sig_score >= 80 else 'adequate'} ({sig_score}/100 from {sig_channel}).")
    if a_verdict in ("STRONG","MODERATE"):
        notes_parts.append(f"Analyst correctly identified {'bullish' if outcome in ('WIN','PARTIAL_WIN') else 'setup — outcome contradicts'} technicals (verdict: {a_verdict}).")
    if dur_h > 0:
        notes_parts.append(f"Trade duration {dur_h:.1f}h {'within' if dur_h < 48 else 'exceeded'} expected range.")
    if max_dd < -2.0:
        notes_parts.append(f"Significant intra-trade drawdown of {max_dd:.1f}% — stop could be tighter.")
    audit_notes = " ".join(notes_parts) if notes_parts else "Awaiting more data for detailed analysis."

    # Lessons (per-trade)
    lessons = []
    if outcome == "WIN" and sig_channel != "?":
        lessons.append(f"Signal from {sig_channel} resulted in a WIN — channel reliability increasing.")
    if outcome == "LOSS" and max_dd < -3.5:
        lessons.append("Stop loss was too wide — consider tighter stops on future entries.")
    if dur_h > 48 and outcome == "LOSS":
        lessons.append("Long-duration trade turned to loss — consider time-based exit after 48h.")

    return {
        "id":                        str(uuid.uuid4()),
        "execution_id":              exe.get("id",""),
        "signal_id":                 sig_id,
        "analyst_result_id":         (analyst or {}).get("id",""),
        "symbol":                    symbol,
        "direction":                 dire,
        "asset_class":               _classify_asset(symbol),
        "outcome":                   outcome,
        "opened_at":                 opened,
        "closed_at":                 closed,
        "duration_hours":            dur_h,
        "entry_avg":                 entry,
        "exit_avg":                  exit_p,
        "pnl_usd":                   round(pnl_usd, 2),
        "pnl_pct":                   round(pnl_pct, 4),
        "fees_total":                round(fees, 2),
        "pnl_after_fees":            round(pnl_usd - fees, 2),
        "max_drawdown_during_trade_pct": max_dd,
        "max_profit_during_trade_pct":   max_prof,
        "signal_source":             sig_channel,
        "signal_score":              sig_score,
        "analyst_verdict":           a_verdict,
        "analyst_score":             a_score,
        "risk_reward_planned":       rr_plan,
        "risk_reward_actual":        rr_act,
        "tps_hit":                   exe.get("tps_hit", 0),
        "stop_hit":                  exe.get("stop_hit", False),
        "indicator_accuracy":        ind_accuracy,
        "audit_notes":               audit_notes,
        "lessons":                   lessons,
        "macro_regime":              load_file(os.path.join(_ROOT,"macro-strategist","macro_state.json"),{}).get("regime",""),
        "audited_at":                datetime.now(timezone.utc).isoformat(),
    }


# ── Performance stats ─────────────────────────────────────────────────────────

def rebuild_stats(journal: list) -> dict:
    """Rebuild performance_stats.json from scratch using trade journal."""
    now     = datetime.now(timezone.utc)
    today   = now.strftime("%Y-%m-%d")
    week_start = (now - timedelta(days=now.weekday())).strftime("%Y-%m-%d")
    month   = now.strftime("%Y-%m")

    def _win(t): return t["outcome"] in ("WIN","PARTIAL_WIN")
    def _pnl(t): return float(t.get("pnl_after_fees") or t.get("pnl_usd") or 0)

    wins   = [t for t in journal if _win(t)]
    losses = [t for t in journal if t["outcome"] == "LOSS"]
    be     = [t for t in journal if t["outcome"] == "BREAK_EVEN"]

    avg_win  = round(mean(t["pnl_pct"] for t in wins),  2) if wins   else 0
    avg_loss = round(mean(t["pnl_pct"] for t in losses), 2) if losses else 0
    sum_win  = sum(_pnl(t) for t in wins)
    sum_loss = abs(sum(_pnl(t) for t in losses))
    pf       = round(sum_win / sum_loss, 2) if sum_loss else 0

    # Streak
    streak_n, streak_type = 0, "none"
    for t in reversed(journal):
        is_win = _win(t)
        if streak_n == 0:
            streak_type = "wins" if is_win else "losses"
            streak_n = 1
        elif (streak_type == "wins") == is_win:
            streak_n += 1
        else:
            break

    max_win_streak  = 0
    max_loss_streak = 0
    cur_w = cur_l = 0
    for t in journal:
        if _win(t):
            cur_w += 1; cur_l = 0
        else:
            cur_l += 1; cur_w = 0
        max_win_streak  = max(max_win_streak,  cur_w)
        max_loss_streak = max(max_loss_streak, cur_l)

    best  = max(journal, key=lambda t: t.get("pnl_pct",0)) if journal else None
    worst = min(journal, key=lambda t: t.get("pnl_pct",0)) if journal else None

    # Time slices
    def _slice(trades, key, value):
        return [t for t in trades if (t.get("closed_at","") or "").startswith(value)]

    daily_j   = _slice(journal, "closed_at", today)
    weekly_j  = [t for t in journal if (t.get("closed_at","") or "") >= week_start]
    monthly_j = [t for t in journal if (t.get("closed_at","") or "").startswith(month)]

    def _summary(trades):
        w = [t for t in trades if _win(t)]
        l = [t for t in trades if t["outcome"] == "LOSS"]
        return {
            "trades_closed": len(trades),
            "wins":          len(w),
            "losses":        len(l),
            "pnl_usd":       round(sum(_pnl(t) for t in trades), 2),
            "win_rate_pct":  round(len(w) / len(trades) * 100, 1) if trades else 0,
        }

    # By asset class
    by_ac: dict[str, list] = defaultdict(list)
    for t in journal:
        by_ac[t.get("asset_class","other")].append(t)
    by_ac_stats = {
        ac: {
            "trades":      len(tl),
            "win_rate":    round(sum(1 for t in tl if _win(t)) / len(tl) * 100, 1),
            "avg_pnl_pct": round(mean(t.get("pnl_pct",0) for t in tl), 2),
        }
        for ac, tl in by_ac.items() if tl
    }

    # By signal source
    by_src: dict[str, list] = defaultdict(list)
    for t in journal:
        src = t.get("signal_source","?")
        by_src[src].append(t)
    by_src_stats = {
        src: {
            "signals":  len(tl),
            "win_rate": round(sum(1 for t in tl if _win(t)) / len(tl) * 100, 1),
            "avg_pnl_pct": round(mean(t.get("pnl_pct",0) for t in tl), 2),
        }
        for src, tl in by_src.items() if tl
    }

    # By analyst verdict
    by_av: dict[str, list] = defaultdict(list)
    for t in journal:
        av = t.get("analyst_verdict","?")
        by_av[av].append(t)
    by_av_stats = {
        av: {
            "trades":   len(tl),
            "win_rate": round(sum(1 for t in tl if _win(t)) / len(tl) * 100, 1),
        }
        for av, tl in by_av.items() if tl
    }

    return {
        "last_updated": now.isoformat(),
        "all_time": {
            "total_trades":    len(journal),
            "wins":            len(wins),
            "losses":          len(losses),
            "break_even":      len(be),
            "win_rate_pct":    round(len(wins) / len(journal) * 100, 1) if journal else 0,
            "avg_win_pct":     avg_win,
            "avg_loss_pct":    avg_loss,
            "profit_factor":   pf,
            "total_pnl_usd":   round(sum(_pnl(t) for t in journal), 2),
            "avg_duration_hours": round(mean(t["duration_hours"] for t in journal), 1) if journal else 0,
            "best_trade":      {"symbol": best["symbol"], "pnl_pct": best["pnl_pct"]} if best else None,
            "worst_trade":     {"symbol": worst["symbol"],"pnl_pct": worst["pnl_pct"]} if worst else None,
            "current_streak":  streak_n,
            "streak_type":     streak_type,
            "max_win_streak":  max_win_streak,
            "max_loss_streak": max_loss_streak,
        },
        "daily":   {**_summary(daily_j),   "date":       today},
        "weekly":  {**_summary(weekly_j),  "week_start": week_start},
        "monthly": {**_summary(monthly_j), "month":      month},
        "by_asset_class":       by_ac_stats,
        "by_signal_source":     by_src_stats,
        "by_analyst_verdict":   by_av_stats,
    }


# ── Lessons extraction ────────────────────────────────────────────────────────

def extract_lessons(journal: list, existing_lessons: list) -> list[dict]:
    """Generate data-driven insights. Only when stats are meaningful."""
    new_lessons = []
    n = len(journal)
    if n < 5:
        return new_lessons

    def _win(t): return t["outcome"] in ("WIN","PARTIAL_WIN")

    # ── Channel reliability ───────────────────────────────────────────────────
    by_src: dict[str, list] = defaultdict(list)
    for t in journal:
        by_src[t.get("signal_source","?")].append(t)
    for src, trades in by_src.items():
        if len(trades) >= 5:
            wr = round(sum(1 for t in trades if _win(t)) / len(trades) * 100, 1)
            key = f"channel_wr_{src}"
            if not any(l.get("key") == key for l in existing_lessons):
                new_lessons.append({
                    "id":          str(uuid.uuid4()),
                    "key":         key,
                    "timestamp":   datetime.now(timezone.utc).isoformat(),
                    "insight":     f"Signals from '{src}' have a {wr:.0f}% win rate across {len(trades)} trades.",
                    "data_points": len(trades),
                    "confidence":  "high" if len(trades) >= 20 else "medium",
                    "actionable_for": "eric",
                })

    # ── Analyst verdict accuracy ──────────────────────────────────────────────
    by_av: dict[str, list] = defaultdict(list)
    for t in journal:
        av = t.get("analyst_verdict","?")
        if av != "?":
            by_av[av].append(t)
    if len(by_av) >= 2:
        strong   = by_av.get("STRONG",[])
        moderate = by_av.get("MODERATE",[])
        if len(strong) >= 5 and len(moderate) >= 5:
            wr_s = round(sum(1 for t in strong   if _win(t)) / len(strong)   * 100, 1)
            wr_m = round(sum(1 for t in moderate if _win(t)) / len(moderate) * 100, 1)
            key = "analyst_strong_vs_moderate"
            if not any(l.get("key") == key for l in existing_lessons) and abs(wr_s - wr_m) > 10:
                new_lessons.append({
                    "id":          str(uuid.uuid4()),
                    "key":         key,
                    "timestamp":   datetime.now(timezone.utc).isoformat(),
                    "insight":     f"STRONG analyst verdicts: {wr_s:.0f}% win rate vs {wr_m:.0f}% for MODERATE. Prefer STRONG setups, especially during RISK-OFF regimes.",
                    "data_points": len(strong) + len(moderate),
                    "confidence":  "high" if (len(strong)+len(moderate)) >= 20 else "medium",
                    "actionable_for": "risk-manager",
                })

    # ── Trade duration ────────────────────────────────────────────────────────
    if n >= 10:
        short  = [t for t in journal if t.get("duration_hours",0) <= 48]
        long_t = [t for t in journal if t.get("duration_hours",0) >  48]
        if len(short) >= 5 and len(long_t) >= 3:
            wr_s = round(sum(1 for t in short   if _win(t)) / len(short)   * 100, 1)
            wr_l = round(sum(1 for t in long_t  if _win(t)) / len(long_t)  * 100, 1)
            key  = "duration_lt48h"
            if not any(l.get("key") == key for l in existing_lessons) and wr_s - wr_l > 10:
                new_lessons.append({
                    "id":          str(uuid.uuid4()),
                    "key":         key,
                    "timestamp":   datetime.now(timezone.utc).isoformat(),
                    "insight":     f"Trades ≤48h: {wr_s:.0f}% win rate. Trades >48h: {wr_l:.0f}% win rate. Consider time-based exits after 48 hours.",
                    "data_points": len(journal),
                    "confidence":  "medium",
                    "actionable_for": "execution-specialist",
                })

    # ── Indicator accuracy ────────────────────────────────────────────────────
    ind_correct: dict[str, list[int]] = defaultdict(list)
    for t in journal:
        for ind_name, result in (t.get("indicator_accuracy") or {}).items():
            ind_correct[ind_name].append(1 if result == "correct" else 0)
    for ind_name, results in ind_correct.items():
        if len(results) >= 10:
            acc = round(mean(results) * 100, 1)
            key = f"indicator_{ind_name}"
            if not any(l.get("key") == key for l in existing_lessons):
                direction = "above" if acc > 65 else "below"
                new_lessons.append({
                    "id":          str(uuid.uuid4()),
                    "key":         key,
                    "timestamp":   datetime.now(timezone.utc).isoformat(),
                    "insight":     f"{ind_name.replace('_',' ').title()} indicator is {acc:.0f}% accurate ({direction} baseline). {'Increase' if acc > 65 else 'Decrease'} its weight in the Analyst.",
                    "data_points": len(results),
                    "confidence":  "medium",
                    "actionable_for": "analyst",
                })

    # ── Macro regime impact ───────────────────────────────────────────────────
    if n >= 10:
        risk_on  = [t for t in journal if "RISK-ON"  in (t.get("macro_regime",""))]
        risk_off = [t for t in journal if "RISK-OFF" in (t.get("macro_regime","")) or
                                          "CRISIS"   in (t.get("macro_regime",""))]
        if len(risk_on) >= 5 and len(risk_off) >= 5:
            wr_on  = round(sum(1 for t in risk_on  if _win(t)) / len(risk_on)  * 100, 1)
            wr_off = round(sum(1 for t in risk_off if _win(t)) / len(risk_off) * 100, 1)
            key = "macro_regime_impact"
            if not any(l.get("key") == key for l in existing_lessons):
                new_lessons.append({
                    "id":          str(uuid.uuid4()),
                    "key":         key,
                    "timestamp":   datetime.now(timezone.utc).isoformat(),
                    "insight":     f"Win rate during RISK-ON: {wr_on:.0f}% vs RISK-OFF: {wr_off:.0f}%. {'Macro regime modifier is effective.' if abs(wr_on-wr_off) > 10 else 'Macro impact is minimal.'}",
                    "data_points": len(risk_on) + len(risk_off),
                    "confidence":  "medium",
                    "actionable_for": "macro-strategist",
                })

    return new_lessons


# ── Discord embeds ────────────────────────────────────────────────────────────

async def post_discord(session: aiohttp.ClientSession, url: str, payload: dict) -> bool:
    if not url:
        return False
    try:
        async with session.post(url, json=payload,
                                timeout=aiohttp.ClientTimeout(total=10)) as resp:
            if resp.status not in (200, 204):
                body = await resp.text()
                log.warning(f"Discord {resp.status}: {body[:80]}")
                return False
            return True
    except Exception as e:
        log.warning(f"Discord post failed: {e}")
        return False


def build_review_embed(entry: dict, streak_n: int, streak_type: str) -> dict:
    outcome  = entry["outcome"]
    icon     = {"WIN":"✅","PARTIAL_WIN":"🟡","BREAK_EVEN":"➖","LOSS":"❌"}.get(outcome,"❓")
    sym      = entry["symbol"]
    dire     = entry["direction"]
    pnl_usd  = entry.get("pnl_after_fees") or entry.get("pnl_usd", 0)
    pnl_pct  = entry.get("pnl_pct", 0)
    pnl_sign = "+" if pnl_usd >= 0 else ""
    dur      = entry.get("duration_hours", 0)

    a_verdict = entry.get("analyst_verdict","?")
    a_score   = entry.get("analyst_score","?")
    sig_score = entry.get("signal_score","?")
    sig_src   = entry.get("signal_source","?")
    rr_plan   = entry.get("risk_reward_planned","?")
    rr_act    = entry.get("risk_reward_actual","?")
    tps_hit   = entry.get("tps_hit", 0)
    max_dd    = entry.get("max_drawdown_during_trade_pct", 0)

    streak_line = f"Current streak: {streak_n} {streak_type}" if streak_n > 1 else ""
    notes_short = entry.get("audit_notes","")[:120]

    desc = (
        f"**P&L:** {pnl_sign}${pnl_usd:,.2f} ({pnl_sign}{pnl_pct:.2f}%) after fees\n"
        f"**Duration:** {dur:.1f} hours\n\n"
        f"**Signal:** Score {sig_score}/100 from {sig_src}\n"
        f"**Analyst:** {a_verdict} ({a_score}/6)\n"
        f"**R:R** Planned: {rr_plan}:1 | Actual: {rr_act if rr_act else 'N/A'}\n\n"
        f"TPs hit: {tps_hit} | Max drawdown: {max_dd:.1f}%\n\n"
        f"_{notes_short}_"
    )
    if streak_line:
        desc += f"\n\n{streak_line}"

    color = {"WIN": 0x00d2a0, "PARTIAL_WIN": 0xffa502,
             "BREAK_EVEN": 0x636e72, "LOSS": 0xff4757}.get(outcome, 0x636e72)

    return {"embeds": [{
        "title":       f"📝 TRADE REVIEW — {sym} {dire} {icon} {outcome}",
        "description": desc,
        "color":       color,
        "footer":      {"text": f"Auditor • {entry.get('audited_at','')[:19].replace('T',' ')} UTC"},
    }]}


def build_daily_embed(stats: dict) -> dict:
    at   = stats.get("all_time", {})
    day  = stats.get("daily", {})
    wk   = stats.get("weekly", {})
    mo   = stats.get("monthly", {})
    date_str = datetime.now(timezone.utc).strftime("%B %-d, %Y")
    pnl  = day.get("pnl_usd",0)
    sign = "+" if pnl >= 0 else ""

    desc = (
        f"**Trades:** {day.get('trades_closed',0)} "
        f"({day.get('wins',0)}W / {day.get('losses',0)}L)\n"
        f"**Day P&L:** {sign}${pnl:,.2f}\n"
        f"**Win rate today:** {day.get('win_rate_pct',0):.1f}%\n\n"
        f"**Running stats:**\n"
        f"  Weekly: +${wk.get('pnl_usd',0):,.0f} ({wk.get('win_rate_pct',0):.1f}% WR)\n"
        f"  Monthly: +${mo.get('pnl_usd',0):,.0f} ({mo.get('win_rate_pct',0):.1f}% WR)\n"
        f"  All-time: +${at.get('total_pnl_usd',0):,.0f} ({at.get('win_rate_pct',0):.1f}% WR)\n"
        f"  Streak: {at.get('current_streak',0)} {at.get('streak_type','')}"
    )
    return {"embeds": [{
        "title":       f"📊 DAILY REPORT — {date_str}",
        "description": desc,
        "color":       0x6c5ce7,
        "footer":      {"text": f"Auditor • {datetime.now(timezone.utc).strftime('%Y-%m-%d %H:%M')} UTC"},
    }]}


def build_monthly_embed(stats: dict, journal: list) -> dict:
    mo    = stats.get("monthly", {})
    at    = stats.get("all_time", {})
    by_ac = stats.get("by_asset_class", {})
    by_src= stats.get("by_signal_source", {})

    month_label = datetime.now(timezone.utc).strftime("%B %Y")
    month_key   = mo.get("month", datetime.now(timezone.utc).strftime("%Y-%m"))

    # Filter journal to this month
    month_trades = [t for t in journal
                    if (t.get("closed_at","") or "").startswith(month_key)]

    def _win(t): return t["outcome"] in ("WIN", "PARTIAL_WIN")
    def _pnl(t): return float(t.get("pnl_after_fees") or t.get("pnl_usd") or 0)

    wins_m   = [t for t in month_trades if _win(t)]
    losses_m = [t for t in month_trades if t["outcome"] == "LOSS"]
    total_m  = len(month_trades)
    wr_m     = round(len(wins_m) / total_m * 100, 1) if total_m else 0
    pnl_m    = round(sum(_pnl(t) for t in month_trades), 2)
    pnl_sign = "+" if pnl_m >= 0 else ""

    # Profit factor for the month
    pos_pnl  = sum(_pnl(t) for t in wins_m)
    neg_pnl  = abs(sum(_pnl(t) for t in losses_m))
    pf_m     = round(pos_pnl / neg_pnl, 2) if neg_pnl else 0

    best_m  = max(month_trades, key=lambda t: t.get("pnl_pct", 0)) if month_trades else None
    worst_m = min(month_trades, key=lambda t: t.get("pnl_pct", 0)) if month_trades else None

    # Asset class breakdown (month only)
    ac_lines = []
    for ac, d in by_ac.items():
        ac_lines.append(f"  {ac.capitalize()}: {d['trades']} trades · {d['win_rate']:.0f}% WR · avg {d['avg_pnl_pct']:+.2f}%")

    # Signal source breakdown (top 3 by win rate, min 3 signals)
    src_ranked = sorted(
        [(src, d) for src, d in by_src.items() if d.get("signals", 0) >= 3],
        key=lambda x: x[1].get("win_rate", 0), reverse=True
    )[:3]
    src_lines = [
        f"  {src[:28]}: {d['signals']} signals · {d['win_rate']:.0f}% WR"
        for src, d in src_ranked
    ]

    desc = (
        f"**Trades:** {total_m} ({len(wins_m)}W / {len(losses_m)}L)\n"
        f"**Win Rate:** {wr_m:.1f}%\n"
        f"**Total P&L:** {pnl_sign}${pnl_m:,.2f}\n"
        f"**Profit Factor:** {pf_m}\n"
        + (f"**Best Trade:** {best_m['symbol']} {best_m['pnl_pct']:+.2f}%\n"  if best_m  else "")
        + (f"**Worst Trade:** {worst_m['symbol']} {worst_m['pnl_pct']:+.2f}%\n" if worst_m else "")
        + (f"\n**By Asset Class:**\n" + "\n".join(ac_lines) + "\n" if ac_lines else "")
        + (f"\n**Top Signal Sources:**\n" + "\n".join(src_lines) if src_lines else "")
        + f"\n\n_All-time: {at.get('total_trades',0)} trades · "
          f"{at.get('win_rate_pct',0):.1f}% WR · "
          f"${at.get('total_pnl_usd',0):,.0f} total P&L_"
    )

    color = 0x00d2a0 if pnl_m >= 0 else 0xff4757
    return {"embeds": [{
        "title":       f"📅 MONTHLY REPORT — {month_label}",
        "description": desc,
        "color":       color,
        "footer":      {"text": f"Auditor • {datetime.now(timezone.utc).strftime('%Y-%m-%d %H:%M')} UTC"},
    }]}


def build_weekly_embed(stats: dict, journal: list) -> dict:
    wk   = stats.get("weekly",{})
    at   = stats.get("all_time",{})
    by_src = stats.get("by_signal_source",{})
    by_av  = stats.get("by_analyst_verdict",{})
    macro  = load_file(os.path.join(_ROOT,"macro-strategist","macro_state.json"),{})

    week_start = wk.get("week_start","?")
    now_str    = datetime.now(timezone.utc).strftime("%B %-d, %Y")

    # Best/worst this week
    week_trades = [t for t in journal if (t.get("closed_at","") or "") >= week_start]
    best  = max(week_trades, key=lambda t: t.get("pnl_pct",0)) if week_trades else None
    worst = min(week_trades, key=lambda t: t.get("pnl_pct",0)) if week_trades else None

    # Top signal source
    top_src = max(by_src.items(), key=lambda x: x[1].get("win_rate",0)) if by_src else ("?", {})
    top_av  = max(by_av.items(), key=lambda x: x[1].get("win_rate",0))  if by_av  else ("?", {})

    desc = (
        f"**Trades:** {wk.get('trades_closed',0)} "
        f"({wk.get('wins',0)}W / {wk.get('losses',0)}L)\n"
        f"**P&L:** +${wk.get('pnl_usd',0):,.0f}\n"
        f"**Win rate:** {wk.get('win_rate_pct',0):.1f}%\n"
        + (f"**Best:** {best['symbol']} {best['pnl_pct']:+.1f}%\n" if best else "")
        + (f"**Worst:** {worst['symbol']} {worst['pnl_pct']:+.1f}%\n" if worst else "")
        + f"\n**Top signal source:** {top_src[0]} ({top_src[1].get('win_rate',0):.0f}% WR)\n"
        f"**Top analyst verdict:** {top_av[0]} ({top_av[1].get('win_rate',0):.0f}% WR)\n"
        f"**Macro regime:** {macro.get('regime','?')} → sizing modifier {macro.get('position_size_modifier',1.0)}x"
    )
    return {"embeds": [{
        "title":       f"📊 WEEKLY REPORT — {week_start} to {now_str}",
        "description": desc,
        "color":       0x6c5ce7,
        "footer":      {"text": f"Auditor • {datetime.now(timezone.utc).strftime('%Y-%m-%d %H:%M')} UTC"},
    }]}


def build_lesson_embed(lesson: dict) -> dict:
    conf  = lesson.get("confidence","?").upper()
    dp    = lesson.get("data_points", 0)
    target= lesson.get("actionable_for","?")
    desc  = (
        f"_{lesson['insight']}_\n\n"
        f"Based on **{dp} trades**.\n"
        f"Actionable for: **{target.title()}**"
    )
    color = 0x00d2a0 if conf == "HIGH" else 0xffa502
    return {"embeds": [{
        "title":       f"💡 NEW INSIGHT ({conf} confidence)",
        "description": desc,
        "color":       color,
        "footer":      {"text": f"Auditor • {lesson['timestamp'][:19].replace('T',' ')} UTC"},
    }]}


# ── Main loop ─────────────────────────────────────────────────────────────────

async def run():
    log.info("=== Auditor starting ===")
    log.info(f"Trade journal : {JOURNAL_FILE}")
    log.info(f"Stats         : {STATS_FILE}")
    log.info(f"Lessons       : {LESSONS_FILE}")
    log.info(f"Discord reviews  : {'✅' if REVIEWS_URL else '❌'}")
    log.info(f"Discord daily    : {'✅' if DAILY_URL else '❌'}")
    log.info(f"Discord weekly   : {'✅' if WEEKLY_URL else '❌'}")
    log.info(f"Discord monthly  : {'✅' if MONTHLY_URL else '❌'}")
    log.info(f"Discord lessons  : {'✅' if LESSONS_URL else '❌'}")
    log.info(f"Poll: {POLL_INTERVAL//60}min | Stats refresh: {STATS_INTERVAL//60}min\n")

    import time as _t
    last_stats   = 0.0
    last_daily   = ""
    last_weekly  = ""
    last_monthly = ""
    lessons_at_n = 0  # journal length at last lessons extraction

    async with aiohttp.ClientSession() as session:
        while True:
            now_dt = datetime.now(timezone.utc)
            now    = _t.monotonic()

            try:
                # ── Scan for new closed trades ────────────────────────────────
                executions      = load("executions") or []
                analyst_results = load("analyst")    or []
                signals         = load("signals")    or []
                risk_state      = load("risk_state") or {}

                journal  = load_file(JOURNAL_FILE, [])
                audited  = {e.get("execution_id","") for e in journal}
                closed   = [e for e in executions
                             if e.get("status") == "closed"
                             and e.get("id","") not in audited]

                if closed:
                    log.info(f"Found {len(closed)} new closed trade(s) to audit")

                for exe in closed:
                    entry = audit_trade(exe, analyst_results, signals, risk_state)
                    journal.append(entry)
                    save_file(JOURNAL_FILE, journal)

                    # Rebuild stats immediately
                    stats = rebuild_stats(journal)
                    save_file(STATS_FILE, stats)
                    at = stats.get("all_time",{})

                    log.info(f"  Audited: {entry['symbol']} {entry['direction']} "
                             f"{entry['outcome']} PnL={entry['pnl_pct']:+.2f}% "
                             f"WR={at.get('win_rate_pct',0):.1f}%")

                    await post_discord(session, REVIEWS_URL,
                                       build_review_embed(entry,
                                                          at.get("current_streak",0),
                                                          at.get("streak_type","")))
                    await asyncio.sleep(0.5)

                # ── Archive journal when large ────────────────────────────────
                journal = load_file(JOURNAL_FILE, [])
                if len(journal) > JOURNAL_MAX:
                    journal = await maybe_rotate(
                        session, "trade-journal", journal, JOURNAL_FILE,
                        max_entries=JOURNAL_MAX, webhook_url=ARCHIVE_URL
                    )
                    save_file(JOURNAL_FILE, journal)

                # ── Lessons every N trades ────────────────────────────────────
                journal = load_file(JOURNAL_FILE, [])
                n       = len(journal)
                if n >= lessons_at_n + LESSONS_EVERY_N and n > 0:
                    existing = load_file(LESSONS_FILE, [])
                    new_l    = extract_lessons(journal, existing)
                    if new_l:
                        existing.extend(new_l)
                        save_file(LESSONS_FILE, existing)
                        for lesson in new_l:
                            log.info(f"  💡 New lesson: {lesson['insight'][:60]}...")
                            await post_discord(session, LESSONS_URL,
                                               build_lesson_embed(lesson))
                            await asyncio.sleep(0.3)
                    lessons_at_n = n

                # ── Periodic stats rebuild ────────────────────────────────────
                if now - last_stats >= STATS_INTERVAL and journal:
                    stats = rebuild_stats(journal)
                    save_file(STATS_FILE, stats)
                    last_stats = now

                # ── Daily report at 23:55 UTC ─────────────────────────────────
                today_str = now_dt.strftime("%Y-%m-%d")
                if now_dt.hour == 23 and now_dt.minute >= 55 and today_str != last_daily:
                    journal = load_file(JOURNAL_FILE, [])
                    stats   = rebuild_stats(journal)
                    save_file(STATS_FILE, stats)
                    await post_discord(session, DAILY_URL, build_daily_embed(stats))
                    last_daily = today_str
                    log.info(f"  Daily report sent for {today_str}")

                # ── Weekly report Sunday 20:00 UTC ────────────────────────────
                week_id = f"{today_str}-w{now_dt.isoweekday()}"
                if (now_dt.isoweekday() == 7 and now_dt.hour == 20
                        and now_dt.minute < 5 and week_id != last_weekly):
                    journal = load_file(JOURNAL_FILE, [])
                    stats   = rebuild_stats(journal)
                    save_file(STATS_FILE, stats)
                    await post_discord(session, WEEKLY_URL,
                                       build_weekly_embed(stats, journal))
                    last_weekly = week_id
                    log.info("  Weekly report sent")

                # ── Monthly report — 1st of month at 00:00 UTC ────────────────
                month_id = now_dt.strftime("%Y-%m")
                if (now_dt.day == 1 and now_dt.hour == 0
                        and now_dt.minute < 5 and month_id != last_monthly):
                    journal = load_file(JOURNAL_FILE, [])
                    stats   = rebuild_stats(journal)
                    save_file(STATS_FILE, stats)
                    await post_discord(session, MONTHLY_URL,
                                       build_monthly_embed(stats, journal))
                    last_monthly = month_id
                    log.info(f"  Monthly report sent for {month_id}")

            except Exception as e:
                log.error(f"Cycle error: {e}", exc_info=True)

            await asyncio.sleep(POLL_INTERVAL)


if __name__ == "__main__":
    asyncio.run(run())
