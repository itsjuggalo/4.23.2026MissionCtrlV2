#!/usr/bin/env node
const express = require('express');
const fs = require('fs');
const path = require('path');
const { spawn } = require('child_process');
const https = require('https');
const http = require('http');
const app = express();
app.use(express.json());

const FORECASTS_DIR = '/home/itsju/.openclaw/workspace/directives/kronos_forecasts';
const SECRETS_DIR = '/home/itsju/.openclaw/secrets';
const WEBHOOK_FILE = path.join(SECRETS_DIR, 'discord-webhook-kronos.txt');
const PORT = 4711;
const FINETUNED_DIR = '/home/itsju/04_RESEARCH/Kronos/finetune_csv/finetuned/us_stocks_1h';
const FINETUNED_TICKERS = new Set(['NVDA','TSLA','SPY','QQQ','AAPL','MSFT','AMD','SMCI','META','MU','AMZN','GOOGL','COIN','BTCUSD','BTC']);
function finetunedReady() {
  try {
    return fs.existsSync(path.join(FINETUNED_DIR, 'tokenizer', 'best_model', 'model.safetensors')) &&
           fs.existsSync(path.join(FINETUNED_DIR, 'basemodel', 'best_model', 'model.safetensors'));
  } catch (_) { return false; }
}
const cache = new Map();
const CACHE_TTL_MS = 15 * 60 * 1000;
// Track in-flight generations to prevent duplicate runs
const generating = new Set();

function getDiscordWebhook() {
  try { return fs.readFileSync(WEBHOOK_FILE, 'utf-8').trim(); } catch (_) { return ''; }
}

function setCache(symbol, model, data) {
  cache.set(`${symbol}|${model}`, { data, exp: Date.now() + CACHE_TTL_MS });
}

function getCache(symbol, model) {
  const e = cache.get(`${symbol}|${model}`);
  if (e && e.exp > Date.now()) return e.data;
  if (e) cache.delete(`${symbol}|${model}`);
  return null;
}

function canonicalize(sym) {
  sym = sym.toUpperCase().trim();
  if (sym === 'BTCUSDT' || sym === 'BTCUSD') return 'BTC';
  if (sym === 'ETHUSDT' || sym === 'ETHUSD') return 'ETH';
  return sym;
}

function findLatest(symbol) {
  const latest = path.join(FORECASTS_DIR, `latest_${symbol}.json`);
  try {
    const raw = fs.readFileSync(latest, 'utf-8');
    const data = JSON.parse(raw);
    if (data.error) return null;
    const stat = fs.statSync(latest);
    return { ...data, _file: `latest_${symbol}.json`, _file_mtime: stat.mtime.toISOString(), _source: 'disk' };
  } catch (_) { return null; }
}

function findFileByModel(symbol, model) {
  // Try latest_ file first (fast path)
  const latest = findLatest(symbol);
  if (latest && (!model || String(latest.model || '').toLowerCase().includes(model))) return latest;
  // Fall back to scanning timestamped files
  let files;
  try {
    files = fs.readdirSync(FORECASTS_DIR)
      .filter(f => f.toUpperCase().startsWith(symbol.toUpperCase() + '_') && f.endsWith('.json') && !f.startsWith('latest_'))
      .sort().reverse();
  } catch (_) { return null; }
  for (const f of files.slice(0, 10)) {
    try {
      const data = JSON.parse(fs.readFileSync(path.join(FORECASTS_DIR, f), 'utf-8'));
      if (data.error) continue;
      if (model && !String(data.model || '').toLowerCase().includes(model)) continue;
      return { ...data, _file: f, _source: 'disk' };
    } catch (_) {}
  }
  return null;
}

// Anti-bloat gate: only post Kronos forecasts worth a notification.
// Kills the ~50/day spam of low-confidence, conflicting, off-hours, duplicate
// forecasts that made #kronos noise. Set KRONOS_POST_ALL=1 to bypass.
const _lastKronosPost = new Map(); // ticker -> epoch ms of last posted
function _shouldPostKronos(f) {
  if (process.env.KRONOS_POST_ALL === '1') return true;
  const conf = String(f.forecast_24h_confidence || '').toLowerCase();
  const dir = String(f.forecast_24h_direction || '').toLowerCase();
  // 1) only HIGH-confidence, directional calls (drop low/medium + neutral noise)
  if (conf !== 'high') return false;
  if (dir !== 'bullish' && dir !== 'bearish') return false;
  // 2) drop self-negating forecasts that conflict with the option context
  if (f.option_in_forecast_direction === false) return false;
  // 3) market hours only (ET 9:30–16:00, Mon–Fri) — no overnight spam
  const now = new Date();
  const et = new Date(now.toLocaleString('en-US', { timeZone: 'America/New_York' }));
  const mins = et.getHours() * 60 + et.getMinutes();
  if (et.getDay() === 0 || et.getDay() === 6 || mins < 570 || mins > 960) return false;
  // 4) dedupe: at most one post per ticker per 2h
  const t = String(f.ticker || '?');
  const last = _lastKronosPost.get(t) || 0;
  if (Date.now() - last < 2 * 60 * 60 * 1000) return false;
  _lastKronosPost.set(t, Date.now());
  return true;
}

function postToDiscord(forecast, source) {
  const webhook = getDiscordWebhook();
  if (!webhook) return;
  if (!_shouldPostKronos(forecast)) {
    console.log(`[kronos] skip Discord post for ${forecast.ticker} (low-signal/off-hours/dup)`);
    return;
  }
  const direction = forecast.forecast_24h_direction || '?';
  const color = { bullish: 0x00FF00, bearish: 0xFF4757, neutral: 0x808080 }[direction] || 0x808080;
  const arrow = { bullish: '\u{1F4C8}', bearish: '\u{1F4C9}', neutral: '\u27A1\uFE0F' }[direction] || '\u2753';
  const ticker = forecast.ticker || '?';
  let title = `${arrow} Kronos: ${ticker}`;
  if (forecast.option_context) title += ` (${forecast.option_context})`;

  const desc = [
    `**Current:** $${Number(forecast.current_price || 0).toLocaleString('en-US', { minimumFractionDigits: 2, maximumFractionDigits: 2 })}`,
    `**24h target:** $${Number(forecast.forecast_24h_target || 0).toLocaleString('en-US', { minimumFractionDigits: 2, maximumFractionDigits: 2 })} (${forecast.forecast_24h_change_pct >= 0 ? '+' : ''}${forecast.forecast_24h_change_pct || 0}%)`,
    `**Direction:** ${direction.toUpperCase()} (confidence: ${forecast.forecast_24h_confidence || '?'})`,
  ];
  if (forecast.forecast_24h_low && forecast.forecast_24h_high) {
    desc.push(`**Predicted range:** $${Number(forecast.forecast_24h_low).toFixed(2)} \u2013 $${Number(forecast.forecast_24h_high).toFixed(2)}`);
  }
  if (forecast.option_in_forecast_direction !== undefined && forecast.option_in_forecast_direction !== null) {
    desc.push(`**Option check:** ${forecast.option_in_forecast_direction ? '\u2705 agrees' : '\u274C conflicts'}`);
  }

  const payload = JSON.stringify({
    username: 'Kronos',
    embeds: [{
      title,
      description: desc.join('\n'),
      color,
      footer: { text: `${forecast.model || 'Kronos'} \u2022 ${source || 'sidecar'} \u2022 ${new Date().toISOString().slice(11, 16)} UTC` },
    }],
  });

  const url = new URL(webhook);
  const mod = url.protocol === 'https:' ? https : http;
  const req = mod.request(url, { method: 'POST', headers: { 'Content-Type': 'application/json', 'Content-Length': Buffer.byteLength(payload) } }, (res) => {
    if (res.statusCode >= 400) console.error(`[discord] post failed: ${res.statusCode}`);
  });
  req.on('error', (e) => console.error(`[discord] error: ${e.message}`));
  req.write(payload);
  req.end();
}

// GET /forecast?symbol=NVDA&model=small
// Returns cached or on-disk forecast
app.get('/forecast', (req, res) => {
  const symbol = canonicalize(String(req.query.symbol || req.query.ticker || ''));
  const model = String(req.query.model || '').toLowerCase();
  if (!symbol) return res.status(400).json({ error: 'symbol required' });
  const cached = getCache(symbol, model);
  if (cached) return res.json({ ...cached, _source: 'cache' });
  const file = findFileByModel(symbol, model);
  if (file) { setCache(symbol, model, file); return res.json(file); }
  res.status(404).json({ error: `no forecast for ${symbol}`, symbol, model, missing: true });
});

// POST /generate { ticker, model }
// Runs forecast synchronously, posts to Discord, returns result
app.post('/generate', (req, res) => {
  const symbol = canonicalize(String(req.body.ticker || req.body.symbol || ''));
  const model = String(req.body.model || 'small').toLowerCase();
  const source = String(req.body.source || 'api');
  if (!symbol) return res.status(400).json({ error: 'ticker required' });
  if (generating.has(symbol)) return res.json({ status: 'already_generating', ticker: symbol, model });

  generating.add(symbol);
  const useFinetuned = FINETUNED_TICKERS.has(symbol) && finetunedReady();
  const args = ['/home/itsju/05_AUTOMATION/scripts/kronos_forecast_v2.py', '--ticker', symbol, '--model', model, '--no-discord'];
  if (useFinetuned) { args.push('--finetuned'); console.log(`[kronos] ${symbol} using finetuned weights`); }
  const child = spawn('/home/itsju/02_DATA/mc-kb/.venv/bin/python', args, { cwd: '/home/itsju/04_RESEARCH/Kronos' });

  let stdout = '';
  let stderr = '';
  child.stdout.on('data', (d) => { stdout += d; });
  child.stderr.on('data', (d) => { stderr += d; });

  // Respond immediately with status, then finish in background
  res.json({ status: 'generating', ticker: symbol, model });

  child.on('close', (code) => {
    generating.delete(symbol);
    if (code !== 0) {
      console.error(`[kronos] ${symbol} exited ${code}: ${stderr.slice(-300)}`);
    }
    // Always check for forecast file on disk - script may write it even on non-zero exit
    const forecast = findLatest(symbol);
    if (forecast && !forecast.error) {
      cache.delete(`${symbol}|${model}`);
      setCache(symbol, model, forecast);
      postToDiscord(forecast, source === 'vercel' ? 'vercel' : 'api');
      console.log(`[kronos] ${symbol} done (exit ${code}), posted to Discord`);
    } else {
      console.error(`[kronos] ${symbol} no valid forecast file after exit ${code}`);
    }
  });
});

// GET /health
app.get('/health', (req, res) => {
  let fileCount = 0;
  try { fileCount = fs.readdirSync(FORECASTS_DIR).filter(f => f.endsWith('.json')).length; } catch (_) {}
  res.json({ ok: true, cached: cache.size, files: fileCount, generating: [...generating], ts: new Date().toISOString() });
});

app.listen(PORT, '127.0.0.1', () => console.log(`kronos-sidecar on 127.0.0.1:${PORT}`));
