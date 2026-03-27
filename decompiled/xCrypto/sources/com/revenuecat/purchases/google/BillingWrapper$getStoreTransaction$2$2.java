package com.revenuecat.purchases.google;

import W2.E;
import com.android.billingclient.api.Purchase;
import com.revenuecat.purchases.ProductType;
import i3.k;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes3.dex */
public final class BillingWrapper$getStoreTransaction$2$2 extends s implements k {
    final /* synthetic */ k $completion;
    final /* synthetic */ Purchase $purchase;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BillingWrapper$getStoreTransaction$2$2(k kVar, Purchase purchase) {
        super(1);
        this.$completion = kVar;
        this.$purchase = purchase;
    }

    @Override // i3.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ProductType) obj);
        return E.f5463a;
    }

    public final void invoke(ProductType type) {
        r.f(type, "type");
        this.$completion.invoke(StoreTransactionConversionsKt.toStoreTransaction$default(this.$purchase, type, null, null, null, 14, null));
    }
}
