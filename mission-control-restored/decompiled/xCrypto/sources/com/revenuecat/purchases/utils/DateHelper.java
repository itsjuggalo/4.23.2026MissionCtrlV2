package com.revenuecat.purchases.utils;

import java.util.Date;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;
import s3.C1779a;
import s3.d;

/* JADX INFO: loaded from: classes3.dex */
public final class DateHelper {
    public static final Companion Companion = new Companion(null);
    private static final long ENTITLEMENT_GRACE_PERIOD;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        /* JADX INFO: renamed from: isDateActive-SxA4cEA$default, reason: not valid java name */
        public static /* synthetic */ DateActive m215isDateActiveSxA4cEA$default(Companion companion, Date date, Date date2, long j4, int i4, Object obj) {
            if ((i4 & 4) != 0) {
                j4 = DateHelper.ENTITLEMENT_GRACE_PERIOD;
            }
            return companion.m216isDateActiveSxA4cEA(date, date2, j4);
        }

        /* JADX INFO: renamed from: isDateActive-SxA4cEA, reason: not valid java name */
        public final DateActive m216isDateActiveSxA4cEA(Date date, Date requestDate, long j4) {
            r.f(requestDate, "requestDate");
            if (date == null) {
                return new DateActive(true, true);
            }
            boolean z4 = new Date().getTime() - requestDate.getTime() <= C1779a.s(j4);
            if (!z4) {
                requestDate = new Date();
            }
            return new DateActive(date.after(requestDate), z4);
        }

        private Companion() {
        }
    }

    static {
        C1779a.C0237a c0237a = C1779a.f14679b;
        ENTITLEMENT_GRACE_PERIOD = s3.c.s(3, d.f14692h);
    }

    private DateHelper() {
    }
}
