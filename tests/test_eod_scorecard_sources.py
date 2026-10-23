"""eod_scorecard price + held-level fallback chains (sweep 2026-10-23)."""
import json
import sys
from datetime import datetime
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parents[1]))
import eod_scorecard as E  # noqa: E402


class _QC:
    def __init__(self, rows):
        self.rows = rows

    def get_canonical_quotes(self, syms):
        return [r for r in self.rows if r["symbol"] in syms]


def test_last_prefers_robinhood_quote_v1(monkeypatch):
    import price_guard
    today = datetime.now(E.ET).strftime("%Y-%m-%d")
    monkeypatch.setattr(price_guard, "QC", _QC([{"symbol": "MU", "price": 857.0, "as_of": f"{today}T16:00:00-04:00",
                                                 "source": {"provider": "robinhood"}}]))
    E.PX_SRC.clear()
    assert E._last("MU") == 857.0 and E.PX_SRC["MU"] == "Robinhood"
    assert "Robinhood ×1" in E._src_footer()


def test_last_skips_a_quote_from_another_day(monkeypatch):
    import price_guard
    monkeypatch.setattr(price_guard, "QC", _QC([{"symbol": "MU", "price": 1.0, "as_of": "2020-01-02T16:00:00-05:00",
                                                 "source": {"provider": "robinhood"}}]))
    assert E._quote_v1("MU") == (None, None)


def test_held_level_chain(tmp_path, monkeypatch):
    assert E._held_level("QQQ", {"heldLevel": 700.7}) == 700.7
    assert E._held_level("QQQ", {"stop": 699.0}) == 699.0
    p = tmp_path / "rebound_setup.json"
    p.write_text(json.dumps({"symbols": {"QQQ": {"lastBar": "2026-10-22", "components": {
        "level": {"best": {"price": 700.7, "held": True}}}}}}))
    monkeypatch.setattr(E, "REBOUND_SETUP", p)
    assert E._held_level("QQQ", {}, today="2026-10-22") == 700.7
    assert E._held_level("QQQ", {}, today="2026-10-23") is None      # another session's level is not used
    assert E._held_level("XLB", {}, today="2026-10-22") is None


def test_rebound_falls_back_to_ping_price(tmp_path, monkeypatch):
    st = tmp_path / "ping.json"
    st.write_text(json.dumps({"pinged": {"CRWD|2026-10-22": "2026-10-22T15:45:03-04:00"},
                              "sketches": {"CRWD|2026-10-22": {"label": "262.5C Dec 18 ~$1,470/contract"}}}))
    monkeypatch.setattr(E, "REBOUND_PING_STATE", st)
    monkeypatch.setattr(E, "REBOUND_SETUP", tmp_path / "none.json")
    monkeypatch.setattr(E, "_last", lambda s: 240.0)
    monkeypatch.setattr(E, "_alert_context", lambda *a, **k: (238.0, None))

    class FD(datetime):
        @classmethod
        def now(cls, tz=None):
            return datetime(2026, 10, 22, 16, 35, tzinfo=E.ET)
    monkeypatch.setattr(E, "datetime", FD)
    (r, g), = E._grade_rebound_triggers()
    assert r["basis"] == "alert" and g[2] == 238.0 and g[3] == 240.0
    msg = E._build_tg_msg([], [], [(r, g)], "", now=FD.now())
    assert "stock since ping 238.00→240.00" in msg
