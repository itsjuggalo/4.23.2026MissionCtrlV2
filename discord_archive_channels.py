#!/usr/bin/env python3
"""
discord_archive_channels.py — reversibly move dead channels into 🗄️ ARCHIVE.

Condense the guild for scrolling by moving the audited zero-real-content channels
under the collapsed ARCHIVE category (NOT delete — fully reversible via rollback).

Uses a bot token with MANAGE_CHANNELS (discord_ops_bot_token). Dry-run by default.

Usage:
  python3 discord_archive_channels.py            # DRY RUN (prints plan, no change)
  python3 discord_archive_channels.py --go       # execute + write rollback
  python3 discord_archive_channels.py --rollback # restore from last rollback file
"""
import sys, json, time
from pathlib import Path
import requests

SECRETS = Path.home() / ".openclaw/secrets"
TOKEN = (SECRETS / "discord_ops_bot_token").read_text().strip()
GUILD = "1486025777970548908"
ARCHIVE_CAT = "1518432389850726412"   # 🗄️ ARCHIVE ② (🗄️ ARCHIVE is full at the 50-channel cap)
ROLLBACK = Path.home() / ".openclaw/secrets/.discord-archive-rollback.json"
API = "https://discord.com/api/v10"
HDR = {"Authorization": f"Bot {TOKEN}",
       "User-Agent": "DiscordBot (https://missionctrl.local, 1.0)",
       "Content-Type": "application/json"}

# Tier A — audited zero real content (SPACER_ONLY or DEAD_empty), live, not feature-pending.
TIER_A = {
    "analyst-research":   "1486045602650521630",
    "macro-sentiment":    "1486045619050123365",
    "live-executions":    "1486045624691331185",
    "execution-history":  "1486045627409502251",
    "agent-comms":        "1490521532269727815",
    "synthetic-analysis": "1497723005026177186",
    "paper-trades":       "1497766926338752592",
    "backtest":           "1497767009189105836",
    "squeeze-alerts":     "1498022103906254879",
    "massage-bookings":   "1516907176281772194",
}


def _req(method, path, **kw):
    for _ in range(5):
        r = requests.request(method, API + path, headers=HDR, timeout=30, **kw)
        if r.status_code == 429:
            time.sleep(float(r.headers.get("Retry-After", 2)) + 0.5); continue
        r.raise_for_status()
        time.sleep(0.4)
        return r.json() if r.text else {}
    raise SystemExit("rate-limited repeatedly")


def do_rollback():
    if not ROLLBACK.exists():
        sys.exit("no rollback file")
    data = json.loads(ROLLBACK.read_text())
    for name, info in data.items():
        print(f"restore #{name} → parent {info['old_parent']}")
        _req("PATCH", f"/channels/{info['id']}",
             json={"parent_id": info["old_parent"]})
    print(f"restored {len(data)} channels")


def main():
    go = "--go" in sys.argv
    if "--rollback" in sys.argv:
        return do_rollback()
    # read current parents for rollback
    chans = {c["id"]: c for c in _req("GET", f"/guilds/{GUILD}/channels")}
    rollback = {}
    print(f"{'EXECUTE' if go else 'DRY RUN'} — move {len(TIER_A)} channels → 🗄️ ARCHIVE\n")
    for name, cid in TIER_A.items():
        cur = chans.get(cid)
        if not cur:
            print(f"  ?? #{name} ({cid}) not found — skip"); continue
        old = cur.get("parent_id")
        if old == ARCHIVE_CAT:
            print(f"  ✓ #{name} already in ARCHIVE — skip"); continue
        rollback[name] = {"id": cid, "old_parent": old}
        if go:
            _req("PATCH", f"/channels/{cid}", json={"parent_id": ARCHIVE_CAT})
            print(f"  → moved #{name}")
        else:
            print(f"  would move #{name:<22} (from parent {old})")
    if go and rollback:
        ROLLBACK.write_text(json.dumps(rollback, indent=2))
        print(f"\nrollback written → {ROLLBACK}")
        print("undo with: python3 discord_archive_channels.py --rollback")
    elif not go:
        print(f"\n(dry run — nothing changed. add --go to execute)")


if __name__ == "__main__":
    main()
