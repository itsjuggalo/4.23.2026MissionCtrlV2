"""Shared `/guest` handler — mint a temp dashboard-access link for someone.

Imported by every conversational bot so `/guest [duration] [name]` behaves IDENTICALLY
no matter which bot Mike happens to DM. One tap-link logs the guest into all three
dashboards (host-scoped mc_access cookie = SSO) until it auto-expires.

Owner-gating is the CALLER's job — each bot already drops non-owner messages before
dispatch. Keep this module owner-agnostic.

Link host = `~/.openclaw/secrets/mc-guest-base` if set (e.g. a public URL once exposure
is enabled), else the Tailscale IP (works for tailnet guests today).
"""
import re
import subprocess
from pathlib import Path

SECRETS = Path.home() / ".openclaw/secrets"
MC_GRANT = str(Path.home() / "bin/mc-grant")


def _base() -> str:
    try:
        b = (SECRETS / "mc-guest-base").read_text().strip()
        if b:
            return b.rstrip("/")
    except Exception:
        pass
    return "http://100.91.39.122:3000"  # tailscale default (any port unlocks all 3)


def mint(text: str) -> str:
    """`text` = the full '/guest ...' message. Returns the reply string to send."""
    args = text.split()[1:]
    dur, label = "24h", "guest"
    if args:
        if re.fullmatch(r"\d+[smhdSMHD]?", args[0]):
            dur = args[0]
            label = " ".join(args[1:]) or "guest"
        else:
            label = " ".join(args) or "guest"
    try:
        r = subprocess.run([MC_GRANT, dur, label], capture_output=True, text=True, timeout=20)
    except Exception as e:
        return f"[guest error] {e}"
    lines = r.stdout.splitlines()
    token = next((l.split(":", 1)[1].strip() for l in lines if l.startswith("Token:")), "")
    expln = next((l for l in lines if "expires" in l), "").strip()
    if not token:
        return f"⚠️ guest mint failed:\n{(r.stdout + r.stderr).strip()[:500]}"
    link = f"{_base()}/api/mc-login?guest={token}"
    return (
        f'🔑 Guest access for "{label}"\n{expln}\n\n'
        f"Forward this — one tap logs them into all 3 dashboards until it expires:\n{link}"
    )
