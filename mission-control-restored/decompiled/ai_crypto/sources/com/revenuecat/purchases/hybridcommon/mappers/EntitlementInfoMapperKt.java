package com.revenuecat.purchases.hybridcommon.mappers;

import E5.o;
import E5.t;
import F5.J;
import com.revenuecat.purchases.EntitlementInfo;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import java.util.Date;
import java.util.Map;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class EntitlementInfoMapperKt {
    public static final Map<String, Object> map(EntitlementInfo entitlementInfo) {
        r.f(entitlementInfo, "<this>");
        o oVarA = t.a("identifier", entitlementInfo.getIdentifier());
        o oVarA2 = t.a("isActive", Boolean.valueOf(entitlementInfo.isActive()));
        o oVarA3 = t.a("willRenew", Boolean.valueOf(entitlementInfo.getWillRenew()));
        o oVarA4 = t.a("periodType", entitlementInfo.getPeriodType().name());
        o oVarA5 = t.a("latestPurchaseDateMillis", Long.valueOf(MappersHelpersKt.toMillis(entitlementInfo.getLatestPurchaseDate())));
        o oVarA6 = t.a("latestPurchaseDate", MappersHelpersKt.toIso8601(entitlementInfo.getLatestPurchaseDate()));
        o oVarA7 = t.a("originalPurchaseDateMillis", Long.valueOf(MappersHelpersKt.toMillis(entitlementInfo.getOriginalPurchaseDate())));
        o oVarA8 = t.a("originalPurchaseDate", MappersHelpersKt.toIso8601(entitlementInfo.getOriginalPurchaseDate()));
        Date expirationDate = entitlementInfo.getExpirationDate();
        o oVarA9 = t.a("expirationDateMillis", expirationDate != null ? Long.valueOf(MappersHelpersKt.toMillis(expirationDate)) : null);
        Date expirationDate2 = entitlementInfo.getExpirationDate();
        o oVarA10 = t.a("expirationDate", expirationDate2 != null ? MappersHelpersKt.toIso8601(expirationDate2) : null);
        o oVarA11 = t.a(ProductResponseJsonKeys.STORE, entitlementInfo.getStore().name());
        o oVarA12 = t.a("productIdentifier", entitlementInfo.getProductIdentifier());
        o oVarA13 = t.a("productPlanIdentifier", entitlementInfo.getProductPlanIdentifier());
        o oVarA14 = t.a("isSandbox", Boolean.valueOf(entitlementInfo.isSandbox()));
        Date unsubscribeDetectedAt = entitlementInfo.getUnsubscribeDetectedAt();
        o oVarA15 = t.a("unsubscribeDetectedAt", unsubscribeDetectedAt != null ? MappersHelpersKt.toIso8601(unsubscribeDetectedAt) : null);
        Date unsubscribeDetectedAt2 = entitlementInfo.getUnsubscribeDetectedAt();
        o oVarA16 = t.a("unsubscribeDetectedAtMillis", unsubscribeDetectedAt2 != null ? Long.valueOf(MappersHelpersKt.toMillis(unsubscribeDetectedAt2)) : null);
        Date billingIssueDetectedAt = entitlementInfo.getBillingIssueDetectedAt();
        o oVarA17 = t.a("billingIssueDetectedAt", billingIssueDetectedAt != null ? MappersHelpersKt.toIso8601(billingIssueDetectedAt) : null);
        Date billingIssueDetectedAt2 = entitlementInfo.getBillingIssueDetectedAt();
        return J.g(oVarA, oVarA2, oVarA3, oVarA4, oVarA5, oVarA6, oVarA7, oVarA8, oVarA9, oVarA10, oVarA11, oVarA12, oVarA13, oVarA14, oVarA15, oVarA16, oVarA17, t.a("billingIssueDetectedAtMillis", billingIssueDetectedAt2 != null ? Long.valueOf(MappersHelpersKt.toMillis(billingIssueDetectedAt2)) : null), t.a("ownershipType", entitlementInfo.getOwnershipType().name()), t.a("verification", entitlementInfo.getVerification().name()));
    }
}
