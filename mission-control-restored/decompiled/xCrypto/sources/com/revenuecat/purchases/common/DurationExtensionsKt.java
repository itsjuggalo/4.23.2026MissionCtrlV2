package com.revenuecat.purchases.common;

import java.util.Date;
import kotlin.jvm.internal.r;
import s3.C1779a;
import s3.c;
import s3.d;

/* JADX INFO: loaded from: classes.dex */
public final class DurationExtensionsKt {
    public static final long between(C1779a.C0237a c0237a, Date startTime, Date endTime) {
        r.f(c0237a, "<this>");
        r.f(startTime, "startTime");
        r.f(endTime, "endTime");
        return c.t(endTime.getTime() - startTime.getTime(), d.f14688d);
    }

    /* JADX INFO: renamed from: min-QTBD994, reason: not valid java name */
    public static final long m97minQTBD994(long j4, long j5) {
        return C1779a.l(j4, j5) < 0 ? j4 : j5;
    }
}
