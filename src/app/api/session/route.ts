/**
 * /api/session — issues mc_sess + mc_csrf cookies on first load.
 * Called by the dashboard entry route (or via middleware redirect).
 * Phase 3d.bis: session cookie issuance.
 */

import { NextRequest, NextResponse } from 'next/server';
import { issueSession, verifySession } from '@/lib/exec-auth';

export const runtime = 'nodejs';

export async function GET(req: NextRequest) {
  // If already has a valid session, just refresh the CSRF and return
  const existingSession = req.cookies.get('mc_sess')?.value;
  const isValid = existingSession ? verifySession(existingSession) !== null : false;

  if (!isValid) {
    // Issue new session
    const { mc_sess, mc_csrf } = issueSession();

    const isSecure = (process.env.MISSIONCTRL_ORIGIN ?? 'http://localhost:3000').startsWith('https');
    const response = NextResponse.json({ ok: true, session_issued: true });

    response.cookies.set('mc_sess', mc_sess, {
      httpOnly: true,
      secure: isSecure,
      sameSite: 'strict',
      path: '/',
      maxAge: 7 * 24 * 60 * 60, // 7 days in seconds
    });

    response.cookies.set('mc_csrf', mc_csrf, {
      httpOnly: false, // Readable by JS so UI can send X-MC-Csrf header
      secure: isSecure,
      sameSite: 'strict',
      path: '/',
      maxAge: 7 * 24 * 60 * 60,
    });

    return response;
  }

  // Session still valid — re-issue CSRF token only
  const { mc_sess, mc_csrf } = issueSession();
  const isSecure = (process.env.MISSIONCTRL_ORIGIN ?? 'http://localhost:3000').startsWith('https');
  const response = NextResponse.json({ ok: true, session_issued: false });

  response.cookies.set('mc_sess', mc_sess, {
    httpOnly: true,
    secure: isSecure,
    sameSite: 'strict',
    path: '/',
    maxAge: 7 * 24 * 60 * 60,
  });

  response.cookies.set('mc_csrf', mc_csrf, {
    httpOnly: false,
    secure: isSecure,
    sameSite: 'strict',
    path: '/',
    maxAge: 7 * 24 * 60 * 60,
  });

  return response;
}
