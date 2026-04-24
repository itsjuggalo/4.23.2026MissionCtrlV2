package com.revenuecat.purchases.common.caching;

import X2.x;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.UtilsKt;
import com.revenuecat.purchases.strings.ReceiptStrings;
import java.util.Arrays;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class DeviceCache$addSuccessfullyPostedToken$$inlined$log$1 extends s implements Function0 {
    final /* synthetic */ LogIntent $intent;
    final /* synthetic */ String $token$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceCache$addSuccessfullyPostedToken$$inlined$log$1(LogIntent logIntent, String str) {
        super(0);
        this.$intent = logIntent;
        this.$token$inlined = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        StringBuilder sb = new StringBuilder();
        sb.append(x.Q(this.$intent.getEmojiList(), "", null, null, 0, null, null, 62, null));
        sb.append(' ');
        String str = this.$token$inlined;
        String str2 = String.format(ReceiptStrings.SAVING_TOKENS_WITH_HASH, Arrays.copyOf(new Object[]{str, UtilsKt.sha1(str)}, 2));
        r.e(str2, "format(this, *args)");
        sb.append(str2);
        return sb.toString();
    }
}
