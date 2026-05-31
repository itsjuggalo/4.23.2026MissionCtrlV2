import json

from pipeline.discord.agent_feed import AgentFeed
from pipeline.discord.agent_feed_reader import recent_outcomes, summarize_for_prompt


def _feed(tmp_path):
    return AgentFeed(
        feed_path=tmp_path / "outcomes.json",
        history_path=tmp_path / "outcomes.jsonl",
        max_entries=5,
    )


def test_record_writes_both_snapshot_and_history(tmp_path):
    feed = _feed(tmp_path)
    ok = feed.record({"id": "x1", "type": "closure", "symbol": "TSLA", "outcome_pct": 85})
    assert ok is True
    assert (tmp_path / "outcomes.json").exists()
    assert (tmp_path / "outcomes.jsonl").exists()
    snapshot = json.loads((tmp_path / "outcomes.json").read_text())
    assert len(snapshot) == 1
    assert snapshot[0]["captured_at"]  # auto-filled


def test_dedup_by_id(tmp_path):
    feed = _feed(tmp_path)
    feed.record({"id": "x1", "type": "closure", "symbol": "TSLA"})
    feed.record({"id": "x1", "type": "closure", "symbol": "TSLA"})  # dup
    feed.record({"id": "x2", "type": "closure", "symbol": "NVDA"})
    snapshot = json.loads((tmp_path / "outcomes.json").read_text())
    assert len(snapshot) == 2
    assert {e["id"] for e in snapshot} == {"x1", "x2"}


def test_snapshot_caps_at_max_entries(tmp_path):
    feed = _feed(tmp_path)  # max_entries=5
    for i in range(10):
        feed.record({"id": f"x{i}", "type": "closure", "symbol": "TSLA"})
    snapshot = json.loads((tmp_path / "outcomes.json").read_text())
    assert len(snapshot) == 5
    # most recent kept
    assert {e["id"] for e in snapshot} == {"x5", "x6", "x7", "x8", "x9"}


def test_history_is_append_only(tmp_path):
    feed = _feed(tmp_path)
    for i in range(10):
        feed.record({"id": f"x{i}", "type": "closure", "symbol": "TSLA"})
    history_lines = (tmp_path / "outcomes.jsonl").read_text().strip().split("\n")
    assert len(history_lines) == 10


def test_malformed_entries_rejected(tmp_path):
    feed = _feed(tmp_path)
    assert feed.record({}) is False
    assert feed.record({"id": "x"}) is False  # missing type
    assert feed.record(None) is False  # type: ignore[arg-type]


def test_reader_filters_by_symbol(tmp_path):
    feed = _feed(tmp_path)
    feed.record({"id": "x1", "type": "closure", "symbol": "TSLA"})
    feed.record({"id": "x2", "type": "closure", "symbol": "NVDA"})
    feed.record({"id": "x3", "type": "peak_gain", "symbol": "TSLA"})
    out = recent_outcomes(feed_path=tmp_path / "outcomes.json", symbol="TSLA")
    assert len(out) == 2
    assert all(e["symbol"] == "TSLA" for e in out)


def test_reader_filters_by_type(tmp_path):
    feed = _feed(tmp_path)
    feed.record({"id": "x1", "type": "closure", "symbol": "TSLA"})
    feed.record({"id": "x2", "type": "peak_gain", "symbol": "TSLA"})
    out = recent_outcomes(feed_path=tmp_path / "outcomes.json", type_filter="peak_gain")
    assert len(out) == 1
    assert out[0]["type"] == "peak_gain"


def test_summarize_handles_empty(tmp_path):
    s = summarize_for_prompt(feed_path=tmp_path / "outcomes.json", symbol="TSLA")
    assert "no recent outcomes" in s.lower()


def test_summarize_lists_closures_and_peaks(tmp_path):
    feed = _feed(tmp_path)
    feed.record({"id": "c1", "type": "closure", "symbol": "TSLA",
                 "strike": 480, "opt_type": "C", "outcome_pct": 85,
                 "category": "SCALP"})
    feed.record({"id": "p1", "type": "peak_gain", "symbol": "TSLA",
                 "strike": 480, "opt_type": "C",
                 "threshold_pct": 100, "actual_peak_pct": 123})
    s = summarize_for_prompt(feed_path=tmp_path / "outcomes.json", symbol="TSLA")
    assert "CLOSED TSLA 480C +85%" in s
    assert "PEAK TSLA 480C crossed +100%" in s
