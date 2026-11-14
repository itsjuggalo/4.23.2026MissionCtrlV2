#!/usr/bin/env python3
"""text_card: render a slash command's text reply as dark, Unusual-Whales-style image cards.

The card is built by parsing the command's own text (text_card_parse), so card data == command data.
    render_cards("/oi NVDA", text) -> {"pngs": [paths], "links": [urls]}
PIL only, no network, no LLM. Adds no claims: it only lays out what the text already says.
"""
from __future__ import annotations

import re
import time
from datetime import datetime
from pathlib import Path
from zoneinfo import ZoneInfo

from PIL import Image, ImageDraw, ImageFont

BG, PANEL, STRIPE, RULE = "#0d1117", "#161b22", "#11161d", "#30363d"
TXT, MUTED, HEAD = "#e6edf3", "#8b949e", "#c9d1d9"
GREEN, RED, AMBER, BLUE = "#3fb950", "#f85149", "#d29922", "#58a6ff"
_FD = "/usr/share/fonts/truetype/dejavu/"
S = 2                      # supersample
W, PADX, PAGE_H = 900, 22, 1000   # logical px
FS = 14
OUT = Path.home() / ".openclaw" / "workspace" / "charts"
ET = ZoneInfo("America/New_York")


def P(v):
    return int(round(v * S))


X0, CW = P(PADX), P(W - 2 * PADX)
_fonts: dict = {}
_cmap = None


def font(size=FS, bold=False, mono=False):
    k = (size, bold, mono)
    if k not in _fonts:
        name = ("DejaVuSansMono" if mono else "DejaVuSans") + ("-Bold" if bold else "") + ".ttf"
        _fonts[k] = ImageFont.truetype(_FD + name, P(size))
    return _fonts[k]


def _has(ch):
    global _cmap
    if _cmap is None:
        try:
            from fontTools.ttLib import TTFont
            _cmap = set(TTFont(_FD + "DejaVuSans.ttf", lazy=True).getBestCmap())
        except Exception:  # noqa: BLE001
            _cmap = False
    if _cmap is False:
        return ord(ch) < 0x1F000 and ord(ch) != 0xFE0F
    return ord(ch) in _cmap


def clean(s):
    return "".join(c for c in s.replace("\t", " ") if c == " " or (_has(c) and not 0xFE00 <= ord(c) <= 0xFE0F and c != "\u200d"))


EMO = {"🟢": ("●", GREEN), "🔴": ("●", RED), "⚪": ("○", MUTED), "✅": ("✓", GREEN), "❌": ("✗", RED),
       "❔": ("?", AMBER), "⛔": ("⊘", RED), "⚠": ("⚠", AMBER), "⚑": ("⚑", AMBER)}
_CON = r"(?<![\w.$])(?:[A-Z]{1,6} (?:\d\d/\d\d/\d\d )?)?\$?\d+(?:\.\d+)?[CP](?!\w)(?: \d\d/\d\d/\d\d)?"
_RX = re.compile("|".join([
    r"(?P<emo>[🟢🔴⚪✅❌❔⛔⚠⚑])",
    r"(?P<sep> · )",
    r"(?P<con>" + _CON + ")",
    r"(?P<num>(?<![\w.\-–/:])[+\-−]\$?\d[\d,]*(?:\.\d+)?[KMB%]?(?!\w))",
    r"(?P<amber>\b(?:PARTIAL|UNAVAILABLE|STALE|ELEVATED|PENDING|SUPPRESSED|BACKWARDATION)\b|\bmissing:)",
    r"(?P<green>\bOPENING\b|\b[Bb]ullish\b|\bBULLISH\b|\[OK\]|\bUP\b|\((?:[Ee]xtreme )?[Gg]reed\)"
    r"|\b(?:TP1|TP2|Final TP|FINAL)\s+[\d.,]*\d)",
    r"(?P<red>\bNOT CONFIRMED\b|\b[Bb]earish\b|\bBEARISH\b|\bDOWN\b|\((?:[Ee]xtreme )?[Ff]ear\)"
    r"|\bSL\s+[\d.,]*\d)",
    r"(?P<blue>\bEntry:|\bENTRY\b|\bCONTANGO\b)",
]))


def tone_of(s):
    m = re.search(r"\d([CP])(?!\w)", s)
    return None if not m else (GREEN if m.group(1) == "C" else RED)


def _color(chunk, base, bold, out):
    pos = 0
    for m in _RX.finditer(chunk):
        if m.start() > pos:
            out.append((clean(chunk[pos:m.start()]), base, bold))
        k, t = m.lastgroup, m.group()
        if k == "emo":
            g, c = EMO[t]
            out.append((g if _has(g) else "!", c, True))
        elif k == "sep":
            out.append((" · ", MUTED, False))
        elif k == "con":
            out.append((t, tone_of(t) or base, True))
        elif k == "num":
            out.append((t, GREEN if t[0] == "+" else RED, bold))
        else:
            out.append((t, {"amber": AMBER, "green": GREEN, "red": RED, "blue": BLUE}[k], True))
        pos = m.end()
    if pos < len(chunk):
        out.append((clean(chunk[pos:]), base, bold))


def rich(line, base=TXT, bold=False, plain=False):
    """Markdown-ish line -> [(text, colour, bold)] with the house colour rules applied."""
    if line[:1] == "\x01":
        base, bold, plain, line = {"g": GREEN, "r": RED, "b": BLUE, "a": AMBER}[line[1]], True, True, line[2:]
    line = re.sub(r"\s*\(?<https?://[^>\s]+>\)?", "", line)
    line = re.sub(r"(?<![*\w])\*(?!\*)([^*\n]+?)\*(?![*\w])", r"\1", line)
    out, b, code = [], bold, False
    for part in re.split(r"(\*\*|`)", line):
        if part == "**":
            b = not b
        elif part == "`":
            code = not code
        elif part:
            if plain:
                out.append((clean(part), base, b))
            else:
                _color(part, HEAD if code else base, b or code and False, out)
    res = []
    for t, c, bb in out:
        t = re.sub(r" {2,}", " ", t)
        if not res:
            t = t.lstrip()
        if t:
            res.append((t, c, bb))
    return res


def seg_w(segs, size=FS):
    return sum(font(size, b).getlength(t) for t, _, b in segs)


def wrap(segs, width, size=FS):
    lines, cur, x = [], [], 0.0
    for text, col, b in segs:
        f = font(size, b)
        for tok in re.findall(r"\s+|\S+", text):
            w = f.getlength(tok)
            if tok.isspace():
                if cur:
                    cur.append((tok, col, b))
                    x += w
                continue
            if cur and x + w > width:
                while cur and cur[-1][0].isspace():
                    cur.pop()
                lines.append(cur)
                cur, x = [], 0.0
            while w > width and len(tok) > 1:
                n = max(1, int(len(tok) * width / w) - 1)
                lines.append([(tok[:n], col, b)])
                tok = tok[n:]
                w = f.getlength(tok)
            cur.append((tok, col, b))
            x += w
    if cur:
        lines.append(cur)
    return lines or [[]]


def runs(d, x, y, line, size=FS):
    for t, c, b in line:
        f = font(size, b)
        d.text((x, y), t, font=f, fill=c)
        x += f.getlength(t)


def tint(color, a=0.30):
    c, g = [int(color[i:i + 2], 16) for i in (1, 3, 5)], [int(BG[i:i + 2], 16) for i in (1, 3, 5)]
    return "#" + "".join(f"{int(g[i] + (c[i] - g[i]) * a):02x}" for i in range(3))


def num_val(s):
    m = re.search(r"(\d[\d,]*(?:\.\d+)?)\s*([KMB])?", s.replace("$", ""))
    if not m:
        return None
    return float(m.group(1).replace(",", "")) * {"K": 1e3, "M": 1e6, "B": 1e9, None: 1}[m.group(2)]


class Atom:
    def __init__(self, h, draw, keep=False, head=None):
        self.h, self.draw, self.keep, self.head = h, draw, keep, head


# ── atoms ────────────────────────────────────────────────────────────────────
def a_gap(h=8):
    return Atom(P(h), lambda d, y: None)


def a_text(segs, size=FS, indent=0, top=3, bottom=3, bg=None, keep=False):
    lines = wrap(segs, CW - P(indent) - P(8), size)
    lh = P(size * 1.45)
    h = P(top) + lh * len(lines) + P(bottom)

    def draw(d, y):
        if bg:
            d.rectangle([X0, y, X0 + CW, y + h - 1], fill=bg)
        for i, ln in enumerate(lines):
            runs(d, X0 + P(4) + P(indent), y + P(top) + i * lh, ln, size)
    return Atom(h, draw, keep)


def a_head(text):
    return a_text(rich(text.rstrip(":"), BLUE, True, plain=True), 13, top=10, bottom=4, keep=True)


def a_banner(title, meta):
    t = wrap(rich(title, TXT, True), CW - P(8), 16)
    m = wrap(rich(" · ".join(meta), MUTED), CW - P(8), 12) if meta else []
    lt, lm = P(16 * 1.4), P(12 * 1.45)
    h = P(18) + lt * len(t) + lm * len(m) + P(6)

    st = {"rule": True}

    def draw(d, y):
        if st["rule"]:
            d.line([X0, y + P(8), X0 + CW, y + P(8)], fill=RULE, width=P(1))
        for i, ln in enumerate(t):
            runs(d, X0 + P(4), y + P(16) + i * lt, ln, 16)
        for i, ln in enumerate(m):
            runs(d, X0 + P(4), y + P(16) + lt * len(t) + i * lm, ln, 12)
    a = Atom(h, draw, keep=True)
    a.st = st
    return a


def a_split(ltxt, lv, rtxt, rv):
    """Green/red premium split bar; lengths are always proportional to the parsed values."""
    tot = (lv + rv) or 1.0
    h = P(46)

    def draw(d, y):
        l = f"{ltxt}  {lv / tot:.0%}"
        r = f"{rv / tot:.0%}  {rtxt}"
        f = font(12, True)
        d.text((X0 + P(4), y + P(4)), l, font=f, fill=GREEN)
        d.text((X0 + CW - P(4) - f.getlength(r), y + P(4)), r, font=f, fill=RED)
        x1, x2, by = X0 + P(4), X0 + CW - P(4), y + P(24)
        mid = x1 + int((x2 - x1) * lv / tot)
        d.rectangle([x1, by, mid, by + P(12)], fill=GREEN)
        d.rectangle([mid + P(2), by, x2, by + P(12)], fill=RED)
    return Atom(h, draw)


def a_pre(lines):
    f, lh = font(12, mono=True), P(17)
    h = lh * len(lines) + P(12)

    def draw(d, y):
        d.rectangle([X0, y, X0 + CW, y + h - 1], fill=PANEL)
        for i, ln in enumerate(lines):
            d.text((X0 + P(8), y + P(6) + i * lh), clean(ln)[:118], font=f, fill=TXT)
    return [Atom(h, draw)]


_NUM = re.compile(r"^[+\-−<>×~±]?\$?[\d,]*\.?\d+\s?(?:[KMB%×x]|sh)?$|^[—–-]$|^$")
_BARS = {"vol", "volume", "oi", "premium", "prem", "prints", "open interest"}


def a_table(header, rows, flex=None, bars=None, size=13, sub=None):
    """header [str], rows [[str]] -> [Atom] (header atom repeats on page breaks) or None if it cannot fit."""
    n, cp, hs = len(header), P(8), 12
    cells = [[rich(c) for c in (r + [""] * n)[:n]] for r in rows]
    nat = [max([font(hs, True).getlength(header[j])] + [seg_w(r[j], size) for r in cells]) + 2 * cp for j in range(n)]
    right = [sum(bool(_NUM.match(r[j].lstrip("\x01grba").strip())) for r in rows if j < len(r)) >= 0.7 * max(1, len(rows)) for j in range(n)]
    over = sum(nat) - CW
    if over > 0:
        j = flex if flex is not None else max(range(n), key=lambda k: nat[k])
        best = None
        minw = [max([0] + [seg_w([(t, c, b)], size) for r in cells for t0, c, b in r[k] for t in t0.split()]) + 2 * cp
                for k in range(n)]                                  # never narrower than a column's longest word
        for capf in (0.18, 0.22, 0.26, 0.30, 0.34, 0.38, 1.0):   # long non-flex columns wrap first
            w, o, rt = list(nat), over, list(right)
            for k in sorted(range(n), key=lambda k: -w[k]):
                if k != j and w[k] > max(CW * capf, minw[k]) and o > 0:
                    cut = min(o, w[k] - max(CW * capf, minw[k]))
                    w[k], rt[k], o = w[k] - cut, False, o - cut
            w[j] -= o
            if w[j] < P(150):
                continue
            tall = sum(max(len(wrap(r[c], w[c] - 2 * cp, size)) for c in range(n)) for r in cells[:60])
            if best is None or tall < best[0]:
                best = (tall, w, rt)
        if best is None:
            return None
        nat, right = best[1], best[2]
        right[j] = False
    else:
        tot = sum(nat)
        nat = [w + (-over) * w / tot for w in nat]
    xs = [X0 + sum(nat[:j]) for j in range(n)]
    if bars is None:
        bars = [j for j in range(n) if header[j].strip().lower() in _BARS]
    mx = {j: max([num_val(r[j]) or 0 for r in rows if j < len(r)] or [0]) for j in bars}
    lh = P(size * 1.45)
    room = {j: nat[j] - 2 * cp - max(seg_w(r[j], size) for r in cells) - P(6) for j in mx}

    def hdraw(d, y):
        d.rectangle([X0, y, X0 + CW, y + P(26) - 1], fill=PANEL)
        f = font(hs, True)
        for j in range(n):
            x = xs[j] + nat[j] - cp - f.getlength(header[j]) if right[j] else xs[j] + cp
            d.text((x, y + P(6)), header[j], font=f, fill=HEAD)
    hd = Atom(P(26), hdraw, keep=True)
    if not any(header):
        hd = None
    atoms = [hd] if hd else []
    for i, r in enumerate(cells):
        wr = [wrap(r[j], nat[j] - 2 * cp, size) for j in range(n)]
        hm = lh * max(len(w) for w in wr) + P(8)
        sl = wrap(rich(sub[i], MUTED), CW - 2 * cp - P(12), 11) if sub and i < len(sub) and sub[i] else []
        h = hm + P(11 * 1.45) * len(sl) + (P(4) if sl else P(2))
        tone = tone_of(" ".join(rows[i])) or BLUE

        def draw(d, y, wr=wr, h=h, i=i, tone=tone, hm=hm, sl=sl):
            if i % 2:
                d.rectangle([X0, y, X0 + CW, y + h - 1], fill=STRIPE)
            for j in range(n):
                if j in mx and mx[j] > 0 and j < len(rows[i]):
                    v = num_val(rows[i][j]) or 0
                    wide = right[j] and room[j] >= P(34)          # room for a bar beside the number, else a thin underbar
                    bw = (room[j] if wide else nat[j] - cp) * v / mx[j]
                    if bw >= 1:
                        d.rectangle([xs[j] + cp / 2, y + (P(4) if wide else hm - P(5)), xs[j] + cp / 2 + bw, y + hm - P(3) - 1],
                                    fill=tint(tone) if wide else tint(tone, 0.75))
                for k, ln in enumerate(wr[j]):
                    x = xs[j] + nat[j] - cp - seg_w(ln, size) if right[j] else xs[j] + cp
                    runs(d, x, y + P(5) + k * lh, ln, size)
            for k, ln in enumerate(sl):
                runs(d, X0 + cp + P(12), y + hm + k * P(11 * 1.45), ln, 11)
        atoms.append(Atom(h, draw, keep=(i == 0 and len(cells) > 1), head=hd))
    return atoms


def a_records(recs, size=13):
    """recs: [[(text, indent_px)]]; striped blocks of wrapped rich text."""
    atoms, lh = [], P(size * 1.45)
    for i, rec in enumerate(recs):
        ls = [(ln, ind) for t, ind in rec for ln in wrap(rich(t), CW - P(16) - P(ind), size)]
        h = lh * len(ls) + P(10)

        def draw(d, y, ls=ls, h=h, i=i):
            if i % 2 == 0:
                d.rectangle([X0, y, X0 + CW, y + h - 1], fill=STRIPE)
            for k, (ln, ind) in enumerate(ls):
                runs(d, X0 + P(8) + P(ind), y + P(5) + k * lh, ln, size)
        atoms.append(Atom(h, draw))
    return atoms


def build(blocks):
    atoms, sect = [], None
    for b in blocks:
        k = b[0]
        if k not in ("table", "gap"):
            sect = b[1] if k == "head" else None
        if k == "head":
            atoms.append(a_head(b[1]))
        elif k == "para":
            atoms.append(a_text(rich(b[1]), indent=b[2] if len(b) > 2 else 0))
        elif k == "note":
            atoms.append(a_text(rich(b[1].strip().strip("_"), MUTED, plain=True), 12))
        elif k == "banner":
            atoms.append(a_banner(b[1], b[2]))
        elif k == "split":
            atoms.append(a_split(*b[1:]))
        elif k == "pre":
            atoms += a_pre(b[1])
        elif k == "gap":
            atoms.append(a_gap())
        elif k == "records":
            atoms += a_records(b[1])
        elif k == "table":
            opt = b[3] if len(b) > 3 else {}
            t = a_table(b[1], b[2], opt.get("flex"), opt.get("bars"), sub=opt.get("sub"))
            if t and sect:
                cont = a_head(sect.rstrip(":") + " (continued)")
                for x in t:
                    x.sect = cont
            atoms += t if t else a_records(
                [[(" · ".join((f"{h} {c}" if h and j else c) for j, (h, c) in enumerate(zip(b[1], r)) if c), 0)]
                 + ([(opt["sub"][i], 16)] if opt.get("sub") and opt["sub"][i] else []) for i, r in enumerate(b[2])])
            atoms.append(a_gap(4))
    return atoms


def paginate(atoms, cap):
    pages, cur, h = [], [], 0
    for a in atoms:
        if cur and h + a.h > cap:
            tail = []
            while cur and cur[-1].keep:
                tail.insert(0, cur.pop())
            if not cur:                       # everything was "keep": break here rather than grow the page
                cur, tail = tail, []
            pages.append(cur)
            cur = tail
            if a.head is not None and a.head not in cur:
                if getattr(a, "sect", None) is not None:
                    cur.append(a.sect)
                cur.append(a.head)
            h = sum(x.h for x in cur)
        cur.append(a)
        h += a.h
    if cur:
        pages.append(cur)
    return pages or [[]]


def _page(atoms, chip, title, meta, i, n, stamp, path):
    tl = wrap(rich(title, TXT, True), CW - P(8), 20)
    ml = wrap(rich(" · ".join(meta), MUTED), CW - P(8), 12) if meta and i == 1 else []
    lt, lm = P(20 * 1.35), P(12 * 1.5)
    top = P(52) + lt * len(tl) + lm * len(ml) + P(12)
    H = top + sum(a.h for a in atoms) + P(44)
    im = Image.new("RGB", (P(W), H), BG)
    d = ImageDraw.Draw(im)
    f = font(13, True)
    cw = f.getlength(chip)
    d.rounded_rectangle([X0, P(16), X0 + cw + P(20), P(42)], radius=P(13), fill=BLUE)
    d.text((X0 + P(10), P(21)), chip, font=f, fill=BG)
    sc = "Synth Control" + (f"  ·  continued {i}/{n}" if i > 1 else "")
    d.text((X0 + CW - font(12).getlength(sc), P(22)), sc, font=font(12), fill=MUTED)
    for k, ln in enumerate(tl):
        runs(d, X0 + P(4), P(52) + k * lt, ln, 20)
    for k, ln in enumerate(ml):
        runs(d, X0 + P(4), P(52) + lt * len(tl) + P(2) + k * lm, ln, 12)
    d.line([X0, top - P(6), X0 + CW, top - P(6)], fill=RULE, width=P(1))
    y = top
    if atoms and getattr(atoms[0], "st", None):
        atoms[0].st["rule"] = False
    for a in atoms:
        a.draw(d, y)
        y += a.h
    d.line([X0, y + P(10), X0 + CW, y + P(10)], fill=RULE, width=P(1))
    d.text((X0 + P(4), y + P(18)), f"Synth Control · rendered {stamp} · data times are in the card", font=font(11), fill=MUTED)
    pg = f"page {i}/{n}"
    d.text((X0 + CW - font(11).getlength(pg), y + P(18)), pg, font=font(11), fill=MUTED)
    im.save(path, optimize=True)
    return str(path)


def render_cards(cmd_label, text, out_dir=OUT):
    """Render `text` (a slash command's reply) into one or more PNG cards. Raises on failure (caller falls back to text)."""
    from text_card_parse import parse
    out_dir = Path(out_dir)
    out_dir.mkdir(parents=True, exist_ok=True)
    now = time.time()
    for old in out_dir.glob("card_*.png"):          # keep the folder small: cards are one-shot
        if now - old.stat().st_mtime > 86400:
            old.unlink(missing_ok=True)
    text = text or "[empty]"
    links = [u for u in dict.fromkeys(re.findall(r"https?://[^\s>)]+", text)) if "." in u.split("//", 1)[1]][:5]   # a cut-off URL is not a link
    title, meta, blocks = parse(cmd_label, text)
    pages = paginate(build(blocks), P(PAGE_H - 130))
    dt = datetime.now(ET)
    stamp = dt.strftime("%a %b ") + f"{dt.day}, {dt.year} {dt.hour % 12 or 12}:{dt:%M %p} ET"
    slug = re.sub(r"[^A-Za-z0-9]+", "_", cmd_label).strip("_")[:40] or "card"
    base = f"card_{slug}_{dt:%H%M%S}_{int(now * 1000) % 1000:03d}"
    pngs = [_page(pg, cmd_label, title, meta, i, len(pages), stamp, out_dir / f"{base}_{i}.png")
            for i, pg in enumerate(pages, 1)]
    return {"pngs": pngs, "links": links}
