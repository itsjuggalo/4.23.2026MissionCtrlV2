package com.revenuecat.purchases.utils;

import cd.q;
import cd.w;
import dd.n0;
import dd.s;
import eh.c0;
import eh.e0;
import eh.i;
import eh.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import vd.l;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0006\u001a#\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\"\u001a\u0010\b\u001a\u0004\u0018\u00010\u0003*\u00020\u00008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Leh/i;", "", "", "", "asMap", "(Leh/i;)Ljava/util/Map;", "getExtractedContent", "(Leh/i;)Ljava/lang/Object;", "extractedContent", "purchases_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class JsonElementExtensionsKt {
    public static final Map<String, Object> asMap(i iVar) {
        t.f(iVar, "<this>");
        if (!(iVar instanceof c0)) {
            return null;
        }
        Set<Map.Entry<String, i>> setEntrySet = j.n(iVar).entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(l.b(n0.d(s.u(setEntrySet, 10)), 16));
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            q qVarA = w.a(entry.getKey(), getExtractedContent((i) entry.getValue()));
            linkedHashMap.put(qVarA.c(), qVarA.d());
        }
        return linkedHashMap;
    }

    private static final Object getExtractedContent(i iVar) {
        if (iVar instanceof e0) {
            e0 e0VarO = j.o(iVar);
            if (e0VarO.c()) {
                return e0VarO.a();
            }
            Object objE = j.e(e0VarO);
            return (objE == null && (objE = j.l(e0VarO)) == null && (objE = j.r(e0VarO)) == null && (objE = j.j(e0VarO)) == null && (objE = j.h(e0VarO)) == null) ? j.f(e0VarO) : objE;
        }
        if (iVar instanceof eh.c) {
            eh.c cVarM = j.m(iVar);
            ArrayList arrayList = new ArrayList(s.u(cVarM, 10));
            Iterator<i> it = cVarM.iterator();
            while (it.hasNext()) {
                arrayList.add(getExtractedContent(it.next()));
            }
            return arrayList;
        }
        if (!(iVar instanceof c0)) {
            return null;
        }
        Set<Map.Entry<String, i>> setEntrySet = j.n(iVar).entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(l.b(n0.d(s.u(setEntrySet, 10)), 16));
        Iterator<T> it2 = setEntrySet.iterator();
        while (it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it2.next();
            q qVarA = w.a(entry.getKey(), getExtractedContent((i) entry.getValue()));
            linkedHashMap.put(qVarA.c(), qVarA.d());
        }
        return linkedHashMap;
    }
}
