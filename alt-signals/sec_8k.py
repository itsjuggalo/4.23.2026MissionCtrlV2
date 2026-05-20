#!/usr/bin/env python3
"""
SEC 8-K live-feed ingester (Tier 2).

Polls SEC EDGAR Atom feed every 10 minutes for new 8-K filings.
Each 8-K is mapped to a ticker via CIK lookup (cached). Items listed in
the filing (1.01 acquisition, 2.02 results, 5.02 exec changes, etc.) drive
the quality score.

Run:
  python3 sec_8k.py
or via uv:
  uv run sec_8k.py
"""
# /// script
# requires-python = ">=3.10"
# dependencies = []
# ///
from __future__ import annotations

import sys
import re
from pathlib import Path
from datetime import datetime, timezone
from xml.etree import ElementTree as ET

sys.path.insert(0, str(Path(__file__).parent))
import _lib

SOURCE = "sec_8k"

# Item-code → (display, quality score) — higher score = more material event
ITEM_SCORES = {
    "1.01": ("material definitive agreement", 70),
    "1.02": ("termination of material agreement", 75),
    "1.03": ("bankruptcy or receivership", 95),
    "2.01": ("acquisition or disposition", 80),
    "2.02": ("earnings release", 75),
    "2.03": ("creation of material obligation", 60),
    "2.04": ("triggering events for obligations", 80),
    "2.05": ("costs of exit/disposal", 65),
    "2.06": ("material impairment", 80),
    "3.01": ("delisting notice or transfer", 90),
    "3.02": ("unregistered equity sale", 60),
    "3.03": ("material modification to rights", 70),
    "4.01": ("change in auditor", 75),
    "4.02": ("non-reliance on prior financials", 95),
    "5.01": ("change in control", 90),
    "5.02": ("dep/elect officer/director", 75),
    "5.03": ("amendment to articles/bylaws", 50),
    "7.01": ("regulation FD disclosure", 50),
    "8.01": ("other events", 40),
}

# Items that should NEVER go to Discord (too noisy)
PUSH_BLOCKLIST = {"7.01", "8.01", "5.03"}

EDGAR_FEED = "https://www.sec.gov/cgi-bin/browse-edgar?action=getcurrent&type=8-K&company=&dateb=&owner=include&count=100&output=atom"
ATOM_NS = {"a": "http://www.w3.org/2005/Atom"}

ITEM_RE = re.compile(r"Item\s+(\d+\.\d{2})", re.IGNORECASE)

# CIK→ticker cache (built once, refreshed weekly)
CIK_MAP_URL = "https://www.sec.gov/files/company_tickers.json"
CIK_CACHE = _lib.STATE_DIR / "cik_to_ticker.json"


def load_cik_to_ticker() -> dict[str, str]:
    """Refresh cache weekly."""
    import json
    if CIK_CACHE.exists():
        age = (datetime.now(timezone.utc).timestamp()
               - CIK_CACHE.stat().st_mtime)
        if age < 7 * 86400:
            try:
                return json.loads(CIK_CACHE.read_text())
            except Exception:
                pass
    try:
        raw = _lib.http_get(CIK_MAP_URL, accept="application/json")
        data = json.loads(raw)
        # data is keyed by row number; values are {cik_str, ticker, title}
        mapping = {}
        for v in data.values():
            cik = str(v.get("cik_str", "")).zfill(10)
            tk = v.get("ticker", "").upper()
            if cik and tk:
                mapping[cik] = tk
        CIK_CACHE.write_text(json.dumps(mapping))
        return mapping
    except Exception as e:
        print(f"[sec_8k] CIK map refresh failed: {e}", file=sys.stderr)
        if CIK_CACHE.exists():
            try:
                return json.loads(CIK_CACHE.read_text())
            except Exception:
                pass
        return {}


def parse_atom_entries(xml_text: str) -> list[dict]:
    entries = []
    try:
        root = ET.fromstring(xml_text)
    except ET.ParseError as e:
        print(f"[sec_8k] atom parse error: {e}", file=sys.stderr)
        return entries
    for entry in root.findall("a:entry", ATOM_NS):
        title = (entry.findtext("a:title", "", ATOM_NS) or "").strip()
        summary = (entry.findtext("a:summary", "", ATOM_NS) or "").strip()
        link_el = entry.find("a:link", ATOM_NS)
        href = link_el.get("href") if link_el is not None else ""
        updated = (entry.findtext("a:updated", "", ATOM_NS) or "").strip()
        accession_id = (entry.findtext("a:id", "", ATOM_NS) or "").strip()
        # Try to pull CIK from the summary's accession path
        m = re.search(r"/data/(\d+)/", href)
        cik = m.group(1).zfill(10) if m else ""
        entries.append({
            "title": title,
            "summary": summary,
            "href": href,
            "updated": updated,
            "id": accession_id,
            "cik": cik,
        })
    return entries


def score_filing(items_found: list[str]) -> tuple[float, str]:
    """Return (max_quality_score, display_string)."""
    if not items_found:
        return 40.0, "8-K (no items parsed)"
    items_scored = [(it, ITEM_SCORES.get(it, ("other", 40))) for it in items_found]
    items_scored.sort(key=lambda x: x[1][1], reverse=True)
    top = items_scored[0]
    if len(items_scored) == 1:
        return float(top[1][1]), f"Item {top[0]} ({top[1][0]})"
    rest = ", ".join(it for it, _ in items_scored[1:3])
    return float(top[1][1]), f"Item {top[0]} ({top[1][0]}) +{rest}"


def main() -> int:
    cik_to_ticker = load_cik_to_ticker()
    if not cik_to_ticker:
        print("[sec_8k] WARN: empty CIK map — filings will be unsymboled")

    try:
        feed = _lib.http_get(EDGAR_FEED, accept="application/atom+xml")
    except Exception as e:
        print(f"[sec_8k] feed fetch failed: {e}", file=sys.stderr)
        return 1

    entries = parse_atom_entries(feed)
    new_count = pushed = 0
    blocked_items_only = 0

    state = _lib.load_state(SOURCE, {"seen_ids": []})
    seen = set(state.get("seen_ids", []))

    for e in entries:
        if e["id"] in seen:
            continue
        seen.add(e["id"])

        items_found = sorted(set(ITEM_RE.findall(e["title"] + " " + e["summary"])))
        score, display = score_filing(items_found)
        ticker = cik_to_ticker.get(e["cik"], None)

        headline = f"{ticker or e['cik']}: {display}"
        if ticker:
            headline = f"{ticker} — {display}"

        sig_id, is_new = _lib.upsert_alt_signal(
            source=SOURCE,
            symbol=ticker,
            direction=None,
            headline=headline,
            url=e["href"],
            raw={
                "title": e["title"],
                "items": items_found,
                "cik": e["cik"],
                "updated": e["updated"],
            },
            quality_score=score,
            ts=e["updated"] or _lib.utc_now_iso(),
            dedup_key=e["id"],
        )
        if is_new:
            new_count += 1
            push_eligible = bool(items_found and not all(it in PUSH_BLOCKLIST for it in items_found))
            if push_eligible:
                if _lib.push_if_top(
                    sig_id, source=SOURCE, symbol=ticker,
                    headline=headline, quality_score=score, url=e["href"],
                ):
                    pushed += 1
            else:
                blocked_items_only += 1

    # Trim seen state to last 2000
    state["seen_ids"] = sorted(seen)[-2000:]
    _lib.save_state(SOURCE, state)
    _lib.log_event(SOURCE, "tick", {
        "entries": len(entries),
        "new": new_count,
        "pushed": pushed,
        "blocked_only": blocked_items_only,
    })
    print(f"[sec_8k] entries={len(entries)} new={new_count} pushed={pushed}")
    return 0


if __name__ == "__main__":
    sys.exit(main())
