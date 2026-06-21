#!/usr/bin/env python3
"""
discord_user.py — Mike's PERSONAL Discord account access (user token, REST).

The Discord equivalent of the Telegram MTProto user session (tg_botfather.py):
acts as Mike's account, not a bot — reads all DMs, every server, every channel.

Auth = the raw USER token (NOT "Bot <token>"). The token is Mike's to supply
(copy from a logged-in discord.com → DevTools → Network → any /api request →
Request Header `authorization`). It cannot be fetched programmatically.

Stored in the vault (~/.openclaw/vault.db) under:
  discord_user.token     — the raw user token (password-grade)
  discord_user.id        — cached from GET /users/@me
  discord_user.username  — cached

CLI:
  discord_user.py set-token [<TOKEN>]    # no arg → reads token from stdin (preferred)
  discord_user.py whoami                 # live GET /users/@me, prints user
  discord_user.py guilds                 # list servers
  discord_user.py dms                    # list open DM channels + recipients
  discord_user.py read <channel_id> [N]  # last N messages in a channel (default 50)
  discord_user.py channels <guild_id>    # list channels in a server
  discord_user.py search <guild_id> <q>  # message search in a server (user-only endpoint)

NOTE: user-token automation is against Discord ToS. Read-only, paced, laptop-IP
only. A 401 means the token died (logout / password change) → re-run set-token.
"""
import sys, os, json, time, random
from pathlib import Path

sys.path.insert(0, str(Path.home() / ".openclaw"))
from vault import get_secret, set_secret  # noqa: E402

import requests  # noqa: E402

API = "https://discord.com/api/v10"
UA = ("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 "
      "(KHTML, like Gecko) Chrome/126.0.0.0 Safari/537.36")


def _token():
    tok = get_secret("discord_user.token")
    if not tok:
        sys.exit("no user token stored. Run: discord_user.py set-token  (paste it)")
    return tok.strip()


def _headers(tok=None):
    return {"Authorization": (tok or _token()), "User-Agent": UA,
            "Content-Type": "application/json"}


def _req(method, path, tok=None, **kw):
    """One REST call with 429 backoff + jittered pacing (ban-risk hygiene)."""
    url = path if path.startswith("http") else API + path
    for attempt in range(5):
        r = requests.request(method, url, headers=_headers(tok), timeout=30, **kw)
        if r.status_code == 429:
            wait = float(r.headers.get("Retry-After", r.json().get("retry_after", 2)))
            time.sleep(wait + 0.5)
            continue
        if r.status_code == 401:
            sys.exit("401 Unauthorized — token is dead (logout/password change). "
                     "Re-run: discord_user.py set-token")
        r.raise_for_status()
        time.sleep(0.4 + random.random() * 0.4)  # gentle pacing
        return r.json() if r.text else {}
    sys.exit("rate-limited repeatedly; try again later")


# ── commands ──────────────────────────────────────────────────────────────────
def cmd_set_token(token=None):
    if not token:
        sys.stderr.write("Paste your Discord USER token, then Enter:\n> ")
        sys.stderr.flush()
        token = sys.stdin.readline().strip()
    if not token:
        sys.exit("no token given.")
    # verify it before storing
    me = _req("GET", "/users/@me", tok=token)
    uid, uname = me["id"], me.get("username", "?")
    set_secret("discord_user.token", token, category="discord_user",
               note="Mike personal Discord user token — password-grade")
    set_secret("discord_user.id", uid, category="discord_user", note="from GET /users/@me")
    set_secret("discord_user.username", uname, category="discord_user")
    print(f"✓ logged in as {uname} (id {uid}). Token saved to vault. Tell Claude 'done'.")


def cmd_whoami():
    me = _req("GET", "/users/@me")
    g = _req("GET", "/users/@me/guilds")
    print(f"{me.get('username')} (id {me['id']})  ·  global_name={me.get('global_name')}  "
          f"·  {len(g)} servers")


def cmd_guilds():
    g = _req("GET", "/users/@me/guilds")
    for s in sorted(g, key=lambda x: x.get("name", "").lower()):
        owner = " [owner]" if s.get("owner") else ""
        print(f"{s['id']}  {s.get('name')}{owner}")
    print(f"\n{len(g)} servers")


def cmd_dms():
    ch = _req("GET", "/users/@me/channels")
    for c in ch:
        rec = ", ".join(r.get("global_name") or r.get("username", "?")
                        for r in c.get("recipients", []))
        kind = "group" if c.get("type") == 3 else "dm"
        print(f"{c['id']}  [{kind}]  {rec or c.get('name','')}")
    print(f"\n{len(ch)} open DM/group channels")


def cmd_read(channel_id, n="50"):
    msgs = _req("GET", f"/channels/{channel_id}/messages?limit={int(n)}")
    for m in reversed(msgs):  # oldest → newest
        a = m.get("author", {})
        who = a.get("global_name") or a.get("username", "?")
        ts = m.get("timestamp", "")[:19].replace("T", " ")
        body = (m.get("content") or "").replace("\n", " ⏎ ")
        if not body and m.get("embeds"):
            body = f"[embed: {m['embeds'][0].get('title') or m['embeds'][0].get('description','')[:80]}]"
        if not body and m.get("attachments"):
            body = f"[{len(m['attachments'])} attachment(s)]"
        print(f"{ts}  {who:>18}: {body}")
    print(f"\n{len(msgs)} messages")


def cmd_channels(guild_id):
    ch = _req("GET", f"/guilds/{guild_id}/channels")
    cats = {c["id"]: c["name"] for c in ch if c.get("type") == 4}
    types = {0: "text", 2: "voice", 4: "cat", 5: "news", 15: "forum"}
    for c in sorted(ch, key=lambda x: (x.get("parent_id") or "", x.get("position", 0))):
        if c.get("type") == 4:
            print(f"\n▼ {c['name']}  ({c['id']})")
        else:
            t = types.get(c.get("type"), c.get("type"))
            print(f"  #{c.get('name'):<28} [{t}]  {c['id']}")
    print(f"\n{len([c for c in ch if c.get('type') != 4])} channels in {len(cats)} categories")


def cmd_search(guild_id, query):
    res = _req("GET", f"/guilds/{guild_id}/messages/search?content={requests.utils.quote(query)}")
    for grp in res.get("messages", []):
        for m in grp:
            a = m.get("author", {})
            who = a.get("username", "?")
            print(f"{m.get('timestamp','')[:19]}  {who}: {(m.get('content') or '')[:120]}")
    print(f"\n~{res.get('total_results', 0)} total matches")


def main():
    if len(sys.argv) < 2:
        print(__doc__); sys.exit(1)
    cmd, rest = sys.argv[1], sys.argv[2:]
    dispatch = {
        "set-token": lambda: cmd_set_token(rest[0] if rest else None),
        "whoami": cmd_whoami, "guilds": cmd_guilds, "dms": cmd_dms,
        "read": lambda: cmd_read(*rest), "channels": lambda: cmd_channels(*rest),
        "search": lambda: cmd_search(*rest),
    }
    fn = dispatch.get(cmd)
    if not fn:
        print(__doc__); sys.exit(f"unknown command: {cmd}")
    fn()


if __name__ == "__main__":
    main()
