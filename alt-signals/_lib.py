#!/usr/bin/env python3
"""
alt-signals shared library.

Every ingester in ~/scripts/alt-signals/*.py imports from here:
  - DB connection + alt_signals upsert
  - quality scoring + Discord push (threshold-gated)
  - state-file helpers (per-source dedup)
  - shared HTTP with SEC-friendly UA

No third-party deps — stdlib only so any uv-run can pick this up.
"""
from __future__ import annotations

import hashlib
import json
import os
import sqlite3
import sys
import time
import urllib.request
import urllib.error
from datetime import datetime, timezone
from pathlib import Path

# ---- paths ----
HOME = Path("/home/itsju")
DB_PATH = HOME / "flow-data" / "flow.db"
STATE_DIR = HOME / ".openclaw" / "state" / "alt_signals"
SECRETS_DIR = HOME / ".openclaw" / "secrets"
LOG_DIR = HOME / ".openclaw" / "logs" / "alt_signals"

STATE_DIR.mkdir(parents=True, exist_ok=True)
LOG_DIR.mkdir(parents=True, exist_ok=True)

# Webhook destination for alt-signals (signal_discovery channel).
# Overridable per-ingester by setting ALT_SIGNALS_WEBHOOK env var.
DEFAULT_WEBHOOK_FILE = SECRETS_DIR / "discord_signal_discovery_webhook"

USER_AGENT = "MissionCtrl Research itsjuggalo@gmail.com"

# Threshold above which an alt_signal gets pushed to Discord on insertion.
DISCORD_PUSH_THRESHOLD = float(os.environ.get("ALT_SIGNALS_DISCORD_THRESHOLD", "70"))


# ---- DB ----
def get_db() -> sqlite3.Connection:
    c = sqlite3.connect(str(DB_PATH), timeout=30)
    c.execute("PRAGMA journal_mode=WAL")
    c.execute("PRAGMA busy_timeout=10000")
    return c


def make_signal_id(source: str, *parts: str) -> str:
    """Deterministic id so re-runs don't duplicate."""
    raw = "|".join([source] + [str(p) for p in parts])
    return hashlib.sha1(raw.encode("utf-8")).hexdigest()[:24]


def upsert_alt_signal(
    *,
    source: str,
    symbol: str | None,
    direction: str | None,
    headline: str,
    url: str | None = None,
    raw: dict | None = None,
    quality_score: float = 50.0,
    ts: str | None = None,
    dedup_key: str | None = None,
) -> tuple[str, bool]:
    """
    Insert one alt_signal. Returns (signal_id, is_new).
    dedup_key: if given, used in the signal_id hash. Else (symbol, headline) is used.
    """
    ts = ts or datetime.now(timezone.utc).isoformat(timespec="seconds")
    sig_id = make_signal_id(source, dedup_key or (symbol or ""), headline[:80])
    raw_json = json.dumps(raw or {}, default=str)

    is_new = False
    with get_db() as c:
        cur = c.cursor()
        cur.execute("SELECT id FROM alt_signals WHERE id = ?", (sig_id,))
        if cur.fetchone() is None:
            is_new = True
            cur.execute(
                """
                INSERT INTO alt_signals
                  (id, ts, source, symbol, direction, headline, url,
                   raw_json, quality_score, status)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, 'new')
                """,
                (sig_id, ts, source, symbol, direction, headline, url,
                 raw_json, quality_score),
            )
        else:
            # Refresh score if it changed
            cur.execute(
                "UPDATE alt_signals SET quality_score = ? WHERE id = ?",
                (quality_score, sig_id),
            )
        c.commit()
    return sig_id, is_new


# ---- HTTP ----
def http_get(
    url: str,
    *,
    accept: str = "application/json,text/html,*/*",
    headers: dict | None = None,
    timeout: int = 30,
    raw_bytes: bool = False,
) -> str | bytes:
    h = {
        "User-Agent": USER_AGENT,
        "Accept": accept,
        "Accept-Encoding": "identity",
    }
    if headers:
        h.update(headers)
    req = urllib.request.Request(url, headers=h)
    with urllib.request.urlopen(req, timeout=timeout) as resp:
        data = resp.read()
    if raw_bytes:
        return data
    return data.decode("utf-8", errors="replace")


# ---- Discord ----
_webhook_url_cache: str | None = None


def _resolve_webhook() -> str | None:
    global _webhook_url_cache
    if _webhook_url_cache is not None:
        return _webhook_url_cache
    if (env := os.environ.get("ALT_SIGNALS_WEBHOOK")):
        _webhook_url_cache = env.strip()
        return _webhook_url_cache
    if DEFAULT_WEBHOOK_FILE.exists():
        _webhook_url_cache = DEFAULT_WEBHOOK_FILE.read_text().strip()
        return _webhook_url_cache
    return None


def discord_post(content: str) -> bool:
    url = _resolve_webhook()
    if not url:
        print("[alt-signals] no discord webhook configured", file=sys.stderr)
        return False
    payload = json.dumps({"content": content[:1990]}).encode("utf-8")
    req = urllib.request.Request(
        url,
        data=payload,
        headers={"Content-Type": "application/json", "User-Agent": USER_AGENT},
        method="POST",
    )
    try:
        with urllib.request.urlopen(req, timeout=15) as resp:
            return resp.status in (200, 204)
    except urllib.error.HTTPError as e:
        # Rate limited — back off once
        if e.code == 429:
            time.sleep(2)
            try:
                with urllib.request.urlopen(req, timeout=15) as resp:
                    return resp.status in (200, 204)
            except Exception:
                return False
        print(f"[alt-signals] discord error {e.code}: {e.read()[:200]}", file=sys.stderr)
        return False
    except Exception as e:
        print(f"[alt-signals] discord exception: {e}", file=sys.stderr)
        return False


def push_if_top(sig_id: str, *, source: str, symbol: str | None, headline: str,
                quality_score: float, url: str | None = None) -> bool:
    """
    Push to Discord if quality_score >= threshold and not already pushed.
    Marks pushed_to_discord=1 on success so morning brief can still pick it up.
    """
    if quality_score < DISCORD_PUSH_THRESHOLD:
        return False
    with get_db() as c:
        row = c.execute(
            "SELECT pushed_to_discord FROM alt_signals WHERE id = ?",
            (sig_id,),
        ).fetchone()
        if row and row[0]:
            return False  # already pushed

    sym_tag = f"`{symbol}` " if symbol else ""
    src_tag = f"**[{source}]**"
    score_tag = f"({quality_score:.0f})"
    suffix = f"\n<{url}>" if url else ""
    msg = f"{src_tag} {sym_tag}{score_tag} {headline}{suffix}"

    ok = discord_post(msg)
    if ok:
        with get_db() as c:
            c.execute(
                "UPDATE alt_signals SET pushed_to_discord = 1, status = 'pushed' WHERE id = ?",
                (sig_id,),
            )
            c.commit()
    return ok


# ---- State files (per-source dedup beyond the SQL hash) ----
def state_path(source: str) -> Path:
    return STATE_DIR / f"{source}.json"


def load_state(source: str, default=None) -> dict:
    p = state_path(source)
    if not p.exists():
        return default if default is not None else {}
    try:
        return json.loads(p.read_text())
    except Exception:
        return default if default is not None else {}


def save_state(source: str, state: dict) -> None:
    p = state_path(source)
    tmp = p.with_suffix(".json.tmp")
    tmp.write_text(json.dumps(state, indent=2, default=str))
    tmp.replace(p)


# ---- Logging ----
def log_event(source: str, kind: str, data: dict) -> None:
    line = json.dumps({
        "ts": datetime.now(timezone.utc).isoformat(timespec="seconds"),
        "source": source,
        "kind": kind,
        **data,
    }, default=str)
    log_path = LOG_DIR / f"{source}.jsonl"
    with log_path.open("a") as f:
        f.write(line + "\n")


# ---- Ticker extraction (used by AInvest + WSB) ----
import re

_TICKER_RE = re.compile(r"\b\$?([A-Z]{1,5})\b")

# Common false positives — English words that look like tickers
_TICKER_STOPWORDS = {
    "I", "A", "THE", "TO", "AND", "OR", "BUT", "IT", "IS", "AT", "BY", "ON", "IN",
    "OF", "FOR", "WITH", "AS", "BE", "AM", "PM", "ET", "PT", "CT", "EST", "PDT",
    "US", "USA", "UK", "EU", "USD", "EUR", "GBP", "CEO", "CFO", "CTO", "COO",
    "IPO", "ETF", "API", "SEC", "FED", "NYSE", "NASDAQ", "AI", "ML", "GPT", "LLM",
    "Q1", "Q2", "Q3", "Q4", "FY", "YOY", "YTD", "WTI", "BS", "ROI", "ROE", "EPS",
    "P", "E", "PE", "ER", "OK", "NO", "YES", "ALL", "ANY", "OUT", "OFF", "UP",
    "DOWN", "NEW", "OLD", "NOW", "THEN", "HERE", "THERE", "TBA", "TBD", "WIP",
    "CC", "DM", "AMA", "DD", "PR", "TLDR", "TLDR", "FWIW", "IIRC", "IMO", "IMHO",
    "STONK", "STONKS", "BULL", "BEAR", "WSB", "YOLO", "FOMO", "HODL", "FUD",
    "IV", "OTM", "ITM", "ATM", "OEM", "CPI", "PPI", "GDP", "JOLTS", "NFP",
    "FOMC", "ECB", "BOJ", "PCE", "ATH", "ATL", "OPEX", "EOD", "EOW", "EOM",
    "AH", "PM", "TYPE", "SHARE", "PLAY", "PORT", "BAG", "MOON", "CALL", "PUT",
    "OG", "EV", "FY", "WEEK", "MONTH", "YEAR",
}


def extract_tickers(text: str, max_tickers: int = 10) -> list[str]:
    """Cheap heuristic ticker extractor. Skips obvious English words."""
    if not text:
        return []
    found: list[str] = []
    seen: set[str] = set()
    for m in _TICKER_RE.finditer(text):
        t = m.group(1).upper()
        if t in _TICKER_STOPWORDS:
            continue
        if len(t) < 2:  # single-letter requires $ prefix
            if m.group(0).startswith("$") is False:
                continue
        if t in seen:
            continue
        seen.add(t)
        found.append(t)
        if len(found) >= max_tickers:
            break
    return found


# ---- Convenience: utc now ----
def utc_now_iso() -> str:
    return datetime.now(timezone.utc).isoformat(timespec="seconds")
