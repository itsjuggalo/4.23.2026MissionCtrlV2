package com.revenuecat.purchases.common;

import X2.x;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class SharedPreferencesManager$getRevenueCatKeysToMigrate$$inlined$log$1 extends s implements Function0 {
    final /* synthetic */ LogIntent $intent;
    final /* synthetic */ List $revenueCatKeys$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesManager$getRevenueCatKeysToMigrate$$inlined$log$1(LogIntent logIntent, List list) {
        super(0);
        this.$intent = logIntent;
        this.$revenueCatKeys$inlined = list;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        StringBuilder sb = new StringBuilder();
        sb.append(x.Q(this.$intent.getEmojiList(), "", null, null, 0, null, null, 62, null));
        sb.append(' ');
        sb.append("Found " + this.$revenueCatKeys$inlined.size() + " RevenueCat keys to migrate: " + this.$revenueCatKeys$inlined);
        return sb.toString();
    }
}
