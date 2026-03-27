package com.revenuecat.purchases.models;

import com.android.billingclient.api.f;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.models.GooglePurchasingData;
import java.util.List;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;
import r3.AbstractC1753A;

/* JADX INFO: loaded from: classes3.dex */
public final class GoogleSubscriptionOption implements SubscriptionOption {
    private final String basePlanId;
    private final GoogleInstallmentsInfo installmentsInfo;
    private final String offerId;
    private final String offerToken;
    private final PresentedOfferingContext presentedOfferingContext;
    private final List<PricingPhase> pricingPhases;
    private final f productDetails;
    private final String productId;
    private final List<String> tags;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GoogleSubscriptionOption(String productId, String basePlanId, String str, List<PricingPhase> pricingPhases, List<String> tags, f productDetails, String offerToken) {
        this(productId, basePlanId, str, pricingPhases, tags, productDetails, offerToken, null, null, 384, null);
        r.f(productId, "productId");
        r.f(basePlanId, "basePlanId");
        r.f(pricingPhases, "pricingPhases");
        r.f(tags, "tags");
        r.f(productDetails, "productDetails");
        r.f(offerToken, "offerToken");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GoogleSubscriptionOption copy$default(GoogleSubscriptionOption googleSubscriptionOption, String str, String str2, String str3, List list, List list2, f fVar, String str4, PresentedOfferingContext presentedOfferingContext, GoogleInstallmentsInfo googleInstallmentsInfo, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = googleSubscriptionOption.productId;
        }
        if ((i4 & 2) != 0) {
            str2 = googleSubscriptionOption.basePlanId;
        }
        if ((i4 & 4) != 0) {
            str3 = googleSubscriptionOption.offerId;
        }
        if ((i4 & 8) != 0) {
            list = googleSubscriptionOption.pricingPhases;
        }
        if ((i4 & 16) != 0) {
            list2 = googleSubscriptionOption.tags;
        }
        if ((i4 & 32) != 0) {
            fVar = googleSubscriptionOption.productDetails;
        }
        if ((i4 & 64) != 0) {
            str4 = googleSubscriptionOption.offerToken;
        }
        if ((i4 & UserMetadata.MAX_ROLLOUT_ASSIGNMENTS) != 0) {
            presentedOfferingContext = googleSubscriptionOption.presentedOfferingContext;
        }
        if ((i4 & 256) != 0) {
            googleInstallmentsInfo = googleSubscriptionOption.installmentsInfo;
        }
        PresentedOfferingContext presentedOfferingContext2 = presentedOfferingContext;
        GoogleInstallmentsInfo googleInstallmentsInfo2 = googleInstallmentsInfo;
        f fVar2 = fVar;
        String str5 = str4;
        List list3 = list2;
        String str6 = str3;
        return googleSubscriptionOption.copy(str, str2, str6, list, list3, fVar2, str5, presentedOfferingContext2, googleInstallmentsInfo2);
    }

    public static /* synthetic */ void getPresentedOfferingIdentifier$annotations() {
    }

    public final String component1() {
        return this.productId;
    }

    public final String component2() {
        return this.basePlanId;
    }

    public final String component3() {
        return this.offerId;
    }

    public final List<PricingPhase> component4() {
        return this.pricingPhases;
    }

    public final List<String> component5() {
        return this.tags;
    }

    public final f component6() {
        return this.productDetails;
    }

    public final String component7() {
        return this.offerToken;
    }

    public final PresentedOfferingContext component8() {
        return this.presentedOfferingContext;
    }

    public final GoogleInstallmentsInfo component9() {
        return this.installmentsInfo;
    }

    public final GoogleSubscriptionOption copy(String productId, String basePlanId, String str, List<PricingPhase> pricingPhases, List<String> tags, f productDetails, String offerToken, PresentedOfferingContext presentedOfferingContext, GoogleInstallmentsInfo googleInstallmentsInfo) {
        r.f(productId, "productId");
        r.f(basePlanId, "basePlanId");
        r.f(pricingPhases, "pricingPhases");
        r.f(tags, "tags");
        r.f(productDetails, "productDetails");
        r.f(offerToken, "offerToken");
        return new GoogleSubscriptionOption(productId, basePlanId, str, pricingPhases, tags, productDetails, offerToken, presentedOfferingContext, googleInstallmentsInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GoogleSubscriptionOption)) {
            return false;
        }
        GoogleSubscriptionOption googleSubscriptionOption = (GoogleSubscriptionOption) obj;
        return r.b(this.productId, googleSubscriptionOption.productId) && r.b(this.basePlanId, googleSubscriptionOption.basePlanId) && r.b(this.offerId, googleSubscriptionOption.offerId) && r.b(this.pricingPhases, googleSubscriptionOption.pricingPhases) && r.b(this.tags, googleSubscriptionOption.tags) && r.b(this.productDetails, googleSubscriptionOption.productDetails) && r.b(this.offerToken, googleSubscriptionOption.offerToken) && r.b(this.presentedOfferingContext, googleSubscriptionOption.presentedOfferingContext) && r.b(this.installmentsInfo, googleSubscriptionOption.installmentsInfo);
    }

    public final String getBasePlanId() {
        return this.basePlanId;
    }

    @Override // com.revenuecat.purchases.models.SubscriptionOption
    public String getId() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.basePlanId);
        String str2 = this.offerId;
        if (str2 == null || AbstractC1753A.U(str2)) {
            str = "";
        } else {
            str = ':' + this.offerId;
        }
        sb.append(str);
        return sb.toString();
    }

    public final String getOfferId() {
        return this.offerId;
    }

    public final String getOfferToken() {
        return this.offerToken;
    }

    @Override // com.revenuecat.purchases.models.SubscriptionOption
    public PresentedOfferingContext getPresentedOfferingContext() {
        return this.presentedOfferingContext;
    }

    @Override // com.revenuecat.purchases.models.SubscriptionOption
    public String getPresentedOfferingIdentifier() {
        PresentedOfferingContext presentedOfferingContext = getPresentedOfferingContext();
        if (presentedOfferingContext != null) {
            return presentedOfferingContext.getOfferingIdentifier();
        }
        return null;
    }

    @Override // com.revenuecat.purchases.models.SubscriptionOption
    public List<PricingPhase> getPricingPhases() {
        return this.pricingPhases;
    }

    public final f getProductDetails() {
        return this.productDetails;
    }

    public final String getProductId() {
        return this.productId;
    }

    @Override // com.revenuecat.purchases.models.SubscriptionOption
    public PurchasingData getPurchasingData() {
        return new GooglePurchasingData.Subscription(this.productId, getId(), this.productDetails, this.offerToken);
    }

    @Override // com.revenuecat.purchases.models.SubscriptionOption
    public List<String> getTags() {
        return this.tags;
    }

    public int hashCode() {
        int iHashCode = ((this.productId.hashCode() * 31) + this.basePlanId.hashCode()) * 31;
        String str = this.offerId;
        int iHashCode2 = (((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.pricingPhases.hashCode()) * 31) + this.tags.hashCode()) * 31) + this.productDetails.hashCode()) * 31) + this.offerToken.hashCode()) * 31;
        PresentedOfferingContext presentedOfferingContext = this.presentedOfferingContext;
        int iHashCode3 = (iHashCode2 + (presentedOfferingContext == null ? 0 : presentedOfferingContext.hashCode())) * 31;
        GoogleInstallmentsInfo googleInstallmentsInfo = this.installmentsInfo;
        return iHashCode3 + (googleInstallmentsInfo != null ? googleInstallmentsInfo.hashCode() : 0);
    }

    public String toString() {
        return "GoogleSubscriptionOption(productId=" + this.productId + ", basePlanId=" + this.basePlanId + ", offerId=" + this.offerId + ", pricingPhases=" + this.pricingPhases + ", tags=" + this.tags + ", productDetails=" + this.productDetails + ", offerToken=" + this.offerToken + ", presentedOfferingContext=" + this.presentedOfferingContext + ", installmentsInfo=" + this.installmentsInfo + ')';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GoogleSubscriptionOption(String productId, String basePlanId, String str, List<PricingPhase> pricingPhases, List<String> tags, f productDetails, String offerToken, PresentedOfferingContext presentedOfferingContext) {
        this(productId, basePlanId, str, pricingPhases, tags, productDetails, offerToken, presentedOfferingContext, null, 256, null);
        r.f(productId, "productId");
        r.f(basePlanId, "basePlanId");
        r.f(pricingPhases, "pricingPhases");
        r.f(tags, "tags");
        r.f(productDetails, "productDetails");
        r.f(offerToken, "offerToken");
    }

    @Override // com.revenuecat.purchases.models.SubscriptionOption
    public GoogleInstallmentsInfo getInstallmentsInfo() {
        return this.installmentsInfo;
    }

    public GoogleSubscriptionOption(String productId, String basePlanId, String str, List<PricingPhase> pricingPhases, List<String> tags, f productDetails, String offerToken, PresentedOfferingContext presentedOfferingContext, GoogleInstallmentsInfo googleInstallmentsInfo) {
        r.f(productId, "productId");
        r.f(basePlanId, "basePlanId");
        r.f(pricingPhases, "pricingPhases");
        r.f(tags, "tags");
        r.f(productDetails, "productDetails");
        r.f(offerToken, "offerToken");
        this.productId = productId;
        this.basePlanId = basePlanId;
        this.offerId = str;
        this.pricingPhases = pricingPhases;
        this.tags = tags;
        this.productDetails = productDetails;
        this.offerToken = offerToken;
        this.presentedOfferingContext = presentedOfferingContext;
        this.installmentsInfo = googleInstallmentsInfo;
    }

    public /* synthetic */ GoogleSubscriptionOption(String str, String str2, String str3, List list, List list2, f fVar, String str4, PresentedOfferingContext presentedOfferingContext, GoogleInstallmentsInfo googleInstallmentsInfo, int i4, AbstractC1585j abstractC1585j) {
        this(str, str2, str3, list, list2, fVar, str4, (i4 & UserMetadata.MAX_ROLLOUT_ASSIGNMENTS) != 0 ? null : presentedOfferingContext, (i4 & 256) != 0 ? null : googleInstallmentsInfo);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GoogleSubscriptionOption(String productId, String basePlanId, String str, List<PricingPhase> pricingPhases, List<String> tags, f productDetails, String offerToken, String presentedOfferingId) {
        this(productId, basePlanId, str, pricingPhases, tags, productDetails, offerToken, new PresentedOfferingContext(presentedOfferingId), null, 256, null);
        r.f(productId, "productId");
        r.f(basePlanId, "basePlanId");
        r.f(pricingPhases, "pricingPhases");
        r.f(tags, "tags");
        r.f(productDetails, "productDetails");
        r.f(offerToken, "offerToken");
        r.f(presentedOfferingId, "presentedOfferingId");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GoogleSubscriptionOption(GoogleSubscriptionOption subscriptionOption, PresentedOfferingContext presentedOfferingContext) {
        this(subscriptionOption.productId, subscriptionOption.basePlanId, subscriptionOption.offerId, subscriptionOption.getPricingPhases(), subscriptionOption.getTags(), subscriptionOption.productDetails, subscriptionOption.offerToken, presentedOfferingContext, subscriptionOption.getInstallmentsInfo());
        r.f(subscriptionOption, "subscriptionOption");
    }
}
