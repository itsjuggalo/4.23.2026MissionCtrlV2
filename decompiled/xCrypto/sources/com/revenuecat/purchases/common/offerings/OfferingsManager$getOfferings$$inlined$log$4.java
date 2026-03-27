package com.revenuecat.purchases.common.offerings;

import X2.x;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.strings.OfferingStrings;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class OfferingsManager$getOfferings$$inlined$log$4 extends s implements Function0 {
    final /* synthetic */ boolean $appInBackground$inlined;
    final /* synthetic */ LogIntent $intent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfferingsManager$getOfferings$$inlined$log$4(LogIntent logIntent, boolean z4) {
        super(0);
        this.$intent = logIntent;
        this.$appInBackground$inlined = z4;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        StringBuilder sb = new StringBuilder();
        sb.append(x.Q(this.$intent.getEmojiList(), "", null, null, 0, null, null, 62, null));
        sb.append(' ');
        sb.append(this.$appInBackground$inlined ? OfferingStrings.OFFERINGS_STALE_UPDATING_IN_BACKGROUND : OfferingStrings.OFFERINGS_STALE_UPDATING_IN_FOREGROUND);
        return sb.toString();
    }
}
