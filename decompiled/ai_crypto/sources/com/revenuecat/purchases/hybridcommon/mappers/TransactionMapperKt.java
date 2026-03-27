package com.revenuecat.purchases.hybridcommon.mappers;

import E5.t;
import F5.J;
import com.amazon.a.a.o.b;
import com.revenuecat.purchases.models.Transaction;
import java.util.Map;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class TransactionMapperKt {
    public static final Map<String, Object> map(Transaction transaction) {
        r.f(transaction, "<this>");
        return J.g(t.a("transactionIdentifier", transaction.getTransactionIdentifier()), t.a("revenueCatId", transaction.getTransactionIdentifier()), t.a("productIdentifier", transaction.getProductIdentifier()), t.a("productId", transaction.getProductIdentifier()), t.a("purchaseDateMillis", Long.valueOf(MappersHelpersKt.toMillis(transaction.getPurchaseDate()))), t.a(b.f9928Q, MappersHelpersKt.toIso8601(transaction.getPurchaseDate())));
    }
}
