module.exports = {
  apps: [
    {
      name: 'tweak-discord-monitor',
      script: '/home/ubuntu/mission-control/tweak/tweak_discord_monitor.py',
      interpreter: 'python3',
      cwd: '/home/ubuntu/mission-control/tweak',
      instances: 1,
      autorestart: true,
      watch: false,
      max_memory_restart: '200M',
      error_file: '/home/ubuntu/.pm2/logs/tweak-discord-monitor-error.log',
      out_file: '/home/ubuntu/.pm2/logs/tweak-discord-monitor-out.log',
      log_date_format: 'YYYY-MM-DD HH:mm:ss Z',
      env: {
        NODE_ENV: 'production'
      }
    }
  ]
};
