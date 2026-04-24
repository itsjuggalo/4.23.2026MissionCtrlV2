#!/usr/bin/env python3
"""Reads PM2 activity feed and seeds new entries to SQLite"""
import json, urllib.request

try:
    req = urllib.request.Request("http://localhost:3033/api/activity")
    resp = urllib.request.urlopen(req, timeout=10)
    data = json.loads(resp.read())
    # The activity API now auto-logs to SQLite on each call
    count = data.get("count", 0)
    print(f"[activity_logger] Triggered activity API — {count} entries processed")
except Exception as e:
    print(f"[activity_logger] Error: {e}")
