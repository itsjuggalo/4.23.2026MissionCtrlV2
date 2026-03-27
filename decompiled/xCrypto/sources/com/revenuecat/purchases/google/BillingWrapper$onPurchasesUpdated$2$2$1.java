package com.revenuecat.purchases.google;

import com.android.billingclient.api.Purchase;
import com.revenuecat.purchases.common.PurchaseExtensionsKt;
import i3.k;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes3.dex */
public final class BillingWrapper$onPurchasesUpdated$2$2$1 extends s implements k {
    public static final BillingWrapper$onPurchasesUpdated$2$2$1 INSTANCE = new BillingWrapper$onPurchasesUpdated$2$2$1();

    public BillingWrapper$onPurchasesUpdated$2$2$1() {
        super(1);
    }

    @Override // i3.k
    public final CharSequence invoke(Purchase it) {
        r.f(it, "it");
        return PurchaseExtensionsKt.toHumanReadableDescription(it);
    }
}
