#!/usr/bin/env python3
import json, os, sys, traceback
from datetime import datetime
import discord

BASE_DIR = os.path.dirname(os.path.abspath(__file__))
CONFIG_PATH = os.path.join(BASE_DIR, "synth_config.json")
STATE_PATH = os.path.join(BASE_DIR, "sent_ids.json")
HISTORY_PATH = os.path.join(BASE_DIR, "synth_history.json")
SECRETS = os.path.expanduser("~/.openclaw/secrets")

def _s(n):
    with open(os.path.join(SECRETS, n)) as f: return f.read().strip()

TOKEN = _s("discord_synthcontrol_token")
CHANNEL_ID = int(_s("discord_synthcontrol_channel"))
OWNER_ID = int(_s("discord_user_id"))

DEFAULTS = {"cadence_minutes": 30, "topn": 20, "min_premium": 0, "watch": [], "mute": []}

def load_config():
    if not os.path.exists(CONFIG_PATH):
        save_config(DEFAULTS); return dict(DEFAULTS)
    try:
        with open(CONFIG_PATH) as f: cfg = json.load(f)
        for k, v in DEFAULTS.items():
            if k not in cfg: cfg[k] = v
        return cfg
    except: return dict(DEFAULTS)

def save_config(cfg):
    tmp = CONFIG_PATH + ".tmp"
    with open(tmp, "w") as f: json.dump(cfg, f, indent=2)
    os.replace(tmp, CONFIG_PATH)

def parse_prem(t):
    t = t.strip().upper().replace("$", "").replace(",", "")
    mult = 1
    if t.endswith("K"): mult = 1000; t = t[:-1]
    elif t.endswith("M"): mult = 1000000; t = t[:-1]
    return int(float(t) * mult)

def fmt_prem(v):
    if v >= 1000000: return f"${v/1000000:.1f}M"
    if v >= 1000: return f"${v/1000:.0f}K"
    return f"${v:.0f}"

intents = discord.Intents.default()
intents.message_content = True
client = discord.Client(intents=intents)

@client.event
async def on_ready():
    print(f"[synth-control-bot] logged in as {client.user} (id={client.user.id})")
    print(f"[synth-control-bot] listening in channel {CHANNEL_ID} for owner {OWNER_ID}")
    ch = client.get_channel(CHANNEL_ID)
    if ch:
        try: await ch.send(f"```synth-control-bot online {datetime.now().strftime('%H:%M:%S')}```")
        except Exception as e: print(f"startup ping failed: {e}")

@client.event
async def on_message(msg):
    if msg.author.id != OWNER_ID: return
    if msg.channel.id != CHANNEL_ID: return
    if not msg.content.startswith("!"): return
    parts = msg.content[1:].split()
    if not parts: return
    cmd = parts[0].lower()
    args = parts[1:]
    try: await dispatch(msg, cmd, args)
    except Exception as e:
        tb = traceback.format_exc()[:1500]
        await msg.channel.send(f"error in `{cmd}`: `{e}`\n```{tb}```")

async def dispatch(msg, cmd, args):
    cfg = load_config()
    if cmd == "help":
        await msg.channel.send(HELP); return
    if cmd == "config":
        await msg.channel.send(f"```json\n{json.dumps(cfg, indent=2)}\n```"); return
    if cmd == "refresh":
        await handle_refresh(msg); return
    if cmd == "cadence":
        if not args:
            await msg.channel.send(f"cadence is {cfg['cadence_minutes']} min. usage: !cadence 15"); return
        n = int(args[0])
        if n < 1 or n > 1440:
            await msg.channel.send("cadence must be 1-1440"); return
        cfg["cadence_minutes"] = n; save_config(cfg)
        await msg.channel.send(f"cadence set to {n} min"); return
    if cmd == "topn":
        if not args:
            await msg.channel.send(f"topn is {cfg['topn']}. usage: !topn 25"); return
        n = int(args[0])
        if n < 1 or n > 50:
            await msg.channel.send("topn must be 1-50"); return
        cfg["topn"] = n; save_config(cfg)
        await msg.channel.send(f"topn set to {n}"); return
    if cmd == "minprem":
        if not args:
            cur = fmt_prem(cfg["min_premium"]) if cfg["min_premium"] else "$0 (no floor)"
            await msg.channel.send(f"minprem is {cur}. usage: !minprem 150K | !minprem 1M | !minprem 0"); return
        v = parse_prem(args[0])
        cfg["min_premium"] = v; save_config(cfg)
        await msg.channel.send(f"min_premium set to {fmt_prem(v)}"); return
    if cmd in ("watch", "unwatch", "mute", "unmute"):
        if not args:
            await msg.channel.send(f"usage: !{cmd} TICKER"); return
        t = args[0].upper()
        key = "watch" if cmd in ("watch", "unwatch") else "mute"
        add = cmd in ("watch", "mute")
        lst = cfg.get(key, [])
        if add and t not in lst: lst.append(t)
        elif not add and t in lst: lst.remove(t)
        cfg[key] = lst; save_config(cfg)
        await msg.channel.send(f"{key} now: {lst if lst else '(empty)'}"); return
    if cmd == "reset":
        save_config(dict(DEFAULTS))
        await msg.channel.send(f"```json\n{json.dumps(dict(DEFAULTS), indent=2)}\n```")
        await msg.channel.send("config reset to defaults"); return
    if cmd == "history":
        await handle_history(msg); return
    if cmd == "stats":
        await handle_stats(msg); return
    if cmd == "crefresh":
        await handle_crefresh(msg); return
    if cmd == "ccadence":
        if not args:
            await msg.channel.send(f"crypto cadence is {cfg.get('crypto_cadence_minutes', 15)} min. usage: !ccadence 15"); return
        n = int(args[0])
        if n < 1 or n > 1440:
            await msg.channel.send("ccadence must be 1-1440"); return
        cfg["crypto_cadence_minutes"] = n; save_config(cfg)
        await msg.channel.send(f"crypto cadence set to {n} min"); return
    if cmd == "ccoins":
        if not args:
            cur = cfg.get("crypto_symbols", [])
            await msg.channel.send(f"crypto symbols: {cur}. usage: !ccoins BTC ETH SOL"); return
        syms = [a.upper().strip() for a in args]
        cfg["crypto_symbols"] = syms; save_config(cfg)
        await msg.channel.send(f"crypto symbols set to: {syms}"); return
    await msg.channel.send(f"unknown command `{cmd}`. try !help")

async def handle_refresh(msg):
    await msg.channel.send("force-firing rollup...")
    sys.path.insert(0, BASE_DIR)
    for m in list(sys.modules.keys()):
        if m == "discord_relay" or m.startswith("discord_relay."):
            del sys.modules[m]
    import discord_relay as dr
    try:
        with open(STATE_PATH) as f: state = json.load(f)
    except: state = {}
    state.pop("synthetic_analysis_last_post", None)
    result = dr.relay_synthetic_analysis(state)
    if result and "synthetic_analysis_last_post" in result:
        try:
            with open(STATE_PATH) as f: cur = json.load(f)
        except: cur = {}
        cur["synthetic_analysis_last_post"] = result["synthetic_analysis_last_post"]
        if "synthetic_analysis_prev" in result:
            cur["synthetic_analysis_prev"] = result["synthetic_analysis_prev"]
        tmp = STATE_PATH + ".tmp"
        with open(tmp, "w") as f: json.dump(cur, f)
        os.replace(tmp, STATE_PATH)
        await msg.channel.send("rollup posted to #synthetic-analysis")
    else:
        await msg.channel.send("relay returned without posting (likely empty flow data, check relay.log)")

async def handle_history(msg):
    if not os.path.exists(HISTORY_PATH):
        await msg.channel.send("no history file yet (created after first post)"); return
    try:
        with open(HISTORY_PATH) as f: h = json.load(f)
    except: h = []
    if not h:
        await msg.channel.send("history empty"); return
    last5 = h[-5:][::-1]
    lines = ["```"]
    for it in last5:
        ts = datetime.fromtimestamp(it.get("ts", 0)).strftime("%m/%d %H:%M")
        lines.append(f"{ts}  pct={it.get('pct',0):.0f}%  bull={it.get('bull','?')}  bear={it.get('bear','?')}  n={it.get('n','?')}")
    lines.append("```")
    await msg.channel.send("\n".join(lines))

async def handle_stats(msg):
    if not os.path.exists(HISTORY_PATH):
        await msg.channel.send("no history file yet"); return
    try:
        with open(HISTORY_PATH) as f: h = json.load(f)
    except: h = []
    today = datetime.now().strftime("%Y-%m-%d")
    todays = [x for x in h if datetime.fromtimestamp(x.get("ts", 0)).strftime("%Y-%m-%d") == today]
    if not todays:
        await msg.channel.send("no posts today"); return
    pcts = [x.get("pct", 0) for x in todays]
    avg = sum(pcts)/len(pcts); hi = max(pcts); lo = min(pcts)
    latest = todays[-1]
    line = f"{len(todays)} posts today. avg {avg:.0f}% bull. range {lo:.0f}-{hi:.0f}%. latest {latest.get('pct',0):.0f}%"
    await msg.channel.send(f"```{line}```")


async def handle_crefresh(msg):
    await msg.channel.send("force-firing crypto rollup...")
    sys.path.insert(0, BASE_DIR)
    for m in list(sys.modules.keys()):
        if m == "discord_relay" or m.startswith("discord_relay."):
            del sys.modules[m]
    import discord_relay as dr
    try:
        with open(STATE_PATH) as f: state = json.load(f)
    except: state = {}
    state.pop("crypto_sentiment_last_post", None)
    result = dr.relay_crypto_sentiment(state)
    if result and "crypto_sentiment_last_post" in result:
        try:
            with open(STATE_PATH) as f: cur = json.load(f)
        except: cur = {}
        cur["crypto_sentiment_last_post"] = result["crypto_sentiment_last_post"]
        if "crypto_sentiment_prev" in result:
            cur["crypto_sentiment_prev"] = result["crypto_sentiment_prev"]
        tmp = STATE_PATH + ".tmp"
        with open(tmp, "w") as f: json.dump(cur, f)
        os.replace(tmp, STATE_PATH)
        await msg.channel.send("crypto rollup posted to #crypto-sentiment")
    else:
        await msg.channel.send("relay returned without posting (check relay.log)")

HELP = """```
synth-control-bot commands:
  !refresh           force-post stock rollup now
  !crefresh          force-post crypto rollup now
  !config            show current settings
  !cadence <min>     stock cadence (1-1440)
  !ccadence <min>    crypto cadence (1-1440)
  !topn <n>          change Top N tickers (1-50)
  !minprem <amt>     min premium floor (150K | 1M | 0)
  !ccoins <syms>     crypto symbols (e.g. BTC ETH SOL)
  !watch <TKR>       pin a ticker
  !unwatch <TKR>     remove pin
  !mute <TKR>        exclude ticker
  !unmute <TKR>      re-include
  !history           last 5 rollups
  !stats             today's bull/bear ratio
  !reset             restore defaults
  !help              this message
```"""

if __name__ == "__main__":
    client.run(TOKEN)
