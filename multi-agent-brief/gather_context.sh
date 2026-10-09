#!/usr/bin/env bash
# Gathers brief context as structured, READ-ONLY text (curls + local files + insider fetch + Discord read).
# Usage: gather_context.sh [premarket|morning|midday|eod|afterhours]
# Every block prints "source: ... as of <ET time>"; older than its threshold -> "STALE <as_of>"; failed -> "UNAVAILABLE".
set -uo pipefail
export TZ="America/New_York"

BRIEF_TYPE="${1:-}"
SECRETS="/home/ubuntu/.openclaw/secrets"
SHADOW_DIR="/home/ubuntu/.openclaw/data/decision/intel_objects/shadow"
export BRIEF_TYPE SHADOW_DIR

echo "=== CONTEXT GENERATED $(date '+%a %Y-%m-%d %H:%M ET') (brief type: ${BRIEF_TYPE:-none}) ==="
echo ""

echo "=== GROK SENTIMENT (Discord #grok, last 4h) ==="
TOKEN=$(cat "$SECRETS/spacer_bot_token.txt" 2>/dev/null || echo "")
if [ -n "$TOKEN" ]; then
  curl -sf -m 10 -H "Authorization: Bot $TOKEN" \
    "https://discord.com/api/v10/channels/1497448514404356136/messages?limit=20" 2>/dev/null \
    | python3 -c "
import sys, json
from datetime import datetime, timezone, timedelta
from zoneinfo import ZoneInfo
ET = ZoneInfo('America/New_York')
msgs = [m for m in json.load(sys.stdin) if m.get('content')]
if not msgs:
    print('UNAVAILABLE (no messages returned)'); sys.exit()
ts = lambda m: datetime.fromisoformat(m['timestamp'].replace('Z','+00:00'))
newest = max(ts(m) for m in msgs)
print('source: Discord #grok (read-only) | newest message as of', newest.astimezone(ET).strftime('%a %m-%d %H:%M ET'))
cutoff = datetime.now(timezone.utc) - timedelta(hours=4)
recent = [m for m in msgs if ts(m) > cutoff]
if not recent:
    print('STALE', newest.astimezone(ET).strftime('%m-%d %H:%M ET'), '(nothing in the last 4h; do not use as current sentiment)')
for m in recent:
    print(f'- [{ts(m).astimezone(ET).strftime(\"%H:%M ET\")}] {m[\"content\"][:300]}')
" 2>/dev/null || echo "UNAVAILABLE (Discord read failed)"
else
  echo "UNAVAILABLE (no bot token)"
fi

echo ""
echo "=== MISSIONCTRL FACTS ==="
python3 - <<'PY'
import os, json, glob, subprocess
from datetime import datetime, timedelta
from zoneinfo import ZoneInfo
ET = ZoneInfo("America/New_York")
NOW = datetime.now(ET)
BT = os.environ.get("BRIEF_TYPE", "")
SHADOW = os.environ["SHADOW_DIR"]

def fmt(dt): return dt.astimezone(ET).strftime("%a %m-%d %H:%M ET")
def ms(v): return datetime.fromtimestamp(v / 1000, ET)
def iso(s): return datetime.fromisoformat(s).astimezone(ET)

def header(name, source, asof, max_age):
    """Print the block header; return True when fresh."""
    if asof is None:
        print(f"\n--- {name} --- source: {source} | as of UNKNOWN | STALE (no as_of; threshold {max_age})")
        return False
    stale = NOW - asof > (max_age if isinstance(max_age, timedelta) else timedelta(hours=max_age))
    thr = f"{int(max_age.total_seconds()//3600) if isinstance(max_age, timedelta) else max_age}h"
    print(f"\n--- {name} --- source: {source} | as of {fmt(asof)} | " + (f"STALE {fmt(asof)} (threshold {thr})" if stale else f"fresh (threshold {thr})"))
    return not stale

def unavailable(name, source, why):
    print(f"\n--- {name} --- source: {source} | UNAVAILABLE ({why})")

def get(path):
    try:
        out = subprocess.run(["curl", "-s", "-m", "8", "-f", f"http://localhost:3000{path}"], capture_output=True, text=True, timeout=12).stdout
        return json.loads(out)
    except Exception:
        return None

# --- shadow facts (decision.boba.briefs) ---
KINDS = {
    "premarket": ["equity_premarket"],
    "morning": ["equity_premarket", "equity_midday"],
    "midday": ["equity_midday", "equity_premarket"],
    "eod": ["equity_close"],
    "afterhours": ["equity_close", "crypto_pm"],
}
want = KINDS.get(BT, ["equity_premarket", "equity_midday", "equity_close", "crypto_am", "crypto_pm"])
today = NOW.strftime("%Y-%m-%d")
shown = 0
for kind in want:
    p = f"{SHADOW}/{today}/{kind}.facts.txt"
    name = f"SHADOW FACTS {kind}"
    src = f"decision.boba.briefs {today}/{kind}.facts.txt"
    if os.path.exists(p):
        asof = datetime.fromtimestamp(os.path.getmtime(p), ET)
        header(name, src, asof, 8 if kind.startswith("crypto") else 6)
        print(open(p).read()[:4000])
        shown += 1
        if BT in ("morning", "midday") and shown >= 1:
            break  # first available kind is enough for these brief types
    else:
        unavailable(name, src, "no file for today yet")
if shown == 0:
    prior = sorted(glob.glob(f"{SHADOW}/2*/{want[0]}.facts.txt"))
    if prior:
        p = prior[-1]
        asof = datetime.fromtimestamp(os.path.getmtime(p), ET)
        print(f"\n--- LAST AVAILABLE {want[0]} (not today) --- source: {p} | STALE {fmt(asof)} (use only as labeled prior context)")
        print(open(p).read()[:2500])

# --- macro regime ---
d = get("/api/macro-regime")
if d is None: unavailable("MACRO REGIME", "/api/macro-regime", "fetch failed")
else:
    fresh = header("MACRO REGIME", "/api/macro-regime (heuristic stance, not the canonical regime)", ms(d["asOf"]) if d.get("asOf") else None, 0.5)
    st = d.get("stance", {}); v = d.get("vix", {}); fg = d.get("fearGreed", {}); y = d.get("yields", {})
    print(f"stance {st.get('label')} score {st.get('score')} | data status {d.get('dataStatus')} (degraded={d.get('degraded')})")
    print(f"VIX {v.get('level')} ({v.get('pct')}%) | Fear&Greed {fg.get('value')} {fg.get('label')} (1w ago {fg.get('oneWeekAgo')})")
    print(f"10Y {y.get('tenY')} (intraday quote) | 2Y {y.get('twoY')} ({y.get('twoYStatus')}, as of {y.get('twoYAsOf')}) | 10Y-13W {y.get('spread10y13w')} ({y.get('spreadStatus')}, as of {y.get('spreadAsOf')})")
    secs = sorted([s for s in d.get("sectors", []) if s.get("return5d") is not None], key=lambda s: -s["return5d"])
    if secs:
        print("sectors 5d: leaders " + ", ".join(f"{s['symbol']} {s['return5d']:+.1f}%" for s in secs[:3]) + " | laggards " + ", ".join(f"{s['symbol']} {s['return5d']:+.1f}%" for s in secs[-3:]))
    print("verdict:", (d.get("verdict") or "")[:300])

# --- crypto regime (BTC/USD) ---
d = get("/api/regime")
if d is None: unavailable("BTC REGIME", "/api/regime", "fetch failed")
else:
    header("BTC REGIME (BTC/USD only)", "/api/regime", ms(d["asOf"]) if d.get("asOf") else None, 2)
    print(f"overall {d.get('overall_regime')} | bias {d.get('direction_bias')} | {d.get('overall_recommendation')}")
    for tf, t in (d.get("timeframes") or {}).items():
        print(f"  {tf}: {t.get('regime')} {t.get('direction')} ADX {t.get('adx')} px {t.get('current_price')}")

# --- crypto desk ---
d = get("/api/crypto-desk")
if d is None: unavailable("CRYPTO DESK", "/api/crypto-desk", "fetch failed")
else:
    header("CRYPTO DESK", "/api/crypto-desk (blend of derivs/onchain/flows/ta/news)", ms(d["asOf"]) if d.get("asOf") else None, 3)
    print("coverage:", d.get("notes"))
    for sym, b in (d.get("blend") or {}).items():
        lv = (d.get("levels") or {}).get(sym, {})
        print(f"  {sym}: regime {b.get('regime')} score {b.get('score'):.2f} conf {b.get('confidence')} | support {lv.get('support')} resistance {lv.get('resistance')} | {lv.get('dist52wHighPct')}% below 52w high")
    for fac, c in (d.get("clocks") or {}).items():
        print(f"  factor {fac}: data as of {c.get('dataAt')}")

# --- macro / Fed ---
d = get("/api/decision/macro_fed")
if d is None: unavailable("MACRO / FED", "/api/decision/macro_fed", "fetch failed")
else:
    ran = iso(d["ranAt"]) if d.get("ranAt") else None
    header("MACRO / FED", "/api/decision/macro_fed (FRED/yfinance/federalreserve.gov)", ran, 36)
    f = d.get("facts", {}); val = lambda k: (f.get(k) or {}).get("value")
    print(f"fed funds target {val('fed.policy.target_lower')}-{val('fed.policy.target_upper')}% | EFFR {val('fed.effr')} | next FOMC {val('fed.next_meeting.date')} | cut/hold/hike {val('fed.next_meeting.cut_prob')}/{val('fed.next_meeting.hold_prob')}/{val('fed.next_meeting.hike_prob')} (futures-implied)")
    print(f"10Y {val('rates.us.t10y')} (FRED daily close) 2Y {val('rates.us.t2y')} 10Y-2Y {val('rates.us.spread_10y2y')} | MOVE {val('rates.us.move_index')}")
    print("note:", d.get("notes"))
    for e in (d.get("market", {}).get("events") or [])[:5]:
        print(f"  event {e.get('at')} {e.get('name')} [{e.get('impact')}]")

# --- option momentum ---
d = get("/api/option-momentum")
if d is None: unavailable("OPTION MOMENTUM", "/api/option-momentum", "fetch failed")
else:
    # API status is AVAILABLE when latest.json is <90s old (engine runs 09:30-16:00 ET only).
    stamps = [t for c in d.get("cards", []) for t in (c.get("quote_as_of"), (c.get("alert") or {}).get("at")) if isinstance(t, (int, float))]
    asof = datetime.fromtimestamp(max(stamps), ET) if stamps else None
    status = d.get("status")
    if status == "AVAILABLE":
        header("OPTION MOMENTUM (display only; not a trade signal)", "/api/option-momentum", asof, 0.05)
    else:
        print(f"\n--- OPTION MOMENTUM (display only; not a trade signal) --- source: /api/option-momentum | "
              f"engine idle (runs 09:30-16:00 ET RTH) | last update {fmt(asof) if asof else 'UNKNOWN'}")
    # What Mike actually received today = the Telegram send ledger (jazzy_relay lane), not card.alert (latest only).
    try:
        import sqlite3
        con = sqlite3.connect(f"file:{os.path.expanduser('~/.local/state/tg-ledger.sqlite')}?mode=ro", uri=True)
        rows = con.execute("select ts, text from sends where fn='jazzy_relay' and day=? and ok=1 order by ts", (today,)).fetchall()
        print(f"alerts sent to Telegram today: {len(rows)}" + ("" if rows else " (none)"))
        for ts, text in rows[-8:]:
            lines = [l for l in (text or "").splitlines() if l.strip()]
            print(f"  {datetime.fromtimestamp(ts, ET).strftime('%H:%M ET')} " + " | ".join(lines[:2])[:160])
    except Exception as e:
        print(f"alerts sent today: UNAVAILABLE (ledger read failed: {type(e).__name__})")
PY

echo ""
echo "=== INSIDER TRADING (OpenInsider + SEC EDGAR) — as of fetch time $(date '+%H:%M ET') ==="
python3 /home/ubuntu/scripts/multi-agent-brief/fetch_insider_trades.py 2>/dev/null || echo "UNAVAILABLE (insider fetch failed)"
