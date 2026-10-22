"""Remedial W6 MC-AUD-135: an unreadable pm2 probe is reported UNAVAILABLE, never '0 online'."""
import sys
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parents[1]))
import md_freshness as M  # noqa: E402


def test_unavailable_is_not_zero():
    b = M.build_auto_block({"ok": False, "online": 0, "total": 0, "names": []},
                           {"lines": 1, "active": 1, "reboot": 0}, {}, "t")
    assert "UNAVAILABLE" in b and "0 online" not in b


def test_ok_counts():
    b = M.build_auto_block({"ok": True, "online": 2, "total": 3, "names": ["a", "b"]},
                           {"lines": 1, "active": 1, "reboot": 0}, {}, "t")
    assert "2 online / 3 total" in b
