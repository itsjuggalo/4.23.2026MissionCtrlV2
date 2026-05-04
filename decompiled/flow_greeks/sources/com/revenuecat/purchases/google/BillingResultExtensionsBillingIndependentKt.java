package com.revenuecat.purchases.google;

import kotlin.Metadata;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0005\u001a\u00020\u0001*\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/android/billingclient/api/a;", "", "toHumanReadableDescription", "(Lcom/android/billingclient/api/a;)Ljava/lang/String;", "", "getOnPurchasesUpdatedSubResponseCodeName", "(I)Ljava/lang/String;", "purchases_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BillingResultExtensionsBillingIndependentKt {
    private static final String getOnPurchasesUpdatedSubResponseCodeName(int i10) {
        if (i10 == 0) {
            return "NO_APPLICABLE_SUB_RESPONSE_CODE";
        }
        if (i10 == 1) {
            return "PAYMENT_DECLINED_DUE_TO_INSUFFICIENT_FUNDS";
        }
        if (i10 == 2) {
            return "USER_INELIGIBLE";
        }
        return "UNKNOWN_SUB_RESPONSE_CODE (" + i10 + ')';
    }

    public static final String toHumanReadableDescription(com.android.billingclient.api.a aVar) {
        t.f(aVar, "<this>");
        return "DebugMessage: " + aVar.a() + ". ErrorCode: " + ErrorsKt.getBillingResponseCodeName(aVar.c()) + ". SubResponseCode: " + getOnPurchasesUpdatedSubResponseCodeName(aVar.b()) + com.amazon.a.a.o.c.a.b.f4610a;
    }
}
