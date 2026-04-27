package com.revenuecat.purchases.amazon;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.amazon.device.iap.PurchasingListener;
import com.amazon.device.iap.PurchasingService;
import com.amazon.device.iap.model.FulfillmentResult;
import com.amazon.device.iap.model.RequestId;
import com.amazon.device.iap.model.UserDataRequest;
import java.util.Set;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class DefaultPurchasingServiceProvider implements PurchasingServiceProvider {
    public static final Parcelable.Creator<DefaultPurchasingServiceProvider> CREATOR = new Creator();

    public static final class Creator implements Parcelable.Creator<DefaultPurchasingServiceProvider> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DefaultPurchasingServiceProvider createFromParcel(Parcel parcel) {
            r.f(parcel, "parcel");
            parcel.readInt();
            return new DefaultPurchasingServiceProvider();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DefaultPurchasingServiceProvider[] newArray(int i4) {
            return new DefaultPurchasingServiceProvider[i4];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.revenuecat.purchases.amazon.PurchasingServiceProvider
    public RequestId getProductData(Set<String> skus) {
        r.f(skus, "skus");
        RequestId productData = PurchasingService.getProductData(skus);
        r.e(productData, "getProductData(skus)");
        return productData;
    }

    @Override // com.revenuecat.purchases.amazon.PurchasingServiceProvider
    public RequestId getPurchaseUpdates(boolean z4) {
        RequestId purchaseUpdates = PurchasingService.getPurchaseUpdates(z4);
        r.e(purchaseUpdates, "getPurchaseUpdates(reset)");
        return purchaseUpdates;
    }

    @Override // com.revenuecat.purchases.amazon.PurchasingServiceProvider
    public RequestId getUserData() {
        RequestId userData = PurchasingService.getUserData(UserDataRequest.newBuilder().setFetchLWAConsentStatus(true).build());
        r.e(userData, "getUserData(UserDataRequ…sentStatus(true).build())");
        return userData;
    }

    @Override // com.revenuecat.purchases.amazon.PurchasingServiceProvider
    public void notifyFulfillment(String receiptId, FulfillmentResult fulfillmentResult) {
        r.f(receiptId, "receiptId");
        r.f(fulfillmentResult, "fulfillmentResult");
        PurchasingService.notifyFulfillment(receiptId, fulfillmentResult);
    }

    @Override // com.revenuecat.purchases.amazon.PurchasingServiceProvider
    public RequestId purchase(String sku) {
        r.f(sku, "sku");
        RequestId requestIdPurchase = PurchasingService.purchase(sku);
        r.e(requestIdPurchase, "purchase(sku)");
        return requestIdPurchase;
    }

    @Override // com.revenuecat.purchases.amazon.PurchasingServiceProvider
    public void registerListener(Context context, PurchasingListener listener) {
        r.f(context, "context");
        r.f(listener, "listener");
        PurchasingService.registerListener(context, listener);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i4) {
        r.f(out, "out");
        out.writeInt(1);
    }
}
