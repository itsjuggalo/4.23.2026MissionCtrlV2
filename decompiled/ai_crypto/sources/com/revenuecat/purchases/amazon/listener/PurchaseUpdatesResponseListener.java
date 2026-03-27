package com.revenuecat.purchases.amazon.listener;

import Q5.k;
import Q5.o;
import com.amazon.device.iap.PurchasingListener;
import com.amazon.device.iap.model.ProductDataResponse;
import com.amazon.device.iap.model.PurchaseResponse;
import com.amazon.device.iap.model.UserDataResponse;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public interface PurchaseUpdatesResponseListener extends PurchasingListener {

    public static final class DefaultImpls {
        @Deprecated
        public static void onProductDataResponse(PurchaseUpdatesResponseListener purchaseUpdatesResponseListener, ProductDataResponse response) {
            r.f(response, "response");
            PurchaseUpdatesResponseListener.super.onProductDataResponse(response);
        }

        @Deprecated
        public static void onPurchaseResponse(PurchaseUpdatesResponseListener purchaseUpdatesResponseListener, PurchaseResponse response) {
            r.f(response, "response");
            PurchaseUpdatesResponseListener.super.onPurchaseResponse(response);
        }

        @Deprecated
        public static void onUserDataResponse(PurchaseUpdatesResponseListener purchaseUpdatesResponseListener, UserDataResponse response) {
            r.f(response, "response");
            PurchaseUpdatesResponseListener.super.onUserDataResponse(response);
        }
    }

    default void onProductDataResponse(ProductDataResponse response) {
        r.f(response, "response");
    }

    default void onPurchaseResponse(PurchaseResponse response) {
        r.f(response, "response");
    }

    default void onUserDataResponse(UserDataResponse response) {
        r.f(response, "response");
    }

    void queryPurchases(o oVar, k kVar);
}
