package com.revenuecat.purchases.google;

import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0005\u001a\u00020\u0004*\u00020\u0000H\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/android/billingclient/api/a;", "", "toHumanReadableDescription", "(Lcom/android/billingclient/api/a;)Ljava/lang/String;", "", "isSuccessful", "(Lcom/android/billingclient/api/a;)Z", "purchases_defaultsRelease"}, k = 2, mv = {1, 8, 0})
public final class BillingResultExtensionsKt {
    public static final boolean isSuccessful(com.android.billingclient.api.a aVar) {
        AbstractC2304t.f(aVar, "<this>");
        return aVar.c() == 0;
    }

    public static final String toHumanReadableDescription(com.android.billingclient.api.a aVar) {
        AbstractC2304t.f(aVar, "<this>");
        return "DebugMessage: " + aVar.a() + ". ErrorCode: " + ErrorsKt.getBillingResponseCodeName(aVar.c()) + ". SubResponseCode: " + ErrorsKt.getOnPurchasesUpdatedSubResponseCodeName(aVar.b()) + com.amazon.a.a.o.c.a.b.f14112a;
    }
}
