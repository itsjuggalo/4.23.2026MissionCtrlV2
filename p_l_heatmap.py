#!/usr/bin/env python3
"""
P/L Heatmap Generator — price×date grid for option P/L visualization.
Used by Academy Reference mode to show theta + breakeven over time.

Formula: P/L = (current_price - entry_price) × greeks_weighted + theta_decay
For a call: P/L(S, t) = bs_price(S, K, t/365, vol) - entry_premium
"""

import sys
import math
from datetime import datetime, timedelta

sys.path.insert(0, '/AIWorkWSL/labs/quantum/src')
import theo


def pl_heatmap(entry_price, strike, kind, entry_dte, vol, spot, rows=11, cols=11):
    """
    Generate a P/L grid: rows = spot prices, cols = days to expiry.
    Returns: {grid: [[P/L,...], ...], spots: [S, ...], days: [d, ...], entry_spot, entry_dte}

    Args:
        entry_price: premium paid per share (float)
        strike: strike price (float)
        kind: "call" or "put"
        entry_dte: days to expiry at entry (int)
        vol: implied volatility as decimal (0.25 = 25%)
        spot: current spot price (float)
        rows: number of spot price rows (default 11 = ±5 increments from spot)
        cols: number of DTE columns (default 11 = from entry_dte down to 0)

    Returns:
        dict: {grid, spots, days, entry_spot, entry_dte, heatmap_type}
    """
    # Spot range: ±(10% of strike) / rows
    spot_range = strike * 0.10
    spot_step = spot_range / (rows // 2)
    spots = [strike - spot_range + (i * spot_step) for i in range(rows)]

    # DTE: entry_dte down to 0
    dte_step = max(1, entry_dte // (cols - 1)) if cols > 1 else 1
    days = [max(0, entry_dte - (i * dte_step)) for i in range(cols)]

    # Build P/L grid
    grid = []
    for s in spots:
        row = []
        for d in days:
            T = d / 365.0
            # Current price of the contract at spot S and DTE d
            current_price = theo.bs_price(s, strike, T, vol, kind=kind)
            # P/L per share (can be negative)
            pl_per_share = current_price - entry_price
            # As percentage of entry
            pl_pct = (pl_per_share / entry_price * 100) if entry_price != 0 else 0
            row.append(pl_pct)
        grid.append(row)

    return {
        'grid': grid,
        'spots': spots,
        'days': days,
        'entry_spot': spot,
        'entry_dte': entry_dte,
        'entry_price': entry_price,
        'heatmap_type': f'{kind.upper()} ${strike:.0f} straddle' if kind in ('call', 'put') else 'spread'
    }


def heatmap_to_svg(data, width=600, height=400, title=''):
    """
    Convert P/L heatmap to SVG with color-coded cells.
    Green = profit, Red = loss, White/Gray = near breakeven.
    """
    grid = data['grid']
    spots = data['spots']
    days = data['days']

    rows, cols = len(grid), len(grid[0]) if grid else 0
    if rows == 0 or cols == 0:
        return '<svg></svg>'

    # Find min/max for color scaling
    all_pls = [pl for row in grid for pl in row]
    min_pl = min(all_pls) if all_pls else -50
    max_pl = max(all_pls) if all_pls else 50

    # SVG dimensions
    margin = 60
    cell_width = (width - 2 * margin) / cols
    cell_height = (height - 2 * margin) / rows

    svg_lines = [
        f'<svg width="{width}" height="{height}" xmlns="http://www.w3.org/2000/svg">',
        '<defs>',
        '<style>',
        '.hm-cell { stroke: #ccc; stroke-width: 0.5; }',
        '.hm-label { font-size: 10px; fill: #333; }',
        '.hm-title { font-size: 14px; font-weight: bold; fill: #000; }',
        '</style>',
        '</defs>',
    ]

    # Title
    if title:
        svg_lines.append(f'<text x="{width/2}" y="25" text-anchor="middle" class="hm-title">{title}</text>')

    # Color function
    def pl_to_color(pl):
        if pl > 0:  # Green gradient
            ratio = min(pl / max_pl, 1.0) if max_pl > 0 else 0
            r = int(255 * (1 - ratio * 0.7))
            g = 255
            b = int(255 * (1 - ratio * 0.7))
        elif pl < 0:  # Red gradient
            ratio = min(abs(pl) / abs(min_pl), 1.0) if min_pl < 0 else 0
            r = 255
            g = int(255 * (1 - ratio * 0.7))
            b = int(255 * (1 - ratio * 0.7))
        else:  # White for breakeven
            r = g = b = 240
        return f'rgb({r},{g},{b})'

    # Grid cells
    for ri, row in enumerate(grid):
        for ci, pl in enumerate(row):
            x = margin + ci * cell_width
            y = margin + ri * cell_height
            color = pl_to_color(pl)
            svg_lines.append(f'<rect x="{x:.1f}" y="{y:.1f}" width="{cell_width:.1f}" height="{cell_height:.1f}" fill="{color}" class="hm-cell" />')
            # Show text only on extreme cells to avoid clutter
            if ri % 2 == 0 or ci % 3 == 0:
                svg_lines.append(f'<text x="{x + cell_width/2:.1f}" y="{y + cell_height/2 + 4:.1f}" text-anchor="middle" class="hm-label" opacity="0.4">{pl:.0f}%</text>')

    # Y-axis (spot prices)
    for ri, spot in enumerate(spots):
        y = margin + ri * cell_height + cell_height / 2
        svg_lines.append(f'<text x="{margin - 10:.1f}" y="{y:.1f}" text-anchor="end" class="hm-label">${spot:.0f}</text>')

    # X-axis (days)
    for ci, day in enumerate(days):
        x = margin + ci * cell_width + cell_width / 2
        svg_lines.append(f'<text x="{x:.1f}" y="{height - margin + 20:.1f}" text-anchor="middle" class="hm-label">{int(day)}d</text>')

    # Axis labels
    svg_lines.append(f'<text x="15" y="{height/2}" text-anchor="middle" class="hm-label" transform="rotate(-90 15 {height/2})">Spot Price</text>')
    svg_lines.append(f'<text x="{width/2}" y="{height - 10}" text-anchor="middle" class="hm-label">Days to Expiry</text>')

    svg_lines.append('</svg>')
    return '\n'.join(svg_lines)


if __name__ == '__main__':
    # Test: SPY $745 call, bought for $5.67, 7 DTE, 20% IV
    data = pl_heatmap(entry_price=5.67, strike=745, kind='call', entry_dte=7, vol=0.20, spot=744)
    svg = heatmap_to_svg(data, title='SPY $745 Call (7 DTE, 20% IV) — P/L over Price & Time')
    print(svg)
