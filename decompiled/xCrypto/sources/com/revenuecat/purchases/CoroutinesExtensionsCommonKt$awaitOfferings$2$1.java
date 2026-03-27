package com.revenuecat.purchases;

import W2.E;
import W2.p;
import i3.k;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public /* synthetic */ class CoroutinesExtensionsCommonKt$awaitOfferings$2$1 extends o implements k {
    public CoroutinesExtensionsCommonKt$awaitOfferings$2$1(Object obj) {
        super(1, obj, Z2.g.class, "resume", "resume(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", 1);
    }

    @Override // i3.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Offerings) obj);
        return E.f5463a;
    }

    public final void invoke(Offerings p02) {
        r.f(p02, "p0");
        ((Z2.e) this.receiver).resumeWith(p.b(p02));
    }
}
