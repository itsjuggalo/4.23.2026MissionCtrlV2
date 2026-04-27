package com.revenuecat.purchases;

import E5.E;
import E5.p;
import Q5.k;
import com.revenuecat.purchases.models.StoreProduct;
import java.util.List;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class CoroutinesExtensionsCommonKt$awaitGetProductsResult$2$2 extends s implements k {
    final /* synthetic */ H5.d $continuation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutinesExtensionsCommonKt$awaitGetProductsResult$2$2(H5.d dVar) {
        super(1);
        this.$continuation = dVar;
    }

    @Override // Q5.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<? extends StoreProduct>) obj);
        return E.f1657a;
    }

    public final void invoke(List<? extends StoreProduct> storeProducts) {
        r.f(storeProducts, "storeProducts");
        this.$continuation.resumeWith(p.b(p.a(p.b(storeProducts))));
    }
}
