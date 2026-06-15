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
GRAD  = os.path.expanduser("~/.openclaw/quantum_graduated.flag")  # lifetime one-time
TG    = os.path.expanduser("~/bin/tg-send-msg")


def _send(msg):
    subprocess.run([TG, msg], timeout=20)


def _graduation_check(dry):
    """One-time lifetime buzz when paper performance clears the go-live gate."""
    if os.path.exists(GRAD) and not dry:
        return
    if not Q.graduation_ready():
        if dry:
            print("graduation: not ready (gate not cleared) → silent")
        return
    sb = Q._load("scoreboard.json") or {}
    o = sb.get("overall") or {}
    msg = ("🎓 *READY TO GRADUATE*\n"
           f"Paper edge proven: {o.get('graded')} trades · "
           f"{(o.get('win_rate') or 0)*100:.0f}% win · exp {o.get('expectancy_pct',0):+.1f}%\n"
           "You cleared the gate (50+ trades & positive expectancy).\n"
           "Consider a SMALL real-money sleeve — start tiny, same rules. /grade for details")
    if dry:
        print("WOULD BUZZ (graduation):\n" + msg)
        return
    try:
        _send(msg)
        open(GRAD, "w").write(datetime.now(ET).isoformat())
    except Exception as e:
        print(f"[sniper] graduation send failed: {e}", file=sys.stderr)


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
        s = {"date": today}
    s.setdefault("alerted", [])          # green-light occ's buzzed today
    s.setdefault("exits_alerted", [])    # "SYM:VERDICT" buzzed today
    s.setdefault("shock_alerted", False) # risk-off buzzed today
    s.setdefault("sweeps_alerted", [])   # OptionSymbols buzzed today (capped)
    return s


def _save_state(s):
    try:
        json.dump(s, open(STATE, "w"))
    except Exception as e:
        print(f"[sniper] state save failed: {e}", file=sys.stderr)


def _occ(p):
    return p.get("occ") or f"{p.get('ticker')}{p.get('expiry')}{p.get('type')}{p.get('strike')}"


def _actionable(p, risk_cap):
    """A buzz must be sizeable: either the naked contract fits (qty>=1) or the
    pipeline's debit spread fits the risk cap. If neither, stay silent — pinging
    Mike to 'buy' something he can't size is exactly the bloat we're killing."""
    if (p.get("qty") or 0) >= 1:
        return True
    return Q._afford_spread(p, risk_cap) is not None


def _buzz_text(p, d):
    typ = (p.get("type") or "").upper()
    tag = "STRONG " if str(p.get("confidence", "")).upper() == "A" else ""
    spread = Q._afford_spread(p, d.get("risk_cap")) if (p.get("qty") or 0) < 1 else None
    if spread:   # naked is over cap → buzz the cap-fitting spread the pipeline built
        return (f"🟢 *{tag}GREEN LIGHT* — buy now (spread fits your cap)\n"
                f"*{p.get('ticker')} ${spread.get('long'):g}/${spread.get('short'):g} {typ} SPREAD* · "
                f"{Q._fmt_exp(p.get('expiry'))} ({p.get('days')}d)\n"
                f"{Q._money(spread.get('cost_per'))} cost · max +{Q._money(spread.get('max_profit'))} / "
                f"−{Q._money(spread.get('max_loss'))} · {p.get('confidence')}-conf · {p.get('value')}\n"
                f"_why: {(p.get('action_why') or 'clean setup')[:110]}_\n"
                f"📝 {spread.get('place_order')}\n"
                f"acct {Q._money(d.get('equity'))} · /pick for more")
    return (f"🟢 *{tag}GREEN LIGHT* — buy now\n"
            f"*{p.get('ticker')} ${p.get('strike'):g} {typ}* · {Q._fmt_exp(p.get('expiry'))} "
            f"({p.get('days')}d)\n"
            f"{Q._money(p.get('per_contract'))}/ct · buy {p.get('qty',1)} = "
            f"{p.get('pct_of_equity')}% · {p.get('confidence')}-conf · "
            f"{p.get('sources')} src · {p.get('value')}\n"
            f"_why: {(p.get('action_why') or 'clean setup')[:110]}_\n"
            f"acct {Q._money(d.get('equity'))} · stop −50% prem · /pick for more")


def _shock_guard(dry, state):
    """Buzz ONCE/day if the market flips risk-off — stop adding, play defense."""
    s = Q._load("shock_flag.json")
    if not s or not s.get("risk_off"):
        if dry: print("shock: clear → silent")
        return False
    if state.get("shock_alerted") and not dry:
        return False
    movers = []
    for m in (s.get("movers") or [])[:3]:
        if isinstance(m, dict):
            pct = m.get("pct")
            movers.append(f"{m.get('ticker','?')}{(' %+.0f%%'%(pct*100)) if isinstance(pct,(int,float)) else ''}")
        else:
            movers.append(str(m))
    msg = (f"🛑 *RISK-OFF* (sev {float(s.get('severity',0)):.0%})\n"
           f"{s.get('reason','market shock')}"
           + (f"\nmovers: {', '.join(movers)}" if movers else "")
           + "\n→ stop adding, tighten stops, play defense. /book")
    if dry:
        print("WOULD BUZZ (shock):\n" + msg); return False
    _send(msg); state["shock_alerted"] = True
    return True


def _exit_guard(dry, state):
    """Buzz when a HELD position flips to EXIT/TRIM — lock winners, cut losers.
    The biggest capital-grower; deduped per SYM:VERDICT/day, one combined message."""
    d = Q._load("portfolio_manage.json")
    if not d:
        if dry: print("exit: no book");
        return False
    moves = d.get("moves") or {}
    flagged = []
    for verdict in ("EXIT", "TRIM", "REDUCE"):
        for it in (moves.get(verdict) or []):
            sym = it.get("symbol") or it.get("ticker")
            key = f"{sym}:{verdict}"
            if key in state["exits_alerted"] and not dry:
                continue
            reasons = it.get("reasons")
            reason = reasons[0] if isinstance(reasons, list) and reasons else (reasons or "")
            ep = it.get("exit_plan") or {}
            at = ep.get("mark") or ep.get("stop")
            flagged.append((verdict, sym, reason, at, key))
    if not flagged:
        if dry: print("exit: all HOLD → silent")
        return False
    emoji = {"EXIT": "🔴", "TRIM": "🟠", "REDUCE": "🟠"}
    lines = ["⚠️ *POSITION ALERTS*"]
    for verdict, sym, reason, at, _ in flagged:
        ats = f" → ~${at:g}" if isinstance(at, (int, float)) else ""
        lines.append(f"{emoji.get(verdict,'⚠️')} {sym} — {verdict} ({reason}){ats}")
    lines.append("/book for details")
    msg = "\n".join(lines)
    if dry:
        print("WOULD BUZZ (exit):\n" + msg); return False
    _send(msg)
    state["exits_alerted"].extend(k for *_, k in flagged)
    return True


SWEEP_MIN_PREM = 3_000_000   # screamer-only push; /sweeps pull shows the rest
SWEEP_MAX_DAY = 6            # hard daily cap (anti-bloat)
SWEEP_FRESH_MIN = 25        # guardian runs ~every 20m


def _sweep_age_min(a):
    import datetime as _dt
    t = a.get("Updated") or a.get("Time")
    if not t:
        return 1e9
    try:
        return (_dt.datetime.now(_dt.timezone.utc).timestamp() * 1000 - float(t)) / 60000
    except Exception:
        return 1e9


def _sweep_alert(dry, state):
    """Buzz ONE rare screamer sweep (≥$3M + new positioning + fresh), capped/day."""
    if len(state.get("sweeps_alerted", [])) >= SWEEP_MAX_DAY and not dry:
        if dry: print("sweeps: daily cap reached")
        return False
    raw = Q._sweeps_raw()
    q = []
    for a in raw:
        if (a.get("totalFlowValue") or 0) < SWEEP_MIN_PREM:
            continue
        if not dry and _sweep_age_min(a) > SWEEP_FRESH_MIN:
            continue
        oi, vol, swp = a.get("OI") or 0, a.get("Volume") or 0, a.get("SWEEPS") or 0
        new_pos = (oi and vol / oi >= 2) or swp >= 15  # brand-new positioning
        if new_pos:
            q.append(a)
    q.sort(key=lambda a: a.get("totalFlowValue") or 0, reverse=True)
    for a in q:
        k = a.get("OptionSymbol")
        if k in state["sweeps_alerted"] and not dry:
            continue
        msg = "🔪 *BIG SWEEP — whales positioning*\n" + Q._sweep_line(a)
        if dry:
            print("WOULD BUZZ (sweep):\n" + msg); return False
        try:
            _send(msg); state["sweeps_alerted"].append(k); return True
        except Exception as e:
            print(f"[sniper] sweep send failed: {e}", file=sys.stderr)
        break
    if dry: print("sweeps: none qualify (need ≥$3M + new positioning + fresh)")
    return False


def _green_light(dry, state):
    """The rare clean-BUY buzz (ACT + cheap/fair). One per run max."""
    d = Q._load("best_contracts.json")
    if not d:
        if dry: print("no best_contracts.json")
        return False
    if not dry and not _fresh_today(d.get("as_of")):
        return False  # stale (weekend) — never buzz old data
    greens = [p for p in (d.get("picks") or [])
              if _is_greenlight(p) and _actionable(p, d.get("risk_cap"))]
    if not greens:
        if dry: print(f"green-light: none (picks {len(d.get('picks') or [])}, all rich/event-risk/over-cap → silent)")
        return False
    # Prefer a green-light the option-signals flow ALSO backs (both engines agree).
    flowdir = Q._flow_directions()
    greens.sort(key=lambda p: 0 if (Q._confluence(p, flowdir) or "").startswith("⭐") else 1)
    for p in greens:
        occ = _occ(p)
        if occ in state["alerted"] and not dry:
            continue
        msg = _buzz_text(p, d)
        conf = Q._confluence(p, flowdir)
        if conf:
            msg += f"\n{conf}"
        if dry:
            print("WOULD BUZZ (green):\n" + msg); return False
        try:
            _send(msg); state["alerted"].append(occ); return True
        except Exception as e:
            print(f"[sniper] send failed: {e}", file=sys.stderr)
        break  # ONE buzz per run max — the single best clean pick (anti-bloat)
    return False


def main():
    """Market-hours guardian (one cron): graduation + shock + exits + green-light,
    each gated/deduped so it only buzzes when it changes Mike's next move."""
    dry = "--dry-run" in sys.argv
    if os.path.exists(HALT) and not dry:
        return  # killswitch — stay silent
    state = _load_state()
    _graduation_check(dry)               # own lifetime flag, scoreboard-based
    changed = False
    changed |= _shock_guard(dry, state)  # defense first
    changed |= _exit_guard(dry, state)   # then manage the book
    changed |= _green_light(dry, state)  # then new entries
    changed |= _sweep_alert(dry, state)  # rare whale-sweep screamer
    if not dry and changed:
        _save_state(state)


if __name__ == "__main__":
    main()
