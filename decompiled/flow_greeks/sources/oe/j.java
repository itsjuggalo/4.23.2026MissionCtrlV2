package oe;

import ce.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f18004a = new j();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f18005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map f18006c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set f18007d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Set f18008e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Set f18009f;

    static {
        ef.d dVar = o.a.f4009s;
        cd.q qVarA = cd.w.a(k.d(dVar, "name"), ce.o.f3959m);
        cd.q qVarA2 = cd.w.a(k.d(dVar, "ordinal"), ef.f.k("ordinal"));
        cd.q qVarA3 = cd.w.a(k.c(o.a.X, "size"), ef.f.k("size"));
        ef.c cVar = o.a.f3976b0;
        Map mapL = dd.o0.l(qVarA, qVarA2, qVarA3, cd.w.a(k.c(cVar, "size"), ef.f.k("size")), cd.w.a(k.d(o.a.f3985g, "length"), ef.f.k("length")), cd.w.a(k.c(cVar, "keys"), ef.f.k("keySet")), cd.w.a(k.c(cVar, "values"), ef.f.k("values")), cd.w.a(k.c(cVar, "entries"), ef.f.k("entrySet")));
        f18005b = mapL;
        Set<Map.Entry> setEntrySet = mapL.entrySet();
        ArrayList<cd.q> arrayList = new ArrayList(dd.s.u(setEntrySet, 10));
        for (Map.Entry entry : setEntrySet) {
            arrayList.add(new cd.q(((ef.c) entry.getKey()).f(), entry.getValue()));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (cd.q qVar : arrayList) {
            ef.f fVar = (ef.f) qVar.d();
            Object arrayList2 = linkedHashMap.get(fVar);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                linkedHashMap.put(fVar, arrayList2);
            }
            ((List) arrayList2).add((ef.f) qVar.c());
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(dd.n0.d(linkedHashMap.size()));
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            linkedHashMap2.put(entry2.getKey(), dd.a0.S((Iterable) entry2.getValue()));
        }
        f18006c = linkedHashMap2;
        Map map = f18005b;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Map.Entry entry3 : map.entrySet()) {
            ef.b bVarN = ee.c.f8681a.n(((ef.c) entry3.getKey()).d().i());
            kotlin.jvm.internal.t.c(bVarN);
            linkedHashSet.add(bVarN.a().b((ef.f) entry3.getValue()));
        }
        f18007d = linkedHashSet;
        Set setKeySet = f18005b.keySet();
        f18008e = setKeySet;
        ArrayList arrayList3 = new ArrayList(dd.s.u(setKeySet, 10));
        Iterator it = setKeySet.iterator();
        while (it.hasNext()) {
            arrayList3.add(((ef.c) it.next()).f());
        }
        f18009f = dd.a0.N0(arrayList3);
    }

    public final Map a() {
        return f18005b;
    }

    public final List b(ef.f name1) {
        kotlin.jvm.internal.t.f(name1, "name1");
        List list = (List) f18006c.get(name1);
        return list == null ? dd.r.k() : list;
    }

    public final Set c() {
        return f18008e;
    }

    public final Set d() {
        return f18009f;
    }
}
