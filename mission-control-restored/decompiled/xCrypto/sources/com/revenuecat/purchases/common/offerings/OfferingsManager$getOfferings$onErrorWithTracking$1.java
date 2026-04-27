package com.revenuecat.purchases.common.offerings;

import W2.E;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import i3.k;
import i3.o;
import java.util.Date;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class OfferingsManager$getOfferings$onErrorWithTracking$1 extends s implements o {
    final /* synthetic */ k $onError;
    final /* synthetic */ Date $startTime;
    final /* synthetic */ OfferingsManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfferingsManager$getOfferings$onErrorWithTracking$1(OfferingsManager offeringsManager, Date date, k kVar) {
        super(2);
        this.this$0 = offeringsManager;
        this.$startTime = date;
        this.$onError = kVar;
    }

    @Override // i3.o
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((PurchasesError) obj, (DiagnosticsTracker.CacheStatus) obj2);
        return E.f5463a;
    }

    public final void invoke(PurchasesError error, DiagnosticsTracker.CacheStatus cacheStatus) {
        r.f(error, "error");
        r.f(cacheStatus, "cacheStatus");
        this.this$0.trackGetOfferingsResultIfNeeded(this.$startTime, cacheStatus, error, null, null);
        k kVar = this.$onError;
        if (kVar != null) {
            kVar.invoke(error);
        }
    }
}
