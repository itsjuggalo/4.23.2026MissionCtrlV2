package com.revenuecat.purchases.common.caching;

import s3.C1779a;
import s3.c;
import s3.d;

/* JADX INFO: loaded from: classes.dex */
public final class DeviceCacheKt {
    public static final int CUSTOMER_INFO_SCHEMA_VERSION = 3;
    private static final long PRODUCT_ENTITLEMENT_MAPPING_CACHE_REFRESH_PERIOD;
    private static final String SHARED_PREFERENCES_PREFIX = "com.revenuecat.purchases.";

    static {
        C1779a.C0237a c0237a = C1779a.f14679b;
        PRODUCT_ENTITLEMENT_MAPPING_CACHE_REFRESH_PERIOD = c.s(25, d.f14691g);
    }
}
