package com.revenuecat.purchases.google;

import X2.x;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.strings.PurchaseStrings;
import java.util.Arrays;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes3.dex */
public final class StoreProductConversionsKt$toStoreProducts$lambda$10$$inlined$log$1 extends s implements Function0 {
    final /* synthetic */ LogIntent $intent;
    final /* synthetic */ com.android.billingclient.api.f $productDetails$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreProductConversionsKt$toStoreProducts$lambda$10$$inlined$log$1(LogIntent logIntent, com.android.billingclient.api.f fVar) {
        super(0);
        this.$intent = logIntent;
        this.$productDetails$inlined = fVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        StringBuilder sb = new StringBuilder();
        sb.append(x.Q(this.$intent.getEmojiList(), "", null, null, 0, null, null, 62, null));
        sb.append(' ');
        String str = String.format(PurchaseStrings.INVALID_PRODUCT_NO_PRICE, Arrays.copyOf(new Object[]{this.$productDetails$inlined.d()}, 1));
        r.e(str, "format(this, *args)");
        sb.append(str);
        return sb.toString();
    }
}
