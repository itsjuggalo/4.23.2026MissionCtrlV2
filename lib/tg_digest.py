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
# internal trigger ids ("AMD:WATCH:202610061136", "id MU:DECIPHER:...") are for logs/state, not readers
_TRIG_ID = re.compile(r"(?:\s*[·—-]\s*|\s+id\s+|\s+)?\b[A-Z][A-Z0-9.\-]{0,9}:[A-Z_]{3,14}:\d{6,14}\b")
_HEADLINE = re.compile(r"^\s*•\s*\[([A-Z][A-Z0-9.\-]{0,9})\]\s*(.+)$")        # "• [NBIS] headline — src · 4m"
MAX_HEADLINES = 3
_GATE = re.compile(r"GATE BLOCKED", re.I)
_GSYM = re.compile(r"\bThe ([A-Z]{1,6}) (?:call|put)\b")
_G = "\x00GATE\x00"        # sentinel row prefix: build() folds all of these into one line
_AGE = re.compile(r"\s*·\s*\d+\s*[smhd]\s*$")
_PULL = re.compile(r"is \$([\d,.]+).*?from is \$([\d,.]+)\s*[–-]\s*\$([\d,.]+)")


def _clip(s: str, n: int = 80) -> str:
    """Clip at a sentence end or word boundary (never mid-word / mid-sentence) + "…"."""
    s = re.sub(r"\s+", " ", s).strip().lstrip("·—").strip().rstrip(" ·—,")   # keep a leading "-38%"
    if len(s) <= n:
        return s
    cut = s[: n - 1]
    end = max(cut.rfind(". "), cut.rfind("; "), cut.rfind(" — "))
    if end >= n * 0.5:
        return cut[: end + 1].rstrip(" —;") + "…"
    sp = cut.rfind(" ")
    return (cut[:sp] if sp >= n * 0.4 else cut).rstrip(" ,;:—-·(") + "…"


# Context a clip must never drop (MC-AUD-080): OCC contract ids, as-of stamps and missing/stale warnings.
_KEEP = re.compile(r"\b[A-Z]{1,6}\d{6}[CP]\d{8}\b|\bas[_ ]of\s+[^·—;]{1,24}|\b(?:STALE|UNAVAILABLE|MISSING|"
                   r"not Robinhood|UNKNOWN)\b[^·—;]{0,24}", re.I)


def _clip_keep(s: str, n: int = 80) -> str:
    """_clip, then re-append any must-keep context the clip cut off."""
    out = _clip(s, n)
    lost = [m.group(0).strip() for m in _KEEP.finditer(re.sub(r"\s+", " ", s)) if m.group(0).strip() not in out]
    return out + (" · " + " · ".join(dict.fromkeys(lost)) if lost else "")


# Direction is part of a row's identity: a PUT row must not overwrite the same ticker's CALL row.
_SIDE = re.compile(r"\b(CALLS?|PUTS?|BULLISH|BEARISH|LONG|SHORT)\b", re.I)
_SIDE_NORM = {"CALL": "call", "CALLS": "call", "BULLISH": "call", "LONG": "call",
              "PUT": "put", "PUTS": "put", "BEARISH": "put", "SHORT": "put"}


def _side(rest: str) -> str:
    m = _SIDE.search(rest)
    return _SIDE_NORM.get(m.group(1).upper(), "") if m else ""


def strip_internal_ids(text: str) -> str:
    """Drop reader-facing trigger ids; the originals stay in logs/state."""
    return _TRIG_ID.sub("", text)


def _esc(s: str) -> str:
    return _html.escape(s, quote=False)


def compact(source: str, text: str, html: bool) -> tuple[str, list[tuple[str, str]]]:
    """(section title, [(key, one-line html row)]) for one queued message."""
    src_html = strip_internal_ids(text if html else _esc(text))
    lines = [ln for ln in src_html.split("\n") if ln.strip()]
    title = TITLES.get(source, source.rsplit(".", 1)[0].replace("_", " "))
    if lines:
        m = _HDR.match(lines[0])
        if m and not _ROW.match(lines[0]):
            title = _TIME.sub("", _STAMP.sub("", _html.unescape(m.group(1)))).strip(" ·—-").title()
    rows: list[tuple[str, str]] = []
    heads = 0
    for ln in lines:
        hm_ = _HEADLINE.match(_plain(ln, True))
        if hm_:                       # headline bullets: keep up to MAX_HEADLINES, never a bare header
            if heads < MAX_HEADLINES:
                heads += 1
                rows.append((f"hl:{hm_.group(1)}:{heads}", f"📰 <b>{hm_.group(1)}</b> {_esc(_clip(hm_.group(2), 110))}"))
            continue
        m = _ROW.match(ln)
        if m:
            glyph, tkr, rest = m.group(1).strip(), m.group(2), _plain(m.group(3), True)
        elif (pm2 := _PROW.match(_plain(ln, True))):
            glyph, tkr, rest = "", pm2.group(1), pm2.group(2)
        else:
            continue
        if not rest.strip():
            continue                  # a bold section label ("<b>SETUPS</b>", "📰 <b>HEADLINES</b>"), not a ticker
        if source == "pullback_autowatch.py" and (pm := _PULL.search(rest)):
            g = [x.strip(",.") for x in pm.groups()]
            rest = f"${g[0]} · buy zone ${g[1]}–${g[2]}"
        glyph = "" if glyph in ("", "▸") else glyph + " "
        side = _side(rest)
        rows.append((f"{tkr}:{side}" if side else tkr, f"{glyph}<b>{tkr}</b> {_esc(_clip_keep(rest))}"))
    if source == "flow_digest_send.py" and _plain(text, html).lstrip().startswith("🔁"):
        return title, rows           # 🔁 REPEAT = "no new info": counted, not shown
    if not rows and lines and _GATE.search(_plain(lines[0], True)):
        gp = _plain(" ".join(lines), True)
        sym = _GSYM.search(gp)
        tm = re.search(r"GATE BLOCKED\s*[—-]\s*(\d{1,2}:\d\d)", gp)
        rows.append((f"gate:{tm.group(1) if tm else len(gp)}",
                     f"{_G}other\x00{sym.group(1) if sym else ''}"))
        return title, rows
    if not rows:     # no ticker rows (verdict notes, recaps): keep the first real line(s)
        body = [_plain(ln, True) for ln in lines
                if not ln.lstrip().startswith("<i>") and not (_HDR.match(ln) and ln is lines[0])]
        snippet = _clip(" — ".join(body[:2]), 140) if body else _clip(_plain(lines[0], True) if lines else "", 140)
        if snippet:
            rows.append((snippet[:40], _esc(snippet)))
    return title, rows


def _headline_key(line: str) -> str | None:
    """Normalised text of a 📰 row (ticker + age dropped) so the same story isn't re-sent."""
    if not line.startswith("📰"):
        return None
    t = _AGE.sub("", _plain(line, True)[1:].strip())
    t = re.sub(r"^[A-Z][A-Z0-9.\-]{0,9}\s+", "", t.strip())
    return re.sub(r"\W+", " ", t).strip().lower() or None


def headline_keys(items: list[tuple]) -> set[str]:
    """Headlines already present in earlier digests (items: (ts, source, html, text))."""
    seen: set[str] = set()
    for ts, src, html, text in items:
        for _k, line in compact(src, text, bool(html))[1]:
            k = _headline_key(line)
            if k:
                seen.add(k)
    return seen


def build(items: list[tuple], now: float | None = None, first_of_day: bool = True,
          seen_headlines: set | None = None) -> list[str]:
    """items: (ts, source, html, text) oldest→newest. Returns digest message chunks.
    first_of_day: carry the one-time explainer line; seen_headlines: normalised headlines
    already sent in an earlier digest today (dropped)."""
    now = now or time.time()
    seen = set(seen_headlines or ())
    sections: dict[str, dict] = {}
    gates: dict[str, tuple] = {}              # every GATE BLOCKED window → ONE line
    for ts, src, html, text in items:
        title, rows = compact(src, text, bool(html))
        sec = sections.setdefault(title, {"rows": {}, "msgs": 0, "last": ts})
        sec["msgs"] += 1
        sec["last"] = max(sec["last"], ts)
        for key, line in rows:                # newest wins, keeps first-seen order
            if line.startswith(_G):
                _, kind, sym = line.split("\x00")[1:]
                gates[key] = (kind, sym)
                continue
            hk = _headline_key(line)
            if hk:
                if hk in seen:
                    continue                  # already sent in an earlier digest today
                seen.add(hk)
            sec["rows"].pop(key, None)
            sec["rows"][key] = line
    if gates:
        n_g = len(gates)
        syms = sorted({sy for _, sy in gates.values() if sy})
        line = f"🔴 {n_g} blocked (no qualifying contract)" + (f": {', '.join(syms)}" if syms else "")
        gtitle = next(iter(sections), "Flow digest")
        for t, sec in sections.items():
            if t.lower().startswith("flow"):
                gtitle = t
        sections.setdefault(gtitle, {"rows": {}, "msgs": 0, "last": items[-1][0]})
        sections[gtitle]["rows"] = {"gate": line, **sections[gtitle]["rows"]}
    hm = lambda t: time.strftime("%-I:%M ET", time.localtime(t))
    n = len(items)
    head = (f"🧾 <b>TRADING DIGEST</b> · {time.strftime('%a %m-%d', time.localtime(now))} {hm(now)}\n"
            f"{n} FYI update{'' if n == 1 else 's'} folded since {hm(items[0][0])}"
            + (" — entries/exits/🟢 arrive instantly in Trading Command" if first_of_day else ""))
    blocks = []
    for title, sec in sections.items():
        rows = list(sec["rows"].values())
        if not rows:
            continue                  # never a section header with nothing under it
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
    chat = open(tg_fleet.CHAT_FILE).read().strip()
    def post(t, mode):   # tg_fleet.call: pinned bot, ledger, TG_DRY_RUN (script-standard #6); digests never buzz
        kw = {"chat_id": chat, "text": t, "disable_web_page_preview": "true",
              "disable_notification": "true", "_review": False}
        if mode:
            kw["parse_mode"] = mode
        return bool(tg_fleet.call(DELIVER_FN, "sendMessage", **kw).get("ok"))
    ok = post(text, "HTML") or post(_plain(text, True), None)
    return ok


def flush(dry: bool = False) -> int:
    con = _con()
    try:
        rows = con.execute("SELECT id, ts, source, html, text FROM digest_queue "
                           "WHERE flushed IS NULL ORDER BY ts").fetchall()
        if not rows:
            print("[tg-digest] nothing queued"); return 0
        day0 = time.mktime(time.localtime()[:3] + (0, 0, 0, 0, 0, -1))
        prior = con.execute("SELECT ts, source, html, text FROM digest_queue "
                            "WHERE flushed IS NOT NULL AND flushed >= ? ORDER BY ts", (day0,)).fetchall()
        chunks = build([r[1:] for r in rows], first_of_day=not prior,
                       seen_headlines=headline_keys(prior))
        if dry:
            print("\n\n".join(chunks)); return 0
        # A chunk delivered by an earlier, partly failed flush is not sent again (MC-AUD-080): its hash is kept in
        # digest_chunks until the whole digest lands.
        import hashlib
        con.execute("CREATE TABLE IF NOT EXISTS digest_chunks (hash TEXT PRIMARY KEY, ts REAL)")
        done = {h for (h,) in con.execute("SELECT hash FROM digest_chunks")}
        ok_all = True
        for c in chunks:
            h = hashlib.sha256(c.encode()).hexdigest()
            if h in done:
                continue
            if _send(c):
                con.execute("INSERT OR IGNORE INTO digest_chunks VALUES (?, ?)", (h, time.time()))
                con.commit()
            else:
                ok_all = False
                break
        if ok_all:
            con.executemany("UPDATE digest_queue SET flushed=? WHERE id=?",
                            [(time.time(), r[0]) for r in rows])
            con.execute("DELETE FROM digest_chunks")
            con.commit()
            print(f"[tg-digest] delivered {len(chunks)} message(s) folding {len(rows)} updates")
            return 0
        print("[tg-digest] send failed — items stay queued; delivered chunks are not re-sent")
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
