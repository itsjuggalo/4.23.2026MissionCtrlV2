package com.revenuecat.purchases.google;

import W2.E;
import com.revenuecat.purchases.PurchasesError;
import i3.k;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes3.dex */
public final class BillingWrapper$acknowledge$2 extends s implements k {
    public static final BillingWrapper$acknowledge$2 INSTANCE = new BillingWrapper$acknowledge$2();

    public BillingWrapper$acknowledge$2() {
        super(1);
    }

    public final void invoke(PurchasesError purchasesError) {
        r.f(purchasesError, "<anonymous parameter 0>");
    }

    @Override // i3.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PurchasesError) obj);
        return E.f5463a;
    }
}
