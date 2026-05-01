#!/usr/bin/env python3
"""
rule_based_decision_engine — autonomous Python-only trading decision maker.

Reads same data sources as Boba (best-options snapshot, PLATINUM hits, ticker rollup,
multi-day repeaters) but uses a deterministic scoring engine instead of an LLM.

Designed as fallback when Anthropic/OpenAI APIs are unavailable.
Can also run alongside Boba/Jazzy for sanity-checking — its picks are auditable
and explainable (every score component logged).

Scoring algorithm (0-100 per candidate, top score executes):
  Premium tier:        0-30 pts (PLATINUM=30, T0=25, T1=20, T2=15)
  Volume/OI ratio:     0-20 pts (higher = newer institutional positioning)
  Sweep dominance:     0-15 pts (higher = more aggressive buy)
  Repeater bonus:      0-15 pts (same contract appearing 3+ today)
  DTE preference:      0-10 pts (7-30 DTE sweet spot)
  Bid-ask side:        0-5 pts (ASK side = aggressive buyer)
  Ticker concentration: 0-5 pts (single contract scores higher when ticker is heavily one-sided)

Execution threshold: score >= 60 to fire a trade.

Usage:
  python3 rule_based_decision_engine.py             # analyze and print pick
  python3 rule_based_decision_engine.py --execute   # also place trade on Alpaca R2
  python3 rule_based_decision_engine.py --account jazzy  # use JazzyHazzy account
"""
import json, sys, argparse, requests, subprocess
from datetime import datetime, timezone, timedelta
from pathlib import Path
from collections import defaultdict

DATA_DIR = Path.home() / ".openclaw" / "data" / "best-options"
SECRETS = Path.home() / ".openclaw" / "secrets"
LOG_DIR = Path.home() / ".openclaw" / "workspace" / "memory"
LOG_DIR.mkdir(parents=True, exist_ok=True)
LOG_FILE = LOG_DIR / "rule_engine_decisions.jsonl"

ALPACA_BASE = "https://paper-api.alpaca.markets/v2"
EXEC_THRESHOLD = 60   # min score to execute
MAX_PICKS_PER_RUN = 1
HEADERS_DISCORD = {"Content-Type": "application/json", "User-Agent": "MissionControl-RuleEngine/1.0"}

def et_now():
    return datetime.now(timezone.utc) + timedelta(hours=-4)

def log(action, detail):
    e = {"ts": datetime.now(timezone.utc).isoformat(), "action": action, "detail": detail}
    with LOG_FILE.open("a") as f:
        f.write(json.dumps(e) + "\n")
    print(f"[rule-engine] {action}: {str(detail)[:300]}", flush=True)

def post_discord(content):
    try:
        url = (SECRETS / "discord_rule_engine_webhook").read_text().strip()
        requests.post(url, headers=HEADERS_DISCORD, json={"content": content[:1900]}, timeout=10)
    except Exception:
        pass

def load_today_snapshot():
    fp = DATA_DIR / f"{et_now().strftime('%Y-%m-%d')}.json"
    if not fp.exists():
        return None
    try:
        return json.loads(fp.read_text())
    except Exception:
        return None

def get_existing_positions_by_ticker(account="r2"):
    """Return set of tickers we already have exposure to (stock OR options)."""
    try:
        if account == "r2":
            key = (SECRETS / "alpaca-key-id").read_text().strip()
            sec = (SECRETS / "alpaca-secret").read_text().strip()
        else:
            key = (SECRETS / "alpaca-jazzy-key-id").read_text().strip()
            sec = (SECRETS / "alpaca-jazzy-secret").read_text().strip()
        H = {"APCA-API-KEY-ID": key, "APCA-API-SECRET-KEY": sec}
        r = requests.get(f"{ALPACA_BASE}/positions", headers=H, timeout=10)
        if r.status_code != 200:
            return set()
        positions = r.json() or []
        tickers = set()
        for p in positions:
            sym = p.get("symbol", "")
            # Option symbols start with ticker (e.g. TSLA260501C00390000)
            # Stock symbols are just the ticker
            # Extract underlying ticker
            import re
            m = re.match(r"^([A-Z]+)\d{6}[CP]\d+$", sym)
            if m:
                tickers.add(m.group(1))
            else:
                tickers.add(sym)
        return tickers
    except Exception as e:
        log("position_check_fail", str(e))
        return set()


def is_platinum(c):
    if c.get("premium", 0) < 10_000_000: return False
    vol = c.get("volume", 0); oi = c.get("oi", 0)
    sw = c.get("sweeps", 0); bl = c.get("blocks", 0)
    tx = sw + bl; dte = c.get("dte", 0)
    vol_ok = (vol >= 5*oi) if oi > 0 else (vol >= 500)
    sw_ok = (sw / tx >= 0.80) if tx > 0 else False
    dte_ok = dte <= 14 or dte >= 180
    return vol_ok and sw_ok and dte_ok

def score_candidate(c, repeater_counts, ticker_totals):
    """Return (score, breakdown_dict)"""
    score = 0
    bd = {}
    # 1. Premium tier (0-30)
    prem = c.get("premium", 0)
    if is_platinum(c): tier_pts = 30; tier_label = "PLATINUM"
    elif prem >= 10_000_000: tier_pts = 25; tier_label = "T0_MEGA"
    elif prem >= 5_000_000: tier_pts = 20; tier_label = "T1_HUGE"
    elif prem >= 1_000_000: tier_pts = 15; tier_label = "T2_BIG"
    else: tier_pts = 0; tier_label = "BELOW_FLOOR"
    score += tier_pts
    bd["tier"] = (tier_label, tier_pts)
    # 2. Volume/OI ratio (0-20)
    vol = c.get("volume", 0); oi = c.get("oi", 0)
    if oi > 0:
        ratio = vol / oi
        if ratio >= 10: vio_pts = 20
        elif ratio >= 5: vio_pts = 15
        elif ratio >= 3: vio_pts = 10
        elif ratio >= 1.5: vio_pts = 5
        else: vio_pts = 0
        ratio_str = f"{ratio:.1f}x"
    else:
        # OI=0 with significant volume = fresh positioning
        vio_pts = 15 if vol >= 500 else 5
        ratio_str = "OI=0"
    score += vio_pts
    bd["vol_oi"] = (ratio_str, vio_pts)
    # 3. Sweep dominance (0-15)
    sw = c.get("sweeps", 0); bl = c.get("blocks", 0); tx = sw + bl
    if tx > 0:
        sw_pct = sw / tx
        if sw_pct >= 0.90: sw_pts = 15
        elif sw_pct >= 0.75: sw_pts = 12
        elif sw_pct >= 0.60: sw_pts = 8
        elif sw_pct >= 0.40: sw_pts = 4
        else: sw_pts = 0
    else:
        sw_pts = 0
        sw_pct = 0
    score += sw_pts
    bd["sweep_dom"] = (f"{int(sw_pct*100)}%", sw_pts)
    # 4. Repeater bonus (0-15)
    sym = c.get("option_symbol", "")
    repeats = repeater_counts.get(sym, 1)
    if repeats >= 5: rep_pts = 15
    elif repeats >= 3: rep_pts = 10
    elif repeats >= 2: rep_pts = 5
    else: rep_pts = 0
    score += rep_pts
    bd["repeater"] = (f"{repeats}x", rep_pts)
    # 5. DTE preference (0-10)
    dte = c.get("dte", 0)
    if 7 <= dte <= 30: dte_pts = 10
    elif 30 < dte <= 60: dte_pts = 7
    elif 60 < dte <= 180: dte_pts = 5
    elif 1 <= dte < 7: dte_pts = 3
    elif dte == 0: dte_pts = 1   # 0DTE is risky for swing
    else: dte_pts = 4   # >180 DTE leaps
    score += dte_pts
    bd["dte"] = (f"{dte}d", dte_pts)
    # 6. Bid-ask side already in tier classification, give 5 if T1/T2 (means SWEEP on ASK was required)
    ba_pts = 5 if c.get("tier") in ("T1_HUGE", "T2_UNUSUAL_HUGE") else 0
    score += ba_pts
    bd["bid_ask"] = ("ASK_aggressive" if ba_pts else "neutral", ba_pts)
    # 7. Ticker concentration (0-5) — is this contract on a heavily one-sided ticker?
    ticker = c.get("ticker", "?")
    is_call = c.get("option_type", "?").upper().startswith("C")
    tt = ticker_totals.get(ticker, {"call": 0, "put": 0})
    total = tt["call"] + tt["put"]
    if total > 0:
        same_side_pct = (tt["call"] if is_call else tt["put"]) / total
        if same_side_pct >= 0.85: conc_pts = 5
        elif same_side_pct >= 0.70: conc_pts = 3
        elif same_side_pct >= 0.55: conc_pts = 1
        else: conc_pts = 0
    else:
        conc_pts = 0
    score += conc_pts
    bd["concentration"] = (f"{int(same_side_pct*100)}%" if total else "n/a", conc_pts)
    return score, bd

def analyze(snap):
    contracts = snap.get("sorted_by_premium", []) or []
    if not contracts:
        return None, []
    # Build repeater counts from contract symbol
    repeater_counts = defaultdict(int)
    ticker_totals = defaultdict(lambda: {"call": 0, "put": 0})
    for c in contracts:
        sym = c.get("option_symbol", "")
        repeater_counts[sym] = max(repeater_counts.get(sym, 0), c.get("total_flow_count", 1))
        t = c.get("ticker", "?")
        prem = c.get("premium", 0)
        if c.get("option_type", "?").upper().startswith("C"):
            ticker_totals[t]["call"] += prem
        else:
            ticker_totals[t]["put"] += prem
    # Score every candidate
    scored = []
    for c in contracts:
        if c.get("premium", 0) < 1_000_000: continue   # T1+ floor
        s, bd = score_candidate(c, repeater_counts, ticker_totals)
        scored.append((s, bd, c))
    scored.sort(key=lambda x: -x[0])
    return scored[0] if scored else None, scored[:10]

def determine_targets(score, c):
    """Set TP/SL based on score + tier"""
    if is_platinum(c):
        return 60, 20   # PLATINUM
    prem = c.get("premium", 0)
    if prem >= 10_000_000:
        return 80, 15   # T0
    if prem >= 5_000_000:
        return 60, 20   # T1 HUGE
    if score >= 75:
        return 50, 25   # high-confidence T2
    return 40, 30       # standard T2

def execute_pick(c, tp_pct, sl_pct, account="r2"):
    """Place buy + protective SL + TP on Alpaca."""
    if account == "r2":
        key = (SECRETS / "alpaca-key-id").read_text().strip()
        sec = (SECRETS / "alpaca-secret").read_text().strip()
    else:
        key = (SECRETS / "alpaca-jazzy-key-id").read_text().strip()
        sec = (SECRETS / "alpaca-jazzy-secret").read_text().strip()
    H = {"APCA-API-KEY-ID": key, "APCA-API-SECRET-KEY": sec, "Content-Type": "application/json"}
    sym = c["option_symbol"]
    qty = 1   # rule engine plays small
    # 1. Pre-flight cleanup (consistent with Boba)
    try:
        r = requests.get(f"{ALPACA_BASE}/orders?status=open&symbols={sym}&limit=10", headers=H, timeout=10)
        for o in (r.json() or []):
            if o.get("side") == "sell":
                requests.delete(f"{ALPACA_BASE}/orders/{o.get('id')}", headers=H, timeout=10)
    except Exception:
        pass
    # 2. Buy market order
    buy = {"symbol": sym, "qty": str(qty), "side": "buy", "type": "market", "time_in_force": "day"}
    br = requests.post(f"{ALPACA_BASE}/orders", headers=H, json=buy, timeout=15)
    if br.status_code not in (200, 201):
        log("buy_fail", f"{sym} HTTP {br.status_code}: {br.text[:200]}")
        return False
    buy_id = br.json().get("id")
    # 3. Poll for fill (10 sec)
    fill = None
    import time as _t
    for _ in range(20):
        _t.sleep(0.5)
        pr = requests.get(f"{ALPACA_BASE}/orders/{buy_id}", headers=H, timeout=5)
        if pr.status_code == 200 and pr.json().get("status") == "filled":
            fill = float(pr.json().get("filled_avg_price", 0))
            break
    if not fill:
        log("buy_no_fill", sym)
        return False
    # 4. Place SL + TP separately (no OCO on options)
    stop_t = round(max(fill * (1 - sl_pct/100), 0.01), 2)
    stop_l = round(max(stop_t * 0.90, 0.01), 2)
    tp_p = round(max(fill * (1 + tp_pct/100), 0.01), 2)
    sl_body = {"symbol": sym, "qty": str(qty), "side": "sell", "position_intent": "sell_to_close",
        "type": "stop_limit", "time_in_force": "gtc",
        "stop_price": str(stop_t), "limit_price": str(stop_l)}
    tp_body = {"symbol": sym, "qty": str(qty), "side": "sell", "position_intent": "sell_to_close",
        "type": "limit", "time_in_force": "gtc", "limit_price": str(tp_p)}
    requests.post(f"{ALPACA_BASE}/orders", headers=H, json=sl_body, timeout=10)
    requests.post(f"{ALPACA_BASE}/orders", headers=H, json=tp_body, timeout=10)
    log("filled", f"{sym} @ ${fill:.2f} TP ${tp_p:.2f} SL ${stop_t:.2f}")
    return True

def format_decision(top, all_scored):
    score, bd, c = top
    sym = c.get("option_symbol", "?")
    ticker = c.get("ticker", "?")
    strike = c.get("strike", 0)
    side = "C" if c.get("option_type", "?").upper().startswith("C") else "P"
    expiry = c.get("expiry", "?")
    dte = c.get("dte", 0)
    prem = c.get("premium", 0)
    bull = "🟢 BULL" if c.get("is_bullish") else "🔴 BEAR"
    decision = "EXECUTE" if score >= EXEC_THRESHOLD else "HOLD"
    msg = [f"🤖 **RULE ENGINE pick** — Score: **{score}/100** → {decision}"]
    msg.append(f"**{ticker} ${strike:.0f}{side} {expiry}** ({dte}d) {bull}")
    msg.append(f"Premium: **${prem/1_000_000:.1f}M**")
    msg.append(f"Score breakdown:")
    for k, (val, pts) in bd.items():
        msg.append(f"  • {k}: {val} → {pts}pts")
    if all_scored and len(all_scored) > 1:
        msg.append(f"\nNext 3 candidates:")
        for s, _, cc in all_scored[1:4]:
            msg.append(f"  {s}/100  {cc.get('ticker')} ${cc.get('strike',0):.0f}{cc.get('option_type','?')[0]} ${cc.get('premium',0)/1_000_000:.1f}M")
    return "\n".join(msg)

def main():
    parser = argparse.ArgumentParser()
    parser.add_argument("--execute", action="store_true", help="actually place trade")
    parser.add_argument("--account", default="r2", choices=["r2", "jazzy"])
    parser.add_argument("--quiet", action="store_true")
    args = parser.parse_args()

    log("startup", f"rule_based_decision_engine ET={et_now().strftime('%Y-%m-%d %H:%M')} account={args.account} execute={args.execute}")
    snap = load_today_snapshot()
    if not snap:
        log("no_snapshot", f"no data for {et_now().strftime('%Y-%m-%d')}")
        return
    held_tickers = get_existing_positions_by_ticker(args.account)
    if held_tickers:
        log("held_tickers", f"{','.join(sorted(held_tickers))}")
    top, all_scored = analyze(snap)
    # Filter out picks where we already have exposure
    if held_tickers:
        all_scored_filtered = [(s, bd, c) for s, bd, c in all_scored if c.get("ticker") not in held_tickers]
        if not all_scored_filtered:
            log("all_filtered", f"all candidates skipped due to existing positions in {held_tickers}")
            top = None
        else:
            removed = len(all_scored) - len(all_scored_filtered)
            if removed > 0:
                log("filtered_held", f"removed {removed} candidates already held")
            top = all_scored_filtered[0]
            all_scored = all_scored_filtered
    if not top:
        log("no_candidates", "no T1+ contracts after position filter")
        return
    score, bd, c = top
    decision_msg = format_decision(top, all_scored)
    if not args.quiet:
        print("\n" + decision_msg + "\n")
    log("top_pick", f"{c.get('ticker')} ${c.get('strike',0):.0f}{c.get('option_type','?')[0]} score={score}")
    if score < EXEC_THRESHOLD:
        log("hold", f"score {score} below threshold {EXEC_THRESHOLD}")
        post_discord("🤖 **Rule Engine** — top pick scored below threshold, holding.\n\n" + decision_msg)
        return
    if not args.execute:
        log("dry_run", f"score {score} would execute but --execute not set")
        post_discord("🤖 **Rule Engine DRY-RUN** — would execute:\n\n" + decision_msg)
        return
    tp, sl = determine_targets(score, c)
    log("executing", f"{c.get('option_symbol')} TP {tp}% SL {sl}%")
    ok = execute_pick(c, tp, sl, account=args.account)
    if ok:
        post_discord(f"🤖✅ **Rule Engine EXECUTED** ({args.account}, TP +{tp}% SL -{sl}%)\n\n" + decision_msg)
    else:
        post_discord("🤖❌ **Rule Engine FAILED to execute**\n\n" + decision_msg)

if __name__ == "__main__":
    main()
