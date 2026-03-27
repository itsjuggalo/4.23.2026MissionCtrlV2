package com.revenuecat.purchases.hybridcommon;

import W2.E;
import W2.t;
import X2.L;
import com.revenuecat.purchases.hybridcommon.mappers.StoreTransactionMapperKt;
import com.revenuecat.purchases.models.StoreTransaction;
import i3.k;
import java.util.Map;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes3.dex */
public final class CommonKt$getPurchaseCompletedFunction$1$1$1 extends s implements k {
    final /* synthetic */ OnResult $onResult;
    final /* synthetic */ StoreTransaction $transaction;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonKt$getPurchaseCompletedFunction$1$1$1(OnResult onResult, StoreTransaction storeTransaction) {
        super(1);
        this.$onResult = onResult;
        this.$transaction = storeTransaction;
    }

    @Override // i3.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Map<String, ? extends Object>) obj);
        return E.f5463a;
    }

    public final void invoke(Map<String, ? extends Object> map) {
        r.f(map, "map");
        this.$onResult.onReceived(L.g(t.a("productIdentifier", this.$transaction.getProductIds().get(0)), t.a("customerInfo", map), t.a("transaction", StoreTransactionMapperKt.map(this.$transaction))));
    }
}
