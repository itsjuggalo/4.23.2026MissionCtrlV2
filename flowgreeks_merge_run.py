#!/usr/bin/env python3
"""
flowgreeks_merge_run.py — merge 2 bot-fed FlowGreeks channels into survivors.

REVERSIBLE. Repoints webhook-URL producers (option_relay_webhooks.json + discord_poster.py)
to a webhook on the survivor channel, then archives the source channel (move, not delete).
Actor: discord_ops_bot_token (Administrator). Dry-run by default.

  python3 flowgreeks_merge_run.py            # DRY RUN
  python3 flowgreeks_merge_run.py --go       # EXECUTE + write rollback
  python3 flowgreeks_merge_run.py --rollback # restore from rollback file
"""
import sys, json, time, shutil
from pathlib import Path
import requests

DRY = ("--go" not in sys.argv) and ("--rollback" not in sys.argv)
ROLL = "--rollback" in sys.argv
SEC = Path.home() / ".openclaw/secrets"
TOKEN = (SEC / "discord_ops_bot_token").read_text().strip()
API = "https://discord.com/api/v10"
H = {"Authorization": f"Bot {TOKEN}",
     "User-Agent": "DiscordBot (https://missionctrl.local, 1.0)",
     "Content-Type": "application/json"}
ARCHIVE_CAT = "1518432389850726412"          # 🗄️ ARCHIVE ②
RELAY_WH = SEC / "option_relay_webhooks.json"
POSTER = Path.home() / "firebase-signals/discord_poster.py"
ROLLBACK = SEC / ".flowgreeks-merge-rollback.json"

MERGES = [
    {"name": "os-closed-stocks -> closed-trades", "source": "1497684381312090172",
     "survivor": "1493401432634691726", "relay_keys": ["os_closed_stocks"],
     "poster_edit": False, "label": "closed-trades"},
    {"name": "stock-longterm -> stock-signals", "source": "1493401397314719806",
     "survivor": "1493401353844818033", "relay_keys": ["long_term_stocks"],
     "poster_edit": True, "label": "stock-signals"},
]


def req(m, p, **kw):
    for _ in range(6):
        r = requests.request(m, API + p, headers=H, timeout=30, **kw)
        if r.status_code == 429:
            time.sleep(float(r.headers.get("Retry-After", 2)) + 0.5); continue
        return r
    raise RuntimeError("rate-limited")


def survivor_webhook(sid, label):
    whs = req("GET", f"/channels/{sid}/webhooks").json()
    if not isinstance(whs, list):
        raise RuntimeError(f"webhooks GET failed for {sid}: {whs}")
    wh = next((w for w in whs if isinstance(w, dict) and (w.get("name") or "").startswith("mc-")), None)
    if not wh:
        if DRY:
            return f"<DRY: would create mc-{label} on {sid}>", None
        wh = req("POST", f"/channels/{sid}/webhooks", json={"name": f"mc-{label}"}).json()
        time.sleep(0.4)
    return f"https://discord.com/api/webhooks/{wh['id']}/{wh['token']}", wh.get("id")


def do_rollback():
    rb = json.loads(ROLLBACK.read_text())
    # restore relay json + poster from .bak
    if Path(rb["relay_bak"]).exists():
        shutil.copy(rb["relay_bak"], RELAY_WH); print("restored", RELAY_WH)
    if rb.get("poster_bak") and Path(rb["poster_bak"]).exists():
        shutil.copy(rb["poster_bak"], POSTER); print("restored", POSTER)
    for cid, parent in rb["unarchive"].items():
        req("PATCH", f"/channels/{cid}", json={"parent_id": parent}); time.sleep(0.4)
        print("un-archived", cid, "->", parent)
    print("ROLLBACK done. Restart option-relay + fcm-discord to re-read.")


def main():
    if ROLL:
        do_rollback(); return

    print(f"=== flowgreeks merge {'DRY-RUN' if DRY else 'EXECUTE'} ===\n")
    relay = json.loads(RELAY_WH.read_text())
    poster_txt = POSTER.read_text()
    rollback = {"relay_bak": "", "poster_bak": "", "unarchive": {}, "repoints": {}}

    # backups
    if not DRY:
        rb_relay = str(RELAY_WH) + ".bak.premerge"
        shutil.copy(RELAY_WH, rb_relay); rollback["relay_bak"] = rb_relay
        rb_poster = str(POSTER) + ".bak.premerge"
        shutil.copy(POSTER, rb_poster); rollback["poster_bak"] = rb_poster

    for m in MERGES:
        print(f"MERGE {m['name']}")
        url, whid = survivor_webhook(m["survivor"], m["label"])
        print(f"   survivor webhook: {url[:60]}...  (id={whid})")
        # repoint relay keys
        for k in m["relay_keys"]:
            old = relay.get(k, "<missing>")
            rollback["repoints"][f"relay:{k}"] = old
            print(f"   relay[{k}]: {old[:45]}...  ->  survivor")
            if not DRY:
                relay[k] = url
        # repoint poster.py (string replace the old URL for this feed's webhook id)
        if m["poster_edit"]:
            old_url = relay.get(m["relay_keys"][0]) if DRY else rollback["repoints"][f"relay:{m['relay_keys'][0]}"]
            # find the long_term_stocks line in poster
            import re
            mt = re.search(r'"long_term_stocks":\s*"(https://[^"]+)"', poster_txt)
            if mt:
                old_poster_url = mt.group(1)
                print(f"   poster.py long_term_stocks: {old_poster_url[:45]}...  ->  survivor")
                rollback["repoints"]["poster:long_term_stocks"] = old_poster_url
                if not DRY:
                    poster_txt = poster_txt.replace(old_poster_url, url)
            else:
                print("   !! poster.py long_term_stocks line NOT found — manual check needed")
        # archive source channel
        ch = req("GET", f"/channels/{m['source']}").json()
        rollback["unarchive"][m["source"]] = ch.get("parent_id")
        print(f"   archive source #{ch.get('name')} (parent {ch.get('parent_id')} -> {ARCHIVE_CAT})")
        if not DRY:
            req("PATCH", f"/channels/{m['source']}",
                json={"parent_id": ARCHIVE_CAT, "lock_permissions": True}); time.sleep(0.4)
        print()

    if not DRY:
        RELAY_WH.write_text(json.dumps(relay, indent=2) + "\n")
        POSTER.write_text(poster_txt)
        ROLLBACK.write_text(json.dumps(rollback, indent=2))
        print(f"WROTE config + rollback {ROLLBACK}")
        print("NEXT: pm2 restart option-relay && pm2 restart fcm-discord, then verify.")
    else:
        print("DRY-RUN complete. Re-run with --go to execute.")


if __name__ == "__main__":
    main()
