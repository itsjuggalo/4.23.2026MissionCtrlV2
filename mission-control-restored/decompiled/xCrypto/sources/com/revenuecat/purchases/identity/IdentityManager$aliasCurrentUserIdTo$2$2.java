package com.revenuecat.purchases.identity;

import W2.E;
import W2.p;
import W2.q;
import Z2.e;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesException;
import i3.k;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes3.dex */
public final class IdentityManager$aliasCurrentUserIdTo$2$2 extends s implements k {
    final /* synthetic */ e $continuation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IdentityManager$aliasCurrentUserIdTo$2$2(e eVar) {
        super(1);
        this.$continuation = eVar;
    }

    @Override // i3.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PurchasesError) obj);
        return E.f5463a;
    }

    public final void invoke(PurchasesError error) {
        r.f(error, "error");
        e eVar = this.$continuation;
        p.a aVar = p.f5487b;
        eVar.resumeWith(p.b(q.a(new PurchasesException(error))));
    }
}
