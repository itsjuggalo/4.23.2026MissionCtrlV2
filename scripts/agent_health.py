#!/usr/bin/env python3
"""
Agent Health Checker — runs every 30 min, scores agents from PM2 status + activity
Posts trust metrics to /api/agent-trust
"""
import json, urllib.request, subprocess

MC = "http://localhost:3033"

def post(endpoint, data):
    try:
        payload = json.dumps(data).encode()
        req = urllib.request.Request(f"{MC}{endpoint}", data=payload,
            headers={"Content-Type": "application/json"}, method="POST")
        urllib.request.urlopen(req, timeout=5)
    except: pass

def get(endpoint):
    try:
        req = urllib.request.Request(f"{MC}{endpoint}")
        resp = urllib.request.urlopen(req, timeout=10)
        return json.loads(resp.read())
    except: return None

# Get PM2 status
try:
    result = subprocess.run(["pm2", "jlist"], capture_output=True, text=True, timeout=10)
    pm2_list = json.loads(result.stdout)
except:
    pm2_list = []

# Map PM2 processes to agents
agent_pm2 = {
    "Boba": None,  # Boba runs via OpenClaw, not PM2
    "JazzyHazzy": None,  # Same
    "Orion": None,  # Same
    "Discord Relay": "option-signals-relay",
    "Option Signals Scraper": "option-signals",
    "Signal Receiver": "signal-receiver",
    "Brief Forwarder": "brief-forwarder",
    "Flow Monitor": "flow-monitor",
}

for agent, pm2_name in agent_pm2.items():
    uptime_score = 50
    restart_penalty = 0
    
    if pm2_name:
        proc = next((p for p in pm2_list if p.get("name") == pm2_name), None)
        if proc:
            status = proc.get("pm2_env", {}).get("status", "unknown")
            restarts = proc.get("pm2_env", {}).get("restart_time", 0)
            uptime_ms = proc.get("pm2_env", {}).get("pm_uptime", 0)
            
            if status == "online":
                uptime_score = 95
            elif status == "stopped":
                uptime_score = 20
            else:
                uptime_score = 40
            
            restart_penalty = min(restarts * 2, 30)
            uptime_score = max(0, uptime_score - restart_penalty)
            
            post("/api/agent-trust", {
                "agent": agent, "metric_type": "uptime",
                "value": uptime_score, "detail": f"status={status}, restarts={restarts}"
            })
            post("/api/agent-trust", {
                "agent": agent, "metric_type": "restarts",
                "value": restarts, "detail": f"PM2 restart count"
            })

# Check OpenClaw agents via cron activity
activities = get("/api/activity")
if activities:
    entries = activities.get("entries", [])
    for agent_name in ["Boba", "JazzyHazzy", "Orion"]:
        agent_entries = [e for e in entries if agent_name.lower() in (e.get("agent", "")).lower()]
        activity_score = min(len(agent_entries) * 10, 100)
        
        has_errors = any("error" in (e.get("action", "")).lower() for e in agent_entries)
        has_hallucinations = any(
            any(bad in (e.get("action", "")).lower() for bad in ["$x", "n/a", "heartbeat_ok", "$0.00"])
            for e in agent_entries
        )
        
        accuracy = 90
        if has_errors: accuracy -= 20
        if has_hallucinations: accuracy -= 30
        
        post("/api/agent-trust", {
            "agent": agent_name, "metric_type": "activity",
            "value": activity_score, "detail": f"{len(agent_entries)} entries in feed"
        })
        post("/api/agent-trust", {
            "agent": agent_name, "metric_type": "accuracy",
            "value": accuracy, "detail": f"errors={has_errors}, hallucinations={has_hallucinations}"
        })

print("[health] Agent health check complete")
