package com.revenuecat.purchases.common;

import E5.t;
import F5.I;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import java.util.Map;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public class PlatformProductId {
    private final String productId;

    public PlatformProductId(String productId) {
        r.f(productId, "productId");
        this.productId = productId;
    }

    public Map<String, String> getAsMap() {
        return I.c(t.a(DiagnosticsTracker.PRODUCT_ID_KEY, getProductId()));
    }

    public String getProductId() {
        return this.productId;
    }
}
