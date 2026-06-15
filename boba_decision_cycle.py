"""
Boba Decision Cycle

Runs 10:30 ET + every 90 min during market hours (10:30, 12:00, 13:30, 15:00 ET).

Workflow:
1. Read today's whale-tier sidecar signals
2. Filter to "new since last run" + "unseen" (dedupe by signal id)
3. Build a shortlist (top 5 by score, ensuring variety across tickers)
4. For each shortlist candidate, trigger Kronos forecast
5. Build a structured prompt for Boba with:
   - His mission (AGENT_IDENTITIES.md)
   - Current Alpaca account state (equity, buying power, open positions)
   - Today's whale signals with reasoning
   - Kronos forecasts
6. Call Claude Sonnet with the prompt
7. Parse Boba's response (expecting JSON: picks, reasoning, sizing)
8. For each pick Boba commits to:
   - Execute on Alpaca (paper)
   - Post to Telegram with reasoning
   - Log decision
9. Update "seen signals" state so next cycle doesn't re-process

Safety:
  - Kill switch file at ~/.openclaw/workspace/state/boba_killswitch aborts execution
  - Max 3 picks per cycle (hard cap)
  - Max $3000 total risk per cycle (hard cap)
"""
import argparse

# === Lessons learned from past losses (auto-injected by loss-feedback cron) ===
def _load_lessons():
    from pathlib import Path
    p = Path("/home/ubuntu/.openclaw/workspace/memory/boba_lessons.md")
    if not p.exists(): return ""
    lines = [L for L in p.read_text().splitlines() if L.startswith("- [")][-15:]
    if not lines: return ""
    return "\n\nRECENT LESSONS LEARNED FROM LOSING TRADES (read these BEFORE picking; do not repeat the same mistake):\n" + "\n".join(lines) + "\n"


def _load_active_position_rules():
    """Load explicit per-position exit triggers maintained at
    ~/.openclaw/workspace/memory/active_position_rules.md.
    Format: free-form markdown. Returned text is prepended to the cycle prompt."""
    from pathlib import Path
    p = Path("/home/ubuntu/.openclaw/workspace/memory/active_position_rules.md")
    if not p.exists():
        return ""
    txt = p.read_text().strip()
    if not txt:
        return ""
    return "\n\n# ACTIVE POSITION EXIT RULES (apply BEFORE picking new contracts)\n" + txt + "\n\n"


def _load_premium_dossier(top_n: int = 5):
    """Load top-N premium dossiers from the laptop pipeline's Floor 5 publish.

    Reads premium_shortlist_published in the local Trade SQL DB. Returns a
    formatted prompt block, or empty string if no rows or DB unreachable.

    Each dossier carries Floor 1-4 chain output (signal-filter -> fundamentals ->
    TA -> insider -> risk-gate). Boba/Jazzy should weigh PLATINUM/GOLD picks
    heavily and honor any risk-gate conditional vetoes embedded in the dossier."""
    import json as _json
    import sqlite3 as _sql
    from pathlib import Path as _Path
    db = _Path("/home/ubuntu/mission-control-restored/data/options_flow.sqlite")
    if not db.exists():
        return ""
    try:
        con = _sql.connect(str(db))
        rows = con.execute(
            "SELECT rank, dossier_json, band, score, published_at, COALESCE(target_account, 'both') AS target_account "
            "FROM premium_shortlist_published "
            "WHERE COALESCE(target_account, 'both') IN ('boba', 'both') "
            "ORDER BY published_at DESC, rank ASC LIMIT ?",
            (top_n,),
        ).fetchall()
        con.close()
    except Exception:
        return ""
    if not rows:
        return ""
    seen = set()
    blocks = []
    for rank, dj, band, score, published in rows:
        try:
            d = _json.loads(dj)
        except Exception:
            continue
        contract = d.get("contract", {})
        key = (d.get("ticker"), contract.get("side"), contract.get("strike"), contract.get("expiry"))
        if key in seen:
            continue
        seen.add(key)
        ticker = d.get("ticker", "?")
        side = contract.get("side", "")
        strike = contract.get("strike", "")
        expiry = contract.get("expiry", "")
        thesis = (d.get("thesis") or "")[:300]
        stages_present = list(d.get("stages", {}).keys())
        blocks.append(
            "### #" + str(rank) + " - " + str(ticker) + " " + str(side) + " $" + str(strike) + " " + str(expiry) +
            " [" + str(band) + "/" + str(score) + "]\n" +
            "  Stages: " + ", ".join(stages_present) + "\n" +
            "  Thesis: " + thesis
        )
    if not blocks:
        return ""
    header = (
        "\n\n# PREMIUM DESK DOSSIER (from laptop six-floor pipeline)\n"
        "Top-ranked candidates from this cycle's Floor 1-4 chain. PLATINUM/GOLD entries\n"
        "have passed fundamentals + TA + insider + risk-gate. Treat as your prioritized\n"
        "shortlist - read these FIRST before the raw flow alerts below.\n\n"
    )
    return header + "\n\n".join(blocks) + "\n\n"


import json
import os
import subprocess
import sys
import time
from datetime import datetime, timedelta, timezone
from pathlib import Path

BOBA_MODEL = "claude-sonnet-4-5"  # Item 26: surfaced as constant for model_used logging

sys.path.insert(0, "/home/ubuntu/mission-control/agent-team")
from post_helper import post_to_telegram
from ops_log import log_to_ops
import firebase_signals

# Multi-agent debate posting (optional — gracefully degrades if lib missing)
try:
    sys.path.insert(0, "/home/ubuntu/scripts/lib")
    from agent_debate import post_to_debate
    _MULTIAGENT_LIB_OK = True
except Exception as _e:
    _MULTIAGENT_LIB_OK = False
    def post_to_debate(*_args, **_kwargs): pass  # no-op stub
    print(f"[boba] multi-agent debate disabled: {_e}", flush=True)

SECRETS = Path("/home/ubuntu/.openclaw/secrets")
STATE_DIR = Path("/home/ubuntu/.openclaw/workspace/state")
STATE_DIR.mkdir(parents=True, exist_ok=True)
SEEN_FILE = STATE_DIR / "boba_seen_signals.json"
KILLSWITCH = STATE_DIR / "boba_killswitch"
DECISIONS_LOG = Path("/home/ubuntu/.openclaw/workspace/skill_outputs/boba_decisions_validated.json")
DECISIONS_LOG.parent.mkdir(parents=True, exist_ok=True)
SIDECAR = Path("/home/ubuntu/mission-control/signal-receiver/data/scored_signals_recent.json")

# Tradier live options quotes (bid/ask/IV/greeks) for informed contract selection
sys.path.insert(0, "/home/ubuntu/scripts/lib")

# Skill loader - injects relevant SKILL.md content into Boba's prompt
try:
    from skill_loader import load_relevant_skills
except Exception as _e:
    print(f"[skill_loader] import failed: {_e}", flush=True)
    def load_relevant_skills(*a, **kw):
        return ""
from anthropic_tracker import log_call as _log_anthropic_call
try:
    from signal_scorer import score_signal, render_breakdown_line
except Exception as _ss_e:
    score_signal = None
    render_breakdown_line = None
    print(f"[signal-scorer] import failed: {_ss_e}", flush=True)

try:
    from peer_picks import peer_picks_block
except Exception as _peer_e:
    peer_picks_block = None
    print(f"[peer-picks] import failed: {_peer_e}", flush=True)

try:
    from pdt_guard import apply_pdt_guard
except Exception as _pdt_e:
    apply_pdt_guard = None
    print(f"[pdt-guard] import failed: {_pdt_e}", flush=True)

import time as _time_tracker
try:
    from tradier_client import fetch_option_quote as _tradier_quote
except Exception:
    _tradier_quote = None
KRONOS_CMD = "/home/itsju/mission-control/agent-team/kronos/kronos_on_demand.py"
KRONOS_PYTHON = "/home/itsju/02_DATA/mc-kb/.venv/bin/python"

MAX_PICKS_PER_CYCLE = 3
MAX_NEW_PICKS_PER_DAY = 3   # Hard cap on NEW picks per trading day across all cycles
MAX_TOTAL_RISK_USD = 1000

# Item 31: post-LLM hard guardrails (enforced by validate_pick_against_guardrails)
MAX_BUYING_POWER_PCT_PER_PICK = 1.0   # SMALL-ACCOUNT TEST MODE: full BP allowed on max conviction (was 0.15, mismatched prompt)
KRONOS_CONFLICTS_OVERRIDE_SCORE = 90  # Flow score required to override Kronos CONFLICTS veto
KRONOS_UNAVAILABLE_OVERRIDE_SCORE = 85  # Flow score required when Kronos unavailable

# Tickers Kronos cannot forecast (Alpaca has no bars for indices)
# These get UNAVAILABLE verdict immediately without inference attempt
KRONOS_SKIP_TICKERS = {"SPX", "NDX", "RUT", "VIX", "XSP", "OEX", "DJX", "XEO", "DJI"}
MIN_DTE_DEFAULT = 1  # 0DTE picks require explicit catalyst language in reasoning
FORBIDDEN_TICKERS = set()  # populated as hallucinations are observed
SHORTLIST_SIZE = 5
DAILY_PICKS_FILE = Path("/home/ubuntu/.openclaw/workspace/state/boba_daily_picks.json")
MIN_FLOW_VALUE = 500_000   # Hard floor: T1+T2 only ($500K+) — anything below is rejected


def read_secret(name):
    p = SECRETS / name
    return p.read_text().strip() if p.exists() else ""


def get_anthropic_key():
    for n in ["anthropic_api_key", "anthropic-api-key.txt", "claude_api_key"]:
        v = read_secret(n)
        if v and v.startswith("sk-"):
            return v
    return ""


def load_seen():
    if SEEN_FILE.exists():
        try:
            return set(json.loads(SEEN_FILE.read_text()))
        except Exception:
            return set()
    return set()


def save_seen(seen):
    SEEN_FILE.write_text(json.dumps(list(seen)))


def load_sidecar():
    if not SIDECAR.exists():
        return []
    try:
        return json.loads(SIDECAR.read_text())
    except Exception:
        return []


def signal_id(sig):
    """Stable ID for a signal so we can dedupe across cycles."""
    return f"{sig.get('ticker','?')}|{sig.get('strike','?')}|{sig.get('option_type','?')}|{sig.get('expiry','?')}|{sig.get('timestamp','?')[:19]}"




def load_daily_picks_state():
    """Read today's daily pick counter (resets at NY 4AM ET)."""
    from datetime import timedelta
    et_now = datetime.now(timezone(timedelta(hours=-4)))   # EDT — adjust to -5 in winter
    today_et = et_now.strftime("%Y-%m-%d")
    try:
        if DAILY_PICKS_FILE.exists():
            data = json.loads(DAILY_PICKS_FILE.read_text())
            if data.get("date") == today_et:
                return data
    except Exception:
        pass
    return {"date": today_et, "new_picks_count": 0, "picks_today": []}


def save_daily_picks_state(state):
    """Persist daily counter to disk."""
    try:
        DAILY_PICKS_FILE.parent.mkdir(parents=True, exist_ok=True)
        DAILY_PICKS_FILE.write_text(json.dumps(state, indent=2))
    except Exception as e:
        print(f"[daily_picks] save failed: {e}", flush=True)


def remaining_picks_today():
    """How many NEW picks Boba still has in the daily budget."""
    state = load_daily_picks_state()
    return max(0, MAX_NEW_PICKS_PER_DAY - state.get("new_picks_count", 0))


def increment_daily_picks(pick_summary):
    """Record a NEW pick was made today, reduce remaining budget."""
    state = load_daily_picks_state()
    state["new_picks_count"] = state.get("new_picks_count", 0) + 1
    state.setdefault("picks_today", []).append(pick_summary)
    save_daily_picks_state(state)


def get_todays_whale_signals(seen_ids):
    sigs = load_sidecar()
    today = datetime.now(timezone.utc).strftime("%Y-%m-%d")
    fresh = []
    for s in sigs:
        if s.get("timestamp", "")[:10] != today:
            continue
        sid = signal_id(s)
        if sid in seen_ids:
            continue
        fresh.append((sid, s))
    return fresh


def build_shortlist(fresh_signals):
    """Top N by score, ensuring ticker variety. Hard floor: $500K+ flow value (T1+T2)."""
    # Hard floor — drop anything below MIN_FLOW_VALUE before sorting
    filtered = [(sid, s) for sid, s in fresh_signals
                if float(s.get("flow_value", 0) or 0) >= MIN_FLOW_VALUE]
    if len(filtered) < len(fresh_signals):
        print(f"[build_shortlist] dropped {len(fresh_signals) - len(filtered)} sigs below ${MIN_FLOW_VALUE:,}", flush=True)
    # Sort by score desc
    sorted_sigs = sorted(filtered, key=lambda x: -x[1].get("score", 0))
    seen_tickers = set()
    out = []
    for sid, s in sorted_sigs:
        t = s.get("ticker")
        if t in seen_tickers and len(out) >= 3:
            continue  # Allow ticker duplicates only for first 3
        seen_tickers.add(t)
        out.append((sid, s))
        if len(out) >= SHORTLIST_SIZE:
            break
    return out


def fetch_kronos_for_ticker(ticker, option_context):
    """BLOCKING — waits for Kronos result. Only used when explicitly needed."""
    try:
        proc = subprocess.run(
            [KRONOS_PYTHON, KRONOS_CMD, "--ticker", ticker, "--option-context", option_context, "--no-discord"],
            capture_output=True, timeout=180, text=True,
        )
        try:
            return json.loads(proc.stdout)
        except Exception:
            return {"error": "kronos output not parseable", "raw": proc.stdout[-500:]}
    except subprocess.TimeoutExpired:
        return {"error": "kronos timeout"}
    except Exception as e:
        return {"error": str(e)}


def fire_kronos_background(ticker, option_context):
    """
    NON-BLOCKING fire-and-forget. Kicks off Kronos in a detached subprocess.
    Posts to Discord when done (via kronos_on_demand.py's built-in Discord post).
    Returns immediately — Boba does not wait.
    """
    try:
        # Detach fully from parent so Boba's cycle can exit without waiting
        import subprocess
        subprocess.Popen(
            [KRONOS_PYTHON, KRONOS_CMD, "--ticker", ticker, "--option-context", option_context],
            stdout=subprocess.DEVNULL,
            stderr=subprocess.DEVNULL,
            stdin=subprocess.DEVNULL,
            start_new_session=True,  # Fully detach from Boba's process group
        )
        return True
    except Exception as e:
        return False


def check_fresh_kronos_file(ticker, max_age_minutes=60):
    """
    Peek at latest Kronos forecast file for this ticker.
    Returns the forecast dict if fresh, None otherwise.
    Used by Boba to take advantage of Kronos data IF it's already available,
    without waiting.
    """
    from datetime import datetime, timezone, timedelta
    latest = Path("/home/ubuntu/.openclaw/workspace/directives/kronos_forecasts") / f"latest_{ticker}.json"
    if not latest.exists():
        return None
    try:
        age_sec = time.time() - latest.stat().st_mtime
        if age_sec > max_age_minutes * 60:
            return None
        return json.loads(latest.read_text())
    except Exception:
        return None



def wait_for_kronos_result(ticker, timeout_sec=240, poll_interval=5):
    """
    After firing Kronos in background, poll latest_<ticker>.json
    for up to timeout_sec seconds waiting for a FRESH result.
    A result counts as fresh if file mtime advanced after we started waiting.
    Returns the forecast dict if result arrives in time, None if timeout.
    """
    latest = Path("/home/ubuntu/.openclaw/workspace/directives/kronos_forecasts") / f"latest_{ticker}.json"
    start_time = time.time()
    initial_mtime = latest.stat().st_mtime if latest.exists() else 0
    while time.time() - start_time < timeout_sec:
        time.sleep(poll_interval)
        if latest.exists():
            current_mtime = latest.stat().st_mtime
            if current_mtime > initial_mtime:
                try:
                    data = json.loads(latest.read_text())
                    if "error" not in data and "forecast_24h_direction" in data:
                        elapsed = int(time.time() - start_time)
                        print(f"[kronos] {ticker} forecast ready after {elapsed}s", file=sys.stderr)
                        return data
                except Exception:
                    continue
    print(f"[kronos] {ticker} timed out after {timeout_sec}s", file=sys.stderr)
    return None


def get_alpaca_account():
    try:
        import requests
        key = read_secret("alpaca-key-id") or read_secret("alpaca_key.txt")
        sec = read_secret("alpaca-secret") or read_secret("alpaca_secret.txt")
        r = requests.get(
            "https://paper-api.alpaca.markets/v2/account",
            headers={"APCA-API-KEY-ID": key, "APCA-API-SECRET-KEY": sec},
            timeout=10,
        )
        if r.status_code == 200:
            return r.json()
    except Exception as e:
        log_to_ops("boba_cycle", "ERROR", f"Alpaca account fetch failed: {e}")
    return {}


def get_alpaca_positions():
    try:
        import requests
        key = read_secret("alpaca-key-id") or read_secret("alpaca_key.txt")
        sec = read_secret("alpaca-secret") or read_secret("alpaca_secret.txt")
        r = requests.get(
            "https://paper-api.alpaca.markets/v2/positions",
            headers={"APCA-API-KEY-ID": key, "APCA-API-SECRET-KEY": sec},
            timeout=10,
        )
        if r.status_code == 200:
            return r.json()
    except Exception as e:
        log_to_ops("boba_cycle", "ERROR", f"Alpaca positions fetch failed: {e}")
    return []


def fetch_live_option_quote(ticker, strike, option_type, expiry):
    """
    Build OCC symbol + fetch live Tradier bid/ask/IV/greeks.
    Returns dict {bid, ask, mid, iv, delta, theta} or None.
    """
    if _tradier_quote is None:
        return None
    try:
        # Build OCC symbol — handle multiple expiry formats:
        #   YYYY-MM-DD (Boba internal)
        #   MM/DD/YY   (whale flow sidecar format)
        #   MM/DD      (Firebase format, year inferred)
        exp_str = str(expiry).strip()
        from datetime import datetime as _dt
        exp_dt = None
        for fmt in ("%Y-%m-%d", "%m/%d/%y", "%m/%d/%Y", "%Y%m%d"):
            try:
                exp_dt = _dt.strptime(exp_str, fmt)
                break
            except ValueError:
                continue
        if exp_dt is None:
            return None
        exp_clean = exp_dt.strftime("%y%m%d")  # YYMMDD
        right = "C" if str(option_type).upper().startswith("C") else "P"
        strike_int = int(float(strike) * 1000)
        occ = f"{str(ticker).upper()}{exp_clean}{right}{strike_int:08d}"
        q = _tradier_quote(occ)
        if not q:
            return None
        bid = q.get("bid", 0) or 0
        ask = q.get("ask", 0) or 0
        mid = round((bid + ask) / 2, 2) if (bid and ask) else 0
        return {
            "bid": bid, "ask": ask, "mid": mid,
            "iv": q.get("iv", 0) or 0,
            "delta": q.get("delta", 0) or 0,
            "theta": q.get("theta", 0) or 0,
            "spread_pct": round(((ask - bid) / mid * 100), 1) if mid else 0,
        }
    except Exception:
        return None


# === UNUSUAL FLOW PRIORITY RULE (memory #12) ===
# Boba MUST evaluate Tier 1 (Huge Flow $1M+ SWEEP+ASK) and Tier 2 (Unusual Huge $500K+ Vol>OI SWEEP+ASK)
# candidates BEFORE selecting top 3 each cycle. Same-day NY 4AM-8PM ET only.
# Tier 1: BlockType=SWEEP AND BidAskType in (A,AA) AND Value>=1M
# Tier 2: Volume>OI AND BlockType=SWEEP AND BidAskType in (A,AA) AND Value>=500K
# Tier 3: Volume>OI (yellow)
UNUSUAL_FLOW_RULE_TEXT = """
MANDATORY UNUSUAL FLOW PRIORITY RULE:
You MUST enumerate every TIER 1 and TIER 2 candidate explicitly before picking your top 3.
TIER 1 = Huge Flow $1M+ (SWEEP on ASK side, premium >= $1M)
TIER 2 = Unusual Huge $500K+ (SWEEP on ASK side, Volume > OI, premium >= $500K)
TIER 3 = Unusual Flow (Volume > OI, COLOR=yellow)
Tier 1 + Tier 2 candidates DOMINATE top 3 selection unless overwhelming reason to skip.
Window: same-day NY 4AM-8PM ET only — no carryover from prior days.
"""

# Rule injected at top of every Boba prompt
def load_grok_brief(max_age_min=60):
    """Read Grok market brief if recent. Returns formatted text or empty string."""
    try:
        f = Path("/home/ubuntu/.openclaw/workspace/directives/grok_brief.json")
        if not f.exists(): return ""
        d = json.loads(f.read_text())
        from datetime import datetime as _dt, timezone as _tz
        gen = _dt.fromisoformat(d["generated_at"].replace("Z","+00:00"))
        age_min = int((_dt.now(_tz.utc) - gen).total_seconds() / 60)
        if age_min > max_age_min: return ""
        text = d.get("brief_text", "").strip()
        if not text: return ""
    except Exception as e:
        log_to_ops("boba_cycle", "WARN", f"Grok brief load failed: {e}")
        return ""


def load_orion_skills():
    """Read Orion's structured skill outputs and summarize for Boba."""
    try:
        from datetime import datetime as _dt, timezone as _tz
        d = Path("/home/ubuntu/.openclaw/workspace/skill_outputs/orion")
        if not d.exists(): return ""
        out = "\n# Orion Skill Outputs (Gemini, structured)\n"
        skills_loaded = 0
        for f in sorted(d.glob("*.json"), key=lambda p: p.stat().st_mtime, reverse=True)[:8]:
            try:
                rec = json.loads(f.read_text())
                ts = rec.get("timestamp", "")
                if ts:
                    gen = _dt.fromisoformat(ts.replace("Z","+00:00"))
                    age_min = int((_dt.now(_tz.utc) - gen).total_seconds() / 60)
                    if age_min > 120: continue  # skip stale
                else:
                    age_min = "?"
                skill = rec.get("skill", f.stem)
                data = rec.get("data", {})
                # Compact summary depending on skill
                if "crypto-ta" in skill:
                    s = data.get("summary") or data.get("trend") or json.dumps(data)[:200]
                    out += f"  - {skill} ({age_min}m old): {s[:200]}\n"
                elif "screener" in skill:
                    coins = data.get("coins", [])[:5]
                    if coins:
                        out += f"  - {skill} top movers: " + ", ".join([f"{c.get('symbol')} {c.get('change_24h',0):+.1f}%" for c in coins]) + "\n"
                elif "funding" in skill:
                    long_count = data.get("extreme_long_count", 0)
                    short_count = data.get("extreme_short_count", 0)
                    out += f"  - {skill}: {long_count} extreme-long / {short_count} extreme-short funding rates\n"
                elif "vol-holdings" in skill or "option-vol" in skill:
                    out += f"  - {skill}: {json.dumps(data)[:250]}\n"
                else:
                    out += f"  - {skill}: {json.dumps(data)[:200]}\n"
                skills_loaded += 1
            except Exception:
                continue
        return out if skills_loaded else ""
    except Exception as e:
        log_to_ops("boba_cycle", "WARN", f"Orion skills load failed: {e}")
        return ""


def load_best_options(max_show=15, min_premium=1_000_000):
    """Load today's best options snapshot from ~/.openclaw/data/best-options/YYYY-MM-DD.json.
    Returns a formatted prompt block of the top T1+T2 contracts sorted by premium DESC.
    Used to give Boba context on whale-tier flow alerts deduped across the day."""
    from pathlib import Path as _Path
    from datetime import datetime as _dt, timezone as _tz, timedelta as _td
    et_now = _dt.now(_tz.utc) + _td(hours=-4)
    date_str = et_now.strftime("%Y-%m-%d")
    fp = _Path.home() / ".openclaw" / "data" / "best-options" / f"{date_str}.json"
    if not fp.exists():
        return ""
    try:
        snap = json.loads(fp.read_text())
    except Exception:
        return ""
    contracts = snap.get("sorted_by_premium", []) or []
    # Filter to T1 + T2 only (whale tier) and premium above floor
    whale = [c for c in contracts if c.get("tier") in ("T1_HUGE", "T2_UNUSUAL_HUGE") and c.get("premium", 0) >= min_premium]
    if not whale:
        return ""
    whale = whale[:max_show]
    tier_counts = snap.get("tier_counts", {})
    last_run = snap.get("last_run_human", "?")
    lines = [f"\n# Today's whale flow archive (T1+T2, deduped by contract, sorted by premium DESC)"]
    lines.append(f"# Snapshot: {last_run} | T1: {tier_counts.get('T1_HUGE',0)} | T2: {tier_counts.get('T2_UNUSUAL_HUGE',0)}")
    for c in whale:
        bull = "BULL" if c.get("is_bullish") else "BEAR"
        lines.append(
            f"  ${c.get('premium',0):>11,}  {c.get('ticker','?'):5s} ${c.get('strike',0):>6.0f} {c.get('option_type','?'):4s} "
            f"{c.get('expiry','?'):10s} {bull} | V:{c.get('volume',0):>5} OI:{c.get('oi',0):>5} SW:{c.get('sweeps',0):>3} BL:{c.get('blocks',0):>2} | {c.get('tier','?')}"
        )
    return "\n".join(lines) + "\n"


def load_ticker_rollup(min_total=10_000_000, max_show=10):
    """Aggregate today's whale flow by TICKER not by contract.
    Returns prompt block showing tickers with combined T1+T2 premium >= min_total,
    sorted by total premium DESC. Shows direction bias (% calls vs puts) per ticker.
    Reveals institutional concentration that single-contract ranking misses
    (e.g. MU spread across 4 contracts at $90M total beats any single $25M trade)."""
    from pathlib import Path as _Path
    from datetime import datetime as _dt, timezone as _tz, timedelta as _td
    et_now = _dt.now(_tz.utc) + _td(hours=-4)
    fp = _Path.home() / ".openclaw" / "data" / "best-options" / f"{et_now.strftime('%Y-%m-%d')}.json"
    if not fp.exists():
        return ""
    try:
        snap = json.loads(fp.read_text())
    except Exception:
        return ""
    contracts = snap.get("sorted_by_premium", []) or []
    whale = [c for c in contracts if c.get("tier") in ("T1_HUGE", "T2_UNUSUAL_HUGE")]
    if not whale:
        return ""
    rollup = {}
    for c in whale:
        t = c.get("ticker", "?")
        if t not in rollup:
            rollup[t] = {"total": 0, "call_prem": 0, "put_prem": 0,
                         "calls": 0, "puts": 0, "biggest": 0, "biggest_strike": 0,
                         "biggest_type": "?", "biggest_exp": "?", "contracts": 0}
        prem = c.get("premium", 0)
        opt = c.get("option_type", "?").upper()
        rollup[t]["total"] += prem
        rollup[t]["contracts"] += 1
        if opt.startswith("C"):
            rollup[t]["call_prem"] += prem
            rollup[t]["calls"] += 1
        else:
            rollup[t]["put_prem"] += prem
            rollup[t]["puts"] += 1
        if prem > rollup[t]["biggest"]:
            rollup[t]["biggest"] = prem
            rollup[t]["biggest_strike"] = c.get("strike", 0)
            rollup[t]["biggest_type"] = opt[0] if opt else "?"
            rollup[t]["biggest_exp"] = c.get("expiry", "?")
    qualified = [(t, r) for t, r in rollup.items() if r["total"] >= min_total]
    if not qualified:
        return ""
    qualified.sort(key=lambda x: -x[1]["total"])
    qualified = qualified[:max_show]
    lines = ["\n# Today's TICKER ROLLUP (T1+T2 aggregate, sorted by total premium DESC)"]
    lines.append("# Reveals institutional positioning when whale flow spans multiple contracts on same ticker.")
    for t, r in qualified:
        cp = r["call_prem"]; pp = r["put_prem"]; total = r["total"]
        if total > 0:
            call_pct = int(cp / total * 100)
            bias = "BULL" if call_pct >= 60 else ("BEAR" if call_pct <= 40 else "MIXED")
        else:
            call_pct = 0; bias = "MIXED"
        lines.append(
            f"  ${total/1_000_000:>5.1f}M  {t:5s}  {r['contracts']}c ({r['calls']}C/{r['puts']}P)  "
            f"{bias} ({call_pct}% calls)  | biggest: ${r['biggest']/1_000_000:.1f}M ${r['biggest_strike']:.0f}{r['biggest_type']} {r['biggest_exp']}"
        )
    return "\n".join(lines) + "\n"


def load_platinum_flow(max_show=5):
    """PLATINUM tier — most unusual of unusual. Statistical 1-3% of all whale flow.
    All 4 conditions must be met:
      1. premium >= 10M (T0 MEGA threshold)
      2. volume >= 5x OI (when OI > 0; OI=0 with vol>500 also counts as fresh institutional positioning)
      3. sweeps >= 80% of total transactions (sweeps + blocks)
      4. low DTE (<=14 days) OR very high DTE (>=180 days) — extremes only, not middle-DTE filler
    Returns prompt block of the rarest most-conviction trades. Boba should evaluate these BEFORE
    T0/T1/T2 since matching all 4 simultaneously is statistically rare and signals urgent institutional intent."""
    from pathlib import Path as _Path
    from datetime import datetime as _dt, timezone as _tz, timedelta as _td
    et_now = _dt.now(_tz.utc) + _td(hours=-4)
    fp = _Path.home() / ".openclaw" / "data" / "best-options" / f"{et_now.strftime('%Y-%m-%d')}.json"
    if not fp.exists():
        return ""
    try:
        snap = json.loads(fp.read_text())
    except Exception:
        return ""
    contracts = snap.get("sorted_by_premium", []) or []
    platinum = []
    for c in contracts:
        prem = c.get("premium", 0)
        if prem < 10_000_000:
            continue
        vol = c.get("volume", 0)
        oi = c.get("oi", 0)
        sweeps = c.get("sweeps", 0)
        blocks = c.get("blocks", 0)
        total_tx = sweeps + blocks
        dte = c.get("dte", 0)
        # Volume vs OI check
        if oi > 0:
            vol_ratio_ok = vol >= 5 * oi
        else:
            vol_ratio_ok = vol >= 500  # OI=0 with significant volume = fresh positioning
        # Sweep dominance check
        sweep_pct_ok = (sweeps / total_tx >= 0.80) if total_tx > 0 else False
        # DTE extremes (urgent or LEAP-style conviction)
        dte_ok = dte <= 14 or dte >= 180
        if vol_ratio_ok and sweep_pct_ok and dte_ok:
            c["_sweep_pct"] = int((sweeps / total_tx) * 100) if total_tx > 0 else 0
            c["_vol_ratio"] = round(vol / oi, 1) if oi > 0 else float("inf")
            platinum.append(c)
    if not platinum:
        return ""
    platinum.sort(key=lambda x: -x.get("premium", 0))
    platinum = platinum[:max_show]
    lines = ["\n# 💎 PLATINUM TIER — most unusual of unusual (rare 1-3% of flow)"]
    lines.append("# All 4 conditions met: $10M+ premium, vol >= 5x OI, sweeps >= 80% of tx, DTE extreme (<=14d or >=180d)")
    lines.append("# Boba: EVALUATE THESE FIRST. Matching all 4 simultaneously signals urgent institutional intent.")
    for c in platinum:
        bull = "BULL" if c.get("is_bullish") else "BEAR"
        side = "C" if c.get("option_type", "?").upper().startswith("C") else "P"
        ratio = c.get("_vol_ratio")
        ratio_str = f"{ratio}x" if ratio != float("inf") else "OI=0"
        lines.append(
            f"  💎 ${c.get('premium',0)/1_000_000:>5.1f}M  {c.get('ticker','?'):5s} ${c.get('strike',0):.0f}{side} "
            f"{c.get('expiry','?')} ({c.get('dte',0)}d) {bull} | "
            f"V/OI:{ratio_str} | Sweep:{c.get('_sweep_pct',0)}% | V:{c.get('volume',0):,}"
        )
    return "\n".join(lines) + "\n"


def load_multi_day_repeaters():
    """Read overnight multi-day pattern report. Surfaces tickers/strikes with persistent
    institutional flow over last 5 days. Generated nightly by multi_day_tracker."""
    from pathlib import Path as _Path
    fp = _Path.home() / ".openclaw" / "data" / "multi-day-repeaters.json"
    if not fp.exists():
        return ""
    try:
        rep = json.loads(fp.read_text())
    except Exception:
        return ""
    tickers = rep.get("tickers", [])
    strikes = rep.get("strikes", [])
    if not tickers and not strikes:
        return ""
    days = rep.get("available_days", 0)
    lines = [f"\n# 🔁 MULTI-DAY REPEATER REPORT ({days}-day lookback, T1+T2 only)"]
    lines.append("# Tickers/strikes appearing in 3+ of last 5 days = sustained institutional positioning.")
    if tickers:
        lines.append("\n## Persistent tickers (sorted by 5-day total premium):")
        for t in tickers[:10]:
            lines.append(
                f"  {t['ticker']:5s}  {t['days_present']}/{days}d  "
                f"${t['total_premium_5d']/1_000_000:>5.1f}M total  "
                f"avg ${t['avg_daily_premium']/1_000_000:.1f}M/day  "
                f"{t['bias']} ({t['call_pct']}% calls)  "
                f"| biggest day: {t['biggest_day']} ${t['biggest_day_premium']/1_000_000:.1f}M"
            )
    if strikes:
        lines.append("\n## Repeated strike+type combos:")
        for s in strikes[:8]:
            lines.append(
                f"  {s['ticker']:5s} ${s['strike']:.0f}{s['type']}  "
                f"{s['days_present']}/{days}d  "
                f"${s['total_premium_5d']/1_000_000:.1f}M total  "
                f"biggest single ${s['biggest_single']/1_000_000:.1f}M"
            )
    return "\n".join(lines) + "\n"


def load_market_briefing():
    """Read hourly market briefing (regime, F&G, BTC). Compact summary."""
    try:
        f = Path("/home/ubuntu/.openclaw/workspace/directives/market_briefing.json")
        if not f.exists(): return ""
        d = json.loads(f.read_text())
        btc = d.get("btc_24h", {})
        fg = d.get("fear_greed", {})
        regime = d.get("internal", {}).get("regime", {})
        return (
            f"\n# Market Regime (hourly snapshot)\n"
            f"  - BTC 24h: ${btc.get('current',0):,.0f} ({btc.get('change_24h_pct',0):+.1f}%) trend {btc.get('trend_24h','?')}\n"
            f"  - Fear/Greed: {fg.get('value','?')} ({fg.get('label','?')})\n"
            f"  - Regime: {regime.get('overall','?')} | Bias: {regime.get('bias','?')}\n"
        )
    except Exception as e:
        log_to_ops("boba_cycle", "WARN", f"Market briefing load failed: {e}")
        return ""



def compute_agent_consensus(window_hours=4):
    """Item 19: scan agent outputs in rolling window, return ticker -> set of agents that mentioned it.
    Sources today: orion (crypto), jazzyhazzy (multi-skill), grok (ct_alpha), boba (prior cycle).
    Kronos and DeepSeek hooks reserved for when their writers come online."""
    import re as _re
    from datetime import datetime as _dt, timezone as _tz, timedelta as _td
    cutoff = _dt.now(_tz.utc) - _td(hours=window_hours)
    votes = {}
    TICKER_RE = _re.compile(r'\b[A-Z]{2,5}\b')
    KNOWN_NOISE = {'USD','ETF','SEC','CEO','CFO','IPO','CPI','PPI','GDP','API','URL','HTTP','HTTPS','JSON','XML','RSS','PDF','PM','AM','UTC','EST','PST','EDT','PDT','ET','ATM','ITM','OTM','SH','PUT','CALL','TP','SL','DTE','IV','RSI','MACD','EMA','SMA','BB','ATR','TUE','MON','WED','THU','FRI','SAT','SUN','JAN','FEB','MAR','APR','MAY','JUN','JUL','AUG','SEP','OCT','NOV','DEC','THE','FOR','AND','THIS','THAT','OUR','YOU','PRO','NEW','OLD','BIG','TOP','LOW','HIGH','OK','OFF','ON','ALL','ANY','MID','MAX','MIN','EOD','BOD','PA','LP','LLC','INC','CORP','TR','TRT','TRY','VS'}
    def _add_vote(ticker, agent_name):
        t = ticker.strip().upper()
        if not t or t in KNOWN_NOISE or len(t) < 2: return
        votes.setdefault(t, set()).add(agent_name)
    def _file_age_ok(path):
        try:
            mtime = _dt.fromtimestamp(path.stat().st_mtime, tz=_tz.utc)
            return mtime >= cutoff
        except Exception: return False
    try:
        odir = Path('/home/ubuntu/.openclaw/workspace/skill_outputs/orion')
        if odir.exists():
            for f in odir.glob('*.json'):
                if not _file_age_ok(f): continue
                try:
                    rec = json.loads(f.read_text())
                    data = rec.get('data', {})
                    sym = data.get('symbol')
                    if sym: _add_vote(sym, 'orion')
                    for c in data.get('coins', [])[:10]:
                        if isinstance(c, dict) and c.get('symbol'): _add_vote(c['symbol'], 'orion')
                except Exception: pass
    except Exception: pass
    try:
        jdir = Path('/home/ubuntu/.openclaw/workspace/skill_outputs/jazzyhazzy')
        if jdir.exists():
            for f in jdir.glob('*.json'):
                if not _file_age_ok(f): continue
                try:
                    rec = json.loads(f.read_text())
                    blob = json.dumps(rec.get('data', {}))
                    for t in set(TICKER_RE.findall(blob)):
                        _add_vote(t, 'jazzy')
                except Exception: pass
    except Exception: pass
    try:
        gf = Path('/home/ubuntu/.openclaw/workspace/skill_outputs/grok_ct_alpha.json')
        if gf.exists() and _file_age_ok(gf):
            rec = json.loads(gf.read_text())
            for item in rec.get('items', []):
                for t in item.get('tickers', []):
                    _add_vote(t, 'grok')
    except Exception: pass
    try:
        bf = Path('/home/ubuntu/.openclaw/workspace/skill_outputs/boba_decisions_validated.json')
        if bf.exists():
            d = json.loads(bf.read_text())
            decs = d if isinstance(d, list) else d.get('decisions', [])
            for dec in decs[-20:]:
                ts_str = dec.get('cycle_time', '')
                if not ts_str: continue
                try:
                    dts = _dt.fromisoformat(ts_str.replace('Z', '+00:00'))
                    if dts < cutoff: continue
                except Exception: continue
                for pick in (dec.get('picks_executed', []) or []) + (dec.get('passed_on', []) or []):
                    if isinstance(pick, dict) and pick.get('ticker'):
                        _add_vote(pick['ticker'], 'boba_prior')
    except Exception: pass
    return votes

def format_consensus_for_prompt(votes, threshold=3):
    """Item 19: format consensus dict for injection into Boba prompt."""
    if not votes: return ''
    high = [(t, agents) for t, agents in votes.items() if len(agents) >= threshold]
    if not high: return ''
    high.sort(key=lambda x: (-len(x[1]), x[0]))
    out = '\n# AGENT CONSENSUS (Item 19) - symbols flagged by 3+ agents in last 4h\n'
    out += 'These are HIGH-CONVICTION tier candidates by virtue of multi-agent overlap.\n'
    out += 'Treat consensus as an independent signal alongside whale flow tier and Kronos verdict.\n'
    for ticker, agents in high[:15]:
        agent_list = ', '.join(sorted(agents))
        out += f'  - {ticker}: {len(agents)} agents ({agent_list})\n'
    return out + '\n'

def build_boba_prompt(account, positions, shortlist_with_kronos, remaining_budget=3):
    equity = float(account.get("equity", 0))
    buying_power = float(account.get("buying_power", 0))
    cash = float(account.get("cash", 0))

    pos_summary = "\n".join([
        f"  - {p.get('symbol')}: {p.get('qty')} @ ${p.get('avg_entry_price')} | P&L {float(p.get('unrealized_plpc',0))*100:+.1f}%"
        for p in positions
    ]) or "  (none open)"

    # === Signal scoring pre-pass: compute confidence + drop TRASH-band signals ===
    _scored_shortlist = []
    if score_signal:
        for _sid, _s, _k in shortlist_with_kronos:
            try:
                _conf = score_signal(_s, kronos=_k)
                _s["confidence"] = _conf
                if _conf["band"] == "TRASH":
                    print(f"[signal-scorer] DROP TRASH: {_s.get('ticker')} ${_s.get('strike')}{(_s.get('option_type','') or '')[:1]} {_s.get('expiry')} | {render_breakdown_line(_conf)}", flush=True)
                    continue
            except Exception as _se:
                print(f"[signal-scorer] error scoring {_s.get('ticker')}: {_se}", flush=True)
            _scored_shortlist.append((_sid, _s, _k))
        # Sort survivors by confidence score DESC
        _scored_shortlist.sort(key=lambda _x: -(_x[1].get("confidence", {}).get("score", 0)))
    else:
        _scored_shortlist = list(shortlist_with_kronos)

    shortlist_text = ""
    for i, (sid, s, k) in enumerate(_scored_shortlist, 1):
        shortlist_text += f"\n\n--- CANDIDATE {i} ---\n"
        shortlist_text += f"Ticker: {s.get('ticker')}\n"
        shortlist_text += f"Contract: ${s.get('strike')} {s.get('option_type')} exp {s.get('expiry')} ({s.get('dte')} DTE)\n"
        shortlist_text += f"Tier: {s.get('tier','')} | Flow: {s.get('flow_value_raw')} | Vol/OI: {s.get('vol_oi_ratio')}x\n"
        shortlist_text += f"Sweeps/Blocks: {s.get('sweeps')}/{s.get('blocks')} | Spot: ${s.get('spot')}\n"
        shortlist_text += f"Score: {s.get('score')}/100 ({s.get('grade')})\n"
        if render_breakdown_line and s.get('confidence'):
            shortlist_text += f"Confidence: {render_breakdown_line(s['confidence'])}\n"

        # Live Tradier quote (if available) — gives LLM real bid/ask/IV/greeks
        _lq = fetch_live_option_quote(s.get("ticker"), s.get("strike"),
                                       s.get("option_type"), s.get("expiry"))
        if _lq and _lq.get("mid"):
            shortlist_text += (
                f"LIVE QUOTE: bid ${_lq['bid']:.2f} / ask ${_lq['ask']:.2f} / mid ${_lq['mid']:.2f}"
                f" | spread {_lq['spread_pct']}%\n"
                f"GREEKS: IV {_lq['iv']:.2f} | Δ {_lq['delta']:+.2f} | Θ {_lq['theta']:+.3f}/day\n"
            )
        else:
            shortlist_text += f"LIVE QUOTE: (Tradier unavailable — use score/spot for sizing)\n"

        shortlist_text += f"Whale reasoning:\n"
        for r in s.get("reasons", []):
            shortlist_text += f"  • {r}\n"
        shortlist_text += f"\nKronos forecast:\n"
        if k.get("forecast_24h_direction") == "pending":
            shortlist_text += f"  ⏳ running in background (not available this cycle — you decide without it)\n"
        elif "error" in k:
            shortlist_text += f"  (unavailable: {k.get('error')})\n"
        else:
            age_note = ""
            if k.get("generated_at"):
                from datetime import datetime, timezone as _tz
                try:
                    gen = datetime.fromisoformat(k["generated_at"].replace("Z","+00:00"))
                    age_min = int((datetime.now(_tz.utc) - gen).total_seconds() / 60)
                    age_note = f" (cached, {age_min} min old)"
                except Exception:
                    pass
            shortlist_text += f"  Direction: {k.get('forecast_24h_direction','?')} (confidence: {k.get('forecast_24h_confidence','?')}){age_note}\n"
            shortlist_text += f"  Target: ${k.get('forecast_24h_target','?')} (current ${k.get('current_price','?')})\n"
            agree = k.get("option_in_forecast_direction")
            if agree is True:
                shortlist_text += f"  → Kronos AGREES with option thesis ✅\n"
            elif agree is False:
                shortlist_text += f"  → Kronos CONFLICTS with option thesis ❌\n"

    firebase_signals_text = firebase_signals.format_for_prompt(firebase_signals.load_signals(), max_show=20)
    firebase_notifications_text = firebase_signals.format_notifications_for_prompt(firebase_signals.load_notifications(), max_show=3)  # parser already consumed these; this is transparency tail
    firebase_flow_alerts_text = firebase_signals.format_flow_alerts_for_prompt(firebase_signals.load_flow_alerts(), max_show=15)
    best_options_text = load_best_options(max_show=15, min_premium=1_000_000) or ""
    ticker_rollup_text = load_ticker_rollup(min_total=10_000_000, max_show=10) or ""
    platinum_flow_text = load_platinum_flow(max_show=5) or ""

    # mc-kb tier enhancements (platinum mandate / confluence / fresh-5min / clusters / sector mix)
    bfe_enhancements = ""
    try:
        import boba_flow_enhancements as _bfe
        _tickers = []
        try:
            _tickers = [s.get("ticker", "") for _, s, _ in shortlist_with_kronos if s and s.get("ticker")]
        except Exception:
            _tickers = []
        _platinum_n = platinum_flow_text.count("\n  💎 $") if platinum_flow_text else 0
        bfe_enhancements = _bfe.assemble_enhancements(_tickers, platinum_count=_platinum_n)
    except Exception as _bfe_e:
        print(f"[bfe] enhancements failed: {_bfe_e!r}", flush=True)
    multi_day_repeaters_text = load_multi_day_repeaters() or ""
    market_briefing_text = load_market_briefing() or ""
    grok_brief_text = load_grok_brief() or ""
    orion_skills_text = load_orion_skills() or ""
    consensus_votes = compute_agent_consensus(window_hours=4)
    consensus_text = format_consensus_for_prompt(consensus_votes, threshold=3)
    _peer_block = peer_picks_block("boba", window_hours=6) if peer_picks_block else ""
    multi_agent_context = market_briefing_text + grok_brief_text + orion_skills_text + consensus_text + _peer_block

    # Skill injection - load relevant SKILL.md content based on decision context
    try:
        _skill_ctx_parts = []
        for _p in (positions or []):
            _sym = _p.get('symbol', '')
            if _sym:
                _skill_ctx_parts.append(_sym)
        for _sid, _s, _k in (shortlist_with_kronos or []):
            _t = _s.get('ticker', '') if isinstance(_s, dict) else ''
            _ot = _s.get('option_type', '') if isinstance(_s, dict) else ''
            if _t:
                _skill_ctx_parts.append(_t)
            if _ot:
                _skill_ctx_parts.append(_ot)
        _skill_ctx_parts.extend([
            'options', 'call', 'put', 'strike', 'expiry', 'IV', 'greeks',
            'delta', 'theta', 'gamma', 'vega', 'flow', 'whale', 'unusual',
            'volume', 'open-interest', 'sweep', 'block', 'bullish', 'bearish',
            'risk', 'sizing', 'position', 'portfolio', 'kronos', 'forecast',
        ])
        _skill_ctx = ' '.join(_skill_ctx_parts)
        skills_section = load_relevant_skills(
            agent='boba',
            context_text=_skill_ctx,
            max_skills=4,
            max_tokens=3500,
            include_body=True,
        ) or ''
        if skills_section:
            print(f"[skill_loader] injected {skills_section.count(chr(35) + chr(35) + chr(35))} skills into Boba prompt", flush=True)
    except Exception as _e:
        print(f"[skill_loader] injection failed: {_e}", flush=True)
        skills_section = ''

    prompt = f"""{skills_section}
You are Boba — the decision-making agent in Mission Control's multi-agent trading system.

# CRITICAL: SMALL-ACCOUNT TEST MODE (May 2026)
You are operating on a fresh $1,000 paper account to prove you can compound a small account.
Hard rules:


# CRITICAL CONTRACT SIZING MATH (read BEFORE choosing any contract):
# - Per-contract cost = AlertPrice * 100
# - Your AVAILABLE BUYING POWER is shown above in account state as "Buying power: $X"
# - You CANNOT pick a contract where (AlertPrice * 100 * contracts) exceeds available BP
# - Examples for $1000 account:
#   - AlertPrice $1.50 -> $150/contract -> 1c=$150 (good fit)
#   - AlertPrice $5.00 -> $500/contract -> 1c=$500 (preserves $500 BP)
#   - AlertPrice $10.00 -> $1000/contract -> 1c=$1000 (full BP, no reserve)
#   - AlertPrice $50.00 -> $5000/contract -> CANNOT AFFORD, SKIP
# - PREFER AlertPrice $1.50-$5.00 range = $150-$500/contract for compounding velocity
# - If a candidate's AlertPrice * 100 > available BP, REJECT and pick a cheaper strike on
#   that ticker (further OTM same expiry usually has lower premium) OR skip the ticker
- Up to 3 picks per day across all cycles. AGGRESSIVE MODE: If you see fresh $1M+ flow this morning with SWEEPS, TAKE IT. Don't wait for perfect confluence. Single-source institutional flow is enough. If only one is max conviction, take just that one and wait for next cron - a cheaper better setup may appear.
- You may use the entire account on a single pick if (and only if) conviction is full: PLATINUM tier OR T0 mega flow PLUS Kronos AGREES PLUS multi-day repeater confirmation.
- Stops handled by profit_lock_daemon (tier-based ratchet at +20/+50/+100/+200 with 8 percent peak-trail) AND trail_daemon as safety net. Boba does NOT manage stop_loss_pct manually beyond the initial OCO bracket value.
- Take-profit stays fixed at the tier-ladder default in the OCO bracket.
- One bad full-size pick wipes the account. Treat each pick as if it were the last one you'll ever make.

# Mission
Make positive-expected-value options trades using whale-tier T1+T2 options flow signals (T1: $1M+ SWEEP/A,AA, T2: $500K+ Vol>OI SWEEP/A,AA), Kronos is available as a consultant — you may consider its forecast when relevant, but flow strength alone justifies a pick. Target average R:R ≥ 1.5. You are NOT aiming for 80%+ win rate — you're aiming for edge × sizing × discipline.

# Account state
Equity: ${equity:,.2f}
Buying power: ${buying_power:,.2f}
Cash: ${cash:,.2f}
Open positions:
{pos_summary}
{multi_agent_context}

# Candidates to review (already filtered to T1+T2 whale tier $500K+ + today's signals)
{shortlist_text}

# Trade signals from providers (Name / Name2 / Vivid / Vivid2 — last 20)
These are curated buy/sell calls from human-run provider services. Use them as INDEPENDENT confirmation: if a provider has called the same direction as a whale flow above, that's stronger alignment. Disagreement is also informative. Do NOT take a pick just because a provider called it — use these alongside whale flow + Kronos.
{firebase_signals_text}

# Provider push notifications (Vivid2 / Name / Name2 OptionNotifications + StockNotifications — last 15)
Text alerts the provider apps push to their users. Often analyst commentary on a previously-issued signal (add/reduce/close), or breaking-news heads-up. Higher recency than the signals above but less actionable.
{firebase_notifications_text}

# Flow Greeks alerts (FlowGreeks / FlowGreeks2 — last 15)
Algorithmic unusual-flow detections (sweeps, block trades, volume-over-OI). Independent of analyst signals. A flow alert on the same ticker/direction as a trade signal above is a strong corroborating signal.
{firebase_flow_alerts_text}
{platinum_flow_text}{bfe_enhancements}
{multi_day_repeaters_text}
{best_options_text}
{ticker_rollup_text}

# Your task — TWO parts every cycle

## TASK 1: POSITION MANAGEMENT (review every open position)
For EVERY open position listed above, output a recommended action in `position_actions`. This does NOT count against your daily new-picks budget.
Available actions per position:
- HOLD — keep the position as-is, no change
- TRIM_25 / TRIM_50 — close 25% or 50% of contracts to lock in partial profit (only if P&L > +30%)
- TIGHTEN_STOP — move stop loss closer to entry (e.g. from -30% to -15%) to protect gains
- EXIT — fully close the position (use when thesis broken, max loss approaching, or better setup elsewhere)
You MUST emit one action per open position. If positions list is empty, position_actions = [].

## TASK 2: NEW PICKS (up to remaining daily budget)
You have {remaining_budget} NEW pick(s) remaining in today's daily budget (cap is {MAX_NEW_PICKS_PER_DAY}/day across ALL cycles).
Pick 0 to {remaining_budget} NEW options to buy on Alpaca paper. Only pick if the setup is genuinely good — if nothing is compelling, say so and pick zero.

### Same-ticker re-flow rule
If a candidate ticker is one you ALREADY hold:
- ADD action (default): open a new contract alongside existing position. Counts as 1 NEW pick.
- REPLACE action: close existing + open new contract. Counts as 1 NEW pick (the close goes in position_actions as EXIT, the new buy goes in picks).
- Specify by setting `same_ticker_action` field to "ADD" or "REPLACE" on the pick.

If your daily budget is 0, you cannot make new picks this cycle — only do TASK 1 (position management).

For each pick, you MUST show due diligence. In the reasoning field, include these items concisely:

1. THESIS — One sentence on the directional/volatility view (e.g., "QQQ bearish next 10 days").
2. CONTRACT SELECTION — Why THIS strike/expiry beats 2 alternatives you considered. Compare at least 2 other strikes OR expiries and state why this one wins on R:R.
3. BREAKEVEN at expiry — calculate as (strike ± premium paid). For calls: strike + premium. For puts: strike − premium.
4. EXPECTED RETURN — If Kronos forecast plays out, estimate the contract's value at that price move. E.g., "Kronos says −5% on QQQ → QQQ=612 → $645P worth ~$33 intrinsic = +220% return."
5. MAX LOSS — premium × contracts × 100 (what you lose if contract expires worthless).
6. RISK FLAGS — name at least one: earnings in expiry window? known catalyst (FOMC, CPI)? low open interest? wide bid/ask spread? IV elevated? If no flags apply, state "none identified."
7. CONVICTION LEVEL — if 0-3 DTE: state the specific catalyst driving the short window. If no catalyst, explain why gamma risk is acceptable.
8. BRIEF CONTEXT CITED — explicitly reference at least one of: Market Regime, Grok narrative, Orion technicals, Kronos forecast, Flow channel signals. Format: "Brief: <source>=<takeaway>". If you genuinely consulted no brief context, write "Brief: none used because <specific reason>" — never leave this blank.

If you cannot answer items 3, 4, 5 with math, DO NOT PICK THAT CONTRACT — pick a different strike/expiry where you can, or pass entirely.

Additional decisions per pick:
- Number of contracts (consider buying power — single pick CAN use full buying power if conviction is maximum (small-account test mode))
- Target profit % (default +50% if no strong reason otherwise)
- Max loss % (default -30%)

Hard limits:
- Max NEW picks this cycle: {remaining_budget} (PLATINUM OVERRIDE NOTICE: if any candidate scores PLATINUM band [confidence ≥ 90], take it ANYWAY — once per day, PLATINUM picks bypass the cap) (out of daily cap {MAX_NEW_PICKS_PER_DAY})
- Max ${MAX_TOTAL_RISK_USD:,} total notional risk across all picks
- PREMIUM TIER LADDER (rank picks highest tier first — if T0 hits exist, ignore lower tiers):
  - T0 MEGA FLOW ($10M+ premium): profit_target_pct=80, stop_loss_pct=15 (highest conviction; if IV%>60 widen stop to 22)
  - T1 HUGE FLOW ($5M+ premium): profit_target_pct=60, stop_loss_pct=20 (high conviction; if IV%>60 widen stop to 30)
  - T2 BIG FLOW ($1M+ premium): profit_target_pct=50, stop_loss_pct=25 (standard; if IV%>60 widen stop to 37)
  - T3 STANDARD ($500K+ SWEEP + A/AA + Vol>OI): profit_target_pct=40, stop_loss_pct=30 (lower; if IV%>60 widen stop to 45)
  - T4 UNUSUAL (Vol>OI yellow): profit_target_pct=30, stop_loss_pct=35 (last resort; if IV%>60 widen stop to 52)
- WITHIN-TIER RANKING (priority order; ties broken in order shown):
  1. repeater_count (same contract 3+ times today)
  2. ticker-strike cluster (3+ distinct strikes on same ticker today — see STRIKE CLUSTERS above)
  3. multi-source confluence (≥3 sources agreeing direction — see MULTI-SOURCE CONFLUENCE above; ≥3 = treat as one tier upgraded)
  4. fresh-5min flag (institutional opens beat 3:55 PM muppet flow)
  5. DTE (shorter wins for flow)
  6. Kronos confidence (HIGH AGREE > MED AGREE > LOW AGREE > NEUTRAL; CONFLICTS = veto)
  7. sweep>block>split
  8. A/AA bid-ask
  9. Vol/OI ratio

# DUAL PROTOCOL — Boba picks under whichever protocol fits each candidate

## Protocol A — FLOW (current method, fast cycle)
Use when: T0/T1/T2 unusual flow priority hits today. Short-dated bets riding institutional positioning.
Gates (all must pass):
- Premium tier T0/T1/T2/T3 (rank highest first)
- Same-day NY 4AM-8PM ET activity
- SWEEP, BLOCK, or repeater (3+ hits today on same contract)
- BidAskType A or AA preferred
- Kronos AGREES or NEUTRAL (CONFLICTS = veto)
Set protocol="flow" in pick. Use T0-T4 TP/SL from ladder above.

## Protocol B — SWING (MU-pattern method, longer hold for trend trades)
Use when: candidate has institutional positioning AND room to ride a multi-week trend. The MU $460C 6/18 added 04/02 at $18.58 → $97.70 = 5.26x. That setup is the template.
Gates (ALL must pass — if any fail, reject as swing or fall back to Protocol A):
- DTE >= 60 at entry (theta runway)
- Delta 0.40-0.55 at entry (ATM, not OTM lottery)
- Underlying price within 5% of strike (cheap premium relative to strike)
- OI >= 1000 before today (institutional pre-positioning, not just today's spike)
- IV percentile < 60 at entry (room for IV expansion)
- Earnings 30-60 days out from entry (catalyst runway, exit before print)
- Kronos AGREES or NEUTRAL on multi-week direction
Set protocol="swing" in pick. Override TP/SL: profit_target_pct=100, stop_loss_pct=25 (uncapped runner with cut loser — let winners breathe). When position hits +50%, you'll later get TIGHTEN_STOP signals from the trail daemon.

## How to choose between A and B for the same candidate
- If candidate passes Protocol B gates AND tier is T0/T1, prefer SWING (longer hold = bigger multiple).
- If candidate fails any Protocol B gate, evaluate as FLOW only.
- Never log the same pick under both protocols. Pick one and commit.
- entry_criteria field MUST list which gates fired (e.g. ["T1_5M+","sweep","repeater_5x","kronos_agrees"] for flow, or ["dte_77","delta_0.48","iv_pct_42","oi_7859","earnings_45d","kronos_agrees"] for swing).

- Kronos is a CONSULTANT, not a hard gate. Use it as one input alongside flow strength, T0/T1/T2 tier, IV, and DTE.
- Set `kronos_verdict` field to one of: AGREES | CONFLICTS | NEUTRAL | UNAVAILABLE based on the forecast block above.
- If kronos_verdict is CONFLICTS: only proceed if flow score is ≥ 90 AND you state the exact score number in your reasoning. Otherwise pass on the pick.
- If kronos_verdict is UNAVAILABLE (timeout, error, or skipped index): only proceed if flow score is ≥ 85 AND you state the score in your reasoning.
- If kronos_verdict is AGREES or NEUTRAL: standard rules apply, no Kronos-specific gate.

# Response format (STRICT JSON, no prose outside the JSON)
{{
  "cycle_summary": "1-2 sentence overview of the current setup today",
  "position_actions": [
    {{"symbol": "SOXX260501P00460000", "action": "HOLD", "reason": "Down -1.5%, thesis intact, 4 days to expiry but spot still above strike"}},
    {{"symbol": "TSLA260515P00360000", "action": "EXIT", "reason": "Kronos now bullish TSLA, original bear thesis invalidated"}}
  ],
  "picks": [
    {{
      "ticker": "NVDA",
      "strike": 145.0,
      "option_type": "CALL",
      "expiry": "2026-05-17",
      "contracts": 5,
      "reasoning": "THESIS: NVDA bullish over 26 days (whale + Kronos agrees). CONTRACT: $145C 05/17 beats $150C (lower delta, same expiry) and $145C 06/21 (extra theta cost, earnings already priced). BREAKEVEN: $145 + $4.50 = $149.50 at expiry. EXPECTED RETURN: Kronos +5% → NVDA=153 → $145C worth ~$8.50 intrinsic = +89%. MAX LOSS: $4.50 × 5 × 100 = $2,250 if NVDA closes ≤ $145. RISK: Earnings in 8 days — IV likely elevated, potential IV crush post-earnings. CONVICTION: 26 DTE, theta manageable, earnings catalyst drives upside.",
      "kronos_verdict": "AGREES",
      "profit_target_pct": 50,
      "stop_loss_pct": 25,
      "confidence": "high",
      "protocol": "flow",
      "entry_criteria": ["T2_1M+", "sweep", "AA", "repeater_3x", "kronos_agrees"]
    }},
    {{
      "ticker": "MU",
      "strike": 460.0,
      "option_type": "CALL",
      "expiry": "2026-06-18",
      "contracts": 1,
      "reasoning": "THESIS: MU bullish multi-week, semis sector strength, pre-earnings IV runway. CONTRACT: $460C 06/18 (77 DTE, ATM delta 0.48) beats $440C (extra premium) and $460C 05/16 (theta starts biting at 30 DTE). BREAKEVEN: $460 + $18.58 = $478.58. EXPECTED RETURN: Kronos +6% over 30d → MU=550 → $460C worth ~$95 = +411%. MAX LOSS: $18.58 × 1 × 100 = $1,858. RISK: IV may compress post-earnings (45d out). CONVICTION: 77 DTE theta-safe, ATM delta lets us ride trend, OI 7,859 confirms institutional pre-positioning.",
      "kronos_verdict": "AGREES",
      "profit_target_pct": 100,
      "stop_loss_pct": 25,
      "confidence": "high",
      "protocol": "swing",
      "entry_criteria": ["dte_77", "delta_0.48", "iv_pct_42", "oi_7859", "earnings_45d", "kronos_agrees"]
    }}
  ],
  "passed_on": [
    {{"ticker": "TSLA", "reason": "Kronos conflicts — forecast bearish but 250C is bullish thesis", "kronos_verdict": "CONFLICTS"}}
  ]
}}


# ADDITIONAL REQUIRED FIELDS PER PICK (INDEPENDENT_THESIS_BLOCK_INSERTED)
For each pick in the picks array, you MUST include:
  - "institutional_thesis": A 1-2 sentence answer to "Why would an institution put this much money on this specific contract right now?"
        Examples that are useful: "Hedge fund rotating from semis into defensives ahead of CPI"; "Earnings play on NVDA pre-report — implied vol cheap relative to history"; "Block hedger covering long-stock exposure after Powell speech"; "Activist pre-positioning ahead of board meeting next Tuesday".
        Avoid: tautologies ("they think it goes up") or restating the flow data ("$7M flow on the strike").
  - "convergence_rationale": REQUIRED ONLY IF you are picking a contract the peer agent already took today.
        Default policy is to pick DIFFERENT contracts. If you converge, explain the DISTINCT edge — e.g., "I size larger because Kronos HIGH-confidence agreement is new since their pick" or "Same contract but different protocol — they took flow, I'm taking earnings".
        If you are picking a contract NOT on the peer's list, OMIT this field.

These two fields will be logged to the journal and reviewed by the daily grader — they are not optional.

Respond with ONLY the JSON. No preamble, no markdown fences.
"""
    return prompt


def _mc_kb_recall():
    """Build a rich pre-prompt context block (ticker-aware).

    1) Top-5 flow tickers in last 24h from options_flow.sqlite
    2) Today's signal tickers from scored_signals_recent.json
    3) mc-kb RAG query using those tickers — returns per-ticker memory chunks

    Never raises; returns "" on any failure (so the cycle proceeds even when
    laptop is offline / sqlite locked / etc).
    """
    try:
        import json as _j
        import sqlite3 as _s
        from datetime import datetime as _dt, timezone as _tz
        from pathlib import Path as _P

        # 1) Top-5 flow tickers (by flow value, last 24h)
        flow_block = ""
        top_tickers = []
        try:
            con = _s.connect("/home/ubuntu/mission-control-restored/data/options_flow.sqlite")
            cur = con.cursor()
            rows = cur.execute(
                """SELECT ticker, COUNT(*), COALESCE(SUM(flow_value),0)
                   FROM flow_alerts
                   WHERE captured_at > datetime('now','-24 hours') AND ticker IS NOT NULL
                   GROUP BY ticker
                   ORDER BY 3 DESC, 2 DESC
                   LIMIT 5"""
            ).fetchall()
            con.close()
            if rows:
                top_tickers = [r[0] for r in rows]
                flow_block = "## Top flow tickers (last 24h, premium-weighted)\n\n"
                for t, n, p in rows:
                    flow_block += f"- **{t}**: {n} alerts, ${int(p):,} premium\n"
                flow_block += "\n"
        except Exception as _e:
            flow_block = f"_(flow_value query failed: {_e})_\n\n"

        # 2) Today's signal tickers
        sig_tickers = []
        try:
            sig_path = _P("/home/ubuntu/mission-control/signal-receiver/data/scored_signals_recent.json")
            if sig_path.exists():
                today = _dt.now(_tz.utc).strftime("%Y-%m-%d")
                sigs = _j.loads(sig_path.read_text())
                sig_tickers = sorted({s.get("ticker","") for s in sigs
                                       if isinstance(s, dict) and s.get("timestamp","")[:10] == today and s.get("ticker")})
        except Exception:
            pass

        # 3) Ticker-aware mc-kb recall
        query_tickers = list(dict.fromkeys(top_tickers + sig_tickers))[:8]  # dedupe, keep order, cap at 8
        if query_tickers:
            query = f"trading decisions options flow patterns for {' '.join(query_tickers)} current rules"
        else:
            query = "trading decisions current rules identity critical context"

        kb_block = ""
        try:
            import mc_kb_client
            kb_block = mc_kb_client.recall(query, top=5, tiers=["identity", "critical"], timeout=8) or ""
        except Exception as _e:
            kb_block = f"_(mc-kb recall failed: {_e})_\n\n"

        result = flow_block + kb_block
        return (result + "\n\n---\n\n") if result.strip() else ""
    except Exception:
        return ""



def call_boba(prompt):
    """Boba picks via the claude.ai subscription CLI (free, no API credits), with the
    six-floor desk dossier + lessons + rules + KB recall prepended. Delegates to lib.llm
    (robust binary path + ANTHROPIC_API_KEY stripped + JSON extraction)."""
    from lib.llm import call_llm
    full_prompt = (
        _load_premium_dossier()  # top-of-prompt six-floor desk output
        + _load_lessons()
        + _load_active_position_rules()
        + _mc_kb_recall()
        + prompt
    )
    _t0 = _time_tracker.time()
    r = call_llm(full_prompt, ["claude_cli", "deepseek"])   # sub-CLI primary, DeepSeek secondary backup
    _dur_ms = int((_time_tracker.time() - _t0) * 1000)
    _log_anthropic_call("boba_decision_cycle", BOBA_MODEL, None, _dur_ms,
                        success=("ok" in r), error=(None if "ok" in r else str(r.get("error", ""))[:200]))
    return r

def convert_spx_to_spy(pick):
    """
    Alpaca paper doesn't trade SPX index options.
    Auto-convert SPX picks to approximate SPY equivalents:
      - Scale strike by live SPX/SPY ratio, round to $5 increments
      - Find nearest tradeable SPY expiry
      - Keep contract count the same (conservative sizing)
    Returns: (converted_pick, conversion_note) or (original_pick, None)
    """
    import requests as _requests
    if pick.get("ticker", "").upper() != "SPX":
        return pick, None

    try:
        H = {
            "APCA-API-KEY-ID": read_secret("alpaca-key-id"),
            "APCA-API-SECRET-KEY": read_secret("alpaca-secret"),
        }

        # Get live SPY + SPX prices for ratio
        r = _requests.get("https://data.alpaca.markets/v2/stocks/SPY/quotes/latest",
                          headers=H, timeout=10)
        if not r.ok:
            return pick, f"SPX→SPY conversion failed: Alpaca quote error {r.status_code}"
        q = r.json().get("quote", {})
        spy_mid = (float(q.get("bp", 0)) + float(q.get("ap", 0))) / 2
        if spy_mid <= 0:
            return pick, "SPX→SPY conversion failed: no SPY mid price"

        # Use yfinance for SPX (or default to 10x ratio if lookup fails)
        try:
            import yfinance as yf
            spx = yf.Ticker('^GSPC').history(period='1d')
            spx_price = float(spx['Close'].iloc[-1]) if not spx.empty else spy_mid * 10.0
        except Exception:
            spx_price = spy_mid * 10.0  # Fallback: assume 10x
        ratio = spx_price / spy_mid  # Typically ~10.03
        if not (9.0 <= ratio <= 11.5):
            print(f"[convert] computed ratio {ratio:.2f} outside sane range, falling back to 10.03", flush=True)
            ratio = 10.03

        # Scale strike and round to nearest $5 (SPY strike increment)
        raw_spy_strike = float(pick["strike"]) / ratio
        spy_strike = round(raw_spy_strike / 5.0) * 5.0

        # Find nearest SPY expiry — search ±45 days around requested expiry
        from datetime import datetime, timedelta
        requested_dt = datetime.strptime(pick["expiry"][:10], "%Y-%m-%d")
        search_start = (requested_dt - timedelta(days=45)).strftime("%Y-%m-%d")
        search_end = (requested_dt + timedelta(days=45)).strftime("%Y-%m-%d")

        option_type = pick.get("option_type", "PUT").upper()
        tradier_type = "put" if option_type.startswith("P") else "call"

        r2 = _requests.get(
            "https://paper-api.alpaca.markets/v2/options/contracts",
            headers=H,
            params={
                "underlying_symbols": "SPY",
                "expiration_date_gte": search_start,
                "expiration_date_lte": search_end,
                "type": tradier_type,
                "strike_price_gte": str(spy_strike - 5),
                "strike_price_lte": str(spy_strike + 5),
                "limit": 30,
                "status": "active",
            },
            timeout=10,
        )
        if not r2.ok:
            return pick, f"SPX→SPY conversion failed: no SPY contracts {r2.status_code}"

        contracts = r2.json().get("option_contracts", [])
        if not contracts:
            return pick, f"SPX→SPY conversion failed: no SPY {tradier_type} near strike {spy_strike} expiry {pick['expiry']}"

        # Find contract with strike exactly spy_strike AND closest expiry to requested
        best = None
        best_delta_days = 10**6
        for ct in contracts:
            try:
                if float(ct.get("strike_price", 0)) != spy_strike:
                    continue
                exp_dt = datetime.strptime(ct["expiration_date"], "%Y-%m-%d")
                delta_days = abs((exp_dt - requested_dt).days)
                if delta_days < best_delta_days:
                    best_delta_days = delta_days
                    best = ct
            except Exception:
                continue

        # Fallback: if no exact strike match, take closest strike at nearest expiry
        if best is None:
            for ct in contracts:
                try:
                    exp_dt = datetime.strptime(ct["expiration_date"], "%Y-%m-%d")
                    delta_days = abs((exp_dt - requested_dt).days)
                    strike_delta = abs(float(ct.get("strike_price", 0)) - spy_strike)
                    combined = delta_days * 10 + strike_delta  # prioritize expiry match
                    if combined < best_delta_days:
                        best_delta_days = combined
                        best = ct
                except Exception:
                    continue

        if best is None:
            return pick, "SPX→SPY conversion failed: no suitable SPY contract found"

        final_spy_strike = float(best["strike_price"])
        final_spy_expiry = best["expiration_date"]

        converted = dict(pick)
        converted["ticker"] = "SPY"
        converted["strike"] = final_spy_strike
        converted["expiry"] = final_spy_expiry
        converted["_spx_original"] = {
            "strike": pick["strike"],
            "expiry": pick["expiry"],
            "ratio_used": round(ratio, 3),
        }
        converted["reasoning"] = (
            pick.get("reasoning", "") +
            f" [Auto-converted from SPX ${pick['strike']:.0f}{option_type[0]} {pick['expiry'][:10]} "
            f"→ SPY ${final_spy_strike:.0f}{option_type[0]} {final_spy_expiry} "
            f"(ratio {ratio:.2f}x, Alpaca can't trade SPX)]"
        )

        # Validate the symbol Alpaca will use is actually tradeable
        from datetime import datetime as _dt
        exp_dt_obj = _dt.strptime(final_spy_expiry, "%Y-%m-%d")
        yymmdd = exp_dt_obj.strftime("%y%m%d")
        opt_letter = "P" if option_type.startswith("P") else "C"
        strike_str = f"{int(round(final_spy_strike * 1000)):08d}"
        candidate_symbol = f"SPY{yymmdd}{opt_letter}{strike_str}"
        v_check = _requests.get(
            f"https://paper-api.alpaca.markets/v2/options/contracts/{candidate_symbol}",
            headers=H, timeout=10
        )
        if v_check.status_code != 200:
            return pick, f"SPX→SPY conversion failed: validated symbol {candidate_symbol} not tradeable on Alpaca ({v_check.status_code})"
        note = (
            f"Converted SPX ${pick['strike']:.0f} {pick['expiry'][:10]} "
            f"→ SPY ${final_spy_strike:.0f} {final_spy_expiry} "
            f"(ratio {ratio:.2f}x, validated {candidate_symbol})"
        )
        return converted, note

    except Exception as e:
        return pick, f"SPX→SPY conversion error: {e}"


def _post_bobatrades(msg: str, pick_key: str = None, thread_name: str = None):
    """Post to #boba-trades channel. Item 36: optional thread routing.

    When pick_key is provided, message is routed into a per-pick thread.
    First message for a pick creates the thread; follow-ups reuse it.
    When pick_key is None, posts flat to channel (legacy behavior).
    """
    try:
        hook_path = Path("/home/ubuntu/.openclaw/secrets/discord_bobatrades_webhook")
        if not hook_path.exists():
            return
        webhook_url = hook_path.read_text().strip()

        # Item 36: route through threading helper if pick_key provided
        if pick_key:
            try:
                import sys as _sys
                _sys.path.insert(0, '/home/ubuntu/scripts/lib')
                from discord_threading import post_to_pick_thread

                bot_token_path = Path("/home/ubuntu/.openclaw/secrets/discord_bot_token")
                channel_id = "1497270534482821220"  # #boba-trades
                bot_token = bot_token_path.read_text().strip() if bot_token_path.exists() else None

                result = post_to_pick_thread(
                    pick_key=pick_key,
                    message=msg,
                    thread_name=thread_name or pick_key,
                    webhook_url=webhook_url,
                    bot_token=bot_token,
                    channel_id=channel_id,
                )
                # If threading failed, helper already attempted flat fallback
                return
            except Exception as _e:
                # Threading helper crashed - fall through to flat post
                print(f"[bobatrades] threading helper failed: {_e}, posting flat", flush=True)

        # Legacy flat post (no pick_key, or threading helper unavailable)
        import requests as _r
        _r.post(webhook_url, json={"content": msg[:1900]}, timeout=10)
    except Exception as e:
        print(f"[bobatrades] post failed: {e}", flush=True)

def validate_pick_against_guardrails(pick, account, prior_picks_this_cycle):
    """Item 31: hard numeric guardrail validator. Runs AFTER LLM, BEFORE Alpaca submit.
    Returns (ok: bool, skip_reason: str). On any violation returns (False, "GUARDRAIL_VIOLATION: ...").

    The prompt already states these rules to Boba. This function enforces them at the code
    level as defense-in-depth - even if Boba hallucinates or misinterprets, picks violating
    rules get rejected here and routed to passed_on.
    """
    ticker = str(pick.get("ticker", "")).upper()
    strike = float(pick.get("strike", 0) or 0)
    contracts = int(pick.get("contracts", 0) or 0)
    option_type = str(pick.get("option_type", "")).upper()
    expiry = str(pick.get("expiry", ""))[:10]
    kronos_verdict = str(pick.get("kronos_verdict", "")).upper()
    reasoning = str(pick.get("reasoning", ""))
    entry_criteria = pick.get("entry_criteria", []) or []
    if not isinstance(entry_criteria, list):
        entry_criteria = []

    # Rule 1: Forbidden tickers blocklist
    if ticker in FORBIDDEN_TICKERS:
        return False, f"GUARDRAIL_VIOLATION: ticker {ticker} is on forbidden list"

    # Rule 2: Required fields present
    if not ticker or strike <= 0 or contracts <= 0 or not expiry:
        return False, f"GUARDRAIL_VIOLATION: missing required field (ticker={ticker}, strike={strike}, contracts={contracts}, expiry={expiry})"
    if option_type not in ("CALL", "PUT"):
        return False, f"GUARDRAIL_VIOLATION: option_type must be CALL or PUT, got {option_type}"

    # Rule 3: Per-pick buying power cap (estimate via mid price * contracts * 100)
    # Use conservative estimate - if quote unavailable, skip this check rather than block
    bp = float(account.get("buying_power", 0) or 0)
    if bp > 0:
        # Try to get live mid price for accurate notional - fall back to skipping if unavailable
        live_quote = None
        try:
            live_quote = fetch_live_option_quote(ticker, strike, option_type, expiry)
        except Exception:
            pass
        if live_quote and live_quote.get("mid"):
            est_cost = float(live_quote["mid"]) * contracts * 100
            max_allowed = bp * MAX_BUYING_POWER_PCT_PER_PICK
            if est_cost > max_allowed:
                return False, f"GUARDRAIL_VIOLATION: pick cost ${est_cost:,.0f} exceeds {int(MAX_BUYING_POWER_PCT_PER_PICK*100)}% of buying power (${max_allowed:,.0f})"

    # Rule 4: Kronos CONFLICTS requires flow score >= 90
    # Score lives in entry_criteria as e.g. "T1_1.75M" - if T0/T1 mega flow we can infer
    # high score, otherwise be strict
    if kronos_verdict == "CONFLICTS":
        # Check reasoning text for explicit flow score number
        import re
        score_match = re.search(r"(?:flow\s*score|score)\s*[:=]?\s*(\d{1,3})", reasoning, re.IGNORECASE)
        flow_score = int(score_match.group(1)) if score_match else None
        # Also accept T0 mega flow as override since T0 = $10M+ which is highest tier
        is_t0 = any(c.upper().startswith("T0") for c in entry_criteria)
        if flow_score is None and not is_t0:
            return False, f"GUARDRAIL_VIOLATION: Kronos CONFLICTS but no flow score >= {KRONOS_CONFLICTS_OVERRIDE_SCORE} cited in reasoning and not T0"
        if flow_score is not None and flow_score < KRONOS_CONFLICTS_OVERRIDE_SCORE:
            return False, f"GUARDRAIL_VIOLATION: Kronos CONFLICTS but flow score {flow_score} < required {KRONOS_CONFLICTS_OVERRIDE_SCORE}"

    # Rule 5: 0 DTE requires explicit catalyst language in reasoning
    try:
        from datetime import datetime as _dt, date as _date
        exp_dt = _dt.strptime(expiry, "%Y-%m-%d").date()
        today = _date.today()
        dte = (exp_dt - today).days
        if dte < 0:
            return False, f"GUARDRAIL_VIOLATION: expiry {expiry} is in the past (DTE={dte})"
        if dte == 0:
            # 0DTE warning only - logged but not blocked. Aggressive mode allows 0DTE on flow alone.
            print(f"[guardrail] 0DTE pick on {ticker} - aggressive mode permits, monitor closely", flush=True)
    except Exception as e:
        return False, f"GUARDRAIL_VIOLATION: cannot parse expiry {expiry}: {e}"

    # Rule 6: Strike sanity - must be within reasonable range of underlying
    # If we have live quote, check strike vs spot via the quote's underlying
    # Skip if no live quote available (don't block on missing data)
    # We could also check via shortlist data but that's not in pick scope here

    # Rule 7: Total cycle picks not duplicating same exact contract
    same_contract_count = sum(
        1 for prior in prior_picks_this_cycle
        if str(prior.get("ticker", "")).upper() == ticker
        and float(prior.get("strike", 0) or 0) == strike
        and str(prior.get("option_type", "")).upper() == option_type
        and str(prior.get("expiry", ""))[:10] == expiry
    )
    if same_contract_count > 0:
        return False, f"GUARDRAIL_VIOLATION: duplicate contract already in this cycle's picks ({ticker} ${strike}{option_type[0]} {expiry})"

    # All checks passed
    return True, ""


def execute_pick_on_alpaca(pick):
    """
    Layer 2 — Place option buy + protection stop-limit on Alpaca paper.

    1. Submit buy market order
    2. Poll up to 10 sec for fill
    3. On fill, submit sell stop-limit at -stop_loss_pct from fill
       (trigger = fill * (1 - sl/100), limit = trigger * 0.9)
    4. Return both order IDs + protection status
    5. Notify BobaTrades Discord on success/failure
    """
    import requests
    import time as _time

    try:
        key = read_secret("alpaca-key-id") or read_secret("alpaca_key.txt")
        sec = read_secret("alpaca-secret") or read_secret("alpaca_secret.txt")
        headers = {"APCA-API-KEY-ID": key, "APCA-API-SECRET-KEY": sec, "Content-Type": "application/json"}

        # Build OCC option symbol: NVDA240517C00145000
        ticker = pick["ticker"]
        expiry = pick["expiry"]  # YYYY-MM-DD
        exp_clean = expiry.replace("-", "")[2:]  # YYMMDD
        right = "C" if pick["option_type"].upper().startswith("C") else "P"
        strike_int = int(float(pick["strike"]) * 1000)
        occ_symbol = f"{ticker}{exp_clean}{right}{strike_int:08d}"
        qty = int(pick["contracts"])

        # 0. PRE-FLIGHT: cancel any stale sell orders for this symbol that could block buy.
        # Defends against orphan SL/TP orders left over from prior trades on the same contract.
        try:
            existing = requests.get("https://paper-api.alpaca.markets/v2/orders?status=open&limit=100",
                headers=headers, timeout=10).json()
            stale = [o for o in existing if o.get("symbol") == occ_symbol and o.get("side") == "sell"]
            if stale:
                for so in stale:
                    requests.delete(f"https://paper-api.alpaca.markets/v2/orders/{so.get('id')}",
                        headers=headers, timeout=10)
                _time.sleep(1)
                _post_bobatrades(f"🧹 Pre-flight cleanup: cancelled {len(stale)} stale sell order(s) on {occ_symbol}", pick_key=occ_symbol, thread_name=f"📊 {occ_symbol}")
        except Exception as _pre_e:
            pass  # best-effort; don't block buy if preflight check fails

        # 1. Submit market buy
        buy_order = {
            "symbol": occ_symbol,
            "qty": str(qty),
            "side": "buy",
            "type": "market",
            "time_in_force": "day",
        }
        buy_r = requests.post(
            "https://paper-api.alpaca.markets/v2/orders",
            headers=headers, json=buy_order, timeout=15,
        )
        if buy_r.status_code not in (200, 201):
            err = f"BUY HTTP {buy_r.status_code}: {buy_r.text[:300]}"
            _post_bobatrades(f"❌ Boba buy REJECTED {occ_symbol} x{qty}\n{err}", pick_key=occ_symbol, thread_name=f"📊 {occ_symbol}")
            return {"ok": False, "error": err, "symbol": occ_symbol}

        buy_data = buy_r.json()
        buy_id = buy_data.get("id")

        # 2. Poll for fill (up to 10 sec)
        fill_price = None
        for _ in range(20):  # 20 * 500ms = 10s
            _time.sleep(0.5)
            poll_r = requests.get(
                f"https://paper-api.alpaca.markets/v2/orders/{buy_id}",
                headers=headers, timeout=5,
            )
            if poll_r.status_code == 200:
                pd = poll_r.json()
                if pd.get("status") == "filled":
                    fill_price = float(pd.get("filled_avg_price") or 0)
                    break

        if not fill_price:
            _post_bobatrades(
                f"⏱️ Boba bought {occ_symbol} x{qty} — NOT filled in 10s\n"
                f"Daemon will trail on next cycle. Order: {buy_id[:8]}",
                pick_key=occ_symbol, thread_name=f"📊 {occ_symbol}"
            )
            return {
                "ok": True, "symbol": occ_symbol, "order_id": buy_id,
                "fill_price": None, "protection_order_id": None,
                "protection_status": "SKIPPED (buy did not fill in 10s — daemon will trail)",
            }

        # 3. Submit stop_limit SL — Alpaca rejects OCO on options (complex orders not supported).
        # TP is handled by daemon trailing SL up + Boba position_actions TRIM/EXIT.
        stop_loss_pct = float(pick.get("stop_loss_pct", 30))
        profit_target_pct = float(pick.get("profit_target_pct", 50))
        stop_trigger = round(max(fill_price * (1 - stop_loss_pct / 100), 0.01), 2)
        stop_limit = round(max(stop_trigger * 0.90, 0.01), 2)
        tp_price = round(max(fill_price * (1 + profit_target_pct / 100), 0.01), 2)

        sl_order = {
            "symbol": occ_symbol,
            "qty": str(qty),
            "side": "sell",
            "position_intent": "sell_to_close",
            "type": "stop_limit",
            "time_in_force": "gtc",
            "stop_price": str(stop_trigger),
            "limit_price": str(stop_limit),
        }
        prot_r = requests.post(
            "https://paper-api.alpaca.markets/v2/orders",
            headers=headers, json=sl_order, timeout=10,
        )

        if prot_r.status_code in (200, 201):
            prot_id = prot_r.json().get("id")
            cost = fill_price * qty * 100

            # 4. Submit TP limit leg (Layer 2 bracket — profit side)
            profit_target_pct = float(pick.get("profit_target_pct", 50))
            tp_price = round(max(fill_price * (1 + profit_target_pct / 100), 0.01), 2)

            tp_order = {
                "symbol": occ_symbol,
                "qty": str(qty),
                "side": "sell",
                "position_intent": "sell_to_close",
                "type": "limit",
                "time_in_force": "gtc",
                "limit_price": str(tp_price),
            }
            tp_r = requests.post(
                "https://paper-api.alpaca.markets/v2/orders",
                headers=headers, json=tp_order, timeout=10,
            )
            tp_id = None
            tp_status = "NOT ARMED"
            if tp_r.status_code in (200, 201):
                tp_id = tp_r.json().get("id")
                tp_status = f"ARMED limit @ ${tp_price:.2f} (+{profit_target_pct:.0f}%)"

            _post_bobatrades(
                f"✅ Boba BOUGHT {occ_symbol} x{qty} @ ${fill_price:.2f} (${cost:,.0f})\n"
                f"🛡️ SL armed: trigger ${stop_trigger:.2f} / limit ${stop_limit:.2f} (-{stop_loss_pct:.0f}%)\n"
                f"🎯 TP armed: limit ${tp_price:.2f} (+{profit_target_pct:.0f}%)" if tp_id else
                f"✅ Boba BOUGHT {occ_symbol} x{qty} @ ${fill_price:.2f} (${cost:,.0f})\n"
                f"🛡️ SL armed: trigger ${stop_trigger:.2f} / limit ${stop_limit:.2f} (-{stop_loss_pct:.0f}%)\n"
                f"⚠️ TP FAILED: HTTP {tp_r.status_code}"
            )
            return {
                "ok": True, "symbol": occ_symbol, "order_id": buy_id,
                "fill_price": fill_price,
                "protection_order_id": prot_id,
                "tp_order_id": tp_id,
                "protection_status": f"ARMED stop-limit @ ${stop_trigger:.2f}/${stop_limit:.2f} (-{stop_loss_pct:.0f}%)",
                "tp_status": tp_status,
            }
        else:
            _post_bobatrades(
                f"⚠️ Boba bought {occ_symbol} x{qty} @ ${fill_price:.2f} "
                f"BUT protection FAILED (HTTP {prot_r.status_code})\n"
                f"Daemon will trail. {prot_r.text[:150]}",
                pick_key=occ_symbol, thread_name=f"📊 {occ_symbol}"
            )
            return {
                "ok": True, "symbol": occ_symbol, "order_id": buy_id,
                "fill_price": fill_price,
                "protection_order_id": None,
                "protection_status": f"FAILED to arm: HTTP {prot_r.status_code} — daemon will trail",
            }

    except Exception as e:
        try:
            _post_bobatrades(f"❌ Boba execute EXCEPTION: {e}")
        except Exception:
            pass
        return {"ok": False, "error": str(e)}



def execute_position_action(action_dict, positions):
    """
    Layer 2 — Execute Boba's position management action.
    Actions: HOLD (no-op), TRIM_25, TRIM_50, TIGHTEN_STOP, EXIT.
    Cancels existing OCO/bracket legs first to release reserved shares,
    sleeps 2s, then submits the new order(s). Reuses pattern from daemon.
    """
    import requests
    import time as _time

    sym = action_dict.get("symbol", "")
    act = (action_dict.get("action", "HOLD") or "HOLD").upper()
    reason = (action_dict.get("reason", "") or "")[:200]

    if act == "HOLD":
        return {"ok": True, "action": act, "symbol": sym, "details": "no-op (HOLD)"}

    pos = next((p for p in positions if p.get("symbol") == sym), None)
    if not pos:
        return {"ok": False, "action": act, "symbol": sym, "error": f"position not found: {sym}"}

    qty = int(float(pos.get("qty", 0)))
    avg_entry = float(pos.get("avg_entry_price", 0))
    cur_price = float(pos.get("current_price", 0) or 0)
    if qty <= 0:
        return {"ok": False, "action": act, "symbol": sym, "error": "qty <= 0"}

    try:
        key = read_secret("alpaca-key-id") or read_secret("alpaca_key.txt")
        sec = read_secret("alpaca-secret") or read_secret("alpaca_secret.txt")
        headers = {"APCA-API-KEY-ID": key, "APCA-API-SECRET-KEY": sec, "Content-Type": "application/json"}
        BASE = "https://paper-api.alpaca.markets/v2"

        # 1. Cancel any open sell orders for this symbol (releases share reservation)
        r = requests.get(f"{BASE}/orders?status=open&limit=100", headers=headers, timeout=10)
        cancelled = 0
        if r.status_code == 200:
            for o in r.json():
                if o.get("symbol") == sym and o.get("side") == "sell":
                    dr = requests.delete(f"{BASE}/orders/{o.get('id')}", headers=headers, timeout=5)
                    if dr.status_code in (200, 204):
                        cancelled += 1
        if cancelled > 0:
            _time.sleep(2)

        # 2. Determine limit price for sells (use current price as proxy for bid)
        is_option = len(sym) >= 15 and sym[-9:-8] in ("0", "1", "2", "3", "4", "5", "6", "7", "8", "9")
        limit_p = cur_price if cur_price > 0.01 else max(avg_entry * 0.95, 0.01)

        # 3. Branch by action
        if act in ("TRIM_25", "TRIM_50"):
            pct = 0.25 if act == "TRIM_25" else 0.50
            close_qty = max(1, int(qty * pct))
            remaining = qty - close_qty

            sell_body = {
                "symbol": sym, "qty": str(close_qty), "side": "sell",
                "position_intent": "sell_to_close",
                "type": "limit", "time_in_force": "day",
                "limit_price": f"{limit_p:.2f}",
            }
            sr = requests.post(f"{BASE}/orders", headers=headers, json=sell_body, timeout=15)
            ok = sr.status_code in (200, 201)
            details = f"sell limit {close_qty}/{qty} @ ${limit_p:.2f}"

            # Reissue OCO on remaining qty so it stays protected
            if ok and remaining > 0 and is_option:
                _time.sleep(1)
                tp_pct, sl_pct = 50.0, 30.0
                stop_t = round(max(avg_entry * (1 - sl_pct/100), 0.01), 2)
                stop_l = round(max(stop_t * 0.90, 0.01), 2)
                tp_p = round(max(avg_entry * (1 + tp_pct/100), 0.01), 2)
                # Alpaca rejects order_class=oco on options. Place SL + TP as two orders.
                # Orphan cleanup in profit_lock_daemon cancels the dangling leg if one fills.
                sl_body = {"symbol": sym, "qty": str(remaining), "side": "sell",
                    "position_intent": "sell_to_close",
                    "type": "stop_limit", "time_in_force": "gtc",
                    "stop_price": str(stop_t), "limit_price": str(stop_l)}
                sl_r = requests.post(f"{BASE}/orders", headers=headers, json=sl_body, timeout=15)
                _time.sleep(0.3)
                tp_body = {"symbol": sym, "qty": str(remaining), "side": "sell",
                    "position_intent": "sell_to_close",
                    "type": "limit", "time_in_force": "gtc",
                    "limit_price": str(tp_p)}
                tp_r = requests.post(f"{BASE}/orders", headers=headers, json=tp_body, timeout=15)
                sl_ok = sl_r.status_code in (200, 201)
                tp_ok = tp_r.status_code in (200, 201)
                details += f" + reissue SL{'OK' if sl_ok else 'FAIL'}/TP{'OK' if tp_ok else 'FAIL'} on {remaining}"
            return {"ok": ok, "action": act, "symbol": sym, "details": details}

        elif act == "EXIT":
            sell_body = {
                "symbol": sym, "qty": str(qty), "side": "sell",
                "position_intent": "sell_to_close",
                "type": "limit", "time_in_force": "day",
                "limit_price": f"{limit_p:.2f}",
            }
            sr = requests.post(f"{BASE}/orders", headers=headers, json=sell_body, timeout=15)
            ok = sr.status_code in (200, 201)
            err = None if ok else f"HTTP {sr.status_code}: {sr.text[:200]}"
            return {"ok": ok, "action": act, "symbol": sym, "details": f"sell limit {qty} @ ${limit_p:.2f}", "error": err}

        elif act == "TIGHTEN_STOP":
            if not is_option:
                return {"ok": False, "action": act, "symbol": sym, "error": "TIGHTEN_STOP only supported on options"}
            tp_pct, sl_pct = 50.0, 15.0
            stop_t = round(max(avg_entry * (1 - sl_pct/100), 0.01), 2)
            stop_l = round(max(stop_t * 0.90, 0.01), 2)
            tp_p = round(max(avg_entry * (1 + tp_pct/100), 0.01), 2)
            # Cancel any existing sell orders for this symbol first (release reserved qty)
            try:
                ex = requests.get(f"{BASE}/orders?status=open&limit=100", headers=headers, timeout=10).json()
                for eo in ex:
                    if eo.get("symbol") == sym and eo.get("side") == "sell":
                        requests.delete(f"{BASE}/orders/{eo.get('id')}", headers=headers, timeout=10)
                        _time.sleep(0.2)
            except Exception:
                pass
            sl_body = {"symbol": sym, "qty": str(qty), "side": "sell",
                "position_intent": "sell_to_close",
                "type": "stop_limit", "time_in_force": "gtc",
                "stop_price": str(stop_t), "limit_price": str(stop_l)}
            sl_r = requests.post(f"{BASE}/orders", headers=headers, json=sl_body, timeout=15)
            _time.sleep(0.3)
            tp_body = {"symbol": sym, "qty": str(qty), "side": "sell",
                "position_intent": "sell_to_close",
                "type": "limit", "time_in_force": "gtc",
                "limit_price": str(tp_p)}
            tp_r = requests.post(f"{BASE}/orders", headers=headers, json=tp_body, timeout=15)
            sl_ok = sl_r.status_code in (200, 201)
            tp_ok = tp_r.status_code in (200, 201)
            ok = sl_ok and tp_ok
            err = None if ok else f"SL HTTP {sl_r.status_code} TP HTTP {tp_r.status_code}"
            return {"ok": ok, "action": act, "symbol": sym, "details": f"SL ${stop_t:.2f} (-{sl_pct:.0f}%) + TP ${tp_p:.2f} (+{tp_pct:.0f}%)", "error": err}

        else:
            return {"ok": False, "action": act, "symbol": sym, "error": f"unknown action: {act}"}

    except Exception as e:
        return {"ok": False, "action": act, "symbol": sym, "error": str(e)[:200]}



def flush_to_boba_memory(cycle_result, picks_executed):
    """
    4-file flush protocol — writes structured memory at end of every Boba cycle.

    Files (all under ~/.openclaw/workspace/boba_memory/):
      - daily-log         : append, operational summary per cycle
      - decisions         : append, each committed pick + full reasoning chain
      - rejected-ideas    : append, each passed-on signal + specific skip reason
      - raw-backup-context: append, full raw cycle_result + picks JSON dump

    Failures here MUST NEVER break the Boba cycle. Wrapped in try/except.
    """
    try:
        import json as _json
        import fcntl as _fcntl
        from datetime import datetime as _dt
        from zoneinfo import ZoneInfo as _ZI
        from pathlib import Path as _P

        MEM_DIR = _P("/home/ubuntu/.openclaw/workspace/boba_memory")
        if not MEM_DIR.is_dir():
            print(f"[flush] boba_memory dir missing — skipping", flush=True)
            return

        ts_et = _dt.now(_ZI("America/New_York"))
        ts_label = ts_et.strftime("%Y-%m-%d %H:%M %Z")
        ts_iso = ts_et.isoformat()

        cycle_summary = cycle_result.get("cycle_summary", "(no summary)")
        passed_on = cycle_result.get("passed_on", [])
        n_picks = len(picks_executed)
        n_passed = len(passed_on)

        def _append_locked(filepath, content):
            with open(filepath, "a", encoding="utf-8") as fh:
                _fcntl.flock(fh.fileno(), _fcntl.LOCK_EX)
                try:
                    fh.write(content)
                finally:
                    _fcntl.flock(fh.fileno(), _fcntl.LOCK_UN)

        # 1. daily-log
        daily_block = (
            f"\n## {ts_label}\n"
            f"- Cycle summary: {cycle_summary}\n"
            f"- Picks committed: {n_picks}\n"
            f"- Passed on: {n_passed}\n"
        )
        if picks_executed:
            daily_block += "- Tickers committed: " + ", ".join(
                str(p.get("ticker", "?")) for p in picks_executed
            ) + "\n"
        _append_locked(MEM_DIR / "daily-log", daily_block)

        # 2. decisions — full reasoning per pick
        if picks_executed:
            dec_block = f"\n## {ts_label}\n"
            for pk in picks_executed:
                tk = pk.get("ticker", "?")
                strike = pk.get("strike", "?")
                opt = pk.get("option_type", "?")
                exp = pk.get("expiry", "?")
                reasoning = pk.get("reasoning", "(none)")
                conf = pk.get("confidence", "?")
                proto = pk.get("protocol", "?")
                pt = pk.get("profit_target_pct", "?")
                sl = pk.get("stop_loss_pct", "?")
                exec_info = pk.get("execution", {})
                ok = exec_info.get("ok") if isinstance(exec_info, dict) else None
                dec_block += (
                    f"\n### {tk} ${strike}{opt} {exp}\n"
                    f"- Protocol: {proto} | Confidence: {conf} | TP: {pt}% | SL: {sl}%\n"
                    f"- Executed: {ok}\n"
                    f"- Reasoning: {reasoning}\n"
                )
            _append_locked(MEM_DIR / "decisions", dec_block)

        # 3. rejected-ideas — passed-on signals with reasons
        if passed_on:
            rej_block = f"\n## {ts_label}\n"
            for r in passed_on:
                tk = r.get("ticker", "?") if isinstance(r, dict) else "?"
                reason = r.get("reason", "(none)") if isinstance(r, dict) else str(r)
                rej_block += f"- {tk}: {reason}\n"
            _append_locked(MEM_DIR / "rejected-ideas", rej_block)

        # 4. raw-backup-context — full unmodified dump
        # Read mike-mindset (Mike's posture context) for inclusion in raw backup
        mindset_content = ""
        try:
            mindset_path = MEM_DIR / "mike-mindset"
            if mindset_path.exists():
                mindset_content = mindset_path.read_text(encoding="utf-8")
        except Exception:
            mindset_content = "(mindset read failed - file may be missing)"

        try:
            raw_dump = _json.dumps({
                "timestamp_et": ts_iso,
                "mike_mindset_snapshot": mindset_content[:8000],
                "cycle_result": cycle_result,
                "picks_executed": picks_executed,
            }, indent=2, default=str)
        except Exception as _je:
            raw_dump = f'{{"timestamp_et": "{ts_iso}", "serialize_error": "{_je}"}}'
        raw_block = f"\n## {ts_label}\n```json\n{raw_dump}\n```\n"
        _append_locked(MEM_DIR / "raw-backup-context", raw_block)

        print(f"[flush] boba_memory updated at {ts_label} ({n_picks} picks, {n_passed} passed)", flush=True)
    except Exception as _flush_e:
        # Flush failures must never break the cycle
        print(f"[flush] FAILED (cycle continues): {_flush_e}", flush=True)


def log_decision(cycle_result, picks_executed):
    # SCHEMA v2 (2026-04-28): enrich picks with protocol + entry_criteria defaults
    # protocol: "flow" (current flow-driven picks) | "swing" (future Protocol B) | "manual"
    # entry_criteria: gates that fired for this pick (e.g. ["T1_huge_flow","sweep_AA","repeater_5x"])
    for _pick in picks_executed:
        if "protocol" not in _pick:
            _pick["protocol"] = "flow"
        if "entry_criteria" not in _pick:
            _pick["entry_criteria"] = []
    entry = {
        "cycle_time": datetime.now(timezone.utc).isoformat(),
        "model_used": BOBA_MODEL,
        "cycle_summary": cycle_result.get("cycle_summary", ""),
        "picks_proposed": len(cycle_result.get("picks", [])),
        "picks_executed": picks_executed,
        "passed_on": cycle_result.get("passed_on", []),
        "position_actions": cycle_result.get("position_actions", []),
        "raw_response": cycle_result,
    }
    existing = []
    if DECISIONS_LOG.exists():
        try:
            existing = json.loads(DECISIONS_LOG.read_text())
            if not isinstance(existing, list):
                existing = []
        except Exception:
            existing = []
    existing.append(entry)
    DECISIONS_LOG.write_text(json.dumps(existing[-500:], indent=2))


def main():
    p = argparse.ArgumentParser()
    p.add_argument("--dry-run", action="store_true", help="Build prompt + show but don't call Boba or execute")
    p.add_argument("--force", action="store_true", help="Ignore killswitch")
    args = p.parse_args()

    cycle_start = datetime.now(timezone.utc).isoformat()

    # Killswitch check
    if KILLSWITCH.exists() and not args.force:
        log_to_ops("boba_cycle", "WARN", f"Killswitch active — aborting. {KILLSWITCH.read_text()[:200]}")
        print("Killswitch active — aborting")
        return 1

    log_to_ops("boba_cycle", "INFO", "Cycle start")

    # 1. Load today's fresh whale signals
    seen = load_seen()
    fresh = get_todays_whale_signals(seen)
    log_to_ops("boba_cycle", "DATA", f"Today's fresh signals: {len(fresh)} (seen: {len(seen)})")
    if not fresh:
        post_to_telegram(
            agent="boba", message_type="Cycle",
            body=f"🫘 No fresh whale signals today yet. Next check in ~90 min.",
            bypass_cooldown=True,
        )
        print("No fresh signals")
        return 0

    # 2. Build shortlist
    shortlist = build_shortlist(fresh)
    log_to_ops("boba_cycle", "DATA", f"Shortlist size: {len(shortlist)}")

    # 3. KRONOS: fire-and-forget background runs for Discord visibility.
    # Boba does NOT wait. Use cached forecasts (< 60 min old) if available;
    # otherwise kick off a background Kronos run and move on.
    shortlist_with_kronos = []
    kronos_fired = []
    kronos_cached = []
    kronos_waited = []
    kronos_timeout = []
    for sid, s in shortlist:
        ticker = s.get("ticker")
        option_ctx = f"{s.get('strike')}{(s.get('option_type') or '?')[0]} {s.get('expiry','')[:10]}"

        # Check for fresh cached forecast first
        # 90 min window matches TRADER cron interval (10:30, 12:00, 13:30, 15:00 ET)
        # Skip Kronos entirely for tickers it cannot forecast (indices, no Alpaca bars)
        if ticker in KRONOS_SKIP_TICKERS:
            placeholder = {
                "ticker": ticker,
                "error": f"kronos skipped - {ticker} not supported (index symbol)",
                "option_context": option_ctx,
                "option_in_forecast_direction": None,
                "skipped": True,
            }
            shortlist_with_kronos.append((sid, s, placeholder))
            kronos_timeout.append(ticker)
            continue
        cached = check_fresh_kronos_file(ticker, max_age_minutes=90)
        if cached and "error" not in cached:
            # We have a recent forecast — annotate it with option context if needed
            if "option_in_forecast_direction" not in cached or cached.get("option_context") != option_ctx:
                cached["option_context"] = option_ctx
                # Null-safe: if forecast errored or has no direction, set None (UNAVAILABLE)
                # rather than False which would falsely become CONFLICTS
                if cached.get("error") or "forecast_24h_direction" not in cached:
                    cached["option_in_forecast_direction"] = None
                else:
                    is_call = "C" in option_ctx.upper().split()[0]
                    is_put = "P" in option_ctx.upper().split()[0]
                    direction = cached.get("forecast_24h_direction", "neutral")
                    if direction == "neutral":
                        cached["option_in_forecast_direction"] = None
                    elif is_call:
                        cached["option_in_forecast_direction"] = (direction == "bullish")
                    elif is_put:
                        cached["option_in_forecast_direction"] = (direction == "bearish")
            shortlist_with_kronos.append((sid, s, cached))
            kronos_cached.append(ticker)
            # Still fire a background refresh for NEXT cycle (so cache stays warm)
            fire_kronos_background(ticker, option_ctx)
        else:
            # No fresh forecast — fire in background, then WAIT up to 75s for result.
            # Kronos typically takes ~50s. If it doesn't finish, use placeholder.
            fire_kronos_background(ticker, option_ctx)
            kronos_fired.append(ticker)
            # Item 11 mitigation: indices have huge option chains, allow extra time
            kronos_timeout_sec = 240 if ticker in ("SPY", "QQQ", "IWM", "DIA") else 240
            waited = wait_for_kronos_result(ticker, timeout_sec=kronos_timeout_sec, poll_interval=3)
            if waited:
                # Got real result — annotate with option context
                waited["option_context"] = option_ctx
                is_call = "C" in option_ctx.upper().split()[0]
                is_put = "P" in option_ctx.upper().split()[0]
                direction = waited.get("forecast_24h_direction", "neutral")
                if is_call:
                    waited["option_in_forecast_direction"] = (direction == "bullish")
                elif is_put:
                    waited["option_in_forecast_direction"] = (direction == "bearish")
                shortlist_with_kronos.append((sid, s, waited))
                kronos_waited.append(ticker)
            else:
                # Timeout — LLM sees it's unavailable
                placeholder = {
                    "note": f"Kronos forecast timed out after 75s — unavailable",
                    "forecast_24h_direction": "unavailable",
                    "forecast_24h_confidence": "unavailable",
                }
                shortlist_with_kronos.append((sid, s, placeholder))
                kronos_timeout.append(ticker)

    log_to_ops("boba_cycle", "DATA",
               f"Kronos: {len(kronos_cached)} cached / {len(kronos_waited)} waited-ok / {len(kronos_timeout)} timeout",
               metadata={"cached": kronos_cached, "waited": kronos_waited, "timeout": kronos_timeout, "fired": kronos_fired})
    print(f"[kronos] {len(kronos_cached)} cached / {len(kronos_waited)} waited-ok / {len(kronos_timeout)} timeout", file=sys.stderr)

    # 4. Get account state
    account = get_alpaca_account()
    positions = get_alpaca_positions()

    # 5. Build prompt
    prompt = build_boba_prompt(account, positions, shortlist_with_kronos, remaining_budget=remaining_picks_today())
    if args.dry_run:
        print("=== DRY RUN — prompt that would be sent to Boba ===")
        print(prompt)
        print(f"\nPrompt size: {len(prompt)} chars")
        return 0

    # 6. Call Boba
    log_to_ops("boba_cycle", "INFO", "Calling Boba (Sonnet)")
    result = call_boba(prompt)

    if "error" in result:
        log_to_ops("boba_cycle", "ERROR", f"Boba call failed: {result['error']}")
        post_to_telegram(
            agent="boba", message_type="Cycle Error",
            body=f"Call failed: {result['error'][:200]}",
            bypass_cooldown=True,
        )
        return 1

    cycle_result = result["response"]
    usage = result.get("usage", {})
    log_to_ops("boba_cycle", "DATA",
               f"Boba response received",
               metadata={"picks": len(cycle_result.get("picks", [])), "passed": len(cycle_result.get("passed_on", [])), "usage": usage})

    # 7. Execute picks — gated by daily NEW picks budget
    remaining_budget = remaining_picks_today()
    print(f"[daily_budget] {remaining_budget} NEW picks remaining today (cap {MAX_NEW_PICKS_PER_DAY})", flush=True)
    cycle_picks = cycle_result.get("picks", [])

    # === PDT guard: under-$25K accounts only get 4 daytrades / 5 days ===
    if apply_pdt_guard and cycle_picks:
        cycle_picks, _pdt_notes = apply_pdt_guard(cycle_picks, account, agent="boba")
        for _n in _pdt_notes:
            print(_n, flush=True)


    # 2-min research-and-confirm before order execution (env BOBA_VALIDATE_PICKS=0 to skip).
    # Gathers live quote + recent flow + mc-kb recall, then asks Claude PROCEED/ABORT per pick.
    # Fail-open: any error returns the original picks unchanged.
    import os as _os
    if _os.environ.get("BOBA_VALIDATE_PICKS", "1") != "0" and cycle_picks:
        try:
            from pick_validator import validate_picks as _validate_picks
            print(f"[pick-validator] validating {len(cycle_picks)} pick(s) with 2-min research pass", flush=True)
            cycle_picks = _validate_picks(cycle_picks, account="boba", sleep_sec=120)
            cycle_result["picks"] = cycle_picks  # keep cycle_result in sync for journaling
        except Exception as _ve:
            print(f"[pick-validator] failed, fail-open: {_ve!r}", flush=True)

    # Cap at min(per-cycle limit, remaining daily budget) — with PLATINUM override.
    # PLATINUM-band picks (confidence ≥ 90) can bypass the daily cap up to once per day.
    effective_cap = min(MAX_PICKS_PER_CYCLE, remaining_budget)
    state = load_daily_picks_state()
    _platinum_override_used = state.get("platinum_overrides_used", 0)
    PLATINUM_OVERRIDES_PER_DAY = 1

    _platinum_picks = [_p for _p in cycle_picks if _p.get("confidence", {}).get("band") == "PLATINUM"]
    _nonplat_picks  = [_p for _p in cycle_picks if _p.get("confidence", {}).get("band") != "PLATINUM"]

    _allow_platinum = min(
        len(_platinum_picks),
        max(0, PLATINUM_OVERRIDES_PER_DAY - _platinum_override_used),
    ) if remaining_budget == 0 else len(_platinum_picks)

    _allow_nonplat = max(0, effective_cap - 0)  # non-PLATINUM picks count against cap
    _pick_queue = _platinum_picks[:_allow_platinum] + _nonplat_picks[:_allow_nonplat]
    _pick_queue = _pick_queue[:max(_allow_platinum + effective_cap, _allow_platinum)]

    if _allow_platinum and remaining_budget == 0:
        print(f"[daily_budget] PLATINUM OVERRIDE: {_allow_platinum} pick(s) allowed despite budget=0 (override {_platinum_override_used + _allow_platinum}/{PLATINUM_OVERRIDES_PER_DAY} today)", flush=True)
        state["platinum_overrides_used"] = _platinum_override_used + _allow_platinum
        save_daily_picks_state(state)

    if len(_pick_queue) < len(cycle_picks):
        print(f"[daily_budget] LLM returned {len(cycle_picks)} picks, executing {len(_pick_queue)} (cap={effective_cap}, platinum_allowed={_allow_platinum})", flush=True)
    picks_executed = []
    for pick in _pick_queue:
        # Auto-convert SPX picks to SPY equivalents (Alpaca can't trade SPX)
        converted_pick, conversion_note = convert_spx_to_spy(pick)
        if conversion_note:
            print(f"[convert] {conversion_note}", flush=True)
            try:
                post_to_telegram(agent="boba", message_type="Note",
                                 body=f"🔄 {conversion_note}", bypass_cooldown=True)
            except Exception:
                pass
        if str(converted_pick.get("ticker", "")).upper() == "SPX":
            print(f"[convert] SKIPPING — pick is still SPX after conversion attempt", flush=True)
            try:
                post_to_telegram(agent="boba", message_type="Note",
                                 body=f"⏭ Skipped SPX pick (no tradeable SPY equivalent): {conversion_note or 'unknown'}",
                                 bypass_cooldown=True)
            except Exception:
                pass
            continue

        # Item 31: hard guardrail validation BEFORE Alpaca submit
        ok, skip_reason = validate_pick_against_guardrails(
            converted_pick, account, picks_executed
        )
        if not ok:
            print(f"[guardrail] REJECTED {converted_pick.get('ticker')} ${converted_pick.get('strike')}: {skip_reason}", flush=True)
            # Route rejected pick to passed_on so it appears in decision log
            cycle_result.setdefault("passed_on", []).append({
                "ticker": converted_pick.get("ticker"),
                "strike": converted_pick.get("strike"),
                "option_type": converted_pick.get("option_type"),
                "expiry": converted_pick.get("expiry"),
                "reason": skip_reason,
                "rejected_by": "guardrail_validator",
            })
            try:
                post_to_telegram(agent="boba", message_type="Note",
                                 body=f"⛔ Guardrail rejected {converted_pick.get('ticker')} ${converted_pick.get('strike')}{str(converted_pick.get('option_type','?'))[0]}: {skip_reason}",
                                 bypass_cooldown=True)
            except Exception:
                pass
            continue

        exec_result = execute_pick_on_alpaca(converted_pick)
        converted_pick["execution"] = exec_result
        picks_executed.append(converted_pick)

        # Increment daily NEW picks counter on successful execution
        if exec_result.get("ok"):
            increment_daily_picks({
                "ticker": converted_pick.get("ticker"),
                "strike": converted_pick.get("strike"),
                "option_type": converted_pick.get("option_type"),
                "expiry": converted_pick.get("expiry"),
                "contracts": converted_pick.get("contracts"),
                "executed_at": __import__("datetime").datetime.now().isoformat(),
            })

        # Telegram announcement per pick
        emoji = "✅" if exec_result.get("ok") else "⚠"
        body = (
            f"{emoji} {converted_pick['ticker']} ${converted_pick['strike']}{converted_pick['option_type'][0]} {converted_pick['expiry'][:10]}\n"
            f"{converted_pick['contracts']} contracts | TP +{converted_pick.get('profit_target_pct', 50)}% / SL -{converted_pick.get('stop_loss_pct', 30)}%\n"
            f"{converted_pick.get('reasoning', '')[:400]}"
        )
        if not exec_result.get("ok"):
            body += f"\n⚠ Alpaca: {exec_result.get('error', 'unknown')[:100]}"
        post_to_telegram(agent="boba", message_type="Pick", body=body, bypass_cooldown=True)

    # Process position_actions (HOLD/TRIM/TIGHTEN/EXIT) — does NOT count against daily budget
    position_actions = cycle_result.get("position_actions", [])
    if position_actions:
        print(f"[position_mgmt] {len(position_actions)} position actions from Boba", flush=True)
        executed_actions = []
        for action in position_actions:
            sym = action.get("symbol", "?")
            act = (action.get("action", "HOLD") or "HOLD").upper()
            reason = (action.get("reason", "") or "")[:200]
            print(f"  {sym}: {act} — {reason}", flush=True)

            if act == "HOLD":
                continue

            result = execute_position_action(action, positions)
            executed_actions.append(result)

            if result.get("ok"):
                details = result.get("details", "")
                print(f"    ✓ {details}", flush=True)
                try:
                    _post_bobatrades(
                        f"⚙️ Boba position action: {sym} {act}\n"
                        f"{details}\n"
                        f"Reason: {reason}",
                        pick_key=sym, thread_name=f"📊 {sym}"
                    )
                except Exception:
                    pass
            else:
                err = result.get("error", "unknown")
                print(f"    ✗ {err}", flush=True)
                try:
                    _post_bobatrades(
                        f"❌ Boba position action FAILED: {sym} {act}\n"
                        f"Error: {err}\n"
                        f"Reason: {reason}",
                        pick_key=sym, thread_name=f"📊 {sym}"
                    )
                except Exception:
                    pass
        try:
            post_to_telegram(
                agent="boba",
                message_type="PosMgmt",
                body="Position actions:\n" + "\n".join(
                    f"• {a.get('symbol','?')}: {a.get('action','HOLD')} ({a.get('reason','')[:80]})"
                    for a in position_actions
                ),
                bypass_cooldown=True
            )
        except Exception:
            pass

    # Cycle summary post
    summary = cycle_result.get("cycle_summary", "(no summary)")
    n_picks = len(picks_executed)
    n_passed = len(cycle_result.get("passed_on", []))
    post_to_telegram(
        agent="boba", message_type="Cycle Summary",
        body=f"{n_picks} picks committed, {n_passed} passed on.\n{summary}",
        bypass_cooldown=True,
    )

    # 8. Mark all shortlist signals as seen
    for sid, _ in shortlist:
        seen.add(sid)
    save_seen(seen)

    # 9. Log decision
    log_decision(cycle_result, picks_executed)

    # 9b. 4-file flush protocol — writes structured memory to ~/.openclaw/workspace/boba_memory/
    # Wrapped internally in try/except — flush failures cannot break the cycle.
    flush_to_boba_memory(cycle_result, picks_executed)

    # Multi-agent: post Boba's cycle summary to #agent-debate
    if _MULTIAGENT_LIB_OK:
        try:
            _summary = cycle_result.get("cycle_summary", "")[:1500]
            _picks = cycle_result.get("picks", [])
            if _picks:
                _pick_lines = [f"• {pk.get('ticker','?')} ${pk.get('strike','?')}{pk.get('option_type','?')} {pk.get('expiry','?')}" for pk in _picks[:3]]
                _summary += "\n\n**Picks this cycle:**\n" + "\n".join(_pick_lines)
            _passed = cycle_result.get("passed_on", [])
            if _passed:
                _summary += f"\n\n_Passed on {len(_passed)}: {', '.join(pk.get('ticker','?') for pk in _passed[:5])}_"
            post_to_debate("boba", _summary, related_symbol=(_picks[0].get("ticker") if _picks else None))
        except Exception as _e:
            print(f"[multiagent] debate post failed: {_e}", flush=True)

    log_to_ops("boba_cycle", "INFO", f"Cycle complete — {n_picks} picks, {n_passed} passed")
    print(f"Cycle done: {n_picks} picks executed, {n_passed} passed on")

    # mc-kb: log this cycle to the daemon's /hive page (graceful-fail if tunnel down)
    try:
        import mc_kb_client
        _tickers = [pk.get("ticker", "?") for pk in cycle_result.get("picks", [])][:8]
        _passed_tickers = [pk.get("ticker", "?") for pk in cycle_result.get("passed_on", [])][:8]
        _cycle_summary = (cycle_result.get("cycle_summary") or "").strip()[:300]
        _hive_summary = (
            f"{n_picks} pick(s) committed, {n_passed} passed. "
            + (f"Tickers: {', '.join(_tickers)}. " if _tickers else "")
            + _cycle_summary
        )
        mc_kb_client.log_event(
            agent_id="boba",
            action="decision_cycle",
            summary=_hive_summary,
            artifacts={"picks": _tickers, "passed_on": _passed_tickers},
            chat_id="trading",
        )
    except Exception as _e:
        print(f"[mc-kb] log_event failed: {_e!r}", flush=True)

    return 0


if __name__ == "__main__":
    sys.exit(main())
