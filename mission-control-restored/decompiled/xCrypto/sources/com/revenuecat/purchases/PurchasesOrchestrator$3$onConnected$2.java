package com.revenuecat.purchases;

import W2.E;
import com.revenuecat.purchases.common.LogUtilsKt;
import i3.k;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class PurchasesOrchestrator$3$onConnected$2 extends s implements k {
    public static final PurchasesOrchestrator$3$onConnected$2 INSTANCE = new PurchasesOrchestrator$3$onConnected$2();

    public PurchasesOrchestrator$3$onConnected$2() {
        super(1);
    }

    @Override // i3.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PurchasesError) obj);
        return E.f5463a;
    }

    public final void invoke(PurchasesError error) {
        r.f(error, "error");
        LogUtilsKt.errorLog(error);
    }
}
