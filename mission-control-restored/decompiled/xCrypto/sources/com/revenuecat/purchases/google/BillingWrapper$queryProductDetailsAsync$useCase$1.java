package com.revenuecat.purchases.google;

import W2.E;
import i3.k;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public /* synthetic */ class BillingWrapper$queryProductDetailsAsync$useCase$1 extends o implements k {
    public BillingWrapper$queryProductDetailsAsync$useCase$1(Object obj) {
        super(1, obj, BillingWrapper.class, "withConnectedClient", "withConnectedClient(Lkotlin/jvm/functions/Function1;)V", 0);
    }

    @Override // i3.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((k) obj);
        return E.f5463a;
    }

    public final void invoke(k p02) {
        r.f(p02, "p0");
        ((BillingWrapper) this.receiver).withConnectedClient(p02);
    }
}
