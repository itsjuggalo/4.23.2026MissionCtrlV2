#!/usr/bin/env python3
"""Synthesize the judge verdicts + dump into DISCORD-CHANNEL-FULL-AUDIT.md."""
import json, glob, os
from collections import Counter, defaultdict
from pathlib import Path

HOME = Path.home()
OUTF = sorted(glob.glob(str(HOME / ".claude/projects/*/tasks/w6usg94ip.output")) +
              glob.glob("/tmp/claude-1000/-home-itsju-restructure/*/tasks/w6usg94ip.output"))
res = json.load(open(OUTF[-1]))["result"]
verdicts = res["verdicts"]
dump = {c["id"]: c for c in json.loads(
    (HOME / ".openclaw/workspace/state/discord_full_dump.json").read_text())["channels"]}

for v in verdicts:
    d = dump.get(v["id"], {})
    v["cat"] = d.get("cat", "?")
    v["last"] = (d.get("last_activity") or "—")[:10]
    v["sp"] = d.get("spacer_msgs"); v["hu"] = d.get("human_msgs"); v["tot"] = d.get("total_100")
    v["archived"] = "ARCHIVE" in (v["cat"] or "")

RECO_ORDER = {"REMOVE": 0, "MERGE": 1, "FIX": 2, "KEEP": 3}
verdicts.sort(key=lambda v: (RECO_ORDER.get(v["recommendation"], 9), v["cat"] or "", v["name"]))

reco = Counter(v["recommendation"] for v in verdicts)
status = Counter(v["status"] for v in verdicts)
def short(s, n=90): return (s or "").replace("\n", " ").replace("|", "/")[:n]

L = []
L.append("# Discord Channel Full Audit — stale vs current (2026-06-21)\n")
L.append(f"Every channel ({len(verdicts)}) in guild `1486025777970548908` judged on content "
         "(last ~12 msgs), feeder, and feeder liveness. **Report only — nothing changed.**\n")
L.append("Evidence dumps: `~/.openclaw/workspace/state/discord_full_dump.json` + `discord_feeder_map.json`. "
         "Re-run: `discord_gather_dump.py` → `discord_build_feeder_map.py` → `discord_split_batches.py` → workflow.\n")
L.append("## Scoreboard")
L.append(f"- **Recommendation:** REMOVE {reco['REMOVE']} · MERGE {reco['MERGE']} · FIX {reco['FIX']} · KEEP {reco['KEEP']}")
L.append(f"- **Status:** " + " · ".join(f"{k} {status[k]}" for k in
         ["CURRENT","STALE","BROKEN","DEAD","REDUNDANT"] if status.get(k)))
L.append("")

def table(items, action_detail=True):
    rows = ["| channel | cat | status | feeder (live) | evidence → action |",
            "|---|---|---|---|---|"]
    for v in items:
        cat = (v["cat"] or "?").split(" ", 1)[-1][:14]
        arc = "🗄️" if v["archived"] else ""
        fl = {"yes": "🟢", "no": "🔴", "unknown": "❔"}.get(v.get("feeder_live"), "")
        ev = short(v["evidence"], 110)
        det = short(v["detail"], 110)
        cell = f"{ev}<br>**→ {det}**" if action_detail else ev
        rows.append(f"| {arc}#{v['name']} | {cat} | {v['status']} | {fl} {short(v['feeder'],42)} | {cell} |")
    return "\n".join(rows)

for bucket, head in [("REMOVE", "🔴 REMOVE — dead / never used / feed never lands here"),
                     ("MERGE", "🟠 MERGE — redundant, fold into another channel"),
                     ("FIX", "🟡 FIX — wanted but stale/broken; repair the feeder")]:
    items = [v for v in verdicts if v["recommendation"] == bucket]
    L.append(f"## {head}  ({len(items)})")
    if bucket == "REMOVE":
        live = [v for v in items if not v["archived"]]
        arch = [v for v in items if v["archived"]]
        if live:
            ids = " ".join(v["id"] for v in live)
            L.append(f"_{len(live)} are still LIVE (archive = reversible). {len(arch)} already archived (permanent-delete candidates)._")
            L.append("```bash")
            L.append("# reversibly archive the LIVE dead ones (edit the archiver's TIER_A or pass these ids):")
            L.append(f"# live REMOVE ids: {ids}")
            L.append("```")
    L.append(table(items))
    L.append("")

L.append("## 🟢 KEEP — healthy, current feeds")
keep = [v for v in verdicts if v["recommendation"] == "KEEP"]
L.append(table(keep, action_detail=False))
L.append("")

L.append("## Full master table (all 132, by recommendation → category)")
L.append("| # | channel | category | status | reco | feeder_live |")
L.append("|---|---|---|---|---|---|")
for i, v in enumerate(verdicts, 1):
    arc = "🗄️" if v["archived"] else ""
    L.append(f"| {i} | {arc}#{v['name']} | {short(v['cat'],22)} | {v['status']} | "
             f"{v['recommendation']} | {v.get('feeder_live')} |")
L.append("")
L.append(f"_Reconciliation: {len(verdicts)} rows = "
         f"{reco['REMOVE']} REMOVE + {reco['MERGE']} MERGE + {reco['FIX']} FIX + {reco['KEEP']} KEEP._")

out = HOME / "restructure/DISCORD-CHANNEL-FULL-AUDIT.md"
out.write_text("\n".join(L))
print("wrote", out, f"({out.stat().st_size} bytes)")
print("REMOVE", reco['REMOVE'], "MERGE", reco['MERGE'], "FIX", reco['FIX'], "KEEP", reco['KEEP'])
print("\nLIVE REMOVE/MERGE candidates (not yet archived):")
for v in verdicts:
    if v["recommendation"] in ("REMOVE","MERGE") and not v["archived"]:
        print(f"  {v['recommendation']:<7} #{v['name']:<22} {v['status']:<10} {short(v['detail'],70)}")
