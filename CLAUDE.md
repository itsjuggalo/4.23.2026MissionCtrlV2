<!--
  Shape source: ~/templates/context-quartet/claude.md (Kashef Context Engineering).
-->

@AGENTS.md

<!-- Trading rules (level 1b): this tree sits outside /AIWorkWSL, so the parent .claude/rules do not auto-load here (verified 2026-10-20). -->
@/AIWorkWSL/.claude/rules/market-data.md
@/AIWorkWSL/.claude/rules/script-standards.md

# scripts — Mike's operator script collection (~206 files)

Loose collection of Python + shell scripts spanning trading utilities, scrapers, log writers, AInvest probes, alpaca helpers, agent-health checks, and dev tooling. Tracked under its own git remote (`itsjuggalo/4.23.2026MissionCtrlV2`).

## What lives here

- `alpaca_*` — RETIRED Alpaca-book helpers (fill listener, archive, history writer); the Alpaca book was retired on 2026-08-11. Historical only, so don't revive them.
- `ainvest_*` — AInvest scrapers + cookie probes
- `askgrok_bot.py`, agent_health.py, activity_logger.py, audit_log_writer.py — utility daemons
- `alt-signals/` — alternative signal source experiments
- `alpaca_history_writer_py/`, `alpaca_archive_py/` — write-path workers for the SQL DB
- `_linear_inventory.txt` — Linear project inventory snapshot

## Knowledge lookups

- `~/.claude/projects/-home-itsju/memory/reference-mission-control-paths.md`
- `~/.claude/projects/-home-itsju/memory/reference-llm-api-keys.md` for key locations

## Defaults / conventions

- Python uses operator's system `python3` — most scripts have no venv. Check imports first.
- Alpaca is a **market-data feed only**: bars, quotes and news. Never add Alpaca order, position or account calls, because Alpaca trading is retired. Mike trades on Robinhood and Coinbase himself.
- Oracle is retired (dead since 2026-07-10). Never deploy to it or SSH to it. Everything runs on the laptop.
- This dir is NOT auto-loaded by anything — invoke scripts individually.
