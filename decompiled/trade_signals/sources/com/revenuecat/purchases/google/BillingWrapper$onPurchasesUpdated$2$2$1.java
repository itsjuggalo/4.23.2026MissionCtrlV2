package com.revenuecat.purchases.google;

import B5.k;
import com.android.billingclient.api.Purchase;
import com.revenuecat.purchases.common.PurchaseExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.AbstractC2306v;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/android/billingclient/api/Purchase;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class BillingWrapper$onPurchasesUpdated$2$2$1 extends AbstractC2306v implements k {
    public static final BillingWrapper$onPurchasesUpdated$2$2$1 INSTANCE = new BillingWrapper$onPurchasesUpdated$2$2$1();

    public BillingWrapper$onPurchasesUpdated$2$2$1() {
        super(1);
    }

    @Override // B5.k
    public final CharSequence invoke(Purchase it) {
        AbstractC2304t.f(it, "it");
        return PurchaseExtensionsKt.toHumanReadableDescription(it);
    }
}
