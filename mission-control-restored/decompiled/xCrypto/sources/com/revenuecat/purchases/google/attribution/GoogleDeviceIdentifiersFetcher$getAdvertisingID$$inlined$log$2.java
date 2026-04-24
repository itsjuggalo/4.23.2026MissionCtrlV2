package com.revenuecat.purchases.google.attribution;

import X2.x;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.strings.AttributionStrings;
import java.util.Arrays;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import z1.C1990h;

/* JADX INFO: loaded from: classes3.dex */
public final class GoogleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$2 extends s implements Function0 {
    final /* synthetic */ C1990h $e$inlined;
    final /* synthetic */ LogIntent $intent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoogleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$2(LogIntent logIntent, C1990h c1990h) {
        super(0);
        this.$intent = logIntent;
        this.$e$inlined = c1990h;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        StringBuilder sb = new StringBuilder();
        sb.append(x.Q(this.$intent.getEmojiList(), "", null, null, 0, null, null, 62, null));
        sb.append(' ');
        String str = String.format(AttributionStrings.GOOGLE_PLAY_SERVICES_NOT_INSTALLED_FETCHING_ADVERTISING_IDENTIFIER, Arrays.copyOf(new Object[]{this.$e$inlined.getLocalizedMessage()}, 1));
        r.e(str, "format(this, *args)");
        sb.append(str);
        return sb.toString();
    }
}
