package com.revenuecat.purchases.identity;

import W2.E;
import W2.p;
import Z2.e;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes3.dex */
public final class IdentityManager$aliasCurrentUserIdTo$2$1 extends s implements Function0 {
    final /* synthetic */ e $continuation;
    final /* synthetic */ String $newAppUserID;
    final /* synthetic */ String $oldAppUserID;
    final /* synthetic */ IdentityManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IdentityManager$aliasCurrentUserIdTo$2$1(IdentityManager identityManager, e eVar, String str, String str2) {
        super(0);
        this.this$0 = identityManager;
        this.$continuation = eVar;
        this.$newAppUserID = str;
        this.$oldAppUserID = str2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Object invoke() {
        m131invoke();
        return E.f5463a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m131invoke() {
        LogHandler currentLogHandler;
        String str;
        String str2;
        IdentityManager identityManager = this.this$0;
        String str3 = this.$newAppUserID;
        String str4 = this.$oldAppUserID;
        synchronized (identityManager) {
            try {
                LogIntent logIntent = LogIntent.USER;
                IdentityManager$aliasCurrentUserIdTo$2$1$invoke$lambda$1$$inlined$log$1 identityManager$aliasCurrentUserIdTo$2$1$invoke$lambda$1$$inlined$log$1 = new IdentityManager$aliasCurrentUserIdTo$2$1$invoke$lambda$1$$inlined$log$1(logIntent, str4, str3);
                switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                    case 1:
                        LogLevel logLevel = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                            str = "[Purchases] - " + logLevel.name();
                            str2 = (String) identityManager$aliasCurrentUserIdTo$2$1$invoke$lambda$1$$inlined$log$1.invoke();
                            currentLogHandler.d(str, str2);
                        }
                        break;
                    case 2:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) identityManager$aliasCurrentUserIdTo$2$1$invoke$lambda$1$$inlined$log$1.invoke(), null);
                        break;
                    case 3:
                        LogLevel logLevel2 = LogLevel.WARN;
                        LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                            currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) identityManager$aliasCurrentUserIdTo$2$1$invoke$lambda$1$$inlined$log$1.invoke());
                        }
                        break;
                    case 4:
                        LogLevel logLevel3 = LogLevel.INFO;
                        LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                            currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) identityManager$aliasCurrentUserIdTo$2$1$invoke$lambda$1$$inlined$log$1.invoke());
                        }
                        break;
                    case 5:
                        LogLevel logLevel4 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                            str = "[Purchases] - " + logLevel4.name();
                            str2 = (String) identityManager$aliasCurrentUserIdTo$2$1$invoke$lambda$1$$inlined$log$1.invoke();
                            currentLogHandler.d(str, str2);
                        }
                        break;
                    case 6:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) identityManager$aliasCurrentUserIdTo$2$1$invoke$lambda$1$$inlined$log$1.invoke(), null);
                        break;
                    case 7:
                        LogLevel logLevel5 = LogLevel.INFO;
                        LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                            currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) identityManager$aliasCurrentUserIdTo$2$1$invoke$lambda$1$$inlined$log$1.invoke());
                        }
                        break;
                    case 8:
                        LogLevel logLevel6 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                            str = "[Purchases] - " + logLevel6.name();
                            str2 = (String) identityManager$aliasCurrentUserIdTo$2$1$invoke$lambda$1$$inlined$log$1.invoke();
                            currentLogHandler.d(str, str2);
                        }
                        break;
                    case 9:
                        LogLevel logLevel7 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                            str = "[Purchases] - " + logLevel7.name();
                            str2 = (String) identityManager$aliasCurrentUserIdTo$2$1$invoke$lambda$1$$inlined$log$1.invoke();
                            currentLogHandler.d(str, str2);
                        }
                        break;
                    case 10:
                        LogLevel logLevel8 = LogLevel.WARN;
                        LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                            currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) identityManager$aliasCurrentUserIdTo$2$1$invoke$lambda$1$$inlined$log$1.invoke());
                        }
                        break;
                    case 11:
                        LogLevel logLevel9 = LogLevel.WARN;
                        LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                            currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) identityManager$aliasCurrentUserIdTo$2$1$invoke$lambda$1$$inlined$log$1.invoke());
                        }
                        break;
                    case 12:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) identityManager$aliasCurrentUserIdTo$2$1$invoke$lambda$1$$inlined$log$1.invoke(), null);
                        break;
                }
                identityManager.offeringsCache.clearCache();
                identityManager.deviceCache.clearCustomerInfoCache(str3);
                identityManager.offlineEntitlementsManager.resetOfflineCustomerInfoCache();
                E e4 = E.f5463a;
            } catch (Throwable th) {
                throw th;
            }
        }
        e eVar = this.$continuation;
        p.a aVar = p.f5487b;
        eVar.resumeWith(p.b(E.f5463a));
    }
}
