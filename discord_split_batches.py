#!/usr/bin/env python3
"""
discord_split_batches.py — merge dump + feeder map, split into per-batch input
files for the judge subagents. Each agent reads ONE small self-contained file.

Writes -> ~/.openclaw/workspace/state/audit_batches/batch_NN.json  (+ index.json)
Run AFTER gather + feeder map.
"""
import json, math
from pathlib import Path

ST = Path.home() / ".openclaw/workspace/state"
dump = {c["id"]: c for c in json.loads((ST / "discord_full_dump.json").read_text())["channels"]}
fm = json.loads((ST / "discord_feeder_map.json").read_text())
feed = fm["channels"]

BATCH = 11
OUT = ST / "audit_batches"
OUT.mkdir(exist_ok=True)
for old in OUT.glob("batch_*.json"):
    old.unlink()

merged = []
for cid, c in dump.items():
    f = feed.get(cid, {})
    merged.append({
        "id": cid, "name": c["name"], "cat": c.get("cat"), "topic": c.get("topic"),
        "last_activity": c.get("last_activity"),
        "total_100": c.get("total_100"), "human_msgs": c.get("human_msgs"),
        "spacer_msgs": c.get("spacer_msgs"), "top_authors": c.get("top_authors"),
        "samples": c.get("samples"),
        "feeder": {
            "webhook_feeders": f.get("webhook_feeders", []),
            "id_refs": f.get("id_refs", []),
            "cron_lines": f.get("cron_lines", []),
        },
    })

merged.sort(key=lambda x: (x.get("cat") or "", x["name"]))
n = math.ceil(len(merged) / BATCH)
index = []
for i in range(n):
    chunk = merged[i * BATCH:(i + 1) * BATCH]
    p = OUT / f"batch_{i:02d}.json"
    p.write_text(json.dumps({
        "today": "2026-06-21",
        "pm2_online": fm.get("pm2_online", []),
        "channels": chunk,
    }, indent=2))
    index.append({"batch": i, "file": str(p), "count": len(chunk),
                  "names": [c["name"] for c in chunk]})

(OUT / "index.json").write_text(json.dumps(index, indent=2))
print(f"{len(merged)} channels -> {n} batches in {OUT}")
for ix in index:
    print(f"  batch_{ix['batch']:02d}: {ix['count']} ch")
