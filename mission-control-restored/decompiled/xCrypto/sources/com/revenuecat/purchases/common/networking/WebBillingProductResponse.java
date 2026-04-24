package com.revenuecat.purchases.common.networking;

import F3.b;
import H3.e;
import I3.d;
import J3.AbstractC0325a0;
import J3.K;
import J3.k0;
import J3.o0;
import java.util.Map;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class WebBillingProductResponse {
    private final String defaultPurchaseOptionId;
    private final String description;
    private final String identifier;
    private final String productType;
    private final Map<String, WebBillingPurchaseOption> purchaseOptions;
    private final String title;
    public static final Companion Companion = new Companion(null);
    private static final b[] $childSerializers = {null, null, null, null, null, new K(o0.f952a, WebBillingPurchaseOption$$serializer.INSTANCE)};

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        public final b serializer() {
            return WebBillingProductResponse$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ WebBillingProductResponse(int i4, String str, String str2, String str3, String str4, String str5, Map map, k0 k0Var) {
        if (39 != (i4 & 39)) {
            AbstractC0325a0.a(i4, 39, WebBillingProductResponse$$serializer.INSTANCE.getDescriptor());
        }
        this.identifier = str;
        this.productType = str2;
        this.title = str3;
        if ((i4 & 8) == 0) {
            this.description = null;
        } else {
            this.description = str4;
        }
        if ((i4 & 16) == 0) {
            this.defaultPurchaseOptionId = null;
        } else {
            this.defaultPurchaseOptionId = str5;
        }
        this.purchaseOptions = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WebBillingProductResponse copy$default(WebBillingProductResponse webBillingProductResponse, String str, String str2, String str3, String str4, String str5, Map map, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = webBillingProductResponse.identifier;
        }
        if ((i4 & 2) != 0) {
            str2 = webBillingProductResponse.productType;
        }
        if ((i4 & 4) != 0) {
            str3 = webBillingProductResponse.title;
        }
        if ((i4 & 8) != 0) {
            str4 = webBillingProductResponse.description;
        }
        if ((i4 & 16) != 0) {
            str5 = webBillingProductResponse.defaultPurchaseOptionId;
        }
        if ((i4 & 32) != 0) {
            map = webBillingProductResponse.purchaseOptions;
        }
        String str6 = str5;
        Map map2 = map;
        return webBillingProductResponse.copy(str, str2, str3, str4, str6, map2);
    }

    public static /* synthetic */ void getDefaultPurchaseOptionId$annotations() {
    }

    public static /* synthetic */ void getProductType$annotations() {
    }

    public static /* synthetic */ void getPurchaseOptions$annotations() {
    }

    public static final /* synthetic */ void write$Self(WebBillingProductResponse webBillingProductResponse, d dVar, e eVar) {
        b[] bVarArr = $childSerializers;
        dVar.o(eVar, 0, webBillingProductResponse.identifier);
        dVar.o(eVar, 1, webBillingProductResponse.productType);
        dVar.o(eVar, 2, webBillingProductResponse.title);
        if (dVar.j(eVar, 3) || webBillingProductResponse.description != null) {
            dVar.E(eVar, 3, o0.f952a, webBillingProductResponse.description);
        }
        if (dVar.j(eVar, 4) || webBillingProductResponse.defaultPurchaseOptionId != null) {
            dVar.E(eVar, 4, o0.f952a, webBillingProductResponse.defaultPurchaseOptionId);
        }
        dVar.u(eVar, 5, bVarArr[5], webBillingProductResponse.purchaseOptions);
    }

    public final String component1() {
        return this.identifier;
    }

    public final String component2() {
        return this.productType;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.description;
    }

    public final String component5() {
        return this.defaultPurchaseOptionId;
    }

    public final Map<String, WebBillingPurchaseOption> component6() {
        return this.purchaseOptions;
    }

    public final WebBillingProductResponse copy(String identifier, String productType, String title, String str, String str2, Map<String, WebBillingPurchaseOption> purchaseOptions) {
        r.f(identifier, "identifier");
        r.f(productType, "productType");
        r.f(title, "title");
        r.f(purchaseOptions, "purchaseOptions");
        return new WebBillingProductResponse(identifier, productType, title, str, str2, purchaseOptions);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebBillingProductResponse)) {
            return false;
        }
        WebBillingProductResponse webBillingProductResponse = (WebBillingProductResponse) obj;
        return r.b(this.identifier, webBillingProductResponse.identifier) && r.b(this.productType, webBillingProductResponse.productType) && r.b(this.title, webBillingProductResponse.title) && r.b(this.description, webBillingProductResponse.description) && r.b(this.defaultPurchaseOptionId, webBillingProductResponse.defaultPurchaseOptionId) && r.b(this.purchaseOptions, webBillingProductResponse.purchaseOptions);
    }

    public final String getDefaultPurchaseOptionId() {
        return this.defaultPurchaseOptionId;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final String getProductType() {
        return this.productType;
    }

    public final Map<String, WebBillingPurchaseOption> getPurchaseOptions() {
        return this.purchaseOptions;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int iHashCode = ((((this.identifier.hashCode() * 31) + this.productType.hashCode()) * 31) + this.title.hashCode()) * 31;
        String str = this.description;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.defaultPurchaseOptionId;
        return ((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.purchaseOptions.hashCode();
    }

    public String toString() {
        return "WebBillingProductResponse(identifier=" + this.identifier + ", productType=" + this.productType + ", title=" + this.title + ", description=" + this.description + ", defaultPurchaseOptionId=" + this.defaultPurchaseOptionId + ", purchaseOptions=" + this.purchaseOptions + ')';
    }

    public WebBillingProductResponse(String identifier, String productType, String title, String str, String str2, Map<String, WebBillingPurchaseOption> purchaseOptions) {
        r.f(identifier, "identifier");
        r.f(productType, "productType");
        r.f(title, "title");
        r.f(purchaseOptions, "purchaseOptions");
        this.identifier = identifier;
        this.productType = productType;
        this.title = title;
        this.description = str;
        this.defaultPurchaseOptionId = str2;
        this.purchaseOptions = purchaseOptions;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WebBillingProductResponse(String str, String str2, String str3, String str4, String str5, Map map, int i4, AbstractC1585j abstractC1585j) {
        Map map2;
        String str6;
        str4 = (i4 & 8) != 0 ? null : str4;
        if ((i4 & 16) != 0) {
            map2 = map;
            str6 = null;
        } else {
            map2 = map;
            str6 = str5;
        }
        this(str, str2, str3, str4, str6, map2);
    }
}
