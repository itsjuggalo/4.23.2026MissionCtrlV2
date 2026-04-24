package com.revenuecat.purchases.subscriberattributes;

import X2.x;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.strings.AttributionStrings;
import java.util.Arrays;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes3.dex */
public final class SubscriberAttributesManager$synchronizeSubscriberAttributesForAllUsers$1$2$2$invoke$$inlined$log$1 extends s implements Function0 {
    final /* synthetic */ PurchasesError $error$inlined;
    final /* synthetic */ LogIntent $intent;
    final /* synthetic */ String $syncingAppUserID$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubscriberAttributesManager$synchronizeSubscriberAttributesForAllUsers$1$2$2$invoke$$inlined$log$1(LogIntent logIntent, String str, PurchasesError purchasesError) {
        super(0);
        this.$intent = logIntent;
        this.$syncingAppUserID$inlined = str;
        this.$error$inlined = purchasesError;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        StringBuilder sb = new StringBuilder();
        sb.append(x.Q(this.$intent.getEmojiList(), "", null, null, 0, null, null, 62, null));
        sb.append(' ');
        String str = String.format(AttributionStrings.ATTRIBUTES_SYNC_ERROR, Arrays.copyOf(new Object[]{this.$syncingAppUserID$inlined, this.$error$inlined}, 2));
        r.e(str, "format(this, *args)");
        sb.append(str);
        return sb.toString();
    }
}
