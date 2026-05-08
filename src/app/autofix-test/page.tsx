"use client";
import * as Sentry from "@sentry/nextjs";

export default function AutofixTest() {
  const fire = async () => {
    try {
      const r = await fetch("/api/autofix-test");
      const d = await r.json();
      console.log(d);
    } catch (e) {
      Sentry.captureException(e);
    }
  };
  return (
    <main style={{padding:48}}>
      <h1>Autofix Loop Test</h1>
      <button onClick={fire} style={{padding:12,fontSize:16}}>Trigger Sentry Error</button>
    </main>
  );
}
