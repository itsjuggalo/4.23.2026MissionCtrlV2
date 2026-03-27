package com.revenuecat.purchases.google;

import W2.E;
import com.revenuecat.purchases.ProductType;
import i3.k;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes3.dex */
public final class BillingWrapper$getPurchaseType$1 extends s implements k {
    final /* synthetic */ k $listener;
    final /* synthetic */ String $purchaseToken;
    final /* synthetic */ BillingWrapper this$0;

    /* JADX INFO: renamed from: com.revenuecat.purchases.google.BillingWrapper$getPurchaseType$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends s implements k {
        final /* synthetic */ k $listener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(k kVar) {
            super(1);
            this.$listener = kVar;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke(((Boolean) obj).booleanValue());
            return E.f5463a;
        }

        public final void invoke(boolean z4) {
            if (z4) {
                this.$listener.invoke(ProductType.INAPP);
            } else {
                this.$listener.invoke(ProductType.UNKNOWN);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BillingWrapper$getPurchaseType$1(k kVar, BillingWrapper billingWrapper, String str) {
        super(1);
        this.$listener = kVar;
        this.this$0 = billingWrapper;
        this.$purchaseToken = str;
    }

    @Override // i3.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return E.f5463a;
    }

    public final void invoke(boolean z4) {
        if (z4) {
            this.$listener.invoke(ProductType.SUBS);
            return;
        }
        BillingWrapper billingWrapper = this.this$0;
        String str = this.$purchaseToken;
        k kVar = this.$listener;
        billingWrapper.queryPurchaseType("inapp", str, kVar, new AnonymousClass1(kVar));
    }
}
