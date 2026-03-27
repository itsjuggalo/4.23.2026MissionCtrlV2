package com.revenuecat.purchases.google;

import X2.x;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.strings.BillingStrings;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes3.dex */
public final class BillingWrapper$onPurchasesUpdated$$inlined$log$1 extends s implements Function0 {
    final /* synthetic */ com.android.billingclient.api.d $billingResult$inlined;
    final /* synthetic */ LogIntent $intent;
    final /* synthetic */ List $notNullPurchasesList$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BillingWrapper$onPurchasesUpdated$$inlined$log$1(LogIntent logIntent, com.android.billingclient.api.d dVar, List list) {
        super(0);
        this.$intent = logIntent;
        this.$billingResult$inlined = dVar;
        this.$notNullPurchasesList$inlined = list;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        StringBuilder sb = new StringBuilder();
        String str = null;
        sb.append(x.Q(this.$intent.getEmojiList(), "", null, null, 0, null, null, 62, null));
        sb.append(' ');
        StringBuilder sb2 = new StringBuilder();
        String str2 = String.format(BillingStrings.BILLING_WRAPPER_PURCHASES_ERROR, Arrays.copyOf(new Object[]{BillingResultExtensionsKt.toHumanReadableDescription(this.$billingResult$inlined)}, 1));
        r.e(str2, "format(this, *args)");
        sb2.append(str2);
        List list = this.$notNullPurchasesList$inlined;
        List list2 = !list.isEmpty() ? list : null;
        if (list2 != null) {
            str = "Purchases:" + x.Q(list2, ", ", null, null, 0, null, BillingWrapper$onPurchasesUpdated$2$2$1.INSTANCE, 30, null);
        }
        sb2.append(str);
        sb.append(sb2.toString());
        return sb.toString();
    }
}
