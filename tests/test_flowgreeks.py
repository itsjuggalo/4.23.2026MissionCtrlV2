"""lib/flowgreeks: routing of every FlowGreeks resource to its category + Discord channel, parsing, dedupe, filter."""
from datetime import datetime, timedelta

from lib import flowgreeks as F

ET = F.ET
T0 = int(datetime(2026, 11, 9, 11, 0, tzinfo=ET).timestamp() * 1000)


def _alert(at, prem=2_000_000, sym="NVDA", bull=False, t=T0):
    return {"alert": {"AlertType": at, "Symbol": sym, "Strike": 200.0, "OptionType": "CALL", "Expiry": 1799989200,
                      "totalFlowValue": prem, "isBullish": bull, "Volume": 10, "OI": 20, "SWEEPS": 2, "BLOCKS": 1,
                      "Time": t, "UnderlyingType": "stock"}, "quote": {}}


def _live(color, value, t=T0, sym="TGT", side="A", vol=100):
    return {"Symbol": sym, "Strike": 80.0, "OptionType": "PUT", "ExpiryStr": "2027-01-15", "Value": value,
            "COLOR": color, "BidAskType": side, "BlockType": "BLOCK", "Volume": vol, "OI": 50, "Time": t,
            "UnderlyingType": "stock"}


def test_route_alert_matches_the_posters():
    assert F.route_alert("high_flow") == ("Huge", False, "#flow-huge")
    assert F.route_alert("unusual_high_flow") == ("Unusual", False, "#flow-unusual")
    assert F.route_alert("repeat_flow") == ("Repeated", False, "#flow-repeaters")
    assert F.route_alert("weekly_flow") == ("Weekly", False, "#fg-weekly")
    assert F.route_alert("repeat_flow_etf") == ("Repeated", True, "#flow-etf-weekly")
    assert F.route_alert(None) == ("Other", False, "#flow-fg-alerts")
    assert F.route_alert("something_new", fg2=True) == ("Other", False, "#fg2-option-alerts")


def test_route_live_color_then_premium():
    assert F.route_live("green", 60_000) == ("Huge", "#flow-huge")
    assert F.route_live("white", 500_000) == ("Huge", "#flow-huge")
    assert F.route_live("yellow", 60_000) == ("Unusual", "#flow-unusual")
    assert F.route_live("white", 150_000) == ("Unusual", "#flow-unusual")
    assert F.route_live("white", 50_000) == ("Live", "#flow-live")
    assert F.route_live(None, 49_999) == ("Live", "not posted (< $50K)")


def test_signals_carry_resource_channel_and_view():
    a = F.alert_sig(_alert("repeat_flow_etf", bull=True))
    assert (a["cat"], a["chan"], a["resource"], a["view"], a["exp"], a["cp"]) == (
        "Repeated", "#flow-etf-weekly", "FG Alerts repeat_flow_etf", "bull", "01/15/27", "C")
    assert "[Repeated ETF · FG Alerts repeat_flow_etf → #flow-etf-weekly]" in F.line(a)
    lv = F.live_sig(_live("yellow", 200_000, side="B"), fg2=True)
    assert (lv["cat"], lv["chan"], lv["resource"], lv["side"], lv["exp"], lv["view"]) == (
        "Unusual", "#flow-unusual", "FG2 LiveFlows yellow", "bid", "01/15/27", "")
    assert "[Unusual · FG2 LiveFlows yellow → #flow-unusual]" in F.line(lv)
    assert F.alert_sig({"alert": {"Symbol": "X"}}) is None and F.live_sig({}) is None


def test_pick_by_type_ticker_premium():
    sigs = [F.alert_sig(_alert("high_flow", 6e6)), F.alert_sig(_alert("weekly_flow_etf", 1e6, sym="SOXL")),
            F.live_sig(_live("white", 600_000)), F.live_sig(_live("white", 80_000, sym="AMD"), fg2=True)]
    assert [s["sym"] for s in F.pick(sigs, "huge", None, None, None)] == ["NVDA", "TGT"]
    assert [s["sym"] for s in F.pick(sigs, "etf", None, None, None)] == ["SOXL"]
    assert [s["sym"] for s in F.pick(sigs, "live", None, None, None)] == ["AMD"]
    assert [s["sym"] for s in F.pick(sigs, "fg2", None, None, None)] == ["AMD"]
    assert [s["sym"] for s in F.pick(sigs, "all", "tgt", None, None)] == ["TGT"]
    assert [s["sym"] for s in F.pick(sigs, "all", None, 500_000, 2e6)] == ["SOXL", "TGT"]


def test_liveflows_dedupe_keys_and_bursts(tmp_path, monkeypatch):
    import json
    start = datetime(2026, 11, 9, 9, 30, tzinfo=ET)
    burst = [_live("white", 20_987_999, t=T0 + i * 1500, vol=2400) for i in range(10)]   # 10 copies over 13.5 s
    later = _live("white", 20_987_999, t=T0 + 600_000, vol=2400)                          # same print 10 min later
    lines = [{"feed": "flow_live_today", "key": str(d["Time"]), "data": d} for d in burst + [later]]
    lines.append({"feed": "flow_live100", "key": "x1", "data": burst[0]})                   # same trade, other key
    stream = tmp_path / "live.jsonl"
    stream.write_text("\n".join(json.dumps(x) for x in lines))
    monkeypatch.setattr(F, "STREAM", stream)
    monkeypatch.setattr(F, "STREAM_HB", tmp_path / "hb")
    monkeypatch.setattr(F, "OS_DATA", tmp_path)
    status = {}
    rows = F.load_liveflows(start, start + timedelta(hours=8), status)
    assert [r["dup"] for r in rows] == [11, 1]
    assert status["FG LiveFlows"][0] == 2 and status["FG2 LiveFlows"] == (0, "Firebase node empty in window")


def test_render_names_every_source_and_empty_ones():
    since = datetime(2026, 11, 9, tzinfo=ET)
    status = {"FG Alerts": (1, "scrape 15:24 ET"), "FG2 Alerts": (0, "Firebase node empty today")}
    out = F.render([F.alert_sig(_alert("high_flow"))], status, kind="huge", ticker="NVDA", lo=1e6, hi=None,
                   since=since)
    assert "FG2 Alerts 0 (Firebase node empty today)" in out and "By type: Huge 1 $2.00M" in out
    assert "premium $1.00M–any" in out and "→ #flow-huge]" in out
    assert "No FlowGreeks signals matched" in F.render([], status, kind="fg2", ticker=None, lo=None, hi=None,
                                                        since=since)
