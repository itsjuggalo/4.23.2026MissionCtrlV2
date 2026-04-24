package com.revenuecat.purchases.hybridcommon;

import W2.E;
import W2.t;
import X2.L;
import com.revenuecat.purchases.interfaces.RedeemWebPurchaseListener;
import i3.k;
import java.util.Map;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes3.dex */
public final class CommonKt$redeemWebPurchase$1$1 extends s implements k {
    final /* synthetic */ OnResult $onResult;
    final /* synthetic */ RedeemWebPurchaseListener.Result $result;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonKt$redeemWebPurchase$1$1(OnResult onResult, RedeemWebPurchaseListener.Result result) {
        super(1);
        this.$onResult = onResult;
        this.$result = result;
    }

    @Override // i3.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Map<String, ? extends Object>) obj);
        return E.f5463a;
    }

    public final void invoke(Map<String, ? extends Object> map) {
        r.f(map, "map");
        this.$onResult.onReceived(L.i(t.a("result", CommonKt.toResultName(this.$result)), t.a("customerInfo", map)));
    }
}
