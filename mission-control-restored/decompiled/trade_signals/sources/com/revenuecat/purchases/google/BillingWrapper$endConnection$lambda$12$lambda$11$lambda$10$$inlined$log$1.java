package com.revenuecat.purchases.google;

import R0.AbstractC0806c;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.strings.BillingStrings;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.AbstractC2306v;
import p5.z;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "invoke", "com/revenuecat/purchases/common/LogWrapperKt$log$fullMessageBuilder$1"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class BillingWrapper$endConnection$lambda$12$lambda$11$lambda$10$$inlined$log$1 extends AbstractC2306v implements Function0 {
    final /* synthetic */ LogIntent $intent;
    final /* synthetic */ AbstractC0806c $it$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BillingWrapper$endConnection$lambda$12$lambda$11$lambda$10$$inlined$log$1(LogIntent logIntent, AbstractC0806c abstractC0806c) {
        super(0);
        this.$intent = logIntent;
        this.$it$inlined = abstractC0806c;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        StringBuilder sb = new StringBuilder();
        sb.append(z.h0(this.$intent.getEmojiList(), "", null, null, 0, null, null, 62, null));
        sb.append(' ');
        String str = String.format(BillingStrings.BILLING_CLIENT_ENDING, Arrays.copyOf(new Object[]{this.$it$inlined}, 1));
        AbstractC2304t.e(str, "format(...)");
        sb.append(str);
        return sb.toString();
    }
}
