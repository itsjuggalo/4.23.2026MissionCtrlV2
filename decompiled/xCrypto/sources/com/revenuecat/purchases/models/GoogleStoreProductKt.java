package com.revenuecat.purchases.models;

import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class GoogleStoreProductKt {
    public static final GoogleStoreProduct getGoogleProduct(StoreProduct storeProduct) {
        r.f(storeProduct, "<this>");
        if (storeProduct instanceof GoogleStoreProduct) {
            return (GoogleStoreProduct) storeProduct;
        }
        return null;
    }
}
