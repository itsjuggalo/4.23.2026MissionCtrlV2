package com.revenuecat.purchases;

import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.models.GoogleReplacementMode;
import com.revenuecat.purchases.models.PurchasingData;
import com.revenuecat.purchases.strings.PurchaseStrings;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.AbstractC2306v;
import p5.z;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "invoke", "com/revenuecat/purchases/common/LogWrapperKt$log$fullMessageBuilder$1"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class PurchasesOrchestrator$startProductChange$$inlined$log$1 extends AbstractC2306v implements Function0 {
    final /* synthetic */ GoogleReplacementMode $googleReplacementMode$inlined;
    final /* synthetic */ LogIntent $intent;
    final /* synthetic */ String $oldProductId$inlined;
    final /* synthetic */ PresentedOfferingContext $presentedOfferingContext$inlined;
    final /* synthetic */ PurchasingData $purchasingData$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PurchasesOrchestrator$startProductChange$$inlined$log$1(LogIntent logIntent, PurchasingData purchasingData, PresentedOfferingContext presentedOfferingContext, String str, GoogleReplacementMode googleReplacementMode) {
        super(0);
        this.$intent = logIntent;
        this.$purchasingData$inlined = purchasingData;
        this.$presentedOfferingContext$inlined = presentedOfferingContext;
        this.$oldProductId$inlined = str;
        this.$googleReplacementMode$inlined = googleReplacementMode;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        String str;
        String offeringIdentifier;
        StringBuilder sb = new StringBuilder();
        sb.append(z.h0(this.$intent.getEmojiList(), "", null, null, 0, null, null, 62, null));
        sb.append(' ');
        StringBuilder sb2 = new StringBuilder();
        sb2.append(' ');
        sb2.append(this.$purchasingData$inlined);
        sb2.append(' ');
        PresentedOfferingContext presentedOfferingContext = this.$presentedOfferingContext$inlined;
        if (presentedOfferingContext == null || (offeringIdentifier = presentedOfferingContext.getOfferingIdentifier()) == null) {
            str = null;
        } else {
            str = PurchaseStrings.OFFERING + offeringIdentifier;
        }
        sb2.append(str);
        sb2.append(" oldProductId: ");
        sb2.append(this.$oldProductId$inlined);
        sb2.append(" googleReplacementMode ");
        sb2.append(this.$googleReplacementMode$inlined);
        String str2 = String.format(PurchaseStrings.PRODUCT_CHANGE_STARTED, Arrays.copyOf(new Object[]{sb2.toString()}, 1));
        AbstractC2304t.e(str2, "format(...)");
        sb.append(str2);
        return sb.toString();
    }
}
