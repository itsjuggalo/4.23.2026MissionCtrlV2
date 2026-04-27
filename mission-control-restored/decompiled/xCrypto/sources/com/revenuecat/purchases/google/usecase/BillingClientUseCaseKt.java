package com.revenuecat.purchases.google.usecase;

import s3.C1779a;

/* JADX INFO: loaded from: classes3.dex */
public final class BillingClientUseCaseKt {
    private static final int MAX_RETRIES_DEFAULT = 3;
    private static final long RETRY_TIMER_MAX_TIME;
    private static final long RETRY_TIMER_SERVICE_UNAVAILABLE_MAX_TIME_FOREGROUND;
    private static final long RETRY_TIMER_START;

    static {
        C1779a.C0237a c0237a = C1779a.f14679b;
        RETRY_TIMER_START = s3.c.s(878, s3.d.f14688d);
        RETRY_TIMER_MAX_TIME = s3.c.s(15, s3.d.f14690f);
        RETRY_TIMER_SERVICE_UNAVAILABLE_MAX_TIME_FOREGROUND = s3.c.s(4, s3.d.f14689e);
    }

    public static final long getRETRY_TIMER_MAX_TIME() {
        return RETRY_TIMER_MAX_TIME;
    }

    public static final long getRETRY_TIMER_SERVICE_UNAVAILABLE_MAX_TIME_FOREGROUND() {
        return RETRY_TIMER_SERVICE_UNAVAILABLE_MAX_TIME_FOREGROUND;
    }
}
