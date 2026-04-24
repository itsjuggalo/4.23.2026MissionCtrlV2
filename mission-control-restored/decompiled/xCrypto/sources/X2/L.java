package X2;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class L extends K {
    public static Map e() {
        A a4 = A.f5578a;
        kotlin.jvm.internal.r.d(a4, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return a4;
    }

    public static Object f(Map map, Object obj) {
        kotlin.jvm.internal.r.f(map, "<this>");
        return J.a(map, obj);
    }

    public static Map g(W2.o... pairs) {
        kotlin.jvm.internal.r.f(pairs, "pairs");
        return pairs.length > 0 ? t(pairs, new LinkedHashMap(K.b(pairs.length))) : e();
    }

    public static Map h(Map map, Iterable keys) {
        kotlin.jvm.internal.r.f(map, "<this>");
        kotlin.jvm.internal.r.f(keys, "keys");
        Map mapU = u(map);
        u.x(mapU.keySet(), keys);
        return j(mapU);
    }

    public static Map i(W2.o... pairs) {
        kotlin.jvm.internal.r.f(pairs, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(K.b(pairs.length));
        n(linkedHashMap, pairs);
        return linkedHashMap;
    }

    public static final Map j(Map map) {
        kotlin.jvm.internal.r.f(map, "<this>");
        int size = map.size();
        return size != 0 ? size != 1 ? map : K.d(map) : e();
    }

    public static Map k(Map map, Map map2) {
        kotlin.jvm.internal.r.f(map, "<this>");
        kotlin.jvm.internal.r.f(map2, "map");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.putAll(map2);
        return linkedHashMap;
    }

    public static void l(Map map, Iterable pairs) {
        kotlin.jvm.internal.r.f(map, "<this>");
        kotlin.jvm.internal.r.f(pairs, "pairs");
        Iterator it = pairs.iterator();
        while (it.hasNext()) {
            W2.o oVar = (W2.o) it.next();
            map.put(oVar.a(), oVar.b());
        }
    }

    public static final void m(Map map, q3.e pairs) {
        kotlin.jvm.internal.r.f(map, "<this>");
        kotlin.jvm.internal.r.f(pairs, "pairs");
        Iterator it = pairs.iterator();
        while (it.hasNext()) {
            W2.o oVar = (W2.o) it.next();
            map.put(oVar.a(), oVar.b());
        }
    }

    public static final void n(Map map, W2.o[] pairs) {
        kotlin.jvm.internal.r.f(map, "<this>");
        kotlin.jvm.internal.r.f(pairs, "pairs");
        for (W2.o oVar : pairs) {
            map.put(oVar.a(), oVar.b());
        }
    }

    public static Map o(Iterable iterable) {
        kotlin.jvm.internal.r.f(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return j(p(iterable, new LinkedHashMap()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return e();
        }
        if (size != 1) {
            return p(iterable, new LinkedHashMap(K.b(collection.size())));
        }
        return K.c((W2.o) (iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next()));
    }

    public static final Map p(Iterable iterable, Map destination) {
        kotlin.jvm.internal.r.f(iterable, "<this>");
        kotlin.jvm.internal.r.f(destination, "destination");
        l(destination, iterable);
        return destination;
    }

    public static Map q(Map map) {
        kotlin.jvm.internal.r.f(map, "<this>");
        int size = map.size();
        return size != 0 ? size != 1 ? u(map) : K.d(map) : e();
    }

    public static Map r(q3.e eVar) {
        kotlin.jvm.internal.r.f(eVar, "<this>");
        return j(s(eVar, new LinkedHashMap()));
    }

    public static final Map s(q3.e eVar, Map destination) {
        kotlin.jvm.internal.r.f(eVar, "<this>");
        kotlin.jvm.internal.r.f(destination, "destination");
        m(destination, eVar);
        return destination;
    }

    public static final Map t(W2.o[] oVarArr, Map destination) {
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
