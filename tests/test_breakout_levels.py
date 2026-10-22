"""breakout_cron levels (R32): menu ids only, validator-checked; no menu → pending + strip. No network, no LLM."""
import json
import sys
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parents[1] / "lib"))
import breakout_levels as B  # noqa: E402

FRESH = {"breakouts": [{"symbol": "NVDA", "close": 221.97}], "breakdowns": [{"symbol": "XYZ"}]}


def test_menus_ok_carries_rule_and_block():
    calls = []
    def run(args, timeout, inp=None):
        calls.append(args)
        return 0, json.dumps({"symbols": {"NVDA": {"status": "OK", "menu": [{"id": "L3"}]}, "XYZ": {"status": "UNAVAILABLE"}},
                              "block": "LEVEL MENU NVDA: L3 214.10 …"})
    lv = B.menus(FRESH, run=run)
    assert calls == [["menus", "NVDA,XYZ"]]
    assert lv["ok"] and "no LEVEL MENU" in lv["block"] and "LEVEL MENU NVDA" in lv["block"]


def test_menus_unavailable_says_pending():
    for rc, out in ((1, "boom"), (0, "not json"), (0, json.dumps({"symbols": {"NVDA": {"status": "UNAVAILABLE"}}, "block": ""}))):
        lv = B.menus(FRESH, run=lambda a, t, i=None: (rc, out))
        assert not lv["ok"] and lv["block"].startswith("levels: pending levels.v1")
    assert B.menus({"breakouts": []})["block"].startswith("levels: pending")


def test_check_uses_validator_then_strips_on_failure():
    lv = {"ok": True, "symbols": {"NVDA": {}}}
    ok = B.check("NVDA — long, SL NVDA:L3 214.10", lv, "{}", run=lambda a, t, i=None: (0, json.dumps({"ok": True})))
    assert ok == "NVDA — long, SL NVDA:L3 214.10"
    red = B.check("NVDA — long, stop 199", lv, "{}", run=lambda a, t, i=None: (0, json.dumps(
        {"ok": False, "redacted": "NVDA — long, stop [?]", "unknown_numbers": [199], "unknown_ids": []})))
    assert "199" not in red.split("\n")[0] and "removed" in red
    # validator down → every level clause stripped, never an unchecked model price
    down = B.check("NVDA — long, stop 199, earnings Thu", lv, "{}", run=lambda a, t, i=None: (124, "timeout"))
    assert "199" not in down and "earnings Thu" in down
    # no menu → strip too
    assert "231" not in B.check("NVDA — long, target 231", {"ok": False}, "{}")
