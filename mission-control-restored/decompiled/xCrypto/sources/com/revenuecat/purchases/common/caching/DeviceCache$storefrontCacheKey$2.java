package com.revenuecat.purchases.common.caching;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class DeviceCache$storefrontCacheKey$2 extends s implements Function0 {
    public static final DeviceCache$storefrontCacheKey$2 INSTANCE = new DeviceCache$storefrontCacheKey$2();

    public DeviceCache$storefrontCacheKey$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        return "storefrontCacheKey";
    }
}
