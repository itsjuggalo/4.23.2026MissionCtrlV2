"""Pattern detection logic - pure functions, no side effects.
Takes flow data + OHLC provider, returns list of alerts.
"""
import json, logging, time
from datetime import datetime, timedelta
from pathlib import Path
from collections import defaultdict

DATA_DIR = Path.home() / "mission-control-restored" / "Option-Signals-Scraper" / "data"

# Thresholds (tunable)
BREAKOUT_PREMIUM_MULT = 3.0       # premium today >= 3x 7d avg
BREAKOUT_MIN_PREMIUM = 500_000    # only consider tickers with $500K+ today
GAP_PCT_MIN = 2.0                  # opening gap >= 2%
GAP_FIRST_HOUR_PREM = 500_000      # first-hour bull premium >= $500K
FLAG_BULL_DAYS = 3                 # 3 consecutive bull-flow days
FLAG_CONSOL_PCT = 3.0              # price within 3% range during consol
REVERSAL_FLIP_PCT = 40             # bull% must flip 40+ pts in <2hr
MIN_TOTAL_PREM_FOR_REVERSAL = 1_000_000


def read_data(name):
    p = DATA_DIR / f"{name}.json"
    if not p.exists(): return None
    try: return json.loads(p.read_text())
    except: return None


def aggregate_flow_today():
    """Per-ticker today's flow stats from flow_liveflows_today."""
    d = read_data("flow_liveflows_today") or {}
    if not isinstance(d, dict): return {}
    by_ticker = defaultdict(lambda: {"bull": 0.0, "bear": 0.0, "total": 0.0,
                                      "n": 0, "fills": []})
    for entry in d.values():
        if not isinstance(entry, dict): continue
        sym = entry.get("Symbol", "")
        if not sym: continue
        opt = entry.get("OptionType", "")
        ba = entry.get("BidAskType", "")
        val = float(entry.get("Value", 0) or 0)
        ts = int(entry.get("Time", 0) or 0)
        if val <= 0: continue
        is_bull = (opt == "CALL" and ba == "A") or (opt == "PUT" and ba == "B")
        is_bear = (opt == "CALL" and ba == "B") or (opt == "PUT" and ba == "A")
        if not (is_bull or is_bear): continue
        s = by_ticker[sym]
        if is_bull: s["bull"] += val
        else: s["bear"] += val
        s["total"] += val
        s["n"] += 1
        s["fills"].append({"ts": ts, "val": val, "bull": is_bull})
    return dict(by_ticker)


def aggregate_flow_history(lookback_days=8):
    """Per-ticker daily premium history from flow_alerts_history.json."""
    d = read_data("flow_alerts_history") or {}
    if not isinstance(d, dict): return {}
    by_ticker_day = defaultdict(lambda: defaultdict(lambda: {"total": 0.0, "bull": 0.0, "bear": 0.0}))
    cutoff = time.time() - (lookback_days * 86400)
    for entry in d.values():
        if not isinstance(entry, dict): continue
        sym = entry.get("Symbol", "")
        if not sym: continue
        ts = int(entry.get("Time", 0) or 0)
        if ts < cutoff: continue
        val = float(entry.get("Value", 0) or 0)
        if val <= 0: continue
        opt = entry.get("OptionType", "")
        ba = entry.get("BidAskType", "")
        is_bull = (opt == "CALL" and ba == "A") or (opt == "PUT" and ba == "B")
        is_bear = (opt == "CALL" and ba == "B") or (opt == "PUT" and ba == "A")
        if not (is_bull or is_bear): continue
        day = datetime.fromtimestamp(ts).date().isoformat()
        s = by_ticker_day[sym][day]
        s["total"] += val
        if is_bull: s["bull"] += val
        else: s["bear"] += val
    return dict(by_ticker_day)


def fmt_prem(v):
    if v >= 1_000_000: return f"${v/1_000_000:.1f}M"
    if v >= 1_000: return f"${v/1_000:.0f}K"
    return f"${v:.0f}"


# ─── Pattern: Breakout ───────────────────────────────────────────────
def detect_breakouts(today_flow, history_flow, ohlc):
    """Premium spike + price breaks 5d high."""
    alerts = []
    today_str = datetime.now().date().isoformat()
    for sym, today in today_flow.items():
        if today["total"] < BREAKOUT_MIN_PREMIUM:
            continue
        # 7d avg premium
        days = history_flow.get(sym, {})
        recent_premiums = [v["total"] for d, v in days.items() if d != today_str]
        if len(recent_premiums) < 3:
            continue
        avg_prem = sum(recent_premiums) / len(recent_premiums)
        if avg_prem == 0:
            continue
        mult = today["total"] / avg_prem
        if mult < BREAKOUT_PREMIUM_MULT:
            continue
        # OHLC check
        hist = ohlc.get_history(sym, days=10)
        if not hist or len(hist) < 6:
            continue
        last_5 = hist[-6:-1]  # exclude today
        five_d_high = max(d["high"] for d in last_5)
        quote = ohlc.get_quote(sym)
        if not quote or quote["last"] <= 0:
            continue
        if quote["last"] <= five_d_high:
            continue
        bull_pct = (today["bull"] / today["total"] * 100) if today["total"] > 0 else 50
        confidence = "HIGH" if (mult >= 5 and bull_pct >= 70) else "MEDIUM"
        alerts.append({
            "pattern": "BREAKOUT",
            "ticker": sym,
            "confidence": confidence,
            "metrics": {
                "today_premium": today["total"],
                "avg_premium": avg_prem,
                "multiplier": mult,
                "five_d_high": five_d_high,
                "current_price": quote["last"],
                "bull_pct": bull_pct,
            },
            "summary": (
                f"Premium today: {fmt_prem(today['total'])} ({mult:.1f}x 7d avg)\n"
                f"Price: ${quote['last']:.2f} → broke 5d high of ${five_d_high:.2f} ✓\n"
                f"Flow direction: {bull_pct:.0f}% bullish"
            ),
        })
    return alerts


# ─── Pattern: Gap-and-Go ─────────────────────────────────────────────
def detect_gap_and_go(today_flow, ohlc):
    """Gap >2% + first-hour bull premium >$500K + holding above gap."""
    alerts = []
    market_open_ts = datetime.now().replace(hour=9, minute=30, second=0, microsecond=0).timestamp()
    first_hour_end = market_open_ts + 3600
    for sym, today in today_flow.items():
        if today["total"] < GAP_FIRST_HOUR_PREM: continue
        quote = ohlc.get_quote(sym)
        if not quote or quote["prev_close"] <= 0 or quote["open"] <= 0:
            continue
        gap_pct = ((quote["open"] - quote["prev_close"]) / quote["prev_close"]) * 100
        if abs(gap_pct) < GAP_PCT_MIN:
            continue
        # First-hour bull/bear flow
        first_hour_bull = sum(f["val"] for f in today["fills"]
                              if f["bull"] and market_open_ts <= f["ts"] <= first_hour_end)
        first_hour_bear = sum(f["val"] for f in today["fills"]
                              if not f["bull"] and market_open_ts <= f["ts"] <= first_hour_end)
        # Direction must match gap
        direction_ok = (gap_pct > 0 and first_hour_bull >= GAP_FIRST_HOUR_PREM) or \
                       (gap_pct < 0 and first_hour_bear >= GAP_FIRST_HOUR_PREM)
        if not direction_ok:
            continue
        # Still holding above/below gap?
        if gap_pct > 0:
            holding = quote["last"] >= quote["open"] * 0.99
        else:
            holding = quote["last"] <= quote["open"] * 1.01
        confidence = "HIGH" if holding else "MEDIUM"
        direction = "UP" if gap_pct > 0 else "DOWN"
        first_hour_prem = first_hour_bull if gap_pct > 0 else first_hour_bear
        alerts.append({
            "pattern": "GAP_AND_GO",
            "ticker": sym,
            "confidence": confidence,
            "metrics": {
                "gap_pct": gap_pct,
                "open": quote["open"],
                "prev_close": quote["prev_close"],
                "current": quote["last"],
                "first_hour_premium": first_hour_prem,
                "holding": holding,
            },
            "summary": (
                f"Open: ${quote['open']:.2f} ({gap_pct:+.1f}% gap from ${quote['prev_close']:.2f} close)\n"
                f"First hour premium: {fmt_prem(first_hour_prem)} ({direction}-side)\n"
                f"Status: {'holding above gap' if holding else 'fading'}"
            ),
        })
    return alerts


# ─── Pattern: Flag continuation ──────────────────────────────────────
def detect_flag(today_flow, history_flow, ohlc):
    """3+ days of bullish flow → 1-2d price consolidation → premium re-accelerating."""
    alerts = []
    today_str = datetime.now().date().isoformat()
    for sym, today in today_flow.items():
        if today["total"] < BREAKOUT_MIN_PREMIUM:
            continue
        days = history_flow.get(sym, {})
        if len(days) < FLAG_BULL_DAYS + 2:
            continue
        sorted_days = sorted(days.items())
        # Look at days N-4 through N-2 (the bull leg) and N-1 through today (consolidation + restart)
        bull_leg_days = sorted_days[-(FLAG_BULL_DAYS + 2):-2]
        bull_leg_total = sum(d[1]["total"] for d in bull_leg_days)
        bull_leg_bull = sum(d[1]["bull"] for d in bull_leg_days)
        if bull_leg_total == 0: continue
        bull_pct_leg = (bull_leg_bull / bull_leg_total) * 100
        if bull_pct_leg < 60:  # need majority bull
            continue
        # Price consolidation check
        hist = ohlc.get_history(sym, days=10)
        if not hist or len(hist) < 4:
            continue
        consol_days = hist[-3:-1]  # last 2 days before today
        consol_high = max(d["high"] for d in consol_days)
        consol_low = min(d["low"] for d in consol_days)
        if consol_high <= 0: continue
        consol_range_pct = ((consol_high - consol_low) / consol_low) * 100
        if consol_range_pct > FLAG_CONSOL_PCT:
            continue
        # Today's premium re-accelerating
        if today["total"] < bull_leg_total / FLAG_BULL_DAYS * 0.7:
            continue  # not even average pace
        bull_pct_today = (today["bull"] / today["total"] * 100) if today["total"] > 0 else 50
        if bull_pct_today < 60:
            continue
        confidence = "MEDIUM"
        alerts.append({
            "pattern": "FLAG",
            "ticker": sym,
            "confidence": confidence,
            "metrics": {
                "bull_leg_premium": bull_leg_total,
                "bull_leg_pct": bull_pct_leg,
                "consol_range_pct": consol_range_pct,
                "today_premium": today["total"],
                "today_bull_pct": bull_pct_today,
            },
            "summary": (
                f"{FLAG_BULL_DAYS} days of bullish flow ({fmt_prem(bull_leg_total)} total, {bull_pct_leg:.0f}% bull)\n"
                f"Last 2 days: price consolidating in {consol_range_pct:.1f}% range\n"
                f"Today: premium re-accelerating ({fmt_prem(today['total'])}, {bull_pct_today:.0f}% bull)"
            ),
        })
    return alerts


# ─── Pattern: Reversal squeeze ───────────────────────────────────────
def detect_reversal(today_flow):
    """Heavy bear flow flipping to bull (or vice versa) within session."""
    alerts = []
    for sym, today in today_flow.items():
        if today["total"] < MIN_TOTAL_PREM_FOR_REVERSAL: continue
        if not today["fills"]: continue
        # Sort fills by time
        sorted_fills = sorted(today["fills"], key=lambda f: f["ts"])
        if len(sorted_fills) < 10: continue
        # Compare first half vs last half bull%
        mid = len(sorted_fills) // 2
        first_bull = sum(f["val"] for f in sorted_fills[:mid] if f["bull"])
        first_bear = sum(f["val"] for f in sorted_fills[:mid] if not f["bull"])
        last_bull = sum(f["val"] for f in sorted_fills[mid:] if f["bull"])
        last_bear = sum(f["val"] for f in sorted_fills[mid:] if not f["bull"])
        first_total = first_bull + first_bear
        last_total = last_bull + last_bear
        if first_total == 0 or last_total == 0: continue
        first_bull_pct = (first_bull / first_total) * 100
        last_bull_pct = (last_bull / last_total) * 100
        flip = abs(last_bull_pct - first_bull_pct)
        if flip < REVERSAL_FLIP_PCT: continue
        direction = "BULLISH" if last_bull_pct > first_bull_pct else "BEARISH"
        confidence = "MEDIUM"
        if flip >= 50 and last_total >= 1_500_000:
            confidence = "HIGH"
        alerts.append({
            "pattern": "REVERSAL",
            "ticker": sym,
            "confidence": confidence,
            "metrics": {
                "first_half_bull_pct": first_bull_pct,
                "last_half_bull_pct": last_bull_pct,
                "flip_magnitude": flip,
                "total_premium": today["total"],
                "direction": direction,
            },
            "summary": (
                f"Earlier: {first_bull_pct:.0f}% bull → Now: {last_bull_pct:.0f}% bull\n"
                f"Flip magnitude: {flip:.0f}pts ({direction})\n"
                f"Total premium today: {fmt_prem(today['total'])}"
            ),
        })
    return alerts


def detect_all(ohlc_provider):
    """Run all 4 detectors and return combined alert list."""
    today_flow = aggregate_flow_today()
    history_flow = aggregate_flow_history(lookback_days=8)
    if not today_flow:
        return []
    alerts = []
    alerts.extend(detect_breakouts(today_flow, history_flow, ohlc_provider))
    alerts.extend(detect_gap_and_go(today_flow, ohlc_provider))
    alerts.extend(detect_flag(today_flow, history_flow, ohlc_provider))
    alerts.extend(detect_reversal(today_flow))
    return alerts
