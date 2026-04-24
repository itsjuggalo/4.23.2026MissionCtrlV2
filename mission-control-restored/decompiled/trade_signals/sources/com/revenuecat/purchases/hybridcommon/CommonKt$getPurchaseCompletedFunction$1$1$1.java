package com.revenuecat.purchases.hybridcommon;

import B5.k;
import com.revenuecat.purchases.hybridcommon.mappers.StoreTransactionMapperKt;
import com.revenuecat.purchases.models.StoreTransaction;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.AbstractC2306v;
import o5.C2470H;
import o5.w;
import p5.M;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "", "", "map", "Lo5/H;", "invoke", "(Ljava/util/Map;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
public final class CommonKt$getPurchaseCompletedFunction$1$1$1 extends AbstractC2306v implements k {
    final /* synthetic */ OnResult $onResult;
    final /* synthetic */ StoreTransaction $transaction;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonKt$getPurchaseCompletedFunction$1$1$1(OnResult onResult, StoreTransaction storeTransaction) {
        super(1);
        this.$onResult = onResult;
        this.$transaction = storeTransaction;
    }

    @Override // B5.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Map<String, ? extends Object>) obj);
        return C2470H.f21956a;
    }

    public final void invoke(Map<String, ? extends Object> map) {
        AbstractC2304t.f(map, "map");
        this.$onResult.onReceived(M.k(w.a("productIdentifier", this.$transaction.getProductIds().get(0)), w.a("customerInfo", map), w.a("transaction", StoreTransactionMapperKt.map(this.$transaction))));
    }
}
