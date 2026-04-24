package com.revenuecat.purchases.amazon.handler;

import X2.x;
import com.amazon.device.iap.model.ProductDataResponse;
import com.revenuecat.purchases.amazon.AmazonStrings;
import com.revenuecat.purchases.common.LogIntent;
import java.util.Arrays;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class ProductDataHandler$onProductDataResponse$$inlined$log$2 extends s implements Function0 {
    final /* synthetic */ LogIntent $intent;
    final /* synthetic */ ProductDataResponse $response$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProductDataHandler$onProductDataResponse$$inlined$log$2(LogIntent logIntent, ProductDataResponse productDataResponse) {
        super(0);
        this.$intent = logIntent;
        this.$response$inlined = productDataResponse;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        StringBuilder sb = new StringBuilder();
        sb.append(x.Q(this.$intent.getEmojiList(), "", null, null, 0, null, null, 62, null));
        sb.append(' ');
        String str = String.format(AmazonStrings.PRODUCTS_REQUEST_UNAVAILABLE, Arrays.copyOf(new Object[]{this.$response$inlined.getUnavailableSkus()}, 1));
        r.e(str, "format(this, *args)");
        sb.append(str);
        return sb.toString();
    }
}
