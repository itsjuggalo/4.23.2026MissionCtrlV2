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
    for d in KEY_DIRS:
        for fname in ("discord_synthcontrol_token", "discord_bot_token",
                      "discord_ops_bot_token", "discord_status_bot_token"):
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


# Archive channels (id -> name) from all_channels.txt
ARCHIVES = {
    "1486136515045101717": "archive-eric",
    "1486136525144981565": "archive-analyst",
    "1486136531440636146": "archive-risk",
    "1486136544602624163": "archive-executions",
    "1486136549815877683": "archive-portfolio",
    "1486136556317184150": "archive-broadcaster",
    "1486136562327748630": "archive-sniper",
    "1486136569218863186": "archive-counter-intel",
    "1486136576583925840": "archive-auditor",
    "1486136582854410331": "archive-macro",
    "1486136588407930980": "archive-psych",
}

# Sniper channel renames (id -> new name).  category renamed separately.
SNIPER_RENAMES = {
    "1486045642915844126": "sniper-entries",    # was sniper-launches
    "1486045643926671390": "sniper-dips",       # was sniper-analysis
    "1486045647345025264": "sniper-exits",      # was sniper-executions
    "1486045648070512851": "sniper-watchlist",  # unchanged
    "1486045648900853910": "sniper-skips",      # was sniper-blacklist
}
SNIPER_CATEGORY_HINT = "CRYPTO SNIPER"  # category to rename -> "SNIPER"


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


def audit_archives():
    print("\n=== ARCHIVE AUDIT (read-only) ===")
    print(f"{'channel':24} {'msgs':>5}  {'last (UTC)':20} verdict")
    print("-" * 70)
    empties = []
    for cid, name in ARCHIVES.items():
        st, msgs = api("GET", f"/channels/{cid}/messages?limit=5")
        time.sleep(0.4)
        if st != 200:
            print(f"{name:24} {'?':>5}  {'-':20} ERROR HTTP {st} {str(msgs)[:50]}")
            continue
        n = len(msgs)
        last = msgs[0]["timestamp"][:19] if n else "-"
        verdict = "EMPTY -> delete" if n == 0 else "has messages -> KEEP"
        if n == 0:
            empties.append((cid, name))
        print(f"{name:24} {n:>5}  {last:20} {verdict}")
    print(f"\n{len(empties)} empty / {len(ARCHIVES)} total. "
          f"Empty: {', '.join(n for _, n in empties) or 'none'}")
    return empties


def delete_empty_archives():
    empties = audit_archives()
    if not empties:
        print("\nNothing empty to delete.")
        return
    print(f"\nDeleting {len(empties)} empty archive channels...")
    for cid, name in empties:
        st, _ = api("DELETE", f"/channels/{cid}")
        print(f"  {'OK ' if st in (200, 204) else 'FAIL'} delete {name} (HTTP {st})")
        time.sleep(0.5)
    # If ALL archives gone, offer to remove the category too
    st, chans = api("GET", f"/guilds/{GUILD}/channels")
    if st == 200:
        cat = next((c for c in chans if c["type"] == 4 and "ARCHIVE" in c["name"].upper()), None)
        children = [c for c in chans if c.get("parent_id") == (cat or {}).get("id")]
        if cat and not children:
            st, _ = api("DELETE", f"/channels/{cat['id']}")
            print(f"  {'OK ' if st in (200,204) else 'FAIL'} delete empty category '{cat['name']}' (HTTP {st})")


def rename_sniper():
    print("\n=== RENAME SNIPER CHANNELS ===")
    for cid, newname in SNIPER_RENAMES.items():
        st, cur = api("GET", f"/channels/{cid}")
        old = cur.get("name", "?") if st == 200 else "?"
        if old == newname:
            print(f"  skip {newname} (already named)")
            continue
        st, _ = api("PATCH", f"/channels/{cid}", {"name": newname})
        print(f"  {'OK ' if st == 200 else 'FAIL'} {old} -> {newname} (HTTP {st})")
        time.sleep(0.5)
    # rename the category
    st, chans = api("GET", f"/guilds/{GUILD}/channels")
    if st == 200:
        cat = next((c for c in chans if c["type"] == 4
                    and SNIPER_CATEGORY_HINT in c["name"].upper()), None)
        if cat:
            st, _ = api("PATCH", f"/channels/{cat['id']}", {"name": "🎯 SNIPER"})
            print(f"  {'OK ' if st == 200 else 'FAIL'} category '{cat['name']}' -> '🎯 SNIPER' (HTTP {st})")


# Categories to leave alone in the bloat audit (Mike: don't touch flow/options)
LEAVE_HINTS = ("FLOWGREEKS", "ULTIMATE FLOW", "STOCK SIGNALS", "TRADE SIGNALS",
               "TRADINGVIEW", "DAILY BRIEFS")


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
    ap.add_argument("--delete-empty-archives", action="store_true")
    ap.add_argument("--rename-sniper", action="store_true")
    ap.add_argument("--audit-activity", action="store_true",
                    help="read-only bloat/dead-channel report across the whole guild")
    args = ap.parse_args()

    if not check_perms() and (args.delete_empty_archives or args.rename_sniper):
        sys.exit("Bot lacks Manage Channels — grant it in Discord (Server Settings -> "
                 "Roles -> the bot's role -> Manage Channels), then re-run.")

    if args.delete_empty_archives:
        delete_empty_archives()
    elif args.rename_sniper:
        rename_sniper()
    elif args.audit_activity:
        audit_activity()
    else:
        audit_archives()
        print("\n(audit only. Flags: --audit-activity (whole-guild bloat report), "
              "--delete-empty-archives, --rename-sniper.)")


if __name__ == "__main__":
    main()
