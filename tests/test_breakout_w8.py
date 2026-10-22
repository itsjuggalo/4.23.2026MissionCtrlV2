"""W8 MC-AUD-013: breakout scan labels — 52W (not ATH), flow direction, bar session/staleness; dry-run render only."""
import json, os, subprocess, sys
from datetime import datetime, timezone
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parents[1]))
import breakout_scanner as S  # noqa: E402

ET_OFF = "-04:00"


def _bars(n, last_c, vol_last):
    out = []
    for i in range(n):
        out.append({"t": f"2026-{1 + i // 28:02d}-{1 + i % 28:02d}T04:00:00Z", "o": 50, "h": 50 + i * 0.1, "l": 49,
                    "c": 50 + i * 0.1, "v": 1000})
    out[-1].update(c=last_c, h=last_c, v=vol_last)
    return out


def test_label_is_52w_not_ath_and_flow_direction():
    b = _bars(260, 80.0, 5000)
    hit = S.analyze("XYZ", b, {"XYZ": {"BEARISH"}}, "breakout")
    assert hit and hit["extreme_label"] == "NEAR-52W-HIGH"
    assert hit["flow_dir"] == "adverse"
    short = S.analyze("XYZ", _bars(100, 80.0, 5000), {}, "breakout")
    assert short["extreme_label"] == "NEAR-100D-HIGH" and short["flow_dir"] == ""
    assert S.flow_tag({"BULLISH"}, "breakout") == "aligned" and S.flow_tag({"BULLISH", "BEARISH"}, "breakout") == "mixed"


def test_bar_meta_partial_and_stale():
    bars = [{"t": "2026-10-21T04:00:00Z"}]
    mid = datetime.fromisoformat("2026-10-21T12:30:00" + ET_OFF)
    assert S.bar_meta(bars, "iex", mid)["session"].startswith("PARTIAL")
    nxt = datetime.fromisoformat("2026-10-22T12:30:00" + ET_OFF)
    assert S.bar_meta(bars, "iex", nxt)["session"].startswith("STALE")
    after = datetime.fromisoformat("2026-10-21T17:00:00" + ET_OFF)
    assert S.bar_meta(bars, "iex", after)["session"] == "COMPLETE"


def test_cron_dry_run_renders_provenance(tmp_path):
    scan = {"bars": {"bar_date": "2026-10-21", "session": "PARTIAL (session open — volume so far vs full-day average)",
                     "source": "Alpaca IEX daily bars — cross-check only, not Robinhood", "adjustment": "split+dividend adjusted"},
            "flow_overlay": {"stale": True, "newest": "2026-06-09 18:03:02"},
            "breakouts": [{"symbol": "XYZ", "close": 80.0, "pct_vs_level": 2.1, "rvol": 3.0, "extreme_label": "NEAR-52W-HIGH",
                           "has_flow": True, "flow_dir": "adverse"}], "breakdowns": []}
    f = tmp_path / "scan.json"
    f.write_text(json.dumps(scan))
    env = {**os.environ, "DRY_RUN": "1", "FORCE": "1", "BREAKOUT_SCAN_JSON_FILE": str(f)}
    out = subprocess.run(["bash", str(Path(__file__).resolve().parents[1] / "breakout_cron.sh")], env=env,
                         capture_output=True, text=True, timeout=60).stdout
    assert "DRY RUN" in out and "PARTIAL" in out and "not Robinhood" in out
    assert "Flow overlay STALE" in out and "🔴FLOW against" in out and "ATH" not in out


if __name__ == "__main__":
    import tempfile
    test_label_is_52w_not_ath_and_flow_direction(); test_bar_meta_partial_and_stale()
    test_cron_dry_run_renders_provenance(Path(tempfile.mkdtemp())); print("ok")
