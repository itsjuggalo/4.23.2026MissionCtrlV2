<!--
  Shape source: ~/templates/context-quartet/claude.md (Kashef Context Engineering).
-->

@AGENTS.md

# scripts — Mike's operator script collection (~206 files)

Loose collection of Python + shell scripts spanning trading utilities, scrapers, log writers, AInvest probes, alpaca helpers, agent-health checks, and dev tooling. Tracked under its own git remote (`itsjuggalo/4.23.2026MissionCtrlV2`).

## What lives here

- `alpaca_*` — Alpaca paper account helpers (fill listener, archive, history writer)
- `ainvest_*` — AInvest scrapers + cookie probes
- `askgrok_bot.py`, agent_health.py, activity_logger.py, audit_log_writer.py — utility daemons
- `alt-signals/` — alternative signal source experiments
- `alpaca_history_writer_py/`, `alpaca_archive_py/` — write-path workers for the SQL DB
- `_linear_inventory.txt` — Linear project inventory snapshot

## Knowledge lookups

- `~/.claude/projects/-home-itsju/memory/reference-prod-deployment.md` — many scripts here mirror what runs on Oracle
- `~/.claude/projects/-home-itsju/memory/reference-mission-control-paths.md`
- `~/.claude/projects/-home-itsju/memory/reference-llm-api-keys.md` for key locations

## Defaults / conventions

- Python uses operator's system `python3` — most scripts have no venv. Check imports first.
- Scripts hitting Alpaca always use **paper** keys. Live keys exist but never wired here.
- Many scripts have an Oracle twin at `/home/ubuntu/scripts/` (deploy via scp).
- This dir is NOT auto-loaded by anything — invoke scripts individually.
