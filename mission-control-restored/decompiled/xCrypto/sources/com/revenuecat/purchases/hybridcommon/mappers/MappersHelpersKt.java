package com.revenuecat.purchases.hybridcommon.mappers;

import W2.j;
import W2.k;
import W2.o;
import W2.t;
import X2.AbstractC0763j;
import X2.AbstractC0765l;
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
import q3.e;
import t3.I;
import t3.L;
import t3.M;

/* JADX INFO: loaded from: classes3.dex */
public final class MappersHelpersKt {
    private static I overrideMapperDispatcher;
    private static final j mapperDispatcher$delegate = k.b(MappersHelpersKt$mapperDispatcher$2.INSTANCE);
    private static final L mainScope = M.b();

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
                jSONObject.put(key, convertToJsonArray(AbstractC0765l.j0((Object[]) value)));
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
                jSONArray.put(convertToJsonArray(AbstractC0763j.c((Object[]) obj)));
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
        e<String> eVarC = q3.j.c(itKeys);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str : eVarC) {
            o oVarA = jSONObject.isNull(str) ? t.a(str, null) : t.a(str, jSONObject.getString(str));
            linkedHashMap.put(oVarA.c(), oVarA.d());
        }
        return linkedHashMap;
    }

    public static final String formatUsingDeviceLocale(String priceCurrencyCode, long j4) {
        r.f(priceCurrencyCode, "priceCurrencyCode");
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
        currencyInstance.setCurrency(Currency.getInstance(priceCurrencyCode));
        String str = currencyInstance.format(j4);
        r.e(str, "getCurrencyInstance().ap…ode)\n    }.format(number)");
        return str;
    }

    public static final L getMainScope() {
        return mainScope;
    }

    public static final I getMapperDispatcher() {
        return (I) mapperDispatcher$delegate.getValue();
    }

    public static final I getOverrideMapperDispatcher() {
        return overrideMapperDispatcher;
    }

    public static final void setOverrideMapperDispatcher(I i4) {
        overrideMapperDispatcher = i4;
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
