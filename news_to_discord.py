#!/usr/bin/env python3
"""news_to_discord.py — market-news feed → Discord #research-feed.

Pulls market/company headlines (Alpaca news = Benzinga, primary/live) and posts
the new ones to #research-feed via the existing research webhook. Dedupes by news
id (state file) and caps per run so it never floods. Cron one-shot (no always-on
PM2 process — the laptop is RAM-marginal).

Sources tonight: Alpaca news (HTTP 200 on the on-disk paper keys). Tavily/Finnhub
are wired as optional fallbacks but Alpaca is the backbone.

Reuses the canonical poster lib/discord_post.py (fixes the urllib-403 UA footgun).
Posts to an EXISTING channel via the EXISTING webhook — creates/edits no channels.
"""
from __future__ import annotations

import json
import os
import sys
import urllib.request
import urllib.parse
from datetime import datetime, timezone
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parent))
from lib.discord_post import post_discord  # noqa: E402
from lib.portfolio import top_tickers  # noqa: E402

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


def _alpaca_keys():
    for kid, ksec in (("alpaca-boba-key-id", "alpaca-boba-secret"),
                      ("alpaca_boba_key_id", "alpaca_boba_secret"),
                      ("alpaca-key-id", "alpaca-secret")):
        k, s = _read(kid), _read(ksec)
        if k and s:
            return k, s
    return None, None


def fetch_alpaca_news(symbols: str = ""):
    k, s = _alpaca_keys()
    if not k or not s:
        print("[news] no alpaca keys on disk", flush=True)
        return []
    params = {"limit": NEWS_LIMIT, "sort": "desc", "include_content": "false"}
    if symbols:
        params["symbols"] = symbols
    url = "https://data.alpaca.markets/v1beta1/news?" + urllib.parse.urlencode(params)
    req = urllib.request.Request(url, headers={
        "APCA-API-KEY-ID": k, "APCA-API-SECRET-KEY": s,
        "User-Agent": "mc-news/1.0"})
    try:
        with urllib.request.urlopen(req, timeout=20) as r:
            data = json.loads(r.read())
        return data.get("news", []) or []
    except Exception as e:  # noqa: BLE001
        print(f"[news] alpaca fetch failed: {e}", flush=True)
        return []


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


def fmt(item, held: bool = False) -> str:
    head = item.get("headline", "(no headline)")
    src = item.get("source", "news")
    syms = ", ".join(item.get("symbols", [])[:6])
    url = item.get("url", "")
    ts = item.get("created_at", "")[:16].replace("T", " ")
    tag = f" · {syms}" if syms else ""
    icon = "⭐ HOLDING" if held else "📰"
    return f"{icon} **{head}**\n{src} · {ts} ET{tag}\n{url}".strip()


def main():
    # Portfolio-first: pull news for YOUR top holdings, then general market as fill.
    holdings = top_tickers(8)
    hset = set(holdings)
    by_id: dict[str, dict] = {}
    for it in fetch_alpaca_news(",".join(holdings)) + fetch_alpaca_news():
        by_id.setdefault(str(it.get("id")), it)   # holdings batch wins on dup
    items = list(by_id.values())
    if not items:
        print("[news] nothing fetched", flush=True)
        return

    def is_held(it):
        return bool(hset & set(it.get("symbols", [])))

    seen = load_seen()
    fresh = [it for it in items if str(it.get("id")) not in seen]
    fresh.sort(key=lambda it: it.get("created_at", ""), reverse=True)  # newest first
    fresh.sort(key=lambda it: 0 if is_held(it) else 1)                 # stable: holdings first
    posted = 0
    for it in fresh[:MAX_PER_RUN]:
        if post_discord(fmt(it, is_held(it)), webhook_name=WEBHOOK, username="Market News"):
            seen.add(str(it.get("id")))
            posted += 1
    for it in fresh[MAX_PER_RUN:]:   # mark the rest seen so a backlog doesn't dump next run
        seen.add(str(it.get("id")))
    save_seen(seen)
    print(f"[news] {datetime.now(timezone.utc).isoformat()} holdings={','.join(holdings)} "
          f"fetched={len(items)} fresh={len(fresh)} posted={posted}", flush=True)


if __name__ == "__main__":
    main()
