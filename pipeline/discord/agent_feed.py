"""Agent-readable feed of trade outcomes.

Follows the convention established by bots/firebase_signal_relay.py:
write a JSON array to ~/.openclaw/workspace/directives/<feed>.json, capped at
the last N entries, deduped by id, newest-last. Both boba_decision_cycle.py and
jazzy_decision_cycle.py already read sibling feeds (firebase_trade_signals.json,
kronos_forecasts/, grok_brief.json) from this directory, so a new feed here is
picked up by adding one line to each agent's prompt-builder.

Also maintains an append-only JSONL history at the same directory for replay /
audit. Both writes are best-effort; failure logs but does not raise.
"""
from __future__ import annotations

import json
import logging
import os
import tempfile
from datetime import datetime, timezone
from pathlib import Path
from typing import Any


_DEFAULT_DIRECTIVES = Path.home() / ".openclaw" / "workspace" / "directives"
_DEFAULT_FEED = _DEFAULT_DIRECTIVES / "options_outcomes_feed.json"
_DEFAULT_HISTORY = _DEFAULT_DIRECTIVES / "options_outcomes_history.jsonl"
_DEFAULT_MAX = 200

log = logging.getLogger(__name__)


def _atomic_write_json(path: Path, data: Any) -> None:
    path.parent.mkdir(parents=True, exist_ok=True)
    fd, tmp = tempfile.mkstemp(dir=str(path.parent), prefix=".tmp_", suffix=".json")
    try:
        with os.fdopen(fd, "w") as f:
            json.dump(data, f, indent=2)
        os.replace(tmp, path)
    except Exception:
        try:
            os.unlink(tmp)
        except OSError:
            pass
        raise


def _append_jsonl(path: Path, entry: dict) -> None:
    path.parent.mkdir(parents=True, exist_ok=True)
    with path.open("a") as f:
        f.write(json.dumps(entry) + "\n")


class AgentFeed:
    """Writes outcomes for boba/jazzy to consume on their next decision cycle.

    Two outputs per record():
      - feed_path:    JSON array, last `max_entries`, agent reads this directly.
      - history_path: JSONL append-only, for replay/audit.
    """

    def __init__(
        self,
        feed_path: Path | str | None = None,
        history_path: Path | str | None = None,
        max_entries: int = _DEFAULT_MAX,
    ) -> None:
        self.feed_path = Path(feed_path or os.environ.get("AGENT_FEED_PATH", _DEFAULT_FEED))
        self.history_path = Path(
            history_path or os.environ.get("AGENT_FEED_HISTORY", _DEFAULT_HISTORY)
        )
        self.max_entries = max_entries

    def record(self, entry: dict) -> bool:
        """Append entry to history + update capped feed snapshot.

        `entry` must include `id` (string, unique) and `type` (string).
        captured_at is auto-filled if missing.
        Returns True on full success, False if either write failed.
        """
        if not isinstance(entry, dict) or "id" not in entry or "type" not in entry:
            log.warning(f"agent_feed: skipping malformed entry: {entry!r}")
            return False

        entry = dict(entry)
        entry.setdefault("captured_at", datetime.now(timezone.utc).isoformat())

        ok_history = True
        try:
            _append_jsonl(self.history_path, entry)
        except Exception as e:
            ok_history = False
            log.warning(f"agent_feed: history append failed: {e}")

        ok_feed = True
        try:
            existing: list[dict] = []
            if self.feed_path.exists():
                try:
                    raw = json.loads(self.feed_path.read_text())
                    if isinstance(raw, list):
                        existing = raw
                except (OSError, json.JSONDecodeError):
                    existing = []

            combined = existing + [entry]
            seen_ids: set[str] = set()
            deduped: list[dict] = []
            for e in reversed(combined):
                eid = e.get("id")
                if eid is None or eid in seen_ids:
                    continue
                seen_ids.add(eid)
                deduped.append(e)
            deduped = list(reversed(deduped))[-self.max_entries:]

            _atomic_write_json(self.feed_path, deduped)
        except Exception as e:
            ok_feed = False
            log.warning(f"agent_feed: snapshot write failed: {e}")

        return ok_history and ok_feed
