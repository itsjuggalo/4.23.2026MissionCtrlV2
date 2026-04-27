package com.revenuecat.purchases.models;

import X2.AbstractC0768o;
import X2.AbstractC0769p;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.models.Period;
import com.revenuecat.purchases.simulatedstore.SimulatedStorePurchasingData;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class TestStoreProduct implements StoreProduct {
    private final String description;
    private final PricingPhase freeTrialPricingPhase;
    private final String id;
    private final PricingPhase introPricePricingPhase;
    private final String name;
    private final Period period;
    private final PresentedOfferingContext presentedOfferingContext;
    private final Price price;
    private final PurchasingData purchasingData;
    private final String title;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TestStoreProduct(String id, String name, String title, String description, Price price) {
        this(id, name, title, description, price, null, null, null, null, 480, null);
        r.f(id, "id");
        r.f(name, "name");
        r.f(title, "title");
        r.f(description, "description");
        r.f(price, "price");
    }

    private final SubscriptionOptions buildSubscriptionOptions() {
        if (getPeriod() == null) {
            return null;
        }
        PricingPhase pricingPhase = new PricingPhase(getPeriod(), RecurrenceMode.INFINITE_RECURRING, null, getPrice());
        return new SubscriptionOptions(AbstractC0769p.l((this.freeTrialPricingPhase == null && this.introPricePricingPhase == null) ? null : new TestSubscriptionOption(AbstractC0769p.l(this.freeTrialPricingPhase, this.introPricePricingPhase, pricingPhase), null, null, null, null, getPurchasingData(), 30, null), new TestSubscriptionOption(AbstractC0768o.b(pricingPhase), null, null, null, null, getPurchasingData(), 30, null)));
    }

    private final PricingPhase component7() {
        return this.freeTrialPricingPhase;
    }

    private final PricingPhase component8() {
        return this.introPricePricingPhase;
    }

    public static /* synthetic */ TestStoreProduct copy$default(TestStoreProduct testStoreProduct, String str, String str2, String str3, String str4, Price price, Period period, PricingPhase pricingPhase, PricingPhase pricingPhase2, PresentedOfferingContext presentedOfferingContext, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = testStoreProduct.id;
        }
        if ((i4 & 2) != 0) {
            str2 = testStoreProduct.name;
        }
        if ((i4 & 4) != 0) {
            str3 = testStoreProduct.title;
        }
        if ((i4 & 8) != 0) {
            str4 = testStoreProduct.description;
        }
        if ((i4 & 16) != 0) {
            price = testStoreProduct.price;
        }
        if ((i4 & 32) != 0) {
            period = testStoreProduct.period;
        }
        if ((i4 & 64) != 0) {
            pricingPhase = testStoreProduct.freeTrialPricingPhase;
        }
        if ((i4 & UserMetadata.MAX_ROLLOUT_ASSIGNMENTS) != 0) {
            pricingPhase2 = testStoreProduct.introPricePricingPhase;
        }
        if ((i4 & 256) != 0) {
            presentedOfferingContext = testStoreProduct.presentedOfferingContext;
        }
        PricingPhase pricingPhase3 = pricingPhase2;
        PresentedOfferingContext presentedOfferingContext2 = presentedOfferingContext;
        Period period2 = period;
        PricingPhase pricingPhase4 = pricingPhase;
        Price price2 = price;
        String str5 = str3;
        return testStoreProduct.copy(str, str2, str5, str4, price2, period2, pricingPhase4, pricingPhase3, presentedOfferingContext2);
    }

    public static /* synthetic */ void getPresentedOfferingIdentifier$annotations() {
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.description;
    }

    public final Price component5() {
        return this.price;
    }

    public final Period component6() {
        return this.period;
    }

    public final PresentedOfferingContext component9() {
        return this.presentedOfferingContext;
    }

    public final TestStoreProduct copy(String id, String name, String title, String description, Price price, Period period, PricingPhase pricingPhase, PricingPhase pricingPhase2, PresentedOfferingContext presentedOfferingContext) {
        r.f(id, "id");
        r.f(name, "name");
        r.f(title, "title");
        r.f(description, "description");
        r.f(price, "price");
        return new TestStoreProduct(id, name, title, description, price, period, pricingPhase, pricingPhase2, presentedOfferingContext);
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public StoreProduct copyWithOfferingId(String offeringId) {
        r.f(offeringId, "offeringId");
        return copyWithPresentedOfferingContext(new PresentedOfferingContext(offeringId));
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public StoreProduct copyWithPresentedOfferingContext(PresentedOfferingContext presentedOfferingContext) {
        return new TestStoreProduct(getId(), getName(), getTitle(), getDescription(), getPrice(), getPeriod(), this.freeTrialPricingPhase, this.introPricePricingPhase, presentedOfferingContext);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TestStoreProduct)) {
            return false;
        }
        TestStoreProduct testStoreProduct = (TestStoreProduct) obj;
        return r.b(this.id, testStoreProduct.id) && r.b(this.name, testStoreProduct.name) && r.b(this.title, testStoreProduct.title) && r.b(this.description, testStoreProduct.description) && r.b(this.price, testStoreProduct.price) && r.b(this.period, testStoreProduct.period) && r.b(this.freeTrialPricingPhase, testStoreProduct.freeTrialPricingPhase) && r.b(this.introPricePricingPhase, testStoreProduct.introPricePricingPhase) && r.b(this.presentedOfferingContext, testStoreProduct.presentedOfferingContext);
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public SubscriptionOption getDefaultOption() {
        SubscriptionOptions subscriptionOptions = getSubscriptionOptions();
        if (subscriptionOptions != null) {
            return subscriptionOptions.getDefaultOffer();
        }
        return null;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public String getDescription() {
        return this.description;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public String getId() {
        return this.id;
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
        PresentedOfferingContext presentedOfferingContext = getPresentedOfferingContext();
        if (presentedOfferingContext != null) {
            return presentedOfferingContext.getOfferingIdentifier();
        }
        return null;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public Price getPrice() {
        return this.price;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public PurchasingData getPurchasingData() {
        return this.purchasingData;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public String getSku() {
        return getId();
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public SubscriptionOptions getSubscriptionOptions() {
        return buildSubscriptionOptions();
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public String getTitle() {
        return this.title;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public ProductType getType() {
        return getPeriod() == null ? ProductType.INAPP : ProductType.SUBS;
    }

    public int hashCode() {
        int iHashCode = ((((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.title.hashCode()) * 31) + this.description.hashCode()) * 31) + this.price.hashCode()) * 31;
        Period period = this.period;
        int iHashCode2 = (iHashCode + (period == null ? 0 : period.hashCode())) * 31;
        PricingPhase pricingPhase = this.freeTrialPricingPhase;
        int iHashCode3 = (iHashCode2 + (pricingPhase == null ? 0 : pricingPhase.hashCode())) * 31;
        PricingPhase pricingPhase2 = this.introPricePricingPhase;
        int iHashCode4 = (iHashCode3 + (pricingPhase2 == null ? 0 : pricingPhase2.hashCode())) * 31;
        PresentedOfferingContext presentedOfferingContext = this.presentedOfferingContext;
        return iHashCode4 + (presentedOfferingContext != null ? presentedOfferingContext.hashCode() : 0);
    }

    public String toString() {
        return "TestStoreProduct(id=" + this.id + ", name=" + this.name + ", title=" + this.title + ", description=" + this.description + ", price=" + this.price + ", period=" + this.period + ", freeTrialPricingPhase=" + this.freeTrialPricingPhase + ", introPricePricingPhase=" + this.introPricePricingPhase + ", presentedOfferingContext=" + this.presentedOfferingContext + ')';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TestStoreProduct(String id, String name, String title, String description, Price price, Period period) {
        this(id, name, title, description, price, period, null, null, null, 448, null);
        r.f(id, "id");
        r.f(name, "name");
        r.f(title, "title");
        r.f(description, "description");
        r.f(price, "price");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TestStoreProduct(String id, String name, String title, String description, Price price, Period period, PricingPhase pricingPhase) {
        this(id, name, title, description, price, period, pricingPhase, null, null, 384, null);
        r.f(id, "id");
        r.f(name, "name");
        r.f(title, "title");
        r.f(description, "description");
        r.f(price, "price");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TestStoreProduct(String id, String name, String title, String description, Price price, Period period, PricingPhase pricingPhase, PricingPhase pricingPhase2) {
        this(id, name, title, description, price, period, pricingPhase, pricingPhase2, null, 256, null);
        r.f(id, "id");
        r.f(name, "name");
        r.f(title, "title");
        r.f(description, "description");
        r.f(price, "price");
    }

    public TestStoreProduct(String id, String name, String title, String description, Price price, Period period, PricingPhase pricingPhase, PricingPhase pricingPhase2, PresentedOfferingContext presentedOfferingContext) {
        r.f(id, "id");
        r.f(name, "name");
        r.f(title, "title");
        r.f(description, "description");
        r.f(price, "price");
        this.id = id;
        this.name = name;
        this.title = title;
        this.description = description;
        this.price = price;
        this.period = period;
        this.freeTrialPricingPhase = pricingPhase;
        this.introPricePricingPhase = pricingPhase2;
        this.presentedOfferingContext = presentedOfferingContext;
        this.purchasingData = new SimulatedStorePurchasingData(getId(), getType(), this);
    }

    public /* synthetic */ TestStoreProduct(String str, String str2, String str3, String str4, Price price, Period period, PricingPhase pricingPhase, PricingPhase pricingPhase2, PresentedOfferingContext presentedOfferingContext, int i4, AbstractC1585j abstractC1585j) {
        this(str, str2, str3, str4, price, (i4 & 32) != 0 ? null : period, (i4 & 64) != 0 ? null : pricingPhase, (i4 & UserMetadata.MAX_ROLLOUT_ASSIGNMENTS) != 0 ? null : pricingPhase2, (i4 & 256) != 0 ? null : presentedOfferingContext);
    }

    public /* synthetic */ TestStoreProduct(String str, String str2, String str3, String str4, Price price, Period period, Period period2, Price price2, int i4, AbstractC1585j abstractC1585j) {
        this(str, str2, str3, str4, price, (i4 & 32) != 0 ? null : period, (i4 & 64) != 0 ? null : period2, (i4 & UserMetadata.MAX_ROLLOUT_ASSIGNMENTS) != 0 ? null : price2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TestStoreProduct(String id, String name, String title, String description, Price price, Period period, Period period2, Price price2) {
        this(id, name, title, description, price, period, period2 != null ? new PricingPhase(period2, RecurrenceMode.FINITE_RECURRING, 1, new Price("Free", 0L, price.getCurrencyCode())) : null, price2 != null ? new PricingPhase(new Period(1, Period.Unit.MONTH, "P1M"), RecurrenceMode.FINITE_RECURRING, 1, price2) : null, null, 256, null);
        r.f(id, "id");
        r.f(name, "name");
        r.f(title, "title");
        r.f(description, "description");
        r.f(price, "price");
    }

    public /* synthetic */ TestStoreProduct(String str, String str2, String str3, Price price, Period period, Period period2, Price price2, int i4, AbstractC1585j abstractC1585j) {
        this(str, str2, str3, price, period, (i4 & 32) != 0 ? null : period2, (i4 & 64) != 0 ? null : price2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TestStoreProduct(String id, String title, String description, Price price, Period period, Period period2, Price price2) {
        this(id, title, title, description, price, period, period2, price2);
        r.f(id, "id");
        r.f(title, "title");
        r.f(description, "description");
        r.f(price, "price");
    }
}
