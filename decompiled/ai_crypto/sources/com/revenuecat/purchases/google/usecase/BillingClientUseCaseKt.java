package com.revenuecat.purchases.google.usecase;

import a6.C0929a;

/* JADX INFO: loaded from: classes2.dex */
public final class BillingClientUseCaseKt {
    private static final int MAX_RETRIES_DEFAULT = 3;
    private static final long RETRY_TIMER_MAX_TIME;
    private static final long RETRY_TIMER_SERVICE_UNAVAILABLE_MAX_TIME_FOREGROUND;
    private static final long RETRY_TIMER_START;

    static {
        C0929a.C0116a c0116a = C0929a.f6400b;
        RETRY_TIMER_START = a6.c.s(878, a6.d.f6409d);
        RETRY_TIMER_MAX_TIME = a6.c.s(15, a6.d.f6411f);
        RETRY_TIMER_SERVICE_UNAVAILABLE_MAX_TIME_FOREGROUND = a6.c.s(4, a6.d.f6410e);
    }

    public static final long getRETRY_TIMER_MAX_TIME() {
        return RETRY_TIMER_MAX_TIME;
    }

    public static final long getRETRY_TIMER_SERVICE_UNAVAILABLE_MAX_TIME_FOREGROUND() {
        return RETRY_TIMER_SERVICE_UNAVAILABLE_MAX_TIME_FOREGROUND;
    }
}
