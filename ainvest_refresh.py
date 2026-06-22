#!/usr/bin/env python3
"""AInvest → MissionCtrl data refresh.

Writes two page-data files the dashboard reads (data/*.json, gitignored):
  • ainvest-themes.json   — AInvest AI-Screener thematic baskets (logged-in bridge)
  • ainvest-options.json  — OUR confluence (Value/Sentiment/Activity) on live-flow tickers,
                            built from local feeds (AInvest's own option scores are paywalled).

Usage:
  ainvest_refresh.py all                 # baskets (slow, ~10m bridge) + confluence
  ainvest_refresh.py themes              # fresh bridge harvest of baskets
  ainvest_refresh.py themes --from-cache # transform last scrape (fast, no bridge)
  ainvest_refresh.py options             # confluence only (fast, local feeds)
"""
import json, re, subprocess, sys, time
from pathlib import Path

OPENCLI = "/home/itsju/.nvm/versions/node/v22.22.3/bin/opencli"
S = "vc2uw7en"
REPO_DATA = Path("/AIWorkWSL/web/missionctrl/data")
THEMES_OUT = REPO_DATA / "ainvest-themes.json"
OPTIONS_OUT = REPO_DATA / "ainvest-options.json"
SCRAPE_CACHE = Path.home() / "scrapes" / "ainvest.com" / "screener-baskets.json"
TOP_N_CONSTITUENTS = 80

CATEGORIES = [
 "thematic-sector-rotation","congress-trading","swing-trading","technical-patterns",
 "momentum-stocks","dividend-investing","corporate-events-catalysts","ai-screeners",
 "options-derivatives-trading","robotics-hardware-stocks","growth-innovation-stocks",
 "analyst-institutional-activity","international-emerging-markets",
 "clean-energy-sustainability","value-investing",
]
DENY = set(("BUY SELL SPY QQQ DIA IWM AI USD ET EOD PM AM RSI MACD ETF US NY EPS WF WFF LEGAL "
 "AIME PE PS YTD CEO CFO IPO FDA SEC AND THE FOR NEW TOP ALL PRO BETA NYSE NASDAQ BATS GLD IEF "
 "GTM TTM TAM ARR MOM WOW QOQ "
 "VIXY BTC ETH OI IV HV DTE ATH EV TAM ROE ROI Q1 Q2 Q3 Q4 FY YOY GDP CPI FED").split())

# ── bridge helpers ─────────────────────────────────────────────────────────
def ev(js, timeout=40):
    try:
        r = subprocess.run([OPENCLI,"browser",S,"eval",js],capture_output=True,text=True,timeout=timeout).stdout
        m = re.search(r'(\[.*\]|\{.*\})', r, re.S)
        return json.loads(m.group(1)) if m else None
    except Exception as e:
        print(f"  eval err: {e}", file=sys.stderr); return None

def opentab(url):
    # navigate the SINGLE bound session tab in place (NOT `tab new` — that spawned
    # one tab per basket, 80+ tabs). `open` reuses the existing tab.
    subprocess.run([OPENCLI,"browser",S,"open",url],capture_output=True,text=True,timeout=50)
    time.sleep(4.5)

def clean_tickers(syms, cap):
    out=[]
    for s in syms or []:
        if s in DENY or len(s) < 2:  # drop 1-letter noise (R/D from "R&D")
            continue
        if s not in out:
            out.append(s)
    return out[:cap or 50]

# pull constituent tickers from the real DOM ticker-cells (not innerText regex),
# scrolling to load virtualized rows. Far cleaner than the old /\b[A-Z]{1,5}\b/ scan
# (which swept up TTM/GTM/R&D noise). Selector verified live on ainvest screener baskets.
_PULL = ("JSON.stringify([...new Set([...document.querySelectorAll('[class*=ticker],[class*=Ticker]')]"
         ".map(e=>(e.innerText||'').trim()).filter(t=>/^[A-Z]{1,6}(\\.[A-Z])?$/.test(t)))])")
def basket_tickers(url, cap):
    opentab(url)
    syms=set(ev(_PULL) or [])
    for _ in range(3):                      # scroll to pull virtualized rows
        ev("(()=>{window.scrollBy(0,1600);return 1})()", timeout=15)
        time.sleep(1.4)
        syms.update(ev(_PULL) or [])
    return clean_tickers(sorted(syms), cap)

# ── themes: harvest baskets via the logged-in bridge ───────────────────────
def harvest_baskets():
    baskets=[]
    for cat in CATEGORIES:
        opentab(f"https://www.ainvest.com/screener/stocks/category-{cat}/")
        cards = ev("JSON.stringify([...document.querySelectorAll('a')]"
                   ".map(a=>({t:(a.innerText||'').trim(),h:a.href}))"
                   ".filter(x=>/\\/screener\\/stocks\\/[a-z0-9-]+\\/$/.test(x.h)&&!/category-/.test(x.h)&&x.t.length>3))")
        seen=set()
        for c in cards or []:
            slug=c["h"].rstrip("/").split("/")[-1]
            if slug in seen: continue
            seen.add(slug)
            raw=c["t"]
            ret=re.search(r'([+-]?\d+(?:\.\d+)?)%', raw)
            cnt=re.search(r'\n(\d+)\n', raw)
            baskets.append({"category":cat,"name":raw.split("\n")[0].strip(),"slug":slug,
                            "url":c["h"],"count":int(cnt.group(1)) if cnt else None,
                            "ret_3mo":float(ret.group(1)) if ret else None,"constituents":[]})
        print(f"[cat] {cat}: +{len(seen)}")
    uniq={b["slug"]:b for b in baskets}; baskets=list(uniq.values())
    ranked=sorted([b for b in baskets if b["ret_3mo"] is not None],key=lambda b:abs(b["ret_3mo"]),reverse=True)[:TOP_N_CONSTITUENTS]
    for b in ranked:
        b["constituents"]=basket_tickers(b["url"], b.get("count"))
        print(f"[tickers] {b['slug']}: {len(b['constituents'])}")
    SCRAPE_CACHE.write_text(json.dumps({"source":"ainvest.com/screener","baskets":baskets},indent=1))
    return baskets

def write_themes(baskets):
    cats=[]
    for b in baskets:
        if b["category"] not in cats: cats.append(b["category"])
    out={"categories":cats,
         "baskets":[{"category":b["category"],"name":b["name"],"slug":b["slug"],
                     "count":b["count"],"ret_3mo":b["ret_3mo"],
                     "tickers":clean_tickers(b.get("constituents") or b.get("tickers"), b.get("count"))}
                    for b in baskets]}
    THEMES_OUT.write_text(json.dumps(out))
    print(f"WROTE {THEMES_OUT} — {len(out['baskets'])} baskets, {sum(1 for b in out['baskets'] if b['tickers'])} w/tickers")

# ── options: OUR confluence from local feeds ───────────────────────────────
FLOW = "/home/ubuntu/mission-control-restored/Option-Signals-Scraper/data/flow_alerts_history.json"
AINVEST_CACHE = "/AIWorkWSL/web/missionctrl/data/ainvest_cache.json"
IV = "/AIWorkWSL/labs/quantum/out/iv_forecast.json"
OCC = re.compile(r'^([A-Z]+)\d{6}[CP]\d+$')

def _load(p):
    try: return json.load(open(p))
    except Exception: return None

def build_confluence():
    flow=_load(FLOW) or {}
    # activity: distinct contracts + update volume per underlying
    act={}
    for occ,v in (flow.items() if isinstance(flow,dict) else []):
        m=OCC.match(occ)
        if not m: continue
        t=m.group(1)
        a=act.setdefault(t,{"contracts":0,"updates":0})
        a["contracts"]+=1; a["updates"]+=int(v.get("num_updates",0) or 0)
    if not act:
        OPTIONS_OUT.write_text(json.dumps({"benchmark":None,"rows":[]})); print("no flow"); return
    # percentile-rank activity → 0-10
    order=sorted(act, key=lambda t:act[t]["contracts"])
    n=len(order); rank={t:i for i,t in enumerate(order)}
    def activity_score(t): return round(10*rank[t]/max(1,n-1),1)
    # sentiment from analyst consensus
    ac=_load(AINVEST_CACHE) or {}; analyst=ac.get("analyst",{}) if isinstance(ac,dict) else {}
    def sentiment_score(t):
        a=analyst.get(t)
        if not a: return None
        tot=(a.get("buy",0)+a.get("hold",0)+a.get("sell",0)) or 1
        return round(10*a.get("buy",0)/tot,1)
    # value from iv_forecast tier + ivRank (low rank = cheap = good)
    ivd=_load(IV) or {}; ivmap={}
    for p in ivd.get("picks",[]):
        tier=p.get("tier"); base={"VERIFIED":8,"FLAG":5,"VETO":2}.get(tier,5)
        r=(p.get("ivRank") or {}).get("ivRank")
        if isinstance(r,(int,float)): base=base + (1.5 if r<35 else -1.5 if r>65 else 0)
        ivmap[p.get("ticker")]=max(0,min(10,round(base,1)))
    def value_score(t): return ivmap.get(t)
    rows=[]
    for t in act:
        if act[t]["contracts"]<2 and t not in analyst and t not in ivmap:
            continue  # too thin + no other signal
        a=activity_score(t); s=sentiment_score(t); val=value_score(t)
        present=[(a,0.4)]+([(s,0.3)] if s is not None else [])+([(val,0.3)] if val is not None else [])
        cov=len(present)  # 1-3 signals present (activity always counts)
        w=sum(p[1] for p in present)
        raw=sum(p[0]*p[1] for p in present)/w if w else 0
        cov_factor=0.8+0.2*(cov-1)/2  # 1 sig→0.8x, 2→0.9x, 3→1.0x: confluence outranks lone signals
        comp=round(raw*cov_factor,1) if w else None
        rows.append({"ticker":t,"value":val,"sentiment":s,"activity":a,"composite":comp,"coverage":cov,
                     "_contracts":act[t]["contracts"]})
    rows.sort(key=lambda r:(r["composite"] if r["composite"] is not None else -1),reverse=True)
    rows=rows[:60]
    for r in rows: r.pop("_contracts",None)
    bm=next((r for r in rows if r["ticker"]=="SPY"),None)
    OPTIONS_OUT.write_text(json.dumps({"benchmark":bm,"rows":rows}))
    print(f"WROTE {OPTIONS_OUT} — {len(rows)} tickers (confluence from flow+analyst+iv)")

# ── main ───────────────────────────────────────────────────────────────────
if __name__=="__main__":
    mode = sys.argv[1] if len(sys.argv)>1 else "all"
    from_cache = "--from-cache" in sys.argv
    if mode in ("themes","all"):
        if from_cache:
            b=(_load(SCRAPE_CACHE) or {}).get("baskets",[]); write_themes(b)
        else:
            write_themes(harvest_baskets())
    if mode in ("options","all"):
        build_confluence()
