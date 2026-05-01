#!/usr/bin/env python3
"""
Shared flow channel reader — any agent can import this to get recent flow context.

Reads last N messages from flow-messages, flow-wins, fg1/fg2 sentiment.
60-second per-channel cache to avoid Discord rate limits when multiple agents call this.

Usage:
    from lib.flow_channel_reader import get_recent_flow_context
    ctx = get_recent_flow_context(agent_token_file="discord_orion_token", lookback_min=30)
    # ctx is dict with: flow_messages, flow_wins, fg1, fg2 each = list of {ts, content, tier}
"""
import requests, json, re, time
from pathlib import Path
from datetime import datetime, timezone, timedelta

SECRETS = Path("/home/ubuntu/.openclaw/secrets")
CACHE_DIR = Path("/home/ubuntu/.openclaw/workspace/cache/flow_channels")
CACHE_DIR.mkdir(parents=True, exist_ok=True)
CACHE_TTL_SEC = 60

CHANNELS = {
    "flow_messages": "1497628864854102076",
    "flow_wins":     "1497661296630304839",
    "fg1":           "1497684473838436534",
    "fg2":           "1497684436538359940",
}

# Tier detection — match T0 ($10M+), T1 ($5M+), T2 ($1M+), T3 ($500K+), T4 ($100K+)
TIER_KEYWORDS = {
    "T0": [r"\$10M", r"\$1[0-9]M", r"T0\b"],
    "T1": [r"\$5M", r"\$[5-9]M", r"T1\b", r"HUGE"],
    "T2": [r"\$1M", r"T2\b", r"UNUSUAL HUGE"],
    "T3": [r"\$500K", r"\$[5-9]00K", r"T3\b", r"UNUSUAL"],
    "T4": [r"\$100K", r"\$[1-4]00K", r"T4\b"],
}

def _detect_tier(content):
    for tier, patterns in TIER_KEYWORDS.items():
        for pat in patterns:
            if re.search(pat, content, re.I):
                return tier
    return None

def _read_token(token_file):
    p = SECRETS / token_file
    if not p.exists(): return None
    return p.read_text().strip()

def _fetch_channel(channel_id, token, limit=20):
    """Direct Discord API call — returns list of messages or [] on error."""
    cache_file = CACHE_DIR / f"{channel_id}.json"
    if cache_file.exists() and (time.time() - cache_file.stat().st_mtime < CACHE_TTL_SEC):
        try:
            return json.loads(cache_file.read_text())
        except: pass
    try:
        r = requests.get(
            f"https://discord.com/api/v10/channels/{channel_id}/messages?limit={limit}",
            headers={"Authorization": f"Bot {token}"}, timeout=10)
        if r.status_code != 200:
            return []
        msgs = r.json()
        cache_file.write_text(json.dumps(msgs))
        return msgs
    except Exception:
        return []

def get_recent_flow_context(agent_token_file="discord_boba_token", lookback_min=30, max_per_channel=15):
    """
    Returns {flow_messages: [...], flow_wins: [...], fg1: [...], fg2: [...]}
    Each list contains: {ts, content, tier, author}
    Filtered to last `lookback_min` minutes.
    """
    token = _read_token(agent_token_file)
    if not token:
        return {k: [] for k in CHANNELS.keys()}
    cutoff = datetime.now(timezone.utc) - timedelta(minutes=lookback_min)
    result = {}
    for cname, cid in CHANNELS.items():
        raw = _fetch_channel(cid, token, limit=max_per_channel)
        items = []
        for m in raw:
            try:
                ts = datetime.fromisoformat(m["timestamp"].replace("Z","+00:00"))
                if ts < cutoff: continue
                content = m.get("content","").strip()
                if not content and m.get("embeds"):
                    e = m["embeds"][0]
                    content = (e.get("title","") + " " + e.get("description","")).strip()
                if not content: continue
                items.append({
                    "ts": ts.isoformat(),
                    "content": content[:500],
                    "tier": _detect_tier(content),
                    "author": m.get("author",{}).get("username","?"),
                })
            except Exception:
                continue
        result[cname] = items
    return result

def format_for_prompt(ctx, max_show=8):
    """Format flow context as compact prompt-ready text."""
    lines = []
    for cname, items in ctx.items():
        if not items: continue
        lines.append(f"\n## {cname.replace('_',' ').upper()} (last {len(items)})")
        # Sort by tier severity (T0 > T1 > T2 > T3 > T4 > None)
        tier_order = {"T0":0,"T1":1,"T2":2,"T3":3,"T4":4,None:5}
        items_sorted = sorted(items, key=lambda x: tier_order.get(x.get("tier"), 5))
        for item in items_sorted[:max_show]:
            tier = item.get("tier") or "?"
            ts_short = item["ts"][11:16]  # HH:MM
            content = item["content"][:200].replace("\n", " ")
            lines.append(f"  [{tier}] {ts_short} {content}")
    return "\n".join(lines) if lines else "(no recent flow channel activity)"

if __name__ == "__main__":
    import sys
    token_file = sys.argv[1] if len(sys.argv) > 1 else "discord_boba_token"
    print(f"Testing with {token_file}...")
    ctx = get_recent_flow_context(agent_token_file=token_file, lookback_min=60)
    print(format_for_prompt(ctx))
