#!/home/itsju/.venv/bin/python
"""Generic Telegram → claude-CLI responder — kills "dead-end" bots.

Many of Mike's bots only SEND (alerts/digests) and go silent if he texts them.
This one daemon makes any such bot conversational: long-poll getUpdates, owner-gate
to Mike, pipe each message into the local `claude` CLI on the subscription wallet
(ANTHROPIC_API_KEY stripped), text the reply back. Same proven pattern as
antigravity_aime_bot.py / lifeclaw_bot.py.

Usage:  tg_responder.py <botkey>      (botkey from BOTS registry below)
Run one PM2 process per bot:  pm2 start tg_responder.py --name tg-<botkey> -- <botkey>

IMPORTANT: only ONE getUpdates consumer may poll a given bot token. Do not point
this at a token another poller already owns (e.g. PipelineSignals/telegram-bot-token.txt
is owned by telegram_dm_responder.py).
"""
import json, os, subprocess, time, sys
from pathlib import Path
import requests

SECRETS    = Path.home() / ".openclaw/secrets"
CLAUDE_BIN = str(Path.home() / ".local/bin/claude")
CLAUDE_CWD = str(Path.home())
TG_MAX     = 4096

# ── Bot registry — each entry = one personal bot we make conversational ───────
BOTS = {
    "laptopclaude": {
        "token": "telegram_laptopclaude_bot_token",       # @oOLaptopClaude_Bot
        "owner": "telegram-chat-id.txt",
        "name":  "LaptopClaude",
        "tools": "Bash,Read,Grep,Glob,WebFetch,WebSearch,Skill,TodoWrite",
        "persona": (
            "You are LaptopClaude — the same Claude that runs Mike's Claude Code, "
            "reachable from his phone. General dev/ops/life copilot on the laptop hub. "
            "Help with code, the system, files, research, quick questions. Read-only "
            "tools only (never edit/deploy/trade). Eastern Time. Keep replies short, "
            "plain-text, skimmable for Telegram (no markdown headers/tables)."
        ),
    },
    "pingpong": {
        "token": "telegram-ping-bot-token",               # @Pingpong727_Bot
        "owner": "telegram-ping-chat-id",
        "name":  "PingPong",
        "tools": "Bash,Read,Grep,Glob,WebFetch,WebSearch,Skill,TodoWrite",
        "persona": (
            "You are PingPong — Mike's ops/health copilot on the laptop hub. Answer "
            "questions about system health, PM2 services, cron, logs, disk/RAM. You may "
            "run READ-ONLY diagnostics via Bash (pm2 status/jlist, free -m, df -h, tail "
            "logs). NEVER restart/kill/deploy/edit anything. Eastern Time. Short, "
            "plain-text answers for Telegram."
        ),
    },
}


def _secret(name):
    return (SECRETS / name).read_text().strip()


def main():
    if len(sys.argv) < 2 or sys.argv[1] not in BOTS:
        print(f"usage: tg_responder.py <{'|'.join(BOTS)}>", flush=True)
        sys.exit(1)
    cfg   = BOTS[sys.argv[1]]
    token = _secret(cfg["token"])
    base  = f"https://api.telegram.org/bot{token}"
    # Owner set: the bot's own chat-id file + the universal one (private chat.id ==
    # Mike's Telegram user id, same across all his bots) — robust to file mismatch.
    owners = set()
    for f in (cfg["owner"], "telegram-chat-id.txt", "lifeclaw_telegram_chat_id"):
        try:
            owners.add(_secret(f))
        except Exception:
            pass
    sys_prompt = (cfg["persona"] +
                  " If you can't find or do something, say so briefly.")
    tools = cfg["tools"]
    name  = cfg["name"]

    def tg(method, req_timeout=10, **kw):
        try:
            return requests.post(f"{base}/{method}", json=kw, timeout=req_timeout).json()
        except Exception as e:
            print(f"tg {method} error: {e}", flush=True)
            return {"ok": False}

    def send_reply(chat_id, text):
        text = text or "[empty]"
        for i in range(0, len(text), TG_MAX):
            tg("sendMessage", chat_id=chat_id, text=text[i:i + TG_MAX])

    def ask_local(question):
        env = {k: v for k, v in os.environ.items() if k != "ANTHROPIC_API_KEY"}
        try:
            r = subprocess.run(
                [CLAUDE_BIN, "-p", question, "--append-system-prompt", sys_prompt,
                 "--model", "sonnet", "--output-format", "json", "--allowedTools", tools],
                capture_output=True, text=True, timeout=300, env=env, cwd=CLAUDE_CWD)
            if r.returncode != 0:
                return f"[{name} error rc={r.returncode}] {r.stderr.strip()[:300]}"
            return (json.loads(r.stdout).get("result") or "").strip() or f"[{name} empty]"
        except subprocess.TimeoutExpired:
            return f"[{name} timed out after 300s]"
        except Exception as e:
            return f"[{name} error] {e}"

    help_txt = (f"🤖 {name} — text me like you text Claude Code.\n"
                f"📈 /pick — the #1 contract to buy now (verified + sized)\n"
                f"📈 /picks · /flow · 🔪 /sweeps — live whale flow · ⚡ /odte\n"
                f"🔔 /winners — app-pushed flow + chase/skip verdict · /chase [TKR]\n"
                f"₿ /crypto — BTC desk (24/7)\n"
                f"📐 /greeks [TKR] · /book · /eod · 🎓 /grade · 📰 /news\n"
                f"📖 /explain — what Greeks/IV/volume mean (plain English)\n"
                f"Or ask anything / run any /skill. /help = this.")

    print(f"{name} responder started ({cfg['token']})", flush=True)
    tg("deleteWebhook")
    offset = 0
    boot = tg("getUpdates", req_timeout=15, timeout=0)
    if boot.get("ok") and boot.get("result"):
        offset = boot["result"][-1]["update_id"]
    while True:
        try:
            data = tg("getUpdates", req_timeout=35, offset=offset, timeout=25,
                      allowed_updates=["message"])
            if not data.get("ok"):
                time.sleep(5); continue
            for upd in data.get("result", []):
                offset = upd["update_id"] + 1
                msg     = upd.get("message", {})
                chat_id = msg.get("chat", {}).get("id")
                text    = (msg.get("text") or "").strip()
                if not chat_id or not text:
                    continue
                if str(chat_id) not in owners:
                    print(f"ignored non-owner {chat_id}", flush=True); continue
                if text.startswith(("/help", "/start")):
                    tg("sendMessage", chat_id=chat_id, text=help_txt); continue
                # Quantum pipeline picks — instant, deterministic, zero-bloat (no LLM).
                cmd0 = text.split()[0].lower()
                # /greeks <TKR> → live lookup (LLM, any contract incl. flow); bare → quantum picks
                if cmd0 == "/greeks":
                    import quantum_tg
                    arg = text.split(maxsplit=1)[1].strip() if " " in text else ""
                    if arg:
                        tg("sendChatAction", chat_id=chat_id, action="typing")
                        send_reply(chat_id, quantum_tg.tidy(
                            ask_local(quantum_tg.greeks_prompt(arg)), 9))
                    else:
                        if not tg("sendMessage", chat_id=chat_id, text=quantum_tg.greeks(),
                                  parse_mode="Markdown").get("ok"):
                            tg("sendMessage", chat_id=chat_id, text=quantum_tg.greeks())
                    print(f"[{name}] /greeks {arg}", flush=True)
                    continue
                # /winners (app-pushed flow + chase verdict) · /chase <TKR> (full read)
                if cmd0 in ("/winners", "/chase", "/flowwin"):
                    import flow_chase
                    tg("sendChatAction", chat_id=chat_id, action="typing")
                    arg = text.split(maxsplit=1)[1].strip() if " " in text else ""
                    try:
                        msg = flow_chase.chase(arg) if (cmd0 == "/chase" or arg) else flow_chase.winners()
                    except Exception as e:
                        msg = f"[flow-chase error] {e}"
                    if not tg("sendMessage", chat_id=chat_id, text=msg,
                              parse_mode="Markdown").get("ok"):
                        tg("sendMessage", chat_id=chat_id, text=msg)
                    print(f"[{name}] {cmd0} {arg}", flush=True)
                    continue
                if cmd0 in ("/pick", "/picks", "/book", "/grade", "/eod", "/flow",
                            "/crypto", "/explain", "/sweeps", "/odte"):
                    try:
                        import quantum_tg
                        msg = (quantum_tg.pick(1) if cmd0 == "/pick"
                               else quantum_tg.pick(3) if cmd0 == "/picks"
                               else quantum_tg.grade() if cmd0 == "/grade"
                               else quantum_tg.eod() if cmd0 == "/eod"
                               else quantum_tg.flow() if cmd0 == "/flow"
                               else quantum_tg.crypto() if cmd0 == "/crypto"
                               else quantum_tg.explain() if cmd0 == "/explain"
                               else quantum_tg.sweeps() if cmd0 == "/sweeps"
                               else quantum_tg.odte() if cmd0 == "/odte"
                               else quantum_tg.book())
                    except Exception as e:
                        msg = f"[pick error] {e}"
                    if not tg("sendMessage", chat_id=chat_id, text=msg,
                              parse_mode="Markdown").get("ok"):
                        tg("sendMessage", chat_id=chat_id, text=msg)  # plain fallback
                    print(f"[{name}] {cmd0}", flush=True)
                    continue
                # /news — portfolio-aware politics/macro read (LLM, uses news-search + web).
                if cmd0 == "/news":
                    import quantum_tg
                    tg("sendChatAction", chat_id=chat_id, action="typing")
                    send_reply(chat_id, quantum_tg.tidy(ask_local(quantum_tg.news_prompt()), 11))
                    print(f"[{name}] /news", flush=True)
                    continue
                # Any other /command is passed VERBATIM to `claude -p`, so every Claude
                # slash-skill (e.g. /flow-desk SPY, /options-desk, /ticker-research NVDA)
                # is a Telegram command automatically — whatever skills get added.
                print(f"[{name}] Q: {text[:120]}", flush=True)
                tg("sendChatAction", chat_id=chat_id, action="typing")
                try:
                    a = ask_local(text); send_reply(chat_id, a)
                    print(f"[{name}] A: {len(a)} chars", flush=True)
                except Exception as e:
                    tg("sendMessage", chat_id=chat_id, text=f"⚠️ {name} error: {e}")
        except Exception as e:
            print(f"poll loop error: {e}", flush=True); time.sleep(5)


if __name__ == "__main__":
    main()
