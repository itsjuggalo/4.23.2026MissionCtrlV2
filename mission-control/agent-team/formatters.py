"""
Human-readable formatters for different agent message types.
All return plain strings ready to pass to post_helper.post_to_telegram.
"""
from typing import List, Dict, Any

def format_flow_scan(top_candidates: List[Dict[str, Any]], total_scanned: int = 0, total_passed: int = 0) -> str:
    if not top_candidates:
        return f"{total_scanned} contracts scanned, 0 passed filter."
    lines = []
    if total_scanned:
        lines.append(f"{total_scanned} → {total_passed or len(top_candidates)} passed filter")
    for i, c in enumerate(top_candidates[:5], 1):
        ticker = c.get("ticker", c.get("symbol", "?"))
        strike = c.get("strike", "?")
        cp = c.get("type", c.get("right", ""))[:1].upper() or "?"
        exp = c.get("expiry", c.get("expiration", ""))[:10]
        score = c.get("score", c.get("total_score", "?"))
        reason = c.get("top_reason", c.get("primary_reason", ""))
        summary = f"{i}. {ticker} {strike}{cp} {exp} — {score}"
        if reason:
            summary += f" ({reason})"
        lines.append(summary)
    return "\n".join(lines)

def format_pick_announcement(ticker: str, strike: float, expiry: str, right: str,
                              contracts: int, risk_usd: float, target_usd: float,
                              reasoning: str) -> str:
    return (
        f"{ticker} {strike}{right.upper()[:1]} {expiry}, {contracts} contracts\n"
        f"Risk ${risk_usd:,.0f} → Target ${target_usd:,.0f} (R:R {target_usd/risk_usd:.1f})\n"
        f"Reason: {reasoning}"
    )

def format_position_update(ticker: str, entry: float, current: float, pnl_pct: float, pnl_usd: float) -> str:
    arrow = "📈" if pnl_pct >= 0 else "📉"
    return (
        f"{arrow} {ticker}: {entry:.2f} → {current:.2f} "
        f"({pnl_pct:+.1f}%, ${pnl_usd:+,.0f})"
    )

def format_eod_summary(trades_today: int, pnl_today_usd: float, win_count: int,
                       loss_count: int, open_positions: int) -> str:
    win_rate = (win_count / max(trades_today, 1)) * 100 if trades_today else 0
    arrow = "✅" if pnl_today_usd >= 0 else "❌"
    return (
        f"{arrow} EOD: {trades_today} trades, "
        f"${pnl_today_usd:+,.0f} P&L, "
        f"{win_count}W/{loss_count}L ({win_rate:.0f}% hit rate)\n"
        f"Open positions: {open_positions}"
    )

def format_news_context(ticker: str, headline: str, source: str = "", impact: str = "") -> str:
    line = f"{ticker}: {headline}"
    if source:
        line += f" ({source})"
    if impact:
        line += f"\nImpact: {impact}"
    return line

def format_thesis_check(ticker: str, bull_case: str, bear_case: str, invalidation: str) -> str:
    return (
        f"{ticker} thesis review:\n"
        f"Bull: {bull_case}\n"
        f"Bear: {bear_case}\n"
        f"Invalidation: {invalidation}"
    )
