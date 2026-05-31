# AGENTS — vendored sub-agent library

191 specialist sub-agents from [wshobson/agents](https://github.com/wshobson/agents) (MIT). This dir is the **flat, auto-discovered** copy: one `.md` per agent, keyed by its unique frontmatter `name`. The full marketplace (plugins + 155 skills + 102 commands) lives at `../marketplace/`.

## Invoke

Reference an agent by its frontmatter `name` (= filename without `.md`):

```
Use the python-pro agent to refactor the supertrend optimizer.
Use comprehensive-review-code-reviewer on the current diff.
```

Names are plugin-namespaced where a role recurs (e.g. 7 distinct `code-reviewer`s ship as `comprehensive-review-code-reviewer`, `git-pr-workflows-code-reviewer`, …). Pick by the plugin whose intent matches.

## Stack-relevant picks (start here)

| Task | Agent |
|---|---|
| Trading models / backtests | `quant-analyst` |
| Portfolio risk, R-multiples, position limits | `risk-manager` |
| Next.js / TS / React UI | `typescript-pro`, `frontend-mobile-development-frontend-developer` |
| Python bots (`*.py` services, scrapers) | `python-pro`, `temporal-python-pro` |
| FastAPI / Django services | `python-development-fastapi-pro`, `python-development-django-pro` |
| SQL on `options_flow.sqlite` | `sql-pro`, `database-design-database-architect`, `database-cloud-optimization-database-optimizer` |
| Data pipelines / RAG / vectors | `data-engineer`, `data-scientist`, `vector-database-engineer` |
| LLM/agent features | `ai-engineer`, `prompt-engineer` |
| Code review (the diff) | `comprehensive-review-code-reviewer` |
| Debugging | `debugging-toolkit-debugger`, `error-debugging-error-detective` |
| Perf | `application-performance-performance-engineer` |
| Security audit | `security-scanning-security-auditor` |

## Boundaries

- These agents operate under the **root `AGENTS.md`**: the "This is NOT the Next.js you know" rule (read `node_modules/next/dist/docs/` before writing Next.js code), the read-mostly authority limits on `options_flow.sqlite`, and the **Data-acquisition policy** (official APIs/MCP first, respect TOS/robots.txt, escalate — never silently bypass).
- Upstream agents reference generic 2024/2025 tooling; trust this repo's `CLAUDE.md`/`AGENTS.md` over any agent's built-in assumptions when they conflict.
- Vendored files are kept faithful for update-ability. Repo-specific tightening lives in the files we've edited (see git history); don't mass-rewrite the rest — re-sync instead.

## Update / re-sync

```bash
git clone --depth 1 https://github.com/wshobson/agents /tmp/wshobson-agents
# refresh full marketplace
rm -rf .claude/marketplace/plugins .claude/marketplace/.claude-plugin
cp -r /tmp/wshobson-agents/plugins .claude/marketplace/plugins
cp -r /tmp/wshobson-agents/.claude-plugin .claude/marketplace/.claude-plugin
# re-flatten agents by frontmatter name
for f in $(find /tmp/wshobson-agents/plugins -path '*/agents/*.md'); do \
  n=$(awk -F': *' '/^name:/{print $2; exit}' "$f" | sed 's/ *$//'); \
  [ -n "$n" ] && cp "$f" ".claude/agents/$n.md"; done
```

Provenance + upstream commit: `../marketplace/VENDOR.txt`.
