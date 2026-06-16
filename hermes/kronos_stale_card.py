#!/home/itsju/.venv/bin/python3
"""Kronos cache freshness → StarCraft card to #devops (as Hermes).

Mirrors hermes.sh's staleness scan, but posts a glanceable card instead of the
73-ticker wall of "Stale: AAOI(3889886s) ALK(926090s) ...".

Exit codes (so hermes.sh can fall back to its curl embed):
  0  handled  — card posted, OR nothing stale (matches hermes: only alerts on stale)
  1  failed   — stale found but card render/post failed → caller should fall back
"""
import glob
import os
import sys
import time

CACHE_DIR = os.path.expanduser("~/.openclaw/workspace/directives/kronos_forecasts")
STALE_LIMIT = 1800  # 30 min — same as hermes.sh
WEBHOOK = "discord_webhook_autofix"  # secrets basename (same channel hermes uses)


def _age_str(a):
    if a >= 86400:
        return f"{a / 86400:.0f}d"
    if a >= 3600:
        return f"{a / 3600:.0f}h"
    return f"{a / 60:.0f}m"


def main():
    if not os.path.isdir(CACHE_DIR):
        return 1
    now = time.time()
    stale = []   # (ticker, age_s)
    fresh = 0
    for f in glob.glob(os.path.join(CACHE_DIR, "latest_*.json")):
        try:
            age = now - os.stat(f).st_mtime
        except OSError:
            continue
        tkr = os.path.basename(f)[len("latest_"):-len(".json")]
        if age > STALE_LIMIT:
            stale.append((tkr, age))
        else:
            fresh += 1

    total = len(stale) + fresh
    if not stale:
        return 0  # nothing to alert (hermes only posts when stale)

    # Discord disabled 2026-06-16 (Mike: ops/dev noise off Discord). Kronos-stale is
    # dev-infra, not trading/politics. Return 0 (success) so hermes.sh ALSO skips its
    # text-embed fallback. Detection still runs; nothing is posted to Discord.
    return 0

    sys.path.insert(0, os.path.expanduser("~/05_AUTOMATION/scripts/lib"))
    try:
        import ops_card
    except Exception:
        return 1

    stale.sort(key=lambda x: -x[1])
    oldest_t, oldest_a = stale[0]
    fresh_pct = (fresh / total * 100) if total else 0
    sev = "crit" if fresh_pct < 50 else "warn"
    rows = [
        {"label": "Stale models", "value": str(len(stale)), "state": "crit"},
        {"label": "Fresh models", "value": str(fresh), "state": "good" if fresh else "warn"},
        {"label": "Oldest", "value": f"{oldest_t} · {_age_str(oldest_a)}", "state": "warn"},
    ]
    top = ", ".join(f"{t} {_age_str(a)}" for t, a in stale[:10])
    spec = {
        "bot": "HERMES", "username": "Hermes", "title": "KRONOS FRESHNESS",
        "glyph": "gauge", "status": sev, "status_text": f"{100 - fresh_pct:.0f}% STALE",
        "rows": rows,
        "bars": [{"label": "Cache freshness", "pct": fresh_pct, "state": sev,
                  "note": f"{fresh} / {total} fresh"}],
        "sections": [{"label": "Stale (oldest first)", "items": [top]}],
        "footer": "kronos cache monitor",
    }
    summary = f":warning: **Kronos cache stale** — {len(stale)} stale / {fresh} fresh"
    try:
        res = ops_card.render_and_post(spec, WEBHOOK, summary)
    except Exception:
        return 1
    return 0 if res.startswith("card:") else 1


if __name__ == "__main__":
    sys.exit(main())
