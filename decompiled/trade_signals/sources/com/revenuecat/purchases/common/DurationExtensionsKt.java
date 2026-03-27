package com.revenuecat.purchases.common;

import W6.a;
import W6.c;
import W6.d;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a#\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\"\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0000ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\f"}, d2 = {"LW6/a$a;", "Ljava/util/Date;", "startTime", "endTime", "LW6/a;", "between", "(LW6/a$a;Ljava/util/Date;Ljava/util/Date;)J", "duration1", "duration2", "min-QTBD994", "(JJ)J", "min", "purchases_defaultsRelease"}, k = 2, mv = {1, 8, 0})
public final class DurationExtensionsKt {
    public static final long between(a.C0149a c0149a, Date startTime, Date endTime) {
        AbstractC2304t.f(c0149a, "<this>");
        AbstractC2304t.f(startTime, "startTime");
        AbstractC2304t.f(endTime, "endTime");
        return c.t(endTime.getTime() - startTime.getTime(), d.f9315d);
    }

    /* JADX INFO: renamed from: min-QTBD994, reason: not valid java name */
    public static final long m62minQTBD994(long j8, long j9) {
        return W6.a.m(j8, j9) < 0 ? j8 : j9;
    }
}
