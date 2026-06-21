#!/usr/bin/env python3
"""
discord_reorg_run.py — execute the consolidation SAFELY. Dry-run by default.

Actor = discord_ops_bot_token (now Administrator). Uses:
  - snapshot  ~/.openclaw/workspace/state/discord_guild_snapshot.json  (name→id, parent, age)
  - secret-map /tmp/discord_secret_map.json  (webhook-secret-file → channel_id)
  - PLAN       imported from discord_reorg.py

Order:  A) rename survivors  B) merge feeds (re-point webhook secrets to a survivor
webhook, then archive the drained source)  C) archive dead channels.
Adaptive safety: an absorb-source with NO webhook secret that is still ACTIVE
(<14d) is NOT archived (would hide live bot-fed content) — it's left + flagged.
Everything recorded to a rollback file.

  discord_reorg_run.py            # dry-run
  discord_reorg_run.py --execute  # do it
"""
import sys, json, time
from pathlib import Path

sys.path.insert(0, str(Path.home() / ".openclaw"))
sys.path.insert(0, str(Path.home() / "scripts"))
from vault import get_secret  # noqa: E402
from discord_reorg import PLAN  # noqa: E402
import requests  # noqa: E402

API = "https://discord.com/api/v10"
G = get_secret("discord_guild_id").strip()
BOT = get_secret("discord_ops_bot_token").strip()
H = {"Authorization": f"Bot {BOT}", "User-Agent": "MissionCtrlReorg/1.0", "Content-Type": "application/json"}
SEC = Path.home() / ".openclaw" / "secrets"
SNAP = json.loads((Path.home() / ".openclaw" / "workspace" / "state" / "discord_guild_snapshot.json").read_text())
SMAP = json.loads(Path("/tmp/discord_secret_map.json").read_text())
ROLLBACK = SEC / ".discord-reorg-rollback.json"
DRY = "--execute" not in sys.argv

# build lookups from snapshot
name2id, id2parent, id2age, archive_cat = {}, {}, {}, None
for cat in SNAP["categories"]:
    if "ARCHIVE" in cat["name"].upper():
        archive_cat = cat["id"]
    for c in cat["channels"]:
        name2id[c["name"]] = c["id"]; id2parent[c["id"]] = cat["id"]; id2age[c["id"]] = c["age_days"]
for c in SNAP.get("uncategorized", []):
    name2id[c["name"]] = c["id"]; id2parent[c["id"]] = None; id2age[c["id"]] = c["age_days"]

# invert secret-map: channel_id -> [secret filenames]
secrets_by_chan = {}
for fn, info in SMAP.items():
    cid = info.get("channel_id")
    if cid:
        secrets_by_chan.setdefault(cid, []).append(fn)

rollback = {"renames": {}, "moves": {}, "secrets": {}}
flagged = []
survivor_wh = {}   # survivor_id -> webhook url


def _req(method, path, **kw):
    for _ in range(6):
        r = requests.request(method, API + path, headers=H, timeout=30, **kw)
        if r.status_code == 429:
            time.sleep(float(r.headers.get("Retry-After", 2)) + 0.5); continue
        return r
    raise RuntimeError("rate-limited")


def rename(cid, new):
    if DRY:
        return
    rollback["renames"][cid] = None  # filled by caller with old name
    _req("PATCH", f"/channels/{cid}", json={"name": new}); time.sleep(0.4)


def get_survivor_webhook(sid, label):
    if sid in survivor_wh:
        return survivor_wh[sid]
    if DRY:
        survivor_wh[sid] = f"<survivor-webhook:{sid}>"; return survivor_wh[sid]
    # reuse an existing mc webhook if present
    whs = _req("GET", f"/channels/{sid}/webhooks").json()
    wh = next((w for w in whs if isinstance(w, dict) and (w.get("name") or "").startswith("mc-")), None)
    if not wh:
        wh = _req("POST", f"/channels/{sid}/webhooks", json={"name": f"mc-{label}"}).json()
    url = f"https://discord.com/api/webhooks/{wh['id']}/{wh['token']}"
    survivor_wh[sid] = url; time.sleep(0.4); return url


def repoint(source_id, wh_url):
    files = secrets_by_chan.get(source_id, [])
    for fn in files:
        p = SEC / fn
        try:
            old = p.read_text().strip()
        except Exception:
            continue
        rollback["secrets"][fn] = old
        if not DRY:
            p.write_text(wh_url + "\n")
    return files


def archive(cid, name):
    rollback["moves"][cid] = id2parent.get(cid)
    if not DRY:
        _req("PATCH", f"/channels/{cid}", json={"parent_id": archive_cat, "lock_permissions": True})
        time.sleep(0.4)


def main():
    print(f"=== reorg {'DRY-RUN' if DRY else 'EXECUTE'} === archive_cat={archive_cat}\n")
    # WAVE A + B — survivors + merges
    for new, spec in PLAN["renames_and_merges"].items():
        old = spec["from"]; sid = name2id.get(old)
        if not sid:
            continue
        if old != new:
            print(f"RENAME  #{old} → #{new}")
            if not DRY:
                _req("PATCH", f"/channels/{sid}", json={"name": new}); rollback["renames"][sid] = old; time.sleep(0.4)
        for ab in spec["absorbs"]:
            abid = name2id.get(ab)
            if not abid:
                continue
            has_secret = abid in secrets_by_chan
            active = (id2age.get(abid) is not None and id2age[abid] < 14)
            if has_secret:
                url = get_survivor_webhook(sid, new)
                files = repoint(abid, url)
                print(f"   MERGE  #{ab} → #{new}  (re-point {len(files)} webhook-secret(s)) + archive")
                archive(abid, ab)
            elif not active:
                print(f"   ARCHIVE #{ab} (dormant, no webhook)")
                archive(abid, ab)
            else:
                print(f"   ⚠ FLAG  #{ab} active + bot-fed (no webhook) — left in place, recategorize manually")
                flagged.append(ab)
    # WAVE C — dead channels
    print()
    for ch in PLAN["archive_only"]:
        cid = name2id.get(ch)
        if not cid:
            continue
        print(f"ARCHIVE-DEAD #{ch}")
        archive(cid, ch)

    if not DRY:
        ROLLBACK.write_text(json.dumps(rollback, indent=2))
        print(f"\nrollback → {ROLLBACK}")
    if flagged:
        print(f"\n⚠ {len(flagged)} active bot-fed channels left in place (need bot-config change, not webhook): "
              + ", ".join(flagged))
    print(f"\n{'(dry-run — nothing changed)' if DRY else 'DONE'}")


if __name__ == "__main__":
    main()
