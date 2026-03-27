package com.revenuecat.purchases.common;

import X2.AbstractC0769p;
import X2.AbstractC0770q;
import X2.x;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.ReplacementMode;
import com.revenuecat.purchases.models.Period;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.models.PricingPhase;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.models.SubscriptionOptions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class ReceiptInfo {
    private final String currency;
    private final String duration;
    private final PresentedOfferingContext presentedOfferingContext;
    private final Double price;
    private final List<PricingPhase> pricingPhases;
    private final List<String> productIDs;
    private final ReplacementMode replacementMode;
    private final StoreProduct storeProduct;
    private final SubscriptionOption subscriptionOption;
    private final String subscriptionOptionId;

    public ReceiptInfo(List<String> productIDs, PresentedOfferingContext presentedOfferingContext, String str, StoreProduct storeProduct, Double d4, String str2, ReplacementMode replacementMode) {
        SubscriptionOption subscriptionOption;
        SubscriptionOptions subscriptionOptions;
        SubscriptionOption next;
        Period period;
        String iso8601;
        r.f(productIDs, "productIDs");
        this.productIDs = productIDs;
        this.presentedOfferingContext = presentedOfferingContext;
        this.subscriptionOptionId = str;
        this.storeProduct = storeProduct;
        this.price = d4;
        this.currency = str2;
        this.replacementMode = replacementMode;
        this.duration = (storeProduct == null || (period = storeProduct.getPeriod()) == null || (iso8601 = period.getIso8601()) == null || iso8601.length() == 0) ? null : iso8601;
        if (storeProduct == null || (subscriptionOptions = storeProduct.getSubscriptionOptions()) == null) {
            subscriptionOption = null;
        } else {
            Iterator<SubscriptionOption> it = subscriptionOptions.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (r.b(next.getId(), this.subscriptionOptionId)) {
                        break;
                    }
                }
            }
            subscriptionOption = next;
        }
        this.subscriptionOption = subscriptionOption;
        this.pricingPhases = subscriptionOption != null ? subscriptionOption.getPricingPhases() : null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!r.b(ReceiptInfo.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        r.d(obj, "null cannot be cast to non-null type com.revenuecat.purchases.common.ReceiptInfo");
        ReceiptInfo receiptInfo = (ReceiptInfo) obj;
        return r.b(this.productIDs, receiptInfo.productIDs) && r.b(this.presentedOfferingContext, receiptInfo.presentedOfferingContext) && r.b(this.storeProduct, receiptInfo.storeProduct) && r.a(this.price, receiptInfo.price) && r.b(this.currency, receiptInfo.currency) && r.b(this.subscriptionOptionId, receiptInfo.subscriptionOptionId);
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final String getDuration() {
        return this.duration;
    }

    public final List<PlatformProductId> getPlatformProductIds$purchases_defaultsRelease() {
        PlatformProductId platformProductId;
        SubscriptionOption subscriptionOption = this.subscriptionOption;
        if (subscriptionOption == null || (platformProductId = ReceiptInfoKt.platformProductId(subscriptionOption)) == null) {
            StoreProduct storeProduct = this.storeProduct;
            platformProductId = storeProduct != null ? ReceiptInfoKt.platformProductId(storeProduct) : null;
        }
        List<String> list = this.productIDs;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!r.b((String) obj, platformProductId != null ? platformProductId.getProductId() : null)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(AbstractC0770q.q(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new PlatformProductId((String) it.next()));
        }
        return x.U(arrayList2, AbstractC0769p.k(platformProductId));
    }

    public final PresentedOfferingContext getPresentedOfferingContext() {
        return this.presentedOfferingContext;
    }

    public final Double getPrice() {
        return this.price;
    }

    public final List<PricingPhase> getPricingPhases() {
        return this.pricingPhases;
    }

    public final List<String> getProductIDs() {
        return this.productIDs;
    }

    public final ReplacementMode getReplacementMode() {
        return this.replacementMode;
    }

    public final StoreProduct getStoreProduct() {
        return this.storeProduct;
    }

    public final String getSubscriptionOptionId() {
        return this.subscriptionOptionId;
    }

    public int hashCode() {
        int iHashCode = this.productIDs.hashCode() * 31;
        PresentedOfferingContext presentedOfferingContext = this.presentedOfferingContext;
        int iHashCode2 = (iHashCode + (presentedOfferingContext != null ? presentedOfferingContext.hashCode() : 0)) * 31;
        StoreProduct storeProduct = this.storeProduct;
        int iHashCode3 = (iHashCode2 + (storeProduct != null ? storeProduct.hashCode() : 0)) * 31;
        String str = this.subscriptionOptionId;
        return iHashCode3 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "ReceiptInfo(productIDs='" + x.Q(this.productIDs, null, null, null, 0, null, null, 63, null) + "', presentedOfferingContext=" + this.presentedOfferingContext + ", storeProduct=" + this.storeProduct + ", subscriptionOptionId=" + this.subscriptionOptionId + ", pricingPhases=" + this.pricingPhases + ", price=" + this.price + ", currency=" + this.currency + ", duration=" + this.duration + ')';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ReceiptInfo(List list, PresentedOfferingContext presentedOfferingContext, String str, StoreProduct storeProduct, Double d4, String str2, ReplacementMode replacementMode, int i4, AbstractC1585j abstractC1585j) {
        Price price;
        Price price2;
        presentedOfferingContext = (i4 & 2) != 0 ? null : presentedOfferingContext;
        str = (i4 & 4) != 0 ? null : str;
        storeProduct = (i4 & 8) != 0 ? null : storeProduct;
        this(list, presentedOfferingContext, str, storeProduct, (i4 & 16) != 0 ? (storeProduct == null || (price2 = storeProduct.getPrice()) == null) ? null : Double.valueOf(price2.getAmountMicros() / 1000000.0d) : d4, (i4 & 32) != 0 ? (storeProduct == null || (price = storeProduct.getPrice()) == null) ? null : price.getCurrencyCode() : str2, (i4 & 64) != 0 ? null : replacementMode);
    }
}
