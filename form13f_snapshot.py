#!/usr/bin/env python3
"""
form13f_snapshot.py — pull recent 13F-HR filings from SEC EDGAR (FREE) for a set
of notable funds, map mega-cap CUSIPs → tickers, and append their holdings to
~/.openclaw/state/sec_scanner/form13f_log.jsonl. The missionctrl /api/consensus
route reads this log as the `institutional13F` source (7-day window, so only
recently-filed 13Fs contribute — 13F is quarterly + ~45-day lagged).

Honest about limits: 13F holdings are reported by CUSIP, so we only emit tickers
for the ~30 mega-caps in CUSIP_MAP (where the bulk of institutional value sits);
other holdings are skipped, never guessed. We log a fund's TOP holdings as
action="add" (they are long the name) timestamped at the filing date.

Run: ~/.venv/bin/python ~/scripts/form13f_snapshot.py
"""
import json, os, time, re, urllib.request
try:
    import defusedxml.ElementTree as ET   # XXE-safe
except Exception:
    import xml.etree.ElementTree as ET    # SEC is trusted; fallback

LOG = os.path.expanduser("~/.openclaw/state/sec_scanner/form13f_log.jsonl")
UA = "MissionControl Research mike@itsjuggalo.com"
TOP_N = 8

# notable funds by SEC CIK
FUNDS = {
    "Berkshire Hathaway": "0001067983",
    "Scion (Burry)":      "0001649339",
    "Pershing Square":    "0001336528",
    "Bridgewater":        "0001350694",
    "Coatue":             "0001135730",
}

# CUSIP → ticker for the mega-caps that dominate 13F value (no guessing beyond these)
CUSIP_MAP = {
    "037833100": "AAPL", "594918104": "MSFT", "67066G104": "NVDA", "023135106": "AMZN",
    "02079K305": "GOOGL", "02079K107": "GOOG", "30303M102": "META", "88160R101": "TSLA",
    "084670702": "BRK.B", "46625H100": "JPM", "92826C839": "V", "91324P102": "UNH",
    "30231G102": "XOM", "478160104": "JNJ", "931142103": "WMT", "57636Q104": "MA",
    "742718109": "PG", "437076102": "HD", "11135F101": "AVGO", "22160K105": "COST",
    "68389X105": "ORCL", "58933Y105": "MRK", "00287Y109": "ABBV", "166764100": "CVX",
    "191216100": "KO", "713448108": "PEP", "00724F101": "ADBE", "64110L106": "NFLX",
    "007903107": "AMD", "79466L302": "CRM", "46625H100b": "JPM", "92343V104": "VZ",
    "17275R102": "CSCO", "459200101": "IBM", "20030N101": "CMCSA", "871829107": "SYK",
}


def fetch(url, tries=3):
    headers = {
        "User-Agent": UA,
        "Accept": "application/json, text/xml, text/html, */*",
        "Accept-Language": "en-US,en;q=0.9",
        "Host": url.split("/")[2],
    }
    last = None
    for i in range(tries):
        try:
            req = urllib.request.Request(url, headers=headers)
            with urllib.request.urlopen(req, timeout=25) as r:
                return r.read()
        except Exception as e:
            last = e
            time.sleep(1.0 + i)   # SEC throttles; back off
    raise last


def latest_13f(cik):
    """Return (accession_no_nodash, filing_date) of the most recent 13F-HR, or None."""
    cik10 = cik.zfill(10)
    sub = json.loads(fetch(f"https://data.sec.gov/submissions/CIK{cik10}.json"))
    recent = sub.get("filings", {}).get("recent", {})
    forms = recent.get("form", [])
    accns = recent.get("accessionNumber", [])
    dates = recent.get("filingDate", [])
    # pick the 13F-HR with the LATEST filing date (don't trust array order)
    best = None
    for i, f in enumerate(forms):
        if f.startswith("13F-HR"):
            if best is None or dates[i] > dates[best]:
                best = i
    return (accns[best].replace("-", ""), dates[best]) if best is not None else None


def infotable_holdings(cik, accn):
    """Fetch the filing's info-table XML and return [(cusip, value)] sorted desc by value."""
    cik_int = str(int(cik))
    base = f"https://www.sec.gov/Archives/edgar/data/{cik_int}/{accn}"
    idx = json.loads(fetch(f"{base}/index.json"))
    xml_name = None
    for item in idx.get("directory", {}).get("item", []):
        n = item.get("name", "")
        nl = n.lower()
        # the holdings file is an .xml that is NOT the primary_doc / header
        if nl.endswith(".xml") and ("infotable" in nl or "form13f" in nl or "table" in nl) and "primary_doc" not in nl:
            xml_name = n
            break
    if not xml_name:
        return []
    raw = fetch(f"{base}/{xml_name}").decode("utf-8", "ignore")
    raw = re.sub(r'xmlns(:\w+)?="[^"]*"', "", raw)   # drop xmlns declarations
    raw = re.sub(r'<(/?)\w+:', r'<\1', raw)          # drop element prefixes (ns1:infoTable -> infoTable)
    raw = re.sub(r'(\s)\w+:(\w+\s*=)', r'\1\2', raw) # drop attribute prefixes (xsi:type -> type)
    root = ET.fromstring(raw)
    out = []
    for it in root.iter("infoTable"):
        cusip = (it.findtext("cusip") or "").strip().upper()
        valnode = it.find("value")
        val = float(valnode.text) if valnode is not None and valnode.text else 0.0
        if cusip:
            out.append((cusip, val))
    # aggregate duplicate cusips, sort by value desc
    agg = {}
    for c, v in out:
        agg[c] = agg.get(c, 0.0) + v
    return sorted(agg.items(), key=lambda x: -x[1])


def main():
    os.makedirs(os.path.dirname(LOG), exist_ok=True)
    # de-dupe key = fund|ticker|filing_date (don't double-log the same quarter)
    seen = set()
    if os.path.exists(LOG):
        for ln in open(LOG):
            try:
                e = json.loads(ln)
                seen.add(f"{e.get('fund')}|{e.get('ticker')}|{e.get('filed')}")
            except Exception:
                pass
    new_rows = []
    for fund, cik in FUNDS.items():
        try:
            latest = latest_13f(cik)
            if not latest:
                continue
            accn, fdate = latest
            holds = infotable_holdings(cik, accn)
            mapped = [(CUSIP_MAP[c], v) for c, v in holds if c in CUSIP_MAP][:TOP_N]
            for tk, v in mapped:
                key = f"{fund}|{tk}|{fdate}"
                if key in seen:
                    continue
                seen.add(key)
                new_rows.append({
                    "ts": fdate + "T12:00:00", "ticker": tk, "fund": fund,
                    "action": "add", "value_usd_k": int(v), "filed": fdate, "source": "13F-HR",
                })
            time.sleep(0.3)   # be polite to EDGAR
        except Exception as e:
            print(f"  {fund}: skip ({str(e)[:80]})")
    if new_rows:
        with open(LOG, "a") as f:
            for r in new_rows:
                f.write(json.dumps(r) + "\n")
    print(f"appended {len(new_rows)} 13F rows to {LOG}")
    if not os.path.exists(LOG):
        print("  (no log yet — no notable fund had a parseable recent 13F)")
        return
    # show how many fall in the live 7-day window
    cutoff = time.time() - 7 * 86400
    recent = 0
    for ln in open(LOG):
        try:
            e = json.loads(ln)
            if time.mktime(time.strptime(e["filed"], "%Y-%m-%d")) >= cutoff:
                recent += 1
        except Exception:
            pass
    print(f"  {recent} rows within the live 7-day consensus window")


if __name__ == "__main__":
    main()
