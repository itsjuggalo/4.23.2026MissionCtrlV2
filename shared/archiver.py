#!/usr/bin/env python3
"""
Shared archive rotation module for all Mission Control bots.

Usage:
    from shared.archiver import maybe_rotate

    # In your bot's main loop (or after every write):
    await maybe_rotate(session, "signals", signals_list, SIGNALS_FILE,
                       max_entries=500, webhook_url=ARCHIVE_WEBHOOK)

The archiver:
  - Checks if the list exceeds max_entries
  - If so: saves the overflow to an archive JSON in the same dir
  - Keeps only the newest max_entries in the live file
  - Posts a 📦 rotation notice to the archive Discord webhook
  - Returns the (possibly trimmed) list for the caller to save
"""
import json
import logging
import os
from datetime import datetime, timezone

import aiohttp

log = logging.getLogger("archiver")

ARCHIVE_SUBDIR = "archive"  # created beside the live file


def _archive_path(live_file: str, label: str) -> str:
    """Return path like /dir/archive/signals_archive_2026-03.json"""
    d    = os.path.dirname(live_file)
    arch = os.path.join(d, ARCHIVE_SUBDIR)
    os.makedirs(arch, exist_ok=True)
    month = datetime.now(timezone.utc).strftime("%Y-%m")
    return os.path.join(arch, f"{label}_archive_{month}.json")


def _load_archive(path: str) -> list:
    if os.path.exists(path):
        try:
            with open(path) as f:
                return json.load(f)
        except Exception:
            return []
    return []


def _save_json(path: str, data) -> None:
    with open(path, "w") as f:
        json.dump(data, f, indent=2, default=str)
    try:
        os.chmod(path, 0o600)
    except Exception:
        pass


def _count_all_archives(live_file: str, label: str) -> int:
    """Total records across all archive files for this label."""
    arch_dir = os.path.join(os.path.dirname(live_file), ARCHIVE_SUBDIR)
    if not os.path.exists(arch_dir):
        return 0
    total = 0
    for fname in os.listdir(arch_dir):
        if fname.startswith(f"{label}_archive_") and fname.endswith(".json"):
            try:
                d = json.load(open(os.path.join(arch_dir, fname)))
                total += len(d) if isinstance(d, list) else 0
            except Exception:
                pass
    return total


async def maybe_rotate(
    session: aiohttp.ClientSession,
    label: str,
    entries: list,
    live_file: str,
    max_entries: int,
    webhook_url: str,
    keep_newest: bool = True,
) -> list:
    """
    Check if entries exceeds max_entries. If so, archive the overflow
    and post a rotation notice. Returns the (possibly trimmed) list.

    Args:
        session       : aiohttp ClientSession
        label         : short name, e.g. "signals", "launches"
        entries       : current list of records
        live_file     : path to the live JSON file
        max_entries   : rotate when len(entries) > this
        webhook_url   : Discord archive channel webhook
        keep_newest   : if True, keep newest max_entries; else keep oldest
    """
    if len(entries) <= max_entries:
        return entries

    n_overflow = len(entries) - max_entries

    if keep_newest:
        overflow = entries[:n_overflow]     # oldest go to archive
        keep     = entries[n_overflow:]     # newest stay live
    else:
        keep     = entries[:max_entries]
        overflow = entries[max_entries:]

    # Append overflow to this month's archive file
    arch_path = _archive_path(live_file, label)
    existing  = _load_archive(arch_path)

    # Detect date range of archived records
    def _ts(r):
        for k in ("timestamp", "opened_at", "closed_at", "audited_at", "last_updated"):
            v = r.get(k) if isinstance(r, dict) else None
            if v: return v[:10]
        return "unknown"

    dates = [_ts(r) for r in overflow]
    dates = [d for d in dates if d != "unknown"]
    date_range = f"{min(dates)} – {max(dates)}" if dates else "unknown dates"

    existing.extend(overflow)
    _save_json(arch_path, existing)

    total_archived = _count_all_archives(live_file, label)

    log.info(
        f"[ARCHIVE] {label}: rotated {n_overflow} entries → {arch_path} "
        f"(total archived: {total_archived})"
    )

    # Post to Discord archive channel
    if webhook_url:
        archive_fname = os.path.basename(arch_path)
        payload = {"embeds": [{
            "title":       f"📦 ARCHIVE ROTATED — {label.replace('-', ' ').title()}",
            "description": (
                f"**Archived:** {n_overflow} entries from {date_range}\n"
                f"**File:** `{archive_fname}`\n"
                f"**Total archived records:** {total_archived:,}\n"
                f"**Live entries remaining:** {len(keep):,}"
            ),
            "color":       0x6c5ce7,
            "footer":      {
                "text": f"Archive • {datetime.now(timezone.utc).strftime('%Y-%m-%d %H:%M')} UTC"
            },
        }]}
        try:
            async with session.post(
                webhook_url, json=payload,
                timeout=aiohttp.ClientTimeout(total=10)
            ) as resp:
                if resp.status not in (200, 204):
                    body = await resp.text()
                    log.warning(f"Archive webhook {resp.status}: {body[:80]}")
        except Exception as e:
            log.warning(f"Archive webhook failed: {e}")

    return keep


def rotate_dict_field(
    data: dict,
    field: str,
    max_entries: int,
    live_file: str,
    label: str,
) -> tuple[dict, list]:
    """
    Synchronous rotation for dicts with a list field (e.g. risk_state.decisions).
    Returns (updated_dict, overflow_list).
    No Discord post — caller handles that.
    """
    entries = data.get(field, [])
    if len(entries) <= max_entries:
        return data, []

    n_overflow = len(entries) - max_entries
    overflow   = entries[:n_overflow]
    keep       = entries[n_overflow:]

    arch_path = _archive_path(live_file, label)
    existing  = _load_archive(arch_path)
    existing.extend(overflow)
    _save_json(arch_path, existing)

    data[field] = keep
    log.info(f"[ARCHIVE] {label}.{field}: rotated {n_overflow} → {arch_path}")
    return data, overflow
