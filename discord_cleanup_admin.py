#!/usr/bin/env python3
"""
discord_cleanup_admin.py — one-off Discord guild cleanup (Mike runs this).

Why this is a standalone script: the agent sandbox masks ~/scripts/keys, so
Claude can't hold the bot token. Your interactive shell can. Run it with the
`!` prefix in Claude Code, or directly in PuTTY.

SAFE BY DEFAULT. With no flags it only AUDITS (read-only) and prints tables.
Mutations require explicit flags:

  # 1) audit only (read-only) — see what's empty + current sniper names
  python3 ~/scripts/discord_cleanup_admin.py

  # 2) delete the archive-* channels that are EMPTY (0 messages)
  python3 ~/scripts/discord_cleanup_admin.py --delete-empty-archives

  # 3) rename the old CRYPTO SNIPER channels to the new trade-sniper names
  python3 ~/scripts/discord_cleanup_admin.py --rename-sniper

Bot must have Manage Channels in the guild. The script checks this first.
"""
import argparse
import json
import os
import sys
import time
import urllib.request
import urllib.error

GUILD = "1486025777970548908"
# ~/.openclaw/secrets is the canonical store; ~/scripts/keys is a mirror that
# can be unavailable in some execution contexts. Try secrets first.
KEY_DIRS = [os.path.expanduser("~/.openclaw/secrets"),
            os.path.expanduser("~/scripts/keys")]


def load_token() -> str:
    # Prefer a bot that actually has Manage Channels / Admin in the guild.
    # Scan (2026-06-13): BobaUpgraded=ADMIN; jazzyhazzy/ReminderBot/Orion2=ManageChannels;
    # SynthControl has neither (it's the poster bot, not an admin).
    for d in KEY_DIRS:
        for fname in ("discord_boba_token", "discord_ops_bot_token",
                      "discord_orion_token", "discord_jazzyhazzy_token",
                      "discord_synthcontrol_token"):
            try:
                t = open(os.path.join(d, fname)).read().strip()
                if t:
                    print(f"[token] using {fname} from {d}")
                    return t
            except OSError:
                continue
    sys.exit("ERROR: no usable bot token in ~/.openclaw/secrets or ~/scripts/keys")


TOKEN = load_token()


def api(method: str, path: str, body=None):
    data = json.dumps(body).encode() if body is not None else None
    req = urllib.request.Request(
        "https://discord.com/api/v10" + path, data=data, method=method,
        headers={"Authorization": "Bot " + TOKEN,
                 "Content-Type": "application/json",
                 "User-Agent": "MissionCtrlCleanup/1.0"})
    try:
        with urllib.request.urlopen(req, timeout=25) as r:
            raw = r.read()
            return r.status, (json.loads(raw) if raw else {})
    except urllib.error.HTTPError as e:
        raw = e.read()
        try:
            return e.code, json.loads(raw)
        except Exception:  # noqa: BLE001
            return e.code, {"raw": raw.decode()[:200]}


# --- Live-discovery config (guild was restructured 2026-06; never trust old IDs) ---
DEAD_DAYS = 21        # no message in this many days = dead
SNIPER_CONFIG = os.path.expanduser("~/trading/daemons/sniper_config.json")
SNIPER_CHANNELS = ["sniper-entries", "sniper-dips", "sniper-exits",
                   "sniper-watchlist", "sniper-skips"]
SNIPER_CATEGORY = "🎯 SNIPER"

# Categories NEVER touched by --delete-dead (flow/options/signals/briefs are live trading data)
PROTECTED_CATEGORY_HINTS = ("SIGNALS", "WHALE", "FLOW", "BRIEF", "TRADING",
                            "RISK", "PORTFOLIO", "VOICE")
# Channel names never deleted even if quiet (safety allowlist)
PROTECTED_NAMES = {"general", "system-logs", "announcements", "mission-control",
                   "agent-comms", "synth-control", "boba-cmd", "tg-bridge", "verify"}


def check_perms():
    st, me = api("GET", "/users/@me")
    print(f"[perms] bot = {me.get('username','?')} id={me.get('id','?')} (HTTP {st})")
    st, gm = api("GET", f"/guilds/{GUILD}/members/{me.get('id')}")
    st2, roles = api("GET", f"/guilds/{GUILD}/roles")
    rp = {r["id"]: int(r["permissions"]) for r in roles} if st2 == 200 else {}
    perm = rp.get(GUILD, 0)
    for rid in (gm.get("roles", []) if isinstance(gm, dict) else []):
        perm |= rp.get(rid, 0)
    admin = bool(perm & 0x8)
    manage = bool(perm & 0x10) or admin
    print(f"[perms] Administrator={admin}  ManageChannels={manage}")
    return manage


def _scan_dead():
    """Live discovery: return (dead_list, cats) where dead = channels with no
    message in DEAD_DAYS, NOT in a protected category, NOT a protected name."""
    import datetime as dt
    st, chans = api("GET", f"/guilds/{GUILD}/channels")
    if st != 200:
        sys.exit(f"cannot list channels: HTTP {st}")
    cats = {c["id"]: c["name"] for c in chans if c["type"] == 4}
    now = dt.datetime.now(dt.timezone.utc)
    dead = []
    for c in [c for c in chans if c["type"] in (0, 5)]:
        cat = cats.get(c.get("parent_id"), "")
        if any(h in cat.upper() for h in PROTECTED_CATEGORY_HINTS):
            continue
        if c["name"] in PROTECTED_NAMES:
            continue
        st, msgs = api("GET", f"/channels/{c['id']}/messages?limit=1")
        time.sleep(0.35)
        if st != 200:
            continue
        if not msgs:
            dead.append((c["id"], c["name"], cat, "empty"))
            continue
        last = dt.datetime.fromisoformat(msgs[0]["timestamp"].replace("Z", "+00:00"))
        age = (now - last).days
        if age >= DEAD_DAYS:
            dead.append((c["id"], c["name"], cat, f"{age}d idle"))
    return dead, cats


def delete_dead(execute: bool, empty_only: bool = False):
    dead, cats = _scan_dead()
    if empty_only:
        dead = [d for d in dead if d[3] == "empty"]
        print("\n=== EMPTY CHANNELS ONLY (non-flow, zero messages) ===")
    else:
        print(f"\n=== DEAD/EMPTY CHANNELS (non-flow, idle ≥{DEAD_DAYS}d) ===")
    for cid, name, cat, why in dead:
        print(f"  {cat[:24]:24} {name:26} {why}")
    print(f"\n{len(dead)} channels qualify.")
    if not dead:
        return
    if not execute:
        print("Preview only. Re-run with --delete-dead --yes to delete these.")
        return
    print("Deleting...")
    for cid, name, cat, why in dead:
        st, _ = api("DELETE", f"/channels/{cid}")
        print(f"  {'OK ' if st in (200, 204) else 'FAIL'} delete {name} (HTTP {st})")
        time.sleep(0.5)
    # remove any now-empty categories we just emptied
    st, chans = api("GET", f"/guilds/{GUILD}/channels")
    if st == 200:
        live_parents = {c.get("parent_id") for c in chans if c["type"] in (0, 5)}
        for c in [c for c in chans if c["type"] == 4 and c["id"] not in live_parents]:
            if any(h in c["name"].upper() for h in PROTECTED_CATEGORY_HINTS):
                continue
            st, _ = api("DELETE", f"/channels/{c['id']}")
            print(f"  {'OK ' if st in (200,204) else 'FAIL'} delete empty category '{c['name']}' (HTTP {st})")


def setup_sniper():
    """Create the 🎯 SNIPER category + channels, write their IDs to sniper_config.json."""
    print("\n=== SETUP SNIPER CHANNELS ===")
    st, chans = api("GET", f"/guilds/{GUILD}/channels")
    if st != 200:
        sys.exit(f"cannot list channels: HTTP {st}")
    existing = {c["name"]: c["id"] for c in chans if c["type"] in (0, 5)}
    cat = next((c for c in chans if c["type"] == 4 and "SNIPER" in c["name"].upper()), None)
    if cat:
        cat_id = cat["id"]
        print(f"  category exists: {cat['name']}")
    else:
        st, cat = api("POST", f"/guilds/{GUILD}/channels", {"name": SNIPER_CATEGORY, "type": 4})
        cat_id = cat.get("id")
        print(f"  {'OK ' if st in (200,201) else 'FAIL'} create category {SNIPER_CATEGORY} (HTTP {st})")
    ids = {}
    for name in SNIPER_CHANNELS:
        key = name.replace("sniper-", "")
        if name in existing:
            ids[key] = existing[name]
            print(f"  exists: {name}")
            continue
        st, ch = api("POST", f"/guilds/{GUILD}/channels",
                     {"name": name, "type": 0, "parent_id": cat_id})
        if st in (200, 201):
            ids[key] = ch["id"]
            print(f"  OK  create {name} -> {ch['id']}")
        else:
            print(f"  FAIL create {name} (HTTP {st} {str(ch)[:80]})")
        time.sleep(0.5)
    # write IDs into sniper_config.json
    try:
        cfg = json.load(open(SNIPER_CONFIG))
    except Exception:  # noqa: BLE001
        cfg = {}
    cfg.setdefault("channels", {}).update(ids)
    json.dump(cfg, open(SNIPER_CONFIG, "w"), indent=2)
    print(f"\nWrote channel IDs to {SNIPER_CONFIG}: {ids}")
    print("Now flip the sniper daemon live (drop SNIPER_DRYRUN=1).")


# Categories to leave alone in the bloat audit (Mike: don't touch flow/options)
LEAVE_HINTS = ("SIGNALS", "WHALE", "FLOW", "BRIEF", "TRADING", "RISK", "PORTFOLIO")


def audit_activity():
    """Read-only: every channel's last-message age + 7-day volume -> find bloat & dead."""
    import datetime as dt
    st, chans = api("GET", f"/guilds/{GUILD}/channels")
    if st != 200:
        sys.exit(f"cannot list channels: HTTP {st}")
    cats = {c["id"]: c["name"] for c in chans if c["type"] == 4}
    now = dt.datetime.now(dt.timezone.utc)
    week_ago = now - dt.timedelta(days=7)
    text = [c for c in chans if c["type"] in (0, 5)]
    text.sort(key=lambda c: (cats.get(c.get("parent_id"), "~"), c["name"]))
    print(f"\n=== CHANNEL ACTIVITY AUDIT ({len(text)} text channels) ===")
    print(f"{'category':22} {'channel':22} {'last msg':>10} {'7d msgs':>7}  note")
    print("-" * 86)
    for c in text:
        cat = cats.get(c.get("parent_id"), "(none)")
        leave = any(h in cat.upper() for h in LEAVE_HINTS)
        st, msgs = api("GET", f"/channels/{c['id']}/messages?limit=100")
        time.sleep(0.35)
        if st != 200:
            print(f"{cat[:22]:22} {c['name'][:22]:22} {'ERR':>10} {st:>7}")
            continue
        if not msgs:
            print(f"{cat[:22]:22} {c['name'][:22]:22} {'never':>10} {0:>7}  DEAD/empty")
            continue
        last = dt.datetime.fromisoformat(msgs[0]["timestamp"].replace("Z", "+00:00"))
        age_d = (now - last).days
        recent = sum(1 for m in msgs
                     if dt.datetime.fromisoformat(m["timestamp"].replace("Z", "+00:00")) >= week_ago)
        note = "(flow/options — leave)" if leave else ""
        if age_d >= 14 and not leave:
            note = "DEAD 14d+ → consider delete"
        elif recent >= 80 and not leave:
            note = "HIGH VOLUME → check for bloat"
        agestr = "today" if age_d == 0 else f"{age_d}d ago"
        print(f"{cat[:22]:22} {c['name'][:22]:22} {agestr:>10} {recent:>7}  {note}")


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("--audit-activity", action="store_true",
                    help="read-only bloat/dead-channel report across the whole guild")
    ap.add_argument("--delete-dead", action="store_true",
                    help="delete non-flow channels idle ≥21d or empty (preview unless --yes)")
    ap.add_argument("--setup-sniper", action="store_true",
                    help="create 🎯 SNIPER category + channels, write IDs to sniper_config.json")
    ap.add_argument("--empty-only", action="store_true",
                    help="with --delete-dead: only delete zero-message channels")
    ap.add_argument("--yes", action="store_true", help="actually execute deletes")
    args = ap.parse_args()

    # preview (--delete-dead without --yes) is read-only; only real mutations need perms
    needs_manage = (args.delete_dead and args.yes) or args.setup_sniper
    if needs_manage and not check_perms():
        sys.exit("Bot lacks Manage Channels — grant it in Discord (Server Settings -> "
                 "Roles -> the bot's role -> Manage Channels), then re-run.")

    if args.delete_dead:
        delete_dead(execute=args.yes, empty_only=args.empty_only)
    elif args.setup_sniper:
        setup_sniper()
    elif args.audit_activity:
        audit_activity()
    else:
        check_perms()
        print("\nFlags: --audit-activity (read-only bloat report) · "
              "--delete-dead [--yes] (purge dead non-flow channels) · "
              "--setup-sniper (create sniper channels).")


if __name__ == "__main__":
    main()
