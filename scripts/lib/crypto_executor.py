"""Crypto trade executor — Alpaca paper.
Runs at end of each Boba/Jazzy decision cycle.
- Calls exit monitor first (closes positions hitting TP/SL)
- Picks top pumpers from screener (CoinPaprika data)
- Submits market buys
- Posts polished embed to Discord (#daily-crypto-pumps)
"""
import sys, json, requests, time
from pathlib import Path
from datetime import datetime, timezone
from zoneinfo import ZoneInfo

sys.path.insert(0, "/home/ubuntu/scripts/lib")
from crypto_screener import (
    get_top_picks, fetch_markets, fetch_alpaca_crypto_symbols,
    score, alpaca_symbol_for,
)
from crypto_exit_monitor import run as run_exit_monitor
from exchange_lookup import availability

SECRETS = Path("/home/ubuntu/.openclaw/secrets")
STATE_DIR = Path("/home/ubuntu/.openclaw/workspace/state")
STATE_DIR.mkdir(parents=True, exist_ok=True)

MAX_PICKS_PER_DAY = 2
RISK_USD_PER_PICK = 200

def _alpaca(account):
    key = (SECRETS / f"alpaca-{account}-key-id").read_text().strip()
    sec = (SECRETS / f"alpaca-{account}-secret").read_text().strip()
    return key, sec, "https://paper-api.alpaca.markets"

def _today():
    et = ZoneInfo("America/New_York")
    return datetime.now(et).strftime("%Y-%m-%d")

def _state_file(account):
    return STATE_DIR / f"crypto_{account}_daily.json"

def _load_state(account):
    f = _state_file(account)
    if not f.exists(): return {"date": _today(), "picks": []}
    d = json.loads(f.read_text())
    if d.get("date") != _today():
        return {"date": _today(), "picks": []}
    return d

def _save_state(account, st):
    _state_file(account).write_text(json.dumps(st, indent=2))

def _webhook():
    p = SECRETS / "discord_webhook_crypto_pumps"
    return p.read_text().strip() if p.exists() else None

def post_discord(payload):
    url = _webhook()
    if not url: return
    try:
        requests.post(url, json=payload, timeout=10)
    except Exception as e:
        print(f"[discord] post fail: {e}")

def submit_crypto_order(account, pick):
    key, sec, base = _alpaca(account)
    qty = round(RISK_USD_PER_PICK / pick["price"], 6)
    body = {"symbol": pick["symbol"], "qty": str(qty), "side": "buy",
            "type": "market", "time_in_force": "gtc"}
    try:
        r = requests.post(f"{base}/v2/orders",
            headers={"APCA-API-KEY-ID": key, "APCA-API-SECRET-KEY": sec,
                     "Content-Type": "application/json"},
            json=body, timeout=15)
        return r.status_code, r.json()
    except Exception as e:
        return 0, {"error": str(e)}

def screener_summary(top_n=50):
    """Returns top N coins by 24h move (any direction) for display.
    Computes an INDEPENDENT 0-100 momentum score so every coin gets a meaningful number.
    """
    alpaca_set = fetch_alpaca_crypto_symbols()
    coins = fetch_markets()
    out = []
    MIN_MCAP_DISPLAY = 100_000_000
    MIN_VOL_DISPLAY = 5_000_000
    for c in coins:
        mc = c.get("market_cap") or 0
        vol = c.get("total_volume") or 0
        if mc < MIN_MCAP_DISPLAY or vol < MIN_VOL_DISPLAY: continue
        sym_up = c.get("symbol", "").upper()
        alpaca_sym = alpaca_symbol_for(sym_up, alpaca_set)

        # Independent display score (0-100) based purely on momentum quality
        chg_1h  = c.get("price_change_percentage_1h_in_currency") or 0
        chg_24h = c.get("price_change_percentage_24h") or 0
        chg_7d  = c.get("price_change_percentage_7d_in_currency") or 0
        # Magnitude (capped at 30% to prevent blow-off distortion)
        magnitude = min(abs(chg_24h), 30) / 30 * 30  # 0-30
        # Direction alignment — all 3 timeframes agreeing = real trend
        bull_aligned = chg_1h > 0 and chg_24h > 0 and chg_7d > -2
        bear_aligned = chg_1h < 0 and chg_24h < 0 and chg_7d < 2
        alignment = 25 if (bull_aligned or bear_aligned) else (10 if (chg_1h > 0) == (chg_24h > 0) else 0)
        # Volume turnover (vol/mcap = how actively traded today vs total cap)
        turnover = min((vol / mc * 100) if mc > 0 else 0, 1) * 25
        # 1h momentum strength
        m1h = min(abs(chg_1h) / 5, 1) * 20
        disp_score = min(int(magnitude + alignment + turnover + m1h), 100)

        out.append({
            "sym": alpaca_sym if alpaca_sym else f"{sym_up}/—",
            "name": c["name"],
            "score": disp_score,
            "chg_1h": chg_1h, "chg_24h": chg_24h, "chg_7d": chg_7d,
            "vol": vol,
            "tradeable": bool(alpaca_sym),
        })
    out.sort(key=lambda x: -abs(x["chg_24h"]))
    return out[:top_n]

def make_table(rows):
    """Compact aligned columns — fits Discord embed width on desktop AND mobile."""
    if not rows: return "_no qualifying movers right now_"
    data = []
    for s in rows:
        base = s["sym"].split("/")[0]
        avail = availability(base)
        a = "A" if s["tradeable"] else "·"
        c = "C" if avail["coinbase"] else "·"
        r = "R" if avail["robinhood"] else "·"
        h = "H" if avail["hyperliquid"] else "·"
        sc = str(s["score"]) if s["score"] > 0 else "—"
        data.append({"coin": base[:6], "exch": a+c+r+h,
                     "h1": f"{s['chg_1h']:+.1f}", "d24": f"{s['chg_24h']:+.1f}",
                     "d7": f"{s['chg_7d']:+.0f}", "vol": f"{s['vol']/1e6:.0f}M", "sc": sc})
    # narrow column widths, no separators or box drawing
    out = ["COIN   EXCH  1h%   24h%  7d%   VOL    SC",
           "─" * 41]
    for d in data:
        out.append(f"{d['coin']:<6} {d['exch']:<4}  "
                   f"{d['h1']:>4}  {d['d24']:>5}  {d['d7']:>3}   "
                   f"{d['vol']:>5}  {d['sc']:>2}")
    return "```\n" + "\n".join(out) + "\n```"

def run(account):
    print(f"[crypto/{account}] starting subcycle", flush=True)
    run_exit_monitor(account)

    st = _load_state(account)
    picks_taken = []
    cap_hit = False
    if len(st["picks"]) >= MAX_PICKS_PER_DAY:
        cap_hit = True
    else:
        picks = get_top_picks(MAX_PICKS_PER_DAY - len(st["picks"]))
        for p in picks:
            if any(x["symbol"] == p["symbol"] for x in st["picks"]): continue
            code, resp = submit_crypto_order(account, p)
            ok = 200 <= code < 300
            print(f"[crypto/{account}] {p['symbol']} score={p['score']} 24h={p['chg_24h']:.1f}% -> {'OK' if ok else 'FAIL'} ({code})", flush=True)
            if ok:
                p_full = dict(p); p_full["order_id"] = resp.get("id", "?"); p_full["qty"] = resp.get("qty")
                picks_taken.append(p_full)
                st["picks"].append({"symbol": p["symbol"], "score": p["score"], "price": p["price"],
                                    "qty": resp.get("qty"), "id": resp.get("id"),
                                    "submitted_at": resp.get("submitted_at")})
                _save_state(account, st)

    # Buy alerts
    for p in picks_taken:
        base = p["symbol"].split("/")[0]
        avail = availability(base)
        on_exch = []
        if p.get("tradeable", True): on_exch.append("Alpaca")
        if avail["coinbase"]:    on_exch.append("Coinbase")
        if avail["robinhood"]:   on_exch.append("Robinhood")
        if avail["hyperliquid"]: on_exch.append("Hyperliquid")
        try: notional = float(p["qty"]) * p["price"]
        except: notional = RISK_USD_PER_PICK
        post_discord({
            "username": f"{account.title()} Trader",
            "avatar_url": "https://cdn-icons-png.flaticon.com/512/2807/2807730.png",
            "embeds": [{
                "title": f"🚀 BOUGHT {p['symbol']} @ ${p['price']:.6f}",
                "color": 5763719,
                "fields": [
                    {"name": "24h",        "value": f"`{p['chg_24h']:+.2f}%`",       "inline": True},
                    {"name": "1h",         "value": f"`{p['chg_1h']:+.2f}%`",        "inline": True},
                    {"name": "7d",         "value": f"`{p['chg_7d']:+.1f}%`",        "inline": True},
                    {"name": "Score",      "value": f"`{p['score']}/100`",            "inline": True},
                    {"name": "Notional",   "value": f"`${notional:.2f}`",             "inline": True},
                    {"name": "Quantity",   "value": f"`{p['qty']}`",                  "inline": True},
                    {"name": "Volume 24h", "value": f"`${p['volume']/1e6:.0f}M`",     "inline": True},
                    {"name": "Market cap", "value": f"`${p['mcap']/1e9:.2f}B`",       "inline": True},
                    {"name": "Available",  "value": ", ".join(on_exch),               "inline": True},
                ],
                "footer": {"text": f"{account} paper · order {p['order_id'][:18]}"},
                "timestamp": datetime.now(timezone.utc).isoformat(),
            }]
        })

    # Cycle summary
    summary = screener_summary(50)
    rows = summary[:50]
    table = make_table(rows)

    if picks_taken:
        status = f"✅ Bought {len(picks_taken)}: " + ", ".join(p["symbol"].split("/")[0] for p in picks_taken)
        color = 5763719
    elif cap_hit:
        status = "🔐 Daily cap reached — holding"
        color = 16776960
    else:
        status = "📡 No qualifiers — watching"
        color = 7506394

    et_time = datetime.now(ZoneInfo("America/New_York")).strftime("%-I:%M %p ET")

    desc = f"📊 **Top movers · {et_time}**\n{table}"
    # Discord limit: 4096 chars per description; trim if oversize
    if len(desc) > 4000:
        desc = desc[:3990] + "\n```"
    post_discord({
        "username": f"{account.title()} Trader",
        "avatar_url": "https://cdn-icons-png.flaticon.com/512/2807/2807730.png",
        "embeds": [{
            "author": {
                "name": f"{account.title()} Trader · Crypto Cycle",
                "icon_url": "https://cdn-icons-png.flaticon.com/512/2807/2807730.png",
            },
            "title": status,
            "description": desc,
            "color": color,
            "thumbnail": {"url": "https://assets.coingecko.com/coins/images/1/large/bitcoin.png"},
                        "fields": [
                {
                    "name": "Brokers",
                    "value": "🦙 **A** Alpaca\n🪙 **C** Coinbase\n🏹 **R** Robinhood\n💧 **H** Hyperliquid",
                    "inline": True,
                },
                {
                    "name": "Score Tiers",
                    "value": "🔥 **80+** strong\n💪 **60-79** solid\n📊 **40-59** mixed\n⚪ **<40** weak",
                    "inline": True,
                },
            ],
"footer": {"text": f"{len(st['picks'])}/{MAX_PICKS_PER_DAY} picks today"},
            "timestamp": datetime.now(timezone.utc).isoformat(),
        }]
    })

if __name__ == "__main__":
    account = sys.argv[1] if len(sys.argv) > 1 else "boba"
    run(account)
