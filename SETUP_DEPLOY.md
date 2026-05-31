# Deploy setup — phone-friendly auto-deploy to Oracle

One-time setup for the `Deploy relay to Oracle` GitHub Action
(`.github/workflows/deploy-relay.yml`). After this is done **every push to
`claude/pipeline-discord-messages-C5Wvw` or `main`** auto-deploys the v2
pipeline to Oracle and restarts pm2 — no laptop required.

## What you need to do (≈ 10 min)

### 1. Get a deploy SSH key onto GitHub

Two options. **Option A is fastest.**

**Option A — reuse your existing `~/.ssh/openclaw.key`.**

From your laptop (WSL):
```bash
cat ~/.ssh/openclaw.key
```

Copy the full output (everything from `-----BEGIN OPENSSH PRIVATE KEY-----`
to `-----END OPENSSH PRIVATE KEY-----` inclusive). Then in your phone browser
(or GitHub mobile app):

1. Go to `https://github.com/itsjuggalo/4.23.2026MissionCtrlV2/settings/secrets/actions`
2. Click **New repository secret**
3. Name: `ORACLE_DEPLOY_KEY`
4. Value: paste the full private key
5. Click **Add secret**

That's it for option A — your existing key already works for Oracle, so no
Oracle-side change needed.

**Option B — generate a dedicated deploy key (more secure).**

On laptop (WSL):
```bash
ssh-keygen -t ed25519 -f ~/.ssh/oracle_deploy_key -N "" -C "github-actions deploy"
cat ~/.ssh/oracle_deploy_key.pub  # copy this line
ssh ubuntu@openclaw 'cat >> ~/.ssh/authorized_keys' < ~/.ssh/oracle_deploy_key.pub
cat ~/.ssh/oracle_deploy_key      # paste this into GitHub secret
```

Then add `ORACLE_DEPLOY_KEY` GitHub secret as in option A but using
`~/.ssh/oracle_deploy_key` contents instead.

### 2. (Optional) Set `SCRIPTS_DEST` repo variable

The workflow only deploys boba/jazzy decision-cycle scripts if you tell it
where they live on Oracle. To enable:

1. First confirm the path (run from any SSH client — your phone is fine):
   ```bash
   ssh ubuntu@openclaw 'find ~ -maxdepth 4 -name boba_decision_cycle.py 2>/dev/null | head -3'
   ```
2. Copy the directory part (everything except the filename).
3. In GitHub: `Settings → Secrets and variables → Actions → Variables → New`
4. Name: `SCRIPTS_DEST`
5. Value: the directory path (e.g. `/home/ubuntu/mission-control-restored/scripts`)
6. Click **Add variable**

Until you set this, the workflow skips script deployment but still ships the
pipeline package + relay.

### 3. Test it

Push any small change to `pipeline/` or `Option-Signals-Scraper/discord_relay.py`
on the `claude/pipeline-discord-messages-C5Wvw` branch — or just trigger it
manually:

1. Go to `https://github.com/itsjuggalo/4.23.2026MissionCtrlV2/actions/workflows/deploy-relay.yml`
2. Click **Run workflow** → pick branch → **Run**

Watch the run from your phone. Success looks like green checkmark + last
log line `✅ Relay restarted cleanly, no import errors, no tracebacks.`

Failure on the smoke test (e.g. `v2 pipeline not importable`) means
something on Oracle drifted — open the logs in the failed step to see what.

## Phone workflow from here on

1. Open `claude.ai/code` in mobile browser. Pick the branch.
2. Tell Claude what to change. It commits + pushes.
3. The deploy action runs automatically (~30 sec).
4. Confirm green checkmark in GitHub Actions tab.
5. Check Discord channels for the new behaviour.

No SSH, no rsync, no `pm2`. The workflow does all of it.
