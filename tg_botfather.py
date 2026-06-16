#!/home/itsju/.venv/bin/python
"""tg_botfather.py — MTProto (Telethon) driver for the @BotFather operations the
Telegram **Bot API cannot do**: pull every bot's TOKEN and rename @usernames.

Logged in as Mike's *user* account (not a bot), it talks to @BotFather the same way
a human would — but scripted and reusable. Solves two standing blockers:
  • the 3 cloud-bot tokens (daily_briefs/media_gens/spare_backup) that exist nowhere
    locally — `tokens` pulls them straight from BotFather, no manual paste.
  • the cryptic @usernames shown in BotFather's own /mybots picker — `rename-all`
    changes them to function-based handles.

SAFETY: own-account automation at human pace. Every BotFather step is throttled
(2–4s); availability is checked WITHOUT touching BotFather (entity-resolve), so the
dry-run is side-effect-free. Tokens/session are password-grade → vault only, never
printed or logged.

One-time setup (Mike):
  1. my.telegram.org → API development tools → create app → api_id + api_hash
  2. tg_botfather.py set-creds <API_ID> <API_HASH>
  3. ! ~/.venv/bin/python ~/scripts/tg_botfather.py login      (interactive phone code)

Then:
  tg_botfather.py list                  # full roster from /mybots, reconciled vs FLEET
  tg_botfather.py tokens --missing      # pull the 3 cloud tokens into vault (+verify ids)
  tg_botfather.py rename-all            # DRY-RUN: proposed handles + availability
  tg_botfather.py rename-all --apply    # commit the available ones
  tg_botfather.py rename <@old> <@new>  # single rename
"""
import argparse
import asyncio
import json
import os
import re
import sys
import urllib.request

sys.path.insert(0, os.path.expanduser("~/scripts"))
import tg_fleet as F  # FLEET, VKEY, _vault, _vget, set_token, VAULT

BF = "BotFather"
TOKEN_RE = re.compile(r"\b(\d{8,10}:[A-Za-z0-9_-]{35})\b")

# Cloud bots are known to the registry only by DISPLAY NAME (their real @username is
# unknown until BotFather tells us). Map name → function so `tokens` can place them.
CLOUD_NAME2FN = {
    "change now": "daily_briefs",
    "gamma trader assistant": "media_gens",
    "bobaclaw": "spare_backup",
}
# @username (lowercased, no @) → function, for the bots whose handle we already know.
USER2FN = {m["user"].lower(): fn for fn, m in F.FLEET.items() if not m["user"].startswith("(")}

# Starting proposal for rename-all — a SUGGESTION, not gospel. Dry-run shows which are
# free; Mike approves/edits (or passes his own map.json). All must end in 'bot'.
DEFAULT_PROPOSAL = {
    "trading_command": "MCTradingCmd_Bot",
    "macro_regime":    "MCMacroRegime_Bot",
    "risk_hedge":      "MCRiskHedge_Bot",
    "aime_research":   "MCResearchAI_Bot",
    "x_sentiment":     "MCXSentiment_Bot",
    "screener":        "MCScreener_Bot",
    "research_desk":   "MCResearchDesk_Bot",
    "jazzy_desk":      "MCJazzyDesk_Bot",
    "openclaw_grok":   "MCGrokRelay_Bot",
    # flow_signals (@PipelineSignals_Bot), system_health (@Pingpong727_Bot),
    # life_wellness (@LifeClaw727_Bot) already read clearly — left out by default.
}


# --------------------------------------------------------------------------- #
# vault — user-session creds live under category 'telegram_user'
# --------------------------------------------------------------------------- #
def _uget(key):
    con = F._vault()
    try:
        row = con.execute("SELECT value FROM secrets WHERE key=?", (key,)).fetchone()
        return row[0].strip() if row else None
    finally:
        con.close()


def _uput(key, val, note=""):
    con = F._vault()
    try:
        con.execute(
            """INSERT INTO secrets(key,value,category,note) VALUES(?,?,'telegram_user',?)
               ON CONFLICT(key) DO UPDATE SET value=excluded.value, note=excluded.note,
               updated_at=strftime('%s','now')""", (key, val, note))
        con.commit()
    finally:
        con.close()


def _creds():
    return (_uget("telegram_user.api_id"), _uget("telegram_user.api_hash"),
            _uget("telegram_user.session"))


def _getme_full(tok):
    """(username, first_name) for a bot token via the Bot API, or (None, None)."""
    try:
        r = json.load(urllib.request.urlopen(
            f"https://api.telegram.org/bot{tok}/getMe", timeout=8))
        if r.get("ok"):
            res = r["result"]
            return res.get("username"), res.get("first_name")
    except Exception:
        pass
    return None, None


# --------------------------------------------------------------------------- #
# Telethon client + BotFather conversation primitives
# --------------------------------------------------------------------------- #
def _client(new_session=False):
    from telethon import TelegramClient
    from telethon.sessions import StringSession
    api_id, api_hash, sess = _creds()
    if not api_id or not api_hash:
        sys.exit("No api_id/api_hash. Run: tg_botfather.py set-creds <API_ID> <API_HASH> "
                 "(from my.telegram.org)")
    return TelegramClient(StringSession("" if new_session else (sess or "")),
                          int(api_id), api_hash)


async def _bf_list(client):
    """All bot @usernames from BotFather's /mybots inline keyboard."""
    async with client.conversation(BF, timeout=60) as conv:
        await conv.send_message("/mybots")
        r = await conv.get_response()
        bots = []
        if r.reply_markup:
            for row in r.reply_markup.rows:
                for btn in row.buttons:
                    t = (getattr(btn, "text", "") or "").strip()
                    if t.startswith("@"):
                        bots.append(t)
        return bots


async def _bf_token(client, username):
    """Token for @username via the /token flow, or None."""
    u = username if username.startswith("@") else "@" + username
    async with client.conversation(BF, timeout=60) as conv:
        await conv.send_message("/token")
        await conv.get_response()
        await asyncio.sleep(2)
        await conv.send_message(u)
        r = await conv.get_response()
        m = TOKEN_RE.search(r.raw_text or "")
        return m.group(1) if m else None


async def _bf_setusername(client, old, new):
    """Run /setusername old→new. Returns ok|taken|invalid|unknown:<text>."""
    old_u = old if old.startswith("@") else "@" + old
    async with client.conversation(BF, timeout=60) as conv:
        await conv.send_message("/setusername")
        await conv.get_response()
        await asyncio.sleep(2)
        await conv.send_message(old_u)
        await conv.get_response()
        await asyncio.sleep(2)
        await conv.send_message(new.lstrip("@"))
        r = await conv.get_response()
        txt = (r.raw_text or "").lower()
        if "success" in txt:
            return "ok"
        if "taken" in txt or "already in use" in txt:
            return "taken"
        if "invalid" in txt:
            return "invalid"
        return "unknown: " + (r.raw_text or "")[:90]


async def _available(client, handle):
    """True=free, False=taken, None=unknown — via entity resolve (NO BotFather call)."""
    from telethon.errors import UsernameNotOccupiedError, UsernameInvalidError
    try:
        await client.get_entity(handle if handle.startswith("@") else "@" + handle)
        return False
    except UsernameNotOccupiedError:
        return True
    except UsernameInvalidError:
        return None
    except Exception:
        return None


# --------------------------------------------------------------------------- #
# Commands
# --------------------------------------------------------------------------- #
def cmd_setcreds(api_id, api_hash):
    int(api_id)  # validate numeric
    _uput("telegram_user.api_id", str(api_id), "my.telegram.org app")
    _uput("telegram_user.api_hash", api_hash, "my.telegram.org app")
    print("✓ api_id/api_hash stored (vault, category telegram_user).")
    print("  next: ! ~/.venv/bin/python ~/scripts/tg_botfather.py login")


async def cmd_login():
    api_id, api_hash, _ = _creds()
    if not api_id:
        sys.exit("set-creds first.")
    client = _client(new_session=True)
    await client.start()  # interactive: phone → code → 2FA password if set
    _uput("telegram_user.session", client.session.save(),
          "MTProto user session — password-grade")
    me = await client.get_me()
    print(f"✓ logged in as {me.first_name} (@{me.username}); session saved to vault.")
    await client.disconnect()


def _print_qr(url: str):
    """Render a login URL as an ASCII QR in the terminal (scannable from the phone app)."""
    import qrcode
    qr = qrcode.QRCode(border=2)
    qr.add_data(url)
    qr.make(fit=True)
    qr.print_ascii(invert=True)


async def cmd_login_qr(password: str | None = None):
    """QR login — no codes to type. Scan the printed QR from Telegram →
    Settings → Devices → Link Desktop Device. Auto-recreates the QR as it
    expires; pass your 2FA password as the arg if you have one set."""
    import asyncio
    from telethon.errors import SessionPasswordNeededError
    api_id, api_hash, _ = _creds()
    if not api_id:
        sys.exit("set-creds first.")
    client = _client(new_session=True)
    await client.connect()
    if await client.is_user_authorized():
        me = await client.get_me()
        print(f"✓ already logged in as {me.first_name} (@{me.username}).")
        await client.disconnect()
        return
    qr = await client.qr_login()
    authed = False
    for attempt in range(1, 11):  # ~10 × 30s ≈ 5 min of scan window
        print(f"\n── Scan this QR from your phone (attempt {attempt}/10) ──")
        print("   Telegram → Settings → Devices → Link Desktop Device\n")
        _print_qr(qr.url)
        try:
            authed = await qr.wait(timeout=30)
            break
        except asyncio.TimeoutError:
            await qr.recreate()
            continue
        except SessionPasswordNeededError:
            if not password:
                await client.disconnect()
                sys.exit("2FA is on — re-run: tg_botfather.py login-qr <YOUR_2FA_PASSWORD>")
            await client.sign_in(password=password)
            authed = True
            break
    if not authed:
        await client.disconnect()
        sys.exit("QR went unscanned after several tries — re-run login-qr.")
    _uput("telegram_user.session", client.session.save(),
          "MTProto user session — password-grade")
    me = await client.get_me()
    print(f"\n✓ logged in as {me.first_name} (@{me.username}); session saved to vault.")
    await client.disconnect()


async def cmd_login_phone(phone: str):
    """Paste-based step 1: request the SMS/app code (no interactive prompt)."""
    from telethon import TelegramClient
    from telethon.sessions import StringSession
    api_id, api_hash, _ = _creds()
    if not api_id:
        sys.exit("set-creds first.")
    client = TelegramClient(StringSession(), int(api_id), api_hash)
    await client.connect()
    sent = await client.send_code_request(phone)
    _uput("telegram_user.session_pending", client.session.save(), "login in progress")
    _uput("telegram_user.login_phone", phone, "login in progress")
    _uput("telegram_user.code_hash", sent.phone_code_hash, "login in progress")
    await client.disconnect()
    print(f"✓ code sent to {phone}. Check Telegram, then run:")
    print("  botfather login-code <CODE>            (or: ...login-code <CODE> <2FA_PASSWORD>)")


async def cmd_login_code(code: str, password: str | None = None):
    """Paste-based step 2: sign in with the code (+ 2FA password if set)."""
    from telethon import TelegramClient
    from telethon.sessions import StringSession
    from telethon.errors import SessionPasswordNeededError
    api_id, api_hash, _ = _creds()
    sess = _uget("telegram_user.session_pending")
    phone = _uget("telegram_user.login_phone")
    code_hash = _uget("telegram_user.code_hash")
    if not (sess and phone and code_hash):
        sys.exit("run 'botfather login-phone <PHONE>' first.")
    client = TelegramClient(StringSession(sess), int(api_id), api_hash)
    await client.connect()
    try:
        await client.sign_in(phone, code=str(code).strip(), phone_code_hash=code_hash)
    except SessionPasswordNeededError:
        if not password:
            await client.disconnect()
            sys.exit("2FA is on — run: botfather login-code <CODE> <YOUR_PASSWORD>")
        await client.sign_in(password=password)
    me = await client.get_me()
    _uput("telegram_user.session", client.session.save(),
          "MTProto user session — password-grade")
    con = F._vault()
    try:
        for k in ("session_pending", "login_phone", "code_hash"):
            con.execute("DELETE FROM secrets WHERE key=?", (f"telegram_user.{k}",))
        con.commit()
    finally:
        con.close()
    print(f"✓ logged in as {me.first_name} (@{me.username}). Session saved — tell Claude 'done'.")
    await client.disconnect()


async def _ensure_auth(client):
    await client.connect()
    if not await client.is_user_authorized():
        await client.disconnect()
        sys.exit("not logged in — run: tg_botfather.py login")


async def cmd_list():
    client = _client()
    await _ensure_auth(client)
    try:
        bots = await _bf_list(client)
        known = {m["user"].lower(): fn for fn, m in F.FLEET.items()}
        print(f"BotFather roster ({len(bots)}):")
        for u in bots:
            fn = known.get(u.lstrip("@").lower())
            print(f"  {u:28} {'→ '+fn if fn else '— UNTRACKED (not in FLEET)'}")
        tracked = {m["user"].lstrip('@').lower() for m in F.FLEET.values()
                   if not m["user"].startswith("(")}
        listed = {u.lstrip('@').lower() for u in bots}
        missing = tracked - listed
        if missing:
            print("registry bots NOT in BotFather list:", ", ".join(sorted(missing)))
    finally:
        await client.disconnect()


async def cmd_tokens(missing_only):
    client = _client()
    await _ensure_auth(client)
    try:
        need = set()
        con = F._vault()
        try:
            for fn in F.FLEET:
                if not F._vget(con, F.VKEY(fn)):
                    need.add(fn)
        finally:
            con.close()
        bots = await _bf_list(client)
        print(f"BotFather lists {len(bots)} bots. Pulling tokens (human-paced)…")
        for u in bots:
            await asyncio.sleep(3)
            tok = await _bf_token(client, u)
            if not tok:
                print(f"  ✗ {u}: no token parsed (maybe inline-only flow) — skip")
                continue
            user, name = _getme_full(tok)
            fn = (USER2FN.get((user or u.lstrip("@")).lower())
                  or CLOUD_NAME2FN.get((name or "").strip().lower()))
            if not fn:
                print(f"  • {u} (name={name!r}) — untracked; not stored")
                continue
            if missing_only and fn not in need:
                print(f"  · {fn:14} {u} already in vault — skip")
                continue
            F.set_token(fn, tok)  # validates via getMe, writes vault (prints @handle, not token)
            if F.FLEET[fn]["user"].startswith("("):
                print(f"     ↳ {fn}: real handle @{user} (registry placeholder "
                      f"{F.FLEET[fn]['user']} — update FLEET.user to @{user})")
    finally:
        await client.disconnect()


async def cmd_rename_one(old, new):
    client = _client()
    await _ensure_auth(client)
    try:
        avail = await _available(client, new)
        print(f"@{new.lstrip('@')}: {'FREE' if avail else 'TAKEN' if avail is False else '?'}")
        if avail:
            res = await _bf_setusername(client, old, new)
            print(f"  {old} → @{new.lstrip('@')}: {res}")
    finally:
        await client.disconnect()


async def cmd_rename_all(map_path, apply):
    client = _client()
    await _ensure_auth(client)
    try:
        mapping = json.load(open(os.path.expanduser(map_path))) if map_path else DEFAULT_PROPOSAL
        print(f"{'APPLYING' if apply else 'DRY-RUN'} — {len(mapping)} renames:")
        for fn, new in mapping.items():
            old = F.FLEET.get(fn, {}).get("user", "")
            if old.startswith("(") or not old:
                print(f"  · {fn:16} no current @handle — skip")
                continue
            avail = await _available(client, new)
            tag = {True: "FREE", False: "TAKEN", None: "?"}[avail]
            line = f"  {fn:16} @{old} → @{new}  [{tag}]"
            if apply and avail:
                await asyncio.sleep(3)
                res = await _bf_setusername(client, old, new)
                line += f"  applied:{res}"
            print(line)
        if not apply:
            print("→ review, then re-run with --apply (only FREE handles are changed).")
    finally:
        await client.disconnect()


def main():
    ap = argparse.ArgumentParser(description="MTProto @BotFather driver (tokens + usernames)")
    sub = ap.add_subparsers(dest="cmd", required=True)
    sc = sub.add_parser("set-creds"); sc.add_argument("api_id"); sc.add_argument("api_hash")
    sub.add_parser("login")
    lq = sub.add_parser("login-qr"); lq.add_argument("password", nargs="?")
    lp = sub.add_parser("login-phone"); lp.add_argument("phone")
    lc = sub.add_parser("login-code"); lc.add_argument("code"); lc.add_argument("password", nargs="?")
    sub.add_parser("list")
    tk = sub.add_parser("tokens"); tk.add_argument("--missing", action="store_true")
    tk.add_argument("--all", action="store_true")
    rn = sub.add_parser("rename"); rn.add_argument("old"); rn.add_argument("new")
    ra = sub.add_parser("rename-all"); ra.add_argument("map", nargs="?")
    ra.add_argument("--apply", action="store_true")
    a = ap.parse_args()

    if a.cmd == "set-creds":
        cmd_setcreds(a.api_id, a.api_hash)
    elif a.cmd == "login":
        asyncio.run(cmd_login())
    elif a.cmd == "login-qr":
        asyncio.run(cmd_login_qr(a.password))
    elif a.cmd == "login-phone":
        asyncio.run(cmd_login_phone(a.phone))
    elif a.cmd == "login-code":
        asyncio.run(cmd_login_code(a.code, a.password))
    elif a.cmd == "list":
        asyncio.run(cmd_list())
    elif a.cmd == "tokens":
        asyncio.run(cmd_tokens(missing_only=a.missing or not a.all))
    elif a.cmd == "rename":
        asyncio.run(cmd_rename_one(a.old, a.new))
    elif a.cmd == "rename-all":
        asyncio.run(cmd_rename_all(a.map, a.apply))


if __name__ == "__main__":
    main()
