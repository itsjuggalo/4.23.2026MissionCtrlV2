<!--
  Shape source: ~/templates/context-quartet/agents.md (Kashef Context Engineering).
  This dir is a SCRIPT BAG, not an agent runtime. AGENTS.md exists to set the safety rules for any sub-agent that opens this tree.
-->

# AGENTS — scripts

No persistent sub-agents. This is Mike's flat script bag (~138 files). Loaded by Claude Code only when a specific task asks for it.

## Spawning rules

- Any sub-agent invoked here MUST: confirm it's editing a laptop script before writing. Some scripts have HISTORICAL Oracle counterparts at `/home/ubuntu/scripts/` (laptop-only since the 2026-06-30 cutover).
- For tasks touching `alpaca_*.py`: paper keys only, never live. Account IDs in `~/LapClaw/MEMORY.md`.
- For tasks touching `ainvest_*`: see `~/.claude/projects/-home-itsju/memory/reference-ainvest-api.md` first.

## Authority limits

- Never deploy a script to Oracle (trading side retired 2026-06-30; comms bots there are Oracle-owned).
- Don't reorganize the script layout — many are referenced by laptop cron entries (and legacy Oracle configs) by exact path.
