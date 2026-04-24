package com.revenuecat.purchases.simulatedstore;

import W2.E;
import X2.AbstractC0768o;
import X2.AbstractC0769p;
import X2.AbstractC0770q;
import X2.L;
import android.app.Activity;
import android.os.Handler;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.PostReceiptInitiationSource;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.PurchasesException;
import com.revenuecat.purchases.PurchasesStateProvider;
import com.revenuecat.purchases.ReplacementMode;
import com.revenuecat.purchases.common.Backend;
import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.ReplaceProductInfo;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.common.networking.WebBillingProductResponse;
import com.revenuecat.purchases.common.networking.WebBillingProductsResponse;
import com.revenuecat.purchases.models.InAppMessageType;
import com.revenuecat.purchases.models.PricingPhase;
import com.revenuecat.purchases.models.PurchaseState;
import com.revenuecat.purchases.models.PurchaseType;
import com.revenuecat.purchases.models.PurchasingData;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.utils.AlertDialogHelper;
import com.revenuecat.purchases.utils.DefaultAlertDialogHelper;
import i3.k;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class SimulatedStoreBillingWrapper extends BillingAbstract {
    private final Backend backend;
    private volatile boolean connected;
    private final DeviceCache deviceCache;
    private final AlertDialogHelper dialogHelper;
    private final Handler mainHandler;

    /* JADX INFO: renamed from: com.revenuecat.purchases.simulatedstore.SimulatedStoreBillingWrapper$queryProductDetailsAsync$2, reason: invalid class name */
    public static final class AnonymousClass2 extends s implements k {
        final /* synthetic */ k $onError;
        final /* synthetic */ k $onReceive;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(k kVar, k kVar2) {
            super(1);
            this.$onReceive = kVar;
            this.$onError = kVar2;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((WebBillingProductsResponse) obj);
            return E.f5463a;
        }

        public final void invoke(WebBillingProductsResponse response) {
            r.f(response, "response");
            try {
                List<WebBillingProductResponse> productDetails = response.getProductDetails();
                ArrayList arrayList = new ArrayList(AbstractC0770q.q(productDetails, 10));
                Iterator<T> it = productDetails.iterator();
                while (it.hasNext()) {
                    arrayList.add(SimulatedStoreProductConverter.convertToStoreProduct$default(SimulatedStoreProductConverter.INSTANCE, (WebBillingProductResponse) it.next(), null, 2, null));
                }
                this.$onReceive.invoke(arrayList);
            } catch (PurchasesException e4) {
                this.$onError.invoke(e4.getError());
            }
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.simulatedstore.SimulatedStoreBillingWrapper$showPurchaseDialog$1, reason: invalid class name */
    public static final class AnonymousClass1 extends s implements Function0 {
        final /* synthetic */ PresentedOfferingContext $presentedOfferingContext;
        final /* synthetic */ StoreProduct $product;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(StoreProduct storeProduct, PresentedOfferingContext presentedOfferingContext) {
            super(0);
            this.$product = storeProduct;
            this.$presentedOfferingContext = presentedOfferingContext;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() throws JSONException {
            m208invoke();
            return E.f5463a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m208invoke() throws JSONException {
            SimulatedStoreBillingWrapper.this.completePurchase(this.$product, this.$presentedOfferingContext);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.simulatedstore.SimulatedStoreBillingWrapper$showPurchaseDialog$2, reason: invalid class name and case insensitive filesystem */
    public static final class C11982 extends s implements Function0 {
        public C11982() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m209invoke();
            return E.f5463a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m209invoke() {
            BillingAbstract.PurchasesUpdatedListener purchasesUpdatedListener = SimulatedStoreBillingWrapper.this.getPurchasesUpdatedListener();
            if (purchasesUpdatedListener != null) {
                purchasesUpdatedListener.onPurchasesFailedToUpdate(new PurchasesError(PurchasesErrorCode.ProductNotAvailableForPurchaseError, "Test purchase failure: no real transaction occurred"));
            }
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.simulatedstore.SimulatedStoreBillingWrapper$showPurchaseDialog$3, reason: invalid class name */
    public static final class AnonymousClass3 extends s implements Function0 {
        public AnonymousClass3() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m210invoke();
            return E.f5463a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m210invoke() {
            BillingAbstract.PurchasesUpdatedListener purchasesUpdatedListener = SimulatedStoreBillingWrapper.this.getPurchasesUpdatedListener();
            if (purchasesUpdatedListener != null) {
                purchasesUpdatedListener.onPurchasesFailedToUpdate(new PurchasesError(PurchasesErrorCode.PurchaseCancelledError, "Purchase cancelled by user"));
            }
        }
    }

    public /* synthetic */ SimulatedStoreBillingWrapper(DeviceCache deviceCache, Handler handler, PurchasesStateProvider purchasesStateProvider, Backend backend, AlertDialogHelper alertDialogHelper, int i4, AbstractC1585j abstractC1585j) {
        this(deviceCache, handler, purchasesStateProvider, backend, (i4 & 16) != 0 ? new DefaultAlertDialogHelper() : alertDialogHelper);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void completePurchase(StoreProduct storeProduct, PresentedOfferingContext presentedOfferingContext) throws JSONException {
        long time = new Date().getTime();
        String str = "test_" + time + '_' + UUID.randomUUID();
        List listB = AbstractC0768o.b(storeProduct.getId());
        ProductType type = storeProduct.getType();
        PurchaseState purchaseState = PurchaseState.PURCHASED;
        Boolean boolValueOf = Boolean.valueOf(storeProduct.getType() == ProductType.SUBS);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("orderId", str);
        jSONObject.put("productId", storeProduct.getId());
        jSONObject.put("purchaseTime", time);
        jSONObject.put("purchaseToken", str);
        jSONObject.put("purchaseState", purchaseState.ordinal());
        E e4 = E.f5463a;
        PurchaseType purchaseType = PurchaseType.GOOGLE_PURCHASE;
        SubscriptionOption defaultOption = storeProduct.getDefaultOption();
        StoreTransaction storeTransaction = new StoreTransaction(str, (List<String>) listB, type, time, str, purchaseState, boolValueOf, (String) null, jSONObject, presentedOfferingContext, (String) null, purchaseType, (String) null, defaultOption != null ? defaultOption.getId() : null, (ReplacementMode) null);
        BillingAbstract.PurchasesUpdatedListener purchasesUpdatedListener = getPurchasesUpdatedListener();
        if (purchasesUpdatedListener != null) {
            purchasesUpdatedListener.onPurchasesUpdated(AbstractC0768o.b(storeTransaction));
        }
    }

    private final void showPurchaseDialog(Activity activity, StoreProduct storeProduct, PresentedOfferingContext presentedOfferingContext) {
        StringBuilder sb = new StringBuilder();
        sb.append("Product: " + storeProduct.getId() + '\n');
        sb.append("Price: " + storeProduct.getPrice().getFormatted() + '\n');
        SubscriptionOption defaultOption = storeProduct.getDefaultOption();
        if (defaultOption != null) {
            for (PricingPhase pricingPhase : defaultOption.getPricingPhases()) {
                sb.append("Phase: " + pricingPhase.getPrice().getFormatted() + " for " + pricingPhase.getBillingPeriod().getIso8601() + '\n');
            }
        }
        String string = sb.toString();
        r.e(string, "StringBuilder().apply(builderAction).toString()");
        this.dialogHelper.showDialog(activity, "Test Store Purchase", string, "Test valid Purchase", "Test failed Purchase", "Cancel", new AnonymousClass1(storeProduct, presentedOfferingContext), new C11982(), new AnonymousClass3());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startConnectionOnMainThread$lambda$0(SimulatedStoreBillingWrapper this$0) {
        r.f(this$0, "this$0");
        this$0.startConnection();
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void consumeAndSave(boolean z4, StoreTransaction purchase, boolean z5, PostReceiptInitiationSource initiationSource) {
        r.f(purchase, "purchase");
        r.f(initiationSource, "initiationSource");
        LogLevel logLevel = LogLevel.DEBUG;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.d("[Purchases] - " + logLevel.name(), "SimulatedStoreBillingAbstract: consumeAndSave - no-op for test store");
        }
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void endConnection() {
        LogLevel logLevel = LogLevel.DEBUG;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.d("[Purchases] - " + logLevel.name(), "SimulatedStoreBillingAbstract: Ending connection");
        }
        this.connected = false;
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void findPurchaseInPurchaseHistory(String appUserID, ProductType productType, String productId, k onCompletion, k onError) {
        r.f(appUserID, "appUserID");
        r.f(productType, "productType");
        r.f(productId, "productId");
        r.f(onCompletion, "onCompletion");
        r.f(onError, "onError");
        LogLevel logLevel = LogLevel.DEBUG;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.d("[Purchases] - " + logLevel.name(), "SimulatedStoreBillingAbstract: findPurchaseInPurchaseHistory for product: " + productId + " will always fail");
        }
        onError.invoke(new PurchasesError(PurchasesErrorCode.PurchaseNotAllowedError, "No active purchase found for product: " + productId));
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void getStorefront(k onSuccess, k onError) {
        r.f(onSuccess, "onSuccess");
        r.f(onError, "onError");
        LogLevel logLevel = LogLevel.DEBUG;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.d("[Purchases] - " + logLevel.name(), "SimulatedStoreBillingAbstract: getStorefront - returning US by default");
        }
        onSuccess.invoke("US");
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public boolean isConnected() {
        return this.connected;
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void makePurchaseAsync(Activity activity, String appUserID, PurchasingData purchasingData, ReplaceProductInfo replaceProductInfo, PresentedOfferingContext presentedOfferingContext, Boolean bool) throws PurchasesException {
        r.f(activity, "activity");
        r.f(appUserID, "appUserID");
        r.f(purchasingData, "purchasingData");
        LogLevel logLevel = LogLevel.DEBUG;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.d("[Purchases] - " + logLevel.name(), "SimulatedStoreBillingAbstract: makePurchaseAsync for product: " + purchasingData.getProductId());
        }
        SimulatedStorePurchasingData simulatedStorePurchasingData = purchasingData instanceof SimulatedStorePurchasingData ? (SimulatedStorePurchasingData) purchasingData : null;
        if (simulatedStorePurchasingData != null) {
            showPurchaseDialog(activity, simulatedStorePurchasingData.getStoreProduct(), presentedOfferingContext);
            return;
        }
        throw new PurchasesException(new PurchasesError(PurchasesErrorCode.ProductNotAvailableForPurchaseError, "Purchasing data is not a valid SimulatedStorePurchasingData: " + purchasingData.getProductId()));
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void queryAllPurchases(String appUserID, k onReceivePurchaseHistory, k onReceivePurchaseHistoryError) {
        r.f(appUserID, "appUserID");
        r.f(onReceivePurchaseHistory, "onReceivePurchaseHistory");
        r.f(onReceivePurchaseHistoryError, "onReceivePurchaseHistoryError");
        LogLevel logLevel = LogLevel.DEBUG;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.d("[Purchases] - " + logLevel.name(), "SimulatedStoreBillingAbstract: queryAllPurchases - returning empty list");
        }
        onReceivePurchaseHistory.invoke(AbstractC0769p.g());
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void queryProductDetailsAsync(ProductType productType, Set<String> productIds, k onReceive, k onError) throws Throwable {
        r.f(productType, "productType");
        r.f(productIds, "productIds");
        r.f(onReceive, "onReceive");
        r.f(onError, "onError");
        LogLevel logLevel = LogLevel.DEBUG;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.d("[Purchases] - " + logLevel.name(), "SimulatedStoreBillingAbstract: queryProductDetailsAsync for products: " + productIds);
        }
        Backend backend = this.backend;
        String cachedAppUserID = this.deviceCache.getCachedAppUserID();
        if (cachedAppUserID == null) {
            cachedAppUserID = "";
        }
        backend.getWebBillingProducts(cachedAppUserID, productIds, new AnonymousClass2(onReceive, onError), onError);
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void queryPurchases(String appUserID, k onSuccess, k onError) {
        r.f(appUserID, "appUserID");
        r.f(onSuccess, "onSuccess");
        r.f(onError, "onError");
        LogLevel logLevel = LogLevel.DEBUG;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.d("[Purchases] - " + logLevel.name(), "SimulatedStoreBillingAbstract: queryPurchases - returning empty map");
        }
        onSuccess.invoke(L.e());
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void showInAppMessagesIfNeeded(Activity activity, List<? extends InAppMessageType> inAppMessageTypes, Function0 subscriptionStatusChange) {
        r.f(activity, "activity");
        r.f(inAppMessageTypes, "inAppMessageTypes");
        r.f(subscriptionStatusChange, "subscriptionStatusChange");
        LogLevel logLevel = LogLevel.DEBUG;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.d("[Purchases] - " + logLevel.name(), "SimulatedStoreBillingAbstract: showInAppMessagesIfNeeded - no-op for test store");
        }
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void startConnection() {
        LogLevel logLevel = LogLevel.DEBUG;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.d("[Purchases] - " + logLevel.name(), "SimulatedStoreBillingAbstract: Starting connection");
        }
        this.connected = true;
        BillingAbstract.StateListener stateListener = getStateListener();
        if (stateListener != null) {
            stateListener.onConnected();
        }
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void startConnectionOnMainThread(long j4) {
        this.mainHandler.postDelayed(new Runnable() { // from class: com.revenuecat.purchases.simulatedstore.a
            @Override // java.lang.Runnable
            public final void run() {
                SimulatedStoreBillingWrapper.startConnectionOnMainThread$lambda$0(this.f11359a);
            }
        }, j4);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimulatedStoreBillingWrapper(DeviceCache deviceCache, Handler mainHandler, PurchasesStateProvider purchasesStateProvider, Backend backend, AlertDialogHelper dialogHelper) {
        super(purchasesStateProvider);
        r.f(deviceCache, "deviceCache");
        r.f(mainHandler, "mainHandler");
        r.f(purchasesStateProvider, "purchasesStateProvider");
        r.f(backend, "backend");
        r.f(dialogHelper, "dialogHelper");
        this.deviceCache = deviceCache;
        this.mainHandler = mainHandler;
        this.backend = backend;
        this.dialogHelper = dialogHelper;
    }
}
