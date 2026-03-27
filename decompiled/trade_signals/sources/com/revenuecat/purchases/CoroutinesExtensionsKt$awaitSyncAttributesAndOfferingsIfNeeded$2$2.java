package com.revenuecat.purchases;

import B5.k;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.AbstractC2306v;
import o5.AbstractC2491s;
import o5.C2470H;
import o5.C2490r;
import s5.InterfaceC2707e;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/revenuecat/purchases/PurchasesError;", "it", "Lo5/H;", "invoke", "(Lcom/revenuecat/purchases/PurchasesError;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
public final class CoroutinesExtensionsKt$awaitSyncAttributesAndOfferingsIfNeeded$2$2 extends AbstractC2306v implements k {
    final /* synthetic */ InterfaceC2707e $continuation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutinesExtensionsKt$awaitSyncAttributesAndOfferingsIfNeeded$2$2(InterfaceC2707e interfaceC2707e) {
        super(1);
        this.$continuation = interfaceC2707e;
    }

    @Override // B5.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PurchasesError) obj);
        return C2470H.f21956a;
    }

    public final void invoke(PurchasesError it) {
        AbstractC2304t.f(it, "it");
        InterfaceC2707e interfaceC2707e = this.$continuation;
        C2490r.a aVar = C2490r.f21981b;
        interfaceC2707e.resumeWith(C2490r.b(AbstractC2491s.a(new PurchasesException(it))));
    }
}
