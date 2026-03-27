package com.revenuecat.purchases;

import W2.E;
import com.revenuecat.purchases.interfaces.PurchaseCallback;
import com.revenuecat.purchases.models.StoreTransaction;
import i3.o;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class PurchasesOrchestrator$getPurchaseCompletedCallbacks$onSuccess$1 extends s implements o {
    final /* synthetic */ PurchasesOrchestrator this$0;

    /* JADX INFO: renamed from: com.revenuecat.purchases.PurchasesOrchestrator$getPurchaseCompletedCallbacks$onSuccess$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends s implements Function0 {
        final /* synthetic */ CustomerInfo $info;
        final /* synthetic */ StoreTransaction $storeTransaction;
        final /* synthetic */ PurchasesOrchestrator this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(PurchasesOrchestrator purchasesOrchestrator, CustomerInfo customerInfo, StoreTransaction storeTransaction) {
            super(0);
            this.this$0 = purchasesOrchestrator;
            this.$info = customerInfo;
            this.$storeTransaction = storeTransaction;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m78invoke();
            return E.f5463a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m78invoke() {
            this.this$0.blockstoreHelper.storeUserIdIfNeeded(this.$info);
            PurchaseCallback purchaseCallback = this.this$0.getPurchaseCallback(this.$storeTransaction.getProductIds().get(0));
            if (purchaseCallback != null) {
                this.this$0.dispatch(new PurchasesOrchestrator$getPurchaseCompletedCallbacks$onSuccess$1$1$1$1(purchaseCallback, this.$storeTransaction, this.$info));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PurchasesOrchestrator$getPurchaseCompletedCallbacks$onSuccess$1(PurchasesOrchestrator purchasesOrchestrator) {
        super(2);
        this.this$0 = purchasesOrchestrator;
    }

    @Override // i3.o
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((StoreTransaction) obj, (CustomerInfo) obj2);
        return E.f5463a;
    }

    public final void invoke(StoreTransaction storeTransaction, CustomerInfo info) {
        r.f(storeTransaction, "storeTransaction");
        r.f(info, "info");
        this.this$0.backupManager.dataChanged();
        this.this$0.blockstoreHelper.aliasCurrentAndStoredUserIdsIfNeeded(new AnonymousClass1(this.this$0, info, storeTransaction));
    }
}
