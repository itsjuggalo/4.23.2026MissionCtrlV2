package com.revenuecat.purchases.hybridcommon.mappers;

import E5.o;
import E5.t;
import F5.AbstractC0551i;
import F5.AbstractC0552j;
import Y5.f;
import Y5.k;
import com.revenuecat.purchases.utils.Iso8601Utils;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.r;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class MappersHelpersKt {
    public static final JSONObject convertToJson(Map<String, ?> map) throws JSONException {
        r.f(map, "<this>");
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value == null) {
                jSONObject.put(key, JSONObject.NULL);
            } else if (value instanceof Map) {
                r.d(value, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, *>");
                jSONObject.put(key, convertToJson((Map) value));
            } else if (value instanceof List) {
                jSONObject.put(key, convertToJsonArray((List) value));
            } else if (value instanceof Object[]) {
                jSONObject.put(key, convertToJsonArray(AbstractC0552j.i0((Object[]) value)));
            } else {
                jSONObject.put(key, value);
            }
        }
        return jSONObject;
    }

    public static final JSONArray convertToJsonArray(List<?> list) {
        r.f(list, "<this>");
        JSONArray jSONArray = new JSONArray();
        for (Object obj : list) {
            if (obj == null) {
                jSONArray.put(JSONObject.NULL);
            } else if (obj instanceof Map) {
                r.d(obj, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, *>");
                jSONArray.put(convertToJson((Map) obj));
            } else if (obj instanceof Object[]) {
                jSONArray.put(convertToJsonArray(AbstractC0551i.c((Object[]) obj)));
            } else if (obj instanceof List) {
                jSONArray.put(convertToJsonArray((List) obj));
            } else {
                jSONArray.put(obj);
            }
        }
        return jSONArray;
    }

    public static final Map<String, String> convertToMap(JSONObject jSONObject) {
        r.f(jSONObject, "<this>");
        Iterator<String> itKeys = jSONObject.keys();
        r.e(itKeys, "this.keys()");
        f<String> fVarC = k.c(itKeys);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str : fVarC) {
            o oVarA = jSONObject.isNull(str) ? t.a(str, null) : t.a(str, jSONObject.getString(str));
            linkedHashMap.put(oVarA.c(), oVarA.d());
        }
        return linkedHashMap;
    }

    public static final String formatUsingDeviceLocale(String priceCurrencyCode, long j7) {
        r.f(priceCurrencyCode, "priceCurrencyCode");
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
        currencyInstance.setCurrency(Currency.getInstance(priceCurrencyCode));
        String str = currencyInstance.format(j7);
        r.e(str, "getCurrencyInstance().ap…ode)\n    }.format(number)");
        return str;
    }

    public static final String toIso8601(Date date) {
        r.f(date, "<this>");
        String str = Iso8601Utils.format(date);
        r.e(str, "format(this)");
        return str;
    }

    public static final long toMillis(Date date) {
        r.f(date, "<this>");
        return date.getTime();
    }
}
