package com.revenuecat.purchases.google;

import E5.E;
import Q5.k;
import com.revenuecat.purchases.PurchasesError;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes2.dex */
public final class BillingWrapper$acknowledge$1 extends s implements k {
    public static final BillingWrapper$acknowledge$1 INSTANCE = new BillingWrapper$acknowledge$1();

    public BillingWrapper$acknowledge$1() {
        super(1);
    }

    public final void invoke(PurchasesError purchasesError) {
        r.f(purchasesError, "<anonymous parameter 0>");
    }

    @Override // Q5.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PurchasesError) obj);
        return E.f1657a;
    }
}
