#!/usr/bin/env python3
"""
discord_gather_dump.py — ONE paced pass that builds the full per-channel dump
for the stale/current analysis. Subagents read this dump (no API calls each).

Per channel: live category, activity, author tally (from audit), and a sample of
the last ~12 messages (author/bot/ts/text). Single connection, 429-aware, paced.

Writes → ~/.openclaw/workspace/state/discord_full_dump.json
"""
import sys, json
from pathlib import Path
sys.path.insert(0, str(Path.home() / "scripts"))
import discord_user as du

GUILD = "1486025777970548908"
AUDIT = Path.home() / ".openclaw/workspace/state/discord_channel_usage_audit.json"
OUT = Path.home() / ".openclaw/workspace/state/discord_full_dump.json"

audit = {c["id"]: c for c in json.load(open(AUDIT))["channels"]}

chans = du._req("GET", f"/guilds/{GUILD}/channels")
cats = {c["id"]: c["name"] for c in chans if c.get("type") == 4}
text = [c for c in chans if c.get("type") in (0, 5)]
print(f"{len(text)} channels — sampling last 12 msgs each…", file=sys.stderr)

out = []
for i, c in enumerate(text, 1):
    cid, name = c["id"], c.get("name", "?")
    cat = cats.get(c.get("parent_id") or "", "—uncategorized—")
    topic = c.get("topic") or ""
    try:
        msgs = du._req("GET", f"/channels/{cid}/messages?limit=12")
    except Exception as e:
        out.append({"id": cid, "name": name, "cat": cat, "error": str(e)})
        print(f"  [{i}/{len(text)}] #{name}: ERR {e}", file=sys.stderr)
        continue
    samples = []
    for m in msgs:
        a = m.get("author", {})
        who = a.get("global_name") or a.get("username", "?")
        is_bot = bool(a.get("bot")) or bool(m.get("webhook_id"))
        body = (m.get("content") or "").replace("\n", " ⏎ ")
        if not body and m.get("embeds"):
            e0 = m["embeds"][0]
            body = "[embed] " + (e0.get("title") or "") + " | " + (e0.get("description") or "")[:160]
        if not body and m.get("attachments"):
            body = f"[{len(m['attachments'])} attachment(s)]"
        samples.append({"ts": m.get("timestamp", "")[:19], "who": who,
                        "bot": is_bot, "text": body[:240]})
    au = audit.get(cid, {})
    out.append({
        "id": cid, "name": name, "cat": cat, "topic": topic[:160],
        "last_activity": au.get("newest") or (samples[0]["ts"] if samples else None),
        "total_100": au.get("total"), "human_msgs": au.get("human_msgs"),
        "spacer_msgs": au.get("spacer_msgs"), "top_authors": au.get("top_authors"),
        "verdict_usage": au.get("verdict"),
        "samples": samples,  # newest first
    })
    print(f"  [{i}/{len(text)}] #{name:<26} samples={len(samples)}", file=sys.stderr)

OUT.write_text(json.dumps({"guild": GUILD, "channels": out}, indent=2))
print(f"\nwrote {OUT}  ({len(out)} channels)", file=sys.stderr)
