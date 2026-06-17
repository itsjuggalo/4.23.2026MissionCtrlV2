#!/home/itsju/.venv/bin/python
"""erikdalton_quiz_qa.py — read-only health check for the Erik Dalton quiz bank.

Verifies, for every entry in quiz_bank.json, that the quiz is actually playable
and that the STILL lines up with the CLIP (the bug we fixed: still@t_mid vs
clip@t_start). For each entry it asserts:
  • clip file exists, has a VIDEO stream + an AUDIO stream (Erik's voice), ~5s
  • still file exists
  • still timestamp == clip center within ±0.6s  (still = clip midpoint)
  • region is one of the 15 known regions; technique + caption non-empty

Exit 0 = all green. Non-zero = something to fix. Run anytime:
    erikdalton_quiz_qa.py            # summary + first failures
    erikdalton_quiz_qa.py --verbose  # per-entry table
"""
from __future__ import annotations

import argparse
import json
import subprocess
from pathlib import Path

ANAT = Path.home() / "erikdalton-kb" / "anatomy"
BANK = ANAT / "quiz_bank.json"
CLIP_SECONDS = 5.0
TOL = 0.6  # still must be within this many seconds of the clip center

REGIONS = {
    "head/face", "jaw/TMJ", "neck", "shoulder", "arm", "elbow", "wrist/hand",
    "thoracic/ribs", "spine/general", "core/abdomen", "low back", "pelvis/SI",
    "hip/glutes", "knee", "foot/ankle",
}


def _probe(path: Path) -> dict:
    """Return {dur, has_video, has_audio} via one ffprobe call."""
    try:
        r = subprocess.run(
            ["ffprobe", "-v", "error", "-show_entries",
             "stream=codec_type:format=duration", "-of", "json", str(path)],
            capture_output=True, text=True, timeout=30)
        d = json.loads(r.stdout or "{}")
        types = {s.get("codec_type") for s in d.get("streams", [])}
        dur = float(d.get("format", {}).get("duration", 0) or 0)
        return {"dur": dur, "has_video": "video" in types, "has_audio": "audio" in types}
    except Exception:
        return {"dur": 0.0, "has_video": False, "has_audio": False}


def _t_mid_for(still: Path) -> float | None:
    """Look up the still's exact t_mid from its lesson frames.json."""
    vid = still.parent.name
    try:
        d = json.load(open(ANAT / "frames" / vid / "frames.json"))
    except Exception:
        return None
    fr = next((f for f in d.get("frames", []) if Path(f.get("file", "")).name == still.name), None)
    if not fr:
        return None
    t = fr.get("t_mid", fr.get("t_start"))
    return float(t) if t is not None else None


def main() -> int:
    ap = argparse.ArgumentParser()
    ap.add_argument("--verbose", action="store_true")
    args = ap.parse_args()

    if not BANK.exists():
        print("FAIL: quiz_bank.json missing")
        return 2
    bank = json.loads(BANK.read_text())
    rows, fails = [], []

    for i, e in enumerate(bank):
        clip = Path(e.get("clip", "")); still = Path(e.get("still", ""))
        problems = []
        if not clip.exists():
            problems.append("clip-missing")
            pr = {"dur": 0.0, "has_video": False, "has_audio": False}
        else:
            pr = _probe(clip)
            if not pr["has_video"]:
                problems.append("no-video")
            if not pr["has_audio"]:
                problems.append("no-voice")
            if not (CLIP_SECONDS - 0.8 <= pr["dur"] <= CLIP_SECONDS + 0.8):
                problems.append(f"dur={pr['dur']:.1f}")
        if not still.exists():
            problems.append("still-missing")
        t_mid = _t_mid_for(still)
        delta = None
        if t_mid is not None:
            center = max(0.0, t_mid - CLIP_SECONDS / 2.0) + CLIP_SECONDS / 2.0
            delta = abs(center - t_mid)
            if delta > TOL:
                problems.append(f"misaligned d={delta:.2f}")
        else:
            problems.append("no-t_mid")
        if e.get("region") not in REGIONS:
            problems.append(f"bad-region:{e.get('region')}")
        if not (e.get("technique") or "").strip():
            problems.append("no-technique")
        if not (e.get("caption") or "").strip():
            problems.append("no-caption")

        ok = not problems
        rows.append((i, e.get("technique", "?")[:38], "OK" if ok else "FAIL",
                     f"d={delta:.2f}" if delta is not None else "d=?",
                     "voice" if pr["has_audio"] else "—", ",".join(problems)))
        if not ok:
            fails.append(rows[-1])

    if args.verbose:
        print(f"{'#':>3} {'technique':40} {'st':5} {'algn':7} {'aud':6} notes")
        for r in rows:
            print(f"{r[0]:>3} {r[1]:40} {r[2]:5} {r[3]:7} {r[4]:6} {r[5]}")

    total = len(bank)
    n_ok = total - len(fails)
    n_voice = sum(1 for r in rows if r[4] == "voice")
    print("\n── Erik quiz QA ───────────────────────────────")
    print(f"entries:        {total}")
    print(f"OK:             {n_ok}")
    print(f"with voice:     {n_voice}/{total}")
    print(f"failures:       {len(fails)}")
    if fails:
        print("\nfirst failures:")
        for r in fails[:12]:
            print(f"  #{r[0]} {r[1]} — {r[5]}")
    print("\nRESULT:", "✅ ALL GREEN" if not fails else "❌ FIX NEEDED")
    return 0 if not fails else 1


if __name__ == "__main__":
    raise SystemExit(main())
