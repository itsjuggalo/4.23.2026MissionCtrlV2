package com.revenuecat.purchases.hybridcommon.mappers;

import U6.h;
import U6.o;
import Y6.I;
import Y6.L;
import Y6.M;
import com.revenuecat.purchases.utils.Iso8601Utils;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2304t;
import o5.AbstractC2484l;
import o5.C2489q;
import o5.InterfaceC2483k;
import o5.w;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p5.AbstractC2590l;
import p5.AbstractC2592n;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001b\u0010\u0003\u001a\u00020\u0002*\f\u0012\u0004\u0012\u00020\u0001\u0012\u0002\b\u00030\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0015\u0010\u0007\u001a\u00020\u0006*\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0004\b\u0007\u0010\b\u001a\u001f\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000*\u00020\u0002¢\u0006\u0004\b\t\u0010\n\u001a\u0013\u0010\r\u001a\u00020\f*\u00020\u000bH\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u0013\u0010\u000f\u001a\u00020\u0001*\u00020\u000bH\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001f\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\fH\u0000¢\u0006\u0004\b\u0013\u0010\u0014\"$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\"\u001b\u0010\u001f\u001a\u00020\u00158@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0019\"\u001a\u0010!\u001a\u00020 8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$¨\u0006%"}, d2 = {"", "", "Lorg/json/JSONObject;", "convertToJson", "(Ljava/util/Map;)Lorg/json/JSONObject;", "", "Lorg/json/JSONArray;", "convertToJsonArray", "(Ljava/util/List;)Lorg/json/JSONArray;", "convertToMap", "(Lorg/json/JSONObject;)Ljava/util/Map;", "Ljava/util/Date;", "", "toMillis", "(Ljava/util/Date;)J", "toIso8601", "(Ljava/util/Date;)Ljava/lang/String;", "priceCurrencyCode", "number", "formatUsingDeviceLocale", "(Ljava/lang/String;J)Ljava/lang/String;", "LY6/I;", "overrideMapperDispatcher", "LY6/I;", "getOverrideMapperDispatcher", "()LY6/I;", "setOverrideMapperDispatcher", "(LY6/I;)V", "mapperDispatcher$delegate", "Lo5/k;", "getMapperDispatcher", "mapperDispatcher", "LY6/L;", "mainScope", "LY6/L;", "getMainScope", "()LY6/L;", "hybridcommon_release"}, k = 2, mv = {1, 8, 0})
public final class MappersHelpersKt {
    private static I overrideMapperDispatcher;
    private static final InterfaceC2483k mapperDispatcher$delegate = AbstractC2484l.a(MappersHelpersKt$mapperDispatcher$2.INSTANCE);
    private static final L mainScope = M.b();

    public static final JSONObject convertToJson(Map<String, ?> map) throws JSONException {
        List listK0;
        AbstractC2304t.f(map, "<this>");
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value == null) {
                value = JSONObject.NULL;
            } else if (value instanceof Map) {
                AbstractC2304t.d(value, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, *>");
                value = convertToJson((Map) value);
            } else {
                if (value instanceof List) {
                    listK0 = (List) value;
                } else if (value instanceof Object[]) {
                    listK0 = AbstractC2592n.k0((Object[]) value);
                }
                value = convertToJsonArray(listK0);
            }
            jSONObject.put(key, value);
        }
        return jSONObject;
    }

    public static final JSONArray convertToJsonArray(List<?> list) throws JSONException {
        List listD;
        AbstractC2304t.f(list, "<this>");
        JSONArray jSONArray = new JSONArray();
        for (Object objConvertToJsonArray : list) {
            if (objConvertToJsonArray == null) {
                objConvertToJsonArray = JSONObject.NULL;
            } else if (objConvertToJsonArray instanceof Map) {
                AbstractC2304t.d(objConvertToJsonArray, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, *>");
                objConvertToJsonArray = convertToJson((Map) objConvertToJsonArray);
            } else {
                if (objConvertToJsonArray instanceof Object[]) {
                    listD = AbstractC2590l.d((Object[]) objConvertToJsonArray);
                } else if (objConvertToJsonArray instanceof List) {
                    listD = (List) objConvertToJsonArray;
                }
                objConvertToJsonArray = convertToJsonArray(listD);
            }
            jSONArray.put(objConvertToJsonArray);
        }
        return jSONArray;
    }

    public static final Map<String, String> convertToMap(JSONObject jSONObject) {
        AbstractC2304t.f(jSONObject, "<this>");
        Iterator<String> itKeys = jSONObject.keys();
        AbstractC2304t.e(itKeys, "this.keys()");
        h<String> hVarE = o.e(itKeys);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str : hVarE) {
            C2489q c2489qA = w.a(str, jSONObject.isNull(str) ? null : jSONObject.getString(str));
            linkedHashMap.put(c2489qA.c(), c2489qA.d());
        }
        return linkedHashMap;
    }

    public static final String formatUsingDeviceLocale(String priceCurrencyCode, long j8) {
        AbstractC2304t.f(priceCurrencyCode, "priceCurrencyCode");
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
        currencyInstance.setCurrency(Currency.getInstance(priceCurrencyCode));
        String str = currencyInstance.format(j8);
        AbstractC2304t.e(str, "getCurrencyInstance().ap…ode)\n    }.format(number)");
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

    public static final void setOverrideMapperDispatcher(I i8) {
        overrideMapperDispatcher = i8;
    }

    public static final String toIso8601(Date date) {
        AbstractC2304t.f(date, "<this>");
        String str = Iso8601Utils.format(date);
        AbstractC2304t.e(str, "format(this)");
        return str;
    }

    public static final long toMillis(Date date) {
        AbstractC2304t.f(date, "<this>");
        return date.getTime();
    }
}
