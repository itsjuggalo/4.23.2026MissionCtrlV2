package com.revenuecat.purchases.models;

import X2.x;
import com.android.billingclient.api.f;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.models.GooglePurchasingData;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class GoogleStoreProduct implements StoreProduct {
    private final String basePlanId;
    private final SubscriptionOption defaultOption;
    private final String description;
    private final String name;
    private final Period period;
    private final PresentedOfferingContext presentedOfferingContext;
    private final String presentedOfferingIdentifier;
    private final Price price;
    private final f productDetails;
    private final String productId;
    private final SubscriptionOptions subscriptionOptions;
    private final String title;
    private final ProductType type;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GoogleStoreProduct(String productId, String str, ProductType type, Price price, String name, String title, String description, Period period, SubscriptionOptions subscriptionOptions, SubscriptionOption subscriptionOption, f productDetails) {
        this(productId, str, type, price, name, title, description, period, subscriptionOptions, subscriptionOption, productDetails, null, null, 6144, null);
        r.f(productId, "productId");
        r.f(type, "type");
        r.f(price, "price");
        r.f(name, "name");
        r.f(title, "title");
        r.f(description, "description");
        r.f(productDetails, "productDetails");
    }

    public static /* synthetic */ GoogleStoreProduct copy$default(GoogleStoreProduct googleStoreProduct, String str, String str2, ProductType productType, Price price, String str3, String str4, String str5, Period period, SubscriptionOptions subscriptionOptions, SubscriptionOption subscriptionOption, f fVar, String str6, PresentedOfferingContext presentedOfferingContext, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = googleStoreProduct.productId;
        }
        return googleStoreProduct.copy(str, (i4 & 2) != 0 ? googleStoreProduct.basePlanId : str2, (i4 & 4) != 0 ? googleStoreProduct.type : productType, (i4 & 8) != 0 ? googleStoreProduct.price : price, (i4 & 16) != 0 ? googleStoreProduct.name : str3, (i4 & 32) != 0 ? googleStoreProduct.title : str4, (i4 & 64) != 0 ? googleStoreProduct.description : str5, (i4 & UserMetadata.MAX_ROLLOUT_ASSIGNMENTS) != 0 ? googleStoreProduct.period : period, (i4 & 256) != 0 ? googleStoreProduct.subscriptionOptions : subscriptionOptions, (i4 & 512) != 0 ? googleStoreProduct.defaultOption : subscriptionOption, (i4 & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0 ? googleStoreProduct.productDetails : fVar, (i4 & 2048) != 0 ? googleStoreProduct.presentedOfferingIdentifier : str6, (i4 & 4096) != 0 ? googleStoreProduct.presentedOfferingContext : presentedOfferingContext);
    }

    public static /* synthetic */ void getPresentedOfferingIdentifier$annotations() {
    }

    public static /* synthetic */ void getSku$annotations() {
    }

    public final String component1() {
        return this.productId;
    }

    public final SubscriptionOption component10() {
        return this.defaultOption;
    }

    public final f component11() {
        return this.productDetails;
    }

    public final String component12() {
        return this.presentedOfferingIdentifier;
    }

    public final PresentedOfferingContext component13() {
        return this.presentedOfferingContext;
    }

    public final String component2() {
        return this.basePlanId;
    }

    public final ProductType component3() {
        return this.type;
    }

    public final Price component4() {
        return this.price;
    }

    public final String component5() {
        return this.name;
    }

    public final String component6() {
        return this.title;
    }

    public final String component7() {
        return this.description;
    }

    public final Period component8() {
        return this.period;
    }

    public final SubscriptionOptions component9() {
        return this.subscriptionOptions;
    }

    public final GoogleStoreProduct copy(String productId, String str, ProductType type, Price price, String name, String title, String description, Period period, SubscriptionOptions subscriptionOptions, SubscriptionOption subscriptionOption, f productDetails, String str2, PresentedOfferingContext presentedOfferingContext) {
        r.f(productId, "productId");
        r.f(type, "type");
        r.f(price, "price");
        r.f(name, "name");
        r.f(title, "title");
        r.f(description, "description");
        r.f(productDetails, "productDetails");
        return new GoogleStoreProduct(productId, str, type, price, name, title, description, period, subscriptionOptions, subscriptionOption, productDetails, str2, presentedOfferingContext);
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public StoreProduct copyWithOfferingId(String offeringId) {
        String str;
        PresentedOfferingContext presentedOfferingContext;
        r.f(offeringId, "offeringId");
        PresentedOfferingContext presentedOfferingContext2 = getPresentedOfferingContext();
        if (presentedOfferingContext2 != null) {
            str = offeringId;
            presentedOfferingContext = PresentedOfferingContext.copy$default(presentedOfferingContext2, str, null, null, 6, null);
            if (presentedOfferingContext == null) {
            }
            return copyWithPresentedOfferingContext(presentedOfferingContext);
        }
        str = offeringId;
        presentedOfferingContext = new PresentedOfferingContext(str);
        return copyWithPresentedOfferingContext(presentedOfferingContext);
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public StoreProduct copyWithPresentedOfferingContext(PresentedOfferingContext presentedOfferingContext) {
        ArrayList arrayList;
        SubscriptionOptions subscriptionOptions = getSubscriptionOptions();
        if (subscriptionOptions != null) {
            arrayList = new ArrayList();
            for (SubscriptionOption subscriptionOption : subscriptionOptions) {
                GoogleSubscriptionOption googleSubscriptionOption = subscriptionOption instanceof GoogleSubscriptionOption ? (GoogleSubscriptionOption) subscriptionOption : null;
                GoogleSubscriptionOption googleSubscriptionOption2 = googleSubscriptionOption != null ? new GoogleSubscriptionOption(googleSubscriptionOption, presentedOfferingContext) : null;
                if (googleSubscriptionOption2 != null) {
                    arrayList.add(googleSubscriptionOption2);
                }
            }
        } else {
            arrayList = null;
        }
        SubscriptionOption defaultOption = getDefaultOption();
        GoogleSubscriptionOption googleSubscriptionOption3 = defaultOption instanceof GoogleSubscriptionOption ? (GoogleSubscriptionOption) defaultOption : null;
        return new GoogleStoreProduct(this, googleSubscriptionOption3 != null ? new GoogleSubscriptionOption(googleSubscriptionOption3, presentedOfferingContext) : null, arrayList != null ? new SubscriptionOptions(arrayList) : null, presentedOfferingContext);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GoogleStoreProduct)) {
            return false;
        }
        GoogleStoreProduct googleStoreProduct = (GoogleStoreProduct) obj;
        return r.b(this.productId, googleStoreProduct.productId) && r.b(this.basePlanId, googleStoreProduct.basePlanId) && this.type == googleStoreProduct.type && r.b(this.price, googleStoreProduct.price) && r.b(this.name, googleStoreProduct.name) && r.b(this.title, googleStoreProduct.title) && r.b(this.description, googleStoreProduct.description) && r.b(this.period, googleStoreProduct.period) && r.b(this.subscriptionOptions, googleStoreProduct.subscriptionOptions) && r.b(this.defaultOption, googleStoreProduct.defaultOption) && r.b(this.productDetails, googleStoreProduct.productDetails) && r.b(this.presentedOfferingIdentifier, googleStoreProduct.presentedOfferingIdentifier) && r.b(this.presentedOfferingContext, googleStoreProduct.presentedOfferingContext);
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public String formattedPricePerMonth(Locale locale) {
        SubscriptionOption basePlan;
        List<PricingPhase> pricingPhases;
        PricingPhase pricingPhase;
        r.f(locale, "locale");
        SubscriptionOptions subscriptionOptions = getSubscriptionOptions();
        if (subscriptionOptions == null || (basePlan = subscriptionOptions.getBasePlan()) == null || (pricingPhases = basePlan.getPricingPhases()) == null || (pricingPhase = (PricingPhase) x.R(pricingPhases)) == null) {
            return null;
        }
        return pricingPhase.formattedPriceInMonths(locale);
    }

    public final String getBasePlanId() {
        return this.basePlanId;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public SubscriptionOption getDefaultOption() {
        return this.defaultOption;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public String getDescription() {
        return this.description;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public String getId() {
        if (this.basePlanId != null) {
            String str = this.productId + ':' + this.basePlanId;
            if (str != null) {
                return str;
            }
        }
        return this.productId;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public String getName() {
        return this.name;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public Period getPeriod() {
        return this.period;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public PresentedOfferingContext getPresentedOfferingContext() {
        return this.presentedOfferingContext;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public String getPresentedOfferingIdentifier() {
        return this.presentedOfferingIdentifier;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public Price getPrice() {
        return this.price;
    }

    public final f getProductDetails() {
        return this.productDetails;
    }

    public final String getProductId() {
        return this.productId;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public PurchasingData getPurchasingData() {
        return (getType() != ProductType.SUBS || getDefaultOption() == null) ? new GooglePurchasingData.InAppProduct(getId(), this.productDetails) : getDefaultOption().getPurchasingData();
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public String getSku() {
        return this.productId;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public SubscriptionOptions getSubscriptionOptions() {
        return this.subscriptionOptions;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public String getTitle() {
        return this.title;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public ProductType getType() {
        return this.type;
    }

    public int hashCode() {
        int iHashCode = this.productId.hashCode() * 31;
        String str = this.basePlanId;
        int iHashCode2 = (((((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.type.hashCode()) * 31) + this.price.hashCode()) * 31) + this.name.hashCode()) * 31) + this.title.hashCode()) * 31) + this.description.hashCode()) * 31;
        Period period = this.period;
        int iHashCode3 = (iHashCode2 + (period == null ? 0 : period.hashCode())) * 31;
        SubscriptionOptions subscriptionOptions = this.subscriptionOptions;
        int iHashCode4 = (iHashCode3 + (subscriptionOptions == null ? 0 : subscriptionOptions.hashCode())) * 31;
        SubscriptionOption subscriptionOption = this.defaultOption;
        int iHashCode5 = (((iHashCode4 + (subscriptionOption == null ? 0 : subscriptionOption.hashCode())) * 31) + this.productDetails.hashCode()) * 31;
        String str2 = this.presentedOfferingIdentifier;
        int iHashCode6 = (iHashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        PresentedOfferingContext presentedOfferingContext = this.presentedOfferingContext;
        return iHashCode6 + (presentedOfferingContext != null ? presentedOfferingContext.hashCode() : 0);
    }

    public String toString() {
        return "GoogleStoreProduct(productId=" + this.productId + ", basePlanId=" + this.basePlanId + ", type=" + this.type + ", price=" + this.price + ", name=" + this.name + ", title=" + this.title + ", description=" + this.description + ", period=" + this.period + ", subscriptionOptions=" + this.subscriptionOptions + ", defaultOption=" + this.defaultOption + ", productDetails=" + this.productDetails + ", presentedOfferingIdentifier=" + this.presentedOfferingIdentifier + ", presentedOfferingContext=" + this.presentedOfferingContext + ')';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GoogleStoreProduct(String productId, String str, ProductType type, Price price, String name, String title, String description, Period period, SubscriptionOptions subscriptionOptions, SubscriptionOption subscriptionOption, f productDetails, String str2) {
        this(productId, str, type, price, name, title, description, period, subscriptionOptions, subscriptionOption, productDetails, str2, null, 4096, null);
        r.f(productId, "productId");
        r.f(type, "type");
        r.f(price, "price");
        r.f(name, "name");
        r.f(title, "title");
        r.f(description, "description");
        r.f(productDetails, "productDetails");
    }

    public GoogleStoreProduct(String productId, String str, ProductType type, Price price, String name, String title, String description, Period period, SubscriptionOptions subscriptionOptions, SubscriptionOption subscriptionOption, f productDetails, String str2, PresentedOfferingContext presentedOfferingContext) {
        r.f(productId, "productId");
        r.f(type, "type");
        r.f(price, "price");
        r.f(name, "name");
        r.f(title, "title");
        r.f(description, "description");
        r.f(productDetails, "productDetails");
        this.productId = productId;
        this.basePlanId = str;
        this.type = type;
        this.price = price;
        this.name = name;
        this.title = title;
        this.description = description;
        this.period = period;
        this.subscriptionOptions = subscriptionOptions;
        this.defaultOption = subscriptionOption;
        this.productDetails = productDetails;
        this.presentedOfferingIdentifier = str2;
        this.presentedOfferingContext = presentedOfferingContext;
    }

    public /* synthetic */ GoogleStoreProduct(String str, String str2, ProductType productType, Price price, String str3, String str4, String str5, Period period, SubscriptionOptions subscriptionOptions, SubscriptionOption subscriptionOption, f fVar, String str6, PresentedOfferingContext presentedOfferingContext, int i4, AbstractC1585j abstractC1585j) {
        this(str, str2, productType, price, str3, str4, str5, period, subscriptionOptions, subscriptionOption, fVar, (i4 & 2048) != 0 ? null : str6, (i4 & 4096) != 0 ? null : presentedOfferingContext);
    }

    public /* synthetic */ GoogleStoreProduct(String str, String str2, ProductType productType, Price price, String str3, String str4, String str5, Period period, SubscriptionOptions subscriptionOptions, SubscriptionOption subscriptionOption, f fVar, PresentedOfferingContext presentedOfferingContext, int i4, AbstractC1585j abstractC1585j) {
        this(str, str2, productType, price, str3, str4, str5, period, subscriptionOptions, subscriptionOption, fVar, (i4 & 2048) != 0 ? null : presentedOfferingContext);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GoogleStoreProduct(String productId, String str, ProductType type, Price price, String name, String title, String description, Period period, SubscriptionOptions subscriptionOptions, SubscriptionOption subscriptionOption, f productDetails, PresentedOfferingContext presentedOfferingContext) {
        this(productId, str, type, price, name, title, description, period, subscriptionOptions, subscriptionOption, productDetails, presentedOfferingContext != null ? presentedOfferingContext.getOfferingIdentifier() : null, presentedOfferingContext);
        r.f(productId, "productId");
        r.f(type, "type");
        r.f(price, "price");
        r.f(name, "name");
        r.f(title, "title");
        r.f(description, "description");
        r.f(productDetails, "productDetails");
    }

    public /* synthetic */ GoogleStoreProduct(String str, String str2, ProductType productType, Price price, String str3, String str4, Period period, SubscriptionOptions subscriptionOptions, SubscriptionOption subscriptionOption, f fVar, String str5, int i4, AbstractC1585j abstractC1585j) {
        this(str, str2, productType, price, str3, str4, period, subscriptionOptions, subscriptionOption, fVar, (i4 & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0 ? null : str5);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GoogleStoreProduct(String productId, String str, ProductType type, Price price, String title, String description, Period period, SubscriptionOptions subscriptionOptions, SubscriptionOption subscriptionOption, f productDetails, String str2) {
        this(productId, str, type, price, title, title, description, period, subscriptionOptions, subscriptionOption, productDetails, str2 != null ? new PresentedOfferingContext(str2) : null);
        r.f(productId, "productId");
        r.f(type, "type");
        r.f(price, "price");
        r.f(title, "title");
        r.f(description, "description");
        r.f(productDetails, "productDetails");
    }

    private GoogleStoreProduct(GoogleStoreProduct googleStoreProduct, SubscriptionOption subscriptionOption, SubscriptionOptions subscriptionOptions, PresentedOfferingContext presentedOfferingContext) {
        this(googleStoreProduct.productId, googleStoreProduct.basePlanId, googleStoreProduct.getType(), googleStoreProduct.getPrice(), googleStoreProduct.getName(), googleStoreProduct.getTitle(), googleStoreProduct.getDescription(), googleStoreProduct.getPeriod(), subscriptionOptions, subscriptionOption, googleStoreProduct.productDetails, presentedOfferingContext);
    }
}
