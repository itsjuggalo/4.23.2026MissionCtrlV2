module.exports = {
  apps: [
    {
      name: 'mc-page-auditor',
      script: '/home/itsju/scripts/mc-page-auditor.js',
      // Run every 15 minutes; PM2 cron mode exits after each run
      cron_restart: '*/15 * * * *',
      autorestart: false,
      watch: false,
      env: {
        NODE_ENV: 'production',
        HOME: '/home/itsju',
        // Pass nvm node path so claude CLI is findable in subshells
        PATH: process.env.PATH || '/home/itsju/.nvm/versions/node/v22.22.3/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin',
      },
      error_file: '/home/itsju/scripts/audit/auditor-error.log',
      out_file: '/home/itsju/scripts/audit/auditor-out.log',
      log_date_format: 'YYYY-MM-DD HH:mm:ss Z',
    },
    {
      name: 'uptime-kuma',
      script: '/home/itsju/uptime-kuma/server/server.js',
      cwd: '/home/itsju/uptime-kuma',
      watch: false,
      autorestart: true,
      max_restarts: 10,
      min_uptime: '10s',
      env: {
        NODE_ENV: 'production',
        HOME: '/home/itsju',
        DATA_DIR: '/home/itsju/uptime-kuma/data',
        UPTIME_KUMA_PORT: '3011',
      },
      error_file: '/home/itsju/scripts/audit/uptime-kuma-error.log',
      out_file: '/home/itsju/scripts/audit/uptime-kuma-out.log',
      log_date_format: 'YYYY-MM-DD HH:mm:ss Z',
    },
  ],
};
