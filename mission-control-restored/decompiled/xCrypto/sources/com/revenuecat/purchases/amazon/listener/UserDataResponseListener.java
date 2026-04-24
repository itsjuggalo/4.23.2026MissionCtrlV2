package com.revenuecat.purchases.amazon.listener;

import com.amazon.device.iap.PurchasingListener;
import com.amazon.device.iap.model.ProductDataResponse;
import com.amazon.device.iap.model.PurchaseResponse;
import com.amazon.device.iap.model.PurchaseUpdatesResponse;
import i3.k;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public interface UserDataResponseListener extends PurchasingListener {

    public static final class DefaultImpls {
        @Deprecated
        public static void onProductDataResponse(UserDataResponseListener userDataResponseListener, ProductDataResponse response) {
            r.f(response, "response");
            UserDataResponseListener.super.onProductDataResponse(response);
        }

        @Deprecated
        public static void onPurchaseResponse(UserDataResponseListener userDataResponseListener, PurchaseResponse response) {
            r.f(response, "response");
            UserDataResponseListener.super.onPurchaseResponse(response);
        }

        @Deprecated
        public static void onPurchaseUpdatesResponse(UserDataResponseListener userDataResponseListener, PurchaseUpdatesResponse response) {
            r.f(response, "response");
            UserDataResponseListener.super.onPurchaseUpdatesResponse(response);
        }
    }

    void getUserData(k kVar, k kVar2);

    default void onProductDataResponse(ProductDataResponse response) {
        r.f(response, "response");
    }

    default void onPurchaseResponse(PurchaseResponse response) {
        r.f(response, "response");
    }

    default void onPurchaseUpdatesResponse(PurchaseUpdatesResponse response) {
        r.f(response, "response");
    }
}
