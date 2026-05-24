<!--
  Shape source: ~/templates/context-quartet/agents.md (Kashef Context Engineering + Mike's MissionCtrlV2 precedent).
-->

<!-- BEGIN:nextjs-agent-rules -->
# This is NOT the Next.js you know

This version has breaking changes — APIs, conventions, and file structure may all differ from your training data. Read the relevant guide in `node_modules/next/dist/docs/` before writing any code. Heed deprecation notices.
<!-- END:nextjs-agent-rules -->

# AGENTS — MissionCtrlV2 (active local dashboard)

This is the **canonical local-host dashboard** on port 3000. Replaces missionctrl.serveftp.com (Oracle), which is stale. No sub-agents — invoked directly by the operator + visited by browser.

## Surfaces

| Page | Path | Backing data |
|---|---|---|
| Flow Database | `src/components/pages/FlowDatabasePage.tsx` | `bridge.serveftp.com/db/*` proxy → Oracle's `options_flow.sqlite` |
| ITB (Intelligent Trading Bot) | ITB page | `/api/itb` route → `~/LapClaw/intelligent-trading-bot/` |
| Freqtrade | Freqtrade page | `/api/freqtrade` route → `~/LapClaw/freqtrade/` |

## Spawning rules

- Any sub-agent for code changes here MUST load: `CLAUDE.md` (this dir) + the **Next.js BREAKING CHANGES** rule above + `node_modules/next/dist/docs/` for the API surface.
- For tasks touching `src/components/pages/FlowDatabasePage.tsx`, also load `~/.claude/projects/-home-itsju/memory/reference-desk-pipeline-data-layer.md`.
- For tasks touching `src/components/layout/Sidebar.tsx` or `AppShellClient.tsx`, scope to navigation — page routing changes ripple through every page component.

## Authority limits

- This UI is read-mostly: it surfaces SQL + RAG state. Don't add write paths to `options_flow.sqlite` from this app — writes go through Oracle's writer processes (`alpaca_history_writer_py`, scrapers).
- Don't proxy through any other Oracle endpoint without updating `.env.local` + bridge token rotation.

## Related

- `COLLABORATION.md` — proxy contract with `bridge.serveftp.com`
- `MEMORY.md` — port, env vars, key paths, deploy notes

## In-flight

- `PLAN.md` — UI eye-candy upgrade for Desk/ITB/Freqtrade/LiveStrategy pages (color-token migration + shared chart primitives + additive API/SQLite reshape). Awaiting `/claudex:plan --from-draft --skip-interview` adversarial review before execution. Mirror at `~/PLAN.md` (symlink) so claudex picks it up from the home cwd.
