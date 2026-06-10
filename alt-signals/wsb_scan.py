#!/usr/bin/env python3
"""
r/wallstreetbets ticker-mention scan (Tier 3).

Hourly pull of /r/wallstreetbets/new.json (free, no auth). Counts ticker
mentions in titles + selftext, z-scores against the 7-day baseline,
flags spikes >= 2σ.

Notes:
  - Reddit JSON endpoint requires a unique-ish User-Agent and is rate-limited
    to ~100/minute unauthenticated.
  - Only counts post-level (not comments) — keeps the script under 10s.
"""
# /// script
# requires-python = ">=3.10"
# dependencies = []
# ///
from __future__ import annotations

import json
import statistics
import sys
from collections import Counter
from datetime import datetime, timezone, timedelta
from pathlib import Path

sys.path.insert(0, str(Path(__file__).parent))
import _lib

SOURCE = "wsb_scan"

SUBREDDITS = ["wallstreetbets", "stocks", "options"]
URL_TMPL = "https://www.reddit.com/r/{sub}/new.json?limit=100"
UA = "MissionCtrl alt-signals/1.0 (itsjuggalo@gmail.com)"

MIN_MENTIONS = 5   # need >= this many to consider
Z_THRESHOLD = 2.0  # z-score for spike alert


def fetch_sub(sub: str) -> list[dict]:
    try:
        text = _lib.http_get(
            URL_TMPL.format(sub=sub),
            accept="application/json",
            headers={"User-Agent": UA},
        )
        data = json.loads(text)
        children = data.get("data", {}).get("children", [])
        return [c.get("data", {}) for c in children]
    except Exception as e:
        print(f"[wsb] {sub}: {e}", file=sys.stderr)
        return []


def count_mentions(posts: list[dict]) -> Counter:
    c: Counter = Counter()
    for p in posts:
        text = (p.get("title", "") + " " + p.get("selftext", ""))
        for t in _lib.extract_tickers(text, max_tickers=20):
            c[t] += 1
    return c


def main() -> int:
    all_posts: list[dict] = []
    for sub in SUBREDDITS:
        all_posts.extend(fetch_sub(sub))

    if not all_posts:
        # An empty scan is NOT a unit failure (was poisoning `systemctl --failed`).
        # NOTE 2026-05-30: Reddit is currently IP-blocking this box (HTTP 403), so
        # WSB produces nothing — needs an authed Reddit API or proxy to revive.
        print("[wsb] no posts", file=sys.stderr)
        return 0

    today_counts = count_mentions(all_posts)
    today_iso = datetime.now(timezone.utc).date().isoformat()

    # Persist per-symbol counts (snapshot for today)
    with _lib.get_db() as conn:
        for sym, n in today_counts.items():
            if n < 2:
                continue
            conn.execute("""
                INSERT OR REPLACE INTO alt_wsb_mentions
                  (ts, symbol, mention_count, sentiment, z_score)
                VALUES (?, ?, ?, ?, ?)
            """, (today_iso, sym, n, 0.0, 0.0))
        conn.commit()

    # Build 7-day baseline per symbol
    with _lib.get_db() as conn:
        cutoff = (datetime.now(timezone.utc).date()
                  - timedelta(days=7)).isoformat()
        baseline_rows = conn.execute("""
            SELECT symbol, mention_count
            FROM alt_wsb_mentions
            WHERE ts >= ? AND ts < ?
        """, (cutoff, today_iso)).fetchall()
    baseline: dict[str, list[int]] = {}
    for sym, n in baseline_rows:
        baseline.setdefault(sym, []).append(n)

    new_count = pushed = 0
    for sym, n in today_counts.most_common(20):
        if n < MIN_MENTIONS:
            continue
        hist = baseline.get(sym, [])
        z = 0.0
        if len(hist) >= 3:
            mu = statistics.mean(hist)
            sd = statistics.pstdev(hist) or 1
            z = (n - mu) / sd
        elif n >= MIN_MENTIONS * 2:
            # First sighting at high volume — give it a baseline alert
            z = 2.0

        if z < Z_THRESHOLD:
            continue

        # Update z back into the row
        with _lib.get_db() as conn:
            conn.execute(
                "UPDATE alt_wsb_mentions SET z_score = ? WHERE ts = ? AND symbol = ?",
                (z, today_iso, sym),
            )
            conn.commit()

        score = min(75, 55 + int(z * 5))  # 55-75 range — social is noisy
        headline = f"{sym} — {n} WSB mentions today ({z:+.1f}σ vs 7d)"
        sig_id, is_new = _lib.upsert_alt_signal(
            source=SOURCE,
            symbol=sym,
            direction=None,
            headline=headline,
            url=f"https://www.reddit.com/r/wallstreetbets/search?q={sym}&restrict_sr=on&sort=new",
            raw={"mentions": n, "z_score": z, "baseline_days": len(hist)},
            quality_score=float(score),
            dedup_key=f"{sym}|{today_iso}",
        )
        if is_new:
            new_count += 1
            if _lib.push_if_top(sig_id, source=SOURCE, symbol=sym,
                                headline=headline, quality_score=float(score)):
                pushed += 1

    _lib.log_event(SOURCE, "tick", {
        "posts_seen": len(all_posts),
        "unique_tickers": len(today_counts),
        "new": new_count, "pushed": pushed,
    })
    top5 = today_counts.most_common(5)
    print(f"[wsb] posts={len(all_posts)} tickers={len(today_counts)} "
          f"top5={top5} new={new_count}")
    return 0


if __name__ == "__main__":
    sys.exit(main())
