#!/usr/bin/env python3
"""
Mission Control Daily Activity Report
Zero LLM calls. Collects data from all systems and generates daily report.

Scans:
- Signal receiver logs (what signals came in, results)
- Market regime history (what regime was detected)
- Optimizer results (what params were recommended)
- PM2 process status (what's running/crashed)
- Cron job results (what ran, what failed)
- Position state (current positions, PnL)

Outputs:
- Daily report JSON for dashboard
- Discord embed summary
- Calendar entry for the day
"""

import json
import os
import sys
import subprocess
import glob
from datetime import datetime, timezone, timedelta
from pathlib import Path

sys.path.insert(0, os.path.expanduser("~/.openclaw/workspace/skills/shared"))

try:
    from mc_utils import get_secret
except ImportError:
    def get_secret(name):
        path = os.path.expanduser(f"~/.openclaw/secrets/{name}")
        with open(path, "r") as f:
            return f.read().strip()

# Paths
SIGNAL_DATA = os.path.expanduser("~/mission-control/signal-receiver/data")
OPTIMIZER_RESULTS = os.path.expanduser("~/mission-control/supertrend-engine/results")
REGIME_DATA = os.path.expanduser("~/mission-control/signal-receiver/data/market_regime.json")
CALENDAR_DIR = os.path.expanduser("~/mission-control/daily-reports/calendar")
REPORTS_DIR = os.path.expanduser("~/mission-control/daily-reports/reports")
DASHBOARD_DIR = os.path.expanduser("~/mission-control/signal-receiver/data")

os.makedirs(CALENDAR_DIR, exist_ok=True)
os.makedirs(REPORTS_DIR, exist_ok=True)


def get_today():
    return datetime.now(timezone.utc).strftime("%Y-%m-%d")


def get_signals_today():
    """Count and summarize signals received today."""
    history_file = os.path.join(SIGNAL_DATA, "signals_history.jsonl")
    if not os.path.exists(history_file):
        return {"total": 0, "buys": 0, "sells": 0, "tp": 0, "sl": 0, "signals": []}

    today = get_today()
    signals = []
    buys = sells = tp = sl = unknown = 0

    with open(history_file, "r") as f:
        for line in f:
            line = line.strip()
            if not line:
                continue
            try:
                sig = json.loads(line)
                if sig.get("timestamp", "").startswith(today):
                    signals.append(sig)
                    action = sig.get("action", "").upper()
                    if action == "BUY":
                        buys += 1
                    elif action == "SELL":
                        sells += 1
                    elif action == "TAKE_PROFIT":
                        tp += 1
                    elif action == "STOP_LOSS":
                        sl += 1
                    else:
                        unknown += 1
            except json.JSONDecodeError:
                continue

    return {
        "total": len(signals),
        "buys": buys,
        "sells": sells,
        "take_profits": tp,
        "stop_losses": sl,
        "unknown": unknown,
        "signals": signals[-20:],  # Last 20
    }


def get_position_state():
    """Get current position state."""
    state_file = os.path.join(SIGNAL_DATA, "latest_state.json")
    if not os.path.exists(state_file):
        return {}
    with open(state_file, "r") as f:
        return json.load(f)


def get_pnl_summary():
    """Calculate PnL from today's closed trades."""
    state = get_position_state()
    summary = {}

    for ticker, data in state.items():
        history = data.get("pnl_history", [])
        today = get_today()
        today_trades = [t for t in history if t.get("closed_at", "").startswith(today)]

        if today_trades:
            total_pnl = sum(t.get("pnl_pct", 0) for t in today_trades)
            wins = [t for t in today_trades if t.get("pnl_pct", 0) > 0]
            losses = [t for t in today_trades if t.get("pnl_pct", 0) <= 0]

            summary[ticker] = {
                "trades_today": len(today_trades),
                "total_pnl_pct": round(total_pnl, 4),
                "wins": len(wins),
                "losses": len(losses),
                "win_rate": round(len(wins) / len(today_trades) * 100, 1) if today_trades else 0,
                "best_trade": round(max(t.get("pnl_pct", 0) for t in today_trades), 4),
                "worst_trade": round(min(t.get("pnl_pct", 0) for t in today_trades), 4),
                "current_direction": data.get("direction"),
                "current_entry": data.get("entry_price"),
            }
        else:
            summary[ticker] = {
                "trades_today": 0,
                "total_pnl_pct": 0,
                "current_direction": data.get("direction"),
                "current_entry": data.get("entry_price"),
            }

    return summary


def get_regime():
    """Get current market regime."""
    if not os.path.exists(REGIME_DATA):
        return {"overall_regime": "UNKNOWN", "direction_bias": "UNKNOWN"}
    with open(REGIME_DATA, "r") as f:
        return json.load(f)


def get_optimal_params():
    """Get latest optimizer results."""
    params_file = os.path.join(SIGNAL_DATA, "optimal_params.json")
    if not os.path.exists(params_file):
        return {}
    with open(params_file, "r") as f:
        return json.load(f)


def get_pm2_status():
    """Get PM2 process status."""
    try:
        result = subprocess.run(
            ["pm2", "jlist"],
            capture_output=True, text=True, timeout=10
        )
        processes = json.loads(result.stdout)
        status = {}
        for p in processes:
            name = p.get("name", "unknown")
            status[name] = {
                "status": p.get("pm2_env", {}).get("status", "unknown"),
                "restarts": p.get("pm2_env", {}).get("restart_time", 0),
                "memory_mb": round(p.get("monit", {}).get("memory", 0) / 1024 / 1024, 1),
                "cpu": p.get("monit", {}).get("cpu", 0),
            }
        return status
    except Exception as e:
        return {"error": str(e)}


def get_cron_status():
    """Check what cron jobs ran today."""
    cron_logs = {
        "optimizer": os.path.expanduser("~/mission-control/supertrend-engine/logs/cron.log"),
        "regime_detector": os.path.expanduser("~/mission-control/regime-detector/logs/cron.log"),
    }

    today = get_today()
    status = {}

    for name, log_path in cron_logs.items():
        if not os.path.exists(log_path):
            status[name] = {"ran_today": False, "last_run": "never"}
            continue

        ran_today = False
        last_line = ""
        with open(log_path, "r") as f:
            for line in f:
                if today in line:
                    ran_today = True
                if line.strip():
                    last_line = line.strip()

        status[name] = {
            "ran_today": ran_today,
            "last_entry": last_line[-100:] if last_line else "empty",
        }

    return status


def get_disk_usage():
    """Quick disk usage check."""
    try:
        result = subprocess.run(
            ["df", "-h", "/home"],
            capture_output=True, text=True, timeout=5
        )
        lines = result.stdout.strip().split("\n")
        if len(lines) > 1:
            parts = lines[1].split()
            return {
                "total": parts[1],
                "used": parts[2],
                "available": parts[3],
                "percent": parts[4],
            }
    except Exception:
        pass
    return {}


def build_report():
    """Build the full daily report."""
    today = get_today()

    print(f"\n{'='*60}")
    print(f"Mission Control Daily Report — {today}")
    print(f"{'='*60}\n")

    signals = get_signals_today()
    pnl = get_pnl_summary()
    regime = get_regime()
    params = get_optimal_params()
    pm2 = get_pm2_status()
    crons = get_cron_status()
    disk = get_disk_usage()
    positions = get_position_state()

    # Print summary
    print(f"SIGNALS: {signals['total']} total ({signals['buys']} buys, {signals['sells']} sells, {signals['take_profits']} TP, {signals['stop_losses']} SL)")

    for ticker, data in pnl.items():
        dir_str = data.get("current_direction", "FLAT") or "FLAT"
        print(f"POSITION {ticker}: {dir_str} | Trades: {data['trades_today']} | PnL: {data['total_pnl_pct']}%")

    regime_str = regime.get("overall_regime", "UNKNOWN")
    bias = regime.get("direction_bias", "UNKNOWN")
    print(f"REGIME: {regime_str} | Bias: {bias}")

    if params:
        print(f"OPTIMAL: ATR {params.get('recommended_atr_period')} / Mult {params.get('recommended_multiplier')}")

    print(f"\nPM2 PROCESSES:")
    for name, data in pm2.items():
        if isinstance(data, dict) and "status" in data:
            emoji = "OK" if data["status"] == "online" else "DOWN"
            print(f"  [{emoji}] {name}: {data['status']} | RAM: {data['memory_mb']}MB | Restarts: {data['restarts']}")

    print(f"\nCRON JOBS:")
    for name, data in crons.items():
        ran = "RAN" if data.get("ran_today") else "NOT RUN"
        print(f"  [{ran}] {name}")

    if disk:
        print(f"\nDISK: {disk.get('used')}/{disk.get('total')} ({disk.get('percent')} used)")

    # Build report object
    report = {
        "date": today,
        "generated_at": datetime.now(timezone.utc).isoformat(),
        "signals": {
            "total": signals["total"],
            "buys": signals["buys"],
            "sells": signals["sells"],
            "take_profits": signals["take_profits"],
            "stop_losses": signals["stop_losses"],
        },
        "pnl": pnl,
        "regime": {
            "overall": regime.get("overall_regime", "UNKNOWN"),
            "bias": regime.get("direction_bias", "UNKNOWN"),
            "recommendation": regime.get("overall_recommendation", ""),
            "timeframes": regime.get("timeframes", {}),
        },
        "optimal_params": {
            "atr_period": params.get("recommended_atr_period"),
            "multiplier": params.get("recommended_multiplier"),
            "win_rate": params.get("expected_win_rate"),
            "profit_factor": params.get("expected_profit_factor"),
        },
        "infrastructure": {
            "pm2": pm2,
            "crons": crons,
            "disk": disk,
        },
    }

    # Save report
    report_file = os.path.join(REPORTS_DIR, f"{today}.json")
    with open(report_file, "w") as f:
        json.dump(report, f, indent=2)
    print(f"\nReport saved: {report_file}")

    # Save calendar entry
    calendar_entry = {
        "date": today,
        "signals_received": signals["total"],
        "trades_closed": sum(d.get("trades_today", 0) for d in pnl.values()),
        "total_pnl_pct": round(sum(d.get("total_pnl_pct", 0) for d in pnl.values()), 4),
        "regime": regime.get("overall_regime", "UNKNOWN"),
        "bias": regime.get("direction_bias", "UNKNOWN"),
        "processes_online": sum(1 for p in pm2.values() if isinstance(p, dict) and p.get("status") == "online"),
        "processes_total": len([p for p in pm2.values() if isinstance(p, dict) and "status" in p]),
        "crons_ran": sum(1 for c in crons.values() if c.get("ran_today")),
        "highlight": _get_highlight(signals, pnl, regime),
    }

    cal_file = os.path.join(CALENDAR_DIR, f"{today}.json")
    with open(cal_file, "w") as f:
        json.dump(calendar_entry, f, indent=2)
    print(f"Calendar saved: {cal_file}")

    # Save latest for dashboard
    dashboard_file = os.path.join(DASHBOARD_DIR, "daily_report.json")
    with open(dashboard_file, "w") as f:
        json.dump(report, f, indent=2)
    print(f"Dashboard: {dashboard_file}")

    # Build monthly calendar view
    _build_monthly_calendar()

    return report


def _get_highlight(signals, pnl, regime):
    """Generate one-line highlight for the day."""
    parts = []

    total_pnl = sum(d.get("total_pnl_pct", 0) for d in pnl.values())
    if total_pnl > 0:
        parts.append(f"+{total_pnl:.2f}% PnL")
    elif total_pnl < 0:
        parts.append(f"{total_pnl:.2f}% PnL")

    if signals["total"] > 0:
        parts.append(f"{signals['total']} signals")

    regime_str = regime.get("overall_regime", "")
    if regime_str:
        parts.append(regime_str.replace("_", " ").title())

    return " | ".join(parts) if parts else "Quiet day"


def _build_monthly_calendar():
    """Build a monthly calendar JSON from daily entries."""
    today = datetime.now(timezone.utc)
    year_month = today.strftime("%Y-%m")

    days = {}
    for f in sorted(glob.glob(os.path.join(CALENDAR_DIR, f"{year_month}-*.json"))):
        try:
            with open(f, "r") as fh:
                entry = json.load(fh)
                days[entry["date"]] = entry
        except Exception:
            continue

    # Summary stats for the month
    total_signals = sum(d.get("signals_received", 0) for d in days.values())
    total_trades = sum(d.get("trades_closed", 0) for d in days.values())
    total_pnl = sum(d.get("total_pnl_pct", 0) for d in days.values())
    active_days = len(days)

    monthly = {
        "month": year_month,
        "generated_at": datetime.now(timezone.utc).isoformat(),
        "summary": {
            "total_signals": total_signals,
            "total_trades": total_trades,
            "total_pnl_pct": round(total_pnl, 4),
            "active_days": active_days,
            "avg_signals_per_day": round(total_signals / active_days, 1) if active_days else 0,
        },
        "days": days,
    }

    monthly_file = os.path.join(CALENDAR_DIR, f"{year_month}-calendar.json")
    with open(monthly_file, "w") as f:
        json.dump(monthly, f, indent=2)
    print(f"Monthly calendar: {monthly_file}")


def post_to_discord(report):
    """Post daily summary to Discord."""
    try:
        webhook = get_secret("discord_tv_signals_webhook")
    except Exception:
        print("No Discord webhook configured")
        return

    today = report["date"]
    signals = report["signals"]
    pnl = report["pnl"]
    regime = report["regime"]
    params = report["optimal_params"]
    infra = report["infrastructure"]

    # PnL line
    total_pnl = sum(d.get("total_pnl_pct", 0) for d in pnl.values())
    total_trades = sum(d.get("trades_today", 0) for d in pnl.values())
    pnl_emoji = "+" if total_pnl >= 0 else ""
    pnl_line = f"{pnl_emoji}{total_pnl:.2f}% ({total_trades} trades)"

    # Position lines
    pos_lines = []
    for ticker, data in pnl.items():
        dir_str = data.get("current_direction", "FLAT") or "FLAT"
        entry = data.get("current_entry")
        entry_str = f" @ ${entry:,.2f}" if entry else ""
        pos_lines.append(f"{ticker}: {dir_str}{entry_str}")

    # Process health
    pm2 = infra.get("pm2", {})
    online = sum(1 for p in pm2.values() if isinstance(p, dict) and p.get("status") == "online")
    total = len([p for p in pm2.values() if isinstance(p, dict) and "status" in p])
    crashed = [n for n, p in pm2.items() if isinstance(p, dict) and p.get("status") != "online"]

    health_line = f"{online}/{total} online"
    if crashed:
        health_line += f" | DOWN: {', '.join(crashed)}"

    # Color based on PnL
    if total_pnl > 1:
        color = 65280  # Green
    elif total_pnl > 0:
        color = 8388352  # Light green
    elif total_pnl > -1:
        color = 16776960  # Yellow
    else:
        color = 16711680  # Red

    embed = {
        "title": f"Daily Report — {today}",
        "color": color,
        "fields": [
            {"name": "Signals", "value": f"{signals['total']} ({signals['buys']}B / {signals['sells']}S / {signals['take_profits']}TP / {signals['stop_losses']}SL)", "inline": True},
            {"name": "PnL", "value": pnl_line, "inline": True},
            {"name": "Regime", "value": f"{regime['overall']} | {regime['bias']}", "inline": True},
            {"name": "Positions", "value": "\n".join(pos_lines) if pos_lines else "No positions", "inline": False},
            {"name": "Optimal Params", "value": f"ATR {params.get('atr_period')} / Mult {params.get('multiplier')} (WR {params.get('win_rate')}%)", "inline": True},
            {"name": "Infrastructure", "value": health_line, "inline": True},
        ],
        "footer": {"text": f"Mission Control Daily Report | Auto-generated"},
    }

    payload = json.dumps({"username": "Mission Control", "embeds": [embed]}).encode("utf-8")
    import urllib.request
    req = urllib.request.Request(
        webhook, data=payload,
        headers={"Content-Type": "application/json", "User-Agent": "SignalReceiver/1.0"},
        method="POST"
    )
    try:
        urllib.request.urlopen(req)
        print("Posted to Discord")
    except Exception as e:
        print(f"Discord error: {e}")


if __name__ == "__main__":
    report = build_report()
    post_to_discord(report)
