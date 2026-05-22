#!/usr/bin/env python3
# /// script
# requires-python = ">=3.10"
# dependencies = []
# ///
"""Load AInvest's vertical-segmented public square prompts into flow.db.

Reads from the most recent ~/aime_research/captures/cookie-probe-v3-<ts>/
A_square_<vertical>.json. Inserts into alt_ainvest_seed_prompts with the
AInvest `id` as primary key (idempotent — re-runs upsert).

Table is created on first run.

Map AInvest's prompt_type → our copilot vertical slug (mostly identity,
plus a few normalizations: Explanation→explain, Prediction→predict,
Help→help, Wiki→wiki, Crypto→crypto). The `All` bucket is skipped — it
duplicates the typed verticals.
"""
from __future__ import annotations

import json, pathlib, sqlite3

DB = pathlib.Path.home() / "flow-data" / "flow.db"
ROOT = pathlib.Path.home() / "aime_research" / "captures"

# AInvest prompt_type → MissionCtrl copilot vertical slug
PT_TO_VERTICAL = {
    "analysis": "analysis",
    "screen":   "screen",
    "charts":   "charts",
    "news":     "news",
    "Crypto":   "crypto",
    "educate":  "educate",
    "Explanation": "explain",
    "Prediction":  "predict",
    "Help":     "help",
    "Wiki":     "wiki",
    # "All" is skipped — duplicates the typed verticals
}

SCHEMA = """
CREATE TABLE IF NOT EXISTS alt_ainvest_seed_prompts (
    id              TEXT PRIMARY KEY,    -- AInvest's prompt id
    ainvest_pt      TEXT NOT NULL,       -- raw prompt_type from AInvest (Crypto/Explanation/etc)
    vertical        TEXT NOT NULL,       -- normalized copilot vertical slug
    query           TEXT NOT NULL,
    query_type      TEXT,                -- intustock / intusstock asset-universe tag
    user_id         TEXT,
    user_name       TEXT,
    user_avatar     TEXT,
    trace_id        TEXT,
    create_time     TEXT,                -- AInvest's createTime (ms epoch string)
    like_num_show   INTEGER,
    share_num_show  INTEGER,
    collect_num_show INTEGER,
    ask_num         INTEGER,
    day_image_url   TEXT,
    night_image_url TEXT,
    pulled_at       TEXT DEFAULT CURRENT_TIMESTAMP,
    source_scene    TEXT
);
CREATE INDEX IF NOT EXISTS idx_ainvest_seed_vertical ON alt_ainvest_seed_prompts(vertical);
CREATE INDEX IF NOT EXISTS idx_ainvest_seed_engagement
    ON alt_ainvest_seed_prompts(vertical, like_num_show DESC, share_num_show DESC);
"""

UPSERT = """
INSERT INTO alt_ainvest_seed_prompts (
    id, ainvest_pt, vertical, query, query_type,
    user_id, user_name, user_avatar, trace_id, create_time,
    like_num_show, share_num_show, collect_num_show, ask_num,
    day_image_url, night_image_url, source_scene
) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
ON CONFLICT(id) DO UPDATE SET
    ainvest_pt = excluded.ainvest_pt,
    vertical   = excluded.vertical,
    query      = excluded.query,
    query_type = excluded.query_type,
    like_num_show = excluded.like_num_show,
    share_num_show = excluded.share_num_show,
    collect_num_show = excluded.collect_num_show,
    ask_num    = excluded.ask_num,
    day_image_url   = excluded.day_image_url,
    night_image_url = excluded.night_image_url,
    pulled_at  = CURRENT_TIMESTAMP;
"""


def find_probe_dir() -> pathlib.Path:
    candidates = [p for p in ROOT.glob("cookie-probe-v3-*") if p.is_dir()]
    if not candidates:
        raise SystemExit(f"no cookie-probe-v3-* dirs under {ROOT}")
    return max(candidates, key=lambda p: p.stat().st_mtime)


def main() -> None:
    src = find_probe_dir()
    print(f"source: {src}")
    print(f"target: {DB}")

    db = sqlite3.connect(DB)
    db.executescript(SCHEMA)

    inserted = updated = skipped = 0
    for pt, vert in PT_TO_VERTICAL.items():
        path = src / f"A_square_{pt}.json"
        if not path.exists():
            print(f"  · {pt}: missing source JSON")
            continue
        prompts = json.loads(path.read_text(encoding="utf-8"))["result"]
        before = db.execute(
            "SELECT COUNT(*) FROM alt_ainvest_seed_prompts WHERE vertical = ?",
            (vert,),
        ).fetchone()[0]
        for p in prompts:
            if not p.get("id") or not p.get("query"):
                skipped += 1
                continue
            db.execute(UPSERT, (
                p["id"], pt, vert, p["query"], p.get("query_type"),
                p.get("user_id"), p.get("user_name"), p.get("user_avatar"),
                p.get("trace_id"), p.get("createTime"),
                p.get("like_num_show"), p.get("share_num_show"),
                p.get("collect_num_show"), p.get("ask_num"),
                p.get("day_image_url"), p.get("night_image_url"),
                "prompt_competition_square",
            ))
        db.commit()
        after = db.execute(
            "SELECT COUNT(*) FROM alt_ainvest_seed_prompts WHERE vertical = ?",
            (vert,),
        ).fetchone()[0]
        added = after - before
        upserted = len(prompts) - added - sum(1 for p in prompts if not p.get("id") or not p.get("query"))
        inserted += added
        updated += upserted
        print(f"  {pt:14s} → {vert:10s}: {len(prompts)} rows ({added} new, {upserted} updated)")

    total = db.execute("SELECT COUNT(*) FROM alt_ainvest_seed_prompts").fetchone()[0]
    per_vert = db.execute(
        "SELECT vertical, COUNT(*) FROM alt_ainvest_seed_prompts GROUP BY vertical ORDER BY vertical"
    ).fetchall()

    print(f"\nTotal rows: {total}  (this run: +{inserted} new, {updated} updated, {skipped} skipped)")
    print("Per-vertical counts:")
    for v, n in per_vert:
        print(f"  {v:10s}: {n}")

    db.close()


if __name__ == "__main__":
    main()
