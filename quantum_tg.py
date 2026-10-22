#!/home/itsju/.venv/bin/python
"""Quantum pipeline picks → ADD-friendly Telegram one-liners (READ-ONLY).

Reads the quantum pricing pipeline's END-RESULT artifacts (owned by another session
— we only READ them) and distills the single best actionable contract into a verdict-
first, zero-bloat message. Powers /pick /picks /book on the Telegram responders.

2026-09-16: Alpaca is a market-DATA source only. No account/equity/heat/positions read
anywhere here — each pick shows its cost per contract (price caps removed 2026-10-05); /book reads Mike's own journal fills
(option-scraper data/paper_trades.json), never a broker book.

Anti-bloat doctrine: ONE clear action, ≤5 short lines, no data walls. Honest when
there's nothing clean (capital preservation > FOMO).
"""
import json, os, re
from datetime import datetime
from zoneinfo import ZoneInfo
from tg_format import esc, b, hdr, section, row, footer, join
import levels_block as LB  # R32 (Mike 2026-10-21): computed levels.v1 block on the top pick

OUT = os.path.expanduser("~/labs/quantum/out")
JOURNAL = "/AIWorkWSL/trading/signals/option-scraper/data/paper_trades.json"   # Mike's own fills (read-only)
MC = "http://localhost:3000"
SCRAPER = os.path.expanduser("~/trading/signals/option-scraper/data")
ET  = ZoneInfo("America/New_York")


def _load(name):
    try:
        return json.load(open(os.path.join(OUT, name)))
    except Exception:
        return None


# MissionCtrl's freshness registry row for the quantum pipeline (read-only). Mike paused it on 2026-09-30; while the row
# says expectation "paused", consumers say so instead of going silent or showing 09-30 picks as current.
REGISTRY = os.environ.get("MC_FRESHNESS_REGISTRY",
                          "/AIWorkWSL/web/missionctrl/src/lib/freshness-registry/freshness_registry.json")


def paused_note():
    """"quantum pipeline paused since 09-30 (Mike) — no current pick" when the registry says paused, else None."""
    try:
        e = next(r for r in json.load(open(REGISTRY))["entries"] if r.get("id") == "quantum-lab")
    except Exception:
        return None
    if e.get("expectation") != "paused":
        return None
    p = e.get("paused") or {}
    return f"quantum pipeline paused since {str(p.get('since') or '?')[5:] or '?'} ({p.get('by') or '?'}) — no current pick"


def _journal(status="open"):
    """Mike's journal fills (took / virtual_pick) with the given status, newest first.
    Read-only; the file is owned by the option-scraper decipher layer."""
    try:
        d = json.load(open(JOURNAL))
    except Exception:
        return []
    rows = d.get("trades") if isinstance(d, dict) and isinstance(d.get("trades"), list) else \
        (list(d.values()) if isinstance(d, dict) else (d or []))
    rows = [r for r in rows if isinstance(r, dict) and r.get("status") == status
            and r.get("source") in ("took", "virtual_pick")]
    rows.sort(key=lambda r: str(r.get("closed_at") or r.get("opened_at") or ""), reverse=True)
    return rows


def _mc(path, timeout=6):
    """GET a missionctrl route as JSON (None on any failure — every caller degrades)."""
    try:
        import urllib.request
        return json.loads(urllib.request.urlopen(f"{MC}{path}", timeout=timeout).read())
    except Exception:
        return None


def _load_scraper(name):
    try:
        return json.load(open(os.path.join(SCRAPER, name)))
    except Exception:
        return None


def _human(n):
    try:
        n = float(n)
    except Exception:
        return str(n)
    for u, dv in (("B", 1e9), ("M", 1e6), ("K", 1e3)):
        if abs(n) >= dv:
            return f"${n/dv:.1f}{u}"
    return f"${n:.0f}"


def flow():
    """Top option-signals flow alerts (the OTHER signal source) — big-money
    positioning, deterministic from the scraper digest. For greeks: /greeks <TKR>."""
    d = _load_scraper("digest_context.json")
    if not d:
        return "no flow data right now (option-signals digest empty)."
    when = str(d.get("generated_at_et", ""))[:16].replace("T", " ")
    lines = [hdr("🌊", "Flow Alerts", sub=f"data {when} ET")]
    sw = _stale_warning(d.get("generated_at_et"), max_min=45).strip()
    if sw:
        lines.append(esc(sw))
    cands = []
    al = d.get("action_layer")
    if isinstance(al, dict):
        cands.append(al)
    cands += [x for x in (d.get("repeating_large_flows") or []) if isinstance(x, dict)]
    seen, rows = set(), []
    for c in cands:
        sym = c.get("symbol")
        key = (sym, c.get("strike"), c.get("type"))
        if not sym or key in seen:
            continue
        seen.add(key)
        sent = c.get("sentiment", "")
        emo = "🟢" if sent == "BULLISH" else "🔴" if sent == "BEARISH" else "⚪"
        t = (c.get("type") or "")[:1]
        rows.append(row(sym, f"${c.get('strike'):g}{t} {c.get('expiry_dte')}d", sent[:4],
                         f"rank {c.get('flowrank')}", _human(c.get('premium_usd')), glyph=emo))
    lines.append(section("Top Flow") if rows else "")
    lines += rows[:3]
    for ap in (d.get("top_app_picks") or [])[:1]:
        if isinstance(ap, dict):
            lines.append(row(ap.get('symbol'), f"${ap.get('strike')}{(ap.get('type') or '')[:1]}",
                              ap.get('category'), glyph="app:"))
    if not rows:
        lines.append("quiet — no standout flow right now.")
    lines.append(footer("big-money positioning. /greeks <TKR> for live greeks/IV"))
    return join(*lines)


def explain():
    """Plain-English cheat sheet — what the numbers mean + why they matter. Pulled
    on demand so the alerts themselves stay tight (no inline clutter)."""
    return join(
        hdr("📖", "What The Numbers Mean"),
        "Δ delta — moves per $1 in the stock (0.50 ≈ 50¢). Higher = more punch + more cost.",
        "θ theta — $ lost to time each day. Your rent for holding. Big θ = clock vs you.",
        "IV — how pricey the option is. High = expensive (rich), crushes after earnings; low = cheap.",
        f"value — our IV read: buy {b('cheap/fair')}, skip {b('rich')}.",
        "vol/OI — contracts traded / open. High = liquid (easy in-out, tight spread); low = avoid.",
        "src — independent feeds confirming it. More = stronger.",
        "⭐ confluence — quantum pick + flow agree = top conviction.",
        f"✅ cleanest buy = cheap/fair IV + Δ0.40-0.60 + liquid + ⭐.")


def _market_open(now=None):
    now = now or datetime.now(ET)
    if now.weekday() >= 5:
        return False
    t = now.hour * 60 + now.minute
    return 9 * 60 + 30 <= t <= 16 * 60  # 9:30–16:00 ET (holidays not handled)


def _stale_warning(as_of, max_min=40):
    """Warn ONLY if data is old during market hours (off-hours staleness is expected)."""
    if not _market_open():
        return ""
    try:
        age = (datetime.now(ET) - datetime.fromisoformat(str(as_of))).total_seconds() / 60
        if age > max_min:
            return f"⚠️ data {int(age)}m old — pipeline may be lagging; verify before acting\n"
    except Exception:
        pass
    return ""


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


def _afford_spread(p):
    """The pipeline's OWN debit spread for this pick, when its quote looks real (≥ $5 per
    spread contract). No price cap is applied (DECISIONS R32: no size, no cap)."""
    s = p.get("spread")
    if not isinstance(s, dict):
        return None
    cost = s.get("cost_per")
    try:
        # < $5 per spread contract = a stale/one-sided quote (e.g. the $1 CRCL $130/$135 seen
        # 2026-09-16) — never headline that.
        if cost is not None and float(cost) >= 5.0:
            return s
    except Exception:
        pass
    return None


def _verdict(p):
    """Evidence read from action + value only (price caps removed 2026-10-05).
    Machine `action` stays ACT/ACT-SMALL/WAIT; the text a human reads is gate
    state / setup evidence, never a trade call."""
    act = (p.get("action") or "").upper()
    val = (p.get("value") or "").lower()
    if act == "ACT" and val in ("cheap", "fair"):
        base = "🟢 GATE PASS — clean signal, fair price"
    elif act == "ACT" and val == "rich":
        base = "🟡 GATE CAUTION — good signal, but IV is rich (pricey)"
    elif act == "ACT-SMALL":
        base = "🟡 GATE CAUTION — event risk"
    elif act == "WAIT":
        base = "⏳ GATE CAUTION — unconfirmed, let the setup confirm"
    else:
        base = "🟡 GATE CAUTION"
    return base


def _pick_line(p):
    typ = (p.get("type") or "").upper()
    per = p.get("per_contract")
    cost = f"{_money(per)} per contract" if per else "cost UNAVAILABLE"
    head = b(f"{p.get('ticker')} ${p.get('strike'):g} {typ}")
    return (f"{head} · {esc(_fmt_exp(p.get('expiry')))} ({esc(p.get('days'))}d)\n"
            + esc(f"{cost} · {p.get('confidence')}-conf · "
                  f"{p.get('sources')} src · {p.get('value')}"))


def _fmt_exp(e):
    try:
        return datetime.strptime(e, "%Y-%m-%d").strftime("%-m/%-d")
    except Exception:
        return e


def _sweeps_raw():
    """Normalized live option sweeps from the scraper feed (flow2_alerts_today.json)."""
    d = _load_scraper("flow2_alerts_today.json")
    vals = d.values() if isinstance(d, dict) else (d if isinstance(d, list) else [])
    out = []
    for v in vals:
        a = v.get("alert") if isinstance(v, dict) and "alert" in v else v
        if isinstance(a, dict) and a.get("Symbol"):
            out.append(a)
    return out


def _sweep_tags(a):
    tags = []
    dte = a.get("DTE")
    oi, vol = a.get("OI") or 0, a.get("Volume") or 0
    if isinstance(dte, (int, float)) and dte <= 1:
        tags.append("⚡0DTE")
    if oi and vol / oi >= 2:
        tags.append(f"📈vol {vol/oi:.0f}×OI")   # new positioning piling in
    swp = a.get("SWEEPS") or 0
    if swp >= 10:
        tags.append(f"{swp}× sweep")
    return tags


FLOW_DB = os.path.expanduser("~/02_DATA/flow-data/flow.db")


def _tape_side(a):
    """Net execution side of this contract's prints in flow.db (FlowScraper ≥ $50K) up to the alert's update time:
    ask-side premium vs bid-side premium. None when flow.db has no print for it. Read-only."""
    import sqlite3
    m = re.match(r"^([A-Z.]+?)(\d{2})(\d{2})(\d{2})([CP])(\d{8})$", a.get("OptionSymbol") or "")
    if not m:
        return None
    exp, strike = f"20{m.group(2)}-{m.group(3)}-{m.group(4)}", int(m.group(6)) / 1000
    upto = a.get("Updated") or a.get("Time") or 0
    try:
        con = sqlite3.connect(f"file:{FLOW_DB}?mode=ro", uri=True, timeout=3)
        rows = con.execute("SELECT bid_ask, SUM(premium) FROM flow_events_dedup WHERE symbol=? AND expiry=? AND strike=? "
                           "AND option_type LIKE ? AND event_time<=? GROUP BY bid_ask",
                           (m.group(1), exp, strike, "C%" if m.group(5) == "C" else "P%", upto)).fetchall()
        con.close()
    except sqlite3.Error:
        return None
    ask = sum(p or 0 for s, p in rows if (s or "").upper() in ("A", "AA"))
    bid = sum(p or 0 for s, p in rows if (s or "").upper() in ("B", "BB"))
    if not ask and not bid:
        return None
    return "ask" if ask > bid else "bid" if bid > ask else "mixed"


def direction_label(opt_type, vendor_bull, tape):
    """The vendor feed's isBullish carries no execution side, so it is labelled as the vendor's read. When flow.db's
    tape names the side, the label says what traded (bought/sold) and both reads are shown if they disagree."""
    put = (opt_type or "").upper().startswith("P")
    vend = "BULL" if vendor_bull else "BEAR"
    if tape in ("ask", "bid"):
        bought = tape == "ask"
        tape_bull = bought != put                        # bought call / sold put = bullish
        what = f"{'bought' if bought else 'sold'} {'put' if put else 'call'} · {'bullish' if tape_bull else 'bearish'}"
        if tape_bull == bool(vendor_bull):
            return f"{'🟢' if tape_bull else '🔴'}{what}"
        return f"🟡 vendor {vend} · tape {what} (net {tape}-side)"
    return f"{'🟢' if vendor_bull else '🔴'}{vend} (vendor; side not in feed)"


def _sweep_line(a, with_tags=True):
    t = (a.get("OptionType") or "")[:1]
    bull = direction_label(a.get("OptionType"), a.get("isBullish"), _tape_side(a))
    line = row(a.get('Symbol'), f"${a.get('Strike'):g}{t} {a.get('DTE')}d",
               _human(a.get('totalFlowValue')), bull,
               f"OI {a.get('OI') or 0}/vol {a.get('Volume') or 0}", glyph="🔪")
    if with_tags:
        tg = _sweep_tags(a)
        if tg:
            line += "\n   " + esc(" · ".join(tg))
    return line


def sweeps(top=5, min_prem=500_000):
    """Live institutional sweeps right now — the whales' footprints. /sweeps."""
    raw = [a for a in _sweeps_raw() if (a.get("totalFlowValue") or 0) >= min_prem]
    raw.sort(key=lambda a: a.get("totalFlowValue") or 0, reverse=True)
    if not raw:
        return "no big sweeps in the feed right now."
    lines = [hdr("🔪", "Live Sweeps", sub="big money positioning")]
    seen = set()
    for a in raw:
        k = a.get("OptionSymbol")
        if k in seen:
            continue
        seen.add(k)
        lines.append(_sweep_line(a))
        if len(seen) >= top:
            break
    lines.append(footer("ride the flow · /greeks <TKR> for greeks · /explain"))
    return join(*lines)


def odte(top=6):
    """0DTE / short-DTE (≤2) sweeps — the fast-money game. /odte."""
    raw = [a for a in _sweeps_raw()
           if isinstance(a.get("DTE"), (int, float)) and a["DTE"] <= 2
           and (a.get("totalFlowValue") or 0) >= 300_000]
    raw.sort(key=lambda a: a.get("totalFlowValue") or 0, reverse=True)
    if not raw:
        return "no 0-2 DTE sweeps right now (none, or market closed)."
    lines = [hdr("⚡", "0DTE / Short-DTE Flow")]
    seen = set()
    for a in raw:
        k = a.get("OptionSymbol")
        if k in seen:
            continue
        seen.add(k)
        lines.append(_sweep_line(a, with_tags=False))
        if len(seen) >= top:
            break
    lines.append(footer("fast + risky — momentum observation only"))
    return join(*lines)


def _flow_directions():
    """{ticker: BULLISH/BEARISH} from the option-signals flow digest (the other engine)."""
    d = _load_scraper("digest_context.json")
    out = {}
    if not d:
        return out
    cands = []
    al = d.get("action_layer")
    if isinstance(al, dict):
        cands.append(al)
    cands += [x for x in (d.get("repeating_large_flows") or []) if isinstance(x, dict)]
    for c in cands:
        s, sent = c.get("symbol"), c.get("sentiment")
        if s and s not in out:
            out[s] = sent
    for ap in (d.get("top_app_picks") or []):
        if isinstance(ap, dict) and ap.get("symbol") and ap["symbol"] not in out:
            out[ap["symbol"]] = "BULLISH" if (ap.get("type") or "").upper() == "CALL" else "BEARISH"
    return out


def _confluence(p, flowdir):
    """Cross-engine check: does the option-signals flow agree with this quantum pick?
    Agreement = top conviction; disagreement = a real caution flag."""
    sym = p.get("ticker")
    if not sym or sym not in flowdir:
        return None
    want = "BULLISH" if (p.get("type") or "").lower() == "call" else "BEARISH"
    fs = flowdir[sym]
    if fs == want:
        return f"⭐ {b('CONFLUENCE')} — option-signals flow agrees"
    return esc(f"⚠️ flow DISAGREES (flow is {str(fs).lower()}) — extra caution")


def _iv_trap(p):
    """Surface the binary IV-crush trap (earnings inside the contract's life) — the
    quiet killer of option trades. Rich IV alone is already in the verdict."""
    why = (p.get("action_why") or "").lower()
    if "earnings" in why or "crush" in why:
        return "⚠️ IV-TRAP — earnings before expiry (IV can crush the premium)"
    return None


def pick(top=1):
    """The single best (top=1) or top-N actionable picks. Verdict-first."""
    paused = paused_note()
    if paused:
        return join(hdr("⏸", "Quantum Paused"), esc(paused))
    d = _load("best_contracts.json")
    if not d:
        return "no pipeline output yet — it runs market hours (Mon–Fri 9:30–4 ET)."
    picks = d.get("picks") or []
    fresh = _freshness(d.get("as_of"))
    if not picks:
        nd = d.get("n_dropped", 0)
        return join(
            hdr("🟦", "No Clean Buy", sub=fresh),
            esc(f"pipeline checked {d.get('n_considered','?')} and dropped all "
                f"{nd} (unverifiable, illiquid or failed a quality gate). Capital preserved — sit tight."))
    flowdir = _flow_directions()
    if top == 1:
        p = picks[0]
        conf = _confluence(p, flowdir)
        trap = _iv_trap(p)
        head = _pick_line(p)
        why = (p.get('action_why') or '')[:120]
        return join(
            hdr("🎯", "Top Pick", sub=fresh),
            esc(_stale_warning(d.get('as_of')).strip()) or None,
            head,
            esc(_verdict(p)),
            conf, trap,
            f"<i>why: {esc(why)}</i>" if why else None,
            "\n".join(esc(x) for x in LB.for_contract(p.get("ticker") or "", p.get("type") or "", p.get("days"), p.get("occ"))),
            footer("cost per contract · advisory — you place every trade"))
    n = min(top, len(picks))
    star_picks, rest = [], []
    for i, p in enumerate(picks[:top], 1):
        (star_picks if (_confluence(p, flowdir) or "").startswith("⭐") else rest).append((i, p))
    lines = [hdr("🎯", f"Top {n} Picks", sub=fresh)]

    def _pick_row(i, p, star):
        typ = (p.get("type") or "").upper()
        price = _money(p.get("per_contract")) if p.get("per_contract") else "UNAVAILABLE"
        verdict = _verdict(p).split(' — ')[0]
        return row(f"{i}. {p.get('ticker')}", f"${p.get('strike'):g}{typ[0]}",
                   _fmt_exp(p.get('expiry')), price, p.get('confidence'),
                   p.get('value'), verdict, glyph=("⭐" if star else "▸"))
    if star_picks:
        lines.append(section("Confluence"))
        lines += [_pick_row(i, p, True) for i, p in star_picks]
    if rest:
        if star_picks:
            lines.append(section("Other Picks"))
        lines += [_pick_row(i, p, False) for i, p in rest]
    lines.append(footer("cost per contract · advisory — you place every trade"))
    return join(*lines)


def book():
    """Mike's OPEN journal fills (took / virtual_pick) with entry price. Never a
    broker book — Alpaca is data only (2026-09-16)."""
    rows = _journal("open")
    if not rows:
        return join(hdr("📒", "Journal"), "no open journal fills — log one from a pick to track it here.")
    out = [hdr("📒", "Journal", sub=f"{len(rows)} open fill{'s' if len(rows) != 1 else ''}")]
    for r in rows[:6]:
        typ = (r.get("type") or r.get("side") or "")[:1].upper()
        strike = r.get("strike")
        head = f"${strike:g}{typ}" if isinstance(strike, (int, float)) else (r.get("contract") or "")
        opened = str(r.get("opened_at") or "")[:10]
        out.append(row(r.get("symbol"), head, _fmt_exp(r.get("expiry")),
                       f"in {_px(r.get('entry'))}",
                       f"since {opened}" if opened else None,
                       glyph="▸"))
    out.append(footer("/pick for new ideas"))
    return join(*out)


def _px(x):
    try:
        x = float(x)
    except Exception:
        return str(x)
    return f"${x:,.0f}" if abs(x) >= 100 else f"${x:.2f}"


def crypto():
    """BTC desk (24/7) — the live source when equities are closed. Alert-only.
    Alpaca crypto is spot/long-only, so a SHORT read = sit out / no clean long."""
    d = _load("btc_desk.json")
    if not d:
        return "no crypto desk output yet."
    fresh = _freshness(d.get("as_of_et") or d.get("as_of"))
    arrow = {"LONG": "🟢↗", "SHORT": "🔴↘"}
    picks = d.get("picks") or []
    lines = [hdr("₿", "Crypto Desk", sub=fresh)]
    dirs = []
    for p in picks:
        coin = p.get("coin")
        dirn = (p.get("direction") or "").upper()
        dirs.append(dirn)
        a = arrow.get(dirn, "⚪")
        pu = p.get("prob_up")
        pup = f"{pu*100:.0f}%up" if isinstance(pu, (int, float)) else None
        crowd = (p.get("magnets") or {}).get("crowd_note", "")
        warn = "⚠️crowded" if "crowded" in str(crowd) else None
        lines.append(row(coin, f"{_px(p.get('spot'))} {a}{dirn[:5]}", pup,
                          f"ref {_px(p.get('entry'))}",
                          warn))
    if picks and all(x == "SHORT" for x in dirs):
        lines.append(esc("→ all reads SHORT; no long-side setup (Alpaca is long-only)"))
    elif any(x == "LONG" for x in dirs):
        longs = ", ".join(p.get("coin") for p in picks if (p.get("direction") or "").upper() == "LONG")
        lines.append(esc(f"→ long setup: {longs}"))
    macro = d.get("macro") or {}
    lines.append(footer(f"alert-only · {d.get('horizon_days')}d horizon · {macro.get('geopol_tone','')}"))
    return join(*lines)


def _ivp(iv):
    return f"{iv*100:.0f}%" if isinstance(iv, (int, float)) else "?"


def greeks():
    """Greeks + IV on the contracts we follow (held options + current picks).
    Helps decide WHICH contract: delta = directional punch, IV = cheap vs pricey."""
    bc = _load("best_contracts.json")
    lines = [hdr("📐", "Greeks / IV")]
    held = _journal("open")
    if held:
        lines.append(section("Journal"))
    for r in held[:4]:
        typ = (r.get("type") or r.get("side") or "")[:1].upper()
        strike = r.get("strike")
        lines.append(row(r.get('symbol'), f"${strike:g}{typ}" if isinstance(strike, (int, float)) else None,
                          _fmt_exp(r.get('expiry')), f"in {_money(r.get('entry'))}"))
    paused = paused_note()
    picks = [] if paused else (bc or {}).get("picks", []) or []
    if paused:
        lines.append(esc(paused))
    if picks:
        lines.append(section("Watching"))
    for p in picks:
        typ = (p.get("type") or "")[:1].upper()
        d = p.get("delta")
        ds = f"Δ{d:.2f}" if isinstance(d, (int, float)) else "Δ?"
        lines.append(row(p.get('ticker'), f"${p.get('strike'):g}{typ}", ds,
                          f"IV {_ivp(p.get('iv'))}", p.get('value')))
    if not held and not picks and not paused:
        lines.append("no live contracts right now — picks load at market open.")
    lines.append(footer("high IV = pricey (rich) → better to sell premium; low IV = cheap to buy"))
    return join(*lines)


def _close_tape():
    """SPY/QQQ/IWM/VIX close + day % (yfinance daily). None on failure."""
    try:
        import yfinance as yf
        df = yf.download(["SPY", "QQQ", "IWM", "^VIX"], period="5d", interval="1d",
                         progress=False, auto_adjust=False, threads=False)["Close"]
        df = df.dropna(how="all")
        if len(df) < 2:
            return None
        out = []
        for sym, label in (("SPY", "SPY"), ("QQQ", "QQQ"), ("IWM", "IWM"), ("^VIX", "VIX")):
            c, pv = float(df[sym].iloc[-1]), float(df[sym].iloc[-2])
            pct = (c / pv - 1) * 100 if pv else 0.0
            out.append(f"{label} {c:,.0f} ({pct:+.1f}%)" if label != "VIX" else f"VIX {c:.1f} ({pct:+.1f}%)")
        return " · ".join(out)
    except Exception:
        return None


def _close_breadth():
    """S&P breadth close from the console breadth route (share of members on a buy signal)."""
    d = _mc("/api/console/breadth?scope=SPY")
    try:
        br = (d.get("current") or {}).get("breadth") or []
        ema = ((d.get("series") or {}).get("ema20") or [])
        now, prev = float(br[-1]), float(br[-2])
        e20 = float(ema[-1]) if ema else None
        tone = "expanding" if now > prev else "contracting"
        return (f"{now:.0f}% of the S&P on a buy signal ({now - prev:+.1f} vs yesterday, {tone})"
                + (f" · 20d avg {e20:.0f}%" if e20 is not None else ""))
    except Exception:
        return None


def _close_sectors():
    """Top-2 / bottom-2 sector ETFs on the day from /api/sector-rotation."""
    d = _mc("/api/sector-rotation")
    try:
        secs = [x for x in d.get("sectors") or [] if isinstance(x.get("return1d"), (int, float))]
        if len(secs) < 4:
            return None
        secs.sort(key=lambda x: x["return1d"], reverse=True)
        f = lambda x: f"{x['symbol']} {x['return1d']:+.1f}%"
        return f"led {f(secs[0])}, {f(secs[1])} · lagged {f(secs[-1])}, {f(secs[-2])}"
    except Exception:
        return None


def _tomorrow_events():
    """Tomorrow's scheduled macro/earnings events via macro_calendar_alert.build (no route)."""
    try:
        import macro_calendar_alert as mca
        from datetime import timedelta
        today, ev = mca.build(1)
        tom = today + timedelta(days=1)
        rows = [e for e in ev if e.get("date") == tom]
        if not rows:
            return "clear — no scheduled high-impact catalysts"
        rows.sort(key=lambda e: e.get("impact") != "high")
        return " · ".join(f"{e.get('tag','')} {e.get('event','')}".strip() for e in rows[:4])
    except Exception:
        return None


def _sessions_old(as_of: str, today: str):
    """Weekdays between as_of and today (None if unparseable)."""
    try:
        from datetime import date, timedelta
        a, t = date.fromisoformat(as_of), date.fromisoformat(today)
    except Exception:
        return None
    n, d = 0, a
    while d < t:
        d += timedelta(days=1)
        if d.weekday() < 5:
            n += 1
    return n


def eod():
    """Market CLOSE wrap — tape, breadth, sectors, what graded today, tomorrow's calendar.
    Deterministic, no LLM, no account data (Alpaca is data only, 2026-09-16)."""
    sb = _load("scoreboard.json")
    today = datetime.now(ET).strftime("%Y-%m-%d")
    lines = [hdr("🌙", "Close")]
    tape = _close_tape()
    if tape:
        lines.append("📊 " + esc(tape))
    br = _close_breadth()
    if br:
        lines.append("📈 " + b("BREADTH") + " " + esc(br))
    sec = _close_sectors()
    if sec:
        lines.append("🧭 " + b("SECTORS") + " " + esc(sec))
    if sb:
        rec = [r for r in (sb.get("recent") or []) if str(r.get("date")) == today]
        if rec:
            w = sum(1 for r in rec if r.get("outcome") == "win")
            lines.append("🎓 " + esc(f"today graded: {len(rec)} ({w}W/{len(rec)-w}L)"))
    g = grade().splitlines()
    if g:
        as_of = str((sb or {}).get("as_of") or "")[:10]
        stale_days = _sessions_old(as_of, today)
        if stale_days is not None and stale_days > 1:
            lines.append("🎓 " + esc(f"Track record STALE — last graded {as_of[5:]} "
                                      f"({stale_days} sessions old; producer paused since 09-30), not today's"))
        else:
            lines.append(g[-1])  # the 🔴/🟡/🟢 readiness line (already HTML-escaped by grade())
    tom = _tomorrow_events()
    if tom:
        lines.append("📆 " + b("TOMORROW") + " " + esc(tom))
    lines.append(footer("cost per contract · advisory — you place every trade"))
    return join(*lines)


GRAD_MIN_N = 50   # Mike's standing go-live gate: n>=50 graded + positive expectancy
GRAD_MIN_WR = 0.40


def grade():
    """Honest readiness read off the pipeline scoreboard (graded picks). The whole point of
    building a graded track record first."""
    d = _load("scoreboard.json")
    if not d:
        return "no track record yet — picks get graded as they play out."
    o = d.get("overall") or {}
    n = o.get("graded", 0) or 0
    wr = o.get("win_rate")
    exp = o.get("expectancy_pct")
    wrp = f"{wr*100:.0f}%" if isinstance(wr, (int, float)) else "?"
    expv = exp if isinstance(exp, (int, float)) else 0.0
    as_of = (d.get("as_of") or "")[:10]
    head = join(hdr("🎓", "Graduation Check"),
                esc(f"HISTORICAL (n={n} graded, through {as_of}): win {wrp}, exp {expv:+.1f}%"))
    gate = esc(f"gate: {GRAD_MIN_N}+ trades & positive expectancy")
    if n < GRAD_MIN_N:
        status = esc(f"🔴 building proof — {n}/{GRAD_MIN_N} trades. Keep grading picks first.")
    elif expv <= 0:
        status = esc(f"🔴 {n} trades but no edge yet (exp {expv:+.1f}%). Refine.")
    elif (wr or 0) < GRAD_MIN_WR:
        status = esc(f"🟡 positive expectancy, thin win-rate ({wrp}). Keep grading.")
    else:
        status = "🟢 GATE PASS — edge proven (historical)."
    return join(head, gate, status)


def tidy(text, max_lines=10):
    """Deterministic anti-bloat: drop a Sources/citations footer + bare URL lines,
    cap to max_lines. So an over-helpful LLM can't bury Mike in links."""
    if not text:
        return text
    out = []
    # markdown links -> keep the outlet name, drop the URL; strip any leftover bare URL
    text = re.sub(r"\[([^\]]+)\]\(https?://[^)\s]*\)", r"\1", text)
    text = re.sub(r"\s*\(?<?https?://\S+>?\)?", "", text)
    for ln in text.splitlines():
        s = ln.strip()
        if re.match(r"(?i)^(sources?|citations?|references?|data sources?)\b\s*:?\s*$", s):
            break
        if re.match(r"(?i)^sources?\s*:", s):
            break
        if re.match(r"^\(?<?https?://", s):
            continue
        if re.match(r"^[-*•]\s*\[.*\]\(https?://", s):
            continue
        out.append(ln)
        if sum(1 for l in out if l.strip()) >= max_lines:
            break
    return "\n".join(out).strip()


def holdings():
    """Tickers in Mike's OPEN journal fills — for journal-aware news. Never a broker read."""
    out = []
    for r in _journal("open"):
        s = r.get("symbol")
        if s and s not in out:
            out.append(s)
    return out


def news_prompt():
    """Prompt for an LLM /news read — politics/macro headlines → impact on my journal names."""
    held = ", ".join(holdings()) or "my watchlist"
    return ("Pull the TOP 3-4 market-moving news / politics / macro headlines RIGHT NOW "
            "(use the news-search skill or a quick web search). I have ADD, so be TIGHT. "
            "For EACH headline give ONE line: the headline + likely market impact "
            "(risk-on/off, which sectors) + whether it touches my journal names "
            f"({held}). Then ONE final line starting 'PREP:' with the single most useful "
            "action to protect or position my open journal fills today. No preamble, no markdown "
            "headers/tables, plain text, max 10 short lines. If nothing is actually moving "
            "markets, just say 'Quiet — no action needed.'")


def premarket_prompt():
    """Prompt for the 8:55 ET pre-market brief — catalysts/politics/macro → plan."""
    held = ", ".join(holdings()) or "my watchlist"
    return ("Write my PRE-MARKET brief for today (Eastern Time). I have ADD — be TIGHT: "
            "≤8 short lines, plain text, NO markdown headers/tables. Use the news-search "
            "skill or a quick web search. In this order:\n"
            "Line 1: one-word tone (RISK-ON / RISK-OFF / NEUTRAL) + a 4-6 word why.\n"
            "Next: today's market-moving CATALYSTS only — FOMC/econ data, major earnings, "
            "politics/geopolitics — one line each, skip anything minor.\n"
            f"Next: do any of my journal names ({held}) have a catalyst today? one line.\n"
            "Last line must start 'PLAN:' with the single most useful thing to do at/after "
            "the open, trading SMALL. "
            "Do not repeat the date, include no links or URLs (name the outlet in words only), and "
            "label the journal-names line 'Watchlist:'. Quiet day → say so, keep it to 3 lines.")


def greeks_prompt(ticker):
    """Prompt for a live greeks/IV lookup on any ticker/contract (incl. flow alerts)."""
    return (f"Give me the live greeks + implied volatility for the most relevant near-term "
            f"option contracts on {ticker.upper()} (use the options-desk or alpaca-trading "
            f"skill / Alpaca options snapshot). I have ADD — be TIGHT: for the near-the-money "
            f"CALL and PUT (nearest liquid weekly/monthly), ONE line each: strike, expiry, "
            f"delta, theta, vega, IV. Then ONE line 'READ:' — is the premium cheap or rich to "
            f"buy now, and any IV-crush risk (earnings soon?). Max 7 lines, plain text, no "
            f"tables, no links.")


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
    arg = sys.argv[2] if len(sys.argv) > 2 else ""
    if cmd == "winners":
        import flow_chase
        print(flow_chase.winners())
    elif cmd == "chase":
        import flow_chase
        print(flow_chase.chase(arg or "SPY"))
    else:
        print(pick(1) if cmd == "pick" else pick(3) if cmd == "picks"
              else grade() if cmd == "grade" else eod() if cmd == "eod"
              else greeks() if cmd == "greeks" else flow() if cmd == "flow"
              else crypto() if cmd == "crypto" else explain() if cmd == "explain"
              else sweeps() if cmd == "sweeps" else odte() if cmd == "odte" else book())
