import { NextResponse } from 'next/server';
import { readFileSync, existsSync } from 'fs';
import { join } from 'path';

const SECRETS = join(process.env.HOME || '/home/ubuntu', '.openclaw/secrets');

async function sendDiscordMessage(webhookUrl: string, content: string) {
  const res = await fetch(webhookUrl, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ content }),
  });
  return res.ok;
}

export async function POST(req: Request) {
  try {
    const { agent, message, channel } = await req.json();

    // Map agent to appropriate Discord webhook
    const webhookMap: Record<string, string> = {
      'broadcast': join(SECRETS, 'discord-webhook-broadcast-log.txt'),
      'signals': join(SECRETS, 'discord-webhook-eric-signals.txt'),
      'execution': join(SECRETS, 'discord-webhook-executions-live.txt'),
      'risk': join(SECRETS, 'discord-webhook-risk-alerts.txt'),
    };

    const webhookFile = webhookMap[channel || 'broadcast'];
    if (!webhookFile || !existsSync(webhookFile)) {
      return NextResponse.json({ error: 'Unknown channel' }, { status: 400 });
    }

    const webhookUrl = readFileSync(webhookFile, 'utf-8').trim();
    const formatted = `**[MISSION CTRL → ${agent || 'ALL'}]**\n${message}`;
    
    const sent = await sendDiscordMessage(webhookUrl, formatted);
    return NextResponse.json({ success: sent });
  } catch (e) {
    return NextResponse.json({ error: String(e).slice(0, 200) }, { status: 500 });
  }
}
