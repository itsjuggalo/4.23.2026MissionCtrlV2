package com.revenuecat.purchases.google;

import Q5.k;
import com.android.billingclient.api.Purchase;
import com.revenuecat.purchases.common.PurchaseExtensionsKt;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes2.dex */
public final class BillingWrapper$onPurchasesUpdated$3$1 extends s implements k {
    public static final BillingWrapper$onPurchasesUpdated$3$1 INSTANCE = new BillingWrapper$onPurchasesUpdated$3$1();

    public BillingWrapper$onPurchasesUpdated$3$1() {
        super(1);
    }

    @Override // Q5.k
    public final CharSequence invoke(Purchase it) {
        r.f(it, "it");
        return PurchaseExtensionsKt.toHumanReadableDescription(it);
    }
}
