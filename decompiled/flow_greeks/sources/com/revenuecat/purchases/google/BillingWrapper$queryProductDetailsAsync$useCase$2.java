package com.revenuecat.purchases.google;

import cd.h0;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.t;
import pd.k;
import pd.o;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public /* synthetic */ class BillingWrapper$queryProductDetailsAsync$useCase$2 extends q implements o {
    public BillingWrapper$queryProductDetailsAsync$useCase$2(Object obj) {
        super(2, obj, BillingWrapper.class, "executeRequestOnUIThread", "executeRequestOnUIThread(Ljava/lang/Long;Lkotlin/jvm/functions/Function1;)V", 0);
    }

    @Override // pd.o
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Long) obj, (k) obj2);
        return h0.f3852a;
    }

    public final void invoke(Long l10, k p12) {
        t.f(p12, "p1");
        ((BillingWrapper) this.receiver).executeRequestOnUIThread(l10, p12);
    }
}
