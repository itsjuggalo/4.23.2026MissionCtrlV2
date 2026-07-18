#!/usr/bin/env node
/**
 * mc-page-auditor.js
 * Sweeps all MissionCtrlV2 API endpoints every 15 min (via PM2 cron).
 * Detects: HTTP errors, empty responses, stale timestamps, null data fields.
 * Writes ~/scripts/audit/latest_audit.json and triggers mc-fix-agent.sh on issues.
 */

'use strict';

const fs = require('fs');
const path = require('path');
const { execSync } = require('child_process');

const BASE_URL = 'http://localhost:3000';
const AUDIT_DIR = path.join(process.env.HOME, 'scripts/audit');
const AUDIT_FILE = path.join(AUDIT_DIR, 'latest_audit.json');
const AUDIT_HISTORY = path.join(AUDIT_DIR, 'audit_history.jsonl');

// Market hours: 9:30am–4pm ET, Mon–Fri
function isMarketHours() {
  const now = new Date();
  const et = new Date(now.toLocaleString('en-US', { timeZone: 'America/New_York' }));
  const day = et.getDay(); // 0=Sun, 6=Sat
  const hour = et.getHours();
  const min = et.getMinutes();
  if (day === 0 || day === 6) return false;
  const minutes = hour * 60 + min;
  return minutes >= 9 * 60 + 30 && minutes < 16 * 60;
}

// Parse ISO or unix-ms timestamp from various field formats
function parseTs(value) {
  if (!value) return null;
  if (typeof value === 'number') return value;
  const d = new Date(value);
  return isNaN(d.getTime()) ? null : d.getTime();
}

function ageMinutes(ts) {
  if (!ts) return Infinity;
  return (Date.now() - ts) / 60000;
}

// Endpoint definitions with custom checks
const ENDPOINTS = [
  // --- Core health ---
  {
    path: '/api/health',
    check(data) {
      if (!data.ok) return `health ok=false: ${JSON.stringify(data.subsystems?.live_strategy_pulse)}`;
      return null;
    },
  },

  // --- Alpaca accounts ---
  {
    path: '/api/status',
    check(data) {
      const boba = data?.accounts?.boba;
      const jazzy = data?.accounts?.jazzy;
      if (boba?.error) return `boba error: ${boba.error}`;
      if (jazzy?.error) return `jazzy error: ${jazzy.error}`;
      if (typeof boba?.equity !== 'number') return 'boba equity missing';
      return null;
    },
  },

  // --- Market data (null fields = broken fetch) ---
  {
    path: '/api/market',
    check(data) {
      const age = ageMinutes(parseTs(data?.timestamp));
      if (isMarketHours() && age > 30) return `market data stale: ${Math.round(age)}m old`;
      if (data?.spy === null && data?.qqq === null) return 'market data all null (fetch broken)';
      return null;
    },
  },

  // --- Live signals (cycle age) ---
  {
    path: '/api/live-signals',
    check(data) {
      const ts = parseTs(data?.lastCycleTime);
      const age = ageMinutes(ts);
      if (age > 8 * 60) return `live-signals lastCycleTime stale: ${Math.round(age / 60)}h ago`;
      return null;
    },
  },

  // --- Pipeline feed ---
  {
    path: '/api/pipeline-feed',
    check(data) {
      if (!data?.events) return 'pipeline-feed: no events field';
      if (data.count === 0 && isMarketHours()) return 'pipeline-feed: 0 events during market hours';
      return null;
    },
  },

  // --- Agents ---
  {
    path: '/api/agents',
    check(data) {
      if (!data?.success) return `agents api error: success=false`;
      const ts = parseTs(data?.timestamp);
      const age = ageMinutes(ts);
      if (age > 60) return `agents timestamp stale: ${Math.round(age)}m old`;
      return null;
    },
  },

  // --- Signals ---
  {
    path: '/api/signals/latest',
    check(data) {
      if (!data || typeof data !== 'object') return 'signals/latest: empty response';
      return null;
    },
  },
  {
    path: '/api/signals/history',
    check(data) {
      if (Array.isArray(data) && data.length === 0 && isMarketHours()) {
        return 'signals/history: empty during market hours';
      }
      return null;
    },
  },

  // --- Flow database ---
  {
    path: '/api/flow-database',
    check(data) {
      if (data?.error) return `flow-database error: ${data.error}`;
      return null;
    },
  },

  // --- Options flow ---
  {
    path: '/api/options-flow',
    check(data) {
      if (data?.error) return `options-flow error: ${data.error}`;
      return null;
    },
  },

  // --- Portfolio ---
  {
    path: '/api/portfolio',
    check(data) {
      if (data?.error) return `portfolio error: ${data.error}`;
      return null;
    },
  },

  // --- Trades ---
  {
    path: '/api/trades',
    check(data) {
      if (data?.error) return `trades error: ${data.error}`;
      return null;
    },
  },

  // --- Alerts ---
  {
    path: '/api/alerts-db',
    check(data) {
      if (data?.error) return `alerts-db error: ${data.error}`;
      return null;
    },
  },

  // --- Regime ---
  {
    path: '/api/regime',
    check(data) {
      if (data?.error) return `regime error: ${data.error}`;
      return null;
    },
  },

  // --- Macro ---
  {
    path: '/api/macro-regime',
    check(data) {
      if (data?.error) return `macro-regime error: ${data.error}`;
      return null;
    },
  },

  // --- Calendar ---
  {
    path: '/api/calendar',
    check(data) {
      if (data?.error) return `calendar error: ${data.error}`;
      return null;
    },
  },

  // --- Activity ---
  {
    path: '/api/activity',
    check(data) {
      if (data?.error) return `activity error: ${data.error}`;
      return null;
    },
  },

  // --- Analyst signals ---
  {
    path: '/api/analyst-signals',
    check(data) {
      if (data?.error) return `analyst-signals error: ${data.error}`;
      return null;
    },
  },

  // --- Telegram signals ---
  {
    path: '/api/telegram-signals',
    check(data) {
      if (data?.error) return `telegram-signals error: ${data.error}`;
      return null;
    },
  },

  // --- Market news ---
  {
    path: '/api/market-news',
    check(data) {
      if (data?.error) return `market-news error: ${data.error}`;
      return null;
    },
  },

  // --- Live strategy ---
  {
    path: '/api/live-strategy',
    check(data) {
      if (data?.error) return `live-strategy error: ${data.error}`;
      return null;
    },
  },

  // --- DB status ---
  {
    path: '/api/db-status',
    check(data) {
      if (data?.error) return `db-status error: ${data.error}`;
      return null;
    },
  },

  // --- Desk cycle ---
  {
    path: '/api/desk-cycle',
    check(data) {
      if (data?.error) return `desk-cycle error: ${data.error}`;
      return null;
    },
  },

  // --- Daily report (should be from today) ---
  {
    path: '/api/daily-report',
    check(data) {
      if (data?.error) return `daily-report error: ${data.error}`;
      const ts = parseTs(data?.generated_at);
      const age = ageMinutes(ts);
      if (age > 24 * 60) return `daily-report stale: ${Math.round(age / 60)}h old`;
      return null;
    },
  },

  // --- Supertrend params (should be from today) ---
  {
    path: '/api/supertrend-params',
    check(data) {
      if (data?.error) return `supertrend-params error: ${data.error}`;
      const ts = parseTs(data?.updated);
      const age = ageMinutes(ts);
      if (age > 24 * 60) return `supertrend-params stale: ${Math.round(age / 60)}h old`;
      return null;
    },
  },

  // --- Equity history ---
  {
    path: '/api/equity-history',
    check(data) {
      if (data?.error) return `equity-history error: ${data.error}`;
      const hist = data?.history || [];
      if (Array.isArray(hist) && hist.length === 0) return 'equity-history: no records (never POSTed)';
      return null;
    },
  },

  // --- Equity intraday ---
  {
    path: '/api/equity-intraday',
    check(data) {
      if (data?.error) return `equity-intraday error: ${data.error}`;
      if (isMarketHours() && (!data?.bars || data.bars.length === 0)) return 'equity-intraday: no bars during market hours';
      return null;
    },
  },

  // --- Trade signals ---
  {
    path: '/api/trade-signals',
    check(data) {
      if (data?.error) return `trade-signals error: ${data.error}`;
      return null;
    },
  },

  // --- Crypto ---
  {
    path: '/api/crypto',
    check(data) {
      if (data?.error) return `crypto error: ${data.error}`;
      return null;
    },
  },

  // --- BTC bias ---
  {
    path: '/api/btc-bias',
    check(data) {
      if (data?.error) return `btc-bias error: ${data.error}`;
      return null;
    },
  },

  // --- Wallets (expect array response) ---
  {
    path: '/api/wallets',
    check(data) {
      if (data?.error) return `wallets error: ${data.error}`;
      if (!Array.isArray(data)) return 'wallets: expected array response';
      const errors = data.filter(w => w.status === 'error').map(w => w.name);
      if (errors.length === data.length) return `wallets: all providers errored (${errors.join(', ')})`;
      return null;
    },
    timeout: 90000,
  },

  // --- Squeeze alerts ---
  {
    path: '/api/squeeze-alerts',
    check(data) {
      if (data?.error) return `squeeze-alerts error: ${data.error}`;
      return null;
    },
  },

  // --- Best options history ---
  {
    path: '/api/best-options-history',
    check(data) {
      if (data?.error) return `best-options-history error: ${data.error}`;
      return null;
    },
  },

  // --- Congress ---
  {
    path: '/api/congress',
    check(data) {
      if (data?.error) return `congress error: ${data.error}`;
      return null;
    },
  },

  // --- Session logs ---
  {
    path: '/api/session-logs',
    check(data) {
      if (data?.error) return `session-logs error: ${data.error}`;
      return null;
    },
  },

  // --- LLM portfolio ---
  {
    path: '/api/llm-portfolio',
    check(data) {
      if (data?.error) return `llm-portfolio error: ${data.error}`;
      return null;
    },
  },

  // --- Usage ---
  {
    path: '/api/usage',
    check(data) {
      if (data?.error) return `usage error: ${data.error}`;
      return null;
    },
  },

  // --- Chart signals ---
  {
    path: '/api/chart-signals',
    check(data) {
      if (data?.error) return `chart-signals error: ${data.error}`;
      return null;
    },
  },

  // --- Trade log ---
  {
    path: '/api/trade-log',
    check(data) {
      if (data?.error) return `trade-log error: ${data.error}`;
      return null;
    },
  },

  // --- GoTrader ---
  {
    path: '/api/gotrader',
    check(data) {
      if (data?.error) return `gotrader error: ${data.error}`;
      return null;
    },
  },

  // --- Freqtrade ---
  {
    path: '/api/freqtrade',
    check(data) {
      if (data?.error) return `freqtrade error: ${data.error}`;
      return null;
    },
  },

  // --- ITB ---
  {
    path: '/api/itb',
    check(data) {
      if (data?.error) return `itb error: ${data.error}`;
      return null;
    },
  },

  // --- Copilot ---
  {
    path: '/api/copilot',
    check(data) {
      if (data?.error) return `copilot error: ${data.error}`;
      return null;
    },
  },

  // --- Stocks ---
  {
    path: '/api/stocks',
    check(data) {
      if (data?.error) return `stocks error: ${data.error}`;
      return null;
    },
  },

  // --- Live Quotes ---
  {
    path: '/api/live-quotes',
    check(data) {
      if (data?.error) return `live-quotes error: ${data.error}`;
      return null;
    },
  },

  // --- Boba Journal ---
  {
    path: '/api/boba-journal',
    check(data) {
      if (data?.error) return `boba-journal error: ${data.error}`;
      return null;
    },
  },

  // --- Notifications ---
  {
    path: '/api/notifications',
    check(data) {
      if (data?.error) return `notifications error: ${data.error}`;
      return null;
    },
  },

  // --- Cost Tracking ---
  {
    path: '/api/cost-tracking',
    check(data) {
      if (data?.error) return `cost-tracking error: ${data.error}`;
      return null;
    },
  },
];

const sleep = (ms) => new Promise((r) => setTimeout(r, ms));

// A transient/connection-level failure means the server is briefly unreachable
// (e.g. the dashboard is mid-restart). These must NOT be reported as endpoint
// errors — missionctrl is on a PM2 cron restart that aligns with this sweep's
// schedule, so a single dead-window would otherwise flag all 50 endpoints down.
// HTTP 5xx / bad-JSON are real route failures and are never retried here.
function isTransientNetworkError(err) {
  if (!err) return false;
  if (err.name === 'TimeoutError') return true;
  const msg = String(err.message || '').toLowerCase();
  const cause = String((err.cause && err.cause.code) || '').toUpperCase();
  return (
    msg.includes('fetch failed') ||
    msg.includes('econnrefused') ||
    msg.includes('econnreset') ||
    msg.includes('socket hang up') ||
    cause === 'ECONNREFUSED' ||
    cause === 'ECONNRESET' ||
    cause === 'UND_ERR_SOCKET'
  );
}

async function checkEndpoint(endpoint) {
  const url = `${BASE_URL}${endpoint.path}`;
  const result = { endpoint: endpoint.path, status: 'ok', issue: null };
  const timeout = endpoint.timeout || 10000;

  // Retry only transient/connection-level failures, to ride out a brief
  // server restart window (~2s). A genuinely-down server still fails after all
  // attempts; a real route bug (5xx / bad JSON) short-circuits on attempt 1.
  const MAX_ATTEMPTS = 3;
  const RETRY_DELAY_MS = 2500;
  let lastErr = null;

  for (let attempt = 1; attempt <= MAX_ATTEMPTS; attempt++) {
    try {
      const res = await fetch(url, { signal: AbortSignal.timeout(timeout) });
      result.httpCode = res.status;

      if (res.status >= 500) {
        result.status = 'error';
        result.issue = `HTTP ${res.status}`;
        return result;
      }

      const text = await res.text();
      let data;
      try {
        data = JSON.parse(text);
      } catch {
        result.status = 'error';
        result.issue = 'invalid JSON response';
        return result;
      }

      // Check for empty response
      if (data === null || (typeof data === 'object' && !Array.isArray(data) && Object.keys(data).length === 0)) {
        result.status = 'warning';
        result.issue = 'empty response {}';
        return result;
      }

      // Run custom check
      const customIssue = endpoint.check(data);
      if (customIssue) {
        result.status = 'stale';
        result.issue = customIssue;
      }
      return result;
    } catch (err) {
      lastErr = err;
      if (isTransientNetworkError(err) && attempt < MAX_ATTEMPTS) {
        await sleep(RETRY_DELAY_MS);
        continue;
      }
      result.status = 'error';
      result.issue = err.name === 'TimeoutError' ? `timeout (${timeout / 1000}s)` : err.message;
      return result;
    }
  }

  result.status = 'error';
  result.issue = lastErr ? lastErr.message : 'unknown error';
  return result;
}

async function runAudit() {
  console.log(`[mc-page-auditor] ${new Date().toISOString()} — starting sweep (${ENDPOINTS.length} endpoints)`);

  const results = await Promise.all(ENDPOINTS.map(checkEndpoint));

  const issues = results
    .filter(r => r.status !== 'ok')
    .map(r => ({ endpoint: r.endpoint, type: r.status, detail: r.issue, httpCode: r.httpCode }));

  const healthy = issues.length === 0;
  const report = {
    ts: Date.now(),
    iso: new Date().toISOString(),
    healthy,
    market_hours: isMarketHours(),
    checked: results.length,
    issues,
    all_results: results,
  };

  fs.mkdirSync(AUDIT_DIR, { recursive: true });
  fs.writeFileSync(AUDIT_FILE, JSON.stringify(report, null, 2));
  fs.appendFileSync(AUDIT_HISTORY, JSON.stringify({ ts: report.ts, healthy, issues }) + '\n');

  if (healthy) {
    console.log('[mc-page-auditor] All endpoints healthy.');
  } else {
    console.log(`[mc-page-auditor] ${issues.length} issue(s) found:`);
    issues.forEach(i => console.log(`  ${i.type.toUpperCase()} ${i.endpoint}: ${i.detail}`));
    // mc-fix-agent.sh uses flock — safe to call even if already running; it will self-exit
    console.log('[mc-page-auditor] Triggering mc-fix-agent.sh...');
    try {
      execSync('bash /home/itsju/scripts/mc-fix-agent.sh', {
        stdio: 'inherit',
        env: { ...process.env, PATH: process.env.PATH },
      });
    } catch (err) {
      console.error('[mc-page-auditor] Fix agent error:', err.message);
    }
  }

  return report;
}

runAudit().catch(err => {
  console.error('[mc-page-auditor] Fatal:', err);
  process.exit(1);
});
