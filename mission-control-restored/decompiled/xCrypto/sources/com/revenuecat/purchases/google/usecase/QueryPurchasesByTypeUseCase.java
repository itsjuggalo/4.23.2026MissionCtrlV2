package com.revenuecat.purchases.google.usecase;

import H0.C0315q;
import H0.InterfaceC0312n;
import W2.E;
import W2.t;
import X2.AbstractC0770q;
import X2.K;
import X2.L;
import X2.u;
import com.android.billingclient.api.Purchase;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.DurationExtensionsKt;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.UtilsKt;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.google.BillingClientParamBuildersKt;
import com.revenuecat.purchases.google.ProductTypeConversionsKt;
import com.revenuecat.purchases.google.StoreTransactionConversionsKt;
import com.revenuecat.purchases.google.usecase.QueryPurchasesByTypeUseCase;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.strings.PurchaseStrings;
import i3.k;
import i3.o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import o3.AbstractC1681l;
import s3.C1779a;

/* JADX INFO: loaded from: classes3.dex */
public final class QueryPurchasesByTypeUseCase extends BillingClientUseCase<Map<String, ? extends StoreTransaction>> {
    private final k onError;
    private final k onSuccess;
    private final QueryPurchasesByTypeUseCaseParams useCaseParams;
    private final k withConnectedClient;

    /* JADX INFO: renamed from: com.revenuecat.purchases.google.usecase.QueryPurchasesByTypeUseCase$executeAsync$1, reason: invalid class name */
    public static final class AnonymousClass1 extends s implements k {
        public AnonymousClass1() {
            super(1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$1$lambda$0(QueryPurchasesByTypeUseCase this$0, com.android.billingclient.api.d result, List purchases) {
            r.f(this$0, "this$0");
            r.f(result, "result");
            r.f(purchases, "purchases");
            BillingClientUseCase.processResult$default(this$0, result, this$0.toMapOfGooglePurchaseWrapper(purchases, this$0.useCaseParams.getProductType()), null, null, 12, null);
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((com.android.billingclient.api.a) obj);
            return E.f5463a;
        }

        public final void invoke(com.android.billingclient.api.a invoke) {
            E e4;
            r.f(invoke, "$this$invoke");
            C0315q c0315qBuildQueryPurchasesParams = BillingClientParamBuildersKt.buildQueryPurchasesParams(QueryPurchasesByTypeUseCase.this.useCaseParams.getProductType());
            if (c0315qBuildQueryPurchasesParams != null) {
                final QueryPurchasesByTypeUseCase queryPurchasesByTypeUseCase = QueryPurchasesByTypeUseCase.this;
                queryPurchasesByTypeUseCase.queryPurchasesAsyncWithTrackingEnsuringOneResponse(invoke, queryPurchasesByTypeUseCase.useCaseParams.getProductType(), c0315qBuildQueryPurchasesParams, new InterfaceC0312n() { // from class: com.revenuecat.purchases.google.usecase.h
                    @Override // H0.InterfaceC0312n
                    public final void a(com.android.billingclient.api.d dVar, List list) {
                        QueryPurchasesByTypeUseCase.AnonymousClass1.invoke$lambda$1$lambda$0(queryPurchasesByTypeUseCase, dVar, list);
                    }
                });
                e4 = E.f5463a;
            } else {
                e4 = null;
            }
            if (e4 == null) {
                QueryPurchasesByTypeUseCase queryPurchasesByTypeUseCase2 = QueryPurchasesByTypeUseCase.this;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                String str = String.format(PurchaseStrings.INVALID_PRODUCT_TYPE, Arrays.copyOf(new Object[]{"queryPurchasesByType"}, 1));
                r.e(str, "format(this, *args)");
                currentLogHandler.e("[Purchases] - ERROR", str, null);
                com.android.billingclient.api.d dVarA = com.android.billingclient.api.d.c().c(5).a();
                r.e(dVarA, "newBuilder()\n           …                 .build()");
                BillingClientUseCase.processResult$default(queryPurchasesByTypeUseCase2, dVarA, L.e(), null, null, 12, null);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QueryPurchasesByTypeUseCase(QueryPurchasesByTypeUseCaseParams useCaseParams, k onSuccess, k onError, k withConnectedClient, o executeRequestOnUIThread) {
        super(useCaseParams, onError, executeRequestOnUIThread);
        r.f(useCaseParams, "useCaseParams");
        r.f(onSuccess, "onSuccess");
        r.f(onError, "onError");
        r.f(withConnectedClient, "withConnectedClient");
        r.f(executeRequestOnUIThread, "executeRequestOnUIThread");
        this.useCaseParams = useCaseParams;
        this.onSuccess = onSuccess;
        this.onError = onError;
        this.withConnectedClient = withConnectedClient;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void queryPurchasesAsyncWithTrackingEnsuringOneResponse(com.android.billingclient.api.a aVar, final String str, C0315q c0315q, final InterfaceC0312n interfaceC0312n) {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final Date now = this.useCaseParams.getDateProvider().getNow();
        aVar.k(c0315q, new InterfaceC0312n() { // from class: com.revenuecat.purchases.google.usecase.g
            @Override // H0.InterfaceC0312n
            public final void a(com.android.billingclient.api.d dVar, List list) {
                QueryPurchasesByTypeUseCase.queryPurchasesAsyncWithTrackingEnsuringOneResponse$lambda$2(atomicBoolean, this, str, now, interfaceC0312n, dVar, list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void queryPurchasesAsyncWithTrackingEnsuringOneResponse$lambda$2(AtomicBoolean hasResponded, QueryPurchasesByTypeUseCase this$0, String productType, Date requestStartTime, InterfaceC0312n listener, com.android.billingclient.api.d billingResult, List purchases) {
        r.f(hasResponded, "$hasResponded");
        r.f(this$0, "this$0");
        r.f(productType, "$productType");
        r.f(requestStartTime, "$requestStartTime");
        r.f(listener, "$listener");
        r.f(billingResult, "billingResult");
        r.f(purchases, "purchases");
        if (!hasResponded.getAndSet(true)) {
            ArrayList arrayList = new ArrayList();
            Iterator it = purchases.iterator();
            while (it.hasNext()) {
                List listC = ((Purchase) it.next()).c();
                r.e(listC, "it.products");
                u.t(arrayList, listC);
            }
            this$0.trackGoogleQueryPurchasesRequestIfNeeded(productType, arrayList, billingResult, requestStartTime);
            listener.a(billingResult, purchases);
            return;
        }
        LogIntent logIntent = LogIntent.GOOGLE_ERROR;
        QueryPurchasesByTypeUseCase$queryPurchasesAsyncWithTrackingEnsuringOneResponse$lambda$2$$inlined$log$1 queryPurchasesByTypeUseCase$queryPurchasesAsyncWithTrackingEnsuringOneResponse$lambda$2$$inlined$log$1 = new QueryPurchasesByTypeUseCase$queryPurchasesAsyncWithTrackingEnsuringOneResponse$lambda$2$$inlined$log$1(logIntent, billingResult);
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler.d("[Purchases] - " + logLevel.name(), (String) queryPurchasesByTypeUseCase$queryPurchasesAsyncWithTrackingEnsuringOneResponse$lambda$2$$inlined$log$1.invoke());
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) queryPurchasesByTypeUseCase$queryPurchasesAsyncWithTrackingEnsuringOneResponse$lambda$2$$inlined$log$1.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) queryPurchasesByTypeUseCase$queryPurchasesAsyncWithTrackingEnsuringOneResponse$lambda$2$$inlined$log$1.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) queryPurchasesByTypeUseCase$queryPurchasesAsyncWithTrackingEnsuringOneResponse$lambda$2$$inlined$log$1.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    currentLogHandler4.d("[Purchases] - " + logLevel4.name(), (String) queryPurchasesByTypeUseCase$queryPurchasesAsyncWithTrackingEnsuringOneResponse$lambda$2$$inlined$log$1.invoke());
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) queryPurchasesByTypeUseCase$queryPurchasesAsyncWithTrackingEnsuringOneResponse$lambda$2$$inlined$log$1.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler5.i("[Purchases] - " + logLevel5.name(), (String) queryPurchasesByTypeUseCase$queryPurchasesAsyncWithTrackingEnsuringOneResponse$lambda$2$$inlined$log$1.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    currentLogHandler6.d("[Purchases] - " + logLevel6.name(), (String) queryPurchasesByTypeUseCase$queryPurchasesAsyncWithTrackingEnsuringOneResponse$lambda$2$$inlined$log$1.invoke());
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    currentLogHandler7.d("[Purchases] - " + logLevel7.name(), (String) queryPurchasesByTypeUseCase$queryPurchasesAsyncWithTrackingEnsuringOneResponse$lambda$2$$inlined$log$1.invoke());
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler8.w("[Purchases] - " + logLevel8.name(), (String) queryPurchasesByTypeUseCase$queryPurchasesAsyncWithTrackingEnsuringOneResponse$lambda$2$$inlined$log$1.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler9.w("[Purchases] - " + logLevel9.name(), (String) queryPurchasesByTypeUseCase$queryPurchasesAsyncWithTrackingEnsuringOneResponse$lambda$2$$inlined$log$1.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) queryPurchasesByTypeUseCase$queryPurchasesAsyncWithTrackingEnsuringOneResponse$lambda$2$$inlined$log$1.invoke(), null);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, StoreTransaction> toMapOfGooglePurchaseWrapper(List<? extends Purchase> list, String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(AbstractC1681l.b(K.b(AbstractC0770q.q(list, 10)), 16));
        for (Purchase purchase : list) {
            String strF = purchase.f();
            r.e(strF, "purchase.purchaseToken");
            W2.o oVarA = t.a(UtilsKt.sha1(strF), StoreTransactionConversionsKt.toStoreTransaction$default(purchase, ProductTypeConversionsKt.toRevenueCatProductType(str), null, null, null, 14, null));
            linkedHashMap.put(oVarA.c(), oVarA.d());
        }
        return linkedHashMap;
    }

    private final void trackGoogleQueryPurchasesRequestIfNeeded(String str, List<String> list, com.android.billingclient.api.d dVar, Date date) {
        DiagnosticsTracker diagnosticsTrackerIfEnabled = this.useCaseParams.getDiagnosticsTrackerIfEnabled();
        if (diagnosticsTrackerIfEnabled != null) {
            int iB = dVar.b();
            String strA = dVar.a();
            r.e(strA, "billingResult.debugMessage");
            diagnosticsTrackerIfEnabled.m110trackGoogleQueryPurchasesRequestzkXUZaI(str, iB, strA, DurationExtensionsKt.between(C1779a.f14679b, date, this.useCaseParams.getDateProvider().getNow()), list);
        }
    }

    @Override // com.revenuecat.purchases.google.usecase.BillingClientUseCase
    public void executeAsync() {
        this.withConnectedClient.invoke(new AnonymousClass1());
    }

    @Override // com.revenuecat.purchases.google.usecase.BillingClientUseCase
    public String getErrorMessage() {
        return "Error when querying purchases of type " + this.useCaseParams.getProductType();
    }

    public final k getOnError() {
        return this.onError;
    }

    public final k getOnSuccess() {
        return this.onSuccess;
    }

    public final k getWithConnectedClient() {
        return this.withConnectedClient;
    }

    @Override // com.revenuecat.purchases.google.usecase.BillingClientUseCase
    public /* bridge */ /* synthetic */ void onOk(Map<String, ? extends StoreTransaction> map) {
        onOk2((Map<String, StoreTransaction>) map);
    }

    /* JADX INFO: renamed from: onOk, reason: avoid collision after fix types in other method */
    public void onOk2(Map<String, StoreTransaction> received) {
        r.f(received, "received");
        this.onSuccess.invoke(received);
    }
}
