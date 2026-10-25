<!-- Updated 2026-10-24 (audit T9/T26). This dir is production scripts, not an agent runtime. AGENTS.md sets the safety rules for any sub-agent that opens this tree. -->

# AGENTS — scripts

No persistent sub-agents of its own, but this tree is production: 9 PM2 apps and about a hundred cron lines run from it (details in `CLAUDE.md`). Bot and lane ownership: MissionCtrl `AGENTS.md` §7 "Telegram/Discord bot ownership (effective 2026-10-24)" and `tg_fleet.py lanes`. Not restated here.

## Spawning rules

- Any sub-agent invoked here MUST confirm it is editing a laptop script before writing. Oracle is retired (dead since 2026-07-10).
- `alpaca_*.py` are retired Alpaca-book helpers (the book was retired 2026-08-11). Don't revive them or wire order/account calls. Alpaca is not a price source.
- For tasks touching `ainvest_*`: read the script header and the MissionCtrl `DATA_SOURCES.md` AInvest rows first; the old memory note is gone. Credentials come from the secrets stores only (`script-standards.md` §9).
- Before sending anything: use the lane's dry-run command from `tg_fleet.py`. Real test sends are not allowed (script-standards §7).

## Authority limits

- Never deploy a script to Oracle, which is retired.
- Don't reorganize the script layout. Many scripts are referenced by exact path from laptop cron entries and PM2.
- The remote is PUBLIC. Scan outgoing diffs for secrets (count matches, never print) before any push, and never push from an automated task.
- No agent places trades. Trade ideas become advisory tickets (`@executor`), and Mike executes them himself.
