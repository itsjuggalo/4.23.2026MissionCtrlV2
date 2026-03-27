package com.revenuecat.purchases;

import W2.E;
import W2.p;
import com.revenuecat.purchases.data.LogInResult;
import i3.o;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class CoroutinesExtensionsKt$awaitLogIn$2$2 extends s implements o {
    final /* synthetic */ Z2.e $continuation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutinesExtensionsKt$awaitLogIn$2$2(Z2.e eVar) {
        super(2);
        this.$continuation = eVar;
    }

    @Override // i3.o
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((CustomerInfo) obj, ((Boolean) obj2).booleanValue());
        return E.f5463a;
    }

    public final void invoke(CustomerInfo customerInfo, boolean z4) {
        r.f(customerInfo, "customerInfo");
        Z2.e eVar = this.$continuation;
        p.a aVar = p.f5487b;
        eVar.resumeWith(p.b(new LogInResult(customerInfo, z4)));
    }
}
