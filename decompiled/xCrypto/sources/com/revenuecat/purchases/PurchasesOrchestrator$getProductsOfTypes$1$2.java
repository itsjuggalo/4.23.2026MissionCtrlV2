package com.revenuecat.purchases;

import W2.E;
import com.revenuecat.purchases.interfaces.GetStoreProductsCallback;
import i3.k;
import java.util.Date;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class PurchasesOrchestrator$getProductsOfTypes$1$2 extends s implements k {
    final /* synthetic */ GetStoreProductsCallback $callback;
    final /* synthetic */ Date $nonNullStartTime;
    final /* synthetic */ Set<String> $productIds;
    final /* synthetic */ PurchasesOrchestrator this$0;

    /* JADX INFO: renamed from: com.revenuecat.purchases.PurchasesOrchestrator$getProductsOfTypes$1$2$1, reason: invalid class name */
    public static final class AnonymousClass1 extends s implements Function0 {
        final /* synthetic */ GetStoreProductsCallback $callback;
        final /* synthetic */ PurchasesError $it;
        final /* synthetic */ Date $nonNullStartTime;
        final /* synthetic */ Set<String> $productIds;
        final /* synthetic */ PurchasesOrchestrator this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(PurchasesOrchestrator purchasesOrchestrator, Date date, Set<String> set, PurchasesError purchasesError, GetStoreProductsCallback getStoreProductsCallback) {
            super(0);
            this.this$0 = purchasesOrchestrator;
            this.$nonNullStartTime = date;
            this.$productIds = set;
            this.$it = purchasesError;
            this.$callback = getStoreProductsCallback;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m77invoke();
            return E.f5463a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m77invoke() {
            PurchasesOrchestrator purchasesOrchestrator = this.this$0;
            Date date = this.$nonNullStartTime;
            Set<String> set = this.$productIds;
            purchasesOrchestrator.trackGetProductsResult(date, set, set, this.$it);
            this.$callback.onError(this.$it);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PurchasesOrchestrator$getProductsOfTypes$1$2(PurchasesOrchestrator purchasesOrchestrator, Date date, Set<String> set, GetStoreProductsCallback getStoreProductsCallback) {
        super(1);
        this.this$0 = purchasesOrchestrator;
        this.$nonNullStartTime = date;
        this.$productIds = set;
        this.$callback = getStoreProductsCallback;
    }

    @Override // i3.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PurchasesError) obj);
        return E.f5463a;
    }

    public final void invoke(PurchasesError it) {
        r.f(it, "it");
        PurchasesOrchestrator purchasesOrchestrator = this.this$0;
        purchasesOrchestrator.dispatch(new AnonymousClass1(purchasesOrchestrator, this.$nonNullStartTime, this.$productIds, it, this.$callback));
    }
}
