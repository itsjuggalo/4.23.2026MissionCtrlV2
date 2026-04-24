package com.revenuecat.purchases.subscriberattributes.caching;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes3.dex */
public final class SubscriberAttributesCache$subscriberAttributesCacheKey$2 extends s implements Function0 {
    final /* synthetic */ SubscriberAttributesCache this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubscriberAttributesCache$subscriberAttributesCacheKey$2(SubscriberAttributesCache subscriberAttributesCache) {
        super(0);
        this.this$0 = subscriberAttributesCache;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        return this.this$0.getDeviceCache$purchases_defaultsRelease().newKey("subscriberAttributes");
    }
}
