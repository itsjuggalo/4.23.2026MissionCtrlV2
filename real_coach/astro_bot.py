#!/usr/bin/env python3
"""astro_bot.py — the astrology lane's deterministic front door (called by tg_responder).

  echo '{"text": "...", "chat": 123}' | astro_bot.py route
    → {"reply": str|null, "context": str|null, "intent": ..., "request_id": ...}
  reply   = a finished, fully computed answer (send it as-is; no LLM)
  context = null reply → the COMPUTED FACTS block the LLM must answer from (astro_facts.RULES)

Commands owned here: /today /week /progressions /synastry /progsyn /profile /chart
(/moon + /moonguide live in tg_responder's ASTRO_MODULE_CMDS → astro_moon.py).
Plain words are routed by astro_facts.detect(): today · week · progressions · timeline ·
placement · exact · strongest · synastry · progressed synastry; anything else → LLM + facts.
Another person's chart without a stored profile → UNAVAILABLE (never a guessed chart).
Every request writes one privacy-safe trace row (astro_trace).
"""
from __future__ import annotations

import json
import re
import subprocess
import sys
from pathlib import Path

HERE = Path(__file__).resolve().parent
sys.path.insert(0, str(HERE))
import astro_trace as TR  # noqa: E402

PY = sys.executable
PROFILE_USAGE = ("/profile add <name> <YYYY-MM-DD> <HH:MM|unknown> <birth place>\n"
                 "e.g. /profile add Sam 1994-06-12 14:30 Tampa, FL  (unknown time → no ASC/houses)\n"
                 "/profile show <name> · /profile delete <name> · /profile list")
PROFILE_HELP = "Add a birth profile first:\n" + PROFILE_USAGE


def _run(script: str, *args: str, timeout: int = 180) -> str:
    try:
        r = subprocess.run([PY, str(HERE / script), *args], capture_output=True, text=True, timeout=timeout)
        return (r.stdout or "").strip() or f"[{script} rc={r.returncode}] {(r.stderr or '').strip()[-300:]}"
    except subprocess.TimeoutExpired:
        return f"[{script} timed out — try again in a minute]"


def chart_card() -> str:
    import astro_truth as T
    n = T.natal()
    order = ["Sun", "Moon", "ASC", "MC", "Mercury", "Venus", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune",
             "Pluto", "Chiron", "Juno"]
    lines = ["🪐 MIKE'S NATAL CHART — Nov 3 1992, 10:46 PM EST, Dunedin FL (computed live, Swiss Ephemeris)"]
    for k in order:
        v = n[k]
        lines.append(f"{k}: {v['dms']}" + (f" · {T.ordinal(v['house'])} house" if k not in ("ASC", "MC") else "")
                     + (" ℞" if v["rx"] else ""))
    lines.append(f"Chart ruler: {T.CHART_RULER} · tropical · Placidus. /transits for today's sky.")
    return "\n".join(lines)


def _profiles_in(text: str) -> list[dict]:
    import astro_facts as F
    return F.profiles_named(text)


def _synastry(text: str, progressed: bool) -> tuple[str, str]:
    import astro_profiles as P
    others = _profiles_in(text)
    if not others:
        names = [p["name"] for p in P.all_profiles() if p["id"] != "mike"]
        return ("UNAVAILABLE — no stored birth profile matches that name, and I only compute charts from stored profiles"
                + (f" (on file: {', '.join(names)})" if names else " (none on file yet)") + ".\n" + PROFILE_HELP,
                "none")
    a, b = "mike", others[0]["id"]
    if len(others) >= 2:
        a, b = others[0]["id"], others[1]["id"]
    return (_run("astro_synastry.py", a, b, *(["--progressed"] if progressed else [])),
            "astro_synastry.progressed" if progressed else "astro_synastry")


def _profile_cmd(args: list[str]) -> str:
    if not args or args[0] == "list":
        return _run("astro_profiles.py", "list") + "\n\nUsage:\n" + PROFILE_USAGE
    if args[0] == "add":
        if len(args) < 5:
            return "Usage:\n" + PROFILE_USAGE
        out = _run("astro_profiles.py", *args, timeout=60)
        return out + ("\nNow try: /synastry " + args[1] if out.startswith("saved") else "")
    if args[0] in ("show", "delete") and len(args) > 1:
        return _run("astro_profiles.py", *args)
    return "Usage:\n" + PROFILE_USAGE


def route(text: str, chat=None) -> dict:
    import astro_facts as F
    rid = TR.new_id()
    with TR.Timer() as tm:
        reply, context, calc = None, None, None
        parts = text.strip().split()
        cmd = parts[0].lower().split("@")[0] if parts and parts[0].startswith("/") else ""
        intent = cmd or F.detect(text)["intent"]
        try:
            if cmd in ("/today", "/daily"):
                reply, calc = _run("daily_transits.py"), "daily_transits"
            elif cmd == "/week":
                reply, calc = _run("astro_weekly.py"), "astro_weekly"
            elif cmd in ("/progressions",):
                reply, calc = _run("daily_transits.py", "--progressed"), "svehla.progressed"
            elif cmd == "/chart":
                reply, calc = chart_card(), "astro_truth.natal"
            elif cmd == "/profile":
                reply, calc = _profile_cmd(parts[1:]), "astro_profiles"
            elif cmd in ("/synastry", "/progsyn"):
                if len(parts) < 2:
                    reply, calc = f"Usage: {cmd} <name> [second name]\n" + _profile_cmd(["list"]), "astro_profiles"
                else:
                    reply, calc = _synastry(" ".join(parts[1:]), cmd == "/progsyn")
            elif cmd:
                return {"reply": None, "context": None, "intent": cmd, "request_id": rid, "handled": False}
            else:
                d = F.detect(text)
                it = d["intent"]
                named = _profiles_in(text)
                if it in ("synastry", "progressed_synastry"):
                    reply, calc = _synastry(text, it == "progressed_synastry")
                elif named and it in ("placement", "chart", "general", "sky", "moon") and \
                        re.search(r"\b(chart|sign|rising|ascendant|placements?|house|natal|born|" +
                                  "|".join(F.PLANETS).lower() + r")\b", text.lower()) and \
                        not re.search(r"\b(general|tell me about|what does .* mean|interpret|read)\b", text.lower()):
                    reply, calc = F.answer_profile(text, named[0]), "astro_facts.profile_chart"
                elif named:            # interpretive question about a stored person → LLM with THEIR chart
                    context, calc = F.llm_context(text), "astro_facts.llm_context+profile"
                elif d.get("other_chart"):
                    reply, calc = ("UNAVAILABLE — I don't have that person's birth data, so I can't say anything "
                                   "about their chart. " + PROFILE_HELP), "none"
                elif it == "profile":
                    reply, calc = PROFILE_HELP, "astro_profiles"
                elif it == "chart":
                    reply, calc = chart_card(), "astro_truth.natal"
                elif it == "year":
                    reply, calc = _run("astro_timeline.py", "year"), "astro_timeline.year"
                elif it == "today":
                    reply, calc = _run("daily_transits.py"), "daily_transits"
                elif it == "week":
                    reply, calc = _run("astro_weekly.py"), "astro_weekly"
                elif it == "progressions":
                    reply, calc = _run("daily_transits.py", "--progressed"), "svehla.progressed"
                elif it == "moon":
                    reply, calc = _run("astro_moon.py", "now"), "astro_moon"
                elif it == "timeline":
                    reply, calc = _run("astro_timeline.py", "30"), "astro_timeline"
                else:
                    reply = F.answer(text)
                    calc = f"astro_facts.{it}" if reply else None
                    if not reply:
                        context, calc = F.llm_context(text), "astro_facts.llm_context"
        except Exception as e:
            reply, calc = None, "error"
            context = None
            TR.log(request_id=rid, chat=chat, intent=intent, calculator="error", error=str(e), lane="astrology")
            return {"reply": f"⚠️ calculation failed ({type(e).__name__}) — nothing guessed. Try /today or /help.",
                    "context": None, "intent": intent, "request_id": rid, "handled": True}
    TR.log(request_id=rid, chat=chat, intent=intent, calculator=calc, duration_ms=tm.ms,
           model=None if reply else "llm", lane="astrology", command=cmd or None)
    return {"reply": reply, "context": context, "intent": intent, "request_id": rid, "handled": True}


if __name__ == "__main__":
    if sys.argv[1:2] == ["route"]:
        req = json.loads(sys.stdin.read() or "{}")
        print(json.dumps(route(req.get("text", ""), req.get("chat")), ensure_ascii=False))
    elif sys.argv[1:2] == ["chart"]:
        print(chart_card())
    else:
        print(__doc__)
