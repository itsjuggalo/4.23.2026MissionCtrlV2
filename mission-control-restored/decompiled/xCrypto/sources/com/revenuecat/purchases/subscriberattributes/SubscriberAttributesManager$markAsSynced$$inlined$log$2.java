package com.revenuecat.purchases.subscriberattributes;

import X2.x;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.strings.AttributionStrings;
import java.util.Arrays;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes3.dex */
public final class SubscriberAttributesManager$markAsSynced$$inlined$log$2 extends s implements Function0 {
    final /* synthetic */ String $appUserID$inlined;
    final /* synthetic */ Map $attributesToMarkAsSynced$inlined;
    final /* synthetic */ LogIntent $intent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubscriberAttributesManager$markAsSynced$$inlined$log$2(LogIntent logIntent, String str, Map map) {
        super(0);
        this.$intent = logIntent;
        this.$appUserID$inlined = str;
        this.$attributesToMarkAsSynced$inlined = map;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        StringBuilder sb = new StringBuilder();
        sb.append(x.Q(this.$intent.getEmojiList(), "", null, null, 0, null, null, 62, null));
        sb.append(' ');
        StringBuilder sb2 = new StringBuilder();
        String str = String.format(AttributionStrings.MARKING_ATTRIBUTES_SYNCED, Arrays.copyOf(new Object[]{this.$appUserID$inlined}, 1));
        r.e(str, "format(this, *args)");
        sb2.append(str);
        sb2.append(x.Q(this.$attributesToMarkAsSynced$inlined.values(), "\n", null, null, 0, null, null, 62, null));
        sb.append(sb2.toString());
        return sb.toString();
    }
}
