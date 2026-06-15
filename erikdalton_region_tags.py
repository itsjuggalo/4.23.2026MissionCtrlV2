#!/usr/bin/env python3
"""Tag every extracted Erik Dalton DVD/USB frame with a body region.

Adds a "region" field (canonical short label, e.g. "wrist/hand", "low back") to
each frame in anatomy/frames/<videoId>/frames.json, derived from the frame's own
transcript text and — as a fallback — the video-level region (title + course +
all frame text). Also writes a "regions" list per video into frames/_index.json.

The dashboard (DatabaseDetail.tsx matchFrames) uses frame.region to BOOST frames
whose region matches the query even when that segment's transcript doesn't say the
word — so "carpal tunnel" reliably surfaces upper-extremity frames mid-demo.

Idempotent: re-run any time (recomputes + overwrites region in place). Read-only
on video files; only rewrites the small JSON sidecars.

Usage:
  python3 erikdalton_region_tags.py            # tag all
  python3 erikdalton_region_tags.py --dry-run  # report, write nothing
"""
from __future__ import annotations

import argparse
import json
import re
import sys
from collections import Counter
from pathlib import Path

FRAMES_DIR = Path("/home/itsju/erikdalton-kb/anatomy/frames")

# Ordered most-specific -> most-general. Each region: (label, keywords).
# First region whose keyword appears wins for a given text (order matters:
# "carpal"/"wrist" must beat the generic "arm").
REGIONS: list[tuple[str, list[str]]] = [
    ("jaw/TMJ",      ["tmj", "jaw", "temporomandibular", "masseter", "mandible"]),
    ("head/face",    ["headache", "cranial", "skull", "occiput", "temporal", "scalp", "face"]),
    ("neck",         ["neck", "cervical", "scalene", "sternocleidomastoid", "scm", "suboccipital", "atlas", "whiplash"]),
    # wrist/hand: client-side region only — NOT "hand"/"finger"/"thumb" (those are
    # the therapist's hands, said constantly in massage narration → false positives).
    ("wrist/hand",   ["carpal", "carpal tunnel", "wrist", "median nerve", "tinel", "flexor retinaculum"]),
    ("elbow",        ["elbow", "epicondyle", "tennis elbow", "forearm", "ulnar nerve", "pronator"]),
    ("shoulder",     ["shoulder", "rotator cuff", "supraspinatus", "infraspinatus", "deltoid", "scapula", "scapular", "clavicle", "acromion", "frozen shoulder", "glenohumeral"]),
    ("arm",          ["arm", "bicep", "tricep", "humerus", "brachial"]),
    ("thoracic/ribs",["thoracic", "rib", "ribs", "mid back", "mid-back", "t-spine", "tspine", "kyphosis", "rhomboid", "trapezius", "dorsal"]),
    ("low back",     ["low back", "lower back", "lumbar", "l4", "l5", "ql ", "quadratus lumborum", "erector", "disc", "sciatic", "sciatica"]),
    ("pelvis/SI",    ["pelvis", "pelvic", "sacro", "sacrum", "si joint", "si-joint", "sacroiliac", "ilium", "iliac", "innominate", "coccyx"]),
    ("hip/glutes",   ["hip", "glute", "gluteus", "piriformis", "psoas", "iliopsoas", "tfl", "trochanter", "groin", "adductor"]),
    ("knee",         ["knee", "patella", "meniscus", "acl", "quadricep", "hamstring", "popliteal"]),
    ("foot/ankle",   ["foot", "feet", "ankle", "plantar", "calf", "gastroc", "soleus", "achilles", "heel", "toe"]),
    ("core/abdomen", ["abdomen", "abdominal", "belly", "core", "diaphragm", "pelvic floor", "viscera", "visceral", "navel"]),
    ("spine/general",["spine", "spinal", "vertebra", "vertebrae", "posture", "postural", "alignment"]),
]


# Pre-compile a word-boundary regex per region so "arm" doesn't match "warm",
# "disc" doesn't match "discomfort", "core" doesn't match "encourage", etc.
# Phrases (with spaces) still work — \b sits on the outer word edges.
_REGION_RE: list[tuple[str, "re.Pattern[str]"]] = [
    (label, re.compile(r"\b(?:" + "|".join(re.escape(k) for k in kws) + r")\b", re.I))
    for label, kws in REGIONS
]


def region_for(text: str) -> str | None:
    for label, rx in _REGION_RE:
        if rx.search(text):
            return label
    return None


def video_region(title: str, course: str, frames: list[dict]) -> str | None:
    """Aggregate region for the whole video: most common per-frame region,
    else a region keyword hit anywhere in title+course+all text."""
    counts: Counter[str] = Counter()
    for fr in frames:
        r = region_for(fr.get("text", ""))
        if r:
            counts[r] += 1
    if counts:
        return counts.most_common(1)[0][0]
    return region_for(f"{title} {course} " + " ".join(fr.get("text", "") for fr in frames))


def main() -> int:
    ap = argparse.ArgumentParser()
    ap.add_argument("--dry-run", action="store_true")
    args = ap.parse_args()

    if not FRAMES_DIR.exists():
        print(f"no frames dir at {FRAMES_DIR}", file=sys.stderr)
        return 1

    idx_path = FRAMES_DIR / "_index.json"
    index = json.loads(idx_path.read_text()) if idx_path.exists() else {}

    total_frames = 0
    tagged_frames = 0
    region_tally: Counter[str] = Counter()
    per_video_region: dict[str, str] = {}

    for fj in sorted(FRAMES_DIR.glob("*/frames.json")):
        data = json.loads(fj.read_text())
        frames = data.get("frames", [])
        vreg = video_region(data.get("title", ""), data.get("course", ""), frames)
        per_video_region[data.get("id", fj.parent.name)] = vreg or "(none)"
        for fr in frames:
            total_frames += 1
            r = region_for(fr.get("text", "")) or vreg
            fr["region"] = r or ""
            if r:
                tagged_frames += 1
                region_tally[r] += 1
        if not args.dry_run:
            fj.write_text(json.dumps(data, indent=2, ensure_ascii=False))

    # Stamp the video-level region into _index.json.
    for vid, meta in index.items():
        if isinstance(meta, dict):
            meta["region"] = per_video_region.get(vid, "(none)")
    if not args.dry_run and index:
        idx_path.write_text(json.dumps(index, indent=2, ensure_ascii=False))

    print(f"videos: {len(per_video_region)}  frames: {total_frames}  "
          f"region-tagged: {tagged_frames} ({100*tagged_frames//max(total_frames,1)}%)")
    print("region distribution:")
    for label, n in region_tally.most_common():
        print(f"  {label:16} {n}")
    untagged = total_frames - tagged_frames
    if untagged:
        print(f"  {'(untagged)':16} {untagged}")
    if args.dry_run:
        print("\n[dry-run] no files written")
    return 0


if __name__ == "__main__":
    sys.exit(main())
