package com.revenuecat.purchases.common.offerings;

import W2.E;
import com.revenuecat.purchases.PurchasesError;
import i3.k;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class OfferingsFactory$getStoreProductsById$1$1$2 extends s implements k {
    final /* synthetic */ k $onError;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfferingsFactory$getStoreProductsById$1$1$2(k kVar) {
        super(1);
        this.$onError = kVar;
    }

    @Override // i3.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PurchasesError) obj);
        return E.f5463a;
    }

    public final void invoke(PurchasesError it) {
        r.f(it, "it");
        this.$onError.invoke(it);
    }
}
