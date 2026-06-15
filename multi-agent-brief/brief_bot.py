#!/usr/bin/env python3
"""multi-agent brief — Grok+Orion+flow+journal → Sonnet 4-6 → Discord embed."""
import sys, json, logging, argparse
from pathlib import Path
from datetime import datetime, timezone, timedelta
import requests

SECRETS = Path("/home/ubuntu/.openclaw/secrets")
LOG_DIR = Path("/home/ubuntu/.openclaw/workspace/logs"); LOG_DIR.mkdir(parents=True, exist_ok=True)
logging.basicConfig(filename=LOG_DIR/"multi_agent_brief.log", level=logging.INFO,
                    format="%(asctime)s %(levelname)s %(message)s")
log = logging.getLogger()

CHANS = {
    "premarket":  "1498004322733260891",
    "morning":    "1490370402126532769",
    "midday":     "1490370454672900137",
    "eod":        "1490370506866819142",
    "afterhours": "1490370558536323112",
}
COLORS = {"premarket":0x00d2a0, "morning":0x4dabf7, "midday":0xffa502, "eod":0xef5350, "afterhours":0x868e96}
PROMPTS = {
    "premarket": "Generate a PRE-MARKET BRIEF (7:45AM ET). Cover overnight crypto/futures, earnings before open, macro events today, after-hours whale flow, 2-3 watchlist tickers with conviction.",
    "morning":   "Generate a MORNING BRIEF (9:45AM ET, 15min after open). Cover opening tape (SPY/QQQ/VIX), sector leadership, immediate flow developments, executed trades from open, watch into midday.",
    "midday":    "Generate a MIDDAY BRIEF (1PM ET). Cover morning P&L, regime check (risk-on/off), afternoon catalysts, flow into close, position adjustments.",
    "eod":       "Generate an EOD BRIEF (4PM ET). Cover day's P&L, what worked/didn't, closing flow (smart money window), tomorrow's setup, overnight crypto watch.",
    "afterhours":"Generate an AFTER-HOURS BRIEF (8:30PM ET). Cover post-close earnings reactions, AH flow, Asia open implications, key levels for tomorrow, X/news since close.",
}

def secret(name):
    p = SECRETS / name
    return p.read_text().strip() if p.exists() else ""

def grok_sentiment(hours=4):
    token = secret("spacer_bot_token.txt")
    if not token: return "no token"
    try:
        r = requests.get("https://discord.com/api/v10/channels/1497448514404356136/messages?limit=20",
                         headers={"Authorization": f"Bot {token}"}, timeout=15)
        if r.status_code != 200: return f"grok HTTP {r.status_code}"
        cutoff = datetime.now(timezone.utc) - timedelta(hours=hours)
        recent = [m for m in r.json()
                  if datetime.fromisoformat(m["timestamp"].replace("Z","+00:00")) > cutoff and m.get("content")]
        if not recent: return "no recent grok updates"
        return "\n".join(f"- {m['content'][:300]}" for m in recent[:10])
    except Exception as e:
        log.warning(f"grok: {e}"); return "grok error"

def orion_tech():
    base = Path("/home/ubuntu/mission-control/signal-receiver/data")
    out = {}
    for f in ("market_regime.json", "optimal_params.json", "latest_state.json"):
        p = base / f
        if p.exists():
            try: out[f.replace(".json","")] = json.loads(p.read_text())
            except: pass
    return out

def live_flow():
    try:
        r = requests.get("http://localhost:3000/api/live-signals", timeout=10)
        if r.status_code == 200:
            d = r.json()
            return {"topWatched": d.get("topWatched",[])[:5],
                    "recentSignals": d.get("recentSignals",[])[:10],
                    "picksExecuted": d.get("picksExecuted",[]),
                    "passedOn": d.get("passedOn",[])}
    except Exception as e: log.warning(f"flow: {e}")
    return {}

def journal(n=5):
    try:
        r = requests.get("http://localhost:3000/api/boba-journal", timeout=10)
        if r.status_code == 200:
            return [{"ticker":e.get("symbol"), "executed":e.get("executed"), "side":e.get("side"),
                     "reasoning":(e.get("reasoning") or "")[:300], "when":e.get("timestamp")}
                    for e in r.json().get("entries",[])[:n]]
    except Exception as e: log.warning(f"journal: {e}")
    return []

def synth(btype, ctx):
    prompt = f"""You are Boba, lead AI trader. {PROMPTS[btype]}

CONTEXT:

GROK X (last 4h):
{ctx['grok']}

ORION TECHNICALS:
{json.dumps(ctx['orion'], indent=2)[:2000]}

LIVE FLOW:
{json.dumps(ctx['flow'], indent=2)[:3000]}

RECENT BOBA DECISIONS (last 5):
{json.dumps(ctx['journal'], indent=2)[:2000]}

OUTPUT — Discord embed-friendly:
- Lead with 1-line take (bullish/bearish/chop)
- 3-4 labeled bullet sections
- End: TODAY'S TOP TRADE IDEA — ticker, direction, conviction (or "no setup")
- Max 1500 chars total. All numbers when possible. No fluff."""
    # Subscription-first (Mike's rule): the OAuth claude wallet via lib/llm.py, NEVER the
    # dead console anthropic_api_key. Briefs are prose (not JSON), so call the providers
    # directly and fall back to deepseek. Returns None if all fail → main() skips the post
    # (never publishes a "NO ANTHROPIC KEY" garbage embed again).
    import sys as _sys
    if "/home/itsju/05_AUTOMATION/scripts" not in _sys.path:
        _sys.path.insert(0, "/home/itsju/05_AUTOMATION/scripts")
    from lib.llm import _claude_oauth, _deepseek
    for _fn in (_claude_oauth, _deepseek):
        try:
            text, _usage = _fn(prompt)
            if text and text.strip():
                return text.strip()
        except Exception as e:
            log.warning(f"synth {_fn.__name__} failed: {e}")
    return None

def post(chan_id, btype, content):
    token = secret("spacer_bot_token.txt")
    et = datetime.now(timezone(timedelta(hours=-4)))
    embed = {"title": f"BOBA {btype.upper()} BRIEF",
             "description": content[:4000],
             "color": COLORS.get(btype, 0x607d8b),
             "footer": {"text": f"{et.strftime('%a %b %d, %I:%M %p ET')} · Multi-agent brief"}}
    r = requests.post(f"https://discord.com/api/v10/channels/{chan_id}/messages",
                      headers={"Authorization": f"Bot {token}", "Content-Type":"application/json"},
                      json={"embeds":[embed]}, timeout=15)
    if r.status_code in (200,201):
        log.info(f"posted {btype} → {chan_id}"); return True
    log.error(f"post fail {r.status_code}: {r.text[:200]}"); return False

def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("btype", choices=list(CHANS.keys()))
    args = ap.parse_args()
    log.info(f"=== {args.btype} brief ===")
    ctx = {"grok": grok_sentiment(), "orion": orion_tech(), "flow": live_flow(), "journal": journal()}
    log.info(f"ctx: grok={len(ctx['grok'])}c, orion={len(ctx['orion'])}k, flow keys={list(ctx['flow'].keys())}, journal={len(ctx['journal'])}e")
    content = synth(args.btype, ctx)
    if not content:
        log.error("synth returned nothing (all LLM providers failed) — skipping post")
        sys.exit(1)
    log.info(f"synth {len(content)}c")
    ok = post(CHANS[args.btype], args.btype, content)
    log.info(f"=== done ok={ok} ===")
    sys.exit(0 if ok else 1)

if __name__ == "__main__":
    main()
