package com.revenuecat.purchases.hybridcommon;

import E5.E;
import Q5.k;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.hybridcommon.mappers.PurchasesErrorKt;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes2.dex */
public final class CommonKt$getProductInfo$onError$1 extends s implements k {
    final /* synthetic */ OnResultList $onResult;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonKt$getProductInfo$onError$1(OnResultList onResultList) {
        super(1);
        this.$onResult = onResultList;
    }

    @Override // Q5.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PurchasesError) obj);
        return E.f1657a;
    }

    public final void invoke(PurchasesError it) {
        r.f(it, "it");
        this.$onResult.onError(PurchasesErrorKt.map$default(it, null, 1, null));
    }
}
