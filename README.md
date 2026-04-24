# 4.23.2026 Mission Control V2 Full Backup

Full server snapshot from Oracle Cloud Ubuntu (132.145.205.15) on 2026-04-23.

## Contents

- `mission-control-restored/` — Active Next.js dashboard (PM2 id 3, port 3033). Primary working dir.
- `mission-control/` — Multi-agent Python bots: signal-receiver, flow-monitor, telegram-listener, analyst, risk-manager, portfolio-monitor, auditor, broadcaster, counter-intelligence, execution-specialist, macro-strategist.
- `mission-control-official/` — Builderz Labs fork (upstream: builderz-labs/mission-control). Code only (no node_modules/.next).
- `.openclaw/` — OpenClaw (Claude Code) install: skills, secrets, workspace, memory, brief history.
- `coupon-claw/` — CouponClaw scraper + monitor bots (Shopify cart validation, Playwright stealth).
- `Option-Signals-Scraper/` — Options flow alert scraper data.
- `.ssh/` — SSH keys/config.
- `_system_state/` — PM2 dump, crontab, nginx config, systemd units, installed packages, tool versions.

## PM2 Processes (from pm2_jlist.json)

mission-control (dashboard), signal-receiver, flow-monitor, telegram-listener, telegram-discord-relay, firebase-signal-relay, brief-forwarder, deepseek-bot, grok-bot, spacer-bot, watchlist-editor-bot, coupon-claw, coupon-monitor, option-signals, option-signals-restored, skill-scheduler.

## Restore procedure

1. `rsync -a <this-dir>/ ~/` (preserving hidden dirs)
2. In each Node dir: `npm install`
3. Python venvs: recreate + `pip install -r requirements.txt`
4. `pm2 resurrect` from `_system_state/pm2_dump.pm2`
5. `crontab _system_state/crontab.txt`
6. Copy `_system_state/nginx_etc` → `/etc/nginx/`, `systemctl reload nginx`
