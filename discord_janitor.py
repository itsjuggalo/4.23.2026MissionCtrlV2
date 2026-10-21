#!/usr/bin/env python3
"""Discord janitor — inventory the MissionCtrl guild and park stale channels (Mike 2026-10-20).

Moves, never deletes:
- a text channel with no message for STALE_DAYS (or never) moves into the bottom category
  "🗄️ STALE — REVIEW" (overflow "🗄️ STALE — REVIEW ②", Discord caps a category at 50 channels);
- a parked channel that has a message again within REVIVE_DAYS moves back to the category it came from;
- every move is recorded in the restore map (accumulates, never clobbered), so any channel can be put back.

Usage:  discord_janitor.py              # dry run: print the plan, change nothing
        discord_janitor.py --apply      # move channels, write the map, post a summary to #system-logs
        discord_janitor.py --restore ID # move one parked channel back to its original category
Config: discord_janitor_config.json next to this file (exempt names/categories, thresholds).
Credentials come from ~/.openclaw/secrets/ only; nothing is printed.
"""
import argparse, datetime as dt, json, os, sys, time, urllib.error, urllib.request
from pathlib import Path
from zoneinfo import ZoneInfo

ET = ZoneInfo("America/New_York")
SECRETS = Path.home() / ".openclaw/secrets"
STATE = Path.home() / ".openclaw/data/discord"
MAP_PATH = STATE / "stale_restore_map.json"
INV_PATH = STATE / "inventory.json"
CFG = json.loads((Path(__file__).resolve().parent / "discord_janitor_config.json").read_text())
API = "https://discord.com/api/v10"
STALE_CATS = ["🗄️ STALE — REVIEW", "🗄️ STALE — REVIEW ②", "🗄️ STALE — REVIEW ③"]
CAT_MAX = 50


def _secret(name):
    return (SECRETS / name).read_text().strip()


TOKEN = _secret("discord_synthcontrol_token")
GUILD = _secret("discord_guild_id")


def call(method, path, body=None):
    for _ in range(6):
        req = urllib.request.Request(API + path, method=method,
                                     data=None if body is None else json.dumps(body).encode(),
                                     headers={"Authorization": "Bot " + TOKEN, "User-Agent": "DiscordBot (mc-janitor, 1.0)",
                                              "Content-Type": "application/json"})
        try:
            with urllib.request.urlopen(req, timeout=20) as r:
                raw = r.read()
                return json.loads(raw) if raw else None
        except urllib.error.HTTPError as e:
            if e.code == 429:
                time.sleep(float(json.loads(e.read() or b"{}").get("retry_after", 1)) + 0.3)
                continue
            raise RuntimeError(f"Discord {method} {path.split('?')[0]} -> HTTP {e.code}") from None
    raise RuntimeError(f"Discord {method} {path.split('?')[0]} -> still rate limited")


def now_et():
    return dt.datetime.now(ET)


def last_message_at(ch):
    """Data time of the newest message (ET), or None when the channel has never had one."""
    if ch["type"] == 15:  # forum: use the snowflake of the newest thread/message id
        lm = ch.get("last_message_id")
        return dt.datetime.fromtimestamp(((int(lm) >> 22) + 1420070400000) / 1000, tz=ET) if lm else None
    msgs = call("GET", f"/channels/{ch['id']}/messages?limit=1")
    return dt.datetime.fromisoformat(msgs[0]["timestamp"]).astimezone(ET) if msgs else None


def inventory():
    chans = call("GET", f"/guilds/{GUILD}/channels")
    cats = {c["id"]: c for c in chans if c["type"] == 4}
    rows = []
    for c in chans:
        if c["type"] not in (0, 5, 15):
            continue
        last = last_message_at(c)
        rows.append({"id": c["id"], "name": c["name"], "type": c["type"], "parent_id": c.get("parent_id"),
                     "category": cats.get(c.get("parent_id"), {}).get("name", "(none)"), "position": c["position"],
                     "last_message_et": last.isoformat() if last else None,
                     "age_days": round((now_et() - last).total_seconds() / 86400, 1) if last else None})
    return chans, cats, rows


def exempt(r):
    return r["name"] in CFG["exempt_names"] or r["category"] in CFG["exempt_categories"]


def load_map():
    return json.loads(MAP_PATH.read_text()) if MAP_PATH.exists() else {}


def ensure_stale_cat(cats, chans, needed_idx):
    by_name = {c["name"]: c for c in cats.values()}
    name = STALE_CATS[needed_idx]
    if name in by_name:
        return by_name[name]["id"]
    top = max([c["position"] for c in chans if c["type"] == 4] + [0]) + 1
    cat = call("POST", f"/guilds/{GUILD}/channels", {"name": name, "type": 4, "position": top})
    cats[cat["id"]] = cat
    chans.append(cat)
    return cat["id"]


def plan(rows, cats):
    stale_ids = {cid for cid, c in cats.items() if c["name"] in STALE_CATS}
    parked = [r for r in rows if r["parent_id"] in stale_ids]
    to_park = [r for r in rows if r["parent_id"] not in stale_ids and not exempt(r)
               and (r["age_days"] is None or r["age_days"] >= CFG["stale_days"])]
    to_revive = [r for r in parked if r["age_days"] is not None and r["age_days"] < CFG["revive_days"]]
    return parked, to_park, to_revive


def post_summary(text):
    ch = CFG.get("summary_channel_id")
    if ch:
        call("POST", f"/channels/{ch}/messages", {"content": text[:1990], "allowed_mentions": {"parse": []}})


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("--apply", action="store_true")
    ap.add_argument("--restore")
    a = ap.parse_args()
    STATE.mkdir(parents=True, exist_ok=True)
    rmap = load_map()

    if a.restore:
        m = rmap.get(a.restore)
        if not m:
            sys.exit(f"channel {a.restore} is not in the restore map")
        call("PATCH", f"/channels/{a.restore}", {"parent_id": m["parent_id"], "lock_permissions": False})
        m["restored_at"] = now_et().isoformat()
        rmap[a.restore] = m
        MAP_PATH.write_text(json.dumps(rmap, indent=1, ensure_ascii=False))
        print(f"restored #{m['name']} → {m['category']}")
        return

    chans, cats, rows = inventory()
    INV_PATH.write_text(json.dumps({"as_of_et": now_et().isoformat(), "channels": rows}, indent=1, ensure_ascii=False))
    parked, to_park, to_revive = plan(rows, cats)
    stamp = now_et().strftime("%a %m-%d %H:%M ET")
    print(f"{stamp}: {len(rows)} channels · {len(parked)} parked · park {len(to_park)} · revive {len(to_revive)}")
    for r in to_park:
        print(f"  PARK   #{r['name']:28} {r['category']:24} last {r['last_message_et'] or 'never'}")
    for r in to_revive:
        print(f"  REVIVE #{r['name']:28} last {r['last_message_et']}")
    if not a.apply:
        print("dry run — nothing moved (use --apply)")
        return

    moved, revived = [], []
    for r in to_revive:
        m = rmap.get(r["id"])
        if not m or (m["parent_id"] and m["parent_id"] not in cats):
            print(f"  skip revive #{r['name']}: original category gone — left parked for Mike")
            continue
        call("PATCH", f"/channels/{r['id']}", {"parent_id": m["parent_id"], "lock_permissions": False})
        m["restored_at"] = now_et().isoformat()
        revived.append(r["name"])
    counts = {}
    for c in rows:
        if c["parent_id"] in cats and cats[c["parent_id"]]["name"] in STALE_CATS:
            counts[c["parent_id"]] = counts.get(c["parent_id"], 0) + 1
    for r in to_park:
        idx = 0
        while True:
            cid = ensure_stale_cat(cats, chans, idx)
            if counts.get(cid, 0) < CAT_MAX:
                break
            idx += 1
        rmap[r["id"]] = {"name": r["name"], "parent_id": r["parent_id"], "category": r["category"],
                         "position": r["position"], "last_message_et": r["last_message_et"],
                         "moved_at": now_et().isoformat(), "restored_at": None}
        MAP_PATH.write_text(json.dumps(rmap, indent=1, ensure_ascii=False))  # map first, then move
        call("PATCH", f"/channels/{r['id']}", {"parent_id": cid, "lock_permissions": False})
        counts[cid] = counts.get(cid, 0) + 1
        moved.append(r["name"])
    MAP_PATH.write_text(json.dumps(rmap, indent=1, ensure_ascii=False))
    # keep the STALE categories at the very bottom
    allcats = sorted([c for c in cats.values() if c["type"] == 4], key=lambda c: c["position"])
    order = [c for c in allcats if c["name"] not in STALE_CATS] + [c for c in allcats if c["name"] in STALE_CATS]
    call("PATCH", f"/guilds/{GUILD}/channels", [{"id": c["id"], "position": i} for i, c in enumerate(order)])
    msg = (f"🧹 **Discord janitor** · {stamp}\n{len(rows)} channels checked. "
           f"Parked {len(moved)} with no post in {CFG['stale_days']}+ days → 🗄️ STALE — REVIEW"
           + (f": {', '.join('#' + n for n in moved[:40])}" if moved else "")
           + (f"\nRevived {len(revived)} (posting again): {', '.join('#' + n for n in revived)}" if revived else "")
           + "\nNothing deleted. Restore map: ~/.openclaw/data/discord/stale_restore_map.json")
    post_summary(msg)
    print(f"applied: parked {len(moved)}, revived {len(revived)}")


if __name__ == "__main__":
    try:
        main()
    except Exception as e:  # fail loud: non-zero exit so hb-run records the failure
        print(f"discord_janitor FAILED: {e}", file=sys.stderr)
        sys.exit(1)
