#!/usr/bin/env python3
"""Browser-free AI-Themes generator for MissionCtrl (?page=ai-themes).

WHY THIS EXISTS: the original themes source (ainvest_refresh.py harvest_baskets)
scrapes ainvest.com through the logged-in opencli/Chrome bridge. When Mike's
Chrome isn't open+logged-in (e.g. after a WSL restart), the harvest returns 0
baskets and the page goes BLANK. This generator is the ALWAYS-ON primary source:
a curated set of thematic baskets whose 3-mo returns are computed from Yahoo's
public chart endpoint (no key, no browser). The ainvest bridge harvest stays as
optional enrichment but can never blank the page (empty-guard, see ainvest_refresh).

Schema written == exactly what /api/ai-themes + AIThemesPage.tsx expect:
  {"categories":[...], "baskets":[{category,name,slug,count,ret_3mo,tickers}]}

Empty-guard: if we cannot compute returns for ANY basket (network down), we KEEP
the existing file rather than clobber it with empties.
"""
import json, time, urllib.request, urllib.error
from pathlib import Path

OUT = Path("/AIWorkWSL/web/missionctrl/data/ainvest-themes.json")
UA = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0 Safari/537.36"

# Curated thematic baskets — current (2026) market themes, equal-weight.
# (category-slug, display name, tickers)
THEMES = [
    ("ai-infrastructure", "AI Infrastructure",   ["NVDA","AMD","AVGO","MRVL","TSM","SMCI","DELL","ANET","VRT","MU"]),
    ("semiconductors",     "Semiconductors",      ["NVDA","AMD","AVGO","TSM","MU","AMAT","LRCX","KLAC","ASML","INTC","QCOM","TXN"]),
    ("quantum-computing",  "Quantum Computing",   ["IONQ","RGTI","QBTS","QUBT","IBM","GOOGL"]),
    ("nuclear-uranium",    "Nuclear & Uranium",   ["CCJ","LEU","OKLO","SMR","NNE","UEC","VST","CEG","TLN"]),
    ("robotics-automation","Robotics & Automation",["ISRG","ABB","ROK","TER","NVDA","TSLA","SERV"]),
    ("cybersecurity",      "Cybersecurity",       ["CRWD","PANW","ZS","FTNT","NET","S","OKTA","CYBR"]),
    ("crypto-equities",    "Crypto Equities",     ["COIN","MSTR","MARA","RIOT","CLSK","HOOD","BITF","HUT"]),
    ("defense-aerospace",  "Defense & Aerospace", ["LMT","RTX","NOC","GD","LHX","BA","PLTR","KTOS","AVAV"]),
    ("datacenter-power",   "Datacenter Power",    ["VST","CEG","NRG","TLN","GEV","ETN","PWR","VRT"]),
    ("obesity-glp1",       "Obesity / GLP-1",     ["LLY","NVO","VKTX","AMGN","ZBH"]),
    ("ev-battery",         "EV & Battery",        ["TSLA","RIVN","LCID","ALB","QS","ENPH","FSLR"]),
    ("space-economy",      "Space Economy",       ["RKLB","LUNR","ASTS","PLTR","RDW","BKSY"]),
    ("megacap-tech",       "Megacap Tech",        ["AAPL","MSFT","GOOGL","AMZN","META","NVDA","TSLA","AVGO"]),
    ("software-saas",      "Software / SaaS",     ["CRM","NOW","SNOW","DDOG","MDB","NET","PLTR","ADBE"]),
]


def ret_3mo(sym):
    """3-month % return from Yahoo public chart (close[-1]/close[0]-1). None on failure."""
    url = f"https://query1.finance.yahoo.com/v8/finance/chart/{sym}?range=3mo&interval=1d"
    try:
        req = urllib.request.Request(url, headers={"User-Agent": UA})
        with urllib.request.urlopen(req, timeout=12) as r:
            d = json.load(r)
        res = d["chart"]["result"][0]
        closes = [c for c in res["indicators"]["quote"][0]["close"] if c is not None]
        if len(closes) < 2:
            return None
        return round(100 * (closes[-1] / closes[0] - 1), 1)
    except Exception:
        return None


def main():
    # one fetch per unique ticker (cached), then equal-weight basket return
    uniq = sorted({t for _, _, ts in THEMES for t in ts})
    rets = {}
    for i, t in enumerate(uniq):
        rets[t] = ret_3mo(t)
        time.sleep(0.25)  # be polite to Yahoo
    ok = sum(1 for v in rets.values() if v is not None)
    print(f"fetched {ok}/{len(uniq)} ticker returns")

    baskets = []
    for slug, name, tickers in THEMES:
        vals = [rets[t] for t in tickers if rets.get(t) is not None]
        ret = round(sum(vals) / len(vals), 1) if vals else None
        baskets.append({
            "category": slug, "name": name, "slug": slug,
            "count": len(tickers), "ret_3mo": ret, "tickers": tickers,
        })

    have_returns = sum(1 for b in baskets if b["ret_3mo"] is not None)
    if have_returns == 0:
        print("EMPTY-GUARD: 0 baskets got returns (network down?) — KEEPING existing file, not clobbering.")
        return

    out = {"categories": [b["category"] for b in baskets], "baskets": baskets,
           "source": "curated+yahoo", "generated": int(time.time())}
    OUT.write_text(json.dumps(out))
    print(f"WROTE {OUT} — {len(baskets)} baskets, {have_returns} with returns")


if __name__ == "__main__":
    main()
