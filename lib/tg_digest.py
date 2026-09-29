#!/usr/bin/env python3
"""tg_digest — fold FYI trading pushes into a few compact digests (2026-09-28).

Mike: "I don't want to scroll through hundreds of messages a day." Act-now messages
(entries, exits, stops, 🟢 TRADE, price alerts, the morning brief, watchdogs) still send
instantly. Watchlists, radars, pulses and recaps are QUEUED here instead and delivered
as one silent digest per slot, one line per ticker, deduped, newest wins.

Hooked into tg_fleet.send() and lib/notify.tg_push(); the sender sees a normal success.
Decided by the SENDING SCRIPT (lib/tg_ledger.source) + the message text — no sender
changes. Unknown sources always send instantly (fail open).

Kill switch (everything instant again, queue kept):  touch ~/.config/tg-digest/OFF
  python3 lib/tg_digest.py flush [--dry]     # send (or print) the pending digest
  python3 lib/tg_digest.py status            # what is queued right now
Cron: weekdays 10:00 11:30 13:00 14:30 16:00 16:50, daily 21:00 (catch-all).
"""
from __future__ import annotations

import html as _html
import json
import os
import re
import sqlite3
import sys
import time
import urllib.parse
import urllib.request
from pathlib import Path

HOME = Path.home()
DB = Path(os.environ.get("TG_LEDGER_DB", str(HOME / ".local/state/tg-ledger.sqlite")))
OFF = HOME / ".config/tg-digest/OFF"
LANES = {"trading_command", "flow_digest"}        # trading lanes this layer intercepts
DELIVER_FN = "trading_digest"                      # @Boba2Telegram_Bot "Trading Digest" (idle bot, 2026-09-28)
# Sources that get their OWN bot instead of Trading Command (2026-09-28 — idle bots put to
# work so Trading Command carries act-now messages only). Sent immediately, not folded.
RELANE = {
    "eod_scorecard.py": "trading_recaps", "best3_grader.py": "trading_recaps",
    "report_card.py": "trading_recaps", "signal_outcomes.py": "trading_recaps",
    "btc_monitor.py": "crypto_desk", "btc_sentiment.py": "crypto_desk",
}
MAX_ROWS = 10                                      # per section, per digest
TG_MAX = 3900
_SCHEMA = """CREATE TABLE IF NOT EXISTS digest_queue (
    id INTEGER PRIMARY KEY, ts REAL NOT NULL, fn TEXT, source TEXT, html INTEGER,
    text TEXT, flushed REAL)"""

# ── policy: which sources are FYI (digest) ────────────────────────────────────
TITLES = {   # section name when a (chunked) message carries no tg_format header
    "pullback_autowatch.py": "Pullback watch", "runner_radar.py": "Runner radar",
    "flow_pulse.py": "Flow pulse",
    "flow_digest_send.py": "Flow digest", "explosion_score.py": "Explosion watch",
}


def _plain(text: str, html: bool) -> str:
    t = re.sub(r"<[^>]+>", "", text) if html else text
    return _html.unescape(t) if html else t


def mode(source: str, text: str, html: bool = True) -> str:
    """'digest' or 'instant' for one message."""
    p = _plain(text, html).lstrip()
    if source in ("pullback_autowatch.py", "runner_radar.py", "flow_pulse.py"):
        # flow_picks_post stays instant: 3 sized pick cards a day (09:50/12:30/15:00)
        return "digest"
    if source == "flow_digest_send.py":            # 🟢 TRADE buzzes; 🟡/🔴/🔁 are FYI
        return "instant" if p.startswith("🟢") else "digest"
    if source == "explosion_score.py":             # SETUP card instant, WATCH list FYI
        return "digest" if "EXPLOSION WATCH" in p.upper() else "instant"
    return "instant"


def enabled() -> bool:
    return not OFF.exists() and os.environ.get("TG_DIGEST_OFF") != "1"


def _con():
    DB.parent.mkdir(parents=True, exist_ok=True)
    con = sqlite3.connect(DB, timeout=5)
    con.execute(_SCHEMA)
    return con


def intercept(fn: str, text: str, html: bool = True) -> bool:
    """True = queued for the next digest (caller must NOT send). Never raises; any
    problem returns False so the message goes out instantly as before."""
    try:
        if not enabled() or fn not in LANES or not text:
            return False
        sys.path.insert(0, str(Path(__file__).resolve().parents[1]))
        from lib.tg_ledger import source, source_chain
        src = source()
        lane = next((RELANE[s] for s in [src, *source_chain()] if s in RELANE), None)
        if lane:                                   # also catches shared helpers (mc_sms.py) sending for btc_*
            return _relane(lane, text, html)
        if mode(src, text, html) != "digest":
            return False
        con = _con()
        try:
            con.execute("INSERT INTO digest_queue (ts, fn, source, html, text) VALUES (?,?,?,?,?)",
                        (time.time(), fn, src, int(bool(html)), text))
            con.commit()
        finally:
            con.close()
        print(f"[tg-digest] queued {src} for the next digest", file=sys.stderr)
        return True
    except Exception:
        return False


def _relane(fn: str, text: str, html: bool) -> bool:
    """Deliver on the source's own bot. False (→ caller sends on the original lane) on failure."""
    stub = os.environ.get("TG_DIGEST_SEND")
    if stub:                                         # tests
        import subprocess
        return subprocess.run([stub, f"[{fn}] {text}"]).returncode == 0
    import contextlib, io
    sys.path.insert(0, str(Path(__file__).resolve().parents[1]))
    import tg_fleet
    with contextlib.redirect_stdout(io.StringIO()):
        ok = tg_fleet.send(fn, text, html=html) == 0
    print(f"[tg-digest] {'sent' if ok else 'FAILED'} on {fn}", file=sys.stderr)
    return ok


# ── compaction ────────────────────────────────────────────────────────────────
_HDR = re.compile(r"^\W{0,4}\s*<b>([^<]{2,40})</b>")
_STAMP = re.compile(r"\s*·\s*(Mon|Tue|Wed|Thu|Fri|Sat|Sun)\s+\d\d-\d\d\s+\d\d:\d\d\s+ET.*$")
_ROW = re.compile(r"^([^<A-Za-z0-9]{0,14})<b>\$?([A-Z][A-Z0-9.\-/]{0,9})</b>(.*)$")
_PROW = re.compile(r"^\s*[▸•]\s*\$?([A-Z][A-Z0-9.\-]{0,9})\b(.*)$")   # plain "▸ SMCI 62 — why"
_TIME = re.compile(r"\s*\d{1,2}:\d\d\s*(AM|PM)?\s*(ET)?", re.I)
_PULL = re.compile(r"is \$([\d,.]+).*?from is \$([\d,.]+)\s*[–-]\s*\$([\d,.]+)")


def _clip(s: str, n: int = 80) -> str:
    s = re.sub(r"\s+", " ", s).strip().lstrip("·—").strip().rstrip(" ·—,")   # keep a leading "-38%"
    return s if len(s) <= n else s[: n - 1].rstrip() + "…"


def _esc(s: str) -> str:
    return _html.escape(s, quote=False)


def compact(source: str, text: str, html: bool) -> tuple[str, list[tuple[str, str]]]:
    """(section title, [(key, one-line html row)]) for one queued message."""
    src_html = text if html else _esc(text)
    lines = [ln for ln in src_html.split("\n") if ln.strip()]
    title = TITLES.get(source, source.rsplit(".", 1)[0].replace("_", " "))
    if lines:
        m = _HDR.match(lines[0])
        if m and not _ROW.match(lines[0]):
            title = _TIME.sub("", _STAMP.sub("", _html.unescape(m.group(1)))).strip(" ·—-").title()
    rows: list[tuple[str, str]] = []
    for ln in lines:
        m = _ROW.match(ln)
        if m:
            glyph, tkr, rest = m.group(1).strip(), m.group(2), _plain(m.group(3), True)
        elif (pm2 := _PROW.match(_plain(ln, True))):
            glyph, tkr, rest = "", pm2.group(1), pm2.group(2)
        else:
            continue
        if not rest.strip() and not glyph:
            continue                  # a bold section label ("<b>SETUPS</b>"), not a ticker
        if source == "pullback_autowatch.py" and (pm := _PULL.search(rest)):
            g = [x.strip(",.") for x in pm.groups()]
            rest = f"${g[0]} · buy zone ${g[1]}–${g[2]}"
        glyph = "" if glyph in ("", "▸") else glyph + " "
        rows.append((tkr, f"{glyph}<b>{tkr}</b> {_esc(_clip(rest))}"))
    if source == "flow_digest_send.py" and _plain(text, html).lstrip().startswith("🔁"):
        return title, rows           # 🔁 REPEAT = "no new info": counted, not shown
    if not rows:     # no ticker rows (verdict notes, recaps): keep the first real line(s)
        body = [_plain(ln, True) for ln in lines
                if not ln.lstrip().startswith("<i>") and not (_HDR.match(ln) and ln is lines[0])]
        snippet = _clip(" — ".join(body[:2]), 140) if body else _clip(_plain(lines[0], True) if lines else "", 140)
        if snippet:
            rows.append((snippet[:40], _esc(snippet)))
    return title, rows


def build(items: list[tuple], now: float | None = None) -> list[str]:
    """items: (ts, source, html, text) oldest→newest. Returns digest message chunks."""
    now = now or time.time()
    sections: dict[str, dict] = {}
    for ts, src, html, text in items:
        title, rows = compact(src, text, bool(html))
        sec = sections.setdefault(title, {"rows": {}, "msgs": 0, "last": ts})
        sec["msgs"] += 1
        sec["last"] = max(sec["last"], ts)
        for key, line in rows:                # newest wins, keeps first-seen order
            sec["rows"].pop(key, None)
            sec["rows"][key] = line
    hm = lambda t: time.strftime("%H:%M", time.localtime(t))
    head = (f"🧾 <b>TRADING DIGEST</b> · {time.strftime('%a %m-%d %H:%M ET', time.localtime(now))}\n"
            f"{len(items)} FYI updates folded since {hm(items[0][0])} — "
            f"entries/exits/🟢 arrive instantly in Trading Command")
    blocks = []
    for title, sec in sections.items():
        rows = list(sec["rows"].values())
        more = len(rows) - MAX_ROWS
        body = "\n".join(rows[-MAX_ROWS:])
        extra = f"\n<i>+{more} more — dashboard</i>" if more > 0 else ""
        blocks.append(f"\n<b>{_esc(title.upper())}</b> <i>({sec['msgs']}×, last {hm(sec['last'])})</i>\n"
                      f"{body}{extra}")
    chunks, cur = [], head
    for blk in blocks:
        if len(cur) + len(blk) > TG_MAX:
            chunks.append(cur); cur = "🧾 <b>TRADING DIGEST</b> (cont.)"
        cur += "\n" + blk
    chunks.append(cur)
    return chunks


# ── delivery ──────────────────────────────────────────────────────────────────
def _send(text: str) -> bool:
    stub = os.environ.get("TG_DIGEST_SEND")          # tests point this at a stub
    if stub:
        import subprocess
        return subprocess.run([stub, text]).returncode == 0
    sys.path.insert(0, str(Path(__file__).resolve().parents[1]))
    import tg_fleet
    tok = tg_fleet.token(tg_fleet.route(DELIVER_FN))
    chat = open(tg_fleet.CHAT_FILE).read().strip()
    def post(t, mode):
        d = {"chat_id": chat, "text": t, "disable_web_page_preview": "true",
             "disable_notification": "true"}           # digests never buzz
        if mode:
            d["parse_mode"] = mode
        try:
            with urllib.request.urlopen(urllib.request.Request(
                    f"https://api.telegram.org/bot{tok}/sendMessage",
                    data=urllib.parse.urlencode(d).encode()), timeout=20) as r:
                return bool(json.load(r).get("ok"))
        except Exception:
            return False
    ok = post(text, "HTML") or post(_plain(text, True), None)
    try:
        from lib.tg_ledger import record
        record(DELIVER_FN, text, ok, html=True, src="tg_digest.py")
    except Exception:
        pass
    return ok


def flush(dry: bool = False) -> int:
    con = _con()
    try:
        rows = con.execute("SELECT id, ts, source, html, text FROM digest_queue "
                           "WHERE flushed IS NULL ORDER BY ts").fetchall()
        if not rows:
            print("[tg-digest] nothing queued"); return 0
        chunks = build([r[1:] for r in rows])
        if dry:
            print("\n\n".join(chunks)); return 0
        if all(_send(c) for c in chunks):
            con.executemany("UPDATE digest_queue SET flushed=? WHERE id=?",
                            [(time.time(), r[0]) for r in rows])
            con.commit()
            print(f"[tg-digest] sent {len(chunks)} message(s) folding {len(rows)} updates")
            return 0
        print("[tg-digest] send failed — items stay queued for the next slot")
        return 1
    finally:
        con.close()


def status() -> None:
    con = _con()
    for src, n, a in con.execute("SELECT source, COUNT(*), MIN(ts) FROM digest_queue "
                                 "WHERE flushed IS NULL GROUP BY source"):
        print(f"  {src:28} {n:3} queued since {time.strftime('%H:%M', time.localtime(a))}")
    print(f"digest {'OFF (kill switch)' if not enabled() else 'ON'}")


if __name__ == "__main__":
    a = sys.argv[1:]
    if a[:1] == ["flush"]:
        sys.exit(flush(dry="--dry" in a))
    status()
