package com.revenuecat.purchases;

import W2.E;
import W2.p;
import W2.q;
import i3.o;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class CoroutinesExtensionsCommonKt$awaitPurchaseResult$2$2 extends s implements o {
    final /* synthetic */ Z2.e $continuation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutinesExtensionsCommonKt$awaitPurchaseResult$2$2(Z2.e eVar) {
        super(2);
        this.$continuation = eVar;
    }

    @Override // i3.o
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((PurchasesError) obj, ((Boolean) obj2).booleanValue());
        return E.f5463a;
    }

    public final void invoke(PurchasesError purchasesError, boolean z4) {
        r.f(purchasesError, "purchasesError");
        Z2.e eVar = this.$continuation;
        p.a aVar = p.f5487b;
        eVar.resumeWith(p.b(p.a(p.b(q.a(new PurchasesTransactionException(purchasesError, z4))))));
    }
}
