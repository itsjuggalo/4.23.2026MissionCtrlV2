#!/usr/bin/env python3
"""entry_radar_refresh.py — compute entry-quality reads for SPY/QQQ + Mike's
watchlist, from completed daily bars (shared loader: Robinhood daily, then cache/yfinance; no Alpaca).

Replaces the Promotion Gate slot on the Command Center with something a trader
can act on: for each symbol — trend, RSI, a pullback ENTRY ZONE (EMA21 ± 0.4*ATR),
the breakout trigger (20d high), and a one-line plain-English verdict
("at entry zone" / "extended — wait for $X" / "downtrend — no edge").

Advisory only. Writes ~/.openclaw/workspace/directives/entry_radar.json
(served by /api/directives?file=entry_radar.json). Cron: pre-market + hourly
weekdays, plus after-hours/weekend refresh (adds `mode`/`nextSession`/
`futuresLean` — see pipeline/lib/afterhours.py in the missionctrl repo).

2026-09-12: the Robinhood-holdings input ("held" stocks from unified_book.json)
was removed site-wide with the portfolio retirement — universe is SPY/QQQ +
watchlist only now.
"""
import json, os, sys, tempfile, time, urllib.error, urllib.request, urllib.parse
from datetime import datetime, timedelta, timezone

HOME = os.path.expanduser("~")
OUT = os.path.join(HOME, ".openclaw/workspace/directives/entry_radar.json")
WATCH_FILE = os.path.join(HOME, "portfolio/cc_watchlist.txt")
SECRETS = os.path.join(HOME, ".openclaw/secrets")
WATCH_DEFAULT = ["AAPL", "NVDA", "TSLA", "MU", "LLY"]
CORE = ["SPY", "QQQ"]
MAX_SYMS = 12

# Shared after-hours/weekend helper lives in the missionctrl repo, not here —
# this script runs from ~/05_AUTOMATION/scripts, so add its pipeline dir.
MC_PIPELINE = "/AIWorkWSL/web/missionctrl/pipeline"
if MC_PIPELINE not in sys.path:
    sys.path.insert(0, MC_PIPELINE)
from lib import afterhours as ah  # noqa: E402


def secret(name):
    return open(os.path.join(SECRETS, name)).read().strip()


def watchlist():
    try:
        syms = [s.strip().upper() for s in open(WATCH_FILE) if s.strip()]
        if syms:
            return syms
    except OSError:
        pass
    return WATCH_DEFAULT


def fetch_bars(syms):
    """Completed daily bars from the shared loader (pipeline/decision/lib/bars.get_bars: Robinhood daily first, then
    the console cache, then yfinance; no Alpaca - market-data §1). Returns {sym: [{h,l,c,t}]}; a symbol the loader
    cannot serve is left out so the caller falls back to Yahoo's chart JSON. Each bar list carries its source in
    BAR_SOURCE[sym] so a card can say where it came from."""
    out = {}
    try:
        sys.path.insert(0, "/AIWorkWSL/web/missionctrl")
        from pipeline.decision.lib import bars as shared
    except Exception as e:  # noqa: BLE001
        print(f"shared bars loader unavailable: {type(e).__name__} - using the Yahoo fallback")
        return out
    for s in syms:
        try:
            bs = shared.get_bars(s.replace(".", "-"), "1d", lookback_period="1y")
        except Exception as e:  # noqa: BLE001
            print(f"bars {s}: {type(e).__name__}: {str(e)[:80]}")
            continue
        out[s] = [{"h": float(r["h"]), "l": float(r["l"]), "c": float(r["c"]),
                   "t": r["t"].astimezone(timezone.utc).strftime("%Y-%m-%dT%H:%M:%SZ")} for r in bs.df.to_dict("records")]
        BAR_SOURCE[s] = str(bs.source)
    return out


BAR_SOURCE = {}


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
    """The canonical RSI (missionctrl lib/rsi_canonical = Robinhood's RSI; same math, a flat series reads 50)."""
    sys.path.insert(0, "/AIWorkWSL/web/missionctrl/pipeline/decision/lib")
    from rsi_canonical import rsi_last
    v = rsi_last(closes, n)
    return None if v is None else round(v, 1)


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


def analyze(sym, bars):
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
    if up and entry_lo <= px <= entry_hi:
        status, note = "AT ENTRY", f"uptrend pullback to the 21-day line — decent entry zone ${entry_lo}–${entry_hi}"
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
        "sym": sym, "price": round(px, 2), "rsi": r,
        "trend": "UP" if up else "DOWN", "ema21": round(e21, 2), "ema8": round(e8, 2),
        "entryLo": entry_lo, "entryHi": entry_hi, "breakout": breakout,
        "hi20": round(hi20, 2), "lo20": round(lo20, 2),
        "status": status, "note": note,
        "lastBar": bars[-1].get("t", ""),
    }


if __name__ == "__main__":
    from zoneinfo import ZoneInfo
    now_et = datetime.now(ZoneInfo("America/New_York"))
    mode = ah.session_state(now_et)

    syms, seen = [], set()
    for s in CORE + watchlist():
        if s not in seen:
            seen.add(s); syms.append(s)
    syms = syms[:MAX_SYMS]
    bars = fetch_bars(syms)
    rows = []
    for s in syms:
        row = analyze(s, bars.get(s, []))
        if row:
            row["source"] = BAR_SOURCE.get(s, "shared bars")
        if not row:                                         # shared loader could not serve it
            row = analyze(s, fetch_yahoo_bars(s.replace(".", "-")))
            if row:
                row["source"] = "yahoo (not Robinhood)"
        if row:
            rows.append(row)
    for disp, ysym in FUTURES.items():                      # MNQ etc via Yahoo
        row = analyze(disp, fetch_yahoo_bars(ysym))
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
            # remedial W4 item 20: "now" is a send-guarded live price with its source + ET time; without one the
            # card says it's the bar close (the zone itself is computed from daily bars).
            try:
                from price_guard import fresh
                live = fresh([r["sym"]]).get(r["sym"].upper()) or {}
            except Exception:
                live = {}
            now_s = (f"now ${live['price']:g} · {live['src']}" if live.get("ok") else
                     f"last bar close ${r['price']} ({r.get('source', 'daily')} bars, no live price)")
            msg = (f"🎯 {r['sym']} ENTERED the entry zone ${r['entryLo']}–${r['entryHi']} "
                   f"({now_s}, RSI {r['rsi']}, was {prev.get(r['sym'])})\n"
                   f"uptrend pullback to the 21-day line "
                   f"(evidence, not a trade call).")   # 2026-10-08 audit F15: zone was printed twice
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
    if now_et.hour == 7:
        buyable = [r for r in rows if r["status"] in ("AT ENTRY", "OVERSOLD")]
        if buyable:
            buyable.sort(key=lambda r: (r["status"] != "AT ENTRY", r["sym"]))
            lines = ["🌅 ENTRY RADAR — buyable at the open", ""]
            for r in buyable:
                tag = "🎯 AT ENTRY" if r["status"] == "AT ENTRY" else "🩹 OVERSOLD"
                lines.append(f"{tag} {r['sym']} ${r['price']} (RSI {r['rsi']})")
                lines.append(f"   zone ${r['entryLo']}–${r['entryHi']}")
                lines.append(f"   {r['note']}")
            lines.append("")
            lines.append("Don't chase. Advisory only.")
            try:
                subprocess.run([os.path.join(HOME, "bin", "tg-send-msg"), "\n".join(lines)],
                               timeout=20, check=False)
                print(f"morning roster sent: {len(buyable)} buyable")
            except Exception as e:
                print(f"morning roster send failed: {e}")
        else:
            print("morning roster: nothing AT ENTRY/OVERSOLD — staying silent")

    # After-hours/weekend context: how stretched are index futures since the
    # last settle, so the zones below (computed off Friday's daily bar) come
    # with a "what's the tape doing right now" gut check. rth runs omit it.
    futures_lean = None
    if mode != "rth":
        fut = ah.futures(["ES=F", "NQ=F"])
        futures_lean = {
            sym.replace("=F", ""): {
                "chgPct": v.get("chgPct"),
                "direction": "up" if (v.get("chgPct") or 0) >= 0 else "down",
            }
            for sym, v in fut.items()
        }

    doc = {
        "updated": now_et.isoformat(),
        "rows": rows,
        "mode": mode,
        "asOf": now_et.isoformat(),
        "nextSession": ah.next_session_label(now_et),
        "futuresLean": futures_lean,
    }
    fd, tmp = tempfile.mkstemp(dir=os.path.dirname(OUT))
    with os.fdopen(fd, "w") as f:
        json.dump(doc, f)
    os.replace(tmp, OUT)
    print(f"wrote {len(rows)} rows: " + ", ".join(f"{r['sym']}:{r['status']}" for r in rows))
