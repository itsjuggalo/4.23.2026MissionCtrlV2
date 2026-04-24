package com.revenuecat.purchases.google.usecase;

import X2.x;
import com.revenuecat.purchases.common.LogIntent;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes3.dex */
public final class ConsumePurchaseUseCase$executeAsync$1$1$1$invoke$$inlined$log$1 extends s implements Function0 {
    final /* synthetic */ LogIntent $intent;
    final /* synthetic */ String $underlyingErrorMessage$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumePurchaseUseCase$executeAsync$1$1$1$invoke$$inlined$log$1(LogIntent logIntent, String str) {
        super(0);
        this.$intent = logIntent;
        this.$underlyingErrorMessage$inlined = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        return x.Q(this.$intent.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + this.$underlyingErrorMessage$inlined;
    }
}
