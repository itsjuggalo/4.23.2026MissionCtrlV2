#!/usr/bin/env node
/**
 * provision-uptime-kuma.js
 * Auto-registers all MissionCtrl API monitors in Uptime Kuma via its REST API.
 * Run ONCE after completing Uptime Kuma first-run setup at http://localhost:3011
 *
 * Usage: node ~/scripts/provision-uptime-kuma.js <username> <password>
 */
'use strict';

const BASE = 'http://localhost:3011';

const MONITORS = [
  // Core infra
  { name: 'MC Health', url: 'http://localhost:3000/api/health', keyword: '"ok":true' },
  { name: 'MC Status (Alpaca)', url: 'http://localhost:3000/api/status', keyword: '"equity"' },
  { name: 'MC Market Data', url: 'http://localhost:3000/api/market', keyword: '"timestamp"' },

  // Signals
  { name: 'MC Live Signals', url: 'http://localhost:3000/api/live-signals', keyword: '"lastCycleTime"' },
  { name: 'MC Signals Latest', url: 'http://localhost:3000/api/signals/latest', keyword: '{}', invertKeyword: true },
  { name: 'MC Analyst Signals', url: 'http://localhost:3000/api/analyst-signals' },
  { name: 'MC Telegram Signals', url: 'http://localhost:3000/api/telegram-signals' },
  { name: 'MC Chart Signals', url: 'http://localhost:3000/api/chart-signals' },

  // Flow / options
  { name: 'MC Flow Database', url: 'http://localhost:3000/api/flow-database' },
  { name: 'MC Options Flow', url: 'http://localhost:3000/api/options-flow' },
  { name: 'MC Alerts DB', url: 'http://localhost:3000/api/alerts-db' },

  // Portfolio / trading
  { name: 'MC Portfolio', url: 'http://localhost:3000/api/portfolio' },
  { name: 'MC Trades', url: 'http://localhost:3000/api/trades' },
  { name: 'MC Activity', url: 'http://localhost:3000/api/activity' },
  { name: 'MC Trade Log', url: 'http://localhost:3000/api/trade-log' },

  // Research / pipeline
  { name: 'MC Pipeline Feed', url: 'http://localhost:3000/api/pipeline-feed', keyword: '"events"' },
  { name: 'MC Agents', url: 'http://localhost:3000/api/agents', keyword: '"success":true' },
  { name: 'MC Regime', url: 'http://localhost:3000/api/regime' },
  { name: 'MC Macro Regime', url: 'http://localhost:3000/api/macro-regime' },
  { name: 'MC Calendar', url: 'http://localhost:3000/api/calendar' },
  { name: 'MC Market News', url: 'http://localhost:3000/api/market-news' },

  // Strategy
  { name: 'MC Live Strategy', url: 'http://localhost:3000/api/live-strategy' },
  { name: 'MC Desk Cycle', url: 'http://localhost:3000/api/desk-cycle' },
  { name: 'MC DB Status', url: 'http://localhost:3000/api/db-status' },

  // Next.js itself
  { name: 'MC Dashboard (root)', url: 'http://localhost:3000/', acceptedStatusCodes: [[200, 399]] },
];

async function login(username, password) {
  const res = await fetch(`${BASE}/api/v1/login`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ username, password }),
  });
  const json = await res.json();
  if (!json.token) throw new Error(`Login failed: ${JSON.stringify(json)}`);
  return json.token;
}

async function addMonitor(token, monitor) {
  const body = {
    type: 'http',
    name: monitor.name,
    url: monitor.url,
    interval: 60,
    retryInterval: 60,
    maxretries: 2,
    method: 'GET',
    active: true,
    ...(monitor.keyword ? { keyword: monitor.keyword, type: 'keyword' } : {}),
    ...(monitor.invertKeyword ? { invertKeyword: true } : {}),
  };

  const res = await fetch(`${BASE}/api/v1/monitor`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
      Authorization: `Bearer ${token}`,
    },
    body: JSON.stringify(body),
  });
  const json = await res.json();
  return json;
}

async function main() {
  const [username, password] = process.argv.slice(2);
  if (!username || !password) {
    console.error('Usage: node provision-uptime-kuma.js <username> <password>');
    process.exit(1);
  }

  console.log('Logging in to Uptime Kuma...');
  const token = await login(username, password);
  console.log('Logged in. Provisioning monitors...\n');

  let ok = 0, fail = 0;
  for (const monitor of MONITORS) {
    try {
      const result = await addMonitor(token, monitor);
      if (result.id || result.monitorID) {
        console.log(`  ✓ ${monitor.name}`);
        ok++;
      } else {
        console.log(`  ✗ ${monitor.name}: ${JSON.stringify(result)}`);
        fail++;
      }
    } catch (err) {
      console.log(`  ✗ ${monitor.name}: ${err.message}`);
      fail++;
    }
  }

  console.log(`\nDone: ${ok} added, ${fail} failed.`);
  console.log(`View at: ${BASE}`);
}

main().catch(err => { console.error(err); process.exit(1); });
