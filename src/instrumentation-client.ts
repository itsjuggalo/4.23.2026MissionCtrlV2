// This file configures the initialization of Sentry on the client.
// https://docs.sentry.io/platforms/javascript/guides/nextjs/
import * as Sentry from "@sentry/nextjs";

Sentry.init({
  dsn: "https://de57cb0654c3ca6a9a0118a93c1058c4@o4511350553444352.ingest.us.sentry.io/4511350671802368",
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
