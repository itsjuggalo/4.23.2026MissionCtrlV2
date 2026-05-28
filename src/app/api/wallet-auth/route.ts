import { NextResponse } from 'next/server';

export async function POST(req: Request) {
  try {
    const { password } = await req.json();
    const correct = process.env.WALLET_PASSWORD;

    if (!correct) {
      return NextResponse.json(
        { success: false, error: 'Not configured' },
        { status: 500 }
      );
    }

    if (!password || typeof password !== 'string') {
      return NextResponse.json({ success: false, error: 'Access denied' }, { status: 401 });
    }

    if (password.toLowerCase() !== correct.toLowerCase()) {
      // Generic error — don't reveal if password exists or not
      return NextResponse.json(
        { success: false, error: 'Access denied' },
        { status: 401 }
      );
    }

    const response = NextResponse.json({ success: true });
    response.cookies.set('wallet_auth', '1', {
      httpOnly: true,
      secure: false,
      sameSite: 'strict',
      path: '/',
      maxAge: 900,
    });
    return response;
  } catch {
    return NextResponse.json(
      { success: false, error: 'Access denied' },
      { status: 401 }
    );
  }
}
