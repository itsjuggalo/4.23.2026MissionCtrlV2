package com.revenuecat.purchases.google;

import H0.C0298d;
import H0.C0307i;
import H0.C0309k;
import H0.InterfaceC0296c;
import H0.InterfaceC0308j;
import H0.InterfaceC0313o;
import W2.E;
import W2.m;
import W2.o;
import W2.t;
import X2.AbstractC0768o;
import X2.AbstractC0769p;
import X2.AbstractC0770q;
import X2.u;
import X2.x;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchaseHistoryRecord;
import com.android.billingclient.api.c;
import com.android.billingclient.api.e;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.NoCoreLibraryDesugaringException;
import com.revenuecat.purchases.PostReceiptInitiationSource;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.PurchasesStateProvider;
import com.revenuecat.purchases.ReplacementMode;
import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.PurchaseExtensionsKt;
import com.revenuecat.purchases.common.ReplaceProductInfo;
import com.revenuecat.purchases.common.UtilsKt;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.google.BillingWrapper;
import com.revenuecat.purchases.google.usecase.AcknowledgePurchaseUseCase;
import com.revenuecat.purchases.google.usecase.AcknowledgePurchaseUseCaseParams;
import com.revenuecat.purchases.google.usecase.BillingClientUseCase;
import com.revenuecat.purchases.google.usecase.ConsumePurchaseUseCase;
import com.revenuecat.purchases.google.usecase.ConsumePurchaseUseCaseParams;
import com.revenuecat.purchases.google.usecase.GetBillingConfigUseCase;
import com.revenuecat.purchases.google.usecase.GetBillingConfigUseCaseParams;
import com.revenuecat.purchases.google.usecase.QueryProductDetailsUseCase;
import com.revenuecat.purchases.google.usecase.QueryProductDetailsUseCaseParams;
import com.revenuecat.purchases.google.usecase.QueryPurchaseHistoryUseCase;
import com.revenuecat.purchases.google.usecase.QueryPurchaseHistoryUseCaseParams;
import com.revenuecat.purchases.google.usecase.QueryPurchasesByTypeUseCase;
import com.revenuecat.purchases.google.usecase.QueryPurchasesByTypeUseCaseParams;
import com.revenuecat.purchases.google.usecase.QueryPurchasesUseCase;
import com.revenuecat.purchases.google.usecase.QueryPurchasesUseCaseParams;
import com.revenuecat.purchases.models.GooglePurchasingData;
import com.revenuecat.purchases.models.GoogleReplacementMode;
import com.revenuecat.purchases.models.InAppMessageType;
import com.revenuecat.purchases.models.PurchaseState;
import com.revenuecat.purchases.models.PurchasingData;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.strings.BillingStrings;
import com.revenuecat.purchases.strings.PurchaseStrings;
import com.revenuecat.purchases.utils.Result;
import i3.k;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import q3.l;

/* JADX INFO: loaded from: classes3.dex */
public final class BillingWrapper extends BillingAbstract implements InterfaceC0313o, InterfaceC0296c {
    private static final Companion Companion = new Companion(null);
    private static final int MAX_PENDING_REQUEST_COUNT_REPORTED = 100;
    private volatile com.android.billingclient.api.a billingClient;
    private final ClientFactory clientFactory;
    private final DateProvider dateProvider;
    private final DeviceCache deviceCache;
    private final DiagnosticsTracker diagnosticsTrackerIfEnabled;
    private final Handler mainHandler;
    private final Map<String, PurchaseContext> purchaseContext;
    private long reconnectMilliseconds;
    private boolean reconnectionAlreadyScheduled;
    private final ConcurrentLinkedQueue<o> serviceRequests;

    public static final class ClientFactory {
        private final Context context;
        private final boolean pendingTransactionsForPrepaidPlansEnabled;

        public ClientFactory(Context context, boolean z4) {
            r.f(context, "context");
            this.context = context;
            this.pendingTransactionsForPrepaidPlansEnabled = z4;
        }

        public final com.android.billingclient.api.a buildClient(InterfaceC0313o listener) {
            r.f(listener, "listener");
            e.a aVarB = com.android.billingclient.api.e.c().b();
            if (this.pendingTransactionsForPrepaidPlansEnabled) {
                aVarB.c();
            }
            com.android.billingclient.api.e eVarA = aVarB.a();
            r.e(eVarA, "newBuilder()\n           …\n                .build()");
            com.android.billingclient.api.a aVarA = com.android.billingclient.api.a.h(this.context).c(eVarA).d(listener).a();
            r.e(aVarA, "newBuilder(context).enab…\n                .build()");
            return aVarA;
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.google.BillingWrapper$consumeAndSave$1, reason: invalid class name */
    public /* synthetic */ class AnonymousClass1 extends kotlin.jvm.internal.o implements k {
        public AnonymousClass1(Object obj) {
            super(1, obj, DeviceCache.class, "addSuccessfullyPostedToken", "addSuccessfullyPostedToken(Ljava/lang/String;)V", 0);
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return E.f5463a;
        }

        public final void invoke(String p02) {
            r.f(p02, "p0");
            ((DeviceCache) this.receiver).addSuccessfullyPostedToken(p02);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.google.BillingWrapper$consumeAndSave$3, reason: invalid class name */
    public /* synthetic */ class AnonymousClass3 extends kotlin.jvm.internal.o implements k {
        public AnonymousClass3(Object obj) {
            super(1, obj, DeviceCache.class, "addSuccessfullyPostedToken", "addSuccessfullyPostedToken(Ljava/lang/String;)V", 0);
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return E.f5463a;
        }

        public final void invoke(String p02) {
            r.f(p02, "p0");
            ((DeviceCache) this.receiver).addSuccessfullyPostedToken(p02);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.google.BillingWrapper$consumeAndSave$4, reason: invalid class name */
    public /* synthetic */ class AnonymousClass4 extends kotlin.jvm.internal.o implements k {
        public AnonymousClass4(Object obj) {
            super(1, obj, DeviceCache.class, "addSuccessfullyPostedToken", "addSuccessfullyPostedToken(Ljava/lang/String;)V", 0);
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return E.f5463a;
        }

        public final void invoke(String p02) {
            r.f(p02, "p0");
            ((DeviceCache) this.receiver).addSuccessfullyPostedToken(p02);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.google.BillingWrapper$getStorefront$2, reason: invalid class name */
    public static final class AnonymousClass2 extends s implements k {
        final /* synthetic */ k $onSuccess;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(k kVar) {
            super(1);
            this.$onSuccess = kVar;
        }

        public final void invoke(C0298d billingConfig) {
            r.f(billingConfig, "billingConfig");
            k kVar = this.$onSuccess;
            String strA = billingConfig.a();
            r.e(strA, "billingConfig.countryCode");
            kVar.invoke(strA);
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((C0298d) obj);
            return E.f5463a;
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.google.BillingWrapper$getStorefront$3, reason: invalid class name and case insensitive filesystem */
    public /* synthetic */ class C11553 extends kotlin.jvm.internal.o implements k {
        public C11553(Object obj) {
            super(1, obj, BillingWrapper.class, "withConnectedClient", "withConnectedClient(Lkotlin/jvm/functions/Function1;)V", 0);
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((k) obj);
            return E.f5463a;
        }

        public final void invoke(k p02) {
            r.f(p02, "p0");
            ((BillingWrapper) this.receiver).withConnectedClient(p02);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.google.BillingWrapper$getStorefront$4, reason: invalid class name and case insensitive filesystem */
    public /* synthetic */ class C11564 extends kotlin.jvm.internal.o implements i3.o {
        public C11564(Object obj) {
            super(2, obj, BillingWrapper.class, "executeRequestOnUIThread", "executeRequestOnUIThread(Ljava/lang/Long;Lkotlin/jvm/functions/Function1;)V", 0);
        }

        @Override // i3.o
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((Long) obj, (k) obj2);
            return E.f5463a;
        }

        public final void invoke(Long l4, k p12) {
            r.f(p12, "p1");
            ((BillingWrapper) this.receiver).executeRequestOnUIThread(l4, p12);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.google.BillingWrapper$launchBillingFlow$2, reason: invalid class name and case insensitive filesystem */
    public static final class C11572 extends s implements k {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ com.android.billingclient.api.c $params;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11572(Activity activity, com.android.billingclient.api.c cVar) {
            super(1);
            this.$activity = activity;
            this.$params = cVar;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((com.android.billingclient.api.a) obj);
            return E.f5463a;
        }

        public final void invoke(com.android.billingclient.api.a withConnectedClient) {
            r.f(withConnectedClient, "$this$withConnectedClient");
            com.android.billingclient.api.d dVarG = withConnectedClient.g(this.$activity, this.$params);
            if (dVarG.b() == 0) {
                dVarG = null;
            }
            if (dVarG != null) {
                LogIntent logIntent = LogIntent.GOOGLE_ERROR;
                BillingWrapper$launchBillingFlow$2$invoke$lambda$2$$inlined$log$1 billingWrapper$launchBillingFlow$2$invoke$lambda$2$$inlined$log$1 = new BillingWrapper$launchBillingFlow$2$invoke$lambda$2$$inlined$log$1(logIntent, dVarG);
                switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                    case 1:
                        LogLevel logLevel = LogLevel.DEBUG;
                        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                            currentLogHandler.d("[Purchases] - " + logLevel.name(), (String) billingWrapper$launchBillingFlow$2$invoke$lambda$2$$inlined$log$1.invoke());
                        }
                        break;
                    case 2:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$launchBillingFlow$2$invoke$lambda$2$$inlined$log$1.invoke(), null);
                        break;
                    case 3:
                        LogLevel logLevel2 = LogLevel.WARN;
                        LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                            currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) billingWrapper$launchBillingFlow$2$invoke$lambda$2$$inlined$log$1.invoke());
                        }
                        break;
                    case 4:
                        LogLevel logLevel3 = LogLevel.INFO;
                        LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                            currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) billingWrapper$launchBillingFlow$2$invoke$lambda$2$$inlined$log$1.invoke());
                        }
                        break;
                    case 5:
                        LogLevel logLevel4 = LogLevel.DEBUG;
                        LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                            currentLogHandler4.d("[Purchases] - " + logLevel4.name(), (String) billingWrapper$launchBillingFlow$2$invoke$lambda$2$$inlined$log$1.invoke());
                        }
                        break;
                    case 6:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$launchBillingFlow$2$invoke$lambda$2$$inlined$log$1.invoke(), null);
                        break;
                    case 7:
                        LogLevel logLevel5 = LogLevel.INFO;
                        LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                            currentLogHandler5.i("[Purchases] - " + logLevel5.name(), (String) billingWrapper$launchBillingFlow$2$invoke$lambda$2$$inlined$log$1.invoke());
                        }
                        break;
                    case 8:
                        LogLevel logLevel6 = LogLevel.DEBUG;
                        LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                            currentLogHandler6.d("[Purchases] - " + logLevel6.name(), (String) billingWrapper$launchBillingFlow$2$invoke$lambda$2$$inlined$log$1.invoke());
                        }
                        break;
                    case 9:
                        LogLevel logLevel7 = LogLevel.DEBUG;
                        LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                            currentLogHandler7.d("[Purchases] - " + logLevel7.name(), (String) billingWrapper$launchBillingFlow$2$invoke$lambda$2$$inlined$log$1.invoke());
                        }
                        break;
                    case 10:
                        LogLevel logLevel8 = LogLevel.WARN;
                        LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                            currentLogHandler8.w("[Purchases] - " + logLevel8.name(), (String) billingWrapper$launchBillingFlow$2$invoke$lambda$2$$inlined$log$1.invoke());
                        }
                        break;
                    case 11:
                        LogLevel logLevel9 = LogLevel.WARN;
                        LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                            currentLogHandler9.w("[Purchases] - " + logLevel9.name(), (String) billingWrapper$launchBillingFlow$2$invoke$lambda$2$$inlined$log$1.invoke());
                        }
                        break;
                    case 12:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$launchBillingFlow$2$invoke$lambda$2$$inlined$log$1.invoke(), null);
                        break;
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.google.BillingWrapper$makePurchaseAsync$4, reason: invalid class name and case insensitive filesystem */
    public static final class C11584 extends s implements k {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ String $appUserID;
        final /* synthetic */ GooglePurchasingData $googlePurchasingData;
        final /* synthetic */ Boolean $isPersonalizedPrice;
        final /* synthetic */ PurchasingData $purchasingData;
        final /* synthetic */ ReplaceProductInfo $replaceProductInfo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11584(PurchasingData purchasingData, ReplaceProductInfo replaceProductInfo, String str, Boolean bool, GooglePurchasingData googlePurchasingData, Activity activity) {
            super(1);
            this.$purchasingData = purchasingData;
            this.$replaceProductInfo = replaceProductInfo;
            this.$appUserID = str;
            this.$isPersonalizedPrice = bool;
            this.$googlePurchasingData = googlePurchasingData;
            this.$activity = activity;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((PurchasesError) obj);
            return E.f5463a;
        }

        public final void invoke(PurchasesError purchasesError) {
            BillingAbstract.PurchasesUpdatedListener purchasesUpdatedListener;
            StoreTransaction oldPurchase;
            List<String> productIds;
            Result resultBuildPurchaseParams = BillingWrapper.this.buildPurchaseParams((GooglePurchasingData) this.$purchasingData, this.$replaceProductInfo, this.$appUserID, this.$isPersonalizedPrice);
            if (!(resultBuildPurchaseParams instanceof Result.Success)) {
                if (!(resultBuildPurchaseParams instanceof Result.Error) || (purchasesUpdatedListener = BillingWrapper.this.getPurchasesUpdatedListener()) == null) {
                    return;
                }
                purchasesUpdatedListener.onPurchasesFailedToUpdate((PurchasesError) ((Result.Error) resultBuildPurchaseParams).getValue());
                return;
            }
            BillingWrapper billingWrapper = BillingWrapper.this;
            GooglePurchasingData googlePurchasingData = this.$googlePurchasingData;
            ReplaceProductInfo replaceProductInfo = this.$replaceProductInfo;
            billingWrapper.trackPurchaseStartIfNeeded(googlePurchasingData, (replaceProductInfo == null || (oldPurchase = replaceProductInfo.getOldPurchase()) == null || (productIds = oldPurchase.getProductIds()) == null) ? null : (String) x.J(productIds));
            BillingWrapper.this.launchBillingFlow(this.$activity, (com.android.billingclient.api.c) ((Result.Success) resultBuildPurchaseParams).getValue());
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.google.BillingWrapper$queryAllPurchases$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11591 extends s implements k {
        final /* synthetic */ k $onReceivePurchaseHistory;
        final /* synthetic */ k $onReceivePurchaseHistoryError;

        /* JADX INFO: renamed from: com.revenuecat.purchases.google.BillingWrapper$queryAllPurchases$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01751 extends s implements k {
            final /* synthetic */ k $onReceivePurchaseHistory;
            final /* synthetic */ List<PurchaseHistoryRecord> $subsPurchasesList;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C01751(k kVar, List<? extends PurchaseHistoryRecord> list) {
                super(1);
                this.$onReceivePurchaseHistory = kVar;
                this.$subsPurchasesList = list;
            }

            @Override // i3.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<? extends PurchaseHistoryRecord>) obj);
                return E.f5463a;
            }

            public final void invoke(List<? extends PurchaseHistoryRecord> inAppPurchasesList) {
                r.f(inAppPurchasesList, "inAppPurchasesList");
                k kVar = this.$onReceivePurchaseHistory;
                List<PurchaseHistoryRecord> list = this.$subsPurchasesList;
                ArrayList arrayList = new ArrayList(AbstractC0770q.q(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(StoreTransactionConversionsKt.toStoreTransaction((PurchaseHistoryRecord) it.next(), ProductType.SUBS));
                }
                ArrayList arrayList2 = new ArrayList(AbstractC0770q.q(inAppPurchasesList, 10));
                Iterator<T> it2 = inAppPurchasesList.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(StoreTransactionConversionsKt.toStoreTransaction((PurchaseHistoryRecord) it2.next(), ProductType.INAPP));
                }
                kVar.invoke(x.U(arrayList, arrayList2));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11591(k kVar, k kVar2) {
            super(1);
            this.$onReceivePurchaseHistoryError = kVar;
            this.$onReceivePurchaseHistory = kVar2;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((List<? extends PurchaseHistoryRecord>) obj);
            return E.f5463a;
        }

        public final void invoke(List<? extends PurchaseHistoryRecord> subsPurchasesList) {
            r.f(subsPurchasesList, "subsPurchasesList");
            BillingWrapper.this.queryPurchaseHistoryAsync("inapp", new C01751(this.$onReceivePurchaseHistory, subsPurchasesList), this.$onReceivePurchaseHistoryError);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.google.BillingWrapper$queryPurchaseHistoryAsync$2, reason: invalid class name and case insensitive filesystem */
    public /* synthetic */ class C11602 extends kotlin.jvm.internal.o implements k {
        public C11602(Object obj) {
            super(1, obj, BillingWrapper.class, "withConnectedClient", "withConnectedClient(Lkotlin/jvm/functions/Function1;)V", 0);
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((k) obj);
            return E.f5463a;
        }

        public final void invoke(k p02) {
            r.f(p02, "p0");
            ((BillingWrapper) this.receiver).withConnectedClient(p02);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.google.BillingWrapper$queryPurchaseHistoryAsync$3, reason: invalid class name and case insensitive filesystem */
    public /* synthetic */ class C11613 extends kotlin.jvm.internal.o implements i3.o {
        public C11613(Object obj) {
            super(2, obj, BillingWrapper.class, "executeRequestOnUIThread", "executeRequestOnUIThread(Ljava/lang/Long;Lkotlin/jvm/functions/Function1;)V", 0);
        }

        @Override // i3.o
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((Long) obj, (k) obj2);
            return E.f5463a;
        }

        public final void invoke(Long l4, k p12) {
            r.f(p12, "p1");
            ((BillingWrapper) this.receiver).executeRequestOnUIThread(l4, p12);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.google.BillingWrapper$queryPurchaseType$3, reason: invalid class name and case insensitive filesystem */
    public /* synthetic */ class C11643 extends kotlin.jvm.internal.o implements k {
        public C11643(Object obj) {
            super(1, obj, BillingWrapper.class, "withConnectedClient", "withConnectedClient(Lkotlin/jvm/functions/Function1;)V", 0);
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((k) obj);
            return E.f5463a;
        }

        public final void invoke(k p02) {
            r.f(p02, "p0");
            ((BillingWrapper) this.receiver).withConnectedClient(p02);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.google.BillingWrapper$queryPurchaseType$4, reason: invalid class name and case insensitive filesystem */
    public /* synthetic */ class C11654 extends kotlin.jvm.internal.o implements i3.o {
        public C11654(Object obj) {
            super(2, obj, BillingWrapper.class, "executeRequestOnUIThread", "executeRequestOnUIThread(Ljava/lang/Long;Lkotlin/jvm/functions/Function1;)V", 0);
        }

        @Override // i3.o
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((Long) obj, (k) obj2);
            return E.f5463a;
        }

        public final void invoke(Long l4, k p12) {
            r.f(p12, "p1");
            ((BillingWrapper) this.receiver).executeRequestOnUIThread(l4, p12);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.google.BillingWrapper$queryPurchases$2, reason: invalid class name and case insensitive filesystem */
    public /* synthetic */ class C11662 extends kotlin.jvm.internal.o implements k {
        public C11662(Object obj) {
            super(1, obj, BillingWrapper.class, "withConnectedClient", "withConnectedClient(Lkotlin/jvm/functions/Function1;)V", 0);
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((k) obj);
            return E.f5463a;
        }

        public final void invoke(k p02) {
            r.f(p02, "p0");
            ((BillingWrapper) this.receiver).withConnectedClient(p02);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.google.BillingWrapper$queryPurchases$3, reason: invalid class name and case insensitive filesystem */
    public /* synthetic */ class C11673 extends kotlin.jvm.internal.o implements i3.o {
        public C11673(Object obj) {
            super(2, obj, BillingWrapper.class, "executeRequestOnUIThread", "executeRequestOnUIThread(Ljava/lang/Long;Lkotlin/jvm/functions/Function1;)V", 0);
        }

        @Override // i3.o
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((Long) obj, (k) obj2);
            return E.f5463a;
        }

        public final void invoke(Long l4, k p12) {
            r.f(p12, "p1");
            ((BillingWrapper) this.receiver).executeRequestOnUIThread(l4, p12);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.google.BillingWrapper$showInAppMessagesIfNeeded$2, reason: invalid class name and case insensitive filesystem */
    public static final class C11682 extends s implements k {
        final /* synthetic */ C0307i $inAppMessageParams;
        final /* synthetic */ Function0 $subscriptionStatusChange;
        final /* synthetic */ WeakReference<Activity> $weakActivity;

        /* JADX INFO: renamed from: com.revenuecat.purchases.google.BillingWrapper$showInAppMessagesIfNeeded$2$2, reason: invalid class name and collision with other inner class name */
        public static final class C01762 extends s implements k {
            final /* synthetic */ C0307i $inAppMessageParams;
            final /* synthetic */ Function0 $subscriptionStatusChange;
            final /* synthetic */ WeakReference<Activity> $weakActivity;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01762(WeakReference<Activity> weakReference, C0307i c0307i, Function0 function0) {
                super(1);
                this.$weakActivity = weakReference;
                this.$inAppMessageParams = c0307i;
                this.$subscriptionStatusChange = function0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void invoke$lambda$5(Function0 subscriptionStatusChange, C0309k inAppMessageResult) {
                r.f(subscriptionStatusChange, "$subscriptionStatusChange");
                r.f(inAppMessageResult, "inAppMessageResult");
                int iA = inAppMessageResult.a();
                if (iA == 0) {
                    LogLevel logLevel = LogLevel.VERBOSE;
                    LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        currentLogHandler.v("[Purchases] - " + logLevel.name(), BillingStrings.BILLING_INAPP_MESSAGE_NONE);
                        return;
                    }
                    return;
                }
                if (iA != 1) {
                    LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    String str = String.format(BillingStrings.BILLING_INAPP_MESSAGE_UNEXPECTED_CODE, Arrays.copyOf(new Object[]{Integer.valueOf(iA)}, 1));
                    r.e(str, "format(this, *args)");
                    currentLogHandler2.e("[Purchases] - ERROR", str, null);
                    return;
                }
                LogLevel logLevel2 = LogLevel.DEBUG;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler3.d("[Purchases] - " + logLevel2.name(), BillingStrings.BILLING_INAPP_MESSAGE_UPDATE);
                }
                subscriptionStatusChange.invoke();
            }

            @Override // i3.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((com.android.billingclient.api.a) obj);
                return E.f5463a;
            }

            public final void invoke(com.android.billingclient.api.a withConnectedClient) {
                r.f(withConnectedClient, "$this$withConnectedClient");
                Activity activity = this.$weakActivity.get();
                if (activity != null) {
                    C0307i c0307i = this.$inAppMessageParams;
                    final Function0 function0 = this.$subscriptionStatusChange;
                    withConnectedClient.l(activity, c0307i, new InterfaceC0308j() { // from class: com.revenuecat.purchases.google.g
                        @Override // H0.InterfaceC0308j
                        public final void a(C0309k c0309k) {
                            BillingWrapper.C11682.C01762.invoke$lambda$5(function0, c0309k);
                        }
                    });
                    return;
                }
                LogLevel logLevel = LogLevel.DEBUG;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler.d("[Purchases] - " + logLevel.name(), "Activity is null, not showing Google Play in-app message.");
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11682(WeakReference<Activity> weakReference, C0307i c0307i, Function0 function0) {
            super(1);
            this.$weakActivity = weakReference;
            this.$inAppMessageParams = c0307i;
            this.$subscriptionStatusChange = function0;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((PurchasesError) obj);
            return E.f5463a;
        }

        public final void invoke(PurchasesError purchasesError) {
            if (purchasesError == null) {
                BillingWrapper.this.withConnectedClient(new C01762(this.$weakActivity, this.$inAppMessageParams, this.$subscriptionStatusChange));
                return;
            }
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            String str = String.format(BillingStrings.BILLING_CONNECTION_ERROR_INAPP_MESSAGES, Arrays.copyOf(new Object[]{purchasesError}, 1));
            r.e(str, "format(this, *args)");
            currentLogHandler.e("[Purchases] - ERROR", str, null);
        }
    }

    public /* synthetic */ BillingWrapper(ClientFactory clientFactory, Handler handler, DeviceCache deviceCache, DiagnosticsTracker diagnosticsTracker, PurchasesStateProvider purchasesStateProvider, DateProvider dateProvider, int i4, AbstractC1585j abstractC1585j) {
        this(clientFactory, handler, deviceCache, diagnosticsTracker, purchasesStateProvider, (i4 & 32) != 0 ? new DefaultDateProvider() : dateProvider);
    }

    private final Result<com.android.billingclient.api.c, PurchasesError> buildOneTimePurchaseParams(GooglePurchasingData.InAppProduct inAppProduct, String str, Boolean bool) {
        c.b.a aVarA = c.b.a();
        aVarA.c(inAppProduct.getProductDetails());
        c.b bVarA = aVarA.a();
        r.e(bVarA, "newBuilder().apply {\n   …etails)\n        }.build()");
        try {
            c.a aVarC = com.android.billingclient.api.c.a().d(AbstractC0768o.b(bVarA)).c(UtilsKt.sha256(str));
            if (bool != null) {
                aVarC.b(bool.booleanValue());
            }
            com.android.billingclient.api.c cVarA = aVarC.a();
            r.e(cVarA, "newBuilder()\n           …                 .build()");
            return new Result.Success(cVarA);
        } catch (NoClassDefFoundError e4) {
            throw new NoCoreLibraryDesugaringException(e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Result<com.android.billingclient.api.c, PurchasesError> buildPurchaseParams(GooglePurchasingData googlePurchasingData, ReplaceProductInfo replaceProductInfo, String str, Boolean bool) {
        if (googlePurchasingData instanceof GooglePurchasingData.InAppProduct) {
            return buildOneTimePurchaseParams((GooglePurchasingData.InAppProduct) googlePurchasingData, str, bool);
        }
        if (googlePurchasingData instanceof GooglePurchasingData.Subscription) {
            return buildSubscriptionPurchaseParams((GooglePurchasingData.Subscription) googlePurchasingData, replaceProductInfo, str, bool);
        }
        throw new m();
    }

    private final Result<com.android.billingclient.api.c, PurchasesError> buildSubscriptionPurchaseParams(GooglePurchasingData.Subscription subscription, ReplaceProductInfo replaceProductInfo, String str, Boolean bool) {
        c.b.a aVarA = c.b.a();
        aVarA.b(subscription.getToken());
        aVarA.c(subscription.getProductDetails());
        c.b bVarA = aVarA.a();
        r.e(bVarA, "newBuilder().apply {\n   …etails)\n        }.build()");
        try {
            c.a aVarD = com.android.billingclient.api.c.a().d(AbstractC0768o.b(bVarA));
            if (replaceProductInfo != null) {
                r.e(aVarD, "buildSubscriptionPurchas…arams$lambda$58$lambda$56");
                BillingFlowParamsExtensionsKt.setUpgradeInfo(aVarD, replaceProductInfo);
                E e4 = E.f5463a;
            } else {
                r.e(aVarD.c(UtilsKt.sha256(str)), "setObfuscatedAccountId(appUserID.sha256())");
            }
            if (bool != null) {
                aVarD.b(bool.booleanValue());
            }
            com.android.billingclient.api.c cVarA = aVarD.a();
            r.e(cVarA, "newBuilder()\n           …                 .build()");
            return new Result.Success(cVarA);
        } catch (NoClassDefFoundError e5) {
            throw new NoCoreLibraryDesugaringException(e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void endConnection$lambda$12(BillingWrapper this$0) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        r.f(this$0, "this$0");
        synchronized (this$0) {
            try {
                com.android.billingclient.api.a aVar = this$0.billingClient;
                if (aVar != null) {
                    LogIntent logIntent = LogIntent.DEBUG;
                    BillingWrapper$endConnection$lambda$12$lambda$11$lambda$10$$inlined$log$1 billingWrapper$endConnection$lambda$12$lambda$11$lambda$10$$inlined$log$1 = new BillingWrapper$endConnection$lambda$12$lambda$11$lambda$10$$inlined$log$1(logIntent, aVar);
                    switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                        case 1:
                            LogLevel logLevel = LogLevel.DEBUG;
                            currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                                str = "[Purchases] - " + logLevel.name();
                                str2 = (String) billingWrapper$endConnection$lambda$12$lambda$11$lambda$10$$inlined$log$1.invoke();
                                currentLogHandler.d(str, str2);
                            }
                            break;
                        case 2:
                            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$endConnection$lambda$12$lambda$11$lambda$10$$inlined$log$1.invoke(), null);
                            break;
                        case 3:
                            LogLevel logLevel2 = LogLevel.WARN;
                            LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                                currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) billingWrapper$endConnection$lambda$12$lambda$11$lambda$10$$inlined$log$1.invoke());
                            }
                            break;
                        case 4:
                            LogLevel logLevel3 = LogLevel.INFO;
                            LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                                currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) billingWrapper$endConnection$lambda$12$lambda$11$lambda$10$$inlined$log$1.invoke());
                            }
                            break;
                        case 5:
                            LogLevel logLevel4 = LogLevel.DEBUG;
                            currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                                str = "[Purchases] - " + logLevel4.name();
                                str2 = (String) billingWrapper$endConnection$lambda$12$lambda$11$lambda$10$$inlined$log$1.invoke();
                                currentLogHandler.d(str, str2);
                            }
                            break;
                        case 6:
                            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$endConnection$lambda$12$lambda$11$lambda$10$$inlined$log$1.invoke(), null);
                            break;
                        case 7:
                            LogLevel logLevel5 = LogLevel.INFO;
                            LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                                currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) billingWrapper$endConnection$lambda$12$lambda$11$lambda$10$$inlined$log$1.invoke());
                            }
                            break;
                        case 8:
                            LogLevel logLevel6 = LogLevel.DEBUG;
                            currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                                str = "[Purchases] - " + logLevel6.name();
                                str2 = (String) billingWrapper$endConnection$lambda$12$lambda$11$lambda$10$$inlined$log$1.invoke();
                                currentLogHandler.d(str, str2);
                            }
                            break;
                        case 9:
                            LogLevel logLevel7 = LogLevel.DEBUG;
                            currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                                str = "[Purchases] - " + logLevel7.name();
                                str2 = (String) billingWrapper$endConnection$lambda$12$lambda$11$lambda$10$$inlined$log$1.invoke();
                                currentLogHandler.d(str, str2);
                            }
                            break;
                        case 10:
                            LogLevel logLevel8 = LogLevel.WARN;
                            LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                                currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) billingWrapper$endConnection$lambda$12$lambda$11$lambda$10$$inlined$log$1.invoke());
                            }
                            break;
                        case 11:
                            LogLevel logLevel9 = LogLevel.WARN;
                            LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                                currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) billingWrapper$endConnection$lambda$12$lambda$11$lambda$10$$inlined$log$1.invoke());
                            }
                            break;
                        case 12:
                            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$endConnection$lambda$12$lambda$11$lambda$10$$inlined$log$1.invoke(), null);
                            break;
                    }
                    aVar.c();
                }
                this$0.billingClient = null;
                E e4 = E.f5463a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void executePendingRequests() {
        o oVarPoll;
        synchronized (this) {
            while (true) {
                try {
                    com.android.billingclient.api.a aVar = this.billingClient;
                    if (aVar == null || !aVar.f() || (oVarPoll = this.serviceRequests.poll()) == null) {
                        break;
                    }
                    r.e(oVarPoll, "poll()");
                    final k kVar = (k) oVarPoll.a();
                    Long l4 = (Long) oVarPoll.b();
                    if (l4 != null) {
                        this.mainHandler.postDelayed(new Runnable() { // from class: com.revenuecat.purchases.google.b
                            @Override // java.lang.Runnable
                            public final void run() {
                                BillingWrapper.executePendingRequests$lambda$3$lambda$2$lambda$0(kVar);
                            }
                        }, l4.longValue());
                    } else {
                        this.mainHandler.post(new Runnable() { // from class: com.revenuecat.purchases.google.c
                            @Override // java.lang.Runnable
                            public final void run() {
                                BillingWrapper.executePendingRequests$lambda$3$lambda$2$lambda$1(kVar);
                            }
                        });
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            E e4 = E.f5463a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void executePendingRequests$lambda$3$lambda$2$lambda$0(k request) {
        r.f(request, "$request");
        request.invoke(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void executePendingRequests$lambda$3$lambda$2$lambda$1(k request) {
        r.f(request, "$request");
        request.invoke(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void executeRequestOnUIThread(Long l4, k kVar) {
        try {
            if (getPurchasesUpdatedListener() != null) {
                this.serviceRequests.add(t.a(kVar, l4));
                com.android.billingclient.api.a aVar = this.billingClient;
                if (aVar == null || aVar.f()) {
                    executePendingRequests();
                } else {
                    BillingAbstract.startConnectionOnMainThread$default(this, 0L, 1, null);
                }
            } else {
                kVar.invoke(new PurchasesError(PurchasesErrorCode.UnknownError, "BillingWrapper is not attached to a listener"));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static /* synthetic */ void executeRequestOnUIThread$default(BillingWrapper billingWrapper, Long l4, k kVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            l4 = null;
        }
        billingWrapper.executeRequestOnUIThread(l4, kVar);
    }

    public static /* synthetic */ void getPurchaseContext$purchases_defaultsRelease$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getStackTrace() {
        StringWriter stringWriter = new StringWriter();
        new Throwable().printStackTrace(new PrintWriter(stringWriter));
        String string = stringWriter.toString();
        r.e(string, "stringWriter.toString()");
        return string;
    }

    private final void getStoreTransaction(Purchase purchase, k kVar) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        LogIntent logIntent = LogIntent.DEBUG;
        BillingWrapper$getStoreTransaction$$inlined$log$1 billingWrapper$getStoreTransaction$$inlined$log$1 = new BillingWrapper$getStoreTransaction$$inlined$log$1(logIntent, purchase);
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    str2 = (String) billingWrapper$getStoreTransaction$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$getStoreTransaction$$inlined$log$1.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) billingWrapper$getStoreTransaction$$inlined$log$1.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) billingWrapper$getStoreTransaction$$inlined$log$1.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    str2 = (String) billingWrapper$getStoreTransaction$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$getStoreTransaction$$inlined$log$1.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) billingWrapper$getStoreTransaction$$inlined$log$1.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    str2 = (String) billingWrapper$getStoreTransaction$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    str2 = (String) billingWrapper$getStoreTransaction$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) billingWrapper$getStoreTransaction$$inlined$log$1.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) billingWrapper$getStoreTransaction$$inlined$log$1.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$getStoreTransaction$$inlined$log$1.invoke(), null);
                break;
        }
        synchronized (this) {
            PurchaseContext purchaseContext = this.purchaseContext.get(PurchaseExtensionsKt.getFirstProductId(purchase));
            if (purchaseContext != null && purchaseContext.getProductType() != null) {
                kVar.invoke(StoreTransactionConversionsKt.toStoreTransaction(purchase, purchaseContext));
                return;
            }
            String strF = purchase.f();
            r.e(strF, "purchase.purchaseToken");
            getPurchaseType$purchases_defaultsRelease(strF, new BillingWrapper$getStoreTransaction$2$2(kVar, purchase));
            E e4 = E.f5463a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void launchBillingFlow(Activity activity, com.android.billingclient.api.c cVar) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        if (activity.getIntent() == null) {
            LogIntent logIntent = LogIntent.WARNING;
            BillingWrapper$launchBillingFlow$$inlined$log$1 billingWrapper$launchBillingFlow$$inlined$log$1 = new BillingWrapper$launchBillingFlow$$inlined$log$1(logIntent);
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                case 1:
                    LogLevel logLevel = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        str = "[Purchases] - " + logLevel.name();
                        str2 = (String) billingWrapper$launchBillingFlow$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$launchBillingFlow$$inlined$log$1.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel2 = LogLevel.WARN;
                    LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) billingWrapper$launchBillingFlow$$inlined$log$1.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel3 = LogLevel.INFO;
                    LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                        currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) billingWrapper$launchBillingFlow$$inlined$log$1.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel4 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                        str = "[Purchases] - " + logLevel4.name();
                        str2 = (String) billingWrapper$launchBillingFlow$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$launchBillingFlow$$inlined$log$1.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel5 = LogLevel.INFO;
                    LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                        currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) billingWrapper$launchBillingFlow$$inlined$log$1.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel6 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                        str = "[Purchases] - " + logLevel6.name();
                        str2 = (String) billingWrapper$launchBillingFlow$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 9:
                    LogLevel logLevel7 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                        str = "[Purchases] - " + logLevel7.name();
                        str2 = (String) billingWrapper$launchBillingFlow$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 10:
                    LogLevel logLevel8 = LogLevel.WARN;
                    LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                        currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) billingWrapper$launchBillingFlow$$inlined$log$1.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel9 = LogLevel.WARN;
                    LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                        currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) billingWrapper$launchBillingFlow$$inlined$log$1.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$launchBillingFlow$$inlined$log$1.invoke(), null);
                    break;
            }
        }
        withConnectedClient(new C11572(activity, cVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBillingSetupFinished$lambda$35(com.android.billingclient.api.d billingResult, BillingWrapper this$0) {
        PurchasesError purchasesErrorBillingResponseToPurchasesError;
        LogHandler currentLogHandler;
        String str;
        String str2;
        r.f(billingResult, "$billingResult");
        r.f(this$0, "this$0");
        int iB = billingResult.b();
        if (iB != 6) {
            if (iB != 7 && iB != 8) {
                if (iB != 12) {
                    switch (iB) {
                        case -2:
                        case 3:
                            String humanReadableDescription = BillingResultExtensionsKt.toHumanReadableDescription(billingResult);
                            if (r.b(billingResult.a(), ErrorsKt.IN_APP_BILLING_LESS_THAN_3_ERROR_MESSAGE)) {
                                String str3 = String.format(BillingStrings.BILLING_UNAVAILABLE_LESS_THAN_3, Arrays.copyOf(new Object[]{humanReadableDescription}, 1));
                                r.e(str3, "format(this, *args)");
                                purchasesErrorBillingResponseToPurchasesError = new PurchasesError(PurchasesErrorCode.StoreProblemError, str3);
                                LogUtilsKt.errorLog(purchasesErrorBillingResponseToPurchasesError);
                            } else {
                                String str4 = String.format(BillingStrings.BILLING_UNAVAILABLE, Arrays.copyOf(new Object[]{humanReadableDescription}, 1));
                                r.e(str4, "format(this, *args)");
                                purchasesErrorBillingResponseToPurchasesError = ErrorsKt.billingResponseToPurchasesError(billingResult.b(), str4);
                                LogUtilsKt.errorLog(purchasesErrorBillingResponseToPurchasesError);
                            }
                            this$0.sendErrorsToAllPendingRequests(purchasesErrorBillingResponseToPurchasesError);
                            break;
                        case 0:
                            LogIntent logIntent = LogIntent.DEBUG;
                            BillingWrapper$onBillingSetupFinished$lambda$35$$inlined$log$1 billingWrapper$onBillingSetupFinished$lambda$35$$inlined$log$1 = new BillingWrapper$onBillingSetupFinished$lambda$35$$inlined$log$1(logIntent, this$0);
                            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                                case 1:
                                    LogLevel logLevel = LogLevel.DEBUG;
                                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                                        str = "[Purchases] - " + logLevel.name();
                                        str2 = (String) billingWrapper$onBillingSetupFinished$lambda$35$$inlined$log$1.invoke();
                                        currentLogHandler.d(str, str2);
                                    }
                                    break;
                                case 2:
                                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$onBillingSetupFinished$lambda$35$$inlined$log$1.invoke(), null);
                                    break;
                                case 3:
                                    LogLevel logLevel2 = LogLevel.WARN;
                                    LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                                        currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) billingWrapper$onBillingSetupFinished$lambda$35$$inlined$log$1.invoke());
                                    }
                                    break;
                                case 4:
                                    LogLevel logLevel3 = LogLevel.INFO;
                                    LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                                        currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) billingWrapper$onBillingSetupFinished$lambda$35$$inlined$log$1.invoke());
                                    }
                                    break;
                                case 5:
                                    LogLevel logLevel4 = LogLevel.DEBUG;
                                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                                        str = "[Purchases] - " + logLevel4.name();
                                        str2 = (String) billingWrapper$onBillingSetupFinished$lambda$35$$inlined$log$1.invoke();
                                        currentLogHandler.d(str, str2);
                                    }
                                    break;
                                case 6:
                                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$onBillingSetupFinished$lambda$35$$inlined$log$1.invoke(), null);
                                    break;
                                case 7:
                                    LogLevel logLevel5 = LogLevel.INFO;
                                    LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                                        currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) billingWrapper$onBillingSetupFinished$lambda$35$$inlined$log$1.invoke());
                                    }
                                    break;
                                case 8:
                                    LogLevel logLevel6 = LogLevel.DEBUG;
                                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                                        str = "[Purchases] - " + logLevel6.name();
                                        str2 = (String) billingWrapper$onBillingSetupFinished$lambda$35$$inlined$log$1.invoke();
                                        currentLogHandler.d(str, str2);
                                    }
                                    break;
                                case 9:
                                    LogLevel logLevel7 = LogLevel.DEBUG;
                                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                                        str = "[Purchases] - " + logLevel7.name();
                                        str2 = (String) billingWrapper$onBillingSetupFinished$lambda$35$$inlined$log$1.invoke();
                                        currentLogHandler.d(str, str2);
                                    }
                                    break;
                                case 10:
                                    LogLevel logLevel8 = LogLevel.WARN;
                                    LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                                        currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) billingWrapper$onBillingSetupFinished$lambda$35$$inlined$log$1.invoke());
                                    }
                                    break;
                                case 11:
                                    LogLevel logLevel9 = LogLevel.WARN;
                                    LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                                        currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) billingWrapper$onBillingSetupFinished$lambda$35$$inlined$log$1.invoke());
                                    }
                                    break;
                                case 12:
                                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$onBillingSetupFinished$lambda$35$$inlined$log$1.invoke(), null);
                                    break;
                            }
                            BillingAbstract.StateListener stateListener = this$0.getStateListener();
                            if (stateListener != null) {
                                stateListener.onConnected();
                            }
                            this$0.executePendingRequests();
                            this$0.reconnectMilliseconds = 1000L;
                            this$0.trackProductDetailsNotSupportedIfNeeded();
                            break;
                    }
                    return;
                }
            }
            LogIntent logIntent2 = LogIntent.GOOGLE_WARNING;
            BillingWrapper$onBillingSetupFinished$lambda$35$$inlined$log$3 billingWrapper$onBillingSetupFinished$lambda$35$$inlined$log$3 = new BillingWrapper$onBillingSetupFinished$lambda$35$$inlined$log$3(logIntent2, billingResult);
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent2.ordinal()]) {
                case 1:
                    LogLevel logLevel10 = LogLevel.DEBUG;
                    LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                        currentLogHandler7.d("[Purchases] - " + logLevel10.name(), (String) billingWrapper$onBillingSetupFinished$lambda$35$$inlined$log$3.invoke());
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$onBillingSetupFinished$lambda$35$$inlined$log$3.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel11 = LogLevel.WARN;
                    LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                        currentLogHandler8.w("[Purchases] - " + logLevel11.name(), (String) billingWrapper$onBillingSetupFinished$lambda$35$$inlined$log$3.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel12 = LogLevel.INFO;
                    LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel12) <= 0) {
                        currentLogHandler9.i("[Purchases] - " + logLevel12.name(), (String) billingWrapper$onBillingSetupFinished$lambda$35$$inlined$log$3.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel13 = LogLevel.DEBUG;
                    LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel13) <= 0) {
                        currentLogHandler10.d("[Purchases] - " + logLevel13.name(), (String) billingWrapper$onBillingSetupFinished$lambda$35$$inlined$log$3.invoke());
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$onBillingSetupFinished$lambda$35$$inlined$log$3.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel14 = LogLevel.INFO;
                    LogHandler currentLogHandler11 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel14) <= 0) {
                        currentLogHandler11.i("[Purchases] - " + logLevel14.name(), (String) billingWrapper$onBillingSetupFinished$lambda$35$$inlined$log$3.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel15 = LogLevel.DEBUG;
                    LogHandler currentLogHandler12 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                        currentLogHandler12.d("[Purchases] - " + logLevel15.name(), (String) billingWrapper$onBillingSetupFinished$lambda$35$$inlined$log$3.invoke());
                    }
                    break;
                case 9:
                    LogLevel logLevel16 = LogLevel.DEBUG;
                    LogHandler currentLogHandler13 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel16) <= 0) {
                        currentLogHandler13.d("[Purchases] - " + logLevel16.name(), (String) billingWrapper$onBillingSetupFinished$lambda$35$$inlined$log$3.invoke());
                    }
                    break;
                case 10:
                    LogLevel logLevel17 = LogLevel.WARN;
                    LogHandler currentLogHandler14 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                        currentLogHandler14.w("[Purchases] - " + logLevel17.name(), (String) billingWrapper$onBillingSetupFinished$lambda$35$$inlined$log$3.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel18 = LogLevel.WARN;
                    LogHandler currentLogHandler15 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel18) <= 0) {
                        currentLogHandler15.w("[Purchases] - " + logLevel18.name(), (String) billingWrapper$onBillingSetupFinished$lambda$35$$inlined$log$3.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$onBillingSetupFinished$lambda$35$$inlined$log$3.invoke(), null);
                    break;
            }
            return;
        }
        LogIntent logIntent3 = LogIntent.GOOGLE_WARNING;
        BillingWrapper$onBillingSetupFinished$lambda$35$$inlined$log$2 billingWrapper$onBillingSetupFinished$lambda$35$$inlined$log$2 = new BillingWrapper$onBillingSetupFinished$lambda$35$$inlined$log$2(logIntent3, billingResult);
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent3.ordinal()]) {
            case 1:
                LogLevel logLevel19 = LogLevel.DEBUG;
                LogHandler currentLogHandler16 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel19) <= 0) {
                    currentLogHandler16.d("[Purchases] - " + logLevel19.name(), (String) billingWrapper$onBillingSetupFinished$lambda$35$$inlined$log$2.invoke());
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$onBillingSetupFinished$lambda$35$$inlined$log$2.invoke(), null);
                break;
            case 3:
                LogLevel logLevel20 = LogLevel.WARN;
                LogHandler currentLogHandler17 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel20) <= 0) {
                    currentLogHandler17.w("[Purchases] - " + logLevel20.name(), (String) billingWrapper$onBillingSetupFinished$lambda$35$$inlined$log$2.invoke());
                }
                break;
            case 4:
                LogLevel logLevel21 = LogLevel.INFO;
                LogHandler currentLogHandler18 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel21) <= 0) {
                    currentLogHandler18.i("[Purchases] - " + logLevel21.name(), (String) billingWrapper$onBillingSetupFinished$lambda$35$$inlined$log$2.invoke());
                }
                break;
            case 5:
                LogLevel logLevel22 = LogLevel.DEBUG;
                LogHandler currentLogHandler19 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel22) <= 0) {
                    currentLogHandler19.d("[Purchases] - " + logLevel22.name(), (String) billingWrapper$onBillingSetupFinished$lambda$35$$inlined$log$2.invoke());
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$onBillingSetupFinished$lambda$35$$inlined$log$2.invoke(), null);
                break;
            case 7:
                LogLevel logLevel23 = LogLevel.INFO;
                LogHandler currentLogHandler20 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel23) <= 0) {
                    currentLogHandler20.i("[Purchases] - " + logLevel23.name(), (String) billingWrapper$onBillingSetupFinished$lambda$35$$inlined$log$2.invoke());
                }
                break;
            case 8:
                LogLevel logLevel24 = LogLevel.DEBUG;
                LogHandler currentLogHandler21 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel24) <= 0) {
                    currentLogHandler21.d("[Purchases] - " + logLevel24.name(), (String) billingWrapper$onBillingSetupFinished$lambda$35$$inlined$log$2.invoke());
                }
                break;
            case 9:
                LogLevel logLevel25 = LogLevel.DEBUG;
                LogHandler currentLogHandler22 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel25) <= 0) {
                    currentLogHandler22.d("[Purchases] - " + logLevel25.name(), (String) billingWrapper$onBillingSetupFinished$lambda$35$$inlined$log$2.invoke());
                }
                break;
            case 10:
                LogLevel logLevel26 = LogLevel.WARN;
                LogHandler currentLogHandler23 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel26) <= 0) {
                    currentLogHandler23.w("[Purchases] - " + logLevel26.name(), (String) billingWrapper$onBillingSetupFinished$lambda$35$$inlined$log$2.invoke());
                }
                break;
            case 11:
                LogLevel logLevel27 = LogLevel.WARN;
                LogHandler currentLogHandler24 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel27) <= 0) {
                    currentLogHandler24.w("[Purchases] - " + logLevel27.name(), (String) billingWrapper$onBillingSetupFinished$lambda$35$$inlined$log$2.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$onBillingSetupFinished$lambda$35$$inlined$log$2.invoke(), null);
                break;
        }
        this$0.retryBillingServiceConnectionWithExponentialBackoff();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void queryPurchaseType(String str, String str2, k kVar, k kVar2) {
        BillingClientUseCase.run$default(new QueryPurchasesByTypeUseCase(new QueryPurchasesByTypeUseCaseParams(this.dateProvider, this.diagnosticsTrackerIfEnabled, getAppInBackground(), str), new C11621(kVar2, str2), new C11632(kVar), new C11643(this), new C11654(this)), 0L, 1, null);
    }

    private final void retryBillingServiceConnectionWithExponentialBackoff() {
        if (this.reconnectionAlreadyScheduled) {
            LogIntent logIntent = LogIntent.WARNING;
            BillingWrapper$retryBillingServiceConnectionWithExponentialBackoff$$inlined$log$1 billingWrapper$retryBillingServiceConnectionWithExponentialBackoff$$inlined$log$1 = new BillingWrapper$retryBillingServiceConnectionWithExponentialBackoff$$inlined$log$1(logIntent);
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                case 1:
                    LogLevel logLevel = LogLevel.DEBUG;
                    LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        currentLogHandler.d("[Purchases] - " + logLevel.name(), (String) billingWrapper$retryBillingServiceConnectionWithExponentialBackoff$$inlined$log$1.invoke());
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$retryBillingServiceConnectionWithExponentialBackoff$$inlined$log$1.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel2 = LogLevel.WARN;
                    LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) billingWrapper$retryBillingServiceConnectionWithExponentialBackoff$$inlined$log$1.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel3 = LogLevel.INFO;
                    LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                        currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) billingWrapper$retryBillingServiceConnectionWithExponentialBackoff$$inlined$log$1.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel4 = LogLevel.DEBUG;
                    LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                        currentLogHandler4.d("[Purchases] - " + logLevel4.name(), (String) billingWrapper$retryBillingServiceConnectionWithExponentialBackoff$$inlined$log$1.invoke());
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$retryBillingServiceConnectionWithExponentialBackoff$$inlined$log$1.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel5 = LogLevel.INFO;
                    LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                        currentLogHandler5.i("[Purchases] - " + logLevel5.name(), (String) billingWrapper$retryBillingServiceConnectionWithExponentialBackoff$$inlined$log$1.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel6 = LogLevel.DEBUG;
                    LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                        currentLogHandler6.d("[Purchases] - " + logLevel6.name(), (String) billingWrapper$retryBillingServiceConnectionWithExponentialBackoff$$inlined$log$1.invoke());
                    }
                    break;
                case 9:
                    LogLevel logLevel7 = LogLevel.DEBUG;
                    LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                        currentLogHandler7.d("[Purchases] - " + logLevel7.name(), (String) billingWrapper$retryBillingServiceConnectionWithExponentialBackoff$$inlined$log$1.invoke());
                    }
                    break;
                case 10:
                    LogLevel logLevel8 = LogLevel.WARN;
                    LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                        currentLogHandler8.w("[Purchases] - " + logLevel8.name(), (String) billingWrapper$retryBillingServiceConnectionWithExponentialBackoff$$inlined$log$1.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel9 = LogLevel.WARN;
                    LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                        currentLogHandler9.w("[Purchases] - " + logLevel9.name(), (String) billingWrapper$retryBillingServiceConnectionWithExponentialBackoff$$inlined$log$1.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$retryBillingServiceConnectionWithExponentialBackoff$$inlined$log$1.invoke(), null);
                    break;
            }
            return;
        }
        LogIntent logIntent2 = LogIntent.WARNING;
        BillingWrapper$retryBillingServiceConnectionWithExponentialBackoff$$inlined$log$2 billingWrapper$retryBillingServiceConnectionWithExponentialBackoff$$inlined$log$2 = new BillingWrapper$retryBillingServiceConnectionWithExponentialBackoff$$inlined$log$2(logIntent2, this);
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent2.ordinal()]) {
            case 1:
                LogLevel logLevel10 = LogLevel.DEBUG;
                LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler10.d("[Purchases] - " + logLevel10.name(), (String) billingWrapper$retryBillingServiceConnectionWithExponentialBackoff$$inlined$log$2.invoke());
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$retryBillingServiceConnectionWithExponentialBackoff$$inlined$log$2.invoke(), null);
                break;
            case 3:
                LogLevel logLevel11 = LogLevel.WARN;
                LogHandler currentLogHandler11 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                    currentLogHandler11.w("[Purchases] - " + logLevel11.name(), (String) billingWrapper$retryBillingServiceConnectionWithExponentialBackoff$$inlined$log$2.invoke());
                }
                break;
            case 4:
                LogLevel logLevel12 = LogLevel.INFO;
                LogHandler currentLogHandler12 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel12) <= 0) {
                    currentLogHandler12.i("[Purchases] - " + logLevel12.name(), (String) billingWrapper$retryBillingServiceConnectionWithExponentialBackoff$$inlined$log$2.invoke());
                }
                break;
            case 5:
                LogLevel logLevel13 = LogLevel.DEBUG;
                LogHandler currentLogHandler13 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel13) <= 0) {
                    currentLogHandler13.d("[Purchases] - " + logLevel13.name(), (String) billingWrapper$retryBillingServiceConnectionWithExponentialBackoff$$inlined$log$2.invoke());
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$retryBillingServiceConnectionWithExponentialBackoff$$inlined$log$2.invoke(), null);
                break;
            case 7:
                LogLevel logLevel14 = LogLevel.INFO;
                LogHandler currentLogHandler14 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel14) <= 0) {
                    currentLogHandler14.i("[Purchases] - " + logLevel14.name(), (String) billingWrapper$retryBillingServiceConnectionWithExponentialBackoff$$inlined$log$2.invoke());
                }
                break;
            case 8:
                LogLevel logLevel15 = LogLevel.DEBUG;
                LogHandler currentLogHandler15 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                    currentLogHandler15.d("[Purchases] - " + logLevel15.name(), (String) billingWrapper$retryBillingServiceConnectionWithExponentialBackoff$$inlined$log$2.invoke());
                }
                break;
            case 9:
                LogLevel logLevel16 = LogLevel.DEBUG;
                LogHandler currentLogHandler16 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel16) <= 0) {
                    currentLogHandler16.d("[Purchases] - " + logLevel16.name(), (String) billingWrapper$retryBillingServiceConnectionWithExponentialBackoff$$inlined$log$2.invoke());
                }
                break;
            case 10:
                LogLevel logLevel17 = LogLevel.WARN;
                LogHandler currentLogHandler17 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                    currentLogHandler17.w("[Purchases] - " + logLevel17.name(), (String) billingWrapper$retryBillingServiceConnectionWithExponentialBackoff$$inlined$log$2.invoke());
                }
                break;
            case 11:
                LogLevel logLevel18 = LogLevel.WARN;
                LogHandler currentLogHandler18 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel18) <= 0) {
                    currentLogHandler18.w("[Purchases] - " + logLevel18.name(), (String) billingWrapper$retryBillingServiceConnectionWithExponentialBackoff$$inlined$log$2.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$retryBillingServiceConnectionWithExponentialBackoff$$inlined$log$2.invoke(), null);
                break;
        }
        this.reconnectionAlreadyScheduled = true;
        startConnectionOnMainThread(this.reconnectMilliseconds);
        this.reconnectMilliseconds = Math.min(this.reconnectMilliseconds * ((long) 2), 900000L);
    }

    private final synchronized void sendErrorsToAllPendingRequests(final PurchasesError purchasesError) {
        while (true) {
            o oVarPoll = this.serviceRequests.poll();
            if (oVarPoll != null) {
                final k kVar = (k) oVarPoll.a();
                this.mainHandler.post(new Runnable() { // from class: com.revenuecat.purchases.google.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        BillingWrapper.sendErrorsToAllPendingRequests$lambda$60$lambda$59(kVar, purchasesError);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendErrorsToAllPendingRequests$lambda$60$lambda$59(k serviceRequest, PurchasesError error) {
        r.f(serviceRequest, "$serviceRequest");
        r.f(error, "$error");
        serviceRequest.invoke(error);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startConnectionOnMainThread$lambda$4(BillingWrapper this$0) {
        r.f(this$0, "this$0");
        this$0.startConnection();
    }

    private final void trackProductDetailsNotSupportedIfNeeded() {
        if (this.diagnosticsTrackerIfEnabled == null) {
            return;
        }
        com.android.billingclient.api.a aVar = this.billingClient;
        com.android.billingclient.api.d dVarE = aVar != null ? aVar.e("fff") : null;
        if (dVarE == null || dVarE.b() != -2) {
            return;
        }
        DiagnosticsTracker diagnosticsTracker = this.diagnosticsTrackerIfEnabled;
        int iB = dVarE.b();
        String strA = dVarE.a();
        r.e(strA, "billingResult.debugMessage");
        diagnosticsTracker.trackProductDetailsNotSupported(iB, strA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void trackPurchaseStartIfNeeded(com.revenuecat.purchases.models.GooglePurchasingData r10, java.lang.String r11) {
        /*
            r9 = this;
            com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker r0 = r9.diagnosticsTrackerIfEnabled
            if (r0 != 0) goto L5
            return
        L5:
            boolean r0 = r10 instanceof com.revenuecat.purchases.models.GooglePurchasingData.Subscription
            r1 = 0
            if (r0 == 0) goto Le
            r0 = r10
            com.revenuecat.purchases.models.GooglePurchasingData$Subscription r0 = (com.revenuecat.purchases.models.GooglePurchasingData.Subscription) r0
            goto Lf
        Le:
            r0 = r1
        Lf:
            if (r0 == 0) goto L50
            com.android.billingclient.api.f r2 = r0.getProductDetails()
            if (r2 == 0) goto L50
            java.util.List r2 = r2.f()
            if (r2 == 0) goto L50
            java.util.Iterator r2 = r2.iterator()
        L21:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L48
            java.lang.Object r3 = r2.next()
            com.android.billingclient.api.f$e r3 = (com.android.billingclient.api.f.e) r3
            java.lang.String r4 = r3.e()
            java.lang.String r5 = r0.getToken()
            boolean r4 = kotlin.jvm.internal.r.b(r4, r5)
            if (r4 == 0) goto L21
            if (r3 == 0) goto L50
            com.android.billingclient.api.f$d r0 = r3.f()
            if (r0 == 0) goto L50
            java.util.List r0 = r0.a()
            goto L51
        L48:
            java.util.NoSuchElementException r10 = new java.util.NoSuchElementException
            java.lang.String r11 = "Collection contains no element matching the predicate."
            r10.<init>(r11)
            throw r10
        L50:
            r0 = r1
        L51:
            r2 = 0
            r4 = 1
            r5 = 0
            if (r0 == 0) goto L7d
            boolean r6 = r0.isEmpty()
            if (r6 == 0) goto L5f
        L5d:
            r6 = r5
            goto L78
        L5f:
            java.util.Iterator r6 = r0.iterator()
        L63:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L5d
            java.lang.Object r7 = r6.next()
            com.android.billingclient.api.f$c r7 = (com.android.billingclient.api.f.c) r7
            long r7 = r7.d()
            int r7 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r7 != 0) goto L63
            r6 = r4
        L78:
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            goto L7e
        L7d:
            r6 = r1
        L7e:
            if (r0 == 0) goto Laa
            java.util.List r0 = X2.x.D(r0, r4)
            if (r0 == 0) goto Laa
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L8e
        L8c:
            r4 = r5
            goto La6
        L8e:
            java.util.Iterator r0 = r0.iterator()
        L92:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L8c
            java.lang.Object r1 = r0.next()
            com.android.billingclient.api.f$c r1 = (com.android.billingclient.api.f.c) r1
            long r7 = r1.d()
            int r1 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r1 <= 0) goto L92
        La6:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r4)
        Laa:
            com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker r0 = r9.diagnosticsTrackerIfEnabled
            java.lang.String r10 = r10.getProductId()
            r0.trackGooglePurchaseStarted(r10, r11, r6, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.google.BillingWrapper.trackPurchaseStartIfNeeded(com.revenuecat.purchases.models.GooglePurchasingData, java.lang.String):void");
    }

    private final void trackPurchaseUpdateReceivedIfNeeded(com.android.billingclient.api.d dVar, List<? extends Purchase> list) {
        ArrayList arrayList;
        DiagnosticsTracker diagnosticsTracker = this.diagnosticsTrackerIfEnabled;
        if (diagnosticsTracker == null) {
            return;
        }
        ArrayList arrayList2 = null;
        if (list != null) {
            arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                List listC = ((Purchase) it.next()).c();
                r.e(listC, "it.products");
                u.t(arrayList, listC);
            }
        } else {
            arrayList = null;
        }
        if (list != null) {
            arrayList2 = new ArrayList(AbstractC0770q.q(list, 10));
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                arrayList2.add(PurchaseStateConversionsKt.toRevenueCatPurchaseState(((Purchase) it2.next()).d()).name());
            }
        }
        int iB = dVar.b();
        String strA = dVar.a();
        r.e(strA, "billingResult.debugMessage");
        diagnosticsTracker.trackGooglePurchaseUpdateReceived(arrayList, arrayList2, iB, strA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void withConnectedClient(i3.k r5) {
        /*
            Method dump skipped, instruction units count: 542
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.google.BillingWrapper.withConnectedClient(i3.k):void");
    }

    public final void acknowledge$purchases_defaultsRelease(String token, PostReceiptInitiationSource initiationSource, k onAcknowledged) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        r.f(token, "token");
        r.f(initiationSource, "initiationSource");
        r.f(onAcknowledged, "onAcknowledged");
        LogIntent logIntent = LogIntent.PURCHASE;
        BillingWrapper$acknowledge$$inlined$log$1 billingWrapper$acknowledge$$inlined$log$1 = new BillingWrapper$acknowledge$$inlined$log$1(logIntent, token);
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    str2 = (String) billingWrapper$acknowledge$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$acknowledge$$inlined$log$1.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) billingWrapper$acknowledge$$inlined$log$1.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) billingWrapper$acknowledge$$inlined$log$1.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    str2 = (String) billingWrapper$acknowledge$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$acknowledge$$inlined$log$1.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) billingWrapper$acknowledge$$inlined$log$1.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    str2 = (String) billingWrapper$acknowledge$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    str2 = (String) billingWrapper$acknowledge$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) billingWrapper$acknowledge$$inlined$log$1.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) billingWrapper$acknowledge$$inlined$log$1.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$acknowledge$$inlined$log$1.invoke(), null);
                break;
        }
        BillingClientUseCase.run$default(new AcknowledgePurchaseUseCase(new AcknowledgePurchaseUseCaseParams(token, initiationSource, getAppInBackground()), onAcknowledged, BillingWrapper$acknowledge$2.INSTANCE, new BillingWrapper$acknowledge$3(this), new BillingWrapper$acknowledge$4(this)), 0L, 1, null);
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void consumeAndSave(boolean z4, StoreTransaction purchase, boolean z5, PostReceiptInitiationSource initiationSource) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        r.f(purchase, "purchase");
        r.f(initiationSource, "initiationSource");
        if (purchase.getType() == ProductType.UNKNOWN || purchase.getPurchaseState() == PurchaseState.PENDING) {
            return;
        }
        Purchase originalGooglePurchase = StoreTransactionConversionsKt.getOriginalGooglePurchase(purchase);
        boolean zH = originalGooglePurchase != null ? originalGooglePurchase.h() : false;
        if (purchase.getType() != ProductType.INAPP) {
            if (!z4 || zH) {
                this.deviceCache.addSuccessfullyPostedToken(purchase.getPurchaseToken());
                return;
            } else {
                acknowledge$purchases_defaultsRelease(purchase.getPurchaseToken(), initiationSource, new AnonymousClass4(this.deviceCache));
                return;
            }
        }
        if (z4 && z5) {
            consumePurchase$purchases_defaultsRelease(purchase.getPurchaseToken(), initiationSource, new AnonymousClass1(this.deviceCache));
            return;
        }
        if (!z4 || zH) {
            this.deviceCache.addSuccessfullyPostedToken(purchase.getPurchaseToken());
            return;
        }
        LogIntent logIntent = LogIntent.PURCHASE;
        BillingWrapper$consumeAndSave$$inlined$log$1 billingWrapper$consumeAndSave$$inlined$log$1 = new BillingWrapper$consumeAndSave$$inlined$log$1(logIntent);
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    str2 = (String) billingWrapper$consumeAndSave$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$consumeAndSave$$inlined$log$1.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) billingWrapper$consumeAndSave$$inlined$log$1.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) billingWrapper$consumeAndSave$$inlined$log$1.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    str2 = (String) billingWrapper$consumeAndSave$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$consumeAndSave$$inlined$log$1.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) billingWrapper$consumeAndSave$$inlined$log$1.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    str2 = (String) billingWrapper$consumeAndSave$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    str2 = (String) billingWrapper$consumeAndSave$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) billingWrapper$consumeAndSave$$inlined$log$1.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) billingWrapper$consumeAndSave$$inlined$log$1.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$consumeAndSave$$inlined$log$1.invoke(), null);
                break;
        }
        acknowledge$purchases_defaultsRelease(purchase.getPurchaseToken(), initiationSource, new AnonymousClass3(this.deviceCache));
    }

    public final void consumePurchase$purchases_defaultsRelease(String token, PostReceiptInitiationSource initiationSource, k onConsumed) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        r.f(token, "token");
        r.f(initiationSource, "initiationSource");
        r.f(onConsumed, "onConsumed");
        LogIntent logIntent = LogIntent.PURCHASE;
        BillingWrapper$consumePurchase$$inlined$log$1 billingWrapper$consumePurchase$$inlined$log$1 = new BillingWrapper$consumePurchase$$inlined$log$1(logIntent, token);
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    str2 = (String) billingWrapper$consumePurchase$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$consumePurchase$$inlined$log$1.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) billingWrapper$consumePurchase$$inlined$log$1.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) billingWrapper$consumePurchase$$inlined$log$1.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    str2 = (String) billingWrapper$consumePurchase$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$consumePurchase$$inlined$log$1.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) billingWrapper$consumePurchase$$inlined$log$1.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    str2 = (String) billingWrapper$consumePurchase$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    str2 = (String) billingWrapper$consumePurchase$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) billingWrapper$consumePurchase$$inlined$log$1.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) billingWrapper$consumePurchase$$inlined$log$1.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$consumePurchase$$inlined$log$1.invoke(), null);
                break;
        }
        BillingClientUseCase.run$default(new ConsumePurchaseUseCase(new ConsumePurchaseUseCaseParams(token, initiationSource, getAppInBackground()), onConsumed, BillingWrapper$consumePurchase$2.INSTANCE, new BillingWrapper$consumePurchase$3(this), new BillingWrapper$consumePurchase$4(this)), 0L, 1, null);
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void endConnection() {
        this.mainHandler.post(new Runnable() { // from class: com.revenuecat.purchases.google.d
            @Override // java.lang.Runnable
            public final void run() {
                BillingWrapper.endConnection$lambda$12(this.f11321a);
            }
        });
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void findPurchaseInPurchaseHistory(String appUserID, ProductType productType, String productId, k onCompletion, k onError) {
        k kVar;
        LogHandler currentLogHandler;
        String str;
        String str2;
        r.f(appUserID, "appUserID");
        r.f(productType, "productType");
        r.f(productId, "productId");
        r.f(onCompletion, "onCompletion");
        r.f(onError, "onError");
        LogIntent logIntent = LogIntent.DEBUG;
        BillingWrapper$findPurchaseInPurchaseHistory$$inlined$log$1 billingWrapper$findPurchaseInPurchaseHistory$$inlined$log$1 = new BillingWrapper$findPurchaseInPurchaseHistory$$inlined$log$1(logIntent, productId, productType);
        E e4 = null;
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    str2 = (String) billingWrapper$findPurchaseInPurchaseHistory$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$findPurchaseInPurchaseHistory$$inlined$log$1.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) billingWrapper$findPurchaseInPurchaseHistory$$inlined$log$1.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) billingWrapper$findPurchaseInPurchaseHistory$$inlined$log$1.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    str2 = (String) billingWrapper$findPurchaseInPurchaseHistory$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$findPurchaseInPurchaseHistory$$inlined$log$1.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) billingWrapper$findPurchaseInPurchaseHistory$$inlined$log$1.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    str2 = (String) billingWrapper$findPurchaseInPurchaseHistory$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    str2 = (String) billingWrapper$findPurchaseInPurchaseHistory$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) billingWrapper$findPurchaseInPurchaseHistory$$inlined$log$1.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) billingWrapper$findPurchaseInPurchaseHistory$$inlined$log$1.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$findPurchaseInPurchaseHistory$$inlined$log$1.invoke(), null);
                break;
        }
        String googleProductType = ProductTypeConversionsKt.toGoogleProductType(productType);
        if (googleProductType != null) {
            kVar = onError;
            BillingClientUseCase.run$default(new QueryPurchaseHistoryUseCase(new QueryPurchaseHistoryUseCaseParams(this.dateProvider, this.diagnosticsTrackerIfEnabled, googleProductType, getAppInBackground()), new BillingWrapper$findPurchaseInPurchaseHistory$2$1(productType, onCompletion, productId, onError), kVar, new BillingWrapper$findPurchaseInPurchaseHistory$2$2(this), new BillingWrapper$findPurchaseInPurchaseHistory$2$3(this)), 0L, 1, null);
            e4 = E.f5463a;
        } else {
            kVar = onError;
        }
        if (e4 == null) {
            kVar.invoke(new PurchasesError(PurchasesErrorCode.PurchaseInvalidError, PurchaseStrings.NOT_RECOGNIZED_PRODUCT_TYPE));
        }
    }

    public final boolean getAppInBackground() {
        return getPurchasesStateProvider().getPurchasesState().getAppInBackground();
    }

    public final synchronized com.android.billingclient.api.a getBillingClient() {
        return this.billingClient;
    }

    public final Map<String, PurchaseContext> getPurchaseContext$purchases_defaultsRelease() {
        return this.purchaseContext;
    }

    public final void getPurchaseType$purchases_defaultsRelease(String purchaseToken, k listener) {
        r.f(purchaseToken, "purchaseToken");
        r.f(listener, "listener");
        queryPurchaseType("subs", purchaseToken, listener, new BillingWrapper$getPurchaseType$1(listener, this, purchaseToken));
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void getStorefront(k onSuccess, k onError) {
        r.f(onSuccess, "onSuccess");
        r.f(onError, "onError");
        LogLevel logLevel = LogLevel.VERBOSE;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.v("[Purchases] - " + logLevel.name(), BillingStrings.BILLING_INITIATE_GETTING_COUNTRY_CODE);
        }
        BillingClientUseCase.run$default(new GetBillingConfigUseCase(new GetBillingConfigUseCaseParams(getAppInBackground()), this.deviceCache, new AnonymousClass2(onSuccess), onError, new C11553(this), new C11564(this)), 0L, 1, null);
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public boolean isConnected() {
        com.android.billingclient.api.a aVar = this.billingClient;
        if (aVar != null) {
            return aVar.f();
        }
        return false;
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void makePurchaseAsync(Activity activity, String appUserID, PurchasingData purchasingData, ReplaceProductInfo replaceProductInfo, PresentedOfferingContext presentedOfferingContext, Boolean bool) {
        String optionId;
        ReplacementMode replacementMode;
        LogHandler currentLogHandler;
        String str;
        String str2;
        r.f(activity, "activity");
        r.f(appUserID, "appUserID");
        r.f(purchasingData, "purchasingData");
        GooglePurchasingData googlePurchasingData = purchasingData instanceof GooglePurchasingData ? (GooglePurchasingData) purchasingData : null;
        if (googlePurchasingData == null) {
            PurchasesErrorCode purchasesErrorCode = PurchasesErrorCode.UnknownError;
            String str3 = String.format(PurchaseStrings.INVALID_PURCHASE_TYPE, Arrays.copyOf(new Object[]{"Play", "GooglePurchasingData"}, 2));
            r.e(str3, "format(this, *args)");
            PurchasesError purchasesError = new PurchasesError(purchasesErrorCode, str3);
            LogUtilsKt.errorLog(purchasesError);
            BillingAbstract.PurchasesUpdatedListener purchasesUpdatedListener = getPurchasesUpdatedListener();
            if (purchasesUpdatedListener != null) {
                purchasesUpdatedListener.onPurchasesFailedToUpdate(purchasesError);
                return;
            }
            return;
        }
        if (googlePurchasingData instanceof GooglePurchasingData.InAppProduct) {
            optionId = null;
        } else {
            if (!(googlePurchasingData instanceof GooglePurchasingData.Subscription)) {
                throw new m();
            }
            optionId = ((GooglePurchasingData.Subscription) googlePurchasingData).getOptionId();
        }
        if (replaceProductInfo != null) {
            LogIntent logIntent = LogIntent.PURCHASE;
            BillingWrapper$makePurchaseAsync$$inlined$log$1 billingWrapper$makePurchaseAsync$$inlined$log$1 = new BillingWrapper$makePurchaseAsync$$inlined$log$1(logIntent, replaceProductInfo, googlePurchasingData);
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                case 1:
                    LogLevel logLevel = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        str = "[Purchases] - " + logLevel.name();
                        str2 = (String) billingWrapper$makePurchaseAsync$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$makePurchaseAsync$$inlined$log$1.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel2 = LogLevel.WARN;
                    LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) billingWrapper$makePurchaseAsync$$inlined$log$1.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel3 = LogLevel.INFO;
                    LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                        currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) billingWrapper$makePurchaseAsync$$inlined$log$1.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel4 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                        str = "[Purchases] - " + logLevel4.name();
                        str2 = (String) billingWrapper$makePurchaseAsync$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$makePurchaseAsync$$inlined$log$1.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel5 = LogLevel.INFO;
                    LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                        currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) billingWrapper$makePurchaseAsync$$inlined$log$1.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel6 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                        str = "[Purchases] - " + logLevel6.name();
                        str2 = (String) billingWrapper$makePurchaseAsync$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 9:
                    LogLevel logLevel7 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                        str = "[Purchases] - " + logLevel7.name();
                        str2 = (String) billingWrapper$makePurchaseAsync$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 10:
                    LogLevel logLevel8 = LogLevel.WARN;
                    LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                        currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) billingWrapper$makePurchaseAsync$$inlined$log$1.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel9 = LogLevel.WARN;
                    LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                        currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) billingWrapper$makePurchaseAsync$$inlined$log$1.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$makePurchaseAsync$$inlined$log$1.invoke(), null);
                    break;
            }
        } else {
            LogIntent logIntent2 = LogIntent.PURCHASE;
            BillingWrapper$makePurchaseAsync$$inlined$log$2 billingWrapper$makePurchaseAsync$$inlined$log$2 = new BillingWrapper$makePurchaseAsync$$inlined$log$2(logIntent2, googlePurchasingData);
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent2.ordinal()]) {
                case 1:
                    LogLevel logLevel10 = LogLevel.DEBUG;
                    LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                        currentLogHandler7.d("[Purchases] - " + logLevel10.name(), (String) billingWrapper$makePurchaseAsync$$inlined$log$2.invoke());
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$makePurchaseAsync$$inlined$log$2.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel11 = LogLevel.WARN;
                    LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                        currentLogHandler8.w("[Purchases] - " + logLevel11.name(), (String) billingWrapper$makePurchaseAsync$$inlined$log$2.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel12 = LogLevel.INFO;
                    LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel12) <= 0) {
                        currentLogHandler9.i("[Purchases] - " + logLevel12.name(), (String) billingWrapper$makePurchaseAsync$$inlined$log$2.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel13 = LogLevel.DEBUG;
                    LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel13) <= 0) {
                        currentLogHandler10.d("[Purchases] - " + logLevel13.name(), (String) billingWrapper$makePurchaseAsync$$inlined$log$2.invoke());
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$makePurchaseAsync$$inlined$log$2.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel14 = LogLevel.INFO;
                    LogHandler currentLogHandler11 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel14) <= 0) {
                        currentLogHandler11.i("[Purchases] - " + logLevel14.name(), (String) billingWrapper$makePurchaseAsync$$inlined$log$2.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel15 = LogLevel.DEBUG;
                    LogHandler currentLogHandler12 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                        currentLogHandler12.d("[Purchases] - " + logLevel15.name(), (String) billingWrapper$makePurchaseAsync$$inlined$log$2.invoke());
                    }
                    break;
                case 9:
                    LogLevel logLevel16 = LogLevel.DEBUG;
                    LogHandler currentLogHandler13 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel16) <= 0) {
                        currentLogHandler13.d("[Purchases] - " + logLevel16.name(), (String) billingWrapper$makePurchaseAsync$$inlined$log$2.invoke());
                    }
                    break;
                case 10:
                    LogLevel logLevel17 = LogLevel.WARN;
                    LogHandler currentLogHandler14 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                        currentLogHandler14.w("[Purchases] - " + logLevel17.name(), (String) billingWrapper$makePurchaseAsync$$inlined$log$2.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel18 = LogLevel.WARN;
                    LogHandler currentLogHandler15 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel18) <= 0) {
                        currentLogHandler15.w("[Purchases] - " + logLevel18.name(), (String) billingWrapper$makePurchaseAsync$$inlined$log$2.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$makePurchaseAsync$$inlined$log$2.invoke(), null);
                    break;
            }
        }
        synchronized (this) {
            if (replaceProductInfo != null) {
                try {
                    replacementMode = replaceProductInfo.getReplacementMode();
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                replacementMode = null;
            }
            String productId = replacementMode == GoogleReplacementMode.DEFERRED ? (String) x.H(replaceProductInfo.getOldPurchase().getProductIds()) : googlePurchasingData.getProductId();
            Map<String, PurchaseContext> map = this.purchaseContext;
            ProductType productType = googlePurchasingData.getProductType();
            ReplacementMode replacementMode2 = replaceProductInfo != null ? replaceProductInfo.getReplacementMode() : null;
            map.put(productId, new PurchaseContext(productType, presentedOfferingContext, optionId, replacementMode2 instanceof GoogleReplacementMode ? (GoogleReplacementMode) replacementMode2 : null));
            E e4 = E.f5463a;
        }
        executeRequestOnUIThread$default(this, null, new C11584(purchasingData, replaceProductInfo, appUserID, bool, googlePurchasingData, activity), 1, null);
    }

    @Override // H0.InterfaceC0296c
    public void onBillingServiceDisconnected() {
        LogHandler currentLogHandler;
        String str;
        String str2;
        LogIntent logIntent = LogIntent.WARNING;
        BillingWrapper$onBillingServiceDisconnected$$inlined$log$1 billingWrapper$onBillingServiceDisconnected$$inlined$log$1 = new BillingWrapper$onBillingServiceDisconnected$$inlined$log$1(logIntent, this);
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    str2 = (String) billingWrapper$onBillingServiceDisconnected$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$onBillingServiceDisconnected$$inlined$log$1.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) billingWrapper$onBillingServiceDisconnected$$inlined$log$1.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) billingWrapper$onBillingServiceDisconnected$$inlined$log$1.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    str2 = (String) billingWrapper$onBillingServiceDisconnected$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$onBillingServiceDisconnected$$inlined$log$1.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) billingWrapper$onBillingServiceDisconnected$$inlined$log$1.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    str2 = (String) billingWrapper$onBillingServiceDisconnected$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    str2 = (String) billingWrapper$onBillingServiceDisconnected$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) billingWrapper$onBillingServiceDisconnected$$inlined$log$1.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) billingWrapper$onBillingServiceDisconnected$$inlined$log$1.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$onBillingServiceDisconnected$$inlined$log$1.invoke(), null);
                break;
        }
        DiagnosticsTracker diagnosticsTracker = this.diagnosticsTrackerIfEnabled;
        if (diagnosticsTracker != null) {
            diagnosticsTracker.trackGoogleBillingServiceDisconnected();
        }
    }

    @Override // H0.InterfaceC0296c
    public void onBillingSetupFinished(final com.android.billingclient.api.d billingResult) {
        r.f(billingResult, "billingResult");
        DiagnosticsTracker diagnosticsTracker = this.diagnosticsTrackerIfEnabled;
        if (diagnosticsTracker != null) {
            int iB = billingResult.b();
            String strA = billingResult.a();
            r.e(strA, "billingResult.debugMessage");
            diagnosticsTracker.trackGoogleBillingSetupFinished(iB, strA, l.g(l.j(x.B(this.serviceRequests), 100)));
        }
        this.mainHandler.post(new Runnable() { // from class: com.revenuecat.purchases.google.a
            @Override // java.lang.Runnable
            public final void run() {
                BillingWrapper.onBillingSetupFinished$lambda$35(billingResult, this);
            }
        });
    }

    @Override // H0.InterfaceC0313o
    public void onPurchasesUpdated(com.android.billingclient.api.d billingResult, List<? extends Purchase> list) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        r.f(billingResult, "billingResult");
        trackPurchaseUpdateReceivedIfNeeded(billingResult, list);
        List<? extends Purchase> listG = list == null ? AbstractC0769p.g() : list;
        if (billingResult.b() == 0 && !listG.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = listG.iterator();
            while (it.hasNext()) {
                getStoreTransaction((Purchase) it.next(), new BillingWrapper$onPurchasesUpdated$1$1(arrayList, listG, this));
            }
            return;
        }
        LogIntent logIntent = LogIntent.GOOGLE_ERROR;
        BillingWrapper$onPurchasesUpdated$$inlined$log$1 billingWrapper$onPurchasesUpdated$$inlined$log$1 = new BillingWrapper$onPurchasesUpdated$$inlined$log$1(logIntent, billingResult, listG);
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    str2 = (String) billingWrapper$onPurchasesUpdated$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$onPurchasesUpdated$$inlined$log$1.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) billingWrapper$onPurchasesUpdated$$inlined$log$1.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) billingWrapper$onPurchasesUpdated$$inlined$log$1.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    str2 = (String) billingWrapper$onPurchasesUpdated$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$onPurchasesUpdated$$inlined$log$1.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) billingWrapper$onPurchasesUpdated$$inlined$log$1.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    str2 = (String) billingWrapper$onPurchasesUpdated$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    str2 = (String) billingWrapper$onPurchasesUpdated$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) billingWrapper$onPurchasesUpdated$$inlined$log$1.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) billingWrapper$onPurchasesUpdated$$inlined$log$1.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$onPurchasesUpdated$$inlined$log$1.invoke(), null);
                break;
        }
        String str3 = "Error updating purchases. " + BillingResultExtensionsKt.toHumanReadableDescription(billingResult);
        int iB = billingResult.b();
        if (list == null && billingResult.b() == 0) {
            str3 = "Error: onPurchasesUpdated received an OK BillingResult with a Null purchases list.";
            iB = 6;
        }
        PurchasesError purchasesErrorBillingResponseToPurchasesError = ErrorsKt.billingResponseToPurchasesError(iB, str3);
        LogUtilsKt.errorLog(purchasesErrorBillingResponseToPurchasesError);
        BillingAbstract.PurchasesUpdatedListener purchasesUpdatedListener = getPurchasesUpdatedListener();
        if (purchasesUpdatedListener != null) {
            purchasesUpdatedListener.onPurchasesFailedToUpdate(purchasesErrorBillingResponseToPurchasesError);
        }
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void queryAllPurchases(String appUserID, k onReceivePurchaseHistory, k onReceivePurchaseHistoryError) {
        r.f(appUserID, "appUserID");
        r.f(onReceivePurchaseHistory, "onReceivePurchaseHistory");
        r.f(onReceivePurchaseHistoryError, "onReceivePurchaseHistoryError");
        queryPurchaseHistoryAsync("subs", new C11591(onReceivePurchaseHistoryError, onReceivePurchaseHistory), onReceivePurchaseHistoryError);
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void queryProductDetailsAsync(ProductType productType, Set<String> productIds, k onReceive, k onError) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        r.f(productType, "productType");
        r.f(productIds, "productIds");
        r.f(onReceive, "onReceive");
        r.f(onError, "onError");
        LogIntent logIntent = LogIntent.DEBUG;
        BillingWrapper$queryProductDetailsAsync$$inlined$log$1 billingWrapper$queryProductDetailsAsync$$inlined$log$1 = new BillingWrapper$queryProductDetailsAsync$$inlined$log$1(logIntent, productIds);
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    str2 = (String) billingWrapper$queryProductDetailsAsync$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$queryProductDetailsAsync$$inlined$log$1.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) billingWrapper$queryProductDetailsAsync$$inlined$log$1.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) billingWrapper$queryProductDetailsAsync$$inlined$log$1.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    str2 = (String) billingWrapper$queryProductDetailsAsync$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$queryProductDetailsAsync$$inlined$log$1.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) billingWrapper$queryProductDetailsAsync$$inlined$log$1.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    str2 = (String) billingWrapper$queryProductDetailsAsync$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    str2 = (String) billingWrapper$queryProductDetailsAsync$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) billingWrapper$queryProductDetailsAsync$$inlined$log$1.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) billingWrapper$queryProductDetailsAsync$$inlined$log$1.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$queryProductDetailsAsync$$inlined$log$1.invoke(), null);
                break;
        }
        BillingClientUseCase.run$default(new QueryProductDetailsUseCase(new QueryProductDetailsUseCaseParams(this.dateProvider, this.diagnosticsTrackerIfEnabled, productIds, productType, getAppInBackground()), onReceive, onError, new BillingWrapper$queryProductDetailsAsync$useCase$1(this), new BillingWrapper$queryProductDetailsAsync$useCase$2(this)), 0L, 1, null);
    }

    public final void queryPurchaseHistoryAsync(String productType, k onReceivePurchaseHistory, k onReceivePurchaseHistoryError) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        r.f(productType, "productType");
        r.f(onReceivePurchaseHistory, "onReceivePurchaseHistory");
        r.f(onReceivePurchaseHistoryError, "onReceivePurchaseHistoryError");
        LogIntent logIntent = LogIntent.DEBUG;
        BillingWrapper$queryPurchaseHistoryAsync$$inlined$log$1 billingWrapper$queryPurchaseHistoryAsync$$inlined$log$1 = new BillingWrapper$queryPurchaseHistoryAsync$$inlined$log$1(logIntent, productType);
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    str2 = (String) billingWrapper$queryPurchaseHistoryAsync$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$queryPurchaseHistoryAsync$$inlined$log$1.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) billingWrapper$queryPurchaseHistoryAsync$$inlined$log$1.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) billingWrapper$queryPurchaseHistoryAsync$$inlined$log$1.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    str2 = (String) billingWrapper$queryPurchaseHistoryAsync$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$queryPurchaseHistoryAsync$$inlined$log$1.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) billingWrapper$queryPurchaseHistoryAsync$$inlined$log$1.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    str2 = (String) billingWrapper$queryPurchaseHistoryAsync$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    str2 = (String) billingWrapper$queryPurchaseHistoryAsync$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) billingWrapper$queryPurchaseHistoryAsync$$inlined$log$1.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) billingWrapper$queryPurchaseHistoryAsync$$inlined$log$1.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$queryPurchaseHistoryAsync$$inlined$log$1.invoke(), null);
                break;
        }
        BillingClientUseCase.run$default(new QueryPurchaseHistoryUseCase(new QueryPurchaseHistoryUseCaseParams(this.dateProvider, this.diagnosticsTrackerIfEnabled, productType, getAppInBackground()), onReceivePurchaseHistory, onReceivePurchaseHistoryError, new C11602(this), new C11613(this)), 0L, 1, null);
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void queryPurchases(String appUserID, k onSuccess, k onError) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        r.f(appUserID, "appUserID");
        r.f(onSuccess, "onSuccess");
        r.f(onError, "onError");
        LogIntent logIntent = LogIntent.DEBUG;
        BillingWrapper$queryPurchases$$inlined$log$1 billingWrapper$queryPurchases$$inlined$log$1 = new BillingWrapper$queryPurchases$$inlined$log$1(logIntent);
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    str2 = (String) billingWrapper$queryPurchases$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$queryPurchases$$inlined$log$1.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) billingWrapper$queryPurchases$$inlined$log$1.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) billingWrapper$queryPurchases$$inlined$log$1.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    str2 = (String) billingWrapper$queryPurchases$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$queryPurchases$$inlined$log$1.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) billingWrapper$queryPurchases$$inlined$log$1.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    str2 = (String) billingWrapper$queryPurchases$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    str2 = (String) billingWrapper$queryPurchases$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) billingWrapper$queryPurchases$$inlined$log$1.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) billingWrapper$queryPurchases$$inlined$log$1.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$queryPurchases$$inlined$log$1.invoke(), null);
                break;
        }
        BillingClientUseCase.run$default(new QueryPurchasesUseCase(new QueryPurchasesUseCaseParams(this.dateProvider, this.diagnosticsTrackerIfEnabled, getAppInBackground()), onSuccess, onError, new C11662(this), new C11673(this)), 0L, 1, null);
    }

    public final synchronized void setBillingClient(com.android.billingclient.api.a aVar) {
        this.billingClient = aVar;
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void showInAppMessagesIfNeeded(Activity activity, List<? extends InAppMessageType> inAppMessageTypes, Function0 subscriptionStatusChange) {
        r.f(activity, "activity");
        r.f(inAppMessageTypes, "inAppMessageTypes");
        r.f(subscriptionStatusChange, "subscriptionStatusChange");
        if (inAppMessageTypes.isEmpty()) {
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", BillingStrings.BILLING_UNSPECIFIED_INAPP_MESSAGE_TYPES, null);
            return;
        }
        C0307i.a aVarA = C0307i.a();
        r.e(aVarA, "newBuilder()");
        Iterator<? extends InAppMessageType> it = inAppMessageTypes.iterator();
        while (it.hasNext()) {
            aVarA.a(it.next().getInAppMessageCategoryId$purchases_defaultsRelease());
        }
        C0307i c0307iB = aVarA.b();
        r.e(c0307iB, "inAppMessageParamsBuilder.build()");
        executeRequestOnUIThread$default(this, null, new C11682(new WeakReference(activity), c0307iB, subscriptionStatusChange), 1, null);
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void startConnection() {
        LogHandler currentLogHandler;
        String str;
        String str2;
        synchronized (this) {
            try {
                if (this.billingClient == null) {
                    this.billingClient = this.clientFactory.buildClient(this);
                }
                this.reconnectionAlreadyScheduled = false;
                com.android.billingclient.api.a aVar = this.billingClient;
                if (aVar != null) {
                    if (!aVar.f()) {
                        LogIntent logIntent = LogIntent.DEBUG;
                        BillingWrapper$startConnection$lambda$8$lambda$7$$inlined$log$1 billingWrapper$startConnection$lambda$8$lambda$7$$inlined$log$1 = new BillingWrapper$startConnection$lambda$8$lambda$7$$inlined$log$1(logIntent, aVar);
                        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                            case 1:
                                LogLevel logLevel = LogLevel.DEBUG;
                                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                                    str = "[Purchases] - " + logLevel.name();
                                    str2 = (String) billingWrapper$startConnection$lambda$8$lambda$7$$inlined$log$1.invoke();
                                    currentLogHandler.d(str, str2);
                                }
                                break;
                            case 2:
                                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$startConnection$lambda$8$lambda$7$$inlined$log$1.invoke(), null);
                                break;
                            case 3:
                                LogLevel logLevel2 = LogLevel.WARN;
                                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) billingWrapper$startConnection$lambda$8$lambda$7$$inlined$log$1.invoke());
                                }
                                break;
                            case 4:
                                LogLevel logLevel3 = LogLevel.INFO;
                                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) billingWrapper$startConnection$lambda$8$lambda$7$$inlined$log$1.invoke());
                                }
                                break;
                            case 5:
                                LogLevel logLevel4 = LogLevel.DEBUG;
                                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                                    str = "[Purchases] - " + logLevel4.name();
                                    str2 = (String) billingWrapper$startConnection$lambda$8$lambda$7$$inlined$log$1.invoke();
                                    currentLogHandler.d(str, str2);
                                }
                                break;
                            case 6:
                                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$startConnection$lambda$8$lambda$7$$inlined$log$1.invoke(), null);
                                break;
                            case 7:
                                LogLevel logLevel5 = LogLevel.INFO;
                                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) billingWrapper$startConnection$lambda$8$lambda$7$$inlined$log$1.invoke());
                                }
                                break;
                            case 8:
                                LogLevel logLevel6 = LogLevel.DEBUG;
                                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                                    str = "[Purchases] - " + logLevel6.name();
                                    str2 = (String) billingWrapper$startConnection$lambda$8$lambda$7$$inlined$log$1.invoke();
                                    currentLogHandler.d(str, str2);
                                }
                                break;
                            case 9:
                                LogLevel logLevel7 = LogLevel.DEBUG;
                                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                                    str = "[Purchases] - " + logLevel7.name();
                                    str2 = (String) billingWrapper$startConnection$lambda$8$lambda$7$$inlined$log$1.invoke();
                                    currentLogHandler.d(str, str2);
                                }
                                break;
                            case 10:
                                LogLevel logLevel8 = LogLevel.WARN;
                                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) billingWrapper$startConnection$lambda$8$lambda$7$$inlined$log$1.invoke());
                                }
                                break;
                            case 11:
                                LogLevel logLevel9 = LogLevel.WARN;
                                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) billingWrapper$startConnection$lambda$8$lambda$7$$inlined$log$1.invoke());
                                }
                                break;
                            case 12:
                                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$startConnection$lambda$8$lambda$7$$inlined$log$1.invoke(), null);
                                break;
                        }
                        DiagnosticsTracker diagnosticsTracker = this.diagnosticsTrackerIfEnabled;
                        if (diagnosticsTracker != null) {
                            diagnosticsTracker.trackGoogleBillingStartConnection();
                        }
                        try {
                            aVar.m(this);
                        } catch (IllegalStateException e4) {
                            LogIntent logIntent2 = LogIntent.GOOGLE_ERROR;
                            BillingWrapper$startConnection$lambda$8$lambda$7$$inlined$log$2 billingWrapper$startConnection$lambda$8$lambda$7$$inlined$log$2 = new BillingWrapper$startConnection$lambda$8$lambda$7$$inlined$log$2(logIntent2, e4);
                            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent2.ordinal()]) {
                                case 1:
                                    LogLevel logLevel10 = LogLevel.DEBUG;
                                    LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                                        currentLogHandler7.d("[Purchases] - " + logLevel10.name(), (String) billingWrapper$startConnection$lambda$8$lambda$7$$inlined$log$2.invoke());
                                    }
                                    break;
                                case 2:
                                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$startConnection$lambda$8$lambda$7$$inlined$log$2.invoke(), null);
                                    break;
                                case 3:
                                    LogLevel logLevel11 = LogLevel.WARN;
                                    LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                                        currentLogHandler8.w("[Purchases] - " + logLevel11.name(), (String) billingWrapper$startConnection$lambda$8$lambda$7$$inlined$log$2.invoke());
                                    }
                                    break;
                                case 4:
                                    LogLevel logLevel12 = LogLevel.INFO;
                                    LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel12) <= 0) {
                                        currentLogHandler9.i("[Purchases] - " + logLevel12.name(), (String) billingWrapper$startConnection$lambda$8$lambda$7$$inlined$log$2.invoke());
                                    }
                                    break;
                                case 5:
                                    LogLevel logLevel13 = LogLevel.DEBUG;
                                    LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel13) <= 0) {
                                        currentLogHandler10.d("[Purchases] - " + logLevel13.name(), (String) billingWrapper$startConnection$lambda$8$lambda$7$$inlined$log$2.invoke());
                                    }
                                    break;
                                case 6:
                                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$startConnection$lambda$8$lambda$7$$inlined$log$2.invoke(), null);
                                    break;
                                case 7:
                                    LogLevel logLevel14 = LogLevel.INFO;
                                    LogHandler currentLogHandler11 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel14) <= 0) {
                                        currentLogHandler11.i("[Purchases] - " + logLevel14.name(), (String) billingWrapper$startConnection$lambda$8$lambda$7$$inlined$log$2.invoke());
                                    }
                                    break;
                                case 8:
                                    LogLevel logLevel15 = LogLevel.DEBUG;
                                    LogHandler currentLogHandler12 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                                        currentLogHandler12.d("[Purchases] - " + logLevel15.name(), (String) billingWrapper$startConnection$lambda$8$lambda$7$$inlined$log$2.invoke());
                                    }
                                    break;
                                case 9:
                                    LogLevel logLevel16 = LogLevel.DEBUG;
                                    LogHandler currentLogHandler13 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel16) <= 0) {
                                        currentLogHandler13.d("[Purchases] - " + logLevel16.name(), (String) billingWrapper$startConnection$lambda$8$lambda$7$$inlined$log$2.invoke());
                                    }
                                    break;
                                case 10:
                                    LogLevel logLevel17 = LogLevel.WARN;
                                    LogHandler currentLogHandler14 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                                        currentLogHandler14.w("[Purchases] - " + logLevel17.name(), (String) billingWrapper$startConnection$lambda$8$lambda$7$$inlined$log$2.invoke());
                                    }
                                    break;
                                case 11:
                                    LogLevel logLevel18 = LogLevel.WARN;
                                    LogHandler currentLogHandler15 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel18) <= 0) {
                                        currentLogHandler15.w("[Purchases] - " + logLevel18.name(), (String) billingWrapper$startConnection$lambda$8$lambda$7$$inlined$log$2.invoke());
                                    }
                                    break;
                                case 12:
                                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingWrapper$startConnection$lambda$8$lambda$7$$inlined$log$2.invoke(), null);
                                    break;
                            }
                            sendErrorsToAllPendingRequests(new PurchasesError(PurchasesErrorCode.StoreProblemError, e4.getMessage()));
                        }
                    }
                    E e5 = E.f5463a;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void startConnectionOnMainThread(long j4) {
        this.mainHandler.postDelayed(new Runnable() { // from class: com.revenuecat.purchases.google.f
            @Override // java.lang.Runnable
            public final void run() {
                BillingWrapper.startConnectionOnMainThread$lambda$4(this.f11324a);
            }
        }, j4);
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.google.BillingWrapper$queryPurchaseType$2, reason: invalid class name and case insensitive filesystem */
    public static final class C11632 extends s implements k {
        final /* synthetic */ k $listener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11632(k kVar) {
            super(1);
            this.$listener = kVar;
        }

        public final void invoke(PurchasesError error) {
            r.f(error, "error");
            LogUtilsKt.errorLog(error);
            this.$listener.invoke(ProductType.UNKNOWN);
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((PurchasesError) obj);
            return E.f5463a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BillingWrapper(ClientFactory clientFactory, Handler mainHandler, DeviceCache deviceCache, DiagnosticsTracker diagnosticsTracker, PurchasesStateProvider purchasesStateProvider, DateProvider dateProvider) {
        super(purchasesStateProvider);
        r.f(clientFactory, "clientFactory");
        r.f(mainHandler, "mainHandler");
        r.f(deviceCache, "deviceCache");
        r.f(purchasesStateProvider, "purchasesStateProvider");
        r.f(dateProvider, "dateProvider");
        this.clientFactory = clientFactory;
        this.mainHandler = mainHandler;
        this.deviceCache = deviceCache;
        this.diagnosticsTrackerIfEnabled = diagnosticsTracker;
        this.dateProvider = dateProvider;
        this.purchaseContext = new LinkedHashMap();
        this.serviceRequests = new ConcurrentLinkedQueue<>();
        this.reconnectMilliseconds = 1000L;
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.google.BillingWrapper$queryPurchaseType$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11621 extends s implements k {
        final /* synthetic */ String $purchaseToken;
        final /* synthetic */ k $resultHandler;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11621(k kVar, String str) {
            super(1);
            this.$resultHandler = kVar;
            this.$purchaseToken = str;
        }

        public final void invoke(Map<String, StoreTransaction> purchases) {
            r.f(purchases, "purchases");
            k kVar = this.$resultHandler;
            Collection<StoreTransaction> collectionValues = purchases.values();
            String str = this.$purchaseToken;
            boolean z4 = false;
            if (collectionValues == null || !collectionValues.isEmpty()) {
                Iterator<T> it = collectionValues.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (r.b(((StoreTransaction) it.next()).getPurchaseToken(), str)) {
                        z4 = true;
                        break;
                    }
                }
            }
            kVar.invoke(Boolean.valueOf(z4));
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Map<String, StoreTransaction>) obj);
            return E.f5463a;
        }
    }
}
