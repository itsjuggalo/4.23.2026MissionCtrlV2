// This file configures the initialization of Sentry on the client.
// https://docs.sentry.io/platforms/javascript/guides/nextjs/
import * as Sentry from "@sentry/nextjs";

Sentry.init({
  dsn: "https://dba5fbbca0c55f98f49eff28a57901ae@o4511350553444352.ingest.us.sentry.io/4511350555344896",
  enableLogs: true,
  sendDefaultPii: true,

  // Session Replay — records DOM video of user session for visual debugging
  replaysSessionSampleRate: 0.1,    // 10% of normal sessions
  replaysOnErrorSampleRate: 1.0,    // 100% of sessions where an error happens

  integrations: [
    Sentry.replayIntegration({
      maskAllText: false,
      blockAllMedia: false,
    }),
    // User Feedback widget with screenshot capture
    Sentry.feedbackIntegration({
      colorScheme: "system",
      showBranding: false,
      enableScreenshot: true,
      autoInject: true,
    }),
  ],
});

export const onRouterTransitionStart = Sentry.captureRouterTransitionStart;
