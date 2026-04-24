package F5;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class J extends I {
    public static Map e() {
        y yVar = y.f2385a;
        kotlin.jvm.internal.r.d(yVar, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return yVar;
    }

    public static Object f(Map map, Object obj) {
        kotlin.jvm.internal.r.f(map, "<this>");
        return H.a(map, obj);
    }

    public static Map g(E5.o... pairs) {
        kotlin.jvm.internal.r.f(pairs, "pairs");
        return pairs.length > 0 ? t(pairs, new LinkedHashMap(I.b(pairs.length))) : e();
    }

    public static Map h(Map map, Iterable keys) {
        kotlin.jvm.internal.r.f(map, "<this>");
        kotlin.jvm.internal.r.f(keys, "keys");
        Map mapU = u(map);
        s.x(mapU.keySet(), keys);
        return j(mapU);
    }

    public static Map i(E5.o... pairs) {
        kotlin.jvm.internal.r.f(pairs, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(I.b(pairs.length));
        n(linkedHashMap, pairs);
        return linkedHashMap;
    }

    public static final Map j(Map map) {
        kotlin.jvm.internal.r.f(map, "<this>");
        int size = map.size();
        return size != 0 ? size != 1 ? map : I.d(map) : e();
    }

    public static Map k(Map map, Map map2) {
        kotlin.jvm.internal.r.f(map, "<this>");
        kotlin.jvm.internal.r.f(map2, "map");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.putAll(map2);
        return linkedHashMap;
    }

    public static final void l(Map map, Y5.f pairs) {
        kotlin.jvm.internal.r.f(map, "<this>");
        kotlin.jvm.internal.r.f(pairs, "pairs");
        Iterator it = pairs.iterator();
        while (it.hasNext()) {
            E5.o oVar = (E5.o) it.next();
            map.put(oVar.a(), oVar.b());
        }
    }

    public static void m(Map map, Iterable pairs) {
        kotlin.jvm.internal.r.f(map, "<this>");
        kotlin.jvm.internal.r.f(pairs, "pairs");
        Iterator it = pairs.iterator();
        while (it.hasNext()) {
            E5.o oVar = (E5.o) it.next();
            map.put(oVar.a(), oVar.b());
        }
    }

    public static final void n(Map map, E5.o[] pairs) {
        kotlin.jvm.internal.r.f(map, "<this>");
        kotlin.jvm.internal.r.f(pairs, "pairs");
        for (E5.o oVar : pairs) {
            map.put(oVar.a(), oVar.b());
        }
    }

    public static Map o(Y5.f fVar) {
        kotlin.jvm.internal.r.f(fVar, "<this>");
        return j(p(fVar, new LinkedHashMap()));
    }

    public static final Map p(Y5.f fVar, Map destination) {
        kotlin.jvm.internal.r.f(fVar, "<this>");
        kotlin.jvm.internal.r.f(destination, "destination");
        l(destination, fVar);
        return destination;
    }

    public static Map q(Iterable iterable) {
        kotlin.jvm.internal.r.f(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return j(r(iterable, new LinkedHashMap()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return e();
        }
        if (size != 1) {
            return r(iterable, new LinkedHashMap(I.b(collection.size())));
        }
        return I.c((E5.o) (iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next()));
    }

    public static final Map r(Iterable iterable, Map destination) {
        kotlin.jvm.internal.r.f(iterable, "<this>");
        kotlin.jvm.internal.r.f(destination, "destination");
        m(destination, iterable);
        return destination;
    }

    public static Map s(Map map) {
        kotlin.jvm.internal.r.f(map, "<this>");
        int size = map.size();
        return size != 0 ? size != 1 ? u(map) : I.d(map) : e();
    }

    public static final Map t(E5.o[] oVarArr, Map destination) {
        kotlin.jvm.internal.r.f(oVarArr, "<this>");
        kotlin.jvm.internal.r.f(destination, "destination");
        n(destination, oVarArr);
        return destination;
    }

    public static Map u(Map map) {
        kotlin.jvm.internal.r.f(map, "<this>");
        return new LinkedHashMap(map);
    }
}
