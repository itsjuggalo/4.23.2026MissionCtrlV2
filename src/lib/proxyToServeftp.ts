import { NextResponse } from "next/server";

// Fallback chain: try SpaceCoast first (live data), then openclaw
const UPSTREAMS = [
  { base: "https://claudeclaw.serveftp.com", tag: "spacecoast" },
  { base: "https://missionctrl.serveftp.com", tag: "openclaw" },
];

/**
 * On Vercel: proxy the request to SpaceCoast (primary) or openclaw (fallback).
 * On local (SpaceCoast/openclaw): returns null so the route falls through to local fs.
 */
export async function proxyToServeftp(req: Request): Promise<NextResponse | null> {
  if (!process.env.VERCEL && !process.env.VERCEL_ENV) return null;

  const url = new URL(req.url);
  const path = `${url.pathname}${url.search}`;

  for (const { base, tag } of UPSTREAMS) {
    try {
      const r = await fetch(`${base}${path}`, {
        method: req.method,
        headers: { Accept: "application/json" },
        cache: "no-store",
        signal: AbortSignal.timeout(8000),
      });
      if (!r.ok && tag !== UPSTREAMS[UPSTREAMS.length - 1].tag) continue;
      const body = await r.text();
      return new NextResponse(body, {
        status: r.status,
        headers: {
          "Content-Type": r.headers.get("Content-Type") || "application/json",
          "Cache-Control": "no-store",
          "X-Proxied-From": tag,
        },
      });
    } catch {
      // This upstream failed, try next
      continue;
    }
  }

  return NextResponse.json({ error: "All upstreams unreachable" }, { status: 502 });
}
