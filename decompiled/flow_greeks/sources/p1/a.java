package p1;

import dd.a0;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static final Set a(Set set) {
        t.f(set, "set");
        Set setUnmodifiableSet = Collections.unmodifiableSet(a0.N0(set));
        t.e(setUnmodifiableSet, "unmodifiableSet(set.toSet())");
        return setUnmodifiableSet;
    }

    public static final Map b(Map map) {
        t.f(map, "map");
        Map mapUnmodifiableMap = Collections.unmodifiableMap(map);
        t.e(mapUnmodifiableMap, "unmodifiableMap(map)");
        return mapUnmodifiableMap;
    }
}
