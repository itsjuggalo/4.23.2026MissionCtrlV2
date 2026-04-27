package com.revenuecat.purchases.common;

import a6.C0929a;
import a6.c;
import a6.d;

/* JADX INFO: loaded from: classes2.dex */
public final class DispatcherConstants {
    public static final DispatcherConstants INSTANCE = new DispatcherConstants();
    private static final long jitterDelay;
    private static final long jitterLongDelay;

    static {
        C0929a.C0116a c0116a = C0929a.f6400b;
        d dVar = d.f6409d;
        jitterDelay = c.t(5000L, dVar);
        jitterLongDelay = c.t(10000L, dVar);
    }

    private DispatcherConstants() {
    }

    /* JADX INFO: renamed from: getJitterDelay-UwyO8pc, reason: not valid java name */
    public final long m63getJitterDelayUwyO8pc() {
        return jitterDelay;
    }

    /* JADX INFO: renamed from: getJitterLongDelay-UwyO8pc, reason: not valid java name */
    public final long m64getJitterLongDelayUwyO8pc() {
        return jitterLongDelay;
    }
}
