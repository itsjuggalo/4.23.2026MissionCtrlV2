package com.revenuecat.purchases.utils;

import a6.C0929a;
import a6.c;
import a6.d;
import java.util.Date;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class DateHelper {
    public static final Companion Companion = new Companion(null);
    private static final long ENTITLEMENT_GRACE_PERIOD;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC2148j abstractC2148j) {
            this();
        }

        /* JADX INFO: renamed from: isDateActive-SxA4cEA$default, reason: not valid java name */
        public static /* synthetic */ DateActive m179isDateActiveSxA4cEA$default(Companion companion, Date date, Date date2, long j7, int i7, Object obj) {
            if ((i7 & 4) != 0) {
                j7 = DateHelper.ENTITLEMENT_GRACE_PERIOD;
            }
            return companion.m180isDateActiveSxA4cEA(date, date2, j7);
        }

        /* JADX INFO: renamed from: isDateActive-SxA4cEA, reason: not valid java name */
        public final DateActive m180isDateActiveSxA4cEA(Date date, Date requestDate, long j7) {
            r.f(requestDate, "requestDate");
            if (date == null) {
                return new DateActive(true, true);
            }
            boolean z7 = new Date().getTime() - requestDate.getTime() <= C0929a.r(j7);
            if (!z7) {
                requestDate = new Date();
            }
            return new DateActive(date.after(requestDate), z7);
        }

        private Companion() {
        }
    }

    static {
        C0929a.C0116a c0116a = C0929a.f6400b;
        ENTITLEMENT_GRACE_PERIOD = c.s(3, d.f6413h);
    }

    private DateHelper() {
    }
}
