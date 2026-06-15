#!/usr/bin/env python3
"""discord_prune_reviewed.py — Mike-run, SAFE-by-default channel prune.

Companion to discord_cleanup_admin.py. Built from a LIVE read-only audit on
2026-06-14 (the guild was already restructured to 12 categories — the old
~130-channel persona tree no longer exists, so --delete-dead's old assumptions
are moot). This deletes ONLY an explicit, reviewed ID allowlist.

Why not just `discord_cleanup_admin.py --delete-dead --yes`?
  - It would delete the 4 EMPTY 🎯 SNIPER channels (sniper-dips/exits/watchlist/
    skips) — they're empty only because the sniper daemon is still dry-run.
    Deleting them breaks sniper_config.json. This script NEVER touches them.
  - It SKIPS dead channels in protected categories (RISK/PORTFOLIO/TRADING/...),
    so the empty scaffolding there can't be reached. This script can (TIER_REVIEW).

Usage (run in PuTTY or with the `!` prefix in Claude Code — needs the bot token):
  python3 ~/scripts/discord_prune_reviewed.py                 # dry-run, TIER_SAFE
  python3 ~/scripts/discord_prune_reviewed.py --yes           # delete TIER_SAFE (5)
  python3 ~/scripts/discord_prune_reviewed.py --include-review # dry-run, +TIER_REVIEW
  python3 ~/scripts/discord_prune_reviewed.py --include-review --yes  # delete both
Bot needs Manage Channels.
"""
import argparse, json, os, sys, time, urllib.request, urllib.error

GUILD = "1486025777970548908"
KEY_DIRS = [os.path.expanduser("~/.openclaw/secrets"), os.path.expanduser("~/scripts/keys")]

# ── Confirmed dead, UNPROTECTED, safe to delete (idle ≥34d, not system/sniper) ──
TIER_SAFE = {
    "1486045591426437302": "bot-commands            (⚙️ SYSTEM, 38d idle)",
    "1498025465871597578": "liquidation-heatmap     (🌐 RESEARCH & MACRO, 48d idle)",
    "1500630220162732102": "test4notifs             (🎯 ALERTS & SENTIMENT, 42d — test chan)",
    "1501770348977328218": "massive-notifs          (🎯 ALERTS & SENTIMENT, 34d idle)",
    "1497464912287498371": "todo-list               (🤖 AGENTS & BOTS, 50d idle)",
}

# ── In protected categories: empty scaffolding / long-quiet. Review before delete.
#    EXCLUDES the protected system names you keep (mission-control, announcements,
#    verify, agent-comms, boba-cmd) and anything currently live.
TIER_REVIEW = {
    "1497766926338752592": "trade-paper       (📈 TRADING, EMPTY scaffold)",
    "1497766972606251029": "trade-live        (📈 TRADING, EMPTY scaffold)",
    "1497767009189105836": "backtest          (📈 TRADING, EMPTY scaffold)",
    "1494746026693759006": "auto-trader       (📈 TRADING, 48d idle)",
    "1486045626277040230": "execution-notes   (📈 TRADING, 81d idle)",
    "1486045621516505309": "risk-exposure     (🛡️ RISK & PORTFOLIO, EMPTY)",
    "1486045622288126024": "risk-rules        (🛡️ RISK & PORTFOLIO, EMPTY)",
    "1486045630509092944": "portfolio-wallets (🛡️ RISK & PORTFOLIO, EMPTY)",
    "1486045631595417790": "portfolio-costs   (🛡️ RISK & PORTFOLIO, EMPTY)",
    "1496301594285838527": "main-portfolios   (🛡️ RISK & PORTFOLIO, 50d idle)",
    "1486530350107852952": "tweak-trades      (📡 SIGNALS — PROVIDERS, 67d idle)",
    "1498486675565969639": "telegram-feed     (📡 SIGNALS — PROVIDERS, 35d idle)",
    "1502921272961794098": "market-pulse      (📰 BRIEFS, 35d idle)",
}

# 🗄️ ARCHIVE — stale leftover history (47–78d idle). Mike asked to reduce these.
# KEEPS the 2 still-live ones (broadcast-log, signals-old). Run with --include-archives.
TIER_ARCHIVE = {
    "1486136525144981565": "archive-analyst          (🗄️ ARCHIVE, 66d)",
    "1486148116670578793": "archive-codex-expert     (🗄️ ARCHIVE, 71d)",
    "1486136515045101717": "archive-eric             (🗄️ ARCHIVE, 48d)",
    "1486045638675267716": "archive-psych-chat       (🗄️ ARCHIVE, 78d)",
    "1486045637387620564": "archive-psych-insights   (🗄️ ARCHIVE, 73d)",
    "1486136562327748630": "archive-sniper           (🗄️ ARCHIVE, 71d)",
    "1486045643926671390": "archive-sniper-analysis  (🗄️ ARCHIVE, 71d)",
    "1486045654378872902": "ci-intelligence-report   (🗄️ ARCHIVE, 67d)",
    "1486045651740659753": "ci-ml-evolution          (🗄️ ARCHIVE, 66d)",
    "1486045651115446292": "ci-obfuscation-log       (🗄️ ARCHIVE, 66d)",
    "1491237210756878538": "coupon                   (🗄️ ARCHIVE, 60d)",
    "1491237848823631892": "coupon-logs              (🗄️ ARCHIVE, 59d)",
    "1491237778791465092": "coupon-request           (🗄️ ARCHIVE, 59d)",
    "1491237939483770920": "coupon-watchlist         (🗄️ ARCHIVE, 68d)",
    "1486045594605719764": "eric-rejected            (🗄️ ARCHIVE, 48d)",
    "1489773321129037854": "hyperliquid              (🗄️ ARCHIVE, 66d)",
    "1498183281173332049": "mbm-messages             (🗄️ ARCHIVE, 47d)",
    "1489773284060041256": "spot                     (🗄️ ARCHIVE, 66d)",
    "1486526749029175437": "tweaktrades              (🗄️ ARCHIVE, 78d)",
}

# NEVER deleted by this script (documented for clarity — not used as input):
#   • 🎯 SNIPER sniper-dips/exits/watchlist/skips  — empty, await daemon go-live
#   • mission-control / announcements / verify / agent-comms / boba-cmd — system
#   • 🗄️ ARCHIVE broadcast-log + signals-old — still LIVE (posted today)


def load_token():
    for d in KEY_DIRS:
        for fn in ("discord_boba_token", "discord_ops_bot_token", "discord_orion_token"):
            try:
                t = open(os.path.join(d, fn)).read().strip()
                if t:
                    print(f"[token] {fn} from {d}")
                    return t
            except OSError:
                continue
    sys.exit("ERROR: no usable bot token in ~/.openclaw/secrets or ~/scripts/keys")


def api(method, path, tok):
    req = urllib.request.Request("https://discord.com/api/v10" + path, method=method,
        headers={"Authorization": "Bot " + tok, "User-Agent": "MissionCtrlPrune/1.0"})
    try:
        with urllib.request.urlopen(req, timeout=25) as r:
            return r.status
    except urllib.error.HTTPError as e:
        return e.code


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("--yes", action="store_true", help="actually delete (default: dry-run)")
    ap.add_argument("--include-review", action="store_true", help="also act on TIER_REVIEW")
    ap.add_argument("--include-archives", action="store_true", help="also act on TIER_ARCHIVE (19 stale archives)")
    args = ap.parse_args()
    tok = load_token()
    targets = dict(TIER_SAFE)
    if args.include_review:
        targets.update(TIER_REVIEW)
    if args.include_archives:
        targets.update(TIER_ARCHIVE)
    print(f"\n{'DELETING' if args.yes else 'DRY-RUN — would delete'} {len(targets)} channels:")
    for cid, label in targets.items():
        print(f"  {label}")
    if not args.yes:
        print("\nRe-run with --yes to delete. Flags: --include-review (live-category set) · "
              "--include-archives (19 stale archives, keeps the 2 live ones).")
        return
    print()
    for cid, label in targets.items():
        st = api("DELETE", f"/channels/{cid}", tok)
        print(f"  {'OK ' if st in (200, 204) else 'FAIL(%s)' % st} {label}")
        time.sleep(0.6)


if __name__ == "__main__":
    main()
