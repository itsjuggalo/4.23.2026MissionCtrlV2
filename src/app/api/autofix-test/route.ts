import { NextResponse } from "next/server";

class AutofixTestError extends Error {
  constructor() {
    super("Autofix end-to-end test error from /api/autofix-test");
  }
}

export async function GET() {
  // Intentional bug: division by zero with bad type coercion
  const data: any = null;
  return NextResponse.json({ result: data.value / 0 });
}
