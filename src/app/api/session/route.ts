/**
 * /api/session — issues mc_sess + mc_csrf cookies on first load.
 * Called by the dashboard entry route (or via middleware redirect).
 * Phase 3d.bis: session cookie issuance.
 */

import { NextRequest, NextResponse } from 'next/server';
import { issueSession, verifySession } from '@/lib/exec-auth';

export const runtime = 'nodejs';

export async function GET(req: NextRequest) {
  try {
    // If already has a valid session, just refresh the CSRF and return
    const existingSession = req.cookies.get('mc_sess')?.value;
    const isValid = existingSession ? verifySession(existingSession) !== null : false;

    const { mc_sess, mc_csrf } = issueSession();
    const isSecure = (process.env.MISSIONCTRL_ORIGIN ?? 'http://localhost:3000').startsWith('https');
    const cookieOpts = (httpOnly: boolean) => ({
      httpOnly,
      secure: isSecure,
      sameSite: 'strict' as const,
      path: '/',
      maxAge: 7 * 24 * 60 * 60,
    });

    const response = NextResponse.json({ ok: true, session_issued: !isValid });
    response.cookies.set('mc_sess', mc_sess, cookieOpts(true));
    response.cookies.set('mc_csrf', mc_csrf, cookieOpts(false));
    return response;
  } catch (e: unknown) {
    return NextResponse.json({ ok: false, error: (e instanceof Error ? e.message : String(e)).slice(0, 200) }, { status: 500 });
  }
}
