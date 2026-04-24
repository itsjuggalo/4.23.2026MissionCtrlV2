package X2;

import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class J {
    public static final Object a(Map map, Object obj) {
        kotlin.jvm.internal.r.f(map, "<this>");
        if (map instanceof I) {
            return ((I) map).c(obj);
        }
        Object obj2 = map.get(obj);
        if (obj2 != null || map.containsKey(obj)) {
            return obj2;
        }
        throw new NoSuchElementException("Key " + obj + " is missing in the map.");
    }
}
