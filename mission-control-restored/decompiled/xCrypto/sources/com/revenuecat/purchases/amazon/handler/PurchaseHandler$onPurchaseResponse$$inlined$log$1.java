package com.revenuecat.purchases.amazon.handler;

import X2.x;
import com.amazon.device.iap.model.PurchaseResponse;
import com.revenuecat.purchases.amazon.AmazonStrings;
import com.revenuecat.purchases.common.LogIntent;
import java.util.Arrays;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class PurchaseHandler$onPurchaseResponse$$inlined$log$1 extends s implements Function0 {
    final /* synthetic */ LogIntent $intent;
    final /* synthetic */ PurchaseResponse $response$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PurchaseHandler$onPurchaseResponse$$inlined$log$1(LogIntent logIntent, PurchaseResponse purchaseResponse) {
        super(0);
        this.$intent = logIntent;
        this.$response$inlined = purchaseResponse;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        StringBuilder sb = new StringBuilder();
        sb.append(x.Q(this.$intent.getEmojiList(), "", null, null, 0, null, null, 62, null));
        sb.append(' ');
        String str = String.format(AmazonStrings.PURCHASE_REQUEST_FINISHED, Arrays.copyOf(new Object[]{this.$response$inlined.toJSON().toString(1)}, 1));
        r.e(str, "format(this, *args)");
        sb.append(str);
        return sb.toString();
    }
}
