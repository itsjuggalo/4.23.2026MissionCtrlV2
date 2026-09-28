#!/usr/bin/env python3
"""astro_profiles.py — birth profiles (the SUBJECT layer). Every chart the bot computes for a
person other than Mike comes from a stored profile; there is no guessing from a name.

Store: ~/portfolio/astrology/profiles.json (chmod 600; override with $ASTRO_PROFILES for tests).
Profile = {id, name, birth_date, birth_time|None, time_known, place, lat, lon, tz, natal_jd}.
  • birth time unknown → time_known False, charts use local NOON for planets and NEVER compute
    ASC/MC/houses (reported UNAVAILABLE).
  • local birth time → UT through zoneinfo (historical DST from the tz database).
  • place → lat/lon via OpenStreetMap Nominatim (free; generic User-Agent, no personal data sent
    beyond the place string) → tz via timezonefinder (offline). Or pass lat,lon,tz explicitly.

  astro_profiles.py list
  astro_profiles.py add <name> <YYYY-MM-DD> <HH:MM|unknown> <place...>
  astro_profiles.py add <name> <YYYY-MM-DD> <HH:MM|unknown> --coords <lat> <lon> <tz>
  astro_profiles.py show <name> · delete <name>
"""
from __future__ import annotations

import json
import os
import re
import sys
from datetime import date, datetime, time as dtime
from pathlib import Path
from zoneinfo import ZoneInfo

sys.path.insert(0, str(Path(__file__).resolve().parent))
import astro_truth as T  # noqa: E402
import swisseph as swe  # noqa: E402

USER_AGENT = "mike-astrology-bot/1.0 (personal, non-commercial)"


def store_path() -> Path:
    return Path(os.environ.get("ASTRO_PROFILES", str(Path.home() / "portfolio/astrology/profiles.json")))


MIKE = {"id": "mike", "name": "Mike", "birth_date": "1992-11-03", "birth_time": "22:46", "time_known": True,
        "place": "Dunedin, FL", "lat": T.LAT, "lon": T.LON, "tz": "America/New_York",
        "natal_jd": T.NATAL_JD, "builtin": True}


def slug(name: str) -> str:
    return re.sub(r"[^a-z0-9]+", "-", name.strip().lower()).strip("-")


def _load() -> dict:
    """Missing store → {}. A store that exists but can't be parsed RAISES (review B14) — returning {}
    would let the next add() silently overwrite every saved profile."""
    p = store_path()
    if not p.exists():
        return {}
    try:
        return json.loads(p.read_text())
    except Exception as e:
        raise RuntimeError(f"profile store {p} is unreadable ({type(e).__name__}); fix or restore it — nothing overwritten") from e


def _save(d: dict) -> None:
    p = store_path()
    p.parent.mkdir(parents=True, exist_ok=True)
    tmp = p.with_suffix(".tmp")
    tmp.write_text(json.dumps(d, indent=1))
    os.chmod(tmp, 0o600)
    tmp.replace(p)
    os.chmod(p, 0o600)


def local_time_status(birth_date: str, birth_time: str | None, tz: str) -> str:
    """'ok' | 'gap' (wall time skipped by a DST jump — it never happened) | 'fold' (happened twice)."""
    d = date.fromisoformat(birth_date)
    hh, mm = (int(x) for x in (birth_time or "12:00").split(":"))
    z = ZoneInfo(tz)
    dt = datetime.combine(d, dtime(hh, mm), tzinfo=z)
    back = dt.astimezone(ZoneInfo("UTC")).astimezone(z)
    if (back.hour, back.minute) != (hh, mm):
        return "gap"
    return "fold" if dt.replace(fold=0).utcoffset() != dt.replace(fold=1).utcoffset() else "ok"


def natal_jd(birth_date: str, birth_time: str | None, tz: str) -> float:
    """UT Julian day of a LOCAL birth moment (unknown time → local noon, flagged by the caller).
    Review A11: a time inside a DST gap raises; an ambiguous (fold) time takes the first occurrence
    (fold=0) and add() records it as ambiguous_time."""
    if local_time_status(birth_date, birth_time, tz) == "gap":
        raise ValueError(f"{birth_date} {birth_time} does not exist in {tz} (clocks jumped forward) — check the birth time")
    d = date.fromisoformat(birth_date)
    hh, mm = (int(x) for x in (birth_time or "12:00").split(":"))
    return T.jd_for(datetime.combine(d, dtime(hh, mm), tzinfo=ZoneInfo(tz)))


def geocode(place: str) -> tuple[float, float, str]:
    import requests
    from timezonefinder import TimezoneFinder
    r = requests.get("https://nominatim.openstreetmap.org/search",
                     params={"q": place, "format": "json", "limit": 1},
                     headers={"User-Agent": USER_AGENT}, timeout=20)
    r.raise_for_status()
    hits = r.json()
    if not hits:
        raise ValueError(f"place not found: {place!r} — try 'City, State' or pass --coords")
    lat, lon = float(hits[0]["lat"]), float(hits[0]["lon"])
    tz = TimezoneFinder().timezone_at(lat=lat, lng=lon)
    if not tz:
        raise ValueError("no timezone for those coordinates — pass --coords with a tz")
    return lat, lon, tz


def add(name: str, birth_date: str, birth_time: str | None, place: str = "",
        lat: float | None = None, lon: float | None = None, tz: str | None = None) -> dict:
    pid = slug(name)
    if pid == "mike":
        raise ValueError("'mike' is the built-in profile")
    date.fromisoformat(birth_date)                               # validates
    if birth_time and birth_time.lower() in ("unknown", "?", "none", "-"):
        birth_time = None
    if birth_time and not re.fullmatch(r"([01]?\d|2[0-3]):[0-5]\d", birth_time):
        raise ValueError("birth time must be HH:MM (24h) or 'unknown'")
    if lat is None or lon is None or not tz:
        lat, lon, tz = geocode(place)
    ZoneInfo(tz)                                                 # validates
    old = _load().get(pid)
    if old and old["name"] != name.strip():
        raise ValueError(f"'{name}' collides with stored profile '{old['name']}' — /profile delete {old['name']} first")
    prof = {"id": pid, "name": name.strip(), "birth_date": birth_date, "birth_time": birth_time,
            "time_known": birth_time is not None, "place": place, "lat": round(lat, 4), "lon": round(lon, 4),
            "tz": tz, "natal_jd": natal_jd(birth_date, birth_time, tz),
            "ambiguous_time": bool(birth_time) and local_time_status(birth_date, birth_time, tz) == "fold",
            "created_at": T.now_local().isoformat(timespec="seconds")}
    d = _load(); d[pid] = prof; _save(d)
    return prof


def get(name: str) -> dict | None:
    pid = slug(name)
    if pid in ("mike", "me", "my", "mine"):
        return dict(MIKE)
    return _load().get(pid)


def all_profiles() -> list[dict]:
    return [dict(MIKE)] + list(_load().values())


def delete(name: str) -> bool:
    d = _load()
    if slug(name) in d:
        del d[slug(name)]; _save(d); return True
    return False


def summary(p: dict) -> str:
    t = p["birth_time"] if p.get("time_known") else "time unknown (no ASC/houses)"
    if p.get("ambiguous_time"):
        t += " (ambiguous — clocks fell back that hour; the first occurrence is used)"
    where = p.get("place") or f"{p['lat']:.2f}, {p['lon']:.2f}"
    return f"{p['name']} — {p['birth_date']} {t} · {where} ({p['tz']})"


def main() -> int:
    a = sys.argv[1:]
    cmd = a[0] if a else "list"
    try:
        if cmd == "list":
            for p in all_profiles():
                print(summary(p))
        elif cmd == "add" and len(a) >= 4:
            name, bd, bt = a[1], a[2], a[3]
            if "--coords" in a:
                i = a.index("--coords")
                p = add(name, bd, bt, "", float(a[i + 1]), float(a[i + 2]), a[i + 3])
            else:
                p = add(name, bd, bt, " ".join(a[4:]))
            print("saved: " + summary(p))
        elif cmd == "show" and len(a) > 1:
            p = get(a[1]); print(summary(p) if p else "no such profile")
        elif cmd == "delete" and len(a) > 1:
            print("deleted" if delete(a[1]) else "no such profile")
        else:
            print(__doc__); return 2
    except Exception as e:
        print(f"✖ {e}"); return 1
    return 0


if __name__ == "__main__":
    sys.exit(main())
