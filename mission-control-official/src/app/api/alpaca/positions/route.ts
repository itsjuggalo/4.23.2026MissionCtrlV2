import { NextResponse } from 'next/server';
import { exec } from 'child_process';
import { promisify } from 'util';

const execPromise = promisify(exec);

export async function GET() {
  try {
    const { stdout } = await execPromise(
      `export APCA_API_KEY_ID='PKR7G34GSA6D73KHV6YWO5DKFX' && ` +
      `export APCA_API_SECRET_KEY='27TKsjFZiySeXu4EBb7bwCvJpucHHbwjC94BRXXaJTLj' && ` +
      `export APCA_API_BASE_URL='https://paper-api.alpaca.markets' && ` +
      `cd /home/ubuntu/.openclaw/workspace/skills/alpaca-trading && ` +
      `bash scripts/alpaca.sh GET /v2/positions`
    );

    const positions = JSON.parse(stdout);
    return NextResponse.json(positions);
  } catch (error) {
    console.error('Alpaca positions error:', error);
    return NextResponse.json([], { status: 200 }); // Return empty array on error
  }
}
