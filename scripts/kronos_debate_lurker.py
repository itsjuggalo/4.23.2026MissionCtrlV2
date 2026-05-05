#!/usr/bin/env python3
"""
Kronos consultant in #agent-debate.

Runs every 5 min during market hours. Watches recent #agent-debate posts for ticker mentions.
For any ticker mentioned that we have a Kronos forecast for, if our forecast is meaningfully
different from agent consensus (e.g., agents lean bullish but Kronos says bearish high-confidence),
post a Kronos take to #agent-debate.

Pure consultant — never blocks decisions, only contributes data.
"""
import re, json, requests, sys
from pathlib import Path
from datetime import datetime, timezone, timedelta

sys.path.insert(0, "/home/ubuntu/scripts")
from lib.agent_debate import post_to_debate

SECRETS = Path("/home/ubuntu/.openclaw/secrets")
KRONOS_DIR = Path("/home/ubuntu/.openclaw/workspace/directives/kronos_forecasts")
DEBATE_CHANNEL = "1498788205544214619"
STATE_FILE = Path("/home/ubuntu/.openclaw/workspace/state/kronos_lurker_state.json")
STATE_FILE.parent.mkdir(parents=True, exist_ok=True)

def load_state():
    if STATE_FILE.exists():
        try: return json.loads(STATE_FILE.read_text())
        except: pass
    return {"last_posted": {}}  # ticker → ISO timestamp

def save_state(s):
    STATE_FILE.write_text(json.dumps(s, indent=2))

def fetch_recent_debate_messages(limit=20):
    token = (SECRETS / "discord_kronos_token").read_text().strip()
    r = requests.get(
        f"https://discord.com/api/v10/channels/{DEBATE_CHANNEL}/messages?limit={limit}",
        headers={"Authorization": f"Bot {token}"}, timeout=10)
    if r.status_code != 200: return []
    return r.json()

def extract_tickers(text):
    """Find $XYZ or naked uppercase tickers 2-5 chars."""
    text = text.upper()
    explicit = set(re.findall(r"\$([A-Z]{1,5})\b", text))
    candidates = set(re.findall(r"\b([A-Z]{2,5})\b", text))
    # Filter common false positives
    blacklist = {"USD","EOD","DTE","ATM","OTM","ITM","IV","OI","TP","SL","NEW","HOLD","EXIT","TRIM",
                 "CALL","PUT","BUY","SELL","BULL","BEAR","HIGH","LOW","MID","T0","T1","T2","T3","T4",
                 "JSON","API","HTTP","ID","UTC","CET","ET","NYSE","NASDAQ","SPX","VIX","BRIEF","CONFIRMED",
                 "PICKS","FLOW","WINS","HUGE","FG","RSI","MACD","EMA","SMA","ADX","BB","HOD","LOD",
                 "OK","SO","OR","AT","BY","FOR","NOT","NO","YES","NEW","OLD","BIG","TOP","ALL"}
    tickers = (explicit | candidates) - blacklist
    return tickers

def load_kronos_forecast(ticker):
    f = KRONOS_DIR / f"latest_{ticker}.json"
    if not f.exists(): return None
    try:
        d = json.loads(f.read_text())
        gen = datetime.fromisoformat(d.get("generated_at","").replace("Z","+00:00"))
        age_h = (datetime.now(timezone.utc) - gen).total_seconds() / 3600
        if age_h > 12: return None  # stale
        return d
    except: return None

def main():
    state = load_state()
    msgs = fetch_recent_debate_messages(limit=15)
    if not msgs:
        print("(no debate messages)"); return
    
    # Aggregate ticker mentions across recent messages
    seen = {}  # ticker → list of (author, content_excerpt)
    for m in msgs:
        author = m.get("author",{}).get("username","?")
        if author == "Kronos": continue  # don't react to own posts
        content = m.get("content","") or ""
        for emb in m.get("embeds",[]):
            content += " " + (emb.get("title","") or "") + " " + (emb.get("description","") or "")
        for t in extract_tickers(content):
            seen.setdefault(t, []).append((author, content[:200]))
    
    if not seen:
        print("(no tickers in recent debate)"); return
    
    print(f"[kronos-lurker] tickers discussed: {list(seen.keys())}")
    
    # For each ticker, check Kronos forecast + post if novel/divergent
    posted = 0
    for ticker, mentions in seen.items():
        # Skip if posted about this ticker in last 4 hours
        last = state["last_posted"].get(ticker)
        if last:
            try:
                last_dt = datetime.fromisoformat(last)
                if (datetime.now(timezone.utc) - last_dt) < timedelta(hours=4):
                    continue
            except: pass
        
        forecast = load_kronos_forecast(ticker)
        if not forecast: continue
        
        direction = forecast.get("forecast_24h_direction", "?")
        confidence = forecast.get("forecast_24h_confidence", "?")
        target = forecast.get("forecast_24h_target", "?")
        current = forecast.get("current_price", "?")
        
        # Only speak when confidence is high or direction is strong
        if str(confidence).lower() in ("low", "very_low"): continue
        
        body = f"**Kronos forecast on {ticker}:**\n"
        body += f"Direction: **{direction}** (confidence: {confidence})\n"
        try:
            target_str = f"{float(target):.2f}"
            current_str = f"{float(current):.2f}"
        except Exception:
            target_str = str(target)
            current_str = str(current)
        body += f"24h target: ${target_str} (current ${current_str})\n\n"
        body += f"_Reacting to mentions in #agent-debate ({len(mentions)} message(s)). I am consultant only — do not let this block your call._"
        
        ok = post_to_debate("kronos", body, related_symbol=ticker)
        if ok:
            state["last_posted"][ticker] = datetime.now(timezone.utc).isoformat()
            posted += 1
            print(f"  ✓ posted Kronos take on {ticker}")
    
    if posted:
        save_state(state)
    print(f"[kronos-lurker] {posted} forecast post(s) sent")

if __name__ == "__main__":
    try:
        main()
    except Exception as e:
        print(f"ERROR: {e}")
        sys.exit(1)
