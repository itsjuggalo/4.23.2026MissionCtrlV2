package com.revenuecat.purchases.common;

import W2.t;
import X2.L;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import java.util.Map;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class GooglePlatformProductId extends PlatformProductId {
    private final String basePlanId;
    private final String offerId;
    private final String productId;

    public /* synthetic */ GooglePlatformProductId(String str, String str2, String str3, int i4, AbstractC1585j abstractC1585j) {
        this(str, (i4 & 2) != 0 ? null : str2, (i4 & 4) != 0 ? null : str3);
    }

    @Override // com.revenuecat.purchases.common.PlatformProductId
    public Map<String, String> getAsMap() {
        return L.g(t.a(DiagnosticsTracker.PRODUCT_ID_KEY, getProductId()), t.a("base_plan_id", this.basePlanId), t.a("offer_id", this.offerId));
    }

    public final String getBasePlanId() {
        return this.basePlanId;
    }

    public final String getOfferId() {
        return this.offerId;
    }

    @Override // com.revenuecat.purchases.common.PlatformProductId
    public String getProductId() {
        return this.productId;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GooglePlatformProductId(String productId, String str, String str2) {
        super(productId);
        r.f(productId, "productId");
        this.productId = productId;
        this.basePlanId = str;
        this.offerId = str2;
    }
}
