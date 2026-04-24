#!/usr/bin/env python3
"""Scan workspace and build memories.json from real files"""
import json, os, re
from datetime import datetime

WORKSPACE = "/home/ubuntu/.openclaw/workspace"
OUTPUT = "/home/ubuntu/mission-control-restored/memory/memories.json"

memories = []
count = 0

for root, dirs, files in os.walk(WORKSPACE):
    dirs[:] = [d for d in dirs if not d.startswith('.') and d != 'node_modules']
    for f in files:
        if not (f.endswith('.md') or f.endswith('.json')): continue
        path = os.path.join(root, f)
        try:
            content = open(path, 'r').read()[:1000]
        except: continue
        
        rel = os.path.relpath(path, WORKSPACE)
        folder = rel.split('/')[0] if '/' in rel else 'root'
        
        # Determine importance
        importance = 'low'
        if any(k in f.lower() for k in ['config', 'secret', 'key', 'critical']): importance = 'high'
        elif any(k in f.lower() for k in ['directive', 'regime', 'signal', 'strategy']): importance = 'medium'
        
        count += 1
        memories.append({
            "id": f"mem-{count:04d}",
            "title": f.replace('.md','').replace('.json','').replace('_',' ').replace('-',' ').title(),
            "content": content[:300],
            "source": folder,
            "tags": [folder, f.split('.')[-1]],
            "importance": importance,
            "timestamp": datetime.fromtimestamp(os.path.getmtime(path)).isoformat(),
            "date": datetime.fromtimestamp(os.path.getmtime(path)).strftime('%Y-%m-%d'),
        })

memories.sort(key=lambda m: m['timestamp'], reverse=True)
with open(OUTPUT, 'w') as fh:
    json.dump(memories, fh, indent=2)
print(f"Built {len(memories)} memories from workspace")
