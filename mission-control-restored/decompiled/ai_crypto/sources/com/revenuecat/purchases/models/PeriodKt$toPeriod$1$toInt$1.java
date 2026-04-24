package com.revenuecat.purchases.models;

import Q5.k;
import Z5.w;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes2.dex */
public final class PeriodKt$toPeriod$1$toInt$1 extends s implements k {
    public static final PeriodKt$toPeriod$1$toInt$1 INSTANCE = new PeriodKt$toPeriod$1$toInt$1();

    public PeriodKt$toPeriod$1$toInt$1() {
        super(1);
    }

    @Override // Q5.k
    public final Integer invoke(String part) {
        r.f(part, "part");
        Integer numI = Z5.s.i(w.C0(part, 1));
        return Integer.valueOf(numI != null ? numI.intValue() : 0);
    }
}
