package com.revenuecat.purchases;

import W2.E;
import i3.k;
import java.util.Date;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class SyncPurchasesHelper$syncPurchases$handleError$1 extends s implements k {
    final /* synthetic */ k $onError;
    final /* synthetic */ Date $startTime;
    final /* synthetic */ SyncPurchasesHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SyncPurchasesHelper$syncPurchases$handleError$1(SyncPurchasesHelper syncPurchasesHelper, Date date, k kVar) {
        super(1);
        this.this$0 = syncPurchasesHelper;
        this.$startTime = date;
        this.$onError = kVar;
    }

    @Override // i3.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PurchasesError) obj);
        return E.f5463a;
    }

    public final void invoke(PurchasesError it) {
        r.f(it, "it");
        this.this$0.trackSyncPurchasesResultIfNeeded(it, this.$startTime);
        this.$onError.invoke(it);
    }
}
