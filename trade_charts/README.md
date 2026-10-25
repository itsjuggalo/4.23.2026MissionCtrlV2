# trade_charts — chart cards for Discord and Telegram

Ten chart generators plus three shared modules. Each run renders PNG cards and posts them to a Discord channel (SynthControl
bot) and to Telegram. They advise only; nothing here places or sizes a trade. Rules that apply here and are not repeated:
`/AIWorkWSL/.claude/rules/market-data.md` (price truth, source + as_of) and `script-standards.md` (the script standard).
Every scheduled line is also a row in MissionCtrl's generated process index (`/AIWorkWSL/web/missionctrl/OPERATIONS.md` §12).
Verified 2026-10-24 23:12 ET against `crontab -l` and the source.

**This repo (`~/scripts`) has a PUBLIC remote.** No webhook, token or chat id goes in this folder. Secrets come from
`~/.openclaw/secrets/` (deliver.py reads the SynthControl bot token there).

## Scheduled (cron, ET, Mon–Fri)

All lines run `cd ~/05_AUTOMATION/scripts/trade_charts && ~/.venv/bin/python <script>` and append to
`~/.openclaw/workspace/logs/trade_charts.log`. Find them with `crontab -l | grep -n trade_charts/`.

| Script | Schedule | Discord channel (default `--channel`) | Reads |
|---|---|---|---|
| `max_pain.py` | 09:35 | `gamma-levels` | Yahoo chains (yfinance), flow stream for `--from-flow` names |
| `earnings_em.py` | 09:40 | `earnings-radar` | Yahoo chains + earnings history, flow stream for ticker names |
| `market_boards.py` | 09:44, 15:50 | `market-regime` | flow stream, Yahoo `^VIX*`, `iv_history.json` |
| `flow_ta_cards.py --top 6` | 09:50, 12:30, 15:45 | `ta-charts` | flow stream, Yahoo bars |
| `straddle_cards.py --from-flow --top 4` | 09:55 | `straddle-cards` | flow stream, Yahoo chains |
| `repeat_flow.py` | 10:00, 14:30 | `ta-charts` | flow stream |
| `gex_chart.py SPY QQQ IWM` | 10:05 | `gamma-levels` | Yahoo chains; when its own sweep finds no gamma flip, the flip from the `pipeline/gex` owner (`factors/gex.json`, only within its max age) |
| `breadth.py` | 10:30 | `market-regime` | Yahoo bars for a fixed ~40-name basket |
| `volume_profile.py --from-flow --top 3` | 11:30 | `ta-charts` | flow stream, Yahoo bars |

"Flow stream" = `/AIWorkWSL/trading/signals/option-scraper/data/flow_alerts_today.json`, read-only (never write it).

Not scheduled: `networth.py`. It is a net-worth / holdings view, and those views were retired 2026-09-12. Do not schedule it.

## Shared modules

- `deliver.py`: `post_chart()` posts one PNG to Discord (channel resolved by name in the guild) and to Telegram as a photo
  through `~/bin/tg-send-media` with `TG_FN=trading_command` (routed by `~/scripts/tg_fleet.py`); `post_album_tg()` sends a
  multi-chart run as one Telegram album (`tg_fleet.send_album`). Bot per fn: MissionCtrl AGENTS §7.
- `chartlib.py`: dark-theme rendering and yfinance OHLCV. PNGs go to `~/.openclaw/workspace/charts/`.
- `spotsrc.py`: the card's spot price through `~/scripts/price_guard.py` (Robinhood first, Yahoo labelled "not Robinhood");
  a stale or missing spot returns `(None, reason)` so the card fails closed. Used by `flow_ta_cards`, `max_pain` and
  `straddle_cards`.

## State files

| File | Writer | Note |
|---|---|---|
| `~/.openclaw/flow_ta_cards_state.json` | `flow_ta_cards.py` | last card key per ticker (skips repeats); not written under `--dry` |
| `~/.openclaw/repeat_flow_state.json` | `repeat_flow.py` | date the legend was last sent; not written under `--dry` |
| `~/.openclaw/workspace/charts/iv_history.json` | `straddle_cards.py` | daily ATM IV per ticker (last 300), feeds IV rank; **written even under `--dry`** |

## Check and test (WSL bash)

Every generator takes `--dry`: it renders the PNG and prints the caption, and posts nothing.

```bash
cd ~/05_AUTOMATION/scripts/trade_charts
~/.venv/bin/python gex_chart.py SPY --dry
tail -50 ~/.openclaw/workspace/logs/trade_charts.log
```

Sends land in the Telegram ledger (`~/.local/state/tg-ledger.sqlite`, table `sends`, column `source` = script name).

## Known gaps (found 2026-10-24, not fixed here)

- No heartbeat and no freshness-registry row for any of the 13 lines (script-standards rule 5), so a failed run is seen
  only in the log.
- Only `gex_chart` has a test (`~/scripts/tests/test_gex_owner_flip.py`); rule 7 asks for a dry-run render test per sender.
- `earnings_em.py` and `volume_profile.py` take spot from the last Yahoo daily close, not through `spotsrc.py`;
  `gex_chart.py` does too but labels it "Yahoo daily bar …, not Robinhood" (rule 2).
- Chains come from yfinance `option_chain`; market-data.md §4 lists CBOE delayed chains for chains and one GEX owner.
