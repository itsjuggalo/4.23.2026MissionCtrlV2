#!/usr/bin/env python3
"""dashboard_data_refresh.py — rebuild ~/.openclaw/workspace/directives/dashboard_data.json

The old producer died with the Oracle cutover (file froze 2026-05-11) while the
missionctrl Command Center kept rendering its analyst/earnings/insider intel as
current. This is the replacement, cron-driven on the laptop (source-of-record
box). Free Finnhub endpoints only; same output contract the page already reads:

  { updated, news[], quotes{SYM:{price,change_p,volume,source}},
    intel{SYM:{symbol, analyst{strongBuy,buy,hold,sell,strongSell,total,buyPct},
               earnings{actual,estimate,surprisePct,period,beat},
               metrics{pe,high52,low52,beta},
               insider{direction,mspr}, news[]}} }

Symbols: the Command Center default watchlist. Override with a one-per-line
~/portfolio/cc_watchlist.txt if the watchlist ever changes.
Rate budget: ~5 syms x 5 calls + 1 general-news = ~26 calls/run (free tier: 60/min).
"""
import json, os, sys, time, tempfile, urllib.request, urllib.parse
from datetime import datetime, timedelta

HOME = os.path.expanduser("~")
OUT = os.path.join(HOME, ".openclaw/workspace/directives/dashboard_data.json")
KEY_FILE = os.path.join(HOME, ".openclaw/secrets/finnhub-api-key.txt")
WATCH_FILE = os.path.join(HOME, "portfolio/cc_watchlist.txt")
DEFAULT_SYMS = ["AAPL", "NVDA", "TSLA", "MU", "LLY"]
BASE = "https://finnhub.io/api/v1"


def key() -> str:
    k = open(KEY_FILE).read().strip()
    if not k:
        sys.exit("no finnhub key")
    return k


def get(path: str, **params):
    params["token"] = KEY
    url = f"{BASE}{path}?{urllib.parse.urlencode(params)}"
    for attempt in range(3):
        try:
            with urllib.request.urlopen(url, timeout=20) as r:
                return json.load(r)
        except Exception:
            if attempt == 2:
                return None
            time.sleep(2 * (attempt + 1))


def symbols():
    try:
        syms = [s.strip().upper() for s in open(WATCH_FILE) if s.strip()]
        if syms:
            return syms[:10]
    except OSError:
        pass
    return DEFAULT_SYMS


def build_intel(sym: str):
    out = {"symbol": sym}
    rec = get("/stock/recommendation", symbol=sym) or []
    if rec:
        r = rec[0]  # newest month
        total = sum(r.get(k, 0) for k in ("strongBuy", "buy", "hold", "sell", "strongSell"))
        if total:
            out["analyst"] = {
                "strongBuy": r.get("strongBuy", 0), "buy": r.get("buy", 0),
                "hold": r.get("hold", 0), "sell": r.get("sell", 0),
                "strongSell": r.get("strongSell", 0), "total": total,
                "buyPct": round((r.get("strongBuy", 0) + r.get("buy", 0)) / total * 100),
            }
    earn = get("/stock/earnings", symbol=sym) or []
    if earn:
        e = earn[0]
        if e.get("actual") is not None and e.get("estimate"):
            surprise = (e["actual"] - e["estimate"]) / abs(e["estimate"]) * 100
            out["earnings"] = {
                "actual": e["actual"], "estimate": e["estimate"],
                "surprisePct": round(surprise, 1), "period": e.get("period", ""),
                "beat": e["actual"] >= e["estimate"],
            }
    met = (get("/stock/metric", symbol=sym, metric="all") or {}).get("metric", {})
    if met:
        out["metrics"] = {
            "pe": met.get("peTTM"), "high52": met.get("52WeekHigh"),
            "low52": met.get("52WeekLow"), "beta": met.get("beta"),
        }
    ins = (get("/stock/insider-sentiment", symbol=sym,
               **{"from": (datetime.now() - timedelta(days=90)).strftime("%Y-%m-%d"),
                  "to": datetime.now().strftime("%Y-%m-%d")}) or {}).get("data", [])
    if ins:
        mspr = round(sum(d.get("mspr", 0) for d in ins) / len(ins), 1)
        out["insider"] = {"direction": "BUYING" if mspr > 0 else "SELLING", "mspr": mspr}
    frm = (datetime.now() - timedelta(days=5)).strftime("%Y-%m-%d")
    news = get("/company-news", symbol=sym, **{"from": frm, "to": datetime.now().strftime("%Y-%m-%d")}) or []
    out["news"] = [
        {"headline": n.get("headline", ""), "source": n.get("source", ""),
         "url": n.get("url", ""),
         "time": datetime.fromtimestamp(n.get("datetime", 0)).strftime("%m/%d %H:%M")}
        for n in news[:5]
    ]
    return out


def build_quotes(syms):
    q = {}
    for s in syms:
        d = get("/quote", symbol=s)
        if d and d.get("c"):
            q[s] = {"price": d["c"], "change_p": d.get("dp", 0), "volume": 0, "source": "Finnhub"}
    return q


def build_general_news():
    news = get("/news", category="general") or []
    return [
        {"time": datetime.fromtimestamp(n.get("datetime", 0)).strftime("%H:%M"),
         "headline": n.get("headline", ""), "source": n.get("source", ""), "url": n.get("url", "")}
        for n in news[:14]
    ]


if __name__ == "__main__":
    KEY = key()
    syms = symbols()
    doc = {
        "updated": datetime.now().astimezone().isoformat(),
        "news": build_general_news(),
        "quotes": build_quotes(syms),
        "intel": {s: build_intel(s) for s in syms},
    }
    # Sanity gate: refuse to overwrite a good file with an empty shell (API down).
    if not doc["intel"] or not any("analyst" in v or "earnings" in v for v in doc["intel"].values()):
        sys.exit("refusing to write: no intel returned (API down?)")
    fd, tmp = tempfile.mkstemp(dir=os.path.dirname(OUT))
    with os.fdopen(fd, "w") as f:
        json.dump(doc, f)
    os.replace(tmp, OUT)
    print(f"wrote {OUT}: {len(doc['intel'])} syms, {len(doc['news'])} headlines")
