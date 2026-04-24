package com.revenuecat.purchases;

import W2.E;
import X2.AbstractC0769p;
import com.revenuecat.purchases.SyncPendingPurchaseResult;
import com.revenuecat.purchases.common.AppConfig;
import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.identity.IdentityManager;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.utils.Result;
import i3.k;
import i3.o;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class PostPendingTransactionsHelper {
    private final AppConfig appConfig;
    private final BillingAbstract billing;
    private final DeviceCache deviceCache;
    private final Dispatcher dispatcher;
    private final IdentityManager identityManager;
    private final PostTransactionWithProductDetailsHelper postTransactionWithProductDetailsHelper;

    /* JADX INFO: renamed from: com.revenuecat.purchases.PostPendingTransactionsHelper$postTransactionsWithCompletion$2, reason: invalid class name */
    public static final class AnonymousClass2 extends s implements o {
        final /* synthetic */ k $onError;
        final /* synthetic */ k $onSuccess;
        final /* synthetic */ List<Result<CustomerInfo, PurchasesError>> $results;
        final /* synthetic */ List<StoreTransaction> $transactionsToSync;
        final /* synthetic */ PostPendingTransactionsHelper this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(List<Result<CustomerInfo, PurchasesError>> list, PostPendingTransactionsHelper postPendingTransactionsHelper, List<StoreTransaction> list2, k kVar, k kVar2) {
            super(2);
            this.$results = list;
            this.this$0 = postPendingTransactionsHelper;
            this.$transactionsToSync = list2;
            this.$onError = kVar;
            this.$onSuccess = kVar2;
        }

        @Override // i3.o
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((StoreTransaction) obj, (CustomerInfo) obj2);
            return E.f5463a;
        }

        public final void invoke(StoreTransaction storeTransaction, CustomerInfo customerInfo) {
            r.f(storeTransaction, "<anonymous parameter 0>");
            r.f(customerInfo, "customerInfo");
            this.$results.add(new Result.Success(customerInfo));
            this.this$0.callCompletionFromResults(this.$transactionsToSync, this.$results, this.$onError, this.$onSuccess);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.PostPendingTransactionsHelper$postTransactionsWithCompletion$3, reason: invalid class name */
    public static final class AnonymousClass3 extends s implements o {
        final /* synthetic */ k $onError;
        final /* synthetic */ k $onSuccess;
        final /* synthetic */ List<Result<CustomerInfo, PurchasesError>> $results;
        final /* synthetic */ List<StoreTransaction> $transactionsToSync;
        final /* synthetic */ PostPendingTransactionsHelper this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(List<Result<CustomerInfo, PurchasesError>> list, PostPendingTransactionsHelper postPendingTransactionsHelper, List<StoreTransaction> list2, k kVar, k kVar2) {
            super(2);
            this.$results = list;
            this.this$0 = postPendingTransactionsHelper;
            this.$transactionsToSync = list2;
            this.$onError = kVar;
            this.$onSuccess = kVar2;
        }

        @Override // i3.o
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((StoreTransaction) obj, (PurchasesError) obj2);
            return E.f5463a;
        }

        public final void invoke(StoreTransaction storeTransaction, PurchasesError purchasesError) {
            r.f(storeTransaction, "<anonymous parameter 0>");
            r.f(purchasesError, "purchasesError");
            this.$results.add(new Result.Error(purchasesError));
            this.this$0.callCompletionFromResults(this.$transactionsToSync, this.$results, this.$onError, this.$onSuccess);
        }
    }

    public PostPendingTransactionsHelper(AppConfig appConfig, DeviceCache deviceCache, BillingAbstract billing, Dispatcher dispatcher, IdentityManager identityManager, PostTransactionWithProductDetailsHelper postTransactionWithProductDetailsHelper) {
        r.f(appConfig, "appConfig");
        r.f(deviceCache, "deviceCache");
        r.f(billing, "billing");
        r.f(dispatcher, "dispatcher");
        r.f(identityManager, "identityManager");
        r.f(postTransactionWithProductDetailsHelper, "postTransactionWithProductDetailsHelper");
        this.appConfig = appConfig;
        this.deviceCache = deviceCache;
        this.billing = billing;
        this.dispatcher = dispatcher;
        this.identityManager = identityManager;
        this.postTransactionWithProductDetailsHelper = postTransactionWithProductDetailsHelper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void callCompletionFromResults(List<StoreTransaction> list, List<? extends Result<CustomerInfo, PurchasesError>> list2, k kVar, k kVar2) {
        if (list.size() == list2.size()) {
            int i4 = 0;
            for (Object obj : list2) {
                int i5 = i4 + 1;
                if (i4 < 0) {
                    AbstractC0769p.p();
                }
                Result result = (Result) obj;
                if (result instanceof Result.Error) {
                    if (kVar != null) {
                        kVar.invoke(((Result.Error) result).getValue());
                        return;
                    }
                    return;
                } else {
                    if (i4 == list2.size() - 1 && kVar2 != null) {
                        r.d(result, "null cannot be cast to non-null type com.revenuecat.purchases.utils.Result.Success<com.revenuecat.purchases.CustomerInfo>");
                        kVar2.invoke(((Result.Success) result).getValue());
                    }
                    i4 = i5;
                }
            }
        }
    }

    public static /* synthetic */ void callCompletionFromResults$default(PostPendingTransactionsHelper postPendingTransactionsHelper, List list, List list2, k kVar, k kVar2, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            kVar = null;
        }
        if ((i4 & 8) != 0) {
            kVar2 = null;
        }
        postPendingTransactionsHelper.callCompletionFromResults(list, list2, kVar, kVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void postTransactionsWithCompletion(List<StoreTransaction> list, boolean z4, String str, Function0 function0, k kVar, k kVar2) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        if (!list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            this.postTransactionWithProductDetailsHelper.postTransactions(list, z4, str, PostReceiptInitiationSource.UNSYNCED_ACTIVE_PURCHASES, new AnonymousClass2(arrayList, this, list, kVar, kVar2), new AnonymousClass3(arrayList, this, list, kVar, kVar2));
            return;
        }
        LogIntent logIntent = LogIntent.DEBUG;
        PostPendingTransactionsHelper$postTransactionsWithCompletion$$inlined$log$1 postPendingTransactionsHelper$postTransactionsWithCompletion$$inlined$log$1 = new PostPendingTransactionsHelper$postTransactionsWithCompletion$$inlined$log$1(logIntent);
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str2 = "[Purchases] - " + logLevel.name();
                    str3 = (String) postPendingTransactionsHelper$postTransactionsWithCompletion$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) postPendingTransactionsHelper$postTransactionsWithCompletion$$inlined$log$1.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) postPendingTransactionsHelper$postTransactionsWithCompletion$$inlined$log$1.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) postPendingTransactionsHelper$postTransactionsWithCompletion$$inlined$log$1.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str2 = "[Purchases] - " + logLevel4.name();
                    str3 = (String) postPendingTransactionsHelper$postTransactionsWithCompletion$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) postPendingTransactionsHelper$postTransactionsWithCompletion$$inlined$log$1.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) postPendingTransactionsHelper$postTransactionsWithCompletion$$inlined$log$1.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str2 = "[Purchases] - " + logLevel6.name();
                    str3 = (String) postPendingTransactionsHelper$postTransactionsWithCompletion$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str2 = "[Purchases] - " + logLevel7.name();
                    str3 = (String) postPendingTransactionsHelper$postTransactionsWithCompletion$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) postPendingTransactionsHelper$postTransactionsWithCompletion$$inlined$log$1.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) postPendingTransactionsHelper$postTransactionsWithCompletion$$inlined$log$1.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) postPendingTransactionsHelper$postTransactionsWithCompletion$$inlined$log$1.invoke(), null);
                break;
        }
        function0.invoke();
    }

    public static /* synthetic */ void syncPendingPurchaseQueue$default(PostPendingTransactionsHelper postPendingTransactionsHelper, boolean z4, k kVar, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            kVar = null;
        }
        postPendingTransactionsHelper.syncPendingPurchaseQueue(z4, kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void syncPendingPurchaseQueue$lambda$2(PostPendingTransactionsHelper this$0, String appUserID, boolean z4, k kVar) {
        r.f(this$0, "this$0");
        r.f(appUserID, "$appUserID");
        this$0.billing.queryPurchases(appUserID, new PostPendingTransactionsHelper$syncPendingPurchaseQueue$3$1(this$0, z4, appUserID, kVar), new PostPendingTransactionsHelper$syncPendingPurchaseQueue$3$2(kVar));
    }

    public final void syncPendingPurchaseQueue(final boolean z4, final k kVar) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        if (this.appConfig.getDangerousSettings().getAutoSyncPurchases()) {
            LogIntent logIntent = LogIntent.DEBUG;
            PostPendingTransactionsHelper$syncPendingPurchaseQueue$$inlined$log$2 postPendingTransactionsHelper$syncPendingPurchaseQueue$$inlined$log$2 = new PostPendingTransactionsHelper$syncPendingPurchaseQueue$$inlined$log$2(logIntent);
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                case 1:
                    LogLevel logLevel = LogLevel.DEBUG;
                    LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        currentLogHandler2.d("[Purchases] - " + logLevel.name(), (String) postPendingTransactionsHelper$syncPendingPurchaseQueue$$inlined$log$2.invoke());
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) postPendingTransactionsHelper$syncPendingPurchaseQueue$$inlined$log$2.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel2 = LogLevel.WARN;
                    LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        currentLogHandler3.w("[Purchases] - " + logLevel2.name(), (String) postPendingTransactionsHelper$syncPendingPurchaseQueue$$inlined$log$2.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel3 = LogLevel.INFO;
                    LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                        currentLogHandler4.i("[Purchases] - " + logLevel3.name(), (String) postPendingTransactionsHelper$syncPendingPurchaseQueue$$inlined$log$2.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel4 = LogLevel.DEBUG;
                    LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                        currentLogHandler5.d("[Purchases] - " + logLevel4.name(), (String) postPendingTransactionsHelper$syncPendingPurchaseQueue$$inlined$log$2.invoke());
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) postPendingTransactionsHelper$syncPendingPurchaseQueue$$inlined$log$2.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel5 = LogLevel.INFO;
                    LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                        currentLogHandler6.i("[Purchases] - " + logLevel5.name(), (String) postPendingTransactionsHelper$syncPendingPurchaseQueue$$inlined$log$2.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel6 = LogLevel.DEBUG;
                    LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                        currentLogHandler7.d("[Purchases] - " + logLevel6.name(), (String) postPendingTransactionsHelper$syncPendingPurchaseQueue$$inlined$log$2.invoke());
                    }
                    break;
                case 9:
                    LogLevel logLevel7 = LogLevel.DEBUG;
                    LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                        currentLogHandler8.d("[Purchases] - " + logLevel7.name(), (String) postPendingTransactionsHelper$syncPendingPurchaseQueue$$inlined$log$2.invoke());
                    }
                    break;
                case 10:
                    LogLevel logLevel8 = LogLevel.WARN;
                    LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                        currentLogHandler9.w("[Purchases] - " + logLevel8.name(), (String) postPendingTransactionsHelper$syncPendingPurchaseQueue$$inlined$log$2.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel9 = LogLevel.WARN;
                    LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                        currentLogHandler10.w("[Purchases] - " + logLevel9.name(), (String) postPendingTransactionsHelper$syncPendingPurchaseQueue$$inlined$log$2.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) postPendingTransactionsHelper$syncPendingPurchaseQueue$$inlined$log$2.invoke(), null);
                    break;
            }
            final String currentAppUserID = this.identityManager.getCurrentAppUserID();
            Dispatcher.enqueue$default(this.dispatcher, new Runnable() { // from class: com.revenuecat.purchases.c
                @Override // java.lang.Runnable
                public final void run() {
                    PostPendingTransactionsHelper.syncPendingPurchaseQueue$lambda$2(this.f11291a, currentAppUserID, z4, kVar);
                }
            }, null, 2, null);
            return;
        }
        LogIntent logIntent2 = LogIntent.DEBUG;
        PostPendingTransactionsHelper$syncPendingPurchaseQueue$$inlined$log$1 postPendingTransactionsHelper$syncPendingPurchaseQueue$$inlined$log$1 = new PostPendingTransactionsHelper$syncPendingPurchaseQueue$$inlined$log$1(logIntent2);
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent2.ordinal()]) {
            case 1:
                LogLevel logLevel10 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    str = "[Purchases] - " + logLevel10.name();
                    str2 = (String) postPendingTransactionsHelper$syncPendingPurchaseQueue$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) postPendingTransactionsHelper$syncPendingPurchaseQueue$$inlined$log$1.invoke(), null);
                break;
            case 3:
                LogLevel logLevel11 = LogLevel.WARN;
                LogHandler currentLogHandler11 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                    currentLogHandler11.w("[Purchases] - " + logLevel11.name(), (String) postPendingTransactionsHelper$syncPendingPurchaseQueue$$inlined$log$1.invoke());
                }
                break;
            case 4:
                LogLevel logLevel12 = LogLevel.INFO;
                LogHandler currentLogHandler12 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel12) <= 0) {
                    currentLogHandler12.i("[Purchases] - " + logLevel12.name(), (String) postPendingTransactionsHelper$syncPendingPurchaseQueue$$inlined$log$1.invoke());
                }
                break;
            case 5:
                LogLevel logLevel13 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel13) <= 0) {
                    str = "[Purchases] - " + logLevel13.name();
                    str2 = (String) postPendingTransactionsHelper$syncPendingPurchaseQueue$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) postPendingTransactionsHelper$syncPendingPurchaseQueue$$inlined$log$1.invoke(), null);
                break;
            case 7:
                LogLevel logLevel14 = LogLevel.INFO;
                LogHandler currentLogHandler13 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel14) <= 0) {
                    currentLogHandler13.i("[Purchases] - " + logLevel14.name(), (String) postPendingTransactionsHelper$syncPendingPurchaseQueue$$inlined$log$1.invoke());
                }
                break;
            case 8:
                LogLevel logLevel15 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                    str = "[Purchases] - " + logLevel15.name();
                    str2 = (String) postPendingTransactionsHelper$syncPendingPurchaseQueue$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 9:
                LogLevel logLevel16 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel16) <= 0) {
                    str = "[Purchases] - " + logLevel16.name();
                    str2 = (String) postPendingTransactionsHelper$syncPendingPurchaseQueue$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 10:
                LogLevel logLevel17 = LogLevel.WARN;
                LogHandler currentLogHandler14 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                    currentLogHandler14.w("[Purchases] - " + logLevel17.name(), (String) postPendingTransactionsHelper$syncPendingPurchaseQueue$$inlined$log$1.invoke());
                }
                break;
            case 11:
                LogLevel logLevel18 = LogLevel.WARN;
                LogHandler currentLogHandler15 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel18) <= 0) {
                    currentLogHandler15.w("[Purchases] - " + logLevel18.name(), (String) postPendingTransactionsHelper$syncPendingPurchaseQueue$$inlined$log$1.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) postPendingTransactionsHelper$syncPendingPurchaseQueue$$inlined$log$1.invoke(), null);
                break;
        }
        if (kVar != null) {
            kVar.invoke(SyncPendingPurchaseResult.AutoSyncDisabled.INSTANCE);
        }
    }
}
