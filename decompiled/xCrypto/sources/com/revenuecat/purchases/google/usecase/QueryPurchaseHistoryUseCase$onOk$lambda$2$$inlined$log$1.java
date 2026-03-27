package com.revenuecat.purchases.google.usecase;

import X2.x;
import com.android.billingclient.api.PurchaseHistoryRecord;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.PurchaseHistoryRecordExtensionsKt;
import com.revenuecat.purchases.strings.RestoreStrings;
import java.util.Arrays;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes3.dex */
public final class QueryPurchaseHistoryUseCase$onOk$lambda$2$$inlined$log$1 extends s implements Function0 {
    final /* synthetic */ LogIntent $intent;
    final /* synthetic */ PurchaseHistoryRecord $it$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QueryPurchaseHistoryUseCase$onOk$lambda$2$$inlined$log$1(LogIntent logIntent, PurchaseHistoryRecord purchaseHistoryRecord) {
        super(0);
        this.$intent = logIntent;
        this.$it$inlined = purchaseHistoryRecord;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        StringBuilder sb = new StringBuilder();
        sb.append(x.Q(this.$intent.getEmojiList(), "", null, null, 0, null, null, 62, null));
        sb.append(' ');
        String str = String.format(RestoreStrings.PURCHASE_HISTORY_RETRIEVED, Arrays.copyOf(new Object[]{PurchaseHistoryRecordExtensionsKt.toHumanReadableDescription(this.$it$inlined)}, 1));
        r.e(str, "format(this, *args)");
        sb.append(str);
        return sb.toString();
    }
}
