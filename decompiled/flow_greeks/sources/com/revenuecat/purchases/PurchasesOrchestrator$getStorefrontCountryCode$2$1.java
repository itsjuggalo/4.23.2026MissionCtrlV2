package com.revenuecat.purchases;

import cd.h0;
import com.revenuecat.purchases.interfaces.GetStorefrontCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "countryCode", "Lcd/h0;", "invoke", "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
public final class PurchasesOrchestrator$getStorefrontCountryCode$2$1 extends v implements pd.k {
    final /* synthetic */ GetStorefrontCallback $callback;
    final /* synthetic */ PurchasesOrchestrator $this_run;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PurchasesOrchestrator$getStorefrontCountryCode$2$1(PurchasesOrchestrator purchasesOrchestrator, GetStorefrontCallback getStorefrontCallback) {
        super(1);
        this.$this_run = purchasesOrchestrator;
        this.$callback = getStorefrontCallback;
    }

    @Override // pd.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return h0.f3852a;
    }

    public final void invoke(String countryCode) {
        t.f(countryCode, "countryCode");
        this.$this_run.storefrontCountryCode = countryCode;
        this.$callback.onReceived(countryCode);
    }
}
