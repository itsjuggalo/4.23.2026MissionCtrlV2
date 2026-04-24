package com.revenuecat.purchases.amazon;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class AmazonCache$amazonPostedTokensKey$2 extends s implements Function0 {
    final /* synthetic */ AmazonCache this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmazonCache$amazonPostedTokensKey$2(AmazonCache amazonCache) {
        super(0);
        this.this$0 = amazonCache;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        return this.this$0.deviceCache.newKey("amazon.tokens");
    }
}
