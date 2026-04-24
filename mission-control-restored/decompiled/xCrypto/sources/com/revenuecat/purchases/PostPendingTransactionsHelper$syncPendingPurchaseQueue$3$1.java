package com.revenuecat.purchases;

import W2.E;
import com.revenuecat.purchases.SyncPendingPurchaseResult;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.models.StoreTransaction;
import i3.k;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class PostPendingTransactionsHelper$syncPendingPurchaseQueue$3$1 extends s implements k {
    final /* synthetic */ boolean $allowSharingPlayStoreAccount;
    final /* synthetic */ String $appUserID;
    final /* synthetic */ k $callback;
    final /* synthetic */ PostPendingTransactionsHelper this$0;

    /* JADX INFO: renamed from: com.revenuecat.purchases.PostPendingTransactionsHelper$syncPendingPurchaseQueue$3$1$2, reason: invalid class name */
    public static final class AnonymousClass2 extends s implements Function0 {
        final /* synthetic */ k $callback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(k kVar) {
            super(0);
            this.$callback = kVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m69invoke();
            return E.f5463a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m69invoke() {
            k kVar = this.$callback;
            if (kVar != null) {
                kVar.invoke(SyncPendingPurchaseResult.NoPendingPurchasesToSync.INSTANCE);
            }
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.PostPendingTransactionsHelper$syncPendingPurchaseQueue$3$1$3, reason: invalid class name */
    public static final class AnonymousClass3 extends s implements k {
        final /* synthetic */ k $callback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(k kVar) {
            super(1);
            this.$callback = kVar;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((PurchasesError) obj);
            return E.f5463a;
        }

        public final void invoke(PurchasesError error) {
            r.f(error, "error");
            k kVar = this.$callback;
            if (kVar != null) {
                kVar.invoke(new SyncPendingPurchaseResult.Error(error));
            }
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.PostPendingTransactionsHelper$syncPendingPurchaseQueue$3$1$4, reason: invalid class name */
    public static final class AnonymousClass4 extends s implements k {
        final /* synthetic */ k $callback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(k kVar) {
            super(1);
            this.$callback = kVar;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((CustomerInfo) obj);
            return E.f5463a;
        }

        public final void invoke(CustomerInfo customerInfo) {
            r.f(customerInfo, "customerInfo");
            k kVar = this.$callback;
            if (kVar != null) {
                kVar.invoke(new SyncPendingPurchaseResult.Success(customerInfo));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostPendingTransactionsHelper$syncPendingPurchaseQueue$3$1(PostPendingTransactionsHelper postPendingTransactionsHelper, boolean z4, String str, k kVar) {
        super(1);
        this.this$0 = postPendingTransactionsHelper;
        this.$allowSharingPlayStoreAccount = z4;
        this.$appUserID = str;
        this.$callback = kVar;
    }

    @Override // i3.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Map<String, StoreTransaction>) obj);
        return E.f5463a;
    }

    public final void invoke(Map<String, StoreTransaction> purchasesByHashedToken) {
        LogHandler currentLogHandler;
        String str;
        Object objInvoke;
        r.f(purchasesByHashedToken, "purchasesByHashedToken");
        for (Map.Entry<String, StoreTransaction> entry : purchasesByHashedToken.entrySet()) {
            String key = entry.getKey();
            StoreTransaction value = entry.getValue();
            LogIntent logIntent = LogIntent.DEBUG;
            PostPendingTransactionsHelper$syncPendingPurchaseQueue$3$1$invoke$lambda$1$$inlined$log$1 postPendingTransactionsHelper$syncPendingPurchaseQueue$3$1$invoke$lambda$1$$inlined$log$1 = new PostPendingTransactionsHelper$syncPendingPurchaseQueue$3$1$invoke$lambda$1$$inlined$log$1(logIntent, value, key);
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                case 1:
                    LogLevel logLevel = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        str = "[Purchases] - " + logLevel.name();
                        objInvoke = postPendingTransactionsHelper$syncPendingPurchaseQueue$3$1$invoke$lambda$1$$inlined$log$1.invoke();
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) postPendingTransactionsHelper$syncPendingPurchaseQueue$3$1$invoke$lambda$1$$inlined$log$1.invoke(), null);
                    continue;
                case 3:
                    LogLevel logLevel2 = LogLevel.WARN;
                    LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) postPendingTransactionsHelper$syncPendingPurchaseQueue$3$1$invoke$lambda$1$$inlined$log$1.invoke());
                    } else {
                        continue;
                    }
                    break;
                case 4:
                    LogLevel logLevel3 = LogLevel.INFO;
                    LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                        currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) postPendingTransactionsHelper$syncPendingPurchaseQueue$3$1$invoke$lambda$1$$inlined$log$1.invoke());
                    } else {
                        continue;
                    }
                    break;
                case 5:
                    LogLevel logLevel4 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                        str = "[Purchases] - " + logLevel4.name();
                        objInvoke = postPendingTransactionsHelper$syncPendingPurchaseQueue$3$1$invoke$lambda$1$$inlined$log$1.invoke();
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) postPendingTransactionsHelper$syncPendingPurchaseQueue$3$1$invoke$lambda$1$$inlined$log$1.invoke(), null);
                    continue;
                case 7:
                    LogLevel logLevel5 = LogLevel.INFO;
                    LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                        currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) postPendingTransactionsHelper$syncPendingPurchaseQueue$3$1$invoke$lambda$1$$inlined$log$1.invoke());
                    } else {
                        continue;
                    }
                    break;
                case 8:
                    LogLevel logLevel6 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                        str = "[Purchases] - " + logLevel6.name();
                        objInvoke = postPendingTransactionsHelper$syncPendingPurchaseQueue$3$1$invoke$lambda$1$$inlined$log$1.invoke();
                    }
                    break;
                case 9:
                    LogLevel logLevel7 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                        str = "[Purchases] - " + logLevel7.name();
                        objInvoke = postPendingTransactionsHelper$syncPendingPurchaseQueue$3$1$invoke$lambda$1$$inlined$log$1.invoke();
                    }
                    break;
                case 10:
                    LogLevel logLevel8 = LogLevel.WARN;
                    LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                        currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) postPendingTransactionsHelper$syncPendingPurchaseQueue$3$1$invoke$lambda$1$$inlined$log$1.invoke());
                    } else {
                        continue;
                    }
                    break;
                case 11:
                    LogLevel logLevel9 = LogLevel.WARN;
                    LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                        currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) postPendingTransactionsHelper$syncPendingPurchaseQueue$3$1$invoke$lambda$1$$inlined$log$1.invoke());
                    } else {
                        continue;
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) postPendingTransactionsHelper$syncPendingPurchaseQueue$3$1$invoke$lambda$1$$inlined$log$1.invoke(), null);
                    continue;
            }
            currentLogHandler.d(str, (String) objInvoke);
        }
        this.this$0.deviceCache.cleanPreviouslySentTokens(purchasesByHashedToken.keySet());
        this.this$0.postTransactionsWithCompletion(this.this$0.deviceCache.getActivePurchasesNotInCache(purchasesByHashedToken), this.$allowSharingPlayStoreAccount, this.$appUserID, new AnonymousClass2(this.$callback), new AnonymousClass3(this.$callback), new AnonymousClass4(this.$callback));
    }
}
