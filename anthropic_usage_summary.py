#!/usr/bin/env python3
"""
anthropic_usage_summary — aggregates today's API calls and posts to Discord.

Runs nightly at 11:55 PM ET via cron (just before spacer).
Reads ~/.openclaw/data/anthropic_usage/{today}.jsonl
Posts breakdown to #anthropic-usage Discord channel (or BobaTrades fallback).
"""
import json
import requests
from collections import defaultdict
from datetime import datetime, timezone, timedelta
from pathlib import Path

DATA_DIR = Path.home() / ".openclaw" / "data" / "anthropic_usage"
SECRETS = Path.home() / ".openclaw" / "secrets"
HEADERS = {"Content-Type": "application/json", "User-Agent": "MissionControl-UsageSummary/1.0"}

def et_now():
    return datetime.now(timezone.utc) + timedelta(hours=-4)

def load_today():
    fp = DATA_DIR / f"{et_now().strftime('%Y-%m-%d')}.jsonl"
    if not fp.exists():
        return []
    entries = []
    for line in fp.read_text().splitlines():
        line = line.strip()
        if not line: continue
        try:
            entries.append(json.loads(line))
        except: pass
    return entries

def aggregate(entries):
    by_caller = defaultdict(lambda: {"calls": 0, "cost": 0.0, "in_tok": 0,
                                      "out_tok": 0, "cache_read": 0,
                                      "cache_create": 0, "fails": 0})
    by_model = defaultdict(lambda: {"calls": 0, "cost": 0.0})
    total = {"calls": 0, "cost": 0.0, "in_tok": 0, "out_tok": 0,
             "cache_read": 0, "cache_create": 0, "fails": 0}
    for e in entries:
        c = e.get("caller", "unknown")
        m = e.get("model", "unknown")
        cost = e.get("cost_usd", 0)
        by_caller[c]["calls"] += 1
        by_caller[c]["cost"] += cost
        by_caller[c]["in_tok"] += e.get("input_tokens", 0)
        by_caller[c]["out_tok"] += e.get("output_tokens", 0)
        by_caller[c]["cache_read"] += e.get("cache_read_tokens", 0)
        by_caller[c]["cache_create"] += e.get("cache_creation_tokens", 0)
        if not e.get("success", True):
            by_caller[c]["fails"] += 1
        by_model[m]["calls"] += 1
        by_model[m]["cost"] += cost
        total["calls"] += 1
        total["cost"] += cost
        total["in_tok"] += e.get("input_tokens", 0)
        total["out_tok"] += e.get("output_tokens", 0)
        total["cache_read"] += e.get("cache_read_tokens", 0)
        total["cache_create"] += e.get("cache_creation_tokens", 0)
        if not e.get("success", True):
            total["fails"] += 1
    return total, by_caller, by_model

def format_summary(total, by_caller, by_model):
    et = et_now()
    date = et.strftime("%a %b %-d %Y")
    lines = [f"📊 **Anthropic Usage — {date}**"]
    lines.append(f"```")
    lines.append(f"Total calls: {total['calls']}  fails: {total['fails']}")
    lines.append(f"Cost today:  ${total['cost']:.2f}")
    lines.append(f"Input:  {total['in_tok']:,} tok")
    lines.append(f"Output: {total['out_tok']:,} tok")
    if total['cache_read'] or total['cache_create']:
        lines.append(f"Cache:  read {total['cache_read']:,} write {total['cache_create']:,}")
    lines.append(f"")
    lines.append(f"By caller (top 8):")
    sorted_callers = sorted(by_caller.items(), key=lambda x: -x[1]["cost"])[:8]
    for name, d in sorted_callers:
        pct = (d["cost"] / total["cost"] * 100) if total["cost"] > 0 else 0
        lines.append(f"  {name:25s} {d['calls']:>4}c ${d['cost']:>7.3f} ({pct:>4.1f}%)")
    lines.append(f"")
    lines.append(f"By model:")
    for name, d in sorted(by_model.items(), key=lambda x: -x[1]["cost"]):
        lines.append(f"  {name:30s} {d['calls']:>4}c ${d['cost']:>7.3f}")
    # 30-day projection at this rate
    monthly = total["cost"] * 22  # ~22 weekdays
    lines.append(f"")
    lines.append(f"At today's rate: ~${monthly:.0f}/mo (22 weekdays)")
    lines.append(f"```")
    return "\n".join(lines)

def post_discord(content):
    # Try dedicated channel first, fall back to bobatrades
    for fname in ["discord_anthropic_usage_webhook", "discord_bobatrades_webhook"]:
        fp = SECRETS / fname
        if fp.exists():
            url = fp.read_text().strip()
            try:
                r = requests.post(url, headers=HEADERS, json={"content": content[:1900]}, timeout=10)
                if r.status_code == 204:
                    return True
            except Exception:
                pass
    return False

def main():
    entries = load_today()
    if not entries:
        post_discord(f"📊 **Anthropic Usage — {et_now().strftime('%a %b %-d')}**\nNo API calls logged today.")
        return
    total, by_caller, by_model = aggregate(entries)
    summary = format_summary(total, by_caller, by_model)
    print(summary)
    post_discord(summary)

if __name__ == "__main__":
    main()
