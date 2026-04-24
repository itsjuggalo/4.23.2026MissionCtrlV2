package com.revenuecat.purchases.google;

import R0.C0818i;
import com.revenuecat.purchases.ReplacementMode;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.ReplaceProductInfo;
import com.revenuecat.purchases.models.GoogleReplacementMode;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"LR0/i$a;", "Lcom/revenuecat/purchases/common/ReplaceProductInfo;", "replaceProductInfo", "Lo5/H;", "setUpgradeInfo", "(LR0/i$a;Lcom/revenuecat/purchases/common/ReplaceProductInfo;)V", "purchases_defaultsRelease"}, k = 2, mv = {1, 8, 0})
public final class BillingFlowParamsExtensionsKt {
    public static final void setUpgradeInfo(C0818i.a aVar, ReplaceProductInfo replaceProductInfo) {
        AbstractC2304t.f(aVar, "<this>");
        AbstractC2304t.f(replaceProductInfo, "replaceProductInfo");
        C0818i.c.a aVarA = C0818i.c.a();
        aVarA.b(replaceProductInfo.getOldPurchase().getPurchaseToken());
        ReplacementMode replacementMode = replaceProductInfo.getReplacementMode();
        if (replacementMode != null) {
            GoogleReplacementMode googleReplacementMode = replacementMode instanceof GoogleReplacementMode ? (GoogleReplacementMode) replacementMode : null;
            if (googleReplacementMode == null) {
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Got non-Google replacement mode", null);
            } else {
                aVarA.d(googleReplacementMode.getPlayBillingClientMode());
            }
        }
        AbstractC2304t.e(aVarA, "newBuilder().apply {\n   …        }\n        }\n    }");
        aVar.e(aVarA.a());
    }
}
