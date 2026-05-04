package com.revenuecat.purchases.google;

import com.revenuecat.purchases.models.GoogleInstallmentsInfo;
import com.revenuecat.purchases.models.GoogleSubscriptionOption;
import d3.p;
import dd.a0;
import dd.s;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a#\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\"\u001a\u0010\n\u001a\u0004\u0018\u00010\u0001*\u00020\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t\"\u0018\u0010\f\u001a\u00020\u000b*\u00020\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r\"\u0018\u0010\u0012\u001a\u00020\u000f*\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Ld3/p$e;", "", "productId", "Ld3/p;", "productDetails", "Lcom/revenuecat/purchases/models/GoogleSubscriptionOption;", "toSubscriptionOption", "(Ld3/p$e;Ljava/lang/String;Ld3/p;)Lcom/revenuecat/purchases/models/GoogleSubscriptionOption;", "getSubscriptionBillingPeriod", "(Ld3/p$e;)Ljava/lang/String;", "subscriptionBillingPeriod", "", "isBasePlan", "(Ld3/p$e;)Z", "Ld3/p$a;", "Lcom/revenuecat/purchases/models/GoogleInstallmentsInfo;", "getInstallmentsInfo", "(Ld3/p$a;)Lcom/revenuecat/purchases/models/GoogleInstallmentsInfo;", "installmentsInfo", "purchases_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SubscriptionOptionConversionsKt {
    private static final GoogleInstallmentsInfo getInstallmentsInfo(p.a aVar) {
        return new GoogleInstallmentsInfo(aVar.a(), aVar.b());
    }

    public static final String getSubscriptionBillingPeriod(p.e eVar) {
        t.f(eVar, "<this>");
        List listA = eVar.f().a();
        t.e(listA, "this.pricingPhases.pricingPhaseList");
        p.c cVar = (p.c) a0.m0(listA);
        if (cVar != null) {
            return cVar.b();
        }
        return null;
    }

    public static final boolean isBasePlan(p.e eVar) {
        t.f(eVar, "<this>");
        return eVar.f().a().size() == 1;
    }

    public static final GoogleSubscriptionOption toSubscriptionOption(p.e eVar, String productId, p productDetails) {
        t.f(eVar, "<this>");
        t.f(productId, "productId");
        t.f(productDetails, "productDetails");
        List<p.c> listA = eVar.f().a();
        t.e(listA, "pricingPhases.pricingPhaseList");
        ArrayList arrayList = new ArrayList(s.u(listA, 10));
        for (p.c it : listA) {
            t.e(it, "it");
            arrayList.add(PricingPhaseConversionsKt.toRevenueCatPricingPhase(it));
        }
        String basePlanId = eVar.a();
        t.e(basePlanId, "basePlanId");
        String strC = eVar.c();
        List offerTags = eVar.d();
        t.e(offerTags, "offerTags");
        String offerToken = eVar.e();
        t.e(offerToken, "offerToken");
        p.a aVarB = eVar.b();
        return new GoogleSubscriptionOption(productId, basePlanId, strC, arrayList, offerTags, productDetails, offerToken, null, aVarB != null ? getInstallmentsInfo(aVarB) : null);
    }
}
