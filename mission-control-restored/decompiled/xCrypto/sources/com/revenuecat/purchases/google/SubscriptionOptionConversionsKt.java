package com.revenuecat.purchases.google;

import X2.AbstractC0770q;
import X2.x;
import com.android.billingclient.api.f;
import com.revenuecat.purchases.models.GoogleInstallmentsInfo;
import com.revenuecat.purchases.models.GoogleSubscriptionOption;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class SubscriptionOptionConversionsKt {
    private static final GoogleInstallmentsInfo getInstallmentsInfo(f.a aVar) {
        return new GoogleInstallmentsInfo(aVar.a(), aVar.b());
    }

    public static final String getSubscriptionBillingPeriod(f.e eVar) {
        r.f(eVar, "<this>");
        List listA = eVar.f().a();
        r.e(listA, "this.pricingPhases.pricingPhaseList");
        f.c cVar = (f.c) x.S(listA);
        if (cVar != null) {
            return cVar.b();
        }
        return null;
    }

    public static final boolean isBasePlan(f.e eVar) {
        r.f(eVar, "<this>");
        return eVar.f().a().size() == 1;
    }

    public static final GoogleSubscriptionOption toSubscriptionOption(f.e eVar, String productId, com.android.billingclient.api.f productDetails) {
        r.f(eVar, "<this>");
        r.f(productId, "productId");
        r.f(productDetails, "productDetails");
        List<f.c> listA = eVar.f().a();
        r.e(listA, "pricingPhases.pricingPhaseList");
        ArrayList arrayList = new ArrayList(AbstractC0770q.q(listA, 10));
        for (f.c it : listA) {
            r.e(it, "it");
            arrayList.add(PricingPhaseConversionsKt.toRevenueCatPricingPhase(it));
        }
        String basePlanId = eVar.a();
        r.e(basePlanId, "basePlanId");
        String strC = eVar.c();
        List offerTags = eVar.d();
        r.e(offerTags, "offerTags");
        String offerToken = eVar.e();
        r.e(offerToken, "offerToken");
        f.a aVarB = eVar.b();
        return new GoogleSubscriptionOption(productId, basePlanId, strC, arrayList, offerTags, productDetails, offerToken, null, aVarB != null ? getInstallmentsInfo(aVarB) : null);
    }
}
