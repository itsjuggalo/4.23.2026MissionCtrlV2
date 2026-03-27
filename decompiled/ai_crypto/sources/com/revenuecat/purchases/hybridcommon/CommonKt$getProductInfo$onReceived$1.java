package com.revenuecat.purchases.hybridcommon;

import E5.E;
import Q5.k;
import com.revenuecat.purchases.hybridcommon.mappers.StoreProductMapperKt;
import com.revenuecat.purchases.models.StoreProduct;
import java.util.List;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes2.dex */
public final class CommonKt$getProductInfo$onReceived$1 extends s implements k {
    final /* synthetic */ OnResultList $onResult;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonKt$getProductInfo$onReceived$1(OnResultList onResultList) {
        super(1);
        this.$onResult = onResultList;
    }

    @Override // Q5.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<? extends StoreProduct>) obj);
        return E.f1657a;
    }

    public final void invoke(List<? extends StoreProduct> it) {
        r.f(it, "it");
        this.$onResult.onReceived(StoreProductMapperKt.map(it));
    }
}
