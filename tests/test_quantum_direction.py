"""/sweeps /odte direction (2026-10-22): the vendor's isBullish has no execution side; flow.db's tape names it.
SPCX 160P 10-21 showed 🟢BULL while the tape was net ask-side (bought puts) — both reads are now shown."""
import sqlite3
import sys
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parents[1]))
import quantum_tg as q  # noqa: E402


def test_direction_label():
    assert q.direction_label("PUT", True, "bid") == "🟢sold put · bullish"
    assert q.direction_label("CALL", True, "ask") == "🟢bought call · bullish"
    assert q.direction_label("CALL", False, "bid") == "🔴sold call · bearish"
    assert q.direction_label("PUT", True, "ask") == "🟡 vendor BULL · tape bought put · bearish (net ask-side)"
    assert q.direction_label("PUT", True, None) == "🟢BULL (vendor; side not in feed)"
    assert q.direction_label("CALL", False, "mixed") == "🔴BEAR (vendor; side not in feed)"


def test_tape_side_reads_flow_db_up_to_alert(tmp_path, monkeypatch):
    db = tmp_path / "flow.db"
    con = sqlite3.connect(db)
    con.execute("CREATE TABLE flow_events_dedup (symbol, option_type, strike, expiry, premium, bid_ask, event_time)")
    con.executemany("INSERT INTO flow_events_dedup VALUES (?,?,?,?,?,?,?)", [
        ("SPCX", "PUT", 160.0, "2026-10-21", 800, "A", 100), ("SPCX", "PUT", 160.0, "2026-10-21", 400, "B", 150),
        ("SPCX", "PUT", 160.0, "2026-10-21", 5000, "B", 999),           # after the alert: not counted
        ("SPCX", "CALL", 160.0, "2026-10-21", 9000, "B", 100)])         # other side of the chain
    con.commit(); con.close()
    monkeypatch.setattr(q, "FLOW_DB", str(db))
    a = {"OptionSymbol": "SPCX261021P00160000", "Updated": 200}
    assert q._tape_side(a) == "ask"
    assert q._tape_side({**a, "Updated": 1000}) == "bid"
    assert q._tape_side({"OptionSymbol": "ZZZ261021P00160000", "Updated": 200}) is None
