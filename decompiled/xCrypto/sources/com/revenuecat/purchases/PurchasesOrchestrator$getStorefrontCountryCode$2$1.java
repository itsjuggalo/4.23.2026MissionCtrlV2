package com.revenuecat.purchases;

import W2.E;
import com.revenuecat.purchases.interfaces.GetStorefrontCallback;
import i3.k;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class PurchasesOrchestrator$getStorefrontCountryCode$2$1 extends s implements k {
    final /* synthetic */ GetStorefrontCallback $callback;
    final /* synthetic */ PurchasesOrchestrator $this_run;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PurchasesOrchestrator$getStorefrontCountryCode$2$1(PurchasesOrchestrator purchasesOrchestrator, GetStorefrontCallback getStorefrontCallback) {
        super(1);
        this.$this_run = purchasesOrchestrator;
        this.$callback = getStorefrontCallback;
    }

    @Override // i3.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return E.f5463a;
    }

    public final void invoke(String countryCode) {
        r.f(countryCode, "countryCode");
        this.$this_run.storefrontCountryCode = countryCode;
        this.$callback.onReceived(countryCode);
    }
}
