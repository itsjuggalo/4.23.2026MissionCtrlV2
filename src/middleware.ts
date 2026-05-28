import { NextRequest, NextResponse } from 'next/server';

// Routes that are always public (no auth required)
const PUBLIC_ROUTES = [
  // Health endpoint — no auth per Phase 6a
  /^\/api\/health(\/.*)?$/,
  // Session issuance
  /^\/api\/session(\/.*)?$/,
  // Static assets and Next.js internals
  /^\/_next\//,
  /^\/favicon\.ico$/,
  // Pre-existing public routes
  /^\/api\/agents\//,
  /^\/api\/memory-graph\//,
  /^\/api\/crypto\//,
  /^\/api\/stocks\//,
  /^\/api\/telegram-signals\//,
  /^\/api\/btc-bias\//,
  // Non-API dashboard shell (the page itself must be accessible)
  /^\/(?!api\/)/,
];

// Routes that require auth (sensitive GETs per R2.H2 + all exec POSTs)
const SENSITIVE_API_ROUTES = [
  /^\/api\/live-strategy/,
  /^\/api\/desk-cycle/,
  /^\/api\/freqtrade/,
  /^\/api\/itb/,
];

function isPublicRoute(pathname: string): boolean {
  return PUBLIC_ROUTES.some(pattern => pattern.test(pathname));
}

function isSensitiveRoute(pathname: string): boolean {
  return SENSITIVE_API_ROUTES.some(pattern => pattern.test(pathname));
}

/**
 * isV2Page — reads MISSIONCTRL_UI_V2_PAGES (comma-separated) and returns
 * whether the given page name is enabled for the v2 chart-heavy UI.
 */
export function isV2Page(name: string): boolean {
  const v2Pages = (process.env.MISSIONCTRL_UI_V2_PAGES ?? '').split(',').map(p => p.trim()).filter(Boolean);
  return v2Pages.includes(name);
}

export function proxy(req: NextRequest) {
  const pathname = new URL(req.url).pathname;
  const authMode = process.env.MISSIONCTRL_AUTH_MODE ?? 'warn';

  // Always allow public routes through
  if (isPublicRoute(pathname)) {
    return NextResponse.next();
  }

  // For sensitive API routes, verify the session cookie
  if (isSensitiveRoute(pathname)) {
    const mc_sess = req.cookies.get('mc_sess')?.value;

    if (!mc_sess) {
      if (authMode === 'enforce') {
        return NextResponse.json(
          { error: 'Authentication required — visit the dashboard to get a session cookie' },
          { status: 401 }
        );
      }
      // warn mode: log and pass through
      console.warn(`[proxy] Unauthenticated request to sensitive route: ${pathname}`);
      return NextResponse.next();
    }

    return NextResponse.next();
  }

  // All other /api/* routes: pass through
  return NextResponse.next();
}

export { proxy as middleware };

export const config = {
  matcher: [
    '/((?!_next/static|_next/image|favicon.ico).*)',
  ],
};
