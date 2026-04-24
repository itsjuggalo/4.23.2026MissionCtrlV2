package com.revenuecat.purchases;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class PurchasesOrchestrator$lifecycleHandler$2 extends s implements Function0 {
    final /* synthetic */ PurchasesOrchestrator this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PurchasesOrchestrator$lifecycleHandler$2(PurchasesOrchestrator purchasesOrchestrator) {
        super(0);
        this.this$0 = purchasesOrchestrator;
    }

    @Override // kotlin.jvm.functions.Function0
    public final AppLifecycleHandler invoke() {
        return new AppLifecycleHandler(this.this$0);
    }
}
