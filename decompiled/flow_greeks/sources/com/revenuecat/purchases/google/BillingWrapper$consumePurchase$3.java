package com.revenuecat.purchases.google;

import cd.h0;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.t;
import pd.k;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public /* synthetic */ class BillingWrapper$consumePurchase$3 extends q implements k {
    public BillingWrapper$consumePurchase$3(Object obj) {
        super(1, obj, BillingWrapper.class, "withConnectedClient", "withConnectedClient(Lkotlin/jvm/functions/Function1;)V", 0);
    }

    @Override // pd.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((k) obj);
        return h0.f3852a;
    }

    public final void invoke(k p02) {
        t.f(p02, "p0");
        ((BillingWrapper) this.receiver).withConnectedClient(p02);
    }
}
