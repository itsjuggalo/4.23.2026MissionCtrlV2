import { NextResponse } from "next/server";
import fs from "fs";
import path from "path";
import os from "os";
import { proxyToServeftp } from "../../../lib/proxyToServeftp";

export const dynamic = 'force-dynamic';
const CALENDAR_FILE = path.join(os.homedir(), "mission-control-restored", "data", "calendar_events.json");

interface CalendarEvent {
  date: string;
  category: string;
  ticker: string;
  title: string;
  detail: string;
  time: string;
  importance: string;
}

interface CalendarData {
  last_updated: string;
  total_events: number;
  month_summaries: Record<string, Record<string, number>>;
  events: CalendarEvent[];
}

export async function GET(request: Request) {
  const __proxied = await proxyToServeftp(request); if (__proxied) return __proxied;
  try {
    const { searchParams } = new URL(request.url);
    const month = searchParams.get("month"); // YYYY-MM
    const category = searchParams.get("category"); // earnings|economic|crypto|dividend|ipo|split

    let data: CalendarData;
    try {
      const raw = fs.readFileSync(CALENDAR_FILE, "utf-8");
      data = JSON.parse(raw);
    } catch {
      data = { last_updated: "", total_events: 0, month_summaries: {}, events: [] };
    }

    let events = data.events;

    // Filter by month
    if (month) {
      events = events.filter((e) => e.date.startsWith(month));
    }

    // Filter by category
    if (category && category !== "all") {
      events = events.filter((e) => e.category === category);
    }

    // Group events by date
    const grouped: Record<string, CalendarEvent[]> = {};
    for (const e of events) {
      if (!grouped[e.date]) grouped[e.date] = [];
      grouped[e.date].push(e);
    }

    return NextResponse.json({
      last_updated: data.last_updated,
      total_events: events.length,
      month_summaries: data.month_summaries,
      grouped,
      events,
    });
  } catch (err) {
    console.error("Calendar API error:", err);
    return NextResponse.json({ error: "Failed to load calendar data" }, { status: 500 });
  }
}