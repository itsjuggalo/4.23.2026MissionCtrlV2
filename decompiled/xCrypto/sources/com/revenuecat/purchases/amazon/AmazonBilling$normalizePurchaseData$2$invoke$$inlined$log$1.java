package com.revenuecat.purchases.amazon;

import X2.x;
import com.revenuecat.purchases.common.LogIntent;
import java.util.Arrays;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class AmazonBilling$normalizePurchaseData$2$invoke$$inlined$log$1 extends s implements Function0 {
    final /* synthetic */ LogIntent $intent;
    final /* synthetic */ JSONObject $response$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmazonBilling$normalizePurchaseData$2$invoke$$inlined$log$1(LogIntent logIntent, JSONObject jSONObject) {
        super(0);
        this.$intent = logIntent;
        this.$response$inlined = jSONObject;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        StringBuilder sb = new StringBuilder();
        sb.append(x.Q(this.$intent.getEmojiList(), "", null, null, 0, null, null, 62, null));
        sb.append(' ');
        String str = String.format(AmazonStrings.RECEIPT_DATA_RECEIVED, Arrays.copyOf(new Object[]{this.$response$inlined.toString()}, 1));
        r.e(str, "format(this, *args)");
        sb.append(str);
        return sb.toString();
    }
}
