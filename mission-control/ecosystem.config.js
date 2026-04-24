const fs = require('fs');

// Helper: read a secret file, return '' if missing
function secret(filename) {
  const p = `/home/ubuntu/.openclaw/secrets/${filename}`;
  try { return fs.readFileSync(p, 'utf8').trim(); } catch(e) { return ''; }
}

// Build shared env object — all secrets loaded at PM2 config parse time
const sharedEnv = {
  PYTHONUNBUFFERED: '1',

  // Alpaca
  ALPACA_API_KEY:      secret('alpaca-key-id'),
  ALPACA_SECRET_KEY:   secret('alpaca-secret'),
  APCA_API_KEY_ID:     secret('alpaca-key-id'),
  APCA_API_SECRET_KEY: secret('alpaca-secret'),

  // Alpha Vantage
  ALPHA_VANTAGE_API_KEY: secret('alphavantage.key'),

  // OpenAI
  OPENAI_API_KEY: secret('openai.key'),

  // OKX
  OKX_API_KEY:    secret('okx_key.txt'),
  OKX_API_SECRET: secret('okx_secret.txt'),
  OKX_PASSPHRASE: secret('okx_passphrase.txt'),

  // FRED
  FRED_API_KEY: secret('fred.txt'),

  // Telegram
  TELEGRAM_BOT_TOKEN: secret('telegram-bot-token.txt'),
  TELEGRAM_CHAT_ID:   secret('telegram-chat-id.txt'),

  // Discord — brief channels
  MORNING_BRIEF_WEBHOOK: secret('discord-webhook-morning-brief.txt'),
  MIDDAY_BRIEF_WEBHOOK:  secret('discord-webhook-midday-brief.txt'),
  EOD_BRIEF_WEBHOOK:     secret('discord-webhook-eod-brief.txt'),
  NIGHTLY_BRIEF_WEBHOOK: secret('discord-webhook-nightly-brief.txt'),

  // Discord — agent channels
  DISCORD_ANALYST_SETUPS_WEBHOOK:        secret('discord-webhook-analyst-setups.txt'),
  DISCORD_ANALYST_WATCHLIST_WEBHOOK:     secret('discord-webhook-analyst-watchlist.txt'),
  DISCORD_ARCHIVE_ANALYST_WEBHOOK:       secret('discord-webhook-archive-analyst.txt'),
  DISCORD_PORTFOLIO_STATUS_WEBHOOK:      secret('discord-webhook-portfolio-status.txt'),
  DISCORD_PORTFOLIO_REBALANCE_WEBHOOK:   secret('discord-webhook-portfolio-rebalance.txt'),
  DISCORD_ARCHIVE_PORTFOLIO_WEBHOOK:     secret('discord-webhook-archive-portfolio.txt'),
  DISCORD_RISK_DECISIONS_WEBHOOK:        secret('discord-webhook-risk-decisions.txt'),
  DISCORD_RISK_ALERTS_WEBHOOK:           secret('discord-webhook-risk-alerts.txt'),
  DISCORD_ARCHIVE_RISK_WEBHOOK:          secret('discord-webhook-archive-risk.txt'),
  DISCORD_ERIC_SIGNALS_WEBHOOK:          secret('discord-webhook-eric-signals.txt'),
  DISCORD_ERIC_REJECTED_WEBHOOK:         secret('discord-webhook-eric-rejected.txt'),
  DISCORD_ARCHIVE_ERIC_WEBHOOK:          secret('discord-webhook-archive-eric.txt'),
  DISCORD_BROADCAST_LOG_WEBHOOK:         secret('discord-webhook-broadcast-log.txt'),
  DISCORD_ARCHIVE_BROADCASTER_WEBHOOK:   secret('discord-webhook-archive-broadcaster.txt'),
  DISCORD_TRADE_REVIEWS_WEBHOOK:         secret('discord-webhook-trade-reviews.txt'),
  DISCORD_PERFORMANCE_DAILY_WEBHOOK:     secret('discord-webhook-performance-daily.txt'),
  DISCORD_PERFORMANCE_WEEKLY_WEBHOOK:    secret('discord-webhook-performance-weekly.txt'),
  DISCORD_LESSONS_WEBHOOK:               secret('discord-webhook-lessons.txt'),
  DISCORD_PERFORMANCE_MONTHLY_WEBHOOK:   secret('discord-webhook-performance-monthly.txt'),
  DISCORD_ARCHIVE_AUDITOR_WEBHOOK:       secret('discord-webhook-archive-auditor.txt'),
  DISCORD_CI_THREAT_WEBHOOK:             secret('discord-webhook-ci-threat.txt'),
  DISCORD_CI_OBFUSCATION_WEBHOOK:        secret('discord-webhook-ci-obfuscation.txt'),
  DISCORD_CI_ML_WEBHOOK:                 secret('discord-webhook-ci-ml.txt'),
  DISCORD_CI_UPGRADES_WEBHOOK:           secret('discord-webhook-ci-upgrades.txt'),
  DISCORD_CI_REPORT_WEBHOOK:             secret('discord-webhook-ci-report.txt'),
  DISCORD_ARCHIVE_CI_WEBHOOK:            secret('discord-webhook-archive-ci.txt'),
  DISCORD_EXECUTIONS_LIVE_WEBHOOK:       secret('discord-webhook-executions-live.txt'),
  DISCORD_EXECUTIONS_PENDING_WEBHOOK:    secret('discord-webhook-executions-pending.txt'),
  DISCORD_EXECUTION_NOTES_WEBHOOK:       secret('discord-webhook-execution-notes.txt'),
  DISCORD_ARCHIVE_EXECUTIONS_WEBHOOK:    secret('discord-webhook-archive-executions.txt'),
  DISCORD_MACRO_OUTLOOK_WEBHOOK:         secret('discord-webhook-macro-outlook.txt'),
  DISCORD_MACRO_ALERTS_WEBHOOK:          secret('discord-webhook-macro-alerts.txt'),
  DISCORD_ARCHIVE_MACRO_WEBHOOK:         secret('discord-webhook-archive-macro.txt'),
};

const MC = '/home/ubuntu/mission-control';

module.exports = {
  apps: [
    {
      name: 'analyst',
      script: `${MC}/analyst/analyst.py`,
      cwd: `${MC}/analyst`,
      interpreter: 'python3',
      autorestart: true, max_restarts: 10, min_uptime: '10s',
      env: sharedEnv,
      error_file: '/home/ubuntu/.pm2/logs/analyst-error.log',
      out_file:   '/home/ubuntu/.pm2/logs/analyst-out.log',
      log_date_format: 'YYYY-MM-DD HH:mm:ss Z',
    },
    {
      name: 'auditor',
      script: `${MC}/auditor/auditor.py`,
      cwd: `${MC}/auditor`,
      interpreter: 'python3',
      autorestart: true, max_restarts: 10, min_uptime: '10s',
      env: sharedEnv,
      error_file: '/home/ubuntu/.pm2/logs/auditor-error.log',
      out_file:   '/home/ubuntu/.pm2/logs/auditor-out.log',
      log_date_format: 'YYYY-MM-DD HH:mm:ss Z',
    },
    {
      name: 'broadcaster',
      script: `${MC}/broadcaster/broadcaster.py`,
      cwd: `${MC}/broadcaster`,
      interpreter: 'python3',
      autorestart: true, max_restarts: 10, min_uptime: '10s',
      env: sharedEnv,
      error_file: '/home/ubuntu/.pm2/logs/broadcaster-error.log',
      out_file:   '/home/ubuntu/.pm2/logs/broadcaster-out.log',
      log_date_format: 'YYYY-MM-DD HH:mm:ss Z',
    },
    {
      name: 'counter-intel',
      script: `${MC}/counter-intelligence/shield.py`,
      cwd: `${MC}/counter-intelligence`,
      interpreter: 'python3',
      autorestart: true, max_restarts: 10, min_uptime: '10s',
      env: sharedEnv,
      error_file: '/home/ubuntu/.pm2/logs/counter-intel-error.log',
      out_file:   '/home/ubuntu/.pm2/logs/counter-intel-out.log',
      log_date_format: 'YYYY-MM-DD HH:mm:ss Z',
    },
    {
      name: 'executor',
      script: `${MC}/execution-specialist/executor.py`,
      cwd: `${MC}/execution-specialist`,
      interpreter: 'python3',
      autorestart: true, max_restarts: 10, min_uptime: '10s',
      env: sharedEnv,
      error_file: '/home/ubuntu/.pm2/logs/executor-error.log',
      out_file:   '/home/ubuntu/.pm2/logs/executor-out.log',
      log_date_format: 'YYYY-MM-DD HH:mm:ss Z',
    },
    {
      name: 'macro-strategist',
      script: `${MC}/macro-strategist/macro_strategist.py`,
      cwd: `${MC}/macro-strategist`,
      interpreter: 'python3',
      autorestart: true, max_restarts: 10, min_uptime: '10s',
      env: sharedEnv,
      error_file: '/home/ubuntu/.pm2/logs/macro-strategist-error.log',
      out_file:   '/home/ubuntu/.pm2/logs/macro-strategist-out.log',
      log_date_format: 'YYYY-MM-DD HH:mm:ss Z',
    },
    {
      name: 'portfolio-monitor',
      script: `${MC}/portfolio-monitor/monitor.py`,
      cwd: `${MC}/portfolio-monitor`,
      interpreter: 'python3',
      autorestart: true, max_restarts: 10, min_uptime: '10s',
      env: sharedEnv,
      error_file: '/home/ubuntu/.pm2/logs/portfolio-monitor-error.log',
      out_file:   '/home/ubuntu/.pm2/logs/portfolio-monitor-out.log',
      log_date_format: 'YYYY-MM-DD HH:mm:ss Z',
    },
    {
      name: 'risk-manager',
      script: `${MC}/risk-manager/risk_manager.py`,
      cwd: `${MC}/risk-manager`,
      interpreter: 'python3',
      autorestart: true, max_restarts: 10, min_uptime: '10s',
      env: sharedEnv,
      error_file: '/home/ubuntu/.pm2/logs/risk-manager-error.log',
      out_file:   '/home/ubuntu/.pm2/logs/risk-manager-out.log',
      log_date_format: 'YYYY-MM-DD HH:mm:ss Z',
    },
    {
      name: 'telegram-listener',
      script: `${MC}/telegram-listener/listener.py`,
      cwd: `${MC}/telegram-listener`,
      interpreter: 'python3',
      autorestart: true, max_restarts: 10, min_uptime: '10s',
      env: sharedEnv,
      error_file: '/home/ubuntu/.pm2/logs/telegram-listener-error.log',
      out_file:   '/home/ubuntu/.pm2/logs/telegram-listener-out.log',
      log_date_format: 'YYYY-MM-DD HH:mm:ss Z',
    },
    {
      name: 'tweak-discord-monitor',
      script: `${MC}/tweak/tweak_discord_monitor.py`,
      cwd: `${MC}/tweak`,
      interpreter: 'python3',
      autorestart: true, max_restarts: 10, min_uptime: '10s',
      node_args: '',
      env: { ...sharedEnv, NODE_ENV: 'production' },
      error_file: '/home/ubuntu/.pm2/logs/tweak-discord-monitor-error.log',
      out_file:   '/home/ubuntu/.pm2/logs/tweak-discord-monitor-out.log',
      log_date_format: 'YYYY-MM-DD HH:mm:ss Z',
    },
  ],
};
