package com.revenuecat.purchases.common.networking;

import E5.t;
import F5.I;
import Q5.k;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.r;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class MapConverter {
    private final /* synthetic */ <T> Object tryCast(Object obj, k kVar) {
        r.j(3, "T");
        return obj != null ? kVar.invoke(obj) : obj;
    }

    public final JSONObject convertToJSON$purchases_defaultsRelease(Map<String, ? extends Object> inputMap) throws JSONException {
        r.f(inputMap, "inputMap");
        LinkedHashMap linkedHashMap = new LinkedHashMap(I.b(inputMap.size()));
        Iterator<T> it = inputMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof List) {
                Iterable iterable = (Iterable) value;
                if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
                    value = new JSONObject(I.c(t.a("temp_key", new JSONArray((Collection) value)))).getJSONArray("temp_key");
                } else {
                    Iterator it2 = iterable.iterator();
                    while (it2.hasNext()) {
                        if (!(it2.next() instanceof String)) {
                            break;
                        }
                    }
                    value = new JSONObject(I.c(t.a("temp_key", new JSONArray((Collection) value)))).getJSONArray("temp_key");
                }
            } else if (value instanceof Map) {
                value = convertToJSON$purchases_defaultsRelease((Map) value);
            }
            linkedHashMap.put(key, value);
        }
        return createJSONObject$purchases_defaultsRelease(linkedHashMap);
    }

    public final JSONObject createJSONObject$purchases_defaultsRelease(Map<String, ? extends Object> inputMap) {
        r.f(inputMap, "inputMap");
        return new JSONObject(inputMap);
    }
}
