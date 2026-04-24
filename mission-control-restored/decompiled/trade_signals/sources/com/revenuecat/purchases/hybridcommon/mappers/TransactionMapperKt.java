package com.revenuecat.purchases.hybridcommon.mappers;

import com.amazon.a.a.o.b;
import com.revenuecat.purchases.models.Transaction;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2304t;
import o5.w;
import p5.M;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u0004¨\u0006\u0005"}, d2 = {"map", "", "", "", "Lcom/revenuecat/purchases/models/Transaction;", "hybridcommon_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TransactionMapperKt {
    public static final Map<String, Object> map(Transaction transaction) {
        AbstractC2304t.f(transaction, "<this>");
        return M.k(w.a("transactionIdentifier", transaction.getTransactionIdentifier()), w.a("revenueCatId", transaction.getTransactionIdentifier()), w.a("productIdentifier", transaction.getProductIdentifier()), w.a("productId", transaction.getProductIdentifier()), w.a("purchaseDateMillis", Long.valueOf(MappersHelpersKt.toMillis(transaction.getPurchaseDate()))), w.a(b.f14039Q, MappersHelpersKt.toIso8601(transaction.getPurchaseDate())));
    }
}
