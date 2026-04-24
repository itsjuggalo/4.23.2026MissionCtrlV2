package com.revenuecat.purchases.google.usecase;

import H0.InterfaceC0310l;
import W2.E;
import X2.AbstractC0769p;
import X2.x;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.DurationExtensionsKt;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.google.BillingClientParamBuildersKt;
import com.revenuecat.purchases.google.ProductTypeConversionsKt;
import com.revenuecat.purchases.google.StoreProductConversionsKt;
import i3.k;
import i3.o;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import s3.C1779a;

/* JADX INFO: loaded from: classes3.dex */
public final class QueryProductDetailsUseCase extends BillingClientUseCase<List<? extends com.android.billingclient.api.f>> {
    private static final Companion Companion = new Companion(null);
    private static final AtomicBoolean hasLoggedBillingFlowParamsError = new AtomicBoolean(false);
    private final k onError;
    private final k onReceive;
    private final QueryProductDetailsUseCaseParams useCaseParams;
    private final k withConnectedClient;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        public final AtomicBoolean getHasLoggedBillingFlowParamsError() {
            return QueryProductDetailsUseCase.hasLoggedBillingFlowParamsError;
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.google.usecase.QueryProductDetailsUseCase$executeAsync$2, reason: invalid class name */
    public static final class AnonymousClass2 extends s implements k {
        final /* synthetic */ Set<String> $nonEmptyProductIds;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Set<String> set) {
            super(1);
            this.$nonEmptyProductIds = set;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) throws Throwable {
            invoke((com.android.billingclient.api.a) obj);
            return E.f5463a;
        }

        public final void invoke(com.android.billingclient.api.a invoke) throws Throwable {
            r.f(invoke, "$this$invoke");
            String googleProductType = ProductTypeConversionsKt.toGoogleProductType(QueryProductDetailsUseCase.this.useCaseParams.getProductType());
            if (googleProductType == null) {
                googleProductType = "inapp";
            }
            final QueryProductDetailsUseCase queryProductDetailsUseCase = QueryProductDetailsUseCase.this;
            queryProductDetailsUseCase.queryProductDetailsAsyncEnsuringOneResponse(invoke, googleProductType, this.$nonEmptyProductIds, new InterfaceC0310l() { // from class: com.revenuecat.purchases.google.usecase.e
                @Override // H0.InterfaceC0310l
                public final void a(com.android.billingclient.api.d dVar, List list) {
                    BillingClientUseCase.processResult$default(queryProductDetailsUseCase, dVar, list, null, null, 12, null);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QueryProductDetailsUseCase(QueryProductDetailsUseCaseParams useCaseParams, k onReceive, k onError, k withConnectedClient, o executeRequestOnUIThread) {
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

    /* JADX WARN: Removed duplicated region for block: B:14:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void logErrorIfIssueBuildingBillingParams(java.util.List<com.android.billingclient.api.f> r4) {
        /*
            r3 = this;
            java.lang.String r0 = "[Purchases] - ERROR"
            java.lang.Object r4 = X2.x.J(r4)
            com.android.billingclient.api.f r4 = (com.android.billingclient.api.f) r4
            if (r4 == 0) goto L73
            java.util.concurrent.atomic.AtomicBoolean r1 = com.revenuecat.purchases.google.usecase.QueryProductDetailsUseCase.hasLoggedBillingFlowParamsError
            r2 = 1
            boolean r1 = r1.getAndSet(r2)
            if (r1 == 0) goto L14
            goto L73
        L14:
            java.util.List r1 = r4.f()     // Catch: java.lang.Throwable -> L2c
            if (r1 == 0) goto L2e
            java.lang.String r2 = "subscriptionOfferDetails"
            kotlin.jvm.internal.r.e(r1, r2)     // Catch: java.lang.Throwable -> L2c
            java.lang.Object r1 = X2.x.J(r1)     // Catch: java.lang.Throwable -> L2c
            com.android.billingclient.api.f$e r1 = (com.android.billingclient.api.f.e) r1     // Catch: java.lang.Throwable -> L2c
            if (r1 == 0) goto L2e
            java.lang.String r1 = r1.e()     // Catch: java.lang.Throwable -> L2c
            goto L2f
        L2c:
            r4 = move-exception
            goto L68
        L2e:
            r1 = 0
        L2f:
            com.android.billingclient.api.c$b$a r2 = com.android.billingclient.api.c.b.a()     // Catch: java.lang.Throwable -> L2c
            com.android.billingclient.api.c$b$a r4 = r2.c(r4)     // Catch: java.lang.Throwable -> L2c
            if (r1 == 0) goto L3c
            r4.b(r1)     // Catch: java.lang.Throwable -> L2c
        L3c:
            com.android.billingclient.api.c$b r4 = r4.a()     // Catch: java.lang.Throwable -> L2c
            java.lang.String r1 = "newBuilder()\n           …                 .build()"
            kotlin.jvm.internal.r.e(r4, r1)     // Catch: java.lang.Throwable -> L2c
            com.android.billingclient.api.c$a r1 = com.android.billingclient.api.c.a()     // Catch: java.lang.Throwable -> L2c java.lang.NoClassDefFoundError -> L5b
            java.util.List r4 = X2.AbstractC0768o.b(r4)     // Catch: java.lang.Throwable -> L2c java.lang.NoClassDefFoundError -> L5b
            com.android.billingclient.api.c$a r4 = r1.d(r4)     // Catch: java.lang.Throwable -> L2c java.lang.NoClassDefFoundError -> L5b
            com.android.billingclient.api.c r4 = r4.a()     // Catch: java.lang.Throwable -> L2c java.lang.NoClassDefFoundError -> L5b
            java.lang.String r1 = "{\n                    Bi…build()\n                }"
            kotlin.jvm.internal.r.e(r4, r1)     // Catch: java.lang.Throwable -> L2c java.lang.NoClassDefFoundError -> L5b
            goto L73
        L5b:
            r4 = move-exception
            com.revenuecat.purchases.LogHandler r1 = com.revenuecat.purchases.common.LogWrapperKt.getCurrentLogHandler()     // Catch: java.lang.Throwable -> L2c
            java.lang.String r2 = "Error building BillingFlowParams which is required to perform purchases in the Play store. This is due to an issue in Google's Billing Client library. Please check https://errors.rev.cat/no-core-library-desugaring for more info and to fix this issue."
            r1.e(r0, r2, r4)     // Catch: java.lang.Throwable -> L2c
            W2.E r4 = W2.E.f5463a     // Catch: java.lang.Throwable -> L2c
            goto L73
        L68:
            com.revenuecat.purchases.LogHandler r1 = com.revenuecat.purchases.common.LogWrapperKt.getCurrentLogHandler()
            java.lang.String r2 = "Error building Params during safety check."
            r1.e(r0, r2, r4)
            W2.E r4 = W2.E.f5463a
        L73:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.google.usecase.QueryProductDetailsUseCase.logErrorIfIssueBuildingBillingParams(java.util.List):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void queryProductDetailsAsyncEnsuringOneResponse(com.android.billingclient.api.a aVar, final String str, final Set<String> set, final InterfaceC0310l interfaceC0310l) throws Throwable {
        try {
            try {
                com.android.billingclient.api.g gVarBuildQueryProductDetailsParams = BillingClientParamBuildersKt.buildQueryProductDetailsParams(str, set);
                final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                final Date now = this.useCaseParams.getDateProvider().getNow();
                aVar.i(gVarBuildQueryProductDetailsParams, new InterfaceC0310l() { // from class: com.revenuecat.purchases.google.usecase.d
                    @Override // H0.InterfaceC0310l
                    public final void a(com.android.billingclient.api.d dVar, List list) {
                        QueryProductDetailsUseCase.queryProductDetailsAsyncEnsuringOneResponse$lambda$8(atomicBoolean, this, set, str, now, interfaceC0310l, dVar, list);
                    }
                });
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void queryProductDetailsAsyncEnsuringOneResponse$lambda$8(AtomicBoolean hasResponded, QueryProductDetailsUseCase this$0, Set productIds, String productType, Date requestStartTime, InterfaceC0310l listener, com.android.billingclient.api.d billingResult, List productDetailsList) {
        r.f(hasResponded, "$hasResponded");
        r.f(this$0, "this$0");
        r.f(productIds, "$productIds");
        r.f(productType, "$productType");
        r.f(requestStartTime, "$requestStartTime");
        r.f(listener, "$listener");
        r.f(billingResult, "billingResult");
        r.f(productDetailsList, "productDetailsList");
        if (!hasResponded.getAndSet(true)) {
            this$0.trackGoogleQueryProductDetailsRequestIfNeeded(productIds, productType, billingResult, requestStartTime);
            listener.a(billingResult, productDetailsList);
            return;
        }
        LogIntent logIntent = LogIntent.GOOGLE_ERROR;
        QueryProductDetailsUseCase$queryProductDetailsAsyncEnsuringOneResponse$lambda$8$$inlined$log$1 queryProductDetailsUseCase$queryProductDetailsAsyncEnsuringOneResponse$lambda$8$$inlined$log$1 = new QueryProductDetailsUseCase$queryProductDetailsAsyncEnsuringOneResponse$lambda$8$$inlined$log$1(logIntent, billingResult);
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler.d("[Purchases] - " + logLevel.name(), (String) queryProductDetailsUseCase$queryProductDetailsAsyncEnsuringOneResponse$lambda$8$$inlined$log$1.invoke());
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) queryProductDetailsUseCase$queryProductDetailsAsyncEnsuringOneResponse$lambda$8$$inlined$log$1.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) queryProductDetailsUseCase$queryProductDetailsAsyncEnsuringOneResponse$lambda$8$$inlined$log$1.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) queryProductDetailsUseCase$queryProductDetailsAsyncEnsuringOneResponse$lambda$8$$inlined$log$1.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    currentLogHandler4.d("[Purchases] - " + logLevel4.name(), (String) queryProductDetailsUseCase$queryProductDetailsAsyncEnsuringOneResponse$lambda$8$$inlined$log$1.invoke());
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) queryProductDetailsUseCase$queryProductDetailsAsyncEnsuringOneResponse$lambda$8$$inlined$log$1.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler5.i("[Purchases] - " + logLevel5.name(), (String) queryProductDetailsUseCase$queryProductDetailsAsyncEnsuringOneResponse$lambda$8$$inlined$log$1.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    currentLogHandler6.d("[Purchases] - " + logLevel6.name(), (String) queryProductDetailsUseCase$queryProductDetailsAsyncEnsuringOneResponse$lambda$8$$inlined$log$1.invoke());
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    currentLogHandler7.d("[Purchases] - " + logLevel7.name(), (String) queryProductDetailsUseCase$queryProductDetailsAsyncEnsuringOneResponse$lambda$8$$inlined$log$1.invoke());
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler8.w("[Purchases] - " + logLevel8.name(), (String) queryProductDetailsUseCase$queryProductDetailsAsyncEnsuringOneResponse$lambda$8$$inlined$log$1.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler9.w("[Purchases] - " + logLevel9.name(), (String) queryProductDetailsUseCase$queryProductDetailsAsyncEnsuringOneResponse$lambda$8$$inlined$log$1.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) queryProductDetailsUseCase$queryProductDetailsAsyncEnsuringOneResponse$lambda$8$$inlined$log$1.invoke(), null);
                break;
        }
    }

    private final void trackGoogleQueryProductDetailsRequestIfNeeded(Set<String> set, String str, com.android.billingclient.api.d dVar, Date date) {
        DiagnosticsTracker diagnosticsTrackerIfEnabled = this.useCaseParams.getDiagnosticsTrackerIfEnabled();
        if (diagnosticsTrackerIfEnabled != null) {
            int iB = dVar.b();
            String strA = dVar.a();
            r.e(strA, "billingResult.debugMessage");
            diagnosticsTrackerIfEnabled.m108trackGoogleQueryProductDetailsRequest9VgGkz4(set, str, iB, strA, DurationExtensionsKt.between(C1779a.f14679b, date, this.useCaseParams.getDateProvider().getNow()));
        }
    }

    @Override // com.revenuecat.purchases.google.usecase.BillingClientUseCase
    public void executeAsync() {
        LogHandler currentLogHandler;
        String str;
        String str2;
        Set<String> productIds = this.useCaseParams.getProductIds();
        ArrayList arrayList = new ArrayList();
        for (Object obj : productIds) {
            if (((String) obj).length() > 0) {
                arrayList.add(obj);
            }
        }
        Set setL0 = x.l0(arrayList);
        if (!setL0.isEmpty()) {
            this.withConnectedClient.invoke(new AnonymousClass2(setL0));
            return;
        }
        LogIntent logIntent = LogIntent.DEBUG;
        QueryProductDetailsUseCase$executeAsync$$inlined$log$1 queryProductDetailsUseCase$executeAsync$$inlined$log$1 = new QueryProductDetailsUseCase$executeAsync$$inlined$log$1(logIntent);
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    str2 = (String) queryProductDetailsUseCase$executeAsync$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) queryProductDetailsUseCase$executeAsync$$inlined$log$1.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) queryProductDetailsUseCase$executeAsync$$inlined$log$1.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) queryProductDetailsUseCase$executeAsync$$inlined$log$1.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    str2 = (String) queryProductDetailsUseCase$executeAsync$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) queryProductDetailsUseCase$executeAsync$$inlined$log$1.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) queryProductDetailsUseCase$executeAsync$$inlined$log$1.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    str2 = (String) queryProductDetailsUseCase$executeAsync$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    str2 = (String) queryProductDetailsUseCase$executeAsync$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) queryProductDetailsUseCase$executeAsync$$inlined$log$1.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) queryProductDetailsUseCase$executeAsync$$inlined$log$1.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) queryProductDetailsUseCase$executeAsync$$inlined$log$1.invoke(), null);
                break;
        }
        this.onReceive.invoke(AbstractC0769p.g());
    }

    @Override // com.revenuecat.purchases.google.usecase.BillingClientUseCase
    public String getErrorMessage() {
        return "Error when fetching products";
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
    public /* bridge */ /* synthetic */ void onOk(List<? extends com.android.billingclient.api.f> list) {
        onOk2((List<com.android.billingclient.api.f>) list);
    }

    /* JADX INFO: renamed from: onOk, reason: avoid collision after fix types in other method */
    public void onOk2(List<com.android.billingclient.api.f> received) {
        LogHandler currentLogHandler;
        String str;
        Object objInvoke;
        LogHandler currentLogHandler2;
        String str2;
        String str3;
        r.f(received, "received");
        LogIntent logIntent = LogIntent.DEBUG;
        QueryProductDetailsUseCase$onOk$$inlined$log$1 queryProductDetailsUseCase$onOk$$inlined$log$1 = new QueryProductDetailsUseCase$onOk$$inlined$log$1(logIntent, this);
        int[] iArr = LogWrapperKt.WhenMappings.$EnumSwitchMapping$0;
        switch (iArr[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str2 = "[Purchases] - " + logLevel.name();
                    str3 = (String) queryProductDetailsUseCase$onOk$$inlined$log$1.invoke();
                    currentLogHandler2.d(str2, str3);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) queryProductDetailsUseCase$onOk$$inlined$log$1.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler3.w("[Purchases] - " + logLevel2.name(), (String) queryProductDetailsUseCase$onOk$$inlined$log$1.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel3.name(), (String) queryProductDetailsUseCase$onOk$$inlined$log$1.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str2 = "[Purchases] - " + logLevel4.name();
                    str3 = (String) queryProductDetailsUseCase$onOk$$inlined$log$1.invoke();
                    currentLogHandler2.d(str2, str3);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) queryProductDetailsUseCase$onOk$$inlined$log$1.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler5.i("[Purchases] - " + logLevel5.name(), (String) queryProductDetailsUseCase$onOk$$inlined$log$1.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str2 = "[Purchases] - " + logLevel6.name();
                    str3 = (String) queryProductDetailsUseCase$onOk$$inlined$log$1.invoke();
                    currentLogHandler2.d(str2, str3);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str2 = "[Purchases] - " + logLevel7.name();
                    str3 = (String) queryProductDetailsUseCase$onOk$$inlined$log$1.invoke();
                    currentLogHandler2.d(str2, str3);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel8.name(), (String) queryProductDetailsUseCase$onOk$$inlined$log$1.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler7.w("[Purchases] - " + logLevel9.name(), (String) queryProductDetailsUseCase$onOk$$inlined$log$1.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) queryProductDetailsUseCase$onOk$$inlined$log$1.invoke(), null);
                break;
        }
        LogIntent logIntent2 = LogIntent.PURCHASE;
        QueryProductDetailsUseCase$onOk$$inlined$log$2 queryProductDetailsUseCase$onOk$$inlined$log$2 = new QueryProductDetailsUseCase$onOk$$inlined$log$2(logIntent2, received);
        switch (iArr[logIntent2.ordinal()]) {
            case 1:
                LogLevel logLevel10 = LogLevel.DEBUG;
                LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler8.d("[Purchases] - " + logLevel10.name(), (String) queryProductDetailsUseCase$onOk$$inlined$log$2.invoke());
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) queryProductDetailsUseCase$onOk$$inlined$log$2.invoke(), null);
                break;
            case 3:
                LogLevel logLevel11 = LogLevel.WARN;
                LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                    currentLogHandler9.w("[Purchases] - " + logLevel11.name(), (String) queryProductDetailsUseCase$onOk$$inlined$log$2.invoke());
                }
                break;
            case 4:
                LogLevel logLevel12 = LogLevel.INFO;
                LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel12) <= 0) {
                    currentLogHandler10.i("[Purchases] - " + logLevel12.name(), (String) queryProductDetailsUseCase$onOk$$inlined$log$2.invoke());
                }
                break;
            case 5:
                LogLevel logLevel13 = LogLevel.DEBUG;
                LogHandler currentLogHandler11 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel13) <= 0) {
                    currentLogHandler11.d("[Purchases] - " + logLevel13.name(), (String) queryProductDetailsUseCase$onOk$$inlined$log$2.invoke());
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) queryProductDetailsUseCase$onOk$$inlined$log$2.invoke(), null);
                break;
            case 7:
                LogLevel logLevel14 = LogLevel.INFO;
                LogHandler currentLogHandler12 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel14) <= 0) {
                    currentLogHandler12.i("[Purchases] - " + logLevel14.name(), (String) queryProductDetailsUseCase$onOk$$inlined$log$2.invoke());
                }
                break;
            case 8:
                LogLevel logLevel15 = LogLevel.DEBUG;
                LogHandler currentLogHandler13 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                    currentLogHandler13.d("[Purchases] - " + logLevel15.name(), (String) queryProductDetailsUseCase$onOk$$inlined$log$2.invoke());
                }
                break;
            case 9:
                LogLevel logLevel16 = LogLevel.DEBUG;
                LogHandler currentLogHandler14 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel16) <= 0) {
                    currentLogHandler14.d("[Purchases] - " + logLevel16.name(), (String) queryProductDetailsUseCase$onOk$$inlined$log$2.invoke());
                }
                break;
            case 10:
                LogLevel logLevel17 = LogLevel.WARN;
                LogHandler currentLogHandler15 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                    currentLogHandler15.w("[Purchases] - " + logLevel17.name(), (String) queryProductDetailsUseCase$onOk$$inlined$log$2.invoke());
                }
                break;
            case 11:
                LogLevel logLevel18 = LogLevel.WARN;
                LogHandler currentLogHandler16 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel18) <= 0) {
                    currentLogHandler16.w("[Purchases] - " + logLevel18.name(), (String) queryProductDetailsUseCase$onOk$$inlined$log$2.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) queryProductDetailsUseCase$onOk$$inlined$log$2.invoke(), null);
                break;
        }
        logErrorIfIssueBuildingBillingParams(received);
        List<com.android.billingclient.api.f> list = !received.isEmpty() ? received : null;
        if (list != null) {
            for (com.android.billingclient.api.f fVar : list) {
                LogIntent logIntent3 = LogIntent.PURCHASE;
                QueryProductDetailsUseCase$onOk$lambda$6$$inlined$log$1 queryProductDetailsUseCase$onOk$lambda$6$$inlined$log$1 = new QueryProductDetailsUseCase$onOk$lambda$6$$inlined$log$1(logIntent3, fVar);
                switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent3.ordinal()]) {
                    case 1:
                        LogLevel logLevel19 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel19) <= 0) {
                            str = "[Purchases] - " + logLevel19.name();
                            objInvoke = queryProductDetailsUseCase$onOk$lambda$6$$inlined$log$1.invoke();
                            currentLogHandler.d(str, (String) objInvoke);
                        }
                        break;
                    case 2:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) queryProductDetailsUseCase$onOk$lambda$6$$inlined$log$1.invoke(), null);
                        break;
                    case 3:
                        LogLevel logLevel20 = LogLevel.WARN;
                        LogHandler currentLogHandler17 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel20) <= 0) {
                            currentLogHandler17.w("[Purchases] - " + logLevel20.name(), (String) queryProductDetailsUseCase$onOk$lambda$6$$inlined$log$1.invoke());
                        }
                        break;
                    case 4:
                        LogLevel logLevel21 = LogLevel.INFO;
                        LogHandler currentLogHandler18 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel21) <= 0) {
                            currentLogHandler18.i("[Purchases] - " + logLevel21.name(), (String) queryProductDetailsUseCase$onOk$lambda$6$$inlined$log$1.invoke());
                        }
                        break;
                    case 5:
                        LogLevel logLevel22 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel22) <= 0) {
                            str = "[Purchases] - " + logLevel22.name();
                            objInvoke = queryProductDetailsUseCase$onOk$lambda$6$$inlined$log$1.invoke();
                            currentLogHandler.d(str, (String) objInvoke);
                        }
                        break;
                    case 6:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) queryProductDetailsUseCase$onOk$lambda$6$$inlined$log$1.invoke(), null);
                        break;
                    case 7:
                        LogLevel logLevel23 = LogLevel.INFO;
                        LogHandler currentLogHandler19 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel23) <= 0) {
                            currentLogHandler19.i("[Purchases] - " + logLevel23.name(), (String) queryProductDetailsUseCase$onOk$lambda$6$$inlined$log$1.invoke());
                        }
                        break;
                    case 8:
                        LogLevel logLevel24 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel24) <= 0) {
                            str = "[Purchases] - " + logLevel24.name();
                            objInvoke = queryProductDetailsUseCase$onOk$lambda$6$$inlined$log$1.invoke();
                            currentLogHandler.d(str, (String) objInvoke);
                        }
                        break;
                    case 9:
                        LogLevel logLevel25 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel25) <= 0) {
                            str = "[Purchases] - " + logLevel25.name();
                            objInvoke = queryProductDetailsUseCase$onOk$lambda$6$$inlined$log$1.invoke();
                            currentLogHandler.d(str, (String) objInvoke);
                        }
                        break;
                    case 10:
                        LogLevel logLevel26 = LogLevel.WARN;
                        LogHandler currentLogHandler20 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel26) <= 0) {
                            currentLogHandler20.w("[Purchases] - " + logLevel26.name(), (String) queryProductDetailsUseCase$onOk$lambda$6$$inlined$log$1.invoke());
                        }
                        break;
                    case 11:
                        LogLevel logLevel27 = LogLevel.WARN;
                        LogHandler currentLogHandler21 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel27) <= 0) {
                            currentLogHandler21.w("[Purchases] - " + logLevel27.name(), (String) queryProductDetailsUseCase$onOk$lambda$6$$inlined$log$1.invoke());
                        }
                        break;
                    case 12:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) queryProductDetailsUseCase$onOk$lambda$6$$inlined$log$1.invoke(), null);
                        break;
                }
            }
            E e4 = E.f5463a;
        }
        this.onReceive.invoke(StoreProductConversionsKt.toStoreProducts(received));
    }
}
