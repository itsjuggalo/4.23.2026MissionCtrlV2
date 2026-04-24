package F5;

import com.google.android.gms.common.api.a;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class I extends H {
    public static int b(int i7) {
        return i7 < 0 ? i7 : i7 < 3 ? i7 + 1 : i7 < 1073741824 ? (int) ((i7 / 0.75f) + 1.0f) : a.e.API_PRIORITY_OTHER;
    }

    public static Map c(E5.o pair) {
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
