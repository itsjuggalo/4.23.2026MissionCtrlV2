package com.revenuecat.purchases.common;

import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.SubscriptionInfo;
import com.revenuecat.purchases.common.networking.HTTPResult;
import com.revenuecat.purchases.common.responses.CustomerInfoResponseJsonKeys;
import com.revenuecat.purchases.common.responses.SubscriptionInfoResponse;
import com.revenuecat.purchases.utils.JSONObjectExtensionsKt;
import com.revenuecat.purchases.utils.SerializationException;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.r;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class CustomerInfoFactory {
    public static final CustomerInfoFactory INSTANCE = new CustomerInfoFactory();

    private CustomerInfoFactory() {
    }

    private final HashMap<String, Date> parseDates(JSONObject jSONObject, String str) throws JSONException {
        HashMap<String, Date> map = new HashMap<>();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String key = itKeys.next();
            String it = jSONObject.getJSONObject(key).optString("product_plan_identifier");
            r.e(it, "it");
            if (it.length() <= 0) {
                it = null;
            }
            JSONObject expirationObject = jSONObject.getJSONObject(key);
            if (it != null) {
                String str2 = key + ':' + it;
                if (str2 != null) {
                    key = str2;
                }
            }
            r.e(key, "key");
            r.e(expirationObject, "expirationObject");
            map.put(key, JSONObjectExtensionsKt.optDate(expirationObject, str));
        }
        return map;
    }

    private final Map<String, Date> parseExpirations(JSONObject jSONObject) {
        return parseDates(jSONObject, "expires_date");
    }

    private final Map<String, Date> parsePurchaseDates(JSONObject jSONObject) {
        return parseDates(jSONObject, "purchase_date");
    }

    public final CustomerInfo buildCustomerInfo(HTTPResult httpResult) {
        r.f(httpResult, "httpResult");
        return buildCustomerInfo(httpResult.getBody(), httpResult.getRequestDate(), httpResult.getVerificationResult());
    }

    public final Map<String, SubscriptionInfo> parseSubscriptionInfos(JSONObject subscriberJSONObject, Date requestDate) throws JSONException {
        r.f(subscriberJSONObject, "subscriberJSONObject");
        r.f(requestDate, "requestDate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        JSONObject jSONObject = subscriberJSONObject.getJSONObject(CustomerInfoResponseJsonKeys.SUBSCRIPTIONS);
        try {
            Iterator<String> itKeys = jSONObject.keys();
            r.e(itKeys, "subscriptions.keys()");
            while (itKeys.hasNext()) {
                String productId = itKeys.next();
                JSONObject jSONObject2 = jSONObject.getJSONObject(productId);
                s6.a defaultJson = JsonProvider.Companion.getDefaultJson();
                String string = jSONObject2.toString();
                r.e(string, "subscriptionJSONObject.toString()");
                defaultJson.a();
                SubscriptionInfoResponse subscriptionInfoResponse = (SubscriptionInfoResponse) defaultJson.d(SubscriptionInfoResponse.Companion.serializer(), string);
                r.e(productId, "productId");
                linkedHashMap.put(productId, new SubscriptionInfo(productId, requestDate, subscriptionInfoResponse, null, 8, null));
            }
        } catch (SerializationException e7) {
            LogUtilsKt.errorLog("Error deserializing subscription information", e7);
            Collections.emptyMap();
        } catch (IllegalArgumentException e8) {
            LogUtilsKt.errorLog("Error deserializing subscription information. The input is not a SubscriptionInfo", e8);
            Collections.emptyMap();
        }
        return linkedHashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.revenuecat.purchases.CustomerInfo buildCustomerInfo(org.json.JSONObject r18, java.util.Date r19, com.revenuecat.purchases.VerificationResult r20) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 239
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.common.CustomerInfoFactory.buildCustomerInfo(org.json.JSONObject, java.util.Date, com.revenuecat.purchases.VerificationResult):com.revenuecat.purchases.CustomerInfo");
    }
}
