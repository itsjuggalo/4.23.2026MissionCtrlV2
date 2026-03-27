package com.revenuecat.purchases.google;

import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.models.GooglePurchasingData;
import com.revenuecat.purchases.strings.PurchaseStrings;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.AbstractC2306v;
import p5.z;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "invoke", "com/revenuecat/purchases/common/LogWrapperKt$log$fullMessageBuilder$1"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class BillingWrapper$makePurchaseAsync$$inlined$log$2 extends AbstractC2306v implements Function0 {
    final /* synthetic */ GooglePurchasingData $googlePurchasingData$inlined;
    final /* synthetic */ LogIntent $intent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BillingWrapper$makePurchaseAsync$$inlined$log$2(LogIntent logIntent, GooglePurchasingData googlePurchasingData) {
        super(0);
        this.$intent = logIntent;
        this.$googlePurchasingData$inlined = googlePurchasingData;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        StringBuilder sb = new StringBuilder();
        sb.append(z.h0(this.$intent.getEmojiList(), "", null, null, 0, null, null, 62, null));
        sb.append(' ');
        String str = String.format(PurchaseStrings.PURCHASING_PRODUCT, Arrays.copyOf(new Object[]{this.$googlePurchasingData$inlined.getProductId()}, 1));
        AbstractC2304t.e(str, "format(...)");
        sb.append(str);
        return sb.toString();
    }
}
