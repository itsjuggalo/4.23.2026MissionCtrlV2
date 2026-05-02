"""
Agent task helper — append discovered tasks to ~/.openclaw/data/agent-tasks.json

Usage from any agent script:
    from agent_tasks import add_discovered_task
    add_discovered_task("Boba", "Review FUBO huge flow $2.1M call", source="firebase", ticker="FUBO")
"""
import json
import os
from datetime import datetime, timezone
from pathlib import Path
import fcntl

TASKS_FILE = Path.home() / ".openclaw" / "data" / "agent-tasks.json"

def add_discovered_task(agent: str, task: str, source: str = "agent", ticker: str = None, max_keep: int = 50):
    """
    Append a discovered task to the agent's discovered_tasks list.
    Atomically writes via flock + os.replace. Keeps last `max_keep` discovered per agent.
    """
    if not TASKS_FILE.exists():
        return False

    entry = {
        "task": task,
        "source": source,
        "discovered_at": datetime.now(timezone.utc).isoformat(),
    }
    if ticker:
        entry["ticker"] = ticker

    tmp_file = TASKS_FILE.with_suffix(".json.tmp")
    with open(TASKS_FILE, "r+") as f:
        fcntl.flock(f, fcntl.LOCK_EX)
        try:
            data = json.load(f)
            agent_data = data.get("agents", {}).get(agent)
            if agent_data is None:
                return False
            disc = agent_data.setdefault("discovered_tasks", [])
            # Skip duplicates within last 24h
            recent = [d for d in disc if d.get("task") == task]
            if recent:
                return False
            disc.append(entry)
            # Keep most recent N
            agent_data["discovered_tasks"] = disc[-max_keep:]
            with open(tmp_file, "w") as t:
                json.dump(data, t, indent=2)
            os.replace(tmp_file, TASKS_FILE)
            return True
        finally:
            fcntl.flock(f, fcntl.LOCK_UN)
