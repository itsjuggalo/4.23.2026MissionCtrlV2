import { NextResponse } from 'next/server';
import { execSync } from 'child_process';

export const dynamic = 'force-dynamic';
export const revalidate = 0;

export async function GET() {
  try {
    // Try to read from OpenClaw logs for token usage
    const tokenData = {
      inputTokens: 0,
      outputTokens: 0,
      totalCost: 0,
      model: 'claude-sonnet-4',
      sessionCount: 0,
    };

    // Try reading today's log for token counts
    try {
      const today = new Date().toISOString().split('T')[0];
      const logPath = `/tmp/openclaw/openclaw-${today}.log`;
      const raw = execSync(`grep -o "input_tokens:[0-9]*\\|output_tokens:[0-9]*" ${logPath} 2>/dev/null | tail -100`, { timeout: 3000 }).toString();
      
      const inputMatches = raw.match(/input_tokens:(\d+)/g) || [];
      const outputMatches = raw.match(/output_tokens:(\d+)/g) || [];
      
      const inputTotal = inputMatches.reduce((sum, m) => sum + (parseInt(m.split(':')[1], 10) || 0), 0);
      const outputTotal = outputMatches.reduce((sum, m) => sum + (parseInt(m.split(':')[1], 10) || 0), 0);
      
      if (inputTotal > 0 || outputTotal > 0) {
        tokenData.inputTokens = inputTotal;
        tokenData.outputTokens = outputTotal;
        // Claude Sonnet approx pricing: $3/M input, $15/M output
        tokenData.totalCost = (inputTotal / 1_000_000 * 3) + (outputTotal / 1_000_000 * 15);
      }
    } catch { /* no log data */ }

    // Get session count from PM2
    try {
      const pm2Out = execSync('pm2 jlist 2>/dev/null', { timeout: 3000 }).toString();
      const processes = JSON.parse(pm2Out);
      tokenData.sessionCount = processes.filter((p: { pm2_env?: { status?: string } }) => p.pm2_env?.status === 'online').length;
    } catch { /* ignore */ }

    return NextResponse.json({ success: true, tokens: tokenData });
  } catch {
    return NextResponse.json({ success: false, tokens: { inputTokens: 0, outputTokens: 0, totalCost: 0, model: 'claude-sonnet-4', sessionCount: 0 } });
  }
}
