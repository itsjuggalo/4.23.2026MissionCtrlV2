package com.revenuecat.purchases.common.networking;

import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.common.CustomerInfoFactory;
import com.revenuecat.purchases.utils.JSONObjectExtensionsKt;
import dd.n0;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, d2 = {"buildPostReceiptResponse", "Lcom/revenuecat/purchases/common/networking/PostReceiptResponse;", "result", "Lcom/revenuecat/purchases/common/networking/HTTPResult;", "purchases_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PostReceiptResponseKt {
    public static final PostReceiptResponse buildPostReceiptResponse(HTTPResult result) {
        t.f(result, "result");
        CustomerInfo customerInfoBuildCustomerInfo = CustomerInfoFactory.INSTANCE.buildCustomerInfo(result);
        JSONObject jSONObjectOptJSONObject = result.getBody().optJSONObject("purchased_products");
        LinkedHashMap linkedHashMap = null;
        if (jSONObjectOptJSONObject != null) {
            Map map$default = JSONObjectExtensionsKt.toMap$default(jSONObjectOptJSONObject, false, 1, null);
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(n0.d(map$default.size()));
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
