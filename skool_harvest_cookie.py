#!/usr/bin/env python3
"""Harvest the skool.com auth_token cookie from the CDP-bridged Windows Chrome
and write it into skool-pp-cli's config.toml. Reads cookies via the browser-level
Storage.getCookies CDP command (no page needed). Never prints the token value."""
import json, os, subprocess, sys, websocket  # websocket-client

GW = open("/tmp/skool_bridge_env").read().strip().split("=", 1)[1] if os.path.exists("/tmp/skool_bridge_env") else \
     subprocess.check_output("ip route show default | awk '{print $3}'", shell=True, text=True).strip()
BASE = f"http://{GW}:9223"
CFG_DIR = os.path.expanduser("~/.config/skool-pp-cli")
CFG = os.path.join(CFG_DIR, "config.toml")

def ws_url():
    import urllib.request
    v = json.load(urllib.request.urlopen(f"{BASE}/json/version", timeout=5))
    return v["webSocketDebuggerUrl"].replace("ws://127.0.0.1:9222", f"ws://{GW}:9223").replace("ws://localhost:9222", f"ws://{GW}:9223")

def get_cookies():
    w = websocket.create_connection(ws_url(), max_size=None, timeout=15)
    w.send(json.dumps({"id": 1, "method": "Storage.getCookies"}))
    while True:
        msg = json.loads(w.recv())
        if msg.get("id") == 1:
            w.close()
            return msg.get("result", {}).get("cookies", [])

def main():
    cookies = get_cookies()
    skool = [c for c in cookies if "skool.com" in (c.get("domain") or "")]
    auth = next((c for c in skool if c.get("name") == "auth_token"), None)
    if not auth or not auth.get("value"):
        print(f"NO_AUTH_TOKEN  (found {len(skool)} skool cookies: {sorted(set(c['name'] for c in skool))})")
        sys.exit(2)
    token = auth["value"]
    os.makedirs(CFG_DIR, exist_ok=True)
    # schema decoded from binary: [credentials] access_token + base_url; [template_vars] community
    cfg = (
        ""
        f'access_token = "{token}"\n'
        'auth_header = "Cookie"\n'
        'base_url = "https://www.skool.com"\n'
    )
    with open(CFG, "w") as f:
        f.write(cfg)
    os.chmod(CFG, 0o600)
    print(f"WROTE {CFG}  (auth_token len={len(token)}, masked …{token[-6:]})")

if __name__ == "__main__":
    main()
