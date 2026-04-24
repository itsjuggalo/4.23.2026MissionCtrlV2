package com.revenuecat.purchases.common;

import android.app.Activity;
import com.revenuecat.purchases.AmazonLWAConsentStatus;
import com.revenuecat.purchases.PostReceiptInitiationSource;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesStateProvider;
import com.revenuecat.purchases.models.InAppMessageType;
import com.revenuecat.purchases.models.PurchasingData;
import com.revenuecat.purchases.models.StoreTransaction;
import i3.k;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public abstract class BillingAbstract {
    private final PurchasesStateProvider purchasesStateProvider;
    private volatile PurchasesUpdatedListener purchasesUpdatedListener;
    private volatile StateListener stateListener;

    public interface PurchasesUpdatedListener {
        void onPurchasesFailedToUpdate(PurchasesError purchasesError);

        void onPurchasesUpdated(List<StoreTransaction> list);
    }

    public interface StateListener {
        void onConnected();
    }

    public BillingAbstract(PurchasesStateProvider purchasesStateProvider) {
        r.f(purchasesStateProvider, "purchasesStateProvider");
        this.purchasesStateProvider = purchasesStateProvider;
    }

    public static /* synthetic */ void makePurchaseAsync$default(BillingAbstract billingAbstract, Activity activity, String str, PurchasingData purchasingData, ReplaceProductInfo replaceProductInfo, PresentedOfferingContext presentedOfferingContext, Boolean bool, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: makePurchaseAsync");
        }
        if ((i4 & 32) != 0) {
            bool = null;
        }
        billingAbstract.makePurchaseAsync(activity, str, purchasingData, replaceProductInfo, presentedOfferingContext, bool);
    }

    public static /* synthetic */ void startConnectionOnMainThread$default(BillingAbstract billingAbstract, long j4, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startConnectionOnMainThread");
        }
        if ((i4 & 1) != 0) {
            j4 = 0;
        }
        billingAbstract.startConnectionOnMainThread(j4);
    }

    public final void close() {
        this.purchasesUpdatedListener = null;
        endConnection();
    }

    public abstract void consumeAndSave(boolean z4, StoreTransaction storeTransaction, boolean z5, PostReceiptInitiationSource postReceiptInitiationSource);

    public abstract void endConnection();

    public abstract void findPurchaseInPurchaseHistory(String str, ProductType productType, String str2, k kVar, k kVar2);

    public void getAmazonLWAConsentStatus(k onSuccess, k onError) {
        r.f(onSuccess, "onSuccess");
        r.f(onError, "onError");
        onSuccess.invoke(AmazonLWAConsentStatus.UNAVAILABLE);
    }

    public final PurchasesStateProvider getPurchasesStateProvider() {
        return this.purchasesStateProvider;
    }

    public final synchronized PurchasesUpdatedListener getPurchasesUpdatedListener() {
        return this.purchasesUpdatedListener;
    }

    public final synchronized StateListener getStateListener() {
        return this.stateListener;
    }

    public abstract void getStorefront(k kVar, k kVar2);

    public abstract boolean isConnected();

    public abstract void makePurchaseAsync(Activity activity, String str, PurchasingData purchasingData, ReplaceProductInfo replaceProductInfo, PresentedOfferingContext presentedOfferingContext, Boolean bool);

    public void normalizePurchaseData(String productID, String purchaseToken, String storeUserID, k onSuccess, k onError) {
        r.f(productID, "productID");
        r.f(purchaseToken, "purchaseToken");
        r.f(storeUserID, "storeUserID");
        r.f(onSuccess, "onSuccess");
        r.f(onError, "onError");
        onSuccess.invoke(productID);
    }

    public abstract void queryAllPurchases(String str, k kVar, k kVar2);

    public abstract void queryProductDetailsAsync(ProductType productType, Set<String> set, k kVar, k kVar2);

    public abstract void queryPurchases(String str, k kVar, k kVar2);

    public final void setPurchasesUpdatedListener(PurchasesUpdatedListener purchasesUpdatedListener) {
        this.purchasesUpdatedListener = purchasesUpdatedListener;
    }

    public final synchronized void setStateListener(StateListener stateListener) {
        this.stateListener = stateListener;
    }

    public abstract void showInAppMessagesIfNeeded(Activity activity, List<? extends InAppMessageType> list, Function0 function0);

    public abstract void startConnection();

    public abstract void startConnectionOnMainThread(long j4);
}
