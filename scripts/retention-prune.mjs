// retention-prune.mjs — nightly dashboard data pruning
// Invoked by mc-dashboard-retention.timer
import Database from 'better-sqlite3';
import path from 'path';
import { fileURLToPath } from 'url';

const __dirname = path.dirname(fileURLToPath(import.meta.url));
const DB_PATH = path.join(__dirname, '../data/dashboard_history.sqlite');

const enabled = process.env.MISSIONCTRL_RETENTION_ENABLED === 'true';
if (!enabled) {
  console.log('Retention disabled (MISSIONCTRL_RETENTION_ENABLED != true) — exiting');
  process.exit(0);
}

const db = new Database(DB_PATH);
db.pragma('foreign_keys = ON');

const now = Date.now();
const d90 = now - 90 * 24 * 60 * 60 * 1000;
const d365 = now - 365 * 24 * 60 * 60 * 1000;

let pruned = 0;
const tx = db.transaction(() => {
  pruned += db.prepare('DELETE FROM itb_runs WHERE ts < ?').run(d90).changes;
  pruned += db.prepare('DELETE FROM live_strategy_pulse WHERE ts < ?').run(d90).changes;
  pruned += db.prepare('DELETE FROM dashboard_metrics WHERE ts < ?').run(d90).changes;
  pruned += db.prepare('DELETE FROM freqtrade_runs WHERE ts < ?').run(d365).changes;
  // CASCADE removes orphaned backtest_curves and backtest_trades
});
tx();

console.log('[retention] Pruned', pruned, 'rows at', new Date().toISOString());

db.prepare(
  'INSERT OR REPLACE INTO dashboard_metrics (ts, key, value) VALUES (?, ?, ?)'
).run(now, 'retention_rows_pruned', pruned);

db.close();
