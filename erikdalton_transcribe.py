#!/usr/bin/env python3
"""
Erik Dalton local video transcription pipeline.
Processes VOB (DVD rips) and MP4 files from Windows Desktop (via /mnt/c).
Usage:
  erikdalton_transcribe.py [--source all|dvd|massage] [--worker-id A]
  --source   which content set to process (default: all)
  --worker-id  label for PID/log files (default: main)
"""
import os, sys, json, subprocess, time, re, argparse
import queue, threading
from pathlib import Path

HOME = Path.home()
os.environ["PATH"] = f"{HOME}/.local/bin:/usr/local/bin:/usr/bin:/bin:" + os.environ.get("PATH", "")
FFMPEG = "/usr/bin/ffmpeg"

DVD_BASE  = Path("/mnt/c/Users/itsju/OneDrive/Desktop/Erik Dalton DVDs")
MSG_BASE  = Path("/mnt/c/Users/itsju/OneDrive/Desktop/Massage")

BASE  = HOME / "scrapes" / "erikdalton"
TX    = BASE / "transcripts"      # resume-seed .txt files
KB    = HOME / "erikdalton-kb" / "transcripts"
TMP   = Path("/tmp/ed_audio")
SECRETS = HOME / ".openclaw" / "secrets"
TODAY = time.strftime("%Y-%m-%d")

for p in (BASE, TX, KB, TMP):
    p.mkdir(parents=True, exist_ok=True)

ap = argparse.ArgumentParser()
ap.add_argument("--source", default="all", choices=["all", "dvd", "massage"],
                help="content set to process")
ap.add_argument("--worker-id", default="main", help="label for PID file and logs")
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
        cid = (SECRETS / "telegram-chat-id.txt").read_text().strip()
        import urllib.request, urllib.parse
        data = urllib.parse.urlencode({"chat_id": cid, "text": msg}).encode()
        urllib.request.urlopen(
            f"https://api.telegram.org/bot{tok}/sendMessage", data=data, timeout=15
        )
    except Exception as e:
        log(f"telegram failed: {e}")


def safe_id(source_path: Path) -> str:
    """Stable filesystem-safe ID from source file path."""
    for base in (DVD_BASE, MSG_BASE):
        try:
            rel = source_path.relative_to(base)
            return re.sub(r'[^\w]', '_', str(rel)).strip('_')[:120]
        except ValueError:
            pass
    return re.sub(r'[^\w]', '_', source_path.name)[:120]


def build_catalog(source_filter: str) -> list:
    """
    Returns list of dicts:
      {id, path, title, course_title, course_slug}
    Strategy per directory:
      - If mp4 files exist → use them (skip VOBs, already decoded)
      - Else use content VOBs (skip VIDEO_TS.VOB + VTS_XX_0.VOB)
    """
    entries = []

    def _process_dir(d: Path, source_root: Path, source_label: str):
        mp4s = sorted(d.glob("*.mp4")) + sorted(d.glob("*.MP4"))
        content_vobs = sorted([
            v for v in d.glob("*.VOB")
            if not v.name.startswith("VIDEO_TS")
            and not re.search(r'VTS_\d+_0\.VOB$', v.name)
        ])
        files_to_use = mp4s if mp4s else content_vobs
        if not files_to_use:
            return

        # Derive course hierarchy from relative path
        rel_parts = d.relative_to(source_root).parts
        if not rel_parts:
            return  # files at root — skip, handled by subdirs

        # course = first part; if nested, append second part for context
        course_name = rel_parts[0]
        if len(rel_parts) >= 2:
            course_title = f"{rel_parts[0]} — {rel_parts[1]}"
        else:
            course_title = rel_parts[0]

        course_slug = f"{source_label}_{re.sub(r'[^a-z0-9]+', '_', course_name.lower()).strip('_')}"

        for f in files_to_use:
            fid = safe_id(f)
            entries.append({
                "id": fid,
                "path": f,
                "title": f.stem,
                "course_title": course_title,
                "course_slug": course_slug,
                "source": source_label,
            })

    sources = []
    if source_filter in ("all", "dvd"):
        sources.append((DVD_BASE, "dvd"))
    if source_filter in ("all", "massage"):
        sources.append((MSG_BASE, "massage"))

    for root, label in sources:
        for d in sorted(root.rglob("*")):
            if d.is_dir():
                _process_dir(d, root, label)

    return entries


def extract_audio(entry: dict) -> Path | None:
    """Extract audio from source video to /tmp/ed_audio/<id>.mp3."""
    fid = entry["id"]
    out = TMP / f"{fid}.mp3"
    try:
        # Clean up any stale tmp file
        if out.exists():
            out.unlink()
        cmd = [
            FFMPEG, "-y", "-i", str(entry["path"]),
            "-vn", "-ac", "1", "-ar", "16000",
            "-f", "mp3", str(out),
            "-loglevel", "error"
        ]
        subprocess.run(cmd, timeout=600, check=True)
        return out if out.exists() and out.stat().st_size > 1024 else None
    except Exception as e:
        log(f"  ffmpeg ERROR {entry['title']}: {e}")
        return None


def write_md(entry: dict, text: str, segs: list):
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
        f"source: erikdalton\n"
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
catalog = build_catalog(ARGS.source)
TOTAL = len(catalog)

# ---- load model ----
from faster_whisper import WhisperModel, BatchedInferencePipeline
log(f"loading GPU model; {TOTAL} items, source={ARGS.source}, worker={ARGS.worker_id}")
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


def transcribe_item(entry: dict, prefetched_audio=None) -> bool:
    fid = entry["id"][:80]
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
        segs = list(segs_gen)
        elapsed = time.time() - t0
        text = " ".join(s.text.strip() for s in segs)
        if not text.strip():
            log(f"  EMPTY transcript {title}")
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
        speed = round(info.duration / elapsed, 1) if elapsed > 0 else 0
        log(f"  OK {title} — {len(text)}ch, {round(info.duration/60,1)}min, {round(elapsed,1)}s ({speed}x)")
        return True
    except Exception as ex:
        log(f"  ERROR {title}: {ex}")
        try: [f.unlink() for f in TMP.glob(f"{fid}*")]
        except: pass
        return False


# ---- flatten for prefetch ----
all_flat = [(e, (TX / f"{e['id'][:80]}.txt").exists()) for e in catalog]
prefetch_iter = ((e, skip) for e, skip in all_flat)
_pf = threading.Thread(target=_prefetch_worker, args=(prefetch_iter,), daemon=True, name="prefetch")
_pf.start()
log("prefetch thread started")

# ---- main loop ----
processed = done_count
current_course = None

for entry, skip in all_flat:
    ct = entry["course_title"]
    if ct != current_course:
        current_course = ct
        log(f"== COURSE: {ct} ==")

    item = _prefetch_q.get()
    if item is _STOP:
        break
    fetched_entry, audio = item

    if skip:
        continue

    if transcribe_item(entry, prefetched_audio=audio):
        processed = sum(1 for e in catalog if (TX / f"{e['id'][:80]}.txt").exists())

    try:
        (BASE / "transcribe_status.json").write_text(json.dumps({
            "updated": time.strftime("%Y-%m-%d %H:%M:%S"),
            "worker": ARGS.worker_id,
            "source": ARGS.source,
            "transcribed": processed,
            "total": TOTAL,
        }))
    except Exception:
        pass

_pf.join(timeout=5)
log(f"ALL DONE worker-{ARGS.worker_id}: {processed}/{TOTAL}")
telegram(
    f"✅ Erik Dalton worker-{ARGS.worker_id} DONE: {processed}/{TOTAL} items transcribed.\n"
    f"Source: {ARGS.source}\n"
    f"Run: python ~/erikdalton-kb/sync.py --reindex"
)

# Check if all items from both sources are now done
all_catalog = build_catalog("all")
all_done = sum(1 for e in all_catalog if (TX / f"{e['id'][:80]}.txt").exists())
if all_done >= len(all_catalog):
    (BASE / ".transcribe_done").write_text(time.strftime("%Y-%m-%d %H:%M:%S"))
    telegram(f"🎓 Erik Dalton ALL {all_done} items DONE! Run: python ~/erikdalton-kb/sync.py --reindex")
