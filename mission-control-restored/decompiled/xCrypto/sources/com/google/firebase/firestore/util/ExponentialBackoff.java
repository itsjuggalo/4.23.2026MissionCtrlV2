package com.google.firebase.firestore.util;

import com.google.firebase.firestore.util.AsyncQueue;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public class ExponentialBackoff {
    public static final double DEFAULT_BACKOFF_FACTOR = 1.5d;
    public static final long DEFAULT_BACKOFF_INITIAL_DELAY_MS = 1000;
    public static final long DEFAULT_BACKOFF_MAX_DELAY_MS = 60000;
    private final double backoffFactor;
    private long currentBaseMs;
    private final long initialDelayMs;
    private long lastAttemptTime;
    private final long maxDelayMs;
    private long nextMaxDelayMs;
    private final AsyncQueue queue;
    private final AsyncQueue.TimerId timerId;
    private AsyncQueue.DelayedTask timerTask;

    public ExponentialBackoff(AsyncQueue asyncQueue, AsyncQueue.TimerId timerId, long j4, double d4, long j5) {
        this.queue = asyncQueue;
        this.timerId = timerId;
        this.initialDelayMs = j4;
        this.backoffFactor = d4;
        this.maxDelayMs = j5;
        this.nextMaxDelayMs = j5;
        this.lastAttemptTime = new Date().getTime();
        reset();
    }

    public static /* synthetic */ void a(ExponentialBackoff exponentialBackoff, Runnable runnable) {
        exponentialBackoff.getClass();
        exponentialBackoff.lastAttemptTime = new Date().getTime();
        runnable.run();
    }

    private long jitterDelayMs() {
        return (long) ((Math.random() - 0.5d) * this.currentBaseMs);
    }

    public void backoffAndRun(final Runnable runnable) {
        cancel();
        long jJitterDelayMs = this.currentBaseMs + jitterDelayMs();
        long jMax = Math.max(0L, new Date().getTime() - this.lastAttemptTime);
        long jMax2 = Math.max(0L, jJitterDelayMs - jMax);
        if (this.currentBaseMs > 0) {
            Logger.debug(getClass().getSimpleName(), "Backing off for %d ms (base delay: %d ms, delay with jitter: %d ms, last attempt: %d ms ago)", Long.valueOf(jMax2), Long.valueOf(this.currentBaseMs), Long.valueOf(jJitterDelayMs), Long.valueOf(jMax));
        }
        this.timerTask = this.queue.enqueueAfterDelay(this.timerId, jMax2, new Runnable() { // from class: com.google.firebase.firestore.util.m
            @Override // java.lang.Runnable
            public final void run() {
                ExponentialBackoff.a(this.f10729a, runnable);
            }
        });
        long j4 = (long) (this.currentBaseMs * this.backoffFactor);
        this.currentBaseMs = j4;
        long j5 = this.initialDelayMs;
        if (j4 < j5) {
            this.currentBaseMs = j5;
        } else {
            long j6 = this.nextMaxDelayMs;
            if (j4 > j6) {
                this.currentBaseMs = j6;
            }
        }
        this.nextMaxDelayMs = this.maxDelayMs;
    }

    public void cancel() {
        AsyncQueue.DelayedTask delayedTask = this.timerTask;
        if (delayedTask != null) {
            delayedTask.cancel();
            this.timerTask = null;
        }
    }

    public void reset() {
        this.currentBaseMs = 0L;
    }

    public void resetToMax() {
        this.currentBaseMs = this.nextMaxDelayMs;
    }

    public void setTemporaryMaxDelay(long j4) {
        this.nextMaxDelayMs = j4;
    }

    public ExponentialBackoff(AsyncQueue asyncQueue, AsyncQueue.TimerId timerId) {
        this(asyncQueue, timerId, 1000L, 1.5d, DEFAULT_BACKOFF_MAX_DELAY_MS);
    }
}
