package com.revenuecat.purchases.google.usecase;

import X2.x;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.strings.OfferingStrings;
import java.util.Arrays;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes3.dex */
public final class QueryProductDetailsUseCase$onOk$$inlined$log$1 extends s implements Function0 {
    final /* synthetic */ LogIntent $intent;
    final /* synthetic */ QueryProductDetailsUseCase this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QueryProductDetailsUseCase$onOk$$inlined$log$1(LogIntent logIntent, QueryProductDetailsUseCase queryProductDetailsUseCase) {
        super(0);
        this.$intent = logIntent;
        this.this$0 = queryProductDetailsUseCase;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        StringBuilder sb = new StringBuilder();
        sb.append(x.Q(this.$intent.getEmojiList(), "", null, null, 0, null, null, 62, null));
        sb.append(' ');
        String str = String.format(OfferingStrings.FETCHING_PRODUCTS_FINISHED, Arrays.copyOf(new Object[]{x.Q(this.this$0.useCaseParams.getProductIds(), null, null, null, 0, null, null, 63, null)}, 1));
        r.e(str, "format(this, *args)");
        sb.append(str);
        return sb.toString();
    }
}
