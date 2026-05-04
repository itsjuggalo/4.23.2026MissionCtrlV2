package com.revenuecat.purchases;

import android.app.Activity;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.interfaces.GetAmazonLWAConsentStatusCallback;
import com.revenuecat.purchases.interfaces.GetCustomerCenterConfigCallback;
import com.revenuecat.purchases.interfaces.GetStorefrontLocaleCallback;
import com.revenuecat.purchases.interfaces.GetVirtualCurrenciesCallback;
import com.revenuecat.purchases.interfaces.LogInCallback;
import com.revenuecat.purchases.interfaces.ProductChangeCallback;
import com.revenuecat.purchases.interfaces.SyncAttributesAndOfferingsCallback;
import com.revenuecat.purchases.interfaces.SyncPurchasesCallback;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.virtualcurrencies.VirtualCurrencies;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import pd.o;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\u001aA\u0010\t\u001a\u00020\b2\u001a\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00002\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0005H\u0000¢\u0006\u0004\b\t\u0010\n\u001aE\u0010\r\u001a\u00020\f2\u001a\u0010\u0004\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u00002\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0000H\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a7\u0010\u0010\u001a\u00020\u000f2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005H\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a7\u0010\u0014\u001a\u00020\u00132\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00030\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005H\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a7\u0010\u0018\u001a\u00020\u00172\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00030\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005H\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a7\u0010\u001c\u001a\u00020\u001b2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00030\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005H\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a7\u0010 \u001a\u00020\u001f2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00030\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005H\u0000¢\u0006\u0004\b \u0010!\u001aY\u0010'\u001a\u00020\u0003*\u00020\"2\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%2\u001a\b\u0002\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00002\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u0000H\u0007¢\u0006\u0004\b'\u0010(\u001aY\u0010+\u001a\u00020\u0003*\u00020\"2\u0006\u0010$\u001a\u00020#2\u0006\u0010*\u001a\u00020)2\u001a\b\u0002\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00002\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u0000H\u0007¢\u0006\u0004\b+\u0010,\u001aI\u0010/\u001a\u00020\u0003*\u00020\"2\u0006\u0010.\u001a\u00020-2\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00052\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0000¢\u0006\u0004\b/\u00100\u001a;\u00101\u001a\u00020\u0003*\u00020\"2\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b1\u00102\u001a;\u00103\u001a\u00020\u0003*\u00020\"2\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b3\u00102\u001aC\u00103\u001a\u00020\u0003*\u00020\"2\u0006\u00105\u001a\u0002042\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b3\u00106\u001a;\u00107\u001a\u00020\u0003*\u00020\"2\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b7\u00102\u001a;\u00108\u001a\u00020\u0003*\u00020\"2\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b8\u00102\u001a;\u00109\u001a\u00020\u0003*\u00020\"2\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b9\u00102\u001a;\u0010:\u001a\u00020\u0003*\u00020\"2\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b:\u00102\u001a=\u0010<\u001a\u00020\u0003*\u00020\"2\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020\u00030\u0005H\u0007¢\u0006\u0004\b<\u00102\u001aQ\u0010@\u001a\u00020\u0003*\u00020\"2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020-0=2\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00052\u0018\u0010?\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0=\u0012\u0004\u0012\u00020\u00030\u0005H\u0007¢\u0006\u0004\b@\u0010A\u001aO\u0010B\u001a\u00020\u0003*\u00020\"2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020-0=2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00052\u0018\u0010?\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0=\u0012\u0004\u0012\u00020\u00030\u0005H\u0007¢\u0006\u0004\bB\u0010A¨\u0006C"}, d2 = {"Lkotlin/Function2;", "Lcom/revenuecat/purchases/CustomerInfo;", "", "Lcd/h0;", "onSuccess", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/PurchasesError;", "onError", "Lcom/revenuecat/purchases/interfaces/LogInCallback;", "logInSuccessListener", "(Lpd/o;Lpd/k;)Lcom/revenuecat/purchases/interfaces/LogInCallback;", "Lcom/revenuecat/purchases/models/StoreTransaction;", "Lcom/revenuecat/purchases/interfaces/ProductChangeCallback;", "productChangeCompletedListener", "(Lpd/o;Lpd/o;)Lcom/revenuecat/purchases/interfaces/ProductChangeCallback;", "Lcom/revenuecat/purchases/interfaces/SyncPurchasesCallback;", "syncPurchasesListener", "(Lpd/k;Lpd/k;)Lcom/revenuecat/purchases/interfaces/SyncPurchasesCallback;", "Lcom/revenuecat/purchases/Offerings;", "Lcom/revenuecat/purchases/interfaces/SyncAttributesAndOfferingsCallback;", "syncAttributesAndOfferingsListener", "(Lpd/k;Lpd/k;)Lcom/revenuecat/purchases/interfaces/SyncAttributesAndOfferingsCallback;", "Lcom/revenuecat/purchases/AmazonLWAConsentStatus;", "Lcom/revenuecat/purchases/interfaces/GetAmazonLWAConsentStatusCallback;", "getAmazonLWAConsentStatusListener", "(Lpd/k;Lpd/k;)Lcom/revenuecat/purchases/interfaces/GetAmazonLWAConsentStatusCallback;", "Lcom/revenuecat/purchases/virtualcurrencies/VirtualCurrencies;", "Lcom/revenuecat/purchases/interfaces/GetVirtualCurrenciesCallback;", "getVirtualCurrenciesCallback", "(Lpd/k;Lpd/k;)Lcom/revenuecat/purchases/interfaces/GetVirtualCurrenciesCallback;", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData;", "Lcom/revenuecat/purchases/interfaces/GetCustomerCenterConfigCallback;", "getCustomerCenterConfigDataListener", "(Lpd/k;Lpd/k;)Lcom/revenuecat/purchases/interfaces/GetCustomerCenterConfigCallback;", "Lcom/revenuecat/purchases/Purchases;", "Landroid/app/Activity;", "activity", "Lcom/revenuecat/purchases/models/StoreProduct;", "storeProduct", "purchaseProductWith", "(Lcom/revenuecat/purchases/Purchases;Landroid/app/Activity;Lcom/revenuecat/purchases/models/StoreProduct;Lpd/o;Lpd/o;)V", "Lcom/revenuecat/purchases/Package;", "packageToPurchase", "purchasePackageWith", "(Lcom/revenuecat/purchases/Purchases;Landroid/app/Activity;Lcom/revenuecat/purchases/Package;Lpd/o;Lpd/o;)V", "", "appUserID", "logInWith", "(Lcom/revenuecat/purchases/Purchases;Ljava/lang/String;Lpd/k;Lpd/o;)V", "logOutWith", "(Lcom/revenuecat/purchases/Purchases;Lpd/k;Lpd/k;)V", "getCustomerInfoWith", "Lcom/revenuecat/purchases/CacheFetchPolicy;", "fetchPolicy", "(Lcom/revenuecat/purchases/Purchases;Lcom/revenuecat/purchases/CacheFetchPolicy;Lpd/k;Lpd/k;)V", "syncPurchasesWith", "syncAttributesAndOfferingsIfNeededWith", "getAmazonLWAConsentStatusWith", "getVirtualCurrenciesWith", "Ljava/util/Locale;", "getStorefrontLocaleWith", "", com.amazon.a.a.o.b.O, "onReceiveSkus", "getSubscriptionSkusWith", "(Lcom/revenuecat/purchases/Purchases;Ljava/util/List;Lpd/k;Lpd/k;)V", "getNonSubscriptionSkusWith", "purchases_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ListenerConversionsKt {
    public static final GetAmazonLWAConsentStatusCallback getAmazonLWAConsentStatusListener(final pd.k onSuccess, final pd.k onError) {
        t.f(onSuccess, "onSuccess");
        t.f(onError, "onError");
        return new GetAmazonLWAConsentStatusCallback() { // from class: com.revenuecat.purchases.ListenerConversionsKt.getAmazonLWAConsentStatusListener.1
            @Override // com.revenuecat.purchases.interfaces.GetAmazonLWAConsentStatusCallback
            public void onError(PurchasesError error) {
                t.f(error, "error");
                onError.invoke(error);
            }

            @Override // com.revenuecat.purchases.interfaces.GetAmazonLWAConsentStatusCallback
            public void onSuccess(AmazonLWAConsentStatus consentStatus) {
                t.f(consentStatus, "consentStatus");
                onSuccess.invoke(consentStatus);
            }
        };
    }

    public static final void getAmazonLWAConsentStatusWith(Purchases purchases, pd.k onError, pd.k onSuccess) {
        t.f(purchases, "<this>");
        t.f(onError, "onError");
        t.f(onSuccess, "onSuccess");
        purchases.getAmazonLWAConsentStatus(getAmazonLWAConsentStatusListener(onSuccess, onError));
    }

    public static /* synthetic */ void getAmazonLWAConsentStatusWith$default(Purchases purchases, pd.k kVar, pd.k kVar2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            kVar = ListenerConversionsCommonKt.getON_ERROR_STUB();
        }
        getAmazonLWAConsentStatusWith(purchases, kVar, kVar2);
    }

    public static final GetCustomerCenterConfigCallback getCustomerCenterConfigDataListener(final pd.k onSuccess, final pd.k onError) {
        t.f(onSuccess, "onSuccess");
        t.f(onError, "onError");
        return new GetCustomerCenterConfigCallback() { // from class: com.revenuecat.purchases.ListenerConversionsKt.getCustomerCenterConfigDataListener.1
            @Override // com.revenuecat.purchases.interfaces.GetCustomerCenterConfigCallback
            public void onError(PurchasesError error) {
                t.f(error, "error");
                onError.invoke(error);
            }

            @Override // com.revenuecat.purchases.interfaces.GetCustomerCenterConfigCallback
            public void onSuccess(CustomerCenterConfigData customerCenterConfig) {
                t.f(customerCenterConfig, "customerCenterConfig");
                onSuccess.invoke(customerCenterConfig);
            }
        };
    }

    public static final void getCustomerInfoWith(Purchases purchases, pd.k onError, pd.k onSuccess) {
        t.f(purchases, "<this>");
        t.f(onError, "onError");
        t.f(onSuccess, "onSuccess");
        purchases.getCustomerInfo(ListenerConversionsCommonKt.receiveCustomerInfoCallback(onSuccess, onError));
    }

    public static /* synthetic */ void getCustomerInfoWith$default(Purchases purchases, pd.k kVar, pd.k kVar2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            kVar = ListenerConversionsCommonKt.getON_ERROR_STUB();
        }
        getCustomerInfoWith(purchases, kVar, kVar2);
    }

    public static final void getNonSubscriptionSkusWith(Purchases purchases, List<String> skus, pd.k onError, pd.k onReceiveSkus) {
        t.f(purchases, "<this>");
        t.f(skus, "skus");
        t.f(onError, "onError");
        t.f(onReceiveSkus, "onReceiveSkus");
        purchases.getProducts(skus, ProductType.INAPP, ListenerConversionsCommonKt.getStoreProductsCallback(onReceiveSkus, onError));
    }

    @ExperimentalPreviewRevenueCatPurchasesAPI
    public static final void getStorefrontLocaleWith(Purchases purchases, final pd.k onError, final pd.k onSuccess) {
        t.f(purchases, "<this>");
        t.f(onError, "onError");
        t.f(onSuccess, "onSuccess");
        purchases.getStorefrontLocale(new GetStorefrontLocaleCallback() { // from class: com.revenuecat.purchases.ListenerConversionsKt.getStorefrontLocaleWith.1
            @Override // com.revenuecat.purchases.interfaces.GetStorefrontLocaleCallback
            public void onError(PurchasesError error) {
                t.f(error, "error");
                onError.invoke(error);
            }

            @Override // com.revenuecat.purchases.interfaces.GetStorefrontLocaleCallback
            public void onReceived(Locale storefrontLocale) {
                t.f(storefrontLocale, "storefrontLocale");
                onSuccess.invoke(storefrontLocale);
            }
        });
    }

    public static /* synthetic */ void getStorefrontLocaleWith$default(Purchases purchases, pd.k kVar, pd.k kVar2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            kVar = ListenerConversionsCommonKt.getON_ERROR_STUB();
        }
        getStorefrontLocaleWith(purchases, kVar, kVar2);
    }

    public static final void getSubscriptionSkusWith(Purchases purchases, List<String> skus, pd.k onError, pd.k onReceiveSkus) {
        t.f(purchases, "<this>");
        t.f(skus, "skus");
        t.f(onError, "onError");
        t.f(onReceiveSkus, "onReceiveSkus");
        purchases.getProducts(skus, ProductType.SUBS, ListenerConversionsCommonKt.getStoreProductsCallback(onReceiveSkus, onError));
    }

    public static /* synthetic */ void getSubscriptionSkusWith$default(Purchases purchases, List list, pd.k kVar, pd.k kVar2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            kVar = ListenerConversionsCommonKt.getON_ERROR_STUB();
        }
        getSubscriptionSkusWith(purchases, list, kVar, kVar2);
    }

    public static final GetVirtualCurrenciesCallback getVirtualCurrenciesCallback(final pd.k onSuccess, final pd.k onError) {
        t.f(onSuccess, "onSuccess");
        t.f(onError, "onError");
        return new GetVirtualCurrenciesCallback() { // from class: com.revenuecat.purchases.ListenerConversionsKt.getVirtualCurrenciesCallback.1
            @Override // com.revenuecat.purchases.interfaces.GetVirtualCurrenciesCallback
            public void onError(PurchasesError error) {
                t.f(error, "error");
                onError.invoke(error);
            }

            @Override // com.revenuecat.purchases.interfaces.GetVirtualCurrenciesCallback
            public void onReceived(VirtualCurrencies virtualCurrencies) {
                t.f(virtualCurrencies, "virtualCurrencies");
                onSuccess.invoke(virtualCurrencies);
            }
        };
    }

    public static final void getVirtualCurrenciesWith(Purchases purchases, pd.k onError, pd.k onSuccess) {
        t.f(purchases, "<this>");
        t.f(onError, "onError");
        t.f(onSuccess, "onSuccess");
        purchases.getVirtualCurrencies(getVirtualCurrenciesCallback(onSuccess, onError));
    }

    public static /* synthetic */ void getVirtualCurrenciesWith$default(Purchases purchases, pd.k kVar, pd.k kVar2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            kVar = ListenerConversionsCommonKt.getON_ERROR_STUB();
        }
        getVirtualCurrenciesWith(purchases, kVar, kVar2);
    }

    public static final LogInCallback logInSuccessListener(final o onSuccess, final pd.k onError) {
        t.f(onSuccess, "onSuccess");
        t.f(onError, "onError");
        return new LogInCallback() { // from class: com.revenuecat.purchases.ListenerConversionsKt.logInSuccessListener.1
            @Override // com.revenuecat.purchases.interfaces.LogInCallback
            public void onError(PurchasesError error) {
                t.f(error, "error");
                pd.k kVar = onError;
                if (kVar != null) {
                }
            }

            @Override // com.revenuecat.purchases.interfaces.LogInCallback
            public void onReceived(CustomerInfo customerInfo, boolean created) {
                t.f(customerInfo, "customerInfo");
                o oVar = onSuccess;
                if (oVar != null) {
                }
            }
        };
    }

    public static final void logInWith(Purchases purchases, String appUserID, pd.k onError, o onSuccess) {
        t.f(purchases, "<this>");
        t.f(appUserID, "appUserID");
        t.f(onError, "onError");
        t.f(onSuccess, "onSuccess");
        purchases.logIn(appUserID, logInSuccessListener(onSuccess, onError));
    }

    public static /* synthetic */ void logInWith$default(Purchases purchases, String str, pd.k kVar, o oVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            kVar = ListenerConversionsCommonKt.getON_ERROR_STUB();
        }
        logInWith(purchases, str, kVar, oVar);
    }

    public static final void logOutWith(Purchases purchases, pd.k onError, pd.k onSuccess) {
        t.f(purchases, "<this>");
        t.f(onError, "onError");
        t.f(onSuccess, "onSuccess");
        purchases.logOut(ListenerConversionsCommonKt.receiveCustomerInfoCallback(onSuccess, onError));
    }

    public static /* synthetic */ void logOutWith$default(Purchases purchases, pd.k kVar, pd.k kVar2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            kVar = ListenerConversionsCommonKt.getON_ERROR_STUB();
        }
        logOutWith(purchases, kVar, kVar2);
    }

    public static final ProductChangeCallback productChangeCompletedListener(final o onSuccess, final o onError) {
        t.f(onSuccess, "onSuccess");
        t.f(onError, "onError");
        return new ProductChangeCallback() { // from class: com.revenuecat.purchases.ListenerConversionsKt.productChangeCompletedListener.1
            @Override // com.revenuecat.purchases.interfaces.ProductChangeCallback
            public void onCompleted(StoreTransaction purchase, CustomerInfo customerInfo) {
                t.f(customerInfo, "customerInfo");
                onSuccess.invoke(purchase, customerInfo);
            }

            @Override // com.revenuecat.purchases.interfaces.PurchaseErrorCallback
            public void onError(PurchasesError error, boolean userCancelled) {
                t.f(error, "error");
                onError.invoke(error, Boolean.valueOf(userCancelled));
            }
        };
    }

    public static final void purchasePackageWith(Purchases purchases, Activity activity, Package packageToPurchase, o onError, o onSuccess) {
        t.f(purchases, "<this>");
        t.f(activity, "activity");
        t.f(packageToPurchase, "packageToPurchase");
        t.f(onError, "onError");
        t.f(onSuccess, "onSuccess");
        purchases.purchasePackage(activity, packageToPurchase, ListenerConversionsCommonKt.purchaseCompletedCallback(onSuccess, onError));
    }

    public static /* synthetic */ void purchasePackageWith$default(Purchases purchases, Activity activity, Package r22, o oVar, o oVar2, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            oVar = ListenerConversionsCommonKt.getON_PURCHASE_ERROR_STUB();
        }
        purchasePackageWith(purchases, activity, r22, oVar, oVar2);
    }

    public static final void purchaseProductWith(Purchases purchases, Activity activity, StoreProduct storeProduct, o onError, o onSuccess) {
        t.f(purchases, "<this>");
        t.f(activity, "activity");
        t.f(storeProduct, "storeProduct");
        t.f(onError, "onError");
        t.f(onSuccess, "onSuccess");
        purchases.purchaseProduct(activity, storeProduct, ListenerConversionsCommonKt.purchaseCompletedCallback(onSuccess, onError));
    }

    public static /* synthetic */ void purchaseProductWith$default(Purchases purchases, Activity activity, StoreProduct storeProduct, o oVar, o oVar2, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            oVar = ListenerConversionsCommonKt.getON_PURCHASE_ERROR_STUB();
        }
        purchaseProductWith(purchases, activity, storeProduct, oVar, oVar2);
    }

    public static final void syncAttributesAndOfferingsIfNeededWith(Purchases purchases, pd.k onError, pd.k onSuccess) {
        t.f(purchases, "<this>");
        t.f(onError, "onError");
        t.f(onSuccess, "onSuccess");
        purchases.syncAttributesAndOfferingsIfNeeded(syncAttributesAndOfferingsListener(onSuccess, onError));
    }

    public static /* synthetic */ void syncAttributesAndOfferingsIfNeededWith$default(Purchases purchases, pd.k kVar, pd.k kVar2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            kVar = ListenerConversionsCommonKt.getON_ERROR_STUB();
        }
        syncAttributesAndOfferingsIfNeededWith(purchases, kVar, kVar2);
    }

    public static final SyncAttributesAndOfferingsCallback syncAttributesAndOfferingsListener(final pd.k onSuccess, final pd.k onError) {
        t.f(onSuccess, "onSuccess");
        t.f(onError, "onError");
        return new SyncAttributesAndOfferingsCallback() { // from class: com.revenuecat.purchases.ListenerConversionsKt.syncAttributesAndOfferingsListener.1
            @Override // com.revenuecat.purchases.interfaces.SyncAttributesAndOfferingsCallback
            public void onError(PurchasesError error) {
                t.f(error, "error");
                onError.invoke(error);
            }

            @Override // com.revenuecat.purchases.interfaces.SyncAttributesAndOfferingsCallback
            public void onSuccess(Offerings offerings) {
                t.f(offerings, "offerings");
                onSuccess.invoke(offerings);
            }
        };
    }

    public static final SyncPurchasesCallback syncPurchasesListener(final pd.k onSuccess, final pd.k onError) {
        t.f(onSuccess, "onSuccess");
        t.f(onError, "onError");
        return new SyncPurchasesCallback() { // from class: com.revenuecat.purchases.ListenerConversionsKt.syncPurchasesListener.1
            @Override // com.revenuecat.purchases.interfaces.SyncPurchasesCallback
            public void onError(PurchasesError error) {
                t.f(error, "error");
                onError.invoke(error);
            }

            @Override // com.revenuecat.purchases.interfaces.SyncPurchasesCallback
            public void onSuccess(CustomerInfo customerInfo) {
                t.f(customerInfo, "customerInfo");
                onSuccess.invoke(customerInfo);
            }
        };
    }

    public static final void syncPurchasesWith(Purchases purchases, pd.k onError, pd.k onSuccess) {
        t.f(purchases, "<this>");
        t.f(onError, "onError");
        t.f(onSuccess, "onSuccess");
        purchases.syncPurchases(syncPurchasesListener(onSuccess, onError));
    }

    public static /* synthetic */ void syncPurchasesWith$default(Purchases purchases, pd.k kVar, pd.k kVar2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            kVar = ListenerConversionsCommonKt.getON_ERROR_STUB();
        }
        syncPurchasesWith(purchases, kVar, kVar2);
    }

    public static final void getCustomerInfoWith(Purchases purchases, CacheFetchPolicy fetchPolicy, pd.k onError, pd.k onSuccess) {
        t.f(purchases, "<this>");
        t.f(fetchPolicy, "fetchPolicy");
        t.f(onError, "onError");
        t.f(onSuccess, "onSuccess");
        purchases.getCustomerInfo(fetchPolicy, ListenerConversionsCommonKt.receiveCustomerInfoCallback(onSuccess, onError));
    }

    public static /* synthetic */ void getCustomerInfoWith$default(Purchases purchases, CacheFetchPolicy cacheFetchPolicy, pd.k kVar, pd.k kVar2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            kVar = ListenerConversionsCommonKt.getON_ERROR_STUB();
        }
        getCustomerInfoWith(purchases, cacheFetchPolicy, kVar, kVar2);
    }
}
