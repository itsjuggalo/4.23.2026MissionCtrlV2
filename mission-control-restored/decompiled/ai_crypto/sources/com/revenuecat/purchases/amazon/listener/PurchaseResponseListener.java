package com.revenuecat.purchases.amazon.listener;

import Q5.k;
import Q5.o;
import android.app.Activity;
import android.os.Handler;
import com.amazon.device.iap.PurchasingListener;
import com.amazon.device.iap.model.ProductDataResponse;
import com.amazon.device.iap.model.PurchaseUpdatesResponse;
import com.amazon.device.iap.model.UserDataResponse;
import com.revenuecat.purchases.models.StoreProduct;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public interface PurchaseResponseListener extends PurchasingListener {

    public static final class DefaultImpls {
        @Deprecated
        public static void onProductDataResponse(PurchaseResponseListener purchaseResponseListener, ProductDataResponse response) {
            r.f(response, "response");
            PurchaseResponseListener.super.onProductDataResponse(response);
        }

        @Deprecated
        public static void onPurchaseUpdatesResponse(PurchaseResponseListener purchaseResponseListener, PurchaseUpdatesResponse response) {
            r.f(response, "response");
            PurchaseResponseListener.super.onPurchaseUpdatesResponse(response);
        }

        @Deprecated
        public static void onUserDataResponse(PurchaseResponseListener purchaseResponseListener, UserDataResponse response) {
            r.f(response, "response");
            PurchaseResponseListener.super.onUserDataResponse(response);
        }
    }

    default void onProductDataResponse(ProductDataResponse response) {
        r.f(response, "response");
    }

    default void onPurchaseUpdatesResponse(PurchaseUpdatesResponse response) {
        r.f(response, "response");
    }

    default void onUserDataResponse(UserDataResponse response) {
        r.f(response, "response");
    }

    void purchase(Handler handler, Activity activity, String str, StoreProduct storeProduct, o oVar, k kVar);
}
