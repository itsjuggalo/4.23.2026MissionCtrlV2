package com.revenuecat.purchases.utils;

import F5.AbstractC0557o;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.r;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class JSONArrayExtensionsKt {
    public static final <T> List<T> replaceJsonNullWithKotlinNull(List<? extends T> list) {
        r.f(list, "<this>");
        ArrayList arrayList = new ArrayList(AbstractC0557o.q(list, 10));
        for (T t7 : list) {
            if (t7 instanceof Map) {
                r.d(t7, "null cannot be cast to non-null type kotlin.collections.Map<T of com.revenuecat.purchases.utils.JSONArrayExtensionsKt.replaceJsonNullWithKotlinNull$lambda$0, T of com.revenuecat.purchases.utils.JSONArrayExtensionsKt.replaceJsonNullWithKotlinNull$lambda$0?>");
                t7 = (T) JSONObjectExtensionsKt.replaceJsonNullWithKotlinNull((Map) t7);
            } else if (t7 instanceof List) {
                r.d(t7, "null cannot be cast to non-null type kotlin.collections.List<T of com.revenuecat.purchases.utils.JSONArrayExtensionsKt.replaceJsonNullWithKotlinNull$lambda$0?>");
                t7 = (T) replaceJsonNullWithKotlinNull((List) t7);
            } else if (r.b(t7, JSONObject.NULL)) {
                t7 = (T) null;
            }
            arrayList.add(t7);
        }
        return arrayList;
    }

    public static final <T> List<T> toList(JSONArray jSONArray) {
        r.f(jSONArray, "<this>");
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i7 = 0; i7 < length; i7++) {
            Object list = jSONArray.get(i7);
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
