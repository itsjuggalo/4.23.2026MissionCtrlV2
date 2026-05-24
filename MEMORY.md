<!--
  Shape source: ~/templates/context-quartet/memory.md (Kashef Context Engineering).
-->

# MEMORY — MissionCtrlV2 (active local dashboard)

Durable facts about this dashboard. Operator memory lives at `~/.claude/projects/-home-itsju/memory/`.

## Persistent state

- **Port:** 3000 (dev). `npm run dev` from this dir.
- **Framework:** Next.js 16.2.1, App Router. Tailwind. TypeScript.
- **Env:** `.env.local` — must contain `BRIDGE_URL=https://bridge.serveftp.com` and `BRIDGE_TOKEN=<bearer>`.
- **Routing:** `src/components/layout/Sidebar.tsx` (nav), `src/components/layout/AppShellClient.tsx` (page mux).

## API routes (this app exposes)

| Route | Backs | Notes |
|---|---|---|
| `/api/flow-database/*` | Oracle `options_flow.sqlite` via bridge | Bearer token from `.env.local` |
| `/api/itb` | `~/LapClaw/intelligent-trading-bot/` | Local read |
| `/api/freqtrade` | `~/LapClaw/freqtrade/` + FreqUI :8080 | Local read |

## Scheduled jobs

None inside this app. Cron / PM2 lives on Oracle. This is a UI-only dashboard.

## Don't break

- **`/api/flow-database/*` is READ-ONLY.** Never wire it for writes — flow data writes go through Oracle's `alpaca_history_writer_py`.
- The `.env.local` bearer token rotates when bridge.serveftp.com cert rolls — if API 401s, check token first.
- When the user says "the dashboard", they mean THIS app (port 3000), not Oracle's `mission-control` PM2 (port 3033).
