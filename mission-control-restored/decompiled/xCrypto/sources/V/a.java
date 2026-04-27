package V;

import X2.x;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static final Set a(Set set) {
        r.f(set, "set");
        Set setUnmodifiableSet = Collections.unmodifiableSet(x.l0(set));
        r.e(setUnmodifiableSet, "unmodifiableSet(set.toSet())");
        return setUnmodifiableSet;
    }

    public static final Map b(Map map) {
        r.f(map, "map");
        Map mapUnmodifiableMap = Collections.unmodifiableMap(map);
        r.e(mapUnmodifiableMap, "unmodifiableMap(map)");
        return mapUnmodifiableMap;
    }
}
