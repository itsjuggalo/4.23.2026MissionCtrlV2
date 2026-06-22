# Archived dead FlowGreeks/signal bots — 2026-06-22

Moved here by the FlowGreeks bot-mapping deep-dive (`~/restructure/FLOWGREEKS-BOT-MAP.md`).
All 11 files were verified **dead** at archive time: NOT in `pm2 jlist`, NOT in `crontab -l`,
NOT in `~/restructure/ecosystem.config.js`, NO live Python importers, NO shell/wrapper callers.
They are abandoned scanner experiments / superseded feeders. Nothing live changed by moving them.

## Files
| Original path | What it was |
|---|---|
| scanners/gamma_squeeze_py | gamma-squeeze scanner → #TradeFlow wh 1497661681126609008 (never scheduled) |
| scanners/pre_pop_py | pre-pop scanner, same dead #TradeFlow webhook |
| scanners/congress_catalyst_py | congress-catalyst scanner, same |
| scanners/multi_feed_overlap_py | multi-feed overlap scanner, same |
| scanners/earnings_catalyst_py | earnings-catalyst scanner, same |
| scanners/eod_decay_py | EOD theta-decay scanner, same |
| scanners/premarket_gap_py | premarket-gap scanner, same |
| option-watcher/watcher_py | standalone option watcher (while-True loop), #TradeFlow, never scheduled |
| squeeze-scanner/squeeze_scanner.py | squeeze-alerts feeder (only true hardcoded channel-id 1498022103906254879), dead |
| deepseek_flow_observer.py | legacy DeepSeek flow observer, no pm2/cron |
| best-options-logger/best_options_poster.py | legacy best-options poster, no pm2/cron, no importers |

## Held back (NOT archived — need manual review)
- `contract_tracker.py` — name referenced by live missionctrl code (trade_ledger_build / score_optimizer / outcome_writer); inspect before touching.
- `briefs_to_discord.py` — has a `deploy_briefs.sh` companion; may be part of a deploy flow.
- `scanners/signature_miner_py` + `signature_miner_v2_py` — not in the verified-dead set.

## Restore
`cd ~/05_AUTOMATION/scripts && mv _ARCHIVE_DEAD_FLOWBOTS_20260622/<subpath> <subpath>`
(e.g. `mv _ARCHIVE_DEAD_FLOWBOTS_20260622/scanners/gamma_squeeze_py scanners/`)
