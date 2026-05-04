package dd;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class o0 extends n0 {
    public static Map h() {
        d0 d0Var = d0.f8001a;
        kotlin.jvm.internal.t.d(d0Var, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return d0Var;
    }

    public static Object i(Map map, Object obj) {
        kotlin.jvm.internal.t.f(map, "<this>");
        return m0.a(map, obj);
    }

    public static HashMap j(cd.q... pairs) {
        kotlin.jvm.internal.t.f(pairs, "pairs");
        HashMap map = new HashMap(n0.d(pairs.length));
        s(map, pairs);
        return map;
    }

    public static LinkedHashMap k(cd.q... pairs) {
        kotlin.jvm.internal.t.f(pairs, "pairs");
        return (LinkedHashMap) y(pairs, new LinkedHashMap(n0.d(pairs.length)));
    }

    public static Map l(cd.q... pairs) {
        kotlin.jvm.internal.t.f(pairs, "pairs");
        return pairs.length > 0 ? y(pairs, new LinkedHashMap(n0.d(pairs.length))) : h();
    }

    public static Map m(Map map, Iterable keys) {
        kotlin.jvm.internal.t.f(map, "<this>");
        kotlin.jvm.internal.t.f(keys, "keys");
        Map mapZ = z(map);
        w.D(mapZ.keySet(), keys);
        return o(mapZ);
    }

    public static Map n(cd.q... pairs) {
        kotlin.jvm.internal.t.f(pairs, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(n0.d(pairs.length));
        s(linkedHashMap, pairs);
        return linkedHashMap;
    }

    public static final Map o(Map map) {
        kotlin.jvm.internal.t.f(map, "<this>");
        int size = map.size();
        return size != 0 ? size != 1 ? map : n0.f(map) : h();
    }

    public static Map p(Map map, Map map2) {
        kotlin.jvm.internal.t.f(map, "<this>");
        kotlin.jvm.internal.t.f(map2, "map");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.putAll(map2);
        return linkedHashMap;
    }

    public static void q(Map map, Iterable pairs) {
        kotlin.jvm.internal.t.f(map, "<this>");
        kotlin.jvm.internal.t.f(pairs, "pairs");
        Iterator it = pairs.iterator();
        while (it.hasNext()) {
            cd.q qVar = (cd.q) it.next();
            map.put(qVar.a(), qVar.b());
        }
    }

    public static final void r(Map map, jg.h pairs) {
        kotlin.jvm.internal.t.f(map, "<this>");
        kotlin.jvm.internal.t.f(pairs, "pairs");
        Iterator it = pairs.iterator();
        while (it.hasNext()) {
            cd.q qVar = (cd.q) it.next();
            map.put(qVar.a(), qVar.b());
        }
    }

    public static final void s(Map map, cd.q[] pairs) {
        kotlin.jvm.internal.t.f(map, "<this>");
        kotlin.jvm.internal.t.f(pairs, "pairs");
        for (cd.q qVar : pairs) {
            map.put(qVar.a(), qVar.b());
        }
    }

    public static Map t(Iterable iterable) {
        kotlin.jvm.internal.t.f(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return o(u(iterable, new LinkedHashMap()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return h();
        }
        if (size != 1) {
            return u(iterable, new LinkedHashMap(n0.d(collection.size())));
        }
        return n0.e((cd.q) (iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next()));
    }

    public static final Map u(Iterable iterable, Map destination) {
        kotlin.jvm.internal.t.f(iterable, "<this>");
        kotlin.jvm.internal.t.f(destination, "destination");
        q(destination, iterable);
        return destination;
    }

    public static Map v(Map map) {
        kotlin.jvm.internal.t.f(map, "<this>");
        int size = map.size();
        return size != 0 ? size != 1 ? z(map) : n0.f(map) : h();
    }

    public static Map w(jg.h hVar) {
        kotlin.jvm.internal.t.f(hVar, "<this>");
        return o(x(hVar, new LinkedHashMap()));
    }

    public static final Map x(jg.h hVar, Map destination) {
        kotlin.jvm.internal.t.f(hVar, "<this>");
        kotlin.jvm.internal.t.f(destination, "destination");
        r(destination, hVar);
        return destination;
    }

    public static final Map y(cd.q[] qVarArr, Map destination) {
        kotlin.jvm.internal.t.f(qVarArr, "<this>");
        kotlin.jvm.internal.t.f(destination, "destination");
        s(destination, qVarArr);
        return destination;
    }

    public static Map z(Map map) {
        kotlin.jvm.internal.t.f(map, "<this>");
        return new LinkedHashMap(map);
    }
}
