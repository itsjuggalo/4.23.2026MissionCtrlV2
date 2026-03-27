package com.revenuecat.purchases;

import X2.x;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.strings.PurchaseStrings;
import java.util.Arrays;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class PurchasesOrchestrator$syncAmazonPurchase$lambda$12$$inlined$log$1 extends s implements Function0 {
    final /* synthetic */ String $amazonUserID$inlined;
    final /* synthetic */ LogIntent $intent;
    final /* synthetic */ String $receiptID$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PurchasesOrchestrator$syncAmazonPurchase$lambda$12$$inlined$log$1(LogIntent logIntent, String str, String str2) {
        super(0);
        this.$intent = logIntent;
        this.$receiptID$inlined = str;
        this.$amazonUserID$inlined = str2;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        StringBuilder sb = new StringBuilder();
        sb.append(x.Q(this.$intent.getEmojiList(), "", null, null, 0, null, null, 62, null));
        sb.append(' ');
        String str = String.format(PurchaseStrings.SYNCING_PURCHASE_SKIPPING, Arrays.copyOf(new Object[]{this.$receiptID$inlined, this.$amazonUserID$inlined}, 2));
        r.e(str, "format(this, *args)");
        sb.append(str);
        return sb.toString();
    }
}
