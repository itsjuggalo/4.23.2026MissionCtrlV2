package com.revenuecat.purchases.amazon.handler;

import X2.x;
import com.revenuecat.purchases.amazon.AmazonStrings;
import com.revenuecat.purchases.common.LogIntent;
import java.util.Arrays;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class ProductDataHandler$getProductData$$inlined$log$1 extends s implements Function0 {
    final /* synthetic */ LogIntent $intent;
    final /* synthetic */ Set $skus$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProductDataHandler$getProductData$$inlined$log$1(LogIntent logIntent, Set set) {
        super(0);
        this.$intent = logIntent;
        this.$skus$inlined = set;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        StringBuilder sb = new StringBuilder();
        sb.append(x.Q(this.$intent.getEmojiList(), "", null, null, 0, null, null, 62, null));
        sb.append(' ');
        String str = String.format(AmazonStrings.REQUESTING_PRODUCTS, Arrays.copyOf(new Object[]{x.Q(this.$skus$inlined, null, null, null, 0, null, null, 63, null)}, 1));
        r.e(str, "format(this, *args)");
        sb.append(str);
        return sb.toString();
    }
}
