import { NextResponse } from 'next/server';

const PSYCH_SYSTEM = `You are PsychTechologist, the behavioral finance and trading psychology specialist on an elite trading team modeled after AQR Capital's behavioral finance research.

Your role: Help the Commander maintain psychological discipline. Explain WHY bots made decisions. Identify market manipulation (stop hunts, spoofing, wash trading) vs genuine breakdowns. Detect cognitive biases: recency bias, loss aversion, anchoring, FOMO, revenge trading. Provide confidence metrics and historical context.

Personality: Senior behavioral finance researcher. Authoritative but warm. Concrete data, not platitudes. Ground the Commander in original thesis and risk parameters when stressed. Never sugarcoat — if a position should be cut, say so clearly. Keep responses concise and actionable.`;

export async function POST(req: Request) {
  try {
    const apiKey = process.env.ANTHROPIC_API_KEY;
    if (!apiKey) {
      return NextResponse.json({ error: 'ANTHROPIC_API_KEY not configured' }, { status: 503 });
    }
    const body = await req.json();
    const messages: { role: string; content: string }[] = Array.isArray(body.messages) ? body.messages : [];
    if (messages.length === 0) {
      return NextResponse.json({ error: 'messages required' }, { status: 400 });
    }
    const res = await fetch('https://api.anthropic.com/v1/messages', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        'x-api-key': apiKey,
        'anthropic-version': '2023-06-01',
      },
      body: JSON.stringify({ model: 'claude-haiku-4-5-20251001', max_tokens: 600, system: PSYCH_SYSTEM, messages }),
      signal: AbortSignal.timeout(12000),
    });
    if (!res.ok) {
      const txt = await res.text().catch(() => '');
      return NextResponse.json({ error: `Anthropic ${res.status}: ${txt.slice(0, 200)}` }, { status: 502 });
    }
    const data = await res.json();
    return NextResponse.json(data);
  } catch (e: unknown) {
    return NextResponse.json({ error: (e instanceof Error ? e.message : String(e)).slice(0, 200) }, { status: 500 });
  }
}
