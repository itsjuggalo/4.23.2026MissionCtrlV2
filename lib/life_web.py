"""life_web — free web enrichment for LifeClaw briefs (LIFE-ONLY, never trading).

Surfaces useful real-time web finds in Mike's daily life brief using the local
free-search service (via [lib.search] → SearXNG :8888). $0, private.

  • coupon_line(brand)            — a live promo code / deal for a brand he already deals with
  • event_prep_line(title, city)  — hours / address / quick context for an upcoming calendar event
  • purchase_line(item)           — "best <item> 2026" review snippet before he buys
  • local_line(city)              — what's on near him this weekend
  • web_finds_block(brands, events, city) — assembled brief section (coupons + next-event prep)

Bounded (caps the number of searches), guarded, and NEVER raises — a web outage must
never break or delay a brief. Off-switch: set env LIFE_WEB=0 (default on).

  from lib.life_web import web_finds_block
"""
from __future__ import annotations

import os

try:
    from lib.search import web_search
except Exception:  # pragma: no cover - keep importable even if path odd
    def web_search(*a, **k):
        return []


def _enabled() -> bool:
    return str(os.getenv("LIFE_WEB", "1")).strip().lower() not in ("0", "false", "no", "off", "")


def _first(query: str, k: int = 3) -> dict | None:
    rows = web_search(query, k=k)
    return rows[0] if rows else None


def _snip(r: dict, maxlen: int = 130) -> str:
    s = (r.get("snippet") or "").strip().replace("\n", " ")
    return s[: maxlen - 1] + "…" if len(s) > maxlen else s


def coupon_line(brand: str) -> str:
    b = (brand or "").strip()
    if not b:
        return ""
    r = _first(f"{b} promo code coupon this month", k=3)
    if not r:
        return ""
    s = _snip(r, 120)
    return f"🎟 {b}: {s}" if s else ""


def event_prep_line(title: str, city: str | None = None) -> str:
    t = (title or "").strip()
    if len(t) < 3:
        return ""
    q = f"{t} {city} hours address".strip() if city else f"{t} hours address"
    r = _first(q, k=3)
    if not r:
        return ""
    s = _snip(r, 120)
    return f"📍 {t}: {s}" if s else ""


def purchase_line(item: str) -> str:
    it = (item or "").strip()
    if not it:
        return ""
    r = _first(f"best {it} 2026 review", k=3)
    if not r:
        return ""
    s = _snip(r, 120)
    return f"🛒 {it}: {s}" if s else ""


def local_line(city: str) -> str:
    c = (city or "").strip()
    if not c:
        return ""
    r = _first(f"things to do this weekend in {c}", k=3)
    if not r:
        return ""
    s = _snip(r, 120)
    return f"🗺 {c}: {s}" if s else ""


_BRAND_JUNK = {"deals", "info", "news", "noreply", "no-reply", "hello", "support",
               "team", "mail", "email", "newsletter", "offers", "sales", "notifications",
               "do-not-reply", "donotreply", "alerts", "account", "members"}


def _clean_brands(brands):
    out = []
    for b in (brands or []):
        b = (b or "").strip()
        if len(b) > 2 and b.lower() not in _BRAND_JUNK and b not in out:
            out.append(b)
    return out


def web_finds_block(brands=None, events=None, city: str | None = None, max_lines: int = 3) -> str:
    """Assemble a compact 'web finds' section (plain lines, no header). '' when disabled/empty."""
    if not _enabled():
        return ""
    lines: list[str] = []
    for b in _clean_brands(brands)[:2]:
        ln = coupon_line(b)
        if ln:
            lines.append(ln)
        if len(lines) >= max_lines:
            return "\n".join(lines)
    for e in (events or [])[:2]:
        ln = event_prep_line(e, city)
        if ln:
            lines.append(ln)
        if len(lines) >= max_lines:
            break
    return "\n".join(lines[:max_lines])


if __name__ == "__main__":
    import sys

    os.environ.setdefault("LIFE_WEB", "1")
    print(web_finds_block(brands=sys.argv[1:] or ["Amazon"], events=["dentist"], city="Indianapolis") or "(no finds)")
