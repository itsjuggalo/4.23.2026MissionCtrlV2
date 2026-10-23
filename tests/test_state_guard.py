"""state_guard — every digest / sender state read carries a max age from fact_policies.json (script standard #4)."""
import json
import os
import sqlite3
import sys
from datetime import datetime, timedelta
from pathlib import Path
from zoneinfo import ZoneInfo

sys.path.insert(0, str(Path(__file__).resolve().parents[1]))
import state_guard as sg  # noqa: E402

ET = ZoneInfo("America/New_York")
FRI_1300 = datetime(2026, 10, 23, 13, 0, tzinfo=ET)        # regular session
SAT_1000 = datetime(2026, 10, 24, 10, 0, tzinfo=ET)        # market closed


def _w(p: Path, doc) -> Path:
    p.write_text(json.dumps(doc))
    return p


def test_document_as_of_decides_and_stale_doc_is_never_returned(tmp_path):
    f = _w(tmp_path / "a.json", {"generated_at": "2026-09-30T14:45:01-04:00", "tickers": {"SPY": {}}})
    r = sg.read_state(f, "flow_agg", as_of="generated_at", now=FRI_1300)
    assert r.status == "STALE" and r.doc is None and r.raw["tickers"] and r.basis == "document as_of"
    assert "STALE under flow_agg" in r.reason
    f2 = _w(tmp_path / "b.json", {"generated_at": "2026-10-23T12:50:00-04:00"})
    r2 = sg.read_state(f2, "flow_agg", as_of="generated_at", now=FRI_1300)
    assert r2.ok and r2.doc == {"generated_at": "2026-10-23T12:50:00-04:00"}


def test_mtime_basis_and_session_awareness(tmp_path):
    f = _w(tmp_path / "c.json", {"x": 1})
    t = (FRI_1300 - timedelta(minutes=10)).timestamp()
    os.utime(f, (t, t))
    assert sg.read_state(f, "flow_agg", now=FRI_1300).status == "DELAYED"
    t = datetime(2026, 10, 23, 15, 59, tzinfo=ET).timestamp()
    os.utime(f, (t, t))
    assert sg.read_state(f, "flow_agg", now=SAT_1000).ok, "the last session's file is EOD on Saturday, not stale"
    t = datetime(2026, 10, 22, 15, 59, tzinfo=ET).timestamp()
    os.utime(f, (t, t))
    assert sg.read_state(f, "flow_agg", now=SAT_1000).status == "STALE", "Thursday's file on Saturday is stale"


def test_missing_bad_and_unknown_policy_fail_closed(tmp_path):
    assert sg.read_state(tmp_path / "nope.json", "flow_agg").status == "UNAVAILABLE"
    (tmp_path / "bad.json").write_text("{")
    assert sg.read_state(tmp_path / "bad.json", "flow_agg").status == "ERROR"
    f = _w(tmp_path / "d.json", {"t": "2026-10-23T12:59:00-04:00"})
    assert sg.read_state(f, "no_such_policy", as_of="t", now=FRI_1300).status == "ERROR"
    assert sg.read_state(f, "flow_agg", as_of="missing_key", now=FRI_1300).status == "UNAVAILABLE"


def test_required_input_raises_the_loud_alert_dry_run(tmp_path, capsys):
    f = _w(tmp_path / "e.json", {"generated_at": "2026-09-30T14:45:01-04:00"})
    sg.read_state(f, "flow_agg", name="test input", as_of="generated_at", required=True, now=FRI_1300, dry_run=True)
    out = capsys.readouterr().out
    assert "test input" in out and str(f) in out


def test_sqlite_status_reads_utc_text_times(tmp_path):
    db = tmp_path / "x.db"
    con = sqlite3.connect(db)
    con.execute("create table t (tagged_at text)")
    con.execute("insert into t values ('2026-06-11 05:00:17')")
    con.commit(); con.close()
    r = sg.sqlite_status(db, "select max(tagged_at) from t", "factor_daily", now=FRI_1300)
    assert r.status == "STALE" and r.as_of.startswith("2026-06-11T01:00:17")


def test_flow_picks_iv_map_drops_a_stale_forecast(tmp_path, monkeypatch):
    """2026-10-23: flow_picks_post no longer stamps picks with a 09-30 'Desk IV' read (producer retired)."""
    import json
    import flow_picks_post as F
    p = tmp_path / "iv.json"
    p.write_text(json.dumps({"as_of": "2026-09-30T15:11:19-04:00", "picks": [{"ticker": "SPY"}]}))
    monkeypatch.setattr(F, "IV_FORECAST", p)
    assert F._load_iv_map() == {}


def test_flow_day_files_must_carry_todays_rows(tmp_path):
    """flow_agg ages by session minutes, so yesterday's 16:00 file is '0 min old' at 09:31: its own rows decide."""
    mon_0931 = datetime(2026, 10, 26, 9, 31, tzinfo=ET)
    fri = int(datetime(2026, 10, 23, 15, 59, tzinfo=ET).timestamp() * 1000)
    mon = int(datetime(2026, 10, 26, 9, 30, 30, tzinfo=ET).timestamp() * 1000)
    old = _w(tmp_path / "flow_alerts_today.json", {"X": {"alert": {"Time": fri, "Updated": fri}}})
    os.utime(old, (mon_0931.timestamp() - 30, mon_0931.timestamp() - 30))   # mtime fresh: the age check alone passes
    r = sg.read_state(old, "flow_agg", now=mon_0931)
    assert r.status == "STALE" and r.doc is None and "not the 2026-10-26 session" in r.reason
    mixed = _w(tmp_path / "flow2_alerts_today.json", {"A": {"alert": {"Time": fri}}, "B": {"alert": {"Time": mon}}})
    os.utime(mixed, (mon_0931.timestamp() - 30,) * 2)
    r = sg.read_state(mixed, "flow_agg", now=mon_0931)
    assert r.status == "STALE" and "not reset" in r.reason
    tail = _w(tmp_path / "flow_live_last100.json", {str(fri): {"Time": fri}, str(mon): {"Time": mon}})
    os.utime(tail, (mon_0931.timestamp() - 30,) * 2)
    assert sg.read_state(tail, "flow_agg", now=mon_0931).ok          # a rolling tail only has to END today
    today = _w(tmp_path / "flow_liveflows_today.json", {str(mon): {"Time": mon}})
    os.utime(today, (mon_0931.timestamp() - 30,) * 2)
    assert sg.read_state(today, "flow_agg", now=mon_0931).ok
    mon_0900 = datetime(2026, 10, 26, 9, 0, tzinfo=ET)                     # pre-open: Friday's file is still EOD
    os.utime(old, (mon_0900.timestamp() - 30,) * 2)
    r = sg.read_state(old, "flow_agg", now=mon_0900)
    assert r.ok and r.status == "EOD"
    os.utime(old, (mon_0931.timestamp() - 30,) * 2)
    other = _w(tmp_path / "ctx_today.json", {"generated_at": "x"})       # no rows with times → no day verdict
    os.utime(other, (mon_0931.timestamp() - 30,) * 2)
    assert sg.read_state(other, "flow_agg", now=mon_0931).ok
