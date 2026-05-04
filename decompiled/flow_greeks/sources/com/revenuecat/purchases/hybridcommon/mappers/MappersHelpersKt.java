package com.revenuecat.purchases.hybridcommon.mappers;

import cd.k;
import cd.l;
import cd.w;
import com.revenuecat.purchases.utils.Iso8601Utils;
import dd.n;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jg.h;
import jg.q;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import ng.k0;
import ng.n0;
import ng.o0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001b\u0010\u0003\u001a\u00020\u0002*\f\u0012\u0004\u0012\u00020\u0001\u0012\u0002\b\u00030\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0015\u0010\u0007\u001a\u00020\u0006*\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0004\b\u0007\u0010\b\u001a\u001f\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000*\u00020\u0002¢\u0006\u0004\b\t\u0010\n\u001a\u0013\u0010\r\u001a\u00020\f*\u00020\u000bH\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u0013\u0010\u000f\u001a\u00020\u0001*\u00020\u000bH\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001f\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\fH\u0000¢\u0006\u0004\b\u0013\u0010\u0014\"$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\"\u001b\u0010\u001f\u001a\u00020\u00158@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0019\"\u001a\u0010!\u001a\u00020 8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$¨\u0006%"}, d2 = {"", "", "Lorg/json/JSONObject;", "convertToJson", "(Ljava/util/Map;)Lorg/json/JSONObject;", "", "Lorg/json/JSONArray;", "convertToJsonArray", "(Ljava/util/List;)Lorg/json/JSONArray;", "convertToMap", "(Lorg/json/JSONObject;)Ljava/util/Map;", "Ljava/util/Date;", "", "toMillis", "(Ljava/util/Date;)J", "toIso8601", "(Ljava/util/Date;)Ljava/lang/String;", "priceCurrencyCode", "number", "formatUsingDeviceLocale", "(Ljava/lang/String;J)Ljava/lang/String;", "Lng/k0;", "overrideMapperDispatcher", "Lng/k0;", "getOverrideMapperDispatcher", "()Lng/k0;", "setOverrideMapperDispatcher", "(Lng/k0;)V", "mapperDispatcher$delegate", "Lcd/k;", "getMapperDispatcher", "mapperDispatcher", "Lng/n0;", "mainScope", "Lng/n0;", "getMainScope", "()Lng/n0;", "hybridcommon_bc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class MappersHelpersKt {
    private static k0 overrideMapperDispatcher;
    private static final k mapperDispatcher$delegate = l.b(MappersHelpersKt$mapperDispatcher$2.INSTANCE);
    private static final n0 mainScope = o0.b();

    public static final JSONObject convertToJson(Map<String, ?> map) throws JSONException {
        t.f(map, "<this>");
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value == null) {
                jSONObject.put(key, JSONObject.NULL);
            } else if (value instanceof Map) {
                t.d(value, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, *>");
                jSONObject.put(key, convertToJson((Map) value));
            } else if (value instanceof List) {
                jSONObject.put(key, convertToJsonArray((List) value));
            } else if (value instanceof Object[]) {
                jSONObject.put(key, convertToJsonArray(n.z0((Object[]) value)));
            } else {
                jSONObject.put(key, value);
            }
        }
        return jSONObject;
    }

    public static final JSONArray convertToJsonArray(List<?> list) {
        t.f(list, "<this>");
        JSONArray jSONArray = new JSONArray();
        for (Object obj : list) {
            if (obj == null) {
                jSONArray.put(JSONObject.NULL);
            } else if (obj instanceof Map) {
                t.d(obj, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, *>");
                jSONArray.put(convertToJson((Map) obj));
            } else if (obj instanceof Object[]) {
                jSONArray.put(convertToJsonArray(dd.l.d((Object[]) obj)));
            } else if (obj instanceof List) {
                jSONArray.put(convertToJsonArray((List) obj));
            } else {
                jSONArray.put(obj);
            }
        }
        return jSONArray;
    }

    public static final Map<String, String> convertToMap(JSONObject jSONObject) {
        t.f(jSONObject, "<this>");
        Iterator<String> itKeys = jSONObject.keys();
        t.e(itKeys, "this.keys()");
        h<String> hVarG = q.g(itKeys);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str : hVarG) {
            cd.q qVarA = jSONObject.isNull(str) ? w.a(str, null) : w.a(str, jSONObject.getString(str));
            linkedHashMap.put(qVarA.c(), qVarA.d());
        }
        return linkedHashMap;
    }

    public static final String formatUsingDeviceLocale(String priceCurrencyCode, long j10) {
        t.f(priceCurrencyCode, "priceCurrencyCode");
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
        currencyInstance.setCurrency(Currency.getInstance(priceCurrencyCode));
        String str = currencyInstance.format(j10);
        t.e(str, "getCurrencyInstance().ap…ode)\n    }.format(number)");
        return str;
    }

    public static final n0 getMainScope() {
        return mainScope;
    }

    public static final k0 getMapperDispatcher() {
        return (k0) mapperDispatcher$delegate.getValue();
    }

    public static final k0 getOverrideMapperDispatcher() {
        return overrideMapperDispatcher;
    }

    public static final void setOverrideMapperDispatcher(k0 k0Var) {
        overrideMapperDispatcher = k0Var;
    }

    public static final String toIso8601(Date date) {
        t.f(date, "<this>");
        String str = Iso8601Utils.format(date);
        t.e(str, "format(this)");
        return str;
    }

    public static final long toMillis(Date date) {
        t.f(date, "<this>");
        return date.getTime();
    }
}
