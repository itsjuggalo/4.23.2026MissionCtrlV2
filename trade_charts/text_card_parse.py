#!/usr/bin/env python3
"""text_card_parse: turn a slash command's text reply into layout blocks for text_card.

parse(label, text) -> (title, meta, blocks). It only re-arranges what the text says: every table cell is a
substring of the reply, nothing is computed or added. Unknown shapes fall back to wrapped paragraphs/records.
"""
from __future__ import annotations

import json
import re

from text_card import num_val, tone_of

BUL = re.compile(r"^\s*(?:•|-|\*) (?=\S)")       # • and markdown - / * bullets
GLYPH = re.compile(r"^[🔪⚡▸] ?(?=\*\*)")
NUMREC = re.compile(r"^\d+\. ")
TITLE = re.compile(r"^(?P<pre>[^\w*`•\[(]*)\*\*(?P<t>.+?)\*\*(?P<rest>.*)$")
SPLIT = re.compile(r"([Cc]alls (\$[\d.,]+[KMB]?) \([\d,]+\)) · ([Pp]uts (\$[\d.,]+[KMB]?) \([\d,]+\))")
EARN = re.compile(r"^`([^`]+)` \*\*([^*]+)\*\* · (.*) · ([^·]+)$")
LV = re.compile(r"^\s{2,}(TP1|TP2|FINAL|SL|ENTRY)\s+(\S+)\s+(.*)$")
MENU = re.compile(r"^L\d+ \S+ · ")
HIT = re.compile(r"^\s+(?P<l>.+?) \((?P<m>[^)]+)\) before SL: (?P<hr>.*?)(?: · mirrored-level baseline (?P<b>.*))?$")
TIDE = re.compile(r"^\d\d:\d\d · ")
ISO = re.compile(r"\d{4}-(\d\d)-(\d\d)T(\d\d:\d\d)(?::\d\d)?(?:\.\d+)?-0[45]:00")
C = r"(?P<c>\S.*? \$?\d+(?:\.\d+)?[CP])"
G, R_, B_, A_ = "\x01g", "\x01r", "\x01b", "\x01a"      # forced cell colours (text_card.rich)

T_CBOE = re.compile(rf"^{C} vol (?P<v>\S+) OI (?P<o>\S+)(?: \((?P<r>×[^)]+)\) bid/ask (?P<ba>\S+) IV (?P<iv>\S+))?$")
T_CHG = re.compile(rf"^{C} OI (?P<a>\S+) → (?P<b>\S+) \((?P<d>[+\-−][\d,]+)\)$")
T_FLOW = re.compile(rf"^{C} (?P<p>-?\$[\d.,]+[KMB]?)\s+(?P<t>[A-Z]+)?\s*(?P<s>\S+)-side vol (?P<v>\S+) OI (?P<o>\S+)"
                    r"(?P<tag>.*?) · (?P<tm>\d\d:\d\d(?: ET)?)(?: · (?:next-day OI )?(?P<cf>.*))?$")
T_CONF = re.compile(rf"^{C} \[(?P<why>[^\]]*)\] next-day OI (?:(?P<a>[\d,]+)→(?P<b>[\d,]+) \((?P<chg>[+\-−][\d,]+) vs "
                    r"(?P<pv>[\d,]+) printed (?P<d>[\d-]+)\) (?P<v>.+)|(?P<pend>PENDING.*))$")
T_UW = re.compile(r"^(?P<t>\d\d/\d\d \d\d:\d\d(?: ET)?) (?P<c>.+?) prem (?P<p>\S+) vol (?P<v>\S+) OI (?P<o>\S+)(?: ask (?P<a>\S+))?$")
T_HOT = re.compile(r"^(?P<s>[A-Z.]{1,6}) (?P<p>\$\S+) in (?P<n>[\d,]+) prints · net (?P<net>\S+)$")
T_CON = re.compile(r"^\**(?P<c>\S.*? \$?[\d.]+[CP])\** — (?P<src>.+?) · prem (?P<p>\S+)(?: \(ask (?P<a>[^/]+)/bid (?P<b>[^)]+)\))?"
                   r"(?: · last (?P<last>[^·]+?))?(?: · live (?P<live>\S+)(?: vol (?P<v>\S+))?(?: OI (?P<o>\S+))?)?(?: · (?P<note>.*))?$")
T_FG = re.compile(r"^(?P<c>[A-Z.]{1,6} \$?[\d.]+[CP] \S+) · (?P<p>\$[\d.,]+[KMB]?) · (?P<t>[A-Z]+)(?: (?P<s>[a-z]+))?"
                  r"(?: · vol (?P<v>\S+) / OI (?P<o>\S+))?(?: · FG (?P<fg>\w+))? · (?P<tm>\d\d/\d\d \d\d:\d\d ET) "
                  r"\[(?P<src>[^\]]*)\]$")
RULE = re.compile(r"^([-*_])\1{2,}$")
MDH = re.compile(r"^#{1,6}\s+(.+?)\s*#*$")
MDSEP = re.compile(r"^:?-{2,}:?$")
KVB = re.compile(r"^\*\*([^*]{2,48}?):?\*\*:? (.+)$")
g = lambda m, k: m.group(k) or ""  # noqa: E731


def _asof(s):
    return ISO.sub(lambda m: f"{m.group(1)}/{m.group(2)} {m.group(3)} ET", s)


def _jsonish(s):
    """JSON-ish payload -> readable 'key: value' text (quotes and the outer braces dropped, nothing else changed)."""
    s = s.strip().replace('"', "")
    return s[1:-1] if s.startswith("{") and s.endswith("}") else s.lstrip("{")


TABLES = [
    (T_CBOE, ["Contract", "Vol", "OI", "Vol/OI", "Bid/Ask", "IV"], {},
     lambda m: [g(m, "c"), g(m, "v"), g(m, "o"), g(m, "r"), g(m, "ba"), g(m, "iv")]),
    (T_CHG, ["Contract", "Prior OI", "OI now", "Change"], {"bars": []},
     lambda m: [g(m, "c"), g(m, "a"), g(m, "b"), g(m, "d")]),
    (T_FLOW, ["Contract", "Premium", "Type", "Side", "Vol", "OI", "Tag", "Time", "Next-day OI"], {"flex": 8},
     lambda m: [g(m, "c"), g(m, "p"), g(m, "t"), g(m, "s"), g(m, "v"), g(m, "o"), g(m, "tag").strip(), g(m, "tm"), g(m, "cf")]),
    (T_CONF, ["Contract", "Why", "Prior OI", "New OI", "Change", "Printed", "Verdict"], {"bars": []},
     lambda m: [g(m, "c"), g(m, "why"), g(m, "a"), g(m, "b"), g(m, "chg"),
                f"{g(m, 'pv')} on {g(m, 'd')}" if m.group("pv") else "", g(m, "v") or g(m, "pend")]),
    (T_UW, ["Time", "Contract", "Premium", "Vol", "OI", "Ask %"], {},
     lambda m: [g(m, "t"), g(m, "c"), g(m, "p"), g(m, "v"), g(m, "o"), g(m, "a")]),
    (T_HOT, ["Ticker", "Premium", "Prints", "Net"], {},
     lambda m: ["**" + g(m, "s") + "**", g(m, "p"), g(m, "n"), g(m, "net")]),
    (T_FG, ["Contract", "Premium", "Type", "Side", "Vol", "OI", "FG", "Time"], {"sub": 1},
     lambda m: [g(m, "c"), g(m, "p"), g(m, "t"), g(m, "s"), g(m, "v"), g(m, "o"), g(m, "fg"), g(m, "tm"), g(m, "src")]),
    (T_CON, ["Contract", "Premium", "At ask", "At bid", "Last print", "Live bid/ask", "Vol", "OI"], {"sub": 1},
     lambda m: [g(m, "c"), g(m, "p"), g(m, "a"), g(m, "b"), g(m, "last").strip(), g(m, "live"), g(m, "v"), g(m, "o"),
                " · ".join(x for x in (g(m, "src"), g(m, "note")) if x)]),
]


def _tab(header, rows, opt=None):
    keep = [j for j in range(len(header)) if any(j < len(r) and r[j] for r in rows)]
    opt = dict(opt or {})
    if "flex" in opt:
        opt["flex"] = keep.index(opt["flex"]) if opt["flex"] in keep else None
    if opt.get("bars"):
        opt["bars"] = [keep.index(j) for j in opt["bars"] if j in keep]
    return ("table", [header[j] for j in keep], [[r[j] if j < len(r) else "" for j in keep] for r in rows], opt)


def _title(s):
    m = TITLE.match(s)
    if not m or ":" in m.group("rest").split(" · ")[0]:
        return None                      # "**Label**: value" is a paragraph, not a title
    parts = [p.strip() for p in (m.group("pre") + m.group("t") + m.group("rest")).split(" · ")]
    m2 = re.match(r"^(.{3,60}?) \((.+)\)$", parts[0])
    if m2 and len(parts[0]) > 56:        # a long "(…)" tail on the title is its sub-line
        parts[:1] = [m2.group(1), m2.group(2)]
    return parts[0], [p for p in parts[1:] if p]


def _generic(one):
    """Bullets that share a ' · ' field count -> table; a label every row shares becomes the column header."""
    rows = [x.split(" · ") for x in one]
    k = len(rows[0])
    if len(rows) < 2 or k < 3 or any(len(r) != k for r in rows) or any(len(r[0]) > 44 for r in rows) \
            or any(len(c) > 34 for r in rows for c in r[1:]):
        return None
    hdr = [""] * k
    for j in range(1, k):
        pre = {re.match(r"^([^\d+\-−$<]*)", r[j]).group(1) for r in rows}
        p = pre.pop() if len(pre) == 1 else ""
        if p.strip() and all(len(r[j]) > len(p) for r in rows):
            hdr[j] = p.strip()[0].upper() + p.strip()[1:]
            for r in rows:
                r[j] = r[j][len(p):]
    if all(tone_of(r[0]) for r in rows):
        hdr[0] = "Contract"
    elif all(re.match(r"^(\*\*)?[A-Z.]{1,6}(\*\*)?$", r[0]) for r in rows):
        hdr[0] = "Ticker"
    return _tab(hdr, rows)


DOSS = re.compile(r"^(?P<b>[\w ]+?) \[(?P<st>[A-Z][A-Z ]*)\] (?P<rest>.* — .*)$")


def _dossier(ms):
    """'block [STATUS] <json, cut at 260 chars> — source · as of <iso>' rows -> table."""
    rows = []
    for m in ms:
        rest, data, src = m.group("rest"), None, ""
        if rest[260:263] == " — ":
            data, src = rest[:260], rest[263:]
        else:
            for k in re.finditer(" — ", rest):
                try:
                    json.loads(rest[:k.start()])
                except ValueError:
                    continue
                data, src = rest[:k.start()], rest[k.end():]
                break
        if data is None:
            data, _, src = rest.rpartition(" — ")
        st = m.group("st")
        mk = G if st == "OK" else A_ if st == "STALE" else R_
        rows.append(["**" + m.group("b") + "**", mk + st, _asof(_jsonish(data)), _asof(src.strip())])
    return _tab(["Block", "Status", "Data", "Source · as of"], rows, {"flex": 2})


def _bullets(items):
    one = [it[0] for it in items]
    if all(len(it) == 1 for it in items):
        ms = [DOSS.match(x) for x in one]
        if len(one) >= 2 and all(ms):
            return _dossier(ms)
        for rx, hdr, opt, fn in TABLES:
            ms = [rx.match(x) for x in one]
            if all(ms):
                if opt.get("sub"):
                    rows = [fn(m) for m in ms]
                    return _tab(hdr, [r[:-1] for r in rows], {"sub": [r[-1] for r in rows]})
                return _tab(hdr, [fn(m) for m in ms], opt)
        t = _generic(one)
        if t:
            return t
        kb = [KVB.match(x) for x in one]
        if len(one) >= 2 and all(kb):        # "**Label:** text" bullets -> label | text
            return ("table", ["", ""], [["**" + m.group(1) + "**", m.group(2)] for m in kb], {"flex": 1})
        kv = [re.match(r"^([^:·]{3,64}): (.+)$", x) for x in one]
        if len(one) >= 3 and all(kv):
            return ("table", ["", ""], [[m.group(1), m.group(2)] for m in kv], {})
    return ("records", [[(it[0], 0)] + [(x, 16) for x in it[1:]] for it in items])


def _fenced(body):
    rows = [b.split() for b in body if b.strip()]
    if len(rows) >= 2:
        k = len(rows[1])
        if all(len(r) == k for r in rows[1:]) and len(rows[0]) in (k, k - 1):
            return ("table", [""] * (k - len(rows[0])) + rows[0], rows[1:], {"bars": []})
    return ("pre", body)


def _levels(ms):
    rows = []
    for m in ms:
        lv, price, rest = m.groups()
        mk = B_ if lv == "ENTRY" else R_ if lv == "SL" else G
        m2 = re.match(r"^(L\d+) (\S+) — (.*)$", rest)
        rows.append([mk + lv, mk + price] + ([m2.group(1), m2.group(2), _asof(m2.group(3))] if m2 else [rest, "", ""]))
    return _tab(["Level", "Price", "ID", "Method", "Basis · source · as of"], rows, {"flex": 4})


def _menu(lines):
    rows = []
    for ln in lines:
        f = ln.split(" · ")
        lid, _, price = f[0].partition(" ")
        asof = f.pop()[6:] if f[-1].startswith("as_of ") else ""
        cut = 2 if len(f) >= 5 and f[-2] == "quote.v1" else 1
        src = " · ".join(f[-cut:]) if len(f) > 2 else ""
        rows.append(["**" + lid + "**", price, f[1] if len(f) > 1 else "", " · ".join(f[2:-cut]), src, _asof(asof)])
    return _tab(["ID", "Price", "Method", "Description", "Source", "As of"], rows, {"flex": 3})


def parse(label, text):
    L = [ln.rstrip() for ln in text.replace("\r", "").split("\n")]
    n, i, first = len(L), 0, True
    title, meta, blocks = None, [], []

    def take(pred, j):
        while j < n and L[j].strip() and pred(L[j]):
            j += 1
        return j

    def meta_next(j):
        """A short ' · ' line right under a title that has no meta is that title's meta."""
        if j < n and " · " in L[j] and len(L[j]) < 140 and not BUL.match(L[j]) and not L[j].startswith((" ", "`", "_")) \
                and not _title(L[j].strip()) and not L[j].endswith(":") and not SPLIT.search(L[j]):
            return [p.strip() for p in L[j].split(" · ")], j + 1
        return [], j

    while i < n:
        s, st = L[i], L[i].strip()
        if not st:
            if blocks and blocks[-1][0] != "gap":
                blocks.append(("gap",))
            i += 1
            continue
        if RULE.match(st.replace(" ", "")):          # markdown rule
            if blocks and blocks[-1][0] != "gap":
                blocks.append(("gap",))
            i += 1
            continue
        if MDH.match(st):                            # markdown heading -> bold line (title or banner)
            st = s = L[i] = "**" + MDH.match(st).group(1).replace("**", "") + "**"
        if st.startswith("```"):
            j = take(lambda x: not x.strip().startswith("```"), i + 1)
            blocks.append(_fenced(L[i + 1:j]))
            i, first = j + 1, False
            continue
        if first:
            first = False
            t = _title(st)
            if not t and re.match(r"^[A-Z.]{1,6} · ", st):
                p = st.split(" · ")
                t = (p[0], p[1:])
            if t:
                title, meta = t
                i += 1
                if not meta:
                    meta, i = meta_next(i)
                continue
        if GLYPH.match(st) or BUL.match(s) or NUMREC.match(st):
            rx = GLYPH if GLYPH.match(st) else BUL if BUL.match(s) else NUMREC
            items, j = [], i
            while j < n and L[j].strip():
                if rx.match(L[j].strip() if rx is not BUL else L[j]):
                    items.append([rx.sub("", L[j].strip(), 1) if rx is GLYPH else BUL.sub("", L[j], 1).strip()
                                  if rx is BUL else L[j].strip()])
                elif items and L[j].startswith("   ") and not BUL.match(L[j]):
                    items[-1].append(L[j].strip())
                else:
                    break
                j += 1
            blocks.append(_bullets(items))
            i = j
        elif st.startswith("|") and st.endswith("|") and st.count("|") >= 3:      # markdown table
            j = take(lambda x: x.strip().startswith("|"), i)
            rows = [[c.strip() for c in x.strip().strip("|").split("|")] for x in L[i:j]]
            rows = [r for r in rows if not all(MDSEP.match(c) for c in r)]
            if len(rows) >= 2 and all(len(r) == len(rows[0]) for r in rows):
                blocks.append(_tab([c.replace("**", "") for c in rows[0]], rows[1:], {"bars": []}))
            else:
                blocks.extend(("para", " · ".join(r), 0) for r in rows)
            i = j
        elif EARN.match(st):
            j = take(lambda x: EARN.match(x.strip()), i)
            rows = []
            for m in (EARN.match(x.strip()) for x in L[i:j]):
                det, flag = m.group(3), ""
                if "date unverified" in det:
                    det, flag = re.sub(r"\s*⚠\ufe0f? date unverified", "", det), A_ + "date unverified"
                rows.append([m.group(1), "**" + m.group(2) + "**", det, flag, m.group(4).strip()])
            blocks.append(_tab(["Date", "Ticker", "Detail", "Flag", "Source"], rows, {"flex": 2}))
            i = j
        elif HIT.match(s):
            j = take(lambda x: HIT.match(x), i)
            blocks.append(_tab(["Level", "Method", "Hit before SL", "Mirrored-level baseline"],
                               [[g(m, "l"), g(m, "m"), g(m, "hr"), g(m, "b")] for m in (HIT.match(x) for x in L[i:j])]))
            i = j
        elif LV.match(s):
            j = take(lambda x: LV.match(x), i)
            blocks.append(_levels([LV.match(x) for x in L[i:j]]))
            i = j
        elif MENU.match(st):
            j = take(lambda x: MENU.match(x.strip()), i)
            blocks.append(_menu([x.strip() for x in L[i:j]]))
            i = j
        elif _title(st):
            t, m = _title(st)
            i += 1
            if not m:
                m, i = meta_next(i)
            blocks.append(("banner", t, m))
        elif " · " in st and i + 2 < n and TIDE.match(L[i + 1]) and L[i + 1].count(" · ") == st.count(" · "):
            j = take(lambda x: TIDE.match(x) and x.count(" · ") == st.count(" · "), i + 1)
            hdr = [p.strip()[0].upper() + p.strip()[1:] for p in st.split(" · ")]
            blocks.append(_tab(hdr, [x.split(" · ") for x in L[i + 1:j]], {"bars": []}))
            i = j
        elif re.match(r"^_.*_$", st) or re.match(r"^\*[^*].*[^*]\*$", st) or st.startswith(("…", "> ")):
            blocks.append(("note", st.lstrip("> ").strip("*")))
            i += 1
        elif (st.endswith(":") and len(st) <= 110) or (len(st) <= 70 and i + 1 < n and BUL.match(L[i + 1])):
            blocks.append(("head", st))
            i += 1
        else:
            body = st
            if "**" not in st:
                body = re.sub(r"^([A-Z][\w /&()'%.\-]{1,38}): (?=\S)", r"**\1:** ", st, count=1)
            m = SPLIT.search(st)
            ok = bool(m and (num_val(m.group(2)) or 0) + (num_val(m.group(4)) or 0) > 0)
            if ok:
                body = re.sub(r"^[ ·]+|[ ·]+$", "", body.replace(m.group(0), " ").replace(" ·  · ", " · "))
            if body:
                blocks.append(("para", body, 14 if s.startswith("  ") else 0))
            if ok:
                lt, rt = m.group(1), m.group(3)
                blocks.append(("split", lt[0].upper() + lt[1:], num_val(m.group(2)), rt[0].upper() + rt[1:], num_val(m.group(4))))
            i += 1
    while blocks and blocks[-1][0] == "gap":
        blocks.pop()
    return title or label.split()[0], meta, blocks
