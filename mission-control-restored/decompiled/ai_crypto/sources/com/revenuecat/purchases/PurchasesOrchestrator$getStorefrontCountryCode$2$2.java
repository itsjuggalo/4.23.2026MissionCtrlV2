package com.revenuecat.purchases;

import E5.E;
import Q5.k;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.interfaces.GetStorefrontCallback;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class PurchasesOrchestrator$getStorefrontCountryCode$2$2 extends s implements k {
    final /* synthetic */ GetStorefrontCallback $callback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PurchasesOrchestrator$getStorefrontCountryCode$2$2(GetStorefrontCallback getStorefrontCallback) {
        super(1);
        this.$callback = getStorefrontCallback;
    }

    @Override // Q5.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PurchasesError) obj);
        return E.f1657a;
    }

    public final void invoke(PurchasesError error) {
        r.f(error, "error");
        LogUtilsKt.errorLog(error);
        this.$callback.onError(error);
    }
}
