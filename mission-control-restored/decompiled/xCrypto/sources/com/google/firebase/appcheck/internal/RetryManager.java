package com.google.firebase.appcheck.internal;

import com.google.firebase.appcheck.internal.util.Clock;

/* JADX INFO: loaded from: classes.dex */
public class RetryManager {
    static final int BAD_REQUEST_ERROR_CODE = 400;
    private static final int EXPONENTIAL = 0;
    static final long MAX_EXP_BACKOFF_MILLIS = 14400000;
    private static final double MAX_JITTER_MULTIPLIER = 0.5d;
    static final int NOT_FOUND_ERROR_CODE = 404;
    private static final int ONE_DAY = 1;
    static final long ONE_DAY_MILLIS = 86400000;
    static final long ONE_SECOND_MILLIS = 1000;
    static final long UNSET_RETRY_TIME = -1;
    private final Clock clock;
    private long currentRetryCount;
    private long nextRetryTimeMillis;

    public RetryManager() {
        this.currentRetryCount = 0L;
        this.nextRetryTimeMillis = -1L;
        this.clock = new Clock.DefaultClock();
    }

    private static int getBackoffStrategyByErrorCode(int i4) {
        return (i4 == 400 || i4 == 404) ? 1 : 0;
    }

    public boolean canRetry() {
        return this.nextRetryTimeMillis <= this.clock.currentTimeMillis();
    }

    public long getNextRetryTimeMillis() {
        return this.nextRetryTimeMillis;
    }

    public void resetBackoffOnSuccess() {
        this.currentRetryCount = 0L;
        this.nextRetryTimeMillis = -1L;
    }

    public void updateBackoffOnFailure(int i4) {
        this.currentRetryCount++;
        if (getBackoffStrategyByErrorCode(i4) == 1) {
            this.nextRetryTimeMillis = this.clock.currentTimeMillis() + ONE_DAY_MILLIS;
            return;
        }
        this.nextRetryTimeMillis = this.clock.currentTimeMillis() + Math.min((long) (Math.pow(2.0d, this.currentRetryCount * ((Math.random() * MAX_JITTER_MULTIPLIER) + 1.0d)) * 1000.0d), MAX_EXP_BACKOFF_MILLIS);
    }

    public RetryManager(Clock clock) {
        this.currentRetryCount = 0L;
        this.nextRetryTimeMillis = -1L;
        this.clock = clock;
    }
}
