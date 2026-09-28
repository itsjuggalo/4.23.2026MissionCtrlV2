#!/home/itsju/.venv/bin/python
"""tg_set_commands.py — set each Telegram bot's native `/` command menu (setMyCommands)
to its ACTUAL working commands. Idempotent; re-run to update.

Why: the fleet's command menus were stale Hermes leftovers (generic start/newchat/
respin/voice/model — 32 on most, 100 on Flow Digest, 0 on System Health) — none matched
what the bot actually does. This sets verified, role-appropriate menus and CLEARS the
menus on pure-push bots (so tapping a command never hits silence). Commands below are
verified against tg_responder.py / lifeclaw_bot.py / bots/grok_telegram.py / antigravity.

Token resolution reuses bot_rebrand (_tok = secrets file, _vault_tok = vault.db).
"""
import json, sys, time
import requests
import bot_rebrand as b

def C(pairs):  # [(cmd, desc), ...] -> Telegram BotCommand list
    return [{"command": c, "description": d} for c, d in pairs]

COCKPIT_FULL = C([
    ("pick", "The #1 contract to buy now (verified + sized)"),
    ("picks", "Top 3 ranked contracts"),
    ("flow", "Live whale options flow"),
    ("sweeps", "Aggressive ask-side sweep prints"),
    ("odte", "0DTE plays"),
    ("winners", "App-pushed flow + chase/skip verdict"),
    ("chase", "Full read on a ticker, e.g. /chase NVDA"),
    ("greeks", "Greeks for a ticker, e.g. /greeks NVDA"),
    ("x", "Live X/Twitter sentiment, e.g. /x NVDA"),
    ("news", "Portfolio-aware macro/news read"),
    ("book", "Open positions"),
    ("grade", "Options academy rep"),
    ("eod", "End-of-day scorecard"),
    ("crypto", "BTC desk (24/7)"),
    ("explain", "Plain-English Greeks/IV"),
    ("help", "Show the command menu"),
])
COCKPIT_LITE = C([
    ("pick", "The #1 contract to buy now"),
    ("flow", "Live whale options flow"),
    ("greeks", "Greeks for a ticker, e.g. /greeks NVDA"),
    ("x", "Live X/Twitter sentiment, e.g. /x NVDA"),
    ("news", "Macro/news read"),
    ("help", "Show the command menu"),
])
# ── desk-specific menus (2026-06-24 fleet designation — each desk a distinct tap-list) ──
MACRO_MENU = C([
    ("news", "Macro/news read for your book"),
    ("x", "Live X sentiment, e.g. /x SPY"),
    ("greeks", "Greeks for a ticker"),
    ("help", "What this desk does (regime · VIX · levels)"),
])
RESEARCH_MENU = C([
    ("greeks", "Greeks for a ticker, e.g. /greeks NVDA"),
    ("news", "Catalysts/news for a ticker"),
    ("x", "Live X sentiment"),
    ("explain", "Plain-English Greeks/IV"),
    ("help", "What this desk does (research · IV · straddle)"),
])
SCREENER_MENU = C([
    ("flow", "Live whale options flow"),
    ("sweeps", "Aggressive ask-side sweeps"),
    ("odte", "0DTE plays"),
    ("news", "What's moving"),
    ("help", "What this desk does (find & rank names)"),
])
RISK_MENU = C([
    ("pick", "#1 contract — I size + risk it"),
    ("greeks", "Greeks for a ticker"),
    ("news", "Macro/news read"),
    ("explain", "Plain-English Greeks/IV"),
    ("help", "What this desk does (max-loss · sizing · hedges)"),
])
JAZZY_MENU = C([
    ("book", "Open Jazzy positions"),
    ("pick", "#1 contract (sized vs Jazzy equity)"),
    ("greeks", "Greeks for a ticker"),
    ("help", "What this desk does (Jazzy paper account)"),
])
LIFE = C([
    ("brief", "Your life brief (calendar, inbox, weather)"),
    ("today", "What's on today"),
    ("todo", "Your to-do list"),
    ("debts", "Debt payoff plan (/debts full = scenarios)"),
    ("paid", "Mark a bill paid"),
    ("help", "Show the command menu"),
])
AIME = C([
    ("ainvest", "One-shot AIME research, e.g. /ainvest read on NVDA"),
    ("agent", "Pin a specialist (copilot/screener/charts/news/predict/crypto/options)"),
    ("exit", "Unpin — back to AIME relay"),
    ("help", "Show the command menu"),
])
OPS = C([("help", "Ask me 'is everything healthy?', 'pm2 status', 'why is X down?'")])
XBOT = C([
    ("help", "Text me a ticker for live X/Twitter sentiment"),
    ("clear", "Clear our conversation"),
    ("reset", "Reset the chat"),
])
ASTRO = C([   # astrology-only lane (@JazzyHazzyClaw_Bot) — final round 2026-09-27: the 8 core flows
    # (Today · Week · Transits · Progressions · Synastry · Progressed synastry · Timeline · Ask)
    ("today", "Today's read: ranked live transits + exact times"),
    ("week", "Themes + every exact of the next 7 days"),
    ("transits", "Today's transits (same as /today) · /full = all + why"),
    ("progressions", "Progressed Moon/Venus + next changes"),
    ("synastry", "Compare charts: /synastry <name> (profile first)"),
    ("progsyn", "Progressed synastry: /progsyn <name>"),
    ("timeline", "Dated hits ahead: /timeline 60"),
    ("moon", "Moon sign + phase vs your placements"),
    ("esoteric", "Soul-level (esoteric) read of your transits"),
    ("help", "Or just ask in plain words · /help all"),
])
CLEAR = []  # pure-push / infra bots: no responder → remove any (misleading) menu
# @PipelineSignals_Bot — telegram_dm_responder.py (cron, every min). No-arg commands only:
# a menu tap sends the bare word. RESUME (clears a shock-guard HALT) deliberately left off
# the tap-list so it can't be hit by accident. (2026-09-28)
PIPELINE_MENU = C([
    ("help", "Flow Coach commands (GATE / EXPLAIN / PAPER need a ticker)"),
    ("quiz", "Pop quiz from today's real signals"),
    ("score", "Virtual journal: mark to market, win/loss"),
    ("paper", "List open virtual journal entries"),
    ("greeks", "Learn options greeks"),
    ("ta", "Learn chart reading"),
    ("learn", "Random learning quiz"),
])

# bot -> (token key, kind file|vault, menu)
FLEET = {
    "trading_command": ("telegram_laptopclaude_bot_token", "f", COCKPIT_FULL),
    "system_health":   ("telegram-ping-bot-token",         "f", OPS),
    "life_wellness":   ("lifeclaw_telegram_bot_token",     "f", LIFE),
    # 2026-09-28: responder antigravity-aime stopped since the 07-15 PM2 trim (push-only) —
    # CLEAR so a tap never hits silence. Restore AIME if the responder comes back.
    "aime_research":   ("telegram_antigravity_bot_token",  "f", CLEAR),
    # Trading Lab (@AntiDoht_Bot) is push-only (quantum IV desk) — no poller, so no menu.
    "research_desk":   ("antidote_telegram_bot_token",     "f", CLEAR),
    "flow_signals":    ("telegram-bot-token.txt",          "f", PIPELINE_MENU),
    # RETIRED 2026-09-27 (@MoneyFlowz_Bot parked, no poller):
    # "x_sentiment":     ("telegram_grok_bot_token",         "f", XBOT),
    "astrology":       ("telegram_jazzyhazzy_bot_token",  "f", ASTRO),
    # PARKED 2026-07-19 (token free to repurpose):
    #     "risk_hedge":      ("antidote_telegram_bot_token",     "f", RISK_MENU),
    # PARKED 2026-07-19 (token free to repurpose):
    #     "research_desk":   ("telegram_orion_bot_token",        "f", RESEARCH_MENU),
    # RETIRED 2026-07-19: token now ClaudeClaw OS's own bot — its grammy app registers
    # its own commands; running this entry would clobber them.
    # "screener":      ("telegram_deepseek_bot_token",     "f", SCREENER_MENU),
    # RETIRED 2026-07-19: token now the MasterMC agent's own bot — claudeclaw registers
    # its own commands; running this entry would clobber them.
    # "macro_regime":  ("telegram_mc_skill_bot_token",     "f", MACRO_MENU),
    "flow_digest":     ("telegram_boba2_bot_token",        "v", CLEAR),
    "daily_briefs":    ("telegram.daily_briefs",           "v", CLEAR),
    "media_gens":      ("telegram.media_gens",             "v", CLEAR),
    # hermes_relay / openclaw_grok: menus are registered by their own live apps (PM2
    # hermes-gateway / openclaw-gateway) — CLEARing them here would wipe working menus.
    # "hermes_relay":    ("telegram_hermes_bot_token",       "v", CLEAR),
    # "openclaw_grok":   ("telegram_openclaw_bot_token",     "v", CLEAR),
    # jazzy_relay / orion_relay retired 2026-09-15 (removed from tg_fleet + tg_responder).
    "grok_scout":      ("telegram.grok_scout",             "v", XBOT),
    "trend_scanner":   ("telegram.trend_scanner",          "v", SCREENER_MENU),
}
# flow_signals (@PipelineSignals_Bot): its menu was a stale claudeclaw leftover (30+ dead
# commands); now PIPELINE_MENU, matching telegram_dm_responder.route(). (2026-09-28)

def set_cmds(tok, cmds):
    r = requests.post(f"https://api.telegram.org/bot{tok}/setMyCommands",
                      json={"commands": cmds}, timeout=15).json()
    return r.get("ok", False), r.get("description", "")

def main():
    only = sys.argv[1] if len(sys.argv) > 1 else None
    for fn, (key, kind, cmds) in FLEET.items():
        if only and fn != only:
            continue
        try:
            tok = b._tok(key) if kind == "f" else b._vault_tok(key)
            if not tok:
                print(f"  ✗ {fn:16} no token ({key})"); continue
            ok, err = set_cmds(tok, cmds)
            label = "CLEARED" if cmds == [] else f"{len(cmds)} cmds"
            print(f"  {'✓' if ok else '✗'} {fn:16} {label}" + ("" if ok else f"  ERR {err}"))
        except Exception as e:
            print(f"  ✗ {fn:16} {e}")
        time.sleep(0.4)

if __name__ == "__main__":
    main()
