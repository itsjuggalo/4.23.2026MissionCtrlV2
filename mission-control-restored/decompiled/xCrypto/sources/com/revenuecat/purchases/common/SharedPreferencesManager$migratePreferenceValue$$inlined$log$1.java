package com.revenuecat.purchases.common;

import X2.x;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class SharedPreferencesManager$migratePreferenceValue$$inlined$log$1 extends s implements Function0 {
    final /* synthetic */ LogIntent $intent;
    final /* synthetic */ String $key$inlined;
    final /* synthetic */ Object $value$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesManager$migratePreferenceValue$$inlined$log$1(LogIntent logIntent, String str, Object obj) {
        super(0);
        this.$intent = logIntent;
        this.$key$inlined = str;
        this.$value$inlined = obj;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        StringBuilder sb = new StringBuilder();
        sb.append(x.Q(this.$intent.getEmojiList(), "", null, null, 0, null, null, 62, null));
        sb.append(' ');
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Unknown preference type for key ");
        sb2.append(this.$key$inlined);
        sb2.append(": ");
        Object obj = this.$value$inlined;
        sb2.append(obj != null ? obj.getClass().getSimpleName() : null);
        sb.append(sb2.toString());
        return sb.toString();
    }
}
