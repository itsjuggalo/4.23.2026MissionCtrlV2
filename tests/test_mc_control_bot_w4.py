"""MC-AUD-005 (audit W4): the dormant control bot only obeys fresh owner messages and never runs a shell by default."""
import importlib
import sys
import time
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parents[1]))


def load(monkeypatch, shell=None):
    if shell is None:
        monkeypatch.delenv("MC_CONTROL_SHELL", raising=False)
    else:
        monkeypatch.setenv("MC_CONTROL_SHELL", shell)
    import mc_control_bot as B
    B = importlib.reload(B)
    monkeypatch.setattr(B, "CHAT", "111")
    ran = []
    monkeypatch.setattr(B, "run", lambda cmd, timeout=0: ran.append(cmd) or "ran")
    return B, ran


def msg(chat="111", sender="111", ctype="private", age=0, text="/time"):
    return {"chat": {"id": int(chat), "type": ctype}, "from": {"id": int(sender)}, "date": time.time() - age, "text": text}


def test_only_fresh_owner_private_messages_pass(monkeypatch):
    B, _ = load(monkeypatch)
    assert B.reject_reason(msg()) is None
    assert B.reject_reason(msg(sender="999")) == "sender is not the owner"
    assert B.reject_reason(msg(chat="222")) == "not the owner's private chat"
    assert B.reject_reason(msg(ctype="group")) == "not the owner's private chat"
    assert B.reject_reason(msg(age=B.STALE_S + 5)) == "stale"


def test_shell_is_off_by_default_and_bare_text_never_runs(monkeypatch):
    B, ran = load(monkeypatch)
    assert "shell is off" in B.handle("/sh rm -rf ~")
    assert "unknown command" in B.handle("rm -rf ~; echo pwned")
    assert ran == []


def test_restart_allowlist_and_quoting(monkeypatch):
    B, ran = load(monkeypatch)
    assert "usage" in B.handle("/restart missionctrl; reboot")
    B.handle("/reject 7;reboot because")
    assert ran and "'7;reboot'" in ran[-1]


def test_shell_only_with_explicit_opt_in(monkeypatch):
    B, ran = load(monkeypatch, shell="1")
    B.handle("/sh echo hi")
    assert ran == ["echo hi"]
