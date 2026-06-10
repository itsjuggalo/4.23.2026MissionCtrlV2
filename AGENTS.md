<!--
  Shape source: ~/templates/context-quartet/agents.md (Kashef Context Engineering).
  This dir is a SCRIPT BAG, not an agent runtime. AGENTS.md exists to set the safety rules for any sub-agent that opens this tree.
-->

# AGENTS — scripts

No persistent sub-agents. This is Mike's flat script bag (~138 files). Loaded by Claude Code only when a specific task asks for it.

## Spawning rules

- Any sub-agent invoked here MUST: confirm it's editing a laptop script (not a deployed Oracle twin) before writing. Many scripts have an Oracle counterpart at `/home/ubuntu/scripts/`.
- For tasks touching `alpaca_*.py`: paper keys only, never live. Account IDs in `~/LapClaw/MEMORY.md`.
- For tasks touching `ainvest_*`: see `~/.claude/projects/-home-itsju/memory/reference-ainvest-api.md` first.

## Authority limits

- Never deploy a script to Oracle without explicit operator confirm.
- Don't reorganize the script layout — many are referenced by Oracle PM2 configs and cron entries by exact path.
