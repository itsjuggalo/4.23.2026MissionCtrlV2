"""R32 guard (Mike 2026-10-21; supersedes R5 for levels): computed levels yes, sizes and caps no.

Rendered messages may carry Entry / TP1 / TP2 / Final TP / SL ONLY through levels_block (the levels.v1 engine, each
level with its method, the block with source + as_of). Everything outside that block stays free of level wording,
and nothing anywhere states a size, a contract count, a risk cap or a price cap. Pure render tests with fake data and
a fake levels block: nothing is sent, no network, no engine call.

Covers: flow_chase (verdict + push card + FLOW WINNERS board) - morning_command (top contract line, momentum prompt) -
quantum_tg (pick verdict + top pick) - real_coach.precheck (no stop / cap gate).
Replaces tests/test_r5_no_stops_targets_caps.py.
"""
import importlib
import json
import os
import re
import sys

import pytest

ROOT = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))


def _imp(name):
    # Several scripts prepend ~/scripts (the main checkout) to sys.path on import, so pin
    # THIS tree to the front before each import and let sys.modules serve the rest.
    sys.path.insert(0, ROOT)
    return importlib.import_module(name)


_imp("tg_format"), _imp("price_guard")
LB = _imp("levels_block")
Q = _imp("quantum_tg")
PC = _imp("real_coach.precheck")
FC = _imp("flow_chase")
MC = _imp("morning_command")

# Level wording: allowed only inside the levels_block lines.
LEVEL_WORDS = re.compile(r"stop ref|target ref|\bstop\b|\btarget\b|\bT1\b|\bTP\d?\b|\bSL\b|time.stop", re.I)
# Size / cap wording: never, anywhere (inside the block too).
SIZE_CAP = re.compile(
    r"\bR:R\b|\d+R\b|reward|\$400|max risk|risk cap|over (your |the )?cap|within (your |the )?cap|affordable|"
    r"size ref|position siz|\bshares\b|per.trade limit|\bbuy \d+ contracts|\d+ contracts? (?:max|at most)|"
    r"contracts? to buy|risk budget|max loss per trade",
    re.I)
FAKE = ["Levels: Entry: 1–2 (Long) · TP1 3 · TP2 4 · Final TP 5 · SL 0.5",
        "Methods: entry pivot · TP1 pivot · TP2 pivot · Final iv_em · SL volume_node · spot fake 10-22 10:00 ET",
        LB.FOOTER]


@pytest.fixture(autouse=True)
def no_live_registry(monkeypatch, tmp_path):
    """paused_note() reads MissionCtrl's freshness registry: tests never read the live one (not paused here)."""
    monkeypatch.setattr(Q, "REGISTRY", str(tmp_path / "absent.json"))


@pytest.fixture(autouse=True)
def fake_levels(monkeypatch):
    """Every sender gets the same fake block — and the call is recorded, so a test can assert the args."""
    calls = []
    def fake(symbol, side="long", horizon="swing", occ=None, *, footer=True, timeout=60):
        calls.append((symbol, side, horizon, occ))
        return [x for x in FAKE if footer or x != LB.FOOTER]
    monkeypatch.setattr(LB, "lines", fake)
    return calls


def _clean(text, block=False):
    """Size/cap wording nowhere; level wording only inside the levels block (which must be present when block=True)."""
    text = re.sub(r"<[^>]+>", "", text)
    bad = [m.group(0) for m in SIZE_CAP.finditer(text)]
    assert not bad, f"size/cap wording {bad!r} in: {text!r}"
    rest = text
    if block:
        for x in FAKE:
            assert x in text, f"levels block line missing: {x!r}"
            rest = rest.replace(x, "")
    bad = [m.group(0) for m in LEVEL_WORDS.finditer(rest)]
    assert not bad, f"level wording outside the levels_block {bad!r} in: {rest!r}"


def test_real_footer_states_no_size_no_cap():
    assert "No size, no cap" in LB.FOOTER


def _alert(**over):
    a = {"Symbol": "NVDA", "Strike": 200.0, "OptionType": "CALL", "AlertPrice": 2.00,
         "DTE": 10, "Volume": 3000, "OI": 1000}
    a.update(over)
    return a


def _verdict(mid, **over):
    return FC.chase_verdict(_alert(**over), {"mid": mid, "iv": 0.5},
                            {"chg_pct": 1.0, "window": "RTH"})


def test_every_chase_tier_states_cost_and_move_without_plan_wording():
    for mid in (2.05, 2.90, 5.00, 1.50):      # EARLY / LATE / SKIP / down-from-alert
        v = _verdict(mid)
        for fld in ("head", "action"):
            _clean(v[fld])
        _clean(" ".join(v["reasons"]))
    early = _verdict(2.05)["action"]
    assert "1 contract ≈ $205" in early and "vs the alert price" in early


def test_expensive_contract_is_priced_not_judged():
    v = _verdict(9.99)
    assert "$999" in v["action"] or v["tier"] == "SKIP"
    _clean(v["action"])


def test_no_quote_reads_unavailable():
    v = FC.chase_verdict(_alert(), {"mid": None}, {})
    assert v["tier"] == "WAIT" and "UNAVAILABLE" in v["action"]
    _clean(v["action"])


def test_flow_chase_helpers_are_gone():
    for name in ("_stop_for", "_target_for", "_stop_pct", "RISK_CAP_USD"):
        assert not hasattr(FC, name)


def test_format_alert_carries_the_levels_block_and_nothing_else(fake_levels):
    a = _alert(OptionSymbol="NVDA261120C00200000_0931ab")
    _clean(FC.format_alert(a, _verdict(2.05)), block=True)
    assert fake_levels[-1] == ("NVDA", "long", "swing", "NVDA261120C00200000")
    _clean(FC.format_alert(_alert(OptionType="PUT", DTE=0), _verdict(2.05)), block=True)
    assert fake_levels[-1][1:3] == ("short", "day")


def test_top_desk_contract_line_has_cost_and_the_levels_block(tmp_path, monkeypatch):
    from datetime import datetime
    p = tmp_path / "best.json"
    p.write_text(json.dumps({"as_of": datetime.now(MC.ET).isoformat(), "picks": [{
        "action": "ACT", "structure": "naked", "ticker": "AMD", "strike": 180, "type": "call",
        "expiry": "2099-01-15", "mid": 3.2, "per_contract": 320}]}))
    monkeypatch.setattr(MC, "BEST_CONTRACTS", p)
    out = MC._one_contract_line()
    assert "$320 per contract" in out and "mid $3.20" in out
    _clean(out, block=True)


def test_morning_prompt_and_helpers_have_no_plan_machinery():
    assert not hasattr(MC, "_plan_orders")
    import inspect
    src = inspect.getsource(MC._catalysts_and_orders)
    assert '"stop"' not in src and '"target"' not in src
    assert "Never state a price level" in src and "never from you" in src   # an LLM never invents a level (R32)


def test_pick_verdict_is_gate_state_only():
    for act, val in (("ACT", "fair"), ("ACT", "rich"), ("ACT-SMALL", "fair"), ("WAIT", "fair")):
        _clean(Q._verdict({"action": act, "value": val}))


def test_precheck_never_blocks_or_computes_a_stop(monkeypatch):
    r = PC.precheck("TSLA", "stock", "buy", size_usd=99999, entry=340, stop=500, target=1)
    assert r["verdict"] == "GO" and r["blocked"] is False
    assert not ({"stop", "target", "risk_usd", "rr", "computed_stop", "stop_source",
                 "size_usd", "manual_stop"} & set(r))
    _clean(" ".join(c["detail"].replace("no stop/target/size checks, R5", "").replace("no stop/target/size checks, R32", "")
                    for c in r["checks"]))
    assert not hasattr(PC, "compute_stop")


def test_top_pick_carries_the_levels_block(monkeypatch, fake_levels):
    from datetime import datetime
    p = {"ticker": "AMD", "strike": 180, "type": "call", "expiry": "2099-01-15", "days": 20, "per_contract": 320,
         "confidence": "A", "sources": 3, "value": "fair", "action": "ACT", "occ": "AMD990115C00180000"}
    monkeypatch.setattr(Q, "_load", lambda name: {"as_of": datetime.now().isoformat(), "picks": [p]}
                        if name == "best_contracts.json" else None)
    _clean(Q.pick(1), block=True)
    assert fake_levels[-1] == ("AMD", "long", "swing", "AMD990115C00180000")


def test_board_rows_stay_compact_without_levels(monkeypatch, fake_levels):
    monkeypatch.setattr(FC, "option_snapshot", lambda occ: {"mid": 2.05, "iv": 0.5})
    monkeypatch.setattr(FC, "equity_snapshot", lambda s: {"chg_pct": 1.0, "window": "RTH"})
    _clean(FC._compact("NVDA261120C00200000", _alert()))
    assert fake_levels == []


def test_paused_pipeline_says_so_instead_of_silence_or_old_picks(monkeypatch, tmp_path):
    """Mike paused the quantum pipeline 2026-09-30: consumers say it, never go silent, never show 09-30 picks."""
    reg = tmp_path / "reg.json"
    reg.write_text(json.dumps({"entries": [{"id": "quantum-lab", "expectation": "paused",
                                            "paused": {"since": "2026-09-30", "by": "Mike", "reason": "cron silenced"}}]}))
    monkeypatch.setattr(Q, "REGISTRY", str(reg))
    note = "quantum pipeline paused since 09-30 (Mike) — no current pick"
    assert Q.paused_note() == note
    monkeypatch.setattr(Q, "_load", lambda name: {"as_of": "2026-09-30T15:11:10-04:00", "picks": [{"ticker": "RIOT"}]})
    monkeypatch.setattr(Q, "_journal", lambda status="open": [])          # never Mike's live journal
    for out in (Q.pick(1), Q.pick(3), MC._one_contract_line(), Q.greeks()):
        assert note in out and "RIOT" not in out
        _clean(out)
    reg.write_text(json.dumps({"entries": [{"id": "quantum-lab", "expectation": "required"}]}))
    assert Q.paused_note() is None
