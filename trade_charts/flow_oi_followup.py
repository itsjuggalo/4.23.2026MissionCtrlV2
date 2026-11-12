#!/usr/bin/env python3
"""flow_oi_followup.py — the next-session open-interest follow-up for `/flow <TICKER>` asked outside market hours
(Mike 2026-11-11).

`/flow` run after 16:00 ET, before 09:30 ET, on a weekend or a holiday queues (ticker, Discord channel, session) in
~/.openclaw/data/flow-oi-followup/queue.json (lib/flow_report.maybe_queue). This script, run by cron the next session
morning, takes each queued ticker's biggest prints of that session and runs MissionCtrl's existing next-day OI check on
them (pipeline/intel/oi_confirm.evaluate, called, not copied): OI before → after and OPENING / PARTIAL / NOT CONFIRMED.
It posts that to the Discord channel the question came from AND to Telegram (~/bin/tg-send-msg), then removes the
ticker from the queue.

If the new OI is not newer than the session being checked (CBOE chain still dated that session, or every OI unchanged
because OCC's overnight file is not in yet), it says "OI not updated yet" in the log and keeps the ticker queued: no
stale numbers are posted. An entry still waiting after MAX_AGE_DAYS is dropped with a log line.

Opening vs closing comes only from this OI change; nothing is guessed. Prints ≥ $50K only (flow.db). No proven edge,
advisory only, no size or levels. The bot token is read from ~/.openclaw/secrets and never printed or logged.

CLI:  ~/.venv/bin/python flow_oi_followup.py [--dry] [--queue PATH] [--top 5]
      --dry prints what it would post and changes nothing (no send, queue untouched).
"""
from __future__ import annotations

import argparse
import os
import subprocess
import sys
from datetime import date, datetime
from pathlib import Path

HERE = Path(__file__).resolve().parent
sys.path.insert(0, str(HERE))
sys.path.insert(0, str(HERE.parent))
import lib  # noqa: E402,F401 — bind ~/scripts/lib now; MissionCtrl's pipeline/ has its own lib/
from lib import flow_report as FR  # noqa: E402

MC = "/AIWorkWSL/web/missionctrl"
if MC not in sys.path:
    sys.path.append(MC)   # append: must not shadow ~/scripts/lib
ET = FR.ET
TOP = 5
MAX_AGE_DAYS = 7
SEC = Path.home() / ".openclaw/secrets"
TG_SEND = str(Path.home() / "bin/tg-send-msg")


def log(msg: str) -> None:
    print(f"[flow-oi-followup] {datetime.now(ET):%Y-%m-%d %H:%M} ET {msg}", flush=True)


# ─── the check (MissionCtrl's oi_confirm, restricted to this ticker's biggest prints) ──
def evaluate_for(sym: str, d: str, top: int = TOP) -> tuple[list[dict], dict]:
    """oi_confirm.evaluate(d) on this ticker's top `top` unexpired contracts by session premium. evaluate() reads the
    targets through the module-level `targets` function, so it is swapped for the duration of the call only.
    Returns (rows, {occ: session print totals})."""
    from pipeline.intel import oi_confirm as OC
    from pipeline.intel.common import parse_occ
    seen: dict = {}

    def _targets(d_: str, prints: dict) -> dict:
        mine = sorted((o for o, r in prints.items() if r["sym"] == sym and (parse_occ(o) or {}).get("expiry", "") > d_),
                      key=lambda o: -prints[o]["premium"])[:top]
        seen.update({o: prints[o] for o in mine})
        return {o: {"flow"} for o in mine}

    orig = OC.targets
    OC.targets = _targets
    try:
        rows = OC.evaluate(d)
    finally:
        OC.targets = orig
    return rows, seen


def oi_updated(rows: list[dict], d: str) -> bool:
    """True when at least one contract has a settled verdict from an OI snapshot dated after session d."""
    return any(r.get("new_d") and r["new_d"] > d and r["verdict"] != "PENDING" for r in rows)


def why_not(rows: list[dict]) -> str:
    return next((r.get("new_src") for r in rows if r.get("new_src")), "no newer chain")


def compose(sym: str, d: str, rows: list[dict], prints: dict) -> str:
    from pipeline.intel import oi_confirm as OC
    from pipeline.intel.common import label
    pol = OC.POLICY
    src = next((r["new_src"] for r in rows if r.get("new_oi") is not None), "n/a")
    out = [f"**{sym} · next-day OI check of the {date.fromisoformat(d):%a %m/%d} session** "
           f"(follow-up to /flow {sym} asked after hours)",
           "Biggest prints of that session, OI before → after:"]
    for r in sorted(rows, key=lambda r: -(prints.get(r["occ"], {}).get("premium") or 0)):
        p = prints.get(r["occ"], {})
        out.append(f"• {label(r['occ'])} · {FR.money(p.get('premium'))} printed · {OC.short(r)}")
    out.append(f"_OPENING = OI rose by ≥ {pol['opening_ratio']:.0%} of the printed volume · NOT CONFIRMED = rose ≤ "
               f"{pol['flat_ratio']:.0%} (flat or down: closing, offset or rolled) · PARTIAL in between._")
    out.append(f"_New OI: {src}. Prints ≥ $50K only (flow.db). No proven edge; advisory only._")
    return "\n".join(out)


# ─── sending (never in --dry; token never printed) ────────────────────────────
def _chunks(text: str, cap: int = 1990) -> list[str]:
    parts, cur = [], ""
    for ln in text.splitlines():
        if cur and len(cur) + len(ln) + 1 > cap:
            parts.append(cur)
            cur = ""
        cur += ln[:cap] + "\n"
    return parts + ([cur] if cur.strip() else [])


def send_discord(channel_id: str, text: str) -> bool:
    from lib import ops_card
    token = (SEC / os.environ.get("DISCORD_AIME_TOKEN_FILE", "discord_synthcontrol_token")).read_text().strip()
    return all(ops_card.post_text_bot(str(channel_id), token, c) for c in _chunks(text))


def send_telegram(text: str) -> bool:
    plain = "\n".join(ln.replace("**", "").strip("_") for ln in text.splitlines())   # Telegram: no Discord markdown
    try:
        r = subprocess.run([TG_SEND, plain], capture_output=True, text=True, timeout=60)
        return r.returncode == 0
    except Exception:  # noqa: BLE001
        return False


# ─── one pass over the queue (pure apart from the injected functions) ─────────
def process(entries: list[dict], now: datetime, *, evaluate=evaluate_for, post_discord=send_discord,
            post_tg=send_telegram, dry: bool = False, top: int = TOP) -> tuple[list[dict], list[str]]:
    """Returns (entries done = remove from the queue, log notes). An entry stays queued unless it was posted to
    Discord, had nothing to check, or is older than MAX_AGE_DAYS."""
    done, notes, cache = [], [], {}
    today = now.astimezone(ET).date()
    for e in entries:
        sym, d, ch = e.get("sym"), e.get("session"), e.get("channel_id")
        try:
            sd = date.fromisoformat(d)
        except (TypeError, ValueError):
            notes.append(f"bad queue entry {e} → removed")
            done.append(e)
            continue
        if today <= sd:
            notes.append(f"{sym} {d}: session not over yet → stays queued")
            continue
        if (today - sd).days > MAX_AGE_DAYS:
            notes.append(f"{sym} {d}: no new OI after {MAX_AGE_DAYS} days → dropped")
            done.append(e)
            continue
        key = (sym, d)
        if key not in cache:
            try:
                cache[key] = evaluate(sym, d, top)
            except Exception as ex:  # noqa: BLE001
                cache[key] = ex
        res = cache[key]
        if isinstance(res, Exception):
            notes.append(f"{sym} {d}: check failed ({type(res).__name__}: {str(res)[:80]}) → stays queued")
            continue
        rows, prints = res
        if not rows:
            msg = (f"**{sym} · next-day OI check of the {sd:%a %m/%d} session**: no unexpired contracts printed "
                   f"≥ $50K that session, nothing to check. Prints ≥ $50K only (flow.db).")
        elif not oi_updated(rows, d):
            notes.append(f"{sym} {d}: OI not updated yet ({why_not(rows)[:90]}) → stays queued")
            continue
        else:
            msg = compose(sym, d, rows, prints)
        if dry:
            notes.append(f"[dry] would post to Discord channel {ch} and Telegram:\n{msg}")
            done.append(e)
            continue
        ok = post_discord(ch, msg)
        tg = post_tg(msg)
        notes.append(f"{sym} {d}: Discord {'sent' if ok else 'FAILED'} · Telegram {'sent' if tg else 'FAILED'}")
        if ok:
            done.append(e)
    return done, notes


def main(argv=None) -> int:
    ap = argparse.ArgumentParser(description=__doc__.split("\n")[0])
    ap.add_argument("--dry", action="store_true", help="print what would be posted; send nothing, keep the queue")
    ap.add_argument("--queue", default=str(FR.QUEUE))
    ap.add_argument("--top", type=int, default=TOP)
    a = ap.parse_args(argv)
    path = Path(a.queue)
    entries = FR.read_queue(path)
    if not entries:
        log("queue empty")
        return 0
    done, notes = process(entries, datetime.now(ET), dry=a.dry, top=a.top)
    for n in notes:
        log(n)
    if a.dry or not done:
        return 0
    with FR._Lock(path):   # re-read: /flow may have queued more while this ran
        gone = {(x.get("sym"), str(x.get("channel_id")), x.get("session")) for x in done}
        left = [x for x in FR.read_queue(path) if (x.get("sym"), str(x.get("channel_id")), x.get("session")) not in gone]
        FR.write_queue(left, path)
    log(f"{len(done)} done, {len(left)} still queued")
    return 0


if __name__ == "__main__":
    sys.exit(main())
