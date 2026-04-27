package com.revenuecat.purchases;

import E5.E;
import E5.p;
import Q5.k;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public /* synthetic */ class CoroutinesExtensionsKt$awaitCustomerInfo$2$1 extends o implements k {
    public CoroutinesExtensionsKt$awaitCustomerInfo$2$1(Object obj) {
        super(1, obj, H5.f.class, "resume", "resume(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", 1);
    }

    @Override // Q5.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CustomerInfo) obj);
        return E.f1657a;
    }

    public final void invoke(CustomerInfo p02) {
        r.f(p02, "p0");
        ((H5.d) this.receiver).resumeWith(p.b(p02));
    }
}
