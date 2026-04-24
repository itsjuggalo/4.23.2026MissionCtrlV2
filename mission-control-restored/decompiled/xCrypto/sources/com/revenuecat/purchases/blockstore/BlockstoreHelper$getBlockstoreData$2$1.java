package com.revenuecat.purchases.blockstore;

import W2.E;
import W2.p;
import Z2.e;
import i3.k;
import kotlin.jvm.internal.s;
import w1.C1904e;

/* JADX INFO: loaded from: classes.dex */
public final class BlockstoreHelper$getBlockstoreData$2$1 extends s implements k {
    final /* synthetic */ e $cont;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlockstoreHelper$getBlockstoreData$2$1(e eVar) {
        super(1);
        this.$cont = eVar;
    }

    @Override // i3.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((C1904e) obj);
        return E.f5463a;
    }

    public final void invoke(C1904e c1904e) {
        e eVar = this.$cont;
        p.a aVar = p.f5487b;
        eVar.resumeWith(p.b(c1904e.i()));
    }
}
