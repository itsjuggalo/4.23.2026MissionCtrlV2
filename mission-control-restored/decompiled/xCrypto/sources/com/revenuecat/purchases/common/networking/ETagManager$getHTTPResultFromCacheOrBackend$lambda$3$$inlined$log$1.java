package com.revenuecat.purchases.common.networking;

import X2.x;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.strings.NetworkStrings;
import java.util.Arrays;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class ETagManager$getHTTPResultFromCacheOrBackend$lambda$3$$inlined$log$1 extends s implements Function0 {
    final /* synthetic */ LogIntent $intent;
    final /* synthetic */ HTTPResult $resultFromBackend$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ETagManager$getHTTPResultFromCacheOrBackend$lambda$3$$inlined$log$1(LogIntent logIntent, HTTPResult hTTPResult) {
        super(0);
        this.$intent = logIntent;
        this.$resultFromBackend$inlined = hTTPResult;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        StringBuilder sb = new StringBuilder();
        sb.append(x.Q(this.$intent.getEmojiList(), "", null, null, 0, null, null, 62, null));
        sb.append(' ');
        String str = String.format(NetworkStrings.ETAG_CALL_ALREADY_RETRIED, Arrays.copyOf(new Object[]{this.$resultFromBackend$inlined}, 1));
        r.e(str, "format(this, *args)");
        sb.append(str);
        return sb.toString();
    }
}
