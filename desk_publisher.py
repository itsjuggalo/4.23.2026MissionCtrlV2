#!/usr/bin/env python3
"""
desk_publisher.py — the autonomous analyst desk.

Each run, every analyst-agent composes a SHORT bylined article from LIVE missionctrl
data (regime, flow, news, congress, verdict-scan, the book) and drops it as a DRAFT
into the articles review queue. Mike approves → it goes public on /explore + the
author page. Deterministic templates (no LLM tokens), always fresh, dedup per slot.

Cron a few times/day (premarket / midday / close / evening). Approve-each by design:
nothing is published without Mike's tap. Inert/additive — only writes draft rows.

Run:  python3 desk_publisher.py [--slot premarket|midday|close|evening]
"""
import json, os, sys, urllib.request
from datetime import datetime, timezone, timedelta

sys.path.insert(0, '/home/itsju/05_AUTOMATION/scripts/lib')
from article_writer import publish_article  # noqa: E402

BASE = 'http://localhost:3000'            # loopback → middleware bypass, no auth
STATE = '/home/itsju/.openclaw/data/desk_publisher_state.json'
ET = timezone(timedelta(hours=-4))        # EDT; ops run in ET


def _get(path, timeout=15):
    try:
        with urllib.request.urlopen(f'{BASE}{path}', timeout=timeout) as r:
            return json.load(r)
    except Exception:
        return None


def _file(path):
    try:
        with open(path) as f:
            return json.load(f)
    except Exception:
        return None


def _load_state():
    s = _file(STATE) or {}
    return set(s.get('published', []))


def _save_state(keys):
    try:
        os.makedirs(os.path.dirname(STATE), exist_ok=True)
        with open(STATE, 'w') as f:
            json.dump({'published': list(keys)[-300:]}, f)
    except Exception:
        pass


def _now():
    return datetime.now(ET)


# ── analyst builders: each returns (title, summary, body_md, tickers) or None ──

def build_mengsk(slot):
    reg = _get('/api/regime') or {}
    news = _get('/api/market-news') or {}
    headlines = (news.get('articles') or news.get('news') or news.get('items') or [])[:4]
    regime = reg.get('overall_regime') or reg.get('regime') or 'UNKNOWN'
    bias = reg.get('direction_bias') or reg.get('bias') or ''
    conf = reg.get('confidence')
    if regime == 'UNKNOWN' and not headlines:
        return None
    title = f"Macro Read: Regime is {regime}{(' / ' + bias) if bias else ''}"
    summary = (f"Market regime reads {regime}{(' (' + bias + ')') if bias else ''}"
               f"{(', confidence ' + str(round(conf*100)) + '%') if isinstance(conf,(int,float)) else ''}. "
               f"Here are the headlines that actually move the book.")
    lines = [f"## The regime", f"- Overall: **{regime}** {bias}".rstrip(),
             (f"- Confidence: {round(conf*100)}%" if isinstance(conf,(int,float)) else None),
             "", "## Headlines that matter"]
    for h in headlines:
        t = h.get('title') or h.get('headline') or ''
        src = h.get('source') or h.get('publisher') or ''
        if t:
            lines.append(f"- {t}" + (f" *(via {src})*" if src else ''))
    lines += ["", "_The lens above any single name — position to the regime, not the noise._"]
    body = "\n".join([x for x in lines if x is not None])
    return title, summary, body, None


def build_zeratul(slot):
    flow = _get('/api/options-flow') or {}
    alerts = (flow.get('alerts') or flow.get('flows') or [])[:6]
    cong = _get('/api/congress') or {}
    clusters = (cong.get('clusters') or [])[:3]
    if not alerts and not clusters:
        return None
    syms = []
    title = "Flow & Intel: Where the Smart Money Is Moving"
    lines = ["## Notable options flow"]
    if alerts:
        for a in alerts:
            s = a.get('Symbol') or a.get('symbol') or '?'
            ot = a.get('OptionType') or a.get('type') or ''
            kind = 'sweep' if (a.get('SWEEPS') or 0) else ('block' if (a.get('BLOCKS') or 0) else 'flow')
            px = a.get('AlertPrice') or a.get('price')
            syms.append(s)
            lines.append(f"- **{s}** {ot} {kind}" + (f" @ {px}" if px else ''))
    else:
        lines.append("- Quiet tape — no standout sweeps right now.")
    if clusters:
        lines += ["", "## Congress clusters (3+ members, same name)"]
        for c in clusters:
            tk = c.get('ticker'); n = c.get('count')
            syms.append(tk)
            lines.append(f"- **{tk}** — {n} members bought in a 7-day window")
    lines += ["", "_Real / watch / noise: lead with the names that show up across flow AND filings._"]
    summary = ("Today's standout options flow and congressional clustering — the signals worth a second look, "
               "triaged real vs noise.")
    tickers = ",".join(dict.fromkeys([s for s in syms if s and s != '?']))[:120] or None
    return title, summary, "\n".join(lines), tickers


def build_raynor(slot):
    cache = _file('/home/itsju/02_DATA/trade-brief-cache.json') or {}
    brief = (cache.get('brief') or '').strip()
    bullets = cache.get('bullets') or []
    vs = _get('/api/verdict-scan') or {}
    rows = vs.get('results') if isinstance(vs.get('results'), list) else (vs if isinstance(vs, list) else [])
    top = [r for r in (rows or []) if isinstance(r, dict)][:5]
    if not brief and not top:
        return None
    title = "Desk Note: The Read Going Into This Session"
    lines = []
    syms = []
    if top:
        lines.append("## Top conviction names")
        for r in top:
            s = r.get('symbol') or r.get('ticker')
            v = r.get('verdict'); sc = r.get('score')
            if s:
                syms.append(s)
                lines.append(f"- **{s}** — {v}" + (f" ({sc})" if sc is not None else ''))
        lines.append("")
    if brief:
        lines += ["## Desk brief", brief]
    if bullets:
        lines += [""] + [f"- {b}" for b in bullets[:6]]
    lines += ["", "_Verdict-first, paper-first. One screen, no walls._"]
    summary = (brief[:180] + '…') if len(brief) > 180 else (brief or "The desk's read on the names and the tape going into the session.")
    tickers = ",".join(dict.fromkeys(syms))[:120] or None
    return title, summary, "\n".join(lines), tickers


def build_aldaris(slot):
    pf = _get('/api/portfolio') or {}
    positions = pf.get('positions') or []
    equity = pf.get('equity') or pf.get('total')
    if not positions:
        return None
    title = "Risk Note: The Book Right Now"
    lines = [f"## The book" + (f" — equity ${equity}" if equity else '')]
    syms = []
    for p in positions[:10]:
        s = p.get('symbol') or p.get('ticker'); pl = p.get('unrealized_plpc') or p.get('pl_pct')
        if s:
            syms.append(s)
            lines.append(f"- **{s}**" + (f" — {round(float(pl)*100,1)}%" if isinstance(pl,(int,float,str)) and str(pl).replace('.','',1).replace('-','',1).isdigit() else ''))
    lines += ["", "_Size as a fraction of current equity. Hard cap $800/trade. Mind correlation._"]
    summary = f"{len(positions)} open positions on the book — concentration, P&L, and the risk read."
    return title, summary, "\n".join(lines), (",".join(dict.fromkeys(syms))[:120] or None)


BUILDERS = [
    ('mengsk', build_mengsk),
    ('zeratul', build_zeratul),
    ('raynor', build_raynor),
    ('aldaris', build_aldaris),
]


def main():
    slot = 'auto'
    if '--slot' in sys.argv:
        slot = sys.argv[sys.argv.index('--slot') + 1]
    if slot == 'auto':
        h = _now().hour
        slot = ('premarket' if h < 11 else 'midday' if h < 15 else 'close' if h < 18 else 'evening')
    day = _now().strftime('%Y-%m-%d')
    seen = _load_state()
    published = 0
    for aid, fn in BUILDERS:
        key = f"{aid}:{day}:{slot}"
        if key in seen:
            continue
        try:
            out = fn(slot)
        except Exception as e:
            print(f"  {aid}: builder error {e}")
            out = None
        if not out:
            print(f"  {aid}: no content this slot — skip")
            continue
        title, summary, body, tickers = out
        try:
            publish_article(aid, title, summary, body, tickers=tickers, source=f'desk-auto:{slot}')
            seen.add(key)
            published += 1
            print(f"  {aid}: drafted '{title[:50]}'")
        except Exception as e:
            print(f"  {aid}: publish error {e}")
    _save_state(seen)
    print(f"desk_publisher [{slot}] {day}: {published} draft(s) queued for review")


if __name__ == '__main__':
    main()
