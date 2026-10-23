"""news — live, ticker-tagged market headlines for the Telegram briefs.

One shared, best-effort source of news so every brief can carry the same real
headlines instead of training-data guesses. Source chain (first non-empty wins):

  1. Alpaca news (Benzinga)  — real-time, ticker-tagged. Primary. (paper keys on disk)
  2. Finnhub company-news    — per-symbol headlines. Catalyst-grade fallback.
  3. SearXNG (self-hosted)   — FREE local news search (categories=news). Cuts the Tavily bill.
  4. Tavily news search      — broad web news. (tvly key on disk)
  5. Yahoo / yfinance        — last-resort, no key.

Stdlib-only core (urllib) so it imports under every brief's interpreter (system
python3, ~/.venv, the digest PY). yfinance is an OPTIONAL import (try/except).

NEVER raises — this is alert-only enrichment; a news outage must never break a brief.

  from lib.news import recent_headlines, headlines_block
  print(headlines_block(["NVDA", "AAPL", "SPY"]))
"""
from __future__ import annotations

import json
import re
import urllib.parse
import urllib.request
from datetime import datetime, timezone
from pathlib import Path

SEC = Path.home() / ".openclaw" / "secrets"
_UA = "mc-news/1.0"


# ─── secrets ───────────────────────────────────────────────────────────────
def _read(*names: str) -> str | None:
    for name in names:
        for n in (name, name + ".txt"):
            p = SEC / n
            if p.exists():
                v = p.read_text().strip()
                if v:
                    return v
    return None


def _finnhub_key() -> str | None:
    return _read("finnhub.key", "finnhub_api_key", "finnhub-api-key", "FINNHUB_API_KEY")


def _tavily_key() -> str | None:
    return _read("tavily.key", "tavily")


# ─── http ──────────────────────────────────────────────────────────────────
def _get(url: str, headers: dict | None = None, timeout: int = 15):
    try:
        req = urllib.request.Request(url, headers={"User-Agent": _UA, **(headers or {})})
        with urllib.request.urlopen(req, timeout=timeout) as r:
            return json.loads(r.read())
    except Exception:
        return None


def _post(url: str, payload: dict, timeout: int = 15):
    try:
        req = urllib.request.Request(
            url, data=json.dumps(payload).encode(),
            headers={"User-Agent": _UA, "Content-Type": "application/json"})
        with urllib.request.urlopen(req, timeout=timeout) as r:
            return json.loads(r.read())
    except Exception:
        return None


# ─── time helpers ──────────────────────────────────────────────────────────
def _now() -> float:
    return datetime.now(timezone.utc).timestamp()


def _epoch(val) -> float:
    """Best-effort → epoch seconds (UTC). Unparseable → now (so it isn't dropped)."""
    if val is None or val == "":
        return _now()
    if isinstance(val, (int, float)):
        return float(val)
    s = str(val).strip()
    try:
        return datetime.fromisoformat(s.replace("Z", "+00:00")).timestamp()
    except Exception:
        pass
    for fmt in ("%a, %d %b %Y %H:%M:%S %Z", "%a, %d %b %Y %H:%M:%S GMT",
                "%Y-%m-%dT%H:%M:%S", "%Y-%m-%d %H:%M:%S", "%Y-%m-%d"):
        try:
            return datetime.strptime(s[:len(fmt) + 6], fmt).replace(tzinfo=timezone.utc).timestamp()
        except Exception:
            continue
    return _now()


def _age(epoch: float) -> str:
    secs = max(0, _now() - epoch)
    if secs < 3600:
        return f"{int(secs // 60)}m"
    if secs < 86400:
        return f"{int(secs // 3600)}h"
    return f"{int(secs // 86400)}d"


# ─── sources (each returns a list of normalized dicts or []) ────────────────
def _norm(ticker, headline, source, url, epoch) -> dict:
    return {"ticker": (ticker or "").upper(), "headline": (headline or "").strip(),
            "source": source or "news", "url": url or "", "epoch": float(epoch)}


_NAMES: dict | None = None
_GENERIC = {"THE", "FIRST", "AMERICAN", "UNITED", "GLOBAL", "INTERNATIONAL", "NATIONAL", "GENERAL", "NEW", "BANK",
            "TRUST", "GROUP", "HOLDINGS", "CAPITAL", "ENERGY", "DIGITAL", "DATA", "TECHNOLOGIES", "TECHNOLOGY"}


def _company_word(sym: str) -> str | None:
    """First distinctive word of the SEC company name ("MARVELL TECHNOLOGY, INC." -> "MARVELL"), or None."""
    global _NAMES
    if _NAMES is None:
        try:
            _NAMES = json.loads((Path.home() / "LapClaw/pipeline/data/sec_company_tickers.json").read_text())
        except Exception:
            _NAMES = {}
    title = (_NAMES.get(sym) or {}).get("title") or ""
    for w in re.findall(r"[A-Za-z][A-Za-z&'-]{2,}", title):
        if w.upper() not in _GENERIC:
            return w.upper()
    return None


def names_ticker(sym: str, headline: str) -> bool:
    """True when the headline itself names `sym` (the ticker or its company's first distinctive word)."""
    if re.search(rf"(?<![A-Za-z]){re.escape(sym)}(?![A-Za-z])", headline or ""):
        return True
    w = _company_word(sym)
    return bool(w and re.search(rf"(?<![A-Za-z]){re.escape(w)}", (headline or "").upper()))


def _tag(syms: list[str], reqset: set, headline: str) -> str:
    """Ticker tag for an article. Alpaca lists every ticker an article touches, so a roundup about Marvell carries
    INTC/AMD/NVDA too (10-06 digest: "[INTC] Marvell Stock Rallies..."). Tag a requested ticker only when the
    headline names it, or when the article lists at most 2 tickers; otherwise the first ticker the headline names;
    otherwise none (market-wide)."""
    named = [s for s in syms if s in reqset and names_ticker(s, headline)]
    if named:
        return named[0]
    if len(syms) <= 2:
        hit = next((s for s in syms if s in reqset), None)
        if hit:
            return hit
    return next((s for s in syms if names_ticker(s, headline)), "")


def _finnhub(symbols: list[str], hours: int) -> list[dict]:
    key = _finnhub_key()
    if not key or not symbols:
        return []
    today = datetime.now(timezone.utc).date()
    frm = today.fromordinal(today.toordinal() - max(1, hours // 24 + 1))
    out = []
    for sym in symbols[:6]:                       # cap calls
        url = (f"https://finnhub.io/api/v1/company-news?symbol={sym}"
               f"&from={frm}&to={today}&token={key}")
        for it in (_get(url) or [])[:10]:
            out.append(_norm(sym, it.get("headline"), it.get("source"),
                             it.get("url"), _epoch(it.get("datetime"))))
    return out


def _tavily(symbols: list[str], max_items: int) -> list[dict]:
    key = _tavily_key()
    if not key:
        return []
    q = ("latest market news " + " ".join(symbols[:6])) if symbols else "stock market news today"
    j = _post("https://api.tavily.com/search",
              {"api_key": key, "query": q, "topic": "news",
               "max_results": max(max_items, 8), "days": 2})
    out = []
    for it in (j or {}).get("results", []) or []:
        out.append(_norm("", it.get("title"), (it.get("url") or "").split("/")[2] if it.get("url") else "news",
                         it.get("url"), _epoch(it.get("published_date"))))
    return out


def _searxng(symbols: list[str], hours: int,
             base: str = "http://127.0.0.1:8888") -> list[dict]:
    """Free self-hosted SearXNG news search (categories=news → real publishedDate).
    Fires before Tavily to cut the paid bill; only as good as the local engine is up."""
    import os
    base = (os.getenv("SEARXNG_URL", base) or base).rstrip("/")
    out = []
    syms = symbols[:5] if symbols else [""]
    for sym in syms:
        q = f"{sym} stock news" if sym else "stock market news today"
        url = base + "/search?" + urllib.parse.urlencode(
            {"q": q, "categories": "news", "format": "json"})
        data = _get(url, {"Accept": "application/json"})
        for it in (data or {}).get("results", [])[:8]:
            out.append(_norm(sym, it.get("title"), it.get("engine") or "news",
                             it.get("url"), _epoch(it.get("publishedDate"))))
    return out


def _yahoo(symbols: list[str]) -> list[dict]:
    try:
        import yfinance as yf
    except Exception:
        return []
    out = []
    for sym in (symbols or ["SPY"])[:5]:
        try:
            for it in (yf.Ticker(sym).news or [])[:5]:
                c = it.get("content", it)            # yfinance 1.x nests under content
                title = c.get("title") or it.get("title")
                pub = (c.get("provider", {}) or {}).get("displayName") or it.get("publisher") or "Yahoo"
                link = ((c.get("canonicalUrl") or {}).get("url")
                        or (c.get("clickThroughUrl") or {}).get("url") or it.get("link") or "")
                ts = it.get("providerPublishTime") or c.get("pubDate")
                out.append(_norm(sym, title, pub, link, _epoch(ts)))
        except Exception:
            continue
    return out


# ─── public API ────────────────────────────────────────────────────────────
def recent_headlines(symbols=None, max_items: int = 6, hours: int = 24) -> list[dict]:
    """Fresh, ticker-tagged headlines for `symbols` (str or list). First source with
    in-window results wins (Finnhub → SearXNG → Tavily → Yahoo; Alpaca news leg removed 2026-10-22). Newest-first, deduped,
    capped at `max_items`. Returns [] on total miss — never raises."""
    if isinstance(symbols, str):
        symbols = [s.strip().upper() for s in symbols.replace(",", " ").split() if s.strip()]
    symbols = [s.upper() for s in (symbols or [])]
    cutoff = _now() - hours * 3600

    for source in (lambda: _finnhub(symbols, hours),
                   lambda: _searxng(symbols, hours),
                   lambda: _tavily(symbols, max_items),
                   lambda: _yahoo(symbols)):
        try:
            items = source() or []
        except Exception:
            items = []
        fresh = [it for it in items if it.get("headline") and it["epoch"] >= cutoff]
        if not fresh:
            continue
        # requested-ticker headlines first, then newest; dedup by headline
        reqset = set(symbols)
        fresh.sort(key=lambda x: (0 if x["ticker"] in reqset else 1, -x["epoch"]))
        seen, uniq = set(), []
        for it in fresh:
            key = it["headline"].lower()[:80]
            if key in seen:
                continue
            seen.add(key)
            uniq.append(it)
        return uniq[:max_items]
    return []


def headlines_block(symbols=None, title: str = "📰 HEADLINES",
                    max_items: int = 4, hours: int = 24, html: bool = False,
                    links: bool = True, maxlen: int = 120, only: bool = False) -> str:
    """Telegram-ready headlines block for `symbols`. Returns "" when nothing fresh
    (callers can append unconditionally — empty means no header, no noise).

    html=True   → HTML-escaped (safe to append to an HTML parse_mode message).
    links=False → drop the <a href> wrapper (still escaped) for a compact footer that
                  fits a tight char budget (e.g. the near-4096 BEST-3 digest).
    maxlen      → per-headline truncation (lower it for tighter footers)."""
    items = recent_headlines(symbols, max_items=max_items * 4 if only else max_items, hours=hours)
    if only:   # only headlines tagged to a requested ticker (no market-wide fill under a ticker title)
        want = {s.upper() for s in ([symbols] if isinstance(symbols, str) else symbols or [])}
        items = [it for it in items if it["ticker"] in want][:max_items]
    if not items:
        return ""
    lines = [title]
    for it in items:
        tag = f"[{it['ticker']}] " if it["ticker"] else ""
        head = it["headline"][:maxlen].rstrip()
        if len(it["headline"]) > maxlen:
            head += "…"
        if html:
            from html import escape
            body = (f"<a href=\"{escape(it['url'])}\">{escape(head)}</a>"
                    if links and it["url"] else escape(head))
            lines.append(f"• {escape(tag)}{body} — {escape(it['source'])} · {_age(it['epoch'])}")
        else:
            lines.append(f"• {tag}{head} — {it['source']} · {_age(it['epoch'])}")
    return "\n".join(lines)


if __name__ == "__main__":
    import sys
    syms = sys.argv[1:] or ["NVDA", "AAPL", "SPY"]
    print(headlines_block(syms) or "(no fresh headlines)")
