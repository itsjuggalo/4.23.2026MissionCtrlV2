package dd;

import com.google.android.gms.common.api.a;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class n0 extends m0 {
    public static Map b(Map builder) {
        kotlin.jvm.internal.t.f(builder, "builder");
        return ((ed.d) builder).m();
    }

    public static Map c() {
        return new ed.d();
    }

    public static int d(int i10) {
        return i10 < 0 ? i10 : i10 < 3 ? i10 + 1 : i10 < 1073741824 ? (int) ((i10 / 0.75f) + 1.0f) : a.e.API_PRIORITY_OTHER;
    }

    public static Map e(cd.q pair) {
        kotlin.jvm.internal.t.f(pair, "pair");
        Map mapSingletonMap = Collections.singletonMap(pair.c(), pair.d());
        kotlin.jvm.internal.t.e(mapSingletonMap, "singletonMap(...)");
        return mapSingletonMap;
    }

    public static final Map f(Map map) {
        kotlin.jvm.internal.t.f(map, "<this>");
        Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
        Map mapSingletonMap = Collections.singletonMap(entry.getKey(), entry.getValue());
        kotlin.jvm.internal.t.e(mapSingletonMap, "with(...)");
        return mapSingletonMap;
    }

    public static SortedMap g(Map map, Comparator comparator) {
        kotlin.jvm.internal.t.f(map, "<this>");
        kotlin.jvm.internal.t.f(comparator, "comparator");
        TreeMap treeMap = new TreeMap(comparator);
        treeMap.putAll(map);
        return treeMap;
    }
}
