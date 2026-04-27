package com.revenuecat.purchases.google.usecase;

import com.revenuecat.purchases.common.LogIntent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2306v;
import p5.z;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "invoke", "com/revenuecat/purchases/common/LogWrapperKt$log$fullMessageBuilder$1"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class ConsumePurchaseUseCase$executeAsync$1$1$1$invoke$$inlined$log$1 extends AbstractC2306v implements Function0 {
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
        return z.h0(this.$intent.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + this.$underlyingErrorMessage$inlined;
    }
}
