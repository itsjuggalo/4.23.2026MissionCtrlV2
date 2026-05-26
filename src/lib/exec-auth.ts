/**
 * exec-auth.ts — authentication for execution endpoints and sensitive GETs.
 *
 * Three modes via MISSIONCTRL_EXEC_MODE:
 *   browser-session (default): stateless HMAC cookie + CSRF double-submit + Origin pin + Sec-Fetch-Site
 *   token-headless: Bearer token + absence of Origin/Sec-Fetch headers
 *   disabled: 503
 *
 * MISSIONCTRL_AUTH_MODE: warn | enforce
 *   warn: log failures but let request through
 *   enforce: reject (401/403/503)
 */

import { createHmac, timingSafeEqual, randomBytes } from 'crypto';
import { NextRequest, NextResponse } from 'next/server';
import { redactString } from './redact';

// Crash loudly if secret is missing in non-disabled modes
function getSessionSecret(): Buffer {
  const secret = process.env.MISSIONCTRL_SESSION_SECRET;
  const execMode = process.env.MISSIONCTRL_EXEC_MODE ?? 'browser-session';
  if (!secret && execMode !== 'disabled') {
    throw new Error(
      '[exec-auth] MISSIONCTRL_SESSION_SECRET is required but not set. ' +
      'Generate one with: openssl rand -hex 32'
    );
  }
  return Buffer.from(secret ?? 'placeholder-disabled-mode', 'hex');
}

// Cached after first call
let _sessionSecret: Buffer | null = null;
function sessionSecret(): Buffer {
  if (!_sessionSecret) _sessionSecret = getSessionSecret();
  return _sessionSecret;
}

export interface SessionPayload {
  iss: string;
  iat: number;
  exp: number;
  jti: string;
}

/**
 * Issue a signed session cookie value.
 * Format: base64url(payload).base64url(hmac_sha256(payload, secret))
 */
export function signSession(payload: SessionPayload): string {
  const payloadB64 = Buffer.from(JSON.stringify(payload)).toString('base64url');
  const sig = createHmac('sha256', sessionSecret())
    .update(payloadB64)
    .digest('base64url');
  return `${payloadB64}.${sig}`;
}

/**
 * Verify a session cookie value. Returns the payload or null on failure.
 */
export function verifySession(cookieValue: string): SessionPayload | null {
  try {
    const dotIdx = cookieValue.lastIndexOf('.');
    if (dotIdx < 0) return null;
    const payloadB64 = cookieValue.slice(0, dotIdx);
    const sigB64 = cookieValue.slice(dotIdx + 1);

    const expectedSig = createHmac('sha256', sessionSecret())
      .update(payloadB64)
      .digest('base64url');

    // Constant-time compare
    const sigBuf = Buffer.from(sigB64, 'base64url');
    const expectedBuf = Buffer.from(expectedSig, 'base64url');
    if (sigBuf.length !== expectedBuf.length) return null;
    if (!timingSafeEqual(sigBuf, expectedBuf)) return null;

    const payload = JSON.parse(Buffer.from(payloadB64, 'base64url').toString()) as SessionPayload;
    if (payload.iss !== 'mc') return null;
    if (payload.exp < Date.now()) return null; // expired

    return payload;
  } catch {
    return null;
  }
}

/**
 * Issue a new session. Returns { mc_sess, mc_csrf } cookie values.
 */
export function issueSession(): { mc_sess: string; mc_csrf: string } {
  const now = Date.now();
  const payload: SessionPayload = {
    iss: 'mc',
    iat: now,
    exp: now + 7 * 24 * 60 * 60 * 1000, // 7 days
    jti: randomBytes(16).toString('hex'),
  };
  return {
    mc_sess: signSession(payload),
    mc_csrf: randomBytes(32).toString('hex'),
  };
}

type AuthMode = 'warn' | 'enforce';
type ExecMode = 'browser-session' | 'token-headless' | 'disabled';

function getAuthMode(): AuthMode {
  return (process.env.MISSIONCTRL_AUTH_MODE ?? 'warn') === 'enforce' ? 'enforce' : 'warn';
}

function getExecMode(): ExecMode {
  const m = process.env.MISSIONCTRL_EXEC_MODE ?? 'browser-session';
  if (m === 'token-headless' || m === 'disabled') return m;
  return 'browser-session';
}

function getConfiguredOrigin(): string {
  return process.env.MISSIONCTRL_ORIGIN ?? 'http://localhost:3000';
}

/**
 * Check browser-session auth. Returns principal string or null on failure.
 */
function checkBrowserSession(req: NextRequest, isStateChanging: boolean): string | null {
  // 1. Origin pin
  const origin = req.headers.get('origin') ?? req.headers.get('referer');
  const configuredOrigin = getConfiguredOrigin();
  if (origin && !origin.startsWith(configuredOrigin)) {
    console.warn(`[exec-auth] Origin mismatch: ${origin} vs ${configuredOrigin}`);
    return null;
  }

  // 2. Sec-Fetch-Site (state-changing only)
  if (isStateChanging) {
    const secFetch = req.headers.get('sec-fetch-site');
    if (secFetch && secFetch !== 'same-origin' && secFetch !== 'none') {
      console.warn(`[exec-auth] Sec-Fetch-Site rejected: ${secFetch}`);
      return null;
    }
  }

  // 3. Session cookie
  const mc_sess = req.cookies.get('mc_sess')?.value;
  if (!mc_sess) {
    console.warn('[exec-auth] Missing mc_sess cookie');
    return null;
  }
  const payload = verifySession(mc_sess);
  if (!payload) {
    console.warn('[exec-auth] Invalid or expired mc_sess cookie');
    return null;
  }

  // 4. CSRF (state-changing only)
  if (isStateChanging) {
    const mc_csrf_cookie = req.cookies.get('mc_csrf')?.value;
    const mc_csrf_header = req.headers.get('x-mc-csrf');
    if (!mc_csrf_cookie || !mc_csrf_header || mc_csrf_cookie !== mc_csrf_header) {
      console.warn('[exec-auth] CSRF mismatch');
      return null;
    }
  }

  // Principal: browser:<hash of jti>
  const jtiHash = createHmac('sha256', sessionSecret())
    .update(payload.jti)
    .digest('hex')
    .slice(0, 16);
  return `browser:${jtiHash}`;
}

/**
 * Check token-headless auth. Returns 'headless' or null on failure.
 */
function checkTokenHeadless(req: NextRequest): string | null {
  // Must NOT have Origin or Sec-Fetch-* headers (prevents browser piggyback)
  if (req.headers.get('origin') || req.headers.get('sec-fetch-site')) {
    console.warn('[exec-auth] token-headless: browser headers present, rejecting');
    return null;
  }

  const authHeader = req.headers.get('authorization');
  if (!authHeader?.startsWith('Bearer ')) {
    console.warn('[exec-auth] token-headless: missing Bearer token');
    return null;
  }
  const token = authHeader.slice(7);
  const expectedToken = process.env.MISSIONCTRL_EXEC_TOKEN;
  if (!expectedToken) {
    console.warn('[exec-auth] token-headless: MISSIONCTRL_EXEC_TOKEN not set');
    return null;
  }

  // Constant-time compare
  try {
    const tokenBuf = Buffer.from(redactString(token));
    const expectedBuf = Buffer.from(expectedToken);
    if (tokenBuf.length !== expectedBuf.length) return null;
    if (!timingSafeEqual(tokenBuf, expectedBuf)) return null;
  } catch {
    return null;
  }

  return 'headless';
}

export interface AuthResult {
  ok: boolean;
  principal?: string;
  errorResponse?: NextResponse;
}

/**
 * assertExecAllowed — call at the top of every exec POST handler.
 * Returns { ok: true, principal } on success.
 * Returns { ok: false, errorResponse } on failure — caller MUST return errorResponse.
 *
 * isStateChanging=true for POST (CSRF required), false for sensitive GETs.
 */
export function assertExecAllowed(req: NextRequest, isStateChanging = true): AuthResult {
  const execMode = getExecMode();
  const authMode = getAuthMode();

  if (execMode === 'disabled') {
    return {
      ok: false,
      errorResponse: NextResponse.json(
        { error: 'Execution is disabled (MISSIONCTRL_EXEC_MODE=disabled)' },
        { status: 503 }
      ),
    };
  }

  let principal: string | null = null;

  if (execMode === 'browser-session') {
    principal = checkBrowserSession(req, isStateChanging);
  } else if (execMode === 'token-headless') {
    principal = checkTokenHeadless(req);
  }

  if (!principal) {
    const status = isStateChanging ? 403 : 401;
    if (authMode === 'warn') {
      console.warn(`[exec-auth] Auth check failed (mode=${execMode}, authMode=warn) — allowing request through`);
      return { ok: true, principal: 'warn-bypass' };
    }
    return {
      ok: false,
      errorResponse: NextResponse.json(
        { error: 'Authentication required' },
        { status }
      ),
    };
  }

  return { ok: true, principal };
}

// In-process rate limiting: 1 concurrent + 10/min per (route, principal)
const rateLimitMap = new Map<string, { concurrent: number; minuteCount: number; minuteReset: number }>();

export function checkRateLimit(route: string, principal: string): boolean {
  const key = `${route}:${principal}`;
  const now = Date.now();
  let state = rateLimitMap.get(key);

  if (!state) {
    state = { concurrent: 0, minuteCount: 0, minuteReset: now + 60_000 };
    rateLimitMap.set(key, state);
  }

  // Reset minute counter
  if (now > state.minuteReset) {
    state.minuteCount = 0;
    state.minuteReset = now + 60_000;
  }

  if (state.concurrent >= 1 || state.minuteCount >= 10) {
    return false; // Rate limited
  }

  return true;
}

export function acquireRateLimit(route: string, principal: string): void {
  const key = `${route}:${principal}`;
  const state = rateLimitMap.get(key);
  if (state) {
    state.concurrent++;
    state.minuteCount++;
  }
}

export function releaseRateLimit(route: string, principal: string): void {
  const key = `${route}:${principal}`;
  const state = rateLimitMap.get(key);
  if (state && state.concurrent > 0) {
    state.concurrent--;
  }
}
