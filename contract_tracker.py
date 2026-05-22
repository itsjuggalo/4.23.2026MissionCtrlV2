#!/usr/bin/env python3
"""contract-tracker: monitors all flow-pinger-signaled OCCs through expiration.
Polls Tradier every 60s, posts DIP/RUNNING/DEAD alerts to #beta-options via BetaBot."""
import json, sys, time, glob, requests, traceback
from datetime import datetime, timezone, timedelta
from pathlib import Path

POLL_INTERVAL_SEC = 60
DTE_MAX_TRACK = 60
DIP_PCT = -10.0
RUNNING_PCT = 20.0
DEAD_PCT = -50.0
SECRETS = Path("/home/ubuntu/.openclaw/secrets")
PINGER_STATE = Path("/home/ubuntu/.openclaw/state/flow_pinger_state.json")
TRACKER_STATE = Path("/home/ubuntu/.openclaw/state/contract_tracker_state.json")
BEST_OPTIONS_DIR = Path("/home/ubuntu/.openclaw/data/best-options")
BETABOT_TOKEN_FILE = SECRETS / "betabot-token"
BETABOT_CHANNEL_ID = "1501337917539356703"
TRADIER_TOKEN_FILE = SECRETS / "tradier-sandbox-key"
ET = timezone(timedelta(hours=-4))

def log(action, msg):
    print(f"[contract-tracker] {action}: {msg}", flush=True)

def load_state():
    try: return json.loads(TRACKER_STATE.read_text())
    except Exception: return {"contracts": {}}

def save_state(s):
    TRACKER_STATE.write_text(json.dumps(s, indent=2, default=str))

def get_pinger_occs():
    try:
        d = json.loads(PINGER_STATE.read_text())
        return list(d.get("cooldowns", {}).keys())
    except Exception:
        return []

def get_alert_data(occ):
    """Look up alert_price + meta from most recent best-options file."""
    try:
        files = sorted(glob.glob(str(BEST_OPTIONS_DIR / "*.json")), reverse=True)
        for f in files[:5]:
            d = json.loads(Path(f).read_text())
            c = d.get("contracts", {}).get(occ)
            if c:
                return {
                    "alert_price": float(c.get("alert_price", 0)),
                    "premium": float(c.get("premium", 0)),
                    "ticker": c.get("ticker"),
                    "strike": c.get("strike"),
                    "option_type": c.get("option_type"),
                    "expiry": c.get("expiry"),
                    "dte": c.get("dte", 0),
                    "tier": c.get("tier", "?"),
                }
    except Exception as e:
        log("alert_lookup_fail", f"{occ}: {e}")
    return None

def fetch_quote(occ):
    try:
        tok = TRADIER_TOKEN_FILE.read_text().strip()
        r = requests.get("https://sandbox.tradier.com/v1/markets/quotes",
            params={"symbols": occ, "greeks": "false"},
            headers={"Authorization": f"Bearer {tok}", "Accept": "application/json"},
            timeout=10)
        if r.ok:
            q = r.json().get("quotes", {}).get("quote", {})
            if isinstance(q, list): q = q[0] if q else {}
            bid = float(q.get("bid", 0) or 0)
            ask = float(q.get("ask", 0) or 0)
            mid = (bid + ask) / 2 if (bid and ask) else (q.get("last", 0) or 0)
            return float(mid)
    except Exception as e:
        log("quote_fail", f"{occ}: {e}")
    return None

def post_betabot(content, embed=None):
    try:
        tok = BETABOT_TOKEN_FILE.read_text().strip()
        body = {"content": content}
        if embed: body["embeds"] = [embed]
        r = requests.post(f"https://discord.com/api/v10/channels/{BETABOT_CHANNEL_ID}/messages",
            headers={"Authorization": f"Bot {tok}", "Content-Type": "application/json"},
            json=body, timeout=10)
        if not r.ok: log("post_fail", f"HTTP {r.status_code}: {r.text[:200]}")
    except Exception as e:
        log("post_fail", str(e))

def build_embed(occ, alert, current, hi, lo, alert_type, color):
    pct_now = ((current - alert["alert_price"]) / alert["alert_price"] * 100) if alert["alert_price"] else 0
    pct_hi = ((hi - alert["alert_price"]) / alert["alert_price"] * 100) if alert["alert_price"] else 0
    pct_lo = ((lo - alert["alert_price"]) / alert["alert_price"] * 100) if alert["alert_price"] else 0
    return {
        "title": f"{alert_type}: {alert['ticker']} ${alert['strike']}{(alert.get('option_type','') or '?')[0]} {alert['expiry']}",
        "description": f"`{occ}` | DTE {alert['dte']} | {alert['tier']} | premium ${alert['premium']/1e6:.1f}M",
        "color": color,
        "fields": [
            {"name": "Alert price", "value": f"${alert['alert_price']:.2f}", "inline": True},
            {"name": "Current", "value": f"${current:.2f} ({pct_now:+.1f}%)", "inline": True},
            {"name": "Today H/L", "value": f"H ${hi:.2f} ({pct_hi:+.1f}%) / L ${lo:.2f} ({pct_lo:+.1f}%)", "inline": False},
        ],
        "footer": {"text": "contract-tracker | poll 60s | DIP/RUNNING/DEAD alerts"},
    }

def main():
    log("startup", f"online | poll {POLL_INTERVAL_SEC}s | DTE max {DTE_MAX_TRACK} | DIP {DIP_PCT}% | RUN {RUNNING_PCT}% | DEAD {DEAD_PCT}%")
    state = load_state()
    while True:
        try:
            occs = get_pinger_occs()
            for occ in occs:
                meta = state["contracts"].get(occ)
                if not meta:
                    alert = get_alert_data(occ)
                    if not alert or not alert.get("alert_price"): continue
                    if alert.get("dte", 99) > DTE_MAX_TRACK: continue
                    state["contracts"][occ] = {
                        "alert": alert, "high": alert["alert_price"], "low": alert["alert_price"],
                        "alerts_fired": [], "first_seen": datetime.now(timezone.utc).isoformat(),
                    }
                    meta = state["contracts"][occ]
                    log("tracking", f"new OCC added: {occ}")

                cur = fetch_quote(occ)
                if cur is None or cur <= 0: continue

                ap = meta["alert"]["alert_price"]
                pct = ((cur - ap) / ap * 100) if ap else 0
                hit_new_high = cur > meta["high"]
                hit_new_low = cur < meta["low"]
                meta["high"] = max(meta["high"], cur)
                meta["low"] = min(meta["low"], cur)
                meta["last_price"] = cur
                meta["last_check"] = datetime.now(timezone.utc).isoformat()
                fired = meta.get("alerts_fired", [])

                # DIP: -10% from alert AND new low AND haven't already fired DIP
                if pct <= DIP_PCT and hit_new_low and "DIP" not in fired:
                    post_betabot(f"<@me> dip alert", build_embed(occ, meta["alert"], cur, meta["high"], meta["low"], "DIP - entry opportunity", 0x2D8F3F))
                    fired.append("DIP")
                    log("dip_alert", f"{occ} {pct:.1f}%")

                # RUNNING: +20% new HOD AND haven't fired RUNNING
                if pct >= RUNNING_PCT and hit_new_high and "RUNNING" not in fired:
                    post_betabot(f"runner alert", build_embed(occ, meta["alert"], cur, meta["high"], meta["low"], "RUNNING - chase risk", 0xC76A00))
                    fired.append("RUNNING")
                    log("running_alert", f"{occ} {pct:.1f}%")

                # DEAD: -50% or DTE < 1
                dte_remaining = meta["alert"].get("dte", 99) - ((time.time() - datetime.fromisoformat(meta["first_seen"]).timestamp()) / 86400)
                if (pct <= DEAD_PCT or dte_remaining < 1) and "DEAD" not in fired:
                    post_betabot(f"dead alert", build_embed(occ, meta["alert"], cur, meta["high"], meta["low"], "DEAD - skip", 0x5F5E5A))
                    fired.append("DEAD")
                    log("dead_alert", f"{occ} {pct:.1f}% dte={dte_remaining:.1f}")

                meta["alerts_fired"] = fired

            save_state(state)
        except Exception as e:
            log("loop_error", f"{e}\n{traceback.format_exc()[:500]}")
        time.sleep(POLL_INTERVAL_SEC)

if __name__ == "__main__":
    sys.exit(main() or 0)
