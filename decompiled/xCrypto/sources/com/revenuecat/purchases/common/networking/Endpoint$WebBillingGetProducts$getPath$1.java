package com.revenuecat.purchases.common.networking;

import android.net.Uri;
import i3.k;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class Endpoint$WebBillingGetProducts$getPath$1 extends s implements k {
    public static final Endpoint$WebBillingGetProducts$getPath$1 INSTANCE = new Endpoint$WebBillingGetProducts$getPath$1();

    public Endpoint$WebBillingGetProducts$getPath$1() {
        super(1);
    }

    @Override // i3.k
    public final CharSequence invoke(String it) {
        r.f(it, "it");
        String strEncode = Uri.encode(it);
        r.e(strEncode, "encode(it)");
        return strEncode;
    }
}
