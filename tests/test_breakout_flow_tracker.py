"""Breakout FLOW overlay reads the signal tracker's vendor flow alerts (flow_candidates retired 2026-06-09)."""
import sqlite3, sys, tempfile, time
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parents[1]))
import breakout_scanner as S  # noqa: E402


def _db(rows):
    d = Path(tempfile.mkdtemp()) / "tracker.sqlite"
    con = sqlite3.connect(d)
    con.execute("CREATE TABLE signals(id TEXT, vendor TEXT, feed TEXT, occ TEXT, alert_at REAL)")
    con.executemany("INSERT INTO signals VALUES(?,?,?,?,?)", rows)
    con.commit(); con.close()
    return d


def test_flow_direction_from_vendor_feeds_only():
    now = time.time()
    S.FLOW_DB = _db([
        ("1", "Unusual Whales", "uw_feed:interval", "NVDA261120C00220000", now - 3600),
        ("2", "FlowGreeks flow", "scraper:flow_alerts_today.json", "NVDA261120P00200000", now - 7200),
        ("3", "Firebase v2", "relay:v2_short_opt", "BRK.B261120C00500000", now - 60),
        ("4", "Desk decipher", "decipher_picks", "AAPL261120C00350000", now - 60),      # our own pick, not flow
        ("5", "Unusual Whales", "uw_feed:hot_contract", "TSLA261120C00400000", now - 5 * 86400),  # older than 3 days
    ])
    out = S.flow_tickers()
    assert out == {"NVDA": {"BULLISH", "BEARISH"}, "BRK.B": {"BULLISH"}}
    assert S.FLOW_STATUS["stale"] is False and S.FLOW_STATUS["newest"].endswith(" ET")
    assert S.flow_tag(out["NVDA"], "breakout") == "mixed"


def test_stale_when_no_recent_flow():
    S.FLOW_DB = _db([("1", "Unusual Whales", "uw_feed:interval", "NVDA261120C00220000", time.time() - 4 * 86400)])
    assert S.flow_tickers() == {} and S.FLOW_STATUS["stale"] is True


if __name__ == "__main__":
    test_flow_direction_from_vendor_feeds_only(); test_stale_when_no_recent_flow(); print("ok")
