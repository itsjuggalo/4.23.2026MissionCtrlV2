#!/usr/bin/env python3
"""
Vibe Coding Academy local video transcription pipeline.
Processes MP4 files from Windows Desktop.
Usage: vibecoding_transcribe.py [--worker-id A] [--courses slug1,slug2]
"""
import os, sys, json, subprocess, time, re, argparse
import queue, threading
from pathlib import Path

HOME = Path.home()
os.environ["PATH"] = f"{HOME}/.local/bin:/usr/local/bin:/usr/bin:/bin:" + os.environ.get("PATH", "")
FFMPEG = "/usr/bin/ffmpeg"

VCA_BASE = Path("/mnt/c/Users/itsju/OneDrive/Desktop/Vibe Coding Academy")

BASE    = HOME / "scrapes" / "vibecoding"
TX      = BASE / "transcripts"
KB      = HOME / "vibecoding-kb" / "transcripts"
TMP     = Path("/tmp/vc_audio")
SECRETS = HOME / ".openclaw" / "secrets"
TODAY   = time.strftime("%Y-%m-%d")

for p in (BASE, TX, KB, TMP):
    p.mkdir(parents=True, exist_ok=True)

ap = argparse.ArgumentParser()
ap.add_argument("--worker-id", default="main")
ap.add_argument("--courses", default="", help="comma-separated course slugs to process (default: all)")
ap.add_argument("--batch-size", type=int, default=16)
ARGS = ap.parse_args()

LOG = BASE / f"transcribe_{ARGS.worker_id}.log"
_log_lock = threading.Lock()


def log(m):
    line = f"[{time.strftime('%Y-%m-%d %H:%M:%S')}] {m}"
    print(line, flush=True)
    try:
        with _log_lock:
            open(LOG, "a").write(line + "\n")
    except Exception:
        pass


def telegram(msg):
    try:
        tok = (SECRETS / "telegram_laptopclaude_bot_token").read_text().strip()
        cid  = (SECRETS / "telegram-chat-id.txt").read_text().strip()
        import urllib.request, urllib.parse
        data = urllib.parse.urlencode({"chat_id": cid, "text": msg}).encode()
        urllib.request.urlopen(
            f"https://api.telegram.org/bot{tok}/sendMessage", data=data, timeout=15)
    except Exception as e:
        log(f"telegram failed: {e}")


def safe_id(path: Path) -> str:
    try:
        rel = path.relative_to(VCA_BASE)
        return re.sub(r'[^\w]', '_', str(rel)).strip('_')[:120]
    except ValueError:
        return re.sub(r'[^\w]', '_', path.name)[:120]


def build_catalog(course_filter=None):
    entries = []
    for d in sorted(VCA_BASE.rglob("*")):
        if not d.is_dir():
            continue
        mp4s = sorted(d.glob("*.mp4")) + sorted(d.glob("*.MP4"))
        if not mp4s:
            continue
        rel_parts = d.relative_to(VCA_BASE).parts
        if not rel_parts:
            continue
        course_name  = rel_parts[0]
        course_title = f"{rel_parts[0]} — {rel_parts[1]}" if len(rel_parts) >= 2 else rel_parts[0]
        course_slug  = re.sub(r'[^a-z0-9]+', '_', course_name.lower()).strip('_')

        if course_filter and course_slug not in course_filter:
            continue

        for f in mp4s:
            # Title: strip trailing " - CourseName · Vibe Coding Academy"
            stem = f.stem
            clean = re.sub(r'\s*-\s*[^·]+ · Vibe Coding Academy.*$', '', stem).strip()
            clean = re.sub(r'^\d+[a-z]?\.\s*', '', clean).strip()  # strip leading "1. " "18a. "
            title = clean if clean else stem
            entries.append({
                "id":           safe_id(f),
                "path":         f,
                "title":        title,
                "course_title": course_title,
                "course_slug":  course_slug,
            })
    return entries


def extract_audio(entry) -> Path | None:
    fid = entry["id"]
    out = TMP / f"{fid[:80]}.mp3"
    try:
        if out.exists():
            out.unlink()
        subprocess.run(
            [FFMPEG, "-y", "-i", str(entry["path"]),
             "-vn", "-ac", "1", "-ar", "16000", "-f", "mp3", str(out),
             "-loglevel", "error"],
            timeout=600, check=True)
        return out if out.exists() and out.stat().st_size > 1024 else None
    except Exception as e:
        log(f"  ffmpeg ERROR {entry['title']}: {e}")
        return None


def write_md(entry, text, segs):
    course_dir = KB / entry["course_slug"]
    course_dir.mkdir(parents=True, exist_ok=True)
    paragraphs, buf, last_ts = [], [], 0.0
    for s in segs:
        buf.append(s["t"])
        if s["e"] - last_ts >= 30:
            paragraphs.append(" ".join(buf).strip())
            buf, last_ts = [], s["e"]
    if buf:
        paragraphs.append(" ".join(buf).strip())
    body = "\n\n".join(p for p in paragraphs if p)
    md = (
        f"---\n"
        f"source: vibe-coding-academy\n"
        f"course: \"{entry['course_title']}\"\n"
        f"title: \"{entry['title']}\"\n"
        f"transcribed: \"{TODAY}\"\n"
        f"---\n\n"
        f"## {entry['title']}\n\n"
        f"*Course: {entry['course_title']}*\n\n"
        f"{body}\n"
    )
    (course_dir / f"{entry['id'][:80]}.md").write_text(md, encoding="utf-8")


# ---- write PID ----
(BASE / f"transcribe_{ARGS.worker_id}.pid").write_text(str(os.getpid()))

# ---- build catalog ----
course_filter = set(s.strip() for s in ARGS.courses.split(",")) if ARGS.courses else None
catalog = build_catalog(course_filter)
TOTAL = len(catalog)

# ---- load model ----
from faster_whisper import WhisperModel, BatchedInferencePipeline
log(f"loading GPU model; {TOTAL} items, worker={ARGS.worker_id}")
_base = WhisperModel("base.en", device="cuda", compute_type="int8_float16")
model = BatchedInferencePipeline(model=_base)
log("model loaded")

done_count = sum(1 for e in catalog if (TX / f"{e['id'][:80]}.txt").exists())
log(f"resume: {done_count}/{TOTAL} already done")

# ---- prefetch queue ----
_STOP = object()
_prefetch_q = queue.Queue(maxsize=2)


def _prefetch_worker(entries_iter):
    for entry, skip in entries_iter:
        if skip:
            _prefetch_q.put((entry, None))
            continue
        try:
            audio = extract_audio(entry)
            _prefetch_q.put((entry, audio))
        except Exception as ex:
            log(f"  prefetch ERROR {entry['title']}: {ex}")
            _prefetch_q.put((entry, None))
    _prefetch_q.put(_STOP)


def transcribe_item(entry, prefetched_audio=None):
    fid     = entry["id"][:80]
    txt_path = TX / f"{fid}.txt"
    if txt_path.exists():
        return True
    title = entry["title"]
    try:
        audio = prefetched_audio or extract_audio(entry)
        if not audio:
            log(f"  no audio: {title}")
            return False
        t0 = time.time()
        segs_gen, info = model.transcribe(str(audio), batch_size=ARGS.batch_size, vad_filter=True)
        segs    = list(segs_gen)
        elapsed = time.time() - t0
        text    = " ".join(s.text.strip() for s in segs)
        if not text.strip():
            log(f"  EMPTY {title}")
            try: audio.unlink()
            except: pass
            return False
        txt_path.write_text(text, encoding="utf-8")
        (TX / f"{fid}.json").write_text(json.dumps({
            "id": fid, "title": title, "course": entry["course_title"],
            "duration": round(info.duration, 1),
            "segments": [{"s": round(s.start,1), "e": round(s.end,1), "t": s.text.strip()} for s in segs]
        }))
        seg_dicts = [{"s": round(s.start,1), "e": round(s.end,1), "t": s.text.strip()} for s in segs]
        write_md(entry, text, seg_dicts)
        try: audio.unlink()
        except: pass
        speed = round(info.duration / elapsed, 1) if elapsed else 0
        log(f"  OK {title} — {len(text)}ch, {round(info.duration/60,1)}min, {round(elapsed,1)}s ({speed}x)")
        return True
    except Exception as ex:
        log(f"  ERROR {title}: {ex}")
        try: [f.unlink() for f in TMP.glob(f"{fid}*")]
        except: pass
        return False


all_flat   = [(e, (TX / f"{e['id'][:80]}.txt").exists()) for e in catalog]
prefetch_iter = ((e, skip) for e, skip in all_flat)
_pf = threading.Thread(target=_prefetch_worker, args=(prefetch_iter,), daemon=True, name="prefetch")
_pf.start()
log("prefetch thread started")

processed     = done_count
current_course = None

for entry, skip in all_flat:
    ct = entry["course_title"]
    if ct != current_course:
        current_course = ct
        log(f"== COURSE: {ct} ==")

    item = _prefetch_q.get()
    if item is _STOP:
        break
    _, audio = item

    if skip:
        continue

    if transcribe_item(entry, prefetched_audio=audio):
        processed = sum(1 for e in catalog if (TX / f"{e['id'][:80]}.txt").exists())

    try:
        (BASE / "transcribe_status.json").write_text(json.dumps({
            "updated": time.strftime("%Y-%m-%d %H:%M:%S"),
            "worker": ARGS.worker_id,
            "transcribed": processed,
            "total": TOTAL,
        }))
    except Exception:
        pass

_pf.join(timeout=5)
log(f"ALL DONE worker-{ARGS.worker_id}: {processed}/{TOTAL}")
telegram(
    f"✅ Vibe Coding Academy worker-{ARGS.worker_id} DONE: {processed}/{TOTAL} transcribed.\n"
    f"Run: python ~/vibecoding-kb/sync.py --reindex"
)

all_done = sum(1 for e in build_catalog() if (TX / f"{e['id'][:80]}.txt").exists())
if all_done >= len(build_catalog()):
    (BASE / ".transcribe_done").write_text(time.strftime("%Y-%m-%d %H:%M:%S"))
    telegram(f"🎓 Vibe Coding Academy ALL {all_done} videos DONE!\npython ~/vibecoding-kb/sync.py --reindex")
