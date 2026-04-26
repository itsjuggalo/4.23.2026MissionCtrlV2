#!/usr/bin/env python3
"""Squeeze scanner — yfinance SI/DTC + whale sweeps + Tradier IV → score → Discord."""
import sys, json, logging, time
from pathlib import Path
from datetime import datetime, timezone, timedelta
import requests
import yfinance as yf

sys.path.insert(0, "/home/ubuntu/scripts/lib")
from tradier_client import fetch_atm_straddle, get_expirations  # noqa

SECRETS = Path("/home/ubuntu/.openclaw/secrets")
LOG_DIR = Path("/home/ubuntu/.openclaw/workspace/logs"); LOG_DIR.mkdir(parents=True, exist_ok=True)
STATE_DIR = Path("/home/ubuntu/.openclaw/workspace/state"); STATE_DIR.mkdir(parents=True, exist_ok=True)
STATE_FILE = STATE_DIR / "squeeze_scanner_state.json"
WATCHLIST = Path("/home/ubuntu/scripts/squeeze-scanner/seed_watchlist.txt")
CHANNEL_ID = "1498022103906254879"  # squeeze-alerts
COOLDOWN_HOURS = 12
SCORE_THRESHOLD = 50

logging.basicConfig(filename=LOG_DIR/"squeeze_scanner.log", level=logging.INFO,
                    format="%(asctime)s %(levelname)s %(message)s")
log = logging.getLogger()

def secret(name):
    p = SECRETS / name
    return p.read_text().strip() if p.exists() else ""

def load_state():
    if STATE_FILE.exists():
        try: return json.loads(STATE_FILE.read_text())
        except: pass
    return {}

def save_state(s):
    STATE_FILE.write_text(json.dumps(s, indent=2))

def load_watchlist():
    tickers = []
    for line in WATCHLIST.read_text().splitlines():
        t = line.split("#")[0].strip()
        if t: tickers.append(t.upper())
    return tickers

def dynamic_universe():
    """Pull tickers with active call sweeps from live-signals."""
    try:
        r = requests.get("http://localhost:3033/api/live-signals", timeout=10)
        if r.status_code == 200:
            sigs = r.json().get("recentSignals", [])
            INDEX_SKIP = {"SPX", "SPXW", "NDX", "RUT", "VIX", "XSP"}
            return [s["ticker"] for s in sigs if s.get("option_type") == "CALL" and s.get("ticker") and s["ticker"] not in INDEX_SKIP]
    except Exception as e:
        log.warning(f"dynamic_universe: {e}")
    return []

def whale_sweep_tickers(hours=24):
    """Tickers with whale CALL sweeps in last N hours."""
    try:
        r = requests.get("http://localhost:3033/api/live-signals", timeout=10)
        if r.status_code != 200: return set()
        cutoff = datetime.now(timezone.utc) - timedelta(hours=hours)
        out = set()
        for s in r.json().get("recentSignals", []):
            if s.get("option_type") != "CALL": continue
            try:
                ts = datetime.fromisoformat(s["timestamp"].replace("Z","+00:00"))
                if ts > cutoff: out.add(s["ticker"])
            except: pass
        return out
    except Exception as e:
        log.warning(f"whale_sweeps: {e}"); return set()

def fetch_yf(ticker):
    """Pull SI / DTC / float / price from yfinance."""
    try:
        t = yf.Ticker(ticker)
        info = t.info or {}
        hist = t.history(period="3mo", interval="1d")
        if hist.empty: return None
        price = float(hist["Close"].iloc[-1])
        hi52 = float(hist["High"].max())
        avg_vol = float(hist["Volume"].tail(20).mean()) if len(hist) >= 20 else float(hist["Volume"].mean())
        si = info.get("sharesShort") or 0
        si_prior = info.get("sharesShortPriorMonth") or 0
        float_shares = info.get("floatShares") or info.get("sharesOutstanding") or 0
        dtc = info.get("shortRatio") or (si / avg_vol if avg_vol > 0 else 0)
        si_pct = (si / float_shares * 100) if float_shares > 0 else 0
        return {
            "ticker": ticker,
            "price": round(price, 2),
            "hi52": round(hi52, 2),
            "from_hi_pct": round((price / hi52 - 1) * 100, 2) if hi52 > 0 else 0,
            "si": int(si),
            "si_prior": int(si_prior),
            "si_change_pct": round((si - si_prior) / si_prior * 100, 1) if si_prior > 0 else 0,
            "float": int(float_shares),
            "si_pct_float": round(si_pct, 2),
            "dtc": round(float(dtc), 2),
            "avg_vol_20d": int(avg_vol),
            "name": (info.get("shortName") or info.get("longName") or ticker)[:40],
        }
    except Exception as e:
        log.warning(f"yf {ticker}: {e}"); return None

def tradier_iv(ticker, spot):
    """Pull ATM call IV from nearest expiry 7-30 DTE."""
    try:
        exps = get_expirations(ticker) or []
        if not exps: return None
        today = datetime.now().date()
        target = None
        for e in exps:
            d = datetime.strptime(e, "%Y-%m-%d").date()
            dte = (d - today).days
            if 7 <= dte <= 35:
                target = e; break
        if not target: target = exps[0]
        # Need spot price — call yfinance fast-info or use the yf_data we already have
        # But tradier_iv is called from main loop; we'll get spot from the data we already fetched.
        # Pass spot via new param — refactor below.
        s = fetch_atm_straddle(ticker, spot, target)
        if s and s.get("call_iv") is not None:
            return {"iv": float(s.get("call_iv") or 0), "exp": target,
                    "implied_move_pct": float(s.get("implied_move_pct") or 0)}
    except Exception as e:
        log.warning(f"tradier {ticker}: {e}")
    return None

def score(yf_data, has_sweep, iv_data):
    """0-100 squeeze score."""
    s = 0; reasons = []
    si_pct = yf_data["si_pct_float"]; dtc = yf_data["dtc"]; from_hi = yf_data["from_hi_pct"]
    if si_pct > 30: s += 30; reasons.append(f"SI {si_pct:.1f}% extreme")
    elif si_pct > 20: s += 20; reasons.append(f"SI {si_pct:.1f}% high")
    elif si_pct > 10: s += 10; reasons.append(f"SI {si_pct:.1f}% elevated")
    if dtc > 7: s += 20; reasons.append(f"DTC {dtc:.1f} extreme")
    elif dtc > 5: s += 15; reasons.append(f"DTC {dtc:.1f} high")
    elif dtc > 3: s += 8; reasons.append(f"DTC {dtc:.1f} mod")
    if has_sweep: s += 25; reasons.append("whale call sweep 24h")
    if iv_data and iv_data.get("implied_move_pct", 0) > 8:
        s += 15; reasons.append(f"IV implied ±{iv_data['implied_move_pct']:.1f}%")
    elif iv_data and iv_data.get("implied_move_pct", 0) > 5:
        s += 8; reasons.append(f"IV implied ±{iv_data['implied_move_pct']:.1f}%")
    if -5 <= from_hi <= 0: s += 10; reasons.append(f"{from_hi:.1f}% from 52w high")
    elif from_hi > 0: s += 5; reasons.append("at new high")
    return min(s, 100), reasons

def post(yf_data, score_val, reasons, iv_data):
    color = 0xef5350 if score_val >= 75 else 0xffa502 if score_val >= 60 else 0x4dabf7
    fields = [
        {"name": "Short Interest", "value": f"{yf_data['si_pct_float']:.1f}% of float\n{yf_data['si']/1e6:.1f}M sh", "inline": True},
        {"name": "Days to Cover", "value": f"{yf_data['dtc']:.1f}d", "inline": True},
        {"name": "Price", "value": f"${yf_data['price']} ({yf_data['from_hi_pct']:+.1f}% vs 52w hi)", "inline": True},
        {"name": "Float", "value": f"{yf_data['float']/1e6:.1f}M", "inline": True},
        {"name": "Avg Vol (20d)", "value": f"{yf_data['avg_vol_20d']/1e6:.2f}M", "inline": True},
        {"name": "SI Δ vs prior mo", "value": f"{yf_data['si_change_pct']:+.1f}%", "inline": True},
    ]
    if iv_data:
        fields.append({"name": "ATM Call IV", "value": f"±{iv_data.get('implied_move_pct',0):.1f}% by {iv_data['exp']}", "inline": False})
    fields.append({"name": "Why", "value": " · ".join(reasons)[:1024] or "—", "inline": False})
    embed = {"title": f"⚡ SQUEEZE WATCH — {yf_data['ticker']} (score {score_val})",
             "description": yf_data["name"], "color": color, "fields": fields,
             "footer": {"text": f"yfinance + Tradier + whale-flow · {datetime.now(timezone(timedelta(hours=-4))).strftime('%a %b %d %I:%M %p ET')}"}}
    token = secret("spacer_bot_token.txt")
    r = requests.post(f"https://discord.com/api/v10/channels/{CHANNEL_ID}/messages",
                      headers={"Authorization": f"Bot {token}", "Content-Type": "application/json"},
                      json={"embeds": [embed]}, timeout=15)
    return r.status_code in (200, 201)

def main():
    log.info("=== squeeze scanner start ===")
    state = load_state()
    now = datetime.now(timezone.utc)
    seed = load_watchlist()
    dynamic = dynamic_universe()
    universe = list(dict.fromkeys(seed + dynamic))
    sweeps = whale_sweep_tickers(24)
    log.info(f"universe={len(universe)} (seed={len(seed)}, dynamic={len(dynamic)}), whale_sweeps={len(sweeps)}")
    posted = 0; scanned = 0; skipped_cooldown = 0
    for tkr in universe:
        scanned += 1
        last = state.get(tkr, {}).get("last_post")
        if last:
            try:
                last_dt = datetime.fromisoformat(last)
                if (now - last_dt).total_seconds() < COOLDOWN_HOURS * 3600:
                    skipped_cooldown += 1; continue
            except: pass
        yf_data = fetch_yf(tkr)
        if not yf_data:
            log.info(f"  {tkr}: yf data missing, skip"); continue
        if yf_data["si_pct_float"] < 5 and yf_data["dtc"] < 2:
            continue  # not a squeeze candidate
        iv = tradier_iv(tkr, yf_data["price"]) if yf_data["si_pct_float"] > 15 else None
        sc, reasons = score(yf_data, tkr in sweeps, iv)
        log.info(f"  {tkr}: score={sc} SI={yf_data['si_pct_float']:.1f}% DTC={yf_data['dtc']:.1f} sweep={tkr in sweeps}")
        if sc >= SCORE_THRESHOLD:
            if post(yf_data, sc, reasons, iv):
                state[tkr] = {"last_post": now.isoformat(), "score": sc}
                posted += 1
                log.info(f"  {tkr}: ✓ POSTED score {sc}")
            time.sleep(1)
        time.sleep(0.3)
    save_state(state)
    log.info(f"=== done: scanned {scanned}, posted {posted}, cooldown-skipped {skipped_cooldown} ===")

if __name__ == "__main__":
    main()
