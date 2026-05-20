#!/usr/bin/env python3
"""
AInvest prompt-square ingester (Tier 3).

Polls https://tech.ainvest.com/.../square_list (the AI prompt community
"square") hourly. Captures new prompts, deduped against state. Extracts
tickers, counts mentions across a rolling 24h window, and emits an
alt_signal for tickers that newly cross a baseline.

This is *idea fuel*, not a trade signal — quality_score is capped at 60
unless multiple prompts on the same ticker cluster in the same window.
"""
# /// script
# requires-python = ">=3.10"
# dependencies = []
# ///
from __future__ import annotations

import json
import sys
import time
from collections import Counter, defaultdict
from datetime import datetime, timezone, timedelta
from pathlib import Path

sys.path.insert(0, str(Path(__file__).parent))
import _lib

SOURCE = "ainvest_prompts"

BASE = "https://tech.ainvest.com/gateway/userstore/iwc/userinfo/prompt/share_query/square_list"
PARAMS_TMPL = (
    "?prompt_type=All&page={page}&scene=prompt_competition_square"
    "&source=ths_wencai_international_pc_robot&pageSize=40"
)

PAGES_PER_TICK = 3  # 3 * 40 = 120 prompts/tick
CLUSTER_WINDOW_HOURS = 24
CLUSTER_MIN = 3  # 3+ mentions of the same ticker → signal


def fetch_page(page: int) -> list[dict]:
    url = BASE + PARAMS_TMPL.format(page=page)
    try:
        text = _lib.http_get(
            url,
            accept="application/json",
            headers={
                "User-Agent": "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36",
                "Referer": "https://www.ainvest.com/",
            },
        )
        data = json.loads(text)
    except Exception as e:
        print(f"[ainvest] page {page}: {e}", file=sys.stderr)
        return []
    # AInvest wraps the prompts in `result` (or sometimes `data`/`list`)
    items = (
        data.get("result")
        or (data.get("data") or {}).get("list")
        or (data.get("data") or {}).get("items")
        or data.get("list")
        or []
    )
    return items if isinstance(items, list) else []


def main() -> int:
    fresh: list[dict] = []
    for p in range(PAGES_PER_TICK):
        items = fetch_page(p)
        if not items:
            break
        fresh.extend(items)
        time.sleep(0.5)

    if not fresh:
        print("[ainvest] no items", file=sys.stderr)
        return 1

    state = _lib.load_state(SOURCE, {"seen": [], "ticker_mentions": {}})
    seen = set(state.get("seen", []))
    ticker_mentions: dict[str, list[str]] = defaultdict(list)
    for k, v in (state.get("ticker_mentions") or {}).items():
        if isinstance(v, list):
            ticker_mentions[k] = v

    cutoff = (datetime.now(timezone.utc)
              - timedelta(hours=CLUSTER_WINDOW_HOURS)).isoformat()

    new_prompt_count = 0
    new_ticker_mentions: list[tuple[str, str]] = []

    for item in fresh:
        prompt_id = (str(item.get("id") or item.get("share_id")
                         or item.get("prompt_id") or "")).strip()
        # AInvest text field is `query`; fall back to legacy names
        text = (item.get("query") or item.get("prompt_text")
                or item.get("content") or item.get("question") or "")
        if not prompt_id:
            if not text:
                continue
            prompt_id = _lib.make_signal_id("ainvest", text[:120])
        if prompt_id in seen:
            continue
        seen.add(prompt_id)
        new_prompt_count += 1

        category = item.get("prompt_type") or item.get("category") or ""
        # `like_num` is usually null; the *_show fields hold the displayed count
        like_num = (item.get("like_num_show") or item.get("like_num")
                    or item.get("likes") or 0)
        try:
            like_num = int(like_num) if like_num is not None else 0
        except Exception:
            like_num = 0

        tickers = _lib.extract_tickers(text, max_tickers=5)
        # Prefer the item's own createTime when present (ms epoch string)
        ts = _lib.utc_now_iso()
        if (ct := item.get("createTime")) and str(ct).isdigit():
            try:
                ts = (datetime.fromtimestamp(int(ct) / 1000, tz=timezone.utc)
                      .isoformat(timespec="seconds"))
            except Exception:
                pass

        # Persist raw prompt
        with _lib.get_db() as conn:
            conn.execute("""
                INSERT OR REPLACE INTO alt_ainvest_prompts
                  (prompt_id, ts, prompt_text, category, tickers, like_num, raw_json)
                VALUES (?, ?, ?, ?, ?, ?, ?)
            """, (prompt_id, ts, text[:2000], category,
                  ",".join(tickers), like_num, json.dumps(item, default=str)[:4000]))
            conn.commit()

        for t in tickers:
            ticker_mentions[t].append(ts)
            new_ticker_mentions.append((t, prompt_id))

    # Trim mentions older than cutoff
    for t in list(ticker_mentions.keys()):
        ticker_mentions[t] = [m for m in ticker_mentions[t] if m >= cutoff]
        if not ticker_mentions[t]:
            del ticker_mentions[t]

    # Cluster signal: tickers with >= CLUSTER_MIN in window
    cluster_new = pushed = 0
    for t, mentions in ticker_mentions.items():
        n = len(mentions)
        if n < CLUSTER_MIN:
            continue
        # Score = base 55, +5 per mention above min, cap 75
        score = min(75, 55 + (n - CLUSTER_MIN) * 5)
        headline = (
            f"{t} — {n} AInvest prompts in last {CLUSTER_WINDOW_HOURS}h"
        )
        sig_id, is_new = _lib.upsert_alt_signal(
            source=SOURCE,
            symbol=t,
            direction=None,
            headline=headline,
            url="https://www.ainvest.com/aime/skillhub/",
            raw={"mentions_in_window": n, "window_hours": CLUSTER_WINDOW_HOURS},
            quality_score=float(score),
            dedup_key=f"{t}|cluster|{_lib.utc_now_iso()[:13]}",  # hourly dedup
        )
        if is_new:
            cluster_new += 1
            if _lib.push_if_top(sig_id, source=SOURCE, symbol=t,
                                headline=headline, quality_score=float(score)):
                pushed += 1

    # Save state, keep last 5k seen prompt_ids
    state["seen"] = sorted(seen)[-5000:]
    state["ticker_mentions"] = ticker_mentions
    _lib.save_state(SOURCE, state)
    _lib.log_event(SOURCE, "tick", {
        "fetched": len(fresh),
        "new_prompts": new_prompt_count,
        "clusters_new": cluster_new,
        "pushed": pushed,
    })
    print(f"[ainvest] fetched={len(fresh)} new_prompts={new_prompt_count} "
          f"clusters={cluster_new} pushed={pushed}")
    return 0


if __name__ == "__main__":
    sys.exit(main())
