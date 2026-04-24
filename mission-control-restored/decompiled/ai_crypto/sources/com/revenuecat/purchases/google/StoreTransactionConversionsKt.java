package com.revenuecat.purchases.google;

import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchaseHistoryRecord;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.ReplacementMode;
import com.revenuecat.purchases.models.GoogleReplacementMode;
import com.revenuecat.purchases.models.PurchaseState;
import com.revenuecat.purchases.models.PurchaseType;
import com.revenuecat.purchases.models.StoreTransaction;
import java.util.List;
import kotlin.jvm.internal.r;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class StoreTransactionConversionsKt {
    public static final Purchase getOriginalGooglePurchase(StoreTransaction storeTransaction) {
        r.f(storeTransaction, "<this>");
        String signature = storeTransaction.getSignature();
        if (signature == null) {
            return null;
        }
        if (storeTransaction.getPurchaseType() != PurchaseType.GOOGLE_PURCHASE) {
            signature = null;
        }
        if (signature != null) {
            return new Purchase(storeTransaction.getOriginalJson().toString(), signature);
        }
        return null;
    }

    public static final StoreTransaction toStoreTransaction(Purchase purchase, ProductType productType, PresentedOfferingContext presentedOfferingContext, String str, GoogleReplacementMode googleReplacementMode) {
        r.f(purchase, "<this>");
        r.f(productType, "productType");
        String strA = purchase.a();
        List listC = purchase.c();
        r.e(listC, "this.products");
        long jE = purchase.e();
        String strF = purchase.f();
        r.e(strF, "this.purchaseToken");
        return new StoreTransaction(strA, (List<String>) listC, productType, jE, strF, PurchaseStateConversionsKt.toRevenueCatPurchaseState(purchase.d()), Boolean.valueOf(purchase.i()), purchase.g(), new JSONObject(purchase.b()), presentedOfferingContext, (String) null, PurchaseType.GOOGLE_PURCHASE, (String) null, str, googleReplacementMode);
    }

    public static /* synthetic */ StoreTransaction toStoreTransaction$default(Purchase purchase, ProductType productType, PresentedOfferingContext presentedOfferingContext, String str, GoogleReplacementMode googleReplacementMode, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            presentedOfferingContext = null;
        }
        if ((i7 & 4) != 0) {
            str = null;
        }
        if ((i7 & 8) != 0) {
            googleReplacementMode = null;
        }
        return toStoreTransaction(purchase, productType, presentedOfferingContext, str, googleReplacementMode);
    }

    public static final StoreTransaction toStoreTransaction(Purchase purchase, PurchaseContext purchaseContext) {
        r.f(purchase, "<this>");
        r.f(purchaseContext, "purchaseContext");
        return toStoreTransaction(purchase, purchaseContext.getProductType(), purchaseContext.getPresentedOfferingContext(), purchaseContext.getSelectedSubscriptionOptionId(), purchaseContext.getReplacementMode());
    }

    public static final StoreTransaction toStoreTransaction(PurchaseHistoryRecord purchaseHistoryRecord, ProductType type) {
        r.f(purchaseHistoryRecord, "<this>");
        r.f(type, "type");
        List listB = purchaseHistoryRecord.b();
        r.e(listB, "this.products");
        long jC = purchaseHistoryRecord.c();
        String strD = purchaseHistoryRecord.d();
        r.e(strD, "this.purchaseToken");
        return new StoreTransaction((String) null, (List<String>) listB, type, jC, strD, PurchaseState.UNSPECIFIED_STATE, (Boolean) null, purchaseHistoryRecord.e(), new JSONObject(purchaseHistoryRecord.a()), (PresentedOfferingContext) null, (String) null, PurchaseType.GOOGLE_RESTORED_PURCHASE, (String) null, (String) null, (ReplacementMode) null);
    }
}
