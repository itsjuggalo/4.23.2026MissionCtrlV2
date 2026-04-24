package com.revenuecat.purchases.subscriberattributes.caching;

import X2.x;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.strings.AttributionStrings;
import java.util.Arrays;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes3.dex */
public final class SubscriberAttributesCache$filterUnsynced$lambda$10$$inlined$log$1 extends s implements Function0 {
    final /* synthetic */ String $appUserID$inlined;
    final /* synthetic */ LogIntent $intent;
    final /* synthetic */ Map $unsyncedAttributesByKey$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubscriberAttributesCache$filterUnsynced$lambda$10$$inlined$log$1(LogIntent logIntent, Map map, String str) {
        super(0);
        this.$intent = logIntent;
        this.$unsyncedAttributesByKey$inlined = map;
        this.$appUserID$inlined = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        StringBuilder sb = new StringBuilder();
        sb.append(x.Q(this.$intent.getEmojiList(), "", null, null, 0, null, null, 62, null));
        sb.append(' ');
        StringBuilder sb2 = new StringBuilder();
        String str = String.format(AttributionStrings.UNSYNCED_ATTRIBUTES_COUNT, Arrays.copyOf(new Object[]{Integer.valueOf(this.$unsyncedAttributesByKey$inlined.size()), this.$appUserID$inlined}, 2));
        r.e(str, "format(this, *args)");
        sb2.append(str);
        sb2.append(!this.$unsyncedAttributesByKey$inlined.isEmpty() ? x.Q(this.$unsyncedAttributesByKey$inlined.values(), "\n", null, null, 0, null, null, 62, null) : "");
        sb.append(sb2.toString());
        return sb.toString();
    }
}
