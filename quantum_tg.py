#!/home/itsju/.venv/bin/python
"""Quantum pipeline picks → ADD-friendly Telegram one-liners (READ-ONLY).

Reads the quantum pricing pipeline's END-RESULT artifacts (owned by another session
— we only READ them) and distills the single best actionable contract into a verdict-
first, zero-bloat message. Powers /pick /picks /book on the Telegram responders.

Anti-bloat doctrine: ONE clear action, ≤5 short lines, no data walls. Honest when
there's nothing clean (capital preservation > FOMO).
"""
import json, os, re
from datetime import datetime
from zoneinfo import ZoneInfo

OUT = os.path.expanduser("~/labs/quantum/out")
SCRAPER = os.path.expanduser("~/trading/signals/option-scraper/data")
ET  = ZoneInfo("America/New_York")


def _load(name):
    try:
        return json.load(open(os.path.join(OUT, name)))
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
    lines = [f"🌊 *FLOW ALERTS* · {when} ET"]
    sw = _stale_warning(d.get("generated_at_et"), max_min=45).strip()
    if sw:
        lines.append(sw)
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
        sz = c.get("sizing") or {}
        e, t1, st = sz.get("suggested_entry"), sz.get("target_1"), sz.get("stop_price")
        tail = (f" · entry ${e:g}→T1 ${t1:g} (stop ${st:g})"
                if isinstance(e, (int, float)) and isinstance(t1, (int, float)) else "")
        rows.append(f"{emo} {sym} ${c.get('strike'):g}{t} {c.get('expiry_dte')}d · "
                    f"{sent[:4]} · rank {c.get('flowrank')} · {_human(c.get('premium_usd'))}{tail}")
        if len(rows) >= 3:
            break
    lines += rows
    for ap in (d.get("top_app_picks") or [])[:1]:
        if isinstance(ap, dict):
            lines.append(f"app: {ap.get('symbol')} ${ap.get('strike')}"
                         f"{(ap.get('type') or '')[:1]} · {ap.get('category')} · "
                         f"buy {ap.get('buy_target')}→{ap.get('sell_target')}")
    if len(lines) == 1:
        lines.append("quiet — no standout flow right now.")
    lines.append("_big-money positioning. /greeks <TKR> for live greeks/IV_")
    return "\n".join(lines)


def explain():
    """Plain-English cheat sheet — what the numbers mean + why they matter. Pulled
    on demand so the alerts themselves stay tight (no inline clutter)."""
    return (
        "📖 *WHAT THE NUMBERS MEAN*\n"
        "Δ delta — moves per $1 in the stock (0.50 ≈ 50¢). Higher = more punch + more cost.\n"
        "θ theta — $ lost to time each day. Your rent for holding. Big θ = clock vs you.\n"
        "IV — how pricey the option is. High = expensive (rich), crushes after earnings; low = cheap.\n"
        "value — our IV read: buy *cheap/fair*, skip *rich*.\n"
        "vol/OI — contracts traded / open. High = liquid (easy in-out, tight spread); low = avoid.\n"
        "src — independent feeds confirming it. More = stronger.\n"
        "⭐ confluence — quantum pick + flow agree = top conviction.\n"
        "✅ cleanest buy = cheap/fair IV + Δ0.40-0.60 + liquid + ⭐.")


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


def _afford_spread(p, risk_cap):
    """The pipeline's OWN debit spread for this pick, IF it fits the risk cap.
    Lets us surface an actionable, cap-fitting trade instead of SKIP when the naked
    contract is too dear — the pipeline already did the structuring; we just read it."""
    s = p.get("spread")
    if not isinstance(s, dict):
        return None
    cost = s.get("cost_per")
    try:
        if risk_cap and cost is not None and float(cost) <= float(risk_cap):
            return s
    except Exception:
        pass
    return None


def _spread_pick_line(p, s):
    """Headline line for a debit-spread play (cap-fitting alternative to the naked call)."""
    typ = (p.get("type") or "").upper()
    rr = s.get("rr")
    rr_s = f" · R:R {rr:.2f}" if isinstance(rr, (int, float)) else ""
    return (f"*{p.get('ticker')} ${s.get('long'):g}/${s.get('short'):g} {typ} SPREAD* · "
            f"{_fmt_exp(p.get('expiry'))} ({p.get('days')}d)\n"
            f"{_money(s.get('cost_per'))} cost · max +{_money(s.get('max_profit'))} / "
            f"-{_money(s.get('max_loss'))}{rr_s} · {p.get('confidence')}-conf · {p.get('value')}")


def _verdict(p, heat=None, risk_cap=None):
    """Honest verdict from action + value, then an ACCOUNT overlay (heat + free cash).
    The overlay can only make it MORE conservative — never talks you into more risk."""
    act = (p.get("action") or "").upper()
    val = (p.get("value") or "").lower()
    if act == "ACT" and val in ("cheap", "fair"):
        base = "🟢 BUY — clean signal, fair price"
    elif act == "ACT" and val == "rich":
        base = "🟡 SMALL — good signal, but IV is rich (pricey)"
    elif act == "ACT-SMALL":
        base = "🟡 SMALL — event risk; keep it light"
    elif act == "WAIT":
        base = "⏳ WAIT — let the setup confirm"
    else:
        base = "🟡 SMALL"
    if (p.get("qty") or 0) < 1:   # naked contract can't be sized within the risk cap
        s = _afford_spread(p, risk_cap)
        if s:   # pipeline's debit spread fits the cap → an actual play, not a SKIP
            return (f"🟢 BUY SPREAD — naked {_money(p.get('per_contract'))} is over cap; "
                    f"the {_money(s.get('cost_per'))} debit spread fits")
        return f"⏳ SKIP — 1 contract ({_money(p.get('per_contract'))}) exceeds your risk cap"
    if heat:
        hp = heat.get("heat_pct") or 0
        if heat.get("over_allocated") or hp >= 55:
            return f"⏳ WAIT — book is hot ({hp:.0f}% heat); manage existing before adding"
        cash, cost = heat.get("cash"), p.get("per_contract")
        if isinstance(cash, (int, float)) and isinstance(cost, (int, float)) and cost > cash:
            return f"⏳ WAIT — only {_money(cash)} free vs {_money(cost)} cost; raise cash first"
    return base


def _pick_line(p):
    typ = (p.get("type") or "").upper()
    qty, pct = p.get("qty") or 0, p.get("pct_of_equity")
    size = (f"buy {qty} = {pct}% of acct" if qty and pct is not None
            else f"1 ct {_money(p.get('per_contract'))} — over your risk cap")
    return (f"*{p.get('ticker')} ${p.get('strike'):g} {typ}* · {_fmt_exp(p.get('expiry'))} "
            f"({p.get('days')}d)\n"
            f"{_money(p.get('per_contract'))}/ct · {size} · {p.get('confidence')}-conf · "
            f"{p.get('sources')} src · {p.get('value')}")


def _fmt_exp(e):
    try:
        return datetime.strptime(e, "%Y-%m-%d").strftime("%-m/%-d")
    except Exception:
        return e


def _acct_line(d):
    h = d.get("portfolio_heat") or {}
    return (f"acct: {_money(d.get('equity'))} · {h.get('heat_pct','?')}% heat · "
            f"{_money(h.get('cash'))} free")


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


def _sweep_line(a, with_tags=True):
    t = (a.get("OptionType") or "")[:1]
    bull = "🟢BULL" if a.get("isBullish") else "🔴BEAR"
    line = (f"🔪 {a.get('Symbol')} ${a.get('Strike'):g}{t} {a.get('DTE')}d · "
            f"{_human(a.get('totalFlowValue'))} · {bull} · OI {a.get('OI') or 0}/vol {a.get('Volume') or 0}")
    if with_tags:
        tg = _sweep_tags(a)
        if tg:
            line += "\n   " + " · ".join(tg)
    return line


def sweeps(top=5, min_prem=500_000):
    """Live institutional sweeps right now — the whales' footprints. /sweeps."""
    raw = [a for a in _sweeps_raw() if (a.get("totalFlowValue") or 0) >= min_prem]
    raw.sort(key=lambda a: a.get("totalFlowValue") or 0, reverse=True)
    if not raw:
        return "no big sweeps in the feed right now."
    lines = ["🔪 *LIVE SWEEPS* (big money positioning)"]
    seen = set()
    for a in raw:
        k = a.get("OptionSymbol")
        if k in seen:
            continue
        seen.add(k)
        lines.append(_sweep_line(a))
        if len(seen) >= top:
            break
    lines.append("_ride the flow · /greeks <TKR> for greeks · /explain_")
    return "\n".join(lines)


def odte(top=6):
    """0DTE / short-DTE (≤2) sweeps — the fast-money game. /odte."""
    raw = [a for a in _sweeps_raw()
           if isinstance(a.get("DTE"), (int, float)) and a["DTE"] <= 2
           and (a.get("totalFlowValue") or 0) >= 300_000]
    raw.sort(key=lambda a: a.get("totalFlowValue") or 0, reverse=True)
    if not raw:
        return "no 0-2 DTE sweeps right now (none, or market closed)."
    lines = ["⚡ *0DTE / SHORT-DTE FLOW*"]
    seen = set()
    for a in raw:
        k = a.get("OptionSymbol")
        if k in seen:
            continue
        seen.add(k)
        lines.append(_sweep_line(a, with_tags=False))
        if len(seen) >= top:
            break
    lines.append("_fast + risky — defined risk only, take profits quick_")
    return "\n".join(lines)


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
        return "⭐ CONFLUENCE — option-signals flow agrees"
    return f"⚠️ flow DISAGREES (flow is {str(fs).lower()}) — extra caution"


def _iv_trap(p):
    """Surface the binary IV-crush trap (earnings inside the contract's life) — the
    quiet killer of option trades. Rich IV alone is already in the verdict."""
    why = (p.get("action_why") or "").lower()
    if "earnings" in why or "crush" in why:
        return "⚠️ IV-TRAP — earnings before expiry (IV can crush the premium)"
    return None


def pick(top=1):
    """The single best (top=1) or top-N actionable picks. Verdict-first."""
    d = _load("best_contracts.json")
    if not d:
        return "no pipeline output yet — it runs market hours (Mon–Fri 9:30–4 ET)."
    picks = d.get("picks") or []
    fresh = _freshness(d.get("as_of"))
    if not picks:
        nd = d.get("n_dropped", 0)
        return (f"🟦 No clean buy right now ({fresh}).\n"
                f"Pipeline checked {d.get('n_considered','?')} and dropped all "
                f"{nd} (too pricey/illiquid/risky). Capital preserved — sit tight.\n"
                f"{_acct_line(d)}")
    heat = d.get("portfolio_heat")
    risk_cap = d.get("risk_cap")
    flowdir = _flow_directions()
    if top == 1:
        p = picks[0]
        spread = _afford_spread(p, risk_cap) if (p.get("qty") or 0) < 1 else None
        conf = _confluence(p, flowdir)
        conf_line = f"{conf}\n" if conf else ""
        trap = _iv_trap(p)
        trap_line = f"{trap}\n" if trap else ""
        head = _spread_pick_line(p, spread) if spread else _pick_line(p)
        order_line = f"📝 {spread['place_order']}\n" if spread and spread.get("place_order") else ""
        return (f"🎯 *TOP PICK* · {fresh}\n"
                f"{_stale_warning(d.get('as_of'))}"
                f"{head}\n"
                f"{_verdict(p, heat, risk_cap)}\n"
                f"{conf_line}{trap_line}"
                f"_why: {(p.get('action_why') or '')[:120]}_\n"
                f"{order_line}"
                f"{_acct_line(d)}")
    lines = [f"🎯 *TOP {min(top,len(picks))} PICKS* · {fresh}"]
    for i, p in enumerate(picks[:top], 1):
        typ = (p.get("type") or "").upper()
        star = " ⭐" if (_confluence(p, flowdir) or "").startswith("⭐") else ""
        sp = _afford_spread(p, risk_cap) if (p.get("qty") or 0) < 1 else None
        price = f"{_money(sp.get('cost_per'))} sprd" if sp else _money(p.get("per_contract"))
        lines.append(f"{i}.{star} {_verdict(p, heat, risk_cap).split(' — ')[0]}  *{p.get('ticker')} "
                     f"${p.get('strike'):g}{typ[0]}* {_fmt_exp(p.get('expiry'))} · "
                     f"{price} · {p.get('confidence')} · {p.get('value')}")
    lines.append(_acct_line(d))
    return "\n".join(lines)


def book():
    """Current paper book + HOLD/TRIM/EXIT verdicts, tight."""
    d = _load("portfolio_manage.json")
    if not d:
        return "no book snapshot yet."
    out = [f"📒 *BOOK* · {_money(d.get('equity'))} · {d.get('heat_pct','?')}% heat · "
           f"{_money(d.get('cash'))} free"]
    positions = d.get("positions") or []
    flagged = []
    # `moves` is keyed BY verdict → list of position dicts (e.g. {"HOLD":[...],"TRIM":[...]}).
    moves = d.get("moves")
    if isinstance(moves, dict):
        for verdict, items in moves.items():
            if str(verdict).upper() in ("HOLD", "KEEP"):
                continue
            for it in (items or []):
                sym = it.get("symbol") if isinstance(it, dict) else it
                flagged.append(f"  ⚠️ {sym}: {verdict}")
    for pos in positions[:6]:
        if isinstance(pos, dict):
            sym = pos.get("symbol") or pos.get("ticker")
            pct = pos.get("pnl_pct")
            pct = f"{pct:+.1f}%" if isinstance(pct, (int, float)) else ""
            out.append(f"  {sym}: {pct} {pos.get('verdict','')}".rstrip())
    if flagged:
        out.append("action:")
        out.extend(flagged)
    else:
        out.append("all HOLD — nothing to do ✅")
    return "\n".join(out)


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
    lines = [f"₿ *CRYPTO DESK* · {fresh}"]
    dirs = []
    for p in picks:
        coin = p.get("coin")
        dirn = (p.get("direction") or "").upper()
        dirs.append(dirn)
        a = arrow.get(dirn, "⚪")
        pu = p.get("prob_up")
        pup = f"{pu*100:.0f}%up" if isinstance(pu, (int, float)) else ""
        crowd = (p.get("magnets") or {}).get("crowd_note", "")
        warn = " ⚠️crowded" if "crowded" in str(crowd) else ""
        lines.append(f"{coin} {_px(p.get('spot'))} {a}{dirn[:5]} {pup} · "
                     f"{_px(p.get('entry'))}→{_px(p.get('target'))} "
                     f"(stp {_px(p.get('stop'))}){warn}")
    if picks and all(x == "SHORT" for x in dirs):
        lines.append("→ all SHORT — no clean long; SIT OUT crypto (Alpaca is long-only)")
    elif any(x == "LONG" for x in dirs):
        longs = ", ".join(p.get("coin") for p in picks if (p.get("direction") or "").upper() == "LONG")
        lines.append(f"→ long setup: {longs}")
    macro = d.get("macro") or {}
    lines.append(f"_alert-only · {d.get('horizon_days')}d horizon · {macro.get('geopol_tone','')}_")
    return "\n".join(lines)


def _ivp(iv):
    return f"{iv*100:.0f}%" if isinstance(iv, (int, float)) else "?"


def greeks():
    """Greeks + IV on the contracts we follow (held options + current picks).
    Helps decide WHICH contract: delta = directional punch, IV = cheap vs pricey."""
    bc = _load("best_contracts.json")
    pm = _load("portfolio_manage.json")
    lines = ["📐 *GREEKS / IV*"]
    held = [p for p in (pm or {}).get("positions", []) or []
            if isinstance(p, dict) and p.get("is_option")]
    for p in held:
        d = p.get("delta"); th = p.get("theta")
        ds = f"Δ{d:+.2f}" if isinstance(d, (int, float)) else ""
        ts = f" θ{th:+.2f}" if isinstance(th, (int, float)) else ""
        lines.append(f"held · {p.get('symbol')} · {ds}{ts} · IV {_ivp(p.get('iv'))}")
    for p in (bc or {}).get("picks", []) or []:
        typ = (p.get("type") or "")[:1].upper()
        d = p.get("delta")
        ds = f"Δ{d:.2f}" if isinstance(d, (int, float)) else "Δ?"
        lines.append(f"{p.get('ticker')} ${p.get('strike'):g}{typ} · {ds} · "
                     f"IV {_ivp(p.get('iv'))} · {p.get('value')}")
    if len(lines) == 1:
        lines.append("no live contracts right now — picks load at market open.")
    lines.append("_high IV = pricey (rich) → better to sell premium; low IV = cheap to buy_")
    return "\n".join(lines)


def eod():
    """End-of-day wrap — facts only (P&L + what graded + grade progress). Deterministic."""
    d = _load("portfolio_manage.json")
    sb = _load("scoreboard.json")
    today = datetime.now(ET).strftime("%Y-%m-%d")
    lines = [f"🌙 *EOD* · {datetime.now(ET).strftime('%a %-m/%-d')}"]
    if d:
        lines.append(f"acct {_money(d.get('equity'))} · {d.get('heat_pct','?')}% heat · "
                     f"{_money(d.get('cash'))} free")
        ps = []
        for p in (d.get("positions") or [])[:5]:
            if isinstance(p, dict):
                sym = p.get("symbol") or p.get("ticker")
                pct = p.get("pnl_pct")
                ps.append(f"{sym} {('%+.1f%%' % pct) if isinstance(pct,(int,float)) else ''}".strip())
        if ps:
            lines.append("positions: " + " · ".join(ps))
    if sb:
        rec = [r for r in (sb.get("recent") or []) if str(r.get("date")) == today]
        if rec:
            w = sum(1 for r in rec if r.get("outcome") == "win")
            lines.append(f"today graded: {len(rec)} ({w}W/{len(rec)-w}L)")
    g = grade().splitlines()
    if g:
        lines.append(g[-1])  # the 🔴/🟡/🟢 readiness line
    return "\n".join(lines)


GRAD_MIN_N = 50   # Mike's standing go-live gate: n>=50 graded + positive expectancy
GRAD_MIN_WR = 0.40


def grade():
    """Honest paper→real readiness off the pipeline scoreboard. Protects against
    going live too early — the whole point of growing paper first."""
    d = _load("scoreboard.json")
    if not d:
        return "no track record yet — picks get graded as they play out."
    o = d.get("overall") or {}
    n = o.get("graded", 0) or 0
    wr = o.get("win_rate")
    exp = o.get("expectancy_pct")
    wrp = f"{wr*100:.0f}%" if isinstance(wr, (int, float)) else "?"
    expv = exp if isinstance(exp, (int, float)) else 0.0
    head = f"🎓 *GRADUATION CHECK*\npaper: {n} graded · {wrp} win · exp {expv:+.1f}%"
    gate = f"gate: {GRAD_MIN_N}+ trades & positive expectancy"
    if n < GRAD_MIN_N:
        status = f"🔴 building proof — {n}/{GRAD_MIN_N} trades. Keep growing paper first."
    elif expv <= 0:
        status = f"🔴 {n} trades but no edge yet (exp {expv:+.1f}%). Stay on paper, refine."
    elif (wr or 0) < GRAD_MIN_WR:
        status = f"🟡 positive expectancy, thin win-rate ({wrp}). One more stretch on paper."
    else:
        status = "🟢 READY — edge proven. Consider sizing up / a small real-money sleeve."
    return f"{head}\n{gate}\n{status}"


def tidy(text, max_lines=10):
    """Deterministic anti-bloat: drop a Sources/citations footer + bare URL lines,
    cap to max_lines. So an over-helpful LLM can't bury Mike in links."""
    if not text:
        return text
    out = []
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
    """Tickers Mike currently holds (from the paper book) — for portfolio-aware news."""
    d = _load("portfolio_manage.json")
    out = []
    for p in (d or {}).get("positions", []) or []:
        if isinstance(p, dict):
            s = p.get("symbol") or p.get("ticker")
            if s:
                out.append(s)
    return out


def news_prompt():
    """Prompt for an LLM /news read — politics/macro headlines → impact on MY book."""
    held = ", ".join(holdings()) or "my watchlist"
    return ("Pull the TOP 3-4 market-moving news / politics / macro headlines RIGHT NOW "
            "(use the news-search skill or a quick web search). I have ADD, so be TIGHT. "
            "For EACH headline give ONE line: the headline + likely market impact "
            "(risk-on/off, which sectors) + whether it touches my holdings "
            f"({held}). Then ONE final line starting 'PREP:' with the single most useful "
            "action to protect or position my paper portfolio today. No preamble, no markdown "
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
            f"Next: do any of my holdings ({held}) have a catalyst today? one line.\n"
            "Last line must start 'PLAN:' with the single most useful thing to do at/after "
            "the open to grow my paper account SAFELY. Quiet day → say so, keep it to 3 lines.")


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
