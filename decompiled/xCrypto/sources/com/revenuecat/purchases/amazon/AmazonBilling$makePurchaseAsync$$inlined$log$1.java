package com.revenuecat.purchases.amazon;

import X2.x;
import com.revenuecat.purchases.common.LogIntent;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class AmazonBilling$makePurchaseAsync$$inlined$log$1 extends s implements Function0 {
    final /* synthetic */ LogIntent $intent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmazonBilling$makePurchaseAsync$$inlined$log$1(LogIntent logIntent) {
        super(0);
        this.$intent = logIntent;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        return x.Q(this.$intent.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + AmazonStrings.PRODUCT_CHANGES_NOT_SUPPORTED;
    }
}
