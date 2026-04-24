package com.revenuecat.purchases.utils;

import K3.h;
import K3.i;
import K3.u;
import K3.w;
import W2.o;
import W2.t;
import X2.AbstractC0770q;
import X2.K;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.r;
import o3.AbstractC1681l;

/* JADX INFO: loaded from: classes3.dex */
public final class JsonElementExtensionsKt {
    public static final Map<String, Object> asMap(h hVar) {
        r.f(hVar, "<this>");
        if (!(hVar instanceof u)) {
            return null;
        }
        Set<Map.Entry<String, h>> setEntrySet = i.n(hVar).entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(AbstractC1681l.b(K.b(AbstractC0770q.q(setEntrySet, 10)), 16));
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            o oVarA = t.a(entry.getKey(), getExtractedContent((h) entry.getValue()));
            linkedHashMap.put(oVarA.c(), oVarA.d());
        }
        return linkedHashMap;
    }

    private static final Object getExtractedContent(h hVar) {
        if (hVar instanceof w) {
            w wVarO = i.o(hVar);
            if (wVarO.i()) {
                return wVarO.f();
            }
            Object objE = i.e(wVarO);
            return (objE == null && (objE = i.l(wVarO)) == null && (objE = i.r(wVarO)) == null && (objE = i.j(wVarO)) == null && (objE = i.h(wVarO)) == null) ? i.f(wVarO) : objE;
        }
        if (hVar instanceof K3.b) {
            K3.b bVarM = i.m(hVar);
            ArrayList arrayList = new ArrayList(AbstractC0770q.q(bVarM, 10));
            Iterator<h> it = bVarM.iterator();
            while (it.hasNext()) {
                arrayList.add(getExtractedContent(it.next()));
            }
            return arrayList;
        }
        if (!(hVar instanceof u)) {
            return null;
        }
        Set<Map.Entry<String, h>> setEntrySet = i.n(hVar).entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(AbstractC1681l.b(K.b(AbstractC0770q.q(setEntrySet, 10)), 16));
        Iterator<T> it2 = setEntrySet.iterator();
        while (it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it2.next();
            o oVarA = t.a(entry.getKey(), getExtractedContent((h) entry.getValue()));
            linkedHashMap.put(oVarA.c(), oVarA.d());
        }
        return linkedHashMap;
    }
}
