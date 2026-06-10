#!/usr/bin/env node
/**
 * provision-uptime-kuma-sqlite.js
 * Inserts MC monitors + Discord notification directly into Uptime Kuma's SQLite DB
 * using better-sqlite3 (already installed by Uptime Kuma).
 */
'use strict';

const Database = require('/home/itsju/uptime-kuma/node_modules/better-sqlite3');
const fs = require('fs');
const path = require('path');

const DB_PATH = path.join(process.env.HOME, 'uptime-kuma/data/kuma.db');
const USER_ID = 1;
const DISCORD_WEBHOOK = fs.readFileSync(
  path.join(process.env.HOME, '.openclaw/secrets/discord_bobatrades_webhook'), 'utf-8'
).trim();

const db = new Database(DB_PATH);
const now = new Date().toISOString().replace('T', ' ').slice(0, 19);

const insertMonitor = db.prepare(`
  INSERT OR IGNORE INTO monitor
    (name, active, user_id, interval, url, type, weight, maxretries,
     ignore_tls, upside_down, maxredirects, accepted_statuscodes_json,
     retry_interval, method, created_date, keyword)
  VALUES
    (@name, 1, @user_id, 60, @url, @type, 2000, 2,
     0, 0, 10, @statuses,
     60, 'GET', @now, @keyword)
`);

const MONITORS = [
  { name: 'MC Health',           url: 'http://localhost:3000/api/health',           keyword: '"ok":true' },
  { name: 'MC Status (Alpaca)',  url: 'http://localhost:3000/api/status',            keyword: '"equity"' },
  { name: 'MC Market Data',     url: 'http://localhost:3000/api/market',            keyword: '"timestamp"' },
  { name: 'MC Live Signals',    url: 'http://localhost:3000/api/live-signals',      keyword: '"lastCycleTime"' },
  { name: 'MC Signals Latest',  url: 'http://localhost:3000/api/signals/latest',   keyword: null },
  { name: 'MC Pipeline Feed',   url: 'http://localhost:3000/api/pipeline-feed',    keyword: '"events"' },
  { name: 'MC Agents',          url: 'http://localhost:3000/api/agents',            keyword: '"success"' },
  { name: 'MC Flow Database',   url: 'http://localhost:3000/api/flow-database',    keyword: null },
  { name: 'MC Options Flow',    url: 'http://localhost:3000/api/options-flow',     keyword: null },
  { name: 'MC Portfolio',       url: 'http://localhost:3000/api/portfolio',        keyword: null },
  { name: 'MC Trades',          url: 'http://localhost:3000/api/trades',           keyword: null },
  { name: 'MC Alerts DB',       url: 'http://localhost:3000/api/alerts-db',        keyword: null },
  { name: 'MC Regime',          url: 'http://localhost:3000/api/regime',           keyword: null },
  { name: 'MC Macro Regime',    url: 'http://localhost:3000/api/macro-regime',     keyword: null },
  { name: 'MC Calendar',        url: 'http://localhost:3000/api/calendar',         keyword: null },
  { name: 'MC Market News',     url: 'http://localhost:3000/api/market-news',      keyword: null },
  { name: 'MC Live Strategy',   url: 'http://localhost:3000/api/live-strategy',    keyword: null },
  { name: 'MC Desk Cycle',      url: 'http://localhost:3000/api/desk-cycle',       keyword: null },
  { name: 'MC Analyst Signals', url: 'http://localhost:3000/api/analyst-signals',  keyword: null },
  { name: 'MC Telegram Signals',url: 'http://localhost:3000/api/telegram-signals', keyword: null },
  { name: 'MC Chart Signals',   url: 'http://localhost:3000/api/chart-signals',    keyword: null },
  { name: 'MC Activity',        url: 'http://localhost:3000/api/activity',         keyword: null },
  { name: 'MC Trade Log',       url: 'http://localhost:3000/api/trade-log',        keyword: null },
  { name: 'MC DB Status',       url: 'http://localhost:3000/api/db-status',        keyword: null },
  { name: 'MC Dashboard',       url: 'http://localhost:3000/',                     keyword: null },
];

console.log(`Inserting ${MONITORS.length} monitors...`);
const insertMany = db.transaction(() => {
  for (const m of MONITORS) {
    insertMonitor.run({
      name: m.name,
      url: m.url,
      type: m.keyword ? 'keyword' : 'http',
      keyword: m.keyword,
      user_id: USER_ID,
      statuses: '["200-299"]',
      now,
    });
    console.log(`  ✓ ${m.name}`);
  }
});
insertMany();

// Insert Discord notification
console.log('\nInserting Discord notification...');
const discordConfig = JSON.stringify({
  type: 'discord',
  webhookURL: DISCORD_WEBHOOK,
  discordUsername: 'Mission Control',
  discordPrefixMessage: '🔴 MC Alert:',
});

db.prepare(`
  INSERT OR IGNORE INTO notification (name, active, user_id, is_default, config)
  VALUES ('Discord MC', 1, ?, 1, ?)
`).run(USER_ID, discordConfig);

const notifId = db.prepare(`SELECT id FROM notification WHERE name='Discord MC' AND user_id=?`).get(USER_ID).id;
console.log(`  ✓ Discord notification id=${notifId} (is_default=1)`);

// Link to all monitors
const monitorIds = db.prepare(`SELECT id FROM monitor WHERE user_id=?`).all(USER_ID).map(r => r.id);
const link = db.prepare(`INSERT OR IGNORE INTO monitor_notification (monitor_id, notification_id) VALUES (?, ?)`);
const linkAll = db.transaction(() => { for (const mid of monitorIds) link.run(mid, notifId); });
linkAll();
console.log(`  ✓ Linked Discord to ${monitorIds.length} monitors`);

db.close();
console.log('\nDone. Restarting Uptime Kuma...');
