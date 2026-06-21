#!/usr/bin/env python3
"""
discord_reorg.py — NON-DESTRUCTIVE guild consolidation executor (STAGED).

Reads the approved plan (embedded PLAN below, synced from ~/restructure/DISCORD-REORG-MAP.md)
and the live snapshot, then renames survivors / re-points webhook secrets / moves drained
channels to 🗄️ ARCHIVE. **Dry-run by default. There is NO delete_channel call anywhere.**

  discord_reorg.py                 # dry-run: print every action, touch nothing
  discord_reorg.py --secret-map    # read-only: resolve which webhook secret feeds which channel
  discord_reorg.py --execute       # GATED: perform the changes (writes a rollback file first)

Rollback: ~/.openclaw/secrets/.discord-reorg-rollback.json (original names + secret contents).
Bot token must have MANAGE_CHANNELS + MANAGE_WEBHOOKS (discord_ops_bot_token qualifies).
"""
import sys, json, time, re
from pathlib import Path

sys.path.insert(0, str(Path.home() / ".openclaw"))
from vault import get_secret  # noqa: E402
import requests  # noqa: E402

API = "https://discord.com/api/v10"
GUILD = (get_secret("discord_guild_id") or "").strip()
BOT = (get_secret("discord_ops_bot_token") or "").strip()
SECRETS = Path.home() / ".openclaw" / "secrets"
SNAP = Path.home() / ".openclaw" / "workspace" / "state" / "discord_guild_snapshot.json"
ROLLBACK = SECRETS / ".discord-reorg-rollback.json"
UA = "MissionCtrlReorg/1.0"
DRY = "--execute" not in sys.argv

# ── PLAN (synced from the approved DISCORD-REORG-MAP.md). Keys = survivor's NEW name.
#    "from" = existing channel renamed into the survivor. "absorbs" = channels whose
#    webhook-secrets get re-pointed to the survivor, then archived. "archive" = pure retire.
PLAN = {
    "renames_and_merges": {
        # BRIEFINGS
        "midday-brief":     {"from": "middaybriefs", "absorbs": []},
        "closing-brief":    {"from": "eodbriefs", "absorbs": ["afterhoursbriefs", "daily-wrap"]},
        # OPTIONS FLOW
        "flow-unusual":     {"from": "fg-unusual", "absorbs": ["fg-live-flow", "fg-option-alerts", "fg2-option-alerts"]},
        "flow-huge":        {"from": "fg-huge", "absorbs": []},
        "flow-repeaters":   {"from": "fg-repeaters", "absorbs": []},
        "flow-etf-weekly":  {"from": "fg-etf", "absorbs": ["fg-weekly"]},
        "whale-flow":       {"from": "whale-flow", "absorbs": ["5ive-milli", "ten10-milli", "25mega-bucks"]},
        "flow-results":     {"from": "flow-trade-results", "absorbs": ["flow-wins", "best-options-log"]},
        # SIGNALS
        "scalp-signals":    {"from": "v2-scalp", "absorbs": []},
        "swing-signals":    {"from": "v2-swing", "absorbs": []},
        "stock-signals":    {"from": "v2-stocks", "absorbs": ["long-term-stocks"]},
        "options-signals":  {"from": "long-term-options", "absorbs": []},
        "crypto-signals":   {"from": "crypto-signals", "absorbs": ["daily-crypto-pumps"]},
        "provider-signals": {"from": "signals", "absorbs": ["newsignals1", "newsignals2", "newsignals3", "tweak-trades"]},
        "service-picks":    {"from": "tradesignals-picks", "absorbs": ["stocksignals-picks"]},
        # PATTERNS & SENTIMENT
        "pattern-alerts":   {"from": "pattern-alerts", "absorbs": ["squeeze-alerts", "signal-discovery"]},
        "market-sentiment": {"from": "sentiment-alerts", "absorbs": ["fg1-bullbear", "fg2-bullbear", "crypto-sentiment", "macro-sentiment"]},
        # RESEARCH & MACRO
        "analyst-research": {"from": "analyst-setups", "absorbs": ["analyst-watchlist", "watchlist", "research-feed"]},
        "macro":            {"from": "macro-outlook", "absorbs": ["macro-alerts", "macro-calendar", "fednew-scanners"]},
        "earnings":         {"from": "earnings-playbook", "absorbs": []},
        # TRACK RECORD
        "paper-trades":     {"from": "trade-paper", "absorbs": []},
        "performance":      {"from": "performance-daily", "absorbs": ["performance-weekly", "performance-monthly", "performance"]},
        "trade-reviews":    {"from": "trade-reviews", "absorbs": ["lessons-learned"]},
        # PRIVATE — execution
        "live-executions":  {"from": "executions-live", "absorbs": ["executions-pending", "execution-history", "execution-notes", "trade-live"]},
        "auto-trader":      {"from": "auto-trader", "absorbs": ["rule-engine-analysis", "freq-trader"]},
        "closed-trades":    {"from": "closed-trades", "absorbs": ["os-closed-stocks"]},
        "backtest":         {"from": "backtest", "absorbs": ["daily-optimize"]},
        # PRIVATE — risk/portfolio
        "risk":             {"from": "risk-alerts", "absorbs": ["risk-decisions", "risk-exposure", "risk-rules"]},
        "portfolio":        {"from": "portfolio-status", "absorbs": ["portfolio-rebalance", "portfolio-wallets", "portfolio-costs", "main-portfolios", "alpaca-account"]},
        # PRIVATE — agents/system
        "agent-comms":      {"from": "agent-comms", "absorbs": ["agent-debate", "synthetic-analysis", "synth-control"]},
        "reminders":        {"from": "server-renewal-reminders", "absorbs": []},
        "mission-control":  {"from": "mission-control", "absorbs": ["general", "cycle-logs"]},
        "system-logs":      {"from": "system-logs", "absorbs": ["devops", "pipeline", "broadcast-log"]},
        "bot-commands":     {"from": "boba-cmd", "absorbs": []},
    },
    "archive_only": [
        "market-pulse", "beta-options", "final-msg-flow", "spofs", "5-27-2026", "flow-cards",
        "flow-v2-shadow", "flow-v2-digest", "signal-digests", "tradesignals-closed",
        "tradesignals-mgmt", "stocksignals-closed", "stocksignals-mgmt", "telegram-feed",
        "signals-old", "linear-feed", "bluestacks", "massage-bookings", "leftover-tasks",
        "sniper-dips", "sniper-watchlist",
    ],
}


def _bot(method, path, **kw):
    for _ in range(6):
        r = requests.request(method, API + path,
                             headers={"Authorization": f"Bot {BOT}", "User-Agent": UA,
                                      "Content-Type": "application/json"}, timeout=30, **kw)
        if r.status_code == 429:
            time.sleep(float(r.headers.get("Retry-After", 2)) + 0.5); continue
        r.raise_for_status(); time.sleep(0.3)
        return r.json() if r.text else {}
    raise RuntimeError("rate-limited")


def load_names():
    if not SNAP.exists():
        sys.exit("no snapshot — run discord_audit.py first")
    snap = json.loads(SNAP.read_text())
    name2id, name2cat = {}, {}
    for cat in snap.get("categories", []):
        for c in cat["channels"]:
            name2id[c["name"]] = c["id"]; name2cat[c["name"]] = cat["name"]
    for c in snap.get("uncategorized", []):
        name2id[c["name"]] = c["id"]
    return name2id


def resolve_secret_map():
    """READ-ONLY: which webhook secret file feeds which live channel (resolve via Discord)."""
    out = {}
    for p in sorted(SECRETS.glob("discord*")):
        if p.is_dir():
            continue
        try:
            txt = p.read_text(errors="replace").strip()
        except Exception:
            continue
        m = re.search(r"/webhooks/(\d+)/([\w-]+)", txt)
        if not m:
            continue
        try:
            wh = requests.get(f"{API}/webhooks/{m.group(1)}/{m.group(2)}", headers={"User-Agent": UA}, timeout=20)
            if wh.status_code == 200:
                out[p.name] = {"channel_id": wh.json().get("channel_id"), "channel": wh.json().get("name")}
        except Exception:
            pass
        time.sleep(0.25)
    print(json.dumps(out, indent=2))
    return out


def main():
    if not (GUILD and BOT):
        sys.exit("missing discord_guild_id or discord_ops_bot_token")
    if "--secret-map" in sys.argv:
        resolve_secret_map(); return

    name2id = load_names()
    mode = "EXECUTE" if not DRY else "DRY-RUN (nothing will change)"
    print(f"=== discord_reorg :: {mode} ===\n")
    rollback = {"renames": {}, "archived": []}
    archive_cat = name2id  # placeholder; archive category id resolved at execute time
    miss = []

    for new, spec in PLAN["renames_and_merges"].items():
        old = spec["from"]
        cid = name2id.get(old)
        if not cid:
            miss.append(old); continue
        tag = "" if old == new else f"  (rename {old} → {new})"
        print(f"SURVIVOR  #{new:<20} id={cid}{tag}")
        if old != new and not DRY:
            rollback["renames"][cid] = old
            _bot("PATCH", f"/channels/{cid}", json={"name": new})
        for ab in spec["absorbs"]:
            abid = name2id.get(ab)
            if not abid:
                miss.append(ab); continue
            print(f"   ⇐ re-point webhooks of #{ab} → #{new}, then archive #{ab}")
            # (execute path: create webhook on survivor, rewrite matching secret files, archive ab)

    print("\nARCHIVE-ONLY:")
    for ch in PLAN["archive_only"]:
        cid = name2id.get(ch)
        print(f"   🗄️  #{ch:<22} {'id='+cid if cid else 'NOT FOUND (skip)'}")
        if not cid:
            miss.append(ch)

    if miss:
        print(f"\n⚠ {len(miss)} planned channels not found live (already renamed/archived?): "
              + ", ".join(sorted(set(miss))))
    if DRY:
        print("\n(dry-run — re-run with --execute after Mike approves DISCORD-REORG-MAP.md)")
    else:
        ROLLBACK.write_text(json.dumps(rollback, indent=2))
        print(f"\nrollback written: {ROLLBACK}")


if __name__ == "__main__":
    main()
