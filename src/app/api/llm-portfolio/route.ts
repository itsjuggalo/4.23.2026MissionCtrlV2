import { NextResponse } from "next/server";
import fs from "fs";
import path from "path";
import os from "os";
import { proxyToServeftp } from "../../../lib/proxyToServeftp";

const DATA_FILE = path.join(os.homedir(), "mission-control-restored", "data", "llm_portfolio.json");

export async function GET(request: Request) {
  const __proxied = await proxyToServeftp(request); if (__proxied) return __proxied;
  try {
    const { searchParams } = new URL(request.url);
    const model = searchParams.get("model");

    let data;
    try {
      data = JSON.parse(fs.readFileSync(DATA_FILE, "utf-8"));
    } catch {
      data = { last_updated: "", leaderboard: [], models: {} };
    }

    if (model && data.models?.[model.toUpperCase()]) {
      const m = data.models[model.toUpperCase()];
      return NextResponse.json({
        last_updated: data.last_updated,
        model: m,
      });
    }

    // Return leaderboard + recent trades per model (not full history)
    const summary: Record<string, unknown> = {};
    for (const [key, val] of Object.entries(data.models || {})) {
      const v = val as Record<string, unknown>;
      summary[key] = {
        name: v.name,
        model: v.model,
        color: v.color,
        total_trades: v.total_trades,
        holdings_count: v.holdings_count,
        buy_volume: v.total_buy_value,
        sell_volume: v.total_sell_value,
        current_holdings: v.current_holdings,
        recent_trades: (v.recent_trades as unknown[])?.slice(0, 10),
      };
    }

    return NextResponse.json({
      last_updated: data.last_updated,
      leaderboard: data.leaderboard,
      models: summary,
    });
  } catch (err) {
    console.error("LLM Portfolio API error:", err);
    return NextResponse.json({ error: "Failed to load LLM portfolio data" }, { status: 500 });
  }
}