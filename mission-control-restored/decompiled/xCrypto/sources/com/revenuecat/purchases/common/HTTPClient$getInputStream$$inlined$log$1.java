package com.revenuecat.purchases.common;

import X2.x;
import com.revenuecat.purchases.strings.NetworkStrings;
import java.util.Arrays;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class HTTPClient$getInputStream$$inlined$log$1 extends s implements Function0 {
    final /* synthetic */ Exception $e$inlined;
    final /* synthetic */ LogIntent $intent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HTTPClient$getInputStream$$inlined$log$1(LogIntent logIntent, Exception exc) {
        super(0);
        this.$intent = logIntent;
        this.$e$inlined = exc;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        StringBuilder sb = new StringBuilder();
        sb.append(x.Q(this.$intent.getEmojiList(), "", null, null, 0, null, null, 62, null));
        sb.append(' ');
        String str = String.format(NetworkStrings.PROBLEM_CONNECTING, Arrays.copyOf(new Object[]{this.$e$inlined.getMessage()}, 1));
        r.e(str, "format(this, *args)");
        sb.append(str);
        return sb.toString();
    }
}
