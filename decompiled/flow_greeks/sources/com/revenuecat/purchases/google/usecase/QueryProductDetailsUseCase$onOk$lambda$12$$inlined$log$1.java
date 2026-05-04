package com.revenuecat.purchases.google.usecase;

import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.strings.OfferingStrings;
import d3.x;
import dd.a0;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "invoke", "com/revenuecat/purchases/common/LogWrapperKt$log$fullMessageBuilder$1"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class QueryProductDetailsUseCase$onOk$lambda$12$$inlined$log$1 extends v implements Function0 {
    final /* synthetic */ LogIntent $intent;
    final /* synthetic */ x $it$inlined;
    final /* synthetic */ QueryProductDetailsUseCase this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QueryProductDetailsUseCase$onOk$lambda$12$$inlined$log$1(LogIntent logIntent, x xVar, QueryProductDetailsUseCase queryProductDetailsUseCase) {
        super(0);
        this.$intent = logIntent;
        this.$it$inlined = xVar;
        this.this$0 = queryProductDetailsUseCase;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(a0.i0(this.$intent.getEmojiList(), "", null, null, 0, null, null, 62, null));
        sb2.append(' ');
        String str = String.format(OfferingStrings.LIST_UNFETCHED_PRODUCTS, Arrays.copyOf(new Object[]{this.$it$inlined.a(), this.$it$inlined.b(), this.this$0.convertUnfetchedProductStatusCodeToString(this.$it$inlined.d()), this.$it$inlined.c()}, 4));
        t.e(str, "format(...)");
        sb2.append(str);
        return sb2.toString();
    }
}
