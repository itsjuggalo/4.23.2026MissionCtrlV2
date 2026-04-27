#!/usr/bin/env python3
"""Sentiment alert bot. Watches relay state for sentiment threshold crossings.
Runs every 5 min via cron. Fires Discord alerts on extreme readings & regime shifts.
"""
import json, os, sys, time, logging
from datetime import datetime, timezone
from pathlib import Path
import requests

SECRETS = Path.home() / ".openclaw" / "secrets"
WEBHOOK = (SECRETS / "discord_sentiment_alerts_webhook").read_text().strip()
RELAY_DIR = Path.home() / "mission-control-restored" / "Option-Signals-Scraper"
DATA_DIR = RELAY_DIR / "data"
RELAY_STATE = RELAY_DIR / "sent_ids.json"

ALERTS_DIR = Path.home() / ".openclaw" / "workspace"
ALERTS_DIR.mkdir(parents=True, exist_ok=True)
ALERT_STATE = ALERTS_DIR / "sentiment_alerts_state.json"

LOG_DIR = Path.home() / ".openclaw" / "workspace" / "logs"
LOG_DIR.mkdir(parents=True, exist_ok=True)
logging.basicConfig(
    filename=LOG_DIR / "sentiment_alerts.log",
    level=logging.INFO,
    format="%(asctime)s %(levelname)s %(message)s"
)

# Thresholds
EXTREME_BULL = 75
EXTREME_BEAR = 25
SHIFT_THRESHOLD = 20  # %point swing in 1hr
WHALE_PREMIUM = 2_000_000
WHALE_DIRECTIONAL = 85  # %
COOLDOWN_SECS = 30 * 60  # don't re-fire same alert within 30 min


def fmt_prem(v):
    if v >= 1_000_000: return f"${v/1_000_000:.1f}M"
    if v >= 1_000: return f"${v/1_000:.0f}K"
    return f"${v:.0f}"


def load_alert_state():
    if not ALERT_STATE.exists():
        return {"fired": {}, "history": []}
    try:
        return json.loads(ALERT_STATE.read_text())
    except Exception:
        return {"fired": {}, "history": []}


def save_alert_state(s):
    tmp = str(ALERT_STATE) + ".tmp"
    with open(tmp, "w") as f: json.dump(s, f, indent=2)
    os.replace(tmp, ALERT_STATE)


def post_alert(title, description, color, fields=None):
    embed = {
        "title": title,
        "description": description,
        "color": color,
        "timestamp": datetime.now(timezone.utc).isoformat(),
        "footer": {"text": f"Sentiment Watch • {datetime.now().strftime('%-I:%M %p ET')}"},
    }
    if fields:
        embed["fields"] = fields
    try:
        r = requests.post(WEBHOOK, json={"embeds": [embed]}, timeout=10)
        if r.status_code in (200, 204):
            logging.info(f"posted alert: {title}")
            return True
        logging.error(f"webhook {r.status_code}: {r.text[:200]}")
        return False
    except Exception as e:
        logging.error(f"post failed: {e}")
        return False


def can_fire(state, key):
    """Check cooldown — same alert can't fire twice within COOLDOWN_SECS."""
    last = state["fired"].get(key, 0)
    return (time.time() - last) >= COOLDOWN_SECS


def mark_fired(state, key):
    state["fired"][key] = int(time.time())
    state.setdefault("history", []).append({
        "ts": int(time.time()),
        "alert": key,
    })
    state["history"] = state["history"][-200:]


def compute_synth_overall():
    """Read raw flow data, compute current overall %bull (independent of relay's snapshot timing)."""
    p = DATA_DIR / "flow_liveflows_today.json"
    if not p.exists():
        p = DATA_DIR / "flow_live_last100.json"
    if not p.exists():
        return None, {}
    try:
        d = json.loads(p.read_text())
    except Exception:
        return None, {}

    ticker = {}
    total_bull, total_bear = 0.0, 0.0
    for entry in d.values():
        if not isinstance(entry, dict): continue
        sym = entry.get("Symbol", "")
        if not sym: continue
        opt = entry.get("OptionType", "")
        ba = entry.get("BidAskType", "")
        val = float(entry.get("Value", 0) or 0)
        if val <= 0: continue
        is_bull = (opt == "CALL" and ba == "A") or (opt == "PUT" and ba == "B")
        is_bear = (opt == "CALL" and ba == "B") or (opt == "PUT" and ba == "A")
        if not (is_bull or is_bear): continue
        s = ticker.setdefault(sym, {"bull": 0.0, "bear": 0.0, "total": 0.0})
        if is_bull:
            s["bull"] += val; total_bull += val
        else:
            s["bear"] += val; total_bear += val
        s["total"] += val
    overall = (total_bull / (total_bull + total_bear) * 100) if (total_bull + total_bear) > 0 else None
    return overall, ticker


def check_extreme(state, overall):
    if overall is None:
        return
    if overall >= EXTREME_BULL and can_fire(state, "extreme_bull"):
        post_alert(
            "🚨 EXTREME BULLISH SENTIMENT",
            f"Overall flow is **{overall:.0f}% bullish** — extreme reading (threshold ≥{EXTREME_BULL}%).\nOften precedes near-term rip OR fades on exhaustion.",
            0x00b894,
        )
        mark_fired(state, "extreme_bull")
        state["fired"].pop("extreme_bear", None)  # invalidate opposite cooldown
    elif overall <= EXTREME_BEAR and can_fire(state, "extreme_bear"):
        post_alert(
            "🚨 EXTREME BEARISH SENTIMENT",
            f"Overall flow is **{overall:.0f}% bullish** ({100-overall:.0f}% bearish) — capitulation reading (threshold ≤{EXTREME_BEAR}%).\nOften precedes bounce OR confirms further breakdown.",
            0xd63031,
        )
        mark_fired(state, "extreme_bear")
        state["fired"].pop("extreme_bull", None)


def check_shift(state, overall):
    """Check if sentiment shifted >SHIFT_THRESHOLD in ~1 hour."""
    if overall is None:
        return
    history = state.setdefault("synth_log", [])
    history.append({"ts": int(time.time()), "pct": overall})
    history[:] = [h for h in history if time.time() - h["ts"] < 90 * 60]  # keep 90 min
    state["synth_log"] = history

    # Compare to ~1hr ago
    target_ts = time.time() - 3600
    closest = min(history, key=lambda h: abs(h["ts"] - target_ts), default=None)
    if not closest or abs(closest["ts"] - target_ts) > 1800:  # need within 30 min of target
        return
    delta = overall - closest["pct"]
    if abs(delta) < SHIFT_THRESHOLD:
        return
    if not can_fire(state, "shift"):
        return
    direction = "BULLISH" if delta > 0 else "BEARISH"
    color = 0xfdcb6e
    post_alert(
        f"⚡ REGIME SHIFT — {direction}",
        f"Sentiment moved **{delta:+.0f}%** in the last hour.\n"
        f"1h ago: {closest['pct']:.0f}% bull → now: {overall:.0f}% bull",
        color,
    )
    mark_fired(state, "shift")


def check_whales(state, ticker):
    """Find any ticker with >$WHALE_PREMIUM and >WHALE_DIRECTIONAL% one-sided."""
    whales = []
    for sym, s in ticker.items():
        if s["total"] < WHALE_PREMIUM:
            continue
        bull_pct = (s["bull"] / s["total"] * 100) if s["total"] > 0 else 50
        if bull_pct >= WHALE_DIRECTIONAL:
            whales.append((sym, s, bull_pct, "BULL"))
        elif bull_pct <= (100 - WHALE_DIRECTIONAL):
            whales.append((sym, s, bull_pct, "BEAR"))

    for sym, s, bull_pct, direction in whales:
        key = f"whale_{sym}_{direction}"
        if not can_fire(state, key):
            continue
        emoji = "🟢" if direction == "BULL" else "🔴"
        post_alert(
            f"🔥 WHALE FLOW: {emoji} {sym}",
            f"**${sym}** has **{fmt_prem(s['total'])}** in flow today, **{bull_pct:.0f}% directional ({direction})**.\n"
            f"Bull: {fmt_prem(s['bull'])} • Bear: {fmt_prem(s['bear'])}",
            0xff7675 if direction == "BEAR" else 0x55efc4,
        )
        mark_fired(state, key)


def main():
    state = load_alert_state()
    overall, ticker = compute_synth_overall()
    if overall is None:
        logging.info("no flow data, skipping")
        save_alert_state(state)
        return
    logging.info(f"overall={overall:.1f}% n_tickers={len(ticker)}")
    check_extreme(state, overall)
    check_shift(state, overall)
    check_whales(state, ticker)
    save_alert_state(state)


if __name__ == "__main__":
    main()
