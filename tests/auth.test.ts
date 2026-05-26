/**
 * tests/auth.test.ts — auth invariants for exec-auth.ts.
 *
 * Mocks next/server so these run in plain Node without a Next.js runtime.
 * Tests the security guarantees that gate MISSIONCTRL_EXEC_ENABLED=true.
 */

import { describe, it, expect, vi, beforeAll } from 'vitest';

// Mock next/server before any import that uses it
vi.mock('next/server', () => ({
  NextResponse: {
    json: (body: unknown, init?: { status?: number }) => ({
      _isMockResponse: true,
      body,
      status: init?.status ?? 200,
    }),
  },
}));

// Set secret before module is imported (cached singleton reads it on first call)
const TEST_SECRET = 'a'.repeat(64); // 32 bytes hex = 64 chars
process.env.MISSIONCTRL_SESSION_SECRET = TEST_SECRET;
process.env.MISSIONCTRL_EXEC_MODE = 'browser-session';
process.env.MISSIONCTRL_AUTH_MODE = 'enforce';
process.env.MISSIONCTRL_ORIGIN = 'http://localhost:3000';

import {
  signSession,
  verifySession,
  issueSession,
  assertExecAllowed,
  type SessionPayload,
} from '../src/lib/exec-auth';
import type { NextRequest } from 'next/server';

/** Build a minimal mock NextRequest */
function makeReq(opts: {
  headers?: Record<string, string | null>;
  cookies?: Record<string, string>;
} = {}): NextRequest {
  return {
    headers: {
      get: (k: string) => opts.headers?.[k.toLowerCase()] ?? null,
    },
    cookies: {
      get: (k: string) => {
        const v = opts.cookies?.[k];
        return v !== undefined ? { value: v } : undefined;
      },
    },
  } as unknown as NextRequest;
}

function validPayload(overrides: Partial<SessionPayload> = {}): SessionPayload {
  const now = Date.now();
  return {
    iss: 'mc',
    iat: now,
    exp: now + 7 * 24 * 60 * 60 * 1000,
    jti: 'test-jti-001',
    ...overrides,
  };
}

// ── Scenario 1 ──────────────────────────────────────────────────────────────

describe('Scenario 1: signSession + verifySession round-trip', () => {
  it('verifies a freshly signed token', () => {
    const payload = validPayload();
    const cookie = signSession(payload);
    const result = verifySession(cookie);
    expect(result).not.toBeNull();
    expect(result!.iss).toBe('mc');
    expect(result!.jti).toBe('test-jti-001');
  });

  it('issueSession returns mc_sess and mc_csrf strings', () => {
    const { mc_sess, mc_csrf } = issueSession();
    expect(typeof mc_sess).toBe('string');
    expect(mc_sess.length).toBeGreaterThan(10);
    expect(typeof mc_csrf).toBe('string');
    expect(mc_csrf.length).toBe(64); // 32 bytes hex
  });
});

// ── Scenario 2 ──────────────────────────────────────────────────────────────

describe('Scenario 2: tampered signature is rejected', () => {
  it('returns null when the signature is modified', () => {
    const cookie = signSession(validPayload());
    const dotIdx = cookie.lastIndexOf('.');
    const tampered = cookie.slice(0, dotIdx) + '.AAAAAAAAAAAAAAAA';
    expect(verifySession(tampered)).toBeNull();
  });

  it('returns null when the payload is modified', () => {
    const cookie = signSession(validPayload());
    const dotIdx = cookie.lastIndexOf('.');
    const fakePayload = Buffer.from(JSON.stringify({ iss: 'mc', iat: 0, exp: 9999999999999, jti: 'evil' })).toString('base64url');
    const tampered = fakePayload + cookie.slice(dotIdx);
    expect(verifySession(tampered)).toBeNull();
  });
});

// ── Scenario 3 ──────────────────────────────────────────────────────────────

describe('Scenario 3: expired session is rejected', () => {
  it('returns null for a token with exp in the past', () => {
    const payload = validPayload({ exp: Date.now() - 1000 });
    const cookie = signSession(payload);
    expect(verifySession(cookie)).toBeNull();
  });
});

// ── Scenario 4 ──────────────────────────────────────────────────────────────

describe('Scenario 4: wrong issuer is rejected', () => {
  it('returns null when iss is not "mc"', () => {
    const payload = validPayload({ iss: 'evil' as 'mc' });
    const cookie = signSession(payload);
    expect(verifySession(cookie)).toBeNull();
  });
});

// ── Scenario 5 ──────────────────────────────────────────────────────────────

describe('Scenario 5: assertExecAllowed disabled → 503', () => {
  it('returns errorResponse with status 503 when EXEC_MODE=disabled', () => {
    const savedMode = process.env.MISSIONCTRL_EXEC_MODE;
    process.env.MISSIONCTRL_EXEC_MODE = 'disabled';
    try {
      const result = assertExecAllowed(makeReq(), true);
      expect(result.ok).toBe(false);
      expect((result.errorResponse as { status: number }).status).toBe(503);
    } finally {
      process.env.MISSIONCTRL_EXEC_MODE = savedMode;
    }
  });
});

// ── Scenario 6 ──────────────────────────────────────────────────────────────

describe('Scenario 6: browser-session missing cookie, warn mode → warn-bypass', () => {
  it('returns ok=true with principal=warn-bypass when cookie is absent and AUTH_MODE=warn', () => {
    const savedAuth = process.env.MISSIONCTRL_AUTH_MODE;
    const savedMode = process.env.MISSIONCTRL_EXEC_MODE;
    process.env.MISSIONCTRL_AUTH_MODE = 'warn';
    process.env.MISSIONCTRL_EXEC_MODE = 'browser-session';
    try {
      const req = makeReq({
        headers: { origin: 'http://localhost:3000' },
        cookies: {}, // no mc_sess
      });
      const result = assertExecAllowed(req, false);
      expect(result.ok).toBe(true);
      expect(result.principal).toBe('warn-bypass');
    } finally {
      process.env.MISSIONCTRL_AUTH_MODE = savedAuth;
      process.env.MISSIONCTRL_EXEC_MODE = savedMode;
    }
  });

  it('returns ok=false status 401 when cookie is absent and AUTH_MODE=enforce', () => {
    process.env.MISSIONCTRL_AUTH_MODE = 'enforce';
    process.env.MISSIONCTRL_EXEC_MODE = 'browser-session';
    const req = makeReq({
      headers: { origin: 'http://localhost:3000' },
      cookies: {},
    });
    const result = assertExecAllowed(req, false);
    expect(result.ok).toBe(false);
    expect((result.errorResponse as { status: number }).status).toBe(401);
  });
});

// ── Scenario 7 ──────────────────────────────────────────────────────────────

describe('Scenario 7: CSRF mismatch on POST → 403', () => {
  it('rejects when mc_csrf cookie and X-MC-Csrf header do not match', () => {
    process.env.MISSIONCTRL_AUTH_MODE = 'enforce';
    process.env.MISSIONCTRL_EXEC_MODE = 'browser-session';

    const { mc_sess, mc_csrf } = issueSession();

    const req = makeReq({
      headers: {
        origin: 'http://localhost:3000',
        'x-mc-csrf': 'wrong-csrf-value',
      },
      cookies: {
        mc_sess,
        mc_csrf, // cookie has real csrf, header has wrong value → mismatch
      },
    });

    const result = assertExecAllowed(req, true); // isStateChanging=true triggers CSRF check
    expect(result.ok).toBe(false);
    expect((result.errorResponse as { status: number }).status).toBe(403);
  });

  it('passes when mc_csrf cookie and X-MC-Csrf header match', () => {
    process.env.MISSIONCTRL_AUTH_MODE = 'enforce';
    process.env.MISSIONCTRL_EXEC_MODE = 'browser-session';

    const { mc_sess, mc_csrf } = issueSession();

    const req = makeReq({
      headers: {
        origin: 'http://localhost:3000',
        'x-mc-csrf': mc_csrf,
      },
      cookies: { mc_sess, mc_csrf },
    });

    const result = assertExecAllowed(req, true);
    expect(result.ok).toBe(true);
    expect(result.principal).toMatch(/^browser:/);
  });
});
