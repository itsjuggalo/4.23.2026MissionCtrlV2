// PM2 config for the AIME Discord bot (browserless — uses ~/scripts/aime_client.py).
//   pm2 start ~/scripts/aime_discord.ecosystem.js && pm2 save
// Bot: SynthControl (discord_synthcontrol_token) in "MissionCtrl Trade Team".
// Slash command /aime is guild-synced (instant). Optional: set AIME_CHANNEL_ID to
// also treat every message in one channel as an AIME query (needs Message Content intent).
module.exports = {
  apps: [{
    name: 'aime-discord',
    script: '/home/itsju/scripts/aime_discord_bot.py',
    interpreter: '/home/itsju/.venv/bin/python',
    cwd: '/home/itsju/scripts',
    autorestart: true,
    max_restarts: 20,
    restart_delay: 5000,
    env: {
      DISCORD_AIME_TOKEN_FILE: 'discord_synthcontrol_token',
      AIME_GUILD_ID: '1486025777970548908',
    },
  }],
};
