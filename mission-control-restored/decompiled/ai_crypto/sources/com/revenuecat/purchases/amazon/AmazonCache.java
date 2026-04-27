package com.revenuecat.purchases.amazon;

import E5.j;
import E5.k;
import F5.J;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.utils.JSONObjectExtensionsKt;
import java.util.Arrays;
import java.util.Map;
import kotlin.jvm.internal.r;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class AmazonCache {
    private final j amazonPostedTokensKey$delegate;
    private final DeviceCache deviceCache;

    public AmazonCache(DeviceCache deviceCache) {
        r.f(deviceCache, "deviceCache");
        this.deviceCache = deviceCache;
        this.amazonPostedTokensKey$delegate = k.b(new AmazonCache$amazonPostedTokensKey$2(this));
    }

    public final synchronized void addSuccessfullyPostedToken(String token) {
        r.f(token, "token");
        this.deviceCache.addSuccessfullyPostedToken(token);
    }

    public final synchronized void cacheSkusByToken(Map<String, String> receiptsToSkus) {
        r.f(receiptsToSkus, "receiptsToSkus");
        LogIntent logIntent = LogIntent.DEBUG;
        String str = String.format(AmazonStrings.CACHING_RECEIPT_TERM_SKUS, Arrays.copyOf(new Object[]{receiptsToSkus}, 1));
        r.e(str, "format(this, *args)");
        LogWrapperKt.log(logIntent, str);
        JSONObject jSONObject = new JSONObject(J.k(getReceiptSkus(), receiptsToSkus));
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("receiptsToSkus", jSONObject);
        DeviceCache deviceCache = this.deviceCache;
        String amazonPostedTokensKey$purchases_defaultsRelease = getAmazonPostedTokensKey$purchases_defaultsRelease();
        String string = jSONObject2.toString();
        r.e(string, "jsonToCache.toString()");
        deviceCache.putString(amazonPostedTokensKey$purchases_defaultsRelease, string);
    }

    public final String getAmazonPostedTokensKey$purchases_defaultsRelease() {
        return (String) this.amazonPostedTokensKey$delegate.getValue();
    }

    public final synchronized Map<String, String> getReceiptSkus() {
        Map<String, String> mapE;
        try {
            JSONObject jSONObjectOrNull = this.deviceCache.getJSONObjectOrNull(getAmazonPostedTokensKey$purchases_defaultsRelease());
            JSONObject jSONObject = jSONObjectOrNull != null ? jSONObjectOrNull.getJSONObject("receiptsToSkus") : null;
            if (jSONObject == null || (mapE = JSONObjectExtensionsKt.toMap$default(jSONObject, false, 1, null)) == null) {
                mapE = J.e();
            }
        } catch (Throwable th) {
            throw th;
        }
        return mapE;
    }
}
