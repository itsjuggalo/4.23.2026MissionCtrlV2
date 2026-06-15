#!/home/itsju/.venv/bin/python
"""Quantum pipeline picks → ADD-friendly Telegram one-liners (READ-ONLY).

Reads the quantum pricing pipeline's END-RESULT artifacts (owned by another session
— we only READ them) and distills the single best actionable contract into a verdict-
first, zero-bloat message. Powers /pick /picks /book on the Telegram responders.

Anti-bloat doctrine: ONE clear action, ≤5 short lines, no data walls. Honest when
there's nothing clean (capital preservation > FOMO).
"""
import json, os
from datetime import datetime
from zoneinfo import ZoneInfo

OUT = os.path.expanduser("~/labs/quantum/out")
ET  = ZoneInfo("America/New_York")


def _load(name):
    try:
        return json.load(open(os.path.join(OUT, name)))
    except Exception:
        return None


def _freshness(as_of):
    """Tiny, calm freshness tag — never alarmist."""
    try:
        t = datetime.fromisoformat(as_of)
        now = datetime.now(ET)
        if t.date() == now.date():
            return f"{t.strftime('%-I:%M %p ET')}"
        return f"{t.strftime('%a %-I:%M%p')} close"
    except Exception:
        return "latest"


def _money(x):
    try:
        return f"${float(x):,.0f}"
    except Exception:
        return str(x)


def _verdict(p):
    """Deterministic, honest verdict from action + value (the 'which one' call)."""
    act = (p.get("action") or "").upper()
    val = (p.get("value") or "").lower()
    if act == "ACT" and val in ("cheap", "fair"):
        return "🟢 BUY — clean signal, fair price"
    if act == "ACT" and val == "rich":
        return "🟡 SMALL — good signal, but IV is rich (pricey)"
    if act == "ACT-SMALL":
        return "🟡 SMALL — event risk; keep it light"
    if act == "WAIT":
        return "⏳ WAIT — let the setup confirm"
    return "🟡 SMALL"


def _pick_line(p):
    typ = (p.get("type") or "").upper()
    return (f"*{p.get('ticker')} ${p.get('strike'):g} {typ}* · {_fmt_exp(p.get('expiry'))} "
            f"({p.get('days')}d)\n"
            f"{_money(p.get('per_contract'))}/ct · buy {p.get('qty',1)} = "
            f"{p.get('pct_of_equity')}% of acct · {p.get('confidence')}-conf · "
            f"{p.get('sources')} src · {p.get('value')}")


def _fmt_exp(e):
    try:
        return datetime.strptime(e, "%Y-%m-%d").strftime("%-m/%-d")
    except Exception:
        return e


def _acct_line(d):
    h = d.get("portfolio_heat") or {}
    return (f"acct: {_money(d.get('equity'))} · {h.get('heat_pct','?')}% heat · "
            f"{_money(h.get('cash'))} free")


def pick(top=1):
    """The single best (top=1) or top-N actionable picks. Verdict-first."""
    d = _load("best_contracts.json")
    if not d:
        return "no pipeline output yet — it runs market hours (Mon–Fri 9:30–4 ET)."
    picks = d.get("picks") or []
    fresh = _freshness(d.get("as_of"))
    if not picks:
        nd = d.get("n_dropped", 0)
        return (f"🟦 No clean buy right now ({fresh}).\n"
                f"Pipeline checked {d.get('n_considered','?')} and dropped all "
                f"{nd} (too pricey/illiquid/risky). Capital preserved — sit tight.\n"
                f"{_acct_line(d)}")
    if top == 1:
        p = picks[0]
        return (f"🎯 *TOP PICK* · {fresh}\n"
                f"{_pick_line(p)}\n"
                f"{_verdict(p)}\n"
                f"_why: {(p.get('action_why') or '')[:120]}_\n"
                f"{_acct_line(d)}")
    lines = [f"🎯 *TOP {min(top,len(picks))} PICKS* · {fresh}"]
    for i, p in enumerate(picks[:top], 1):
        typ = (p.get("type") or "").upper()
        lines.append(f"{i}. {_verdict(p).split(' — ')[0]}  *{p.get('ticker')} "
                     f"${p.get('strike'):g}{typ[0]}* {_fmt_exp(p.get('expiry'))} · "
                     f"{_money(p.get('per_contract'))} · {p.get('confidence')} · {p.get('value')}")
    lines.append(_acct_line(d))
    return "\n".join(lines)


def book():
    """Current paper book + HOLD/TRIM/EXIT verdicts, tight."""
    d = _load("portfolio_manage.json")
    if not d:
        return "no book snapshot yet."
    out = [f"📒 *BOOK* · {_money(d.get('equity'))} · {d.get('heat_pct','?')}% heat · "
           f"{_money(d.get('cash'))} free"]
    positions = d.get("positions") or []
    flagged = []
    # `moves` is keyed BY verdict → list of position dicts (e.g. {"HOLD":[...],"TRIM":[...]}).
    moves = d.get("moves")
    if isinstance(moves, dict):
        for verdict, items in moves.items():
            if str(verdict).upper() in ("HOLD", "KEEP"):
                continue
            for it in (items or []):
                sym = it.get("symbol") if isinstance(it, dict) else it
                flagged.append(f"  ⚠️ {sym}: {verdict}")
    for pos in positions[:6]:
        if isinstance(pos, dict):
            sym = pos.get("symbol") or pos.get("ticker")
            pct = pos.get("pnl_pct")
            pct = f"{pct:+.1f}%" if isinstance(pct, (int, float)) else ""
            out.append(f"  {sym}: {pct} {pos.get('verdict','')}".rstrip())
    if flagged:
        out.append("action:")
        out.extend(flagged)
    else:
        out.append("all HOLD — nothing to do ✅")
    return "\n".join(out)


GRAD_MIN_N = 50   # Mike's standing go-live gate: n>=50 graded + positive expectancy
GRAD_MIN_WR = 0.40


def grade():
    """Honest paper→real readiness off the pipeline scoreboard. Protects against
    going live too early — the whole point of growing paper first."""
    d = _load("scoreboard.json")
    if not d:
        return "no track record yet — picks get graded as they play out."
    o = d.get("overall") or {}
    n = o.get("graded", 0) or 0
    wr = o.get("win_rate")
    exp = o.get("expectancy_pct")
    wrp = f"{wr*100:.0f}%" if isinstance(wr, (int, float)) else "?"
    expv = exp if isinstance(exp, (int, float)) else 0.0
    head = f"🎓 *GRADUATION CHECK*\npaper: {n} graded · {wrp} win · exp {expv:+.1f}%"
    gate = f"gate: {GRAD_MIN_N}+ trades & positive expectancy"
    if n < GRAD_MIN_N:
        status = f"🔴 building proof — {n}/{GRAD_MIN_N} trades. Keep growing paper first."
    elif expv <= 0:
        status = f"🔴 {n} trades but no edge yet (exp {expv:+.1f}%). Stay on paper, refine."
    elif (wr or 0) < GRAD_MIN_WR:
        status = f"🟡 positive expectancy, thin win-rate ({wrp}). One more stretch on paper."
    else:
        status = "🟢 READY — edge proven. Consider sizing up / a small real-money sleeve."
    return f"{head}\n{gate}\n{status}"


def graduation_ready():
    """True only when the gate is cleanly met (for a one-time 'ready' buzz)."""
    d = _load("scoreboard.json")
    o = (d or {}).get("overall") or {}
    n = o.get("graded", 0) or 0
    exp = o.get("expectancy_pct") or 0
    wr = o.get("win_rate") or 0
    return n >= GRAD_MIN_N and exp > 0 and wr >= GRAD_MIN_WR


if __name__ == "__main__":
    import sys
    cmd = sys.argv[1] if len(sys.argv) > 1 else "pick"
    print(pick(1) if cmd == "pick" else pick(3) if cmd == "picks"
          else grade() if cmd == "grade" else book())
