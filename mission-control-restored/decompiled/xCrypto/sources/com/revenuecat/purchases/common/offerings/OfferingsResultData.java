package com.revenuecat.purchases.common.offerings;

import com.revenuecat.purchases.Offerings;
import java.util.Set;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class OfferingsResultData {
    private final Set<String> notFoundProductIds;
    private final Offerings offerings;
    private final Set<String> requestedProductIds;

    public OfferingsResultData(Offerings offerings, Set<String> requestedProductIds, Set<String> notFoundProductIds) {
        r.f(offerings, "offerings");
        r.f(requestedProductIds, "requestedProductIds");
        r.f(notFoundProductIds, "notFoundProductIds");
        this.offerings = offerings;
        this.requestedProductIds = requestedProductIds;
        this.notFoundProductIds = notFoundProductIds;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OfferingsResultData copy$default(OfferingsResultData offeringsResultData, Offerings offerings, Set set, Set set2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            offerings = offeringsResultData.offerings;
        }
        if ((i4 & 2) != 0) {
            set = offeringsResultData.requestedProductIds;
        }
        if ((i4 & 4) != 0) {
            set2 = offeringsResultData.notFoundProductIds;
        }
        return offeringsResultData.copy(offerings, set, set2);
    }

    public final Offerings component1() {
        return this.offerings;
    }

    public final Set<String> component2() {
        return this.requestedProductIds;
    }

    public final Set<String> component3() {
        return this.notFoundProductIds;
    }

    public final OfferingsResultData copy(Offerings offerings, Set<String> requestedProductIds, Set<String> notFoundProductIds) {
        r.f(offerings, "offerings");
        r.f(requestedProductIds, "requestedProductIds");
        r.f(notFoundProductIds, "notFoundProductIds");
        return new OfferingsResultData(offerings, requestedProductIds, notFoundProductIds);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OfferingsResultData)) {
            return false;
        }
        OfferingsResultData offeringsResultData = (OfferingsResultData) obj;
        return r.b(this.offerings, offeringsResultData.offerings) && r.b(this.requestedProductIds, offeringsResultData.requestedProductIds) && r.b(this.notFoundProductIds, offeringsResultData.notFoundProductIds);
    }

    public final Set<String> getNotFoundProductIds() {
        return this.notFoundProductIds;
    }

    public final Offerings getOfferings() {
        return this.offerings;
    }

    public final Set<String> getRequestedProductIds() {
        return this.requestedProductIds;
    }

    public int hashCode() {
        return (((this.offerings.hashCode() * 31) + this.requestedProductIds.hashCode()) * 31) + this.notFoundProductIds.hashCode();
    }

    public String toString() {
        return "OfferingsResultData(offerings=" + this.offerings + ", requestedProductIds=" + this.requestedProductIds + ", notFoundProductIds=" + this.notFoundProductIds + ')';
    }
}
