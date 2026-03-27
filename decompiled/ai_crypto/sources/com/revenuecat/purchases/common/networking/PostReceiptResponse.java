package com.revenuecat.purchases.common.networking;

import com.revenuecat.purchases.CustomerInfo;
import java.util.Map;
import kotlin.jvm.internal.r;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class PostReceiptResponse {
    private final JSONObject body;
    private final CustomerInfo customerInfo;
    private final Map<String, PostReceiptProductInfo> productInfoByProductId;

    public PostReceiptResponse(CustomerInfo customerInfo, Map<String, PostReceiptProductInfo> map, JSONObject body) {
        r.f(customerInfo, "customerInfo");
        r.f(body, "body");
        this.customerInfo = customerInfo;
        this.productInfoByProductId = map;
        this.body = body;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PostReceiptResponse copy$default(PostReceiptResponse postReceiptResponse, CustomerInfo customerInfo, Map map, JSONObject jSONObject, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            customerInfo = postReceiptResponse.customerInfo;
        }
        if ((i7 & 2) != 0) {
            map = postReceiptResponse.productInfoByProductId;
        }
        if ((i7 & 4) != 0) {
            jSONObject = postReceiptResponse.body;
        }
        return postReceiptResponse.copy(customerInfo, map, jSONObject);
    }

    public final CustomerInfo component1() {
        return this.customerInfo;
    }

    public final Map<String, PostReceiptProductInfo> component2() {
        return this.productInfoByProductId;
    }

    public final JSONObject component3() {
        return this.body;
    }

    public final PostReceiptResponse copy(CustomerInfo customerInfo, Map<String, PostReceiptProductInfo> map, JSONObject body) {
        r.f(customerInfo, "customerInfo");
        r.f(body, "body");
        return new PostReceiptResponse(customerInfo, map, body);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PostReceiptResponse)) {
            return false;
        }
        PostReceiptResponse postReceiptResponse = (PostReceiptResponse) obj;
        return r.b(this.customerInfo, postReceiptResponse.customerInfo) && r.b(this.productInfoByProductId, postReceiptResponse.productInfoByProductId) && r.b(this.body, postReceiptResponse.body);
    }

    public final JSONObject getBody() {
        return this.body;
    }

    public final CustomerInfo getCustomerInfo() {
        return this.customerInfo;
    }

    public final Map<String, PostReceiptProductInfo> getProductInfoByProductId() {
        return this.productInfoByProductId;
    }

    public int hashCode() {
        int iHashCode = this.customerInfo.hashCode() * 31;
        Map<String, PostReceiptProductInfo> map = this.productInfoByProductId;
        return ((iHashCode + (map == null ? 0 : map.hashCode())) * 31) + this.body.hashCode();
    }

    public String toString() {
        return "PostReceiptResponse(customerInfo=" + this.customerInfo + ", productInfoByProductId=" + this.productInfoByProductId + ", body=" + this.body + ')';
    }
}
