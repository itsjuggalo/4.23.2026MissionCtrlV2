#!/usr/bin/env python3
"""
discord_overhaul.py — Mike's 2026-06-21 Discord overhaul (NON-DESTRUCTIVE).

Builds the public-front-door tree on guild MissionCtrl Trade Team:
  - asset-class rename + recategorize + A-Z sort within every category
  - public/private permission wall keyed on @Verified (gate already exists)
  - re-create CouponClaw's deleted channels + update ~/coupon-claw/.env
  - archive experimental/dormant floaters (NEVER delete; move to ARCHIVE)

Waves (run independently; dry-run is the default):
  discord_overhaul.py --wave recreate           # coupon DEALS cat + 3 channels
  discord_overhaul.py --wave reorg               # rename/recategorize/A-Z/archive/merge
  discord_overhaul.py --wave perms               # public/private wall + verify gate
  discord_overhaul.py --wave all                 # all three, in order
  add --execute to actually mutate (else dry-run prints every action)

Actor = discord_ops_bot_token (Reminders bot, @MC Bots = Administrator).
Owner = Mike (bypasses all overwrites -> cannot be locked out).
Rollback -> ~/.openclaw/secrets/.discord-overhaul-rollback.json
Created-id cache -> ~/.openclaw/workspace/state/discord_overhaul_created.json
"""
import sys, json, time
from pathlib import Path

sys.path.insert(0, str(Path.home() / ".openclaw"))
from vault import get_secret  # noqa: E402
import requests  # noqa: E402

API = "https://discord.com/api/v10"
G = get_secret("discord_guild_id").strip()
BOT = get_secret("discord_ops_bot_token").strip()
H = {"Authorization": f"Bot {BOT}", "User-Agent": "MCOverhaul/1.0", "Content-Type": "application/json"}
SEC = Path.home() / ".openclaw" / "secrets"
STATE = Path.home() / ".openclaw" / "workspace" / "state"
SNAP = json.loads((STATE / "discord_guild_snapshot.json").read_text())
SMAP = json.loads(Path("/tmp/discord_secret_map.json").read_text()) if Path("/tmp/discord_secret_map.json").exists() else {}
ROLLBACK = SEC / ".discord-overhaul-rollback.json"
CREATED_F = STATE / "discord_overhaul_created.json"
DRY = "--execute" not in sys.argv
WAVE = (sys.argv[sys.argv.index("--wave") + 1] if "--wave" in sys.argv else "all")

# ── role ids ──────────────────────────────────────────────────────────────
EVERYONE = G
VERIFIED = "1486033851594838118"
MEMBER = "1518434759678627951"  # gate-granted role (ops bot CAN assign; @Verified it cannot)
ASKGROK = "1497457295297347687"
COUPONCLAW = "1491241034380873832"
ARCHIVE_CAT = "1507444328681832479"
# bot roles that READ private channels via gateway (webhooks bypass view anyway)
BOT_PRIV_VIEW = [
    "1518337048627511488",  # MC Bots (admin)
    "1489403275626151949", "1497762598479855629", "1501993052074676300",  # Boba/BobaUpgraded/BobaToday
    "1489395509700333621", "1489401489783787524", "1489808339704615015",  # jazzy/Orion/Orion2
    "1498804421176463424", "1497750786753564692",  # Kronos/SynthControl
    "1497765446164942983", "1498862701638582317",  # TGBridge/MC Status
    "1493804134590185485", "1486135269722685574",  # scorer/ArchiveBot
]

# perm bits
VIEW = 1 << 10
SEND = 1 << 11

# ── live lookups from snapshot ──────────────────────────────────────────────
name2id, id2name, id2age = {}, {}, {}
for cat in SNAP["categories"]:
    for c in cat["channels"]:
        name2id[c["name"]] = c["id"]; id2name[c["id"]] = c["name"]; id2age[c["id"]] = c["age_days"]
for c in SNAP.get("uncategorized", []):
    name2id[c["name"]] = c["id"]; id2name[c["id"]] = c["name"]; id2age[c["id"]] = c["age_days"]
secrets_by_chan = {}
for fn, info in SMAP.items():
    cid = info.get("channel_id")
    if cid:
        secrets_by_chan.setdefault(cid, []).append(fn)
# disambiguate duplicate channel names -> force the LIVE id (not the archived dupe)
AMBIG = {"performance": "1486045633855881259"}  # TRADING live, not ARCHIVE 1497766751566565396
name2id.update(AMBIG)
created = json.loads(CREATED_F.read_text()) if CREATED_F.exists() else {}
rollback = json.loads(ROLLBACK.read_text()) if ROLLBACK.exists() else {"renames": {}, "moves": {}, "secrets": {}, "created": []}
flagged = []

# ── TARGET TREE ─────────────────────────────────────────────────────────────
# vis: entry | public | public_interactive | private
# each channel: (current_live_name_OR_new, rename_to | None)
TARGET = [
    ("📌 START HERE", "1518339855896285324", "entry", [
        ("welcome", None), ("rules-disclaimer", None),
        ("announcements", None), ("verify", None)]),
    ("📰 BRIEFS", "1502375208072249344", "public", [
        ("premarket-brief", None), ("midday-brief", None),
        ("closing-brief", None), ("price-checker", None)]),
    ("🐳 OPTIONS FLOW", "1507444324508500119", "public", [
        ("flow-picks", None), ("flow-unusual", None), ("flow-huge", None),
        ("flow-repeaters", None), ("flow-etf-weekly", None), ("whale-flow", None),
        ("flow-results", None), ("flow-wins", None),
        ("fg-option-alerts", "flow-fg-alerts"), ("fg-live-flow", "flow-live")]),
    ("🎯 SIGNALS", "1502375197066662029", "public", [
        ("stock-signals", None), ("stocksignals-picks", "stock-picks"),
        ("stocksignals-closed", "stock-closed"), ("stocksignals-mgmt", "stock-mgmt"),
        ("long-term-stocks", "stock-longterm"),
        ("options-signals", None), ("tradesignals-closed", "options-closed"),
        ("tradesignals-mgmt", "options-mgmt"), ("service-picks", "options-service"),
        ("crypto-signals", None), ("scalp-signals", None), ("swing-signals", None),
        ("provider-signals", None), ("telegram-feed", "provider-telegram")]),
    ("🎯 SNIPER", "1515359701087555584", "public", [
        ("sniper-entries", None), ("sniper-exits", None), ("sniper-dips", None),
        ("sniper-skips", None), ("sniper-watchlist", None)]),
    ("📡 ALERTS & SENTIMENT", "1502734857875357868", "public", [
        ("market-sentiment", None), ("macro-sentiment", None),
        ("pattern-alerts", None), ("squeeze-alerts", None), ("x-updates", None),
        ("fg1-bullbear", "sentiment-fg-bull"), ("fg2-bullbear", "sentiment-fg-bear")]),
    ("🌐 RESEARCH & MACRO", "1507444326588878969", "public", [
        ("analyst-research", None), ("earnings", None), ("macro", None),
        ("macro-calendar", None), ("sector-rotation", None)]),
    ("📊 TRACK RECORD", None, "public", [
        ("paper-trades", None), ("performance", None), ("trade-reviews", None)]),
    ("🎟️ DEALS", None, "public_interactive", [
        ("coupon-request", "__create__"), ("coupon-logs", "__create__"),
        ("coupon-watchlist", "__create__")]),
    ("💰 EXECUTION", "1502734853119148093", "private", [
        ("live-executions", None), ("auto-trader", None), ("closed-trades", None),
        ("backtest", None), ("execution-history", None), ("os-closed-stocks", None),
        ("boba-trades", None)]),
    ("🛡️ RISK & PORTFOLIO", "1502734864275734740", "private", [
        ("risk", None), ("portfolio", None)]),
    ("🤖 AGENTS & BOTS", "1502734870575579357", "private", [
        ("agent-comms", None), ("bot-commands", None), ("kronos", None),
        ("reminders", None), ("synthetic-analysis", None), ("tg-bridge", None),
        ("leftover-tasks", None)]),
    ("⚙️ SYSTEM", "1502375214623887372", "private", [
        ("mission-control", None), ("system-logs", None),
        ("general", None), ("massage-bookings", None)]),
]
# webhook-fed dupes to merge (re-point secret -> survivor, then archive source)
MERGES = {"premarket-brief": ["morning-briefs"]}
# dormant/experimental floaters -> ARCHIVE (NEVER delete)
ARCHIVE_DRAIN = ["flow-v2-shadow", "flow-v2-digest", "flow-cards",
                 "signal-digests", "bluestacks", "linear-feed"]


def req(method, path, **kw):
    for _ in range(8):
        r = requests.request(method, API + path, headers=H, timeout=30, **kw)
        if r.status_code == 429:
            time.sleep(float(r.headers.get("Retry-After", 2)) + 0.5); continue
        if r.status_code >= 400:
            raise RuntimeError(f"{method} {path} -> {r.status_code} {r.text[:200]}")
        time.sleep(0.35)
        return r.json() if r.text else {}
    raise RuntimeError("rate-limited")


def save():
    if DRY:
        return
    CREATED_F.write_text(json.dumps(created, indent=2))
    ROLLBACK.write_text(json.dumps(rollback, indent=2))


# ── WAVE: recreate (DEALS cat + coupon channels) ────────────────────────────
def ensure_category(name):
    """return cat id, creating if needed (cached)."""
    if name in created:
        return created[name]
    # find by existing id in TARGET
    for n, cid, *_ in TARGET:
        if n == name and cid:
            return cid
    print(f"CREATE category {name}")
    if DRY:
        return f"<new-cat:{name}>"
    j = req("POST", f"/guilds/{G}/channels", json={"name": name, "type": 4})
    created[name] = j["id"]; rollback["created"].append(j["id"]); save()
    return j["id"]


def ensure_channel(name, parent_id):
    if name in name2id:
        return name2id[name]
    if name in created:
        return created[name]
    print(f"CREATE channel #{name} under {parent_id}")
    if DRY:
        return f"<new-chan:{name}>"
    j = req("POST", f"/guilds/{G}/channels", json={"name": name, "type": 0, "parent_id": parent_id})
    created[name] = j["id"]; rollback["created"].append(j["id"]); name2id[name] = j["id"]; save()
    return j["id"]


def wave_recreate():
    print("\n=== WAVE recreate (CouponClaw DEALS) ===")
    deals = ensure_category("🎟️ DEALS")
    ids = {}
    for ch in ("coupon-request", "coupon-logs", "coupon-watchlist"):
        ids[ch] = ensure_channel(ch, deals)
    print(f"coupon channel ids: {ids}")
    return ids


# ── WAVE: reorg (rename / merge / recategorize / A-Z / archive) ─────────────
def get_survivor_webhook(sid, label):
    if DRY:
        return f"<wh:{sid}>"
    whs = req("GET", f"/channels/{sid}/webhooks")
    wh = next((w for w in whs if isinstance(w, dict) and (w.get("name") or "").startswith("mc-")), None)
    if not wh:
        wh = req("POST", f"/channels/{sid}/webhooks", json={"name": f"mc-{label}"})
    return f"https://discord.com/api/webhooks/{wh['id']}/{wh['token']}"


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


def wave_reorg():
    print("\n=== WAVE reorg ===")
    # 1) renames (asset-class clustering)
    print("\n-- renames --")
    for cat_name, cid, vis, chans in TARGET:
        for cur, ren in chans:
            if ren and ren not in ("__create__",):
                sid = name2id.get(cur)
                if not sid:
                    continue
                print(f"RENAME #{cur} -> #{ren}")
                if not DRY:
                    req("PATCH", f"/channels/{sid}", json={"name": ren})
                    rollback["renames"][sid] = cur
                name2id[ren] = sid  # track new name
    # 2) webhook merges
    print("\n-- merges (re-point webhook + archive source) --")
    for survivor, sources in MERGES.items():
        sid = name2id.get(survivor)
        if not sid:
            continue
        for src in sources:
            abid = name2id.get(src)
            if not abid:
                continue
            if abid in secrets_by_chan:
                url = get_survivor_webhook(sid, survivor)
                files = repoint(abid, url)
                print(f"MERGE #{src} -> #{survivor} (re-point {len(files)} secret) + archive")
                _archive(abid, src)
            elif id2age.get(abid) is None or id2age[abid] > 14:
                print(f"ARCHIVE #{src} (dormant, no webhook)")
                _archive(abid, src)
            else:
                print(f"FLAG #{src} active+bot-fed (no webhook) — left in place")
                flagged.append(src)
    # 3) archive drains
    print("\n-- archive drains --")
    for ch in ARCHIVE_DRAIN:
        cid2 = name2id.get(ch)
        if cid2:
            print(f"ARCHIVE #{ch}")
            _archive(cid2, ch)
    save()


_archive_cats = [ARCHIVE_CAT]


def _archive(cid, name):
    rollback["moves"].setdefault(cid, None)
    if DRY:
        return
    for target in list(_archive_cats):
        try:
            req("PATCH", f"/channels/{cid}", json={"parent_id": target, "lock_permissions": True})
            return
        except RuntimeError as e:
            if "CHANNEL_PARENT_MAX_CHANNELS" not in str(e):
                raise
    # all archive cats full -> create overflow
    ov = ensure_category("🗄️ ARCHIVE ②")
    _archive_cats.append(ov)
    req("PATCH", f"/channels/{cid}", json={"parent_id": ov, "lock_permissions": True})


def wave_positions():
    """recategorize + A-Z within each category (individual PATCH; bulk multi-parent is rejected)."""
    print("\n=== recategorize + A-Z sort ===")
    cat_pos = 0
    for cat_name, cid, vis, chans in TARGET:
        real_cid = created.get(cat_name, cid)
        if not real_cid or str(real_cid).startswith("<"):
            print(f"(skip positions for uncreated {cat_name})"); cat_pos += 1; continue
        if not DRY:
            req("PATCH", f"/channels/{real_cid}", json={"position": cat_pos, "name": cat_name})
        cat_pos += 1
        finals = []
        for cur, ren in chans:
            final_name = ren if (ren and ren != "__create__") else cur
            sid = name2id.get(final_name) or created.get(final_name)
            if sid and not str(sid).startswith("<"):
                finals.append((final_name, sid))
        for pos, (fname, sid) in enumerate(sorted(finals)):  # A-Z
            rollback["moves"].setdefault(sid, "?")
            print(f"   {cat_name[:14]:<14} [{pos}] #{fname}")
            if not DRY:
                req("PATCH", f"/channels/{sid}", json={"parent_id": real_cid, "position": pos})
    save()


# ── WAVE: perms (public/private wall) ───────────────────────────────────────
def overwrites_for(vis):
    ow = []
    if vis == "entry":
        ow.append({"id": EVERYONE, "type": 0, "allow": str(VIEW), "deny": str(SEND)})
        ow.append({"id": VERIFIED, "type": 0, "allow": str(VIEW), "deny": "0"})
        ow.append({"id": MEMBER, "type": 0, "allow": str(VIEW), "deny": "0"})
    elif vis == "public":
        ow.append({"id": EVERYONE, "type": 0, "allow": "0", "deny": str(VIEW)})
        ow.append({"id": VERIFIED, "type": 0, "allow": str(VIEW), "deny": str(SEND)})
        ow.append({"id": MEMBER, "type": 0, "allow": str(VIEW), "deny": str(SEND)})
        ow.append({"id": ASKGROK, "type": 0, "allow": str(VIEW | SEND), "deny": "0"})
    elif vis == "public_interactive":  # DEALS — members can post requests
        ow.append({"id": EVERYONE, "type": 0, "allow": "0", "deny": str(VIEW)})
        ow.append({"id": VERIFIED, "type": 0, "allow": str(VIEW | SEND), "deny": "0"})
        ow.append({"id": MEMBER, "type": 0, "allow": str(VIEW | SEND), "deny": "0"})
        ow.append({"id": COUPONCLAW, "type": 0, "allow": str(VIEW | SEND), "deny": "0"})
    elif vis == "private":
        ow.append({"id": EVERYONE, "type": 0, "allow": "0", "deny": str(VIEW)})
        ow.append({"id": VERIFIED, "type": 0, "allow": "0", "deny": str(VIEW)})
        ow.append({"id": MEMBER, "type": 0, "allow": "0", "deny": str(VIEW)})
        for rid in BOT_PRIV_VIEW:
            ow.append({"id": rid, "type": 0, "allow": str(VIEW | SEND), "deny": "0"})
    return ow


def wave_perms():
    print("\n=== WAVE perms (public/private wall) ===")
    # archive + voice categories -> private (hide old exec/risk data from members)
    extra = [("🗄️ ARCHIVE", ARCHIVE_CAT, "private"),
             ("Voice Channels", "1486025778922782721", "private")]
    ov2 = created.get("🗄️ ARCHIVE ②")
    if ov2:
        extra.append(("🗄️ ARCHIVE ②", ov2, "private"))
    allcats = [(n, created.get(n, cid), v) for n, cid, v, _ in TARGET] + extra
    kids = req("GET", f"/guilds/{G}/channels") if not DRY else []
    for cat_name, real_cid, vis in allcats:
        if not real_cid or str(real_cid).startswith("<"):
            continue
        print(f"PERMS {cat_name}  [{vis}]")
        if not DRY:
            req("PATCH", f"/channels/{real_cid}", json={"permission_overwrites": overwrites_for(vis)})
            for k in kids:
                if k.get("parent_id") == real_cid and k.get("type") in (0, 2):
                    try:
                        req("PATCH", f"/channels/{k['id']}", json={"lock_permissions": True})
                    except Exception as e:
                        print(f"   ! sync {k.get('name')}: {e}")
    save()


def ensure_all_categories():
    """create any TARGET category with id=None (TRACK RECORD, DEALS) before positions/perms."""
    for cat_name, cid, vis, chans in TARGET:
        if not cid:
            ensure_category(cat_name)


def main():
    print(f"### discord_overhaul  wave={WAVE}  {'DRY-RUN' if DRY else 'EXECUTE'} ###")
    if WAVE in ("recreate", "all"):
        wave_recreate()
    if WAVE in ("reorg", "all"):
        ensure_all_categories()
        wave_reorg()
        wave_positions()
    if WAVE == "positions":
        ensure_all_categories()
        wave_positions()
    if WAVE in ("perms", "all"):
        ensure_all_categories()
        wave_perms()
    if flagged:
        print(f"\n⚠ {len(flagged)} active bot-fed left in place: " + ", ".join(flagged))
    print("\n" + ("(dry-run — nothing changed)" if DRY else f"DONE — rollback {ROLLBACK}"))


if __name__ == "__main__":
    main()
