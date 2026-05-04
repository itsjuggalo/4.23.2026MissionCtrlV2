package com.revenuecat.purchases.hybridcommon.mappers;

import cd.q;
import cd.w;
import com.revenuecat.purchases.EntitlementInfo;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import dd.o0;
import java.util.Date;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u0004¨\u0006\u0005"}, d2 = {"map", "", "", "", "Lcom/revenuecat/purchases/EntitlementInfo;", "hybridcommon_bc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class EntitlementInfoMapperKt {
    public static final Map<String, Object> map(EntitlementInfo entitlementInfo) {
        t.f(entitlementInfo, "<this>");
        q qVarA = w.a("identifier", entitlementInfo.getIdentifier());
        q qVarA2 = w.a("isActive", Boolean.valueOf(entitlementInfo.getIsActive()));
        q qVarA3 = w.a("willRenew", Boolean.valueOf(entitlementInfo.getWillRenew()));
        q qVarA4 = w.a("periodType", entitlementInfo.getPeriodType().name());
        q qVarA5 = w.a("latestPurchaseDateMillis", Long.valueOf(MappersHelpersKt.toMillis(entitlementInfo.getLatestPurchaseDate())));
        q qVarA6 = w.a("latestPurchaseDate", MappersHelpersKt.toIso8601(entitlementInfo.getLatestPurchaseDate()));
        q qVarA7 = w.a("originalPurchaseDateMillis", Long.valueOf(MappersHelpersKt.toMillis(entitlementInfo.getOriginalPurchaseDate())));
        q qVarA8 = w.a("originalPurchaseDate", MappersHelpersKt.toIso8601(entitlementInfo.getOriginalPurchaseDate()));
        Date expirationDate = entitlementInfo.getExpirationDate();
        q qVarA9 = w.a("expirationDateMillis", expirationDate != null ? Long.valueOf(MappersHelpersKt.toMillis(expirationDate)) : null);
        Date expirationDate2 = entitlementInfo.getExpirationDate();
        q qVarA10 = w.a("expirationDate", expirationDate2 != null ? MappersHelpersKt.toIso8601(expirationDate2) : null);
        q qVarA11 = w.a(ProductResponseJsonKeys.STORE, entitlementInfo.getStore().name());
        q qVarA12 = w.a("productIdentifier", entitlementInfo.getProductIdentifier());
        q qVarA13 = w.a("productPlanIdentifier", entitlementInfo.getProductPlanIdentifier());
        q qVarA14 = w.a("isSandbox", Boolean.valueOf(entitlementInfo.getIsSandbox()));
        Date unsubscribeDetectedAt = entitlementInfo.getUnsubscribeDetectedAt();
        q qVarA15 = w.a("unsubscribeDetectedAt", unsubscribeDetectedAt != null ? MappersHelpersKt.toIso8601(unsubscribeDetectedAt) : null);
        Date unsubscribeDetectedAt2 = entitlementInfo.getUnsubscribeDetectedAt();
        q qVarA16 = w.a("unsubscribeDetectedAtMillis", unsubscribeDetectedAt2 != null ? Long.valueOf(MappersHelpersKt.toMillis(unsubscribeDetectedAt2)) : null);
        Date billingIssueDetectedAt = entitlementInfo.getBillingIssueDetectedAt();
        q qVarA17 = w.a("billingIssueDetectedAt", billingIssueDetectedAt != null ? MappersHelpersKt.toIso8601(billingIssueDetectedAt) : null);
        Date billingIssueDetectedAt2 = entitlementInfo.getBillingIssueDetectedAt();
        return o0.l(qVarA, qVarA2, qVarA3, qVarA4, qVarA5, qVarA6, qVarA7, qVarA8, qVarA9, qVarA10, qVarA11, qVarA12, qVarA13, qVarA14, qVarA15, qVarA16, qVarA17, w.a("billingIssueDetectedAtMillis", billingIssueDetectedAt2 != null ? Long.valueOf(MappersHelpersKt.toMillis(billingIssueDetectedAt2)) : null), w.a("ownershipType", entitlementInfo.getOwnershipType().name()), w.a("verification", entitlementInfo.getVerification().name()));
    }
}
