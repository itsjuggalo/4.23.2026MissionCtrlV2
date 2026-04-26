#!/usr/bin/env python3
"""Signal discovery — find emerging high-quality TG signal channels.
Reads telegram-listener's signals.json + channel_stats.json to identify:
  - Channels with rising signal volume in last 24h
  - Channels with novel symbols not seen before  
  - Channels with high actionable-rate (entry+stop+TP all parsed)
Posts top 3 candidates to #signal-discovery via webhook.
"""
import json, os, time, requests
from pathlib import Path
from datetime import datetime, timezone, timedelta
from collections import defaultdict, Counter

SECRETS = Path.home() / ".openclaw" / "secrets"
WEBHOOK = (SECRETS / "discord_signal_discovery_webhook").read_text().strip()
LISTENER_DIR = Path.home() / "mission-control" / "telegram-listener"
SIGNALS_FILE = LISTENER_DIR / "signals.json"
STATS_FILE = LISTENER_DIR / "channel_stats.json"
STATE_FILE = Path.home() / ".openclaw" / "workspace" / "state" / "signal_discovery_state.json"
STATE_FILE.parent.mkdir(parents=True, exist_ok=True)

def load_state():
    if STATE_FILE.exists():
        try: return json.loads(STATE_FILE.read_text())
        except: pass
    return {"last_run": 0, "known_symbols": []}

def save_state(s):
    STATE_FILE.write_text(json.dumps(s))

def main():
    if not SIGNALS_FILE.exists():
        print("[discovery] signals.json missing, exiting")
        return
    signals = json.loads(SIGNALS_FILE.read_text())
    if not isinstance(signals, list) or not signals:
        print("[discovery] no signals to analyze")
        return

    state = load_state()
    known = set(state.get("known_symbols", []))
    now = time.time()
    cutoff_24h = (datetime.now(timezone.utc) - timedelta(hours=24)).isoformat()

    # Per-channel stats
    chan_stats = defaultdict(lambda: {"count_24h": 0, "actionable": 0, "novel_symbols": set(), "name": ""})
    new_symbols = set()

    for s in signals:
        ts = s.get("timestamp", "")
        if ts < cutoff_24h: continue
        cid = s.get("channel_id", "?")
        chan_stats[cid]["name"] = s.get("channel_name", "?")
        chan_stats[cid]["count_24h"] += 1
        # Actionable = entry + (stop or sl) + (target or tp) all present and non-empty
        if s.get("entry") and (s.get("stop") or s.get("sl")) and (s.get("target") or s.get("tp")):
            chan_stats[cid]["actionable"] += 1
        sym = s.get("symbol", "")
        if sym:
            if sym not in known:
                new_symbols.add(sym)
                chan_stats[cid]["novel_symbols"].add(sym)

    # Score each channel: weight count + actionable_rate + novel_count
    candidates = []
    for cid, st in chan_stats.items():
        if st["count_24h"] < 3: continue
        actionable_rate = st["actionable"] / st["count_24h"] if st["count_24h"] else 0
        score = st["count_24h"] + (st["actionable"] * 2) + (len(st["novel_symbols"]) * 3)
        candidates.append({
            "id": cid, "name": st["name"],
            "count": st["count_24h"],
            "actionable": st["actionable"],
            "actionable_rate": actionable_rate,
            "novel_count": len(st["novel_symbols"]),
            "novel_samples": list(st["novel_symbols"])[:5],
            "score": score,
        })
    candidates.sort(key=lambda x: x["score"], reverse=True)
    top = candidates[:3]

    # Post embed
    if not top:
        print("[discovery] no qualifying channels (need ≥3 signals/24h)")
        save_state({"last_run": int(now), "known_symbols": list(known | new_symbols)[:5000]})
        return

    fields = []
    for c in top:
        v = (f"**Volume**: {c['count']} signals/24h\n"
             f"**Actionable**: {c['actionable']} ({c['actionable_rate']*100:.0f}%)\n"
             f"**New symbols**: {c['novel_count']}")
        if c["novel_samples"]:
            v += f"\n_{', '.join(c['novel_samples'])}_"
        fields.append({"name": f"📡 {c['name'][:80]}", "value": v[:1024], "inline": False})

    payload = {
        "embeds": [{
            "title": "🔎 Signal Discovery — Top Channels (24h)",
            "color": 0x9b59b6,
            "fields": fields,
            "timestamp": datetime.now(timezone.utc).isoformat(),
            "footer": {"text": f"Total signals 24h: {sum(c['count'] for c in candidates)} | Channels analyzed: {len(candidates)}"},
        }],
    }
    try:
        r = requests.post(WEBHOOK, json=payload, timeout=10)
        print(f"[discovery] webhook: {r.status_code} ({len(top)} candidates posted)")
    except Exception as e:
        print(f"[discovery] webhook error: {e}")

    save_state({"last_run": int(now), "known_symbols": list(known | new_symbols)[:5000]})

if __name__ == "__main__":
    main()
