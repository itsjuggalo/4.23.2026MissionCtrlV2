#!/usr/bin/env python3
"""
notification_bridge — receives MacroDroid POSTs from BlueStacks notification
captures and fans them out to (a) Discord, (b) the Boba/Jazzy feed, and
(c) an audit log.

  MacroDroid (BlueStacks)
        │  HTTP POST /notify?token=...
        ▼
  notification_bridge (this service, prod port 8090)
        ├── append to firebase_signal_notifications.json   (Boba/Jazzy auto-read)
        ├── append to notification_audit.ndjson            (immutable trail)
        ├── dedup by hash(pkg + title + body + minute)
        └── forward to Discord (BlueStacks channel)        (retry w/ backoff)

PM2:
  /home/ubuntu/.npm-global/bin/pm2 start notification_bridge.py \\
    --name notification-bridge --interpreter python3

Endpoints:
  POST /notify?token=...   — MacroDroid posts here
  GET  /health             — liveness + counters
"""

import hashlib
import re
import http.server
import json
import os
import queue
import socketserver
import threading
import time
import urllib.parse
import urllib.request
from datetime import datetime, timezone
from pathlib import Path

# ─── PATHS ───────────────────────────────────────────────────────────────────
SECRETS = Path("/home/ubuntu/.openclaw/secrets")
DATA = Path("/home/ubuntu/mission-control-restored/data")
DATA.mkdir(parents=True, exist_ok=True)
DIRECTIVES = Path("/home/ubuntu/.openclaw/workspace/directives")
DIRECTIVES.mkdir(parents=True, exist_ok=True)

AUDIT_LOG               = DATA / "notification_audit.ndjson"
BOBA_NOTIFICATIONS_FEED = DIRECTIVES / "firebase_signal_notifications.json"
RETRY_QUEUE_FILE        = DATA / "notification_retry_queue.ndjson"
STATUS_FILE             = DIRECTIVES / "notification_bridge_status.json"
BOBA_NOTIF_MAX = 100

# ─── SQLITE STORE (full history, alongside the rolling JSON feed) ────────────
import sqlite3 as _sqlite3
OPTIONS_FLOW_DB = Path("/home/ubuntu/mission-control-restored/data/options_flow.sqlite")


def _sqlite_insert_notification(rec):
    if not OPTIONS_FLOW_DB.exists():
        return
    try:
        conn = _sqlite3.connect(str(OPTIONS_FLOW_DB), timeout=10)
        cur = conn.cursor()
        cur.execute("""
            INSERT OR IGNORE INTO notifications
            (id, captured_at, source, path, package, ticker, title, message,
             category, raw_json)
            VALUES (?,?,?,?,?,?,?,?,?,?)
        """, (
            rec.get("id"), rec.get("captured_at"), rec.get("source"),
            rec.get("path"), rec.get("package"), rec.get("ticker"),
            rec.get("title"), rec.get("message"), rec.get("category"),
            json.dumps(rec),
        ))
        conn.commit()
        conn.close()
    except Exception as e:
        print(f"[bridge] sqlite notif insert err: {e}")



# ─── CONFIG ──────────────────────────────────────────────────────────────────
PORT = 8090
DEDUP_WINDOW_SECONDS = 60   # 1-minute bucket for hash collision
DEDUP_CACHE_MAX = 5000      # keep last N hashes in memory


def get_secret(name):
    p = SECRETS / name
    return p.read_text().strip() if p.exists() else None


# Auth token (rotates by writing to this file). If missing, falls back to a
# build-once token written at startup — log it on boot so you can find it.
BRIDGE_TOKEN = (
    get_secret("notification-bridge-token.txt")
    or os.environ.get("BRIDGE_TOKEN")
)

# Discord webhook — written by you into this file (the URL from your MacroDroid macro).
# Fallback chain mirrors firebase_signal_relay.py.
DISCORD_WEBHOOK = (
    get_secret("discord-webhook-bluestacks.txt")
    or get_secret("discord_best_options_webhook")
    or get_secret("discord_tv_signals_webhook")
)

COMPARE_WEBHOOK = get_secret("discord-webhook-5-27-2026.txt")


# ─── DEDUP CACHE (in-memory, sliding) ────────────────────────────────────────
_dedup_lock = threading.Lock()
_dedup_cache = {}   # hash -> first_seen_ts (epoch)


def is_duplicate(payload):
    """Return True if we've seen the same (pkg, title, body, minute-bucket) before."""
    pkg = payload.get("package", "")
    title = payload.get("title", "")
    body = payload.get("text", "") or payload.get("body", "")
    minute_bucket = int(time.time() // DEDUP_WINDOW_SECONDS)
    h = hashlib.sha256(f"{pkg}|{title}|{body}|{minute_bucket}".encode()).hexdigest()
    now = time.time()
    with _dedup_lock:
        if h in _dedup_cache:
            return True
        _dedup_cache[h] = now
        # Trim cache if too large
        if len(_dedup_cache) > DEDUP_CACHE_MAX:
            cutoff = now - (DEDUP_WINDOW_SECONDS * 10)
            stale = [k for k, t in _dedup_cache.items() if t < cutoff]
            for k in stale:
                del _dedup_cache[k]
    return False


# ─── RETRY QUEUE (persistent, simple NDJSON) ─────────────────────────────────
_retry_queue = queue.Queue()


def enqueue_retry(payload, target):
    rec = {"target": target, "payload": payload, "enqueued_at": time.time()}
    try:
        with RETRY_QUEUE_FILE.open("a") as f:
            f.write(json.dumps(rec) + "\n")
    except Exception as e:
        print(f"[bridge] retry-queue write failed: {e}")
    _retry_queue.put(rec)


def retry_worker():
    """Background thread that drains the retry queue with exponential backoff."""
    while True:
        try:
            rec = _retry_queue.get(timeout=60)
        except queue.Empty:
            continue
        delay = min(60 * (2 ** min(rec.get("attempts", 0), 6)), 3600)
        time.sleep(delay)
        if rec["target"] == "discord":
            if _do_post_discord(rec["payload"]):
                _COUNTERS["retried_ok"] += 1
            else:
                rec["attempts"] = rec.get("attempts", 0) + 1
                if rec["attempts"] < 10:
                    _retry_queue.put(rec)
                else:
                    _COUNTERS["dropped"] += 1
                    print(f"[bridge] dropped after 10 retries: {rec['payload'].get('title')}")


# ─── PERSISTENCE: AUDIT LOG ──────────────────────────────────────────────────
_persist_lock = threading.Lock()


def append_audit(payload, *, received_at):
    rec = {"received_at": received_at, **payload}
    with _persist_lock:
        with AUDIT_LOG.open("a") as f:
            f.write(json.dumps(rec) + "\n")


# ─── PERSISTENCE: BOBA/JAZZY FEED ────────────────────────────────────────────
def append_to_boba_feed(payload, *, received_at):
    """Match the shape firebase_signal_relay.py writes so Boba/Jazzy consumers
    don't need any new code. signal_kind=notification, with the macrodroid
    source labeled distinctly so the feed reader can tell apart."""
    pkg = payload.get("package", "")
    title = payload.get("title", "")
    body = payload.get("text", "") or payload.get("body", "")
    # Stable ID across re-fires within the dedup window
    notif_id = hashlib.sha256(f"{pkg}|{title}|{body}|{received_at[:16]}".encode()).hexdigest()[:24]
    rec = {
        "id": f"macrodroid:{notif_id}",
        "signal_kind": "notification",
        "source": "MacroDroid",
        "path": payload.get("app_name") or pkg,
        "package": pkg,
        "ticker": payload.get("ticker", ""),
        "title": title,
        "message": body,
        "category": payload.get("category", ""),
        "captured_at": received_at,
    }
    with _persist_lock:
        existing = []
        if BOBA_NOTIFICATIONS_FEED.exists():
            try:
                existing = json.loads(BOBA_NOTIFICATIONS_FEED.read_text())
                if not isinstance(existing, list):
                    existing = []
            except Exception:
                existing = []
        combined = (existing + [rec])
        seen = set()
        deduped = []
        for r in reversed(combined):
            if r.get("id") not in seen:
                seen.add(r.get("id"))
                deduped.append(r)
        deduped = list(reversed(deduped))[-BOBA_NOTIF_MAX:]
        BOBA_NOTIFICATIONS_FEED.write_text(json.dumps(deduped, indent=2))
        # Dual-write to SQLite (full history beyond the rolling cap)
        _sqlite_insert_notification(rec)


# ─── DISCORD FORWARD ─────────────────────────────────────────────────────────
def _do_post_discord(payload):
    if not DISCORD_WEBHOOK:
        return False
    title = payload.get("title", "(no title)")
    body = payload.get("text", "") or payload.get("body", "")
    app_name = payload.get("app_name") or payload.get("package", "")
    msg = f"**{app_name}** — {title}\n{body}"
    data = json.dumps({"username": "Signal Bridge", "content": msg[:1900]}).encode()
    req = urllib.request.Request(DISCORD_WEBHOOK, data=data, method="POST",
                                  headers={
                                      "Content-Type": "application/json",
                                      "User-Agent": "mission-control-bridge/1.0 (+https://github.com/discord/discord-api-docs)",
                                  })
    try:
        with urllib.request.urlopen(req, timeout=10) as resp:
            return 200 <= resp.status < 300
    except Exception as e:
        print(f"[bridge] discord post failed: {e}")
        return False


def _post_compare(payload):
    if not COMPARE_WEBHOOK:
        return
    title = payload.get("title", "(no title)")
    body = payload.get("text", "") or payload.get("body", "")
    app_name = payload.get("app_name") or payload.get("package", "")
    msg = f"**{app_name}** — {title}\n{body}"
    data = json.dumps({"username": "BlueStacks/MacroDroid", "content": msg[:1900]}).encode()
    req = urllib.request.Request(COMPARE_WEBHOOK, data=data, method="POST",
                                  headers={"Content-Type": "application/json",
                                           "User-Agent": "mission-control-bridge/1.0"})
    try:
        with urllib.request.urlopen(req, timeout=10):
            pass
    except Exception as e:
        print(f"[bridge] compare post failed: {e}")


def forward_to_discord(payload):
    if _do_post_discord(payload):
        _COUNTERS["forwarded_ok"] += 1
    else:
        _COUNTERS["forwarded_fail"] += 1
        enqueue_retry(payload, "discord")
    _post_compare(payload)


# ─── COUNTERS + STATUS ───────────────────────────────────────────────────────
_COUNTERS = {
    "received": 0, "duplicates": 0, "filtered_junk": 0,
    "forwarded_ok": 0, "forwarded_fail": 0,
    "retried_ok": 0, "dropped": 0,
}

# Regex that matches an unsubstituted MacroDroid magic-text token AS THE WHOLE STRING.
# Examples that match: "{lv=payload}", "{not_title}", "{notification}", "{not_app_name}"
_UNSUB_PLACEHOLDER_RE = re.compile(
    r"^\s*\{(?:lv=\w+|not_\w+|notification|app_name|app_package)\}\s*$"
)


def _is_placeholder(s):
    if not s or not isinstance(s, str):
        return False
    return bool(_UNSUB_PLACEHOLDER_RE.match(s))


def is_junk_payload(payload):
    """A payload is junk if all of its useful content fields are either empty
    or unsubstituted MacroDroid placeholder tokens. We drop these before the
    feed write + Discord forward so Boba/Jazzy never see them."""
    title = payload.get("title", "") or ""
    text = payload.get("text", "") or ""
    content = payload.get("content", "") or ""
    app = payload.get("app_name", payload.get("username", "")) or ""
    pkg = payload.get("package", "") or ""
    fields = [title, text, content, app, pkg]
    # All non-empty fields must be placeholders for it to be junk.
    non_empty = [f for f in fields if f.strip()]
    if not non_empty:
        return True  # nothing useful at all
    return all(_is_placeholder(f) for f in non_empty)
_LAST_RECEIVED_AT = None
_LAST_HEARTBEAT_AT = None   # last forwarder __heartbeat__ ping (liveness, independent of app activity)


def write_status():
    try:
        STATUS_FILE.write_text(json.dumps({
            "ok": True,
            "last_received_at": _LAST_RECEIVED_AT,
            "last_heartbeat_at": _LAST_HEARTBEAT_AT,
            "counters": _COUNTERS,
            "dedup_cache_size": len(_dedup_cache),
            "retry_queue_size": _retry_queue.qsize(),
            "discord_webhook_configured": bool(DISCORD_WEBHOOK),
        }, indent=2))
    except Exception as e:
        print(f"[bridge] status write failed: {e}")


# ─── HTTP HANDLER ────────────────────────────────────────────────────────────

# ─── READ-ONLY SQLITE QUERY ENDPOINTS (used by the local web UI) ─────────────
def _db_query(query, params=()):
    """Run a SELECT against options_flow.sqlite and return list-of-dicts."""
    try:
        conn = _sqlite3.connect(str(OPTIONS_FLOW_DB), timeout=10)
        conn.row_factory = _sqlite3.Row
        cur = conn.cursor()
        cur.execute(query, params)
        rows = [dict(r) for r in cur.fetchall()]
        conn.close()
        return rows
    except Exception as e:
        print(f"[bridge] db query failed: {e}")
        return []


def db_handle(self, parsed):
    """Dispatch /db/<table>?limit=&ticker=&since= -> JSON.
    Returns True if handled (response already sent), False otherwise."""
    if not parsed.path.startswith("/db/"):
        return False

    qs = urllib.parse.parse_qs(parsed.query)
    try:
        limit = min(int(qs.get("limit", ["100"])[0]), 1000)
    except (ValueError, TypeError):
        limit = 100
    ticker = (qs.get("ticker", [""])[0] or "").upper().strip() or None
    since = qs.get("since", [""])[0] or None
    account = qs.get("account", [""])[0] or None

    table_path = parsed.path[len("/db/"):]

    if table_path == "stats":
        out = {}
        for tbl in ("flow_alerts", "trade_signals", "notifications", "auto_trader_orders"):
            rows = _db_query(f"SELECT COUNT(*) AS n FROM {tbl}")
            out[tbl] = rows[0]["n"] if rows else 0
        # latest captured_at per table
        for tbl in ("flow_alerts", "trade_signals", "notifications"):
            r = _db_query(f"SELECT MAX(captured_at) AS latest FROM {tbl}")
            out[f"{tbl}_latest"] = r[0]["latest"] if r else None
        r = _db_query("SELECT MAX(placed_at) AS latest FROM auto_trader_orders WHERE status NOT IN ('seeded','skipped')")
        out["auto_trader_orders_last_real_order"] = r[0]["latest"] if r else None
        self._send_json(200, out)
        return True

    if table_path == "flow-alerts":
        where, params = ["1=1"], []
        if ticker:
            where.append("ticker = ?")
            params.append(ticker)
        if since:
            where.append("captured_at >= ?")
            params.append(since)
        rows = _db_query(
            f"SELECT * FROM flow_alerts WHERE {' AND '.join(where)} "
            f"ORDER BY captured_at DESC LIMIT {limit}",
            tuple(params),
        )
        self._send_json(200, {"table": "flow_alerts", "rows": rows, "count": len(rows)})
        return True

    if table_path == "trade-signals":
        where, params = ["1=1"], []
        if ticker:
            where.append("ticker = ?")
            params.append(ticker)
        if since:
            where.append("captured_at >= ?")
            params.append(since)
        rows = _db_query(
            f"SELECT * FROM trade_signals WHERE {' AND '.join(where)} "
            f"ORDER BY captured_at DESC LIMIT {limit}",
            tuple(params),
        )
        self._send_json(200, {"table": "trade_signals", "rows": rows, "count": len(rows)})
        return True

    if table_path == "notifications":
        where, params = ["1=1"], []
        if ticker:
            where.append("ticker = ?")
            params.append(ticker)
        if since:
            where.append("captured_at >= ?")
            params.append(since)
        rows = _db_query(
            f"SELECT * FROM notifications WHERE {' AND '.join(where)} "
            f"ORDER BY captured_at DESC LIMIT {limit}",
            tuple(params),
        )
        self._send_json(200, {"table": "notifications", "rows": rows, "count": len(rows)})
        return True

    if table_path == "auto-trader-orders":
        where, params = ["1=1"], []
        if ticker:
            where.append("ticker = ?")
            params.append(ticker)
        if account:
            where.append("account = ?")
            params.append(account)
        if since:
            where.append("placed_at >= ?")
            params.append(since)
        rows = _db_query(
            f"SELECT * FROM auto_trader_orders WHERE {' AND '.join(where)} "
            f"ORDER BY placed_at DESC LIMIT {limit}",
            tuple(params),
        )
        self._send_json(200, {"table": "auto_trader_orders", "rows": rows, "count": len(rows)})
        return True

    if table_path == "top-flow-tickers":
        rows = _db_query(
            "SELECT ticker, COUNT(*) AS alerts, SUM(flow_value) AS total_premium "
            "FROM flow_alerts WHERE ticker IS NOT NULL "
            "GROUP BY ticker ORDER BY total_premium DESC LIMIT ?",
            (limit,),
        )
        self._send_json(200, {"rows": rows, "count": len(rows)})
        return True

    if table_path == "premium-shortlist":
        # Read-only: the desk's published picks (band/score/curator thesis/lane/conviction)
        # for ARIES to surface as a "desk verdict" on the Contract Card. No ticker column
        # (the contract lives inside dossier_json), so callers match by ticker+strike+expiry.
        where, params = ["1=1"], []
        if since:
            where.append("published_at >= ?")
            params.append(since)
        rows = _db_query(
            f"SELECT id, cycle_id, rank, band, score, published_at, target_account, "
            f"asset_class, signal_id, dossier_json "
            f"FROM premium_shortlist_published WHERE {' AND '.join(where)} "
            f"ORDER BY published_at DESC LIMIT {limit}",
            tuple(params),
        )
        self._send_json(200, {"table": "premium_shortlist_published", "rows": rows, "count": len(rows)})
        return True

    self._send_json(404, {"error": f"unknown table: {table_path}"})
    return True


class Handler(http.server.BaseHTTPRequestHandler):
    def log_message(self, fmt, *args):
        print(f"[bridge] {self.address_string()} - {fmt % args}")

    def _send_json(self, code, obj):
        body = json.dumps(obj).encode()
        self.send_response(code)
        self.send_header("Content-Type", "application/json")
        self.send_header("Content-Length", str(len(body)))
        self.end_headers()
        self.wfile.write(body)

    def do_GET(self):
        parsed = urllib.parse.urlparse(self.path)
        if parsed.path == "/health":
            self._send_json(200, {
                "ok": True,
                "last_received_at": _LAST_RECEIVED_AT,
                "counters": _COUNTERS,
                "dedup_cache_size": len(_dedup_cache),
                "retry_queue_size": _retry_queue.qsize(),
                "discord_webhook_configured": bool(DISCORD_WEBHOOK),
            })
        elif parsed.path.startswith("/db/"):
            # Token auth for db endpoints — same token as POST /notify
            qs = urllib.parse.parse_qs(parsed.query)
            provided = (qs.get("token", [""])[0]
                        or self.headers.get("X-Bridge-Token", ""))
            if BRIDGE_TOKEN and provided != BRIDGE_TOKEN:
                self._send_json(401, {"error": "bad token"})
                return
            db_handle(self, parsed)
        else:
            self._send_json(404, {"error": "not found"})

    def do_POST(self):
        parsed = urllib.parse.urlparse(self.path)
        if parsed.path != "/notify":
            self._send_json(404, {"error": "not found"})
            return

        # Token auth
        qs = urllib.parse.parse_qs(parsed.query)
        provided = (qs.get("token", [""])[0]
                    or self.headers.get("X-Bridge-Token", ""))
        if BRIDGE_TOKEN and provided != BRIDGE_TOKEN:
            self._send_json(401, {"error": "bad token"})
            return

        # Parse body — accept either:
        #   (a) {title, text, app_name, package}  — shim-native shape
        #   (b) {content, username}                — Discord webhook shape (MacroDroid default)
        #   (c) malformed JSON with literal newlines  — regex-fallback extract
        import re as _re
        clen = int(self.headers.get("Content-Length", "0"))
        raw = self.rfile.read(clen) if clen > 0 else b""
        raw_str = raw.decode("utf-8", errors="replace")
        try:
            payload = json.loads(raw_str or "{}")
            if not isinstance(payload, dict):
                payload = {"text": raw_str}
        except Exception:
            payload = {"text": raw_str}

        # Discord-shape regex-fallback: if the body LOOKS like Discord JSON but didn't
        # parse cleanly (literal newlines inside content break json.loads), extract via regex.
        looks_like_discord = ('"username"' in raw_str and '"content"' in raw_str)
        if looks_like_discord and not payload.get("username"):
            m_user = _re.search(r'"username"\s*:\s*"([^"]*)"', raw_str)
            # content: lazy through trailing "} at end, allowing newlines inside
            m_content = _re.search(r'"content"\s*:\s*"(.+?)"\s*\}\s*\Z', raw_str, _re.DOTALL)
            if m_user:
                payload["username"] = m_user.group(1)
            if m_content:
                payload["content"] = m_content.group(1)
            if m_user or m_content:
                payload.pop("text", None)

        # Discord-shape normalization: turn {content, username} into our fields
        if not payload.get("title") and not payload.get("text"):
            content = payload.get("content", "")
            if content:
                # Handle BOTH literal newline AND escaped \n
                content = content.replace("\\n", "\n")
                if "\n" in content:
                    head, body = content.split("\n", 1)
                else:
                    head, body = content, ""
                payload["title"] = head.strip("* ")
                payload["text"] = body
            if payload.get("username") and not payload.get("app_name"):
                payload["app_name"] = payload["username"]

        global _LAST_RECEIVED_AT, _LAST_HEARTBEAT_AT

        # Heartbeat ping from the phone/BlueStacks forwarder — liveness ONLY.
        # Match __heartbeat__ as a STANDALONE field value (not a substring) so a real
        # notification that merely contains the word can't be swallowed (skipping
        # audit/DB/Discord) AND can't spuriously refresh forwarder-liveness. The
        # MacroDroid heartbeat macro sends exactly {"title":"__heartbeat__"}.
        _hb_fields = (str(payload.get('title', '') or ''),
                      str(payload.get('text', '') or ''),
                      str(payload.get('content', '') or ''))
        if payload.get("type") == "heartbeat" or any(f.strip() == "__heartbeat__" for f in _hb_fields):
            _LAST_HEARTBEAT_AT = datetime.now(timezone.utc).isoformat()
            # Process-safe liveness: a dedicated epoch file ONLY this heartbeat path
            # writes, so a normal POST's write_status() can't clobber it. (Server is
            # ThreadingMixIn / single-process; the file also survives restarts and is
            # decoupled from the status file.) The signal_watchdog reads this file.
            try:
                hbf = "/home/ubuntu/firebase-signals/notif_forwarder_heartbeat"
                with open(hbf + ".tmp", "w") as _f:
                    _f.write(str(time.time()))
                os.replace(hbf + ".tmp", hbf)
            except Exception as _e:
                print(f"[bridge] heartbeat file write failed: {_e}")
            self._send_json(200, {"ok": True, "heartbeat": True})
            return

        _LAST_RECEIVED_AT = datetime.now(timezone.utc).isoformat()
        _COUNTERS["received"] += 1

        # 1. Persist first (most important — never lose data)
        try:
            append_audit(payload, received_at=_LAST_RECEIVED_AT)
        except Exception as e:
            print(f"[bridge] audit write failed: {e}")

        # 2. Dedup
        if is_duplicate(payload):
            _COUNTERS["duplicates"] += 1
            write_status()
            self._send_json(200, {"ok": True, "deduped": True})
            return

        # 3. Junk filter — drop unsubstituted-placeholder payloads BEFORE
        # they reach the Boba feed or Discord. Audit log already has them.
        if is_junk_payload(payload):
            _COUNTERS["filtered_junk"] += 1
            print(f"[bridge] dropped junk (unsubstituted placeholders): {json.dumps(payload)[:200]}")
            write_status()
            self._send_json(200, {"ok": True, "filtered": True})
            return

        # 4. Boba/Jazzy feed
        try:
            append_to_boba_feed(payload, received_at=_LAST_RECEIVED_AT)
        except Exception as e:
            print(f"[bridge] boba feed write failed: {e}")

        # 5. Discord forward
        forward_to_discord(payload)

        write_status()
        self._send_json(200, {"ok": True, "received": True})


class ThreadingServer(socketserver.ThreadingMixIn, http.server.HTTPServer):
    daemon_threads = True
    allow_reuse_address = True


if __name__ == "__main__":
    if not BRIDGE_TOKEN:
        # First-run convenience: mint a token, write it to the secrets file,
        # log it loudly so the user can configure MacroDroid.
        import secrets as _secrets
        BRIDGE_TOKEN = _secrets.token_urlsafe(24)
        try:
            (SECRETS / "notification-bridge-token.txt").write_text(BRIDGE_TOKEN)
        except Exception as e:
            print(f"[bridge] could not write token to secrets ({e}) — using ephemeral")
        print(f"[bridge] MINTED NEW TOKEN: {BRIDGE_TOKEN}")
        print(f"[bridge]   (saved to {SECRETS}/notification-bridge-token.txt)")
        print(f"[bridge]   MacroDroid URL: http://<host>:{PORT}/notify?token={BRIDGE_TOKEN}")

    print(f"[bridge] starting on 0.0.0.0:{PORT}")
    print(f"[bridge] discord webhook: {'configured' if DISCORD_WEBHOOK else 'MISSING'}")

    t = threading.Thread(target=retry_worker, daemon=True)
    t.start()

    write_status()
    server = ThreadingServer(("0.0.0.0", PORT), Handler)
    try:
        server.serve_forever()
    except KeyboardInterrupt:
        print("[bridge] stopped.")
