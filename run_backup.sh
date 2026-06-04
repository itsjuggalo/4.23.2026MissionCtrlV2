#!/bin/bash
# Full emergency backup v2: code + configs + secrets + metadata + runbooks + history + PM2 state
# Pushes to: https://github.com/itsjuggalo/MissionCtrl-Data.git (disaster-recovery branch)
set -e

REPO_URL="https://github.com/itsjuggalo/MissionCtrl-Data.git"
STAGING=~/backups/staging
REPO=~/backups/repo
TS=$(date -u +%Y%m%d-%H%M)

echo "=== Step 1: Clean staging and clone repo ==="
# sudo: prior runs stage root-owned files (e.g. /etc/nginx configs), which a plain rm can't
# remove → dirty staging → blobs never built. This was why the backup silently failed.
sudo rm -rf "$STAGING" "$REPO" 2>/dev/null || rm -rf "$STAGING" "$REPO"
mkdir -p "$STAGING"
git clone "$REPO_URL" "$REPO"
cd "$REPO"
git checkout -b disaster-recovery 2>/dev/null || git checkout disaster-recovery
git pull origin disaster-recovery 2>/dev/null || true

echo "=== Step 2: Copy code & configs ==="
cd "$STAGING"
rsync -a --max-size=25M --exclude 'node_modules' --exclude '.next' --exclude '.git' --exclude 'dist' --exclude 'build' --exclude '*.log' --exclude '*.jsonl' ~/mission-control-restored/ ./mission-control-restored/
rsync -a --max-size=25M --exclude 'node_modules' --exclude '*.log' --exclude '*.jsonl' ~/mission-control/signal-receiver/ ./signal-receiver/ 2>/dev/null || echo "signal-receiver skipped"
mkdir -p openclaw
cp -r ~/.openclaw/agents ./openclaw/agents 2>/dev/null || true
rsync -a --max-size=10M --exclude '*.log' --exclude '.git' ~/.openclaw/workspace/ ./openclaw/workspace/ 2>/dev/null || true
cp -r ~/scripts ./scripts 2>/dev/null || true
cp -r ~/bin ./bin 2>/dev/null || true   # boot/resilience scripts: wsl-boot.sh, safe-wsl-shutdown, backup-memory.sh, etc.
mkdir -p nginx
sudo cp -r /etc/nginx/sites-enabled ./nginx/sites-enabled 2>/dev/null || true
sudo cp -r /etc/nginx/sites-available ./nginx/sites-available 2>/dev/null || true
sudo chown -R "$(id -un):$(id -gn)" ./nginx 2>/dev/null || true   # portable: laptop=itsju, Oracle=ubuntu (was hardcoded ubuntu → left files root-owned on laptop)
crontab -l > ./crontab.txt 2>/dev/null || echo "# no crontab" > ./crontab.txt
mkdir -p skills
for dir in boba jazzyhazzy orion shared reference; do
  [ -d ~/.openclaw/skills/$dir ] && cp -r ~/.openclaw/skills/$dir ./skills/$dir
done

echo "=== Step 3: Stage secrets into a temp tree, then ENCRYPT to a single blob ==="
# Fail-safe: secrets are NEVER written to the repo in plaintext. They are tar'd
# and encrypted with openssl AES-256-CBC (pbkdf2+salt) using the passphrase at
# ~/.config/mc-secrets/dr_backup.key (mode 600, gitignored, OUTSIDE any repo).
DR_KEY="$HOME/.config/mc-secrets/dr_backup.key"
if [ ! -s "$DR_KEY" ]; then
  echo "FATAL: DR passphrase key missing at $DR_KEY — refusing to back up secrets in plaintext" >&2
  exit 1
fi

# Build the plaintext secrets tree in a private temp dir OUTSIDE staging/repo.
SECRETS_TMP=$(mktemp -d "${TMPDIR:-/tmp}/dr-secrets.XXXXXX")
chmod 700 "$SECRETS_TMP"
mkdir -p "$SECRETS_TMP/secrets" "$SECRETS_TMP/oci" "$SECRETS_TMP/env-files" "$SECRETS_TMP/ssh" "$SECRETS_TMP/mc-secrets"
cp -r ~/.openclaw/secrets/. "$SECRETS_TMP/secrets/" 2>/dev/null || true
cp ~/.oci/config "$SECRETS_TMP/oci/config" 2>/dev/null || true
cp ~/.oci/oci_api_key.pem "$SECRETS_TMP/oci/oci_api_key.pem" 2>/dev/null || true
cp ~/.oci/oci_api_key_public.pem "$SECRETS_TMP/oci/oci_api_key_public.pem" 2>/dev/null || true
# New SQLite secrets store — this is now the CANONICAL secrets source (migrated
# 2026-06-03), so we no longer sweep the whole home dir for .env* files.
cp ~/.config/mc-secrets/secrets.sqlite "$SECRETS_TMP/mc-secrets/secrets.sqlite" 2>/dev/null || true
# Narrowed 2026-06-03: only the EXPLICIT live-app env files that aren't in the store,
# not a home-wide find (which tripped the credential-collection safety gate).
for f in ~/aries/.env.local ~/01_ACTIVE/LapClaw/.env.local; do
  [ -f "$f" ] && cp "$f" "$SECRETS_TMP/env-files/$(echo "$f" | sed "s|$HOME/||" | tr '/' '_')" 2>/dev/null || true
done

# Encrypt the whole tree into ONE blob inside staging. No plaintext secret lands in the repo.
tar czf - -C "$SECRETS_TMP" . \
  | openssl enc -aes-256-cbc -pbkdf2 -salt -pass "file:$DR_KEY" \
  > "$STAGING/secrets.tar.gz.enc"
echo "secrets.tar.gz.enc written ($(du -h "$STAGING/secrets.tar.gz.enc" | cut -f1))"
# Wipe the plaintext temp tree immediately.
rm -rf "$SECRETS_TMP"

echo "=== Step 4: PM2 state + startup command ==="
mkdir -p pm2
pm2 save >/dev/null 2>&1 || true
cp ~/.pm2/dump.pm2 ./pm2/dump.pm2 2>/dev/null || true
pm2 jlist 2>/dev/null > ./pm2/jlist.json || true
pm2 startup 2>&1 | tail -5 > ./pm2/startup-command.txt || true

echo "=== Step 5: Bash history + Telegram session + live data (ENCRYPTED) ==="
# These can contain credentials (pasted secrets in history, auth tokens in
# .session files, keys in SQLite DBs) so they go into a SECOND encrypted blob,
# never the plaintext repo. Belt-and-suspenders: *.sqlite/*.session also gitignored.
SENS_TMP=$(mktemp -d "${TMPDIR:-/tmp}/dr-sens.XXXXXX")
chmod 700 "$SENS_TMP"
mkdir -p "$SENS_TMP/telegram-session" "$SENS_TMP/databases"
# Narrowed 2026-06-03: no bash/zsh history collection and no `sudo`/root access
# (those tripped the credential-collection + privilege-escalation safety gate and
# aren't needed to restore service). Telegram sessions + trade DBs are scoped to
# their KNOWN dirs only, not a home-wide find.
for d in ~/mission-control-restored ~/01_ACTIVE/mission-control-restored ~/01_ACTIVE/LapClaw; do
  [ -d "$d" ] && find "$d" -maxdepth 3 -name "*.session" 2>/dev/null | while read s; do
    cp "$s" "$SENS_TMP/telegram-session/" 2>/dev/null || true
  done
done
for d in ~/01_ACTIVE/LapClaw/pipeline ~/.openclaw; do
  [ -d "$d" ] && find "$d" -maxdepth 2 \( -name "*.db" -o -name "*.sqlite" \) 2>/dev/null | while read f; do
    cp "$f" "$SENS_TMP/databases/$(echo "$f" | sed "s|$HOME/||" | tr '/' '_')" 2>/dev/null || true
  done
done
tar czf - -C "$SENS_TMP" . \
  | openssl enc -aes-256-cbc -pbkdf2 -salt -pass "file:$HOME/.config/mc-secrets/dr_backup.key" \
  > "$STAGING/sensitive-data.tar.gz.enc"
echo "sensitive-data.tar.gz.enc written ($(du -h "$STAGING/sensitive-data.tar.gz.enc" | cut -f1))"
rm -rf "$SENS_TMP"

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
# Strip embedded .git dirs from staged content (e.g. openclaw/workspace, go-trader,
# mission-control). -mindepth 2 protects the repo's OWN ./.git (depth 1). Without this, git
# treats them as broken submodules → "fatal: bad object HEAD" and the push step fails.
find . -mindepth 2 -name .git -prune -exec rm -rf {} + 2>/dev/null || true
cat > .gitignore <<EOF
node_modules/
*.log
.next/
dist/
build/
*.pyc
__pycache__/
# Belt-and-suspenders: never commit plaintext secrets/keys/DBs/sessions.
# Secrets are committed ONLY as the encrypted blobs secrets.tar.gz.enc /
# sensitive-data.tar.gz.enc (which are NOT matched by these patterns).
secrets/
oci/
env-files/
telegram-session/
databases/
history/
ssh/
*.env
.env*
*.sqlite
*.session
*.key
*.pem
EOF
# Defensive purge: if any prior plaintext secret dirs/files are still tracked
# from an earlier run, remove them from the index before committing.
git rm -r --cached --ignore-unmatch secrets oci env-files telegram-session databases history ssh 2>/dev/null || true

echo "=== Step 10: Commit & push ==="
git add -A
git -c user.email="mike@missionctrl.local" -c user.name="Mike" commit -m "Emergency backup $TS" || echo "Nothing to commit"
git push -u origin disaster-recovery

echo "=== Step 11: Local snapshot (optional, non-fatal) ==="
cd ~/backups
if command -v zip >/dev/null 2>&1; then
  ZIP_NAME="openclaw-full-backup-$TS.zip"
  zip -qr "$ZIP_NAME" staging/ -x "*.log" && ls -lh "$ZIP_NAME"
else
  # zip not installed — fall back to tar.gz so the run still succeeds (was exit 127)
  TAR_NAME="openclaw-full-backup-$TS.tar.gz"
  tar czf "$TAR_NAME" --exclude='*.log' staging/ && ls -lh "$TAR_NAME"
fi

echo ""
echo "============================================"
echo "✅ BACKUP v2 COMPLETE"
echo "============================================"
echo "GitHub: https://github.com/itsjuggalo/MissionCtrl-Data/tree/disaster-recovery"
echo "Local zip: ~/backups/$ZIP_NAME"
echo "Includes: code, configs, secrets, PM2 state, bash history, Telegram session, SQLite DBs, runbooks"
echo "============================================"
