"""Read the option-relay flow channels in Mike's Discord (huge / unusual / repeaters / weekly / ETF / live / firehose)
and summarise them for the SynthControl /flow command. Read-only: Discord REST GETs with the bot token, nothing posted.

The relay (trading/signals/option-scraper/discord_relay.py) posts two card shapes:
  batch   title "🚨 Huge Flow · 3 signals · 7:50:34 PM UTC", one line per signal:
          "⬜📈 **TSM** `$410.0c` Dec18  ·  $632.5K BLOCK ask  ·  @`$0.0`"
  single  title "🔴 NVDA $215.0P 01/15/27", description "Flow Premium **$6.57M** • Size / OI 1646 / 28074 • ..."
Batch channels re-post a signal in later windows, so identical signals are counted once per channel and day.
Direction (📈/📉, 🟢/🔴) is shown as the relay posted it. Channel ids come from the relay's own webhook store, so
there is one source of truth for which channel is which.
"""
from __future__ import annotations

import json
import re
import time
from collections import Counter
from datetime import date, datetime, time as dtime, timedelta
from pathlib import Path
from zoneinfo import ZoneInfo

import requests

ET = ZoneInfo("America/New_York")
API = "https://discord.com/api/v10"
WEBHOOKS = Path.home() / ".openclaw" / "secrets" / "option_relay_webhooks.json"

# /flow type -> relay webhook key (discord_relay.get_flow_channel routes AlertType to these)
TYPES = {
    "huge": "flow_huge",            # AlertType high_flow
    "unusual": "flow_unusual",      # unusual_high_flow
    "repeated": "flow_repeaters",   # repeat_flow
    "weekly": "flow_weekly",        # weekly_flow
    "etf": "flow_etf",              # *_etf
    "live": "flow_live",            # live tape batches
    "firehose": "flow_alerts",      # every relay alert (duplicates the typed channels)
}
ALL = ("huge", "unusual", "repeated", "weekly", "etf")   # "all" leaves out live + firehose (they repeat these)
MAX_PAGES = 40           # 100 messages a page, per channel
_CHANNEL_IDS: dict[str, str] = {}

_PREM = re.compile(r"\$?\s*([\d,]*\.?\d+)\s*([KMB]?)", re.I)
_BATCH = re.compile(r"(?P<flag>\S*?)(?P<dir>📈|📉)\s*\*\*(?P<sym>[A-Z][A-Z0-9.]*)\*\*\s*`\$(?P<strike>[\d.]+)(?P<cp>[cp])`"
                    r"\s*(?P<exp>\w+)\s*·\s*\$(?P<prem>[\d.,]+[KMB]?)\s*(?P<kind>[A-Z_]+)?\s*(?P<side>ask|bid|mid)?", re.I)
_SINGLE = re.compile(r"(?P<dir>🟢|🔴)\s*(?P<sym>[A-Z][A-Z0-9.]*)\s+\$(?P<strike>[\d.]+)(?P<cp>[CP])\s+(?P<exp>[\d/]+)")
_FIELD = {"prem": re.compile(r"Flow Premium \*\*\$([\d.,]+[KMB]?)\*\*"),
          "size_oi": re.compile(r"Size / OI (\d+) / (\d+)"),
          "sw_bl": re.compile(r"Sweeps / Blocks (\d+) / (\d+)")}


# ─── pure helpers (tested) ────────────────────────────────────────────────────
def parse_premium(text) -> float | None:
    """'$632.5K' / '1.5m' / '250000' / '2B' -> dollars. None if it doesn't parse."""
    if text is None:
        return None
    m = _PREM.fullmatch(str(text).strip().replace(" ", ""))
    if not m:
        return None
    try:
        v = float(m.group(1).replace(",", ""))
    except ValueError:
        return None
    return v * {"": 1, "K": 1e3, "M": 1e6, "B": 1e9}[m.group(2).upper()]


def money(x: float | None) -> str:
    if x is None:
        return "n/a"
    a = abs(x)
    s = f"${a / 1e9:.2f}B" if a >= 1e9 else f"${a / 1e6:.2f}M" if a >= 1e6 else f"${a / 1e3:.0f}K" if a >= 1e3 else f"${a:.0f}"
    return ("-" if x < 0 else "") + s


def _strike(s: str) -> str:
    return f"{float(s):g}"


_FCM_CARD = re.compile(r"^(?P<sym>[A-Z][A-Z0-9.]*) (?P<cp>CALL|PUT) \S+ \$(?P<strike>[\d.]+) exp (?P<exp>[\d/]+)")
_DOT = {"🟢": "green", "🟡": "yellow", "🔴": "red", "⬜": "white"}


def _field(e: dict, name: str) -> str:
    return next((f.get("value") or "" for f in e.get("fields") or [] if f.get("name") == name), "")


def parse_message(msg: dict) -> list[dict]:
    """One Discord message (REST JSON) -> the flow signals on it. `src` names the card shape:
    relay card (option-relay, one FlowGreeks alert), fcm card (fcm-discord, one FlowGreeks alert),
    fcm batch (fcm-discord, FlowGreeks LiveFlows trades; its 📈/📉 is CALL/PUT, its dot is the FlowGreeks COLOR)."""
    ts = datetime.fromisoformat(msg["timestamp"]).astimezone(ET)
    out = []
    for e in msg.get("embeds") or []:
        title, desc = e.get("title") or "", e.get("description") or ""
        m = _SINGLE.search(title)
        if m and _FIELD["prem"].search(desc):
            so, sb = _FIELD["size_oi"].search(desc), _FIELD["sw_bl"].search(desc)
            out.append({"sym": m["sym"], "strike": _strike(m["strike"]), "cp": m["cp"].upper(), "exp": m["exp"],
                        "premium": parse_premium(_FIELD["prem"].search(desc).group(1)),
                        "dir": "bull" if m["dir"] == "🟢" else "bear", "kind": "", "side": "", "color": "",
                        "size": int(so.group(1)) if so else None, "oi": int(so.group(2)) if so else None,
                        "sweeps": int(sb.group(1)) if sb else None, "blocks": int(sb.group(2)) if sb else None,
                        "ts": ts, "src": "relay card", "alert_type": None})
            continue
        f = _FCM_CARD.search(title)
        if f and _field(e, "Total Flow Value"):
            prem = parse_premium(_field(e, "Total Flow Value"))
            sb = re.match(r"(\d+) / (\d+)", _field(e, "Sweeps/Blocks"))
            ov = re.match(r"([\d,]+) / ([\d,]+)", _field(e, "OI / Volume"))
            at = re.search(r"\*\*([A-Z0-9 ]+)\*\*", desc)
            if prem:
                out.append({"sym": f["sym"], "strike": _strike(f["strike"]), "cp": f["cp"][0], "exp": f["exp"],
                            "premium": prem, "dir": "bull" if "BULL" in desc else "bear", "kind": "", "side": "",
                            "color": "", "size": int(ov.group(2).replace(",", "")) if ov else None,
                            "oi": int(ov.group(1).replace(",", "")) if ov else None,
                            "sweeps": int(sb.group(1)) if sb else None, "blocks": int(sb.group(2)) if sb else None,
                            "ts": ts, "src": "fcm card",
                            "alert_type": None if not at or at[1] == "FLOW ALERT" else at[1].lower().replace(" ", "_")})
            continue
        for line in desc.splitlines():
            b = _BATCH.search(line)
            if not b:
                continue
            out.append({"sym": b["sym"], "strike": _strike(b["strike"]), "cp": b["cp"].upper(), "exp": b["exp"],
                        "premium": parse_premium(b["prem"]), "dir": None, "color": _DOT.get(b["flag"], "white"),
                        "kind": (b["kind"] or "").upper(), "side": (b["side"] or "").lower(),
                        "size": None, "oi": None, "sweeps": None, "blocks": None, "ts": ts, "src": "fcm batch",
                        "alert_type": None})
    return out


def parse_cards(msg: dict) -> list[dict]:
    """Only the single-alert cards (FlowGreeks Alerts), with `view` = FlowGreeks' isBullish."""
    return [{**c, "view": c["dir"]} for c in parse_message(msg) if c["src"] != "fcm batch"]


def dedupe(sigs: list[dict]) -> list[dict]:
    """Batch channels re-post the same signal in later 20s windows: keep the first per contract/premium/kind/side/day."""
    seen, out = set(), []
    for s in sorted(sigs, key=lambda s: s["ts"]):
        k = (s["chan"], s["ts"].date(), s["sym"], s["strike"], s["cp"], s["exp"], round(s["premium"] or 0, -2),
             s["kind"], s["side"])
        if k not in seen:
            seen.add(k)
            out.append(s)
    return out


def filt(sigs: list[dict], ticker: str | None = None, lo: float | None = None, hi: float | None = None,
         cp: str | None = None) -> list[dict]:
    t = (ticker or "").upper().strip() or None
    return [s for s in sigs if (t is None or s["sym"] == t) and (cp is None or s["cp"] == cp)
            and (lo is None or (s["premium"] or 0) >= lo) and (hi is None or (s["premium"] or 0) <= hi)]


def start_of_window(days: int, today: date | None = None) -> datetime:
    """Midnight ET of the first session day in the window. days=1 = latest weekday (Fri on a weekend)."""
    d = today or datetime.now(ET).date()
    while d.weekday() >= 5:
        d -= timedelta(days=1)
    left = max(1, days) - 1
    while left:
        d -= timedelta(days=1)
        if d.weekday() < 5:
            left -= 1
    return datetime.combine(d, dtime(0, 0), tzinfo=ET)


def message_text(msg: dict) -> str:
    parts = [msg.get("content") or ""]
    for e in msg.get("embeds") or []:
        parts += [e.get("title") or "", e.get("description") or ""]
        parts += [f"{f.get('name', '')} {f.get('value', '')}" for f in e.get("fields") or []]
    return " ".join(" ".join(p.split()) for p in parts if p).strip()


def mentions(msg: dict, ticker: str) -> str | None:
    """Text of a message in a format the parser doesn't know (news, UW crier, other bots) if it names the ticker."""
    t = message_text(msg)
    if t and re.search(rf"(?<![A-Za-z0-9])\$?{re.escape(ticker.upper())}(?![A-Za-z0-9])", t):
        return re.sub(r"<t:(\d+):\w>", lambda m: datetime.fromtimestamp(int(m[1]), ET).strftime("%H:%M"), t)
    return None


def render(sigs: list[dict], *, label: str, since: datetime, ticker: str | None, lo: float | None, hi: float | None,
           scanned: int, capped: list[str], unparsed: int, top: int = 12, notes: list[tuple] | None = None) -> str:
    band = "" if lo is None and hi is None else f" · premium {money(lo) if lo is not None else '$0'}–{money(hi) if hi is not None else 'any'}"
    head = (f"**{ticker.upper() + ' · ' if ticker else ''}{label} flow** · since {since:%a %m/%d} ET{band} · "
            f"{len(sigs)} signals from {scanned} messages · read from Discord")
    lines = [head]
    if capped:
        lines.append(f"⚠️ stopped at {MAX_PAGES * 100} messages in {', '.join(capped)} — older posts not read; use a shorter window")
    notes = notes or []
    tail = []
    if notes:
        tail.append(f"Other posts naming {ticker.upper()} ({len(notes)}, not flow cards — premium filter not applied):")
        tail += [f"• #{c} {ts:%m/%d %H:%M} ET · {txt[:180]}" for ts, c, txt in sorted(notes, reverse=True)[:8]]
    if not sigs:
        lines.append("No flow signals matched." + (f" ({unparsed} messages were not relay flow cards)" if unparsed else ""))
        return "\n".join(lines + tail)
    calls = [s for s in sigs if s["cp"] == "C"]
    puts = [s for s in sigs if s["cp"] == "P"]
    bull = sum(s["premium"] or 0 for s in sigs if s["dir"] == "bull")
    bear = sum(s["premium"] or 0 for s in sigs if s["dir"] == "bear")
    cards = sum(1 for s in sigs if s["dir"])
    lines.append(f"Calls {money(sum(s['premium'] or 0 for s in calls))} ({len(calls)}) · Puts "
                 f"{money(sum(s['premium'] or 0 for s in puts))} ({len(puts)})"
                 + (f" · FlowGreeks alert view on {cards} cards: 🟢 {money(bull)} vs 🔴 {money(bear)}" if cards else ""))
    src = Counter(s["src"] for s in sigs)
    lines.append("Card types: " + " · ".join(f"{k} {n}" for k, n in src.most_common())
                 + " (relay/fcm card = FlowGreeks Alerts; fcm batch = FlowGreeks LiveFlows trades)")
    by_chan = Counter(s["chan"] for s in sigs)
    lines.append("By channel: " + " · ".join(f"{c} {n}" for c, n in by_chan.most_common()))
    if not ticker:
        prem = Counter()
        for s in sigs:
            prem[s["sym"]] += s["premium"] or 0
        lines.append("Top tickers: " + " · ".join(f"{t} {money(p)}" for t, p in prem.most_common(10)))
    rep = Counter((s["sym"], s["strike"], s["cp"], s["exp"]) for s in sigs)
    multi = [(k, n) for k, n in rep.most_common(5) if n > 1]
    if multi:
        lines.append("Hit more than once: " + " · ".join(f"{k[0]} {k[1]}{k[2]} {k[3]} ×{n}" for k, n in multi))
    lines.append("Biggest:")
    for s in sorted(sigs, key=lambda s: -(s["premium"] or 0))[:top]:
        extra = []
        if s["kind"] or s["side"]:
            extra.append(f"{s['kind']} {s['side']}".strip())
        if s["size"] is not None:
            extra.append(f"size {s['size']:,} / OI {s['oi']:,}")
        if s["sweeps"] is not None:
            extra.append(f"{s['sweeps']} sweeps / {s['blocks']} blocks")
        if s["dir"]:
            extra.insert(0, f"FG {'🟢 bull' if s['dir'] == 'bull' else '🔴 bear'}")
        if s["color"] and s["color"] != "white":
            extra.append(f"FG {s['color']}")
        res = "FG LiveFlows trade" if s["src"] == "fcm batch" else "FG Alerts " + (s.get("alert_type") or "card")
        lines.append(f"• {s['sym']} ${s['strike']}{s['cp']} {s['exp']} · {money(s['premium'])} · "
                     f"{' · '.join(extra) + ' · ' if extra else ''}{s['ts']:%m/%d %H:%M} ET [#{s['chan']} · {res} · {s['src']}]")
    return "\n".join(lines + tail)


# ─── Discord REST (read-only) ─────────────────────────────────────────────────
def channel_id(key: str, session=None) -> str:
    """Relay webhook key -> channel id (a webhook GET returns its channel_id, no auth). Cached per process."""
    if key not in _CHANNEL_IDS:
        url = json.loads(WEBHOOKS.read_text())[key]
        r = (session or requests).get(url, timeout=10)
        r.raise_for_status()
        _CHANNEL_IDS[key] = r.json()["channel_id"]
    return _CHANNEL_IDS[key]


def _snowflake(dt: datetime) -> int:
    return (int(dt.timestamp() * 1000) - 1420070400000) << 22


def fetch(cid: str, since: datetime, token: str, session=None) -> tuple[list[dict], bool, str]:
    """Messages in channel cid newer than since, oldest last. Returns (messages, capped, channel name)."""
    s = session or requests.Session()
    h = {"Authorization": "Bot " + token}
    info = s.get(f"{API}/channels/{cid}", headers=h, timeout=10)
    info.raise_for_status()
    name = info.json().get("name") or cid
    out, before, floor = [], None, _snowflake(since)
    for _ in range(MAX_PAGES):
        params = {"limit": 100, **({"before": before} if before else {})}
        r = s.get(f"{API}/channels/{cid}/messages", headers=h, params=params, timeout=15)
        if r.status_code == 429:
            time.sleep(float(r.json().get("retry_after", 1)) + 0.2)
            continue
        r.raise_for_status()
        page = r.json()
        if not page:
            return out, False, name
        out += [m for m in page if int(m["id"]) > floor]
        if int(page[-1]["id"]) <= floor:
            return out, False, name
        before = page[-1]["id"]
    return out, True, name


def scan(token: str, *, types: list[str] | None = None, channel_ids: list[str] | None = None,
         ticker: str | None = None, lo: float | None = None, hi: float | None = None, days: int = 1,
         cp: str | None = None) -> str:
    """Read the chosen relay channels (and/or any channel ids) and summarise the matching signals."""
    since = start_of_window(max(1, min(days, 5)))
    s = requests.Session()
    targets = [(t, channel_id(TYPES[t], s)) for t in (types or [])] + [(None, c) for c in (channel_ids or [])]
    sigs, scanned, capped, unparsed, names, notes = [], 0, [], 0, [], []
    for typ, cid in targets:
        try:
            msgs, cap, name = fetch(cid, since, token, s)
        except requests.HTTPError as e:
            names.append(f"#{cid} UNAVAILABLE (HTTP {e.response.status_code if e.response is not None else '?'})")
            continue
        names.append(f"#{name}")
        scanned += len(msgs)
        if cap:
            capped.append(f"#{name}")
        for m in msgs:
            got = parse_message(m)
            if not got and (m.get("embeds") or m.get("content")):
                unparsed += 1
                if ticker and typ is None and (txt := mentions(m, ticker)):
                    notes.append((datetime.fromisoformat(m["timestamp"]).astimezone(ET), name, txt))
            for g in got:
                g["chan"] = name
            sigs += got
    sigs = filt(dedupe(sigs), ticker, lo, hi, cp)
    label = "/".join(types) if types and not channel_ids else ", ".join(names)
    out = render(sigs, label=label, since=since, ticker=ticker, lo=lo, hi=hi, scanned=scanned, capped=capped,
                 unparsed=unparsed, notes=notes)
    bad = [n for n in names if "UNAVAILABLE" in n]
    return out + ("\n" + " · ".join(bad) if bad else "")
