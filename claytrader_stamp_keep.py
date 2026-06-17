#!/usr/bin/env python3
"""claytrader_stamp_keep.py — join the vision-curated quiz_bank.json back into each
lesson's frames.json so the ClaudeClaw ClayTrader page can show ONLY the real chart
stills (with precise `concept` + `caption`), not every coarse lesson-topic frame.

Why: claytrader_quiz_build.py writes a coarse lesson-level `topic` onto EVERY frame,
but only vision-verifies a subset as actual charts (-> quiz_bank.json, with a precise
`concept`/`caption`). The frontend reads frames.json, so without this the quiz/examples
surface non-chart frames labelled with the coarse topic. This stamps the bank's
keep/concept/caption/difficulty onto the matching frame objects in frames.json.

Idempotent: re-running just re-stamps. Match key = vimeo_id + basename(still).
Backend needs NO restart — the existing frames/:videoId endpoint returns the full
frame objects from frames.json as-is.

Usage:  python3 claytrader_stamp_keep.py            # stamp from quiz_bank.json
        python3 claytrader_stamp_keep.py --clear    # remove keep stamps (revert)
"""
import argparse
import json
import os
from pathlib import Path

KB = Path.home() / "claytrader-kb"
BANK = KB / "quiz_bank.json"
FRAMES = KB / "frames"


def main() -> int:
    ap = argparse.ArgumentParser()
    ap.add_argument("--clear", action="store_true", help="strip keep/concept/caption stamps")
    args = ap.parse_args()

    if not BANK.exists():
        print(f"no bank at {BANK}")
        return 1
    bank = json.loads(BANK.read_text())

    # bank entries grouped by vimeo_id -> { basename: entry }
    by_vid: dict[str, dict[str, dict]] = {}
    for e in bank:
        vid = str(e.get("vimeo_id") or "")
        still = e.get("still") or ""
        if not vid or not still:
            continue
        by_vid.setdefault(vid, {})[os.path.basename(still)] = e

    stamped = lessons = cleared = 0
    for fj in sorted(FRAMES.glob("*/frames.json")):
        vid = fj.parent.name
        try:
            d = json.load(open(fj))
        except Exception:
            continue
        frames = d.get("frames", [])
        changed = False
        keepmap = by_vid.get(vid, {})
        for f in frames:
            base = os.path.basename(f.get("file", ""))
            if args.clear:
                for k in ("keep", "concept", "caption", "difficulty"):
                    if k in f:
                        del f[k]; changed = True; cleared += 1
                continue
            entry = keepmap.get(base)
            if entry:
                f["keep"] = True
                f["concept"] = entry.get("concept") or f.get("topic") or ""
                f["caption"] = entry.get("caption") or ""
                f["difficulty"] = entry.get("difficulty") or "medium"
                changed = True
                stamped += 1
        if changed:
            fj.write_text(json.dumps(d, indent=1))
            lessons += 1

    if args.clear:
        print(f"Cleared {cleared} stamps across {lessons} lessons.")
    else:
        print(f"Stamped {stamped} kept chart frames across {lessons} lessons "
              f"(bank={len(bank)}).")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
