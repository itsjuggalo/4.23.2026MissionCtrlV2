"""gex_chart.owner_flip: the GEX owner's flip fills a chart whose own chain has no zero cross (2026-10-23 sweep)."""
import datetime as dt
import json
import sys
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parents[1] / "trade_charts"))
import gex_chart as G  # noqa: E402

ET = dt.timezone(dt.timedelta(hours=-4))


def _doc(tmp_path, as_of="2026-10-22T15:59:59-04:00", flip=772.62):
    p = tmp_path / "gex.json"
    p.write_text(json.dumps({"asOf": as_of, "symbols": {"SPY": {"flip": flip, "asOf": as_of}}}))
    return p


def test_owner_flip_fresh(tmp_path):
    f, label = G.owner_flip("SPY", dt.datetime(2026, 10, 23, 10, 5, tzinfo=ET), _doc(tmp_path))
    assert f == 772.62 and "pipeline/gex CBOE chain" in label and "10-22 15:59 ET" in label


def test_owner_flip_stale_or_missing(tmp_path):
    f, why = G.owner_flip("SPY", dt.datetime(2026, 10, 24, 10, 5, tzinfo=ET), _doc(tmp_path))
    assert f is None and "stale" in why
    f, why = G.owner_flip("QQQ", dt.datetime(2026, 10, 23, 10, 5, tzinfo=ET), _doc(tmp_path))
    assert f is None and "no flip" in why
    f, why = G.owner_flip("SPY", None, tmp_path / "nope.json")
    assert f is None and "unreadable" in why


def test_caption_names_flip_source():
    g = dict(ticker="SPY", expiry="2026-11-20", dte=28, spot=764.0, spot_src="Yahoo daily bar 10-22, not Robinhood",
             net=-2.78e9, div=1e9, unit="$Bn", flip=772.62, flip_src="pipeline/gex CBOE chain, as of 10-22 15:59 ET",
             thin=False)
    c = G.caption(g)
    assert "gamma flip $772.62 (pipeline/gex CBOE chain" in c and "n/a" not in c
    c2 = G.caption({**g, "flip": None, "flip_src": "no zero cross in this chain; GEX owner flip is stale"})
    assert "gamma flip UNAVAILABLE (no zero cross" in c2
