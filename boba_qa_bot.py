#!/usr/bin/env python3
"""
boba_qa_bot — natural-language Q&A on flow data.

Listens on #boba-cmd. Answers questions like:
  - "best option in huge flow today"
  - "what's repeating in flow today"
  - "any T0 hits in fg1"
  - "best swing setup today"
  - "compare best call vs put in flow"

Reads scraped flow JSON files directly (no Discord scraping):
  - flow_alerts_today.json + flow_liveflows_today.json (Ultimate Flow primary)
  - flow2_alerts_today.json + flow2_liveflows_today.json (Flow Greeks 2)
  - analyst_*.json (Name/Vivid signals)

Premium tier ladder (T0-T4): same as Boba prompt — single source of truth.
Same-day scope: 4AM ET to now.

Cost: pure ranking = $0. Synthesis question (LLM) = ~$0.01-0.03 via Sonnet.
"""
import asyncio, json, os, re, sys, time
from datetime import datetime, timezone, timedelta
from pathlib import Path
from collections import defaultdict
import discord, requests

SECRETS = Path.home() / ".openclaw" / "secrets"
LOG_DIR = Path.home() / ".openclaw" / "workspace" / "logs"
QUERY_LOG = Path.home() / ".openclaw" / "workspace" / "memory" / "boba_qa_queries.jsonl"
LOG_DIR.mkdir(parents=True, exist_ok=True)
QUERY_LOG.parent.mkdir(parents=True, exist_ok=True)

# Auth
def _read(name):
    p = SECRETS / name
    return p.read_text().strip() if p.exists() else ""

# Try boba-specific token first, fall back to a shared bot token if you make one
TOKEN = _read("discord_boba_qa_token") or _read("discord_boba_token") or _read("discord_askgrok_token")
if not TOKEN:
    print("FATAL: no Discord bot token found. Need ~/.openclaw/secrets/discord_boba_qa_token", flush=True)
    sys.exit(1)

AUTH_USER_ID = int(_read("mike_discord_user_id") or _read("discord_user_id") or "0")
BOBA_CMD_CHANNEL = int(_read("discord_boba_cmd_channel") or "1497766640723427389")
ANTHROPIC_KEY = _read("anthropic_api_key")

# Data sources
FLOW_DIR = Path("/home/ubuntu/mission-control-restored/Option-Signals-Scraper/data")

SOURCE_MAP = {
    # Primary "huge flow" / "ultimate flow" / "flow" / "repeater"
    "huge flow":      ["flow_alerts_today.json", "flow_liveflows_today.json"],
    "ultimate flow":  ["flow_alerts_today.json", "flow_liveflows_today.json"],
    "flow":           ["flow_alerts_today.json", "flow_liveflows_today.json"],
    "repeater":       ["flow_alerts_today.json", "flow_liveflows_today.json"],
    "repeater flow":  ["flow_alerts_today.json", "flow_liveflows_today.json"],
    # Flow Greeks 1 / 2
    "fg1":            ["flow_alerts_today.json"],   # FG1 primary alerts
    "flowgreeks 1":   ["flow_alerts_today.json"],
    "fg2":            ["flow2_alerts_today.json", "flow2_liveflows_today.json"],
    "flowgreeks 2":   ["flow2_alerts_today.json", "flow2_liveflows_today.json"],
    # Analyst signals
    "analyst":        ["analyst_signals_merged.json"],
    "watchlist":      ["analyst_signals_merged.json"],
    "name":           ["analyst_name_shorttermoptions.json", "analyst_name2_shorttermoptions.json"],
    "vivid":          ["analyst_vivid_shorttermoptions.json", "analyst_vivid2_shorttermoptions.json"],
    # Swing-specific
    "swing":          ["analyst_name_longtermoptions.json", "analyst_name2_longtermoptions.json",
                       "analyst_vivid_longtermoptions.json", "analyst_vivid2_longtermoptions.json"],
    "leaps":          ["analyst_name_longtermoptions.json", "analyst_name2_longtermoptions.json"],
}

# Tier thresholds (premium in $)
TIER_T0 = 10_000_000
TIER_T1 = 5_000_000
TIER_T2 = 1_000_000
TIER_T3 = 500_000
TIER_T4 = 100_000

# Cache for parsed day-set
_cache = {"data": None, "ts": 0}
CACHE_SEC = 300  # 5 minutes

# Rate limit per user
_last_query = {}
RATE_LIMIT_SEC = 20


def audit(action, detail):
    entry = {"ts": datetime.now(timezone.utc).isoformat(), "action": action, "detail": detail}
    with QUERY_LOG.open("a") as f:
        f.write(json.dumps(entry) + "\n")
    print(f"[boba-qa] {action}: {str(detail)[:300]}", flush=True)


def today_4am_et_ms():
    """Returns Unix ms for today's 4AM ET (or yesterday's if we're before 4AM today)."""
    now = datetime.now(timezone.utc)
    et_offset = timedelta(hours=4)  # EDT is UTC-4
    et_now = now - et_offset
    cutoff_et = et_now.replace(hour=4, minute=0, second=0, microsecond=0)
    if et_now.hour < 4:
        cutoff_et -= timedelta(days=1)
    cutoff_utc = cutoff_et + et_offset
    return int(cutoff_utc.timestamp() * 1000)


def normalize_record(rec, source_file):
    """Normalize a flow record to a consistent dict regardless of source schema."""
    # Handle alert-style records (have "alert" sub-dict)
    if isinstance(rec, dict) and "alert" in rec and isinstance(rec["alert"], dict):
        a = rec["alert"]
        return {
            "ticker": a.get("Symbol", ""),
            "option_symbol": a.get("OptionSymbol", ""),
            "strike": a.get("Strike", 0),
            "option_type": a.get("OptionType", ""),
            "expiry_ms": (a.get("Expiry", 0) or 0) * 1000,
            "dte": a.get("DTE", 0),
            "premium": a.get("totalFlowValue", 0) or 0,
            "volume": a.get("Volume", 0),
            "oi": a.get("OI", 0),
            "sweeps": a.get("SWEEPS", 0),
            "blocks": a.get("BLOCKS", 0),
            "spot": a.get("Spot", 0),
            "is_bullish": a.get("isBullish", True),
            "time_ms": a.get("Time", 0),
            "repeater_count": a.get("totalFlowCount", 1) or 1,
            "alert_price": a.get("AlertPrice", 0),
            "source": source_file,
        }
    # Handle live-flow records (no "alert" wrapper)
    if isinstance(rec, dict) and "Symbol" in rec:
        return {
            "ticker": rec.get("Symbol", ""),
            "option_symbol": "",
            "strike": rec.get("Strike", 0),
            "option_type": rec.get("OptionType", ""),
            "expiry_ms": int(rec.get("Expiry", 0) or 0) * 1000 if rec.get("Expiry", 0) < 1e10 else int(rec.get("Expiry", 0) or 0),
            "dte": 0,
            "premium": rec.get("Value", 0) or 0,
            "volume": rec.get("Volume", 0),
            "oi": rec.get("OI", 0),
            "sweeps": 1 if rec.get("BlockType") == "SWEEP" else 0,
            "blocks": 1 if rec.get("BlockType") == "BLOCK" else 0,
            "spot": rec.get("Spot", 0),
            "is_bullish": rec.get("OptionType", "").upper() == "CALL",
            "time_ms": rec.get("Time", 0),
            "repeater_count": 1,
            "alert_price": rec.get("Price", 0),
            "bid_ask": rec.get("BidAskType", ""),
            "block_type": rec.get("BlockType", ""),
            "source": source_file,
        }
    return None


def load_source(source_files):
    """Load + normalize all records from given source files for today only."""
    cutoff_ms = today_4am_et_ms()
    out = []
    for fname in source_files:
        fpath = FLOW_DIR / fname
        if not fpath.exists():
            continue
        try:
            data = json.load(fpath.open())
        except Exception as e:
            audit("load_error", f"{fname}: {e}")
            continue
        records = list(data.values()) if isinstance(data, dict) else data
        for rec in records:
            n = normalize_record(rec, fname)
            if n and n["time_ms"] >= cutoff_ms:
                out.append(n)
    return out


def get_tier(premium):
    if premium >= TIER_T0: return ("T0", "MEGA FLOW", "$10M+")
    if premium >= TIER_T1: return ("T1", "HUGE FLOW", "$5M+")
    if premium >= TIER_T2: return ("T2", "BIG FLOW", "$1M+")
    if premium >= TIER_T3: return ("T3", "STANDARD", "$500K+")
    if premium >= TIER_T4: return ("T4", "UNUSUAL", "$100K+")
    return ("X", "LOW", "<$100K")


def score_record(r):
    """Co-primary tiebreakers: repeater_count and DTE-shorter, then sweep/bid-ask/vol-oi."""
    repeater = r.get("repeater_count", 1) or 1
    dte = r.get("dte", 30) or 30

    repeater_score = (repeater * 10) if repeater >= 3 else 0
    if dte <= 0: dte_bonus = 15
    elif dte <= 2: dte_bonus = 10
    elif dte <= 7: dte_bonus = 6
    elif dte <= 30: dte_bonus = 3
    else: dte_bonus = 0

    sweep_bonus = (r.get("sweeps", 0) * 5) + (r.get("blocks", 0) * 2)

    bid_ask = r.get("bid_ask", "")
    bidask_bonus = 4 if bid_ask == "AA" else (3 if bid_ask == "A" else (-2 if bid_ask == "B" else (-3 if bid_ask == "BB" else 0)))

    oi = r.get("oi", 0) or 1
    vol = r.get("volume", 0)
    vol_oi = vol / oi if oi > 0 else 0
    vol_oi_bonus = min(vol_oi * 2, 10)  # cap at 10

    return repeater_score + dte_bonus + sweep_bonus + bidask_bonus + vol_oi_bonus


def dedupe_and_aggregate(records):
    """Group same contract appearing multiple times, sum repeater count."""
    groups = defaultdict(list)
    for r in records:
        if not r["option_symbol"]:
            # Build a key for live-flow records
            key = f"{r['ticker']}_{r['strike']}_{r['option_type']}_{r['expiry_ms']}"
        else:
            key = r["option_symbol"]
        groups[key].append(r)
    aggregated = []
    for key, recs in groups.items():
        # Sum premiums, count hits, take latest record as base
        base = max(recs, key=lambda x: x["time_ms"])
        base = dict(base)  # shallow copy
        base["premium"] = sum(r["premium"] for r in recs)
        base["repeater_count"] = max(base.get("repeater_count", 1), len(recs))
        base["sweeps"] = sum(r.get("sweeps", 0) for r in recs)
        base["blocks"] = sum(r.get("blocks", 0) for r in recs)
        aggregated.append(base)
    return aggregated


def get_data(force=False):
    """Cached data fetch. Returns dict by source category."""
    now = time.time()
    if not force and _cache["data"] and (now - _cache["ts"]) < CACHE_SEC:
        return _cache["data"]
    data = {}
    for category, files in SOURCE_MAP.items():
        records = load_source(files)
        records = dedupe_and_aggregate(records)
        data[category] = records
    _cache["data"] = data
    _cache["ts"] = now
    return data


# ─── Question parser ─────────────────────────────────────────────────────────

def parse_question(q):
    """Extract intent, source, filters from natural-language question."""
    qlow = q.lower().strip()
    parsed = {
        "source": None,
        "intent": "best",  # best | repeater | compare | tier_only | scan
        "tier_floor": None,  # T0 / T1 / T2 / T3 / T4
        "option_type": None,  # CALL / PUT
        "limit": 1,
        "synthesize": False,  # call LLM for analysis vs raw ranking
    }

    # Source detection
    for key in sorted(SOURCE_MAP.keys(), key=len, reverse=True):  # longest match first
        if key in qlow:
            parsed["source"] = key
            break
    if not parsed["source"]:
        parsed["source"] = "flow"  # default

    # Intent detection
    if "repeat" in qlow:
        parsed["intent"] = "repeater"
    elif "compare" in qlow or " vs " in qlow:
        parsed["intent"] = "compare"
        parsed["limit"] = 2
    elif any(w in qlow for w in ["should i", "would you", "is this", "thoughts on"]):
        parsed["synthesize"] = True
    elif any(w in qlow for w in ["scan", "show me", "list", "all "]):
        parsed["intent"] = "scan"
        parsed["limit"] = 5

    # Tier floor
    m = re.search(r"\bt([0-4])\b", qlow)
    if m: parsed["tier_floor"] = f"T{m.group(1)}"

    # Option type
    if "call" in qlow and "put" not in qlow: parsed["option_type"] = "CALL"
    elif "put" in qlow and "call" not in qlow: parsed["option_type"] = "PUT"

    # Top-N
    m = re.search(r"top\s+(\d+)", qlow)
    if m: parsed["limit"] = min(int(m.group(1)), 10)

    return parsed


# ─── Ranker ──────────────────────────────────────────────────────────────────

def rank_picks(records, parsed):
    """Apply T0→T4 ladder + within-tier scoring."""
    # Filter by option_type if asked
    if parsed["option_type"]:
        records = [r for r in records if r["option_type"].upper() == parsed["option_type"]]

    # Bucket by tier
    buckets = {"T0": [], "T1": [], "T2": [], "T3": [], "T4": [], "X": []}
    for r in records:
        tier_code, _, _ = get_tier(r["premium"])
        buckets[tier_code].append(r)

    # Apply tier floor if asked
    floor_order = ["T0", "T1", "T2", "T3", "T4", "X"]
    if parsed["tier_floor"]:
        floor_idx = floor_order.index(parsed["tier_floor"])
        # Keep only tiers at or above floor (lower idx = higher tier)
        for code in floor_order[floor_idx + 1:]:
            buckets[code] = []

    # Score within tier
    for code in buckets:
        buckets[code].sort(key=lambda r: -score_record(r))

    # Build output: highest non-empty tier first
    selected = []
    chosen_tier = None
    for code in floor_order:
        if buckets[code]:
            selected = buckets[code][:parsed["limit"]]
            chosen_tier = code
            break

    counts = {code: len(buckets[code]) for code in floor_order if len(buckets[code]) > 0}
    return {
        "tier": chosen_tier,
        "picks": selected,
        "tier_counts": counts,
        "all_filtered_records": sum(len(v) for v in buckets.values()),
    }


# ─── Output formatting ───────────────────────────────────────────────────────

def fmt_premium(v):
    if v >= 1e6: return f"${v/1e6:.1f}M"
    if v >= 1e3: return f"${v/1e3:.0f}K"
    return f"${v:.0f}"


def format_response(result, parsed, source_label):
    if not result["picks"]:
        return f"📭 No qualifying flow today in **{source_label}**. Tiers scanned: {result['tier_counts']}"

    tier_code = result["tier"]
    _, tier_name, tier_thresh = get_tier(result["picks"][0]["premium"])

    counts_str = " | ".join([f"{k}: {v}" for k, v in sorted(result["tier_counts"].items())])

    lines = [f"📊 **Today's flow scan — {source_label} — 4AM ET to now**"]
    lines.append(f"Total: {result['all_filtered_records']} contracts. {counts_str}")
    lines.append("")

    rank_word = {"T0": "🔥 T0 MEGA", "T1": "🦈 T1 HUGE", "T2": "🐋 T2 BIG", "T3": "📊 T3 STANDARD", "T4": "📉 T4 UNUSUAL", "X": "⚠ Below thresholds"}.get(tier_code, tier_code)

    if parsed["intent"] == "compare" and len(result["picks"]) >= 2:
        lines.append(f"**Comparison ({rank_word} tier):**")
    elif parsed["intent"] == "scan":
        lines.append(f"**Top {len(result['picks'])} from {rank_word} tier:**")
    else:
        lines.append(f"**Best pick ({rank_word} tier {tier_thresh}):**")

    for i, p in enumerate(result["picks"], 1):
        score = round(score_record(p), 1)
        sym = p.get("option_symbol") or f"{p['ticker']} ${p['strike']}{p['option_type'][0] if p['option_type'] else '?'}"
        repeater_str = f" ×{p['repeater_count']}" if p.get("repeater_count", 1) > 1 else ""
        ba = f" {p.get('bid_ask','')}" if p.get('bid_ask') else ""
        bt = f" {p.get('block_type','')}" if p.get('block_type') else ("SWEEP" if p.get('sweeps',0) else "BLOCK" if p.get('blocks',0) else "")
        oi_vol = f"V{p.get('volume',0):,}/OI{p.get('oi',0):,}"
        prefix = f"{i}. " if len(result["picks"]) > 1 else ""
        lines.append(
            f"{prefix}**{sym}** ({p.get('dte','?')} DTE) — "
            f"{fmt_premium(p['premium'])}{repeater_str} | "
            f"{bt}{ba} | {oi_vol} | "
            f"score: **{score}**"
        )

    if not result["picks"] or tier_code == "T4":
        lines.append("")
        lines.append("⚠ No T0/T1/T2 hits — Boba would likely pass.")

    return "\n".join(lines)[:1900]


# ─── Anthropic synthesis (for "should I take it" type questions) ────────────

def call_claude(question, context):
    if not ANTHROPIC_KEY:
        return "(Anthropic key missing — synthesis unavailable)"
    try:
        r = requests.post(
            "https://api.anthropic.com/v1/messages",
            headers={
                "x-api-key": ANTHROPIC_KEY,
                "anthropic-version": "2023-06-01",
                "content-type": "application/json",
            },
            json={
                "model": "claude-sonnet-4-5",
                "max_tokens": 800,
                "messages": [{
                    "role": "user",
                    "content": (
                        f"You are Boba, evaluating today's flow data. Mike asked:\n"
                        f"{question}\n\n"
                        f"Today's ranked flow data:\n{context}\n\n"
                        f"Apply your two-protocol logic (Protocol A flow / Protocol B swing). "
                        f"Be concise (under 1200 chars). State whether you'd take it, why, "
                        f"and which protocol fits."
                    )
                }],
            },
            timeout=60,
        )
        if r.status_code != 200:
            return f"Claude API error {r.status_code}: {r.text[:200]}"
        data = r.json()
        return data["content"][0]["text"]
    except Exception as e:
        return f"Claude call failed: {e}"


# ─── Discord client ──────────────────────────────────────────────────────────

intents = discord.Intents.default()
intents.message_content = True
intents.messages = True
intents.guilds = True
client = discord.Client(intents=intents)


def is_question(text):
    t = text.strip().lower()
    if not t: return False
    if t.endswith("?"): return True
    triggers = ("which", "what", "best", "should i", "any t", "compare", "show me",
                "what's", "whats", "scan", "top ", "find", "is there", "are there")
    return any(t.startswith(x) for x in triggers)


@client.event
async def on_ready():
    audit("startup", f"as {client.user}, {len(client.guilds)} guilds, listening on channel {BOBA_CMD_CHANNEL}")


@client.event
async def on_message(message):
    if message.author.id == client.user.id: return
    if AUTH_USER_ID and message.author.id != AUTH_USER_ID: return
    if message.channel.id != BOBA_CMD_CHANNEL: return
    if not is_question(message.content): return

    # Rate limit
    now = time.time()
    last = _last_query.get(message.author.id, 0)
    if now - last < RATE_LIMIT_SEC:
        await message.add_reaction("⏱")
        return
    _last_query[message.author.id] = now

    try:
        parsed = parse_question(message.content)
        audit("query", {"q": message.content[:200], "parsed": parsed})

        await message.add_reaction("🔍")

        data = get_data()
        records = data.get(parsed["source"], [])
        if parsed["intent"] == "repeater":
            records = [r for r in records if r.get("repeater_count", 1) >= 3]

        result = rank_picks(records, parsed)
        response = format_response(result, parsed, parsed["source"].replace("_", " ").title())

        if parsed["synthesize"] and ANTHROPIC_KEY:
            synth = call_claude(message.content, response)
            response = response + "\n\n**🤖 Boba's verdict:**\n" + synth[:1000]

        await message.reply(response[:1990], mention_author=False)
        audit("answered", {"tier": result["tier"], "picks": len(result["picks"])})
    except Exception as e:
        audit("error", str(e))
        await message.reply(f"❌ QA error: {e}", mention_author=False)


if __name__ == "__main__":
    print(f"[boba-qa] Starting. Channel={BOBA_CMD_CHANNEL} Auth={AUTH_USER_ID}", flush=True)
    client.run(TOKEN)
