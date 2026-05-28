import { NextResponse } from 'next/server';
import { spawn } from 'child_process';
import fs from 'fs';
import path from 'path';
import os from 'os';
import crypto from 'crypto';
import Database from 'better-sqlite3';
import { proxyToServeftp } from "../../../lib/proxyToServeftp";

export const revalidate = 0;

// Claude Code CLI binary. Resolve at module-load time so the service
// (which has a minimal PATH from `bash -lc 'npm start'`) doesn't fail with
// ENOENT. Override via the CLAUDE_CLI_PATH env var.
function resolveClaudeBin(): string {
  if (process.env.CLAUDE_CLI_PATH) return process.env.CLAUDE_CLI_PATH;
  // Prefer the Linux-native binary (bundled with the agent SDK) over the
  // Windows shim — Windows has a tight command-line length limit that the
  // copilot's full system prompt with alt_signals context overruns.
  const candidates = [
    '/home/itsju/claudeclaw-os/node_modules/@anthropic-ai/claude-agent-sdk-linux-x64/claude',
    '/home/itsju/AiData/claudeclaw-1/node_modules/@anthropic-ai/claude-agent-sdk-linux-x64/claude',
    '/mnt/c/Users/itsju/AppData/Roaming/npm/claude',
    '/home/itsju/.npm-global/bin/claude',
    '/usr/local/bin/claude',
  ];
  for (const p of candidates) {
    try { if (fs.existsSync(p)) return p; } catch { /* noop */ }
  }
  return 'claude';
}
const CLAUDE_BIN = resolveClaudeBin();

interface ClaudeCliResult {
  result?: string;
  is_error?: boolean;
  usage?: { input_tokens?: number; output_tokens?: number; cache_read_input_tokens?: number };
  total_cost_usd?: number;
  duration_ms?: number;
  model?: string;
  session_id?: string;
}

// Known subagent slugs (loaded from ~/.claude/agents/*.md). Used to validate
// /agent-name slash commands at the start of a user message and pass --agent.
const AGENT_SLUGS = new Set([
  'analyst', 'auditor', 'comms-utility', 'crypto-sniper', 'executor',
  'investment-banker', 'macro-strategist', 'portfolio-monitor',
  'quant-engineer', 'research-desk', 'risk-manager', 'signal-filter',
  'stock-researcher', 'web-researcher', 'workflow-builder',
  // Useful built-ins
  'explore', 'plan', 'general-purpose',
]);

// Slash aliases the user can type at the start of a message
const SLASH_ALIASES: Record<string, string> = {
  aladdin: 'signal-filter', // BlackRock DNA persona slug
  filter: 'signal-filter',
  signal: 'signal-filter',
  risk: 'risk-manager',
  macro: 'macro-strategist',
  portfolio: 'portfolio-monitor',
  exec: 'executor',
  ib: 'investment-banker',
  research: 'research-desk',
  crypto: 'crypto-sniper',
  quant: 'quant-engineer',
  comms: 'comms-utility',
  workflow: 'workflow-builder',
};

/**
 * Vertical chat experiences — mirror of AInvest's `prompt_type` taxonomy
 * (captured from their public square_list payload, 2026-05-20). Same chat-send
 * endpoint; the vertical decides the output shape and which structured card,
 * if any, the model should emit.
 *
 *   analysis  — Data-Agent style stock/numeric deep-dive
 *   screen    — natural-language → screener result table
 *   charts    — AI Charts: returns a chart card with levels
 *   news      — news digest with sentiment + ticker tags
 *   crypto    — crypto-asset chat (overlaps /crypto agent; orthogonal)
 *   educate   — finance encyclopedia entry
 *   explain   — "why did X surge?" event explainer
 *   predict   — forecast / probability framing
 *   help      — Mission Control how-to
 *   wiki      — wiki lookup (entity / definition)
 */
const VERTICAL_SLUGS = new Set([
  'analysis', 'screen', 'charts', 'news', 'crypto',
  'educate', 'explain', 'predict', 'help', 'wiki',
]);

const VERTICAL_ALIASES: Record<string, string> = {
  data: 'analysis',
  dataagent: 'analysis',
  'data-agent': 'analysis',
  screener: 'screen',
  scan: 'screen',
  chart: 'charts',
  news: 'news',
  explainer: 'explain',
  why: 'explain',
  forecast: 'predict',
  prediction: 'predict',
  edu: 'educate',
  howto: 'help',
};

/**
 * Returns {agentSlug, verticalSlug, prompt} from a leading slash command.
 * Resolution order:
 *   1. If the slash maps to an agent slug → route to that agent (existing behavior).
 *      Vertical is left for the body to set (orthogonal).
 *   2. Else if the slash maps to a vertical slug → set vertical, no agent.
 *   3. Else → unknown command, leave the original prompt intact.
 */
function parseSlashCommand(prompt: string): {
  agentSlug: string | null;
  verticalSlug: string | null;
  prompt: string;
} {
  const m = prompt.match(/^\/([\w-]+)\s+([\s\S]+)$/);
  if (!m) return { agentSlug: null, verticalSlug: null, prompt };
  const cmd = m[1].toLowerCase();
  const rest = m[2];

  // Agent shortcut takes priority — preserves /aladdin, /crypto-sniper, /risk, etc.
  const agentSlug = SLASH_ALIASES[cmd] || cmd;
  if (AGENT_SLUGS.has(agentSlug)) {
    return { agentSlug, verticalSlug: null, prompt: rest };
  }

  // Vertical shortcut — /screen, /charts, /news, /predict, /educate, /wiki, ...
  const verticalSlug = VERTICAL_ALIASES[cmd] || cmd;
  if (VERTICAL_SLUGS.has(verticalSlug)) {
    return { agentSlug: null, verticalSlug, prompt: rest };
  }

  return { agentSlug: null, verticalSlug: null, prompt };
}

/** Normalize a body.vertical input; returns null when unrecognized. */
function normalizeVertical(raw: unknown): string | null {
  if (typeof raw !== 'string') return null;
  const v = raw.trim().toLowerCase();
  if (!v) return null;
  const alias = VERTICAL_ALIASES[v] || v;
  return VERTICAL_SLUGS.has(alias) ? alias : null;
}

/**
 * Per-vertical system-prompt addendum. Each block tells the model what
 * SHAPE the user expects for this vertical, including any preferred
 * structured card. Keep blocks short — they stack on top of the base
 * + persona prompts and we don't want to drown the model.
 */
const VERTICAL_PROMPTS: Record<string, string> = {
  analysis: `=== VERTICAL: analysis (Data Agent) ===
The user is in the data-agent vertical. They want a numeric / factual deep-dive
on a single ticker, fund, or event. Lead with the answer in one sentence, then
1–3 supporting numbers (cite source: dashboard context, flow.db, or stated tool
result). Avoid trade-frame cards in this vertical — the user is researching, not
sizing. If a chart would clarify, emit a \`chart\` card with key levels.`,

  screen: `=== VERTICAL: screen (AI Screener) ===
The user wants a natural-language screener. Parse their criteria, return a
\`screener\` card listing the top matches, and follow it with a 1-sentence note
on what was excluded. Pull universe candidates from the live dashboard context
(alt_signals_top_24h, holdings) where it fits — don't invent tickers.

\`\`\`screener
{"criteria":"FINRA short>50% AND ADV>500K","universe":"alt_signals_top_24h","results":[{"symbol":"ARTC","note":"64% short, 500K ADV","score":95},{"symbol":"MACI","note":"...","score":80}],"excluded":"warrants, SPAC units, <100K ADV"}
\`\`\``,

  charts: `=== VERTICAL: charts (AI Charts) ===
The user wants chart-flavored analysis on a ticker. Identify the pattern in
one sentence, then emit a \`chart\` card with 2–4 named price levels (support,
resistance, gap, MA). If the live quote isn't available, fill levels with
null prices and note "verify levels before sizing".`,

  news: `=== VERTICAL: news (AI News) ===
The user wants a news-flavored answer. Surface 2–4 recent headlines from the
live dashboard context (or note "no fresh news in feed" if absent), each as one
line: \`• [ticker] headline — sentiment (+/-/neutral)\`. End with a 1-sentence
synthesis. No trade-frame cards.`,

  crypto: `=== VERTICAL: crypto ===
The user is asking about a crypto asset. Cover spot trend, on-chain/funding if
available, and the top catalyst in 3 lines. Use 24h, 7d framing. If they ask for
levels, emit a \`chart\` card with S1/R1.`,

  educate: `=== VERTICAL: educate (encyclopedia) ===
The user wants a definition / explainer. Give a 2-paragraph answer: definition
first, then a worked example with real numbers. Avoid jargon without a gloss.
No structured cards.`,

  explain: `=== VERTICAL: explain (event explainer) ===
The user is asking "why did X happen / surge / drop?". Identify the catalyst in
one line, then 2–3 supporting facts (filing, headline, flow). Cite where each
fact came from (dashboard / news feed / 8-K). No cards.`,

  predict: `=== VERTICAL: predict (forecast) ===
The user is asking for a probability framing on a future event. Give a base
rate, then the catalysts moving it up/down, then your point estimate as a range
("60–70%"). Add a one-line "what would change my mind". No cards.`,

  help: `=== VERTICAL: help (Mission Control how-to) ===
The user is asking how to use Mission Control. Give a 2–4 step procedure with
the exact slash command, file path, or button to click. Cite the page route
(e.g. /signals, /risk). Suppress agent persona language in this vertical — be
plain and operational.`,

  wiki: `=== VERTICAL: wiki (entity lookup) ===
The user wants a brief wiki-style entry on an entity (company, fund, regulator,
indicator). Give 3–5 lines: what it is, who runs it, why it matters to a
trader. No structured cards.`,
};

interface ClaudeCliArgs {
  prompt: string;
  systemPrompt: string;
  model: string;
  /** If false, tools are disabled (`--tools ""`). Default true for in-chat agent ops. */
  enableTools?: boolean;
}

/**
 * Load an agent's persona body (post-frontmatter) from ~/.claude/agents/<slug>.md.
 * Returns null if the file doesn't exist or can't be parsed.
 *
 * We deliberately do NOT use the CLI's `--agent` flag for slash-command routing
 * because that grants the agent its full tool-list (e.g. Bash, WebFetch),
 * bypassing our safe-tool allowlist. Instead we inject the persona as a
 * system-prompt addendum and keep --tools "Task,Read,Grep,Glob" enforced.
 */
function loadAgentPersona(slug: string): string | null {
  try {
    const p = path.join(os.homedir(), '.claude', 'agents', `${slug}.md`);
    if (!fs.existsSync(p)) return null;
    const raw = fs.readFileSync(p, 'utf-8');
    const m = raw.match(/^---\n[\s\S]*?\n---\n([\s\S]*)$/);
    return (m ? m[1] : raw).trim();
  } catch { return null; }
}

/**
 * Build the CLI argv. We use `--strict-mcp-config` to prevent the 280+ MCP
 * servers configured in ~/.claude/settings.json from auto-loading and
 * blowing the context window. Subagents still load via `--setting-sources user`.
 */
function buildClaudeArgs(opts: ClaudeCliArgs, outputFormat: 'json' | 'stream-json'): string[] {
  const args: string[] = [
    '-p',
    '--output-format', outputFormat,
    '--no-session-persistence',
    '--strict-mcp-config',
    '--setting-sources', 'user',
    '--permission-mode', 'bypassPermissions',
    '--model', opts.model,
    '--system-prompt', opts.systemPrompt,
  ];
  if (opts.enableTools === false) {
    args.push('--tools', '');
  } else {
    // Safe read + subagent invocation. No Edit/Write/NotebookEdit.
    // Bash is intentionally omitted to keep the chat from running shell commands.
    args.push('--tools', 'Task,Read,Grep,Glob');
  }
  if (outputFormat === 'stream-json') {
    args.push('--include-partial-messages');
    args.push('--verbose');
  }
  return args;
}

/**
 * Run the Claude Code CLI in non-interactive print mode and return the JSON result.
 *
 * Uses the OAuth credentials at ~/.claude/.credentials.json (Claude Max
 * subscription) — no API key needed.
 */
async function runClaudeCli(opts: ClaudeCliArgs & { timeoutMs?: number }): Promise<ClaudeCliResult> {
  return new Promise((resolve, reject) => {
    const args = buildClaudeArgs(opts, 'json');
    const child = spawn(CLAUDE_BIN, args, {
      stdio: ['pipe', 'pipe', 'pipe'],
      env: { ...process.env, HOME: os.homedir() },
    });

    const stdoutChunks: Buffer[] = [];
    const stderrChunks: Buffer[] = [];
    child.stdout.on('data', (c: Buffer) => stdoutChunks.push(c));
    child.stderr.on('data', (c: Buffer) => stderrChunks.push(c));

    const timeoutMs = opts.timeoutMs ?? 120000;
    const t = setTimeout(() => {
      child.kill('SIGKILL');
      reject(new Error(`Claude CLI timed out after ${timeoutMs}ms`));
    }, timeoutMs);

    child.on('error', (err) => {
      clearTimeout(t);
      reject(err);
    });
    child.on('close', (code) => {
      clearTimeout(t);
      const stdout = Buffer.concat(stdoutChunks).toString('utf-8');
      const stderr = Buffer.concat(stderrChunks).toString('utf-8');
      if (code !== 0) {
        reject(new Error(`Claude CLI exited ${code}: ${stderr.slice(0, 400) || stdout.slice(0, 400)}`));
        return;
      }
      const trimmed = stdout.trim();
      const lastLine = trimmed.split('\n').filter((l) => l.trim().length > 0).pop() || trimmed;
      try {
        const data: ClaudeCliResult = JSON.parse(lastLine);
        resolve(data);
      } catch (e) {
        reject(new Error(`Failed to parse Claude CLI output: ${e instanceof Error ? e.message : String(e)}; stdout head: ${stdout.slice(0, 400)}`));
      }
    });

    child.stdin.write(opts.prompt);
    child.stdin.end();
  });
}

// ---- streaming ----

interface SseEvent {
  type: 'delta' | 'tool_use' | 'tool_result' | 'thread' | 'done' | 'error' | 'status';
  [k: string]: unknown;
}

function sse(event: SseEvent): string {
  return `data: ${JSON.stringify(event)}\n\n`;
}

/**
 * Spawn the CLI in stream-json mode and turn its line-delimited output into
 * a ReadableStream of SSE-formatted events.
 *
 * onComplete receives the assembled assistant text and final usage so the
 * route can persist the thread.
 */
function streamClaudeCli(
  opts: ClaudeCliArgs,
  onComplete: (data: { fullText: string; usage: ClaudeCliResult['usage']; model: string }) => Promise<void> | void,
): ReadableStream<Uint8Array> {
  const encoder = new TextEncoder();
  return new ReadableStream<Uint8Array>({
    start(controller) {
      const args = buildClaudeArgs(opts, 'stream-json');
      const child = spawn(CLAUDE_BIN, args, {
        stdio: ['pipe', 'pipe', 'pipe'],
        env: { ...process.env, HOME: os.homedir() },
      });

      let stdoutBuffer = '';
      let fullText = '';
      let finalUsage: ClaudeCliResult['usage'] = undefined;
      let finalModel = opts.model;
      let finished = false;

      const emit = (ev: SseEvent) => {
        controller.enqueue(encoder.encode(sse(ev)));
      };

      const timeoutMs = 180000;
      const t = setTimeout(() => {
        child.kill('SIGKILL');
        if (!finished) {
          emit({ type: 'error', message: `CLI timed out after ${timeoutMs}ms` });
          controller.close();
          finished = true;
        }
      }, timeoutMs);

      child.stdout.on('data', (chunk: Buffer) => {
        stdoutBuffer += chunk.toString('utf-8');
        let nl;
        while ((nl = stdoutBuffer.indexOf('\n')) !== -1) {
          const line = stdoutBuffer.slice(0, nl).trim();
          stdoutBuffer = stdoutBuffer.slice(nl + 1);
          if (!line) continue;
          let msg: Record<string, unknown>;
          try { msg = JSON.parse(line); } catch { continue; }
          const t = msg.type as string;
          if (t === 'stream_event') {
            const ev = (msg.event || {}) as Record<string, unknown>;
            const evType = ev.type as string;
            if (evType === 'content_block_delta') {
              const delta = (ev.delta || {}) as Record<string, unknown>;
              if (delta.type === 'text_delta' && typeof delta.text === 'string') {
                if (delta.text.length > 0) {
                  fullText += delta.text;
                  emit({ type: 'delta', text: delta.text });
                }
              } else if (delta.type === 'input_json_delta') {
                // tool args streaming — we only signal that a tool is in flight
              }
            } else if (evType === 'content_block_start') {
              const block = (ev.content_block || {}) as Record<string, unknown>;
              if (block.type === 'tool_use') {
                emit({ type: 'tool_use', name: String(block.name || ''), id: String(block.id || '') });
              }
            }
          } else if (t === 'user') {
            // Tool result coming back from a tool the model invoked
            const content = ((msg.message as Record<string, unknown>)?.content || []) as Array<Record<string, unknown>>;
            for (const c of content) {
              if (c.type === 'tool_result') {
                const result = typeof c.content === 'string' ? c.content : JSON.stringify(c.content);
                emit({ type: 'tool_result', tool_use_id: String(c.tool_use_id || ''), content: result.slice(0, 600) });
              }
            }
          } else if (t === 'result') {
            // Final aggregate. Capture usage + model.
            const usage = msg.usage as ClaudeCliResult['usage'];
            if (usage) finalUsage = usage;
            const modelUsage = msg.modelUsage as Record<string, unknown> | undefined;
            if (modelUsage) {
              const firstModel = Object.keys(modelUsage)[0];
              if (firstModel) finalModel = firstModel;
            }
            // Prefer the result text if streaming missed something
            const resultText = msg.result as string | undefined;
            if (resultText && fullText.length === 0) fullText = resultText;
          } else if (t === 'system' && (msg.subtype === 'status' || msg.subtype === 'init')) {
            emit({ type: 'status', subtype: String(msg.subtype) });
          }
        }
      });

      child.stderr.on('data', (chunk: Buffer) => {
        const txt = chunk.toString('utf-8');
        // Stream non-fatal warnings as status events to aid debugging
        if (txt.trim()) emit({ type: 'status', stderr: txt.slice(0, 200) });
      });

      child.on('error', (err) => {
        clearTimeout(t);
        if (!finished) {
          emit({ type: 'error', message: err.message });
          controller.close();
          finished = true;
        }
      });

      child.on('close', async (code) => {
        clearTimeout(t);
        if (finished) return;
        if (code !== 0) {
          emit({ type: 'error', message: `CLI exited with code ${code}` });
          controller.close();
          finished = true;
          return;
        }
        try {
          await onComplete({ fullText, usage: finalUsage, model: finalModel });
        } catch { /* persistence failures shouldn't break the stream */ }
        emit({ type: 'done', model: finalModel, tokens: {
          input: finalUsage?.input_tokens || 0,
          output: finalUsage?.output_tokens || 0,
        }});
        controller.close();
        finished = true;
      });

      child.stdin.write(opts.prompt);
      child.stdin.end();
    },
  });
}

function formatHistoryAsPrompt(messages: { role: string; content: string }[]): string {
  // The CLI is single-shot in `-p` mode, so we serialize the whole history
  // into one prompt. The most recent user message is the one to respond to.
  if (messages.length === 1) return messages[0].content;
  const lines: string[] = [
    '<conversation_history>',
    ...messages.slice(0, -1).map((m) => `[${m.role === 'user' ? 'User' : 'Assistant'}]: ${m.content}`),
    '</conversation_history>',
    '',
    'Continue the conversation. Respond to the most recent User message:',
    '',
    messages[messages.length - 1].content,
  ];
  return lines.join('\n');
}

// ---- secrets / file helpers ----

function readSecret(name: string): string {
  try {
    const p = path.join(os.homedir(), '.openclaw', 'secrets', name);
    if (fs.existsSync(p)) return fs.readFileSync(p, 'utf-8').trim();
  } catch { /* noop */ }
  return process.env[name.toUpperCase()] || '';
}

function safeReadJSON(filepath: string): unknown {
  try {
    if (!fs.existsSync(filepath)) return null;
    return JSON.parse(fs.readFileSync(filepath, 'utf-8'));
  } catch { return null; }
}

// ---- flow.db helpers (alt_signals + threads) ----

const FLOW_DB = path.join(os.homedir(), 'flow-data', 'flow.db');

function openFlowDb(): Database.Database | null {
  try {
    if (!fs.existsSync(FLOW_DB)) return null;
    const db = new Database(FLOW_DB, { fileMustExist: true });
    db.pragma('journal_mode = WAL');
    db.pragma('busy_timeout = 5000');
    return db;
  } catch { return null; }
}

function fetchAltSignalsContext(): Record<string, unknown> {
  const db = openFlowDb();
  if (!db) return {};
  try {
    const top: unknown[] = db.prepare(`
      SELECT source, symbol, headline, quality_score, ts, url
      FROM alt_signals
      WHERE ts >= datetime('now', '-24 hours') AND quality_score >= 60
      ORDER BY quality_score DESC, ts DESC
      LIMIT 30
    `).all();

    const sourceCounts: unknown[] = db.prepare(`
      SELECT source, COUNT(*) AS n, AVG(quality_score) AS avg_q
      FROM alt_signals
      WHERE ts >= datetime('now', '-24 hours')
      GROUP BY source
      ORDER BY n DESC
    `).all();

    const vix: unknown = db.prepare(`
      SELECT ts, vix9d, vix, vix3m, vix6m, contango_vix_3m, regime
      FROM alt_vix_term_structure
      ORDER BY ts DESC LIMIT 1
    `).get();

    const dix: unknown = db.prepare(`
      SELECT ts, dix, gex, spx_close
      FROM alt_dix_gex
      ORDER BY ts DESC LIMIT 1
    `).get();

    const cot: unknown[] = db.prepare(`
      SELECT market, noncomm_net, noncomm_net_z, week_of
      FROM alt_cot_positioning
      ORDER BY week_of DESC, market
      LIMIT 12
    `).all();

    return {
      alt_signals_top_24h: top,
      alt_signals_by_source_24h: sourceCounts,
      vix_term_structure_latest: vix,
      dix_gex_latest: dix,
      cot_latest_by_market: cot,
    };
  } catch (e) {
    return { alt_signals_error: (e instanceof Error ? e.message : String(e)).slice(0, 200) };
  } finally {
    db.close();
  }
}

async function buildDashboardContext(): Promise<string> {
  const home = os.homedir();
  const mcData = path.join(home, 'mission-control-restored', 'data');
  const srData = path.join(home, 'mission-control', 'signal-receiver', 'data');
  const ctx: Record<string, unknown> = {};

  const portfolio = safeReadJSON(path.join(mcData, 'portfolio.json'));
  if (portfolio) ctx.portfolio = portfolio;

  const latestState = safeReadJSON(path.join(srData, 'latest_state.json'));
  if (latestState) ctx.current_positions = latestState;

  const regime = safeReadJSON(path.join(srData, 'market_regime.json'));
  if (regime) ctx.regime = regime;

  const params = safeReadJSON(path.join(srData, 'optimal_params.json'));
  if (params) ctx.optimal_params = params;

  const dailyReport = safeReadJSON(path.join(mcData, 'daily_report.json'));
  if (dailyReport) ctx.daily_report = dailyReport;

  const congress = safeReadJSON(path.join(mcData, 'congress_trades.json')) as Record<string, unknown> | null;
  if (congress) {
    ctx.congress_summary = {
      total_trades: congress.total_trades,
      last_updated: congress.last_updated,
      top_politicians: (congress.politicians as unknown[] | undefined)?.slice(0, 5),
      suspicious_count: (congress.suspicious as unknown[] | undefined)?.length || 0,
    };
  }

  const llm = safeReadJSON(path.join(mcData, 'llm_portfolio.json')) as Record<string, unknown> | null;
  if (llm) ctx.llm_leaderboard = llm.leaderboard;

  const usage = safeReadJSON(path.join(mcData, 'api_usage.json')) as Record<string, unknown> | null;
  if (usage) {
    ctx.api_usage_summary = { last_updated: usage.last_updated, totals_by_provider: usage.totals_by_provider };
  }

  const calendar = safeReadJSON(path.join(mcData, 'calendar_events.json')) as Record<string, unknown> | null;
  if (calendar?.events && Array.isArray(calendar.events)) {
    const now = new Date();
    const week = new Date(now.getTime() + 7 * 24 * 60 * 60 * 1000);
    const upcoming = (calendar.events as Array<Record<string, unknown>>).filter((e) => {
      const d = new Date(String(e.date));
      return d >= now && d <= week;
    });
    ctx.upcoming_events = upcoming.slice(0, 15);
  }

  // NEW: alt-signals pipeline (8-source ingester output)
  const altCtx = fetchAltSignalsContext();
  Object.assign(ctx, altCtx);

  const str = JSON.stringify(ctx, null, 2);
  return str.length > 50000 ? str.slice(0, 50000) + '\n... (truncated)' : str;
}

// ---- model selection ----

const MODEL_SONNET = 'claude-sonnet-4-6';
const MODEL_HAIKU = 'claude-haiku-4-5-20251001';

function pickAutoModel(message: string): string {
  const msg = message.trim();
  if (msg.length < 80) return MODEL_HAIKU;
  if (/analyz|compar|explain|strateg|backtest|why|should I|recommend|deep|detail|forecast|outlook/i.test(msg)) return MODEL_SONNET;
  return MODEL_HAIKU;
}

const BASE_SYSTEM = `You are the Mission Control copilot — an AI trading assistant for Commander Mike. He runs a multi-agent AI trading system migrated into WSL Ubuntu on his laptop:

- Agents: Boba (Claude Sonnet, orchestrator), JazzyHazzy (GPT-4o-mini, research/news), Orion (Gemini Flash, scanner/technicals)
- Hedge-fund persona roster on call: Aladdin (BlackRock signal filter), Analyst, Risk-Manager, Macro-Strategist, Executor, Portfolio-Monitor, Auditor, Investment-Banker, Research-Desk, Crypto-Sniper, Quant-Engineer, Comms-Utility, Workflow-Builder
- Alpaca paper account: ~$137K equity (from $100K start)
- BTCUSD systematic strategy: SuperTrend on Coinbase 1H via TradingView webhooks
- alt-signals pipeline: 8 free Tier 2/3 sources writing to flow.db (SEC 8-K live, FINRA short interest, CME COT, VIX term structure, DIX/GEX, AInvest prompts, WSB ticker scan, HN + r/algotrading)
- Dashboard: Next.js on port 3033

Be direct, concise, and tactical. Use numbers. No fluff. Reference the live context blocks below by name when relevant.`;

const SUPPORT_SYSTEM = `You are the Mission Control support assistant. You help Commander Mike with questions about how to use Mission Control, troubleshoot issues, configure settings, and understand what each feature does.

Mission Control is a Next.js trading dashboard running in WSL Ubuntu on his laptop. It has these pages:
- Dashboard: portfolio overview, positions, regime, strategy params
- TV Chart: TradingView embed with signal panel
- Tasks: pipeline kanban showing trade ideas flowing through stages
- Signals: live signal feed from TradingView webhooks
- Agents: Boba (orchestrator), JazzyHazzy (research), Orion (scanner)
- Congress: congressional trading activity tracker
- LLM Portfolio: AI model portfolio leaderboard (AIME, DeepSeek, Qwen, Claude, Gemini, GPT)
- Calendar: earnings, economic events, dividends, IPOs
- Risk: exposure and risk metrics
- Wallets: crypto wallet balances

Be warm, patient, and thorough. Explain things clearly. If you don't know something specific about the system, say so honestly.`;

// ---- types ----

type ChatMessage = { role: 'user' | 'assistant'; content: string };

function genThreadId(): string {
  return crypto.randomBytes(8).toString('hex');
}

function makeTitle(firstUserMessage: string): string {
  const t = firstUserMessage.trim().replace(/\s+/g, ' ');
  return t.length <= 60 ? t : t.slice(0, 57) + '...';
}

// ---- GET handler (health probe) ----

export async function GET() {
  return NextResponse.json({ status: 'ok', endpoint: 'copilot', note: 'POST only' });
}

// ---- POST handler ----

export async function POST(req: Request) {
  const __proxied = await proxyToServeftp(req); if (__proxied) return __proxied;
  try {
    const url = new URL(req.url);
    const wantsStream =
      url.searchParams.get('stream') === '1' ||
      (req.headers.get('accept') || '').includes('text/event-stream');

    const body = await req.json();
    const mode = String(body.mode || 'auto').toLowerCase();
    const thread_id_in = typeof body.thread_id === 'string' && body.thread_id ? String(body.thread_id) : null;

    // Accept BOTH shapes:
    //   legacy: { message: "...", mode }
    //   new:    { messages: [{role,content}, ...], mode, thread_id? }
    let messages: ChatMessage[] = [];
    if (Array.isArray(body.messages)) {
      messages = (body.messages as Array<Record<string, unknown>>)
        .map((m) => ({
          role: m.role === 'assistant' ? 'assistant' : 'user',
          content: String(m.content || ''),
        }))
        .filter((m) => m.content.length > 0) as ChatMessage[];
    } else if (typeof body.message === 'string' && body.message.trim()) {
      messages = [{ role: 'user', content: body.message.trim() }];
    }

    if (messages.length === 0 || messages[messages.length - 1].role !== 'user') {
      return NextResponse.json({ error: 'Need at least one user message' }, { status: 400 });
    }

    // ---- parse slash-command for agent OR vertical handoff on the LAST user message ----
    const rawLast = messages[messages.length - 1].content;
    const { agentSlug, verticalSlug: slashVertical, prompt: cleanedLast } = parseSlashCommand(rawLast);
    if (agentSlug || slashVertical) {
      // Replace the last user message with the cleaned version (slash stripped)
      // for both the CLI invocation and the persisted thread.
      messages = [...messages.slice(0, -1), { role: 'user', content: cleanedLast }];
    }
    // Vertical resolution: explicit body.vertical wins; otherwise the slash
    // shortcut (if any). Agents and verticals are orthogonal, so /aladdin
    // can still run inside a screener vertical if both are sent.
    const vertical: string | null = normalizeVertical(body.vertical) || slashVertical || null;
    const lastUserText = messages[messages.length - 1].content;

    // ---- model + system prompt ----
    let model = MODEL_SONNET;
    if (mode === 'fast') model = MODEL_HAIKU;
    else if (mode === 'auto') model = pickAutoModel(lastUserText);

    let systemPrompt = BASE_SYSTEM;
    if (mode === 'support') {
      systemPrompt = SUPPORT_SYSTEM;
    } else if (mode === 'copilot') {
      const context = await buildDashboardContext();
      systemPrompt += `\n\n=== LIVE DASHBOARD CONTEXT ===\n${context}\n=== END CONTEXT ===\n\nWhen answering, reference this live data directly. Cite specific numbers, positions, and states. alt_signals_top_24h is the new 8-source feed — surface those headlines when relevant.`;
    }
    // Tool guidance — let the model know how to reach the subagents and read files
    systemPrompt += `\n\nYou have a Task tool that can delegate to specialist subagents on this machine. Use it when the request is best served by Aladdin/signal-filter (signal triage), analyst (technicals), risk-manager, macro-strategist, executor, portfolio-monitor, auditor, investment-banker, research-desk, crypto-sniper, quant-engineer, comms-utility, or workflow-builder. You also have Read/Grep/Glob to read files (flow.db is at ~/flow-data/flow.db; alt-signals scripts are at ~/scripts/alt-signals/). Be tight: cite numbers, route work, return a short verdict.

DISCIPLINE: do not pre-emptively read files or list directories unless the user's request actually requires it. If the live context above already answers the question, answer directly. Tool use is for filling gaps, not exploration.`;

    // Persona injection — when a /agent slash-command routed, append the
    // agent's persona body to the system prompt INSTEAD of using --agent
    // (which would unlock the agent's full tool grants, including Bash).
    if (agentSlug) {
      const persona = loadAgentPersona(agentSlug);
      if (persona) {
        systemPrompt += `\n\n=== ACTIVE PERSONA: ${agentSlug} ===\n${persona}\n=== END PERSONA ===\n\nRespond in this persona's voice, discipline, and decision framework. The user invoked you via /${agentSlug}. Stay in role for this entire response.`;
      }
    }

    // Vertical injection — orthogonal to the agent persona. Tells the model
    // what SHAPE the user expects (free-text vs screener table vs chart card).
    if (vertical && VERTICAL_PROMPTS[vertical]) {
      systemPrompt += `\n\n${VERTICAL_PROMPTS[vertical]}\n=== END VERTICAL ===`;
    }

    // Structured output cards. When the model emits these fenced blocks, the
    // UI replaces them with React cards inline. Use them sparingly — only when
    // the data is well-defined; otherwise plain text or markdown tables.
    systemPrompt += `

When a response NATURALLY fits one of these shapes, emit it as a fenced JSON code block AT THE END of your message. The UI renders these as cards. Always include the trailing prose summary OUTSIDE the block.

\`\`\`trade-frame
{"symbol":"NVDA","direction":"long","entry":485.20,"stop":472.00,"target":520.00,"size_hint":"1% NAV","conviction":"medium","rationale":"<=20 chars"}
\`\`\`

\`\`\`backtest
{"setup":"Item 4.02 + DIX<0.40","n_trades":18,"win_rate":0.61,"avg_win":0.072,"avg_loss":-0.034,"max_dd":-0.18,"sharpe":1.3,"period":"24mo"}
\`\`\`

\`\`\`chart
{"symbol":"BTC-USD","period":"1mo","interval":"1d","note":"<=60 chars","levels":[{"label":"S1","price":92000},{"label":"R1","price":108000}]}
\`\`\`

\`\`\`screener
{"criteria":"FINRA short>50% AND ADV>500K","universe":"alt_signals_top_24h","results":[{"symbol":"ARTC","note":"64% short, 500K ADV","score":95}],"excluded":"warrants, SPAC units, <100K ADV"}
\`\`\`

Do NOT emit a card unless explicitly asked or the user's intent obviously matches. Most replies should be plain text.

PRICE DISCIPLINE for trade-frame cards: never invent entry/stop/target. If you have NOT verified a live quote from the LIVE DASHBOARD CONTEXT block or via a tool call, either:
  (a) emit the card with entry=null, stop=null, target=null, and rationale="price reference needed — verify quote before sending", OR
  (b) skip the card entirely and describe the setup as prose with relative levels (e.g. "short on bounce to 52-week high, stop above weekly resistance").
Inventing a plausible-looking price like "$12" because the ticker is in the alt_signals feed is unacceptable — those signals are catalyst-flagged, not priced.`;

    const thread_id = thread_id_in || genThreadId();
    const promptForCli = formatHistoryAsPrompt(messages);

    // ---- persistence helper (used by both buffered and streaming paths) ----
    const persistThread = async (responseText: string, usage: ClaudeCliResult['usage'] | undefined): Promise<boolean> => {
      try {
        const db = openFlowDb();
        if (!db) return false;
        try {
          // Idempotent migration: add `vertical` column on first write per process.
          // SQLite's ADD COLUMN throws if it already exists; we swallow that.
          try { db.exec(`ALTER TABLE copilot_threads ADD COLUMN vertical TEXT`); }
          catch { /* column already exists — fine */ }

          const fullHistory: ChatMessage[] = [...messages, { role: 'assistant', content: responseText }];
          const existing = db.prepare('SELECT thread_id FROM copilot_threads WHERE thread_id = ?').get(thread_id);
          const title = makeTitle(messages.find((m) => m.role === 'user')?.content || lastUserText);
          if (existing) {
            db.prepare(`
              UPDATE copilot_threads
              SET updated_at = CURRENT_TIMESTAMP,
                  messages_json = ?, msg_count = ?, mode = ?, model_last = ?, vertical = COALESCE(?, vertical)
              WHERE thread_id = ?
            `).run(JSON.stringify(fullHistory), fullHistory.length, mode, model, vertical, thread_id);
          } else {
            db.prepare(`
              INSERT INTO copilot_threads
                (thread_id, title, mode, model_last, msg_count, messages_json, vertical)
              VALUES (?, ?, ?, ?, ?, ?, ?)
            `).run(thread_id, title, mode, model, fullHistory.length, JSON.stringify(fullHistory), vertical);
          }
        } finally {
          db.close();
        }
        // usage logging
        try {
          const logPath = path.join(os.homedir(), 'mission-control-restored', 'data', 'api_usage.json');
          let log: Record<string, unknown> = {};
          if (fs.existsSync(logPath)) log = JSON.parse(fs.readFileSync(logPath, 'utf-8'));
          const entries = (log.entries as unknown[] | undefined) || [];
          entries.push({
            timestamp: new Date().toISOString(),
            source: 'copilot',
            provider: 'anthropic',
            model,
            input_tokens: usage?.input_tokens || 0,
            output_tokens: usage?.output_tokens || 0,
            mode,
            thread_id,
            agent: agentSlug || null,
            vertical: vertical || null,
          });
          log.entries = entries;
          log.last_updated = new Date().toISOString();
          fs.writeFileSync(logPath, JSON.stringify(log, null, 2));
        } catch { /* swallow */ }
        return true;
      } catch { return false; }
    };

    // ---- STREAMING PATH (SSE) ----
    if (wantsStream) {
      const stream = streamClaudeCli({
        prompt: promptForCli,
        systemPrompt,
        model,
        enableTools: true,
      }, async ({ fullText, usage, model: finalModel }) => {
        await persistThread(fullText, usage);
        // Send a thread event before `done` so the client knows the id
        // (SSE writes here would race with controller close — handled inside
        // streamClaudeCli's final `done` event which includes everything).
        void finalModel;
      });
      // Inject the thread_id by tagging the stream — wrap it.
      const headers = new Headers({
        'Content-Type': 'text/event-stream; charset=utf-8',
        'Cache-Control': 'no-cache, no-transform',
        'Connection': 'keep-alive',
        'X-Thread-Id': thread_id,
        'X-Agent': agentSlug || '',
        'X-Vertical': vertical || '',
      });
      // Prepend an SSE event with thread metadata before the model output
      const prefixStream = new ReadableStream<Uint8Array>({
        start(controller) {
          const enc = new TextEncoder();
          controller.enqueue(enc.encode(sse({ type: 'thread', thread_id, agent: agentSlug, vertical })));
          controller.close();
        },
      });
      // Concatenate prefix + main stream
      const combined = new ReadableStream<Uint8Array>({
        async start(controller) {
          const reader1 = prefixStream.getReader();
          while (true) {
            const r = await reader1.read();
            if (r.done) break;
            controller.enqueue(r.value);
          }
          const reader2 = stream.getReader();
          while (true) {
            const r = await reader2.read();
            if (r.done) break;
            controller.enqueue(r.value);
          }
          controller.close();
        },
      });
      return new Response(combined, { headers });
    }

    // ---- BUFFERED PATH (legacy) ----
    let cliResult: ClaudeCliResult;
    try {
      cliResult = await runClaudeCli({
        prompt: promptForCli,
        systemPrompt,
        model,
        enableTools: true,
        timeoutMs: 180000,
      });
    } catch (e) {
      return NextResponse.json({
        error: `Claude CLI invocation failed: ${(e instanceof Error ? e.message : String(e)).slice(0, 200)}`,
      }, { status: 500 });
    }

    if (cliResult.is_error) {
      return NextResponse.json({ error: cliResult.result || 'Claude CLI returned is_error=true' }, { status: 500 });
    }

    const responseText = cliResult.result || '';
    const data = {
      usage: {
        input_tokens: cliResult.usage?.input_tokens || 0,
        output_tokens: cliResult.usage?.output_tokens || 0,
      },
    };

    const persisted = await persistThread(responseText, cliResult.usage);

    return NextResponse.json({
      response: responseText,
      model,
      mode,
      vertical,
      agent: agentSlug,
      thread_id,
      persisted,
      tokens: { input: data.usage?.input_tokens || 0, output: data.usage?.output_tokens || 0 },
    });
  } catch (err) {
    return NextResponse.json({ error: (err instanceof Error ? err.message : String(err)).slice(0, 200) }, { status: 500 });
  }
}
