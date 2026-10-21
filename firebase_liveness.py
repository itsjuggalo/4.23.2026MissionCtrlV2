#!/usr/bin/env python3
"""Firebase source-vs-relay liveness → #broadcast-log (Mike 2026-10-20 #19: "keep the resource working"; post in a
channel that carries no data). READ-ONLY: GETs against the official RTDB source and a read of the relay's
jsonl. Never touches the relay (pm2 fcm-rtdb / firebase-signal-relay) or its code.

Per relayed node: newest item at the SOURCE (RTDB keys are epoch seconds) vs newest item the RELAY stored.
  OK        relay caught up with the source
  RELAY LAG the source has items newer than the relay's newest (> LAG_MIN) → relay missed something
  QUIET     source itself silent > QUIET_DAYS (vendor stopped posting there — not a relay fault)
Also lists UNTAPPED source nodes (live at the source, not in the relay's stream list).
  firebase_liveness.py [--post]   (default prints; --post also posts to #broadcast-log)
Writes ~/.openclaw/data/firebase/liveness.json for Data Health / the vendor scorecard.
"""
import argparse, json, re, sys, time, urllib.error, urllib.parse, urllib.request
from datetime import datetime
from pathlib import Path
from zoneinfo import ZoneInfo

ET = ZoneInfo("America/New_York")
SRC = "https://stock-signal-72772-default-rtdb.firebaseio.com"
RELAY_CODE = Path.home() / "firebase-signals/rtdb_stream.py"
RELAY_JSONL = Path.home() / "firebase-signals/live_signals.jsonl"
OUT = Path.home() / ".openclaw/data/firebase/liveness.json"
SEC = Path.home() / ".openclaw/secrets"
BROADCAST_LOG = "1486045641221083216"
VENDORS = ["Vivid", "Vivid2", "Name", "Name2", "OSIndia"]
LAG_MIN, QUIET_DAYS = 15, 7


def get(path, **q):
    url = f"{SRC}/{path}.json" + ("?" + urllib.parse.urlencode(q) if q else "")
    for i in range(3):
        try:
            with urllib.request.urlopen(url, timeout=25) as r:
                return json.load(r)
        except Exception:
            time.sleep(1 + i)
    return None


def newest_epoch(path):
    d = get(path, orderBy='"$key"', limitToLast=1)
    if not isinstance(d, dict) or not d:
        return None
    k = next(iter(d))
    return int(k) if k.isdigit() and 1_000_000_000 < int(k) < 4_000_000_000 else None


def relay_streams():
    """(feed, path) pairs parsed from the relay's own stream list — read as text, never imported."""
    pairs = re.findall(r'\("([a-z0-9_]+)",\s*[\'"](/[^\'"?]+?)\.json', RELAY_CODE.read_text())
    return [(f, p.strip("/")) for f, p in pairs]


def relay_newest():
    """Newest stored item per feed + the start of the relay store's window (the jsonl is rotated)."""
    last, first = {}, None
    with RELAY_JSONL.open() as f:
        for line in f:
            try:
                d = json.loads(line)
                last[d["feed"]] = d["received_at"]
                first = first or d["received_at"]
            except Exception:
                continue
    return ({k: datetime.fromisoformat(v).timestamp() for k, v in last.items()},
            datetime.fromisoformat(first).timestamp() if first else None)


def fmt(ts):
    return datetime.fromtimestamp(ts, ET).strftime("%m-%d %H:%M") if ts else "never"


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("--post", action="store_true")
    a = ap.parse_args()
    now = time.time()
    streams = relay_streams()
    if not streams:
        sys.exit("could not parse the relay stream list — report it, do not guess")
    relayed = {p for _, p in streams}
    rn, window_start = relay_newest()
    rows = []
    for feed, path in streams:
        if path.startswith("FlowGreeks"):
            continue  # keyed by contract/day, not epoch; flow freshness is covered by Data Health
        src = newest_epoch(path)
        rel = rn.get(feed)
        if src is None:
            state = "EMPTY"
        elif now - src > QUIET_DAYS * 86400:
            state = "QUIET"
        elif rel is None and window_start and src < window_start:
            state = "OK"  # newest source item predates the relay store's window — nothing to compare
        elif rel is None or src - rel > LAG_MIN * 60:
            state = "RELAY LAG"
        else:
            state = "OK"
        rows.append({"feed": feed, "path": path, "source_newest": src, "relay_newest": rel, "state": state})
    untapped = []
    for v in VENDORS:
        subs = get(v, shallow="true") or {}
        for s in subs:
            p = f"{v}/{s}"
            if p in relayed:
                continue
            src = newest_epoch(p)
            if src and now - src < QUIET_DAYS * 86400:
                untapped.append({"path": p, "source_newest": src})
    OUT.parent.mkdir(parents=True, exist_ok=True)
    OUT.write_text(json.dumps({"as_of_et": datetime.now(ET).isoformat(timespec="seconds"), "nodes": rows,
                               "untapped_live": untapped}, indent=1))
    lag = [r for r in rows if r["state"] == "RELAY LAG"]
    quiet = [r for r in rows if r["state"] == "QUIET"]
    ok = [r for r in rows if r["state"] == "OK"]
    L = [f"🔥 **Firebase source vs relay** · {datetime.now(ET):%a %m-%d %H:%M} ET · official RTDB (read-only) vs relay store",
         f"✅ {len(ok)} relayed nodes current · ⚠️ {len(lag)} relay lag · 💤 {len(quiet)} quiet at source (> {QUIET_DAYS}d)"]
    for r in lag:
        L.append(f"⚠️ **{r['path']}** ({r['feed']}): source newest {fmt(r['source_newest'])} ET, relay newest {fmt(r['relay_newest'])} ET — relay is behind")
    if quiet:
        L.append("💤 quiet at the SOURCE (vendor stopped posting; relay not at fault): "
                 + ", ".join(f"{r['path']} (last {fmt(r['source_newest'])})" for r in quiet))
    if untapped:
        L.append("🆕 live at the source but NOT relayed: " + ", ".join(f"{u['path']} (last {fmt(u['source_newest'])})" for u in untapped))
    for r in ok:
        L.append(f"· {r['path']}: {fmt(r['source_newest'])} ET")
    msg = "\n".join(L)
    print(msg)
    if a.post:
        tok = (SEC / "discord_synthcontrol_token").read_text().strip()
        for i in range(0, len(msg), 1950):
            req = urllib.request.Request(f"https://discord.com/api/v10/channels/{BROADCAST_LOG}/messages", method="POST",
                                         data=json.dumps({"content": msg[i:i + 1950], "allowed_mentions": {"parse": []}}).encode(),
                                         headers={"Authorization": "Bot " + tok, "Content-Type": "application/json",
                                                  "User-Agent": "DiscordBot (mc-fb-liveness, 1.0)"})
            urllib.request.urlopen(req, timeout=20).read()
    if lag:
        sys.exit(2)  # loud: hb-run records the relay lag as a failure for Data Health


if __name__ == "__main__":
    main()
