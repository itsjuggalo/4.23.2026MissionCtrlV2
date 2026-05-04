package com.revenuecat.purchases.common;

import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import lg.a;
import lg.c;
import lg.d;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a#\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\"\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0000ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\f"}, d2 = {"Llg/a$a;", "Ljava/util/Date;", "startTime", "endTime", "Llg/a;", "between", "(Llg/a$a;Ljava/util/Date;Ljava/util/Date;)J", "duration1", "duration2", "min-QTBD994", "(JJ)J", "min", "purchases_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DurationExtensionsKt {
    public static final long between(a.C0282a c0282a, Date startTime, Date endTime) {
        t.f(c0282a, "<this>");
        t.f(startTime, "startTime");
        t.f(endTime, "endTime");
        return c.t(endTime.getTime() - startTime.getTime(), d.f15688d);
    }

    /* JADX INFO: renamed from: min-QTBD994, reason: not valid java name */
    public static final long m106minQTBD994(long j10, long j11) {
        return lg.a.l(j10, j11) < 0 ? j10 : j11;
    }
}
