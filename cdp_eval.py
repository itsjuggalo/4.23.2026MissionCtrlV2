#!/usr/bin/env python3
"""cdp_eval.py — run JavaScript inside a real headless Chrome page and print the result.

The read-only twin of aries_cdp_shot.py (which captures pixels; this one captures
VALUES). Written 2026-07-19 to verify client-rendered Mission Control pages: the
dashboards fetch their data in the browser, so `curl | grep` sees an empty shell and
proves nothing. This drives an actual page and reports what the DOM really says.

Dependency-free — raw CDP over a hand-rolled websocket, stdlib only, same as
aries_cdp_shot.py. No node, no puppeteer, no pip install.

USAGE
  cdp_eval.py URL 'JS_EXPRESSION' [WAIT_S]

  JS_EXPRESSION is evaluated in the page and its value printed as JSON. Async is
  supported (the promise is awaited), so you can click, sleep, and then read.
  Return a string (JSON.stringify(...)) for anything non-scalar — the CDP bridge
  only marshals JSON-serializable values.

OPTIONS (env vars, so they compose in a pipeline)
  CDP_INIT   JS injected BEFORE any page script runs, on every navigation.
             This is the interesting one — see "Faking the clock" below.
  CDP_PORT   remote-debugging port (default 9333; aries_cdp_shot.py uses 9222,
             so both can run at once)
  CDP_W      viewport width  (default 1440)
  CDP_H      viewport height (default 2200)
  CDP_KEEP   set to 1 to reuse the profile dir instead of wiping it — keeps
             cookies/logins between runs. Default wipes for a clean slate.

EXAMPLES

  # Is the element there, and what does it say?
  cdp_eval.py http://localhost:3000/dashboard?page=Performance \\
    'JSON.stringify({found: document.body.innerText.includes("PROMOTION GATE")})'

  # Expand a collapsed section first, then read it.
  cdp_eval.py http://localhost:3000/dashboard?page=command-center '(async()=>{
     const sleep=ms=>new Promise(r=>setTimeout(r,ms));
     [...document.querySelectorAll("*")].filter(e=>/LIVE CHART/.test(e.textContent||"")).pop().click();
     await sleep(6000);
     return JSON.stringify([...document.querySelectorAll(".flow-row")].map(e=>e.title).slice(0,3));
   })()' 14

FAKING THE CLOCK (the reason this script exists)
  Time-dependent UI is normally only testable at the right time of day. CDP_INIT
  runs before the page's own scripts, so you can replace Date and prove a branch
  that won't happen for days:

    export CDP_INIT='(()=>{const F=new Date("2026-07-20T15:00:00Z").getTime();
      const R=Date; class D extends R{constructor(...a){a.length?super(...a):super(F);}
      static now(){return F;}} D.parse=R.parse; D.UTC=R.UTC; window.Date=D;})();'

  That froze the Command Center at Mon 11:00 ET on a Sunday night to confirm the
  chart really swaps BTC→SPY during regular trading hours. Note it only fakes the
  PAGE's clock — server responses still carry real timestamps, so this proves
  render logic, never end-to-end behavior.

BROWSER SAFETY
  Always launches its own throwaway --user-data-dir (/tmp/cdp_eval_profile).
  It never touches Mike's real Chrome profile, logins, or settings.

EXIT CODES
  0 ok · 1 evaluation threw or returned nothing · 2 could not reach Chrome
"""
import sys, os, json, socket, base64, struct, time, subprocess, urllib.request, shutil

if len(sys.argv) < 3 or sys.argv[1] in ("-h", "--help"):
    print(__doc__)
    sys.exit(0)

url, expr = sys.argv[1], sys.argv[2]
WAIT = float(sys.argv[3]) if len(sys.argv) > 3 else 9.0
PORT = int(os.environ.get("CDP_PORT", "9333"))
W = int(os.environ.get("CDP_W", "1440"))
H = int(os.environ.get("CDP_H", "2200"))
INIT = os.environ.get("CDP_INIT")
UDD = "/tmp/cdp_eval_profile"

if os.environ.get("CDP_KEEP") != "1":
    shutil.rmtree(UDD, ignore_errors=True)  # fresh profile every run

chrome = subprocess.Popen([
    "google-chrome", "--headless=new", "--disable-gpu", "--no-sandbox",
    "--hide-scrollbars", "--force-device-scale-factor=1",
    f"--window-size={W},{H}", f"--remote-debugging-port={PORT}",
    f"--user-data-dir={UDD}", "about:blank"],
    stdout=subprocess.DEVNULL, stderr=subprocess.DEVNULL)


def cleanup():
    try:
        chrome.terminate()
        chrome.wait(timeout=5)
    except Exception:
        try:
            chrome.kill()
        except Exception:
            pass


def get_ws():
    for _ in range(50):
        try:
            data = json.load(urllib.request.urlopen(f"http://127.0.0.1:{PORT}/json/list", timeout=1))
            for t in data:
                if t.get("type") == "page" and t.get("webSocketDebuggerUrl"):
                    return t["webSocketDebuggerUrl"]
        except Exception:
            pass
        time.sleep(0.2)
    return None


ws_url = get_ws()
if not ws_url:
    print(f"ERR: no Chrome page target on port {PORT} — is another instance holding it?", file=sys.stderr)
    cleanup()
    sys.exit(2)

hostport, path = ws_url[5:].split("/", 1)
host, port = hostport.split(":")
s = socket.create_connection((host, int(port)))
key = base64.b64encode(os.urandom(16)).decode()
s.sendall((f"GET /{path} HTTP/1.1\r\nHost: {host}:{port}\r\nUpgrade: websocket\r\n"
           f"Connection: Upgrade\r\nSec-WebSocket-Key: {key}\r\n"
           f"Sec-WebSocket-Version: 13\r\n\r\n").encode())
buf = b""
while b"\r\n\r\n" not in buf:
    buf += s.recv(4096)


def send(obj):
    payload = json.dumps(obj).encode()
    hdr = bytearray([0x81])  # FIN + text
    n = len(payload)
    mask = os.urandom(4)
    if n < 126:
        hdr.append(0x80 | n)
    elif n < 65536:
        hdr.append(0x80 | 126); hdr += struct.pack(">H", n)
    else:
        hdr.append(0x80 | 127); hdr += struct.pack(">Q", n)
    hdr += mask
    s.sendall(bytes(hdr) + bytes(b ^ mask[i % 4] for i, b in enumerate(payload)))


def recv_exact(n):
    d = b""
    while len(d) < n:
        c = s.recv(n - len(d))
        if not c:
            raise RuntimeError("socket closed")
        d += c
    return d


def recv_msg():
    while True:
        out = b""
        while True:
            b0, b1 = recv_exact(2)
            fin, opcode = b0 & 0x80, b0 & 0x0F
            ln = b1 & 0x7F
            if ln == 126:
                ln = struct.unpack(">H", recv_exact(2))[0]
            elif ln == 127:
                ln = struct.unpack(">Q", recv_exact(8))[0]
            out += recv_exact(ln)
            if fin:
                break
        if opcode in (1, 2):
            return out.decode("utf-8", "replace")
        # ignore ping/pong/close control frames


mid = 0


def call(method, params=None, wait=True):
    global mid
    mid += 1
    my = mid
    send({"id": my, "method": method, "params": params or {}})
    if not wait:
        return None
    while True:
        msg = json.loads(recv_msg())
        if msg.get("id") == my:
            return msg


try:
    call("Page.enable")
    call("Runtime.enable")
    call("Network.enable")
    # A stale PWA service worker can serve an old shell (404'd CSS hash → unstyled,
    # wrong markup). Bypass it so we evaluate against the build actually on disk.
    call("Network.setBypassServiceWorker", {"bypass": True})
    if INIT:
        call("Page.addScriptToEvaluateOnNewDocument", {"source": INIT})
    call("Page.navigate", {"url": url})
    time.sleep(WAIT)  # let CSS + client fetches + render settle

    res = call("Runtime.evaluate",
               {"expression": expr, "returnByValue": True, "awaitPromise": True})
    result = res.get("result", {})

    # Surface page-side errors instead of printing a bare null and looking like a pass.
    if result.get("exceptionDetails"):
        exc = result["exceptionDetails"]
        desc = (exc.get("exception") or {}).get("description") or exc.get("text")
        print(f"ERR: expression threw — {desc}", file=sys.stderr)
        sys.exit(1)

    value = result.get("result", {}).get("value")
    if value is None:
        print("ERR: expression returned undefined/null "
              "(remember to JSON.stringify non-scalars)", file=sys.stderr)
        sys.exit(1)

    # If the page handed back JSON, pretty-print it; otherwise print as-is.
    try:
        print(json.dumps(json.loads(value), indent=1, ensure_ascii=False))
    except (TypeError, ValueError):
        print(value if isinstance(value, str) else json.dumps(value, indent=1, ensure_ascii=False))
finally:
    cleanup()
