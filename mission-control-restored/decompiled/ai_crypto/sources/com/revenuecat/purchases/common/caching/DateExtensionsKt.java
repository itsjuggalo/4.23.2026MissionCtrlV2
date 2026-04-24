package com.revenuecat.purchases.common.caching;

import a6.C0929a;
import a6.c;
import a6.d;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.strings.ReceiptStrings;
import java.util.Arrays;
import java.util.Date;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class DateExtensionsKt {
    private static final long CACHE_REFRESH_PERIOD_IN_BACKGROUND;
    private static final long CACHE_REFRESH_PERIOD_IN_FOREGROUND;

    static {
        C0929a.C0116a c0116a = C0929a.f6400b;
        CACHE_REFRESH_PERIOD_IN_FOREGROUND = c.s(5, d.f6411f);
        CACHE_REFRESH_PERIOD_IN_BACKGROUND = c.s(25, d.f6412g);
    }

    public static final boolean isCacheStale(Date date, boolean z7, DateProvider dateProvider) {
        r.f(dateProvider, "dateProvider");
        if (date == null) {
            return true;
        }
        LogIntent logIntent = LogIntent.DEBUG;
        String str = String.format(ReceiptStrings.CHECKING_IF_CACHE_STALE, Arrays.copyOf(new Object[]{Boolean.valueOf(z7)}, 1));
        r.e(str, "format(this, *args)");
        LogWrapperKt.log(logIntent, str);
        return m66isCacheStale8Mi8wO0(date, z7 ? CACHE_REFRESH_PERIOD_IN_BACKGROUND : CACHE_REFRESH_PERIOD_IN_FOREGROUND, dateProvider);
    }

    public static /* synthetic */ boolean isCacheStale$default(Date date, boolean z7, DateProvider dateProvider, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            dateProvider = new DefaultDateProvider();
        }
        return isCacheStale(date, z7, dateProvider);
    }

    /* JADX INFO: renamed from: isCacheStale-8Mi8wO0, reason: not valid java name */
    public static final boolean m66isCacheStale8Mi8wO0(Date date, long j7, DateProvider dateProvider) {
        r.f(dateProvider, "dateProvider");
        if (date == null) {
            return true;
        }
        C0929a.C0116a c0116a = C0929a.f6400b;
        return C0929a.k(c.t(dateProvider.getNow().getTime() - date.getTime(), d.f6409d), j7) >= 0;
    }

    /* JADX INFO: renamed from: isCacheStale-8Mi8wO0$default, reason: not valid java name */
    public static /* synthetic */ boolean m67isCacheStale8Mi8wO0$default(Date date, long j7, DateProvider dateProvider, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            dateProvider = new DefaultDateProvider();
        }
        return m66isCacheStale8Mi8wO0(date, j7, dateProvider);
    }
}
