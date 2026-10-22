"""flow_picks_post staged v2 terms (Mike 2026-10-21): with the flag file absent the production score is unchanged;
with it present the accumulation + IV-rank delta from missionctrl pipeline/intel/pick_features.py is added.
Offline: flow.db and iv_rank_ext reads are stubbed. Run: ~/.venv/bin/python ~/scripts/tests/test_flow_picks_v2.py"""
import sys
import tempfile
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parents[1]))
sys.path.append("/AIWorkWSL/web/missionctrl")
import flow_picks_post as P  # noqa: E402
from pipeline.intel import pick_features as PF  # noqa: E402

A = {"Symbol": "AAPL", "OptionSymbol": "AAPL261120C00340000", "OptionType": "Call", "Strike": 340,
     "Expiry": 1795150800, "totalFlowValue": 1_000_000, "Volume": 2000, "OI": 1000, "DTE": 30, "SWEEPS": 2, "BLOCKS": 1}


def _stub(monkey_flag: Path | None):
    PF.FLAG = monkey_flag or Path("/nonexistent/flow_picks_v2.on")
    PF.buys_by_symbol = lambda sym, day, until=None: {("C", 340.0): {"2026-11-20": {"2026-10-19", "2026-10-20", "2026-10-21"},
                                                                     "2026-12-18": {"2026-10-16"}}}
    PF.iv_rank = lambda sym, doc=None: {"iv_rank": 25.0, "source": "tastytrade /market-metrics", "as_of": "2026-10-21T15:50"}
    P._V2_BUYS.clear(); P._V2_NOTES.clear(); P._V2_ON = False


def test_flag_off_score_unchanged():
    _stub(None)
    base = P._score(A)[0]
    assert P._v2_delta(A) == 0.0 and not P._V2_ON and not P._V2_NOTES
    assert abs(base - P._score(A)[0]) < 1e-12


def test_flag_on_adds_accumulation_and_iv_terms():
    with tempfile.TemporaryDirectory() as t:
        flag = Path(t) / "flow_picks_v2.on"
        flag.touch()
        _stub(None)
        base = P._score(A)[0]
        _stub(flag)
        d = P._v2_delta(A)
        # 3 sessions → 2 extra × 0.75; 1 other-expiry session × 0.3; IVR 25 → (50−25)/50 × 1.0
        assert abs(d - (1.5 + 0.3 + 0.5)) < 1e-9, d
        assert abs(P._score(A)[0] - (base + d)) < 1e-9
        notes = " ".join(P._V2_NOTES[A["OptionSymbol"]])
        assert "bought on 3 sessions" in notes and "IVR 25" in notes and "tastytrade" in notes


def test_replay_base_score_matches_production():
    from pipeline.intel.pick_replay import base_score
    _stub(None)
    for a in (A, {**A, "DTE": 3, "Volume": 50, "OI": 0, "SWEEPS": 20}, {**A, "DTE": 200, "totalFlowValue": 0}):
        prod = P._score(a)[0]
        rep = base_score(a["totalFlowValue"], a["Volume"], a["OI"] or 1, a["DTE"], a["SWEEPS"] + a["BLOCKS"])
        assert abs(prod - rep) < 1e-9, (prod, rep)


if __name__ == "__main__":
    test_flag_off_score_unchanged(); test_flag_on_adds_accumulation_and_iv_terms(); test_replay_base_score_matches_production()
    print("3 passed")
