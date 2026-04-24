package com.revenuecat.purchases;

import W2.E;
import com.revenuecat.purchases.interfaces.PurchaseCallback;
import com.revenuecat.purchases.models.StoreTransaction;
import i3.o;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class PurchasesOrchestrator$getPurchaseCompletedCallbacks$onError$1 extends s implements o {
    final /* synthetic */ PurchasesOrchestrator this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PurchasesOrchestrator$getPurchaseCompletedCallbacks$onError$1(PurchasesOrchestrator purchasesOrchestrator) {
        super(2);
        this.this$0 = purchasesOrchestrator;
    }

    @Override // i3.o
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((StoreTransaction) obj, (PurchasesError) obj2);
        return E.f5463a;
    }

    public final void invoke(StoreTransaction purchase, PurchasesError error) {
        r.f(purchase, "purchase");
        r.f(error, "error");
        PurchaseCallback purchaseCallback = this.this$0.getPurchaseCallback(purchase.getProductIds().get(0));
        if (purchaseCallback != null) {
            this.this$0.dispatch(purchaseCallback, error);
        }
    }
}
