<!--
  Shape source: ~/templates/context-quartet/agents.md (Kashef Context Engineering).
  This dir is a SCRIPT BAG, not an agent runtime. AGENTS.md exists to set the safety rules for any sub-agent that opens this tree.
-->

# AGENTS — scripts

No persistent sub-agents. This is Mike's flat script bag (~138 files). Loaded by Claude Code only when a specific task asks for it.

## Spawning rules

- Any sub-agent invoked here MUST confirm it's editing a laptop script before writing. Oracle is retired (dead since 2026-07-10).
- `alpaca_*.py` are retired Alpaca-book helpers (the book was retired 2026-08-11). Don't revive them or wire order/account calls. Alpaca is market data only.
- For tasks touching `ainvest_*`: see `~/.claude/projects/-home-itsju/memory/reference-ainvest-api.md` first.

## Authority limits

- Never deploy a script to Oracle, which is retired.
- Don't reorganize the script layout. Many scripts are referenced by exact path from laptop cron entries.
- No agent places trades. Trade ideas become advisory tickets (`@executor`), and Mike executes them himself.
