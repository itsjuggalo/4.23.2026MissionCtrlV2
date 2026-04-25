#!/usr/bin/env python3
"""TodoBot — Mike's todo list with Grok-powered triage. Auth-locked to one user."""
import asyncio, json, os, sys, time, uuid
from datetime import datetime, timezone, timedelta
from pathlib import Path
import discord, requests

SECRETS = Path.home() / ".openclaw" / "secrets"
WORKSPACE = Path.home() / ".openclaw" / "workspace"
TODOS_DIR = WORKSPACE / "todos"
TODOS_DIR.mkdir(parents=True, exist_ok=True)
TODOS_FILE = TODOS_DIR / "todos.json"
LOG_DIR = WORKSPACE / "logs"
LOG_DIR.mkdir(parents=True, exist_ok=True)
AUDIT_LOG = LOG_DIR / "todo_bot_audit.jsonl"

TOKEN = (SECRETS / "discord_todo_bot_token").read_text().strip()
AUTH_USER_ID = int((SECRETS / "mike_discord_user_id").read_text().strip())
XAI_KEY = (SECRETS / "xai_api_key").read_text().strip()

GROK_URL = "https://api.x.ai/v1/responses"
GROK_MODEL = "grok-4-fast-non-reasoning"

CATEGORIES = ["dev", "dashboard", "bot", "trading", "pine", "personal", "other"]
ENERGY = ["quick", "medium", "deep"]


def audit(action, detail):
    entry = {"ts": datetime.now(timezone.utc).isoformat(), "action": action, "detail": detail}
    with AUDIT_LOG.open("a") as f:
        f.write(json.dumps(entry) + "\n")
    print(f"[audit] {action}: {detail}", flush=True)


def load_todos():
    if not TODOS_FILE.exists():
        return []
    try:
        return json.loads(TODOS_FILE.read_text())
    except Exception:
        return []


def save_todos(todos):
    TODOS_FILE.write_text(json.dumps(todos, indent=2))


def next_id(todos):
    """Strictly sequential — never reuse IDs even after completion."""
    if not todos:
        return 1
    return max(t.get("id", 0) for t in todos) + 1


def call_grok(prompt, structured=False):
    body = {"model": GROK_MODEL, "input": prompt}
    try:
        r = requests.post(GROK_URL, headers={"Authorization": f"Bearer {XAI_KEY}", "Content-Type": "application/json"}, json=body, timeout=60)
        if r.status_code != 200:
            return None
        data = r.json()
        for block in data.get("output", []):
            for c in block.get("content", []) or []:
                if c.get("type") == "output_text":
                    txt = c.get("text", "").strip()
                    if structured and txt.startswith("```"):
                        txt = txt.split("```")[1]
                        if txt.startswith("json"):
                            txt = txt[4:]
                        txt = txt.rsplit("```", 1)[0].strip()
                    return txt
    except Exception as e:
        print(f"[grok-err] {e}", flush=True)
    return None


def categorize_with_grok(text):
    """Ask Grok to pick category + energy + estimate from free text."""
    prompt = (
        f'Categorize this todo: "{text}"\n\n'
        f'Categories: {", ".join(CATEGORIES)}\n'
        f'Energy levels: quick (<15min), medium (~1hr), deep (>2hr focused)\n\n'
        f'Respond with STRICT JSON only:\n'
        f'{{"category":"<one>","energy":"<one>","estimate_min":<int>,"reason":"<1 short sentence>"}}'
    )
    out = call_grok(prompt, structured=True)
    if not out:
        return {"category": "other", "energy": "medium", "estimate_min": 60, "reason": "(grok unavailable)"}
    try:
        d = json.loads(out)
        if d.get("category") not in CATEGORIES:
            d["category"] = "other"
        if d.get("energy") not in ENERGY:
            d["energy"] = "medium"
        d["estimate_min"] = int(d.get("estimate_min", 60))
        return d
    except Exception:
        return {"category": "other", "energy": "medium", "estimate_min": 60, "reason": "(parse failed)"}


def fmt_todo(t, idx_num=None):
    icons = {"dev": "🔧", "dashboard": "📊", "bot": "🤖", "trading": "📈", "pine": "📜", "personal": "🏠", "other": "•"}
    energy_e = {"quick": "⚡", "medium": "◐", "deep": "🧠"}
    icon = icons.get(t.get("category", "other"), "•")
    en = energy_e.get(t.get("energy", "medium"), "◐")
    num = idx_num or t.get("id", "?")
    age_min = (datetime.now(timezone.utc) - datetime.fromisoformat(t.get("created_at", "").replace("Z", "+00:00"))).total_seconds() / 60 if t.get("created_at") else 0
    age = f"{int(age_min)}m" if age_min < 60 else (f"{int(age_min/60)}h" if age_min < 1440 else f"{int(age_min/1440)}d")
    return f"`#{num}` {icon}{en} {t.get('text','')[:120]}  _·{age}·_"


# Discord setup
intents = discord.Intents.default()
intents.message_content = True
intents.messages = True
intents.guilds = True
client = discord.Client(intents=intents)

CHANNEL_NAMES = {"todo", "todo-list", "todos"}  # only respond in #todo


@client.event
async def on_ready():
    print(f"[todo] Logged in as {client.user} (id={client.user.id})", flush=True)
    print(f"[todo] Auth user: {AUTH_USER_ID}", flush=True)
    print(f"[todo] Active in channels: {CHANNEL_NAMES}", flush=True)
    audit("startup", f"as {client.user}")


@client.event
async def on_message(message):
    if message.author.id == client.user.id:
        return
    if message.author.id != AUTH_USER_ID:
        return
    # Only respond in #todo
    if message.channel.name not in CHANNEL_NAMES:
        return

    content = message.content.strip()
    if not content:
        return

    todos = load_todos()
    active = [t for t in todos if not t.get("completed_at")]

    # !help
    if content in ("!help", "!commands"):
        await message.channel.send(
            "**TodoBot commands:**\n"
            "`+ <text>` — add a todo (Grok auto-categorizes)\n"
            "`!list` — show all active\n"
            "`!list quick` / `medium` / `deep` — filter by energy\n"
            "`!list dev` / `bot` / `trading` / etc — filter by category\n"
            "`!done <id>` or `- <id>` — mark complete\n"
            "`!find <text>` — search active + completed\n"
            "`!triage` — Grok ranks what to do next\n"
            "`!recap` — what did I complete last 7 days\n"
            "`!stats` — counts by category/energy\n"
            "`!daily` — morning briefing (also runs auto at 8 AM)\n"
            "`!import-memory` — pull pending TODOs from Mission Control memory\n"
            "`!clear-done` — purge completed older than 30 days"
        )
        return

    # + <text> — quick add (also accept "add ...")
    if content.startswith("+ ") or content.lower().startswith("add "):
        text = content[2:] if content.startswith("+ ") else content[4:]
        text = text.strip()
        if not text:
            return
        async with message.channel.typing():
            cat = categorize_with_grok(text)
        new = {
            "id": next_id(todos),
            "text": text,
            "category": cat["category"],
            "energy": cat["energy"],
            "estimate_min": cat["estimate_min"],
            "actual_min": None,
            "created_at": datetime.now(timezone.utc).isoformat(),
            "completed_at": None,
            "source": "discord-quick-add",
            "ai_reason": cat.get("reason", ""),
        }
        todos.append(new)
        save_todos(todos)
        await message.channel.send(f"✓ Added {fmt_todo(new)}\n_{cat.get('reason','')}_")
        audit("add", f"#{new['id']} {text[:80]}")
        return

    # !done <id> or - <id>
    if content.startswith("!done") or content.startswith("- "):
        parts = content.replace("!done", "").replace("- ", "").strip().split()
        if not parts or not parts[0].isdigit():
            await message.channel.send("Usage: `!done 7` or `- 7`")
            return
        target_id = int(parts[0])
        for t in todos:
            if t.get("id") == target_id and not t.get("completed_at"):
                t["completed_at"] = datetime.now(timezone.utc).isoformat()
                if t.get("created_at"):
                    elapsed = (datetime.fromisoformat(t["completed_at"].replace("Z","+00:00")) - datetime.fromisoformat(t["created_at"].replace("Z","+00:00"))).total_seconds() / 60
                    t["actual_min"] = round(elapsed)
                save_todos(todos)
                await message.channel.send(f"✅ Done: {t.get('text','')[:120]}\n_open #{target_id} for {t.get('actual_min','?')}min · estimated {t.get('estimate_min','?')}min_")
                audit("done", f"#{target_id}")
                return
        await message.channel.send(f"❌ #{target_id} not found or already done")
        return

    # !list [filter]
    if content.startswith("!list"):
        parts = content.split()
        filt = parts[1].lower() if len(parts) > 1 else None
        items = active
        if filt in ENERGY:
            items = [t for t in items if t.get("energy") == filt]
        elif filt in CATEGORIES:
            items = [t for t in items if t.get("category") == filt]
        if not items:
            await message.channel.send(f"No active todos{f' in {filt}' if filt else ''}.")
            return
        # Group by category
        by_cat = {}
        for t in items:
            by_cat.setdefault(t.get("category","other"), []).append(t)
        chunks = []
        for cat in sorted(by_cat.keys()):
            chunks.append(f"\n**{cat.upper()}** ({len(by_cat[cat])})")
            for t in sorted(by_cat[cat], key=lambda x: -x.get("id",0))[:15]:
                chunks.append(fmt_todo(t))
        out = "\n".join(chunks)
        for c in [out[i:i+1900] for i in range(0, len(out), 1900)]:
            await message.channel.send(c)
        return

    # !find <text>
    if content.startswith("!find"):
        q = content[5:].strip().lower()
        if not q:
            await message.channel.send("Usage: `!find kronos`")
            return
        matches = [t for t in todos if q in t.get("text","").lower()]
        if not matches:
            await message.channel.send(f"No matches for `{q}`")
            return
        active_m = [t for t in matches if not t.get("completed_at")]
        done_m = [t for t in matches if t.get("completed_at")]
        out = []
        if active_m:
            out.append(f"**Active ({len(active_m)}):**")
            for t in active_m[:10]:
                out.append(fmt_todo(t))
        if done_m:
            out.append(f"\n**Completed ({len(done_m)}):**")
            for t in done_m[-5:]:
                out.append(f"~~{fmt_todo(t)}~~")
        await message.channel.send("\n".join(out)[:1900])
        return

    # !triage
    if content.startswith("!triage"):
        if not active:
            await message.channel.send("No active todos to triage.")
            return
        items_text = "\n".join(f"#{t['id']} [{t.get('category')}/{t.get('energy')}/~{t.get('estimate_min',60)}m] {t.get('text','')}" for t in active[:30])
        prompt = (
            f"Mike has these active todos in his Mission Control trading system:\n\n{items_text}\n\n"
            "Rank the TOP 5 he should tackle next session. For each, give:\n"
            "1. ID and one-line why\n"
            "2. Best block of time (quick/medium/deep)\n"
            "3. Any dependencies on other todos in the list\n"
            "Be terse, no fluff. End with a one-line 'NEXT MOVE' recommendation."
        )
        async with message.channel.typing():
            answer = call_grok(prompt) or "(Grok unavailable)"
        for c in [answer[i:i+1900] for i in range(0, len(answer), 1900)]:
            await message.channel.send(c)
        audit("triage", f"active={len(active)}")
        return

    # !recap — last 7 days completed
    if content.startswith("!recap"):
        cutoff = datetime.now(timezone.utc) - timedelta(days=7)
        recent_done = [t for t in todos if t.get("completed_at") and datetime.fromisoformat(t["completed_at"].replace("Z","+00:00")) >= cutoff]
        if not recent_done:
            await message.channel.send("Nothing completed in last 7 days.")
            return
        by_day = {}
        for t in recent_done:
            d = t["completed_at"][:10]
            by_day.setdefault(d, []).append(t)
        out = [f"**Completed last 7 days ({len(recent_done)} items):**"]
        for day in sorted(by_day.keys(), reverse=True):
            out.append(f"\n**{day}** ({len(by_day[day])})")
            for t in by_day[day]:
                out.append(f"  ✓ {t.get('text','')[:100]}")
        await message.channel.send("\n".join(out)[:1900])
        return

    # !stats
    if content.startswith("!stats"):
        if not todos:
            await message.channel.send("No todos yet.")
            return
        active_n = len(active)
        done_n = len(todos) - active_n
        cats = {}
        for t in active:
            cats[t.get("category","other")] = cats.get(t.get("category","other"), 0) + 1
        ens = {}
        for t in active:
            ens[t.get("energy","medium")] = ens.get(t.get("energy","medium"), 0) + 1
        out = [f"**Stats:**\n📋 Active: {active_n} | ✅ Done: {done_n}\n"]
        out.append("**By category:**")
        for c in sorted(cats.keys()):
            out.append(f"  {c}: {cats[c]}")
        out.append("\n**By energy:**")
        for e in sorted(ens.keys()):
            out.append(f"  {e}: {ens[e]}")
        await message.channel.send("\n".join(out))
        return

    # !daily
    if content.startswith("!daily"):
        cutoff = datetime.now(timezone.utc) - timedelta(hours=24)
        done_today = [t for t in todos if t.get("completed_at") and datetime.fromisoformat(t["completed_at"].replace("Z","+00:00")) >= cutoff]
        out = [f"☀️ **Daily Briefing — {datetime.now(timezone.utc).strftime('%A %b %d')}**\n"]
        out.append(f"Completed last 24h: {len(done_today)}")
        for t in done_today[:5]:
            out.append(f"  ✓ {t.get('text','')[:100]}")
        out.append(f"\nActive: {len(active)} todos")
        if active:
            quick = [t for t in active if t.get("energy") == "quick"]
            if quick:
                out.append(f"⚡ Quick wins: {len(quick)}")
                for t in quick[:3]:
                    out.append(f"  {fmt_todo(t)}")
        await message.channel.send("\n".join(out)[:1900])
        return

    # !import-memory — bootstrap from Mission Control TODOs already in user memory
    if content.startswith("!import-memory"):
        seeds = [
            ("dev", "deep", 240, "Pine Script: DayTrader v3 5m scalper"),
            ("dev", "medium", 90, "Pine Script: 30m SuperTrend filter on 1H v2.2"),
            ("dev", "deep", 240, "Pine Script: OC Long Hunter BTC v1"),
            ("dev", "deep", 240, "Pine Script: OC Short Hunter BTC v1"),
            ("dev", "deep", 360, "Pine Script: Holy Grail BTC 4-layer"),
            ("dev", "medium", 60, "TradingView backtest: Combined v2.2 on 1h BTCUSD 1Y"),
            ("dev", "medium", 60, "TradingView backtest: 4H v2.2 on 4h BTCUSD"),
            ("dev", "medium", 60, "TradingView backtest: 1D v2.2 on 1D BTCUSD"),
            ("dev", "medium", 60, "TradingView backtest: DayTrader v2.2 on 15m"),
            ("dashboard", "deep", 180, "Fix dashboard Copilot blocks #2/#4/#5 (rendering/data)"),
            ("dashboard", "deep", 240, "Mobile version of Mission Control dashboard"),
            ("dashboard", "deep", 180, "Portfolio correlation matrix page"),
            ("dashboard", "deep", 180, "Liquidation heatmap (CoinGlass API)"),
            ("dashboard", "deep", 180, "Short squeeze scanner on Scanner page"),
            ("dashboard", "medium", 90, "StarCraft Marine vs Protoss landing animation"),
            ("bot", "medium", 90, "Discord captcha bot for Trading Team HQ"),
            ("bot", "medium", 60, "Whale Alert monitor on-chain BTC/ETH >$10M"),
            ("bot", "medium", 60, "FRED economic calendar bot (FOMC/CPI/NFP)"),
            ("bot", "medium", 90, "Signal performance tracker bot"),
            ("bot", "deep", 180, "Free signal channel discovery (Discord+Telegram)"),
            ("personal", "deep", 240, "Massage site mikemassage.ddns.net"),
            ("dev", "medium", 60, "Kronos 6th agent design"),
            ("dev", "deep", 180, "Boba brief upgrade"),
            ("dev", "deep", 240, "Duplicate file/dead code cleanup audit"),
        ]
        added = 0
        for cat, en, est, txt in seeds:
            if any(t.get("text") == txt for t in todos):
                continue
            todos.append({
                "id": next_id(todos), "text": txt, "category": cat, "energy": en,
                "estimate_min": est, "actual_min": None,
                "created_at": datetime.now(timezone.utc).isoformat(),
                "completed_at": None, "source": "memory-import",
                "ai_reason": "imported from Mission Control memory",
            })
            added += 1
        save_todos(todos)
        await message.channel.send(f"✓ Imported {added} todos from memory ({len(todos)} total)")
        audit("import-memory", f"added={added}")
        return

    # !clear-done
    if content.startswith("!clear-done"):
        cutoff = datetime.now(timezone.utc) - timedelta(days=30)
        before = len(todos)
        todos = [t for t in todos if not t.get("completed_at") or datetime.fromisoformat(t["completed_at"].replace("Z","+00:00")) >= cutoff]
        save_todos(todos)
        await message.channel.send(f"🧹 Purged {before - len(todos)} completed todos older than 30 days")
        return

    # Anything else — ignore (not in #todo command set)
    return


if __name__ == "__main__":
    print("[todo] Starting...", flush=True)
    client.run(TOKEN, log_handler=None)
