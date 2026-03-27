import { NextRequest, NextResponse } from 'next/server';

// Routes that don't require auth (safe internal APIs)
const PUBLIC_ROUTES = [
  /^\/api\/agents\//,
  /^\/api\/memory-graph\//,
  /^\/api\/crypto\//,
  /^\/api\/stocks\//,
  /^\/api\/telegram-signals\//,
  /^\/api\/btc-bias\//,
];

export function middleware(req: NextRequest) {
  const pathname = new URL(req.url).pathname;

  // Skip auth for public API routes
  if (PUBLIC_ROUTES.some(pattern => pattern.test(pathname))) {
    return NextResponse.next();
  }

  // AUTH DISABLED - Allow all requests through
  return NextResponse.next();

  /* BASIC AUTH CODE - COMMENTED OUT
  const authUser = process.env.BASIC_AUTH_USER;
  const authPass = process.env.BASIC_AUTH_PASS;

  const authHeader = req.headers.get('authorization');

  if (authHeader && authHeader.startsWith('Basic ')) {
    const base64 = authHeader.slice(6);
    const decoded = Buffer.from(base64, 'base64').toString('utf-8');
    const [user, ...passParts] = decoded.split(':');
    const pass = passParts.join(':');

    if (user === authUser && pass === authPass) {
      return NextResponse.next();
    }
  }

  return new NextResponse('Unauthorized', {
    status: 401,
    headers: {
      'WWW-Authenticate': 'Basic realm="Mission Control"',
    },
  });
  */
}

export const config = {
  matcher: ['/(.(?!_next/static|_next/image|favicon.ico).*)'],
};
