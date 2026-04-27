package p5;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2489q;
import q5.C2637d;

/* JADX INFO: loaded from: classes2.dex */
public abstract class L extends K {
    public static Map b(Map builder) {
        AbstractC2304t.f(builder, "builder");
        return ((C2637d) builder).l();
    }

    public static Map c() {
        return new C2637d();
    }

    public static int d(int i8) {
        if (i8 < 0) {
            return i8;
        }
        if (i8 < 3) {
            return i8 + 1;
        }
        if (i8 < 1073741824) {
            return (int) ((i8 / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static Map e(C2489q pair) {
        AbstractC2304t.f(pair, "pair");
        Map mapSingletonMap = Collections.singletonMap(pair.c(), pair.d());
        AbstractC2304t.e(mapSingletonMap, "singletonMap(...)");
        return mapSingletonMap;
    }

    public static final Map f(Map map) {
        AbstractC2304t.f(map, "<this>");
        Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
        Map mapSingletonMap = Collections.singletonMap(entry.getKey(), entry.getValue());
        AbstractC2304t.e(mapSingletonMap, "with(...)");
        return mapSingletonMap;
    }

    public static SortedMap g(Map map, Comparator comparator) {
        AbstractC2304t.f(map, "<this>");
        AbstractC2304t.f(comparator, "comparator");
        TreeMap treeMap = new TreeMap(comparator);
        treeMap.putAll(map);
        return treeMap;
    }
}
