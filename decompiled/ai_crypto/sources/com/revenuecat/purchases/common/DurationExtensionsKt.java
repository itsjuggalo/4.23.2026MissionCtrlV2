package com.revenuecat.purchases.common;

import a6.C0929a;
import a6.c;
import a6.d;
import java.util.Date;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class DurationExtensionsKt {
    public static final long between(C0929a.C0116a c0116a, Date startTime, Date endTime) {
        r.f(c0116a, "<this>");
        r.f(startTime, "startTime");
        r.f(endTime, "endTime");
        return c.t(endTime.getTime() - startTime.getTime(), d.f6409d);
    }

    /* JADX INFO: renamed from: min-QTBD994, reason: not valid java name */
    public static final long m65minQTBD994(long j7, long j8) {
        return C0929a.k(j7, j8) < 0 ? j7 : j8;
    }
}
