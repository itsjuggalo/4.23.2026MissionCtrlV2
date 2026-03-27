package com.revenuecat.purchases.hybridcommon.mappers;

import W2.o;
import W2.t;
import X2.L;
import com.amazon.a.a.o.b;
import com.revenuecat.purchases.SubscriptionInfo;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import java.util.Date;
import java.util.Map;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class SubscriptionInfoMapperKt {
    public static final Map<String, Object> map(SubscriptionInfo subscriptionInfo) {
        r.f(subscriptionInfo, "<this>");
        o oVarA = t.a("productIdentifier", subscriptionInfo.getProductIdentifier());
        o oVarA2 = t.a(b.f8743Q, MappersHelpersKt.toIso8601(subscriptionInfo.getPurchaseDate()));
        Date originalPurchaseDate = subscriptionInfo.getOriginalPurchaseDate();
        o oVarA3 = t.a("originalPurchaseDate", originalPurchaseDate != null ? MappersHelpersKt.toIso8601(originalPurchaseDate) : null);
        Date expiresDate = subscriptionInfo.getExpiresDate();
        o oVarA4 = t.a("expiresDate", expiresDate != null ? MappersHelpersKt.toIso8601(expiresDate) : null);
        o oVarA5 = t.a(ProductResponseJsonKeys.STORE, subscriptionInfo.getStore().name());
        Date unsubscribeDetectedAt = subscriptionInfo.getUnsubscribeDetectedAt();
        o oVarA6 = t.a("unsubscribeDetectedAt", unsubscribeDetectedAt != null ? MappersHelpersKt.toIso8601(unsubscribeDetectedAt) : null);
        o oVarA7 = t.a("isSandbox", Boolean.valueOf(subscriptionInfo.isSandbox()));
        Date billingIssuesDetectedAt = subscriptionInfo.getBillingIssuesDetectedAt();
        o oVarA8 = t.a("billingIssuesDetectedAt", billingIssuesDetectedAt != null ? MappersHelpersKt.toIso8601(billingIssuesDetectedAt) : null);
        Date gracePeriodExpiresDate = subscriptionInfo.getGracePeriodExpiresDate();
        o oVarA9 = t.a("gracePeriodExpiresDate", gracePeriodExpiresDate != null ? MappersHelpersKt.toIso8601(gracePeriodExpiresDate) : null);
        o oVarA10 = t.a("ownershipType", subscriptionInfo.getOwnershipType().name());
        o oVarA11 = t.a("periodType", subscriptionInfo.getPeriodType().name());
        Date refundedAt = subscriptionInfo.getRefundedAt();
        return L.g(oVarA, oVarA2, oVarA3, oVarA4, oVarA5, oVarA6, oVarA7, oVarA8, oVarA9, oVarA10, oVarA11, t.a("refundedAt", refundedAt != null ? MappersHelpersKt.toIso8601(refundedAt) : null), t.a("storeTransactionId", subscriptionInfo.getStoreTransactionId()), t.a("isActive", Boolean.valueOf(subscriptionInfo.isActive())), t.a("willRenew", Boolean.valueOf(subscriptionInfo.getWillRenew())));
    }
}
