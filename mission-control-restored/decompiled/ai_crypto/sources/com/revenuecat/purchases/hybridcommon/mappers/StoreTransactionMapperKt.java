package com.revenuecat.purchases.hybridcommon.mappers;

import E5.t;
import F5.J;
import F5.v;
import com.amazon.a.a.o.b;
import com.revenuecat.purchases.models.StoreTransaction;
import java.util.Date;
import java.util.Map;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class StoreTransactionMapperKt {
    public static final Map<String, Object> map(StoreTransaction storeTransaction) {
        r.f(storeTransaction, "<this>");
        return J.g(t.a("transactionIdentifier", storeTransaction.getOrderId()), t.a("productIdentifier", v.I(storeTransaction.getProductIds())), t.a("purchaseDateMillis", Long.valueOf(storeTransaction.getPurchaseTime())), t.a(b.f9928Q, MappersHelpersKt.toIso8601(new Date(storeTransaction.getPurchaseTime()))));
    }
}
