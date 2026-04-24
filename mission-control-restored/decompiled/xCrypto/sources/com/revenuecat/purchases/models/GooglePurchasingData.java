package com.revenuecat.purchases.models;

import W2.m;
import com.android.billingclient.api.f;
import com.revenuecat.purchases.ProductType;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public abstract class GooglePurchasingData implements PurchasingData {

    public static final class InAppProduct extends GooglePurchasingData {
        private final f productDetails;
        private final String productId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InAppProduct(String productId, f productDetails) {
            super(null);
            r.f(productId, "productId");
            r.f(productDetails, "productDetails");
            this.productId = productId;
            this.productDetails = productDetails;
        }

        public static /* synthetic */ InAppProduct copy$default(InAppProduct inAppProduct, String str, f fVar, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                str = inAppProduct.productId;
            }
            if ((i4 & 2) != 0) {
                fVar = inAppProduct.productDetails;
            }
            return inAppProduct.copy(str, fVar);
        }

        public final String component1() {
            return this.productId;
        }

        public final f component2() {
            return this.productDetails;
        }

        public final InAppProduct copy(String productId, f productDetails) {
            r.f(productId, "productId");
            r.f(productDetails, "productDetails");
            return new InAppProduct(productId, productDetails);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof InAppProduct)) {
                return false;
            }
            InAppProduct inAppProduct = (InAppProduct) obj;
            return r.b(this.productId, inAppProduct.productId) && r.b(this.productDetails, inAppProduct.productDetails);
        }

        public final f getProductDetails() {
            return this.productDetails;
        }

        @Override // com.revenuecat.purchases.models.PurchasingData
        public String getProductId() {
            return this.productId;
        }

        public int hashCode() {
            return (this.productId.hashCode() * 31) + this.productDetails.hashCode();
        }

        public String toString() {
            return "InAppProduct(productId=" + this.productId + ", productDetails=" + this.productDetails + ')';
        }
    }

    public static final class Subscription extends GooglePurchasingData {
        private final String optionId;
        private final f productDetails;
        private final String productId;
        private final String token;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Subscription(String productId, String optionId, f productDetails, String token) {
            super(null);
            r.f(productId, "productId");
            r.f(optionId, "optionId");
            r.f(productDetails, "productDetails");
            r.f(token, "token");
            this.productId = productId;
            this.optionId = optionId;
            this.productDetails = productDetails;
            this.token = token;
        }

        public static /* synthetic */ Subscription copy$default(Subscription subscription, String str, String str2, f fVar, String str3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                str = subscription.productId;
            }
            if ((i4 & 2) != 0) {
                str2 = subscription.optionId;
            }
            if ((i4 & 4) != 0) {
                fVar = subscription.productDetails;
            }
            if ((i4 & 8) != 0) {
                str3 = subscription.token;
            }
            return subscription.copy(str, str2, fVar, str3);
        }

        public final String component1() {
            return this.productId;
        }

        public final String component2() {
            return this.optionId;
        }

        public final f component3() {
            return this.productDetails;
        }

        public final String component4() {
            return this.token;
        }

        public final Subscription copy(String productId, String optionId, f productDetails, String token) {
            r.f(productId, "productId");
            r.f(optionId, "optionId");
            r.f(productDetails, "productDetails");
            r.f(token, "token");
            return new Subscription(productId, optionId, productDetails, token);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Subscription)) {
                return false;
            }
            Subscription subscription = (Subscription) obj;
            return r.b(this.productId, subscription.productId) && r.b(this.optionId, subscription.optionId) && r.b(this.productDetails, subscription.productDetails) && r.b(this.token, subscription.token);
        }

        public final String getOptionId() {
            return this.optionId;
        }

        public final f getProductDetails() {
            return this.productDetails;
        }

        @Override // com.revenuecat.purchases.models.PurchasingData
        public String getProductId() {
            return this.productId;
        }

        public final String getToken() {
            return this.token;
        }

        public int hashCode() {
            return (((((this.productId.hashCode() * 31) + this.optionId.hashCode()) * 31) + this.productDetails.hashCode()) * 31) + this.token.hashCode();
        }

        public String toString() {
            return "Subscription(productId=" + this.productId + ", optionId=" + this.optionId + ", productDetails=" + this.productDetails + ", token=" + this.token + ')';
        }
    }

    public /* synthetic */ GooglePurchasingData(AbstractC1585j abstractC1585j) {
        this();
    }

    @Override // com.revenuecat.purchases.models.PurchasingData
    public ProductType getProductType() {
        if (this instanceof InAppProduct) {
            return ProductType.INAPP;
        }
        if (this instanceof Subscription) {
            return ProductType.SUBS;
        }
        throw new m();
    }

    private GooglePurchasingData() {
    }
}
