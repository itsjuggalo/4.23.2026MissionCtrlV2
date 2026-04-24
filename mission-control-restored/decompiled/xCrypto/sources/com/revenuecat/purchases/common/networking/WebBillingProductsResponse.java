package com.revenuecat.purchases.common.networking;

import F3.b;
import J3.AbstractC0325a0;
import J3.C0332e;
import J3.k0;
import java.util.List;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class WebBillingProductsResponse {
    private final List<WebBillingProductResponse> productDetails;
    public static final Companion Companion = new Companion(null);
    private static final b[] $childSerializers = {new C0332e(WebBillingProductResponse$$serializer.INSTANCE)};

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        public final b serializer() {
            return WebBillingProductsResponse$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ WebBillingProductsResponse(int i4, List list, k0 k0Var) {
        if (1 != (i4 & 1)) {
            AbstractC0325a0.a(i4, 1, WebBillingProductsResponse$$serializer.INSTANCE.getDescriptor());
        }
        this.productDetails = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WebBillingProductsResponse copy$default(WebBillingProductsResponse webBillingProductsResponse, List list, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            list = webBillingProductsResponse.productDetails;
        }
        return webBillingProductsResponse.copy(list);
    }

    public static /* synthetic */ void getProductDetails$annotations() {
    }

    public final List<WebBillingProductResponse> component1() {
        return this.productDetails;
    }

    public final WebBillingProductsResponse copy(List<WebBillingProductResponse> productDetails) {
        r.f(productDetails, "productDetails");
        return new WebBillingProductsResponse(productDetails);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof WebBillingProductsResponse) && r.b(this.productDetails, ((WebBillingProductsResponse) obj).productDetails);
    }

    public final List<WebBillingProductResponse> getProductDetails() {
        return this.productDetails;
    }

    public int hashCode() {
        return this.productDetails.hashCode();
    }

    public String toString() {
        return "WebBillingProductsResponse(productDetails=" + this.productDetails + ')';
    }

    public WebBillingProductsResponse(List<WebBillingProductResponse> productDetails) {
        r.f(productDetails, "productDetails");
        this.productDetails = productDetails;
    }
}
