import { NextResponse } from "next/server";
import fs from "fs";
import path from "path";
import os from "os";

const DATA_FILE = path.join(os.homedir(), "mission-control-restored", "data", "congress_trades.json");

export async function GET(request: Request) {
  try {
    const { searchParams } = new URL(request.url);
    const filterTicker = searchParams.get("ticker");
    const filterParty = searchParams.get("party");
    const filterType = searchParams.get("type");

    let data;
    try {
      data = JSON.parse(fs.readFileSync(DATA_FILE, "utf-8"));
    } catch {
      data = { last_updated: "", total_trades: 0, politicians: [], suspicious: [], trades: [] };
    }

    let trades = data.trades || [];

    if (filterTicker) trades = trades.filter((t: Record<string, string>) => t.ticker === filterTicker.toUpperCase());
    if (filterParty) trades = trades.filter((t: Record<string, string>) => t.party?.toLowerCase() === filterParty.toLowerCase());
    if (filterType) trades = trades.filter((t: Record<string, string>) => t.trade_type === filterType.toLowerCase());

    return NextResponse.json({
      last_updated: data.last_updated,
      total_trades: trades.length,
      politicians: data.politicians || [],
      suspicious: data.suspicious || [],
      trades: trades.slice(0, 200),
    });
  } catch (err) {
    console.error("Congress API error:", err);
    return NextResponse.json({ error: "Failed to load congress data" }, { status: 500 });
  }
}
