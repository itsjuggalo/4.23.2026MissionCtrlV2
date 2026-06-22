#!/usr/bin/env python3
"""
discord_channel_usage_audit.py — read-only "who actually posts here?" audit.

Goal: find channels that are mainly just the Spacer day-divider banner (or other
bot-only / dead channels) so the guild can be condensed for easier scrolling.

Reuses Mike's user token + paced _req from discord_user.py (single connection,
429-aware, gentle pacing — ToS hygiene). Fetches the last N messages per text
channel, tallies author breakdown, classifies each channel.

Usage: python3 discord_channel_usage_audit.py <guild_id> [N_per_channel=100]
Writes JSON → ~/.openclaw/workspace/state/discord_channel_usage_audit.json
"""
import sys, os, json
from pathlib import Path
from collections import Counter

sys.path.insert(0, str(Path.home() / "scripts"))
import discord_user as du  # reuse _req (token + 429 backoff + pacing)

GUILD = sys.argv[1] if len(sys.argv) > 1 else "1486025777970548908"
N = int(sys.argv[2]) if len(sys.argv) > 2 else 100
OUT = Path.home() / ".openclaw/workspace/state/discord_channel_usage_audit.json"

# author names treated as "decorative / non-content" bots (channel-fillers)
SPACER_NAMES = {"spacer"}


def classify(stats):
    total = stats["total"]
    if total == 0:
        return "DEAD_empty"
    human = stats["human_msgs"]
    spacer = stats["spacer_msgs"]
    bot = stats["bot_msgs"]
    other_bot = bot - spacer  # non-spacer bot/app/webhook posts
    spacer_share = spacer / total if total else 0

    if human == 0 and other_bot == 0 and spacer > 0:
        return "SPACER_ONLY"          # nothing but day-divider banners → condense
    if human == 0 and spacer_share >= 0.6 and other_bot <= 2:
        return "SPACER_DOMINATED"     # almost all spacer, trivial other bot noise
    if human == 0 and bot > 0:
        return "BOT_FEED"             # live automated feed (real content), no humans
    if human <= 2:
        return "MOSTLY_BOT"           # tiny bit of human, mostly automated
    return "HUMAN_ACTIVE"


def main():
    chans = du._req("GET", f"/guilds/{GUILD}/channels")
    cats = {c["id"]: c["name"] for c in chans if c.get("type") == 4}
    text = [c for c in chans if c.get("type") in (0, 5)]  # text + announcement
    print(f"{len(text)} text channels across {len(cats)} categories — fetching last {N} each…",
          file=sys.stderr)

    results = []
    for i, c in enumerate(text, 1):
        cid, name = c["id"], c.get("name", "?")
        cat = cats.get(c.get("parent_id") or "", "—uncategorized—")
        try:
            msgs = du._req("GET", f"/channels/{cid}/messages?limit={N}")
        except SystemExit:
            raise
        except Exception as e:
            print(f"  [{i}/{len(text)}] #{name}: ERR {e}", file=sys.stderr)
            results.append({"cat": cat, "name": name, "id": cid, "error": str(e)})
            continue

        authors = Counter()
        bot_msgs = human_msgs = spacer_msgs = 0
        newest = oldest = None
        human_authors = set()
        for m in msgs:
            a = m.get("author", {})
            who = a.get("global_name") or a.get("username", "?")
            is_bot = bool(a.get("bot")) or m.get("webhook_id")
            authors[who] += 1
            if (a.get("username", "").lower() in SPACER_NAMES
                    or who.lower() in SPACER_NAMES):
                spacer_msgs += 1
            if is_bot:
                bot_msgs += 1
            else:
                human_msgs += 1
                human_authors.add(who)
            ts = m.get("timestamp", "")[:19]
            if ts:
                newest = max(newest, ts) if newest else ts
                oldest = min(oldest, ts) if oldest else ts

        stats = {
            "cat": cat, "name": name, "id": cid,
            "total": len(msgs), "bot_msgs": bot_msgs, "human_msgs": human_msgs,
            "spacer_msgs": spacer_msgs, "human_authors": len(human_authors),
            "newest": newest, "oldest": oldest,
            "top_authors": authors.most_common(4),
        }
        stats["verdict"] = classify(stats)
        results.append(stats)
        print(f"  [{i}/{len(text)}] {stats['verdict']:<16} #{name:<26} "
              f"tot={stats['total']:>3} hu={human_msgs:>3} sp={spacer_msgs:>3} "
              f"bot={bot_msgs:>3}", file=sys.stderr)

    OUT.write_text(json.dumps({"guild": GUILD, "n_per": N, "channels": results}, indent=2))
    print(f"\nwrote {OUT}", file=sys.stderr)

    # summary table to stdout
    order = {"SPACER_ONLY": 0, "SPACER_DOMINATED": 1, "DEAD_empty": 2,
             "MOSTLY_BOT": 3, "BOT_FEED": 4, "HUMAN_ACTIVE": 5}
    buckets = Counter(r.get("verdict", "error") for r in results)
    print("\n=== VERDICT COUNTS ===")
    for v, n in sorted(buckets.items(), key=lambda x: order.get(x[0], 9)):
        print(f"  {v:<18} {n}")


if __name__ == "__main__":
    main()
