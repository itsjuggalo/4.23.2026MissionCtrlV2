package com.revenuecat.purchases;

import E5.E;
import E5.p;
import E5.q;
import Q5.k;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class CoroutinesExtensionsKt$awaitLogOut$2$1 extends s implements k {
    final /* synthetic */ H5.d $continuation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutinesExtensionsKt$awaitLogOut$2$1(H5.d dVar) {
        super(1);
        this.$continuation = dVar;
    }

    @Override // Q5.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PurchasesError) obj);
        return E.f1657a;
    }

    public final void invoke(PurchasesError it) {
        r.f(it, "it");
        H5.d dVar = this.$continuation;
        p.a aVar = p.f1681b;
        dVar.resumeWith(p.b(q.a(new PurchasesException(it))));
    }
}
