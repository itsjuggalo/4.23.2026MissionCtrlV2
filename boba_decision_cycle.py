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
import json
import os
import subprocess
import sys
import time
from datetime import datetime, timedelta, timezone
from pathlib import Path

sys.path.insert(0, "/home/ubuntu/mission-control/agent-team")
from post_helper import post_to_telegram
from ops_log import log_to_ops

SECRETS = Path("/home/ubuntu/.openclaw/secrets")
STATE_DIR = Path("/home/ubuntu/.openclaw/workspace/state")
STATE_DIR.mkdir(parents=True, exist_ok=True)
SEEN_FILE = STATE_DIR / "boba_seen_signals.json"
KILLSWITCH = STATE_DIR / "boba_killswitch"
DECISIONS_LOG = Path("/home/ubuntu/.openclaw/workspace/skill_outputs/boba_decisions_validated.json")
DECISIONS_LOG.parent.mkdir(parents=True, exist_ok=True)
SIDECAR = Path("/home/ubuntu/mission-control/signal-receiver/data/scored_signals_recent.json")
FIREBASE_FEED = Path("/home/ubuntu/.openclaw/workspace/directives/firebase_trade_signals.json")

# Tradier live options quotes (bid/ask/IV/greeks) for informed contract selection
sys.path.insert(0, "/home/ubuntu/scripts/lib")
try:
    from tradier_client import fetch_option_quote as _tradier_quote
except Exception:
    _tradier_quote = None
KRONOS_CMD = "/home/ubuntu/mission-control/agent-team/kronos/kronos_on_demand.py"

MAX_PICKS_PER_CYCLE = 3
MAX_TOTAL_RISK_USD = 3000
SHORTLIST_SIZE = 5


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


def load_firebase_signals():
    """Load Firebase Name/Name2/Vivid trade signals (last 50)."""
    if not FIREBASE_FEED.exists():
        return []
    try:
        return json.loads(FIREBASE_FEED.read_text())
    except Exception:
        return []


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
    """Top N by score, ensuring ticker variety."""
    # Sort by score desc
    sorted_sigs = sorted(fresh_signals, key=lambda x: -x[1].get("score", 0))
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
            ["python3", KRONOS_CMD, "--ticker", ticker, "--option-context", option_context, "--no-discord"],
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
            ["python3", KRONOS_CMD, "--ticker", ticker, "--option-context", option_context],
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



def wait_for_kronos_result(ticker, timeout_sec=75, poll_interval=3):
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


def format_firebase_signals_for_prompt(signals, max_show=20):
    """Format last N Firebase trade signals (Name/Name2/Vivid) into prompt-ready text."""
    if not signals:
        return "  (no recent provider trade signals)"
    # Most recent first, cap at max_show
    recent = sorted(signals, key=lambda x: x.get("captured_at", ""), reverse=True)[:max_show]
    lines = []
    for s in recent:
        side = "PUT" if s.get("is_put") else "CALL"
        cat = s.get("category", "?")
        ticker = s.get("ticker", "?")
        strike = s.get("strike", "?")
        buy = s.get("buy_target", "?")
        sell = s.get("sell_target", "?")
        sl = s.get("stop_loss", "?")
        source = s.get("source", "?")
        risk = s.get("risk") or "?"
        is_free = s.get("is_free", False)
        free_tag = "FREE" if is_free else "PREMIUM"
        # Convert expiry timestamp to MM/DD if available
        exp_str = "?"
        ts = s.get("expiry_ts")
        if ts:
            try:
                from datetime import datetime as _dt
                exp_str = _dt.fromtimestamp(int(ts)).strftime("%m/%d")
            except Exception:
                pass
        lines.append(
            f"  - [{source}] {cat}: {ticker} ${strike} {side} exp {exp_str} | "
            f"Entry ${buy} → Target ${sell} | SL ${sl} | Risk: {risk} | {free_tag}"
        )
    return "\n".join(lines)



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
def build_boba_prompt(account, positions, shortlist_with_kronos):
    equity = float(account.get("equity", 0))
    buying_power = float(account.get("buying_power", 0))
    cash = float(account.get("cash", 0))

    pos_summary = "\n".join([
        f"  - {p.get('symbol')}: {p.get('qty')} @ ${p.get('avg_entry_price')} | P&L {float(p.get('unrealized_plpc',0))*100:+.1f}%"
        for p in positions
    ]) or "  (none open)"

    shortlist_text = ""
    for i, (sid, s, k) in enumerate(shortlist_with_kronos, 1):
        shortlist_text += f"\n\n--- CANDIDATE {i} ---\n"
        shortlist_text += f"Ticker: {s.get('ticker')}\n"
        shortlist_text += f"Contract: ${s.get('strike')} {s.get('option_type')} exp {s.get('expiry')} ({s.get('dte')} DTE)\n"
        shortlist_text += f"Tier: {s.get('tier','')} | Flow: {s.get('flow_value_raw')} | Vol/OI: {s.get('vol_oi_ratio')}x\n"
        shortlist_text += f"Sweeps/Blocks: {s.get('sweeps')}/{s.get('blocks')} | Spot: ${s.get('spot')}\n"
        shortlist_text += f"Score: {s.get('score')}/100 ({s.get('grade')})\n"

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

    firebase_signals_text = format_firebase_signals_for_prompt(load_firebase_signals(), max_show=20)

    prompt = f"""You are Boba — the decision-making agent in Mission Control's multi-agent trading system.

# Mission
Make positive-expected-value options trades using whale-tier ($1M+) options flow signals, validated by Kronos price forecasts. Target average R:R ≥ 1.5. You are NOT aiming for 80%+ win rate — you're aiming for edge × sizing × discipline.

# Account state
Equity: ${equity:,.2f}
Buying power: ${buying_power:,.2f}
Cash: ${cash:,.2f}
Open positions:
{pos_summary}

# Candidates to review (already filtered to $1M+ whale tier + today's signals)
{shortlist_text}

# Trade signals from providers (Name / Name2 / Vivid — last 20)
These are curated buy/sell calls from human-run provider services. Use them as INDEPENDENT confirmation: if a provider has called the same direction as a whale flow above, that's stronger alignment. Disagreement is also informative. Do NOT take a pick just because a provider called it — use these alongside whale flow + Kronos.
{firebase_signals_text}

# Your task
Pick UP TO 3 options to buy on Alpaca paper. You can pick 0, 1, 2, or 3. Only pick if the setup is genuinely good — if nothing is compelling, say so and skip.

For each pick, you MUST show due diligence. In the reasoning field, include these items concisely:

1. THESIS — One sentence on the directional/volatility view (e.g., "QQQ bearish next 10 days").
2. CONTRACT SELECTION — Why THIS strike/expiry beats 2 alternatives you considered. Compare at least 2 other strikes OR expiries and state why this one wins on R:R.
3. BREAKEVEN at expiry — calculate as (strike ± premium paid). For calls: strike + premium. For puts: strike − premium.
4. EXPECTED RETURN — If Kronos forecast plays out, estimate the contract's value at that price move. E.g., "Kronos says −5% on QQQ → QQQ=612 → $645P worth ~$33 intrinsic = +220% return."
5. MAX LOSS — premium × contracts × 100 (what you lose if contract expires worthless).
6. RISK FLAGS — name at least one: earnings in expiry window? known catalyst (FOMC, CPI)? low open interest? wide bid/ask spread? IV elevated? If no flags apply, state "none identified."
7. CONVICTION LEVEL — if 0-3 DTE: state the specific catalyst driving the short window. If no catalyst, explain why gamma risk is acceptable.

If you cannot answer items 3, 4, 5 with math, DO NOT PICK THAT CONTRACT — pick a different strike/expiry where you can, or pass entirely.

Additional decisions per pick:
- Number of contracts (consider buying power — don't exceed 15% of buying power per pick)
- Target profit % (default +50% if no strong reason otherwise)
- Max loss % (default -30%)

Hard limits:
- Max 3 picks total
- Max ${MAX_TOTAL_RISK_USD:,} total notional risk across all picks
- HARD GATE: Kronos CONFLICTS = AUTOMATIC VETO. Do NOT pick the contract. The ONLY override is if the flow score is ≥ 90 AND you must state the exact score number in your reasoning AND state why the flow override is justified
- HARD GATE: Kronos UNAVAILABLE (timeout/error) = AUTOMATIC VETO. Do NOT pick the contract unless flow score is ≥ 85 AND you state the exact score in your reasoning
- For every pick, you MUST set the `kronos_verdict` field in the JSON output to one of: AGREES | CONFLICTS | NEUTRAL | UNAVAILABLE — this is REQUIRED, not optional

# Response format (STRICT JSON, no prose outside the JSON)
{{
  "cycle_summary": "1-2 sentence overview of the current setup today",
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
      "stop_loss_pct": 30,
      "confidence": "high"
    }}
  ],
  "passed_on": [
    {{"ticker": "TSLA", "reason": "Kronos conflicts — forecast bearish but 250C is bullish thesis", "kronos_verdict": "CONFLICTS"}}
  ]
}}

Respond with ONLY the JSON. No preamble, no markdown fences.
"""
    return prompt


def call_boba(prompt):
    """Call Claude Sonnet with the prompt."""
    try:
        import requests
    except ImportError:
        return {"error": "requests not installed"}

    api_key = get_anthropic_key()
    if not api_key:
        return {"error": "no anthropic key"}

    try:
        r = requests.post(
            "https://api.anthropic.com/v1/messages",
            headers={
                "x-api-key": api_key,
                "anthropic-version": "2023-06-01",
                "content-type": "application/json",
            },
            json={
                "model": "claude-sonnet-4-5",
                "max_tokens": 2000,
                "messages": [{"role": "user", "content": prompt}],
            },
            timeout=90,
        )
        if r.status_code != 200:
            return {"error": f"API {r.status_code}: {r.text[:500]}"}
        data = r.json()
        text = ""
        for block in data.get("content", []):
            if block.get("type") == "text":
                text += block.get("text", "")
        # Parse JSON from response
        text = text.strip()
        if text.startswith("```"):
            text = text.split("```")[1]
            if text.startswith("json"):
                text = text[4:]
        try:
            return {"ok": True, "response": json.loads(text.strip()), "usage": data.get("usage", {})}
        except Exception as e:
            return {"error": f"JSON parse failed: {e}", "raw": text[:2000]}
    except Exception as e:
        return {"error": f"API call failed: {e}"}


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
            f"https://paper-api.alpaca.markets/v2/assets/{candidate_symbol}",
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


def _post_bobatrades(msg: str):
    """Fire-and-forget Discord webhook to BobaTrades. Never raises."""
    try:
        import requests
        from pathlib import Path
        hook = Path("/home/ubuntu/.openclaw/secrets/discord_bobatrades_webhook")
        if not hook.exists():
            return
        url = hook.read_text().strip()
        if not url:
            return
        requests.post(url, json={"content": msg}, timeout=5)
    except Exception:
        pass


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
            _post_bobatrades(f"❌ Boba buy REJECTED {occ_symbol} x{qty}\n{err}")
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
                f"Daemon will trail on next cycle. Order: {buy_id[:8]}"
            )
            return {
                "ok": True, "symbol": occ_symbol, "order_id": buy_id,
                "fill_price": None, "protection_order_id": None,
                "protection_status": "SKIPPED (buy did not fill in 10s — daemon will trail)",
            }

        # 3. Submit OCO bracket — SL + TP as single broker-managed pair
        stop_loss_pct = float(pick.get("stop_loss_pct", 30))
        profit_target_pct = float(pick.get("profit_target_pct", 50))
        stop_trigger = round(max(fill_price * (1 - stop_loss_pct / 100), 0.01), 2)
        stop_limit = round(max(stop_trigger * 0.90, 0.01), 2)
        tp_price = round(max(fill_price * (1 + profit_target_pct / 100), 0.01), 2)

        oco_order = {
            "symbol": occ_symbol,
            "qty": str(qty),
            "side": "sell",
            "type": "limit",
            "time_in_force": "gtc",
            "order_class": "oco",
            "take_profit": {"limit_price": str(tp_price)},
            "stop_loss": {"stop_price": str(stop_trigger), "limit_price": str(stop_limit)},
        }
        prot_r = requests.post(
            "https://paper-api.alpaca.markets/v2/orders",
            headers=headers, json=oco_order, timeout=10,
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
                f"Daemon will trail. {prot_r.text[:150]}"
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


def log_decision(cycle_result, picks_executed):
    entry = {
        "cycle_time": datetime.now(timezone.utc).isoformat(),
        "cycle_summary": cycle_result.get("cycle_summary", ""),
        "picks_proposed": len(cycle_result.get("picks", [])),
        "picks_executed": picks_executed,
        "passed_on": cycle_result.get("passed_on", []),
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
        cached = check_fresh_kronos_file(ticker, max_age_minutes=90)
        if cached and "error" not in cached:
            # We have a recent forecast — annotate it with option context if needed
            if "option_in_forecast_direction" not in cached or cached.get("option_context") != option_ctx:
                cached["option_context"] = option_ctx
                is_call = "C" in option_ctx.upper().split()[0]
                is_put = "P" in option_ctx.upper().split()[0]
                direction = cached.get("forecast_24h_direction", "neutral")
                if is_call:
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
            waited = wait_for_kronos_result(ticker, timeout_sec=75, poll_interval=3)
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
    prompt = build_boba_prompt(account, positions, shortlist_with_kronos)
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

    # 7. Execute picks
    picks_executed = []
    for pick in cycle_result.get("picks", [])[:MAX_PICKS_PER_CYCLE]:
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
        exec_result = execute_pick_on_alpaca(converted_pick)
        converted_pick["execution"] = exec_result
        picks_executed.append(converted_pick)

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

    log_to_ops("boba_cycle", "INFO", f"Cycle complete — {n_picks} picks, {n_passed} passed")
    print(f"Cycle done: {n_picks} picks executed, {n_passed} passed on")
    return 0


if __name__ == "__main__":
    sys.exit(main())
