package com.revenuecat.purchases.amazon;

import X2.x;
import com.revenuecat.purchases.common.LogIntent;
import java.util.Arrays;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class AmazonCache$cacheSkusByToken$$inlined$log$1 extends s implements Function0 {
    final /* synthetic */ LogIntent $intent;
    final /* synthetic */ Map $receiptsToSkus$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmazonCache$cacheSkusByToken$$inlined$log$1(LogIntent logIntent, Map map) {
        super(0);
        this.$intent = logIntent;
        this.$receiptsToSkus$inlined = map;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        StringBuilder sb = new StringBuilder();
        sb.append(x.Q(this.$intent.getEmojiList(), "", null, null, 0, null, null, 62, null));
        sb.append(' ');
        String str = String.format(AmazonStrings.CACHING_RECEIPT_TERM_SKUS, Arrays.copyOf(new Object[]{this.$receiptsToSkus$inlined}, 1));
        r.e(str, "format(this, *args)");
        sb.append(str);
        return sb.toString();
    }
}
