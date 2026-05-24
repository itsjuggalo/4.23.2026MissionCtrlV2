<!-- Shape source: ~/templates/context-quartet/claude.md (Kashef Context Engineering). -->

@AGENTS.md

# MissionCtrlV2 — Active Local Dashboard (port 3000)

This is the **canonical local-host dashboard** for Mission Control. Replaces missionctrl.serveftp.com (Oracle), which is now stale.

## Running

```bash
cd ~/sites/missioncontrol/MissionCtrlV2
npm run dev    # port 3000
```

## Key facts

- **Next.js 16.2.1** — App Router. See AGENTS.md and `node_modules/next/dist/docs/` for current API surface (do NOT assume training-data Next.js patterns work).
- **Env**: `.env.local` holds `BRIDGE_URL=https://bridge.serveftp.com` and `BRIDGE_TOKEN=...` for the Flow Database API proxy.
- **Flow Database page** (in `src/components/pages/FlowDatabasePage.tsx`) reads `/api/flow-database/*` which proxies to bridge.serveftp.com/db/* on Oracle.
- **Sidebar nav** in `src/components/layout/Sidebar.tsx`; page routing in `src/components/layout/AppShellClient.tsx`.

## Knowledge lookups

```bash
python ~/mc-kb/query.py "<question>"   # RAG search across bible + memory + notes
```

See `~/CLAUDE.md` for laptop-hub overview and `~/.claude/projects/-home-itsju/memory/MEMORY.md` for memory index.

## Data layer

- **Trade data (SQL)**: Oracle's `/home/ubuntu/mission-control-restored/data/options_flow.sqlite` — read-only via bridge.serveftp.com/db/* (token-gated).
- **Memory/docs (RAG)**: `~/mc-kb/` — separate from this app.
- Do NOT add knowledge facts to options_flow.sqlite. Do NOT add trade events to RAG.

## Active workspace, do not delete

When the user says "the dashboard" without qualifying, they mean THIS dir's `npm run dev` on localhost:3000 — not Oracle's `mission-control` PM2 process.
