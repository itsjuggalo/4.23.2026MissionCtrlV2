package com.revenuecat.purchases.hybridcommon.mappers;

import W2.t;
import X2.L;
import X2.x;
import com.amazon.a.a.o.b;
import com.revenuecat.purchases.models.StoreTransaction;
import java.util.Date;
import java.util.Map;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class StoreTransactionMapperKt {
    public static final Map<String, Object> map(StoreTransaction storeTransaction) {
        r.f(storeTransaction, "<this>");
        return L.g(t.a("transactionIdentifier", storeTransaction.getOrderId()), t.a("productIdentifier", x.H(storeTransaction.getProductIds())), t.a("purchaseDateMillis", Long.valueOf(storeTransaction.getPurchaseTime())), t.a(b.f8743Q, MappersHelpersKt.toIso8601(new Date(storeTransaction.getPurchaseTime()))));
    }
}
