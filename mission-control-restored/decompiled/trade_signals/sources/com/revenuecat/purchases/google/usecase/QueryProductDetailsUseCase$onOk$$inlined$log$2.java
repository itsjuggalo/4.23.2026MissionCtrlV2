package com.revenuecat.purchases.google.usecase;

import R0.C0839v;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.strings.OfferingStrings;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.AbstractC2306v;
import p5.z;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "invoke", "com/revenuecat/purchases/common/LogWrapperKt$log$fullMessageBuilder$1"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class QueryProductDetailsUseCase$onOk$$inlined$log$2 extends AbstractC2306v implements Function0 {
    final /* synthetic */ LogIntent $intent;
    final /* synthetic */ C0839v $received$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QueryProductDetailsUseCase$onOk$$inlined$log$2(LogIntent logIntent, C0839v c0839v) {
        super(0);
        this.$intent = logIntent;
        this.$received$inlined = c0839v;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        StringBuilder sb = new StringBuilder();
        sb.append(z.h0(this.$intent.getEmojiList(), "", null, null, 0, null, null, 62, null));
        sb.append(' ');
        List listA = this.$received$inlined.a();
        AbstractC2304t.e(listA, "received.productDetailsList");
        String str = String.format(OfferingStrings.RETRIEVED_PRODUCTS, Arrays.copyOf(new Object[]{z.h0(listA, null, null, null, 0, null, QueryProductDetailsUseCase$onOk$2$1.INSTANCE, 31, null)}, 1));
        AbstractC2304t.e(str, "format(...)");
        sb.append(str);
        return sb.toString();
    }
}
