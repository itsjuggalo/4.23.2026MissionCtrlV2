#!/usr/bin/env python3
"""
discord_build_feeder_map.py — channel -> feeder(s) + liveness, for the audit.

Method (per approved plan):
  1. Collect every Discord webhook URL referenced anywhere (secret files + inline dicts).
  2. Resolve each via UNAUTHENTICATED GET /webhooks/{id}/{token} -> channel_id (paced).
     (No user-token automation; webhook-info needs no auth.)
  3. Grep the codebase for each channel's *id* (unique) to catch hardcoded refs.
  4. crontab -l + pm2 jlist for cron-feed lines and which Discord PM2 procs are online.

Writes -> ~/.openclaw/workspace/state/discord_feeder_map.json  (keyed by channel id)
Run AFTER discord_gather_dump.py (reads the dump for the channel list).
"""
import re, json, subprocess, time
from pathlib import Path
import requests

HOME = Path.home()
DUMP = HOME / ".openclaw/workspace/state/discord_full_dump.json"
OUT = HOME / ".openclaw/workspace/state/discord_feeder_map.json"
SECRETS = HOME / ".openclaw/secrets"
SEARCH_DIRS = [str(HOME / d) for d in
               ("scripts", "05_AUTOMATION/scripts", "cron", "trading",
                "01_ACTIVE", "firebase-signals")]
WEBHOOK_RE = re.compile(r"discord(?:app)?\.com/api/(?:v\d+/)?webhooks/(\d+)/([A-Za-z0-9_.\-]+)")

chans = json.loads(DUMP.read_text())["channels"]
by_id = {c["id"]: c for c in chans}
names = {c["id"]: c["name"] for c in chans}

# ── 1. collect webhook URLs (with a source label) ──────────────────────────────
hooks = {}   # (id,token) -> set(source labels)
def add(url, label):
    m = WEBHOOK_RE.search(url)
    if m:
        hooks.setdefault((m.group(1), m.group(2)), set()).add(label)

# labeled JSON registry
j = SECRETS / "option_relay_webhooks.json"
if j.exists():
    try:
        for k, v in json.loads(j.read_text()).items():
            if isinstance(v, str): add(v, f"option_relay:{k}")
    except Exception: pass
# per-channel secret files
for f in SECRETS.glob("*webhook*"):
    try: add(f.read_text(), f"secretfile:{f.name}")
    except Exception: pass
for f in SECRETS.glob("discord*"):
    try:
        t = f.read_text()
        if "webhooks/" in t: add(t, f"secretfile:{f.name}")
    except Exception: pass
# catch-all grep of inline dicts in code
try:
    g = subprocess.run(["grep", "-rhoE", WEBHOOK_RE.pattern, *SEARCH_DIRS],
                       capture_output=True, text=True, timeout=60).stdout
    for line in g.splitlines(): add(line, "code-inline")
except Exception: pass

print(f"collected {len(hooks)} unique webhooks; resolving (paced)…")

# ── 2. resolve webhook -> channel_id (unauthenticated, paced) ───────────────────
wh_to_chan = {}
UA = {"User-Agent": "Mozilla/5.0"}
for i, ((wid, tok), labels) in enumerate(hooks.items(), 1):
    try:
        r = requests.get(f"https://discord.com/api/v10/webhooks/{wid}/{tok}",
                         headers=UA, timeout=20)
        if r.status_code == 429:
            time.sleep(float(r.headers.get("Retry-After", 2)) + 0.5)
            r = requests.get(f"https://discord.com/api/v10/webhooks/{wid}/{tok}",
                             headers=UA, timeout=20)
        if r.ok:
            cid = r.json().get("channel_id")
            if cid: wh_to_chan.setdefault(cid, set()).update(labels)
    except Exception:
        pass
    time.sleep(0.35)
    if i % 25 == 0: print(f"  resolved {i}/{len(hooks)}")

# ── 3. grep each channel id across the codebase ────────────────────────────────
def id_refs(cid):
    try:
        r = subprocess.run(["grep", "-rlF", cid, *SEARCH_DIRS,
                            str(SECRETS)], capture_output=True, text=True, timeout=40)
        return [p.replace(str(HOME), "~") for p in r.stdout.split()][:6]
    except Exception:
        return []

# ── 4. crontab + pm2 ───────────────────────────────────────────────────────────
try:
    cron = subprocess.run(["crontab", "-l"], capture_output=True, text=True).stdout
except Exception:
    cron = ""
cron_lines = [l for l in cron.splitlines() if "discord" in l.lower() or "to_discord" in l.lower()]
try:
    pm2 = json.loads(subprocess.run(["pm2", "jlist"], capture_output=True, text=True).stdout or "[]")
    pm2_online = sorted(p["name"] for p in pm2 if p.get("pm2_env", {}).get("status") == "online")
except Exception:
    pm2_online = []

# ── 5. assemble ────────────────────────────────────────────────────────────────
out = {"pm2_online": pm2_online, "discord_cron_count": len(cron_lines),
       "discord_cron_lines": cron_lines, "channels": {}}
for cid, c in by_id.items():
    nm = c["name"]
    refs = id_refs(cid)
    # crontab lines naming this channel (word-ish boundary)
    cl = [l for l in cron_lines if re.search(rf"(?<![\w-]){re.escape(nm)}(?![\w-])", l)]
    out["channels"][cid] = {
        "name": nm,
        "webhook_feeders": sorted(wh_to_chan.get(cid, [])),
        "id_refs": refs,
        "cron_lines": cl,
    }

OUT.write_text(json.dumps(out, indent=2))
wired = sum(1 for v in out["channels"].values()
            if v["webhook_feeders"] or v["id_refs"] or v["cron_lines"])
print(f"\nwrote {OUT}")
print(f"  {len(wh_to_chan)} channels have a resolved webhook feed")
print(f"  {wired}/{len(by_id)} channels have SOME discoverable feeder")
print(f"  pm2 online (discord-ish): " +
      ", ".join(p for p in pm2_online if any(k in p for k in
               ('discord','option','fcm','aime','firebase','relay'))))
