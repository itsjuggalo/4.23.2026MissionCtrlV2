#!/usr/bin/env python3
"""Best Options of the Day logger — polls Firebase /FlowGreeks2/Alerts/today."""
import json, sys
from datetime import datetime, timezone, timedelta
from pathlib import Path
import requests

FIREBASE_URL = "https://stock-signal-72772-default-rtdb.firebaseio.com/FlowGreeks2/Alerts/today.json"
DATA_DIR = Path.home() / ".openclaw" / "data" / "best-options"
DATA_DIR.mkdir(parents=True, exist_ok=True)

def et_now():
    # EDT (-4); if you need EST swap to -5
    return datetime.now(timezone.utc) + timedelta(hours=-4)

def et_today_str():
    return et_now().strftime("%Y-%m-%d")

def classify_tier(a):
    v = a.get("totalFlowValue", 0); sw = a.get("SWEEPS", 0)
    vol = a.get("Volume", 0); oi = a.get("OI", 0)
    vol_gt_oi = (volume := vol) > oi if oi > 0 else vol > 0
    if v >= 1_000_000 and sw > 0 and vol_gt_oi: return "T1_HUGE"
    if v >= 500_000 and sw > 0 and vol_gt_oi: return "T2_UNUSUAL_HUGE"
    if vol_gt_oi: return "T3_UNUSUAL"
    return "NORMAL"

def normalize(sym, wrapper):
    a = wrapper.get("alert", {}) if isinstance(wrapper, dict) else {}
    if not a: return None
    t_ms = a.get("Time", 0); exp_s = a.get("Expiry", 0)
    try:
        exp_iso = datetime.fromtimestamp(exp_s, timezone.utc).strftime("%Y-%m-%d") if exp_s else None
    except Exception:
        exp_iso = None
    return {
        "option_symbol": sym, "ticker": a.get("Symbol", "?"),
        "strike": a.get("Strike", 0), "option_type": a.get("OptionType", "?"),
        "expiry": exp_iso, "dte": a.get("DTE", 0),
        "premium": int(a.get("totalFlowValue", 0)),
        "volume": int(a.get("Volume", 0)), "oi": int(a.get("OI", 0)),
        "sweeps": int(a.get("SWEEPS", 0)), "blocks": int(a.get("BLOCKS", 0)),
        "alert_price": float(a.get("AlertPrice", 0)),
        "spot": float(a.get("Spot", 0)),
        "is_bullish": bool(a.get("isBullish", False)),
        "alert_type": a.get("AlertType", "?"),
        "trade_count": int(a.get("trade_count", 0)),
        "total_flow_count": int(a.get("totalFlowCount", 0)),
        "first_seen_ms": t_ms,
        "last_updated_ms": int(a.get("Updated", 0)),
        "tier": classify_tier(a),
    }

def run_once():
    date_str = et_today_str()
    print(f"[best-options] Run at {et_now().strftime('%I:%M %p ET')} for {date_str}", flush=True)
    try:
        r = requests.get(FIREBASE_URL, timeout=15); r.raise_for_status()
        raw = r.json() or {}
    except Exception as e:
        print(f"[best-options] Fetch failed: {e}", flush=True); return
    new_alerts = {}
    for sym, w in raw.items():
        n = normalize(sym, w)
        if n and n["premium"] > 0: new_alerts[sym] = n
    print(f"[best-options] {len(raw)} raw → {len(new_alerts)} valid", flush=True)

    # Merge with existing day snapshot, keep highest-premium occurrence
    p = DATA_DIR / f"{date_str}.json"
    snap = {"date": date_str, "contracts": {}}
    if p.exists():
        try: snap = json.loads(p.read_text())
        except: pass
    contracts = snap.get("contracts", {})
    n_new, n_up = 0, 0
    for sym, a in new_alerts.items():
        if sym not in contracts: contracts[sym] = a; n_new += 1
        elif a["premium"] > contracts[sym].get("premium", 0): contracts[sym] = a; n_up += 1

    sorted_list = sorted(contracts.values(), key=lambda x: x["premium"], reverse=True)
    snap["contracts"] = contracts
    snap["sorted_by_premium"] = sorted_list[:200]
    snap["total_contracts"] = len(contracts)
    snap["tier_counts"] = {t: sum(1 for c in contracts.values() if c["tier"] == t)
                           for t in ("T1_HUGE","T2_UNUSUAL_HUGE","T3_UNUSUAL","NORMAL")}
    snap["highest_premium"] = sorted_list[0] if sorted_list else None
    snap["last_run_at"] = et_now().isoformat()
    snap["last_run_human"] = et_now().strftime("%Y-%m-%d %I:%M %p ET")
    p.write_text(json.dumps(snap, indent=2))

    print(f"[best-options] OK: {len(contracts)} contracts ({n_new} new, {n_up} replaced w/ higher premium)", flush=True)
    print(f"[best-options] Tiers: T1={snap['tier_counts']['T1_HUGE']} T2={snap['tier_counts']['T2_UNUSUAL_HUGE']} T3={snap['tier_counts']['T3_UNUSUAL']}", flush=True)
    for c in sorted_list[:5]:
        print(f"  ${c['premium']:>10,}  {c['ticker']:5s} ${c['strike']:>6.0f} {c['option_type']:4s} {c['expiry']} | V:{c['volume']:>5} OI:{c['oi']:>5} SW:{c['sweeps']:>2} | {c['tier']}", flush=True)

if __name__ == "__main__":
    run_once()
