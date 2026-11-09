"""Every FlowGreeks Firebase resource, read locally and read-only, for the SynthControl /flow command.

Resources (Firebase RTDB stock-signal-72772 -> the local copy this reads):
  FG Alerts       /FlowGreeks/Alerts/today      option-scraper data/flow_alerts_today.json (scraped every 5 min)
  FG2 Alerts      /FlowGreeks2/Alerts/today     option-scraper data/flow2_alerts_today.json
  FG LiveFlows    /FlowGreeks/LiveFlows/today   ~/firebase-signals/live_signals.jsonl (fcm-rtdb live stream, feeds
                  + /FlowGreeks/LiveFlowLast100  flow_live_today/flow_live100) + data/flow_liveflows_today.json and
                                                 data/flow_live_last100.json (scrapes); earlier weeks from the
                                                 ~/02_DATA/firebase-raw weekly archives
  FG2 LiveFlows   /FlowGreeks2/LiveFlows/today  stream feed flow2_live_today + data/flow2_liveflows_today.json
  FG BullBears    /FlowGreeks/BullBears/today   data/flow_bullbears_today.json
  FG2 BullBears   /FlowGreeks2/BullBears        data/flow2_bullbears.json ("today" + one key per day)

Every signal is tagged with its category, resource and the Discord channel the posters route it to, using the same
rules as fcm-discord (firebase-signals/discord_poster.py) and option-relay (discord_relay.get_flow_channel):
  Alerts:    *_etf -> #flow-etf-weekly · weekly_flow -> #fg-weekly · repeat_flow -> #flow-repeaters ·
             unusual_high_flow -> #flow-unusual · high_flow -> #flow-huge · anything else -> #flow-fg-alerts
             (FG2: #fg2-option-alerts)
  LiveFlows: COLOR green or >= $500K -> Huge #flow-huge · yellow or >= $150K -> Unusual #flow-unusual ·
             >= $50K -> Live #flow-live · below $50K is not posted anywhere
Alerts from earlier days (days > 1) come from the alert cards in those Discord channels (lib/discord_flow), since the
Firebase Alerts node only holds today. Never writes anything; the *_alerts_today.json files are read only.
"""
from __future__ import annotations

import gzip
import json
import os
from collections import Counter
from datetime import date, datetime, timedelta
from pathlib import Path
from zoneinfo import ZoneInfo

ET = ZoneInfo("America/New_York")
OS_DATA = Path("/AIWorkWSL/trading/signals/option-scraper/data")
STREAM = Path.home() / "firebase-signals" / "live_signals.jsonl"
STREAM_HB = Path.home() / "firebase-signals" / "rtdb_heartbeat"
ARCHIVE = Path.home() / "02_DATA" / "firebase-raw"

DUP_WINDOW_S = 10
CATS = ("Huge", "Unusual", "Repeated", "Weekly", "Live", "Other")
_ALERT_CAT = {"high_flow": "Huge", "unusual_high_flow": "Unusual", "repeat_flow": "Repeated", "weekly_flow": "Weekly"}
_ALERT_CHAN = {"Huge": "#flow-huge", "Unusual": "#flow-unusual", "Repeated": "#flow-repeaters", "Weekly": "#fg-weekly"}
_STREAM_FEEDS = {"flow_live_today": "FG", "flow_live100": "FG", "flow2_live_today": "FG2"}


# ─── routing (pure, tested) ───────────────────────────────────────────────────
def route_alert(alert_type: str | None, fg2: bool = False) -> tuple[str, bool, str]:
    """AlertType -> (category, is_etf, Discord channel)."""
    at = (alert_type or "").lower()
    etf = at.endswith("_etf")
    cat = _ALERT_CAT.get(at[:-4] if etf else at, "Other")
    if etf:
        return cat, True, "#flow-etf-weekly"
    if cat == "Other":
        return cat, False, "#fg2-option-alerts" if fg2 else "#flow-fg-alerts"
    return cat, False, _ALERT_CHAN[cat]


def route_live(color: str | None, value: float) -> tuple[str, str]:
    """LiveFlows trade -> (category, Discord channel), fcm-discord format_raw_flow rule."""
    c = (color or "white").lower()
    if c == "green" or value >= 500_000:
        return "Huge", "#flow-huge"
    if c == "yellow" or value >= 150_000:
        return "Unusual", "#flow-unusual"
    return "Live", "#flow-live" if value >= 50_000 else "not posted (< $50K)"


def _num(v) -> float:
    try:
        return float(v or 0)
    except (TypeError, ValueError):
        return 0.0


def _exp(epoch_s) -> str:
    try:
        return datetime.fromtimestamp(int(epoch_s), ET).strftime("%m/%d/%y")
    except (TypeError, ValueError, OSError):
        return "?"


def _exp_str(s) -> str | None:
    try:
        return date.fromisoformat(str(s)).strftime("%m/%d/%y")
    except ValueError:
        return None


def alert_sig(entry: dict, fg2: bool = False) -> dict | None:
    a = entry.get("alert", entry) if isinstance(entry, dict) else None
    if not isinstance(a, dict) or not a.get("Symbol") or not a.get("Time"):
        return None
    cat, etf, chan = route_alert(a.get("AlertType"), fg2)
    res = "FG2 Alerts" if fg2 else "FG Alerts"
    return {"sym": a["Symbol"], "strike": f"{_num(a.get('Strike')):g}", "cp": str(a.get("OptionType", "?"))[:1].upper(),
            "exp": _exp(a.get("Expiry")), "premium": _num(a.get("totalFlowValue", a.get("Value"))),
            "ts": datetime.fromtimestamp(int(a["Time"]) / 1000, ET), "cat": cat, "etf": etf, "chan": chan,
            "resource": f"{res} {a.get('AlertType') or 'untyped'}",
            "view": "bull" if a.get("isBullish") else "bear", "side": "", "color": "",
            "size": int(_num(a.get("Volume"))), "oi": int(_num(a.get("OI"))),
            "sweeps": int(_num(a.get("SWEEPS"))), "blocks": int(_num(a.get("BLOCKS")))}


def live_sig(d: dict, fg2: bool = False) -> dict | None:
    if not isinstance(d, dict) or not d.get("Symbol") or not d.get("Time"):
        return None
    v = _num(d.get("Value"))
    cat, chan = route_live(d.get("COLOR"), v)
    ba = str(d.get("BidAskType") or "")
    return {"sym": d["Symbol"], "strike": f"{_num(d.get('Strike')):g}", "cp": str(d.get("OptionType", "?"))[:1].upper(),
            "exp": _exp_str(d.get("ExpiryStr")) or _exp(d.get("Expiry")), "premium": v,
            "ts": datetime.fromtimestamp(int(d["Time"]) / 1000, ET), "cat": cat, "etf": d.get("UnderlyingType") == "ETF",
            "chan": chan, "resource": f"{'FG2' if fg2 else 'FG'} LiveFlows {(d.get('COLOR') or 'white').lower()}",
            "view": "", "side": "ask" if ba == "A" else "bid" if ba == "B" else ba.lower(),
            "color": (d.get("COLOR") or "white").lower(), "size": int(_num(d.get("Volume"))), "oi": int(_num(d.get("OI"))),
            "sweeps": None, "blocks": None, "kind": d.get("BlockType") or ""}


# ─── loaders (local files, read-only) ─────────────────────────────────────────
def _load_json(p: Path):
    try:
        return json.loads(p.read_text())
    except (OSError, ValueError):
        return None


def _as_of(p: Path) -> str:
    try:
        return datetime.fromtimestamp(p.stat().st_mtime, ET).strftime("%H:%M ET")
    except OSError:
        return "missing"


def load_alerts(status: dict) -> list[dict]:
    out = []
    for fname, fg2, res in (("flow_alerts_today.json", False, "FG Alerts"), ("flow2_alerts_today.json", True, "FG2 Alerts")):
        p = OS_DATA / fname
        d = _load_json(p)
        rows = [s for s in (alert_sig(v, fg2) for v in d.values()) if s] if isinstance(d, dict) else []
        status[res] = (len(rows), f"scrape {_as_of(p)}" if rows else
                       ("Firebase node empty today" if p.exists() else "file missing"))
        out += rows
    return out


def _stream_lines(start: datetime):
    """Raw LiveFlows lines from the live stream file plus the weekly archives that overlap the window."""
    files = [STREAM]
    if start.date() < date.today() - timedelta(days=date.today().weekday() + 1):
        files += sorted(ARCHIVE.glob("live_signals-week-ending-*.jsonl.gz"))[-2:]
    for f in files:
        if not f.exists():
            continue
        opener = gzip.open if f.suffix == ".gz" else open
        with opener(f, "rt", errors="replace") as fh:
            for line in fh:
                if '"flow_live' in line or '"flow2_live' in line:
                    yield line


def load_liveflows(start: datetime, end: datetime, status: dict) -> list[dict]:
    seen: dict[tuple, dict] = {}
    t0, t1 = start.timestamp() * 1000, end.timestamp() * 1000
    counts = Counter()
    for line in _stream_lines(start):
        try:
            e = json.loads(line)
        except ValueError:
            continue
        grp = _STREAM_FEEDS.get(e.get("feed"))
        d = e.get("data")
        if not grp or not isinstance(d, dict) or not (t0 <= _num(d.get("Time")) < t1):
            continue
        k = (grp, str(e.get("key")))
        if k not in seen and (s := live_sig(d, grp == "FG2")):
            seen[k] = s
            counts[grp + " stream"] += 1
    if True:  # the scrapes hold today only; the time filter below drops anything outside the window
        for fname, grp in (("flow_liveflows_today.json", "FG"), ("flow_live_last100.json", "FG"),
                           ("flow2_liveflows_today.json", "FG2")):
            d = _load_json(OS_DATA / fname)
            if not isinstance(d, dict):
                continue
            for key, v in d.items():
                if (grp, str(key)) not in seen and isinstance(v, dict) and t0 <= _num(v.get("Time")) < t1 \
                        and (s := live_sig(v, grp == "FG2")):
                    seen[(grp, str(key))] = s
                    counts[grp + " scrape"] += 1
    try:
        hb = datetime.fromtimestamp(float(STREAM_HB.read_text().strip()), ET).strftime("%H:%M ET")
    except (OSError, ValueError):
        hb = "no heartbeat"
    # One trade can arrive under several keys (stream, LiveFlowLast100, scrape), and FlowGreeks sometimes posts the
    # same print several times a second apart. Identical prints (contract, value, size, side, kind) within
    # DUP_WINDOW_S collapse into one row with dup = how many copies arrived.
    rows, last = [], {}
    for r in sorted(seen.values(), key=lambda r: r["ts"]):
        c = (r["resource"][:3], r["sym"], r["strike"], r["cp"], r["exp"], r["premium"], r["size"], r["side"], r["kind"])
        prev = last.get(c)
        if prev is not None and (r["ts"] - prev[1]).total_seconds() <= DUP_WINDOW_S:
            prev[0]["dup"] += 1
            last[c] = (prev[0], r["ts"])          # sliding: a burst stays one row while copies keep coming
            continue
        r["dup"] = 1
        last[c] = (r, r["ts"])
        rows.append(r)
    for grp in ("FG", "FG2"):
        n = sum(1 for r in rows if r["resource"].startswith(grp + " "))
        extra = counts[grp + " scrape"]
        status[f"{grp} LiveFlows"] = (n, f"RTDB stream (heartbeat {hb})" + (f" + {extra} only in the scrape" if extra else "")
                                      if n else "Firebase node empty in window")
    return rows


def bullbears(sym: str) -> list[str]:
    out = []
    d = _load_json(OS_DATA / "flow_bullbears_today.json")
    r = d.get(sym) if isinstance(d, dict) else None
    out.append(f"FG BullBears today ({_as_of(OS_DATA / 'flow_bullbears_today.json')}): " +
               (f"{'🟢 bullish' if r.get('isBullish') else '🔴 bearish'} · net {_m(_num(r.get('valueDifference')))} · "
                f"rank {r.get('Rank')} · {r.get('count')} flows" if isinstance(r, dict) else "not listed"))
    d2 = _load_json(OS_DATA / "flow2_bullbears.json")
    when, r2 = "today", None
    if isinstance(d2, dict):
        r2 = (d2.get("today") or {}).get(sym) if isinstance(d2.get("today"), dict) else None
        if r2 is None and not d2.get("today"):
            days = sorted((k for k in d2 if k.isdigit()), key=int)
            if days:
                when = "STALE: node empty today, last day " + datetime.fromtimestamp(int(days[-1]), ET).strftime("%m/%d")
                r2 = d2[days[-1]].get(sym) if isinstance(d2[days[-1]], dict) else None
    out.append(f"FG2 BullBears ({when}): " +
               (f"{'🟢 bullish' if r2.get('isBullish') else '🔴 bearish'} · bull {_m(_num(r2.get('bullishValue')))} vs "
                f"bear {_m(_num(r2.get('bearishValue')))} · rank {r2.get('Rank')} · {r2.get('count')} flows"
                if isinstance(r2, dict) else "not listed"))
    return out


# ─── filter + render ──────────────────────────────────────────────────────────
TYPE_HELP = {"huge": "Huge", "unusual": "Unusual", "repeated": "Repeated", "weekly": "Weekly", "live": "Live",
             "other": "Other"}


def pick(sigs: list[dict], kind: str, ticker: str | None, lo: float | None, hi: float | None) -> list[dict]:
    t = (ticker or "").upper() or None
    out = []
    for s in sigs:
        if t and s["sym"] != t:
            continue
        if lo is not None and s["premium"] < lo or hi is not None and s["premium"] > hi:
            continue
        if kind == "etf" and not (s["etf"] and s["resource"].startswith(("FG Alerts", "FG2 Alerts"))):
            continue
        if kind == "fg2" and not s["resource"].startswith("FG2"):
            continue
        if kind in TYPE_HELP and s["cat"] != TYPE_HELP[kind]:
            continue
        out.append(s)
    return out


def _m(x: float | None) -> str:
    if x is None:
        return "n/a"
    a = abs(x)
    v = f"${a / 1e9:.2f}B" if a >= 1e9 else f"${a / 1e6:.2f}M" if a >= 1e6 else f"${a / 1e3:.0f}K" if a >= 1e3 else f"${a:.0f}"
    return ("-" if x < 0 else "") + v


def tag(s: dict) -> str:
    return f"[{s['cat']}{' ETF' if s['etf'] and 'Alerts' in s['resource'] else ''} · {s['resource']} → {s['chan']}]"


def line(s: dict) -> str:
    bits = [f"{s['sym']} ${s['strike']}{s['cp']} {s['exp']}", _m(s["premium"])]
    if s["view"]:
        bits.append(f"FG {'🟢 bull' if s['view'] == 'bull' else '🔴 bear'}")
    if s.get("kind") or s["side"]:
        bits.append(f"{s.get('kind', '')} {s['side']}".strip())
    if s["size"] is not None and s["oi"] is not None:
        bits.append(f"vol {s['size']:,} / OI {s['oi']:,}")
    if s["sweeps"] is not None:
        bits.append(f"{s['sweeps']}sw/{s['blocks']}bl")
    bits.append(f"{s['ts']:%m/%d %H:%M} ET")
    if s.get("dup", 1) > 1:
        bits.append(f"×{s['dup']} identical prints, counted once")
    return "• " + " · ".join(bits) + " " + tag(s)


def render(sigs: list[dict], status: dict, *, kind: str, ticker: str | None, lo: float | None, hi: float | None,
           since: datetime, bb: list[str] | None = None, top: int = 10) -> str:
    band = "" if lo is None and hi is None else f" · premium {_m(lo) if lo is not None else '$0'}–{_m(hi) if hi is not None else 'any'}"
    out = [f"**{ticker.upper() + ' · ' if ticker else ''}FlowGreeks {kind} flow** · since {since:%a %m/%d} ET{band} · "
           f"{len(sigs):,} signals",
           "Sources: " + " · ".join(f"{k} {n:,} ({why})" for k, (n, why) in status.items())]
    cats = Counter()
    prem = Counter()
    for s in sigs:
        cats[s["cat"]] += 1
        prem[s["cat"]] += s["premium"]
    if sigs:
        out.append("By type: " + " · ".join(f"{c} {cats[c]:,} {_m(prem[c])}" for c in CATS if cats[c]))
        calls = [s for s in sigs if s["cp"] == "C"]
        puts = [s for s in sigs if s["cp"] == "P"]
        out.append(f"Calls {_m(sum(s['premium'] for s in calls))} ({len(calls):,}) · Puts "
                   f"{_m(sum(s['premium'] for s in puts))} ({len(puts):,})")
    out += bb or []
    if not sigs:
        out.append("No FlowGreeks signals matched.")
        return "\n".join(out)
    if not ticker:
        tk = Counter()
        for s in sigs:
            tk[s["sym"]] += s["premium"]
        out.append("Top tickers: " + " · ".join(f"{t} {_m(p)}" for t, p in tk.most_common(8)))
    rep = Counter((s["sym"], s["strike"], s["cp"], s["exp"]) for s in sigs)
    multi = [(k, n) for k, n in rep.most_common(5) if n > 1]
    if multi:
        out.append("Same contract more than once: " + " · ".join(f"{k[0]} {k[1]}{k[2]} {k[3]} ×{n}" for k, n in multi))
    out.append("Biggest:")
    out += [line(s) for s in sorted(sigs, key=lambda s: -s["premium"])[:top]]
    return "\n".join(out)


def history_alerts(token: str, start: datetime, today0: datetime, status: dict, kind: str = "all") -> list[dict]:
    """Alerts before today: the alert cards in the typed Discord channels (Firebase keeps only today's Alerts)."""
    from lib import discord_flow as D
    if start >= today0:
        return []
    out = []
    chans = {"#flow-huge": "flow_huge", "#flow-unusual": "flow_unusual", "#flow-repeaters": "flow_repeaters",
             "#fg-weekly": "flow_weekly", "#flow-etf-weekly": "flow_etf", "#flow-fg-alerts": "flow_alerts"}
    # the #flow-etf-weekly cards don't say which *_etf type they are, so they only count for etf / all
    want = {"huge": ["#flow-huge"], "unusual": ["#flow-unusual"], "repeated": ["#flow-repeaters"],
            "weekly": ["#fg-weekly"], "etf": ["#flow-etf-weekly"], "other": ["#flow-fg-alerts"],
            "fg2": []}.get(kind, list(chans))

    def one(chan):
        msgs, _cap, _name = D.fetch(D.channel_id(chans[chan]), start, token)
        return chan, msgs

    from concurrent.futures import ThreadPoolExecutor
    with ThreadPoolExecutor(max_workers=6) as ex:
        fetched = list(ex.map(one, want))
    for chan, msgs in fetched:
        for m in msgs:
            for c in D.parse_cards(m):
                if c["ts"] >= today0:
                    continue
                at = c["alert_type"] or {"#flow-huge": "high_flow", "#flow-unusual": "unusual_high_flow",
                                          "#flow-repeaters": "repeat_flow", "#fg-weekly": "weekly_flow"}.get(chan)
                if chan == "#flow-fg-alerts" and c["alert_type"] in _ALERT_CAT:
                    continue          # typed alert already read from its own channel
                cat, etf, routed = route_alert(at)
                if chan == "#flow-etf-weekly":
                    etf, routed, at = True, chan, at or "*_etf, type not on card"
                out.append({**c, "cat": cat, "etf": etf, "chan": routed,
                            "resource": f"FG Alerts {at or 'untyped'} (from the {chan} card)", "side": "", "color": ""})
    seen, uniq = set(), []
    for s in sorted(out, key=lambda s: s["ts"]):
        k = (s["sym"], s["strike"], s["cp"], s["exp"], round(s["premium"], -3), s["ts"].date())
        if k not in seen:
            seen.add(k)
            uniq.append(s)
    status["FG Alerts (earlier days)"] = (len(uniq), "Discord alert cards")
    return uniq


def scan(*, kind: str = "all", ticker: str | None = None, lo: float | None = None, hi: float | None = None,
         days: int = 1, token: str | None = None) -> str:
    from lib.discord_flow import start_of_window
    since = start_of_window(max(1, min(days, 5)))
    now = datetime.now(ET)
    today0 = datetime.combine(now.date(), datetime.min.time(), tzinfo=ET)
    status: dict = {}
    sigs = [s for s in load_alerts(status) if s["ts"] >= since]
    if kind != "live":
        try:
            sigs += history_alerts(token, since, today0, status, kind) if token else []
        except Exception as e:  # noqa: BLE001
            status["FG Alerts (earlier days)"] = (0, f"UNAVAILABLE: Discord read failed ({e.__class__.__name__})")
    if kind not in ("repeated", "weekly", "etf", "other"):
        sigs += load_liveflows(since, now + timedelta(minutes=1), status)
    sym = (ticker or "").strip().upper().lstrip("$") or None
    rows = pick(sigs, kind, sym, lo, hi)
    return render(rows, status, kind=kind, ticker=sym, lo=lo, hi=hi, since=since, bb=bullbears(sym) if sym else None)
