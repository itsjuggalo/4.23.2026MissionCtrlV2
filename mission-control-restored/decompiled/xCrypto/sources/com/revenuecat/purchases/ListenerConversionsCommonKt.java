package com.revenuecat.purchases;

import com.revenuecat.purchases.interfaces.GetStoreProductsCallback;
import com.revenuecat.purchases.interfaces.GetStorefrontCallback;
import com.revenuecat.purchases.interfaces.PurchaseCallback;
import com.revenuecat.purchases.interfaces.ReceiveCustomerInfoCallback;
import com.revenuecat.purchases.interfaces.ReceiveOfferingsCallback;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.StoreTransaction;
import i3.k;
import i3.o;
import java.util.List;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class ListenerConversionsCommonKt {
    private static final k ON_ERROR_STUB = ListenerConversionsCommonKt$ON_ERROR_STUB$1.INSTANCE;
    private static final o ON_PURCHASE_ERROR_STUB = ListenerConversionsCommonKt$ON_PURCHASE_ERROR_STUB$1.INSTANCE;

    public static final k getON_ERROR_STUB() {
        return ON_ERROR_STUB;
    }

    public static final o getON_PURCHASE_ERROR_STUB() {
        return ON_PURCHASE_ERROR_STUB;
    }

    public static final void getOfferingsWith(Purchases purchases, k onError, k onSuccess) {
        r.f(purchases, "<this>");
        r.f(onError, "onError");
        r.f(onSuccess, "onSuccess");
        purchases.getOfferings(receiveOfferingsCallback(onSuccess, onError));
    }

    public static /* synthetic */ void getOfferingsWith$default(Purchases purchases, k kVar, k kVar2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            kVar = ON_ERROR_STUB;
        }
        getOfferingsWith(purchases, kVar, kVar2);
    }

    public static final void getProductsWith(Purchases purchases, List<String> productIds, k onError, k onGetStoreProducts) {
        r.f(purchases, "<this>");
        r.f(productIds, "productIds");
        r.f(onError, "onError");
        r.f(onGetStoreProducts, "onGetStoreProducts");
        purchases.getProducts(productIds, getStoreProductsCallback(onGetStoreProducts, onError));
    }

    public static /* synthetic */ void getProductsWith$default(Purchases purchases, List list, k kVar, k kVar2, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            kVar = ON_ERROR_STUB;
        }
        getProductsWith(purchases, list, kVar, kVar2);
    }

    public static final GetStoreProductsCallback getStoreProductsCallback(final k onReceived, final k onError) {
        r.f(onReceived, "onReceived");
        r.f(onError, "onError");
        return new GetStoreProductsCallback() { // from class: com.revenuecat.purchases.ListenerConversionsCommonKt.getStoreProductsCallback.1
            @Override // com.revenuecat.purchases.interfaces.GetStoreProductsCallback
            public void onError(PurchasesError error) {
                r.f(error, "error");
                onError.invoke(error);
            }

            @Override // com.revenuecat.purchases.interfaces.GetStoreProductsCallback
            public void onReceived(List<? extends StoreProduct> storeProducts) {
                r.f(storeProducts, "storeProducts");
                onReceived.invoke(storeProducts);
            }
        };
    }

    public static final void getStorefrontCountryCodeWith(Purchases purchases, final k onError, final k onSuccess) {
        r.f(purchases, "<this>");
        r.f(onError, "onError");
        r.f(onSuccess, "onSuccess");
        purchases.getStorefrontCountryCode(new GetStorefrontCallback() { // from class: com.revenuecat.purchases.ListenerConversionsCommonKt.getStorefrontCountryCodeWith.1
            @Override // com.revenuecat.purchases.interfaces.GetStorefrontCallback
            public void onError(PurchasesError error) {
                r.f(error, "error");
                onError.invoke(error);
            }

            @Override // com.revenuecat.purchases.interfaces.GetStorefrontCallback
            public void onReceived(String storefrontCountryCode) {
                r.f(storefrontCountryCode, "storefrontCountryCode");
                onSuccess.invoke(storefrontCountryCode);
            }
        });
    }

    public static /* synthetic */ void getStorefrontCountryCodeWith$default(Purchases purchases, k kVar, k kVar2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            kVar = ON_ERROR_STUB;
        }
        getStorefrontCountryCodeWith(purchases, kVar, kVar2);
    }

    public static final PurchaseCallback purchaseCompletedCallback(final o onSuccess, final o onError) {
        r.f(onSuccess, "onSuccess");
        r.f(onError, "onError");
        return new PurchaseCallback() { // from class: com.revenuecat.purchases.ListenerConversionsCommonKt.purchaseCompletedCallback.1
            @Override // com.revenuecat.purchases.interfaces.PurchaseCallback
            public void onCompleted(StoreTransaction storeTransaction, CustomerInfo customerInfo) {
                r.f(storeTransaction, "storeTransaction");
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

    public static final void purchaseWith(Purchases purchases, PurchaseParams purchaseParams, o onError, o onSuccess) {
        r.f(purchases, "<this>");
        r.f(purchaseParams, "purchaseParams");
        r.f(onError, "onError");
        r.f(onSuccess, "onSuccess");
        purchases.purchase(purchaseParams, purchaseCompletedCallback(onSuccess, onError));
    }

    public static /* synthetic */ void purchaseWith$default(Purchases purchases, PurchaseParams purchaseParams, o oVar, o oVar2, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            oVar = ON_PURCHASE_ERROR_STUB;
        }
        purchaseWith(purchases, purchaseParams, oVar, oVar2);
    }

    public static final ReceiveCustomerInfoCallback receiveCustomerInfoCallback(final k onSuccess, final k onError) {
        r.f(onSuccess, "onSuccess");
        r.f(onError, "onError");
        return new ReceiveCustomerInfoCallback() { // from class: com.revenuecat.purchases.ListenerConversionsCommonKt.receiveCustomerInfoCallback.1
            @Override // com.revenuecat.purchases.interfaces.ReceiveCustomerInfoCallback
            public void onError(PurchasesError error) {
                r.f(error, "error");
                k kVar = onError;
                if (kVar != null) {
                }
            }

            @Override // com.revenuecat.purchases.interfaces.ReceiveCustomerInfoCallback
            public void onReceived(CustomerInfo customerInfo) {
                r.f(customerInfo, "customerInfo");
                k kVar = onSuccess;
                if (kVar != null) {
                }
            }
        };
    }

    public static final ReceiveOfferingsCallback receiveOfferingsCallback(final k onSuccess, final k onError) {
        r.f(onSuccess, "onSuccess");
        r.f(onError, "onError");
        return new ReceiveOfferingsCallback() { // from class: com.revenuecat.purchases.ListenerConversionsCommonKt.receiveOfferingsCallback.1
            @Override // com.revenuecat.purchases.interfaces.ReceiveOfferingsCallback
            public void onError(PurchasesError error) {
                r.f(error, "error");
                onError.invoke(error);
            }

            @Override // com.revenuecat.purchases.interfaces.ReceiveOfferingsCallback
            public void onReceived(Offerings offerings) {
                r.f(offerings, "offerings");
                onSuccess.invoke(offerings);
            }
        };
    }

    public static final void restorePurchasesWith(Purchases purchases, k onError, k onSuccess) {
        r.f(purchases, "<this>");
        r.f(onError, "onError");
        r.f(onSuccess, "onSuccess");
        purchases.restorePurchases(receiveCustomerInfoCallback(onSuccess, onError));
    }

    public static /* synthetic */ void restorePurchasesWith$default(Purchases purchases, k kVar, k kVar2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            kVar = ON_ERROR_STUB;
        }
        restorePurchasesWith(purchases, kVar, kVar2);
    }

    public static final void getProductsWith(Purchases purchases, List<String> productIds, ProductType productType, k onError, k onGetStoreProducts) {
        r.f(purchases, "<this>");
        r.f(productIds, "productIds");
        r.f(onError, "onError");
        r.f(onGetStoreProducts, "onGetStoreProducts");
        purchases.getProducts(productIds, productType, getStoreProductsCallback(onGetStoreProducts, onError));
    }

    public static /* synthetic */ void getProductsWith$default(Purchases purchases, List list, ProductType productType, k kVar, k kVar2, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            kVar = ON_ERROR_STUB;
        }
        getProductsWith(purchases, list, productType, kVar, kVar2);
    }
}
