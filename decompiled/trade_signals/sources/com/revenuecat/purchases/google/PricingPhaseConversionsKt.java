package com.revenuecat.purchases.google;

import R0.C0834q;
import com.revenuecat.purchases.models.Period;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.models.PricingPhase;
import com.revenuecat.purchases.models.RecurrenceMode;
import com.revenuecat.purchases.models.RecurrenceModeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"LR0/q$c;", "Lcom/revenuecat/purchases/models/PricingPhase;", "toRevenueCatPricingPhase", "(LR0/q$c;)Lcom/revenuecat/purchases/models/PricingPhase;", "purchases_defaultsRelease"}, k = 2, mv = {1, 8, 0})
public final class PricingPhaseConversionsKt {
    public static final PricingPhase toRevenueCatPricingPhase(C0834q.c cVar) {
        AbstractC2304t.f(cVar, "<this>");
        Period.Companion companion = Period.INSTANCE;
        String billingPeriod = cVar.b();
        AbstractC2304t.e(billingPeriod, "billingPeriod");
        Period periodCreate = companion.create(billingPeriod);
        RecurrenceMode recurrenceMode = RecurrenceModeKt.toRecurrenceMode(Integer.valueOf(cVar.f()));
        Integer numValueOf = Integer.valueOf(cVar.a());
        String formattedPrice = cVar.c();
        AbstractC2304t.e(formattedPrice, "formattedPrice");
        long jD = cVar.d();
        String priceCurrencyCode = cVar.e();
        AbstractC2304t.e(priceCurrencyCode, "priceCurrencyCode");
        return new PricingPhase(periodCreate, recurrenceMode, numValueOf, new Price(formattedPrice, jD, priceCurrencyCode));
    }
}
