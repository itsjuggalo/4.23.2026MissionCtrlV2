package com.revenuecat.purchases.google;

import X2.x;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.strings.BillingStrings;
import java.util.Arrays;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes3.dex */
public final class BillingWrapper$onBillingSetupFinished$lambda$35$$inlined$log$1 extends s implements Function0 {
    final /* synthetic */ LogIntent $intent;
    final /* synthetic */ BillingWrapper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BillingWrapper$onBillingSetupFinished$lambda$35$$inlined$log$1(LogIntent logIntent, BillingWrapper billingWrapper) {
        super(0);
        this.$intent = logIntent;
        this.this$0 = billingWrapper;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        StringBuilder sb = new StringBuilder();
        sb.append(x.Q(this.$intent.getEmojiList(), "", null, null, 0, null, null, 62, null));
        sb.append(' ');
        com.android.billingclient.api.a billingClient = this.this$0.getBillingClient();
        String str = String.format(BillingStrings.BILLING_SERVICE_SETUP_FINISHED, Arrays.copyOf(new Object[]{billingClient != null ? billingClient.toString() : null}, 1));
        r.e(str, "format(this, *args)");
        sb.append(str);
        return sb.toString();
    }
}
