package com.revenuecat.purchases.common.caching;

import W6.a;
import W6.c;
import W6.d;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\"\u0014\u0010\u0001\u001a\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005\"\u0014\u0010\u0007\u001a\u00020\u00068\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"LW6/a;", "PRODUCT_ENTITLEMENT_MAPPING_CACHE_REFRESH_PERIOD", "J", "", "SHARED_PREFERENCES_PREFIX", "Ljava/lang/String;", "", "CUSTOMER_INFO_SCHEMA_VERSION", "I", "purchases_defaultsRelease"}, k = 2, mv = {1, 8, 0})
public final class DeviceCacheKt {
    public static final int CUSTOMER_INFO_SCHEMA_VERSION = 3;
    private static final long PRODUCT_ENTITLEMENT_MAPPING_CACHE_REFRESH_PERIOD;
    private static final String SHARED_PREFERENCES_PREFIX = "com.revenuecat.purchases.";

    static {
        a.C0149a c0149a = a.f9306b;
        PRODUCT_ENTITLEMENT_MAPPING_CACHE_REFRESH_PERIOD = c.s(25, d.f9318g);
    }
}
