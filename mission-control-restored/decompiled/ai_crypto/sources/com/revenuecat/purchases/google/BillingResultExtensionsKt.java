package com.revenuecat.purchases.google;

import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class BillingResultExtensionsKt {
    public static final boolean isSuccessful(com.android.billingclient.api.d dVar) {
        r.f(dVar, "<this>");
        return dVar.b() == 0;
    }

    public static final String toHumanReadableDescription(com.android.billingclient.api.d dVar) {
        r.f(dVar, "<this>");
        return "DebugMessage: " + dVar.a() + ". ErrorCode: " + ErrorsKt.getBillingResponseCodeName(dVar.b()) + com.amazon.a.a.o.c.a.b.f10001a;
    }
}
