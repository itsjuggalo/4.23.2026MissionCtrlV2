package com.revenuecat.purchases.utils;

import W6.a;
import W6.c;
import W6.d;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/revenuecat/purchases/utils/DateHelper;", "", "()V", "Companion", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DateHelper {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long ENTITLEMENT_GRACE_PERIOD;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\f\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\u00078\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\r\u0010\u000e\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000f"}, d2 = {"Lcom/revenuecat/purchases/utils/DateHelper$Companion;", "", "<init>", "()V", "Ljava/util/Date;", "expirationDate", "requestDate", "LW6/a;", "gracePeriod", "Lcom/revenuecat/purchases/utils/DateActive;", "isDateActive-SxA4cEA", "(Ljava/util/Date;Ljava/util/Date;J)Lcom/revenuecat/purchases/utils/DateActive;", "isDateActive", "ENTITLEMENT_GRACE_PERIOD", "J", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        private Companion() {
        }

        /* JADX INFO: renamed from: isDateActive-SxA4cEA$default, reason: not valid java name */
        public static /* synthetic */ DateActive m177isDateActiveSxA4cEA$default(Companion companion, Date date, Date date2, long j8, int i8, Object obj) {
            if ((i8 & 4) != 0) {
                j8 = DateHelper.ENTITLEMENT_GRACE_PERIOD;
            }
            return companion.m178isDateActiveSxA4cEA(date, date2, j8);
        }

        /* JADX INFO: renamed from: isDateActive-SxA4cEA, reason: not valid java name */
        public final DateActive m178isDateActiveSxA4cEA(Date expirationDate, Date requestDate, long gracePeriod) {
            AbstractC2304t.f(requestDate, "requestDate");
            if (expirationDate == null) {
                return new DateActive(true, true);
            }
            boolean z7 = new Date().getTime() - requestDate.getTime() <= a.H(gracePeriod);
            if (!z7) {
                requestDate = new Date();
            }
            return new DateActive(expirationDate.after(requestDate), z7);
        }

        public /* synthetic */ Companion(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    static {
        a.C0149a c0149a = a.f9306b;
        ENTITLEMENT_GRACE_PERIOD = c.s(3, d.f9319h);
    }

    private DateHelper() {
    }
}
