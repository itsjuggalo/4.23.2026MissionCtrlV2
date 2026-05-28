import fs from 'fs';
import path from 'path';

const SECRETS = path.join(process.env.HOME || '/home/itsju', '.openclaw/secrets');

let cachedUrl: string | null | undefined = undefined;

function webhookUrl(): string | null {
  if (cachedUrl !== undefined) return cachedUrl;
  const p = path.join(SECRETS, 'discord_bobatrades_webhook');
  try {
    cachedUrl = fs.readFileSync(p, 'utf-8').trim();
  } catch {
    cachedUrl = null;
  }
  return cachedUrl;
}

type Color = 'green' | 'red' | 'yellow' | 'grey';
const COLORS: Record<Color, number> = {
  green: 0x22c55e,
  red: 0xef4444,
  yellow: 0xf59e0b,
  grey: 0x6b7280,
};

export async function postDiscord(content: string, color: Color = 'grey', mention = false): Promise<void> {
  const url = webhookUrl();
  if (!url) return;
  try {
    await fetch(url, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({
        content: mention ? `@here ${content}` : content,
        embeds: [{ color: COLORS[color], description: content }],
        allowed_mentions: { parse: mention ? ['everyone'] : [] },
      }),
    });
  } catch {
    // best-effort, never throw to the request path
  }
}
