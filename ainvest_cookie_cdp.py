#!/usr/bin/env python3
"""AInvest cookie from Mike's DEDICATED isolated Chrome profile (Google sign-in), via CDP.

The AIME account is a Google sign-in, so the emailed-code login (ainvest_login.js) reaches a
different account that AIME refuses. Mike signs in ONCE in the isolated profile
(~/bin/ainvest-view-launch.sh, profile C:\\Users\\itsju\\AppData\\Local\\ainvest-profile,
never his default Chrome profile). This script then reads the AInvest cookies from that profile,
checks AIME actually answers with them, and only then replaces ~/.openclaw/secrets/ainvest_cookie.txt (600).

  ainvest_cookie_cdp.py            # capture from the open window (CDP :9333)
  ainvest_cookie_cdp.py --refresh  # self-renew: open the same profile headless (CDP :9347), capture, close
Never prints cookie values. Exit 0 = cookie written and AIME healthy.
"""
import os, re, subprocess, sys, time
from pathlib import Path

sys.path.insert(0, str(Path.home() / "scripts"))
import aime_client  # noqa: E402

CHROME = "/mnt/c/Program Files/Google/Chrome/Application/chrome.exe"
PROFILE_WIN = r"C:\Users\itsju\AppData\Local\ainvest-profile"
COOKIE_FILE = Path.home() / ".openclaw/secrets/ainvest_cookie.txt"
PS = "/mnt/c/Windows/System32/WindowsPowerShell/v1.0/powershell.exe"
PS_SCRIPT = Path.home() / "scripts/ainvest_cdp_cookies.ps1"


def capture(port, touch, wait=30):
    """Cookies via a Windows-side PowerShell CDP client on 127.0.0.1 (Chrome's debug port is never exposed).
    Returns (Cookie header, names) or (None, error text)."""
    win = subprocess.run(["wslpath", "-w", str(PS_SCRIPT)], capture_output=True, text=True).stdout.strip()
    err = ""
    for _ in range(max(1, wait // 3)):
        r = subprocess.run([PS, "-NoProfile", "-ExecutionPolicy", "Bypass", "-File", win, "-Port", str(port)] + (["-Touch"] if touch else []),
                           capture_output=True, text=True, timeout=90)
        out = r.stdout.strip()
        if r.returncode == 0 and out.startswith("["):
            import json
            cookies = json.loads(out)
            seen, parts = set(), []
            for c in sorted(cookies, key=lambda c: c["domain"].startswith(".")):   # host-specific first
                if c["name"] not in seen:
                    seen.add(c["name"]); parts.append(f"{c['name']}={c['value']}")
            return "; ".join(parts), seen
        err = (r.stderr.strip().splitlines() or ["no output"])[0][:120]
        time.sleep(3)
    return None, err


def healthy_with(header):
    m = re.search(r"(?:^|;\s*)userid=([^;]+)", header)
    if not m: return False, "no userid cookie (not signed in?)"
    old = aime_client._cookie
    aime_client._cookie = lambda: header
    try:
        uid, aime_client.USER_ID = aime_client.USER_ID, m.group(1)
        ans = aime_client.ask_aime("Reply with the single word OK.", timeout=90)
    finally:
        aime_client._cookie = old; aime_client.USER_ID = uid
    return (not ans.startswith("[")), ans[:80] if ans.startswith("[") else "answered"


def main():
    refresh = "--refresh" in sys.argv
    port = 9347 if refresh else 9333
    proc = None
    if refresh:
        proc = subprocess.Popen([CHROME, f"--user-data-dir={PROFILE_WIN}", f"--remote-debugging-port={port}",
                                 "--headless=new", "--no-first-run", "--no-default-browser-check", "about:blank"],
                                stdout=subprocess.DEVNULL, stderr=subprocess.DEVNULL)
    try:
        header, names = capture(port, touch=refresh)
    finally:
        if proc:
            subprocess.run([PS, "-NoProfile", "-Command",
                            f"Get-CimInstance Win32_Process -Filter \"name='chrome.exe'\" | Where-Object {{ $_.CommandLine -like '*remote-debugging-port={port}*' }} | ForEach-Object {{ Stop-Process -Id $_.ProcessId -Force }}"],
                           stdout=subprocess.DEVNULL, stderr=subprocess.DEVNULL, timeout=30)
    if header is None:
        print(f"CDP :{port} not readable ({names})" + ("" if refresh else " — run ~/bin/ainvest-view-launch.sh first")); return 2
    ok, why = healthy_with(header)
    print(f"cookies {len(names)} (sess_tk={'sess_tk' in names}, userid={'userid' in names}) · AIME {'OK' if ok else 'REFUSED: ' + why}")
    if not ok: return 1
    tmp = COOKIE_FILE.with_suffix(".tmp")
    tmp.write_text(header); os.chmod(tmp, 0o600); tmp.replace(COOKIE_FILE)
    print("wrote", COOKIE_FILE.name)
    return 0


if __name__ == "__main__":
    sys.exit(main())
