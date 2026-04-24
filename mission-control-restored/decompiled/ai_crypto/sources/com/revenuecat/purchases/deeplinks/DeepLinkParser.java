package com.revenuecat.purchases.deeplinks;

import Z5.u;
import android.net.Uri;
import com.revenuecat.purchases.WebPurchaseRedemption;
import com.revenuecat.purchases.common.LogUtilsKt;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class DeepLinkParser {
    public static final DeepLinkParser INSTANCE = new DeepLinkParser();
    private static final String REDEEM_WEB_PURCHASE_HOST = "redeem_web_purchase";

    private DeepLinkParser() {
    }

    public final WebPurchaseRedemption parseWebPurchaseRedemption(Uri data) {
        r.f(data, "data");
        if (r.b(data.getHost(), REDEEM_WEB_PURCHASE_HOST)) {
            String queryParameter = data.getQueryParameter("redemption_token");
            if (queryParameter != null && !u.P(queryParameter)) {
                return new WebPurchaseRedemption(queryParameter);
            }
            LogUtilsKt.debugLog("Redemption token is missing web redemption deep link. Ignoring.");
            return null;
        }
        LogUtilsKt.debugLog("Unrecognized deep link host: " + data.getHost() + ". Ignoring");
        return null;
    }
}
