package com.revenuecat.purchases.google;

import W2.E;
import com.android.billingclient.api.PurchaseHistoryRecord;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.strings.PurchaseStrings;
import i3.k;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes3.dex */
public final class BillingWrapper$findPurchaseInPurchaseHistory$2$1 extends s implements k {
    final /* synthetic */ k $onCompletion;
    final /* synthetic */ k $onError;
    final /* synthetic */ String $productId;
    final /* synthetic */ ProductType $productType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BillingWrapper$findPurchaseInPurchaseHistory$2$1(ProductType productType, k kVar, String str, k kVar2) {
        super(1);
        this.$productType = productType;
        this.$onCompletion = kVar;
        this.$productId = str;
        this.$onError = kVar2;
    }

    public final void invoke(List<? extends PurchaseHistoryRecord> purchasesList) {
        Object next;
        r.f(purchasesList, "purchasesList");
        String str = this.$productId;
        Iterator<T> it = purchasesList.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((PurchaseHistoryRecord) next).b().contains(str)) {
                    break;
                }
            }
        }
        PurchaseHistoryRecord purchaseHistoryRecord = (PurchaseHistoryRecord) next;
        StoreTransaction storeTransaction = purchaseHistoryRecord != null ? StoreTransactionConversionsKt.toStoreTransaction(purchaseHistoryRecord, this.$productType) : null;
        if (storeTransaction != null) {
            this.$onCompletion.invoke(storeTransaction);
            return;
        }
        String str2 = String.format(PurchaseStrings.NO_EXISTING_PURCHASE, Arrays.copyOf(new Object[]{this.$productId}, 1));
        r.e(str2, "format(this, *args)");
        this.$onError.invoke(new PurchasesError(PurchasesErrorCode.PurchaseInvalidError, str2));
    }

    @Override // i3.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<? extends PurchaseHistoryRecord>) obj);
        return E.f5463a;
    }
}
