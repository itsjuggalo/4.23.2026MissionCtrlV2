#!/usr/bin/env python3
"""Item 35: callable doc-conversion tool using Microsoft MarkItDown.

Public function:
    convert_doc(path_or_url, timeout=30) -> dict

Returns:
    {
        'ok': bool,
        'source_path': str,
        'title': str | None,
        'content': str,        # cleaned markdown
        'format': str,         # 'pdf' | 'xlsx' | 'docx' | 'pptx' | 'csv' | 'image' | etc.
        'error': str | None,
    }

Handles: PDF, Excel xlsx/xls, Word docx, PowerPoint pptx, CSV, JSON, XML,
HTML, ZIP, EPUB, images with OCR. Pairs with web_scraper - that handles URLs,
this handles binary docs.

Use cases for MC:
- SEC 10-K, 10-Q PDFs
- 13F holdings spreadsheets
- Earnings call transcript PDFs
- Investor deck PowerPoints
- Any binary doc Boba/Jazzy/Orion needs to ingest

Designed for graceful degradation - never raises, always returns a dict.
"""
import sys, os
from pathlib import Path

SUPPORTED_EXTS = {
    '.pdf', '.xlsx', '.xls', '.docx', '.pptx', '.csv', '.json', '.xml',
    '.html', '.htm', '.zip', '.epub', '.txt', '.md',
    '.png', '.jpg', '.jpeg', '.gif', '.bmp',
    '.mp3', '.wav', '.m4a',
}


def _detect_format(path):
    """Detect format from file extension."""
    if not path:
        return 'unknown'
    ext = Path(path).suffix.lower()
    if ext.startswith('.'):
        return ext[1:]
    return 'unknown'


def convert_doc(path_or_url, timeout=30):
    """Convert any binary doc to clean markdown via MarkItDown.

    Args:
        path_or_url: local file path OR a URL (MarkItDown handles both)
        timeout: not currently used by MarkItDown but kept for API consistency

    Returns:
        dict with keys: ok, source_path, title, content, format, error
    """
    if not path_or_url:
        return {
            'ok': False, 'source_path': str(path_or_url), 'title': None,
            'content': '', 'format': 'unknown',
            'error': 'empty path or url',
        }

    p_str = str(path_or_url)

    # If it looks like a local path, verify it exists
    if not p_str.startswith(('http://', 'https://')):
        if not Path(p_str).exists():
            return {
                'ok': False, 'source_path': p_str, 'title': None,
                'content': '', 'format': 'unknown',
                'error': f'file not found: {p_str}',
            }

    fmt = _detect_format(p_str)

    try:
        from markitdown import MarkItDown
    except ImportError as e:
        return {
            'ok': False, 'source_path': p_str, 'title': None,
            'content': '', 'format': fmt,
            'error': f'markitdown not installed: {e}',
        }

    try:
        md = MarkItDown()
        result = md.convert(p_str)
        content = getattr(result, 'text_content', '') or ''
        title = getattr(result, 'title', None)
        if not content:
            return {
                'ok': False, 'source_path': p_str, 'title': title,
                'content': '', 'format': fmt,
                'error': 'empty conversion result',
            }
        return {
            'ok': True, 'source_path': p_str, 'title': title,
            'content': content, 'format': fmt,
            'error': None,
        }
    except Exception as e:
        return {
            'ok': False, 'source_path': p_str, 'title': None,
            'content': '', 'format': fmt,
            'error': f'conversion failed: {type(e).__name__}: {e}',
        }


if __name__ == '__main__':
    if len(sys.argv) < 2:
        print('usage: doc_converter.py <path_or_url>')
        sys.exit(1)
    target = sys.argv[1]
    result = convert_doc(target)
    if result['ok']:
        print(f"Format: {result['format']}")
        print(f"Title: {result['title']}")
        print(f"Content length: {len(result['content'])} chars")
        print(f"--- First 500 chars ---")
        print(result['content'][:500])
    else:
        print(f"FAILED: {result['error']}")
        sys.exit(1)
