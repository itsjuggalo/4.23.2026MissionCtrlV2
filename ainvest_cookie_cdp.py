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
import os, re, subprocess, sys, time, urllib.request
from pathlib import Path

sys.path.insert(0, str(Path.home() / "scripts"))
import aime_client  # noqa: E402

CHROME = "/mnt/c/Program Files/Google/Chrome/Application/chrome.exe"
PROFILE_WIN = r"C:\Users\itsju\AppData\Local\ainvest-profile"
COOKIE_FILE = Path.home() / ".openclaw/secrets/ainvest_cookie.txt"
def _host():
    """Windows Chrome's CDP is reached via the WSL default gateway (NAT networking), else localhost."""
    try:
        gw = subprocess.run(["ip", "route", "show", "default"], capture_output=True, text=True).stdout.split()[2]
    except Exception:
        gw = None
    return [h for h in ("127.0.0.1", gw) if h]


URLS = ["https://www.ainvest.com", "https://tech.ainvest.com", "https://ainvest.com"]


def cdp_up(port, wait=0):
    """Returns the reachable host, or None."""
    for _ in range(max(1, wait)):
        for h in _host():
            try:
                urllib.request.urlopen(f"http://{h}:{port}/json/version", timeout=3).read(); return h
            except Exception:
                pass
        time.sleep(1)
    return None


def _ws(host, port):
    """Chrome advertises ws://127.0.0.1:…; from WSL that must point at the reachable host."""
    import json
    v = json.load(urllib.request.urlopen(f"http://{host}:{port}/json/version", timeout=5))
    return re.sub(r"^ws://[^/]+", f"ws://{host}:{port}", v["webSocketDebuggerUrl"])


def capture(host, port):
    """Raw CDP (browser target): optionally open AInvest so it re-issues the session, then Storage.getCookies."""
    import json, websocket
    ws = websocket.create_connection(_ws(host, port), timeout=30, suppress_origin=True)
    n = [0]

    def call(method, **params):
        n[0] += 1; ws.send(json.dumps({"id": n[0], "method": method, "params": params}))
        while True:
            msg = json.loads(ws.recv())
            if msg.get("id") == n[0]: return msg.get("result", {})
    try:
        if port != 9333:   # headless refresh: touch AInvest so the site refreshes its session cookies
            tid = call("Target.createTarget", url="https://www.ainvest.com/")["targetId"]
            time.sleep(8); call("Target.closeTarget", targetId=tid)
        cookies = [c for c in call("Storage.getCookies").get("cookies", []) if c["domain"].lstrip(".").endswith("ainvest.com")]
    finally:
        ws.close()
    seen, parts = set(), []
    for c in sorted(cookies, key=lambda c: c["domain"].startswith(".")):   # host-specific first
        if c["name"] not in seen:
            seen.add(c["name"]); parts.append(f"{c['name']}={c['value']}")
    return "; ".join(parts), seen


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
        host = cdp_up(port, wait=30)
        if not host:
            print(f"CDP :{port} not reachable" + ("" if refresh else " — run ~/bin/ainvest-view-launch.sh first")); return 2
        header, names = capture(host, port)
    finally:
        if proc:
            subprocess.run(["/mnt/c/Windows/System32/WindowsPowerShell/v1.0/powershell.exe", "-NoProfile", "-Command",
                            f"Get-CimInstance Win32_Process -Filter \"name='chrome.exe'\" | Where-Object {{ $_.CommandLine -like '*remote-debugging-port={port}*' }} | ForEach-Object {{ Stop-Process -Id $_.ProcessId -Force }}"],
                           stdout=subprocess.DEVNULL, stderr=subprocess.DEVNULL, timeout=30)
    ok, why = healthy_with(header)
    print(f"cookies {len(names)} (sess_tk={'sess_tk' in names}, userid={'userid' in names}) · AIME {'OK' if ok else 'REFUSED: ' + why}")
    if not ok: return 1
    tmp = COOKIE_FILE.with_suffix(".tmp")
    tmp.write_text(header); os.chmod(tmp, 0o600); tmp.replace(COOKIE_FILE)
    print("wrote", COOKIE_FILE.name)
    return 0


if __name__ == "__main__":
    sys.exit(main())
