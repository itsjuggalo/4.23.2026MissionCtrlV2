package com.revenuecat.purchases.common.caching;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes2.dex */
public final class DeviceCache$tokensCacheKey$2 extends s implements Function0 {
    final /* synthetic */ DeviceCache this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceCache$tokensCacheKey$2(DeviceCache deviceCache) {
        super(0);
        this.this$0 = deviceCache;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        return this.this$0.getApiKeyPrefix() + ".tokens";
    }
}
