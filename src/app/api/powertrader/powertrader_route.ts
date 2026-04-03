import { NextResponse } from 'next/server';
import { promises as fs } from 'fs';
import path from 'path';
import { exec } from 'child_process';
import { promisify } from 'util';

const execAsync = promisify(exec);

const HUB_DATA = '/home/ubuntu/mission-control/powertrader-ai/hub_data';

async function readJson(filePath: string): Promise<any> {
  try {
    const data = await fs.readFile(filePath, 'utf-8');
    return JSON.parse(data);
  } catch {
    return null;
  }
}

async function readJsonl(filePath: string): Promise<any[]> {
  try {
    const data = await fs.readFile(filePath, 'utf-8');
    return data.trim().split('\n')
      .filter(Boolean)
      .map(line => { try { return JSON.parse(line); } catch { return null; } })
      .filter(Boolean)
      .reverse(); // newest first
  } catch {
    return [];
  }
}

async function isRunning(): Promise<boolean> {
  try {
    const { stdout } = await execAsync('pm2 jlist');
    const list = JSON.parse(stdout);
    return list.some((p: any) => p.name === 'powertrader' && p.pm2_env?.status === 'online');
  } catch {
    return false;
  }
}

export async function GET() {
  try {
    const [status, trades, pnl, running] = await Promise.all([
      readJson(path.join(HUB_DATA, 'trader_status.json')),
      readJsonl(path.join(HUB_DATA, 'trade_history.jsonl')),
      readJson(path.join(HUB_DATA, 'pnl_ledger.json')),
      isRunning(),
    ]);

    return NextResponse.json({
      success: true,
      status:  status || {},
      trades:  trades.slice(0, 100),
      pnl:     pnl || {},
      running,
      hub_data_path: HUB_DATA,
    }, { headers: { 'Cache-Control': 'no-store' } });

  } catch (error) {
    return NextResponse.json({
      success: false,
      status:  {},
      trades:  [],
      pnl:     {},
      running: false,
      hub_data_path: HUB_DATA,
    }, { status: 500 });
  }
}
