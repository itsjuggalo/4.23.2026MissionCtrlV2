package com.revenuecat.purchases.amazon.listener;

import com.amazon.device.iap.PurchasingListener;
import com.amazon.device.iap.model.PurchaseResponse;
import com.amazon.device.iap.model.PurchaseUpdatesResponse;
import com.amazon.device.iap.model.UserDataResponse;
import i3.k;
import java.util.Set;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public interface ProductDataResponseListener extends PurchasingListener {

    public static final class DefaultImpls {
        @Deprecated
        public static void onPurchaseResponse(ProductDataResponseListener productDataResponseListener, PurchaseResponse response) {
            r.f(response, "response");
            ProductDataResponseListener.super.onPurchaseResponse(response);
        }

        @Deprecated
        public static void onPurchaseUpdatesResponse(ProductDataResponseListener productDataResponseListener, PurchaseUpdatesResponse response) {
            r.f(response, "response");
            ProductDataResponseListener.super.onPurchaseUpdatesResponse(response);
        }

        @Deprecated
        public static void onUserDataResponse(ProductDataResponseListener productDataResponseListener, UserDataResponse response) {
            r.f(response, "response");
            ProductDataResponseListener.super.onUserDataResponse(response);
        }
    }

    void getProductData(Set<String> set, String str, k kVar, k kVar2);

    @Override // com.amazon.device.iap.PurchasingListener, com.revenuecat.purchases.amazon.listener.PurchaseUpdatesResponseListener, com.revenuecat.purchases.amazon.listener.UserDataResponseListener
    default void onPurchaseResponse(PurchaseResponse response) {
        r.f(response, "response");
    }

    @Override // com.amazon.device.iap.PurchasingListener, com.revenuecat.purchases.amazon.listener.PurchaseResponseListener, com.revenuecat.purchases.amazon.listener.UserDataResponseListener
    default void onPurchaseUpdatesResponse(PurchaseUpdatesResponse response) {
        r.f(response, "response");
    }

    @Override // com.amazon.device.iap.PurchasingListener, com.revenuecat.purchases.amazon.listener.PurchaseResponseListener, com.revenuecat.purchases.amazon.listener.PurchaseUpdatesResponseListener
    default void onUserDataResponse(UserDataResponse response) {
        r.f(response, "response");
    }
}
