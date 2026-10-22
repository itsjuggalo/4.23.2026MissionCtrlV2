#!/usr/bin/env python3
"""Daily Claude-vs-Codex debates on Discord (Mike 2026-10-20). Advisory only — Mike decides and places every order.

  debate_daily.py --topic portfolio   # 16:45 ET → #agent-debate. Live RH + Coinbase holdings, read-only, in memory only
  debate_daily.py --topic hot         # 16:50 ET → #hot-contract-picks. Today's hottest flow names, deep-dived
  add --dry-run to print instead of posting.

Facts are built by Python from the connected sources (quote.v1, the intel query layer: flow.db, CBOE chains/GEX,
FINRA dark pool, UW crier, Firebase, scraper streams) with source + as_of on every line. The models only interpret.
Two rounds: each side writes its read, then answers the other. Each side's prompt is capped at MAX_FACTS chars.
Claude runs on the Claude plan (LLM_ROUTE=claude), Codex on the ChatGPT plan (llm-route → codex, circuit breaker).
If a side fails, its slot is posted as "skipped" with the reason — the other side still posts.
No stops, targets, sizes or caps (DECISIONS R5). Portfolio holdings are never written to disk (global rule).
"""
from __future__ import annotations

import argparse, concurrent.futures as cf, json, os, subprocess, sys, time, urllib.error, urllib.request
from datetime import date, datetime
from pathlib import Path
from zoneinfo import ZoneInfo

sys.path.insert(0, str(Path(__file__).resolve().parent / "lib"))
ET = ZoneInfo("America/New_York")
SEC = Path.home() / ".openclaw/secrets"
MC = "/AIWorkWSL/web/missionctrl"
PY = str(Path.home() / ".venv/bin/python")
LLM_ROUTE = str(Path.home() / "bin/llm-route")
LOG_DIR = Path.home() / ".openclaw/data/debates"
MAX_FACTS = 9000
CHANNELS = {"portfolio": "1498788205544214619", "hot": None}  # hot: resolved by name below
HOT_NAME = "hot-contract-picks"
INDEX_ETFS = {"SPY", "QQQ", "IWM", "DIA", "SPX", "XSP", "VIX", "TLT", "GLD", "SLV", "SMH", "SOXL", "TQQQ", "SQQQ"}

RULES = """You are {who}, one side of a daily debate with {other}. Mike (a retail trader) reads it on Discord.
Rules:
- Advisory only. Mike makes every decision and places every order himself in Robinhood (stocks/options) or Coinbase (crypto).
- Use ONLY the facts below. Every number you cite must appear in them, with its source/as-of. Never invent a price, level or date.
- No stop-loss, no price target, no position size, no risk cap (Mike's rule R5). Talk about what the evidence says, momentum, catalysts, what would change the read.
- If an input is missing or stale, say so plainly; do not fill it in.
- Give both sides: the bull case and the bear case. Executable vehicles only (no naked shorts — puts or inverse ETFs).
- Plain English, short bullets, max {limit} characters. No preamble.
"""


def now_et() -> datetime:
    return datetime.now(ET)


def run(cmd: list[str], timeout=120, env=None, inp: str | None = None) -> tuple[int, str]:
    try:
        p = subprocess.run(cmd, cwd=MC, capture_output=True, text=True, timeout=timeout, env=env, input=inp)
        return p.returncode, (p.stdout or "") + ("" if p.returncode == 0 else (p.stderr or "")[-400:])
    except subprocess.TimeoutExpired:
        return 124, f"timed out after {timeout}s"


def intel(*args: str, limit=1400) -> str:
    rc, out = run([PY, "-m", "pipeline.intel.query", *args], timeout=150)
    out = out.strip()
    return (out[:limit] + " …") if len(out) > limit else (out or f"intel {' '.join(args)}: no output (rc {rc})")


# ---------- facts ----------
def _crypto_trend(asset: str) -> str:
    """Momentum from Coinbase Exchange daily candles (public): 1d / 7d / 30d % change + where price sits in the 30d range."""
    try:
        req = urllib.request.Request(f"https://api.exchange.coinbase.com/products/{asset}-USD/candles?granularity=86400",
                                     headers={"User-Agent": "mc-debate/1.0"})
        with urllib.request.urlopen(req, timeout=10) as r:
            c = json.load(r)  # [time, low, high, open, close, volume], newest first
        if len(c) < 31:
            return " · trend UNAVAILABLE (short Coinbase history)"
        close = [x[4] for x in c]
        pct = lambda n: (close[0] / close[n] - 1) * 100
        lo, hi = min(x[1] for x in c[:30]), max(x[2] for x in c[:30])
        pos = (close[0] - lo) / (hi - lo) * 100 if hi > lo else 50
        day = datetime.fromtimestamp(c[0][0], ET).strftime("%m-%d")
        return f" · 1d {pct(1):+.1f}% · 7d {pct(7):+.1f}% · 30d {pct(30):+.1f}% · at {pos:.0f}% of 30d range (Coinbase daily candles, latest {day})"
    except Exception as e:
        return f" · trend UNAVAILABLE (Coinbase candles: {type(e).__name__})"


def portfolio_facts() -> str:
    from live_holdings import gather
    h = gather()
    L = [f"PORTFOLIO FACTS · read live {h['as_of_et']} ET · Robinhood + Coinbase, read-only"]
    tot = 0.0
    if h["stocks"]:
        L.append("Stocks (Robinhood):")
        for s in h["stocks"]:
            val = s["qty"] * s["price"] if s["price"] is not None else None
            tot += val or 0
            pl = f"{(s['price'] / s['avg_cost'] - 1) * 100:+.1f}% vs avg cost" if s["price"] and s["avg_cost"] else "P/L n/a"
            L.append(f"- {s['symbol']} {s['qty']:g} sh · avg {s['avg_cost']:.2f} · price {s['price'] if s['price'] is not None else 'UNAVAILABLE'}"
                     f" ({s['source']}, as of {s['as_of']}) · {pl}")
    if h["options"]:
        L.append("Options (Robinhood):")
        for o in h["options"]:
            dte = (date.fromisoformat(o["expiry"]) - now_et().date()).days
            val = o["mark"] * 100 * o["contracts"] if o["mark"] is not None else None
            tot += val or 0
            pl = f"{(o['mark'] / o['avg_price'] - 1) * 100:+.1f}% vs avg" if o["mark"] and o["avg_price"] else "P/L n/a"
            L.append(f"- {o['side']} {o['contracts']:g}x {o['underlying']} {o['strike']:g}{o['type'][0].upper()} {o['expiry']} ({dte} DTE)"
                     f" · avg {o['avg_price']:.2f} · mark {o['mark'] if o['mark'] is not None else 'UNAVAILABLE'} ({o['mark_source']}, {o['mark_as_of']}) · {pl}")
    if h["crypto"]:
        agg: dict = {}
        for c in h["crypto"]:
            a = agg.setdefault(c["asset"], {"qty": 0.0, "venues": set(), "price": c["price"], "source": c["source"], "as_of": c["as_of"],
                                            "chg": c.get("change_pct"), "basis": c.get("change_basis")})
            a["qty"] += c["qty"]; a["venues"].add(c["venue"])
        rows = sorted(agg.items(), key=lambda kv: -(kv[1]["qty"] * (kv[1]["price"] or 0)))
        L.append("Crypto (Robinhood + Coinbase), by value:")
        small = 0.0
        for asset, a in rows:
            val = a["qty"] * a["price"] if a["price"] is not None else None
            tot += val or 0
            if val is not None and val < 5:
                small += val
                continue
            chg = _crypto_trend(asset)
            L.append(f"- {asset} {a['qty']:.6g} · ${val:,.2f} @ {a['price']} ({a['source']}, {a['as_of']}){chg} · {'/'.join(sorted(a['venues']))}"
                     if val is not None else f"- {asset} {a['qty']:.6g} · price UNAVAILABLE")
        if small:
            L.append(f"- dust under $5 each: ${small:,.2f} total")
    L.append(f"Total marked value of positions above: ${tot:,.2f} (cash not included)")
    if h["missing"]:
        L.append("MISSING: " + "; ".join(h["missing"]))
    unders = list(dict.fromkeys([s["symbol"] for s in h["stocks"]] + [o["underlying"] for o in h["options"]]))[:4]
    for u in unders:
        L.append("")
        L.append(intel("intel", u, limit=1500))
    return "\n".join(L)[:MAX_FACTS]


_CONTRACT_LINE = r"\*\*([A-Z][A-Z.]{0,5}) (\d\d)/(\d\d)/(\d\d) (\d+(?:\.\d+)?)([CP])\*\*"   # "**NVDA 10/30/26 220C**"
FLOW_DB = Path.home() / "02_DATA/flow-data/flow.db"


def _first_print(occ: dict) -> tuple[float, float | None] | None:
    """(epoch s, fill price) of the contract's FIRST print in flow.db (deduped view, read-only); None if absent."""
    import sqlite3
    try:
        con = sqlite3.connect(f"file:{FLOW_DB}?mode=ro", uri=True, timeout=5)
        row = con.execute("SELECT event_time, price FROM flow_events_dedup WHERE symbol=? AND expiry=? AND strike=? "
                          "AND upper(substr(option_type,1,1))=? ORDER BY event_time LIMIT 1",
                          (occ["symbol"], occ["expiry"], occ["strike"], occ["kind"][0].upper())).fetchone()
        con.close()
    except Exception:  # noqa: BLE001 — store unreadable = no anchor (said so in the line)
        return None
    return (row[0] / 1000, row[1]) if row else None


def contract_moves(text: str, top: int = 6) -> list[str]:
    """Mike 2026-10-21: for each contract named in the contracts lists (top ~6), how far the CONTRACT moved since
    its first flow print, from Robinhood's own option bars. Anchor = the 5-minute bar holding the first print
    (within the last week) or that day's daily close; latest = the newest RH bar. Missing → said, never guessed."""
    sys.path.insert(0, str(Path(__file__).resolve().parent))
    from lib.rh_quote import rh_option_bars, parse_occ
    seen, out = [], []
    import re
    for m in re.finditer(_CONTRACT_LINE, text):
        sym, mm, dd, yy, k, cp = m.groups()
        occ = f"{sym}{yy}{mm}{dd}{cp}{round(float(k) * 1000):08d}"
        if occ not in seen and sum(o.startswith(sym) and o[len(sym)].isdigit() for o in seen) < 2:   # ≤2 per name
            seen.append(occ)
    fmt = lambda t: datetime.fromtimestamp(t, ET).strftime("%m/%d %H:%M ET")  # noqa: E731
    for occ in seen[:top]:
        c = parse_occ(occ)
        label = f"{c['symbol']} {c['expiry'][5:7]}/{c['expiry'][8:10]}/{c['expiry'][2:4]} {c['strike']:g}{occ[len(c['symbol']) + 6]}" if c else occ
        fp = _first_print(c) if c else None
        if not fp:
            out.append(f"- {label}: no first flow print in flow.db — move since first print UNAVAILABLE")
            continue
        t0, fill = fp
        five = rh_option_bars(occ, "5minute", "week")
        anchor = next((b for b in five["bars"] if b["t"] <= t0 < b["t"] + 300), None)
        if anchor:
            ref, how = anchor["o"], f"open of the 5-min bar at {fmt(anchor['t'])}"
        else:
            day = rh_option_bars(occ, "day", "year")
            d0 = datetime.fromtimestamp(t0, ET).date().isoformat()
            bar = next((b for b in day["bars"] if datetime.fromtimestamp(b["t"], ZoneInfo("UTC")).date().isoformat() == d0), None)
            if not bar:
                out.append(f"- {label}: first print {fmt(t0)}; no Robinhood bar for that time "
                           f"({five['error'] or day['error'] or 'no traded bar'}) — move UNAVAILABLE")
                continue
            ref, how = bar["c"], f"close of {d0[5:]} (first-print day)"
        latest_src = five if five["bars"] else rh_option_bars(occ, "day", "year")
        if not latest_src["bars"] or not ref:
            out.append(f"- {label}: no latest Robinhood bar ({latest_src['error']}) — move UNAVAILABLE")
            continue
        last = latest_src["bars"][-1]["c"]
        pct = (last - ref) / ref * 100
        fill_txt = f"; first print fill ${fill:g} (flow.db)" if fill else ""
        out.append(f"- {label}: {pct:+.1f}% since first flow print {fmt(t0)} (RH bars: {ref:g} {how} → {last:g}, "
                   f"as of {latest_src['as_of_et']}{fill_txt})")
    return out


def hot_facts() -> tuple[str, list[str]]:
    hot = intel("hot", limit=1500)
    names = []
    for line in hot.splitlines():
        if line.startswith("• "):
            t = line[2:].split()[0]
            if t not in INDEX_ETFS:
                names.append(t)
    names = names[:3]
    L = [f"HOT CONTRACTS FACTS · built {now_et():%a %m-%d %H:%M} ET", hot]
    contract_text = []
    for t in names:
        c = intel("contracts", t, "--days", os.environ.get("DEBATE_DAYS", "1"), limit=1200)
        contract_text.append(c)
        L += ["", c, intel("intel", t, limit=1500)]
    try:
        moves = contract_moves("\n".join(contract_text))
    except Exception as e:  # noqa: BLE001 — the debate still runs; the gap is stated, never filled
        moves = [f"- contract moves UNAVAILABLE ({type(e).__name__}: {str(e)[:80]})"]
    if moves:
        # first in the facts so the 9K trim never cuts it
        L[1:1] = ["", "**Contract moves since first flow print** (Robinhood option bars; anchor = 5-min bar of the first print, "
                       "else that day's close):", *moves]
    return "\n".join(L)[:MAX_FACTS], names


# ---------- models ----------
def ask(side: str, prompt: str) -> tuple[bool, str]:
    env = dict(os.environ)
    if side == "Claude":
        env["LLM_ROUTE"] = "claude"
    else:
        env.pop("LLM_ROUTE", None)
    rc, out = run([LLM_ROUTE, "-p", "--model", "sonnet", "--tools", ""], timeout=420, env=env, inp=prompt)
    out = out.strip()
    if rc != 0 or not out:
        reason = out.splitlines()[-1][:160] if out else f"exit {rc}"
        return False, f"_{side} side skipped — {reason}_"
    return True, out[:1500]


def debate(facts: str, task: str) -> dict:
    p1 = {s: RULES.format(who=s, other=o, limit=1100) + f"\nTask: {task}\n\nFACTS\n{facts}"
          for s, o in (("Claude", "Codex"), ("Codex", "Claude"))}
    with cf.ThreadPoolExecutor(2) as ex:
        r1 = dict(zip(p1, ex.map(lambda s: ask(s, p1[s]), p1)))
    r2 = {}
    if all(ok for ok, _ in r1.values()):
        p2 = {s: RULES.format(who=s, other=o, limit=700)
              + f"\nRound 2. {o} wrote the read below. Say where you agree, where you disagree and why (cite the facts), "
                f"and what single fact would settle it.\n\n{o.upper()} ROUND 1\n{r1[o][1]}\n\nFACTS\n{facts}"
              for s, o in (("Claude", "Codex"), ("Codex", "Claude"))}
        with cf.ThreadPoolExecutor(2) as ex:
            r2 = dict(zip(p2, ex.map(lambda s: ask(s, p2[s]), p2)))
    return {"r1": r1, "r2": r2}


# ---------- discord ----------
def _bot(method, path, body=None):
    tok = (SEC / "discord_synthcontrol_token").read_text().strip()
    for _ in range(5):
        req = urllib.request.Request("https://discord.com/api/v10" + path, method=method,
                                     data=None if body is None else json.dumps(body).encode(),
                                     headers={"Authorization": "Bot " + tok, "Content-Type": "application/json",
                                              "User-Agent": "DiscordBot (mc-debate, 1.0)"})
        try:
            with urllib.request.urlopen(req, timeout=20) as r:
                raw = r.read()
                return json.loads(raw) if raw else None
        except urllib.error.HTTPError as e:
            if e.code == 429:
                time.sleep(float(json.loads(e.read() or b"{}").get("retry_after", 1)) + 0.3)
                continue
            raise RuntimeError(f"Discord {method} -> HTTP {e.code}") from None


def hot_channel_id() -> str:
    guild = (SEC / "discord_guild_id").read_text().strip()
    chans = _bot("GET", f"/guilds/{guild}/channels")
    for c in chans:
        if c["name"] == HOT_NAME and c["type"] == 0:
            return c["id"]
    parent = next((c["id"] for c in chans if c["type"] == 4 and "OPTIONS FLOW" in c["name"]), None)
    c = _bot("POST", f"/guilds/{guild}/channels", {"name": HOT_NAME, "type": 0, "parent_id": parent,
                                                   "topic": "Daily 16:50 ET Claude-vs-Codex debate on the day's hottest contracts. Advisory only."})
    return c["id"]


def post(channel: str, chunks: list[str], dry: bool):
    for ch in chunks:
        for i in range(0, len(ch), 1950):
            part = ch[i:i + 1950]
            if dry:
                print(part + "\n-----")
            else:
                _bot("POST", f"/channels/{channel}/messages", {"content": part, "allowed_mentions": {"parse": []}})
                time.sleep(0.6)


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("--topic", choices=["portfolio", "hot"], required=True)
    ap.add_argument("--dry-run", action="store_true")
    a = ap.parse_args()
    t0 = time.time()
    stamp = now_et().strftime("%a %m-%d %H:%M ET")
    if a.topic == "portfolio":
        facts = portfolio_facts()
        task = ("Review Mike's current holdings. For each position: what the evidence says now (momentum, flow, catalysts, "
                "time decay for options) and whether the original thesis still holds. Flag the weakest and strongest position.")
        title = f"⚔️ **Claude vs Codex — portfolio debate** · {stamp}\n_Holdings read live (read-only) from Robinhood + Coinbase. Advisory only — you decide._"
        channel = CHANNELS["portfolio"]
        names = []
    else:
        facts, names = hot_facts()
        task = ("From today's hottest flow names, pick the 1–3 most interesting specific contracts (from the contracts lists) "
                "and argue whether the flow is conviction or hedging/noise. Name the contract exactly as listed.")
        title = (f"🔥 **Claude vs Codex — hot contract picks** · {stamp}\n_Names: {', '.join(names) or 'none today'} · "
                 f"facts from flow.db, CBOE, FINRA, UW crier, Firebase, scraper streams. Advisory only — you decide._")
        channel = None if a.dry_run else hot_channel_id()
    res = debate(facts, task)
    r1, r2 = res["r1"], res["r2"]
    chunks = [title, f"🟠 **Claude — read**\n{r1['Claude'][1]}", f"🟢 **Codex — read**\n{r1['Codex'][1]}"]
    if r2:
        chunks += [f"🟠 **Claude — answers Codex**\n{r2['Claude'][1]}", f"🟢 **Codex — answers Claude**\n{r2['Codex'][1]}"]
    else:
        chunks.append("_Round 2 skipped: one side did not answer round 1._")
    chunks.append(f"_Facts {len(facts):,} chars per side · {time.time() - t0:.0f}s · no stops/targets/sizes by rule (R5)._")
    post(channel, chunks, a.dry_run)
    LOG_DIR.mkdir(parents=True, exist_ok=True)
    meta = {"topic": a.topic, "at_et": now_et().isoformat(timespec="seconds"), "facts_chars": len(facts),
            "ok": {s: r1[s][0] for s in r1}, "round2": bool(r2), "names": names, "dry_run": a.dry_run}
    if a.topic == "hot":  # no holdings in this one — keep the transcript for grading
        meta["transcript"] = chunks
    (LOG_DIR / f"{now_et():%Y-%m-%d}-{a.topic}{'-dry' if a.dry_run else ''}.json").write_text(json.dumps(meta, indent=1, ensure_ascii=False))
    if not any(ok for ok, _ in r1.values()):
        sys.exit("both sides failed")


if __name__ == "__main__":
    main()
