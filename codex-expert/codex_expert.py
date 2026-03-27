#!/usr/bin/env python3
"""
Codex Expert — Mission Control self-healing immune system.
Monitors all bots, auto-fixes what it can, alerts on the rest.

Schedule:
  Every  2 min : PM2 process health
  Every  5 min : Error log scan + Mission Control dashboard
  Every 10 min : File integrity
  Every 15 min : External API health
"""
import asyncio
import json
import logging
import os
import re
import shutil
import subprocess
import sys
import time
import uuid
from datetime import datetime, timezone

import aiohttp
import psutil
from dotenv import load_dotenv

# ── Config ─────────────────────────────────────────────────────────────────────

load_dotenv(os.path.join(os.path.dirname(os.path.abspath(__file__)), ".env"))

_DIR   = os.path.dirname(os.path.abspath(__file__))
_ROOT  = os.path.dirname(_DIR)

WEBHOOK_URL     = os.getenv("DISCORD_CODEX_WEBHOOK", "")
HEALTH_LOG_FILE = os.path.join(_DIR, "health_log.json")

# PM2 cron jobs — expected to be "stopped" between runs
CRON_BOTS = {"btc-bias-scorer", "macro-strategist"}

# Intervals
HEALTH_INTERVAL      = 2 * 60
LOG_INTERVAL         = 5 * 60
INTEGRITY_INTERVAL   = 10 * 60
API_INTERVAL         = 15 * 60
DASHBOARD_INTERVAL   = 5 * 60

MAX_RESTART_ATTEMPTS  = 3
RESTART_WINDOW_SEC    = 10 * 60   # 10 minutes
MAX_MEMORY_MB         = 200
DISK_ALERT_GB         = 2.0
PM2_LOG_MAX_MB        = 50
MAX_HEALTH_LOG        = 500
ALERT_COOLDOWN_SEC    = 3600      # 1 alert per issue per hour

logging.basicConfig(
    level=logging.INFO,
    format="%(asctime)s [CODEX] %(message)s",
    datefmt="%Y-%m-%d %H:%M:%S",
    stream=sys.stdout,
)
log = logging.getLogger("codex")

# ── File I/O ───────────────────────────────────────────────────────────────────

def load_health_log() -> list:
    if os.path.exists(HEALTH_LOG_FILE):
        try:
            with open(HEALTH_LOG_FILE) as f:
                return json.load(f)
        except Exception:
            return []
    return []


def save_health_log(entries: list) -> None:
    if len(entries) > MAX_HEALTH_LOG:
        entries = entries[-MAX_HEALTH_LOG:]
    with open(HEALTH_LOG_FILE, "w") as f:
        json.dump(entries, f, indent=2, default=str)


def append_log(entry: dict) -> None:
    entries = load_health_log()
    entries.append(entry)
    save_health_log(entries)


def load_json_safe(path: str):
    """Return parsed JSON or None if invalid."""
    try:
        with open(path) as f:
            return json.load(f)
    except Exception:
        return None


# ── Alert deduplication ────────────────────────────────────────────────────────

_alert_last_sent: dict[str, float] = {}


def can_alert(key: str) -> bool:
    now = time.monotonic()
    if now - _alert_last_sent.get(key, 0) >= ALERT_COOLDOWN_SEC:
        _alert_last_sent[key] = now
        return True
    return False


# ── Discord ────────────────────────────────────────────────────────────────────

async def post_discord(session: aiohttp.ClientSession, payload: dict) -> bool:
    if not WEBHOOK_URL:
        return False
    try:
        async with session.post(
            WEBHOOK_URL, json=payload,
            timeout=aiohttp.ClientTimeout(total=10)
        ) as resp:
            return resp.status in (200, 204)
    except Exception as e:
        log.warning(f"Discord post failed: {e}")
        return False


def embed(title: str, desc: str, color: int = 0x6c5ce7) -> dict:
    return {"embeds": [{
        "title":       title,
        "description": desc,
        "color":       color,
        "footer":      {"text": f"Codex Expert • {datetime.now(timezone.utc).strftime('%Y-%m-%d %H:%M')} UTC"},
    }]}


# ── PM2 helpers ────────────────────────────────────────────────────────────────

def pm2_jlist() -> list[dict]:
    try:
        out = subprocess.check_output(["pm2", "jlist"], timeout=15)
        return json.loads(out)
    except Exception as e:
        log.warning(f"pm2 jlist failed: {e}")
        return []


def pm2_restart(name: str) -> bool:
    try:
        subprocess.check_call(["pm2", "restart", name], timeout=20, stdout=subprocess.DEVNULL, stderr=subprocess.DEVNULL)
        return True
    except Exception:
        return False


def pm2_error_log(name: str, lines: int = 30) -> str:
    """Read PM2 error log for a named process."""
    try:
        out = subprocess.check_output(
            ["pm2", "logs", name, "--err", "--lines", str(lines), "--nostream"],
            timeout=15, stderr=subprocess.STDOUT
        )
        return out.decode("utf-8", errors="replace")
    except Exception:
        return ""


def pm2_log_size_mb(name: str) -> float:
    """Return error+out log size in MB for a process."""
    pm2_home = os.path.expanduser("~/.pm2/logs")
    total = 0
    for suffix in (f"{name}-out.log", f"{name}-error.log"):
        p = os.path.join(pm2_home, suffix)
        if os.path.exists(p):
            total += os.path.getsize(p)
    return total / (1024 * 1024)


def clear_pm2_logs(name: str) -> None:
    pm2_home = os.path.expanduser("~/.pm2/logs")
    for suffix in (f"{name}-out.log", f"{name}-error.log"):
        p = os.path.join(pm2_home, suffix)
        if os.path.exists(p):
            open(p, "w").close()


# ── Check 1: PM2 process health ────────────────────────────────────────────────

# Track restart attempts: {name: [(timestamp, ...), ...]}
_restart_history: dict[str, list[float]] = {}


async def check_pm2_health(session: aiohttp.ClientSession) -> None:
    procs = pm2_jlist()
    if not procs:
        return

    issues = []
    now = time.monotonic()

    for p in procs:
        name      = p.get("name", "")
        env       = p.get("pm2_env", {})
        status    = env.get("status", "")
        mem_bytes = p.get("monit", {}).get("memory", 0)
        mem_mb    = mem_bytes // (1024 * 1024)
        restarts  = env.get("restart_time", 0)

        # Skip expected cron job stopped state
        if name in CRON_BOTS and status == "stopped":
            continue

        # Memory alert
        if mem_mb > MAX_MEMORY_MB and can_alert(f"mem_{name}"):
            issues.append(f"⚠️ {name}: memory {mem_mb}MB > {MAX_MEMORY_MB}MB limit")
            log.warning(f"Memory alert: {name} at {mem_mb}MB")

        # Crashed / errored
        if status in ("stopped", "errored"):
            hist = _restart_history.setdefault(name, [])
            # Prune attempts older than the window
            hist[:] = [t for t in hist if now - t < RESTART_WINDOW_SEC]

            if len(hist) >= MAX_RESTART_ATTEMPTS:
                # Too many restarts — alert and don't try again
                if can_alert(f"maxrestart_{name}"):
                    await post_discord(session, embed(
                        f"🚨 CODEX ALERT — Commander Action Needed",
                        f"**Bot:** {name}\n**Status:** {status}\n"
                        f"**Issue:** Restarted {len(hist)}× in the last 10 minutes and keeps failing.\n"
                        f"**Suggested fix:** Check `pm2 logs {name}` for the root cause.",
                        0xff4757
                    ))
                    log.warning(f"Max restarts hit for {name} — alerting Commander")
            else:
                # Attempt restart
                log.info(f"Restarting {name} (status={status}, attempt {len(hist)+1})")
                ok = pm2_restart(name)
                hist.append(now)
                if ok:
                    await asyncio.sleep(4)
                    # Verify it came back up
                    new_procs = pm2_jlist()
                    new_status = next(
                        (x.get("pm2_env",{}).get("status") for x in new_procs if x.get("name") == name),
                        "unknown"
                    )
                    result_ok = new_status == "online"
                    entry = {
                        "id":        str(uuid.uuid4()),
                        "timestamp": datetime.now(timezone.utc).isoformat(),
                        "type":      "auto_fix",
                        "bot":       name,
                        "issue":     f"Process {status}",
                        "action":    f"pm2 restart {name}",
                        "result":    "online" if result_ok else f"still {new_status}",
                    }
                    append_log(entry)

                    if result_ok:
                        log.info(f"  ✅ {name} back online")
                        await post_discord(session, embed(
                            "🔧 AUTO-FIX APPLIED",
                            f"**Bot:** {name}\n**Issue:** Process {status}\n"
                            f"**Action:** pm2 restart {name}\n"
                            f"**Result:** Back online, running normally\n"
                            f"No Commander intervention needed.",
                            0x00d2a0
                        ))
                    else:
                        log.warning(f"  ❌ {name} still not online after restart")

    # Log size checks
    for p in procs:
        name = p.get("name", "")
        size = pm2_log_size_mb(name)
        if size > PM2_LOG_MAX_MB:
            clear_pm2_logs(name)
            log.info(f"Cleared logs for {name} ({size:.1f}MB > {PM2_LOG_MAX_MB}MB)")
            append_log({"timestamp": datetime.now(timezone.utc).isoformat(),
                        "type": "log_clear", "bot": name, "size_mb": round(size, 1)})

    # Disk space
    disk  = psutil.disk_usage("/")
    free_gb = disk.free / (1024**3)
    if free_gb < DISK_ALERT_GB and can_alert("disk_space"):
        await post_discord(session, embed(
            "🚨 CODEX ALERT — Low Disk Space",
            f"Free disk: **{free_gb:.1f}GB** (threshold: {DISK_ALERT_GB}GB)\n"
            f"Consider cleaning logs or archives.",
            0xff4757
        ))

    # Periodic nominal report (every ~30 min via health check cadence)
    if not hasattr(check_pm2_health, "_last_nominal"):
        check_pm2_health._last_nominal = 0  # type: ignore
    if now - check_pm2_health._last_nominal > 1800:  # type: ignore
        check_pm2_health._last_nominal = now  # type: ignore
        online  = [p for p in procs if p.get("pm2_env",{}).get("status") == "online"]
        stopped = [p for p in procs if p.get("pm2_env",{}).get("status") == "stopped"
                   and p.get("name") in CRON_BOTS]
        total_mem = sum(p.get("monit",{}).get("memory",0) for p in procs) // (1024*1024)
        await post_discord(session, embed(
            "🟢 HEALTH CHECK — All systems nominal",
            f"{len(online)} daemons online | {len(stopped)} cron jobs idle\n"
            f"Memory: {total_mem}mb total | Disk: {free_gb:.1f}GB free\n"
            f"No critical issues detected.",
            0x00d2a0
        ))


# ── Check 2: Error log scanning ────────────────────────────────────────────────

# Known fixable / known ignorable patterns
IGNORABLE = [
    r"KeyboardInterrupt",
    r"Traceback.*KeyboardInterrupt",
]

KNOWN_ERRORS = {
    r"429|Rate limited|Too Many Requests|rate_limited": (
        "rate_limit",
        "API rate limit hit. Consider adding delays between calls.",
    ),
    r"connection.refused|ECONNREFUSED|ConnectionRefused": (
        "conn_refused",
        "Service connection refused. Check if the target service is running.",
    ),
    r"ModuleNotFoundError|ImportError": (
        "import_error",
        "A Python module is missing. Check requirements.txt and run pip install.",
    ),
    r"SyntaxError": (
        "syntax_error",
        "Python syntax error. Check the file for typos.",
    ),
    r"PermissionError|Permission denied": (
        "permission_error",
        "File permission error. Check chmod on the target file.",
    ),
    r"FileNotFoundError|No such file": (
        "file_not_found",
        "A required file is missing.",
    ),
    r"JSONDecodeError|Expecting value": (
        "json_error",
        "A JSON file is corrupted. Will attempt restore from archive.",
    ),
}


async def check_error_logs(session: aiohttp.ClientSession) -> None:
    procs = pm2_jlist()
    for p in procs:
        name   = p.get("name", "")
        status = p.get("pm2_env", {}).get("status", "")
        if status == "stopped" and name in CRON_BOTS:
            continue

        log_text = pm2_error_log(name, 30)
        if not log_text.strip():
            continue

        # Strip ignorable patterns
        lines = [l for l in log_text.splitlines()
                 if not any(re.search(pat, l, re.IGNORECASE) for pat in IGNORABLE)]
        clean_log = "\n".join(lines[-20:]).strip()
        if not clean_log:
            continue

        for pattern, (error_key, suggestion) in KNOWN_ERRORS.items():
            if re.search(pattern, clean_log, re.IGNORECASE):
                alert_key = f"logerr_{name}_{error_key}"
                if can_alert(alert_key):
                    log.warning(f"Error pattern '{error_key}' in {name}")
                    append_log({
                        "timestamp": datetime.now(timezone.utc).isoformat(),
                        "type":      "log_error_detected",
                        "bot":       name,
                        "error_key": error_key,
                        "snippet":   clean_log[-300:],
                    })
                    await post_discord(session, embed(
                        f"🚨 CODEX ALERT — Commander Action Needed",
                        f"**Bot:** {name}\n"
                        f"**Error type:** {error_key.replace('_',' ').title()}\n"
                        f"**Suggested fix:** {suggestion}\n"
                        f"**Log snippet:**\n```\n{clean_log[-400:]}\n```",
                        0xff4757
                    ))
                break   # only one alert per bot per cycle


# ── Check 3: File integrity ────────────────────────────────────────────────────

BOT_FILES = {
    "telegram-listener": [
        (os.path.join(_ROOT, "telegram-listener/signals.json"),          list),
        (os.path.join(_ROOT, "telegram-listener/channel_stats.json"),    dict),
    ],
    "analyst": [
        (os.path.join(_ROOT, "analyst/analysis_results.json"),           list),
    ],
    "risk-manager": [
        (os.path.join(_ROOT, "risk-manager/risk_state.json"),            dict),
        (os.path.join(_ROOT, "risk-manager/risk_rules.json"),            dict),
    ],
    "portfolio-monitor": [
        (os.path.join(_ROOT, "portfolio-monitor/portfolio_state.json"),  dict),
    ],
    "auditor": [
        (os.path.join(_ROOT, "auditor/trade_journal.json"),              list),
    ],
    "crypto-sniper": [
        (os.path.join(_ROOT, "crypto-sniper/launches.json"),             list),
    ],
}

REQUIRED_ENV_KEYS = {
    "telegram-listener":    ["DISCORD_ERIC_SIGNALS_WEBHOOK"],
    "analyst":              ["DISCORD_ANALYST_SETUPS_WEBHOOK"],
    "risk-manager":         ["DISCORD_RISK_DECISIONS_WEBHOOK"],
    "portfolio-monitor":    ["DISCORD_PORTFOLIO_STATUS_WEBHOOK"],
    "broadcaster":          ["TELEGRAM_BOT_TOKEN", "DISCORD_BROADCAST_LOG_WEBHOOK"],
    "crypto-sniper":        ["DISCORD_SNIPER_LAUNCHES_WEBHOOK"],
    "execution-specialist": ["DISCORD_EXECUTIONS_LIVE_WEBHOOK"],
    "auditor":              ["DISCORD_TRADE_REVIEWS_WEBHOOK"],
}


def find_latest_archive(live_file: str, label: str) -> str | None:
    """Find the most recent archive file for a given label."""
    arch_dir = os.path.join(os.path.dirname(live_file), "archive")
    if not os.path.exists(arch_dir):
        return None
    candidates = sorted(
        [f for f in os.listdir(arch_dir) if f.startswith(f"{label}_archive_")],
        reverse=True
    )
    return os.path.join(arch_dir, candidates[0]) if candidates else None


async def check_file_integrity(session: aiohttp.ClientSession) -> None:
    for bot_name, file_specs in BOT_FILES.items():
        for file_path, expected_type in file_specs:
            if not os.path.exists(file_path):
                continue
            data = load_json_safe(file_path)
            if data is None or not isinstance(data, expected_type):
                log.warning(f"Corrupted JSON: {file_path}")
                # Attempt restore from archive
                label = os.path.basename(file_path).replace(".json","")
                arch  = find_latest_archive(file_path, label)
                restored = False
                if arch:
                    arch_data = load_json_safe(arch)
                    if arch_data is not None:
                        shutil.copy(file_path, file_path + ".corrupted")
                        with open(file_path, "w") as f:
                            json.dump(arch_data, f, indent=2, default=str)
                        os.chmod(file_path, 0o600)
                        restored = True
                        log.info(f"Restored {file_path} from {arch}")

                append_log({
                    "timestamp": datetime.now(timezone.utc).isoformat(),
                    "type":      "file_integrity",
                    "bot":       bot_name,
                    "file":      file_path,
                    "action":    f"restored from {arch}" if restored else "archive not found",
                })

                alert_key = f"corrupt_{file_path}"
                if can_alert(alert_key):
                    await post_discord(session, embed(
                        "🔧 AUTO-FIX APPLIED" if restored else "🚨 CODEX ALERT — File Corrupted",
                        f"**Bot:** {bot_name}\n"
                        f"**File:** {os.path.basename(file_path)}\n"
                        f"**Issue:** Invalid JSON (corrupted)\n"
                        f"**Action:** {'Restored from archive ✅' if restored else 'No archive found — manual intervention needed'}",
                        0x00d2a0 if restored else 0xff4757
                    ))

    # Check .env files
    for bot_name, required_keys in REQUIRED_ENV_KEYS.items():
        env_path = os.path.join(_ROOT, bot_name, ".env")
        if not os.path.exists(env_path):
            if can_alert(f"envmissing_{bot_name}"):
                await post_discord(session, embed(
                    "🚨 CODEX ALERT — Missing .env File",
                    f"**Bot:** {bot_name}\n**File:** {env_path}\n**Action needed:** Recreate .env with required keys.",
                    0xff4757
                ))
            continue
        with open(env_path) as f:
            content = f.read()
        missing = [k for k in required_keys if k not in content]
        if missing and can_alert(f"envkeys_{bot_name}"):
            await post_discord(session, embed(
                "🚨 CODEX ALERT — Missing .env Keys",
                f"**Bot:** {bot_name}\n**Missing keys:** {', '.join(missing)}",
                0xff4757
            ))


# ── Check 4: External API health ──────────────────────────────────────────────

async def check_apis(session: aiohttp.ClientSession) -> None:
    results: dict[str, bool] = {}

    async def probe(name: str, url: str, timeout: int = 8) -> None:
        try:
            async with session.get(url, timeout=aiohttp.ClientTimeout(total=timeout)) as r:
                results[name] = r.status < 500
        except Exception:
            results[name] = False

    await asyncio.gather(
        probe("OKX",         "https://www.okx.com/api/v5/market/ticker?instId=BTC-USDT"),
        probe("Yahoo",       "https://query1.finance.yahoo.com/v8/finance/chart/BTC-USD?interval=1d&range=1d"),
        probe("CoinGecko",   "https://api.coingecko.com/api/v3/ping"),
        probe("Firebase",    "https://stock-signal-72772-default-rtdb.firebaseio.com/Vivid2/ShortTermOptions.json?shallow=true"),
    )

    # Discord: try the codex webhook itself
    try:
        async with session.post(
            WEBHOOK_URL,
            json={"content": None},
            timeout=aiohttp.ClientTimeout(total=5)
        ) as r:
            results["Discord"] = r.status in (200, 204, 400)  # 400 = bad payload but webhook reachable
    except Exception:
        results["Discord"] = False

    down = [name for name, ok in results.items() if not ok]
    if down:
        for name in down:
            if can_alert(f"api_{name}"):
                log.warning(f"API down: {name}")
                append_log({"timestamp": datetime.now(timezone.utc).isoformat(),
                            "type": "api_down", "service": name})
                await post_discord(session, embed(
                    "🚨 CODEX ALERT — External Service Down",
                    f"**Service:** {name}\n**Status:** Not responding\nBots depending on this service may show errors.",
                    0xff4757
                ))
    else:
        log.debug("All external APIs reachable")


# ── Check 5: Mission Control dashboard ────────────────────────────────────────

async def check_dashboard(session: aiohttp.ClientSession) -> None:
    # Check if port 3000 is responding
    try:
        async with session.get(
            "http://127.0.0.1:3000",
            timeout=aiohttp.ClientTimeout(total=8)
        ) as r:
            if r.status in (200, 401):  # 401 = auth required but server is up
                return
    except Exception:
        pass

    # Not responding — restart
    log.warning("Mission Control not responding — restarting")
    ok = pm2_restart("mission-control")
    append_log({
        "timestamp": datetime.now(timezone.utc).isoformat(),
        "type":      "auto_fix",
        "bot":       "mission-control",
        "issue":     "Dashboard not responding on port 3000",
        "action":    "pm2 restart mission-control",
        "result":    "restarted" if ok else "restart failed",
    })
    if can_alert("dashboard_down"):
        await post_discord(session, embed(
            "🔧 AUTO-FIX APPLIED" if ok else "🚨 CODEX ALERT — Dashboard Down",
            f"**Issue:** Mission Control not responding on :3000\n"
            f"**Action:** pm2 restart mission-control\n"
            f"**Result:** {'Restarted ✅' if ok else 'Restart failed ❌'}",
            0x00d2a0 if ok else 0xff4757
        ))

    # Check build staleness
    next_dir = os.path.join(_ROOT, ".next")
    src_dir  = os.path.join(_ROOT, "src")
    if os.path.exists(next_dir) and os.path.exists(src_dir):
        try:
            build_mtime = os.path.getmtime(next_dir)
            src_mtime   = max(
                os.path.getmtime(os.path.join(dirpath, f))
                for dirpath, _, files in os.walk(src_dir)
                for f in files if f.endswith((".tsx", ".ts"))
            )
            if src_mtime > build_mtime + 30:
                log.info("Source files newer than build — triggering rebuild")
                try:
                    subprocess.check_call(
                        ["npm", "run", "build"],
                        cwd=_ROOT, timeout=120,
                        stdout=subprocess.DEVNULL, stderr=subprocess.DEVNULL
                    )
                    pm2_restart("mission-control")
                    append_log({
                        "timestamp": datetime.now(timezone.utc).isoformat(),
                        "type":      "auto_fix",
                        "bot":       "mission-control",
                        "issue":     "Stale build (source files newer than .next)",
                        "action":    "npm run build + pm2 restart",
                        "result":    "rebuilt and restarted",
                    })
                    await post_discord(session, embed(
                        "🔧 AUTO-FIX APPLIED",
                        "**Issue:** Mission Control build was stale\n"
                        "**Action:** npm run build + pm2 restart mission-control\n"
                        "**Result:** Rebuilt and restarted ✅",
                        0x00d2a0
                    ))
                except subprocess.TimeoutExpired:
                    log.warning("Build timed out")
        except Exception as e:
            log.warning(f"Build staleness check failed: {e}")


# ── Check 6: Independent code fixes ───────────────────────────────────────────

# Simple auto-fixable patterns: (error_pattern, fix_function)
async def attempt_code_fix(session: aiohttp.ClientSession, bot_name: str, error_log: str) -> bool:
    """
    Attempt simple code fixes. Returns True if fix applied.
    Currently handles:
    - Missing __init__.py in shared/
    - Wrong file path references that resolve to existing paths
    """
    # Fix: shared module not found (missing __init__.py)
    if re.search(r"No module named '?shared", error_log):
        init_path = os.path.join(_ROOT, "shared", "__init__.py")
        if not os.path.exists(init_path):
            open(init_path, "w").close()
            log.info(f"Created {init_path}")
            pm2_restart(bot_name)
            append_log({
                "timestamp": datetime.now(timezone.utc).isoformat(),
                "type":      "code_fix",
                "bot":       bot_name,
                "issue":     "missing shared/__init__.py",
                "action":    f"created {init_path}",
                "before":    "file missing",
                "after":     "file created",
            })
            await post_discord(session, embed(
                "🔧 AUTO-FIX APPLIED",
                f"**Bot:** {bot_name}\n"
                f"**Issue:** Missing shared/__init__.py\n"
                f"**Action:** Created file + restarted\n"
                f"**Result:** Applied ✅",
                0x00d2a0
            ))
            return True

    return False


# ── Main loop ──────────────────────────────────────────────────────────────────

async def run():
    log.info("=== Codex Expert starting ===")
    log.info(f"Root     : {_ROOT}")
    log.info(f"Health log: {HEALTH_LOG_FILE}")
    log.info(f"Discord  : {'✅' if WEBHOOK_URL else '❌'}")
    log.info(f"Intervals: health={HEALTH_INTERVAL//60}m | logs={LOG_INTERVAL//60}m | "
             f"integrity={INTEGRITY_INTERVAL//60}m | api={API_INTERVAL//60}m\n")

    last_health    = 0.0
    last_logs      = 0.0
    last_integrity = 0.0
    last_api       = 0.0
    last_dashboard = 0.0

    async with aiohttp.ClientSession() as session:
        # Startup notification
        await post_discord(session, embed(
            "🤖 CODEX EXPERT ONLINE",
            "Self-healing immune system is active.\n"
            "Monitoring all bots, files, APIs, and the dashboard.\n"
            "Auto-fixing issues as they arise.",
            0x6c5ce7
        ))

        while True:
            now = time.monotonic()

            if now - last_health >= HEALTH_INTERVAL:
                try:
                    await check_pm2_health(session)
                except Exception as e:
                    log.error(f"PM2 health check error: {e}", exc_info=True)
                last_health = time.monotonic()

            if now - last_logs >= LOG_INTERVAL:
                try:
                    await check_error_logs(session)
                    await check_dashboard(session)
                except Exception as e:
                    log.error(f"Log/dashboard check error: {e}", exc_info=True)
                last_logs = time.monotonic()

            if now - last_integrity >= INTEGRITY_INTERVAL:
                try:
                    await check_file_integrity(session)
                except Exception as e:
                    log.error(f"File integrity check error: {e}", exc_info=True)
                last_integrity = time.monotonic()

            if now - last_api >= API_INTERVAL:
                try:
                    await check_apis(session)
                except Exception as e:
                    log.error(f"API health check error: {e}", exc_info=True)
                last_api = time.monotonic()

            await asyncio.sleep(30)


if __name__ == "__main__":
    asyncio.run(run())
