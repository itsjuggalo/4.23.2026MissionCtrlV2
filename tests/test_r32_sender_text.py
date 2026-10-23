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


def test_how_to_play_exit_comes_from_levels_v1_or_is_dropped(monkeypatch):
    sys.path.insert(0, str(ROOT))
    import levels_block as LB
    monkeypatch.setattr(LB, "exit_line", lambda s, k, d=None: f"{s} TP1 1.00 (pivot) · SL 0.50 (pivot) — levels.v1, spot x ET")
    got = E.how_to_play({"Symbol": "QQQ", "OptionType": "CALL", "DTE": 30})
    assert "levels.v1" in got and "50-100%" not in got and "-50%" not in got
    monkeypatch.setattr(LB, "exit_line", lambda s, k, d=None: None)
    got = E.how_to_play({"Symbol": "QQQ", "OptionType": "CALL", "DTE": 30})
    assert "TP1" not in got and "cut at" not in got, "no computed level → no exit line"


def test_exit_line_parses_the_engine_and_refuses_partial(monkeypatch):
    sys.path.insert(0, str(ROOT))
    import levels_block as LB
    doc = {"status": "OK", "line": "Entry: 1–2 (Long) · TP1 3.5 · TP2 4 · Final TP 5 · SL 0.9",
           "lines": ["Levels: …", "Methods: entry pivot+spot · TP1 pivot · TP2 pivot · Final atr_ext · SL volume_node · "
                     "spot quote.v1 · robinhood 10-23 13:52 ET · ATR14 1.0"]}
    monkeypatch.setattr(LB, "_doc", lambda *a, **k: doc)
    assert LB.exit_line("x", "CALL", 30) == ("X TP1 3.5 (pivot) · SL 0.9 (volume_node) — levels.v1, "
                                             "spot quote.v1 · robinhood 10-23 13:52 ET")
    monkeypatch.setattr(LB, "_doc", lambda *a, **k: {"status": "UNAVAILABLE", "lines": ["Levels UNAVAILABLE — x"]})
    assert LB.exit_line("x", "CALL", 30) is None
