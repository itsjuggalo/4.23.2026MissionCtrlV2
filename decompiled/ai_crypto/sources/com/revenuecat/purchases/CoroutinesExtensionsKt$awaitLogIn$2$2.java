package com.revenuecat.purchases;

import E5.E;
import E5.p;
import Q5.o;
import com.revenuecat.purchases.data.LogInResult;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class CoroutinesExtensionsKt$awaitLogIn$2$2 extends s implements o {
    final /* synthetic */ H5.d $continuation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutinesExtensionsKt$awaitLogIn$2$2(H5.d dVar) {
        super(2);
        this.$continuation = dVar;
    }

    @Override // Q5.o
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((CustomerInfo) obj, ((Boolean) obj2).booleanValue());
        return E.f1657a;
    }

    public final void invoke(CustomerInfo customerInfo, boolean z7) {
        r.f(customerInfo, "customerInfo");
        H5.d dVar = this.$continuation;
        p.a aVar = p.f1681b;
        dVar.resumeWith(p.b(new LogInResult(customerInfo, z7)));
    }
}
