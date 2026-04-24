package com.revenuecat.purchases.google.usecase;

import H0.C0314p;
import H0.InterfaceC0311m;
import W2.E;
import X2.AbstractC0769p;
import com.android.billingclient.api.PurchaseHistoryRecord;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.DurationExtensionsKt;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.google.BillingClientParamBuildersKt;
import com.revenuecat.purchases.google.usecase.QueryPurchaseHistoryUseCase;
import com.revenuecat.purchases.strings.PurchaseStrings;
import i3.k;
import i3.o;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import s3.C1779a;

/* JADX INFO: loaded from: classes3.dex */
public final class QueryPurchaseHistoryUseCase extends BillingClientUseCase<List<? extends PurchaseHistoryRecord>> {
    private final k onError;
    private final k onReceive;
    private final QueryPurchaseHistoryUseCaseParams useCaseParams;
    private final k withConnectedClient;

    /* JADX INFO: renamed from: com.revenuecat.purchases.google.usecase.QueryPurchaseHistoryUseCase$executeAsync$1, reason: invalid class name */
    public static final class AnonymousClass1 extends s implements k {
        public AnonymousClass1() {
            super(1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$2$lambda$1(AtomicBoolean hasResponded, QueryPurchaseHistoryUseCase this$0, Date requestStartTime, com.android.billingclient.api.d billingResult, List list) {
            r.f(hasResponded, "$hasResponded");
            r.f(this$0, "this$0");
            r.f(requestStartTime, "$requestStartTime");
            r.f(billingResult, "billingResult");
            if (!hasResponded.getAndSet(true)) {
                this$0.trackGoogleQueryPurchaseHistoryRequestIfNeeded(this$0.useCaseParams.getProductType(), billingResult, requestStartTime);
                BillingClientUseCase.processResult$default(this$0, billingResult, list, null, null, 12, null);
                return;
            }
            LogIntent logIntent = LogIntent.GOOGLE_ERROR;
            QueryPurchaseHistoryUseCase$executeAsync$1$invoke$lambda$2$lambda$1$$inlined$log$1 queryPurchaseHistoryUseCase$executeAsync$1$invoke$lambda$2$lambda$1$$inlined$log$1 = new QueryPurchaseHistoryUseCase$executeAsync$1$invoke$lambda$2$lambda$1$$inlined$log$1(logIntent, billingResult);
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                case 1:
                    LogLevel logLevel = LogLevel.DEBUG;
                    LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        currentLogHandler.d("[Purchases] - " + logLevel.name(), (String) queryPurchaseHistoryUseCase$executeAsync$1$invoke$lambda$2$lambda$1$$inlined$log$1.invoke());
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) queryPurchaseHistoryUseCase$executeAsync$1$invoke$lambda$2$lambda$1$$inlined$log$1.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel2 = LogLevel.WARN;
                    LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) queryPurchaseHistoryUseCase$executeAsync$1$invoke$lambda$2$lambda$1$$inlined$log$1.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel3 = LogLevel.INFO;
                    LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                        currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) queryPurchaseHistoryUseCase$executeAsync$1$invoke$lambda$2$lambda$1$$inlined$log$1.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel4 = LogLevel.DEBUG;
                    LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                        currentLogHandler4.d("[Purchases] - " + logLevel4.name(), (String) queryPurchaseHistoryUseCase$executeAsync$1$invoke$lambda$2$lambda$1$$inlined$log$1.invoke());
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) queryPurchaseHistoryUseCase$executeAsync$1$invoke$lambda$2$lambda$1$$inlined$log$1.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel5 = LogLevel.INFO;
                    LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                        currentLogHandler5.i("[Purchases] - " + logLevel5.name(), (String) queryPurchaseHistoryUseCase$executeAsync$1$invoke$lambda$2$lambda$1$$inlined$log$1.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel6 = LogLevel.DEBUG;
                    LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                        currentLogHandler6.d("[Purchases] - " + logLevel6.name(), (String) queryPurchaseHistoryUseCase$executeAsync$1$invoke$lambda$2$lambda$1$$inlined$log$1.invoke());
                    }
                    break;
                case 9:
                    LogLevel logLevel7 = LogLevel.DEBUG;
                    LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                        currentLogHandler7.d("[Purchases] - " + logLevel7.name(), (String) queryPurchaseHistoryUseCase$executeAsync$1$invoke$lambda$2$lambda$1$$inlined$log$1.invoke());
                    }
                    break;
                case 10:
                    LogLevel logLevel8 = LogLevel.WARN;
                    LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                        currentLogHandler8.w("[Purchases] - " + logLevel8.name(), (String) queryPurchaseHistoryUseCase$executeAsync$1$invoke$lambda$2$lambda$1$$inlined$log$1.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel9 = LogLevel.WARN;
                    LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                        currentLogHandler9.w("[Purchases] - " + logLevel9.name(), (String) queryPurchaseHistoryUseCase$executeAsync$1$invoke$lambda$2$lambda$1$$inlined$log$1.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) queryPurchaseHistoryUseCase$executeAsync$1$invoke$lambda$2$lambda$1$$inlined$log$1.invoke(), null);
                    break;
            }
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((com.android.billingclient.api.a) obj);
            return E.f5463a;
        }

        public final void invoke(com.android.billingclient.api.a invoke) {
            E e4;
            r.f(invoke, "$this$invoke");
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            final Date now = QueryPurchaseHistoryUseCase.this.useCaseParams.getDateProvider().getNow();
            C0314p c0314pBuildQueryPurchaseHistoryParams = BillingClientParamBuildersKt.buildQueryPurchaseHistoryParams(QueryPurchaseHistoryUseCase.this.useCaseParams.getProductType());
            if (c0314pBuildQueryPurchaseHistoryParams != null) {
                final QueryPurchaseHistoryUseCase queryPurchaseHistoryUseCase = QueryPurchaseHistoryUseCase.this;
                invoke.j(c0314pBuildQueryPurchaseHistoryParams, new InterfaceC0311m() { // from class: com.revenuecat.purchases.google.usecase.f
                    @Override // H0.InterfaceC0311m
                    public final void a(com.android.billingclient.api.d dVar, List list) {
                        QueryPurchaseHistoryUseCase.AnonymousClass1.invoke$lambda$2$lambda$1(atomicBoolean, queryPurchaseHistoryUseCase, now, dVar, list);
                    }
                });
                e4 = E.f5463a;
            } else {
                e4 = null;
            }
            if (e4 == null) {
                QueryPurchaseHistoryUseCase queryPurchaseHistoryUseCase2 = QueryPurchaseHistoryUseCase.this;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                String str = String.format(PurchaseStrings.INVALID_PRODUCT_TYPE, Arrays.copyOf(new Object[]{"queryPurchaseHistory"}, 1));
                r.e(str, "format(this, *args)");
                currentLogHandler.e("[Purchases] - ERROR", str, null);
                com.android.billingclient.api.d dVarA = com.android.billingclient.api.d.c().c(5).a();
                r.e(dVarA, "newBuilder()\n           …                 .build()");
                BillingClientUseCase.processResult$default(queryPurchaseHistoryUseCase2, dVarA, null, null, null, 12, null);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QueryPurchaseHistoryUseCase(QueryPurchaseHistoryUseCaseParams useCaseParams, k onReceive, k onError, k withConnectedClient, o executeRequestOnUIThread) {
        super(useCaseParams, onError, executeRequestOnUIThread);
        r.f(useCaseParams, "useCaseParams");
        r.f(onReceive, "onReceive");
        r.f(onError, "onError");
        r.f(withConnectedClient, "withConnectedClient");
        r.f(executeRequestOnUIThread, "executeRequestOnUIThread");
        this.useCaseParams = useCaseParams;
        this.onReceive = onReceive;
        this.onError = onError;
        this.withConnectedClient = withConnectedClient;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void trackGoogleQueryPurchaseHistoryRequestIfNeeded(String str, com.android.billingclient.api.d dVar, Date date) {
        DiagnosticsTracker diagnosticsTrackerIfEnabled = this.useCaseParams.getDiagnosticsTrackerIfEnabled();
        if (diagnosticsTrackerIfEnabled != null) {
            int iB = dVar.b();
            String strA = dVar.a();
            r.e(strA, "billingResult.debugMessage");
            diagnosticsTrackerIfEnabled.m109trackGoogleQueryPurchaseHistoryRequestWn2Vu4Y(str, iB, strA, DurationExtensionsKt.between(C1779a.f14679b, date, this.useCaseParams.getDateProvider().getNow()));
        }
    }

    @Override // com.revenuecat.purchases.google.usecase.BillingClientUseCase
    public void executeAsync() {
        this.withConnectedClient.invoke(new AnonymousClass1());
    }

    @Override // com.revenuecat.purchases.google.usecase.BillingClientUseCase
    public String getErrorMessage() {
        return "Error receiving purchase history";
    }

    public final k getOnError() {
        return this.onError;
    }

    public final k getOnReceive() {
        return this.onReceive;
    }

    public final k getWithConnectedClient() {
        return this.withConnectedClient;
    }

    @Override // com.revenuecat.purchases.google.usecase.BillingClientUseCase
    public void onOk(List<? extends PurchaseHistoryRecord> list) {
        E e4;
        LogHandler currentLogHandler;
        String str;
        Object objInvoke;
        List<? extends PurchaseHistoryRecord> list2 = (list == null || list.isEmpty()) ? null : list;
        if (list2 != null) {
            for (PurchaseHistoryRecord purchaseHistoryRecord : list2) {
                LogIntent logIntent = LogIntent.RC_PURCHASE_SUCCESS;
                QueryPurchaseHistoryUseCase$onOk$lambda$2$$inlined$log$1 queryPurchaseHistoryUseCase$onOk$lambda$2$$inlined$log$1 = new QueryPurchaseHistoryUseCase$onOk$lambda$2$$inlined$log$1(logIntent, purchaseHistoryRecord);
                switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                    case 1:
                        LogLevel logLevel = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                            str = "[Purchases] - " + logLevel.name();
                            objInvoke = queryPurchaseHistoryUseCase$onOk$lambda$2$$inlined$log$1.invoke();
                        }
                        break;
                    case 2:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) queryPurchaseHistoryUseCase$onOk$lambda$2$$inlined$log$1.invoke(), null);
                        continue;
                    case 3:
                        LogLevel logLevel2 = LogLevel.WARN;
                        LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                            currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) queryPurchaseHistoryUseCase$onOk$lambda$2$$inlined$log$1.invoke());
                        } else {
                            continue;
                        }
                        break;
                    case 4:
                        LogLevel logLevel3 = LogLevel.INFO;
                        LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                            currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) queryPurchaseHistoryUseCase$onOk$lambda$2$$inlined$log$1.invoke());
                        } else {
                            continue;
                        }
                        break;
                    case 5:
                        LogLevel logLevel4 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                            str = "[Purchases] - " + logLevel4.name();
                            objInvoke = queryPurchaseHistoryUseCase$onOk$lambda$2$$inlined$log$1.invoke();
                        }
                        break;
                    case 6:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) queryPurchaseHistoryUseCase$onOk$lambda$2$$inlined$log$1.invoke(), null);
                        continue;
                    case 7:
                        LogLevel logLevel5 = LogLevel.INFO;
                        LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                            currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) queryPurchaseHistoryUseCase$onOk$lambda$2$$inlined$log$1.invoke());
                        } else {
                            continue;
                        }
                        break;
                    case 8:
                        LogLevel logLevel6 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                            str = "[Purchases] - " + logLevel6.name();
                            objInvoke = queryPurchaseHistoryUseCase$onOk$lambda$2$$inlined$log$1.invoke();
                        }
                        break;
                    case 9:
                        LogLevel logLevel7 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                            str = "[Purchases] - " + logLevel7.name();
                            objInvoke = queryPurchaseHistoryUseCase$onOk$lambda$2$$inlined$log$1.invoke();
                        }
                        break;
                    case 10:
                        LogLevel logLevel8 = LogLevel.WARN;
                        LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                            currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) queryPurchaseHistoryUseCase$onOk$lambda$2$$inlined$log$1.invoke());
                        } else {
                            continue;
                        }
                        break;
                    case 11:
                        LogLevel logLevel9 = LogLevel.WARN;
                        LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                            currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) queryPurchaseHistoryUseCase$onOk$lambda$2$$inlined$log$1.invoke());
                        } else {
                            continue;
                        }
                        break;
                    case 12:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) queryPurchaseHistoryUseCase$onOk$lambda$2$$inlined$log$1.invoke(), null);
                        continue;
                }
                currentLogHandler.d(str, (String) objInvoke);
            }
            e4 = E.f5463a;
        } else {
            e4 = null;
        }
        if (e4 == null) {
            LogIntent logIntent2 = LogIntent.DEBUG;
            QueryPurchaseHistoryUseCase$onOk$$inlined$log$1 queryPurchaseHistoryUseCase$onOk$$inlined$log$1 = new QueryPurchaseHistoryUseCase$onOk$$inlined$log$1(logIntent2);
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent2.ordinal()]) {
                case 1:
                    LogLevel logLevel10 = LogLevel.DEBUG;
                    LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                        currentLogHandler7.d("[Purchases] - " + logLevel10.name(), (String) queryPurchaseHistoryUseCase$onOk$$inlined$log$1.invoke());
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) queryPurchaseHistoryUseCase$onOk$$inlined$log$1.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel11 = LogLevel.WARN;
                    LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                        currentLogHandler8.w("[Purchases] - " + logLevel11.name(), (String) queryPurchaseHistoryUseCase$onOk$$inlined$log$1.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel12 = LogLevel.INFO;
                    LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel12) <= 0) {
                        currentLogHandler9.i("[Purchases] - " + logLevel12.name(), (String) queryPurchaseHistoryUseCase$onOk$$inlined$log$1.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel13 = LogLevel.DEBUG;
                    LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel13) <= 0) {
                        currentLogHandler10.d("[Purchases] - " + logLevel13.name(), (String) queryPurchaseHistoryUseCase$onOk$$inlined$log$1.invoke());
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) queryPurchaseHistoryUseCase$onOk$$inlined$log$1.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel14 = LogLevel.INFO;
                    LogHandler currentLogHandler11 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel14) <= 0) {
                        currentLogHandler11.i("[Purchases] - " + logLevel14.name(), (String) queryPurchaseHistoryUseCase$onOk$$inlined$log$1.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel15 = LogLevel.DEBUG;
                    LogHandler currentLogHandler12 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                        currentLogHandler12.d("[Purchases] - " + logLevel15.name(), (String) queryPurchaseHistoryUseCase$onOk$$inlined$log$1.invoke());
                    }
                    break;
                case 9:
                    LogLevel logLevel16 = LogLevel.DEBUG;
                    LogHandler currentLogHandler13 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel16) <= 0) {
                        currentLogHandler13.d("[Purchases] - " + logLevel16.name(), (String) queryPurchaseHistoryUseCase$onOk$$inlined$log$1.invoke());
                    }
                    break;
                case 10:
                    LogLevel logLevel17 = LogLevel.WARN;
                    LogHandler currentLogHandler14 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                        currentLogHandler14.w("[Purchases] - " + logLevel17.name(), (String) queryPurchaseHistoryUseCase$onOk$$inlined$log$1.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel18 = LogLevel.WARN;
                    LogHandler currentLogHandler15 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel18) <= 0) {
                        currentLogHandler15.w("[Purchases] - " + logLevel18.name(), (String) queryPurchaseHistoryUseCase$onOk$$inlined$log$1.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) queryPurchaseHistoryUseCase$onOk$$inlined$log$1.invoke(), null);
                    break;
            }
        }
        k kVar = this.onReceive;
        if (list == null) {
            list = AbstractC0769p.g();
        }
        kVar.invoke(list);
    }
}
