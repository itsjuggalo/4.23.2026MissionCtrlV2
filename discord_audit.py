#!/usr/bin/env python3
"""
discord_audit.py — read-only live snapshot of the guild for the reorg map.

Uses a BOT token (Bot <token>) that is in the guild. GET-only: never mutates.
Outputs:
  - JSON snapshot → ~/.openclaw/workspace/state/discord_guild_snapshot.json
  - human summary to stdout (category tree + per-channel last-activity age)
"""
import sys, json, time, datetime
from pathlib import Path

sys.path.insert(0, str(Path.home() / ".openclaw"))
from vault import get_secret  # noqa: E402
import requests  # noqa: E402

API = "https://discord.com/api/v10"
DISCORD_EPOCH = 1420070400000
GUILD = (get_secret("discord_guild_id") or "").strip()
UA = "MissionCtrlAudit/1.0 (read-only)"

# try bot tokens in order of known capability
for key in ("discord_ops_bot_token", "discord_status_bot_token", "discord_boba_token"):
    BOT = (get_secret(key) or "").strip()
    if BOT:
        TOKEN_KEY = key
        break
else:
    sys.exit("no usable bot token found")


def _get(path):
    for _ in range(5):
        r = requests.get(API + path, headers={"Authorization": f"Bot {BOT}", "User-Agent": UA}, timeout=30)
        if r.status_code == 429:
            time.sleep(float(r.headers.get("Retry-After", 2)) + 0.5); continue
        if r.status_code in (401, 403):
            return {"_error": r.status_code, "_path": path}
        r.raise_for_status()
        time.sleep(0.3)
        return r.json()
    return {"_error": "ratelimit"}


def snowflake_age(sid):
    if not sid:
        return None
    ms = (int(sid) >> 22) + DISCORD_EPOCH
    return datetime.datetime.fromtimestamp(ms / 1000)


def main():
    if not GUILD:
        sys.exit("no discord_guild_id")
    chans = _get(f"/guilds/{GUILD}/channels")
    if isinstance(chans, dict) and chans.get("_error"):
        sys.exit(f"channels fetch failed: {chans}  (token {TOKEN_KEY} lacks access)")

    cats = {c["id"]: c for c in chans if c.get("type") == 4}
    by_parent = {}
    for c in chans:
        if c.get("type") == 4:
            continue
        by_parent.setdefault(c.get("parent_id"), []).append(c)

    now = datetime.datetime.now()
    snapshot = {"guild": GUILD, "token_key": TOKEN_KEY, "generated": now.isoformat(timespec="seconds"),
                "categories": [], "uncategorized": []}

    def chan_rec(c):
        last = snowflake_age(c.get("last_message_id"))
        age_days = round((now - last).total_seconds() / 86400, 1) if last else None
        return {"id": c["id"], "name": c.get("name"), "type": c.get("type"),
                "position": c.get("position"), "last_activity": last.isoformat(timespec="minutes") if last else None,
                "age_days": age_days, "topic": c.get("topic")}

    ordered_cats = sorted(cats.values(), key=lambda x: x.get("position", 0))
    print(f"# Guild {GUILD} — live snapshot ({now:%Y-%m-%d %H:%M}) via {TOKEN_KEY}\n")
    total = 0
    for cat in ordered_cats:
        kids = sorted(by_parent.get(cat["id"], []), key=lambda x: x.get("position", 0))
        rec = {"name": cat["name"], "id": cat["id"], "channels": [chan_rec(c) for c in kids]}
        snapshot["categories"].append(rec)
        print(f"\n▼ {cat['name']}  ({len(kids)})")
        for c in kids:
            cr = chan_rec(c); total += 1
            age = f"{cr['age_days']}d ago" if cr["age_days"] is not None else "never/empty"
            flag = "  💤 DORMANT" if (cr["age_days"] is None or cr["age_days"] > 14) else ""
            print(f"    #{cr['name']:<28} last={age:<14}{flag}")
    # uncategorized
    for c in sorted(by_parent.get(None, []), key=lambda x: x.get("position", 0)):
        cr = chan_rec(c); total += 1
        snapshot["uncategorized"].append(cr)
        print(f"  (top) #{cr['name']}")

    out = Path.home() / ".openclaw" / "workspace" / "state" / "discord_guild_snapshot.json"
    out.parent.mkdir(parents=True, exist_ok=True)
    out.write_text(json.dumps(snapshot, indent=2))
    print(f"\n{total} channels across {len(ordered_cats)} categories → snapshot: {out}")


if __name__ == "__main__":
    main()
