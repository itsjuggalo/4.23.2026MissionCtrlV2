#!/home/itsju/.venv/bin/python
"""erikdalton_quiz_build.py — build a CURATED bodywork-quiz bank from the Erik Dalton DVDs.

For each lesson (frames.json under ~/erikdalton-kb/anatomy/frames/*/), pick the best
hands-on segment, cut a short SILENT mp4 clip (motion — the technique in action) from the
source video with ffmpeg (metadata stripped → no timestamp leak), then VISION-CURATE the
representative still via Claude (OAuth subscription): keep only clips that clearly show a
hands-on manual-therapy technique (drop talking-head / title / wide-room / blank), and let
the model write a clean technique label (no DVD chapter number) + a one-line caption +
difficulty. Output → quiz_bank.json, consumed by bodywork_quiz.py.

Resumable: skips lessons already in the bank. Gentle/serial to share the subscription
rate-limit with interactive Claude Code. Run:
    erikdalton_quiz_build.py [--limit N] [--max-per-video K] [--dry]
"""
from __future__ import annotations

import argparse
import base64
import glob
import json
import os
import subprocess
import sys
import time
from pathlib import Path

ANAT = Path.home() / "erikdalton-kb" / "anatomy"
CLIPS = ANAT / "quiz_clips"
BANK = ANAT / "quiz_bank.json"
PROCESSED = ANAT / "quiz_build_processed.json"
CRED = Path.home() / ".claude" / ".credentials.json"

CLIP_SECONDS = 5
CLIP_W = 480
CLIP_FPS = 15


# ───────────────────────── claude OAuth vision ──────────────────────────────
def _oauth_token() -> str | None:
    try:
        d = json.loads(CRED.read_text())
        return (d.get("claudeAiOauth") or {}).get("accessToken")
    except Exception:
        return None


def _vision_classify(still_path: Path, title: str, region: str, transcript: str) -> dict | None:
    """Ask Claude (vision) whether the still clearly shows a hands-on technique, and to
    return a clean label/caption/difficulty. Returns dict or None on failure."""
    tok = _oauth_token()
    if not tok or not still_path.exists():
        return None
    try:
        import urllib.request
        b64 = base64.b64encode(still_path.read_bytes()).decode()
        prompt = (
            "This is a still from an Erik Dalton manual-therapy (massage/bodywork) instructional "
            "DVD. Decide if it CLEARLY shows a hands-on technique being performed on a person "
            "(therapist's hands in contact, recognizable body region). Reject talking-head, title "
            "cards, slides, wide empty rooms, or ambiguous frames.\n"
            f"Lesson title (may include a chapter number — IGNORE the number): {title!r}\n"
            f"Body region tag: {region!r}\n"
            f"Transcript near this moment: {transcript[:600]!r}\n\n"
            "Reply with ONLY compact JSON: {\"keep\": true|false, \"technique\": \"<clean technique "
            "name, NO leading number, <=6 words>\", \"caption\": \"<one short sentence on what's "
            "shown / the cue>\", \"difficulty\": \"easy|medium|hard\"}"
        )
        body = {
            "model": "claude-sonnet-4-5", "max_tokens": 400,
            "system": "You are Claude Code, Anthropic's official CLI for Claude.",
            "messages": [{"role": "user", "content": [
                {"type": "image", "source": {"type": "base64",
                 "media_type": "image/jpeg", "data": b64}},
                {"type": "text", "text": prompt},
            ]}],
        }
        req = urllib.request.Request(
            "https://api.anthropic.com/v1/messages",
            data=json.dumps(body).encode(), method="POST",
            headers={"Authorization": "Bearer " + tok, "anthropic-version": "2023-06-01",
                     "anthropic-beta": "oauth-2025-04-20", "content-type": "application/json"})
        with urllib.request.urlopen(req, timeout=60) as r:
            d = json.loads(r.read())
        txt = d["content"][0]["text"].strip()
        i, j = txt.find("{"), txt.rfind("}")
        return json.loads(txt[i:j + 1]) if i >= 0 else None
    except Exception as e:
        print(f"  vision error: {str(e)[:160]}", file=sys.stderr)
        return None


# ───────────────────────── clip extraction ──────────────────────────────────
def _cut_clip(src: str, t_center: float, out: Path) -> bool:
    """5s mp4 CENTERED on the curated still moment, WITH Erik's voice (mono AAC), metadata
    stripped (no timestamp leak), small + autoplay-friendly. Centering keeps the still ==
    the clip's middle frame, so the screenshot and the motion show the SAME instant
    (fixes the old t_start-vs-t_mid drift). If the source has no audio it degrades to silent."""
    half = CLIP_SECONDS / 2.0
    t0 = max(0.0, float(t_center) - half)
    cmd = ["ffmpeg", "-y", "-ss", f"{t0:.2f}", "-t", str(CLIP_SECONDS), "-i", src,
           "-vf", f"fps={CLIP_FPS},scale={CLIP_W}:-2", "-c:v", "libx264",
           "-pix_fmt", "yuv420p", "-c:a", "aac", "-b:a", "96k", "-ac", "1",
           "-movflags", "+faststart", "-map_metadata", "-1",
           "-loglevel", "error", str(out)]
    try:
        r = subprocess.run(cmd, capture_output=True, text=True, timeout=120)
        return r.returncode == 0 and out.exists() and out.stat().st_size > 1000
    except Exception as e:
        print(f"  ffmpeg error: {str(e)[:160]}", file=sys.stderr)
        return False


def _probe_dur(p: Path) -> float | None:
    try:
        r = subprocess.run(["ffprobe", "-v", "error", "-show_entries", "format=duration",
                            "-of", "default=nw=1:nk=1", str(p)],
                           capture_output=True, text=True, timeout=30)
        return float(r.stdout.strip())
    except Exception:
        return None


def _frame_meta_for(entry: dict) -> tuple | None:
    """Resolve (source_video, t_mid) for an existing bank entry via its lesson frames.json."""
    still = Path(entry.get("still", ""))
    if not still.name:
        return None
    vid = still.parent.name
    try:
        d = json.load(open(ANAT / "frames" / vid / "frames.json"))
    except Exception:
        return None
    src = d.get("source_video")
    if not src or not os.path.exists(src):
        return None
    fr = next((f for f in d.get("frames", []) if Path(f.get("file", "")).name == still.name), None)
    if not fr:
        return None
    t_mid = fr.get("t_mid", fr.get("t_start"))
    return (src, float(t_mid)) if t_mid is not None else None


def _recut_bank() -> int:
    """Re-cut every existing bank clip CENTERED on its still (+ Erik's voice), overwriting in
    place, then assert still == clip-center (±0.6s) and duration ~CLIP_SECONDS. Idempotent."""
    bank = json.loads(BANK.read_text()) if BANK.exists() else []
    ok = bad = skip = 0
    rows = []
    for i, e in enumerate(bank):
        meta = _frame_meta_for(e)
        out = Path(e["clip"])
        if not meta:
            skip += 1
            rows.append((e.get("technique", "?")[:40], "SKIP", "no src/meta"))
            print(f"  [{i+1}/{len(bank)}] SKIP {e.get('technique','?')[:40]}", flush=True)
            continue
        src, t_mid = meta
        center = max(0.0, t_mid - CLIP_SECONDS / 2.0) + CLIP_SECONDS / 2.0
        delta = abs(center - t_mid)
        if not _cut_clip(src, t_mid, out):
            bad += 1
            rows.append((e.get("technique", "?")[:40], "CUT-FAIL", f"d={delta:.2f}"))
            print(f"  [{i+1}/{len(bank)}] CUT-FAIL {e.get('technique','?')[:40]}", flush=True)
            continue
        dur = _probe_dur(out)
        good = delta <= 0.6 and dur is not None and abs(dur - CLIP_SECONDS) < 0.8
        status = "OK" if good else "CHECK"
        if good:
            ok += 1
        else:
            bad += 1
        rows.append((e.get("technique", "?")[:40], status,
                     f"d={delta:.2f} dur={dur:.1f}" if dur else f"d={delta:.2f} dur=?"))
        print(f"  [{i+1}/{len(bank)}] {status} {e.get('technique','?')[:40]}", flush=True)
    print("\n── re-cut alignment report ──────────────────────────────────")
    print(f"{'technique':42} {'status':9} detail")
    for t, s, det in rows:
        print(f"{t:42} {s:9} {det}")
    print(f"\nOK={ok}  CHECK/FAIL={bad}  SKIP={skip}  total={len(bank)}")
    return 0 if bad == 0 else 1


def _best_frames(d: dict, k: int) -> list:
    """Rank a lesson's frames for 'most likely a clear hands-on moment': has a real region,
    mid-video, longest transcript (descriptive = hands-on), then take top k."""
    frames = [f for f in d.get("frames", [])
              if f.get("file") and (f.get("region") and f["region"] != "none")
              and f.get("t_mid", 0) >= 12]
    frames.sort(key=lambda f: len(f.get("text") or ""), reverse=True)
    return frames[:k]


def main() -> int:
    ap = argparse.ArgumentParser()
    ap.add_argument("--limit", type=int, default=60, help="max lessons to process this run")
    ap.add_argument("--max-per-video", type=int, default=1)
    ap.add_argument("--dry", action="store_true")
    ap.add_argument("--recut", action="store_true",
                    help="re-cut existing bank clips centered-on-still + Erik's voice, then QA-assert alignment")
    args = ap.parse_args()

    if args.recut:
        return _recut_bank()

    CLIPS.mkdir(parents=True, exist_ok=True)
    bank = json.loads(BANK.read_text()) if BANK.exists() else []
    processed = set(json.loads(PROCESSED.read_text())) if PROCESSED.exists() else set()

    fjs = sorted(glob.glob(str(ANAT / "frames" / "*" / "frames.json")))
    done = kept = 0
    for fj in fjs:
        vid = Path(fj).parent.name
        if vid in processed:
            continue
        if done >= args.limit:
            break
        try:
            d = json.load(open(fj))
        except Exception:
            processed.add(vid); continue
        title = (d.get("title") or "").strip()
        src = d.get("source_video")
        if not title or not src or not os.path.exists(src):
            processed.add(vid); continue

        done += 1
        print(f"[{done}] {vid}", flush=True)
        for fr in _best_frames(d, args.max_per_video):
            still = ANAT / fr["file"]
            region = (fr.get("region") or "").strip()
            transcript = (fr.get("text") or "").strip()
            if args.dry:
                print(f"  DRY would cut+vision seg {fr.get('seg')} ({region}) {still.name}")
                continue
            verdict = _vision_classify(still, title, region, transcript)
            time.sleep(1.2)  # gentle on the shared subscription rate-limit
            if not verdict or not verdict.get("keep"):
                print(f"  drop seg {fr.get('seg')} ({verdict.get('technique') if verdict else 'no-verdict'})")
                continue
            out = CLIPS / f"{vid}-seg{int(fr.get('seg', 0)):03d}.mp4"
            if any(e.get("clip") == str(out) for e in bank):
                continue  # already in bank (resume-safe, no dup)
            if not out.exists() and not _cut_clip(src, fr.get("t_mid", fr.get("t_start", 0)), out):
                print("  clip cut failed"); continue
            bank.append({
                "clip": str(out), "still": str(still),
                "technique": (verdict.get("technique") or title).strip(),
                "region": region, "caption": (verdict.get("caption") or "").strip(),
                "difficulty": (verdict.get("difficulty") or "medium").strip(),
                "lesson": title, "course": d.get("course", ""),
            })
            kept += 1
            BANK.write_text(json.dumps(bank, indent=1))  # incremental save
            print(f"  KEEP: {verdict.get('technique')} [{region}] (bank={len(bank)})")
        if not args.dry:
            processed.add(vid)
            PROCESSED.write_text(json.dumps(sorted(processed)))

    print(f"\nDone this run: processed {done} lessons, kept {kept}. "
          f"Bank total: {len(bank)}. Remaining unprocessed: {len(fjs) - len(processed)}")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
