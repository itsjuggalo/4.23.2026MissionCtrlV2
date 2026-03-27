package com.revenuecat.purchases.common.networking;

import B5.k;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.AbstractC2306v;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class Endpoint$WebBillingGetProducts$getPath$1 extends AbstractC2306v implements k {
    public static final Endpoint$WebBillingGetProducts$getPath$1 INSTANCE = new Endpoint$WebBillingGetProducts$getPath$1();

    public Endpoint$WebBillingGetProducts$getPath$1() {
        super(1);
    }

    @Override // B5.k
    public final CharSequence invoke(String it) {
        AbstractC2304t.f(it, "it");
        String strEncode = Uri.encode(it);
        AbstractC2304t.e(strEncode, "encode(it)");
        return strEncode;
    }
}
