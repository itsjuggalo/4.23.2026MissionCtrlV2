package com.revenuecat.purchases.common.caching;

import a6.C0929a;
import a6.c;
import a6.d;

/* JADX INFO: loaded from: classes2.dex */
public final class DeviceCacheKt {
    public static final int CUSTOMER_INFO_SCHEMA_VERSION = 3;
    private static final long PRODUCT_ENTITLEMENT_MAPPING_CACHE_REFRESH_PERIOD;
    private static final String SHARED_PREFERENCES_PREFIX = "com.revenuecat.purchases.";

    static {
        C0929a.C0116a c0116a = C0929a.f6400b;
        PRODUCT_ENTITLEMENT_MAPPING_CACHE_REFRESH_PERIOD = c.s(25, d.f6412g);
    }
}
