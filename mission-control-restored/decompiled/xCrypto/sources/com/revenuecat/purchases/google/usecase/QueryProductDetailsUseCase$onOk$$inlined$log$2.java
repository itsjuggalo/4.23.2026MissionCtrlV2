package com.revenuecat.purchases.google.usecase;

import X2.x;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.strings.OfferingStrings;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes3.dex */
public final class QueryProductDetailsUseCase$onOk$$inlined$log$2 extends s implements Function0 {
    final /* synthetic */ LogIntent $intent;
    final /* synthetic */ List $received$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QueryProductDetailsUseCase$onOk$$inlined$log$2(LogIntent logIntent, List list) {
        super(0);
        this.$intent = logIntent;
        this.$received$inlined = list;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        StringBuilder sb = new StringBuilder();
        sb.append(x.Q(this.$intent.getEmojiList(), "", null, null, 0, null, null, 62, null));
        sb.append(' ');
        String str = String.format(OfferingStrings.RETRIEVED_PRODUCTS, Arrays.copyOf(new Object[]{x.Q(this.$received$inlined, null, null, null, 0, null, QueryProductDetailsUseCase$onOk$2$1.INSTANCE, 31, null)}, 1));
        r.e(str, "format(this, *args)");
        sb.append(str);
        return sb.toString();
    }
}
