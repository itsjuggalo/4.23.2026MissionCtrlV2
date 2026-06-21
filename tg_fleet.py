#!/home/itsju/.venv/bin/python
"""tg_fleet.py — the single source of truth for Mike's Telegram bot fleet.

Mike's decision (2026-06-15): ALL telegram tokens live in ONE place = vault.db, and every
bot has exactly ONE function. This module:
  • holds the FLEET registry (function → identity + role)
  • `harvest`  — pulls each token from its (scattered) current source, getMe-verifies it, and
                 writes it into vault.db under a uniform key  telegram.<function>
  • `send`     — send(function, msg): resolve the vault token + post to Mike's chat
  • `export`   — regenerate the old flat secret-file names from vault (back-compat shim)
  • `status`   — print the fleet + verify each token via getMe
  • `manifest` — write ~/.openclaw/telegram_fleet.json (metadata only, NO token values)

  tg_fleet.py status
  tg_fleet.py harvest [--write]
  tg_fleet.py send <function> "<message>"
  tg_fleet.py token <function>            # print the vault-first resolved token (for senders)
  tg_fleet.py set <function> <TOKEN>      # fold in a cloud-only bot (Gamma/CHANGE NOW/BobaClaw)
"""
import json
import os
import sqlite3
import sys
import urllib.parse
import urllib.request

import requests

SEC = os.path.expanduser("~/.openclaw/secrets")
VAULT = os.path.expanduser("~/.openclaw/vault.db")
MANIFEST = os.path.expanduser("~/.openclaw/telegram_fleet.json")
CHAT_FILE = os.path.join(SEC, "telegram-chat-id.txt")

# function → identity. `src` = where the token CURRENTLY lives (for harvest):
#   ("file", name) flat secret file · ("vault", key) existing vault key · ("cloud", None) Mike pastes.
# role: interactive (polled getUpdates) | push (send-only) | infra (not a chat target) | spare
FLEET = {
    # ── interactive (you text them) ─────────────────────────────────────────
    "trading_command": dict(user="oOLaptopClaude_Bot",      avatar="raynor",          role="interactive", src=("file", "telegram_laptopclaude_bot_token")),
    "system_health":   dict(user="Pingpong727_Bot",         avatar="adjutant",        role="interactive", src=("file", "telegram-ping-bot-token")),
    "life_wellness":   dict(user="LifeClaw727_Bot",         avatar="arbiter",         role="interactive", src=("file", "lifeclaw_telegram_bot_token")),
    "aime_research":   dict(user="AntiGravityg59laptop_Bot",avatar="zeratul",         role="interactive", src=("file", "telegram_antigravity_bot_token")),
    "x_sentiment":     dict(user="MoneyFlowz_Bot",          avatar="mutalisk",        role="interactive", src=("file", "telegram_grok_bot_token")),
    "jazzy_desk":      dict(user="JazzyHazzyClaw_Bot",      avatar="duke",            role="interactive", src=("file", "telegram_jazzyhazzy_bot_token")),
    "risk_hedge":      dict(user="AntiDoht_Bot",            avatar="aldaris",         role="interactive", src=("file", "antidote_telegram_bot_token")),
    "research_desk":   dict(user="ResearchDaMoney_Bot",     avatar="high_templar",    role="interactive", src=("file", "telegram_orion_bot_token")),
    "screener":        dict(user="TrndRsrch_Bot",           avatar="wraith",          role="interactive", src=("file", "telegram_deepseek_bot_token")),
    "macro_regime":    dict(user="MMCTRL727_Bot",           avatar="mengsk",          role="interactive", src=("file", "telegram_mc_skill_bot_token")),
    # ── push (they alert you) ───────────────────────────────────────────────
    "flow_signals":    dict(user="PipelineSignals_Bot",     avatar="queen_of_blades", role="push",        src=("file", "telegram-bot-token.txt")),
    "flow_digest":     dict(user="Boba2Telegram_Bot",       avatar="hydralisk",       role="push",        src=("vault", "telegram_boba2_bot_token")),
    "daily_briefs":    dict(user="SpaceCoast_Claude_Bot",   avatar="ghost",           role="push",        src=("cloud", None)),
    # ── media (off the trade chats) ─────────────────────────────────────────
    "media_gens":      dict(user="JazzyHazzyTelegram_Bot",  avatar="fenix",           role="push",        src=("cloud", None)),
    # ── infra (not chat targets) ────────────────────────────────────────────
    "hermes_relay":    dict(user="Gumroadie_bot",           avatar="dragoon",         role="infra",       src=("vault", "telegram_hermes_bot_token")),
    "openclaw_grok":   dict(user="OpenclawGrok727_Bot",     avatar="ghost",           role="infra",       src=("vault", "telegram_openclaw_bot_token")),
    # laptop_control = the Remote-Control phone gateway bot (tg-channel). Dedicated BotFather bot;
    # token at ~/.openclaw/secrets/telegram_phone_channel_bot_token (no-token until Mike creates it).
    "laptop_control":  dict(user="(pending BotFather)",     avatar="battlecruiser",   role="infra",       src=("file", "telegram_phone_channel_bot_token")),
    # ── spare ───────────────────────────────────────────────────────────────
    "spare_backup":    dict(user="(BobaClaw)",              avatar="tassadar",        role="spare",       src=("cloud", None)),
    # ── reserve pool (Mike's spare bots, folded in 2026-06-16 — named + rebranded, persona-ready) ──
    "jazzy_relay":     dict(user="JazzyHazzy_Bot",          avatar="zealot",          role="spare",       src=("cloud", None)),
    "orion_relay":     dict(user="oOrionz_Bot",             avatar="kerrigan",        role="spare",       src=("cloud", None)),
    "grok_scout":      dict(user="Grootk_Bot",              avatar="goliath",         role="spare",       src=("cloud", None)),
    "trend_scanner":   dict(user="Deepseeker_Bot",          avatar="firebat",         role="spare",       src=("cloud", None)),
}

VKEY = "telegram.{}".format  # vault key for a function


def _vault():
    con = sqlite3.connect(VAULT)
    con.execute("""CREATE TABLE IF NOT EXISTS secrets(key TEXT PRIMARY KEY, value TEXT NOT NULL,
                   category TEXT NOT NULL DEFAULT 'general', note TEXT,
                   created_at INTEGER DEFAULT (strftime('%s','now')),
                   updated_at INTEGER DEFAULT (strftime('%s','now')))""")
    return con


def _vget(con, key):
    row = con.execute("SELECT value FROM secrets WHERE key=?", (key,)).fetchone()
    return row[0].strip() if row else None


def _vput(con, key, val, note):
    con.execute("""INSERT INTO secrets(key,value,category,note) VALUES(?,?,'telegram',?)
                   ON CONFLICT(key) DO UPDATE SET value=excluded.value, note=excluded.note,
                   updated_at=strftime('%s','now')""", (key, val, note))
    con.commit()


def _src_token(con, src):
    kind, ref = src
    if kind == "file":
        p = os.path.join(SEC, ref)
        return open(p).read().strip() if os.path.exists(p) else None
    if kind == "vault":
        return _vget(con, ref)
    return None  # cloud → not local


def _getme(tok):
    try:
        r = json.load(urllib.request.urlopen(f"https://api.telegram.org/bot{tok}/getMe", timeout=8))
        return r["result"]["username"] if r.get("ok") else None
    except Exception:
        return None


def token(fn):
    """The canonical token for a function — vault first, else its source (pre-migration)."""
    con = _vault()
    try:
        return _vget(con, VKEY(fn)) or _src_token(con, FLEET[fn]["src"])
    finally:
        con.close()


def harvest(write=False):
    con = _vault()
    try:
        for fn, m in FLEET.items():
            vkey = VKEY(fn)
            if _vget(con, vkey):
                print(f"  ✓ {fn:16} already in vault ({m['user']})")
                continue
            tok = _src_token(con, m["src"])
            if not tok:
                print(f"  … {fn:16} {'CLOUD — paste with: tg_fleet.py set '+fn+' <TOKEN>' if m['src'][0]=='cloud' else 'source missing: '+str(m['src'])}")
                continue
            u = _getme(tok)
            if not u:
                print(f"  ✗ {fn:16} token DEAD via getMe ({m['src']})")
                continue
            if write:
                _vput(con, vkey, tok, f"@{u} · {m['role']}")
                print(f"  → {fn:16} vault[{vkey}] = @{u}")
            else:
                print(f"  • {fn:16} would migrate @{u} from {m['src']}")
    finally:
        con.close()


def set_token(fn, tok):
    if fn not in FLEET:
        print(f"unknown function '{fn}'. known: {', '.join(FLEET)}"); return
    u = _getme(tok)
    if not u:
        print("that token is DEAD via getMe — not stored."); return
    con = _vault()
    try:
        _vput(con, VKEY(fn), tok, f"@{u} · {FLEET[fn]['role']}")
        print(f"✓ {fn} → vault[{VKEY(fn)}] = @{u}")
    finally:
        con.close()


def send(fn, msg):
    tok = token(fn)
    if not tok:
        print(f"no token for {fn}"); return 1
    chat = open(CHAT_FILE).read().strip()
    import urllib.parse
    data = urllib.parse.urlencode({"chat_id": chat, "text": msg,
                                   "disable_web_page_preview": "true"}).encode()
    try:
        r = json.load(urllib.request.urlopen(f"https://api.telegram.org/bot{tok}/sendMessage", data=data, timeout=15))
        print("sent" if r.get("ok") else f"fail: {r.get('description')}")
        return 0 if r.get("ok") else 1
    except Exception as e:
        print(f"send error: {e}"); return 1


def _resolve(fn):
    """Return (token, label). media_gens falls back to system_health until its token is set."""
    tok = token(fn)
    if tok:
        return tok, fn
    if fn == "media_gens":
        return token("system_health"), "system_health(fallback)"
    return None, fn


def send_upload(fn, path, caption="", as_doc=False):
    if not os.path.exists(path):
        print(f"no such file: {path}"); return 1
    tok, label = _resolve(fn)
    if not tok:
        print(f"no token for {fn}"); return 1
    chat = open(CHAT_FILE).read().strip()
    low = path.lower()
    if as_doc:
        method, field = "sendDocument", "document"
    elif low.endswith((".jpg", ".jpeg", ".png", ".webp", ".gif")):
        method, field = "sendPhoto", "photo"
    elif low.endswith((".mp4", ".mov", ".webm", ".mkv")):
        method, field = "sendVideo", "video"
    else:
        method, field = "sendDocument", "document"
    data = {"chat_id": chat}
    if caption:
        data["caption"] = caption
    with open(path, "rb") as fh:
        r = requests.post(f"https://api.telegram.org/bot{tok}/{method}",
                          data=data, files={field: fh}, timeout=90).json()
    if r.get("ok"):
        print(f"sent {os.path.basename(path)} → {label}"); return 0
    if method == "sendVideo":  # codec fallback
        with open(path, "rb") as fh:
            r = requests.post(f"https://api.telegram.org/bot{tok}/sendDocument",
                              data=data, files={"document": fh}, timeout=90).json()
        if r.get("ok"):
            print(f"sent {os.path.basename(path)} → {label} (as document)"); return 0
    print(f"fail: {r.get('description')}"); return 1


def manifest():
    m = {fn: {"username": d["user"], "vault_key": VKEY(fn), "avatar": d["avatar"],
              "role": d["role"]} for fn, d in FLEET.items()}
    json.dump(m, open(MANIFEST, "w"), indent=2)
    print(f"wrote {MANIFEST} ({len(m)} bots)")


def status():
    con = _vault()
    try:
        print(f"{'function':16} {'role':12} {'username':26} in_vault  live")
        for fn, m in FLEET.items():
            inv = "yes" if _vget(con, VKEY(fn)) else "no"
            tok = token(fn)
            live = ("@" + _getme(tok)) if tok else "—"
            print(f"{fn:16} {m['role']:12} {m['user']:26} {inv:8} {live}")
    finally:
        con.close()


if __name__ == "__main__":
    a = sys.argv[1:]
    cmd = a[0] if a else "status"
    if cmd == "harvest":
        harvest(write="--write" in a)
    elif cmd == "set" and len(a) >= 3:
        set_token(a[1], a[2])
    elif cmd == "token" and len(a) >= 2:
        # print the vault-first resolved token for a function (for senders to centralize on)
        t = token(a[1])
        if t:
            print(t)
        sys.exit(0 if t else 1)
    elif cmd == "send" and len(a) >= 3:
        sys.exit(send(a[1], " ".join(a[2:])))
    elif cmd == "sendfile" and len(a) >= 3:
        sys.exit(send_upload(a[1], a[2], a[3] if len(a) > 3 else "", as_doc=True))
    elif cmd == "sendmedia" and len(a) >= 3:
        sys.exit(send_upload(a[1], a[2], a[3] if len(a) > 3 else ""))
    elif cmd == "manifest":
        manifest()
    else:
        status()
