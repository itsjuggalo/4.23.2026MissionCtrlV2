"""lib/flow_report (the /flow evidence report) + trade_charts/flow_oi_followup. Fixed inputs, no network, no sends."""
import sys
from datetime import date, datetime
from pathlib import Path

from lib import flow_report as R
from lib import flowgreeks as F

sys.path.insert(0, str(Path(__file__).resolve().parents[1] / "trade_charts"))
import flow_oi_followup as FU  # noqa: E402

ET = R.ET
T0 = datetime(2026, 11, 10, 11, 2, 32, tzinfo=ET).timestamp()
SESSION = date(2026, 11, 10)


def _p(src="flow.db", t=T0, prem=8_218_479.0, vol=3055, side="A", cp="C", strike=175.0, exp="2027-06-17", oi=7530,
       kind="SWEEP", copies=1):
    return {"sym": "NVDA", "cp": cp, "strike": strike, "exp": exp, "t": t, "premium": prem, "volume": vol, "oi": oi,
            "side": side, "kind": kind, "src": {src}, "copies": copies}


def _alert(t=T0 + 40, prem=8_218_479.0, vol=3055, trades=1, view="bull", typ="high_flow"):
    return {"sym": "NVDA", "cp": "C", "strike": 175.0, "exp": "2027-06-17", "t": t, "premium": prem, "volume": vol,
            "oi": 7530, "view": view, "type": typ, "trades": trades}


def _c(cp="C", ask=0.0, bid=0.0, **kw):
    c = {"sym": "NVDA", "cp": cp, "strike": 175.0, "exp": "2027-06-17", "premium": ask + bid, "ask": ask, "bid": bid,
         "noside": 0.0, "prints": 1, "sweeps": 0, "blocks": 0, "volume": 100, "vol_known": True, "oi": 1000,
         "first": T0, "last": T0, "views": R.Counter(), "types": R.Counter()}
    c.update(kw)
    return c


CTX = {"session": SESSION, "norm": {"mult": 2.0, "median": 1e8, "n": 20}, "move": {"pct": 1.5}, "oi": {}}


# ─── dedup ────────────────────────────────────────────────────────────────────
def test_dedup_removes_feed_and_alert_twins_keeps_separate_prints():
    raw = [_p("flow.db"), _p("FG LiveFlows", t=T0 + 0.4),                       # one print, two feeds
           _p("flow.db", t=T0 + 1, prem=128_000.0, vol=50, side="B"),          # different size/side: separate
           _p("flow.db", t=T0 + 2, prem=128_000.0, vol=50, side="B")]          # same feed again: a real repeat
    prints, removed = R.dedup(raw)
    assert len(prints) == 3 and removed == 1
    assert prints[0]["src"] == {"flow.db", "FG LiveFlows"}
    summaries, merged = R.attach_alerts(prints, [_alert(), _alert(trades=9, prem=9_630_000.0, vol=3581,
                                                                    view="bear", typ="repeat_flow")])
    assert merged == 1 and len(prints) == 3                                    # the single-trade alert is that print
    assert "FG Alerts" in prints[0]["src"] and len(summaries) == 1             # the 9-trade alert is only a summary
    agg = R.aggregate(prints, summaries)
    big = next(c for c in agg if c["strike"] == 175.0)
    assert big["premium"] == 8_218_479.0 + 2 * 128_000.0                       # alerts never add premium
    assert big["views"]["bull"] == 1 and big["views"]["bear"] == 1


def test_dedup_window_and_same_feed_copies():
    prints, removed = R.dedup([_p("flow.db"), _p("FG LiveFlows", t=T0 + 30, copies=3)])
    assert len(prints) == 2 and removed == 2                                   # 30 s apart: not a twin; 2 copies collapsed


def test_fold_legs_counts_a_sweep_once_and_keeps_blocks_that_do_not_fit():
    live = "FG LiveFlows"
    sweep = _p(live, T0 + 0.47, 8_218_479.0, 3055)
    legs = [_p(live, T0 + 0.47, 145_259.0, 54, kind="BLOCK"), _p(live, T0 + 0.53, 1_186_289.0, 441, kind="BLOCK")]
    other_price = _p(live, T0 + 0.5, 300_000.0, 100, kind="BLOCK")            # $30.00 vs the sweep's $26.90
    other_side = _p(live, T0 + 0.5, 269_000.0, 100, side="B", kind="BLOCK")
    later = _p(live, T0 + 5, 269_000.0, 100, kind="BLOCK")                    # same price, 5 s later
    too_big = _p(live, T0 + 0.5, 10_760_000.0, 4000, kind="BLOCK")            # more contracts than the sweep
    prints, _ = R.dedup([sweep, *legs, other_price, other_side, later, too_big])
    out, n, prem = R.fold_legs(prints)
    assert n == 2 and round(prem) == 145_259 + 1_186_289
    assert len(out) == 5 and sum(1 for p in out if p["kind"] == "BLOCK") == 4
    c = R.aggregate([p for p in out if p["side"] == "A" and p["t"] < T0 + 1 and p["volume"] in (3055,)])[0]
    assert c["premium"] == 8_218_479.0 and c["prints"] == 1
    # blocks with no sweep are untouched
    assert R.fold_legs(R.dedup([_p(live, T0, 269_000.0, 100, kind="BLOCK")])[0])[1] == 0


def test_flowgreeks_merges_alert_live_twin_into_one_line():
    ts = datetime.fromtimestamp(T0, ET)
    live = {"sym": "NVDA", "strike": "175", "cp": "C", "exp": "06/17/27", "premium": 8_218_479.0, "ts": ts,
            "cat": "Huge", "etf": False, "chan": "#flow-huge", "resource": "FG LiveFlows white", "view": "", "side": "ask",
            "color": "white", "size": 3055, "oi": 7530, "sweeps": None, "blocks": None, "kind": "SWEEP"}
    alert = {**live, "ts": datetime.fromtimestamp(T0 + 40, ET), "resource": "FG Alerts high_flow", "view": "bull",
             "side": "", "kind": "", "sweeps": 1, "blocks": 0, "trades": 1}
    other = {**alert, "view": "bear", "trades": 9, "premium": 9_630_000.0, "size": 3581, "resource": "FG Alerts repeat_flow",
             "chan": "#flow-repeaters", "cat": "Repeated"}
    sigs, merged = F.merge_twins([alert, live, other])
    assert merged == 1 and len(sigs) == 2
    F.mark_mixed(sigs)
    ln = F.line(next(s for s in sigs if "LiveFlows" in s["resource"]))
    assert "FG LiveFlows white + FG Alerts high_flow → #flow-huge" in ln and "mixed 1🟢/1🔴" in ln
    assert "alert total of 9 prints" in F.line(next(s for s in sigs if s.get("trades") == 9))


# ─── direction rule ───────────────────────────────────────────────────────────
def test_direction_four_cases_and_unclear():
    assert R.direction(_c("C", ask=90, bid=10))[0] == "bull"     # calls bought at the ask
    assert R.direction(_c("P", ask=10, bid=90))[0] == "bull"     # puts sold at the bid
    assert R.direction(_c("P", ask=90, bid=10))[0] == "bear"     # puts bought at the ask
    assert R.direction(_c("C", ask=10, bid=90))[0] == "bear"     # calls sold at the bid
    assert R.direction(_c("C", ask=55, bid=45))[0] == "unclear"  # closer than 60/40
    assert R.direction(_c("C", ask=60, bid=40))[0] == "bull"     # exactly 60/40 is one-way
    assert R.direction(_c("C", ask=0, bid=0, noside=100)) == ("unclear", None)


# ─── evidence ─────────────────────────────────────────────────────────────────
def test_evidence_order_and_0dte_counts_against():
    strong = _c("C", ask=900, bid=100, prints=5, volume=5000, oi=1000)                      # one-way, vol>OI, repeat
    weak = _c("C", ask=90, bid=10, prints=1, volume=10, oi=1000, strike=200.0)             # one-way only, smaller
    zero = _c("C", ask=900, bid=100, prints=5, volume=5000, oi=1000, strike=180.0, exp="2026-11-10")
    g = R.rank([weak, zero, strong], CTX)["bull"]
    assert [c["strike"] for c, _, _ in g] == [175.0, 180.0, 200.0]
    counts = {c["strike"]: n for c, _, n in g}
    assert counts[175.0] == 6 and counts[180.0] == 4 and counts[200.0] == 4      # 0DTE: one ✅ fewer AND one ⛔; tie → bigger premium first
    assert ("expiry", R.AGAINST, "0DTE/expired") in R.evidence(zero, CTX)


def test_missing_input_is_unavailable_not_zero():
    ctx = {**CTX, "norm": {"na": "only 3 stored sessions, 10 needed"}, "move": {"na": "no 11/10 bar"}}
    items = R.evidence(_c("C", ask=90, bid=10, oi=None), ctx)
    st = {k: (s, t) for k, s, t in items}
    assert st["unusual"] == (R.NA, "premium norm UNAVAILABLE (only 3 stored sessions, 10 needed)")
    assert st["stock"] == (R.NA, "stock move UNAVAILABLE (no 11/10 bar)")
    assert st["vol>OI"] == (R.NA, "OI not reported")
    assert R.count(items) == 2                                               # UNAVAILABLE items are not counted
    lines = R.render_contract(1, _c("C", ask=90, bid=10, oi=None), items, R.count(items))
    assert "❔ premium norm UNAVAILABLE" in lines[-1] and "$0" not in "\n".join(lines)
    assert R.perp_line("NVDA", {"ok": False, "status": "UNAVAILABLE", "error": "key rejected (401)"}) == \
        "Perp: UNAVAILABLE (key rejected (401))"
    assert R.perp_line("ZZZZ", {"ok": False, "status": "UNAVAILABLE", "error": "HTTP 404"}).startswith(
        "Perp: no perpetual for this ticker")
    assert "UNAVAILABLE" in R.ctx_earnings("NO_SUCH_TICKER_X", SESSION)
    assert "not the stock or its options" in R.perp_line("IBIT", {"ok": True, "status": "OK", "as_of": None, "data": {
        "regimeLabel": "Balanced", "openInterestUsd": 7e9, "components": {"oi24hPct": -2.0, "fundingRatePct": 0.008}}})


def test_norm_eval():
    assert "na" in R.norm_eval(5e6, [1e6] * 5)
    n = R.norm_eval(3e6, [1e6] * 20)
    assert round(n["mult"], 2) == 3.0
    assert "median $0" in R.norm_eval(3e6, [0.0] * 20)["na"]


def test_render_sections_in_order_and_short_lines():
    prints, removed = R.dedup([_p("flow.db"), _p("FG LiveFlows", t=T0 + 0.3),
                               _p(cp="P", side="A", prem=500_000.0, vol=100, strike=150.0)])
    out = R.render(sym="NVDA", session=SESSION, prints=prints, removed=removed, summaries=[], ctx=CTX,
                   data_times="flow.db 16:00 ET", context=["Price: UNAVAILABLE (test)"], fg_block="FGBLOCK",
                   tape_block="TAPEBLOCK", stale=["FG2 Alerts 0 (Firebase node empty today)"])
    order = ["evidence report", "Duplicates removed: 1", "🟢 **Bullish evidence**", "🔴 **Bearish evidence**",
             "⚪ **Unclear or mixed**", "**Context**", "FGBLOCK", "TAPEBLOCK", "Stale or empty sources:", "not NBBO"]
    pos = [out.index(x) for x in order]
    assert pos == sorted(pos)
    assert "evidence count · no proven edge" in out
    for bad in ("high-confidence", "proven edge.", "win rate", "entry", "stop", "target"):
        assert bad not in out.lower().replace("no proven edge", "")
    assert max(len(ln) for ln in out.splitlines()) <= 200


# ─── queue (market clock) ─────────────────────────────────────────────────────
def test_queue_only_outside_regular_hours(tmp_path):
    q = tmp_path / "queue.json"
    rth = datetime(2026, 11, 10, 11, 0, tzinfo=ET)
    assert R.maybe_queue("NVDA", 123, SESSION, rth, path=q) is None and R.read_queue(q) == []
    assert R.maybe_queue("NVDA", 123, SESSION, datetime(2026, 11, 10, 9, 29, tzinfo=ET), path=q)   # pre-market
    assert "already" in R.maybe_queue("NVDA", 123, SESSION, datetime(2026, 11, 10, 17, 0, tzinfo=ET), path=q)
    assert R.maybe_queue("AMD", 123, SESSION, datetime(2026, 11, 14, 12, 0, tzinfo=ET), path=q)     # Saturday
    assert R.maybe_queue("TSLA", 9, SESSION, datetime(2026, 11, 26, 12, 0, tzinfo=ET), path=q)     # Thanksgiving
    assert [(e["sym"], e["channel_id"]) for e in R.read_queue(q)] == [("NVDA", "123"), ("AMD", "123"), ("TSLA", "9")]
    assert R.maybe_queue("NVDA", None, SESSION, datetime(2026, 11, 10, 17, 0, tzinfo=ET), path=q) is None


def test_session_for_premarket_is_previous_day():
    assert R.session_for(datetime(2026, 11, 11, 8, 0, tzinfo=ET)) == date(2026, 11, 10)
    assert R.session_for(datetime(2026, 11, 11, 22, 0, tzinfo=ET)) == date(2026, 11, 11)
    assert R.session_for(datetime(2026, 11, 14, 12, 0, tzinfo=ET)) == date(2026, 11, 13)


# ─── morning follow-up ────────────────────────────────────────────────────────
def _row(verdict, new_d, chg=None):
    return {"occ": "NVDA270617C00175000", "d": "2026-11-10", "verdict": verdict, "new_d": new_d, "prior_oi": 7530,
            "new_oi": None if chg is None else 7530 + chg, "chg": chg, "print_vol": 3055,
            "new_src": "chain still dated 2026-11-10" if new_d is None else "CBOE delayed chain (snapshot 2026-11-11 16:25 ET)"}


def test_followup_keeps_ticker_queued_when_oi_not_newer():
    sent = []
    entry = {"sym": "NVDA", "channel_id": "1", "session": "2026-11-10"}
    now = datetime(2026, 11, 11, 10, 45, tzinfo=ET)
    done, notes = FU.process([entry], now, evaluate=lambda s, d, t: ([_row("PENDING", None)], {}),
                             post_discord=lambda c, m: sent.append(m) or True, post_tg=lambda m: True)
    assert done == [] and sent == [] and "OI not updated yet" in notes[0]
    # same session evening (session not over) → also kept, nothing evaluated
    done, notes = FU.process([entry], datetime(2026, 11, 10, 20, 0, tzinfo=ET),
                             evaluate=lambda *a: 1 / 0, post_discord=lambda c, m: True, post_tg=lambda m: True)
    assert done == [] and "not over" in notes[0]


def test_followup_posts_and_removes_when_oi_is_newer():
    sent = []
    entry = {"sym": "NVDA", "channel_id": "1", "session": "2026-11-10"}
    done, _ = FU.process([entry], datetime(2026, 11, 11, 10, 45, tzinfo=ET),
                         evaluate=lambda s, d, t: ([_row("OPENING", "2026-11-11", chg=3000)],
                                                   {"NVDA270617C00175000": {"premium": 8.2e6}}),
                         post_discord=lambda c, m: sent.append(("discord", c, m)) or True,
                         post_tg=lambda m: sent.append(("tg", m)) or True)
    assert done == [entry] and [s[0] for s in sent] == ["discord", "tg"]
    assert "7,530→10,530" in sent[0][2] and "OPENING" in sent[0][2] and "$8.20M printed" in sent[0][2]
    # Discord failed → stays queued for the next run
    done, _ = FU.process([entry], datetime(2026, 11, 11, 10, 45, tzinfo=ET),
                         evaluate=lambda s, d, t: ([_row("OPENING", "2026-11-11", chg=3000)], {}),
                         post_discord=lambda c, m: False, post_tg=lambda m: True)
    assert done == []
