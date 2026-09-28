#!/usr/bin/env python3
"""astro_alerts.py — at-the-moment pushes (hourly cron, 08:00–22:00 ET):
  • timeline hits going exact within the next hour (canonical exact_at_local from astro_timeline)
  • Moon void-of-course starting within the hour
  • stations, lunations, eclipses within the hour
  • every Moon sign ingress and phase change (astro_moon posts; 12 h catch-up after quiet hours)
State in ~/portfolio/astrology/alerts_sent.json prevents repeats. `--dry` prints only; `--window N` minutes (default 60).
"""
from __future__ import annotations
import json, sys
from datetime import date, datetime, timedelta
from pathlib import Path
import astro_truth as T
import astro_lexicon as lex
import astro_timeline as TL
from svehla import send_to_lane

STATE = Path.home() / "portfolio/astrology/alerts_sent.json"
QUIET = (22, 8)                       # no pushes from 22:00 to 08:00 ET


def due(now: datetime | None = None, window_min: int = 60, lookback_min: int = 0) -> list[tuple[str, str]]:
    """(uid, text) for everything that goes exact in [now-lookback, now+window). The hourly run
    looks back 65 min so an alert whose send failed last hour goes out now (state is only
    written after a successful send)."""
    now = now or datetime.now(T.ET)
    end = now + timedelta(minutes=window_min)
    start = now - timedelta(minutes=lookback_min)
    out = []
    today = now.date()
    for e in TL.load():
        # the canonical localized instant from the timeline (same root finder as every other surface);
        # transit-frame aspects only — progressed "times" are date-precision by nature
        if e.get("kind") not in ("aspect", "to_progressed") or e.get("moving_frame") != "transit" or not e.get("exact_at_local"):
            continue
        t = T.round_minute(datetime.fromisoformat(e["exact_at_local"]))
        if start <= t < end:
            # one line: the meaning already went out in the 08:32 message (hits + 🗓 cover ±2 days)
            out.append((f"tl:{e['date']}:{e['key']}", f"⏰ Exact at {t:%-I:%M %p} ET: {e['what']}"))
    try:
        import astro_sky as SK
        voc = SK.void_of_course(now)
        vs = datetime.fromisoformat(voc["voc_start_et"])
        if start <= vs < end:
            ing = datetime.fromisoformat(voc["ingress_et"])
            out.append((f"voc:{vs.isoformat()}", f"🌙 Moon goes void-of-course at {vs:%-I:%M %p} until {ing:%a %-I:%M %p} ET — finish what's started, don't launch anything new."))
        ev = SK._events_in(today, 2)
        for st in ev.get("stations", []):
            t = datetime.fromisoformat(st["date_et"])
            if start <= t < end:
                out.append((f"st:{st['date_et']}", f"⏸ {st['body']} stations {'retrograde' if st['kind'] == 'retrograde' else 'direct'} at {t:%-I:%M %p} ET, {st['deg']}° {st['sign']} (your {T.ordinal(st['house'])} house) — the turning point; plans made this hour tend to stick."))
        for ln in ev.get("lunations", []) + ev.get("eclipses", []):
            t = datetime.fromisoformat(ln["date_et"])
            if start <= t < end:
                label = ("New Moon" if ln.get("kind") == "new" else "Full Moon") if "type" not in ln else f"{ln['type'].title()} {ln['kind']} eclipse"
                key = f"{label} in {ln['sign']}" if "type" not in ln else f"{ln['kind'].capitalize()} eclipse in the {T.ordinal(ln['house'])} house"
                ent = lex.kb_entry(key)
                out.append((f"lun:{ln['date_et']}", f"{'🌑' if 'New' in label or 'solar' in label else '🌕'} {label} exact at {t:%-I:%M %p} ET, {ln['deg']}° {ln['sign']} (your {T.ordinal(ln['house'])} house)" + (f" — {ent['translation']}" if ent else "")))
    except Exception as ex:
        out.append(("err", f"(sky alerts unavailable: {ex})"))
    # 2026-09-28 (Mike): a post every time the Moon changes sign or phase, read against his chart.
    # 12 h lookback so anything that happened during quiet hours goes out at the first 8 AM run.
    try:
        import astro_moon
        out += astro_moon.due(now - timedelta(minutes=max(lookback_min, 720 if lookback_min else 0)), end)
    except Exception as ex:
        out.append(("err", f"(moon posts unavailable: {ex})"))
    return out


def main() -> int:
    dry = "--dry" in sys.argv
    win = int(sys.argv[sys.argv.index("--window") + 1]) if "--window" in sys.argv else 60
    now = datetime.now(T.ET)
    if not dry and (now.hour >= QUIET[0] or now.hour < QUIET[1]):
        return 0
    sent = json.loads(STATE.read_text()) if STATE.exists() else {}
    items = [(u, t) for u, t in due(now, win, 0 if dry else 65) if u not in sent and u != "err"]
    if not items:
        print("nothing due"); return 0
    msg = "\n\n".join(t for _, t in items)
    print(msg)
    if not dry:
        from daily_transits import chunk_message
        for chunk in chunk_message(msg):          # never truncate: split under Telegram's cap
            if not send_to_lane(chunk):           # not marked sent → the next hourly run retries it
                print("✖ alert send failed — will retry next run", file=sys.stderr); return 1
        for u, _ in items:
            sent[u] = now.isoformat(timespec="minutes")
        cutoff = (now - timedelta(days=14)).isoformat()
        sent = {k: v for k, v in sent.items() if v >= cutoff}
        STATE.write_text(json.dumps(sent, indent=1))
    return 0


if __name__ == "__main__":
    sys.exit(main())
