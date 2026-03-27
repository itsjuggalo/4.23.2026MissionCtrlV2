package com.revenuecat.purchases.models;

import F5.AbstractC0556n;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.ProductType;
import java.util.List;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
final class TestSubscriptionOption implements SubscriptionOption {
    private final String basePlanId;
    private final InstallmentsInfo installmentsInfo;
    private final PresentedOfferingContext presentedOfferingContext;
    private final List<PricingPhase> pricingPhases;
    private final String productIdentifier;
    private final List<String> tags;

    public TestSubscriptionOption(String productIdentifier, List<PricingPhase> pricingPhases, String basePlanId, List<String> tags, PresentedOfferingContext presentedOfferingContext, InstallmentsInfo installmentsInfo) {
        r.f(productIdentifier, "productIdentifier");
        r.f(pricingPhases, "pricingPhases");
        r.f(basePlanId, "basePlanId");
        r.f(tags, "tags");
        r.f(presentedOfferingContext, "presentedOfferingContext");
        this.productIdentifier = productIdentifier;
        this.pricingPhases = pricingPhases;
        this.basePlanId = basePlanId;
        this.tags = tags;
        this.presentedOfferingContext = presentedOfferingContext;
        this.installmentsInfo = installmentsInfo;
    }

    public final String getBasePlanId() {
        return this.basePlanId;
    }

    @Override // com.revenuecat.purchases.models.SubscriptionOption
    public String getId() {
        if (getPricingPhases().size() == 1) {
            return this.basePlanId;
        }
        return this.basePlanId + ":testOfferId";
    }

    @Override // com.revenuecat.purchases.models.SubscriptionOption
    public InstallmentsInfo getInstallmentsInfo() {
        return this.installmentsInfo;
    }

    @Override // com.revenuecat.purchases.models.SubscriptionOption
    public PresentedOfferingContext getPresentedOfferingContext() {
        return this.presentedOfferingContext;
    }

    @Override // com.revenuecat.purchases.models.SubscriptionOption
    public String getPresentedOfferingIdentifier() {
        return getPresentedOfferingContext().getOfferingIdentifier();
    }

    @Override // com.revenuecat.purchases.models.SubscriptionOption
    public List<PricingPhase> getPricingPhases() {
        return this.pricingPhases;
    }

    public final String getProductIdentifier() {
        return this.productIdentifier;
    }

    @Override // com.revenuecat.purchases.models.SubscriptionOption
    public PurchasingData getPurchasingData() {
        return new PurchasingData() { // from class: com.revenuecat.purchases.models.TestSubscriptionOption$purchasingData$1
            @Override // com.revenuecat.purchases.models.PurchasingData
            public String getProductId() {
                return this.this$0.getProductIdentifier();
            }

            @Override // com.revenuecat.purchases.models.PurchasingData
            public ProductType getProductType() {
                return ProductType.SUBS;
            }
        };
    }

    @Override // com.revenuecat.purchases.models.SubscriptionOption
    public List<String> getTags() {
        return this.tags;
    }

    public /* synthetic */ TestSubscriptionOption(String str, List list, String str2, List list2, PresentedOfferingContext presentedOfferingContext, InstallmentsInfo installmentsInfo, int i7, AbstractC2148j abstractC2148j) {
        this(str, list, (i7 & 4) != 0 ? "testBasePlanId" : str2, (i7 & 8) != 0 ? AbstractC0556n.g() : list2, (i7 & 16) != 0 ? new PresentedOfferingContext("offering") : presentedOfferingContext, (i7 & 32) != 0 ? null : installmentsInfo);
    }
}
