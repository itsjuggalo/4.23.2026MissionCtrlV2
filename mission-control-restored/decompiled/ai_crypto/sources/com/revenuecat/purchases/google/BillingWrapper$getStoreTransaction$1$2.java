package com.revenuecat.purchases.google;

import E5.E;
import Q5.k;
import com.android.billingclient.api.Purchase;
import com.revenuecat.purchases.ProductType;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes2.dex */
public final class BillingWrapper$getStoreTransaction$1$2 extends s implements k {
    final /* synthetic */ k $completion;
    final /* synthetic */ Purchase $purchase;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BillingWrapper$getStoreTransaction$1$2(k kVar, Purchase purchase) {
        super(1);
        this.$completion = kVar;
        this.$purchase = purchase;
    }

    @Override // Q5.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ProductType) obj);
        return E.f1657a;
    }

    public final void invoke(ProductType type) {
        r.f(type, "type");
        this.$completion.invoke(StoreTransactionConversionsKt.toStoreTransaction$default(this.$purchase, type, null, null, null, 14, null));
    }
}
