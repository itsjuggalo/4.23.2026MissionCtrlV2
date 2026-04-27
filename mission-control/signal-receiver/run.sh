#!/bin/bash
# Signal Receiver — Startup Script
# Run directly: ./run.sh
# PM2: pm2 start run.sh --name signal-receiver

cd "$(dirname "$0")"

# Install deps if needed
pip install fastapi uvicorn python-dateutil --break-system-packages -q 2>/dev/null

# Create dirs
mkdir -p logs data

echo "[signal-receiver] Starting on port 8420..."
exec python3 -m uvicorn webhook_server:app --host 127.0.0.1 --port 8420 --log-level info
