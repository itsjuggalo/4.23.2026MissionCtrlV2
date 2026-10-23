#!/home/itsju/.venv/bin/python
"""tg_fleet.py — the single source of truth for Mike's Telegram bot fleet.

Mike's decision (2026-06-15): ALL telegram tokens live in ONE place = vault.db, and every
bot has exactly ONE function. This module:
  • holds the FLEET registry (function → identity + role)
  • `harvest`  — pulls each token from its (scattered) current source, getMe-verifies it, and
                 writes it into vault.db under a uniform key  telegram.<function>
  • `send`     — send(function, msg): resolve the vault token + post to Mike's chat
  • `export`   — regenerate the old flat secret-file names from vault (back-compat shim)
  • `status`   — print the fleet + verify each token via getMe
  • `manifest` — write ~/.openclaw/telegram_fleet.json (metadata only, NO token values)

  tg_fleet.py status
  tg_fleet.py harvest [--write]
  tg_fleet.py send <function> "<message>"
  tg_fleet.py token <function>            # print the resolved token (for senders; pinned bot id only)
  tg_fleet.py lanes                       # every bot + its lanes (ids only); exit 1 on a trading/non-trading mix
  tg_fleet.py set <function> <TOKEN>      # fold in a cloud-only bot (Gamma/CHANGE NOW/BobaClaw)
"""
import json
import os
import sqlite3
import sys
import urllib.parse
import urllib.request, urllib.error

import requests

SEC = os.path.expanduser("~/.openclaw/secrets")
VAULT = os.path.expanduser("~/.openclaw/vault.db")
MANIFEST = os.path.expanduser("~/.openclaw/telegram_fleet.json")
CHAT_FILE = os.path.join(SEC, "telegram-chat-id.txt")

# function → identity. `src` = where the token CURRENTLY lives (for harvest):
#   ("file", name) flat secret file · ("vault", key) existing vault key · ("cloud", None) Mike pastes.
# role: interactive (polled getUpdates) | push (send-only) | infra (not a chat target) | spare
FLEET = {
    # ── interactive (you text them) ─────────────────────────────────────────
    "trading_command": dict(user="oOLaptopClaude_Bot",      avatar="raynor",          role="interactive", src=("file", "telegram_laptopclaude_bot_token")),
    "system_health":   dict(user="Pingpong727_Bot",         avatar="adjutant",        role="interactive", src=("file", "telegram-ping-bot-token")),
    "life_wellness":   dict(user="LifeClaw727_Bot",         avatar="arbiter",         role="interactive", src=("file", "lifeclaw_telegram_bot_token")),
    "aime_research":   dict(user="AntiGravityg59laptop_Bot",avatar="zeratul",         role="push",        src=("file", "telegram_antigravity_bot_token")),
    # 2026-09-28: @MoneyFlowz_Bot (ex x_sentiment, retired 09-27) REPURPOSED as the QUIZ-ONLY
    # lane — every trading quiz sends here; poller = quiz_bot.py (PM2 quiz-bot).
    "quiz":            dict(user="MoneyFlowz_Bot",          avatar="nova",            role="interactive", src=("file", "telegram_grok_bot_token")),
    # RETIRED 2026-09-27: x_sentiment (@MoneyFlowz_Bot) — its only poller, PM2 grok-bot, was dead
    # since 09-02 and nothing sends TG_FN=x_sentiment. Bot stays parked in BotFather; token file kept.
    # 2026-08-10 — @JazzyHazzyClaw_Bot (PARKED since 07-19, ex Jazzy Desk) REPURPOSED as the
    # ASTROLOGY-ONLY lane: natal / transits / readings, never trading. Old fn `jazzy_desk`
    # retired; vault key is now telegram.astrology.
    "astrology":       dict(user="JazzyHazzyClaw_Bot",      avatar="high_templar",    role="interactive", src=("file", "telegram_jazzyhazzy_bot_token")),
    # 🚨 2026-07-29 — @ResearchDaMoney_Bot IS NOW MIKE'S MASSAGE BUSINESS CHAT
    # ("Massage By Mike — Chat"). It used to be research_desk, so five quantum senders
    # hardcoding TG_FN=research_desk were pushing IV Desk / Straddle Lab / Pre-Trade
    # Confluence / payoff+IV charts straight into a client-facing chat (29 msgs in 7d).
    # `research_desk` now points at the free @AntiDoht_Bot, rebranded "Trading Lab" —
    # the learning lane. `telegram_orion_bot_token` is deliberately referenced by NO
    # fleet function any more, so nothing can leak back into the massage chat.
    # ⛔ DO NOT re-add a fleet entry pointing at telegram_orion_bot_token.
    # (The old `risk_hedge` fn was the same @AntiDoht_Bot and was PARKED/unused — it is
    # folded into research_desk rather than left as a duplicate token mapping.)
    "research_desk":   dict(user="AntiDoht_Bot",            avatar="aldaris",         role="push",        src=("file", "antidote_telegram_bot_token")),
    # 2026-10-22 (MC-AUD-084, Mike GO): the TA-chart lane (quantum ta_chart.py, TG_FN=screener) moved OFF
    # @TrndRsrch_Bot — that bot is ClaudeClaw OS's own chat (grammy poller), not a trading lane — onto the
    # unused spare @JazzyHazzyTelegram_Bot (its vault row is telegram.media_gens; old bot in MOVED).
    "screener":        dict(user="JazzyHazzyTelegram_Bot",  avatar="wraith",          role="push",        src=("vault", "telegram.media_gens")),
    # RETIRED 2026-09-27: macro_regime (@MMCTRL727_Bot) — owner was the claudeclaw `mastermc` persona,
    # deleted 2026-08-30 (no unique code). Bot stays parked in BotFather; token file kept.
    # ── push (they alert you) ───────────────────────────────────────────────
    "flow_signals":    dict(user="PipelineSignals_Bot",     avatar="queen_of_blades", role="push",        src=("file", "telegram-bot-token.txt")),
    # flow_digest content is delivered by trading_command since 2026-09-28 (see ALIAS below);
    # @Boba2Telegram_Bot stays registered, parked, token kept.
    # 2026-09-28 (Mike: "use the bots that haven't messaged this month") — three idle bots
    # take the trading overflow so Trading Command carries act-now messages only:
    "trading_digest":  dict(user="Boba2Telegram_Bot",       avatar="hydralisk",       role="interactive", src=("vault", "telegram_boba2_bot_token")),   # compact FYI digest (lib/tg_digest.py)
    "trading_recaps":  dict(user="MMCTRL727_Bot",           avatar="mengsk",          role="interactive", src=("file", "telegram_mc_skill_bot_token")), # EOD / grades / scorecards / weekly report card
    "crypto_desk":     dict(user="Grootk_Bot",              avatar="dark_archon",     role="interactive", src=("vault", "telegram.grok_scout")),        # BTC/ETH moves + news, QuantEdge perps
    "flow_digest":     dict(user="Boba2Telegram_Bot",       avatar="hydralisk",       role="push",        src=("vault", "telegram_boba2_bot_token")),
    "daily_briefs":    dict(user="SpaceCoast_Claude_Bot",   avatar="ghost",           role="push",        src=("cloud", None)),
    # RETIRED 2026-10-22: media_gens (@JazzyHazzyTelegram_Bot "Spare — Media (unused)") — no sender ever
    # used it; the bot now carries the `screener` TA-chart lane. Vault key telegram.media_gens kept.
    # ── app notifiers (off the trade chats — their own app's events only) ───
    # 2026-09-15 (D7, telegram lane charter spec) — WinMeals' chain_footprint.py --notify
    # was landing on tg-send-msg's trading_command DEFAULT (ops sweep finding: unrelated
    # WinMeals-accuracy content in the trading firehose). chain_footprint.py now passes
    # TG_FN=winmeals explicitly. 2026-09-15 follow-up: rather than have Mike BotFather a
    # new bot at the 20-bot cap, repointed at trend_scanner's already-tokened, confirmed-
    # idle @Deepseeker_Bot — its crontab line is commented out and no live sender
    # referenced it (grep across ~/scripts, ~/05_AUTOMATION/scripts, /AIWorkWSL/web,
    # /AIWorkWSL/trading only turned up shared reserve/responder infra, not a dedicated
    # sender). `src` below is the VAULT REFERENCE only (telegram.trend_scanner) — the
    # secret value itself was never copied/duplicated; see the retired note on
    # trend_scanner further down. Mike can rename the bot's display name via BotFather
    # /setname whenever he likes — nothing here depends on the display name.
    # 2026-10-22 (MC-AUD-084): trend_scanner moved off this bot — WinMeals is now the only job on it.
    "winmeals":        dict(user="Deepseeker_Bot",           avatar="medic",           role="push",        src=("vault", "telegram.trend_scanner")),
    # ── infra (not chat targets) ────────────────────────────────────────────
    # RETIRED 2026-10-22: hermes_relay (@Gumroadie_bot "Hermes Agent") — hermes-gateway stopped since 2026-09-30;
    # the bot now carries boba_desk (see MOVED). Vault key telegram_hermes_bot_token kept.
    "openclaw_grok":   dict(user="OpenclawGrok727_Bot",     avatar="ghost",           role="infra",       src=("vault", "telegram_openclaw_bot_token")),
    # laptop_control = RESERVED slot for a Telegram-channel gateway (tg-channel). Channel deferred
    # 2026-06-21: Mike at the 20-bot BotFather cap + phone-hub (Remote Control) already covers phone
    # control. Activate only if a bot slot frees: free a slot → BotFather /newbot → drop the token in
    # ~/.openclaw/secrets/telegram_phone_channel_bot_token → tg-channel. See [[reference_phone_remote_control]].
    "laptop_control":  dict(user="(reserved — no bot; cap reached)", avatar="battlecruiser", role="infra", src=("file", "telegram_phone_channel_bot_token")),
    # (spare_backup / @BobaClaw removed 2026-06-21 — phantom: no real BotFather bot existed; all 20 slots are live.)
    # ── reserve pool (Mike's spare bots, folded in 2026-06-16 — named + rebranded, persona-ready) ──
    # (jazzy_relay @JazzyHazzy_Bot + orion_relay @oOrionz_Bot removed 2026-09-15 — Orion/Boba/Jazzy retired; bots stay parked in BotFather.)
    # Repurposed 2026-10-06 (Mike: "rename them of their new purposes"):
    #   flow_momentum      = Option Momentum Engine Best-3 alerts (pipeline/decision/option_momentum/alerts.py pins id 8699883048)
    #   contract_forensics = why-it-moved case notes (pipeline/decision/option_momentum/explain.py --send contract_forensics)
    # 2026-10-22 (Mike GO, MC-AUD-157/171): each bot ALSO answers Mike's questions — ONE poller per bot, MissionCtrl
    # PM2 boba-lane-jazzy / boba-lane-orion (pipeline/decision/boba/telegram_lane.py; sends via tg_lint + the ledger).
    # The senders above stay send-only (they never getUpdates), so they cannot collide with the lane's poller.
    "flow_momentum":      dict(user="JazzyHazzy_Bot",  avatar="arbiter",  role="interactive", src=("vault", "telegram.jazzy_relay")),
    "contract_forensics": dict(user="oOrionz_Bot",     avatar="sentinel", role="interactive", src=("vault", "telegram.orion_relay")),
    # 2026-10-22 (Mike: "use one of the bots that isn't being used"): Boba's own Q&A lane, PM2 boba-lane-boba
    # (telegram_lane.py boba). New fn (not in MOVED): the lane was pinned to @Boba2 but never went live there — lane-bots
    # polls @Boba2 for trading_digest, so a second poller would 409.
    # @Gumroadie_bot was the Hermes agent's chat: hermes-gateway stopped since 2026-09-30, 0 ledger sends.
    # Restarting hermes-gateway on this token would fight the lane (409) — give Hermes another bot first.
    "boba_desk":          dict(user="Gumroadie_bot",   avatar="dragoon",  role="interactive", src=("vault", "telegram_hermes_bot_token")),
    "grok_scout":      dict(user="Grootk_Bot",              avatar="goliath",         role="spare",       src=("cloud", None)),
    # retired→winmeals 2026-09-15: confirmed idle (crontab line commented out, no live
    # sender referenced it) — its vault token (telegram.trend_scanner) is now also
    # reachable as the "winmeals" fleet fn above (same underlying vault row, not
    # duplicated). Left resolvable here too so nothing that still names "trend_scanner"
    # (reserve_persona_push.py, bot_rebrand.py, tg_responder.py's DM menu) breaks — just
    # don't route new content at it under this name.
    # 2026-10-22 (MC-AUD-084, Mike GO): tg-gateway still polled the trendscanner persona (a trading
    # scanner) on the WinMeals bot, so trading replies shared a chat with WinMeals alerts. The persona
    # moved to @SpaceCoast_Claude_Bot (trading backup-alerts bot, no sends to date; vault row
    # telegram.daily_briefs). The vault row telegram.trend_scanner stays the WinMeals bot's token
    # (winmeals' src) — an explicit vault src wins in token(). Old bot in MOVED below.
    "trend_scanner":   dict(user="SpaceCoast_Claude_Bot",   avatar="firebat",         role="interactive", src=("vault", "telegram.daily_briefs")),
}

# ── Lane identity (MC-AUD-084/088, Mike GO 2026-10-22) ──────────────────────────────────────────
# BOT_ID pins every function to its bot's NUMERIC id (the token prefix: public, not the secret).
# send / send_upload / the `token` verb refuse a token whose id is not the pin, and set / harvest
# refuse to store one, so a wrong token can never claim a lane (MC-AUD-078 E17.03).
BOT_ID = {
    "trading_command": 8846283782, "system_health": 8859951513, "life_wellness": 8625099101,
    "aime_research": 8523091364, "quiz": 8619370934, "astrology": 8617274201,
    "research_desk": 8873738822, "screener": 8520537147, "flow_signals": 8832281008,
    "trading_digest": 8732615829, "trading_recaps": 8971365609, "crypto_desk": 8628283615,
    "flow_digest": 8732615829, "daily_briefs": 8519775882, "winmeals": 8950043596,
    "boba_desk": 8637552667, "openclaw_grok": 8997890122, "flow_momentum": 8699883048,
    "contract_forensics": 8812859752, "grok_scout": 8628283615, "trend_scanner": 8519775882,
}
# What each lane carries. One bot never mixes "trading" with another kind (`tg_fleet.py lanes`
# lists every bot and exits 1 on a mix). Several trading lanes may share a trading bot.
KIND = {
    "trading_command": "trading", "aime_research": "trading", "quiz": "trading",
    "research_desk": "trading", "screener": "trading", "flow_signals": "trading",
    "trading_digest": "trading", "trading_recaps": "trading", "crypto_desk": "trading",
    "flow_digest": "trading", "daily_briefs": "trading", "flow_momentum": "trading",
    "contract_forensics": "trading", "grok_scout": "trading", "trend_scanner": "trading",
    "system_health": "ops", "life_wellness": "personal", "astrology": "personal",
    "boba_desk": "trading",
    "winmeals": "app", "openclaw_grok": "infra", "laptop_control": "infra",
}
# A lane whose bot changed: the bot it used before and until when (ET), so its old output (in the
# old chat) and new output stay traceable (MC-AUD-088). The tg ledger also stamps bot_id per send.
MOVED = {
    "screener": [dict(bot_id=8442367980, user="TrndRsrch_Bot", until="2026-10-22 ET",
                      why="ClaudeClaw OS chat, not a trading lane")],
    "trend_scanner": [dict(bot_id=8950043596, user="Deepseeker_Bot", until="2026-10-22 ET",
                           why="WinMeals Alerts chat (app, non-trading)")],
}

# ─────────────────────────────────────────────────────────────────────────────
# CHARTER — lane charter registry (2026-09-15, spec: docs/superpowers/specs/
# 2026-09-15-telegram-lane-charter-design.md §2). Mike: "the goal of having
# different bots is so that the info doesn't get drowned by other messages.
# Upgrade each bot so each telegram is specific to the information it
# provides so it doesn't get lost." ADVISORY ONLY — nothing here feeds
# sizing/gates/decision cycles.
#
# One entry per LANE (a lane is a distinct topic, not always 1:1 with a FLEET
# bot — several lanes share one bot, e.g. trading_command carries the morning
# brief + setups + rebound + catalyst-evening). Keys:
#   fleet         — which FLEET function/bot this lane's messages land in
#   owns / never  — the content contract from the spec table (§2)
#   cadence       — human cron label (source of truth: crontab -l)
#   cadence_min   — minutes between fires, used for the checker's "read older
#                   than 2x cadence => dead upstream" math
#   reads         — every file path / http://localhost:3000/api/... URL the
#                   lane's script(s) consume, derived by reading the scripts
#                   (NOT secrets — no tokens/chat ids ever go in this list)
#   dry_run_cmd   — exact argv (list[str]) to render the lane with no send,
#                   or None if the underlying script has no --dry-run yet.
#                   D1-D9 (spec §1) task two sibling agents with adding
#                   --dry-run to morning_command/eod_scorecard/rebound_
#                   trigger_ping/data_freshness_auditor and setup_scanner/
#                   explosion_score/shock_guard/iv_tg/chain_footprint — those
#                   entries already point at the flag so lane_consistency.py
#                   picks it up the moment it lands, with no further edit
#                   here. Lanes with no --dry-run planned this pass are None.
# ─────────────────────────────────────────────────────────────────────────────
_H = os.path.expanduser("~")

CHARTER = {
    "trading_command": dict(
        fleet="trading_command",
        owns=["regime + macro reaction", "structure-vs-sentiment", "catalyst read-through",
              "DPH dark-pool line", "relay x DP tags", "high-SNR headlines", "day plan"],
        never=["holdings", "equity", "intraday triggers", "grades"],
        cadence="08:15 ET Mon-Fri", cadence_min=24 * 60,
        reads=[
            f"{_H}/.openclaw/data/decision/factors/catalysts.json",
            f"{_H}/.openclaw/data/decision/rebound_setup.json",
            f"{_H}/.openclaw/data/decision/macro_reaction.json",
            "/AIWorkWSL/labs/quantum/out/best_contracts.json",
            "http://localhost:3000/api/decision?symbol=SPY",
            "http://localhost:3000/api/macro-regime",
        ],
        # Producers deliberately silenced (crontab "silenced 2026-09-30"): the checker
        # reports PAUSED (WARN), not a dead-upstream FAIL. Remove an entry on un-silence.
        paused={
            "/AIWorkWSL/labs/quantum/out/best_contracts.json": dict(since="2026-09-30",
                reason="producer silenced by Mike"),
        },
        dry_run_cmd=[f"{_H}/.venv/bin/python",
                     f"{_H}/05_AUTOMATION/scripts/morning_command.py", "--dry-run"],
    ),
    "setup_sms": dict(
        fleet="trading_command",
        owns=["premarket/opening setups", "MTF glyph", "rebound state"],
        never=["regime narrative", "grades"],
        cadence="08:20/09:12/09:50 + :10,:30,:50 10-15 ET Mon-Fri + weekend --crypto",
        cadence_min=20,
        # Round 2 (2026-09-15): D3 landed — setup_scanner.py no longer calls the dead
        # /api/portfolio-rh route (a code import, not a freshness-checkable "read";
        # risk_cap.py itself is retired, R5 2026-10-20). It now reads MTF/rebound state
        # through the shared mtf_rebound.py helper, confirmed via `import mtf_rebound as
        # mr` + its own /api/mtf-ta and /api/rebound-setup calls — using SPY as the probe
        # symbol here since `reads` is a static per-lane list, not per-ticker.
        reads=[
            "http://localhost:3000/api/mtf-ta?symbol=SPY",
            "http://localhost:3000/api/rebound-setup?symbol=SPY",
        ],
        # setup_scanner.py's real flag is `--dry` (not `--dry-run` — verified by reading
        # main(): `dry = "--dry" in args`). `--dry-run` alone would be silently ignored
        # (it uses a bare sys.argv set-membership check, not argparse, so an unknown flag
        # never errors) and the script would run LIVE, sending real SMS/Telegram — this
        # was caught and fixed before ever being committed. Verified live: `setup_scanner.py
        # --premarket --dry` exits 0, prints only, sends nothing (2026-09-15).
        dry_run_cmd=[f"{_H}/mc-kb/.venv/bin/python", "setup_scanner.py", "--premarket", "--dry"],
        cwd="/AIWorkWSL/trading/analysis",
    ),
    "explosion_runner": dict(
        fleet="trading_command",
        owns=["scored pre-explosion candidates (own grader floor)", "runner-watch list"],
        never=["setups already sent (cite trigger_id instead)"],
        cadence="09:50 + hourly 10-15 ET Mon-Fri (explosion_score); 08:35 + :20 10-15 ET (runner_radar)",
        # cadence_min is 24h here specifically for the floor-file staleness check below
        # (it only gates FILE-type reads — the two API URLs above are checked by HTTP
        # status only, unaffected by this value); team-lead verified live that's the
        # realistic write cadence to gate on, not the hourly script-run cadence in the
        # `cadence` label above.
        cadence_min=24 * 60,
        # Round 2: D3 landed here too (dead /api/portfolio-rh call deleted). explosion_score.py also imports mtf_rebound as mr.
        # Round 3 correction (team-lead, 2026-09-15): explosion_score_floor.json DOES
        # exist now (shipped by the sibling agent after round 2's check, confirmed live
        # — score_floor(), FLOOR_OUT = data/explosion_score_floor.json) — it's an
        # OUTPUT explosion_score.py writes from signal_outcomes.sqlite each run, not an
        # input it reads back, but tracking its freshness is still a legitimate signal
        # that the floor-computation half of the pipeline last succeeded. Re-added.
        reads=[
            "http://localhost:3000/api/mtf-ta?symbol=SPY",
            "http://localhost:3000/api/rebound-setup?symbol=SPY",
            "/AIWorkWSL/trading/analysis/data/explosion_score_floor.json",
        ],
        # explosion_score.py's real flag is also `--dry` (same bare-sys.argv pattern as
        # setup_scanner.py, same wrong-flag-would-silently-run-live risk — fixed here
        # too). Verified live: `explosion_score.py --dry` exits 0, prints only
        # (2026-09-15).
        dry_run_cmd=["/usr/bin/python3", "explosion_score.py", "--dry"],
        cwd="/AIWorkWSL/trading/analysis",
    ),
    "pullback_autowatch": dict(
        fleet="trading_command",
        owns=["pullback-to-level watches (levels from /api/decision + /api/mtf-ta)"],
        never=["anything that is not a level watch"],
        cadence=":20,:50 9-16 ET Mon-Fri", cadence_min=30,
        # Round 4 (team-lead, 2026-09-15): re-derived by reading the script. It GETs
        # the board (not the POST it writes to), plus a per-symbol /api/decision level
        # cross-check and mtf_rebound.py's /api/mtf-ta glyph (same shared helper
        # setup_scanner/explosion_score use) — confirmed via `import mtf_rebound as mr`.
        reads=[
            "http://localhost:3000/api/pullback-watch?fresh=1",
            "http://localhost:3000/api/options-flow",
            "http://localhost:3000/api/decision?symbol=SPY",
            "http://localhost:3000/api/mtf-ta?symbol=SPY",
        ],
        # pullback_autowatch.py now has --dry-run (argparse, confirmed). Cron runs bare
        # `python3` from cwd /AIWorkWSL/trading/analysis with no PATH= override in the
        # crontab — verified it resolves to /usr/bin/python3 (both `which python3` and
        # `env -i which python3` agree; matches every other bare-python3 line in this
        # same crontab, e.g. runner_radar.py/explosion_score.py). Verified live:
        # `--dry-run` exits 0, prints "DRY RUN (not sent, N chars)", sends nothing
        # (2026-09-15).
        dry_run_cmd=["/usr/bin/python3", "/AIWorkWSL/trading/analysis/pullback_autowatch.py",
                     "--dry-run"],
    ),
    "rebound": dict(
        fleet="trading_command",
        owns=["TRIGGERED rebound setups", "pinned contract (symbol|triggeredAt state)"],
        never=["HELD/watching states (that's morning_command's brief, not this ping)"],
        cadence="09:45 + 10:15 ET Mon-Fri", cadence_min=30,
        reads=[
            f"{_H}/.openclaw/data/decision/rebound_setup.json",
            # Round 2 fix: real path is ~/.openclaw/data/decision/rebound_ping_state.json
            # (verified via rebound_trigger_ping.py's own STATE_FILE default), not
            # ~/05_AUTOMATION/state/... — the v1 path was a guess, never actually read
            # by the script, so it always WARNed "does not exist" regardless of truth.
            f"{_H}/.openclaw/data/decision/rebound_ping_state.json",
        ],
        dry_run_cmd=[f"{_H}/.venv/bin/python",
                     f"{_H}/05_AUTOMATION/scripts/rebound_trigger_ping.py", "--dry-run"],
    ),
    "catalyst_evening": dict(
        fleet="trading_command",
        owns=["cluster/CEO-buy days", "SNR corroboration"],
        never=["price commentary"],
        cadence="22:25 ET Mon-Fri", cadence_min=24 * 60,
        reads=[
            "http://localhost:3000/api/news-snr",
        ],
        dry_run_cmd=[f"{_H}/.venv/bin/python",
                     f"{_H}/05_AUTOMATION/scripts/catalyst_evening_ping.py", "--dry-run"],
    ),
    "flow_digest": dict(
        fleet="flow_digest",
        owns=["grades of today's flow picks", "best3 grader stats"],
        never=["equity", "P&L", "book value"],
        # Round 3 (2026-09-15, team-lead): eod_scorecard.py is final — repointed off
        # the dead trade_journal.jsonl entirely. Cron moved 16:10 -> 16:35 ET.
        cadence="16:35 ET Mon-Fri", cadence_min=24 * 60,
        # Re-derived by reading eod_scorecard.py's own constants (SIGNAL_OUTCOMES_DB,
        # REBOUND_PING_STATE, NEWS_SNR_URL) rather than trusting the old guess:
        reads=[
            "/AIWorkWSL/trading/analysis/signal_outcomes.sqlite",  # `alerts` table — setup_scanner + explosion_score sources
            f"{_H}/.openclaw/data/decision/rebound_ping_state.json",  # same pinned-sketch file as the `rebound` lane (D5)
            "http://localhost:3000/api/news-snr?min=65",
        ],
        dry_run_cmd=[f"{_H}/.venv/bin/python",
                     f"{_H}/05_AUTOMATION/scripts/eod_scorecard.py", "--dry-run"],
    ),
    "best3": dict(
        fleet="flow_digest",
        owns=["top-3 flow picks above the calibrated score floor"],
        never=["ungated/below-floor picks"],
        cadence="10:05 card Mon-Fri (override :10,:30,:50 10-15 + 16:20 grader + quiz SILENCED 2026-09-30)",
        cadence_min=24 * 60,  # only the daily 10:05 card remains; 20 was the silenced override cadence
        reads=[
            "/AIWorkWSL/trading/signals/option-scraper/data/best3.log",
            "/AIWorkWSL/trading/signals/option-scraper/data/best3_scoreboard.json",
        ],
        paused={
            "/AIWorkWSL/trading/signals/option-scraper/data/best3_scoreboard.json": dict(
                since="2026-09-30", reason="producer silenced by Mike (grader)"),
        },
        # Round 2: both scripts already had --eod --dry-run (argparse, confirmed via
        # grep + a live run — best3_grader prints the scoreboard/calibration/floor
        # buckets, scoreboard_auditor prints "no open virtual trades", both exit 0,
        # neither sends). Two independent commands for one lane — lane_consistency.py's
        # dry_run_cmd accepts a list of argv lists for exactly this case; it concatenates
        # whichever renders succeed and never crashes if one of the two fails.
        dry_run_cmd=[
            ["/usr/bin/python3", "best3_grader.py", "--eod", "--dry-run"],
            ["/usr/bin/python3", "scoreboard_auditor.py", "--eod", "--dry-run"],
        ],
        cwd="/AIWorkWSL/trading/signals/option-scraper/pipeline/digest",
    ),
    "shock_guard": dict(
        fleet="flow_signals",
        owns=["CRISIS/HALT only"],
        never=["routine market notes"],
        cadence="*/2 min always-on", cadence_min=2,
        # Alpaca (data.alpaca.markets) deliberately excluded from `reads`: D4 (spec §1)
        # demotes it to a fallback behind yfinance/api/market-news, and it needs auth
        # headers this checker doesn't carry (an unauthenticated probe would always
        # read 401/dead regardless of true health) — checking the free primary is the
        # honest freshness signal for this lane.
        reads=[
            "http://localhost:3000/api/market-news",
        ],
        # Round 2 fix: shock_guard.py's dry-run is an ENV VAR (`DRY=os.environ.get("DRY")
        # == "1"`), not a CLI flag — the v1 `--dry-run` argv did nothing (main() never
        # inspects sys.argv at all) and would have run LIVE every 2 minutes on cron,
        # capable of a real CRISIS/HALT send. Caught before commit; fixed to set DRY=1
        # via `env`, which lane_consistency.py merges into the subprocess environment.
        # Verified live: `DRY=1 python3 shock_guard.py` exits 0, prints the level/vix/
        # spy/btc/headlines JSON, sends nothing (2026-09-15).
        dry_run_cmd=["/usr/bin/python3", f"{_H}/scripts/shock_guard.py"],
        env={"DRY": "1"},
    ),
    "quantum": dict(
        fleet="research_desk",
        owns=["crypto desk reads (btc_desk/exit_monitor/pretrade_confluence)", "IV desk reads"],
        never=["equity"],
        cadence="10:05 + 15:25 ET Mon-Fri (iv_tg/iv_chart)", cadence_min=24 * 60,
        reads=[
            "/AIWorkWSL/labs/quantum/out/iv_forecast.json",
            "/AIWorkWSL/labs/quantum/out/premium_income.json",
            "http://localhost:3000/api/decision?symbol=SPY",
        ],
        paused={
            "/AIWorkWSL/labs/quantum/out/iv_forecast.json": dict(since="2026-09-30",
                reason="producer silenced by Mike (supercomputer.sh/quantum_sniper)"),
            "/AIWorkWSL/labs/quantum/out/premium_income.json": dict(since="2026-09-30",
                reason="producer silenced by Mike (supercomputer.sh/quantum_sniper)"),
        },
        # Round 2 fix: iv_tg.py is "Dry-run by default; --send pushes via Telegram" (its
        # own docstring) — it only defines `--send` via strict argparse, so the v1
        # `--dry-run` argv would have hit argparse's unrecognized-argument error (exit 2,
        # correctly SKIPPED, not a live-send risk here — but still not functional).
        # Fixed to no flags at all, which IS the dry-run path. Verified live: `iv_tg.py`
        # (no args) exits 0, prints the DRY RUN preview, sends nothing (2026-09-15).
        dry_run_cmd=["./.venv/bin/python", "src/iv_tg.py"],
        cwd="/AIWorkWSL/labs/quantum",
    ),
    "options_position_scorecard": dict(
        fleet="trading_command",
        owns=["option contracts on the relay universe", "relay x DP confluence tag"],
        never=["Alpaca positions"],
        cadence="15:40 ET Mon-Fri", cadence_min=24 * 60,
        # Round 4 (team-lead, 2026-09-15): re-derived from the live script. Alpaca
        # /v2/positions is gone — the script's own comment says it "replaces the
        # retired Alpaca /v2/positions." Confirmed via grep: RELAY_URL/DARKPOOL_URL
        # are the only two HTTP sources it reads.
        reads=[
            "http://localhost:3000/api/firebase-relay",
            "http://localhost:3000/api/darkpool?view=relay",
        ],
        # team-lead suggested `--dry-run`, but the script has NO argparse/flag parsing
        # at all (verified by reading it) — its only gate is `DRY = os.environ.get("DRY")
        # == "1"`, same pattern as shock_guard.py (round 2). Passing `--dry-run` as an
        # argv would be silently ignored and the script would run LIVE. Verified live:
        # `DRY=1 /home/itsju/.venv/bin/python .../options_position_scorecard.py` exits 0,
        # prints contract cards, no OneDrive write, no Telegram send (2026-09-15).
        dry_run_cmd=["/home/itsju/.venv/bin/python",
                     "/home/itsju/05_AUTOMATION/scripts/options_position_scorecard.py"],
        env={"DRY": "1"},
    ),
    "telegram_dm_responder": dict(
        fleet="flow_signals",
        owns=["answers from /api/decision?symbol= summary", "/api/mtf-ta read", "/api/news-snr"],
        never=["retired journal"],
        cadence="every minute (long-poll)", cadence_min=5,
        # Round 2 fix: /api/coach-gate is POST-only (route.ts defines no GET handler,
        # it needs a ticker+size body to do anything) — the checker's dead-upstream
        # probe is a plain GET, which correctly gets a 405 from a live, healthy route
        # and would FAIL forever on a false alarm. Dropped; /api/decision is the
        # meaningful GET-able freshness signal for this lane.
        reads=[
            "http://localhost:3000/api/decision?symbol=SPY",
        ],
        # Round 2: telegram_dm_responder.py now has `--dry-run` (sets DRY=1 internally,
        # which gates every reply-send branch — verified by reading the script: every
        # `_handle_*` reply path checks `os.environ.get("DRY") == "1"` and prints instead
        # of calling the Telegram API). It still does one real (non-mutating) getUpdates
        # long-poll with `timeout=0` to render anything — that's a read, not a send, and
        # the script never prints its own token. Verified live: exits 0, sends nothing
        # (2026-09-15).
        dry_run_cmd=["/usr/bin/python3",
                     "/AIWorkWSL/trading/signals/option-scraper/pipeline/digest/telegram_dm_responder.py",
                     "--dry-run"],
    ),
    "system_health": dict(
        fleet="system_health",
        owns=["DEAD / heal-failed / cron-failure alerts (gated)",
              "MISSING DATA alerts: every free source of a required input failed (market-data §3; "
              "missionctrl pipeline/decision/lib/missing_data.py, once per input per ET day)",
              "nightly check summary, report only (missionctrl pipeline/ops/nightly_check.py, 05:30 ET weekdays; "
              "Mike 2026-10-22)"],
        never=["routine OK pings"],
        cadence="06:45 ET daily", cadence_min=24 * 60,
        reads=[
            f"{_H}/LapClaw/pipeline/desk_pipeline.sqlite",
            f"{_H}/.openclaw/workspace/directives/freshness_audit_report.json",
        ],
        # data_freshness_auditor.py has no --dry-run yet (Group A sibling adding it).
        dry_run_cmd=["/usr/bin/python3",
                     f"{_H}/05_AUTOMATION/scripts/data_freshness_auditor.py", "--dry-run"],
    ),
    "app_notifiers": dict(
        # D7 landed 2026-09-15: chain_footprint.py now passes TG_FN=winmeals explicitly
        # instead of falling through to trading_command's default (tg_fleet.py FLEET gained
        # a dedicated "winmeals" entry — no token provisioned yet, Mike's call).
        fleet="winmeals",
        owns=["their own app's events (e.g. WinMeals promo/chain-footprint accuracy)"],
        never=["trading content"],
        cadence="08:35 ET Mon (chain_footprint.py --audit --notify)", cadence_min=7 * 24 * 60,
        reads=[
            "/AIWorkWSL/web/winmeals/engine/data",
        ],
        # chain_footprint.py has no --dry-run yet (Group B sibling adding it).
        dry_run_cmd=["./.venv/bin/python", "chain_footprint.py", "--audit", "--dry-run"],
        cwd="/AIWorkWSL/web/winmeals/engine",
    ),
}

VKEY = "telegram.{}".format  # vault key for a function


def _vault():
    con = sqlite3.connect(VAULT)
    con.execute("""CREATE TABLE IF NOT EXISTS secrets(key TEXT PRIMARY KEY, value TEXT NOT NULL,
                   category TEXT NOT NULL DEFAULT 'general', note TEXT,
                   created_at INTEGER DEFAULT (strftime('%s','now')),
                   updated_at INTEGER DEFAULT (strftime('%s','now')))""")
    return con


def _vget(con, key):
    row = con.execute("SELECT value FROM secrets WHERE key=?", (key,)).fetchone()
    return row[0].strip() if row else None


def _vput(con, key, val, note):
    con.execute("""INSERT INTO secrets(key,value,category,note) VALUES(?,?,'telegram',?)
                   ON CONFLICT(key) DO UPDATE SET value=excluded.value, note=excluded.note,
                   updated_at=strftime('%s','now')""", (key, val, note))
    con.commit()


def _src_token(con, src):
    kind, ref = src
    if kind == "file":
        p = os.path.join(SEC, ref)
        return open(p).read().strip() if os.path.exists(p) else None
    if kind == "vault":
        return _vget(con, ref)
    return None  # cloud → not local


def _getme(tok):
    try:
        r = json.load(urllib.request.urlopen(f"https://api.telegram.org/bot{tok}/getMe", timeout=8))
        return r["result"]["username"] if r.get("ok") else None
    except Exception:
        return None


# Lanes whose messages now land in another bot's chat (2026-09-28, Mike: "move best to
# trading command"). Applied on the SEND side only — send(), send_upload() and the `token`
# CLI verb that senders (lib/notify.tg_push, scoreboard_auditor, best3_*) resolve through —
# so registry/audit calls to token() still see each bot's own token. The alias bot stays
# registered (parked, token kept) — delete the alias to move a lane back.
ALIAS = {
    "flow_digest": "trading_command",   # best3 / flow pulse / flow picks / EOD scorecard
}


def route(fn):
    """The function whose bot actually delivers `fn`'s messages."""
    return ALIAS.get(fn, fn)


def token(fn):
    """The canonical token for a function. An explicit vault `src` wins (2026-10-22, MC-AUD-084: a lane
    moves to another bot by editing FLEET only, no vault rows copied); else vault telegram.<fn>, else src."""
    con = _vault()
    try:
        src = FLEET[fn]["src"]
        if src[0] == "vault":
            return _vget(con, src[1])
        return _vget(con, VKEY(fn)) or _src_token(con, src)
    finally:
        con.close()


def _tok_id(tok):
    head = tok.split(":", 1)[0] if tok and ":" in tok else ""
    return int(head) if head.isdigit() else None


def pinned_token(fn):
    """token(fn) only when its numeric bot id is the lane's BOT_ID pin; else None and a stderr note
    (no token text). Senders resolve through this, so a lane never posts as another bot."""
    tok = token(fn)
    if not tok:
        return None
    pin = BOT_ID.get(fn)
    if pin is not None and _tok_id(tok) != pin:
        print(f"{fn}: token is bot {_tok_id(tok)}, lane is pinned to {pin} — refused", file=sys.stderr)
        return None
    return tok


def lanes(out=print):
    """Every bot with the lanes on it (pinned id, kind, the id the token really carries). Returns
    the problems: a bot mixing trading with another kind, or a token that is not its pin."""
    bots, problems = {}, []
    for fn, d in FLEET.items():
        pin, real = BOT_ID.get(fn), _tok_id(token(fn))
        bots.setdefault(pin, []).append(fn)
        if pin is not None and real != pin:
            problems.append(f"{fn}: token is bot {real}, pin {pin}")
    for pin, fns in sorted(bots.items(), key=lambda kv: str(kv[0])):
        kinds = sorted({KIND.get(f, "?") for f in fns})
        users = sorted({FLEET[f]["user"] for f in fns})
        out(f"{str(pin):11} @{'/'.join(users):26} {','.join(kinds):16} {', '.join(fns)}")
        if "trading" in kinds and len(kinds) > 1:
            problems.append(f"bot {pin} mixes {'+'.join(kinds)}: {', '.join(fns)}")
    for fn, olds in MOVED.items():
        for o in olds:
            out(f"  moved: {fn} was on {o['bot_id']} @{o['user']} until {o['until']} ({o['why']})")
    for p in problems:
        out(f"PROBLEM {p}")
    if not problems:
        out("OK: every token matches its pin; no bot mixes trading with another kind")
    return problems


def harvest(write=False):
    con = _vault()
    try:
        for fn, m in FLEET.items():
            vkey = VKEY(fn)
            if _vget(con, vkey):
                print(f"  ✓ {fn:16} already in vault ({m['user']})")
                continue
            tok = _src_token(con, m["src"])
            if not tok:
                print(f"  … {fn:16} {'CLOUD — paste with: tg_fleet.py set '+fn+' <TOKEN>' if m['src'][0]=='cloud' else 'source missing: '+str(m['src'])}")
                continue
            if BOT_ID.get(fn) is not None and _tok_id(tok) != BOT_ID[fn]:
                print(f"  ✗ {fn:16} source token is bot {_tok_id(tok)}, pin {BOT_ID[fn]} — skipped")
                continue
            u = _getme(tok)
            if not u:
                print(f"  ✗ {fn:16} token DEAD via getMe ({m['src']})")
                continue
            if write:
                _vput(con, vkey, tok, f"@{u} · {m['role']}")
                print(f"  → {fn:16} vault[{vkey}] = @{u}")
            else:
                print(f"  • {fn:16} would migrate @{u} from {m['src']}")
    finally:
        con.close()


def set_token(fn, tok):
    if fn not in FLEET:
        print(f"unknown function '{fn}'. known: {', '.join(FLEET)}"); return
    if BOT_ID.get(fn) is not None and _tok_id(tok) != BOT_ID[fn]:
        print(f"that token is bot {_tok_id(tok)}, but {fn} is pinned to {BOT_ID[fn]} — not stored."); return
    u = _getme(tok)
    if not u:
        print("that token is DEAD via getMe — not stored."); return
    con = _vault()
    try:
        _vput(con, VKEY(fn), tok, f"@{u} · {FLEET[fn]['role']}")
        print(f"✓ {fn} → vault[{VKEY(fn)}] = @{u}")
    finally:
        con.close()


def _strip_html(msg):
    """Plain-text fallback for an HTML-mode message Telegram refused to parse."""
    import html as _html, re as _re
    return _html.unescape(_re.sub(r"</?(b|i|u|s|code|pre|a)(\s[^>]*)?>", "", msg))


def _ledger(fn, text, ok, html=False):
    """Passive send record (lib/tg_ledger.py) — never affects the send. (2026-09-28)"""
    try:
        sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
        from lib.tg_ledger import record
        record(fn, text, ok, html=html)
    except Exception:
        pass


def send(fn, msg, html=False):
    """Post `msg` to Mike's chat as `fn`. html=True → parse_mode=HTML (callers must escape
    dynamic text with tg_format.esc). If Telegram rejects the markup the message is re-sent
    as plain text with the tags stripped so a formatting slip never drops a trading ping.
    (2026-09-15 — Telegram message-format sweep.)"""
    fn = route(fn)
    if os.environ.get("TG_DRY_RUN") == "1":   # render only (MC-AUD-084): nothing sent, queued or recorded
        return _dry(fn, msg)
    try:   # FYI pushes fold into the next digest (lib/tg_digest.py) — 2026-09-28
        sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
        from lib.tg_digest import intercept
        if intercept(fn, msg, html):
            print("queued for digest (accepted; delivered at the next digest slot)")
            return 0
    except Exception:
        pass
    try:   # pre-send review (lib/tg_lint.py): hold exact repeats + broken renders, strip internal ids.
        from lib.tg_lint import review   # fail-open by design — 2026-10-08 TG audit
        reviewed, notes = review(fn, msg)
        if reviewed is None:
            print(f"held by pre-send review: {'; '.join(notes)}")
            return 0
        msg = reviewed
    except Exception:
        pass
    tok = pinned_token(fn)
    if not tok:
        print(f"no token for {fn}"); return 1
    chat = open(CHAT_FILE).read().strip()
    import urllib.parse
    def _post(text, mode):
        d = {"chat_id": chat, "text": text, "disable_web_page_preview": "true"}
        if mode:
            d["parse_mode"] = mode
        data = urllib.parse.urlencode(d).encode()
        try:
            return json.load(urllib.request.urlopen(f"https://api.telegram.org/bot{tok}/sendMessage", data=data, timeout=15))
        except urllib.error.HTTPError as e:  # Telegram returns 400 + JSON for parse errors
            try:
                return json.loads(e.read().decode())
            except Exception:
                return {"ok": False, "description": str(e)}
        except Exception as e:
            return {"ok": False, "description": str(e)}
    sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
    from lib.tg_split import chunks   # >4096 used to fail outright ("message is too long") — 2026-09-28
    ok, why = True, ""
    for part in chunks(msg):
        r = _post(part, "HTML" if html else None)
        if not r.get("ok") and html and "parse" in str(r.get("description", "")).lower():
            print(f"html rejected ({r.get('description')}) — resending plain")
            r = _post(_strip_html(part), None)
        if not r.get("ok"):
            ok, why = False, r.get("description")
    print("sent" if ok else f"fail: {why}")
    _ledger(fn, msg, ok, html)
    return 0 if ok else 1


def _dry(fn, msg):
    """TG_DRY_RUN=1: print the lane, its pinned bot and the text instead of posting (no token text)."""
    ok = bool(pinned_token(fn))
    print(f"DRY {fn} → bot {BOT_ID.get(fn)} @{FLEET[fn]['user']} ({KIND.get(fn)})"
          f"{'' if ok else ' — NO VALID TOKEN'}\n{msg}")
    return 0 if ok else 1


def _resolve(fn):
    """Return (token, label) without crossing fleet lanes."""
    tok = pinned_token(fn)
    if tok:
        return tok, fn
    return None, fn


def send_upload(fn, path, caption="", as_doc=False, html=False):
    """html=True → caption parsed as Telegram HTML (tg_format output); falls back to a
    stripped plain caption if Telegram rejects the markup (2026-09-16)."""
    if not os.path.exists(path):
        print(f"no such file: {path}"); return 1
    fn = route(fn)
    if os.environ.get("TG_DRY_RUN") == "1":
        return _dry(fn, f"[{os.path.basename(path)}] {caption}")
    tok, label = _resolve(fn)
    if not tok:
        print(f"no token for {fn}"); return 1
    chat = open(CHAT_FILE).read().strip()
    low = path.lower()
    if as_doc:
        method, field = "sendDocument", "document"
    elif low.endswith((".jpg", ".jpeg", ".png", ".webp", ".gif")):
        method, field = "sendPhoto", "photo"
    elif low.endswith((".mp4", ".mov", ".webm", ".mkv")):
        method, field = "sendVideo", "video"
    else:
        method, field = "sendDocument", "document"
    data = {"chat_id": chat}
    if caption:
        data["caption"] = caption
        if html:
            data["parse_mode"] = "HTML"
    with open(path, "rb") as fh:
        r = requests.post(f"https://api.telegram.org/bot{tok}/{method}",
                          data=data, files={field: fh}, timeout=90).json()
    if not r.get("ok") and html and "parse" in str(r.get("description", "")).lower():
        data.pop("parse_mode", None); data["caption"] = _strip_html(caption)
        with open(path, "rb") as fh:
            r = requests.post(f"https://api.telegram.org/bot{tok}/{method}",
                              data=data, files={field: fh}, timeout=90).json()
    _ledger(fn, f"[{method[4:].lower()} {os.path.basename(path)}] {caption}", r.get("ok"), html)
    if r.get("ok"):
        print(f"sent {os.path.basename(path)} → {label}"); return 0
    if method == "sendVideo":  # codec fallback
        with open(path, "rb") as fh:
            r = requests.post(f"https://api.telegram.org/bot{tok}/sendDocument",
                              data=data, files={"document": fh}, timeout=90).json()
        if r.get("ok"):
            print(f"sent {os.path.basename(path)} → {label} (as document)"); return 0
    print(f"fail: {r.get('description')}"); return 1


def _bot_id(fn: str) -> int | None:
    """Numeric bot id = the part of the vault token before ':' (public id, not the secret; MC-AUD-078).
    The token itself is never written or printed."""
    tok = token(fn)
    head = tok.split(":", 1)[0] if tok and ":" in tok else ""
    return int(head) if head.isdigit() else None


def manifest():
    m = {fn: {"username": d["user"], "bot_id": BOT_ID.get(fn), "token_bot_id": _bot_id(fn),
              "vault_key": d["src"][1] if d["src"][0] == "vault" else VKEY(fn), "avatar": d["avatar"],
              "role": d["role"], "kind": KIND.get(fn), "moved_from": MOVED.get(fn, [])} for fn, d in FLEET.items()}
    json.dump(m, open(MANIFEST, "w"), indent=2)
    print(f"wrote {MANIFEST} ({len(m)} bots)")


def status():
    con = _vault()
    try:
        print(f"{'function':16} {'role':12} {'username':26} in_vault  live")
        for fn, m in FLEET.items():
            inv = "yes" if _vget(con, VKEY(fn)) else "no"
            tok = token(fn)
            live = ("@" + _getme(tok)) if tok else "—"
            print(f"{fn:16} {m['role']:12} {m['user']:26} {inv:8} {live}")
    finally:
        con.close()


if __name__ == "__main__":
    a = sys.argv[1:]
    cmd = a[0] if a else "status"
    if cmd == "harvest":
        harvest(write="--write" in a)
    elif cmd == "set" and len(a) >= 3:
        set_token(a[1], a[2])
    elif cmd == "token" and len(a) >= 2:
        # print the vault-first resolved token for a function (for senders to centralize on)
        t = pinned_token(route(a[1]))   # senders resolve here → follow ALIAS; pinned bot id only
        if t:
            print(t)
        sys.exit(0 if t else 1)
    elif cmd == "send" and len(a) >= 3:
        sys.exit(send(a[1], " ".join(a[2:])))
    elif cmd == "sendhtml" and len(a) >= 3:          # HTML parse mode (tg_format.py output)
        sys.exit(send(a[1], " ".join(a[2:]), html=True))
    elif cmd == "sendfile" and len(a) >= 3:
        sys.exit(send_upload(a[1], a[2], a[3] if len(a) > 3 else "", as_doc=True))
    elif cmd == "sendmedia" and len(a) >= 3:
        sys.exit(send_upload(a[1], a[2], a[3] if len(a) > 3 else ""))
    elif cmd == "sendmediahtml" and len(a) >= 3:     # HTML caption (tg_format.py output)
        sys.exit(send_upload(a[1], a[2], a[3] if len(a) > 3 else "", html=True))
    elif cmd == "manifest":
        manifest()
    elif cmd == "lanes":                             # every bot + its lanes; exit 1 on a mix/mismatch
        sys.exit(1 if lanes() else 0)
    else:
        status()
