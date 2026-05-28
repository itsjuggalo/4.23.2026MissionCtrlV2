import Database from 'better-sqlite3';
import path from 'path';
import fs from 'fs';

interface CountRow { count: number }
interface AvgRow { avg: number | null }
interface SumRow { total: number | null }
interface MaxRow { best: number | null }
interface MinRow { worst: number | null }

// ============================================================================
// Mission Control SQLite Database
// Persistent storage for trades, activities, alerts, agent metrics
// ============================================================================

const DATA_DIR = path.join(process.env.HOME || '/home/ubuntu', '.mission-control');
const DB_PATH = path.join(DATA_DIR, 'mission-control.db');

// Ensure data directory exists
if (!fs.existsSync(DATA_DIR)) {
  fs.mkdirSync(DATA_DIR, { recursive: true });
}

let _db: Database.Database | null = null;

export function getDb(): Database.Database {
  if (!_db) {
    _db = new Database(DB_PATH);
    _db.pragma('journal_mode = WAL');
    _db.pragma('busy_timeout = 5000');
    _db.pragma('synchronous = NORMAL');
    _db.pragma('foreign_keys = ON');
    runMigrations(_db);
  }
  return _db;
}

function runMigrations(db: Database.Database) {
  db.exec(`
    CREATE TABLE IF NOT EXISTS migrations (
      id INTEGER PRIMARY KEY,
      name TEXT NOT NULL,
      applied_at TEXT DEFAULT (datetime('now'))
    );
  `);

  const applied = new Set(
    db.prepare('SELECT name FROM migrations').all().map((r: any) => r.name)
  );

  const migrations: [string, string][] = [
    ['001_trades', `
      CREATE TABLE IF NOT EXISTS trades (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        symbol TEXT NOT NULL,
        direction TEXT NOT NULL,
        entry_price REAL,
        exit_price REAL,
        quantity REAL,
        pnl_dollars REAL,
        pnl_pct REAL,
        source TEXT DEFAULT 'supertrend',
        status TEXT DEFAULT 'open',
        entry_time TEXT DEFAULT (datetime('now')),
        exit_time TEXT,
        notes TEXT,
        created_at TEXT DEFAULT (datetime('now'))
      );
      CREATE INDEX IF NOT EXISTS idx_trades_symbol ON trades(symbol);
      CREATE INDEX IF NOT EXISTS idx_trades_status ON trades(status);
      CREATE INDEX IF NOT EXISTS idx_trades_entry_time ON trades(entry_time);
    `],

    ['002_activities', `
      CREATE TABLE IF NOT EXISTS activities (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        agent TEXT NOT NULL,
        action TEXT NOT NULL,
        detail TEXT,
        category TEXT DEFAULT 'system',
        severity TEXT DEFAULT 'info',
        created_at TEXT DEFAULT (datetime('now'))
      );
      CREATE INDEX IF NOT EXISTS idx_activities_agent ON activities(agent);
      CREATE INDEX IF NOT EXISTS idx_activities_category ON activities(category);
      CREATE INDEX IF NOT EXISTS idx_activities_created ON activities(created_at);
    `],

    ['003_alerts', `
      CREATE TABLE IF NOT EXISTS alerts (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        severity TEXT NOT NULL DEFAULT 'info',
        category TEXT NOT NULL,
        title TEXT NOT NULL,
        detail TEXT,
        value TEXT,
        acknowledged INTEGER DEFAULT 0,
        created_at TEXT DEFAULT (datetime('now'))
      );
      CREATE INDEX IF NOT EXISTS idx_alerts_severity ON alerts(severity);
      CREATE INDEX IF NOT EXISTS idx_alerts_acknowledged ON alerts(acknowledged);
    `],

    ['004_agent_metrics', `
      CREATE TABLE IF NOT EXISTS agent_metrics (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        agent TEXT NOT NULL,
        metric_type TEXT NOT NULL,
        metric_value REAL,
        detail TEXT,
        recorded_at TEXT DEFAULT (datetime('now'))
      );
      CREATE INDEX IF NOT EXISTS idx_agent_metrics_agent ON agent_metrics(agent);
      CREATE INDEX IF NOT EXISTS idx_agent_metrics_type ON agent_metrics(metric_type);
    `],

    ['005_sessions', `
      CREATE TABLE IF NOT EXISTS sessions (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        agent TEXT NOT NULL,
        model TEXT,
        input_tokens INTEGER DEFAULT 0,
        output_tokens INTEGER DEFAULT 0,
        cost_dollars REAL DEFAULT 0,
        task_description TEXT,
        started_at TEXT DEFAULT (datetime('now')),
        ended_at TEXT
      );
      CREATE INDEX IF NOT EXISTS idx_sessions_agent ON sessions(agent);
    `],

    ['006_daily_snapshots', `
      CREATE TABLE IF NOT EXISTS daily_snapshots (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        date TEXT NOT NULL UNIQUE,
        equity REAL,
        cash REAL,
        buying_power REAL,
        daily_pnl REAL,
        daily_pnl_pct REAL,
        total_return_pct REAL,
        positions_json TEXT,
        btc_price REAL,
        regime TEXT,
        bias TEXT,
        created_at TEXT DEFAULT (datetime('now'))
      );
      CREATE INDEX IF NOT EXISTS idx_snapshots_date ON daily_snapshots(date);
    `],

    ['007_webhooks', `
      CREATE TABLE IF NOT EXISTS webhook_events (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        source TEXT NOT NULL,
        event_type TEXT NOT NULL,
        payload TEXT,
        status TEXT DEFAULT 'received',
        response_code INTEGER,
        processed_at TEXT,
        created_at TEXT DEFAULT (datetime('now'))
      );
      CREATE INDEX IF NOT EXISTS idx_webhook_source ON webhook_events(source);
    `],

    ['008_skill_usage', `
      CREATE TABLE IF NOT EXISTS skill_usage (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        skill_name TEXT NOT NULL,
        agent TEXT NOT NULL,
        success INTEGER DEFAULT 1,
        execution_ms INTEGER,
        error TEXT,
        used_at TEXT DEFAULT (datetime('now'))
      );
      CREATE INDEX IF NOT EXISTS idx_skill_agent ON skill_usage(agent);
    `],
  ];

  const insert = db.prepare('INSERT INTO migrations (name) VALUES (?)');

  for (const [name, sql] of migrations) {
    if (!applied.has(name)) {
      db.exec(sql);
      insert.run(name);
      console.log(`[db] Migration applied: ${name}`);
    }
  }
}

// ============================================================================
// Query helpers
// ============================================================================

// Trades
export function insertTrade(trade: {
  symbol: string; direction: string; entry_price?: number;
  quantity?: number; source?: string; notes?: string;
}) {
  const db = getDb();
  return db.prepare(`
    INSERT INTO trades (symbol, direction, entry_price, quantity, source, notes)
    VALUES (@symbol, @direction, @entry_price, @quantity, @source, @notes)
  `).run(trade);
}

export function closeTrade(id: number, exit_price: number, pnl_dollars: number, pnl_pct: number) {
  const db = getDb();
  return db.prepare(`
    UPDATE trades SET status = 'closed', exit_price = ?, pnl_dollars = ?, pnl_pct = ?,
    exit_time = datetime('now') WHERE id = ?
  `).run(exit_price, pnl_dollars, pnl_pct, id);
}

export function getRecentTrades(limit = 50) {
  return getDb().prepare('SELECT * FROM trades ORDER BY created_at DESC LIMIT ?').all(limit);
}

export function getTradeStats() {
  const db = getDb();
  const total = db.prepare('SELECT COUNT(*) as count FROM trades WHERE status = ?').get('closed') as CountRow | undefined;
  const wins = db.prepare('SELECT COUNT(*) as count FROM trades WHERE status = ? AND pnl_pct > 0').get('closed') as CountRow | undefined;
  const avgWin = db.prepare('SELECT AVG(pnl_pct) as avg FROM trades WHERE status = ? AND pnl_pct > 0').get('closed') as AvgRow | undefined;
  const avgLoss = db.prepare('SELECT AVG(pnl_pct) as avg FROM trades WHERE status = ? AND pnl_pct <= 0').get('closed') as AvgRow | undefined;
  const totalPnl = db.prepare('SELECT SUM(pnl_dollars) as total FROM trades WHERE status = ?').get('closed') as SumRow | undefined;
  const best = db.prepare('SELECT MAX(pnl_pct) as best FROM trades WHERE status = ?').get('closed') as MaxRow | undefined;
  const worst = db.prepare('SELECT MIN(pnl_pct) as worst FROM trades WHERE status = ?').get('closed') as MinRow | undefined;

  return {
    total_trades: total?.count || 0,
    wins: wins?.count || 0,
    losses: (total?.count || 0) - (wins?.count || 0),
    win_rate: (total?.count ?? 0) > 0 ? ((wins?.count || 0) / total!.count * 100) : 0,
    avg_win: avgWin?.avg || 0,
    avg_loss: avgLoss?.avg || 0,
    total_pnl: totalPnl?.total || 0,
    best_trade: best?.best || 0,
    worst_trade: worst?.worst || 0,
    profit_factor: Math.abs(avgLoss?.avg || 0) > 0
      ? (avgWin?.avg || 0) / Math.abs(avgLoss?.avg || 0)
      : 0,
  };
}

// Activities
export function logActivity(agent: string, action: string, detail?: string, category?: string, severity?: string) {
  const db = getDb();
  return db.prepare(`
    INSERT INTO activities (agent, action, detail, category, severity)
    VALUES (?, ?, ?, ?, ?)
  `).run(agent, action, detail || '', category || 'system', severity || 'info');
}

export function getRecentActivities(limit = 100, category?: string) {
  const db = getDb();
  if (category) {
    return db.prepare('SELECT * FROM activities WHERE category = ? ORDER BY created_at DESC LIMIT ?').all(category, limit);
  }
  return db.prepare('SELECT * FROM activities ORDER BY created_at DESC LIMIT ?').all(limit);
}

// Alerts
export function createAlert(severity: string, category: string, title: string, detail?: string, value?: string) {
  const db = getDb();
  return db.prepare(`
    INSERT INTO alerts (severity, category, title, detail, value)
    VALUES (?, ?, ?, ?, ?)
  `).run(severity, category, title, detail || '', value || '');
}

export function getActiveAlerts(limit = 50) {
  return getDb().prepare('SELECT * FROM alerts WHERE acknowledged = 0 ORDER BY created_at DESC LIMIT ?').all(limit);
}

export function acknowledgeAlert(id: number) {
  return getDb().prepare('UPDATE alerts SET acknowledged = 1 WHERE id = ?').run(id);
}

// Daily snapshots
export function saveDailySnapshot(snapshot: {
  equity: number; cash: number; buying_power: number;
  daily_pnl: number; daily_pnl_pct: number; total_return_pct: number;
  positions_json: string; btc_price: number; regime: string; bias: string;
}) {
  const db = getDb();
  const today = new Date().toISOString().split('T')[0];
  return db.prepare(`
    INSERT OR REPLACE INTO daily_snapshots
    (date, equity, cash, buying_power, daily_pnl, daily_pnl_pct, total_return_pct, positions_json, btc_price, regime, bias)
    VALUES (?, @equity, @cash, @buying_power, @daily_pnl, @daily_pnl_pct, @total_return_pct, @positions_json, @btc_price, @regime, @bias)
  `).run(today, snapshot);
}

export function getEquityHistory(days = 90) {
  return getDb().prepare('SELECT * FROM daily_snapshots ORDER BY date DESC LIMIT ?').all(days);
}

// Sessions / cost tracking
export function logSession(agent: string, model: string, input_tokens: number, output_tokens: number, cost: number, task?: string) {
  const db = getDb();
  return db.prepare(`
    INSERT INTO sessions (agent, model, input_tokens, output_tokens, cost_dollars, task_description)
    VALUES (?, ?, ?, ?, ?, ?)
  `).run(agent, model, input_tokens, output_tokens, cost, task || '');
}

export function getCostSummary(days = 30) {
  const db = getDb();
  return db.prepare(`
    SELECT agent, model,
      COUNT(*) as sessions,
      SUM(input_tokens) as total_input,
      SUM(output_tokens) as total_output,
      SUM(cost_dollars) as total_cost
    FROM sessions
    WHERE started_at >= datetime('now', '-' || ? || ' days')
    GROUP BY agent, model
    ORDER BY total_cost DESC
  `).all(days);
}

// Agent metrics
export function recordAgentMetric(agent: string, metric_type: string, value: number, detail?: string) {
  const db = getDb();
  return db.prepare(`
    INSERT INTO agent_metrics (agent, metric_type, metric_value, detail)
    VALUES (?, ?, ?, ?)
  `).run(agent, metric_type, value, detail || '');
}

export function getAgentTrustScore(agent: string) {
  const db = getDb();
  const metrics = db.prepare(`
    SELECT metric_type, AVG(metric_value) as avg_value, COUNT(*) as count
    FROM agent_metrics
    WHERE agent = ? AND recorded_at >= datetime('now', '-7 days')
    GROUP BY metric_type
  `).all(agent);
  return metrics;
}

// Webhook events
export function logWebhookEvent(source: string, event_type: string, payload: string, status?: string, response_code?: number) {
  const db = getDb();
  return db.prepare(`
    INSERT INTO webhook_events (source, event_type, payload, status, response_code, processed_at)
    VALUES (?, ?, ?, ?, ?, datetime('now'))
  `).run(source, event_type, payload, status || 'received', response_code || 0);
}

export function getWebhookHistory(limit = 50) {
  return getDb().prepare('SELECT * FROM webhook_events ORDER BY created_at DESC LIMIT ?').all(limit);
}

// Database stats
export function getDbStats() {
  const db = getDb();
  const trades = db.prepare('SELECT COUNT(*) as count FROM trades').get() as CountRow | undefined;
  const activities = db.prepare('SELECT COUNT(*) as count FROM activities').get() as CountRow | undefined;
  const alerts = db.prepare('SELECT COUNT(*) as count FROM alerts').get() as CountRow | undefined;
  const sessions = db.prepare('SELECT COUNT(*) as count FROM sessions').get() as CountRow | undefined;
  const snapshots = db.prepare('SELECT COUNT(*) as count FROM daily_snapshots').get() as CountRow | undefined;
  const webhooks = db.prepare('SELECT COUNT(*) as count FROM webhook_events').get() as CountRow | undefined;

  return {
    trades: trades?.count || 0,
    activities: activities?.count || 0,
    alerts: alerts?.count || 0,
    sessions: sessions?.count || 0,
    snapshots: snapshots?.count || 0,
    webhooks: webhooks?.count || 0,
    db_path: DB_PATH,
    db_size: fs.existsSync(DB_PATH) ? `${(fs.statSync(DB_PATH).size / 1024).toFixed(1)} KB` : '0 KB',
  };
}
