#!/usr/bin/env python3
"""
HackerNews + r/algotrading ingester (Tier 3).

Light idea-feed: pulls top HN front page + top r/algotrading posts, 4x daily.
Surface headline + URL — no ticker extraction (these are tool/strategy posts).
quality_score capped at 55 — pure idea fuel, never push to Discord, just
feed the morning brief.

To keep noise down, only emit a signal for posts with high engagement
(HN >= 100 points, Reddit >= 50 upvotes).
"""
# /// script
# requires-python = ">=3.10"
# dependencies = []
# ///
from __future__ import annotations

import json
import sys
from datetime import datetime, timezone
from pathlib import Path

sys.path.insert(0, str(Path(__file__).parent))
import _lib

SOURCE = "hn_algo"

HN_TOP = "https://hacker-news.firebaseio.com/v0/topstories.json"
HN_ITEM = "https://hacker-news.firebaseio.com/v0/item/{id}.json"
REDDIT_URLS = [
    ("algotrading", "https://www.reddit.com/r/algotrading/top.json?t=day&limit=25"),
    ("quant", "https://www.reddit.com/r/quant/top.json?t=day&limit=25"),
    ("financialindependence", "https://www.reddit.com/r/financialindependence/top.json?t=day&limit=10"),
]

UA = "MissionCtrl alt-signals/1.0 (itsjuggalo@gmail.com)"

HN_MIN_POINTS = 100
REDDIT_MIN_UPS = 50
KEYWORDS = (
    "trading", "trade", "stock", "option", "options", "etf", "futures",
    "crypto", "bitcoin", "btc", "eth", "quant", "algo", "alpha", "backtest",
    "portfolio", "risk", "hedge", "fed", "sec", "ipo", "merger", "earnings",
    "vix", "rates", "yield", "treasury", "bond", "ai", "llm", "agent",
)


def matches_finance(text: str) -> bool:
    low = text.lower()
    return any(k in low for k in KEYWORDS)


def fetch_hn_top() -> list[dict]:
    try:
        ids = json.loads(_lib.http_get(HN_TOP, accept="application/json",
                                       headers={"User-Agent": UA}))
    except Exception as e:
        print(f"[hn] top list: {e}", file=sys.stderr)
        return []
    items = []
    for hid in ids[:30]:
        try:
            text = _lib.http_get(HN_ITEM.format(id=hid),
                                 accept="application/json",
                                 headers={"User-Agent": UA})
            d = json.loads(text)
            if d:
                items.append(d)
        except Exception:
            continue
    return items


def fetch_reddit(sub: str, url: str) -> list[dict]:
    try:
        text = _lib.http_get(url, accept="application/json",
                             headers={"User-Agent": UA})
        data = json.loads(text)
        children = data.get("data", {}).get("children", [])
        return [c.get("data", {}) for c in children]
    except Exception as e:
        print(f"[hn] r/{sub}: {e}", file=sys.stderr)
        return []


def main() -> int:
    new_count = 0

    # HN front page
    for item in fetch_hn_top():
        title = item.get("title", "")
        url = item.get("url") or f"https://news.ycombinator.com/item?id={item.get('id')}"
        points = item.get("score", 0) or 0
        if points < HN_MIN_POINTS:
            continue
        if not matches_finance(title):
            continue
        score = min(55, 40 + int(points / 50))
        sig_id, is_new = _lib.upsert_alt_signal(
            source=SOURCE,
            symbol=None,
            direction=None,
            headline=f"HN ({points}pts): {title}",
            url=url,
            raw={"hn_id": item.get("id"), "points": points,
                 "type": item.get("type"), "by": item.get("by")},
            quality_score=float(score),
            dedup_key=f"hn|{item.get('id')}",
        )
        if is_new:
            new_count += 1
        # No push_if_top — these are brief-only

    # Reddit subs
    for sub, url in REDDIT_URLS:
        for post in fetch_reddit(sub, url):
            title = post.get("title", "")
            ups = post.get("ups", 0) or 0
            if ups < REDDIT_MIN_UPS:
                continue
            if not matches_finance(title) and sub not in ("algotrading", "quant"):
                continue
            score = min(55, 40 + int(ups / 25))
            permalink = post.get("permalink", "")
            full_url = f"https://www.reddit.com{permalink}" if permalink else post.get("url", "")
            sig_id, is_new = _lib.upsert_alt_signal(
                source=SOURCE,
                symbol=None,
                direction=None,
                headline=f"r/{sub} ({ups}↑): {title}",
                url=full_url,
                raw={"sub": sub, "id": post.get("id"), "ups": ups,
                     "num_comments": post.get("num_comments", 0)},
                quality_score=float(score),
                dedup_key=f"reddit|{post.get('id')}",
            )
            if is_new:
                new_count += 1

    _lib.log_event(SOURCE, "tick", {"new": new_count})
    print(f"[hn_algo] new={new_count}")
    return 0


if __name__ == "__main__":
    sys.exit(main())
