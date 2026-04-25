#!/usr/bin/env python3
"""AskGrok Discord Bot — Mike's personal assistant. Auth-locked to one user ID."""
import asyncio, json, os, sys, time
from datetime import datetime, timezone
from pathlib import Path
import discord, requests

SECRETS = Path.home() / ".openclaw" / "secrets"
LOG_DIR = Path.home() / ".openclaw" / "workspace" / "logs"
LOG_DIR.mkdir(parents=True, exist_ok=True)
AUDIT_LOG = LOG_DIR / "askgrok_bot_audit.jsonl"

TOKEN = (SECRETS / "discord_askgrok_token").read_text().strip()
AUTH_USER_ID = int((SECRETS / "mike_discord_user_id").read_text().strip())
XAI_KEY = (SECRETS / "xai_api_key").read_text().strip()

GROK_URL = "https://api.x.ai/v1/responses"
GROK_MODEL = "grok-4-fast-non-reasoning"

pending_confirms = {}


def audit(action, detail):
    entry = {"ts": datetime.now(timezone.utc).isoformat(), "action": action, "detail": detail}
    with AUDIT_LOG.open("a") as f:
        f.write(json.dumps(entry) + "\n")
    print(f"[audit] {action}: {detail}", flush=True)


def call_grok(user_query, context=""):
    prompt = (
        f"You are Mike's personal assistant in a Discord channel. "
        f"He asks you questions; you answer using x_search when current info is needed. "
        f"Be concise (under 1500 chars), specific, cite X handles when relevant.\n\n"
        f"{context}\n\n"
        f"Mike's question: {user_query}"
    )
    try:
        r = requests.post(
            GROK_URL,
            headers={"Authorization": f"Bearer {XAI_KEY}", "Content-Type": "application/json"},
            json={"model": GROK_MODEL, "input": prompt, "tools": [{"type": "x_search"}]},
            timeout=180,
        )
        if r.status_code != 200:
            return f"Grok API error {r.status_code}: {r.text[:300]}"
        data = r.json()
        for block in data.get("output", []):
            for c in block.get("content", []) or []:
                if c.get("type") == "output_text":
                    return c.get("text", "(empty response)")
        return "(no output_text)"
    except Exception as e:
        return f"Grok call failed: {e}"


intents = discord.Intents.default()
intents.message_content = True
intents.messages = True
intents.guilds = True
client = discord.Client(intents=intents)


@client.event
async def on_ready():
    print(f"[askgrok] Logged in as {client.user} (id={client.user.id})", flush=True)
    print(f"[askgrok] Auth user: {AUTH_USER_ID}", flush=True)
    for g in client.guilds:
        print(f"  Guild: {g.name} ({len(g.text_channels)} channels)", flush=True)
    audit("startup", f"as {client.user}, {len(client.guilds)} guilds")


@client.event
async def on_message(message):
    if message.author.id == client.user.id:
        return
    if message.author.id != AUTH_USER_ID:
        return
    content = message.content.strip()
    if not content:
        return

    if content.upper() == "CONFIRM" and message.author.id in pending_confirms:
        action_fn, expires_at = pending_confirms[message.author.id]
        if time.time() > expires_at:
            await message.channel.send("⏰ Confirmation expired. Try again.")
            del pending_confirms[message.author.id]
            return
        del pending_confirms[message.author.id]
        try:
            await action_fn(message)
        except Exception as e:
            await message.channel.send(f"❌ Action failed: {e}")
            audit("action_failed", str(e))
        return

    if content.upper() == "CANCEL" and message.author.id in pending_confirms:
        del pending_confirms[message.author.id]
        await message.channel.send("🛑 Cancelled.")
        return

    if content.startswith("!audit"):
        if not AUDIT_LOG.exists():
            await message.channel.send("No audit entries yet.")
            return
        lines = AUDIT_LOG.read_text().strip().splitlines()[-15:]
        recap = "\n".join(f"`{json.loads(l).get('ts','')[:19]}` **{json.loads(l).get('action','')}** {json.loads(l).get('detail','')[:80]}" for l in lines)
        await message.channel.send(f"**Last 15 actions:**\n{recap[:1900]}")
        return

    if content.startswith("!read"):
        parts = content.split(maxsplit=2)
        if len(parts) < 2 or not message.channel_mentions:
            await message.channel.send("Usage: `!read #channel-name 50`")
            return
        target = message.channel_mentions[0]
        n = int(parts[2]) if len(parts) > 2 and parts[2].isdigit() else 30
        n = min(n, 100)
        async with message.channel.typing():
            history = [m async for m in target.history(limit=n)]
            transcript = "\n".join(f"[{m.created_at.strftime('%H:%M')}] {m.author.name}: {m.content[:300]}" for m in reversed(history) if m.content)
            answer = call_grok(
                f"Summarize what's been discussed in #{target.name}. Highlight key info, decisions, action items.",
                context=f"Recent {n} messages from #{target.name}:\n{transcript[:8000]}"
            )
        for chunk in [answer[i:i+1900] for i in range(0, len(answer), 1900)]:
            await message.channel.send(chunk)
        audit("read_channel", f"{target.name} last {n}")
        return

    if content.startswith("!rename-channel"):
        parts = content.split(maxsplit=2)
        if len(parts) < 3 or not message.channel_mentions:
            await message.channel.send('Usage: `!rename-channel #old new-name`')
            return
        target = message.channel_mentions[0]
        new_name = parts[2].strip().replace(" ", "-")[:100]
        async def do_rename(_msg):
            await target.edit(name=new_name)
            await _msg.channel.send(f"✓ Renamed to `#{new_name}`")
            audit("rename_channel", f"{target.id} {target.name} → {new_name}")
        pending_confirms[message.author.id] = (do_rename, time.time() + 60)
        await message.channel.send(f"⚠️ Rename `#{target.name}` → `#{new_name}`?\nReply **CONFIRM** within 60s.")
        return

    if content.startswith("!delete-msg"):
        parts = content.split()
        if len(parts) < 2 or not parts[1].isdigit():
            await message.channel.send("Usage: `!delete-msg 123456789`")
            return
        msg_id = int(parts[1])
        async def do_delete(_msg):
            try:
                target_msg = await message.channel.fetch_message(msg_id)
                await target_msg.delete()
                await _msg.channel.send(f"✓ Deleted {msg_id}")
                audit("delete_msg", f"channel={message.channel.name} msg_id={msg_id}")
            except discord.NotFound:
                await _msg.channel.send(f"❌ Message not found")
        pending_confirms[message.author.id] = (do_delete, time.time() + 60)
        await message.channel.send(f"⚠️ Delete message `{msg_id}`?\nReply **CONFIRM** within 60s.")
        return

    if content.startswith("!pin"):
        parts = content.split()
        if len(parts) < 2 or not parts[1].isdigit():
            await message.channel.send("Usage: `!pin 123456789`")
            return
        msg_id = int(parts[1])
        try:
            target_msg = await message.channel.fetch_message(msg_id)
            await target_msg.pin()
            await message.channel.send(f"📌 Pinned {msg_id}")
            audit("pin_msg", f"msg_id={msg_id}")
        except Exception as e:
            await message.channel.send(f"❌ {e}")
        return

    # !flowpicks N — rank last N min of $1M+ flow by best risk-adjusted % return
    if content.startswith("!flowpicks"):
        parts = content.split()
        minutes = int(parts[1]) if len(parts) > 1 and parts[1].isdigit() else 60
        minutes = min(minutes, 720)  # cap at 12h

        await message.channel.send(f"🔍 Loading $1M+ flow from last {minutes}min, fetching live quotes...")

        try:
            sys.path.insert(0, "/home/ubuntu/scripts")
            sys.path.insert(0, "/home/ubuntu/scripts/lib")
            import json as _json
            from datetime import datetime as _dt, timezone as _tz, timedelta as _td

            sidecar_path = Path("/home/ubuntu/mission-control/signal-receiver/data/scored_signals_recent.json")
            if not sidecar_path.exists():
                await message.channel.send("❌ No sidecar file found")
                return

            sigs = _json.loads(sidecar_path.read_text())
            cutoff = _dt.now(_tz.utc) - _td(minutes=minutes)
            fresh = []
            for s in sigs:
                ts_str = s.get("timestamp", "")
                if not ts_str:
                    continue
                try:
                    ts = _dt.fromisoformat(ts_str.replace("Z", "+00:00"))
                except Exception:
                    continue
                if ts >= cutoff and float(s.get("flow_value", 0)) >= 1_000_000:
                    fresh.append(s)

            if not fresh:
                await message.channel.send(f"No $1M+ flow signals in last {minutes}min.")
                return

            # Top 8 by score for ranking
            fresh.sort(key=lambda x: -x.get("score", 0))
            top = fresh[:8]

            # Fetch live Tradier quotes for each
            from boba_decision_cycle import fetch_live_option_quote, check_fresh_kronos_file
            enriched = []
            for s in top:
                lq = fetch_live_option_quote(
                    s.get("ticker"), s.get("strike"),
                    s.get("option_type"), s.get("expiry")
                )
                kr = check_fresh_kronos_file(s.get("ticker"), max_age_minutes=240) or {}
                enriched.append({"sig": s, "quote": lq, "kronos": kr})

            # Build context for Grok
            ctx_parts = []
            for i, e in enumerate(enriched, 1):
                s = e["sig"]
                q = e["quote"] or {}
                k = e["kronos"]
                line = (
                    f"#{i} {s.get('ticker')} ${s.get('strike')} {s.get('option_type')} "
                    f"exp {s.get('expiry')} ({s.get('dte')} DTE) | "
                    f"Flow {s.get('flow_value_raw')} | Vol/OI {s.get('vol_oi_ratio')}x | "
                    f"Spot ${s.get('spot')} | Score {s.get('score')}/100"
                )
                if q.get("mid"):
                    line += (
                        f"\n   LIVE: bid ${q['bid']:.2f} / ask ${q['ask']:.2f} / mid ${q['mid']:.2f}"
                        f" | spread {q['spread_pct']}% | IV {q['iv']:.2f} | Δ {q['delta']:+.2f} | Θ {q['theta']:+.3f}/d"
                    )
                else:
                    line += "\n   LIVE: (Tradier unavailable)"
                if k.get("forecast_24h_direction") and k.get("forecast_24h_direction") != "pending":
                    line += (
                        f"\n   KRONOS: {k.get('forecast_24h_direction')} target ${k.get('forecast_24h_target','?')}"
                        f" (current ${k.get('current_price','?')}) | agree={k.get('option_in_forecast_direction')}"
                    )
                ctx_parts.append(line)
            context = "\n\n".join(ctx_parts)

            # Ask Grok to rank
            question = (
                "From the candidates above, pick the TOP 3 with the BEST risk-adjusted % return potential. "
                "For each pick show the math:\n"
                "1. THESIS - 1 sentence directional view\n"
                "2. ENTRY - mid price as cost basis\n"
                "3. BREAKEVEN at expiry (strike +/- premium)\n"
                "4. TARGET MOVE needed (from Kronos forecast or Δ-implied)\n"
                "5. EXPECTED RETURN % if target hits (delta * underlying move - theta decay over DTE)\n"
                "6. MAX LOSS = premium * 100 if expires worthless\n"
                "7. R:R RATIO = expected_gain / max_loss\n"
                "8. RISK FLAGS (wide spread >5%, low DTE, IV elevated, Kronos conflict)\n\n"
                "Rank by R:R ratio descending. Be ruthless - skip any with R:R < 1.0 or Kronos conflict. "
                "If fewer than 3 qualify, say so. Be concise but show all the math."
            )

            async with message.channel.typing():
                answer = call_grok(question, context=f"$1M+ FLOW CANDIDATES (last {minutes}min):\n\n{context}")

            for chunk in [answer[i:i+1900] for i in range(0, len(answer), 1900)]:
                await message.channel.send(chunk)
            audit("flowpicks", f"window={minutes}min candidates={len(top)}")
        except Exception as e:
            await message.channel.send(f"❌ Error: {e}")
            audit("flowpicks_failed", str(e))
        return

    # !digest — full synthesis: whale flow + Firebase signals + Kronos + Boba's last call + Grok macro
    if content.startswith("!digest"):
        await message.channel.send("🧠 Loading all sources for full digest...")
        try:
            sys.path.insert(0, "/home/ubuntu/scripts")
            sys.path.insert(0, "/home/ubuntu/scripts/lib")
            import json as _json
            from datetime import datetime as _dt, timezone as _tz, timedelta as _td

            ctx_blocks = []

            # 1. Whale flow — top 5 from last 4h
            try:
                sigs = _json.loads(Path("/home/ubuntu/mission-control/signal-receiver/data/scored_signals_recent.json").read_text())
                cutoff = _dt.now(_tz.utc) - _td(hours=4)
                fresh = []
                for s in sigs:
                    ts_str = s.get("timestamp", "")
                    try:
                        ts = _dt.fromisoformat(ts_str.replace("Z", "+00:00"))
                    except Exception:
                        continue
                    if ts >= cutoff and float(s.get("flow_value", 0)) >= 1_000_000:
                        fresh.append(s)
                fresh.sort(key=lambda x: -x.get("score", 0))
                top5 = fresh[:5]
                if top5:
                    lines = [f"  - {s.get('ticker')} ${s.get('strike')} {s.get('option_type')} exp {s.get('expiry')} ({s.get('dte')}DTE) | {s.get('flow_value_raw')} | score {s.get('score')}/100 ({s.get('grade')})" for s in top5]
                    ctx_blocks.append("WHALE FLOW (last 4h, $1M+):\n" + "\n".join(lines))
                else:
                    ctx_blocks.append("WHALE FLOW: none in last 4h")
            except Exception as e:
                ctx_blocks.append(f"WHALE FLOW: error ({e})")

            # 2. Firebase trade signals — Name/Name2/Vivid
            try:
                fb = Path("/home/ubuntu/.openclaw/workspace/directives/firebase_trade_signals.json")
                if fb.exists():
                    fbs = _json.loads(fb.read_text())
                    last10 = sorted(fbs, key=lambda x: x.get("captured_at", ""), reverse=True)[:10]
                    lines = [f"  - [{s.get('source')}] {s.get('category')}: {s.get('ticker')} ${s.get('strike')} {'PUT' if s.get('is_put') else 'CALL'} exp {s.get('expiry')} | entry ${s.get('buy_target')} target ${s.get('sell_target')} SL ${s.get('stop_loss')} risk={s.get('risk')}" for s in last10]
                    ctx_blocks.append("FIREBASE PROVIDER SIGNALS (Name/Name2/Vivid, last 10):\n" + "\n".join(lines))
                else:
                    ctx_blocks.append("FIREBASE: feed empty")
            except Exception as e:
                ctx_blocks.append(f"FIREBASE: error ({e})")

            # 3. Kronos forecasts — cached for major tickers
            try:
                kdir = Path("/home/ubuntu/.openclaw/workspace/directives/kronos_forecasts")
                if kdir.exists():
                    klines = []
                    for f in sorted(kdir.glob("latest_*.json"))[:8]:
                        try:
                            k = _json.loads(f.read_text())
                            tkr = f.stem.replace("latest_", "")
                            d = k.get("forecast_24h_direction", "?")
                            tgt = k.get("forecast_24h_target", "?")
                            cur = k.get("current_price", "?")
                            conf = k.get("forecast_24h_confidence", "?")
                            klines.append(f"  - {tkr}: {d} (target ${tgt}, current ${cur}, conf {conf})")
                        except Exception:
                            continue
                    if klines:
                        ctx_blocks.append("KRONOS FORECASTS (cached):\n" + "\n".join(klines))
            except Exception:
                pass

            # 4. Boba's most recent decision
            try:
                bd = Path("/home/ubuntu/.openclaw/workspace/skill_outputs/boba_decisions_validated.json")
                if bd.exists():
                    decisions = _json.loads(bd.read_text())
                    if decisions:
                        last = decisions[-1]
                        summary = last.get("cycle_summary", "")[:300]
                        picks = last.get("picks_executed", [])
                        plines = []
                        for p in picks[:3]:
                            ex = p.get("execution", {}) or {}
                            plines.append(f"  - {ex.get('symbol','?')}: {p.get('contracts','?')}x at TP+{p.get('profit_target_pct',0)}% / SL-{p.get('stop_loss_pct',0)}%")
                        ctx_blocks.append(f"BOBA'S LAST DECISION ({last.get('timestamp','?')[:19]}):\nSummary: {summary}\nPicks executed:\n" + ("\n".join(plines) if plines else "  (no picks)"))
            except Exception as e:
                ctx_blocks.append(f"BOBA: error ({e})")

            # 5. Grok latest CT digest
            try:
                gd = Path("/home/ubuntu/.openclaw/workspace/skill_outputs/grok_ct_alpha.json")
                if gd.exists():
                    g = _json.loads(gd.read_text())
                    age_min = (_dt.now(_tz.utc) - _dt.fromisoformat(g.get("generated_at","").replace("Z","+00:00"))).total_seconds() / 60
                    s = g.get("summary", "")[:400]
                    ihigh = [i for i in g.get("items", []) if i.get("urgency") == "high"][:3]
                    ihlines = [f"  - {i.get('topic','')}: {i.get('summary','')[:150]}" for i in ihigh]
                    ctx_blocks.append(f"GROK CT DIGEST ({int(age_min)}min ago):\n{s}\nHigh-urgency items:\n" + ("\n".join(ihlines) if ihlines else "  (none)"))
            except Exception:
                pass

            full_ctx = "\n\n".join(ctx_blocks)

            question = (
                "You have all of Mike's intel sources above. Synthesize them into a single SHORT trade desk briefing:\n"
                "1. ONE-LINE MARKET TAKE — overall vibe right now (2-3 sentences max)\n"
                "2. TOP 3 OPPORTUNITIES — ranked across whale flow + Firebase signals + Boba's view, with which side (long/short) and why each is best risk-adjusted. Cite the source.\n"
                "3. RISKS / CONFLICTS — where do sources disagree? Where is Kronos saying opposite of whale flow? Anything to AVOID?\n"
                "4. ACTION ITEMS — 1-3 specific things Mike should do/watch in next session.\n\n"
                "Be ruthless and specific. Don't pad with disclaimers. If there's nothing to do, say 'sit on hands'."
            )

            async with message.channel.typing():
                answer = call_grok(question, context=full_ctx)

            for chunk in [answer[i:i+1900] for i in range(0, len(answer), 1900)]:
                await message.channel.send(chunk)
            audit("digest", f"sources={len(ctx_blocks)} answer_chars={len(answer)}")
        except Exception as e:
            await message.channel.send(f"❌ Digest error: {e}")
            audit("digest_failed", str(e))
        return

    if content.startswith("!help"):
        await message.channel.send(
            "**AskGrok commands:**\n"
            "Type any question → Grok + x_search answer\n"
            "`!read #channel 50` — summarize messages\n"
            "`!pin <id>` — pin message\n"
            "`!delete-msg <id>` — delete (CONFIRM)\n"
            "`!rename-channel #old new` — rename (CONFIRM)\n"
            "`!flowpicks 60` — rank $1M+ flow by risk-adjusted % return\n`!audit` — last 15 actions\n"
            "Reply `CONFIRM` or `CANCEL` for pending actions."
        )
        return

    async with message.channel.typing():
        answer = call_grok(content)
    for chunk in [answer[i:i+1900] for i in range(0, len(answer), 1900)]:
        await message.channel.send(chunk)
    audit("question", f"channel={message.channel.name} q={content[:100]}")


if __name__ == "__main__":
    print("[askgrok] Starting...", flush=True)
    client.run(TOKEN, log_handler=None)
