#!/usr/bin/env bash
# Persist the live wallets response (real-money accounts only — paper
# accounts excluded) to ~/portfolio/portfolio_snapshot.json. Driven by
# portfolio-snapshot.timer so the file stays fresh as prices fluctuate.
set -u
exec /usr/bin/python3 - "$HOME/portfolio/portfolio_snapshot.json" <<'PY'
import json
import sys
import urllib.request

OUT = sys.argv[1]
try:
    with urllib.request.urlopen("http://127.0.0.1:3000/api/wallets", timeout=60) as r:
        wallets = json.load(r)
except Exception as e:
    print(f"[portfolio-snapshot] fetch failed: {e}", file=sys.stderr)
    sys.exit(1)

real = [w for w in wallets if (w.get("badge") or "").upper() != "PAPER"]
with open(OUT + ".tmp", "w") as f:
    json.dump(real, f, indent=2)
import os
os.replace(OUT + ".tmp", OUT)
print(f"[portfolio-snapshot] wrote {len(real)} real-money wallets "
      f"(of {len(wallets)} total) to {OUT}")
PY
