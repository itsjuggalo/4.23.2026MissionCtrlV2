package com.revenuecat.purchases.google;

import com.android.billingclient.api.c;
import com.revenuecat.purchases.ReplacementMode;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.ReplaceProductInfo;
import com.revenuecat.purchases.models.GoogleReplacementMode;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class BillingFlowParamsExtensionsKt {
    public static final void setUpgradeInfo(c.a aVar, ReplaceProductInfo replaceProductInfo) {
        r.f(aVar, "<this>");
        r.f(replaceProductInfo, "replaceProductInfo");
        c.C0177c.a aVarA = c.C0177c.a();
        aVarA.b(replaceProductInfo.getOldPurchase().getPurchaseToken());
        ReplacementMode replacementMode = replaceProductInfo.getReplacementMode();
        if (replacementMode != null) {
            GoogleReplacementMode googleReplacementMode = replacementMode instanceof GoogleReplacementMode ? (GoogleReplacementMode) replacementMode : null;
            if (googleReplacementMode == null) {
                LogUtilsKt.errorLog$default("Got non-Google replacement mode", null, 2, null);
            } else {
                aVarA.d(googleReplacementMode.getPlayBillingClientMode());
            }
        }
        r.e(aVarA, "newBuilder().apply {\n   …        }\n        }\n    }");
        aVar.e(aVarA.a());
    }
}
