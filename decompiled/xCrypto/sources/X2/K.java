package X2;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class K extends J {
    public static int b(int i4) {
        if (i4 < 0) {
            return i4;
        }
        if (i4 < 3) {
            return i4 + 1;
        }
        if (i4 < 1073741824) {
            return (int) ((i4 / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static Map c(W2.o pair) {
        kotlin.jvm.internal.r.f(pair, "pair");
        Map mapSingletonMap = Collections.singletonMap(pair.c(), pair.d());
        kotlin.jvm.internal.r.e(mapSingletonMap, "singletonMap(...)");
        return mapSingletonMap;
    }

    public static final Map d(Map map) {
        kotlin.jvm.internal.r.f(map, "<this>");
        Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
        Map mapSingletonMap = Collections.singletonMap(entry.getKey(), entry.getValue());
        kotlin.jvm.internal.r.e(mapSingletonMap, "with(...)");
        return mapSingletonMap;
    }
}
