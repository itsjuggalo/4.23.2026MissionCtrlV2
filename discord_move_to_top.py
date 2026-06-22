#!/usr/bin/env python3
"""Move general, bluestacks, 5-27-2026 to the TOP (into 📌 START HERE, positions 0-2). Reversible."""
import sys, json, time
from pathlib import Path
import requests

TOKEN = (Path.home() / ".openclaw/secrets/discord_ops_bot_token").read_text().strip()
GUILD = "1486025777970548908"
TOP_CAT = "1518339855896285324"   # 📌 START HERE (display position 0)
API = "https://discord.com/api/v10"
HDR = {"Authorization": f"Bot {TOKEN}",
       "User-Agent": "DiscordBot (https://missionctrl.local, 1.0)",
       "Content-Type": "application/json"}
ROLLBACK = Path.home() / ".openclaw/secrets/.discord-move-to-top-rollback.json"

# channel id : desired top position
TARGETS = [
    ("general",   "1486025778922782722", 0),
    ("bluestacks","1501957754431078702", 1),
    ("5-27-2026", "1509383214635028480", 2),
]


def req(method, path, **kw):
    for _ in range(5):
        r = requests.request(method, API + path, headers=HDR, timeout=30, **kw)
        if r.status_code == 429:
            time.sleep(float(r.headers.get("Retry-After", 2)) + 0.5); continue
        r.raise_for_status()
        time.sleep(0.4)
        return r.json() if r.text else {}
    raise SystemExit("rate-limited")


def main():
    go = "--go" in sys.argv
    if "--rollback" in sys.argv:
        data = json.loads(ROLLBACK.read_text())
        for nm, info in data.items():
            req("PATCH", f"/channels/{info['id']}",
                json={"parent_id": info["old_parent"], "position": info["old_position"]})
            print(f"restored #{nm} → {info['old_parent']} pos {info['old_position']}")
        return
    chans = {c["id"]: c for c in req("GET", f"/guilds/{GUILD}/channels")}
    rb = {}
    print(f"{'EXECUTE' if go else 'DRY RUN'} — move 3 channels to TOP (📌 START HERE pos 0-2)\n")
    for nm, cid, pos in TARGETS:
        cur = chans.get(cid)
        if not cur:
            print(f"  ?? #{nm} not found"); continue
        rb[nm] = {"id": cid, "old_parent": cur.get("parent_id"), "old_position": cur.get("position", 0)}
        print(f"  #{nm:<12} {cur.get('parent_id')} pos{cur.get('position')}  →  START HERE pos{pos}")
        if go:
            req("PATCH", f"/channels/{cid}", json={"parent_id": TOP_CAT})
    if go:
        # set positions at the top of the category in one bulk call
        req("PATCH", f"/guilds/{GUILD}/channels",
            json=[{"id": cid, "position": pos, "parent_id": TOP_CAT} for nm, cid, pos in TARGETS])
        ROLLBACK.write_text(json.dumps(rb, indent=2))
        print(f"\n✓ moved. rollback → {ROLLBACK}")
        print("undo: python3 discord_move_to_top.py --rollback")
    else:
        print("\n(dry run — add --go)")


if __name__ == "__main__":
    main()
