#!/usr/bin/env python3
"""
mc — MissionCtrl one-keystroke ops (Step 5 of /silver-platter build plan, 2026-05-11).

Subcommands:
  mc status              All 7 wallets, drawdown proximity, killswitches, precycle, last cycle
  mc pause <wallet>      Set killswitch_<wallet> manually
  mc resume <wallet>     Clear killswitch_<wallet>
  mc precycle            Print precycle_health.json summary
  mc platters            Print silver_platters layout status
  mc audit [date]        Tail today's audit log (or pass YYYY-MM-DD)
  mc postmortem <symbol> Pull audit log entries for one symbol across all dates
  mc drawdown            Per-wallet drawdown state with cap proximity
  mc help                Print this list

All output paste-friendly. No interactive prompts.
"""
import json, os, subprocess, sys
from datetime import datetime, timezone, timedelta
from pathlib import Path

ET = timezone(timedelta(hours=-4))
NOW = datetime.now(timezone.utc)
NOW_ET = NOW.astimezone(ET)

PLATTERS = Path("/home/ubuntu/.openclaw/data/silver_platters")
STATE = Path("/home/ubuntu/.openclaw/workspace/state")
AUDIT_DIR = PLATTERS / "audit_log"
PRECYCLE = Path("/home/ubuntu/.openclaw/data/precycle_health.json")
DRAWDOWN_STATE = STATE / "wallet_drawdown_state.json"
SNAPSHOT = Path("/home/ubuntu/wallets-snapshot")

WALLETS = ["alpaca_paper", "coinbase", "robinhood", "hyperliquid_personal"]


def hr(label=""):
    bar = "─" * 60
    if label:
        print(f"\n── {label} {'─' * (56 - len(label))}")
    else:
        print(bar)


def cmd_status():
    print(f"MissionCtrl status @ {NOW_ET.strftime('%Y-%m-%d %H:%M:%S ET')}")

    hr("Wallets")
    if SNAPSHOT.exists():
        try:
            wallets = json.loads(SNAPSHOT.read_text())
            for w in wallets:
                bal = float(w.get("balance") or 0)
                cash = float(w.get("cash") or 0)
                badge = w.get("badge") or w.get("type") or ""
                name = w.get("name") or "?"
                print(f"  {name:30s} ${bal:>12,.2f}  cash=${cash:>10,.2f}  {badge}")
        except Exception as e:
            print(f"  ERROR parsing snapshot: {e}")
    else:
        print("  wallet snapshot missing — wallets-snapshot cron may have stalled")

    hr("Drawdown today")
    if DRAWDOWN_STATE.exists():
        dd = json.loads(DRAWDOWN_STATE.read_text())
        for wid in WALLETS:
            s = dd.get(wid)
            if not s:
                print(f"  {wid:25s} no state today")
                continue
            caps = s.get("caps", {})
            ks = STATE / f"killswitch_{wid}"
            ks_marker = "🔴 KILLSWITCH" if ks.exists() else "  ok"
            print(f"  {wid:25s} bal=${s.get('last_balance',0):>10,.2f}  open=${s.get('opening_balance',0):>10,.2f}  dd_open={s.get('last_dd_open_pct',0):+6.2f}% (cap {caps.get('day_open',0)}%)  dd_high={s.get('last_dd_high_pct',0):+6.2f}% (cap {caps.get('day_high',0)}%)  {ks_marker}")
    else:
        print("  no drawdown state yet (per_wallet_drawdown_guard.py has not run)")

    hr("Killswitches")
    boba_global = STATE / "boba_killswitch"
    print(f"  boba_killswitch (global): {'🔴 SET' if boba_global.exists() else 'clear'}")
    for wid in WALLETS:
        ks = STATE / f"killswitch_{wid}"
        sup = STATE / f"killswitch_{wid}.suppress"
        line = f"  killswitch_{wid:25s}"
        if ks.exists():
            try:
                meta = json.loads(ks.read_text())
                line += f" 🔴 SET at {meta.get('set_at_et','?')} reason={meta.get('reason','?')[:60]}"
            except Exception:
                line += " 🔴 SET (unparseable)"
        else:
            line += " clear"
        if sup.exists():
            line += " [SUPPRESSED by override]"
        print(line)

    hr("Precycle health")
    if PRECYCLE.exists():
        h = json.loads(PRECYCLE.read_text())
        c = h.get("counts", {})
        print(f"  overall: {h.get('overall')}  red={c.get('red',0)} yellow={c.get('yellow',0)} green={c.get('green',0)}  checked={h.get('checked_at_et','?')}")
        for s in h.get("sources", []):
            if s["status"] != "GREEN":
                print(f"    {s['status']:6s} {s['id']:30s} {s.get('issue') or ''}")
    else:
        print("  precycle_health.json missing — precycle_health.py has not run")

    hr("Last 5 audit events")
    today_log = AUDIT_DIR / f"{NOW_ET.strftime('%Y-%m-%d')}.jsonl"
    if today_log.exists():
        with open(today_log) as f:
            lines = f.readlines()
        for ln in lines[-5:]:
            try:
                e = json.loads(ln)
                print(f"  {e.get('ts_et','?')} {e.get('type','?'):8s} {e.get('asset_class','?'):8s} {e.get('wallet','?'):20s} {e.get('ticker_or_symbol','?')}")
            except Exception:
                continue
    else:
        print(f"  no events today ({today_log.name})")

    hr("PM2")
    try:
        out = subprocess.run(["pm2", "jlist"], capture_output=True, text=True, timeout=8)
        d = json.loads(out.stdout)
        online = sum(1 for p in d if p["pm2_env"].get("status") == "online")
        total = len(d)
        loops = [p["name"] for p in d if p["pm2_env"].get("restart_time", 0) > 100]
        print(f"  online: {online}/{total}")
        if loops:
            print(f"  high-restart procs (>100): {', '.join(loops[:8])}{' ...' if len(loops) > 8 else ''}")
    except Exception as e:
        print(f"  pm2 jlist failed: {e}")


def _killswitch_path(wallet):
    return STATE / f"killswitch_{wallet}"


def cmd_pause(args):
    if not args:
        print("usage: mc pause <wallet>  e.g. mc pause coinbase")
        return 1
    wallet = args[0]
    if wallet not in WALLETS:
        print(f"unknown wallet '{wallet}'. Valid: {', '.join(WALLETS)}")
        return 1
    ks = _killswitch_path(wallet)
    ks.write_text(json.dumps({
        "set_at": NOW.isoformat(),
        "set_at_et": NOW_ET.strftime("%Y-%m-%d %H:%M:%S ET"),
        "reason": "manual via mc pause",
        "set_by": "mc-tools (operator)",
    }, indent=2))
    print(f"killswitch_{wallet} SET at {ks}")


def cmd_resume(args):
    if not args:
        print("usage: mc resume <wallet>  e.g. mc resume coinbase")
        return 1
    wallet = args[0]
    if wallet not in WALLETS:
        print(f"unknown wallet '{wallet}'. Valid: {', '.join(WALLETS)}")
        return 1
    ks = _killswitch_path(wallet)
    if ks.exists():
        ks.unlink()
        print(f"killswitch_{wallet} CLEARED")
    else:
        print(f"killswitch_{wallet} was not set")


def cmd_precycle():
    if not PRECYCLE.exists():
        print("precycle_health.json missing")
        return 1
    h = json.loads(PRECYCLE.read_text())
    c = h.get("counts", {})
    print(f"overall: {h.get('overall')} red={c.get('red',0)} yellow={c.get('yellow',0)} green={c.get('green',0)}  checked={h.get('checked_at_et','?')}")
    for s in h.get("sources", []):
        age = s.get("age_minutes")
        age_str = f"{age:>7.2f}min" if isinstance(age, (int, float)) else "    n/a"
        issue = f"  ({s.get('issue')})" if s.get("issue") else ""
        print(f"  {s['status']:6s} {s['id']:30s} age={age_str}  max={s.get('max_age_minutes','?')}min{issue}")


def cmd_platters():
    if not PLATTERS.exists():
        print("silver_platters/ does not exist — run silver_platters_layout.py setup")
        return 1
    subprocess.run(["python3", "/home/ubuntu/scripts/silver_platters_layout.py", "status"])


def cmd_audit(args):
    date_str = args[0] if args else NOW_ET.strftime("%Y-%m-%d")
    fp = AUDIT_DIR / f"{date_str}.jsonl"
    if not fp.exists():
        print(f"no audit log for {date_str} ({fp})")
        return 1
    with open(fp) as f:
        lines = f.readlines()
    print(f"{date_str}: {len(lines)} events")
    for ln in lines[-30:]:
        try:
            e = json.loads(ln)
            print(f"  {e.get('ts_et','?'):25s} {e.get('type','?'):8s} {e.get('asset_class','?'):8s} {e.get('wallet','?'):22s} {e.get('ticker_or_symbol','?')}")
        except Exception:
            continue
    if len(lines) > 30:
        print(f"  ... showing last 30 of {len(lines)} (cat {fp} for full)")


def cmd_postmortem(args):
    if not args:
        print("usage: mc postmortem <symbol>  e.g. mc postmortem NVDA")
        return 1
    symbol = args[0].upper()
    if not AUDIT_DIR.exists():
        print(f"audit_log/ missing")
        return 1
    matches = []
    for fp in sorted(AUDIT_DIR.glob("*.jsonl")):
        with open(fp) as f:
            for ln in f:
                if f'"{symbol}"' in ln:
                    try:
                        e = json.loads(ln)
                        if (e.get("ticker_or_symbol") or "").upper() == symbol:
                            matches.append((fp.stem, e))
                    except Exception:
                        continue
    print(f"{symbol}: {len(matches)} events across audit history")
    for date, e in matches[-30:]:
        details = e.get("details", {})
        outcome = details.get("outcome") or details.get("status_raw") or ""
        ret = details.get("pct_return")
        ret_str = f" {ret:+.1f}%" if isinstance(ret, (int, float)) else ""
        print(f"  {date}  {e.get('type','?'):8s}  {e.get('asset_class','?'):8s}  {outcome[:40]}{ret_str}")
    if len(matches) > 30:
        print(f"  ... showing last 30 of {len(matches)}")


def cmd_drawdown():
    if not DRAWDOWN_STATE.exists():
        print("no drawdown state yet")
        return 1
    dd = json.loads(DRAWDOWN_STATE.read_text())
    print(f"Drawdown state @ {NOW_ET.strftime('%Y-%m-%d %H:%M ET')}")
    for wid, s in dd.items():
        caps = s.get("caps", {})
        ks = _killswitch_path(wid).exists()
        cap_open = caps.get("day_open", -10)
        cap_high = caps.get("day_high", -8)
        dd_open = s.get("last_dd_open_pct", 0)
        dd_high = s.get("last_dd_high_pct", 0)
        room_open = dd_open - cap_open  # positive = headroom before breach, negative = past cap
        room_high = dd_high - cap_high
        if ks:
            marker = "🔴"
        elif min(room_open, room_high) < 2:
            marker = "⚠️"
        else:
            marker = "  "
        print(f"  {marker} {wid:25s} bal=${s.get('last_balance',0):>10,.2f}  dd_open={dd_open:+6.2f}% (room {room_open:+5.2f})  dd_high={dd_high:+6.2f}% (room {room_high:+5.2f})  asset={caps.get('asset','?')}  real={caps.get('real',False)}")


def cmd_help():
    print(__doc__.strip())


def main():
    if len(sys.argv) < 2 or sys.argv[1] in ("help", "-h", "--help"):
        cmd_help()
        return 0
    cmd = sys.argv[1]
    args = sys.argv[2:]
    table = {
        "status": cmd_status,
        "pause": lambda: cmd_pause(args),
        "resume": lambda: cmd_resume(args),
        "precycle": cmd_precycle,
        "platters": cmd_platters,
        "audit": lambda: cmd_audit(args),
        "postmortem": cmd_postmortem,
        "drawdown": cmd_drawdown,
    }
    if cmd == "postmortem":
        return cmd_postmortem(args)
    fn = table.get(cmd)
    if not fn:
        print(f"unknown subcommand '{cmd}'. mc help for list.")
        return 1
    return fn() or 0


if __name__ == "__main__":
    sys.exit(main())
