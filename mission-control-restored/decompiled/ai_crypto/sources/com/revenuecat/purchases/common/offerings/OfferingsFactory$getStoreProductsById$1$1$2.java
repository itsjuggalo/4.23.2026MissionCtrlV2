package com.revenuecat.purchases.common.offerings;

import E5.E;
import Q5.k;
import com.revenuecat.purchases.PurchasesError;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes2.dex */
public final class OfferingsFactory$getStoreProductsById$1$1$2 extends s implements k {
    final /* synthetic */ k $onError;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfferingsFactory$getStoreProductsById$1$1$2(k kVar) {
        super(1);
        this.$onError = kVar;
    }

    @Override // Q5.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PurchasesError) obj);
        return E.f1657a;
    }

    public final void invoke(PurchasesError it) {
        r.f(it, "it");
        this.$onError.invoke(it);
    }
}
