package com.revenuecat.purchases.google;

import W2.E;
import i3.k;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public /* synthetic */ class BillingWrapper$queryProductDetailsAsync$useCase$2 extends o implements i3.o {
    public BillingWrapper$queryProductDetailsAsync$useCase$2(Object obj) {
        super(2, obj, BillingWrapper.class, "executeRequestOnUIThread", "executeRequestOnUIThread(Ljava/lang/Long;Lkotlin/jvm/functions/Function1;)V", 0);
    }

    @Override // i3.o
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Long) obj, (k) obj2);
        return E.f5463a;
    }

    public final void invoke(Long l4, k p12) {
        r.f(p12, "p1");
        ((BillingWrapper) this.receiver).executeRequestOnUIThread(l4, p12);
    }
}
