package com.revenuecat.purchases.common;

import W2.t;
import X2.K;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import java.util.Map;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public class PlatformProductId {
    private final String productId;

    public PlatformProductId(String productId) {
        r.f(productId, "productId");
        this.productId = productId;
    }

    public Map<String, String> getAsMap() {
        return K.c(t.a(DiagnosticsTracker.PRODUCT_ID_KEY, getProductId()));
    }

    public String getProductId() {
        return this.productId;
    }
}
