package com.revenuecat.purchases.common;

import s3.C1779a;
import s3.c;
import s3.d;

/* JADX INFO: loaded from: classes.dex */
public final class DispatcherConstants {
    public static final DispatcherConstants INSTANCE = new DispatcherConstants();
    private static final long jitterDelay;
    private static final long jitterLongDelay;

    static {
        C1779a.C0237a c0237a = C1779a.f14679b;
        d dVar = d.f14688d;
        jitterDelay = c.t(5000L, dVar);
        jitterLongDelay = c.t(10000L, dVar);
    }

    private DispatcherConstants() {
    }

    /* JADX INFO: renamed from: getJitterDelay-UwyO8pc, reason: not valid java name */
    public final long m95getJitterDelayUwyO8pc() {
        return jitterDelay;
    }

    /* JADX INFO: renamed from: getJitterLongDelay-UwyO8pc, reason: not valid java name */
    public final long m96getJitterLongDelayUwyO8pc() {
        return jitterLongDelay;
    }
}
