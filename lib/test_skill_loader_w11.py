"""MC-AUD-120 (W11): archived folders never pooled, truncation + unreadable visible, reference-only label."""
import importlib.machinery
import importlib.util
from pathlib import Path

_loader = importlib.machinery.SourceFileLoader("skill_loader_py", str(Path(__file__).with_name("skill_loader_py")))
_spec = importlib.util.spec_from_loader("skill_loader_py", _loader)
sl = importlib.util.module_from_spec(_spec)
_loader.exec_module(sl)


def _mk(root, folder, name, body):
    d = root / folder / name
    d.mkdir(parents=True)
    (d / "SKILL.md").write_text(body)


def test_pool_and_labels(tmp_path, monkeypatch):
    monkeypatch.setattr(sl, "SKILLS_ROOT", tmp_path)
    monkeypatch.setattr(sl, "PER_SKILL_CHAR_CAP", 100)
    _mk(tmp_path, "boba", "options-greeks", "---\nname: options-greeks\ndescription: options delta gamma\n---\n" + "delta " * 60)
    _mk(tmp_path, "boba", "_archive-options", "---\nname: arch\ndescription: options delta\n---\nold")
    _mk(tmp_path, "_archive", "options-old", "---\nname: old\ndescription: options\n---\nold")
    _mk(tmp_path, "boba", "empty", "   ")
    block, meta = sl.load_relevant_skills_with_meta("boba", "options delta", max_tokens=4000,
                                                    extra_folders=("_archive",))
    assert meta["skills_loaded"] == ["options-greeks"]
    assert meta["truncated"] == ["options-greeks"] and "truncated: first 100 of" in block
    assert any(p.endswith("empty/SKILL.md") for p in meta["unreadable"])
    assert "Reference methodology only" in block and "file date" in block and "arch" not in meta["skills_loaded"]
