import { NextResponse } from "next/server";
import fs from "fs";
import path from "path";
import os from "os";

const DATA_DIR = path.join(os.homedir(), "mission-control-restored", "data");
const USAGE_FILE = path.join(DATA_DIR, "api_usage.json");
const BUDGETS_FILE = path.join(DATA_DIR, "api_budgets.json");

interface UsageEntry {
  timestamp: string;
  source: string;
  provider: string;
  model: string;
  input_tokens: number;
  output_tokens: number;
  cost_usd: number;
}

interface Budgets {
  [provider: string]: number;
}

function readJSON(filePath: string, fallback: unknown): unknown {
  try {
    const raw = fs.readFileSync(filePath, "utf-8");
    return JSON.parse(raw);
  } catch {
    return fallback;
  }
}

export async function GET() {
  try {
    const entries = readJSON(USAGE_FILE, []) as UsageEntry[];
    const budgets = readJSON(BUDGETS_FILE, {
      anthropic: 50,
      openai: 20,
      deepseek: 20,
      xai: 20,
    }) as Budgets;

    // Total spend per provider
    const spendByProvider: Record<string, number> = {};
    const spendBySource: Record<string, number> = {};
    const tokensByProvider: Record<string, { input: number; output: number }> = {};

    for (const e of entries) {
      // By provider
      spendByProvider[e.provider] = (spendByProvider[e.provider] || 0) + e.cost_usd;

      // By source
      spendBySource[e.source] = (spendBySource[e.source] || 0) + e.cost_usd;

      // Tokens by provider
      if (!tokensByProvider[e.provider]) {
        tokensByProvider[e.provider] = { input: 0, output: 0 };
      }
      tokensByProvider[e.provider].input += e.input_tokens;
      tokensByProvider[e.provider].output += e.output_tokens;
    }

    // Remaining balance per provider
    const balances: Record<string, { budget: number; spent: number; remaining: number; pct_used: number }> = {};
    for (const [provider, budget] of Object.entries(budgets)) {
      const spent = spendByProvider[provider] || 0;
      balances[provider] = {
        budget,
        spent: Math.round(spent * 100) / 100,
        remaining: Math.round((budget - spent) * 100) / 100,
        pct_used: budget > 0 ? Math.round((spent / budget) * 10000) / 100 : 0,
      };
    }

    // Hourly buckets for last 24h
    const now = Date.now();
    const hourly: Record<string, Record<string, number>> = {};
    for (let i = 23; i >= 0; i--) {
      const hourStart = new Date(now - i * 3600000);
      const key = hourStart.toISOString().slice(0, 13);
      hourly[key] = {};
    }

    for (const e of entries) {
      const ts = new Date(e.timestamp).getTime();
      if (now - ts <= 24 * 3600000) {
        const key = new Date(e.timestamp).toISOString().slice(0, 13);
        if (hourly[key]) {
          hourly[key][e.provider] = (hourly[key][e.provider] || 0) + e.cost_usd;
        }
      }
    }

    const hourlyData = Object.entries(hourly).map(([hour, providers]) => ({
      hour: hour.slice(5, 13).replace("T", " ") + "h",
      ...Object.fromEntries(
        Object.entries(providers).map(([k, v]) => [k, Math.round(v * 10000) / 10000])
      ),
    }));

    // Daily buckets for last 7 days
    const daily: Record<string, Record<string, number>> = {};
    for (let i = 6; i >= 0; i--) {
      const dayStart = new Date(now - i * 86400000);
      const key = dayStart.toISOString().slice(0, 10);
      daily[key] = {};
    }

    for (const e of entries) {
      const ts = new Date(e.timestamp).getTime();
      if (now - ts <= 7 * 86400000) {
        const key = new Date(e.timestamp).toISOString().slice(0, 10);
        if (daily[key]) {
          daily[key][e.provider] = (daily[key][e.provider] || 0) + e.cost_usd;
        }
      }
    }

    const dailyData = Object.entries(daily).map(([day, providers]) => ({
      day: day.slice(5),
      ...Object.fromEntries(
        Object.entries(providers).map(([k, v]) => [k, Math.round(v * 10000) / 10000])
      ),
    }));

    // Source breakdown
    const sourceData = Object.entries(spendBySource)
      .map(([source, cost]) => ({ source, cost: Math.round(cost * 10000) / 10000 }))
      .sort((a, b) => b.cost - a.cost);

    // Recent entries (last 20)
    const recent = entries.slice(-20).reverse().map((e) => ({
      ...e,
      cost_usd: Math.round(e.cost_usd * 10000) / 10000,
    }));

    return NextResponse.json({
      balances,
      spendByProvider,
      spendBySource: sourceData,
      tokensByProvider,
      hourlyData,
      dailyData,
      recent,
      totalEntries: entries.length,
    });
  } catch (err) {
    console.error("Usage API error:", err);
    return NextResponse.json({ error: "Failed to load usage data" }, { status: 500 });
  }
}
