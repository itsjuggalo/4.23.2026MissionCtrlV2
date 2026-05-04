package com.revenuecat.purchases.hybridcommon;

import cd.h0;
import cd.w;
import com.revenuecat.purchases.interfaces.RedeemWebPurchaseListener;
import dd.o0;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import pd.k;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "", "", "map", "Lcd/h0;", "invoke", "(Ljava/util/Map;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
public final class CommonKt$redeemWebPurchase$1$1 extends v implements k {
    final /* synthetic */ OnResult $onResult;
    final /* synthetic */ RedeemWebPurchaseListener.Result $result;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonKt$redeemWebPurchase$1$1(OnResult onResult, RedeemWebPurchaseListener.Result result) {
        super(1);
        this.$onResult = onResult;
        this.$result = result;
    }

    @Override // pd.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Map<String, ? extends Object>) obj);
        return h0.f3852a;
    }

    public final void invoke(Map<String, ? extends Object> map) {
        t.f(map, "map");
        this.$onResult.onReceived(o0.n(w.a("result", CommonKt.toResultName(this.$result)), w.a("customerInfo", map)));
    }
}
