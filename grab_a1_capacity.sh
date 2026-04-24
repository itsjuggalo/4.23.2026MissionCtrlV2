#!/usr/bin/env bash
# =============================================================================
# grab_a1_capacity.sh — Oracle A1.Flex Capacity Grabber
# Phase 2: Run ONLY after Mike's explicit approval
# =============================================================================
# DO NOT RUN THIS SCRIPT WITHOUT MIKE'S EXPLICIT GO-AHEAD
# =============================================================================

set -euo pipefail

# --- Config ------------------------------------------------------------------
OCI=/home/ubuntu/bin/oci
LOG=/home/ubuntu/logs/a1_grab.log
SECRETS=/home/ubuntu/.openclaw/secrets/oci_ocids.env

TENANCY_OCID="ocid1.tenancy.oc1..aaaaaaaa7xvl6lv4uuecui2fdztavdouhbrlatnpqw7vzirtl2limzvswcla"
COMPARTMENT_OCID="$TENANCY_OCID"   # root compartment = tenancy OCID for free tier

# Subnet: openclaw-subnet (created 2026-03-17, the original openclaw-vcn subnet)
SUBNET_OCID="ocid1.subnet.oc1.iad.aaaaaaaadprgu6gq4ru2siidswnrltajgxqfrngkbixdpcqqn3wp6ryoxdsq"

# Latest Ubuntu 22.04 aarch64 image (Canonical-Ubuntu-22.04-aarch64-2026.03.31-0)
IMAGE_OCID="ocid1.image.oc1.iad.aaaaaaaac6ozbxqea5kb7to5qu3asvnqj5f4j6gcxhxipeafefzpwtxm6mwa"

# SSH public key (from ~/.ssh/authorized_keys on current A2 instance)
SSH_PUBLIC_KEY="ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQCfm3P4CJIIjhh/0uSyDRlsnaNkSxn12VVTaACK11lhMWfB3jmBboUPMLm6ohK8USj+jTEAuL7rIjTzRb35FJ04JTxciVfqlelXfTwAFxC0EzEvrmTszVwND07Wi8TYgPs35drpyDjbyfTEFNmRpk8oTQ51TwFmA6zZM2N9aUv/KVySRzOr4jwYIH2d0i/w5oCBWZ6AtyPcoAfmxXJv4pYyKNQe+7tpzJiMYTtMY658tHd5tsjWGGADv/6vt57jwLU85OsfO/jVPRlBR48FpBsV6pRK6fyDHejiblJJg5hgppHhAJdLgfRZjcxmfd2cm3mXV8JNlT9gYP3oCKTdJoKV ssh-key-2026-03-17"

DISCORD_WEBHOOK="https://discord.com/api/webhooks/1486136528034856961/kuGVpKfnVsFYfhHUwPFuzeuSOiQ4PGPzWj_08KNoGQGJie5Zk643Zzq2WTl6WyPIZ9Z5"

INSTANCE_NAME="openclaw-a1-free"
SHAPE="VM.Standard.A1.Flex"
OCPUS=4
MEMORY_GB=24

RETRY_WAIT=60   # seconds between AD attempts

# Ashburn ADs to cycle through
ADS=(
  "XcfP:US-ASHBURN-AD-1"
  "XcfP:US-ASHBURN-AD-2"
  "XcfP:US-ASHBURN-AD-3"
)

# --- Logging -----------------------------------------------------------------
log() {
  local ts
  ts=$(date -u '+%Y-%m-%d %H:%M:%S UTC')
  echo "[$ts] $*" | tee -a "$LOG"
}

# --- Discord notification -----------------------------------------------------
notify_discord() {
  local message="$1"
  curl -s -X POST "$DISCORD_WEBHOOK" \
    -H "Content-Type: application/json" \
    -d "{\"content\": \"$message\"}" \
    >> "$LOG" 2>&1 || true
}

# --- Main --------------------------------------------------------------------
log "=========================================="
log "A1 Capacity Grabber started"
log "Target: $SHAPE | $OCPUS OCPU | ${MEMORY_GB}GB RAM"
log "Instance name: $INSTANCE_NAME"
log "Subnet: $SUBNET_OCID"
log "Image: $IMAGE_OCID"
log "=========================================="

for AD in "${ADS[@]}"; do
  log "Trying AD: $AD ..."

  # Attempt to launch the instance
  LAUNCH_OUTPUT=$($OCI compute instance launch \
    --availability-domain "$AD" \
    --compartment-id "$COMPARTMENT_OCID" \
    --shape "$SHAPE" \
    --shape-config "{\"ocpus\": $OCPUS, \"memoryInGBs\": $MEMORY_GB}" \
    --subnet-id "$SUBNET_OCID" \
    --image-id "$IMAGE_OCID" \
    --display-name "$INSTANCE_NAME" \
    --assign-public-ip true \
    --ssh-authorized-keys-file <(echo "$SSH_PUBLIC_KEY") \
    --wait-for-state RUNNING \
    --max-wait-seconds 600 \
    --output json 2>&1) || LAUNCH_EXIT=$?

  LAUNCH_EXIT=${LAUNCH_EXIT:-0}

  # Check for out-of-capacity error
  if echo "$LAUNCH_OUTPUT" | grep -qi "Out of host capacity\|out_of_capacity\|InternalError"; then
    log "AD $AD: Out of host capacity. Waiting ${RETRY_WAIT}s before next AD..."
    echo "$LAUNCH_OUTPUT" >> "$LOG"
    sleep "$RETRY_WAIT"
    continue
  fi

  # Check for other errors
  if [ "$LAUNCH_EXIT" -ne 0 ]; then
    log "ERROR: Launch failed in $AD with unexpected error:"
    echo "$LAUNCH_OUTPUT" >> "$LOG"
    log "Exiting with code 1. Do not retry automatically — check logs."
    notify_discord "⚠️ **A1 Grab FAILED** in $AD with unexpected error. Check ~/logs/a1_grab.log"
    exit 1
  fi

  # Success!
  INSTANCE_OCID=$(echo "$LAUNCH_OUTPUT" | python3 -c "import sys,json; d=json.load(sys.stdin); print(d['data']['id'])" 2>/dev/null || echo "UNKNOWN")
  PUBLIC_IP=$(echo "$LAUNCH_OUTPUT" | python3 -c "
import sys, json
d = json.load(sys.stdin)
vnics = d.get('data', {})
print('(check OCI console for public IP)')
" 2>/dev/null || echo "check OCI console")

  log "=========================================="
  log "SUCCESS! Instance launched in $AD"
  log "Instance OCID: $INSTANCE_OCID"
  log "Public IP: $PUBLIC_IP"
  log "Display name: $INSTANCE_NAME"
  log "=========================================="

  notify_discord "🎉 **A1 Instance GRABBED!** ✅\n\`\`\`\nAD: $AD\nOCID: $INSTANCE_OCID\nShape: $SHAPE ($OCPUS OCPU / ${MEMORY_GB}GB)\nName: $INSTANCE_NAME\nSSH: ubuntu@<check OCI console for IP>\n\`\`\`\nPhase 2 complete — ready for migration."

  exit 0

done

log "All ADs exhausted — no capacity available. Script will need to be re-run."
notify_discord "😞 **A1 Grab failed** — no capacity in any Ashburn AD. Re-run script later."
exit 0
