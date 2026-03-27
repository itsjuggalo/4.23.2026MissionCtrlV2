package com.revenuecat.purchases;

import E5.E;
import Q5.k;
import com.revenuecat.purchases.SyncPendingPurchaseResult;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class PostPendingTransactionsHelper$syncPendingPurchaseQueue$1$2 extends s implements k {
    final /* synthetic */ k $callback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostPendingTransactionsHelper$syncPendingPurchaseQueue$1$2(k kVar) {
        super(1);
        this.$callback = kVar;
    }

    @Override // Q5.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PurchasesError) obj);
        return E.f1657a;
    }

    public final void invoke(PurchasesError error) {
        r.f(error, "error");
        LogWrapperKt.log(LogIntent.GOOGLE_ERROR, error.toString());
        k kVar = this.$callback;
        if (kVar != null) {
            kVar.invoke(new SyncPendingPurchaseResult.Error(error));
        }
    }
}
