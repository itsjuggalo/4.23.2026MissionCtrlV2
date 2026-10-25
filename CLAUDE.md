<!-- Updated 2026-10-24 (audit T9/T26): production description, fleet pointers, dead memory/template pointers removed. -->

@AGENTS.md

<!-- Trading rules (level 1b): this tree sits outside /AIWorkWSL, so the parent .claude/rules do not auto-load here (verified 2026-10-20). -->
@/AIWorkWSL/.claude/rules/market-data.md
@/AIWorkWSL/.claude/rules/script-standards.md

# scripts — Mike's operator script tree (PRODUCTION, not a loose bag)

`~/scripts` is a symlink to `/home/itsju/05_AUTOMATION/scripts`. At 2026-10-24 it holds 356 entries (212 `.py`). 9 PM2 apps run from it and 107 active cron lines call into it by path, so **never move or rename files here**. Git: branch `master`, remote `origin` = `itsjuggalo/4.23.2026MissionCtrlV2`, which is a **PUBLIC** repo. Scan the outgoing diff for secrets before any push (count matches, never print them); script-standards §1.

## What lives here
- **Telegram / Discord fleet (production).** Roster, bot ids, lanes and charters: `tg_fleet.py` (`python3 tg_fleet.py lanes` prints it; dry-run commands per lane are in the same file). Human view and ownership: MissionCtrl `AGENTS.md` §7 "Telegram/Discord bot ownership (effective 2026-10-24)". Sends go only through `tg_fleet` with `lib/tg_ledger.py` and `lib/tg_lint.py` (script-standards §6); `lib/tg_digest.py` handles digests. Do not restate a roster in any doc.
- **PM2 apps that run from this tree** (verified against `pm2 jlist` 2026-10-24): `aime-discord` (`aime_discord_bot.py`), `antigravity-aime` (`antigravity_aime_bot.py`), `lifeclaw-bot` (`lifeclaw_bot.py`), `tg-gateway` (`tg_responder.py`), `discord-user-listener`, `discord-reactor`, `firebase-signal-relay` (`firebase_signal_relay.py`; the protected relay dir `~/firebase-signals` is separate and is never edited from here), `quiz-bot` (`quiz_bot.py`), `lane-bots` (`lane_bots.py`).
- **Price path.** `price_guard.py` path-loads MissionCtrl's `pipeline/decision/lib/quote_client.py`; every sender checks a price through it (Robinhood first, Yahoo labelled). `lib/rh_quote.py` is the read-only Robinhood quote helper.
- **Ops and docs upkeep.** `infra_sentinel.sh` (self-heal, kill switch in SYSTEM-MAP), `md_freshness.py` (weekly doc refresh), `tests/` (offline checks, e.g. `math_parity_guard.py`).
- Other: `ainvest_*` (AInvest scrapers and cookie probes), `askgrok_bot.py`, `agent_health.py`, `activity_logger.py`, `audit_log_writer.py`, `alt-signals/` (experiments), `quantum_premarket.py` / `quantum_eod.py` (Telegram cards that sit beside `/AIWorkWSL/labs/quantum`), `_linear_inventory.txt`.
- **RETIRED, history only (never revive):** `alpaca_*` helpers (`alpaca_fill_listener.py`, `alpaca_archive_py/`, `alpaca_history_writer_py/`; the Alpaca book was retired 2026-08-11). Files archived 2026-10-23 are listed in `/AIWorkWSL/archive/2026-10-23-retired/README.md`.

## Where facts live (replaces the old memory pointers, which no longer exist)
- Paths, ports, PM2, cron-edit safety: `~/SYSTEM-MAP.md`. MissionCtrl paths: `/AIWorkWSL/web/missionctrl/CLAUDE.md`.
- Credentials: the secrets stores only (`~/.config/mc-secrets/secrets.sqlite`, `~/.openclaw/secrets/`, `.env`; `~/scripts/keys/` when present; script-standards §9). Never in argv, URLs, logs or docs.

## Defaults / conventions
- Python uses the operator's system `python3` (or `~/.venv`, `~/mc-kb/.venv` where a cron line says so) — most scripts have no venv. Check imports first.
- Alpaca is **not a price source** (Robinhood first, Yahoo labelled fallback). Alpaca market data (bars, news) stays only where no free replacement exists yet, labelled as a cross-check. Never add Alpaca order, position or account calls. Mike trades on Robinhood and Coinbase himself.
- Oracle is retired (dead since 2026-07-10). Never deploy to it or SSH to it. Everything runs on the laptop.
- This directory is not auto-loaded as session context. It is not a bag of loose scripts to run by hand: check `crontab -l` and `pm2 list` before touching or running any file, because a send can reach Telegram, Discord or SMS.
