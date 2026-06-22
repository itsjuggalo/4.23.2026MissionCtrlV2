#!/usr/bin/env python3
"""
discord_build_feeder_map.py — channel -> feeder(s) + liveness, for the audit.

  1. Collect every Discord webhook URL referenced (secret files + inline code dicts).
  2. Resolve each via UNAUTHENTICATED GET /webhooks/{id}/{token} -> channel_id (paced).
  3. ONE bulk grep of all channel ids over tight, filtered source dirs.
  4. crontab -l + pm2 jlist for cron-feed lines and live Discord PM2 procs.

Writes -> ~/.openclaw/workspace/state/discord_feeder_map.json
Run AFTER discord_gather_dump.py.
"""
import re, json, subprocess, time
from pathlib import Path
import requests

HOME = Path.home()
DUMP = HOME / ".openclaw/workspace/state/discord_full_dump.json"
OUT = HOME / ".openclaw/workspace/state/discord_feeder_map.json"
SECRETS = HOME / ".openclaw/secrets"
# tight dirs that actually hold feeders (no full ~/trading or ~/01_ACTIVE tree walks)
SEARCH_DIRS = [str(p) for p in [
    HOME / "scripts", HOME / "05_AUTOMATION/scripts", HOME / "cron",
    HOME / "firebase-signals", HOME / "trading/daemons",
    HOME / "trading/signals/option-scraper",
    HOME / "01_ACTIVE/sites/missioncontrol/MissionCtrlV2/Option-Signals-Scraper",
] if p.exists()]
GREP_FLAGS = ["--include=*.py", "--include=*.sh", "--include=*.json",
              "--include=*.txt", "--include=*.js", "--include=*.cjs",
              "--exclude-dir=.git", "--exclude-dir=node_modules",
              "--exclude-dir=.venv", "--exclude-dir=venv",
              "--exclude-dir=__pycache__", "--exclude-dir=.next",
              "--exclude-dir=data", "--exclude-dir=logs"]
WEBHOOK_RE = re.compile(r"discord(?:app)?\.com/api/(?:v\d+/)?webhooks/(\d+)/([A-Za-z0-9_.\-]+)")

chans = json.loads(DUMP.read_text())["channels"]
by_id = {c["id"]: c for c in chans}

# ── 1. collect webhook URLs ─────────────────────────────────────────────────────
hooks = {}
def add(url, label):
    m = WEBHOOK_RE.search(url or "")
    if m: hooks.setdefault((m.group(1), m.group(2)), set()).add(label)

j = SECRETS / "option_relay_webhooks.json"
if j.exists():
    try:
        for k, v in json.loads(j.read_text()).items():
            if isinstance(v, str): add(v, f"option_relay:{k}")
    except Exception: pass
for f in list(SECRETS.glob("*webhook*")) + list(SECRETS.glob("discord*")):
    try:
        t = f.read_text()
        if "webhooks/" in t: add(t, f"secretfile:{f.name}")
    except Exception: pass
try:
    g = subprocess.run(["grep", "-rhoE", *GREP_FLAGS, WEBHOOK_RE.pattern, *SEARCH_DIRS],
                       capture_output=True, text=True, timeout=60).stdout
    for line in g.splitlines(): add(line, "code-inline")
except Exception as e:
    print("inline grep skipped:", e)

print(f"collected {len(hooks)} unique webhooks; resolving (paced)…")

# ── 2. resolve webhook -> channel_id (unauthenticated, paced) ───────────────────
wh_to_chan = {}
UA = {"User-Agent": "Mozilla/5.0"}
for i, ((wid, tok), labels) in enumerate(hooks.items(), 1):
    try:
        r = requests.get(f"https://discord.com/api/v10/webhooks/{wid}/{tok}", headers=UA, timeout=20)
        if r.status_code == 429:
            time.sleep(float(r.headers.get("Retry-After", 2)) + 0.5)
            r = requests.get(f"https://discord.com/api/v10/webhooks/{wid}/{tok}", headers=UA, timeout=20)
        if r.ok:
            cid = r.json().get("channel_id")
            if cid: wh_to_chan.setdefault(cid, set()).update(labels)
    except Exception: pass
    time.sleep(0.3)
    if i % 25 == 0: print(f"  resolved {i}/{len(hooks)}")
print(f"  {len(wh_to_chan)} channels mapped via webhook")

# ── 3. ONE bulk grep of all channel ids (file:match) ───────────────────────────
ids = list(by_id)
alt = "|".join(ids)
id_to_files = {cid: set() for cid in ids}
try:
    out = subprocess.run(["grep", "-rEoH", *GREP_FLAGS, alt, *SEARCH_DIRS,
                          str(SECRETS)], capture_output=True, text=True, timeout=120).stdout
    for line in out.splitlines():
        # format: path:matchedid
        path, _, mid = line.rpartition(":")
        if mid in id_to_files:
            id_to_files[mid].add(path.replace(str(HOME), "~"))
except Exception as e:
    print("bulk id grep skipped:", e)

# ── 4. crontab + pm2 ───────────────────────────────────────────────────────────
try: cron = subprocess.run(["crontab", "-l"], capture_output=True, text=True).stdout
except Exception: cron = ""
cron_lines = [l for l in cron.splitlines()
              if l.strip() and not l.strip().startswith("#")
              and ("discord" in l.lower())]
try:
    pm2 = json.loads(subprocess.run(["pm2", "jlist"], capture_output=True, text=True).stdout or "[]")
    pm2_online = sorted(p["name"] for p in pm2 if p.get("pm2_env", {}).get("status") == "online")
except Exception: pm2_online = []

# ── 5. assemble ────────────────────────────────────────────────────────────────
out = {"pm2_online": pm2_online, "discord_cron_count": len(cron_lines),
       "discord_cron_lines": cron_lines, "channels": {}}
for cid, c in by_id.items():
    nm = c["name"]
    cl = [l for l in cron_lines if re.search(rf"(?<![\w-]){re.escape(nm)}(?![\w-])", l)]
    out["channels"][cid] = {
        "name": nm,
        "webhook_feeders": sorted(wh_to_chan.get(cid, [])),
        "id_refs": sorted(id_to_files.get(cid, []))[:6],
        "cron_lines": cl,
    }

OUT.write_text(json.dumps(out, indent=2))
wired = sum(1 for v in out["channels"].values()
            if v["webhook_feeders"] or v["id_refs"] or v["cron_lines"])
print(f"\nwrote {OUT}")
print(f"  {wired}/{len(by_id)} channels have a discoverable feeder")
print("  discord PM2 online: " + ", ".join(
    p for p in pm2_online if any(k in p for k in
    ('discord','option','fcm','aime','firebase','relay'))))
