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
  tg_fleet.py token <function>            # print the vault-first resolved token (for senders)
  tg_fleet.py set <function> <TOKEN>      # fold in a cloud-only bot (Gamma/CHANGE NOW/BobaClaw)
"""
import json
import os
import sqlite3
import sys
import urllib.parse
import urllib.request

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
    "aime_research":   dict(user="AntiGravityg59laptop_Bot",avatar="zeratul",         role="interactive", src=("file", "telegram_antigravity_bot_token")),
    "x_sentiment":     dict(user="MoneyFlowz_Bot",          avatar="mutalisk",        role="interactive", src=("file", "telegram_grok_bot_token")),
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
    "screener":        dict(user="TrndRsrch_Bot",           avatar="wraith",          role="interactive", src=("file", "telegram_deepseek_bot_token")),
    "macro_regime":    dict(user="MMCTRL727_Bot",           avatar="mengsk",          role="interactive", src=("file", "telegram_mc_skill_bot_token")),
    # ── push (they alert you) ───────────────────────────────────────────────
    "flow_signals":    dict(user="PipelineSignals_Bot",     avatar="queen_of_blades", role="push",        src=("file", "telegram-bot-token.txt")),
    "flow_digest":     dict(user="Boba2Telegram_Bot",       avatar="hydralisk",       role="push",        src=("vault", "telegram_boba2_bot_token")),
    "daily_briefs":    dict(user="SpaceCoast_Claude_Bot",   avatar="ghost",           role="push",        src=("cloud", None)),
    # ── media (off the trade chats) ─────────────────────────────────────────
    "media_gens":      dict(user="JazzyHazzyTelegram_Bot",  avatar="fenix",           role="push",        src=("cloud", None)),
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
    "winmeals":        dict(user="Deepseeker_Bot",           avatar="medic",           role="push",        src=("vault", "telegram.trend_scanner")),
    # ── infra (not chat targets) ────────────────────────────────────────────
    "hermes_relay":    dict(user="Gumroadie_bot",           avatar="dragoon",         role="infra",       src=("vault", "telegram_hermes_bot_token")),
    "openclaw_grok":   dict(user="OpenclawGrok727_Bot",     avatar="ghost",           role="infra",       src=("vault", "telegram_openclaw_bot_token")),
    # laptop_control = RESERVED slot for a Telegram-channel gateway (tg-channel). Channel deferred
    # 2026-06-21: Mike at the 20-bot BotFather cap + phone-hub (Remote Control) already covers phone
    # control. Activate only if a bot slot frees: free a slot → BotFather /newbot → drop the token in
    # ~/.openclaw/secrets/telegram_phone_channel_bot_token → tg-channel. See [[reference_phone_remote_control]].
    "laptop_control":  dict(user="(reserved — no bot; cap reached)", avatar="battlecruiser", role="infra", src=("file", "telegram_phone_channel_bot_token")),
    # (spare_backup / @BobaClaw removed 2026-06-21 — phantom: no real BotFather bot existed; all 20 slots are live.)
    # ── reserve pool (Mike's spare bots, folded in 2026-06-16 — named + rebranded, persona-ready) ──
    "jazzy_relay":     dict(user="JazzyHazzy_Bot",          avatar="zealot",          role="spare",       src=("cloud", None)),
    "orion_relay":     dict(user="oOrionz_Bot",             avatar="kerrigan",        role="spare",       src=("cloud", None)),
    "grok_scout":      dict(user="Grootk_Bot",              avatar="goliath",         role="spare",       src=("cloud", None)),
    # retired→winmeals 2026-09-15: confirmed idle (crontab line commented out, no live
    # sender referenced it) — its vault token (telegram.trend_scanner) is now also
    # reachable as the "winmeals" fleet fn above (same underlying vault row, not
    # duplicated). Left resolvable here too so nothing that still names "trend_scanner"
    # (reserve_persona_push.py, bot_rebrand.py, tg_responder.py's DM menu) breaks — just
    # don't route new content at it under this name.
    "trend_scanner":   dict(user="Deepseeker_Bot",          avatar="firebat",         role="spare",       src=("cloud", None)),
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
        dry_run_cmd=[f"{_H}/.venv/bin/python",
                     f"{_H}/05_AUTOMATION/scripts/morning_command.py", "--dry-run"],
    ),
    "setup_sms": dict(
        fleet="trading_command",
        owns=["premarket/opening setups", "MTF glyph", "rebound state", "$400 flat-cap sizing"],
        never=["regime narrative", "grades"],
        cadence="08:20/09:12/09:50 + :10,:30,:50 10-15 ET Mon-Fri + weekend --crypto",
        cadence_min=20,
        # Round 2 (2026-09-15): D3 landed — setup_scanner.py no longer calls the dead
        # /api/portfolio-rh route (imports risk_cap.py's flat $400 cap instead — a code
        # import, not a freshness-checkable "read"). It now reads MTF/rebound state
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
        cadence_min=60,
        # Round 2: D3 landed here too (dead /api/portfolio-rh call deleted, risk_cap.py
        # import instead). explosion_score.py also imports mtf_rebound as mr. No
        # `data/explosion_score_floor.json` file exists (checked) — its score floor is
        # computed at runtime from the signal_outcomes log and printed, not persisted to
        # a path worth freshness-checking; dropped the runner_radar.log guess too (not
        # actually read as an input by explosion_score.py — verified via grep).
        reads=[
            "http://localhost:3000/api/mtf-ta?symbol=SPY",
            "http://localhost:3000/api/rebound-setup?symbol=SPY",
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
        reads=[
            "http://localhost:3000/api/pullback-watch?fresh=1",
            "http://localhost:3000/api/options-flow",
        ],
        dry_run_cmd=None,  # not in this pass's D-fix list; no --dry-run flag exists
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
        cadence="10:05 card + :10,:30,:50 10-15 ET override + 16:20 grader Mon-Fri",
        cadence_min=20,
        reads=[
            "/AIWorkWSL/trading/signals/option-scraper/data/best3.log",
            "/AIWorkWSL/trading/signals/option-scraper/data/best3_scoreboard.json",
        ],
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
        reads=[
            "https://paper-api.alpaca.markets/v2/positions",  # doctrine-flagged, fleet-a Lane 13
        ],
        dry_run_cmd=None,  # not in this pass's D-fix list; no --dry-run flag exists
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
        owns=["DEAD / heal-failed / cron-failure alerts (gated)"],
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


def token(fn):
    """The canonical token for a function — vault first, else its source (pre-migration)."""
    con = _vault()
    try:
        return _vget(con, VKEY(fn)) or _src_token(con, FLEET[fn]["src"])
    finally:
        con.close()


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
    u = _getme(tok)
    if not u:
        print("that token is DEAD via getMe — not stored."); return
    con = _vault()
    try:
        _vput(con, VKEY(fn), tok, f"@{u} · {FLEET[fn]['role']}")
        print(f"✓ {fn} → vault[{VKEY(fn)}] = @{u}")
    finally:
        con.close()


def send(fn, msg):
    tok = token(fn)
    if not tok:
        print(f"no token for {fn}"); return 1
    chat = open(CHAT_FILE).read().strip()
    import urllib.parse
    data = urllib.parse.urlencode({"chat_id": chat, "text": msg,
                                   "disable_web_page_preview": "true"}).encode()
    try:
        r = json.load(urllib.request.urlopen(f"https://api.telegram.org/bot{tok}/sendMessage", data=data, timeout=15))
        print("sent" if r.get("ok") else f"fail: {r.get('description')}")
        return 0 if r.get("ok") else 1
    except Exception as e:
        print(f"send error: {e}"); return 1


def _resolve(fn):
    """Return (token, label) without crossing fleet lanes."""
    tok = token(fn)
    if tok:
        return tok, fn
    return None, fn


def send_upload(fn, path, caption="", as_doc=False):
    if not os.path.exists(path):
        print(f"no such file: {path}"); return 1
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
    with open(path, "rb") as fh:
        r = requests.post(f"https://api.telegram.org/bot{tok}/{method}",
                          data=data, files={field: fh}, timeout=90).json()
    if r.get("ok"):
        print(f"sent {os.path.basename(path)} → {label}"); return 0
    if method == "sendVideo":  # codec fallback
        with open(path, "rb") as fh:
            r = requests.post(f"https://api.telegram.org/bot{tok}/sendDocument",
                              data=data, files={"document": fh}, timeout=90).json()
        if r.get("ok"):
            print(f"sent {os.path.basename(path)} → {label} (as document)"); return 0
    print(f"fail: {r.get('description')}"); return 1


def manifest():
    m = {fn: {"username": d["user"], "vault_key": VKEY(fn), "avatar": d["avatar"],
              "role": d["role"]} for fn, d in FLEET.items()}
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
        t = token(a[1])
        if t:
            print(t)
        sys.exit(0 if t else 1)
    elif cmd == "send" and len(a) >= 3:
        sys.exit(send(a[1], " ".join(a[2:])))
    elif cmd == "sendfile" and len(a) >= 3:
        sys.exit(send_upload(a[1], a[2], a[3] if len(a) > 3 else "", as_doc=True))
    elif cmd == "sendmedia" and len(a) >= 3:
        sys.exit(send_upload(a[1], a[2], a[3] if len(a) > 3 else ""))
    elif cmd == "manifest":
        manifest()
    else:
        status()
