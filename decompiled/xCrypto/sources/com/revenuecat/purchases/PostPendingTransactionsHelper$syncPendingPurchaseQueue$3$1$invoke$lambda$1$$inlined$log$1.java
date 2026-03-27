package com.revenuecat.purchases;

import X2.x;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.strings.RestoreStrings;
import java.util.Arrays;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class PostPendingTransactionsHelper$syncPendingPurchaseQueue$3$1$invoke$lambda$1$$inlined$log$1 extends s implements Function0 {
    final /* synthetic */ String $hash$inlined;
    final /* synthetic */ LogIntent $intent;
    final /* synthetic */ StoreTransaction $purchase$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostPendingTransactionsHelper$syncPendingPurchaseQueue$3$1$invoke$lambda$1$$inlined$log$1(LogIntent logIntent, StoreTransaction storeTransaction, String str) {
        super(0);
        this.$intent = logIntent;
        this.$purchase$inlined = storeTransaction;
        this.$hash$inlined = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        StringBuilder sb = new StringBuilder();
        sb.append(x.Q(this.$intent.getEmojiList(), "", null, null, 0, null, null, 62, null));
        sb.append(' ');
        String str = String.format(RestoreStrings.QUERYING_PURCHASE_WITH_HASH, Arrays.copyOf(new Object[]{this.$purchase$inlined.getType(), this.$hash$inlined}, 2));
        r.e(str, "format(this, *args)");
        sb.append(str);
        return sb.toString();
    }
}
