package com.revenuecat.purchases;

import cd.h0;
import cd.r;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public /* synthetic */ class CoroutinesExtensionsKt$awaitCustomerInfo$2$1 extends q implements pd.k {
    public CoroutinesExtensionsKt$awaitCustomerInfo$2$1(Object obj) {
        super(1, obj, gd.g.class, "resume", "resume(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", 1);
    }

    @Override // pd.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CustomerInfo) obj);
        return h0.f3852a;
    }

    public final void invoke(CustomerInfo p02) {
        t.f(p02, "p0");
        ((gd.e) this.receiver).resumeWith(r.b(p02));
    }
}
