import { NextResponse } from 'next/server';
import fs from 'fs/promises';
import path from 'path';
import os from 'os';
import { proxyToServeftp } from "../../../lib/proxyToServeftp";

/**
 * Boba Journal — aggregates Boba's existing decision log with live SQLite trade outcomes.
 *
 * Sources:
 *   - ~/.openclaw/workspace/skill_outputs/boba_decisions_validated.json  (rich reasoning per cycle)
 *   - ~/.openclaw/workspace/memory/trade_log.jsonl                        (auto_trader BTC log)
 *   - /api/trade-log (SQLite) — outcome data when positions close
 *
 * Returns unified entries ordered newest-first.
 */

const BOBA_DECISIONS = path.join(os.homedir(), '.openclaw', 'workspace', 'skill_outputs', 'boba_decisions_validated.json');
const AUTO_TRADER_LOG = path.join(os.homedir(), '.openclaw', 'workspace', 'memory', 'trade_log.jsonl');

interface BobaPick {
  ticker: string;
  strike?: number;
  option_type?: string;
  expiry?: string;
  contracts?: number;
  reasoning: string;
  profit_target_pct?: number;
  stop_loss_pct?: number;
  confidence?: string;
  execution?: { ok: boolean; symbol?: string; order_id?: string; error?: string };
  // SCHEMA v2 (2026-04-28): two-protocol journaling
  protocol?: 'flow' | 'swing' | 'manual';
  entry_criteria?: string[];
}

interface BobaCycle {
  cycle_time: string;
  cycle_summary: string;
  picks_proposed: number;
  picks_executed: BobaPick[];
  passed_on: { ticker: string; reason: string }[];
}

interface JournalEntry {
  id: string;
  source: 'boba-options' | 'auto-trader-btc' | 'manual';
  timestamp: string;
  symbol: string;
  full_symbol?: string;   // full option symbol if applicable
  side: string;            // long call, long put, short, etc.
  qty: number;
  strike?: number;
  expiry?: string;
  confidence?: string;
  profit_target_pct?: number;
  stop_loss_pct?: number;
  // The crown jewel — full reasoning from Boba
  reasoning: string;
  // Context
  cycle_summary?: string;
  passed_on?: { ticker: string; reason: string }[];
  // Execution
  executed: boolean;
  order_id?: string;
  error?: string;
  // SCHEMA v2 (2026-04-28): two-protocol journaling
  protocol?: 'flow' | 'swing' | 'manual';
  entry_criteria?: string[];
}

async function loadBobaDecisions(): Promise<BobaCycle[]> {
  try {
    const raw = await fs.readFile(BOBA_DECISIONS, 'utf-8');
    const data = JSON.parse(raw);
    return Array.isArray(data) ? data : [];
  } catch {
    return [];
  }
}

async function loadAutoTraderLog(): Promise<any[]> {
  try {
    const raw = await fs.readFile(AUTO_TRADER_LOG, 'utf-8');
    return raw.split('\n').filter(Boolean).map(line => {
      try { return JSON.parse(line); } catch { return null; }
    }).filter(Boolean);
  } catch {
    return [];
  }
}

function flattenBobaDecisions(cycles: BobaCycle[]): JournalEntry[] {
  const out: JournalEntry[] = [];
  for (const cycle of cycles) {
    for (const pick of (cycle.picks_executed || [])) {
      const isPut = (pick.option_type || '').toUpperCase() === 'PUT';
      out.push({
        id: `boba-${cycle.cycle_time}-${pick.ticker}-${pick.strike || ''}`,
        source: 'boba-options',
        timestamp: cycle.cycle_time,
        symbol: pick.ticker,
        full_symbol: pick.execution?.symbol,
        side: isPut ? 'long put' : 'long call',
        qty: pick.contracts || 0,
        strike: pick.strike,
        expiry: pick.expiry,
        confidence: pick.confidence,
        profit_target_pct: pick.profit_target_pct,
        stop_loss_pct: pick.stop_loss_pct,
        reasoning: pick.reasoning || '',
        cycle_summary: cycle.cycle_summary,
        passed_on: cycle.passed_on,
        executed: !!pick.execution?.ok,
        order_id: pick.execution?.order_id,
        error: pick.execution?.error,
        // SCHEMA v2: protocol + entry_criteria pass-through
        protocol: pick.protocol || 'flow',
        entry_criteria: pick.entry_criteria || [],
      });
    }
  }
  return out;
}

function flattenAutoTrader(entries: any[]): JournalEntry[] {
  return entries.map((e, i) => ({
    id: `auto-${e.timestamp || i}-${e.symbol || 'BTC'}`,
    source: 'auto-trader-btc' as const,
    timestamp: e.timestamp || new Date().toISOString(),
    symbol: e.symbol || 'BTC/USD',
    side: (e.side || e.direction || '').toLowerCase(),
    qty: e.qty || e.quantity || 0,
    reasoning: e.reason || e.note || (e.signal ? `SuperTrend ${e.signal.direction || ''} @ ${e.signal.entry_price || ''}` : 'BTC SuperTrend auto-trade'),
    executed: true,
  }));
}

export async function GET(req: Request) {
  const __proxied = await proxyToServeftp(req); if (__proxied) return __proxied;
  try {
    const url = new URL(req.url);
    const sourceFilter = url.searchParams.get('source'); // 'boba-options' | 'auto-trader-btc' | null (all)
    const limit = Number(url.searchParams.get('limit') || '100');

    const [cycles, autoLog] = await Promise.all([
      loadBobaDecisions(),
      loadAutoTraderLog(),
    ]);

    const bobaEntries = flattenBobaDecisions(cycles);
    const autoEntries = flattenAutoTrader(autoLog);

    let merged = [...bobaEntries, ...autoEntries];
    if (sourceFilter) merged = merged.filter(e => e.source === sourceFilter);
    merged.sort((a, b) => (b.timestamp || '').localeCompare(a.timestamp || ''));
    const limited = merged.slice(0, limit);

    // Also surface cycle-level stats: picks passed on
    const recentCycles = cycles.slice(-20).reverse().map(c => ({
      cycle_time: c.cycle_time,
      cycle_summary: c.cycle_summary,
      picks_proposed: c.picks_proposed,
      picks_executed_count: (c.picks_executed || []).filter(p => p.execution?.ok).length,
      passed_on: c.passed_on || [],
    }));

    // Basic stats
    const totalBoba = bobaEntries.length;
    const executedBoba = bobaEntries.filter(e => e.executed).length;
    const highConv = bobaEntries.filter(e => e.confidence === 'high').length;
    const totalAuto = autoEntries.length;

    // Confidence breakdown
    const confStats: Record<string, number> = {};
    for (const e of bobaEntries) {
      const c = e.confidence || 'unspecified';
      confStats[c] = (confStats[c] || 0) + 1;
    }

    return NextResponse.json({
      entries: limited,
      recentCycles,
      stats: {
        total_decisions: merged.length,
        boba_options: totalBoba,
        boba_executed: executedBoba,
        boba_high_conviction: highConv,
        auto_trader_btc: totalAuto,
        confidence_breakdown: confStats,
      },
    });
  } catch (e: unknown) {
    return NextResponse.json({ error: e instanceof Error ? e.message : String(e), entries: [] }, { status: 500 });
  }
}