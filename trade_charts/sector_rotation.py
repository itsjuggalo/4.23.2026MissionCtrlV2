#!/usr/bin/env python3
"""sector_rotation.py — where money is rotating across the 11 SPDR sectors, for #sector-rotation and /sectors.

Three independent reads, each with its source and as_of, then a rule-based rotation call (no LLM):
  1. Relative strength: sector ETF return minus SPY return over 1, 5 and 20 sessions (Robinhood daily bars,
     Yahoo fallback labelled).
  2. Options flow: net bullish-minus-bearish option premium by sector from flow.db's latest session
     (calls +, puts −; ask-side +, bid-side −), stocks mapped to their sector ETF. A PROXY for money flow.
  3. Dark pool: each sector's off-exchange share of volume vs its 30-day average (FINRA, pipeline/darkpool).
`--weekly` adds the slow money: congressional trades by sector (Signal8) and 13F institutional sector weights
(local f13.sqlite, matched filers, quarter over quarter). That data lags weeks to months: context, not timing.

Advisory only. No proven edge. No size. A missing input prints UNAVAILABLE with the reason.

CLI:  ~/.venv/bin/python sector_rotation.py [--dry] [--weekly] [--channel sector-rotation]
"""
from __future__ import annotations

import warnings

warnings.filterwarnings("ignore")   # yfinance/pandas deprecation noise would flood the cron log

import argparse
import json
import sqlite3
import sys
from datetime import datetime
from pathlib import Path
from zoneinfo import ZoneInfo

HERE = Path(__file__).resolve().parent
sys.path.insert(0, str(HERE))
sys.path.insert(0, str(HERE.parent))
import lib  # noqa: E402,F401 — bind ~/scripts/lib now; MissionCtrl modules put pipeline/ (which has its own lib/) first on sys.path
MC = "/AIWorkWSL/web/missionctrl"
sys.path.append(MC)   # append: must not shadow ~/scripts/lib
ET = ZoneInfo("America/New_York")
CHANNEL = "sector-rotation"
NAMES = {"XLK": "Technology", "XLF": "Financials", "XLV": "Health Care", "XLE": "Energy", "XLI": "Industrials",
         "XLY": "Cons. Discretionary", "XLP": "Cons. Staples", "XLU": "Utilities", "XLB": "Materials",
         "XLRE": "Real Estate", "XLC": "Communications"}
F13_DB = Path.home() / ".openclaw/data/f13/f13.sqlite"


def _m(x: float) -> str:
    return f"{'+' if x >= 0 else '−'}${abs(x) / 1e6:,.1f}M"


# ── 1. relative strength ──────────────────────────────────────────────────────
def perf() -> tuple[dict, str]:
    import ta_cmd
    out, srcs, dates = {}, set(), set()
    for sym in ["SPY", *NAMES]:
        try:
            df, src = ta_cmd.stock_bars(sym, "1d")
        except Exception as e:  # noqa: BLE001
            out[sym] = {"error": str(e)[:80]}
            continue
        c = df["Close"]
        if len(c) < 21:
            out[sym] = {"error": f"only {len(c)} bars"}
            continue
        out[sym] = {"close": float(c.iloc[-1]), **{f"r{n}": (float(c.iloc[-1]) / float(c.iloc[-1 - n]) - 1) * 100
                                                  for n in (1, 5, 20)}}
        srcs.add(src)
        dates.add(f"{df.index[-1]:%Y-%m-%d}")
    spy = out.get("SPY") or {}
    for sym in NAMES:
        if "error" not in out[sym] and "error" not in spy:
            for n in (1, 5, 20):
                out[sym][f"rs{n}"] = out[sym][f"r{n}"] - spy[f"r{n}"]
    return out, f"{' / '.join(sorted(srcs)) or 'UNAVAILABLE'} · last bar {', '.join(sorted(dates)) or 'n/a'}"


# ── 2. options flow by sector ─────────────────────────────────────────────────
def flow() -> tuple[dict, str]:
    from pipeline.darkpool import _common as C
    from pipeline.intel import query as Q
    smap = {**C.symbol_sector_map(), **{s: s for s in NAMES}}
    s, e, day = Q.session_window()
    rows = Q.session_rows(None, s, e)
    agg = {k: {"net": 0.0, "bull": 0.0, "bear": 0.0, "n": 0} for k in NAMES}
    sided = mapped = 0
    last = 0
    for r in rows:
        last = max(last, r["event_time"])
        v = Q.net_premium(r["option_type"], r["bid_ask"], r["premium"])
        if v is None:
            continue
        sided += 1
        sec = smap.get(r["symbol"])
        if sec not in agg:
            continue
        mapped += 1
        a = agg[sec]
        a["net"] += v
        a["bull" if v > 0 else "bear"] += abs(v)
        a["n"] += 1
    as_of = datetime.fromtimestamp(last / 1000, ET).strftime("%m-%d %H:%M ET") if last else "n/a"
    meta = (f"flow.db session {day} · {len(rows):,} prints, {sided:,} with a side, {mapped:,} mapped to a sector "
            f"(index ETFs and non-S&P names are left out) · last print {as_of}")
    return agg, meta


# ── 3. dark pool ──────────────────────────────────────────────────────────────
def darkpool() -> tuple[dict, str]:
    from pipeline.darkpool import _common as C
    d = C.load_latest()
    return d.get("sectors") or {}, f"FINRA off-exchange share, pipeline/darkpool as of {d.get('asOf') or 'n/a'}"


# ── build ─────────────────────────────────────────────────────────────────────
def render(p: dict, f: dict | None, title: str) -> str:
    import chartlib
    import matplotlib.pyplot as plt
    syms = sorted([s for s in NAMES if "rs5" in p.get(s, {})], key=lambda s: p[s]["rs5"])
    fig, axes = plt.subplots(1, 2 if f else 1, figsize=(12, 6), facecolor="#0d1117")
    axes = list(axes) if f else [axes]
    col = lambda v: "#3fb950" if v >= 0 else "#f85149"  # noqa: E731
    labels = [f"{s} {NAMES[s]}" for s in syms]
    ax = axes[0]
    ax.barh(labels, [p[s]["rs5"] for s in syms], color=[col(p[s]["rs5"]) for s in syms])
    ax.set_title("5-session return minus SPY (points)", color="#e6edf3", fontsize=11)
    if f:
        ax = axes[1]
        vals = [f[s]["net"] / 1e6 for s in syms]
        ax.barh(labels, vals, color=[col(v) for v in vals])
        ax.set_title("Net option premium, bullish minus bearish ($M, proxy)", color="#e6edf3", fontsize=11)
        ax.set_yticklabels([])
    for ax in axes:
        ax.set_facecolor("#0d1117")
        ax.axvline(0, color="#6e7681", lw=0.8)
        ax.tick_params(colors="#8b949e", labelsize=9)
        ax.grid(axis="x", color="#21262d", lw=0.6)
        for sp in ax.spines.values():
            sp.set_color("#30363d")
    fig.suptitle(title, color="#e6edf3", fontsize=13)
    fig.tight_layout()
    path = str(chartlib.OUT / "sector_rotation.png")
    fig.savefig(path, dpi=120, facecolor="#0d1117")
    plt.close("all")
    return path


def build(chart: bool = True) -> dict:
    now = datetime.now(ET)
    lines = [f"🔄 **SECTOR ROTATION** · {now:%a %m-%d %H:%M ET}"]
    try:
        p, p_src = perf()
    except Exception as e:  # noqa: BLE001
        p, p_src = {}, f"UNAVAILABLE ({type(e).__name__}: {str(e)[:80]})"
    try:
        f, f_src = flow()
    except Exception as e:  # noqa: BLE001
        f, f_src = None, f"UNAVAILABLE ({type(e).__name__}: {str(e)[:80]})"
    try:
        dp, dp_src = darkpool()
    except Exception as e:  # noqa: BLE001
        dp, dp_src = {}, f"UNAVAILABLE ({type(e).__name__}: {str(e)[:80]})"

    ok = [s for s in NAMES if "rs5" in p.get(s, {})]
    if not ok:
        lines.append(f"Relative strength: UNAVAILABLE ({p_src})")
        return {"ok": False, "text": "\n".join(lines), "png": None}
    ranked = sorted(ok, key=lambda s: -p[s]["rs5"])
    money_in = [s for s in ranked if p[s]["rs5"] > 0 and f and f[s]["net"] > 0]
    money_out = [s for s in ranked[::-1] if p[s]["rs5"] < 0 and f and f[s]["net"] < 0]
    split = [s for s in ranked if f and s not in money_in and s not in money_out and f[s]["n"]]
    lab = lambda xs: ", ".join(f"{s} {NAMES[s]}" for s in xs) or "none"  # noqa: E731
    if f:
        lines += [f"**Money IN** (beating SPY over 5 sessions AND net bullish option premium): {lab(money_in)}",
                  f"**Money OUT** (lagging SPY AND net bearish option premium): {lab(money_out)}",
                  f"Price and flow disagree: {', '.join(split) or 'none'}"]
    else:
        lines.append(f"Leaders vs SPY (5 sessions): {lab(ranked[:3])} · Laggards: {lab(ranked[-3:][::-1])}")
        lines.append(f"Options flow by sector: {f_src}")
    spy = p.get("SPY", {})
    if "r5" in spy:
        lines.append(f"SPY: 1d {spy['r1']:+.2f}% · 5d {spy['r5']:+.2f}% · 20d {spy['r20']:+.2f}%")
    lines.append("```")
    lines.append(f"{'ETF':<5}{'1d':>7}{'5d':>7}{'20d':>7}{'5d-SPY':>8}{'netFlow':>11}{'DP':>7}{'vs30d':>7}")
    for s in ranked:
        x = p[s]
        fl = _m(f[s]["net"]) if f and f[s]["n"] else "n/a"
        d = dp.get(s) or {}
        dps = f"{d['dpShare'] * 100:.1f}%" if d.get("dpShare") is not None else "n/a"
        dv = f"{d['vs30d'] * 100:+.1f}" if d.get("vs30d") is not None else "n/a"
        lines.append(f"{s:<5}{x['r1']:>+7.2f}{x['r5']:>+7.2f}{x['r20']:>+7.2f}{x['rs5']:>+8.2f}{fl:>11}{dps:>7}{dv:>7}")
    lines.append("```")
    lines += [f"_Prices: {p_src}._", f"_Flow: {f_src}. A proxy: premium shows positioning, not shares bought._",
              f"_DP = {dp_src}; vs30d in points. Rule-based, no AI. Advisory only, no proven edge, no size._"]
    text = "\n".join(lines)
    png = None
    if chart:
        try:
            png = render(p, f, f"Sector rotation · {now:%m-%d %H:%M ET}")
        except Exception as e:  # noqa: BLE001
            text += f"\n_Chart render failed ({type(e).__name__})._"
    return {"ok": True, "text": text[:1990], "png": png}


# ── weekly slow money ─────────────────────────────────────────────────────────
def f13_sector_shift() -> list[str]:
    from pipeline.darkpool import _common as C
    smap = C.symbol_sector_map()
    con = sqlite3.connect(f"file:{F13_DB}?mode=ro", uri=True, timeout=30)
    try:
        per = [r[0] for r in con.execute("SELECT period FROM filings WHERE status='parsed' GROUP BY period "
                                         "HAVING count(DISTINCT cik) >= 500 ORDER BY period DESC LIMIT 2")]
        if len(per) < 2:
            return ["13F institutions: UNAVAILABLE (fewer than two quarters with 500+ filers in f13.sqlite)"]
        new, old = per
        both = ("SELECT cik FROM filings WHERE status='parsed' AND period=? "
                "INTERSECT SELECT cik FROM filings WHERE status='parsed' AND period=?")
        n = con.execute(f"SELECT count(*) FROM ({both})", (new, old)).fetchone()[0]
        filed = con.execute("SELECT max(filed_date) FROM filings WHERE status='parsed' AND period=?", (new,)).fetchone()[0]
        tot: dict[str, dict[str, float]] = {new: {}, old: {}}
        for q in (new, old):
            sql = ("SELECT m.ticker, sum(h.value_usd) FROM holdings h JOIN filings f ON f.accession=h.accession "
                   "JOIN cusip_map m ON m.cusip=h.cusip WHERE f.status='parsed' AND f.period=? "
                   f"AND f.cik IN ({both}) AND (h.put_call IS NULL OR h.put_call='') AND m.ticker IS NOT NULL "
                   "GROUP BY m.ticker")
            for tk, v in con.execute(sql, (q, new, old)):
                sec = smap.get(tk)
                if sec:
                    tot[q][sec] = tot[q].get(sec, 0.0) + (v or 0.0)
    finally:
        con.close()
    sn, so = sum(tot[new].values()), sum(tot[old].values())
    if not sn or not so:
        return ["13F institutions: UNAVAILABLE (no S&P 500 holdings matched for the two quarters)"]
    ch = sorted(((tot[new].get(s, 0) / sn - tot[old].get(s, 0) / so) * 100, s) for s in NAMES)
    up = " · ".join(f"{s} {d:+.2f}" for d, s in ch[::-1][:4])
    dn = " · ".join(f"{s} {d:+.2f}" for d, s in ch[:4])
    return [f"**13F institutions** — {n:,} filers that reported both {old} and {new} (latest filing {filed}):",
            f"Sector weight gained (points of S&P 500 stock holdings): {up}",
            f"Sector weight lost: {dn}",
            f"_Local f13.sqlite (SEC 13F). {new} filings are still arriving until about 45 days after quarter end. "
            "A weight change mixes price moves with buying and selling; it is not pure flow._"]


def congress_sector() -> list[str]:
    try:
        from pipeline.cc_verify import signal8_client as s8
        r = s8.call_tool("get_political_sector_rotation", {})
    except Exception as e:  # noqa: BLE001
        return [f"**Congress by sector**: UNAVAILABLE (Signal8 client: {type(e).__name__})"]
    if r.status != "ok" or not r.data:
        return [f"**Congress by sector**: UNAVAILABLE (Signal8 {r.status}: {str(r.error)[:120]})"]
    return ["**Congress by sector** (Signal8, STOCK Act disclosures; filed up to 45 days after the trade):",
            "```", json.dumps(r.data, indent=1)[:1100], "```"]


def weekly() -> str:
    lines = [f"🏛️ **SECTOR ROTATION — slow money (weekly)** · {datetime.now(ET):%a %m-%d %H:%M ET}",
             "_Lags weeks to months. Context for the daily read above, not a timing signal._"]
    for fn in (f13_sector_shift, congress_sector):
        try:
            lines += fn()
        except Exception as e:  # noqa: BLE001
            lines.append(f"{fn.__name__}: UNAVAILABLE ({type(e).__name__}: {str(e)[:100]})")
    lines.append("_Advisory only, no proven edge, no size._")
    return "\n".join(lines)[:1990]


def main() -> int:
    ap = argparse.ArgumentParser()
    ap.add_argument("--dry", action="store_true")
    ap.add_argument("--weekly", action="store_true")
    ap.add_argument("--channel", default=CHANNEL)
    a = ap.parse_args()
    if a.weekly:
        text = weekly()
        if a.dry:
            print(text)
            return 0
        from deliver import GUILD, SYNTH_TOKEN, oc
        cid = oc.resolve_channel(GUILD, SYNTH_TOKEN, a.channel)
        ok = bool(cid and oc.post_text_bot(cid, SYNTH_TOKEN, text))
        print(f"{datetime.now(ET):%F %T ET} weekly posted={ok} channel={a.channel}")
        return 0 if ok else 1
    r = build()
    if a.dry:
        print(r["text"], "\npng:", r["png"], "| chars:", len(r["text"]))
        return 0 if r["ok"] else 1
    from deliver import GUILD, SYNTH_TOKEN, oc, post_chart
    if r["png"]:
        ok, _ = post_chart(a.channel, r["png"], r["text"], tg=False)
    else:
        cid = oc.resolve_channel(GUILD, SYNTH_TOKEN, a.channel)
        ok = bool(cid and oc.post_text_bot(cid, SYNTH_TOKEN, r["text"]))
    print(f"{datetime.now(ET):%F %T ET} posted={ok} ok={r['ok']} channel={a.channel}")
    return 0 if ok and r["ok"] else 1


if __name__ == "__main__":
    sys.exit(main())
