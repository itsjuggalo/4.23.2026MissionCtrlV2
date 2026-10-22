"""debate_daily.contract_moves (Mike 2026-10-21): contract move since first flow print, from RH option bars. No network."""
import sys, unittest
from pathlib import Path
from unittest import mock
sys.path.insert(0, str(Path(__file__).resolve().parents[1]))
import debate_daily as d  # noqa: E402
from lib import rh_quote  # noqa: E402

T0 = rh_quote._epoch("2026-10-21T13:44:00Z")          # 09:44 ET first print
TEXT = "• **TSLA 10/26/26 420P** — flow.db×3\n• **TSLA 10/26/26 420P** — dup\n• **MU 11/27/26 850P** — x"


def bars(rows, err=None, as_of_et="2026-10-21 16:00 ET"):
    return {"bars": [{"t": t, "o": o, "h": o, "l": c, "c": c} for t, o, c in rows], "error": err, "as_of_et": as_of_et}


class Moves(unittest.TestCase):
    def test_five_minute_anchor_and_missing_day(self):
        def fake(occ, interval="day", span="year", **kw):
            if occ.startswith("TSLA") and interval == "5minute":
                return bars([(T0 - 240, 40.0, 39.0), (T0 + 7000, 36.0, 36.0)])
            return bars([], err="robinhood: no traded bars for this contract in the span")
        with mock.patch.object(rh_quote, "rh_option_bars", side_effect=fake), \
             mock.patch.object(d, "_first_print", side_effect=lambda c: (T0, 37.5) if c["symbol"] == "TSLA" else None):
            out = d.contract_moves(TEXT)
        self.assertEqual(len(out), 2)                                  # duplicate contract counted once
        self.assertIn("-10.0% since first flow print 10/21 09:44 ET", out[0])
        self.assertIn("open of the 5-min bar at 10/21 09:40 ET → 36", out[0])
        self.assertIn("first print fill $37.5 (flow.db)", out[0])
        self.assertIn("no first flow print in flow.db — move since first print UNAVAILABLE", out[1])


def test_pick_menu_lists_every_contract_and_names_failure(monkeypatch):
    """pick_score.v1 factor menu (R35): one line per contract from the scorer; a failure is stated, never filled."""
    import json as _json
    import debate_daily as D
    text = "**NVDA 11/20/26 200C** x\n**AMD 11/20/26 150P** y"
    calls = {}

    def ok(cmd, timeout=120, env=None, inp=None):
        calls["cmd"] = cmd
        occs = cmd[cmd.index("--lines") + 1].split(",")
        return 0, _json.dumps({o: "pick_score.v1 +0.10 (9/12): flow +0.5" for o in occs})
    monkeypatch.setattr(D, "run", ok)
    m = D.pick_menu(text)
    assert "NVDA261120C00200000: pick_score.v1 +0.10" in m and "AMD261120P00150000" in m and "weigh every factor" in m
    monkeypatch.setattr(D, "run", lambda *a, **k: (1, "boom"))
    assert D.pick_menu(text).startswith("FACTOR MENU UNAVAILABLE (pick_score.v1 rc 1)")
    assert D.pick_menu("no contracts here") == ""


if __name__ == "__main__":
    unittest.main()
