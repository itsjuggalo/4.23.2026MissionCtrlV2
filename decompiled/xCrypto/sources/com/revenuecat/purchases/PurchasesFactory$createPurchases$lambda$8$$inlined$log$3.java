package com.revenuecat.purchases;

import X2.x;
import com.revenuecat.purchases.common.AppConfig;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.strings.ConfigureStrings;
import java.util.Arrays;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class PurchasesFactory$createPurchases$lambda$8$$inlined$log$3 extends s implements Function0 {
    final /* synthetic */ AppConfig $appConfig$inlined;
    final /* synthetic */ LogIntent $intent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PurchasesFactory$createPurchases$lambda$8$$inlined$log$3(LogIntent logIntent, AppConfig appConfig) {
        super(0);
        this.$intent = logIntent;
        this.$appConfig$inlined = appConfig;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        StringBuilder sb = new StringBuilder();
        sb.append(x.Q(this.$intent.getEmojiList(), "", null, null, 0, null, null, 62, null));
        sb.append(' ');
        String str = String.format(ConfigureStrings.PACKAGE_NAME, Arrays.copyOf(new Object[]{this.$appConfig$inlined.getPackageName()}, 1));
        r.e(str, "format(this, *args)");
        sb.append(str);
        return sb.toString();
    }
}
