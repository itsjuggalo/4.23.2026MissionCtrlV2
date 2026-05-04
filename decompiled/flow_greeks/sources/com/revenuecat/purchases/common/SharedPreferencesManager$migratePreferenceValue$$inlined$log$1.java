package com.revenuecat.purchases.common;

import dd.a0;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.v;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "invoke", "com/revenuecat/purchases/common/LogWrapperKt$log$fullMessageBuilder$1"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class SharedPreferencesManager$migratePreferenceValue$$inlined$log$1 extends v implements Function0 {
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
        StringBuilder sb2 = new StringBuilder();
        sb2.append(a0.i0(this.$intent.getEmojiList(), "", null, null, 0, null, null, 62, null));
        sb2.append(' ');
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Unknown preference type for key ");
        sb3.append(this.$key$inlined);
        sb3.append(": ");
        Object obj = this.$value$inlined;
        sb3.append(obj != null ? obj.getClass().getSimpleName() : null);
        sb2.append(sb3.toString());
        return sb2.toString();
    }
}
