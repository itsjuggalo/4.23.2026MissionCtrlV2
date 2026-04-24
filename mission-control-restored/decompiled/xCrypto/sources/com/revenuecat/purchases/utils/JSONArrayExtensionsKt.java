package com.revenuecat.purchases.utils;

import X2.AbstractC0770q;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.r;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class JSONArrayExtensionsKt {
    public static final <T> List<T> replaceJsonNullWithKotlinNull(List<? extends T> list) {
        r.f(list, "<this>");
        ArrayList arrayList = new ArrayList(AbstractC0770q.q(list, 10));
        for (T t4 : list) {
            if (t4 instanceof Map) {
                r.d(t4, "null cannot be cast to non-null type kotlin.collections.Map<T of com.revenuecat.purchases.utils.JSONArrayExtensionsKt.replaceJsonNullWithKotlinNull$lambda$0, T of com.revenuecat.purchases.utils.JSONArrayExtensionsKt.replaceJsonNullWithKotlinNull$lambda$0?>");
                t4 = (T) JSONObjectExtensionsKt.replaceJsonNullWithKotlinNull((Map) t4);
            } else if (t4 instanceof List) {
                r.d(t4, "null cannot be cast to non-null type kotlin.collections.List<T of com.revenuecat.purchases.utils.JSONArrayExtensionsKt.replaceJsonNullWithKotlinNull$lambda$0?>");
                t4 = (T) replaceJsonNullWithKotlinNull((List) t4);
            } else if (r.b(t4, JSONObject.NULL)) {
                t4 = (T) null;
            }
            arrayList.add(t4);
        }
        return arrayList;
    }

    public static final <T> List<T> toList(JSONArray jSONArray) {
        r.f(jSONArray, "<this>");
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i4 = 0; i4 < length; i4++) {
            Object list = jSONArray.get(i4);
            if (list instanceof JSONObject) {
                list = JSONObjectExtensionsKt.toMap((JSONObject) list, true);
            } else if (list instanceof JSONArray) {
                list = toList((JSONArray) list);
            }
            arrayList.add(list);
        }
        return arrayList;
    }
}
