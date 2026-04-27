package com.revenuecat.purchases.google;

import com.android.billingclient.api.f;
import com.revenuecat.purchases.models.Period;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.models.PricingPhase;
import com.revenuecat.purchases.models.RecurrenceMode;
import com.revenuecat.purchases.models.RecurrenceModeKt;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class PricingPhaseConversionsKt {
    public static final PricingPhase toRevenueCatPricingPhase(f.c cVar) {
        r.f(cVar, "<this>");
        Period.Factory factory = Period.Factory;
        String billingPeriod = cVar.b();
        r.e(billingPeriod, "billingPeriod");
        Period periodCreate = factory.create(billingPeriod);
        RecurrenceMode recurrenceMode = RecurrenceModeKt.toRecurrenceMode(Integer.valueOf(cVar.f()));
        Integer numValueOf = Integer.valueOf(cVar.a());
        String formattedPrice = cVar.c();
        r.e(formattedPrice, "formattedPrice");
        long jD = cVar.d();
        String priceCurrencyCode = cVar.e();
        r.e(priceCurrencyCode, "priceCurrencyCode");
        return new PricingPhase(periodCreate, recurrenceMode, numValueOf, new Price(formattedPrice, jD, priceCurrencyCode));
    }
}
