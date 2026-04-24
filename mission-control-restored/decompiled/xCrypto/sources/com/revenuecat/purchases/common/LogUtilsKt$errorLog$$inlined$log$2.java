package com.revenuecat.purchases.common;

import X2.x;
import com.revenuecat.purchases.PurchasesError;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class LogUtilsKt$errorLog$$inlined$log$2 extends s implements Function0 {
    final /* synthetic */ PurchasesError $error$inlined;
    final /* synthetic */ LogIntent $intent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LogUtilsKt$errorLog$$inlined$log$2(LogIntent logIntent, PurchasesError purchasesError) {
        super(0);
        this.$intent = logIntent;
        this.$error$inlined = purchasesError;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        return x.Q(this.$intent.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + this.$error$inlined.toString();
    }
}
