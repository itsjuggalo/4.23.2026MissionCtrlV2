package com.revenuecat.purchases;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class Offering$threeMonth$2 extends s implements Function0 {
    final /* synthetic */ Offering this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Offering$threeMonth$2(Offering offering) {
        super(0);
        this.this$0 = offering;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Package invoke() {
        return this.this$0.findPackage(PackageType.THREE_MONTH);
    }
}
