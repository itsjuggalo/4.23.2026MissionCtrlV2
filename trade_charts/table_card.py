"""table_card — dark-theme table cards (PNG) for Discord. Prototype 2026-11-13; palette matches trade_charts/chartlib.py.

render(title, columns, sections, path, subtitle=, split=, notes=) -> path
  columns : [{"label": "Vol", "align": "r"|"l", "bar": "#3fb950"|None}]
  sections: [(heading|None, [row, ...])]; row = one cell per column;
            cell = str | (str, color) | [(str, color), ...] | {"text": .., "frac": 0..1} for a data-bar cell
  split   : (left_label, left_value, right_label, right_value) -> green/red share bar under the title
  notes   : list of footer lines (source + as_of first)
Presentation only: every number is passed in by the caller, nothing is computed or fetched here."""
from pathlib import Path
from PIL import Image, ImageDraw, ImageFont

BG, PANEL, STRIPE, RULE = "#0d1117", "#161b22", "#11161d", "#30363d"
TXT, MUTED, HEAD = "#e6edf3", "#8b949e", "#c9d1d9"
GREEN, RED, AMBER, BLUE = "#3fb950", "#f85149", "#d29922", "#58a6ff"
_FD = "/usr/share/fonts/truetype/dejavu/"
S = 2  # supersample: Discord downsizes, so draw at 2x for crisp text


def _font(size, bold=False):
    return ImageFont.truetype(_FD + ("DejaVuSans-Bold.ttf" if bold else "DejaVuSans.ttf"), size * S)


def _segs(cell):
    if isinstance(cell, dict):
        cell = cell.get("text", "")
    if isinstance(cell, str):
        return [(cell, TXT)]
    if isinstance(cell, tuple):
        return [cell]
    return list(cell)


def render(title, columns, sections, path, subtitle=None, split=None, notes=()):
    f_t, f_s, f_h, f_c, f_n = _font(19, True), _font(11), _font(11, True), _font(12), _font(10)
    probe = ImageDraw.Draw(Image.new("RGB", (8, 8)))
    w = lambda s, f: probe.textlength(s, font=f)
    pad, gap, rh = 18 * S, 22 * S, 26 * S
    rows = [r for _, rr in sections for r in rr]
    cw = [max([w(c["label"], f_h)] + [sum(w(t, f_c) for t, _ in _segs(r[i])) for r in rows]) for i, c in enumerate(columns)]
    cw = [x + (70 * S if c.get("bar") else 0) for x, c in zip(cw, columns)]
    tw = sum(cw) + gap * (len(columns) - 1)
    W = int(max(tw, w(title, f_t), max([w(n, f_n) for n in notes] or [0]), 420 * S) + 2 * pad)
    extra = (W - 2 * pad - tw) / max(1, len(columns) - 1)          # spread spare width between columns
    xs, x = [], pad
    for cwid in cw:
        xs.append(x); x += cwid + gap + extra
    n_head = sum(1 for h, _ in sections if h)
    H = int(pad + 30 * S + (18 * S if subtitle else 0) + (30 * S if split else 0) + rh
            + rh * len(rows) + 24 * S * n_head + 8 * S + 15 * S * len(notes) + pad)
    im = Image.new("RGB", (W, H), BG); d = ImageDraw.Draw(im)
    y = pad
    d.text((pad, y), title, font=f_t, fill=TXT); y += 30 * S
    if subtitle:
        d.text((pad, y), subtitle, font=f_s, fill=MUTED); y += 18 * S
    if split:
        ll, lv, rl, rv = split; tot = (lv + rv) or 1; cut = pad + (W - 2 * pad) * lv / tot
        d.rounded_rectangle((pad, y + 4 * S, W - pad, y + 20 * S), 4 * S, fill=RED)
        d.rounded_rectangle((pad, y + 4 * S, cut, y + 20 * S), 4 * S, fill=GREEN)
        d.text((pad + 6 * S, y + 6 * S), f"{ll} {lv / tot:.0%}", font=f_n, fill=BG)
        t = f"{rl} {rv / tot:.0%}"; d.text((W - pad - 6 * S - w(t, f_n), y + 6 * S), t, font=f_n, fill=BG)
        y += 30 * S
    d.rectangle((pad - 8 * S, y, W - pad + 8 * S, y + rh), fill=PANEL)
    for c, x0, cwid in zip(columns, xs, cw):
        lx = x0 + cwid - w(c["label"], f_h) if c.get("align") == "r" else x0
        d.text((lx, y + 6 * S), c["label"], font=f_h, fill=HEAD)
    y += rh
    for head, rr in sections:
        if head:
            d.text((pad, y + 7 * S), head.upper(), font=f_h, fill=BLUE); y += 24 * S
        for k, r in enumerate(rr):
            if k % 2:
                d.rectangle((pad - 8 * S, y, W - pad + 8 * S, y + rh), fill=STRIPE)
            for c, x0, cwid, cell in zip(columns, xs, cw, r):
                segs = _segs(cell); tl = sum(w(t, f_c) for t, _ in segs)
                if c.get("bar") and isinstance(cell, dict):
                    bw = 62 * S * max(0.0, min(1.0, cell.get("frac") or 0))
                    if bw >= 1:
                        d.rectangle((x0, y + 8 * S, x0 + bw, y + rh - 8 * S), fill=c["bar"])
                cx = x0 + cwid - tl if c.get("align") == "r" else x0
                for t, col in segs:
                    d.text((cx, y + 6 * S), t, font=f_c, fill=col); cx += w(t, f_c)
            y += rh
    d.line((pad, y + 4 * S, W - pad, y + 4 * S), fill=RULE, width=S); y += 8 * S
    for n in notes:
        d.text((pad, y + 2 * S), n, font=f_n, fill=MUTED); y += 15 * S
    Path(path).parent.mkdir(parents=True, exist_ok=True)
    im.save(path, optimize=True)
    return str(path)
