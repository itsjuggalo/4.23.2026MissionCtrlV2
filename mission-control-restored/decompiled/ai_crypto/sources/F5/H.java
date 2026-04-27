package F5;

import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class H {
    public static final Object a(Map map, Object obj) {
        kotlin.jvm.internal.r.f(map, "<this>");
        if (map instanceof G) {
            return ((G) map).b(obj);
        }
        Object obj2 = map.get(obj);
        if (obj2 != null || map.containsKey(obj)) {
            return obj2;
        }
        throw new NoSuchElementException("Key " + obj + " is missing in the map.");
    }
}
