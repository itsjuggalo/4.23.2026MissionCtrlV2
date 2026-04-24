package com.revenuecat.purchases.common;

import X2.x;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class LogWrapperKt$log$fullMessageBuilder$1 extends s implements Function0 {
    final /* synthetic */ LogIntent $intent;
    final /* synthetic */ Function0 $messageBuilder;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LogWrapperKt$log$fullMessageBuilder$1(LogIntent logIntent, Function0 function0) {
        super(0);
        this.$intent = logIntent;
        this.$messageBuilder = function0;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        return x.Q(this.$intent.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + ((String) this.$messageBuilder.invoke());
    }
}
