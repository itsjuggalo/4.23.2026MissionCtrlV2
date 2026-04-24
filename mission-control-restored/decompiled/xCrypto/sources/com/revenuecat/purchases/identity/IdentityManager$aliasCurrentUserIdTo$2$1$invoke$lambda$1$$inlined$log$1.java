package com.revenuecat.purchases.identity;

import X2.x;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.strings.IdentityStrings;
import java.util.Arrays;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes3.dex */
public final class IdentityManager$aliasCurrentUserIdTo$2$1$invoke$lambda$1$$inlined$log$1 extends s implements Function0 {
    final /* synthetic */ LogIntent $intent;
    final /* synthetic */ String $newAppUserID$inlined;
    final /* synthetic */ String $oldAppUserID$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IdentityManager$aliasCurrentUserIdTo$2$1$invoke$lambda$1$$inlined$log$1(LogIntent logIntent, String str, String str2) {
        super(0);
        this.$intent = logIntent;
        this.$oldAppUserID$inlined = str;
        this.$newAppUserID$inlined = str2;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        StringBuilder sb = new StringBuilder();
        sb.append(x.Q(this.$intent.getEmojiList(), "", null, null, 0, null, null, 62, null));
        sb.append(' ');
        String str = String.format(IdentityStrings.ALIAS_OLD_USER_ID_TO_CURRENT_SUCCESSFUL, Arrays.copyOf(new Object[]{this.$oldAppUserID$inlined, this.$newAppUserID$inlined}, 2));
        r.e(str, "format(this, *args)");
        sb.append(str);
        return sb.toString();
    }
}
