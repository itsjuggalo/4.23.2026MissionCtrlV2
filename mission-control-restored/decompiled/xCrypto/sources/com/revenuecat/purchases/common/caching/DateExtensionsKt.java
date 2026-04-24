package com.revenuecat.purchases.common.caching;

import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import java.util.Date;
import kotlin.jvm.internal.r;
import s3.C1779a;
import s3.c;
import s3.d;

/* JADX INFO: loaded from: classes.dex */
public final class DateExtensionsKt {
    private static final long CACHE_REFRESH_PERIOD_IN_BACKGROUND;
    private static final long CACHE_REFRESH_PERIOD_IN_FOREGROUND;

    static {
        C1779a.C0237a c0237a = C1779a.f14679b;
        CACHE_REFRESH_PERIOD_IN_FOREGROUND = c.s(5, d.f14690f);
        CACHE_REFRESH_PERIOD_IN_BACKGROUND = c.s(25, d.f14691g);
    }

    public static final boolean isCacheStale(Date date, boolean z4, DateProvider dateProvider) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        r.f(dateProvider, "dateProvider");
        if (date == null) {
            return true;
        }
        LogIntent logIntent = LogIntent.DEBUG;
        DateExtensionsKt$isCacheStale$lambda$1$$inlined$log$1 dateExtensionsKt$isCacheStale$lambda$1$$inlined$log$1 = new DateExtensionsKt$isCacheStale$lambda$1$$inlined$log$1(logIntent, z4);
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    str2 = (String) dateExtensionsKt$isCacheStale$lambda$1$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) dateExtensionsKt$isCacheStale$lambda$1$$inlined$log$1.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) dateExtensionsKt$isCacheStale$lambda$1$$inlined$log$1.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) dateExtensionsKt$isCacheStale$lambda$1$$inlined$log$1.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    str2 = (String) dateExtensionsKt$isCacheStale$lambda$1$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) dateExtensionsKt$isCacheStale$lambda$1$$inlined$log$1.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) dateExtensionsKt$isCacheStale$lambda$1$$inlined$log$1.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    str2 = (String) dateExtensionsKt$isCacheStale$lambda$1$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    str2 = (String) dateExtensionsKt$isCacheStale$lambda$1$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) dateExtensionsKt$isCacheStale$lambda$1$$inlined$log$1.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) dateExtensionsKt$isCacheStale$lambda$1$$inlined$log$1.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) dateExtensionsKt$isCacheStale$lambda$1$$inlined$log$1.invoke(), null);
                break;
        }
        return m98isCacheStale8Mi8wO0(date, z4 ? CACHE_REFRESH_PERIOD_IN_BACKGROUND : CACHE_REFRESH_PERIOD_IN_FOREGROUND, dateProvider);
    }

    public static /* synthetic */ boolean isCacheStale$default(Date date, boolean z4, DateProvider dateProvider, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            dateProvider = new DefaultDateProvider();
        }
        return isCacheStale(date, z4, dateProvider);
    }

    /* JADX INFO: renamed from: isCacheStale-8Mi8wO0, reason: not valid java name */
    public static final boolean m98isCacheStale8Mi8wO0(Date date, long j4, DateProvider dateProvider) {
        r.f(dateProvider, "dateProvider");
        if (date == null) {
            return true;
        }
        C1779a.C0237a c0237a = C1779a.f14679b;
        return C1779a.l(c.t(dateProvider.getNow().getTime() - date.getTime(), d.f14688d), j4) >= 0;
    }

    /* JADX INFO: renamed from: isCacheStale-8Mi8wO0$default, reason: not valid java name */
    public static /* synthetic */ boolean m99isCacheStale8Mi8wO0$default(Date date, long j4, DateProvider dateProvider, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            dateProvider = new DefaultDateProvider();
        }
        return m98isCacheStale8Mi8wO0(date, j4, dateProvider);
    }
}
