package com.revenuecat.purchases.amazon;

import W2.E;
import W2.m;
import W2.t;
import X2.AbstractC0768o;
import X2.AbstractC0770q;
import X2.K;
import X2.L;
import X2.x;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.amazon.device.iap.model.FulfillmentResult;
import com.amazon.device.iap.model.LWAConsentStatus;
import com.amazon.device.iap.model.ProductDataResponse;
import com.amazon.device.iap.model.ProductType;
import com.amazon.device.iap.model.PurchaseResponse;
import com.amazon.device.iap.model.PurchaseUpdatesResponse;
import com.amazon.device.iap.model.Receipt;
import com.amazon.device.iap.model.UserData;
import com.amazon.device.iap.model.UserDataResponse;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.revenuecat.purchases.AmazonLWAConsentStatus;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.PostReceiptInitiationSource;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.PurchasesStateProvider;
import com.revenuecat.purchases.amazon.AmazonPurchasingData;
import com.revenuecat.purchases.amazon.handler.ProductDataHandler;
import com.revenuecat.purchases.amazon.handler.PurchaseHandler;
import com.revenuecat.purchases.amazon.handler.PurchaseUpdatesHandler;
import com.revenuecat.purchases.amazon.handler.UserDataHandler;
import com.revenuecat.purchases.amazon.listener.ProductDataResponseListener;
import com.revenuecat.purchases.amazon.listener.PurchaseResponseListener;
import com.revenuecat.purchases.amazon.listener.PurchaseUpdatesResponseListener;
import com.revenuecat.purchases.amazon.listener.UserDataResponseListener;
import com.revenuecat.purchases.common.BackendHelper;
import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import com.revenuecat.purchases.common.DurationExtensionsKt;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.ReplaceProductInfo;
import com.revenuecat.purchases.common.UtilsKt;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.models.InAppMessageType;
import com.revenuecat.purchases.models.PurchaseState;
import com.revenuecat.purchases.models.PurchasingData;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.strings.BillingStrings;
import com.revenuecat.purchases.strings.PurchaseStrings;
import i3.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import org.json.JSONException;
import org.json.JSONObject;
import s3.C1779a;

/* JADX INFO: loaded from: classes.dex */
public final class AmazonBilling extends BillingAbstract implements ProductDataResponseListener, PurchaseResponseListener, PurchaseUpdatesResponseListener, UserDataResponseListener {
    private final AmazonBackend amazonBackend;
    private final Context applicationContext;
    private final AmazonCache cache;
    private boolean connected;
    private final DateProvider dateProvider;
    private final DiagnosticsTracker diagnosticsTrackerIfEnabled;
    private final boolean finishTransactions;
    private final Handler mainHandler;
    private final ProductDataResponseListener productDataHandler;
    private final PurchaseResponseListener purchaseHandler;
    private final PurchaseUpdatesResponseListener purchaseUpdatesHandler;
    private final PurchasingServiceProvider purchasingServiceProvider;
    private final ConcurrentLinkedQueue<k> serviceRequests;
    private final UserDataResponseListener userDataHandler;

    /* JADX INFO: renamed from: com.revenuecat.purchases.amazon.AmazonBilling$consumeAndSave$1, reason: invalid class name */
    public static final class AnonymousClass1 extends s implements k {
        final /* synthetic */ StoreTransaction $purchase;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(StoreTransaction storeTransaction) {
            super(1);
            this.$purchase = storeTransaction;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((PurchasesError) obj);
            return E.f5463a;
        }

        public final void invoke(PurchasesError purchasesError) {
            if (purchasesError == null) {
                AmazonBilling.this.purchasingServiceProvider.notifyFulfillment(this.$purchase.getPurchaseToken(), FulfillmentResult.FULFILLED);
            } else {
                LogUtilsKt.errorLog(purchasesError);
            }
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.amazon.AmazonBilling$findPurchaseInPurchaseHistory$2, reason: invalid class name */
    public static final class AnonymousClass2 extends s implements k {
        final /* synthetic */ k $onCompletion;
        final /* synthetic */ k $onError;
        final /* synthetic */ String $productId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(k kVar, String str, k kVar2) {
            super(1);
            this.$onCompletion = kVar;
            this.$productId = str;
            this.$onError = kVar2;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((List<StoreTransaction>) obj);
            return E.f5463a;
        }

        public final void invoke(List<StoreTransaction> it) {
            Object next;
            r.f(it, "it");
            String str = this.$productId;
            Iterator<T> it2 = it.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it2.next();
                    if (r.b(str, ((StoreTransaction) next).getProductIds().get(0))) {
                        break;
                    }
                }
            }
            StoreTransaction storeTransaction = (StoreTransaction) next;
            if (storeTransaction != null) {
                this.$onCompletion.invoke(storeTransaction);
                return;
            }
            String str2 = String.format(PurchaseStrings.NO_EXISTING_PURCHASE, Arrays.copyOf(new Object[]{this.$productId}, 1));
            r.e(str2, "format(this, *args)");
            this.$onError.invoke(new PurchasesError(PurchasesErrorCode.PurchaseInvalidError, str2));
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.amazon.AmazonBilling$getAmazonLWAConsentStatus$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11281 extends s implements k {
        final /* synthetic */ k $onError;
        final /* synthetic */ k $onSuccess;

        /* JADX INFO: renamed from: com.revenuecat.purchases.amazon.AmazonBilling$getAmazonLWAConsentStatus$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01661 extends s implements k {
            final /* synthetic */ k $onError;
            final /* synthetic */ k $onSuccess;
            final /* synthetic */ AmazonBilling this$0;

            /* JADX INFO: renamed from: com.revenuecat.purchases.amazon.AmazonBilling$getAmazonLWAConsentStatus$1$1$WhenMappings */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[LWAConsentStatus.values().length];
                    try {
                        iArr[LWAConsentStatus.CONSENTED.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[LWAConsentStatus.UNAVAILABLE.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01661(AmazonBilling amazonBilling, k kVar, k kVar2) {
                super(1);
                this.this$0 = amazonBilling;
                this.$onSuccess = kVar;
                this.$onError = kVar2;
            }

            @Override // i3.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((UserData) obj);
                return E.f5463a;
            }

            public final void invoke(UserData userData) {
                AmazonLWAConsentStatus amazonLWAConsentStatus;
                r.f(userData, "userData");
                LWAConsentStatus lWAConsentStatus = userData.getLWAConsentStatus();
                if (lWAConsentStatus == null) {
                    this.$onError.invoke(new PurchasesError(PurchasesErrorCode.StoreProblemError, AmazonStrings.ERROR_USER_DATA_LWA_CONSENT_STATUS_NULL_STORE_PROBLEM));
                    return;
                }
                k kVar = this.$onSuccess;
                int i4 = WhenMappings.$EnumSwitchMapping$0[lWAConsentStatus.ordinal()];
                if (i4 == 1) {
                    amazonLWAConsentStatus = AmazonLWAConsentStatus.CONSENTED;
                } else {
                    if (i4 != 2) {
                        throw new m();
                    }
                    amazonLWAConsentStatus = AmazonLWAConsentStatus.UNAVAILABLE;
                }
                kVar.invoke(amazonLWAConsentStatus);
            }
        }

        /* JADX INFO: renamed from: com.revenuecat.purchases.amazon.AmazonBilling$getAmazonLWAConsentStatus$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends s implements k {
            final /* synthetic */ k $onError;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(k kVar) {
                super(1);
                this.$onError = kVar;
            }

            @Override // i3.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((PurchasesError) obj);
                return E.f5463a;
            }

            public final void invoke(PurchasesError error) {
                r.f(error, "error");
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                String str = String.format(BillingStrings.BILLING_AMAZON_ERROR_LWA_CONSENT_STATUS, Arrays.copyOf(new Object[]{error}, 1));
                r.e(str, "format(this, *args)");
                currentLogHandler.e("[Purchases] - ERROR", str, null);
                this.$onError.invoke(error);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11281(k kVar, k kVar2) {
            super(1);
            this.$onError = kVar;
            this.$onSuccess = kVar2;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((PurchasesError) obj);
            return E.f5463a;
        }

        public final void invoke(PurchasesError purchasesError) {
            if (purchasesError == null) {
                AmazonBilling.this.userDataHandler.getUserData(new C01661(AmazonBilling.this, this.$onSuccess, this.$onError), new AnonymousClass2(this.$onError));
                return;
            }
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            String str = String.format(BillingStrings.BILLING_CONNECTION_ERROR_LWA_CONSENT_STATUS, Arrays.copyOf(new Object[]{purchasesError}, 1));
            r.e(str, "format(this, *args)");
            currentLogHandler.e("[Purchases] - ERROR", str, null);
            this.$onError.invoke(purchasesError);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.amazon.AmazonBilling$getStorefront$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11291 extends s implements k {
        final /* synthetic */ k $onError;
        final /* synthetic */ k $onSuccess;

        /* JADX INFO: renamed from: com.revenuecat.purchases.amazon.AmazonBilling$getStorefront$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01671 extends s implements k {
            final /* synthetic */ k $onError;
            final /* synthetic */ k $onSuccess;
            final /* synthetic */ AmazonBilling this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01671(AmazonBilling amazonBilling, k kVar, k kVar2) {
                super(1);
                this.this$0 = amazonBilling;
                this.$onSuccess = kVar;
                this.$onError = kVar2;
            }

            @Override // i3.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((UserData) obj);
                return E.f5463a;
            }

            public final void invoke(UserData userData) {
                r.f(userData, "userData");
                String marketplace = userData.getMarketplace();
                if (marketplace == null) {
                    this.$onError.invoke(new PurchasesError(PurchasesErrorCode.StoreProblemError, AmazonStrings.ERROR_USER_DATA_MARKETPLACE_NULL_STORE_PROBLEM));
                } else {
                    this.$onSuccess.invoke(marketplace);
                }
            }
        }

        /* JADX INFO: renamed from: com.revenuecat.purchases.amazon.AmazonBilling$getStorefront$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends s implements k {
            final /* synthetic */ k $onError;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(k kVar) {
                super(1);
                this.$onError = kVar;
            }

            @Override // i3.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((PurchasesError) obj);
                return E.f5463a;
            }

            public final void invoke(PurchasesError error) {
                r.f(error, "error");
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                String str = String.format(BillingStrings.BILLING_AMAZON_ERROR_STOREFRONT, Arrays.copyOf(new Object[]{error}, 1));
                r.e(str, "format(this, *args)");
                currentLogHandler.e("[Purchases] - ERROR", str, null);
                this.$onError.invoke(error);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11291(k kVar, k kVar2) {
            super(1);
            this.$onError = kVar;
            this.$onSuccess = kVar2;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((PurchasesError) obj);
            return E.f5463a;
        }

        public final void invoke(PurchasesError purchasesError) {
            if (purchasesError == null) {
                AmazonBilling.this.userDataHandler.getUserData(new C01671(AmazonBilling.this, this.$onSuccess, this.$onError), new AnonymousClass2(this.$onError));
                return;
            }
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            String str = String.format(BillingStrings.BILLING_CONNECTION_ERROR_STORE_COUNTRY, Arrays.copyOf(new Object[]{purchasesError}, 1));
            r.e(str, "format(this, *args)");
            currentLogHandler.e("[Purchases] - ERROR", str, null);
            this.$onError.invoke(purchasesError);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.amazon.AmazonBilling$handleReceipt$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11301 extends s implements k {
        final /* synthetic */ PresentedOfferingContext $presentedOfferingContext;
        final /* synthetic */ Receipt $receipt;
        final /* synthetic */ UserData $userData;
        final /* synthetic */ AmazonBilling this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11301(Receipt receipt, PresentedOfferingContext presentedOfferingContext, UserData userData, AmazonBilling amazonBilling) {
            super(1);
            this.$receipt = receipt;
            this.$presentedOfferingContext = presentedOfferingContext;
            this.$userData = userData;
            this.this$0 = amazonBilling;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) throws JSONException {
            invoke((JSONObject) obj);
            return E.f5463a;
        }

        public final void invoke(JSONObject response) throws JSONException {
            r.f(response, "response");
            Object obj = response.get(com.amazon.a.a.o.b.f8738L);
            r.d(obj, "null cannot be cast to non-null type kotlin.String");
            StoreTransaction storeTransaction = StoreTransactionConversionsKt.toStoreTransaction(this.$receipt, (String) obj, this.$presentedOfferingContext, PurchaseState.PURCHASED, this.$userData);
            BillingAbstract.PurchasesUpdatedListener purchasesUpdatedListener = this.this$0.getPurchasesUpdatedListener();
            if (purchasesUpdatedListener != null) {
                purchasesUpdatedListener.onPurchasesUpdated(AbstractC0768o.b(storeTransaction));
            }
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.amazon.AmazonBilling$handleReceipt$2, reason: invalid class name and case insensitive filesystem */
    public /* synthetic */ class C11312 extends o implements k {
        public C11312(Object obj) {
            super(1, obj, AmazonBilling.class, "onPurchaseError", "onPurchaseError(Lcom/revenuecat/purchases/PurchasesError;)V", 0);
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((PurchasesError) obj);
            return E.f5463a;
        }

        public final void invoke(PurchasesError p02) {
            r.f(p02, "p0");
            ((AmazonBilling) this.receiver).onPurchaseError(p02);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.amazon.AmazonBilling$makePurchaseAsync$2, reason: invalid class name and case insensitive filesystem */
    public static final class C11322 extends s implements k {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ String $appUserID;
        final /* synthetic */ PresentedOfferingContext $presentedOfferingContext;
        final /* synthetic */ AmazonStoreProduct $storeProduct;

        /* JADX INFO: renamed from: com.revenuecat.purchases.amazon.AmazonBilling$makePurchaseAsync$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends s implements i3.o {
            final /* synthetic */ PresentedOfferingContext $presentedOfferingContext;
            final /* synthetic */ AmazonStoreProduct $storeProduct;
            final /* synthetic */ AmazonBilling this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(AmazonBilling amazonBilling, AmazonStoreProduct amazonStoreProduct, PresentedOfferingContext presentedOfferingContext) {
                super(2);
                this.this$0 = amazonBilling;
                this.$storeProduct = amazonStoreProduct;
                this.$presentedOfferingContext = presentedOfferingContext;
            }

            @Override // i3.o
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Receipt) obj, (UserData) obj2);
                return E.f5463a;
            }

            public final void invoke(Receipt receipt, UserData userData) {
                r.f(receipt, "receipt");
                r.f(userData, "userData");
                this.this$0.handleReceipt(receipt, userData, this.$storeProduct, this.$presentedOfferingContext);
            }
        }

        /* JADX INFO: renamed from: com.revenuecat.purchases.amazon.AmazonBilling$makePurchaseAsync$2$2, reason: invalid class name and collision with other inner class name */
        public static final class C01682 extends s implements k {
            final /* synthetic */ AmazonBilling this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01682(AmazonBilling amazonBilling) {
                super(1);
                this.this$0 = amazonBilling;
            }

            @Override // i3.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((PurchasesError) obj);
                return E.f5463a;
            }

            public final void invoke(PurchasesError it) {
                r.f(it, "it");
                this.this$0.onPurchaseError(it);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11322(Activity activity, String str, AmazonStoreProduct amazonStoreProduct, PresentedOfferingContext presentedOfferingContext) {
            super(1);
            this.$activity = activity;
            this.$appUserID = str;
            this.$storeProduct = amazonStoreProduct;
            this.$presentedOfferingContext = presentedOfferingContext;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((PurchasesError) obj);
            return E.f5463a;
        }

        public final void invoke(PurchasesError purchasesError) {
            if (purchasesError != null) {
                AmazonBilling.this.onPurchaseError(purchasesError);
                return;
            }
            PurchaseResponseListener purchaseResponseListener = AmazonBilling.this.purchaseHandler;
            Handler handler = AmazonBilling.this.mainHandler;
            Activity activity = this.$activity;
            String str = this.$appUserID;
            AmazonStoreProduct amazonStoreProduct = this.$storeProduct;
            purchaseResponseListener.purchase(handler, activity, str, amazonStoreProduct, new AnonymousClass1(AmazonBilling.this, amazonStoreProduct, this.$presentedOfferingContext), new C01682(AmazonBilling.this));
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.amazon.AmazonBilling$normalizePurchaseData$2, reason: invalid class name and case insensitive filesystem */
    public static final class C11332 extends s implements k {
        final /* synthetic */ k $onError;
        final /* synthetic */ k $onSuccess;
        final /* synthetic */ String $purchaseToken;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11332(k kVar, String str, k kVar2) {
            super(1);
            this.$onError = kVar;
            this.$purchaseToken = str;
            this.$onSuccess = kVar2;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((JSONObject) obj);
            return E.f5463a;
        }

        public final void invoke(JSONObject response) {
            LogHandler currentLogHandler;
            String str;
            String str2;
            r.f(response, "response");
            LogIntent logIntent = LogIntent.DEBUG;
            AmazonBilling$normalizePurchaseData$2$invoke$$inlined$log$1 amazonBilling$normalizePurchaseData$2$invoke$$inlined$log$1 = new AmazonBilling$normalizePurchaseData$2$invoke$$inlined$log$1(logIntent, response);
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                case 1:
                    LogLevel logLevel = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        str = "[Purchases] - " + logLevel.name();
                        str2 = (String) amazonBilling$normalizePurchaseData$2$invoke$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) amazonBilling$normalizePurchaseData$2$invoke$$inlined$log$1.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel2 = LogLevel.WARN;
                    LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) amazonBilling$normalizePurchaseData$2$invoke$$inlined$log$1.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel3 = LogLevel.INFO;
                    LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                        currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) amazonBilling$normalizePurchaseData$2$invoke$$inlined$log$1.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel4 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                        str = "[Purchases] - " + logLevel4.name();
                        str2 = (String) amazonBilling$normalizePurchaseData$2$invoke$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) amazonBilling$normalizePurchaseData$2$invoke$$inlined$log$1.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel5 = LogLevel.INFO;
                    LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                        currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) amazonBilling$normalizePurchaseData$2$invoke$$inlined$log$1.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel6 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                        str = "[Purchases] - " + logLevel6.name();
                        str2 = (String) amazonBilling$normalizePurchaseData$2$invoke$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 9:
                    LogLevel logLevel7 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                        str = "[Purchases] - " + logLevel7.name();
                        str2 = (String) amazonBilling$normalizePurchaseData$2$invoke$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 10:
                    LogLevel logLevel8 = LogLevel.WARN;
                    LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                        currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) amazonBilling$normalizePurchaseData$2$invoke$$inlined$log$1.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel9 = LogLevel.WARN;
                    LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                        currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) amazonBilling$normalizePurchaseData$2$invoke$$inlined$log$1.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) amazonBilling$normalizePurchaseData$2$invoke$$inlined$log$1.invoke(), null);
                    break;
            }
            String termSkuFromJSON = AmazonBilling.this.getTermSkuFromJSON(response);
            if (termSkuFromJSON == null) {
                this.$onError.invoke(ErrorsKt.missingTermSkuError(response));
            } else {
                AmazonBilling.this.cache.cacheSkusByToken(K.c(t.a(this.$purchaseToken, termSkuFromJSON)));
                this.$onSuccess.invoke(termSkuFromJSON);
            }
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.amazon.AmazonBilling$normalizePurchaseData$3, reason: invalid class name */
    public static final class AnonymousClass3 extends s implements k {
        final /* synthetic */ k $onError;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(k kVar) {
            super(1);
            this.$onError = kVar;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((PurchasesError) obj);
            return E.f5463a;
        }

        public final void invoke(PurchasesError error) {
            r.f(error, "error");
            this.$onError.invoke(ErrorsKt.errorGettingReceiptInfo(error));
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.amazon.AmazonBilling$queryAllPurchases$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11341 extends s implements k {
        final /* synthetic */ k $onReceivePurchaseHistory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11341(k kVar) {
            super(1);
            this.$onReceivePurchaseHistory = kVar;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Map<String, StoreTransaction>) obj);
            return E.f5463a;
        }

        public final void invoke(Map<String, StoreTransaction> it) {
            r.f(it, "it");
            this.$onReceivePurchaseHistory.invoke(x.g0(it.values()));
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.amazon.AmazonBilling$queryProductDetailsAsync$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11351 extends s implements k {
        final /* synthetic */ k $onError;
        final /* synthetic */ k $onReceive;
        final /* synthetic */ Set<String> $productIds;

        /* JADX INFO: renamed from: com.revenuecat.purchases.amazon.AmazonBilling$queryProductDetailsAsync$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01691 extends s implements k {
            final /* synthetic */ k $onError;
            final /* synthetic */ k $onReceive;
            final /* synthetic */ Set<String> $productIds;
            final /* synthetic */ AmazonBilling this$0;

            /* JADX INFO: renamed from: com.revenuecat.purchases.amazon.AmazonBilling$queryProductDetailsAsync$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C01701 extends s implements k {
                final /* synthetic */ k $onReceive;
                final /* synthetic */ Set<String> $productIds;
                final /* synthetic */ Date $requestStartTime;
                final /* synthetic */ AmazonBilling this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C01701(AmazonBilling amazonBilling, Date date, Set<String> set, k kVar) {
                    super(1);
                    this.this$0 = amazonBilling;
                    this.$requestStartTime = date;
                    this.$productIds = set;
                    this.$onReceive = kVar;
                }

                @Override // i3.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((List<? extends StoreProduct>) obj);
                    return E.f5463a;
                }

                public final void invoke(List<? extends StoreProduct> it) {
                    r.f(it, "it");
                    this.this$0.trackAmazonQueryProductDetailsRequestIfNeeded(true, this.$requestStartTime, this.$productIds);
                    this.$onReceive.invoke(it);
                }
            }

            /* JADX INFO: renamed from: com.revenuecat.purchases.amazon.AmazonBilling$queryProductDetailsAsync$1$1$2, reason: invalid class name */
            public static final class AnonymousClass2 extends s implements k {
                final /* synthetic */ k $onError;
                final /* synthetic */ Set<String> $productIds;
                final /* synthetic */ Date $requestStartTime;
                final /* synthetic */ AmazonBilling this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass2(AmazonBilling amazonBilling, Date date, Set<String> set, k kVar) {
                    super(1);
                    this.this$0 = amazonBilling;
                    this.$requestStartTime = date;
                    this.$productIds = set;
                    this.$onError = kVar;
                }

                @Override // i3.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((PurchasesError) obj);
                    return E.f5463a;
                }

                public final void invoke(PurchasesError it) {
                    r.f(it, "it");
                    this.this$0.trackAmazonQueryProductDetailsRequestIfNeeded(false, this.$requestStartTime, this.$productIds);
                    this.$onError.invoke(it);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01691(AmazonBilling amazonBilling, Set<String> set, k kVar, k kVar2) {
                super(1);
                this.this$0 = amazonBilling;
                this.$productIds = set;
                this.$onReceive = kVar;
                this.$onError = kVar2;
            }

            @Override // i3.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((UserData) obj);
                return E.f5463a;
            }

            public final void invoke(UserData userData) {
                r.f(userData, "userData");
                Date now = this.this$0.dateProvider.getNow();
                ProductDataResponseListener productDataResponseListener = this.this$0.productDataHandler;
                Set<String> set = this.$productIds;
                String marketplace = userData.getMarketplace();
                r.e(marketplace, "userData.marketplace");
                productDataResponseListener.getProductData(set, marketplace, new C01701(this.this$0, now, this.$productIds, this.$onReceive), new AnonymousClass2(this.this$0, now, this.$productIds, this.$onError));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11351(k kVar, Set<String> set, k kVar2) {
            super(1);
            this.$onError = kVar;
            this.$productIds = set;
            this.$onReceive = kVar2;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((PurchasesError) obj);
            return E.f5463a;
        }

        public final void invoke(PurchasesError purchasesError) {
            if (purchasesError == null) {
                AmazonBilling.this.userDataHandler.getUserData(new C01691(AmazonBilling.this, this.$productIds, this.$onReceive, this.$onError), this.$onError);
            } else {
                this.$onError.invoke(purchasesError);
            }
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.amazon.AmazonBilling$queryPurchases$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11361 extends s implements k {
        final /* synthetic */ boolean $filterOnlyActivePurchases;
        final /* synthetic */ k $onError;
        final /* synthetic */ k $onSuccess;

        /* JADX INFO: renamed from: com.revenuecat.purchases.amazon.AmazonBilling$queryPurchases$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01711 extends s implements i3.o {
            final /* synthetic */ boolean $filterOnlyActivePurchases;
            final /* synthetic */ k $onError;
            final /* synthetic */ k $onSuccess;
            final /* synthetic */ Date $requestStartTime;
            final /* synthetic */ AmazonBilling this$0;

            /* JADX INFO: renamed from: com.revenuecat.purchases.amazon.AmazonBilling$queryPurchases$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C01721 extends s implements i3.o {
                final /* synthetic */ List<Receipt> $filteredReceipts;
                final /* synthetic */ k $onError;
                final /* synthetic */ k $onSuccess;
                final /* synthetic */ UserData $userData;
                final /* synthetic */ AmazonBilling this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C01721(AmazonBilling amazonBilling, k kVar, List<Receipt> list, UserData userData, k kVar2) {
                    super(2);
                    this.this$0 = amazonBilling;
                    this.$onError = kVar;
                    this.$filteredReceipts = list;
                    this.$userData = userData;
                    this.$onSuccess = kVar2;
                }

                @Override // i3.o
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Map<String, String>) obj, (Map<String, PurchasesError>) obj2);
                    return E.f5463a;
                }

                public final void invoke(Map<String, String> tokensToSkusMap, Map<String, PurchasesError> errors) {
                    r.f(tokensToSkusMap, "tokensToSkusMap");
                    r.f(errors, "errors");
                    this.this$0.logErrorsIfAny(errors);
                    if (tokensToSkusMap.isEmpty()) {
                        this.$onError.invoke(new PurchasesError(PurchasesErrorCode.InvalidReceiptError, AmazonStrings.ERROR_FETCHING_PURCHASE_HISTORY_ALL_RECEIPTS_INVALID));
                    } else {
                        this.$onSuccess.invoke(this.this$0.toMapOfReceiptHashesToRestoredPurchases(this.$filteredReceipts, tokensToSkusMap, this.$userData));
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01711(AmazonBilling amazonBilling, Date date, boolean z4, k kVar, k kVar2) {
                super(2);
                this.this$0 = amazonBilling;
                this.$requestStartTime = date;
                this.$filterOnlyActivePurchases = z4;
                this.$onSuccess = kVar;
                this.$onError = kVar2;
            }

            @Override // i3.o
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((List<Receipt>) obj, (UserData) obj2);
                return E.f5463a;
            }

            public final void invoke(List<Receipt> receipts, UserData userData) {
                List list;
                r.f(receipts, "receipts");
                r.f(userData, "userData");
                this.this$0.trackAmazonQueryPurchasesRequestIfNeeded(true, this.$requestStartTime, receipts);
                if (this.$filterOnlyActivePurchases) {
                    AmazonBilling amazonBilling = this.this$0;
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : receipts) {
                        Receipt receipt = (Receipt) obj;
                        if (receipt.getCancelDate() == null || receipt.getCancelDate().compareTo(amazonBilling.dateProvider.getNow()) > 0) {
                            arrayList.add(obj);
                        }
                    }
                    list = arrayList;
                } else {
                    list = receipts;
                }
                if (list.isEmpty()) {
                    this.$onSuccess.invoke(L.e());
                    return;
                }
                AmazonBilling amazonBilling2 = this.this$0;
                String userId = userData.getUserId();
                r.e(userId, "userData.userId");
                amazonBilling2.getMissingSkusForReceipts(userId, list, new C01721(this.this$0, this.$onError, list, userData, this.$onSuccess));
            }
        }

        /* JADX INFO: renamed from: com.revenuecat.purchases.amazon.AmazonBilling$queryPurchases$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends s implements k {
            final /* synthetic */ k $onError;
            final /* synthetic */ Date $requestStartTime;
            final /* synthetic */ AmazonBilling this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(AmazonBilling amazonBilling, Date date, k kVar) {
                super(1);
                this.this$0 = amazonBilling;
                this.$requestStartTime = date;
                this.$onError = kVar;
            }

            @Override // i3.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((PurchasesError) obj);
                return E.f5463a;
            }

            public final void invoke(PurchasesError it) {
                r.f(it, "it");
                this.this$0.trackAmazonQueryPurchasesRequestIfNeeded(false, this.$requestStartTime, null);
                this.$onError.invoke(it);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11361(k kVar, boolean z4, k kVar2) {
            super(1);
            this.$onError = kVar;
            this.$filterOnlyActivePurchases = z4;
            this.$onSuccess = kVar2;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((PurchasesError) obj);
            return E.f5463a;
        }

        public final void invoke(PurchasesError purchasesError) {
            if (purchasesError != null) {
                this.$onError.invoke(purchasesError);
            } else {
                Date now = AmazonBilling.this.dateProvider.getNow();
                AmazonBilling.this.purchaseUpdatesHandler.queryPurchases(new C01711(AmazonBilling.this, now, this.$filterOnlyActivePurchases, this.$onSuccess, this.$onError), new AnonymousClass2(AmazonBilling.this, now, this.$onError));
            }
        }
    }

    public /* synthetic */ AmazonBilling(Context context, AmazonBackend amazonBackend, AmazonCache amazonCache, boolean z4, Handler handler, PurchasesStateProvider purchasesStateProvider, DiagnosticsTracker diagnosticsTracker, PurchasingServiceProvider purchasingServiceProvider, ProductDataResponseListener productDataResponseListener, PurchaseResponseListener purchaseResponseListener, PurchaseUpdatesResponseListener purchaseUpdatesResponseListener, UserDataResponseListener userDataResponseListener, DateProvider dateProvider, int i4, AbstractC1585j abstractC1585j) {
        Handler handler2;
        ProductDataResponseListener productDataHandler;
        PurchasingServiceProvider defaultPurchasingServiceProvider = (i4 & UserMetadata.MAX_ROLLOUT_ASSIGNMENTS) != 0 ? new DefaultPurchasingServiceProvider() : purchasingServiceProvider;
        if ((i4 & 256) != 0) {
            handler2 = handler;
            productDataHandler = new ProductDataHandler(defaultPurchasingServiceProvider, handler2);
        } else {
            handler2 = handler;
            productDataHandler = productDataResponseListener;
        }
        this(context, amazonBackend, amazonCache, z4, handler, purchasesStateProvider, diagnosticsTracker, defaultPurchasingServiceProvider, productDataHandler, (i4 & 512) != 0 ? new PurchaseHandler(defaultPurchasingServiceProvider, context, diagnosticsTracker, null, 8, null) : purchaseResponseListener, (i4 & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0 ? new PurchaseUpdatesHandler(defaultPurchasingServiceProvider) : purchaseUpdatesResponseListener, (i4 & 2048) != 0 ? new UserDataHandler(defaultPurchasingServiceProvider, handler2, null, 4, null) : userDataResponseListener, (i4 & 4096) != 0 ? new DefaultDateProvider() : dateProvider);
    }

    private final void executePendingRequests() {
        synchronized (this) {
            while (isConnected() && !this.serviceRequests.isEmpty()) {
                try {
                    final k kVarRemove = this.serviceRequests.remove();
                    runOnUIThread(new Runnable() { // from class: com.revenuecat.purchases.amazon.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            kVarRemove.invoke(null);
                        }
                    });
                } catch (Throwable th) {
                    throw th;
                }
            }
            E e4 = E.f5463a;
        }
    }

    private final synchronized void executeRequestOnUIThread(k kVar) {
        try {
            if (getPurchasesUpdatedListener() != null) {
                this.serviceRequests.add(kVar);
                if (isConnected()) {
                    executePendingRequests();
                } else {
                    BillingAbstract.startConnectionOnMainThread$default(this, 0L, 1, null);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getMissingSkusForReceipts(String str, List<Receipt> list, i3.o oVar) {
        Map<String, String> receiptSkus = this.cache.getReceiptSkus();
        Map mapU = L.u(receiptSkus);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ArrayList<Receipt> arrayList = new ArrayList();
        for (Object obj : list) {
            if (((Receipt) obj).getProductType() != ProductType.SUBSCRIPTION) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(AbstractC0770q.q(arrayList, 10));
        for (Receipt receipt : arrayList) {
            arrayList2.add(t.a(receipt.getReceiptId(), receipt.getSku()));
        }
        L.l(mapU, arrayList2);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : list) {
            if (((Receipt) obj2).getProductType() == ProductType.SUBSCRIPTION) {
                arrayList3.add(obj2);
            }
        }
        ArrayList<Receipt> arrayList4 = new ArrayList();
        for (Object obj3 : arrayList3) {
            if (!receiptSkus.containsKey(((Receipt) obj3).getReceiptId())) {
                arrayList4.add(obj3);
            }
        }
        if (arrayList4.isEmpty()) {
            oVar.invoke(mapU, linkedHashMap);
            return;
        }
        kotlin.jvm.internal.E e4 = new kotlin.jvm.internal.E();
        e4.f13409a = arrayList4.size();
        for (Receipt receipt2 : arrayList4) {
            AmazonBackend amazonBackend = this.amazonBackend;
            String receiptId = receipt2.getReceiptId();
            r.e(receiptId, "receipt.receiptId");
            i3.o oVar2 = oVar;
            AmazonBilling$getMissingSkusForReceipts$1$1 amazonBilling$getMissingSkusForReceipts$1$1 = new AmazonBilling$getMissingSkusForReceipts$1$1(mapU, receipt2, e4, this, oVar2, linkedHashMap);
            Map map = mapU;
            mapU = map;
            amazonBackend.getAmazonReceiptData(receiptId, str, amazonBilling$getMissingSkusForReceipts$1$1, new AmazonBilling$getMissingSkusForReceipts$1$2(linkedHashMap, receipt2, e4, oVar2, map));
            oVar = oVar2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getTermSkuFromJSON(JSONObject jSONObject) {
        try {
            return jSONObject.getString(com.amazon.a.a.o.b.f8738L);
        } catch (JSONException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleReceipt(Receipt receipt, UserData userData, StoreProduct storeProduct, PresentedOfferingContext presentedOfferingContext) {
        if (receipt.getProductType() != ProductType.SUBSCRIPTION) {
            StoreTransaction storeTransaction = StoreTransactionConversionsKt.toStoreTransaction(receipt, storeProduct.getId(), presentedOfferingContext, PurchaseState.PURCHASED, userData);
            BillingAbstract.PurchasesUpdatedListener purchasesUpdatedListener = getPurchasesUpdatedListener();
            if (purchasesUpdatedListener != null) {
                purchasesUpdatedListener.onPurchasesUpdated(AbstractC0768o.b(storeTransaction));
                return;
            }
            return;
        }
        AmazonBackend amazonBackend = this.amazonBackend;
        String receiptId = receipt.getReceiptId();
        r.e(receiptId, "receipt.receiptId");
        String userId = userData.getUserId();
        r.e(userId, "userData.userId");
        amazonBackend.getAmazonReceiptData(receiptId, userId, new C11301(receipt, presentedOfferingContext, userData, this), new C11312(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logErrorsIfAny(Map<String, PurchasesError> map) {
        if (map.isEmpty()) {
            return;
        }
        String strQ = x.Q(map.keySet(), "\n", null, null, 0, null, null, 62, null);
        LogIntent logIntent = LogIntent.AMAZON_ERROR;
        AmazonBilling$logErrorsIfAny$$inlined$log$1 amazonBilling$logErrorsIfAny$$inlined$log$1 = new AmazonBilling$logErrorsIfAny$$inlined$log$1(logIntent, strQ);
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler.d("[Purchases] - " + logLevel.name(), (String) amazonBilling$logErrorsIfAny$$inlined$log$1.invoke());
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) amazonBilling$logErrorsIfAny$$inlined$log$1.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) amazonBilling$logErrorsIfAny$$inlined$log$1.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) amazonBilling$logErrorsIfAny$$inlined$log$1.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    currentLogHandler4.d("[Purchases] - " + logLevel4.name(), (String) amazonBilling$logErrorsIfAny$$inlined$log$1.invoke());
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) amazonBilling$logErrorsIfAny$$inlined$log$1.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler5.i("[Purchases] - " + logLevel5.name(), (String) amazonBilling$logErrorsIfAny$$inlined$log$1.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    currentLogHandler6.d("[Purchases] - " + logLevel6.name(), (String) amazonBilling$logErrorsIfAny$$inlined$log$1.invoke());
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    currentLogHandler7.d("[Purchases] - " + logLevel7.name(), (String) amazonBilling$logErrorsIfAny$$inlined$log$1.invoke());
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler8.w("[Purchases] - " + logLevel8.name(), (String) amazonBilling$logErrorsIfAny$$inlined$log$1.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler9.w("[Purchases] - " + logLevel9.name(), (String) amazonBilling$logErrorsIfAny$$inlined$log$1.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) amazonBilling$logErrorsIfAny$$inlined$log$1.invoke(), null);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onPurchaseError(PurchasesError purchasesError) {
        BillingAbstract.PurchasesUpdatedListener purchasesUpdatedListener = getPurchasesUpdatedListener();
        if (purchasesUpdatedListener != null) {
            purchasesUpdatedListener.onPurchasesFailedToUpdate(purchasesError);
        }
    }

    private final void runOnUIThread(Runnable runnable) {
        if (r.b(Looper.getMainLooper().getThread(), Thread.currentThread())) {
            runnable.run();
        } else {
            this.mainHandler.post(runnable);
        }
    }

    private final boolean shouldFinishTransactions() {
        LogHandler currentLogHandler;
        String str;
        String str2;
        if (this.finishTransactions) {
            return true;
        }
        LogIntent logIntent = LogIntent.AMAZON_WARNING;
        AmazonBilling$shouldFinishTransactions$$inlined$log$1 amazonBilling$shouldFinishTransactions$$inlined$log$1 = new AmazonBilling$shouldFinishTransactions$$inlined$log$1(logIntent);
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) > 0) {
                    return false;
                }
                str = "[Purchases] - " + logLevel.name();
                str2 = (String) amazonBilling$shouldFinishTransactions$$inlined$log$1.invoke();
                break;
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) amazonBilling$shouldFinishTransactions$$inlined$log$1.invoke(), null);
                return false;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) > 0) {
                    return false;
                }
                currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) amazonBilling$shouldFinishTransactions$$inlined$log$1.invoke());
                return false;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) > 0) {
                    return false;
                }
                currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) amazonBilling$shouldFinishTransactions$$inlined$log$1.invoke());
                return false;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) > 0) {
                    return false;
                }
                str = "[Purchases] - " + logLevel4.name();
                str2 = (String) amazonBilling$shouldFinishTransactions$$inlined$log$1.invoke();
                break;
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) amazonBilling$shouldFinishTransactions$$inlined$log$1.invoke(), null);
                return false;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) > 0) {
                    return false;
                }
                currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) amazonBilling$shouldFinishTransactions$$inlined$log$1.invoke());
                return false;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) > 0) {
                    return false;
                }
                str = "[Purchases] - " + logLevel6.name();
                str2 = (String) amazonBilling$shouldFinishTransactions$$inlined$log$1.invoke();
                break;
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) > 0) {
                    return false;
                }
                str = "[Purchases] - " + logLevel7.name();
                str2 = (String) amazonBilling$shouldFinishTransactions$$inlined$log$1.invoke();
                break;
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) > 0) {
                    return false;
                }
                currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) amazonBilling$shouldFinishTransactions$$inlined$log$1.invoke());
                return false;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) > 0) {
                    return false;
                }
                currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) amazonBilling$shouldFinishTransactions$$inlined$log$1.invoke());
                return false;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) amazonBilling$shouldFinishTransactions$$inlined$log$1.invoke(), null);
                return false;
            default:
                return false;
        }
        currentLogHandler.d(str, str2);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startConnectionOnMainThread$lambda$0(AmazonBilling this$0) {
        r.f(this$0, "this$0");
        this$0.startConnection();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, StoreTransaction> toMapOfReceiptHashesToRestoredPurchases(List<Receipt> list, Map<String, String> map, UserData userData) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        ArrayList arrayList = new ArrayList();
        for (Receipt receipt : list) {
            String str3 = map.get(receipt.getReceiptId());
            W2.o oVarA = null;
            if (str3 == null) {
                LogIntent logIntent = LogIntent.AMAZON_ERROR;
                AmazonBilling$toMapOfReceiptHashesToRestoredPurchases$lambda$5$$inlined$log$1 amazonBilling$toMapOfReceiptHashesToRestoredPurchases$lambda$5$$inlined$log$1 = new AmazonBilling$toMapOfReceiptHashesToRestoredPurchases$lambda$5$$inlined$log$1(logIntent);
                switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                    case 1:
                        LogLevel logLevel = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                            str = "[Purchases] - " + logLevel.name();
                            str2 = (String) amazonBilling$toMapOfReceiptHashesToRestoredPurchases$lambda$5$$inlined$log$1.invoke();
                            currentLogHandler.d(str, str2);
                        }
                        break;
                    case 2:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) amazonBilling$toMapOfReceiptHashesToRestoredPurchases$lambda$5$$inlined$log$1.invoke(), null);
                        break;
                    case 3:
                        LogLevel logLevel2 = LogLevel.WARN;
                        LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                            currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) amazonBilling$toMapOfReceiptHashesToRestoredPurchases$lambda$5$$inlined$log$1.invoke());
                        }
                        break;
                    case 4:
                        LogLevel logLevel3 = LogLevel.INFO;
                        LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                            currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) amazonBilling$toMapOfReceiptHashesToRestoredPurchases$lambda$5$$inlined$log$1.invoke());
                        }
                        break;
                    case 5:
                        LogLevel logLevel4 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                            str = "[Purchases] - " + logLevel4.name();
                            str2 = (String) amazonBilling$toMapOfReceiptHashesToRestoredPurchases$lambda$5$$inlined$log$1.invoke();
                            currentLogHandler.d(str, str2);
                        }
                        break;
                    case 6:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) amazonBilling$toMapOfReceiptHashesToRestoredPurchases$lambda$5$$inlined$log$1.invoke(), null);
                        break;
                    case 7:
                        LogLevel logLevel5 = LogLevel.INFO;
                        LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                            currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) amazonBilling$toMapOfReceiptHashesToRestoredPurchases$lambda$5$$inlined$log$1.invoke());
                        }
                        break;
                    case 8:
                        LogLevel logLevel6 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                            str = "[Purchases] - " + logLevel6.name();
                            str2 = (String) amazonBilling$toMapOfReceiptHashesToRestoredPurchases$lambda$5$$inlined$log$1.invoke();
                            currentLogHandler.d(str, str2);
                        }
                        break;
                    case 9:
                        LogLevel logLevel7 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                            str = "[Purchases] - " + logLevel7.name();
                            str2 = (String) amazonBilling$toMapOfReceiptHashesToRestoredPurchases$lambda$5$$inlined$log$1.invoke();
                            currentLogHandler.d(str, str2);
                        }
                        break;
                    case 10:
                        LogLevel logLevel8 = LogLevel.WARN;
                        LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                            currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) amazonBilling$toMapOfReceiptHashesToRestoredPurchases$lambda$5$$inlined$log$1.invoke());
                        }
                        break;
                    case 11:
                        LogLevel logLevel9 = LogLevel.WARN;
                        LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                            currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) amazonBilling$toMapOfReceiptHashesToRestoredPurchases$lambda$5$$inlined$log$1.invoke());
                        }
                        break;
                    case 12:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) amazonBilling$toMapOfReceiptHashesToRestoredPurchases$lambda$5$$inlined$log$1.invoke(), null);
                        break;
                }
            } else {
                StoreTransaction storeTransaction = StoreTransactionConversionsKt.toStoreTransaction(receipt, str3, null, PurchaseState.UNSPECIFIED_STATE, userData);
                String receiptId = receipt.getReceiptId();
                r.e(receiptId, "receipt.receiptId");
                oVarA = t.a(UtilsKt.sha1(receiptId), storeTransaction);
            }
            if (oVarA != null) {
                arrayList.add(oVarA);
            }
        }
        return L.o(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void trackAmazonQueryProductDetailsRequestIfNeeded(boolean z4, Date date, Set<String> set) {
        DiagnosticsTracker diagnosticsTracker = this.diagnosticsTrackerIfEnabled;
        if (diagnosticsTracker != null) {
            diagnosticsTracker.m103trackAmazonQueryProductDetailsRequestKLykuaI(DurationExtensionsKt.between(C1779a.f14679b, date, this.dateProvider.getNow()), z4, set);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void trackAmazonQueryPurchasesRequestIfNeeded(boolean z4, Date date, List<Receipt> list) {
        ArrayList arrayList;
        DiagnosticsTracker diagnosticsTracker = this.diagnosticsTrackerIfEnabled;
        if (diagnosticsTracker != null) {
            long jBetween = DurationExtensionsKt.between(C1779a.f14679b, date, this.dateProvider.getNow());
            if (list != null) {
                arrayList = new ArrayList(AbstractC0770q.q(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(((Receipt) it.next()).getSku());
                }
            } else {
                arrayList = null;
            }
            diagnosticsTracker.m104trackAmazonQueryPurchasesRequestKLykuaI(jBetween, z4, arrayList);
        }
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void consumeAndSave(boolean z4, StoreTransaction purchase, boolean z5, PostReceiptInitiationSource initiationSource) {
        r.f(purchase, "purchase");
        r.f(initiationSource, "initiationSource");
        if (!shouldFinishTransactions() || purchase.getType() == com.revenuecat.purchases.ProductType.UNKNOWN || purchase.getPurchaseState() == PurchaseState.PENDING) {
            return;
        }
        if (z4) {
            executeRequestOnUIThread(new AnonymousClass1(purchase));
        }
        this.cache.addSuccessfullyPostedToken(purchase.getPurchaseToken());
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void endConnection() {
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void findPurchaseInPurchaseHistory(String appUserID, com.revenuecat.purchases.ProductType productType, String productId, k onCompletion, k onError) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        r.f(appUserID, "appUserID");
        r.f(productType, "productType");
        r.f(productId, "productId");
        r.f(onCompletion, "onCompletion");
        r.f(onError, "onError");
        LogIntent logIntent = LogIntent.DEBUG;
        AmazonBilling$findPurchaseInPurchaseHistory$$inlined$log$1 amazonBilling$findPurchaseInPurchaseHistory$$inlined$log$1 = new AmazonBilling$findPurchaseInPurchaseHistory$$inlined$log$1(logIntent, productId, productType);
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    str2 = (String) amazonBilling$findPurchaseInPurchaseHistory$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) amazonBilling$findPurchaseInPurchaseHistory$$inlined$log$1.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) amazonBilling$findPurchaseInPurchaseHistory$$inlined$log$1.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) amazonBilling$findPurchaseInPurchaseHistory$$inlined$log$1.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    str2 = (String) amazonBilling$findPurchaseInPurchaseHistory$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) amazonBilling$findPurchaseInPurchaseHistory$$inlined$log$1.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) amazonBilling$findPurchaseInPurchaseHistory$$inlined$log$1.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    str2 = (String) amazonBilling$findPurchaseInPurchaseHistory$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    str2 = (String) amazonBilling$findPurchaseInPurchaseHistory$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) amazonBilling$findPurchaseInPurchaseHistory$$inlined$log$1.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) amazonBilling$findPurchaseInPurchaseHistory$$inlined$log$1.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) amazonBilling$findPurchaseInPurchaseHistory$$inlined$log$1.invoke(), null);
                break;
        }
        queryAllPurchases(appUserID, new AnonymousClass2(onCompletion, productId, onError), onError);
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void getAmazonLWAConsentStatus(k onSuccess, k onError) {
        r.f(onSuccess, "onSuccess");
        r.f(onError, "onError");
        executeRequestOnUIThread(new C11281(onError, onSuccess));
    }

    @Override // com.revenuecat.purchases.amazon.listener.ProductDataResponseListener
    public void getProductData(Set<String> skus, String marketplace, k onReceive, k onError) {
        r.f(skus, "skus");
        r.f(marketplace, "marketplace");
        r.f(onReceive, "onReceive");
        r.f(onError, "onError");
        this.productDataHandler.getProductData(skus, marketplace, onReceive, onError);
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void getStorefront(k onSuccess, k onError) {
        r.f(onSuccess, "onSuccess");
        r.f(onError, "onError");
        executeRequestOnUIThread(new C11291(onError, onSuccess));
    }

    @Override // com.revenuecat.purchases.amazon.listener.UserDataResponseListener
    public void getUserData(k onSuccess, k onError) {
        r.f(onSuccess, "onSuccess");
        r.f(onError, "onError");
        this.userDataHandler.getUserData(onSuccess, onError);
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public boolean isConnected() {
        return this.connected;
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void makePurchaseAsync(Activity activity, String appUserID, PurchasingData purchasingData, ReplaceProductInfo replaceProductInfo, PresentedOfferingContext presentedOfferingContext, Boolean bool) {
        r.f(activity, "activity");
        r.f(appUserID, "appUserID");
        r.f(purchasingData, "purchasingData");
        AmazonPurchasingData.Product product = purchasingData instanceof AmazonPurchasingData.Product ? (AmazonPurchasingData.Product) purchasingData : null;
        if (product == null) {
            PurchasesErrorCode purchasesErrorCode = PurchasesErrorCode.UnknownError;
            String str = String.format(PurchaseStrings.INVALID_PURCHASE_TYPE, Arrays.copyOf(new Object[]{"Amazon", "AmazonPurchaseInfo"}, 2));
            r.e(str, "format(this, *args)");
            PurchasesError purchasesError = new PurchasesError(purchasesErrorCode, str);
            LogUtilsKt.errorLog(purchasesError);
            BillingAbstract.PurchasesUpdatedListener purchasesUpdatedListener = getPurchasesUpdatedListener();
            if (purchasesUpdatedListener != null) {
                purchasesUpdatedListener.onPurchasesFailedToUpdate(purchasesError);
            }
            return;
        }
        AmazonStoreProduct storeProduct = product.getStoreProduct();
        if (shouldFinishTransactions()) {
            if (replaceProductInfo == null) {
                executeRequestOnUIThread(new C11322(activity, appUserID, storeProduct, presentedOfferingContext));
                return;
            }
            LogIntent logIntent = LogIntent.AMAZON_WARNING;
            AmazonBilling$makePurchaseAsync$$inlined$log$1 amazonBilling$makePurchaseAsync$$inlined$log$1 = new AmazonBilling$makePurchaseAsync$$inlined$log$1(logIntent);
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                case 1:
                    LogLevel logLevel = LogLevel.DEBUG;
                    LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        currentLogHandler.d("[Purchases] - " + logLevel.name(), (String) amazonBilling$makePurchaseAsync$$inlined$log$1.invoke());
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) amazonBilling$makePurchaseAsync$$inlined$log$1.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel2 = LogLevel.WARN;
                    LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) amazonBilling$makePurchaseAsync$$inlined$log$1.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel3 = LogLevel.INFO;
                    LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                        currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) amazonBilling$makePurchaseAsync$$inlined$log$1.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel4 = LogLevel.DEBUG;
                    LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                        currentLogHandler4.d("[Purchases] - " + logLevel4.name(), (String) amazonBilling$makePurchaseAsync$$inlined$log$1.invoke());
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) amazonBilling$makePurchaseAsync$$inlined$log$1.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel5 = LogLevel.INFO;
                    LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                        currentLogHandler5.i("[Purchases] - " + logLevel5.name(), (String) amazonBilling$makePurchaseAsync$$inlined$log$1.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel6 = LogLevel.DEBUG;
                    LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                        currentLogHandler6.d("[Purchases] - " + logLevel6.name(), (String) amazonBilling$makePurchaseAsync$$inlined$log$1.invoke());
                    }
                    break;
                case 9:
                    LogLevel logLevel7 = LogLevel.DEBUG;
                    LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                        currentLogHandler7.d("[Purchases] - " + logLevel7.name(), (String) amazonBilling$makePurchaseAsync$$inlined$log$1.invoke());
                    }
                    break;
                case 10:
                    LogLevel logLevel8 = LogLevel.WARN;
                    LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                        currentLogHandler8.w("[Purchases] - " + logLevel8.name(), (String) amazonBilling$makePurchaseAsync$$inlined$log$1.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel9 = LogLevel.WARN;
                    LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                        currentLogHandler9.w("[Purchases] - " + logLevel9.name(), (String) amazonBilling$makePurchaseAsync$$inlined$log$1.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) amazonBilling$makePurchaseAsync$$inlined$log$1.invoke(), null);
                    break;
            }
        }
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void normalizePurchaseData(String productID, String purchaseToken, String storeUserID, k onSuccess, k onError) {
        r.f(productID, "productID");
        r.f(purchaseToken, "purchaseToken");
        r.f(storeUserID, "storeUserID");
        r.f(onSuccess, "onSuccess");
        r.f(onError, "onError");
        String str = this.cache.getReceiptSkus().get(purchaseToken);
        if (str != null) {
            onSuccess.invoke(str);
        } else {
            this.amazonBackend.getAmazonReceiptData(purchaseToken, storeUserID, new C11332(onError, purchaseToken, onSuccess), new AnonymousClass3(onError));
        }
    }

    @Override // com.amazon.device.iap.PurchasingListener, com.revenuecat.purchases.amazon.listener.PurchaseResponseListener, com.revenuecat.purchases.amazon.listener.PurchaseUpdatesResponseListener, com.revenuecat.purchases.amazon.listener.UserDataResponseListener
    public void onProductDataResponse(ProductDataResponse response) {
        r.f(response, "response");
        if (shouldFinishTransactions()) {
            this.productDataHandler.onProductDataResponse(response);
        }
    }

    @Override // com.revenuecat.purchases.amazon.listener.ProductDataResponseListener, com.amazon.device.iap.PurchasingListener, com.revenuecat.purchases.amazon.listener.PurchaseUpdatesResponseListener, com.revenuecat.purchases.amazon.listener.UserDataResponseListener
    public void onPurchaseResponse(PurchaseResponse response) {
        r.f(response, "response");
        if (shouldFinishTransactions()) {
            this.purchaseHandler.onPurchaseResponse(response);
        }
    }

    @Override // com.revenuecat.purchases.amazon.listener.ProductDataResponseListener, com.amazon.device.iap.PurchasingListener, com.revenuecat.purchases.amazon.listener.PurchaseResponseListener, com.revenuecat.purchases.amazon.listener.UserDataResponseListener
    public void onPurchaseUpdatesResponse(PurchaseUpdatesResponse response) {
        r.f(response, "response");
        if (shouldFinishTransactions()) {
            this.purchaseUpdatesHandler.onPurchaseUpdatesResponse(response);
        }
    }

    @Override // com.revenuecat.purchases.amazon.listener.ProductDataResponseListener, com.amazon.device.iap.PurchasingListener, com.revenuecat.purchases.amazon.listener.PurchaseResponseListener, com.revenuecat.purchases.amazon.listener.PurchaseUpdatesResponseListener
    public void onUserDataResponse(UserDataResponse response) {
        r.f(response, "response");
        if (shouldFinishTransactions()) {
            this.userDataHandler.onUserDataResponse(response);
        }
    }

    @Override // com.revenuecat.purchases.amazon.listener.PurchaseResponseListener
    public void purchase(Handler mainHandler, Activity activity, String appUserID, StoreProduct storeProduct, i3.o onSuccess, k onError) {
        r.f(mainHandler, "mainHandler");
        r.f(activity, "activity");
        r.f(appUserID, "appUserID");
        r.f(storeProduct, "storeProduct");
        r.f(onSuccess, "onSuccess");
        r.f(onError, "onError");
        this.purchaseHandler.purchase(mainHandler, activity, appUserID, storeProduct, onSuccess, onError);
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void queryAllPurchases(String appUserID, k onReceivePurchaseHistory, k onReceivePurchaseHistoryError) {
        r.f(appUserID, "appUserID");
        r.f(onReceivePurchaseHistory, "onReceivePurchaseHistory");
        r.f(onReceivePurchaseHistoryError, "onReceivePurchaseHistoryError");
        queryPurchases(false, (k) new C11341(onReceivePurchaseHistory), onReceivePurchaseHistoryError);
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void queryProductDetailsAsync(com.revenuecat.purchases.ProductType productType, Set<String> productIds, k onReceive, k onError) {
        r.f(productType, "productType");
        r.f(productIds, "productIds");
        r.f(onReceive, "onReceive");
        r.f(onError, "onError");
        if (shouldFinishTransactions()) {
            executeRequestOnUIThread(new C11351(onError, productIds, onReceive));
        }
    }

    @Override // com.revenuecat.purchases.amazon.listener.PurchaseUpdatesResponseListener
    public void queryPurchases(i3.o onSuccess, k onError) {
        r.f(onSuccess, "onSuccess");
        r.f(onError, "onError");
        this.purchaseUpdatesHandler.queryPurchases(onSuccess, onError);
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void showInAppMessagesIfNeeded(Activity activity, List<? extends InAppMessageType> inAppMessageTypes, Function0 subscriptionStatusChange) {
        r.f(activity, "activity");
        r.f(inAppMessageTypes, "inAppMessageTypes");
        r.f(subscriptionStatusChange, "subscriptionStatusChange");
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void startConnection() {
        if (shouldFinishTransactions()) {
            this.purchasingServiceProvider.registerListener(this.applicationContext, this);
            this.connected = true;
            BillingAbstract.StateListener stateListener = getStateListener();
            if (stateListener != null) {
                stateListener.onConnected();
            }
            executePendingRequests();
        }
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void startConnectionOnMainThread(long j4) {
        runOnUIThread(new Runnable() { // from class: com.revenuecat.purchases.amazon.b
            @Override // java.lang.Runnable
            public final void run() {
                AmazonBilling.startConnectionOnMainThread$lambda$0(this.f11283a);
            }
        });
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void queryPurchases(String appUserID, k onSuccess, k onError) {
        r.f(appUserID, "appUserID");
        r.f(onSuccess, "onSuccess");
        r.f(onError, "onError");
        if (shouldFinishTransactions()) {
            queryPurchases(true, onSuccess, onError);
        }
    }

    private final void queryPurchases(boolean z4, k kVar, k kVar2) {
        executeRequestOnUIThread(new C11361(kVar2, z4, kVar));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmazonBilling(Context applicationContext, AmazonBackend amazonBackend, AmazonCache cache, boolean z4, Handler mainHandler, PurchasesStateProvider stateProvider, DiagnosticsTracker diagnosticsTracker, PurchasingServiceProvider purchasingServiceProvider, ProductDataResponseListener productDataHandler, PurchaseResponseListener purchaseHandler, PurchaseUpdatesResponseListener purchaseUpdatesHandler, UserDataResponseListener userDataHandler, DateProvider dateProvider) {
        super(stateProvider);
        r.f(applicationContext, "applicationContext");
        r.f(amazonBackend, "amazonBackend");
        r.f(cache, "cache");
        r.f(mainHandler, "mainHandler");
        r.f(stateProvider, "stateProvider");
        r.f(purchasingServiceProvider, "purchasingServiceProvider");
        r.f(productDataHandler, "productDataHandler");
        r.f(purchaseHandler, "purchaseHandler");
        r.f(purchaseUpdatesHandler, "purchaseUpdatesHandler");
        r.f(userDataHandler, "userDataHandler");
        r.f(dateProvider, "dateProvider");
        this.applicationContext = applicationContext;
        this.amazonBackend = amazonBackend;
        this.cache = cache;
        this.finishTransactions = z4;
        this.mainHandler = mainHandler;
        this.diagnosticsTrackerIfEnabled = diagnosticsTracker;
        this.purchasingServiceProvider = purchasingServiceProvider;
        this.productDataHandler = productDataHandler;
        this.purchaseHandler = purchaseHandler;
        this.purchaseUpdatesHandler = purchaseUpdatesHandler;
        this.userDataHandler = userDataHandler;
        this.dateProvider = dateProvider;
        this.serviceRequests = new ConcurrentLinkedQueue<>();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AmazonBilling(Context applicationContext, DeviceCache cache, boolean z4, Handler mainHandler, BackendHelper backendHelper, PurchasesStateProvider stateProvider, DiagnosticsTracker diagnosticsTracker) {
        this(applicationContext, new AmazonBackend(backendHelper), new AmazonCache(cache), z4, mainHandler, stateProvider, diagnosticsTracker, null, null, null, null, null, null, 8064, null);
        r.f(applicationContext, "applicationContext");
        r.f(cache, "cache");
        r.f(mainHandler, "mainHandler");
        r.f(backendHelper, "backendHelper");
        r.f(stateProvider, "stateProvider");
    }
}
