#!/usr/bin/env python3
"""Item 33: callable web-scrape tool.

Public function:
    scrape_url(url, mode='markdown', timeout=15) -> dict

Returns:
    {
        'ok': bool,
        'url': str,
        'title': str | None,
        'content': str,        # cleaned markdown or text
        'source': str,         # 'firecrawl' | 'trafilatura' | 'requests'
        'error': str | None,
    }

Behavior:
    1. If FIRECRAWL_API_KEY exists in secrets, try Firecrawl first
    2. On Firecrawl failure or absence, fall back to trafilatura
    3. On trafilatura failure, fall back to raw requests + bs4 strip

Used by any agent that needs clean text from a URL (SEC filings, news, blogs).
Designed for graceful degradation - never raises, always returns a dict.

Per Mike rules: no credential rotation reminders. If FIRECRAWL_API_KEY is
missing, just use the fallback silently.
"""
import json, sys, time
from pathlib import Path

SECRETS = Path.home() / ".openclaw" / "secrets"
DEFAULT_UA = "MissionCtrl-WebScraper/1.0"


def _load_firecrawl_key():
    p = SECRETS / "firecrawl_api_key"
    if p.exists():
        try:
            k = p.read_text().strip()
            if k and len(k) > 10:
                return k
        except Exception:
            pass
    return None


def _scrape_firecrawl(url, api_key, timeout=15):
    """Try Firecrawl cloud API. Returns dict or None on failure."""
    try:
        import requests
        r = requests.post(
            "https://api.firecrawl.dev/v1/scrape",
            headers={
                "Authorization": f"Bearer {api_key}",
                "Content-Type": "application/json",
            },
            json={
                "url": url,
                "formats": ["markdown"],
                "onlyMainContent": True,
            },
            timeout=timeout,
        )
        if r.status_code != 200:
            return None
        d = r.json()
        if not d.get("success"):
            return None
        data = d.get("data", {})
        return {
            "title": data.get("metadata", {}).get("title"),
            "content": data.get("markdown", ""),
            "source": "firecrawl",
        }
    except Exception:
        return None


def _scrape_trafilatura(url, timeout=15):
    """Fallback: trafilatura clean extraction. Returns dict or None."""
    try:
        import trafilatura
        downloaded = trafilatura.fetch_url(url, no_ssl=False)
        if not downloaded:
            return None
        # Extract as markdown for consistency with Firecrawl mode
        content = trafilatura.extract(
            downloaded,
            output_format="markdown",
            include_comments=False,
            include_tables=True,
        )
        if not content:
            return None
        # Try to grab the title from metadata
        try:
            meta = trafilatura.extract_metadata(downloaded)
            title = meta.title if meta else None
        except Exception:
            title = None
        return {
            "title": title,
            "content": content,
            "source": "trafilatura",
        }
    except Exception:
        return None


def _scrape_requests(url, timeout=15):
    """Last-resort fallback: requests + bs4 text strip. Returns dict or None."""
    try:
        import requests
        from bs4 import BeautifulSoup
        r = requests.get(url, headers={"User-Agent": DEFAULT_UA}, timeout=timeout)
        if r.status_code != 200:
            return None
        soup = BeautifulSoup(r.text, "lxml")
        # Strip script/style/nav/footer
        for tag in soup(["script", "style", "nav", "footer", "aside"]):
            tag.decompose()
        title = soup.title.string.strip() if soup.title and soup.title.string else None
        # Get visible text
        text = soup.get_text(separator="\n", strip=True)
        # Compress whitespace
        lines = [l.strip() for l in text.split("\n") if l.strip()]
        content = "\n".join(lines)
        return {
            "title": title,
            "content": content,
            "source": "requests",
        }
    except Exception:
        return None


def scrape_url(url, mode="markdown", timeout=15):
    """Main entry point. Tries Firecrawl, then trafilatura, then requests+bs4.

    Args:
        url: target URL to scrape
        mode: 'markdown' (default) or 'text'. Affects extraction style.
        timeout: per-request timeout in seconds

    Returns:
        dict with keys: ok, url, title, content, source, error
    """
    if not url or not isinstance(url, str) or not url.startswith(("http://", "https://")):
        return {
            "ok": False, "url": url, "title": None, "content": "",
            "source": None, "error": "invalid url",
        }

    fc_key = _load_firecrawl_key()
    if fc_key:
        result = _scrape_firecrawl(url, fc_key, timeout=timeout)
        if result and result.get("content"):
            return {
                "ok": True, "url": url,
                "title": result.get("title"),
                "content": result.get("content", ""),
                "source": "firecrawl",
                "error": None,
            }

    result = _scrape_trafilatura(url, timeout=timeout)
    if result and result.get("content"):
        return {
            "ok": True, "url": url,
            "title": result.get("title"),
            "content": result.get("content", ""),
            "source": "trafilatura",
            "error": None,
        }

    result = _scrape_requests(url, timeout=timeout)
    if result and result.get("content"):
        return {
            "ok": True, "url": url,
            "title": result.get("title"),
            "content": result.get("content", ""),
            "source": "requests",
            "error": None,
        }

    return {
        "ok": False, "url": url, "title": None, "content": "",
        "source": None, "error": "all extraction methods failed",
    }


if __name__ == "__main__":
    if len(sys.argv) < 2:
        print("usage: web_scraper.py <url>")
        sys.exit(1)
    url = sys.argv[1]
    result = scrape_url(url)
    if result["ok"]:
        print(f"Source: {result['source']}")
        print(f"Title: {result['title']}")
        print(f"Content length: {len(result['content'])} chars")
        print(f"--- First 500 chars ---")
        print(result["content"][:500])
    else:
        print(f"FAILED: {result['error']}")
        sys.exit(1)
