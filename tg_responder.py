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
(the per-lane PM2 procs were deleted 2026-09-15 with the Orion/Boba/Jazzy retirement) — never run one
of them while tg-gateway is up (getUpdates 409).

Since 2026-09-01 every lane EXCEPT `astrology` is commands-only: a bare non-slash message
gets a one-line "commands-only" reply instead of an LLM call (see FREE_CHAT_LANES). Slash
commands still work everywhere. Astrology stays fully conversational.

IMPORTANT: only ONE getUpdates consumer may poll a given bot token. Do not point
this at a token another poller already owns (e.g. PipelineSignals/telegram-bot-token.txt
is owned by telegram_dm_responder.py).
"""
import collections, json, os, re, subprocess, threading, time, sys
from pathlib import Path
import requests

# 2026-09-27: every local date/time in this process (and its subprocesses) is Eastern Time,
# whatever PM2 injected (a corrupted TZ string made glibc fall back to UTC, so the astrology
# "today" rolled over at 8 PM ET).
os.environ["TZ"] = "America/New_York"
time.tzset()

SECRETS    = Path.home() / ".openclaw/secrets"
CLAUDE_BIN = str(Path.home() / "bin/llm-route")
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
    # 2026-08-10 — ex "Jazzy Desk" (PARKED 07-19) repurposed as the ASTROLOGY-ONLY lane.
    # `astro_only` strips every trading command from this bot: no /pick /flow /greeks etc.
    "astrology": {
        "token": "telegram_jazzyhazzy_bot_token",         # @JazzyHazzyClaw_Bot → Astrology
        "owner": "telegram-chat-id.txt",
        "name":  "Astrology",
        "tools": "Read,Grep,Glob",     # 2026-09-28 review: facts come from astro_bot, never from tools
        "astro_only": True,
        "persona": (
            "You are Astrology — Mike's personal astrologer, and ONLY that. You never give "
            "trading picks or market calls; if asked, say astrology only and point him "
            "to Trading Command.\n"
            "Mike's chart (Nov 3 1992, 10:46 PM EST, Dunedin FL) and every live position, aspect, "
            "exact time, pass and progression arrive in the COMPUTED FACTS block at the top of each "
            "message — that block is the only source of chart facts; anything not in it is UNAVAILABLE "
            "(say which /command computes it). PLACIDUS houses (Svehla's system). Every answer is "
            "fact-checked against the ephemeris afterwards — never invent a degree, house or aspect.\n"
            "Never run scripts or look anything up to get chart facts — the COMPUTED FACTS block is "
            "complete for this question. You may Read ~/portfolio/astrology/*.json* (his journal, "
            "scores, loose ends) and ~/scripts/real_coach/svehla_windows.json (Svehla's window "
            "why/do text) when he asks what he noted or what a window means.\n"
            "TROPICAL WESTERN ONLY: never use Vedic/sidereal/jyotish techniques (nakshatras, dashas, "
            "Rahu/Ketu). Interpretation wording follows astro_lexicon (practical + esoteric, Placidus "
            "houses) so answers match the daily send. Never mention trading, markets or money moves.\n"
            "Eastern Time. Short, warm, plain-text for Telegram — no markdown headers or tables. "
            "Mike has ADD: lead with the read, then at most 5 tight lines."
        ),
        # 2026-09-27 (Mike: trim the menu — 0 commands used since ≥09-20): short /help,
        # the full list lives behind /help all. Every command still works when typed.
        "help": (
            "🔮 Astrology — your chart, and only your chart. The 8:32 message comes to you daily.\n"
            "• /today — today's read · /full — every live transit + why it ranks\n"
            "• /week — themes + every exact of the next 7 days · /timeline — dated hits ahead\n"
            "• /progressions — your progressed Moon/Venus + next changes\n"
            "• /synastry <name> · /progsyn <name> — charts compared (needs /profile add first)\n"
            "• /moon — the Moon's sign + phase vs your placements · /moonguide — all 12 signs + 8 phases\n"
            "• /esoteric — the soul-level read of your transits (also its own post every morning)\n"
            "• /esonatal — your natal chart esoterically, planet by planet: sign · house · soul meaning\n"
            "Every reading ends with a 📖 key: plain + esoteric meaning of each sign, planet, house, phase.\n"
            "• /dates — your Aug 2026 reading · /chart — natal placements · /wheel — image\n"
            "• Live page: https://claudeclaw.serveftp.com/astrology/readings/mike-today-live.html\n"
            "Or just ask in plain words. /help all = every command (40+)."
        ),
        "help_all": (
            "🔮 Astrology — your chart, and only your chart.\n"
            "• /transits · /today — today's REAL transits vs your natal (Swiss Ephemeris)\n"
            "• /week — the weekly read · /lookahead — day-by-day transits for 7 days\n"
            "• /progressions — progressed Moon/Venus + next ingresses\n"
            "• /moon — Moon sign + phase against your placements (auto-posted at every change) · /moonguide\n"
            "• /esoteric — esoteric read of today's transits · every reply ends with a 📖 plain + esoteric key\n"
            "• /esonatal — natal chart esoterically: each planet → sign → house, with its soul meaning\n"
            "• /profile add <name> <YYYY-MM-DD> <HH:MM|unknown> <place> · /profile list\n"
            "• /synastry <name> [name2] — synastry (identity-labelled, unknown time → no angles)\n"
            "• /progsyn <name> [name2] — progressed synastry, all four frames\n"
            "• /chart — your natal placements at a glance\n"
            "• /readings — what's in your astrology suite\n"
            "• /dates — your Aug 2026 reading's timeline, what's active now + what's next\n"
            "• /progressed — progressed Moon/Venus/Sun/Juno positions today (/progressions adds the next ingresses)\n"
            "• /explain — today's transits, the full read: aspect geometry, which house it fires from\n"
            "   and lands in, both signs, esoteric meaning of each planet, how to work it\n"
            "• /planet <x> · /sign <x> · /house <1-12> · /aspect <x> — the lexicon, practical + esoteric\n"
            "• /lookahead · /month — the coming transits day by day, peak day marked · /quality — today 1-10\n"
            "• /tnp — the 8 transneptunian points (Hades, Apollon…) natal + 90° dial hits · /midpoints — planetary pictures now · /critical — anything on a critical/anaretic degree · /startransits — planets on fixed stars today\n"
            "• /profection — your time-lord year and month · /hours — today's planetary hours (Dunedin) · /firdaria — your Persian time-lord periods (tropical)\n"
            "• /full — today's complete read (the 8:32 send is a one-message digest) · /alerts — what goes exact in the next 24h (hourly pushes run 8am–10pm) · /evidence — your notes and scores vs the sky\n"
            "• Live page: https://claudeclaw.serveftp.com/astrology/readings/mike-today-live.html (log in once; regenerated 08:30 ET)\n"
            "• /timeline [days] [full] — every exact hit, house change, progression and eclipse ahead, dated from the real ephemeris · /year — 12 months in one screen\n"
            "• /sky — lunations, eclipses, stations, ingresses, Mercury rx + shadow, in your houses · /voc\n"
            "• /solarreturn · /lunarreturn · /phase (progressed lunation phase) · /solararc\n"
            "• /natal (patterns: t-square etc.) · /natalaspects · /activation · /stars (fixed stars)\n"
            "• /wheel — natal + today's transits as a chart image\n"
            "• /exact — next exact transit hits + progressed ingresses (pinged 3d before)\n"
            "• /note <text> — journal what happened (stamped with the active window)\n"
            "• /score <window> 1-5 · /scorecard — did Svehla's dates play out?\n"
            "• /ask <q> · /askdraft — queue questions for the next consult, draft the email\n"
            "• /contingency · /loose · /income · /juno — your action items, tracked\n"
            "Or just ask: 'what's Saturn doing to my 7th?', 'how's this week?',\n"
            "'is Mercury retrograde?', 'when does the Moon go void?', 'where is Sam's Venus?'\n"
            "No trading here — that's Trading Command. /help = this."
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
            "position, assess: cost, correlation/concentration, drawdown, and hedges (no stops, "
            "targets, sizing or price caps). Be the voice that protects capital. Never place trades. Eastern Time, short plain-text."
        ),
        "help": (
            "🛡️ Risk & Hedge — capital-protection desk (Bridgewater DNA).\n"
            "For any trade or position I look at:\n"
            "• cost per contract / share\n"
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
            "You are Macro & Regime — top-down market read: Fed/rates, key SPY/QQQ levels, sector "
            "rotation, and how today's politics/news hits Mike's journal names. Lead with the "
            "CANONICAL regime label exactly as MissionCtrl publishes it (macro.regime.composite from "
            "http://localhost:3000/api/intel/v1/macro); if that fact is missing say 'regime: "
            "unavailable' — never invent or re-derive a regime. Risk-on/off bias is evidence "
            "(cite the inputs), not a verdict or trade call. Eastern Time, short plain-text."
        ),
        "help": (
            "🌐 Macro & Regime — top-down market read.\n"
            "• canonical regime label · risk-bias evidence · VIX\n"
            "• Fed / rates · key SPY/QQQ levels · sector rotation\n"
            "📲 Auto-push: the daily Morning Brief lands here (~9am ET).\n"
            "Ask anything / run any /skill. /help = this."
        ),
    },
    # ── reserve pool → distinct-LLM personas (provider diversity across the fleet) ─
    # token lives in the vault (tg_fleet `telegram.<fleet_fn>`); `providers` routes the
    # free-text brain via lib.llm.call_llm_text. No `tools` key → claude-tool commands
    # (/news, /greeks TKR) fall back to the default toolset on the claude CLI.
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
        "fleet_fn": "trend_scanner",                       # → @SpaceCoast_Claude_Bot since 2026-10-22 (MC-AUD-084; was the WinMeals bot)
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

# (jazzyrelay / jazzycodexgpt / orionrelay personas removed 2026-09-15 — Mike: Orion/Boba/Jazzy retired.)



def _redact(e) -> str:
    """Exception text with any bot token masked — requests errors embed the full API URL,
    which put live tokens into PM2 logs (2026-09-28)."""
    return re.sub(r"bot\d+:[\w-]+", "bot<redacted>", str(e))

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
OWNED_ELSEWHERE = {"xsentiment": "quiz_bot.py owns telegram_grok_bot_token (quiz lane, 2026-09-28)",
                   "grokscout":  "lane_bots.py owns @Grootk_Bot (crypto_desk lane, 2026-09-28)"}

# Gateway default lane set = every live conversational lane (2026-07-19 collapse: one
# process replaces the per-lane PM2 procs). Excludes *_PARKED/_RETIRED and OWNED_ELSEWHERE.
GATEWAY_LANES = ["laptopclaude", "pingpong", "trendscanner", "astrology"]   # grokscout → lane_bots.py (Crypto Desk) 2026-09-28

# Free-form chatter (a bare non-slash message) fires an LLM call on Mike's subscription and
# eats his 5-hour window. Only the astrology lane keeps that fully-conversational mode
# (Mike, 2026-09-01); every other lane stays reachable by explicit /command only.
FREE_CHAT_LANES = {"astrology"}

# Every trading command the cockpit exposes — refused outright on an `astro_only` lane so
# the astrology bot stays astrology-ONLY (Mike, 2026-08-10).
TRADING_CMDS = {"/pick", "/picks", "/book", "/grade", "/eod", "/flow", "/crypto", "/explain",
                "/sweeps", "/odte", "/greeks", "/winners", "/chase", "/flowwin", "/x", "/news",
                "/levels", "/dossier", "/intel", "/gex", "/oi", "/iv"}

# Deterministic MissionCtrl intel CLI (pipeline/intel/query.py) — same reader as the aime Discord bot; no LLM.
# /levels is levels.v1 (R32: computed, never written by an LLM).
INTEL_CMDS = {"/levels": "levels", "/dossier": "dossier", "/intel": "intel", "/gex": "gex", "/oi": "oi", "/iv": "iv"}


def run_intel(args, timeout=120):
    try:
        r = subprocess.run(["/home/itsju/.venv/bin/python", "-m", "pipeline.intel.query", *args], capture_output=True,
                           text=True, timeout=timeout, cwd="/AIWorkWSL/web/missionctrl")
        out = (r.stdout or "").strip()
        if r.returncode != 0:
            return f"⚠️ intel error rc={r.returncode}: {(r.stderr or out).strip()[-400:]}"
        return out or "[intel returned nothing]"
    except subprocess.TimeoutExpired:
        return f"⚠️ intel timed out after {timeout}s"
    except Exception as e:  # noqa: BLE001
        return f"⚠️ intel error: {e}"

def astro_factcheck(answer):
    """Run the astrology lane's free-chat answer through astro_verify.py --check-text: every
    sign/degree/house/aspect/retrograde claim is re-derived from the Swiss Ephemeris (Placidus).
    Wrong claims get a ⚠️ correction footer; right ones a one-line ✔. Never blocks the reply."""
    try:
        r = subprocess.run([str(Path.home() / ".venv/bin/python"),
                            str(Path.home() / "scripts/real_coach/astro_verify.py"), "--check-text"],
                           input=answer, capture_output=True, text=True, timeout=90)
        note = (r.stdout or "").strip()
        return f"{answer}\n\n{note}" if note else answer
    except Exception as e:
        return f"{answer}\n\n(fact-check unavailable: {e})"


# 2026-09-14 r3: astrology-lane task commands → ~/scripts/real_coach/astro_tasks.py <cmd> <args>
ASTRO_TASK_CMDS = {"/exact", "/note", "/score", "/scorecard", "/ask", "/askdraft",
                   "/contingency", "/loose", "/income", "/juno"}
# 2026-09-15 r7: sky / returns / patterns / lookahead modules → command → [script, *args]
ASTRO_MODULE_CMDS = {
    "/sky":         ("astro_sky.py", []),            "/voc":       ("astro_sky.py", ["voc"]),
    "/solarreturn": ("astro_returns.py", ["solar"]), "/lunarreturn": ("astro_returns.py", ["lunar"]),
    "/phase":       ("astro_returns.py", ["phase"]), "/solararc":  ("astro_returns.py", ["arc"]),
    "/natal":       ("astro_patterns.py", ["patterns"]), "/natalaspects": ("astro_patterns.py", ["aspects"]),
    "/activation":  ("astro_patterns.py", ["activation"]), "/stars": ("astro_patterns.py", ["stars"]),
    "/week":        ("astro_weekly.py", []),      "/lookahead": ("astro_lookahead.py", ["week"]), "/month":    ("astro_lookahead.py", ["month"]),
    "/quality":     ("astro_lookahead.py", ["quality"]),
    "/moon":        ("astro_moon.py", ["now"]),       "/moonguide": ("astro_moon.py", ["guide"]),
    "/esoteric":    ("astro_esoteric.py", []),   "/esonatal": ("astro_esoteric.py", ["--natal"]),
    "/full":        ("daily_transits.py", ["--full"]),   "/evidence": ("astro_evidence.py", []),
    "/alerts":      ("astro_alerts.py", ["--dry", "--window", "1440"]),
    "/timeline":    ("astro_timeline.py", ["30"]),         "/year":      ("astro_timeline.py", ["year"]),
    "/profection":  ("astro_timing.py", ["profection"]), "/hours":   ("astro_timing.py", ["hours"]),
    "/firdaria":    ("astro_timing.py", ["firdaria"]),
    "/tnp":         ("astro_uranian.py", ["tnp"]),       "/midpoints": ("astro_uranian.py", ["midpoints"]),
    "/critical":    ("astro_uranian.py", ["critical"]),  "/startransits": ("astro_uranian.py", ["stars"]),
}

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
            print(f"tg {method} error: {_redact(e)}", flush=True)
            return {"ok": False}

    def send_reply(chat_id, text):
        """Plain text (always valid — no parse_mode), split on line boundaries under TG_MAX,
        one retry per chunk on a transient failure."""
        text = text or "[empty]"
        chunks, cur = [], ""
        for ln in text.split("\n"):
            while len(ln) > TG_MAX - 96:                     # a single monster line: hard wrap
                chunks.append(cur) if cur else None; cur = ""
                chunks.append(ln[:TG_MAX - 96]); ln = ln[TG_MAX - 96:]
            if len(cur) + len(ln) + 1 > TG_MAX - 96:
                chunks.append(cur); cur = ln
            else:
                cur = f"{cur}\n{ln}" if cur else ln
        if cur:
            chunks.append(cur)
        for i, c in enumerate(chunks):
            body = c if len(chunks) == 1 else f"{c}\n({i + 1}/{len(chunks)})"
            r = tg("sendMessage", chat_id=chat_id, text=body)
            if not r.get("ok"):
                time.sleep(2)
                r = tg("sendMessage", chat_id=chat_id, text=body)
            if not r.get("ok"):
                print(f"send_reply FAILED chat={chat_id}: {str(r)[:200]}", flush=True)

    def astro_key(chat_id, text):
        """Astrology lane (Mike 2026-09-28): after every reading, a 📖 key — the plain AND esoteric
        meaning of each sign/planet/house/Moon phase the reply mentions (astro_lexicon.esoteric_key)."""
        if not cfg.get("astro_only") or not text or text.startswith(("[", "⚠️", "UNAVAILABLE", "Usage")):
            return
        try:
            r = subprocess.run([str(Path.home() / ".venv/bin/python"),
                                str(Path.home() / "scripts/real_coach/astro_lexicon.py"), "key"],
                               input=text, capture_output=True, text=True, timeout=30)
            if (r.stdout or "").strip():
                send_reply(chat_id, r.stdout.strip())
        except Exception as e:
            print(f"[{name}] astro_key error: {e}", flush=True)

    def send_html(chat_id, text):
        """HTML reply for the quantum/flow commands. Over TG_MAX, or markup Telegram rejects
        → tag-stripped plain text, chunked by send_reply (a long reply used to fail twice and
        send nothing). (2026-09-28)"""
        text = text or "[empty]"
        if len(text) <= TG_MAX and tg("sendMessage", chat_id=chat_id, text=text,
                                       parse_mode="HTML").get("ok"):
            return
        import html as _html, re as _re
        send_reply(chat_id, _html.unescape(_re.sub(r"</?(b|i|u|s|code|pre|a)(\s[^>]*)?>", "", text)))

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
        tool_set = tools if ("Skill" in tools or cfg.get("astro_only")) else tools + ",Skill"
        try:
            with LLM_SEM:
                r = subprocess.run(
                    [CLAUDE_BIN, "-p", question, "--append-system-prompt", sys_prompt,
                     "--model", "sonnet", "--effort", "medium", "--output-format", "json",
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

    # ── conversation memory (2026-08-17, Mike): each claude -p call is stateless, so
    # follow-ups ("what does that mean then?") were answered with zero context. Keep the
    # last 8 exchanges per lane on disk and prepend them to the free-text brain's prompt.
    hist_path = Path.home() / ".openclaw/tg_history" / f"{botkey}.jsonl"
    hist_path.parent.mkdir(parents=True, exist_ok=True)
    history = collections.deque(maxlen=8)
    try:
        for ln in hist_path.read_text().splitlines()[-8:]:
            q_, a_ = json.loads(ln)
            history.append((q_, a_))
    except Exception:
        pass

    # 2026-09-14: astrology lane gets a live-sky preamble (active Svehla windows + progressed
    # Moon/Venus) so free-chat answers are grounded without a tool call. Cached per ET day.
    sky_cache = {}

    def sky_context():
        if not cfg.get("astro_only"):
            return ""
        day = time.strftime("%Y-%m-%d")         # ET: TZ pinned at import
        if day not in sky_cache:
            parts = []
            rc = Path.home() / "scripts/real_coach"
            py = str(Path.home() / ".venv/bin/python")
            # round 9: ground free chat in the same material as the morning send —
            # Svehla context, today's timeline, Uranian dial, timing layer, 14-day timeline
            # numbers (positions, exacts, passes) come from the COMPUTED FACTS block now; this
            # keeps only the interpretive reading context
            for label, argv in (("Svehla reading context", [py, str(rc / "svehla.py"), "context"]),
                                ("Timing layer", [py, str(rc / "astro_timing.py"), "today"])):
                try:
                    r = subprocess.run(argv, capture_output=True, text=True, timeout=90)
                    txt = (r.stdout or "").strip()
                    txt = re.sub(r",\s*hour \w+", "", txt)   # cached all day → drop the planetary hour
                    if txt:
                        parts.append(f"[{label}]\n{txt[:1800]}")
                except Exception as e:
                    parts.append(f"[{label} unavailable: {e}]")
            sky_cache.clear(); sky_cache[day] = "\n\n".join(parts)
        return sky_cache[day]

    def with_context(question, facts_ctx=None):
        sky = sky_context()
        pre = (f"{facts_ctx}\n\n" if facts_ctx else "") + \
              (f"Reading context (Svehla narrative + timing, computed today): {sky}\n\n" if sky else "")
        if not history:
            return pre + question
        ctx = "\n".join(f"Mike: {q_}\nYou: {a_}" for q_, a_ in history)
        return (pre + "Recent conversation (context only — answer the NEW message):\n" + ctx +
                "\n\nNEW message from Mike: " + question)

    def remember(q_, a_):
        if a_.startswith("["):          # backend error strings aren't conversation
            return
        history.append((q_, a_[:700]))
        try:
            with hist_path.open("a") as f:
                f.write(json.dumps([q_, a_[:700]]) + "\n")
            os.chmod(hist_path, 0o600)
        except Exception:
            pass

    help_txt = (f"🤖 {name} — text me like you text Claude Code.\n"
                f"📈 /pick — the #1 desk contract (verified, with cost)\n"
                f"📈 /picks · /flow · 🔪 /sweeps — live whale flow · ⚡ /odte\n"
                f"🔔 /winners — app-pushed flow + chase-timing evidence · /chase [TKR]\n"
                f"📏 /levels TKR [short] — computed levels + menu + hit rates · 🗂 /dossier TKR\n"
                f"🐳 /intel · /gex · /oi · /iv TKR — instant flow intel (no AI)\n"
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
    # Downtime catch-up (2026-08-17, Mike): do NOT skip messages queued while the bot
    # was down — leave offset at 0 so the main loop answers every pending update.
    # Telegram only keeps updates 24h, so worst case we answer a day-old question.
    boot = tg("getUpdates", req_timeout=15, timeout=0)
    if boot.get("ok") and boot.get("result"):
        print(f"[{name}] {len(boot['result'])} update(s) queued during downtime — answering all", flush=True)
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
                    if cfg.get("help_all") and text.split()[1:2] == ["all"]:
                        send_reply(chat_id, cfg["help_all"]); continue
                    tg("sendMessage", chat_id=chat_id, text=help_txt); continue
                # Quantum pipeline picks — instant, deterministic, zero-bloat (no LLM).
                cmd0 = text.split()[0].lower()
                facts_ctx = None                        # astrology: COMPUTED FACTS for the LLM path
                if not cmd0.startswith("/") and botkey not in FREE_CHAT_LANES:
                    tg("sendMessage", chat_id=chat_id,
                       text=f"💤 {name} is on commands-only mode — free chat is off to save "
                            f"the Claude window. Send a /command (/help for the list). "
                            f"Free chat lives on the Astrology bot.")
                    print(f"[{name}] free-chat suppressed: {text[:60]}", flush=True)
                    continue
                # ── astrology-only lane: no trading surface at all ────────────
                if cfg.get("astro_only"):
                    if cmd0 in TRADING_CMDS and cmd0 != "/explain":
                        tg("sendMessage", chat_id=chat_id,
                           text="🔮 Astrology lane only — trading lives on Trading Command "
                                "(@oOLaptopClaude_Bot). Try /transits, /chart or /readings.")
                        continue
                    # 2026-09-27 final round: astro_bot routes commands it owns + every plain
                    # message: a computed reply goes out as-is (no LLM); otherwise the COMPUTED
                    # FACTS block becomes the LLM's grounding. Router failure → old path.
                    try:
                        tg("sendChatAction", chat_id=chat_id, action="typing")
                        rr = subprocess.run([str(Path.home() / ".venv/bin/python"),
                                             str(Path.home() / "scripts/real_coach/astro_bot.py"), "route"],
                                            input=json.dumps({"text": text, "chat": chat_id}),
                                            capture_output=True, text=True, timeout=240)
                        routed = json.loads(rr.stdout or "{}")
                    except Exception as e:
                        routed = {}
                        print(f"[{name}] astro_bot route error: {e}", flush=True)
                    if routed.get("reply"):
                        send_reply(chat_id, routed["reply"])
                        astro_key(chat_id, routed["reply"])
                        if not text.startswith("/"):
                            remember(text, routed["reply"])
                        print(f"[{name}] routed {routed.get('intent')} rid={routed.get('request_id')}", flush=True)
                        continue
                    facts_ctx = routed.get("context")
                    if cmd0 in ("/transits", "/today", "/daily"):
                        tg("sendChatAction", chat_id=chat_id, action="typing")
                        try:
                            r = subprocess.run(
                                [str(Path.home() / ".venv/bin/python"),
                                 str(Path.home() / "scripts/real_coach/daily_transits.py")],
                                capture_output=True, text=True, timeout=120)
                            out = (r.stdout or "").strip()
                            if not out:
                                print(f"[{name}] /transits rc={r.returncode} {r.stderr.strip()[-300:]}", flush=True)
                                out = f"⚠️ /transits couldn't compute right now — nothing guessed. Try again in a minute."
                        except Exception as e:
                            out = f"[transits error] {e}"
                        send_reply(chat_id, out)
                        astro_key(chat_id, out)
                        print(f"[{name}] /transits", flush=True)
                        continue
                    # 2026-09-15 r7: /wheel → render natal+transit PNG and send as a photo
                    if cmd0 == "/wheel":
                        try:
                            tg("sendChatAction", chat_id=chat_id, action="upload_photo")
                            r = subprocess.run([str(Path.home() / ".venv/bin/python"),
                                                str(Path.home() / "scripts/real_coach/astro_wheel.py")],
                                               capture_output=True, text=True, timeout=120)
                            png = (r.stdout or "").strip().splitlines()[-1] if r.returncode == 0 else ""
                            if png and Path(png).exists():
                                subprocess.run([str(Path.home() / ".venv/bin/python"), str(Path.home() / "scripts/tg_fleet.py"),
                                                "sendmedia", "astrology", png, "Natal (gold) + today's transits (teal) · Placidus"],
                                               capture_output=True, timeout=60)
                            else:
                                send_reply(chat_id, f"[/wheel failed] {r.stderr.strip()[:200]}")
                        except Exception as e:
                            send_reply(chat_id, f"[/wheel error] {e}")
                        print(f"[{name}] /wheel", flush=True)
                        continue
                    if cmd0 in ASTRO_MODULE_CMDS:
                        script, margs = ASTRO_MODULE_CMDS[cmd0]
                        extra = text.split()[1:]
                        try:
                            r = subprocess.run([str(Path.home() / ".venv/bin/python"),
                                                str(Path.home() / "scripts/real_coach" / script), *margs, *extra],
                                               capture_output=True, text=True, timeout=180)
                            out = (r.stdout or "").strip()
                            if not out:
                                print(f"[{name}] {cmd0} rc={r.returncode} {r.stderr.strip()[-300:]}", flush=True)
                                out = f"⚠️ {cmd0} couldn't compute right now — nothing guessed. Try again in a minute."
                        except Exception as e:
                            out = f"[{cmd0} error] {e}"
                        send_reply(chat_id, out)
                        if cmd0 not in ("/alerts", "/moonguide", "/esonatal"):   # these carry every ✧ line inline
                            astro_key(chat_id, out)
                        print(f"[{name}] {cmd0}", flush=True)
                        continue
                    # 2026-09-14 r3: accountability + evidence layer (astro_tasks.py)
                    if cmd0 in ASTRO_TASK_CMDS:
                        parts = text.split()
                        try:
                            r = subprocess.run(
                                [str(Path.home() / ".venv/bin/python"),
                                 str(Path.home() / "scripts/real_coach/astro_tasks.py"), cmd0[1:], *parts[1:]],
                                capture_output=True, text=True, timeout=120)
                            out = (r.stdout or "").strip()
                            if not out:
                                print(f"[{name}] {cmd0} rc={r.returncode} {r.stderr.strip()[-300:]}", flush=True)
                                out = f"⚠️ {cmd0} couldn't compute right now — nothing guessed. Try again in a minute."
                        except Exception as e:
                            out = f"[{cmd0} error] {e}"
                        send_reply(chat_id, out)
                        print(f"[{name}] {cmd0} ({len(parts) - 1} args)", flush=True)
                        continue
                    # 2026-09-15: lexicon — /planet /sign /house /aspect <key> → daily_transits --lookup
                    if cmd0 in ("/planet", "/sign", "/house", "/aspect"):
                        key = text.split(maxsplit=1)[1].strip() if " " in text else ""
                        if not key:
                            send_reply(chat_id, f"Usage: {cmd0} <name>  e.g. /planet saturn · /sign scorpio · /house 10 · /aspect square")
                            continue
                        try:
                            r = subprocess.run(
                                [str(Path.home() / ".venv/bin/python"),
                                 str(Path.home() / "scripts/real_coach/daily_transits.py"), "--lookup", cmd0[1:], key],
                                capture_output=True, text=True, timeout=60)
                            out = (r.stdout or "").strip()
                            if not out:
                                print(f"[{name}] {cmd0} rc={r.returncode} {r.stderr.strip()[-300:]}", flush=True)
                                out = f"⚠️ {cmd0} couldn't compute right now — nothing guessed. Try again in a minute."
                        except Exception as e:
                            out = f"[{cmd0} error] {e}"
                        send_reply(chat_id, out)
                        print(f"[{name}] {cmd0} {key}", flush=True)
                        continue
                    # 2026-09-14: Svehla Aug-2026 reading layer — dated windows + real progressions
                    if cmd0 in ("/dates", "/progressed", "/explain"):
                        flag = {"/dates": "--dates", "/progressed": "--progressed", "/explain": "--explain"}[cmd0]
                        try:
                            r = subprocess.run(
                                [str(Path.home() / ".venv/bin/python"),
                                 str(Path.home() / "scripts/real_coach/daily_transits.py"), flag],
                                capture_output=True, text=True, timeout=120)
                            out = (r.stdout or "").strip()
                            if not out:
                                print(f"[{name}] {cmd0} rc={r.returncode} {r.stderr.strip()[-300:]}", flush=True)
                                out = f"⚠️ {cmd0} couldn't compute right now — nothing guessed. Try again in a minute."
                        except Exception as e:
                            out = f"[{cmd0} error] {e}"
                        send_reply(chat_id, out)
                        if cmd0 not in ("/alerts", "/moonguide", "/esonatal"):   # these carry every ✧ line inline
                            astro_key(chat_id, out)
                        print(f"[{name}] {cmd0}", flush=True)
                        continue
                    if cmd0 == "/readings":
                        d = Path.home() / "agents/claudeclaw/data/astrology"
                        files = sorted(p.stem for p in d.glob("mike-*.html") if "trading" not in p.stem) if d.is_dir() else []
                        send_reply(chat_id, ("📚 Your astrology suite (claudeclaw /astrology):\n" +
                                             "\n".join("• " + f for f in files) +
                                             "\nAsk me about any of them by name.")
                                   if files else "📚 No readings found in the suite yet.")
                        print(f"[{name}] /readings", flush=True)
                        continue
                    # 2026-09-28 review fence: nothing reaches the LLM on this lane without the
                    # COMPUTED FACTS block, and no stray slash command reaches a skill.
                    if text.startswith("/"):
                        send_reply(chat_id, f"Unknown astrology command {cmd0} — /help lists them.")
                        continue
                    if not facts_ctx:
                        send_reply(chat_id, "⚠️ The chart calculation didn't run, so I won't guess. "
                                            "Try again in a minute, or /today.")
                        print(f"[{name}] no facts → refused LLM", flush=True)
                        continue
                # /greeks <TKR> → live lookup (LLM, any contract incl. flow); bare → quantum picks
                if cmd0 == "/greeks":
                    import quantum_tg
                    arg = text.split(maxsplit=1)[1].strip() if " " in text else ""
                    if arg:
                        tg("sendChatAction", chat_id=chat_id, action="typing")
                        send_reply(chat_id, quantum_tg.tidy(
                            ask_local(quantum_tg.greeks_prompt(arg)), 9))
                    else:
                        send_html(chat_id, quantum_tg.greeks())
                    print(f"[{name}] /greeks {arg}", flush=True)
                    continue
                # /levels /dossier /intel /gex /oi /iv <TKR> → intel CLI (deterministic, no LLM)
                if cmd0 in INTEL_CMDS:
                    arg = text.split(maxsplit=1)[1].strip() if " " in text else ""
                    if not arg:
                        send_reply(chat_id, f"usage: {cmd0} NVDA" + (" [short]" if cmd0 == "/levels" else ""))
                        continue
                    args = [INTEL_CMDS[cmd0], *arg.split()]
                    if cmd0 == "/levels" and args[-1].lower() in ("short", "long"):
                        args = args[:-1] + ["--side", args[-1].lower()]
                    tg("sendChatAction", chat_id=chat_id, action="typing")
                    send_reply(chat_id, run_intel(args))
                    print(f"[{name}] {cmd0} {arg}", flush=True)
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
                    send_html(chat_id, msg)
                    print(f"[{name}] {cmd0} {arg}", flush=True)
                    continue
                if cmd0 in ("/pick", "/picks", "/book", "/grade", "/eod", "/flow",
                            "/crypto", "/explain", "/sweeps", "/odte"):
                    tg("sendChatAction", chat_id=chat_id, action="typing")
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
                    send_html(chat_id, msg)
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
                #    This lets the Codex-brain lanes use the Codex-installed AInvest/SkillHub skills
                #    instead of bouncing /ainvest back through Claude.
                #  • plain text → the persona's own brain (claude, or Codex/Grok/etc.
                #    for the reserve bots) — provider diversity preserved.
                # Each call is a FRESH `claude -p` (stateless): no context carries between
                # messages, so there's nothing to clear (no /newchat) and briefs are untouched.
                print(f"[{name}] Q: " + (f"{len(text)} chars" if cfg.get("astro_only") else text[:120]), flush=True)
                tg("sendChatAction", chat_id=chat_id, action="typing")
                try:
                    codex_primary = (cfg.get("providers") or [None])[0] == "codex_cli"
                    qq = with_context(text, facts_ctx)
                    a = ask_persona(qq) if (codex_primary or not text.startswith("/")) else ask_local(qq)
                    if cfg.get("astro_only") and not a.startswith("["):
                        a = astro_factcheck(a)          # 2026-09-15: every answer audited vs the ephemeris
                    send_reply(chat_id, a)
                    astro_key(chat_id, a)
                    remember(text, a)
                    print(f"[{name}] A: {len(a)} chars", flush=True)
                except Exception as e:
                    tg("sendMessage", chat_id=chat_id, text=f"⚠️ {name} error: {e}")
        except Exception as e:
            print(f"poll loop error: {_redact(e)}", flush=True); time.sleep(5)


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
