import { NextResponse } from 'next/server';
import { execSync } from 'child_process';

export async function GET() {
  try {
    const raw = execSync('crontab -l 2>/dev/null || echo ""', { encoding: 'utf-8' });
    const lines = raw.split('\n').filter(l => l.trim() && !l.startsWith('#'));
    const crons = lines.map((line, i) => {
      const parts = line.trim().split(/\s+/);
      const schedule = parts.slice(0, 5).join(' ');
      const command = parts.slice(5).join(' ');
      // Extract script name
      const scriptMatch = command.match(/([^\/\s]+\.(py|sh))/);
      const name = scriptMatch ? scriptMatch[1] : command.slice(0, 40);
      return { id: i, schedule, command, name, enabled: true, raw: line };
    });
    return NextResponse.json({ crons, count: crons.length });
  } catch (e) {
    return NextResponse.json({ crons: [], count: 0, error: String(e) });
  }
}

export async function POST(req: Request) {
  try {
    const { action, cronId, raw } = await req.json();
    
    if (action === 'toggle') {
      const crontab = execSync('crontab -l 2>/dev/null || echo ""', { encoding: 'utf-8' });
      const lines = crontab.split('\n');
      let activeIndex = 0;
      const newLines = lines.map(line => {
        if (line.trim() && !line.startsWith('#')) {
          if (activeIndex === cronId) {
            activeIndex++;
            return '# DISABLED: ' + line;
          }
          activeIndex++;
        } else if (line.startsWith('# DISABLED: ') && activeIndex === cronId) {
          activeIndex++;
          return line.replace('# DISABLED: ', '');
        }
        return line;
      });
      execSync(`echo "${newLines.join('\n')}" | crontab -`, { encoding: 'utf-8' });
      return NextResponse.json({ success: true });
    }

    if (action === 'run_now') {
      const crontab = execSync('crontab -l 2>/dev/null || echo ""', { encoding: 'utf-8' });
      const lines = crontab.split('\n').filter(l => l.trim() && !l.startsWith('#'));
      if (cronId >= 0 && cronId < lines.length) {
        const parts = lines[cronId].trim().split(/\s+/);
        const command = parts.slice(5).join(' ');
        try {
          const output = execSync(command, { timeout: 30000, encoding: 'utf-8' });
          return NextResponse.json({ success: true, output: output.slice(0, 500) });
        } catch (e) {
          return NextResponse.json({ success: false, error: String(e).slice(0, 200) });
        }
      }
    }

    return NextResponse.json({ error: 'Unknown action' }, { status: 400 });
  } catch (e) {
    return NextResponse.json({ error: String(e).slice(0, 200) }, { status: 500 });
  }
}
