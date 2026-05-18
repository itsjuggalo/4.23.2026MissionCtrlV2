import { NextResponse } from "next/server";
import fs from "fs";
import path from "path";
import os from "os";
import { proxyToServeftp } from "../../../lib/proxyToServeftp";

// NOTE: signal-receiver data lives under ~/mission-control/ (not mission-control-restored)
const DATA_DIR = path.join(os.homedir(), "mission-control", "signal-receiver", "data");

function safeReadJSON(filename: string): Record<string, unknown> {
  try {
    const fp = path.join(DATA_DIR, filename);
    if (!fs.existsSync(fp)) return {};
    const content = fs.readFileSync(fp, "utf-8");
    return JSON.parse(content);
  } catch (err) {
    console.error(`[chart-signals] ${filename} error:`, err);
    return {};
  }
}

function safeReadJSONL(filename: string, maxLines: number = 50): Record<string, unknown>[] {
  try {
    const fp = path.join(DATA_DIR, filename);
    if (!fs.existsSync(fp)) return [];
    const content = fs.readFileSync(fp, "utf-8");
    const lines = content.trim().split("\n").filter(Boolean);
    // Take the last maxLines and parse each; skip bad lines
    const tail = lines.slice(-maxLines);
    const parsed: Record<string, unknown>[] = [];
    for (const line of tail) {
      try { parsed.push(JSON.parse(line)); } catch { /* skip malformed */ }
    }
    // Newest first
    return parsed.reverse();
  } catch (err) {
    console.error(`[chart-signals] ${filename} error:`, err);
    return [];
  }
}

export async function GET(req: Request) {
  const __proxied = await proxyToServeftp(req); if (__proxied) return __proxied;
  try {
    const regime = safeReadJSON("market_regime.json");
    const optimal_params = safeReadJSON("optimal_params.json");
    const latest_state = safeReadJSON("latest_state.json");
    const signals = safeReadJSONL("signals_history.jsonl", 50);

    return NextResponse.json({
      regime,
      optimal_params,
      latest_state,
      signals,
      updated_at: new Date().toISOString(),
    });
  } catch (err) {
    console.error("[chart-signals] route error:", err);
    return NextResponse.json(
      { regime: {}, optimal_params: {}, latest_state: {}, signals: [], updated_at: "" },
      { status: 200 }
    );
  }
}