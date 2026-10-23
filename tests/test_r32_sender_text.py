"""R32 (Mike 2026-10-21): no position size, % of equity or risk cap in sender text; morning_radar has no Alpaca leg."""
import re
import sys
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
sys.path.insert(0, str(ROOT / "lib"))
import explain as E  # noqa: E402

SIZING = re.compile(r"of (equity|account|portfolio)|\$\d+ risk|sized vs", re.I)


def test_how_to_play_carries_no_sizing():
    for a in ({"DTE": 0, "isBullish": True}, {"DTE": 30, "isBullish": False}):
        assert not SIZING.search(E.how_to_play(a, iv=80))


def test_sender_sources_carry_no_sizing_text():
    for f in ("lib/explain.py", "lib/chart_renderer.py", "tg_set_commands.py",
              "/AIWorkWSL/trading/analysis/preopen.py"):
        src = (ROOT / f).read_text() if not f.startswith("/") else Path(f).read_text()
        assert not SIZING.search(src), f


def test_morning_radar_reads_no_alpaca():
    src = (ROOT / "morning_radar.py").read_text()
    assert "data.alpaca.markets" not in src and "alpaca-boba" not in src
