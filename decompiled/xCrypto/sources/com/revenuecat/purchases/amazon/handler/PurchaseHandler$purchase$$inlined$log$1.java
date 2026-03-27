package com.revenuecat.purchases.amazon.handler;

import X2.x;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.strings.PurchaseStrings;
import java.util.Arrays;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class PurchaseHandler$purchase$$inlined$log$1 extends s implements Function0 {
    final /* synthetic */ LogIntent $intent;
    final /* synthetic */ StoreProduct $storeProduct$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PurchaseHandler$purchase$$inlined$log$1(LogIntent logIntent, StoreProduct storeProduct) {
        super(0);
        this.$intent = logIntent;
        this.$storeProduct$inlined = storeProduct;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        StringBuilder sb = new StringBuilder();
        sb.append(x.Q(this.$intent.getEmojiList(), "", null, null, 0, null, null, 62, null));
        sb.append(' ');
        String str = String.format(PurchaseStrings.PURCHASING_PRODUCT, Arrays.copyOf(new Object[]{this.$storeProduct$inlined.getId()}, 1));
        r.e(str, "format(this, *args)");
        sb.append(str);
        return sb.toString();
    }
}
