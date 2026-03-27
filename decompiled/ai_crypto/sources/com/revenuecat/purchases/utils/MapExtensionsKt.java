package com.revenuecat.purchases.utils;

import Q5.k;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class MapExtensionsKt {
    public static final <K, V> Map<K, V> filterNotNullValues(Map<K, ? extends V> map) {
        r.f(map, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<K, ? extends V> entry : map.entrySet()) {
            if (entry.getValue() != null) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, R> Map<R, V> mapNotNullKeys(Map<K, ? extends V> map, k transform) {
        r.f(map, "<this>");
        r.f(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map.size());
        for (Map.Entry<K, ? extends V> entry : map.entrySet()) {
            Object objInvoke = transform.invoke(entry);
            if (objInvoke != null) {
                linkedHashMap.put(objInvoke, entry.getValue());
            }
        }
        return linkedHashMap;
    }
}
