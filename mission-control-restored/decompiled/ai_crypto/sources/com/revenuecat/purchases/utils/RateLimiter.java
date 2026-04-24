package com.revenuecat.purchases.utils;

import a6.C0929a;
import kotlin.jvm.internal.AbstractC2148j;

/* JADX INFO: loaded from: classes2.dex */
public final class RateLimiter {
    private final long[] callTimestamps;
    private int index;
    private final int maxCallInclusive;
    private final int maxCallsInPeriod;
    private final long periodSeconds;

    public /* synthetic */ RateLimiter(int i7, long j7, AbstractC2148j abstractC2148j) {
        this(i7, j7);
    }

    public final int getMaxCallsInPeriod() {
        return this.maxCallsInPeriod;
    }

    /* JADX INFO: renamed from: getPeriodSeconds-UwyO8pc, reason: not valid java name */
    public final long m183getPeriodSecondsUwyO8pc() {
        return this.periodSeconds;
    }

    public final synchronized boolean shouldProceed() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i7 = (this.index + 1) % this.maxCallInclusive;
        long j7 = this.callTimestamps[i7];
        if (j7 != 0 && jCurrentTimeMillis - j7 <= C0929a.r(this.periodSeconds)) {
            return false;
        }
        this.callTimestamps[this.index] = jCurrentTimeMillis;
        this.index = i7;
        return true;
    }

    private RateLimiter(int i7, long j7) {
        this.maxCallsInPeriod = i7;
        this.periodSeconds = j7;
        int i8 = i7 + 1;
        this.maxCallInclusive = i8;
        this.callTimestamps = new long[i8];
    }
}
