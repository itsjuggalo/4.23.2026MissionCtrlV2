package com.revenuecat.purchases;

import X2.x;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.strings.PurchaseStrings;
import java.util.Arrays;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class PurchasesOrchestrator$Companion$canMakePayments$2$1$onBillingServiceDisconnected$lambda$6$$inlined$log$2 extends s implements Function0 {
    final /* synthetic */ IllegalArgumentException $e$inlined;
    final /* synthetic */ LogIntent $intent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PurchasesOrchestrator$Companion$canMakePayments$2$1$onBillingServiceDisconnected$lambda$6$$inlined$log$2(LogIntent logIntent, IllegalArgumentException illegalArgumentException) {
        super(0);
        this.$intent = logIntent;
        this.$e$inlined = illegalArgumentException;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        StringBuilder sb = new StringBuilder();
        sb.append(x.Q(this.$intent.getEmojiList(), "", null, null, 0, null, null, 62, null));
        sb.append(' ');
        String str = String.format(PurchaseStrings.EXCEPTION_CANMAKEPAYMENTS, Arrays.copyOf(new Object[]{this.$e$inlined.getLocalizedMessage()}, 1));
        r.e(str, "format(this, *args)");
        sb.append(str);
        return sb.toString();
    }
}
