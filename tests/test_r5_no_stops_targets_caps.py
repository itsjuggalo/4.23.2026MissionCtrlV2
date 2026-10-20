"""R5 (Mike 2026-10-20): no stops, no targets, no risk caps, no sizing in any advisory text.

The scanners observe momentum. Rendered messages state what moved, how much, and the
per-contract cost (premium mid x 100) — and nothing trade-plan-like. Pure render tests
with fake data: nothing is sent, no network.

Covers: flow_chase (verdict + FLOW WINNERS board) - morning_command (top contract line,
catalyst prompt) - quantum_sniper (green-light buzz) - quantum_tg (pick verdict) -
real_coach.precheck (no stop / cap gate).
"""
import importlib
import json
import os
import re
import sys

ROOT = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))


def _imp(name):
    # Several scripts prepend ~/scripts (the main checkout) to sys.path on import, so pin
    # THIS tree to the front before each import and let sys.modules serve the rest.
    sys.path.insert(0, ROOT)
    return importlib.import_module(name)


_imp("tg_format"), _imp("price_guard")
Q = _imp("quantum_tg")
QS = _imp("quantum_sniper")
PC = _imp("real_coach.precheck")
FC = _imp("flow_chase")
MC = _imp("morning_command")

FORBIDDEN = re.compile(
    r"stop ref|target ref|\bstop\b|\btarget\b|\bT1\b|\bR:R\b|\d+R\b|reward|"
    r"\$400|max risk|risk cap|over (your |the )?cap|within (your |the )?cap|affordable|"
    r"size ref|position siz|\bshares\b|per.trade limit|time.stop",
    re.I)


def _clean(text):
    bad = [m.group(0) for m in FORBIDDEN.finditer(text)]
    assert not bad, f"R5 wording found {bad!r} in: {text!r}"


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


def test_format_alert_is_clean():
    a = _alert()
    _clean(FC.format_alert(a, _verdict(2.05)))


def test_top_desk_contract_line_has_cost_and_no_levels(tmp_path, monkeypatch):
    from datetime import datetime
    p = tmp_path / "best.json"
    p.write_text(json.dumps({"as_of": datetime.now(MC.ET).isoformat(), "picks": [{
        "action": "ACT", "structure": "naked", "ticker": "AMD", "strike": 180, "type": "call",
        "expiry": "2099-01-15", "mid": 3.2, "per_contract": 320}]}))
    monkeypatch.setattr(MC, "BEST_CONTRACTS", p)
    out = MC._one_contract_line()
    assert "$320 per contract" in out and "mid $3.20" in out
    _clean(re.sub(r"<[^>]+>", "", out))


def test_morning_prompt_and_helpers_have_no_plan_machinery():
    assert not hasattr(MC, "_plan_orders")
    import inspect
    src = inspect.getsource(MC._catalysts_and_orders)
    assert '"stop"' not in src and '"target"' not in src
    assert "no stops, no targets" in src


def test_sniper_buzz_has_cost_and_no_levels():
    p = {"ticker": "AMD", "strike": 180, "type": "call", "expiry": "2099-01-15", "days": 20,
         "per_contract": 320, "confidence": "A", "sources": 3, "value": "fair",
         "action_why": "clean setup"}
    out = QS._buzz_text(p, {})
    assert "$320" in out and "per contract" in out
    _clean(re.sub(r"<[^>]+>", "", out))


def test_pick_verdict_is_gate_state_only():
    for act, val in (("ACT", "fair"), ("ACT", "rich"), ("ACT-SMALL", "fair"), ("WAIT", "fair")):
        _clean(Q._verdict({"action": act, "value": val}))


def test_precheck_never_blocks_or_computes_a_stop(monkeypatch):
    r = PC.precheck("TSLA", "stock", "buy", size_usd=99999, entry=340, stop=500, target=1)
    assert r["verdict"] == "GO" and r["blocked"] is False
    assert not ({"stop", "target", "risk_usd", "rr", "computed_stop", "stop_source",
                 "size_usd", "manual_stop"} & set(r))
    _clean(" ".join(c["detail"].replace("no stop/target/size checks, R5", "") for c in r["checks"]))
    assert not hasattr(PC, "compute_stop")
