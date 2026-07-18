#!/usr/bin/env python3
"""md_freshness.py — weekly self-heal for Mike's master docs.

Why this exists: a session once told Mike to use PuTTY and cited a retired
"spacecoast/Hetzner" two-box architecture — both were STALE markdown read as truth.
This keeps the canonical docs honest against the LIVE system so that never recurs.

Read-only on the live system. Four jobs:
  1. Snapshot live truth: pm2, crontab, listening ports, key SQLite DBs.
  2. Regenerate the <!-- AUTO:BEGIN -->..<!-- AUTO:END --> block in ~/SYSTEM-MAP.md
     from that truth (the ONLY write to a live doc; idempotent, marker-bounded).
  3. Grep ALL ~/**/*.md (minus archives/vendored) for retired/stale terms.
  4. Freshness-check the curated master registry (mtime age + MEMORY.md byte caps).
Writes a full report to ~/restructure/DOCS-FRESHNESS.md + a terse Telegram summary.

Usage:
  python3 md_freshness.py            # full run (report + SYSTEM-MAP block + Telegram)
  python3 md_freshness.py --dry-run  # print report to stdout, write NOTHING, no Telegram
  python3 md_freshness.py --no-tg    # full run, skip Telegram

Mirrors the house patterns: daemon_health.py (pm2 jlist parse), digest.py
(markdown + delivery), cron_health.py (alert-only). Prose drift is REPORTED, never
auto-rewritten (live-infra protective tier — Mike approves prose edits).
All subprocess calls are list-form (no shell) — fixed argv, no injection surface.
"""
import json
import os
import re
import subprocess
import sys
from datetime import datetime, timezone
from pathlib import Path

HOME = Path.home()
SYSTEM_MAP = HOME / "SYSTEM-MAP.md"
REPORT = HOME / "restructure" / "DOCS-FRESHNESS.md"
DESK_DB = HOME / "LapClaw" / "pipeline" / "desk_pipeline.sqlite"
FLOW_DB = HOME / "02_DATA" / "flow-data" / "flow.db"
TG_SEND = HOME / "bin" / "tg-send-msg"

DRY = "--dry-run" in sys.argv
NO_TG = "--no-tg" in sys.argv or DRY

MEMORY_CAP = 26 * 1024  # soft cap on memory index files; realistic for a ~115-entry index
                        # (durable shrink = retire SHIPPED/RESOLVED entries, not shorter lines)
STALE_DAYS = 21         # living docs older than this get flagged

# Curated registry: the docs that describe "current" projects/trading/ops.
REGISTRY = [
    HOME / ".claude" / "CLAUDE.md",
    HOME / "CLAUDE.md",
    HOME / "restructure" / "CLAUDE.md",
    HOME / "restructure" / "MIKE.md",
    SYSTEM_MAP,
    HOME / "restructure" / "REFERENCE.md",
    HOME / "restructure" / "00-START-HERE.md",
    HOME / "restructure" / "PROGRESS.md",
    HOME / ".claude" / "projects" / "-home-itsju-restructure" / "memory" / "MEMORY.md",
    HOME / ".claude" / "projects" / "-home-itsju" / "memory" / "MEMORY.md",
    HOME / "restructure" / "OPEN-ITEMS.md",
]
MEMORY_FILES = {
    HOME / ".claude" / "projects" / "-home-itsju-restructure" / "memory" / "MEMORY.md",
    HOME / ".claude" / "projects" / "-home-itsju" / "memory" / "MEMORY.md",
}

# Retired / stale terms. A hit whose line also matches CONTEXT_OK is "acknowledged"
# (the doc names the term to retire/warn about it — e.g. this script, MIKE.md, the
# canary rule, or SYSTEM-MAP's "NOT a failover") — not a live defect.
STALE_TERMS = [
    ("putty", re.compile(r"\bputty\b", re.I)),
    ("spacecoast", re.compile(r"spacecoast", re.I)),
    ("hetzner", re.compile(r"hetzner", re.I)),
    ("brain/muscle two-box", re.compile(r"\bBRAIN\b.*\bMUSCLE\b")),
    ("oracle-as-trading-box", re.compile(r"oracle.{0,45}(failover|production|safety[- ]net)", re.I)),
    ("bobacattrades", re.compile(r"bobacattrades", re.I)),
    ("4.23 repo", re.compile(r"4\.23 repo", re.I)),
    # 2026-06-30 laptop-only cutover relics (added 2026-07-01)
    ("missionctrl.serveftp mirror", re.compile(r"missionctrl\.serveftp", re.I)),
    ("3300 tunnel", re.compile(r"3300:localhost:3000|-R ?3300", re.I)),
    ("8091 tunnel", re.compile(r"8091.{0,60}(reverse|tunnel)|(reverse|tunnel).{0,60}8091", re.I)),
    ("massage-site python :3002", re.compile(r"massage-site|http\.server 3002", re.I)),
    ("oracle options_flow db", re.compile(r"options_flow\.sqlite", re.I)),
]
CONTEXT_OK = re.compile(
    r"(retired|legacy|NOT a|never a|stopped on purpose|comms[- ]?(relay|only)|tripwire|canary|"
    r"example|do ?n.t|stale|historical|deprecat|pre-consolidation|migrated|don't restart|"
    r"old notes|RETIRED|disabled|cutover|repoint|leftover|was cut|feed was cut|\bdead\b)",
    re.I,
)

# Live Telegram FLEET false positives. "SpaceCoast" here is the LIVE @SpaceCoast_Claude_Bot
# briefs-bus and "@Boba*" are LIVE bots (FLEET-MAP / telegram-inventory / TELEGRAM-FLEET-QUALITY-
# AUDIT) — NOT the retired Hetzner 'spacecoast' box. A hit whose line carries a bot/fleet marker
# (@handle, *_Bot, briefs/bus/desk/digest/scoreboard, chain=) is a live identity → acknowledge it.
# Kept tight so a bare stale ref ("spacecoast = the BRAIN box", "ssh spacecoast") still flags.
BOT_NAME_OK = re.compile(
    r"(SpaceCoast|Boba)\w*_?Bot\b|@\s*(SpaceCoast|Boba)\w*|"
    r"BobaCatTrades(Team|Bot|_?bot)\b|"  # live TG team/bot identity — NOT the bobacattrades.* domain
    r"(SpaceCoast|Boba)\b.*(brief|bus|desk|digest|scoreboard|chain=|@Boba|_Bot)|"
    r"(brief|bus|desk|digest|scoreboard|chain=).*(SpaceCoast|Boba)\b",
    re.I,
)

# Directories/files to skip in the *.md sweep (substring match on the path). These are
# immutable historical logs/dumps — by design they RECORD old terms, so flagging them is
# pure noise. The point of the sweep is LIVING docs that steer sessions, not archives.
EXCLUDE = [
    "/.git/", "/node_modules/", "/archive/", "-frozen-", "skool", "erikdalton-kb/transcripts",
    "/backups/", "/.claude.bak/", "/.hermes/migration/", "/.next/", "/dist/", "/.venv/",
    "/venv/", "/site-packages/", "/.cache/", "second-brain/archive", "/worktrees/",
    "/.openclaw/workspace/memory/", "/.trash/", "/tmp/",
    "conversation_backup", "/06_REPORTS/", "_backup", ".bak", "/episodic/",
    "/.remember/", "/.bible-rag/", "/04_RESEARCH/AiData/",  # historical corpora / bannered-abandoned tree
    "audit_log", "/bible/README.md",  # append-only write-logs / bible changelog corpus
    "01_ACTIVE/sites/missioncontrol/",  # legacy MissionCtrlV2 tree — banner-marked STALE 2026-07-01, canonical = /AIWorkWSL/web/missionctrl
]
# Files exempt from stale-term flagging (they intentionally name retired terms as examples).
SELF_EXEMPT = {REPORT, HOME / "restructure" / "MIKE.md",
               HOME / "05_AUTOMATION" / "scripts" / "md_freshness.py"}

# A defect in a CANONICAL doc (one a fresh session reads as present truth) is the dangerous
# kind — report those loudly; everything else is a quieter tail.
def is_canonical(path_str):
    name = path_str.rsplit("/", 1)[-1]
    return ("/restructure/" in path_str or "/.claude/" in path_str or "/memory/" in path_str
            or "SYSTEM-MAP.md" in path_str
            or name in {"CLAUDE.md", "AGENTS.md", "MEMORY.md", "COLLABORATION.md"})


def sh(args, timeout=20, env=None):
    """Run a fixed argv (no shell); return stdout text, '' on any failure."""
    try:
        r = subprocess.run(args, capture_output=True, text=True, timeout=timeout,
                           env=env, stdin=subprocess.DEVNULL)
        return r.stdout
    except Exception:
        return ""


def now_et():
    s = sh(["date", "+%A %Y-%m-%d %I:%M %p %Z"],
           env={**os.environ, "TZ": "America/New_York"}).strip()
    return s or "(time unavailable)"


def fmt_mtime(ts):
    return datetime.fromtimestamp(ts).strftime("%Y-%m-%d %H:%M")


def age_days(ts):
    return int((datetime.now(timezone.utc).timestamp() - ts) // 86400)


# ---- 1. live snapshot ----------------------------------------------------------
def snap_pm2():
    try:
        procs = json.loads(sh(["pm2", "jlist"]))
    except Exception:
        return {"ok": False, "online": 0, "total": 0, "names": []}
    online = [p.get("name", "?") for p in procs
              if p.get("pm2_env", {}).get("status") == "online"]
    return {"ok": True, "online": len(online), "total": len(procs), "names": sorted(online)}


def snap_cron():
    lines = sh(["crontab", "-l"]).splitlines()
    active = [l for l in lines if l.strip() and not l.lstrip().startswith("#")]
    reboot = [l for l in active if "@reboot" in l]
    return {"lines": len(lines), "active": len(active), "reboot": len(reboot)}


def snap_ports():
    out = sh(["ss", "-tlnp"])
    seen = {}
    for line in out.splitlines():
        if "LISTEN" not in line:
            continue
        m = re.search(r"\s(\S+):(\d+)\s", line)
        if not m:
            continue
        pm = re.search(r'"([^"]+)"', line)
        seen.setdefault(m.group(2), pm.group(1) if pm else "?")
    return dict(sorted(seen.items(), key=lambda kv: int(kv[0])))


def snap_db(path):
    if not path.exists():
        return None
    st = path.stat()
    return {"mb": round(st.st_size / 1024 / 1024, 1), "mtime": fmt_mtime(st.st_mtime)}


# ---- 2. SYSTEM-MAP auto-block --------------------------------------------------
def build_auto_block(pm2, cron, ports, ts):
    port_str = ", ".join(f"{p}({proc})" for p, proc in ports.items()) or "(none seen)"
    lines = [
        "<!-- AUTO:BEGIN — regenerated weekly by md_freshness.py; do not hand-edit between these markers -->",
        f"### Live state — auto-refreshed {ts}",
        f"- **PM2:** {pm2['online']} online / {pm2['total']} total"
        + ("" if pm2["ok"] else " (pm2 jlist unreadable)"),
        f"- **Online procs:** {', '.join(pm2['names']) if pm2['names'] else '(none)'}",
        f"- **Crontab:** {cron['lines']} lines ({cron['active']} active, {cron['reboot']} @reboot)",
        f"- **Listening ports:** {port_str}",
    ]
    for label, path in (("desk_pipeline.sqlite", DESK_DB), ("flow.db", FLOW_DB)):
        d = snap_db(path)
        if d:
            lines.append(f"- **{label}:** {d['mb']} MB, modified {d['mtime']}")
    lines.append("<!-- AUTO:END -->")
    return "\n".join(lines)


def update_system_map(block):
    if not SYSTEM_MAP.exists():
        return "missing"
    txt = SYSTEM_MAP.read_text()
    pat = re.compile(r"<!-- AUTO:BEGIN.*?-->.*?<!-- AUTO:END -->", re.S)
    if not pat.search(txt):
        return "no-markers"  # markers must be installed once by hand; never guess insertion
    new = pat.sub(lambda _: block, txt)
    if new == txt:
        return "unchanged"
    if not DRY:
        SYSTEM_MAP.write_text(new)
    return "updated"


# ---- 3. stale-term sweep -------------------------------------------------------
def sweep_stale():
    canon, other, acknowledged = [], [], []
    scanned = 0
    for md in HOME.rglob("*.md"):
        p = str(md)
        if any(x in p for x in EXCLUDE) or md in SELF_EXEMPT:
            continue
        try:
            text = md.read_text(errors="ignore")
        except Exception:
            continue
        scanned += 1
        # A file carrying a HISTORICAL/RETIRED banner at the top, or a dated phase recipe,
        # is self-labelled stale — route ALL its hits to acknowledged so bannering clears it.
        name = p.rsplit("/", 1)[-1]
        bannered = bool(re.search(r"(historical|retired / stale|retired/stale)", text[:900], re.I))
        phase_doc = bool(re.match(r"\d\d-PHASE|PHASE\d", name))
        whole_ack = bannered or phase_doc
        for i, line in enumerate(text.splitlines(), 1):
            for label, rx in STALE_TERMS:
                if rx.search(line):
                    rec = (label, p.replace(str(HOME), "~"), i, line.strip()[:120])
                    if whole_ack or CONTEXT_OK.search(line) or BOT_NAME_OK.search(line):
                        acknowledged.append(rec)
                    elif is_canonical(p):
                        canon.append(rec)
                    else:
                        other.append(rec)
    return canon, other, acknowledged, scanned


# ---- 4. registry freshness -----------------------------------------------------
def check_registry():
    rows = []
    for path in REGISTRY:
        disp = str(path).replace(str(HOME), "~")
        if not path.exists():
            rows.append((disp, "MISSING", "", ["MISSING"]))
            continue
        st = path.stat()
        ad = age_days(st.st_mtime)
        flags = []
        if path in MEMORY_FILES and st.st_size > MEMORY_CAP:
            flags.append(f"OVER CAP {st.st_size/1024:.1f}KB>{MEMORY_CAP//1024}KB")
        if ad > STALE_DAYS:
            flags.append(f"{ad}d old")
        rows.append((disp, f"{st.st_size/1024:.1f}KB", f"{ad}d", flags))
    return rows


# ---- report assembly -----------------------------------------------------------
def main():
    ts = now_et()
    pm2, cron, ports = snap_pm2(), snap_cron(), snap_ports()
    block = build_auto_block(pm2, cron, ports, ts)
    sm_status = update_system_map(block)
    canon, other, ack, scanned = sweep_stale()
    reg = check_registry()

    out = [
        f"# DOCS-FRESHNESS — auto-generated {ts}",
        "",
        f"_Self-heal sweep by `md_freshness.py`{' (DRY-RUN)' if DRY else ''}. "
        "Live system is the source of truth; this flags docs that disagree. "
        f"{scanned} living `.md` scanned (archives/backups/conversation dumps skipped)._",
        "",
        "## Live state",
        f"- PM2: **{pm2['online']} online / {pm2['total']} total**",
        f"- Crontab: **{cron['lines']} lines** ({cron['active']} active, {cron['reboot']} @reboot)",
        f"- Listening ports: {len(ports)} — {', '.join(ports) or '(none)'}",
        f"- SYSTEM-MAP auto-block: **{sm_status}**"
        + ("  ⚠️ install `<!-- AUTO:BEGIN -->`/`<!-- AUTO:END -->` markers once by hand"
           if sm_status == "no-markers" else ""),
        "",
        f"## 🔴 Stale terms in CANONICAL docs: {len(canon)}  (these steer sessions — fix first)",
    ]
    if canon:
        for label, f, ln, snip in canon:
            out.append(f"- 🔴 **{label}** — `{f}:{ln}` — {snip}")
    else:
        out.append("- ✓ none — no retired terms used as live truth in canonical docs")
    out += ["", f"## Stale terms in other living docs: {len(other)}  (lower priority)"]
    for label, f, ln, snip in other[:25]:
        out.append(f"- 🟡 **{label}** — `{f}:{ln}` — {snip}")
    if len(other) > 25:
        out.append(f"- …and {len(other)-25} more")
    out += [
        "",
        f"## Acknowledged mentions (term named as retired/example): {len(ack)}",
        "- (informational — these lines retire/warn about the term, not assert it)",
        "",
        "## Master registry freshness",
        "| File | Size | Age | Flags |",
        "|---|---|---|---|",
    ]
    for f, size, age, flags in reg:
        out.append(f"| `{f}` | {size} | {age} | {' · '.join(flags) if flags else '✓'} |")
    report = "\n".join(out)

    if DRY:
        print(report)
        return

    REPORT.write_text(report)
    reg_flags = sum(1 for r in reg if r[3])
    summary = (f"📋 Docs freshness — {ts}\n"
               f"PM2 {pm2['online']}/{pm2['total']} · cron {cron['lines']}L · ports {len(ports)}\n"
               f"SYSTEM-MAP block: {sm_status}\n"
               f"🔴 canonical stale-refs: {len(canon)} · other: {len(other)} · registry flags: {reg_flags}\n"
               f"full report: ~/restructure/DOCS-FRESHNESS.md")
    if not NO_TG and TG_SEND.exists():
        sh([str(TG_SEND), summary], timeout=30)
    # Best-effort Discord post to #system-logs (ops channel). Reuses lib/discord_post.py
    # which already handles the urllib UA-403 gotcha; never raises.
    if not NO_TG:
        try:
            sys.path.insert(0, str(Path(__file__).resolve().parent))
            from lib.discord_post import post_discord
            post_discord(summary, webhook_name="discord_ops_webhook", username="Docs Freshness")
        except Exception:
            pass
    print(f"wrote {REPORT} · SYSTEM-MAP {sm_status} · canon {len(canon)} · other {len(other)} · reg_flags {reg_flags}")


if __name__ == "__main__":
    main()
