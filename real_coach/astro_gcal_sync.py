#!/usr/bin/env python3
"""astro_gcal_sync.py — push Svehla windows + exact hits into Mike's Google Calendar (idea #3).

Idempotent: every event carries extendedProperties.private.svehla_uid; re-running updates
changed titles/dates and inserts new ones, never duplicates. All-day, free (transparent),
3-day popup reminder. Uses the existing ~/.config/calendar/token.json (calendar.events scope).
Run after editing svehla_windows.json or rebuilding exact hits:  astro_gcal_sync.py [--dry]
"""
from __future__ import annotations

import json
import sys
from datetime import date, timedelta
from pathlib import Path

from google.auth.transport.requests import Request
from google.oauth2.credentials import Credentials
from googleapiclient.discovery import build

sys.path.insert(0, str(Path(__file__).resolve().parent))
import svehla  # noqa: E402

TOKEN = Path.home() / ".config/calendar/token.json"
CAL_ID = "primary"
COLOR_WINDOW, COLOR_EXACT, COLOR_TIMELINE = "3", "9", "7"     # grape / blueberry / peacock in Google's palette
DRY = "--dry" in sys.argv


def wanted() -> dict[str, dict]:
    out = {}
    for w in svehla.load_windows():
        out[w["id"]] = {
            "summary": f"🔮 {w['title']}",
            "description": f"WHY: {w['why']}\n\nDO: {w['do']}\n\nSvehla, Aug 29 2026 reading · Telegram /dates",
            "start": {"date": w["_start"].isoformat()},
            "end": {"date": (w["_end"] + timedelta(days=1)).isoformat()},
            "colorId": COLOR_WINDOW,
        }
    for h in svehla.exact_hits():
        d = date.fromisoformat(h["date"])
        uid = "exact-" + h["date"] + "-" + "".join(c for c in h["what"] if c.isalnum())[:40]
        out[uid] = {
            "summary": f"⏰ {h['what']}",
            "description": "Exact hit (0° orb), Swiss Ephemeris. Aug 2026 Svehla reading layer · Telegram /exact",
            "start": {"date": d.isoformat()},
            "end": {"date": (d + timedelta(days=1)).isoformat()},
            "colorId": COLOR_EXACT,
        }
    # round 9: the dated timeline (real ephemeris) — outer-planet hard aspects, house/sign changes, eclipses,
    # progressed-Moon changes, transits to progressed points, sky-to-sky. Skips fast-asteroid noise.
    try:
        import astro_timeline
        for e in astro_timeline.load():
            k = e["kind"]
            keep = (k in ("eclipse", "sky", "to_progressed")
                    or (k in ("sign", "house") and e["body"] in ("Jupiter", "Saturn", "Uranus", "Neptune", "Pluto", "Chiron"))
                    or (k == "progressed" and (not e.get("aspect") or e["aspect"] in ("conjunct", "opposite", "square")))
                    or (k == "aspect" and e["body"] in ("Saturn", "Uranus", "Neptune", "Pluto", "Chiron") and e.get("aspect") in ("conjunct", "square", "opposite"))
                    or (k == "aspect" and e["body"] == "Jupiter" and e.get("aspect") == "conjunct"))
            if not keep:
                continue
            d = date.fromisoformat(e["date"])
            uid = "tl-" + e["date"] + "-" + "".join(c for c in e["key"] if c.isalnum())[:48]
            if uid in out:
                continue
            meaning = astro_timeline._meaning(e, full=True)
            out[uid] = {
                "summary": f"🗓 {e['what']}",
                "description": (meaning + "\n\n" if meaning else "") + "Timeline layer (Swiss Ephemeris, Placidus) · Telegram /timeline",
                "start": {"date": d.isoformat()},
                "end": {"date": (d + timedelta(days=1)).isoformat()},
                "colorId": COLOR_TIMELINE,
            }
    except Exception as ex:
        print(f"[timeline skipped: {ex}]", file=sys.stderr)
    for v in out.values():
        v["transparency"] = "transparent"
        v["reminders"] = {"useDefault": False, "overrides": [{"method": "popup", "minutes": 3 * 24 * 60}]}
    return out


def _do(fn, tries: int = 6):
    """Google Calendar write with pacing + exponential backoff on 403 rateLimitExceeded / 5xx."""
    import time
    from googleapiclient.errors import HttpError
    for i in range(tries):
        try:
            r = fn()
            time.sleep(0.35)                      # ~3 writes/s keeps us under the per-user quota
            return r
        except HttpError as e:
            if e.resp.status in (403, 429, 500, 503) and i < tries - 1:
                time.sleep(2 ** i)
                continue
            raise


def main() -> int:
    creds = Credentials.from_authorized_user_file(str(TOKEN))
    if not creds.valid:
        creds.refresh(Request())
        TOKEN.write_text(creds.to_json())
    svc = build("calendar", "v3", credentials=creds, cache_discovery=False)
    existing = {}
    page = None
    while True:
        r = svc.events().list(calendarId=CAL_ID, privateExtendedProperty="svehla=1", maxResults=250,
                              pageToken=page, showDeleted=False, singleEvents=True).execute()
        for e in r.get("items", []):
            uid = (e.get("extendedProperties", {}).get("private", {}) or {}).get("svehla_uid")
            if uid:
                existing[uid] = e
        page = r.get("nextPageToken")
        if not page:
            break
    ins = upd = same = 0
    for uid, body in wanted().items():
        body["extendedProperties"] = {"private": {"svehla": "1", "svehla_uid": uid}}
        e = existing.get(uid)
        if e is None:
            ins += 1
            if not DRY:
                _do(lambda: svc.events().insert(calendarId=CAL_ID, body=body).execute())
        elif (e.get("summary") != body["summary"] or e["start"].get("date") != body["start"]["date"]
              or e["end"].get("date") != body["end"]["date"] or e.get("description") != body["description"]):
            upd += 1
            if not DRY:
                _do(lambda: svc.events().patch(calendarId=CAL_ID, eventId=e["id"], body=body).execute())
        else:
            same += 1
    print(f"gcal sync{' (dry)' if DRY else ''}: {ins} inserted, {upd} updated, {same} unchanged, {len(existing)} were already there")
    return 0


if __name__ == "__main__":
    sys.exit(main())
