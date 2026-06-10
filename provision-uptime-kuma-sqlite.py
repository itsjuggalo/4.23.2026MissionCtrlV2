#!/usr/bin/env python3
"""Provision Uptime Kuma monitors + Discord notification via direct SQLite insert."""
import sqlite3, json, os, datetime

DB = os.path.expanduser("~/uptime-kuma/data/kuma.db")
WEBHOOK = open(os.path.expanduser("~/.openclaw/secrets/discord_bobatrades_webhook")).read().strip()
USER_ID = 1
NOW = datetime.datetime.utcnow().strftime("%Y-%m-%d %H:%M:%S")

MONITORS = [
    ("MC Health",            "http://localhost:3000/api/health",           '"ok":true'),
    ("MC Status (Alpaca)",   "http://localhost:3000/api/status",            '"equity"'),
    ("MC Market Data",       "http://localhost:3000/api/market",            '"timestamp"'),
    ("MC Live Signals",      "http://localhost:3000/api/live-signals",      '"lastCycleTime"'),
    ("MC Signals Latest",    "http://localhost:3000/api/signals/latest",    None),
    ("MC Pipeline Feed",     "http://localhost:3000/api/pipeline-feed",     '"events"'),
    ("MC Agents",            "http://localhost:3000/api/agents",            '"success"'),
    ("MC Flow Database",     "http://localhost:3000/api/flow-database",     None),
    ("MC Options Flow",      "http://localhost:3000/api/options-flow",      None),
    ("MC Portfolio",         "http://localhost:3000/api/portfolio",         None),
    ("MC Trades",            "http://localhost:3000/api/trades",            None),
    ("MC Alerts DB",         "http://localhost:3000/api/alerts-db",        None),
    ("MC Regime",            "http://localhost:3000/api/regime",            None),
    ("MC Macro Regime",      "http://localhost:3000/api/macro-regime",      None),
    ("MC Calendar",          "http://localhost:3000/api/calendar",          None),
    ("MC Market News",       "http://localhost:3000/api/market-news",       None),
    ("MC Live Strategy",     "http://localhost:3000/api/live-strategy",     None),
    ("MC Desk Cycle",        "http://localhost:3000/api/desk-cycle",        None),
    ("MC Analyst Signals",   "http://localhost:3000/api/analyst-signals",   None),
    ("MC Telegram Signals",  "http://localhost:3000/api/telegram-signals",  None),
    ("MC Chart Signals",     "http://localhost:3000/api/chart-signals",     None),
    ("MC Activity",          "http://localhost:3000/api/activity",          None),
    ("MC Trade Log",         "http://localhost:3000/api/trade-log",         None),
    ("MC DB Status",         "http://localhost:3000/api/db-status",         None),
    ("MC Dashboard",         "http://localhost:3000/",                      None),
]

con = sqlite3.connect(DB)
cur = con.cursor()

print(f"Inserting {len(MONITORS)} monitors...")
for name, url, keyword in MONITORS:
    mtype = "keyword" if keyword else "http"
    cur.execute("""
        INSERT OR IGNORE INTO monitor
          (name, active, user_id, interval, url, type, weight, maxretries,
           ignore_tls, upside_down, maxredirects, accepted_statuscodes_json,
           retry_interval, method, created_date, keyword)
        VALUES (?,1,?,60,?,?,2000,2,0,0,10,'[\"200-299\"]',60,'GET',?,?)
    """, (name, USER_ID, url, mtype, NOW, keyword))
    print(f"  ✓ {name}")

# Discord notification
print("\nInserting Discord notification...")
config = json.dumps({
    "type": "discord",
    "webhookURL": WEBHOOK,
    "discordUsername": "Mission Control",
    "discordPrefixMessage": "🔴 MC Alert:",
})
cur.execute("""
    INSERT OR IGNORE INTO notification (name, active, user_id, is_default, config)
    VALUES ('Discord MC', 1, ?, 1, ?)
""", (USER_ID, config))

notif_id = cur.execute(
    "SELECT id FROM notification WHERE name='Discord MC' AND user_id=?", (USER_ID,)
).fetchone()[0]
print(f"  ✓ Discord notification id={notif_id} (is_default=1 — auto-applies to all monitors)")

# Link notification to all monitors
monitor_ids = [r[0] for r in cur.execute("SELECT id FROM monitor WHERE user_id=?", (USER_ID,)).fetchall()]
for mid in monitor_ids:
    cur.execute("INSERT OR IGNORE INTO monitor_notification (monitor_id, notification_id) VALUES (?,?)", (mid, notif_id))
print(f"  ✓ Linked Discord to {len(monitor_ids)} monitors")

con.commit()
con.close()
print("\nDone.")
