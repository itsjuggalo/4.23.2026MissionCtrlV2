package com.revenuecat.purchases.amazon.attribution;

import X2.x;
import android.provider.Settings;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.strings.AttributionStrings;
import java.util.Arrays;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class AmazonDeviceIdentifiersFetcher$getDeviceIdentifiers$$inlined$log$1 extends s implements Function0 {
    final /* synthetic */ Settings.SettingNotFoundException $e$inlined;
    final /* synthetic */ LogIntent $intent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmazonDeviceIdentifiersFetcher$getDeviceIdentifiers$$inlined$log$1(LogIntent logIntent, Settings.SettingNotFoundException settingNotFoundException) {
        super(0);
        this.$intent = logIntent;
        this.$e$inlined = settingNotFoundException;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        StringBuilder sb = new StringBuilder();
        sb.append(x.Q(this.$intent.getEmojiList(), "", null, null, 0, null, null, 62, null));
        sb.append(' ');
        String str = String.format(AttributionStrings.AMAZON_COULD_NOT_GET_ADID, Arrays.copyOf(new Object[]{this.$e$inlined.getLocalizedMessage()}, 1));
        r.e(str, "format(this, *args)");
        sb.append(str);
        return sb.toString();
    }
}
