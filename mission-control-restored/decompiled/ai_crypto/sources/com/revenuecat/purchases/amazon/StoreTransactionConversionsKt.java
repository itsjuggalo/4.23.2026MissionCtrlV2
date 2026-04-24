package com.revenuecat.purchases.amazon;

import F5.AbstractC0555m;
import com.amazon.device.iap.model.ProductType;
import com.amazon.device.iap.model.Receipt;
import com.amazon.device.iap.model.UserData;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.ReplacementMode;
import com.revenuecat.purchases.models.PurchaseState;
import com.revenuecat.purchases.models.PurchaseType;
import com.revenuecat.purchases.models.StoreTransaction;
import java.util.List;
import kotlin.jvm.internal.r;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class StoreTransactionConversionsKt {
    public static final StoreTransaction toStoreTransaction(Receipt receipt, String productId, PresentedOfferingContext presentedOfferingContext, PurchaseState purchaseState, UserData userData) {
        r.f(receipt, "<this>");
        r.f(productId, "productId");
        r.f(purchaseState, "purchaseState");
        r.f(userData, "userData");
        ProductType productType = receipt.getProductType();
        r.e(productType, "this.productType");
        com.revenuecat.purchases.ProductType revenueCatProductType = ProductTypeConversionsKt.toRevenueCatProductType(productType);
        List listB = AbstractC0555m.b(productId);
        long time = receipt.getPurchaseDate().getTime();
        String receiptId = receipt.getReceiptId();
        r.e(receiptId, "this.receiptId");
        boolean z7 = false;
        if (revenueCatProductType == com.revenuecat.purchases.ProductType.SUBS && !receipt.isCanceled()) {
            z7 = true;
        }
        Boolean boolValueOf = Boolean.valueOf(z7);
        JSONObject json = receipt.toJSON();
        r.e(json, "this.toJSON()");
        return new StoreTransaction((String) null, (List<String>) listB, revenueCatProductType, time, receiptId, purchaseState, boolValueOf, (String) null, json, presentedOfferingContext, userData.getUserId(), PurchaseType.AMAZON_PURCHASE, userData.getMarketplace(), (String) null, (ReplacementMode) null);
    }
}
