package com.revenuecat.purchases;

import android.app.Activity;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.interfaces.GetAmazonLWAConsentStatusCallback;
import com.revenuecat.purchases.interfaces.GetCustomerCenterConfigCallback;
import com.revenuecat.purchases.interfaces.GetVirtualCurrenciesCallback;
import com.revenuecat.purchases.interfaces.LogInCallback;
import com.revenuecat.purchases.interfaces.ProductChangeCallback;
import com.revenuecat.purchases.interfaces.SyncAttributesAndOfferingsCallback;
import com.revenuecat.purchases.interfaces.SyncPurchasesCallback;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.virtualcurrencies.VirtualCurrencies;
import i3.k;
import i3.o;
import java.util.List;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class ListenerConversionsKt {
    public static final GetAmazonLWAConsentStatusCallback getAmazonLWAConsentStatusListener(final k onSuccess, final k onError) {
        r.f(onSuccess, "onSuccess");
        r.f(onError, "onError");
        return new GetAmazonLWAConsentStatusCallback() { // from class: com.revenuecat.purchases.ListenerConversionsKt.getAmazonLWAConsentStatusListener.1
            @Override // com.revenuecat.purchases.interfaces.GetAmazonLWAConsentStatusCallback
            public void onError(PurchasesError error) {
                r.f(error, "error");
                onError.invoke(error);
            }

            @Override // com.revenuecat.purchases.interfaces.GetAmazonLWAConsentStatusCallback
            public void onSuccess(AmazonLWAConsentStatus consentStatus) {
                r.f(consentStatus, "consentStatus");
                onSuccess.invoke(consentStatus);
            }
        };
    }

    public static final void getAmazonLWAConsentStatusWith(Purchases purchases, k onError, k onSuccess) {
        r.f(purchases, "<this>");
        r.f(onError, "onError");
        r.f(onSuccess, "onSuccess");
        purchases.getAmazonLWAConsentStatus(getAmazonLWAConsentStatusListener(onSuccess, onError));
    }

    public static /* synthetic */ void getAmazonLWAConsentStatusWith$default(Purchases purchases, k kVar, k kVar2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            kVar = ListenerConversionsCommonKt.getON_ERROR_STUB();
        }
        getAmazonLWAConsentStatusWith(purchases, kVar, kVar2);
    }

    public static final GetCustomerCenterConfigCallback getCustomerCenterConfigDataListener(final k onSuccess, final k onError) {
        r.f(onSuccess, "onSuccess");
        r.f(onError, "onError");
        return new GetCustomerCenterConfigCallback() { // from class: com.revenuecat.purchases.ListenerConversionsKt.getCustomerCenterConfigDataListener.1
            @Override // com.revenuecat.purchases.interfaces.GetCustomerCenterConfigCallback
            public void onError(PurchasesError error) {
                r.f(error, "error");
                onError.invoke(error);
            }

            @Override // com.revenuecat.purchases.interfaces.GetCustomerCenterConfigCallback
            public void onSuccess(CustomerCenterConfigData customerCenterConfig) {
                r.f(customerCenterConfig, "customerCenterConfig");
                onSuccess.invoke(customerCenterConfig);
            }
        };
    }

    public static final void getCustomerInfoWith(Purchases purchases, k onError, k onSuccess) {
        r.f(purchases, "<this>");
        r.f(onError, "onError");
        r.f(onSuccess, "onSuccess");
        purchases.getCustomerInfo(ListenerConversionsCommonKt.receiveCustomerInfoCallback(onSuccess, onError));
    }

    public static /* synthetic */ void getCustomerInfoWith$default(Purchases purchases, k kVar, k kVar2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            kVar = ListenerConversionsCommonKt.getON_ERROR_STUB();
        }
        getCustomerInfoWith(purchases, kVar, kVar2);
    }

    public static final void getNonSubscriptionSkusWith(Purchases purchases, List<String> skus, k onError, k onReceiveSkus) {
        r.f(purchases, "<this>");
        r.f(skus, "skus");
        r.f(onError, "onError");
        r.f(onReceiveSkus, "onReceiveSkus");
        purchases.getProducts(skus, ProductType.INAPP, ListenerConversionsCommonKt.getStoreProductsCallback(onReceiveSkus, onError));
    }

    public static final void getSubscriptionSkusWith(Purchases purchases, List<String> skus, k onError, k onReceiveSkus) {
        r.f(purchases, "<this>");
        r.f(skus, "skus");
        r.f(onError, "onError");
        r.f(onReceiveSkus, "onReceiveSkus");
        purchases.getProducts(skus, ProductType.SUBS, ListenerConversionsCommonKt.getStoreProductsCallback(onReceiveSkus, onError));
    }

    public static /* synthetic */ void getSubscriptionSkusWith$default(Purchases purchases, List list, k kVar, k kVar2, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            kVar = ListenerConversionsCommonKt.getON_ERROR_STUB();
        }
        getSubscriptionSkusWith(purchases, list, kVar, kVar2);
    }

    public static final GetVirtualCurrenciesCallback getVirtualCurrenciesCallback(final k onSuccess, final k onError) {
        r.f(onSuccess, "onSuccess");
        r.f(onError, "onError");
        return new GetVirtualCurrenciesCallback() { // from class: com.revenuecat.purchases.ListenerConversionsKt.getVirtualCurrenciesCallback.1
            @Override // com.revenuecat.purchases.interfaces.GetVirtualCurrenciesCallback
            public void onError(PurchasesError error) {
                r.f(error, "error");
                onError.invoke(error);
            }

            @Override // com.revenuecat.purchases.interfaces.GetVirtualCurrenciesCallback
            public void onReceived(VirtualCurrencies virtualCurrencies) {
                r.f(virtualCurrencies, "virtualCurrencies");
                onSuccess.invoke(virtualCurrencies);
            }
        };
    }

    public static final void getVirtualCurrenciesWith(Purchases purchases, k onError, k onSuccess) {
        r.f(purchases, "<this>");
        r.f(onError, "onError");
        r.f(onSuccess, "onSuccess");
        purchases.getVirtualCurrencies(getVirtualCurrenciesCallback(onSuccess, onError));
    }

    public static /* synthetic */ void getVirtualCurrenciesWith$default(Purchases purchases, k kVar, k kVar2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            kVar = ListenerConversionsCommonKt.getON_ERROR_STUB();
        }
        getVirtualCurrenciesWith(purchases, kVar, kVar2);
    }

    public static final LogInCallback logInSuccessListener(final o onSuccess, final k onError) {
        r.f(onSuccess, "onSuccess");
        r.f(onError, "onError");
        return new LogInCallback() { // from class: com.revenuecat.purchases.ListenerConversionsKt.logInSuccessListener.1
            @Override // com.revenuecat.purchases.interfaces.LogInCallback
            public void onError(PurchasesError error) {
                r.f(error, "error");
                k kVar = onError;
                if (kVar != null) {
                }
            }

            @Override // com.revenuecat.purchases.interfaces.LogInCallback
            public void onReceived(CustomerInfo customerInfo, boolean z4) {
                r.f(customerInfo, "customerInfo");
                o oVar = onSuccess;
                if (oVar != null) {
                }
            }
        };
    }

    public static final void logInWith(Purchases purchases, String appUserID, k onError, o onSuccess) {
        r.f(purchases, "<this>");
        r.f(appUserID, "appUserID");
        r.f(onError, "onError");
        r.f(onSuccess, "onSuccess");
        purchases.logIn(appUserID, logInSuccessListener(onSuccess, onError));
    }

    public static /* synthetic */ void logInWith$default(Purchases purchases, String str, k kVar, o oVar, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            kVar = ListenerConversionsCommonKt.getON_ERROR_STUB();
        }
        logInWith(purchases, str, kVar, oVar);
    }

    public static final void logOutWith(Purchases purchases, k onError, k onSuccess) {
        r.f(purchases, "<this>");
        r.f(onError, "onError");
        r.f(onSuccess, "onSuccess");
        purchases.logOut(ListenerConversionsCommonKt.receiveCustomerInfoCallback(onSuccess, onError));
    }

    public static /* synthetic */ void logOutWith$default(Purchases purchases, k kVar, k kVar2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            kVar = ListenerConversionsCommonKt.getON_ERROR_STUB();
        }
        logOutWith(purchases, kVar, kVar2);
    }

    public static final ProductChangeCallback productChangeCompletedListener(final o onSuccess, final o onError) {
        r.f(onSuccess, "onSuccess");
        r.f(onError, "onError");
        return new ProductChangeCallback() { // from class: com.revenuecat.purchases.ListenerConversionsKt.productChangeCompletedListener.1
            @Override // com.revenuecat.purchases.interfaces.ProductChangeCallback
            public void onCompleted(StoreTransaction storeTransaction, CustomerInfo customerInfo) {
                r.f(customerInfo, "customerInfo");
                onSuccess.invoke(storeTransaction, customerInfo);
            }

            @Override // com.revenuecat.purchases.interfaces.PurchaseErrorCallback
            public void onError(PurchasesError error, boolean z4) {
                r.f(error, "error");
                onError.invoke(error, Boolean.valueOf(z4));
            }
        };
    }

    public static final void purchasePackageWith(Purchases purchases, Activity activity, Package packageToPurchase, o onError, o onSuccess) {
        r.f(purchases, "<this>");
        r.f(activity, "activity");
        r.f(packageToPurchase, "packageToPurchase");
        r.f(onError, "onError");
        r.f(onSuccess, "onSuccess");
        purchases.purchasePackage(activity, packageToPurchase, ListenerConversionsCommonKt.purchaseCompletedCallback(onSuccess, onError));
    }

    public static /* synthetic */ void purchasePackageWith$default(Purchases purchases, Activity activity, Package r22, o oVar, o oVar2, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            oVar = ListenerConversionsCommonKt.getON_PURCHASE_ERROR_STUB();
        }
        purchasePackageWith(purchases, activity, r22, oVar, oVar2);
    }

    public static final void purchaseProductWith(Purchases purchases, Activity activity, StoreProduct storeProduct, o onError, o onSuccess) {
        r.f(purchases, "<this>");
        r.f(activity, "activity");
        r.f(storeProduct, "storeProduct");
        r.f(onError, "onError");
        r.f(onSuccess, "onSuccess");
        purchases.purchaseProduct(activity, storeProduct, ListenerConversionsCommonKt.purchaseCompletedCallback(onSuccess, onError));
    }

    public static /* synthetic */ void purchaseProductWith$default(Purchases purchases, Activity activity, StoreProduct storeProduct, o oVar, o oVar2, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            oVar = ListenerConversionsCommonKt.getON_PURCHASE_ERROR_STUB();
        }
        purchaseProductWith(purchases, activity, storeProduct, oVar, oVar2);
    }

    public static final void syncAttributesAndOfferingsIfNeededWith(Purchases purchases, k onError, k onSuccess) {
        r.f(purchases, "<this>");
        r.f(onError, "onError");
        r.f(onSuccess, "onSuccess");
        purchases.syncAttributesAndOfferingsIfNeeded(syncAttributesAndOfferingsListener(onSuccess, onError));
    }

    public static /* synthetic */ void syncAttributesAndOfferingsIfNeededWith$default(Purchases purchases, k kVar, k kVar2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            kVar = ListenerConversionsCommonKt.getON_ERROR_STUB();
        }
        syncAttributesAndOfferingsIfNeededWith(purchases, kVar, kVar2);
    }

    public static final SyncAttributesAndOfferingsCallback syncAttributesAndOfferingsListener(final k onSuccess, final k onError) {
        r.f(onSuccess, "onSuccess");
        r.f(onError, "onError");
        return new SyncAttributesAndOfferingsCallback() { // from class: com.revenuecat.purchases.ListenerConversionsKt.syncAttributesAndOfferingsListener.1
            @Override // com.revenuecat.purchases.interfaces.SyncAttributesAndOfferingsCallback
            public void onError(PurchasesError error) {
                r.f(error, "error");
                onError.invoke(error);
            }

            @Override // com.revenuecat.purchases.interfaces.SyncAttributesAndOfferingsCallback
            public void onSuccess(Offerings offerings) {
                r.f(offerings, "offerings");
                onSuccess.invoke(offerings);
            }
        };
    }

    public static final SyncPurchasesCallback syncPurchasesListener(final k onSuccess, final k onError) {
        r.f(onSuccess, "onSuccess");
        r.f(onError, "onError");
        return new SyncPurchasesCallback() { // from class: com.revenuecat.purchases.ListenerConversionsKt.syncPurchasesListener.1
            @Override // com.revenuecat.purchases.interfaces.SyncPurchasesCallback
            public void onError(PurchasesError error) {
                r.f(error, "error");
                onError.invoke(error);
            }

            @Override // com.revenuecat.purchases.interfaces.SyncPurchasesCallback
            public void onSuccess(CustomerInfo customerInfo) {
                r.f(customerInfo, "customerInfo");
                onSuccess.invoke(customerInfo);
            }
        };
    }

    public static final void syncPurchasesWith(Purchases purchases, k onError, k onSuccess) {
        r.f(purchases, "<this>");
        r.f(onError, "onError");
        r.f(onSuccess, "onSuccess");
        purchases.syncPurchases(syncPurchasesListener(onSuccess, onError));
    }

    public static /* synthetic */ void syncPurchasesWith$default(Purchases purchases, k kVar, k kVar2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            kVar = ListenerConversionsCommonKt.getON_ERROR_STUB();
        }
        syncPurchasesWith(purchases, kVar, kVar2);
    }

    public static final void getCustomerInfoWith(Purchases purchases, CacheFetchPolicy fetchPolicy, k onError, k onSuccess) {
        r.f(purchases, "<this>");
        r.f(fetchPolicy, "fetchPolicy");
        r.f(onError, "onError");
        r.f(onSuccess, "onSuccess");
        purchases.getCustomerInfo(fetchPolicy, ListenerConversionsCommonKt.receiveCustomerInfoCallback(onSuccess, onError));
    }

    public static /* synthetic */ void getCustomerInfoWith$default(Purchases purchases, CacheFetchPolicy cacheFetchPolicy, k kVar, k kVar2, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            kVar = ListenerConversionsCommonKt.getON_ERROR_STUB();
        }
        getCustomerInfoWith(purchases, cacheFetchPolicy, kVar, kVar2);
    }
}
