#!/usr/bin/env python3
"""
Mission Control Calendar Scraper v3
Primary source: AInvest API (earnings, economic, dividends, IPO)
Secondary: Finnhub (broader date range), known events (FOMC, CPI, NFP, crypto)
"""
import json, os, time
from datetime import datetime, timedelta
from pathlib import Path
try:
    import requests
except ImportError:
    os.system("pip3 install requests --break-system-packages -q")
    import requests

DATA_DIR = Path.home() / "mission-control-restored" / "data"
DATA_DIR.mkdir(parents=True, exist_ok=True)
OUTPUT_FILE = DATA_DIR / "calendar_events.json"
SECRETS_DIR = Path.home() / ".openclaw" / "secrets"

def get_secret(name):
    p = SECRETS_DIR / name
    return p.read_text().strip() if p.exists() else None

AINVEST_KEY = get_secret("ainvest_api_key")
FINNHUB_KEY = get_secret("finnhub_api_key") or "d70ov6hr01ql6rg044qgd70ov6hr01ql6rg044r0"
NOW = datetime.now()

KNOWN_ECONOMIC = [
    {"date":"2026-01-28","title":"FOMC Rate Decision","detail":"Fed interest rate announcement","importance":"high"},
    {"date":"2026-03-18","title":"FOMC Rate Decision","detail":"Fed interest rate announcement","importance":"high"},
    {"date":"2026-05-06","title":"FOMC Rate Decision","detail":"Fed interest rate announcement","importance":"high"},
    {"date":"2026-06-17","title":"FOMC Rate Decision","detail":"Fed interest rate announcement","importance":"high"},
    {"date":"2026-07-29","title":"FOMC Rate Decision","detail":"Fed interest rate announcement","importance":"high"},
    {"date":"2026-09-16","title":"FOMC Rate Decision","detail":"Fed interest rate announcement","importance":"high"},
    {"date":"2026-11-04","title":"FOMC Rate Decision","detail":"Fed interest rate announcement","importance":"high"},
    {"date":"2026-12-16","title":"FOMC Rate Decision","detail":"Fed interest rate announcement","importance":"high"},
    {"date":"2026-01-14","title":"CPI Report","detail":"Consumer Price Index (Dec)","importance":"high"},
    {"date":"2026-02-12","title":"CPI Report","detail":"Consumer Price Index (Jan)","importance":"high"},
    {"date":"2026-03-11","title":"CPI Report","detail":"Consumer Price Index (Feb)","importance":"high"},
    {"date":"2026-04-10","title":"CPI Report","detail":"Consumer Price Index (Mar)","importance":"high"},
    {"date":"2026-05-13","title":"CPI Report","detail":"Consumer Price Index (Apr)","importance":"high"},
    {"date":"2026-06-10","title":"CPI Report","detail":"Consumer Price Index (May)","importance":"high"},
    {"date":"2026-07-14","title":"CPI Report","detail":"Consumer Price Index (Jun)","importance":"high"},
    {"date":"2026-08-12","title":"CPI Report","detail":"Consumer Price Index (Jul)","importance":"high"},
    {"date":"2026-09-11","title":"CPI Report","detail":"Consumer Price Index (Aug)","importance":"high"},
    {"date":"2026-10-13","title":"CPI Report","detail":"Consumer Price Index (Sep)","importance":"high"},
    {"date":"2026-11-12","title":"CPI Report","detail":"Consumer Price Index (Oct)","importance":"high"},
    {"date":"2026-12-10","title":"CPI Report","detail":"Consumer Price Index (Nov)","importance":"high"},
    {"date":"2026-01-09","title":"Non-Farm Payrolls","detail":"US Jobs Report (Dec)","importance":"high"},
    {"date":"2026-02-06","title":"Non-Farm Payrolls","detail":"US Jobs Report (Jan)","importance":"high"},
    {"date":"2026-03-06","title":"Non-Farm Payrolls","detail":"US Jobs Report (Feb)","importance":"high"},
    {"date":"2026-04-03","title":"Non-Farm Payrolls","detail":"US Jobs Report (Mar)","importance":"high"},
    {"date":"2026-05-08","title":"Non-Farm Payrolls","detail":"US Jobs Report (Apr)","importance":"high"},
    {"date":"2026-06-05","title":"Non-Farm Payrolls","detail":"US Jobs Report (May)","importance":"high"},
    {"date":"2026-07-02","title":"Non-Farm Payrolls","detail":"US Jobs Report (Jun)","importance":"high"},
    {"date":"2026-08-07","title":"Non-Farm Payrolls","detail":"US Jobs Report (Jul)","importance":"high"},
    {"date":"2026-09-04","title":"Non-Farm Payrolls","detail":"US Jobs Report (Aug)","importance":"high"},
    {"date":"2026-10-02","title":"Non-Farm Payrolls","detail":"US Jobs Report (Sep)","importance":"high"},
    {"date":"2026-11-06","title":"Non-Farm Payrolls","detail":"US Jobs Report (Oct)","importance":"high"},
    {"date":"2026-12-04","title":"Non-Farm Payrolls","detail":"US Jobs Report (Nov)","importance":"high"},
    {"date":"2026-01-29","title":"GDP Q4 2025 (Advance)","detail":"GDP first estimate","importance":"high"},
    {"date":"2026-04-29","title":"GDP Q1 2026 (Advance)","detail":"GDP first estimate","importance":"high"},
    {"date":"2026-07-30","title":"GDP Q2 2026 (Advance)","detail":"GDP first estimate","importance":"high"},
    {"date":"2026-10-29","title":"GDP Q3 2026 (Advance)","detail":"GDP first estimate","importance":"high"},
    {"date":"2026-01-30","title":"PCE Price Index","detail":"Personal Consumption Expenditures (Dec)","importance":"high"},
    {"date":"2026-02-27","title":"PCE Price Index","detail":"Personal Consumption Expenditures (Jan)","importance":"high"},
    {"date":"2026-03-27","title":"PCE Price Index","detail":"Personal Consumption Expenditures (Feb)","importance":"high"},
    {"date":"2026-04-30","title":"PCE Price Index","detail":"Personal Consumption Expenditures (Mar)","importance":"high"},
    {"date":"2026-05-29","title":"PCE Price Index","detail":"Personal Consumption Expenditures (Apr)","importance":"high"},
    {"date":"2026-06-26","title":"PCE Price Index","detail":"Personal Consumption Expenditures (May)","importance":"high"},
    {"date":"2026-07-31","title":"PCE Price Index","detail":"Personal Consumption Expenditures (Jun)","importance":"high"},
    {"date":"2026-04-09","title":"PPI Report","detail":"Producer Price Index (Mar)","importance":"medium"},
    {"date":"2026-05-14","title":"PPI Report","detail":"Producer Price Index (Apr)","importance":"medium"},
    {"date":"2026-06-11","title":"PPI Report","detail":"Producer Price Index (May)","importance":"medium"},
    {"date":"2026-04-15","title":"Retail Sales","detail":"US Retail Sales (Mar)","importance":"medium"},
    {"date":"2026-05-15","title":"Retail Sales","detail":"US Retail Sales (Apr)","importance":"medium"},
    {"date":"2026-04-01","title":"ISM Manufacturing PMI","detail":"Institute for Supply Management","importance":"medium"},
    {"date":"2026-05-01","title":"ISM Manufacturing PMI","detail":"Institute for Supply Management","importance":"medium"},
    {"date":"2026-04-07","title":"JOLTS Job Openings","detail":"Job Openings & Labor Turnover","importance":"medium"},
    {"date":"2026-05-05","title":"JOLTS Job Openings","detail":"Job Openings & Labor Turnover","importance":"medium"},
    {"date":"2026-04-28","title":"Consumer Confidence","detail":"Conference Board Index","importance":"medium"},
    {"date":"2026-05-26","title":"Consumer Confidence","detail":"Conference Board Index","importance":"medium"},
    {"date":"2026-03-20","title":"Quad Witching","detail":"Quarterly options/futures expiration","importance":"high"},
    {"date":"2026-04-17","title":"Monthly Options Expiration","detail":"Standard monthly expiry","importance":"medium"},
    {"date":"2026-05-15","title":"Monthly Options Expiration","detail":"Standard monthly expiry","importance":"medium"},
    {"date":"2026-06-19","title":"Quad Witching","detail":"Quarterly options/futures expiration","importance":"high"},
    {"date":"2026-04-03","title":"Market Closed — Good Friday","detail":"NYSE/NASDAQ closed","importance":"low"},
    {"date":"2026-05-25","title":"Market Closed — Memorial Day","detail":"NYSE/NASDAQ closed","importance":"low"},
]

KNOWN_CRYPTO = [
    {"date":"2026-04-15","title":"US Tax Day — Crypto Sell Pressure","detail":"Tax deadline historically causes selling","ticker":"BTC","importance":"medium"},
    {"date":"2026-04-19","title":"BTC Halving 2-Year Anniversary","detail":"2 years since April 2024 halving","ticker":"BTC","importance":"high"},
    {"date":"2026-04-28","title":"CME BTC Futures Expiry","detail":"Monthly Bitcoin futures expiration","ticker":"BTC","importance":"medium"},
    {"date":"2026-04-30","title":"Binance BNB Burn (Q1)","detail":"Quarterly BNB token burn","ticker":"BNB","importance":"medium"},
    {"date":"2026-05-01","title":"ETH Pectra Upgrade Window","detail":"Ethereum protocol upgrade","ticker":"ETH","importance":"high"},
    {"date":"2026-05-29","title":"CME BTC Futures Expiry","detail":"Monthly Bitcoin futures expiration","ticker":"BTC","importance":"medium"},
    {"date":"2026-06-01","title":"XRP Escrow Release","detail":"Monthly Ripple escrow unlock (~1B XRP)","ticker":"XRP","importance":"medium"},
    {"date":"2026-06-26","title":"CME BTC Quarterly Futures Expiry","detail":"Quarterly expiration — high volume","ticker":"BTC","importance":"high"},
    {"date":"2026-07-01","title":"SOL Token Unlock","detail":"Major Solana token unlock event","ticker":"SOL","importance":"high"},
]

# ─── AInvest API ──────────────────────────────────────────

def ainvest_get(endpoint, params):
    if not AINVEST_KEY:
        return None
    try:
        r = requests.get(
            f"https://openapi.ainvest.com/open/{endpoint}",
            params=params,
            headers={"Authorization": f"Bearer {AINVEST_KEY}"},
            timeout=15
        )
        if r.status_code == 200:
            d = r.json(); return (d.get("data") or {}).get("data", []) if isinstance(d, dict) else []
    except Exception as ex:
        print(f"  [ainvest] {endpoint} error: {ex}")
    return []

def scrape_ainvest_earnings(dates):
    events = []
    for d in dates:
        ds = d.strftime("%Y-%m-%d")
        data = ainvest_get("calendar/earnings", {"date": ds})
        if data:
            for e in data:
                eps_est = e.get("eps_forecast")
                eps_act = e.get("eps_actual")
                eps_surp = e.get("eps_surprise")
                rev_act = e.get("revenue_actual")
                rev_est = e.get("revenue_forecast")
                rev_surp = e.get("revenue_surprise")

                detail_parts = []
                if eps_est is not None:
                    detail_parts.append(f"EPS Est: {eps_est:.2f}")
                if eps_act is not None:
                    detail_parts.append(f"Act: {eps_act:.2f}")
                if eps_surp is not None:
                    pct = eps_surp * 100
                    detail_parts.append(f"Surp: {pct:+.1f}%")
                if rev_act and rev_act > 0:
                    rev_b = rev_act / 1e9
                    detail_parts.append(f"Rev: ${rev_b:.1f}B" if rev_b >= 1 else f"Rev: ${rev_act/1e6:.0f}M")

                beat = None
                if eps_surp is not None:
                    beat = "beat" if eps_surp > 0 else "miss" if eps_surp < 0 else "meet"

                events.append({
                    "date": ds,
                    "category": "earnings",
                    "ticker": e.get("ticker", ""),
                    "title": f"{e.get('ticker','')} {e.get('period_name','')} Earnings",
                    "detail": " | ".join(detail_parts) if detail_parts else "Earnings report",
                    "time": "",
                    "importance": "high" if (rev_act and rev_act > 5e9) else "medium",
                    "eps_forecast": eps_est,
                    "eps_actual": eps_act,
                    "eps_surprise": eps_surp,
                    "revenue_actual": rev_act,
                    "revenue_forecast": rev_est,
                    "revenue_surprise": rev_surp,
                    "beat_miss": beat,
                })
        time.sleep(0.3)
    print(f"[ainvest] Earnings: {len(events)} events from {len(dates)} days")
    return events

def scrape_ainvest_economic(dates):
    events = []
    for d in dates:
        ds = d.strftime("%Y-%m-%d")
        data = ainvest_get("calendar/economics", {"date": ds})
        if data:
            for e in data:
                imp = e.get("importance", 1)
                imp_str = "high" if imp >= 3 else "medium" if imp >= 2 else "low"
                detail_parts = []
                if e.get("previous") is not None:
                    detail_parts.append(f"Prev: {e['previous']}")
                if e.get("forecast") is not None:
                    detail_parts.append(f"Est: {e['forecast']}")
                if e.get("actual") is not None:
                    detail_parts.append(f"Act: {e['actual']}")

                events.append({
                    "date": ds,
                    "category": "economic",
                    "ticker": "",
                    "title": e.get("index", ""),
                    "detail": " | ".join(detail_parts) if detail_parts else "",
                    "time": "",
                    "importance": imp_str,
                    "actual": e.get("actual"),
                    "forecast": e.get("forecast"),
                    "previous": e.get("previous"),
                })
        time.sleep(0.3)
    print(f"[ainvest] Economic: {len(events)} events from {len(dates)} days")
    return events

def scrape_ainvest_dividends(dates):
    events = []
    for d in dates:
        ds = d.strftime("%Y-%m-%d")
        data = ainvest_get("calendar/dividends", {"date": ds})
        if data:
            for e in data:
                amt = e.get("amount", 0)
                events.append({
                    "date": ds,
                    "category": "dividend",
                    "ticker": e.get("ticker", ""),
                    "title": f"{e.get('ticker','')} Ex-Dividend",
                    "detail": f"${amt:.2f}/share | Pay: {e.get('pay_date','')}",
                    "time": "",
                    "importance": "low",
                    "amount": amt,
                    "pay_date": e.get("pay_date", ""),
                })
        time.sleep(0.3)
    print(f"[ainvest] Dividends: {len(events)} events from {len(dates)} days")
    return events

def scrape_ainvest_ipo(dates):
    events = []
    for d in dates:
        ds = d.strftime("%Y-%m-%d")
        data = ainvest_get("calendar/ipo", {"date": ds})
        if data:
            for e in data:
                events.append({
                    "date": ds,
                    "category": "ipo",
                    "ticker": e.get("ticker", "") or e.get("symbol", ""),
                    "title": f"{e.get('ticker','') or e.get('symbol','')} {e.get('name','')}".strip(),
                    "detail": e.get("price_range", "Price: TBD"),
                    "time": "",
                    "importance": "medium",
                })
        time.sleep(0.3)
    print(f"[ainvest] IPO: {len(events)} events from {len(dates)} days")
    return events

# ─── Finnhub (broader range) ─────────────────────────────

def scrape_finnhub_earnings_range(from_d, to_d):
    events = []
    try:
        r = requests.get("https://finnhub.io/api/v1/calendar/earnings",
            params={"from": from_d, "to": to_d, "token": FINNHUB_KEY}, timeout=15)
        if r.status_code == 200:
            for x in r.json().get("earningsCalendar", []):
                eps = x.get("epsEstimate")
                rev = x.get("revenueEstimate")
                d = []
                if eps is not None: d.append(f"EPS Est: {eps}")
                if rev is not None: d.append(f"Rev: ${rev/1e9:.1f}B" if rev and rev > 1e9 else f"Rev: ${rev/1e6:.0f}M" if rev else "")
                events.append({
                    "date": x.get("date", ""),
                    "category": "earnings",
                    "ticker": x.get("symbol", ""),
                    "title": f"{x.get('symbol','')} Earnings",
                    "detail": " | ".join([i for i in d if i]) or "Earnings report",
                    "time": x.get("hour", ""),
                    "importance": "high" if (rev and rev > 5e9) else "medium",
                })
    except Exception as ex:
        print(f"[finnhub] earnings error: {ex}")
    return events

# ─── Build ────────────────────────────────────────────────

def dedup(events):
    seen = set()
    out = []
    for e in events:
        k = f"{e['date']}_{e.get('category','')}_{e.get('ticker','')}_{e.get('title','')}"
        if k not in seen:
            seen.add(k)
            out.append(e)
    return out

def build_summaries(events):
    s = {}
    for e in events:
        if not e.get("date"): continue
        mk = e["date"][:7]
        if mk not in s:
            s[mk] = {"earnings": 0, "economic": 0, "crypto": 0, "dividend": 0, "ipo": 0}
        c = e.get("category", "")
        if c in s[mk]:
            s[mk][c] += 1
    return s

def main():
    print(f"\n{'='*60}")
    print(f"[calendar] Scraper v3 (AInvest + Finnhub + Known)")
    print(f"[calendar] {NOW.isoformat()}")
    print(f"{'='*60}\n")

    all_events = []

    # Generate date lists
    # AInvest: 14 days back + 45 days forward (weekdays only to reduce calls)
    ainvest_dates = []
    for offset in range(-14, 46):
        d = NOW + timedelta(days=offset)
        if d.weekday() < 5:  # Mon-Fri only
            ainvest_dates.append(d)
    print(f"[calendar] AInvest scanning {len(ainvest_dates)} weekdays...")

    # AInvest earnings (richest data)
    if AINVEST_KEY:
        all_events.extend(scrape_ainvest_earnings(ainvest_dates))
        all_events.extend(scrape_ainvest_economic(ainvest_dates))
        all_events.extend(scrape_ainvest_dividends(ainvest_dates))
        all_events.extend(scrape_ainvest_ipo(ainvest_dates))
    else:
        print("[calendar] WARNING: No AInvest API key found, falling back to Finnhub only")

    # Finnhub for extended range (months Ainvest doesn't cover)
    print("[calendar] Finnhub extended range...")
    for s, e in [(45, 90), (90, 120)]:
        fd = (NOW + timedelta(days=s)).strftime("%Y-%m-%d")
        td = (NOW + timedelta(days=e)).strftime("%Y-%m-%d")
        fh = scrape_finnhub_earnings_range(fd, td)
        print(f"  [finnhub] {fd} to {td}: {len(fh)} earnings")
        all_events.extend(fh)
        time.sleep(1)

    # Known economic events
    for e in KNOWN_ECONOMIC:
        all_events.append({
            "date": e["date"], "category": "economic", "ticker": "",
            "title": e["title"], "detail": e["detail"],
            "time": "", "importance": e["importance"]
        })
    print(f"[calendar] Known economic: {len(KNOWN_ECONOMIC)}")

    # Known crypto events
    for e in KNOWN_CRYPTO:
        all_events.append({
            "date": e["date"], "category": "crypto", "ticker": e.get("ticker", ""),
            "title": e["title"], "detail": e["detail"],
            "time": "", "importance": e["importance"]
        })
    print(f"[calendar] Known crypto: {len(KNOWN_CRYPTO)}")

    # Weekly jobless claims (Thursdays, 3 months)
    d = NOW - timedelta(days=NOW.weekday()) + timedelta(days=3)
    if d < NOW: d += timedelta(days=7)
    claims_count = 0
    for _ in range(13):
        all_events.append({
            "date": d.strftime("%Y-%m-%d"), "category": "economic", "ticker": "",
            "title": "Initial Jobless Claims", "detail": "Weekly unemployment claims (8:30 AM ET)",
            "time": "08:30", "importance": "low"
        })
        d += timedelta(days=7)
        claims_count += 1
    print(f"[calendar] Weekly claims: {claims_count}")

    # Clean, dedup, sort
    all_events = [e for e in all_events if e.get("date")]
    all_events = dedup(all_events)
    all_events.sort(key=lambda x: x["date"])
    summaries = build_summaries(all_events)

    output = {
        "last_updated": NOW.isoformat(),
        "total_events": len(all_events),
        "scraper_version": "3.0",
        "sources": ["ainvest", "finnhub", "known-calendar"],
        "month_summaries": summaries,
        "events": all_events
    }

    with open(OUTPUT_FILE, "w") as f:
        json.dump(output, f, indent=2)

    print(f"\n{'='*60}")
    print(f"[calendar] DONE — {len(all_events)} total events")
    print(f"[calendar] -> {OUTPUT_FILE}")
    for m, c in sorted(summaries.items()):
        print(f"  {m}: {sum(c.values())} total — {c}")
    print(f"{'='*60}\n")

if __name__ == "__main__":
    main()
