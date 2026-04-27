package com.revenuecat.purchases;

import B5.k;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2302q;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2470H;
import o5.C2490r;
import s5.AbstractC2709g;
import s5.InterfaceC2707e;

/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public /* synthetic */ class CoroutinesExtensionsKt$awaitCustomerInfo$2$1 extends AbstractC2302q implements k {
    public CoroutinesExtensionsKt$awaitCustomerInfo$2$1(Object obj) {
        super(1, obj, AbstractC2709g.class, "resume", "resume(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", 1);
    }

    @Override // B5.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CustomerInfo) obj);
        return C2470H.f21956a;
    }

    public final void invoke(CustomerInfo p02) {
        AbstractC2304t.f(p02, "p0");
        ((InterfaceC2707e) this.receiver).resumeWith(C2490r.b(p02));
    }
}
