package com.revenuecat.purchases;

import W2.E;
import i3.k;
import java.util.Date;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class SyncPurchasesHelper$syncPurchases$handleSuccess$1 extends s implements k {
    final /* synthetic */ k $onSuccess;
    final /* synthetic */ Date $startTime;
    final /* synthetic */ SyncPurchasesHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SyncPurchasesHelper$syncPurchases$handleSuccess$1(SyncPurchasesHelper syncPurchasesHelper, Date date, k kVar) {
        super(1);
        this.this$0 = syncPurchasesHelper;
        this.$startTime = date;
        this.$onSuccess = kVar;
    }

    @Override // i3.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CustomerInfo) obj);
        return E.f5463a;
    }

    public final void invoke(CustomerInfo it) {
        r.f(it, "it");
        this.this$0.trackSyncPurchasesResultIfNeeded(null, this.$startTime);
        this.$onSuccess.invoke(it);
    }
}
