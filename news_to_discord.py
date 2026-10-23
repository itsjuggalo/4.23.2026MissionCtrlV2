#!/usr/bin/env python3
"""news_to_discord.py — market-news feed → Discord #research-feed.

Pulls market/company headlines (Finnhub free news; migrated from Alpaca news 2026-10-22) and posts
the new ones to #research-feed via the existing research webhook. Dedupes by news
id (state file) and caps per run so it never floods. Cron one-shot (no always-on
PM2 process — the laptop is RAM-marginal).

Source: Finnhub company-news (watched tickers) + general market news.

Reuses the canonical poster lib/discord_post.py (fixes the urllib-403 UA footgun).
Posts to an EXISTING channel via the EXISTING webhook — creates/edits no channels.
"""
from __future__ import annotations

import json
import os
import sys
import urllib.request
import urllib.parse
from datetime import datetime, timedelta, timezone
from zoneinfo import ZoneInfo
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parent))
from lib.discord_post import post_discord  # noqa: E402

ET = ZoneInfo("America/New_York")
SEC = Path.home() / ".openclaw" / "secrets"
STATE = Path.home() / ".openclaw" / "state" / "news_to_discord_seen.json"
WEBHOOK = "discord_webhook_research.txt"   # → #research-feed (verified 2026-06-14)
MAX_PER_RUN = 6                            # newest-unseen cap so it never floods
MAX_SEEN = 4000
NEWS_LIMIT = 50


def _read(name: str) -> str:
    for n in (name, name + ".txt"):
        p = SEC / n
        if p.exists():
            v = p.read_text().strip()
            if v:
                return v
    return ""


def _finnhub_key() -> str:
    return _read("finnhub.key") or _read("finnhub_api_key") or _read("finnhub-api-key") or _read("FINNHUB_API_KEY")


def watch_tickers(n: int = 8) -> list[str]:
    """Watchlist + live flow-relay tickers, padded with a static index fallback.
    Was lib.portfolio.top_tickers (Alpaca paper holdings, capital-ranked); retired
    2026-09-15 — portfolio views retired site-wide 2026-09-12, no live holdings
    feed exists to rank against."""
    tk: list[str] = []
    try:
        wl = json.loads((Path.home() / ".openclaw" / "data" / "watchlist.json").read_text())
        tk += [str(t).upper() for t in wl]
    except Exception:
        pass
    try:
        req = urllib.request.Request("http://localhost:3000/api/firebase-relay",
                                     headers={"User-Agent": "mc-news/1.0"})
        with urllib.request.urlopen(req, timeout=6) as r:
            j = json.loads(r.read())
        for sig in (j or {}).get("signals", []) or []:
            t = str((sig or {}).get("ticker", "")).upper()
            if t and t not in tk:
                tk.append(t)
    except Exception:
        pass
    for d in ("SPY", "QQQ", "IWM", "DIA"):
        if d not in tk:
            tk.append(d)
    return tk[:n]


def _fh_get(path: str, **q):
    k = _finnhub_key()
    if not k:
        print("[news] no finnhub key on disk", flush=True)
        return []
    url = "https://finnhub.io/api/v1/" + path + "?" + urllib.parse.urlencode({**q, "token": k})
    try:
        with urllib.request.urlopen(urllib.request.Request(url, headers={"User-Agent": "mc-news/1.0"}), timeout=20) as r:
            return json.loads(r.read()) or []
    except Exception as e:  # noqa: BLE001
        print(f"[news] finnhub {path} failed: {type(e).__name__}", flush=True)
        return []


def _norm(it: dict, syms: list[str]) -> dict:
    ts = datetime.fromtimestamp(int(it.get("datetime") or 0), ET)
    return {"id": f"fh:{it.get('id')}", "headline": it.get("headline") or "(no headline)",
            "source": it.get("source") or "news", "url": it.get("url") or "",
            "created_at": ts.isoformat(timespec="minutes"), "symbols": syms}


def fetch_news(symbols: list[str] | None = None):
    """Finnhub (free): company-news per watched ticker, or the general market feed when none given.
    Replaces Alpaca news (market-data rule: Alpaca is not a data source where a free replacement exists)."""
    if not symbols:
        return [_norm(it, [x for x in (it.get("related") or "").split(",") if x])
                for it in _fh_get("news", category="general")][:NEWS_LIMIT]
    today = datetime.now(ET).date()
    frm = today - timedelta(days=1)
    out = []
    for sym in symbols[:8]:
        out += [_norm(it, [sym]) for it in _fh_get("company-news", symbol=sym, **{"from": frm, "to": today})[:10]]
    return out


def load_seen():
    try:
        return set(json.loads(STATE.read_text()))
    except Exception:
        return set()


def save_seen(seen):
    STATE.parent.mkdir(parents=True, exist_ok=True)
    arr = list(seen)[-MAX_SEEN:]
    tmp = STATE.with_suffix(".tmp")
    tmp.write_text(json.dumps(arr))
    os.replace(tmp, STATE)


def fmt(item, watched: bool = False) -> str:
    head = item.get("headline", "(no headline)")
    src = item.get("source", "news")
    syms = ", ".join(item.get("symbols", [])[:6])
    url = item.get("url", "")
    ts = item.get("created_at", "")[:16].replace("T", " ")
    tag = f" · {syms}" if syms else ""
    icon = "⭐ WATCHED" if watched else "📰"
    return f"{icon} **{head}**\n{src} · {ts} ET{tag}\n{url}".strip()


def main():
    import argparse
    ap = argparse.ArgumentParser()
    ap.add_argument("--dry-run", action="store_true", help="print what would post, don't post")
    a = ap.parse_args()

    # Watchlist-first: pull news for YOUR watched names, then general market as fill.
    watched = watch_tickers(8)
    wset = set(watched)
    by_id: dict[str, dict] = {}
    for it in fetch_news(watched) + fetch_news():
        by_id.setdefault(str(it.get("id")), it)   # watched batch wins on dup
    items = list(by_id.values())
    if not items:
        print("[news] nothing fetched", flush=True)
        return

    def is_watched(it):
        return bool(wset & set(it.get("symbols", [])))

    seen = load_seen()
    fresh = [it for it in items if str(it.get("id")) not in seen]
    fresh.sort(key=lambda it: it.get("created_at", ""), reverse=True)  # newest first
    fresh.sort(key=lambda it: 0 if is_watched(it) else 1)              # stable: watched first
    posted = 0
    for it in fresh[:MAX_PER_RUN]:
        if a.dry_run:
            print(fmt(it, is_watched(it)) + "\n", flush=True)
            posted += 1
            continue
        if post_discord(fmt(it, is_watched(it)), webhook_name=WEBHOOK, username="Market News"):
            seen.add(str(it.get("id")))
            posted += 1
    if not a.dry_run:
        for it in fresh[MAX_PER_RUN:]:   # mark the rest seen so a backlog doesn't dump next run
            seen.add(str(it.get("id")))
        save_seen(seen)
    print(f"[news] {datetime.now(timezone.utc).isoformat()} watched={','.join(watched)} "
          f"fetched={len(items)} fresh={len(fresh)} posted={posted}"
          f"{' (dry-run, not saved)' if a.dry_run else ''}", flush=True)


if __name__ == "__main__":
    main()
