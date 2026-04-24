package com.revenuecat.purchases.common.networking;

import X2.K;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.common.CustomerInfoFactory;
import com.revenuecat.purchases.utils.JSONObjectExtensionsKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.r;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class PostReceiptResponseKt {
    public static final PostReceiptResponse buildPostReceiptResponse(HTTPResult result) {
        r.f(result, "result");
        CustomerInfo customerInfoBuildCustomerInfo = CustomerInfoFactory.INSTANCE.buildCustomerInfo(result);
        JSONObject jSONObjectOptJSONObject = result.getBody().optJSONObject("purchased_products");
        LinkedHashMap linkedHashMap = null;
        if (jSONObjectOptJSONObject != null) {
            Map map$default = JSONObjectExtensionsKt.toMap$default(jSONObjectOptJSONObject, false, 1, null);
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(K.b(map$default.size()));
            for (Map.Entry entry : map$default.entrySet()) {
                Object key = entry.getKey();
                JSONObject jSONObject = (JSONObject) entry.getValue();
                if (!jSONObject.has("should_consume")) {
                    jSONObject = null;
                }
                linkedHashMap2.put(key, new PostReceiptProductInfo(jSONObject != null ? Boolean.valueOf(jSONObject.optBoolean("should_consume")) : null));
            }
            linkedHashMap = linkedHashMap2;
        }
        return new PostReceiptResponse(customerInfoBuildCustomerInfo, linkedHashMap, result.getBody());
    }
}
