package com.revenuecat.purchases.hybridcommon.mappers;

import com.revenuecat.purchases.EntitlementInfo;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import java.util.Date;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2489q;
import o5.w;
import p5.M;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u0004¨\u0006\u0005"}, d2 = {"map", "", "", "", "Lcom/revenuecat/purchases/EntitlementInfo;", "hybridcommon_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class EntitlementInfoMapperKt {
    public static final Map<String, Object> map(EntitlementInfo entitlementInfo) {
        AbstractC2304t.f(entitlementInfo, "<this>");
        C2489q c2489qA = w.a("identifier", entitlementInfo.getIdentifier());
        C2489q c2489qA2 = w.a("isActive", Boolean.valueOf(entitlementInfo.getIsActive()));
        C2489q c2489qA3 = w.a("willRenew", Boolean.valueOf(entitlementInfo.getWillRenew()));
        C2489q c2489qA4 = w.a("periodType", entitlementInfo.getPeriodType().name());
        C2489q c2489qA5 = w.a("latestPurchaseDateMillis", Long.valueOf(MappersHelpersKt.toMillis(entitlementInfo.getLatestPurchaseDate())));
        C2489q c2489qA6 = w.a("latestPurchaseDate", MappersHelpersKt.toIso8601(entitlementInfo.getLatestPurchaseDate()));
        C2489q c2489qA7 = w.a("originalPurchaseDateMillis", Long.valueOf(MappersHelpersKt.toMillis(entitlementInfo.getOriginalPurchaseDate())));
        C2489q c2489qA8 = w.a("originalPurchaseDate", MappersHelpersKt.toIso8601(entitlementInfo.getOriginalPurchaseDate()));
        Date expirationDate = entitlementInfo.getExpirationDate();
        C2489q c2489qA9 = w.a("expirationDateMillis", expirationDate != null ? Long.valueOf(MappersHelpersKt.toMillis(expirationDate)) : null);
        Date expirationDate2 = entitlementInfo.getExpirationDate();
        C2489q c2489qA10 = w.a("expirationDate", expirationDate2 != null ? MappersHelpersKt.toIso8601(expirationDate2) : null);
        C2489q c2489qA11 = w.a(ProductResponseJsonKeys.STORE, entitlementInfo.getStore().name());
        C2489q c2489qA12 = w.a("productIdentifier", entitlementInfo.getProductIdentifier());
        C2489q c2489qA13 = w.a("productPlanIdentifier", entitlementInfo.getProductPlanIdentifier());
        C2489q c2489qA14 = w.a("isSandbox", Boolean.valueOf(entitlementInfo.getIsSandbox()));
        Date unsubscribeDetectedAt = entitlementInfo.getUnsubscribeDetectedAt();
        C2489q c2489qA15 = w.a("unsubscribeDetectedAt", unsubscribeDetectedAt != null ? MappersHelpersKt.toIso8601(unsubscribeDetectedAt) : null);
        Date unsubscribeDetectedAt2 = entitlementInfo.getUnsubscribeDetectedAt();
        C2489q c2489qA16 = w.a("unsubscribeDetectedAtMillis", unsubscribeDetectedAt2 != null ? Long.valueOf(MappersHelpersKt.toMillis(unsubscribeDetectedAt2)) : null);
        Date billingIssueDetectedAt = entitlementInfo.getBillingIssueDetectedAt();
        C2489q c2489qA17 = w.a("billingIssueDetectedAt", billingIssueDetectedAt != null ? MappersHelpersKt.toIso8601(billingIssueDetectedAt) : null);
        Date billingIssueDetectedAt2 = entitlementInfo.getBillingIssueDetectedAt();
        return M.k(c2489qA, c2489qA2, c2489qA3, c2489qA4, c2489qA5, c2489qA6, c2489qA7, c2489qA8, c2489qA9, c2489qA10, c2489qA11, c2489qA12, c2489qA13, c2489qA14, c2489qA15, c2489qA16, c2489qA17, w.a("billingIssueDetectedAtMillis", billingIssueDetectedAt2 != null ? Long.valueOf(MappersHelpersKt.toMillis(billingIssueDetectedAt2)) : null), w.a("ownershipType", entitlementInfo.getOwnershipType().name()), w.a("verification", entitlementInfo.getVerification().name()));
    }
}
