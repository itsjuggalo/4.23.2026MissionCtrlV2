"""_load() must survive a stream file that parses to a non-dict (empty feed node = JSON string).

Run: ~/.venv/bin/python -m pytest -q -p no:anyio tests/test_flow_picks_load.py
"""
import json
import sys
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parents[1]))
import flow_picks_post as F  # noqa: E402


def test_load_skips_non_dict_stream_files(tmp_path, monkeypatch):
    (tmp_path / "a.json").write_text('""')        # 2-byte empty-feed file
    (tmp_path / "b.json").write_text("[]")
    (tmp_path / "c.json").write_text(json.dumps({"k1": {"alert": {"OptionSymbol": "AAA", "totalFlowValue": 5}}}))
    monkeypatch.setattr(F, "DATA", tmp_path)
    monkeypatch.setattr(F, "FILES", ["a.json", "b.json", "c.json", "missing.json"])
    out = F._load()
    assert list(out) == ["AAA"]
