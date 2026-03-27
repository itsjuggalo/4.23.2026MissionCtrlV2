package com.revenuecat.purchases;

import W2.E;
import W2.p;
import W2.q;
import i3.k;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class CoroutinesExtensionsCommonKt$awaitRestore$2$1 extends s implements k {
    final /* synthetic */ Z2.e $continuation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutinesExtensionsCommonKt$awaitRestore$2$1(Z2.e eVar) {
        super(1);
        this.$continuation = eVar;
    }

    @Override // i3.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PurchasesError) obj);
        return E.f5463a;
    }

    public final void invoke(PurchasesError it) {
        r.f(it, "it");
        Z2.e eVar = this.$continuation;
        p.a aVar = p.f5487b;
        eVar.resumeWith(p.b(q.a(new PurchasesException(it))));
    }
}
