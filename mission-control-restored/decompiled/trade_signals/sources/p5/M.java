package p5;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2489q;

/* JADX INFO: loaded from: classes2.dex */
public abstract class M extends L {
    public static Map h() {
        C2574C c2574c = C2574C.f22363a;
        AbstractC2304t.d(c2574c, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return c2574c;
    }

    public static Object i(Map map, Object obj) {
        AbstractC2304t.f(map, "<this>");
        return K.a(map, obj);
    }

    public static HashMap j(C2489q... pairs) {
        AbstractC2304t.f(pairs, "pairs");
        HashMap map = new HashMap(L.d(pairs.length));
        r(map, pairs);
        return map;
    }

    public static Map k(C2489q... pairs) {
        AbstractC2304t.f(pairs, "pairs");
        return pairs.length > 0 ? x(pairs, new LinkedHashMap(L.d(pairs.length))) : h();
    }

    public static Map l(Map map, Iterable keys) {
        AbstractC2304t.f(map, "<this>");
        AbstractC2304t.f(keys, "keys");
        Map mapY = y(map);
        v.B(mapY.keySet(), keys);
        return n(mapY);
    }

    public static Map m(C2489q... pairs) {
        AbstractC2304t.f(pairs, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(L.d(pairs.length));
        r(linkedHashMap, pairs);
        return linkedHashMap;
    }

    public static final Map n(Map map) {
        AbstractC2304t.f(map, "<this>");
        int size = map.size();
        return size != 0 ? size != 1 ? map : L.f(map) : h();
    }

    public static Map o(Map map, Map map2) {
        AbstractC2304t.f(map, "<this>");
        AbstractC2304t.f(map2, "map");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.putAll(map2);
        return linkedHashMap;
    }

    public static final void p(Map map, U6.h pairs) {
        AbstractC2304t.f(map, "<this>");
        AbstractC2304t.f(pairs, "pairs");
        Iterator it = pairs.iterator();
        while (it.hasNext()) {
            C2489q c2489q = (C2489q) it.next();
            map.put(c2489q.a(), c2489q.b());
        }
    }

    public static void q(Map map, Iterable pairs) {
        AbstractC2304t.f(map, "<this>");
        AbstractC2304t.f(pairs, "pairs");
        Iterator it = pairs.iterator();
        while (it.hasNext()) {
            C2489q c2489q = (C2489q) it.next();
            map.put(c2489q.a(), c2489q.b());
        }
    }

    public static final void r(Map map, C2489q[] pairs) {
        AbstractC2304t.f(map, "<this>");
        AbstractC2304t.f(pairs, "pairs");
        for (C2489q c2489q : pairs) {
            map.put(c2489q.a(), c2489q.b());
        }
    }

    public static Map s(U6.h hVar) {
        AbstractC2304t.f(hVar, "<this>");
        return n(t(hVar, new LinkedHashMap()));
    }

    public static final Map t(U6.h hVar, Map destination) {
        AbstractC2304t.f(hVar, "<this>");
        AbstractC2304t.f(destination, "destination");
        p(destination, hVar);
        return destination;
    }

    public static Map u(Iterable iterable) {
        AbstractC2304t.f(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return n(v(iterable, new LinkedHashMap()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return h();
        }
        if (size != 1) {
            return v(iterable, new LinkedHashMap(L.d(collection.size())));
        }
        return L.e((C2489q) (iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next()));
    }

    public static final Map v(Iterable iterable, Map destination) {
        AbstractC2304t.f(iterable, "<this>");
        AbstractC2304t.f(destination, "destination");
        q(destination, iterable);
        return destination;
    }

    public static Map w(Map map) {
        AbstractC2304t.f(map, "<this>");
        int size = map.size();
        return size != 0 ? size != 1 ? y(map) : L.f(map) : h();
    }

    public static final Map x(C2489q[] c2489qArr, Map destination) {
        AbstractC2304t.f(c2489qArr, "<this>");
        AbstractC2304t.f(destination, "destination");
        r(destination, c2489qArr);
        return destination;
    }

    public static Map y(Map map) {
        AbstractC2304t.f(map, "<this>");
        return new LinkedHashMap(map);
    }
}
