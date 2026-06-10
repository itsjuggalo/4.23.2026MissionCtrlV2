#!/usr/bin/env python3
"""Dependency-free CDP screenshotter: launch headless Chrome, wait, capture.
Usage: cdp_shot.py URL OUT.png [W H] [WAIT_S]
Lets client-side fetches resolve (real navigation, no virtual-time stall)."""
import sys, os, json, socket, base64, hashlib, struct, time, subprocess, urllib.request, signal

url, out = sys.argv[1], sys.argv[2]
W = int(sys.argv[3]) if len(sys.argv) > 3 else 420
H = int(sys.argv[4]) if len(sys.argv) > 4 else 900
WAIT = float(sys.argv[5]) if len(sys.argv) > 5 else 4.0
PORT = 9222
UDD = "/tmp/cdp_shot_profile"

import shutil
shutil.rmtree(UDD, ignore_errors=True)  # fresh profile every run
chrome = subprocess.Popen([
    "google-chrome", "--headless=new", "--disable-gpu", "--no-sandbox",
    "--hide-scrollbars", "--force-device-scale-factor=1",
    f"--window-size={W},{H}", f"--remote-debugging-port={PORT}",
    f"--user-data-dir={UDD}", "about:blank"],
    stdout=subprocess.DEVNULL, stderr=subprocess.DEVNULL)

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
    raise RuntimeError("no page target")

ws_url = get_ws()
# parse ws://host:port/path
hostport, path = ws_url[5:].split("/", 1)
host, port = hostport.split(":")
path = "/" + path
s = socket.create_connection((host, int(port)))
key = base64.b64encode(os.urandom(16)).decode()
s.sendall(("GET %s HTTP/1.1\r\nHost: %s:%s\r\nUpgrade: websocket\r\nConnection: Upgrade\r\n"
           "Sec-WebSocket-Key: %s\r\nSec-WebSocket-Version: 13\r\n\r\n" % (path, host, port, key)).encode())
# read handshake response headers
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
    masked = bytes(b ^ mask[i % 4] for i, b in enumerate(payload))
    s.sendall(bytes(hdr) + masked)

def recv_exact(n):
    d = b""
    while len(d) < n:
        c = s.recv(n - len(d))
        if not c: raise RuntimeError("socket closed")
        d += c
    return d

def recv_msg():
    while True:
        out_payload = b""
        while True:
            b0, b1 = recv_exact(2)
            fin = b0 & 0x80; opcode = b0 & 0x0f
            ln = b1 & 0x7f
            if ln == 126: ln = struct.unpack(">H", recv_exact(2))[0]
            elif ln == 127: ln = struct.unpack(">Q", recv_exact(8))[0]
            out_payload += recv_exact(ln)
            if fin: break
        if opcode in (1, 2):
            return out_payload.decode("utf-8", "replace")
        # ignore ping/pong/close-ish control frames

mid = 0
def call(method, params=None, wait=True):
    global mid
    mid += 1; my = mid
    send({"id": my, "method": method, "params": params or {}})
    if not wait: return None
    while True:
        msg = json.loads(recv_msg())
        if msg.get("id") == my:
            return msg

call("Page.enable")
call("Network.enable")
# PWA service worker can serve a stale dev shell (404'd CSS hash => unstyled).
# Bypass it, then navigate so styles load normally and client fetches resolve.
call("Network.setBypassServiceWorker", {"bypass": True})
call("Page.navigate", {"url": url})
time.sleep(WAIT)  # let CSS + client fetch + render settle
res = call("Page.captureScreenshot", {"format": "png", "captureBeyondViewport": True,
           "clip": {"x": 0, "y": 0, "width": W, "height": H, "scale": 1}})
data = res.get("result", {}).get("data")
if not data:
    print("ERR", json.dumps(res)[:300]); chrome.terminate(); sys.exit(1)
open(out, "wb").write(base64.b64decode(data))
print("OK", out, os.path.getsize(out), "bytes")
try: chrome.terminate()
except Exception: pass
