package com.revenuecat.purchases.google.usecase;

import i3.k;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes3.dex */
public final class QueryProductDetailsUseCase$onOk$2$1 extends s implements k {
    public static final QueryProductDetailsUseCase$onOk$2$1 INSTANCE = new QueryProductDetailsUseCase$onOk$2$1();

    public QueryProductDetailsUseCase$onOk$2$1() {
        super(1);
    }

    @Override // i3.k
    public final CharSequence invoke(com.android.billingclient.api.f it) {
        r.f(it, "it");
        String string = it.toString();
        r.e(string, "it.toString()");
        return string;
    }
}
