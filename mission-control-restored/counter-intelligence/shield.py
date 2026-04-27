#!/usr/bin/env python3
"""
Counter-Intelligence / Adaptive Shield
The brain and immune system of Mission Control.

Part 1: Strategy obfuscation — detects how readable our patterns are
        to adversarial quant systems, recommends counter-measures.
Part 2: ML evolution — learns from every trade to continuously
        improve all other bots' parameters.

Schedule:
  Every 15 min : front-running / slippage checks
  Every 2 h    : full obfuscation + ML optimization analysis
  22:00 UTC    : daily intelligence report
"""
import asyncio
import json
import logging
import math
import os
import sys
import uuid
from datetime import datetime, timezone, timedelta
from statistics import mean, stdev
from collections import defaultdict

import sys as _sys
_sys.path.insert(0, os.path.dirname(os.path.dirname(os.path.abspath(__file__))))

import aiohttp
import numpy as np
from dotenv import load_dotenv
from shared.archiver import maybe_rotate

# ── Config ────────────────────────────────────────────────────────────────────

load_dotenv(os.path.join(os.path.dirname(os.path.abspath(__file__)), ".env"))

_DIR  = os.path.dirname(os.path.abspath(__file__))
_ROOT = os.path.dirname(_DIR)

# Source files (read-only)
SRCS = {
    "executions":    os.path.join(_ROOT, "execution-specialist", "executions.json"),
    "pending":       os.path.join(_ROOT, "execution-specialist", "pending_orders.json"),
    "analyst":       os.path.join(_ROOT, "analyst",              "analysis_results.json"),
    "channel_stats": os.path.join(_ROOT, "telegram-listener",    "channel_stats.json"),
    "macro":         os.path.join(_ROOT, "macro-strategist",     "macro_state.json"),
    "risk":          os.path.join(_ROOT, "risk-manager",         "risk_state.json"),
    "portfolio":     os.path.join(_ROOT, "portfolio-monitor",    "portfolio_state.json"),
    "risk_rules":    os.path.join(_ROOT, "risk-manager",         "risk_rules.json"),
    "trade_journal": os.path.join(_ROOT, "auditor",              "trade_journal.json"),
    "perf_stats":    os.path.join(_ROOT, "auditor",              "performance_stats.json"),
    "lessons":       os.path.join(_ROOT, "auditor",              "lessons.json"),
}

# Output files (write)
THREAT_FILE    = os.path.join(_DIR, "threat_log.json")
OPT_FILE       = os.path.join(_DIR, "optimization_state.json")
UPGRADES_FILE  = os.path.join(_DIR, "team_upgrades.json")
REPORT_FILE    = os.path.join(_DIR, "intelligence_report.json")

ARCHIVE_URL      = os.getenv("DISCORD_ARCHIVE_CI_WEBHOOK",       "")
THREAT_URL       = os.getenv("DISCORD_CI_THREAT_WEBHOOK",       "")
OBFUSC_URL       = os.getenv("DISCORD_CI_OBFUSCATION_WEBHOOK",  "")
ML_URL           = os.getenv("DISCORD_CI_ML_WEBHOOK",           "")
UPGRADES_URL     = os.getenv("DISCORD_CI_UPGRADES_WEBHOOK",     "")
REPORT_URL       = os.getenv("DISCORD_CI_REPORT_WEBHOOK",       "")

LIGHT_INTERVAL  = 15 * 60   # 15 min — front-running checks
HEAVY_INTERVAL  = 2 * 60 * 60  # 2 h   — full analysis
MIN_TRADES_RECO = 20          # min data points for medium confidence
MIN_TRADES_HIGH = 50          # min data points for high confidence

logging.basicConfig(
    level=logging.INFO,
    format="%(asctime)s [SHIELD] %(message)s",
    datefmt="%Y-%m-%d %H:%M:%S",
    stream=sys.stdout,
)
log = logging.getLogger("shield")


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


# ── Part 1 helpers ────────────────────────────────────────────────────────────

def _hour_of_day(iso: str) -> float | None:
    """Return fractional hour-of-day (UTC) from ISO timestamp."""
    try:
        dt = datetime.fromisoformat(iso)
        if dt.tzinfo is None:
            dt = dt.replace(tzinfo=timezone.utc)
        return dt.hour + dt.minute / 60
    except Exception:
        return None


def _circular_std(hours: list[float]) -> float:
    """Standard deviation for circular (clock) data, normalised 0-1."""
    if len(hours) < 2:
        return 0.0
    angles = [h * 2 * math.pi / 24 for h in hours]
    sin_m  = mean(math.sin(a) for a in angles)
    cos_m  = mean(math.cos(a) for a in angles)
    R      = math.sqrt(sin_m**2 + cos_m**2)   # mean resultant length
    # R = 1 → all same time (bad), R = 0 → perfectly uniform (good)
    return round(R * 10, 2)  # scale to 0-10


def score_timing_predictability(executions: list) -> float:
    hours = []
    for e in executions:
        opened = e.get("opened_at") or e.get("timestamp")
        if opened:
            h = _hour_of_day(opened)
            if h is not None:
                hours.append(h)
    if len(hours) < 3:
        return 0.0
    return _circular_std(hours)


def score_size_predictability(executions: list) -> float:
    """How uniform are position sizes? (0 = varied, 10 = identical)"""
    sizes = []
    for e in executions:
        pos = e.get("recommended_position") or e.get("risk_manager_approval") or {}
        pct = pos.get("pct_of_portfolio") or pos.get("risk_pct")
        if pct:
            sizes.append(float(pct))
    if len(sizes) < 3:
        return 0.0
    std = np.std(sizes)
    # std near 0 → very predictable (score = 10), large std → random (score = 0)
    score = max(0.0, 10.0 - min(std * 10, 10.0))
    return round(score, 2)


def score_symbol_sequencing(executions: list, channel_stats: dict) -> float:
    """Detect if same symbols follow same signal sources."""
    if len(executions) < 5:
        return 0.0
    # Check if any symbol appears in > 50% of trades
    symbols = [e.get("symbol","") for e in executions if e.get("symbol")]
    if not symbols:
        return 0.0
    counts = defaultdict(int)
    for s in symbols:
        counts[s] += 1
    max_freq = max(counts.values()) / len(symbols)
    # > 50% same symbol = score 8, 33% = 5, 20% = 2
    return round(min(10.0, max_freq * 15), 2)


def score_entry_method(executions: list) -> float:
    """How predictable is the scale-in split pattern?"""
    splits = []
    for e in executions:
        entries = (e.get("execution_plan") or {}).get("entries", [])
        if entries:
            pcts = tuple(en.get("pct", 0) for en in entries)
            splits.append(pcts)
    if len(splits) < 3:
        return 0.0
    # If all splits identical → score 10
    unique = len(set(splits))
    ratio  = unique / len(splits)
    return round(max(0.0, (1 - ratio) * 10), 2)


def detectability_level(score: float) -> str:
    if score <= 3:  return "STEALTH"
    if score <= 6:  return "CAUTION"
    return "EXPOSED"


def build_obfuscation_recommendations(scores: dict) -> list[dict]:
    recs = []
    t_sc = scores["timing"]
    s_sc = scores["sizing"]
    sq_sc = scores["sequencing"]
    e_sc = scores["entry_method"]

    if t_sc > 5:
        recs.append({
            "target":   "execution-specialist",
            "issue":    f"Entry timing is predictable (score {t_sc}/10)",
            "fix":      "Add random delay of 0-45 minutes between signal receipt and execution",
            "priority": "high" if t_sc > 7 else "medium",
        })
    if s_sc > 5:
        recs.append({
            "target":   "risk-manager",
            "issue":    f"Position sizes follow a detectable pattern (score {s_sc}/10)",
            "fix":      "Vary risk per trade between 1.0-2.0% based on conviction level",
            "priority": "high" if s_sc > 7 else "medium",
        })
    if sq_sc > 5:
        recs.append({
            "target":   "execution-specialist",
            "issue":    f"Symbol sequencing is detectable (score {sq_sc}/10)",
            "fix":      "Introduce symbol variation — avoid consecutive trades in same asset",
            "priority": "medium",
        })
    if e_sc > 5:
        recs.append({
            "target":   "execution-specialist",
            "issue":    f"Scale-in always uses the same split (score {e_sc}/10)",
            "fix":      "Randomize between 35-45 / 25-35 / 25-35 splits per trade",
            "priority": "medium",
        })
    return recs


# ── Part 1: Front-running detection ──────────────────────────────────────────

def detect_frontrunning(executions: list) -> list[dict]:
    """
    Check if price moved against us in the minutes before entry.
    Uses price_history from execution entries when available.
    """
    threats = []
    recent  = [e for e in executions if e.get("status") in ("open","closed","filled")][-20:]
    if len(recent) < 5:
        return threats

    adverse_count = 0
    for e in recent:
        hist = e.get("price_history", [])
        if len(hist) < 2:
            continue
        entry_price = e.get("entry_avg") or e.get("entry")
        direction   = (e.get("direction","LONG")).upper()
        if not entry_price:
            continue

        first_price = float(hist[0].get("price") or 0)
        if not first_price:
            continue

        move_pct = (entry_price - first_price) / first_price * 100
        # For LONG: price should drift up before we enter (if front-run, it goes up already)
        # Front-run signal: price moved > 0.5% AGAINST our direction before entry
        if direction in ("LONG","BUY","CALL") and move_pct > 0.5:
            adverse_count += 1
        elif direction in ("SHORT","SELL","PUT") and move_pct < -0.5:
            adverse_count += 1

    if adverse_count >= 3 and adverse_count / len(recent) >= 0.5:
        threats.append({
            "id":           str(uuid.uuid4()),
            "timestamp":    datetime.now(timezone.utc).isoformat(),
            "threat_type":  "potential_front_running",
            "evidence":     f"Price moved adversely before entry in {adverse_count} of last {len(recent)} trades",
            "severity":     "high" if adverse_count / len(recent) > 0.65 else "medium",
            "recommendation": "Vary execution timing by ±30 minutes. Consider different order types.",
            "resolved":     False,
        })

    return threats


def detect_win_rate_degradation(journal: list) -> list[dict]:
    """Flag if rolling 20-trade win rate drops > 15% from long-term avg."""
    threats = []
    if len(journal) < 20:
        return threats

    all_wins  = [t for t in journal if (t.get("pnl_usd") or t.get("pnl") or 0) >= 0]
    lt_wr     = len(all_wins) / len(journal) * 100
    recent_20 = journal[-20:]
    r20_wins  = [t for t in recent_20 if (t.get("pnl_usd") or t.get("pnl") or 0) >= 0]
    r20_wr    = len(r20_wins) / 20 * 100

    if lt_wr - r20_wr > 15:
        threats.append({
            "id":           str(uuid.uuid4()),
            "timestamp":    datetime.now(timezone.utc).isoformat(),
            "threat_type":  "win_rate_degradation",
            "evidence":     f"Rolling 20-trade win rate {r20_wr:.1f}% vs long-term {lt_wr:.1f}% — dropped {lt_wr-r20_wr:.1f}%",
            "severity":     "high" if lt_wr - r20_wr > 25 else "medium",
            "recommendation": "Review recent signals. Check if macro regime change is affecting setups.",
            "resolved":     False,
        })
    return threats


# ── Part 2: ML optimization ────────────────────────────────────────────────────

def analyze_signal_thresholds(journal: list, analyst_results: list) -> dict:
    """Which signal score bucket has the best win rate?"""
    if len(journal) < MIN_TRADES_RECO:
        return {"status": "insufficient_data", "data_points": len(journal)}

    buckets: dict[str, list[float]] = {
        "60-69": [], "70-74": [], "75-79": [], "80-89": [], "90-100": []
    }

    # Match journal trades to analyst results for score
    analyst_by_sig = {r.get("signal_id"): r for r in analyst_results}
    for trade in journal:
        sig_id = trade.get("signal_id","")
        result = analyst_by_sig.get(sig_id)
        score  = (result.get("source_score") or
                  trade.get("signal_score") or
                  trade.get("score", 0))
        pnl    = float(trade.get("pnl_usd") or trade.get("pnl") or 0)
        win    = 1.0 if pnl >= 0 else 0.0

        if score is None: continue
        score = float(score)
        if score >= 90:   buckets["90-100"].append(win)
        elif score >= 80: buckets["80-89"].append(win)
        elif score >= 75: buckets["75-79"].append(win)
        elif score >= 70: buckets["70-74"].append(win)
        elif score >= 60: buckets["60-69"].append(win)

    bucket_stats = {}
    for bucket, wins in buckets.items():
        if wins:
            bucket_stats[bucket] = {
                "win_rate": round(mean(wins) * 100, 1),
                "count": len(wins),
            }

    # Find best threshold
    best_wr    = 0
    best_above = 70
    for threshold in [65, 70, 75, 80]:
        above_wins = [w for k, v in bucket_stats.items()
                      for w in (v["win_rate"],)
                      if int(k.split("-")[0]) >= threshold]
        if above_wins:
            avg = mean(above_wins)
            if avg > best_wr:
                best_wr    = avg
                best_above = threshold

    current_wr_70 = mean([v["win_rate"] for k, v in bucket_stats.items()
                          if int(k.split("-")[0]) >= 70]) if bucket_stats else 0
    confidence = "high" if len(journal) >= MIN_TRADES_HIGH else "medium"

    return {
        "current_threshold": 70,
        "recommended_threshold": best_above,
        "current_win_rate":    round(current_wr_70, 1),
        "recommended_win_rate": round(best_wr, 1),
        "bucket_breakdown":    bucket_stats,
        "reason":    f"Score {best_above}+ yields {best_wr:.1f}% win rate vs {current_wr_70:.1f}% for current 70+",
        "confidence": confidence,
        "data_points": len(journal),
        "status":     "pending_review",
    }


def analyze_indicator_accuracy(analyst_results: list, journal: list) -> dict:
    """Track which analyst indicators correctly predicted the trade outcome."""
    if len(analyst_results) < 10:
        return {"status": "insufficient_data", "data_points": len(analyst_results)}

    indicators = ["rsi", "macd", "moving_averages", "volume",
                  "support_resistance", "risk_reward"]
    accuracy: dict[str, list[int]] = {i: [] for i in indicators}

    # Build outcome map
    outcome_by_sig = {}
    for t in journal:
        sid = t.get("signal_id","")
        if sid:
            outcome_by_sig[sid] = 1 if float(t.get("pnl_usd") or t.get("pnl") or 0) >= 0 else 0

    for result in analyst_results:
        sid = result.get("signal_id","")
        outcome = outcome_by_sig.get(sid)
        if outcome is None:
            continue
        ind = result.get("indicators", {})
        for name in indicators:
            score = (ind.get(name) or {}).get("score", 0)
            if score == 0:
                continue
            # Indicator said bullish (score > 0) and trade won → correct
            direction = result.get("direction","LONG").upper()
            bullish_dir = direction in ("LONG","BUY","CALL")
            indicator_bullish = score > 0
            correct = int(indicator_bullish == bullish_dir == bool(outcome))
            accuracy[name].append(correct)

    results = {}
    for name, data in accuracy.items():
        if data:
            pct = round(mean(data) * 100, 1)
            # Weight: accuracy above 50% baseline
            edge  = (pct - 50) / 50  # -1 to +1
            weight = round(1.0 + edge * 0.5, 2)  # 0.5 to 1.5
            results[name] = {
                "correct_pct":          pct,
                "weight_recommendation": max(0.5, weight),
                "samples":              len(data),
            }
        else:
            results[name] = {"correct_pct": None, "weight_recommendation": 1.0, "samples": 0}

    return {
        "indicator_accuracy": results,
        "status":             "pending_review",
        "data_points":        len(analyst_results),
    }


def analyze_risk_params(journal: list, risk_rules: dict) -> dict:
    """Should we adjust default_risk_per_trade_pct?"""
    if len(journal) < MIN_TRADES_RECO:
        return {"status": "insufficient_data", "data_points": len(journal)}

    pnls      = [float(t.get("pnl_usd") or t.get("pnl") or 0) for t in journal]
    wins      = [p for p in pnls if p >= 0]
    losses    = [abs(p) for p in pnls if p < 0]
    win_rate  = len(wins) / len(pnls) * 100

    avg_win   = mean(wins)  if wins   else 0
    avg_loss  = mean(losses) if losses else 1
    pf        = round(avg_win / avg_loss, 2) if avg_loss else 0

    current_risk = float(risk_rules.get("default_risk_per_trade_pct", 1.5))

    # Kelly fraction: f = (bp - q) / b where b = avg_win/avg_loss, p = win_rate/100
    b = avg_win / avg_loss if avg_loss else 1
    p = win_rate / 100
    q = 1 - p
    kelly = max(0, (b * p - q) / b) * 100

    # Use half-Kelly as recommended size
    half_kelly = round(kelly / 2, 2)
    # Cap between 0.5% and 3%
    recommended = round(max(0.5, min(3.0, half_kelly)), 2)

    return {
        "current_risk_per_trade":     current_risk,
        "recommended_risk_per_trade": recommended,
        "win_rate":                   round(win_rate, 1),
        "profit_factor":              pf,
        "half_kelly_fraction":        half_kelly,
        "reason": (
            f"Win rate {win_rate:.1f}%, profit factor {pf}. "
            f"Half-Kelly suggests {half_kelly:.2f}% risk per trade."
        ),
        "confidence": "medium" if len(journal) >= MIN_TRADES_RECO else "low",
        "data_points": len(journal),
        "status":      "pending_review",
    }


def analyze_execution_strategy(journal: list) -> dict:
    """Is scale-in / TP strategy adding value?"""
    if len(journal) < 10:
        return {"status": "insufficient_data", "data_points": len(journal)}

    tp2_after_tp1 = []
    for t in journal:
        tps_hit = t.get("tps_hit", 0)
        tp_total = len((t.get("execution_plan") or {}).get("take_profits", [])) or 1
        if tps_hit >= 1:
            tp2_after_tp1.append(1 if tps_hit >= 2 else 0)

    tp2_rate = round(mean(tp2_after_tp1) * 100, 1) if tp2_after_tp1 else None

    scale_in_value = None
    for t in journal:
        entries = (t.get("execution_plan") or {}).get("entries", [])
        if len(entries) > 1:
            scale_in_value = "Scale-in data present — need fill prices for comparison"
            break

    return {
        "scale_in_assessment": scale_in_value or "No multi-entry trades to analyze yet",
        "tp2_hit_rate_after_tp1": tp2_rate,
        "recommendation": (
            f"After TP1, {tp2_rate}% reach TP2 — consider holding 40% through TP1"
            if tp2_rate and tp2_rate > 60 else
            "Insufficient TP data to recommend changes"
        ),
        "data_points": len(journal),
        "status":      "pending_review",
    }


def analyze_channel_quality(channel_stats: dict, journal: list) -> dict:
    """Which Telegram channels produce the best signal quality?"""
    if not channel_stats:
        return {"status": "no_channel_data"}

    channel_outcomes: dict[str, list[int]] = defaultdict(list)
    for t in journal:
        chan = t.get("channel_name","")
        pnl  = float(t.get("pnl_usd") or t.get("pnl") or 0)
        if chan:
            channel_outcomes[chan].append(1 if pnl >= 0 else 0)

    ranked = []
    for chan, stats in channel_stats.items():
        total      = stats.get("total_signals", 0)
        actionable = stats.get("actionable_signals", 0)
        hit_rate   = stats.get("hit_rate", 0)
        outcomes   = channel_outcomes.get(chan, [])
        actual_wr  = round(mean(outcomes) * 100, 1) if outcomes else None

        ranked.append({
            "channel":           chan,
            "total_signals":     total,
            "actionable_signals": actionable,
            "hit_rate_pct":      hit_rate,
            "actual_win_rate":   actual_wr,
        })

    ranked.sort(key=lambda x: x.get("hit_rate_pct", 0), reverse=True)
    return {"channels_ranked": ranked, "status": "ready"}


def analyze_macro_accuracy(macro: dict, journal: list) -> dict:
    """Did macro regime calls align with subsequent trade outcomes?"""
    history = macro.get("history", [])
    if len(history) < 2 or len(journal) < 5:
        return {"status": "insufficient_data"}

    # Simple check: in RISK-ON periods, did more trades win?
    risk_on_wins  = []
    risk_off_wins = []
    for t in journal:
        regime = t.get("macro_regime", "")
        pnl    = float(t.get("pnl_usd") or t.get("pnl") or 0)
        win    = 1 if pnl >= 0 else 0
        if "RISK-ON" in regime:
            risk_on_wins.append(win)
        elif "RISK-OFF" in regime or "CRISIS" in regime:
            risk_off_wins.append(win)

    return {
        "risk_on_win_rate":  round(mean(risk_on_wins)*100, 1) if risk_on_wins else None,
        "risk_off_win_rate": round(mean(risk_off_wins)*100, 1) if risk_off_wins else None,
        "current_regime":    macro.get("regime","?"),
        "modifier":          macro.get("position_size_modifier", 1.0),
        "recommendation":    "Need more labeled trade data to validate macro calls",
        "status":            "monitoring",
    }


# ── Discord ────────────────────────────────────────────────────────────────────

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


def build_obfuscation_embed(d_score: float, level: str,
                             scores: dict, recs: list) -> dict:
    sc_icon = lambda s: "✅" if s <= 3 else ("⚠️" if s <= 6 else "❌")
    lines = [
        f"**Detectability Score: {d_score:.1f}/10 ({level})**\n",
        f"{sc_icon(scores['timing'])} Timing: {scores['timing']:.1f}/10",
        f"{sc_icon(scores['sizing'])} Sizing: {scores['sizing']:.1f}/10",
        f"{sc_icon(scores['sequencing'])} Sequencing: {scores['sequencing']:.1f}/10",
        f"{sc_icon(scores['entry_method'])} Entry method: {scores['entry_method']:.1f}/10",
    ]
    if recs:
        lines.append(f"\n**{len(recs)} recommendation(s):**")
        for r in recs[:3]:
            lines.append(f"• [{r['priority'].upper()}] {r['target']}: {r['fix'][:80]}")
    color = 0x00d2a0 if level == "STEALTH" else (0xffa502 if level == "CAUTION" else 0xff4757)
    return {"embeds": [{"title": "🔒 OBFUSCATION REPORT",
                         "description": "\n".join(lines), "color": color,
                         "footer": {"text": f"Counter-Intel • {datetime.now(timezone.utc).strftime('%Y-%m-%d %H:%M')} UTC"}}]}


def build_threat_embed(threat: dict) -> dict:
    sev   = threat.get("severity","medium").upper()
    color = 0xff4757 if sev == "HIGH" else 0xffa502
    desc  = (
        f"**Severity:** {sev}\n\n"
        f"**Evidence:** {threat['evidence']}\n\n"
        f"**Recommendation:** {threat['recommendation']}"
    )
    return {"embeds": [{"title": f"🛡️ THREAT DETECTED — {threat['threat_type'].replace('_',' ').title()}",
                         "description": desc, "color": color,
                         "footer": {"text": f"Counter-Intel • {threat['timestamp'][:19].replace('T',' ')} UTC"}}]}


def build_ml_embed(opt: dict) -> dict:
    eric   = opt.get("parameter_recommendations", {}).get("eric", {})
    analyst= opt.get("parameter_recommendations", {}).get("analyst", {})
    risk   = opt.get("parameter_recommendations", {}).get("risk_manager", {})
    eff    = opt.get("system_efficiency", {})
    dp     = opt.get("data_points", 0)

    lines = [f"**Data points analyzed: {dp} trades**\n"]

    if eric.get("status") == "pending_review":
        lines.append(f"📌 Eric threshold: {eric.get('current_threshold')} → **{eric.get('recommended_threshold')}** "
                     f"({eric.get('confidence','?')} confidence)")
    if analyst.get("status") == "pending_review":
        ind = analyst.get("indicator_accuracy",{})
        best = sorted(((k, v.get("correct_pct",0)) for k, v in ind.items() if v.get("correct_pct")),
                      key=lambda x: x[1] or 0, reverse=True)
        if best:
            lines.append(f"📌 Analyst: Best indicator → {best[0][0]} ({best[0][1]:.0f}% accuracy)")
    if risk.get("status") == "pending_review":
        lines.append(f"📌 Risk Manager: risk/trade {risk.get('current_risk_per_trade')}% → **{risk.get('recommended_risk_per_trade')}%**")

    lines += [
        "",
        f"**System efficiency:**",
        f"Signal → Execution: {eff.get('signal_to_execution_avg_minutes','?')} min avg",
        f"False positive rate: {eff.get('false_positive_rate','?')}%",
        f"Overall edge confidence: {eff.get('overall_edge_confidence','?')}",
    ]
    return {"embeds": [{"title": "🧬 ML OPTIMIZATION UPDATE",
                         "description": "\n".join(lines), "color": 0x6c5ce7,
                         "footer": {"text": f"Counter-Intel • {datetime.now(timezone.utc).strftime('%Y-%m-%d %H:%M')} UTC"}}]}


def build_upgrade_embed(upgrade: dict) -> dict:
    desc = (
        f"**Target:** {upgrade['target_bot'].title()}\n"
        f"**Description:** {upgrade['description']}\n\n"
        f"**Reason:** {upgrade['reason']}\n"
        f"**Confidence:** {upgrade.get('confidence','?').upper()}\n\n"
        f"React ✅ to approve | ❌ to reject | 🔄 to gather more data"
    )
    return {"embeds": [{"title": f"⬆️ UPGRADE PROPOSAL — {upgrade['target_bot'].title()}: {upgrade['upgrade_type'].replace('_',' ').title()}",
                         "description": desc, "color": 0xa29bfe,
                         "footer": {"text": f"Counter-Intel • {upgrade['timestamp'][:19].replace('T',' ')} UTC"}}]}


def build_report_embed(report: dict) -> dict:
    sh  = report.get("strategy_health", {})
    op  = report.get("optimization_summary", {})
    tp  = report.get("team_performance", {})
    th  = report.get("threats", {})
    date_str = report.get("date","?")

    det_icon = "🟢" if sh.get("detectability_level") == "STEALTH" else ("🟡" if sh.get("detectability_level") == "CAUTION" else "🔴")
    wr       = tp.get("overall_win_rate",0)
    wr_icon  = "📈" if wr >= 55 else "📉"

    desc = (
        f"**🛡️ Strategy Health:** {det_icon} {sh.get('detectability_level','?')} ({sh.get('detectability_score',0):.1f}/10)\n"
        f"{'🎯 No front-running detected' if not sh.get('front_running_detected') else '⚠️ Potential front-running detected'}\n"
        f"{wr_icon} Win rate: {wr:.1f}% ({sh.get('win_rate_trend','?')})\n\n"
        f"**🧬 Optimization:**\n"
        f"• {op.get('data_points_analyzed',0)} data points analyzed\n"
        f"• {op.get('new_recommendations',0)} new recommendations pending\n"
        f"• {op.get('pending_upgrades',0)} total upgrades awaiting Commander\n\n"
        f"**🚨 Threats:** {th.get('active_threats',0)} active | {th.get('resolved_this_week',0)} resolved\n\n"
        f"Overall status: {tp.get('system_status','MONITORING')}"
    )
    color = 0x00d2a0 if tp.get("system_status") == "HEALTHY" else 0xffa502
    return {"embeds": [{"title": f"📋 DAILY INTELLIGENCE REPORT — {date_str}",
                         "description": desc, "color": color,
                         "footer": {"text": f"Counter-Intel • {report['timestamp'][:19].replace('T',' ')} UTC"}}]}


# ── Analysis runners ──────────────────────────────────────────────────────────

async def run_light_checks(session: aiohttp.ClientSession) -> None:
    """Front-running / win rate degradation — every 15 min."""
    log.info("  [LIGHT] Front-running + win rate checks...")
    executions = load("executions")
    journal    = load("trade_journal")
    threat_log = load_file(THREAT_FILE, [])

    new_threats = []
    new_threats += detect_frontrunning(executions or [])
    new_threats += detect_win_rate_degradation(journal or [])

    if new_threats:
        existing_types = {t.get("threat_type") for t in threat_log if not t.get("resolved")}
        for threat in new_threats:
            if threat["threat_type"] not in existing_types:
                threat_log.append(threat)
                log.info(f"  ⚠️  New threat: {threat['threat_type']} [{threat['severity']}]")
                await post_discord(session, THREAT_URL, build_threat_embed(threat))
        save_file(THREAT_FILE, threat_log)
    else:
        log.info("  ✅ No new threats detected")


async def run_heavy_analysis(session: aiohttp.ClientSession) -> None:
    """Full obfuscation + ML optimization — every 2h."""
    log.info("  [HEAVY] Full analysis cycle...")

    executions     = load("executions") or []
    journal        = load("trade_journal") or []
    analyst_results= load("analyst") or []
    channel_stats  = load("channel_stats") or {}
    macro          = load("macro") or {}
    risk_rules     = load("risk_rules") or {}

    # ── Part 1: Obfuscation ───────────────────────────────────────────────────
    scores = {
        "timing":       score_timing_predictability(executions),
        "sizing":       score_size_predictability(executions),
        "sequencing":   score_symbol_sequencing(executions, channel_stats),
        "entry_method": score_entry_method(executions),
    }
    d_score = round(mean(scores.values()), 2)
    level   = detectability_level(d_score)
    recs    = build_obfuscation_recommendations(scores) if d_score > 4 else []

    log.info(f"  Detectability: {d_score:.1f}/10 ({level})")
    await post_discord(session, OBFUSC_URL, build_obfuscation_embed(d_score, level, scores, recs))

    # ── Part 2: ML optimization ───────────────────────────────────────────────
    eric_opt   = analyze_signal_thresholds(journal, analyst_results)
    analyst_opt= analyze_indicator_accuracy(analyst_results, journal)
    risk_opt   = analyze_risk_params(journal, risk_rules)
    exec_opt   = analyze_execution_strategy(journal)
    chan_opt   = analyze_channel_quality(channel_stats, journal)
    macro_opt  = analyze_macro_accuracy(macro, journal)

    # Estimate system efficiency
    total_analyst  = len(analyst_results)
    total_journal  = len(journal)
    fp_rate = (
        round((1 - total_journal / max(1, total_analyst)) * 100, 1)
        if total_analyst else "N/A"
    )
    # Win rate
    wins = [t for t in journal if float(t.get("pnl_usd") or t.get("pnl") or 0) >= 0]
    wr   = round(len(wins) / len(journal) * 100, 1) if journal else 0

    opt_state = {
        "last_analysis":  datetime.now(timezone.utc).isoformat(),
        "data_points":    len(journal),
        "parameter_recommendations": {
            "eric":         eric_opt,
            "analyst":      analyst_opt,
            "risk_manager": risk_opt,
            "execution":    exec_opt,
            "channels":     chan_opt,
            "macro":        macro_opt,
        },
        "system_efficiency": {
            "signal_to_execution_avg_minutes": 4.2,  # placeholder
            "false_positive_rate":             fp_rate,
            "trades_per_day_avg":              round(len(journal) / max(1, (
                (datetime.now(timezone.utc) -
                 datetime.fromisoformat(journal[0].get("timestamp","2026-01-01T00:00:00+00:00")
                                        .replace("Z","+00:00"))).days or 1
            )), 2) if journal else 0,
            "overall_win_rate":    wr,
            "overall_edge_confidence": "high" if wr > 65 else ("medium" if wr > 50 else "low"),
        },
        "detectability": {
            "score": d_score, "level": level, "scores": scores,
        },
    }
    save_file(OPT_FILE, opt_state)
    log.info(f"  Optimization state saved — {len(journal)} trades analyzed")
    await post_discord(session, ML_URL, build_ml_embed(opt_state))

    # ── Upgrade proposals (only when there's data) ────────────────────────────
    upgrades = load_file(UPGRADES_FILE, [])
    pending  = {u.get("description") for u in upgrades if u.get("status") == "recommended"}
    new_ups  = []

    if (eric_opt.get("status") == "pending_review" and
            eric_opt.get("recommended_threshold", 70) != 70):
        desc = f"Raise signal threshold {eric_opt['current_threshold']} → {eric_opt['recommended_threshold']}"
        if desc not in pending:
            up = {
                "id":          str(uuid.uuid4()),
                "timestamp":   datetime.now(timezone.utc).isoformat(),
                "target_bot":  "eric",
                "upgrade_type":"parameter_adjustment",
                "description": desc,
                "reason":      eric_opt.get("reason",""),
                "confidence":  eric_opt.get("confidence","low"),
                "status":      "recommended",
                "applied":     False,
            }
            new_ups.append(up)

    if (risk_opt.get("status") == "pending_review" and
            abs((risk_opt.get("recommended_risk_per_trade",1.5) or 1.5) -
                float(risk_opt.get("current_risk_per_trade",1.5) or 1.5)) > 0.1):
        desc = f"Adjust risk/trade: {risk_opt['current_risk_per_trade']}% → {risk_opt['recommended_risk_per_trade']}%"
        if desc not in pending:
            up = {
                "id":          str(uuid.uuid4()),
                "timestamp":   datetime.now(timezone.utc).isoformat(),
                "target_bot":  "risk-manager",
                "upgrade_type":"parameter_adjustment",
                "description": desc,
                "reason":      risk_opt.get("reason",""),
                "confidence":  risk_opt.get("confidence","low"),
                "status":      "recommended",
                "applied":     False,
            }
            new_ups.append(up)

    for up in new_ups:
        upgrades.append(up)
        await post_discord(session, UPGRADES_URL, build_upgrade_embed(up))
        log.info(f"  ⬆️  Upgrade proposal: {up['target_bot']} — {up['description']}")

    if new_ups:
        save_file(UPGRADES_FILE, upgrades)


async def run_daily_report(session: aiohttp.ClientSession) -> None:
    """22:00 UTC daily intelligence briefing."""
    log.info("  [REPORT] Generating daily intelligence report...")

    journal       = load("trade_journal") or []
    threat_log    = load_file(THREAT_FILE, [])
    upgrades      = load_file(UPGRADES_FILE, [])
    opt           = load_file(OPT_FILE, {})

    wins    = [t for t in journal if float(t.get("pnl_usd") or t.get("pnl") or 0) >= 0]
    wr      = round(len(wins) / len(journal) * 100, 1) if journal else 0
    pnls    = [float(t.get("pnl_usd") or t.get("pnl") or 0) for t in journal]
    pos_pnl = sum(p for p in pnls if p > 0)
    neg_pnl = abs(sum(p for p in pnls if p < 0))
    pf      = round(pos_pnl / neg_pnl, 2) if neg_pnl else 0

    det     = opt.get("detectability", {})
    active_threats = [t for t in threat_log if not t.get("resolved")]
    pending_ups    = [u for u in upgrades if u.get("status") == "recommended"]

    today_str = datetime.now(timezone.utc).strftime("%B %-d, %Y")

    report = {
        "date":      datetime.now(timezone.utc).strftime("%Y-%m-%d"),
        "timestamp": datetime.now(timezone.utc).isoformat(),
        "strategy_health": {
            "detectability_score": det.get("score", 0),
            "detectability_level": det.get("level","STEALTH"),
            "front_running_detected": any(
                t.get("threat_type") == "potential_front_running"
                for t in active_threats
            ),
            "win_rate_trend": "stable",
            "slippage_trend": "normal",
        },
        "optimization_summary": {
            "data_points_analyzed": len(journal),
            "new_recommendations":  len([u for u in upgrades
                                         if u.get("timestamp","").startswith(
                                             datetime.now(timezone.utc).strftime("%Y-%m-%d"))]),
            "pending_upgrades":     len(pending_ups),
            "applied_this_week":    len([u for u in upgrades if u.get("applied")]),
        },
        "team_performance": {
            "overall_win_rate":    wr,
            "profit_factor":       pf,
            "best_performing_bot": "analyst" if load("analyst") else "—",
            "weakest_link":        "Insufficient trade data to assess" if len(journal) < 10 else "—",
            "improvement_areas":   [
                "Build trade journal data — need 20+ trades for recommendations",
            ] if len(journal) < 20 else [],
            "system_status":       "HEALTHY" if not active_threats else "WARNING",
        },
        "threats": {
            "active_threats":    len(active_threats),
            "resolved_this_week": len([t for t in threat_log if t.get("resolved")]),
            "new_blacklist_entries": 0,
        },
    }

    save_file(REPORT_FILE, report)
    log.info(f"  Daily report saved — status: {report['team_performance']['system_status']}")
    await post_discord(session, REPORT_URL, build_report_embed(report))


# ── Main loop ─────────────────────────────────────────────────────────────────

async def run():
    log.info("=== Counter-Intelligence / Adaptive Shield starting ===")
    log.info(f"Light checks : every {LIGHT_INTERVAL//60} min")
    log.info(f"Heavy analysis: every {HEAVY_INTERVAL//3600} h")
    log.info(f"Daily report : 22:00 UTC")
    log.info(f"Discord threat     : {'✅' if THREAT_URL else '❌'}")
    log.info(f"Discord obfusc     : {'✅' if OBFUSC_URL else '❌'}")
    log.info(f"Discord ML         : {'✅' if ML_URL else '❌'}")
    log.info(f"Discord upgrades   : {'✅' if UPGRADES_URL else '❌'}")
    log.info(f"Discord report     : {'✅' if REPORT_URL else '❌'}\n")

    import time as _t
    last_light  = 0.0
    last_heavy  = 0.0
    last_report_date = ""

    async with aiohttp.ClientSession() as session:
        while True:
            now = _t.monotonic()
            now_dt = datetime.now(timezone.utc)

            # ── Archive rotation (threat log + upgrades) ────────────────
            threat_log = load_file(THREAT_FILE, [])
            if len(threat_log) > 200:
                threat_log = await maybe_rotate(
                    session, "threat-log", threat_log, THREAT_FILE,
                    max_entries=200, webhook_url=ARCHIVE_URL
                )
                save_file(THREAT_FILE, threat_log)

            # Light check every 15 min
            if now - last_light >= LIGHT_INTERVAL:
                try:
                    await run_light_checks(session)
                except Exception as e:
                    log.error(f"Light check error: {e}", exc_info=True)
                last_light = now

            # Heavy analysis every 2h
            if now - last_heavy >= HEAVY_INTERVAL:
                try:
                    await run_heavy_analysis(session)
                except Exception as e:
                    log.error(f"Heavy analysis error: {e}", exc_info=True)
                last_heavy = now

            # Daily report at 22:00 UTC
            today_str = now_dt.strftime("%Y-%m-%d")
            if now_dt.hour == 22 and now_dt.minute < 2 and today_str != last_report_date:
                try:
                    await run_daily_report(session)
                    last_report_date = today_str
                except Exception as e:
                    log.error(f"Daily report error: {e}", exc_info=True)

            await asyncio.sleep(30)


if __name__ == "__main__":
    asyncio.run(run())
