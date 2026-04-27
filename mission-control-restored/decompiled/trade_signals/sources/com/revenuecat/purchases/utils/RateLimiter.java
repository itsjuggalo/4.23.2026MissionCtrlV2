package com.revenuecat.purchases.utils;

import W6.a;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2296k;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0016\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0005\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000bR\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u000b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0016"}, d2 = {"Lcom/revenuecat/purchases/utils/RateLimiter;", "", "", "maxCallsInPeriod", "LW6/a;", "periodSeconds", "<init>", "(IJLkotlin/jvm/internal/k;)V", "", "shouldProceed", "()Z", "I", "getMaxCallsInPeriod", "()I", "J", "getPeriodSeconds-UwyO8pc", "()J", "maxCallInclusive", "", "callTimestamps", "[J", FirebaseAnalytics.Param.INDEX, "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0})
public final class RateLimiter {
    private final long[] callTimestamps;
    private int index;
    private final int maxCallInclusive;
    private final int maxCallsInPeriod;
    private final long periodSeconds;

    private RateLimiter(int i8, long j8) {
        this.maxCallsInPeriod = i8;
        this.periodSeconds = j8;
        int i9 = i8 + 1;
        this.maxCallInclusive = i9;
        this.callTimestamps = new long[i9];
    }

    public final int getMaxCallsInPeriod() {
        return this.maxCallsInPeriod;
    }

    /* JADX INFO: renamed from: getPeriodSeconds-UwyO8pc, reason: not valid java name and from getter */
    public final long getPeriodSeconds() {
        return this.periodSeconds;
    }

    public final synchronized boolean shouldProceed() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i8 = (this.index + 1) % this.maxCallInclusive;
        long j8 = this.callTimestamps[i8];
        if (j8 != 0 && jCurrentTimeMillis - j8 <= a.H(this.periodSeconds)) {
            return false;
        }
        this.callTimestamps[this.index] = jCurrentTimeMillis;
        this.index = i8;
        return true;
    }

    public /* synthetic */ RateLimiter(int i8, long j8, AbstractC2296k abstractC2296k) {
        this(i8, j8);
    }
}
