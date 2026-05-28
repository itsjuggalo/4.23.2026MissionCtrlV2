import { NextResponse } from 'next/server';
import { execFileSync } from 'child_process';

const PSYCH_SYSTEM = `You are PsychTechologist, the behavioral finance and trading psychology specialist on an elite trading team modeled after AQR Capital's behavioral finance research.

Your role: Help the Commander maintain psychological discipline. Explain WHY bots made decisions. Identify market manipulation (stop hunts, spoofing, wash trading) vs genuine breakdowns. Detect cognitive biases: recency bias, loss aversion, anchoring, FOMO, revenge trading. Provide confidence metrics and historical context.

Personality: Senior behavioral finance researcher. Authoritative but warm. Concrete data, not platitudes. Ground the Commander in original thesis and risk parameters when stressed. Never sugarcoat — if a position should be cut, say so clearly. Keep responses concise and actionable.`;

const CLAUDE_BIN = process.env.CLAUDE_BIN ?? 'claude';

export async function POST(req: Request) {
  try {
    const body = await req.json();
    const messages: { role: string; content: string }[] = Array.isArray(body.messages) ? body.messages : [];
    if (messages.length === 0) {
      return NextResponse.json({ error: 'messages required' }, { status: 400 });
    }
    // Format conversation history + system prompt into a single prompt for claude --print
    const history = messages
      .map((m) => `${m.role === 'user' ? 'User' : 'Assistant'}: ${m.content}`)
      .join('\n\n');
    const fullPrompt = `${PSYCH_SYSTEM}\n\n${history}\n\nAssistant:`;
    const text = execFileSync(
      CLAUDE_BIN,
      ['--print', '--model', 'claude-haiku-4-5-20251001'],
      { input: fullPrompt, encoding: 'utf8', timeout: 15000 }
    ).trim();
    // Return in Anthropic messages API shape so the client doesn't need changes
    return NextResponse.json({
      content: [{ type: 'text', text }],
      model: 'claude-haiku-4-5-20251001',
      role: 'assistant',
    });
  } catch (e: unknown) {
    return NextResponse.json({ error: (e instanceof Error ? e.message : String(e)).slice(0, 200) }, { status: 500 });
  }
}
