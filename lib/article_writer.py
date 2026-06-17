"""
article_writer.py — helper for cron generators to emit AI-author articles.

Usage:
    from lib.article_writer import publish_article

    publish_article(
        author_id='raynor',
        title='NVDA breaks key resistance',
        summary='Nvidia cleared the $950 level on heavy volume after hours.',
        body_md='## What happened\\n...full analysis...',
        tickers=['NVDA'],
        source='desk_analysis',
    )

The row lands as status='draft' in data/articles.sqlite.
The operator approves via the /explore review queue (loopback-only PATCH).
"""

import sqlite3
import json
import os
from datetime import datetime, timezone

# Absolute path — same DB that the Next.js API routes open.
# Resolved once at import time so callers can be in any working directory.
_DB_PATH = '/AIWorkWSL/web/missionctrl/data/articles.sqlite'


def _open_db() -> sqlite3.Connection:
    """Open (or create) the articles DB with the same schema as the API route."""
    conn = sqlite3.connect(_DB_PATH, timeout=5)
    conn.execute('PRAGMA journal_mode=WAL')
    # Note: Python stdlib sqlite3 rejects function-call DEFAULTs (e.g. datetime('now'))
    # even though SQLite itself allows them. Timestamp is inserted explicitly by
    # publish_article(), so the DEFAULT clause is omitted here — schema stays
    # compatible with the Next.js better-sqlite3 schema that includes it.
    conn.execute('''
        CREATE TABLE IF NOT EXISTS articles (
            id           INTEGER PRIMARY KEY,
            author_id    TEXT    NOT NULL,
            title        TEXT    NOT NULL,
            summary      TEXT    NOT NULL DEFAULT '',
            body_md      TEXT    NOT NULL DEFAULT '',
            tickers      TEXT,
            status       TEXT    NOT NULL DEFAULT 'draft',
            source       TEXT,
            created_at   TEXT    NOT NULL,
            published_at TEXT
        )
    ''')
    conn.execute("CREATE INDEX IF NOT EXISTS idx_articles_status    ON articles(status)")
    conn.execute("CREATE INDEX IF NOT EXISTS idx_articles_author    ON articles(author_id)")
    conn.execute("CREATE INDEX IF NOT EXISTS idx_articles_published ON articles(published_at DESC)")
    conn.commit()
    return conn


def publish_article(
    author_id: str,
    title: str,
    summary: str = '',
    body_md: str = '',
    tickers: list[str] | None = None,
    source: str | None = None,
) -> int:
    """
    Insert a DRAFT article row. Returns the new row id.

    Parameters
    ----------
    author_id : str
        Must match an id in AIME_SPECIALISTS (e.g. 'raynor', 'fenix').
    title : str
        Article headline.
    summary : str
        One-paragraph AI summary shown in feed cards and the detail header.
    body_md : str
        Full article body in Markdown.
    tickers : list[str] | None
        e.g. ['NVDA', 'SPY'] — stored as JSON array.
    source : str | None
        Provenance label, e.g. 'morning_brief' or 'flow_digest'.
    """
    tickers_json = json.dumps(tickers) if tickers else None
    created_at = datetime.now(tz=timezone.utc).strftime('%Y-%m-%d %H:%M:%S')

    conn = _open_db()
    try:
        cur = conn.execute(
            '''INSERT INTO articles
               (author_id, title, summary, body_md, tickers, source, created_at)
               VALUES (?, ?, ?, ?, ?, ?, ?)''',
            (author_id, title, summary, body_md, tickers_json, source, created_at),
        )
        conn.commit()
        return cur.lastrowid  # type: ignore[return-value]
    finally:
        conn.close()
