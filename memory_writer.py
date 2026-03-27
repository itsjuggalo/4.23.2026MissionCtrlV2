#!/usr/bin/env python3
"""
Memory Writer — harvests insights from all agents and writes to memory store
Runs every 5 minutes, appends new memories, deduplicates by content hash
"""

import json
import time
import hashlib
from datetime import datetime, timezone
from pathlib import Path
from typing import Dict, List, Optional

BASE     = Path('/home/ubuntu/mission-control')
MEM_DIR  = BASE / 'memory'
MEM_FILE = MEM_DIR / 'memories.json'

MEM_DIR.mkdir(exist_ok=True)

# ── Helpers ───────────────────────────────────────────────────────────────────

def load_json(path: Path) -> Optional[dict | list]:
    try:
        if path.exists():
            with open(path) as f:
                return json.load(f)
    except Exception as e:
        print(f"  ⚠️  Could not read {path.name}: {e}")
    return None

def load_memories() -> List[Dict]:
    if MEM_FILE.exists():
        with open(MEM_FILE) as f:
            return json.load(f)
    return []

def save_memories(memories: List[Dict]):
    with open(MEM_FILE, 'w') as f:
        json.dump(memories, f, indent=2)

def make_id(content: str) -> str:
    return hashlib.md5(content.encode()).hexdigest()[:12]

def memory(title: str, content: str, source: str, tags: List[str],
           importance: str = 'medium') -> Dict:
    return {
        "id":         make_id(content),
        "title":      title,
        "content":    content,
        "source":     source,
        "tags":       tags,
        "importance": importance,   # low / medium / high / critical
        "timestamp":  datetime.now(timezone.utc).isoformat(),
        "date":       datetime.now().strftime('%b %d'),
    }

# ── Agent harvesters ──────────────────────────────────────────────────────────

def harvest_btc_bias() -> List[Dict]:
    data = load_json(BASE / 'btc-bias/btc-bias.json')
    if not data:
        return []
    bias  = data.get('bias', 'unknown')
    score = data.get('score', 0)
    mems  = []

    content = (f"BTC bias is {bias.upper()} with score {score}/13. "
               f"Fear & Greed: {data.get('fear_greed_index', '?')}. "
               f"Funding rate: {data.get('funding_rate', '?')}.")
    imp = 'high' if abs(score) >= 5 else 'medium'
    mems.append(memory(
        title=f"BTC Bias: {bias.upper()} ({score:+d}/13)",
        content=content,
        source='btc-bias-scorer',
        tags=['btc', 'bias', 'macro', bias.lower()],
        importance=imp
    ))
    return mems

def harvest_macro() -> List[Dict]:
    data = load_json(BASE / 'macro-strategist/macro_state.json')
    if not data:
        return []
    regime   = data.get('regime', 'unknown')
    score    = data.get('score', 0)
    modifier = data.get('modifier', 1.0)
    signals  = data.get('signals', {})

    parts = []
    for k, v in signals.items():
        if isinstance(v, dict) and v.get('summary'):
            parts.append(v['summary'])

    content = (f"Macro regime is {regime.upper()} (score {score}/12, "
               f"position modifier {modifier}x). " + ' '.join(parts[:3]))
    imp = 'critical' if regime in ['CRISIS', 'BEAR'] else 'high' if regime == 'RISK_OFF' else 'medium'

    return [memory(
        title=f"Macro Regime: {regime} ({modifier}x modifier)",
        content=content,
        source='macro-strategist',
        tags=['macro', 'regime', regime.lower().replace('_', '-')],
        importance=imp
    )]

def harvest_analyst() -> List[Dict]:
    data = load_json(BASE / 'analyst/analysis_results.json')
    if not data or not isinstance(data, list):
        return []

    mems = []
    # Take last 5 analyses
    for result in data[-5:]:
        symbol    = result.get('symbol', '?')
        direction = result.get('direction', '?')
        score     = result.get('score', 0)
        entry     = result.get('entry', 0)
        targets   = result.get('targets', [])
        inds      = result.get('indicators', {})

        rsi  = inds.get('rsi', {}).get('value', '?')
        macd = inds.get('macd', {}).get('signal', '?')
        ma   = inds.get('moving_averages', {}).get('structure', '?')

        content = (f"{symbol} {direction} signal at ${entry:,.2f}. "
                   f"Score: {score}. RSI: {rsi}, MACD: {macd}. "
                   f"MA structure: {ma}. "
                   f"Targets: {', '.join(f'${t:,.2f}' for t in targets[:2])}.")

        mems.append(memory(
            title=f"Analyst: {symbol} {direction} @ ${entry:,.2f}",
            content=content,
            source='analyst',
            tags=['analysis', symbol.lower(), direction.lower(), 'technicals'],
            importance='high' if abs(score) >= 3 else 'medium'
        ))
    return mems

def harvest_portfolio() -> List[Dict]:
    data = load_json(BASE / 'portfolio-monitor/portfolio_state.json')
    if not data:
        return []

    total   = data.get('total_value_usd', 0)
    pnl_day = data.get('total_pnl_today_usd', 0)
    pnl_wk  = data.get('total_pnl_week_usd', 0)
    deployed= data.get('deployed_pct', 0)
    cash    = data.get('cash_available', 0)

    content = (f"Portfolio value: ${total:,.2f}. "
               f"Today P&L: ${pnl_day:+,.2f}. "
               f"Week P&L: ${pnl_wk:+,.2f}. "
               f"Deployed: {deployed:.1f}%, Cash: ${cash:,.2f}.")

    positions = data.get('positions', [])
    if positions:
        top = sorted(positions, key=lambda x: abs(x.get('unrealized_pnl_usd', 0)), reverse=True)[:3]
        pos_str = ', '.join(f"{p['symbol']} ({p.get('unrealized_pnl_pct', 0):+.1f}%)" for p in top)
        content += f" Top movers: {pos_str}."

    imp = 'high' if abs(pnl_day) > 500 else 'medium'
    return [memory(
        title=f"Portfolio: ${total:,.0f} | Day {pnl_day:+,.0f}",
        content=content,
        source='portfolio-monitor',
        tags=['portfolio', 'pnl', 'positions'],
        importance=imp
    )]

def harvest_risk() -> List[Dict]:
    data = load_json(BASE / 'risk-manager/risk_state.json')
    if not data:
        return []

    mems     = []
    daily    = data.get('daily_pnl', 0)
    weekly   = data.get('weekly_pnl', 0)
    losses   = data.get('consecutive_losses', 0)
    port_val = data.get('portfolio_value', 0)

    content = (f"Risk state: portfolio ${port_val:,.0f}. "
               f"Daily P&L: {daily:+.1f}%, weekly: {weekly:+.1f}%. "
               f"Consecutive losses: {losses}.")

    imp = 'critical' if losses >= 3 else 'high' if losses >= 2 else 'medium'
    mems.append(memory(
        title=f"Risk State: {losses} consecutive losses",
        content=content,
        source='risk-manager',
        tags=['risk', 'drawdown', 'pnl'],
        importance=imp
    ))

    # Recent veto decisions
    decisions = data.get('decisions', [])
    vetoes = [d for d in decisions[-10:] if d.get('decision') == 'VETOED']
    for v in vetoes[-3:]:
        sym    = v.get('symbol', '?')
        reason = v.get('reason', 'No reason given')
        mems.append(memory(
            title=f"Risk Veto: {sym}",
            content=f"Risk manager vetoed {sym} trade. Reason: {reason}",
            source='risk-manager',
            tags=['risk', 'veto', sym.lower()],
            importance='high'
        ))
    return mems

def harvest_counter_intel() -> List[Dict]:
    data = load_json(BASE / 'counter-intelligence/intelligence_report.json')
    if not data:
        return []

    health    = data.get('strategy_health', {})
    team_perf = data.get('team_performance', {})
    threats   = data.get('threats', {})

    detect    = health.get('detectability_level', '?')
    win_rate  = team_perf.get('overall_win_rate', 0)
    best_bot  = team_perf.get('best_performing_bot', '?')
    weak_link = team_perf.get('weakest_link', '?')
    active_t  = threats.get('active_threats', 0)
    improvements = team_perf.get('improvement_areas', [])

    content = (f"Strategy detectability: {detect}. "
               f"Team win rate: {win_rate:.0f}%. "
               f"Best bot: {best_bot}, weakest: {weak_link}. "
               f"Active threats: {active_t}. "
               + (f"Improvements: {improvements[0]}" if improvements else ''))

    imp = 'critical' if active_t > 0 else 'medium'
    return [memory(
        title=f"Counter-Intel: {detect} | {active_t} threats",
        content=content,
        source='counter-intelligence',
        tags=['intelligence', 'security', 'performance', detect.lower()],
        importance=imp
    )]

def harvest_crypto_sniper() -> List[Dict]:
    launches = load_json(BASE / 'crypto-sniper/launches.json')
    watchlist = load_json(BASE / 'crypto-sniper/watchlist.json')
    if not launches or not isinstance(launches, list):
        return []

    mems = []
    # Recent launches
    recent = sorted(launches, key=lambda x: x.get('detected_at', ''), reverse=True)[:5]
    for launch in recent:
        sym     = launch.get('symbol', '?')
        score   = launch.get('score', 0)
        status  = launch.get('status', '?')
        reason  = launch.get('reason', '')
        content = f"New launch detected: {sym}. Score: {score}. Status: {status}. {reason}"
        mems.append(memory(
            title=f"Sniper: {sym} launch detected (score {score})",
            content=content,
            source='crypto-sniper',
            tags=['launch', 'sniper', sym.lower(), status.lower()],
            importance='high' if score >= 70 else 'medium'
        ))

    # Watchlist summary
    if watchlist and isinstance(watchlist, list):
        syms = [w.get('symbol', '') for w in watchlist[:5]]
        mems.append(memory(
            title=f"Sniper Watchlist: {len(watchlist)} tokens",
            content=f"Crypto sniper is watching {len(watchlist)} tokens: {', '.join(syms)}...",
            source='crypto-sniper',
            tags=['watchlist', 'sniper', 'launch'],
            importance='low'
        ))
    return mems

def harvest_execution() -> List[Dict]:
    data = load_json(BASE / 'execution-specialist/executions.json')
    if not data or not isinstance(data, list):
        return []

    mems = []
    recent = data[-5:] if len(data) >= 5 else data
    for ex in recent:
        sym    = ex.get('symbol', '?')
        action = ex.get('action', '?')
        price  = ex.get('price', 0)
        status = ex.get('status', '?')
        slip   = ex.get('slippage_pct', 0)
        content = (f"Execution: {action} {sym} @ ${price:,.4f}. "
                   f"Status: {status}. Slippage: {slip:.3f}%.")
        mems.append(memory(
            title=f"Execution: {action} {sym} @ ${price:,.4f}",
            content=content,
            source='execution-specialist',
            tags=['execution', sym.lower(), action.lower(), status.lower()],
            importance='medium'
        ))
    return mems

def harvest_tweak() -> List[Dict]:
    positions = load_json(BASE / 'tweak/positions.json')
    wallet    = load_json(BASE / 'tweak/wallet.json')
    pnl_src   = load_json(BASE / 'tweak/pnl_by_source.json')
    if not positions or not wallet:
        return []

    mems = []
    open_pos  = [p for p in positions if p.get('status') == 'open']
    total_pnl = sum(p.get('unrealized_pnl', 0) for p in open_pos)
    balance   = wallet.get('balance_usd', 0)
    available = wallet.get('available', 0)

    content = (f"Tweak paper trading: {len(open_pos)} open positions. "
               f"Wallet: ${balance:,.2f}, available: ${available:,.2f}. "
               f"Total unrealized P&L: ${total_pnl:+,.2f}.")

    # Source breakdown
    if pnl_src:
        for src, stats in pnl_src.items():
            if stats.get('total_trades', 0) > 0:
                content += (f" {src}: {stats['total_trades']} trades, "
                           f"${stats['total_pnl']:+,.2f} P&L, "
                           f"{stats['win_rate']:.0f}% win rate.")

    imp = 'high' if abs(total_pnl) > 100 else 'medium'
    mems.append(memory(
        title=f"Tweak: {len(open_pos)} positions | P&L ${total_pnl:+,.0f}",
        content=content,
        source='tweak',
        tags=['tweak', 'positions', 'pnl', 'paper-trading'],
        importance=imp
    ))

    # Best and worst positions
    if open_pos:
        sorted_pos = sorted(open_pos, key=lambda x: x.get('unrealized_pnl', 0), reverse=True)
        best  = sorted_pos[0]
        worst = sorted_pos[-1]
        if best.get('unrealized_pnl', 0) > 0:
            mems.append(memory(
                title=f"Best Position: {best['symbol']} +${best.get('unrealized_pnl', 0):.2f}",
                content=(f"{best['symbol']} is the best performing position with "
                        f"+${best.get('unrealized_pnl', 0):.2f} "
                        f"({best.get('unrealized_pnl_pct', 0):+.2f}%). "
                        f"Entry: ${best.get('entry_price', 0):,.4f}, "
                        f"Current: ${best.get('current_price', 0) or 0:,.4f}."),
                source='tweak',
                tags=['tweak', 'winner', best['symbol'].lower()],
                importance='medium'
            ))
        if worst.get('unrealized_pnl', 0) < -50:
            mems.append(memory(
                title=f"Worst Position: {worst['symbol']} ${worst.get('unrealized_pnl', 0):.2f}",
                content=(f"{worst['symbol']} is the worst performing position with "
                        f"${worst.get('unrealized_pnl', 0):.2f} "
                        f"({worst.get('unrealized_pnl_pct', 0):+.2f}%). "
                        f"Entry: ${worst.get('entry_price', 0):,.4f}, "
                        f"Current: ${worst.get('current_price', 0) or 0:,.4f}."),
                source='tweak',
                tags=['tweak', 'loser', worst['symbol'].lower()],
                importance='high'
            ))
    return mems

def harvest_telegram() -> List[Dict]:
    data = load_json(BASE / 'telegram-listener/signals.json')
    stats = load_json(BASE / 'telegram-listener/channel_stats.json')
    if not data or not isinstance(data, list):
        return []

    mems = []
    actionable = [s for s in data if s.get('status') == 'actionable']
    high_score = [s for s in actionable if (s.get('score') or 0) >= 80]

    content = (f"Telegram listener has {len(data)} total signals: "
               f"{len(actionable)} actionable, "
               f"{len(high_score)} high confidence (score ≥80).")

    if high_score:
        syms = list(set(s.get('symbol', '') for s in high_score[:5]))
        content += f" High confidence signals: {', '.join(syms)}."

    mems.append(memory(
        title=f"Telegram: {len(actionable)} actionable signals",
        content=content,
        source='telegram-listener',
        tags=['telegram', 'signals', 'actionable'],
        importance='medium'
    ))

    # Channel stats
    if stats and isinstance(stats, dict):
        top_channels = sorted(stats.items(),
                              key=lambda x: x[1].get('signal_count', 0),
                              reverse=True)[:3]
        if top_channels:
            ch_str = ', '.join(f"{name} ({info.get('signal_count', 0)} signals)"
                               for name, info in top_channels)
            mems.append(memory(
                title=f"Top Telegram Channels",
                content=f"Most active channels: {ch_str}.",
                source='telegram-listener',
                tags=['telegram', 'channels'],
                importance='low'
            ))
    return mems

def harvest_broadcaster() -> List[Dict]:
    data = load_json(BASE / 'broadcaster/broadcast_log.json')
    if not data or not isinstance(data, list):
        return []
    recent = data[-3:]
    mems = []
    for entry in recent:
        msg     = entry.get('message', '')[:120]
        channel = entry.get('channel', '?')
        mems.append(memory(
            title=f"Broadcast: {msg[:50]}...",
            content=f"Broadcasted to {channel}: {msg}",
            source='broadcaster',
            tags=['broadcast', 'alert', channel.lower()],
            importance='low'
        ))
    return mems

# ── Main loop ─────────────────────────────────────────────────────────────────

HARVESTERS = [
    harvest_btc_bias,
    harvest_macro,
    harvest_analyst,
    harvest_portfolio,
    harvest_risk,
    harvest_counter_intel,
    harvest_crypto_sniper,
    harvest_execution,
    harvest_tweak,
    harvest_telegram,
    harvest_broadcaster,
]

def run_once():
    print(f"\n🧠 Memory Writer — {datetime.now().strftime('%H:%M:%S')}")
    existing  = load_memories()
    known_ids = {m['id'] for m in existing}
    new_mems  = []

    for harvester in HARVESTERS:
        try:
            results = harvester()
            for m in results:
                if m['id'] not in known_ids:
                    new_mems.append(m)
                    known_ids.add(m['id'])
                    print(f"  ✅ [{m['source']}] {m['title'][:60]}")
        except Exception as e:
            print(f"  ❌ {harvester.__name__}: {e}")

    if new_mems:
        # Prepend new memories, keep last 500
        all_mems = new_mems + existing
        all_mems = all_mems[:500]
        save_memories(all_mems)
        print(f"\n  💾 Saved {len(new_mems)} new memories ({len(all_mems)} total)")
    else:
        print("  ℹ️  No new memories")

def run():
    print("🧠 Memory Writer starting...")
    while True:
        try:
            run_once()
        except Exception as e:
            print(f"❌ Error: {e}")
        time.sleep(300)  # Run every 5 minutes

if __name__ == '__main__':
    run()
