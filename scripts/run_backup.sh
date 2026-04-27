#!/bin/bash
# Full emergency backup v2: code + configs + secrets + metadata + runbooks + history + PM2 state
# Pushes to: https://github.com/itsjuggalo/MissionCtrl-Data.git (disaster-recovery branch)
set -e

REPO_URL="https://github.com/itsjuggalo/MissionCtrl-Data.git"
STAGING=~/backups/staging
REPO=~/backups/repo
TS=$(date -u +%Y%m%d-%H%M)

echo "=== Step 1: Clean staging and clone repo ==="
rm -rf "$STAGING" "$REPO"
mkdir -p "$STAGING"
git clone "$REPO_URL" "$REPO"
cd "$REPO"
git checkout -b disaster-recovery 2>/dev/null || git checkout disaster-recovery
git pull origin disaster-recovery 2>/dev/null || true

echo "=== Step 2: Copy code & configs ==="
cd "$STAGING"
rsync -a --exclude 'node_modules' --exclude '.next' --exclude '.git' --exclude 'dist' --exclude 'build' --exclude '*.log' ~/mission-control-restored/ ./mission-control-restored/
rsync -a --exclude 'node_modules' --exclude '*.log' ~/mission-control/signal-receiver/ ./signal-receiver/ 2>/dev/null || echo "signal-receiver skipped"
mkdir -p openclaw
cp -r ~/.openclaw/agents ./openclaw/agents 2>/dev/null || true
rsync -a --max-size=10M --exclude '*.log' ~/.openclaw/workspace/ ./openclaw/workspace/ 2>/dev/null || true
cp -r ~/scripts ./scripts 2>/dev/null || true
mkdir -p nginx
sudo cp -r /etc/nginx/sites-enabled ./nginx/sites-enabled 2>/dev/null || true
sudo cp -r /etc/nginx/sites-available ./nginx/sites-available 2>/dev/null || true
sudo chown -R ubuntu:ubuntu ./nginx 2>/dev/null || true
crontab -l > ./crontab.txt 2>/dev/null || echo "# no crontab" > ./crontab.txt
mkdir -p skills
for dir in boba jazzyhazzy orion shared reference; do
  [ -d ~/.openclaw/skills/$dir ] && cp -r ~/.openclaw/skills/$dir ./skills/$dir
done

echo "=== Step 3: Copy secrets (UNENCRYPTED per user request) ==="
cp -r ~/.openclaw/secrets ./secrets 2>/dev/null || true
mkdir -p oci
cp ~/.oci/config ./oci/config 2>/dev/null || true
cp ~/.oci/oci_api_key.pem ./oci/oci_api_key.pem 2>/dev/null || true
cp ~/.oci/oci_api_key_public.pem ./oci/oci_api_key_public.pem 2>/dev/null || true
mkdir -p env-files
find ~ -name ".env*" -not -path "*/node_modules/*" -not -path "*/.next/*" -not -path "*/backups/*" -not -path "*/.git/*" 2>/dev/null | while read f; do
  dest=$(echo "$f" | sed "s|$HOME/||" | tr '/' '_')
  cp "$f" ./env-files/"$dest" 2>/dev/null || true
done
mkdir -p ssh
cp ~/.ssh/authorized_keys ./ssh/authorized_keys 2>/dev/null || true

echo "=== Step 4: PM2 state + startup command ==="
mkdir -p pm2
pm2 save >/dev/null 2>&1 || true
cp ~/.pm2/dump.pm2 ./pm2/dump.pm2 2>/dev/null || true
pm2 jlist 2>/dev/null > ./pm2/jlist.json || true
pm2 startup 2>&1 | tail -5 > ./pm2/startup-command.txt || true

echo "=== Step 5: Bash history + Telegram session + live data ==="
mkdir -p history
cp ~/.bash_history ./history/bash_history_ubuntu.txt 2>/dev/null || true
sudo cat /root/.bash_history 2>/dev/null > ./history/bash_history_root.txt || true
cp ~/.zsh_history ./history/zsh_history.txt 2>/dev/null || true
# Telegram sessions
mkdir -p telegram-session
find ~ -name "*.session" -not -path "*/node_modules/*" 2>/dev/null | while read s; do
  cp "$s" ./telegram-session/ 2>/dev/null || true
done
# SQLite DBs
mkdir -p databases
find ~ -name "*.db" -not -path "*/node_modules/*" -not -path "*/backups/*" 2>/dev/null | while read d; do
  dest=$(echo "$d" | sed "s|$HOME/||" | tr '/' '_')
  cp "$d" ./databases/"$dest" 2>/dev/null || true
done

echo "=== Step 6: Generate METADATA.md ==="
source ~/.openclaw/secrets/oci_ocids.env 2>/dev/null || true
cat > METADATA.md <<EOF
# Mission Control + OpenClaw Infrastructure Metadata
Generated: $(date -u)
Server: $(hostname) ($(curl -s ifconfig.me 2>/dev/null || echo unknown))

## Oracle Cloud
- Tenancy OCID: ${TENANCY_OCID:-see secrets/oci_ocids.env}
- User OCID: ${USER_OCID:-see secrets/oci_ocids.env}
- Region: ${REGION:-us-ashburn-1}
- Current shape: VM.Standard.A2.Flex (PAID - plan migration to A1.Flex)
- VCN: openclaw-vcn
- Subnet: openclaw-subnet

## Installed software versions at backup time
- Node: $(node --version 2>/dev/null)
- npm: $(npm --version 2>/dev/null)
- Python: $(python3 --version 2>/dev/null)
- PM2: $(pm2 --version 2>/dev/null)
- nginx: $(nginx -v 2>&1)
- OCI CLI: $(oci --version 2>/dev/null)

## DNS
- missionctrl.serveftp.com -> 132.145.205.15 (NoIP)
- mikemassage.ddns.net -> planned second instance

## Discord
- Guild: Trading Team HQ (ID: 1486025777970548908)
- Webhooks: see secrets/ directory

## Telegram
- api_id: 31236866
- api_hash: see secrets/.env
- 7 monitored channel IDs in signal-receiver config
- Session file: see telegram-session/

## Firebase
- Realtime DB: stock-signal-72772-default-rtdb.firebaseio.com (publicly readable)

## Ports
- 3033: Mission Control dashboard (Next.js, PM2)
- 8420: Signal receiver (Python, PM2)
- 80: nginx reverse proxy
- 22: SSH

## Critical paths
- Dashboard: ~/mission-control-restored/ (NOT ~/mission-control/)
- Signal receiver: ~/mission-control/signal-receiver/
- OpenClaw: ~/.openclaw/
- Secrets: ~/.openclaw/secrets/
EOF

echo "=== Step 7: Write runbooks ==="
cat > RUNBOOK_MISSIONCTRL.md <<'EOF'
# Mission Control Emergency Restore (Fast Path)
Goal: Dashboard + signal-receiver running on new server in <30 min.

## 1. Install prerequisites
sudo apt update && sudo apt install -y git nginx python3-pip curl sqlite3
curl -fsSL https://deb.nodesource.com/setup_20.x | sudo -E bash -
sudo apt install -y nodejs
sudo npm install -g pm2

## 2. Clone backup
git clone https://github.com/itsjuggalo/MissionCtrl-Data.git
cd MissionCtrl-Data && git checkout disaster-recovery

## 3. Restore files
cp -r mission-control-restored ~/mission-control-restored
mkdir -p ~/mission-control && cp -r signal-receiver ~/mission-control/signal-receiver
mkdir -p ~/.openclaw && cp -r openclaw/* ~/.openclaw/ && cp -r secrets ~/.openclaw/secrets
chmod 600 ~/.openclaw/secrets/*
# Telegram session
find telegram-session -name "*.session" -exec cp {} ~/mission-control-restored/telegram-listener/ \;

## 4. Restore .env files (flattened names in env-files/)
# underscores in filename = slashes in path
# e.g. .openclaw_secrets_.env -> ~/.openclaw/secrets/.env — place manually

## 5. Install & start
cd ~/mission-control-restored && npm install && npm run build
cd ~/mission-control/signal-receiver && pip3 install -r requirements.txt
# PM2 resurrect from dump
mkdir -p ~/.pm2
cp ~/MissionCtrl-Data/pm2/dump.pm2 ~/.pm2/dump.pm2
pm2 resurrect
# If resurrect fails, manually start:
# cd ~/mission-control-restored && pm2 start npm --name mission-control -- start
# cd ~/mission-control/signal-receiver && pm2 start signal_receiver.py --name signal-receiver --interpreter python3
pm2 save
# Run the startup command from pm2/startup-command.txt

## 6. Restore nginx
sudo cp nginx/sites-available/* /etc/nginx/sites-available/
sudo cp nginx/sites-enabled/* /etc/nginx/sites-enabled/
sudo nginx -t && sudo systemctl reload nginx

## 7. Restore cron
crontab crontab.txt

## 8. Update NoIP DNS -> new server IP
## 9. Verify: curl localhost:3033 && curl localhost:8420/health && pm2 status
EOF

cat > RUNBOOK_FULL_REBUILD.md <<'EOF'
# Full Disaster Recovery — Rebuild Everything
Goal: Restore ALL infrastructure (OpenClaw agents, skills, bots, cron) from scratch.

## 1. Provision new server
- Oracle: aim for VM.Standard.A1.Flex (Always Free, 4 OCPU / 24 GB)
- Security list ports: 22, 80, 443, 3033, 8420
- SSH key: see ssh/authorized_keys in this backup

## 2. Run RUNBOOK_MISSIONCTRL.md first (get trading back online)

## 3. Install OpenClaw
curl -fsSL https://openclaw.ai/install.sh | bash
source ~/.bashrc

## 4. Restore OpenClaw state
cp -r openclaw/agents ~/.openclaw/agents
cp -r secrets ~/.openclaw/secrets
chmod 600 ~/.openclaw/secrets/*

## 5. Re-register agents (direct JSON edits are ignored by OpenClaw)
openclaw agents add boba
openclaw agents add jazzyhazzy
openclaw agents add orion

## 6. Restore skills library
mkdir -p ~/.openclaw/skills && cp -r skills/* ~/.openclaw/skills/

## 7. Restore cron & PM2
crontab crontab.txt
cp pm2/dump.pm2 ~/.pm2/dump.pm2 && pm2 resurrect

## 8. Install OCI CLI
bash -c "$(curl -L https://raw.githubusercontent.com/oracle/oci-cli/master/scripts/install/install.sh)"
mkdir -p ~/.oci && cp oci/* ~/.oci/ && chmod 600 ~/.oci/oci_api_key.pem ~/.oci/config

## Gotchas
- VM.Standard.A2.Flex is PAID, A1.Flex is FREE — one letter difference
- Gemini free tier: 20 req/day NOT 250 — disable high-freq Gemini cron
- openclaw config set uses zero-indexed arrays for agents
- Scan new skills for wallet addresses / exec / credential reads before running
- Full restart: pkill -f openclaw && openclaw start, then /new in TUI

## External re-auth checklist
- Anthropic API key (rotate if exposed)
- OKX, Alpaca, Hyperliquid, Robinhood, Firebase, Discord bots, Telegram session
- NoIP: point missionctrl.serveftp.com & mikemassage.ddns.net at new IP
EOF

echo "=== Step 8: Sanity check sizes ==="
cd "$STAGING"
echo "--- Total staging size ---"
du -sh .
echo "--- Files over 50MB ---"
find . -type f -size +50M -exec ls -lh {} \;

echo "=== Step 9: Sync to repo ==="
cd "$REPO"
find . -mindepth 1 -not -path './.git*' -delete 2>/dev/null || true
cp -r "$STAGING"/* .
cp -r "$STAGING"/.[!.]* . 2>/dev/null || true
cat > .gitignore <<EOF
node_modules/
*.log
.next/
dist/
build/
*.pyc
__pycache__/
EOF

echo "=== Step 10: Commit & push ==="
git add -A
git -c user.email="mike@missionctrl.local" -c user.name="Mike" commit -m "Emergency backup $TS" || echo "Nothing to commit"
git push -u origin disaster-recovery

echo "=== Step 11: Local zip snapshot ==="
cd ~/backups
ZIP_NAME="openclaw-full-backup-$TS.zip"
zip -qr "$ZIP_NAME" staging/ -x "*.log"
ls -lh "$ZIP_NAME"

echo ""
echo "============================================"
echo "✅ BACKUP v2 COMPLETE"
echo "============================================"
echo "GitHub: https://github.com/itsjuggalo/MissionCtrl-Data/tree/disaster-recovery"
echo "Local zip: ~/backups/$ZIP_NAME"
echo "Includes: code, configs, secrets, PM2 state, bash history, Telegram session, SQLite DBs, runbooks"
echo "============================================"
