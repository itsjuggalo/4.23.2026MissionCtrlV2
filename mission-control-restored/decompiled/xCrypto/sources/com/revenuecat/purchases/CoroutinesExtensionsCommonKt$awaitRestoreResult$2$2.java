package com.revenuecat.purchases;

import W2.E;
import W2.p;
import i3.k;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class CoroutinesExtensionsCommonKt$awaitRestoreResult$2$2 extends s implements k {
    final /* synthetic */ Z2.e $continuation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutinesExtensionsCommonKt$awaitRestoreResult$2$2(Z2.e eVar) {
        super(1);
        this.$continuation = eVar;
    }

    @Override // i3.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CustomerInfo) obj);
        return E.f5463a;
    }

    public final void invoke(CustomerInfo customerInfo) {
        r.f(customerInfo, "customerInfo");
        this.$continuation.resumeWith(p.b(p.a(p.b(customerInfo))));
    }
}
