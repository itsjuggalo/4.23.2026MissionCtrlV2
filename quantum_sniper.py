#!/home/itsju/.venv/bin/python
"""Quantum green-light sniper — the rare, low-noise "BUY THIS NOW" buzz.

READ-ONLY on the quantum pipeline output (owned by another session). After each
pipeline cycle this fires AT MOST one Telegram buzz, and only for a genuinely clean
green-light: action==ACT AND value in {cheap,fair} (rich/event-risk picks are
SILENT — that's the de-bloat). Deduped per contract per day so it never repeats.

This is the "simple alert that grows capital" — separate from and rarer than the
3×/day digest. Anti-bloat: if nothing is clean, it says nothing.

Cron (a few min after supercomputer.sh's */20):  9,29,49 9-16 * * 1-5
Test:  quantum_sniper.py --dry-run   (prints, never sends, ignores dedup)
Halt:  touch ~/.openclaw/quantum_HALT   (shared killswitch) — sniper stays silent
"""
import json, os, sys, subprocess
from datetime import datetime
from zoneinfo import ZoneInfo

sys.path.insert(0, os.path.expanduser("~/scripts"))
import quantum_tg as Q  # shared read-only formatters

ET    = ZoneInfo("America/New_York")
STATE = os.path.expanduser("~/.openclaw/quantum_sniper_state.json")
HALT  = os.path.expanduser("~/.openclaw/quantum_HALT")
TG    = os.path.expanduser("~/bin/tg-send-msg")


def _is_greenlight(p):
    return (str(p.get("action", "")).upper() == "ACT"
            and str(p.get("value", "")).lower() in ("cheap", "fair"))


def _fresh_today(as_of):
    try:
        return datetime.fromisoformat(as_of).date() == datetime.now(ET).date()
    except Exception:
        return False


def _load_state():
    try:
        s = json.load(open(STATE))
    except Exception:
        s = {}
    today = datetime.now(ET).strftime("%Y-%m-%d")
    if s.get("date") != today:
        s = {"date": today, "alerted": []}
    return s


def _save_state(s):
    try:
        json.dump(s, open(STATE, "w"))
    except Exception as e:
        print(f"[sniper] state save failed: {e}", file=sys.stderr)


def _occ(p):
    return p.get("occ") or f"{p.get('ticker')}{p.get('expiry')}{p.get('type')}{p.get('strike')}"


def _buzz_text(p, d):
    typ = (p.get("type") or "").upper()
    tag = "STRONG " if str(p.get("confidence", "")).upper() == "A" else ""
    return (f"🟢 *{tag}GREEN LIGHT* — buy now\n"
            f"*{p.get('ticker')} ${p.get('strike'):g} {typ}* · {Q._fmt_exp(p.get('expiry'))} "
            f"({p.get('days')}d)\n"
            f"{Q._money(p.get('per_contract'))}/ct · buy {p.get('qty',1)} = "
            f"{p.get('pct_of_equity')}% · {p.get('confidence')}-conf · "
            f"{p.get('sources')} src · {p.get('value')}\n"
            f"_why: {(p.get('action_why') or 'clean setup')[:110]}_\n"
            f"acct {Q._money(d.get('equity'))} · stop −50% prem · /pick for more")


def main():
    dry = "--dry-run" in sys.argv
    if os.path.exists(HALT) and not dry:
        return  # killswitch — stay silent
    d = Q._load("best_contracts.json")
    if not d:
        if dry: print("no best_contracts.json")
        return
    if not dry and not _fresh_today(d.get("as_of")):
        return  # stale (e.g. weekend) — never buzz old data
    greens = [p for p in (d.get("picks") or []) if _is_greenlight(p)]
    if not greens:
        if dry: print(f"no green-light (picks: {len(d.get('picks') or [])}, all rich/event-risk → silent)")
        return
    state = _load_state()
    sent = 0
    for p in greens:
        occ = _occ(p)
        if occ in state["alerted"] and not dry:
            continue
        msg = _buzz_text(p, d)
        if dry:
            print("WOULD BUZZ:\n" + msg + "\n")
        else:
            try:
                subprocess.run([TG, msg], timeout=20)
                state["alerted"].append(occ)
                sent += 1
            except Exception as e:
                print(f"[sniper] send failed: {e}", file=sys.stderr)
        break  # ONE buzz per run max — the single best clean pick (anti-bloat)
    if not dry and sent:
        _save_state(state)


if __name__ == "__main__":
    main()
