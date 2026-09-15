#!/usr/bin/env python3
"""astro_tasks.py — the accountability + evidence layer on top of Svehla's reading.

State lives in ~/portfolio/astrology/ (JSON, human-readable):
  journal.jsonl    /note   — what happened, stamped with the active window ids
  scores.json      /score  — 1-5 "did it play out" per window → /scorecard
  questions.jsonl  /ask    — questions for the next Svehla consult → /askdraft
  tasks.json       /contingency /loose /juno — status trackers
  income.jsonl     /income — weekly Jupiter-2H check-ins

Scheduled: only `daily` (Uranus-Hades guardrail → Trading Command, 2028-29). `monthly` and
`friday` exist but are NOT cron'd — Mike 2026-09-14: "less questions, more insight". The
Monday weekly carries a one-line contingency countdown and the loose-ends list if he added any.
"""
from __future__ import annotations

import json
import subprocess
import sys
from datetime import date, datetime, timedelta
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parent))
import svehla  # noqa: E402

DIR = Path.home() / "portfolio" / "astrology"
DIR.mkdir(parents=True, exist_ok=True)
JOURNAL, SCORES, QUESTIONS, TASKS, INCOME = (DIR / f for f in
    ("journal.jsonl", "scores.json", "questions.jsonl", "tasks.json", "income.jsonl"))
TG_FLEET = Path.home() / "scripts" / "tg_fleet.py"
ALCYONE_START = date(2027, 3, 10)          # the window Svehla worries about most
SATURN_MC_END = date(2027, 4, 17)          # loose-ends deadline


def _jload(p: Path, default):
    try:
        return json.loads(p.read_text())
    except Exception:
        return default


def _jsave(p: Path, obj) -> None:
    p.write_text(json.dumps(obj, indent=1, ensure_ascii=False))


def _append(p: Path, obj: dict) -> None:
    with p.open("a") as f:
        f.write(json.dumps(obj, ensure_ascii=False) + "\n")


def _lines(p: Path) -> list[dict]:
    try:
        return [json.loads(x) for x in p.read_text().splitlines() if x.strip()]
    except Exception:
        return []


def send(lane: str, msg: str) -> None:
    subprocess.run([sys.executable, str(TG_FLEET), "send", lane, msg], capture_output=True, timeout=30)


def tasks() -> dict:
    t = _jload(TASKS, {})
    t.setdefault("contingency", {"housing": "not started", "cash_saved": 0, "cash_target": 0})
    t.setdefault("loose_ends", [])
    t.setdefault("juno", {"kids": False, "chores": False, "load": False})
    return t


# ── #4 journal + scorecard ────────────────────────────────────────────────────
def note(text: str) -> str:
    if not text:
        recent = _lines(JOURNAL)[-5:]
        if not recent:
            return "📓 No notes yet. /note <what happened> — stamped with the active Svehla windows."
        return "📓 Last notes:\n" + "\n".join(f"{n['date']}: {n['text'][:120]}" for n in recent)
    d = svehla.today_et()
    _append(JOURNAL, {"date": d.isoformat(), "windows": [w["id"] for w in svehla.active(d)], "text": text})
    return f"📓 Noted ({d:%b %-d}), filed under: {', '.join(w['id'] for w in svehla.active(d)) or 'no active window'}."


def score(args: list[str]) -> str:
    """/score <window-id|last> <1-5> [note]"""
    ws = {w["id"]: w for w in svehla.load_windows()}
    if not args:
        return "Usage: /score <window-id> <1-5> [note]. Window ids: " + ", ".join(ws)[:600]
    wid = args[0]
    if wid == "last":
        past = sorted((w for w in ws.values() if w["_end"] < svehla.today_et()), key=lambda w: w["_end"])
        if not past:
            return "No window has ended yet."
        wid = past[-1]["id"]
    if wid not in ws:
        return f"Unknown window '{wid}'. /dates lists them; ids: " + ", ".join(ws)[:600]
    try:
        val = int(args[1]); assert 1 <= val <= 5
    except Exception:
        return "Score must be 1-5 (1 = nothing like it, 5 = exactly as read)."
    sc = _jload(SCORES, {})
    sc[wid] = {"score": val, "note": " ".join(args[2:]), "date": svehla.today_et().isoformat(),
               "kind": ws[wid]["kind"], "title": ws[wid]["title"]}
    _jsave(SCORES, sc)
    return f"✅ {ws[wid]['title']} scored {val}/5." + (" Note saved." if len(args) > 2 else "")


def scorecard() -> str:
    sc = _jload(SCORES, {})
    if not sc:
        return "📊 No windows scored yet. When one ends I'll ask; or /score <id> 1-5 any time."
    by = {}
    for v in sc.values():
        by.setdefault(v["kind"], []).append(v["score"])
    lines = [f"📊 SVEHLA SCORECARD — {len(sc)} window(s) scored, avg {sum(v['score'] for v in sc.values()) / len(sc):.1f}/5", ""]
    for k, vals in sorted(by.items()):
        lines.append(f"{svehla.KIND_ICON.get(k, '•')} {k}: {sum(vals) / len(vals):.1f}/5 over {len(vals)}")
    lines.append("")
    for wid, v in sorted(sc.items(), key=lambda kv: kv[1]["date"]):
        lines.append(f"{v['score']}/5 {v['title']}" + (f" — {v['note']}" if v["note"] else ""))
    return "\n".join(lines)


# ── #5 next-consult prep ──────────────────────────────────────────────────────
def ask(text: str) -> str:
    if text:
        d = svehla.today_et()
        _append(QUESTIONS, {"date": d.isoformat(), "windows": [w["id"] for w in svehla.active(d)], "q": text})
        return f"❓ Saved for the next consult ({len(_lines(QUESTIONS))} queued). /askdraft when you're ready to email him."
    qs = _lines(QUESTIONS)
    if not qs:
        return "❓ No questions queued. /ask <question> as they come up; /askdraft drafts the email."
    return "❓ Queued for Svehla:\n" + "\n".join(f"{i + 1}. ({q['date']}) {q['q']}" for i, q in enumerate(qs))


def askdraft() -> str:
    qs = _lines(QUESTIONS)
    if not qs:
        return "Nothing queued — /ask <question> first."
    d = svehla.today_et()
    p = svehla.progressed(d)
    sc = _jload(SCORES, {})
    lines = [f"Subject: Follow-up questions — Mike (Nov 3 1992, 10:46 PM, Dunedin FL)", "",
             "Hi Svehla,", "",
             f"Following your August 29 2026 reading, a few questions that came up as the dates played out. "
             f"For reference today is {d:%B %-d %Y}; progressed Moon {svehla.sign_deg(p['Moon']['lon'])}, "
             f"progressed Venus {svehla.sign_deg(p['Venus']['lon'])}.", ""]
    for i, q in enumerate(qs, 1):
        ctx = ", ".join(q["windows"]) if q["windows"] else "between windows"
        lines.append(f"{i}. {q['q']}  (asked {q['date']}, during: {ctx})")
    if sc:
        lines += ["", "How your dates tracked so far (my 1-5 self-scores):"]
        lines += [f"- {v['title']}: {v['score']}/5" + (f" — {v['note']}" if v["note"] else "") for v in sc.values()]
    lines += ["", "Thank you,", "Mike"]
    return "\n".join(lines)


# ── #6 contingency tracker ────────────────────────────────────────────────────
def contingency(args: list[str]) -> str:
    t = tasks(); c = t["contingency"]
    if args:
        if args[0] == "housing" and len(args) > 1:
            c["housing"] = " ".join(args[1:])
        elif args[0] == "cash" and len(args) > 1:
            try:
                if "/" in args[1]:
                    a, b = args[1].split("/"); c["cash_saved"], c["cash_target"] = float(a), float(b)
                else:
                    c["cash_saved"] = float(args[1])
            except ValueError:
                return "Usage: /contingency cash <saved>/<target>  or  /contingency cash <saved>"
        elif args[0] == "target" and len(args) > 1:
            c["cash_target"] = float(args[1])
        else:
            return "Usage: /contingency housing <not started|started|done|free text> · cash <saved>/<target> · target <n>"
        _jsave(TASKS, t)
    d = svehla.today_et()
    days = (ALCYONE_START - d).days
    pct = (c["cash_saved"] / c["cash_target"] * 100) if c["cash_target"] else 0
    return ("🛡 SPRING 2027 CONTINGENCY (Svehla: pMoon 28-29° Taurus on Alcyone, Mar 10 → May 3 2027)\n"
            f"{days} days until the window opens.\n"
            f"• Housing plan: {c['housing']}\n"
            f"• Cash reserve: ${c['cash_saved']:,.0f} / ${c['cash_target']:,.0f} ({pct:.0f}%)\n"
            "Set: /contingency housing done · /contingency cash 1500/5000")


# ── #7 Saturn loose ends ──────────────────────────────────────────────────────
def loose(args: list[str]) -> str:
    t = tasks(); le = t["loose_ends"]
    d = svehla.today_et()
    if args and args[0] == "add" and len(args) > 1:
        le.append({"text": " ".join(args[1:]), "added": d.isoformat(), "done": None}); _jsave(TASKS, t)
    elif args and args[0] == "done" and len(args) > 1:
        try:
            i = int(args[1]) - 1; le[i]["done"] = d.isoformat(); _jsave(TASKS, t)
        except Exception:
            return "Usage: /loose done <n>"
    elif args:
        return "Usage: /loose · /loose add <career loose end> · /loose done <n>"
    open_ = [x for x in le if not x["done"]]
    closed = [x for x in le if x["done"]]
    lines = [f"🏛 SATURN LOOSE ENDS — {(SATURN_MC_END - d).days} days until Saturn leaves your MC (Apr 17 2027)"]
    if not le:
        lines.append("Nothing listed. /loose add <the career thing you keep not finishing>")
    for i, x in enumerate(le, 1):
        lines.append(f"{'✅' if x['done'] else '⬜'} {i}. {x['text']}")
    lines.append(f"{len(open_)} open · {len(closed)} closed")
    return "\n".join(lines)


# ── #8 Jupiter income check-in ────────────────────────────────────────────────
def jupiter_active(d: date) -> dict | None:
    for w in svehla.active(d):
        if w["id"].startswith("jupiter-2h"):
            return w
    return None


def income(args: list[str]) -> str:
    d = svehla.today_et()
    if args:
        _append(INCOME, {"date": d.isoformat(), "entry": " ".join(args),
                         "window": (jupiter_active(d) or {}).get("id")})
        return f"💰 Logged for {d:%b %-d}. /income with no text shows the log."
    rows = _lines(INCOME)
    if not rows:
        return "💰 No check-ins yet. Fridays during Jupiter-in-2H I'll ask; /income <number or yes/no + note> any time."
    return "💰 INCOME CHECK-INS (Jupiter 2H)\n" + "\n".join(f"{r['date']}: {r['entry']}" for r in rows[-12:])


# ── #9 Juno check-in ──────────────────────────────────────────────────────────
JUNO_ITEMS = {"kids": "how her kids get disciplined", "chores": "chores split", "load": "emotional load split"}


def juno(args: list[str]) -> str:
    t = tasks(); j = t["juno"]
    if args and args[0] in JUNO_ITEMS:
        j[args[0]] = (len(args) < 2 or args[1] != "undo"); _jsave(TASKS, t)
    elif args:
        return "Usage: /juno · /juno kids|chores|load [undo]"
    d = svehla.today_et()
    left = (date(2026, 10, 7) - d).days
    lines = ["💞 JUNO CHECK-IN — the three things Svehla said to iron out" +
             (f" ({left} days until Juno leaves your Descendant)" if left >= 0 else " (window closed Oct 7)")]
    lines += [f"{'✅' if j[k] else '⬜'} {v}  (/juno {k})" for k, v in JUNO_ITEMS.items()]
    return "\n".join(lines)


# ── scheduled jobs ────────────────────────────────────────────────────────────
def job_daily(d: date | None = None) -> str:
    """#10 Uranus-Hades guardrail → Trading Command, on window start + every Monday inside it."""
    d = d or svehla.today_et()
    for w in svehla.active(d):
        if w["id"].startswith("uranus-hades") and (w["_start"] == d or d.weekday() == 0):
            return (f"🔮 Astrology guardrail (Svehla): Uranus is on your natal Hades until {w['_end']:%b %-d %Y}. "
                    "No impulsive money moves — be thorough and conservative with finances. "
                    "A sudden financial step backwards is the caution for this window.")
    return ""


def job_monthly(d: date | None = None) -> str:
    d = d or svehla.today_et()
    parts = []
    if d < ALCYONE_START:
        c = tasks()["contingency"]
        if c["housing"] != "done" or (c["cash_target"] and c["cash_saved"] < c["cash_target"]):
            parts.append(contingency([]))
    if any(w["id"] == "juno-dsc" for w in svehla.active(d)):
        j = tasks()["juno"]
        if not all(j.values()):
            parts.append(juno([]))
    return "\n\n".join(parts)


def job_friday(d: date | None = None) -> str:
    d = d or svehla.today_et()
    w = jupiter_active(d)
    if not w:
        return ""
    return (f"💰 Jupiter in your 2nd house ({(w['_end'] - d).days}d left): did income expand this week? "
            "Reply /income <number or yes/no + one line>. Svehla: expand material security as much as you can.")


def loose_nag(d: date | None = None) -> str:
    """Rides inside the Monday weekly send while Saturn is on the MC."""
    d = d or svehla.today_et()
    if d > SATURN_MC_END:
        return ""
    open_ = [x for x in tasks()["loose_ends"] if not x["done"]]
    if not open_:
        return ""
    return f"🏛 Saturn loose ends still open ({len(open_)}): " + "; ".join(x["text"] for x in open_[:5])


COMMANDS = {
    "note": lambda a: note(" ".join(a)), "score": score, "scorecard": lambda a: scorecard(),
    "ask": lambda a: ask(" ".join(a)), "askdraft": lambda a: askdraft(),
    "contingency": contingency, "loose": loose, "income": income, "juno": juno,
    "exact": lambda a: svehla.exact_block(),
}

if __name__ == "__main__":
    argv = [a for a in sys.argv[1:] if a != "--send"]
    cmd, args = (argv[0] if argv else "help"), argv[1:]
    if cmd in ("daily", "monthly", "friday"):
        out = {"daily": job_daily, "monthly": job_monthly, "friday": job_friday}[cmd]()
        if out:
            print(out)
            if "--send" in sys.argv:
                send("trading_command" if cmd == "daily" else "astrology", out)
        sys.exit(0)
    if cmd not in COMMANDS:
        print("commands: " + ", ".join(COMMANDS)); sys.exit(1)
    print(COMMANDS[cmd](args))
