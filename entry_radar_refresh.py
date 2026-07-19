#!/usr/bin/env python3
"""entry_radar_refresh.py — compute entry-quality reads for SPY/QQQ + Mike's
watchlist + his held stocks, from Alpaca daily bars (IEX feed, free).

Replaces the Promotion Gate slot on the Command Center with something a trader
can act on: for each symbol — trend, RSI, a pullback BUY ZONE (EMA21 ± 0.4*ATR),
the breakout trigger (20d high), and a one-line plain-English verdict
("at entry zone" / "extended — wait for $X" / "downtrend — no edge").

Advisory only. Writes ~/.openclaw/workspace/directives/entry_radar.json
(served by /api/directives?file=entry_radar.json). Cron: pre-market + hourly.
"""
import json, os, sys, tempfile, urllib.request, urllib.parse
from datetime import datetime, timedelta, timezone

HOME = os.path.expanduser("~")
OUT = os.path.join(HOME, ".openclaw/workspace/directives/entry_radar.json")
BOOK = os.path.join(HOME, "portfolio/unified_book.json")
WATCH_FILE = os.path.join(HOME, "portfolio/cc_watchlist.txt")
SECRETS = os.path.join(HOME, ".openclaw/secrets")
WATCH_DEFAULT = ["AAPL", "NVDA", "TSLA", "MU", "LLY"]
CORE = ["SPY", "QQQ"]
CRYPTO = {"BTC", "ETH", "DOGE", "XRP", "XLM", "CRO", "XCN", "LTC", "HBAR", "ALGO",
          "UNI", "JASMY", "ETC", "SOL", "ADA", "USDC", "USD"}
MAX_SYMS = 12


def secret(name):
    return open(os.path.join(SECRETS, name)).read().strip()


def held_stocks():
    """Top held STOCK tickers from the unified book (mkt value ≥ $50)."""
    try:
        book = json.load(open(BOOK))
    except Exception:
        return []
    rows = []
    for p in book.get("positions", []):
        s = (p.get("symbol") or "").upper()
        if not s or s in CRYPTO:
            continue
        if (p.get("asset_class") or "").lower() == "crypto":
            continue
        if (p.get("mkt_value") or 0) >= 50:
            rows.append((p["mkt_value"], s))
    rows.sort(reverse=True)
    seen, out = set(), []
    for _, s in rows:
        if s not in seen:
            seen.add(s); out.append(s)
    return out


def watchlist():
    try:
        syms = [s.strip().upper() for s in open(WATCH_FILE) if s.strip()]
        if syms:
            return syms
    except OSError:
        pass
    return WATCH_DEFAULT


def fetch_bars(syms, key, sec):
    url = ("https://data.alpaca.markets/v2/stocks/bars?"
           + urllib.parse.urlencode({
               "symbols": ",".join(syms), "timeframe": "1Day", "limit": 3000,
               "adjustment": "split", "feed": "iex",
               "start": (datetime.utcnow() - timedelta(days=180)).strftime("%Y-%m-%dT00:00:00Z"),
           }))
    req = urllib.request.Request(url, headers={"APCA-API-KEY-ID": key, "APCA-API-SECRET-KEY": sec})
    with urllib.request.urlopen(req, timeout=30) as r:
        return json.load(r).get("bars", {})


def fetch_yahoo_bars(ysym, rng="1y", interval="1d"):
    """Futures/anything Alpaca can't serve (MNQ=F) via Yahoo's public chart JSON.
    Returns bars in the same {h,l,c,t} shape as fetch_bars. Stdlib only."""
    url = (f"https://query1.finance.yahoo.com/v8/finance/chart/{urllib.parse.quote(ysym)}"
           f"?range={rng}&interval={interval}")
    req = urllib.request.Request(url, headers={"User-Agent": "Mozilla/5.0 (entry-radar)"})
    try:
        with urllib.request.urlopen(req, timeout=25) as r:
            d = json.load(r)
        res = d["chart"]["result"][0]
        q = res["indicators"]["quote"][0]
        ts = res.get("timestamp") or []
        bars = []
        for i, t in enumerate(ts):
            h, l, c = q["high"][i], q["low"][i], q["close"][i]
            if None in (h, l, c):
                continue
            bars.append({"h": h, "l": l, "c": c,
                         "t": datetime.fromtimestamp(t, tz=timezone.utc)
                         .strftime("%Y-%m-%dT%H:%M:%SZ")})
        return bars
    except Exception:
        return []


# Yahoo-sourced symbols appended AFTER the Alpaca list (futures: Mike asked for MNQ
# dip-entry timing 2026-07-07). display name -> yahoo symbol
FUTURES = {"MNQ": "MNQ=F"}


def ema(vals, n):
    k = 2 / (n + 1)
    e = vals[0]
    for v in vals[1:]:
        e = v * k + e * (1 - k)
    return e


def rsi(closes, n=14):
    if len(closes) < n + 1:
        return None
    gains = losses = 0.0
    for i in range(1, n + 1):
        d = closes[i] - closes[i - 1]
        gains += max(d, 0); losses += max(-d, 0)
    ag, al = gains / n, losses / n
    for i in range(n + 1, len(closes)):
        d = closes[i] - closes[i - 1]
        ag = (ag * (n - 1) + max(d, 0)) / n
        al = (al * (n - 1) + max(-d, 0)) / n
    return 100.0 if al == 0 else round(100 - 100 / (1 + ag / al), 1)


def atr(bars, n=14):
    if len(bars) < n + 1:
        return None
    trs = []
    for i in range(1, len(bars)):
        h, l, pc = bars[i]["h"], bars[i]["l"], bars[i - 1]["c"]
        trs.append(max(h - l, abs(h - pc), abs(l - pc)))
    a = sum(trs[:n]) / n
    for t in trs[n:]:
        a = (a * (n - 1) + t) / n
    return a


def analyze(sym, bars, held):
    if len(bars) < 30:
        return None
    closes = [b["c"] for b in bars]
    px = closes[-1]
    e21, e8 = ema(closes, 21), ema(closes, 8)
    r = rsi(closes)
    a = atr(bars) or 0
    hi20 = max(b["h"] for b in bars[-20:])
    lo20 = min(b["l"] for b in bars[-20:])
    up = px > e21
    entry_lo, entry_hi = round(e21 - 0.4 * a, 2), round(e21 + 0.4 * a, 2)
    breakout = round(hi20 + 0.1 * a, 2)
    stop_ref = round(lo20, 2)
    if up and entry_lo <= px <= entry_hi:
        status, note = "AT ENTRY", f"uptrend pullback to the 21-day line — decent entry zone ${entry_lo}–${entry_hi}, risk off ${stop_ref}"
    elif up and px > entry_hi:
        gap = (px - e21) / a if a else 0
        status = "EXTENDED" if gap > 1.2 else "TRENDING"
        note = (f"don't chase — wait for a dip to ${entry_lo}–${entry_hi}" if status == "EXTENDED"
                else f"in trend; better price near ${entry_hi}, breakout add over ${breakout}")
    elif r is not None and r < 32:
        status, note = "OVERSOLD", f"RSI {r} washed out — bounce watch only, needs a green day to confirm"
    else:
        status, note = "NO EDGE", f"below the 21-day line — no long edge until it reclaims ${round(e21, 2)}"
    return {
        "sym": sym, "held": held, "price": round(px, 2), "rsi": r,
        "trend": "UP" if up else "DOWN", "ema21": round(e21, 2), "ema8": round(e8, 2),
        "entryLo": entry_lo, "entryHi": entry_hi, "breakout": breakout,
        "stopRef": stop_ref, "hi20": round(hi20, 2), "lo20": round(lo20, 2),
        "status": status, "note": note,
        "lastBar": bars[-1].get("t", ""),
    }


if __name__ == "__main__":
    key, sec = secret("alpaca-key-id"), secret("alpaca-secret")
    held = held_stocks()
    syms, seen = [], set()
    for s in CORE + watchlist() + held:
        if s not in seen:
            seen.add(s); syms.append(s)
    syms = syms[:MAX_SYMS]
    bars = fetch_bars(syms, key, sec)
    rows = []
    for s in syms:
        row = analyze(s, bars.get(s, []), s in held)
        if row:
            rows.append(row)
    for disp, ysym in FUTURES.items():                      # MNQ etc via Yahoo
        row = analyze(disp, fetch_yahoo_bars(ysym), False)
        if row:
            row["source"] = "yahoo"
            rows.append(row)
    if not rows:
        sys.exit("refusing to write: no bars returned")
    # AT-ENTRY transition alerts (real_coach P4): ping ONLY when a symbol newly
    # ENTERS the buy zone — the "when is the right TA entry after a dip" answer.
    try:
        prev = {r["sym"]: r.get("status") for r in json.load(open(OUT)).get("rows", [])}
    except Exception:
        prev = {}
    import subprocess
    for r in rows:
        if r["status"] == "AT ENTRY" and prev.get(r["sym"]) not in (None, "AT ENTRY"):
            msg = (f"🎯 {r['sym']} ENTERED the buy zone ${r['entryLo']}–${r['entryHi']} "
                   f"(now ${r['price']}, RSI {r['rsi']}, was {prev.get(r['sym'])})\n"
                   f"{r['note']}\nStop ref ${r['stopRef']} — plan the entry, don't chase.")
            try:
                subprocess.run([os.path.join(HOME, "bin", "tg-send-msg"), msg],
                               timeout=20, check=False)
            except Exception:
                pass
    # Morning roster (7:40 ET run only): one digest of everything currently
    # buyable, so the buyable list arrives without opening the page. The
    # transition pings above fire all day and only on a NEW entry; this is the
    # once-a-day "what's in the zone right now" snapshot. Stays silent when
    # nothing qualifies — a daily "nothing today" trains you to ignore it.
    # ET explicitly: the cron sets TZ=America/New_York, but a manual run without
    # it would read UTC and fire this at 3am ET instead.
    from zoneinfo import ZoneInfo
    if datetime.now(ZoneInfo("America/New_York")).hour == 7:
        buyable = [r for r in rows if r["status"] in ("AT ENTRY", "OVERSOLD")]
        if buyable:
            buyable.sort(key=lambda r: (r["status"] != "AT ENTRY", r["sym"]))
            lines = ["🌅 ENTRY RADAR — buyable at the open", ""]
            for r in buyable:
                tag = "🎯 AT ENTRY" if r["status"] == "AT ENTRY" else "🩹 OVERSOLD"
                lines.append(f"{tag} {r['sym']} ${r['price']} (RSI {r['rsi']})")
                lines.append(f"   zone ${r['entryLo']}–${r['entryHi']} · stop ref ${r['stopRef']}")
                lines.append(f"   {r['note']}")
            lines.append("")
            lines.append("Plan the entry, don't chase. Advisory only — size it yourself.")
            try:
                subprocess.run([os.path.join(HOME, "bin", "tg-send-msg"), "\n".join(lines)],
                               timeout=20, check=False)
                print(f"morning roster sent: {len(buyable)} buyable")
            except Exception as e:
                print(f"morning roster send failed: {e}")
        else:
            print("morning roster: nothing AT ENTRY/OVERSOLD — staying silent")

    doc = {"updated": datetime.now().astimezone().isoformat(), "rows": rows}
    fd, tmp = tempfile.mkstemp(dir=os.path.dirname(OUT))
    with os.fdopen(fd, "w") as f:
        json.dump(doc, f)
    os.replace(tmp, OUT)
    print(f"wrote {len(rows)} rows: " + ", ".join(f"{r['sym']}:{r['status']}" for r in rows))
