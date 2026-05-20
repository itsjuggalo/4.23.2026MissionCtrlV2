#!/usr/bin/env python3
# /// script
# requires-python = ">=3.10"
# dependencies = []
# ///
"""Pull the highest-engagement prompt's result PNG (day + night variants)
for each of AInvest's 10 prompt_type verticals.

Reads from the most recent ~/aime_research/captures/cookie-probe-v3-<ts>/
directory. Saves to ./screenshots/<vertical>_<day|night>.png in that dir.

20 images total (10 verticals × day+night), ~5-15 KB each.
"""
from __future__ import annotations

import json, pathlib, urllib.request, urllib.error

ROOT = pathlib.Path.home() / "aime_research" / "captures"
PROBE_DIR = max((p for p in ROOT.glob("cookie-probe-v3-*") if p.is_dir()),
                key=lambda p: p.stat().st_mtime)
SHOTS = PROBE_DIR / "screenshots"
SHOTS.mkdir(exist_ok=True)

print(f"source: {PROBE_DIR}")
print(f"target: {SHOTS}\n")

# Skip `All` — it duplicates other verticals. Use the 10 specific types.
VERTICALS = ["analysis", "screen", "charts", "news", "Crypto",
             "educate", "Explanation", "Prediction", "Help", "Wiki"]

UA = {"User-Agent": ("Mozilla/5.0 (Windows NT 10.0; Win64; x64) "
                    "AppleWebKit/537.36 (KHTML, like Gecko) "
                    "Chrome/130.0.0.0 Safari/537.36")}

manifest = []
for pt in VERTICALS:
    path = PROBE_DIR / f"A_square_{pt}.json"
    if not path.exists():
        print(f"  · {pt}: no source JSON")
        continue
    prompts = json.loads(path.read_text(encoding="utf-8"))["result"]
    # Highest engagement = like_num_show + share_num_show + collect_num_show
    def score(p):
        return ((p.get("like_num_show") or 0)
                + (p.get("share_num_show") or 0)
                + (p.get("collect_num_show") or 0))
    candidates = [p for p in prompts if p.get("day_image_url")]
    if not candidates:
        print(f"  · {pt}: no candidates with image_url")
        continue
    top = max(candidates, key=score)
    print(f"  {pt:14s} top:like={top.get('like_num_show')} "
          f"share={top.get('share_num_show')} collect={top.get('collect_num_show')}")
    print(f"    query: \"{top['query'][:80]}\"")
    for variant in ("day", "night"):
        url = top.get(f"{variant}_image_url")
        if not url:
            print(f"      [skip] {variant}: no URL")
            continue
        try:
            req = urllib.request.Request(url, headers=UA)
            with urllib.request.urlopen(req, timeout=20) as r:
                data = r.read()
            fname = f"{pt}_{variant}.png"
            (SHOTS / fname).write_bytes(data)
            print(f"      [ok ] {variant}: {len(data):,} bytes → {fname}")
            manifest.append({
                "vertical": pt, "variant": variant,
                "query": top["query"], "trace_id": top["trace_id"],
                "like_num_show": top.get("like_num_show"),
                "share_num_show": top.get("share_num_show"),
                "collect_num_show": top.get("collect_num_show"),
                "url": url, "file": fname, "size": len(data),
            })
        except urllib.error.HTTPError as e:
            print(f"      [err] {variant}: HTTP {e.code}")
        except Exception as e:
            print(f"      [err] {variant}: {e}")

(SHOTS / "manifest.json").write_text(
    json.dumps(manifest, indent=2, ensure_ascii=False), encoding="utf-8")

print(f"\nManifest -> {SHOTS / 'manifest.json'}")
print(f"Total images: {sum(1 for _ in SHOTS.glob('*.png'))}")
