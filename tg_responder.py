#!/home/itsju/.venv/bin/python
"""Generic Telegram → claude-CLI responder — kills "dead-end" bots.

Many of Mike's bots only SEND (alerts/digests) and go silent if he texts them.
This one daemon makes any such bot conversational: long-poll getUpdates, owner-gate
to Mike, pipe each message into the local `claude` CLI on the subscription wallet
(ANTHROPIC_API_KEY stripped), text the reply back. Same proven pattern as
antigravity_aime_bot.py / lifeclaw_bot.py.

Usage:  tg_responder.py <botkey>                  one lane (botkey from BOTS registry)
        tg_responder.py --gateway [l1,l2|active]  ALL live lanes in ONE process (thread per
                                                  lane; LLM_SEM caps concurrent CLI calls)

Since 2026-07-19 the fleet runs as ONE PM2 process (the pm2-tg-bot-gateway collapse):
  pm2 start tg_responder.py --name tg-gateway --interpreter ~/.venv/bin/python \
      --max-memory-restart 300M -- --gateway active
The old per-lane procs (tg-laptopclaude, tg-pingpong, tg-grokscout, tg-trendscanner,
tg-jazzycodexgpt, tg-orionrelay) are STOPPED in PM2 as instant rollback — never run one
of them while tg-gateway is up (getUpdates 409).

IMPORTANT: only ONE getUpdates consumer may poll a given bot token. Do not point
this at a token another poller already owns (e.g. PipelineSignals/telegram-bot-token.txt
is owned by telegram_dm_responder.py).
"""
import json, os, subprocess, threading, time, sys
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
        "help": (
            "🩺 System Health — your laptop ops/health copilot.\n"
            "Ask me in plain English:\n"
            "• is everything healthy?   • pm2 status\n"
            "• why is X down?           • disk / RAM / swap?\n"
            "• tail the X log           • any cron stale?\n"
            "Read-only diagnostics — I never restart/kill/deploy.\n"
            "/help = this."
        ),
    },
    # ── repurposed specialist bots (each a distinct trading front-door) ───────
    "xsentiment": {
        "token": "telegram_grok_bot_token",               # @MoneyFlowz_Bot → X-Sentiment
        "owner": "telegram-chat-id.txt",
        "name":  "X-Sentiment",
        "tools": "Bash,Read,Grep,Glob,WebFetch,WebSearch",
        "default_x": True,   # bare (non-slash) input → native Grok x_search
        "persona": (
            "You are X-Sentiment — Mike's live X/Twitter trader-sentiment scout. For any "
            "ticker/topic, summarize the last 24h of trader-relevant X chatter: bullish vs "
            "bearish lean + any catalyst. 4 lines max, plain text, Eastern Time. Mike has ADD "
            "— be tight."
        ),
        "help": (
            "𝕏 X-Sentiment — live X/Twitter trader mood (Grok).\n"
            "Just type a ticker or topic → I scan the last 24h:\n"
            "• NVDA          • spy 0dte today\n"
            "→ bull vs bear lean + any catalyst, 4 lines.\n"
            "Or /x [TKR] explicitly · ask anything / run any /skill.\n"
            "/help = this."
        ),
    },
    # PARKED 2026-07-19: responder stopped, bot renamed "PARKED (free)". Token free to repurpose.
    "jazzy_PARKED": {
        "token": "telegram_jazzyhazzy_bot_token",         # @JazzyHazzyClaw_Bot → Jazzy Desk
        "owner": "telegram-chat-id.txt",
        "name":  "Jazzy Desk",
        "tools": "Bash,Read,Grep,Glob,WebFetch",
        "persona": (
            "You are Jazzy Desk — Mike's Jazzy paper-account command (Alpaca PAPER account "
            "'jazzy', keys in ~/.openclaw/secrets/alpaca-jazzy-*). Report positions, P&L, and "
            "size trades as a fraction of CURRENT jazzy equity ($800 risk cap). READ-ONLY — "
            "never place trades. Eastern Time, short plain-text."
        ),
        "help": (
            "🎷 Jazzy Desk — your Alpaca PAPER 'jazzy' account (read-only).\n"
            "• positions / P&L      • /book — open positions\n"
            "• size a trade vs CURRENT jazzy equity ($800 cap)\n"
            "Never places trades. Ask anything / run any /skill.\n"
            "/help = this."
        ),
    },
    # PARKED 2026-07-19: responder stopped, bot renamed "PARKED (free)". Token free to repurpose.
    "risk_PARKED": {
        "token": "antidote_telegram_bot_token",           # @AntiDoht_Bot → Risk & Hedge
        "owner": "telegram-chat-id.txt",
        "name":  "Risk & Hedge",
        "tools": "Bash,Read,Grep,Glob,WebFetch",
        "persona": (
            "You are Risk & Hedge — Mike's risk manager (Bridgewater DNA). For any trade or "
            "position, assess: max loss, size vs CURRENT live equity (cap risk $800 per "
            "trade), correlation/concentration, drawdown, and hedges. Be the voice that protects "
            "capital. Never place trades. Eastern Time, short plain-text."
        ),
        "help": (
            "🛡️ Risk & Hedge — capital-protection desk (Bridgewater DNA).\n"
            "For any trade or position I size up:\n"
            "• max loss · size vs CURRENT equity ($800 cap)\n"
            "• correlation / concentration · drawdown · hedges\n"
            "Never places trades. Ask anything / run any /skill.\n"
            "/help = this."
        ),
    },
    # PARKED 2026-07-19: responder stopped, bot renamed "PARKED (free)". Token free to repurpose.
    "research_PARKED": {
        "token": "telegram_orion_bot_token",              # @ResearchDaMoney_Bot → Research Desk
        "owner": "telegram-chat-id.txt",
        "name":  "Research Desk",
        "tools": "Bash,Read,Grep,Glob,WebFetch,WebSearch",
        "persona": (
            "You are Research Desk — deep fundamental research on any ticker: business model, "
            "financials, catalysts, valuation, the bull vs bear case, key risks. Thorough but "
            "skimmable; end with a one-line take. Eastern Time, plain-text."
        ),
        "help": (
            "🔬 Research Desk — fundamentals + IV & structure.\n"
            "• deep ticker research (bull/bear · catalysts · valuation)\n"
            "• IV rich/cheap · straddle & structure reads\n"
            "• /greeks [TKR] · /explain\n"
            "📲 Auto-push: SPY Straddle Lab lands here each morning.\n"
            "Ask anything / run any /skill. /help = this."
        ),
    },
    # RETIRED 2026-07-19: @TrndRsrch_Bot token repurposed as ClaudeClaw OS's own bot
    # (grammy poller in /AIWorkWSL/agents/claudeclaw). Re-enabling this entry would 409 it.
    "screener_RETIRED": {
        "token": "telegram_deepseek_bot_token",           # @TrndRsrch_Bot → now ClaudeClaw OS
        "owner": "telegram-chat-id.txt",
        "name":  "Screener",
        "tools": "Bash,Read,Grep,Glob,WebFetch,WebSearch",
        "persona": (
            "You are Screener — find and rank tickers on demand: top movers, oversold "
            "large-caps, unusual options volume, momentum, insider buying. Return a tight ranked "
            "list (ticker — one-line why), 5-8 names. Eastern Time, plain-text."
        ),
        "help": (
            "📡 Screener — find & rank names on demand.\n"
            "• top movers · oversold large-caps\n"
            "• unusual options volume · momentum · insider buys\n"
            "→ tight ranked list (ticker — why).\n"
            "Ask anything / run any /skill. /help = this."
        ),
    },
    # RETIRED 2026-07-19: @MMCTRL727_Bot token is now the MasterMC agent's own bot
    # (claudeclaw --agent mastermc). Re-enabling this entry would 409 it.
    "macro_RETIRED": {
        "token": "telegram_mc_skill_bot_token",           # @MMCTRL727_Bot → now MasterMC agent
        "owner": "telegram-chat-id.txt",
        "name":  "Macro & Regime",
        "tools": "Bash,Read,Grep,Glob,WebFetch,WebSearch",
        "persona": (
            "You are Macro & Regime — top-down market read: risk-on/off regime, Fed/rates, key "
            "SPY/QQQ levels, sector rotation, and how today's politics/news hits Mike's book. "
            "Lead with the regime verdict. Eastern Time, short plain-text."
        ),
        "help": (
            "🌐 Macro & Regime — top-down market read.\n"
            "• risk-on/off regime verdict · VIX\n"
            "• Fed / rates · key SPY/QQQ levels · sector rotation\n"
            "📲 Auto-push: the daily Morning Brief lands here (~9am ET).\n"
            "Ask anything / run any /skill. /help = this."
        ),
    },
    # ── reserve pool → distinct-LLM personas (provider diversity across the fleet) ─
    # token lives in the vault (tg_fleet `telegram.<fleet_fn>`); `providers` routes the
    # free-text brain via lib.llm.call_llm_text. No `tools` key → claude-tool commands
    # (/news, /greeks TKR) fall back to the default toolset on the claude CLI.
    "jazzycodexgpt": {
        "fleet_fn": "jazzy_relay",                         # vault → @JazzyHazzy_Bot
        "owner": "telegram-chat-id.txt",
        "name":  "JazzyCodexGPT",
        "providers": ["codex_cli", "grok_oauth"],          # OpenAI/ChatGPT sub (Codex) → Grok sub fallback (deepseek API unregistered 06-17)
        "persona": (
            "You are JazzyCodexGPT — a GPT-powered second-opinion trading analyst (OpenAI brain), "
            "an independent cross-check to the Claude desks. For any ticker or trade give your own "
            "read: thesis, the key risk, and a clear lean. Size ideas as a fraction of CURRENT "
            "equity, $800 risk cap. Never place trades. Eastern Time, short plain-text for Telegram."
        ),
        "help": (
            "🤝 JazzyCodexGPT — GPT 2nd-opinion analyst (OpenAI brain).\n"
            "An independent cross-check to the Claude desks:\n"
            "• my own read on any ticker/trade: thesis · key risk · lean\n"
            "Provider diversity. Never places trades.\n"
            "Ask anything. /help = this."
        ),
    },
    "orionrelay": {
        "fleet_fn": "orion_relay",                         # vault → @oOrionz_Bot
        "owner": "telegram-chat-id.txt",
        "name":  "Orion Relay",
        "providers": ["claude_oauth", "codex_cli"],        # Claude sub → Codex sub (gemini/deepseek API unregistered 06-17)
        "persona": (
            "You are Orion Relay — a deep research/decision desk (Claude brain) running structured "
            "reads alongside the GPT (JazzyCodexGPT) and Grok (Grok Scout) desks. For any ticker or "
            "question give a structured read: the setup, catalysts, bull vs bear, and a decisive take. "
            "Never place trades. Eastern Time, short plain-text for Telegram."
        ),
        "help": (
            "🛰️ Orion Relay — structured research/decision desk (Claude brain).\n"
            "For any ticker or question:\n"
            "• the setup · catalysts · bull vs bear · decisive take\n"
            "Runs alongside the GPT + Grok desks. Never places trades.\n"
            "Ask anything. /help = this."
        ),
    },
    "grokscout": {
        "fleet_fn": "grok_scout",                          # vault → @Grootk_Bot
        "owner": "telegram-chat-id.txt",
        "name":  "Grok Scout",
        "providers": ["grok_oauth", "codex_cli"],          # SuperGrok sub → Codex sub fallback (deepseek API unregistered 06-17)
        "default_x": True,                                  # bare input → live native X search
        "persona": (
            "You are Grok Scout — a live X/Twitter scout on the SuperGrok subscription. For any "
            "ticker or topic surface what X is saying right now: notable posts, the bull/bear lean, "
            "and any fresh catalyst. 4-5 lines max, plain text, Eastern Time. Mike has ADD."
        ),
        "help": (
            "🛰️ Grok Scout — live X/Twitter scout (SuperGrok).\n"
            "Type a ticker or topic → what X is saying right now:\n"
            "• notable posts · bull/bear lean · fresh catalyst\n"
            "Or /x [TKR]. Ask anything. /help = this."
        ),
    },
    "trendscanner": {
        "fleet_fn": "trend_scanner",                       # vault → @Deepseeker_Bot
        "owner": "telegram-chat-id.txt",
        "name":  "Trend Scanner",
        "providers": ["codex_cli", "claude_oauth"],        # Codex sub → Claude sub (deepseek API unregistered 06-17)
        "persona": (
            "You are Trend Scanner — a GPT-powered momentum/trend scanner. Find and rank names "
            "by momentum, breakouts, relative strength, and unusual volume; return a tight ranked "
            "list (ticker — one-line why), 5-8 names. Eastern Time, plain-text."
        ),
        "help": (
            "📈 Trend Scanner — momentum/breakout scanner (GPT brain).\n"
            "• rank names by momentum · breakouts · rel-strength · unusual vol\n"
            "→ tight ranked list (ticker — why).\n"
            "Ask anything. /help = this."
        ),
    },
}

# Backward-compatible process arg for the old PM2 name.
BOTS["jazzyrelay"] = BOTS["jazzycodexgpt"]


def _secret(name):
    return (SECRETS / name).read_text().strip()


def _fleet_token(fn):
    """Resolve a bot token from the tg_fleet vault (telegram.<fn>) via its CLI."""
    r = subprocess.run([sys.executable, str(Path.home() / "scripts/tg_fleet.py"), "token", fn],
                       capture_output=True, text=True, timeout=15)
    tok = (r.stdout or "").strip()
    if not tok:
        raise RuntimeError(f"no vault token for fleet fn '{fn}': {r.stderr.strip()[:120]}")
    return tok


# Tokens owned by a DIFFERENT dedicated poller — refuse to start here, else two
# getUpdates consumers fight over one token (Telegram delivers each update once).
OWNED_ELSEWHERE = {"xsentiment": "grok_telegram.py owns telegram_grok_bot_token (x_sentiment)"}

# Gateway default lane set = every live conversational lane (2026-07-19 collapse: one
# process replaces the per-lane PM2 procs). Excludes *_PARKED/_RETIRED and OWNED_ELSEWHERE.
GATEWAY_LANES = ["laptopclaude", "pingpong", "grokscout", "trendscanner",
                 "jazzycodexgpt", "orionrelay"]

# One claude/codex CLI can pull ~0.5GB; with 6 lanes in one process, cap concurrent
# LLM subprocess calls so a burst of DMs can't stack six of them.
LLM_SEM = threading.BoundedSemaphore(2)


def run_bot(botkey):
    cfg   = BOTS[botkey]
    token = _fleet_token(cfg["fleet_fn"]) if cfg.get("fleet_fn") else _secret(cfg["token"])
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
    tools = cfg.get("tools", "Bash,Read,Grep,Glob,WebFetch,WebSearch")
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

    def handle_cb(cq):
        """Inline-button taps. Owner-gated. Extensible by callback_data prefix.
        `oq:<LETTER>:<qid>` = Options Academy rep → graded by options_quiz_grade."""
        cq_id = cq.get("id")
        frm = str((cq.get("from") or {}).get("id", ""))
        ccid = (cq.get("message") or {}).get("chat", {}).get("id")
        if frm not in owners and str(ccid) not in owners:
            tg("answerCallbackQuery", callback_query_id=cq_id); return
        parts = (cq.get("data") or "").split(":")
        if parts and parts[0] == "oq":
            try:
                sys.path.insert(0, "/home/itsju/05_AUTOMATION/scripts")
                import options_quiz_grade
                cmsg, right = options_quiz_grade.grade(parts[1] if len(parts) > 1 else "",
                                                       parts[2] if len(parts) > 2 else None)
            except Exception as e:
                cmsg, right = f"[grade error] {e}", None
            tg("answerCallbackQuery", callback_query_id=cq_id,
               text=("✅ Correct!" if right else ("❌ Not quite" if right is False else "closed")))
            if ccid:
                tg("sendMessage", chat_id=ccid, text=cmsg, parse_mode="HTML")
            print(f"[{name}] oq tap right={right}", flush=True)
        else:
            tg("answerCallbackQuery", callback_query_id=cq_id)

    def ask_local(question):
        env = {k: v for k, v in os.environ.items() if k != "ANTHROPIC_API_KEY"}
        # Ensure the Skill tool is available so /ainvest, /options-desk, /flow-desk, etc.
        # actually run as skills (not just chat) on every bot, incl. the reserve ones.
        tool_set = tools if "Skill" in tools else tools + ",Skill"
        try:
            with LLM_SEM:
                r = subprocess.run(
                    [CLAUDE_BIN, "-p", question, "--append-system-prompt", sys_prompt,
                     "--model", "sonnet", "--effort", "high", "--output-format", "json",
                     "--allowedTools", tool_set],
                    capture_output=True, text=True, timeout=300, env=env, cwd=CLAUDE_CWD)
            if r.returncode != 0:
                return f"[{name} error rc={r.returncode}] {r.stderr.strip()[:300]}"
            return (json.loads(r.stdout).get("result") or "").strip() or f"[{name} empty]"
        except subprocess.TimeoutExpired:
            return f"[{name} timed out after 300s]"
        except Exception as e:
            return f"[{name} error] {e}"

    def ask_persona(question):
        """Free-text brain. claude-CLI bots (providers=None) keep the claude path unchanged;
        reserve bots route through their own LLM (Codex/Gemini/Grok/DeepSeek) via call_llm_text."""
        providers = cfg.get("providers")
        if not providers:
            return ask_local(question)
        prompt = (sys_prompt + "\n\nUser message: " + question +
                  "\n\nReply now in plain text for Telegram (no markdown headers or tables), "
                  "under 8 lines, Eastern Time.")
        try:
            sys.path.insert(0, "/home/itsju/05_AUTOMATION/scripts")
            from lib import llm
            with LLM_SEM:
                out = llm.call_llm_text(prompt, providers)
            return out or f"[{name}: all backends busy — try again shortly]"
        except Exception as e:
            return f"[{name} backend error] {e}"

    help_txt = (f"🤖 {name} — text me like you text Claude Code.\n"
                f"📈 /pick — the #1 contract to buy now (verified + sized)\n"
                f"📈 /picks · /flow · 🔪 /sweeps — live whale flow · ⚡ /odte\n"
                f"🔔 /winners — app-pushed flow + chase/skip verdict · /chase [TKR]\n"
                f"₿ /crypto — BTC desk (24/7)\n"
                f"📐 /greeks [TKR] · /book · /eod · 🎓 /grade · 📰 /news\n"
                f"𝕏 /x [TKR] — live X/Twitter trader sentiment (Grok)\n"
                f"📖 /explain — what Greeks/IV/volume mean (plain English)\n"
                f"Or ask anything / run any /skill. /help = this.")
    help_txt += "\n🔑 /guest [24h] [name] — mint a temp link to give someone dashboard access"
    # Per-bot help override (keeps the /help text coherent with the bot's job — e.g. an
    # ops bot shouldn't advertise trading commands). Falls back to the cockpit help above.
    if cfg.get("help"):
        help_txt = cfg["help"]

    print(f"{name} responder started ({cfg.get('token') or cfg.get('fleet_fn')})", flush=True)
    tg("deleteWebhook")
    offset = 0
    boot = tg("getUpdates", req_timeout=15, timeout=0)
    if boot.get("ok") and boot.get("result"):
        offset = boot["result"][-1]["update_id"]
    while True:
        try:
            data = tg("getUpdates", req_timeout=35, offset=offset, timeout=25,
                      allowed_updates=["message", "callback_query"])
            if not data.get("ok"):
                time.sleep(5); continue
            for upd in data.get("result", []):
                offset = upd["update_id"] + 1
                if upd.get("callback_query"):           # tapped inline button (e.g. options rep)
                    try:
                        handle_cb(upd["callback_query"])
                    except Exception as e:
                        print(f"callback error: {e}", flush=True)
                    continue
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
                # /x <ticker/query> — live X/Twitter trader sentiment via Grok on your
                # SUBSCRIPTION (native x_search OAuth, web fallback). Pull-only, anti-bloat.
                if cmd0 == "/x":
                    arg = text.split(maxsplit=1)[1].strip() if " " in text else ""
                    if not arg:
                        tg("sendMessage", chat_id=chat_id,
                           text="usage: /x NVDA — live X/Twitter trader sentiment (Grok on your sub)")
                        continue
                    tg("sendChatAction", chat_id=chat_id, action="typing")
                    out = None
                    try:
                        sys.path.insert(0, "/home/itsju/05_AUTOMATION/scripts")
                        from lib import x_search
                        out = x_search.x_sentiment(arg)
                    except Exception as e:
                        print(f"[{name}] /x x_search err {e}", flush=True)
                    if not out:  # token missing/expired → web fallback via the CLI
                        out = ask_local(f"Summarize trader-relevant X/Twitter chatter on {arg} "
                                        f"in the last 24h: bullish/bearish lean + any catalyst. "
                                        f"4 lines max, I have ADD.")
                    send_reply(chat_id, f"𝕏 *{arg.upper()}*\n{out}")
                    print(f"[{name}] /x {arg}", flush=True)
                    continue
                # /news — portfolio-aware politics/macro read (LLM, uses news-search + web).
                if cmd0 == "/news":
                    import quantum_tg
                    tg("sendChatAction", chat_id=chat_id, action="typing")
                    send_reply(chat_id, quantum_tg.tidy(ask_local(quantum_tg.news_prompt()), 11))
                    print(f"[{name}] /news", flush=True)
                    continue
                # /guest [duration] [name] — give someone temp dashboard access. Works on
                # EVERY bot (owner-gated above); shared logic lives in mc_guest.py.
                if cmd0 == "/guest":
                    import mc_guest
                    send_reply(chat_id, mc_guest.mint(text))
                    print(f"[{name}] /guest", flush=True)
                    continue
                # X-Sentiment bot: a bare (non-slash) message → native Grok x_search first.
                if cfg.get("default_x") and not text.startswith("/"):
                    tg("sendChatAction", chat_id=chat_id, action="typing")
                    out = None
                    try:
                        sys.path.insert(0, "/home/itsju/05_AUTOMATION/scripts")
                        from lib import x_search
                        out = x_search.x_sentiment(text.strip())
                    except Exception as e:
                        print(f"[{name}] default_x err {e}", flush=True)
                    if not out:
                        out = ask_persona(text)
                    send_reply(chat_id, f"𝕏 *{text.strip().upper()}*\n{out}")
                    print(f"[{name}] x:{text[:40]}", flush=True)
                    continue
                # Routing for everything else:
                #  • a /slash command usually goes through Claude skills.
                #  • Codex-primary reserve bots keep slash skills in their own OpenAI lane.
                #    This lets JazzyCodexGPT use the Codex-installed AInvest/SkillHub skills
                #    instead of bouncing /ainvest back through Claude.
                #  • plain text → the persona's own brain (claude, or Codex/Grok/etc.
                #    for the reserve bots) — provider diversity preserved.
                # Each call is a FRESH `claude -p` (stateless): no context carries between
                # messages, so there's nothing to clear (no /newchat) and briefs are untouched.
                print(f"[{name}] Q: {text[:120]}", flush=True)
                tg("sendChatAction", chat_id=chat_id, action="typing")
                try:
                    codex_primary = (cfg.get("providers") or [None])[0] == "codex_cli"
                    a = ask_persona(text) if (codex_primary or not text.startswith("/")) else ask_local(text)
                    send_reply(chat_id, a)
                    print(f"[{name}] A: {len(a)} chars", flush=True)
                except Exception as e:
                    tg("sendMessage", chat_id=chat_id, text=f"⚠️ {name} error: {e}")
        except Exception as e:
            print(f"poll loop error: {e}", flush=True); time.sleep(5)


def _lane_thread(botkey):
    """Gateway wrapper: keep a lane alive forever; one bad lane never kills the process."""
    backoff = 10
    while True:
        try:
            run_bot(botkey)                      # only returns on crash
        except Exception as e:
            print(f"[gateway] lane '{botkey}' crashed: {e} — restart in {backoff}s", flush=True)
        time.sleep(backoff)
        backoff = min(backoff * 2, 300)


def main():
    args = sys.argv[1:]
    if args and args[0] == "--gateway":
        lanes = (args[1].split(",") if len(args) > 1 and args[1] != "active"
                 else GATEWAY_LANES)
        lanes = [ln for ln in lanes if ln in BOTS and ln not in OWNED_ELSEWHERE
                 and not ln.endswith(("_PARKED", "_RETIRED"))]
        if not lanes:
            print("gateway: no valid lanes", flush=True); sys.exit(1)
        print(f"tg-gateway starting {len(lanes)} lanes: {', '.join(lanes)}", flush=True)
        threads = [threading.Thread(target=_lane_thread, args=(ln,), daemon=True, name=ln)
                   for ln in lanes]
        for t in threads:
            t.start()
            time.sleep(1)                        # stagger boots (vault CLI + deleteWebhook)
        while True:                              # supervise: a dead lane thread should be
            time.sleep(60)                       # impossible (_lane_thread never returns) —
            dead = [t.name for t in threads if not t.is_alive()]
            if dead:                             # if it happens anyway, exit non-zero so PM2
                print(f"[gateway] DEAD lane threads: {dead} — exiting for PM2 restart", flush=True)
                sys.exit(1)                      # restarts the whole gateway (self-heal).
        return
    if len(args) < 1 or args[0] not in BOTS:
        print(f"usage: tg_responder.py <{'|'.join(BOTS)}> | --gateway [lane1,lane2|active]",
              flush=True)
        sys.exit(1)
    if args[0] in OWNED_ELSEWHERE:
        print(f"REFUSING '{args[0]}': {OWNED_ELSEWHERE[args[0]]} — "
              f"starting it would steal that poller's getUpdates.", flush=True)
        sys.exit(2)
    run_bot(args[0])


if __name__ == "__main__":
    main()
