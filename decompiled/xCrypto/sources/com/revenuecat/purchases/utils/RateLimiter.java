package com.revenuecat.purchases.utils;

import kotlin.jvm.internal.AbstractC1585j;
import s3.C1779a;

/* JADX INFO: loaded from: classes3.dex */
public final class RateLimiter {
    private final long[] callTimestamps;
    private int index;
    private final int maxCallInclusive;
    private final int maxCallsInPeriod;
    private final long periodSeconds;

    public /* synthetic */ RateLimiter(int i4, long j4, AbstractC1585j abstractC1585j) {
        this(i4, j4);
    }

    public final int getMaxCallsInPeriod() {
        return this.maxCallsInPeriod;
    }

    /* JADX INFO: renamed from: getPeriodSeconds-UwyO8pc, reason: not valid java name */
    public final long m219getPeriodSecondsUwyO8pc() {
        return this.periodSeconds;
    }

    public final synchronized boolean shouldProceed() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i4 = (this.index + 1) % this.maxCallInclusive;
        long j4 = this.callTimestamps[i4];
        if (j4 != 0 && jCurrentTimeMillis - j4 <= C1779a.s(this.periodSeconds)) {
            return false;
        }
        this.callTimestamps[this.index] = jCurrentTimeMillis;
        this.index = i4;
        return true;
    }

    private RateLimiter(int i4, long j4) {
        this.maxCallsInPeriod = i4;
        this.periodSeconds = j4;
        int i5 = i4 + 1;
        this.maxCallInclusive = i5;
        this.callTimestamps = new long[i5];
    }
}
