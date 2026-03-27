package com.revenuecat.purchases;

import E5.E;
import Q5.k;
import com.revenuecat.purchases.common.LogUtilsKt;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class PurchasesOrchestrator$2$onConnected$2 extends s implements k {
    public static final PurchasesOrchestrator$2$onConnected$2 INSTANCE = new PurchasesOrchestrator$2$onConnected$2();

    public PurchasesOrchestrator$2$onConnected$2() {
        super(1);
    }

    @Override // Q5.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PurchasesError) obj);
        return E.f1657a;
    }

    public final void invoke(PurchasesError error) {
        r.f(error, "error");
        LogUtilsKt.errorLog(error);
    }
}
