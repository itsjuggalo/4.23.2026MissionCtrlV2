#!/bin/bash
cd "$(dirname "$0")"
pip3 install websocket-client 2>/dev/null
exec python3 flow_monitor.py
