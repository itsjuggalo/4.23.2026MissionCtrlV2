module.exports = {
  apps: [
    {
      name: 'mission-control',
      script: 'npm',
      args: 'start -- -p 3033',
      cwd: '/home/ubuntu/mission-control',
      
      // CRITICAL: Disable file watching to prevent .next deletion
      watch: false,
      ignore_watch: [
        'node_modules',
        '.next',
        '.git',
        'dist',
        'build',
        'pnpm-lock.yaml',
        'yarn.lock',
        'package-lock.json'
      ],
      
      // Restart configuration
      autorestart: true,
      max_restarts: 10,
      min_uptime: '10s',
      
      // Environment
      env: {
        NODE_ENV: 'production',
      },
      
      // Logging
      error_file: '/home/ubuntu/.pm2/logs/mission-control-error.log',
      out_file: '/home/ubuntu/.pm2/logs/mission-control-out.log',
      log_date_format: 'YYYY-MM-DD HH:mm:ss Z',
      
      // Graceful shutdown
      kill_timeout: 5000,
      wait_ready: true,
      listen_timeout: 10000,
    },
  ],
};
