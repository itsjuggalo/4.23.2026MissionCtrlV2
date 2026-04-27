package com.revenuecat.purchases;

import E5.E;
import E5.p;
import Q5.k;
import com.revenuecat.purchases.models.StoreProduct;
import java.util.List;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public /* synthetic */ class CoroutinesExtensionsCommonKt$awaitGetProducts$2$1 extends o implements k {
    public CoroutinesExtensionsCommonKt$awaitGetProducts$2$1(Object obj) {
        super(1, obj, H5.f.class, "resume", "resume(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", 1);
    }

    @Override // Q5.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<? extends StoreProduct>) obj);
        return E.f1657a;
    }

    public final void invoke(List<? extends StoreProduct> p02) {
        r.f(p02, "p0");
        ((H5.d) this.receiver).resumeWith(p.b(p02));
    }
}
