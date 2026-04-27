package com.revenuecat.purchases.models;

import i3.k;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import r3.C;
import r3.w;

/* JADX INFO: loaded from: classes3.dex */
public final class PeriodKt$toPeriod$1$toInt$1 extends s implements k {
    public static final PeriodKt$toPeriod$1$toInt$1 INSTANCE = new PeriodKt$toPeriod$1$toInt$1();

    public PeriodKt$toPeriod$1$toInt$1() {
        super(1);
    }

    @Override // i3.k
    public final Integer invoke(String part) {
        r.f(part, "part");
        Integer numM = w.m(C.H0(part, 1));
        return Integer.valueOf(numM != null ? numM.intValue() : 0);
    }
}
